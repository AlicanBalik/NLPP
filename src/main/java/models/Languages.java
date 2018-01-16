package models;

public enum Languages {
	
	Croatian("hr"),
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
