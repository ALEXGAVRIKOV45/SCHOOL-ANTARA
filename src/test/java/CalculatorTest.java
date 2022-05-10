import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
@BeforeClass
	void beforeClass(){


}

@Test
	void calcTest(){
	String[] args = new String[0];
	Calculator.main(args);


}



}
