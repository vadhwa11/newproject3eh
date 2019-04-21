package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the deduction table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="deduction"
 */

public abstract class BaseDeduction implements Serializable {

	public static String REF = "Deduction";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_DEDUCTION_CODE = "DeductionCode";
	public static String PROP_ID = "Id";
	public static String PROP_DEDUCTION_DESCRIPTION = "DeductionDescription";

	// constructors
	public BaseDeduction() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDeduction(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deductionCode;
	private java.lang.String deductionDescription;
	private java.lang.Double amount;
	private java.lang.Integer hospitalId;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="deduction_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: deduction_code
	 */
	public java.lang.String getDeductionCode() {
		return deductionCode;
	}

	/**
	 * Set the value related to the column: deduction_code
	 * 
	 * @param deductionCode
	 *            the deduction_code value
	 */
	public void setDeductionCode(java.lang.String deductionCode) {
		this.deductionCode = deductionCode;
	}

	/**
	 * Return the value associated with the column: deduction_description
	 */
	public java.lang.String getDeductionDescription() {
		return deductionDescription;
	}

	/**
	 * Set the value related to the column: deduction_description
	 * 
	 * @param deductionDescription
	 *            the deduction_description value
	 */
	public void setDeductionDescription(java.lang.String deductionDescription) {
		this.deductionDescription = deductionDescription;
	}

	/**
	 * Return the value associated with the column: amount
	 */
	public java.lang.Double getAmount() {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * 
	 * @param amount
	 *            the amount value
	 */
	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public java.lang.Integer getAddEditById() {
		return addEditById;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * 
	 * @param addEditById
	 *            the add_edit_by_id value
	 */
	public void setAddEditById(java.lang.Integer addEditById) {
		this.addEditById = addEditById;
	}

	/**
	 * Return the value associated with the column: add_edit_date_time
	 */
	public java.util.Date getAddEditDateTime() {
		return addEditDateTime;
	}

	/**
	 * Set the value related to the column: add_edit_date_time
	 * 
	 * @param addEditDateTime
	 *            the add_edit_date_time value
	 */
	public void setAddEditDateTime(java.util.Date addEditDateTime) {
		this.addEditDateTime = addEditDateTime;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.Deduction)) {
			return false;
		} else {
			jkt.hms.masters.business.Deduction deduction = (jkt.hms.masters.business.Deduction) obj;
			if (null == this.getId() || null == deduction.getId()) {
				return false;
			} else {
				return (this.getId().equals(deduction.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}