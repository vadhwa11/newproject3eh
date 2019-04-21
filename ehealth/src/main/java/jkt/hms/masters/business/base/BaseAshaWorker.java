package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the asha_worker table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="asha_worker"
 */

public abstract class BaseAshaWorker  implements Serializable {

	public static String REF = "AshaWorker";
	public static String PROP_QUALIFICATION = "Qualification";
	public static String PROP_ASHA_NAME = "AshaName";
	public static String PROP_HOSPITAL_TYPE = "HospitalType";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ASHA_CODE = "AshaCode";
	public static String PROP_BANK_ACCOUNT = "BankAccount";
	public static String PROP_ID = "Id";
	public static String PROP_BANK_NAME = "BankName";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_LSG = "Lsg";
	public static String PROP_IFSC = "Ifsc";


	// constructors
	public BaseAshaWorker () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAshaWorker (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ashaCode;
	private java.lang.String ashaName;
	private java.lang.String contactNo;
	private java.lang.String bankAccount;
	private java.lang.String bankName;
	private java.lang.String ifsc;

	// many to one
	private jkt.hrms.masters.business.MasQualification qualification;
	private jkt.hms.masters.business.MasLsg lsg;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasHospitalType hospitalType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="asha_id"
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
	 * Return the value associated with the column: asha_code
	 */
	public java.lang.String getAshaCode () {
		return ashaCode;
	}

	/**
	 * Set the value related to the column: asha_code
	 * @param ashaCode the asha_code value
	 */
	public void setAshaCode (java.lang.String ashaCode) {
		this.ashaCode = ashaCode;
	}



	/**
	 * Return the value associated with the column: asha_name
	 */
	public java.lang.String getAshaName () {
		return ashaName;
	}

	/**
	 * Set the value related to the column: asha_name
	 * @param ashaName the asha_name value
	 */
	public void setAshaName (java.lang.String ashaName) {
		this.ashaName = ashaName;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: bank_account
	 */
	public java.lang.String getBankAccount () {
		return bankAccount;
	}

	/**
	 * Set the value related to the column: bank_account
	 * @param bankAccount the bank_account value
	 */
	public void setBankAccount (java.lang.String bankAccount) {
		this.bankAccount = bankAccount;
	}



	/**
	 * Return the value associated with the column: bank_name
	 */
	public java.lang.String getBankName () {
		return bankName;
	}

	/**
	 * Set the value related to the column: bank_name
	 * @param bankName the bank_name value
	 */
	public void setBankName (java.lang.String bankName) {
		this.bankName = bankName;
	}



	/**
	 * Return the value associated with the column: ifsc
	 */
	public java.lang.String getIfsc () {
		return ifsc;
	}

	/**
	 * Set the value related to the column: ifsc
	 * @param ifsc the ifsc value
	 */
	public void setIfsc (java.lang.String ifsc) {
		this.ifsc = ifsc;
	}



	/**
	 * Return the value associated with the column: qualification
	 */
	public jkt.hrms.masters.business.MasQualification getQualification () {
		return qualification;
	}

	/**
	 * Set the value related to the column: qualification
	 * @param qualification the qualification value
	 */
	public void setQualification (jkt.hrms.masters.business.MasQualification qualification) {
		this.qualification = qualification;
	}



	/**
	 * Return the value associated with the column: lsg_id
	 */
	public jkt.hms.masters.business.MasLsg getLsg () {
		return lsg;
	}

	/**
	 * Set the value related to the column: lsg_id
	 * @param lsg the lsg_id value
	 */
	public void setLsg (jkt.hms.masters.business.MasLsg lsg) {
		this.lsg = lsg;
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
	 * Return the value associated with the column: hospital_type_id
	 */
	public jkt.hms.masters.business.MasHospitalType getHospitalType () {
		return hospitalType;
	}

	/**
	 * Set the value related to the column: hospital_type_id
	 * @param hospitalType the hospital_type_id value
	 */
	public void setHospitalType (jkt.hms.masters.business.MasHospitalType hospitalType) {
		this.hospitalType = hospitalType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AshaWorker)) return false;
		else {
			jkt.hms.masters.business.AshaWorker ashaWorker = (jkt.hms.masters.business.AshaWorker) obj;
			if (null == this.getId() || null == ashaWorker.getId()) return false;
			else return (this.getId().equals(ashaWorker.getId()));
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