package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sp_dept_group_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sp_dept_group_t"
 */

public abstract class BaseSpDeptGroupT  implements Serializable {

	public static String REF = "SpDeptGroupT";
	public static String PROP_SP_PARAMETER = "SpParameter";
	public static String PROP_ID = "Id";
	public static String PROP_DEPT_GROUP_M = "DeptGroupM";


	// constructors
	public BaseSpDeptGroupT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSpDeptGroupT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.SpDeptGroupM deptGroupM;
	private jkt.hms.masters.business.MasSpecialityParameter spParameter;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="dept_group_t_id"
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
	 * Return the value associated with the column: dept_group_m_id
	 */
	public jkt.hms.masters.business.SpDeptGroupM getDeptGroupM () {
		return deptGroupM;
	}

	/**
	 * Set the value related to the column: dept_group_m_id
	 * @param deptGroupM the dept_group_m_id value
	 */
	public void setDeptGroupM (jkt.hms.masters.business.SpDeptGroupM deptGroupM) {
		this.deptGroupM = deptGroupM;
	}



	/**
	 * Return the value associated with the column: sp_parameter_id
	 */
	public jkt.hms.masters.business.MasSpecialityParameter getSpParameter () {
		return spParameter;
	}

	/**
	 * Set the value related to the column: sp_parameter_id
	 * @param spParameter the sp_parameter_id value
	 */
	public void setSpParameter (jkt.hms.masters.business.MasSpecialityParameter spParameter) {
		this.spParameter = spParameter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SpDeptGroupT)) return false;
		else {
			jkt.hms.masters.business.SpDeptGroupT spDeptGroupT = (jkt.hms.masters.business.SpDeptGroupT) obj;
			if (null == this.getId() || null == spDeptGroupT.getId()) return false;
			else return (this.getId().equals(spDeptGroupT.getId()));
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