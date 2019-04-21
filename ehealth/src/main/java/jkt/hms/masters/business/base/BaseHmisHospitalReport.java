package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hmis_hospital_report table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hmis_hospital_report"
 */

public abstract class BaseHmisHospitalReport  implements Serializable {

	public static String REF = "HmisHospitalReport";
	public static String PROP_REPORT_YEAR = "ReportYear";
	public static String PROP_HOSPITAL_MODIFY = "HospitalModify";
	public static String PROP_PARAMETER = "Parameter";
	public static String PROP_REPORT_MONTH = "ReportMonth";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_HOSPITAL_ACTUAL = "HospitalActual";
	public static String PROP_DISTRICT = "District";


	// constructors
	public BaseHmisHospitalReport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHmisHospitalReport (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hospitalActual;
	private java.lang.Integer hospitalModify;
	private java.lang.Integer reportMonth;
	private java.lang.Integer reportYear;

	// many to one
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasPhReportsParameters parameter;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: hospital_actual
	 */
	public java.lang.Integer getHospitalActual () {
		return hospitalActual;
	}

	/**
	 * Set the value related to the column: hospital_actual
	 * @param hospitalActual the hospital_actual value
	 */
	public void setHospitalActual (java.lang.Integer hospitalActual) {
		this.hospitalActual = hospitalActual;
	}



	/**
	 * Return the value associated with the column: hospital_modify
	 */
	public java.lang.Integer getHospitalModify () {
		return hospitalModify;
	}

	/**
	 * Set the value related to the column: hospital_modify
	 * @param hospitalModify the hospital_modify value
	 */
	public void setHospitalModify (java.lang.Integer hospitalModify) {
		this.hospitalModify = hospitalModify;
	}



	/**
	 * Return the value associated with the column: report_month
	 */
	public java.lang.Integer getReportMonth () {
		return reportMonth;
	}

	/**
	 * Set the value related to the column: report_month
	 * @param reportMonth the report_month value
	 */
	public void setReportMonth (java.lang.Integer reportMonth) {
		this.reportMonth = reportMonth;
	}



	/**
	 * Return the value associated with the column: report_year
	 */
	public java.lang.Integer getReportYear () {
		return reportYear;
	}

	/**
	 * Set the value related to the column: report_year
	 * @param reportYear the report_year value
	 */
	public void setReportYear (java.lang.Integer reportYear) {
		this.reportYear = reportYear;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
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
	 * Return the value associated with the column: parameter_id
	 */
	public jkt.hms.masters.business.MasPhReportsParameters getParameter () {
		return parameter;
	}

	/**
	 * Set the value related to the column: parameter_id
	 * @param parameter the parameter_id value
	 */
	public void setParameter (jkt.hms.masters.business.MasPhReportsParameters parameter) {
		this.parameter = parameter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HmisHospitalReport)) return false;
		else {
			jkt.hms.masters.business.HmisHospitalReport hmisHospitalReport = (jkt.hms.masters.business.HmisHospitalReport) obj;
			if (null == this.getId() || null == hmisHospitalReport.getId()) return false;
			else return (this.getId().equals(hmisHospitalReport.getId()));
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