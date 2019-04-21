package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_medicine_cardiovascular_system table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_medicine_cardiovascular_system"
 */

public abstract class BaseOpdMedicineCardiovascularSystem  implements Serializable {

	public static String REF = "OpdMedicineCardiovascularSystem";
	public static String PROP_SITE = "Site";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_PALPITATION_OF_PERIPHERAL_VESSEL = "PalpitationOfPeripheralVessel";
	public static String PROP_VOLUME = "Volume";
	public static String PROP_CS_CHARACTER = "CsCharacter";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_RHYTHM = "Rhythm";
	public static String PROP_RATE = "Rate";
	public static String PROP_RADIO_FEMORAL_DELAY = "RadioFemoralDelay";
	public static String PROP_CONDITION_OF_THE_VESSEL_WELL = "ConditionOfTheVesselWell";


	// constructors
	public BaseOpdMedicineCardiovascularSystem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdMedicineCardiovascularSystem (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String site;
	private java.lang.String rate;
	private java.lang.String rhythm;
	private java.lang.String volume;
	private java.lang.String csCharacter;
	private java.lang.String conditionOfTheVesselWell;
	private java.lang.String radioFemoralDelay;
	private java.lang.String palpitationOfPeripheralVessel;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="medicine_cardiovascular_system_id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: site
	 */
	public java.lang.String getSite () {
		return site;
	}

	/**
	 * Set the value related to the column: site
	 * @param site the site value
	 */
	public void setSite (java.lang.String site) {
		this.site = site;
	}



	/**
	 * Return the value associated with the column: rate
	 */
	public java.lang.String getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param rate the rate value
	 */
	public void setRate (java.lang.String rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: rhythm
	 */
	public java.lang.String getRhythm () {
		return rhythm;
	}

	/**
	 * Set the value related to the column: rhythm
	 * @param rhythm the rhythm value
	 */
	public void setRhythm (java.lang.String rhythm) {
		this.rhythm = rhythm;
	}



	/**
	 * Return the value associated with the column: volume
	 */
	public java.lang.String getVolume () {
		return volume;
	}

	/**
	 * Set the value related to the column: volume
	 * @param volume the volume value
	 */
	public void setVolume (java.lang.String volume) {
		this.volume = volume;
	}



	/**
	 * Return the value associated with the column: cs_character
	 */
	public java.lang.String getCsCharacter () {
		return csCharacter;
	}

	/**
	 * Set the value related to the column: cs_character
	 * @param csCharacter the cs_character value
	 */
	public void setCsCharacter (java.lang.String csCharacter) {
		this.csCharacter = csCharacter;
	}



	/**
	 * Return the value associated with the column: condition_of_the_vessel_well
	 */
	public java.lang.String getConditionOfTheVesselWell () {
		return conditionOfTheVesselWell;
	}

	/**
	 * Set the value related to the column: condition_of_the_vessel_well
	 * @param conditionOfTheVesselWell the condition_of_the_vessel_well value
	 */
	public void setConditionOfTheVesselWell (java.lang.String conditionOfTheVesselWell) {
		this.conditionOfTheVesselWell = conditionOfTheVesselWell;
	}



	/**
	 * Return the value associated with the column: radio_femoral_delay
	 */
	public java.lang.String getRadioFemoralDelay () {
		return radioFemoralDelay;
	}

	/**
	 * Set the value related to the column: radio_femoral_delay
	 * @param radioFemoralDelay the radio_femoral_delay value
	 */
	public void setRadioFemoralDelay (java.lang.String radioFemoralDelay) {
		this.radioFemoralDelay = radioFemoralDelay;
	}



	/**
	 * Return the value associated with the column: palpitation_of_peripheral_vessel
	 */
	public java.lang.String getPalpitationOfPeripheralVessel () {
		return palpitationOfPeripheralVessel;
	}

	/**
	 * Set the value related to the column: palpitation_of_peripheral_vessel
	 * @param palpitationOfPeripheralVessel the palpitation_of_peripheral_vessel value
	 */
	public void setPalpitationOfPeripheralVessel (java.lang.String palpitationOfPeripheralVessel) {
		this.palpitationOfPeripheralVessel = palpitationOfPeripheralVessel;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdMedicineCardiovascularSystem)) return false;
		else {
			jkt.hms.masters.business.OpdMedicineCardiovascularSystem opdMedicineCardiovascularSystem = (jkt.hms.masters.business.OpdMedicineCardiovascularSystem) obj;
			if (null == this.getId() || null == opdMedicineCardiovascularSystem.getId()) return false;
			else return (this.getId().equals(opdMedicineCardiovascularSystem.getId()));
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