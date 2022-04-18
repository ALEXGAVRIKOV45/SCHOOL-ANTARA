package animals;
// Лошади
public class Horse extends Herbivores{

	public Horse(String name, String voice) {
		super(name, voice);
	}

	@Override
	public String getVoice() {
		return null;
	}
}
