package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the token_display_ip table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="token_display_ip"
 */

public abstract class BaseTokenDisplayIp  implements Serializable {

	public static String REF = "TokenDisplayIp";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_DISPLAY_NAME = "DisplayName";


	// constructors
	public BaseTokenDisplayIp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTokenDisplayIp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTokenDisplayIp (
		java.lang.Integer id,
		java.lang.String displayName) {

		this.setId(id);
		this.setDisplayName(displayName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String displayName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasInstituteDepartment> masInstituteDepartments;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: display_name
	 */
	public java.lang.String getDisplayName () {
		return displayName;
	}

	/**
	 * Set the value related to the column: display_name
	 * @param displayName the display_name value
	 */
	public void setDisplayName (java.lang.String displayName) {
		this.displayName = displayName;
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
	 * Return the value associated with the column: MasInstituteDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.MasInstituteDepartment> getMasInstituteDepartments () {
		return masInstituteDepartments;
	}

	/**
	 * Set the value related to the column: MasInstituteDepartments
	 * @param masInstituteDepartments the MasInstituteDepartments value
	 */
	public void setMasInstituteDepartments (java.util.Set<jkt.hms.masters.business.MasInstituteDepartment> masInstituteDepartments) {
		this.masInstituteDepartments = masInstituteDepartments;
	}

	public void addToMasInstituteDepartments (jkt.hms.masters.business.MasInstituteDepartment masInstituteDepartment) {
		if (null == getMasInstituteDepartments()) setMasInstituteDepartments(new java.util.TreeSet<jkt.hms.masters.business.MasInstituteDepartment>());
		getMasInstituteDepartments().add(masInstituteDepartment);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TokenDisplayIp)) return false;
		else {
			jkt.hms.masters.business.TokenDisplayIp tokenDisplayIp = (jkt.hms.masters.business.TokenDisplayIp) obj;
			if (null == this.getId() || null == tokenDisplayIp.getId()) return false;
			else return (this.getId().equals(tokenDisplayIp.getId()));
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