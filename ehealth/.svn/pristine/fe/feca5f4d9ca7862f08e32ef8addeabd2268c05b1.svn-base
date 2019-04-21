package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_general_surgery_prev_speciality table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_general_surgery_prev_speciality"
 */

public abstract class BaseOpdGeneralSurgeryPrevSpeciality  implements Serializable {

	public static String REF = "OpdGeneralSurgeryPrevSpeciality";
	public static String PROP_TYPE_PREV = "TypePrev";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_DATE_PREV = "DatePrev";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_INSTITUTION = "Institution";
	public static String PROP_HOSPITALIZATION_DURATION = "HospitalizationDuration";


	// constructors
	public BaseOpdGeneralSurgeryPrevSpeciality () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGeneralSurgeryPrevSpeciality (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String typePrev;
	private java.util.Date datePrev;
	private java.lang.String institution;
	private java.lang.String hospitalizationDuration;
	private java.lang.String complications;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="general_surgery_prev_id"
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
	 * Return the value associated with the column: type_prev
	 */
	public java.lang.String getTypePrev () {
		return typePrev;
	}

	/**
	 * Set the value related to the column: type_prev
	 * @param typePrev the type_prev value
	 */
	public void setTypePrev (java.lang.String typePrev) {
		this.typePrev = typePrev;
	}



	/**
	 * Return the value associated with the column: date_prev
	 */
	public java.util.Date getDatePrev () {
		return datePrev;
	}

	/**
	 * Set the value related to the column: date_prev
	 * @param datePrev the date_prev value
	 */
	public void setDatePrev (java.util.Date datePrev) {
		this.datePrev = datePrev;
	}



	/**
	 * Return the value associated with the column: institution
	 */
	public java.lang.String getInstitution () {
		return institution;
	}

	/**
	 * Set the value related to the column: institution
	 * @param institution the institution value
	 */
	public void setInstitution (java.lang.String institution) {
		this.institution = institution;
	}



	/**
	 * Return the value associated with the column: hospitalization_duration
	 */
	public java.lang.String getHospitalizationDuration () {
		return hospitalizationDuration;
	}

	/**
	 * Set the value related to the column: hospitalization_duration
	 * @param hospitalizationDuration the hospitalization_duration value
	 */
	public void setHospitalizationDuration (java.lang.String hospitalizationDuration) {
		this.hospitalizationDuration = hospitalizationDuration;
	}



	/**
	 * Return the value associated with the column: complications
	 */
	public java.lang.String getComplications () {
		return complications;
	}

	/**
	 * Set the value related to the column: complications
	 * @param complications the complications value
	 */
	public void setComplications (java.lang.String complications) {
		this.complications = complications;
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
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdGeneralSurgeryPrevSpeciality)) return false;
		else {
			jkt.hms.masters.business.OpdGeneralSurgeryPrevSpeciality opdGeneralSurgeryPrevSpeciality = (jkt.hms.masters.business.OpdGeneralSurgeryPrevSpeciality) obj;
			if (null == this.getId() || null == opdGeneralSurgeryPrevSpeciality.getId()) return false;
			else return (this.getId().equals(opdGeneralSurgeryPrevSpeciality.getId()));
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