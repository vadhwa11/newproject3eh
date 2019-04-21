package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_reaction_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_reaction_entry"
 */

public abstract class BaseBloodReactionEntry  implements Serializable {

	public static String REF = "BloodReactionEntry";
	public static String PROP_PAIN_HEAD = "PainHead";
	public static String PROP_RASH_ITCHING = "RashItching";
	public static String PROP_PAIN_BACK = "PainBack";
	public static String PROP_PAIN_CHEST = "PainChest";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ISSUED_DATE = "IssuedDate";
	public static String PROP_TIME_STARTED = "TimeStarted";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_BLOOD_BAG_NO = "BloodBagNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TEMP_DURING_TRANSFUSION = "TempDuringTransfusion";
	public static String PROP_WD_NO = "WdNo";
	public static String PROP_BLOOD_BANK_ID = "BloodBankId";
	public static String PROP_ISSUED_TIME = "IssuedTime";
	public static String PROP_PULMONARY_OEDEMA = "PulmonaryOedema";
	public static String PROP_SCREENING = "Screening";
	public static String PROP_QUANTITY_GIVEN = "QuantityGiven";
	public static String PROP_HAEMOGLOBINUANA = "Haemoglobinuana";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_ID = "Id";
	public static String PROP_TRANSFUSSION = "Transfussion";
	public static String PROP_BP_MAX = "BpMax";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_RACTION_DATE = "RactionDate";
	public static String PROP_PULSE_AFTER_TRANSFUSION = "PulseAfterTransfusion";
	public static String PROP_CHILLS = "Chills";
	public static String PROP_BP_MIN = "BpMin";
	public static String PROP_BP_MAX_AFTER_TRANSFUSION = "BpMaxAfterTransfusion";
	public static String PROP_TEMP_AFTER_TRANSFUSION = "TempAfterTransfusion";
	public static String PROP_ISSUED_TO = "IssuedTo";
	public static String PROP_TIME_COMPLETED = "TimeCompleted";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RISE_TEMP = "RiseTemp";
	public static String PROP_JAUNDICE = "Jaundice";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DONOR_NAME = "DonorName";
	public static String PROP_CROSS_MATCHED_BY = "CrossMatchedBy";
	public static String PROP_BP_MAX_DURING_TRANSFUSION = "BpMaxDuringTransfusion";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_RIGOR = "Rigor";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_PAIN_ELSEWHERE = "PainElsewhere";
	public static String PROP_ANY_OTHER_SIGNS = "AnyOtherSigns";
	public static String PROP_HIN = "Hin";
	public static String PROP_PULSE_DURING_TRANSFUSION = "PulseDuringTransfusion";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BP_MIN_AFTER_TRANSFUSION = "BpMinAfterTransfusion";
	public static String PROP_BP_MIN_DURING_TRANSFUSION = "BpMinDuringTransfusion";
	public static String PROP_DATE_TRANSFUSSION = "DateTransfussion";
	public static String PROP_ISSUED_BY = "IssuedBy";


	// constructors
	public BaseBloodReactionEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodReactionEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date ractionDate;
	private java.lang.String bloodBagNo;
	private java.util.Date issuedDate;
	private java.lang.String issuedTime;
	private java.lang.String donorName;
	private java.lang.String issuedTo;
	private java.lang.String wdNo;
	private java.lang.String transfussion;
	private java.util.Date dateTransfussion;
	private java.lang.String timeStarted;
	private java.lang.String timeCompleted;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String riseTemp;
	private java.lang.String remarks;
	private java.math.BigDecimal temperature;
	private java.lang.Integer pulse;
	private java.lang.Integer bpMin;
	private java.lang.Integer bpMax;
	private java.lang.String screening;
	private java.math.BigDecimal tempDuringTransfusion;
	private java.lang.Integer pulseDuringTransfusion;
	private java.lang.Integer bpMinDuringTransfusion;
	private java.lang.Integer bpMaxDuringTransfusion;
	private java.math.BigDecimal tempAfterTransfusion;
	private java.lang.Integer pulseAfterTransfusion;
	private java.lang.Integer bpMinAfterTransfusion;
	private java.lang.Integer bpMaxAfterTransfusion;
	private java.lang.String chills;
	private java.lang.String rigor;
	private java.lang.String rashItching;
	private java.lang.String painBack;
	private java.lang.String painChest;
	private java.lang.String painHead;
	private java.lang.String painElsewhere;
	private java.lang.String haemoglobinuana;
	private java.lang.String pulmonaryOedema;
	private java.lang.String jaundice;
	private java.lang.String anyOtherSigns;
	private java.lang.String quantityGiven;

	// many to one
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasEmployee issuedBy;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee crossMatchedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasHospital bloodBankId;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodTransfussionReactionHd> bloodTransfussionReactionHds;



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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: raction_date
	 */
	public java.util.Date getRactionDate () {
		return ractionDate;
	}

	/**
	 * Set the value related to the column: raction_date
	 * @param ractionDate the raction_date value
	 */
	public void setRactionDate (java.util.Date ractionDate) {
		this.ractionDate = ractionDate;
	}



	/**
	 * Return the value associated with the column: blood_bag_no
	 */
	public java.lang.String getBloodBagNo () {
		return bloodBagNo;
	}

	/**
	 * Set the value related to the column: blood_bag_no
	 * @param bloodBagNo the blood_bag_no value
	 */
	public void setBloodBagNo (java.lang.String bloodBagNo) {
		this.bloodBagNo = bloodBagNo;
	}



	/**
	 * Return the value associated with the column: issued_date
	 */
	public java.util.Date getIssuedDate () {
		return issuedDate;
	}

	/**
	 * Set the value related to the column: issued_date
	 * @param issuedDate the issued_date value
	 */
	public void setIssuedDate (java.util.Date issuedDate) {
		this.issuedDate = issuedDate;
	}



	/**
	 * Return the value associated with the column: issued_time
	 */
	public java.lang.String getIssuedTime () {
		return issuedTime;
	}

	/**
	 * Set the value related to the column: issued_time
	 * @param issuedTime the issued_time value
	 */
	public void setIssuedTime (java.lang.String issuedTime) {
		this.issuedTime = issuedTime;
	}



	/**
	 * Return the value associated with the column: donor_name
	 */
	public java.lang.String getDonorName () {
		return donorName;
	}

	/**
	 * Set the value related to the column: donor_name
	 * @param donorName the donor_name value
	 */
	public void setDonorName (java.lang.String donorName) {
		this.donorName = donorName;
	}



	/**
	 * Return the value associated with the column: issued_to
	 */
	public java.lang.String getIssuedTo () {
		return issuedTo;
	}

	/**
	 * Set the value related to the column: issued_to
	 * @param issuedTo the issued_to value
	 */
	public void setIssuedTo (java.lang.String issuedTo) {
		this.issuedTo = issuedTo;
	}



	/**
	 * Return the value associated with the column: wd_no
	 */
	public java.lang.String getWdNo () {
		return wdNo;
	}

	/**
	 * Set the value related to the column: wd_no
	 * @param wdNo the wd_no value
	 */
	public void setWdNo (java.lang.String wdNo) {
		this.wdNo = wdNo;
	}



	/**
	 * Return the value associated with the column: transfussion
	 */
	public java.lang.String getTransfussion () {
		return transfussion;
	}

	/**
	 * Set the value related to the column: transfussion
	 * @param transfussion the transfussion value
	 */
	public void setTransfussion (java.lang.String transfussion) {
		this.transfussion = transfussion;
	}



	/**
	 * Return the value associated with the column: date_transfussion
	 */
	public java.util.Date getDateTransfussion () {
		return dateTransfussion;
	}

	/**
	 * Set the value related to the column: date_transfussion
	 * @param dateTransfussion the date_transfussion value
	 */
	public void setDateTransfussion (java.util.Date dateTransfussion) {
		this.dateTransfussion = dateTransfussion;
	}



	/**
	 * Return the value associated with the column: time_started
	 */
	public java.lang.String getTimeStarted () {
		return timeStarted;
	}

	/**
	 * Set the value related to the column: time_started
	 * @param timeStarted the time_started value
	 */
	public void setTimeStarted (java.lang.String timeStarted) {
		this.timeStarted = timeStarted;
	}



	/**
	 * Return the value associated with the column: time_completed
	 */
	public java.lang.String getTimeCompleted () {
		return timeCompleted;
	}

	/**
	 * Set the value related to the column: time_completed
	 * @param timeCompleted the time_completed value
	 */
	public void setTimeCompleted (java.lang.String timeCompleted) {
		this.timeCompleted = timeCompleted;
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
	 * Return the value associated with the column: rise_temp
	 */
	public java.lang.String getRiseTemp () {
		return riseTemp;
	}

	/**
	 * Set the value related to the column: rise_temp
	 * @param riseTemp the rise_temp value
	 */
	public void setRiseTemp (java.lang.String riseTemp) {
		this.riseTemp = riseTemp;
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
	 * Return the value associated with the column: temperature
	 */
	public java.math.BigDecimal getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * @param temperature the temperature value
	 */
	public void setTemperature (java.math.BigDecimal temperature) {
		this.temperature = temperature;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.Integer getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.Integer pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: bp_min
	 */
	public java.lang.Integer getBpMin () {
		return bpMin;
	}

	/**
	 * Set the value related to the column: bp_min
	 * @param bpMin the bp_min value
	 */
	public void setBpMin (java.lang.Integer bpMin) {
		this.bpMin = bpMin;
	}



	/**
	 * Return the value associated with the column: bp_max
	 */
	public java.lang.Integer getBpMax () {
		return bpMax;
	}

	/**
	 * Set the value related to the column: bp_max
	 * @param bpMax the bp_max value
	 */
	public void setBpMax (java.lang.Integer bpMax) {
		this.bpMax = bpMax;
	}



	/**
	 * Return the value associated with the column: screening
	 */
	public java.lang.String getScreening () {
		return screening;
	}

	/**
	 * Set the value related to the column: screening
	 * @param screening the screening value
	 */
	public void setScreening (java.lang.String screening) {
		this.screening = screening;
	}



	/**
	 * Return the value associated with the column: temp_during_transfusion
	 */
	public java.math.BigDecimal getTempDuringTransfusion () {
		return tempDuringTransfusion;
	}

	/**
	 * Set the value related to the column: temp_during_transfusion
	 * @param tempDuringTransfusion the temp_during_transfusion value
	 */
	public void setTempDuringTransfusion (java.math.BigDecimal tempDuringTransfusion) {
		this.tempDuringTransfusion = tempDuringTransfusion;
	}



	/**
	 * Return the value associated with the column: pulse_during_transfusion
	 */
	public java.lang.Integer getPulseDuringTransfusion () {
		return pulseDuringTransfusion;
	}

	/**
	 * Set the value related to the column: pulse_during_transfusion
	 * @param pulseDuringTransfusion the pulse_during_transfusion value
	 */
	public void setPulseDuringTransfusion (java.lang.Integer pulseDuringTransfusion) {
		this.pulseDuringTransfusion = pulseDuringTransfusion;
	}



	/**
	 * Return the value associated with the column: bp_min_during_transfusion
	 */
	public java.lang.Integer getBpMinDuringTransfusion () {
		return bpMinDuringTransfusion;
	}

	/**
	 * Set the value related to the column: bp_min_during_transfusion
	 * @param bpMinDuringTransfusion the bp_min_during_transfusion value
	 */
	public void setBpMinDuringTransfusion (java.lang.Integer bpMinDuringTransfusion) {
		this.bpMinDuringTransfusion = bpMinDuringTransfusion;
	}



	/**
	 * Return the value associated with the column: bp_max_during_transfusion
	 */
	public java.lang.Integer getBpMaxDuringTransfusion () {
		return bpMaxDuringTransfusion;
	}

	/**
	 * Set the value related to the column: bp_max_during_transfusion
	 * @param bpMaxDuringTransfusion the bp_max_during_transfusion value
	 */
	public void setBpMaxDuringTransfusion (java.lang.Integer bpMaxDuringTransfusion) {
		this.bpMaxDuringTransfusion = bpMaxDuringTransfusion;
	}



	/**
	 * Return the value associated with the column: temp_after_transfusion
	 */
	public java.math.BigDecimal getTempAfterTransfusion () {
		return tempAfterTransfusion;
	}

	/**
	 * Set the value related to the column: temp_after_transfusion
	 * @param tempAfterTransfusion the temp_after_transfusion value
	 */
	public void setTempAfterTransfusion (java.math.BigDecimal tempAfterTransfusion) {
		this.tempAfterTransfusion = tempAfterTransfusion;
	}



	/**
	 * Return the value associated with the column: pulse_after_transfusion
	 */
	public java.lang.Integer getPulseAfterTransfusion () {
		return pulseAfterTransfusion;
	}

	/**
	 * Set the value related to the column: pulse_after_transfusion
	 * @param pulseAfterTransfusion the pulse_after_transfusion value
	 */
	public void setPulseAfterTransfusion (java.lang.Integer pulseAfterTransfusion) {
		this.pulseAfterTransfusion = pulseAfterTransfusion;
	}



	/**
	 * Return the value associated with the column: bp_min_after_transfusion
	 */
	public java.lang.Integer getBpMinAfterTransfusion () {
		return bpMinAfterTransfusion;
	}

	/**
	 * Set the value related to the column: bp_min_after_transfusion
	 * @param bpMinAfterTransfusion the bp_min_after_transfusion value
	 */
	public void setBpMinAfterTransfusion (java.lang.Integer bpMinAfterTransfusion) {
		this.bpMinAfterTransfusion = bpMinAfterTransfusion;
	}



	/**
	 * Return the value associated with the column: bp_max__after_transfusion
	 */
	public java.lang.Integer getBpMaxAfterTransfusion () {
		return bpMaxAfterTransfusion;
	}

	/**
	 * Set the value related to the column: bp_max__after_transfusion
	 * @param bpMaxAfterTransfusion the bp_max__after_transfusion value
	 */
	public void setBpMaxAfterTransfusion (java.lang.Integer bpMaxAfterTransfusion) {
		this.bpMaxAfterTransfusion = bpMaxAfterTransfusion;
	}



	/**
	 * Return the value associated with the column: chills
	 */
	public java.lang.String getChills () {
		return chills;
	}

	/**
	 * Set the value related to the column: chills
	 * @param chills the chills value
	 */
	public void setChills (java.lang.String chills) {
		this.chills = chills;
	}



	/**
	 * Return the value associated with the column: rigor
	 */
	public java.lang.String getRigor () {
		return rigor;
	}

	/**
	 * Set the value related to the column: rigor
	 * @param rigor the rigor value
	 */
	public void setRigor (java.lang.String rigor) {
		this.rigor = rigor;
	}



	/**
	 * Return the value associated with the column: rash_itching
	 */
	public java.lang.String getRashItching () {
		return rashItching;
	}

	/**
	 * Set the value related to the column: rash_itching
	 * @param rashItching the rash_itching value
	 */
	public void setRashItching (java.lang.String rashItching) {
		this.rashItching = rashItching;
	}



	/**
	 * Return the value associated with the column: pain_back
	 */
	public java.lang.String getPainBack () {
		return painBack;
	}

	/**
	 * Set the value related to the column: pain_back
	 * @param painBack the pain_back value
	 */
	public void setPainBack (java.lang.String painBack) {
		this.painBack = painBack;
	}



	/**
	 * Return the value associated with the column: pain_chest
	 */
	public java.lang.String getPainChest () {
		return painChest;
	}

	/**
	 * Set the value related to the column: pain_chest
	 * @param painChest the pain_chest value
	 */
	public void setPainChest (java.lang.String painChest) {
		this.painChest = painChest;
	}



	/**
	 * Return the value associated with the column: pain_head
	 */
	public java.lang.String getPainHead () {
		return painHead;
	}

	/**
	 * Set the value related to the column: pain_head
	 * @param painHead the pain_head value
	 */
	public void setPainHead (java.lang.String painHead) {
		this.painHead = painHead;
	}



	/**
	 * Return the value associated with the column: pain_elsewhere
	 */
	public java.lang.String getPainElsewhere () {
		return painElsewhere;
	}

	/**
	 * Set the value related to the column: pain_elsewhere
	 * @param painElsewhere the pain_elsewhere value
	 */
	public void setPainElsewhere (java.lang.String painElsewhere) {
		this.painElsewhere = painElsewhere;
	}



	/**
	 * Return the value associated with the column: haemoglobinuana
	 */
	public java.lang.String getHaemoglobinuana () {
		return haemoglobinuana;
	}

	/**
	 * Set the value related to the column: haemoglobinuana
	 * @param haemoglobinuana the haemoglobinuana value
	 */
	public void setHaemoglobinuana (java.lang.String haemoglobinuana) {
		this.haemoglobinuana = haemoglobinuana;
	}



	/**
	 * Return the value associated with the column: pulmonary_oedema
	 */
	public java.lang.String getPulmonaryOedema () {
		return pulmonaryOedema;
	}

	/**
	 * Set the value related to the column: pulmonary_oedema
	 * @param pulmonaryOedema the pulmonary_oedema value
	 */
	public void setPulmonaryOedema (java.lang.String pulmonaryOedema) {
		this.pulmonaryOedema = pulmonaryOedema;
	}



	/**
	 * Return the value associated with the column: jaundice
	 */
	public java.lang.String getJaundice () {
		return jaundice;
	}

	/**
	 * Set the value related to the column: jaundice
	 * @param jaundice the jaundice value
	 */
	public void setJaundice (java.lang.String jaundice) {
		this.jaundice = jaundice;
	}



	/**
	 * Return the value associated with the column: any_other_signs
	 */
	public java.lang.String getAnyOtherSigns () {
		return anyOtherSigns;
	}

	/**
	 * Set the value related to the column: any_other_signs
	 * @param anyOtherSigns the any_other_signs value
	 */
	public void setAnyOtherSigns (java.lang.String anyOtherSigns) {
		this.anyOtherSigns = anyOtherSigns;
	}



	/**
	 * Return the value associated with the column: quantity_given
	 */
	public java.lang.String getQuantityGiven () {
		return quantityGiven;
	}

	/**
	 * Set the value related to the column: quantity_given
	 * @param quantityGiven the quantity_given value
	 */
	public void setQuantityGiven (java.lang.String quantityGiven) {
		this.quantityGiven = quantityGiven;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroup the blood_group_id value
	 */
	public void setBloodGroup (jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: issued_by
	 */
	public jkt.hms.masters.business.MasEmployee getIssuedBy () {
		return issuedBy;
	}

	/**
	 * Set the value related to the column: issued_by
	 * @param issuedBy the issued_by value
	 */
	public void setIssuedBy (jkt.hms.masters.business.MasEmployee issuedBy) {
		this.issuedBy = issuedBy;
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
	 * Return the value associated with the column: cross_matched_by
	 */
	public jkt.hms.masters.business.MasEmployee getCrossMatchedBy () {
		return crossMatchedBy;
	}

	/**
	 * Set the value related to the column: cross_matched_by
	 * @param crossMatchedBy the cross_matched_by value
	 */
	public void setCrossMatchedBy (jkt.hms.masters.business.MasEmployee crossMatchedBy) {
		this.crossMatchedBy = crossMatchedBy;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: blood_bank_id
	 */
	public jkt.hms.masters.business.MasHospital getBloodBankId () {
		return bloodBankId;
	}

	/**
	 * Set the value related to the column: blood_bank_id
	 * @param bloodBankId the blood_bank_id value
	 */
	public void setBloodBankId (jkt.hms.masters.business.MasHospital bloodBankId) {
		this.bloodBankId = bloodBankId;
	}



	/**
	 * Return the value associated with the column: BloodTransfussionReactionHds
	 */
	public java.util.Set<jkt.hms.masters.business.BloodTransfussionReactionHd> getBloodTransfussionReactionHds () {
		return bloodTransfussionReactionHds;
	}

	/**
	 * Set the value related to the column: BloodTransfussionReactionHds
	 * @param bloodTransfussionReactionHds the BloodTransfussionReactionHds value
	 */
	public void setBloodTransfussionReactionHds (java.util.Set<jkt.hms.masters.business.BloodTransfussionReactionHd> bloodTransfussionReactionHds) {
		this.bloodTransfussionReactionHds = bloodTransfussionReactionHds;
	}

	public void addToBloodTransfussionReactionHds (jkt.hms.masters.business.BloodTransfussionReactionHd bloodTransfussionReactionHd) {
		if (null == getBloodTransfussionReactionHds()) setBloodTransfussionReactionHds(new java.util.TreeSet<jkt.hms.masters.business.BloodTransfussionReactionHd>());
		getBloodTransfussionReactionHds().add(bloodTransfussionReactionHd);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodReactionEntry)) return false;
		else {
			jkt.hms.masters.business.BloodReactionEntry bloodReactionEntry = (jkt.hms.masters.business.BloodReactionEntry) obj;
			if (null == this.getId() || null == bloodReactionEntry.getId()) return false;
			else return (this.getId().equals(bloodReactionEntry.getId()));
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