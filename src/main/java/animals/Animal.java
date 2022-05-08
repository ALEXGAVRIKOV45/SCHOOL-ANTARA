package animals;

import food.Food;
import food.Grass;
import food.Meat;

public abstract class Animal {
	protected String name;
	protected String voice;

	public Animal(String name, String voice) {
		this.voice = voice;
		this.name = name;
	}

	public Boolean eat(Food food) {
		if ((this instanceof Predators && food instanceof Meat) || (this instanceof Herbivores && food instanceof Grass)) {
			return true;
		} else return false;
	}

	public Animal(String name) {
		this.name = name;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String voice() {
		return this.voice;
	}

}

