package metier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.IGestionMember;

public class GestionMemberImplArrayList implements IGestionMember{

	List<Member>liste=new ArrayList<Member>();

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public List<Member> getMembersBMC(String mc) {
		// TODO Auto-generated method stub
		List<Member>l=new ArrayList<Member>();
		for(Member e :liste)
			if(e.getUsername().contains(mc))
				l.add(e);
		return l;
	}

	@Override
	public void trierMemberParNom() {
		liste.sort((a,b)->a.getUsername().compareTo(b.getUsername()));
		
	}
	@Override
	public void ajouterMember(Member e) {
		liste.add(e);
	}

	@Override
	public List<Member> rechercherParMC(String mc) {
		List<Member>l=new ArrayList<>();
		for(Member e:liste)
			if(e.getUsername().contains(mc))
				l.add(e);
		return l;
	}

	@Override
	public List<Member> listeDesMembers() {
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public void supprimerMember(int id) {
		for(Iterator<Member>i=liste.iterator();i.hasNext();)
		{
			Member e=i.next();
			if(e.getId()==id)
				i.remove();
		}
		
	}

	@Override
	public boolean verifierCIN(int c) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int verifierLogin(int cin, String password) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUsername(int cin) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
