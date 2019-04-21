package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bld_crossmatching_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bld_crossmatching_header"
 */

public abstract class BaseBldCrossmatchingHeader  implements Serializable {

	public static String REF = "BldCrossmatchingHeader";
	public static String PROP_CROSS_MATCH_TIME = "CrossMatchTime";
	public static String PROP_CROSS_MATCH_STATUS = "CrossMatchStatus";
	public static String PROP_BLD_GROUP = "BldGroup";
	public static String PROP_BAG_NO = "BagNo";
	public static String PROP_CROSS_MATCH_BY = "CrossMatchBy";
	public static String PROP_BLD_REQUEST_COMPONENT = "BldRequestComponent";
	public static String PROP_CROSS_MATCH_DATE = "CrossMatchDate";
	public static String PROP_ID = "Id";
	public static String PROP_BLD_BANK_ID = "BldBankId";
	public static String PROP_BLOOD_ISSUE_STATUS = "BloodIssueStatus";
	public static String PROP_BLD_REQUEST = "BldRequest";
	public static String PROP_BLD_REQUEST_HOSPITAL_ID = "BldRequestHospitalId";


	// constructors
	public BaseBldCrossmatchingHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBldCrossmatchingHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String crossMatchTime;
	private java.lang.String crossMatchStatus;
	private java.lang.String bagNo;
	private java.util.Date crossMatchDate;
	private java.lang.String bloodIssueStatus;

	// many to one
	private jkt.hms.masters.business.Users crossMatchBy;
	private jkt.hms.masters.business.MasBloodGroup bldGroup;
	private jkt.hms.masters.business.BloodMasComponent bldRequestComponent;
	private jkt.hms.masters.business.BloodRequestEntryHeader bldRequest;
	private jkt.hms.masters.business.MasHospital bldRequestHospitalId;
	private jkt.hms.masters.business.MasHospital bldBankId;



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
	 * Return the value associated with the column: cross_match_time
	 */
	public java.lang.String getCrossMatchTime () {
		return crossMatchTime;
	}

	/**
	 * Set the value related to the column: cross_match_time
	 * @param crossMatchTime the cross_match_time value
	 */
	public void setCrossMatchTime (java.lang.String crossMatchTime) {
		this.crossMatchTime = crossMatchTime;
	}



	/**
	 * Return the value associated with the column: cross_match_status
	 */
	public java.lang.String getCrossMatchStatus () {
		return crossMatchStatus;
	}

	/**
	 * Set the value related to the column: cross_match_status
	 * @param crossMatchStatus the cross_match_status value
	 */
	public void setCrossMatchStatus (java.lang.String crossMatchStatus) {
		this.crossMatchStatus = crossMatchStatus;
	}



	/**
	 * Return the value associated with the column: bag_no
	 */
	public java.lang.String getBagNo () {
		return bagNo;
	}

	/**
	 * Set the value related to the column: bag_no
	 * @param bagNo the bag_no value
	 */
	public void setBagNo (java.lang.String bagNo) {
		this.bagNo = bagNo;
	}



	/**
	 * Return the value associated with the column: cross_match_date
	 */
	public java.util.Date getCrossMatchDate () {
		return crossMatchDate;
	}

	/**
	 * Set the value related to the column: cross_match_date
	 * @param crossMatchDate the cross_match_date value
	 */
	public void setCrossMatchDate (java.util.Date crossMatchDate) {
		this.crossMatchDate = crossMatchDate;
	}



	/**
	 * Return the value associated with the column: blood_issue_status
	 */
	public java.lang.String getBloodIssueStatus () {
		return bloodIssueStatus;
	}

	/**
	 * Set the value related to the column: blood_issue_status
	 * @param bloodIssueStatus the blood_issue_status value
	 */
	public void setBloodIssueStatus (java.lang.String bloodIssueStatus) {
		this.bloodIssueStatus = bloodIssueStatus;
	}



	/**
	 * Return the value associated with the column: cross_match_by
	 */
	public jkt.hms.masters.business.Users getCrossMatchBy () {
		return crossMatchBy;
	}

	/**
	 * Set the value related to the column: cross_match_by
	 * @param crossMatchBy the cross_match_by value
	 */
	public void setCrossMatchBy (jkt.hms.masters.business.Users crossMatchBy) {
		this.crossMatchBy = crossMatchBy;
	}



	/**
	 * Return the value associated with the column: bld_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBldGroup () {
		return bldGroup;
	}

	/**
	 * Set the value related to the column: bld_group_id
	 * @param bldGroup the bld_group_id value
	 */
	public void setBldGroup (jkt.hms.masters.business.MasBloodGroup bldGroup) {
		this.bldGroup = bldGroup;
	}



	/**
	 * Return the value associated with the column: bld_request_component
	 */
	public jkt.hms.masters.business.BloodMasComponent getBldRequestComponent () {
		return bldRequestComponent;
	}

	/**
	 * Set the value related to the column: bld_request_component
	 * @param bldRequestComponent the bld_request_component value
	 */
	public void setBldRequestComponent (jkt.hms.masters.business.BloodMasComponent bldRequestComponent) {
		this.bldRequestComponent = bldRequestComponent;
	}



	/**
	 * Return the value associated with the column: bld_request_id
	 */
	public jkt.hms.masters.business.BloodRequestEntryHeader getBldRequest () {
		return bldRequest;
	}

	/**
	 * Set the value related to the column: bld_request_id
	 * @param bldRequest the bld_request_id value
	 */
	public void setBldRequest (jkt.hms.masters.business.BloodRequestEntryHeader bldRequest) {
		this.bldRequest = bldRequest;
	}



	/**
	 * Return the value associated with the column: bld_request_hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getBldRequestHospitalId () {
		return bldRequestHospitalId;
	}

	/**
	 * Set the value related to the column: bld_request_hospital_id
	 * @param bldRequestHospitalId the bld_request_hospital_id value
	 */
	public void setBldRequestHospitalId (jkt.hms.masters.business.MasHospital bldRequestHospitalId) {
		this.bldRequestHospitalId = bldRequestHospitalId;
	}



	/**
	 * Return the value associated with the column: blood_bank_id
	 */
	public jkt.hms.masters.business.MasHospital getBldBankId () {
		return bldBankId;
	}

	/**
	 * Set the value related to the column: blood_bank_id
	 * @param bldBankId the blood_bank_id value
	 */
	public void setBldBankId (jkt.hms.masters.business.MasHospital bldBankId) {
		this.bldBankId = bldBankId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BldCrossmatchingHeader)) return false;
		else {
			jkt.hms.masters.business.BldCrossmatchingHeader bldCrossmatchingHeader = (jkt.hms.masters.business.BldCrossmatchingHeader) obj;
			if (null == this.getId() || null == bldCrossmatchingHeader.getId()) return false;
			else return (this.getId().equals(bldCrossmatchingHeader.getId()));
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