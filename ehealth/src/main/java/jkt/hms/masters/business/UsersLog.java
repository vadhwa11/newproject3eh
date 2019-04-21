package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseUsersLog;



public class UsersLog extends BaseUsersLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UsersLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UsersLog (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UsersLog (
		java.lang.Integer id,
		java.lang.String userName,
		java.lang.String status,
		java.lang.String hostUrl) {

		super (
			id,
			userName,
			status,
			hostUrl);
	}

/*[CONSTRUCTOR MARKER END]*/


}