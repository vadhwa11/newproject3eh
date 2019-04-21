package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_scheme table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_scheme"
 */

public abstract class BaseMasScheme  implements Serializable {

	public static String REF = "MasScheme";
	public static String PROP_STATUS = "Status";
	public static String PROP_LETTER_FLAG = "LetterFlag";
	public static String PROP_FUNDED_BY = "FundedBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SCHEME_CODE = "SchemeCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SCHEME_NAME = "SchemeName";
	public static String PROP_SCHEME_TYPE = "SchemeType";


	// constructors
	public BaseMasScheme () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasScheme (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String schemeCode;
	private java.lang.String schemeName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String schemeType;
	private java.lang.String lastChgTime;
	private java.lang.String letterFlag;
	private java.lang.String fundedBy;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.FaSchemeAccountMapping> faSchemeAccountMappings;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="scheme_id"
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
	 * Return the value associated with the column: scheme_code
	 */
	public java.lang.String getSchemeCode () {
		return schemeCode;
	}

	/**
	 * Set the value related to the column: scheme_code
	 * @param schemeCode the scheme_code value
	 */
	public void setSchemeCode (java.lang.String schemeCode) {
		this.schemeCode = schemeCode;
	}



	/**
	 * Return the value associated with the column: scheme_name
	 */
	public java.lang.String getSchemeName () {
		return schemeName;
	}

	/**
	 * Set the value related to the column: scheme_name
	 * @param schemeName the scheme_name value
	 */
	public void setSchemeName (java.lang.String schemeName) {
		this.schemeName = schemeName;
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
	 * Return the value associated with the column: scheme_type
	 */
	public java.lang.String getSchemeType () {
		return schemeType;
	}

	/**
	 * Set the value related to the column: scheme_type
	 * @param schemeType the scheme_type value
	 */
	public void setSchemeType (java.lang.String schemeType) {
		this.schemeType = schemeType;
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
	 * Return the value associated with the column: letter_flag
	 */
	public java.lang.String getLetterFlag () {
		return letterFlag;
	}

	/**
	 * Set the value related to the column: letter_flag
	 * @param letterFlag the letter_flag value
	 */
	public void setLetterFlag (java.lang.String letterFlag) {
		this.letterFlag = letterFlag;
	}



	/**
	 * Return the value associated with the column: funded_by
	 */
	public java.lang.String getFundedBy () {
		return fundedBy;
	}

	/**
	 * Set the value related to the column: funded_by
	 * @param fundedBy the funded_by value
	 */
	public void setFundedBy (java.lang.String fundedBy) {
		this.fundedBy = fundedBy;
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
	 * Return the value associated with the column: FaSchemeAccountMappings
	 */
	public java.util.Set<jkt.hms.masters.business.FaSchemeAccountMapping> getFaSchemeAccountMappings () {
		return faSchemeAccountMappings;
	}

	/**
	 * Set the value related to the column: FaSchemeAccountMappings
	 * @param faSchemeAccountMappings the FaSchemeAccountMappings value
	 */
	public void setFaSchemeAccountMappings (java.util.Set<jkt.hms.masters.business.FaSchemeAccountMapping> faSchemeAccountMappings) {
		this.faSchemeAccountMappings = faSchemeAccountMappings;
	}

	public void addToFaSchemeAccountMappings (jkt.hms.masters.business.FaSchemeAccountMapping faSchemeAccountMapping) {
		if (null == getFaSchemeAccountMappings()) setFaSchemeAccountMappings(new java.util.TreeSet<jkt.hms.masters.business.FaSchemeAccountMapping>());
		getFaSchemeAccountMappings().add(faSchemeAccountMapping);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasScheme)) return false;
		else {
			jkt.hms.masters.business.MasScheme masScheme = (jkt.hms.masters.business.MasScheme) obj;
			if (null == this.getId() || null == masScheme.getId()) return false;
			else return (this.getId().equals(masScheme.getId()));
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