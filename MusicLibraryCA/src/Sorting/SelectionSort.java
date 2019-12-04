/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import Objects.Songs;
import static java.util.Collections.swap;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author akinb
 * selection sorting algorithm used to sort list of objects
 */
public class SelectionSort {
      public static void sort(LinkedList sl, Comparator<Songs> cs ) 
    { 
        int n = sl.size();
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
//            for (int j = i+1; j < n; j++) {
//                if(cs(sl.get(min_idx),sl.get(j) > 1)){
//                    min_idx = j;
//                }
//            }
//            
//            swap(sl, min_idx, i);
//                    
  
            // Swap the found minimum element with the first 
            // element 
            
        } 
        
//        public static void swap(LinkedList sl, int pls, int wr){
//            Songs temp = sl.get(pls);
//            sl[pls] = array[wr]; 
//            arr[i] = temp; 
//            }
    }
}
