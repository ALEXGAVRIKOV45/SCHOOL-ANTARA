package StepDefs;

public enum SortingMode {
	ПоУмолчанию(1,"По умолчанию"),
	Дешевле(2,"Дешевле"),
	Дороже(3,"Дороже"),
	ПоДате(4,"По дате");

	private int id;
	private String title;

	SortingMode(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public int getId(){
		return id;
	}
}
