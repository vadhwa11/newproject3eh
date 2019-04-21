package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the xl_300_table_temp table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="xl_300_table_temp"
 */

public abstract class BaseXl300TableTemp  implements Serializable {

	public static String REF = "Xl300TableTemp";
	public static String PROP_PAT_ID = "PatId";
	public static String PROP_RESULT = "Result";
	public static String PROP_SAMPLE_POS = "SamplePos";
	public static String PROP_FLAG = "Flag";
	public static String PROP_ROUND_NO = "RoundNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_CHEM_NAME = "ChemName";
	public static String PROP_RESULT_DATE = "ResultDate";
	public static String PROP_RE_RUN = "ReRun";
	public static String PROP_UNIT = "Unit";
	public static String PROP_SAMP_VOL_TYPE = "SampVolType";


	// constructors
	public BaseXl300TableTemp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseXl300TableTemp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patId;
	private java.lang.String chemName;
	private java.lang.String result;
	private java.lang.String unit;
	private java.util.Date resultDate;
	private java.lang.String samplePos;
	private java.lang.String flag;
	private java.lang.String roundNo;
	private java.lang.String remarks;
	private java.lang.String reRun;
	private java.lang.String sampVolType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="xl_id"
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
	 * Return the value associated with the column: Pat_Id
	 */
	public java.lang.String getPatId () {
		return patId;
	}

	/**
	 * Set the value related to the column: Pat_Id
	 * @param patId the Pat_Id value
	 */
	public void setPatId (java.lang.String patId) {
		this.patId = patId;
	}



	/**
	 * Return the value associated with the column: Chem_Name
	 */
	public java.lang.String getChemName () {
		return chemName;
	}

	/**
	 * Set the value related to the column: Chem_Name
	 * @param chemName the Chem_Name value
	 */
	public void setChemName (java.lang.String chemName) {
		this.chemName = chemName;
	}



	/**
	 * Return the value associated with the column: Result
	 */
	public java.lang.String getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: Result
	 * @param result the Result value
	 */
	public void setResult (java.lang.String result) {
		this.result = result;
	}



	/**
	 * Return the value associated with the column: Unit
	 */
	public java.lang.String getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: Unit
	 * @param unit the Unit value
	 */
	public void setUnit (java.lang.String unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: Result_Date
	 */
	public java.util.Date getResultDate () {
		return resultDate;
	}

	/**
	 * Set the value related to the column: Result_Date
	 * @param resultDate the Result_Date value
	 */
	public void setResultDate (java.util.Date resultDate) {
		this.resultDate = resultDate;
	}



	/**
	 * Return the value associated with the column: Sample_Pos
	 */
	public java.lang.String getSamplePos () {
		return samplePos;
	}

	/**
	 * Set the value related to the column: Sample_Pos
	 * @param samplePos the Sample_Pos value
	 */
	public void setSamplePos (java.lang.String samplePos) {
		this.samplePos = samplePos;
	}



	/**
	 * Return the value associated with the column: Flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: Flag
	 * @param flag the Flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: RoundNo
	 */
	public java.lang.String getRoundNo () {
		return roundNo;
	}

	/**
	 * Set the value related to the column: RoundNo
	 * @param roundNo the RoundNo value
	 */
	public void setRoundNo (java.lang.String roundNo) {
		this.roundNo = roundNo;
	}



	/**
	 * Return the value associated with the column: Remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: Remarks
	 * @param remarks the Remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: ReRun
	 */
	public java.lang.String getReRun () {
		return reRun;
	}

	/**
	 * Set the value related to the column: ReRun
	 * @param reRun the ReRun value
	 */
	public void setReRun (java.lang.String reRun) {
		this.reRun = reRun;
	}



	/**
	 * Return the value associated with the column: SampVolType
	 */
	public java.lang.String getSampVolType () {
		return sampVolType;
	}

	/**
	 * Set the value related to the column: SampVolType
	 * @param sampVolType the SampVolType value
	 */
	public void setSampVolType (java.lang.String sampVolType) {
		this.sampVolType = sampVolType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Xl300TableTemp)) return false;
		else {
			jkt.hms.masters.business.Xl300TableTemp xl300TableTemp = (jkt.hms.masters.business.Xl300TableTemp) obj;
			if (null == this.getId() || null == xl300TableTemp.getId()) return false;
			else return (this.getId().equals(xl300TableTemp.getId()));
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