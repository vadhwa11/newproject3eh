package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_projecttype table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_projecttype"
 */

public abstract class BaseMstrProjecttype  implements Serializable {

	public static String REF = "MstrProjecttype";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PROJECT_NAME = "ProjectName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PROJECT_CODE = "ProjectCode";


	// constructors
	public BaseMstrProjecttype () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrProjecttype (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String projectName;
	private java.lang.String projectCode;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hrms.masters.business.MstrProject> mstrProjects;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="project_type_id"
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
	 * Return the value associated with the column: project_name
	 */
	public java.lang.String getProjectName () {
		return projectName;
	}

	/**
	 * Set the value related to the column: project_name
	 * @param projectName the project_name value
	 */
	public void setProjectName (java.lang.String projectName) {
		this.projectName = projectName;
	}



	/**
	 * Return the value associated with the column: project_code
	 */
	public java.lang.String getProjectCode () {
		return projectCode;
	}

	/**
	 * Set the value related to the column: project_code
	 * @param projectCode the project_code value
	 */
	public void setProjectCode (java.lang.String projectCode) {
		this.projectCode = projectCode;
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
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: MstrProjects
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrProject> getMstrProjects () {
		return mstrProjects;
	}

	/**
	 * Set the value related to the column: MstrProjects
	 * @param mstrProjects the MstrProjects value
	 */
	public void setMstrProjects (java.util.Set<jkt.hrms.masters.business.MstrProject> mstrProjects) {
		this.mstrProjects = mstrProjects;
	}

	public void addToMstrProjects (jkt.hrms.masters.business.MstrProject mstrProject) {
		if (null == getMstrProjects()) setMstrProjects(new java.util.TreeSet<jkt.hrms.masters.business.MstrProject>());
		getMstrProjects().add(mstrProject);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrProjecttype)) return false;
		else {
			jkt.hrms.masters.business.MstrProjecttype mstrProjecttype = (jkt.hrms.masters.business.MstrProjecttype) obj;
			if (null == this.getId() || null == mstrProjecttype.getId()) return false;
			else return (this.getId().equals(mstrProjecttype.getId()));
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