package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_reservation_jphn table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_reservation_jphn"
 */

public abstract class BaseStoreReservationJphn  implements Serializable {

	public static String REF = "StoreReservationJphn";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CAMP_GROUP = "CampGroup";
	public static String PROP_ID = "Id";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseStoreReservationJphn () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreReservationJphn (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.StoreReservationCampGroup campGroup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="store_reservation_jphn_id"
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



	/**
	 * Return the value associated with the column: camp_group_id
	 */
	public jkt.hms.masters.business.StoreReservationCampGroup getCampGroup () {
		return campGroup;
	}

	/**
	 * Set the value related to the column: camp_group_id
	 * @param campGroup the camp_group_id value
	 */
	public void setCampGroup (jkt.hms.masters.business.StoreReservationCampGroup campGroup) {
		this.campGroup = campGroup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreReservationJphn)) return false;
		else {
			jkt.hms.masters.business.StoreReservationJphn storeReservationJphn = (jkt.hms.masters.business.StoreReservationJphn) obj;
			if (null == this.getId() || null == storeReservationJphn.getId()) return false;
			else return (this.getId().equals(storeReservationJphn.getId()));
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