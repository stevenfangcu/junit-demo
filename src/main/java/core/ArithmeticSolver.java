package core;

public class ArithmeticSolver {
	public double add(double leftOp, double rightOp) {
		return leftOp + rightOp;
	}
	public double subtract(double leftOp, double rightOp) {
		return leftOp - rightOp;
	}
	public double multi(double leftOp, double rightOp) {
		return leftOp * rightOp;
	}
	public double divide(double leftOp, double rightOp) {
		return leftOp / rightOp;
	}
	public double modulus(double leftOp, double rightOp) {
		return leftOp % rightOp;
	}
	public double solve(String operator, double leftOperand, double rightOperand) {
		double answer = 0;
		switch (operator) {
			case"+":
				answer = add(leftOperand, rightOperand);
				break;
			case"-":
				answer = subtract(leftOperand, rightOperand);
				break;
			case"*":
				answer = multi(leftOperand, rightOperand);
				break;
			case"/":
				answer = divide(leftOperand, rightOperand);
				break;
			case"%":
				answer = modulus(leftOperand, rightOperand);
				break;
		}
		return answer;
	}
}
