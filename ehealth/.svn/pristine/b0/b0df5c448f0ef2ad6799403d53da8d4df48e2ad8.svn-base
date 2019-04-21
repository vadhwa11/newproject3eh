package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_training_schedule table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_training_schedule"
 */

public abstract class BaseHrTrainingSchedule  implements Serializable {

	public static String REF = "HrTrainingSchedule";
	public static String PROP_TRAINING = "Training";
	public static String PROP_CLASS_SIZE = "ClassSize";
	public static String PROP_TRAINING_DATE = "TrainingDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TRAINING_END_TIME = "TrainingEndTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_INSTRUCTOR = "Instructor";
	public static String PROP_TRAINING_LOCATION_TYPE = "TrainingLocationType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_TRAINING_TIME = "TrainingTime";
	public static String PROP_DURATION = "Duration";
	public static String PROP_TRAINING_START_DATE = "TrainingStartDate";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TRAINING_END_DATE = "TrainingEndDate";


	// constructors
	public BaseHrTrainingSchedule () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTrainingSchedule (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date trainingDate;
	private java.lang.String trainingTime;
	private java.lang.Integer classSize;
	private java.lang.String duration;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date trainingStartDate;
	private java.util.Date trainingEndDate;
	private java.lang.String address;
	private java.lang.String trainingEndTime;
	private java.lang.String orderNo;
	private java.lang.String trainingLocationType;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.HrMasTraining training;
	private jkt.hrms.masters.business.HrMasInstructor instructor;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="training_schedule_id"
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
	 * Return the value associated with the column: training_date
	 */
	public java.util.Date getTrainingDate () {
		return trainingDate;
	}

	/**
	 * Set the value related to the column: training_date
	 * @param trainingDate the training_date value
	 */
	public void setTrainingDate (java.util.Date trainingDate) {
		this.trainingDate = trainingDate;
	}



	/**
	 * Return the value associated with the column: training_time
	 */
	public java.lang.String getTrainingTime () {
		return trainingTime;
	}

	/**
	 * Set the value related to the column: training_time
	 * @param trainingTime the training_time value
	 */
	public void setTrainingTime (java.lang.String trainingTime) {
		this.trainingTime = trainingTime;
	}



	/**
	 * Return the value associated with the column: class_size
	 */
	public java.lang.Integer getClassSize () {
		return classSize;
	}

	/**
	 * Set the value related to the column: class_size
	 * @param classSize the class_size value
	 */
	public void setClassSize (java.lang.Integer classSize) {
		this.classSize = classSize;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
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
	 * Return the value associated with the column: training_start_date
	 */
	public java.util.Date getTrainingStartDate () {
		return trainingStartDate;
	}

	/**
	 * Set the value related to the column: training_start_date
	 * @param trainingStartDate the training_start_date value
	 */
	public void setTrainingStartDate (java.util.Date trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}



	/**
	 * Return the value associated with the column: training_end_date
	 */
	public java.util.Date getTrainingEndDate () {
		return trainingEndDate;
	}

	/**
	 * Set the value related to the column: training_end_date
	 * @param trainingEndDate the training_end_date value
	 */
	public void setTrainingEndDate (java.util.Date trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: end_time
	 */
	public java.lang.String getTrainingEndTime () {
		return trainingEndTime;
	}

	/**
	 * Set the value related to the column: end_time
	 * @param trainingEndTime the end_time value
	 */
	public void setTrainingEndTime (java.lang.String trainingEndTime) {
		this.trainingEndTime = trainingEndTime;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.String getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.String orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: training_location_type
	 */
	public java.lang.String getTrainingLocationType () {
		return trainingLocationType;
	}

	/**
	 * Set the value related to the column: training_location_type
	 * @param trainingLocationType the training_location_type value
	 */
	public void setTrainingLocationType (java.lang.String trainingLocationType) {
		this.trainingLocationType = trainingLocationType;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: training_id
	 */
	public jkt.hrms.masters.business.HrMasTraining getTraining () {
		return training;
	}

	/**
	 * Set the value related to the column: training_id
	 * @param training the training_id value
	 */
	public void setTraining (jkt.hrms.masters.business.HrMasTraining training) {
		this.training = training;
	}



	/**
	 * Return the value associated with the column: instructor_id
	 */
	public jkt.hrms.masters.business.HrMasInstructor getInstructor () {
		return instructor;
	}

	/**
	 * Set the value related to the column: instructor_id
	 * @param instructor the instructor_id value
	 */
	public void setInstructor (jkt.hrms.masters.business.HrMasInstructor instructor) {
		this.instructor = instructor;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrTrainingSchedule)) return false;
		else {
			jkt.hrms.masters.business.HrTrainingSchedule hrTrainingSchedule = (jkt.hrms.masters.business.HrTrainingSchedule) obj;
			if (null == this.getId() || null == hrTrainingSchedule.getId()) return false;
			else return (this.getId().equals(hrTrainingSchedule.getId()));
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