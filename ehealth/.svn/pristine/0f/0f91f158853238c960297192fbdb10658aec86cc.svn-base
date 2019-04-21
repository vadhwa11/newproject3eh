package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_antenatal_card_trimester table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_antenatal_card_trimester"
 */

public abstract class BaseOpdAntenatalCardTrimester  implements Serializable {

	public static String REF = "OpdAntenatalCardTrimester";
	public static String PROP_URIN_ALBUMIN = "urinAlbumin";
	public static String PROP_SYSTEMIC_EXAMIN = "systemicExamin";
	public static String PROP_CVS = "cvs";
	public static String PROP_BP_DIASTOLICS = "BpDiastolics";
	public static String PROP_BP_SYSTOLICS = "BpSystolics";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ODEMIA = "Odemia";
	public static String PROP_FT_ADVICE = "ftAdvice";
	public static String PROP_FHS = "fhs";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_OTHERS_FIRST_TRIMSTER = "OthersFirstTrimster";
	public static String PROP_RESP_SYSTEM = "respSystem";
	public static String PROP_PV_TRIMES = "PvTrimes";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_OBSTETRIC_RISK_MEASURE = "obstetricRiskMeasure";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OTHERS = "Others";
	public static String PROP_FH = "fh";
	public static String PROP_TRIMESTER_TYPE = "trimesterType";
	public static String PROP_ANTENATAL_CARD = "AntenatalCard";
	public static String PROP_PA_TRIMES = "PaTrimes";
	public static String PROP_GENERAL_EXAMINATION = "GeneralExamination";
	public static String PROP_HIN = "Hin";
	public static String PROP_GA_DAYS = "GaDays";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_ANT_FTDAE = "antFtdae";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PALLOR = "Pallor";
	public static String PROP_LOCAL_EXAMINATION = "LocalExamination";
	public static String PROP_ID = "Id";
	public static String PROP_GA_WEEKS = "GaWeeks";
	public static String PROP_TRIMES_DATE = "TrimesDate";


	// constructors
	public BaseOpdAntenatalCardTrimester () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdAntenatalCardTrimester (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date trimesDate;
	private java.lang.String gaWeeks;
	private java.lang.String gaDays;
	private java.lang.String bpSystolics;
	private java.lang.String bpDiastolics;
	private java.lang.String paTrimes;
	private java.lang.String pvTrimes;
	private java.math.BigDecimal weight;
	private java.lang.String urinAlbumin;
	private java.lang.Integer trimesterType;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String cvs;
	private java.lang.String respSystem;
	private java.lang.String ftAdvice;
	private java.util.Date antFtdae;
	private java.lang.String pallor;
	private java.lang.String odemia;
	private java.lang.String systemicExamin;
	private java.lang.String obstetricRiskMeasure;
	private java.lang.Integer fhs;
	private java.lang.String generalExamination;
	private java.lang.String fh;
	private java.lang.String localExamination;
	private java.lang.String othersFirstTrimster;
	private java.lang.String others;

	// many to one
	private jkt.hms.masters.business.OpdAntenatalCard antenatalCard;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_antenatal_card_trimester_id"
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
	 * Return the value associated with the column: trimes_date
	 */
	public java.util.Date getTrimesDate () {
		return trimesDate;
	}

	/**
	 * Set the value related to the column: trimes_date
	 * @param trimesDate the trimes_date value
	 */
	public void setTrimesDate (java.util.Date trimesDate) {
		this.trimesDate = trimesDate;
	}



	/**
	 * Return the value associated with the column: ga_weeks
	 */
	public java.lang.String getGaWeeks () {
		return gaWeeks;
	}

	/**
	 * Set the value related to the column: ga_weeks
	 * @param gaWeeks the ga_weeks value
	 */
	public void setGaWeeks (java.lang.String gaWeeks) {
		this.gaWeeks = gaWeeks;
	}



	/**
	 * Return the value associated with the column: ga_days
	 */
	public java.lang.String getGaDays () {
		return gaDays;
	}

	/**
	 * Set the value related to the column: ga_days
	 * @param gaDays the ga_days value
	 */
	public void setGaDays (java.lang.String gaDays) {
		this.gaDays = gaDays;
	}



	/**
	 * Return the value associated with the column: bp_systolics
	 */
	public java.lang.String getBpSystolics () {
		return bpSystolics;
	}

	/**
	 * Set the value related to the column: bp_systolics
	 * @param bpSystolics the bp_systolics value
	 */
	public void setBpSystolics (java.lang.String bpSystolics) {
		this.bpSystolics = bpSystolics;
	}



	/**
	 * Return the value associated with the column: bp_diastolics
	 */
	public java.lang.String getBpDiastolics () {
		return bpDiastolics;
	}

	/**
	 * Set the value related to the column: bp_diastolics
	 * @param bpDiastolics the bp_diastolics value
	 */
	public void setBpDiastolics (java.lang.String bpDiastolics) {
		this.bpDiastolics = bpDiastolics;
	}



	/**
	 * Return the value associated with the column: pa_trimes
	 */
	public java.lang.String getPaTrimes () {
		return paTrimes;
	}

	/**
	 * Set the value related to the column: pa_trimes
	 * @param paTrimes the pa_trimes value
	 */
	public void setPaTrimes (java.lang.String paTrimes) {
		this.paTrimes = paTrimes;
	}



	/**
	 * Return the value associated with the column: pv_trimes
	 */
	public java.lang.String getPvTrimes () {
		return pvTrimes;
	}

	/**
	 * Set the value related to the column: pv_trimes
	 * @param pvTrimes the pv_trimes value
	 */
	public void setPvTrimes (java.lang.String pvTrimes) {
		this.pvTrimes = pvTrimes;
	}



	/**
	 * Return the value associated with the column: weght
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weght
	 * @param weight the weght value
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: urine_albumin
	 */
	public java.lang.String getUrinAlbumin () {
		return urinAlbumin;
	}

	/**
	 * Set the value related to the column: urine_albumin
	 * @param urinAlbumin the urine_albumin value
	 */
	public void setUrinAlbumin (java.lang.String urinAlbumin) {
		this.urinAlbumin = urinAlbumin;
	}



	/**
	 * Return the value associated with the column: trimester_type
	 */
	public java.lang.Integer getTrimesterType () {
		return trimesterType;
	}

	/**
	 * Set the value related to the column: trimester_type
	 * @param trimesterType the trimester_type value
	 */
	public void setTrimesterType (java.lang.Integer trimesterType) {
		this.trimesterType = trimesterType;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: cvs
	 */
	public java.lang.String getCvs () {
		return cvs;
	}

	/**
	 * Set the value related to the column: cvs
	 * @param cvs the cvs value
	 */
	public void setCvs (java.lang.String cvs) {
		this.cvs = cvs;
	}



	/**
	 * Return the value associated with the column: resp_system
	 */
	public java.lang.String getRespSystem () {
		return respSystem;
	}

	/**
	 * Set the value related to the column: resp_system
	 * @param respSystem the resp_system value
	 */
	public void setRespSystem (java.lang.String respSystem) {
		this.respSystem = respSystem;
	}



	/**
	 * Return the value associated with the column: advise
	 */
	public java.lang.String getFtAdvice () {
		return ftAdvice;
	}

	/**
	 * Set the value related to the column: advise
	 * @param ftAdvice the advise value
	 */
	public void setFtAdvice (java.lang.String ftAdvice) {
		this.ftAdvice = ftAdvice;
	}



	/**
	 * Return the value associated with the column: ant_ftdate
	 */
	public java.util.Date getAntFtdae () {
		return antFtdae;
	}

	/**
	 * Set the value related to the column: ant_ftdate
	 * @param antFtdae the ant_ftdate value
	 */
	public void setAntFtdae (java.util.Date antFtdae) {
		this.antFtdae = antFtdae;
	}



	/**
	 * Return the value associated with the column: pallor
	 */
	public java.lang.String getPallor () {
		return pallor;
	}

	/**
	 * Set the value related to the column: pallor
	 * @param pallor the pallor value
	 */
	public void setPallor (java.lang.String pallor) {
		this.pallor = pallor;
	}



	/**
	 * Return the value associated with the column: odemia
	 */
	public java.lang.String getOdemia () {
		return odemia;
	}

	/**
	 * Set the value related to the column: odemia
	 * @param odemia the odemia value
	 */
	public void setOdemia (java.lang.String odemia) {
		this.odemia = odemia;
	}



	/**
	 * Return the value associated with the column: systemic_examin
	 */
	public java.lang.String getSystemicExamin () {
		return systemicExamin;
	}

	/**
	 * Set the value related to the column: systemic_examin
	 * @param systemicExamin the systemic_examin value
	 */
	public void setSystemicExamin (java.lang.String systemicExamin) {
		this.systemicExamin = systemicExamin;
	}



	/**
	 * Return the value associated with the column: obstetric_risk_measure
	 */
	public java.lang.String getObstetricRiskMeasure () {
		return obstetricRiskMeasure;
	}

	/**
	 * Set the value related to the column: obstetric_risk_measure
	 * @param obstetricRiskMeasure the obstetric_risk_measure value
	 */
	public void setObstetricRiskMeasure (java.lang.String obstetricRiskMeasure) {
		this.obstetricRiskMeasure = obstetricRiskMeasure;
	}



	/**
	 * Return the value associated with the column: fhs
	 */
	public java.lang.Integer getFhs () {
		return fhs;
	}

	/**
	 * Set the value related to the column: fhs
	 * @param fhs the fhs value
	 */
	public void setFhs (java.lang.Integer fhs) {
		this.fhs = fhs;
	}



	/**
	 * Return the value associated with the column: general_examination
	 */
	public java.lang.String getGeneralExamination () {
		return generalExamination;
	}

	/**
	 * Set the value related to the column: general_examination
	 * @param generalExamination the general_examination value
	 */
	public void setGeneralExamination (java.lang.String generalExamination) {
		this.generalExamination = generalExamination;
	}



	/**
	 * Return the value associated with the column: fh
	 */
	public java.lang.String getFh () {
		return fh;
	}

	/**
	 * Set the value related to the column: fh
	 * @param fh the fh value
	 */
	public void setFh (java.lang.String fh) {
		this.fh = fh;
	}



	/**
	 * Return the value associated with the column: local_examination
	 */
	public java.lang.String getLocalExamination () {
		return localExamination;
	}

	/**
	 * Set the value related to the column: local_examination
	 * @param localExamination the local_examination value
	 */
	public void setLocalExamination (java.lang.String localExamination) {
		this.localExamination = localExamination;
	}



	/**
	 * Return the value associated with the column: others_first_trimster
	 */
	public java.lang.String getOthersFirstTrimster () {
		return othersFirstTrimster;
	}

	/**
	 * Set the value related to the column: others_first_trimster
	 * @param othersFirstTrimster the others_first_trimster value
	 */
	public void setOthersFirstTrimster (java.lang.String othersFirstTrimster) {
		this.othersFirstTrimster = othersFirstTrimster;
	}



	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.String getOthers () {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * @param others the others value
	 */
	public void setOthers (java.lang.String others) {
		this.others = others;
	}



	/**
	 * Return the value associated with the column: opd_antenatal_card_id
	 */
	public jkt.hms.masters.business.OpdAntenatalCard getAntenatalCard () {
		return antenatalCard;
	}

	/**
	 * Set the value related to the column: opd_antenatal_card_id
	 * @param antenatalCard the opd_antenatal_card_id value
	 */
	public void setAntenatalCard (jkt.hms.masters.business.OpdAntenatalCard antenatalCard) {
		this.antenatalCard = antenatalCard;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdAntenatalCardTrimester)) return false;
		else {
			jkt.hms.masters.business.OpdAntenatalCardTrimester opdAntenatalCardTrimester = (jkt.hms.masters.business.OpdAntenatalCardTrimester) obj;
			if (null == this.getId() || null == opdAntenatalCardTrimester.getId()) return false;
			else return (this.getId().equals(opdAntenatalCardTrimester.getId()));
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