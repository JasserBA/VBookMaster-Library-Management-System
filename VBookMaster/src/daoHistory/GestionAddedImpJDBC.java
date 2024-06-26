package daoHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnection;

import metierHistory.History;

public class GestionAddedImpJDBC implements IGestionAdded {
    
    private Connection cnx;
    
    public GestionAddedImpJDBC() throws SQLException {
        cnx = SingletonConnection.getInstance();
    }
    

    @Override
    public void ajouterHistory(History e) throws SQLException {
        PreparedStatement ps = cnx.prepareStatement("INSERT INTO AddedHistory(BookID,CIN,Category,CoverPath) VALUES(?,?,?,?)");
        ps.setInt(1, e.getBookID());
        ps.setInt(2, e.getCin());
        ps.setString(3, e.getCategory());
        ps.setString(4, e.getCoverPath());
        ps.executeUpdate();
    }
    

    @Override
    public List<History> listeHistory() throws SQLException {
        List<History> liste = new ArrayList<>();
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM AddedHistory");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            int BookID = rs.getInt(2);
            int cin = rs.getInt(3);
            String Category = rs.getString(4);
            String CoverPath = rs.getString(5);

            liste.add(new History(id, BookID, cin, Category, CoverPath));
        }
        return liste;
    }


    @Override
    public List<History> getAllHistory() {
        return null;
    }
}
