package jkt.hrms.attendance.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrAbsentRegister;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.util.Box;
import jkt.hms.util.DateNotMatchedException;
import jkt.hrms.masters.business.HrAttendanceLoader;
import jkt.hrms.masters.business.HrEmployeeShiftDetails;
import jkt.hrms.masters.business.HrMasShift;
import jkt.hrms.masters.business.HrMasShiftCodes;

public interface AttendanceHandlerService {

	Map<String, Object> showEmployeeDetails();

	Map<String, Object> saveEmployeeShiftDetails(
			HrEmployeeShiftDetails hrEmployeeShiftDetails);

	Map<String, Object> editEmployeeShiftDetail(int employeeShiftDetailId);

	// Map<String, Object> showSearchEmployeeShiftDetails();

	// Map<String, Object> searchEmployeeShiftDetails(int employeeId);

	Map<String, Object> updateEmployeeShiftDetails(
			Map<String, Object> parameterMap);

	Map<String, Object> showShiftJsp(int hospitalId);

	Map<String, Object> saveShiftDetails(HrMasShift hrMasShift, int hospitalId);

	Map<String, Object> editShiftDetails(int shiftId, int hospitalId);

	Map<String, Object> updateShiftDetails(Map<String, Object> parameterMap);

	Map<String, Object> importAttendanceFile(Map<String, Object> generalMap)
			throws DateNotMatchedException;

	Map<String, Object> processDataInAttendanceFile(
			Map<String, Object> generalMap);

	Map<String, Object> saveShiftCode(HrMasShiftCodes hrMasShiftCodes);

	Map<String, Object> showShiftCodeJsp();

	Map<String, Object> editShiftCode(Map<String, Object> generalMap);

	Map<String, Object> deleteShiftCode(Map<String, Object> generalMap);

	Map<String, Object> searchShiftCode(String shiftCode, String shiftName);

	Map<String, Object> showEmployeeAttendanceJsp(int new_employee_id);

	Map<String, Object> showEmployeeAttendanceForAdminJsp(Map<String, Object> parameterMap);

	Map<String, Object> saveEmployeeAttenadance(
			HrAttendanceLoader hrAttendanceLoader);

	Map<String, Object> displayEmployeeAttenadance(
			Map<String, Object> generalMap);

	Map<String, Object> showDatawiseAttendanceReportJsp();

	Map<String, Object> showLateAttendanceReportJsp();

	Map<String, Object> showAttendanceCardReportJsp();

	Map<String, Object> getConnectionForReport();

	Map<String, Object> printEmployeeAttendanceCardReport(
			Map<String, Object> generalMap);

	public List getLateEmployeeList(MasEmployee user);

	Map<String, Object> editEmployeeAttendance(int employeeAttendanceId);

	Map<String, Object> updateEmployeeAttendance(Map<String, Object> generalMap);

	Map<String, Object> getEmployeeList(int departmentId);

	List<Integer> getWeekands();

	int getNoOfLegalHolidays(java.util.Date startDate, java.util.Date endDate);

	Map<String, Object> showMonthlyAttendanceReportJsp();

	Map<String, Object> showMonthlyAttendanceStatusReportJsp();

	Map<String, Object> showAttendanceVerifyJsp(Map parameterMap);

	Map<String, Object> saveAttendanceVerify(Map<String, Object> generalMap);

	Map<String, Object> showManualEmployeeAttendanceJsp();

	Map<String, Object> saveManualEmployeeAttenadance(
			Map<String, Object> generalMap);

	Map<String, Object> showAttendanceLoaderJsp();

	boolean importMsAccessFile();

	Map<String, Object> saveShiftParameterDetails(Map<String, Object> valueMap);

	Map<String, Object> searchShiftParameter(Map<String, Object> valueMap);

	Map<String, Object> updateShiftParameterDetails(Map<String, Object> valueMap);

	Map<String, Object> showDutyScheduleJsp(Map parameterMap);

	Map<String, Object> searchDutyScheduleEmployee(Map parameterMap);

	Map<String, Object> getSessForShift(Map parameterMap);

	Map<String, Object> saveDutySchedule(Map parameterMap);

	Map<String, Object> searchEmployeeForAttenadance(Map parameterMap);

	void saveEmployeeAbsent(HrAbsentRegister hrAbsentRegister);

	Map<String, Object> updateEmployeeAttenadanceNew(
			Map<String, Object> parameterMap);

	Map<String, Object> validateDutySchedule(Map parameterMap);

	Map<String, Object> getShiftForSchedule(Box box);

	Map<String, Object> getEmpServiceCentre(Box box);

}
