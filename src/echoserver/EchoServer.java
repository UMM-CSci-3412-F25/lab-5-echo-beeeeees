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
        InputStream input = client.getInputStream();
        OutputStream output = client.getOutputStream();

        // Construct a writer so we can write to the socket, thereby
        // sending something back to the client.
        // Send the current date back to the client.
        
        

        // BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        


        int character;
        while ((character = input.read()) != -1) {
          System.out.print((char)character);
          output.write(character);
      }

      output.flush();

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