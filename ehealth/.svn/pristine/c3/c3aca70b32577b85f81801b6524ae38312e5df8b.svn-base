package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_shift_codes table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_shift_codes"
 */

public abstract class BaseMasShiftCodes implements Serializable {

	public static String REF = "MasShiftCodes";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SHIFT_NAME = "ShiftName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SHIFT_CODE = "ShiftCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasShiftCodes() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasShiftCodes(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String shiftCode;
	private java.lang.String shiftName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hrms.masters.business.MasShift> masShifts;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="shift_codes_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: shift_code
	 */
	public java.lang.String getShiftCode() {
		return shiftCode;
	}

	/**
	 * Set the value related to the column: shift_code
	 * 
	 * @param shiftCode
	 *            the shift_code value
	 */
	public void setShiftCode(java.lang.String shiftCode) {
		this.shiftCode = shiftCode;
	}

	/**
	 * Return the value associated with the column: shift_name
	 */
	public java.lang.String getShiftName() {
		return shiftName;
	}

	/**
	 * Set the value related to the column: shift_name
	 * 
	 * @param shiftName
	 *            the shift_name value
	 */
	public void setShiftName(java.lang.String shiftName) {
		this.shiftName = shiftName;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: MasShifts
	 */
	public java.util.Set<jkt.hrms.masters.business.MasShift> getMasShifts() {
		return masShifts;
	}

	/**
	 * Set the value related to the column: MasShifts
	 * 
	 * @param masShifts
	 *            the MasShifts value
	 */
	public void setMasShifts(
			java.util.Set<jkt.hrms.masters.business.MasShift> masShifts) {
		this.masShifts = masShifts;
	}

	public void addToMasShifts(jkt.hrms.masters.business.MasShift masShift) {
		if (null == getMasShifts()) {
			setMasShifts(new java.util.TreeSet<jkt.hrms.masters.business.MasShift>());
		}
		getMasShifts().add(masShift);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasShiftCodes)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasShiftCodes masShiftCodes = (jkt.hrms.masters.business.MasShiftCodes) obj;
			if (null == this.getId() || null == masShiftCodes.getId()) {
				return false;
			} else {
				return (this.getId().equals(masShiftCodes.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}