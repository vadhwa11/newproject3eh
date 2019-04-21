package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_antenatal_usg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_antenatal_usg"
 */

public abstract class BaseOpdAntenatalUsg  implements Serializable {

	public static String REF = "OpdAntenatalUsg";
	public static String PROP_USG_PARAMETER = "UsgParameter";
	public static String PROP_USG_FLAG = "UsgFlag";
	public static String PROP_FIRST_TRIM_WEEKS = "firstTrimWeeks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_USG_PARAMETER_VALUE1 = "UsgParameterValue1";
	public static String PROP_USG_PARAMETER_VALUE2 = "UsgParameterValue2";
	public static String PROP_USG_PARAMETER_VALUE3 = "UsgParameterValue3";
	public static String PROP_USG_PARAMETER_VALUE4 = "UsgParameterValue4";
	public static String PROP_VISIT = "Visit";
	public static String PROP_USG_PARAMETER_VALUE5 = "UsgParameterValue5";
	public static String PROP_USG_PARAMETER_VALUE6 = "UsgParameterValue6";
	public static String PROP_TRIMISTER = "Trimister";
	public static String PROP_VISIT_FLAG = "VisitFlag";
	public static String PROP_OPD_ANTENATAL_CARD = "OpdAntenatalCard";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOpdAntenatalUsg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdAntenatalUsg (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String trimister;
	private java.lang.String usgParameter;
	private java.lang.String usgParameterValue1;
	private java.lang.String usgParameterValue2;
	private java.lang.String usgParameterValue3;
	private java.lang.String usgParameterValue4;
	private java.lang.String firstTrimWeeks;
	private java.lang.String usgFlag;
	private java.lang.String visitFlag;
	private java.lang.String usgParameterValue5;
	private java.lang.String usgParameterValue6;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_antenatal_usg_id"
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
	 * Return the value associated with the column: trimister
	 */
	public java.lang.String getTrimister () {
		return trimister;
	}

	/**
	 * Set the value related to the column: trimister
	 * @param trimister the trimister value
	 */
	public void setTrimister (java.lang.String trimister) {
		this.trimister = trimister;
	}



	/**
	 * Return the value associated with the column: usg_parameter
	 */
	public java.lang.String getUsgParameter () {
		return usgParameter;
	}

	/**
	 * Set the value related to the column: usg_parameter
	 * @param usgParameter the usg_parameter value
	 */
	public void setUsgParameter (java.lang.String usgParameter) {
		this.usgParameter = usgParameter;
	}



	/**
	 * Return the value associated with the column: usg_parameter_value1
	 */
	public java.lang.String getUsgParameterValue1 () {
		return usgParameterValue1;
	}

	/**
	 * Set the value related to the column: usg_parameter_value1
	 * @param usgParameterValue1 the usg_parameter_value1 value
	 */
	public void setUsgParameterValue1 (java.lang.String usgParameterValue1) {
		this.usgParameterValue1 = usgParameterValue1;
	}



	/**
	 * Return the value associated with the column: usg_parameter_value2
	 */
	public java.lang.String getUsgParameterValue2 () {
		return usgParameterValue2;
	}

	/**
	 * Set the value related to the column: usg_parameter_value2
	 * @param usgParameterValue2 the usg_parameter_value2 value
	 */
	public void setUsgParameterValue2 (java.lang.String usgParameterValue2) {
		this.usgParameterValue2 = usgParameterValue2;
	}



	/**
	 * Return the value associated with the column: usg_parameter_value3
	 */
	public java.lang.String getUsgParameterValue3 () {
		return usgParameterValue3;
	}

	/**
	 * Set the value related to the column: usg_parameter_value3
	 * @param usgParameterValue3 the usg_parameter_value3 value
	 */
	public void setUsgParameterValue3 (java.lang.String usgParameterValue3) {
		this.usgParameterValue3 = usgParameterValue3;
	}



	/**
	 * Return the value associated with the column: usg_parameter_value4
	 */
	public java.lang.String getUsgParameterValue4 () {
		return usgParameterValue4;
	}

	/**
	 * Set the value related to the column: usg_parameter_value4
	 * @param usgParameterValue4 the usg_parameter_value4 value
	 */
	public void setUsgParameterValue4 (java.lang.String usgParameterValue4) {
		this.usgParameterValue4 = usgParameterValue4;
	}



	/**
	 * Return the value associated with the column: first_trim_weeks
	 */
	public java.lang.String getFirstTrimWeeks () {
		return firstTrimWeeks;
	}

	/**
	 * Set the value related to the column: first_trim_weeks
	 * @param firstTrimWeeks the first_trim_weeks value
	 */
	public void setFirstTrimWeeks (java.lang.String firstTrimWeeks) {
		this.firstTrimWeeks = firstTrimWeeks;
	}



	/**
	 * Return the value associated with the column: usg_flag
	 */
	public java.lang.String getUsgFlag () {
		return usgFlag;
	}

	/**
	 * Set the value related to the column: usg_flag
	 * @param usgFlag the usg_flag value
	 */
	public void setUsgFlag (java.lang.String usgFlag) {
		this.usgFlag = usgFlag;
	}



	/**
	 * Return the value associated with the column: visit_flag
	 */
	public java.lang.String getVisitFlag () {
		return visitFlag;
	}

	/**
	 * Set the value related to the column: visit_flag
	 * @param visitFlag the visit_flag value
	 */
	public void setVisitFlag (java.lang.String visitFlag) {
		this.visitFlag = visitFlag;
	}



	/**
	 * Return the value associated with the column: usg_parameter_value5
	 */
	public java.lang.String getUsgParameterValue5 () {
		return usgParameterValue5;
	}

	/**
	 * Set the value related to the column: usg_parameter_value5
	 * @param usgParameterValue5 the usg_parameter_value5 value
	 */
	public void setUsgParameterValue5 (java.lang.String usgParameterValue5) {
		this.usgParameterValue5 = usgParameterValue5;
	}



	/**
	 * Return the value associated with the column: usg_parameter_value6
	 */
	public java.lang.String getUsgParameterValue6 () {
		return usgParameterValue6;
	}

	/**
	 * Set the value related to the column: usg_parameter_value6
	 * @param usgParameterValue6 the usg_parameter_value6 value
	 */
	public void setUsgParameterValue6 (java.lang.String usgParameterValue6) {
		this.usgParameterValue6 = usgParameterValue6;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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
	 * Return the value associated with the column: opd_antenatal_card_id
	 */
	public jkt.hms.masters.business.OpdAntenatalCard getOpdAntenatalCard () {
		return opdAntenatalCard;
	}

	/**
	 * Set the value related to the column: opd_antenatal_card_id
	 * @param opdAntenatalCard the opd_antenatal_card_id value
	 */
	public void setOpdAntenatalCard (jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard) {
		this.opdAntenatalCard = opdAntenatalCard;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdAntenatalUsg)) return false;
		else {
			jkt.hms.masters.business.OpdAntenatalUsg opdAntenatalUsg = (jkt.hms.masters.business.OpdAntenatalUsg) obj;
			if (null == this.getId() || null == opdAntenatalUsg.getId()) return false;
			else return (this.getId().equals(opdAntenatalUsg.getId()));
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