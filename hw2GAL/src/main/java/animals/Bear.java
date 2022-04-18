package animals;
// Медведи
class Bear extends Predators {

	public Bear(String name, String voice) {
		super(name, voice);
	}

	@Override
	public String Voice() {
		return getVoice();
	}

}
