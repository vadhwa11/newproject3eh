package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the transfer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="transfer"
 */

public abstract class BaseTransfer  implements Serializable {

	public static String REF = "Transfer";
	public static String PROP_TIME_OF_TRANSFER = "TimeOfTransfer";
	public static String PROP_LIST_DATE = "ListDate";
	public static String PROP_REQUEST_STATUS = "RequestStatus";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PAYWARD_BOOKING_STATUS = "PaywardBookingStatus";
	public static String PROP_TRANSFER_TYPE = "TransferType";
	public static String PROP_TRANSFER_REASON = "TransferReason";
	public static String PROP_FROM_BED = "FromBed";
	public static String PROP_DATE_OF_TRANSFER = "DateOfTransfer";
	public static String PROP_TO_WARD = "ToWard";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_TRANSFER_NO = "TransferNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_AD_STATUS = "AdStatus";
	public static String PROP_TO_BED = "ToBed";
	public static String PROP_AUTHORIZED_BY = "AuthorizedBy";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_PATIENT_CONDITION = "PatientCondition";
	public static String PROP_FROM_WARD = "FromWard";
	public static String PROP_ID = "Id";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_LIST = "List";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_LIST_TIME = "ListTime";


	// constructors
	public BaseTransfer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTransfer (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.String adStatus;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.util.Date dateOfTransfer;
	private java.lang.String list;
	private java.util.Date listDate;
	private java.lang.String listTime;
	private java.lang.String patientCondition;
	private java.lang.String paywardBookingStatus;
	private java.lang.String requestStatus;
	private java.lang.String status;
	private java.lang.String timeOfTransfer;
	private java.lang.Integer transferNo;
	private java.lang.String transferReason;
	private java.lang.String transferType;

	// many to one
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasEmployee authorizedBy;
	private jkt.hms.masters.business.MasBed fromBed;
	private jkt.hms.masters.business.MasDepartment fromWard;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasBed toBed;
	private jkt.hms.masters.business.MasDepartment toWard;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="transfer_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: ad_status
	 */
	public java.lang.String getAdStatus () {
		return adStatus;
	}

	/**
	 * Set the value related to the column: ad_status
	 * @param adStatus the ad_status value
	 */
	public void setAdStatus (java.lang.String adStatus) {
		this.adStatus = adStatus;
	}



	/**
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate () {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * @param addEditDate the add_edit_date value
	 */
	public void setAddEditDate (java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}



	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * @param addEditTime the add_edit_time value
	 */
	public void setAddEditTime (java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
	}



	/**
	 * Return the value associated with the column: date_of_transfer
	 */
	public java.util.Date getDateOfTransfer () {
		return dateOfTransfer;
	}

	/**
	 * Set the value related to the column: date_of_transfer
	 * @param dateOfTransfer the date_of_transfer value
	 */
	public void setDateOfTransfer (java.util.Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}



	/**
	 * Return the value associated with the column: list
	 */
	public java.lang.String getList () {
		return list;
	}

	/**
	 * Set the value related to the column: list
	 * @param list the list value
	 */
	public void setList (java.lang.String list) {
		this.list = list;
	}



	/**
	 * Return the value associated with the column: list_date
	 */
	public java.util.Date getListDate () {
		return listDate;
	}

	/**
	 * Set the value related to the column: list_date
	 * @param listDate the list_date value
	 */
	public void setListDate (java.util.Date listDate) {
		this.listDate = listDate;
	}



	/**
	 * Return the value associated with the column: list_time
	 */
	public java.lang.String getListTime () {
		return listTime;
	}

	/**
	 * Set the value related to the column: list_time
	 * @param listTime the list_time value
	 */
	public void setListTime (java.lang.String listTime) {
		this.listTime = listTime;
	}



	/**
	 * Return the value associated with the column: patient_condition
	 */
	public java.lang.String getPatientCondition () {
		return patientCondition;
	}

	/**
	 * Set the value related to the column: patient_condition
	 * @param patientCondition the patient_condition value
	 */
	public void setPatientCondition (java.lang.String patientCondition) {
		this.patientCondition = patientCondition;
	}



	/**
	 * Return the value associated with the column: payward_booking_status
	 */
	public java.lang.String getPaywardBookingStatus () {
		return paywardBookingStatus;
	}

	/**
	 * Set the value related to the column: payward_booking_status
	 * @param paywardBookingStatus the payward_booking_status value
	 */
	public void setPaywardBookingStatus (java.lang.String paywardBookingStatus) {
		this.paywardBookingStatus = paywardBookingStatus;
	}



	/**
	 * Return the value associated with the column: request_status
	 */
	public java.lang.String getRequestStatus () {
		return requestStatus;
	}

	/**
	 * Set the value related to the column: request_status
	 * @param requestStatus the request_status value
	 */
	public void setRequestStatus (java.lang.String requestStatus) {
		this.requestStatus = requestStatus;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: time_of_transfer
	 */
	public java.lang.String getTimeOfTransfer () {
		return timeOfTransfer;
	}

	/**
	 * Set the value related to the column: time_of_transfer
	 * @param timeOfTransfer the time_of_transfer value
	 */
	public void setTimeOfTransfer (java.lang.String timeOfTransfer) {
		this.timeOfTransfer = timeOfTransfer;
	}



	/**
	 * Return the value associated with the column: transfer_no
	 */
	public java.lang.Integer getTransferNo () {
		return transferNo;
	}

	/**
	 * Set the value related to the column: transfer_no
	 * @param transferNo the transfer_no value
	 */
	public void setTransferNo (java.lang.Integer transferNo) {
		this.transferNo = transferNo;
	}



	/**
	 * Return the value associated with the column: transfer_reason
	 */
	public java.lang.String getTransferReason () {
		return transferReason;
	}

	/**
	 * Set the value related to the column: transfer_reason
	 * @param transferReason the transfer_reason value
	 */
	public void setTransferReason (java.lang.String transferReason) {
		this.transferReason = transferReason;
	}



	/**
	 * Return the value associated with the column: transfer_type
	 */
	public java.lang.String getTransferType () {
		return transferType;
	}

	/**
	 * Set the value related to the column: transfer_type
	 * @param transferType the transfer_type value
	 */
	public void setTransferType (java.lang.String transferType) {
		this.transferType = transferType;
	}



	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
	}



	/**
	 * Return the value associated with the column: authorized_by_id
	 */
	public jkt.hms.masters.business.MasEmployee getAuthorizedBy () {
		return authorizedBy;
	}

	/**
	 * Set the value related to the column: authorized_by_id
	 * @param authorizedBy the authorized_by_id value
	 */
	public void setAuthorizedBy (jkt.hms.masters.business.MasEmployee authorizedBy) {
		this.authorizedBy = authorizedBy;
	}



	/**
	 * Return the value associated with the column: from_bed_id
	 */
	public jkt.hms.masters.business.MasBed getFromBed () {
		return fromBed;
	}

	/**
	 * Set the value related to the column: from_bed_id
	 * @param fromBed the from_bed_id value
	 */
	public void setFromBed (jkt.hms.masters.business.MasBed fromBed) {
		this.fromBed = fromBed;
	}



	/**
	 * Return the value associated with the column: from_ward_id
	 */
	public jkt.hms.masters.business.MasDepartment getFromWard () {
		return fromWard;
	}

	/**
	 * Set the value related to the column: from_ward_id
	 * @param fromWard the from_ward_id value
	 */
	public void setFromWard (jkt.hms.masters.business.MasDepartment fromWard) {
		this.fromWard = fromWard;
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
	 * Return the value associated with the column: to_bed_id
	 */
	public jkt.hms.masters.business.MasBed getToBed () {
		return toBed;
	}

	/**
	 * Set the value related to the column: to_bed_id
	 * @param toBed the to_bed_id value
	 */
	public void setToBed (jkt.hms.masters.business.MasBed toBed) {
		this.toBed = toBed;
	}



	/**
	 * Return the value associated with the column: to_ward_id
	 */
	public jkt.hms.masters.business.MasDepartment getToWard () {
		return toWard;
	}

	/**
	 * Set the value related to the column: to_ward_id
	 * @param toWard the to_ward_id value
	 */
	public void setToWard (jkt.hms.masters.business.MasDepartment toWard) {
		this.toWard = toWard;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Transfer)) return false;
		else {
			jkt.hms.masters.business.Transfer transfer = (jkt.hms.masters.business.Transfer) obj;
			if (null == this.getId() || null == transfer.getId()) return false;
			else return (this.getId().equals(transfer.getId()));
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