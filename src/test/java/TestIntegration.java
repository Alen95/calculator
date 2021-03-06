

import static org.junit.Assert.assertEquals;

import org.junit.Test;import org.junit.runner.RunWith;

import com.example.model.OperationModel;
import com.example.service.CalculateSimple;

public class TestIntegration {

	@Test
	public void testAddition() {
		int a = 3;
		int b = 4;
		OperationModel opModel = new OperationModel(a,b);
		CalculateSimple calc = new CalculateSimple();
		int additionAB = calc.add(opModel);
		assertEquals(7,additionAB);
		
	}
	
	/**
	 * Test reset of values
	 */
	@Test
	public void testResetOfValues() {
		int a = 3;
		int b = 4;
		OperationModel opModel = new OperationModel(a,b);
		CalculateSimple calc = new CalculateSimple();
		int additionAB = calc.add(opModel);
		opModel = calc.clearSimple(opModel);
		assertEquals(opModel.getA(),0);
		assertEquals(opModel.getB(),0);
	}
	
}
