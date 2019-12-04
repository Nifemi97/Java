/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Date;

/**
 *
 * @author nifemi
 */
public class Songs implements Comparable<Songs>{
    
    
    private String title;
    private String artist;
    private String genre;
    private String release;
    private int album_count;
    private int play_count;
    private Date last_played;
    
    /**
     *The song class where objects can be created from
     * 
     */
    public Songs(){
    }
    
    /**
     *
     * @param t
     * @param a
     * @param g
     * @param r
     * @param ac
     * @param pc
     * @param lp
     * 
     * 
     * Here all the variables needed to create a song object is passed through parameter
     */
    public Songs(String t, String a, String g, String r, int ac, int pc, Date lp){
        
       // play_count = play_count++;
        title = t;
        artist = a;
        genre = g;
        release= r;
        album_count = ac;
        play_count = pc;
        last_played = lp;
        
    }

    /**
     *the getter methods for each variable
     * @return each getter method returns the information contained in each variable by using the .get to call on the methods
     */
    public String getTitle(){
        return title;
    }
    
    /**
     *similar to the getters, the setters can be used to assign information to each of the variables by using the .set call
     * @param title
     */
    public void setTitle( String title){
        this.title = title;
    }
    
    /**
     *
     * @return
     */
    public String getArtist(){
        return artist;
    }
    
    /**
     *
     * @param artist
     */
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    /**
     *
     * @return
     */
    public String getGenre(){
        return genre;
    }
    
    /**
     *
     * @param genre
     */
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    /**
     *
     * @return
     */
    public String getRelease(){
        return release;
    }
    
    /**
     *
     * @param release
     */
    public void setRelease(String release){
        this.release = release;
    }
    
    /**
     *
     * @return
     */
    public int getAlbumCount(){
        return album_count;
    }
    
    /**
     *
     * @param album_count
     */
    public void setAlbumCount(int album_count){
        this.album_count = album_count;
    }
    
    /**
     *
     * @return
     */
    public int getPlayCount(){
        return play_count;
    }
    
    /**
     *
     * @param play_count
     */
    public void setPlayCount(int play_count){
        this.play_count = play_count;
    }
    
    /**
     *
     * @return
     */
    public Date getLastPlayed(){
        return last_played;
    }
    
    /**
     *
     * @param last_played
     */
    public void setLastPlayed(Date last_played){
        this.last_played = last_played;
    }
    
    /*
    *the toString returns the object in the specified order
    *
    */
    
    @Override
    public String toString(){
        return "Title:" + title + " " + "Artist: " + artist + " " + "Genre: " + genre + " " + "Release Date: " + release + " " +  "Track Record: " + album_count + " " + "Play Count: " + play_count + " " + "Last Played Date: " + last_played;
    }
    
    /*
    *the equals is used to compare objects to each other, similar to the compareTo and comparabele
    */
    
    @Override
    public boolean equals(Object obj){
        Songs sg = (Songs) obj;
        
        if(this.title == sg.title){
            return true;
        }
        else 
            return false;
    }


    
    @Override
    public int compareTo(Songs compareSong){
        String compareTitle = ((Songs) compareSong).getTitle();
        if(compareTitle.equalsIgnoreCase(compareSong.getTitle())){
            String compareArtist = ((Songs) compareSong).getArtist();
            return -1;
            
        }
        return -1;
    }
    
    
}

