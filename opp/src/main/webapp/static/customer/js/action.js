$(document).ready(function(e){
	var unslider=$("#pic_wrap1").unslider({
		dots:true
	}),
	data=unslider.data("unslider");

	$(".unslider-arrow").click(function(){
		var fn=this.className.split(" ")[1];
		data[fn]();
	});
});

$(document).ready(function(e){
	var unslider=$("#pic_wrap2").unslider({
		dots:true
	}),
	data=unslider.data("unslider");

	$(".unslider-arrow").click(function(){
		var fn=this.className.split(" ")[1];
		data[fn]();
	});
});
$(document).ready(function(e){
	var unslider=$("#pic_wrap3").unslider({
		dots:true
	}),
	data=unslider.data("unslider");

	$(".unslider-arrow").click(function(){
		var fn=this.className.split(" ")[1];
		data[fn]();
	});
});
$(document).ready(function(e){
	var unslider=$("#pic_wrap4").unslider({
		dots:true
	}),
	data=unslider.data("unslider");

	$(".unslider-arrow").click(function(){
		var fn=this.className.split(" ")[1];
		data[fn]();
	});
});
$(document).ready(function(e){
	var unslider=$("#pic_wrap5").unslider({
		dots:true
	}),
	data=unslider.data("unslider");

	$(".unslider-arrow").click(function(){
		var fn=this.className.split(" ")[1];
		data[fn]();
	});
});
$(document).ready(function(e){
	var unslider=$("#pic_wrap6").unslider({
		dots:true
	}),
	data=unslider.data("unslider");

	$(".unslider-arrow").click(function(){
		var fn=this.className.split(" ")[1];
		data[fn]();
	});
});

$(document).ready(function(e){
	var unslider=$("#pic_wrap7").unslider({
		dots:true
	}),
	data=unslider.data("unslider");

	$(".unslider-arrow").click(function(){
		var fn=this.className.split(" ")[1];
		data[fn]();
	});
});

$(function(){
	var tab1=document.getElementById("title1");
	var li=tab1.getElementsByTagName("li");
	var shoplist=document.getElementById("contentTwo1");
	var ul=shoplist.getElementsByTagName("ul");
	for(var i=0;i<li.length;i++){
		li[i].index=i;
		li[i].onclick=function(){
			for(var n=0;n<li.length;n++){
				li[n].className="";
				ul[n].className="hide";
			}
			this.className="on";
			ul[this.index].className="";
		}
	}
})
$(function(){
	var tab2=document.getElementById("title2");
	var li=tab2.getElementsByTagName("li");
	var shoplist=document.getElementById("contentTwo2");
	var ul=shoplist.getElementsByTagName("ul");
	for(var i=0;i<li.length;i++){
		li[i].index=i;
		li[i].onclick=function(){
			for(var n=0;n<li.length;n++){
				li[n].className="";
				ul[n].className="hide";
			}
			this.className="on";
			ul[this.index].className="";
		}
	}
})
$(function(){
	var tab3=document.getElementById("title3");
	var li=tab3.getElementsByTagName("li");
	var shoplist=document.getElementById("contentTwo3");
	var ul=shoplist.getElementsByTagName("ul");
	for(var i=0;i<li.length;i++){
		li[i].index=i;
		li[i].onclick=function(){
			for(var n=0;n<li.length;n++){
				li[n].className="";
				ul[n].className="hide";
			}
			this.className="on";
			ul[this.index].className="";
		}
	}
})
$(function(){
	var tab4=document.getElementById("title4");
	var li=tab4.getElementsByTagName("li");
	var shoplist=document.getElementById("contentTwo4");
	var ul=shoplist.getElementsByTagName("ul");
	for(var i=0;i<li.length;i++){
		li[i].index=i;
		li[i].onclick=function(){
			for(var n=0;n<li.length;n++){
				li[n].className="";
				ul[n].className="hide";
			}
			this.className="on";
			ul[this.index].className="";
		}
	}
})
$(function(){
	var tab5=document.getElementById("title5");
	var li=tab5.getElementsByTagName("li");
	var shoplist=document.getElementById("contentTwo5");
	var ul=shoplist.getElementsByTagName("ul");
	for(var i=0;i<li.length;i++){
		li[i].index=i;
		li[i].onclick=function(){
			for(var n=0;n<li.length;n++){
				li[n].className="";
				ul[n].className="hide";
			}
			this.className="on";
			ul[this.index].className="";
		}
	}
})

$(function(){
	// debugger;
	var recommendlist=document.getElementById("recommend");
	var next=recommendlist.getElementsByTagName("span")[0];
	var ul=recommendlist.getElementsByTagName("ul");
	var time=0;
	next.onclick=function(){
		time++;
		for(var i=0;i<ul.length;i++){
			if(i==time){
				ul[i].className="clearfix";
			}else{
				ul[i].className="clearfix hide";
			}
		}	
		if(time==ul.length-1){
			time=-1;
		}
	}
})
$(function(){
	$("#shopClass_show dl").mouseover(function(){
		$(this).addClass("activeShopClass")
			   .siblings().removeClass("activeShopClass");
	}).mouseleave(function(){
		$(this).removeClass("activeShopClass");
	})
})