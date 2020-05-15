
$(function(){ 

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
    	$('#slide_img img').attr('src', 'img/slide_'+check+'.jpg');
    	$('#slide_img img').stop(true).css({'opacity': 0.3}).animate({'opacity': 1}, 1500);
    }
	



// email 패턴에 대한 정규표현식
var emailPat = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
var passwordPat=/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;



function chkSubmit6(){
	var frm=document.classform;
  var email=frm.email.value.trim();
  var password=frm.password.value.trim();


	document.getElementById("passwarn").innerHTML="";
	document.getElementById("emailwarn").innerHTML="";

	//정규표현식 객체의 test() : 패턴매칭 여부. 
	if(!passwordPat.test(password)){
		document.getElementById("passwarn").innerHTML="유효하지 않은 비밀번호";
		frm.url.focus();
		return false;
	}

	if(!emailPat.test(email)){
		document.getElementById("emailwarn").innerHTML="잘못된 email";
		frm.email.focus();
		return false;
	}
  return true;
}

});