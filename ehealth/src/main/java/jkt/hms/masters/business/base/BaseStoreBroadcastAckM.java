package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_broadcast_ack_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_broadcast_ack_m"
 */

public abstract class BaseStoreBroadcastAckM  implements Serializable {

	public static String REF = "StoreBroadcastAckM";
	public static String PROP_STATUS = "Status";
	public static String PROP_RESPONDED_DATE = "RespondedDate";
	public static String PROP_REQUESTED_INSTITUTE = "RequestedInstitute";
	public static String PROP_RESPONDED_DEPARTMENT = "RespondedDepartment";
	public static String PROP_RESPONDED_BY = "RespondedBy";
	public static String PROP_RESPONDED_INSTITUTE = "RespondedInstitute";
	public static String PROP_ENQUIRY_M = "EnquiryM";
	public static String PROP_ID = "Id";
	public static String PROP_RESPONDED_TIME = "RespondedTime";


	// constructors
	public BaseStoreBroadcastAckM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBroadcastAckM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date respondedDate;
	private java.lang.String respondedTime;

	// many to one
	private jkt.hms.masters.business.StoreBroadcastEnquiryM enquiryM;
	private jkt.hms.masters.business.MasHospital respondedInstitute;
	private jkt.hms.masters.business.Users respondedBy;
	private jkt.hms.masters.business.MasHospital requestedInstitute;
	private jkt.hms.masters.business.MasDepartment respondedDepartment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ack_m_id"
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
	 * Return the value associated with the column: responded_date
	 */
	public java.util.Date getRespondedDate () {
		return respondedDate;
	}

	/**
	 * Set the value related to the column: responded_date
	 * @param respondedDate the responded_date value
	 */
	public void setRespondedDate (java.util.Date respondedDate) {
		this.respondedDate = respondedDate;
	}



	/**
	 * Return the value associated with the column: responded_time
	 */
	public java.lang.String getRespondedTime () {
		return respondedTime;
	}

	/**
	 * Set the value related to the column: responded_time
	 * @param respondedTime the responded_time value
	 */
	public void setRespondedTime (java.lang.String respondedTime) {
		this.respondedTime = respondedTime;
	}



	/**
	 * Return the value associated with the column: enquiry_m_id
	 */
	public jkt.hms.masters.business.StoreBroadcastEnquiryM getEnquiryM () {
		return enquiryM;
	}

	/**
	 * Set the value related to the column: enquiry_m_id
	 * @param enquiryM the enquiry_m_id value
	 */
	public void setEnquiryM (jkt.hms.masters.business.StoreBroadcastEnquiryM enquiryM) {
		this.enquiryM = enquiryM;
	}



	/**
	 * Return the value associated with the column: responded_institute_id
	 */
	public jkt.hms.masters.business.MasHospital getRespondedInstitute () {
		return respondedInstitute;
	}

	/**
	 * Set the value related to the column: responded_institute_id
	 * @param respondedInstitute the responded_institute_id value
	 */
	public void setRespondedInstitute (jkt.hms.masters.business.MasHospital respondedInstitute) {
		this.respondedInstitute = respondedInstitute;
	}



	/**
	 * Return the value associated with the column: responded_by
	 */
	public jkt.hms.masters.business.Users getRespondedBy () {
		return respondedBy;
	}

	/**
	 * Set the value related to the column: responded_by
	 * @param respondedBy the responded_by value
	 */
	public void setRespondedBy (jkt.hms.masters.business.Users respondedBy) {
		this.respondedBy = respondedBy;
	}



	/**
	 * Return the value associated with the column: requested_institute_id
	 */
	public jkt.hms.masters.business.MasHospital getRequestedInstitute () {
		return requestedInstitute;
	}

	/**
	 * Set the value related to the column: requested_institute_id
	 * @param requestedInstitute the requested_institute_id value
	 */
	public void setRequestedInstitute (jkt.hms.masters.business.MasHospital requestedInstitute) {
		this.requestedInstitute = requestedInstitute;
	}



	/**
	 * Return the value associated with the column: responded_department_id
	 */
	public jkt.hms.masters.business.MasDepartment getRespondedDepartment () {
		return respondedDepartment;
	}

	/**
	 * Set the value related to the column: responded_department_id
	 * @param respondedDepartment the responded_department_id value
	 */
	public void setRespondedDepartment (jkt.hms.masters.business.MasDepartment respondedDepartment) {
		this.respondedDepartment = respondedDepartment;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreBroadcastAckM)) return false;
		else {
			jkt.hms.masters.business.StoreBroadcastAckM storeBroadcastAckM = (jkt.hms.masters.business.StoreBroadcastAckM) obj;
			if (null == this.getId() || null == storeBroadcastAckM.getId()) return false;
			else return (this.getId().equals(storeBroadcastAckM.getId()));
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