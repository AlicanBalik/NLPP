package models;

public enum Languages {
	
	English("en"),
	German("de"),
	Turkish("tr");

	private String prefix;
	
	Languages(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix() {
		return prefix;
	}

}
