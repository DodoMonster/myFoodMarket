$(function(){
	var $selectNav=$('.select-nav');//导航全选按钮
	var $removeAllNav=$('.remove-all-nav');//导航取消全选按钮
	var $cancelNav=$('.cancel-nav');//导航删除按钮
	var $cancelBtn=$('.cancel');//信息删除按钮

	//点击“全选”按钮时，所有信息都被选中
	$selectNav.click(function(){
		$("[type='checkbox']").removeAttr("checked");//把之前单个选中的取消
		$("[type='checkbox']").attr("checked",'true');
	})

	//点击“取消全选”按钮时，所有信息都取消选中
	$removeAllNav.click(function(){
		$("[type='checkbox']").removeAttr("checked");
	})

	//点击导航“删除”按钮时，选中的信息都被删除
	$cancelNav.click(function(){
		$("input[type='checkbox']").each(function(){
			if($(this).attr("checked")){
				$(this).parent().parent().remove();
			}	
		})
	})

	//点击每个信息的“删除”按钮时，相应的信息被删除
	$cancelBtn.click(function(){
		$(this).parent().parent().remove();
	})
});