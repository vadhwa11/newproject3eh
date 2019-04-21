package jkt.hms.billing.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import jkt.hms.billing.dataservice.OpBillingDataServiceImpl;

import org.quartz.CronTrigger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DailyChargeBatchProcess extends QuartzJobBean {

	private OpBillingDataServiceImpl opBillingDataService = null;

	public OpBillingDataServiceImpl getOpBillingDataService() {
		return opBillingDataService;
	}

	public void setOpBillingDataService(
			OpBillingDataServiceImpl opBillingDataService) {
		this.opBillingDataService = opBillingDataService;
	}

	protected void executeInternal(JobExecutionContext arg)
			throws JobExecutionException {
		boolean saved = false;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
		/*	String userName = (String) session.getAttribute("userName");
			dataMap.put("userName", userName);
*/
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
			        new String[] {"eha-applicationContext.xml"});


			Scheduler scheduler = (Scheduler) appContext.getBean("scheduleFactory");
			String[] triggerNames = new String[] {};
			String triggerName = "";
			CronTrigger trigger = null;
			/*if (scheduler != null) {
				try {
					// throws SchedulerException
					triggerNames = scheduler.getTriggerNames("DEFAULT");
					triggerName = triggerNames.length > 0 ? triggerNames[0] : "";
					trigger = (CronTrigger) scheduler.getTrigger(triggerName, "DEFAULT");
					if (trigger != null) {
						// throws ParseException
						trigger.setCronExpression("0 0 7 * * ?");

						// throws SchedulerException
						scheduler.rescheduleJob(triggerName, "DEFAULT",trigger);
					}
				} catch (SchedulerException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}*/

			map = opBillingDataService.scheduledDailyChargeEntry(dataMap);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		if (saved == true) {
		} else {
		}
	}


}

