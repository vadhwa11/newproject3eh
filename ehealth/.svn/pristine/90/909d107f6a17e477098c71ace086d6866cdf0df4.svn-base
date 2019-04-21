package jkt.hrms.setup.controller;

import static jkt.hrms.util.HrmsRequestConstants.ACCOUNT_NO_OF_EPF;
import static jkt.hrms.util.HrmsRequestConstants.ADMIN_CHARGE;
import static jkt.hrms.util.HrmsRequestConstants.ADMIN_ON_EDLI;
import static jkt.hrms.util.HrmsRequestConstants.BENEFIT_PERCENTAGE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.DA;
import static jkt.hrms.util.HrmsRequestConstants.EDLI;
import static jkt.hrms.util.HrmsRequestConstants.EPS_MAX_LIMIT;
import static jkt.hrms.util.HrmsRequestConstants.ESI_EMPLOYEE_CONT;
import static jkt.hrms.util.HrmsRequestConstants.ESI_EMPLOYER_CONT;
import static jkt.hrms.util.HrmsRequestConstants.FEMALE_TAX_REBATE;
import static jkt.hrms.util.HrmsRequestConstants.FIN_YR_FOR_LEAVE_CALC;
import static jkt.hrms.util.HrmsRequestConstants.GRATUITY;
import static jkt.hrms.util.HrmsRequestConstants.HEAD_OFFICE_CODE;
import static jkt.hrms.util.HrmsRequestConstants.HOLIDAY1;
import static jkt.hrms.util.HrmsRequestConstants.HOLIDAY2;
import static jkt.hrms.util.HrmsRequestConstants.HOSPITAL_ID;
import static jkt.hrms.util.HrmsRequestConstants.INCLUDE_HOLIDAYS_In_LEAVE;
import static jkt.hrms.util.HrmsRequestConstants.INSPECTION_CHARGE;
import static jkt.hrms.util.HrmsRequestConstants.IN_SERVICE_CODE;
import static jkt.hrms.util.HrmsRequestConstants.LEAVE_ENCASH;
import static jkt.hrms.util.HrmsRequestConstants.NIGHT_SHIFT_END;
import static jkt.hrms.util.HrmsRequestConstants.NIGHT_SHIFT_START;
import static jkt.hrms.util.HrmsRequestConstants.NO_OF_WORKING_DAYS;
import static jkt.hrms.util.HrmsRequestConstants.PAN_NO;
import static jkt.hrms.util.HrmsRequestConstants.PARAMETER_MAINTENANCE_ID;
import static jkt.hrms.util.HrmsRequestConstants.PARAMETER_MAINTENANCE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.PASSWORD_EXPIRY_DAY;
import static jkt.hrms.util.HrmsRequestConstants.PAY_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.PENSION_FUND;
import static jkt.hrms.util.HrmsRequestConstants.RETIREMENT_AGE;
import static jkt.hrms.util.HrmsRequestConstants.SICK_LEAVE_ELIGIBILITY;
import static jkt.hrms.util.HrmsRequestConstants.SUPERANNUATION;
import static jkt.hrms.util.HrmsRequestConstants.TAN_NO;
import static jkt.hrms.util.HrmsRequestConstants.UNUSED_LEAVE_CARY_FWD_OR_ENCASH;
import static jkt.hrms.util.HrmsRequestConstants.VACATION_LEAVE_ELIGIBILITY;
import static jkt.hrms.util.HrmsRequestConstants.VOLUNATRY_CONTR;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasParameterMaintenance;
import jkt.hrms.setup.handler.SetupHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SetupController extends MultiActionController {
	SetupHandlerService setupHandlerService = null;

	public ModelAndView showParameterMaintenanceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		map = setupHandlerService.showParameterMaintenanceJsp(hospitalId);
		String jsp = PARAMETER_MAINTENANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveParameterMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HrMasParameterMaintenance hrMasParameterMaintenance = new HrMasParameterMaintenance();

		if (request.getParameter(INSPECTION_CHARGE) != null
				&& !request.getParameter(INSPECTION_CHARGE).equals("")) {
			Float inspectionCharge = Float.parseFloat(request
					.getParameter(INSPECTION_CHARGE));
			hrMasParameterMaintenance.setInspectionCharge(inspectionCharge);
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			int hospitalId = Integer
					.parseInt(request.getParameter(HOSPITAL_ID));
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasParameterMaintenance.setHospital(masHospital);
		}
		if (request.getParameter(DA) != null) {
			String da = request.getParameter(DA);
			hrMasParameterMaintenance.setDa(da);
		}

		if (request.getParameter(EPS_MAX_LIMIT) != null) {
			BigDecimal epsMaxLimit = new BigDecimal(
					request.getParameter(EPS_MAX_LIMIT));
			hrMasParameterMaintenance.setEpsMaxLimit(epsMaxLimit);
		}
		if (request.getParameter(EDLI) != null
				&& !request.getParameter(EDLI).equals("")) {
			Float edli = Float.parseFloat(request.getParameter(EDLI));
			hrMasParameterMaintenance.setEdli(edli);
		}

		if (request.getParameter(ADMIN_CHARGE) != null
				&& !request.getParameter(ADMIN_CHARGE).equals("")) {
			Float adminCharge = Float.parseFloat(request
					.getParameter(ADMIN_CHARGE));
			hrMasParameterMaintenance.setAdminCharge(adminCharge);
		}
		if (request.getParameter(HEAD_OFFICE_CODE) != null) {
			String headOfficeCode = request.getParameter(HEAD_OFFICE_CODE);
			hrMasParameterMaintenance.setHeadOfficeCode(headOfficeCode);
		}

		if (request.getParameter(IN_SERVICE_CODE) != null) {
			int inServiceCode = Integer.parseInt(request
					.getParameter(IN_SERVICE_CODE));
			hrMasParameterMaintenance.setInServiceCode(inServiceCode);
		}

		if (request.getParameter(LEAVE_ENCASH) != null) {
			int leaveEncash = Integer.parseInt(request
					.getParameter(LEAVE_ENCASH));
			hrMasParameterMaintenance.setLeaveEncash(leaveEncash);
		}
		if (request.getParameter(PAY_TYPE) != null) {
			int payType = Integer.parseInt(request.getParameter(PAY_TYPE));
			hrMasParameterMaintenance.setPayType(payType);
		}

		if (request.getParameter(NO_OF_WORKING_DAYS) != null) {
			int noOfWorkingDays = Integer.parseInt(request
					.getParameter(NO_OF_WORKING_DAYS));
			hrMasParameterMaintenance.setNoOfWorkingDays(noOfWorkingDays);
		}
		if (request.getParameter(RETIREMENT_AGE) != null) {
			int retirementAge = Integer.parseInt(request
					.getParameter(RETIREMENT_AGE));
			hrMasParameterMaintenance.setRetirementAge(retirementAge);
		}
		if (request.getParameter(VOLUNATRY_CONTR) != null) {
			String volunatryContr = request.getParameter(VOLUNATRY_CONTR);
			hrMasParameterMaintenance.setVolunatryContr(volunatryContr);
		}
		if (request.getParameter(HOLIDAY1) != null) {
			String saturdayHoliday = request.getParameter(HOLIDAY1);
			hrMasParameterMaintenance.setHoliday1(saturdayHoliday);
		}
		if (request.getParameter(HOLIDAY2) != null) {
			String sundayHoliday = request.getParameter(HOLIDAY2);
			hrMasParameterMaintenance.setHoliday2(sundayHoliday);
		}
		if (request.getParameter(GRATUITY) != null
				&& !request.getParameter(VOLUNATRY_CONTR).equals("")) {
			Float gratuity = Float.parseFloat(request.getParameter(GRATUITY));
			hrMasParameterMaintenance.setGratuity(gratuity);
		}
		if (request.getParameter(SUPERANNUATION) != null
				&& !request.getParameter(SUPERANNUATION).equals("")) {
			Float superannuation = Float.parseFloat(request
					.getParameter(SUPERANNUATION));
			hrMasParameterMaintenance.setSuperannuation(superannuation);
		}
		if (request.getParameter(PASSWORD_EXPIRY_DAY) != null) {
			int passwordExpiryDay = Integer.parseInt(request
					.getParameter(PASSWORD_EXPIRY_DAY));
			hrMasParameterMaintenance.setPasswordExpiryDay(passwordExpiryDay);
		}

		if (request.getParameter(ADMIN_ON_EDLI) != null
				&& !request.getParameter(ADMIN_ON_EDLI).equals("")) {
			Float adminOnEdli = Float.parseFloat(request
					.getParameter(ADMIN_ON_EDLI));
			hrMasParameterMaintenance.setAdminOnEdli(adminOnEdli);
		}
		if (request.getParameter(PENSION_FUND) != null
				&& !request.getParameter(PENSION_FUND).equals("")) {
			Float pensionFund = Float.parseFloat(request
					.getParameter(PENSION_FUND));
			hrMasParameterMaintenance.setPensionFund(pensionFund);
		}
		if (request.getParameter(ACCOUNT_NO_OF_EPF) != null) {
			String accountNoOfEpf = request.getParameter(ACCOUNT_NO_OF_EPF);
			hrMasParameterMaintenance.setAccountNoOfEpf(accountNoOfEpf);
		}

		if (request.getParameter(FEMALE_TAX_REBATE) != null) {
			BigDecimal femaleTaxRebate = new BigDecimal(
					request.getParameter(FEMALE_TAX_REBATE));
			hrMasParameterMaintenance.setFemaleTaxRebate(femaleTaxRebate);
		}
		if (request.getParameter(PAN_NO) != null) {
			String panNo = request.getParameter(PAN_NO);
			hrMasParameterMaintenance.setPanNo(panNo);
		}

		if (request.getParameter(TAN_NO) != null) {
			String tanNo = request.getParameter(TAN_NO);
			hrMasParameterMaintenance.setTanNo(tanNo);
		}

		if (request.getParameter(ESI_EMPLOYEE_CONT) != null
				&& !request.getParameter(ESI_EMPLOYEE_CONT).equals("")) {
			Float esiEmployeeCont = Float.parseFloat(request
					.getParameter(ESI_EMPLOYEE_CONT));
			hrMasParameterMaintenance.setEsiEmployeeCont(esiEmployeeCont);
		}
		if (request.getParameter(ESI_EMPLOYER_CONT) != null
				&& !request.getParameter(ESI_EMPLOYER_CONT).equals("")) {
			Float esiEmployerCont = Float.parseFloat(request
					.getParameter(ESI_EMPLOYER_CONT));
			hrMasParameterMaintenance.setEsiEmployerCont(esiEmployerCont);
		}
		if (request.getParameter(NIGHT_SHIFT_START) != null) {
			String nightShiftStart = request.getParameter(NIGHT_SHIFT_START);
			hrMasParameterMaintenance.setNightShiftStart(nightShiftStart);
		}
		if (request.getParameter(NIGHT_SHIFT_END) != null) {
			String nightShiftEnd = request.getParameter(NIGHT_SHIFT_END);
			hrMasParameterMaintenance.setNightShiftEnd(nightShiftEnd);
		}
		if (request.getParameter(BENEFIT_PERCENTAGE) != null
				&& !request.getParameter(BENEFIT_PERCENTAGE).equals("")) {
			Float benefitPercentage = Float.parseFloat(request
					.getParameter(BENEFIT_PERCENTAGE));
			hrMasParameterMaintenance.setBenefitPercentage(benefitPercentage);
		}
		if (request.getParameter(FIN_YR_FOR_LEAVE_CALC) != null) {
			hrMasParameterMaintenance.setFinYrForLeaveCalc("y");
		} else {
			hrMasParameterMaintenance.setFinYrForLeaveCalc("n");
		}

		if (request.getParameter(INCLUDE_HOLIDAYS_In_LEAVE) != null) {
			hrMasParameterMaintenance.setIncludeHolidaysInLeave("y");
		} else {
			hrMasParameterMaintenance.setIncludeHolidaysInLeave("n");
		}

		if (request.getParameter(UNUSED_LEAVE_CARY_FWD_OR_ENCASH) != null) {
			hrMasParameterMaintenance.setUnusdLeaveCaryFwdOrEncash("y");
		} else {
			hrMasParameterMaintenance.setUnusdLeaveCaryFwdOrEncash("n");
		}

		if (request.getParameter(SICK_LEAVE_ELIGIBILITY) != null) {
			hrMasParameterMaintenance.setSickLeaveEligibilty("y");
		} else {
			hrMasParameterMaintenance.setSickLeaveEligibilty("n");
		}

		if (request.getParameter(VACATION_LEAVE_ELIGIBILITY) != null) {
			hrMasParameterMaintenance.setVacationLeaveEligibilty("y");
		} else {
			hrMasParameterMaintenance.setVacationLeaveEligibilty("n");
		}
		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			hrMasParameterMaintenance.setLastChgBy(lastchangeBy);
		}
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			hrMasParameterMaintenance.setLastChgDate(currentDate);
		}

		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			hrMasParameterMaintenance.setLastChgTime(currentTime);
		}


		hrMasParameterMaintenance.setStatus("y");

		map = setupHandlerService
				.saveParameterMaintenance(hrMasParameterMaintenance);
		String jsp = PARAMETER_MAINTENANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView upDateParameterMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int parameterMaintenanceId = 0;
		if (request.getParameter(PARAMETER_MAINTENANCE_ID) != null) {
			parameterMaintenanceId = Integer.parseInt(request
					.getParameter(PARAMETER_MAINTENANCE_ID));
		}
		generalMap.put("parameterMaintenanceId", parameterMaintenanceId);
		if (request.getParameter(INSPECTION_CHARGE) != null
				&& !request.getParameter(INSPECTION_CHARGE).equals("")) {
			Float inspectionCharge = Float.parseFloat(request
					.getParameter(INSPECTION_CHARGE));
			generalMap.put("inspectionCharge", inspectionCharge);
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			int hospitalId = Integer
					.parseInt(request.getParameter(HOSPITAL_ID));
			generalMap.put("hospitalId", hospitalId);

		}
		if (request.getParameter(DA) != null) {
			String da = request.getParameter(DA);
			generalMap.put("da", da);
		}

		if (request.getParameter(EPS_MAX_LIMIT) != null) {
			BigDecimal epsMaxLimit = new BigDecimal(
					request.getParameter(EPS_MAX_LIMIT));
			generalMap.put("epsMaxLimit", epsMaxLimit);
		}
		if (request.getParameter(EDLI) != null
				&& !request.getParameter(EDLI).equals("")) {
			Float edli = Float.parseFloat(request.getParameter(EDLI));
			generalMap.put("edli", edli);
		}

		if (request.getParameter(ADMIN_CHARGE) != null
				&& !request.getParameter(ADMIN_CHARGE).equals("")) {
			Float adminCharge = Float.parseFloat(request
					.getParameter(ADMIN_CHARGE));
			generalMap.put("adminCharge", adminCharge);
		}
		if (request.getParameter(HEAD_OFFICE_CODE) != null) {
			String headOfficeCode = request.getParameter(HEAD_OFFICE_CODE);
			generalMap.put("headOfficeCode", headOfficeCode);
		}

		if (request.getParameter(IN_SERVICE_CODE) != null) {
			int inServiceCode = Integer.parseInt(request
					.getParameter(IN_SERVICE_CODE));
			generalMap.put("inServiceCode", inServiceCode);
		}

		if (request.getParameter(LEAVE_ENCASH) != null) {
			int leaveEncash = Integer.parseInt(request
					.getParameter(LEAVE_ENCASH));
			generalMap.put("leaveEncash", leaveEncash);
		}
		if (request.getParameter(PAY_TYPE) != null) {
			int payType = Integer.parseInt(request.getParameter(PAY_TYPE));
			generalMap.put("payType", payType);
		}

		if (request.getParameter(NO_OF_WORKING_DAYS) != null) {
			int noOfWorkingDays = Integer.parseInt(request
					.getParameter(NO_OF_WORKING_DAYS));
			generalMap.put("noOfWorkingDays", noOfWorkingDays);
		}
		if (request.getParameter(RETIREMENT_AGE) != null) {
			int retirementAge = Integer.parseInt(request
					.getParameter(RETIREMENT_AGE));
			generalMap.put("retirementAge", retirementAge);
		}
		if (request.getParameter(VOLUNATRY_CONTR) != null) {
			String volunatryContr = request.getParameter(VOLUNATRY_CONTR);
			generalMap.put("volunatryContr", volunatryContr);
		}
		if (request.getParameter(HOLIDAY1) != null) {
			String saturdayHoliday = request.getParameter(HOLIDAY1);
			generalMap.put("saturdayHoliday", saturdayHoliday);
		}
		if (request.getParameter(HOLIDAY2) != null) {
			String sundayHoliday = request.getParameter(HOLIDAY2);
			generalMap.put("sundayHoliday", sundayHoliday);
		}
		if (request.getParameter(GRATUITY) != null
				&& !request.getParameter(VOLUNATRY_CONTR).equals("")) {
			Float gratuity = Float.parseFloat(request.getParameter(GRATUITY));
			generalMap.put("gratuity", gratuity);
		}
		if (request.getParameter(SUPERANNUATION) != null
				&& !request.getParameter(SUPERANNUATION).equals("")) {
			Float superannuation = Float.parseFloat(request
					.getParameter(SUPERANNUATION));
			generalMap.put("superannuation", superannuation);
		}
		if (request.getParameter(PASSWORD_EXPIRY_DAY) != null) {
			int passwordExpiryDay = Integer.parseInt(request
					.getParameter(PASSWORD_EXPIRY_DAY));
			generalMap.put("passwordExpiryDay", passwordExpiryDay);
		}

		if (request.getParameter(ADMIN_ON_EDLI) != null
				&& !request.getParameter(ADMIN_ON_EDLI).equals("")) {
			Float adminOnEdli = Float.parseFloat(request
					.getParameter(ADMIN_ON_EDLI));
			generalMap.put("adminOnEdli", adminOnEdli);
		}
		if (request.getParameter(PENSION_FUND) != null
				&& !request.getParameter(PENSION_FUND).equals("")) {
			Float pensionFund = Float.parseFloat(request
					.getParameter(PENSION_FUND));
			generalMap.put("pensionFund", pensionFund);
		}
		if (request.getParameter(ACCOUNT_NO_OF_EPF) != null) {
			String accountNoOfEpf = request.getParameter(ACCOUNT_NO_OF_EPF);
			generalMap.put("accountNoOfEpf", accountNoOfEpf);
		}

		if (request.getParameter(FEMALE_TAX_REBATE) != null) {
			BigDecimal femaleTaxRebate = new BigDecimal(
					request.getParameter(FEMALE_TAX_REBATE));
			generalMap.put("femaleTaxRebate", femaleTaxRebate);
		}
		if (request.getParameter(PAN_NO) != null) {
			String panNo = request.getParameter(PAN_NO);
			generalMap.put("panNo", panNo);
		}

		if (request.getParameter(TAN_NO) != null) {
			String tanNo = request.getParameter(TAN_NO);
			generalMap.put("tanNo", tanNo);
		}

		if (request.getParameter(ESI_EMPLOYEE_CONT) != null
				&& !request.getParameter(ESI_EMPLOYEE_CONT).equals("")) {
			Float esiEmployeeCont = Float.parseFloat(request
					.getParameter(ESI_EMPLOYEE_CONT));
			generalMap.put("esiEmployeeCont", esiEmployeeCont);
		}
		if (request.getParameter(ESI_EMPLOYER_CONT) != null
				&& !request.getParameter(ESI_EMPLOYER_CONT).equals("")) {
			Float esiEmployerCont = Float.parseFloat(request
					.getParameter(ESI_EMPLOYER_CONT));
			generalMap.put("esiEmployerCont", esiEmployerCont);
		}
		if (request.getParameter(NIGHT_SHIFT_START) != null) {
			String nightShiftStart = request.getParameter(NIGHT_SHIFT_START);
			generalMap.put("nightShiftStart", nightShiftStart);
		}
		if (request.getParameter(NIGHT_SHIFT_END) != null) {
			String nightShiftEnd = request.getParameter(NIGHT_SHIFT_END);
			generalMap.put("nightShiftEnd", nightShiftEnd);
		}
		if (request.getParameter(BENEFIT_PERCENTAGE) != null
				&& !request.getParameter(BENEFIT_PERCENTAGE).equals("")) {
			Float benefitPercentage = Float.parseFloat(request
					.getParameter(BENEFIT_PERCENTAGE));
			generalMap.put("benefitPercentage", benefitPercentage);
		}

		String finalYrLeaveCalc = "";
		if (request.getParameter(FIN_YR_FOR_LEAVE_CALC) != null) {
			finalYrLeaveCalc = "y";
		} else {
			finalYrLeaveCalc = "n";
		}
		generalMap.put("finalYrLeaveCalc", finalYrLeaveCalc);

		String includeHolidaysInLeave = "";
		if (request.getParameter(INCLUDE_HOLIDAYS_In_LEAVE) != null) {
			includeHolidaysInLeave = "y";
		} else {
			includeHolidaysInLeave = "n";
		}
		generalMap.put("includeHolidaysInLeave", includeHolidaysInLeave);

		String unusdLeaveForCaryOrEncash = "";
		if (request.getParameter(UNUSED_LEAVE_CARY_FWD_OR_ENCASH) != null) {
			unusdLeaveForCaryOrEncash = "y";
		} else {
			unusdLeaveForCaryOrEncash = "n";
		}
		generalMap.put("unusdLeaveForCaryOrEncash", unusdLeaveForCaryOrEncash);

		String sickLeaveEligibility = "";
		if (request.getParameter(SICK_LEAVE_ELIGIBILITY) != null) {
			sickLeaveEligibility = "y";
		} else {
			sickLeaveEligibility = "n";
		}
		generalMap.put("sickLeaveEligibility", sickLeaveEligibility);

		String vacationLeaveEligibility = "";
		if (request.getParameter(VACATION_LEAVE_ELIGIBILITY) != null) {
			vacationLeaveEligibility = "y";
		} else {
			vacationLeaveEligibility = "n";
		}
		generalMap.put("vacationLeaveEligibility", vacationLeaveEligibility);

		if (request.getParameter(CHANGED_BY) != null) {
			String lastchangeBy = request.getParameter(CHANGED_BY);
			generalMap.put("lastchangeBy", lastchangeBy);

		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			generalMap.put("changedDate", changedDate);
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			generalMap.put("changedTime", changedTime);
		}
		map = setupHandlerService.upDateParameterMaintenance(generalMap);

		String jsp = PARAMETER_MAINTENANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public SetupHandlerService getSetupHandlerService() {
		return setupHandlerService;
	}

	public void setSetupHandlerService(SetupHandlerService setupHandlerService) {
		this.setupHandlerService = setupHandlerService;
	}

}
