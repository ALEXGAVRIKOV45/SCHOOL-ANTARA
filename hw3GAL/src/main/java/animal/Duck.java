package animal;

import animal.interfaces.Fly;
import animal.interfaces.Swim;
import animal.interfaces.Voice;

// Утки
public class Duck extends Herbivores implements Fly, Swim, Voice {

	public Duck(String name, String voice, AviarySize aviarySize) {
		super(name, voice, aviarySize);
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
