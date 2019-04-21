package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_mas_parameter_maintenance table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_mas_parameter_maintenance"
 */

public abstract class BaseHrMasParameterMaintenance implements Serializable {

	public static String REF = "HrMasParameterMaintenance";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOLIDAY1 = "Holiday1";
	public static String PROP_TAN_NO = "TanNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PASSWORD_EXPIRY_DAY = "PasswordExpiryDay";
	public static String PROP_NO_OF_WORKING_DAYS = "NoOfWorkingDays";
	public static String PROP_PAY_TYPE = "PayType";
	public static String PROP_UNUSD_LEAVE_CARY_FWD_OR_ENCASH = "UnusdLeaveCaryFwdOrEncash";
	public static String PROP_LEAVE_ENCASH = "LeaveEncash";
	public static String PROP_VACATION_LEAVE_ELIGIBILTY = "VacationLeaveEligibilty";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_IN_SERVICE_CODE = "InServiceCode";
	public static String PROP_GRATUITY = "Gratuity";
	public static String PROP_PENSION_FUND = "PensionFund";
	public static String PROP_EPS_MAX_LIMIT = "EpsMaxLimit";
	public static String PROP_ADMIN_ON_EDLI = "AdminOnEdli";
	public static String PROP_FEMALE_TAX_REBATE = "FemaleTaxRebate";
	public static String PROP_BENEFIT_PERCENTAGE = "BenefitPercentage";
	public static String PROP_INSPECTION_CHARGE = "InspectionCharge";
	public static String PROP_VOLUNATRY_CONTR = "VolunatryContr";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ESI_EMPLOYEE_CONT = "EsiEmployeeCont";
	public static String PROP_NIGHT_SHIFT_END = "NightShiftEnd";
	public static String PROP_SICK_LEAVE_ELIGIBILTY = "SickLeaveEligibilty";
	public static String PROP_PAN_NO = "PanNo";
	public static String PROP_HEAD_OFFICE_CODE = "HeadOfficeCode";
	public static String PROP_RETIREMENT_AGE = "RetirementAge";
	public static String PROP_ACCOUNT_NO_OF_EPF = "AccountNoOfEpf";
	public static String PROP_SUPERANNUATION = "Superannuation";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_NIGHT_SHIFT_START = "NightShiftStart";
	public static String PROP_DA = "Da";
	public static String PROP_ESI_EMPLOYER_CONT = "EsiEmployerCont";
	public static String PROP_INCLUDE_HOLIDAYS_IN_LEAVE = "IncludeHolidaysInLeave";
	public static String PROP_ADMIN_CHARGE = "AdminCharge";
	public static String PROP_EDLI = "Edli";
	public static String PROP_HOLIDAY2 = "Holiday2";
	public static String PROP_ID = "Id";
	public static String PROP_FIN_YR_FOR_LEAVE_CALC = "FinYrForLeaveCalc";

	// constructors
	public BaseHrMasParameterMaintenance() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasParameterMaintenance(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String da;
	private java.math.BigDecimal epsMaxLimit;
	private java.lang.Float edli;
	private java.lang.Float adminCharge;
	private java.lang.String headOfficeCode;
	private java.lang.Integer inServiceCode;
	private java.lang.Integer leaveEncash;
	private java.lang.Integer payType;
	private java.lang.Integer noOfWorkingDays;
	private java.lang.Integer retirementAge;
	private java.lang.String volunatryContr;
	private java.lang.String holiday1;
	private java.lang.String holiday2;
	private java.lang.Float gratuity;
	private java.lang.Float superannuation;
	private java.lang.Integer passwordExpiryDay;
	private java.lang.Float inspectionCharge;
	private java.lang.Float adminOnEdli;
	private java.lang.Float pensionFund;
	private java.lang.String accountNoOfEpf;
	private java.math.BigDecimal femaleTaxRebate;
	private java.lang.String panNo;
	private java.lang.String tanNo;
	private java.lang.Float esiEmployeeCont;
	private java.lang.Float esiEmployerCont;
	private java.lang.String nightShiftStart;
	private java.lang.String nightShiftEnd;
	private java.lang.Float benefitPercentage;
	private java.lang.String finYrForLeaveCalc;
	private java.lang.String includeHolidaysInLeave;
	private java.lang.String unusdLeaveCaryFwdOrEncash;
	private java.lang.String sickLeaveEligibilty;
	private java.lang.String vacationLeaveEligibilty;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="parameter_maintenance_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: da
	 */
	public java.lang.String getDa() {
		return da;
	}

	/**
	 * Set the value related to the column: da
	 * 
	 * @param da
	 *            the da value
	 */
	public void setDa(java.lang.String da) {
		this.da = da;
	}

	/**
	 * Return the value associated with the column: eps_max_limit
	 */
	public java.math.BigDecimal getEpsMaxLimit() {
		return epsMaxLimit;
	}

	/**
	 * Set the value related to the column: eps_max_limit
	 * 
	 * @param epsMaxLimit
	 *            the eps_max_limit value
	 */
	public void setEpsMaxLimit(java.math.BigDecimal epsMaxLimit) {
		this.epsMaxLimit = epsMaxLimit;
	}

	/**
	 * Return the value associated with the column: edli
	 */
	public java.lang.Float getEdli() {
		return edli;
	}

	/**
	 * Set the value related to the column: edli
	 * 
	 * @param edli
	 *            the edli value
	 */
	public void setEdli(java.lang.Float edli) {
		this.edli = edli;
	}

	/**
	 * Return the value associated with the column: admin_charge
	 */
	public java.lang.Float getAdminCharge() {
		return adminCharge;
	}

	/**
	 * Set the value related to the column: admin_charge
	 * 
	 * @param adminCharge
	 *            the admin_charge value
	 */
	public void setAdminCharge(java.lang.Float adminCharge) {
		this.adminCharge = adminCharge;
	}

	/**
	 * Return the value associated with the column: head_office_code
	 */
	public java.lang.String getHeadOfficeCode() {
		return headOfficeCode;
	}

	/**
	 * Set the value related to the column: head_office_code
	 * 
	 * @param headOfficeCode
	 *            the head_office_code value
	 */
	public void setHeadOfficeCode(java.lang.String headOfficeCode) {
		this.headOfficeCode = headOfficeCode;
	}

	/**
	 * Return the value associated with the column: in_service_code
	 */
	public java.lang.Integer getInServiceCode() {
		return inServiceCode;
	}

	/**
	 * Set the value related to the column: in_service_code
	 * 
	 * @param inServiceCode
	 *            the in_service_code value
	 */
	public void setInServiceCode(java.lang.Integer inServiceCode) {
		this.inServiceCode = inServiceCode;
	}

	/**
	 * Return the value associated with the column: leave_encash
	 */
	public java.lang.Integer getLeaveEncash() {
		return leaveEncash;
	}

	/**
	 * Set the value related to the column: leave_encash
	 * 
	 * @param leaveEncash
	 *            the leave_encash value
	 */
	public void setLeaveEncash(java.lang.Integer leaveEncash) {
		this.leaveEncash = leaveEncash;
	}

	/**
	 * Return the value associated with the column: pay_type
	 */
	public java.lang.Integer getPayType() {
		return payType;
	}

	/**
	 * Set the value related to the column: pay_type
	 * 
	 * @param payType
	 *            the pay_type value
	 */
	public void setPayType(java.lang.Integer payType) {
		this.payType = payType;
	}

	/**
	 * Return the value associated with the column: no_of_working_days
	 */
	public java.lang.Integer getNoOfWorkingDays() {
		return noOfWorkingDays;
	}

	/**
	 * Set the value related to the column: no_of_working_days
	 * 
	 * @param noOfWorkingDays
	 *            the no_of_working_days value
	 */
	public void setNoOfWorkingDays(java.lang.Integer noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}

	/**
	 * Return the value associated with the column: retirement_age
	 */
	public java.lang.Integer getRetirementAge() {
		return retirementAge;
	}

	/**
	 * Set the value related to the column: retirement_age
	 * 
	 * @param retirementAge
	 *            the retirement_age value
	 */
	public void setRetirementAge(java.lang.Integer retirementAge) {
		this.retirementAge = retirementAge;
	}

	/**
	 * Return the value associated with the column: volunatry_contr
	 */
	public java.lang.String getVolunatryContr() {
		return volunatryContr;
	}

	/**
	 * Set the value related to the column: volunatry_contr
	 * 
	 * @param volunatryContr
	 *            the volunatry_contr value
	 */
	public void setVolunatryContr(java.lang.String volunatryContr) {
		this.volunatryContr = volunatryContr;
	}

	/**
	 * Return the value associated with the column: holiday1
	 */
	public java.lang.String getHoliday1() {
		return holiday1;
	}

	/**
	 * Set the value related to the column: holiday1
	 * 
	 * @param holiday1
	 *            the holiday1 value
	 */
	public void setHoliday1(java.lang.String holiday1) {
		this.holiday1 = holiday1;
	}

	/**
	 * Return the value associated with the column: holiday2
	 */
	public java.lang.String getHoliday2() {
		return holiday2;
	}

	/**
	 * Set the value related to the column: holiday2
	 * 
	 * @param holiday2
	 *            the holiday2 value
	 */
	public void setHoliday2(java.lang.String holiday2) {
		this.holiday2 = holiday2;
	}

	/**
	 * Return the value associated with the column: gratuity
	 */
	public java.lang.Float getGratuity() {
		return gratuity;
	}

	/**
	 * Set the value related to the column: gratuity
	 * 
	 * @param gratuity
	 *            the gratuity value
	 */
	public void setGratuity(java.lang.Float gratuity) {
		this.gratuity = gratuity;
	}

	/**
	 * Return the value associated with the column: superannuation
	 */
	public java.lang.Float getSuperannuation() {
		return superannuation;
	}

	/**
	 * Set the value related to the column: superannuation
	 * 
	 * @param superannuation
	 *            the superannuation value
	 */
	public void setSuperannuation(java.lang.Float superannuation) {
		this.superannuation = superannuation;
	}

	/**
	 * Return the value associated with the column: password_expiry_day
	 */
	public java.lang.Integer getPasswordExpiryDay() {
		return passwordExpiryDay;
	}

	/**
	 * Set the value related to the column: password_expiry_day
	 * 
	 * @param passwordExpiryDay
	 *            the password_expiry_day value
	 */
	public void setPasswordExpiryDay(java.lang.Integer passwordExpiryDay) {
		this.passwordExpiryDay = passwordExpiryDay;
	}

	/**
	 * Return the value associated with the column: inspection_charge
	 */
	public java.lang.Float getInspectionCharge() {
		return inspectionCharge;
	}

	/**
	 * Set the value related to the column: inspection_charge
	 * 
	 * @param inspectionCharge
	 *            the inspection_charge value
	 */
	public void setInspectionCharge(java.lang.Float inspectionCharge) {
		this.inspectionCharge = inspectionCharge;
	}

	/**
	 * Return the value associated with the column: admin_on_edli
	 */
	public java.lang.Float getAdminOnEdli() {
		return adminOnEdli;
	}

	/**
	 * Set the value related to the column: admin_on_edli
	 * 
	 * @param adminOnEdli
	 *            the admin_on_edli value
	 */
	public void setAdminOnEdli(java.lang.Float adminOnEdli) {
		this.adminOnEdli = adminOnEdli;
	}

	/**
	 * Return the value associated with the column: pension_fund
	 */
	public java.lang.Float getPensionFund() {
		return pensionFund;
	}

	/**
	 * Set the value related to the column: pension_fund
	 * 
	 * @param pensionFund
	 *            the pension_fund value
	 */
	public void setPensionFund(java.lang.Float pensionFund) {
		this.pensionFund = pensionFund;
	}

	/**
	 * Return the value associated with the column: account_no_of_epf
	 */
	public java.lang.String getAccountNoOfEpf() {
		return accountNoOfEpf;
	}

	/**
	 * Set the value related to the column: account_no_of_epf
	 * 
	 * @param accountNoOfEpf
	 *            the account_no_of_epf value
	 */
	public void setAccountNoOfEpf(java.lang.String accountNoOfEpf) {
		this.accountNoOfEpf = accountNoOfEpf;
	}

	/**
	 * Return the value associated with the column: female_tax_rebate
	 */
	public java.math.BigDecimal getFemaleTaxRebate() {
		return femaleTaxRebate;
	}

	/**
	 * Set the value related to the column: female_tax_rebate
	 * 
	 * @param femaleTaxRebate
	 *            the female_tax_rebate value
	 */
	public void setFemaleTaxRebate(java.math.BigDecimal femaleTaxRebate) {
		this.femaleTaxRebate = femaleTaxRebate;
	}

	/**
	 * Return the value associated with the column: pan_no
	 */
	public java.lang.String getPanNo() {
		return panNo;
	}

	/**
	 * Set the value related to the column: pan_no
	 * 
	 * @param panNo
	 *            the pan_no value
	 */
	public void setPanNo(java.lang.String panNo) {
		this.panNo = panNo;
	}

	/**
	 * Return the value associated with the column: tan_no
	 */
	public java.lang.String getTanNo() {
		return tanNo;
	}

	/**
	 * Set the value related to the column: tan_no
	 * 
	 * @param tanNo
	 *            the tan_no value
	 */
	public void setTanNo(java.lang.String tanNo) {
		this.tanNo = tanNo;
	}

	/**
	 * Return the value associated with the column: esi_employee_cont
	 */
	public java.lang.Float getEsiEmployeeCont() {
		return esiEmployeeCont;
	}

	/**
	 * Set the value related to the column: esi_employee_cont
	 * 
	 * @param esiEmployeeCont
	 *            the esi_employee_cont value
	 */
	public void setEsiEmployeeCont(java.lang.Float esiEmployeeCont) {
		this.esiEmployeeCont = esiEmployeeCont;
	}

	/**
	 * Return the value associated with the column: esi_employer_cont
	 */
	public java.lang.Float getEsiEmployerCont() {
		return esiEmployerCont;
	}

	/**
	 * Set the value related to the column: esi_employer_cont
	 * 
	 * @param esiEmployerCont
	 *            the esi_employer_cont value
	 */
	public void setEsiEmployerCont(java.lang.Float esiEmployerCont) {
		this.esiEmployerCont = esiEmployerCont;
	}

	/**
	 * Return the value associated with the column: night_shift_start
	 */
	public java.lang.String getNightShiftStart() {
		return nightShiftStart;
	}

	/**
	 * Set the value related to the column: night_shift_start
	 * 
	 * @param nightShiftStart
	 *            the night_shift_start value
	 */
	public void setNightShiftStart(java.lang.String nightShiftStart) {
		this.nightShiftStart = nightShiftStart;
	}

	/**
	 * Return the value associated with the column: night_shift_end
	 */
	public java.lang.String getNightShiftEnd() {
		return nightShiftEnd;
	}

	/**
	 * Set the value related to the column: night_shift_end
	 * 
	 * @param nightShiftEnd
	 *            the night_shift_end value
	 */
	public void setNightShiftEnd(java.lang.String nightShiftEnd) {
		this.nightShiftEnd = nightShiftEnd;
	}

	/**
	 * Return the value associated with the column: benefit_percentage
	 */
	public java.lang.Float getBenefitPercentage() {
		return benefitPercentage;
	}

	/**
	 * Set the value related to the column: benefit_percentage
	 * 
	 * @param benefitPercentage
	 *            the benefit_percentage value
	 */
	public void setBenefitPercentage(java.lang.Float benefitPercentage) {
		this.benefitPercentage = benefitPercentage;
	}

	/**
	 * Return the value associated with the column: fin_yr_for_leave_calc
	 */
	public java.lang.String getFinYrForLeaveCalc() {
		return finYrForLeaveCalc;
	}

	/**
	 * Set the value related to the column: fin_yr_for_leave_calc
	 * 
	 * @param finYrForLeaveCalc
	 *            the fin_yr_for_leave_calc value
	 */
	public void setFinYrForLeaveCalc(java.lang.String finYrForLeaveCalc) {
		this.finYrForLeaveCalc = finYrForLeaveCalc;
	}

	/**
	 * Return the value associated with the column: include_holidays_in_leave
	 */
	public java.lang.String getIncludeHolidaysInLeave() {
		return includeHolidaysInLeave;
	}

	/**
	 * Set the value related to the column: include_holidays_in_leave
	 * 
	 * @param includeHolidaysInLeave
	 *            the include_holidays_in_leave value
	 */
	public void setIncludeHolidaysInLeave(
			java.lang.String includeHolidaysInLeave) {
		this.includeHolidaysInLeave = includeHolidaysInLeave;
	}

	/**
	 * Return the value associated with the column:
	 * unusd_leave_cary_fwd_or_encash
	 */
	public java.lang.String getUnusdLeaveCaryFwdOrEncash() {
		return unusdLeaveCaryFwdOrEncash;
	}

	/**
	 * Set the value related to the column: unusd_leave_cary_fwd_or_encash
	 * 
	 * @param unusdLeaveCaryFwdOrEncash
	 *            the unusd_leave_cary_fwd_or_encash value
	 */
	public void setUnusdLeaveCaryFwdOrEncash(
			java.lang.String unusdLeaveCaryFwdOrEncash) {
		this.unusdLeaveCaryFwdOrEncash = unusdLeaveCaryFwdOrEncash;
	}

	/**
	 * Return the value associated with the column: sick_leave_eligibilty
	 */
	public java.lang.String getSickLeaveEligibilty() {
		return sickLeaveEligibilty;
	}

	/**
	 * Set the value related to the column: sick_leave_eligibilty
	 * 
	 * @param sickLeaveEligibilty
	 *            the sick_leave_eligibilty value
	 */
	public void setSickLeaveEligibilty(java.lang.String sickLeaveEligibilty) {
		this.sickLeaveEligibilty = sickLeaveEligibilty;
	}

	/**
	 * Return the value associated with the column: vacation_leave_eligibilty
	 */
	public java.lang.String getVacationLeaveEligibilty() {
		return vacationLeaveEligibilty;
	}

	/**
	 * Set the value related to the column: vacation_leave_eligibilty
	 * 
	 * @param vacationLeaveEligibilty
	 *            the vacation_leave_eligibilty value
	 */
	public void setVacationLeaveEligibilty(
			java.lang.String vacationLeaveEligibilty) {
		this.vacationLeaveEligibilty = vacationLeaveEligibilty;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.HrMasParameterMaintenance)) {
			return false;
		} else {
			jkt.hrms.masters.business.HrMasParameterMaintenance hrMasParameterMaintenance = (jkt.hrms.masters.business.HrMasParameterMaintenance) obj;
			if (null == this.getId()
					|| null == hrMasParameterMaintenance.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrMasParameterMaintenance.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}