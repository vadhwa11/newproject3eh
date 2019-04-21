package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_trvsubapptbl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_trvsubapptbl"
 */

public abstract class BaseEtrTrvsubapptbl  implements Serializable {

	public static String REF = "EtrTrvsubapptbl";
	public static String PROP_EXP = "Exp";
	public static String PROP_APPR_STS = "ApprSts";
	public static String PROP_ID = "Id";
	public static String PROP_APPR = "Appr";
	public static String PROP_APPR_DATE = "ApprDate";
	public static String PROP_CMTS = "Cmts";


	// constructors
	public BaseEtrTrvsubapptbl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrTrvsubapptbl (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String cmts;
	private java.lang.String apprSts;
	private java.util.Date apprDate;

	// many to one
	private jkt.hrms.masters.business.EtrExpsubmit exp;
	private jkt.hms.masters.business.MasEmployee appr;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="TrvApp_id"
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
	 * Return the value associated with the column: Cmts
	 */
	public java.lang.String getCmts () {
		return cmts;
	}

	/**
	 * Set the value related to the column: Cmts
	 * @param cmts the Cmts value
	 */
	public void setCmts (java.lang.String cmts) {
		this.cmts = cmts;
	}



	/**
	 * Return the value associated with the column: Appr_Sts
	 */
	public java.lang.String getApprSts () {
		return apprSts;
	}

	/**
	 * Set the value related to the column: Appr_Sts
	 * @param apprSts the Appr_Sts value
	 */
	public void setApprSts (java.lang.String apprSts) {
		this.apprSts = apprSts;
	}



	/**
	 * Return the value associated with the column: Appr_date
	 */
	public java.util.Date getApprDate () {
		return apprDate;
	}

	/**
	 * Set the value related to the column: Appr_date
	 * @param apprDate the Appr_date value
	 */
	public void setApprDate (java.util.Date apprDate) {
		this.apprDate = apprDate;
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
	 * Return the value associated with the column: Appr_id
	 */
	public jkt.hms.masters.business.MasEmployee getAppr () {
		return appr;
	}

	/**
	 * Set the value related to the column: Appr_id
	 * @param appr the Appr_id value
	 */
	public void setAppr (jkt.hms.masters.business.MasEmployee appr) {
		this.appr = appr;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrTrvsubapptbl)) return false;
		else {
			jkt.hrms.masters.business.EtrTrvsubapptbl etrTrvsubapptbl = (jkt.hrms.masters.business.EtrTrvsubapptbl) obj;
			if (null == this.getId() || null == etrTrvsubapptbl.getId()) return false;
			else return (this.getId().equals(etrTrvsubapptbl.getId()));
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