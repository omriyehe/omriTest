package utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButill {
    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection != null)

            return connection;
        else {

            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                String urlCn ="jdbc:derby:C:/Users/omri/Desktop/omriTest/omriTest/my_db";
                connection= DriverManager.getConnection(urlCn,"root","root");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
