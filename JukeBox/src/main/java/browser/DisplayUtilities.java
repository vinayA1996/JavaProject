package browser;

import Beams.Podcast;
import Beams.Song;
import controller.GetConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class DisplayUtilities {
    public void displaySongs(ArrayList<Song> Songs){
        Iterator<Song> i=Songs.iterator();

        Song song;

        System.out.println("________________________________-----------------------------------------------------_______________________");
        System.out.printf("| %-10s | %-30s | %-25s | %-15s |  %-15s  | %-10s |%n","Song Id","Song Name","Artist","Genre","album","duration");
        System.out.println("________________________________----------------------------------------------------____________________________");

        while (i.hasNext()){
            song=i.next();
            System.out.printf("| %-10s | %-30s | %-25s | %-15s |  %-15s  | %-10s |%n",song.getSongId(),song.getSongName(),song.getArtistName(),song.getGenre(),song.getAlbum(),song.getDuration());

        }
    }
    public void displaySPodcast(ArrayList<Podcast> Podcast){
        Iterator<Podcast> i=Podcast.iterator();
        Podcast podcasts;
        System.out.println("_________________________________________________--------------------------------------------------------________________________________________");
        System.out.printf("| %-10s | %-30s | %-25s | %-15s |  %-39s  | %-18s | %-10s |%n","id","Podcast Id","Podcast Name","Episode Id","Episode Name","Episode No","duration");
        System.out.println("_________________________________________________--------------------------------------------------------________________________________________");
        while (i.hasNext()){
            podcasts=i.next();
            System.out.printf("| %-10s | %-30s | %-25s | %-15s |  %-40s  |  %-15s  | %-10s |%n",podcasts.getId(),podcasts.getPodcastId(),podcasts.getPodcastName(),podcasts.getEpisodeId(),podcasts.getEpisodeName(),podcasts.getEpisodeNo(),podcasts.getDuration(),podcasts.getUrl());

        }
    }
    public static void  viewPlaylist() {
        try {
            Connection connection = GetConnection.connectTo();
            Statement st = connection.createStatement();
            ResultSet rs=st.executeQuery("select * from playlist");
            System.out.printf("| %-10s | %-30s | %-25s | %-15s |  %-39s  |%n","playlistId","playlistName","userId","songid","podcastId");
            while (rs.next()){
                System.out.printf("| %-10s | %-30s | %-25s | %-15s |  %-39s  |%n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
