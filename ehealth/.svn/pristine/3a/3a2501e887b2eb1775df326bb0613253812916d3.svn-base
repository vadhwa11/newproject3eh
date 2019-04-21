package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_insurance_company table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_insurance_company"
 */

public abstract class BaseMasInsuranceCompany  implements Serializable {

	public static String REF = "MasInsuranceCompany";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COMPANY_CODE = "CompanyCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY_NAME = "CompanyName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasInsuranceCompany () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasInsuranceCompany (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String companyCode;
	private java.lang.String companyName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.PrqInsuranceDetails> prqInsuranceDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="company_id"
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
	 * Return the value associated with the column: company_code
	 */
	public java.lang.String getCompanyCode () {
		return companyCode;
	}

	/**
	 * Set the value related to the column: company_code
	 * @param companyCode the company_code value
	 */
	public void setCompanyCode (java.lang.String companyCode) {
		this.companyCode = companyCode;
	}



	/**
	 * Return the value associated with the column: company_name
	 */
	public java.lang.String getCompanyName () {
		return companyName;
	}

	/**
	 * Set the value related to the column: company_name
	 * @param companyName the company_name value
	 */
	public void setCompanyName (java.lang.String companyName) {
		this.companyName = companyName;
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
	 * Return the value associated with the column: PrqInsuranceDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PrqInsuranceDetails> getPrqInsuranceDetails () {
		return prqInsuranceDetails;
	}

	/**
	 * Set the value related to the column: PrqInsuranceDetails
	 * @param prqInsuranceDetails the PrqInsuranceDetails value
	 */
	public void setPrqInsuranceDetails (java.util.Set<jkt.hms.masters.business.PrqInsuranceDetails> prqInsuranceDetails) {
		this.prqInsuranceDetails = prqInsuranceDetails;
	}

	public void addToPrqInsuranceDetails (jkt.hms.masters.business.PrqInsuranceDetails prqInsuranceDetails) {
		if (null == getPrqInsuranceDetails()) setPrqInsuranceDetails(new java.util.TreeSet<jkt.hms.masters.business.PrqInsuranceDetails>());
		getPrqInsuranceDetails().add(prqInsuranceDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasInsuranceCompany)) return false;
		else {
			jkt.hms.masters.business.MasInsuranceCompany masInsuranceCompany = (jkt.hms.masters.business.MasInsuranceCompany) obj;
			if (null == this.getId() || null == masInsuranceCompany.getId()) return false;
			else return (this.getId().equals(masInsuranceCompany.getId()));
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