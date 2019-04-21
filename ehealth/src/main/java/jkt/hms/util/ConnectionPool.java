package jkt.hms.util;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.Properties;
//commented for maven
/*import oracle.jdbc.pool.OracleConnectionCacheManager;*/

import org.apache.log4j.Logger;
//commented for maven
/*import com.microsoft.sqlserver.jdbc.SQLServerDataSource;*/

public class ConnectionPool {
	//commented for maven
	/*

	static Logger logger = Logger.getLogger(ConnectionPool.class);
	 private final  static String CACHE_NAME = "MYCACHE";
	    private  static SQLServerDataSource ods = null;
	    
	        static {
	            //logger.info("Initialisation du OracleDataSource");
	            try {
	            	 ods = new SQLServerDataSource();
//	                ods.setURL("jdbc:oracle:thin:@200.200.200.5:1521:ccis01");
//	                ods.setUser("sms");
//	                ods.setPassword("sms");
	                ods.setURL("jdbc:oracle:thin:@192.168.203.64:1521:XE");
	                //ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
	                ods.setUser("dpnew");
	                ods.setPassword("dpnew");
	                // caching parms
	                //ods.setConnectionCachingEnabled(true); 
	                //ods.setConnectionCacheName(CACHE_NAME);
	                Properties cacheProps = new Properties();
	                cacheProps.setProperty("MinLimit", "3");
	                cacheProps.setProperty("MaxLimit", "6"); 
	                cacheProps.setProperty("InitialLimit", "10"); 
	                cacheProps.setProperty("ConnectionWaitTimeout", "5");
	                cacheProps.setProperty("ValidateConnection", "true");
	 
	                //ods.setConnectionCacheProperties(cacheProps);
	    
	            }
	            catch (Exception e) {
	            	logger.info("Exception :"+e.getMessage() );
	            }
	        }
	   
	    *//**
	     * private constructor for static class
	     *//*
	   private ConnectionPool() { }
	 
	    
	    public static Connection getConnectionFromOracle() 
	       throws SQLException 
	    {
	      if (ods == null) {
	          throw new SQLException("OracleDataSource is null.");   
	      }
	      return ods.getConnection();
	    }
	   
	    public static void closePooledConnections() throws SQLException{
	      if (ods != null ) {
	          //ods.close();
	      }
	    }
	   
	    public static void listCacheInfos() throws SQLException{
	      @SuppressWarnings("unused")
		OracleConnectionCacheManager occm =    OracleConnectionCacheManager.getConnectionCacheManagerInstance();
	 
	    }
*/}
