package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePlaylist {

    public static void songsPlaylist(String playlistName,int userId,String songid,String podcastid )  {
        Connection connection=GetConnection.connectTo();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("insert into playlist(playlistName,userId,songid,podcastId)  values('" + playlistName + "'," + userId + "," + songid + "," + podcastid+");");
        }catch (SQLException e){
            System.out.println(e);
        }

    }
}
