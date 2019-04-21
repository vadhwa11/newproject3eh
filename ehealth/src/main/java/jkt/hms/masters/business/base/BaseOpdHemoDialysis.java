package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_hemo_dialysis table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_hemo_dialysis"
 */

public abstract class BaseOpdHemoDialysis  implements Serializable {

	public static String REF = "OpdHemoDialysis";
	public static String PROP_DIALYSIS_ACCESS1 = "DialysisAccess1";
	public static String PROP_DIALYSATE_FLOW_RATE = "DialysateFlowRate";
	public static String PROP_DIALYSIS_DATE = "DialysisDate";
	public static String PROP_DIALYSIS_ACCESS2 = "DialysisAccess2";
	public static String PROP_PRE_HD_WEIGHT = "PreHdWeight";
	public static String PROP_BLOOD_FLOW_RATE = "BloodFlowRate";
	public static String PROP_EVENTS_COMPLICATIONS = "EventsComplications";
	public static String PROP_VITAL_PULSE = "VitalPulse";
	public static String PROP_VITAL_DATE_TIME = "VitalDateTime";
	public static String PROP_UF = "Uf";
	public static String PROP_DIALYSIS_HD_NO = "DialysisHdNo";
	public static String PROP_WEIGHT_GAIN = "WeightGain";
	public static String PROP_KT_V = "KtV";
	public static String PROP_URR = "Urr";
	public static String PROP_VITAL_BP = "VitalBp";
	public static String PROP_NEXT_DIALYSIS_TIME = "NextDialysisTime";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_NEXT_DIALYSIS_DATE = "NextDialysisDate";
	public static String PROP_ID = "Id";
	public static String PROP_VITAL_TEMPERATURE = "VitalTemperature";
	public static String PROP_POST_HD_WEIGHT = "PostHdWeight";
	public static String PROP_HEPARIN_DOSE = "HeparinDose";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOpdHemoDialysis () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdHemoDialysis (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dialysisDate;
	private java.lang.Integer dialysisHdNo;
	private java.lang.String dialysisAccess1;
	private java.lang.String dialysisAccess2;
	private java.math.BigDecimal preHdWeight;
	private java.math.BigDecimal postHdWeight;
	private java.math.BigDecimal weightGain;
	private java.lang.String heparinDose;
	private java.lang.Integer bloodFlowRate;
	private java.lang.Integer dialysateFlowRate;
	private java.lang.Integer ktV;
	private java.lang.Integer urr;
	private java.lang.Integer uf;
	private java.lang.String nextDialysisDate;
	private java.lang.String nextDialysisTime;
	private java.lang.String eventsComplications;
	private java.lang.String vitalDateTime;
	private java.lang.String vitalBp;
	private java.lang.Integer vitalPulse;
	private java.math.BigDecimal vitalTemperature;

	// many to one
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="hemo_dialysis_id"
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
	 * Return the value associated with the column: dialysis_date
	 */
	public java.lang.String getDialysisDate () {
		return dialysisDate;
	}

	/**
	 * Set the value related to the column: dialysis_date
	 * @param dialysisDate the dialysis_date value
	 */
	public void setDialysisDate (java.lang.String dialysisDate) {
		this.dialysisDate = dialysisDate;
	}



	/**
	 * Return the value associated with the column: dialysis_hd_no
	 */
	public java.lang.Integer getDialysisHdNo () {
		return dialysisHdNo;
	}

	/**
	 * Set the value related to the column: dialysis_hd_no
	 * @param dialysisHdNo the dialysis_hd_no value
	 */
	public void setDialysisHdNo (java.lang.Integer dialysisHdNo) {
		this.dialysisHdNo = dialysisHdNo;
	}



	/**
	 * Return the value associated with the column: dialysis_access1
	 */
	public java.lang.String getDialysisAccess1 () {
		return dialysisAccess1;
	}

	/**
	 * Set the value related to the column: dialysis_access1
	 * @param dialysisAccess1 the dialysis_access1 value
	 */
	public void setDialysisAccess1 (java.lang.String dialysisAccess1) {
		this.dialysisAccess1 = dialysisAccess1;
	}



	/**
	 * Return the value associated with the column: dialysis_access2
	 */
	public java.lang.String getDialysisAccess2 () {
		return dialysisAccess2;
	}

	/**
	 * Set the value related to the column: dialysis_access2
	 * @param dialysisAccess2 the dialysis_access2 value
	 */
	public void setDialysisAccess2 (java.lang.String dialysisAccess2) {
		this.dialysisAccess2 = dialysisAccess2;
	}



	/**
	 * Return the value associated with the column: pre_hd_weight
	 */
	public java.math.BigDecimal getPreHdWeight () {
		return preHdWeight;
	}

	/**
	 * Set the value related to the column: pre_hd_weight
	 * @param preHdWeight the pre_hd_weight value
	 */
	public void setPreHdWeight (java.math.BigDecimal preHdWeight) {
		this.preHdWeight = preHdWeight;
	}



	/**
	 * Return the value associated with the column: post_hd_weight
	 */
	public java.math.BigDecimal getPostHdWeight () {
		return postHdWeight;
	}

	/**
	 * Set the value related to the column: post_hd_weight
	 * @param postHdWeight the post_hd_weight value
	 */
	public void setPostHdWeight (java.math.BigDecimal postHdWeight) {
		this.postHdWeight = postHdWeight;
	}



	/**
	 * Return the value associated with the column: weight_gain
	 */
	public java.math.BigDecimal getWeightGain () {
		return weightGain;
	}

	/**
	 * Set the value related to the column: weight_gain
	 * @param weightGain the weight_gain value
	 */
	public void setWeightGain (java.math.BigDecimal weightGain) {
		this.weightGain = weightGain;
	}



	/**
	 * Return the value associated with the column: heparin_dose
	 */
	public java.lang.String getHeparinDose () {
		return heparinDose;
	}

	/**
	 * Set the value related to the column: heparin_dose
	 * @param heparinDose the heparin_dose value
	 */
	public void setHeparinDose (java.lang.String heparinDose) {
		this.heparinDose = heparinDose;
	}



	/**
	 * Return the value associated with the column: blood_flow_rate
	 */
	public java.lang.Integer getBloodFlowRate () {
		return bloodFlowRate;
	}

	/**
	 * Set the value related to the column: blood_flow_rate
	 * @param bloodFlowRate the blood_flow_rate value
	 */
	public void setBloodFlowRate (java.lang.Integer bloodFlowRate) {
		this.bloodFlowRate = bloodFlowRate;
	}



	/**
	 * Return the value associated with the column: dialysate_flow_rate
	 */
	public java.lang.Integer getDialysateFlowRate () {
		return dialysateFlowRate;
	}

	/**
	 * Set the value related to the column: dialysate_flow_rate
	 * @param dialysateFlowRate the dialysate_flow_rate value
	 */
	public void setDialysateFlowRate (java.lang.Integer dialysateFlowRate) {
		this.dialysateFlowRate = dialysateFlowRate;
	}



	/**
	 * Return the value associated with the column: kt_v
	 */
	public java.lang.Integer getKtV () {
		return ktV;
	}

	/**
	 * Set the value related to the column: kt_v
	 * @param ktV the kt_v value
	 */
	public void setKtV (java.lang.Integer ktV) {
		this.ktV = ktV;
	}



	/**
	 * Return the value associated with the column: urr
	 */
	public java.lang.Integer getUrr () {
		return urr;
	}

	/**
	 * Set the value related to the column: urr
	 * @param urr the urr value
	 */
	public void setUrr (java.lang.Integer urr) {
		this.urr = urr;
	}



	/**
	 * Return the value associated with the column: uf
	 */
	public java.lang.Integer getUf () {
		return uf;
	}

	/**
	 * Set the value related to the column: uf
	 * @param uf the uf value
	 */
	public void setUf (java.lang.Integer uf) {
		this.uf = uf;
	}



	/**
	 * Return the value associated with the column: next_dialysis_date
	 */
	public java.lang.String getNextDialysisDate () {
		return nextDialysisDate;
	}

	/**
	 * Set the value related to the column: next_dialysis_date
	 * @param nextDialysisDate the next_dialysis_date value
	 */
	public void setNextDialysisDate (java.lang.String nextDialysisDate) {
		this.nextDialysisDate = nextDialysisDate;
	}



	/**
	 * Return the value associated with the column: next_dialysis_time
	 */
	public java.lang.String getNextDialysisTime () {
		return nextDialysisTime;
	}

	/**
	 * Set the value related to the column: next_dialysis_time
	 * @param nextDialysisTime the next_dialysis_time value
	 */
	public void setNextDialysisTime (java.lang.String nextDialysisTime) {
		this.nextDialysisTime = nextDialysisTime;
	}



	/**
	 * Return the value associated with the column: events_complications
	 */
	public java.lang.String getEventsComplications () {
		return eventsComplications;
	}

	/**
	 * Set the value related to the column: events_complications
	 * @param eventsComplications the events_complications value
	 */
	public void setEventsComplications (java.lang.String eventsComplications) {
		this.eventsComplications = eventsComplications;
	}



	/**
	 * Return the value associated with the column: vital_date_time
	 */
	public java.lang.String getVitalDateTime () {
		return vitalDateTime;
	}

	/**
	 * Set the value related to the column: vital_date_time
	 * @param vitalDateTime the vital_date_time value
	 */
	public void setVitalDateTime (java.lang.String vitalDateTime) {
		this.vitalDateTime = vitalDateTime;
	}



	/**
	 * Return the value associated with the column: vital_bp
	 */
	public java.lang.String getVitalBp () {
		return vitalBp;
	}

	/**
	 * Set the value related to the column: vital_bp
	 * @param vitalBp the vital_bp value
	 */
	public void setVitalBp (java.lang.String vitalBp) {
		this.vitalBp = vitalBp;
	}



	/**
	 * Return the value associated with the column: vital_pulse
	 */
	public java.lang.Integer getVitalPulse () {
		return vitalPulse;
	}

	/**
	 * Set the value related to the column: vital_pulse
	 * @param vitalPulse the vital_pulse value
	 */
	public void setVitalPulse (java.lang.Integer vitalPulse) {
		this.vitalPulse = vitalPulse;
	}



	/**
	 * Return the value associated with the column: vital_temperature
	 */
	public java.math.BigDecimal getVitalTemperature () {
		return vitalTemperature;
	}

	/**
	 * Set the value related to the column: vital_temperature
	 * @param vitalTemperature the vital_temperature value
	 */
	public void setVitalTemperature (java.math.BigDecimal vitalTemperature) {
		this.vitalTemperature = vitalTemperature;
	}



	/**
	 * Return the value associated with the column: opd_patient_details
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details
	 * @param opdPatientDetails the opd_patient_details value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdHemoDialysis)) return false;
		else {
			jkt.hms.masters.business.OpdHemoDialysis opdHemoDialysis = (jkt.hms.masters.business.OpdHemoDialysis) obj;
			if (null == this.getId() || null == opdHemoDialysis.getId()) return false;
			else return (this.getId().equals(opdHemoDialysis.getId()));
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