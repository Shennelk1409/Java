import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.sql.*;

import java.net.InetSocketAddress;
import java.util.Map;
// To Compile in MacOS/Replit use:  javac -cp sqlite-jdbc-3.23.1.jar: Main.java
// To compile in Windows use:       javac -cp sqlite-jdbc-3.23.1.jar
// To execute(run) in Windows use:  java -cp sqlite-jdbc-3.23.1.jar: Main

/*
To communicate with DB server: In browser, append route name to the Port forwarded address
(ctrl + click link in Codespace Port tab)
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
    
     
    // Problem 1: Create a default route that serves the following message: "You are connected, but route not given or incorrect....";
    server.createContext("/", new RouteHandler("You are connected, but route not given or incorrect....") );
    

    // Problem 2: Create a route called 'employees' that gets all the employee records.
    String sql = "";
    sql  = "Select * from employees";
    server.createContext("/employees", new RouteHandler(db,sql) );

    // Problem 3: Create a route called 'songs' that gets the track name and the album title of the song.
    sql  = " SELECT tracks.name, tracks.unitprice, albums.title FROM tracks ";
    sql += " INNER JOIN albums ON tracks.albumid=albums.albumid ";
    server.createContext("/songs", new RouteHandler(db,sql) );
       
    // Start the server      
    server.start();
    System.out.println("Server is listening on port " + port); 
    
  }    
}


