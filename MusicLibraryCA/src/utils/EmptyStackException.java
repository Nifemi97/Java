/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author akinb
 * this file, similar to the map and queue exception files, handles any exception relating to Stacks
 */
public class EmptyStackException extends RuntimeException {
    public EmptyStackException(String message){
        super(message);
    }

    public EmptyStackException()
    {
    }
}
