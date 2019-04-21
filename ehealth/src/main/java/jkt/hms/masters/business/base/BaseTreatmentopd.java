package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the treatmentopd table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="treatmentopd"
 */

public abstract class BaseTreatmentopd  implements Serializable {

	public static String REF = "Treatmentopd";
	public static String PROP_DIAGNOSISID = "Diagnosisid";
	public static String PROP_SUCTIONING = "Suctioning";
	public static String PROP_TTIME = "Ttime";
	public static String PROP_NEBULISATION = "Nebulisation";
	public static String PROP_MOBILISATION = "Mobilisation";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INITIALVENTILATORSETTING = "Initialventilatorsetting";
	public static String PROP_ANYOTHER = "Anyother";
	public static String PROP_REFERRALSADVICE = "Referralsadvice";
	public static String PROP_NUTRITION = "Nutrition";
	public static String PROP_INCHARGEDR = "Inchargedr";
	public static String PROP_QTY = "Qty";
	public static String PROP_FINANCIALYEARID = "Financialyearid";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_SPIROMETRY = "Spirometry";
	public static String PROP_DRUGGROUPID_R = "DruggroupidR";
	public static String PROP_DAYS = "Days";
	public static String PROP_ENEMA = "Enema";
	public static String PROP_INVESTIGATIONS = "Investigations";
	public static String PROP_TDATE = "Tdate";
	public static String PROP_CHESTPT = "Chestpt";
	public static String PROP_DRUGGROUPID = "Druggroupid";
	public static String PROP_HGT = "Hgt";
	public static String PROP_DOSE = "Dose";
	public static String PROP_DEEPBREATHEXERCISE = "Deepbreathexercise";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_OPDNO = "Opdno";
	public static String PROP_NOTE = "Note";
	public static String PROP_CHANGEOFPOSITION = "Changeofposition";
	public static String PROP_T_FLAG = "TFlag";
	public static String PROP_DRUGID = "Drugid";
	public static String PROP_OXYGEN = "Oxygen";
	public static String PROP_IVFLUID = "Ivfluid";
	public static String PROP_VITALSIGNS = "Vitalsigns";
	public static String PROP_ID = "Id";
	public static String PROP_DRUGDESCRIPTION = "Drugdescription";
	public static String PROP_DRNAME = "Drname";
	public static String PROP_MONITORPERPHERALPULSES = "Monitorperpheralpulses";
	public static String PROP_STEAMINHALATION = "Steaminhalation";
	public static String PROP_REGNO = "Regno";


	// constructors
	public BaseTreatmentopd () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTreatmentopd (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String regno;
	private java.lang.String opdno;
	private java.util.Date tdate;
	private java.util.Date ttime;
	private java.lang.String diagnosisid;
	private java.lang.Integer drugid;
	private java.lang.Integer druggroupid;
	private java.lang.String dose;
	private java.lang.Integer days;
	private java.lang.String note;
	private java.lang.Integer financialyearid;
	private java.lang.Integer qty;
	private boolean tFlag;
	private java.lang.String drugdescription;
	private java.lang.String diagnosis;
	private java.lang.String chestpt;
	private java.lang.String steaminhalation;
	private java.lang.String spirometry;
	private java.lang.String deepbreathexercise;
	private java.lang.String nebulisation;
	private java.lang.String changeofposition;
	private java.lang.String vitalsigns;
	private java.lang.String hgt;
	private java.lang.String mobilisation;
	private java.lang.String monitorperpheralpulses;
	private java.lang.String suctioning;
	private java.lang.String initialventilatorsetting;
	private java.lang.String oxygen;
	private java.lang.String enema;
	private java.lang.String anyother;
	private java.lang.String investigations;
	private java.lang.String nutrition;
	private java.lang.String referralsadvice;
	private java.lang.String ivfluid;
	private java.lang.String inchargedr;
	private java.lang.String drname;
	private java.lang.Integer druggroupidR;
	private java.util.Date lastChgDate;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="treatmentno"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: regno
	 */
	public java.lang.String getRegno () {
		return regno;
	}

	/**
	 * Set the value related to the column: regno
	 * @param regno the regno value
	 */
	public void setRegno (java.lang.String regno) {
		this.regno = regno;
	}



	/**
	 * Return the value associated with the column: opdno
	 */
	public java.lang.String getOpdno () {
		return opdno;
	}

	/**
	 * Set the value related to the column: opdno
	 * @param opdno the opdno value
	 */
	public void setOpdno (java.lang.String opdno) {
		this.opdno = opdno;
	}



	/**
	 * Return the value associated with the column: tdate
	 */
	public java.util.Date getTdate () {
		return tdate;
	}

	/**
	 * Set the value related to the column: tdate
	 * @param tdate the tdate value
	 */
	public void setTdate (java.util.Date tdate) {
		this.tdate = tdate;
	}



	/**
	 * Return the value associated with the column: ttime
	 */
	public java.util.Date getTtime () {
		return ttime;
	}

	/**
	 * Set the value related to the column: ttime
	 * @param ttime the ttime value
	 */
	public void setTtime (java.util.Date ttime) {
		this.ttime = ttime;
	}



	/**
	 * Return the value associated with the column: diagnosisid
	 */
	public java.lang.String getDiagnosisid () {
		return diagnosisid;
	}

	/**
	 * Set the value related to the column: diagnosisid
	 * @param diagnosisid the diagnosisid value
	 */
	public void setDiagnosisid (java.lang.String diagnosisid) {
		this.diagnosisid = diagnosisid;
	}



	/**
	 * Return the value associated with the column: drugid
	 */
	public java.lang.Integer getDrugid () {
		return drugid;
	}

	/**
	 * Set the value related to the column: drugid
	 * @param drugid the drugid value
	 */
	public void setDrugid (java.lang.Integer drugid) {
		this.drugid = drugid;
	}



	/**
	 * Return the value associated with the column: druggroupid
	 */
	public java.lang.Integer getDruggroupid () {
		return druggroupid;
	}

	/**
	 * Set the value related to the column: druggroupid
	 * @param druggroupid the druggroupid value
	 */
	public void setDruggroupid (java.lang.Integer druggroupid) {
		this.druggroupid = druggroupid;
	}



	/**
	 * Return the value associated with the column: dose
	 */
	public java.lang.String getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * @param dose the dose value
	 */
	public void setDose (java.lang.String dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.Integer getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.Integer days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: note
	 */
	public java.lang.String getNote () {
		return note;
	}

	/**
	 * Set the value related to the column: note
	 * @param note the note value
	 */
	public void setNote (java.lang.String note) {
		this.note = note;
	}



	/**
	 * Return the value associated with the column: financialyearid
	 */
	public java.lang.Integer getFinancialyearid () {
		return financialyearid;
	}

	/**
	 * Set the value related to the column: financialyearid
	 * @param financialyearid the financialyearid value
	 */
	public void setFinancialyearid (java.lang.Integer financialyearid) {
		this.financialyearid = financialyearid;
	}



	/**
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.lang.Integer qty) {
		this.qty = qty;
	}



	/**
	 * Return the value associated with the column: t_flag
	 */
	public boolean isTFlag () {
		return tFlag;
	}

	/**
	 * Set the value related to the column: t_flag
	 * @param tFlag the t_flag value
	 */
	public void setTFlag (boolean tFlag) {
		this.tFlag = tFlag;
	}



	/**
	 * Return the value associated with the column: drugdescription
	 */
	public java.lang.String getDrugdescription () {
		return drugdescription;
	}

	/**
	 * Set the value related to the column: drugdescription
	 * @param drugdescription the drugdescription value
	 */
	public void setDrugdescription (java.lang.String drugdescription) {
		this.drugdescription = drugdescription;
	}



	/**
	 * Return the value associated with the column: diagnosis
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis
	 * @param diagnosis the diagnosis value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: chestpt
	 */
	public java.lang.String getChestpt () {
		return chestpt;
	}

	/**
	 * Set the value related to the column: chestpt
	 * @param chestpt the chestpt value
	 */
	public void setChestpt (java.lang.String chestpt) {
		this.chestpt = chestpt;
	}



	/**
	 * Return the value associated with the column: steaminhalation
	 */
	public java.lang.String getSteaminhalation () {
		return steaminhalation;
	}

	/**
	 * Set the value related to the column: steaminhalation
	 * @param steaminhalation the steaminhalation value
	 */
	public void setSteaminhalation (java.lang.String steaminhalation) {
		this.steaminhalation = steaminhalation;
	}



	/**
	 * Return the value associated with the column: spirometry
	 */
	public java.lang.String getSpirometry () {
		return spirometry;
	}

	/**
	 * Set the value related to the column: spirometry
	 * @param spirometry the spirometry value
	 */
	public void setSpirometry (java.lang.String spirometry) {
		this.spirometry = spirometry;
	}



	/**
	 * Return the value associated with the column: deepbreathexercise
	 */
	public java.lang.String getDeepbreathexercise () {
		return deepbreathexercise;
	}

	/**
	 * Set the value related to the column: deepbreathexercise
	 * @param deepbreathexercise the deepbreathexercise value
	 */
	public void setDeepbreathexercise (java.lang.String deepbreathexercise) {
		this.deepbreathexercise = deepbreathexercise;
	}



	/**
	 * Return the value associated with the column: nebulisation
	 */
	public java.lang.String getNebulisation () {
		return nebulisation;
	}

	/**
	 * Set the value related to the column: nebulisation
	 * @param nebulisation the nebulisation value
	 */
	public void setNebulisation (java.lang.String nebulisation) {
		this.nebulisation = nebulisation;
	}



	/**
	 * Return the value associated with the column: changeofposition
	 */
	public java.lang.String getChangeofposition () {
		return changeofposition;
	}

	/**
	 * Set the value related to the column: changeofposition
	 * @param changeofposition the changeofposition value
	 */
	public void setChangeofposition (java.lang.String changeofposition) {
		this.changeofposition = changeofposition;
	}



	/**
	 * Return the value associated with the column: vitalsigns
	 */
	public java.lang.String getVitalsigns () {
		return vitalsigns;
	}

	/**
	 * Set the value related to the column: vitalsigns
	 * @param vitalsigns the vitalsigns value
	 */
	public void setVitalsigns (java.lang.String vitalsigns) {
		this.vitalsigns = vitalsigns;
	}



	/**
	 * Return the value associated with the column: hgt
	 */
	public java.lang.String getHgt () {
		return hgt;
	}

	/**
	 * Set the value related to the column: hgt
	 * @param hgt the hgt value
	 */
	public void setHgt (java.lang.String hgt) {
		this.hgt = hgt;
	}



	/**
	 * Return the value associated with the column: mobilisation
	 */
	public java.lang.String getMobilisation () {
		return mobilisation;
	}

	/**
	 * Set the value related to the column: mobilisation
	 * @param mobilisation the mobilisation value
	 */
	public void setMobilisation (java.lang.String mobilisation) {
		this.mobilisation = mobilisation;
	}



	/**
	 * Return the value associated with the column: monitorperpheralpulses
	 */
	public java.lang.String getMonitorperpheralpulses () {
		return monitorperpheralpulses;
	}

	/**
	 * Set the value related to the column: monitorperpheralpulses
	 * @param monitorperpheralpulses the monitorperpheralpulses value
	 */
	public void setMonitorperpheralpulses (java.lang.String monitorperpheralpulses) {
		this.monitorperpheralpulses = monitorperpheralpulses;
	}



	/**
	 * Return the value associated with the column: suctioning
	 */
	public java.lang.String getSuctioning () {
		return suctioning;
	}

	/**
	 * Set the value related to the column: suctioning
	 * @param suctioning the suctioning value
	 */
	public void setSuctioning (java.lang.String suctioning) {
		this.suctioning = suctioning;
	}



	/**
	 * Return the value associated with the column: initialventilatorsetting
	 */
	public java.lang.String getInitialventilatorsetting () {
		return initialventilatorsetting;
	}

	/**
	 * Set the value related to the column: initialventilatorsetting
	 * @param initialventilatorsetting the initialventilatorsetting value
	 */
	public void setInitialventilatorsetting (java.lang.String initialventilatorsetting) {
		this.initialventilatorsetting = initialventilatorsetting;
	}



	/**
	 * Return the value associated with the column: oxygen
	 */
	public java.lang.String getOxygen () {
		return oxygen;
	}

	/**
	 * Set the value related to the column: oxygen
	 * @param oxygen the oxygen value
	 */
	public void setOxygen (java.lang.String oxygen) {
		this.oxygen = oxygen;
	}



	/**
	 * Return the value associated with the column: enema
	 */
	public java.lang.String getEnema () {
		return enema;
	}

	/**
	 * Set the value related to the column: enema
	 * @param enema the enema value
	 */
	public void setEnema (java.lang.String enema) {
		this.enema = enema;
	}



	/**
	 * Return the value associated with the column: anyother
	 */
	public java.lang.String getAnyother () {
		return anyother;
	}

	/**
	 * Set the value related to the column: anyother
	 * @param anyother the anyother value
	 */
	public void setAnyother (java.lang.String anyother) {
		this.anyother = anyother;
	}



	/**
	 * Return the value associated with the column: investigations
	 */
	public java.lang.String getInvestigations () {
		return investigations;
	}

	/**
	 * Set the value related to the column: investigations
	 * @param investigations the investigations value
	 */
	public void setInvestigations (java.lang.String investigations) {
		this.investigations = investigations;
	}



	/**
	 * Return the value associated with the column: nutrition
	 */
	public java.lang.String getNutrition () {
		return nutrition;
	}

	/**
	 * Set the value related to the column: nutrition
	 * @param nutrition the nutrition value
	 */
	public void setNutrition (java.lang.String nutrition) {
		this.nutrition = nutrition;
	}



	/**
	 * Return the value associated with the column: referralsadvice
	 */
	public java.lang.String getReferralsadvice () {
		return referralsadvice;
	}

	/**
	 * Set the value related to the column: referralsadvice
	 * @param referralsadvice the referralsadvice value
	 */
	public void setReferralsadvice (java.lang.String referralsadvice) {
		this.referralsadvice = referralsadvice;
	}



	/**
	 * Return the value associated with the column: ivfluid
	 */
	public java.lang.String getIvfluid () {
		return ivfluid;
	}

	/**
	 * Set the value related to the column: ivfluid
	 * @param ivfluid the ivfluid value
	 */
	public void setIvfluid (java.lang.String ivfluid) {
		this.ivfluid = ivfluid;
	}



	/**
	 * Return the value associated with the column: inchargedr
	 */
	public java.lang.String getInchargedr () {
		return inchargedr;
	}

	/**
	 * Set the value related to the column: inchargedr
	 * @param inchargedr the inchargedr value
	 */
	public void setInchargedr (java.lang.String inchargedr) {
		this.inchargedr = inchargedr;
	}



	/**
	 * Return the value associated with the column: drname
	 */
	public java.lang.String getDrname () {
		return drname;
	}

	/**
	 * Set the value related to the column: drname
	 * @param drname the drname value
	 */
	public void setDrname (java.lang.String drname) {
		this.drname = drname;
	}



	/**
	 * Return the value associated with the column: druggroupid_r
	 */
	public java.lang.Integer getDruggroupidR () {
		return druggroupidR;
	}

	/**
	 * Set the value related to the column: druggroupid_r
	 * @param druggroupidR the druggroupid_r value
	 */
	public void setDruggroupidR (java.lang.Integer druggroupidR) {
		this.druggroupidR = druggroupidR;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Treatmentopd)) return false;
		else {
			jkt.hms.masters.business.Treatmentopd treatmentopd = (jkt.hms.masters.business.Treatmentopd) obj;
			if (null == this.getId() || null == treatmentopd.getId()) return false;
			else return (this.getId().equals(treatmentopd.getId()));
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