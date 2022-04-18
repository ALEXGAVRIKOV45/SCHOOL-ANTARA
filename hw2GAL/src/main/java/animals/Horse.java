package animals;

import animals.interfaces.Run;
import animals.interfaces.Swim;
import animals.interfaces.Voice;

// Лошади
public class Horse extends Herbivores implements Run, Swim, Voice {

	public Horse(String name, String voice) {
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
	public void swiming() {
		System.out.println("Лошадь " + getName() + " плавает");
	}

	@Override
	public String voice() {
		return this.getVoice();
	}

	@Override
	public void runing() {
		System.out.println("Лошадь " + getName() + " бегает");
	}

}
