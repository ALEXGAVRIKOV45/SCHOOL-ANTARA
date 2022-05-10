import interfaces.Divide;
import interfaces.Minus;
import interfaces.Multiply;
import interfaces.Plus;

public class Operations implements Plus, Minus, Multiply, Divide {

	public Operations() {
	}

	@Override
	public Float plusNumbers(float a, float b) {
		return Float.valueOf(a+b);
	}

	@Override
	public Float minusNumbers(float a, float b) {
		return Float.valueOf(a-b);
	}

	@Override
	public Float multiplyNumbers(float a, float b) {
		return Float.valueOf(a*b);
	}

	@Override
	public Float divideNumbers(float a, float b) {
		return Float.valueOf(a/b);
	}

}
