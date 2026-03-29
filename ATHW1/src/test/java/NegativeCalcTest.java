import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalcTest {
	Calculator calc;

	@BeforeClass
	void beforeTest() {
		calc = new Calculator();
	}

	@DataProvider(name = "dpNegativeCalc")
	@Description("Данные для негативных тестов")
	public static Object[][] dpNegCalc() {
		return new Object[][]{
				{"(", "2", 3F}, {"1", "U", 3F}, {"Г", "2", 3F}
		};
	}

	@Test(description = "Тест метода сложения на невалидные символы", dataProvider = "dpNegativeCalc")
	void negCalcPlusTest(String a, String b, float c) throws NumberFormatException {
		Assert.assertThrows(NumberFormatException.class, () -> {
			calc.plusNumbers(a, b);
		});
	}

	@Test(description = "Тест метода вычитания на невалидные символы", dataProvider = "dpNegativeCalc")
	void negCalcMinusTest(String a, String b, float c) throws NumberFormatException {
		Assert.assertThrows(NumberFormatException.class, () -> {
			calc.minusNumbers(a, b);
		});
	}

	@Test(description = "Тест метода умножения на невалидные символы", dataProvider = "dpNegativeCalc")
	void negCalcMultiplyTest(String a, String b, float c) throws NumberFormatException {
		Assert.assertThrows(NumberFormatException.class, () -> {
			calc.multiplyNumbers(a, b);
		});
	}

	@Test(description = "Тест метода деления на невалидные символы", dataProvider = "dpNegativeCalc")
	void negCalcDivideTest(String a, String b, float c) throws NumberFormatException {
		Assert.assertThrows(NumberFormatException.class, () -> {
			calc.divideNumbers(a, b);
		});
	}

}
