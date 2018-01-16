package models;

public enum CroatianPrefix {
	
	one("jednu"),
	two("dvije"),
	three("tri"),
	four("četiri"),
	five("pet"),
	////***///
	// Želio bih rezervirati jednu sobu u Neumu između 25.05.2018 i 30.05.2018
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
