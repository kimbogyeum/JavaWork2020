//object
console.log('object');

//property: value 쌍
x={firstName:"Jhon", lastName:"Doe"};
console.log(x,typeof x);

//value 접근하는 방법
console.log(x["firstName"],x.firstName);

//object 는 length 값 없다. 
console.log(x.length);

//for ~ in 
for(key in x){ //배열에서 index가 추출된것처럼 property 가 추출된다.
    console.log(`x[${key}]=${x[key]}`);
}

//value 는 어떠한 타입이라도 가능!
x={
    name:"kim"
    ,age:24
    ,height:170
    ,score:[20,30,50]
    ,sayHello:function(){
        console.log('안녕하세요');
    }
    ,getScore:function(n){
        return this.score[n]; //this 꼭 써줘야한다. 같은 식구니까.
    }
    ,getTotal: function(){
        var total=0;
        for(i=0;i<this.score.length;i++){
            total+=this.score[i];
        }
        return total;

    }
    ,getaverage: function(){
        var avg=this.getTotal()/this.score.length;
        return  avg.toFixed(2);
    }

};
console.log(x['name'],typeof x['name']);
console.log(x['age'],typeof x['age']);
console.log(x.height,typeof x.height);
console.log(x.score, x.score.length);
x.sayHello(); //console.log 안해도되지롱
console.log(x.getScore(0));
console.log(x.getTotal()); //score 점수 합계
console.log(x.getaverage()); //score 점수 합계


console.log();
x={firstName:"Jhon", lastName:"Doe"};
console.log(x,typeof x);
x.firstName="Mike" //변경
console.log(x);

x['age']=45; //없던 property 추가, 파이썬이랑 비슷하네
console.log(x);

delete x.firstName;
console.log(x);

//없는 property 접근하려면
console.log(x.firstName); //undefined

//--------------------------------------
//console.log(a); //에러
var b
console.log(b);//undefined
b="김재현";
console.log(b);

// '함수'가 'object 생성자'로 사용가능.
function Person(firstName,lastName,age){
    //함수안에서 this
    this.firstName=firstName;
    this.lastName=lastName;
    this.age=age;

    //console.log(this);
}

Person('aaa', 'bbb', 30); //호출
var p1=new Person('aaa', 'bbb', 30);// 생성자
console.log(p1);
var p2=new Person('김','재현',25);
console.log(p2);
