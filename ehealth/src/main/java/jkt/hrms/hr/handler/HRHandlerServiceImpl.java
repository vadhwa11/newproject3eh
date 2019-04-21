package jkt.hrms.hr.handler;

import jkt.hrms.hr.dataservice.HRDataService;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HRHandlerServiceImpl implements HRHandlerService{

	private HRDataService hrDataService;

	public HRDataService getHrDataService() {
		return hrDataService;
	}

	public void setHrDataService(HRDataService hrDataService) {
		this.hrDataService = hrDataService;
	}
}
