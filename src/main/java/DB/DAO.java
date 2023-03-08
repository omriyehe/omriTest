package DB;

import model.Event;
import model.User;
import utill.DButill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection connection;

    public DAO() {
        connection = DButill.getConnection();
    }


    public boolean checkUser(String user,String pass) {

        try {

            PreparedStatement pStatement;
            pStatement = connection.prepareStatement
                    ("SELECT * FROM APP.A_USER WHERE A_USER=? AND PASSWORD=?");
            pStatement.setString(1, user);
            pStatement.setString(2, pass);

            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                pStatement.close();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public User getUserFromUser(String user, String pass) {

        try {

            PreparedStatement pStatement;
            pStatement = connection.prepareStatement
                    ("SELECT * FROM APP.A_USER WHERE A_USER=? AND PASSWORD=?");
            pStatement.setString(1, user);
            pStatement.setString(2, pass);

            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUser(rs.getString("A_USER"));
                u.setPassword(rs.getString("PASSWORD"));

                pStatement.close();
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public  boolean cheackIfHourExist(int day,int hour,String user) {
        try {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement
                    ("SELECT * FROM APP.EVENT WHERE B_USER=? AND DAY=? AND TIME=?");
            pStatement.setString(1, user);
            pStatement.setInt(2, day);
            pStatement.setInt(3, hour);

            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                return true;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





    public  void add_event
            (String user, String desc, String type, int day, int hour) {

        try {

            PreparedStatement pStatement;

            pStatement = connection.prepareStatement("insert into APP.EVENT values (?,?,?,?,?)");

            pStatement.setString(1, desc);

            pStatement.setInt(2, day);

            pStatement.setInt(3, hour);

            pStatement.setString(4, type);

            pStatement.setString(5, user);

            pStatement.executeUpdate();
            pStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public List<Event> getEventListByeDay(int day) {

        try {

            PreparedStatement pStatement;

            pStatement = connection.prepareStatement("select * from APP.EVENT WHERE DAY=?");
            pStatement.setInt(1, day);
            ResultSet rs = pStatement.executeQuery();

            List<Event> list_of_event = new ArrayList<Event>();

            while (rs.next()) {
                Event e = new Event();
                e.setDescription(rs.getString("DESRIPTION"));
                e.setDay(rs.getInt("DAY"));
                e.setHour(rs.getInt("TIME"));
                e.setType(rs.getString("TYPE"));
                e.setUser(rs.getString("B_USER"));
                list_of_event.add(e);
            }
            pStatement.close();
            return list_of_event;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Event> getEventListByeHour(int hour) {

        try {

            PreparedStatement pStatement;

            pStatement = connection.prepareStatement("select * from APP.EVENT WHERE TIME=?");
            pStatement.setInt(1, hour);
            ResultSet rs = pStatement.executeQuery();

            List<Event> list_of_event = new ArrayList<Event>();

            while (rs.next()) {
                Event e = new Event();
                e.setDescription(rs.getString("DESRIPTION"));
                e.setDay(rs.getInt("DAY"));
                e.setHour(rs.getInt("TIME"));
                e.setType(rs.getString("TYPE"));
                e.setUser(rs.getString("B_USER"));
                list_of_event.add(e);
            }
            pStatement.close();
            return list_of_event;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Event> getEventListByeHourAndDay(int hour,int day) {

        try {

            PreparedStatement pStatement;

            pStatement = connection.prepareStatement
                    ("select * from APP.EVENT WHERE TIME=? AND DAY=?");
            pStatement.setInt(1, hour);
            pStatement.setInt(2, day);

            ResultSet rs = pStatement.executeQuery();

            List<Event> list_of_event = new ArrayList<Event>();

            while (rs.next()) {
                Event e = new Event();
                e.setDescription(rs.getString("DESRIPTION"));
                e.setDay(rs.getInt("DAY"));
                e.setHour(rs.getInt("TIME"));
                e.setType(rs.getString("TYPE"));
                e.setUser(rs.getString("B_USER"));
                list_of_event.add(e);
            }
            pStatement.close();
            return list_of_event;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public Event getEventFromHourAndDay(int day,int hour) {

        try {

            PreparedStatement pStatement;
            pStatement = connection.prepareStatement
                    ("SELECT * FROM APP.EVENT WHERE DAY=? AND TIME=?");
            pStatement.setInt(1, day);
            pStatement.setInt(2, hour);

            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                Event e = new Event();
                e.setDescription(rs.getString("DESRIPTION"));
                e.setDay(rs.getInt("DAY"));
                e.setHour(rs.getInt("TIME"));
                e.setType(rs.getString("TYPE"));
                e.setUser(rs.getString("B_USER"));
                pStatement.close();
                return e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public  void editEvent
        (int hour_to_edit,int day_to_edit,
         int day,int hour,String desc,String type ,String user) {

        try {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement
                    ("UPDATE APP.EVENT SET DESRIPTION =?, DAY=? ,TIME=?,TYPE=?,B_USER=?WHERE DAY=? AND TIME=?");
            pStatement.setString(1,desc);
            pStatement.setInt(2,day);
            pStatement.setInt(3,hour);
            pStatement.setString(4,type);
            pStatement.setString(5,user);
            pStatement.setInt(6,day_to_edit);
            pStatement.setInt(7,hour_to_edit);

            pStatement.executeUpdate();

            pStatement = connection.prepareStatement("DELETE FROM APP.EVENT WHERE DAY=? AND TIME=?");

            pStatement.setInt(1,day);
            pStatement.setInt(2,hour);
            pStatement.executeUpdate();




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public  void removeEvent
            (int hour_to_edit,int day_to_edit) {

        try {
            PreparedStatement pStatement;


            pStatement = connection.prepareStatement("DELETE FROM APP.EVENT WHERE DAY=? AND TIME=?");

            pStatement.setInt(1,hour_to_edit);
            pStatement.setInt(2,day_to_edit);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
