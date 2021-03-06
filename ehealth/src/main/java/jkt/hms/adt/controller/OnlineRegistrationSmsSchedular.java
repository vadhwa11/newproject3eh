package jkt.hms.adt.controller;


import jkt.hms.adt.dataservice.ADTDataService;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class OnlineRegistrationSmsSchedular extends QuartzJobBean{
	ADTDataService adtDataService;
	public ADTDataService getAdtDataService() {
		return adtDataService;
	}
	public void setAdtDataService(ADTDataService adtDataService) {
		this.adtDataService = adtDataService;
	}
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		/*System.out.println("*****************OTP SMS Start************");*/
		adtDataService.updateMobileRegistration();
		/*System.out.println("*****************OTP SMS End************");*/
		
	}

}
