package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_priority table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_priority"
 */

public abstract class BaseBlPriority  implements Serializable {

	public static String REF = "BlPriority";
	public static String PROP_STATUS = "Status";
	public static String PROP_PRIORITY_CODE = "PriorityCode";
	public static String PROP_PRIORITY_NAM = "PriorityNam";
	public static String PROP_ID = "Id";
	public static String PROP_BED = "Bed";
	public static String PROP_PRIORITY = "Priority";


	// constructors
	public BaseBlPriority () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPriority (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String priorityCode;
	private java.lang.String priorityNam;
	private java.lang.String bed;
	private java.lang.String status;
	private java.lang.String priority;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="priorityid"
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
	 * Return the value associated with the column: priority_code
	 */
	public java.lang.String getPriorityCode () {
		return priorityCode;
	}

	/**
	 * Set the value related to the column: priority_code
	 * @param priorityCode the priority_code value
	 */
	public void setPriorityCode (java.lang.String priorityCode) {
		this.priorityCode = priorityCode;
	}



	/**
	 * Return the value associated with the column: priority_nam
	 */
	public java.lang.String getPriorityNam () {
		return priorityNam;
	}

	/**
	 * Set the value related to the column: priority_nam
	 * @param priorityNam the priority_nam value
	 */
	public void setPriorityNam (java.lang.String priorityNam) {
		this.priorityNam = priorityNam;
	}



	/**
	 * Return the value associated with the column: bed
	 */
	public java.lang.String getBed () {
		return bed;
	}

	/**
	 * Set the value related to the column: bed
	 * @param bed the bed value
	 */
	public void setBed (java.lang.String bed) {
		this.bed = bed;
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
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlPriority)) return false;
		else {
			jkt.hms.masters.business.BlPriority blPriority = (jkt.hms.masters.business.BlPriority) obj;
			if (null == this.getId() || null == blPriority.getId()) return false;
			else return (this.getId().equals(blPriority.getId()));
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