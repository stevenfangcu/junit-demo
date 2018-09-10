package core;

import junit.framework.TestCase;

public class ArithmeticSolverTest extends TestCase{
	
	public void testAdd() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(4.0, solver.add(2,2));
	}
	public void testSubtract() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(2.0, solver.subtract(4,2));
	}
	public void testAddNumberativeNumber() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(-2.0, solver.subtract(2,4));
		assertEquals(-55.0, solver.add(-58, 3));
		assertEquals(10.0, solver.add(25,-15));
	}
	public void testAddLargeNumbers () {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		//assertEquals(Double.MIN_VALUE, solver.subtract(Double.MAX_VALUE,1));
		//assertEquals(-5.8110005, solver.add(-58752887, 642882));
	}
	public void testAddDecimalNumbers () {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(8.6,  solver.add(5.3, 3.3));
		assertEquals(12.778,  solver.add(9.445, 3.333));
		assertNotNull(solver.add(9.445, 3.333));
		
	}
	public void testMulti() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(4.0, solver.multi(4,1));
	}
	public void testDivide() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(3.0, solver.divide(6,2));
	}
	public void testModulus() {
		ArithmeticSolver solver = new ArithmeticSolver();
		
		assertEquals(1.0, solver.modulus(5,2));
	}
}
