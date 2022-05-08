package animals;

import animals.interfaces.Swim;

// Рыбы
public class Fish extends Predators implements Swim {

	public Fish(String name) {
		super(name);
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public void swiming() {
		System.out.println("Рыбка " + getName() + " плавает");
	}

}
