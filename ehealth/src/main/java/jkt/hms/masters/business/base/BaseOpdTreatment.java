package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_treatment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_treatment"
 */

public abstract class BaseOpdTreatment  implements Serializable {

	public static String REF = "OpdTreatment";
	public static String PROP_FLAG = "Flag";
	public static String PROP_ENDODONTICS_HEADER = "EndodonticsHeader";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_TOOTH = "Tooth";
	public static String PROP_TREATMENT = "Treatment";


	// constructors
	public BaseOpdTreatment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdTreatment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tooth;
	private java.lang.String treatment;
	private java.lang.String remarks;
	private java.lang.String flag;

	// many to one
	private jkt.hms.masters.business.OpdEndodonticsHeader endodonticsHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_treatment_id"
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
	 * Return the value associated with the column: tooth
	 */
	public java.lang.String getTooth () {
		return tooth;
	}

	/**
	 * Set the value related to the column: tooth
	 * @param tooth the tooth value
	 */
	public void setTooth (java.lang.String tooth) {
		this.tooth = tooth;
	}



	/**
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * @param treatment the treatment value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: endodontics_header_id
	 */
	public jkt.hms.masters.business.OpdEndodonticsHeader getEndodonticsHeader () {
		return endodonticsHeader;
	}

	/**
	 * Set the value related to the column: endodontics_header_id
	 * @param endodonticsHeader the endodontics_header_id value
	 */
	public void setEndodonticsHeader (jkt.hms.masters.business.OpdEndodonticsHeader endodonticsHeader) {
		this.endodonticsHeader = endodonticsHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdTreatment)) return false;
		else {
			jkt.hms.masters.business.OpdTreatment opdTreatment = (jkt.hms.masters.business.OpdTreatment) obj;
			if (null == this.getId() || null == opdTreatment.getId()) return false;
			else return (this.getId().equals(opdTreatment.getId()));
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