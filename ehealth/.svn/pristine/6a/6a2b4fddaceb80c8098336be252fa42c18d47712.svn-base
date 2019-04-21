package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_mas_unit_day table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_mas_unit_day"
 */

public abstract class BaseOtMasUnitDay  implements Serializable {

	public static String REF = "OtMasUnitDay";
	public static String PROP_STATUS = "Status";
	public static String PROP_UNIT_M = "UnitM";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MAS_BED = "MasBed";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_DAY_NAME = "DayName";


	// constructors
	public BaseOtMasUnitDay () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtMasUnitDay (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOtMasUnitDay (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.HospitalDoctorUnitM unitM,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String status,
		java.lang.String dayName) {

		this.setId(id);
		this.setHospital(hospital);
		this.setUnitM(unitM);
		this.setDepartment(department);
		this.setStatus(status);
		this.setDayName(dayName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.lang.String dayName;

	// many to one
	private jkt.hms.masters.business.MasBed masBed;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.HospitalDoctorUnitM unitM;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="unit_day_id"
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
	 * Return the value associated with the column: day_name
	 */
	public java.lang.String getDayName () {
		return dayName;
	}

	/**
	 * Set the value related to the column: day_name
	 * @param dayName the day_name value
	 */
	public void setDayName (java.lang.String dayName) {
		this.dayName = dayName;
	}



	/**
	 * Return the value associated with the column: mas_bed_id
	 */
	public jkt.hms.masters.business.MasBed getMasBed () {
		return masBed;
	}

	/**
	 * Set the value related to the column: mas_bed_id
	 * @param masBed the mas_bed_id value
	 */
	public void setMasBed (jkt.hms.masters.business.MasBed masBed) {
		this.masBed = masBed;
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
	 * Return the value associated with the column: unit_m_id
	 */
	public jkt.hms.masters.business.HospitalDoctorUnitM getUnitM () {
		return unitM;
	}

	/**
	 * Set the value related to the column: unit_m_id
	 * @param unitM the unit_m_id value
	 */
	public void setUnitM (jkt.hms.masters.business.HospitalDoctorUnitM unitM) {
		this.unitM = unitM;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtMasUnitDay)) return false;
		else {
			jkt.hms.masters.business.OtMasUnitDay otMasUnitDay = (jkt.hms.masters.business.OtMasUnitDay) obj;
			if (null == this.getId() || null == otMasUnitDay.getId()) return false;
			else return (this.getId().equals(otMasUnitDay.getId()));
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