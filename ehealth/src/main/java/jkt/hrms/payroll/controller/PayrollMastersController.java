package jkt.hrms.payroll.controller;

import static jkt.hrms.util.HrmsRequestConstants.ARREAR_ELEMENT;
import static jkt.hrms.util.HrmsRequestConstants.BASIC_DEPENDENT;
import static jkt.hrms.util.HrmsRequestConstants.BASIC_MULTIPLIER;
import static jkt.hrms.util.HrmsRequestConstants.BONUS_RATE;
import static jkt.hrms.util.HrmsRequestConstants.BONUS_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.CARRY_FORWARD;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CODE;
import static jkt.hrms.util.HrmsRequestConstants.COMMON_ID;
import static jkt.hrms.util.HrmsRequestConstants.CTC_HEADING;
import static jkt.hrms.util.HrmsRequestConstants.DUE_DATE;
import static jkt.hrms.util.HrmsRequestConstants.EFFECTIVE_DATE;
import static jkt.hrms.util.HrmsRequestConstants.FIXED_AMOUNT;
import static jkt.hrms.util.HrmsRequestConstants.FROM_DATE;
import static jkt.hrms.util.HrmsRequestConstants.GRADE_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_BONUS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_LOAN_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_PAYELEMENT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_PAYROLL_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_REIMBERSEMENT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.INTEREST_PERCENT;
import static jkt.hrms.util.HrmsRequestConstants.MAXIMUM_AMOUNT;
import static jkt.hrms.util.HrmsRequestConstants.MAX_BASIC;
import static jkt.hrms.util.HrmsRequestConstants.MAX_TAX_EXEMPTION;
import static jkt.hrms.util.HrmsRequestConstants.OT_CALCULATION;
import static jkt.hrms.util.HrmsRequestConstants.PAYMENT_FREQUENCY;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_STATUS;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.PF_DEPENDENT;
import static jkt.hrms.util.HrmsRequestConstants.REIMB_ELEMENT;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_FIELD;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_NAME;
import static jkt.hrms.util.HrmsRequestConstants.SELECTED_RADIO;
import static jkt.hrms.util.HrmsRequestConstants.STATUS_DATE;
import static jkt.hrms.util.HrmsRequestConstants.TAXABLE;
import static jkt.hrms.util.HrmsRequestConstants.TO_DATE;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasBonus;
import jkt.hrms.masters.business.HrMasLoan;
import jkt.hrms.masters.business.HrMasPayElement;
import jkt.hrms.masters.business.HrMasPayroll;
import jkt.hrms.masters.business.HrMasReimbersement;
import jkt.hrms.payroll.handler.PayrollMastersHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PayrollMastersController extends MultiActionController {
	PayrollMastersHandlerService payrollMastersHandlerService = null;

	public PayrollMastersHandlerService getPayrollMastersHandlerService() {
		return payrollMastersHandlerService;
	}

	public void setPayrollMastersHandlerService(
			PayrollMastersHandlerService payrollMastersHandlerService) {
		this.payrollMastersHandlerService = payrollMastersHandlerService;
	}

	public ModelAndView showBonusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollMastersHandlerService.showBonusJsp();
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveBonus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasBonus hrMasBonus = new HrMasBonus();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasBonus.setHospital(masHospital);
		}
		String bonusCode = "";
		if (request.getParameter(CODE) != null) {
			bonusCode = request.getParameter(CODE);
		}
		hrMasBonus.setBonusCode(bonusCode);
		String bonusDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			bonusDescription = request.getParameter(SEARCH_NAME);
		}
		hrMasBonus.setDescription(bonusDescription);
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		hrMasBonus.setFromDate(fromDate);
		Date toDate = new Date();
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}
		hrMasBonus.setToDate(toDate);
		Date dueDate = new Date();
		if (request.getParameter(DUE_DATE) != null
				&& !(request.getParameter(DUE_DATE).equals(""))) {
			dueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DUE_DATE));
		}
		hrMasBonus.setDueDate(dueDate);

		String bonusType = "";
		if (request.getParameter(BONUS_TYPE) != null) {
			bonusType = request.getParameter(BONUS_TYPE);
			hrMasBonus.setBonusType(bonusType);
		}
		String paymentFrequency = "";
		if (request.getParameter(PAYMENT_FREQUENCY) != null) {
			paymentFrequency = request.getParameter(PAYMENT_FREQUENCY);
		}
		hrMasBonus.setPaymentFrequency(paymentFrequency);
		Float bonusRate = null;
		if (request.getParameter(BONUS_RATE) != null
				&& !request.getParameter(BONUS_RATE).equals("")) {
			bonusRate = Float.parseFloat(request.getParameter(BONUS_RATE));
			hrMasBonus.setBonusRate(bonusRate);
		}
		if (request.getParameter(FIXED_AMOUNT) != null
				&& !request.getParameter(FIXED_AMOUNT).equals("")) {
			BigDecimal fixedAmount = new BigDecimal(
					request.getParameter(FIXED_AMOUNT));
			hrMasBonus.setFixedAmount(fixedAmount);
		}
		if (request.getParameter(MAX_BASIC) != null
				&& !request.getParameter(MAX_BASIC).equals("")) {
			BigDecimal maxBasic = new BigDecimal(
					request.getParameter(MAX_BASIC));
			hrMasBonus.setMaxBasic(maxBasic);
		}
		if (request.getParameter(TAXABLE) != null) {
			hrMasBonus.setTaxable("y");
		} else {
			hrMasBonus.setTaxable("n");
		}

		if (request.getParameter(GRADE_ID) != null
				&& !(request.getParameter(GRADE_ID).equals("0"))) {
			int gradeId = Integer.parseInt(request.getParameter(GRADE_ID));
			MasGrade masGrade = new MasGrade();
			masGrade.setId(gradeId);
			hrMasBonus.setGrade(masGrade);
		}

		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		hrMasBonus.setLastChgBy(changedBy);
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		hrMasBonus.setLastChgDate(currentDate);
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		hrMasBonus.setStatus("y");
		hrMasBonus.setLastChgTime(currentTime);
		map = payrollMastersHandlerService.saveBonus(hrMasBonus);
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBonus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int bonusId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bonusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		String bonusCode = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bonusCode = request.getParameter(CODE);
		}
		String bonusDescription = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bonusDescription = request.getParameter(SEARCH_NAME);
		}
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}

		Date toDate = new Date();
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}

		Date dueDate = new Date();
		if (request.getParameter(DUE_DATE) != null
				&& !(request.getParameter(DUE_DATE).equals(""))) {
			dueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DUE_DATE));
		}
		String bonusType = "";
		if (request.getParameter(BONUS_TYPE) != null) {
			bonusType = request.getParameter(BONUS_TYPE);
		}
		String paymentFrequency = "";
		if (request.getParameter(PAYMENT_FREQUENCY) != null) {
			paymentFrequency = request.getParameter(PAYMENT_FREQUENCY);
		}
		Float bonusRate = null;
		if (request.getParameter(BONUS_RATE) != null
				&& !request.getParameter(BONUS_RATE).equals("")) {
			bonusRate = Float.parseFloat(request.getParameter(BONUS_RATE));
		}

		BigDecimal fixedAmount = null;
		if (request.getParameter(FIXED_AMOUNT) != null
				&& !request.getParameter(FIXED_AMOUNT).equals("")) {
			fixedAmount = new BigDecimal(request.getParameter(FIXED_AMOUNT));
		}
		BigDecimal maxBasic = null;
		if (request.getParameter(MAX_BASIC) != null
				&& !request.getParameter(MAX_BASIC).equals("")) {
			maxBasic = new BigDecimal(request.getParameter(MAX_BASIC));
		}
		String taxable = "";
		if (request.getParameter(TAXABLE) != null) {
			taxable = "y";
		} else {
			taxable = "n";
		}
		int gradeId = 0;

		if (request.getParameter(GRADE_ID) != null
				&& !request.getParameter(GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(GRADE_ID));
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("bonusId", bonusId);
		generalMap.put("bonusCode", bonusCode);
		generalMap.put("bonusDescription", bonusDescription);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		generalMap.put("dueDate", dueDate);
		generalMap.put("bonusType", bonusType);
		generalMap.put("paymentFrequency", paymentFrequency);
		generalMap.put("bonusRate", bonusRate);
		generalMap.put("fixedAmount", fixedAmount);
		generalMap.put("gradeId", gradeId);
		generalMap.put("maxBasic", maxBasic);
		generalMap.put("taxable", taxable);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		map = payrollMastersHandlerService.editBonus(generalMap);

		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBonus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int bonusId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bonusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("bonusId", bonusId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		map = payrollMastersHandlerService.deleteBonus(generalMap);
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBonus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String bonusCode = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bonusCode = request.getParameter(CODE);
		}
		String bonusDescription = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bonusDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		String searchField = "";
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			bonusCode = searchField;
			bonusDescription = null;

		} else {
			bonusCode = null;
			bonusDescription = searchField;
		}
		map = payrollMastersHandlerService.searchBonus(bonusCode,
				bonusDescription);
		String jsp = HR_BONUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showLoanJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollMastersHandlerService.showLoanJsp();
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveLoan(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasLoan hrMasLoan = new HrMasLoan();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasLoan.setHospital(masHospital);
		}
		String loanCode = "";
		if (request.getParameter(CODE) != null) {
			loanCode = request.getParameter(CODE);
		}
		hrMasLoan.setLoanCode(loanCode);
		String loanDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			loanDescription = request.getParameter(SEARCH_NAME);
		}
		hrMasLoan.setLoanDescription(loanDescription);

		BigDecimal maxAmount = null;
		if (request.getParameter(MAXIMUM_AMOUNT) != null) {
			maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
		}
		hrMasLoan.setMaxAmount(maxAmount);
		Float interestPercent = null;
		if (request.getParameter(INTEREST_PERCENT) != null
				&& !request.getParameter(INTEREST_PERCENT).equals("")) {
			interestPercent = Float.parseFloat(request
					.getParameter(INTEREST_PERCENT));
		}
		hrMasLoan.setInterestPercent(interestPercent);
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		hrMasLoan.setLastChgBy(changedBy);
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		hrMasLoan.setLastChgDate(currentDate);
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		hrMasLoan.setLastChgTime(currentTime);
		hrMasLoan.setStatus("y");
		map = payrollMastersHandlerService.saveLoan(hrMasLoan);
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editLoan(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int loanId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			loanId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		generalMap.put("loanId", loanId);
		String loanCode = "";
		if (request.getParameter(CODE) != null) {
			loanCode = request.getParameter(CODE);
		}
		generalMap.put("loanCode", loanCode);
		String loanDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			loanDescription = request.getParameter(SEARCH_NAME);
		}
		generalMap.put("loanDescription", loanDescription);

		BigDecimal maxAmount = null;
		if (request.getParameter(MAXIMUM_AMOUNT) != null) {
			maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
		}
		generalMap.put("maxAmount", maxAmount);
		Float interestPercent = null;
		if (request.getParameter(INTEREST_PERCENT) != null
				&& !request.getParameter(INTEREST_PERCENT).equals("")) {
			interestPercent = Float.parseFloat(request
					.getParameter(INTEREST_PERCENT));
		}
		generalMap.put("interestPercent", interestPercent);
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		generalMap.put("changedBy", changedBy);
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		generalMap.put("currentDate", currentDate);
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("currentTime", currentTime);
		map = payrollMastersHandlerService.editLoan(generalMap);
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteLoan(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int loanId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			loanId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("loanId", loanId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		map = payrollMastersHandlerService.deleteLoan(generalMap);
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchLoan(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String loanCode = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			loanCode = request.getParameter(CODE);
		}
		String loanDescription = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			loanDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		String searchField = "";
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			loanCode = searchField;
			loanDescription = null;

		} else {
			loanCode = null;
			loanDescription = searchField;
		}
		map = payrollMastersHandlerService
				.searchLoan(loanCode, loanDescription);
		String jsp = HR_LOAN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPayrollJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollMastersHandlerService.showPayrollJsp();
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView savePayroll(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasPayroll hrMasPayroll = new HrMasPayroll();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasPayroll.setHospital(masHospital);
		}
		String payrollCode = "";
		if (request.getParameter(CODE) != null) {
			payrollCode = request.getParameter(CODE);
		}
		hrMasPayroll.setPayrollCode(payrollCode);
		String payrollDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			payrollDescription = request.getParameter(SEARCH_NAME);
		}
		hrMasPayroll.setPayrollDescription(payrollDescription);
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		hrMasPayroll.setFromDate(fromDate);
		Date toDate = new Date();
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}
		hrMasPayroll.setToDate(toDate);
		String frequency = "";
		if (request.getParameter(PAYMENT_FREQUENCY) != null) {
			frequency = request.getParameter(PAYMENT_FREQUENCY);
		}
		hrMasPayroll.setFrequency(frequency);
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		hrMasPayroll.setLastChgBy(changedBy);
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		hrMasPayroll.setLastChgDate(currentDate);
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		hrMasPayroll.setLastChgTime(currentTime);
		hrMasPayroll.setStatus("y");
		map = payrollMastersHandlerService.savePayroll(hrMasPayroll);
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editPayroll(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int payrollId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			payrollId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		generalMap.put("payrollId", payrollId);
		String payrollCode = "";
		if (request.getParameter(CODE) != null) {
			payrollCode = request.getParameter(CODE);
		}
		generalMap.put("payrollCode", payrollCode);
		String payrollDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			payrollDescription = request.getParameter(SEARCH_NAME);
		}
		generalMap.put("payrollDescription", payrollDescription);
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		generalMap.put("fromDate", fromDate);
		Date toDate = new Date();
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}
		generalMap.put("toDate", toDate);
		String frequency = "";
		if (request.getParameter(PAYMENT_FREQUENCY) != null) {
			frequency = request.getParameter(PAYMENT_FREQUENCY);
		}
		generalMap.put("frequency", frequency);
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		generalMap.put("changedBy", changedBy);
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		generalMap.put("currentDate", currentDate);
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("currentTime", currentTime);

		map = payrollMastersHandlerService.editPayroll(generalMap);

		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletePayroll(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int payrollId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			payrollId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("payrollId", payrollId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		map = payrollMastersHandlerService.deletePayroll(generalMap);
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPayroll(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String payrollCode = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			payrollCode = request.getParameter(CODE);
		}
		String payrollDescription = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			payrollDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		String searchField = "";
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			payrollCode = searchField;
			payrollDescription = null;

		} else {
			payrollCode = null;
			payrollDescription = searchField;
		}
		map = payrollMastersHandlerService.searchPayroll(payrollCode,
				payrollDescription);
		String jsp = HR_PAYROLL_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPayElementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = payrollMastersHandlerService.showPayElementJsp();
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView savePayElement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasPayElement hrMasPayElement = new HrMasPayElement();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasPayElement.setHospital(masHospital);
		}
		String payElementCode = "";
		if (request.getParameter(CODE) != null) {
			payElementCode = request.getParameter(CODE);
		}
		hrMasPayElement.setPayElementCode(payElementCode);
		String payElementDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			payElementDescription = request.getParameter(SEARCH_NAME);
		}
		hrMasPayElement.setPayElementDesc(payElementDescription);
		Date effectiveDate = new Date();
		if (request.getParameter(EFFECTIVE_DATE) != null
				&& !(request.getParameter(EFFECTIVE_DATE).equals(""))) {
			effectiveDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EFFECTIVE_DATE));
		}
		hrMasPayElement.setEffectiveDate(effectiveDate);
		String payElementType = "";
		if (request.getParameter(PAY_ELEMENT_TYPE) != null) {
			payElementType = request.getParameter(PAY_ELEMENT_TYPE);
		}
		hrMasPayElement.setPayElementType(payElementType);
		if (request.getParameter(TAXABLE) != null) {
			hrMasPayElement.setTaxableElement("y");
		} else {
			hrMasPayElement.setTaxableElement("n");
		}

		if (request.getParameter(OT_CALCULATION) != null) {
			hrMasPayElement.setOtCalculation("y");
		} else {
			hrMasPayElement.setOtCalculation("n");
		}

		Float basicMultiplier = 0.0f;
		if (request.getParameter(BASIC_MULTIPLIER) != null
				&& !(request.getParameter(BASIC_MULTIPLIER).equals(""))) {
			basicMultiplier = Float.parseFloat(request
					.getParameter(BASIC_MULTIPLIER));
		}
		hrMasPayElement.setBasicMultiplier(basicMultiplier);
		if (request.getParameter(ARREAR_ELEMENT) != null) {
			hrMasPayElement.setArrearElement("y");
		} else {
			hrMasPayElement.setArrearElement("n");
		}

		if (request.getParameter(REIMB_ELEMENT) != null) {
			hrMasPayElement.setReimbElement("y");
		} else {
			hrMasPayElement.setReimbElement("n");
		}

		if (request.getParameter(BASIC_DEPENDENT) != null) {
			hrMasPayElement.setBasicDependent("y");
		} else {
			hrMasPayElement.setBasicDependent("n");
		}
		if (request.getParameter(PF_DEPENDENT) != null) {
			hrMasPayElement.setPfDependent("y");
		} else {
			hrMasPayElement.setPfDependent("n");
		}
		BigDecimal maxAmount = null;

		if (request.getParameter(MAXIMUM_AMOUNT) != null
				&& !request.getParameter(MAXIMUM_AMOUNT).equals("")) {
			maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));
			hrMasPayElement.setMaxAmount(maxAmount);
		}
		String ctcHeading = "";
		if (request.getParameter(CTC_HEADING) != null) {
			ctcHeading = request.getParameter(CTC_HEADING);
		}
		hrMasPayElement.setCTCHeading(ctcHeading);

		String payElementStatus = "";
		if (request.getParameter(PAY_ELEMENT_STATUS) != null) {
			payElementStatus = request.getParameter(PAY_ELEMENT_STATUS);
		}
		hrMasPayElement.setPayElementStatus(payElementStatus);
		Date statusDate = new Date();
		if (request.getParameter(STATUS_DATE) != null
				&& !(request.getParameter(STATUS_DATE).equals(""))) {
			statusDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(STATUS_DATE));
		}
		hrMasPayElement.setStatusDate(statusDate);
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		hrMasPayElement.setLastChgBy(changedBy);
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		hrMasPayElement.setLastChgDate(currentDate);
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		hrMasPayElement.setLastChgTime(currentTime);
		hrMasPayElement.setStatus("y");

		map = payrollMastersHandlerService.savePayElement(hrMasPayElement);
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editPayElement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int payElementId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			payElementId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		generalMap.put("payElementId", payElementId);
		String payElementCode = "";
		if (request.getParameter(CODE) != null) {
			payElementCode = request.getParameter(CODE);
		}
		generalMap.put("payElementCode", payElementCode);
		String payElementDescription = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			payElementDescription = request.getParameter(SEARCH_NAME);
		}
		generalMap.put("payElementDescription", payElementDescription);

		Date effectiveDate = new Date();
		if (request.getParameter(EFFECTIVE_DATE) != null
				&& !(request.getParameter(EFFECTIVE_DATE).equals(""))) {
			effectiveDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EFFECTIVE_DATE));
		}
		generalMap.put("effectiveDate", effectiveDate);
		String payElementType = "";
		if (request.getParameter(PAY_ELEMENT_TYPE) != null) {
			payElementType = request.getParameter(PAY_ELEMENT_TYPE);
		}
		generalMap.put("payElementType", payElementType);
		String taxableElement = "";
		if (request.getParameter(TAXABLE) != null) {
			taxableElement = "y";
		} else {
			taxableElement = "n";
		}
		generalMap.put("taxableElement", taxableElement);

		String otCalculation = "";
		if (request.getParameter(OT_CALCULATION) != null) {
			otCalculation = "y";
		} else {
			otCalculation = "n";
		}
		generalMap.put("otCalculation", otCalculation);
		Float basicMultiplier = 0.0f;
		if (request.getParameter(BASIC_MULTIPLIER) != null
				&& !request.getParameter(BASIC_MULTIPLIER).equals("")) {
			basicMultiplier = Float.parseFloat(request
					.getParameter(BASIC_MULTIPLIER));
		}
		generalMap.put("basicMultiplier", basicMultiplier);

		String arrearElement = "";
		if (request.getParameter(ARREAR_ELEMENT) != null) {
			arrearElement = "y";
		} else {
			arrearElement = "n";
		}
		generalMap.put("arrearElement", arrearElement);

		String reimbElement = "";
		if (request.getParameter(REIMB_ELEMENT) != null) {
			reimbElement = "y";
		} else {
			reimbElement = "n";
			;
		}
		generalMap.put("reimbElement", reimbElement);

		String basicDependent = "";
		if (request.getParameter(BASIC_DEPENDENT) != null) {
			basicDependent = "y";
		} else {
			basicDependent = "n";
			;
		}
		generalMap.put("basicDependent", basicDependent);
		String pfDependent = "";
		if (request.getParameter(PF_DEPENDENT) != null) {
			pfDependent = "y";
		} else {
			pfDependent = "n";
		}
		generalMap.put("pfDependent", pfDependent);

		BigDecimal maxAmount = null;
		if (request.getParameter(MAXIMUM_AMOUNT) != null
				&& !request.getParameter(MAXIMUM_AMOUNT).equals("")) {
			maxAmount = new BigDecimal(request.getParameter(MAXIMUM_AMOUNT));

		}
		generalMap.put("maxAmount", maxAmount);

		String ctcHeading = "";
		if (request.getParameter(CTC_HEADING) != null) {
			ctcHeading = request.getParameter(CTC_HEADING);
		}
		generalMap.put(CTC_HEADING, ctcHeading);

		String payElementStatus = "";
		if (request.getParameter(PAY_ELEMENT_STATUS) != null) {
			payElementStatus = request.getParameter(PAY_ELEMENT_STATUS);
		}
		generalMap.put("payElementStatus", payElementStatus);
		Date statusDate = new Date();
		if (request.getParameter(STATUS_DATE) != null
				&& !(request.getParameter(STATUS_DATE).equals(""))) {
			statusDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(STATUS_DATE));
		}
		generalMap.put("statusDate", statusDate);
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		generalMap.put("changedBy", changedBy);
		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		generalMap.put("currentDate", currentDate);
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("currentTime", currentTime);

		map = payrollMastersHandlerService.editPayElement(generalMap);
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletePayElement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int payElementId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			payElementId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("payElementId", payElementId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		map = payrollMastersHandlerService.deletePayElement(generalMap);

		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPayElement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String payElementCode = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			payElementCode = request.getParameter(CODE);
		}
		String payElementDescription = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			payElementDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		String searchField = "";
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			payElementCode = searchField;
			payElementDescription = null;

		} else {
			payElementCode = null;
			payElementDescription = searchField;
		}
		map = payrollMastersHandlerService.searchPayElement(payElementCode,
				payElementDescription);
		String jsp = HR_PAYELEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showReimbersementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = payrollMastersHandlerService.showReimbersementJsp();
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveReimbersement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasReimbersement hrMasReimbersement = new HrMasReimbersement();

		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasReimbersement.setHospital(masHospital);
		}
		if (request.getParameter(CODE) != null) {
			String reimbCode = request.getParameter(CODE);
			hrMasReimbersement.setReimbCode(reimbCode);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			String reimbDescription = request.getParameter(SEARCH_NAME);
			hrMasReimbersement.setReimbDesc(reimbDescription);
		}
		if (request.getParameter(MAXIMUM_AMOUNT) != null
				&& !request.getParameter(MAXIMUM_AMOUNT).equals("")) {
			BigDecimal maxAmount = new BigDecimal(
					request.getParameter(MAXIMUM_AMOUNT));
			hrMasReimbersement.setMaxAmount(maxAmount);
		}
		if (request.getParameter(TAXABLE) != null) {
			hrMasReimbersement.setTaxable("y");
		} else {
			hrMasReimbersement.setTaxable("n");
		}
		if (request.getParameter(MAX_TAX_EXEMPTION) != null
				&& !request.getParameter(MAX_TAX_EXEMPTION).equals("")) {
			BigDecimal maxTaxExemption = new BigDecimal(
					request.getParameter(MAX_TAX_EXEMPTION));
			hrMasReimbersement.setMaxTaxExemption(maxTaxExemption);
		}
		if (request.getParameter(CARRY_FORWARD) != null) {
			hrMasReimbersement.setCarryForward("y");
		} else {
			hrMasReimbersement.setCarryForward("n");
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			String changedBy = request.getParameter(CHANGED_BY);
			hrMasReimbersement.setLastChgBy(changedBy);
		}

		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			hrMasReimbersement.setLastChgDate(currentDate);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			String currentTime = request.getParameter(CHANGED_TIME);
			hrMasReimbersement.setLastChgTime(currentTime);
		}
		hrMasReimbersement.setStatus("y");
		map = payrollMastersHandlerService
				.saveReimbersement(hrMasReimbersement);
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editReimbersement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			int reimbId = Integer.parseInt(request.getParameter(COMMON_ID));
			generalMap.put("reimbId", reimbId);
		}
		if (request.getParameter(CODE) != null) {
			String reimbCode = request.getParameter(CODE);
			generalMap.put("reimbCode", reimbCode);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			String reimbDescription = request.getParameter(SEARCH_NAME);
			generalMap.put("reimbDescription", reimbDescription);
		}
		if (request.getParameter(MAXIMUM_AMOUNT) != null) {
			BigDecimal maxAmount = new BigDecimal(
					request.getParameter(MAXIMUM_AMOUNT));
			generalMap.put("maxAmount", maxAmount);
		}
		if (request.getParameter(TAXABLE) != null) {
			String taxable = "y";
			generalMap.put("taxable", taxable);
		} else {
			String taxable = "n";
			generalMap.put("taxable", taxable);
		}

		if (request.getParameter(MAX_TAX_EXEMPTION) != null
				&& !request.getParameter(MAX_TAX_EXEMPTION).equals("")) {
			BigDecimal maxTaxExemption = new BigDecimal(
					request.getParameter(MAX_TAX_EXEMPTION));
			generalMap.put("maxTaxExemption", maxTaxExemption);
		}
		if (request.getParameter(CARRY_FORWARD) != null) {
			String carryForward = "y";
			generalMap.put("carryForward", carryForward);
		} else {
			String carryForward = "y";
			generalMap.put("carryForward", carryForward);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			String changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}

		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			Date currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			String currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		map = payrollMastersHandlerService.editReimbersement(generalMap);
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteReimbersement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int reimbId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			reimbId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		generalMap.put("reimbId", reimbId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		map = payrollMastersHandlerService.deleteReimbersement(generalMap);
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchReimbersement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String reimbCode = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			reimbCode = request.getParameter(CODE);
		}
		String reimbDescription = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			reimbDescription = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		String searchField = "";
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			reimbCode = searchField;
			reimbDescription = null;

		} else {
			reimbCode = null;
			reimbDescription = searchField;
		}
		map = payrollMastersHandlerService.searchReimbersement(reimbCode,
				reimbDescription);
		String jsp = HR_REIMBERSEMENT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		return new ModelAndView("index", "map", map);
	}

}
