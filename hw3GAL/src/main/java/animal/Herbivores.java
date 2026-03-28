package animal;

import food.Food;
import food.Grass;

// Травоядные
public class Herbivores extends Animal {

	public Herbivores(String name, String voice, AviarySize aviarySize) {
		super(name, voice, aviarySize);
	}

	@Override
	public Boolean eat(Food food) {
		if (food instanceof Grass) {
			return true;
		} else {
		//	System.out.println(this.getClass().getSimpleName() + " не едят " + food.getName());
			return false;
		}
	}


}


