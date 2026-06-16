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
    
    // Default route    
    server.createContext("/", new RouteHandler("You are connected, but route not given or incorrect....") );

    /* GOAL: To create a webpage that will display a card for each track(song) in the 'tracks' table from the Chinook database. (See picture "chinookDBdiagram.JPG").

    PART 1: Build a database server with the route you will need to serve the required information from the DB. Test your route to make sure that it is working correctly.
    Database 
    For Part 2, see "Activity50-Website".
    */

    // Add your code here.....see Problem.txt file for tasks



    
  
    // Start the server      
    server.start();
    System.out.println("Server is listening on port " + port);       
      
  }    
}


