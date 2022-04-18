import animals.Animal;
import animals.interfaces.Swim;
import food.Food;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Worker {
	private String name;
	private int age;
	private String sex;

	public Worker(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}


	void feed(Animal[] animals, Food[] foods) {
		System.out.println(this.name + " решил покормить животных ");
		for (Animal a : animals) {
			for (Food f : foods) {
				if (a.eat(f)) {
					System.out.println(a.getClass().getSimpleName() + " " + a.getName() + " поел " + f.getName());

				}
			}
		}
		System.out.println();
	}

	public void goPond(Swim[] animals) {
		System.out.println(this.name + " предложил животным поплавать в пруду !");
		System.out.println("В пруду :");

		for (Swim a : animals) {
			a.swiming();
		}
		System.out.println();
	}

	public void getVoice(Animal[] animals) {
		System.out.println(this.name + " попросил всех животных показать голос !");
		for (Animal a : animals) {
			if (a.getClass().getSimpleName().equals("Fish")) {
				continue;
			} else {
				System.out.println(a.getClass().getSimpleName() + " " + a.getName() + " кричит - " + a.getVoice());
			}
		}
		System.out.println();
	}

	public void goToTheWork() {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println(this.sex + " по имени " +
				this.name + " в возрасте " + this.age + " лет пришел на работу в "
				+ localDateTime.format(DateTimeFormatter.ofPattern("HH:mm dd MMMM yyy")));
		System.out.println();
	}


}
