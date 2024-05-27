package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import metier.Member;
import metierBook.Book;

public class GestionMemberImpJDBC implements IGestionMember {

    private List<Book> liste = new ArrayList<Book>();
    private Connection cnx;

    public GestionMemberImpJDBC() throws SQLException {
        cnx = SingletonConnection.getInstance();
    }

    @Override
    public void ajouterMember(Member e) throws SQLException {
        PreparedStatement ps = cnx.prepareStatement("INSERT INTO Members(CIN,Username,Birthday,Gender,MemberType,Password) VALUES(?,?,?,?,?,?)");
        ps.setInt(1, e.getCIN());
        ps.setString(2, e.getUsername());
        ps.setString(3, e.getBirthday());
        ps.setString(4, e.getGender());
        ps.setString(5, e.getMemberType());
        ps.setString(6, e.getPassword());
        ps.executeUpdate();
    }

    @Override
    public boolean verifierCIN(int cin) throws SQLException {
        String query = "SELECT COUNT(*) FROM Members WHERE CIN = ?";
        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setInt(1, cin);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    @Override
    public List<Member> rechercherParMC(String mc) throws SQLException {
        List<Member> liste = new ArrayList<Member>();
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Members WHERE Username LIKE ?");
        ps.setString(1, "%" + mc + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            liste.add(new Member(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        return liste;
    }

    @Override
    public List<Member> listeDesMembers() throws SQLException {
        List<Member> liste = new ArrayList<>();
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Members WHERE CIN != 0");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            int cin = rs.getInt(2);
            String username = rs.getString(3);
            String birthday = rs.getString(4);
            String gender = rs.getString(5);
            String memberType = rs.getString(6);
            String password = rs.getString(7);

            liste.add(new Member(id, cin, username, birthday, gender, memberType, password));
        }
        return liste;
    }

    @Override
    public void supprimerMember(int cin) throws SQLException {
        PreparedStatement ps = cnx.prepareStatement("DELETE FROM Members WHERE CIN=?");
        ps.setInt(1, cin);
        ps.executeUpdate();
    }

    @Override
    public int verifierLogin(int cin, String password) throws SQLException {
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM Members WHERE CIN = ?");
        ps.setInt(1, cin);

        ResultSet rs = ps.executeQuery();
        if (!((String.valueOf(cin).length() == 8) || cin == 0))
            return 2;
        if (rs.next()) { // Exist-CIN
            String dbPassword = rs.getString("Password");
            if (password.equals(dbPassword))
                return 1; // Success
            else
                return 0; // NotfOUND-password
        } else {
            return -1; // NotfOUND-CIN
        }
    }

    @Override
    public List<Member> getAllMembers() {
        return null;
    }

    @Override
    public List<Member> getMembersBMC(String mc) {
        return null;
    }

    @Override
    public void trierMemberParNom() {
        liste.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));
    }

    @Override
    public String getUsername(int cin) throws SQLException {
        PreparedStatement ps = cnx.prepareStatement("SELECT Username FROM Members WHERE CIN = ?");
        ps.setInt(1, cin);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("Username");
        } else {
            throw new SQLException("Member with CIN " + cin + " not found.");
        }

    }
}
