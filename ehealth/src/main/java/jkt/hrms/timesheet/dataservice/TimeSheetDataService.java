package jkt.hrms.timesheet.dataservice;

import java.util.Date;

import java.util.List;
import java.util.Map;

import jkt.hrms.masters.business.Tbltimesheet;
import jkt.hrms.masters.business.TbltimesheetAprl;

public interface TimeSheetDataService 
{
	public  Map showTimeSheetJsp(int empId,Date date);
	public  Map getTaskList(int empId,int prjId);
	public boolean submitTimeSheet(Tbltimesheet tbltimesheet);
	public boolean submitTimeSheet(int prjId);
	public boolean deleteTimeSheet(int prjId);
	public  Map showTimeSheetApprovalJsp(int empId);
	public Map loadTimeSheet(int empId,Date date,int currentEmpId, int approverId, int otherId);
	public Map setTimeSheetStatus(int id,String status,TbltimesheetAprl tbltimesheetAprl,int manager);
	public boolean editTimeSheet(Map map);
	public boolean approveAll(Date fromDate,Date toDate,int currentEmpId);
	public  Map showFreezTimeSheet(String year);
	public boolean saveFreezTimeSheet(Map map);
	public boolean markNoOfSubmission(int empId,Date date);
	public Map<String, Object> copyOtherDateTimeSheet(
			Map<String, Object> generalMap);
}
