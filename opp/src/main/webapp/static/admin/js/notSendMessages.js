$(function() {
	var $selectNav = $('.select-nav'); //导航全选按钮
	var $removeAllNav = $('.remove-all-nav'); //导航取消全选按钮
	var $cancelNav = $('.cancel-nav'); //导航删除按钮
	var $cancelBtn = $('.cancel'); //信息删除按钮
	var $showAllNav = $('.show-all-nav'); //导航默认显示按钮
	var $notSetTimeNav = $('.not-set-time-nav'); //导航未定时按钮
	var $setTimeNav = $('.set-time-nav'); //导航定时按钮

	var $messageList = $('.messageList'); //信息列表

	$('.messageList').find("li").each(function() {
		if ($(this).find(".contentFooter").children().length == 3) {
			$(this).find(".contentFooter").find(".action").html("发送");
			$(this).find(".contentFooter").find("a").html("取消");
		}else if($(this).find(".contentFooter").children().length == 2) {
			$(this).find(".contentFooter").find(".action").html("保存");
			$(this).find(".contentFooter").find("a").html("发送");
		}
	})


	//点击“默认显示”按钮，显示所有信息
	$showAllNav.click(function() {
		$('.messageList').find("li").removeClass();
	})

	//点击“未定时”按钮，显示未定时信息
	$notSetTimeNav.click(function() {
		$('.messageList').find("li").each(function() {
			$(this).removeClass();
			if ($(this).find(".contentFooter").children().length == 3) {
				$(this).addClass("hide");
			}
		})
	})

	//点击“定时”按钮，显示定时信息
	$setTimeNav.click(function() {
		$('.messageList').find("li").each(function() {
			$(this).removeClass();
			if ($(this).find(".contentFooter").children().length == 2) {
				$(this).addClass("hide");
			}
		})
	})

	//点击“全选”按钮时，所有信息都被选中
	$selectNav.click(function() {
		$("[type='checkbox']").removeAttr("checked"); //把之前单个选中的取消
		$("[type='checkbox']").attr("checked", 'true');
	})

	//点击“取消全选”按钮时，所有信息都取消选中
	$removeAllNav.click(function() {
		$("[type='checkbox']").removeAttr("checked");
	})

	//点击导航“删除”按钮时，选中的信息都被删除
	$cancelNav.click(function() {
		$("input[type='checkbox']").each(function() {
			if ($(this).attr("checked")) {
				$(this).parent().parent().remove();
			}
		})
	})

	//点击每个信息的“删除”按钮时，相应的信息被删除
	$cancelBtn.click(function() {
		$(this).parent().parent().remove();
	})
});