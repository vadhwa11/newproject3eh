package jkt.hrms.masters.business.dao;

import org.hibernate.Session;

import jkt.hrms.masters.business.base.BaseHrTrainingApprovalStatusDAO;


public class HrTrainingApprovalStatusDAO extends BaseHrTrainingApprovalStatusDAO implements jkt.hrms.masters.business.dao.iface.HrTrainingApprovalStatusDAO {

	public HrTrainingApprovalStatusDAO () {}
	
	public HrTrainingApprovalStatusDAO (Session session) {
		super(session);
	}


}