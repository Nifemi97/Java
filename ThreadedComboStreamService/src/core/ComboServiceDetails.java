/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author grahamm
 */
public class ComboServiceDetails 
{
    // Create variables to hold information on how this protocol operates
    
    // By providing the information in variables, you can change it easily
    // and by providing the variables in a utility class such as this,
    // you can ensure both client and server use the SAME values
    
    public static final int LISTENING_PORT = 773;
    
    // Breaking characters
    public static final String COMMAND_SEPARATOR = "%%";
    
    // Command strings
    public static final String END_SESSION = "QUIT";
    public static final String ECHO = "ECHO";
    public static final String DAYTIME = "DAYTIME";
    
    // Response strings
    public static final String UNRECOGNISED = "UNKNOWN_COMMAND";
    public static final String SESSION_TERMINATED = "GOODBYE";
}
