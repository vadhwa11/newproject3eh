package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the labor_room table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="labor_room"
 */

public abstract class BaseLaborRoom  implements Serializable {

	public static String REF = "LaborRoom";
	public static String PROP_FETAL_HEART = "FetalHeart";
	public static String PROP_LABOR_ROOM_TYPE = "LaborRoomType";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NST = "Nst";
	public static String PROP_CONTRACTION = "Contraction";
	public static String PROP_LUNG_BASES = "LungBases";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LABOR_ROOM_DATE = "LaborRoomDate";
	public static String PROP_OXYINFO_RATE = "OxyinfoRate";
	public static String PROP_LAB_ROOM_IO = "LabRoomIo";
	public static String PROP_RESP_RATE = "RespRate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LABOR_ROOM_TIME = "LaborRoomTime";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_MATERNAL_PULSE_RATE = "MaternalPulseRate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_LAB_ROOM_BP = "LabRoomBp";
	public static String PROP_KNEE_JERK = "KneeJerk";


	// constructors
	public BaseLaborRoom () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLaborRoom (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date laborRoomDate;
	private java.lang.Long maternalPulseRate;
	private java.lang.Long respRate;
	private java.lang.Long labRoomBp;
	private java.lang.String lungBases;
	private java.lang.Long kneeJerk;
	private java.lang.Long fetalHeart;
	private java.lang.Long nst;
	private java.lang.String contraction;
	private java.lang.String labRoomIo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Long laborRoomType;
	private java.lang.String laborRoomTime;
	private java.lang.String oxyinfoRate;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="labor_room_id"
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
	 * Return the value associated with the column: labor_room_date
	 */
	public java.util.Date getLaborRoomDate () {
		return laborRoomDate;
	}

	/**
	 * Set the value related to the column: labor_room_date
	 * @param laborRoomDate the labor_room_date value
	 */
	public void setLaborRoomDate (java.util.Date laborRoomDate) {
		this.laborRoomDate = laborRoomDate;
	}



	/**
	 * Return the value associated with the column: maternal_pulse_rate
	 */
	public java.lang.Long getMaternalPulseRate () {
		return maternalPulseRate;
	}

	/**
	 * Set the value related to the column: maternal_pulse_rate
	 * @param maternalPulseRate the maternal_pulse_rate value
	 */
	public void setMaternalPulseRate (java.lang.Long maternalPulseRate) {
		this.maternalPulseRate = maternalPulseRate;
	}



	/**
	 * Return the value associated with the column: resp_rate
	 */
	public java.lang.Long getRespRate () {
		return respRate;
	}

	/**
	 * Set the value related to the column: resp_rate
	 * @param respRate the resp_rate value
	 */
	public void setRespRate (java.lang.Long respRate) {
		this.respRate = respRate;
	}



	/**
	 * Return the value associated with the column: lab_room_bp
	 */
	public java.lang.Long getLabRoomBp () {
		return labRoomBp;
	}

	/**
	 * Set the value related to the column: lab_room_bp
	 * @param labRoomBp the lab_room_bp value
	 */
	public void setLabRoomBp (java.lang.Long labRoomBp) {
		this.labRoomBp = labRoomBp;
	}



	/**
	 * Return the value associated with the column: lung_bases
	 */
	public java.lang.String getLungBases () {
		return lungBases;
	}

	/**
	 * Set the value related to the column: lung_bases
	 * @param lungBases the lung_bases value
	 */
	public void setLungBases (java.lang.String lungBases) {
		this.lungBases = lungBases;
	}



	/**
	 * Return the value associated with the column: knee_jerk
	 */
	public java.lang.Long getKneeJerk () {
		return kneeJerk;
	}

	/**
	 * Set the value related to the column: knee_jerk
	 * @param kneeJerk the knee_jerk value
	 */
	public void setKneeJerk (java.lang.Long kneeJerk) {
		this.kneeJerk = kneeJerk;
	}



	/**
	 * Return the value associated with the column: fetal_heart
	 */
	public java.lang.Long getFetalHeart () {
		return fetalHeart;
	}

	/**
	 * Set the value related to the column: fetal_heart
	 * @param fetalHeart the fetal_heart value
	 */
	public void setFetalHeart (java.lang.Long fetalHeart) {
		this.fetalHeart = fetalHeart;
	}



	/**
	 * Return the value associated with the column: nst
	 */
	public java.lang.Long getNst () {
		return nst;
	}

	/**
	 * Set the value related to the column: nst
	 * @param nst the nst value
	 */
	public void setNst (java.lang.Long nst) {
		this.nst = nst;
	}



	/**
	 * Return the value associated with the column: contraction
	 */
	public java.lang.String getContraction () {
		return contraction;
	}

	/**
	 * Set the value related to the column: contraction
	 * @param contraction the contraction value
	 */
	public void setContraction (java.lang.String contraction) {
		this.contraction = contraction;
	}



	/**
	 * Return the value associated with the column: lab_room_io
	 */
	public java.lang.String getLabRoomIo () {
		return labRoomIo;
	}

	/**
	 * Set the value related to the column: lab_room_io
	 * @param labRoomIo the lab_room_io value
	 */
	public void setLabRoomIo (java.lang.String labRoomIo) {
		this.labRoomIo = labRoomIo;
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
	 * Return the value associated with the column: labor_room_type
	 */
	public java.lang.Long getLaborRoomType () {
		return laborRoomType;
	}

	/**
	 * Set the value related to the column: labor_room_type
	 * @param laborRoomType the labor_room_type value
	 */
	public void setLaborRoomType (java.lang.Long laborRoomType) {
		this.laborRoomType = laborRoomType;
	}



	/**
	 * Return the value associated with the column: labor_room_time
	 */
	public java.lang.String getLaborRoomTime () {
		return laborRoomTime;
	}

	/**
	 * Set the value related to the column: labor_room_time
	 * @param laborRoomTime the labor_room_time value
	 */
	public void setLaborRoomTime (java.lang.String laborRoomTime) {
		this.laborRoomTime = laborRoomTime;
	}



	/**
	 * Return the value associated with the column: oxyinfo_rate
	 */
	public java.lang.String getOxyinfoRate () {
		return oxyinfoRate;
	}

	/**
	 * Set the value related to the column: oxyinfo_rate
	 * @param oxyinfoRate the oxyinfo_rate value
	 */
	public void setOxyinfoRate (java.lang.String oxyinfoRate) {
		this.oxyinfoRate = oxyinfoRate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LaborRoom)) return false;
		else {
			jkt.hms.masters.business.LaborRoom laborRoom = (jkt.hms.masters.business.LaborRoom) obj;
			if (null == this.getId() || null == laborRoom.getId()) return false;
			else return (this.getId().equals(laborRoom.getId()));
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