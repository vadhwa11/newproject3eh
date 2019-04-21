package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_fitness_certificate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_fitness_certificate"
 */

public abstract class BasePatientFitnessCertificate  implements Serializable {

	public static String REF = "PatientFitnessCertificate";
	public static String PROP_HAEMO = "Haemo";
	public static String PROP_TLC = "Tlc";
	public static String PROP_POLY = "Poly";
	public static String PROP_ANS = "Ans";
	public static String PROP_RES_SYSTEM = "ResSystem";
	public static String PROP_GENERAL_PHYSICAL_EXAM = "GeneralPhysicalExam";
	public static String PROP_GENITO_URINARY = "GenitoUrinary";
	public static String PROP_ACTIVITY_OF_VISION = "ActivityOfVision";
	public static String PROP_HB = "Hb";
	public static String PROP_FITNESS_CERTIFICATE_NO = "FitnessCertificateNo";
	public static String PROP_CNS = "Cns";
	public static String PROP_CVS = "Cvs";
	public static String PROP_COLOR_VISION = "ColorVision";
	public static String PROP_PA = "Pa";
	public static String PROP_OHE = "Ohe";
	public static String PROP_LETHO = "Letho";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_BIL = "Bil";
	public static String PROP_ACE = "Ace";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_SYSTEMIC_EXAM = "SystemicExam";
	public static String PROP_ID = "Id";
	public static String PROP_MA = "Ma";
	public static String PROP_HIN = "Hin";
	public static String PROP_ESNO = "Esno";


	// constructors
	public BasePatientFitnessCertificate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientFitnessCertificate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String generalPhysicalExam;
	private java.lang.String systemicExam;
	private java.lang.String resSystem;
	private java.lang.String cvs;
	private java.lang.String pa;
	private java.lang.String genitoUrinary;
	private java.lang.String cns;
	private java.lang.String ans;
	private java.lang.String bloodGroup;
	private java.lang.String haemo;
	private java.lang.Integer hb;
	private java.lang.Integer tlc;
	private java.lang.Integer poly;
	private java.lang.Integer letho;
	private java.lang.Integer esno;
	private java.lang.Integer ma;
	private java.lang.Integer bil;
	private java.lang.String fitnessCertificateNo;
	private java.lang.String activityOfVision;
	private java.lang.String colorVision;
	private java.lang.String ohe;
	private java.lang.String ace;
	private java.lang.String hospitalName;

	// many to one
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pat_fitness_id"
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
	 * Return the value associated with the column: general_physical_exam
	 */
	public java.lang.String getGeneralPhysicalExam () {
		return generalPhysicalExam;
	}

	/**
	 * Set the value related to the column: general_physical_exam
	 * @param generalPhysicalExam the general_physical_exam value
	 */
	public void setGeneralPhysicalExam (java.lang.String generalPhysicalExam) {
		this.generalPhysicalExam = generalPhysicalExam;
	}



	/**
	 * Return the value associated with the column: systemic_exam
	 */
	public java.lang.String getSystemicExam () {
		return systemicExam;
	}

	/**
	 * Set the value related to the column: systemic_exam
	 * @param systemicExam the systemic_exam value
	 */
	public void setSystemicExam (java.lang.String systemicExam) {
		this.systemicExam = systemicExam;
	}



	/**
	 * Return the value associated with the column: res_system
	 */
	public java.lang.String getResSystem () {
		return resSystem;
	}

	/**
	 * Set the value related to the column: res_system
	 * @param resSystem the res_system value
	 */
	public void setResSystem (java.lang.String resSystem) {
		this.resSystem = resSystem;
	}



	/**
	 * Return the value associated with the column: cvs
	 */
	public java.lang.String getCvs () {
		return cvs;
	}

	/**
	 * Set the value related to the column: cvs
	 * @param cvs the cvs value
	 */
	public void setCvs (java.lang.String cvs) {
		this.cvs = cvs;
	}



	/**
	 * Return the value associated with the column: pa
	 */
	public java.lang.String getPa () {
		return pa;
	}

	/**
	 * Set the value related to the column: pa
	 * @param pa the pa value
	 */
	public void setPa (java.lang.String pa) {
		this.pa = pa;
	}



	/**
	 * Return the value associated with the column: genito_urinary
	 */
	public java.lang.String getGenitoUrinary () {
		return genitoUrinary;
	}

	/**
	 * Set the value related to the column: genito_urinary
	 * @param genitoUrinary the genito_urinary value
	 */
	public void setGenitoUrinary (java.lang.String genitoUrinary) {
		this.genitoUrinary = genitoUrinary;
	}



	/**
	 * Return the value associated with the column: cns
	 */
	public java.lang.String getCns () {
		return cns;
	}

	/**
	 * Set the value related to the column: cns
	 * @param cns the cns value
	 */
	public void setCns (java.lang.String cns) {
		this.cns = cns;
	}



	/**
	 * Return the value associated with the column: ans
	 */
	public java.lang.String getAns () {
		return ans;
	}

	/**
	 * Set the value related to the column: ans
	 * @param ans the ans value
	 */
	public void setAns (java.lang.String ans) {
		this.ans = ans;
	}



	/**
	 * Return the value associated with the column: blood_group
	 */
	public java.lang.String getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group
	 * @param bloodGroup the blood_group value
	 */
	public void setBloodGroup (java.lang.String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: haemo
	 */
	public java.lang.String getHaemo () {
		return haemo;
	}

	/**
	 * Set the value related to the column: haemo
	 * @param haemo the haemo value
	 */
	public void setHaemo (java.lang.String haemo) {
		this.haemo = haemo;
	}



	/**
	 * Return the value associated with the column: hb
	 */
	public java.lang.Integer getHb () {
		return hb;
	}

	/**
	 * Set the value related to the column: hb
	 * @param hb the hb value
	 */
	public void setHb (java.lang.Integer hb) {
		this.hb = hb;
	}



	/**
	 * Return the value associated with the column: tlc
	 */
	public java.lang.Integer getTlc () {
		return tlc;
	}

	/**
	 * Set the value related to the column: tlc
	 * @param tlc the tlc value
	 */
	public void setTlc (java.lang.Integer tlc) {
		this.tlc = tlc;
	}



	/**
	 * Return the value associated with the column: poly
	 */
	public java.lang.Integer getPoly () {
		return poly;
	}

	/**
	 * Set the value related to the column: poly
	 * @param poly the poly value
	 */
	public void setPoly (java.lang.Integer poly) {
		this.poly = poly;
	}



	/**
	 * Return the value associated with the column: letho
	 */
	public java.lang.Integer getLetho () {
		return letho;
	}

	/**
	 * Set the value related to the column: letho
	 * @param letho the letho value
	 */
	public void setLetho (java.lang.Integer letho) {
		this.letho = letho;
	}



	/**
	 * Return the value associated with the column: esno
	 */
	public java.lang.Integer getEsno () {
		return esno;
	}

	/**
	 * Set the value related to the column: esno
	 * @param esno the esno value
	 */
	public void setEsno (java.lang.Integer esno) {
		this.esno = esno;
	}



	/**
	 * Return the value associated with the column: ma
	 */
	public java.lang.Integer getMa () {
		return ma;
	}

	/**
	 * Set the value related to the column: ma
	 * @param ma the ma value
	 */
	public void setMa (java.lang.Integer ma) {
		this.ma = ma;
	}



	/**
	 * Return the value associated with the column: bil
	 */
	public java.lang.Integer getBil () {
		return bil;
	}

	/**
	 * Set the value related to the column: bil
	 * @param bil the bil value
	 */
	public void setBil (java.lang.Integer bil) {
		this.bil = bil;
	}



	/**
	 * Return the value associated with the column: fitness_certificate_no
	 */
	public java.lang.String getFitnessCertificateNo () {
		return fitnessCertificateNo;
	}

	/**
	 * Set the value related to the column: fitness_certificate_no
	 * @param fitnessCertificateNo the fitness_certificate_no value
	 */
	public void setFitnessCertificateNo (java.lang.String fitnessCertificateNo) {
		this.fitnessCertificateNo = fitnessCertificateNo;
	}



	/**
	 * Return the value associated with the column: activity_of_vision
	 */
	public java.lang.String getActivityOfVision () {
		return activityOfVision;
	}

	/**
	 * Set the value related to the column: activity_of_vision
	 * @param activityOfVision the activity_of_vision value
	 */
	public void setActivityOfVision (java.lang.String activityOfVision) {
		this.activityOfVision = activityOfVision;
	}



	/**
	 * Return the value associated with the column: color_of_vision
	 */
	public java.lang.String getColorVision () {
		return colorVision;
	}

	/**
	 * Set the value related to the column: color_of_vision
	 * @param colorVision the color_of_vision value
	 */
	public void setColorVision (java.lang.String colorVision) {
		this.colorVision = colorVision;
	}



	/**
	 * Return the value associated with the column: ohe
	 */
	public java.lang.String getOhe () {
		return ohe;
	}

	/**
	 * Set the value related to the column: ohe
	 * @param ohe the ohe value
	 */
	public void setOhe (java.lang.String ohe) {
		this.ohe = ohe;
	}



	/**
	 * Return the value associated with the column: ace
	 */
	public java.lang.String getAce () {
		return ace;
	}

	/**
	 * Set the value related to the column: ace
	 * @param ace the ace value
	 */
	public void setAce (java.lang.String ace) {
		this.ace = ace;
	}



	/**
	 * Return the value associated with the column: hospital_name
	 */
	public java.lang.String getHospitalName () {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: hospital_name
	 * @param hospitalName the hospital_name value
	 */
	public void setHospitalName (java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientFitnessCertificate)) return false;
		else {
			jkt.hms.masters.business.PatientFitnessCertificate patientFitnessCertificate = (jkt.hms.masters.business.PatientFitnessCertificate) obj;
			if (null == this.getId() || null == patientFitnessCertificate.getId()) return false;
			else return (this.getId().equals(patientFitnessCertificate.getId()));
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