import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BoundaryValueCalcTest {
	Calculator calc;

	@BeforeClass
	void beforeTest() {
		calc = new Calculator();
	}


	@DataProvider(name = "dpOutBoundaryCalc")
	@Description("Данные для тестов граничных значений")
	public static Object[][] dpOutBoundaryCalc() {
		return new Object[][]{
				{"-101", "-101" }, {"101","101"}
		};
	}

	@DataProvider(name = "dpInBoundaryPlusCalc")
	@Description("Данные для тестов граничных значений")
	public static Object[][] dpInBoundaryPlusCalc() {
		return new Object[][]{
				{"-100", "-100", -200F}, {"-99", "-99", -198F}, {"99", "99", 198F}, {"100", "100", 200F}
		};
	}

	@DataProvider(name = "dpInBoundaryMinusCalc")
	@Description("Данные для тестов граничных значений")
	public static Object[][] dpInBoundaryMinusCalc() {
		return new Object[][]{
				{"-100", "-100", 0F}, {"-99", "-99", 0F}, {"99", "99", 0F}, {"100", "100", 0F}
		};
	}

	@DataProvider(name = "dpInBoundaryMultiplayCalc")
	@Description("Данные для тестов граничных значений")
	public static Object[][] dpInBoundaryMultiplayCalc() {
		return new Object[][]{
				{"-100", "-100", 10000F}, {"-99", "-99", 9801F}, {"99", "99", 9801F}, {"100", "100", 10000F}
		};
	}

	@DataProvider(name = "dpInBoundaryDivideCalc")
	@Description("Данные для тестов граничных значений")
	public static Object[][] dpInBoundaryDivideCalc() {
		return new Object[][]{
				{"-100", "-100", 1F}, {"-99", "-99", 1F}, {"99", "99", 1F}, {"100", "100", 1F}
		};
	}

	@Test(description = "Тест сложения чисел за границей разрешенных значений", dataProvider = "dpOutBoundaryCalc")
	void boundaryOutCalcPlusTest(String a, String b) {
		Assert.assertNull(calc.plusNumbers(a, b));
	}

	@Test(description = "Тест вычитания чисел за границей разрешенных значений", dataProvider = "dpOutBoundaryCalc")
	void boundaryOutCalcMinusTest(String a, String b) {
		Assert.assertNull(calc.minusNumbers(a, b));
	}

	@Test(description = "Тест умножения чисел за границей разрешенных значений", dataProvider = "dpOutBoundaryCalc")
	void boundaryOutCalcMultiplyTest(String a, String b) {
		Assert.assertNull(calc.multiplyNumbers(a, b));
	}

	@Test(description = "Тест деления чисел за границей разрешенных значений", dataProvider = "dpOutBoundaryCalc")
	void boundaryOutCalcDivideTest(String a, String b) {
		Assert.assertNull(calc.divideNumbers(a, b));
	}

	@DataProvider(name = "dpZeroDivideCalc")
	@Description("Данные для теста деления на НОЛЬ")
	public static Object[][] dpZeroDivideCalc() {
		return new Object[][]{
				{"50", "0"}
		};
	}
	@Test(description = "Тест деления на НОЛЬ", dataProvider = "dpZeroDivideCalc" )
	void boundaryZeroCalcDivideTest(String a, String b) {
		Assert.assertNull(calc.divideNumbers(a, b));
	}

	@Test(description = "Тест сложения чисел граничные значения ", dataProvider = "dpInBoundaryPlusCalc")
	void boundaryInCalcPlusTest(String a, String b, float c) {
		float result = calc.plusNumbers(a, b);
		Assert.assertEquals(c, result);
	}

	@Test(description = "Тест вычитания чисел граничные значения ", dataProvider = "dpInBoundaryMinusCalc")
	void boundaryInCalcMinusTest(String a, String b, float c) {
		float result = calc.minusNumbers(a, b);
		Assert.assertEquals(c, result);
	}

	@Test(description = "Тест умножения чисел граничные значения ", dataProvider = "dpInBoundaryMultiplayCalc")
	void boundaryInCalcMultiplayTest(String a, String b, float c) {
		float result = calc.multiplyNumbers(a, b);

		Assert.assertEquals(c, result);
	}

	@Test(description = "Тест деления чисел граничные значения ", dataProvider = "dpInBoundaryDivideCalc")
	void boundaryInCalcDivideTest(String a, String b, float c) {
		float result = calc.divideNumbers(a, b);

		Assert.assertEquals(c, result);
	}


}
