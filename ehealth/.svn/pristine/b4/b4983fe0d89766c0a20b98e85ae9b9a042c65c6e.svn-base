package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_anc_termination_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_anc_termination_m"
 */

public abstract class BasePhAncTerminationM  implements Serializable {

	public static String REF = "PhAncTerminationM";
	public static String PROP_MTP_REASON = "MtpReason";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SERVER_PK = "ServerPk";
	public static String PROP_ATTENDED_BY = "AttendedBy";
	public static String PROP_TERM = "Term";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ANC_REG_ID = "AncRegId";
	public static String PROP_DELIVERY_TYPE = "DeliveryType";
	public static String PROP_TERMINATION_DATE = "TerminationDate";
	public static String PROP_ID = "Id";
	public static String PROP_NATURE_MTP_MIS = "NatureMtpMis";
	public static String PROP_MTP_METHOD = "MtpMethod";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_FOLLOWUP_STATUS = "FollowupStatus";
	public static String PROP_TRIMESTER = "Trimester";
	public static String PROP_TERMINATION_TYPE = "TerminationType";
	public static String PROP_INSTITUTE_TYPE = "InstituteType";


	// constructors
	public BasePhAncTerminationM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhAncTerminationM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long serverPk;
	private java.lang.String terminationType;
	private java.lang.String natureMtpMis;
	private java.lang.String mtpReason;
	private java.lang.String mtpMethod;
	private java.lang.String trimester;
	private java.lang.String instituteType;
	private java.lang.String ancRegId;
	private java.util.Date terminationDate;
	private java.lang.String deliveryType;
	private java.lang.String term;
	private java.lang.String attendedBy;
	private java.lang.String complications;
	private java.lang.String remarks;
	private java.lang.String followupStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="termination_m_id"
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
	 * Return the value associated with the column: server_pk
	 */
	public java.lang.Long getServerPk () {
		return serverPk;
	}

	/**
	 * Set the value related to the column: server_pk
	 * @param serverPk the server_pk value
	 */
	public void setServerPk (java.lang.Long serverPk) {
		this.serverPk = serverPk;
	}



	/**
	 * Return the value associated with the column: termination_type
	 */
	public java.lang.String getTerminationType () {
		return terminationType;
	}

	/**
	 * Set the value related to the column: termination_type
	 * @param terminationType the termination_type value
	 */
	public void setTerminationType (java.lang.String terminationType) {
		this.terminationType = terminationType;
	}



	/**
	 * Return the value associated with the column: nature_mtp_mis
	 */
	public java.lang.String getNatureMtpMis () {
		return natureMtpMis;
	}

	/**
	 * Set the value related to the column: nature_mtp_mis
	 * @param natureMtpMis the nature_mtp_mis value
	 */
	public void setNatureMtpMis (java.lang.String natureMtpMis) {
		this.natureMtpMis = natureMtpMis;
	}



	/**
	 * Return the value associated with the column: mtp_reason
	 */
	public java.lang.String getMtpReason () {
		return mtpReason;
	}

	/**
	 * Set the value related to the column: mtp_reason
	 * @param mtpReason the mtp_reason value
	 */
	public void setMtpReason (java.lang.String mtpReason) {
		this.mtpReason = mtpReason;
	}



	/**
	 * Return the value associated with the column: mtp_method
	 */
	public java.lang.String getMtpMethod () {
		return mtpMethod;
	}

	/**
	 * Set the value related to the column: mtp_method
	 * @param mtpMethod the mtp_method value
	 */
	public void setMtpMethod (java.lang.String mtpMethod) {
		this.mtpMethod = mtpMethod;
	}



	/**
	 * Return the value associated with the column: trimester
	 */
	public java.lang.String getTrimester () {
		return trimester;
	}

	/**
	 * Set the value related to the column: trimester
	 * @param trimester the trimester value
	 */
	public void setTrimester (java.lang.String trimester) {
		this.trimester = trimester;
	}



	/**
	 * Return the value associated with the column: institute_type
	 */
	public java.lang.String getInstituteType () {
		return instituteType;
	}

	/**
	 * Set the value related to the column: institute_type
	 * @param instituteType the institute_type value
	 */
	public void setInstituteType (java.lang.String instituteType) {
		this.instituteType = instituteType;
	}



	/**
	 * Return the value associated with the column: anc_reg_id
	 */
	public java.lang.String getAncRegId () {
		return ancRegId;
	}

	/**
	 * Set the value related to the column: anc_reg_id
	 * @param ancRegId the anc_reg_id value
	 */
	public void setAncRegId (java.lang.String ancRegId) {
		this.ancRegId = ancRegId;
	}



	/**
	 * Return the value associated with the column: termination_date
	 */
	public java.util.Date getTerminationDate () {
		return terminationDate;
	}

	/**
	 * Set the value related to the column: termination_date
	 * @param terminationDate the termination_date value
	 */
	public void setTerminationDate (java.util.Date terminationDate) {
		this.terminationDate = terminationDate;
	}



	/**
	 * Return the value associated with the column: delivery_type
	 */
	public java.lang.String getDeliveryType () {
		return deliveryType;
	}

	/**
	 * Set the value related to the column: delivery_type
	 * @param deliveryType the delivery_type value
	 */
	public void setDeliveryType (java.lang.String deliveryType) {
		this.deliveryType = deliveryType;
	}



	/**
	 * Return the value associated with the column: term
	 */
	public java.lang.String getTerm () {
		return term;
	}

	/**
	 * Set the value related to the column: term
	 * @param term the term value
	 */
	public void setTerm (java.lang.String term) {
		this.term = term;
	}



	/**
	 * Return the value associated with the column: attended_by
	 */
	public java.lang.String getAttendedBy () {
		return attendedBy;
	}

	/**
	 * Set the value related to the column: attended_by
	 * @param attendedBy the attended_by value
	 */
	public void setAttendedBy (java.lang.String attendedBy) {
		this.attendedBy = attendedBy;
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
	 * Return the value associated with the column: followup_status
	 */
	public java.lang.String getFollowupStatus () {
		return followupStatus;
	}

	/**
	 * Set the value related to the column: followup_status
	 * @param followupStatus the followup_status value
	 */
	public void setFollowupStatus (java.lang.String followupStatus) {
		this.followupStatus = followupStatus;
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
		if (!(obj instanceof jkt.hms.masters.business.PhAncTerminationM)) return false;
		else {
			jkt.hms.masters.business.PhAncTerminationM phAncTerminationM = (jkt.hms.masters.business.PhAncTerminationM) obj;
			if (null == this.getId() || null == phAncTerminationM.getId()) return false;
			else return (this.getId().equals(phAncTerminationM.getId()));
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