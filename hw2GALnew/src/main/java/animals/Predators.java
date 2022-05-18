package animals;

import food.Food;
import food.Meat;

// Хищники
public class Predators extends Animal {

	public Predators(String name, String voice) {
		super(name, voice);
	}

	public Predators(String name) {
		super(name);
	}

	@Override
	public Boolean eat(Food food) {
		if (food instanceof Meat) {
			return true;
		} else {
			System.out.println(this.getClass().getSimpleName() + " не едят " + food.getName());
			return false;
		}
	}
}
