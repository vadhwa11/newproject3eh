package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_intake table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_intake"
 */

public abstract class BaseIpdIntake  implements Serializable {

	public static String REF = "IpdIntake";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORAL = "Oral";
	public static String PROP_TIME = "Time";
	public static String PROP_PTR = "Ptr";
	public static String PROP_DATE = "Date";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_INTAKE = "TotalIntake";
	public static String PROP_IV_COUNT = "IvCount";
	public static String PROP_IV = "Iv";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INTAKE = "Intake";
	public static String PROP_INTAKEOUTPUT = "Intakeoutput";
	public static String PROP_RYLE_TUBE = "RyleTube";


	// constructors
	public BaseIpdIntake () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdIntake (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date date;
	private java.lang.String time;
	private java.lang.String intake;
	private java.lang.String oral;
	private java.lang.String iv;
	private java.lang.String ivCount;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String ptr;
	private java.lang.String ryleTube;
	private java.lang.String totalIntake;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.IpdIntakeOutputChart intakeoutput;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ipd_intake_id"
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
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getTime () {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * @param time the time value
	 */
	public void setTime (java.lang.String time) {
		this.time = time;
	}



	/**
	 * Return the value associated with the column: intake
	 */
	public java.lang.String getIntake () {
		return intake;
	}

	/**
	 * Set the value related to the column: intake
	 * @param intake the intake value
	 */
	public void setIntake (java.lang.String intake) {
		this.intake = intake;
	}



	/**
	 * Return the value associated with the column: oral
	 */
	public java.lang.String getOral () {
		return oral;
	}

	/**
	 * Set the value related to the column: oral
	 * @param oral the oral value
	 */
	public void setOral (java.lang.String oral) {
		this.oral = oral;
	}



	/**
	 * Return the value associated with the column: iv
	 */
	public java.lang.String getIv () {
		return iv;
	}

	/**
	 * Set the value related to the column: iv
	 * @param iv the iv value
	 */
	public void setIv (java.lang.String iv) {
		this.iv = iv;
	}



	/**
	 * Return the value associated with the column: iv_count
	 */
	public java.lang.String getIvCount () {
		return ivCount;
	}

	/**
	 * Set the value related to the column: iv_count
	 * @param ivCount the iv_count value
	 */
	public void setIvCount (java.lang.String ivCount) {
		this.ivCount = ivCount;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: ptr
	 */
	public java.lang.String getPtr () {
		return ptr;
	}

	/**
	 * Set the value related to the column: ptr
	 * @param ptr the ptr value
	 */
	public void setPtr (java.lang.String ptr) {
		this.ptr = ptr;
	}



	/**
	 * Return the value associated with the column: ryle_tube
	 */
	public java.lang.String getRyleTube () {
		return ryleTube;
	}

	/**
	 * Set the value related to the column: ryle_tube
	 * @param ryleTube the ryle_tube value
	 */
	public void setRyleTube (java.lang.String ryleTube) {
		this.ryleTube = ryleTube;
	}



	/**
	 * Return the value associated with the column: total_intake
	 */
	public java.lang.String getTotalIntake () {
		return totalIntake;
	}

	/**
	 * Set the value related to the column: total_intake
	 * @param totalIntake the total_intake value
	 */
	public void setTotalIntake (java.lang.String totalIntake) {
		this.totalIntake = totalIntake;
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
	 * Return the value associated with the column: intakeoutput_id
	 */
	public jkt.hms.masters.business.IpdIntakeOutputChart getIntakeoutput () {
		return intakeoutput;
	}

	/**
	 * Set the value related to the column: intakeoutput_id
	 * @param intakeoutput the intakeoutput_id value
	 */
	public void setIntakeoutput (jkt.hms.masters.business.IpdIntakeOutputChart intakeoutput) {
		this.intakeoutput = intakeoutput;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdIntake)) return false;
		else {
			jkt.hms.masters.business.IpdIntake ipdIntake = (jkt.hms.masters.business.IpdIntake) obj;
			if (null == this.getId() || null == ipdIntake.getId()) return false;
			else return (this.getId().equals(ipdIntake.getId()));
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