package edu.fgcu.dataengineering;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException, CsvValidationException {
    BookStoreDB database = new BookStoreDB();
    // Literally just calls our parser right now (....and is called for tests)
    CsvParser csvP = new CsvParser("src/Data/bookstore_report2.csv");
    // csvP.printCsv();
    ArrayList<Book> tempList = new ArrayList<>(csvP.createBookListFromCsv());

    /*
    for (Book book : tempList) {
      System.out.println(book.toString());
    }
    */

    // Insert list of books into the database
    database.insertBookListIntoDatabase(tempList);

    // Load the json
    /*
    1. Create instance of GSON
    2. Create a JsonReader object using FileReader
    3. Array of class instances of AuthorParser, assign data from our JsonReader
    4. foreach loop to check data
     */

    Gson gson = new Gson();
    JsonReader jread = new JsonReader(new FileReader("src/Data/authors.json"));
    AuthorParser[] authors = gson.fromJson(jread, AuthorParser[].class);

    // Function call to add list to the database
    database.insertAuthorListIntoDatabase(authors);

    /*
    for (var element : authors) {
      System.out.println(element.getName());
    }
     */
  }
}
