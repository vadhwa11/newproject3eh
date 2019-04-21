package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_family_planing_reg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_family_planing_reg"
 */

public abstract class BasePhFamilyPlaningReg  implements Serializable {

	public static String REF = "PhFamilyPlaningReg";
	public static String PROP_OTHER_METHOD = "OtherMethod";
	public static String PROP_HUSBAND_ID = "HusbandId";
	public static String PROP_FAMILY_ID = "FamilyId";
	public static String PROP_FPA_DATE = "FpaDate";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LONG_LAT = "LongLat";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ECR_ID = "EcrId";
	public static String PROP_PERM_METHODS = "PermMethods";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TEMP_METHODS = "TempMethods";
	public static String PROP_DT_ADOTED_PERM_METHOD = "DtAdotedPermMethod";
	public static String PROP_ID = "Id";
	public static String PROP_WIFE_ID = "WifeId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PLACE_PROCEDURE_DONE = "PlaceProcedureDone";


	// constructors
	public BasePhFamilyPlaningReg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhFamilyPlaningReg (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String familyId;
	private java.lang.String husbandId;
	private java.lang.String wifeId;
	private java.lang.String ecrId;
	private java.lang.Long contactNo;
	private java.util.Date fpaDate;
	private java.lang.String tempMethods;
	private java.lang.String permMethods;
	private java.lang.String otherMethod;
	private java.lang.String dtAdotedPermMethod;
	private java.lang.String placeProcedureDone;
	private java.lang.String complications;
	private java.lang.String remarks;
	private java.lang.String longLat;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="planing_reg_id"
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
	 * Return the value associated with the column: family_id
	 */
	public java.lang.String getFamilyId () {
		return familyId;
	}

	/**
	 * Set the value related to the column: family_id
	 * @param familyId the family_id value
	 */
	public void setFamilyId (java.lang.String familyId) {
		this.familyId = familyId;
	}



	/**
	 * Return the value associated with the column: husband_id
	 */
	public java.lang.String getHusbandId () {
		return husbandId;
	}

	/**
	 * Set the value related to the column: husband_id
	 * @param husbandId the husband_id value
	 */
	public void setHusbandId (java.lang.String husbandId) {
		this.husbandId = husbandId;
	}



	/**
	 * Return the value associated with the column: wife_id
	 */
	public java.lang.String getWifeId () {
		return wifeId;
	}

	/**
	 * Set the value related to the column: wife_id
	 * @param wifeId the wife_id value
	 */
	public void setWifeId (java.lang.String wifeId) {
		this.wifeId = wifeId;
	}



	/**
	 * Return the value associated with the column: ecr_id
	 */
	public java.lang.String getEcrId () {
		return ecrId;
	}

	/**
	 * Set the value related to the column: ecr_id
	 * @param ecrId the ecr_id value
	 */
	public void setEcrId (java.lang.String ecrId) {
		this.ecrId = ecrId;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.Long getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.Long contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: fpa_date
	 */
	public java.util.Date getFpaDate () {
		return fpaDate;
	}

	/**
	 * Set the value related to the column: fpa_date
	 * @param fpaDate the fpa_date value
	 */
	public void setFpaDate (java.util.Date fpaDate) {
		this.fpaDate = fpaDate;
	}



	/**
	 * Return the value associated with the column: temp_methods
	 */
	public java.lang.String getTempMethods () {
		return tempMethods;
	}

	/**
	 * Set the value related to the column: temp_methods
	 * @param tempMethods the temp_methods value
	 */
	public void setTempMethods (java.lang.String tempMethods) {
		this.tempMethods = tempMethods;
	}



	/**
	 * Return the value associated with the column: perm_methods
	 */
	public java.lang.String getPermMethods () {
		return permMethods;
	}

	/**
	 * Set the value related to the column: perm_methods
	 * @param permMethods the perm_methods value
	 */
	public void setPermMethods (java.lang.String permMethods) {
		this.permMethods = permMethods;
	}



	/**
	 * Return the value associated with the column: other_method
	 */
	public java.lang.String getOtherMethod () {
		return otherMethod;
	}

	/**
	 * Set the value related to the column: other_method
	 * @param otherMethod the other_method value
	 */
	public void setOtherMethod (java.lang.String otherMethod) {
		this.otherMethod = otherMethod;
	}



	/**
	 * Return the value associated with the column: dt_adoted_perm_method
	 */
	public java.lang.String getDtAdotedPermMethod () {
		return dtAdotedPermMethod;
	}

	/**
	 * Set the value related to the column: dt_adoted_perm_method
	 * @param dtAdotedPermMethod the dt_adoted_perm_method value
	 */
	public void setDtAdotedPermMethod (java.lang.String dtAdotedPermMethod) {
		this.dtAdotedPermMethod = dtAdotedPermMethod;
	}



	/**
	 * Return the value associated with the column: place_procedure_done
	 */
	public java.lang.String getPlaceProcedureDone () {
		return placeProcedureDone;
	}

	/**
	 * Set the value related to the column: place_procedure_done
	 * @param placeProcedureDone the place_procedure_done value
	 */
	public void setPlaceProcedureDone (java.lang.String placeProcedureDone) {
		this.placeProcedureDone = placeProcedureDone;
	}



	/**
	 * Return the value associated with the column: complications
	 */
	public java.lang.String getComplications () {
		return complications;
	}

	/**
	 * Set the value related to the column: complications
	 * @param complications the complications value
	 */
	public void setComplications (java.lang.String complications) {
		this.complications = complications;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: long_lat
	 */
	public java.lang.String getLongLat () {
		return longLat;
	}

	/**
	 * Set the value related to the column: long_lat
	 * @param longLat the long_lat value
	 */
	public void setLongLat (java.lang.String longLat) {
		this.longLat = longLat;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhFamilyPlaningReg)) return false;
		else {
			jkt.hms.masters.business.PhFamilyPlaningReg phFamilyPlaningReg = (jkt.hms.masters.business.PhFamilyPlaningReg) obj;
			if (null == this.getId() || null == phFamilyPlaningReg.getId()) return false;
			else return (this.getId().equals(phFamilyPlaningReg.getId()));
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