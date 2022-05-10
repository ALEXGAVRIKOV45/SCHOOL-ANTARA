import java.util.Scanner;

public class Calculator {
	static float a, b;
	static int operation;
	static int exit = 1;
	static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		while (true) {
			if (exit == 0) {
				System.out.println("Работа калькулятора завершена");
				break;
			}
			inputNumber();
			Operations countNumbers = new Operations();
			switch (operation) {
				case 1:
					System.out.println(a + " + " + b + " = " + countNumbers.plusNumbers(a, b));
					break;
				case 2:
					System.out.println(a + " - " + b + " = " + countNumbers.minusNumbers(a, b));
					break;
				case 3:
					System.out.println(a + " * " + b + " = " + countNumbers.multiplyNumbers(a, b));
					break;
				case 4:
					System.out.println(a + " / " + b + " = " + countNumbers.divideNumbers(a, b));
					break;
			}

			isExit();
		}

	}

	static void inputNumber() {
		System.out.println("Введите цифры А и В:");
		a = sc.nextFloat();
		b = sc.nextFloat();

		do {
			System.out.println("Введите номер операции +(1) -(2) *(3) /(4) :");
			operation = sc.nextInt();
		} while (!isOperationValid());
	}

	static void isExit() {
		do {
			System.out.println("Еще раз ? 1-Да 0-Нет");
			exit = sc.nextInt();
		} while (!isExitValid());
	}

	static Boolean isExitValid() {
		if (exit < 0 || exit > 1) {
			return false;
		}
		return true;
	}

	static Boolean isOperationValid() {
		if (operation < 0 || operation > 4) {
			return false;
		}
		return true;
	}
}
