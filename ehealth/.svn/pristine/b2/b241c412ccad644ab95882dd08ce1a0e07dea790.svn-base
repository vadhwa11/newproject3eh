package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the employee_telephone_dir table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="employee_telephone_dir"
 */

public abstract class BaseEmployeeTeleDirec  implements Serializable {

	public static String REF = "EmployeeTeleDirec";
	public static String PROP_PHONE_NO = "Phone";
	public static String PROP_NAME = "Name";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";


	// constructors
	public BaseEmployeeTeleDirec () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployeeTeleDirec (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String phone ;
	private java.lang.String address;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="emp_id"
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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: mobile_no
	 */
	public java.lang.String getPhone() {
		return phone ;
	}

	/**
	 * Set the value related to the column: mobile_no
	 * @param phone  the mobile_no value
	 */
	public void setPhone(java.lang.String phone ) {
		this.phone  = phone ;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.EmployeeTeleDirec)) return false;
		else {
			jkt.hms.masters.business.EmployeeTeleDirec employeeTeleDirec = (jkt.hms.masters.business.EmployeeTeleDirec) obj;
			if (null == this.getId() || null == employeeTeleDirec.getId()) return false;
			else return (this.getId().equals(employeeTeleDirec.getId()));
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