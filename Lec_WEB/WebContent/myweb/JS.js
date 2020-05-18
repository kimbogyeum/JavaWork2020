
$(function(){ 

// 상단메뉴바
  $(".menu1 ul li").hover(function(){
    $(this).find("ul").stop().fadeToggle(300);
    });



// 슬라이드쇼
    var check = 1;
    setInterval(function() {
      if(check == 3) check = 0;
      check++;
      slideImg();   	  	
    }, 4000);


    function slideImg(){
		$("#main").stop(true).css('background-image','url(img/main'+check+'.jpg');
		$('#slide_img img.pic1').stop(true).css({'opacity': 0.3}).animate({'opacity': 1}, 1500);

    	$('#slide_img img.pic1').attr('src', 'img/slide_'+check+'.jpg');
		$('#slide_img img.pic1').stop(true).css({'opacity': 0.3}).animate({'opacity': 1}, 1500);
		
		$('#slide_img img.pic2').attr('src', 'img/slides_'+check+'.jpg');
    	$('#slide_img img.pic2').stop(true).css({'opacity': 0.3}).animate({'opacity': 1}, 1500);
    }
	


	
	// form 팝업창
		var Btn = document.getElementById("Btn");
		var modal = document.getElementById("id01");
		var close = document.getElementsByClassName("close")[0];
		
		Btn.onclick = function(){
			modal.style.display = "block";
		}
		
		close.onclick = function(){
			modal.style.display = "none";
		}
		
		window.onclick = function(event){
			if(event.target == modal){
				modal.style.display = "none";
			}
		}
		
	// //팝업창 체크표시여부
	$(".cc1").hide();
	$(".cc2").hide();
	$(".cc3").hide();
	$(".cc4").hide();
	$(".cc5").hide();
	$(".cc6").hide();
	$(".cc7").hide();
	$(".cc8").hide();

	$("._1").click(function(){$(".cc1").show();});
	$("._2").click(function(){$(".cc2").show();});	
	$("._3").click(function(){$(".cc3").show();});	
	$("._4").click(function(){$(".cc4").show();});	
	$("._5").click(function(){$(".cc5").show();});	
	$("._6").click(function(){$(".cc6").show();});	
	$("._7").click(function(){$(".cc7").show();});	
	$("._8").click(function(){$(".cc8").show();});
});


