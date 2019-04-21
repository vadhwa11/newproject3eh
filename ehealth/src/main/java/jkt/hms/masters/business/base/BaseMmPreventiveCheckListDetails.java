package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_preventive_check_list_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_preventive_check_list_details"
 */

public abstract class BaseMmPreventiveCheckListDetails  implements Serializable {

	public static String REF = "MmPreventiveCheckListDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_PREVENTIVE_NO = "PreventiveNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_CHECK_LIST = "CheckList";
	public static String PROP_REQUEST = "Request";
	public static String PROP_INSPECTION_REPORT = "InspectionReport";


	// constructors
	public BaseMmPreventiveCheckListDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmPreventiveCheckListDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer preventiveNo;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MmPreventiveCheckList checkList;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MmInspectionReport inspectionReport;
	private jkt.hms.masters.business.MmServiceRequest request;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="preventive_details_id"
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
	 * Return the value associated with the column: preventive_no
	 */
	public java.lang.Integer getPreventiveNo () {
		return preventiveNo;
	}

	/**
	 * Set the value related to the column: preventive_no
	 * @param preventiveNo the preventive_no value
	 */
	public void setPreventiveNo (java.lang.Integer preventiveNo) {
		this.preventiveNo = preventiveNo;
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
	 * Return the value associated with the column: check_list_id
	 */
	public jkt.hms.masters.business.MmPreventiveCheckList getCheckList () {
		return checkList;
	}

	/**
	 * Set the value related to the column: check_list_id
	 * @param checkList the check_list_id value
	 */
	public void setCheckList (jkt.hms.masters.business.MmPreventiveCheckList checkList) {
		this.checkList = checkList;
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
	 * Return the value associated with the column: inspection_report_id
	 */
	public jkt.hms.masters.business.MmInspectionReport getInspectionReport () {
		return inspectionReport;
	}

	/**
	 * Set the value related to the column: inspection_report_id
	 * @param inspectionReport the inspection_report_id value
	 */
	public void setInspectionReport (jkt.hms.masters.business.MmInspectionReport inspectionReport) {
		this.inspectionReport = inspectionReport;
	}



	/**
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.MmServiceRequest getRequest () {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * @param request the request_id value
	 */
	public void setRequest (jkt.hms.masters.business.MmServiceRequest request) {
		this.request = request;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmPreventiveCheckListDetails)) return false;
		else {
			jkt.hms.masters.business.MmPreventiveCheckListDetails mmPreventiveCheckListDetails = (jkt.hms.masters.business.MmPreventiveCheckListDetails) obj;
			if (null == this.getId() || null == mmPreventiveCheckListDetails.getId()) return false;
			else return (this.getId().equals(mmPreventiveCheckListDetails.getId()));
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