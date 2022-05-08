package animal;

import food.Food;
import food.Grass;
import food.Meat;
import food.foodException.WrongFoodException;

import java.util.Objects;

public abstract class Animal {
	protected String name;
	protected String voice;
	AviarySize aviarySize;

	public Animal(String name, String voice, AviarySize aviarySize) {
		this.voice = voice;
		this.name = name;
		this.aviarySize = aviarySize;

	}

	public Boolean eat(Food food) throws WrongFoodException {
		if ((this instanceof Predators && food instanceof Meat) || (this instanceof Herbivores && food instanceof Grass)) {
			return true;
		} else return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || o.getClass() != getClass()) {
			return false;
		}
		return false;
	}

	@Override
	public int hashCode() {

		return Objects.hashCode(name);
	}

	public Animal(String name, AviarySize aviarySize) {
		this.name = name;
		this.aviarySize = aviarySize;
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

	public AviarySize getAviarySize() {
		return aviarySize;
	}

	public void setAviarySize(AviarySize aviarySize) {
		this.aviarySize = aviarySize;
	}
}

