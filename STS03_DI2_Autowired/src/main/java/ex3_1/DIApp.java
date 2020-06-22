package ex3_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {

	public static void main(String[] args) {
		
		System.out.println("Main 시작");
		//스프링 설정파일 resource 명시
		String configLocation="classpath:applicationContext.xml";
		
		//ApplicationContext 객체를 만드는 시점에서 bean 객체가 생성된다!
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext(configLocation);
		System.out.println("Application Context 컨테이너 생성 완료\n");
		
		OperatorBean operator=null;
		operator =ctx.getBean("op1",OperatorBean.class) ;
		int value = operator.doOperate();
		System.out.println("결과1:" + value);


		ctx.close();
		System.out.println("Main종료");

	}

}
