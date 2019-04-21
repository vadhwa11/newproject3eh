package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the users_login_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="users_login_details"
 */

public abstract class BaseUsersLoginDetails  implements Serializable {

	public static String REF = "UsersLoginDetails";
	public static String PROP_USER = "User";
	public static String PROP_LAST_UNSUCCESSFUL_LOGIN_TIME = "LastUnsuccessfulLoginTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_UNSUCCESSFUL_LOGIN_DATE = "LastUnsuccessfulLoginDate";
	public static String PROP_FROM_IP = "FromIp";


	// constructors
	public BaseUsersLoginDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsersLoginDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fromIp;
	private java.util.Date lastUnsuccessfulLoginDate;
	private java.lang.String lastUnsuccessfulLoginTime;

	// many to one
	private jkt.hms.masters.business.Users user;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="login_details_id"
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
	 * Return the value associated with the column: from_ip
	 */
	public java.lang.String getFromIp () {
		return fromIp;
	}

	/**
	 * Set the value related to the column: from_ip
	 * @param fromIp the from_ip value
	 */
	public void setFromIp (java.lang.String fromIp) {
		this.fromIp = fromIp;
	}



	/**
	 * Return the value associated with the column: last_unsuccessful_login_date
	 */
	public java.util.Date getLastUnsuccessfulLoginDate () {
		return lastUnsuccessfulLoginDate;
	}

	/**
	 * Set the value related to the column: last_unsuccessful_login_date
	 * @param lastUnsuccessfulLoginDate the last_unsuccessful_login_date value
	 */
	public void setLastUnsuccessfulLoginDate (java.util.Date lastUnsuccessfulLoginDate) {
		this.lastUnsuccessfulLoginDate = lastUnsuccessfulLoginDate;
	}



	/**
	 * Return the value associated with the column: last_unsuccessful_login_time
	 */
	public java.lang.String getLastUnsuccessfulLoginTime () {
		return lastUnsuccessfulLoginTime;
	}

	/**
	 * Set the value related to the column: last_unsuccessful_login_time
	 * @param lastUnsuccessfulLoginTime the last_unsuccessful_login_time value
	 */
	public void setLastUnsuccessfulLoginTime (java.lang.String lastUnsuccessfulLoginTime) {
		this.lastUnsuccessfulLoginTime = lastUnsuccessfulLoginTime;
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
		if (!(obj instanceof jkt.hms.masters.business.UsersLoginDetails)) return false;
		else {
			jkt.hms.masters.business.UsersLoginDetails usersLoginDetails = (jkt.hms.masters.business.UsersLoginDetails) obj;
			if (null == this.getId() || null == usersLoginDetails.getId()) return false;
			else return (this.getId().equals(usersLoginDetails.getId()));
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