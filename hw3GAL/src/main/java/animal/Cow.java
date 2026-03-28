package animal;

import animal.interfaces.Run;
import animal.interfaces.Swim;
import animal.interfaces.Voice;

// Коровы
public class Cow extends Herbivores implements Voice, Swim, Run {

	public Cow(String name, String voice, AviarySize aviarySize) {
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
	public void swiming() {
		System.out.println("Корова " + getName() + " плавает");
	}

	@Override
	public String voice() {
		return this.getVoice();
	}


	@Override
	public void runing() {
		System.out.println("Корова " + getName() + " бегает");
	}

}
