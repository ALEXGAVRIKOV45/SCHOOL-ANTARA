package animals;
// Волки
public class Wolf extends Predators {

	public Wolf(String name, String voice) {
		super(name, voice);
	}

	@Override
	public String Voice() {
		return getVoice();
	}

}
