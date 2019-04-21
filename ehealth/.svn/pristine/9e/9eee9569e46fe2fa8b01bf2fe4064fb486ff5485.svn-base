package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_mas_electrical_section table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_mas_electrical_section"
 */

public abstract class BasePhMasElectricalSection  implements Serializable {

	public static String REF = "PhMasElectricalSection";
	public static String PROP_ELECTRICAL_SECTION_CODE = "ElectricalSectionCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ELECTRICAL_SECTION_NAME = "ElectricalSectionName";


	// constructors
	public BasePhMasElectricalSection () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhMasElectricalSection (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String electricalSectionCode;
	private java.lang.String electricalSectionName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasVillage village;
	private jkt.hms.masters.business.MasDistrict district;

	public jkt.hms.masters.business.MasDistrict getDistrict() {
		return district;
	}

	public void setDistrict(jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}



	// collections
	private java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveies;
	private java.util.Set<jkt.hms.masters.business.PhHouseSurvey> phHouseSurveies;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="electrical_section_id"
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
	 * Return the value associated with the column: electrical_section_code
	 */
	public java.lang.String getElectricalSectionCode () {
		return electricalSectionCode;
	}

	/**
	 * Set the value related to the column: electrical_section_code
	 * @param electricalSectionCode the electrical_section_code value
	 */
	public void setElectricalSectionCode (java.lang.String electricalSectionCode) {
		this.electricalSectionCode = electricalSectionCode;
	}



	/**
	 * Return the value associated with the column: electrical_section_name
	 */
	public java.lang.String getElectricalSectionName () {
		return electricalSectionName;
	}

	/**
	 * Set the value related to the column: electrical_section_name
	 * @param electricalSectionName the electrical_section_name value
	 */
	public void setElectricalSectionName (java.lang.String electricalSectionName) {
		this.electricalSectionName = electricalSectionName;
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
	 * Return the value associated with the column: village_id
	 */
	public jkt.hms.masters.business.MasVillage getVillage () {
		return village;
	}

	/**
	 * Set the value related to the column: village_id
	 * @param village the village_id value
	 */
	public void setVillage (jkt.hms.masters.business.MasVillage village) {
		this.village = village;
	}



	/**
	 * Return the value associated with the column: PhVillageSurveies
	 */
	public java.util.Set<jkt.hms.masters.business.PhVillageSurvey> getPhVillageSurveies () {
		return phVillageSurveies;
	}

	/**
	 * Set the value related to the column: PhVillageSurveies
	 * @param phVillageSurveies the PhVillageSurveies value
	 */
	public void setPhVillageSurveies (java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveies) {
		this.phVillageSurveies = phVillageSurveies;
	}

	public void addToPhVillageSurveies (jkt.hms.masters.business.PhVillageSurvey phVillageSurvey) {
		if (null == getPhVillageSurveies()) setPhVillageSurveies(new java.util.TreeSet<jkt.hms.masters.business.PhVillageSurvey>());
		getPhVillageSurveies().add(phVillageSurvey);
	}



	/**
	 * Return the value associated with the column: PhHouseSurveies
	 */
	public java.util.Set<jkt.hms.masters.business.PhHouseSurvey> getPhHouseSurveies () {
		return phHouseSurveies;
	}

	/**
	 * Set the value related to the column: PhHouseSurveies
	 * @param phHouseSurveies the PhHouseSurveies value
	 */
	public void setPhHouseSurveies (java.util.Set<jkt.hms.masters.business.PhHouseSurvey> phHouseSurveies) {
		this.phHouseSurveies = phHouseSurveies;
	}

	public void addToPhHouseSurveies (jkt.hms.masters.business.PhHouseSurvey phHouseSurvey) {
		if (null == getPhHouseSurveies()) setPhHouseSurveies(new java.util.TreeSet<jkt.hms.masters.business.PhHouseSurvey>());
		getPhHouseSurveies().add(phHouseSurvey);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhMasElectricalSection)) return false;
		else {
			jkt.hms.masters.business.PhMasElectricalSection phMasElectricalSection = (jkt.hms.masters.business.PhMasElectricalSection) obj;
			if (null == this.getId() || null == phMasElectricalSection.getId()) return false;
			else return (this.getId().equals(phMasElectricalSection.getId()));
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