package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mlc_case table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mlc_case"
 */

public abstract class BaseMlcCase  implements Serializable {

	public static String REF = "MlcCase";
	public static String PROP_MLC_TIME = "MlcTime";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_STATEMENT = "Statement";
	public static String PROP_MLC_NO = "MlcNo";
	public static String PROP_NATURE_OF_MLC = "NatureOfMlc";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_WEAPON_USED = "WeaponUsed";
	public static String PROP_INCIDENT_DATE = "IncidentDate";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_SEVERITY_OF_INJURY = "SeverityOfInjury";
	public static String PROP_PATIENT_RELATION = "PatientRelation";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_SRNO_VEHICALE = "SrnoVehicale";
	public static String PROP_BROUGHT_BY_ADDR = "BroughtByAddr";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_INJURY_TYPE = "InjuryType";
	public static String PROP_VISIT_NO = "VisitNo";
	public static String PROP_POLICE_STATION = "PoliceStation";
	public static String PROP_POLICE_OFFICER = "PoliceOfficer";
	public static String PROP_BROUGHT_BY = "BroughtBy";
	public static String PROP_MLC_DATE = "MlcDate";
	public static String PROP_INJURY_DIMENSION = "InjuryDimension";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_NAME_AND_ADDRESS_OF_DRIVER = "NameAndAddressOfDriver";
	public static String PROP_VISIT = "Visit";
	public static String PROP_INCIDENT_TIME = "IncidentTime";
	public static String PROP_TYPE_AND_NO_OF_VEHICLE = "TypeAndNoOfVehicle";
	public static String PROP_STATUS = "Status";
	public static String PROP_BODY_PART = "BodyPart";
	public static String PROP_INJURY_NATURE = "InjuryNature";
	public static String PROP_PATIENT_CONDITION = "PatientCondition";
	public static String PROP_ID = "Id";
	public static String PROP_INJURY_DETAILS = "InjuryDetails";
	public static String PROP_HIN = "Hin";
	public static String PROP_FIR_NO = "FirNo";
	public static String PROP_INCIDENT_PLACE = "IncidentPlace";


	// constructors
	public BaseMlcCase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMlcCase (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mlcNo;
	private java.lang.Integer visitNo;
	private java.lang.String adNo;
	private java.lang.String injuryType;
	private java.lang.String injuryDimension;
	private java.lang.String injuryDetails;
	private java.lang.String firNo;
	private java.lang.String policeOfficer;
	private java.lang.String policeStation;
	private java.lang.String statement;
	private java.lang.String broughtBy;
	private java.lang.String patientCondition;
	private java.lang.String weaponUsed;
	private java.lang.String incidentPlace;
	private java.lang.String typeAndNoOfVehicle;
	private java.lang.String nameAndAddressOfDriver;
	private java.util.Date mlcDate;
	private java.lang.String mlcTime;
	private java.util.Date incidentDate;
	private java.lang.String incidentTime;
	private java.lang.String remarks;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String status;
	private java.lang.String natureOfMlc;
	private java.lang.String severityOfInjury;
	private java.lang.String broughtByAddr;
	private java.lang.String srnoVehicale;
	private java.lang.String patientRelation;

	// many to one
	private jkt.hms.masters.business.MasInjuryNature injuryNature;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasBodyPart bodyPart;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="mlc_id"
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
	 * Return the value associated with the column: mlc_no
	 */
	public java.lang.String getMlcNo () {
		return mlcNo;
	}

	/**
	 * Set the value related to the column: mlc_no
	 * @param mlcNo the mlc_no value
	 */
	public void setMlcNo (java.lang.String mlcNo) {
		this.mlcNo = mlcNo;
	}



	/**
	 * Return the value associated with the column: visit_no
	 */
	public java.lang.Integer getVisitNo () {
		return visitNo;
	}

	/**
	 * Set the value related to the column: visit_no
	 * @param visitNo the visit_no value
	 */
	public void setVisitNo (java.lang.Integer visitNo) {
		this.visitNo = visitNo;
	}



	/**
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: injury_type
	 */
	public java.lang.String getInjuryType () {
		return injuryType;
	}

	/**
	 * Set the value related to the column: injury_type
	 * @param injuryType the injury_type value
	 */
	public void setInjuryType (java.lang.String injuryType) {
		this.injuryType = injuryType;
	}



	/**
	 * Return the value associated with the column: injury_dimension
	 */
	public java.lang.String getInjuryDimension () {
		return injuryDimension;
	}

	/**
	 * Set the value related to the column: injury_dimension
	 * @param injuryDimension the injury_dimension value
	 */
	public void setInjuryDimension (java.lang.String injuryDimension) {
		this.injuryDimension = injuryDimension;
	}



	/**
	 * Return the value associated with the column: injury_details
	 */
	public java.lang.String getInjuryDetails () {
		return injuryDetails;
	}

	/**
	 * Set the value related to the column: injury_details
	 * @param injuryDetails the injury_details value
	 */
	public void setInjuryDetails (java.lang.String injuryDetails) {
		this.injuryDetails = injuryDetails;
	}



	/**
	 * Return the value associated with the column: fir_no
	 */
	public java.lang.String getFirNo () {
		return firNo;
	}

	/**
	 * Set the value related to the column: fir_no
	 * @param firNo the fir_no value
	 */
	public void setFirNo (java.lang.String firNo) {
		this.firNo = firNo;
	}



	/**
	 * Return the value associated with the column: police_officer
	 */
	public java.lang.String getPoliceOfficer () {
		return policeOfficer;
	}

	/**
	 * Set the value related to the column: police_officer
	 * @param policeOfficer the police_officer value
	 */
	public void setPoliceOfficer (java.lang.String policeOfficer) {
		this.policeOfficer = policeOfficer;
	}



	/**
	 * Return the value associated with the column: police_station
	 */
	public java.lang.String getPoliceStation () {
		return policeStation;
	}

	/**
	 * Set the value related to the column: police_station
	 * @param policeStation the police_station value
	 */
	public void setPoliceStation (java.lang.String policeStation) {
		this.policeStation = policeStation;
	}



	/**
	 * Return the value associated with the column: statement
	 */
	public java.lang.String getStatement () {
		return statement;
	}

	/**
	 * Set the value related to the column: statement
	 * @param statement the statement value
	 */
	public void setStatement (java.lang.String statement) {
		this.statement = statement;
	}



	/**
	 * Return the value associated with the column: brought_by
	 */
	public java.lang.String getBroughtBy () {
		return broughtBy;
	}

	/**
	 * Set the value related to the column: brought_by
	 * @param broughtBy the brought_by value
	 */
	public void setBroughtBy (java.lang.String broughtBy) {
		this.broughtBy = broughtBy;
	}



	/**
	 * Return the value associated with the column: patient_condition
	 */
	public java.lang.String getPatientCondition () {
		return patientCondition;
	}

	/**
	 * Set the value related to the column: patient_condition
	 * @param patientCondition the patient_condition value
	 */
	public void setPatientCondition (java.lang.String patientCondition) {
		this.patientCondition = patientCondition;
	}



	/**
	 * Return the value associated with the column: weapon_used
	 */
	public java.lang.String getWeaponUsed () {
		return weaponUsed;
	}

	/**
	 * Set the value related to the column: weapon_used
	 * @param weaponUsed the weapon_used value
	 */
	public void setWeaponUsed (java.lang.String weaponUsed) {
		this.weaponUsed = weaponUsed;
	}



	/**
	 * Return the value associated with the column: incident_place
	 */
	public java.lang.String getIncidentPlace () {
		return incidentPlace;
	}

	/**
	 * Set the value related to the column: incident_place
	 * @param incidentPlace the incident_place value
	 */
	public void setIncidentPlace (java.lang.String incidentPlace) {
		this.incidentPlace = incidentPlace;
	}



	/**
	 * Return the value associated with the column: type_and_no_of_vehicle
	 */
	public java.lang.String getTypeAndNoOfVehicle () {
		return typeAndNoOfVehicle;
	}

	/**
	 * Set the value related to the column: type_and_no_of_vehicle
	 * @param typeAndNoOfVehicle the type_and_no_of_vehicle value
	 */
	public void setTypeAndNoOfVehicle (java.lang.String typeAndNoOfVehicle) {
		this.typeAndNoOfVehicle = typeAndNoOfVehicle;
	}



	/**
	 * Return the value associated with the column: name_and_address_of_driver
	 */
	public java.lang.String getNameAndAddressOfDriver () {
		return nameAndAddressOfDriver;
	}

	/**
	 * Set the value related to the column: name_and_address_of_driver
	 * @param nameAndAddressOfDriver the name_and_address_of_driver value
	 */
	public void setNameAndAddressOfDriver (java.lang.String nameAndAddressOfDriver) {
		this.nameAndAddressOfDriver = nameAndAddressOfDriver;
	}



	/**
	 * Return the value associated with the column: mlc_date
	 */
	public java.util.Date getMlcDate () {
		return mlcDate;
	}

	/**
	 * Set the value related to the column: mlc_date
	 * @param mlcDate the mlc_date value
	 */
	public void setMlcDate (java.util.Date mlcDate) {
		this.mlcDate = mlcDate;
	}



	/**
	 * Return the value associated with the column: mlc_time
	 */
	public java.lang.String getMlcTime () {
		return mlcTime;
	}

	/**
	 * Set the value related to the column: mlc_time
	 * @param mlcTime the mlc_time value
	 */
	public void setMlcTime (java.lang.String mlcTime) {
		this.mlcTime = mlcTime;
	}



	/**
	 * Return the value associated with the column: incident_date
	 */
	public java.util.Date getIncidentDate () {
		return incidentDate;
	}

	/**
	 * Set the value related to the column: incident_date
	 * @param incidentDate the incident_date value
	 */
	public void setIncidentDate (java.util.Date incidentDate) {
		this.incidentDate = incidentDate;
	}



	/**
	 * Return the value associated with the column: incident_time
	 */
	public java.lang.String getIncidentTime () {
		return incidentTime;
	}

	/**
	 * Set the value related to the column: incident_time
	 * @param incidentTime the incident_time value
	 */
	public void setIncidentTime (java.lang.String incidentTime) {
		this.incidentTime = incidentTime;
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
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate () {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * @param addEditDate the add_edit_date value
	 */
	public void setAddEditDate (java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}



	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * @param addEditTime the add_edit_time value
	 */
	public void setAddEditTime (java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
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
	 * Return the value associated with the column: nature_of_mlc
	 */
	public java.lang.String getNatureOfMlc () {
		return natureOfMlc;
	}

	/**
	 * Set the value related to the column: nature_of_mlc
	 * @param natureOfMlc the nature_of_mlc value
	 */
	public void setNatureOfMlc (java.lang.String natureOfMlc) {
		this.natureOfMlc = natureOfMlc;
	}



	/**
	 * Return the value associated with the column: severity_of_injury
	 */
	public java.lang.String getSeverityOfInjury () {
		return severityOfInjury;
	}

	/**
	 * Set the value related to the column: severity_of_injury
	 * @param severityOfInjury the severity_of_injury value
	 */
	public void setSeverityOfInjury (java.lang.String severityOfInjury) {
		this.severityOfInjury = severityOfInjury;
	}



	/**
	 * Return the value associated with the column: brought_by_addr
	 */
	public java.lang.String getBroughtByAddr () {
		return broughtByAddr;
	}

	/**
	 * Set the value related to the column: brought_by_addr
	 * @param broughtByAddr the brought_by_addr value
	 */
	public void setBroughtByAddr (java.lang.String broughtByAddr) {
		this.broughtByAddr = broughtByAddr;
	}



	/**
	 * Return the value associated with the column: srno_vehicale
	 */
	public java.lang.String getSrnoVehicale () {
		return srnoVehicale;
	}

	/**
	 * Set the value related to the column: srno_vehicale
	 * @param srnoVehicale the srno_vehicale value
	 */
	public void setSrnoVehicale (java.lang.String srnoVehicale) {
		this.srnoVehicale = srnoVehicale;
	}



	/**
	 * Return the value associated with the column: patient_relation
	 */
	public java.lang.String getPatientRelation () {
		return patientRelation;
	}

	/**
	 * Set the value related to the column: patient_relation
	 * @param patientRelation the patient_relation value
	 */
	public void setPatientRelation (java.lang.String patientRelation) {
		this.patientRelation = patientRelation;
	}



	/**
	 * Return the value associated with the column: injury_nature_id
	 */
	public jkt.hms.masters.business.MasInjuryNature getInjuryNature () {
		return injuryNature;
	}

	/**
	 * Set the value related to the column: injury_nature_id
	 * @param injuryNature the injury_nature_id value
	 */
	public void setInjuryNature (jkt.hms.masters.business.MasInjuryNature injuryNature) {
		this.injuryNature = injuryNature;
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
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
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
	 * Return the value associated with the column: body_part_id
	 */
	public jkt.hms.masters.business.MasBodyPart getBodyPart () {
		return bodyPart;
	}

	/**
	 * Set the value related to the column: body_part_id
	 * @param bodyPart the body_part_id value
	 */
	public void setBodyPart (jkt.hms.masters.business.MasBodyPart bodyPart) {
		this.bodyPart = bodyPart;
	}



	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MlcCase)) return false;
		else {
			jkt.hms.masters.business.MlcCase mlcCase = (jkt.hms.masters.business.MlcCase) obj;
			if (null == this.getId() || null == mlcCase.getId()) return false;
			else return (this.getId().equals(mlcCase.getId()));
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