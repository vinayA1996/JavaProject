package browser;

import Beams.Podcast;
import Beams.Song;
import controller.CreatePlaylist;
import model.UserDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
    public static void mainMenu(int userid) {
        String playlistName="";
        int select;
        String finalsongs = "";
        String finalpodcast = "";


        DisplayUtilities display=new DisplayUtilities();

        System.out.println("---------------------------");
        System.out.println("\t\tMain menu");
        System.out.println("---------------------------");

        int selection;
        Scanner sc = new Scanner(System.in);
        ArrayList<Song>songslist=UserDetails.songs();

        String Input="";
        System.out.print("1\t****  View All Songs And Play  ****\n2\t****  Search Song By Name     " +
                " ****\n3\t****  Search Songs By Genre   ****\n4\t****  Search Songs By Artist" +
                "  ****\n5\t****  View Podcast            ****\n6\t****  Create Playlist        " +
                " ****\n7\t****  View Playlist          ****\n");
        System.out.println("Enter Option");
        selection = sc.nextInt();
        switch (selection) {
            case 1:{
                display.displaySongs(songslist);
                Menu.playSong(songslist);
            }break;
            case 2:{
                //Search by Song Name
                display.displaySongs(songslist);
                System.out.println("Enter Song Name To Search");
                Input= sc.next();

                ArrayList<Song> searchSongs= UserDetails.Searchsong(Input);

                display.displaySongs(searchSongs);

                Menu.playSong(searchSongs);
            }break;
            case 3:{
                //Search by genre
                display.displaySongs(songslist);
                System.out.println("Enter Genre of Song to Search");
                Input= sc.nextLine();
                Input= sc.nextLine();
                ArrayList<Song>searchSongs= UserDetails.SearchByGenre(Input);
                display.displaySongs(searchSongs);
                Menu.playSong(searchSongs);
            }break;
            case 4:{
                //Search by Artist
                display.displaySongs(songslist);
                System.out.println("Enter Artist of Song to Search");
                Input= sc.nextLine();
                Input= sc.nextLine();
                ArrayList<Song>searchSongs= UserDetails.SearchByArtist(Input);
                display.displaySongs(searchSongs);
                Menu.playSong(searchSongs);
            }break;
            case 5:{
                //View Podcast
                ArrayList<Podcast>podcastslist=UserDetails.podcasts();
                display.displaySPodcast(podcastslist);
                Menu.playPodcast(podcastslist);
            }break;
            case 6:{
                System.out.println("1\tEnter 1 to add song in playlist\n2\t Enter 2 to add to podcast\n");
                select= sc.nextInt();
                switch (select){
                    case 1:{
                        display.displaySongs(songslist);
                        int songId;
                        System.out.println("Enter Playlist Names :");
                        playlistName=sc.nextLine();
                        playlistName=sc.nextLine();
                        do {
                            System.out.println("enter songId or press 0 to exit" );
                            songId=sc.nextInt();//2
                            String songsId = String.valueOf(songId);
                            finalsongs = finalsongs.concat(",").concat(songsId);
                            System.out.println(finalsongs);
                        } while(songId>0);
                    }
                    case 2:{
                        ArrayList<Podcast> list =UserDetails.podcasts();
                        display.displaySPodcast(list);
                        int songId;
                        System.out.println("Enter Podcast playlist Names :");
                        playlistName=sc.nextLine();
                        playlistName=sc.nextLine();
                        do {
                            System.out.println("enter Id of podcast");
                            songId=sc.nextInt();
                            String songsId = String.valueOf(songId);
                            System.out.println(songsId);
                            finalpodcast = finalsongs.concat(",").concat(songsId);
                            System.out.println(finalsongs);
                        } while(songId>0);
                    }
                }
                System.out.println(playlistName);
                CreatePlaylist.songsPlaylist(playlistName,userid,finalsongs,finalpodcast);
            }break;
            case 7:{
            DisplayUtilities.viewPlaylist();
            }

        }

    }
   public static void playSong(ArrayList<Song>Music){

       Scanner sc=new Scanner(System.in);

       System.out.println("1.Play all songs!!\n2.Select song\n3.Main menu ");
       int opt = sc.nextInt();
       int songId=0;
       switch (opt) {

           case 1 -> PlayMusic.playList(Music);
           case 2 -> {
               System.out.println("Enter song id");
               songId=sc.nextInt();
               PlayMusic.playSong(Music,songId);
           }
           case 3 -> Menu.mainMenu(0);

       }
   }
    public static void playPodcast(ArrayList<Podcast>Music){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Play all podcast!!\n2.Select song\n3.Main menu ");
        int opt = sc.nextInt();
        int id=0;
        switch (opt) {

            case 1: PlayMusic.playPodcast(Music);
            break;
            case 2 :
                System.out.println("Enter id");
                id=sc.nextInt();
               PlayMusic.playPodcast(Music);
            break;
            case 3 : Menu.mainMenu(0);
            break;
        }
    }
}