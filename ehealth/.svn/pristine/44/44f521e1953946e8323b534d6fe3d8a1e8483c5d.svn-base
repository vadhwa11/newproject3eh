package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the inj_appointment_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="inj_appointment_header"
 */

public abstract class BaseInjAppointmentHeader  implements Serializable {

	public static String REF = "InjAppointmentHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_NEXT_APPOINTMENT_DATE = "NextAppointmentDate";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRESCRIPTION = "Prescription";
	public static String PROP_ID = "Id";
	public static String PROP_NEW_VISIT = "NewVisit";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT_PRESCRIPTION_HEADER = "InpatientPrescriptionHeader";
	public static String PROP_INPATIENT = "Inpatient";

	// constructors
	public BaseInjAppointmentHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInjAppointmentHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseInjAppointmentHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.Visit visit,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.InpatientPrescriptionHeader inpatientPrescriptionHeader,
		jkt.hms.masters.business.Inpatient inpatient) {

		this.setId(id);
		this.setVisit(visit);
		this.setHin(hin);
		this.setInpatientPrescriptionHeader(inpatientPrescriptionHeader);
		this.setInpatient(inpatient);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date appointmentDate;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date nextAppointmentDate;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.PatientPrescriptionHeader prescription;
	private jkt.hms.masters.business.Visit newVisit;

	// collections
	private java.util.Set<jkt.hms.masters.business.InjAppointmentDetails> injAppointmentDetails;
	
	private jkt.hms.masters.business.InpatientPrescriptionHeader InpatientPrescriptionHeader;
	private jkt.hms.masters.business.Inpatient inpatient;

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="inj_appointment_header_id"
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
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * @param appointmentDate the appointment_date value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
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
	 * Return the value associated with the column: next_appointment_date
	 */
	public java.util.Date getNextAppointmentDate () {
		return nextAppointmentDate;
	}

	/**
	 * Set the value related to the column: next_appointment_date
	 * @param nextAppointmentDate the next_appointment_date value
	 */
	public void setNextAppointmentDate (java.util.Date nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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
	 * Return the value associated with the column: prescription_id
	 */
	public jkt.hms.masters.business.PatientPrescriptionHeader getPrescription () {
		return prescription;
	}

	/**
	 * Set the value related to the column: prescription_id
	 * @param prescription the prescription_id value
	 */
	public void setPrescription (jkt.hms.masters.business.PatientPrescriptionHeader prescription) {
		this.prescription = prescription;
	}



	/**
	 * Return the value associated with the column: new_visit_id
	 */
	public jkt.hms.masters.business.Visit getNewVisit () {
		return newVisit;
	}

	/**
	 * Set the value related to the column: new_visit_id
	 * @param newVisit the new_visit_id value
	 */
	public void setNewVisit (jkt.hms.masters.business.Visit newVisit) {
		this.newVisit = newVisit;
	}



	/**
	 * Return the value associated with the column: InjAppointmentDetails
	 */
	public java.util.Set<jkt.hms.masters.business.InjAppointmentDetails> getInjAppointmentDetails () {
		return injAppointmentDetails;
	}

	/**
	 * Set the value related to the column: InjAppointmentDetails
	 * @param injAppointmentDetails the InjAppointmentDetails value
	 */
	public void setInjAppointmentDetails (java.util.Set<jkt.hms.masters.business.InjAppointmentDetails> injAppointmentDetails) {
		this.injAppointmentDetails = injAppointmentDetails;
	}

	public void addToInjAppointmentDetails (jkt.hms.masters.business.InjAppointmentDetails injAppointmentDetails) {
		if (null == getInjAppointmentDetails()) setInjAppointmentDetails(new java.util.TreeSet<jkt.hms.masters.business.InjAppointmentDetails>());
		getInjAppointmentDetails().add(injAppointmentDetails);
	}

	public jkt.hms.masters.business.InpatientPrescriptionHeader getInpatientPrescriptionHeader() {
		return InpatientPrescriptionHeader;
	}

	public void setInpatientPrescriptionHeader(
			jkt.hms.masters.business.InpatientPrescriptionHeader inpatientPrescriptionHeader) {
		InpatientPrescriptionHeader = inpatientPrescriptionHeader;
	}

	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.InjAppointmentHeader)) return false;
		else {
			jkt.hms.masters.business.InjAppointmentHeader injAppointmentHeader = (jkt.hms.masters.business.InjAppointmentHeader) obj;
			if (null == this.getId() || null == injAppointmentHeader.getId()) return false;
			else return (this.getId().equals(injAppointmentHeader.getId()));
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