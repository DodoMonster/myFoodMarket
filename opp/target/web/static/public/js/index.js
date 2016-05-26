$(function() {
	showPage();
	showCircle();
});

function showCircle()
{

	$('.circle').each(function(index, el) {
	    var num = $(this).find('span').text() * 3.6;
	    if (num<=180) {
	        $(this).find('.right').css('transform', "rotate(" + num + "deg)");
	    } else {
	        $(this).find('.right').css('transform', "rotate(180deg)");
	        $(this).find('.left').css('transform', "rotate(" + (num - 180) + "deg)");
	    };
	});

}


function showPage(){
	$.ajax({
		type:"GET",
		url : $.GetUrl()+"IndexAction/showPage",
		dataType : "json",
		success:function(ret){
//			alert(ret);
			var carousel_inner = "";
			var carousel_indicators = "";
			for(var i=0;i<ret.bannerPic.length;i++){
				carousel_inner +='<div class="item '+(i==0?'active':'')+'">'+
					  '	  <img src="../images/'+ret.bannerPic[i].pic+'" alt="...">'+
					  '	  <div class="carousel-caption">'+
					  '		...'+
					  '	  </div>'+
					  '</div>';
				carousel_indicators += '<li data-target="#carousel-example-generic" data-slide-to="'+i+'" class="'+(i==0?'active':'')+'"></li>'
			}
			$(".carousel-inner").append(carousel_inner);
			$(".carousel-indicators").append(carousel_indicators);

//			$(".box-content-h1").append(ret.productTitle);
//			$(".box-content-h2").append(ret.productIntro);
//			$(".box-content-img").attr("src","../images/"+ret.productPic);

			str = "";
			for(var i=0;i<ret.members.length;i++){
				str += "<li>"+
							"<img src='../images/"+ret.members[i].pic+"' alt=''>"+
							"<h3>"+ret.members[i].name+"</h3>"+
							"<p>"+ret.members[i].job+"</p>"+
							"<p class='info-b'>"+ret.members[i].introduction+"</p>"+
						"</li>"
			}
			$(".members").append(str);

//			$(".contact-info-message").append(ret.contactMessage);
//			$(".contact-info-address").append("地址： "+ret.contactAddr);
//			$(".contact-info-phone").append("电话： "+ret.contactPhone);
//			$(".contact-info-email").append("邮件： "+ret.contactEmail);

		},
		error:function(){
			alert("connect fail!");
		}
	});
}

