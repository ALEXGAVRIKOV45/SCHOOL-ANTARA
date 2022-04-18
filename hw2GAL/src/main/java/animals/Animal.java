package animals;

import animals.interfaces.Fly;
import animals.interfaces.Run;
import animals.interfaces.Swim;
import animals.interfaces.Voice;

public class Animal {
	protected static String voice;
	protected static String name;

	public Animal(String name, String voice) {
		this.name = name;
		this.voice = voice;
	}

	//	void eat(Food food) {
//
//
//	}
	public void flying() {
	}

	public String getVoice() {
		return voice;
	}


}

