package echoserver;

import java.io.*;
import java.net.*;

public class EchoServer {
  public static final int portNumber = 6013;

  public static void main(String[] args) {
    try {
      // Start listening on the specified port
      ServerSocket sock = new ServerSocket(portNumber);

      // Run forever, which is common for server style services
      while (true) {
        // Wait until someone connects, thereby requesting a date
        Socket client = sock.accept();
        System.out.println("Got a request!");
        System.out.println("sock.");

        // Construct a writer so we can write to the socket, thereby
        // sending something back to the client.
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // Send the current date back to the client.
        
        

        // BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        


        String line;
        while ((line = stdIn.readLine()) != null) {
        System.out.println(line);
        writer.println(line);
      }

        // Close the client socket since we're done.
        client.shutdownOutput();
        client.close();
      }
    // *Very* minimal error handling.
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}