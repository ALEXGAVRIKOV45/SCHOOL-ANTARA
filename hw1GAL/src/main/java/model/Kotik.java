package model;

import java.util.Random;

public class Kotik {
	private static int count; // Количество созданных элементов
	/* Затраты энергии по видам деятельности */
	final int consumPlay = 3;
	final int consumSleep = 1;
	final int consumChaseMouse = 3;
	final int consumLick = 2;
	final int consumPhoto = 2;
	/*   Количество еды при приеме пищи */
	final int food = 10;
	private String name;  // Имя
	private int weight;   // Вес
	private String meow;  // Как мяукает
	private int satiety;  // Степень сытости

	public Kotik(String name, int weight, String meow, int satiety) {
		count++;
		this.name = name;
		this.weight = weight;
		this.meow = meow;
		this.satiety = satiety;
	}

	public Kotik() {
		count++;
	}

	public static int getCount() {
		return count;
	}

	public void liveAnotherDay() {
		Random random = new Random();
		for (int i = 0; i < 24; i++) {
			int act = random.nextInt(5);
			switch (act) {
				case 0:
					System.out.println((i + 1) + " Котик " + getName() + (play(consumPlay) ? " поиграл " : " не поиграл ") + " чувство сытости " + getSatiety());
					break;
				case 1:
					System.out.println((i + 1) + " Котик " + getName() + (sleep(consumSleep) ? " поспал " : " не поспал ") + " чувство сытости " + getSatiety());
					break;
				case 2:
					System.out.println((i + 1) + " Котик " + getName() + (chaseMouse(consumChaseMouse) ? " догонял мышку " : " не догонял мышку") + " чувство сытости " + getSatiety());
					break;
				case 3:
					System.out.println((i + 1) + " Котик " + getName() + (lick(consumLick) ? " вылизался " : " не вылизался") + " чувство сытости " + getSatiety());
					break;
				case 4:
					System.out.println((i + 1) + " Котик " + getName() + (photo(consumPhoto) ? " фотографировался " : " не фотографировался ") + " чувство сытости " + getSatiety());
					break;
			}

			if (getSatiety() <= 0) {
				eat(food);
				System.out.println(" Котик " + getName() + " поел ");
			}
		}
	}

	public Boolean actionsKotik(Kotik kotik, int consum) {
		kotik.satiety -= consum;
		if (kotik.satiety > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean play(int consum) {
		return actionsKotik(this, consum);
	}

	public Boolean sleep(int consum) {
		return actionsKotik(this, consum);
	}

	public Boolean chaseMouse(int consum) {
		return actionsKotik(this, consum);
	}

	public Boolean lick(int consum) {
		return actionsKotik(this, consum);
	}

	public Boolean photo(int consum) {
		return actionsKotik(this, consum);
	}

	public void eat(int satiety) {
		this.satiety += food;
	}

	public void eat(int satiety, int food) {
		this.satiety += food;
	}

	public void eat() {
		eat(this.satiety, food);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getMeow() {
		return meow;
	}

	public void setMeow(String meow) {
		this.meow = meow;
	}

	public int getSatiety() {
		return satiety;
	}

	public void setSatiety(int satiety) {
		this.satiety = satiety;
	}
}
