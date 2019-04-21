package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_general_surgery_past_speciality table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_general_surgery_past_speciality"
 */

public abstract class BaseOpdGeneralSurgeryPastSpeciality  implements Serializable {

	public static String REF = "OpdGeneralSurgeryPastSpeciality";
	public static String PROP_RELATION = "Relation";
	public static String PROP_DISEASE = "Disease";
	public static String PROP_OTHERS = "Others";
	public static String PROP_FLAG_SPECIALITY = "FlagSpeciality";
	public static String PROP_NUMBER_OF_EPISODES = "NumberOfEpisodes";
	public static String PROP_DETAILS_ONE = "DetailsOne";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_DETAILS_TWO = "DetailsTwo";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_OTHERS_ANOTHER = "OthersAnother";
	public static String PROP_DRUGS = "Drugs";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOpdGeneralSurgeryPastSpeciality () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGeneralSurgeryPastSpeciality (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String flagSpeciality;
	private java.lang.String disease;
	private java.lang.String numberOfEpisodes;
	private java.lang.String detailsOne;
	private java.lang.String detailsTwo;
	private java.lang.String othersAnother;
	private java.lang.String drugs;
	private java.lang.String others;
	private java.lang.String duration;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.MasRelation relation;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="general_surgery_past_id"
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
	 * Return the value associated with the column: flag_speciality
	 */
	public java.lang.String getFlagSpeciality () {
		return flagSpeciality;
	}

	/**
	 * Set the value related to the column: flag_speciality
	 * @param flagSpeciality the flag_speciality value
	 */
	public void setFlagSpeciality (java.lang.String flagSpeciality) {
		this.flagSpeciality = flagSpeciality;
	}



	/**
	 * Return the value associated with the column: disease
	 */
	public java.lang.String getDisease () {
		return disease;
	}

	/**
	 * Set the value related to the column: disease
	 * @param disease the disease value
	 */
	public void setDisease (java.lang.String disease) {
		this.disease = disease;
	}



	/**
	 * Return the value associated with the column: number_of_episodes
	 */
	public java.lang.String getNumberOfEpisodes () {
		return numberOfEpisodes;
	}

	/**
	 * Set the value related to the column: number_of_episodes
	 * @param numberOfEpisodes the number_of_episodes value
	 */
	public void setNumberOfEpisodes (java.lang.String numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}



	/**
	 * Return the value associated with the column: details_one
	 */
	public java.lang.String getDetailsOne () {
		return detailsOne;
	}

	/**
	 * Set the value related to the column: details_one
	 * @param detailsOne the details_one value
	 */
	public void setDetailsOne (java.lang.String detailsOne) {
		this.detailsOne = detailsOne;
	}



	/**
	 * Return the value associated with the column: details_two
	 */
	public java.lang.String getDetailsTwo () {
		return detailsTwo;
	}

	/**
	 * Set the value related to the column: details_two
	 * @param detailsTwo the details_two value
	 */
	public void setDetailsTwo (java.lang.String detailsTwo) {
		this.detailsTwo = detailsTwo;
	}



	/**
	 * Return the value associated with the column: others_another
	 */
	public java.lang.String getOthersAnother () {
		return othersAnother;
	}

	/**
	 * Set the value related to the column: others_another
	 * @param othersAnother the others_another value
	 */
	public void setOthersAnother (java.lang.String othersAnother) {
		this.othersAnother = othersAnother;
	}



	/**
	 * Return the value associated with the column: drugs
	 */
	public java.lang.String getDrugs () {
		return drugs;
	}

	/**
	 * Set the value related to the column: drugs
	 * @param drugs the drugs value
	 */
	public void setDrugs (java.lang.String drugs) {
		this.drugs = drugs;
	}



	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.String getOthers () {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * @param others the others value
	 */
	public void setOthers (java.lang.String others) {
		this.others = others;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
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



	/**
	 * Return the value associated with the column: relation
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation
	 * @param relation the relation value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdGeneralSurgeryPastSpeciality)) return false;
		else {
			jkt.hms.masters.business.OpdGeneralSurgeryPastSpeciality opdGeneralSurgeryPastSpeciality = (jkt.hms.masters.business.OpdGeneralSurgeryPastSpeciality) obj;
			if (null == this.getId() || null == opdGeneralSurgeryPastSpeciality.getId()) return false;
			else return (this.getId().equals(opdGeneralSurgeryPastSpeciality.getId()));
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