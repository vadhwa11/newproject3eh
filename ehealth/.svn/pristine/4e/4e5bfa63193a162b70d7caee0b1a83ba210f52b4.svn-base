package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_empaneled table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_empaneled"
 */

public abstract class BaseMasEmpaneled  implements Serializable {

	public static String REF = "MasEmpaneled";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_LICENCE_NO = "LicenceNo";
	public static String PROP_CONTACT_PERSON = "ContactPerson";
	public static String PROP_LOGIN_NAME = "LoginName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_EMPANELED_CODE = "EmpaneledCode";
	public static String PROP_CITY = "City";
	public static String PROP_STATUS = "Status";
	public static String PROP_CP_MOBILE_NO = "CpMobileNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_MOBILENO = "Mobileno";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_EMPANELED_NAME = "EmpaneledName";
	public static String PROP_TIN_NO = "TinNo";
	public static String PROP_ID = "Id";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasEmpaneled () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmpaneled (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasEmpaneled (
		java.lang.Integer id,
		java.lang.String loginName,
		java.lang.String password) {

		this.setId(id);
		this.setLoginName(loginName);
		this.setPassword(password);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String empaneledCode;
	private java.lang.String empaneledName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String address;
	private java.lang.Integer pinCode;
	private java.lang.String mobileno;
	private java.lang.String licenceNo;
	private java.lang.Integer tinNo;
	private java.lang.String contactPerson;
	private java.lang.String cpMobileNo;
	private java.lang.String emailId;
	private java.lang.String loginName;
	private java.lang.String password;

	// many to one
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasEmpaneledHospital> masEmpaneledHospitals;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="empaneled_id"
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
	 * Return the value associated with the column: empaneled_code
	 */
	public java.lang.String getEmpaneledCode () {
		return empaneledCode;
	}

	/**
	 * Set the value related to the column: empaneled_code
	 * @param empaneledCode the empaneled_code value
	 */
	public void setEmpaneledCode (java.lang.String empaneledCode) {
		this.empaneledCode = empaneledCode;
	}



	/**
	 * Return the value associated with the column: empaneled_name
	 */
	public java.lang.String getEmpaneledName () {
		return empaneledName;
	}

	/**
	 * Set the value related to the column: empaneled_name
	 * @param empaneledName the empaneled_name value
	 */
	public void setEmpaneledName (java.lang.String empaneledName) {
		this.empaneledName = empaneledName;
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
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
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
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.Integer getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * @param pinCode the pin_code value
	 */
	public void setPinCode (java.lang.Integer pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * Return the value associated with the column: mobileno
	 */
	public java.lang.String getMobileno () {
		return mobileno;
	}

	/**
	 * Set the value related to the column: mobileno
	 * @param mobileno the mobileno value
	 */
	public void setMobileno (java.lang.String mobileno) {
		this.mobileno = mobileno;
	}



	/**
	 * Return the value associated with the column: licence_no
	 */
	public java.lang.String getLicenceNo () {
		return licenceNo;
	}

	/**
	 * Set the value related to the column: licence_no
	 * @param licenceNo the licence_no value
	 */
	public void setLicenceNo (java.lang.String licenceNo) {
		this.licenceNo = licenceNo;
	}



	/**
	 * Return the value associated with the column: tin_no
	 */
	public java.lang.Integer getTinNo () {
		return tinNo;
	}

	/**
	 * Set the value related to the column: tin_no
	 * @param tinNo the tin_no value
	 */
	public void setTinNo (java.lang.Integer tinNo) {
		this.tinNo = tinNo;
	}



	/**
	 * Return the value associated with the column: contact_person
	 */
	public java.lang.String getContactPerson () {
		return contactPerson;
	}

	/**
	 * Set the value related to the column: contact_person
	 * @param contactPerson the contact_person value
	 */
	public void setContactPerson (java.lang.String contactPerson) {
		this.contactPerson = contactPerson;
	}



	/**
	 * Return the value associated with the column: cp_mobile_no
	 */
	public java.lang.String getCpMobileNo () {
		return cpMobileNo;
	}

	/**
	 * Set the value related to the column: cp_mobile_no
	 * @param cpMobileNo the cp_mobile_no value
	 */
	public void setCpMobileNo (java.lang.String cpMobileNo) {
		this.cpMobileNo = cpMobileNo;
	}



	/**
	 * Return the value associated with the column: email_id
	 */
	public java.lang.String getEmailId () {
		return emailId;
	}

	/**
	 * Set the value related to the column: email_id
	 * @param emailId the email_id value
	 */
	public void setEmailId (java.lang.String emailId) {
		this.emailId = emailId;
	}



	/**
	 * Return the value associated with the column: login_name
	 */
	public java.lang.String getLoginName () {
		return loginName;
	}

	/**
	 * Set the value related to the column: login_name
	 * @param loginName the login_name value
	 */
	public void setLoginName (java.lang.String loginName) {
		this.loginName = loginName;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: city_id
	 */
	public jkt.hms.masters.business.MasDistrict getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city_id
	 * @param city the city_id value
	 */
	public void setCity (jkt.hms.masters.business.MasDistrict city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param state the state_id value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}
	  
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: MasEmpaneledHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmpaneledHospital> getMasEmpaneledHospitals () {
		return masEmpaneledHospitals;
	}

	/**
	 * Set the value related to the column: MasEmpaneledHospitals
	 * @param masEmpaneledHospitals the MasEmpaneledHospitals value
	 */
	public void setMasEmpaneledHospitals (java.util.Set<jkt.hms.masters.business.MasEmpaneledHospital> masEmpaneledHospitals) {
		this.masEmpaneledHospitals = masEmpaneledHospitals;
	}

	public void addToMasEmpaneledHospitals (jkt.hms.masters.business.MasEmpaneledHospital masEmpaneledHospital) {
		if (null == getMasEmpaneledHospitals()) setMasEmpaneledHospitals(new java.util.TreeSet<jkt.hms.masters.business.MasEmpaneledHospital>());
		getMasEmpaneledHospitals().add(masEmpaneledHospital);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasEmpaneled)) return false;
		else {
			jkt.hms.masters.business.MasEmpaneled masEmpaneled = (jkt.hms.masters.business.MasEmpaneled) obj;
			if (null == this.getId() || null == masEmpaneled.getId()) return false;
			else return (this.getId().equals(masEmpaneled.getId()));
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