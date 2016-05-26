/**
 * @author DodoMonster
 * 2016-04-23
 */

 $(function(){
    var $delBtn=$('.delete-btn');//删除按钮
    var $modifyBtn=$('.modify-btn');//修改按钮
    var $linkBtn=$('.assosiate-btn');//关联按钮

    var $overlay=$('#overlay');//遮罩

    var $modifyDiv=$('#modifyDiv');//修改图片框
    var $cancelModifyBtn=$('#cancel-modify-btn');//取消修改图片按钮
    var $uploadImg=$('.uploadImg');//上传图片按钮
    var $addNewImg=$('#newImg');//新增图片按钮
    var $showImg=$('#showImg');//图片预览处
    var $closeBox=$('.close-box');//关闭图片选择按钮

    var $linkDiv=$('#linkDiv');//修改图片关联框
    var $confirmLinkBtn=$('.confirm-shop');//确认修改关联店铺按钮
    var $cancelLinkBtn=$('.cancel-shop');//取消修改关联店铺按钮
    var $goodsBtn=$('.goods-nav');//商品导航按钮
    var $shopBtn=$('.shop-nav');//店铺导航按钮
    var $goodsNav=$('#goodsNav');//商品导航栏
    var $shopNav=$('#shopNav');//店铺导航栏
    var $navLi=$('.linkNav li');//修改图片关联框导航
    var $modalWrapper=$('#modelWrapper');//关联框外层

    /*
	* 美化input[type=file]按钮后显示文件名
	*
	* step1 : 鼠标悬浮显示遮罩和删除按钮
	*
	* step2 ：鼠标离开隐藏遮罩和删除按钮
	*
	*/
    $uploadImg.on('change','input[type=file]',function(){
        var filePath=$(this).val();//获取上传的文件名
        var $fileTip=$(this).parent('a').siblings('.fileTip');//文件名显示处以及错误提示显示处
        if(filePath.indexOf('jpg')!=-1||filePath.indexOf('png')!=-1){//文件类型为图片
            var arr=filePath.split('\\');//分离文件名字
            var fileName=arr[arr.length-1];//获取文件的纯文件名
            $fileTip.html(fileName);//显示文件名
        }
        else{
            $fileTip.html('您还未上传文件！');//提示错误信息
        }

    })

    /*
     * 点击删除按钮处理事件
     *
     * stpe1 : 获取需要删除的图片以及其id
     *
     * step2 : 弹框提示是否确定删除该图片
     *
     * step3 : 确定则发起ajax请求发送被删除图片的id，请求成功移除图片并关闭弹框
     *
     * step4 : 取消则关闭弹框
     */
    $delBtn.click(function(){
        var $delImg=$(this).parents('li');//获取被删除的图片
        var $delImgId=$delImg.attr('id');//获取被删除图片的id
        layer.confirm('确定是否删除此图片？',{
            skin:'layui-layer-molv',
            area:['300px','200px'],
            title:'图片删除提示',
            shade:0.6,
            moveType:1,
            shift:1
        },function(index){
            $.ajax({
                url:'',
                type:'GET',
                data:{imgId:$delImgId},//被删除图片的id
                dataType:'JSON',
                beforeSend:showLoadTips(),
                success:function(data){
                    $delImg.remove();//移除该图片
                    layer.close(index);//关闭弹框
                },
                error:errorFun()
            });
        });
    });

    /*
     * 点击修改按钮处理事件
     *
     * step1 : 获取被修改的图片的id
     *
     * step2 : 把被修改的图片的id设置到修改图片框的对应input的value中
     *
     * step3 : 调用显示图片选择框
     *
     */
    $modifyBtn.click(function(){
        var $modifyImgId=$(this).parents('li').find('img').attr('id');//获取被修改的图片的id
        $('.beModifyImg').val($modifyImgId);//把被修改的图片的id设置到修改图片框的对应input的value中
        showModifyDiv();
    });

    /*
     * 点击取消修改按钮,重置表单，图片预览区置空，清空文件名，隐藏选择图片选择框
     *
     */
     $cancelModifyBtn.click(function(){
          document.modifyImg.reset();//重置表单
          $('.fileTip').text("");//文件名提示置空
          $('#preview').html("");//图片预览区置空
          hideModifyDiv();//隐藏选择图片选择框
     });
     /*
      * 关闭x按钮处理事件，调用隐藏图片选择框
      */
     $closeBox.click(hideModifyDiv);

     /*
      * 点击新增图片按钮处理事件
      *
      * step1 : 获取已有图片张数
      *
      * step2 ：判断是否==6张，如果已经等于则弹框提示不能再进行添加
      *
      * step3 ：不满6张弹出选择图片框
      */
      $addNewImg.click(function(){
          var $liLength=$('#imgGallery li').length;//获取已有图片的张数
          if($liLength==6){
                layer.msg('图片已经满6张！请先删除再添加',{
                    area:['400px','100px']
                });
          }else{
              showModifyDiv();
          }
      });

    // $('#shopList ul').perfectScrollbar(); //店铺容器滚动条

    /*
     * 点击关联店铺显示商品关联修改框函数
     *
     * stpe1 : 图片修改框显示
     *
     * step2 : 遮罩显示
     *
     * step3 : disable滚动条
     *
     */
    $linkBtn.click(function(){
        $linkDiv.animate({"top": "50%","opacity":"1"}, 200);//关联店铺弹框显示
        $overlay.show();//遮罩显示
        $modalWrapper.show();//关联店铺弹框外层显示
        $("body").css('overflow','hidden');//禁止滚动条
    });

    /*
     * 点击'店铺'显示店铺导航函数
     *
     */
    $shopBtn.click(function(){
        $shopNav.show();
        $goodsNav.hide();
    });
    /*
     * 点击'商品'显示商品导航函数
     */
    $goodsBtn.click(function(){
        $shopNav.hide();
        $goodsNav.show()
    });

    $navLi.click(function(){
        $(this).addClass('active');
    });

    /*点击取消按钮关闭关联店铺弹框*/
    $cancelLinkBtn.click(function(){
        $linkDiv.animate({"top": "50%","opacity":"1"}, 200);//关联店铺弹框隐藏
        $overlay.hide();//遮罩隐藏
        $modalWrapper.hide();//关联店铺弹框外层隐藏
        $("body").css('overflow','auto');//body滚动条允许
    });

    /*
     * 显示图片修改框函数
     *
     * stpe1 : 图片修改框显示
     *
     * step2 : 遮罩显示
     *
     * step3 : disable滚动条
     *
     */
    function showModifyDiv(){
        $modifyDiv.animate({"top": "50%","opacity":"1"}, 200);
        $overlay.show();//遮罩显示
        $("body").css('overflow','hidden');//禁止滚动条
    }

    /*
     * 隐藏图片修改函数
     *
     * stpe1 : 图片修改框隐藏
     *
     * step2 : 遮罩隐藏
     *
     * step3 : enable滚动条
     *
     */
    function hideModifyDiv(){
        $modifyDiv.animate({"top": "-100%","opacity":"0"}, 200);
        $overlay.hide();//遮罩显示
        $("body").css('overflow','auto');//禁止滚动条
    }



    /*发起ajax请求提示加载信息*/
    function showLoadTips() {
        loadIndex = layer.load(0, {
            shade: false
        });
    }

    /*异步请求失败后显示提示失败提示框*/
    function errorFun() {
        layer.msg('数据连接失败！请反省！', {
            area: ['300px', '100px']
        });
    }
 });

 /*上传图片预览*/
function previewImage(file){
    var MAXWIDTH  = 200;
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
