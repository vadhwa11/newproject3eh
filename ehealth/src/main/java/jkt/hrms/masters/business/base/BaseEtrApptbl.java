package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_apptbl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_apptbl"
 */

public abstract class BaseEtrApptbl  implements Serializable {

	public static String REF = "EtrApptbl";
	public static String PROP_APPR_TIME = "ApprTime";
	public static String PROP_CANCEL_APPR_DATE = "CancelApprDate";
	public static String PROP_TRV = "Trv";
	public static String PROP_APPR_STS = "ApprSts";
	public static String PROP_ID = "Id";
	public static String PROP_APPR = "Appr";
	public static String PROP_CANCEL_APPR_TIME = "CancelApprTime";
	public static String PROP_APPR_DATE = "ApprDate";
	public static String PROP_CMTS = "Cmts";


	// constructors
	public BaseEtrApptbl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrApptbl (java.lang.Integer id) {
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
	private java.lang.String apprTime;
	private java.lang.String cancelApprTime;
	private java.util.Date cancelApprDate;

	// many to one
	private jkt.hms.masters.business.MasEmployee appr;
	private jkt.hrms.masters.business.EtrTravelreq trv;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: appr_time
	 */
	public java.lang.String getApprTime () {
		return apprTime;
	}

	/**
	 * Set the value related to the column: appr_time
	 * @param apprTime the appr_time value
	 */
	public void setApprTime (java.lang.String apprTime) {
		this.apprTime = apprTime;
	}



	/**
	 * Return the value associated with the column: cancel_appr_time
	 */
	public java.lang.String getCancelApprTime () {
		return cancelApprTime;
	}

	/**
	 * Set the value related to the column: cancel_appr_time
	 * @param cancelApprTime the cancel_appr_time value
	 */
	public void setCancelApprTime (java.lang.String cancelApprTime) {
		this.cancelApprTime = cancelApprTime;
	}



	/**
	 * Return the value associated with the column: cancel_appr_date
	 */
	public java.util.Date getCancelApprDate () {
		return cancelApprDate;
	}

	/**
	 * Set the value related to the column: cancel_appr_date
	 * @param cancelApprDate the cancel_appr_date value
	 */
	public void setCancelApprDate (java.util.Date cancelApprDate) {
		this.cancelApprDate = cancelApprDate;
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



	/**
	 * Return the value associated with the column: Trv_id
	 */
	public jkt.hrms.masters.business.EtrTravelreq getTrv () {
		return trv;
	}

	/**
	 * Set the value related to the column: Trv_id
	 * @param trv the Trv_id value
	 */
	public void setTrv (jkt.hrms.masters.business.EtrTravelreq trv) {
		this.trv = trv;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrApptbl)) return false;
		else {
			jkt.hrms.masters.business.EtrApptbl etrApptbl = (jkt.hrms.masters.business.EtrApptbl) obj;
			if (null == this.getId() || null == etrApptbl.getId()) return false;
			else return (this.getId().equals(etrApptbl.getId()));
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