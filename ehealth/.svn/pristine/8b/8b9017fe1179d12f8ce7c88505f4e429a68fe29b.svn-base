package jkt.hrms.recruitment.controller;

import static jkt.hrms.util.HrmsRequestConstants.AGE_LIMIT;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.COMMENTS;
import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.DESIRABLE_QUALIFICATION;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_ID;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.EXP_LOWER_RANGE;
import static jkt.hrms.util.HrmsRequestConstants.EXP_UPPER_RANGE;
import static jkt.hrms.util.HrmsRequestConstants.FROM_DATE_FOR_VALIDATION;
import static jkt.hrms.util.HrmsRequestConstants.HOSPITAL_ID;
import static jkt.hrms.util.HrmsRequestConstants.INFRASTRUCTURE_REQUIREMENT;
import static jkt.hrms.util.HrmsRequestConstants.INITIATOR_ID;
import static jkt.hrms.util.HrmsRequestConstants.JOB_DESCRIPTION;
import static jkt.hrms.util.HrmsRequestConstants.LOCATION_ID;
import static jkt.hrms.util.HrmsRequestConstants.NUMBER_OF_POSITIONS;
import static jkt.hrms.util.HrmsRequestConstants.PRIMARY_PURPOSE_OF_POSITION;
import static jkt.hrms.util.HrmsRequestConstants.PROPOSED_DESIGNATION;
import static jkt.hrms.util.HrmsRequestConstants.QUALIFICATION_OBTAINED;
import static jkt.hrms.util.HrmsRequestConstants.REPORTING_MANAGER_EMP_ID;
import static jkt.hrms.util.HrmsRequestConstants.REQUEST_APPROVED_LEAVES_JSP;
import static jkt.hrms.util.HrmsRequestConstants.REQUIRED_SKILL;
import static jkt.hrms.util.HrmsRequestConstants.REQUISITION_DATE;
import static jkt.hrms.util.HrmsRequestConstants.RESOURCE_REQUEST_ID;
import static jkt.hrms.util.HrmsRequestConstants.RESOURCE_REQUISITION;
import static jkt.hrms.util.HrmsRequestConstants.SALARY_LOWER_RANGE;
import static jkt.hrms.util.HrmsRequestConstants.SALARY_UPPER_RANGE;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_REQUESTS;
import static jkt.hrms.util.HrmsRequestConstants.TO_DATE_FOR_VALIDATION;
import static jkt.hrms.util.HrmsRequestConstants.USERS;
import static jkt.hrms.util.HrmsRequestConstants.VACANCY_REASON_ID;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.MasEmployeeType;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.masters.business.MasVacancyReason;
import jkt.hrms.masters.business.UserManager;
import jkt.hrms.recruitment.handler.RecruitmentHandlerService;
import jkt.hrms.recruitment.masters.business.HrRequisitionHistory;
import jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus;
import jkt.hrms.recruitment.masters.business.RequestStatusMaster;
import jkt.hrms.recruitment.masters.business.ResourceRequisition;
import jkt.hrms.util.SendMail;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class RecruitmentController extends MultiActionController {
	private RecruitmentHandlerService recruitmentHandlerService = null;

	public RecruitmentHandlerService getRecruitmentHandlerService() {
		return recruitmentHandlerService;
	}

	public void setRecruitmentHandlerService(
			RecruitmentHandlerService recruitmentHandlerService) {
		this.recruitmentHandlerService = recruitmentHandlerService;
	}

	public ModelAndView showApprovedRequest(HttpServletRequest request,
			HttpServletResponse

			response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		List approvedLeavesList = recruitmentHandlerService
				.getAllApprovedRequests();

		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,APPROVED_LEAVES_JSP);
		// map.put(TITLE,"Approved Leaves");

		map.put("approvedLeavesList", approvedLeavesList);
		// map.put("approvedLeavesEncashment", approvedLeavesEncashment);

		String jsp = REQUEST_APPROVED_LEAVES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	/*public ModelAndView showResourceReqJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users user = null;
		Set<UserManager> usermanagers = new HashSet<UserManager>();
		int hospitalId = 0;

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
		}
		map = recruitmentHandlerService.showResourceReqJsp(hospitalId);
		Map map1 = (Map) recruitmentHandlerService.loadObject(MasEmployee.class, 1);
		map.putAll(map1);
		String jsp = RESOURCE_REQUISITION;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}
*/
	public ModelAndView saveManPowerRequisitionDetail(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*
		 * int hospitalId =0;
		 * 
		 * 
		 * if (session.getAttribute("hospitalId")!= null) { hospitalId =
		 * (Integer)session.getAttribute("hospitalId"); }
		 */

		ResourceRequisition resourceRequisition = new ResourceRequisition();
		Users user = null;
		String name = "";
		String empId = "";
		String loginId = "";
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			name = user.getEmployee().getFirstName();
			empId = user.getEmployee().getEmployeeCode();
			loginId = user.getEmployee().getEmail();
		}
		int hospitalId = 0;
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			resourceRequisition.setCompany(masHospital);
		}

		int reqAddByEmpId = 0;
		if (request.getParameter(EMPLOYEE_ID) != null) {
			reqAddByEmpId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(reqAddByEmpId);
			resourceRequisition.setReqAddBy(masEmployee);
		}

		if (request.getParameter(INITIATOR_ID) != null
				&& !request.getParameter(INITIATOR_ID).equals("0")) {
			Integer initiatorName = new Integer(
					request.getParameter(INITIATOR_ID));
			MasEmployee initiator = new MasEmployee();
			initiator.setId(initiatorName);
			resourceRequisition.setInitiator(initiator);
		}

		if (request.getParameter(REQUISITION_DATE) != null
				&& !(request.getParameter(REQUISITION_DATE).equals(""))) {
			Date requisitionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(REQUISITION_DATE));
			resourceRequisition.setRequisitionDate(requisitionDate);
		}

		if (request.getParameter(EMPLOYEE_TYPE) != null
				&& !request.getParameter(EMPLOYEE_TYPE).equals("0")) {
			int employeeTypeId = Integer.parseInt(request
					.getParameter(EMPLOYEE_TYPE));
			MasEmployeeType masEmployeeType = new MasEmployeeType();
			masEmployeeType.setId(employeeTypeId);
			resourceRequisition.setEmployeeType(masEmployeeType);
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !request.getParameter(DEPARTMENT_ID).equals("0")) {
			int departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID));
			MasEmployeeDepartment masDepartment = new MasEmployeeDepartment();
			masDepartment.setId(departmentId);
			resourceRequisition.setDepartment(masDepartment);
		}
		if (request.getParameter(LOCATION_ID) != null
				&& !request.getParameter(LOCATION_ID).equals("0")) {
			int locationId = Integer
					.parseInt(request.getParameter(LOCATION_ID));
			MasLocation masLocation = new MasLocation();
			masLocation.setId(locationId);
			resourceRequisition.setLocation(masLocation);
		}
		if (request.getParameter(PROPOSED_DESIGNATION) != null
				&& !(request.getParameter(PROPOSED_DESIGNATION).equals(""))) {
			String proposedDesignation = request
					.getParameter(PROPOSED_DESIGNATION);
			resourceRequisition.setProposedDesignation(proposedDesignation);
		}
		if (request.getParameter(VACANCY_REASON_ID) != null
				&& !request.getParameter(VACANCY_REASON_ID).equals("0")) {
			int vacancyReasonId = Integer.parseInt(request
					.getParameter(VACANCY_REASON_ID));
			MasVacancyReason masVacancyReason = new MasVacancyReason();
			masVacancyReason.setId(vacancyReasonId);
			resourceRequisition.setVacancyReason(masVacancyReason);
		}
		if (request.getParameter(REPORTING_MANAGER_EMP_ID) != null
				&& !request.getParameter(REPORTING_MANAGER_EMP_ID).equals("0")) {
			int reportingManagerEmpId = Integer.parseInt(request
					.getParameter(REPORTING_MANAGER_EMP_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(reportingManagerEmpId);
			resourceRequisition.setRepManager(masEmployee);
		}
		if (request.getParameter(NUMBER_OF_POSITIONS) != null
				&& !(request.getParameter(NUMBER_OF_POSITIONS).equals(""))) {
			Integer totalNoPosition = Integer.parseInt(request
					.getParameter(NUMBER_OF_POSITIONS));
			resourceRequisition.setTotalNoPosition(totalNoPosition);
		}
		resourceRequisition.setNoOfPositionOccupied(0);
		if (request.getParameter(QUALIFICATION_OBTAINED) != null
				&& !request.getParameter(QUALIFICATION_OBTAINED).equals("0")) {
			int qualificationId = Integer.parseInt(request
					.getParameter(QUALIFICATION_OBTAINED));
			MasQualification masQualification = new MasQualification();
			masQualification.setId(qualificationId);
			resourceRequisition.setQualification(masQualification);
		}
		if (request.getParameter(DESIRABLE_QUALIFICATION) != null
				&& !request.getParameter(DESIRABLE_QUALIFICATION).equals("0")) {
			int desirableQlfId = Integer.parseInt(request
					.getParameter(DESIRABLE_QUALIFICATION));
			MasQualification masQualification = new MasQualification();
			masQualification.setId(desirableQlfId);
			resourceRequisition.setDesirableQlf(masQualification);
		}

		if (request.getParameter(EXP_LOWER_RANGE) != null
				&& !request.getParameter(EXP_LOWER_RANGE).equals("")) {
			int expLowerRange = Integer.parseInt(request
					.getParameter(EXP_LOWER_RANGE));
			resourceRequisition.setExpLowerRange(expLowerRange);
		}
		if (request.getParameter(EXP_UPPER_RANGE) != null
				&& !request.getParameter(EXP_UPPER_RANGE).equals("")) {
			int expUpperRange = Integer.parseInt(request
					.getParameter(EXP_UPPER_RANGE));
			resourceRequisition.setExpUpperRange(expUpperRange);
		}
		if (request.getParameter(AGE_LIMIT) != null
				&& !(request.getParameter(AGE_LIMIT).equals(""))) {
			Integer ageLimit = Integer
					.parseInt(request.getParameter(AGE_LIMIT));
			resourceRequisition.setAgeLimit(ageLimit);
		}
		if (request.getParameter(PRIMARY_PURPOSE_OF_POSITION) != null
				&& !(request.getParameter(PRIMARY_PURPOSE_OF_POSITION)
						.equals(""))) {
			String positionPurpose = request
					.getParameter(PRIMARY_PURPOSE_OF_POSITION);
			resourceRequisition.setPositionPurpose(positionPurpose);
		}
		if (request.getParameter(JOB_DESCRIPTION) != null
				&& !(request.getParameter(JOB_DESCRIPTION).equals(""))) {
			String jobDescription = request.getParameter(JOB_DESCRIPTION);
			resourceRequisition.setJobDesc(jobDescription);
		}
		if (request.getParameter(REQUIRED_SKILL) != null
				&& !(request.getParameter(REQUIRED_SKILL).equals(""))) {
			String requiredSkill = request.getParameter(REQUIRED_SKILL);
			resourceRequisition.setRequiredSkill(requiredSkill);
		}
		if (request.getParameter(INFRASTRUCTURE_REQUIREMENT) != null
				&& !request.getParameter(INFRASTRUCTURE_REQUIREMENT)
						.equals("0")) {
			String infrastRequirment = request
					.getParameter(INFRASTRUCTURE_REQUIREMENT);
			resourceRequisition.setInfrastRequirment(infrastRequirment);
		}
		if (request.getParameter(SALARY_LOWER_RANGE) != "") {
			int salaryLowerRange = new Integer(
					request.getParameter(SALARY_LOWER_RANGE));
			resourceRequisition.setSalaryLowerRange(salaryLowerRange);
		}
		if (request.getParameter(SALARY_UPPER_RANGE) != "") {
			int salaryUpperRange = new Integer(
					request.getParameter(SALARY_UPPER_RANGE));
			resourceRequisition.setSalaryUpperRange(salaryUpperRange);
		}
		String comments = "";
		if (request.getParameter(COMMENTS) != "") {
			comments = request.getParameter(COMMENTS);

		}
		Integer approvingManagerId = 0;
		if (request.getParameter("approvingManager") != null
				&& !request.getParameter("approvingManager").equals("0")) {
			approvingManagerId = new Integer(
					request.getParameter("approvingManager"));
			MasEmployee employee = new MasEmployee();
			employee.setId(approvingManagerId);
			resourceRequisition.setApprovingManager(employee);
		}

		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			resourceRequisition.setLastChgBy(lastchangeBy);
		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			resourceRequisition.setLastChgDate(changedDate);
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			resourceRequisition.setLastChgTime(changedTime);
		}
		resourceRequisition.setStatus("y");

		map = recruitmentHandlerService
				.saveResourceRequisitionDetail(resourceRequisition);

		// -------setting status -------//
		Map map1 = (Map) recruitmentHandlerService.loadObject(
				MasEmployee.class, approvingManagerId);
		MasEmployee approvingManager = (MasEmployee) map1
				.get("approvingManager");
		MasRank intermedAppDesig = (MasRank) map1
				.get("intermediateApproverDesignation");
		MasRank finalApproverDesig = (MasRank) map1
				.get("finalApproverDesignation");
		HrResourceRequisitionStatus hrResourceRequisitionStatus = new HrResourceRequisitionStatus();

		RequestStatusMaster requestStatusMaster = new RequestStatusMaster();

		hrResourceRequisitionStatus.setCurrentLevel(0);
		requestStatusMaster.setId(1);

		hrResourceRequisitionStatus.setMasEmployee(user.getEmployee());

		hrResourceRequisitionStatus.setRequestStatusMaster(requestStatusMaster);

		hrResourceRequisitionStatus.setResourceRequisition(resourceRequisition);
		hrResourceRequisitionStatus.setActionDate(HMSUtil
				.getCurrentDateAndTimeObject());
		hrResourceRequisitionStatus.setComments(comments);
		recruitmentHandlerService
				.saveOrUpdateResourceRequisitionStatus(hrResourceRequisitionStatus);

		HrRequisitionHistory requisitionHistory = new HrRequisitionHistory();
		requisitionHistory.setRequisition(resourceRequisition);
		requisitionHistory.setEmployee(user.getEmployee());

		if (approvingManager.getRank().getId().equals(intermedAppDesig.getId())
				|| approvingManager.getRank().getId()
						.equals(finalApproverDesig.getId())) {
			requestStatusMaster.setId(1);
			requisitionHistory.setStatus(requestStatusMaster);
		} else {
			requisitionHistory.setStatus(requestStatusMaster);
		}
		requisitionHistory.setActionDate(HMSUtil.getCurrentDateAndTimeObject());
		requisitionHistory.setComments(comments);
		recruitmentHandlerService
				.saveOrUpdateRequisitionHistory(requisitionHistory);
		// resourceRequisition.setHrResourceRequisitionStatus(hrResourceRequisitionStatus);

		// Set<UserManager> usermanagers
		// String loginId = user.getEmployee().getEmail();

		Map parameterMap = new HashMap();
		if (user != null
				&& (!user.getEmployee().getDepartment().getDepartmentName()
						.equals("HR"))
				&& request.getParameter(EMPLOYEE_ID) != null) {
			reqAddByEmpId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			parameterMap.put("reqAddByEmpId", reqAddByEmpId);
		}
		parameterMap.put("hospitalId", hospitalId);
		Map requisitionListMap = recruitmentHandlerService
				.searchResourceRequests(parameterMap);
		List resourceRequisitionList = new ArrayList();
		if (requisitionListMap != null) {
			resourceRequisitionList = (List) requisitionListMap
					.get("resourceRequisitionList");
		}

		String subject = "Request For New Manpower Resource";
		String mailContent = "Hi \n\n  This request for new resource is given by "
				+ name + " having Employee Code :" + empId + ":- \n\n";
		boolean sent = false;
		String message = "";
		if ((Boolean) map.get("flag")) {
			try {
				sent = SendMail.sendMail("", loginId, resourceRequisition
						.getApprovingManager().getEmail(), "", "", subject,
						mailContent);
			} catch (Exception e) {
				sent = false;
				e.printStackTrace();
			}
			if (sent) {
				message = (String) map.get("message");
				message += " and a mail notification has been sent to corresponding Functional Head";
				map.put("message", message);
			}

		}
		String jsp = SEARCH_REQUESTS;
		jsp += ".jsp";
		map.putAll(map1);
		map.put("contentJsp", jsp);
		map.put("resourceRequisitionList", resourceRequisitionList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchResourceRequests(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String jsp = SEARCH_REQUESTS;
		HttpSession session = request.getSession();
		Users user = null;
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
		}

		if (request.getParameter(FROM_DATE_FOR_VALIDATION) != null
				&& !(request.getParameter(FROM_DATE_FOR_VALIDATION).equals(""))) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE_FOR_VALIDATION));
			parameterMap.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE_FOR_VALIDATION) != null
				&& !(request.getParameter(TO_DATE_FOR_VALIDATION).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE_FOR_VALIDATION));
			parameterMap.put("toDate", toDate);
		}
		/* for status y or no */
		/*
		 * if (request.getParameter(TO_DATE) != null &&
		 * !(request.getParameter(TO_DATE).equals(""))) { Date toDate =
		 * HMSUtil.convertStringTypeDateToDateType
		 * (request.getParameter(TO_DATE)); parameterMap.put("toDate", toDate);
		 * }
		 */

		int hospitalId = 0;
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
			parameterMap.put("hospitalId", hospitalId);
		}
		int reqAddByEmpId = 0;

		if (user != null && user.getEmployee() != null) {
			reqAddByEmpId = user.getEmployee().getId();
			parameterMap.put("reqAddByEmpId", reqAddByEmpId);
		}

		map = recruitmentHandlerService.searchResourceRequests(parameterMap);
		Map map1 = recruitmentHandlerService.loadObject(MasEmployee.class, 1);
		map.putAll(map1);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView updateManPowerRequisitionDetail(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String jsp = SEARCH_REQUESTS;
		int requisitionId = 0;
		int hospitalId = 0;
		Users user = null;
		String resend = "no";
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		parameterMap.put("hospitalId", hospitalId);
		if (request.getParameter("resend") != null) {
			resend = request.getParameter("resend");

		}
		if (request.getParameter(RESOURCE_REQUEST_ID) != null) {
			requisitionId = Integer.parseInt(request
					.getParameter(RESOURCE_REQUEST_ID));
			parameterMap.put("requisitionId", requisitionId);
		}

		if (!request.getParameter(EMPLOYEE_TYPE).equals("0")) {
			int employeeTypeId = Integer.parseInt(request
					.getParameter(EMPLOYEE_TYPE));
			// MasEmployeeType masEmployeeType=new MasEmployeeType();
			// masEmployeeType.setId(employeeTypeId);
			parameterMap.put("employeeTypeId", employeeTypeId);
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			int departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID));
			parameterMap.put("departmentId", departmentId);
		}

		if (!request.getParameter(LOCATION_ID).equals("0")) {
			int locationId = Integer
					.parseInt(request.getParameter(LOCATION_ID));
			parameterMap.put("locationId", locationId);
		}

		if (request.getParameter(PROPOSED_DESIGNATION) != null
				&& !(request.getParameter(PROPOSED_DESIGNATION).equals(""))) {
			String proposedDesignation = request
					.getParameter(PROPOSED_DESIGNATION);
			parameterMap.put("proposedDesignation", proposedDesignation);
		}

		if (!request.getParameter(VACANCY_REASON_ID).equals("0")) {
			int vacancyReasonId = Integer.parseInt(request
					.getParameter(VACANCY_REASON_ID));
			parameterMap.put("vacancyReasonId", vacancyReasonId);
		}

		if (request.getParameter(NUMBER_OF_POSITIONS) != null
				&& !(request.getParameter(NUMBER_OF_POSITIONS).equals(""))) {
			Integer totalNoPosition = Integer.parseInt(request
					.getParameter(NUMBER_OF_POSITIONS));
			parameterMap.put("totalNoPosition", totalNoPosition);
		}

		if (!request.getParameter(QUALIFICATION_OBTAINED).equals("0")) {
			int qualificationId = Integer.parseInt(request
					.getParameter(QUALIFICATION_OBTAINED));
			parameterMap.put("qualificationId", qualificationId);
		}

		if (!request.getParameter(DESIRABLE_QUALIFICATION).equals("0")) {
			int desirableQlfId = Integer.parseInt(request
					.getParameter(DESIRABLE_QUALIFICATION));
			parameterMap.put("desirableQlfId", desirableQlfId);
		}

		if (request.getParameter(EXP_LOWER_RANGE) != null
				&& !request.getParameter(EXP_LOWER_RANGE).equals("")) {
			int expLowerRange = Integer.parseInt(request
					.getParameter(EXP_LOWER_RANGE));
			parameterMap.put(EXP_LOWER_RANGE, expLowerRange);
		}
		if (request.getParameter(EXP_UPPER_RANGE) != null
				&& !request.getParameter(EXP_UPPER_RANGE).equals("")) {
			int expUpperRange = Integer.parseInt(request
					.getParameter(EXP_UPPER_RANGE));
			parameterMap.put(EXP_UPPER_RANGE, expUpperRange);
		}
		if (request.getParameter(AGE_LIMIT) != null
				&& !(request.getParameter(AGE_LIMIT).equals(""))) {
			Integer ageLimit = Integer
					.parseInt(request.getParameter(AGE_LIMIT));
			parameterMap.put("ageLimit", ageLimit);
		}

		if (request.getParameter(PRIMARY_PURPOSE_OF_POSITION) != null
				&& !(request.getParameter(PRIMARY_PURPOSE_OF_POSITION)
						.equals(""))) {
			String positionPurpose = request
					.getParameter(PRIMARY_PURPOSE_OF_POSITION);
			parameterMap.put("positionPurpose", positionPurpose);
		}

		if (request.getParameter(JOB_DESCRIPTION) != null
				&& !(request.getParameter(JOB_DESCRIPTION).equals(""))) {
			String jobDescription = request.getParameter(JOB_DESCRIPTION);
			parameterMap.put("jobDescription", jobDescription);
		}

		if (request.getParameter(REQUIRED_SKILL) != null
				&& !(request.getParameter(REQUIRED_SKILL).equals(""))) {
			String requiredSkill = request.getParameter(REQUIRED_SKILL);
			parameterMap.put("requiredSkill", requiredSkill);
		}

		if (!request.getParameter(INFRASTRUCTURE_REQUIREMENT).equals("")) {
			String infrastRequirment = request
					.getParameter(INFRASTRUCTURE_REQUIREMENT);
			parameterMap.put("infrastRequirment", infrastRequirment);
		}
		if (request.getParameter(SALARY_LOWER_RANGE) != "") {
			int salaryLowerRange = new Integer(
					request.getParameter(SALARY_LOWER_RANGE));
			parameterMap.put("salaryLowerRange", salaryLowerRange);
		}
		if (request.getParameter(SALARY_UPPER_RANGE) != "") {
			int salaryUpperRange = new Integer(
					request.getParameter(SALARY_UPPER_RANGE));
			parameterMap.put("salaryUpperRange", salaryUpperRange);
		}
		Integer approvingManagerId = null;
		if (request.getParameter("approvingManager") != null
				&& request.getParameter("approvingManager") != ""
				&& request.getParameter("approvingManager") != "0") {
			approvingManagerId = new Integer(
					request.getParameter("approvingManager"));
			parameterMap.put("approvingManagerId", approvingManagerId);
		}

		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			parameterMap.put("lastchangeBy", lastchangeBy);
		}

		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			Date changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			parameterMap.put("changedDate", changedDate);
		}

		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			parameterMap.put("changedTime", changedTime);
		}

		map = recruitmentHandlerService
				.updateResourceRequisitionDetail(parameterMap);

		ResourceRequisition resourceRequisition = (ResourceRequisition) map
				.get("resourceRequisition");
		if (resend.equals("yes")) {
			HrResourceRequisitionStatus resourceRequisitionStatus = resourceRequisition
					.getHrResourceRequisitionStatus();
			RequestStatusMaster requestStatusMaster = new RequestStatusMaster();
			requestStatusMaster.setId(7);
			resourceRequisitionStatus
					.setRequestStatusMaster(requestStatusMaster);
			int currentLevel = resourceRequisitionStatus.getCurrentLevel();
			resourceRequisitionStatus.setCurrentLevel(--currentLevel);
			resourceRequisitionStatus.setMasEmployee(user.getEmployee());
			recruitmentHandlerService
					.saveOrUpdateResourceRequisitionStatus(resourceRequisitionStatus);

			HrRequisitionHistory requisitionHistory = new HrRequisitionHistory();
			requisitionHistory.setActionDate(HMSUtil
					.getCurrentDateAndTimeObject());
			requisitionHistory.setRequisition(resourceRequisition);
			if (user != null) {
				requisitionHistory.setEmployee(user.getEmployee());
			}
			requisitionHistory.setStatus(requestStatusMaster);
			recruitmentHandlerService
					.saveOrUpdateRequisitionHistory(requisitionHistory);
		}

		parameterMap = new HashMap();
		Integer reqAddByEmpId = 0;
		if (user != null) {
			reqAddByEmpId = user.getEmployee().getId();
			parameterMap.put("reqAddByEmpId", reqAddByEmpId);
		}
		parameterMap.put("hospitalId", hospitalId);
		Map requisitionListMap = recruitmentHandlerService
				.searchResourceRequests(parameterMap);
		List resourceRequisitionList = new ArrayList();
		if (requisitionListMap != null) {
			resourceRequisitionList = (List) requisitionListMap
					.get("resourceRequisitionList");
		}
		Map map1 = (Map) recruitmentHandlerService.loadObject(
				MasEmployee.class, approvingManagerId);
		jsp += ".jsp";
		map.putAll(map1);
		map.put("contentJsp", jsp);
		map.put("resourceRequisitionList", resourceRequisitionList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showResourceDetailForUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		int requisitionId = 0;
		if (request.getParameter(RESOURCE_REQUEST_ID) != null) {
			requisitionId = Integer.parseInt(request
					.getParameter(RESOURCE_REQUEST_ID));
		}

		map = recruitmentHandlerService.showResourceDetailForUpdate(hospitalId,
				requisitionId);
		String jsp = RESOURCE_REQUISITION;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		Map map1 = recruitmentHandlerService.loadObject(MasEmployee.class, 1);
		map.putAll(map1);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showRequestApprovalScreen(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		Users user = null;
		Integer userId = 0;
		Integer hospitalId = 0;
		if (session.getAttribute(RequestConstants.USERS) != null) {
			user = (Users) session.getAttribute(RequestConstants.USERS);
			userId = user.getId();
			map.put("user", user);

		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			map.put("hospitalId", hospitalId);
		}
		if (request.getParameter(FROM_DATE_FOR_VALIDATION) != null
				&& !(request.getParameter(FROM_DATE_FOR_VALIDATION).equals(""))) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE_FOR_VALIDATION));
			map.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE_FOR_VALIDATION) != null
				&& !(request.getParameter(TO_DATE_FOR_VALIDATION).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE_FOR_VALIDATION));
			map.put("toDate", toDate);
		}

		map = recruitmentHandlerService.getRequistionListForUser(map);
		List<ResourceRequisition> resourceRequisitionList = (List) map
				.get("resourceRequisitionList");
		// resourceRequisitionList =
		// recruitmentHandlerService.addDepartmentTotalCTC(resourceRequisitionList);
		List requestStatusMasterList = recruitmentHandlerService
				.getRequestStatusMasterList();
		String jsp = "hr_requisitionApproval.jsp";
		map.put("contentJsp", jsp);
		// map.put("resourceRequisitionList" ,resourceRequisitionList);
		Map map1 = recruitmentHandlerService.loadObject(MasEmployee.class, 1);
		map.putAll(map1);
		map.put("requestStatusMasterList", requestStatusMasterList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateRequisitionStatus(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Users users = null;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("map") != null) {
			map = (HashMap<String, Object>) session.getAttribute("map");
		}
		String requestStatus = request.getParameter("requestStatus");
		String comments = request.getParameter(COMMENTS);
		Integer requestStatusId = new Integer(requestStatus);
		RequestStatusMaster requestStatusMaster = recruitmentHandlerService
				.getRequestStatusMasterById(requestStatusId);
		List<ResourceRequisition> requisitionList = (List<ResourceRequisition>) map
				.get("resourceRequisitionList");
		List<ResourceRequisition> requisitionListToBeUpdated = new ArrayList<ResourceRequisition>();
		for (int i = 0; i <= requisitionList.size(); i++) {
			String checkedIds = request.getParameter("id" + i);
			if (checkedIds != null) {
				requisitionListToBeUpdated.add(requisitionList.get(i));
			}
		}

		for (ResourceRequisition resourceRequisition : requisitionListToBeUpdated) {
			HrResourceRequisitionStatus hrResourceRequisitionStatus = resourceRequisition
					.getHrResourceRequisitionStatus();
			String approvedLevel = HMSUtil.getValuesFromPropertiesFile(
					"recruitmentFile.properties",
					"hrResourceRequisitionStatus.CurrentLevel");

			hrResourceRequisitionStatus.setCurrentLevel(new Integer(
					approvedLevel));

			if (users != null) {
				hrResourceRequisitionStatus.setMasEmployee(users.getEmployee());
			}

			RequestStatusMaster requestStatusMaster2 = new RequestStatusMaster();
			requestStatusMaster2.setId(new Integer(requestStatusId));
			hrResourceRequisitionStatus
					.setRequestStatusMaster(requestStatusMaster2);

			hrResourceRequisitionStatus
					.setResourceRequisition(resourceRequisition);
			hrResourceRequisitionStatus.setActionDate(HMSUtil
					.getCurrentDateAndTimeObject());
			hrResourceRequisitionStatus.setComments(comments);
			recruitmentHandlerService
					.saveOrUpdateResourceRequisitionStatus(hrResourceRequisitionStatus);

			HrRequisitionHistory requisitionHistory = new HrRequisitionHistory();
			requisitionHistory.setRequisition(resourceRequisition);
			requisitionHistory.setEmployee(users.getEmployee());
			requisitionHistory.setStatus(requestStatusMaster2);
			requisitionHistory.setActionDate(HMSUtil
					.getCurrentDateAndTimeObject());
			requisitionHistory.setComments(comments);
			recruitmentHandlerService
					.saveOrUpdateRequisitionHistory(requisitionHistory);

		}

		List updatedList = recruitmentHandlerService
				.updateRequisitionStatus(requisitionListToBeUpdated);
		String message = "";
		String url = "/hms/hrms/recruitment?method=showRequestApprovalScreen";
		if (updatedList != null && updatedList.size() != 0) {
			// String updatedStatus =
			// ((ResourceRequisition)updatedList.get(0)).atusDesc();

			if (requestStatusMaster.getId() == 3) {
				message = "Selected Requests for man power has been put "
						+ requestStatusMaster.getStatusDesc();
			} else {
				message = "Selected Requests for man power has been "
						+ requestStatusMaster.getStatusDesc();
			}
		}

		map.put("messageTOBeVisibleToTheUser", message);
		map.put("url", url);
		map.put("contentJsp", "message.jsp");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAnalyseMarketCtcJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Users users = null;
		Map parameterMap = new HashMap();
		int hospitalId = 0;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}

		if (session != null
				&& session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
		}

		parameterMap.put("users", users);
		parameterMap.put("hospitalId", hospitalId);

		Map map = recruitmentHandlerService
				.getRequistionListForMarketCTCAnalysis(parameterMap);
		List requestStatusMasterList = recruitmentHandlerService
				.getRequestStatusMasterList();
		String jsp = "hr_marketCtcAnalysis";
		jsp = jsp + ".jsp";
		Map map1 = recruitmentHandlerService.loadObject(MasEmployee.class, 1);
		map.putAll(map1);
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addMarketCtc(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Users users = null;
		Map map = new HashMap();
		Map parameterMap = new HashMap();

		int hospitalId = 0;
		Integer marketCtc = 0;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}

		if (session != null
				&& session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
		}
		if (session.getAttribute("map") != null) {
			map = (HashMap<String, Object>) session.getAttribute("map");
		}
		List<ResourceRequisition> requisitionList = (List<ResourceRequisition>) map
				.get("resourceRequisitionList");
		List<ResourceRequisition> requisitionListToBeUpdated = new ArrayList<ResourceRequisition>();
		for (int i = 0; i <= requisitionList.size(); i++) {
			String checkedIds = request.getParameter("id" + i);
			if (checkedIds != null) {
				requisitionListToBeUpdated.add(requisitionList.get(i));
			}
		}
		marketCtc = new Integer(request.getParameter("marketCTC"));

		for (ResourceRequisition resourceRequisition : requisitionListToBeUpdated) {
			HrResourceRequisitionStatus hrResourceRequisitionStatus = resourceRequisition
					.getHrResourceRequisitionStatus();

			RequestStatusMaster requestStatusMaster = new RequestStatusMaster();
			requestStatusMaster.setId(5);

			hrResourceRequisitionStatus
					.setRequestStatusMaster(requestStatusMaster);
			hrResourceRequisitionStatus.setMasEmployee(users.getEmployee());

			hrResourceRequisitionStatus
					.setResourceRequisition(resourceRequisition);
			recruitmentHandlerService
					.saveOrUpdateResourceRequisitionStatus(hrResourceRequisitionStatus);

			HrRequisitionHistory requisitionHistory = new HrRequisitionHistory();
			requisitionHistory.setRequisition(resourceRequisition);
			requisitionHistory.setEmployee(users.getEmployee());
			requisitionHistory.setStatus(requestStatusMaster);
			requisitionHistory.setActionDate(HMSUtil
					.getCurrentDateAndTimeObject());
			recruitmentHandlerService
					.saveOrUpdateRequisitionHistory(requisitionHistory);

			resourceRequisition.setMarketCtc(marketCtc);
			resourceRequisition.setCTCAnalysedBy(users.getEmployee());
		}
		List updatedList = recruitmentHandlerService
				.updateRequisitionStatus(requisitionListToBeUpdated);
		String message = "";
		String url = "/hms/hrms/recruitment?method=showAnalyseMarketCtcJsp";
		if (updatedList != null && updatedList.size() != 0) {
			message = "Market CTC for the selected requests for man power has been analysed";
		}

		map.put("messageTOBeVisibleToTheUser", message);
		map.put("url", url);
		map.put("contentJsp", "message.jsp");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForRecruitmentRequisition(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map mapresourceRequisition = (Map) session
				.getAttribute("mapresourceRequisition");
		List<ResourceRequisition> searchresourceRequisitionList = new ArrayList<ResourceRequisition>();
		if (mapresourceRequisition.get("searchresourceRequisitionList") != null) {
			searchresourceRequisitionList = (List) mapresourceRequisition
					.get("searchresourceRequisitionList");
		}
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		try {
			JasperReport jasperReport = HMSUtil.getCompiledReport(context,
					"man power requisitions");
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
					searchresourceRequisitionList);
			bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
					ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = "man power requisitions_" + new Date();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream ouputStream = response.getOutputStream();

			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public ModelAndView showResourceReqJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Map<String, Object> map2= new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users user = null;
		//String flag = "true";
		String flag="";
		String id="";
		
		Set<UserManager> usermanagers = new HashSet<UserManager>();
		int hospitalId =0;

		if (session.getAttribute("locationId")!= null) {
			hospitalId = (Integer)session.getAttribute("locationId");
		}
		if (session.getAttribute("users")!= null) {
			user = (Users)session.getAttribute("users");
		}
		int instituteId = 0;
		int cadreId = 0;
		int departmentId = 0;
		int designationId = 0; 
		
		
		if(request.getParameter("institute") != null && !request.getParameter("institute").equals("")){
			instituteId =Integer.parseInt(request.getParameter("institute"));
		}
		System.out.println("instituteId=111==="+instituteId);
		if(request.getParameter("department") != null && !request.getParameter("department").equals("")){
			departmentId =Integer.parseInt(request.getParameter("department"));
		}
		if(request.getParameter("designation") != null && !request.getParameter("designation").equals("")){
			designationId =Integer.parseInt(request.getParameter("designation"));
		}
		if(request.getParameter("cadre") != null && !request.getParameter("cadre").equals("")){
			cadreId =Integer.parseInt(request.getParameter("cadre"));
		}
		
		detailMap.put("hospitalId", hospitalId);
		detailMap.put("instituteId", instituteId);
		detailMap.put("designationId", designationId);
		detailMap.put("departmentId", departmentId);
		detailMap.put("cadreId", cadreId);
		detailMap.put("hospitalId", hospitalId);
		map = recruitmentHandlerService.showResourceReqJsp(detailMap);
		//map.put("flag", flag);
		
		
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag");
		}
		if(request.getParameter("id") != null){
			id = request.getParameter("id");
		}
		detailMap.put("id", id);
		List manPowerRequisitionList = recruitmentHandlerService.getAllApprovedRequests();
		
		//List rmsIdList = resumeHandlerService.getRecruitersList("1");
		if(flag != null && ! flag.equals("") && flag.equals("s")){
			System.out.println("instituteId=222==="+instituteId);
			map2 = recruitmentHandlerService.getEmployeeForPromo(detailMap);
			map.put("map2",map2);
		
		}
		
		//Map map1 = (Map) recruitmentHandlerService.loadObject(MasEmployee.class , 1) ;
		//map.putAll(map1);
		//String jsp = RESOURCE_REQUISITION;
		
		map.put("id",id);
		map.put("flag",flag);
		map.put("instituteId", instituteId);
		map.put("designationId", designationId);
		map.put("departmentId", departmentId);
		map.put("cadreId", cadreId);
		String jsp = "resourceRequistion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchResourceReqJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> detailMap = new HashMap<String, Object>();
			Map<String, Object> map2= new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Users user = null;
			//String flag = "true";
			String flag="";
			String id="";
			
			Set<UserManager> usermanagers = new HashSet<UserManager>();
			int hospitalId =0;

			if (session.getAttribute("locationId")!= null) {
				hospitalId = (Integer)session.getAttribute("locationId");
			}
			if (session.getAttribute("users")!= null) {
				user = (Users)session.getAttribute("users");
			}
			int instituteId = 0;
			int cadreId = 0;
			int departmentId = 0;
			int designationId = 0; 
			
			
			if(request.getParameter("institute") != null && !request.getParameter("institute").equals("")){
				instituteId =Integer.parseInt(request.getParameter("institute"));
			}
			System.out.println("instituteId=111==="+instituteId);
			if(request.getParameter("department") != null && !request.getParameter("department").equals("")){
				departmentId =Integer.parseInt(request.getParameter("department"));
			}
			if(request.getParameter("designation") != null && !request.getParameter("designation").equals("")){
				designationId =Integer.parseInt(request.getParameter("designation"));
			}
			if(request.getParameter("cadre") != null && !request.getParameter("cadre").equals("")){
				cadreId =Integer.parseInt(request.getParameter("cadre"));
			}
			
			detailMap.put("hospitalId", hospitalId);
			detailMap.put("instituteId", instituteId);
			detailMap.put("designationId", designationId);
			detailMap.put("departmentId", departmentId);
			detailMap.put("cadreId", cadreId);
			map = recruitmentHandlerService.searchResourceReqJsp(detailMap);
			//map.put("flag", flag);
			
			
			if(request.getParameter("flag") != null){
				flag = request.getParameter("flag");
			}
			if(request.getParameter("id") != null){
				id = request.getParameter("id");
			}
			
			detailMap.put("id", id);
			List manPowerRequisitionList = recruitmentHandlerService.getAllApprovedRequests();
			//List rmsIdList = resumeHandlerService.getRecruitersList("1");
			if(flag != null && ! flag.equals("") && flag.equals("s")){
				//System.out.println("map2"+id);
				
				map2 = recruitmentHandlerService.getEmployeeForPromo(detailMap);
				map.put("map2",map2);
			
			}
			
			//Map map1 = (Map) recruitmentHandlerService.loadObject(MasEmployee.class , 1) ;
			//map.putAll(map1);
			//String jsp = RESOURCE_REQUISITION;
			
			map.put("id",id);
			map.put("flag",flag);
			String jsp = "resourceRequistion";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("instituteId", instituteId);
			map.put("designationId", designationId);
			map.put("departmentId", departmentId);
			map.put("cadreId", cadreId);
			return new ModelAndView("index", "map", map);
		}
	public ModelAndView viewPost(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int rankId = 0;
		int hospitalId =0;
		
		if (session.getAttribute("hospitalId")!= null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		if (request.getParameter("rankId")!= null) {
			rankId = Integer.parseInt(""+request.getParameter("rankId"));
		}
		detailMap.put("hospitalId", hospitalId);
		detailMap.put("rankId", rankId);
		map = recruitmentHandlerService.showPostJsp(detailMap);
		String jsp = "viewpostPopup";
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}

}

