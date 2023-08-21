package my.board;

public class User {
	
	private String userID;
	private String userName;
	private String userPassword;
	private int userAge;
	private String useremail;
	
	public User() {
		
	}
	
	public User(String userID, String userName, String userPassword, int userAge, String email) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAge = userAge;
		this.useremail = email;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return useremail;
	}

	public void setUserEmail(String email) {
		this.useremail = email;
	}


	
	

}
