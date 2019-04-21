package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_antenatal_card table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_antenatal_card"
 */

public abstract class BaseOpdAntenatalCard  implements Serializable {

	public static String REF = "OpdAntenatalCard";
	public static String PROP_LMP_GA_ONE = "LmpGaOne";
	public static String PROP_BPP_TWO = "BppTwo";
	public static String PROP_DOPPLER_ONE = "DopplerOne";
	public static String PROP_LMP = "Lmp";
	public static String PROP_EDEMA = "Edema";
	public static String PROP_BPD_THREE = "BpdThree";
	public static String PROP_FASTING = "Fasting";
	public static String PROP_SURGICAL = "Surgical";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BREAST_FEEDING = "BreastFeeding";
	public static String PROP_FHS_FM = "FhsFm";
	public static String PROP_AC_THREE = "AcThree";
	public static String PROP_ECLAMPSIA = "Eclampsia";
	public static String PROP_HC_TWO = "HcTwo";
	public static String PROP_ANTENATAL_DATE = "AntenatalDate";
	public static String PROP_CONSANGUINEOUS = "Consanguineous";
	public static String PROP_LMP_GA_THREE = "LmpGaThree";
	public static String PROP_VASECTOMY = "vasectomy";
	public static String PROP_TETANUS_ONEST_DOSE_DATE = "TetanusOnestDoseDate";
	public static String PROP_CYCLE = "Cycle";
	public static String PROP_USG_GA_USG_REPORT = "UsgGaUsgReport";
	public static String PROP_HYPERTEN_PRE_YN = "HypertenPreYn";
	public static String PROP_EBW_USG_REPORT = "EbwUsgReport";
	public static String PROP_LMP_GA_USG_REPORT = "LmpGaUsgReport";
	public static String PROP_CLUBBING = "Clubbing";
	public static String PROP_PARA = "Para";
	public static String PROP_TWO_HR = "TwoHr";
	public static String PROP_USG_REMARKS = "UsgRemarks";
	public static String PROP_REFFERED_HOSPITAL = "RefferedHospital";
	public static String PROP_BMI_STATUS = "BmiStatus";
	public static String PROP_CYCLE_FLOW = "cycleFlow";
	public static String PROP_DIDSHE_RECEIVE_YN = "DidsheReceiveYn";
	public static String PROP_USG_THIRD_REMARKS = "UsgThirdRemarks";
	public static String PROP_FL_USG_REPORT = "FlUsgReport";
	public static String PROP_HC_THREE = "HcThree";
	public static String PROP_ADVICE = "Advice";
	public static String PROP_STILL_BIRTH = "StillBirth";
	public static String PROP_DATE_USG_ONE = "DateUsgOne";
	public static String PROP_DM_YN = "DmYn";
	public static String PROP_SPINE = "Spine";
	public static String PROP_PALLOR = "Pallor";
	public static String PROP_DEGREE = "Degree";
	public static String PROP_VESICULAR = "Vesicular";
	public static String PROP_CVS_GEN_EXAM = "CvsGenExam";
	public static String PROP_INFERTILITY = "Infertility";
	public static String PROP_DURATION_OF_MARRIAGE_MONTH = "DurationOfMarriageMonth";
	public static String PROP_AFI_THREE = "AfiThree";
	public static String PROP_ANEMIA_YN = "AnemiaYn";
	public static String PROP_DURATION_OF_MARRIAGE_YEAR = "DurationOfMarriageYear";
	public static String PROP_OBSTETRIC_VALUES = "ObstetricValues";
	public static String PROP_AFI_TWO = "AfiTwo";
	public static String PROP_AGE_YEAR = "AgeYear";
	public static String PROP_CYANOSIS = "Cyanosis";
	public static String PROP_DOPPLER_THREE = "DopplerThree";
	public static String PROP_BUILD = "Build";
	public static String PROP_EBW_ONE = "EbwOne";
	public static String PROP_SEX = "Sex";
	public static String PROP_HEART = "Heart";
	public static String PROP_LYMPHADENOPATHY_VALUE = "LymphadenopathyValue";
	public static String PROP_BPD_USG_REPORT = "BpdUsgReport";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_OBSTER_COMPLCATN = "ObsterComplcatn";
	public static String PROP_OEDEMA = "Oedema";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SEVER_DEDUCT_TREAT = "SeverDeductTreat";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ENGAGEMENT = "Engagement";
	public static String PROP_TUBAL_LIGATION = "tubalLigation";
	public static String PROP_SURGICAL_HISTORY = "SurgicalHistory";
	public static String PROP_BLOOD_GROUP_HUSBAND = "BloodGroupHusband";
	public static String PROP_ONE_HR = "OneHr";
	public static String PROP_PERSONAL_HISTORY = "PersonalHistory";
	public static String PROP_ICTERUS = "Icterus";
	public static String PROP_NEXT_VISIT_ON = "NextVisitOn";
	public static String PROP_AGE = "Age";
	public static String PROP_IUD = "Iud";
	public static String PROP_CERCLAGE = "Cerclage";
	public static String PROP_USG_GA_ONE = "UsgGaOne";
	public static String PROP_HIGH_RISK_FACTORS = "HighRiskFactors";
	public static String PROP_MEDICAL_HISTORY = "MedicalHistory";
	public static String PROP_YEAR = "Year";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REFFERED_G_A = "RefferedGA";
	public static String PROP_BIRTH_WEIGHT = "BirthWeight";
	public static String PROP_DAYS = "Days";
	public static String PROP_OCP_S = "ocpS";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_MARRITAL_HISTORY_REMARKS = "MarritalHistoryRemarks";
	public static String PROP_OBSTETRIC_COMPLICATIONS = "ObstetricComplications";
	public static String PROP_DATE_USG_REPORT = "DateUsgReport";
	public static String PROP_BPP_THREE = "BppThree";
	public static String PROP_FL_THREE = "FlThree";
	public static String PROP_MULTIPLE_PREGNANCY = "MultiplePregnancy";
	public static String PROP_SURGICAL_HISTORY_RADIO = "SurgicalHistoryRadio";
	public static String PROP_CYCLE1 = "Cycle1";
	public static String PROP_SEVER_NAME_MEDCN = "SeverNameMedcn";
	public static String PROP_HIV = "Hiv";
	public static String PROP_CYCLE2 = "Cycle2";
	public static String PROP_FL_TWO = "FlTwo";
	public static String PROP_CYCLE3 = "Cycle3";
	public static String PROP_STS = "Sts";
	public static String PROP_TETANUS_TWOND_DOSE_DATE = "TetanusTwondDoseDate";
	public static String PROP_THYRIOD = "Thyriod";
	public static String PROP_CONDOM = "condom";
	public static String PROP_ABORTIONS = "Abortions";
	public static String PROP_STATUS = "Status";
	public static String PROP_DIETARY_HABIT = "DietaryHabit";
	public static String PROP_BP = "Bp";
	public static String PROP_BPP_USG_REPORT = "BppUsgReport";
	public static String PROP_HIN = "Hin";
	public static String PROP_HB_GMS = "HbGms";
	public static String PROP_HIP = "hip";
	public static String PROP_BPP_ONE = "BppOne";
	public static String PROP_DAYS1 = "Days1";
	public static String PROP_DAYS2 = "Days2";
	public static String PROP_REFERRED_FROM_PRIVATE_DETAIL = "ReferredFromPrivateDetail";
	public static String PROP_INTERVAL_IUCD = "intervalIucd";
	public static String PROP_EBW_TWO = "EbwTwo";
	public static String PROP_DAYS3 = "Days3";
	public static String PROP_BMI = "Bmi";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_GESTATIONAL_AGE_DAYS = "GestationalAgeDays";
	public static String PROP_GAIT = "Gait";
	public static String PROP_OTHERS_GENERAL_EXAMINATION = "OthersGeneralExamination";
	public static String PROP_UNKNOWN_LMP_STATUS = "UnknownLmpStatus";
	public static String PROP_ECLAMPSIA_YN = "EclampsiaYn";
	public static String PROP_DATE_USG_TWO = "DateUsgTwo";
	public static String PROP_USG_DETAIL = "UsgDetail";
	public static String PROP_PREGN_CONFRM = "PregnConfrm";
	public static String PROP_PREGNANCY_OUTCOME = "PregnancyOutcome";
	public static String PROP_DOPPLER_TWO = "DopplerTwo";
	public static String PROP_FOETAL_ABNORMALITY = "FoetalAbnormality";
	public static String PROP_BPD_ONE = "BpdOne";
	public static String PROP_EBW_THREE = "EbwThree";
	public static String PROP_MTP = "Mtp";
	public static String PROP_REFERRED_FROM_PRIVATE = "ReferredFromPrivate";
	public static String PROP_DOPPLER_USG_REPORT = "DopplerUsgReport";
	public static String PROP_UTERINE_SIZE = "UterineSize";
	public static String PROP_DATE_USG_THREE = "DateUsgThree";
	public static String PROP_AFI_USG_REPORT = "AfiUsgReport";
	public static String PROP_NUTRITION = "Nutrition";
	public static String PROP_HEART_DIS = "HeartDis";
	public static String PROP_THREE_HR = "ThreeHr";
	public static String PROP_MILD_NAME_MEDCN = "MildNameMedcn";
	public static String PROP_PPIUCD = "ppiucd";
	public static String PROP_MENARCHE = "Menarche";
	public static String PROP_HBSAG = "Hbsag";
	public static String PROP_NONE = "none";
	public static String PROP_WEIGHT_ANTENATAL = "WeightAntenatal";
	public static String PROP_OGTT = "Ogtt";
	public static String PROP_ANYPREV_ABDOMSUR_YN = "AnyprevAbdomsurYn";
	public static String PROP_BPP_TWO_USG = "BppTwoUsg";
	public static String PROP_OGTT_DATE = "OgttDate";
	public static String PROP_GRAVIDA = "Gravida";
	public static String PROP_NIPPLE = "Nipple";
	public static String PROP_FL_ONE = "FlOne";
	public static String PROP_LYMPHADENOPATHY = "Lymphadenopathy";
	public static String PROP_HC_ONE = "HcOne";
	public static String PROP_EDD = "Edd";
	public static String PROP_MEDICAL_DISORD = "MedicalDisord";
	public static String PROP_LIVE = "Live";
	public static String PROP_DELVR_OUTCM = "DelvrOutcm";
	public static String PROP_USG_GA_THREE = "UsgGaThree";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AGE_MONTH = "AgeMonth";
	public static String PROP_ECTOPIC = "Ectopic";
	public static String PROP_HEARTDIS_YN = "HeartdisYn";
	public static String PROP_SMOKING = "Smoking";
	public static String PROP_EXAMINATION_DATE = "ExaminationDate";
	public static String PROP_ANYPREV_ABDOMSURG = "AnyprevAbdomsurg";
	public static String PROP_MEDICAL = "Medical";
	public static String PROP_CERCLAGES_YN = "CerclagesYn";
	public static String PROP_USG_SECOND_REMARKS = "UsgSecondRemarks";
	public static String PROP_AC_TWO = "AcTwo";
	public static String PROP_FACTOR = "Factor";
	public static String PROP_OTHER = "Other";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_GCT = "Gct";
	public static String PROP_INFERTILITY_DETAILS = "InfertilityDetails";
	public static String PROP_HC_USG_REPORT = "HcUsgReport";
	public static String PROP_AC_USG_REPORT = "AcUsgReport";
	public static String PROP_LAM = "lam";
	public static String PROP_WAIST = "waist";
	public static String PROP_USG_GA_TWO = "UsgGaTwo";
	public static String PROP_ID = "Id";
	public static String PROP_GRAVIDA1 = "Gravida1";
	public static String PROP_EDC_DATE = "EdcDate";
	public static String PROP_GESTATIONAL_AGE_WEEKS = "GestationalAgeWeeks";
	public static String PROP_MILD_DEDUCT_TREAT = "MildDeductTreat";
	public static String PROP_OTHER_IMMUNIZATION_DETAIL = "OtherImmunizationDetail";
	public static String PROP_AC_ONE = "AcOne";
	public static String PROP_GYNECOLOGICAL = "Gynecological";
	public static String PROP_WILLING_FOR_TUBECTOMY = "WillingForTubectomy";
	public static String PROP_PRESENTATION_POSITION = "PresentationPosition";
	public static String PROP_MARITAL_STATUS = "maritalStatus";
	public static String PROP_NND = "Nnd";
	public static String PROP_PARLLOR = "Parllor";
	public static String PROP_BLOOD_GROUP_WIFE = "BloodGroupWife";
	public static String PROP_OTHERS_TT_DETAILS = "OthersTtDetails";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_LMP_GA_TWO = "LmpGaTwo";
	public static String PROP_BREAST = "Breast";
	public static String PROP_AFI_ONE = "AfiOne";
	public static String PROP_DIDSHE_RECEIV = "DidsheReceiv";
	public static String PROP_GENERAL_HEALTH = "GeneralHealth";
	public static String PROP_URINE = "Urine";
	public static String PROP_SCANNED_EDC = "ScannedEdc";
	public static String PROP_ANY_COMPLIANT = "AnyCompliant";
	public static String PROP_LUNGS = "Lungs";
	public static String PROP_HELP_YN = "HelpYn";


	// constructors
	public BaseOpdAntenatalCard () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdAntenatalCard (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer menarche;
	private java.lang.String cycle;
	private java.lang.String days;
	private java.util.Date lmp;
	private java.util.Date edd;
	private java.lang.Integer gravida;
	private java.lang.Integer para;
	private java.lang.Integer abortions;
	private java.lang.Integer live;
	private java.lang.Integer ectopic;
	private java.lang.String year;
	private java.lang.String pregnancyOutcome;
	private java.lang.String complications;
	private java.lang.Integer age;
	private java.lang.String sex;
	private java.lang.Integer birthWeight;
	private java.lang.String breastFeeding;
	private java.lang.String generalHealth;
	private java.lang.String medical;
	private java.lang.String surgical;
	private java.lang.String gynecological;
	private java.lang.String medicalHistory;
	private java.lang.String multiplePregnancy;
	private java.lang.String foetalAbnormality;
	private java.lang.String dietaryHabit;
	private java.lang.String smoking;
	private java.lang.String build;
	private java.lang.String nutrition;
	private java.lang.String height;
	private java.lang.String weight;
	private java.lang.String breast;
	private java.lang.String nipple;
	private java.lang.String heart;
	private java.lang.String lungs;
	private java.lang.String bloodGroupWife;
	private java.lang.String bloodGroupHusband;
	private java.lang.String sts;
	private java.lang.String hbsag;
	private java.lang.String hiv;
	private java.lang.String gct;
	private java.util.Date examinationDate;
	private java.lang.String ogtt;
	private java.util.Date ogttDate;
	private java.lang.String fasting;
	private java.lang.String oneHr;
	private java.lang.String twoHr;
	private java.lang.String threeHr;
	private java.lang.String highRiskFactors;
	private java.util.Date tetanusOnestDoseDate;
	private java.util.Date tetanusTwondDoseDate;
	private java.lang.String willingForTubectomy;
	private java.util.Date antenatalDate;
	private java.lang.String weightAntenatal;
	private java.lang.String anyCompliant;
	private java.lang.String parllor;
	private java.lang.String oedema;
	private java.lang.String bp;
	private java.lang.String uterineSize;
	private java.lang.String presentationPosition;
	private java.lang.String engagement;
	private java.lang.String fhsFm;
	private java.lang.String urine;
	private java.lang.String hbGms;
	private java.util.Date nextVisitOn;
	private java.lang.String advice;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String obsterComplcatn;
	private java.lang.String medicalDisord;
	private java.lang.Integer delvrOutcm;
	private java.lang.String usgDetail;
	private java.lang.String anemiaYn;
	private java.lang.String dmYn;
	private java.lang.String heartdisYn;
	private java.lang.String hypertenPreYn;
	private java.lang.String helpYn;
	private java.lang.String didsheReceiveYn;
	private java.lang.String eclampsiaYn;
	private java.lang.String anyprevAbdomsurYn;
	private java.lang.String cerclagesYn;
	private java.lang.String heartDis;
	private java.lang.String mildNameMedcn;
	private java.lang.String mildDeductTreat;
	private java.lang.String severNameMedcn;
	private java.lang.String severDeductTreat;
	private java.lang.String maritalStatus;
	private java.lang.String cycleFlow;
	private java.lang.String didsheReceiv;
	private java.lang.String eclampsia;
	private java.lang.String anyprevAbdomsurg;
	private java.lang.String cerclage;
	private java.lang.String ocpS;
	private java.lang.String tubalLigation;
	private java.lang.String condom;
	private java.lang.String lam;
	private java.lang.String ppiucd;
	private java.lang.String vasectomy;
	private java.lang.String intervalIucd;
	private java.lang.String none;
	private java.lang.String other;
	private java.lang.String pregnConfrm;
	private java.lang.String gravida1;
	private java.lang.Integer vesicular;
	private java.lang.Integer mtp;
	private java.lang.Integer iud;
	private java.lang.Integer stillBirth;
	private java.lang.Integer nnd;
	private java.util.Date scannedEdc;
	private java.util.Date edcDate;
	private java.lang.String ageYear;
	private java.lang.String ageMonth;
	private java.lang.String consanguineous;
	private java.lang.String degree;
	private java.lang.String infertility;
	private java.lang.String factor;
	private java.lang.String infertilityDetails;
	private java.lang.String familyHistory;
	private java.lang.String personalHistory;
	private java.lang.String bmi;
	private java.lang.String bmiStatus;
	private java.lang.String cycle1;
	private java.lang.String days1;
	private java.lang.String cycle2;
	private java.lang.String days2;
	private java.lang.String cycle3;
	private java.lang.String days3;
	private java.lang.String thyriod;
	private java.lang.String surgicalHistory;
	private java.lang.String durationOfMarriageYear;
	private java.lang.String durationOfMarriageMonth;
	private java.lang.String gestationalAgeWeeks;
	private java.lang.String gestationalAgeDays;
	private java.lang.String referredFromPrivate;
	private java.lang.String referredFromPrivateDetail;
	private java.lang.String surgicalHistoryRadio;
	private java.lang.String otherImmunizationDetail;
	private java.lang.String pallor;
	private java.lang.String icterus;
	private java.lang.String cyanosis;
	private java.lang.String lymphadenopathy;
	private java.lang.String edema;
	private java.lang.String spine;
	private java.lang.String gait;
	private java.lang.Integer waist;
	private java.lang.Integer hip;
	private java.lang.String marritalHistoryRemarks;
	private java.lang.String cvsGenExam;
	private java.lang.String othersGeneralExamination;
	private java.lang.String othersTtDetails;
	private java.lang.String lymphadenopathyValue;
	private java.lang.String obstetricComplications;
	private java.lang.String obstetricValues;
	private java.lang.String dateUsgReport;
	private java.util.Date dateUsgOne;
	private java.util.Date dateUsgTwo;
	private java.util.Date dateUsgThree;
	private java.lang.String lmpGaUsgReport;
	private java.lang.String lmpGaOne;
	private java.lang.String lmpGaTwo;
	private java.lang.String lmpGaThree;
	private java.lang.String usgGaUsgReport;
	private java.lang.String usgGaOne;
	private java.lang.String usgGaTwo;
	private java.lang.String usgGaThree;
	private java.lang.String afiUsgReport;
	private java.lang.String afiOne;
	private java.lang.String afiTwo;
	private java.lang.String afiThree;
	private java.lang.String bppUsgReport;
	private java.lang.String bppOne;
	private java.lang.String bppTwoUsg;
	private java.lang.String bppThree;
	private java.lang.String bpdUsgReport;
	private java.lang.String bpdOne;
	private java.lang.String bppTwo;
	private java.lang.String bpdThree;
	private java.lang.String flUsgReport;
	private java.lang.String flOne;
	private java.lang.String flTwo;
	private java.lang.String flThree;
	private java.lang.String acUsgReport;
	private java.lang.String acOne;
	private java.lang.String acTwo;
	private java.lang.String acThree;
	private java.lang.String hcUsgReport;
	private java.lang.String hcOne;
	private java.lang.String hcTwo;
	private java.lang.String hcThree;
	private java.lang.String ebwUsgReport;
	private java.lang.String ebwOne;
	private java.lang.String ebwTwo;
	private java.lang.String ebwThree;
	private java.lang.String dopplerUsgReport;
	private java.lang.String dopplerOne;
	private java.lang.String dopplerTwo;
	private java.lang.String dopplerThree;
	private java.lang.String usgRemarks;
	private java.lang.String usgSecondRemarks;
	private java.lang.String usgThirdRemarks;
	private java.lang.String clubbing;
	private java.lang.String refferedHospital;
	private java.lang.String refferedGA;
	private java.lang.String unknownLmpStatus;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_antenatal_card_id"
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
	 * Return the value associated with the column: menarche
	 */
	public java.lang.Integer getMenarche () {
		return menarche;
	}

	/**
	 * Set the value related to the column: menarche
	 * @param menarche the menarche value
	 */
	public void setMenarche (java.lang.Integer menarche) {
		this.menarche = menarche;
	}



	/**
	 * Return the value associated with the column: cycle
	 */
	public java.lang.String getCycle () {
		return cycle;
	}

	/**
	 * Set the value related to the column: cycle
	 * @param cycle the cycle value
	 */
	public void setCycle (java.lang.String cycle) {
		this.cycle = cycle;
	}



	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.String getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.String days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: lmp
	 */
	public java.util.Date getLmp () {
		return lmp;
	}

	/**
	 * Set the value related to the column: lmp
	 * @param lmp the lmp value
	 */
	public void setLmp (java.util.Date lmp) {
		this.lmp = lmp;
	}



	/**
	 * Return the value associated with the column: edd
	 */
	public java.util.Date getEdd () {
		return edd;
	}

	/**
	 * Set the value related to the column: edd
	 * @param edd the edd value
	 */
	public void setEdd (java.util.Date edd) {
		this.edd = edd;
	}



	/**
	 * Return the value associated with the column: gravida
	 */
	public java.lang.Integer getGravida () {
		return gravida;
	}

	/**
	 * Set the value related to the column: gravida
	 * @param gravida the gravida value
	 */
	public void setGravida (java.lang.Integer gravida) {
		this.gravida = gravida;
	}



	/**
	 * Return the value associated with the column: para
	 */
	public java.lang.Integer getPara () {
		return para;
	}

	/**
	 * Set the value related to the column: para
	 * @param para the para value
	 */
	public void setPara (java.lang.Integer para) {
		this.para = para;
	}



	/**
	 * Return the value associated with the column: abortions
	 */
	public java.lang.Integer getAbortions () {
		return abortions;
	}

	/**
	 * Set the value related to the column: abortions
	 * @param abortions the abortions value
	 */
	public void setAbortions (java.lang.Integer abortions) {
		this.abortions = abortions;
	}



	/**
	 * Return the value associated with the column: live
	 */
	public java.lang.Integer getLive () {
		return live;
	}

	/**
	 * Set the value related to the column: live
	 * @param live the live value
	 */
	public void setLive (java.lang.Integer live) {
		this.live = live;
	}



	/**
	 * Return the value associated with the column: ectopic
	 */
	public java.lang.Integer getEctopic () {
		return ectopic;
	}

	/**
	 * Set the value related to the column: ectopic
	 * @param ectopic the ectopic value
	 */
	public void setEctopic (java.lang.Integer ectopic) {
		this.ectopic = ectopic;
	}



	/**
	 * Return the value associated with the column: year
	 */
	public java.lang.String getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.String year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: pregnancy_outcome
	 */
	public java.lang.String getPregnancyOutcome () {
		return pregnancyOutcome;
	}

	/**
	 * Set the value related to the column: pregnancy_outcome
	 * @param pregnancyOutcome the pregnancy_outcome value
	 */
	public void setPregnancyOutcome (java.lang.String pregnancyOutcome) {
		this.pregnancyOutcome = pregnancyOutcome;
	}



	/**
	 * Return the value associated with the column: complications
	 */
	public java.lang.String getComplications () {
		return complications;
	}

	/**
	 * Set the value related to the column: complications
	 * @param complications the complications value
	 */
	public void setComplications (java.lang.String complications) {
		this.complications = complications;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.Integer getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.Integer age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * @param sex the sex value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: birth_weight
	 */
	public java.lang.Integer getBirthWeight () {
		return birthWeight;
	}

	/**
	 * Set the value related to the column: birth_weight
	 * @param birthWeight the birth_weight value
	 */
	public void setBirthWeight (java.lang.Integer birthWeight) {
		this.birthWeight = birthWeight;
	}



	/**
	 * Return the value associated with the column: breast_feeding
	 */
	public java.lang.String getBreastFeeding () {
		return breastFeeding;
	}

	/**
	 * Set the value related to the column: breast_feeding
	 * @param breastFeeding the breast_feeding value
	 */
	public void setBreastFeeding (java.lang.String breastFeeding) {
		this.breastFeeding = breastFeeding;
	}



	/**
	 * Return the value associated with the column: general_health
	 */
	public java.lang.String getGeneralHealth () {
		return generalHealth;
	}

	/**
	 * Set the value related to the column: general_health
	 * @param generalHealth the general_health value
	 */
	public void setGeneralHealth (java.lang.String generalHealth) {
		this.generalHealth = generalHealth;
	}



	/**
	 * Return the value associated with the column: medical
	 */
	public java.lang.String getMedical () {
		return medical;
	}

	/**
	 * Set the value related to the column: medical
	 * @param medical the medical value
	 */
	public void setMedical (java.lang.String medical) {
		this.medical = medical;
	}



	/**
	 * Return the value associated with the column: surgical
	 */
	public java.lang.String getSurgical () {
		return surgical;
	}

	/**
	 * Set the value related to the column: surgical
	 * @param surgical the surgical value
	 */
	public void setSurgical (java.lang.String surgical) {
		this.surgical = surgical;
	}



	/**
	 * Return the value associated with the column: gynecological
	 */
	public java.lang.String getGynecological () {
		return gynecological;
	}

	/**
	 * Set the value related to the column: gynecological
	 * @param gynecological the gynecological value
	 */
	public void setGynecological (java.lang.String gynecological) {
		this.gynecological = gynecological;
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
	 * Return the value associated with the column: multiple_pregnancy
	 */
	public java.lang.String getMultiplePregnancy () {
		return multiplePregnancy;
	}

	/**
	 * Set the value related to the column: multiple_pregnancy
	 * @param multiplePregnancy the multiple_pregnancy value
	 */
	public void setMultiplePregnancy (java.lang.String multiplePregnancy) {
		this.multiplePregnancy = multiplePregnancy;
	}



	/**
	 * Return the value associated with the column: foetal_abnormality
	 */
	public java.lang.String getFoetalAbnormality () {
		return foetalAbnormality;
	}

	/**
	 * Set the value related to the column: foetal_abnormality
	 * @param foetalAbnormality the foetal_abnormality value
	 */
	public void setFoetalAbnormality (java.lang.String foetalAbnormality) {
		this.foetalAbnormality = foetalAbnormality;
	}



	/**
	 * Return the value associated with the column: dietary_habit
	 */
	public java.lang.String getDietaryHabit () {
		return dietaryHabit;
	}

	/**
	 * Set the value related to the column: dietary_habit
	 * @param dietaryHabit the dietary_habit value
	 */
	public void setDietaryHabit (java.lang.String dietaryHabit) {
		this.dietaryHabit = dietaryHabit;
	}



	/**
	 * Return the value associated with the column: smoking
	 */
	public java.lang.String getSmoking () {
		return smoking;
	}

	/**
	 * Set the value related to the column: smoking
	 * @param smoking the smoking value
	 */
	public void setSmoking (java.lang.String smoking) {
		this.smoking = smoking;
	}



	/**
	 * Return the value associated with the column: build
	 */
	public java.lang.String getBuild () {
		return build;
	}

	/**
	 * Set the value related to the column: build
	 * @param build the build value
	 */
	public void setBuild (java.lang.String build) {
		this.build = build;
	}



	/**
	 * Return the value associated with the column: nutrition
	 */
	public java.lang.String getNutrition () {
		return nutrition;
	}

	/**
	 * Set the value related to the column: nutrition
	 * @param nutrition the nutrition value
	 */
	public void setNutrition (java.lang.String nutrition) {
		this.nutrition = nutrition;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.String height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.String getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.String weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: breast
	 */
	public java.lang.String getBreast () {
		return breast;
	}

	/**
	 * Set the value related to the column: breast
	 * @param breast the breast value
	 */
	public void setBreast (java.lang.String breast) {
		this.breast = breast;
	}



	/**
	 * Return the value associated with the column: nipple
	 */
	public java.lang.String getNipple () {
		return nipple;
	}

	/**
	 * Set the value related to the column: nipple
	 * @param nipple the nipple value
	 */
	public void setNipple (java.lang.String nipple) {
		this.nipple = nipple;
	}



	/**
	 * Return the value associated with the column: heart
	 */
	public java.lang.String getHeart () {
		return heart;
	}

	/**
	 * Set the value related to the column: heart
	 * @param heart the heart value
	 */
	public void setHeart (java.lang.String heart) {
		this.heart = heart;
	}



	/**
	 * Return the value associated with the column: lungs
	 */
	public java.lang.String getLungs () {
		return lungs;
	}

	/**
	 * Set the value related to the column: lungs
	 * @param lungs the lungs value
	 */
	public void setLungs (java.lang.String lungs) {
		this.lungs = lungs;
	}



	/**
	 * Return the value associated with the column: blood_group_wife
	 */
	public java.lang.String getBloodGroupWife () {
		return bloodGroupWife;
	}

	/**
	 * Set the value related to the column: blood_group_wife
	 * @param bloodGroupWife the blood_group_wife value
	 */
	public void setBloodGroupWife (java.lang.String bloodGroupWife) {
		this.bloodGroupWife = bloodGroupWife;
	}



	/**
	 * Return the value associated with the column: blood_group_husband
	 */
	public java.lang.String getBloodGroupHusband () {
		return bloodGroupHusband;
	}

	/**
	 * Set the value related to the column: blood_group_husband
	 * @param bloodGroupHusband the blood_group_husband value
	 */
	public void setBloodGroupHusband (java.lang.String bloodGroupHusband) {
		this.bloodGroupHusband = bloodGroupHusband;
	}



	/**
	 * Return the value associated with the column: sts
	 */
	public java.lang.String getSts () {
		return sts;
	}

	/**
	 * Set the value related to the column: sts
	 * @param sts the sts value
	 */
	public void setSts (java.lang.String sts) {
		this.sts = sts;
	}



	/**
	 * Return the value associated with the column: hbsag
	 */
	public java.lang.String getHbsag () {
		return hbsag;
	}

	/**
	 * Set the value related to the column: hbsag
	 * @param hbsag the hbsag value
	 */
	public void setHbsag (java.lang.String hbsag) {
		this.hbsag = hbsag;
	}



	/**
	 * Return the value associated with the column: hiv
	 */
	public java.lang.String getHiv () {
		return hiv;
	}

	/**
	 * Set the value related to the column: hiv
	 * @param hiv the hiv value
	 */
	public void setHiv (java.lang.String hiv) {
		this.hiv = hiv;
	}



	/**
	 * Return the value associated with the column: gct
	 */
	public java.lang.String getGct () {
		return gct;
	}

	/**
	 * Set the value related to the column: gct
	 * @param gct the gct value
	 */
	public void setGct (java.lang.String gct) {
		this.gct = gct;
	}



	/**
	 * Return the value associated with the column: examination_date
	 */
	public java.util.Date getExaminationDate () {
		return examinationDate;
	}

	/**
	 * Set the value related to the column: examination_date
	 * @param examinationDate the examination_date value
	 */
	public void setExaminationDate (java.util.Date examinationDate) {
		this.examinationDate = examinationDate;
	}



	/**
	 * Return the value associated with the column: ogtt
	 */
	public java.lang.String getOgtt () {
		return ogtt;
	}

	/**
	 * Set the value related to the column: ogtt
	 * @param ogtt the ogtt value
	 */
	public void setOgtt (java.lang.String ogtt) {
		this.ogtt = ogtt;
	}



	/**
	 * Return the value associated with the column: ogtt_date
	 */
	public java.util.Date getOgttDate () {
		return ogttDate;
	}

	/**
	 * Set the value related to the column: ogtt_date
	 * @param ogttDate the ogtt_date value
	 */
	public void setOgttDate (java.util.Date ogttDate) {
		this.ogttDate = ogttDate;
	}



	/**
	 * Return the value associated with the column: fasting
	 */
	public java.lang.String getFasting () {
		return fasting;
	}

	/**
	 * Set the value related to the column: fasting
	 * @param fasting the fasting value
	 */
	public void setFasting (java.lang.String fasting) {
		this.fasting = fasting;
	}



	/**
	 * Return the value associated with the column: one_hr
	 */
	public java.lang.String getOneHr () {
		return oneHr;
	}

	/**
	 * Set the value related to the column: one_hr
	 * @param oneHr the one_hr value
	 */
	public void setOneHr (java.lang.String oneHr) {
		this.oneHr = oneHr;
	}



	/**
	 * Return the value associated with the column: two_hr
	 */
	public java.lang.String getTwoHr () {
		return twoHr;
	}

	/**
	 * Set the value related to the column: two_hr
	 * @param twoHr the two_hr value
	 */
	public void setTwoHr (java.lang.String twoHr) {
		this.twoHr = twoHr;
	}



	/**
	 * Return the value associated with the column: three_hr
	 */
	public java.lang.String getThreeHr () {
		return threeHr;
	}

	/**
	 * Set the value related to the column: three_hr
	 * @param threeHr the three_hr value
	 */
	public void setThreeHr (java.lang.String threeHr) {
		this.threeHr = threeHr;
	}



	/**
	 * Return the value associated with the column: high_risk_factors
	 */
	public java.lang.String getHighRiskFactors () {
		return highRiskFactors;
	}

	/**
	 * Set the value related to the column: high_risk_factors
	 * @param highRiskFactors the high_risk_factors value
	 */
	public void setHighRiskFactors (java.lang.String highRiskFactors) {
		this.highRiskFactors = highRiskFactors;
	}



	/**
	 * Return the value associated with the column: tetanus_onest_dose_date
	 */
	public java.util.Date getTetanusOnestDoseDate () {
		return tetanusOnestDoseDate;
	}

	/**
	 * Set the value related to the column: tetanus_onest_dose_date
	 * @param tetanusOnestDoseDate the tetanus_onest_dose_date value
	 */
	public void setTetanusOnestDoseDate (java.util.Date tetanusOnestDoseDate) {
		this.tetanusOnestDoseDate = tetanusOnestDoseDate;
	}



	/**
	 * Return the value associated with the column: tetanus_twond_dose_date
	 */
	public java.util.Date getTetanusTwondDoseDate () {
		return tetanusTwondDoseDate;
	}

	/**
	 * Set the value related to the column: tetanus_twond_dose_date
	 * @param tetanusTwondDoseDate the tetanus_twond_dose_date value
	 */
	public void setTetanusTwondDoseDate (java.util.Date tetanusTwondDoseDate) {
		this.tetanusTwondDoseDate = tetanusTwondDoseDate;
	}



	/**
	 * Return the value associated with the column: willing_for_tubectomy
	 */
	public java.lang.String getWillingForTubectomy () {
		return willingForTubectomy;
	}

	/**
	 * Set the value related to the column: willing_for_tubectomy
	 * @param willingForTubectomy the willing_for_tubectomy value
	 */
	public void setWillingForTubectomy (java.lang.String willingForTubectomy) {
		this.willingForTubectomy = willingForTubectomy;
	}



	/**
	 * Return the value associated with the column: antenatal_date
	 */
	public java.util.Date getAntenatalDate () {
		return antenatalDate;
	}

	/**
	 * Set the value related to the column: antenatal_date
	 * @param antenatalDate the antenatal_date value
	 */
	public void setAntenatalDate (java.util.Date antenatalDate) {
		this.antenatalDate = antenatalDate;
	}



	/**
	 * Return the value associated with the column: weight_antenatal
	 */
	public java.lang.String getWeightAntenatal () {
		return weightAntenatal;
	}

	/**
	 * Set the value related to the column: weight_antenatal
	 * @param weightAntenatal the weight_antenatal value
	 */
	public void setWeightAntenatal (java.lang.String weightAntenatal) {
		this.weightAntenatal = weightAntenatal;
	}



	/**
	 * Return the value associated with the column: any_compliant
	 */
	public java.lang.String getAnyCompliant () {
		return anyCompliant;
	}

	/**
	 * Set the value related to the column: any_compliant
	 * @param anyCompliant the any_compliant value
	 */
	public void setAnyCompliant (java.lang.String anyCompliant) {
		this.anyCompliant = anyCompliant;
	}



	/**
	 * Return the value associated with the column: parllor
	 */
	public java.lang.String getParllor () {
		return parllor;
	}

	/**
	 * Set the value related to the column: parllor
	 * @param parllor the parllor value
	 */
	public void setParllor (java.lang.String parllor) {
		this.parllor = parllor;
	}



	/**
	 * Return the value associated with the column: oedema
	 */
	public java.lang.String getOedema () {
		return oedema;
	}

	/**
	 * Set the value related to the column: oedema
	 * @param oedema the oedema value
	 */
	public void setOedema (java.lang.String oedema) {
		this.oedema = oedema;
	}



	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.String getBp () {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * @param bp the bp value
	 */
	public void setBp (java.lang.String bp) {
		this.bp = bp;
	}



	/**
	 * Return the value associated with the column: uterine_size
	 */
	public java.lang.String getUterineSize () {
		return uterineSize;
	}

	/**
	 * Set the value related to the column: uterine_size
	 * @param uterineSize the uterine_size value
	 */
	public void setUterineSize (java.lang.String uterineSize) {
		this.uterineSize = uterineSize;
	}



	/**
	 * Return the value associated with the column: presentation_position
	 */
	public java.lang.String getPresentationPosition () {
		return presentationPosition;
	}

	/**
	 * Set the value related to the column: presentation_position
	 * @param presentationPosition the presentation_position value
	 */
	public void setPresentationPosition (java.lang.String presentationPosition) {
		this.presentationPosition = presentationPosition;
	}



	/**
	 * Return the value associated with the column: engagement
	 */
	public java.lang.String getEngagement () {
		return engagement;
	}

	/**
	 * Set the value related to the column: engagement
	 * @param engagement the engagement value
	 */
	public void setEngagement (java.lang.String engagement) {
		this.engagement = engagement;
	}



	/**
	 * Return the value associated with the column: fhs_fm
	 */
	public java.lang.String getFhsFm () {
		return fhsFm;
	}

	/**
	 * Set the value related to the column: fhs_fm
	 * @param fhsFm the fhs_fm value
	 */
	public void setFhsFm (java.lang.String fhsFm) {
		this.fhsFm = fhsFm;
	}



	/**
	 * Return the value associated with the column: urine
	 */
	public java.lang.String getUrine () {
		return urine;
	}

	/**
	 * Set the value related to the column: urine
	 * @param urine the urine value
	 */
	public void setUrine (java.lang.String urine) {
		this.urine = urine;
	}



	/**
	 * Return the value associated with the column: hb_gms
	 */
	public java.lang.String getHbGms () {
		return hbGms;
	}

	/**
	 * Set the value related to the column: hb_gms
	 * @param hbGms the hb_gms value
	 */
	public void setHbGms (java.lang.String hbGms) {
		this.hbGms = hbGms;
	}



	/**
	 * Return the value associated with the column: next_visit_on
	 */
	public java.util.Date getNextVisitOn () {
		return nextVisitOn;
	}

	/**
	 * Set the value related to the column: next_visit_on
	 * @param nextVisitOn the next_visit_on value
	 */
	public void setNextVisitOn (java.util.Date nextVisitOn) {
		this.nextVisitOn = nextVisitOn;
	}



	/**
	 * Return the value associated with the column: advice
	 */
	public java.lang.String getAdvice () {
		return advice;
	}

	/**
	 * Set the value related to the column: advice
	 * @param advice the advice value
	 */
	public void setAdvice (java.lang.String advice) {
		this.advice = advice;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
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
	 * Return the value associated with the column: obster_complcatn
	 */
	public java.lang.String getObsterComplcatn () {
		return obsterComplcatn;
	}

	/**
	 * Set the value related to the column: obster_complcatn
	 * @param obsterComplcatn the obster_complcatn value
	 */
	public void setObsterComplcatn (java.lang.String obsterComplcatn) {
		this.obsterComplcatn = obsterComplcatn;
	}



	/**
	 * Return the value associated with the column: medical_disord
	 */
	public java.lang.String getMedicalDisord () {
		return medicalDisord;
	}

	/**
	 * Set the value related to the column: medical_disord
	 * @param medicalDisord the medical_disord value
	 */
	public void setMedicalDisord (java.lang.String medicalDisord) {
		this.medicalDisord = medicalDisord;
	}



	/**
	 * Return the value associated with the column: delvr_outcm
	 */
	public java.lang.Integer getDelvrOutcm () {
		return delvrOutcm;
	}

	/**
	 * Set the value related to the column: delvr_outcm
	 * @param delvrOutcm the delvr_outcm value
	 */
	public void setDelvrOutcm (java.lang.Integer delvrOutcm) {
		this.delvrOutcm = delvrOutcm;
	}



	/**
	 * Return the value associated with the column: usg_detail
	 */
	public java.lang.String getUsgDetail () {
		return usgDetail;
	}

	/**
	 * Set the value related to the column: usg_detail
	 * @param usgDetail the usg_detail value
	 */
	public void setUsgDetail (java.lang.String usgDetail) {
		this.usgDetail = usgDetail;
	}



	/**
	 * Return the value associated with the column: anemia_yn
	 */
	public java.lang.String getAnemiaYn () {
		return anemiaYn;
	}

	/**
	 * Set the value related to the column: anemia_yn
	 * @param anemiaYn the anemia_yn value
	 */
	public void setAnemiaYn (java.lang.String anemiaYn) {
		this.anemiaYn = anemiaYn;
	}



	/**
	 * Return the value associated with the column: dm_yn
	 */
	public java.lang.String getDmYn () {
		return dmYn;
	}

	/**
	 * Set the value related to the column: dm_yn
	 * @param dmYn the dm_yn value
	 */
	public void setDmYn (java.lang.String dmYn) {
		this.dmYn = dmYn;
	}



	/**
	 * Return the value associated with the column: heartdis_yn
	 */
	public java.lang.String getHeartdisYn () {
		return heartdisYn;
	}

	/**
	 * Set the value related to the column: heartdis_yn
	 * @param heartdisYn the heartdis_yn value
	 */
	public void setHeartdisYn (java.lang.String heartdisYn) {
		this.heartdisYn = heartdisYn;
	}



	/**
	 * Return the value associated with the column: hyperten_pre_yn
	 */
	public java.lang.String getHypertenPreYn () {
		return hypertenPreYn;
	}

	/**
	 * Set the value related to the column: hyperten_pre_yn
	 * @param hypertenPreYn the hyperten_pre_yn value
	 */
	public void setHypertenPreYn (java.lang.String hypertenPreYn) {
		this.hypertenPreYn = hypertenPreYn;
	}



	/**
	 * Return the value associated with the column: help_yn
	 */
	public java.lang.String getHelpYn () {
		return helpYn;
	}

	/**
	 * Set the value related to the column: help_yn
	 * @param helpYn the help_yn value
	 */
	public void setHelpYn (java.lang.String helpYn) {
		this.helpYn = helpYn;
	}



	/**
	 * Return the value associated with the column: didshe_receive_yn
	 */
	public java.lang.String getDidsheReceiveYn () {
		return didsheReceiveYn;
	}

	/**
	 * Set the value related to the column: didshe_receive_yn
	 * @param didsheReceiveYn the didshe_receive_yn value
	 */
	public void setDidsheReceiveYn (java.lang.String didsheReceiveYn) {
		this.didsheReceiveYn = didsheReceiveYn;
	}



	/**
	 * Return the value associated with the column: eclampsia_yn
	 */
	public java.lang.String getEclampsiaYn () {
		return eclampsiaYn;
	}

	/**
	 * Set the value related to the column: eclampsia_yn
	 * @param eclampsiaYn the eclampsia_yn value
	 */
	public void setEclampsiaYn (java.lang.String eclampsiaYn) {
		this.eclampsiaYn = eclampsiaYn;
	}



	/**
	 * Return the value associated with the column: anyprev_abdomsur_yn
	 */
	public java.lang.String getAnyprevAbdomsurYn () {
		return anyprevAbdomsurYn;
	}

	/**
	 * Set the value related to the column: anyprev_abdomsur_yn
	 * @param anyprevAbdomsurYn the anyprev_abdomsur_yn value
	 */
	public void setAnyprevAbdomsurYn (java.lang.String anyprevAbdomsurYn) {
		this.anyprevAbdomsurYn = anyprevAbdomsurYn;
	}



	/**
	 * Return the value associated with the column: cerclages_yn
	 */
	public java.lang.String getCerclagesYn () {
		return cerclagesYn;
	}

	/**
	 * Set the value related to the column: cerclages_yn
	 * @param cerclagesYn the cerclages_yn value
	 */
	public void setCerclagesYn (java.lang.String cerclagesYn) {
		this.cerclagesYn = cerclagesYn;
	}



	/**
	 * Return the value associated with the column: heart_dis
	 */
	public java.lang.String getHeartDis () {
		return heartDis;
	}

	/**
	 * Set the value related to the column: heart_dis
	 * @param heartDis the heart_dis value
	 */
	public void setHeartDis (java.lang.String heartDis) {
		this.heartDis = heartDis;
	}



	/**
	 * Return the value associated with the column: mild_name_medcn
	 */
	public java.lang.String getMildNameMedcn () {
		return mildNameMedcn;
	}

	/**
	 * Set the value related to the column: mild_name_medcn
	 * @param mildNameMedcn the mild_name_medcn value
	 */
	public void setMildNameMedcn (java.lang.String mildNameMedcn) {
		this.mildNameMedcn = mildNameMedcn;
	}



	/**
	 * Return the value associated with the column: mild_deduct_treat
	 */
	public java.lang.String getMildDeductTreat () {
		return mildDeductTreat;
	}

	/**
	 * Set the value related to the column: mild_deduct_treat
	 * @param mildDeductTreat the mild_deduct_treat value
	 */
	public void setMildDeductTreat (java.lang.String mildDeductTreat) {
		this.mildDeductTreat = mildDeductTreat;
	}



	/**
	 * Return the value associated with the column: sever_name_medcn
	 */
	public java.lang.String getSeverNameMedcn () {
		return severNameMedcn;
	}

	/**
	 * Set the value related to the column: sever_name_medcn
	 * @param severNameMedcn the sever_name_medcn value
	 */
	public void setSeverNameMedcn (java.lang.String severNameMedcn) {
		this.severNameMedcn = severNameMedcn;
	}



	/**
	 * Return the value associated with the column: sever_deduct_treat
	 */
	public java.lang.String getSeverDeductTreat () {
		return severDeductTreat;
	}

	/**
	 * Set the value related to the column: sever_deduct_treat
	 * @param severDeductTreat the sever_deduct_treat value
	 */
	public void setSeverDeductTreat (java.lang.String severDeductTreat) {
		this.severDeductTreat = severDeductTreat;
	}



	/**
	 * Return the value associated with the column: marital_status
	 */
	public java.lang.String getMaritalStatus () {
		return maritalStatus;
	}

	/**
	 * Set the value related to the column: marital_status
	 * @param maritalStatus the marital_status value
	 */
	public void setMaritalStatus (java.lang.String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	/**
	 * Return the value associated with the column: cycle_flow
	 */
	public java.lang.String getCycleFlow () {
		return cycleFlow;
	}

	/**
	 * Set the value related to the column: cycle_flow
	 * @param cycleFlow the cycle_flow value
	 */
	public void setCycleFlow (java.lang.String cycleFlow) {
		this.cycleFlow = cycleFlow;
	}



	/**
	 * Return the value associated with the column: didshe_receiv
	 */
	public java.lang.String getDidsheReceiv () {
		return didsheReceiv;
	}

	/**
	 * Set the value related to the column: didshe_receiv
	 * @param didsheReceiv the didshe_receiv value
	 */
	public void setDidsheReceiv (java.lang.String didsheReceiv) {
		this.didsheReceiv = didsheReceiv;
	}



	/**
	 * Return the value associated with the column: eclampsia
	 */
	public java.lang.String getEclampsia () {
		return eclampsia;
	}

	/**
	 * Set the value related to the column: eclampsia
	 * @param eclampsia the eclampsia value
	 */
	public void setEclampsia (java.lang.String eclampsia) {
		this.eclampsia = eclampsia;
	}



	/**
	 * Return the value associated with the column: anyprev_abdomsurg
	 */
	public java.lang.String getAnyprevAbdomsurg () {
		return anyprevAbdomsurg;
	}

	/**
	 * Set the value related to the column: anyprev_abdomsurg
	 * @param anyprevAbdomsurg the anyprev_abdomsurg value
	 */
	public void setAnyprevAbdomsurg (java.lang.String anyprevAbdomsurg) {
		this.anyprevAbdomsurg = anyprevAbdomsurg;
	}



	/**
	 * Return the value associated with the column: cerclage
	 */
	public java.lang.String getCerclage () {
		return cerclage;
	}

	/**
	 * Set the value related to the column: cerclage
	 * @param cerclage the cerclage value
	 */
	public void setCerclage (java.lang.String cerclage) {
		this.cerclage = cerclage;
	}



	/**
	 * Return the value associated with the column: ocps
	 */
	public java.lang.String getOcpS () {
		return ocpS;
	}

	/**
	 * Set the value related to the column: ocps
	 * @param ocpS the ocps value
	 */
	public void setOcpS (java.lang.String ocpS) {
		this.ocpS = ocpS;
	}



	/**
	 * Return the value associated with the column: tubal_ligation
	 */
	public java.lang.String getTubalLigation () {
		return tubalLigation;
	}

	/**
	 * Set the value related to the column: tubal_ligation
	 * @param tubalLigation the tubal_ligation value
	 */
	public void setTubalLigation (java.lang.String tubalLigation) {
		this.tubalLigation = tubalLigation;
	}



	/**
	 * Return the value associated with the column: condom
	 */
	public java.lang.String getCondom () {
		return condom;
	}

	/**
	 * Set the value related to the column: condom
	 * @param condom the condom value
	 */
	public void setCondom (java.lang.String condom) {
		this.condom = condom;
	}



	/**
	 * Return the value associated with the column: lam
	 */
	public java.lang.String getLam () {
		return lam;
	}

	/**
	 * Set the value related to the column: lam
	 * @param lam the lam value
	 */
	public void setLam (java.lang.String lam) {
		this.lam = lam;
	}



	/**
	 * Return the value associated with the column: ppiucd
	 */
	public java.lang.String getPpiucd () {
		return ppiucd;
	}

	/**
	 * Set the value related to the column: ppiucd
	 * @param ppiucd the ppiucd value
	 */
	public void setPpiucd (java.lang.String ppiucd) {
		this.ppiucd = ppiucd;
	}



	/**
	 * Return the value associated with the column: vasectomy
	 */
	public java.lang.String getVasectomy () {
		return vasectomy;
	}

	/**
	 * Set the value related to the column: vasectomy
	 * @param vasectomy the vasectomy value
	 */
	public void setVasectomy (java.lang.String vasectomy) {
		this.vasectomy = vasectomy;
	}



	/**
	 * Return the value associated with the column: interval_iucd
	 */
	public java.lang.String getIntervalIucd () {
		return intervalIucd;
	}

	/**
	 * Set the value related to the column: interval_iucd
	 * @param intervalIucd the interval_iucd value
	 */
	public void setIntervalIucd (java.lang.String intervalIucd) {
		this.intervalIucd = intervalIucd;
	}



	/**
	 * Return the value associated with the column: none
	 */
	public java.lang.String getNone () {
		return none;
	}

	/**
	 * Set the value related to the column: none
	 * @param none the none value
	 */
	public void setNone (java.lang.String none) {
		this.none = none;
	}



	/**
	 * Return the value associated with the column: other
	 */
	public java.lang.String getOther () {
		return other;
	}

	/**
	 * Set the value related to the column: other
	 * @param other the other value
	 */
	public void setOther (java.lang.String other) {
		this.other = other;
	}



	/**
	 * Return the value associated with the column: pregn_confrm
	 */
	public java.lang.String getPregnConfrm () {
		return pregnConfrm;
	}

	/**
	 * Set the value related to the column: pregn_confrm
	 * @param pregnConfrm the pregn_confrm value
	 */
	public void setPregnConfrm (java.lang.String pregnConfrm) {
		this.pregnConfrm = pregnConfrm;
	}



	/**
	 * Return the value associated with the column: gravida1
	 */
	public java.lang.String getGravida1 () {
		return gravida1;
	}

	/**
	 * Set the value related to the column: gravida1
	 * @param gravida1 the gravida1 value
	 */
	public void setGravida1 (java.lang.String gravida1) {
		this.gravida1 = gravida1;
	}



	/**
	 * Return the value associated with the column: vesicular
	 */
	public java.lang.Integer getVesicular () {
		return vesicular;
	}

	/**
	 * Set the value related to the column: vesicular
	 * @param vesicular the vesicular value
	 */
	public void setVesicular (java.lang.Integer vesicular) {
		this.vesicular = vesicular;
	}



	/**
	 * Return the value associated with the column: mtp
	 */
	public java.lang.Integer getMtp () {
		return mtp;
	}

	/**
	 * Set the value related to the column: mtp
	 * @param mtp the mtp value
	 */
	public void setMtp (java.lang.Integer mtp) {
		this.mtp = mtp;
	}



	/**
	 * Return the value associated with the column: iud
	 */
	public java.lang.Integer getIud () {
		return iud;
	}

	/**
	 * Set the value related to the column: iud
	 * @param iud the iud value
	 */
	public void setIud (java.lang.Integer iud) {
		this.iud = iud;
	}



	/**
	 * Return the value associated with the column: still_birth
	 */
	public java.lang.Integer getStillBirth () {
		return stillBirth;
	}

	/**
	 * Set the value related to the column: still_birth
	 * @param stillBirth the still_birth value
	 */
	public void setStillBirth (java.lang.Integer stillBirth) {
		this.stillBirth = stillBirth;
	}



	/**
	 * Return the value associated with the column: nnd
	 */
	public java.lang.Integer getNnd () {
		return nnd;
	}

	/**
	 * Set the value related to the column: nnd
	 * @param nnd the nnd value
	 */
	public void setNnd (java.lang.Integer nnd) {
		this.nnd = nnd;
	}



	/**
	 * Return the value associated with the column: scanned_edc
	 */
	public java.util.Date getScannedEdc () {
		return scannedEdc;
	}

	/**
	 * Set the value related to the column: scanned_edc
	 * @param scannedEdc the scanned_edc value
	 */
	public void setScannedEdc (java.util.Date scannedEdc) {
		this.scannedEdc = scannedEdc;
	}



	/**
	 * Return the value associated with the column: edc_Date
	 */
	public java.util.Date getEdcDate () {
		return edcDate;
	}

	/**
	 * Set the value related to the column: edc_Date
	 * @param edcDate the edc_Date value
	 */
	public void setEdcDate (java.util.Date edcDate) {
		this.edcDate = edcDate;
	}



	/**
	 * Return the value associated with the column: age_year
	 */
	public java.lang.String getAgeYear () {
		return ageYear;
	}

	/**
	 * Set the value related to the column: age_year
	 * @param ageYear the age_year value
	 */
	public void setAgeYear (java.lang.String ageYear) {
		this.ageYear = ageYear;
	}



	/**
	 * Return the value associated with the column: age_month
	 */
	public java.lang.String getAgeMonth () {
		return ageMonth;
	}

	/**
	 * Set the value related to the column: age_month
	 * @param ageMonth the age_month value
	 */
	public void setAgeMonth (java.lang.String ageMonth) {
		this.ageMonth = ageMonth;
	}



	/**
	 * Return the value associated with the column: consanguineous
	 */
	public java.lang.String getConsanguineous () {
		return consanguineous;
	}

	/**
	 * Set the value related to the column: consanguineous
	 * @param consanguineous the consanguineous value
	 */
	public void setConsanguineous (java.lang.String consanguineous) {
		this.consanguineous = consanguineous;
	}



	/**
	 * Return the value associated with the column: degree
	 */
	public java.lang.String getDegree () {
		return degree;
	}

	/**
	 * Set the value related to the column: degree
	 * @param degree the degree value
	 */
	public void setDegree (java.lang.String degree) {
		this.degree = degree;
	}



	/**
	 * Return the value associated with the column: infertility
	 */
	public java.lang.String getInfertility () {
		return infertility;
	}

	/**
	 * Set the value related to the column: infertility
	 * @param infertility the infertility value
	 */
	public void setInfertility (java.lang.String infertility) {
		this.infertility = infertility;
	}



	/**
	 * Return the value associated with the column: factor
	 */
	public java.lang.String getFactor () {
		return factor;
	}

	/**
	 * Set the value related to the column: factor
	 * @param factor the factor value
	 */
	public void setFactor (java.lang.String factor) {
		this.factor = factor;
	}



	/**
	 * Return the value associated with the column: infertility_details
	 */
	public java.lang.String getInfertilityDetails () {
		return infertilityDetails;
	}

	/**
	 * Set the value related to the column: infertility_details
	 * @param infertilityDetails the infertility_details value
	 */
	public void setInfertilityDetails (java.lang.String infertilityDetails) {
		this.infertilityDetails = infertilityDetails;
	}



	/**
	 * Return the value associated with the column: family_history
	 */
	public java.lang.String getFamilyHistory () {
		return familyHistory;
	}

	/**
	 * Set the value related to the column: family_history
	 * @param familyHistory the family_history value
	 */
	public void setFamilyHistory (java.lang.String familyHistory) {
		this.familyHistory = familyHistory;
	}



	/**
	 * Return the value associated with the column: personal_history
	 */
	public java.lang.String getPersonalHistory () {
		return personalHistory;
	}

	/**
	 * Set the value related to the column: personal_history
	 * @param personalHistory the personal_history value
	 */
	public void setPersonalHistory (java.lang.String personalHistory) {
		this.personalHistory = personalHistory;
	}



	/**
	 * Return the value associated with the column: bmi
	 */
	public java.lang.String getBmi () {
		return bmi;
	}

	/**
	 * Set the value related to the column: bmi
	 * @param bmi the bmi value
	 */
	public void setBmi (java.lang.String bmi) {
		this.bmi = bmi;
	}



	/**
	 * Return the value associated with the column: bmi_status
	 */
	public java.lang.String getBmiStatus () {
		return bmiStatus;
	}

	/**
	 * Set the value related to the column: bmi_status
	 * @param bmiStatus the bmi_status value
	 */
	public void setBmiStatus (java.lang.String bmiStatus) {
		this.bmiStatus = bmiStatus;
	}



	/**
	 * Return the value associated with the column: cycle1
	 */
	public java.lang.String getCycle1 () {
		return cycle1;
	}

	/**
	 * Set the value related to the column: cycle1
	 * @param cycle1 the cycle1 value
	 */
	public void setCycle1 (java.lang.String cycle1) {
		this.cycle1 = cycle1;
	}



	/**
	 * Return the value associated with the column: days1
	 */
	public java.lang.String getDays1 () {
		return days1;
	}

	/**
	 * Set the value related to the column: days1
	 * @param days1 the days1 value
	 */
	public void setDays1 (java.lang.String days1) {
		this.days1 = days1;
	}



	/**
	 * Return the value associated with the column: cycle2
	 */
	public java.lang.String getCycle2 () {
		return cycle2;
	}

	/**
	 * Set the value related to the column: cycle2
	 * @param cycle2 the cycle2 value
	 */
	public void setCycle2 (java.lang.String cycle2) {
		this.cycle2 = cycle2;
	}



	/**
	 * Return the value associated with the column: days2
	 */
	public java.lang.String getDays2 () {
		return days2;
	}

	/**
	 * Set the value related to the column: days2
	 * @param days2 the days2 value
	 */
	public void setDays2 (java.lang.String days2) {
		this.days2 = days2;
	}



	/**
	 * Return the value associated with the column: cycle3
	 */
	public java.lang.String getCycle3 () {
		return cycle3;
	}

	/**
	 * Set the value related to the column: cycle3
	 * @param cycle3 the cycle3 value
	 */
	public void setCycle3 (java.lang.String cycle3) {
		this.cycle3 = cycle3;
	}



	/**
	 * Return the value associated with the column: days3
	 */
	public java.lang.String getDays3 () {
		return days3;
	}

	/**
	 * Set the value related to the column: days3
	 * @param days3 the days3 value
	 */
	public void setDays3 (java.lang.String days3) {
		this.days3 = days3;
	}



	/**
	 * Return the value associated with the column: thyriod
	 */
	public java.lang.String getThyriod () {
		return thyriod;
	}

	/**
	 * Set the value related to the column: thyriod
	 * @param thyriod the thyriod value
	 */
	public void setThyriod (java.lang.String thyriod) {
		this.thyriod = thyriod;
	}



	/**
	 * Return the value associated with the column: surgical_history
	 */
	public java.lang.String getSurgicalHistory () {
		return surgicalHistory;
	}

	/**
	 * Set the value related to the column: surgical_history
	 * @param surgicalHistory the surgical_history value
	 */
	public void setSurgicalHistory (java.lang.String surgicalHistory) {
		this.surgicalHistory = surgicalHistory;
	}



	/**
	 * Return the value associated with the column: duration_of_marriage_year
	 */
	public java.lang.String getDurationOfMarriageYear () {
		return durationOfMarriageYear;
	}

	/**
	 * Set the value related to the column: duration_of_marriage_year
	 * @param durationOfMarriageYear the duration_of_marriage_year value
	 */
	public void setDurationOfMarriageYear (java.lang.String durationOfMarriageYear) {
		this.durationOfMarriageYear = durationOfMarriageYear;
	}



	/**
	 * Return the value associated with the column: duration_of_marriage_month
	 */
	public java.lang.String getDurationOfMarriageMonth () {
		return durationOfMarriageMonth;
	}

	/**
	 * Set the value related to the column: duration_of_marriage_month
	 * @param durationOfMarriageMonth the duration_of_marriage_month value
	 */
	public void setDurationOfMarriageMonth (java.lang.String durationOfMarriageMonth) {
		this.durationOfMarriageMonth = durationOfMarriageMonth;
	}



	/**
	 * Return the value associated with the column: gestational_age_weeks
	 */
	public java.lang.String getGestationalAgeWeeks () {
		return gestationalAgeWeeks;
	}

	/**
	 * Set the value related to the column: gestational_age_weeks
	 * @param gestationalAgeWeeks the gestational_age_weeks value
	 */
	public void setGestationalAgeWeeks (java.lang.String gestationalAgeWeeks) {
		this.gestationalAgeWeeks = gestationalAgeWeeks;
	}



	/**
	 * Return the value associated with the column: gestational_age_days
	 */
	public java.lang.String getGestationalAgeDays () {
		return gestationalAgeDays;
	}

	/**
	 * Set the value related to the column: gestational_age_days
	 * @param gestationalAgeDays the gestational_age_days value
	 */
	public void setGestationalAgeDays (java.lang.String gestationalAgeDays) {
		this.gestationalAgeDays = gestationalAgeDays;
	}



	/**
	 * Return the value associated with the column: referred_from_private
	 */
	public java.lang.String getReferredFromPrivate () {
		return referredFromPrivate;
	}

	/**
	 * Set the value related to the column: referred_from_private
	 * @param referredFromPrivate the referred_from_private value
	 */
	public void setReferredFromPrivate (java.lang.String referredFromPrivate) {
		this.referredFromPrivate = referredFromPrivate;
	}



	/**
	 * Return the value associated with the column: referred_from_private_detail
	 */
	public java.lang.String getReferredFromPrivateDetail () {
		return referredFromPrivateDetail;
	}

	/**
	 * Set the value related to the column: referred_from_private_detail
	 * @param referredFromPrivateDetail the referred_from_private_detail value
	 */
	public void setReferredFromPrivateDetail (java.lang.String referredFromPrivateDetail) {
		this.referredFromPrivateDetail = referredFromPrivateDetail;
	}



	/**
	 * Return the value associated with the column: surgical_history_radio
	 */
	public java.lang.String getSurgicalHistoryRadio () {
		return surgicalHistoryRadio;
	}

	/**
	 * Set the value related to the column: surgical_history_radio
	 * @param surgicalHistoryRadio the surgical_history_radio value
	 */
	public void setSurgicalHistoryRadio (java.lang.String surgicalHistoryRadio) {
		this.surgicalHistoryRadio = surgicalHistoryRadio;
	}



	/**
	 * Return the value associated with the column: other_immunization_detail
	 */
	public java.lang.String getOtherImmunizationDetail () {
		return otherImmunizationDetail;
	}

	/**
	 * Set the value related to the column: other_immunization_detail
	 * @param otherImmunizationDetail the other_immunization_detail value
	 */
	public void setOtherImmunizationDetail (java.lang.String otherImmunizationDetail) {
		this.otherImmunizationDetail = otherImmunizationDetail;
	}



	/**
	 * Return the value associated with the column: pallor
	 */
	public java.lang.String getPallor () {
		return pallor;
	}

	/**
	 * Set the value related to the column: pallor
	 * @param pallor the pallor value
	 */
	public void setPallor (java.lang.String pallor) {
		this.pallor = pallor;
	}



	/**
	 * Return the value associated with the column: icterus
	 */
	public java.lang.String getIcterus () {
		return icterus;
	}

	/**
	 * Set the value related to the column: icterus
	 * @param icterus the icterus value
	 */
	public void setIcterus (java.lang.String icterus) {
		this.icterus = icterus;
	}



	/**
	 * Return the value associated with the column: cyanosis
	 */
	public java.lang.String getCyanosis () {
		return cyanosis;
	}

	/**
	 * Set the value related to the column: cyanosis
	 * @param cyanosis the cyanosis value
	 */
	public void setCyanosis (java.lang.String cyanosis) {
		this.cyanosis = cyanosis;
	}



	/**
	 * Return the value associated with the column: lymphadenopathy
	 */
	public java.lang.String getLymphadenopathy () {
		return lymphadenopathy;
	}

	/**
	 * Set the value related to the column: lymphadenopathy
	 * @param lymphadenopathy the lymphadenopathy value
	 */
	public void setLymphadenopathy (java.lang.String lymphadenopathy) {
		this.lymphadenopathy = lymphadenopathy;
	}



	/**
	 * Return the value associated with the column: edema
	 */
	public java.lang.String getEdema () {
		return edema;
	}

	/**
	 * Set the value related to the column: edema
	 * @param edema the edema value
	 */
	public void setEdema (java.lang.String edema) {
		this.edema = edema;
	}



	/**
	 * Return the value associated with the column: spine
	 */
	public java.lang.String getSpine () {
		return spine;
	}

	/**
	 * Set the value related to the column: spine
	 * @param spine the spine value
	 */
	public void setSpine (java.lang.String spine) {
		this.spine = spine;
	}



	/**
	 * Return the value associated with the column: gait
	 */
	public java.lang.String getGait () {
		return gait;
	}

	/**
	 * Set the value related to the column: gait
	 * @param gait the gait value
	 */
	public void setGait (java.lang.String gait) {
		this.gait = gait;
	}



	/**
	 * Return the value associated with the column: waist
	 */
	public java.lang.Integer getWaist () {
		return waist;
	}

	/**
	 * Set the value related to the column: waist
	 * @param waist the waist value
	 */
	public void setWaist (java.lang.Integer waist) {
		this.waist = waist;
	}



	/**
	 * Return the value associated with the column: hip
	 */
	public java.lang.Integer getHip () {
		return hip;
	}

	/**
	 * Set the value related to the column: hip
	 * @param hip the hip value
	 */
	public void setHip (java.lang.Integer hip) {
		this.hip = hip;
	}



	/**
	 * Return the value associated with the column: marrital_history_remarks
	 */
	public java.lang.String getMarritalHistoryRemarks () {
		return marritalHistoryRemarks;
	}

	/**
	 * Set the value related to the column: marrital_history_remarks
	 * @param marritalHistoryRemarks the marrital_history_remarks value
	 */
	public void setMarritalHistoryRemarks (java.lang.String marritalHistoryRemarks) {
		this.marritalHistoryRemarks = marritalHistoryRemarks;
	}



	/**
	 * Return the value associated with the column: cvs_gen_exam
	 */
	public java.lang.String getCvsGenExam () {
		return cvsGenExam;
	}

	/**
	 * Set the value related to the column: cvs_gen_exam
	 * @param cvsGenExam the cvs_gen_exam value
	 */
	public void setCvsGenExam (java.lang.String cvsGenExam) {
		this.cvsGenExam = cvsGenExam;
	}



	/**
	 * Return the value associated with the column: others_general_examination
	 */
	public java.lang.String getOthersGeneralExamination () {
		return othersGeneralExamination;
	}

	/**
	 * Set the value related to the column: others_general_examination
	 * @param othersGeneralExamination the others_general_examination value
	 */
	public void setOthersGeneralExamination (java.lang.String othersGeneralExamination) {
		this.othersGeneralExamination = othersGeneralExamination;
	}



	/**
	 * Return the value associated with the column: others_tt_details
	 */
	public java.lang.String getOthersTtDetails () {
		return othersTtDetails;
	}

	/**
	 * Set the value related to the column: others_tt_details
	 * @param othersTtDetails the others_tt_details value
	 */
	public void setOthersTtDetails (java.lang.String othersTtDetails) {
		this.othersTtDetails = othersTtDetails;
	}



	/**
	 * Return the value associated with the column: lymphadenopathy_value
	 */
	public java.lang.String getLymphadenopathyValue () {
		return lymphadenopathyValue;
	}

	/**
	 * Set the value related to the column: lymphadenopathy_value
	 * @param lymphadenopathyValue the lymphadenopathy_value value
	 */
	public void setLymphadenopathyValue (java.lang.String lymphadenopathyValue) {
		this.lymphadenopathyValue = lymphadenopathyValue;
	}



	/**
	 * Return the value associated with the column: obstetric_complications
	 */
	public java.lang.String getObstetricComplications () {
		return obstetricComplications;
	}

	/**
	 * Set the value related to the column: obstetric_complications
	 * @param obstetricComplications the obstetric_complications value
	 */
	public void setObstetricComplications (java.lang.String obstetricComplications) {
		this.obstetricComplications = obstetricComplications;
	}



	/**
	 * Return the value associated with the column: obstetric_values
	 */
	public java.lang.String getObstetricValues () {
		return obstetricValues;
	}

	/**
	 * Set the value related to the column: obstetric_values
	 * @param obstetricValues the obstetric_values value
	 */
	public void setObstetricValues (java.lang.String obstetricValues) {
		this.obstetricValues = obstetricValues;
	}



	/**
	 * Return the value associated with the column: date_usg_report
	 */
	public java.lang.String getDateUsgReport () {
		return dateUsgReport;
	}

	/**
	 * Set the value related to the column: date_usg_report
	 * @param dateUsgReport the date_usg_report value
	 */
	public void setDateUsgReport (java.lang.String dateUsgReport) {
		this.dateUsgReport = dateUsgReport;
	}



	/**
	 * Return the value associated with the column: date_usg_one
	 */
	public java.util.Date getDateUsgOne () {
		return dateUsgOne;
	}

	/**
	 * Set the value related to the column: date_usg_one
	 * @param dateUsgOne the date_usg_one value
	 */
	public void setDateUsgOne (java.util.Date dateUsgOne) {
		this.dateUsgOne = dateUsgOne;
	}



	/**
	 * Return the value associated with the column: date_usg_two
	 */
	public java.util.Date getDateUsgTwo () {
		return dateUsgTwo;
	}

	/**
	 * Set the value related to the column: date_usg_two
	 * @param dateUsgTwo the date_usg_two value
	 */
	public void setDateUsgTwo (java.util.Date dateUsgTwo) {
		this.dateUsgTwo = dateUsgTwo;
	}



	/**
	 * Return the value associated with the column: date_usg_three
	 */
	public java.util.Date getDateUsgThree () {
		return dateUsgThree;
	}

	/**
	 * Set the value related to the column: date_usg_three
	 * @param dateUsgThree the date_usg_three value
	 */
	public void setDateUsgThree (java.util.Date dateUsgThree) {
		this.dateUsgThree = dateUsgThree;
	}



	/**
	 * Return the value associated with the column: lmp_ga_usg_report
	 */
	public java.lang.String getLmpGaUsgReport () {
		return lmpGaUsgReport;
	}

	/**
	 * Set the value related to the column: lmp_ga_usg_report
	 * @param lmpGaUsgReport the lmp_ga_usg_report value
	 */
	public void setLmpGaUsgReport (java.lang.String lmpGaUsgReport) {
		this.lmpGaUsgReport = lmpGaUsgReport;
	}



	/**
	 * Return the value associated with the column: lmp_ga_one
	 */
	public java.lang.String getLmpGaOne () {
		return lmpGaOne;
	}

	/**
	 * Set the value related to the column: lmp_ga_one
	 * @param lmpGaOne the lmp_ga_one value
	 */
	public void setLmpGaOne (java.lang.String lmpGaOne) {
		this.lmpGaOne = lmpGaOne;
	}



	/**
	 * Return the value associated with the column: lmp_ga_two
	 */
	public java.lang.String getLmpGaTwo () {
		return lmpGaTwo;
	}

	/**
	 * Set the value related to the column: lmp_ga_two
	 * @param lmpGaTwo the lmp_ga_two value
	 */
	public void setLmpGaTwo (java.lang.String lmpGaTwo) {
		this.lmpGaTwo = lmpGaTwo;
	}



	/**
	 * Return the value associated with the column: lmp_ga_three
	 */
	public java.lang.String getLmpGaThree () {
		return lmpGaThree;
	}

	/**
	 * Set the value related to the column: lmp_ga_three
	 * @param lmpGaThree the lmp_ga_three value
	 */
	public void setLmpGaThree (java.lang.String lmpGaThree) {
		this.lmpGaThree = lmpGaThree;
	}



	/**
	 * Return the value associated with the column: usg_ga_usg_report
	 */
	public java.lang.String getUsgGaUsgReport () {
		return usgGaUsgReport;
	}

	/**
	 * Set the value related to the column: usg_ga_usg_report
	 * @param usgGaUsgReport the usg_ga_usg_report value
	 */
	public void setUsgGaUsgReport (java.lang.String usgGaUsgReport) {
		this.usgGaUsgReport = usgGaUsgReport;
	}



	/**
	 * Return the value associated with the column: usg_ga_one
	 */
	public java.lang.String getUsgGaOne () {
		return usgGaOne;
	}

	/**
	 * Set the value related to the column: usg_ga_one
	 * @param usgGaOne the usg_ga_one value
	 */
	public void setUsgGaOne (java.lang.String usgGaOne) {
		this.usgGaOne = usgGaOne;
	}



	/**
	 * Return the value associated with the column: usg_ga_two
	 */
	public java.lang.String getUsgGaTwo () {
		return usgGaTwo;
	}

	/**
	 * Set the value related to the column: usg_ga_two
	 * @param usgGaTwo the usg_ga_two value
	 */
	public void setUsgGaTwo (java.lang.String usgGaTwo) {
		this.usgGaTwo = usgGaTwo;
	}



	/**
	 * Return the value associated with the column: usg_ga_three
	 */
	public java.lang.String getUsgGaThree () {
		return usgGaThree;
	}

	/**
	 * Set the value related to the column: usg_ga_three
	 * @param usgGaThree the usg_ga_three value
	 */
	public void setUsgGaThree (java.lang.String usgGaThree) {
		this.usgGaThree = usgGaThree;
	}



	/**
	 * Return the value associated with the column: afi_usg_report
	 */
	public java.lang.String getAfiUsgReport () {
		return afiUsgReport;
	}

	/**
	 * Set the value related to the column: afi_usg_report
	 * @param afiUsgReport the afi_usg_report value
	 */
	public void setAfiUsgReport (java.lang.String afiUsgReport) {
		this.afiUsgReport = afiUsgReport;
	}



	/**
	 * Return the value associated with the column: afi_one
	 */
	public java.lang.String getAfiOne () {
		return afiOne;
	}

	/**
	 * Set the value related to the column: afi_one
	 * @param afiOne the afi_one value
	 */
	public void setAfiOne (java.lang.String afiOne) {
		this.afiOne = afiOne;
	}



	/**
	 * Return the value associated with the column: afi_two
	 */
	public java.lang.String getAfiTwo () {
		return afiTwo;
	}

	/**
	 * Set the value related to the column: afi_two
	 * @param afiTwo the afi_two value
	 */
	public void setAfiTwo (java.lang.String afiTwo) {
		this.afiTwo = afiTwo;
	}



	/**
	 * Return the value associated with the column: afi_three
	 */
	public java.lang.String getAfiThree () {
		return afiThree;
	}

	/**
	 * Set the value related to the column: afi_three
	 * @param afiThree the afi_three value
	 */
	public void setAfiThree (java.lang.String afiThree) {
		this.afiThree = afiThree;
	}



	/**
	 * Return the value associated with the column: bpp_usg_report
	 */
	public java.lang.String getBppUsgReport () {
		return bppUsgReport;
	}

	/**
	 * Set the value related to the column: bpp_usg_report
	 * @param bppUsgReport the bpp_usg_report value
	 */
	public void setBppUsgReport (java.lang.String bppUsgReport) {
		this.bppUsgReport = bppUsgReport;
	}



	/**
	 * Return the value associated with the column: bpp_one
	 */
	public java.lang.String getBppOne () {
		return bppOne;
	}

	/**
	 * Set the value related to the column: bpp_one
	 * @param bppOne the bpp_one value
	 */
	public void setBppOne (java.lang.String bppOne) {
		this.bppOne = bppOne;
	}



	/**
	 * Return the value associated with the column: bpp_two_usg
	 */
	public java.lang.String getBppTwoUsg () {
		return bppTwoUsg;
	}

	/**
	 * Set the value related to the column: bpp_two_usg
	 * @param bppTwoUsg the bpp_two_usg value
	 */
	public void setBppTwoUsg (java.lang.String bppTwoUsg) {
		this.bppTwoUsg = bppTwoUsg;
	}



	/**
	 * Return the value associated with the column: bpp_three
	 */
	public java.lang.String getBppThree () {
		return bppThree;
	}

	/**
	 * Set the value related to the column: bpp_three
	 * @param bppThree the bpp_three value
	 */
	public void setBppThree (java.lang.String bppThree) {
		this.bppThree = bppThree;
	}



	/**
	 * Return the value associated with the column: bpd_usg_report
	 */
	public java.lang.String getBpdUsgReport () {
		return bpdUsgReport;
	}

	/**
	 * Set the value related to the column: bpd_usg_report
	 * @param bpdUsgReport the bpd_usg_report value
	 */
	public void setBpdUsgReport (java.lang.String bpdUsgReport) {
		this.bpdUsgReport = bpdUsgReport;
	}



	/**
	 * Return the value associated with the column: bpd_one
	 */
	public java.lang.String getBpdOne () {
		return bpdOne;
	}

	/**
	 * Set the value related to the column: bpd_one
	 * @param bpdOne the bpd_one value
	 */
	public void setBpdOne (java.lang.String bpdOne) {
		this.bpdOne = bpdOne;
	}



	/**
	 * Return the value associated with the column: bpp_two
	 */
	public java.lang.String getBppTwo () {
		return bppTwo;
	}

	/**
	 * Set the value related to the column: bpp_two
	 * @param bppTwo the bpp_two value
	 */
	public void setBppTwo (java.lang.String bppTwo) {
		this.bppTwo = bppTwo;
	}



	/**
	 * Return the value associated with the column: bpd_three
	 */
	public java.lang.String getBpdThree () {
		return bpdThree;
	}

	/**
	 * Set the value related to the column: bpd_three
	 * @param bpdThree the bpd_three value
	 */
	public void setBpdThree (java.lang.String bpdThree) {
		this.bpdThree = bpdThree;
	}



	/**
	 * Return the value associated with the column: fl_usg_report
	 */
	public java.lang.String getFlUsgReport () {
		return flUsgReport;
	}

	/**
	 * Set the value related to the column: fl_usg_report
	 * @param flUsgReport the fl_usg_report value
	 */
	public void setFlUsgReport (java.lang.String flUsgReport) {
		this.flUsgReport = flUsgReport;
	}



	/**
	 * Return the value associated with the column: fl_one
	 */
	public java.lang.String getFlOne () {
		return flOne;
	}

	/**
	 * Set the value related to the column: fl_one
	 * @param flOne the fl_one value
	 */
	public void setFlOne (java.lang.String flOne) {
		this.flOne = flOne;
	}



	/**
	 * Return the value associated with the column: fl_two
	 */
	public java.lang.String getFlTwo () {
		return flTwo;
	}

	/**
	 * Set the value related to the column: fl_two
	 * @param flTwo the fl_two value
	 */
	public void setFlTwo (java.lang.String flTwo) {
		this.flTwo = flTwo;
	}



	/**
	 * Return the value associated with the column: fl_three
	 */
	public java.lang.String getFlThree () {
		return flThree;
	}

	/**
	 * Set the value related to the column: fl_three
	 * @param flThree the fl_three value
	 */
	public void setFlThree (java.lang.String flThree) {
		this.flThree = flThree;
	}



	/**
	 * Return the value associated with the column: ac_usg_report
	 */
	public java.lang.String getAcUsgReport () {
		return acUsgReport;
	}

	/**
	 * Set the value related to the column: ac_usg_report
	 * @param acUsgReport the ac_usg_report value
	 */
	public void setAcUsgReport (java.lang.String acUsgReport) {
		this.acUsgReport = acUsgReport;
	}



	/**
	 * Return the value associated with the column: ac_one
	 */
	public java.lang.String getAcOne () {
		return acOne;
	}

	/**
	 * Set the value related to the column: ac_one
	 * @param acOne the ac_one value
	 */
	public void setAcOne (java.lang.String acOne) {
		this.acOne = acOne;
	}



	/**
	 * Return the value associated with the column: ac_two
	 */
	public java.lang.String getAcTwo () {
		return acTwo;
	}

	/**
	 * Set the value related to the column: ac_two
	 * @param acTwo the ac_two value
	 */
	public void setAcTwo (java.lang.String acTwo) {
		this.acTwo = acTwo;
	}



	/**
	 * Return the value associated with the column: ac_three
	 */
	public java.lang.String getAcThree () {
		return acThree;
	}

	/**
	 * Set the value related to the column: ac_three
	 * @param acThree the ac_three value
	 */
	public void setAcThree (java.lang.String acThree) {
		this.acThree = acThree;
	}



	/**
	 * Return the value associated with the column: hc_usg_report
	 */
	public java.lang.String getHcUsgReport () {
		return hcUsgReport;
	}

	/**
	 * Set the value related to the column: hc_usg_report
	 * @param hcUsgReport the hc_usg_report value
	 */
	public void setHcUsgReport (java.lang.String hcUsgReport) {
		this.hcUsgReport = hcUsgReport;
	}



	/**
	 * Return the value associated with the column: hc_one
	 */
	public java.lang.String getHcOne () {
		return hcOne;
	}

	/**
	 * Set the value related to the column: hc_one
	 * @param hcOne the hc_one value
	 */
	public void setHcOne (java.lang.String hcOne) {
		this.hcOne = hcOne;
	}



	/**
	 * Return the value associated with the column: hc_two
	 */
	public java.lang.String getHcTwo () {
		return hcTwo;
	}

	/**
	 * Set the value related to the column: hc_two
	 * @param hcTwo the hc_two value
	 */
	public void setHcTwo (java.lang.String hcTwo) {
		this.hcTwo = hcTwo;
	}



	/**
	 * Return the value associated with the column: hc_three
	 */
	public java.lang.String getHcThree () {
		return hcThree;
	}

	/**
	 * Set the value related to the column: hc_three
	 * @param hcThree the hc_three value
	 */
	public void setHcThree (java.lang.String hcThree) {
		this.hcThree = hcThree;
	}



	/**
	 * Return the value associated with the column: ebw_usg_report
	 */
	public java.lang.String getEbwUsgReport () {
		return ebwUsgReport;
	}

	/**
	 * Set the value related to the column: ebw_usg_report
	 * @param ebwUsgReport the ebw_usg_report value
	 */
	public void setEbwUsgReport (java.lang.String ebwUsgReport) {
		this.ebwUsgReport = ebwUsgReport;
	}



	/**
	 * Return the value associated with the column: ebw_one
	 */
	public java.lang.String getEbwOne () {
		return ebwOne;
	}

	/**
	 * Set the value related to the column: ebw_one
	 * @param ebwOne the ebw_one value
	 */
	public void setEbwOne (java.lang.String ebwOne) {
		this.ebwOne = ebwOne;
	}



	/**
	 * Return the value associated with the column: ebw_two
	 */
	public java.lang.String getEbwTwo () {
		return ebwTwo;
	}

	/**
	 * Set the value related to the column: ebw_two
	 * @param ebwTwo the ebw_two value
	 */
	public void setEbwTwo (java.lang.String ebwTwo) {
		this.ebwTwo = ebwTwo;
	}



	/**
	 * Return the value associated with the column: ebw_three
	 */
	public java.lang.String getEbwThree () {
		return ebwThree;
	}

	/**
	 * Set the value related to the column: ebw_three
	 * @param ebwThree the ebw_three value
	 */
	public void setEbwThree (java.lang.String ebwThree) {
		this.ebwThree = ebwThree;
	}



	/**
	 * Return the value associated with the column: doppler_usg_report
	 */
	public java.lang.String getDopplerUsgReport () {
		return dopplerUsgReport;
	}

	/**
	 * Set the value related to the column: doppler_usg_report
	 * @param dopplerUsgReport the doppler_usg_report value
	 */
	public void setDopplerUsgReport (java.lang.String dopplerUsgReport) {
		this.dopplerUsgReport = dopplerUsgReport;
	}



	/**
	 * Return the value associated with the column: doppler_one
	 */
	public java.lang.String getDopplerOne () {
		return dopplerOne;
	}

	/**
	 * Set the value related to the column: doppler_one
	 * @param dopplerOne the doppler_one value
	 */
	public void setDopplerOne (java.lang.String dopplerOne) {
		this.dopplerOne = dopplerOne;
	}



	/**
	 * Return the value associated with the column: doppler_two
	 */
	public java.lang.String getDopplerTwo () {
		return dopplerTwo;
	}

	/**
	 * Set the value related to the column: doppler_two
	 * @param dopplerTwo the doppler_two value
	 */
	public void setDopplerTwo (java.lang.String dopplerTwo) {
		this.dopplerTwo = dopplerTwo;
	}



	/**
	 * Return the value associated with the column: doppler_three
	 */
	public java.lang.String getDopplerThree () {
		return dopplerThree;
	}

	/**
	 * Set the value related to the column: doppler_three
	 * @param dopplerThree the doppler_three value
	 */
	public void setDopplerThree (java.lang.String dopplerThree) {
		this.dopplerThree = dopplerThree;
	}



	/**
	 * Return the value associated with the column: usg_remarks
	 */
	public java.lang.String getUsgRemarks () {
		return usgRemarks;
	}

	/**
	 * Set the value related to the column: usg_remarks
	 * @param usgRemarks the usg_remarks value
	 */
	public void setUsgRemarks (java.lang.String usgRemarks) {
		this.usgRemarks = usgRemarks;
	}



	/**
	 * Return the value associated with the column: usg_second_remarks
	 */
	public java.lang.String getUsgSecondRemarks () {
		return usgSecondRemarks;
	}

	/**
	 * Set the value related to the column: usg_second_remarks
	 * @param usgSecondRemarks the usg_second_remarks value
	 */
	public void setUsgSecondRemarks (java.lang.String usgSecondRemarks) {
		this.usgSecondRemarks = usgSecondRemarks;
	}



	/**
	 * Return the value associated with the column: usg_third_remarks
	 */
	public java.lang.String getUsgThirdRemarks () {
		return usgThirdRemarks;
	}

	/**
	 * Set the value related to the column: usg_third_remarks
	 * @param usgThirdRemarks the usg_third_remarks value
	 */
	public void setUsgThirdRemarks (java.lang.String usgThirdRemarks) {
		this.usgThirdRemarks = usgThirdRemarks;
	}



	/**
	 * Return the value associated with the column: clubbing
	 */
	public java.lang.String getClubbing () {
		return clubbing;
	}

	/**
	 * Set the value related to the column: clubbing
	 * @param clubbing the clubbing value
	 */
	public void setClubbing (java.lang.String clubbing) {
		this.clubbing = clubbing;
	}



	/**
	 * Return the value associated with the column: reffered_hospital
	 */
	public java.lang.String getRefferedHospital () {
		return refferedHospital;
	}

	/**
	 * Set the value related to the column: reffered_hospital
	 * @param refferedHospital the reffered_hospital value
	 */
	public void setRefferedHospital (java.lang.String refferedHospital) {
		this.refferedHospital = refferedHospital;
	}



	/**
	 * Return the value associated with the column: reffered_ga
	 */
	public java.lang.String getRefferedGA () {
		return refferedGA;
	}

	/**
	 * Set the value related to the column: reffered_ga
	 * @param refferedGA the reffered_ga value
	 */
	public void setRefferedGA (java.lang.String refferedGA) {
		this.refferedGA = refferedGA;
	}



	/**
	 * Return the value associated with the column: unknown_lmp_status
	 */
	public java.lang.String getUnknownLmpStatus () {
		return unknownLmpStatus;
	}

	/**
	 * Set the value related to the column: unknown_lmp_status
	 * @param unknownLmpStatus the unknown_lmp_status value
	 */
	public void setUnknownLmpStatus (java.lang.String unknownLmpStatus) {
		this.unknownLmpStatus = unknownLmpStatus;
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
	 * Return the value associated with the column: inpatientid
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatientid
	 * @param inpatient the inpatientid value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdAntenatalCard)) return false;
		else {
			jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard = (jkt.hms.masters.business.OpdAntenatalCard) obj;
			if (null == this.getId() || null == opdAntenatalCard.getId()) return false;
			else return (this.getId().equals(opdAntenatalCard.getId()));
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