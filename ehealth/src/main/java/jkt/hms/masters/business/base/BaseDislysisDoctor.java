package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dislysis_doctor table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dislysis_doctor"
 */

public abstract class BaseDislysisDoctor  implements Serializable {

	public static String REF = "DislysisDoctor";
	public static String PROP_MEDICATION = "Medication";
	public static String PROP_ULTRAFILTRATION = "Ultrafiltration";
	public static String PROP_WEIGHT_LOSS = "WeightLoss";
	public static String PROP_DIALYSATE = "Dialysate";
	public static String PROP_ID = "Id";
	public static String PROP_HOURS_OF_DIALYSIS = "HoursOfDialysis";
	public static String PROP_DIALYSER = "Dialyser";
	public static String PROP_INVESTIGATIONS = "Investigations";
	public static String PROP_TRANSFUSION = "Transfusion";
	public static String PROP_HIN = "Hin";
	public static String PROP_HEPARIN = "Heparin";


	// constructors
	public BaseDislysisDoctor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDislysisDoctor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dialysate;
	private java.lang.String dialyser;
	private java.lang.String ultrafiltration;
	private java.lang.String hoursOfDialysis;
	private java.lang.String transfusion;
	private java.lang.String weightLoss;
	private java.lang.String heparin;
	private java.lang.String medication;
	private java.lang.String investigations;

	// many to one
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="doctor_order_id"
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
	 * Return the value associated with the column: dialysate
	 */
	public java.lang.String getDialysate () {
		return dialysate;
	}

	/**
	 * Set the value related to the column: dialysate
	 * @param dialysate the dialysate value
	 */
	public void setDialysate (java.lang.String dialysate) {
		this.dialysate = dialysate;
	}



	/**
	 * Return the value associated with the column: dialyser
	 */
	public java.lang.String getDialyser () {
		return dialyser;
	}

	/**
	 * Set the value related to the column: dialyser
	 * @param dialyser the dialyser value
	 */
	public void setDialyser (java.lang.String dialyser) {
		this.dialyser = dialyser;
	}



	/**
	 * Return the value associated with the column: ultrafiltration
	 */
	public java.lang.String getUltrafiltration () {
		return ultrafiltration;
	}

	/**
	 * Set the value related to the column: ultrafiltration
	 * @param ultrafiltration the ultrafiltration value
	 */
	public void setUltrafiltration (java.lang.String ultrafiltration) {
		this.ultrafiltration = ultrafiltration;
	}



	/**
	 * Return the value associated with the column: hours_of_dialysis
	 */
	public java.lang.String getHoursOfDialysis () {
		return hoursOfDialysis;
	}

	/**
	 * Set the value related to the column: hours_of_dialysis
	 * @param hoursOfDialysis the hours_of_dialysis value
	 */
	public void setHoursOfDialysis (java.lang.String hoursOfDialysis) {
		this.hoursOfDialysis = hoursOfDialysis;
	}



	/**
	 * Return the value associated with the column: transfusion
	 */
	public java.lang.String getTransfusion () {
		return transfusion;
	}

	/**
	 * Set the value related to the column: transfusion
	 * @param transfusion the transfusion value
	 */
	public void setTransfusion (java.lang.String transfusion) {
		this.transfusion = transfusion;
	}



	/**
	 * Return the value associated with the column: weight_loss
	 */
	public java.lang.String getWeightLoss () {
		return weightLoss;
	}

	/**
	 * Set the value related to the column: weight_loss
	 * @param weightLoss the weight_loss value
	 */
	public void setWeightLoss (java.lang.String weightLoss) {
		this.weightLoss = weightLoss;
	}



	/**
	 * Return the value associated with the column: heparin
	 */
	public java.lang.String getHeparin () {
		return heparin;
	}

	/**
	 * Set the value related to the column: heparin
	 * @param heparin the heparin value
	 */
	public void setHeparin (java.lang.String heparin) {
		this.heparin = heparin;
	}



	/**
	 * Return the value associated with the column: medication
	 */
	public java.lang.String getMedication () {
		return medication;
	}

	/**
	 * Set the value related to the column: medication
	 * @param medication the medication value
	 */
	public void setMedication (java.lang.String medication) {
		this.medication = medication;
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
		if (!(obj instanceof jkt.hms.masters.business.DislysisDoctor)) return false;
		else {
			jkt.hms.masters.business.DislysisDoctor dislysisDoctor = (jkt.hms.masters.business.DislysisDoctor) obj;
			if (null == this.getId() || null == dislysisDoctor.getId()) return false;
			else return (this.getId().equals(dislysisDoctor.getId()));
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