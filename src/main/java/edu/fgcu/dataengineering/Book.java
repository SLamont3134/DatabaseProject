package edu.fgcu.dataengineering;

public class Book {

  private String isbn;
  private String publisherName;
  private String authorName;
  private int bookYear;
  private String bookTitle;
  private int bookPrice;
  private String store;
  private String location;

  /**
   * All Parameters Constructor
   *
   * @param isbn
   * @param publisherName
   * @param authorName
   * @param bookYear
   * @param bookTitle
   * @param bookPrice
   */
  Book(
      String isbn,
      String publisherName,
      String authorName,
      int bookYear,
      String bookTitle,
      int bookPrice) {
    setIsbn(isbn);
    setPublisherName(publisherName);
    setAuthorName(authorName);
    setBookYear(bookYear);
    setBookTitle(bookTitle);
    setBookPrice(bookPrice);
  }

  /**
   * All Parameters minus bookYear and bookPrice
   *
   * @param isbn
   * @param publisherName
   * @param authorName
   * @param bookTitle
   */
  Book(String isbn, String publisherName, String authorName, String bookTitle) {
    setIsbn(isbn);
    setPublisherName(publisherName);
    setAuthorName(authorName);
    setBookYear(0);
    setBookTitle(bookTitle);
    setBookPrice(0);
  }

  /**
   * @param isbn
   * @param publisherName
   * @param authorName
   * @param bookTitle
   * @param store
   * @param location
   */
  Book(
      String isbn,
      String publisherName,
      String authorName,
      String bookTitle,
      String store,
      String location) {
    setIsbn(isbn);
    setPublisherName(publisherName);
    setAuthorName(authorName);
    setBookYear(0);
    setBookTitle(bookTitle);
    setBookPrice(0);
    setStore(store);
    setLocation(location);
    // System.out.println("Book created");
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public int getBookYear() {
    return bookYear;
  }

  public void setBookYear(int bookYear) {
    this.bookYear = bookYear;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public int getBookPrice() {
    return bookPrice;
  }

  public void setBookPrice(int bookPrice) {
    this.bookPrice = bookPrice;
  }

  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "Book{"
        + "isbn='"
        + isbn
        + '\''
        + ", publisherName='"
        + publisherName
        + '\''
        + ", authorName='"
        + authorName
        + '\''
        + ", bookYear="
        + bookYear
        + ", bookTitle='"
        + bookTitle
        + '\''
        + ", bookPrice="
        + bookPrice
        + ", store='"
        + store
        + '\''
        + ", location='"
        + location
        + '\''
        + '}';
  }
}
