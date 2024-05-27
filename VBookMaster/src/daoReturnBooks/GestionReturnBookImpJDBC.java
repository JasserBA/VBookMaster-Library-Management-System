package daoReturnBooks;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import metierBook.Book;

public class GestionReturnBookImpJDBC implements IGestionReturnBook {
	 private List<Book> liste=new ArrayList<Book>();
	private Connection cnx;
	public GestionReturnBookImpJDBC() throws SQLException
	{
		cnx=SingletonConnection.getInstance();
	}

	@Override
	public void ajouterBook(Book e) throws SQLException {
		PreparedStatement ps=cnx.prepareStatement("INSERT INTO returnbooks(BookID,Title,Publisher,Category,CoverPath,PDFPath) VALUES(?,?,?,?,?,?)");
		ps.setInt(1, e.getBookID());
		ps.setString(2, e.getTitle());
		ps.setString(3, e.getPublisher());
		ps.setString(4, e.getCategory());
		ps.setString(5, e.getCoverPath());
		ps.setString(6, e.getPDFPath());
		ps.executeUpdate();
	}
	
	@Override
	public boolean verifierBookID(int bookid) throws SQLException {
		// TODO Auto-generated method stub
	    String query = "SELECT COUNT(*) FROM returnbooks WHERE BookID = ?";
	    try (PreparedStatement ps = cnx.prepareStatement(query)) {
	        ps.setInt(1, bookid);
	        try (ResultSet rs = ps.executeQuery()) {
	            return rs.next() && rs.getInt(1) > 0;
	        }
	    }
	}

	@Override
	public List<Book> rechercherParMC(String mc) throws SQLException {
		List<Book>liste=new ArrayList<Book>();
		PreparedStatement ps=cnx.prepareStatement("SELECT * FROM returnbooks WHERE Title LIKE ?");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			liste.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)));
		}
		return liste;
	}
	@Override
	public List<Book> listeDesBooks() throws SQLException {
	    List<Book> liste = new ArrayList<>();
	    PreparedStatement ps = cnx.prepareStatement("SELECT * FROM returnbooks");
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
	        int id = rs.getInt(1);
	        int BookID = rs.getInt(2);
	        String Title = rs.getString(3);
	        String Publisher = rs.getString(4);
	        String Category = rs.getString(5);
	        String CoverPath = rs.getString(6);
	        String PDFPath = rs.getString(7);

	        liste.add(new Book(id, BookID, Title, Publisher, Category, CoverPath, PDFPath));
	    }
	    return liste;
	}


	@Override
	public void supprimerBook(int bookid)throws SQLException {
		PreparedStatement ps=cnx.prepareStatement("DELETE FROM returnbooks WHERE BookID=?");
		ps.setInt(1, bookid);
		ps.executeUpdate();
	}

	@Override
	public int verifierLogin(int cin, String password) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksBMC(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trierBookParNom() {
		// TODO Auto-generated method stub
		liste.sort((a,b)->a.getTitle().compareTo(b.getTitle()));
	}


}
