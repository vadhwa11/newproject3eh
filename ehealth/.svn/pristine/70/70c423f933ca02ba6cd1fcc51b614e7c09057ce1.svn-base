package jkt.hrms.leave.controller;

import jkt.hrms.leave.handler.LeaveDetailsHandlerService;
import jkt.security.masters.handler.UserMasterHandlerService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MonthlyLeaveSchedulerController extends QuartzJobBean {

	private LeaveDetailsHandlerService leaveHandlerService = null;
	private UserMasterHandlerService userMasterHandlerService = null;

	protected void executeInternal(JobExecutionContext arg)
			throws JobExecutionException {
		try {

			// List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediator = new
			// ArrayList<HrMasLeaveTypeMediator>();
			// leaveHandlerService.updateLeavePolicy(); // Commented For Time
			// Being
			leaveHandlerService.updateLeaveBalanceMonthly();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public UserMasterHandlerService getUserMasterHandlerService() {
		return userMasterHandlerService;
	}

	public void setUserMasterHandlerService(
			UserMasterHandlerService userMasterHandlerService) {
		this.userMasterHandlerService = userMasterHandlerService;
	}

	public LeaveDetailsHandlerService getLeaveHandlerService() {
		return leaveHandlerService;
	}

	public void setLeaveHandlerService(
			LeaveDetailsHandlerService leaveHandlerService) {
		this.leaveHandlerService = leaveHandlerService;
	}

}
