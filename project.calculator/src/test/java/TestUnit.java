

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.OperationModel;
import com.example.service.CalculateSimple;

@RunWith(SpringJUnit4ClassRunner.class)
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
