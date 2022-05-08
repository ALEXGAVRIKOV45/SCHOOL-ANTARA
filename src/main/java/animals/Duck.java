package animals;

import animals.interfaces.Fly;
import animals.interfaces.Swim;
import animals.interfaces.Voice;

// Утки
public class Duck extends Herbivores implements Fly, Swim, Voice {

	public Duck(String name, String voice) {
		super(name, voice);
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}

	public String getVoice() {
		return super.getVoice();
	}

	public void setVoice(String voice) {
		super.setVoice(voice);
	}

	@Override
	public void flying() {
		System.out.println("Утка " + getName() + " летает");
	}

	@Override
	public void swiming() {
		System.out.println("Утка " + getName() + " плавает");
	}



	@Override
	public String voice() {
		return this.getVoice();
	}
}
