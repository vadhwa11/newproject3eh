package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_mas_panchayat table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_mas_panchayat"
 */

public abstract class BasePhMasPanchayat  implements Serializable {

	public static String REF = "PhMasPanchayat";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PANCHAYAT_CODE = "PanchayatCode";
	public static String PROP_ID = "Id";
	public static String PROP_ASSEMBLY = "Assembly";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PANCHAYAT_NAME = "PanchayatName";


	// constructors
	public BasePhMasPanchayat () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhMasPanchayat (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String panchayatCode;
	private java.lang.String panchayatName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.PhMasParliyamentAssembly assembly;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveies;
	private java.util.Set<jkt.hms.masters.business.PhHouseSurvey> phHouseSurveies;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="panchayat_id"
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
	 * Return the value associated with the column: panchayat_code
	 */
	public java.lang.String getPanchayatCode () {
		return panchayatCode;
	}

	/**
	 * Set the value related to the column: panchayat_code
	 * @param panchayatCode the panchayat_code value
	 */
	public void setPanchayatCode (java.lang.String panchayatCode) {
		this.panchayatCode = panchayatCode;
	}



	/**
	 * Return the value associated with the column: panchayat_name
	 */
	public java.lang.String getPanchayatName () {
		return panchayatName;
	}

	/**
	 * Set the value related to the column: panchayat_name
	 * @param panchayatName the panchayat_name value
	 */
	public void setPanchayatName (java.lang.String panchayatName) {
		this.panchayatName = panchayatName;
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
	 * Return the value associated with the column: assembly_id
	 */
	public jkt.hms.masters.business.PhMasParliyamentAssembly getAssembly () {
		return assembly;
	}

	/**
	 * Set the value related to the column: assembly_id
	 * @param assembly the assembly_id value
	 */
	public void setAssembly (jkt.hms.masters.business.PhMasParliyamentAssembly assembly) {
		this.assembly = assembly;
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
		if (!(obj instanceof jkt.hms.masters.business.PhMasPanchayat)) return false;
		else {
			jkt.hms.masters.business.PhMasPanchayat phMasPanchayat = (jkt.hms.masters.business.PhMasPanchayat) obj;
			if (null == this.getId() || null == phMasPanchayat.getId()) return false;
			else return (this.getId().equals(phMasPanchayat.getId()));
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