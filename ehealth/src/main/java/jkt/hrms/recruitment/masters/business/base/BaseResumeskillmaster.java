package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumeskillmaster
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumeskillmaster"
 */

public abstract class BaseResumeskillmaster implements Serializable {

	public static String REF = "Resumeskillmaster";
	public static String PROP_SKILL_DESC = "SkillDesc";
	public static String PROP_ID = "Id";
	public static String PROP_SKILL_PARENT = "SkillParent";

	// constructors
	public BaseResumeskillmaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumeskillmaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseResumeskillmaster(java.lang.Integer id,
			java.lang.Integer skillParent, java.lang.String skillDesc) {

		this.setId(id);
		this.setSkillParent(skillParent);
		this.setSkillDesc(skillDesc);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer skillParent;
	private java.lang.String skillDesc;

	// collections
	private java.util.Set<jkt.hrms.recruitment.masters.business.Resumeskillmaster> childs;

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
	 * Return the value associated with the column: skill_parent
	 */
	public java.lang.Integer getSkillParent() {
		return skillParent;
	}

	/**
	 * Set the value related to the column: skill_parent
	 * 
	 * @param skillParent
	 *            the skill_parent value
	 */
	public void setSkillParent(java.lang.Integer skillParent) {
		this.skillParent = skillParent;
	}

	/**
	 * Return the value associated with the column: skill_desc
	 */
	public java.lang.String getSkillDesc() {
		return skillDesc;
	}

	/**
	 * Set the value related to the column: skill_desc
	 * 
	 * @param skillDesc
	 *            the skill_desc value
	 */
	public void setSkillDesc(java.lang.String skillDesc) {
		this.skillDesc = skillDesc;
	}

	/**
	 * Return the value associated with the column: childs
	 */
	public java.util.Set<jkt.hrms.recruitment.masters.business.Resumeskillmaster> getChilds() {
		return childs;
	}

	/**
	 * Set the value related to the column: childs
	 * 
	 * @param childs
	 *            the childs value
	 */
	public void setChilds(
			java.util.Set<jkt.hrms.recruitment.masters.business.Resumeskillmaster> childs) {
		this.childs = childs;
	}

	public void addTochilds(
			jkt.hrms.recruitment.masters.business.Resumeskillmaster resumeskillmaster) {
		if (null == getChilds()) {
			setChilds(new java.util.TreeSet<jkt.hrms.recruitment.masters.business.Resumeskillmaster>());
		}
		getChilds().add(resumeskillmaster);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumeskillmaster)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumeskillmaster resumeskillmaster = (jkt.hrms.recruitment.masters.business.Resumeskillmaster) obj;
			if (null == this.getId() || null == resumeskillmaster.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumeskillmaster.getId()));
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