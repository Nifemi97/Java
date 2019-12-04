/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Objects.Songs;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import storage.LinkBasedQueue;

/**
 *
 * @author akinb
 */
public class SongList {

    /**
     *the project application where song objects can be created, deleted, added to a play lists and viewed
     * @param args
     * @throws FileNotFoundException 
     * @throws UnsupportedEncodingException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException {
        
        /*
        here a LinkedList is being used to store the songs
        a user is prompted to enter details that will be used to create a song object
        the scanner class is used to allow the user to enter information
        printwriter is used to allow the songs to be written to a file
        */
        Scanner s = new Scanner(System.in);
        PrintWriter writer = new PrintWriter("MusicLibrary.txt", "UTF-8");
        PrintWriter playlist = new PrintWriter("playlist.txt", "UTF-8");
        Scanner sc = new Scanner(new File("MusicLibrary.txt"));
        Date thedate = new Date();

        //an instance of a new song object
        Songs sg = new Songs();

        //LinkedList of type songs which holds the song objects
        LinkedList<Songs> sl = new LinkedList<Songs>();

        //adds all the songs to the LinkedList
        sl.add(new Songs("Sicko Mode", "Travis Scott", "R&B", "2018", 324324663, 20000, thedate));
        sl.add(new Songs("Mo bamba", "Asap Rocy", "R&B", "2018", 93249, 23434, thedate));
        sl.add(new Songs("Not Afraid", "Eminem", "R&B", "2018", 34542, 224352, thedate));
        sl.add(new Songs("Invnicible", "Tinie Tempah", "Pop", "2010", 121324, 414242, thedate));
        sl.add(new Songs("Leg Over", "Mr Eazi", "Wolrd", "2017", 17575752, 2483832, thedate));
        sl.add(new Songs("Congratulations", "Post Malone", "R&B", "2017", 1262622, 24727818, thedate));
        sl.add(new Songs("ButterflyEffect", "Travis Scott", "Hip Hop/Rap", "2018", 2727712, 2474747, thedate));
        sl.add(new Songs(" Collard Greens", "Schoolboy Q", "Hip Hop/Rap", "2014", 433812, 27277, thedate));
        sl.add(new Songs("Home", "Various Artists", "Mixed", "2017", 1938392, 2747474, thedate));

        System.out.println("Please select one of the following options:");

        String choice = "";
        do {
            System.out.println("0) Exit the application");
            System.out.println("1) Add a song to the library");
            System.out.println("2) Remove a song from the library");
            System.out.println("3) Display all songs");
            System.out.println("4) Search for a song");
            System.out.println("5) Play a song");
            System.out.println("6) Create a playlist");
            //System.out.println("7) Play a playlist");
            System.out.println("8) Edit a playlist");
          //  System.out.println("9) Delete a playlist");
            choice = s.next();

            /*
            here a list of all the songs are displayed using a for loop
            the songs are then written to the musiclibrary file using printwriter writer
            */
            if (choice.equalsIgnoreCase("1")) {
                int songId = 0;

                ArrayList<Songs> adding = new ArrayList<Songs>();
                System.out.println("Add a song to the library: ");
                System.out.println("Title: ");
                String title = s.next();
                System.out.println("Artist: ");
                String artist = s.next();
                System.out.println("Genre: ");
                String genre = s.next();
                System.out.println("Release Date: ");
                String release = s.next();
                System.out.println("Album Count");
                int album_count = s.nextInt();
                System.out.println("Play Count");
                int play_count = s.nextInt();
                System.out.println("Date Last Played");
                Date last_played = thedate;
                sl.add(new Songs(title, artist, genre, release, album_count, play_count, last_played));

                for (int i = 0; i < sl.size(); i++) {
                    songId++;
                    System.out.println("Song Id: " + songId + sl.get(i));

                    writer.println("Song Id: " + songId + " " + sl + "\n");
                }




            }
            /*
            the user is prompted to choose song they would eant to remove
            */
            //System.out.println("Removing---------");
            if (choice.equalsIgnoreCase("2")) {
                System.out.println("Remove a song");
                System.out.println("select a song to remove");
                int opt = s.nextInt();
                sl.remove(opt);
                writer.println(sl);

            }

            // System.out.println("Displaying all-------");
            if (choice.equalsIgnoreCase("3")) {
                int songId = 0;
                System.out.println("Display all songs");
                for (int i = 0; i < sl.size(); i++) {
                    songId++;
                    writer.println("Song Id: " + songId + " " + sl.get(i) + "\n");
                    System.out.println("Song Id:" + songId + " " + sl.get(i));
                }
                while (sc.hasNext()) {
                    System.out.println(sc.nextLine());
                }
            }

            // System.out.println("Searching for a song");
            if (choice.equalsIgnoreCase("4")) {
                
                System.out.println("Enter a song you want to find");
                String find = s.next();
                System.out.println("***********");
                for(int i=0; i<sl.size(); i++){
                    if(find.equals(sl.get(i).getTitle())){
                        
                        System.out.println("Song found");
                        System.out.println(sl.get(i));
                        
                        System.out.println(sl);
                    }
                    else{
                        System.out.println("Song not found");
                    }
                }
                
                    
                }
                
            //System.out.println("Play a song");
            if (choice.equalsIgnoreCase("5")) {
                System.out.println("Play a song");

                int songId = 0;
                boolean found = false;
                for (int i = 0; i < sl.size(); i++) {
                    songId++;
                    System.out.println("Current songs:" + songId + " " + sl.get(i).getTitle());
                }
                System.out.println("Select a song you want to play");
                String play = s.next();

                for (int i = 0; i < sl.size(); i++) {
                    songId++;
                    if(play.equalsIgnoreCase(sl.get(i).getTitle())){
                        System.out.println("Song is now playing");
                        System.out.println(sl.get(i));
                        System.out.println("*****************8");
                        System.out.println(sl);
                    }
                    else{
                        System.out.println("Song not found");
                    }
                }
                java.util.concurrent.TimeUnit.SECONDS.sleep(3);

            }
            //System.out.println("Create a playlist");
            if(choice.equalsIgnoreCase("6")){
                System.out.println("Create a playlist");
                LinkBasedQueue<Songs> linkQueue = new LinkBasedQueue();
                
              // linkQueue.enqueue(sl);
               
               for(int i=0; i<sl.size()-2; i++){
                   linkQueue.enqueue(sl.get(i));
               }
               int songId=0;
                
                while(!linkQueue.isEmpty()){
                    songId++;
                    System.out.println("Check playlist: " + "Song Id" + songId + linkQueue.dequeue());
                    
                }
                writer.println("Song Id: " + songId + " " + linkQueue + "\n");
                writer.println(linkQueue);
            }
            
            //System.out.println("Edit a playlist");
            if(choice.equalsIgnoreCase("7")){
                System.out.println("Remove a song from the playlist");
                int songId=0;
                LinkBasedQueue<String> linkQueue = new LinkBasedQueue();
                 for(int i=0; i<sl.size()-2; i++){
                   linkQueue.enqueue(sl.get(i).getTitle());
               }
                
                while(!linkQueue.isEmpty()){
                    songId++;
                    System.out.println("Check playlist: " + "Song Id" + songId + linkQueue.dequeue());
                    
                }
                System.out.println("select a song to remove");
                String opt = s.next();
                for(int i=0; i<linkQueue.size(); i++){
                    linkQueue.dequeue();
                }
                //linkQueue.dequeue(opt);
                
                //sl.remove(opt);
                writer.println(sl);
            }
            
            else if (choice.equalsIgnoreCase("0")) {
                System.out.println("Goodbye:)");
            }
        } while (!choice.equalsIgnoreCase("0"));

        writer.println(sl);

    }

}
