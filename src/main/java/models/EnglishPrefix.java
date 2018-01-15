package models;

public enum EnglishPrefix {
	
	one("one"),
	two("two"),
	three("three"),
	four("four"),
	five("five"),
	////***///
	// I want to book one room in Sarajevo between 25.05.2018 and 30.05.2018.
	book("book"),
	in("in"),
	and("and");

	private String prefix;
	
	EnglishPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix() {
		return prefix;
	}

}
