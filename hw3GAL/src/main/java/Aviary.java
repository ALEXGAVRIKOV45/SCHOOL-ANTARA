import animal.Animal;
import animal.AviarySize;
import animal.Herbivores;
import animal.Predators;

import java.util.HashSet;
import java.util.Set;

public class Aviary<T extends Animal> {
	private Set<Animal> a = new HashSet<>();
	char type;
	AviarySize size;

	static String getTypeAV(char typeAV) {
		if (typeAV == 'H') {
			return "травоядных";
		} else {
			return "хищников";
		}
	}

	public Aviary(char typeAV, AviarySize size) {
		this.type = typeAV;
		this.size = size;
		System.out.println("Создан вольер для " + getTypeAV(typeAV) + " размером " + size);
	}

	public void addAviary(Animal animal) {
		if (this.size.ordinal() >= animal.getAviarySize().ordinal()) {
			if ((this.type == 'H' && animal instanceof Herbivores) || (this.type == 'P' && animal instanceof Predators)) {
				this.a.add(animal);
				System.out.println("В вольер " + getTypeAV(this.type) + " добавлен " +
						animal.getClass().getSimpleName() + " " + animal.getName());
			} else {
				System.out.println("Вольер " + getTypeAV(this.type) + " не подходит для " +
						animal.getClass().getSimpleName() + " " + animal.getName());
			}
		} else {
			System.out.println("Вольер " + getTypeAV(this.type) + " мал " + this.size + " " +
					animal.getClass().getSimpleName() + " " + animal.getName() + " " + animal.getAviarySize());
		}
	}

	public void delAviary(Animal animal) {
		if ((this.type == 'H' && animal instanceof Herbivores) || (this.type == 'P' && animal instanceof Predators)) {
			this.a.remove(animal);
			System.out.println("Из вольера " + getTypeAV(this.type) + " ушел " +
					animal.getClass().getSimpleName() + " " + animal.getName());
		}
	}

	public void printAviary() {
		System.out.println();
		System.out.println("Состав вольера " + getTypeAV(this.type));
		for (Animal animal : a) {
			System.out.println(animal.getClass().getSimpleName() + " " + animal.getName());
		}
	}

	public Animal findInAviary(String name) {
		for (Animal av : this.a) {
			if (av.getName().equals(name)) {
				return av;
			}
		}
		return null;
	}


}
