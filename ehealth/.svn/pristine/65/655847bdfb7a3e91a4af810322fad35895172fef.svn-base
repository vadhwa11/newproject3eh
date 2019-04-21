package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_sample_collection_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_sample_collection_header"
 */

public abstract class BaseDgSampleCollectionHeader  implements Serializable {

	public static String REF = "DgSampleCollectionHeader";
	public static String PROP_DIAGNOSIS_TIME = "DiagnosisTime";
	public static String PROP_ORDER = "Order";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BLOOD_SAMPLE_COLLECTION_DATE = "BloodSampleCollectionDate";
	public static String PROP_ORDER_BY_DEPARTMENT = "OrderByDepartment";
	public static String PROP_DIAGNOSIS_DATE = "DiagnosisDate";
	public static String PROP_SAMPLE_BAR_CODE_PENDING = "SampleBarCodePending";
	public static String PROP_VALIDATED_BY = "ValidatedBy";
	public static String PROP_HIN = "Hin";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ORDER_STATUS = "OrderStatus";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_SAMPLE_VALIDATION_DATE = "SampleValidationDate";
	public static String PROP_PHARMACY_LAB_QUEUE_ID = "PharmacyLabQueueId";
	public static String PROP_BLOOD_SAMPLE_COLLECTION_TIME = "BloodSampleCollectionTime";
	public static String PROP_BLOOD_SAMPLE_COLLECTION = "BloodSampleCollection";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SAMPLE_VALIDATION_TIME = "SampleValidationTime";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REFER_HOSPITAL = "ReferHospital";
	public static String PROP_ID = "Id";
	public static String PROP_COLLECTION_CENTER = "CollectionCenter";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SAMPLE_BAR_CODE = "SampleBarCode";


	// constructors
	public BaseDgSampleCollectionHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgSampleCollectionHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String orderStatus;
	private java.util.Date diagnosisDate;
	private java.lang.String diagnosisTime;
	private java.util.Date sampleValidationDate;
	private java.lang.String sampleValidationTime;
	private java.util.Date bloodSampleCollectionDate;
	private java.lang.String bloodSampleCollectionTime;
	private java.lang.String sampleBarCode;
	private java.lang.String sampleBarCodePending;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.DgCollectionCenter collectionCenter;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee validatedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.BloodSampleCollection bloodSampleCollection;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.DgOrderhd order;
	private jkt.hms.masters.business.MasDepartment orderByDepartment;
	private jkt.hms.masters.business.MasHospital referHospital;
	private jkt.hms.masters.business.PharmacyLabQueue pharmacyLabQueueId;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.DgHistoSampleCollectionDetails> dgHistoSampleCollectionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="sample_collection_header_id"
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



	/**
	 * Return the value associated with the column: diagnosis_date
	 */
	public java.util.Date getDiagnosisDate () {
		return diagnosisDate;
	}

	/**
	 * Set the value related to the column: diagnosis_date
	 * @param diagnosisDate the diagnosis_date value
	 */
	public void setDiagnosisDate (java.util.Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}



	/**
	 * Return the value associated with the column: diagnosis_time
	 */
	public java.lang.String getDiagnosisTime () {
		return diagnosisTime;
	}

	/**
	 * Set the value related to the column: diagnosis_time
	 * @param diagnosisTime the diagnosis_time value
	 */
	public void setDiagnosisTime (java.lang.String diagnosisTime) {
		this.diagnosisTime = diagnosisTime;
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
	 * Return the value associated with the column: blood_sample_collection_date
	 */
	public java.util.Date getBloodSampleCollectionDate () {
		return bloodSampleCollectionDate;
	}

	/**
	 * Set the value related to the column: blood_sample_collection_date
	 * @param bloodSampleCollectionDate the blood_sample_collection_date value
	 */
	public void setBloodSampleCollectionDate (java.util.Date bloodSampleCollectionDate) {
		this.bloodSampleCollectionDate = bloodSampleCollectionDate;
	}



	/**
	 * Return the value associated with the column: blood_sample_collection_time
	 */
	public java.lang.String getBloodSampleCollectionTime () {
		return bloodSampleCollectionTime;
	}

	/**
	 * Set the value related to the column: blood_sample_collection_time
	 * @param bloodSampleCollectionTime the blood_sample_collection_time value
	 */
	public void setBloodSampleCollectionTime (java.lang.String bloodSampleCollectionTime) {
		this.bloodSampleCollectionTime = bloodSampleCollectionTime;
	}



	/**
	 * Return the value associated with the column: sample_bar_code
	 */
	public java.lang.String getSampleBarCode () {
		return sampleBarCode;
	}

	/**
	 * Set the value related to the column: sample_bar_code
	 * @param sampleBarCode the sample_bar_code value
	 */
	public void setSampleBarCode (java.lang.String sampleBarCode) {
		this.sampleBarCode = sampleBarCode;
	}



	/**
	 * Return the value associated with the column: sample_bar_code_pending
	 */
	public java.lang.String getSampleBarCodePending () {
		return sampleBarCodePending;
	}

	/**
	 * Set the value related to the column: sample_bar_code_pending
	 * @param sampleBarCodePending the sample_bar_code_pending value
	 */
	public void setSampleBarCodePending (java.lang.String sampleBarCodePending) {
		this.sampleBarCodePending = sampleBarCodePending;
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
	 * Return the value associated with the column: collection_center_id
	 */
	public jkt.hms.masters.business.DgCollectionCenter getCollectionCenter () {
		return collectionCenter;
	}

	/**
	 * Set the value related to the column: collection_center_id
	 * @param collectionCenter the collection_center_id value
	 */
	public void setCollectionCenter (jkt.hms.masters.business.DgCollectionCenter collectionCenter) {
		this.collectionCenter = collectionCenter;
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
	 * Return the value associated with the column: blood_sample_collection_id
	 */
	public jkt.hms.masters.business.BloodSampleCollection getBloodSampleCollection () {
		return bloodSampleCollection;
	}

	/**
	 * Set the value related to the column: blood_sample_collection_id
	 * @param bloodSampleCollection the blood_sample_collection_id value
	 */
	public void setBloodSampleCollection (jkt.hms.masters.business.BloodSampleCollection bloodSampleCollection) {
		this.bloodSampleCollection = bloodSampleCollection;
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
	 * Return the value associated with the column: order_id
	 */
	public jkt.hms.masters.business.DgOrderhd getOrder () {
		return order;
	}

	/**
	 * Set the value related to the column: order_id
	 * @param order the order_id value
	 */
	public void setOrder (jkt.hms.masters.business.DgOrderhd order) {
		this.order = order;
	}



	/**
	 * Return the value associated with the column: order_by_department
	 */
	public jkt.hms.masters.business.MasDepartment getOrderByDepartment () {
		return orderByDepartment;
	}

	/**
	 * Set the value related to the column: order_by_department
	 * @param orderByDepartment the order_by_department value
	 */
	public void setOrderByDepartment (jkt.hms.masters.business.MasDepartment orderByDepartment) {
		this.orderByDepartment = orderByDepartment;
	}



	/**
	 * Return the value associated with the column: referred_hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getReferHospital () {
		return referHospital;
	}

	/**
	 * Set the value related to the column: referred_hospital_id
	 * @param referHospital the referred_hospital_id value
	 */
	public void setReferHospital (jkt.hms.masters.business.MasHospital referHospital) {
		this.referHospital = referHospital;
	}



	/**
	 * Return the value associated with the column: pharmacy_lab_queue_id
	 */
	public jkt.hms.masters.business.PharmacyLabQueue getPharmacyLabQueueId () {
		return pharmacyLabQueueId;
	}

	/**
	 * Set the value related to the column: pharmacy_lab_queue_id
	 * @param pharmacyLabQueueId the pharmacy_lab_queue_id value
	 */
	public void setPharmacyLabQueueId (jkt.hms.masters.business.PharmacyLabQueue pharmacyLabQueueId) {
		this.pharmacyLabQueueId = pharmacyLabQueueId;
	}



	/**
	 * Return the value associated with the column: DgSampleCollectionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> getDgSampleCollectionDetails () {
		return dgSampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionDetails
	 * @param dgSampleCollectionDetails the DgSampleCollectionDetails value
	 */
	public void setDgSampleCollectionDetails (java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails) {
		this.dgSampleCollectionDetails = dgSampleCollectionDetails;
	}

	public void addToDgSampleCollectionDetails (jkt.hms.masters.business.DgSampleCollectionDetails dgSampleCollectionDetails) {
		if (null == getDgSampleCollectionDetails()) setDgSampleCollectionDetails(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionDetails>());
		getDgSampleCollectionDetails().add(dgSampleCollectionDetails);
	}



	/**
	 * Return the value associated with the column: DgResultEntryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> getDgResultEntryHeaders () {
		return dgResultEntryHeaders;
	}

	/**
	 * Set the value related to the column: DgResultEntryHeaders
	 * @param dgResultEntryHeaders the DgResultEntryHeaders value
	 */
	public void setDgResultEntryHeaders (java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders) {
		this.dgResultEntryHeaders = dgResultEntryHeaders;
	}

	public void addToDgResultEntryHeaders (jkt.hms.masters.business.DgResultEntryHeader dgResultEntryHeader) {
		if (null == getDgResultEntryHeaders()) setDgResultEntryHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryHeader>());
		getDgResultEntryHeaders().add(dgResultEntryHeader);
	}



	/**
	 * Return the value associated with the column: DgHistoSampleCollectionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgHistoSampleCollectionDetails> getDgHistoSampleCollectionDetails () {
		return dgHistoSampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: DgHistoSampleCollectionDetails
	 * @param dgHistoSampleCollectionDetails the DgHistoSampleCollectionDetails value
	 */
	public void setDgHistoSampleCollectionDetails (java.util.Set<jkt.hms.masters.business.DgHistoSampleCollectionDetails> dgHistoSampleCollectionDetails) {
		this.dgHistoSampleCollectionDetails = dgHistoSampleCollectionDetails;
	}

	public void addToDgHistoSampleCollectionDetails (jkt.hms.masters.business.DgHistoSampleCollectionDetails dgHistoSampleCollectionDetails) {
		if (null == getDgHistoSampleCollectionDetails()) setDgHistoSampleCollectionDetails(new java.util.TreeSet<jkt.hms.masters.business.DgHistoSampleCollectionDetails>());
		getDgHistoSampleCollectionDetails().add(dgHistoSampleCollectionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgSampleCollectionHeader)) return false;
		else {
			jkt.hms.masters.business.DgSampleCollectionHeader dgSampleCollectionHeader = (jkt.hms.masters.business.DgSampleCollectionHeader) obj;
			if (null == this.getId() || null == dgSampleCollectionHeader.getId()) return false;
			else return (this.getId().equals(dgSampleCollectionHeader.getId()));
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