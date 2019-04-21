package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_specialty_template table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_specialty_template"
 */

public abstract class BaseMasSpecialtyTemplate  implements Serializable {

	public static String REF = "MasSpecialtyTemplate";
	public static String PROP_TEMPLATE_TYPE = "TemplateType";
	public static String PROP_STATUS = "Status";
	public static String PROP_TEMPLATE_NAME = "TemplateName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_TEMPLATE_CODE = "TemplateCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasSpecialtyTemplate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSpecialtyTemplate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String templateCode;
	private java.lang.String templateName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String templateType;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasSpecialityDeptGroup> masSpecialityDeptGroups;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="template_id"
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
	 * Return the value associated with the column: template_code
	 */
	public java.lang.String getTemplateCode () {
		return templateCode;
	}

	/**
	 * Set the value related to the column: template_code
	 * @param templateCode the template_code value
	 */
	public void setTemplateCode (java.lang.String templateCode) {
		this.templateCode = templateCode;
	}



	/**
	 * Return the value associated with the column: template_name
	 */
	public java.lang.String getTemplateName () {
		return templateName;
	}

	/**
	 * Set the value related to the column: template_name
	 * @param templateName the template_name value
	 */
	public void setTemplateName (java.lang.String templateName) {
		this.templateName = templateName;
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
	 * Return the value associated with the column: template_type
	 */
	public java.lang.String getTemplateType () {
		return templateType;
	}

	/**
	 * Set the value related to the column: template_type
	 * @param templateType the template_type value
	 */
	public void setTemplateType (java.lang.String templateType) {
		this.templateType = templateType;
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
	 * Return the value associated with the column: MasSpecialityDeptGroups
	 */
	public java.util.Set<jkt.hms.masters.business.MasSpecialityDeptGroup> getMasSpecialityDeptGroups () {
		return masSpecialityDeptGroups;
	}

	/**
	 * Set the value related to the column: MasSpecialityDeptGroups
	 * @param masSpecialityDeptGroups the MasSpecialityDeptGroups value
	 */
	public void setMasSpecialityDeptGroups (java.util.Set<jkt.hms.masters.business.MasSpecialityDeptGroup> masSpecialityDeptGroups) {
		this.masSpecialityDeptGroups = masSpecialityDeptGroups;
	}

	public void addToMasSpecialityDeptGroups (jkt.hms.masters.business.MasSpecialityDeptGroup masSpecialityDeptGroup) {
		if (null == getMasSpecialityDeptGroups()) setMasSpecialityDeptGroups(new java.util.TreeSet<jkt.hms.masters.business.MasSpecialityDeptGroup>());
		getMasSpecialityDeptGroups().add(masSpecialityDeptGroup);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSpecialtyTemplate)) return false;
		else {
			jkt.hms.masters.business.MasSpecialtyTemplate masSpecialtyTemplate = (jkt.hms.masters.business.MasSpecialtyTemplate) obj;
			if (null == this.getId() || null == masSpecialtyTemplate.getId()) return false;
			else return (this.getId().equals(masSpecialtyTemplate.getId()));
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