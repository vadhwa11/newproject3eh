package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_sample_collection table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_sample_collection"
 */

public abstract class BaseBloodSampleCollection  implements Serializable {

	public static String REF = "BloodSampleCollection";
	public static String PROP_BLOOD_SAMPLE_COLLECTED_BY = "BloodSampleCollectedBy";
	public static String PROP_BAG_NUMBER = "BagNumber";
	public static String PROP_BLOOD_SAMPLE_DATE = "BloodSampleDate";
	public static String PROP_STOCK_BATCH_ITEM = "StockBatchItem";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_QUANTITY_COLLECTED = "QuantityCollected";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_REQUEST = "Request";
	public static String PROP_VALIDATED_BY = "ValidatedBy";
	public static String PROP_SAMPLE_CROSS_CHECK_STATUS = "SampleCrossCheckStatus";
	public static String PROP_REASON_FOR_PROCESS_INCOMPLETE = "ReasonForProcessIncomplete";
	public static String PROP_COMPONENT_QUANTITY = "ComponentQuantity";
	public static String PROP_BP_DIASTOLLIC = "BpDiastollic";
	public static String PROP_SAMPLE_EXPIRY_DATE = "SampleExpiryDate";
	public static String PROP_BLOOD_SAMPLE_TIME = "BloodSampleTime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BAG_TYPE = "BagType";
	public static String PROP_SAMPLE_VALIDATION_DATE = "SampleValidationDate";
	public static String PROP_TUBE_NUMBER = "TubeNumber";
	public static String PROP_BP_SYSTOLLIC = "BpSystollic";
	public static String PROP_COMPONENT = "Component";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_COLLECTED_BY = "CollectedBy";
	public static String PROP_BLOOD_SAMPLE_REMARKS = "BloodSampleRemarks";
	public static String PROP_SAMPLE_COLLECTION_NO = "SampleCollectionNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SAMPLE_COLLECTION_TIME = "SampleCollectionTime";
	public static String PROP_SAMPLE_STATUS = "SampleStatus";
	public static String PROP_DONATION = "Donation";
	public static String PROP_SAMPLE_COLLECTION_DATE = "SampleCollectionDate";
	public static String PROP_ID = "Id";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_HIN = "Hin";
	public static String PROP_BAG_EXPIRY_DATE = "BagExpiryDate";
	public static String PROP_ACCEPTED_REJECTED = "AcceptedRejected";
	public static String PROP_SAMPLE_VALIDATION_TIME = "SampleValidationTime";


	// constructors
	public BaseBloodSampleCollection () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodSampleCollection (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sampleCollectionNo;
	private java.util.Date sampleCollectionDate;
	private java.lang.String sampleCollectionTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String sampleStatus;
	private java.lang.String remarks;
	private java.util.Date sampleValidationDate;
	private java.lang.String sampleValidationTime;
	private java.lang.String acceptedRejected;
	private java.lang.String bagNumber;
	private java.lang.String tubeNumber;
	private java.lang.Long pulse;
	private java.lang.Long bpSystollic;
	private java.lang.Long bpDiastollic;
	private java.math.BigDecimal quantityCollected;
	private java.lang.String reasonForProcessIncomplete;
	private java.lang.Integer componentQuantity;
	private java.util.Date sampleExpiryDate;
	private java.lang.String batchNo;
	private java.lang.String bagType;
	private java.util.Date bagExpiryDate;
	private java.util.Date bloodSampleDate;
	private java.lang.String bloodSampleTime;
	private java.lang.String bloodSampleRemarks;
	private java.lang.String sampleCrossCheckStatus;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.BloodDonationEntryHeader donation;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee validatedBy;
	private jkt.hms.masters.business.BloodRequestEntryHeader request;
	private jkt.hms.masters.business.BloodMasComponent component;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users bloodSampleCollectedBy;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee collectedBy;
	private jkt.hms.masters.business.StoreItemBatchStock stockBatchItem;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodSampleScreeningHeader> bloodSampleScreeningHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: sample_collection_no
	 */
	public java.lang.String getSampleCollectionNo () {
		return sampleCollectionNo;
	}

	/**
	 * Set the value related to the column: sample_collection_no
	 * @param sampleCollectionNo the sample_collection_no value
	 */
	public void setSampleCollectionNo (java.lang.String sampleCollectionNo) {
		this.sampleCollectionNo = sampleCollectionNo;
	}



	/**
	 * Return the value associated with the column: sample_collection_date
	 */
	public java.util.Date getSampleCollectionDate () {
		return sampleCollectionDate;
	}

	/**
	 * Set the value related to the column: sample_collection_date
	 * @param sampleCollectionDate the sample_collection_date value
	 */
	public void setSampleCollectionDate (java.util.Date sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}



	/**
	 * Return the value associated with the column: sample_collection_time
	 */
	public java.lang.String getSampleCollectionTime () {
		return sampleCollectionTime;
	}

	/**
	 * Set the value related to the column: sample_collection_time
	 * @param sampleCollectionTime the sample_collection_time value
	 */
	public void setSampleCollectionTime (java.lang.String sampleCollectionTime) {
		this.sampleCollectionTime = sampleCollectionTime;
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
	 * Return the value associated with the column: sample_status
	 */
	public java.lang.String getSampleStatus () {
		return sampleStatus;
	}

	/**
	 * Set the value related to the column: sample_status
	 * @param sampleStatus the sample_status value
	 */
	public void setSampleStatus (java.lang.String sampleStatus) {
		this.sampleStatus = sampleStatus;
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
	 * Return the value associated with the column: sample_validation_date
	 */
	public java.util.Date getSampleValidationDate () {
		return sampleValidationDate;
	}

	/**
	 * Set the value related to the column: sample_validation_date
	 * @param sampleValidationDate the sample_validation_date value
	 */
	public void setSampleValidationDate (java.util.Date sampleValidationDate) {
		this.sampleValidationDate = sampleValidationDate;
	}



	/**
	 * Return the value associated with the column: sample_validation_time
	 */
	public java.lang.String getSampleValidationTime () {
		return sampleValidationTime;
	}

	/**
	 * Set the value related to the column: sample_validation_time
	 * @param sampleValidationTime the sample_validation_time value
	 */
	public void setSampleValidationTime (java.lang.String sampleValidationTime) {
		this.sampleValidationTime = sampleValidationTime;
	}



	/**
	 * Return the value associated with the column: accepted_rejected
	 */
	public java.lang.String getAcceptedRejected () {
		return acceptedRejected;
	}

	/**
	 * Set the value related to the column: accepted_rejected
	 * @param acceptedRejected the accepted_rejected value
	 */
	public void setAcceptedRejected (java.lang.String acceptedRejected) {
		this.acceptedRejected = acceptedRejected;
	}



	/**
	 * Return the value associated with the column: bag_number
	 */
	public java.lang.String getBagNumber () {
		return bagNumber;
	}

	/**
	 * Set the value related to the column: bag_number
	 * @param bagNumber the bag_number value
	 */
	public void setBagNumber (java.lang.String bagNumber) {
		this.bagNumber = bagNumber;
	}



	/**
	 * Return the value associated with the column: tube_number
	 */
	public java.lang.String getTubeNumber () {
		return tubeNumber;
	}

	/**
	 * Set the value related to the column: tube_number
	 * @param tubeNumber the tube_number value
	 */
	public void setTubeNumber (java.lang.String tubeNumber) {
		this.tubeNumber = tubeNumber;
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
	 * Return the value associated with the column: bp_systollic
	 */
	public java.lang.Long getBpSystollic () {
		return bpSystollic;
	}

	/**
	 * Set the value related to the column: bp_systollic
	 * @param bpSystollic the bp_systollic value
	 */
	public void setBpSystollic (java.lang.Long bpSystollic) {
		this.bpSystollic = bpSystollic;
	}



	/**
	 * Return the value associated with the column: bp_diastollic
	 */
	public java.lang.Long getBpDiastollic () {
		return bpDiastollic;
	}

	/**
	 * Set the value related to the column: bp_diastollic
	 * @param bpDiastollic the bp_diastollic value
	 */
	public void setBpDiastollic (java.lang.Long bpDiastollic) {
		this.bpDiastollic = bpDiastollic;
	}



	/**
	 * Return the value associated with the column: quantity_collected
	 */
	public java.math.BigDecimal getQuantityCollected () {
		return quantityCollected;
	}

	/**
	 * Set the value related to the column: quantity_collected
	 * @param quantityCollected the quantity_collected value
	 */
	public void setQuantityCollected (java.math.BigDecimal quantityCollected) {
		this.quantityCollected = quantityCollected;
	}



	/**
	 * Return the value associated with the column: reason_for_process_incomplete
	 */
	public java.lang.String getReasonForProcessIncomplete () {
		return reasonForProcessIncomplete;
	}

	/**
	 * Set the value related to the column: reason_for_process_incomplete
	 * @param reasonForProcessIncomplete the reason_for_process_incomplete value
	 */
	public void setReasonForProcessIncomplete (java.lang.String reasonForProcessIncomplete) {
		this.reasonForProcessIncomplete = reasonForProcessIncomplete;
	}



	/**
	 * Return the value associated with the column: component_quantity
	 */
	public java.lang.Integer getComponentQuantity () {
		return componentQuantity;
	}

	/**
	 * Set the value related to the column: component_quantity
	 * @param componentQuantity the component_quantity value
	 */
	public void setComponentQuantity (java.lang.Integer componentQuantity) {
		this.componentQuantity = componentQuantity;
	}



	/**
	 * Return the value associated with the column: sample_expiry_date
	 */
	public java.util.Date getSampleExpiryDate () {
		return sampleExpiryDate;
	}

	/**
	 * Set the value related to the column: sample_expiry_date
	 * @param sampleExpiryDate the sample_expiry_date value
	 */
	public void setSampleExpiryDate (java.util.Date sampleExpiryDate) {
		this.sampleExpiryDate = sampleExpiryDate;
	}



	/**
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (java.lang.String batchNo) {
		this.batchNo = batchNo;
	}



	/**
	 * Return the value associated with the column: bag_type
	 */
	public java.lang.String getBagType () {
		return bagType;
	}

	/**
	 * Set the value related to the column: bag_type
	 * @param bagType the bag_type value
	 */
	public void setBagType (java.lang.String bagType) {
		this.bagType = bagType;
	}



	/**
	 * Return the value associated with the column: bag_expiry_date
	 */
	public java.util.Date getBagExpiryDate () {
		return bagExpiryDate;
	}

	/**
	 * Set the value related to the column: bag_expiry_date
	 * @param bagExpiryDate the bag_expiry_date value
	 */
	public void setBagExpiryDate (java.util.Date bagExpiryDate) {
		this.bagExpiryDate = bagExpiryDate;
	}



	/**
	 * Return the value associated with the column: blood_sample_date
	 */
	public java.util.Date getBloodSampleDate () {
		return bloodSampleDate;
	}

	/**
	 * Set the value related to the column: blood_sample_date
	 * @param bloodSampleDate the blood_sample_date value
	 */
	public void setBloodSampleDate (java.util.Date bloodSampleDate) {
		this.bloodSampleDate = bloodSampleDate;
	}



	/**
	 * Return the value associated with the column: blood_sample_time
	 */
	public java.lang.String getBloodSampleTime () {
		return bloodSampleTime;
	}

	/**
	 * Set the value related to the column: blood_sample_time
	 * @param bloodSampleTime the blood_sample_time value
	 */
	public void setBloodSampleTime (java.lang.String bloodSampleTime) {
		this.bloodSampleTime = bloodSampleTime;
	}



	/**
	 * Return the value associated with the column: blood_sample_remarks
	 */
	public java.lang.String getBloodSampleRemarks () {
		return bloodSampleRemarks;
	}

	/**
	 * Set the value related to the column: blood_sample_remarks
	 * @param bloodSampleRemarks the blood_sample_remarks value
	 */
	public void setBloodSampleRemarks (java.lang.String bloodSampleRemarks) {
		this.bloodSampleRemarks = bloodSampleRemarks;
	}



	/**
	 * Return the value associated with the column: sample_cross_check_status
	 */
	public java.lang.String getSampleCrossCheckStatus () {
		return sampleCrossCheckStatus;
	}

	/**
	 * Set the value related to the column: sample_cross_check_status
	 * @param sampleCrossCheckStatus the sample_cross_check_status value
	 */
	public void setSampleCrossCheckStatus (java.lang.String sampleCrossCheckStatus) {
		this.sampleCrossCheckStatus = sampleCrossCheckStatus;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: validated_by
	 */
	public jkt.hms.masters.business.MasEmployee getValidatedBy () {
		return validatedBy;
	}

	/**
	 * Set the value related to the column: validated_by
	 * @param validatedBy the validated_by value
	 */
	public void setValidatedBy (jkt.hms.masters.business.MasEmployee validatedBy) {
		this.validatedBy = validatedBy;
	}



	/**
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.BloodRequestEntryHeader getRequest () {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * @param request the request_id value
	 */
	public void setRequest (jkt.hms.masters.business.BloodRequestEntryHeader request) {
		this.request = request;
	}



	/**
	 * Return the value associated with the column: component_id
	 */
	public jkt.hms.masters.business.BloodMasComponent getComponent () {
		return component;
	}

	/**
	 * Set the value related to the column: component_id
	 * @param component the component_id value
	 */
	public void setComponent (jkt.hms.masters.business.BloodMasComponent component) {
		this.component = component;
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
	 * Return the value associated with the column: blood_sample_collected_by
	 */
	public jkt.hms.masters.business.Users getBloodSampleCollectedBy () {
		return bloodSampleCollectedBy;
	}

	/**
	 * Set the value related to the column: blood_sample_collected_by
	 * @param bloodSampleCollectedBy the blood_sample_collected_by value
	 */
	public void setBloodSampleCollectedBy (jkt.hms.masters.business.Users bloodSampleCollectedBy) {
		this.bloodSampleCollectedBy = bloodSampleCollectedBy;
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



	/**
	 * Return the value associated with the column: stock_batch_item_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getStockBatchItem () {
		return stockBatchItem;
	}

	/**
	 * Set the value related to the column: stock_batch_item_id
	 * @param stockBatchItem the stock_batch_item_id value
	 */
	public void setStockBatchItem (jkt.hms.masters.business.StoreItemBatchStock stockBatchItem) {
		this.stockBatchItem = stockBatchItem;
	}



	/**
	 * Return the value associated with the column: BloodSampleScreeningHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BloodSampleScreeningHeader> getBloodSampleScreeningHeaders () {
		return bloodSampleScreeningHeaders;
	}

	/**
	 * Set the value related to the column: BloodSampleScreeningHeaders
	 * @param bloodSampleScreeningHeaders the BloodSampleScreeningHeaders value
	 */
	public void setBloodSampleScreeningHeaders (java.util.Set<jkt.hms.masters.business.BloodSampleScreeningHeader> bloodSampleScreeningHeaders) {
		this.bloodSampleScreeningHeaders = bloodSampleScreeningHeaders;
	}

	public void addToBloodSampleScreeningHeaders (jkt.hms.masters.business.BloodSampleScreeningHeader bloodSampleScreeningHeader) {
		if (null == getBloodSampleScreeningHeaders()) setBloodSampleScreeningHeaders(new java.util.TreeSet<jkt.hms.masters.business.BloodSampleScreeningHeader>());
		getBloodSampleScreeningHeaders().add(bloodSampleScreeningHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodSampleCollection)) return false;
		else {
			jkt.hms.masters.business.BloodSampleCollection bloodSampleCollection = (jkt.hms.masters.business.BloodSampleCollection) obj;
			if (null == this.getId() || null == bloodSampleCollection.getId()) return false;
			else return (this.getId().equals(bloodSampleCollection.getId()));
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