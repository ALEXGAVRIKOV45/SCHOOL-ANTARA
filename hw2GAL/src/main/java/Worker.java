import java.time.LocalDateTime;
import java.time.LocalDate;
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


	void feed(){

	}

	void getVoice() {

	}

	public void goToTheWork() {

		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

		System.out.println(this.sex + " по имени " +
				           this.name + " в возрасте " + this.age + " лет пришел на работу в "
				           + localDateTime.format(DateTimeFormatter.ofPattern("HH:mm dd MMMM yyy")));
	}
}
