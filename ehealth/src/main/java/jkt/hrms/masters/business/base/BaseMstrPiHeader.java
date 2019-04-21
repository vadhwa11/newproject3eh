package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_pi_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_pi_header"
 */

public abstract class BaseMstrPiHeader  implements Serializable {

	public static String REF = "MstrPiHeader";
	public static String PROP_PI_PAN_NO = "PiPanNo";
	public static String PROP_PI_ACC_NO = "PiAccNo";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BANK = "Bank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PI_BRANCH = "PiBranch";
	public static String PROP_PI_PREVIOUS_ASSOCIATION = "PiPreviousAssociation";
	public static String PROP_PI_NAME = "PiName";
	public static String PROP_PI_EMAIL_ID = "PiEmailId";
	public static String PROP_PI_MOBILE_NO = "PiMobileNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PI_CONTACT_NO = "PiContactNo";
	public static String PROP_RATING = "Rating";
	public static String PROP_PI_ADDRESS = "PiAddress";
	public static String PROP_PI_MED_REG_NO = "PiMedRegNo";
	public static String PROP_ID = "Id";
	public static String PROP_PI_FAX_NO = "PiFaxNo";
	public static String PROP_PI_CODE = "PiCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DESIGNATION = "Designation";


	// constructors
	public BaseMstrPiHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrPiHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String piName;
	private java.lang.String piAddress;
	private java.lang.String piContactNo;
	private java.lang.String piMobileNo;
	private java.lang.String piEmailId;
	private java.lang.String piFaxNo;
	private java.lang.String piMedRegNo;
	private java.lang.String piPanNo;
	private java.lang.String piBranch;
	private java.lang.String piPreviousAssociation;
	private java.lang.String piAccNo;
	private java.lang.String comments;
	private java.lang.String status;
	private java.lang.String designation;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String piCode;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrRating rating;

	// collections
	private java.util.Set<jkt.hrms.masters.business.MstrPiDetail> mstrPiDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pi_header_id"
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
	 * Return the value associated with the column: pi_name
	 */
	public java.lang.String getPiName () {
		return piName;
	}

	/**
	 * Set the value related to the column: pi_name
	 * @param piName the pi_name value
	 */
	public void setPiName (java.lang.String piName) {
		this.piName = piName;
	}



	/**
	 * Return the value associated with the column: pi_address
	 */
	public java.lang.String getPiAddress () {
		return piAddress;
	}

	/**
	 * Set the value related to the column: pi_address
	 * @param piAddress the pi_address value
	 */
	public void setPiAddress (java.lang.String piAddress) {
		this.piAddress = piAddress;
	}



	/**
	 * Return the value associated with the column: pi_contact_no
	 */
	public java.lang.String getPiContactNo () {
		return piContactNo;
	}

	/**
	 * Set the value related to the column: pi_contact_no
	 * @param piContactNo the pi_contact_no value
	 */
	public void setPiContactNo (java.lang.String piContactNo) {
		this.piContactNo = piContactNo;
	}



	/**
	 * Return the value associated with the column: pi_mobile_no
	 */
	public java.lang.String getPiMobileNo () {
		return piMobileNo;
	}

	/**
	 * Set the value related to the column: pi_mobile_no
	 * @param piMobileNo the pi_mobile_no value
	 */
	public void setPiMobileNo (java.lang.String piMobileNo) {
		this.piMobileNo = piMobileNo;
	}



	/**
	 * Return the value associated with the column: pi_email_id
	 */
	public java.lang.String getPiEmailId () {
		return piEmailId;
	}

	/**
	 * Set the value related to the column: pi_email_id
	 * @param piEmailId the pi_email_id value
	 */
	public void setPiEmailId (java.lang.String piEmailId) {
		this.piEmailId = piEmailId;
	}



	/**
	 * Return the value associated with the column: pi_fax_no
	 */
	public java.lang.String getPiFaxNo () {
		return piFaxNo;
	}

	/**
	 * Set the value related to the column: pi_fax_no
	 * @param piFaxNo the pi_fax_no value
	 */
	public void setPiFaxNo (java.lang.String piFaxNo) {
		this.piFaxNo = piFaxNo;
	}



	/**
	 * Return the value associated with the column: pi_med_reg_no
	 */
	public java.lang.String getPiMedRegNo () {
		return piMedRegNo;
	}

	/**
	 * Set the value related to the column: pi_med_reg_no
	 * @param piMedRegNo the pi_med_reg_no value
	 */
	public void setPiMedRegNo (java.lang.String piMedRegNo) {
		this.piMedRegNo = piMedRegNo;
	}



	/**
	 * Return the value associated with the column: pi_pan_no
	 */
	public java.lang.String getPiPanNo () {
		return piPanNo;
	}

	/**
	 * Set the value related to the column: pi_pan_no
	 * @param piPanNo the pi_pan_no value
	 */
	public void setPiPanNo (java.lang.String piPanNo) {
		this.piPanNo = piPanNo;
	}



	/**
	 * Return the value associated with the column: pi_branch
	 */
	public java.lang.String getPiBranch () {
		return piBranch;
	}

	/**
	 * Set the value related to the column: pi_branch
	 * @param piBranch the pi_branch value
	 */
	public void setPiBranch (java.lang.String piBranch) {
		this.piBranch = piBranch;
	}



	/**
	 * Return the value associated with the column: pi_previous_association
	 */
	public java.lang.String getPiPreviousAssociation () {
		return piPreviousAssociation;
	}

	/**
	 * Set the value related to the column: pi_previous_association
	 * @param piPreviousAssociation the pi_previous_association value
	 */
	public void setPiPreviousAssociation (java.lang.String piPreviousAssociation) {
		this.piPreviousAssociation = piPreviousAssociation;
	}



	/**
	 * Return the value associated with the column: pi_acc_no
	 */
	public java.lang.String getPiAccNo () {
		return piAccNo;
	}

	/**
	 * Set the value related to the column: pi_acc_no
	 * @param piAccNo the pi_acc_no value
	 */
	public void setPiAccNo (java.lang.String piAccNo) {
		this.piAccNo = piAccNo;
	}



	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param comments the comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
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
	 * Return the value associated with the column: designation
	 */
	public java.lang.String getDesignation () {
		return designation;
	}

	/**
	 * Set the value related to the column: designation
	 * @param designation the designation value
	 */
	public void setDesignation (java.lang.String designation) {
		this.designation = designation;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: pi_code
	 */
	public java.lang.String getPiCode () {
		return piCode;
	}

	/**
	 * Set the value related to the column: pi_code
	 * @param piCode the pi_code value
	 */
	public void setPiCode (java.lang.String piCode) {
		this.piCode = piCode;
	}



	/**
	 * Return the value associated with the column: bank_id
	 */
	public jkt.hms.masters.business.MasBankMaster getBank () {
		return bank;
	}

	/**
	 * Set the value related to the column: bank_id
	 * @param bank the bank_id value
	 */
	public void setBank (jkt.hms.masters.business.MasBankMaster bank) {
		this.bank = bank;
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
	 * Return the value associated with the column: rating_id
	 */
	public jkt.hrms.masters.business.MstrRating getRating () {
		return rating;
	}

	/**
	 * Set the value related to the column: rating_id
	 * @param rating the rating_id value
	 */
	public void setRating (jkt.hrms.masters.business.MstrRating rating) {
		this.rating = rating;
	}



	/**
	 * Return the value associated with the column: MstrPiDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrPiDetail> getMstrPiDetails () {
		return mstrPiDetails;
	}

	/**
	 * Set the value related to the column: MstrPiDetails
	 * @param mstrPiDetails the MstrPiDetails value
	 */
	public void setMstrPiDetails (java.util.Set<jkt.hrms.masters.business.MstrPiDetail> mstrPiDetails) {
		this.mstrPiDetails = mstrPiDetails;
	}

	public void addToMstrPiDetails (jkt.hrms.masters.business.MstrPiDetail mstrPiDetail) {
		if (null == getMstrPiDetails()) setMstrPiDetails(new java.util.TreeSet<jkt.hrms.masters.business.MstrPiDetail>());
		getMstrPiDetails().add(mstrPiDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrPiHeader)) return false;
		else {
			jkt.hrms.masters.business.MstrPiHeader mstrPiHeader = (jkt.hrms.masters.business.MstrPiHeader) obj;
			if (null == this.getId() || null == mstrPiHeader.getId()) return false;
			else return (this.getId().equals(mstrPiHeader.getId()));
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