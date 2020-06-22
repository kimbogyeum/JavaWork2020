package ex2_1;

public class PlusOp implements OperatorBean {

	int operand1;
	int operand2;
	
	
	

	public PlusOp(int operand1, int operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}


	public PlusOp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getOperand1() {
		return operand1;
	}


	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}


	public int getOperand2() {
		return operand2;
	}


	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}


	@Override
	public int doOperate() {
		int result=operand1+operand2;
		return result;
	}

}
