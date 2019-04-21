package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_post_anaesthesia_procedure table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_post_anaesthesia_procedure"
 */

public abstract class BaseOtPostAnaesthesiaProcedure  implements Serializable {

	public static String REF = "OtPostAnaesthesiaProcedure";
	public static String PROP_UO = "Uo";
	public static String PROP_GLYCOPHYRROLATE = "Glycophyrrolate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RISK_GRADE = "RiskGrade";
	public static String PROP_ECG = "Ecg";
	public static String PROP_BMI = "Bmi";
	public static String PROP_ETT_LMA = "EttLma";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_KETAMINE = "Ketamine";
	public static String PROP_ETT_LMA_TEXT = "EttLmaText";
	public static String PROP_CVP = "Cvp";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ANAESTHESIA_TO_TIME = "AnaesthesiaToTime";
	public static String PROP_E_OTHERS = "EOthers";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DATE_OF_POST = "DateOfPost";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_ASA_GRADE_DETAILS = "AsaGradeDetails";
	public static String PROP_BOOKING = "Booking";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ANAESTHESIA_FROM_TIME = "AnaesthesiaFromTime";
	public static String PROP_IN_PATIENT = "InPatient";
	public static String PROP_ANESTHESIA = "Anesthesia";
	public static String PROP_ID = "Id";
	public static String PROP_NIBP = "Nibp";
	public static String PROP_BUPIVACAINE = "Bupivacaine";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_REAMRKS_FOR_DISCHARGEVITAL = "ReamrksForDischargevital";
	public static String PROP_TEMP = "Temp";
	public static String PROP_IABP = "Iabp";
	public static String PROP_OTHERS = "Others";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SURGEY_FROM_TIME = "SurgeyFromTime";
	public static String PROP_SEVOFLURANE = "Sevoflurane";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ISOFLURANE = "Isoflurane";
	public static String PROP_BMI_STATUS = "BmiStatus";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_YEARLYSLNO = "Yearlyslno";
	public static String PROP_NEOSTIGMINE = "Neostigmine";
	public static String PROP_MONTHLYSLNO = "Monthlyslno";
	public static String PROP_SP02 = "Sp02";
	public static String PROP_SURGEY_TO_TIME = "SurgeyToTime";
	public static String PROP_LEVEL_OF_ANESTHESIA = "LevelOfAnesthesia";
	public static String PROP_RESPIRATORY = "respiratory";
	public static String PROP_NITRONS_OXIDE = "NitronsOxide";
	public static String PROP_RECOVERY = "Recovery";
	public static String PROP_HALOTHANE = "Halothane";
	public static String PROP_BP = "Bp";
	public static String PROP_HIN = "Hin";
	public static String PROP_PROFOFOL = "Profofol";


	// constructors
	public BaseOtPostAnaesthesiaProcedure () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPostAnaesthesiaProcedure (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String yearlyslno;
	private java.lang.String monthlyslno;
	private java.lang.String surgeyFromTime;
	private java.lang.String surgeyToTime;
	private java.lang.String asaGradeDetails;
	private java.lang.String anaesthesiaFromTime;
	private java.lang.String anaesthesiaToTime;
	private java.lang.String ettLma;
	private java.lang.Integer ettLmaText;
	private java.lang.String ecg;
	private java.lang.String nibp;
	private java.lang.String cvp;
	private java.lang.String temp;
	private java.lang.String sp02;
	private java.lang.String iabp;
	private java.lang.String uo;
	private java.lang.Integer neostigmine;
	private java.lang.Integer glycophyrrolate;
	private java.lang.Integer others;
	private java.lang.String recovery;
	private java.lang.String riskGrade;
	private java.lang.String eOthers;
	private java.lang.String remarks;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.util.Date dateOfPost;
	private java.lang.String halothane;
	private java.lang.String isoflurane;
	private java.lang.String sevoflurane;
	private java.lang.String nitronsOxide;
	private java.lang.String profofol;
	private java.lang.String ketamine;
	private java.lang.String bupivacaine;
	private java.lang.String levelOfAnesthesia;
	private java.lang.Integer height;
	private java.lang.Integer weight;
	private java.lang.String bmi;
	private java.lang.String pulse;
	private java.lang.String bp;
	private java.lang.String respiratory;
	private java.lang.String bmiStatus;
	private java.lang.String reamrksForDischargevital;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasAnesthesia anesthesia;
	private jkt.hms.masters.business.OtBooking booking;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inPatient;

	// collections
	private java.util.Set<jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail> otSurgeyPaAnesthesiologistDetails;
	private java.util.Set<jkt.hms.masters.business.OtSurgeyPaEmployeeDetail> otSurgeyPaEmployeeDetails;
	private java.util.Set<jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail> otSurgeyPaIvFluidsDetails;
	private java.util.Set<jkt.hms.masters.business.OtSurgeyPaPremedicationDetail> otSurgeyPaPremedicationDetails;
	private java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> otSurgeyPaSurgeyDetails;
	private java.util.Set<jkt.hms.masters.business.OtSurgeyPaProcedureDetail> otSurgeyPaProcedureDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ot_post_anaesthesia_procedure_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: yearlyslno
	 */
	public java.lang.String getYearlyslno () {
		return yearlyslno;
	}

	/**
	 * Set the value related to the column: yearlyslno
	 * @param yearlyslno the yearlyslno value
	 */
	public void setYearlyslno (java.lang.String yearlyslno) {
		this.yearlyslno = yearlyslno;
	}



	/**
	 * Return the value associated with the column: monthlyslno
	 */
	public java.lang.String getMonthlyslno () {
		return monthlyslno;
	}

	/**
	 * Set the value related to the column: monthlyslno
	 * @param monthlyslno the monthlyslno value
	 */
	public void setMonthlyslno (java.lang.String monthlyslno) {
		this.monthlyslno = monthlyslno;
	}



	/**
	 * Return the value associated with the column: surgey_from_time
	 */
	public java.lang.String getSurgeyFromTime () {
		return surgeyFromTime;
	}

	/**
	 * Set the value related to the column: surgey_from_time
	 * @param surgeyFromTime the surgey_from_time value
	 */
	public void setSurgeyFromTime (java.lang.String surgeyFromTime) {
		this.surgeyFromTime = surgeyFromTime;
	}



	/**
	 * Return the value associated with the column: surgey_to_time
	 */
	public java.lang.String getSurgeyToTime () {
		return surgeyToTime;
	}

	/**
	 * Set the value related to the column: surgey_to_time
	 * @param surgeyToTime the surgey_to_time value
	 */
	public void setSurgeyToTime (java.lang.String surgeyToTime) {
		this.surgeyToTime = surgeyToTime;
	}



	/**
	 * Return the value associated with the column: asa_grade_details
	 */
	public java.lang.String getAsaGradeDetails () {
		return asaGradeDetails;
	}

	/**
	 * Set the value related to the column: asa_grade_details
	 * @param asaGradeDetails the asa_grade_details value
	 */
	public void setAsaGradeDetails (java.lang.String asaGradeDetails) {
		this.asaGradeDetails = asaGradeDetails;
	}



	/**
	 * Return the value associated with the column: anaesthesia_from_time
	 */
	public java.lang.String getAnaesthesiaFromTime () {
		return anaesthesiaFromTime;
	}

	/**
	 * Set the value related to the column: anaesthesia_from_time
	 * @param anaesthesiaFromTime the anaesthesia_from_time value
	 */
	public void setAnaesthesiaFromTime (java.lang.String anaesthesiaFromTime) {
		this.anaesthesiaFromTime = anaesthesiaFromTime;
	}



	/**
	 * Return the value associated with the column: anaesthesia_to_time
	 */
	public java.lang.String getAnaesthesiaToTime () {
		return anaesthesiaToTime;
	}

	/**
	 * Set the value related to the column: anaesthesia_to_time
	 * @param anaesthesiaToTime the anaesthesia_to_time value
	 */
	public void setAnaesthesiaToTime (java.lang.String anaesthesiaToTime) {
		this.anaesthesiaToTime = anaesthesiaToTime;
	}



	/**
	 * Return the value associated with the column: ett_lma
	 */
	public java.lang.String getEttLma () {
		return ettLma;
	}

	/**
	 * Set the value related to the column: ett_lma
	 * @param ettLma the ett_lma value
	 */
	public void setEttLma (java.lang.String ettLma) {
		this.ettLma = ettLma;
	}



	/**
	 * Return the value associated with the column: ett_lma_text
	 */
	public java.lang.Integer getEttLmaText () {
		return ettLmaText;
	}

	/**
	 * Set the value related to the column: ett_lma_text
	 * @param ettLmaText the ett_lma_text value
	 */
	public void setEttLmaText (java.lang.Integer ettLmaText) {
		this.ettLmaText = ettLmaText;
	}



	/**
	 * Return the value associated with the column: ecg
	 */
	public java.lang.String getEcg () {
		return ecg;
	}

	/**
	 * Set the value related to the column: ecg
	 * @param ecg the ecg value
	 */
	public void setEcg (java.lang.String ecg) {
		this.ecg = ecg;
	}



	/**
	 * Return the value associated with the column: nibp
	 */
	public java.lang.String getNibp () {
		return nibp;
	}

	/**
	 * Set the value related to the column: nibp
	 * @param nibp the nibp value
	 */
	public void setNibp (java.lang.String nibp) {
		this.nibp = nibp;
	}



	/**
	 * Return the value associated with the column: cvp
	 */
	public java.lang.String getCvp () {
		return cvp;
	}

	/**
	 * Set the value related to the column: cvp
	 * @param cvp the cvp value
	 */
	public void setCvp (java.lang.String cvp) {
		this.cvp = cvp;
	}



	/**
	 * Return the value associated with the column: temp
	 */
	public java.lang.String getTemp () {
		return temp;
	}

	/**
	 * Set the value related to the column: temp
	 * @param temp the temp value
	 */
	public void setTemp (java.lang.String temp) {
		this.temp = temp;
	}



	/**
	 * Return the value associated with the column: sp02
	 */
	public java.lang.String getSp02 () {
		return sp02;
	}

	/**
	 * Set the value related to the column: sp02
	 * @param sp02 the sp02 value
	 */
	public void setSp02 (java.lang.String sp02) {
		this.sp02 = sp02;
	}



	/**
	 * Return the value associated with the column: iabp
	 */
	public java.lang.String getIabp () {
		return iabp;
	}

	/**
	 * Set the value related to the column: iabp
	 * @param iabp the iabp value
	 */
	public void setIabp (java.lang.String iabp) {
		this.iabp = iabp;
	}



	/**
	 * Return the value associated with the column: uo
	 */
	public java.lang.String getUo () {
		return uo;
	}

	/**
	 * Set the value related to the column: uo
	 * @param uo the uo value
	 */
	public void setUo (java.lang.String uo) {
		this.uo = uo;
	}



	/**
	 * Return the value associated with the column: neostigmine
	 */
	public java.lang.Integer getNeostigmine () {
		return neostigmine;
	}

	/**
	 * Set the value related to the column: neostigmine
	 * @param neostigmine the neostigmine value
	 */
	public void setNeostigmine (java.lang.Integer neostigmine) {
		this.neostigmine = neostigmine;
	}



	/**
	 * Return the value associated with the column: glycophyrrolate
	 */
	public java.lang.Integer getGlycophyrrolate () {
		return glycophyrrolate;
	}

	/**
	 * Set the value related to the column: glycophyrrolate
	 * @param glycophyrrolate the glycophyrrolate value
	 */
	public void setGlycophyrrolate (java.lang.Integer glycophyrrolate) {
		this.glycophyrrolate = glycophyrrolate;
	}



	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.Integer getOthers () {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * @param others the others value
	 */
	public void setOthers (java.lang.Integer others) {
		this.others = others;
	}



	/**
	 * Return the value associated with the column: recovery
	 */
	public java.lang.String getRecovery () {
		return recovery;
	}

	/**
	 * Set the value related to the column: recovery
	 * @param recovery the recovery value
	 */
	public void setRecovery (java.lang.String recovery) {
		this.recovery = recovery;
	}



	/**
	 * Return the value associated with the column: risk_grade
	 */
	public java.lang.String getRiskGrade () {
		return riskGrade;
	}

	/**
	 * Set the value related to the column: risk_grade
	 * @param riskGrade the risk_grade value
	 */
	public void setRiskGrade (java.lang.String riskGrade) {
		this.riskGrade = riskGrade;
	}



	/**
	 * Return the value associated with the column: e_others
	 */
	public java.lang.String getEOthers () {
		return eOthers;
	}

	/**
	 * Set the value related to the column: e_others
	 * @param eOthers the e_others value
	 */
	public void setEOthers (java.lang.String eOthers) {
		this.eOthers = eOthers;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: date_of_post
	 */
	public java.util.Date getDateOfPost () {
		return dateOfPost;
	}

	/**
	 * Set the value related to the column: date_of_post
	 * @param dateOfPost the date_of_post value
	 */
	public void setDateOfPost (java.util.Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}



	/**
	 * Return the value associated with the column: halothane
	 */
	public java.lang.String getHalothane () {
		return halothane;
	}

	/**
	 * Set the value related to the column: halothane
	 * @param halothane the halothane value
	 */
	public void setHalothane (java.lang.String halothane) {
		this.halothane = halothane;
	}



	/**
	 * Return the value associated with the column: isoflurane
	 */
	public java.lang.String getIsoflurane () {
		return isoflurane;
	}

	/**
	 * Set the value related to the column: isoflurane
	 * @param isoflurane the isoflurane value
	 */
	public void setIsoflurane (java.lang.String isoflurane) {
		this.isoflurane = isoflurane;
	}



	/**
	 * Return the value associated with the column: sevoflurane
	 */
	public java.lang.String getSevoflurane () {
		return sevoflurane;
	}

	/**
	 * Set the value related to the column: sevoflurane
	 * @param sevoflurane the sevoflurane value
	 */
	public void setSevoflurane (java.lang.String sevoflurane) {
		this.sevoflurane = sevoflurane;
	}



	/**
	 * Return the value associated with the column: nitrons_oxide
	 */
	public java.lang.String getNitronsOxide () {
		return nitronsOxide;
	}

	/**
	 * Set the value related to the column: nitrons_oxide
	 * @param nitronsOxide the nitrons_oxide value
	 */
	public void setNitronsOxide (java.lang.String nitronsOxide) {
		this.nitronsOxide = nitronsOxide;
	}



	/**
	 * Return the value associated with the column: profofol
	 */
	public java.lang.String getProfofol () {
		return profofol;
	}

	/**
	 * Set the value related to the column: profofol
	 * @param profofol the profofol value
	 */
	public void setProfofol (java.lang.String profofol) {
		this.profofol = profofol;
	}



	/**
	 * Return the value associated with the column: ketamine
	 */
	public java.lang.String getKetamine () {
		return ketamine;
	}

	/**
	 * Set the value related to the column: ketamine
	 * @param ketamine the ketamine value
	 */
	public void setKetamine (java.lang.String ketamine) {
		this.ketamine = ketamine;
	}



	/**
	 * Return the value associated with the column: bupivacaine
	 */
	public java.lang.String getBupivacaine () {
		return bupivacaine;
	}

	/**
	 * Set the value related to the column: bupivacaine
	 * @param bupivacaine the bupivacaine value
	 */
	public void setBupivacaine (java.lang.String bupivacaine) {
		this.bupivacaine = bupivacaine;
	}



	/**
	 * Return the value associated with the column: level_of_anesthesia
	 */
	public java.lang.String getLevelOfAnesthesia () {
		return levelOfAnesthesia;
	}

	/**
	 * Set the value related to the column: level_of_anesthesia
	 * @param levelOfAnesthesia the level_of_anesthesia value
	 */
	public void setLevelOfAnesthesia (java.lang.String levelOfAnesthesia) {
		this.levelOfAnesthesia = levelOfAnesthesia;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.Integer getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.Integer height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.Integer getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.Integer weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: bmi
	 */
	public java.lang.String getBmi () {
		return bmi;
	}

	/**
	 * Set the value related to the column: bmi
	 * @param bmi the bmi value
	 */
	public void setBmi (java.lang.String bmi) {
		this.bmi = bmi;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.String getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.String pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.String getBp () {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * @param bp the bp value
	 */
	public void setBp (java.lang.String bp) {
		this.bp = bp;
	}



	/**
	 * Return the value associated with the column: respiratory
	 */
	public java.lang.String getRespiratory () {
		return respiratory;
	}

	/**
	 * Set the value related to the column: respiratory
	 * @param respiratory the respiratory value
	 */
	public void setRespiratory (java.lang.String respiratory) {
		this.respiratory = respiratory;
	}



	/**
	 * Return the value associated with the column: bmi_status
	 */
	public java.lang.String getBmiStatus () {
		return bmiStatus;
	}

	/**
	 * Set the value related to the column: bmi_status
	 * @param bmiStatus the bmi_status value
	 */
	public void setBmiStatus (java.lang.String bmiStatus) {
		this.bmiStatus = bmiStatus;
	}



	/**
	 * Return the value associated with the column: reamrks_for_discharge_vital
	 */
	public java.lang.String getReamrksForDischargevital () {
		return reamrksForDischargevital;
	}

	/**
	 * Set the value related to the column: reamrks_for_discharge_vital
	 * @param reamrksForDischargevital the reamrks_for_discharge_vital value
	 */
	public void setReamrksForDischargevital (java.lang.String reamrksForDischargevital) {
		this.reamrksForDischargevital = reamrksForDischargevital;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: anesthesia_id
	 */
	public jkt.hms.masters.business.MasAnesthesia getAnesthesia () {
		return anesthesia;
	}

	/**
	 * Set the value related to the column: anesthesia_id
	 * @param anesthesia the anesthesia_id value
	 */
	public void setAnesthesia (jkt.hms.masters.business.MasAnesthesia anesthesia) {
		this.anesthesia = anesthesia;
	}



	/**
	 * Return the value associated with the column: booking_id
	 */
	public jkt.hms.masters.business.OtBooking getBooking () {
		return booking;
	}

	/**
	 * Set the value related to the column: booking_id
	 * @param booking the booking_id value
	 */
	public void setBooking (jkt.hms.masters.business.OtBooking booking) {
		this.booking = booking;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: in_patient_id
	 */
	public jkt.hms.masters.business.Inpatient getInPatient () {
		return inPatient;
	}

	/**
	 * Set the value related to the column: in_patient_id
	 * @param inPatient the in_patient_id value
	 */
	public void setInPatient (jkt.hms.masters.business.Inpatient inPatient) {
		this.inPatient = inPatient;
	}



	/**
	 * Return the value associated with the column: OtSurgeyPaAnesthesiologistDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail> getOtSurgeyPaAnesthesiologistDetails () {
		return otSurgeyPaAnesthesiologistDetails;
	}

	/**
	 * Set the value related to the column: OtSurgeyPaAnesthesiologistDetails
	 * @param otSurgeyPaAnesthesiologistDetails the OtSurgeyPaAnesthesiologistDetails value
	 */
	public void setOtSurgeyPaAnesthesiologistDetails (java.util.Set<jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail> otSurgeyPaAnesthesiologistDetails) {
		this.otSurgeyPaAnesthesiologistDetails = otSurgeyPaAnesthesiologistDetails;
	}

	public void addToOtSurgeyPaAnesthesiologistDetails (jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail otSurgeyPaAnesthesiologistDetail) {
		if (null == getOtSurgeyPaAnesthesiologistDetails()) setOtSurgeyPaAnesthesiologistDetails(new java.util.TreeSet<jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail>());
		getOtSurgeyPaAnesthesiologistDetails().add(otSurgeyPaAnesthesiologistDetail);
	}



	/**
	 * Return the value associated with the column: OtSurgeyPaEmployeeDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtSurgeyPaEmployeeDetail> getOtSurgeyPaEmployeeDetails () {
		return otSurgeyPaEmployeeDetails;
	}

	/**
	 * Set the value related to the column: OtSurgeyPaEmployeeDetails
	 * @param otSurgeyPaEmployeeDetails the OtSurgeyPaEmployeeDetails value
	 */
	public void setOtSurgeyPaEmployeeDetails (java.util.Set<jkt.hms.masters.business.OtSurgeyPaEmployeeDetail> otSurgeyPaEmployeeDetails) {
		this.otSurgeyPaEmployeeDetails = otSurgeyPaEmployeeDetails;
	}

	public void addToOtSurgeyPaEmployeeDetails (jkt.hms.masters.business.OtSurgeyPaEmployeeDetail otSurgeyPaEmployeeDetail) {
		if (null == getOtSurgeyPaEmployeeDetails()) setOtSurgeyPaEmployeeDetails(new java.util.TreeSet<jkt.hms.masters.business.OtSurgeyPaEmployeeDetail>());
		getOtSurgeyPaEmployeeDetails().add(otSurgeyPaEmployeeDetail);
	}



	/**
	 * Return the value associated with the column: OtSurgeyPaIvFluidsDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail> getOtSurgeyPaIvFluidsDetails () {
		return otSurgeyPaIvFluidsDetails;
	}

	/**
	 * Set the value related to the column: OtSurgeyPaIvFluidsDetails
	 * @param otSurgeyPaIvFluidsDetails the OtSurgeyPaIvFluidsDetails value
	 */
	public void setOtSurgeyPaIvFluidsDetails (java.util.Set<jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail> otSurgeyPaIvFluidsDetails) {
		this.otSurgeyPaIvFluidsDetails = otSurgeyPaIvFluidsDetails;
	}

	public void addToOtSurgeyPaIvFluidsDetails (jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail otSurgeyPaIvFluidsDetail) {
		if (null == getOtSurgeyPaIvFluidsDetails()) setOtSurgeyPaIvFluidsDetails(new java.util.TreeSet<jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail>());
		getOtSurgeyPaIvFluidsDetails().add(otSurgeyPaIvFluidsDetail);
	}



	/**
	 * Return the value associated with the column: OtSurgeyPaPremedicationDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtSurgeyPaPremedicationDetail> getOtSurgeyPaPremedicationDetails () {
		return otSurgeyPaPremedicationDetails;
	}

	/**
	 * Set the value related to the column: OtSurgeyPaPremedicationDetails
	 * @param otSurgeyPaPremedicationDetails the OtSurgeyPaPremedicationDetails value
	 */
	public void setOtSurgeyPaPremedicationDetails (java.util.Set<jkt.hms.masters.business.OtSurgeyPaPremedicationDetail> otSurgeyPaPremedicationDetails) {
		this.otSurgeyPaPremedicationDetails = otSurgeyPaPremedicationDetails;
	}

	public void addToOtSurgeyPaPremedicationDetails (jkt.hms.masters.business.OtSurgeyPaPremedicationDetail otSurgeyPaPremedicationDetail) {
		if (null == getOtSurgeyPaPremedicationDetails()) setOtSurgeyPaPremedicationDetails(new java.util.TreeSet<jkt.hms.masters.business.OtSurgeyPaPremedicationDetail>());
		getOtSurgeyPaPremedicationDetails().add(otSurgeyPaPremedicationDetail);
	}



	/**
	 * Return the value associated with the column: OtSurgeyPaSurgeyDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> getOtSurgeyPaSurgeyDetails () {
		return otSurgeyPaSurgeyDetails;
	}

	/**
	 * Set the value related to the column: OtSurgeyPaSurgeyDetails
	 * @param otSurgeyPaSurgeyDetails the OtSurgeyPaSurgeyDetails value
	 */
	public void setOtSurgeyPaSurgeyDetails (java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> otSurgeyPaSurgeyDetails) {
		this.otSurgeyPaSurgeyDetails = otSurgeyPaSurgeyDetails;
	}

	public void addToOtSurgeyPaSurgeyDetails (jkt.hms.masters.business.OtSurgeyPaSurgeyDetail otSurgeyPaSurgeyDetail) {
		if (null == getOtSurgeyPaSurgeyDetails()) setOtSurgeyPaSurgeyDetails(new java.util.TreeSet<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail>());
		getOtSurgeyPaSurgeyDetails().add(otSurgeyPaSurgeyDetail);
	}



	/**
	 * Return the value associated with the column: OtSurgeyPaProcedureDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtSurgeyPaProcedureDetail> getOtSurgeyPaProcedureDetails () {
		return otSurgeyPaProcedureDetails;
	}

	/**
	 * Set the value related to the column: OtSurgeyPaProcedureDetails
	 * @param otSurgeyPaProcedureDetails the OtSurgeyPaProcedureDetails value
	 */
	public void setOtSurgeyPaProcedureDetails (java.util.Set<jkt.hms.masters.business.OtSurgeyPaProcedureDetail> otSurgeyPaProcedureDetails) {
		this.otSurgeyPaProcedureDetails = otSurgeyPaProcedureDetails;
	}

	public void addToOtSurgeyPaProcedureDetails (jkt.hms.masters.business.OtSurgeyPaProcedureDetail otSurgeyPaProcedureDetail) {
		if (null == getOtSurgeyPaProcedureDetails()) setOtSurgeyPaProcedureDetails(new java.util.TreeSet<jkt.hms.masters.business.OtSurgeyPaProcedureDetail>());
		getOtSurgeyPaProcedureDetails().add(otSurgeyPaProcedureDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPostAnaesthesiaProcedure)) return false;
		else {
			jkt.hms.masters.business.OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (jkt.hms.masters.business.OtPostAnaesthesiaProcedure) obj;
			if (null == this.getId() || null == otPostAnaesthesiaProcedure.getId()) return false;
			else return (this.getId().equals(otPostAnaesthesiaProcedure.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}