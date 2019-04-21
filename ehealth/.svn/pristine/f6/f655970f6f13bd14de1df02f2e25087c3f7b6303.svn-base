package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_day_block_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_day_block_detail"
 */

public abstract class BasePhDayBlockDetail  implements Serializable {

	public static String REF = "PhDayBlockDetail";
	public static String PROP_SURVEY = "Survey";
	public static String PROP_LOCALITY = "Locality";
	public static String PROP_WARD = "Ward";
	public static String PROP_ID = "Id";
	public static String PROP_DAY = "Day";


	// constructors
	public BasePhDayBlockDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhDayBlockDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.PhDayBlock day;
	private jkt.hms.masters.business.MasWard ward;
	private jkt.hms.masters.business.PhHouseSurvey survey;
	private jkt.hms.masters.business.PhMasLocality locality;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="day_detail_id"
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
	 * Return the value associated with the column: day_id
	 */
	public jkt.hms.masters.business.PhDayBlock getDay () {
		return day;
	}

	/**
	 * Set the value related to the column: day_id
	 * @param day the day_id value
	 */
	public void setDay (jkt.hms.masters.business.PhDayBlock day) {
		this.day = day;
	}



	/**
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasWard getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasWard ward) {
		this.ward = ward;
	}



	/**
	 * Return the value associated with the column: survey_id
	 */
	public jkt.hms.masters.business.PhHouseSurvey getSurvey () {
		return survey;
	}

	/**
	 * Set the value related to the column: survey_id
	 * @param survey the survey_id value
	 */
	public void setSurvey (jkt.hms.masters.business.PhHouseSurvey survey) {
		this.survey = survey;
	}



	/**
	 * Return the value associated with the column: locality_id
	 */
	public jkt.hms.masters.business.PhMasLocality getLocality () {
		return locality;
	}

	/**
	 * Set the value related to the column: locality_id
	 * @param locality the locality_id value
	 */
	public void setLocality (jkt.hms.masters.business.PhMasLocality locality) {
		this.locality = locality;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhDayBlockDetail)) return false;
		else {
			jkt.hms.masters.business.PhDayBlockDetail phDayBlockDetail = (jkt.hms.masters.business.PhDayBlockDetail) obj;
			if (null == this.getId() || null == phDayBlockDetail.getId()) return false;
			else return (this.getId().equals(phDayBlockDetail.getId()));
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