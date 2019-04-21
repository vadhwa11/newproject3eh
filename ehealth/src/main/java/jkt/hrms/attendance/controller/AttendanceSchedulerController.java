package jkt.hrms.attendance.controller;

import jkt.hms.stores.dataservice.StoresDataService;
import jkt.hrms.attendance.dataservice.AttendanceDataService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AttendanceSchedulerController extends QuartzJobBean {

	private AttendanceDataService attendanceDataService = null;

	protected void executeInternal(JobExecutionContext arg)
			throws JobExecutionException {
		boolean updated = false;
		try {
			updated = attendanceDataService.importMsAccessFile();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		if (updated == true) {
		} else {
		}
	}

	public AttendanceDataService getAttendanceDataService() {
		return attendanceDataService;
	}

	public void setAttendanceDataService(AttendanceDataService attendanceDataService) {
		this.attendanceDataService = attendanceDataService;
	}

}
