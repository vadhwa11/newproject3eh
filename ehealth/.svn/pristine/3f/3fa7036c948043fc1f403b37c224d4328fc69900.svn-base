package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_sign_out table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_sign_out"
 */

public abstract class BaseOtSignOut  implements Serializable {

	public static String REF = "OtSignOut";
	public static String PROP_OT_BOOKING = "OtBooking";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_KEY_CONCERN_FOR_RECOVERY = "KeyConcernForRecovery";
	public static String PROP_ID = "Id";
	public static String PROP_SPECIMEN_IDENTIFIED = "SpecimenIdentified";
	public static String PROP_NAME_OF_OPERATIVE_PROCEDURE = "NameOfOperativeProcedure";
	public static String PROP_SPONGE_NEEDLE_CHECKED = "SpongeNeedleChecked";
	public static String PROP_HIN = "Hin";
	public static String PROP_ANY_EQUIP_PROBLEM = "AnyEquipProblem";


	// constructors
	public BaseOtSignOut () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtSignOut (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String nameOfOperativeProcedure;
	private java.lang.String specimenIdentified;
	private java.lang.String anyEquipProblem;
	private java.lang.String keyConcernForRecovery;
	private java.util.Date lastChgDate;
	private java.lang.String spongeNeedleChecked;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OtBooking otBooking;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ot_sign_out_id"
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
	 * Return the value associated with the column: name_of_operative_procedure
	 */
	public java.lang.String getNameOfOperativeProcedure () {
		return nameOfOperativeProcedure;
	}

	/**
	 * Set the value related to the column: name_of_operative_procedure
	 * @param nameOfOperativeProcedure the name_of_operative_procedure value
	 */
	public void setNameOfOperativeProcedure (java.lang.String nameOfOperativeProcedure) {
		this.nameOfOperativeProcedure = nameOfOperativeProcedure;
	}



	/**
	 * Return the value associated with the column: specimen_identified
	 */
	public java.lang.String getSpecimenIdentified () {
		return specimenIdentified;
	}

	/**
	 * Set the value related to the column: specimen_identified
	 * @param specimenIdentified the specimen_identified value
	 */
	public void setSpecimenIdentified (java.lang.String specimenIdentified) {
		this.specimenIdentified = specimenIdentified;
	}



	/**
	 * Return the value associated with the column: any_equip_problem
	 */
	public java.lang.String getAnyEquipProblem () {
		return anyEquipProblem;
	}

	/**
	 * Set the value related to the column: any_equip_problem
	 * @param anyEquipProblem the any_equip_problem value
	 */
	public void setAnyEquipProblem (java.lang.String anyEquipProblem) {
		this.anyEquipProblem = anyEquipProblem;
	}



	/**
	 * Return the value associated with the column: key_concern_for_recovery
	 */
	public java.lang.String getKeyConcernForRecovery () {
		return keyConcernForRecovery;
	}

	/**
	 * Set the value related to the column: key_concern_for_recovery
	 * @param keyConcernForRecovery the key_concern_for_recovery value
	 */
	public void setKeyConcernForRecovery (java.lang.String keyConcernForRecovery) {
		this.keyConcernForRecovery = keyConcernForRecovery;
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
	 * Return the value associated with the column: sponge_needle_checked
	 */
	public java.lang.String getSpongeNeedleChecked () {
		return spongeNeedleChecked;
	}

	/**
	 * Set the value related to the column: sponge_needle_checked
	 * @param spongeNeedleChecked the sponge_needle_checked value
	 */
	public void setSpongeNeedleChecked (java.lang.String spongeNeedleChecked) {
		this.spongeNeedleChecked = spongeNeedleChecked;
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
	 * Return the value associated with the column: ot_booking_id
	 */
	public jkt.hms.masters.business.OtBooking getOtBooking () {
		return otBooking;
	}

	/**
	 * Set the value related to the column: ot_booking_id
	 * @param otBooking the ot_booking_id value
	 */
	public void setOtBooking (jkt.hms.masters.business.OtBooking otBooking) {
		this.otBooking = otBooking;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtSignOut)) return false;
		else {
			jkt.hms.masters.business.OtSignOut otSignOut = (jkt.hms.masters.business.OtSignOut) obj;
			if (null == this.getId() || null == otSignOut.getId()) return false;
			else return (this.getId().equals(otSignOut.getId()));
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