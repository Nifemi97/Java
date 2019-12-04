/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueExceptions;

/**
 *
 * @author akinb
 * handles queue exceptions
 */
public class QueueFullException extends RuntimeException {
    public QueueFullException(String message){
        super(message);
    }

    public QueueFullException()
    {
    }
}

