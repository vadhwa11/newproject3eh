package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_empanelled_billing_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_empanelled_billing_m"
 */

public abstract class BaseStoreEmpanelledBillingM  implements Serializable {

	public static String REF = "StoreEmpanelledBillingM";
	public static String PROP_BILLING_DATE = "BillingDate";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRESCRIPTION = "Prescription";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_BILL_AMT = "BillAmt";
	public static String PROP_EMPANELLED_ID = "EmpanelledId";
	public static String PROP_STATUS = "Status";
	public static String PROP_VENDER_NAME = "VenderName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RECEIVED_AMT = "ReceivedAmt";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_AMT = "TotalAmt";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_NET_AMT = "NetAmt";


	// constructors
	public BaseStoreEmpanelledBillingM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreEmpanelledBillingM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreEmpanelledBillingM (
		java.lang.Integer id,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.PatientPrescriptionHeader prescription) {

		this.setId(id);
		this.setHin(hin);
		this.setPrescription(prescription);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String billNo;
	private java.util.Date billingDate;
	private java.math.BigDecimal billAmt;
	private java.math.BigDecimal totalAmt;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal netAmt;
	private java.math.BigDecimal receivedAmt;
	private java.lang.String venderName;
	private java.lang.Long empanelledId;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.PatientPrescriptionHeader prescription;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreEmpanelledBillingT> storeEmpanelledBillingTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="em_billing_m_id"
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
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.String getBillNo () {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * @param billNo the bill_no value
	 */
	public void setBillNo (java.lang.String billNo) {
		this.billNo = billNo;
	}



	/**
	 * Return the value associated with the column: billing_date
	 */
	public java.util.Date getBillingDate () {
		return billingDate;
	}

	/**
	 * Set the value related to the column: billing_date
	 * @param billingDate the billing_date value
	 */
	public void setBillingDate (java.util.Date billingDate) {
		this.billingDate = billingDate;
	}



	/**
	 * Return the value associated with the column: bill_amt
	 */
	public java.math.BigDecimal getBillAmt () {
		return billAmt;
	}

	/**
	 * Set the value related to the column: bill_amt
	 * @param billAmt the bill_amt value
	 */
	public void setBillAmt (java.math.BigDecimal billAmt) {
		this.billAmt = billAmt;
	}



	/**
	 * Return the value associated with the column: total_amt
	 */
	public java.math.BigDecimal getTotalAmt () {
		return totalAmt;
	}

	/**
	 * Set the value related to the column: total_amt
	 * @param totalAmt the total_amt value
	 */
	public void setTotalAmt (java.math.BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}



	/**
	 * Return the value associated with the column: discount_percent
	 */
	public java.math.BigDecimal getDiscountPercent () {
		return discountPercent;
	}

	/**
	 * Set the value related to the column: discount_percent
	 * @param discountPercent the discount_percent value
	 */
	public void setDiscountPercent (java.math.BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}



	/**
	 * Return the value associated with the column: discount_amt
	 */
	public java.math.BigDecimal getDiscountAmt () {
		return discountAmt;
	}

	/**
	 * Set the value related to the column: discount_amt
	 * @param discountAmt the discount_amt value
	 */
	public void setDiscountAmt (java.math.BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}



	/**
	 * Return the value associated with the column: net_amt
	 */
	public java.math.BigDecimal getNetAmt () {
		return netAmt;
	}

	/**
	 * Set the value related to the column: net_amt
	 * @param netAmt the net_amt value
	 */
	public void setNetAmt (java.math.BigDecimal netAmt) {
		this.netAmt = netAmt;
	}



	/**
	 * Return the value associated with the column: received_amt
	 */
	public java.math.BigDecimal getReceivedAmt () {
		return receivedAmt;
	}

	/**
	 * Set the value related to the column: received_amt
	 * @param receivedAmt the received_amt value
	 */
	public void setReceivedAmt (java.math.BigDecimal receivedAmt) {
		this.receivedAmt = receivedAmt;
	}



	/**
	 * Return the value associated with the column: vender_name
	 */
	public java.lang.String getVenderName () {
		return venderName;
	}

	/**
	 * Set the value related to the column: vender_name
	 * @param venderName the vender_name value
	 */
	public void setVenderName (java.lang.String venderName) {
		this.venderName = venderName;
	}



	/**
	 * Return the value associated with the column: empanelled_id
	 */
	public java.lang.Long getEmpanelledId () {
		return empanelledId;
	}

	/**
	 * Set the value related to the column: empanelled_id
	 * @param empanelledId the empanelled_id value
	 */
	public void setEmpanelledId (java.lang.Long empanelledId) {
		this.empanelledId = empanelledId;
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
	 * Return the value associated with the column: prescription_id
	 */
	public jkt.hms.masters.business.PatientPrescriptionHeader getPrescription () {
		return prescription;
	}

	/**
	 * Set the value related to the column: prescription_id
	 * @param prescription the prescription_id value
	 */
	public void setPrescription (jkt.hms.masters.business.PatientPrescriptionHeader prescription) {
		this.prescription = prescription;
	}



	/**
	 * Return the value associated with the column: StoreEmpanelledBillingTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreEmpanelledBillingT> getStoreEmpanelledBillingTs () {
		return storeEmpanelledBillingTs;
	}

	/**
	 * Set the value related to the column: StoreEmpanelledBillingTs
	 * @param storeEmpanelledBillingTs the StoreEmpanelledBillingTs value
	 */
	public void setStoreEmpanelledBillingTs (java.util.Set<jkt.hms.masters.business.StoreEmpanelledBillingT> storeEmpanelledBillingTs) {
		this.storeEmpanelledBillingTs = storeEmpanelledBillingTs;
	}

	public void addToStoreEmpanelledBillingTs (jkt.hms.masters.business.StoreEmpanelledBillingT storeEmpanelledBillingT) {
		if (null == getStoreEmpanelledBillingTs()) setStoreEmpanelledBillingTs(new java.util.TreeSet<jkt.hms.masters.business.StoreEmpanelledBillingT>());
		getStoreEmpanelledBillingTs().add(storeEmpanelledBillingT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreEmpanelledBillingM)) return false;
		else {
			jkt.hms.masters.business.StoreEmpanelledBillingM storeEmpanelledBillingM = (jkt.hms.masters.business.StoreEmpanelledBillingM) obj;
			if (null == this.getId() || null == storeEmpanelledBillingM.getId()) return false;
			else return (this.getId().equals(storeEmpanelledBillingM.getId()));
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