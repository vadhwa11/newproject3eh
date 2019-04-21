package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumeremarks table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumeremarks"
 */

public abstract class BaseResumeremarks implements Serializable {

	public static String REF = "Resumeremarks";
	public static String PROP_DATE_REMARKS = "DateRemarks";
	public static String PROP_REMARKS_BY = "RemarksBy";
	public static String PROP_RESUME_ID = "ResumeId";
	public static String PROP_ID = "Id";
	public static String PROP_REMARKS = "Remarks";

	// constructors
	public BaseResumeremarks() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumeremarks(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer resumeId;
	private java.lang.String remarks;
	private java.util.Date dateRemarks;
	private java.lang.String remarksBy;

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
	 * Return the value associated with the column: resume_id
	 */
	public java.lang.Integer getResumeId() {
		return resumeId;
	}

	/**
	 * Set the value related to the column: resume_id
	 * 
	 * @param resumeId
	 *            the resume_id value
	 */
	public void setResumeId(java.lang.Integer resumeId) {
		this.resumeId = resumeId;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: date_remarks
	 */
	public java.util.Date getDateRemarks() {
		return dateRemarks;
	}

	/**
	 * Set the value related to the column: date_remarks
	 * 
	 * @param dateRemarks
	 *            the date_remarks value
	 */
	public void setDateRemarks(java.util.Date dateRemarks) {
		this.dateRemarks = dateRemarks;
	}

	/**
	 * Return the value associated with the column: remarks_by
	 */
	public java.lang.String getRemarksBy() {
		return remarksBy;
	}

	/**
	 * Set the value related to the column: remarks_by
	 * 
	 * @param remarksBy
	 *            the remarks_by value
	 */
	public void setRemarksBy(java.lang.String remarksBy) {
		this.remarksBy = remarksBy;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumeremarks)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumeremarks resumeremarks = (jkt.hrms.recruitment.masters.business.Resumeremarks) obj;
			if (null == this.getId() || null == resumeremarks.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumeremarks.getId()));
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