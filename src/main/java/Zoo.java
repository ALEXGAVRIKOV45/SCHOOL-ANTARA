
import animals.*;
import animals.interfaces.Swim;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {
	public static void main(String[] args) {
		System.out.println("Открылся ЗООПАРК ! ");

		Worker worker = new Worker("Василич", 35, "Мужик");
		Animal duck1 = new Duck("Дональд Дак", "Кря кря");
		Animal cow1 = new Cow("Зорька", "Му му");
		Animal horse1 = new Horse("Пегас", "Игого");
		Animal bear1 = new Bear("Потапыч", "Ррррр");
		Animal wolf1 = new Wolf("Серый", "Ууууу");
		Animal fish1 = new Fish("Гуппи");

		Food food1 = new Grass("Трава", 10);
		Food food2 = new Grass("Зерно", 15);
		Food food3 = new Grass("Яблоки", 12);
		Food food4 = new Meat("Котлета", 20);
		Food food5 = new Meat("Колбаса", 18);
		Food food6 = new Meat("Шашлык", 25);

		Animal[] animals = {
				duck1,
				fish1,
				cow1,
				horse1,
				bear1,
				wolf1
		};

		Food[] foods = {
				food1,
				food2,
				food3,
				food4,
				food5,
				food6
		};
		Swim[] pondAnimals = new Swim[]{
				(Swim) duck1,
				(Swim) fish1,
				(Swim) horse1,
				(Swim) cow1,
				(Swim) wolf1
		};

		worker.goToTheWork();
		worker.getVoice(animals);
		worker.goPond(pondAnimals);
		worker.feed(animals, foods);
	}
}


