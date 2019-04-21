package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hospital_doctor_unit_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hospital_doctor_unit_m"
 */

public abstract class BaseHospitalDoctorUnitM  implements Serializable {

	public static String REF = "HospitalDoctorUnitM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_UNIT_CODE = "UnitCode";
	public static String PROP_EMP_DEPT = "EmpDept";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	
	public static String PROP_MONDAY = "Monday";
	public static String PROP_TUESDAY = "Tuesday";
	public static String PROP_WEDNESDAY = "Wednesday";
	public static String PROP_THURSDAY = "Thursday";
	public static String PROP_FRIDAY = "Friday";
	public static String PROP_SATURDAY = "Saturday";
	public static String PROP_SUNDAY = "Sunday";


	// constructors
	public BaseHospitalDoctorUnitM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHospitalDoctorUnitM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String unitCode;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployeeDepartment empDept;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.HospitalDoctorUnitT> hospitalDoctorUnitTs;
	private java.util.Set<jkt.hms.masters.business.OtMasUnitDay> otMasUnitDaies;
	private java.util.Set<jkt.hms.masters.business.OtBooking> otBookings;
	
	private java.lang.String monday;
	public java.lang.String getMonday() {
		return monday;
	}

	public void setMonday(java.lang.String monday) {
		this.monday = monday;
	}

	public java.lang.String getTuesday() {
		return tuesday;
	}

	public void setTuesday(java.lang.String tuesday) {
		this.tuesday = tuesday;
	}

	public java.lang.String getWednesday() {
		return wednesday;
	}

	public void setWednesday(java.lang.String wednesday) {
		this.wednesday = wednesday;
	}

	public java.lang.String getThursday() {
		return thursday;
	}

	public void setThursday(java.lang.String thursday) {
		this.thursday = thursday;
	}

	public java.lang.String getFriday() {
		return friday;
	}

	public void setFriday(java.lang.String friday) {
		this.friday = friday;
	}

	public java.lang.String getSaturday() {
		return saturday;
	}

	public void setSaturday(java.lang.String saturday) {
		this.saturday = saturday;
	}

	public java.lang.String getSunday() {
		return sunday;
	}

	public void setSunday(java.lang.String sunday) {
		this.sunday = sunday;
	}



	private java.lang.String tuesday;
	private java.lang.String wednesday;
	private java.lang.String thursday;
	private java.lang.String friday;
	private java.lang.String saturday;
	private java.lang.String sunday;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="unit_m_id"
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
	 * Return the value associated with the column: unit_code
	 */
	public java.lang.String getUnitCode () {
		return unitCode;
	}

	/**
	 * Set the value related to the column: unit_code
	 * @param unitCode the unit_code value
	 */
	public void setUnitCode (java.lang.String unitCode) {
		this.unitCode = unitCode;
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
	 * Return the value associated with the column: emp_dept_id
	 */
	public jkt.hms.masters.business.MasEmployeeDepartment getEmpDept () {
		return empDept;
	}

	/**
	 * Set the value related to the column: emp_dept_id
	 * @param empDept the emp_dept_id value
	 */
	public void setEmpDept (jkt.hms.masters.business.MasEmployeeDepartment empDept) {
		this.empDept = empDept;
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
	 * Return the value associated with the column: HospitalDoctorUnitTs
	 */
	public java.util.Set<jkt.hms.masters.business.HospitalDoctorUnitT> getHospitalDoctorUnitTs () {
		return hospitalDoctorUnitTs;
	}

	/**
	 * Set the value related to the column: HospitalDoctorUnitTs
	 * @param hospitalDoctorUnitTs the HospitalDoctorUnitTs value
	 */
	public void setHospitalDoctorUnitTs (java.util.Set<jkt.hms.masters.business.HospitalDoctorUnitT> hospitalDoctorUnitTs) {
		this.hospitalDoctorUnitTs = hospitalDoctorUnitTs;
	}

	public void addToHospitalDoctorUnitTs (jkt.hms.masters.business.HospitalDoctorUnitT hospitalDoctorUnitT) {
		if (null == getHospitalDoctorUnitTs()) setHospitalDoctorUnitTs(new java.util.TreeSet<jkt.hms.masters.business.HospitalDoctorUnitT>());
		getHospitalDoctorUnitTs().add(hospitalDoctorUnitT);
	}



	/**
	 * Return the value associated with the column: OtMasUnitDaies
	 */
	public java.util.Set<jkt.hms.masters.business.OtMasUnitDay> getOtMasUnitDaies () {
		return otMasUnitDaies;
	}

	/**
	 * Set the value related to the column: OtMasUnitDaies
	 * @param otMasUnitDaies the OtMasUnitDaies value
	 */
	public void setOtMasUnitDaies (java.util.Set<jkt.hms.masters.business.OtMasUnitDay> otMasUnitDaies) {
		this.otMasUnitDaies = otMasUnitDaies;
	}

	public void addToOtMasUnitDaies (jkt.hms.masters.business.OtMasUnitDay otMasUnitDay) {
		if (null == getOtMasUnitDaies()) setOtMasUnitDaies(new java.util.TreeSet<jkt.hms.masters.business.OtMasUnitDay>());
		getOtMasUnitDaies().add(otMasUnitDay);
	}



	/**
	 * Return the value associated with the column: OtBookings
	 */
	public java.util.Set<jkt.hms.masters.business.OtBooking> getOtBookings () {
		return otBookings;
	}

	/**
	 * Set the value related to the column: OtBookings
	 * @param otBookings the OtBookings value
	 */
	public void setOtBookings (java.util.Set<jkt.hms.masters.business.OtBooking> otBookings) {
		this.otBookings = otBookings;
	}

	public void addToOtBookings (jkt.hms.masters.business.OtBooking otBooking) {
		if (null == getOtBookings()) setOtBookings(new java.util.TreeSet<jkt.hms.masters.business.OtBooking>());
		getOtBookings().add(otBooking);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HospitalDoctorUnitM)) return false;
		else {
			jkt.hms.masters.business.HospitalDoctorUnitM hospitalDoctorUnitM = (jkt.hms.masters.business.HospitalDoctorUnitM) obj;
			if (null == this.getId() || null == hospitalDoctorUnitM.getId()) return false;
			else return (this.getId().equals(hospitalDoctorUnitM.getId()));
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