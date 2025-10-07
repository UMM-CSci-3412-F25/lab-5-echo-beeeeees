package echoserver;

import java.io.*;
import java.net.*;

public class EchoClient {
  public static final int portNumber = 6013;

  public static void main(String[] args) throws IOException {
    String server;
    // Use "127.0.0.1", i.e., localhost, if no server is specified.
    if (args.length == 0) {
      server = "127.0.0.1";
    } else {
      server = args[0];
    }

    try {
      // Connect to the server
      Socket socket = new Socket(server, portNumber);

      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      // Get the input stream so we can read from that socket
      InputStream input = socket.getInputStream();
      BufferedReader in = new BufferedReader(new InputStreamReader(input));
    
      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
      // Print all the input we receive from the server
      int line;
      while ((line = stdIn.read()) != null) {
        out.println(line);
        System.out.println(in.readLine());
      }

      // Close the socket when we're done reading from it
      socket.shutdownOutput();
      socket.close();

    // Provide some minimal error handling.
    } catch (ConnectException ce) {
      System.out.println("We were unable to connect to " + server);
      System.out.println("You should make sure the server is running.");
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}