/**
 * @author DodoMonster
 * 2016-04-19
 */

$(function() {
	var $plusBtn = $("#tagsDiv .fa-plus"); //添加商品标签按钮
	var $tagDiv = $("#tagsDiv ul");//商品标签容器
	var $newTagDiv = '<li><input type="text" name="name" class="new"><i class="fa fa-close"></i></li>';//商品标签所处的li容器
	var $delBtn=$('#tagsDiv .fa-close');//获取商品标签右上角的删除按钮
	var $goodsImg=$('.img-gallery li');//商品图的li容器
	var $delImgBtn=$('.img-gallery .close-btn');//删除商品图片按钮

	var $overlay=$('#overlay');//遮罩
	var $batchDiv=$('#chooseImg');//批量上传图片框
	var $batchBtn=$('.uploadImgs');//批量上传图片按钮
	var $closeBatchBtn=$('.close-btn');//关闭批量上传框按钮
	var $allCancelBtn=$('.diyCancelAll');//全部取消按钮

	/*
	* 点击商品标签添加按钮处理事件
	*
	* step1 : 弹出提示框，使用户在提示框处输入商品的新增标签
	*
	* step2 ：如果用户点击了取消则直接关闭提示框
	*
	* step3 ：如果用户点击了确定，先判断用户输入是否为空
	*
	* step4 : 为空则弹框提示不能为空
	*
	* step5 : 不为空则获取用户输入的新增的商品名，并把其插入到html文档中
	*/
	$plusBtn.click(function() {
		layer.open({
			title: '新增商品标签',
			skin: 'layui-layer-molv',
			content: '<input class="input-new-tag" />',
			btn: ['确定', '取消'],
			yes: function(index) {
				var $newTag = $('.input-new-tag').val();
				if($newTag){//当新增标签输入不为空
					$tagDiv.append($newTagDiv);//新建小标签容器li
					$tagDiv.find('li:last-child').children('input').attr('value',$newTag);//把输入的商品新标签插入到新建的小标签容器li
					layer.close(index);//关闭弹框
				}else{//当新增标签输入为空时弹框提示
					layer.msg('新增标签输入不能为空！',{
						time:2000,
						area:['200px','100px']
					});
				}
			}
		});
	});

	/*

	* 点击商品标签右上角的删除按钮处理函数
	*
	* step1 : 弹出提示框，使用户再次确定是否删除该商品标签
	*
	* step2 ：获取被点击的需要被删的商品标签li
	*
	* step3 ：如果用户点击了确定，移除该商品标签li并关闭弹框
	*
	* step4 : 取消则关闭弹框
	*
	*/

	$tagDiv.on('click','.fa-close',function(){
		var $deletedLi=$(this).parent('li');//获取被点击的需要被删的商品标签li
		layer.confirm('是否确认删除此商品标签？',{
			skin:'layui-layer-molv',

			title:'删除提示',
			shade:0.6,//遮罩透明度
			moveType:1,//拖拽风格,0是默认,1是传统拖动
			shift:1,//0-6是动画形式，-1不开启
		},function(index){
			$deletedLi.remove();//移除需要被删的li
			layer.close(index);//关闭弹框
		});
	});

	/*
	* 鼠标悬浮和离开商品图片处理函数
	*
	* step1 : 鼠标悬浮显示遮罩和删除按钮
	*
	* step2 ：鼠标离开隐藏遮罩和删除按钮
	*
	*/
	$goodsImg.mouseover(function(){
		$(this).find('.close-btn').addClass('show-close');
		$(this).find('.fa').show();
	}).mouseleave(function() {
		$(this).find('.close-btn').removeClass('show-close');
		$(this).find('.fa').hide();
	});

	/*
	* 点击商品图片上面的删除按钮删除图片
	*
	* step1 : 鼠标悬浮显示遮罩和删除按钮
	*
	* step2 ：鼠标离开隐藏遮罩和删除按钮
	*
	*/
	$delImgBtn.click(function(){
		var $delImg=$(this).parents('li');
		layer.open({
			title:'商品图片移除提示',
			skin:'layui-layer-molv',
			content:'<p>确定删除此商品图片？</p>',
			btn:['确定','取消'],
			yes:function(index){
				$delImg.remove();//移除点击的不需要的图片
				layer.close(index);
			}
		});
	});

	// $('.img-gallery').perfectScrollbar(); //商品图片容器滚动条
	//  $('.fileBoxUl').perfectScrollbar(); //批量上传图片容器滚动条


	/*
	* 美化input[type=file]按钮后显示文件名
	*
	* step1 : 鼠标悬浮显示遮罩和删除按钮
	*
	* step2 ：鼠标离开隐藏遮罩和删除按钮
	*
	*/
	$('a.uploadImg').on('change','input[type=file]',function(){
		var filePath=$(this).val();//获取上传的文件名
		var $showFileName=$(this).parent('a').siblings('.showFileName');//文件名显示处
        var $fileErrorTip=$(this).parent('a').siblings('.fileErrorTip');//错误提示显示处
		if(filePath.indexOf('jpg')!=-1||filePath.indexOf('png')!=-1){//文件类型为图片
			$fileErrorTip.html('').hide();//不弹出错误提示框
			var arr=filePath.split('\\');//分离文件名字
			var fileName=arr[arr.length-1];//获取文件的纯文件名
			$showFileName.html(fileName);//把文件名插入到显示文件名的框框中
		}else {//没有选择上传文件或者上传的不是图片
			$showFileName.html('');//文件名置空
			$fileErrorTip.html('您未上传文件，或者您上传文件类型(只能上传图片)有误！').show();//错误提示显示
			return false;
		}
	});

	/*点击上传本地图片按钮处理事件*/
	$batchBtn.click(showBatchDiv);

	$closeBatchBtn.click(hideBatchDiv);

	/*批量上传ajax交互*/
	$('#batchImg').diyUpload({
		url:'server/fileupload.php',
		success:function( data ) {
		console.info( data );
	},
		error:function( err ) {
			console.info( err );
		},
		buttonText : '选择文件',
		chunked:true,
		// 分片大小
		chunkSize:512 * 1024,
		//最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
		fileNumLimit:50,
		fileSizeLimit:500000 * 1024,
		fileSingleSizeLimit:50000 * 1024,
		accept: {}
	});
	/*
	 * 显示批量上传图片框函数
	 *
	 * stpe1 : 批量上传图片框显示
	 *
	 * step2 : 遮罩显示
	 *
	 * step3 : disable滚动条
	 *
	 */
	function showBatchDiv(){
		$batchDiv.animate({"top": "50%","opacity":"1"}, 200);
		$overlay.show();//遮罩显示
		$("body").css('overflow','hidden');//禁止滚动条
	}

	/*
	 * 隐藏批量上传图片框函数
	 *
	 * stpe1 : 批量上传图片框隐藏
	 *
	 * step2 : 遮罩隐藏
	 *
	 * step3 : enable滚动条
	 *
	 */
	function hideBatchDiv(){
		$batchDiv.animate({"top": "-100%","opacity":"0"}, 200);
		$overlay.hide();//遮罩显示
		$("body").css('overflow','auto');//禁止滚动条
	}

});

/*上传图片预览*/
function previewImage(file){
   var MAXWIDTH  = 300;
   var MAXHEIGHT = 200;
   var div = document.getElementById('preview');
   if (file.files && file.files[0]){
	   div.innerHTML = '<img id="showImg">';
	   var img = document.getElementById('showImg');
	   img.onload = function(){
		   var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
		   img.width = rect.width;
		   img.height = rect.height;
		   img.style.marginLeft = rect.left+'px';
		   img.style.marginTop = rect.top+'px';
	   }
	   var reader = new FileReader();
	   reader.onload = function(evt){img.src = evt.target.result;}
	   reader.readAsDataURL(file.files[0]);
   }else{
	   var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
	   file.select();
	   var src = document.selection.createRange().text;
	   div.innerHTML = '<img id="showImg">';
	   var img = document.getElementById('showImg');
	   img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
	   var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
	   status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
	   div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;margin-left:"+rect.left+"px;"+sFilter+src+"\"'></div>";
   }

}

function clacImgZoomParam( maxWidth, maxHeight, width, height ){
   var param = {top:0, left:0, width:width, height:height};
   if( width>maxWidth || height>maxHeight ){
	   rateWidth = width / maxWidth;
	   rateHeight = height / maxHeight;
	   if( rateWidth > rateHeight ){
		   param.width =  maxWidth;
		   param.height = Math.round(height / rateWidth);
	   }else{
		   param.width = Math.round(width / rateHeight);
		   param.height = maxHeight;
	   }
   }
   param.left = Math.round((maxWidth - param.width) / 2);
   param.top = Math.round((maxHeight - param.height) / 2);
   return param;
}
