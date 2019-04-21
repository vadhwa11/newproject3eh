package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_template table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_template"
 */

public abstract class BaseOpdTemplate  implements Serializable {

	public static String REF = "OpdTemplate";
	public static String PROP_TEMPLATE_TYPE = "TemplateType";
	public static String PROP_STATUS = "Status";
	public static String PROP_TEMPLATE_NAME = "TemplateName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_TEMPLATE_CODE = "TemplateCode";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_LOCAL_TEMPLATE ="TemplateLocal"; //added by Om Tripathi
	
	// constructors
	public BaseOpdTemplate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdTemplate (java.lang.Integer id) {
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
	private java.lang.String templateType;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer templateLocal;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> opdTemplateInvestigations;
	private java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> opdTemplateTreatments;



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
	 * Return the value associated with the column: template_local
	 */
	public java.lang.Integer getTemplateLocal() {
		return templateLocal;
	}
	/**
	 * Set the value related to the column: template_local
	 * @param templateLocal the template_local value
	 */
	public void setTemplateLocal(java.lang.Integer templateLocal) {
		this.templateLocal = templateLocal;
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
	 * Return the value associated with the column: OpdTemplateInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> getOpdTemplateInvestigations () {
		return opdTemplateInvestigations;
	}

	/**
	 * Set the value related to the column: OpdTemplateInvestigations
	 * @param opdTemplateInvestigations the OpdTemplateInvestigations value
	 */
	public void setOpdTemplateInvestigations (java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> opdTemplateInvestigations) {
		this.opdTemplateInvestigations = opdTemplateInvestigations;
	}

	public void addToOpdTemplateInvestigations (jkt.hms.masters.business.OpdTemplateInvestigation opdTemplateInvestigation) {
		if (null == getOpdTemplateInvestigations()) setOpdTemplateInvestigations(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplateInvestigation>());
		getOpdTemplateInvestigations().add(opdTemplateInvestigation);
	}



	/**
	 * Return the value associated with the column: OpdTemplateTreatments
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> getOpdTemplateTreatments () {
		return opdTemplateTreatments;
	}

	/**
	 * Set the value related to the column: OpdTemplateTreatments
	 * @param opdTemplateTreatments the OpdTemplateTreatments value
	 */
	public void setOpdTemplateTreatments (java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> opdTemplateTreatments) {
		this.opdTemplateTreatments = opdTemplateTreatments;
	}

	public void addToOpdTemplateTreatments (jkt.hms.masters.business.OpdTemplateTreatment opdTemplateTreatment) {
		if (null == getOpdTemplateTreatments()) setOpdTemplateTreatments(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplateTreatment>());
		getOpdTemplateTreatments().add(opdTemplateTreatment);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdTemplate)) return false;
		else {
			jkt.hms.masters.business.OpdTemplate opdTemplate = (jkt.hms.masters.business.OpdTemplate) obj;
			if (null == this.getId() || null == opdTemplate.getId()) return false;
			else return (this.getId().equals(opdTemplate.getId()));
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