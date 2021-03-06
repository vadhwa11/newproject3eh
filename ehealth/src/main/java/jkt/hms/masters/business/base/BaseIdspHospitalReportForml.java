package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the idsp_hospital_report_forml table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="idsp_hospital_report_forml"
 */

public abstract class BaseIdspHospitalReportForml  implements Serializable {

	public static String REF = "IdspHospitalReportForml";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_NO_OF_SAMPLES_TESTED = "NoOfSamplesTested";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DISEASES_NAME = "DiseasesName";
	public static String PROP_ID = "Id";


	// constructors
	public BaseIdspHospitalReportForml () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIdspHospitalReportForml (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String diseasesName;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.lang.Integer noOfSamplesTested;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="idsp_hospital_report_forml_id"
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
	 * Return the value associated with the column: diseases_name
	 */
	public java.lang.String getDiseasesName () {
		return diseasesName;
	}

	/**
	 * Set the value related to the column: diseases_name
	 * @param diseasesName the diseases_name value
	 */
	public void setDiseasesName (java.lang.String diseasesName) {
		this.diseasesName = diseasesName;
	}



	/**
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * @param startDate the start_date value
	 */
	public void setStartDate (java.util.Date startDate) {
		this.startDate = startDate;
	}



	/**
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
	}



	/**
	 * Return the value associated with the column: no_of_samples_tested
	 */
	public java.lang.Integer getNoOfSamplesTested () {
		return noOfSamplesTested;
	}

	/**
	 * Set the value related to the column: no_of_samples_tested
	 * @param noOfSamplesTested the no_of_samples_tested value
	 */
	public void setNoOfSamplesTested (java.lang.Integer noOfSamplesTested) {
		this.noOfSamplesTested = noOfSamplesTested;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IdspHospitalReportForml)) return false;
		else {
			jkt.hms.masters.business.IdspHospitalReportForml idspHospitalReportForml = (jkt.hms.masters.business.IdspHospitalReportForml) obj;
			if (null == this.getId() || null == idspHospitalReportForml.getId()) return false;
			else return (this.getId().equals(idspHospitalReportForml.getId()));
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