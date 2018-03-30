package by.chekh.hotelminsk.connectionpool;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by dima on 11/16/2017.
 */
public enum ConnectionPool {
    INSTANCE;

    private DataSource dataSource;

    {
        InitialContext initContext= null;
        try {
            initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/hotelmanagerbd");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() throws SQLException {
        Connection  connection = dataSource.getConnection();
        return connection;
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
