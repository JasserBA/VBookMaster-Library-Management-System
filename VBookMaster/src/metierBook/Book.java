package metierBook;

public class Book {
	private int id,BookID;
	private String Title,Publisher,Category,CoverPath,PDFPath;
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
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
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
	public String getPDFPath() {
		return PDFPath;
	}
	public void setPDFPath(String pdfpath) {
		PDFPath = pdfpath;
	}
	public Book(int bookID, String title, String publisher, String category, String coverPath, String pdfpath){
		super();
		BookID = bookID;
		Title = title;
		Publisher = publisher;
		Category = category;
		CoverPath = coverPath;
		PDFPath = pdfpath;
	}
	public Book(int id, int bookID, String title, String publisher, String category, String coverPath, String pdfpath){
		super();
		this.id = id;
		BookID = bookID;
		Title = title;
		Publisher = publisher;
		Category = category;
		CoverPath = coverPath;
		PDFPath = pdfpath;
	}

}
