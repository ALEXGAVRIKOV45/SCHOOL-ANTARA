package animals;

import animals.interfaces.Fly;
import animals.interfaces.Voice;

// Утки
public class Duck extends Herbivores implements Fly, Voice {


	public Duck(String name, String voice) {
		super(name, voice);
	}

	@Override
	public String getVoice() {
		return this.voice;
	}

	@Override
	public void flying() {
		System.out.println("Утка " + this.name + " летит");
	}


}
