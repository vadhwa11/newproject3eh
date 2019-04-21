package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_template table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_template"
 */

public abstract class BaseMasTemplate  implements Serializable {

	public static String REF = "MasTemplate";
	public static String PROP_STATUS = "Status";
	public static String PROP_TEMPLATE_NAME = "TemplateName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DEPT = "Dept";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_TEMPLATE_CODE = "TemplateCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REMOVE_ID = "RemoveId";

	// constructors
	public BaseMasTemplate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasTemplate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasTemplate (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment dept,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.Users lastChgBy,
		java.lang.String templateName,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime,
		java.lang.String templateCode) {

		this.setId(id);
		this.setDept(dept);
		this.setHospital(hospital);
		this.setLastChgBy(lastChgBy);
		this.setTemplateName(templateName);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		this.setTemplateCode(templateCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String templateName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String templateCode;
	private java.lang.Integer removeId;
	
	// many to one
	private jkt.hms.masters.business.MasDepartment dept;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.UserTemplate> userTemplates;
	private java.util.Set<jkt.hms.masters.business.TemplateApplication> templateApplications;
	private java.util.Set<jkt.hms.masters.business.TemplateDepartment> templateDepartments;



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
	 * Return the value associated with the column: dept_id
	 */
	public jkt.hms.masters.business.MasDepartment getDept () {
		return dept;
	}

	/**
	 * Set the value related to the column: dept_id
	 * @param dept the dept_id value
	 */
	public void setDept (jkt.hms.masters.business.MasDepartment dept) {
		this.dept = dept;
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
	 * Return the value associated with the column: UserTemplates
	 */
	public java.util.Set<jkt.hms.masters.business.UserTemplate> getUserTemplates () {
		return userTemplates;
	}

	/**
	 * Set the value related to the column: UserTemplates
	 * @param userTemplates the UserTemplates value
	 */
	public void setUserTemplates (java.util.Set<jkt.hms.masters.business.UserTemplate> userTemplates) {
		this.userTemplates = userTemplates;
	}

	public void addToUserTemplates (jkt.hms.masters.business.UserTemplate userTemplate) {
		if (null == getUserTemplates()) setUserTemplates(new java.util.TreeSet<jkt.hms.masters.business.UserTemplate>());
		getUserTemplates().add(userTemplate);
	}



	/**
	 * Return the value associated with the column: TemplateApplications
	 */
	public java.util.Set<jkt.hms.masters.business.TemplateApplication> getTemplateApplications () {
		return templateApplications;
	}

	/**
	 * Set the value related to the column: TemplateApplications
	 * @param templateApplications the TemplateApplications value
	 */
	public void setTemplateApplications (java.util.Set<jkt.hms.masters.business.TemplateApplication> templateApplications) {
		this.templateApplications = templateApplications;
	}

	public void addToTemplateApplications (jkt.hms.masters.business.TemplateApplication templateApplication) {
		if (null == getTemplateApplications()) setTemplateApplications(new java.util.TreeSet<jkt.hms.masters.business.TemplateApplication>());
		getTemplateApplications().add(templateApplication);
	}



	/**
	 * Return the value associated with the column: TemplateDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.TemplateDepartment> getTemplateDepartments () {
		return templateDepartments;
	}

	/**
	 * Set the value related to the column: TemplateDepartments
	 * @param templateDepartments the TemplateDepartments value
	 */
	public void setTemplateDepartments (java.util.Set<jkt.hms.masters.business.TemplateDepartment> templateDepartments) {
		this.templateDepartments = templateDepartments;
	}

	public void addToTemplateDepartments (jkt.hms.masters.business.TemplateDepartment templateDepartment) {
		if (null == getTemplateDepartments()) setTemplateDepartments(new java.util.TreeSet<jkt.hms.masters.business.TemplateDepartment>());
		getTemplateDepartments().add(templateDepartment);
	}


	/**
	 * Return the value associated with the column: remove_id
	 */
	

	public java.lang.Integer getRemoveId() {
		return removeId;
	}
	/**
	 * Set the value related to the column: remove_id
	 * @param removeId the remove_id value
	 */
	public void setRemoveId(java.lang.Integer removeId) {
		this.removeId = removeId;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasTemplate)) return false;
		else {
			jkt.hms.masters.business.MasTemplate masTemplate = (jkt.hms.masters.business.MasTemplate) obj;
			if (null == this.getId() || null == masTemplate.getId()) return false;
			else return (this.getId().equals(masTemplate.getId()));
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