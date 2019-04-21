package jkt.hms.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import jkt.hms.adt.controller.RegistrationController;
import jkt.hms.login.handler.LoginHandlerService;
import jkt.hms.util.DBUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SessionListener implements HttpSessionListener,ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	
	static final Logger LOGGER = Logger.getLogger(SessionListener.class);
	
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         this.applicationContext = applicationContext;
    }
    
	  @Override
	  public void sessionCreated(HttpSessionEvent arg0) {
	  }
	  
	  @Override
	  public void sessionDestroyed(HttpSessionEvent arg0) {
		  DBUtils dbUtils = (DBUtils)applicationContext.getBean("dbutils");
		HttpSession session =   arg0.getSession();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		int userId=0;
		String sqlQuery = null;
		
		if(session.getAttribute("userId")!=null){
			userId =(Integer) session.getAttribute("userId");
		}
		
		map.put("userId", userId);
		try {
			connection = dbUtils.getConnection();
			sqlQuery = "update mas_service_centre_counter set status = 'y' where service_centre_counter_id = (select current_counter_id from users where user_id = ?)";
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			sqlQuery = "update users set current_counter_id =null, login_status ='n' where user_id = ?";
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		/*	sqlQuery = "update mas_employee set visit_time_upto = null where  employee_id = (select employee_id from users where user_id = ?)";
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();*/
			LOGGER.info("Session Closed !!!");
		}catch (Exception e) {
			LOGGER.error("Error in SessionListener", e);
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException se) {
				LOGGER.error("Error in SessionListener on closing prepared statement", se);
			}
			DBUtils.closeConnection(connection);
		}
	  }


}
;