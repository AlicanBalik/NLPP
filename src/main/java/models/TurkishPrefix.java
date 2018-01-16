package models;

public enum TurkishPrefix {
	
	one("bir"),
	two("iki"),
	three("uc"),
	four("dort"),
	five("bes"),
	//////*****////
	// 25.05.2018 ve 30.05.2018 tarihleri arasinda Sarajevo'da bir oda rezervasyonu yaptirmak istiyorum
	ve("ve"),
	arasinda("arasinda"),
	oda("oda");

	private String prefix;
	
	TurkishPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix() {
		return prefix;
	}

}
