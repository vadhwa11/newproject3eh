package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_booking table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_booking"
 */

public abstract class BaseOtBooking  implements Serializable {

	public static String REF = "OtBooking";
	public static String PROP_BOOKED_BY = "BookedBy";
	public static String PROP_LAST_CHGD_TIME = "LastChgdTime";
	public static String PROP_SURGERY_END_TIME = "SurgeryEndTime";
	public static String PROP_OPD_SURSERY_HEADER = "OpdSurseryHeader";
	public static String PROP_OT = "Ot";
	public static String PROP_VISIT = "Visit";
	public static String PROP_UNIT_HEAD = "UnitHead";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_UNIT = "Unit";
	public static String PROP_OT_POST_ANETHESIA_STATUS = "OtPostAnethesiaStatus";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_SURGERY_DATE = "SurgeryDate";
	public static String PROP_INTRA_OPERATIVE_STATUS = "IntraOperativeStatus";
	public static String PROP_SURGERY = "Surgery";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BOOKING_TYPE = "BookingType";
	public static String PROP_OT_NOTE_PROCEDURE_STATUS = "OtNoteProcedureStatus";
	public static String PROP_OT_BOOKING_STATUS = "OtBookingStatus";
	public static String PROP_PRE_OPERATIVE_STATUS = "PreOperativeStatus";
	public static String PROP_BED = "Bed";
	public static String PROP_LAST_CHGD_DATE = "LastChgdDate";
	public static String PROP_HIN = "Hin";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_SURGICAL_SAFETY_STATUS = "SurgicalSafetyStatus";
	public static String PROP_SURGERY_TIME = "SurgeryTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_LAST_CHGD_BY = "LastChgdBy";
	public static String PROP_ID = "Id";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_SURGERY_STATUS = "SurgeryStatus";
	public static String PROP_BLOOD_REQUIRE="BloodRequire";


	// constructors
	public BaseOtBooking () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtBooking (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date surgeryDate;
	private java.lang.String surgeryTime;
	private java.util.Date lastChgdDate;
	private java.lang.String lastChgdTime;
	private java.lang.Integer orderNo;
	private java.lang.String otBookingStatus;
	private java.lang.Integer slNo;
	private java.lang.String bookingType;
	private java.lang.String surgeryStatus;
	private java.lang.String surgeryEndTime;
	private java.lang.String otPostAnethesiaStatus;
	private java.lang.String otNoteProcedureStatus;
	private java.lang.String preOperativeStatus;
	private java.lang.String intraOperativeStatus;
	private java.lang.String surgicalSafetyStatus;
	private java.lang.String bloodRequire;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.OtMasChargeDetails surgery;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.HospitalDoctorUnitM unit;
	private jkt.hms.masters.business.MasOt ot;
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.OpdSurgeryHeader opdSurseryHeader;
	private jkt.hms.masters.business.MasBed bed;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasEmployee unitHead;
	private jkt.hms.masters.business.Users lastChgdBy;
	private jkt.hms.masters.business.MasEmployee bookedBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> otPreAnaesthesiaProcNotesMains;
	private java.util.Set<jkt.hms.masters.business.OtBookSurgeon> otBookSurgeons;



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
	 * Return the value associated with the column: surgery_date
	 */
	public java.util.Date getSurgeryDate () {
		return surgeryDate;
	}

	/**
	 * Set the value related to the column: surgery_date
	 * @param surgeryDate the surgery_date value
	 */
	public void setSurgeryDate (java.util.Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}



	/**
	 * Return the value associated with the column: surgery_time
	 */
	public java.lang.String getSurgeryTime () {
		return surgeryTime;
	}

	/**
	 * Set the value related to the column: surgery_time
	 * @param surgeryTime the surgery_time value
	 */
	public void setSurgeryTime (java.lang.String surgeryTime) {
		this.surgeryTime = surgeryTime;
	}



	/**
	 * Return the value associated with the column: last_chgd_date
	 */
	public java.util.Date getLastChgdDate () {
		return lastChgdDate;
	}

	/**
	 * Set the value related to the column: last_chgd_date
	 * @param lastChgdDate the last_chgd_date value
	 */
	public void setLastChgdDate (java.util.Date lastChgdDate) {
		this.lastChgdDate = lastChgdDate;
	}



	/**
	 * Return the value associated with the column: last_chgd_time
	 */
	public java.lang.String getLastChgdTime () {
		return lastChgdTime;
	}

	/**
	 * Set the value related to the column: last_chgd_time
	 * @param lastChgdTime the last_chgd_time value
	 */
	public void setLastChgdTime (java.lang.String lastChgdTime) {
		this.lastChgdTime = lastChgdTime;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: ot_booking_status
	 */
	public java.lang.String getOtBookingStatus () {
		return otBookingStatus;
	}

	/**
	 * Set the value related to the column: ot_booking_status
	 * @param otBookingStatus the ot_booking_status value
	 */
	public void setOtBookingStatus (java.lang.String otBookingStatus) {
		this.otBookingStatus = otBookingStatus;
	}



	/**
	 * Return the value associated with the column: sl_no
	 */
	public java.lang.Integer getSlNo () {
		return slNo;
	}

	/**
	 * Set the value related to the column: sl_no
	 * @param slNo the sl_no value
	 */
	public void setSlNo (java.lang.Integer slNo) {
		this.slNo = slNo;
	}



	/**
	 * Return the value associated with the column: booking_type
	 */
	public java.lang.String getBookingType () {
		return bookingType;
	}

	/**
	 * Set the value related to the column: booking_type
	 * @param bookingType the booking_type value
	 */
	public void setBookingType (java.lang.String bookingType) {
		this.bookingType = bookingType;
	}



	/**
	 * Return the value associated with the column: surgery_status
	 */
	public java.lang.String getSurgeryStatus () {
		return surgeryStatus;
	}

	/**
	 * Set the value related to the column: surgery_status
	 * @param surgeryStatus the surgery_status value
	 */
	public void setSurgeryStatus (java.lang.String surgeryStatus) {
		this.surgeryStatus = surgeryStatus;
	}



	/**
	 * Return the value associated with the column: surgery_end_time
	 */
	public java.lang.String getSurgeryEndTime () {
		return surgeryEndTime;
	}

	/**
	 * Set the value related to the column: surgery_end_time
	 * @param surgeryEndTime the surgery_end_time value
	 */
	public void setSurgeryEndTime (java.lang.String surgeryEndTime) {
		this.surgeryEndTime = surgeryEndTime;
	}



	/**
	 * Return the value associated with the column: ot_post_anethesia_status
	 */
	public java.lang.String getOtPostAnethesiaStatus () {
		return otPostAnethesiaStatus;
	}

	/**
	 * Set the value related to the column: ot_post_anethesia_status
	 * @param otPostAnethesiaStatus the ot_post_anethesia_status value
	 */
	public void setOtPostAnethesiaStatus (java.lang.String otPostAnethesiaStatus) {
		this.otPostAnethesiaStatus = otPostAnethesiaStatus;
	}



	/**
	 * Return the value associated with the column: ot_note_procedure_status
	 */
	public java.lang.String getOtNoteProcedureStatus () {
		return otNoteProcedureStatus;
	}

	/**
	 * Set the value related to the column: ot_note_procedure_status
	 * @param otNoteProcedureStatus the ot_note_procedure_status value
	 */
	public void setOtNoteProcedureStatus (java.lang.String otNoteProcedureStatus) {
		this.otNoteProcedureStatus = otNoteProcedureStatus;
	}



	/**
	 * Return the value associated with the column: pre_operative_status
	 */
	public java.lang.String getPreOperativeStatus () {
		return preOperativeStatus;
	}

	public java.lang.String getBloodRequire() {
		return bloodRequire;
	}

	public void setBloodRequire(java.lang.String bloodRequire) {
		this.bloodRequire = bloodRequire;
	}

	/**
	 * Set the value related to the column: pre_operative_status
	 * @param preOperativeStatus the pre_operative_status value
	 */
	public void setPreOperativeStatus (java.lang.String preOperativeStatus) {
		this.preOperativeStatus = preOperativeStatus;
	}



	/**
	 * Return the value associated with the column: intra_operative_status
	 */
	public java.lang.String getIntraOperativeStatus () {
		return intraOperativeStatus;
	}

	/**
	 * Set the value related to the column: intra_operative_status
	 * @param intraOperativeStatus the intra_operative_status value
	 */
	public void setIntraOperativeStatus (java.lang.String intraOperativeStatus) {
		this.intraOperativeStatus = intraOperativeStatus;
	}



	/**
	 * Return the value associated with the column: surgical_safety_status
	 */
	public java.lang.String getSurgicalSafetyStatus () {
		return surgicalSafetyStatus;
	}

	/**
	 * Set the value related to the column: surgical_safety_status
	 * @param surgicalSafetyStatus the surgical_safety_status value
	 */
	public void setSurgicalSafetyStatus (java.lang.String surgicalSafetyStatus) {
		this.surgicalSafetyStatus = surgicalSafetyStatus;
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
	 * Return the value associated with the column: surgery_id
	 */
	public jkt.hms.masters.business.OtMasChargeDetails getSurgery () {
		return surgery;
	}

	/**
	 * Set the value related to the column: surgery_id
	 * @param surgery the surgery_id value
	 */
	public void setSurgery (jkt.hms.masters.business.OtMasChargeDetails surgery) {
		this.surgery = surgery;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.HospitalDoctorUnitM getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.HospitalDoctorUnitM unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: ot_id
	 */
	public jkt.hms.masters.business.MasOt getOt () {
		return ot;
	}

	/**
	 * Set the value related to the column: ot_id
	 * @param ot the ot_id value
	 */
	public void setOt (jkt.hms.masters.business.MasOt ot) {
		this.ot = ot;
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
	 * Return the value associated with the column: opd_sursery_header_id
	 */
	public jkt.hms.masters.business.OpdSurgeryHeader getOpdSurseryHeader () {
		return opdSurseryHeader;
	}

	/**
	 * Set the value related to the column: opd_sursery_header_id
	 * @param opdSurseryHeader the opd_sursery_header_id value
	 */
	public void setOpdSurseryHeader (jkt.hms.masters.business.OpdSurgeryHeader opdSurseryHeader) {
		this.opdSurseryHeader = opdSurseryHeader;
	}



	/**
	 * Return the value associated with the column: bed_id
	 */
	public jkt.hms.masters.business.MasBed getBed () {
		return bed;
	}

	/**
	 * Set the value related to the column: bed_id
	 * @param bed the bed_id value
	 */
	public void setBed (jkt.hms.masters.business.MasBed bed) {
		this.bed = bed;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: unit_head_id
	 */
	public jkt.hms.masters.business.MasEmployee getUnitHead () {
		return unitHead;
	}

	/**
	 * Set the value related to the column: unit_head_id
	 * @param unitHead the unit_head_id value
	 */
	public void setUnitHead (jkt.hms.masters.business.MasEmployee unitHead) {
		this.unitHead = unitHead;
	}



	/**
	 * Return the value associated with the column: last_chgd_by
	 */
	public jkt.hms.masters.business.Users getLastChgdBy () {
		return lastChgdBy;
	}

	/**
	 * Set the value related to the column: last_chgd_by
	 * @param lastChgdBy the last_chgd_by value
	 */
	public void setLastChgdBy (jkt.hms.masters.business.Users lastChgdBy) {
		this.lastChgdBy = lastChgdBy;
	}



	/**
	 * Return the value associated with the column: booked_by
	 */
	public jkt.hms.masters.business.MasEmployee getBookedBy () {
		return bookedBy;
	}

	/**
	 * Set the value related to the column: booked_by
	 * @param bookedBy the booked_by value
	 */
	public void setBookedBy (jkt.hms.masters.business.MasEmployee bookedBy) {
		this.bookedBy = bookedBy;
	}



	/**
	 * Return the value associated with the column: OtPreAnaesthesiaProcNotesMains
	 */
	public java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> getOtPreAnaesthesiaProcNotesMains () {
		return otPreAnaesthesiaProcNotesMains;
	}

	/**
	 * Set the value related to the column: OtPreAnaesthesiaProcNotesMains
	 * @param otPreAnaesthesiaProcNotesMains the OtPreAnaesthesiaProcNotesMains value
	 */
	public void setOtPreAnaesthesiaProcNotesMains (java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> otPreAnaesthesiaProcNotesMains) {
		this.otPreAnaesthesiaProcNotesMains = otPreAnaesthesiaProcNotesMains;
	}

	public void addToOtPreAnaesthesiaProcNotesMains (jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain) {
		if (null == getOtPreAnaesthesiaProcNotesMains()) setOtPreAnaesthesiaProcNotesMains(new java.util.TreeSet<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain>());
		getOtPreAnaesthesiaProcNotesMains().add(otPreAnaesthesiaProcNotesMain);
	}



	/**
	 * Return the value associated with the column: OtBookSurgeons
	 */
	public java.util.Set<jkt.hms.masters.business.OtBookSurgeon> getOtBookSurgeons () {
		return otBookSurgeons;
	}

	/**
	 * Set the value related to the column: OtBookSurgeons
	 * @param otBookSurgeons the OtBookSurgeons value
	 */
	public void setOtBookSurgeons (java.util.Set<jkt.hms.masters.business.OtBookSurgeon> otBookSurgeons) {
		this.otBookSurgeons = otBookSurgeons;
	}

	public void addToOtBookSurgeons (jkt.hms.masters.business.OtBookSurgeon otBookSurgeon) {
		if (null == getOtBookSurgeons()) setOtBookSurgeons(new java.util.TreeSet<jkt.hms.masters.business.OtBookSurgeon>());
		getOtBookSurgeons().add(otBookSurgeon);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtBooking)) return false;
		else {
			jkt.hms.masters.business.OtBooking otBooking = (jkt.hms.masters.business.OtBooking) obj;
			if (null == this.getId() || null == otBooking.getId()) return false;
			else return (this.getId().equals(otBooking.getId()));
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