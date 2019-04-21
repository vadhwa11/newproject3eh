package jkt.hms.util;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {

    private static final Logger LOG = Logger.getLogger(DBUtils.class);

    private static DataSource dataSource;

    public static Connection getConnection(){
       // WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        //DataSource dataSource = (DataSource) context.getBean("dataSource");

        Connection connection = null;
        try {
           connection  = dataSource.getConnection();
        }
        catch (SQLException e) {
            LOG.error("Unable to get connection : " + e.getMessage());
        }

        return connection;
    }

    public static void closeConnection(Connection connection){
        if(connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                LOG.error("Unable to close connection : " + e.getMessage());
            }
        }

    }

    public void setDataSource(final DataSource ds) {
        dataSource = ds;
    }

}
