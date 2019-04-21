package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_student_registration table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_student_registration"
 */

public abstract class BasePhStudentRegistration  implements Serializable {

	public static String REF = "PhStudentRegistration";
	public static String PROP_CLASSDETAILS = "Classdetails";
	public static String PROP_IDENTIFICATION_MARK_TWO = "IdentificationMarkTwo";
	public static String PROP_RELATION = "Relation";
	public static String PROP_GUARDIAN_CONTACTNO = "GuardianContactno";
	public static String PROP_IDENTIFICATION_MARK_ONE = "IdentificationMarkOne";
	public static String PROP_EDUCATION_STATUS_FATHER = "EducationStatusFather";
	public static String PROP_MEMBERSURVEY = "Membersurvey";
	public static String PROP_CONTACT_NO_MOTHER = "ContactNoMother";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_FATHER_NAME = "FatherName";
	public static String PROP_JOININGDATE = "Joiningdate";
	public static String PROP_PLACE_OF_BIRTH = "PlaceOfBirth";
	public static String PROP_GUARDIAN_ADDRESS = "GuardianAddress";
	public static String PROP_OCCUPATION_MOTHER = "OccupationMother";
	public static String PROP_MOTHER_NAME = "MotherName";
	public static String PROP_OCCUPATION_FATHER = "OccupationFather";
	public static String PROP_EDUCATION_STATUS_MOTHER = "EducationStatusMother";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ADMISSION_NO = "AdmissionNo";
	public static String PROP_BIRTH_ORDER_OF_THIS_CHILD = "BirthOrderOfThisChild";
	public static String PROP_ID = "Id";
	public static String PROP_GUARDIAN_NAME = "GuardianName";
	public static String PROP_CONTACT_NO_FATHER = "ContactNoFather";
	public static String PROP_NAME_OF_SIBLINGS = "NameOfSiblings";


	// constructors
	public BasePhStudentRegistration () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhStudentRegistration (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhStudentRegistration (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital) {

		this.setId(id);
		this.setHospital(hospital);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date joiningdate;
	private java.lang.String admissionNo;
	private java.lang.String identificationMarkOne;
	private java.lang.String identificationMarkTwo;
	private java.lang.String address;
	private java.lang.String nameOfSiblings;
	private java.lang.String birthOrderOfThisChild;
	private java.lang.String placeOfBirth;
	private java.lang.String guardianAddress;
	private java.lang.String guardianName;
	private java.lang.String guardianContactno;
	private java.lang.String motherName;
	private java.lang.String fatherName;
	private java.lang.String educationStatusMother;
	private java.lang.String educationStatusFather;
	private java.lang.String contactNoMother;
	private java.lang.String contactNoFather;

	// many to one
	private jkt.hms.masters.business.MasOccupation occupationMother;
	private jkt.hms.masters.business.MasOccupation occupationFather;
	private jkt.hms.masters.business.PhClassDetails classdetails;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.PhMemberSurvey membersurvey;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="student_id"
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
	 * Return the value associated with the column: joiningdate
	 */
	public java.util.Date getJoiningdate () {
		return joiningdate;
	}

	/**
	 * Set the value related to the column: joiningdate
	 * @param joiningdate the joiningdate value
	 */
	public void setJoiningdate (java.util.Date joiningdate) {
		this.joiningdate = joiningdate;
	}



	/**
	 * Return the value associated with the column: admission_no
	 */
	public java.lang.String getAdmissionNo () {
		return admissionNo;
	}

	/**
	 * Set the value related to the column: admission_no
	 * @param admissionNo the admission_no value
	 */
	public void setAdmissionNo (java.lang.String admissionNo) {
		this.admissionNo = admissionNo;
	}



	/**
	 * Return the value associated with the column: identification_mark_one
	 */
	public java.lang.String getIdentificationMarkOne () {
		return identificationMarkOne;
	}

	/**
	 * Set the value related to the column: identification_mark_one
	 * @param identificationMarkOne the identification_mark_one value
	 */
	public void setIdentificationMarkOne (java.lang.String identificationMarkOne) {
		this.identificationMarkOne = identificationMarkOne;
	}



	/**
	 * Return the value associated with the column: identification_mark_two
	 */
	public java.lang.String getIdentificationMarkTwo () {
		return identificationMarkTwo;
	}

	/**
	 * Set the value related to the column: identification_mark_two
	 * @param identificationMarkTwo the identification_mark_two value
	 */
	public void setIdentificationMarkTwo (java.lang.String identificationMarkTwo) {
		this.identificationMarkTwo = identificationMarkTwo;
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
	 * Return the value associated with the column: name_of_siblings
	 */
	public java.lang.String getNameOfSiblings () {
		return nameOfSiblings;
	}

	/**
	 * Set the value related to the column: name_of_siblings
	 * @param nameOfSiblings the name_of_siblings value
	 */
	public void setNameOfSiblings (java.lang.String nameOfSiblings) {
		this.nameOfSiblings = nameOfSiblings;
	}



	/**
	 * Return the value associated with the column: birth_order_of_this_child
	 */
	public java.lang.String getBirthOrderOfThisChild () {
		return birthOrderOfThisChild;
	}

	/**
	 * Set the value related to the column: birth_order_of_this_child
	 * @param birthOrderOfThisChild the birth_order_of_this_child value
	 */
	public void setBirthOrderOfThisChild (java.lang.String birthOrderOfThisChild) {
		this.birthOrderOfThisChild = birthOrderOfThisChild;
	}



	/**
	 * Return the value associated with the column: place_of_birth
	 */
	public java.lang.String getPlaceOfBirth () {
		return placeOfBirth;
	}

	/**
	 * Set the value related to the column: place_of_birth
	 * @param placeOfBirth the place_of_birth value
	 */
	public void setPlaceOfBirth (java.lang.String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}



	/**
	 * Return the value associated with the column: guardian_address
	 */
	public java.lang.String getGuardianAddress () {
		return guardianAddress;
	}

	/**
	 * Set the value related to the column: guardian_address
	 * @param guardianAddress the guardian_address value
	 */
	public void setGuardianAddress (java.lang.String guardianAddress) {
		this.guardianAddress = guardianAddress;
	}



	/**
	 * Return the value associated with the column: guardian_name
	 */
	public java.lang.String getGuardianName () {
		return guardianName;
	}

	/**
	 * Set the value related to the column: guardian_name
	 * @param guardianName the guardian_name value
	 */
	public void setGuardianName (java.lang.String guardianName) {
		this.guardianName = guardianName;
	}



	/**
	 * Return the value associated with the column: guardian_contactno
	 */
	public java.lang.String getGuardianContactno () {
		return guardianContactno;
	}

	/**
	 * Set the value related to the column: guardian_contactno
	 * @param guardianContactno the guardian_contactno value
	 */
	public void setGuardianContactno (java.lang.String guardianContactno) {
		this.guardianContactno = guardianContactno;
	}



	/**
	 * Return the value associated with the column: mother_name
	 */
	public java.lang.String getMotherName () {
		return motherName;
	}

	/**
	 * Set the value related to the column: mother_name
	 * @param motherName the mother_name value
	 */
	public void setMotherName (java.lang.String motherName) {
		this.motherName = motherName;
	}



	/**
	 * Return the value associated with the column: father_name
	 */
	public java.lang.String getFatherName () {
		return fatherName;
	}

	/**
	 * Set the value related to the column: father_name
	 * @param fatherName the father_name value
	 */
	public void setFatherName (java.lang.String fatherName) {
		this.fatherName = fatherName;
	}



	/**
	 * Return the value associated with the column: education_status_mother
	 */
	public java.lang.String getEducationStatusMother () {
		return educationStatusMother;
	}

	/**
	 * Set the value related to the column: education_status_mother
	 * @param educationStatusMother the education_status_mother value
	 */
	public void setEducationStatusMother (java.lang.String educationStatusMother) {
		this.educationStatusMother = educationStatusMother;
	}



	/**
	 * Return the value associated with the column: education_status_father
	 */
	public java.lang.String getEducationStatusFather () {
		return educationStatusFather;
	}

	/**
	 * Set the value related to the column: education_status_father
	 * @param educationStatusFather the education_status_father value
	 */
	public void setEducationStatusFather (java.lang.String educationStatusFather) {
		this.educationStatusFather = educationStatusFather;
	}



	/**
	 * Return the value associated with the column: contact_no_Mother
	 */
	public java.lang.String getContactNoMother () {
		return contactNoMother;
	}

	/**
	 * Set the value related to the column: contact_no_Mother
	 * @param contactNoMother the contact_no_Mother value
	 */
	public void setContactNoMother (java.lang.String contactNoMother) {
		this.contactNoMother = contactNoMother;
	}



	/**
	 * Return the value associated with the column: contact_no_father
	 */
	public java.lang.String getContactNoFather () {
		return contactNoFather;
	}

	/**
	 * Set the value related to the column: contact_no_father
	 * @param contactNoFather the contact_no_father value
	 */
	public void setContactNoFather (java.lang.String contactNoFather) {
		this.contactNoFather = contactNoFather;
	}



	/**
	 * Return the value associated with the column: occupation_id_mother
	 */
	public jkt.hms.masters.business.MasOccupation getOccupationMother () {
		return occupationMother;
	}

	/**
	 * Set the value related to the column: occupation_id_mother
	 * @param occupationMother the occupation_id_mother value
	 */
	public void setOccupationMother (jkt.hms.masters.business.MasOccupation occupationMother) {
		this.occupationMother = occupationMother;
	}



	/**
	 * Return the value associated with the column: occupation_id_father
	 */
	public jkt.hms.masters.business.MasOccupation getOccupationFather () {
		return occupationFather;
	}

	/**
	 * Set the value related to the column: occupation_id_father
	 * @param occupationFather the occupation_id_father value
	 */
	public void setOccupationFather (jkt.hms.masters.business.MasOccupation occupationFather) {
		this.occupationFather = occupationFather;
	}



	/**
	 * Return the value associated with the column: classdetails
	 */
	public jkt.hms.masters.business.PhClassDetails getClassdetails () {
		return classdetails;
	}

	/**
	 * Set the value related to the column: classdetails
	 * @param classdetails the classdetails value
	 */
	public void setClassdetails (jkt.hms.masters.business.PhClassDetails classdetails) {
		this.classdetails = classdetails;
	}



	/**
	 * Return the value associated with the column: relation
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation
	 * @param relation the relation value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: membersurvey
	 */
	public jkt.hms.masters.business.PhMemberSurvey getMembersurvey () {
		return membersurvey;
	}

	/**
	 * Set the value related to the column: membersurvey
	 * @param membersurvey the membersurvey value
	 */
	public void setMembersurvey (jkt.hms.masters.business.PhMemberSurvey membersurvey) {
		this.membersurvey = membersurvey;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhStudentRegistration)) return false;
		else {
			jkt.hms.masters.business.PhStudentRegistration phStudentRegistration = (jkt.hms.masters.business.PhStudentRegistration) obj;
			if (null == this.getId() || null == phStudentRegistration.getId()) return false;
			else return (this.getId().equals(phStudentRegistration.getId()));
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