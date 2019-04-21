package jkt.hms.stores.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jkt.hms.stores.dataservice.StoresDataService;
import jkt.hms.util.HMSUtil;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


@DisallowConcurrentExecution
public class SlowMovingItems extends QuartzJobBean {
	
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
		Date processDate = null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		//HttpSession session = request.getSession();
		//Users users = new Users();
		try
		{
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			
			storesDataService.schedulerForSlowMovingDrugs(dataMap);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
}
