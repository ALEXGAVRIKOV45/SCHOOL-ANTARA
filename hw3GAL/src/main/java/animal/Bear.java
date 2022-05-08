package animal;

import animal.interfaces.Run;
import animal.interfaces.Voice;

// Медведи
public class Bear extends Predators implements Run, Voice {

	public Bear(String name, String voice,AviarySize aviarySize) {
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
	public String voice() {
		return this.getVoice();
	}

	@Override
	public void runing() {
		System.out.println("Медведь " + getName() + " бегает");
	}


}
