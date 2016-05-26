$(function() {
	var $linkBtn = $('.chooseObject'); //选择对象按钮
	var $linkDiv = $('#linkDiv'); //选择对象框
	var $cancelLinkBtn = $('#cancel'); //取消选择对象框
	var $confirmLinkBtn = $('#confirm'); //确认选择对象框
	var $userBtn = $('.user-nav'); //用户导航按钮
	var $shopBtn = $('.shop-nav'); //店铺导航按钮
	var $allBtn = $('.all-nav'); //全选导航按钮
	var $removeallBtn = $('.remove-all-nav'); //取消全选导航按钮
	var $allUserBtn = $('.all-user-nav'); //全选用户按钮
	var $allShopBtn = $('.all-shop-nav'); //全选店铺按钮
	var $userNav = $('#userNav'); //用户导航
	var $shopNav = $('#shopNav'); //店铺导航

	var $objectList = $('.objectList'); //选中对象列表
	var $toggleShowBtn=$('#toggleShow'); //显示更多按钮
	var $groupClass=$('.groupClass'); //分组列表
	var length=$groupClass.children().length;

	if(length>6){
		$(".groupClass li").each(function() {
			if($(this).index()>5){
				$(this).addClass("hide");
			}
		});
	}
	$toggleShowBtn.toggle(function(){
		$("#toggleShow i").removeClass("fa fa-angle-down");
		$("#toggleShow i").addClass("fa fa-angle-up");
		$(".groupClass li").each(function() {
			if($(this).index()>5){
				$(this).removeClass("hide");
			}
		});

	},function(){
		$("#toggleShow i").removeClass("fa fa-angle-up");
		$("#toggleShow i").addClass("fa fa-angle-down");
		$(".groupClass li").each(function() {
			if($(this).index()>5){
				$(this).addClass("hide");
			}
		});
	})

	var selected = new Array();

	// 点击选择对象按钮，选择对象框出现
	$linkBtn.click(function() {
		$linkDiv.removeClass("display");
		$objectList.children("ul").replaceWith("");
		selected.length=0;
		$linkDiv.animate({
			"top": "50%",
			"opacity": "1"
		}, 200);
	});

	// 点击“用户”按钮，显示用户导航和用户选项
	$userBtn.click(function() {
		$userNav.show();
		$shopNav.hide();
	});

	// 点击“店铺”按钮，显示店铺导航
	$shopBtn.click(function() {
		$userNav.hide();
		$shopNav.show();
	});

	// 点击“全选”按钮，所有选项li都被选中
	$allBtn.click(function() {
		$("[type='checkbox']").removeAttr("checked"); //把之前选中的对象都取消选中
		$("[type='checkbox']").attr("checked", 'true');
	})

	// 点击“取消全选”按钮，所有店铺对象都不被选中
	$removeallBtn.click(function() {
		$("[type='checkbox']").removeAttr("checked");
	})

	// 点击“全选用户”按钮，所有用户对象都被选中
	$allUserBtn.click(function() {
		$("[type='checkbox']").removeAttr("checked"); //把之前选中的店铺都取消选中
		$("[name='user']").attr("checked", 'true');
	})

	// 点击“全选店铺”按钮，所有店铺对象都被选中
	$allShopBtn.click(function() {
		$("[type='checkbox']").removeAttr("checked"); //把之前选中的用户都取消选中
		$("[name='shop']").attr("checked", 'true');
	})

	// 点击“取消”按钮，所有店铺对象都取消选中
	$cancelLinkBtn.click(function() {
		$("[type='checkbox']").removeAttr("checked");
		$linkDiv.animate({
			"top": "50%",
			"opacity": "1"
		}, 200);
		$linkDiv.addClass("display");
	})

	// 点击“确认”按钮，所有被选中对象被列出
	$confirmLinkBtn.click(function() {
		var j=0;
		$("#objectContainer li input[type=checkbox]").each(function() {
			if (this.checked) {
				selected[j] = $(this).val();
				j++;
			}
		});
		if (selected.length == 0) {
		} else {
			var str = "<ul class='appendContent'>";
			for (i = 0; i < selected.length; i++) {
				str += "<li>" + selected[i] + "</li>"
			}
			str += "</ul>";
			$objectList.append(str);
			
		}
		$linkDiv.animate({
			"top": "50%",
			"opacity": "0"
		}, 200);

		$linkDiv.addClass("display");		
	})


	$(function() {
			$("#datepicker").datetimepicker({
				minDate:0
			});
		});

})