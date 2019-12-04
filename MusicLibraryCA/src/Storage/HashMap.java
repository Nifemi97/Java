/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

/**
 *
 * @author akinb
 */
public class HashMap<K, V> {
    // Create a variable to track how many K-V pairs are in the hash map
    private int size;
    // Declare an array of Entry objects to store key-value pairs
    // Generic type, so anything can be a Key and anything can be a Value
    private Entry<K, V> [] data;
    
    public HashMap(){
        // Create the array as an array of Entry objects 
        // (as they'll always be Entry objects, we need to make them Entry, not Object)
        data = (Entry<K, V> []) new Entry[100];
        // Set count of pairings to 0
        size = 0;
    }
    
    public V put(K key, V value){
        // Get the hash value of the key and make sure it's > 0
        int hash = Math.abs(key.hashCode());
        // Calculate a slot within the size of the array
        int destinationIndex = hash % data.length;
        // Check if there's something already there
        if(data[destinationIndex] == null){
            // If it's empty, create the new Entry 
            Entry<K, V> newEntry = new Entry(key, value);
            // Save it in the destination slot
            data[destinationIndex] = newEntry;
            // Increase the number of mappings/pairings
            size++;
            // Return nothing as nothing was overwritten
            return null;
        }
        else{
            // If we found a value here already, save the old value
            V oldValue = data[destinationIndex].getValue();
            // Set the value in this entry to be the new (incoming) value
            data[destinationIndex].setValue(value);
            // Return the old value that has been overwritten
            return oldValue;
        }
    }
    
    public V get(K key){
        // We need to figure out which slot to check, so we need to do the same
        // steps as we carried out to insert an element to begin with
        // Calculate the hash of the key 
        int hash = Math.abs(key.hashCode());
        // Mod the hash so we can find a valid position
        int destinationIndex = hash % data.length;
        // Check if there's anything in this slot
        if(data[destinationIndex] != null){
            // if so, return the value in this slot
            return data[destinationIndex].getValue();
        }
        // If we didn't find it in that slot, return nothing
        return null;
    }
    
    public int size(){
        // Return the count of how many mappings have been added to the map
        return size;
    }
    
    private static class Entry<K, V>{
        private final K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
        
        public void setValue(V newValue){
            this.value = newValue;
        }
    }
}
