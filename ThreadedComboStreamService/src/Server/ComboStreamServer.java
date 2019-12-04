package Server;

import core.ComboServiceDetails;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class ComboStreamServer {

    public static void main(String[] args) {
        try{
            // Set up a connection socket for other programs to connect to
            ServerSocket listeningSocket = new ServerSocket(ComboServiceDetails.LISTENING_PORT);
            
            // Set up ThreadGroup to store all of the client threads together
            ThreadGroup group = new ThreadGroup("Client threads");
            // Place more emphasis on accepting clients than processing them 
            // by setting their maximum priority to be 1 less than the main method's priority
            group.setMaxPriority(Thread.currentThread().getPriority() - 1);
            
            // Do main logic of server
            boolean continueRunning = true;
            int threadCount = 0;
            
            while(continueRunning)
            {
                // Step 2) wait for incoming connection and build communications link
                Socket dataSocket = listeningSocket.accept();

                // Increase the number of threads dealt with by one
                threadCount++;
                System.out.println("The server has now accepted " + threadCount + " clients");
                
                // Step 3) Build thread 
                //         Thread should be given:
                //              1) a group to be stored in
                //              2) a name to be listed under
                //              3) a socket to communicate through
                //              4) Any extra information that should be shared
                ComboServiceThread newClient = new ComboServiceThread(group, dataSocket.getInetAddress()+"", dataSocket, threadCount);
                // Step 4) Start the thread running
                newClient.start();
            }
            listeningSocket.close();
        }
        catch(Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
