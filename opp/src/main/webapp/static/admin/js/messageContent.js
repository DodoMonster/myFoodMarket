$(function(){
	var $toggleShowBtn=$('#toggleShow'); //显示更多按钮
	var $objectListUl=$('.objectListUl'); //对象列表
	var length=$objectListUl.children().length;

	if(length>9){
		$(".objectListUl li").each(function() {
			if($(this).index()>8){
				$(this).addClass("hide");
			}
		});
	}
	$toggleShowBtn.toggle(function(){
		$("#toggleShow i").removeClass("fa fa-angle-down");
		$("#toggleShow i").addClass("fa fa-angle-up");
		$(".objectListUl li").each(function() {
			if($(this).index()>8){
				$(this).removeClass("hide");
			}
		});

	},function(){
		$("#toggleShow i").removeClass("fa fa-angle-up");
		$("#toggleShow i").addClass("fa fa-angle-down");
		$(".objectListUl li").each(function() {
			if($(this).index()>8){
				$(this).addClass("hide");
			}
		});
	})
});
