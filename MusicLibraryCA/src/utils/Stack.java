/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author akinb
 */
public class Stack {
    // Reference to the first node in the stack
    // (We need to know where the stack starts)
    private Node first;
    
    // How many elements are in the stack
    // Increase this when an element is pushed onto the stack.
    // Decrease this when an element is popped off the stack.
    private int size;
    
    // When a stack is started/created, the first slot is empty
    public Stack()
    {
        first = null;
    }
    
    // Method to check if the stack contains anything
    // if the first element is null, the stack is empty
    public boolean isEmpty(){
        return first == null;
    }
    
    // Method to get the number of elements in the stack
    public int size(){
        return size;
    }
    
    // Method to add an element to the top of the stack
    // Because stacks are only ever added to at the top, this is the only 
    // method we need that adds an element
    public void push(int data){
        // Build a node to hold our new data
        Node newNode = new Node(data);
        // If there's nothing in the list, 
        // set the first node to be this one
        if(first == null){
            first = newNode;
        }else{
            // Otherwise, insert our new node in front of the current first one
            // set our new node to point to the original first element
            newNode.next = first;
            // Set the stack's first element to be our new node
            first = newNode;
        }
        // increase the number of elements in the stack by one
        size++;
    }
    
    // Method to remove the first element from the top of the stack
    public int pop(){
        // If there is nothing in the stack at the moment, throw an exception
        if(isEmpty()){
            // This is a custom exception, it extends the RuntimeException class
            throw new EmptyStackException();
        }else{
            // If there are elements in the stack, save the first one in a temp variable
            Node current = first;
            // Remove the first element from the stack
            // Chop the first element off by pointing the first variable to the second one down
            first = first.next;
            // Decrease the size of the stack by one
            size--;
            // Return the data that *was* stored at the top of the stack
            return current.data;
        }
    }
    
    // Method to access (NOT remove) the first element in the stack
    public int peek(){
        // If the stack is empty, throw an exception
        if(isEmpty()){
            // Again, this is a custom exception
            throw new EmptyStackException();
        }else{
            // If there are elements in the stack, return the data in the first node
            return first.data;
        }
    }
    
    private static class Node {
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }

        public boolean hasNext(){
            return next != null;
        }

        public Node getNext(){
            return next;
        }
    }
}

