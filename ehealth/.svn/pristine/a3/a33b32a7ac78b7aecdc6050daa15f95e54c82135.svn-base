package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mobile_registration table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mobile_registration"
 */

public abstract class BaseMobileRegistration  implements Serializable {

	public static String REF = "MobileRegistration";
	public static String PROP_VERIFIED_STATUS = "VerifiedStatus";
	public static String PROP_OTP_TIME = "OtpTime";
	public static String PROP_OTP = "Otp";
	public static String PROP_ID = "Id";
	public static String PROP_OTP_DATE = "OtpDate";
	public static String PROP_MOBILE_NO = "MobileNo";


	// constructors
	public BaseMobileRegistration () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMobileRegistration (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mobileNo;
	private java.lang.Integer otp;
	private java.util.Date otpDate;
	private java.lang.String otpTime;
	private java.lang.String verifiedStatus;



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
	 * Return the value associated with the column: mobile_no
	 */
	public java.lang.String getMobileNo () {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: mobile_no
	 * @param mobileNo the mobile_no value
	 */
	public void setMobileNo (java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}



	/**
	 * Return the value associated with the column: otp
	 */
	public java.lang.Integer getOtp () {
		return otp;
	}

	/**
	 * Set the value related to the column: otp
	 * @param otp the otp value
	 */
	public void setOtp (java.lang.Integer otp) {
		this.otp = otp;
	}



	/**
	 * Return the value associated with the column: otp_date
	 */
	public java.util.Date getOtpDate () {
		return otpDate;
	}

	/**
	 * Set the value related to the column: otp_date
	 * @param otpDate the otp_date value
	 */
	public void setOtpDate (java.util.Date otpDate) {
		this.otpDate = otpDate;
	}



	/**
	 * Return the value associated with the column: otp_time
	 */
	public java.lang.String getOtpTime () {
		return otpTime;
	}

	/**
	 * Set the value related to the column: otp_time
	 * @param otpTime the otp_time value
	 */
	public void setOtpTime (java.lang.String otpTime) {
		this.otpTime = otpTime;
	}



	/**
	 * Return the value associated with the column: verified_status
	 */
	public java.lang.String getVerifiedStatus () {
		return verifiedStatus;
	}

	/**
	 * Set the value related to the column: verified_status
	 * @param verifiedStatus the verified_status value
	 */
	public void setVerifiedStatus (java.lang.String verifiedStatus) {
		this.verifiedStatus = verifiedStatus;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MobileRegistration)) return false;
		else {
			jkt.hms.masters.business.MobileRegistration mobileRegistration = (jkt.hms.masters.business.MobileRegistration) obj;
			if (null == this.getId() || null == mobileRegistration.getId()) return false;
			else return (this.getId().equals(mobileRegistration.getId()));
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