package jkt.hms.billing.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jkt.hms.billing.dataservice.OpBillingDataService;
import jkt.hms.util.HMSUtil;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


@DisallowConcurrentExecution
public class GRNSchedulerController extends QuartzJobBean {

	private OpBillingDataService opBillingDataService = null;

	@SuppressWarnings("unchecked")
	protected void executeInternal(JobExecutionContext arg) throws JobExecutionException
	{
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
						
			/*if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				dataMap.put("userId", users.getId());
			}
			String userName = (String) session.getAttribute("userName");
			dataMap.put("userName", userName);*/
			
			processDate = HMSUtil.convertStringTypeDateToDateType(date);
			dataMap.put("processDate", processDate);
			dataMap.put("userId", 1);
			dataMap.put("userName", "admin");
			opBillingDataService.scheduledDailyChargeEntry(dataMap);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public OpBillingDataService getOpBillingDataService() {
		return opBillingDataService;
	}

	public void setOpBillingDataService(OpBillingDataService opBillingDataService) {
		this.opBillingDataService = opBillingDataService;
	}
}