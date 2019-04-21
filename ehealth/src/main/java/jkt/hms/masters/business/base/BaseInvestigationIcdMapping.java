package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the investigation_icd_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="investigation_icd_mapping"
 */

public abstract class BaseInvestigationIcdMapping  implements Serializable {

	public static String REF = "InvestigationIcdMapping";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_ICD_CODE = "IcdCode";
	public static String PROP_ID = "Id";


	// constructors
	public BaseInvestigationIcdMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInvestigationIcdMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasIcd icdCode;
	private jkt.hms.masters.business.DgMasInvestigation investigation;



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
	 * Return the value associated with the column: icd_code
	 */
	public jkt.hms.masters.business.MasIcd getIcdCode () {
		return icdCode;
	}

	/**
	 * Set the value related to the column: icd_code
	 * @param icdCode the icd_code value
	 */
	public void setIcdCode (jkt.hms.masters.business.MasIcd icdCode) {
		this.icdCode = icdCode;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigation the investigation_id value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.InvestigationIcdMapping)) return false;
		else {
			jkt.hms.masters.business.InvestigationIcdMapping investigationIcdMapping = (jkt.hms.masters.business.InvestigationIcdMapping) obj;
			if (null == this.getId() || null == investigationIcdMapping.getId()) return false;
			else return (this.getId().equals(investigationIcdMapping.getId()));
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