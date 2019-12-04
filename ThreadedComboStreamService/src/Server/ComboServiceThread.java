package Server;

import core.ComboServiceDetails;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


// This class must extend the Thread class so it can run by itself
public class ComboServiceThread extends Thread {

    // Create the global variables to hold the Socket, streams and number of this thread
    private Socket dataSocket;
    private Scanner input;
    private PrintWriter output;
    private int number;

    // Constructor should pass input any information the thread will need to interact with the client
    // It MUST get the client's Socket object
    // If there is an object to be shared between all clients 
    // (e.g. Dictionary or EmailStore all clients should add to or query),
    // then it should be passed into the Thread via the constructor's parameters
    public ComboServiceThread(ThreadGroup group, String name, Socket dataSocket, int number)
    {
        super(group, name);

        try
        {
            // Save the data socket used for communication between the thread and the Client
            this.dataSocket = dataSocket;
            // Save the id of the thread to identify output
            this.number = number;
            // Create the stream for reading from the Client
            input = new Scanner(new InputStreamReader(this.dataSocket.getInputStream()));
            // Create the stream for writing to the Client
            output = new PrintWriter(this.dataSocket.getOutputStream(), true);
        } catch (IOException e)
        {
            System.out.println("An exception occurred while setting up connection links for a thread: " + e.getMessage());
        }
    }

    // run method. This is called when .start() is called on an instance of the Thread class
    // The method MUST be called run (it overrides the run method from the Thread class)
    // It should contain the LOGIC of the server, i.e. 
    //      a) receiving messages from client, 
    //      b) processing what the client wants to do
    //      c) sending an appropriate response back to the client
    @Override
    public void run()
    {
        // Set up variables for use in communication with this client
        String incomingMessage = "";
        String response;
        try
        {
            // While the client does not want to end the session
            while (!incomingMessage.equals(ComboServiceDetails.END_SESSION))
            {
                // Wipe the response to make sure we never use an old value
                response = null;

                // take input information from the client
                incomingMessage = input.nextLine();
                System.out.println("Received message: " + incomingMessage);

                // Break up information into components
                String[] components = incomingMessage.split(ComboServiceDetails.COMMAND_SEPARATOR);

                // Process the information supplied by the client
                if (components[0].equals(ComboServiceDetails.ECHO))
                {
                    // Take the remaining text the client sent (i.e. all the information provided)
                    // and execute the requested action (e.g. echo the message back etc)
                    StringBuffer echoMessage = new StringBuffer("");

                    if (components.length > 1)
                    {
                        echoMessage.append(components[1]);
                        // What if the user included %% input their message? It should still be echoed back
                        // So we need to add the %%s that were removed by .split back input
                        for (int i = 2; i < components.length; i++)
                        {
                            echoMessage.append(ComboServiceDetails.COMMAND_SEPARATOR);
                            echoMessage.append(components[i]);
                        }
                    }
                    response = echoMessage.toString();
                } else if (components[0].equals(ComboServiceDetails.DAYTIME))
                {
                    response = new Date().toString();
                } else if (components[0].equals(ComboServiceDetails.END_SESSION))
                {
                    response = ComboServiceDetails.SESSION_TERMINATED;
                } else
                {
                    // If information was missing, set the response to inform the
                    // client that the command wasn't recognised
                    response = ComboServiceDetails.UNRECOGNISED;
                }

                // Send back the computed response
                output.println(response);
                output.flush();
            }
        }
        catch(Exception e)
        {
            System.out.println("An exception occurred while communicating with client #" + number + ": " + e.getMessage());     
        } finally
        {
            try
            {
                // Shut down connection
                System.out.println("\n* Closing connection with client #" + number + "... *");
                dataSocket.close();
            } catch (IOException e)
            {
                System.out.println("Unable to disconnect: " + e.getMessage());
                System.exit(1);
            }
        }
    }
}
