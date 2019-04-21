package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_shift_codes table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_shift_codes"
 */

public abstract class BaseHrMasShiftCodes  implements Serializable {

	public static String REF = "HrMasShiftCodes";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SHIFT_CODE = "ShiftCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SHIFT_NAME = "ShiftName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrMasShiftCodes () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasShiftCodes (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String shiftCode;
	private java.lang.String shiftName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hrms.masters.business.HrMasShift> hrMasShifts;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="shift_codes_id"
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
	 * Return the value associated with the column: shift_code
	 */
	public java.lang.String getShiftCode () {
		return shiftCode;
	}

	/**
	 * Set the value related to the column: shift_code
	 * @param shiftCode the shift_code value
	 */
	public void setShiftCode (java.lang.String shiftCode) {
		this.shiftCode = shiftCode;
	}



	/**
	 * Return the value associated with the column: shift_name
	 */
	public java.lang.String getShiftName () {
		return shiftName;
	}

	/**
	 * Set the value related to the column: shift_name
	 * @param shiftName the shift_name value
	 */
	public void setShiftName (java.lang.String shiftName) {
		this.shiftName = shiftName;
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
	 * Return the value associated with the column: HrMasShifts
	 */
	public java.util.Set<jkt.hrms.masters.business.HrMasShift> getHrMasShifts () {
		return hrMasShifts;
	}

	/**
	 * Set the value related to the column: HrMasShifts
	 * @param hrMasShifts the HrMasShifts value
	 */
	public void setHrMasShifts (java.util.Set<jkt.hrms.masters.business.HrMasShift> hrMasShifts) {
		this.hrMasShifts = hrMasShifts;
	}

	public void addToHrMasShifts (jkt.hrms.masters.business.HrMasShift hrMasShift) {
		if (null == getHrMasShifts()) setHrMasShifts(new java.util.TreeSet<jkt.hrms.masters.business.HrMasShift>());
		getHrMasShifts().add(hrMasShift);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrMasShiftCodes)) return false;
		else {
			jkt.hrms.masters.business.HrMasShiftCodes hrMasShiftCodes = (jkt.hrms.masters.business.HrMasShiftCodes) obj;
			if (null == this.getId() || null == hrMasShiftCodes.getId()) return false;
			else return (this.getId().equals(hrMasShiftCodes.getId()));
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