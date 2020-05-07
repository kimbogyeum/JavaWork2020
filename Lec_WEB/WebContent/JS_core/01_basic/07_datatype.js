// 자료형 : data type

//  https://developer.mozilla.org/ko/docs/Web/JavaSCript/Data_structures

// 동적타이핑 (dynamic type)
// 변수는 고정타입이 없다

// runtime 에 개발자가 모르는 어떤 타입의 값이
// 들어올수 있다  주의!

// 데이터 타입
// 1.기본타입 (primitive)
//  -- boolean
//  -- null
//  -- undefined
//  -- number
//  -- string
//  -- symbol (ES6 에 추가)
//
// 2. 객체 (object)
// 객체지향언어가 아니지만 함수가 객체역할을 한다. 
// 


//---------------------------------------------------------------------------------
// boolean 타입 : true / false
console.log(`\n<boolean>`)

{
    const isTrue=true;
    const isFalse=false;

    console.log(`isTrue=${isTrue}`,typeof isTrue)
    console.log(`isFalse=${isFalse}`,typeof isFalse)

    if(isTrue){
        console.log(isTrue,"참입니다.");
    }else{
        console.log(isTrue, "거짓입니다.");
    }


    //객체로 생성가능! 가능은 하지만 비추한다. 
    const a=new Boolean(false); // false 값을 갖는 Boolean 객체
    console.log(`a=`,a,typeof a);

    if(a){ // new를 사용하여 생성하면 조건식에서 '참' 으로 판정된다?
        console.log(a,"참입니다.");
    }else{
        console.log(a, "거짓입니다.");
    }

    //new를 사용하지 않고 boolean만들기
    const b=Boolean(false) //Boolean() 함수가 되는거지.
    console.log(`b=`,b,typeof b);

    if(b){ 
        console.log(b,"참입니다.");
    }else{
        console.log(b, "거짓입니다.");
    }


}

//--------------------------------------------------------------------------
// null : 값이 없는 object 
console.log(`\n<null>`)
{

    const a=null;
    console.log(`a= `,a , typeof a)

}


//--------------------------------------------------------------------------
// undefined : 아무 값도 대입 안된 상태. 
console.log(`\n<undefined>`)
{
    let b; // 아무값도 대입 안된 상태, undefined
    console.log(`b= `, b, typeof b);

    let a=10; // 원래는 number 타입으로 나옴. 
    a= undefined; //다시 ubdefined 로 대입하면  
    console.log('a= ',a, typeof a) //b 처럼 undefined 나옴


    a=null; b=undefined;
    if(a==b){ //==: 값이 같은지만 비교하는것. 
        console.log('a와 b가 같습니다') // ==같습니다. 
    }else{
        console.log('a와 b가 다릅니다')
    }


    if(a===b){ //===: 값뿐만 아니라 type까지 비교
        console.log('a와 b가 같습니다') 
    }else{
        console.log('a와 b가 다릅니다') // ==다릅니다. 
    }

    //가급적 JS 프로그래밍에 작성시 ==보단 === 추천
    //!=보다는 !==추천
}


//------------------------------------------------------------------------
//number
console.log(`\n<number>`)
{

    //실수이든 정수이든 모두 number 타입. 
    const a=37;
    console.log('a=',a,typeof a);
    
    const b=3.14;
    console.log('b=',b,typeof b);

    const c=NaN; //Not a Number
    console.log('c=',c,typeof c);

    let d=Number(123);
    console.log('d=',d,typeof d);

    d=Number('123'); //number 로 형변환 된다. 
    console.log('d=',d,typeof d); //number
    
    d=Number('Mark');
    console.log('d=',d,typeof d); //NaN

    d=parseInt('123'); //이 또한 number로 형변환. 
    console.log('d=',d,typeof d); //number
    
    d=parseInt('Alice'); 
    console.log('d=',d,typeof d); //NaN

    d=parseInt('3.14'); //number로 형변환
    d*=2;
    console.log('d=',d,typeof d)

    d=parseInt('3.14'); //3.14 -> 3
    console.log('d=',d,typeof d)

    d=parseFloat('300'); 
    console.log('d=',d,typeof d)

    num1=100 ; num2='100';
    if(num1==num2){ //== 값을 비교.
        console.log(`${num1}==${num2} 같다`)
    }else{
        console.log(`${num1}==${num2} 다르다`)
    }

    if(num1===num2){ //== 값과 타입 비교.
        console.log(`${num1}===${num2} 같다`)
    }else{
        console.log(`${num1}===${num2} 다르다`)
    }

}


//------------------------------------------------------------------------
//String(문자열) : ' ' " "
console.log(`\n<String>`)

{
    let a='Mark'
    console.log('a=',a,typeof a);
    
    a='Mark'
    console.log('a=',a,typeof a);

    // She's gone
    a = "She's gone";
    console.log('a=',a,typeof a);

    // He says "Hello"
    a = 'He says "Hello"';
    console.log('a=',a,typeof a);

    // He says "I'm fine"
    a = "He says \"I'm fine\"";
    console.log('a=',a,typeof a);

    // +문자열 연산
    a="Mark"
    let b=a+" Hamill"
    console.log('b=',b,typeof b);


    console.log(a * 2) //NaN

    
    //문자열 비교연산 가능! 코드순 비교 
    console.log("a">"b")
    console.log("a"<"b")
    console.log("abc">"abd")
    console.log("AAaa">"AaAa") // false : 대문자보다 소문자가 크지

}


//-------------------------------------------------
// symbol : ES6 부터 출현, '고유'한 값을 만들어낼때 사용
// https://developer.mozilla.org/ko/docs/Glossary/Symbol
console.log(`\n<symbol>`)
{
    const a=Symbol(); // new 사용하면 안됨. 
    const b=Symbol(37);
    const c=Symbol('Mark');
    const d=Symbol('Mark'); //c, d 는 같은 것이 아니다! 고유한 Symbol 객체로 만들어진다. 

    console.log('a=',a, typeof a);
    console.log('b=',b, typeof b);
    console.log('c=',c, typeof c);
    console.log('d=',d, typeof d);

    //Symbol은 완전히 다른것으로 인식한다. 
    console.log(c==d);
    console.log(c===d);

    //일반 문자열
    e='Mark'; f='Mark'
    console.log(e==f);
    console.log(e===f);


}


