package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_expdetails table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_expdetails"
 */

public abstract class BaseEtrExpdetails  implements Serializable {

	public static String REF = "EtrExpdetails";
	public static String PROP_CURID = "Curid";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_TODATE = "Todate";
	public static String PROP_APPROVED_EXPENSE_AMOUNT = "ApprovedExpenseAmount";
	public static String PROP_TO_COUNTRY = "ToCountry";
	public static String PROP_EXGRATE = "Exgrate";
	public static String PROP_FROM_COUNTRY = "FromCountry";
	public static String PROP_FROM_PALCE = "FromPalce";
	public static String PROP_FRMDATE = "Frmdate";
	public static String PROP_STANDARD_AMOUNT = "StandardAmount";
	public static String PROP_EXP = "Exp";
	public static String PROP_DAYS = "Days";
	public static String PROP_ID = "Id";
	public static String PROP_EXPTYPE = "Exptype";
	public static String PROP_TO_PLACE = "ToPlace";


	// constructors
	public BaseEtrExpdetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrExpdetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEtrExpdetails (
		java.lang.Integer id,
		jkt.hrms.masters.business.MstrCode exptype,
		jkt.hrms.masters.business.EtrExpsubmit exp,
		jkt.hms.masters.business.MasCurrency curid) {

		this.setId(id);
		this.setExptype(exptype);
		this.setExp(exp);
		this.setCurid(curid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Float days;
	private java.math.BigDecimal amount;
	private java.util.Date frmdate;
	private java.util.Date todate;
	private java.lang.String description;
	private java.lang.Double exgrate;
	private java.math.BigDecimal approvedExpenseAmount;
	private java.math.BigDecimal standardAmount;

	// many to one
	private jkt.hms.masters.business.MasDistrict toPlace;
	private jkt.hrms.masters.business.MstrCode exptype;
	private jkt.hrms.masters.business.EtrExpsubmit exp;
	private jkt.hms.masters.business.MasDistrict fromPalce;
	private jkt.hms.masters.business.MasCountry fromCountry;
	private jkt.hms.masters.business.MasCurrency curid;
	private jkt.hms.masters.business.MasCountry toCountry;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="expd_id"
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
	 * Return the value associated with the column: days
	 */
	public java.lang.Float getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.Float days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: frmdate
	 */
	public java.util.Date getFrmdate () {
		return frmdate;
	}

	/**
	 * Set the value related to the column: frmdate
	 * @param frmdate the frmdate value
	 */
	public void setFrmdate (java.util.Date frmdate) {
		this.frmdate = frmdate;
	}



	/**
	 * Return the value associated with the column: todate
	 */
	public java.util.Date getTodate () {
		return todate;
	}

	/**
	 * Set the value related to the column: todate
	 * @param todate the todate value
	 */
	public void setTodate (java.util.Date todate) {
		this.todate = todate;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: exgrate
	 */
	public java.lang.Double getExgrate () {
		return exgrate;
	}

	/**
	 * Set the value related to the column: exgrate
	 * @param exgrate the exgrate value
	 */
	public void setExgrate (java.lang.Double exgrate) {
		this.exgrate = exgrate;
	}



	/**
	 * Return the value associated with the column: approved_expense_amount
	 */
	public java.math.BigDecimal getApprovedExpenseAmount () {
		return approvedExpenseAmount;
	}

	/**
	 * Set the value related to the column: approved_expense_amount
	 * @param approvedExpenseAmount the approved_expense_amount value
	 */
	public void setApprovedExpenseAmount (java.math.BigDecimal approvedExpenseAmount) {
		this.approvedExpenseAmount = approvedExpenseAmount;
	}



	/**
	 * Return the value associated with the column: standard_amount
	 */
	public java.math.BigDecimal getStandardAmount () {
		return standardAmount;
	}

	/**
	 * Set the value related to the column: standard_amount
	 * @param standardAmount the standard_amount value
	 */
	public void setStandardAmount (java.math.BigDecimal standardAmount) {
		this.standardAmount = standardAmount;
	}



	/**
	 * Return the value associated with the column: to_place_id
	 */
	public jkt.hms.masters.business.MasDistrict getToPlace () {
		return toPlace;
	}

	/**
	 * Set the value related to the column: to_place_id
	 * @param toPlace the to_place_id value
	 */
	public void setToPlace (jkt.hms.masters.business.MasDistrict toPlace) {
		this.toPlace = toPlace;
	}



	/**
	 * Return the value associated with the column: exptype_id
	 */
	public jkt.hrms.masters.business.MstrCode getExptype () {
		return exptype;
	}

	/**
	 * Set the value related to the column: exptype_id
	 * @param exptype the exptype_id value
	 */
	public void setExptype (jkt.hrms.masters.business.MstrCode exptype) {
		this.exptype = exptype;
	}



	/**
	 * Return the value associated with the column: exp_id
	 */
	public jkt.hrms.masters.business.EtrExpsubmit getExp () {
		return exp;
	}

	/**
	 * Set the value related to the column: exp_id
	 * @param exp the exp_id value
	 */
	public void setExp (jkt.hrms.masters.business.EtrExpsubmit exp) {
		this.exp = exp;
	}



	/**
	 * Return the value associated with the column: from_palce_id
	 */
	public jkt.hms.masters.business.MasDistrict getFromPalce () {
		return fromPalce;
	}

	/**
	 * Set the value related to the column: from_palce_id
	 * @param fromPalce the from_palce_id value
	 */
	public void setFromPalce (jkt.hms.masters.business.MasDistrict fromPalce) {
		this.fromPalce = fromPalce;
	}



	/**
	 * Return the value associated with the column: from_country_id
	 */
	public jkt.hms.masters.business.MasCountry getFromCountry () {
		return fromCountry;
	}

	/**
	 * Set the value related to the column: from_country_id
	 * @param fromCountry the from_country_id value
	 */
	public void setFromCountry (jkt.hms.masters.business.MasCountry fromCountry) {
		this.fromCountry = fromCountry;
	}



	/**
	 * Return the value associated with the column: curid
	 */
	public jkt.hms.masters.business.MasCurrency getCurid () {
		return curid;
	}

	/**
	 * Set the value related to the column: curid
	 * @param curid the curid value
	 */
	public void setCurid (jkt.hms.masters.business.MasCurrency curid) {
		this.curid = curid;
	}



	/**
	 * Return the value associated with the column: to_country_id
	 */
	public jkt.hms.masters.business.MasCountry getToCountry () {
		return toCountry;
	}

	/**
	 * Set the value related to the column: to_country_id
	 * @param toCountry the to_country_id value
	 */
	public void setToCountry (jkt.hms.masters.business.MasCountry toCountry) {
		this.toCountry = toCountry;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrExpdetails)) return false;
		else {
			jkt.hrms.masters.business.EtrExpdetails etrExpdetails = (jkt.hrms.masters.business.EtrExpdetails) obj;
			if (null == this.getId() || null == etrExpdetails.getId()) return false;
			else return (this.getId().equals(etrExpdetails.getId()));
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