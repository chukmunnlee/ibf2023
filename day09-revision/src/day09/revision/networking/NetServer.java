package day09.revision.networking;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer {

   public static void main(String[] args) throws Exception {

      int port = 3000;
      if (args.length > 0)
         port = Integer.parseInt(args[0]);

      OutputStream os = new FileOutputStream("log.txt");
      LogSession logger = new LogSession(os);

      // Create a ServerSocket
      System.out.printf("Starting server on port %d\n", port);
      // Try with resource
      try (ServerSocket server = new ServerSocket(port)) {
         while (true) {
            // Accept a new connection
            Socket client = server.accept();
            System.out.printf("Got a new connection...\n");

            HandleClient handler = new HandleClient(client, logger);
            handler.process();
         }
      } catch (Exception ex) {
         // Handle the exception
         ex.printStackTrace();
      } finally {
         logger.close();
      }

      // exit the block, the server is closed: socket.close()
   }
   
}
