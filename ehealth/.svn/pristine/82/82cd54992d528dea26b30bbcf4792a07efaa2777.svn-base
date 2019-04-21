package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hospital_doctor_unit_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hospital_doctor_unit_t"
 */

public abstract class BaseHospitalDoctorUnitT  implements Serializable {

	public static String REF = "HospitalDoctorUnitT";
	public static String PROP_STATUS = "Status";
	public static String PROP_UNIT_M = "UnitM";
	public static String PROP_ID = "Id";
	public static String PROP_HEAD_FLEG = "HeadFleg";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseHospitalDoctorUnitT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHospitalDoctorUnitT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHospitalDoctorUnitT (
		java.lang.Integer id,
		jkt.hms.masters.business.HospitalDoctorUnitM unitM,
		jkt.hms.masters.business.MasEmployee employee,
		java.lang.String status) {

		this.setId(id);
		this.setUnitM(unitM);
		this.setEmployee(employee);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.lang.String headFleg;

	// many to one
	private jkt.hms.masters.business.HospitalDoctorUnitM unitM;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="unit_t_id"
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
	 * Return the value associated with the column: head_fleg
	 */
	public java.lang.String getHeadFleg () {
		return headFleg;
	}

	/**
	 * Set the value related to the column: head_fleg
	 * @param headFleg the head_fleg value
	 */
	public void setHeadFleg (java.lang.String headFleg) {
		this.headFleg = headFleg;
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HospitalDoctorUnitT)) return false;
		else {
			jkt.hms.masters.business.HospitalDoctorUnitT hospitalDoctorUnitT = (jkt.hms.masters.business.HospitalDoctorUnitT) obj;
			if (null == this.getId() || null == hospitalDoctorUnitT.getId()) return false;
			else return (this.getId().equals(hospitalDoctorUnitT.getId()));
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