package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_endodontics_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_endodontics_header"
 */

public abstract class BaseOpdEndodonticsHeader  implements Serializable {

	public static String REF = "OpdEndodonticsHeader";
	public static String PROP_NATURE_OF_PAIN = "NatureOfPain";
	public static String PROP_FACIALSWELLINGA_VALUE = "FacialswellingaValue";
	public static String PROP_ONSET = "Onset";
	public static String PROP_OTHERS = "Others";
	public static String PROP_QUALITY = "Quality";
	public static String PROP_LYMPHNODE_ENLARGEMENT_VALUE = "LymphnodeEnlargementValue";
	public static String PROP_SWELLING = "Swelling";
	public static String PROP_FACIALSWELLINGA = "Facialswellinga";
	public static String PROP_INITIATED_BY = "InitiatedBy";
	public static String PROP_DURATION = "Duration";
	public static String PROP_SINUS_TRACTVALUE = "SinusTractvalue";
	public static String PROP_RELEIVED_BY = "ReleivedBy";
	public static String PROP_SWELLING_VALUE = "SwellingValue";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LOCATION = "Location";
	public static String PROP_LOCATION_ENDODONTICS = "LocationEndodontics";
	public static String PROP_SINUS_TRACT = "SinusTract";
	public static String PROP_VISIT = "Visit";
	public static String PROP_CHIEF_COMPLAINT_VALUE = "ChiefComplaintValue";
	public static String PROP_NATURE = "Nature";
	public static String PROP_CHIEF_COMPLAINT = "ChiefComplaint";
	public static String PROP_ID = "Id";
	public static String PROP_LYMPHNODE_ENLARGEMENT = "LymphnodeEnlargement";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOpdEndodonticsHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdEndodonticsHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String chiefComplaint;
	private java.lang.String chiefComplaintValue;
	private java.lang.String natureOfPain;
	private java.lang.String quality;
	private java.lang.String onset;
	private java.lang.String location;
	private java.lang.String duration;
	private java.lang.String initiatedBy;
	private java.lang.String releivedBy;
	private java.lang.String others;
	private java.lang.String facialswellinga;
	private java.lang.String facialswellingaValue;
	private java.lang.String lymphnodeEnlargement;
	private java.lang.String lymphnodeEnlargementValue;
	private java.lang.String swelling;
	private java.lang.String swellingValue;
	private java.lang.String nature;
	private java.lang.String locationEndodontics;
	private java.lang.String sinusTract;
	private java.lang.String sinusTractvalue;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdPreAssessmentClinicDental> opdPreAssessmentClinicDentals;
	private java.util.Set<jkt.hms.masters.business.OpdTreatment> opdTreatments;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="endodontics_header_id"
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
	 * Return the value associated with the column: chief_complaint_value
	 */
	public java.lang.String getChiefComplaintValue () {
		return chiefComplaintValue;
	}

	/**
	 * Set the value related to the column: chief_complaint_value
	 * @param chiefComplaintValue the chief_complaint_value value
	 */
	public void setChiefComplaintValue (java.lang.String chiefComplaintValue) {
		this.chiefComplaintValue = chiefComplaintValue;
	}



	/**
	 * Return the value associated with the column: nature_of_pain
	 */
	public java.lang.String getNatureOfPain () {
		return natureOfPain;
	}

	/**
	 * Set the value related to the column: nature_of_pain
	 * @param natureOfPain the nature_of_pain value
	 */
	public void setNatureOfPain (java.lang.String natureOfPain) {
		this.natureOfPain = natureOfPain;
	}



	/**
	 * Return the value associated with the column: quality
	 */
	public java.lang.String getQuality () {
		return quality;
	}

	/**
	 * Set the value related to the column: quality
	 * @param quality the quality value
	 */
	public void setQuality (java.lang.String quality) {
		this.quality = quality;
	}



	/**
	 * Return the value associated with the column: onset
	 */
	public java.lang.String getOnset () {
		return onset;
	}

	/**
	 * Set the value related to the column: onset
	 * @param onset the onset value
	 */
	public void setOnset (java.lang.String onset) {
		this.onset = onset;
	}



	/**
	 * Return the value associated with the column: location
	 */
	public java.lang.String getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location
	 * @param location the location value
	 */
	public void setLocation (java.lang.String location) {
		this.location = location;
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
	 * Return the value associated with the column: initiated_by
	 */
	public java.lang.String getInitiatedBy () {
		return initiatedBy;
	}

	/**
	 * Set the value related to the column: initiated_by
	 * @param initiatedBy the initiated_by value
	 */
	public void setInitiatedBy (java.lang.String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}



	/**
	 * Return the value associated with the column: releived_by
	 */
	public java.lang.String getReleivedBy () {
		return releivedBy;
	}

	/**
	 * Set the value related to the column: releived_by
	 * @param releivedBy the releived_by value
	 */
	public void setReleivedBy (java.lang.String releivedBy) {
		this.releivedBy = releivedBy;
	}



	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.String getOthers () {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * @param others the others value
	 */
	public void setOthers (java.lang.String others) {
		this.others = others;
	}



	/**
	 * Return the value associated with the column: facialswellinga
	 */
	public java.lang.String getFacialswellinga () {
		return facialswellinga;
	}

	/**
	 * Set the value related to the column: facialswellinga
	 * @param facialswellinga the facialswellinga value
	 */
	public void setFacialswellinga (java.lang.String facialswellinga) {
		this.facialswellinga = facialswellinga;
	}



	/**
	 * Return the value associated with the column: facialswellinga_value
	 */
	public java.lang.String getFacialswellingaValue () {
		return facialswellingaValue;
	}

	/**
	 * Set the value related to the column: facialswellinga_value
	 * @param facialswellingaValue the facialswellinga_value value
	 */
	public void setFacialswellingaValue (java.lang.String facialswellingaValue) {
		this.facialswellingaValue = facialswellingaValue;
	}



	/**
	 * Return the value associated with the column: lymphnode_enlargement
	 */
	public java.lang.String getLymphnodeEnlargement () {
		return lymphnodeEnlargement;
	}

	/**
	 * Set the value related to the column: lymphnode_enlargement
	 * @param lymphnodeEnlargement the lymphnode_enlargement value
	 */
	public void setLymphnodeEnlargement (java.lang.String lymphnodeEnlargement) {
		this.lymphnodeEnlargement = lymphnodeEnlargement;
	}



	/**
	 * Return the value associated with the column: lymphnode_enlargement_value
	 */
	public java.lang.String getLymphnodeEnlargementValue () {
		return lymphnodeEnlargementValue;
	}

	/**
	 * Set the value related to the column: lymphnode_enlargement_value
	 * @param lymphnodeEnlargementValue the lymphnode_enlargement_value value
	 */
	public void setLymphnodeEnlargementValue (java.lang.String lymphnodeEnlargementValue) {
		this.lymphnodeEnlargementValue = lymphnodeEnlargementValue;
	}



	/**
	 * Return the value associated with the column: swelling
	 */
	public java.lang.String getSwelling () {
		return swelling;
	}

	/**
	 * Set the value related to the column: swelling
	 * @param swelling the swelling value
	 */
	public void setSwelling (java.lang.String swelling) {
		this.swelling = swelling;
	}



	/**
	 * Return the value associated with the column: swelling_value
	 */
	public java.lang.String getSwellingValue () {
		return swellingValue;
	}

	/**
	 * Set the value related to the column: swelling_value
	 * @param swellingValue the swelling_value value
	 */
	public void setSwellingValue (java.lang.String swellingValue) {
		this.swellingValue = swellingValue;
	}



	/**
	 * Return the value associated with the column: nature
	 */
	public java.lang.String getNature () {
		return nature;
	}

	/**
	 * Set the value related to the column: nature
	 * @param nature the nature value
	 */
	public void setNature (java.lang.String nature) {
		this.nature = nature;
	}



	/**
	 * Return the value associated with the column: location_endodontics
	 */
	public java.lang.String getLocationEndodontics () {
		return locationEndodontics;
	}

	/**
	 * Set the value related to the column: location_endodontics
	 * @param locationEndodontics the location_endodontics value
	 */
	public void setLocationEndodontics (java.lang.String locationEndodontics) {
		this.locationEndodontics = locationEndodontics;
	}



	/**
	 * Return the value associated with the column: sinus_tract
	 */
	public java.lang.String getSinusTract () {
		return sinusTract;
	}

	/**
	 * Set the value related to the column: sinus_tract
	 * @param sinusTract the sinus_tract value
	 */
	public void setSinusTract (java.lang.String sinusTract) {
		this.sinusTract = sinusTract;
	}



	/**
	 * Return the value associated with the column: sinus_tractvalue
	 */
	public java.lang.String getSinusTractvalue () {
		return sinusTractvalue;
	}

	/**
	 * Set the value related to the column: sinus_tractvalue
	 * @param sinusTractvalue the sinus_tractvalue value
	 */
	public void setSinusTractvalue (java.lang.String sinusTractvalue) {
		this.sinusTractvalue = sinusTractvalue;
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



	/**
	 * Return the value associated with the column: OpdTreatments
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTreatment> getOpdTreatments () {
		return opdTreatments;
	}

	/**
	 * Set the value related to the column: OpdTreatments
	 * @param opdTreatments the OpdTreatments value
	 */
	public void setOpdTreatments (java.util.Set<jkt.hms.masters.business.OpdTreatment> opdTreatments) {
		this.opdTreatments = opdTreatments;
	}

	public void addToOpdTreatments (jkt.hms.masters.business.OpdTreatment opdTreatment) {
		if (null == getOpdTreatments()) setOpdTreatments(new java.util.TreeSet<jkt.hms.masters.business.OpdTreatment>());
		getOpdTreatments().add(opdTreatment);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdEndodonticsHeader)) return false;
		else {
			jkt.hms.masters.business.OpdEndodonticsHeader opdEndodonticsHeader = (jkt.hms.masters.business.OpdEndodonticsHeader) obj;
			if (null == this.getId() || null == opdEndodonticsHeader.getId()) return false;
			else return (this.getId().equals(opdEndodonticsHeader.getId()));
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