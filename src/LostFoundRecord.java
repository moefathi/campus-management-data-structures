package cms;

public class LostFoundRecord {
	private String description;
	private String date;
	private String location;
	private boolean isFound;
	
	public LostFoundRecord(String describtion, String date, String location) {
		this.description = describtion;
		this.date = date;
		this.location = location;
		this.isFound = false;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public String getLocation() {
		return location;
	}

	public boolean isFound() {
		return isFound;
	}

	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}

	

}
