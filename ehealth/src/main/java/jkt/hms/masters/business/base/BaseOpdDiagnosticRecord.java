package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_diagnostic_record table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_diagnostic_record"
 */

public abstract class BaseOpdDiagnosticRecord  implements Serializable {

	public static String REF = "OpdDiagnosticRecord";
	public static String PROP_MOUTH_OPENING_VALUE = "MouthOpeningValue";
	public static String PROP_DEFECTS = "Defects";
	public static String PROP_MINORSURGICAL_PROCEDURES_VALUE = "MinorsurgicalProceduresValue";
	public static String PROP_PLAQUE = "Plaque";
	public static String PROP_MEDICAL_HISTORY = "MedicalHistory";
	public static String PROP_PLAQUE_VALUE = "PlaqueValue";
	public static String PROP_ORAL_LESIONS_VALUE = "OralLesionsValue";
	public static String PROP_ROOT_STUMPS_VALUE = "RootStumpsValue";
	public static String PROP_CALCULUS = "Calculus";
	public static String PROP_MOUTH_OPENING = "MouthOpening";
	public static String PROP_MOBILE_TEETH_VALUE = "MobileTeethValue";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_EDENTULOUSNESS_MANDIBULAR = "EdentulousnessMandibular";
	public static String PROP_MOBILE_TEETH = "MobileTeeth";
	public static String PROP_PREVIOUS_MAXILLARY = "PreviousMaxillary";
	public static String PROP_PROSTHESIS_MAXILLARY = "ProsthesisMaxillary";
	public static String PROP_CALCULUS_VALUE = "CalculusValue";
	public static String PROP_PREVIOUS_MANDIBULAR = "PreviousMandibular";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ROOT_STUMPS = "RootStumps";
	public static String PROP_PREPROSTHETIC_PROCEDURES = "PreprostheticProcedures";
	public static String PROP_EDENTULOUSNESS_MAXILLARY = "EdentulousnessMaxillary";
	public static String PROP_PROSTHESIS_MANDIBULAR = "ProsthesisMandibular";
	public static String PROP_PREPROSTHETIC_PROCEDURES_VALUE = "PreprostheticProceduresValue";
	public static String PROP_ORAL_LESIONS = "OralLesions";
	public static String PROP_CHIEF_COMPLAINT = "ChiefComplaint";
	public static String PROP_MINORSURGICAL_PROCEDURES = "MinorsurgicalProcedures";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_DEFECTS_VALUE = "DefectsValue";


	// constructors
	public BaseOpdDiagnosticRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdDiagnosticRecord (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String medicalHistory;
	private java.lang.String chiefComplaint;
	private java.lang.String edentulousnessMaxillary;
	private java.lang.String edentulousnessMandibular;
	private java.lang.String prosthesisMaxillary;
	private java.lang.String prosthesisMandibular;
	private java.lang.String previousMaxillary;
	private java.lang.String previousMandibular;
	private java.lang.String rootStumps;
	private java.lang.String rootStumpsValue;
	private java.lang.String mobileTeeth;
	private java.lang.String mobileTeethValue;
	private java.lang.String plaque;
	private java.lang.String plaqueValue;
	private java.lang.String calculus;
	private java.lang.String calculusValue;
	private java.lang.String oralLesions;
	private java.lang.String oralLesionsValue;
	private java.lang.String defects;
	private java.lang.String defectsValue;
	private java.lang.String mouthOpening;
	private java.lang.String mouthOpeningValue;
	private java.lang.String preprostheticProcedures;
	private java.lang.String preprostheticProceduresValue;
	private java.lang.String minorsurgicalProcedures;
	private java.lang.String minorsurgicalProceduresValue;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdPreAssessmentClinicDental> opdPreAssessmentClinicDentals;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="diagnostic_record_id"
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
	 * Return the value associated with the column: medical_history
	 */
	public java.lang.String getMedicalHistory () {
		return medicalHistory;
	}

	/**
	 * Set the value related to the column: medical_history
	 * @param medicalHistory the medical_history value
	 */
	public void setMedicalHistory (java.lang.String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}



	/**
	 * Return the value associated with the column: chief_complaint
	 */
	public java.lang.String getChiefComplaint () {
		return chiefComplaint;
	}

	/**
	 * Set the value related to the column: chief_complaint
	 * @param chiefComplaint the chief_complaint value
	 */
	public void setChiefComplaint (java.lang.String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}



	/**
	 * Return the value associated with the column: edentulousness_maxillary
	 */
	public java.lang.String getEdentulousnessMaxillary () {
		return edentulousnessMaxillary;
	}

	/**
	 * Set the value related to the column: edentulousness_maxillary
	 * @param edentulousnessMaxillary the edentulousness_maxillary value
	 */
	public void setEdentulousnessMaxillary (java.lang.String edentulousnessMaxillary) {
		this.edentulousnessMaxillary = edentulousnessMaxillary;
	}



	/**
	 * Return the value associated with the column: edentulousness_mandibular
	 */
	public java.lang.String getEdentulousnessMandibular () {
		return edentulousnessMandibular;
	}

	/**
	 * Set the value related to the column: edentulousness_mandibular
	 * @param edentulousnessMandibular the edentulousness_mandibular value
	 */
	public void setEdentulousnessMandibular (java.lang.String edentulousnessMandibular) {
		this.edentulousnessMandibular = edentulousnessMandibular;
	}



	/**
	 * Return the value associated with the column: prosthesis_maxillary
	 */
	public java.lang.String getProsthesisMaxillary () {
		return prosthesisMaxillary;
	}

	/**
	 * Set the value related to the column: prosthesis_maxillary
	 * @param prosthesisMaxillary the prosthesis_maxillary value
	 */
	public void setProsthesisMaxillary (java.lang.String prosthesisMaxillary) {
		this.prosthesisMaxillary = prosthesisMaxillary;
	}



	/**
	 * Return the value associated with the column: prosthesis_mandibular
	 */
	public java.lang.String getProsthesisMandibular () {
		return prosthesisMandibular;
	}

	/**
	 * Set the value related to the column: prosthesis_mandibular
	 * @param prosthesisMandibular the prosthesis_mandibular value
	 */
	public void setProsthesisMandibular (java.lang.String prosthesisMandibular) {
		this.prosthesisMandibular = prosthesisMandibular;
	}



	/**
	 * Return the value associated with the column: previous_maxillary
	 */
	public java.lang.String getPreviousMaxillary () {
		return previousMaxillary;
	}

	/**
	 * Set the value related to the column: previous_maxillary
	 * @param previousMaxillary the previous_maxillary value
	 */
	public void setPreviousMaxillary (java.lang.String previousMaxillary) {
		this.previousMaxillary = previousMaxillary;
	}



	/**
	 * Return the value associated with the column: previous_mandibular
	 */
	public java.lang.String getPreviousMandibular () {
		return previousMandibular;
	}

	/**
	 * Set the value related to the column: previous_mandibular
	 * @param previousMandibular the previous_mandibular value
	 */
	public void setPreviousMandibular (java.lang.String previousMandibular) {
		this.previousMandibular = previousMandibular;
	}



	/**
	 * Return the value associated with the column: root_stumps
	 */
	public java.lang.String getRootStumps () {
		return rootStumps;
	}

	/**
	 * Set the value related to the column: root_stumps
	 * @param rootStumps the root_stumps value
	 */
	public void setRootStumps (java.lang.String rootStumps) {
		this.rootStumps = rootStumps;
	}



	/**
	 * Return the value associated with the column: root_stumps_value
	 */
	public java.lang.String getRootStumpsValue () {
		return rootStumpsValue;
	}

	/**
	 * Set the value related to the column: root_stumps_value
	 * @param rootStumpsValue the root_stumps_value value
	 */
	public void setRootStumpsValue (java.lang.String rootStumpsValue) {
		this.rootStumpsValue = rootStumpsValue;
	}



	/**
	 * Return the value associated with the column: mobile_teeth
	 */
	public java.lang.String getMobileTeeth () {
		return mobileTeeth;
	}

	/**
	 * Set the value related to the column: mobile_teeth
	 * @param mobileTeeth the mobile_teeth value
	 */
	public void setMobileTeeth (java.lang.String mobileTeeth) {
		this.mobileTeeth = mobileTeeth;
	}



	/**
	 * Return the value associated with the column: mobile_teeth_value
	 */
	public java.lang.String getMobileTeethValue () {
		return mobileTeethValue;
	}

	/**
	 * Set the value related to the column: mobile_teeth_value
	 * @param mobileTeethValue the mobile_teeth_value value
	 */
	public void setMobileTeethValue (java.lang.String mobileTeethValue) {
		this.mobileTeethValue = mobileTeethValue;
	}



	/**
	 * Return the value associated with the column: plaque
	 */
	public java.lang.String getPlaque () {
		return plaque;
	}

	/**
	 * Set the value related to the column: plaque
	 * @param plaque the plaque value
	 */
	public void setPlaque (java.lang.String plaque) {
		this.plaque = plaque;
	}



	/**
	 * Return the value associated with the column: plaque_value
	 */
	public java.lang.String getPlaqueValue () {
		return plaqueValue;
	}

	/**
	 * Set the value related to the column: plaque_value
	 * @param plaqueValue the plaque_value value
	 */
	public void setPlaqueValue (java.lang.String plaqueValue) {
		this.plaqueValue = plaqueValue;
	}



	/**
	 * Return the value associated with the column: calculus
	 */
	public java.lang.String getCalculus () {
		return calculus;
	}

	/**
	 * Set the value related to the column: calculus
	 * @param calculus the calculus value
	 */
	public void setCalculus (java.lang.String calculus) {
		this.calculus = calculus;
	}



	/**
	 * Return the value associated with the column: calculus_value
	 */
	public java.lang.String getCalculusValue () {
		return calculusValue;
	}

	/**
	 * Set the value related to the column: calculus_value
	 * @param calculusValue the calculus_value value
	 */
	public void setCalculusValue (java.lang.String calculusValue) {
		this.calculusValue = calculusValue;
	}



	/**
	 * Return the value associated with the column: oral_lesions
	 */
	public java.lang.String getOralLesions () {
		return oralLesions;
	}

	/**
	 * Set the value related to the column: oral_lesions
	 * @param oralLesions the oral_lesions value
	 */
	public void setOralLesions (java.lang.String oralLesions) {
		this.oralLesions = oralLesions;
	}



	/**
	 * Return the value associated with the column: oral_lesions_value
	 */
	public java.lang.String getOralLesionsValue () {
		return oralLesionsValue;
	}

	/**
	 * Set the value related to the column: oral_lesions_value
	 * @param oralLesionsValue the oral_lesions_value value
	 */
	public void setOralLesionsValue (java.lang.String oralLesionsValue) {
		this.oralLesionsValue = oralLesionsValue;
	}



	/**
	 * Return the value associated with the column: defects
	 */
	public java.lang.String getDefects () {
		return defects;
	}

	/**
	 * Set the value related to the column: defects
	 * @param defects the defects value
	 */
	public void setDefects (java.lang.String defects) {
		this.defects = defects;
	}



	/**
	 * Return the value associated with the column: defects_value
	 */
	public java.lang.String getDefectsValue () {
		return defectsValue;
	}

	/**
	 * Set the value related to the column: defects_value
	 * @param defectsValue the defects_value value
	 */
	public void setDefectsValue (java.lang.String defectsValue) {
		this.defectsValue = defectsValue;
	}



	/**
	 * Return the value associated with the column: mouth_opening
	 */
	public java.lang.String getMouthOpening () {
		return mouthOpening;
	}

	/**
	 * Set the value related to the column: mouth_opening
	 * @param mouthOpening the mouth_opening value
	 */
	public void setMouthOpening (java.lang.String mouthOpening) {
		this.mouthOpening = mouthOpening;
	}



	/**
	 * Return the value associated with the column: mouth_opening_value
	 */
	public java.lang.String getMouthOpeningValue () {
		return mouthOpeningValue;
	}

	/**
	 * Set the value related to the column: mouth_opening_value
	 * @param mouthOpeningValue the mouth_opening_value value
	 */
	public void setMouthOpeningValue (java.lang.String mouthOpeningValue) {
		this.mouthOpeningValue = mouthOpeningValue;
	}



	/**
	 * Return the value associated with the column: preprosthetic_procedures
	 */
	public java.lang.String getPreprostheticProcedures () {
		return preprostheticProcedures;
	}

	/**
	 * Set the value related to the column: preprosthetic_procedures
	 * @param preprostheticProcedures the preprosthetic_procedures value
	 */
	public void setPreprostheticProcedures (java.lang.String preprostheticProcedures) {
		this.preprostheticProcedures = preprostheticProcedures;
	}



	/**
	 * Return the value associated with the column: preprosthetic_procedures_value
	 */
	public java.lang.String getPreprostheticProceduresValue () {
		return preprostheticProceduresValue;
	}

	/**
	 * Set the value related to the column: preprosthetic_procedures_value
	 * @param preprostheticProceduresValue the preprosthetic_procedures_value value
	 */
	public void setPreprostheticProceduresValue (java.lang.String preprostheticProceduresValue) {
		this.preprostheticProceduresValue = preprostheticProceduresValue;
	}



	/**
	 * Return the value associated with the column: minorsurgical_procedures
	 */
	public java.lang.String getMinorsurgicalProcedures () {
		return minorsurgicalProcedures;
	}

	/**
	 * Set the value related to the column: minorsurgical_procedures
	 * @param minorsurgicalProcedures the minorsurgical_procedures value
	 */
	public void setMinorsurgicalProcedures (java.lang.String minorsurgicalProcedures) {
		this.minorsurgicalProcedures = minorsurgicalProcedures;
	}



	/**
	 * Return the value associated with the column: minorsurgical_procedures_value
	 */
	public java.lang.String getMinorsurgicalProceduresValue () {
		return minorsurgicalProceduresValue;
	}

	/**
	 * Set the value related to the column: minorsurgical_procedures_value
	 * @param minorsurgicalProceduresValue the minorsurgical_procedures_value value
	 */
	public void setMinorsurgicalProceduresValue (java.lang.String minorsurgicalProceduresValue) {
		this.minorsurgicalProceduresValue = minorsurgicalProceduresValue;
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
	 * Return the value associated with the column: OpdPreAssessmentClinicDentals
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPreAssessmentClinicDental> getOpdPreAssessmentClinicDentals () {
		return opdPreAssessmentClinicDentals;
	}

	/**
	 * Set the value related to the column: OpdPreAssessmentClinicDentals
	 * @param opdPreAssessmentClinicDentals the OpdPreAssessmentClinicDentals value
	 */
	public void setOpdPreAssessmentClinicDentals (java.util.Set<jkt.hms.masters.business.OpdPreAssessmentClinicDental> opdPreAssessmentClinicDentals) {
		this.opdPreAssessmentClinicDentals = opdPreAssessmentClinicDentals;
	}

	public void addToOpdPreAssessmentClinicDentals (jkt.hms.masters.business.OpdPreAssessmentClinicDental opdPreAssessmentClinicDental) {
		if (null == getOpdPreAssessmentClinicDentals()) setOpdPreAssessmentClinicDentals(new java.util.TreeSet<jkt.hms.masters.business.OpdPreAssessmentClinicDental>());
		getOpdPreAssessmentClinicDentals().add(opdPreAssessmentClinicDental);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdDiagnosticRecord)) return false;
		else {
			jkt.hms.masters.business.OpdDiagnosticRecord opdDiagnosticRecord = (jkt.hms.masters.business.OpdDiagnosticRecord) obj;
			if (null == this.getId() || null == opdDiagnosticRecord.getId()) return false;
			else return (this.getId().equals(opdDiagnosticRecord.getId()));
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