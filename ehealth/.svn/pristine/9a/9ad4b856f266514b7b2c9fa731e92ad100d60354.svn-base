package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_reaction_entry_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_reaction_entry_details"
 */

public abstract class BaseBloodReactionEntryDetails  implements Serializable {

	public static String REF = "BloodReactionEntryDetails";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_ENTRY_HEADER = "EntryHeader";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BLOOD_REACTION_NAME = "BloodReactionName";


	// constructors
	public BaseBloodReactionEntryDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodReactionEntryDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bloodReactionName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.BloodReactionEntry entryHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="entry_details_id"
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
	 * Return the value associated with the column: blood_reaction_name
	 */
	public java.lang.String getBloodReactionName () {
		return bloodReactionName;
	}

	/**
	 * Set the value related to the column: blood_reaction_name
	 * @param bloodReactionName the blood_reaction_name value
	 */
	public void setBloodReactionName (java.lang.String bloodReactionName) {
		this.bloodReactionName = bloodReactionName;
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
	 * Return the value associated with the column: entry_header_id
	 */
	public jkt.hms.masters.business.BloodReactionEntry getEntryHeader () {
		return entryHeader;
	}

	/**
	 * Set the value related to the column: entry_header_id
	 * @param entryHeader the entry_header_id value
	 */
	public void setEntryHeader (jkt.hms.masters.business.BloodReactionEntry entryHeader) {
		this.entryHeader = entryHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodReactionEntryDetails)) return false;
		else {
			jkt.hms.masters.business.BloodReactionEntryDetails bloodReactionEntryDetails = (jkt.hms.masters.business.BloodReactionEntryDetails) obj;
			if (null == this.getId() || null == bloodReactionEntryDetails.getId()) return false;
			else return (this.getId().equals(bloodReactionEntryDetails.getId()));
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