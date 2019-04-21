package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ambulance_register table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ambulance_register"
 */

public abstract class BaseAmbulanceRegister  implements Serializable {

	public static String REF = "AmbulanceRegister";
	public static String PROP_DRIVER_CONTACT = "DriverContact";
	public static String PROP_REQUEST_STATUS = "RequestStatus";
	public static String PROP_AMBULANCE = "Ambulance";
	public static String PROP_DISTANCE = "Distance";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ATTENDENTS = "Attendents";
	public static String PROP_DRIVER_NAME = "DriverName";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_AMBULANCE_RUN_TIME = "AmbulanceRunTime";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_TO_DESTINATION = "ToDestination";
	public static String PROP_AMBULANCE_RUN_DATE = "AmbulanceRunDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_FROM_SMC = "FromSmc";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_DOCTOR = "Doctor";


	// constructors
	public BaseAmbulanceRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAmbulanceRegister (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date ambulanceRunDate;
	private java.lang.String ambulanceRunTime;
	private java.lang.String fromSmc;
	private java.lang.String toDestination;
	private java.lang.String patientName;
	private java.lang.String attendents;
	private java.lang.String driverName;
	private java.lang.String driverContact;
	private java.math.BigDecimal charge;
	private java.math.BigDecimal distance;
	private java.lang.String remarks;
	private java.lang.String requestStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String billStatus;
	public java.lang.String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(java.lang.String billStatus) {
		this.billStatus = billStatus;
	}



	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasAmbulance ambulance;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ambulance_register_id"
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
	 * Return the value associated with the column: ambulance_run_date
	 */
	public java.util.Date getAmbulanceRunDate () {
		return ambulanceRunDate;
	}

	/**
	 * Set the value related to the column: ambulance_run_date
	 * @param ambulanceRunDate the ambulance_run_date value
	 */
	public void setAmbulanceRunDate (java.util.Date ambulanceRunDate) {
		this.ambulanceRunDate = ambulanceRunDate;
	}



	/**
	 * Return the value associated with the column: ambulance_run_time
	 */
	public java.lang.String getAmbulanceRunTime () {
		return ambulanceRunTime;
	}

	/**
	 * Set the value related to the column: ambulance_run_time
	 * @param ambulanceRunTime the ambulance_run_time value
	 */
	public void setAmbulanceRunTime (java.lang.String ambulanceRunTime) {
		this.ambulanceRunTime = ambulanceRunTime;
	}



	/**
	 * Return the value associated with the column: from_smc
	 */
	public java.lang.String getFromSmc () {
		return fromSmc;
	}

	/**
	 * Set the value related to the column: from_smc
	 * @param fromSmc the from_smc value
	 */
	public void setFromSmc (java.lang.String fromSmc) {
		this.fromSmc = fromSmc;
	}



	/**
	 * Return the value associated with the column: to_destination
	 */
	public java.lang.String getToDestination () {
		return toDestination;
	}

	/**
	 * Set the value related to the column: to_destination
	 * @param toDestination the to_destination value
	 */
	public void setToDestination (java.lang.String toDestination) {
		this.toDestination = toDestination;
	}



	/**
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * @param patientName the patient_name value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: attendents
	 */
	public java.lang.String getAttendents () {
		return attendents;
	}

	/**
	 * Set the value related to the column: attendents
	 * @param attendents the attendents value
	 */
	public void setAttendents (java.lang.String attendents) {
		this.attendents = attendents;
	}



	/**
	 * Return the value associated with the column: driver_name
	 */
	public java.lang.String getDriverName () {
		return driverName;
	}

	/**
	 * Set the value related to the column: driver_name
	 * @param driverName the driver_name value
	 */
	public void setDriverName (java.lang.String driverName) {
		this.driverName = driverName;
	}



	/**
	 * Return the value associated with the column: driver_contact
	 */
	public java.lang.String getDriverContact () {
		return driverContact;
	}

	/**
	 * Set the value related to the column: driver_contact
	 * @param driverContact the driver_contact value
	 */
	public void setDriverContact (java.lang.String driverContact) {
		this.driverContact = driverContact;
	}



	/**
	 * Return the value associated with the column: charge
	 */
	public java.math.BigDecimal getCharge () {
		return charge;
	}

	/**
	 * Set the value related to the column: charge
	 * @param charge the charge value
	 */
	public void setCharge (java.math.BigDecimal charge) {
		this.charge = charge;
	}



	/**
	 * Return the value associated with the column: distance
	 */
	public java.math.BigDecimal getDistance () {
		return distance;
	}

	/**
	 * Set the value related to the column: distance
	 * @param distance the distance value
	 */
	public void setDistance (java.math.BigDecimal distance) {
		this.distance = distance;
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
	 * Return the value associated with the column: request_status
	 */
	public java.lang.String getRequestStatus () {
		return requestStatus;
	}

	/**
	 * Set the value related to the column: request_status
	 * @param requestStatus the request_status value
	 */
	public void setRequestStatus (java.lang.String requestStatus) {
		this.requestStatus = requestStatus;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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



	/**
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
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
	 * Return the value associated with the column: ambulance_id
	 */
	public jkt.hms.masters.business.MasAmbulance getAmbulance () {
		return ambulance;
	}

	/**
	 * Set the value related to the column: ambulance_id
	 * @param ambulance the ambulance_id value
	 */
	public void setAmbulance (jkt.hms.masters.business.MasAmbulance ambulance) {
		this.ambulance = ambulance;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AmbulanceRegister)) return false;
		else {
			jkt.hms.masters.business.AmbulanceRegister ambulanceRegister = (jkt.hms.masters.business.AmbulanceRegister) obj;
			if (null == this.getId() || null == ambulanceRegister.getId()) return false;
			else return (this.getId().equals(ambulanceRegister.getId()));
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