/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Objects.Songs;

/**
 *
 * @author akinb
 */
public class LinkedList {
    private Node first = null;
    private int size = 0;
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public int size(){
        return size;
    }
    
    public Songs get(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException();
        }else{
            Node current = first;
            for(int i = 0; i < pos; i++){
                current = current.next;
            }
            return current.data;
        }
    }
    
    public void addFirst(Songs data){
        Node newNode = new Node(data);
        if(first == null){
            first = newNode;
        }else{
            newNode.next = first;
            first = newNode;
        }
        size++;
    }
    
    public void add(Songs data){
        if(isEmpty()){
            addFirst(data);
        }else{
            Node newNode = new Node(data);
            // Find the end of the list
            Node current = first;
            while(current.hasNext()){
                //current = current.getNext();
                current = current.next;
            }
            // Add/attach new node onto the last element
            //current.setNext(newNode);
            current.next = newNode;

            size++;
        }
    }
    
    public void add(Songs data, int pos){
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException();
        }else if(pos == 0){
            addFirst(data);
        } else if(pos == size){
            add(data);
        }else{
            Node newNode = new Node(data);
            Node current = first;
            for(int i = 0; i < pos-1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }
    
    public Songs removeFirst(){
        if(isEmpty()){
            return null;
        }
        else {
            Node current = first; 
            first = first.next;
            size--;
            return current.data;
        }
    }
    
    public Songs removeLast(){
        Node current = first;
        for(int i = 0; i < size-1; i++){
            current = current.next;
        }
        Node temp = current.next;
        current.next = null;
        size--;
        return temp.data;
    }
    
    public Songs remove(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException();
        }else if(pos ==0){
            return removeFirst();
        }else if(pos == size-1){
            return removeLast();
        }else{
            Node current = first;
            for(int i = 0; i< pos-1; i++){
                current = current.next;
            }
            
            Node temp = current.next;
            current.next = temp.next;
            size--;
            return temp.data;
        }
    }
    
//    public Songs remove(String input){
//        Songs sg = new Songs();
//        if(input.equalsIgnoreCase(sg.getTitle())){
//            return removeFirst();
//        }else if((!input.equalsIgnoreCase(sg.getTitle()))){
//            rem
//        }
//    }
    
    private static class Node{
        private Songs data;
        //private int date2;
        private Node next;
        
        public Node(Songs sl){
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

