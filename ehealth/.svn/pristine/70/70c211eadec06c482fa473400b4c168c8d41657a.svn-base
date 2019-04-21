package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_bed table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_bed"
 */

public abstract class BaseMasBed  implements Serializable {

	public static String REF = "MasBed";
	public static String PROP_FLAG = "Flag";
	public static String PROP_INTRODUCTION_DATE = "IntroductionDate";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_ATTACHED = "Attached";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_STATUS = "Status";
	public static String PROP_ROOM = "Room";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BED_NO = "BedNo";
	public static String PROP_BED_TYPE = "BedType";
	public static String PROP_BED_STATUS = "BedStatus";
	public static String PROP_V_BED = "VBed";
	public static String PROP_DIET_TYPE = "DietType";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DISCARD_DATE = "DiscardDate";


	// constructors
	public BaseMasBed () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBed (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bedNo;
	private java.util.Date introductionDate;
	private java.util.Date discardDate;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String adNo;
	private java.lang.String dietType;
	private java.lang.String attached;
	private java.lang.String bedType;
	private java.lang.String flag;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasRoom room;
	private jkt.hms.masters.business.MasBed vBed;
	private jkt.hms.masters.business.MasBedStatus bedStatus;

	// collections
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfersByToBed;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfersByFromBed;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.OtMasUnitDay> otMasUnitDays;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="bed_id"
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
	 * Return the value associated with the column: bed_no
	 */
	public java.lang.String getBedNo () {
		return bedNo;
	}

	/**
	 * Set the value related to the column: bed_no
	 * @param bedNo the bed_no value
	 */
	public void setBedNo (java.lang.String bedNo) {
		this.bedNo = bedNo;
	}



	/**
	 * Return the value associated with the column: introduction_date
	 */
	public java.util.Date getIntroductionDate () {
		return introductionDate;
	}

	/**
	 * Set the value related to the column: introduction_date
	 * @param introductionDate the introduction_date value
	 */
	public void setIntroductionDate (java.util.Date introductionDate) {
		this.introductionDate = introductionDate;
	}



	/**
	 * Return the value associated with the column: discard_date
	 */
	public java.util.Date getDiscardDate () {
		return discardDate;
	}

	/**
	 * Set the value related to the column: discard_date
	 * @param discardDate the discard_date value
	 */
	public void setDiscardDate (java.util.Date discardDate) {
		this.discardDate = discardDate;
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: diet_type
	 */
	public java.lang.String getDietType () {
		return dietType;
	}

	/**
	 * Set the value related to the column: diet_type
	 * @param dietType the diet_type value
	 */
	public void setDietType (java.lang.String dietType) {
		this.dietType = dietType;
	}



	/**
	 * Return the value associated with the column: attached
	 */
	public java.lang.String getAttached () {
		return attached;
	}

	/**
	 * Set the value related to the column: attached
	 * @param attached the attached value
	 */
	public void setAttached (java.lang.String attached) {
		this.attached = attached;
	}



	/**
	 * Return the value associated with the column: bed_type
	 */
	public java.lang.String getBedType () {
		return bedType;
	}

	/**
	 * Set the value related to the column: bed_type
	 * @param bedType the bed_type value
	 */
	public void setBedType (java.lang.String bedType) {
		this.bedType = bedType;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
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



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: room_id
	 */
	public jkt.hms.masters.business.MasRoom getRoom () {
		return room;
	}

	/**
	 * Set the value related to the column: room_id
	 * @param room the room_id value
	 */
	public void setRoom (jkt.hms.masters.business.MasRoom room) {
		this.room = room;
	}



	/**
	 * Return the value associated with the column: v_bed_id
	 */
	public jkt.hms.masters.business.MasBed getVBed () {
		return vBed;
	}

	/**
	 * Set the value related to the column: v_bed_id
	 * @param vBed the v_bed_id value
	 */
	public void setVBed (jkt.hms.masters.business.MasBed vBed) {
		this.vBed = vBed;
	}



	/**
	 * Return the value associated with the column: bed_status_id
	 */
	public jkt.hms.masters.business.MasBedStatus getBedStatus () {
		return bedStatus;
	}

	/**
	 * Set the value related to the column: bed_status_id
	 * @param bedStatus the bed_status_id value
	 */
	public void setBedStatus (jkt.hms.masters.business.MasBedStatus bedStatus) {
		this.bedStatus = bedStatus;
	}



	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set<jkt.hms.masters.business.AttachInpatient> getAttachInpatients () {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * @param attachInpatients the AttachInpatients value
	 */
	public void setAttachInpatients (java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients (jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients()) setAttachInpatients(new java.util.TreeSet<jkt.hms.masters.business.AttachInpatient>());
		getAttachInpatients().add(attachInpatient);
	}



	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients () {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * @param inpatients the Inpatients value
	 */
	public void setInpatients (java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients (jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients()) setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}



	/**
	 * Return the value associated with the column: TransfersByToBed
	 */
	public java.util.Set<jkt.hms.masters.business.Transfer> getTransfersByToBed () {
		return transfersByToBed;
	}

	/**
	 * Set the value related to the column: TransfersByToBed
	 * @param transfersByToBed the TransfersByToBed value
	 */
	public void setTransfersByToBed (java.util.Set<jkt.hms.masters.business.Transfer> transfersByToBed) {
		this.transfersByToBed = transfersByToBed;
	}

	public void addToTransfersByToBed (jkt.hms.masters.business.Transfer transfer) {
		if (null == getTransfersByToBed()) setTransfersByToBed(new java.util.TreeSet<jkt.hms.masters.business.Transfer>());
		getTransfersByToBed().add(transfer);
	}



	/**
	 * Return the value associated with the column: TransfersByFromBed
	 */
	public java.util.Set<jkt.hms.masters.business.Transfer> getTransfersByFromBed () {
		return transfersByFromBed;
	}

	/**
	 * Set the value related to the column: TransfersByFromBed
	 * @param transfersByFromBed the TransfersByFromBed value
	 */
	public void setTransfersByFromBed (java.util.Set<jkt.hms.masters.business.Transfer> transfersByFromBed) {
		this.transfersByFromBed = transfersByFromBed;
	}

	public void addToTransfersByFromBed (jkt.hms.masters.business.Transfer transfer) {
		if (null == getTransfersByFromBed()) setTransfersByFromBed(new java.util.TreeSet<jkt.hms.masters.business.Transfer>());
		getTransfersByFromBed().add(transfer);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}



	/**
	 * Return the value associated with the column: OtMasUnitDays
	 */
	public java.util.Set<jkt.hms.masters.business.OtMasUnitDay> getOtMasUnitDays () {
		return otMasUnitDays;
	}

	/**
	 * Set the value related to the column: OtMasUnitDays
	 * @param otMasUnitDays the OtMasUnitDays value
	 */
	public void setOtMasUnitDays (java.util.Set<jkt.hms.masters.business.OtMasUnitDay> otMasUnitDays) {
		this.otMasUnitDays = otMasUnitDays;
	}

	public void addToOtMasUnitDays (jkt.hms.masters.business.OtMasUnitDay otMasUnitDay) {
		if (null == getOtMasUnitDays()) setOtMasUnitDays(new java.util.TreeSet<jkt.hms.masters.business.OtMasUnitDay>());
		getOtMasUnitDays().add(otMasUnitDay);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBed)) return false;
		else {
			jkt.hms.masters.business.MasBed masBed = (jkt.hms.masters.business.MasBed) obj;
			if (null == this.getId() || null == masBed.getId()) return false;
			else return (this.getId().equals(masBed.getId()));
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