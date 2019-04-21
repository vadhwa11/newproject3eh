package jkt.hrms.timesheet.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hrms.masters.business.Tbltimesheet;
import jkt.hrms.masters.business.TbltimesheetAprl;
import jkt.hrms.timesheet.dataservice.TimeSheetDataService;

public class TimeSheetHandlerServiceImpl implements TimeSheetHandlerService {

	TimeSheetDataService timesheetDataService = null;

	public TimeSheetDataService getTimesheetDataService() {
		return timesheetDataService;
	}

	public void setTimesheetDataService(TimeSheetDataService timesheetDataService) {
		this.timesheetDataService = timesheetDataService;
	}

	public Map showTimeSheetJsp(int empId,Date date) {
		// TODO Auto-generated method stub
		return timesheetDataService.showTimeSheetJsp(empId,date);
	}

	public Map getTaskList(int empId, int prjId) {
		// TODO Auto-generated method stub
		return timesheetDataService.getTaskList(empId,prjId);
	}

	public boolean submitTimeSheet(Tbltimesheet tbltimesheet) {
		// TODO Auto-generated method stub
		return timesheetDataService.submitTimeSheet(tbltimesheet);
	}

	public boolean submitTimeSheet(int prjId) {
		// TODO Auto-generated method stub
		return timesheetDataService.submitTimeSheet(prjId);
	}
	public boolean deleteTimeSheet(int prjId) {
		// TODO Auto-generated method stub
		return timesheetDataService.deleteTimeSheet(prjId);
	}

	public Map showTimeSheetApprovalJsp(int empId) {
		// TODO Auto-generated method stub
		return timesheetDataService.showTimeSheetApprovalJsp(empId);
	}

	public Map loadTimeSheet(int empId, Date date,int currentEmpId, int approverId, int otherId) {
		// TODO Auto-generated method stub
		return timesheetDataService.loadTimeSheet(empId, date,currentEmpId, approverId, otherId);
	}

	public Map setTimeSheetStatus(int id,String status,TbltimesheetAprl tbltimesheetAprl,int manager) {
		// TODO Auto-generated method stub
		return timesheetDataService.setTimeSheetStatus(id,status,tbltimesheetAprl,manager);
	}

	public boolean editTimeSheet(Map map) {
		// TODO Auto-generated method stub
		return timesheetDataService.editTimeSheet(map);
	}

	public boolean approveAll(Date fromDate, Date toDate,int currentEmpId) {
		// TODO Auto-generated method stub
		return timesheetDataService.approveAll(fromDate, toDate,currentEmpId);
	}

	public boolean saveFreezTimeSheet(Map map) {
		// TODO Auto-generated method stub
		return timesheetDataService.saveFreezTimeSheet(map);
	}

	public Map showFreezTimeSheet(String year) {
		// TODO Auto-generated method stub
		return timesheetDataService.showFreezTimeSheet(year);
	}

	public boolean markNoOfSubmission(int empId, Date date) {
		// TODO Auto-generated method stub
		return timesheetDataService.markNoOfSubmission(empId, date);
	}

	public Map<String, Object> copyOtherDateTimeSheet(Map<String, Object> generalMap) {
		
		return timesheetDataService.copyOtherDateTimeSheet(generalMap);
	}
	
}
