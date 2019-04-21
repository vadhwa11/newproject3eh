package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_payward_booking table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_payward_booking"
 */

public abstract class BaseBlPaywardBooking  implements Serializable {

	public static String REF = "BlPaywardBooking";
	public static String PROP_BOOKING_DATE = "BookingDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PAYWARD = "Payward";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_ROOM_TYPE = "RoomType";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_APPROVE_TIME = "ApproveTime";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BOOKING_TIME = "BookingTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_APPROVE_DATE = "ApproveDate";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_AMOUNT_ADJUSTED = "AmountAdjusted";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BOOKING_STATUS = "BookingStatus";
	public static String PROP_CHARGE_RATE = "ChargeRate";
	public static String PROP_TRANSFER = "Transfer";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_BED_ALLOTMENT_DATE = "BedAllotmentDate";
	public static String PROP_CURRENT_WAITING_LIST = "CurrentWaitingList";
	public static String PROP_ALLOTMENT_DATE = "AllotmentDate";
	public static String PROP_BED_ALLOTMENT_TIME = "BedAllotmentTime";
	public static String PROP_AMOUNT_PAID = "AmountPaid";
	public static String PROP_NUMBER_OF_DAYS = "NumberOfDays";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_ALLOTMENT_TIME = "AllotmentTime";


	// constructors
	public BaseBlPaywardBooking () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPaywardBooking (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlPaywardBooking (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment payward,
		jkt.hms.masters.business.MasRoomType roomType) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		this.setHospital(hospital);
		this.setPayward(payward);
		this.setRoomType(roomType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer currentWaitingList;
	private java.lang.Integer numberOfDays;
	private java.math.BigDecimal amount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String bookingStatus;
	private java.util.Date bookingDate;
	private java.lang.String bookingTime;
	private java.util.Date approveDate;
	private java.lang.String approveTime;
	private java.util.Date allotmentDate;
	private java.lang.String allotmentTime;
	private java.util.Date bedAllotmentDate;
	private java.lang.String bedAllotmentTime;
	private java.math.BigDecimal amountPaid;
	private java.math.BigDecimal amountAdjusted;
	private java.math.BigDecimal chargeRate;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.BlPriority priority;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Transfer transfer;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasDepartment payward;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.MasRoomType roomType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="booking_id"
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
	 * Return the value associated with the column: current_waiting_list
	 */
	public java.lang.Integer getCurrentWaitingList () {
		return currentWaitingList;
	}

	/**
	 * Set the value related to the column: current_waiting_list
	 * @param currentWaitingList the current_waiting_list value
	 */
	public void setCurrentWaitingList (java.lang.Integer currentWaitingList) {
		this.currentWaitingList = currentWaitingList;
	}



	/**
	 * Return the value associated with the column: number_of_days
	 */
	public java.lang.Integer getNumberOfDays () {
		return numberOfDays;
	}

	/**
	 * Set the value related to the column: number_of_days
	 * @param numberOfDays the number_of_days value
	 */
	public void setNumberOfDays (java.lang.Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
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
	 * Return the value associated with the column: booking_status
	 */
	public java.lang.String getBookingStatus () {
		return bookingStatus;
	}

	/**
	 * Set the value related to the column: booking_status
	 * @param bookingStatus the booking_status value
	 */
	public void setBookingStatus (java.lang.String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}



	/**
	 * Return the value associated with the column: booking_date
	 */
	public java.util.Date getBookingDate () {
		return bookingDate;
	}

	/**
	 * Set the value related to the column: booking_date
	 * @param bookingDate the booking_date value
	 */
	public void setBookingDate (java.util.Date bookingDate) {
		this.bookingDate = bookingDate;
	}



	/**
	 * Return the value associated with the column: booking_time
	 */
	public java.lang.String getBookingTime () {
		return bookingTime;
	}

	/**
	 * Set the value related to the column: booking_time
	 * @param bookingTime the booking_time value
	 */
	public void setBookingTime (java.lang.String bookingTime) {
		this.bookingTime = bookingTime;
	}



	/**
	 * Return the value associated with the column: approve_date
	 */
	public java.util.Date getApproveDate () {
		return approveDate;
	}

	/**
	 * Set the value related to the column: approve_date
	 * @param approveDate the approve_date value
	 */
	public void setApproveDate (java.util.Date approveDate) {
		this.approveDate = approveDate;
	}



	/**
	 * Return the value associated with the column: approve_time
	 */
	public java.lang.String getApproveTime () {
		return approveTime;
	}

	/**
	 * Set the value related to the column: approve_time
	 * @param approveTime the approve_time value
	 */
	public void setApproveTime (java.lang.String approveTime) {
		this.approveTime = approveTime;
	}



	/**
	 * Return the value associated with the column: allotment_date
	 */
	public java.util.Date getAllotmentDate () {
		return allotmentDate;
	}

	/**
	 * Set the value related to the column: allotment_date
	 * @param allotmentDate the allotment_date value
	 */
	public void setAllotmentDate (java.util.Date allotmentDate) {
		this.allotmentDate = allotmentDate;
	}



	/**
	 * Return the value associated with the column: allotment_time
	 */
	public java.lang.String getAllotmentTime () {
		return allotmentTime;
	}

	/**
	 * Set the value related to the column: allotment_time
	 * @param allotmentTime the allotment_time value
	 */
	public void setAllotmentTime (java.lang.String allotmentTime) {
		this.allotmentTime = allotmentTime;
	}



	/**
	 * Return the value associated with the column: bed_allotment_date
	 */
	public java.util.Date getBedAllotmentDate () {
		return bedAllotmentDate;
	}

	/**
	 * Set the value related to the column: bed_allotment_date
	 * @param bedAllotmentDate the bed_allotment_date value
	 */
	public void setBedAllotmentDate (java.util.Date bedAllotmentDate) {
		this.bedAllotmentDate = bedAllotmentDate;
	}



	/**
	 * Return the value associated with the column: bed_allotment_time
	 */
	public java.lang.String getBedAllotmentTime () {
		return bedAllotmentTime;
	}

	/**
	 * Set the value related to the column: bed_allotment_time
	 * @param bedAllotmentTime the bed_allotment_time value
	 */
	public void setBedAllotmentTime (java.lang.String bedAllotmentTime) {
		this.bedAllotmentTime = bedAllotmentTime;
	}



	/**
	 * Return the value associated with the column: amount_paid
	 */
	public java.math.BigDecimal getAmountPaid () {
		return amountPaid;
	}

	/**
	 * Set the value related to the column: amount_paid
	 * @param amountPaid the amount_paid value
	 */
	public void setAmountPaid (java.math.BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}



	/**
	 * Return the value associated with the column: amount_adjusted
	 */
	public java.math.BigDecimal getAmountAdjusted () {
		return amountAdjusted;
	}

	/**
	 * Set the value related to the column: amount_adjusted
	 * @param amountAdjusted the amount_adjusted value
	 */
	public void setAmountAdjusted (java.math.BigDecimal amountAdjusted) {
		this.amountAdjusted = amountAdjusted;
	}



	/**
	 * Return the value associated with the column: charge_rate
	 */
	public java.math.BigDecimal getChargeRate () {
		return chargeRate;
	}

	/**
	 * Set the value related to the column: charge_rate
	 * @param chargeRate the charge_rate value
	 */
	public void setChargeRate (java.math.BigDecimal chargeRate) {
		this.chargeRate = chargeRate;
	}



	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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
	 * Return the value associated with the column: priority_id
	 */
	public jkt.hms.masters.business.BlPriority getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority_id
	 * @param priority the priority_id value
	 */
	public void setPriority (jkt.hms.masters.business.BlPriority priority) {
		this.priority = priority;
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
	 * Return the value associated with the column: transfer_id
	 */
	public jkt.hms.masters.business.Transfer getTransfer () {
		return transfer;
	}

	/**
	 * Set the value related to the column: transfer_id
	 * @param transfer the transfer_id value
	 */
	public void setTransfer (jkt.hms.masters.business.Transfer transfer) {
		this.transfer = transfer;
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
	 * Return the value associated with the column: payward_id
	 */
	public jkt.hms.masters.business.MasDepartment getPayward () {
		return payward;
	}

	/**
	 * Set the value related to the column: payward_id
	 * @param payward the payward_id value
	 */
	public void setPayward (jkt.hms.masters.business.MasDepartment payward) {
		this.payward = payward;
	}



	/**
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}



	/**
	 * Return the value associated with the column: room_type_id
	 */
	public jkt.hms.masters.business.MasRoomType getRoomType () {
		return roomType;
	}

	/**
	 * Set the value related to the column: room_type_id
	 * @param roomType the room_type_id value
	 */
	public void setRoomType (jkt.hms.masters.business.MasRoomType roomType) {
		this.roomType = roomType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlPaywardBooking)) return false;
		else {
			jkt.hms.masters.business.BlPaywardBooking blPaywardBooking = (jkt.hms.masters.business.BlPaywardBooking) obj;
			if (null == this.getId() || null == blPaywardBooking.getId()) return false;
			else return (this.getId().equals(blPaywardBooking.getId()));
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