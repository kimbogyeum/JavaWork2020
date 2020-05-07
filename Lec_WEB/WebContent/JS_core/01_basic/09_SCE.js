// 논리연산자
// && and 연산자
// || or 연산자
// ! not 연산자

console.log(true && true)
console.log(true && false)


// 논리연산자를 이용한 조건문 실행
// Short Circuit Evaluation

// 표현식1 && 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식1
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식2

// 표현식1 || 표현식2
//  표현식1 이 Falsy 이면 || 의 결과값은 표현식2
//  표현식1 이 Truthy 이면 || 의 결과값은 표현식1


let a=100
console.log(a>10 && a+10<10)
console.log(a<10 && a+10<10)

console.log("Hello" || "world") //논리연산자가 true,false 나오는게 아니라 왼쪽값이 나온다. 
console.log( 0 ||"world") //왼쪽이 false면 오른쪽 값이 나온다. 

console.log(5&&100) //무조건 오른쪽 

