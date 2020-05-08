/**
 * TODO
 */

 function light(sw){
     var pic;
     if(sw==0){
         pic="http://www.w3schools.com/html/pic_bulboff.gif";

     }else{
        pic="http://www.w3schools.com/html/pic_bulbon.gif";
     }

     document.getElementById('myImage').src=pic; /*tag는 img고 src 값 바꿔주는것.*/
       
 }