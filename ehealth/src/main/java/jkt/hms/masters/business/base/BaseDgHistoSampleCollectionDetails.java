package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_histo_sample_collection_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_histo_sample_collection_details"
 */

public abstract class BaseDgHistoSampleCollectionDetails  implements Serializable {

	public static String REF = "DgHistoSampleCollectionDetails";
	public static String PROP_MAINCHARGE = "Maincharge";
	public static String PROP_STAINING_COMMENT = "StainingComment";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_ORDER_STATUS = "OrderStatus";
	public static String PROP_VALIDATED = "Validated";
	public static String PROP_IDENTIFICATION_NO = "IdentificationNo";
	public static String PROP_LAB_STATUS = "LabStatus";
	public static String PROP_DIAG_NO = "DiagNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SAMPLE = "Sample";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_REJECTED = "Rejected";
	public static String PROP_SAMPLE_COLLECTION_HEADER = "SampleCollectionHeader";
	public static String PROP_SAMPLE_NO = "SampleNo";
	public static String PROP_COLLECTED = "Collected";
	public static String PROP_SAMPLE_COLL_DATETIME = "SampleCollDatetime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_SUBCHARGE = "Subcharge";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COLLECTED_BY = "CollectedBy";
	public static String PROP_CONTAINER = "Container";
	public static String PROP_REASON = "Reason";


	// constructors
	public BaseDgHistoSampleCollectionDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgHistoSampleCollectionDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String collected;
	private java.lang.String orderStatus;
	private java.lang.String empanelledStatus;
	private java.lang.String remarks;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String validated;
	private java.lang.String reason;
	private java.lang.String diagNo;
	private java.util.Date sampleCollDatetime;
	private java.lang.String rejected;
	private java.lang.String sampleNo;
	private java.lang.String labStatus;
	private java.lang.String identificationNo;
	private java.lang.String stainingComment;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasSubChargecode subcharge;
	private jkt.hms.masters.business.DgSampleCollectionHeader sampleCollectionHeader;
	private jkt.hms.masters.business.DgMasCollection container;
	private jkt.hms.masters.business.DgMasInvestigation investigation;
	private jkt.hms.masters.business.MasSample sample;
	private jkt.hms.masters.business.MasMainChargecode maincharge;
	private jkt.hms.masters.business.MasEmployee collectedBy;
	private jkt.hms.masters.business.MasEmpaneled empaneled;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="histo_details_id"
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
	 * Return the value associated with the column: collected
	 */
	public java.lang.String getCollected () {
		return collected;
	}

	/**
	 * Set the value related to the column: collected
	 * @param collected the collected value
	 */
	public void setCollected (java.lang.String collected) {
		this.collected = collected;
	}



	/**
	 * Return the value associated with the column: order_status
	 */
	public java.lang.String getOrderStatus () {
		return orderStatus;
	}

	/**
	 * Set the value related to the column: order_status
	 * @param orderStatus the order_status value
	 */
	public void setOrderStatus (java.lang.String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public java.lang.String getEmpanelledStatus() {
		return empanelledStatus;
	}

	public void setEmpanelledStatus(java.lang.String empanelledStatus) {
		this.empanelledStatus = empanelledStatus;
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
	 * Return the value associated with the column: validated
	 */
	public java.lang.String getValidated () {
		return validated;
	}

	/**
	 * Set the value related to the column: validated
	 * @param validated the validated value
	 */
	public void setValidated (java.lang.String validated) {
		this.validated = validated;
	}



	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: diag_no
	 */
	public java.lang.String getDiagNo () {
		return diagNo;
	}

	/**
	 * Set the value related to the column: diag_no
	 * @param diagNo the diag_no value
	 */
	public void setDiagNo (java.lang.String diagNo) {
		this.diagNo = diagNo;
	}



	/**
	 * Return the value associated with the column: sample_coll_datetime
	 */
	public java.util.Date getSampleCollDatetime () {
		return sampleCollDatetime;
	}

	/**
	 * Set the value related to the column: sample_coll_datetime
	 * @param sampleCollDatetime the sample_coll_datetime value
	 */
	public void setSampleCollDatetime (java.util.Date sampleCollDatetime) {
		this.sampleCollDatetime = sampleCollDatetime;
	}



	/**
	 * Return the value associated with the column: rejected
	 */
	public java.lang.String getRejected () {
		return rejected;
	}

	/**
	 * Set the value related to the column: rejected
	 * @param rejected the rejected value
	 */
	public void setRejected (java.lang.String rejected) {
		this.rejected = rejected;
	}



	/**
	 * Return the value associated with the column: sample_no
	 */
	public java.lang.String getSampleNo () {
		return sampleNo;
	}

	/**
	 * Set the value related to the column: sample_no
	 * @param sampleNo the sample_no value
	 */
	public void setSampleNo (java.lang.String sampleNo) {
		this.sampleNo = sampleNo;
	}



	/**
	 * Return the value associated with the column: lab_status
	 */
	public java.lang.String getLabStatus () {
		return labStatus;
	}

	/**
	 * Set the value related to the column: lab_status
	 * @param labStatus the lab_status value
	 */
	public void setLabStatus (java.lang.String labStatus) {
		this.labStatus = labStatus;
	}



	/**
	 * Return the value associated with the column: identification_no
	 */
	public java.lang.String getIdentificationNo () {
		return identificationNo;
	}

	/**
	 * Set the value related to the column: identification_no
	 * @param identificationNo the identification_no value
	 */
	public void setIdentificationNo (java.lang.String identificationNo) {
		this.identificationNo = identificationNo;
	}



	/**
	 * Return the value associated with the column: staining_comment
	 */
	public java.lang.String getStainingComment () {
		return stainingComment;
	}

	/**
	 * Set the value related to the column: staining_comment
	 * @param stainingComment the staining_comment value
	 */
	public void setStainingComment (java.lang.String stainingComment) {
		this.stainingComment = stainingComment;
	}



	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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
	 * Return the value associated with the column: subcharge
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubcharge () {
		return subcharge;
	}

	/**
	 * Set the value related to the column: subcharge
	 * @param subcharge the subcharge value
	 */
	public void setSubcharge (jkt.hms.masters.business.MasSubChargecode subcharge) {
		this.subcharge = subcharge;
	}



	/**
	 * Return the value associated with the column: sample_collection_header_id
	 */
	public jkt.hms.masters.business.DgSampleCollectionHeader getSampleCollectionHeader () {
		return sampleCollectionHeader;
	}

	/**
	 * Set the value related to the column: sample_collection_header_id
	 * @param sampleCollectionHeader the sample_collection_header_id value
	 */
	public void setSampleCollectionHeader (jkt.hms.masters.business.DgSampleCollectionHeader sampleCollectionHeader) {
		this.sampleCollectionHeader = sampleCollectionHeader;
	}



	/**
	 * Return the value associated with the column: container
	 */
	public jkt.hms.masters.business.DgMasCollection getContainer () {
		return container;
	}

	/**
	 * Set the value related to the column: container
	 * @param container the container value
	 */
	public void setContainer (jkt.hms.masters.business.DgMasCollection container) {
		this.container = container;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigation the investigation_id value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: sample_id
	 */
	public jkt.hms.masters.business.MasSample getSample () {
		return sample;
	}

	/**
	 * Set the value related to the column: sample_id
	 * @param sample the sample_id value
	 */
	public void setSample (jkt.hms.masters.business.MasSample sample) {
		this.sample = sample;
	}



	/**
	 * Return the value associated with the column: maincharge
	 */
	public jkt.hms.masters.business.MasMainChargecode getMaincharge () {
		return maincharge;
	}

	/**
	 * Set the value related to the column: maincharge
	 * @param maincharge the maincharge value
	 */
	public void setMaincharge (jkt.hms.masters.business.MasMainChargecode maincharge) {
		this.maincharge = maincharge;
	}



	/**
	 * Return the value associated with the column: collected_by
	 */
	public jkt.hms.masters.business.MasEmployee getCollectedBy () {
		return collectedBy;
	}

	/**
	 * Set the value related to the column: collected_by
	 * @param collectedBy the collected_by value
	 */
	public void setCollectedBy (jkt.hms.masters.business.MasEmployee collectedBy) {
		this.collectedBy = collectedBy;
	}

	


	public jkt.hms.masters.business.MasEmpaneled getEmpaneled() {
		return empaneled;
	}

	public void setEmpaneled(jkt.hms.masters.business.MasEmpaneled empaneled) {
		this.empaneled = empaneled;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgHistoSampleCollectionDetails)) return false;
		else {
			jkt.hms.masters.business.DgHistoSampleCollectionDetails dgHistoSampleCollectionDetails = (jkt.hms.masters.business.DgHistoSampleCollectionDetails) obj;
			if (null == this.getId() || null == dgHistoSampleCollectionDetails.getId()) return false;
			else return (this.getId().equals(dgHistoSampleCollectionDetails.getId()));
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