package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumejobprofile
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumejobprofile"
 */

public abstract class BaseResumejobprofile implements Serializable {

	public static String REF = "Resumejobprofile";
	public static String PROP_JOB_PROFILE = "JobProfile";
	public static String PROP_ID = "Id";

	// constructors
	public BaseResumejobprofile() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumejobprofile(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseResumejobprofile(java.lang.Integer id,
			java.lang.String jobProfile) {

		this.setId(id);
		this.setJobProfile(jobProfile);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String jobProfile;

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
	 * Return the value associated with the column: job_profile
	 */
	public java.lang.String getJobProfile() {
		return jobProfile;
	}

	/**
	 * Set the value related to the column: job_profile
	 * 
	 * @param jobProfile
	 *            the job_profile value
	 */
	public void setJobProfile(java.lang.String jobProfile) {
		this.jobProfile = jobProfile;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumejobprofile)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumejobprofile resumejobprofile = (jkt.hrms.recruitment.masters.business.Resumejobprofile) obj;
			if (null == this.getId() || null == resumejobprofile.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumejobprofile.getId()));
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