package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_transfer_approved table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_transfer_approved"
 */

public abstract class BaseHrTransferApproved  implements Serializable {

	public static String REF = "HrTransferApproved";
	public static String PROP_APPROVED_TIME = "ApprovedTime";
	public static String PROP_TRANSFER_ORDER_NO = "TransferOrderNo";
	public static String PROP_TRANSFER_DISTRICT = "TransferDistrict";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_RELEIVING_SESSION = "ReleivingSession";
	public static String PROP_STATUS = "Status";
	public static String PROP_JOINING_DATE = "JoiningDate";
	public static String PROP_TRANSFER_APP = "TransferApp";
	public static String PROP_ID = "Id";
	public static String PROP_APPROVED_BY_DATE = "ApprovedByDate";
	public static String PROP_ACTUAL_RELEIVING_DATE = "ActualReleivingDate";
	public static String PROP_TRANSFER_INSTITUTE = "TransferInstitute";


	// constructors
	public BaseHrTransferApproved () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTransferApproved (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date joiningDate;
	private java.lang.String status;
	private java.lang.String remarks;
	private java.util.Date approvedByDate;
	private java.lang.String approvedTime;
	private java.lang.String transferOrderNo;
	private java.util.Date actualReleivingDate;

	// many to one
	private jkt.hms.masters.business.HrTransferApplicationM transferApp;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasDistrict transferDistrict;
	private jkt.hms.masters.business.MasHospital transferInstitute;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasOpSession releivingSession;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="trans_approv_id"
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
	 * Return the value associated with the column: joining_date
	 */
	public java.util.Date getJoiningDate () {
		return joiningDate;
	}

	/**
	 * Set the value related to the column: joining_date
	 * @param joiningDate the joining_date value
	 */
	public void setJoiningDate (java.util.Date joiningDate) {
		this.joiningDate = joiningDate;
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
	 * Return the value associated with the column: approved_by_date
	 */
	public java.util.Date getApprovedByDate () {
		return approvedByDate;
	}

	/**
	 * Set the value related to the column: approved_by_date
	 * @param approvedByDate the approved_by_date value
	 */
	public void setApprovedByDate (java.util.Date approvedByDate) {
		this.approvedByDate = approvedByDate;
	}



	/**
	 * Return the value associated with the column: approved_time
	 */
	public java.lang.String getApprovedTime () {
		return approvedTime;
	}

	/**
	 * Set the value related to the column: approved_time
	 * @param approvedTime the approved_time value
	 */
	public void setApprovedTime (java.lang.String approvedTime) {
		this.approvedTime = approvedTime;
	}



	/**
	 * Return the value associated with the column: transfer_order_no
	 */
	public java.lang.String getTransferOrderNo () {
		return transferOrderNo;
	}

	/**
	 * Set the value related to the column: transfer_order_no
	 * @param transferOrderNo the transfer_order_no value
	 */
	public void setTransferOrderNo (java.lang.String transferOrderNo) {
		this.transferOrderNo = transferOrderNo;
	}



	/**
	 * Return the value associated with the column: actual_releving_date
	 */
	public java.util.Date getActualReleivingDate () {
		return actualReleivingDate;
	}

	/**
	 * Set the value related to the column: actual_releving_date
	 * @param actualReleivingDate the actual_releving_date value
	 */
	public void setActualReleivingDate (java.util.Date actualReleivingDate) {
		this.actualReleivingDate = actualReleivingDate;
	}



	/**
	 * Return the value associated with the column: transfer_app_id
	 */
	public jkt.hms.masters.business.HrTransferApplicationM getTransferApp () {
		return transferApp;
	}

	/**
	 * Set the value related to the column: transfer_app_id
	 * @param transferApp the transfer_app_id value
	 */
	public void setTransferApp (jkt.hms.masters.business.HrTransferApplicationM transferApp) {
		this.transferApp = transferApp;
	}



	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: transfer_district
	 */
	public jkt.hms.masters.business.MasDistrict getTransferDistrict () {
		return transferDistrict;
	}

	/**
	 * Set the value related to the column: transfer_district
	 * @param transferDistrict the transfer_district value
	 */
	public void setTransferDistrict (jkt.hms.masters.business.MasDistrict transferDistrict) {
		this.transferDistrict = transferDistrict;
	}



	/**
	 * Return the value associated with the column: transfer_institute
	 */
	public jkt.hms.masters.business.MasHospital getTransferInstitute () {
		return transferInstitute;
	}

	/**
	 * Set the value related to the column: transfer_institute
	 * @param transferInstitute the transfer_institute value
	 */
	public void setTransferInstitute (jkt.hms.masters.business.MasHospital transferInstitute) {
		this.transferInstitute = transferInstitute;
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
	 * Return the value associated with the column: relieving_session
	 */
	public jkt.hms.masters.business.MasOpSession getReleivingSession () {
		return releivingSession;
	}

	/**
	 * Set the value related to the column: relieving_session
	 * @param releivingSession the relieving_session value
	 */
	public void setReleivingSession (jkt.hms.masters.business.MasOpSession releivingSession) {
		this.releivingSession = releivingSession;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrTransferApproved)) return false;
		else {
			jkt.hms.masters.business.HrTransferApproved hrTransferApproved = (jkt.hms.masters.business.HrTransferApproved) obj;
			if (null == this.getId() || null == hrTransferApproved.getId()) return false;
			else return (this.getId().equals(hrTransferApproved.getId()));
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