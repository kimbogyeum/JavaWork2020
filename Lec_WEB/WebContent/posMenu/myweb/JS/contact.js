const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');
const signInContainer = document.getElementsByClassName('sign-in-container')[0];
const inputName = document.getElementById("inputName");
const inputInId = document.getElementById("inputInId");
const inputInPassword = document.getElementById('inputInPassword');
const inputUpId = document.getElementById('inputUpId');
const inputUpPassword = document.getElementById('inputUpPassword');
const signInBtn = document.getElementById('signInBtn');
const signUpBtn = document.getElementById('signUpBtn');


signUpButton.addEventListener('click', function() {
    container.classList.add("right-panel-active");
    signInContainer.style.display = "none";
    
});

signInButton.addEventListener('click', function() {
    container.classList.remove("right-panel-active");
    signInContainer.style.display = "block";
});


signInBtn.addEventListener("click", function(){
    if(inputInId.value == ""){
        window.alert('아이디를 입력하세요.');
        return;
    }
        if(inputInPassword.value == ""){
        window.alert('비밀번호를 입력하세요.');
        return;
        }
    
    alert('Login Successful!')
        location.href="index.html";

});

signUpBtn.addEventListener("click", function () {

    if (inputName.value == '') {
        window.alert('이름을 입력하세요');
        return;
    }

    if (inputUpId.value == "") {
        window.alert('아이디를 입력하세요.');
        return;
    }

    if (inputUpPassword.value == "") {
        window.alert('비밀번호를 입력하세요.');
        return;
    }

    window.alert('SignUp Successful!');
    location.href = "index.html";



    // if(inputName.value != ""){
    //     if(inputUpEmail.value != ""){
    //         if(inputUpPassword.value != ""){
    //            
    //             location.href="index.html";
    //         }
    //      }
    //  }
     
  });