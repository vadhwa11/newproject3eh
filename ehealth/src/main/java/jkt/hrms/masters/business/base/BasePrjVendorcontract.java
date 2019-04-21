package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_vendorcontract table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_vendorcontract"
 */

public abstract class BasePrjVendorcontract  implements Serializable {

	public static String REF = "PrjVendorcontract";
	public static String PROP_STATUS = "Status";
	public static String PROP_VENDOR_SERVICE_TYPE = "VendorServiceType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VENDOR = "Vendor";
	public static String PROP_PRJ = "Prj";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VC_DATE = "VcDate";


	// constructors
	public BasePrjVendorcontract () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjVendorcontract (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date vcDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.VendorServiceType vendorServiceType;
	private jkt.hrms.masters.business.MstrVendor vendor;
	private jkt.hrms.masters.business.MstrProject prj;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Vc_Id"
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
	 * Return the value associated with the column: Vc_Date
	 */
	public java.util.Date getVcDate () {
		return vcDate;
	}

	/**
	 * Set the value related to the column: Vc_Date
	 * @param vcDate the Vc_Date value
	 */
	public void setVcDate (java.util.Date vcDate) {
		this.vcDate = vcDate;
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
	 * Return the value associated with the column: vendor_service_type_id
	 */
	public jkt.hrms.masters.business.VendorServiceType getVendorServiceType () {
		return vendorServiceType;
	}

	/**
	 * Set the value related to the column: vendor_service_type_id
	 * @param vendorServiceType the vendor_service_type_id value
	 */
	public void setVendorServiceType (jkt.hrms.masters.business.VendorServiceType vendorServiceType) {
		this.vendorServiceType = vendorServiceType;
	}



	/**
	 * Return the value associated with the column: Vendor_id
	 */
	public jkt.hrms.masters.business.MstrVendor getVendor () {
		return vendor;
	}

	/**
	 * Set the value related to the column: Vendor_id
	 * @param vendor the Vendor_id value
	 */
	public void setVendor (jkt.hrms.masters.business.MstrVendor vendor) {
		this.vendor = vendor;
	}



	/**
	 * Return the value associated with the column: Prj_id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: Prj_id
	 * @param prj the Prj_id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjVendorcontract)) return false;
		else {
			jkt.hrms.masters.business.PrjVendorcontract prjVendorcontract = (jkt.hrms.masters.business.PrjVendorcontract) obj;
			if (null == this.getId() || null == prjVendorcontract.getId()) return false;
			else return (this.getId().equals(prjVendorcontract.getId()));
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