package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_pass_print_reason table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_pass_print_reason"
 */

public abstract class BaseMasPassPrintReason  implements Serializable {

	public static String REF = "MasPassPrintReason";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_PRINT_REASON_CODE = "PrintReasonCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PRINT_REASON_NAME = "PrintReasonName";


	// constructors
	public BaseMasPassPrintReason () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPassPrintReason (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasPassPrintReason (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String printReasonCode;
	private java.lang.String printReasonName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdGatepassDetails> ipdGatepassDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="print_reason_id"
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
	 * Return the value associated with the column: print_reason_code
	 */
	public java.lang.String getPrintReasonCode () {
		return printReasonCode;
	}

	/**
	 * Set the value related to the column: print_reason_code
	 * @param printReasonCode the print_reason_code value
	 */
	public void setPrintReasonCode (java.lang.String printReasonCode) {
		this.printReasonCode = printReasonCode;
	}



	/**
	 * Return the value associated with the column: print_reason_name
	 */
	public java.lang.String getPrintReasonName () {
		return printReasonName;
	}

	/**
	 * Set the value related to the column: print_reason_name
	 * @param printReasonName the print_reason_name value
	 */
	public void setPrintReasonName (java.lang.String printReasonName) {
		this.printReasonName = printReasonName;
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
	 * Return the value associated with the column: IpdGatepassDetails
	 */
	public java.util.Set<jkt.hms.masters.business.IpdGatepassDetails> getIpdGatepassDetails () {
		return ipdGatepassDetails;
	}

	/**
	 * Set the value related to the column: IpdGatepassDetails
	 * @param ipdGatepassDetails the IpdGatepassDetails value
	 */
	public void setIpdGatepassDetails (java.util.Set<jkt.hms.masters.business.IpdGatepassDetails> ipdGatepassDetails) {
		this.ipdGatepassDetails = ipdGatepassDetails;
	}

	public void addToIpdGatepassDetails (jkt.hms.masters.business.IpdGatepassDetails ipdGatepassDetails) {
		if (null == getIpdGatepassDetails()) setIpdGatepassDetails(new java.util.TreeSet<jkt.hms.masters.business.IpdGatepassDetails>());
		getIpdGatepassDetails().add(ipdGatepassDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPassPrintReason)) return false;
		else {
			jkt.hms.masters.business.MasPassPrintReason masPassPrintReason = (jkt.hms.masters.business.MasPassPrintReason) obj;
			if (null == this.getId() || null == masPassPrintReason.getId()) return false;
			else return (this.getId().equals(masPassPrintReason.getId()));
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