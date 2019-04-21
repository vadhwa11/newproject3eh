package jkt.hms.stores.controller;

import java.util.HashMap;
import java.util.Map;

import jkt.hms.stores.dataservice.StoresDataService;
import jkt.hms.stores.handler.StoresHandlerService;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class StoreStockRegisterCronJob  extends QuartzJobBean {

	StoresDataService storesDataService= null;
	public StoresDataService getStoresDataService() {
		return storesDataService;
	}
	public void setStoresDataService(StoresDataService storesDataService) {
		this.storesDataService = storesDataService;
	}
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		getStartSch();
		//Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map=storesDataService.setStoreStockRegisterCronJob(mapDetail);
	}
	public void getStartSch() {
	}
}
