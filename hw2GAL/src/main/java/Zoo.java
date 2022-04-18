import animals.Animal;
import animals.Duck;

public class Zoo {
	public static void main(String[] args) {
		System.out.println("test");

		Worker worker = new Worker("Василич",35,"Мужик");
		Animal duck1 = new Duck("Дональд Дак", "Кря кря");

		worker.goToTheWork();

		duck1.flying();
		System.out.println(duck1.getVoice());
		}
	}


