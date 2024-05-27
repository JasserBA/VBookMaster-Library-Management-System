package metier;

public class Member {
	private int id,CIN ;
	private String Username,Birthday,Gender,MemberType,Password;
	//private static int cpt; auto increm dans la base de données
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cin) {
		CIN = cin;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getMemberType() {
		return MemberType;
	}
	public void setMemberType(String memberType) {
		MemberType = memberType;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Member(int cin, String username, String birthday, String gender, String memberType,
			String password) {
		super();
		// this.id = cpt++; 
		CIN = cin;
		Username = username;
		Birthday = birthday;
		Gender = gender;
		MemberType = memberType;
		Password = password;
	}
	public Member(int id ,int cin, String username, String birthday, String gender, String memberType,
			String password) {
		super();
		this.id = id;
		CIN = cin;
		Username = username;
		Birthday = birthday;
		Gender = gender;
		MemberType = memberType;
		Password = password;
	}

}
