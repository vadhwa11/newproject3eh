package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the users table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="users"
 */

public abstract class BaseUsersLog  implements Serializable {

	public static String REF = "UsersLog";
	public static String PROP_USER = "User";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOST_URL = "HostUrl";
	public static String PROP_ID = "Id";
	public static String PROP_USER_NAME = "UserName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseUsersLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsersLog (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUsersLog (
		java.lang.Integer id,
		java.lang.String userName,
		java.lang.String status,
		java.lang.String hostUrl) {

		this.setId(id);
		this.setUserName(userName);
		this.setStatus(status);
		this.setHostUrl(hostUrl);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userName;
	private java.lang.String status;
	private java.lang.String hostUrl;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Users user;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="users_log_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: user_name
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: user_name
	 * @param userName the user_name value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: host_url
	 */
	public java.lang.String getHostUrl () {
		return hostUrl;
	}

	/**
	 * Set the value related to the column: host_url
	 * @param hostUrl the host_url value
	 */
	public void setHostUrl (java.lang.String hostUrl) {
		this.hostUrl = hostUrl;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public jkt.hms.masters.business.Users getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (jkt.hms.masters.business.Users user) {
		this.user = user;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.UsersLog)) return false;
		else {
			jkt.hms.masters.business.UsersLog usersLog = (jkt.hms.masters.business.UsersLog) obj;
			if (null == this.getId() || null == usersLog.getId()) return false;
			else return (this.getId().equals(usersLog.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}