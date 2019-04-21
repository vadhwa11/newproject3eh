package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_transfer_application_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_transfer_application_m"
 */

public abstract class BaseHrTransferApplicationM  implements Serializable {

	public static String REF = "HrTransferApplicationM";
	public static String PROP_NOTIFICATION_NO = "NotificationNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_WITHIN_DAYS = "WithinDays";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TRANSFER_STSTUS = "TransferStstus";
	public static String PROP_ID = "Id";
	public static String PROP_TR_HOSPITAL = "TrHospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_CUR_HOSPITAL = "CurHospital";


	// constructors
	public BaseHrTransferApplicationM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTransferApplicationM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String withinDays;
	private java.lang.String transferStstus;

	// many to one
	private jkt.hms.masters.business.MasHospital trHospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital curHospital;
	private jkt.hms.masters.business.HrMasTransferNotification notificationNo;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrTransferApplicationT> hrTransferApplicationTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="transfer_app_id"
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
	 * Return the value associated with the column: within_days
	 */
	public java.lang.String getWithinDays () {
		return withinDays;
	}

	/**
	 * Set the value related to the column: within_days
	 * @param withinDays the within_days value
	 */
	public void setWithinDays (java.lang.String withinDays) {
		this.withinDays = withinDays;
	}



	/**
	 * Return the value associated with the column: transfer_ststus
	 */
	public java.lang.String getTransferStstus () {
		return transferStstus;
	}

	/**
	 * Set the value related to the column: transfer_ststus
	 * @param transferStstus the transfer_ststus value
	 */
	public void setTransferStstus (java.lang.String transferStstus) {
		this.transferStstus = transferStstus;
	}



	/**
	 * Return the value associated with the column: tr_hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getTrHospital () {
		return trHospital;
	}

	/**
	 * Set the value related to the column: tr_hospital_id
	 * @param trHospital the tr_hospital_id value
	 */
	public void setTrHospital (jkt.hms.masters.business.MasHospital trHospital) {
		this.trHospital = trHospital;
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
	 * Return the value associated with the column: cur_hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getCurHospital () {
		return curHospital;
	}

	/**
	 * Set the value related to the column: cur_hospital_id
	 * @param curHospital the cur_hospital_id value
	 */
	public void setCurHospital (jkt.hms.masters.business.MasHospital curHospital) {
		this.curHospital = curHospital;
	}



	/**
	 * Return the value associated with the column: notification_no
	 */
	public jkt.hms.masters.business.HrMasTransferNotification getNotificationNo () {
		return notificationNo;
	}

	/**
	 * Set the value related to the column: notification_no
	 * @param notificationNo the notification_no value
	 */
	public void setNotificationNo (jkt.hms.masters.business.HrMasTransferNotification notificationNo) {
		this.notificationNo = notificationNo;
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
	 * Return the value associated with the column: HrTransferApplicationTs
	 */
	public java.util.Set<jkt.hms.masters.business.HrTransferApplicationT> getHrTransferApplicationTs () {
		return hrTransferApplicationTs;
	}

	/**
	 * Set the value related to the column: HrTransferApplicationTs
	 * @param hrTransferApplicationTs the HrTransferApplicationTs value
	 */
	public void setHrTransferApplicationTs (java.util.Set<jkt.hms.masters.business.HrTransferApplicationT> hrTransferApplicationTs) {
		this.hrTransferApplicationTs = hrTransferApplicationTs;
	}

	public void addToHrTransferApplicationTs (jkt.hms.masters.business.HrTransferApplicationT hrTransferApplicationT) {
		if (null == getHrTransferApplicationTs()) setHrTransferApplicationTs(new java.util.TreeSet<jkt.hms.masters.business.HrTransferApplicationT>());
		getHrTransferApplicationTs().add(hrTransferApplicationT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrTransferApplicationM)) return false;
		else {
			jkt.hms.masters.business.HrTransferApplicationM hrTransferApplicationM = (jkt.hms.masters.business.HrTransferApplicationM) obj;
			if (null == this.getId() || null == hrTransferApplicationM.getId()) return false;
			else return (this.getId().equals(hrTransferApplicationM.getId()));
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