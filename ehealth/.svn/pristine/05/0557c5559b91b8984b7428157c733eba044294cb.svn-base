package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumeprojectsdetail
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumeprojectsdetail"
 */

public abstract class BaseResumeprojectsdetail implements Serializable {

	public static String REF = "Resumeprojectsdetail";
	public static String PROP_DUID = "Duid";
	public static String PROP_PROJECT_NAME = "ProjectName";
	public static String PROP_ID = "Id";
	public static String PROP_DU = "Du";

	// constructors
	public BaseResumeprojectsdetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumeprojectsdetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseResumeprojectsdetail(java.lang.Integer id,
			jkt.hrms.recruitment.masters.business.Resumedudetail du,
			java.lang.String projectName) {

		this.setId(id);
		this.setDu(du);
		this.setProjectName(projectName);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String projectName;
	private java.lang.Integer duid;

	// many to one
	private jkt.hrms.recruitment.masters.business.Resumedudetail du;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: ProjectName
	 */
	public java.lang.String getProjectName() {
		return projectName;
	}

	/**
	 * Set the value related to the column: ProjectName
	 * 
	 * @param projectName
	 *            the ProjectName value
	 */
	public void setProjectName(java.lang.String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Return the value associated with the column: Du_id
	 */
	public java.lang.Integer getDuid() {
		return duid;
	}

	/**
	 * Set the value related to the column: Du_id
	 * 
	 * @param duid
	 *            the Du_id value
	 */
	public void setDuid(java.lang.Integer duid) {
		this.duid = duid;
	}

	/**
	 * Return the value associated with the column: Du_id
	 */
	public jkt.hrms.recruitment.masters.business.Resumedudetail getDu() {
		return du;
	}

	/**
	 * Set the value related to the column: Du_id
	 * 
	 * @param du
	 *            the Du_id value
	 */
	public void setDu(jkt.hrms.recruitment.masters.business.Resumedudetail du) {
		this.du = du;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumeprojectsdetail)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumeprojectsdetail resumeprojectsdetail = (jkt.hrms.recruitment.masters.business.Resumeprojectsdetail) obj;
			if (null == this.getId() || null == resumeprojectsdetail.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumeprojectsdetail.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}