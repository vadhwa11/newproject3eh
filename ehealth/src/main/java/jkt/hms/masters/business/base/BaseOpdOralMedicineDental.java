package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_oral_medicine_dental table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_oral_medicine_dental"
 */

public abstract class BaseOpdOralMedicineDental  implements Serializable {

	public static String REF = "OpdOralMedicineDental";
	public static String PROP_TEETH37_VALUE = "Teeth37Value";
	public static String PROP_SMOKELESS_DAILY_PAST = "SmokelessDailyPast";
	public static String PROP_SMOKING_DOCTOR_ASK_FROMER = "SmokingDoctorAskFromer";
	public static String PROP_SMOKING_VISITED_DOCTOR_FROMER = "SmokingVisitedDoctorFromer";
	public static String PROP_TEETH52_VALUE = "Teeth52Value";
	public static String PROP_ORAL_EYES = "OralEyes";
	public static String PROP_SMOKING_QUIT_PERIOD = "SmokingQuitPeriod";
	public static String PROP_SMOKING_QUIT_TOBACOO_FROMER = "SmokingQuitTobacooFromer";
	public static String PROP_TEETH34 = "Teeth34";
	public static String PROP_SMOKELESS_LESS_DAILY_START_AGE = "SmokelessLessDailyStartAge";
	public static String PROP_TEETH33 = "Teeth33";
	public static String PROP_TEETH36 = "Teeth36";
	public static String PROP_TEETH38_VALUE = "Teeth38Value";
	public static String PROP_TEETH35 = "Teeth35";
	public static String PROP_TEETH38 = "Teeth38";
	public static String PROP_ALCOHOL_QUIT_ANY_FROMER = "AlcoholQuitAnyFromer";
	public static String PROP_TEETH37 = "Teeth37";
	public static String PROP_TEETH53_VALUE = "Teeth53Value";
	public static String PROP_GEN_NUTRITIONAL = "GenNutritional";
	public static String PROP_INDIGESTION = "Indigestion";
	public static String PROP_TEETH27_VALUE = "Teeth27Value";
	public static String PROP_TEETH32 = "Teeth32";
	public static String PROP_GEN_DEVELOPMENTAL = "GenDevelopmental";
	public static String PROP_TEETH31 = "Teeth31";
	public static String PROP_SMOKELESS_FREQUENCY_PAST = "SmokelessFrequencyPast";
	public static String PROP_ALCOHOL_STOP_YEAR_FORMER = "AlcoholStopYearFormer";
	public static String PROP_TEETH47 = "Teeth47";
	public static String PROP_TEETH46 = "Teeth46";
	public static String PROP_TEETH45 = "Teeth45";
	public static String PROP_SMOKELESS_AFTER_WAKEUP = "SmokelessAfterWakeup";
	public static String PROP_ALCOHOL_LESS_DAILY_START_AGE = "AlcoholLessDailyStartAge";
	public static String PROP_HIGH_JUGULAR = "HighJugular";
	public static String PROP_TEETH44 = "Teeth44";
	public static String PROP_TEETH85_VALUE = "Teeth85Value";
	public static String PROP_TEETH48 = "Teeth48";
	public static String PROP_CASE_SUMMARY = "CaseSummary";
	public static String PROP_MICTURITION = "Micturition";
	public static String PROP_TEETH43 = "Teeth43";
	public static String PROP_TEETH42 = "Teeth42";
	public static String PROP_TEETH41 = "Teeth41";
	public static String PROP_GEN_HAIR = "GenHair";
	public static String PROP_PERIOD = "Period";
	public static String PROP_ORAL_NOSE = "OralNose";
	public static String PROP_SMOKELESS_NO_VISITED_DOCTOR_FROMER = "SmokelessNoVisitedDoctorFromer";
	public static String PROP_SUBMENTAL_SUBMANDIBULAR = "SubmentalSubmandibular";
	public static String PROP_SMOKING_DAILY_START_AGE = "SmokingDailyStartAge";
	public static String PROP_TEETH44_VALUE = "Teeth44Value";
	public static String PROP_TEETH16 = "Teeth16";
	public static String PROP_TEETH15 = "Teeth15";
	public static String PROP_TEETH18 = "Teeth18";
	public static String PROP_TEETH17 = "Teeth17";
	public static String PROP_TEETH12 = "Teeth12";
	public static String PROP_TEETH11 = "Teeth11";
	public static String PROP_SMOKING_AFTER_WAKEUP = "SmokingAfterWakeup";
	public static String PROP_SMOKING_DAILY_START_YEAR_FORMER = "SmokingDailyStartYearFormer";
	public static String PROP_TEETH14 = "Teeth14";
	public static String PROP_ORAL_THROAT = "OralThroat";
	public static String PROP_TEETH13 = "Teeth13";
	public static String PROP_MOUTH_OPENING = "MouthOpening";
	public static String PROP_TEETH47_VALUE = "Teeth47Value";
	public static String PROP_HISTORY_PRESENTING_COMPLAINT = "HistoryPresentingComplaint";
	public static String PROP_ALCOHOL_LESS_DAILY_PRODUCT = "AlcoholLessDailyProduct";
	public static String PROP_LOW_JUGULAR = "LowJugular";
	public static String PROP_SMOKELESS_TRY_STOP = "SmokelessTryStop";
	public static String PROP_BRUSHING_HABBITS = "BrushingHabbits";
	public static String PROP_TEETH46_VALUE = "Teeth46Value";
	public static String PROP_SMOKING_DAILY_START_AGE_FORMER = "SmokingDailyStartAgeFormer";
	public static String PROP_ORAL_TMJ = "OralTmj";
	public static String PROP_SMOKELESS_CURRENTLY = "SmokelessCurrently";
	public static String PROP_ORAL_EAR = "OralEar";
	public static String PROP_TEETH28 = "Teeth28";
	public static String PROP_TEETH27 = "Teeth27";
	public static String PROP_TEETH26 = "Teeth26";
	public static String PROP_TEETH25 = "Teeth25";
	public static String PROP_TEETH24 = "Teeth24";
	public static String PROP_TEETH23 = "Teeth23";
	public static String PROP_TEETH54_VALUE = "Teeth54Value";
	public static String PROP_TEETH22 = "Teeth22";
	public static String PROP_TEETH21 = "Teeth21";
	public static String PROP_ALCOHOL_CURRENTLY = "AlcoholCurrently";
	public static String PROP_TEETH43_VALUE = "Teeth43Value";
	public static String PROP_WEIGHT_LOSS_GAIN = "WeightLossGain";
	public static String PROP_SMOKELESS_VISITED_DOCTOR_FROMER = "SmokelessVisitedDoctorFromer";
	public static String PROP_LATERAL_BORDER = "LateralBorder";
	public static String PROP_TEETH18_VALUE = "Teeth18Value";
	public static String PROP_ALCOHOL_DAILY_START_YEAR = "AlcoholDailyStartYear";
	public static String PROP_TEETH82_VALUE = "Teeth82Value";
	public static String PROP_SMOKELESS_DAILY_START_AGE_FORMER = "SmokelessDailyStartAgeFormer";
	public static String PROP_ORAL_FACIAL_FORM = "OralFacialForm";
	public static String PROP_TEETH34_VALUE = "Teeth34Value";
	public static String PROP_ALCOHOL_AFTER_WAKEUP = "AlcoholAfterWakeup";
	public static String PROP_TEETH36_VALUE = "Teeth36Value";
	public static String PROP_ORAL_NECK = "OralNeck";
	public static String PROP_LOCAL_EXAMINATION_FINDINGS = "LocalExaminationFindings";
	public static String PROP_ALCOHOL_NO_VISITED_DOCTOR_FROMER = "AlcoholNoVisitedDoctorFromer";
	public static String PROP_DORSUM = "Dorsum";
	public static String PROP_TEETH41_VALUE = "Teeth41Value";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TEETH32_VALUE = "Teeth32Value";
	public static String PROP_TEETH62_VALUE = "Teeth62Value";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SMOKELESS_DOCTOR_ASK_FROMER = "SmokelessDoctorAskFromer";
	public static String PROP_ALCOHOL_QUIT_TOBACOO_FROMER = "AlcoholQuitTobacooFromer";
	public static String PROP_SMOKELESS_QUIT_TOBACOO_FROMER = "SmokelessQuitTobacooFromer";
	public static String PROP_LATERAL_BORDER_DETAILS = "LateralBorderDetails";
	public static String PROP_TEETH12_VALUE = "Teeth12Value";
	public static String PROP_SMOKING_LESS_DAILY_START_YEAR = "SmokingLessDailyStartYear";
	public static String PROP_TONGUE_INSPECTION = "TongueInspection";
	public static String PROP_TEETH74_VALUE = "Teeth74Value";
	public static String PROP_HAEMATURIA = "Haematuria";
	public static String PROP_GEN_SKULL = "GenSkull";
	public static String PROP_SPUTUM_QUANTITY = "SputumQuantity";
	public static String PROP_CHEST_PAIN = "ChestPain";
	public static String PROP_MENOPAUSE = "Menopause";
	public static String PROP_TEETH24_VALUE = "Teeth24Value";
	public static String PROP_TEETH65_VALUE = "Teeth65Value";
	public static String PROP_TEETH28_VALUE = "Teeth28Value";
	public static String PROP_TRACHEO_OESOPHAGEAL = "TracheoOesophageal";
	public static String PROP_ALCOHOL_QUIT_PERIOD = "AlcoholQuitPeriod";
	public static String PROP_APPETITE = "Appetite";
	public static String PROP_SMOKELESS_DAILY_START_YEAR = "SmokelessDailyStartYear";
	public static String PROP_OEDEMA_FEET = "OedemaFeet";
	public static String PROP_SMOKELESS_LESS_DAILY_START_YEAR = "SmokelessLessDailyStartYear";
	public static String PROP_HEADACHE = "Headache";
	public static String PROP_ORAL_HAIR = "OralHair";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ALCOHOL_VISITED_DOCTOR_FROMER = "AlcoholVisitedDoctorFromer";
	public static String PROP_PAST_MEDICAL_DENTAL_HISTORY = "PastMedicalDentalHistory";
	public static String PROP_SMOKING_CURRENTLY = "SmokingCurrently";
	public static String PROP_ORAL_SALIVARY_GLANDS = "OralSalivaryGlands";
	public static String PROP_TEETH16_VALUE = "Teeth16Value";
	public static String PROP_SMOKING_QUIT_ANY_FROMER = "SmokingQuitAnyFromer";
	public static String PROP_ANGINA = "Angina";
	public static String PROP_HOARSENESS = "Hoarseness";
	public static String PROP_DIETARY_HABBITS = "DietaryHabbits";
	public static String PROP_GEN_LYMPH_NODES = "GenLymphNodes";
	public static String PROP_FITS = "Fits";
	public static String PROP_TEETH75_VALUE = "Teeth75Value";
	public static String PROP_ALCOHOL_LESS_DAILY_START_YEAR = "AlcoholLessDailyStartYear";
	public static String PROP_ORAL_CRANIAL_NERVES_EXAMINATION = "OralCranialNervesExamination";
	public static String PROP_TEETH25_VALUE = "Teeth25Value";
	public static String PROP_ALCOHOL_DOCTOR_ASK_FROMER = "AlcoholDoctorAskFromer";
	public static String PROP_TEETH51_VALUE = "Teeth51Value";
	public static String PROP_HIN = "Hin";
	public static String PROP_SMOKELESS_QUIT_PERIOD = "SmokelessQuitPeriod";
	public static String PROP_TEETH14_VALUE = "Teeth14Value";
	public static String PROP_SMOKING_LESS_DAILY_PRODUCT = "SmokingLessDailyProduct";
	public static String PROP_SMOKING_TRY_STOP = "SmokingTryStop";
	public static String PROP_SMOKING_TRY_QUITTING = "SmokingTryQuitting";
	public static String PROP_ALCOHOL_DAILY_START_YEAR_FORMER = "AlcoholDailyStartYearFormer";
	public static String PROP_DENTITION_STATUS = "DentitionStatus";
	public static String PROP_GEN_NAILS = "GenNails";
	public static String PROP_SMOKING_DAILY_START_YEAR = "SmokingDailyStartYear";
	public static String PROP_NOCTURIA = "Nocturia";
	public static String PROP_TEETH83_VALUE = "Teeth83Value";
	public static String PROP_ORAL_HYGIENE_STATUS = "OralHygieneStatus";
	public static String PROP_SMOKING_NO_VISITED_DOCTOR_FROMER = "SmokingNoVisitedDoctorFromer";
	public static String PROP_COUGH = "Cough";
	public static String PROP_SMOKELESS_QUIT_ANY_FROMER = "SmokelessQuitAnyFromer";
	public static String PROP_TEETH31_VALUE = "Teeth31Value";
	public static String PROP_TEETH11_VALUE = "Teeth11Value";
	public static String PROP_TEETH42_VALUE = "Teeth42Value";
	public static String PROP_ORAL_SKIN = "OralSkin";
	public static String PROP_GEN_EYES = "GenEyes";
	public static String PROP_SPUTUM_SMELL = "SputumSmell";
	public static String PROP_MID_JUGULAR = "MidJugular";
	public static String PROP_BOWELS = "Bowels";
	public static String PROP_SMOKING_DAILY_PAST = "SmokingDailyPast";
	public static String PROP_TEETH71_VALUE = "Teeth71Value";
	public static String PROP_TEETH81_VALUE = "Teeth81Value";
	public static String PROP_GEN_NOSE = "GenNose";
	public static String PROP_VOMITING = "Vomiting";
	public static String PROP_TEETH48_VALUE = "Teeth48Value";
	public static String PROP_TEETH21_VALUE = "Teeth21Value";
	public static String PROP_SPUTUM_COLOUR = "SputumColour";
	public static String PROP_SMOKELESS_TRY_QUITTING = "SmokelessTryQuitting";
	public static String PROP_VISION = "Vision";
	public static String PROP_POSTERIOR_JUGULAR = "PosteriorJugular";
	public static String PROP_SMOKING_DAILY_PRODUCT = "SmokingDailyProduct";
	public static String PROP_MENARCHE = "Menarche";
	public static String PROP_SUPERIOR_MEDIASTINAL = "SuperiorMediastinal";
	public static String PROP_SMOKELESS_DAILY_PRODUCT = "SmokelessDailyProduct";
	public static String PROP_TEETH26_VALUE = "Teeth26Value";
	public static String PROP_ALCOHOL_DAILY_PRODUCT = "AlcoholDailyProduct";
	public static String PROP_DYSPNOEA = "Dyspnoea";
	public static String PROP_PRESENTING_COMPLAINTS = "PresentingComplaints";
	public static String PROP_ALCOHOL_DAILY_PAST = "AlcoholDailyPast";
	public static String PROP_GEN_SKIN = "GenSkin";
	public static String PROP_MICTURITION_FREQUENCY = "MicturitionFrequency";
	public static String PROP_TEETH64_VALUE = "Teeth64Value";
	public static String PROP_SORE_THROAT = "SoreThroat";
	public static String PROP_TEETH84 = "Teeth84";
	public static String PROP_TEETH85 = "Teeth85";
	public static String PROP_ALCOHOL_TRY_STOP = "AlcoholTryStop";
	public static String PROP_EPISTAXIS = "Epistaxis";
	public static String PROP_TEETH81 = "Teeth81";
	public static String PROP_TEETH82 = "Teeth82";
	public static String PROP_TEETH83 = "Teeth83";
	public static String PROP_TEETH55_VALUE = "Teeth55Value";
	public static String PROP_ORTHOPNOEA = "Orthopnoea";
	public static String PROP_PERSONAL_SOCIAL_HISTORY = "PersonalSocialHistory";
	public static String PROP_SMOKELESS_STOP_YEAR_FORMER = "SmokelessStopYearFormer";
	public static String PROP_FREQUENT_COLDS = "FrequentColds";
	public static String PROP_TEETH73_VALUE = "Teeth73Value";
	public static String PROP_TEETH17_VALUE = "Teeth17Value";
	public static String PROP_TEETH61_VALUE = "Teeth61Value";
	public static String PROP_TEETH75 = "Teeth75";
	public static String PROP_TEETH73 = "Teeth73";
	public static String PROP_TEETH74 = "Teeth74";
	public static String PROP_TEETH71 = "Teeth71";
	public static String PROP_TEETH84_VALUE = "Teeth84Value";
	public static String PROP_TEETH72 = "Teeth72";
	public static String PROP_SMOKELESS_LESS_DAILY_PRODUCT = "SmokelessLessDailyProduct";
	public static String PROP_FLOW_DAYS = "FlowDays";
	public static String PROP_ALCOHOL_DAILY_START_AGE = "AlcoholDailyStartAge";
	public static String PROP_SMOKELESS_DAILY_START_AGE = "SmokelessDailyStartAge";
	public static String PROP_HAEMOPTYSIS = "Haemoptysis";
	public static String PROP_SMOKING_FREQUENCY_PAST = "SmokingFrequencyPast";
	public static String PROP_ID = "Id";
	public static String PROP_SPUTUM = "Sputum";
	public static String PROP_TEETH45_VALUE = "Teeth45Value";
	public static String PROP_SMOKING_STOP_YEAR_FORMER = "SmokingStopYearFormer";
	public static String PROP_GEN_EARS = "GenEars";
	public static String PROP_ORAL_HEAD = "OralHead";
	public static String PROP_TEETH61 = "Teeth61";
	public static String PROP_TEETH62 = "Teeth62";
	public static String PROP_TEETH63 = "Teeth63";
	public static String PROP_ALCOHOL_TRY_STOP_USING = "AlcoholTryStopUsing";
	public static String PROP_SMOKELESS_DAILY_START_YEAR_FORMER = "SmokelessDailyStartYearFormer";
	public static String PROP_TEETH64 = "Teeth64";
	public static String PROP_TEETH65 = "Teeth65";
	public static String PROP_TEETH72_VALUE = "Teeth72Value";
	public static String PROP_VENTRAL_SURFACE = "VentralSurface";
	public static String PROP_ORAL_SALIVARY_GLANDS_PALPABLE = "OralSalivaryGlandsPalpable";
	public static String PROP_TEETH33_VALUE = "Teeth33Value";
	public static String PROP_ALCOHOL_DAILY_START_AGE_FORMER = "AlcoholDailyStartAgeFormer";
	public static String PROP_TEETH53 = "Teeth53";
	public static String PROP_ALCOHOL_TRY_QUITTING = "AlcoholTryQuitting";
	public static String PROP_TEETH54 = "Teeth54";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_TEETH51 = "Teeth51";
	public static String PROP_TEETH52 = "Teeth52";
	public static String PROP_TEETH55 = "Teeth55";
	public static String PROP_TEETH23_VALUE = "Teeth23Value";
	public static String PROP_DYSURIA = "Dysuria";
	public static String PROP_TEETH15_VALUE = "Teeth15Value";
	public static String PROP_SMOKELESS_TRY_STOP_USING = "SmokelessTryStopUsing";
	public static String PROP_TEETH35_VALUE = "Teeth35Value";
	public static String PROP_SMOKING_LESS_DAILY_START_AGE = "SmokingLessDailyStartAge";
	public static String PROP_TEETH22_VALUE = "Teeth22Value";
	public static String PROP_TEETH63_VALUE = "Teeth63Value";
	public static String PROP_SMOKING_TRY_STOP_USING = "SmokingTryStopUsing";
	public static String PROP_TEETH13_VALUE = "Teeth13Value";
	public static String PROP_HEARING = "Hearing";
	public static String PROP_ALCOHOL_FREQUENCY_PAST = "AlcoholFrequencyPast";
	public static String PROP_GEN_HEAD = "GenHead";


	// constructors
	public BaseOpdOralMedicineDental () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOralMedicineDental (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String presentingComplaints;
	private java.lang.String historyPresentingComplaint;
	private java.lang.String pastMedicalDentalHistory;
	private java.lang.String familyHistory;
	private java.lang.String personalSocialHistory;
	private java.lang.String dietaryHabbits;
	private java.lang.String brushingHabbits;
	private java.lang.String smokingCurrently;
	private java.lang.String smokelessCurrently;
	private java.lang.String alcoholCurrently;
	private java.lang.String smokingDailyPast;
	private java.lang.String smokelessDailyPast;
	private java.lang.String alcoholDailyPast;
	private java.lang.String smokingFrequencyPast;
	private java.lang.String smokelessFrequencyPast;
	private java.lang.String alcoholFrequencyPast;
	private java.lang.Integer smokingDailyStartAge;
	private java.lang.Integer smokelessDailyStartAge;
	private java.lang.Integer alcoholDailyStartAge;
	private java.lang.Integer smokingDailyStartYear;
	private java.lang.Integer smokelessDailyStartYear;
	private java.lang.Integer alcoholDailyStartYear;
	private java.lang.Integer smokingDailyProduct;
	private java.lang.Integer smokelessDailyProduct;
	private java.lang.Integer alcoholDailyProduct;
	private java.lang.Integer smokingAfterWakeup;
	private java.lang.Integer smokelessAfterWakeup;
	private java.lang.Integer alcoholAfterWakeup;
	private java.lang.Integer smokingLessDailyStartAge;
	private java.lang.Integer smokelessLessDailyStartAge;
	private java.lang.Integer alcoholLessDailyStartAge;
	private java.lang.Integer smokingLessDailyStartYear;
	private java.lang.Integer smokelessLessDailyStartYear;
	private java.lang.Integer alcoholLessDailyStartYear;
	private java.lang.Integer smokingLessDailyProduct;
	private java.lang.Integer smokelessLessDailyProduct;
	private java.lang.Integer alcoholLessDailyProduct;
	private java.lang.Integer smokingDailyStartAgeFormer;
	private java.lang.Integer smokelessDailyStartAgeFormer;
	private java.lang.Integer alcoholDailyStartAgeFormer;
	private java.lang.Integer smokingDailyStartYearFormer;
	private java.lang.Integer smokelessDailyStartYearFormer;
	private java.lang.Integer alcoholDailyStartYearFormer;
	private java.lang.Integer smokingStopYearFormer;
	private java.lang.Integer smokelessStopYearFormer;
	private java.lang.Integer alcoholStopYearFormer;
	private java.lang.String smokingVisitedDoctorFromer;
	private java.lang.String smokelessVisitedDoctorFromer;
	private java.lang.String alcoholVisitedDoctorFromer;
	private java.lang.Integer smokingNoVisitedDoctorFromer;
	private java.lang.Integer smokelessNoVisitedDoctorFromer;
	private java.lang.Integer alcoholNoVisitedDoctorFromer;
	private java.lang.String smokingDoctorAskFromer;
	private java.lang.String smokelessDoctorAskFromer;
	private java.lang.String alcoholDoctorAskFromer;
	private java.lang.String smokingQuitTobacooFromer;
	private java.lang.String smokelessQuitTobacooFromer;
	private java.lang.String alcoholQuitTobacooFromer;
	private java.lang.String smokingQuitAnyFromer;
	private java.lang.String smokelessQuitAnyFromer;
	private java.lang.String alcoholQuitAnyFromer;
	private java.lang.String smokingTryStop;
	private java.lang.String smokelessTryStop;
	private java.lang.String alcoholTryStop;
	private java.lang.Integer smokingQuitPeriod;
	private java.lang.Integer smokelessQuitPeriod;
	private java.lang.Integer alcoholQuitPeriod;
	private java.lang.String smokingTryStopUsing;
	private java.lang.String smokelessTryStopUsing;
	private java.lang.String alcoholTryStopUsing;
	private java.lang.String smokingTryQuitting;
	private java.lang.String smokelessTryQuitting;
	private java.lang.String alcoholTryQuitting;
	private java.lang.String appetite;
	private java.lang.Integer weightLossGain;
	private java.lang.String indigestion;
	private java.lang.String bowels;
	private java.lang.String chestPain;
	private java.lang.String angina;
	private java.lang.String dyspnoea;
	private java.lang.String orthopnoea;
	private java.lang.String oedemaFeet;
	private java.lang.String cough;
	private java.lang.String haemoptysis;
	private java.lang.String sputum;
	private java.lang.String sputumColour;
	private java.lang.String sputumQuantity;
	private java.lang.String sputumSmell;
	private java.lang.String vision;
	private java.lang.String hearing;
	private java.lang.String micturition;
	private java.lang.Integer micturitionFrequency;
	private java.lang.String dysuria;
	private java.lang.String haematuria;
	private java.lang.String nocturia;
	private java.lang.Integer period;
	private java.lang.Integer menarche;
	private java.lang.Integer flowDays;
	private java.lang.Integer menopause;
	private java.lang.String hoarseness;
	private java.lang.String soreThroat;
	private java.lang.String epistaxis;
	private java.lang.String frequentColds;
	private java.lang.String headache;
	private java.lang.String vomiting;
	private java.lang.String fits;
	private java.lang.String genDevelopmental;
	private java.lang.String genNutritional;
	private java.lang.String genHead;
	private java.lang.String genSkull;
	private java.lang.String genEyes;
	private java.lang.String genEars;
	private java.lang.String genNose;
	private java.lang.String genSkin;
	private java.lang.String genHair;
	private java.lang.String genNails;
	private java.lang.String genLymphNodes;
	private java.lang.String oralHead;
	private java.lang.String oralFacialForm;
	private java.lang.String oralHair;
	private java.lang.String oralSkin;
	private java.lang.String oralEyes;
	private java.lang.String oralEar;
	private java.lang.String oralNose;
	private java.lang.String oralThroat;
	private java.lang.String oralSalivaryGlands;
	private java.lang.String oralSalivaryGlandsPalpable;
	private java.lang.String oralCranialNervesExamination;
	private java.lang.String oralNeck;
	private java.lang.String oralTmj;
	private java.lang.String submentalSubmandibular;
	private java.lang.String highJugular;
	private java.lang.String midJugular;
	private java.lang.String lowJugular;
	private java.lang.String posteriorJugular;
	private java.lang.String tracheoOesophageal;
	private java.lang.String superiorMediastinal;
	private java.lang.String mouthOpening;
	private java.lang.String oralHygieneStatus;
	private java.lang.String dentitionStatus;
	private java.lang.String teeth18;
	private java.lang.String teeth17;
	private java.lang.String teeth16;
	private java.lang.String teeth15;
	private java.lang.String teeth14;
	private java.lang.String teeth13;
	private java.lang.String teeth12;
	private java.lang.String teeth11;
	private java.lang.String teeth21;
	private java.lang.String teeth22;
	private java.lang.String teeth23;
	private java.lang.String teeth24;
	private java.lang.String teeth25;
	private java.lang.String teeth26;
	private java.lang.String teeth27;
	private java.lang.String teeth28;
	private java.lang.String teeth48;
	private java.lang.String teeth47;
	private java.lang.String teeth46;
	private java.lang.String teeth45;
	private java.lang.String teeth44;
	private java.lang.String teeth43;
	private java.lang.String teeth42;
	private java.lang.String teeth41;
	private java.lang.String teeth31;
	private java.lang.String teeth32;
	private java.lang.String teeth33;
	private java.lang.String teeth34;
	private java.lang.String teeth35;
	private java.lang.String teeth36;
	private java.lang.String teeth37;
	private java.lang.String teeth38;
	private java.lang.String teeth51;
	private java.lang.String teeth52;
	private java.lang.String teeth53;
	private java.lang.String teeth54;
	private java.lang.String teeth55;
	private java.lang.String teeth61;
	private java.lang.String teeth62;
	private java.lang.String teeth63;
	private java.lang.String teeth64;
	private java.lang.String teeth65;
	private java.lang.String teeth81;
	private java.lang.String teeth82;
	private java.lang.String teeth83;
	private java.lang.String teeth84;
	private java.lang.String teeth85;
	private java.lang.String teeth71;
	private java.lang.String teeth72;
	private java.lang.String teeth73;
	private java.lang.String teeth74;
	private java.lang.String teeth75;
	private java.lang.String teeth18Value;
	private java.lang.String teeth17Value;
	private java.lang.String teeth16Value;
	private java.lang.String teeth15Value;
	private java.lang.String teeth14Value;
	private java.lang.String teeth13Value;
	private java.lang.String teeth12Value;
	private java.lang.String teeth11Value;
	private java.lang.String teeth21Value;
	private java.lang.String teeth22Value;
	private java.lang.String teeth23Value;
	private java.lang.String teeth24Value;
	private java.lang.String teeth25Value;
	private java.lang.String teeth26Value;
	private java.lang.String teeth27Value;
	private java.lang.String teeth28Value;
	private java.lang.String teeth48Value;
	private java.lang.String teeth47Value;
	private java.lang.String teeth46Value;
	private java.lang.String teeth45Value;
	private java.lang.String teeth44Value;
	private java.lang.String teeth43Value;
	private java.lang.String teeth42Value;
	private java.lang.String teeth41Value;
	private java.lang.String teeth31Value;
	private java.lang.String teeth32Value;
	private java.lang.String teeth33Value;
	private java.lang.String teeth34Value;
	private java.lang.String teeth35Value;
	private java.lang.String teeth36Value;
	private java.lang.String teeth37Value;
	private java.lang.String teeth38Value;
	private java.lang.String teeth51Value;
	private java.lang.String teeth52Value;
	private java.lang.String teeth53Value;
	private java.lang.String teeth54Value;
	private java.lang.String teeth55Value;
	private java.lang.String teeth61Value;
	private java.lang.String teeth62Value;
	private java.lang.String teeth63Value;
	private java.lang.String teeth64Value;
	private java.lang.String teeth65Value;
	private java.lang.String teeth81Value;
	private java.lang.String teeth82Value;
	private java.lang.String teeth83Value;
	private java.lang.String teeth84Value;
	private java.lang.String teeth85Value;
	private java.lang.String teeth71Value;
	private java.lang.String teeth72Value;
	private java.lang.String teeth73Value;
	private java.lang.String teeth74Value;
	private java.lang.String teeth75Value;
	private java.lang.String tongueInspection;
	private java.lang.String dorsum;
	private java.lang.String ventralSurface;
	private java.lang.String lateralBorder;
	private java.lang.String lateralBorderDetails;
	private java.lang.String localExaminationFindings;
	private java.lang.String caseSummary;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdOralMedicineDentalTissue> opdOralMedicineDentalTissues;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="oral_medicine_id"
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
	 * Return the value associated with the column: presenting_complaints
	 */
	public java.lang.String getPresentingComplaints () {
		return presentingComplaints;
	}

	/**
	 * Set the value related to the column: presenting_complaints
	 * @param presentingComplaints the presenting_complaints value
	 */
	public void setPresentingComplaints (java.lang.String presentingComplaints) {
		this.presentingComplaints = presentingComplaints;
	}



	/**
	 * Return the value associated with the column: history_presenting_complaint
	 */
	public java.lang.String getHistoryPresentingComplaint () {
		return historyPresentingComplaint;
	}

	/**
	 * Set the value related to the column: history_presenting_complaint
	 * @param historyPresentingComplaint the history_presenting_complaint value
	 */
	public void setHistoryPresentingComplaint (java.lang.String historyPresentingComplaint) {
		this.historyPresentingComplaint = historyPresentingComplaint;
	}



	/**
	 * Return the value associated with the column: past_medical_dental_history
	 */
	public java.lang.String getPastMedicalDentalHistory () {
		return pastMedicalDentalHistory;
	}

	/**
	 * Set the value related to the column: past_medical_dental_history
	 * @param pastMedicalDentalHistory the past_medical_dental_history value
	 */
	public void setPastMedicalDentalHistory (java.lang.String pastMedicalDentalHistory) {
		this.pastMedicalDentalHistory = pastMedicalDentalHistory;
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
	 * Return the value associated with the column: personal_social_history
	 */
	public java.lang.String getPersonalSocialHistory () {
		return personalSocialHistory;
	}

	/**
	 * Set the value related to the column: personal_social_history
	 * @param personalSocialHistory the personal_social_history value
	 */
	public void setPersonalSocialHistory (java.lang.String personalSocialHistory) {
		this.personalSocialHistory = personalSocialHistory;
	}



	/**
	 * Return the value associated with the column: dietary_habbits
	 */
	public java.lang.String getDietaryHabbits () {
		return dietaryHabbits;
	}

	/**
	 * Set the value related to the column: dietary_habbits
	 * @param dietaryHabbits the dietary_habbits value
	 */
	public void setDietaryHabbits (java.lang.String dietaryHabbits) {
		this.dietaryHabbits = dietaryHabbits;
	}



	/**
	 * Return the value associated with the column: brushing_habbits
	 */
	public java.lang.String getBrushingHabbits () {
		return brushingHabbits;
	}

	/**
	 * Set the value related to the column: brushing_habbits
	 * @param brushingHabbits the brushing_habbits value
	 */
	public void setBrushingHabbits (java.lang.String brushingHabbits) {
		this.brushingHabbits = brushingHabbits;
	}



	/**
	 * Return the value associated with the column: smoking_currently
	 */
	public java.lang.String getSmokingCurrently () {
		return smokingCurrently;
	}

	/**
	 * Set the value related to the column: smoking_currently
	 * @param smokingCurrently the smoking_currently value
	 */
	public void setSmokingCurrently (java.lang.String smokingCurrently) {
		this.smokingCurrently = smokingCurrently;
	}



	/**
	 * Return the value associated with the column: smokeless_currently
	 */
	public java.lang.String getSmokelessCurrently () {
		return smokelessCurrently;
	}

	/**
	 * Set the value related to the column: smokeless_currently
	 * @param smokelessCurrently the smokeless_currently value
	 */
	public void setSmokelessCurrently (java.lang.String smokelessCurrently) {
		this.smokelessCurrently = smokelessCurrently;
	}



	/**
	 * Return the value associated with the column: alcohol_currently
	 */
	public java.lang.String getAlcoholCurrently () {
		return alcoholCurrently;
	}

	/**
	 * Set the value related to the column: alcohol_currently
	 * @param alcoholCurrently the alcohol_currently value
	 */
	public void setAlcoholCurrently (java.lang.String alcoholCurrently) {
		this.alcoholCurrently = alcoholCurrently;
	}



	/**
	 * Return the value associated with the column: smoking_daily_past
	 */
	public java.lang.String getSmokingDailyPast () {
		return smokingDailyPast;
	}

	/**
	 * Set the value related to the column: smoking_daily_past
	 * @param smokingDailyPast the smoking_daily_past value
	 */
	public void setSmokingDailyPast (java.lang.String smokingDailyPast) {
		this.smokingDailyPast = smokingDailyPast;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_past
	 */
	public java.lang.String getSmokelessDailyPast () {
		return smokelessDailyPast;
	}

	/**
	 * Set the value related to the column: smokeless_daily_past
	 * @param smokelessDailyPast the smokeless_daily_past value
	 */
	public void setSmokelessDailyPast (java.lang.String smokelessDailyPast) {
		this.smokelessDailyPast = smokelessDailyPast;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_past
	 */
	public java.lang.String getAlcoholDailyPast () {
		return alcoholDailyPast;
	}

	/**
	 * Set the value related to the column: alcohol_daily_past
	 * @param alcoholDailyPast the alcohol_daily_past value
	 */
	public void setAlcoholDailyPast (java.lang.String alcoholDailyPast) {
		this.alcoholDailyPast = alcoholDailyPast;
	}



	/**
	 * Return the value associated with the column: smoking_frequency_past
	 */
	public java.lang.String getSmokingFrequencyPast () {
		return smokingFrequencyPast;
	}

	/**
	 * Set the value related to the column: smoking_frequency_past
	 * @param smokingFrequencyPast the smoking_frequency_past value
	 */
	public void setSmokingFrequencyPast (java.lang.String smokingFrequencyPast) {
		this.smokingFrequencyPast = smokingFrequencyPast;
	}



	/**
	 * Return the value associated with the column: smokeless_frequency_past
	 */
	public java.lang.String getSmokelessFrequencyPast () {
		return smokelessFrequencyPast;
	}

	/**
	 * Set the value related to the column: smokeless_frequency_past
	 * @param smokelessFrequencyPast the smokeless_frequency_past value
	 */
	public void setSmokelessFrequencyPast (java.lang.String smokelessFrequencyPast) {
		this.smokelessFrequencyPast = smokelessFrequencyPast;
	}



	/**
	 * Return the value associated with the column: alcohol_frequency_past
	 */
	public java.lang.String getAlcoholFrequencyPast () {
		return alcoholFrequencyPast;
	}

	/**
	 * Set the value related to the column: alcohol_frequency_past
	 * @param alcoholFrequencyPast the alcohol_frequency_past value
	 */
	public void setAlcoholFrequencyPast (java.lang.String alcoholFrequencyPast) {
		this.alcoholFrequencyPast = alcoholFrequencyPast;
	}



	/**
	 * Return the value associated with the column: smoking_daily_start_age
	 */
	public java.lang.Integer getSmokingDailyStartAge () {
		return smokingDailyStartAge;
	}

	/**
	 * Set the value related to the column: smoking_daily_start_age
	 * @param smokingDailyStartAge the smoking_daily_start_age value
	 */
	public void setSmokingDailyStartAge (java.lang.Integer smokingDailyStartAge) {
		this.smokingDailyStartAge = smokingDailyStartAge;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_start_age
	 */
	public java.lang.Integer getSmokelessDailyStartAge () {
		return smokelessDailyStartAge;
	}

	/**
	 * Set the value related to the column: smokeless_daily_start_age
	 * @param smokelessDailyStartAge the smokeless_daily_start_age value
	 */
	public void setSmokelessDailyStartAge (java.lang.Integer smokelessDailyStartAge) {
		this.smokelessDailyStartAge = smokelessDailyStartAge;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_start_age
	 */
	public java.lang.Integer getAlcoholDailyStartAge () {
		return alcoholDailyStartAge;
	}

	/**
	 * Set the value related to the column: alcohol_daily_start_age
	 * @param alcoholDailyStartAge the alcohol_daily_start_age value
	 */
	public void setAlcoholDailyStartAge (java.lang.Integer alcoholDailyStartAge) {
		this.alcoholDailyStartAge = alcoholDailyStartAge;
	}



	/**
	 * Return the value associated with the column: smoking_daily_start_year
	 */
	public java.lang.Integer getSmokingDailyStartYear () {
		return smokingDailyStartYear;
	}

	/**
	 * Set the value related to the column: smoking_daily_start_year
	 * @param smokingDailyStartYear the smoking_daily_start_year value
	 */
	public void setSmokingDailyStartYear (java.lang.Integer smokingDailyStartYear) {
		this.smokingDailyStartYear = smokingDailyStartYear;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_start_year
	 */
	public java.lang.Integer getSmokelessDailyStartYear () {
		return smokelessDailyStartYear;
	}

	/**
	 * Set the value related to the column: smokeless_daily_start_year
	 * @param smokelessDailyStartYear the smokeless_daily_start_year value
	 */
	public void setSmokelessDailyStartYear (java.lang.Integer smokelessDailyStartYear) {
		this.smokelessDailyStartYear = smokelessDailyStartYear;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_start_year
	 */
	public java.lang.Integer getAlcoholDailyStartYear () {
		return alcoholDailyStartYear;
	}

	/**
	 * Set the value related to the column: alcohol_daily_start_year
	 * @param alcoholDailyStartYear the alcohol_daily_start_year value
	 */
	public void setAlcoholDailyStartYear (java.lang.Integer alcoholDailyStartYear) {
		this.alcoholDailyStartYear = alcoholDailyStartYear;
	}



	/**
	 * Return the value associated with the column: smoking_daily_product
	 */
	public java.lang.Integer getSmokingDailyProduct () {
		return smokingDailyProduct;
	}

	/**
	 * Set the value related to the column: smoking_daily_product
	 * @param smokingDailyProduct the smoking_daily_product value
	 */
	public void setSmokingDailyProduct (java.lang.Integer smokingDailyProduct) {
		this.smokingDailyProduct = smokingDailyProduct;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_product
	 */
	public java.lang.Integer getSmokelessDailyProduct () {
		return smokelessDailyProduct;
	}

	/**
	 * Set the value related to the column: smokeless_daily_product
	 * @param smokelessDailyProduct the smokeless_daily_product value
	 */
	public void setSmokelessDailyProduct (java.lang.Integer smokelessDailyProduct) {
		this.smokelessDailyProduct = smokelessDailyProduct;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_product
	 */
	public java.lang.Integer getAlcoholDailyProduct () {
		return alcoholDailyProduct;
	}

	/**
	 * Set the value related to the column: alcohol_daily_product
	 * @param alcoholDailyProduct the alcohol_daily_product value
	 */
	public void setAlcoholDailyProduct (java.lang.Integer alcoholDailyProduct) {
		this.alcoholDailyProduct = alcoholDailyProduct;
	}



	/**
	 * Return the value associated with the column: smoking_after_wakeup
	 */
	public java.lang.Integer getSmokingAfterWakeup () {
		return smokingAfterWakeup;
	}

	/**
	 * Set the value related to the column: smoking_after_wakeup
	 * @param smokingAfterWakeup the smoking_after_wakeup value
	 */
	public void setSmokingAfterWakeup (java.lang.Integer smokingAfterWakeup) {
		this.smokingAfterWakeup = smokingAfterWakeup;
	}



	/**
	 * Return the value associated with the column: smokeless_after_wakeup
	 */
	public java.lang.Integer getSmokelessAfterWakeup () {
		return smokelessAfterWakeup;
	}

	/**
	 * Set the value related to the column: smokeless_after_wakeup
	 * @param smokelessAfterWakeup the smokeless_after_wakeup value
	 */
	public void setSmokelessAfterWakeup (java.lang.Integer smokelessAfterWakeup) {
		this.smokelessAfterWakeup = smokelessAfterWakeup;
	}



	/**
	 * Return the value associated with the column: alcohol_after_wakeup
	 */
	public java.lang.Integer getAlcoholAfterWakeup () {
		return alcoholAfterWakeup;
	}

	/**
	 * Set the value related to the column: alcohol_after_wakeup
	 * @param alcoholAfterWakeup the alcohol_after_wakeup value
	 */
	public void setAlcoholAfterWakeup (java.lang.Integer alcoholAfterWakeup) {
		this.alcoholAfterWakeup = alcoholAfterWakeup;
	}



	/**
	 * Return the value associated with the column: smoking_less_daily_start_age
	 */
	public java.lang.Integer getSmokingLessDailyStartAge () {
		return smokingLessDailyStartAge;
	}

	/**
	 * Set the value related to the column: smoking_less_daily_start_age
	 * @param smokingLessDailyStartAge the smoking_less_daily_start_age value
	 */
	public void setSmokingLessDailyStartAge (java.lang.Integer smokingLessDailyStartAge) {
		this.smokingLessDailyStartAge = smokingLessDailyStartAge;
	}



	/**
	 * Return the value associated with the column: smokeless_less_daily_start_age
	 */
	public java.lang.Integer getSmokelessLessDailyStartAge () {
		return smokelessLessDailyStartAge;
	}

	/**
	 * Set the value related to the column: smokeless_less_daily_start_age
	 * @param smokelessLessDailyStartAge the smokeless_less_daily_start_age value
	 */
	public void setSmokelessLessDailyStartAge (java.lang.Integer smokelessLessDailyStartAge) {
		this.smokelessLessDailyStartAge = smokelessLessDailyStartAge;
	}



	/**
	 * Return the value associated with the column: alcohol_less_daily_start_age
	 */
	public java.lang.Integer getAlcoholLessDailyStartAge () {
		return alcoholLessDailyStartAge;
	}

	/**
	 * Set the value related to the column: alcohol_less_daily_start_age
	 * @param alcoholLessDailyStartAge the alcohol_less_daily_start_age value
	 */
	public void setAlcoholLessDailyStartAge (java.lang.Integer alcoholLessDailyStartAge) {
		this.alcoholLessDailyStartAge = alcoholLessDailyStartAge;
	}



	/**
	 * Return the value associated with the column: smoking_less_daily_start_year
	 */
	public java.lang.Integer getSmokingLessDailyStartYear () {
		return smokingLessDailyStartYear;
	}

	/**
	 * Set the value related to the column: smoking_less_daily_start_year
	 * @param smokingLessDailyStartYear the smoking_less_daily_start_year value
	 */
	public void setSmokingLessDailyStartYear (java.lang.Integer smokingLessDailyStartYear) {
		this.smokingLessDailyStartYear = smokingLessDailyStartYear;
	}



	/**
	 * Return the value associated with the column: smokeless_less_daily_start_year
	 */
	public java.lang.Integer getSmokelessLessDailyStartYear () {
		return smokelessLessDailyStartYear;
	}

	/**
	 * Set the value related to the column: smokeless_less_daily_start_year
	 * @param smokelessLessDailyStartYear the smokeless_less_daily_start_year value
	 */
	public void setSmokelessLessDailyStartYear (java.lang.Integer smokelessLessDailyStartYear) {
		this.smokelessLessDailyStartYear = smokelessLessDailyStartYear;
	}



	/**
	 * Return the value associated with the column: alcohol_less_daily_start_year
	 */
	public java.lang.Integer getAlcoholLessDailyStartYear () {
		return alcoholLessDailyStartYear;
	}

	/**
	 * Set the value related to the column: alcohol_less_daily_start_year
	 * @param alcoholLessDailyStartYear the alcohol_less_daily_start_year value
	 */
	public void setAlcoholLessDailyStartYear (java.lang.Integer alcoholLessDailyStartYear) {
		this.alcoholLessDailyStartYear = alcoholLessDailyStartYear;
	}



	/**
	 * Return the value associated with the column: smoking_less_daily_product
	 */
	public java.lang.Integer getSmokingLessDailyProduct () {
		return smokingLessDailyProduct;
	}

	/**
	 * Set the value related to the column: smoking_less_daily_product
	 * @param smokingLessDailyProduct the smoking_less_daily_product value
	 */
	public void setSmokingLessDailyProduct (java.lang.Integer smokingLessDailyProduct) {
		this.smokingLessDailyProduct = smokingLessDailyProduct;
	}



	/**
	 * Return the value associated with the column: smokeless_less_daily_product
	 */
	public java.lang.Integer getSmokelessLessDailyProduct () {
		return smokelessLessDailyProduct;
	}

	/**
	 * Set the value related to the column: smokeless_less_daily_product
	 * @param smokelessLessDailyProduct the smokeless_less_daily_product value
	 */
	public void setSmokelessLessDailyProduct (java.lang.Integer smokelessLessDailyProduct) {
		this.smokelessLessDailyProduct = smokelessLessDailyProduct;
	}



	/**
	 * Return the value associated with the column: alcohol_less_daily_product
	 */
	public java.lang.Integer getAlcoholLessDailyProduct () {
		return alcoholLessDailyProduct;
	}

	/**
	 * Set the value related to the column: alcohol_less_daily_product
	 * @param alcoholLessDailyProduct the alcohol_less_daily_product value
	 */
	public void setAlcoholLessDailyProduct (java.lang.Integer alcoholLessDailyProduct) {
		this.alcoholLessDailyProduct = alcoholLessDailyProduct;
	}



	/**
	 * Return the value associated with the column: smoking_daily_start_age_former
	 */
	public java.lang.Integer getSmokingDailyStartAgeFormer () {
		return smokingDailyStartAgeFormer;
	}

	/**
	 * Set the value related to the column: smoking_daily_start_age_former
	 * @param smokingDailyStartAgeFormer the smoking_daily_start_age_former value
	 */
	public void setSmokingDailyStartAgeFormer (java.lang.Integer smokingDailyStartAgeFormer) {
		this.smokingDailyStartAgeFormer = smokingDailyStartAgeFormer;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_start_age_former
	 */
	public java.lang.Integer getSmokelessDailyStartAgeFormer () {
		return smokelessDailyStartAgeFormer;
	}

	/**
	 * Set the value related to the column: smokeless_daily_start_age_former
	 * @param smokelessDailyStartAgeFormer the smokeless_daily_start_age_former value
	 */
	public void setSmokelessDailyStartAgeFormer (java.lang.Integer smokelessDailyStartAgeFormer) {
		this.smokelessDailyStartAgeFormer = smokelessDailyStartAgeFormer;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_start_age_former
	 */
	public java.lang.Integer getAlcoholDailyStartAgeFormer () {
		return alcoholDailyStartAgeFormer;
	}

	/**
	 * Set the value related to the column: alcohol_daily_start_age_former
	 * @param alcoholDailyStartAgeFormer the alcohol_daily_start_age_former value
	 */
	public void setAlcoholDailyStartAgeFormer (java.lang.Integer alcoholDailyStartAgeFormer) {
		this.alcoholDailyStartAgeFormer = alcoholDailyStartAgeFormer;
	}



	/**
	 * Return the value associated with the column: smoking_daily_start_year_former
	 */
	public java.lang.Integer getSmokingDailyStartYearFormer () {
		return smokingDailyStartYearFormer;
	}

	/**
	 * Set the value related to the column: smoking_daily_start_year_former
	 * @param smokingDailyStartYearFormer the smoking_daily_start_year_former value
	 */
	public void setSmokingDailyStartYearFormer (java.lang.Integer smokingDailyStartYearFormer) {
		this.smokingDailyStartYearFormer = smokingDailyStartYearFormer;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_start_year_former
	 */
	public java.lang.Integer getSmokelessDailyStartYearFormer () {
		return smokelessDailyStartYearFormer;
	}

	/**
	 * Set the value related to the column: smokeless_daily_start_year_former
	 * @param smokelessDailyStartYearFormer the smokeless_daily_start_year_former value
	 */
	public void setSmokelessDailyStartYearFormer (java.lang.Integer smokelessDailyStartYearFormer) {
		this.smokelessDailyStartYearFormer = smokelessDailyStartYearFormer;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_start_year_former
	 */
	public java.lang.Integer getAlcoholDailyStartYearFormer () {
		return alcoholDailyStartYearFormer;
	}

	/**
	 * Set the value related to the column: alcohol_daily_start_year_former
	 * @param alcoholDailyStartYearFormer the alcohol_daily_start_year_former value
	 */
	public void setAlcoholDailyStartYearFormer (java.lang.Integer alcoholDailyStartYearFormer) {
		this.alcoholDailyStartYearFormer = alcoholDailyStartYearFormer;
	}



	/**
	 * Return the value associated with the column: smoking_stop_year_former
	 */
	public java.lang.Integer getSmokingStopYearFormer () {
		return smokingStopYearFormer;
	}

	/**
	 * Set the value related to the column: smoking_stop_year_former
	 * @param smokingStopYearFormer the smoking_stop_year_former value
	 */
	public void setSmokingStopYearFormer (java.lang.Integer smokingStopYearFormer) {
		this.smokingStopYearFormer = smokingStopYearFormer;
	}



	/**
	 * Return the value associated with the column: smokeless_stop_year_former
	 */
	public java.lang.Integer getSmokelessStopYearFormer () {
		return smokelessStopYearFormer;
	}

	/**
	 * Set the value related to the column: smokeless_stop_year_former
	 * @param smokelessStopYearFormer the smokeless_stop_year_former value
	 */
	public void setSmokelessStopYearFormer (java.lang.Integer smokelessStopYearFormer) {
		this.smokelessStopYearFormer = smokelessStopYearFormer;
	}



	/**
	 * Return the value associated with the column: alcohol_stop_year_former
	 */
	public java.lang.Integer getAlcoholStopYearFormer () {
		return alcoholStopYearFormer;
	}

	/**
	 * Set the value related to the column: alcohol_stop_year_former
	 * @param alcoholStopYearFormer the alcohol_stop_year_former value
	 */
	public void setAlcoholStopYearFormer (java.lang.Integer alcoholStopYearFormer) {
		this.alcoholStopYearFormer = alcoholStopYearFormer;
	}



	/**
	 * Return the value associated with the column: smoking_visited_doctor_fromer
	 */
	public java.lang.String getSmokingVisitedDoctorFromer () {
		return smokingVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: smoking_visited_doctor_fromer
	 * @param smokingVisitedDoctorFromer the smoking_visited_doctor_fromer value
	 */
	public void setSmokingVisitedDoctorFromer (java.lang.String smokingVisitedDoctorFromer) {
		this.smokingVisitedDoctorFromer = smokingVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_visited_doctor_fromer
	 */
	public java.lang.String getSmokelessVisitedDoctorFromer () {
		return smokelessVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: smokeless_visited_doctor_fromer
	 * @param smokelessVisitedDoctorFromer the smokeless_visited_doctor_fromer value
	 */
	public void setSmokelessVisitedDoctorFromer (java.lang.String smokelessVisitedDoctorFromer) {
		this.smokelessVisitedDoctorFromer = smokelessVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_visited_doctor_fromer
	 */
	public java.lang.String getAlcoholVisitedDoctorFromer () {
		return alcoholVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: alcohol_visited_doctor_fromer
	 * @param alcoholVisitedDoctorFromer the alcohol_visited_doctor_fromer value
	 */
	public void setAlcoholVisitedDoctorFromer (java.lang.String alcoholVisitedDoctorFromer) {
		this.alcoholVisitedDoctorFromer = alcoholVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: smoking_no_visited_doctor_fromer
	 */
	public java.lang.Integer getSmokingNoVisitedDoctorFromer () {
		return smokingNoVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: smoking_no_visited_doctor_fromer
	 * @param smokingNoVisitedDoctorFromer the smoking_no_visited_doctor_fromer value
	 */
	public void setSmokingNoVisitedDoctorFromer (java.lang.Integer smokingNoVisitedDoctorFromer) {
		this.smokingNoVisitedDoctorFromer = smokingNoVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_no_visited_doctor_fromer
	 */
	public java.lang.Integer getSmokelessNoVisitedDoctorFromer () {
		return smokelessNoVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: smokeless_no_visited_doctor_fromer
	 * @param smokelessNoVisitedDoctorFromer the smokeless_no_visited_doctor_fromer value
	 */
	public void setSmokelessNoVisitedDoctorFromer (java.lang.Integer smokelessNoVisitedDoctorFromer) {
		this.smokelessNoVisitedDoctorFromer = smokelessNoVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_no_visited_doctor_fromer
	 */
	public java.lang.Integer getAlcoholNoVisitedDoctorFromer () {
		return alcoholNoVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: alcohol_no_visited_doctor_fromer
	 * @param alcoholNoVisitedDoctorFromer the alcohol_no_visited_doctor_fromer value
	 */
	public void setAlcoholNoVisitedDoctorFromer (java.lang.Integer alcoholNoVisitedDoctorFromer) {
		this.alcoholNoVisitedDoctorFromer = alcoholNoVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: smoking_doctor_ask_fromer
	 */
	public java.lang.String getSmokingDoctorAskFromer () {
		return smokingDoctorAskFromer;
	}

	/**
	 * Set the value related to the column: smoking_doctor_ask_fromer
	 * @param smokingDoctorAskFromer the smoking_doctor_ask_fromer value
	 */
	public void setSmokingDoctorAskFromer (java.lang.String smokingDoctorAskFromer) {
		this.smokingDoctorAskFromer = smokingDoctorAskFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_doctor_ask_fromer
	 */
	public java.lang.String getSmokelessDoctorAskFromer () {
		return smokelessDoctorAskFromer;
	}

	/**
	 * Set the value related to the column: smokeless_doctor_ask_fromer
	 * @param smokelessDoctorAskFromer the smokeless_doctor_ask_fromer value
	 */
	public void setSmokelessDoctorAskFromer (java.lang.String smokelessDoctorAskFromer) {
		this.smokelessDoctorAskFromer = smokelessDoctorAskFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_doctor_ask_fromer
	 */
	public java.lang.String getAlcoholDoctorAskFromer () {
		return alcoholDoctorAskFromer;
	}

	/**
	 * Set the value related to the column: alcohol_doctor_ask_fromer
	 * @param alcoholDoctorAskFromer the alcohol_doctor_ask_fromer value
	 */
	public void setAlcoholDoctorAskFromer (java.lang.String alcoholDoctorAskFromer) {
		this.alcoholDoctorAskFromer = alcoholDoctorAskFromer;
	}



	/**
	 * Return the value associated with the column: smoking_quit_tobacoo_fromer
	 */
	public java.lang.String getSmokingQuitTobacooFromer () {
		return smokingQuitTobacooFromer;
	}

	/**
	 * Set the value related to the column: smoking_quit_tobacoo_fromer
	 * @param smokingQuitTobacooFromer the smoking_quit_tobacoo_fromer value
	 */
	public void setSmokingQuitTobacooFromer (java.lang.String smokingQuitTobacooFromer) {
		this.smokingQuitTobacooFromer = smokingQuitTobacooFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_quit_tobacoo_fromer
	 */
	public java.lang.String getSmokelessQuitTobacooFromer () {
		return smokelessQuitTobacooFromer;
	}

	/**
	 * Set the value related to the column: smokeless_quit_tobacoo_fromer
	 * @param smokelessQuitTobacooFromer the smokeless_quit_tobacoo_fromer value
	 */
	public void setSmokelessQuitTobacooFromer (java.lang.String smokelessQuitTobacooFromer) {
		this.smokelessQuitTobacooFromer = smokelessQuitTobacooFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_quit_tobacoo_fromer
	 */
	public java.lang.String getAlcoholQuitTobacooFromer () {
		return alcoholQuitTobacooFromer;
	}

	/**
	 * Set the value related to the column: alcohol_quit_tobacoo_fromer
	 * @param alcoholQuitTobacooFromer the alcohol_quit_tobacoo_fromer value
	 */
	public void setAlcoholQuitTobacooFromer (java.lang.String alcoholQuitTobacooFromer) {
		this.alcoholQuitTobacooFromer = alcoholQuitTobacooFromer;
	}



	/**
	 * Return the value associated with the column: smoking_quit_any_fromer
	 */
	public java.lang.String getSmokingQuitAnyFromer () {
		return smokingQuitAnyFromer;
	}

	/**
	 * Set the value related to the column: smoking_quit_any_fromer
	 * @param smokingQuitAnyFromer the smoking_quit_any_fromer value
	 */
	public void setSmokingQuitAnyFromer (java.lang.String smokingQuitAnyFromer) {
		this.smokingQuitAnyFromer = smokingQuitAnyFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_quit_any_fromer
	 */
	public java.lang.String getSmokelessQuitAnyFromer () {
		return smokelessQuitAnyFromer;
	}

	/**
	 * Set the value related to the column: smokeless_quit_any_fromer
	 * @param smokelessQuitAnyFromer the smokeless_quit_any_fromer value
	 */
	public void setSmokelessQuitAnyFromer (java.lang.String smokelessQuitAnyFromer) {
		this.smokelessQuitAnyFromer = smokelessQuitAnyFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_quit_any_fromer
	 */
	public java.lang.String getAlcoholQuitAnyFromer () {
		return alcoholQuitAnyFromer;
	}

	/**
	 * Set the value related to the column: alcohol_quit_any_fromer
	 * @param alcoholQuitAnyFromer the alcohol_quit_any_fromer value
	 */
	public void setAlcoholQuitAnyFromer (java.lang.String alcoholQuitAnyFromer) {
		this.alcoholQuitAnyFromer = alcoholQuitAnyFromer;
	}



	/**
	 * Return the value associated with the column: smoking_try_stop
	 */
	public java.lang.String getSmokingTryStop () {
		return smokingTryStop;
	}

	/**
	 * Set the value related to the column: smoking_try_stop
	 * @param smokingTryStop the smoking_try_stop value
	 */
	public void setSmokingTryStop (java.lang.String smokingTryStop) {
		this.smokingTryStop = smokingTryStop;
	}



	/**
	 * Return the value associated with the column: smokeless_try_stop
	 */
	public java.lang.String getSmokelessTryStop () {
		return smokelessTryStop;
	}

	/**
	 * Set the value related to the column: smokeless_try_stop
	 * @param smokelessTryStop the smokeless_try_stop value
	 */
	public void setSmokelessTryStop (java.lang.String smokelessTryStop) {
		this.smokelessTryStop = smokelessTryStop;
	}



	/**
	 * Return the value associated with the column: alcohol_try_stop
	 */
	public java.lang.String getAlcoholTryStop () {
		return alcoholTryStop;
	}

	/**
	 * Set the value related to the column: alcohol_try_stop
	 * @param alcoholTryStop the alcohol_try_stop value
	 */
	public void setAlcoholTryStop (java.lang.String alcoholTryStop) {
		this.alcoholTryStop = alcoholTryStop;
	}



	/**
	 * Return the value associated with the column: smoking_quit_period
	 */
	public java.lang.Integer getSmokingQuitPeriod () {
		return smokingQuitPeriod;
	}

	/**
	 * Set the value related to the column: smoking_quit_period
	 * @param smokingQuitPeriod the smoking_quit_period value
	 */
	public void setSmokingQuitPeriod (java.lang.Integer smokingQuitPeriod) {
		this.smokingQuitPeriod = smokingQuitPeriod;
	}



	/**
	 * Return the value associated with the column: smokeless_quit_period
	 */
	public java.lang.Integer getSmokelessQuitPeriod () {
		return smokelessQuitPeriod;
	}

	/**
	 * Set the value related to the column: smokeless_quit_period
	 * @param smokelessQuitPeriod the smokeless_quit_period value
	 */
	public void setSmokelessQuitPeriod (java.lang.Integer smokelessQuitPeriod) {
		this.smokelessQuitPeriod = smokelessQuitPeriod;
	}



	/**
	 * Return the value associated with the column: alcohol_quit_period
	 */
	public java.lang.Integer getAlcoholQuitPeriod () {
		return alcoholQuitPeriod;
	}

	/**
	 * Set the value related to the column: alcohol_quit_period
	 * @param alcoholQuitPeriod the alcohol_quit_period value
	 */
	public void setAlcoholQuitPeriod (java.lang.Integer alcoholQuitPeriod) {
		this.alcoholQuitPeriod = alcoholQuitPeriod;
	}



	/**
	 * Return the value associated with the column: smoking_try_stop_using
	 */
	public java.lang.String getSmokingTryStopUsing () {
		return smokingTryStopUsing;
	}

	/**
	 * Set the value related to the column: smoking_try_stop_using
	 * @param smokingTryStopUsing the smoking_try_stop_using value
	 */
	public void setSmokingTryStopUsing (java.lang.String smokingTryStopUsing) {
		this.smokingTryStopUsing = smokingTryStopUsing;
	}



	/**
	 * Return the value associated with the column: smokeless_try_stop_using
	 */
	public java.lang.String getSmokelessTryStopUsing () {
		return smokelessTryStopUsing;
	}

	/**
	 * Set the value related to the column: smokeless_try_stop_using
	 * @param smokelessTryStopUsing the smokeless_try_stop_using value
	 */
	public void setSmokelessTryStopUsing (java.lang.String smokelessTryStopUsing) {
		this.smokelessTryStopUsing = smokelessTryStopUsing;
	}



	/**
	 * Return the value associated with the column: alcohol_try_stop_using
	 */
	public java.lang.String getAlcoholTryStopUsing () {
		return alcoholTryStopUsing;
	}

	/**
	 * Set the value related to the column: alcohol_try_stop_using
	 * @param alcoholTryStopUsing the alcohol_try_stop_using value
	 */
	public void setAlcoholTryStopUsing (java.lang.String alcoholTryStopUsing) {
		this.alcoholTryStopUsing = alcoholTryStopUsing;
	}



	/**
	 * Return the value associated with the column: smoking_try_quitting
	 */
	public java.lang.String getSmokingTryQuitting () {
		return smokingTryQuitting;
	}

	/**
	 * Set the value related to the column: smoking_try_quitting
	 * @param smokingTryQuitting the smoking_try_quitting value
	 */
	public void setSmokingTryQuitting (java.lang.String smokingTryQuitting) {
		this.smokingTryQuitting = smokingTryQuitting;
	}



	/**
	 * Return the value associated with the column: smokeless_try_quitting
	 */
	public java.lang.String getSmokelessTryQuitting () {
		return smokelessTryQuitting;
	}

	/**
	 * Set the value related to the column: smokeless_try_quitting
	 * @param smokelessTryQuitting the smokeless_try_quitting value
	 */
	public void setSmokelessTryQuitting (java.lang.String smokelessTryQuitting) {
		this.smokelessTryQuitting = smokelessTryQuitting;
	}



	/**
	 * Return the value associated with the column: alcohol_try_quitting
	 */
	public java.lang.String getAlcoholTryQuitting () {
		return alcoholTryQuitting;
	}

	/**
	 * Set the value related to the column: alcohol_try_quitting
	 * @param alcoholTryQuitting the alcohol_try_quitting value
	 */
	public void setAlcoholTryQuitting (java.lang.String alcoholTryQuitting) {
		this.alcoholTryQuitting = alcoholTryQuitting;
	}



	/**
	 * Return the value associated with the column: appetite
	 */
	public java.lang.String getAppetite () {
		return appetite;
	}

	/**
	 * Set the value related to the column: appetite
	 * @param appetite the appetite value
	 */
	public void setAppetite (java.lang.String appetite) {
		this.appetite = appetite;
	}



	/**
	 * Return the value associated with the column: weight_loss_gain
	 */
	public java.lang.Integer getWeightLossGain () {
		return weightLossGain;
	}

	/**
	 * Set the value related to the column: weight_loss_gain
	 * @param weightLossGain the weight_loss_gain value
	 */
	public void setWeightLossGain (java.lang.Integer weightLossGain) {
		this.weightLossGain = weightLossGain;
	}



	/**
	 * Return the value associated with the column: indigestion
	 */
	public java.lang.String getIndigestion () {
		return indigestion;
	}

	/**
	 * Set the value related to the column: indigestion
	 * @param indigestion the indigestion value
	 */
	public void setIndigestion (java.lang.String indigestion) {
		this.indigestion = indigestion;
	}



	/**
	 * Return the value associated with the column: bowels
	 */
	public java.lang.String getBowels () {
		return bowels;
	}

	/**
	 * Set the value related to the column: bowels
	 * @param bowels the bowels value
	 */
	public void setBowels (java.lang.String bowels) {
		this.bowels = bowels;
	}



	/**
	 * Return the value associated with the column: chest_pain
	 */
	public java.lang.String getChestPain () {
		return chestPain;
	}

	/**
	 * Set the value related to the column: chest_pain
	 * @param chestPain the chest_pain value
	 */
	public void setChestPain (java.lang.String chestPain) {
		this.chestPain = chestPain;
	}



	/**
	 * Return the value associated with the column: angina
	 */
	public java.lang.String getAngina () {
		return angina;
	}

	/**
	 * Set the value related to the column: angina
	 * @param angina the angina value
	 */
	public void setAngina (java.lang.String angina) {
		this.angina = angina;
	}



	/**
	 * Return the value associated with the column: dyspnoea
	 */
	public java.lang.String getDyspnoea () {
		return dyspnoea;
	}

	/**
	 * Set the value related to the column: dyspnoea
	 * @param dyspnoea the dyspnoea value
	 */
	public void setDyspnoea (java.lang.String dyspnoea) {
		this.dyspnoea = dyspnoea;
	}



	/**
	 * Return the value associated with the column: orthopnoea
	 */
	public java.lang.String getOrthopnoea () {
		return orthopnoea;
	}

	/**
	 * Set the value related to the column: orthopnoea
	 * @param orthopnoea the orthopnoea value
	 */
	public void setOrthopnoea (java.lang.String orthopnoea) {
		this.orthopnoea = orthopnoea;
	}



	/**
	 * Return the value associated with the column: oedema_feet
	 */
	public java.lang.String getOedemaFeet () {
		return oedemaFeet;
	}

	/**
	 * Set the value related to the column: oedema_feet
	 * @param oedemaFeet the oedema_feet value
	 */
	public void setOedemaFeet (java.lang.String oedemaFeet) {
		this.oedemaFeet = oedemaFeet;
	}



	/**
	 * Return the value associated with the column: cough
	 */
	public java.lang.String getCough () {
		return cough;
	}

	/**
	 * Set the value related to the column: cough
	 * @param cough the cough value
	 */
	public void setCough (java.lang.String cough) {
		this.cough = cough;
	}



	/**
	 * Return the value associated with the column: haemoptysis
	 */
	public java.lang.String getHaemoptysis () {
		return haemoptysis;
	}

	/**
	 * Set the value related to the column: haemoptysis
	 * @param haemoptysis the haemoptysis value
	 */
	public void setHaemoptysis (java.lang.String haemoptysis) {
		this.haemoptysis = haemoptysis;
	}



	/**
	 * Return the value associated with the column: sputum
	 */
	public java.lang.String getSputum () {
		return sputum;
	}

	/**
	 * Set the value related to the column: sputum
	 * @param sputum the sputum value
	 */
	public void setSputum (java.lang.String sputum) {
		this.sputum = sputum;
	}



	/**
	 * Return the value associated with the column: sputum_colour
	 */
	public java.lang.String getSputumColour () {
		return sputumColour;
	}

	/**
	 * Set the value related to the column: sputum_colour
	 * @param sputumColour the sputum_colour value
	 */
	public void setSputumColour (java.lang.String sputumColour) {
		this.sputumColour = sputumColour;
	}



	/**
	 * Return the value associated with the column: sputum_quantity
	 */
	public java.lang.String getSputumQuantity () {
		return sputumQuantity;
	}

	/**
	 * Set the value related to the column: sputum_quantity
	 * @param sputumQuantity the sputum_quantity value
	 */
	public void setSputumQuantity (java.lang.String sputumQuantity) {
		this.sputumQuantity = sputumQuantity;
	}



	/**
	 * Return the value associated with the column: sputum_smell
	 */
	public java.lang.String getSputumSmell () {
		return sputumSmell;
	}

	/**
	 * Set the value related to the column: sputum_smell
	 * @param sputumSmell the sputum_smell value
	 */
	public void setSputumSmell (java.lang.String sputumSmell) {
		this.sputumSmell = sputumSmell;
	}



	/**
	 * Return the value associated with the column: vision
	 */
	public java.lang.String getVision () {
		return vision;
	}

	/**
	 * Set the value related to the column: vision
	 * @param vision the vision value
	 */
	public void setVision (java.lang.String vision) {
		this.vision = vision;
	}



	/**
	 * Return the value associated with the column: hearing
	 */
	public java.lang.String getHearing () {
		return hearing;
	}

	/**
	 * Set the value related to the column: hearing
	 * @param hearing the hearing value
	 */
	public void setHearing (java.lang.String hearing) {
		this.hearing = hearing;
	}



	/**
	 * Return the value associated with the column: micturition
	 */
	public java.lang.String getMicturition () {
		return micturition;
	}

	/**
	 * Set the value related to the column: micturition
	 * @param micturition the micturition value
	 */
	public void setMicturition (java.lang.String micturition) {
		this.micturition = micturition;
	}



	/**
	 * Return the value associated with the column: micturition_frequency
	 */
	public java.lang.Integer getMicturitionFrequency () {
		return micturitionFrequency;
	}

	/**
	 * Set the value related to the column: micturition_frequency
	 * @param micturitionFrequency the micturition_frequency value
	 */
	public void setMicturitionFrequency (java.lang.Integer micturitionFrequency) {
		this.micturitionFrequency = micturitionFrequency;
	}



	/**
	 * Return the value associated with the column: dysuria
	 */
	public java.lang.String getDysuria () {
		return dysuria;
	}

	/**
	 * Set the value related to the column: dysuria
	 * @param dysuria the dysuria value
	 */
	public void setDysuria (java.lang.String dysuria) {
		this.dysuria = dysuria;
	}



	/**
	 * Return the value associated with the column: haematuria
	 */
	public java.lang.String getHaematuria () {
		return haematuria;
	}

	/**
	 * Set the value related to the column: haematuria
	 * @param haematuria the haematuria value
	 */
	public void setHaematuria (java.lang.String haematuria) {
		this.haematuria = haematuria;
	}



	/**
	 * Return the value associated with the column: nocturia
	 */
	public java.lang.String getNocturia () {
		return nocturia;
	}

	/**
	 * Set the value related to the column: nocturia
	 * @param nocturia the nocturia value
	 */
	public void setNocturia (java.lang.String nocturia) {
		this.nocturia = nocturia;
	}



	/**
	 * Return the value associated with the column: period
	 */
	public java.lang.Integer getPeriod () {
		return period;
	}

	/**
	 * Set the value related to the column: period
	 * @param period the period value
	 */
	public void setPeriod (java.lang.Integer period) {
		this.period = period;
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
	 * Return the value associated with the column: flow_days
	 */
	public java.lang.Integer getFlowDays () {
		return flowDays;
	}

	/**
	 * Set the value related to the column: flow_days
	 * @param flowDays the flow_days value
	 */
	public void setFlowDays (java.lang.Integer flowDays) {
		this.flowDays = flowDays;
	}



	/**
	 * Return the value associated with the column: menopause
	 */
	public java.lang.Integer getMenopause () {
		return menopause;
	}

	/**
	 * Set the value related to the column: menopause
	 * @param menopause the menopause value
	 */
	public void setMenopause (java.lang.Integer menopause) {
		this.menopause = menopause;
	}



	/**
	 * Return the value associated with the column: hoarseness
	 */
	public java.lang.String getHoarseness () {
		return hoarseness;
	}

	/**
	 * Set the value related to the column: hoarseness
	 * @param hoarseness the hoarseness value
	 */
	public void setHoarseness (java.lang.String hoarseness) {
		this.hoarseness = hoarseness;
	}



	/**
	 * Return the value associated with the column: sore_throat
	 */
	public java.lang.String getSoreThroat () {
		return soreThroat;
	}

	/**
	 * Set the value related to the column: sore_throat
	 * @param soreThroat the sore_throat value
	 */
	public void setSoreThroat (java.lang.String soreThroat) {
		this.soreThroat = soreThroat;
	}



	/**
	 * Return the value associated with the column: epistaxis
	 */
	public java.lang.String getEpistaxis () {
		return epistaxis;
	}

	/**
	 * Set the value related to the column: epistaxis
	 * @param epistaxis the epistaxis value
	 */
	public void setEpistaxis (java.lang.String epistaxis) {
		this.epistaxis = epistaxis;
	}



	/**
	 * Return the value associated with the column: frequent_colds
	 */
	public java.lang.String getFrequentColds () {
		return frequentColds;
	}

	/**
	 * Set the value related to the column: frequent_colds
	 * @param frequentColds the frequent_colds value
	 */
	public void setFrequentColds (java.lang.String frequentColds) {
		this.frequentColds = frequentColds;
	}



	/**
	 * Return the value associated with the column: headache
	 */
	public java.lang.String getHeadache () {
		return headache;
	}

	/**
	 * Set the value related to the column: headache
	 * @param headache the headache value
	 */
	public void setHeadache (java.lang.String headache) {
		this.headache = headache;
	}



	/**
	 * Return the value associated with the column: vomiting
	 */
	public java.lang.String getVomiting () {
		return vomiting;
	}

	/**
	 * Set the value related to the column: vomiting
	 * @param vomiting the vomiting value
	 */
	public void setVomiting (java.lang.String vomiting) {
		this.vomiting = vomiting;
	}



	/**
	 * Return the value associated with the column: fits
	 */
	public java.lang.String getFits () {
		return fits;
	}

	/**
	 * Set the value related to the column: fits
	 * @param fits the fits value
	 */
	public void setFits (java.lang.String fits) {
		this.fits = fits;
	}



	/**
	 * Return the value associated with the column: gen_developmental
	 */
	public java.lang.String getGenDevelopmental () {
		return genDevelopmental;
	}

	/**
	 * Set the value related to the column: gen_developmental
	 * @param genDevelopmental the gen_developmental value
	 */
	public void setGenDevelopmental (java.lang.String genDevelopmental) {
		this.genDevelopmental = genDevelopmental;
	}



	/**
	 * Return the value associated with the column: gen_nutritional
	 */
	public java.lang.String getGenNutritional () {
		return genNutritional;
	}

	/**
	 * Set the value related to the column: gen_nutritional
	 * @param genNutritional the gen_nutritional value
	 */
	public void setGenNutritional (java.lang.String genNutritional) {
		this.genNutritional = genNutritional;
	}



	/**
	 * Return the value associated with the column: gen_head
	 */
	public java.lang.String getGenHead () {
		return genHead;
	}

	/**
	 * Set the value related to the column: gen_head
	 * @param genHead the gen_head value
	 */
	public void setGenHead (java.lang.String genHead) {
		this.genHead = genHead;
	}



	/**
	 * Return the value associated with the column: gen_skull
	 */
	public java.lang.String getGenSkull () {
		return genSkull;
	}

	/**
	 * Set the value related to the column: gen_skull
	 * @param genSkull the gen_skull value
	 */
	public void setGenSkull (java.lang.String genSkull) {
		this.genSkull = genSkull;
	}



	/**
	 * Return the value associated with the column: gen_eyes
	 */
	public java.lang.String getGenEyes () {
		return genEyes;
	}

	/**
	 * Set the value related to the column: gen_eyes
	 * @param genEyes the gen_eyes value
	 */
	public void setGenEyes (java.lang.String genEyes) {
		this.genEyes = genEyes;
	}



	/**
	 * Return the value associated with the column: gen_ears
	 */
	public java.lang.String getGenEars () {
		return genEars;
	}

	/**
	 * Set the value related to the column: gen_ears
	 * @param genEars the gen_ears value
	 */
	public void setGenEars (java.lang.String genEars) {
		this.genEars = genEars;
	}



	/**
	 * Return the value associated with the column: gen_nose
	 */
	public java.lang.String getGenNose () {
		return genNose;
	}

	/**
	 * Set the value related to the column: gen_nose
	 * @param genNose the gen_nose value
	 */
	public void setGenNose (java.lang.String genNose) {
		this.genNose = genNose;
	}



	/**
	 * Return the value associated with the column: gen_skin
	 */
	public java.lang.String getGenSkin () {
		return genSkin;
	}

	/**
	 * Set the value related to the column: gen_skin
	 * @param genSkin the gen_skin value
	 */
	public void setGenSkin (java.lang.String genSkin) {
		this.genSkin = genSkin;
	}



	/**
	 * Return the value associated with the column: gen_hair
	 */
	public java.lang.String getGenHair () {
		return genHair;
	}

	/**
	 * Set the value related to the column: gen_hair
	 * @param genHair the gen_hair value
	 */
	public void setGenHair (java.lang.String genHair) {
		this.genHair = genHair;
	}



	/**
	 * Return the value associated with the column: gen_nails
	 */
	public java.lang.String getGenNails () {
		return genNails;
	}

	/**
	 * Set the value related to the column: gen_nails
	 * @param genNails the gen_nails value
	 */
	public void setGenNails (java.lang.String genNails) {
		this.genNails = genNails;
	}



	/**
	 * Return the value associated with the column: gen_lymph_nodes
	 */
	public java.lang.String getGenLymphNodes () {
		return genLymphNodes;
	}

	/**
	 * Set the value related to the column: gen_lymph_nodes
	 * @param genLymphNodes the gen_lymph_nodes value
	 */
	public void setGenLymphNodes (java.lang.String genLymphNodes) {
		this.genLymphNodes = genLymphNodes;
	}



	/**
	 * Return the value associated with the column: oral_head
	 */
	public java.lang.String getOralHead () {
		return oralHead;
	}

	/**
	 * Set the value related to the column: oral_head
	 * @param oralHead the oral_head value
	 */
	public void setOralHead (java.lang.String oralHead) {
		this.oralHead = oralHead;
	}



	/**
	 * Return the value associated with the column: oral_facial_form
	 */
	public java.lang.String getOralFacialForm () {
		return oralFacialForm;
	}

	/**
	 * Set the value related to the column: oral_facial_form
	 * @param oralFacialForm the oral_facial_form value
	 */
	public void setOralFacialForm (java.lang.String oralFacialForm) {
		this.oralFacialForm = oralFacialForm;
	}



	/**
	 * Return the value associated with the column: oral_hair
	 */
	public java.lang.String getOralHair () {
		return oralHair;
	}

	/**
	 * Set the value related to the column: oral_hair
	 * @param oralHair the oral_hair value
	 */
	public void setOralHair (java.lang.String oralHair) {
		this.oralHair = oralHair;
	}



	/**
	 * Return the value associated with the column: oral_skin
	 */
	public java.lang.String getOralSkin () {
		return oralSkin;
	}

	/**
	 * Set the value related to the column: oral_skin
	 * @param oralSkin the oral_skin value
	 */
	public void setOralSkin (java.lang.String oralSkin) {
		this.oralSkin = oralSkin;
	}



	/**
	 * Return the value associated with the column: oral_eyes
	 */
	public java.lang.String getOralEyes () {
		return oralEyes;
	}

	/**
	 * Set the value related to the column: oral_eyes
	 * @param oralEyes the oral_eyes value
	 */
	public void setOralEyes (java.lang.String oralEyes) {
		this.oralEyes = oralEyes;
	}



	/**
	 * Return the value associated with the column: oral_ear
	 */
	public java.lang.String getOralEar () {
		return oralEar;
	}

	/**
	 * Set the value related to the column: oral_ear
	 * @param oralEar the oral_ear value
	 */
	public void setOralEar (java.lang.String oralEar) {
		this.oralEar = oralEar;
	}



	/**
	 * Return the value associated with the column: oral_nose
	 */
	public java.lang.String getOralNose () {
		return oralNose;
	}

	/**
	 * Set the value related to the column: oral_nose
	 * @param oralNose the oral_nose value
	 */
	public void setOralNose (java.lang.String oralNose) {
		this.oralNose = oralNose;
	}



	/**
	 * Return the value associated with the column: oral_throat
	 */
	public java.lang.String getOralThroat () {
		return oralThroat;
	}

	/**
	 * Set the value related to the column: oral_throat
	 * @param oralThroat the oral_throat value
	 */
	public void setOralThroat (java.lang.String oralThroat) {
		this.oralThroat = oralThroat;
	}



	/**
	 * Return the value associated with the column: oral_salivary_glands
	 */
	public java.lang.String getOralSalivaryGlands () {
		return oralSalivaryGlands;
	}

	/**
	 * Set the value related to the column: oral_salivary_glands
	 * @param oralSalivaryGlands the oral_salivary_glands value
	 */
	public void setOralSalivaryGlands (java.lang.String oralSalivaryGlands) {
		this.oralSalivaryGlands = oralSalivaryGlands;
	}



	/**
	 * Return the value associated with the column: oral_salivary_glands_palpable
	 */
	public java.lang.String getOralSalivaryGlandsPalpable () {
		return oralSalivaryGlandsPalpable;
	}

	/**
	 * Set the value related to the column: oral_salivary_glands_palpable
	 * @param oralSalivaryGlandsPalpable the oral_salivary_glands_palpable value
	 */
	public void setOralSalivaryGlandsPalpable (java.lang.String oralSalivaryGlandsPalpable) {
		this.oralSalivaryGlandsPalpable = oralSalivaryGlandsPalpable;
	}



	/**
	 * Return the value associated with the column: oral_cranial_nerves_examination
	 */
	public java.lang.String getOralCranialNervesExamination () {
		return oralCranialNervesExamination;
	}

	/**
	 * Set the value related to the column: oral_cranial_nerves_examination
	 * @param oralCranialNervesExamination the oral_cranial_nerves_examination value
	 */
	public void setOralCranialNervesExamination (java.lang.String oralCranialNervesExamination) {
		this.oralCranialNervesExamination = oralCranialNervesExamination;
	}



	/**
	 * Return the value associated with the column: oral_neck
	 */
	public java.lang.String getOralNeck () {
		return oralNeck;
	}

	/**
	 * Set the value related to the column: oral_neck
	 * @param oralNeck the oral_neck value
	 */
	public void setOralNeck (java.lang.String oralNeck) {
		this.oralNeck = oralNeck;
	}



	/**
	 * Return the value associated with the column: oral_tmj
	 */
	public java.lang.String getOralTmj () {
		return oralTmj;
	}

	/**
	 * Set the value related to the column: oral_tmj
	 * @param oralTmj the oral_tmj value
	 */
	public void setOralTmj (java.lang.String oralTmj) {
		this.oralTmj = oralTmj;
	}



	/**
	 * Return the value associated with the column: submental_submandibular
	 */
	public java.lang.String getSubmentalSubmandibular () {
		return submentalSubmandibular;
	}

	/**
	 * Set the value related to the column: submental_submandibular
	 * @param submentalSubmandibular the submental_submandibular value
	 */
	public void setSubmentalSubmandibular (java.lang.String submentalSubmandibular) {
		this.submentalSubmandibular = submentalSubmandibular;
	}



	/**
	 * Return the value associated with the column: high_jugular
	 */
	public java.lang.String getHighJugular () {
		return highJugular;
	}

	/**
	 * Set the value related to the column: high_jugular
	 * @param highJugular the high_jugular value
	 */
	public void setHighJugular (java.lang.String highJugular) {
		this.highJugular = highJugular;
	}



	/**
	 * Return the value associated with the column: mid_jugular
	 */
	public java.lang.String getMidJugular () {
		return midJugular;
	}

	/**
	 * Set the value related to the column: mid_jugular
	 * @param midJugular the mid_jugular value
	 */
	public void setMidJugular (java.lang.String midJugular) {
		this.midJugular = midJugular;
	}



	/**
	 * Return the value associated with the column: low_jugular
	 */
	public java.lang.String getLowJugular () {
		return lowJugular;
	}

	/**
	 * Set the value related to the column: low_jugular
	 * @param lowJugular the low_jugular value
	 */
	public void setLowJugular (java.lang.String lowJugular) {
		this.lowJugular = lowJugular;
	}



	/**
	 * Return the value associated with the column: posterior_jugular
	 */
	public java.lang.String getPosteriorJugular () {
		return posteriorJugular;
	}

	/**
	 * Set the value related to the column: posterior_jugular
	 * @param posteriorJugular the posterior_jugular value
	 */
	public void setPosteriorJugular (java.lang.String posteriorJugular) {
		this.posteriorJugular = posteriorJugular;
	}



	/**
	 * Return the value associated with the column: tracheo_oesophageal
	 */
	public java.lang.String getTracheoOesophageal () {
		return tracheoOesophageal;
	}

	/**
	 * Set the value related to the column: tracheo_oesophageal
	 * @param tracheoOesophageal the tracheo_oesophageal value
	 */
	public void setTracheoOesophageal (java.lang.String tracheoOesophageal) {
		this.tracheoOesophageal = tracheoOesophageal;
	}



	/**
	 * Return the value associated with the column: superior_mediastinal
	 */
	public java.lang.String getSuperiorMediastinal () {
		return superiorMediastinal;
	}

	/**
	 * Set the value related to the column: superior_mediastinal
	 * @param superiorMediastinal the superior_mediastinal value
	 */
	public void setSuperiorMediastinal (java.lang.String superiorMediastinal) {
		this.superiorMediastinal = superiorMediastinal;
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
	 * Return the value associated with the column: oral_hygiene_status
	 */
	public java.lang.String getOralHygieneStatus () {
		return oralHygieneStatus;
	}

	/**
	 * Set the value related to the column: oral_hygiene_status
	 * @param oralHygieneStatus the oral_hygiene_status value
	 */
	public void setOralHygieneStatus (java.lang.String oralHygieneStatus) {
		this.oralHygieneStatus = oralHygieneStatus;
	}



	/**
	 * Return the value associated with the column: dentition_status
	 */
	public java.lang.String getDentitionStatus () {
		return dentitionStatus;
	}

	/**
	 * Set the value related to the column: dentition_status
	 * @param dentitionStatus the dentition_status value
	 */
	public void setDentitionStatus (java.lang.String dentitionStatus) {
		this.dentitionStatus = dentitionStatus;
	}



	/**
	 * Return the value associated with the column: teeth_18
	 */
	public java.lang.String getTeeth18 () {
		return teeth18;
	}

	/**
	 * Set the value related to the column: teeth_18
	 * @param teeth18 the teeth_18 value
	 */
	public void setTeeth18 (java.lang.String teeth18) {
		this.teeth18 = teeth18;
	}



	/**
	 * Return the value associated with the column: teeth_17
	 */
	public java.lang.String getTeeth17 () {
		return teeth17;
	}

	/**
	 * Set the value related to the column: teeth_17
	 * @param teeth17 the teeth_17 value
	 */
	public void setTeeth17 (java.lang.String teeth17) {
		this.teeth17 = teeth17;
	}



	/**
	 * Return the value associated with the column: teeth_16
	 */
	public java.lang.String getTeeth16 () {
		return teeth16;
	}

	/**
	 * Set the value related to the column: teeth_16
	 * @param teeth16 the teeth_16 value
	 */
	public void setTeeth16 (java.lang.String teeth16) {
		this.teeth16 = teeth16;
	}



	/**
	 * Return the value associated with the column: teeth_15
	 */
	public java.lang.String getTeeth15 () {
		return teeth15;
	}

	/**
	 * Set the value related to the column: teeth_15
	 * @param teeth15 the teeth_15 value
	 */
	public void setTeeth15 (java.lang.String teeth15) {
		this.teeth15 = teeth15;
	}



	/**
	 * Return the value associated with the column: teeth_14
	 */
	public java.lang.String getTeeth14 () {
		return teeth14;
	}

	/**
	 * Set the value related to the column: teeth_14
	 * @param teeth14 the teeth_14 value
	 */
	public void setTeeth14 (java.lang.String teeth14) {
		this.teeth14 = teeth14;
	}



	/**
	 * Return the value associated with the column: teeth_13
	 */
	public java.lang.String getTeeth13 () {
		return teeth13;
	}

	/**
	 * Set the value related to the column: teeth_13
	 * @param teeth13 the teeth_13 value
	 */
	public void setTeeth13 (java.lang.String teeth13) {
		this.teeth13 = teeth13;
	}



	/**
	 * Return the value associated with the column: teeth_12
	 */
	public java.lang.String getTeeth12 () {
		return teeth12;
	}

	/**
	 * Set the value related to the column: teeth_12
	 * @param teeth12 the teeth_12 value
	 */
	public void setTeeth12 (java.lang.String teeth12) {
		this.teeth12 = teeth12;
	}



	/**
	 * Return the value associated with the column: teeth_11
	 */
	public java.lang.String getTeeth11 () {
		return teeth11;
	}

	/**
	 * Set the value related to the column: teeth_11
	 * @param teeth11 the teeth_11 value
	 */
	public void setTeeth11 (java.lang.String teeth11) {
		this.teeth11 = teeth11;
	}



	/**
	 * Return the value associated with the column: teeth_21
	 */
	public java.lang.String getTeeth21 () {
		return teeth21;
	}

	/**
	 * Set the value related to the column: teeth_21
	 * @param teeth21 the teeth_21 value
	 */
	public void setTeeth21 (java.lang.String teeth21) {
		this.teeth21 = teeth21;
	}



	/**
	 * Return the value associated with the column: teeth_22
	 */
	public java.lang.String getTeeth22 () {
		return teeth22;
	}

	/**
	 * Set the value related to the column: teeth_22
	 * @param teeth22 the teeth_22 value
	 */
	public void setTeeth22 (java.lang.String teeth22) {
		this.teeth22 = teeth22;
	}



	/**
	 * Return the value associated with the column: teeth_23
	 */
	public java.lang.String getTeeth23 () {
		return teeth23;
	}

	/**
	 * Set the value related to the column: teeth_23
	 * @param teeth23 the teeth_23 value
	 */
	public void setTeeth23 (java.lang.String teeth23) {
		this.teeth23 = teeth23;
	}



	/**
	 * Return the value associated with the column: teeth_24
	 */
	public java.lang.String getTeeth24 () {
		return teeth24;
	}

	/**
	 * Set the value related to the column: teeth_24
	 * @param teeth24 the teeth_24 value
	 */
	public void setTeeth24 (java.lang.String teeth24) {
		this.teeth24 = teeth24;
	}



	/**
	 * Return the value associated with the column: teeth_25
	 */
	public java.lang.String getTeeth25 () {
		return teeth25;
	}

	/**
	 * Set the value related to the column: teeth_25
	 * @param teeth25 the teeth_25 value
	 */
	public void setTeeth25 (java.lang.String teeth25) {
		this.teeth25 = teeth25;
	}



	/**
	 * Return the value associated with the column: teeth_26
	 */
	public java.lang.String getTeeth26 () {
		return teeth26;
	}

	/**
	 * Set the value related to the column: teeth_26
	 * @param teeth26 the teeth_26 value
	 */
	public void setTeeth26 (java.lang.String teeth26) {
		this.teeth26 = teeth26;
	}



	/**
	 * Return the value associated with the column: teeth_27
	 */
	public java.lang.String getTeeth27 () {
		return teeth27;
	}

	/**
	 * Set the value related to the column: teeth_27
	 * @param teeth27 the teeth_27 value
	 */
	public void setTeeth27 (java.lang.String teeth27) {
		this.teeth27 = teeth27;
	}



	/**
	 * Return the value associated with the column: teeth_28
	 */
	public java.lang.String getTeeth28 () {
		return teeth28;
	}

	/**
	 * Set the value related to the column: teeth_28
	 * @param teeth28 the teeth_28 value
	 */
	public void setTeeth28 (java.lang.String teeth28) {
		this.teeth28 = teeth28;
	}



	/**
	 * Return the value associated with the column: teeth_48
	 */
	public java.lang.String getTeeth48 () {
		return teeth48;
	}

	/**
	 * Set the value related to the column: teeth_48
	 * @param teeth48 the teeth_48 value
	 */
	public void setTeeth48 (java.lang.String teeth48) {
		this.teeth48 = teeth48;
	}



	/**
	 * Return the value associated with the column: teeth_47
	 */
	public java.lang.String getTeeth47 () {
		return teeth47;
	}

	/**
	 * Set the value related to the column: teeth_47
	 * @param teeth47 the teeth_47 value
	 */
	public void setTeeth47 (java.lang.String teeth47) {
		this.teeth47 = teeth47;
	}



	/**
	 * Return the value associated with the column: teeth_46
	 */
	public java.lang.String getTeeth46 () {
		return teeth46;
	}

	/**
	 * Set the value related to the column: teeth_46
	 * @param teeth46 the teeth_46 value
	 */
	public void setTeeth46 (java.lang.String teeth46) {
		this.teeth46 = teeth46;
	}



	/**
	 * Return the value associated with the column: teeth_45
	 */
	public java.lang.String getTeeth45 () {
		return teeth45;
	}

	/**
	 * Set the value related to the column: teeth_45
	 * @param teeth45 the teeth_45 value
	 */
	public void setTeeth45 (java.lang.String teeth45) {
		this.teeth45 = teeth45;
	}



	/**
	 * Return the value associated with the column: teeth_44
	 */
	public java.lang.String getTeeth44 () {
		return teeth44;
	}

	/**
	 * Set the value related to the column: teeth_44
	 * @param teeth44 the teeth_44 value
	 */
	public void setTeeth44 (java.lang.String teeth44) {
		this.teeth44 = teeth44;
	}



	/**
	 * Return the value associated with the column: teeth_43
	 */
	public java.lang.String getTeeth43 () {
		return teeth43;
	}

	/**
	 * Set the value related to the column: teeth_43
	 * @param teeth43 the teeth_43 value
	 */
	public void setTeeth43 (java.lang.String teeth43) {
		this.teeth43 = teeth43;
	}



	/**
	 * Return the value associated with the column: teeth_42
	 */
	public java.lang.String getTeeth42 () {
		return teeth42;
	}

	/**
	 * Set the value related to the column: teeth_42
	 * @param teeth42 the teeth_42 value
	 */
	public void setTeeth42 (java.lang.String teeth42) {
		this.teeth42 = teeth42;
	}



	/**
	 * Return the value associated with the column: teeth_41
	 */
	public java.lang.String getTeeth41 () {
		return teeth41;
	}

	/**
	 * Set the value related to the column: teeth_41
	 * @param teeth41 the teeth_41 value
	 */
	public void setTeeth41 (java.lang.String teeth41) {
		this.teeth41 = teeth41;
	}



	/**
	 * Return the value associated with the column: teeth_31
	 */
	public java.lang.String getTeeth31 () {
		return teeth31;
	}

	/**
	 * Set the value related to the column: teeth_31
	 * @param teeth31 the teeth_31 value
	 */
	public void setTeeth31 (java.lang.String teeth31) {
		this.teeth31 = teeth31;
	}



	/**
	 * Return the value associated with the column: teeth_32
	 */
	public java.lang.String getTeeth32 () {
		return teeth32;
	}

	/**
	 * Set the value related to the column: teeth_32
	 * @param teeth32 the teeth_32 value
	 */
	public void setTeeth32 (java.lang.String teeth32) {
		this.teeth32 = teeth32;
	}



	/**
	 * Return the value associated with the column: teeth_33
	 */
	public java.lang.String getTeeth33 () {
		return teeth33;
	}

	/**
	 * Set the value related to the column: teeth_33
	 * @param teeth33 the teeth_33 value
	 */
	public void setTeeth33 (java.lang.String teeth33) {
		this.teeth33 = teeth33;
	}



	/**
	 * Return the value associated with the column: teeth_34
	 */
	public java.lang.String getTeeth34 () {
		return teeth34;
	}

	/**
	 * Set the value related to the column: teeth_34
	 * @param teeth34 the teeth_34 value
	 */
	public void setTeeth34 (java.lang.String teeth34) {
		this.teeth34 = teeth34;
	}



	/**
	 * Return the value associated with the column: teeth_35
	 */
	public java.lang.String getTeeth35 () {
		return teeth35;
	}

	/**
	 * Set the value related to the column: teeth_35
	 * @param teeth35 the teeth_35 value
	 */
	public void setTeeth35 (java.lang.String teeth35) {
		this.teeth35 = teeth35;
	}



	/**
	 * Return the value associated with the column: teeth_36
	 */
	public java.lang.String getTeeth36 () {
		return teeth36;
	}

	/**
	 * Set the value related to the column: teeth_36
	 * @param teeth36 the teeth_36 value
	 */
	public void setTeeth36 (java.lang.String teeth36) {
		this.teeth36 = teeth36;
	}



	/**
	 * Return the value associated with the column: teeth_37
	 */
	public java.lang.String getTeeth37 () {
		return teeth37;
	}

	/**
	 * Set the value related to the column: teeth_37
	 * @param teeth37 the teeth_37 value
	 */
	public void setTeeth37 (java.lang.String teeth37) {
		this.teeth37 = teeth37;
	}



	/**
	 * Return the value associated with the column: teeth_38
	 */
	public java.lang.String getTeeth38 () {
		return teeth38;
	}

	/**
	 * Set the value related to the column: teeth_38
	 * @param teeth38 the teeth_38 value
	 */
	public void setTeeth38 (java.lang.String teeth38) {
		this.teeth38 = teeth38;
	}



	/**
	 * Return the value associated with the column: teeth_51
	 */
	public java.lang.String getTeeth51 () {
		return teeth51;
	}

	/**
	 * Set the value related to the column: teeth_51
	 * @param teeth51 the teeth_51 value
	 */
	public void setTeeth51 (java.lang.String teeth51) {
		this.teeth51 = teeth51;
	}



	/**
	 * Return the value associated with the column: teeth_52
	 */
	public java.lang.String getTeeth52 () {
		return teeth52;
	}

	/**
	 * Set the value related to the column: teeth_52
	 * @param teeth52 the teeth_52 value
	 */
	public void setTeeth52 (java.lang.String teeth52) {
		this.teeth52 = teeth52;
	}



	/**
	 * Return the value associated with the column: teeth_53
	 */
	public java.lang.String getTeeth53 () {
		return teeth53;
	}

	/**
	 * Set the value related to the column: teeth_53
	 * @param teeth53 the teeth_53 value
	 */
	public void setTeeth53 (java.lang.String teeth53) {
		this.teeth53 = teeth53;
	}



	/**
	 * Return the value associated with the column: teeth_54
	 */
	public java.lang.String getTeeth54 () {
		return teeth54;
	}

	/**
	 * Set the value related to the column: teeth_54
	 * @param teeth54 the teeth_54 value
	 */
	public void setTeeth54 (java.lang.String teeth54) {
		this.teeth54 = teeth54;
	}



	/**
	 * Return the value associated with the column: teeth_55
	 */
	public java.lang.String getTeeth55 () {
		return teeth55;
	}

	/**
	 * Set the value related to the column: teeth_55
	 * @param teeth55 the teeth_55 value
	 */
	public void setTeeth55 (java.lang.String teeth55) {
		this.teeth55 = teeth55;
	}



	/**
	 * Return the value associated with the column: teeth_61
	 */
	public java.lang.String getTeeth61 () {
		return teeth61;
	}

	/**
	 * Set the value related to the column: teeth_61
	 * @param teeth61 the teeth_61 value
	 */
	public void setTeeth61 (java.lang.String teeth61) {
		this.teeth61 = teeth61;
	}



	/**
	 * Return the value associated with the column: teeth_62
	 */
	public java.lang.String getTeeth62 () {
		return teeth62;
	}

	/**
	 * Set the value related to the column: teeth_62
	 * @param teeth62 the teeth_62 value
	 */
	public void setTeeth62 (java.lang.String teeth62) {
		this.teeth62 = teeth62;
	}



	/**
	 * Return the value associated with the column: teeth_63
	 */
	public java.lang.String getTeeth63 () {
		return teeth63;
	}

	/**
	 * Set the value related to the column: teeth_63
	 * @param teeth63 the teeth_63 value
	 */
	public void setTeeth63 (java.lang.String teeth63) {
		this.teeth63 = teeth63;
	}



	/**
	 * Return the value associated with the column: teeth_64
	 */
	public java.lang.String getTeeth64 () {
		return teeth64;
	}

	/**
	 * Set the value related to the column: teeth_64
	 * @param teeth64 the teeth_64 value
	 */
	public void setTeeth64 (java.lang.String teeth64) {
		this.teeth64 = teeth64;
	}



	/**
	 * Return the value associated with the column: teeth_65
	 */
	public java.lang.String getTeeth65 () {
		return teeth65;
	}

	/**
	 * Set the value related to the column: teeth_65
	 * @param teeth65 the teeth_65 value
	 */
	public void setTeeth65 (java.lang.String teeth65) {
		this.teeth65 = teeth65;
	}



	/**
	 * Return the value associated with the column: teeth_81
	 */
	public java.lang.String getTeeth81 () {
		return teeth81;
	}

	/**
	 * Set the value related to the column: teeth_81
	 * @param teeth81 the teeth_81 value
	 */
	public void setTeeth81 (java.lang.String teeth81) {
		this.teeth81 = teeth81;
	}



	/**
	 * Return the value associated with the column: teeth_82
	 */
	public java.lang.String getTeeth82 () {
		return teeth82;
	}

	/**
	 * Set the value related to the column: teeth_82
	 * @param teeth82 the teeth_82 value
	 */
	public void setTeeth82 (java.lang.String teeth82) {
		this.teeth82 = teeth82;
	}



	/**
	 * Return the value associated with the column: teeth_83
	 */
	public java.lang.String getTeeth83 () {
		return teeth83;
	}

	/**
	 * Set the value related to the column: teeth_83
	 * @param teeth83 the teeth_83 value
	 */
	public void setTeeth83 (java.lang.String teeth83) {
		this.teeth83 = teeth83;
	}



	/**
	 * Return the value associated with the column: teeth_84
	 */
	public java.lang.String getTeeth84 () {
		return teeth84;
	}

	/**
	 * Set the value related to the column: teeth_84
	 * @param teeth84 the teeth_84 value
	 */
	public void setTeeth84 (java.lang.String teeth84) {
		this.teeth84 = teeth84;
	}



	/**
	 * Return the value associated with the column: teeth_85
	 */
	public java.lang.String getTeeth85 () {
		return teeth85;
	}

	/**
	 * Set the value related to the column: teeth_85
	 * @param teeth85 the teeth_85 value
	 */
	public void setTeeth85 (java.lang.String teeth85) {
		this.teeth85 = teeth85;
	}



	/**
	 * Return the value associated with the column: teeth_71
	 */
	public java.lang.String getTeeth71 () {
		return teeth71;
	}

	/**
	 * Set the value related to the column: teeth_71
	 * @param teeth71 the teeth_71 value
	 */
	public void setTeeth71 (java.lang.String teeth71) {
		this.teeth71 = teeth71;
	}



	/**
	 * Return the value associated with the column: teeth_72
	 */
	public java.lang.String getTeeth72 () {
		return teeth72;
	}

	/**
	 * Set the value related to the column: teeth_72
	 * @param teeth72 the teeth_72 value
	 */
	public void setTeeth72 (java.lang.String teeth72) {
		this.teeth72 = teeth72;
	}



	/**
	 * Return the value associated with the column: teeth_73
	 */
	public java.lang.String getTeeth73 () {
		return teeth73;
	}

	/**
	 * Set the value related to the column: teeth_73
	 * @param teeth73 the teeth_73 value
	 */
	public void setTeeth73 (java.lang.String teeth73) {
		this.teeth73 = teeth73;
	}



	/**
	 * Return the value associated with the column: teeth_74
	 */
	public java.lang.String getTeeth74 () {
		return teeth74;
	}

	/**
	 * Set the value related to the column: teeth_74
	 * @param teeth74 the teeth_74 value
	 */
	public void setTeeth74 (java.lang.String teeth74) {
		this.teeth74 = teeth74;
	}



	/**
	 * Return the value associated with the column: teeth_75
	 */
	public java.lang.String getTeeth75 () {
		return teeth75;
	}

	/**
	 * Set the value related to the column: teeth_75
	 * @param teeth75 the teeth_75 value
	 */
	public void setTeeth75 (java.lang.String teeth75) {
		this.teeth75 = teeth75;
	}



	/**
	 * Return the value associated with the column: teeth_18_value
	 */
	public java.lang.String getTeeth18Value () {
		return teeth18Value;
	}

	/**
	 * Set the value related to the column: teeth_18_value
	 * @param teeth18Value the teeth_18_value value
	 */
	public void setTeeth18Value (java.lang.String teeth18Value) {
		this.teeth18Value = teeth18Value;
	}



	/**
	 * Return the value associated with the column: teeth_17_value
	 */
	public java.lang.String getTeeth17Value () {
		return teeth17Value;
	}

	/**
	 * Set the value related to the column: teeth_17_value
	 * @param teeth17Value the teeth_17_value value
	 */
	public void setTeeth17Value (java.lang.String teeth17Value) {
		this.teeth17Value = teeth17Value;
	}



	/**
	 * Return the value associated with the column: teeth_16_value
	 */
	public java.lang.String getTeeth16Value () {
		return teeth16Value;
	}

	/**
	 * Set the value related to the column: teeth_16_value
	 * @param teeth16Value the teeth_16_value value
	 */
	public void setTeeth16Value (java.lang.String teeth16Value) {
		this.teeth16Value = teeth16Value;
	}



	/**
	 * Return the value associated with the column: teeth_15_value
	 */
	public java.lang.String getTeeth15Value () {
		return teeth15Value;
	}

	/**
	 * Set the value related to the column: teeth_15_value
	 * @param teeth15Value the teeth_15_value value
	 */
	public void setTeeth15Value (java.lang.String teeth15Value) {
		this.teeth15Value = teeth15Value;
	}



	/**
	 * Return the value associated with the column: teeth_14_value
	 */
	public java.lang.String getTeeth14Value () {
		return teeth14Value;
	}

	/**
	 * Set the value related to the column: teeth_14_value
	 * @param teeth14Value the teeth_14_value value
	 */
	public void setTeeth14Value (java.lang.String teeth14Value) {
		this.teeth14Value = teeth14Value;
	}



	/**
	 * Return the value associated with the column: teeth_13_value
	 */
	public java.lang.String getTeeth13Value () {
		return teeth13Value;
	}

	/**
	 * Set the value related to the column: teeth_13_value
	 * @param teeth13Value the teeth_13_value value
	 */
	public void setTeeth13Value (java.lang.String teeth13Value) {
		this.teeth13Value = teeth13Value;
	}



	/**
	 * Return the value associated with the column: teeth_12_value
	 */
	public java.lang.String getTeeth12Value () {
		return teeth12Value;
	}

	/**
	 * Set the value related to the column: teeth_12_value
	 * @param teeth12Value the teeth_12_value value
	 */
	public void setTeeth12Value (java.lang.String teeth12Value) {
		this.teeth12Value = teeth12Value;
	}



	/**
	 * Return the value associated with the column: teeth_11_value
	 */
	public java.lang.String getTeeth11Value () {
		return teeth11Value;
	}

	/**
	 * Set the value related to the column: teeth_11_value
	 * @param teeth11Value the teeth_11_value value
	 */
	public void setTeeth11Value (java.lang.String teeth11Value) {
		this.teeth11Value = teeth11Value;
	}



	/**
	 * Return the value associated with the column: teeth_21_value
	 */
	public java.lang.String getTeeth21Value () {
		return teeth21Value;
	}

	/**
	 * Set the value related to the column: teeth_21_value
	 * @param teeth21Value the teeth_21_value value
	 */
	public void setTeeth21Value (java.lang.String teeth21Value) {
		this.teeth21Value = teeth21Value;
	}



	/**
	 * Return the value associated with the column: teeth_22_value
	 */
	public java.lang.String getTeeth22Value () {
		return teeth22Value;
	}

	/**
	 * Set the value related to the column: teeth_22_value
	 * @param teeth22Value the teeth_22_value value
	 */
	public void setTeeth22Value (java.lang.String teeth22Value) {
		this.teeth22Value = teeth22Value;
	}



	/**
	 * Return the value associated with the column: teeth_23_value
	 */
	public java.lang.String getTeeth23Value () {
		return teeth23Value;
	}

	/**
	 * Set the value related to the column: teeth_23_value
	 * @param teeth23Value the teeth_23_value value
	 */
	public void setTeeth23Value (java.lang.String teeth23Value) {
		this.teeth23Value = teeth23Value;
	}



	/**
	 * Return the value associated with the column: teeth_24_value
	 */
	public java.lang.String getTeeth24Value () {
		return teeth24Value;
	}

	/**
	 * Set the value related to the column: teeth_24_value
	 * @param teeth24Value the teeth_24_value value
	 */
	public void setTeeth24Value (java.lang.String teeth24Value) {
		this.teeth24Value = teeth24Value;
	}



	/**
	 * Return the value associated with the column: teeth_25_value
	 */
	public java.lang.String getTeeth25Value () {
		return teeth25Value;
	}

	/**
	 * Set the value related to the column: teeth_25_value
	 * @param teeth25Value the teeth_25_value value
	 */
	public void setTeeth25Value (java.lang.String teeth25Value) {
		this.teeth25Value = teeth25Value;
	}



	/**
	 * Return the value associated with the column: teeth_26_value
	 */
	public java.lang.String getTeeth26Value () {
		return teeth26Value;
	}

	/**
	 * Set the value related to the column: teeth_26_value
	 * @param teeth26Value the teeth_26_value value
	 */
	public void setTeeth26Value (java.lang.String teeth26Value) {
		this.teeth26Value = teeth26Value;
	}



	/**
	 * Return the value associated with the column: teeth_27_value
	 */
	public java.lang.String getTeeth27Value () {
		return teeth27Value;
	}

	/**
	 * Set the value related to the column: teeth_27_value
	 * @param teeth27Value the teeth_27_value value
	 */
	public void setTeeth27Value (java.lang.String teeth27Value) {
		this.teeth27Value = teeth27Value;
	}



	/**
	 * Return the value associated with the column: teeth_28_value
	 */
	public java.lang.String getTeeth28Value () {
		return teeth28Value;
	}

	/**
	 * Set the value related to the column: teeth_28_value
	 * @param teeth28Value the teeth_28_value value
	 */
	public void setTeeth28Value (java.lang.String teeth28Value) {
		this.teeth28Value = teeth28Value;
	}



	/**
	 * Return the value associated with the column: teeth_48_value
	 */
	public java.lang.String getTeeth48Value () {
		return teeth48Value;
	}

	/**
	 * Set the value related to the column: teeth_48_value
	 * @param teeth48Value the teeth_48_value value
	 */
	public void setTeeth48Value (java.lang.String teeth48Value) {
		this.teeth48Value = teeth48Value;
	}



	/**
	 * Return the value associated with the column: teeth_47_value
	 */
	public java.lang.String getTeeth47Value () {
		return teeth47Value;
	}

	/**
	 * Set the value related to the column: teeth_47_value
	 * @param teeth47Value the teeth_47_value value
	 */
	public void setTeeth47Value (java.lang.String teeth47Value) {
		this.teeth47Value = teeth47Value;
	}



	/**
	 * Return the value associated with the column: teeth_46_value
	 */
	public java.lang.String getTeeth46Value () {
		return teeth46Value;
	}

	/**
	 * Set the value related to the column: teeth_46_value
	 * @param teeth46Value the teeth_46_value value
	 */
	public void setTeeth46Value (java.lang.String teeth46Value) {
		this.teeth46Value = teeth46Value;
	}



	/**
	 * Return the value associated with the column: teeth_45_value
	 */
	public java.lang.String getTeeth45Value () {
		return teeth45Value;
	}

	/**
	 * Set the value related to the column: teeth_45_value
	 * @param teeth45Value the teeth_45_value value
	 */
	public void setTeeth45Value (java.lang.String teeth45Value) {
		this.teeth45Value = teeth45Value;
	}



	/**
	 * Return the value associated with the column: teeth_44_value
	 */
	public java.lang.String getTeeth44Value () {
		return teeth44Value;
	}

	/**
	 * Set the value related to the column: teeth_44_value
	 * @param teeth44Value the teeth_44_value value
	 */
	public void setTeeth44Value (java.lang.String teeth44Value) {
		this.teeth44Value = teeth44Value;
	}



	/**
	 * Return the value associated with the column: teeth_43_value
	 */
	public java.lang.String getTeeth43Value () {
		return teeth43Value;
	}

	/**
	 * Set the value related to the column: teeth_43_value
	 * @param teeth43Value the teeth_43_value value
	 */
	public void setTeeth43Value (java.lang.String teeth43Value) {
		this.teeth43Value = teeth43Value;
	}



	/**
	 * Return the value associated with the column: teeth_42_value
	 */
	public java.lang.String getTeeth42Value () {
		return teeth42Value;
	}

	/**
	 * Set the value related to the column: teeth_42_value
	 * @param teeth42Value the teeth_42_value value
	 */
	public void setTeeth42Value (java.lang.String teeth42Value) {
		this.teeth42Value = teeth42Value;
	}



	/**
	 * Return the value associated with the column: teeth_41_value
	 */
	public java.lang.String getTeeth41Value () {
		return teeth41Value;
	}

	/**
	 * Set the value related to the column: teeth_41_value
	 * @param teeth41Value the teeth_41_value value
	 */
	public void setTeeth41Value (java.lang.String teeth41Value) {
		this.teeth41Value = teeth41Value;
	}



	/**
	 * Return the value associated with the column: teeth_31_value
	 */
	public java.lang.String getTeeth31Value () {
		return teeth31Value;
	}

	/**
	 * Set the value related to the column: teeth_31_value
	 * @param teeth31Value the teeth_31_value value
	 */
	public void setTeeth31Value (java.lang.String teeth31Value) {
		this.teeth31Value = teeth31Value;
	}



	/**
	 * Return the value associated with the column: teeth_32_value
	 */
	public java.lang.String getTeeth32Value () {
		return teeth32Value;
	}

	/**
	 * Set the value related to the column: teeth_32_value
	 * @param teeth32Value the teeth_32_value value
	 */
	public void setTeeth32Value (java.lang.String teeth32Value) {
		this.teeth32Value = teeth32Value;
	}



	/**
	 * Return the value associated with the column: teeth_33_value
	 */
	public java.lang.String getTeeth33Value () {
		return teeth33Value;
	}

	/**
	 * Set the value related to the column: teeth_33_value
	 * @param teeth33Value the teeth_33_value value
	 */
	public void setTeeth33Value (java.lang.String teeth33Value) {
		this.teeth33Value = teeth33Value;
	}



	/**
	 * Return the value associated with the column: teeth_34_value
	 */
	public java.lang.String getTeeth34Value () {
		return teeth34Value;
	}

	/**
	 * Set the value related to the column: teeth_34_value
	 * @param teeth34Value the teeth_34_value value
	 */
	public void setTeeth34Value (java.lang.String teeth34Value) {
		this.teeth34Value = teeth34Value;
	}



	/**
	 * Return the value associated with the column: teeth_35_value
	 */
	public java.lang.String getTeeth35Value () {
		return teeth35Value;
	}

	/**
	 * Set the value related to the column: teeth_35_value
	 * @param teeth35Value the teeth_35_value value
	 */
	public void setTeeth35Value (java.lang.String teeth35Value) {
		this.teeth35Value = teeth35Value;
	}



	/**
	 * Return the value associated with the column: teeth_36_value
	 */
	public java.lang.String getTeeth36Value () {
		return teeth36Value;
	}

	/**
	 * Set the value related to the column: teeth_36_value
	 * @param teeth36Value the teeth_36_value value
	 */
	public void setTeeth36Value (java.lang.String teeth36Value) {
		this.teeth36Value = teeth36Value;
	}



	/**
	 * Return the value associated with the column: teeth_37_value
	 */
	public java.lang.String getTeeth37Value () {
		return teeth37Value;
	}

	/**
	 * Set the value related to the column: teeth_37_value
	 * @param teeth37Value the teeth_37_value value
	 */
	public void setTeeth37Value (java.lang.String teeth37Value) {
		this.teeth37Value = teeth37Value;
	}



	/**
	 * Return the value associated with the column: teeth_38_value
	 */
	public java.lang.String getTeeth38Value () {
		return teeth38Value;
	}

	/**
	 * Set the value related to the column: teeth_38_value
	 * @param teeth38Value the teeth_38_value value
	 */
	public void setTeeth38Value (java.lang.String teeth38Value) {
		this.teeth38Value = teeth38Value;
	}



	/**
	 * Return the value associated with the column: teeth_51_value
	 */
	public java.lang.String getTeeth51Value () {
		return teeth51Value;
	}

	/**
	 * Set the value related to the column: teeth_51_value
	 * @param teeth51Value the teeth_51_value value
	 */
	public void setTeeth51Value (java.lang.String teeth51Value) {
		this.teeth51Value = teeth51Value;
	}



	/**
	 * Return the value associated with the column: teeth_52_value
	 */
	public java.lang.String getTeeth52Value () {
		return teeth52Value;
	}

	/**
	 * Set the value related to the column: teeth_52_value
	 * @param teeth52Value the teeth_52_value value
	 */
	public void setTeeth52Value (java.lang.String teeth52Value) {
		this.teeth52Value = teeth52Value;
	}



	/**
	 * Return the value associated with the column: teeth_53_value
	 */
	public java.lang.String getTeeth53Value () {
		return teeth53Value;
	}

	/**
	 * Set the value related to the column: teeth_53_value
	 * @param teeth53Value the teeth_53_value value
	 */
	public void setTeeth53Value (java.lang.String teeth53Value) {
		this.teeth53Value = teeth53Value;
	}



	/**
	 * Return the value associated with the column: teeth_54_value
	 */
	public java.lang.String getTeeth54Value () {
		return teeth54Value;
	}

	/**
	 * Set the value related to the column: teeth_54_value
	 * @param teeth54Value the teeth_54_value value
	 */
	public void setTeeth54Value (java.lang.String teeth54Value) {
		this.teeth54Value = teeth54Value;
	}



	/**
	 * Return the value associated with the column: teeth_55_value
	 */
	public java.lang.String getTeeth55Value () {
		return teeth55Value;
	}

	/**
	 * Set the value related to the column: teeth_55_value
	 * @param teeth55Value the teeth_55_value value
	 */
	public void setTeeth55Value (java.lang.String teeth55Value) {
		this.teeth55Value = teeth55Value;
	}



	/**
	 * Return the value associated with the column: teeth_61_value
	 */
	public java.lang.String getTeeth61Value () {
		return teeth61Value;
	}

	/**
	 * Set the value related to the column: teeth_61_value
	 * @param teeth61Value the teeth_61_value value
	 */
	public void setTeeth61Value (java.lang.String teeth61Value) {
		this.teeth61Value = teeth61Value;
	}



	/**
	 * Return the value associated with the column: teeth_62_value
	 */
	public java.lang.String getTeeth62Value () {
		return teeth62Value;
	}

	/**
	 * Set the value related to the column: teeth_62_value
	 * @param teeth62Value the teeth_62_value value
	 */
	public void setTeeth62Value (java.lang.String teeth62Value) {
		this.teeth62Value = teeth62Value;
	}



	/**
	 * Return the value associated with the column: teeth_63_value
	 */
	public java.lang.String getTeeth63Value () {
		return teeth63Value;
	}

	/**
	 * Set the value related to the column: teeth_63_value
	 * @param teeth63Value the teeth_63_value value
	 */
	public void setTeeth63Value (java.lang.String teeth63Value) {
		this.teeth63Value = teeth63Value;
	}



	/**
	 * Return the value associated with the column: teeth_64_value
	 */
	public java.lang.String getTeeth64Value () {
		return teeth64Value;
	}

	/**
	 * Set the value related to the column: teeth_64_value
	 * @param teeth64Value the teeth_64_value value
	 */
	public void setTeeth64Value (java.lang.String teeth64Value) {
		this.teeth64Value = teeth64Value;
	}



	/**
	 * Return the value associated with the column: teeth_65_value
	 */
	public java.lang.String getTeeth65Value () {
		return teeth65Value;
	}

	/**
	 * Set the value related to the column: teeth_65_value
	 * @param teeth65Value the teeth_65_value value
	 */
	public void setTeeth65Value (java.lang.String teeth65Value) {
		this.teeth65Value = teeth65Value;
	}



	/**
	 * Return the value associated with the column: teeth_81_value
	 */
	public java.lang.String getTeeth81Value () {
		return teeth81Value;
	}

	/**
	 * Set the value related to the column: teeth_81_value
	 * @param teeth81Value the teeth_81_value value
	 */
	public void setTeeth81Value (java.lang.String teeth81Value) {
		this.teeth81Value = teeth81Value;
	}



	/**
	 * Return the value associated with the column: teeth_82_value
	 */
	public java.lang.String getTeeth82Value () {
		return teeth82Value;
	}

	/**
	 * Set the value related to the column: teeth_82_value
	 * @param teeth82Value the teeth_82_value value
	 */
	public void setTeeth82Value (java.lang.String teeth82Value) {
		this.teeth82Value = teeth82Value;
	}



	/**
	 * Return the value associated with the column: teeth_83_value
	 */
	public java.lang.String getTeeth83Value () {
		return teeth83Value;
	}

	/**
	 * Set the value related to the column: teeth_83_value
	 * @param teeth83Value the teeth_83_value value
	 */
	public void setTeeth83Value (java.lang.String teeth83Value) {
		this.teeth83Value = teeth83Value;
	}



	/**
	 * Return the value associated with the column: teeth_84_value
	 */
	public java.lang.String getTeeth84Value () {
		return teeth84Value;
	}

	/**
	 * Set the value related to the column: teeth_84_value
	 * @param teeth84Value the teeth_84_value value
	 */
	public void setTeeth84Value (java.lang.String teeth84Value) {
		this.teeth84Value = teeth84Value;
	}



	/**
	 * Return the value associated with the column: teeth_85_value
	 */
	public java.lang.String getTeeth85Value () {
		return teeth85Value;
	}

	/**
	 * Set the value related to the column: teeth_85_value
	 * @param teeth85Value the teeth_85_value value
	 */
	public void setTeeth85Value (java.lang.String teeth85Value) {
		this.teeth85Value = teeth85Value;
	}



	/**
	 * Return the value associated with the column: teeth_71_value
	 */
	public java.lang.String getTeeth71Value () {
		return teeth71Value;
	}

	/**
	 * Set the value related to the column: teeth_71_value
	 * @param teeth71Value the teeth_71_value value
	 */
	public void setTeeth71Value (java.lang.String teeth71Value) {
		this.teeth71Value = teeth71Value;
	}



	/**
	 * Return the value associated with the column: teeth_72_value
	 */
	public java.lang.String getTeeth72Value () {
		return teeth72Value;
	}

	/**
	 * Set the value related to the column: teeth_72_value
	 * @param teeth72Value the teeth_72_value value
	 */
	public void setTeeth72Value (java.lang.String teeth72Value) {
		this.teeth72Value = teeth72Value;
	}



	/**
	 * Return the value associated with the column: teeth_73_value
	 */
	public java.lang.String getTeeth73Value () {
		return teeth73Value;
	}

	/**
	 * Set the value related to the column: teeth_73_value
	 * @param teeth73Value the teeth_73_value value
	 */
	public void setTeeth73Value (java.lang.String teeth73Value) {
		this.teeth73Value = teeth73Value;
	}



	/**
	 * Return the value associated with the column: teeth_74_value
	 */
	public java.lang.String getTeeth74Value () {
		return teeth74Value;
	}

	/**
	 * Set the value related to the column: teeth_74_value
	 * @param teeth74Value the teeth_74_value value
	 */
	public void setTeeth74Value (java.lang.String teeth74Value) {
		this.teeth74Value = teeth74Value;
	}



	/**
	 * Return the value associated with the column: teeth_75_value
	 */
	public java.lang.String getTeeth75Value () {
		return teeth75Value;
	}

	/**
	 * Set the value related to the column: teeth_75_value
	 * @param teeth75Value the teeth_75_value value
	 */
	public void setTeeth75Value (java.lang.String teeth75Value) {
		this.teeth75Value = teeth75Value;
	}



	/**
	 * Return the value associated with the column: tongue_inspection
	 */
	public java.lang.String getTongueInspection () {
		return tongueInspection;
	}

	/**
	 * Set the value related to the column: tongue_inspection
	 * @param tongueInspection the tongue_inspection value
	 */
	public void setTongueInspection (java.lang.String tongueInspection) {
		this.tongueInspection = tongueInspection;
	}



	/**
	 * Return the value associated with the column: dorsum
	 */
	public java.lang.String getDorsum () {
		return dorsum;
	}

	/**
	 * Set the value related to the column: dorsum
	 * @param dorsum the dorsum value
	 */
	public void setDorsum (java.lang.String dorsum) {
		this.dorsum = dorsum;
	}



	/**
	 * Return the value associated with the column: ventral_surface
	 */
	public java.lang.String getVentralSurface () {
		return ventralSurface;
	}

	/**
	 * Set the value related to the column: ventral_surface
	 * @param ventralSurface the ventral_surface value
	 */
	public void setVentralSurface (java.lang.String ventralSurface) {
		this.ventralSurface = ventralSurface;
	}



	/**
	 * Return the value associated with the column: lateral_border
	 */
	public java.lang.String getLateralBorder () {
		return lateralBorder;
	}

	/**
	 * Set the value related to the column: lateral_border
	 * @param lateralBorder the lateral_border value
	 */
	public void setLateralBorder (java.lang.String lateralBorder) {
		this.lateralBorder = lateralBorder;
	}



	/**
	 * Return the value associated with the column: lateral_border_details
	 */
	public java.lang.String getLateralBorderDetails () {
		return lateralBorderDetails;
	}

	/**
	 * Set the value related to the column: lateral_border_details
	 * @param lateralBorderDetails the lateral_border_details value
	 */
	public void setLateralBorderDetails (java.lang.String lateralBorderDetails) {
		this.lateralBorderDetails = lateralBorderDetails;
	}



	/**
	 * Return the value associated with the column: local_examination_findings
	 */
	public java.lang.String getLocalExaminationFindings () {
		return localExaminationFindings;
	}

	/**
	 * Set the value related to the column: local_examination_findings
	 * @param localExaminationFindings the local_examination_findings value
	 */
	public void setLocalExaminationFindings (java.lang.String localExaminationFindings) {
		this.localExaminationFindings = localExaminationFindings;
	}



	/**
	 * Return the value associated with the column: case_summary
	 */
	public java.lang.String getCaseSummary () {
		return caseSummary;
	}

	/**
	 * Set the value related to the column: case_summary
	 * @param caseSummary the case_summary value
	 */
	public void setCaseSummary (java.lang.String caseSummary) {
		this.caseSummary = caseSummary;
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
	 * Return the value associated with the column: OpdOralMedicineDentalTissues
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOralMedicineDentalTissue> getOpdOralMedicineDentalTissues () {
		return opdOralMedicineDentalTissues;
	}

	/**
	 * Set the value related to the column: OpdOralMedicineDentalTissues
	 * @param opdOralMedicineDentalTissues the OpdOralMedicineDentalTissues value
	 */
	public void setOpdOralMedicineDentalTissues (java.util.Set<jkt.hms.masters.business.OpdOralMedicineDentalTissue> opdOralMedicineDentalTissues) {
		this.opdOralMedicineDentalTissues = opdOralMedicineDentalTissues;
	}

	public void addToOpdOralMedicineDentalTissues (jkt.hms.masters.business.OpdOralMedicineDentalTissue opdOralMedicineDentalTissue) {
		if (null == getOpdOralMedicineDentalTissues()) setOpdOralMedicineDentalTissues(new java.util.TreeSet<jkt.hms.masters.business.OpdOralMedicineDentalTissue>());
		getOpdOralMedicineDentalTissues().add(opdOralMedicineDentalTissue);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOralMedicineDental)) return false;
		else {
			jkt.hms.masters.business.OpdOralMedicineDental opdOralMedicineDental = (jkt.hms.masters.business.OpdOralMedicineDental) obj;
			if (null == this.getId() || null == opdOralMedicineDental.getId()) return false;
			else return (this.getId().equals(opdOralMedicineDental.getId()));
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