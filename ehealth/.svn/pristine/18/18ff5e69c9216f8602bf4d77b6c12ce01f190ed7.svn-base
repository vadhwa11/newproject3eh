package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_gatepass_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_gatepass_details"
 */

public abstract class BaseIpdGatepassDetails  implements Serializable {

	public static String REF = "IpdGatepassDetails";
	public static String PROP_VALID_FROM = "ValidFrom";
	public static String PROP_PRINTED_DATE = "PrintedDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRINT_REASON = "PrintReason";
	public static String PROP_ACTIVE_STATUS = "ActiveStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PASS_TYPE = "PassType";
	public static String PROP_ID = "Id";
	public static String PROP_VALID_TO = "ValidTo";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_PRINTED_TIME = "PrintedTime";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_RENEW_RESION = "RenewResion";


	// constructors
	public BaseIpdGatepassDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdGatepassDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIpdGatepassDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasPassPrintReason printReason,
		jkt.hms.masters.business.MasPassType passType) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		this.setPrintReason(printReason);
		this.setPassType(passType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String slNo;
	private java.lang.String activeStatus;
	private java.util.Date validFrom;
	private java.util.Date validTo;
	private java.util.Date printedDate;
	private java.lang.String printedTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String renewResion;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasPassPrintReason printReason;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasPassType passType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="gatepass_id"
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
	 * Return the value associated with the column: sl_no
	 */
	public java.lang.String getSlNo () {
		return slNo;
	}

	/**
	 * Set the value related to the column: sl_no
	 * @param slNo the sl_no value
	 */
	public void setSlNo (java.lang.String slNo) {
		this.slNo = slNo;
	}



	/**
	 * Return the value associated with the column: active_status
	 */
	public java.lang.String getActiveStatus () {
		return activeStatus;
	}

	/**
	 * Set the value related to the column: active_status
	 * @param activeStatus the active_status value
	 */
	public void setActiveStatus (java.lang.String activeStatus) {
		this.activeStatus = activeStatus;
	}



	/**
	 * Return the value associated with the column: valid_from
	 */
	public java.util.Date getValidFrom () {
		return validFrom;
	}

	/**
	 * Set the value related to the column: valid_from
	 * @param validFrom the valid_from value
	 */
	public void setValidFrom (java.util.Date validFrom) {
		this.validFrom = validFrom;
	}



	/**
	 * Return the value associated with the column: valid_to
	 */
	public java.util.Date getValidTo () {
		return validTo;
	}

	/**
	 * Set the value related to the column: valid_to
	 * @param validTo the valid_to value
	 */
	public void setValidTo (java.util.Date validTo) {
		this.validTo = validTo;
	}



	/**
	 * Return the value associated with the column: printed_date
	 */
	public java.util.Date getPrintedDate () {
		return printedDate;
	}

	/**
	 * Set the value related to the column: printed_date
	 * @param printedDate the printed_date value
	 */
	public void setPrintedDate (java.util.Date printedDate) {
		this.printedDate = printedDate;
	}



	/**
	 * Return the value associated with the column: printed_time
	 */
	public java.lang.String getPrintedTime () {
		return printedTime;
	}

	/**
	 * Set the value related to the column: printed_time
	 * @param printedTime the printed_time value
	 */
	public void setPrintedTime (java.lang.String printedTime) {
		this.printedTime = printedTime;
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
	 * Return the value associated with the column: renew_resion
	 */
	public java.lang.String getRenewResion () {
		return renewResion;
	}

	/**
	 * Set the value related to the column: renew_resion
	 * @param renewResion the renew_resion value
	 */
	public void setRenewResion (java.lang.String renewResion) {
		this.renewResion = renewResion;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: print_reason_id
	 */
	public jkt.hms.masters.business.MasPassPrintReason getPrintReason () {
		return printReason;
	}

	/**
	 * Set the value related to the column: print_reason_id
	 * @param printReason the print_reason_id value
	 */
	public void setPrintReason (jkt.hms.masters.business.MasPassPrintReason printReason) {
		this.printReason = printReason;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: pass_type
	 */
	public jkt.hms.masters.business.MasPassType getPassType () {
		return passType;
	}

	/**
	 * Set the value related to the column: pass_type
	 * @param passType the pass_type value
	 */
	public void setPassType (jkt.hms.masters.business.MasPassType passType) {
		this.passType = passType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdGatepassDetails)) return false;
		else {
			jkt.hms.masters.business.IpdGatepassDetails ipdGatepassDetails = (jkt.hms.masters.business.IpdGatepassDetails) obj;
			if (null == this.getId() || null == ipdGatepassDetails.getId()) return false;
			else return (this.getId().equals(ipdGatepassDetails.getId()));
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