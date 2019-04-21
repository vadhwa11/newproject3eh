package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_vendor table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_vendor"
 */

public abstract class BaseMstrVendor  implements Serializable {

	public static String REF = "MstrVendor";
	public static String PROP_VENDOR_ADDRESS = "VendorAddress";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_VENDOR_CONTACT_NO = "VendorContactNo";
	public static String PROP_VENDOR_PAN_NO = "VendorPanNo";
	public static String PROP_BANK = "Bank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VENDOR_CODE = "VendorCode";
	public static String PROP_VENDOR_ACC_NO = "VendorAccNo";
	public static String PROP_PEREVIOUS_ASSOCIATE = "PereviousAssociate";
	public static String PROP_VENDOR_SERVICE = "VendorService";
	public static String PROP_VENDOR_CUST_SERV_NO = "VendorCustServNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_VENDOR_NAME = "VendorName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RATING = "Rating";
	public static String PROP_VENDOR_BRANCH = "VendorBranch";
	public static String PROP_VENDOR_EMAIL_ID = "VendorEmailId";
	public static String PROP_VENDOR_WEB_SITE = "VendorWebSite";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VENDOR_FAX_NO = "VendorFaxNo";


	// constructors
	public BaseMstrVendor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrVendor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vendorName;
	private java.lang.String vendorAddress;
	private java.lang.String vendorContactNo;
	private java.lang.String vendorFaxNo;
	private java.lang.String vendorEmailId;
	private java.lang.String vendorWebSite;
	private java.lang.String vendorCustServNo;
	private java.lang.String vendorPanNo;
	private java.lang.String vendorBranch;
	private java.lang.String vendorAccNo;
	private java.lang.String pereviousAssociate;
	private java.lang.String comments;
	private java.lang.String status;
	private java.lang.String vendorCode;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.VendorServiceType vendorService;
	private jkt.hrms.masters.business.MstrRating rating;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="vendor_id"
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
	 * Return the value associated with the column: vendor_name
	 */
	public java.lang.String getVendorName () {
		return vendorName;
	}

	/**
	 * Set the value related to the column: vendor_name
	 * @param vendorName the vendor_name value
	 */
	public void setVendorName (java.lang.String vendorName) {
		this.vendorName = vendorName;
	}



	/**
	 * Return the value associated with the column: vendor_address
	 */
	public java.lang.String getVendorAddress () {
		return vendorAddress;
	}

	/**
	 * Set the value related to the column: vendor_address
	 * @param vendorAddress the vendor_address value
	 */
	public void setVendorAddress (java.lang.String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}



	/**
	 * Return the value associated with the column: vendor_contact_no
	 */
	public java.lang.String getVendorContactNo () {
		return vendorContactNo;
	}

	/**
	 * Set the value related to the column: vendor_contact_no
	 * @param vendorContactNo the vendor_contact_no value
	 */
	public void setVendorContactNo (java.lang.String vendorContactNo) {
		this.vendorContactNo = vendorContactNo;
	}



	/**
	 * Return the value associated with the column: vendor_fax_no
	 */
	public java.lang.String getVendorFaxNo () {
		return vendorFaxNo;
	}

	/**
	 * Set the value related to the column: vendor_fax_no
	 * @param vendorFaxNo the vendor_fax_no value
	 */
	public void setVendorFaxNo (java.lang.String vendorFaxNo) {
		this.vendorFaxNo = vendorFaxNo;
	}



	/**
	 * Return the value associated with the column: vendor_email_id
	 */
	public java.lang.String getVendorEmailId () {
		return vendorEmailId;
	}

	/**
	 * Set the value related to the column: vendor_email_id
	 * @param vendorEmailId the vendor_email_id value
	 */
	public void setVendorEmailId (java.lang.String vendorEmailId) {
		this.vendorEmailId = vendorEmailId;
	}



	/**
	 * Return the value associated with the column: vendor_web_site
	 */
	public java.lang.String getVendorWebSite () {
		return vendorWebSite;
	}

	/**
	 * Set the value related to the column: vendor_web_site
	 * @param vendorWebSite the vendor_web_site value
	 */
	public void setVendorWebSite (java.lang.String vendorWebSite) {
		this.vendorWebSite = vendorWebSite;
	}



	/**
	 * Return the value associated with the column: vendor_cust_serv_no
	 */
	public java.lang.String getVendorCustServNo () {
		return vendorCustServNo;
	}

	/**
	 * Set the value related to the column: vendor_cust_serv_no
	 * @param vendorCustServNo the vendor_cust_serv_no value
	 */
	public void setVendorCustServNo (java.lang.String vendorCustServNo) {
		this.vendorCustServNo = vendorCustServNo;
	}



	/**
	 * Return the value associated with the column: vendor_pan_no
	 */
	public java.lang.String getVendorPanNo () {
		return vendorPanNo;
	}

	/**
	 * Set the value related to the column: vendor_pan_no
	 * @param vendorPanNo the vendor_pan_no value
	 */
	public void setVendorPanNo (java.lang.String vendorPanNo) {
		this.vendorPanNo = vendorPanNo;
	}



	/**
	 * Return the value associated with the column: vendor_branch
	 */
	public java.lang.String getVendorBranch () {
		return vendorBranch;
	}

	/**
	 * Set the value related to the column: vendor_branch
	 * @param vendorBranch the vendor_branch value
	 */
	public void setVendorBranch (java.lang.String vendorBranch) {
		this.vendorBranch = vendorBranch;
	}



	/**
	 * Return the value associated with the column: vendor_acc_no
	 */
	public java.lang.String getVendorAccNo () {
		return vendorAccNo;
	}

	/**
	 * Set the value related to the column: vendor_acc_no
	 * @param vendorAccNo the vendor_acc_no value
	 */
	public void setVendorAccNo (java.lang.String vendorAccNo) {
		this.vendorAccNo = vendorAccNo;
	}



	/**
	 * Return the value associated with the column: perevious_associate
	 */
	public java.lang.String getPereviousAssociate () {
		return pereviousAssociate;
	}

	/**
	 * Set the value related to the column: perevious_associate
	 * @param pereviousAssociate the perevious_associate value
	 */
	public void setPereviousAssociate (java.lang.String pereviousAssociate) {
		this.pereviousAssociate = pereviousAssociate;
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
	 * Return the value associated with the column: vendor_code
	 */
	public java.lang.String getVendorCode () {
		return vendorCode;
	}

	/**
	 * Set the value related to the column: vendor_code
	 * @param vendorCode the vendor_code value
	 */
	public void setVendorCode (java.lang.String vendorCode) {
		this.vendorCode = vendorCode;
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
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: vendor_service_id
	 */
	public jkt.hrms.masters.business.VendorServiceType getVendorService () {
		return vendorService;
	}

	/**
	 * Set the value related to the column: vendor_service_id
	 * @param vendorService the vendor_service_id value
	 */
	public void setVendorService (jkt.hrms.masters.business.VendorServiceType vendorService) {
		this.vendorService = vendorService;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrVendor)) return false;
		else {
			jkt.hrms.masters.business.MstrVendor mstrVendor = (jkt.hrms.masters.business.MstrVendor) obj;
			if (null == this.getId() || null == mstrVendor.getId()) return false;
			else return (this.getId().equals(mstrVendor.getId()));
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