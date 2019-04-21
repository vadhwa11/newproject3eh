package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_condemnation_commitee_members table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_condemnation_commitee_members"
 */

public abstract class BaseMmCondemnationCommiteeMembers  implements Serializable {

	public static String REF = "MmCondemnationCommiteeMembers";
	public static String PROP_ID = "Id";
	public static String PROP_CONDEMNATION_COMMITEE = "CondemnationCommitee";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseMmCondemnationCommiteeMembers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmCondemnationCommiteeMembers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MmCondemnationCommitee condemnationCommitee;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="member_id"
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
	 * Return the value associated with the column: condemnation_commitee_id
	 */
	public jkt.hms.masters.business.MmCondemnationCommitee getCondemnationCommitee () {
		return condemnationCommitee;
	}

	/**
	 * Set the value related to the column: condemnation_commitee_id
	 * @param condemnationCommitee the condemnation_commitee_id value
	 */
	public void setCondemnationCommitee (jkt.hms.masters.business.MmCondemnationCommitee condemnationCommitee) {
		this.condemnationCommitee = condemnationCommitee;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmCondemnationCommiteeMembers)) return false;
		else {
			jkt.hms.masters.business.MmCondemnationCommiteeMembers mmCondemnationCommiteeMembers = (jkt.hms.masters.business.MmCondemnationCommiteeMembers) obj;
			if (null == this.getId() || null == mmCondemnationCommiteeMembers.getId()) return false;
			else return (this.getId().equals(mmCondemnationCommiteeMembers.getId()));
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