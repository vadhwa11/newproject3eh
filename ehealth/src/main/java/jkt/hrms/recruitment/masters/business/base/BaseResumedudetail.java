package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumedudetail table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumedudetail"
 */

public abstract class BaseResumedudetail implements Serializable {

	public static String REF = "Resumedudetail";
	public static String PROP_ID = "Id";
	public static String PROP_D_U_NAME = "DUName";

	// constructors
	public BaseResumedudetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumedudetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseResumedudetail(java.lang.Integer id, java.lang.String dUName) {

		this.setId(id);
		this.setDUName(dUName);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dUName;

	// collections
	private java.util.Set<jkt.hrms.recruitment.masters.business.Resumeprojectsdetail> resumeprojectsdetails;

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
	 * Return the value associated with the column: DUName
	 */
	public java.lang.String getDUName() {
		return dUName;
	}

	/**
	 * Set the value related to the column: DUName
	 * 
	 * @param dUName
	 *            the DUName value
	 */
	public void setDUName(java.lang.String dUName) {
		this.dUName = dUName;
	}

	/**
	 * Return the value associated with the column: Resumeprojectsdetails
	 */
	public java.util.Set<jkt.hrms.recruitment.masters.business.Resumeprojectsdetail> getResumeprojectsdetails() {
		return resumeprojectsdetails;
	}

	/**
	 * Set the value related to the column: Resumeprojectsdetails
	 * 
	 * @param resumeprojectsdetails
	 *            the Resumeprojectsdetails value
	 */
	public void setResumeprojectsdetails(
			java.util.Set<jkt.hrms.recruitment.masters.business.Resumeprojectsdetail> resumeprojectsdetails) {
		this.resumeprojectsdetails = resumeprojectsdetails;
	}

	public void addToResumeprojectsdetails(
			jkt.hrms.recruitment.masters.business.Resumeprojectsdetail resumeprojectsdetail) {
		if (null == getResumeprojectsdetails()) {
			setResumeprojectsdetails(new java.util.TreeSet<jkt.hrms.recruitment.masters.business.Resumeprojectsdetail>());
		}
		getResumeprojectsdetails().add(resumeprojectsdetail);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumedudetail)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumedudetail resumedudetail = (jkt.hrms.recruitment.masters.business.Resumedudetail) obj;
			if (null == this.getId() || null == resumedudetail.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumedudetail.getId()));
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