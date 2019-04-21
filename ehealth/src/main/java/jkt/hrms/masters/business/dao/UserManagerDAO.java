package jkt.hrms.masters.business.dao;

import jkt.hrms.masters.business.base.BaseUserManagerDAO;

import org.hibernate.Session;

public class UserManagerDAO extends BaseUserManagerDAO implements
		jkt.hrms.masters.business.dao.iface.UserManagerDAO {

	public UserManagerDAO() {
	}

	public UserManagerDAO(Session session) {
		super(session);
	}

}