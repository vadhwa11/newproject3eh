package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_address table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_address"
 */

public abstract class BaseHrEmployeeAddress  implements Serializable {

	public static String REF = "HrEmployeeAddress";
	public static String PROP_EMP_WARD_NO = "EmpWardNo";
	public static String PROP_HOUSE_NO = "HouseNo";
	public static String PROP_LSG_HOUSE_NO = "LsgHouseNo";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_WARD_NO = "WardNo";
	public static String PROP_EMP_LOCALITY = "EmpLocality";
	public static String PROP_LSG_NAME = "LsgName";
	public static String PROP_ADDRESS3 = "Address3";
	public static String PROP_DISTRICT = "District";
	public static String PROP_LOCALITY = "Locality";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_ID = "Id";
	public static String PROP_ADDRESS_TYPE = "AddressType";
	public static String PROP_POST_OFFICE = "PostOffice";
	public static String PROP_TALUK = "Taluk";


	// constructors
	public BaseHrEmployeeAddress () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeeAddress (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String houseNo;
	private java.lang.String lsgHouseNo;
	private java.lang.String address;
	private java.util.Date addEditDateTime;
	private java.lang.Long statusId;
	private java.lang.String empWardNo;
	private java.lang.String empLocality;
	private java.lang.String address2;
	private java.lang.String address3;

	// many to one
	private jkt.hms.masters.business.MasPostCode postOffice;
	private jkt.hms.masters.business.MasLsg lsgName;
	private jkt.hms.masters.business.MasTaluk taluk;
	private jkt.hms.masters.business.PhMasLocality locality;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasWard wardNo;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasAddressType addressType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="emp_address_id"
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
	 * Return the value associated with the column: house_no
	 */
	public java.lang.String getHouseNo () {
		return houseNo;
	}

	/**
	 * Set the value related to the column: house_no
	 * @param houseNo the house_no value
	 */
	public void setHouseNo (java.lang.String houseNo) {
		this.houseNo = houseNo;
	}



	/**
	 * Return the value associated with the column: lsg_house_no
	 */
	public java.lang.String getLsgHouseNo () {
		return lsgHouseNo;
	}

	/**
	 * Set the value related to the column: lsg_house_no
	 * @param lsgHouseNo the lsg_house_no value
	 */
	public void setLsgHouseNo (java.lang.String lsgHouseNo) {
		this.lsgHouseNo = lsgHouseNo;
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



	/**
	 * Return the value associated with the column: add_edit_date_time
	 */
	public java.util.Date getAddEditDateTime () {
		return addEditDateTime;
	}

	/**
	 * Set the value related to the column: add_edit_date_time
	 * @param addEditDateTime the add_edit_date_time value
	 */
	public void setAddEditDateTime (java.util.Date addEditDateTime) {
		this.addEditDateTime = addEditDateTime;
	}



	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Long getStatusId () {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * @param statusId the status_id value
	 */
	public void setStatusId (java.lang.Long statusId) {
		this.statusId = statusId;
	}



	/**
	 * Return the value associated with the column: emp_ward_no
	 */
	public java.lang.String getEmpWardNo () {
		return empWardNo;
	}

	/**
	 * Set the value related to the column: emp_ward_no
	 * @param empWardNo the emp_ward_no value
	 */
	public void setEmpWardNo (java.lang.String empWardNo) {
		this.empWardNo = empWardNo;
	}



	/**
	 * Return the value associated with the column: emp_locality
	 */
	public java.lang.String getEmpLocality () {
		return empLocality;
	}

	/**
	 * Set the value related to the column: emp_locality
	 * @param empLocality the emp_locality value
	 */
	public void setEmpLocality (java.lang.String empLocality) {
		this.empLocality = empLocality;
	}



	/**
	 * Return the value associated with the column: address2
	 */
	public java.lang.String getAddress2 () {
		return address2;
	}

	/**
	 * Set the value related to the column: address2
	 * @param address2 the address2 value
	 */
	public void setAddress2 (java.lang.String address2) {
		this.address2 = address2;
	}



	/**
	 * Return the value associated with the column: address3
	 */
	public java.lang.String getAddress3 () {
		return address3;
	}

	/**
	 * Set the value related to the column: address3
	 * @param address3 the address3 value
	 */
	public void setAddress3 (java.lang.String address3) {
		this.address3 = address3;
	}



	/**
	 * Return the value associated with the column: post_office
	 */
	public jkt.hms.masters.business.MasPostCode getPostOffice () {
		return postOffice;
	}

	/**
	 * Set the value related to the column: post_office
	 * @param postOffice the post_office value
	 */
	public void setPostOffice (jkt.hms.masters.business.MasPostCode postOffice) {
		this.postOffice = postOffice;
	}



	/**
	 * Return the value associated with the column: lsg_name
	 */
	public jkt.hms.masters.business.MasLsg getLsgName () {
		return lsgName;
	}

	/**
	 * Set the value related to the column: lsg_name
	 * @param lsgName the lsg_name value
	 */
	public void setLsgName (jkt.hms.masters.business.MasLsg lsgName) {
		this.lsgName = lsgName;
	}



	/**
	 * Return the value associated with the column: taluk_id
	 */
	public jkt.hms.masters.business.MasTaluk getTaluk () {
		return taluk;
	}

	/**
	 * Set the value related to the column: taluk_id
	 * @param taluk the taluk_id value
	 */
	public void setTaluk (jkt.hms.masters.business.MasTaluk taluk) {
		this.taluk = taluk;
	}



	/**
	 * Return the value associated with the column: locality
	 */
	public jkt.hms.masters.business.PhMasLocality getLocality () {
		return locality;
	}

	/**
	 * Set the value related to the column: locality
	 * @param locality the locality value
	 */
	public void setLocality (jkt.hms.masters.business.PhMasLocality locality) {
		this.locality = locality;
	}



	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
	}



	/**
	 * Return the value associated with the column: ward_no
	 */
	public jkt.hms.masters.business.MasWard getWardNo () {
		return wardNo;
	}

	/**
	 * Set the value related to the column: ward_no
	 * @param wardNo the ward_no value
	 */
	public void setWardNo (jkt.hms.masters.business.MasWard wardNo) {
		this.wardNo = wardNo;
	}



	/**
	 * Return the value associated with the column: district
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district
	 * @param district the district value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
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
	 * Return the value associated with the column: address_type_id
	 */
	public jkt.hms.masters.business.MasAddressType getAddressType () {
		return addressType;
	}

	/**
	 * Set the value related to the column: address_type_id
	 * @param addressType the address_type_id value
	 */
	public void setAddressType (jkt.hms.masters.business.MasAddressType addressType) {
		this.addressType = addressType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeeAddress)) return false;
		else {
			jkt.hms.masters.business.HrEmployeeAddress hrEmployeeAddress = (jkt.hms.masters.business.HrEmployeeAddress) obj;
			if (null == this.getId() || null == hrEmployeeAddress.getId()) return false;
			else return (this.getId().equals(hrEmployeeAddress.getId()));
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