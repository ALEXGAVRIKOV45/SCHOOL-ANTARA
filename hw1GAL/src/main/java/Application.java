import model.Kotik;

//import static model.Kotik.count;

public class Application {
	public static void main(String[] args) {

		Kotik kotik1 = new Kotik("Murzik", 12, "May may", 18);
		Kotik kotik2 = new Kotik();
		setKotik(kotik2, "Barsik", 10, "Meo meo", 15);
		System.out.println("Котик " + kotik1.getName() + " весит " + kotik1.getWeight());
		kotik1.liveAnotherDay();

		System.out.println();
		System.out.println("Котик " + kotik1.getName() + " говорит " + kotik1.getMeow());
		System.out.println("Котик " + kotik2.getName() + " говорит " + kotik2.getMeow());
		System.out.println("Они мяукают " + (kotik1.getMeow().equals(kotik2.getMeow()) ? "одиниково " : "по разному"));
		System.out.println();
		System.out.println("Всего котиков было создано: " + Kotik.getCount());

	}

	public static void setKotik(Kotik kotik, String name, int weight, String meow, int satiety) {
		kotik.setName(name);
		kotik.setWeight(weight);
		kotik.setMeow(meow);
		kotik.setSatiety(satiety);
	}

}

