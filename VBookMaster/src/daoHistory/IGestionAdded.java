package daoHistory;

import java.sql.SQLException;
import java.util.List;

import metierBook.Book;
import metierHistory.History;

public interface IGestionAdded {
	void ajouterHistory(History e) throws SQLException;
	List<History> listeHistory()throws SQLException;
	List<History> getAllHistory();
}
