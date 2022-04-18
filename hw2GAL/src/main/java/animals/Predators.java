package animals;
// Хищники
public abstract class Predators extends Animal {


	public Predators(String name,String voice) {
		super(name, voice);
	}

	public abstract String Voice();
}
