package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_broadcast_enquiry_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_broadcast_enquiry_m"
 */

public abstract class BaseStoreBroadcastEnquiryM  implements Serializable {

	public static String REF = "StoreBroadcastEnquiryM";
	public static String PROP_STATUS = "Status";
	public static String PROP_BROADCAST_NO = "BroadcastNo";
	public static String PROP_REQUESTED_BY = "RequestedBy";
	public static String PROP_BROADCAST_TYPE = "BroadcastType";
	public static String PROP_BROADCAST_TIME = "BroadcastTime";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INSTITUTE = "Institute";
	public static String PROP_VALID_UP_TO = "ValidUpTo";
	public static String PROP_BROADCAST_DATE = "BroadcastDate";


	// constructors
	public BaseStoreBroadcastEnquiryM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBroadcastEnquiryM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String broadcastType;
	private java.lang.String broadcastNo;
	private java.lang.String status;
	private java.util.Date broadcastDate;
	private java.lang.String broadcastTime;
	private java.util.Date validUpTo;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Users requestedBy;
	private jkt.hms.masters.business.MasHospital institute;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreBroadcastEnquiryT> storeBroadcastEnquiryTs;
	private java.util.Set<jkt.hms.masters.business.StoreBroadcastAckM> storeBroadcastAckMs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="enquiry_m_id"
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
	 * Return the value associated with the column: broadcast_type
	 */
	public java.lang.String getBroadcastType () {
		return broadcastType;
	}

	/**
	 * Set the value related to the column: broadcast_type
	 * @param broadcastType the broadcast_type value
	 */
	public void setBroadcastType (java.lang.String broadcastType) {
		this.broadcastType = broadcastType;
	}



	/**
	 * Return the value associated with the column: broadcast_no
	 */
	public java.lang.String getBroadcastNo () {
		return broadcastNo;
	}

	/**
	 * Set the value related to the column: broadcast_no
	 * @param broadcastNo the broadcast_no value
	 */
	public void setBroadcastNo (java.lang.String broadcastNo) {
		this.broadcastNo = broadcastNo;
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
	 * Return the value associated with the column: broadcast_date
	 */
	public java.util.Date getBroadcastDate () {
		return broadcastDate;
	}

	/**
	 * Set the value related to the column: broadcast_date
	 * @param broadcastDate the broadcast_date value
	 */
	public void setBroadcastDate (java.util.Date broadcastDate) {
		this.broadcastDate = broadcastDate;
	}



	/**
	 * Return the value associated with the column: broadcast_time
	 */
	public java.lang.String getBroadcastTime () {
		return broadcastTime;
	}

	/**
	 * Set the value related to the column: broadcast_time
	 * @param broadcastTime the broadcast_time value
	 */
	public void setBroadcastTime (java.lang.String broadcastTime) {
		this.broadcastTime = broadcastTime;
	}



	/**
	 * Return the value associated with the column: valid_up_to
	 */
	public java.util.Date getValidUpTo () {
		return validUpTo;
	}

	/**
	 * Set the value related to the column: valid_up_to
	 * @param validUpTo the valid_up_to value
	 */
	public void setValidUpTo (java.util.Date validUpTo) {
		this.validUpTo = validUpTo;
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
	 * Return the value associated with the column: requested_by
	 */
	public jkt.hms.masters.business.Users getRequestedBy () {
		return requestedBy;
	}

	/**
	 * Set the value related to the column: requested_by
	 * @param requestedBy the requested_by value
	 */
	public void setRequestedBy (jkt.hms.masters.business.Users requestedBy) {
		this.requestedBy = requestedBy;
	}



	/**
	 * Return the value associated with the column: institute_id
	 */
	public jkt.hms.masters.business.MasHospital getInstitute () {
		return institute;
	}

	/**
	 * Set the value related to the column: institute_id
	 * @param institute the institute_id value
	 */
	public void setInstitute (jkt.hms.masters.business.MasHospital institute) {
		this.institute = institute;
	}



	/**
	 * Return the value associated with the column: StoreBroadcastEnquiryTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBroadcastEnquiryT> getStoreBroadcastEnquiryTs () {
		return storeBroadcastEnquiryTs;
	}

	/**
	 * Set the value related to the column: StoreBroadcastEnquiryTs
	 * @param storeBroadcastEnquiryTs the StoreBroadcastEnquiryTs value
	 */
	public void setStoreBroadcastEnquiryTs (java.util.Set<jkt.hms.masters.business.StoreBroadcastEnquiryT> storeBroadcastEnquiryTs) {
		this.storeBroadcastEnquiryTs = storeBroadcastEnquiryTs;
	}

	public void addToStoreBroadcastEnquiryTs (jkt.hms.masters.business.StoreBroadcastEnquiryT storeBroadcastEnquiryT) {
		if (null == getStoreBroadcastEnquiryTs()) setStoreBroadcastEnquiryTs(new java.util.TreeSet<jkt.hms.masters.business.StoreBroadcastEnquiryT>());
		getStoreBroadcastEnquiryTs().add(storeBroadcastEnquiryT);
	}



	/**
	 * Return the value associated with the column: StoreBroadcastAckMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBroadcastAckM> getStoreBroadcastAckMs () {
		return storeBroadcastAckMs;
	}

	/**
	 * Set the value related to the column: StoreBroadcastAckMs
	 * @param storeBroadcastAckMs the StoreBroadcastAckMs value
	 */
	public void setStoreBroadcastAckMs (java.util.Set<jkt.hms.masters.business.StoreBroadcastAckM> storeBroadcastAckMs) {
		this.storeBroadcastAckMs = storeBroadcastAckMs;
	}

	public void addToStoreBroadcastAckMs (jkt.hms.masters.business.StoreBroadcastAckM storeBroadcastAckM) {
		if (null == getStoreBroadcastAckMs()) setStoreBroadcastAckMs(new java.util.TreeSet<jkt.hms.masters.business.StoreBroadcastAckM>());
		getStoreBroadcastAckMs().add(storeBroadcastAckM);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreBroadcastEnquiryM)) return false;
		else {
			jkt.hms.masters.business.StoreBroadcastEnquiryM storeBroadcastEnquiryM = (jkt.hms.masters.business.StoreBroadcastEnquiryM) obj;
			if (null == this.getId() || null == storeBroadcastEnquiryM.getId()) return false;
			else return (this.getId().equals(storeBroadcastEnquiryM.getId()));
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