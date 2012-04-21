package cdl.android.model;

public class UserInfo {
	private String firstName;
	private String lastName;
	
	private LevelInfo levelInfo;
	
	private int levelNo;
	private String race;
	private String email;
	private int points;
	
	public UserInfo(String firstName, String lastName, LevelInfo levelInfo) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		
		this.setLevelInfo(this.levelInfo);
	}
	
	public UserInfo(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		
		this.setLevelInfo(new LevelInfo());
	}
	
	public UserInfo() {
		this("", "");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LevelInfo getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(LevelInfo level) {
		this.levelInfo = level;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
