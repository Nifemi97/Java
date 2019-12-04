/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import core.ComboServiceDetails;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ComboStreamClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            // Step 1 (on consumer side) - Establish channel of communication
           Socket dataSocket = new Socket("localhost", ComboServiceDetails.LISTENING_PORT); 
           
           // Step 3) Build output and input objects
            OutputStream out = dataSocket.getOutputStream();
            PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

            InputStream in = dataSocket.getInputStream();
            Scanner input = new Scanner(new InputStreamReader(in));
           
            Scanner keyboard = new Scanner(System.in);
            String message = "";
            while(!message.equals(ComboServiceDetails.END_SESSION))
            {
                displayMenu();
                int choice = getNumber(keyboard);
                String response = "";
                if(choice >=0 && choice < 3)
                {
                    switch (choice)
                    {
                        case 0:
                            message = ComboServiceDetails.END_SESSION;
                            
                            // Send message
                            output.println(message);
                            output.flush();
                            
                            response = input.nextLine();
                            if(response.equals(ComboServiceDetails.SESSION_TERMINATED))
                            {
                                System.out.println("Session ended.");
                            }
                            
                            break;
                        case 1:
                            message = generateEcho(keyboard);

                            // Send message
                            output.println(message);
                            output.flush();
                            
                            // Get response
                            response = input.nextLine();
                            
                            System.out.println("Received response: \"" + response + "\".");
                            break;
                        case 2:
                            message = ComboServiceDetails.DAYTIME;
                            
                            // Send message
                            output.println(message);
                            output.flush();
                            
                            // Get response
                            response = input.nextLine();
                            System.out.println("The current date and time is: " + response);
                            break;
                    }
                    if(response.equals(ComboServiceDetails.UNRECOGNISED))
                    {
                        System.out.println("Sorry, that request cannot be recognised.");
                    }
                }
                else
                {
                    System.out.println("Please select an option from the menu");
                }
            }
            System.out.println("Thank you for using the (Stream-based) Combo system.");
            dataSocket.close();
        }catch(Exception e)
        {
            System.out.println("An error occurred: "  + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void displayMenu()
    {
        System.out.println("0) Exit");
        System.out.println("1) Echo a message");
        System.out.println("2) Get the current day and time");
    }
    
    // A method to retrieve a number from the user at all times
    // This method deals with repeatedly requesting a number from the user
    // until they enter numeric data instead of text.
    public static int getNumber(Scanner keyboard)
    {
        boolean numberEntered = false;
        int number = 0;
        while(!numberEntered)
        {
            try{
                number = keyboard.nextInt();
                numberEntered = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a number.");
                keyboard.nextLine();
            }
        }
        keyboard.nextLine();
        return number;
    }
    
    
    // Methods to provide command functionality on client side
    
    public static String generateEcho(Scanner keyboard)
    {
        // Set up command text
        StringBuffer message = new StringBuffer(ComboServiceDetails.ECHO);
        message.append(ComboServiceDetails.COMMAND_SEPARATOR);
        // Get message to be echoed
        System.out.println("Please enter the message to be echoed: ");
        String echo = keyboard.nextLine();
        // Add new text to end of command string
        message.append(echo);
        
        // Return final message
        return message.toString();
    }
}
