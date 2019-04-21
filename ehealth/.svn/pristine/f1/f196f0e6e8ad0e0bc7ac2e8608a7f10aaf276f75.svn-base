package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_setup_parameter_maintaince table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_setup_parameter_maintaince"
 */

public abstract class BaseMasSetupParameterMaintaince  implements Serializable {

	public static String REF = "MasSetupParameterMaintaince";
	public static String PROP_ROL_DIVISION_FACTOR = "RolDivisionFactor";
	public static String PROP_SLOW_MOVING_PERCENT = "SlowMovingPercent";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_UPDATE_REG_CHARGE_CODE = "UpdateRegChargeCode";
	public static String PROP_ROQ_DIVISION_FACTOR = "RoqDivisionFactor";
	public static String PROP_FAST_MOVING_PERCENT = "FastMovingPercent";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LOGIN_IMAGE = "LoginImage";
	public static String PROP_CASTE = "Caste";
	public static String PROP_SERVER_PORT_NUMBER = "ServerPortNumber";
	public static String PROP_LICENSE_CODE = "LicenseCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VERSION = "Version";
	public static String PROP_NON_MOVING_PERCENT = "NonMovingPercent";
	public static String PROP_BLOCK = "Block";
	public static String PROP_RELATION = "Relation";
	public static String PROP_BLOOD_DON_GAP = "BloodDonGap";
	public static String PROP_MIN_AGE = "MinAge";
	public static String PROP_VISIT_CHARGE_CODE = "VisitChargeCode";
	public static String PROP_RELIGION = "Religion";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PO_SIGNATORY_OFFICER = "PoSignatoryOfficer";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_MONTH_OF_ROL = "MonthOfRol";
	public static String PROP_MAX_AGE = "MaxAge";
	public static String PROP_LOGIN_IMG_NAME = "LoginImgName";
	public static String PROP_REFRESH_TIME = "RefreshTime";
	public static String PROP_STATE = "State";
	public static String PROP_ID = "Id";
	public static String PROP_REFERENCE = "Reference";
	public static String PROP_LANGUAGE = "Language";
	public static String PROP_REG_CHARGE_CODE = "RegChargeCode";


	// constructors
	public BaseMasSetupParameterMaintaince () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSetupParameterMaintaince (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer minAge;
	private java.lang.Integer maxAge;
	private java.lang.Integer bloodDonGap;
	private java.lang.Integer refreshTime;
	private java.lang.String version;
	private byte[] loginImage;
	private java.lang.Integer monthOfRol;
	private java.lang.Integer roqDivisionFactor;
	private java.lang.Integer rolDivisionFactor;
	private java.lang.String licenseCode;
	private java.lang.Integer serverPortNumber;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String loginImgName;
	private java.lang.Integer slowMovingPercent;
	private java.lang.Integer fastMovingPercent;
	private java.lang.Integer nonMovingPercent;
	private java.lang.String poSignatoryOfficer;

	// many to one
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasLanguage language;
	private jkt.hms.masters.business.MasReligion religion;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasCaste caste;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasReference reference;
	private jkt.hms.masters.business.MasChargeCode visitChargeCode;
	private jkt.hms.masters.business.MasChargeCode regChargeCode;
	private jkt.hms.masters.business.MasChargeCode updateRegChargeCode;
	private jkt.hms.masters.business.MasBlock block;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="setup_parammeter_id"
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
	 * Return the value associated with the column: min_age
	 */
	public java.lang.Integer getMinAge () {
		return minAge;
	}

	/**
	 * Set the value related to the column: min_age
	 * @param minAge the min_age value
	 */
	public void setMinAge (java.lang.Integer minAge) {
		this.minAge = minAge;
	}



	/**
	 * Return the value associated with the column: max_age
	 */
	public java.lang.Integer getMaxAge () {
		return maxAge;
	}

	/**
	 * Set the value related to the column: max_age
	 * @param maxAge the max_age value
	 */
	public void setMaxAge (java.lang.Integer maxAge) {
		this.maxAge = maxAge;
	}



	/**
	 * Return the value associated with the column: blood_don_gap
	 */
	public java.lang.Integer getBloodDonGap () {
		return bloodDonGap;
	}

	/**
	 * Set the value related to the column: blood_don_gap
	 * @param bloodDonGap the blood_don_gap value
	 */
	public void setBloodDonGap (java.lang.Integer bloodDonGap) {
		this.bloodDonGap = bloodDonGap;
	}



	/**
	 * Return the value associated with the column: refresh_time
	 */
	public java.lang.Integer getRefreshTime () {
		return refreshTime;
	}

	/**
	 * Set the value related to the column: refresh_time
	 * @param refreshTime the refresh_time value
	 */
	public void setRefreshTime (java.lang.Integer refreshTime) {
		this.refreshTime = refreshTime;
	}



	/**
	 * Return the value associated with the column: version
	 */
	public java.lang.String getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: version
	 * @param version the version value
	 */
	public void setVersion (java.lang.String version) {
		this.version = version;
	}



	/**
	 * Return the value associated with the column: login_image
	 */
	public byte[] getLoginImage () {
		return loginImage;
	}

	/**
	 * Set the value related to the column: login_image
	 * @param loginImage the login_image value
	 */
	public void setLoginImage (byte[] loginImage) {
		this.loginImage = loginImage;
	}



	/**
	 * Return the value associated with the column: month_of_rol
	 */
	public java.lang.Integer getMonthOfRol () {
		return monthOfRol;
	}

	/**
	 * Set the value related to the column: month_of_rol
	 * @param monthOfRol the month_of_rol value
	 */
	public void setMonthOfRol (java.lang.Integer monthOfRol) {
		this.monthOfRol = monthOfRol;
	}



	/**
	 * Return the value associated with the column: roq_division_factor
	 */
	public java.lang.Integer getRoqDivisionFactor () {
		return roqDivisionFactor;
	}

	/**
	 * Set the value related to the column: roq_division_factor
	 * @param roqDivisionFactor the roq_division_factor value
	 */
	public void setRoqDivisionFactor (java.lang.Integer roqDivisionFactor) {
		this.roqDivisionFactor = roqDivisionFactor;
	}



	/**
	 * Return the value associated with the column: rol_division_factor
	 */
	public java.lang.Integer getRolDivisionFactor () {
		return rolDivisionFactor;
	}

	/**
	 * Set the value related to the column: rol_division_factor
	 * @param rolDivisionFactor the rol_division_factor value
	 */
	public void setRolDivisionFactor (java.lang.Integer rolDivisionFactor) {
		this.rolDivisionFactor = rolDivisionFactor;
	}



	/**
	 * Return the value associated with the column: license_code
	 */
	public java.lang.String getLicenseCode () {
		return licenseCode;
	}

	/**
	 * Set the value related to the column: license_code
	 * @param licenseCode the license_code value
	 */
	public void setLicenseCode (java.lang.String licenseCode) {
		this.licenseCode = licenseCode;
	}



	/**
	 * Return the value associated with the column: server_port_number
	 */
	public java.lang.Integer getServerPortNumber () {
		return serverPortNumber;
	}

	/**
	 * Set the value related to the column: server_port_number
	 * @param serverPortNumber the server_port_number value
	 */
	public void setServerPortNumber (java.lang.Integer serverPortNumber) {
		this.serverPortNumber = serverPortNumber;
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
	 * Return the value associated with the column: login_img_name
	 */
	public java.lang.String getLoginImgName () {
		return loginImgName;
	}

	/**
	 * Set the value related to the column: login_img_name
	 * @param loginImgName the login_img_name value
	 */
	public void setLoginImgName (java.lang.String loginImgName) {
		this.loginImgName = loginImgName;
	}



	/**
	 * Return the value associated with the column: slow_moving
	 */
	public java.lang.Integer getSlowMovingPercent () {
		return slowMovingPercent;
	}

	/**
	 * Set the value related to the column: slow_moving
	 * @param slowMovingPercent the slow_moving value
	 */
	public void setSlowMovingPercent (java.lang.Integer slowMovingPercent) {
		this.slowMovingPercent = slowMovingPercent;
	}



	/**
	 * Return the value associated with the column: fast_moving
	 */
	public java.lang.Integer getFastMovingPercent () {
		return fastMovingPercent;
	}

	/**
	 * Set the value related to the column: fast_moving
	 * @param fastMovingPercent the fast_moving value
	 */
	public void setFastMovingPercent (java.lang.Integer fastMovingPercent) {
		this.fastMovingPercent = fastMovingPercent;
	}



	/**
	 * Return the value associated with the column: non_moving
	 */
	public java.lang.Integer getNonMovingPercent () {
		return nonMovingPercent;
	}

	/**
	 * Set the value related to the column: non_moving
	 * @param nonMovingPercent the non_moving value
	 */
	public void setNonMovingPercent (java.lang.Integer nonMovingPercent) {
		this.nonMovingPercent = nonMovingPercent;
	}



	/**
	 * Return the value associated with the column: po_signatory
	 */
	public java.lang.String getPoSignatoryOfficer () {
		return poSignatoryOfficer;
	}

	/**
	 * Set the value related to the column: po_signatory
	 * @param poSignatoryOfficer the po_signatory value
	 */
	public void setPoSignatoryOfficer (java.lang.String poSignatoryOfficer) {
		this.poSignatoryOfficer = poSignatoryOfficer;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
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
	 * Return the value associated with the column: language_id
	 */
	public jkt.hms.masters.business.MasLanguage getLanguage () {
		return language;
	}

	/**
	 * Set the value related to the column: language_id
	 * @param language the language_id value
	 */
	public void setLanguage (jkt.hms.masters.business.MasLanguage language) {
		this.language = language;
	}



	/**
	 * Return the value associated with the column: religion_id
	 */
	public jkt.hms.masters.business.MasReligion getReligion () {
		return religion;
	}

	/**
	 * Set the value related to the column: religion_id
	 * @param religion the religion_id value
	 */
	public void setReligion (jkt.hms.masters.business.MasReligion religion) {
		this.religion = religion;
	}



	/**
	 * Return the value associated with the column: last_chg_by_id
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by_id
	 * @param lastChgBy the last_chg_by_id value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: caste_id
	 */
	public jkt.hms.masters.business.MasCaste getCaste () {
		return caste;
	}

	/**
	 * Set the value related to the column: caste_id
	 * @param caste the caste_id value
	 */
	public void setCaste (jkt.hms.masters.business.MasCaste caste) {
		this.caste = caste;
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
	 * Return the value associated with the column: country_id
	 */
	public jkt.hms.masters.business.MasCountry getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country_id
	 * @param country the country_id value
	 */
	public void setCountry (jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: reference_id
	 */
	public jkt.hms.masters.business.MasReference getReference () {
		return reference;
	}

	/**
	 * Set the value related to the column: reference_id
	 * @param reference the reference_id value
	 */
	public void setReference (jkt.hms.masters.business.MasReference reference) {
		this.reference = reference;
	}



	/**
	 * Return the value associated with the column: visit_charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getVisitChargeCode () {
		return visitChargeCode;
	}

	/**
	 * Set the value related to the column: visit_charge_code_id
	 * @param visitChargeCode the visit_charge_code_id value
	 */
	public void setVisitChargeCode (jkt.hms.masters.business.MasChargeCode visitChargeCode) {
		this.visitChargeCode = visitChargeCode;
	}



	/**
	 * Return the value associated with the column: reg_charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getRegChargeCode () {
		return regChargeCode;
	}

	/**
	 * Set the value related to the column: reg_charge_code_id
	 * @param regChargeCode the reg_charge_code_id value
	 */
	public void setRegChargeCode (jkt.hms.masters.business.MasChargeCode regChargeCode) {
		this.regChargeCode = regChargeCode;
	}



	/**
	 * Return the value associated with the column: update_reg_charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getUpdateRegChargeCode () {
		return updateRegChargeCode;
	}

	/**
	 * Set the value related to the column: update_reg_charge_code_id
	 * @param updateRegChargeCode the update_reg_charge_code_id value
	 */
	public void setUpdateRegChargeCode (jkt.hms.masters.business.MasChargeCode updateRegChargeCode) {
		this.updateRegChargeCode = updateRegChargeCode;
	}



	/**
	 * Return the value associated with the column: block_id
	 */
	public jkt.hms.masters.business.MasBlock getBlock () {
		return block;
	}

	/**
	 * Set the value related to the column: block_id
	 * @param block the block_id value
	 */
	public void setBlock (jkt.hms.masters.business.MasBlock block) {
		this.block = block;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSetupParameterMaintaince)) return false;
		else {
			jkt.hms.masters.business.MasSetupParameterMaintaince masSetupParameterMaintaince = (jkt.hms.masters.business.MasSetupParameterMaintaince) obj;
			if (null == this.getId() || null == masSetupParameterMaintaince.getId()) return false;
			else return (this.getId().equals(masSetupParameterMaintaince.getId()));
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