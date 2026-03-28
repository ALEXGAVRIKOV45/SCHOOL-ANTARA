
import animal.*;
import animal.interfaces.Swim;
import food.Food;
import food.Grass;
import food.Meat;
import food.foodException.WrongFoodException;

public class Zoo {
	public static void main(String[] args) throws WrongFoodException {
		System.out.println("Открылся ЗООПАРК ! ");

		Worker worker = new Worker("Василич", 35, "Мужик");
		Animal duck1 = new Duck("Дональд Дак", "Кря кря", AviarySize.MEDIUM);
		Animal cow1 = new Cow("Зорька", "Му му", AviarySize.LARGE);
		Animal horse1 = new Horse("Пегас", "Игого", AviarySize.LARGE);
		Animal bear1 = new Bear("Потапыч", "Ррррр", AviarySize.VERYBIG);
		Animal wolf1 = new Wolf("Серый", "Ууууу", AviarySize.MEDIUM);
		Animal fish1 = new Fish("Гуппи", AviarySize.SMALL);

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

		Aviary avH = new Aviary('H', AviarySize.LARGE);
		Aviary avP = new Aviary('P', AviarySize.LARGE);

		avH.addAviary(duck1);
		avH.addAviary(horse1);
		avH.addAviary(cow1);

		avH.addAviary(wolf1);

		avP.addAviary(wolf1);
		avP.addAviary(cow1);
		avP.addAviary(bear1);

		avH.printAviary();
		avP.printAviary();

		avH.delAviary(cow1);

		System.out.println("Ссылка на Лошадь - " + avH.findInAviary("Пегас"));
		System.out.println("Ссылка на Волка - " + avP.findInAviary("Серый"));


	}
}


