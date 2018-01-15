package models;

public enum GermanPrefix {
	
	one("ein"),
	two("zwei"),
	three("drei"),
	four("vier"),
	five("funf"),
	//////******/////
//	Ich möchte ein Zimmer in Sarajevo zwischen 25.05.2018 und 30.05.2018 buchen.
	und("und"),
	in("in"),
	zimmer("zimmer");
	

	private String prefix;
	
	GermanPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix() {
		return prefix;
	}

}
