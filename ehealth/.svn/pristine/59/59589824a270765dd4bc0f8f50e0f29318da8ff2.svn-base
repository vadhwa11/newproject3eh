package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_training_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_training_type"
 */

public abstract class BaseMasTrainingType  implements Serializable {

	public static String REF = "MasTrainingType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TRAINING_TYPE_NAME = "TrainingTypeName";
	public static String PROP_TRAINING_TYPE_CODE = "TrainingTypeCode";


	// constructors
	public BaseMasTrainingType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasTrainingType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String trainingTypeCode;
	private java.lang.String trainingTypeName;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hrms.masters.business.HrMasTraining> hrMasTrainings;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="training_type_id"
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
	 * Return the value associated with the column: training_type_code
	 */
	public java.lang.String getTrainingTypeCode () {
		return trainingTypeCode;
	}

	/**
	 * Set the value related to the column: training_type_code
	 * @param trainingTypeCode the training_type_code value
	 */
	public void setTrainingTypeCode (java.lang.String trainingTypeCode) {
		this.trainingTypeCode = trainingTypeCode;
	}



	/**
	 * Return the value associated with the column: training_type_name
	 */
	public java.lang.String getTrainingTypeName () {
		return trainingTypeName;
	}

	/**
	 * Set the value related to the column: training_type_name
	 * @param trainingTypeName the training_type_name value
	 */
	public void setTrainingTypeName (java.lang.String trainingTypeName) {
		this.trainingTypeName = trainingTypeName;
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
	 * Return the value associated with the column: HrMasTrainings
	 */
	public java.util.Set<jkt.hrms.masters.business.HrMasTraining> getHrMasTrainings () {
		return hrMasTrainings;
	}

	/**
	 * Set the value related to the column: HrMasTrainings
	 * @param hrMasTrainings the HrMasTrainings value
	 */
	public void setHrMasTrainings (java.util.Set<jkt.hrms.masters.business.HrMasTraining> hrMasTrainings) {
		this.hrMasTrainings = hrMasTrainings;
	}

	public void addToHrMasTrainings (jkt.hrms.masters.business.HrMasTraining hrMasTraining) {
		if (null == getHrMasTrainings()) setHrMasTrainings(new java.util.TreeSet<jkt.hrms.masters.business.HrMasTraining>());
		getHrMasTrainings().add(hrMasTraining);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MasTrainingType)) return false;
		else {
			jkt.hrms.masters.business.MasTrainingType masTrainingType = (jkt.hrms.masters.business.MasTrainingType) obj;
			if (null == this.getId() || null == masTrainingType.getId()) return false;
			else return (this.getId().equals(masTrainingType.getId()));
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