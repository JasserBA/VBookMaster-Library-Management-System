package metierBook;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import daoBooks.IGestionBook;

public class GestionMemberImplArrayList implements IGestionBook{

	List<Book>liste=new ArrayList<Book>();

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public List<Book> getBooksBMC(String mc) {
		// TODO Auto-generated method stub
		List<Book>l=new ArrayList<Book>();
		for(Book e :liste)
			if(e.getTitle().contains(mc))
				l.add(e);
		return l;
	}

	@Override
	public void trierBookParNom() {
		liste.sort((a,b)->a.getTitle().compareTo(b.getTitle()));
	}
	@Override
	public void ajouterBook(Book e) {
		liste.add(e);
	}

	@Override
	public List<Book> rechercherParMC(String mc) {
		List<Book>l=new ArrayList<>();
		for(Book e:liste)
			if(e.getTitle().contains(mc))
				l.add(e);
		return l;
	}

	@Override
	public List<Book> listeDesBooks() {
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public void supprimerBook(int id) {
		for(Iterator<Book>i=liste.iterator();i.hasNext();)
		{
			Book e=i.next();
			if(e.getId()==id)
				i.remove();
		}
		
	}

	@Override
	public boolean verifierBookID(int c) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int verifierLogin(int cin, String password) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
