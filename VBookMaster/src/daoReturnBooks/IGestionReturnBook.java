package daoReturnBooks;

import java.sql.SQLException;
import java.util.List;

import metierBook.Book;

public interface IGestionReturnBook {
    void ajouterBook(Book e) throws SQLException;
    void supprimerBook(int cin) throws SQLException;
    
    boolean verifierBookID(int bookid) throws SQLException;

    int verifierLogin(int cin, String password) throws SQLException;

    List<Book> rechercherParMC(String mc) throws SQLException;

    List<Book> listeDesBooks() throws SQLException;
    List<Book> getAllBooks();
    List<Book> getBooksBMC(String mc);
    void trierBookParNom();
}
