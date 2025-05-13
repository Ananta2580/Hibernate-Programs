package com.java.lib.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.lib.model.Admin;
import com.java.lib.model.Books;
import com.java.lib.model.LibUsers;
import com.java.lib.model.TranBook;
import com.java.lib.model.TransReturn;
import com.java.lib.util.ConnectionHelper;
import com.java.lib.util.EncryptPassword;

public class LibraryDaoImpl implements LibraryDao{
	
	Connection conn;
	PreparedStatement ps;
	
	@Override
	public String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(libUsers.getPassword());
		conn = ConnectionHelper.getConnection();
		String query = "insert into libusers(username,password) values(?,?)";
		ps = conn.prepareStatement(query);
		ps.setString(1, libUsers.getUsername());
		ps.setString(2, encr);
		ps.executeUpdate();
		return "User Account Created Successfully";
	}

	@Override
	public int login(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(libUsers.getPassword());
		conn = ConnectionHelper.getConnection();
		String query = "select count(*)  cnt from LibUsers where username = ? and password = ? ";
		ps= conn.prepareStatement(query);
		ps.setString(1, libUsers.getUsername());
		ps.setString(2, encr);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

	@Override
	public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		String query;
		boolean isValid = true;
		if(searchType.equals("id")) {
			query = "select * from Books where id = ?";
		}else if(searchType.equals("bookname")) {
			query = "select * from Books where name = ?";
		}else if(searchType.equals("authorname")) {
			query = "select * from Books where author = ?";
		}else if(searchType.equals("dept")) {
			query = "select * from Books where dept = ?";
		}else {
			isValid = false;
			query = "select * from Books";
		}
		
		conn = ConnectionHelper.getConnection();
		ps = conn.prepareStatement(query);
		if (isValid == true) {
			ps.setString(1, searchValue);
		}
		ResultSet rs = ps.executeQuery();
		Books books = null;
		List<Books> booksList = new ArrayList<Books>();
		while(rs.next()) {
			books = new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setNoOfBooks(rs.getInt("TotalBooks"));
			booksList.add(books);
		}
		return booksList;
	}

	@Override
	public int issueOrNot(String username, int bookId) throws ClassNotFoundException, SQLException {
		conn = ConnectionHelper.getConnection();
		String sql = "select count(*) cnt from tranbook where username = ? and bookid = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setInt(2, bookId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

	@Override
	public String issueBook(String username, int bookId) throws ClassNotFoundException, SQLException {
	    conn = ConnectionHelper.getConnection();

	    // 1. Check if this user already has this book issued
	    int alreadyIssued = issueOrNot(username, bookId);
	    if (alreadyIssued > 0) {
	        return "Book Id " + bookId + " for user " + username + " is already issued.";
	    }

	    // 2. Check if user has already issued 4 or more books
	    String countQuery = "SELECT COUNT(*) AS issuedCount FROM tranbook WHERE username = ?";
	    ps = conn.prepareStatement(countQuery);
	    ps.setString(1, username);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	        int issuedCount = rs.getInt("issuedCount");
	        if (issuedCount >= 4) {
	            return "Cannot issue more than 4 books.";
	        }
	    }

	    // 3. Check if this book has only one copy left
	    String stockQuery = "SELECT totalbooks FROM books WHERE id = ?";
	    ps = conn.prepareStatement(stockQuery);
	    ps.setInt(1, bookId);
	    rs = ps.executeQuery();
	    if (rs.next()) {
	        int totalBooks = rs.getInt("totalbooks");
	        if (totalBooks <= 1) {
	            return "Book Id " + bookId + " is not for issue. Only 1 copy available.";
	        }
	    }

	    // 4. Issue book
	    String issueQuery = "INSERT INTO tranbook(username, bookid) VALUES (?, ?)";
	    ps = conn.prepareStatement(issueQuery);
	    ps.setString(1, username);
	    ps.setInt(2, bookId);
	    ps.executeUpdate();

	    // 5. Decrease book count
	    String updateQuery = "UPDATE books SET totalbooks = totalbooks - 1 WHERE id = ?";
	    ps = conn.prepareStatement(updateQuery);
	    ps.setInt(1, bookId);
	    ps.executeUpdate();

	    return "Book Id " + bookId + " issued successfully.";
	}


	@Override
	public List<TranBook> accountDetails(String username) throws ClassNotFoundException, SQLException {
		conn = ConnectionHelper.getConnection();
		String query = "select * from tranbook where username = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		List<TranBook> bookIssued = new ArrayList<TranBook>();
		TranBook tranBook = null;
		while(rs.next()) {
			tranBook = new TranBook();
			tranBook.setBookId(rs.getInt("bookId"));
			tranBook.setUsername(rs.getString("username"));
			tranBook.setDate(rs.getDate("Fromdate"));
			bookIssued.add(tranBook);
		}
		return bookIssued;
	}

	@Override
	public String returnBook(String username, int bookId) throws ClassNotFoundException, SQLException {
		String cmd = "SELECT * FROM TranBook WHERE Username = ? and BookId = ?";
		conn = ConnectionHelper.getConnection();
		ps = conn.prepareStatement(cmd);
		ps.setString(1, username);
		ps.setInt(2, bookId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Date fromDate = rs.getDate("fromDate");
		
		String sql2 = " INSERT INTO TransReturn(UserName,BookId,FromDate) VALUES (?,?,?)" ;
		ps = conn.prepareStatement(sql2);
		ps.setString(1,username);
		ps.setInt(2,bookId);
		ps.setDate(3,fromDate);
		ps.executeUpdate();
		
		String sql1 = "DELETE FROM TranBook WHERE BookId = ? AND Username = ? " ;
		ps = conn.prepareStatement(sql1);
		ps.setInt(1,bookId);
		ps.setString(2,username);
		ps.executeUpdate();
		
		String sql3 = "Update Books set TotalBooks = TotalBooks + 1 where Id = ?";
		ps = conn.prepareStatement(sql3);
		ps.setInt(1, bookId);
		ps.executeUpdate();
		return "Book with Id " +bookId + " For User " +username + " Returned Successfully...";
	}

	@Override
	public List<TransReturn> showHistory(String username) throws ClassNotFoundException, SQLException {
		conn = ConnectionHelper.getConnection();
		String query = "select * from transreturn where username = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		List<TransReturn> histList = new ArrayList<TransReturn>();
		TransReturn tReturn = null;
		while(rs.next()) {
			tReturn = new TransReturn();
			tReturn.setBookId(rs.getInt("bookId"));
			tReturn.setUsername(rs.getString("username"));
			tReturn.setFromDate(rs.getDate("fromDate"));
			tReturn.setToDate(rs.getDate("ToDate"));
			histList.add(tReturn);
		}
		return histList;
	}

	@Override
	public String createAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(admin.getPassword());
		conn = ConnectionHelper.getConnection();
		String query = "INSERT INTO admin (name, password)"
				+ "VALUES (?,?)";
		ps = conn.prepareStatement(query);
		ps.setString(1, admin.getAdminName());
		ps.setString(2, encr);
		ps.executeUpdate();
		return "Admin created Successfully";
	}

	@Override
	public int adminLogin(Admin admin) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(admin.getPassword());
		conn = ConnectionHelper.getConnection();
		String query = "select count(*) cnt from admin where name = ? and password = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, admin.getAdminName());
		ps.setString(2, encr);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

	@Override
	public String addBook(Books book) throws ClassNotFoundException, SQLException {
		conn = ConnectionHelper.getConnection();
		String query = "SELECT id, totalbooks FROM books "
				+ "WHERE name=? AND author=? AND edition=? AND dept=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, book.getName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getEdition());
		ps.setString(4, book.getDept());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("id");
			int noBooks = rs.getInt("TotalBooks");
			int updated = noBooks + book.getNoOfBooks();
			
			query = "update books set TotalBooks = ? where id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, updated);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			return "Book already exist no updated to"+updated;
		}
		else {
			query = "insert into books (name,author,edition,dept,TotalBooks) values (?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getEdition());
			ps.setString(4, book.getDept());
			ps.setInt(5, book.getNoOfBooks());
			
			ps.executeUpdate();
			
			return "New Book Added successfully";
		}
	}

	@Override
	public List<TransReturn> getOverdueReturn() throws ClassNotFoundException, SQLException {
		List<TransReturn> returnList = new ArrayList<TransReturn>();
		conn = ConnectionHelper.getConnection();
		String query = "SELECT bookid, username, fromdate, todate,"
				+"DATEDIFF(todate, fromdate) AS diff "
				+"FROM transreturn WHERE DATEDIFF(todate, fromdate) > 21";
		
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			TransReturn tr = new TransReturn();
			tr.setBookId(rs.getInt("bookid"));
            tr.setUsername(rs.getString("username"));
            tr.setFromDate(rs.getDate("fromdate"));
            tr.setToDate(rs.getDate("todate"));
            tr.setFine((rs.getInt("diff") - 21) * 5);
            
            returnList.add(tr);
		}
		return returnList;
	}

}
