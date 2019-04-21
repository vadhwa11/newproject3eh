package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseUsers;

public class Users extends BaseUsers {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Users () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Users (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Users (
		java.lang.Integer id,
		java.lang.String loginName,
		java.lang.String userName,
		java.lang.String password,
		java.lang.String status,
		java.lang.String superuser) {

		super (
			id,
			loginName,
			userName,
			password,
			status,
			superuser);
	}

	/* [CONSTRUCTOR MARKER END] */

}