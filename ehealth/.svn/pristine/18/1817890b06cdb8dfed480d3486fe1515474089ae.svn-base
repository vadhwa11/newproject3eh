package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_training table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_training"
 */

public abstract class BaseMasTraining implements Serializable {

	public static String REF = "MasTraining";
	public static String PROP_TRAINING_NAME = "TrainingName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TRAINING_CODE = "TrainingCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasTraining() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasTraining(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String trainingCode;
	private java.lang.String trainingName;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="training_id"
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
	 * Return the value associated with the column: training_code
	 */
	public java.lang.String getTrainingCode() {
		return trainingCode;
	}

	/**
	 * Set the value related to the column: training_code
	 * 
	 * @param trainingCode
	 *            the training_code value
	 */
	public void setTrainingCode(java.lang.String trainingCode) {
		this.trainingCode = trainingCode;
	}

	/**
	 * Return the value associated with the column: training_name
	 */
	public java.lang.String getTrainingName() {
		return trainingName;
	}

	/**
	 * Set the value related to the column: training_name
	 * 
	 * @param trainingName
	 *            the training_name value
	 */
	public void setTrainingName(java.lang.String trainingName) {
		this.trainingName = trainingName;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasTraining)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasTraining masTraining = (jkt.hrms.masters.business.MasTraining) obj;
			if (null == this.getId() || null == masTraining.getId()) {
				return false;
			} else {
				return (this.getId().equals(masTraining.getId()));
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