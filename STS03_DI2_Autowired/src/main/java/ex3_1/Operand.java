package ex3_1;

public class Operand {
	int value;

	
	public Operand() {
		System.out.println("기본생성자 Operand() 생성");
	}

	
	public Operand(int value) {
		super();
		System.out.printf("Operand(%s)생성\n",value);
		this.value = value;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return String.format("[Operand:%d]",value);
	}
	
}
