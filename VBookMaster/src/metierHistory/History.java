package metierHistory;

public class History {
	private int id,BookID, CIN;
	private String Category,CoverPath;
	//private static int cpt; auto increm dans la base de données
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public int getCin() {
		return CIN;
	}
	public void setCin(int cin) {
		CIN = cin;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getCoverPath() {
		return 	CoverPath;
	}
	public void setCoverPath(String coverPath) {
			CoverPath = coverPath;
	}
	public History(int bookID, int cin, String category, String coverPath){
		super();
		BookID = bookID;
		CIN = cin;
		Category = category;
		CoverPath = coverPath;
	}
	public History(int id, int bookID, int cin, String category, String coverPath){
		super();
		this.id = id;
		BookID = bookID;
		CIN = cin;
		Category = category;
		CoverPath = coverPath;
	}

}
