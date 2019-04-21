package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_assessment_entry_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_assessment_entry_m"
 */

public abstract class BaseBloodAssessmentEntryM  implements Serializable {

	public static String REF = "BloodAssessmentEntryM";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DEFERRED_ON_DATE = "DeferredOnDate";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_FINAL_RESULT = "FinalResult";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_CELL_GROUPING_REQUEST = "CellGroupingRequest";
	public static String PROP_PHYSICAL_EXAM = "PhysicalExam";
	public static String PROP_ASSESSMENT_DATE = "AssessmentDate";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_BP = "Bp";
	public static String PROP_PHYSICAL_FIT = "PhysicalFit";
	public static String PROP_MAS_STORE_ITEM = "MasStoreItem";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COLLECTD_VOLUME = "CollectdVolume";
	public static String PROP_DEFERRED_TILL_DATE = "DeferredTillDate";
	public static String PROP_BLD_COLLECTION_STATUS = "BldCollectionStatus";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_BP_DIASTOLIC = "BpDiastolic";
	public static String PROP_BLOOD_BANK = "BloodBank";
	public static String PROP_DONATION = "Donation";
	public static String PROP_HEMOGLOBIN = "Hemoglobin";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseBloodAssessmentEntryM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodAssessmentEntryM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String finalResult;
	private java.util.Date deferredOnDate;
	private java.math.BigDecimal height;
	private java.math.BigDecimal weight;
	private java.math.BigDecimal temperature;
	private java.lang.Long pulse;
	private java.lang.String bp;
	private java.math.BigDecimal collectdVolume;
	private java.lang.String physicalExam;
	private java.lang.String physicalFit;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date deferredTillDate;
	private java.lang.String bpDiastolic;
	private java.lang.String cellGroupingRequest;
	private java.lang.String hemoglobin;
	private java.util.Date assessmentDate;
	private java.lang.String bldCollectionStatus;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital bloodBank;
	private jkt.hms.masters.business.MasStoreItem masStoreItem;
	private jkt.hms.masters.business.BloodDonationEntryHeader donation;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodAssessmentEntryT> bloodAssessmentEntryTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="entry_m_id"
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
	 * Return the value associated with the column: final_result
	 */
	public java.lang.String getFinalResult () {
		return finalResult;
	}

	/**
	 * Set the value related to the column: final_result
	 * @param finalResult the final_result value
	 */
	public void setFinalResult (java.lang.String finalResult) {
		this.finalResult = finalResult;
	}



	/**
	 * Return the value associated with the column: deferred_on_date
	 */
	public java.util.Date getDeferredOnDate () {
		return deferredOnDate;
	}

	/**
	 * Set the value related to the column: deferred_on_date
	 * @param deferredOnDate the deferred_on_date value
	 */
	public void setDeferredOnDate (java.util.Date deferredOnDate) {
		this.deferredOnDate = deferredOnDate;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.math.BigDecimal getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.math.BigDecimal height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: temperature
	 */
	public java.math.BigDecimal getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * @param temperature the temperature value
	 */
	public void setTemperature (java.math.BigDecimal temperature) {
		this.temperature = temperature;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.Long getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.Long pulse) {
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
	 * Return the value associated with the column: collectd_volume
	 */
	public java.math.BigDecimal getCollectdVolume () {
		return collectdVolume;
	}

	/**
	 * Set the value related to the column: collectd_volume
	 * @param collectdVolume the collectd_volume value
	 */
	public void setCollectdVolume (java.math.BigDecimal collectdVolume) {
		this.collectdVolume = collectdVolume;
	}



	/**
	 * Return the value associated with the column: physical_exam
	 */
	public java.lang.String getPhysicalExam () {
		return physicalExam;
	}

	/**
	 * Set the value related to the column: physical_exam
	 * @param physicalExam the physical_exam value
	 */
	public void setPhysicalExam (java.lang.String physicalExam) {
		this.physicalExam = physicalExam;
	}



	/**
	 * Return the value associated with the column: physical_fit
	 */
	public java.lang.String getPhysicalFit () {
		return physicalFit;
	}

	/**
	 * Set the value related to the column: physical_fit
	 * @param physicalFit the physical_fit value
	 */
	public void setPhysicalFit (java.lang.String physicalFit) {
		this.physicalFit = physicalFit;
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
	 * Return the value associated with the column: deferred_till_date
	 */
	public java.util.Date getDeferredTillDate () {
		return deferredTillDate;
	}

	/**
	 * Set the value related to the column: deferred_till_date
	 * @param deferredTillDate the deferred_till_date value
	 */
	public void setDeferredTillDate (java.util.Date deferredTillDate) {
		this.deferredTillDate = deferredTillDate;
	}



	/**
	 * Return the value associated with the column: bp_diastolic
	 */
	public java.lang.String getBpDiastolic () {
		return bpDiastolic;
	}

	/**
	 * Set the value related to the column: bp_diastolic
	 * @param bpDiastolic the bp_diastolic value
	 */
	public void setBpDiastolic (java.lang.String bpDiastolic) {
		this.bpDiastolic = bpDiastolic;
	}



	/**
	 * Return the value associated with the column: cell_grouping_request
	 */
	public java.lang.String getCellGroupingRequest () {
		return cellGroupingRequest;
	}

	/**
	 * Set the value related to the column: cell_grouping_request
	 * @param cellGroupingRequest the cell_grouping_request value
	 */
	public void setCellGroupingRequest (java.lang.String cellGroupingRequest) {
		this.cellGroupingRequest = cellGroupingRequest;
	}



	/**
	 * Return the value associated with the column: hemoglobin
	 */
	public java.lang.String getHemoglobin () {
		return hemoglobin;
	}

	/**
	 * Set the value related to the column: hemoglobin
	 * @param hemoglobin the hemoglobin value
	 */
	public void setHemoglobin (java.lang.String hemoglobin) {
		this.hemoglobin = hemoglobin;
	}



	/**
	 * Return the value associated with the column: assessment_date
	 */
	public java.util.Date getAssessmentDate () {
		return assessmentDate;
	}

	/**
	 * Set the value related to the column: assessment_date
	 * @param assessmentDate the assessment_date value
	 */
	public void setAssessmentDate (java.util.Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}



	/**
	 * Return the value associated with the column: bld_collection_status
	 */
	public java.lang.String getBldCollectionStatus () {
		return bldCollectionStatus;
	}

	/**
	 * Set the value related to the column: bld_collection_status
	 * @param bldCollectionStatus the bld_collection_status value
	 */
	public void setBldCollectionStatus (java.lang.String bldCollectionStatus) {
		this.bldCollectionStatus = bldCollectionStatus;
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
	 * Return the value associated with the column: blood_bank_id
	 */
	public jkt.hms.masters.business.MasHospital getBloodBank () {
		return bloodBank;
	}

	/**
	 * Set the value related to the column: blood_bank_id
	 * @param bloodBank the blood_bank_id value
	 */
	public void setBloodBank (jkt.hms.masters.business.MasHospital bloodBank) {
		this.bloodBank = bloodBank;
	}



	/**
	 * Return the value associated with the column: mas_store_item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getMasStoreItem () {
		return masStoreItem;
	}

	/**
	 * Set the value related to the column: mas_store_item_id
	 * @param masStoreItem the mas_store_item_id value
	 */
	public void setMasStoreItem (jkt.hms.masters.business.MasStoreItem masStoreItem) {
		this.masStoreItem = masStoreItem;
	}



	/**
	 * Return the value associated with the column: donation_id
	 */
	public jkt.hms.masters.business.BloodDonationEntryHeader getDonation () {
		return donation;
	}

	/**
	 * Set the value related to the column: donation_id
	 * @param donation the donation_id value
	 */
	public void setDonation (jkt.hms.masters.business.BloodDonationEntryHeader donation) {
		this.donation = donation;
	}



	/**
	 * Return the value associated with the column: BloodAssessmentEntryTs
	 */
	public java.util.Set<jkt.hms.masters.business.BloodAssessmentEntryT> getBloodAssessmentEntryTs () {
		return bloodAssessmentEntryTs;
	}

	/**
	 * Set the value related to the column: BloodAssessmentEntryTs
	 * @param bloodAssessmentEntryTs the BloodAssessmentEntryTs value
	 */
	public void setBloodAssessmentEntryTs (java.util.Set<jkt.hms.masters.business.BloodAssessmentEntryT> bloodAssessmentEntryTs) {
		this.bloodAssessmentEntryTs = bloodAssessmentEntryTs;
	}

	public void addToBloodAssessmentEntryTs (jkt.hms.masters.business.BloodAssessmentEntryT bloodAssessmentEntryT) {
		if (null == getBloodAssessmentEntryTs()) setBloodAssessmentEntryTs(new java.util.TreeSet<jkt.hms.masters.business.BloodAssessmentEntryT>());
		getBloodAssessmentEntryTs().add(bloodAssessmentEntryT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodAssessmentEntryM)) return false;
		else {
			jkt.hms.masters.business.BloodAssessmentEntryM bloodAssessmentEntryM = (jkt.hms.masters.business.BloodAssessmentEntryM) obj;
			if (null == this.getId() || null == bloodAssessmentEntryM.getId()) return false;
			else return (this.getId().equals(bloodAssessmentEntryM.getId()));
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