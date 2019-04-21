package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_hmis_parameters table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_hmis_parameters"
 */

public abstract class BaseMasHmisParameters  implements Serializable {

	public static String REF = "MasHmisParameters";
	public static String PROP_HMIS_PARAMETER = "HmisParameter";
	public static String PROP_HMIS_TYPE = "HmisType";
	public static String PROP_ID = "Id";
	public static String PROP_HMIS_ID = "HmisId";


	// constructors
	public BaseMasHmisParameters () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasHmisParameters (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String hmisId;
	private java.lang.String hmisParameter;
	private java.lang.String hmisType;



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
	 * Return the value associated with the column: hmis_id
	 */
	public java.lang.String getHmisId () {
		return hmisId;
	}

	/**
	 * Set the value related to the column: hmis_id
	 * @param hmisId the hmis_id value
	 */
	public void setHmisId (java.lang.String hmisId) {
		this.hmisId = hmisId;
	}



	/**
	 * Return the value associated with the column: hmis_parameter
	 */
	public java.lang.String getHmisParameter () {
		return hmisParameter;
	}

	/**
	 * Set the value related to the column: hmis_parameter
	 * @param hmisParameter the hmis_parameter value
	 */
	public void setHmisParameter (java.lang.String hmisParameter) {
		this.hmisParameter = hmisParameter;
	}



	/**
	 * Return the value associated with the column: hmis_type
	 */
	public java.lang.String getHmisType () {
		return hmisType;
	}

	/**
	 * Set the value related to the column: hmis_type
	 * @param hmisType the hmis_type value
	 */
	public void setHmisType (java.lang.String hmisType) {
		this.hmisType = hmisType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasHmisParameters)) return false;
		else {
			jkt.hms.masters.business.MasHmisParameters masHmisParameters = (jkt.hms.masters.business.MasHmisParameters) obj;
			if (null == this.getId() || null == masHmisParameters.getId()) return false;
			else return (this.getId().equals(masHmisParameters.getId()));
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