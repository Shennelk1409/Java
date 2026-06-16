import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.sql.*;

import java.net.InetSocketAddress;
import java.util.Map;
/*
In order to communicate with the DB server from a browser tab, you will need to append the route name to the Dev URL (copy url from Networking tool within Replit)
OR 
In the browser address bar, type in http:// followed by your IP address, then a colon and the port #, followed by the route name
For e.g., http://192.168.0.100:8500/route_name
*/
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() throws IOException{

    // Create a port - this is your Gateway
    int port = 8500;

    // Create the HTTPserver object
    HttpServer server = HttpServer.create(new InetSocketAddress(port),0);

    // Create the database object
    Database db = new Database("jdbc:sqlite:chinook.db");

    // For all problems below, limit query to about 5 records and only pull up required fields (columns)    

      // Problem 1: Create a default route that serves the message: "You are connected, but route not given or incorrect....";

    
      // Problem 2: Create a route called 'customers' that gets the First name, Last name and Phone# for the first 5 entries of the Customers table.

    
      // Problem 3: Create a route called 'employees' that gets Employee ID and Title of the first 5 entries in the Employees table.

    
      // Problem 4: Create a route called 'albumsinfo' that gets the albums with the track information and artists information. (Limit to 5 records)

    
      // Problem 5: Create a route called 'customersongs' that gets customer first & last names, song names and date of purchase (i.e., Invoice Date) of each song. (Limit to 5 records)

    

    // Start the server      
    server.start();
    System.out.println("Server is listening on port " + port);        
      
  }    
}
