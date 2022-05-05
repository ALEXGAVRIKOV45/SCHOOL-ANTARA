package food;
// Еда
public class Food {
	String name;
	int nutritional;

	public Food(String name, int nutritional) {
		this.name = name;
		this.nutritional = nutritional;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNutritional() {
		return nutritional;
	}

	public void setNutritional(int nutritional) {
		this.nutritional = nutritional;
	}
}
