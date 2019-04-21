package sms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.smslib.smsserver.SMSServer;
@SuppressWarnings("unused")
public class SimpleConnection {
	private static Connection accessConnection1=null;
	private static Connection conn = null;
	private static Connection conn2 = null;
	static Logger logger = Logger.getLogger(SimpleConnection.class);
	public static  Connection getConnectionFromOracle() {
		
				if (conn == null) {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						//conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","dpsms","dpsms");
						//conn= DriverManager.getConnection("jdbc:oracle:thin:@200.200.200.5:1521:ccis01","anandnautyal","anand9654111625");
						conn= DriverManager.getConnection("jdbc:oracle:thin:@200.200.200.5:1521:ccis01","supervisor","supervisor");
					} catch (SQLException e) {
						logger.info("Data Base Connection Not Found :"+e.getMessage() );
					}
					catch (ClassNotFoundException e) {
						logger.info("ClassNotFoundException :"+e.getMessage() );
					}
					catch (Exception e) {
						logger.info("DatabaseException :"+e.getMessage() );
					}
				}
				return conn;
		
 }
	
	public static  Connection getConnectionFromOracle2() {
		
		if (conn2 == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","dpsms","dpsms");
				//conn= DriverManager.getConnection("jdbc:oracle:thin:@200.200.200.5:1521:ccis01","anandnautyal","anand9654111625");
				conn2= DriverManager.getConnection("jdbc:oracle:thin:@200.200.200.6:1521:ccis02","supervisor","supervisor");
			} catch (SQLException e) {
				logger.info("Data Base Connection Not Found :"+e.getMessage() );
			}
			catch (ClassNotFoundException e) {
				logger.info("ClassNotFoundException :"+e.getMessage() );
			}
			catch (Exception e) {
				logger.info("DatabaseException :"+e.getMessage() );
			}
		}
		return conn2;

  }
	
	
public synchronized static Connection getConnectionFromAccess() {
	Connection accessConnection=null;
		if (accessConnection == null) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				accessConnection = DriverManager.getConnection("jdbc:odbc:dpsms","","");
			} catch (SQLException e) {
				logger.info("Exception :"+e.getMessage() );
			} catch (ClassNotFoundException e) {
				logger.info("Exception :"+e.getMessage() );
			}
		}
		return accessConnection;

	}
public synchronized static Connection getConnectionFromAccessForPV() {
	Connection accessConnectionForPV=null;
	if (accessConnectionForPV == null) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			accessConnectionForPV = DriverManager.getConnection("jdbc:odbc:passport","","");
		} catch (SQLException e) {
			logger.info("Exception :"+e.getMessage() );
		} catch (ClassNotFoundException e) {
			logger.info("Exception :"+e.getMessage() );
		}
	}
	return accessConnectionForPV;

}
}
