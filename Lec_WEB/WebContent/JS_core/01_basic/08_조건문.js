//if~ else
//if~ else if ~else;
//Java, C와 언어구조 동일

a=100

if(a+1>100){ //여기의 a는 5번줄의 a
    let a=10;
    console.log('if 안의 a 같은',a) //여기의 a 는 if문 안의 a
}

//let이 아닌 var라면 Hoisting 이 되겠지? 
if(a+1>100){ 
    console.log('if 안의 a 같은',a)
    var a=10;
    console.log('if 안의 a 같은',a) 
}



// 조건에서 참거짓 판정시!
// Falsy 로 평가될때!
// false, 0, '', null, undefined, NaN   <-- 'Falsy 한 값'이라 한다

// Truthy 로 평가될때
// true, 37, 'Mark', {} - 파이썬에서는 false, [] - 파이썬에서는 false   <-- 'Truthy 한 값' 이라 한다


function print(data){
    if(data){ //참(Truthy) 거짓(Falsy) 판정
        console.log(data,typeof data, '--Truethy')
    }else{
        console.log(data,typeof data, '--Falsy')
    }
}
print(true)
print(false)
print(100)
print(0)
print(-1)
print('Hello')
print("") //F
print([10,20,30])
print([]) //T,★파이썬과는 다르다!!!
print({'name':'John','age':43}) //T, object는 key value쌍이다. 
print({}) //T,★파이썬과는 다르다!!!
print(null)
print(undefined)
print(NaN)
print(100/0)


print() //호출시 전달인지 없으면 undefined 값으로 동작함

console.log()
console.log(!undefined)
console.log(!null)
console.log(!0)
console.log(!"")
console.log(!NaN)

//Truthy 값에 !결과 => false (boolean)
console.log(!3)
console.log(!"Hello")
console.log(!" ")
console.log(![10,20,30])
console.log(![])
console.log(!{})

// Truthy, Falsy 판정결과 --> boolean
//1. 삼항연산자 사용
let value={'a':100}
let isTrue=value ? true:false;
console.log('isTrue=',isTrue,typeof isTrue)

//2. !! 사용하면 가능.
isTrue=!!value; 
console.log('isTrue=',isTrue,typeof isTrue)

console.log()


//함수정의할때 매개변수 체크 필요 --여기 강사님꺼 다시보자. 잘못쓴듯,
function printName(person){

    //매개변수 null check 
    //if(person===undefined||person===null) return;
    if(!person) return;
    console.log('이름은',person.name)
}


let myBrother={name:"John"}
printName(myBrother)
printName()
// printName() //에러, undefined 값이 person에 넘겨짐




