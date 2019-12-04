/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import java.util.Comparator;
import Objects.Songs;

/**
 *
 * @author akinb
 * this is a comparator class, this comparator is used to sort songs by artists in descending order
 */
public class ArtistComparatorDes implements Comparator<Songs>{
    
    @Override
    public int compare(Songs song1, Songs song2){
        return song2.getArtist().compareTo(song1.getArtist());
    }
}
