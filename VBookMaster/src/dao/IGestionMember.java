package dao;

import java.sql.SQLException;
import java.util.List;

import metier.Member;

public interface IGestionMember {
    void ajouterMember(Member e) throws SQLException;
    void supprimerMember(int cin) throws SQLException;
    
    boolean verifierCIN(int cin) throws SQLException;

    int verifierLogin(int cin, String password) throws SQLException;
    String getUsername(int cin) throws SQLException;
    
    List<Member> rechercherParMC(String mc) throws SQLException;

    List<Member> listeDesMembers() throws SQLException;
    List<Member> getAllMembers();
    List<Member> getMembersBMC(String mc);
    void trierMemberParNom();
}
