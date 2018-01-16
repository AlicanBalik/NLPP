package models;

public enum CroatianPrefix {
	
	one("jednu"),
	two("dvije"),
	three("tri"),
	four("četiri"),
	five("pet"),
	////***///
	rezervirati("rezervirati"),
	u("u"),
	i("i");

	private String prefix;
	
	CroatianPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix() {
		return prefix;
	}

}
