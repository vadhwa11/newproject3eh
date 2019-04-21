package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_diet_requisition_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_diet_requisition_header"
 */

public abstract class BaseIpdDietRequisitionHeader  implements Serializable {

	public static String REF = "IpdDietRequisitionHeader";
	public static String PROP_REQUISITION_DATE = "RequisitionDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REQUISITION_FOR_DATE = "RequisitionForDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_REQUISITION_TO = "RequisitionTo";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseIpdDietRequisitionHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdDietRequisitionHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date requisitionDate;
	private java.util.Date requisitionForDate;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment requisitionTo;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdDietRequisitionDetails> ipdDietRequisitionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="diet_requisition_header_id"
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
	 * Return the value associated with the column: requisition_date
	 */
	public java.util.Date getRequisitionDate () {
		return requisitionDate;
	}

	/**
	 * Set the value related to the column: requisition_date
	 * @param requisitionDate the requisition_date value
	 */
	public void setRequisitionDate (java.util.Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}



	/**
	 * Return the value associated with the column: requisition_for_date
	 */
	public java.util.Date getRequisitionForDate () {
		return requisitionForDate;
	}

	/**
	 * Set the value related to the column: requisition_for_date
	 * @param requisitionForDate the requisition_for_date value
	 */
	public void setRequisitionForDate (java.util.Date requisitionForDate) {
		this.requisitionForDate = requisitionForDate;
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
	 * Return the value associated with the column: requisition_to
	 */
	public jkt.hms.masters.business.MasDepartment getRequisitionTo () {
		return requisitionTo;
	}

	/**
	 * Set the value related to the column: requisition_to
	 * @param requisitionTo the requisition_to value
	 */
	public void setRequisitionTo (jkt.hms.masters.business.MasDepartment requisitionTo) {
		this.requisitionTo = requisitionTo;
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
	 * Return the value associated with the column: IpdDietRequisitionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.IpdDietRequisitionDetails> getIpdDietRequisitionDetails () {
		return ipdDietRequisitionDetails;
	}

	/**
	 * Set the value related to the column: IpdDietRequisitionDetails
	 * @param ipdDietRequisitionDetails the IpdDietRequisitionDetails value
	 */
	public void setIpdDietRequisitionDetails (java.util.Set<jkt.hms.masters.business.IpdDietRequisitionDetails> ipdDietRequisitionDetails) {
		this.ipdDietRequisitionDetails = ipdDietRequisitionDetails;
	}

	public void addToIpdDietRequisitionDetails (jkt.hms.masters.business.IpdDietRequisitionDetails ipdDietRequisitionDetails) {
		if (null == getIpdDietRequisitionDetails()) setIpdDietRequisitionDetails(new java.util.TreeSet<jkt.hms.masters.business.IpdDietRequisitionDetails>());
		getIpdDietRequisitionDetails().add(ipdDietRequisitionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdDietRequisitionHeader)) return false;
		else {
			jkt.hms.masters.business.IpdDietRequisitionHeader ipdDietRequisitionHeader = (jkt.hms.masters.business.IpdDietRequisitionHeader) obj;
			if (null == this.getId() || null == ipdDietRequisitionHeader.getId()) return false;
			else return (this.getId().equals(ipdDietRequisitionHeader.getId()));
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