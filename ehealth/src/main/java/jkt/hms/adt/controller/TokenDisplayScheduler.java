package jkt.hms.adt.controller;

import jkt.hms.adt.dataservice.RegistrationDataService;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class TokenDisplayScheduler  extends QuartzJobBean {
	
	private RegistrationDataService registrationDataService = null;

	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(
			RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		
		registrationDataService.updateDrWiseTokenDisplay();
		
	}

}
