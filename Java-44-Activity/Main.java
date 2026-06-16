import java.io.IOException;
import java.sql.*;
/*
Use the chinook database to write the SQL statements to produce the info asked (using chinookDBdiagram.jpg to decide which tables contain the required info and their relationships)
*/
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() {

    String sql = "";
    String result ="";     
		Database db = new Database("jdbc:sqlite:chinook.db");	

    // Problem 1:
    // For the first 30 tracks, get the name of the track and the album name that it belongs to.
    sql  = " Select tracks.name, albums.title FROM tracks ";
    sql += " Inner Join albums ";
    sql += " ON tracks.albumId = albums.albumId ";
    sql += " LIMIT 30 ";
    result = db.runSQL(sql,"table-auto");

    // Problem 2:
    // // For every Invoice in April 2012, retrieve the customer's first name & last name, invoice id, and invoice date.  (Invoice date format: YYYY-MM-DD)
    sql  = " SELECT customers.firstname, customers.lastname, ";
    sql += " invoices.invoiceid, invoices.invoicedate FROM customers ";
    sql += " INNER JOIN invoices ON customers.customerid = invoices.customerid ";
    sql += " WHERE invoices.invoicedate LIKE '2012-04%' ";
    result = db.runSQL(sql,"table-auto");

    // Problem 3:
    // For the first 20 invoices, get the customer id, invoice id, track name, unit price and quantity. (Hint: information is across 3 tables)
     sql  = " SELECT customers.customerid, invoices.invoiceid, ";
    sql += " invoice_items.unitprice, invoice_items.quantity FROM customers ";
    sql += " INNER JOIN invoices ON customers.customerid = invoices.customerid ";
    sql += " INNER JOIN invoice_items ON invoices.invoiceid=invoice_items.invoiceid";
    sql += " LIMIT 20 ";
    result = db.runSQL(sql,"table-auto");

    // Problem 4:
    // What is the list of customer names whose merchandise is being shipped either to the USA, Germany or Poland? (Hint: use BillingCountry in invoices table). (REMOVE DUPLICATES)
    sql  = " SELECT DISTINCT customers.firstname, customers.lastname FROM customers ";
    sql += " INNER JOIN invoices ON customers.customerid = invoices.customerid ";
    sql += " WHERE invoices.billingcountry IN ('USA','Germany','Poland') ";
    result = db.runSQL(sql,"table-auto");

    // Problem 5:
    // List the first 20 song(track) names that are “Latin” music (genre)?
    sql  = " SELECT tracks.name FROM tracks ";
    sql += " INNER JOIN genres ON tracks.genreId = genres.genreID ";
    sql += " WHERE genres.name='Latin' ";
    sql += " LIMIT 20 ";
    result = db.runSQL(sql,"table-auto");

    // Problem 6:
    // List all the “Jazz” album titles. 'Jazz' is a genre. (REMOVE DUPLICATES)
    sql  = " SELECT DISTINCT albums.title FROM albums ";
    sql += " INNER JOIN tracks ON tracks.albumId = albums.albumId ";
    sql += " INNER JOIN genres ON tracks.genreId = genres.genreID ";
    sql += " WHERE genres.name='Jazz' ";
    result = db.runSQL(sql,"table-auto");

    // Problem 7:
    // List all the Pop Artist names. 'Pop' is a genre. (REMOVE DUPLICATES)
    sql  = " SELECT DISTINCT artists.name FROM artists ";
    sql += " INNER JOIN albums On artists.artistId = albums.artistId ";
    sql += " INNER JOIN tracks On tracks.albumId = albums.albumId ";
    sql += " INNER JOIN genres On tracks.genreId = genres.genreID ";
    sql += " WHERE genres.name='Pop' ";
    result = db.runSQL(sql,"table-auto");
      
  }    
}