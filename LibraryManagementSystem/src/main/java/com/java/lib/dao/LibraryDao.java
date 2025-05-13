package com.java.lib.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.lib.model.Admin;
import com.java.lib.model.Books;
import com.java.lib.model.LibUsers;
import com.java.lib.model.TranBook;
import com.java.lib.model.TransReturn;

public interface LibraryDao {
	
	String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException;
	int login(LibUsers libUsers) throws ClassNotFoundException, SQLException;
	List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException;
	int issueOrNot(String username, int bookId) throws ClassNotFoundException, SQLException;
	String issueBook(String username, int bookId) throws ClassNotFoundException, SQLException;
	List<TranBook> accountDetails(String username) throws ClassNotFoundException, SQLException;
	String returnBook(String username, int bookId) throws ClassNotFoundException, SQLException;
	List<TransReturn> showHistory(String username) throws ClassNotFoundException, SQLException;
	String createAdmin(Admin admin) throws ClassNotFoundException, SQLException;
	int adminLogin(Admin admin) throws ClassNotFoundException, SQLException;
	String addBook(Books book) throws ClassNotFoundException, SQLException;
	List<TransReturn> getOverdueReturn() throws ClassNotFoundException, SQLException;
}
