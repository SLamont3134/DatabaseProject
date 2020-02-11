package edu.fgcu.dataengineering;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.sqlite.SQLiteException;

/** Manages all interactions with the BookStore sqllite database. */
public class BookStoreDB {

  private Connection conn;
  private PreparedStatement pstmt;

  BookStoreDB() {
    this.conn = null;
    pstmt = null;
  }

  /** Establishes connection to the BookStore database. */
  public void connectToDb() {

    try {
      String url = "jdbc:sqlite:src/Data/BookStore.db";
      conn = DriverManager.getConnection(url);

      System.out.println("Connection to SQLite has been established.");

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Inserts a list of Books objects into the book table database.
   *
   * @param tempList ArrayList of book objects.
   */
  public void insertBookListIntoDatabase(ArrayList<Book> tempList) {

    connectToDb();

    for (Book book : tempList) {
      try {
        String insertQuery =
            "INSERT INTO book "
                + "(isbn, publisher_name, author_name,book_year, book_title, book_price)"
                + " VALUES (?, ?, ?,?,?,?)";
        pstmt = conn.prepareStatement(insertQuery);
        pstmt.setString(1, book.getIsbn());
        pstmt.setString(2, book.getPublisherName());
        pstmt.setString(3, book.getAuthorName());
        pstmt.setInt(4, book.getBookYear());
        pstmt.setString(5, book.getBookTitle());
        pstmt.setInt(6, book.getBookPrice());
        pstmt.executeUpdate();
        System.out.println("Successfully Added " + book.getBookTitle() + " To Database");
      } catch (SQLiteException e) {
        System.out.println("Book already exists in database");
      } catch (SQLException e) {
        System.out.println(e);
      }
    }
    disconnectFromDb();
  }

  /**
   * Inserts a list of Authors into the author database.
   *
   * @param tempList ArrayList, list of authors to be inserted into database.
   */
  public void insertAuthorListIntoDatabase(AuthorParser[] tempList) {

    connectToDb();

    for (AuthorParser author : tempList) {
      try {
        String insertQuery =
            "INSERT INTO author " + "(author_name, author_email, author_url)" + " VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(insertQuery);
        pstmt.setString(1, author.getName());
        pstmt.setString(2, author.getEmail());
        pstmt.setString(3, author.getUrl());
        pstmt.executeUpdate();
        System.out.println("Successfully Added " + author.getName() + " To Database");
      } catch (SQLiteException e) {
        System.out.println("Author already exists in database");
      } catch (SQLException e) {
        System.out.println(e);
      }
    }
    disconnectFromDb();
  }

  /** Disconnects from the BookStore database. */
  public void disconnectFromDb() {
    try {
      if (conn != null) {
        conn.close();
        System.out.println("Disconnected From DB");
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  /**
   * Test class for BookStoreDB class.
   *
   * @param args arguments.
   */
  public static void main(String[] args) {
    BookStoreDB test = new BookStoreDB();
    test.connectToDb();
    test.disconnectFromDb();
  }
}
