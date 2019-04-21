package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bud_estimate_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bud_estimate_entry"
 */

public abstract class BaseBudEstimateEntry  implements Serializable {

	public static String REF = "BudEstimateEntry";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_MAJOR_HEAD_ID = "MajorHeadId";
	public static String PROP_MAJOR_SUB_HEAD_ID = "MajorSubHeadId";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_STARTING_ESTIMETION_AMOUNT = "StartingEstimetionAmount";
	public static String PROP_MINOR_HEAD_ID = "MinorHeadId";
	public static String PROP_ESTIMETION_DATE = "EstimetionDate";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_DEMAND_NO = "DemandNo";
	public static String PROP_OBJECT_HEAD_ID = "ObjectHeadId";
	public static String PROP_STATUS = "Status";
	public static String PROP_SAVING_AMOUNT = "SavingAmount";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MINOR_SUB_HEAD_ID = "MinorSubHeadId";
	public static String PROP_EXCESS_AMOUNT = "ExcessAmount";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SECTOR_TYPE = "SectorType";


	// constructors
	public BaseBudEstimateEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudEstimateEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String demandNo;
	private java.math.BigDecimal amount;
	private java.lang.String sectorType;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer hospitalId;
	private java.math.BigDecimal excessAmount;
	private java.math.BigDecimal savingAmount;
	private java.math.BigDecimal startingEstimetionAmount;
	private java.util.Date estimetionDate;

	// many to one
	private jkt.hrms.masters.business.HrMasFinancialYear fYear;
	private jkt.hms.masters.business.BudSubMajorHead majorSubHeadId;
	private jkt.hms.masters.business.BudObjectHead objectHeadId;
	private jkt.hms.masters.business.BudMinorSubHead minorSubHeadId;
	private jkt.hms.masters.business.BudMajorHead majorHeadId;
	private jkt.hms.masters.business.BudMinorHead minorHeadId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="budget_id"
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
	 * Return the value associated with the column: demand_no
	 */
	public java.lang.String getDemandNo () {
		return demandNo;
	}

	/**
	 * Set the value related to the column: demand_no
	 * @param demandNo the demand_no value
	 */
	public void setDemandNo (java.lang.String demandNo) {
		this.demandNo = demandNo;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: sector_type
	 */
	public java.lang.String getSectorType () {
		return sectorType;
	}

	/**
	 * Set the value related to the column: sector_type
	 * @param sectorType the sector_type value
	 */
	public void setSectorType (java.lang.String sectorType) {
		this.sectorType = sectorType;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: excess_amount
	 */
	public java.math.BigDecimal getExcessAmount () {
		return excessAmount;
	}

	/**
	 * Set the value related to the column: excess_amount
	 * @param excessAmount the excess_amount value
	 */
	public void setExcessAmount (java.math.BigDecimal excessAmount) {
		this.excessAmount = excessAmount;
	}



	/**
	 * Return the value associated with the column: saving_amount
	 */
	public java.math.BigDecimal getSavingAmount () {
		return savingAmount;
	}

	/**
	 * Set the value related to the column: saving_amount
	 * @param savingAmount the saving_amount value
	 */
	public void setSavingAmount (java.math.BigDecimal savingAmount) {
		this.savingAmount = savingAmount;
	}



	/**
	 * Return the value associated with the column: Starting_estimetion_amount
	 */
	public java.math.BigDecimal getStartingEstimetionAmount () {
		return startingEstimetionAmount;
	}

	/**
	 * Set the value related to the column: Starting_estimetion_amount
	 * @param startingEstimetionAmount the Starting_estimetion_amount value
	 */
	public void setStartingEstimetionAmount (java.math.BigDecimal startingEstimetionAmount) {
		this.startingEstimetionAmount = startingEstimetionAmount;
	}



	/**
	 * Return the value associated with the column: estimation_date
	 */
	public java.util.Date getEstimetionDate () {
		return estimetionDate;
	}

	/**
	 * Set the value related to the column: estimation_date
	 * @param estimetionDate the estimation_date value
	 */
	public void setEstimetionDate (java.util.Date estimetionDate) {
		this.estimetionDate = estimetionDate;
	}



	/**
	 * Return the value associated with the column: financial_id
	 */
	public jkt.hrms.masters.business.HrMasFinancialYear getFYear () {
		return fYear;
	}

	/**
	 * Set the value related to the column: financial_id
	 * @param fYear the financial_id value
	 */
	public void setFYear (jkt.hrms.masters.business.HrMasFinancialYear fYear) {
		this.fYear = fYear;
	}



	/**
	 * Return the value associated with the column: major_sub_head_id
	 */
	public jkt.hms.masters.business.BudSubMajorHead getMajorSubHeadId () {
		return majorSubHeadId;
	}

	/**
	 * Set the value related to the column: major_sub_head_id
	 * @param majorSubHeadId the major_sub_head_id value
	 */
	public void setMajorSubHeadId (jkt.hms.masters.business.BudSubMajorHead majorSubHeadId) {
		this.majorSubHeadId = majorSubHeadId;
	}



	/**
	 * Return the value associated with the column: object_head_id
	 */
	public jkt.hms.masters.business.BudObjectHead getObjectHeadId () {
		return objectHeadId;
	}

	/**
	 * Set the value related to the column: object_head_id
	 * @param objectHeadId the object_head_id value
	 */
	public void setObjectHeadId (jkt.hms.masters.business.BudObjectHead objectHeadId) {
		this.objectHeadId = objectHeadId;
	}



	/**
	 * Return the value associated with the column: minor_sub_head_id
	 */
	public jkt.hms.masters.business.BudMinorSubHead getMinorSubHeadId () {
		return minorSubHeadId;
	}

	/**
	 * Set the value related to the column: minor_sub_head_id
	 * @param minorSubHeadId the minor_sub_head_id value
	 */
	public void setMinorSubHeadId (jkt.hms.masters.business.BudMinorSubHead minorSubHeadId) {
		this.minorSubHeadId = minorSubHeadId;
	}



	/**
	 * Return the value associated with the column: major_head_id
	 */
	public jkt.hms.masters.business.BudMajorHead getMajorHeadId () {
		return majorHeadId;
	}

	/**
	 * Set the value related to the column: major_head_id
	 * @param majorHeadId the major_head_id value
	 */
	public void setMajorHeadId (jkt.hms.masters.business.BudMajorHead majorHeadId) {
		this.majorHeadId = majorHeadId;
	}



	/**
	 * Return the value associated with the column: minor_head_id
	 */
	public jkt.hms.masters.business.BudMinorHead getMinorHeadId () {
		return minorHeadId;
	}

	/**
	 * Set the value related to the column: minor_head_id
	 * @param minorHeadId the minor_head_id value
	 */
	public void setMinorHeadId (jkt.hms.masters.business.BudMinorHead minorHeadId) {
		this.minorHeadId = minorHeadId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudEstimateEntry)) return false;
		else {
			jkt.hms.masters.business.BudEstimateEntry budEstimateEntry = (jkt.hms.masters.business.BudEstimateEntry) obj;
			if (null == this.getId() || null == budEstimateEntry.getId()) return false;
			else return (this.getId().equals(budEstimateEntry.getId()));
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