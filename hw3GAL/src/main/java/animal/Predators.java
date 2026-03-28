package animal;

import food.Food;
import food.Meat;
import food.foodException.WrongFoodException;

// Хищники
public class Predators extends Animal {

	public Predators(String name, String voice, AviarySize aviarySize) {
		super(name, voice, aviarySize);
	}

	public Predators(String name,AviarySize aviarySize) {
		super(name, aviarySize);
	}

	@Override
	public Boolean eat(Food food) throws WrongFoodException {

		if (food instanceof Meat) {
			return true;
		} else {
		//	System.out.println(this.getClass().getSimpleName() + " не едят " + food.getName());
			return false;
		}
	}
}
