package cc.doing.as.dao;

import cc.doing.as.ds.ActivityDS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ActivityDAO {
    public void insertActivity(Activity activity){
        try(Connection con = ActivityDS.getDataSource().getConnection()){
            if(con != null){
                try(PreparedStatement insertPS = con.prepareStatement(
                        "INSERT INTO " +
                                "activities  (agent_id, duration, time_stamp, url, window_title, p_name) " +
                                "VALUES (?, ?, ?, ?, ?, ?)"
                )){
                    insertPS.setString(1,activity.getAgentId());
                    insertPS.setInt(2,activity.getDuration());
                    insertPS.setTimestamp(3, new Timestamp(activity.getDateTime().getTime()));
                    insertPS.setString(4,activity.getUrl());
                    insertPS.setString(5, activity.getWindowText());
                    insertPS.setString(6,activity.getpName());
                    int rowsAffected = insertPS.executeUpdate();
                    System.out.println(rowsAffected + " rows affected.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActivity(Activity activity){

    }
}
