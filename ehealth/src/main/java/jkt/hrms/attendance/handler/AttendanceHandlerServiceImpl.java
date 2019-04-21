package jkt.hrms.attendance.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrAbsentRegister;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.util.Box;
import jkt.hms.util.DateNotMatchedException;
import jkt.hrms.attendance.dataservice.AttendanceDataService;
import jkt.hrms.masters.business.HrAttendanceLoader;
import jkt.hrms.masters.business.HrEmployeeShiftDetails;
import jkt.hrms.masters.business.HrMasShift;
import jkt.hrms.masters.business.HrMasShiftCodes;

public class AttendanceHandlerServiceImpl implements AttendanceHandlerService {
	AttendanceDataService attendanceDataService = null;

	public AttendanceDataService getAttendanceDataService() {
		return attendanceDataService;
	}

	public void setAttendanceDataService(
			AttendanceDataService attendanceDataService) {
		this.attendanceDataService = attendanceDataService;
	}

	public Map<String, Object> showEmployeeDetails() {

		return attendanceDataService.showEmployeeDetails();
	}

	public Map<String, Object> saveEmployeeShiftDetails(
			HrEmployeeShiftDetails hrEmployeeShiftDetails) {

		return attendanceDataService
				.saveEmployeeShiftDetails(hrEmployeeShiftDetails);
	}

	public Map<String, Object> editEmployeeShiftDetail(int employeeShiftDetailId) {

		return attendanceDataService
				.editEmployeeShiftDetail(employeeShiftDetailId);
	}

	/*
	 * public Map<String, Object> showSearchEmployeeShiftDetails() {
	 *
	 * return attendanceDataService.showSearchEmployeeShiftDetails(); }
	 *
	 * public Map<String, Object> searchEmployeeShiftDetails(int employeeId) {
	 *
	 * return attendanceDataService.searchEmployeeShiftDetails(employeeId); }
	 */
	public Map<String, Object> updateEmployeeShiftDetails(
			Map<String, Object> parameterMap) {

		return attendanceDataService.updateEmployeeShiftDetails(parameterMap);
	}

	public Map<String, Object> showShiftJsp(int hospitalId) {

		return attendanceDataService.showShiftJsp(hospitalId);
	}

	public Map<String, Object> saveShiftDetails(HrMasShift hrMasShift,int hospitalId) {

		return attendanceDataService.saveShiftDetails(hrMasShift,hospitalId);
	}

	public Map<String, Object> editShiftDetails(int shiftId,int hospitalId) {

		return attendanceDataService.editShiftDetails(shiftId,hospitalId);
	}

	public Map<String, Object> updateShiftDetails(
			Map<String, Object> parameterMap) {

		return attendanceDataService.updateShiftDetails(parameterMap);
	}

	public Map<String, Object> importAttendanceFile(
			Map<String, Object> generalMap) throws DateNotMatchedException {

		return attendanceDataService.importAttendanceFile(generalMap);
	}

	public Map<String, Object> processDataInAttendanceFile(
			Map<String, Object> generalMap) {

		return attendanceDataService.processDataInAttendanceFile(generalMap);
	}

	public Map<String, Object> saveShiftCode(HrMasShiftCodes hrMasShiftCodes) {

		return attendanceDataService.saveShiftCode(hrMasShiftCodes);
	}

	public Map<String, Object> showShiftCodeJsp() {

		return attendanceDataService.showShiftCodeJsp();
	}

	public Map<String, Object> editShiftCode(Map<String, Object> generalMap) {

		return attendanceDataService.editShiftCode(generalMap);
	}

	public Map<String, Object> deleteShiftCode(Map<String, Object> generalMap) {

		return attendanceDataService.deleteShiftCode(generalMap);
	}

	public Map<String, Object> searchShiftCode(String shiftCode,
			String shiftName) {

		return attendanceDataService.searchShiftCode(shiftCode, shiftName);
	}

	public Map<String, Object> showEmployeeAttendanceJsp(int new_employee_id) {

		return attendanceDataService.showEmployeeAttendanceJsp(new_employee_id);
	}
	
	/*public Map<String, Object> showEmployeeAttendanceForAdminJsp() {
		return attendanceDataService.showEmployeeAttendanceForAdminJsp();
    }*/
	public Map<String, Object> showEmployeeAttendanceForAdminJsp(Map<String, Object> parameterMap) {

		return attendanceDataService.showEmployeeAttendanceForAdminJsp(parameterMap);
	}

	public Map<String, Object> saveEmployeeAttenadance(
			HrAttendanceLoader hrAttendanceLoader) {

		return attendanceDataService
				.saveEmployeeAttenadance(hrAttendanceLoader);
	}

	public Map<String, Object> displayEmployeeAttenadance(
			Map<String, Object> generalMap) {

		return attendanceDataService.displayEmployeeAttenadance(generalMap);
	}

	public Map<String, Object> showDatawiseAttendanceReportJsp() {

		return attendanceDataService.showDatawiseAttendanceReportJsp();
	}

	public Map<String, Object> showLateAttendanceReportJsp() {

		return attendanceDataService.showLateAttendanceReportJsp();
	}

	public Map<String, Object> showAttendanceCardReportJsp() {

		return attendanceDataService.showAttendanceCardReportJsp();
	}

	public Map<String, Object> getConnectionForReport() {

		return attendanceDataService.getConnectionForReport();
	}

	public Map<String, Object> printEmployeeAttendanceCardReport(
			Map<String, Object> generalMap) {

		return attendanceDataService
				.printEmployeeAttendanceCardReport(generalMap);
	}

	public List getLateEmployeeList(MasEmployee user) {
		return attendanceDataService.getLateEmployeeList(user);
	}

	public Map<String, Object> editEmployeeAttendance(int employeeAttendanceId) {

		return attendanceDataService
				.editEmployeeAttendance(employeeAttendanceId);
	}

	public Map<String, Object> updateEmployeeAttendance(
			Map<String, Object> generalMap) {

		return attendanceDataService.updateEmployeeAttendance(generalMap);
	}

	public Map<String, Object> getEmployeeList(int departmentId) {
		// TODO Auto-generated method stub
		return attendanceDataService.getEmployeeList(departmentId);
	}

	public List<Integer> getWeekands() {
		// TODO Auto-generated method stub
		return attendanceDataService.getWeekands();
	}

	public int getNoOfLegalHolidays(java.util.Date startDate,
			java.util.Date endDate) {
		return attendanceDataService.getNoOfLegalHolidays(startDate, endDate);
	}

	public Map<String, Object> showMonthlyAttendanceReportJsp() {

		return attendanceDataService.showMonthlyAttendanceReportJsp();
	}

	public Map<String, Object> showMonthlyAttendanceStatusReportJsp() {

		return attendanceDataService.showMonthlyAttendanceStatusReportJsp();
	}

	/*public Map<String, Object> showAttendanceVerifyJsp(java.util.Date date) {

		return attendanceDataService.showAttendanceVerifyJsp(date);
	}*/

	public Map<String, Object> saveAttendanceVerify(
			Map<String, Object> generalMap) {

		return attendanceDataService.saveAttendanceVerify(generalMap);
	}

	public Map<String, Object> showManualEmployeeAttendanceJsp() {

		return attendanceDataService.showManualEmployeeAttendanceJsp();
	}

	public Map<String, Object> saveManualEmployeeAttenadance(
			Map<String, Object> generalMap) {

		return attendanceDataService.saveManualEmployeeAttenadance(generalMap);
	}
	public Map<String, Object> showAttendanceLoaderJsp() {

		return attendanceDataService.showAttendanceLoaderJsp();
	}


	public boolean importMsAccessFile() {

		return attendanceDataService.importMsAccessFile();
	}

	@Override
	public Map<String, Object> saveShiftParameterDetails(Map<String, Object> valueMap) {
			
		return attendanceDataService.saveShiftParameterDetails(valueMap);
	}

	@Override
	public Map<String, Object> searchShiftParameter(Map<String, Object> valueMap) {
		return attendanceDataService.searchShiftParameter(valueMap);
	}

	@Override
	public Map<String, Object> updateShiftParameterDetails(Map<String, Object> valueMap) {
			
		return attendanceDataService.updateShiftParameterDetails(valueMap);
	}

	@Override
	public Map<String, Object> showDutyScheduleJsp(Map parameterMap) {
		return attendanceDataService.showDutyScheduleJsp(parameterMap);
	}

	@Override
	public Map<String, Object> searchDutyScheduleEmployee(Map parameterMap) {
		// TODO Auto-generated method stub
		return attendanceDataService.searchDutyScheduleEmployee(parameterMap);
	}

	@Override
	public Map<String, Object> getSessForShift(Map parameterMap) {
		return attendanceDataService.getSessForShift(parameterMap);
	}

	@Override
	public Map<String, Object> saveDutySchedule(Map parameterMap) {
		return attendanceDataService.saveDutySchedule(parameterMap);
	}

	@Override
	public Map<String, Object> searchEmployeeForAttenadance(Map parameterMap) {
		return attendanceDataService.searchEmployeeForAttenadance(parameterMap);
	}

	@Override
	public Map<String, Object> showAttendanceVerifyJsp(Map parameterMap) {
		return attendanceDataService.showAttendanceVerifyJsp(parameterMap);
	}

	@Override
	public void saveEmployeeAbsent(HrAbsentRegister hrAbsentRegister) {
		attendanceDataService.saveEmployeeAbsent(hrAbsentRegister);
		
	}

	@Override
	public Map<String, Object> updateEmployeeAttenadanceNew(
			Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return attendanceDataService.updateEmployeeAttenadanceNew(parameterMap);
	}

	@Override
	public Map<String, Object> validateDutySchedule(Map parameterMap) {
		return attendanceDataService.validateDutySchedule(parameterMap);
	}

	@Override
	public Map<String, Object> getShiftForSchedule(Box box) {
		return attendanceDataService.getShiftForSchedule(box);
	}

	@Override
	public Map<String, Object> getEmpServiceCentre(Box box) {
		return attendanceDataService.getEmpServiceCentre(box);
	}

	
}
