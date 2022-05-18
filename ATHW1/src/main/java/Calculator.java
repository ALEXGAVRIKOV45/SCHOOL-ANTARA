public class Calculator implements CalculatorService {
	@Override
	public Float plusNumbers(String a, String b) throws NumberFormatException {
		if (((Float.parseFloat(a) < -100) || (Float.parseFloat(b) < -100)) || ((Float.parseFloat(a) > 100) || (Float.parseFloat(b) > 100))) {
			return null;
		}
		return (Float.parseFloat(a) + Float.parseFloat(b));
	}

	@Override
	public Float minusNumbers(String a, String b) throws NumberFormatException {
		if (((Float.parseFloat(a) < -100) || (Float.parseFloat(b) < -100)) || ((Float.parseFloat(a) > 100) || (Float.parseFloat(b) > 100))) {
			return null;
		}
		return (Float.parseFloat(a) - Float.parseFloat(b));
	}

	@Override
	public Float multiplyNumbers(String a, String b) throws NumberFormatException {
		if (((Float.parseFloat(a) < -100) || (Float.parseFloat(b) < -100)) || ((Float.parseFloat(a) > 100) || (Float.parseFloat(b) > 100))) {
			return null;
		}
		return (Float.parseFloat(a) * Float.parseFloat(b));
	}

	@Override
	public Float divideNumbers(String a, String b) throws NumberFormatException {
		if ((Float.parseFloat(a) < -100) || (Float.parseFloat(b) < -100) ||
				(Float.parseFloat(a) > 100) || (Float.parseFloat(b) > 100) || (Float.parseFloat(b) == 0)) {
			return null;
		}
		return (Float.parseFloat(a) / Float.parseFloat(b));
	}


}
