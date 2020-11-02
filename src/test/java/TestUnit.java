

import static org.junit.Assert.assertEquals;

import org.junit.Test;import org.junit.runner.RunWith;

import com.example.model.OperationModel;

public class TestUnit {

	/**
	 * Test addition functionality
	 */
	@Test
	public void testOperationModel() {
		int a = 3;
		int b = 4;
		OperationModel opModel = new OperationModel();
		opModel.setA(a);
		opModel.setB(b);
		
		assertEquals(opModel.getA(),a);
		assertEquals(opModel.getB(),b);
	}

}
