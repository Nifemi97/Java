/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapFullException;

/**
 *
 * @author akinb
 */
public class MapFullException extends RuntimeException{

    /**
     *
     */
    public MapFullException(){
    }

    /**
     *
     * @param message
     * Handles exceptions caused when using maps
     */
    public MapFullException(String message){
        super(message);
    }
}
