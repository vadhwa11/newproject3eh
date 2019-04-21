package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_care_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_care_details"
 */

public abstract class BaseIpdCareDetails  implements Serializable {

	public static String REF = "IpdCareDetails";
	public static String PROP_CARE_DATE = "CareDate";
	public static String PROP_CARE_TIME = "CareTime";
	public static String PROP_ID = "Id";
	public static String PROP_CARE_FREQUENCY_COUNT = "CareFrequencyCount";
	public static String PROP_CARE_HEADER = "CareHeader";


	// constructors
	public BaseIpdCareDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdCareDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date careDate;
	private java.lang.String careTime;
	private java.lang.Integer careFrequencyCount;

	// many to one
	private jkt.hms.masters.business.IpdCareHeader careHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="care_details_id"
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
	 * Return the value associated with the column: care_date
	 */
	public java.util.Date getCareDate () {
		return careDate;
	}

	/**
	 * Set the value related to the column: care_date
	 * @param careDate the care_date value
	 */
	public void setCareDate (java.util.Date careDate) {
		this.careDate = careDate;
	}



	/**
	 * Return the value associated with the column: care_time
	 */
	public java.lang.String getCareTime () {
		return careTime;
	}

	/**
	 * Set the value related to the column: care_time
	 * @param careTime the care_time value
	 */
	public void setCareTime (java.lang.String careTime) {
		this.careTime = careTime;
	}



	/**
	 * Return the value associated with the column: care_frequency_count
	 */
	public java.lang.Integer getCareFrequencyCount () {
		return careFrequencyCount;
	}

	/**
	 * Set the value related to the column: care_frequency_count
	 * @param careFrequencyCount the care_frequency_count value
	 */
	public void setCareFrequencyCount (java.lang.Integer careFrequencyCount) {
		this.careFrequencyCount = careFrequencyCount;
	}



	/**
	 * Return the value associated with the column: care_header_id
	 */
	public jkt.hms.masters.business.IpdCareHeader getCareHeader () {
		return careHeader;
	}

	/**
	 * Set the value related to the column: care_header_id
	 * @param careHeader the care_header_id value
	 */
	public void setCareHeader (jkt.hms.masters.business.IpdCareHeader careHeader) {
		this.careHeader = careHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdCareDetails)) return false;
		else {
			jkt.hms.masters.business.IpdCareDetails ipdCareDetails = (jkt.hms.masters.business.IpdCareDetails) obj;
			if (null == this.getId() || null == ipdCareDetails.getId()) return false;
			else return (this.getId().equals(ipdCareDetails.getId()));
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