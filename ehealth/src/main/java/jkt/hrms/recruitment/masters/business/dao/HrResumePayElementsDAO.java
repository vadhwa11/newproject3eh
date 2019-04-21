package jkt.hrms.recruitment.masters.business.dao;

import jkt.hrms.recruitment.masters.business.base.BaseHrResumePayElementsDAO;

import org.hibernate.Session;

public class HrResumePayElementsDAO extends BaseHrResumePayElementsDAO
		implements
		jkt.hrms.recruitment.masters.business.dao.iface.HrResumePayElementsDAO {

	public HrResumePayElementsDAO() {
	}

	public HrResumePayElementsDAO(Session session) {
		super(session);
	}

}