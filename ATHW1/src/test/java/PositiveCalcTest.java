import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveCalcTest {
	Calculator calc;

	@BeforeClass
	void beforeTest() {
		calc = new Calculator();
	}

	@DataProvider(name = "dpPlusCalc")
	@Description("Данные для тестов сложения чисел")
	public static Object[][] dpPlusCalc() {
		return new Object[][]{
				{"1", "2", 3}, {"10", "15", 25}, {"-10", "-15", -25}, {"1.3", "2.6", 3.9F}, {"10.23", "5.55", 15.78F}, {"-10.11", "-10.22", -20.33F}
		};
	}

	@Test(description = "Тест сложения чисел", dataProvider = "dpPlusCalc")
	void posCalcPlusTest(String a, String b, float c) {
		float result = calc.plusNumbers(a, b);
		if (rabotaSOstatkom(result, c)) {
			result = c;
		}
		Assert.assertEquals(c, result);
	}


	@DataProvider(name = "dpMinusCalc")
	@Description("Данные для тестов вычитания чисел")
	public static Object[][] dpMinusCalc() {
		return new Object[][]{
				{"2", "1", 1}, {"15", "10", 5}, {"-10", "-15", 5}, {"2.6", "1.3", 1.3F}, {"10.23", "5.55", 4.68F}, {"-10.11", "-10.22", 0.11F}
		};
	}

	@Test(description = "Тест вычитания чисел", dataProvider = "dpMinusCalc")
	void posCalcMinusTest(String a, String b, float c) {
		float result = calc.minusNumbers(a, b);
		if (rabotaSOstatkom(result, c)) {
			result = c;
		}
		Assert.assertEquals(c, result);
	}


	@DataProvider(name = "dpMultiplyCalc")
	@Description("Данные для тестов умножения чисел")
	public static Object[][] dpMultiplyCalc() {
		return new Object[][]{
				{"2", "1", 2}, {"15", "10", 150}, {"-10", "-15", 150}, {"2.6", "1.3", 3.38F}, {"10.23", "5.55", 56.7765F}, {"-10.11", "-10.22", 103.324F}
		};
	}

	@Test(description = "Тест умножения чисел", dataProvider = "dpMultiplyCalc")
	void posCalcMultiplyTest(String a, String b, float c) {
		float result = calc.multiplyNumbers(a, b);
		if (rabotaSOstatkom(result, c)) {
			result = c;
		}
		Assert.assertEquals(c, result);
	}

	@DataProvider(name = "dpDivideCalc")
	@Description("Данные для тестов деления чисел")
	public static Object[][] dpDivideCalc() {
		return new Object[][]{
				{"2", "1", 2}, {"15", "10", 1.5F}, {"-10", "-15", 0.6666F}, {"2.6", "1.3", 2.0F}, {"10.23", "5.55", 1.8432F}, {"-10.22", "-10.11", 1.010F}
		};
	}

	@Test(description = "Тест деления чисел", dataProvider = "dpDivideCalc")
	void posCalcDivideTest(String a, String b, float c) {
		float result = calc.divideNumbers(a, b);
		if (rabotaSOstatkom(result, c)) {
			result = c;
		}
		Assert.assertEquals(c, result);
	}

	Boolean rabotaSOstatkom(float n, float m) {
		if (Math.abs(n - m) < 0.001) {
			return true;
		} else {
			return false;
		}
	}

}
