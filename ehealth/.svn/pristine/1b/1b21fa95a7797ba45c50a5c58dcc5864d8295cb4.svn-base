package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumeskill table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumeskill"
 */

public abstract class BaseResumeskill implements Serializable {

	public static String REF = "Resumeskill";
	public static String PROP_SKILL_ID = "SkillId";
	public static String PROP_RESUME_ID = "ResumeId";
	public static String PROP_SKILL_TYPE = "SkillType";
	public static String PROP_ID = "Id";

	// constructors
	public BaseResumeskill() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumeskill(java.lang.Integer id) {
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
	private java.lang.Integer skillId;
	private java.lang.String skillType;

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
	 * Return the value associated with the column: skill_id
	 */
	public java.lang.Integer getSkillId() {
		return skillId;
	}

	/**
	 * Set the value related to the column: skill_id
	 * 
	 * @param skillId
	 *            the skill_id value
	 */
	public void setSkillId(java.lang.Integer skillId) {
		this.skillId = skillId;
	}

	/**
	 * Return the value associated with the column: skill_type
	 */
	public java.lang.String getSkillType() {
		return skillType;
	}

	/**
	 * Set the value related to the column: skill_type
	 * 
	 * @param skillType
	 *            the skill_type value
	 */
	public void setSkillType(java.lang.String skillType) {
		this.skillType = skillType;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumeskill)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumeskill resumeskill = (jkt.hrms.recruitment.masters.business.Resumeskill) obj;
			if (null == this.getId() || null == resumeskill.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumeskill.getId()));
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