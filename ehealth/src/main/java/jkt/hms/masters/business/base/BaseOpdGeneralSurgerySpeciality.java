package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_general_surgery_speciality table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_general_surgery_speciality"
 */

public abstract class BaseOpdGeneralSurgerySpeciality  implements Serializable {

	public static String REF = "OpdGeneralSurgerySpeciality";
	public static String PROP_DISTENSION_DURATION = "DistensionDuration";
	public static String PROP_LESION_PLANE = "LesionPlane";
	public static String PROP_EDEMA = "Edema";
	public static String PROP_TYPE_OF_DELIVERY = "TypeOfDelivery";
	public static String PROP_LOCAL_LYMPH_SITE = "LocalLymphSite";
	public static String PROP_MALENA_DURATION = "MalenaDuration";
	public static String PROP_BRUIT = "Bruit";
	public static String PROP_LESION_TYPE = "LesionType";
	public static String PROP_RESPIRATORY_CREPITAIONS = "RespiratoryCrepitaions";
	public static String PROP_DISCOLORATION_SITE = "DiscolorationSite";
	public static String PROP_GASTRO_INTESTINAL_TENDERNESS = "GastroIntestinalTenderness";
	public static String PROP_LESION_MOBILITY = "LesionMobility";
	public static String PROP_INFERTITILITY = "Infertitility";
	public static String PROP_LESION_SURFACE = "LesionSurface";
	public static String PROP_ALCOHOL_DAY = "AlcoholDay";
	public static String PROP_PAIN_SITE = "PainSite";
	public static String PROP_TRAUMA = "Trauma";
	public static String PROP_ORAL_CAVITY = "OralCavity";
	public static String PROP_SWELLINGS = "Swellings";
	public static String PROP_OTHER_ADDICTION_VALUE = "OtherAddictionValue";
	public static String PROP_LESION = "Lesion";
	public static String PROP_DILATED_VEINS_DURATION = "DilatedVeinsDuration";
	public static String PROP_ASA_GRADE = "AsaGrade";
	public static String PROP_GENERALIZED_LYMPHADENOPATHY_TXT = "GeneralizedLymphadenopathyTxt";
	public static String PROP_LOCAL_LYMPH_OTHERS = "LocalLymphOthers";
	public static String PROP_BONES = "Bones";
	public static String PROP_AIRENTRY = "Airentry";
	public static String PROP_LOCAL_LYMPH = "LocalLymph";
	public static String PROP_PAIN = "Pain";
	public static String PROP_DYSPHAGIA_TYPE = "DysphagiaType";
	public static String PROP_CLUBBING = "Clubbing";
	public static String PROP_CLAUDICATION_REFERRAL = "ClaudicationReferral";
	public static String PROP_VERBAL_RESPONSE = "VerbalResponse";
	public static String PROP_JAUNDICE_DURATION = "JaundiceDuration";
	public static String PROP_LOCAL_LYMPH_MOBILITY = "LocalLymphMobility";
	public static String PROP_GASTRO_INTESTINAL_BRUIT_TYPE = "GastroIntestinalBruitType";
	public static String PROP_TRAUMA_DURATION = "TraumaDuration";
	public static String PROP_DILATED_VEINS_SITE = "DilatedVeinsSite";
	public static String PROP_LESION_SHAPE = "LesionShape";
	public static String PROP_URINARY_OBSTRUCTION_DURATION = "UrinaryObstructionDuration";
	public static String PROP_URINARY_OBSTRUCTION_CONTINUOS = "UrinaryObstructionContinuos";
	public static String PROP_THROAT = "Throat";
	public static String PROP_PAIN_REFERRAL = "PainReferral";
	public static String PROP_JAUNDICE = "Jaundice";
	public static String PROP_LOCAL_NERVES_OTHERS = "LocalNervesOthers";
	public static String PROP_PULSE_RHYTHM = "PulseRhythm";
	public static String PROP_MUMBER_DAY = "MumberDay";
	public static String PROP_LOCAL_JOINTS = "LocalJoints";
	public static String PROP_LESION_SIZE = "LesionSize";
	public static String PROP_COUGH_DURATION = "CoughDuration";
	public static String PROP_SPINE = "Spine";
	public static String PROP_PALLOR = "Pallor";
	public static String PROP_ASCITES = "Ascites";
	public static String PROP_HAEMATOCHEZIA_INITIAL = "HaematocheziaInitial";
	public static String PROP_OTHERS_DATA = "OthersData";
	public static String PROP_TRAUMA_TYPE = "TraumaType";
	public static String PROP_SWELLING_CHECK = "SwellingCheck";
	public static String PROP_HAEMETEMESIS_INITIAL = "HaemetemesisInitial";
	public static String PROP_LOCAL_VESSEL_FLOW_VOLUME = "LocalVesselFlowVolume";
	public static String PROP_SCALP = "Scalp";
	public static String PROP_PULSE_VESSEL_WALL = "PulseVesselWall";
	public static String PROP_RESPIRATION_TYPE = "RespirationType";
	public static String PROP_SMOKING_DAY = "SmokingDay";
	public static String PROP_DISTENSION_SITE = "DistensionSite";
	public static String PROP_SWELLING_SITE = "SwellingSite";
	public static String PROP_CYCLELENGTH = "Cyclelength";
	public static String PROP_VOMITING_DURATION = "VomitingDuration";
	public static String PROP_LOCAL_VESSEL_OTHERS = "LocalVesselOthers";
	public static String PROP_RESPIRATORY_TENDERNESS_TYPE = "RespiratoryTendernessType";
	public static String PROP_HEARTBURN_TYPE = "HeartburnType";
	public static String PROP_CYANOSIS = "Cyanosis";
	public static String PROP_JVP = "Jvp";
	public static String PROP_HEARTBURN = "Heartburn";
	public static String PROP_RESPIRATION_RATE = "RespirationRate";
	public static String PROP_PAIN_TYPE = "PainType";
	public static String PROP_LESION_OTHERS = "LesionOthers";
	public static String PROP_SWELLING_SHAPE = "SwellingShape";
	public static String PROP_CLAUDICATION_SHIFTING = "ClaudicationShifting";
	public static String PROP_ULCER = "Ulcer";
	public static String PROP_DISCHARGE_TYPE = "DischargeType";
	public static String PROP_LESION_SITE = "LesionSite";
	public static String PROP_ABDOMEN = "Abdomen";
	public static String PROP_RHONCHI = "Rhonchi";
	public static String PROP_LOCAL_JOINTS_MOVEMENTS = "LocalJointsMovements";
	public static String PROP_LOCAL_LYMPH_TYPE = "LocalLymphType";
	public static String PROP_ULCER_GROWTH_RATE = "UlcerGrowthRate";
	public static String PROP_BLEEDING_SITE = "BleedingSite";
	public static String PROP_ICTERUS = "Icterus";
	public static String PROP_LOCAL_LYMPH_SURFACE = "LocalLymphSurface";
	public static String PROP_LOCAL_NERVES_SENSORY = "LocalNervesSensory";
	public static String PROP_PERSONAL_HABITS = "PersonalHabits";
	public static String PROP_MENOPAUSE = "Menopause";
	public static String PROP_LESION_CONSISTENCY = "LesionConsistency";
	public static String PROP_HAEMATOCHEZIA_DURATION = "HaematocheziaDuration";
	public static String PROP_LACTATION_DURATION = "LactationDuration";
	public static String PROP_ULCER_SHAPE = "UlcerShape";
	public static String PROP_SWELLING = "Swelling";
	public static String PROP_APPETITE = "Appetite";
	public static String PROP_CLAUDICATION_TYPE = "ClaudicationType";
	public static String PROP_SP = "Sp";
	public static String PROP_LOCAL_VESSEL = "LocalVessel";
	public static String PROP_RESPIRATORY_RHONCHI_TYPE = "RespiratoryRhonchiType";
	public static String PROP_SOUNDS = "Sounds";
	public static String PROP_DYSPNEA = "Dyspnea";
	public static String PROP_PAIN_DURATION = "PainDuration";
	public static String PROP_CLAUDICATION_RADIATION = "ClaudicationRadiation";
	public static String PROP_BLADDER = "Bladder";
	public static String PROP_HAEMETEMESIS = "Haemetemesis";
	public static String PROP_SKIN = "Skin";
	public static String PROP_GENITALIA = "Genitalia";
	public static String PROP_SWELLING_DURATION = "SwellingDuration";
	public static String PROP_GASTRO_INTESTINAL_BRUIT_SITE = "GastroIntestinalBruitSite";
	public static String PROP_DISCHARGE_DURATION = "DischargeDuration";
	public static String PROP_SMOKING_VALUE = "SmokingValue";
	public static String PROP_BP = "Bp";
	public static String PROP_CONSTIPATION = "Constipation";
	public static String PROP_GCS_TOTAL = "GcsTotal";
	public static String PROP_DISCHARGE_SITE = "DischargeSite";
	public static String PROP_HIN = "Hin";
	public static String PROP_GASTRO_INTESTINAL_TENDERNESS_TYPE = "GastroIntestinalTendernessType";
	public static String PROP_BMI = "Bmi";
	public static String PROP_RESPIRATORY_CREPITAIONS_TYPE = "RespiratoryCrepitaionsType";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_SKULL = "Skull";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_RESPIRATORY_TENDERNESS_SITE = "RespiratoryTendernessSite";
	public static String PROP_VESSELS = "Vessels";
	public static String PROP_CLAUDICATION = "Claudication";
	public static String PROP_DISCOLORATION_DURATION = "DiscolorationDuration";
	public static String PROP_RESPIRATION_RHYTHM = "RespirationRhythm";
	public static String PROP_RENAL_ANGLES = "RenalAngles";
	public static String PROP_COUGH = "Cough";
	public static String PROP_ALCOHOL_VALUE = "AlcoholValue";
	public static String PROP_MUSCULOSKELETAL_MUSCLE_POWER = "MusculoskeletalMusclePower";
	public static String PROP_DISCOLORATION = "Discoloration";
	public static String PROP_REFLEXES = "Reflexes";
	public static String PROP_GENERALIZED_LYMPHADENOPATHY = "GeneralizedLymphadenopathy";
	public static String PROP_DYSURIA_TYPE = "DysuriaType";
	public static String PROP_RESPIRATORY_CREPITAIONS_SITE = "RespiratoryCrepitaionsSite";
	public static String PROP_SWELLING_SIZE = "SwellingSize";
	public static String PROP_SMOKING_NUMBER = "SmokingNumber";
	public static String PROP_DIET = "Diet";
	public static String PROP_PR_EXAMINATION = "PrExamination";
	public static String PROP_FLOWDAYS = "Flowdays";
	public static String PROP_PLAN = "Plan";
	public static String PROP_PAIN_RADIATION = "PainRadiation";
	public static String PROP_VOMITING = "Vomiting";
	public static String PROP_HAEMATOCHEZIA = "Haematochezia";
	public static String PROP_BOWEL = "Bowel";
	public static String PROP_LOCAL_LYMPH_SIZE = "LocalLymphSize";
	public static String PROP_ULCER_SIZE = "UlcerSize";
	public static String PROP_CLAUDICATION_SITE = "ClaudicationSite";
	public static String PROP_MM = "Mm";
	public static String PROP_HEAD_INJURY_CLASSIFICATION = "HeadInjuryClassification";
	public static String PROP_MENARCHE = "Menarche";
	public static String PROP_NAUSEA = "Nausea";
	public static String PROP_VOMITING_BILIOUS = "VomitingBilious";
	public static String PROP_TONGUE = "Tongue";
	public static String PROP_TRAUBE_SPACE = "TraubeSpace";
	public static String PROP_LIVER_CHECK = "LiverCheck";
	public static String PROP_HRT = "Hrt";
	public static String PROP_LOCAL_LYMPH_CONSISTENCY = "LocalLymphConsistency";
	public static String PROP_LOCAL_NERVES = "LocalNerves";
	public static String PROP_PRESENTING_COMPLAINTS = "PresentingComplaints";
	public static String PROP_FLUID_THRILL = "FluidThrill";
	public static String PROP_SLEEP = "Sleep";
	public static String PROP_LMP_DATE = "LmpDate";
	public static String PROP_LIVER = "Liver";
	public static String PROP_FEVER_DURATION = "FeverDuration";
	public static String PROP_HAEMETEMESIS_DURATION = "HaemetemesisDuration";
	public static String PROP_CONSTIPATION_DURATION = "ConstipationDuration";
	public static String PROP_DYSPNEA_TYPE = "DyspneaType";
	public static String PROP_CLAUDICATION_DURATION = "ClaudicationDuration";
	public static String PROP_LOCAL_VESSEL_BRUIT = "LocalVesselBruit";
	public static String PROP_EDEMA_TXT = "EdemaTxt";
	public static String PROP_VOMITING_TIME_AFTER_FOOD_INTAKE = "VomitingTimeAfterFoodIntake";
	public static String PROP_PPS = "Pps";
	public static String PROP_SMOKING = "Smoking";
	public static String PROP_NUMBER_OF_CHILDREN = "NumberOfChildren";
	public static String PROP_COUGH_TYPE = "CoughType";
	public static String PROP_NAUSEA_DURATION = "NauseaDuration";
	public static String PROP_NAUSEA_TYPE = "NauseaType";
	public static String PROP_BLEEDING_DURATION = "BleedingDuration";
	public static String PROP_RESPIRATORY_RHONCHI_SITE = "RespiratoryRhonchiSite";
	public static String PROP_VOMITING_PROJECTILE = "VomitingProjectile";
	public static String PROP_GCS = "Gcs";
	public static String PROP_PAIN_SHIFTING = "PainShifting";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_DYSPHAGIA = "Dysphagia";
	public static String PROP_LOCAL_NERVES_MOTOR = "LocalNervesMotor";
	public static String PROP_BLEEDING = "Bleeding";
	public static String PROP_ID = "Id";
	public static String PROP_HEARTBURN_DURATION = "HeartburnDuration";
	public static String PROP_PULSE_VOLUME = "PulseVolume";
	public static String PROP_ULCER_SITE = "UlcerSite";
	public static String PROP_DYSPHAGIA_DURATION = "DysphagiaDuration";
	public static String PROP_FEVER_TYPE = "FeverType";
	public static String PROP_CARDIOMEGALY = "Cardiomegaly";
	public static String PROP_ALCOHOL_VOLUME = "AlcoholVolume";
	public static String PROP_MOTOR_RESPONSE = "MotorResponse";
	public static String PROP_DISCHARGE = "Discharge";
	public static String PROP_URINARY_OBSTRUCTION = "UrinaryObstruction";
	public static String PROP_MALENA = "Malena";
	public static String PROP_GENERAL_EXAMINATION = "GeneralExamination";
	public static String PROP_RESPIRATORY_TENDERNESS = "RespiratoryTenderness";
	public static String PROP_OCP = "Ocp";
	public static String PROP_CONSTIPATION_PROGRESSIVE_INTERMITTENT = "ConstipationProgressiveIntermittent";
	public static String PROP_SWELLING_GROWTH_RATE = "SwellingGrowthRate";
	public static String PROP_FEVER = "Fever";
	public static String PROP_NERVES = "Nerves";
	public static String PROP_GENERALIZED_LYMPHADENOPATHY_TXT_VALUE = "GeneralizedLymphadenopathyTxtValue";
	public static String PROP_DYSURIA_DURATION = "DysuriaDuration";
	public static String PROP_MUSCULOSKELETAL_JOINTS = "MusculoskeletalJoints";
	public static String PROP_DILATED_VEINS = "DilatedVeins";
	public static String PROP_CRANIAL_NERVES = "CranialNerves";
	public static String PROP_DISTENSION = "Distension";
	public static String PROP_JAUNDICE_PROGRESSIVE_INTERMITTENT = "JaundiceProgressiveIntermittent";
	public static String PROP_LOCAL_LYMPH_SHAPE = "LocalLymphShape";
	public static String PROP_GASTRO_INTESTINAL_TENDERNESS_SITE = "GastroIntestinalTendernessSite";
	public static String PROP_EXTERNAL_GENITALIA = "ExternalGenitalia";
	public static String PROP_ULCER_DURATION = "UlcerDuration";
	public static String PROP_CONSTIPATION_ABSOLUTE_RELATIVE = "ConstipationAbsoluteRelative";
	public static String PROP_DYSURIA = "Dysuria";
	public static String PROP_JOINTS = "Joints";
	public static String PROP_DYSPHAGIA_SOLIDS = "DysphagiaSolids";
	public static String PROP_CLAUDICATION_DISTANCE = "ClaudicationDistance";
	public static String PROP_EYE_OPENING_RESPONSE = "EyeOpeningResponse";
	public static String PROP_NAILS = "Nails";
	public static String PROP_OTHER_ADDICTIONS = "OtherAddictions";
	public static String PROP_PULSE_RATE = "PulseRate";
	public static String PROP_DYSPNEA_DURATION = "DyspneaDuration";


	// constructors
	public BaseOpdGeneralSurgerySpeciality () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGeneralSurgerySpeciality (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bleedingDuration;
	private java.lang.String bleedingSite;
	private java.lang.String claudicationDuration;
	private java.lang.String claudicationSite;
	private java.lang.String claudicationType;
	private java.lang.String claudicationShifting;
	private java.lang.String claudicationReferral;
	private java.lang.String claudicationDistance;
	private java.lang.String constipationAbsoluteRelative;
	private java.lang.String constipationProgressiveIntermittent;
	private java.lang.String coughDuration;
	private java.lang.String coughType;
	private java.lang.String dilatedVeinsDuration;
	private java.lang.String dilatedVeinsSite;
	private java.lang.String dischargeDuration;
	private java.lang.String dischargeSite;
	private java.lang.String dischargeType;
	private java.lang.String discolorationDuration;
	private java.lang.String discolorationSite;
	private java.lang.String distensionDuration;
	private java.lang.String distensionSite;
	private java.lang.String dysphagiaDuration;
	private java.lang.String dysphagiaType;
	private java.lang.String dysphagiaSolids;
	private java.lang.String dyspneaDuration;
	private java.lang.String dyspneaType;
	private java.lang.String dysuriaDuration;
	private java.lang.String dysuriaType;
	private java.lang.String feverDuration;
	private java.lang.String feverType;
	private java.lang.String haematocheziaDuration;
	private java.lang.String haematocheziaInitial;
	private java.lang.String haemetemesisDuration;
	private java.lang.String haemetemesisInitial;
	private java.lang.String heartburnDuration;
	private java.lang.String heartburnType;
	private java.lang.String jaundiceDuration;
	private java.lang.String jaundiceProgressiveIntermittent;
	private java.lang.String malenaDuration;
	private java.lang.String nauseaDuration;
	private java.lang.String nauseaType;
	private java.lang.String painDuration;
	private java.lang.String painSite;
	private java.lang.String painType;
	private java.lang.String painRadiation;
	private java.lang.String painShifting;
	private java.lang.String painReferral;
	private java.lang.String swellingDuration;
	private java.lang.String swellingSite;
	private java.lang.String swellingSize;
	private java.lang.String swellingShape;
	private java.lang.String swellingGrowthRate;
	private java.lang.String traumaDuration;
	private java.lang.String traumaType;
	private java.lang.String ulcerDuration;
	private java.lang.String ulcerSite;
	private java.lang.String ulcerSize;
	private java.lang.String ulcerShape;
	private java.lang.String ulcerGrowthRate;
	private java.lang.String urinaryObstructionDuration;
	private java.lang.String urinaryObstructionContinuos;
	private java.lang.String vomitingDuration;
	private java.lang.String vomitingProjectile;
	private java.lang.String vomitingTimeAfterFoodIntake;
	private java.lang.String vomitingBilious;
	private java.lang.String diet;
	private java.lang.String sleep;
	private java.lang.String appetite;
	private java.lang.String bowel;
	private java.lang.String bladder;
	private java.lang.String smoking;
	private java.lang.String mumberDay;
	private java.lang.String alcoholVolume;
	private java.lang.String alcoholDay;
	private java.lang.String otherAddictions;
	private java.lang.String menarche;
	private java.lang.String cyclelength;
	private java.lang.String flowdays;
	private java.lang.String menopause;
	private java.lang.String numberOfChildren;
	private java.lang.String lactationDuration;
	private java.lang.String pps;
	private java.lang.String hrt;
	private java.lang.String pallor;
	private java.lang.String icterus;
	private java.lang.String cyanosis;
	private java.lang.String clubbing;
	private java.lang.String generalizedLymphadenopathy;
	private java.lang.String generalizedLymphadenopathyTxt;
	private java.lang.String edema;
	private java.lang.String edemaTxt;
	private java.lang.String bones;
	private java.lang.String genitalia;
	private java.lang.String joints;
	private java.lang.String nails;
	private java.lang.String nerves;
	private java.lang.String scalp;
	private java.lang.String skin;
	private java.lang.String skull;
	private java.lang.String spine;
	private java.lang.String vessels;
	private java.lang.String height;
	private java.lang.String weight;
	private java.lang.String bmi;
	private java.lang.String bp;
	private java.lang.String mm;
	private java.lang.String jvp;
	private java.lang.String sp;
	private java.lang.String pulseRate;
	private java.lang.String pulseRhythm;
	private java.lang.String pulseVolume;
	private java.lang.String pulseVesselWall;
	private java.lang.String respirationRate;
	private java.lang.String respirationRhythm;
	private java.lang.String respirationType;
	private java.lang.String asaGrade;
	private java.lang.String lesion;
	private java.lang.String lesionType;
	private java.lang.String lesionSite;
	private java.lang.String lesionSize;
	private java.lang.String lesionSurface;
	private java.lang.String lesionShape;
	private java.lang.String lesionConsistency;
	private java.lang.String lesionMobility;
	private java.lang.String lesionPlane;
	private java.lang.String lesionOthers;
	private java.lang.String localLymph;
	private java.lang.String localLymphType;
	private java.lang.String localLymphSite;
	private java.lang.String localLymphSize;
	private java.lang.String localLymphSurface;
	private java.lang.String localLymphShape;
	private java.lang.String localLymphConsistency;
	private java.lang.String localLymphMobility;
	private java.lang.String localLymphOthers;
	private java.lang.String localVessel;
	private java.lang.String localVesselFlowVolume;
	private java.lang.String localVesselBruit;
	private java.lang.String localVesselOthers;
	private java.lang.String localNerves;
	private java.lang.String localNervesSensory;
	private java.lang.String localNervesMotor;
	private java.lang.String localNervesOthers;
	private java.lang.String localJoints;
	private java.lang.String localJointsMovements;
	private java.lang.String oralCavity;
	private java.lang.String tongue;
	private java.lang.String throat;
	private java.lang.String abdomen;
	private java.lang.String gastroIntestinalTenderness;
	private java.lang.String gastroIntestinalTendernessSite;
	private java.lang.String gastroIntestinalTendernessType;
	private java.lang.String swellings;
	private java.lang.String liver;
	private java.lang.String renalAngles;
	private java.lang.String traubeSpace;
	private java.lang.String ascites;
	private java.lang.String bruit;
	private java.lang.String gastroIntestinalBruitSite;
	private java.lang.String gastroIntestinalBruitType;
	private java.lang.String prExamination;
	private java.lang.String externalGenitalia;
	private java.lang.String airentry;
	private java.lang.String respiratoryTenderness;
	private java.lang.String respiratoryTendernessType;
	private java.lang.String respiratoryTendernessSite;
	private java.lang.String rhonchi;
	private java.lang.String respiratoryRhonchiSite;
	private java.lang.String respiratoryRhonchiType;
	private java.lang.String respiratoryCrepitaions;
	private java.lang.String respiratoryCrepitaionsSite;
	private java.lang.String respiratoryCrepitaionsType;
	private java.lang.String sounds;
	private java.lang.String cardiomegaly;
	private java.lang.String gcs;
	private java.lang.String gcsTotal;
	private java.lang.String cranialNerves;
	private java.lang.String reflexes;
	private java.lang.String musculoskeletalMusclePower;
	private java.lang.String musculoskeletalJoints;
	private java.lang.String plan;
	private java.lang.String claudicationRadiation;
	private java.lang.String constipationDuration;
	private java.lang.String smokingNumber;
	private java.lang.String smokingDay;
	private java.util.Date lmpDate;
	private java.lang.String ocp;
	private java.lang.String infertitility;
	private java.lang.String generalExamination;
	private java.lang.String bleeding;
	private java.lang.String claudication;
	private java.lang.String constipation;
	private java.lang.String cough;
	private java.lang.String dilatedVeins;
	private java.lang.String discharge;
	private java.lang.String discoloration;
	private java.lang.String distension;
	private java.lang.String dysphagia;
	private java.lang.String dyspnea;
	private java.lang.String dysuria;
	private java.lang.String fever;
	private java.lang.String haematochezia;
	private java.lang.String haemetemesis;
	private java.lang.String heartburn;
	private java.lang.String jaundice;
	private java.lang.String malena;
	private java.lang.String nausea;
	private java.lang.String pain;
	private java.lang.String swelling;
	private java.lang.String trauma;
	private java.lang.String ulcer;
	private java.lang.String urinaryObstruction;
	private java.lang.String vomiting;
	private java.lang.String personalHabits;
	private java.lang.String smokingValue;
	private java.lang.String alcoholValue;
	private java.lang.String otherAddictionValue;
	private java.lang.String swellingCheck;
	private java.lang.String liverCheck;
	private java.lang.String eyeOpeningResponse;
	private java.lang.String verbalResponse;
	private java.lang.String motorResponse;
	private java.lang.String headInjuryClassification;
	private java.lang.String generalizedLymphadenopathyTxtValue;
	private java.lang.String othersData;
	private java.lang.String fluidThrill;
	private java.lang.String presentingComplaints;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.MasDeliveryType typeOfDelivery;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="general_surgery_id"
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
	 * Return the value associated with the column: bleeding_duration
	 */
	public java.lang.String getBleedingDuration () {
		return bleedingDuration;
	}

	/**
	 * Set the value related to the column: bleeding_duration
	 * @param bleedingDuration the bleeding_duration value
	 */
	public void setBleedingDuration (java.lang.String bleedingDuration) {
		this.bleedingDuration = bleedingDuration;
	}



	/**
	 * Return the value associated with the column: bleeding_site
	 */
	public java.lang.String getBleedingSite () {
		return bleedingSite;
	}

	/**
	 * Set the value related to the column: bleeding_site
	 * @param bleedingSite the bleeding_site value
	 */
	public void setBleedingSite (java.lang.String bleedingSite) {
		this.bleedingSite = bleedingSite;
	}



	/**
	 * Return the value associated with the column: claudication_duration
	 */
	public java.lang.String getClaudicationDuration () {
		return claudicationDuration;
	}

	/**
	 * Set the value related to the column: claudication_duration
	 * @param claudicationDuration the claudication_duration value
	 */
	public void setClaudicationDuration (java.lang.String claudicationDuration) {
		this.claudicationDuration = claudicationDuration;
	}



	/**
	 * Return the value associated with the column: claudication_site
	 */
	public java.lang.String getClaudicationSite () {
		return claudicationSite;
	}

	/**
	 * Set the value related to the column: claudication_site
	 * @param claudicationSite the claudication_site value
	 */
	public void setClaudicationSite (java.lang.String claudicationSite) {
		this.claudicationSite = claudicationSite;
	}



	/**
	 * Return the value associated with the column: claudication_type
	 */
	public java.lang.String getClaudicationType () {
		return claudicationType;
	}

	/**
	 * Set the value related to the column: claudication_type
	 * @param claudicationType the claudication_type value
	 */
	public void setClaudicationType (java.lang.String claudicationType) {
		this.claudicationType = claudicationType;
	}



	/**
	 * Return the value associated with the column: claudication_shifting
	 */
	public java.lang.String getClaudicationShifting () {
		return claudicationShifting;
	}

	/**
	 * Set the value related to the column: claudication_shifting
	 * @param claudicationShifting the claudication_shifting value
	 */
	public void setClaudicationShifting (java.lang.String claudicationShifting) {
		this.claudicationShifting = claudicationShifting;
	}



	/**
	 * Return the value associated with the column: claudication_referral
	 */
	public java.lang.String getClaudicationReferral () {
		return claudicationReferral;
	}

	/**
	 * Set the value related to the column: claudication_referral
	 * @param claudicationReferral the claudication_referral value
	 */
	public void setClaudicationReferral (java.lang.String claudicationReferral) {
		this.claudicationReferral = claudicationReferral;
	}



	/**
	 * Return the value associated with the column: claudication_distance
	 */
	public java.lang.String getClaudicationDistance () {
		return claudicationDistance;
	}

	/**
	 * Set the value related to the column: claudication_distance
	 * @param claudicationDistance the claudication_distance value
	 */
	public void setClaudicationDistance (java.lang.String claudicationDistance) {
		this.claudicationDistance = claudicationDistance;
	}



	/**
	 * Return the value associated with the column: constipation_absolute_relative
	 */
	public java.lang.String getConstipationAbsoluteRelative () {
		return constipationAbsoluteRelative;
	}

	/**
	 * Set the value related to the column: constipation_absolute_relative
	 * @param constipationAbsoluteRelative the constipation_absolute_relative value
	 */
	public void setConstipationAbsoluteRelative (java.lang.String constipationAbsoluteRelative) {
		this.constipationAbsoluteRelative = constipationAbsoluteRelative;
	}



	/**
	 * Return the value associated with the column: constipation_progressive_intermittent
	 */
	public java.lang.String getConstipationProgressiveIntermittent () {
		return constipationProgressiveIntermittent;
	}

	/**
	 * Set the value related to the column: constipation_progressive_intermittent
	 * @param constipationProgressiveIntermittent the constipation_progressive_intermittent value
	 */
	public void setConstipationProgressiveIntermittent (java.lang.String constipationProgressiveIntermittent) {
		this.constipationProgressiveIntermittent = constipationProgressiveIntermittent;
	}



	/**
	 * Return the value associated with the column: cough_duration
	 */
	public java.lang.String getCoughDuration () {
		return coughDuration;
	}

	/**
	 * Set the value related to the column: cough_duration
	 * @param coughDuration the cough_duration value
	 */
	public void setCoughDuration (java.lang.String coughDuration) {
		this.coughDuration = coughDuration;
	}



	/**
	 * Return the value associated with the column: cough_type
	 */
	public java.lang.String getCoughType () {
		return coughType;
	}

	/**
	 * Set the value related to the column: cough_type
	 * @param coughType the cough_type value
	 */
	public void setCoughType (java.lang.String coughType) {
		this.coughType = coughType;
	}



	/**
	 * Return the value associated with the column: dilated_veins_duration
	 */
	public java.lang.String getDilatedVeinsDuration () {
		return dilatedVeinsDuration;
	}

	/**
	 * Set the value related to the column: dilated_veins_duration
	 * @param dilatedVeinsDuration the dilated_veins_duration value
	 */
	public void setDilatedVeinsDuration (java.lang.String dilatedVeinsDuration) {
		this.dilatedVeinsDuration = dilatedVeinsDuration;
	}



	/**
	 * Return the value associated with the column: dilated_veins_site
	 */
	public java.lang.String getDilatedVeinsSite () {
		return dilatedVeinsSite;
	}

	/**
	 * Set the value related to the column: dilated_veins_site
	 * @param dilatedVeinsSite the dilated_veins_site value
	 */
	public void setDilatedVeinsSite (java.lang.String dilatedVeinsSite) {
		this.dilatedVeinsSite = dilatedVeinsSite;
	}



	/**
	 * Return the value associated with the column: discharge_duration
	 */
	public java.lang.String getDischargeDuration () {
		return dischargeDuration;
	}

	/**
	 * Set the value related to the column: discharge_duration
	 * @param dischargeDuration the discharge_duration value
	 */
	public void setDischargeDuration (java.lang.String dischargeDuration) {
		this.dischargeDuration = dischargeDuration;
	}



	/**
	 * Return the value associated with the column: discharge_site
	 */
	public java.lang.String getDischargeSite () {
		return dischargeSite;
	}

	/**
	 * Set the value related to the column: discharge_site
	 * @param dischargeSite the discharge_site value
	 */
	public void setDischargeSite (java.lang.String dischargeSite) {
		this.dischargeSite = dischargeSite;
	}



	/**
	 * Return the value associated with the column: discharge_type
	 */
	public java.lang.String getDischargeType () {
		return dischargeType;
	}

	/**
	 * Set the value related to the column: discharge_type
	 * @param dischargeType the discharge_type value
	 */
	public void setDischargeType (java.lang.String dischargeType) {
		this.dischargeType = dischargeType;
	}



	/**
	 * Return the value associated with the column: discoloration_duration
	 */
	public java.lang.String getDiscolorationDuration () {
		return discolorationDuration;
	}

	/**
	 * Set the value related to the column: discoloration_duration
	 * @param discolorationDuration the discoloration_duration value
	 */
	public void setDiscolorationDuration (java.lang.String discolorationDuration) {
		this.discolorationDuration = discolorationDuration;
	}



	/**
	 * Return the value associated with the column: discoloration_site
	 */
	public java.lang.String getDiscolorationSite () {
		return discolorationSite;
	}

	/**
	 * Set the value related to the column: discoloration_site
	 * @param discolorationSite the discoloration_site value
	 */
	public void setDiscolorationSite (java.lang.String discolorationSite) {
		this.discolorationSite = discolorationSite;
	}



	/**
	 * Return the value associated with the column: distension_duration
	 */
	public java.lang.String getDistensionDuration () {
		return distensionDuration;
	}

	/**
	 * Set the value related to the column: distension_duration
	 * @param distensionDuration the distension_duration value
	 */
	public void setDistensionDuration (java.lang.String distensionDuration) {
		this.distensionDuration = distensionDuration;
	}



	/**
	 * Return the value associated with the column: distension_site
	 */
	public java.lang.String getDistensionSite () {
		return distensionSite;
	}

	/**
	 * Set the value related to the column: distension_site
	 * @param distensionSite the distension_site value
	 */
	public void setDistensionSite (java.lang.String distensionSite) {
		this.distensionSite = distensionSite;
	}



	/**
	 * Return the value associated with the column: dysphagia_duration
	 */
	public java.lang.String getDysphagiaDuration () {
		return dysphagiaDuration;
	}

	/**
	 * Set the value related to the column: dysphagia_duration
	 * @param dysphagiaDuration the dysphagia_duration value
	 */
	public void setDysphagiaDuration (java.lang.String dysphagiaDuration) {
		this.dysphagiaDuration = dysphagiaDuration;
	}



	/**
	 * Return the value associated with the column: dysphagia_type
	 */
	public java.lang.String getDysphagiaType () {
		return dysphagiaType;
	}

	/**
	 * Set the value related to the column: dysphagia_type
	 * @param dysphagiaType the dysphagia_type value
	 */
	public void setDysphagiaType (java.lang.String dysphagiaType) {
		this.dysphagiaType = dysphagiaType;
	}



	/**
	 * Return the value associated with the column: dysphagia_solids
	 */
	public java.lang.String getDysphagiaSolids () {
		return dysphagiaSolids;
	}

	/**
	 * Set the value related to the column: dysphagia_solids
	 * @param dysphagiaSolids the dysphagia_solids value
	 */
	public void setDysphagiaSolids (java.lang.String dysphagiaSolids) {
		this.dysphagiaSolids = dysphagiaSolids;
	}



	/**
	 * Return the value associated with the column: dyspnea_duration
	 */
	public java.lang.String getDyspneaDuration () {
		return dyspneaDuration;
	}

	/**
	 * Set the value related to the column: dyspnea_duration
	 * @param dyspneaDuration the dyspnea_duration value
	 */
	public void setDyspneaDuration (java.lang.String dyspneaDuration) {
		this.dyspneaDuration = dyspneaDuration;
	}



	/**
	 * Return the value associated with the column: dyspnea_type
	 */
	public java.lang.String getDyspneaType () {
		return dyspneaType;
	}

	/**
	 * Set the value related to the column: dyspnea_type
	 * @param dyspneaType the dyspnea_type value
	 */
	public void setDyspneaType (java.lang.String dyspneaType) {
		this.dyspneaType = dyspneaType;
	}



	/**
	 * Return the value associated with the column: dysuria_duration
	 */
	public java.lang.String getDysuriaDuration () {
		return dysuriaDuration;
	}

	/**
	 * Set the value related to the column: dysuria_duration
	 * @param dysuriaDuration the dysuria_duration value
	 */
	public void setDysuriaDuration (java.lang.String dysuriaDuration) {
		this.dysuriaDuration = dysuriaDuration;
	}



	/**
	 * Return the value associated with the column: dysuria_type
	 */
	public java.lang.String getDysuriaType () {
		return dysuriaType;
	}

	/**
	 * Set the value related to the column: dysuria_type
	 * @param dysuriaType the dysuria_type value
	 */
	public void setDysuriaType (java.lang.String dysuriaType) {
		this.dysuriaType = dysuriaType;
	}



	/**
	 * Return the value associated with the column: fever_duration
	 */
	public java.lang.String getFeverDuration () {
		return feverDuration;
	}

	/**
	 * Set the value related to the column: fever_duration
	 * @param feverDuration the fever_duration value
	 */
	public void setFeverDuration (java.lang.String feverDuration) {
		this.feverDuration = feverDuration;
	}



	/**
	 * Return the value associated with the column: fever_type
	 */
	public java.lang.String getFeverType () {
		return feverType;
	}

	/**
	 * Set the value related to the column: fever_type
	 * @param feverType the fever_type value
	 */
	public void setFeverType (java.lang.String feverType) {
		this.feverType = feverType;
	}



	/**
	 * Return the value associated with the column: haematochezia_duration
	 */
	public java.lang.String getHaematocheziaDuration () {
		return haematocheziaDuration;
	}

	/**
	 * Set the value related to the column: haematochezia_duration
	 * @param haematocheziaDuration the haematochezia_duration value
	 */
	public void setHaematocheziaDuration (java.lang.String haematocheziaDuration) {
		this.haematocheziaDuration = haematocheziaDuration;
	}



	/**
	 * Return the value associated with the column: haematochezia_initial
	 */
	public java.lang.String getHaematocheziaInitial () {
		return haematocheziaInitial;
	}

	/**
	 * Set the value related to the column: haematochezia_initial
	 * @param haematocheziaInitial the haematochezia_initial value
	 */
	public void setHaematocheziaInitial (java.lang.String haematocheziaInitial) {
		this.haematocheziaInitial = haematocheziaInitial;
	}



	/**
	 * Return the value associated with the column: haemetemesis_duration
	 */
	public java.lang.String getHaemetemesisDuration () {
		return haemetemesisDuration;
	}

	/**
	 * Set the value related to the column: haemetemesis_duration
	 * @param haemetemesisDuration the haemetemesis_duration value
	 */
	public void setHaemetemesisDuration (java.lang.String haemetemesisDuration) {
		this.haemetemesisDuration = haemetemesisDuration;
	}



	/**
	 * Return the value associated with the column: haemetemesis_initial
	 */
	public java.lang.String getHaemetemesisInitial () {
		return haemetemesisInitial;
	}

	/**
	 * Set the value related to the column: haemetemesis_initial
	 * @param haemetemesisInitial the haemetemesis_initial value
	 */
	public void setHaemetemesisInitial (java.lang.String haemetemesisInitial) {
		this.haemetemesisInitial = haemetemesisInitial;
	}



	/**
	 * Return the value associated with the column: heartburn_duration
	 */
	public java.lang.String getHeartburnDuration () {
		return heartburnDuration;
	}

	/**
	 * Set the value related to the column: heartburn_duration
	 * @param heartburnDuration the heartburn_duration value
	 */
	public void setHeartburnDuration (java.lang.String heartburnDuration) {
		this.heartburnDuration = heartburnDuration;
	}



	/**
	 * Return the value associated with the column: heartburn_type
	 */
	public java.lang.String getHeartburnType () {
		return heartburnType;
	}

	/**
	 * Set the value related to the column: heartburn_type
	 * @param heartburnType the heartburn_type value
	 */
	public void setHeartburnType (java.lang.String heartburnType) {
		this.heartburnType = heartburnType;
	}



	/**
	 * Return the value associated with the column: jaundice_duration
	 */
	public java.lang.String getJaundiceDuration () {
		return jaundiceDuration;
	}

	/**
	 * Set the value related to the column: jaundice_duration
	 * @param jaundiceDuration the jaundice_duration value
	 */
	public void setJaundiceDuration (java.lang.String jaundiceDuration) {
		this.jaundiceDuration = jaundiceDuration;
	}



	/**
	 * Return the value associated with the column: jaundice_progressive_intermittent
	 */
	public java.lang.String getJaundiceProgressiveIntermittent () {
		return jaundiceProgressiveIntermittent;
	}

	/**
	 * Set the value related to the column: jaundice_progressive_intermittent
	 * @param jaundiceProgressiveIntermittent the jaundice_progressive_intermittent value
	 */
	public void setJaundiceProgressiveIntermittent (java.lang.String jaundiceProgressiveIntermittent) {
		this.jaundiceProgressiveIntermittent = jaundiceProgressiveIntermittent;
	}



	/**
	 * Return the value associated with the column: malena_duration
	 */
	public java.lang.String getMalenaDuration () {
		return malenaDuration;
	}

	/**
	 * Set the value related to the column: malena_duration
	 * @param malenaDuration the malena_duration value
	 */
	public void setMalenaDuration (java.lang.String malenaDuration) {
		this.malenaDuration = malenaDuration;
	}



	/**
	 * Return the value associated with the column: nausea_duration
	 */
	public java.lang.String getNauseaDuration () {
		return nauseaDuration;
	}

	/**
	 * Set the value related to the column: nausea_duration
	 * @param nauseaDuration the nausea_duration value
	 */
	public void setNauseaDuration (java.lang.String nauseaDuration) {
		this.nauseaDuration = nauseaDuration;
	}



	/**
	 * Return the value associated with the column: nausea_type
	 */
	public java.lang.String getNauseaType () {
		return nauseaType;
	}

	/**
	 * Set the value related to the column: nausea_type
	 * @param nauseaType the nausea_type value
	 */
	public void setNauseaType (java.lang.String nauseaType) {
		this.nauseaType = nauseaType;
	}



	/**
	 * Return the value associated with the column: pain_duration
	 */
	public java.lang.String getPainDuration () {
		return painDuration;
	}

	/**
	 * Set the value related to the column: pain_duration
	 * @param painDuration the pain_duration value
	 */
	public void setPainDuration (java.lang.String painDuration) {
		this.painDuration = painDuration;
	}



	/**
	 * Return the value associated with the column: pain_site
	 */
	public java.lang.String getPainSite () {
		return painSite;
	}

	/**
	 * Set the value related to the column: pain_site
	 * @param painSite the pain_site value
	 */
	public void setPainSite (java.lang.String painSite) {
		this.painSite = painSite;
	}



	/**
	 * Return the value associated with the column: pain_type
	 */
	public java.lang.String getPainType () {
		return painType;
	}

	/**
	 * Set the value related to the column: pain_type
	 * @param painType the pain_type value
	 */
	public void setPainType (java.lang.String painType) {
		this.painType = painType;
	}



	/**
	 * Return the value associated with the column: pain_radiation
	 */
	public java.lang.String getPainRadiation () {
		return painRadiation;
	}

	/**
	 * Set the value related to the column: pain_radiation
	 * @param painRadiation the pain_radiation value
	 */
	public void setPainRadiation (java.lang.String painRadiation) {
		this.painRadiation = painRadiation;
	}



	/**
	 * Return the value associated with the column: pain_shifting
	 */
	public java.lang.String getPainShifting () {
		return painShifting;
	}

	/**
	 * Set the value related to the column: pain_shifting
	 * @param painShifting the pain_shifting value
	 */
	public void setPainShifting (java.lang.String painShifting) {
		this.painShifting = painShifting;
	}



	/**
	 * Return the value associated with the column: pain_referral
	 */
	public java.lang.String getPainReferral () {
		return painReferral;
	}

	/**
	 * Set the value related to the column: pain_referral
	 * @param painReferral the pain_referral value
	 */
	public void setPainReferral (java.lang.String painReferral) {
		this.painReferral = painReferral;
	}



	/**
	 * Return the value associated with the column: swelling_duration
	 */
	public java.lang.String getSwellingDuration () {
		return swellingDuration;
	}

	/**
	 * Set the value related to the column: swelling_duration
	 * @param swellingDuration the swelling_duration value
	 */
	public void setSwellingDuration (java.lang.String swellingDuration) {
		this.swellingDuration = swellingDuration;
	}



	/**
	 * Return the value associated with the column: swelling_site
	 */
	public java.lang.String getSwellingSite () {
		return swellingSite;
	}

	/**
	 * Set the value related to the column: swelling_site
	 * @param swellingSite the swelling_site value
	 */
	public void setSwellingSite (java.lang.String swellingSite) {
		this.swellingSite = swellingSite;
	}



	/**
	 * Return the value associated with the column: swelling_size
	 */
	public java.lang.String getSwellingSize () {
		return swellingSize;
	}

	/**
	 * Set the value related to the column: swelling_size
	 * @param swellingSize the swelling_size value
	 */
	public void setSwellingSize (java.lang.String swellingSize) {
		this.swellingSize = swellingSize;
	}



	/**
	 * Return the value associated with the column: swelling_shape
	 */
	public java.lang.String getSwellingShape () {
		return swellingShape;
	}

	/**
	 * Set the value related to the column: swelling_shape
	 * @param swellingShape the swelling_shape value
	 */
	public void setSwellingShape (java.lang.String swellingShape) {
		this.swellingShape = swellingShape;
	}



	/**
	 * Return the value associated with the column: swelling_growth_rate
	 */
	public java.lang.String getSwellingGrowthRate () {
		return swellingGrowthRate;
	}

	/**
	 * Set the value related to the column: swelling_growth_rate
	 * @param swellingGrowthRate the swelling_growth_rate value
	 */
	public void setSwellingGrowthRate (java.lang.String swellingGrowthRate) {
		this.swellingGrowthRate = swellingGrowthRate;
	}



	/**
	 * Return the value associated with the column: trauma_duration
	 */
	public java.lang.String getTraumaDuration () {
		return traumaDuration;
	}

	/**
	 * Set the value related to the column: trauma_duration
	 * @param traumaDuration the trauma_duration value
	 */
	public void setTraumaDuration (java.lang.String traumaDuration) {
		this.traumaDuration = traumaDuration;
	}



	/**
	 * Return the value associated with the column: trauma_type
	 */
	public java.lang.String getTraumaType () {
		return traumaType;
	}

	/**
	 * Set the value related to the column: trauma_type
	 * @param traumaType the trauma_type value
	 */
	public void setTraumaType (java.lang.String traumaType) {
		this.traumaType = traumaType;
	}



	/**
	 * Return the value associated with the column: ulcer_duration
	 */
	public java.lang.String getUlcerDuration () {
		return ulcerDuration;
	}

	/**
	 * Set the value related to the column: ulcer_duration
	 * @param ulcerDuration the ulcer_duration value
	 */
	public void setUlcerDuration (java.lang.String ulcerDuration) {
		this.ulcerDuration = ulcerDuration;
	}



	/**
	 * Return the value associated with the column: ulcer_site
	 */
	public java.lang.String getUlcerSite () {
		return ulcerSite;
	}

	/**
	 * Set the value related to the column: ulcer_site
	 * @param ulcerSite the ulcer_site value
	 */
	public void setUlcerSite (java.lang.String ulcerSite) {
		this.ulcerSite = ulcerSite;
	}



	/**
	 * Return the value associated with the column: ulcer_size
	 */
	public java.lang.String getUlcerSize () {
		return ulcerSize;
	}

	/**
	 * Set the value related to the column: ulcer_size
	 * @param ulcerSize the ulcer_size value
	 */
	public void setUlcerSize (java.lang.String ulcerSize) {
		this.ulcerSize = ulcerSize;
	}



	/**
	 * Return the value associated with the column: ulcer_shape
	 */
	public java.lang.String getUlcerShape () {
		return ulcerShape;
	}

	/**
	 * Set the value related to the column: ulcer_shape
	 * @param ulcerShape the ulcer_shape value
	 */
	public void setUlcerShape (java.lang.String ulcerShape) {
		this.ulcerShape = ulcerShape;
	}



	/**
	 * Return the value associated with the column: ulcer_growth_rate
	 */
	public java.lang.String getUlcerGrowthRate () {
		return ulcerGrowthRate;
	}

	/**
	 * Set the value related to the column: ulcer_growth_rate
	 * @param ulcerGrowthRate the ulcer_growth_rate value
	 */
	public void setUlcerGrowthRate (java.lang.String ulcerGrowthRate) {
		this.ulcerGrowthRate = ulcerGrowthRate;
	}



	/**
	 * Return the value associated with the column: urinary_obstruction_duration
	 */
	public java.lang.String getUrinaryObstructionDuration () {
		return urinaryObstructionDuration;
	}

	/**
	 * Set the value related to the column: urinary_obstruction_duration
	 * @param urinaryObstructionDuration the urinary_obstruction_duration value
	 */
	public void setUrinaryObstructionDuration (java.lang.String urinaryObstructionDuration) {
		this.urinaryObstructionDuration = urinaryObstructionDuration;
	}



	/**
	 * Return the value associated with the column: urinary_obstruction_continuos
	 */
	public java.lang.String getUrinaryObstructionContinuos () {
		return urinaryObstructionContinuos;
	}

	/**
	 * Set the value related to the column: urinary_obstruction_continuos
	 * @param urinaryObstructionContinuos the urinary_obstruction_continuos value
	 */
	public void setUrinaryObstructionContinuos (java.lang.String urinaryObstructionContinuos) {
		this.urinaryObstructionContinuos = urinaryObstructionContinuos;
	}



	/**
	 * Return the value associated with the column: vomiting_duration
	 */
	public java.lang.String getVomitingDuration () {
		return vomitingDuration;
	}

	/**
	 * Set the value related to the column: vomiting_duration
	 * @param vomitingDuration the vomiting_duration value
	 */
	public void setVomitingDuration (java.lang.String vomitingDuration) {
		this.vomitingDuration = vomitingDuration;
	}



	/**
	 * Return the value associated with the column: vomiting_projectile
	 */
	public java.lang.String getVomitingProjectile () {
		return vomitingProjectile;
	}

	/**
	 * Set the value related to the column: vomiting_projectile
	 * @param vomitingProjectile the vomiting_projectile value
	 */
	public void setVomitingProjectile (java.lang.String vomitingProjectile) {
		this.vomitingProjectile = vomitingProjectile;
	}



	/**
	 * Return the value associated with the column: vomiting_time_after_food_intake
	 */
	public java.lang.String getVomitingTimeAfterFoodIntake () {
		return vomitingTimeAfterFoodIntake;
	}

	/**
	 * Set the value related to the column: vomiting_time_after_food_intake
	 * @param vomitingTimeAfterFoodIntake the vomiting_time_after_food_intake value
	 */
	public void setVomitingTimeAfterFoodIntake (java.lang.String vomitingTimeAfterFoodIntake) {
		this.vomitingTimeAfterFoodIntake = vomitingTimeAfterFoodIntake;
	}



	/**
	 * Return the value associated with the column: vomiting_bilious
	 */
	public java.lang.String getVomitingBilious () {
		return vomitingBilious;
	}

	/**
	 * Set the value related to the column: vomiting_bilious
	 * @param vomitingBilious the vomiting_bilious value
	 */
	public void setVomitingBilious (java.lang.String vomitingBilious) {
		this.vomitingBilious = vomitingBilious;
	}



	/**
	 * Return the value associated with the column: diet
	 */
	public java.lang.String getDiet () {
		return diet;
	}

	/**
	 * Set the value related to the column: diet
	 * @param diet the diet value
	 */
	public void setDiet (java.lang.String diet) {
		this.diet = diet;
	}



	/**
	 * Return the value associated with the column: sleep
	 */
	public java.lang.String getSleep () {
		return sleep;
	}

	/**
	 * Set the value related to the column: sleep
	 * @param sleep the sleep value
	 */
	public void setSleep (java.lang.String sleep) {
		this.sleep = sleep;
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
	 * Return the value associated with the column: bowel
	 */
	public java.lang.String getBowel () {
		return bowel;
	}

	/**
	 * Set the value related to the column: bowel
	 * @param bowel the bowel value
	 */
	public void setBowel (java.lang.String bowel) {
		this.bowel = bowel;
	}



	/**
	 * Return the value associated with the column: bladder
	 */
	public java.lang.String getBladder () {
		return bladder;
	}

	/**
	 * Set the value related to the column: bladder
	 * @param bladder the bladder value
	 */
	public void setBladder (java.lang.String bladder) {
		this.bladder = bladder;
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
	 * Return the value associated with the column: mumber_day
	 */
	public java.lang.String getMumberDay () {
		return mumberDay;
	}

	/**
	 * Set the value related to the column: mumber_day
	 * @param mumberDay the mumber_day value
	 */
	public void setMumberDay (java.lang.String mumberDay) {
		this.mumberDay = mumberDay;
	}



	/**
	 * Return the value associated with the column: alcohol_volume
	 */
	public java.lang.String getAlcoholVolume () {
		return alcoholVolume;
	}

	/**
	 * Set the value related to the column: alcohol_volume
	 * @param alcoholVolume the alcohol_volume value
	 */
	public void setAlcoholVolume (java.lang.String alcoholVolume) {
		this.alcoholVolume = alcoholVolume;
	}



	/**
	 * Return the value associated with the column: alcohol_day
	 */
	public java.lang.String getAlcoholDay () {
		return alcoholDay;
	}

	/**
	 * Set the value related to the column: alcohol_day
	 * @param alcoholDay the alcohol_day value
	 */
	public void setAlcoholDay (java.lang.String alcoholDay) {
		this.alcoholDay = alcoholDay;
	}



	/**
	 * Return the value associated with the column: other_addictions
	 */
	public java.lang.String getOtherAddictions () {
		return otherAddictions;
	}

	/**
	 * Set the value related to the column: other_addictions
	 * @param otherAddictions the other_addictions value
	 */
	public void setOtherAddictions (java.lang.String otherAddictions) {
		this.otherAddictions = otherAddictions;
	}



	/**
	 * Return the value associated with the column: menarche
	 */
	public java.lang.String getMenarche () {
		return menarche;
	}

	/**
	 * Set the value related to the column: menarche
	 * @param menarche the menarche value
	 */
	public void setMenarche (java.lang.String menarche) {
		this.menarche = menarche;
	}



	/**
	 * Return the value associated with the column: cyclelength
	 */
	public java.lang.String getCyclelength () {
		return cyclelength;
	}

	/**
	 * Set the value related to the column: cyclelength
	 * @param cyclelength the cyclelength value
	 */
	public void setCyclelength (java.lang.String cyclelength) {
		this.cyclelength = cyclelength;
	}



	/**
	 * Return the value associated with the column: flowdays
	 */
	public java.lang.String getFlowdays () {
		return flowdays;
	}

	/**
	 * Set the value related to the column: flowdays
	 * @param flowdays the flowdays value
	 */
	public void setFlowdays (java.lang.String flowdays) {
		this.flowdays = flowdays;
	}



	/**
	 * Return the value associated with the column: menopause
	 */
	public java.lang.String getMenopause () {
		return menopause;
	}

	/**
	 * Set the value related to the column: menopause
	 * @param menopause the menopause value
	 */
	public void setMenopause (java.lang.String menopause) {
		this.menopause = menopause;
	}



	/**
	 * Return the value associated with the column: number_of_children
	 */
	public java.lang.String getNumberOfChildren () {
		return numberOfChildren;
	}

	/**
	 * Set the value related to the column: number_of_children
	 * @param numberOfChildren the number_of_children value
	 */
	public void setNumberOfChildren (java.lang.String numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}



	/**
	 * Return the value associated with the column: lactation_duration
	 */
	public java.lang.String getLactationDuration () {
		return lactationDuration;
	}

	/**
	 * Set the value related to the column: lactation_duration
	 * @param lactationDuration the lactation_duration value
	 */
	public void setLactationDuration (java.lang.String lactationDuration) {
		this.lactationDuration = lactationDuration;
	}



	/**
	 * Return the value associated with the column: pps
	 */
	public java.lang.String getPps () {
		return pps;
	}

	/**
	 * Set the value related to the column: pps
	 * @param pps the pps value
	 */
	public void setPps (java.lang.String pps) {
		this.pps = pps;
	}



	/**
	 * Return the value associated with the column: hrt
	 */
	public java.lang.String getHrt () {
		return hrt;
	}

	/**
	 * Set the value related to the column: hrt
	 * @param hrt the hrt value
	 */
	public void setHrt (java.lang.String hrt) {
		this.hrt = hrt;
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
	 * Return the value associated with the column: generalized_lymphadenopathy
	 */
	public java.lang.String getGeneralizedLymphadenopathy () {
		return generalizedLymphadenopathy;
	}

	/**
	 * Set the value related to the column: generalized_lymphadenopathy
	 * @param generalizedLymphadenopathy the generalized_lymphadenopathy value
	 */
	public void setGeneralizedLymphadenopathy (java.lang.String generalizedLymphadenopathy) {
		this.generalizedLymphadenopathy = generalizedLymphadenopathy;
	}



	/**
	 * Return the value associated with the column: generalized_lymphadenopathy_txt
	 */
	public java.lang.String getGeneralizedLymphadenopathyTxt () {
		return generalizedLymphadenopathyTxt;
	}

	/**
	 * Set the value related to the column: generalized_lymphadenopathy_txt
	 * @param generalizedLymphadenopathyTxt the generalized_lymphadenopathy_txt value
	 */
	public void setGeneralizedLymphadenopathyTxt (java.lang.String generalizedLymphadenopathyTxt) {
		this.generalizedLymphadenopathyTxt = generalizedLymphadenopathyTxt;
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
	 * Return the value associated with the column: edema_txt
	 */
	public java.lang.String getEdemaTxt () {
		return edemaTxt;
	}

	/**
	 * Set the value related to the column: edema_txt
	 * @param edemaTxt the edema_txt value
	 */
	public void setEdemaTxt (java.lang.String edemaTxt) {
		this.edemaTxt = edemaTxt;
	}



	/**
	 * Return the value associated with the column: bones
	 */
	public java.lang.String getBones () {
		return bones;
	}

	/**
	 * Set the value related to the column: bones
	 * @param bones the bones value
	 */
	public void setBones (java.lang.String bones) {
		this.bones = bones;
	}



	/**
	 * Return the value associated with the column: genitalia
	 */
	public java.lang.String getGenitalia () {
		return genitalia;
	}

	/**
	 * Set the value related to the column: genitalia
	 * @param genitalia the genitalia value
	 */
	public void setGenitalia (java.lang.String genitalia) {
		this.genitalia = genitalia;
	}



	/**
	 * Return the value associated with the column: joints
	 */
	public java.lang.String getJoints () {
		return joints;
	}

	/**
	 * Set the value related to the column: joints
	 * @param joints the joints value
	 */
	public void setJoints (java.lang.String joints) {
		this.joints = joints;
	}



	/**
	 * Return the value associated with the column: nails
	 */
	public java.lang.String getNails () {
		return nails;
	}

	/**
	 * Set the value related to the column: nails
	 * @param nails the nails value
	 */
	public void setNails (java.lang.String nails) {
		this.nails = nails;
	}



	/**
	 * Return the value associated with the column: nerves
	 */
	public java.lang.String getNerves () {
		return nerves;
	}

	/**
	 * Set the value related to the column: nerves
	 * @param nerves the nerves value
	 */
	public void setNerves (java.lang.String nerves) {
		this.nerves = nerves;
	}



	/**
	 * Return the value associated with the column: scalp
	 */
	public java.lang.String getScalp () {
		return scalp;
	}

	/**
	 * Set the value related to the column: scalp
	 * @param scalp the scalp value
	 */
	public void setScalp (java.lang.String scalp) {
		this.scalp = scalp;
	}



	/**
	 * Return the value associated with the column: skin
	 */
	public java.lang.String getSkin () {
		return skin;
	}

	/**
	 * Set the value related to the column: skin
	 * @param skin the skin value
	 */
	public void setSkin (java.lang.String skin) {
		this.skin = skin;
	}



	/**
	 * Return the value associated with the column: skull
	 */
	public java.lang.String getSkull () {
		return skull;
	}

	/**
	 * Set the value related to the column: skull
	 * @param skull the skull value
	 */
	public void setSkull (java.lang.String skull) {
		this.skull = skull;
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
	 * Return the value associated with the column: vessels
	 */
	public java.lang.String getVessels () {
		return vessels;
	}

	/**
	 * Set the value related to the column: vessels
	 * @param vessels the vessels value
	 */
	public void setVessels (java.lang.String vessels) {
		this.vessels = vessels;
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
	 * Return the value associated with the column: mm
	 */
	public java.lang.String getMm () {
		return mm;
	}

	/**
	 * Set the value related to the column: mm
	 * @param mm the mm value
	 */
	public void setMm (java.lang.String mm) {
		this.mm = mm;
	}



	/**
	 * Return the value associated with the column: jvp
	 */
	public java.lang.String getJvp () {
		return jvp;
	}

	/**
	 * Set the value related to the column: jvp
	 * @param jvp the jvp value
	 */
	public void setJvp (java.lang.String jvp) {
		this.jvp = jvp;
	}



	/**
	 * Return the value associated with the column: sp
	 */
	public java.lang.String getSp () {
		return sp;
	}

	/**
	 * Set the value related to the column: sp
	 * @param sp the sp value
	 */
	public void setSp (java.lang.String sp) {
		this.sp = sp;
	}



	/**
	 * Return the value associated with the column: pulse_rate
	 */
	public java.lang.String getPulseRate () {
		return pulseRate;
	}

	/**
	 * Set the value related to the column: pulse_rate
	 * @param pulseRate the pulse_rate value
	 */
	public void setPulseRate (java.lang.String pulseRate) {
		this.pulseRate = pulseRate;
	}



	/**
	 * Return the value associated with the column: pulse_rhythm
	 */
	public java.lang.String getPulseRhythm () {
		return pulseRhythm;
	}

	/**
	 * Set the value related to the column: pulse_rhythm
	 * @param pulseRhythm the pulse_rhythm value
	 */
	public void setPulseRhythm (java.lang.String pulseRhythm) {
		this.pulseRhythm = pulseRhythm;
	}



	/**
	 * Return the value associated with the column: pulse_volume
	 */
	public java.lang.String getPulseVolume () {
		return pulseVolume;
	}

	/**
	 * Set the value related to the column: pulse_volume
	 * @param pulseVolume the pulse_volume value
	 */
	public void setPulseVolume (java.lang.String pulseVolume) {
		this.pulseVolume = pulseVolume;
	}



	/**
	 * Return the value associated with the column: pulse_vessel_wall
	 */
	public java.lang.String getPulseVesselWall () {
		return pulseVesselWall;
	}

	/**
	 * Set the value related to the column: pulse_vessel_wall
	 * @param pulseVesselWall the pulse_vessel_wall value
	 */
	public void setPulseVesselWall (java.lang.String pulseVesselWall) {
		this.pulseVesselWall = pulseVesselWall;
	}



	/**
	 * Return the value associated with the column: respiration_rate
	 */
	public java.lang.String getRespirationRate () {
		return respirationRate;
	}

	/**
	 * Set the value related to the column: respiration_rate
	 * @param respirationRate the respiration_rate value
	 */
	public void setRespirationRate (java.lang.String respirationRate) {
		this.respirationRate = respirationRate;
	}



	/**
	 * Return the value associated with the column: respiration_rhythm
	 */
	public java.lang.String getRespirationRhythm () {
		return respirationRhythm;
	}

	/**
	 * Set the value related to the column: respiration_rhythm
	 * @param respirationRhythm the respiration_rhythm value
	 */
	public void setRespirationRhythm (java.lang.String respirationRhythm) {
		this.respirationRhythm = respirationRhythm;
	}



	/**
	 * Return the value associated with the column: respiration_type
	 */
	public java.lang.String getRespirationType () {
		return respirationType;
	}

	/**
	 * Set the value related to the column: respiration_type
	 * @param respirationType the respiration_type value
	 */
	public void setRespirationType (java.lang.String respirationType) {
		this.respirationType = respirationType;
	}



	/**
	 * Return the value associated with the column: asa_grade
	 */
	public java.lang.String getAsaGrade () {
		return asaGrade;
	}

	/**
	 * Set the value related to the column: asa_grade
	 * @param asaGrade the asa_grade value
	 */
	public void setAsaGrade (java.lang.String asaGrade) {
		this.asaGrade = asaGrade;
	}



	/**
	 * Return the value associated with the column: lesion
	 */
	public java.lang.String getLesion () {
		return lesion;
	}

	/**
	 * Set the value related to the column: lesion
	 * @param lesion the lesion value
	 */
	public void setLesion (java.lang.String lesion) {
		this.lesion = lesion;
	}



	/**
	 * Return the value associated with the column: lesion_type
	 */
	public java.lang.String getLesionType () {
		return lesionType;
	}

	/**
	 * Set the value related to the column: lesion_type
	 * @param lesionType the lesion_type value
	 */
	public void setLesionType (java.lang.String lesionType) {
		this.lesionType = lesionType;
	}



	/**
	 * Return the value associated with the column: lesion_site
	 */
	public java.lang.String getLesionSite () {
		return lesionSite;
	}

	/**
	 * Set the value related to the column: lesion_site
	 * @param lesionSite the lesion_site value
	 */
	public void setLesionSite (java.lang.String lesionSite) {
		this.lesionSite = lesionSite;
	}



	/**
	 * Return the value associated with the column: lesion_size
	 */
	public java.lang.String getLesionSize () {
		return lesionSize;
	}

	/**
	 * Set the value related to the column: lesion_size
	 * @param lesionSize the lesion_size value
	 */
	public void setLesionSize (java.lang.String lesionSize) {
		this.lesionSize = lesionSize;
	}



	/**
	 * Return the value associated with the column: lesion_surface
	 */
	public java.lang.String getLesionSurface () {
		return lesionSurface;
	}

	/**
	 * Set the value related to the column: lesion_surface
	 * @param lesionSurface the lesion_surface value
	 */
	public void setLesionSurface (java.lang.String lesionSurface) {
		this.lesionSurface = lesionSurface;
	}



	/**
	 * Return the value associated with the column: lesion_shape
	 */
	public java.lang.String getLesionShape () {
		return lesionShape;
	}

	/**
	 * Set the value related to the column: lesion_shape
	 * @param lesionShape the lesion_shape value
	 */
	public void setLesionShape (java.lang.String lesionShape) {
		this.lesionShape = lesionShape;
	}



	/**
	 * Return the value associated with the column: lesion_consistency
	 */
	public java.lang.String getLesionConsistency () {
		return lesionConsistency;
	}

	/**
	 * Set the value related to the column: lesion_consistency
	 * @param lesionConsistency the lesion_consistency value
	 */
	public void setLesionConsistency (java.lang.String lesionConsistency) {
		this.lesionConsistency = lesionConsistency;
	}



	/**
	 * Return the value associated with the column: lesion_mobility
	 */
	public java.lang.String getLesionMobility () {
		return lesionMobility;
	}

	/**
	 * Set the value related to the column: lesion_mobility
	 * @param lesionMobility the lesion_mobility value
	 */
	public void setLesionMobility (java.lang.String lesionMobility) {
		this.lesionMobility = lesionMobility;
	}



	/**
	 * Return the value associated with the column: lesion_plane
	 */
	public java.lang.String getLesionPlane () {
		return lesionPlane;
	}

	/**
	 * Set the value related to the column: lesion_plane
	 * @param lesionPlane the lesion_plane value
	 */
	public void setLesionPlane (java.lang.String lesionPlane) {
		this.lesionPlane = lesionPlane;
	}



	/**
	 * Return the value associated with the column: lesion_others
	 */
	public java.lang.String getLesionOthers () {
		return lesionOthers;
	}

	/**
	 * Set the value related to the column: lesion_others
	 * @param lesionOthers the lesion_others value
	 */
	public void setLesionOthers (java.lang.String lesionOthers) {
		this.lesionOthers = lesionOthers;
	}



	/**
	 * Return the value associated with the column: local_lymph
	 */
	public java.lang.String getLocalLymph () {
		return localLymph;
	}

	/**
	 * Set the value related to the column: local_lymph
	 * @param localLymph the local_lymph value
	 */
	public void setLocalLymph (java.lang.String localLymph) {
		this.localLymph = localLymph;
	}



	/**
	 * Return the value associated with the column: local_lymph_type
	 */
	public java.lang.String getLocalLymphType () {
		return localLymphType;
	}

	/**
	 * Set the value related to the column: local_lymph_type
	 * @param localLymphType the local_lymph_type value
	 */
	public void setLocalLymphType (java.lang.String localLymphType) {
		this.localLymphType = localLymphType;
	}



	/**
	 * Return the value associated with the column: local_lymph_site
	 */
	public java.lang.String getLocalLymphSite () {
		return localLymphSite;
	}

	/**
	 * Set the value related to the column: local_lymph_site
	 * @param localLymphSite the local_lymph_site value
	 */
	public void setLocalLymphSite (java.lang.String localLymphSite) {
		this.localLymphSite = localLymphSite;
	}



	/**
	 * Return the value associated with the column: local_lymph_size
	 */
	public java.lang.String getLocalLymphSize () {
		return localLymphSize;
	}

	/**
	 * Set the value related to the column: local_lymph_size
	 * @param localLymphSize the local_lymph_size value
	 */
	public void setLocalLymphSize (java.lang.String localLymphSize) {
		this.localLymphSize = localLymphSize;
	}



	/**
	 * Return the value associated with the column: local_lymph_surface
	 */
	public java.lang.String getLocalLymphSurface () {
		return localLymphSurface;
	}

	/**
	 * Set the value related to the column: local_lymph_surface
	 * @param localLymphSurface the local_lymph_surface value
	 */
	public void setLocalLymphSurface (java.lang.String localLymphSurface) {
		this.localLymphSurface = localLymphSurface;
	}



	/**
	 * Return the value associated with the column: local_lymph_shape
	 */
	public java.lang.String getLocalLymphShape () {
		return localLymphShape;
	}

	/**
	 * Set the value related to the column: local_lymph_shape
	 * @param localLymphShape the local_lymph_shape value
	 */
	public void setLocalLymphShape (java.lang.String localLymphShape) {
		this.localLymphShape = localLymphShape;
	}



	/**
	 * Return the value associated with the column: local_lymph_consistency
	 */
	public java.lang.String getLocalLymphConsistency () {
		return localLymphConsistency;
	}

	/**
	 * Set the value related to the column: local_lymph_consistency
	 * @param localLymphConsistency the local_lymph_consistency value
	 */
	public void setLocalLymphConsistency (java.lang.String localLymphConsistency) {
		this.localLymphConsistency = localLymphConsistency;
	}



	/**
	 * Return the value associated with the column: local_lymph_mobility
	 */
	public java.lang.String getLocalLymphMobility () {
		return localLymphMobility;
	}

	/**
	 * Set the value related to the column: local_lymph_mobility
	 * @param localLymphMobility the local_lymph_mobility value
	 */
	public void setLocalLymphMobility (java.lang.String localLymphMobility) {
		this.localLymphMobility = localLymphMobility;
	}



	/**
	 * Return the value associated with the column: local_lymph_others
	 */
	public java.lang.String getLocalLymphOthers () {
		return localLymphOthers;
	}

	/**
	 * Set the value related to the column: local_lymph_others
	 * @param localLymphOthers the local_lymph_others value
	 */
	public void setLocalLymphOthers (java.lang.String localLymphOthers) {
		this.localLymphOthers = localLymphOthers;
	}



	/**
	 * Return the value associated with the column: local_vessel
	 */
	public java.lang.String getLocalVessel () {
		return localVessel;
	}

	/**
	 * Set the value related to the column: local_vessel
	 * @param localVessel the local_vessel value
	 */
	public void setLocalVessel (java.lang.String localVessel) {
		this.localVessel = localVessel;
	}



	/**
	 * Return the value associated with the column: local_vessel_flow_volume
	 */
	public java.lang.String getLocalVesselFlowVolume () {
		return localVesselFlowVolume;
	}

	/**
	 * Set the value related to the column: local_vessel_flow_volume
	 * @param localVesselFlowVolume the local_vessel_flow_volume value
	 */
	public void setLocalVesselFlowVolume (java.lang.String localVesselFlowVolume) {
		this.localVesselFlowVolume = localVesselFlowVolume;
	}



	/**
	 * Return the value associated with the column: local_vessel_bruit
	 */
	public java.lang.String getLocalVesselBruit () {
		return localVesselBruit;
	}

	/**
	 * Set the value related to the column: local_vessel_bruit
	 * @param localVesselBruit the local_vessel_bruit value
	 */
	public void setLocalVesselBruit (java.lang.String localVesselBruit) {
		this.localVesselBruit = localVesselBruit;
	}



	/**
	 * Return the value associated with the column: local_vessel_others
	 */
	public java.lang.String getLocalVesselOthers () {
		return localVesselOthers;
	}

	/**
	 * Set the value related to the column: local_vessel_others
	 * @param localVesselOthers the local_vessel_others value
	 */
	public void setLocalVesselOthers (java.lang.String localVesselOthers) {
		this.localVesselOthers = localVesselOthers;
	}



	/**
	 * Return the value associated with the column: local_nerves
	 */
	public java.lang.String getLocalNerves () {
		return localNerves;
	}

	/**
	 * Set the value related to the column: local_nerves
	 * @param localNerves the local_nerves value
	 */
	public void setLocalNerves (java.lang.String localNerves) {
		this.localNerves = localNerves;
	}



	/**
	 * Return the value associated with the column: local_nerves_sensory
	 */
	public java.lang.String getLocalNervesSensory () {
		return localNervesSensory;
	}

	/**
	 * Set the value related to the column: local_nerves_sensory
	 * @param localNervesSensory the local_nerves_sensory value
	 */
	public void setLocalNervesSensory (java.lang.String localNervesSensory) {
		this.localNervesSensory = localNervesSensory;
	}



	/**
	 * Return the value associated with the column: local_nerves_motor
	 */
	public java.lang.String getLocalNervesMotor () {
		return localNervesMotor;
	}

	/**
	 * Set the value related to the column: local_nerves_motor
	 * @param localNervesMotor the local_nerves_motor value
	 */
	public void setLocalNervesMotor (java.lang.String localNervesMotor) {
		this.localNervesMotor = localNervesMotor;
	}



	/**
	 * Return the value associated with the column: local_nerves_others
	 */
	public java.lang.String getLocalNervesOthers () {
		return localNervesOthers;
	}

	/**
	 * Set the value related to the column: local_nerves_others
	 * @param localNervesOthers the local_nerves_others value
	 */
	public void setLocalNervesOthers (java.lang.String localNervesOthers) {
		this.localNervesOthers = localNervesOthers;
	}



	/**
	 * Return the value associated with the column: local_joints
	 */
	public java.lang.String getLocalJoints () {
		return localJoints;
	}

	/**
	 * Set the value related to the column: local_joints
	 * @param localJoints the local_joints value
	 */
	public void setLocalJoints (java.lang.String localJoints) {
		this.localJoints = localJoints;
	}



	/**
	 * Return the value associated with the column: local_joints_movements
	 */
	public java.lang.String getLocalJointsMovements () {
		return localJointsMovements;
	}

	/**
	 * Set the value related to the column: local_joints_movements
	 * @param localJointsMovements the local_joints_movements value
	 */
	public void setLocalJointsMovements (java.lang.String localJointsMovements) {
		this.localJointsMovements = localJointsMovements;
	}



	/**
	 * Return the value associated with the column: oral_cavity
	 */
	public java.lang.String getOralCavity () {
		return oralCavity;
	}

	/**
	 * Set the value related to the column: oral_cavity
	 * @param oralCavity the oral_cavity value
	 */
	public void setOralCavity (java.lang.String oralCavity) {
		this.oralCavity = oralCavity;
	}



	/**
	 * Return the value associated with the column: tongue
	 */
	public java.lang.String getTongue () {
		return tongue;
	}

	/**
	 * Set the value related to the column: tongue
	 * @param tongue the tongue value
	 */
	public void setTongue (java.lang.String tongue) {
		this.tongue = tongue;
	}



	/**
	 * Return the value associated with the column: throat
	 */
	public java.lang.String getThroat () {
		return throat;
	}

	/**
	 * Set the value related to the column: throat
	 * @param throat the throat value
	 */
	public void setThroat (java.lang.String throat) {
		this.throat = throat;
	}



	/**
	 * Return the value associated with the column: abdomen
	 */
	public java.lang.String getAbdomen () {
		return abdomen;
	}

	/**
	 * Set the value related to the column: abdomen
	 * @param abdomen the abdomen value
	 */
	public void setAbdomen (java.lang.String abdomen) {
		this.abdomen = abdomen;
	}



	/**
	 * Return the value associated with the column: gastro_intestinal_tenderness
	 */
	public java.lang.String getGastroIntestinalTenderness () {
		return gastroIntestinalTenderness;
	}

	/**
	 * Set the value related to the column: gastro_intestinal_tenderness
	 * @param gastroIntestinalTenderness the gastro_intestinal_tenderness value
	 */
	public void setGastroIntestinalTenderness (java.lang.String gastroIntestinalTenderness) {
		this.gastroIntestinalTenderness = gastroIntestinalTenderness;
	}



	/**
	 * Return the value associated with the column: gastro_intestinal_tenderness_site
	 */
	public java.lang.String getGastroIntestinalTendernessSite () {
		return gastroIntestinalTendernessSite;
	}

	/**
	 * Set the value related to the column: gastro_intestinal_tenderness_site
	 * @param gastroIntestinalTendernessSite the gastro_intestinal_tenderness_site value
	 */
	public void setGastroIntestinalTendernessSite (java.lang.String gastroIntestinalTendernessSite) {
		this.gastroIntestinalTendernessSite = gastroIntestinalTendernessSite;
	}



	/**
	 * Return the value associated with the column: gastro_intestinal_tenderness_type
	 */
	public java.lang.String getGastroIntestinalTendernessType () {
		return gastroIntestinalTendernessType;
	}

	/**
	 * Set the value related to the column: gastro_intestinal_tenderness_type
	 * @param gastroIntestinalTendernessType the gastro_intestinal_tenderness_type value
	 */
	public void setGastroIntestinalTendernessType (java.lang.String gastroIntestinalTendernessType) {
		this.gastroIntestinalTendernessType = gastroIntestinalTendernessType;
	}



	/**
	 * Return the value associated with the column: swellings
	 */
	public java.lang.String getSwellings () {
		return swellings;
	}

	/**
	 * Set the value related to the column: swellings
	 * @param swellings the swellings value
	 */
	public void setSwellings (java.lang.String swellings) {
		this.swellings = swellings;
	}



	/**
	 * Return the value associated with the column: liver
	 */
	public java.lang.String getLiver () {
		return liver;
	}

	/**
	 * Set the value related to the column: liver
	 * @param liver the liver value
	 */
	public void setLiver (java.lang.String liver) {
		this.liver = liver;
	}



	/**
	 * Return the value associated with the column: renal_angles
	 */
	public java.lang.String getRenalAngles () {
		return renalAngles;
	}

	/**
	 * Set the value related to the column: renal_angles
	 * @param renalAngles the renal_angles value
	 */
	public void setRenalAngles (java.lang.String renalAngles) {
		this.renalAngles = renalAngles;
	}



	/**
	 * Return the value associated with the column: traube_space
	 */
	public java.lang.String getTraubeSpace () {
		return traubeSpace;
	}

	/**
	 * Set the value related to the column: traube_space
	 * @param traubeSpace the traube_space value
	 */
	public void setTraubeSpace (java.lang.String traubeSpace) {
		this.traubeSpace = traubeSpace;
	}



	/**
	 * Return the value associated with the column: ascites
	 */
	public java.lang.String getAscites () {
		return ascites;
	}

	/**
	 * Set the value related to the column: ascites
	 * @param ascites the ascites value
	 */
	public void setAscites (java.lang.String ascites) {
		this.ascites = ascites;
	}



	/**
	 * Return the value associated with the column: bruit
	 */
	public java.lang.String getBruit () {
		return bruit;
	}

	/**
	 * Set the value related to the column: bruit
	 * @param bruit the bruit value
	 */
	public void setBruit (java.lang.String bruit) {
		this.bruit = bruit;
	}



	/**
	 * Return the value associated with the column: gastro_intestinal_bruit_site
	 */
	public java.lang.String getGastroIntestinalBruitSite () {
		return gastroIntestinalBruitSite;
	}

	/**
	 * Set the value related to the column: gastro_intestinal_bruit_site
	 * @param gastroIntestinalBruitSite the gastro_intestinal_bruit_site value
	 */
	public void setGastroIntestinalBruitSite (java.lang.String gastroIntestinalBruitSite) {
		this.gastroIntestinalBruitSite = gastroIntestinalBruitSite;
	}



	/**
	 * Return the value associated with the column: gastro_intestinal_bruit_type
	 */
	public java.lang.String getGastroIntestinalBruitType () {
		return gastroIntestinalBruitType;
	}

	/**
	 * Set the value related to the column: gastro_intestinal_bruit_type
	 * @param gastroIntestinalBruitType the gastro_intestinal_bruit_type value
	 */
	public void setGastroIntestinalBruitType (java.lang.String gastroIntestinalBruitType) {
		this.gastroIntestinalBruitType = gastroIntestinalBruitType;
	}



	/**
	 * Return the value associated with the column: pr_examination
	 */
	public java.lang.String getPrExamination () {
		return prExamination;
	}

	/**
	 * Set the value related to the column: pr_examination
	 * @param prExamination the pr_examination value
	 */
	public void setPrExamination (java.lang.String prExamination) {
		this.prExamination = prExamination;
	}



	/**
	 * Return the value associated with the column: external_genitalia
	 */
	public java.lang.String getExternalGenitalia () {
		return externalGenitalia;
	}

	/**
	 * Set the value related to the column: external_genitalia
	 * @param externalGenitalia the external_genitalia value
	 */
	public void setExternalGenitalia (java.lang.String externalGenitalia) {
		this.externalGenitalia = externalGenitalia;
	}



	/**
	 * Return the value associated with the column: airentry
	 */
	public java.lang.String getAirentry () {
		return airentry;
	}

	/**
	 * Set the value related to the column: airentry
	 * @param airentry the airentry value
	 */
	public void setAirentry (java.lang.String airentry) {
		this.airentry = airentry;
	}



	/**
	 * Return the value associated with the column: respiratory_tenderness
	 */
	public java.lang.String getRespiratoryTenderness () {
		return respiratoryTenderness;
	}

	/**
	 * Set the value related to the column: respiratory_tenderness
	 * @param respiratoryTenderness the respiratory_tenderness value
	 */
	public void setRespiratoryTenderness (java.lang.String respiratoryTenderness) {
		this.respiratoryTenderness = respiratoryTenderness;
	}



	/**
	 * Return the value associated with the column: respiratory_tenderness_type
	 */
	public java.lang.String getRespiratoryTendernessType () {
		return respiratoryTendernessType;
	}

	/**
	 * Set the value related to the column: respiratory_tenderness_type
	 * @param respiratoryTendernessType the respiratory_tenderness_type value
	 */
	public void setRespiratoryTendernessType (java.lang.String respiratoryTendernessType) {
		this.respiratoryTendernessType = respiratoryTendernessType;
	}



	/**
	 * Return the value associated with the column: respiratory_tenderness_site
	 */
	public java.lang.String getRespiratoryTendernessSite () {
		return respiratoryTendernessSite;
	}

	/**
	 * Set the value related to the column: respiratory_tenderness_site
	 * @param respiratoryTendernessSite the respiratory_tenderness_site value
	 */
	public void setRespiratoryTendernessSite (java.lang.String respiratoryTendernessSite) {
		this.respiratoryTendernessSite = respiratoryTendernessSite;
	}



	/**
	 * Return the value associated with the column: rhonchi
	 */
	public java.lang.String getRhonchi () {
		return rhonchi;
	}

	/**
	 * Set the value related to the column: rhonchi
	 * @param rhonchi the rhonchi value
	 */
	public void setRhonchi (java.lang.String rhonchi) {
		this.rhonchi = rhonchi;
	}



	/**
	 * Return the value associated with the column: respiratory_rhonchi_site
	 */
	public java.lang.String getRespiratoryRhonchiSite () {
		return respiratoryRhonchiSite;
	}

	/**
	 * Set the value related to the column: respiratory_rhonchi_site
	 * @param respiratoryRhonchiSite the respiratory_rhonchi_site value
	 */
	public void setRespiratoryRhonchiSite (java.lang.String respiratoryRhonchiSite) {
		this.respiratoryRhonchiSite = respiratoryRhonchiSite;
	}



	/**
	 * Return the value associated with the column: respiratory_rhonchi_type
	 */
	public java.lang.String getRespiratoryRhonchiType () {
		return respiratoryRhonchiType;
	}

	/**
	 * Set the value related to the column: respiratory_rhonchi_type
	 * @param respiratoryRhonchiType the respiratory_rhonchi_type value
	 */
	public void setRespiratoryRhonchiType (java.lang.String respiratoryRhonchiType) {
		this.respiratoryRhonchiType = respiratoryRhonchiType;
	}



	/**
	 * Return the value associated with the column: respiratory_crepitaions
	 */
	public java.lang.String getRespiratoryCrepitaions () {
		return respiratoryCrepitaions;
	}

	/**
	 * Set the value related to the column: respiratory_crepitaions
	 * @param respiratoryCrepitaions the respiratory_crepitaions value
	 */
	public void setRespiratoryCrepitaions (java.lang.String respiratoryCrepitaions) {
		this.respiratoryCrepitaions = respiratoryCrepitaions;
	}



	/**
	 * Return the value associated with the column: respiratory_crepitaions_site
	 */
	public java.lang.String getRespiratoryCrepitaionsSite () {
		return respiratoryCrepitaionsSite;
	}

	/**
	 * Set the value related to the column: respiratory_crepitaions_site
	 * @param respiratoryCrepitaionsSite the respiratory_crepitaions_site value
	 */
	public void setRespiratoryCrepitaionsSite (java.lang.String respiratoryCrepitaionsSite) {
		this.respiratoryCrepitaionsSite = respiratoryCrepitaionsSite;
	}



	/**
	 * Return the value associated with the column: respiratory_crepitaions_type
	 */
	public java.lang.String getRespiratoryCrepitaionsType () {
		return respiratoryCrepitaionsType;
	}

	/**
	 * Set the value related to the column: respiratory_crepitaions_type
	 * @param respiratoryCrepitaionsType the respiratory_crepitaions_type value
	 */
	public void setRespiratoryCrepitaionsType (java.lang.String respiratoryCrepitaionsType) {
		this.respiratoryCrepitaionsType = respiratoryCrepitaionsType;
	}



	/**
	 * Return the value associated with the column: sounds
	 */
	public java.lang.String getSounds () {
		return sounds;
	}

	/**
	 * Set the value related to the column: sounds
	 * @param sounds the sounds value
	 */
	public void setSounds (java.lang.String sounds) {
		this.sounds = sounds;
	}



	/**
	 * Return the value associated with the column: cardiomegaly
	 */
	public java.lang.String getCardiomegaly () {
		return cardiomegaly;
	}

	/**
	 * Set the value related to the column: cardiomegaly
	 * @param cardiomegaly the cardiomegaly value
	 */
	public void setCardiomegaly (java.lang.String cardiomegaly) {
		this.cardiomegaly = cardiomegaly;
	}



	/**
	 * Return the value associated with the column: gcs
	 */
	public java.lang.String getGcs () {
		return gcs;
	}

	/**
	 * Set the value related to the column: gcs
	 * @param gcs the gcs value
	 */
	public void setGcs (java.lang.String gcs) {
		this.gcs = gcs;
	}



	/**
	 * Return the value associated with the column: gcs_total
	 */
	public java.lang.String getGcsTotal () {
		return gcsTotal;
	}

	/**
	 * Set the value related to the column: gcs_total
	 * @param gcsTotal the gcs_total value
	 */
	public void setGcsTotal (java.lang.String gcsTotal) {
		this.gcsTotal = gcsTotal;
	}



	/**
	 * Return the value associated with the column: cranial_nerves
	 */
	public java.lang.String getCranialNerves () {
		return cranialNerves;
	}

	/**
	 * Set the value related to the column: cranial_nerves
	 * @param cranialNerves the cranial_nerves value
	 */
	public void setCranialNerves (java.lang.String cranialNerves) {
		this.cranialNerves = cranialNerves;
	}



	/**
	 * Return the value associated with the column: reflexes
	 */
	public java.lang.String getReflexes () {
		return reflexes;
	}

	/**
	 * Set the value related to the column: reflexes
	 * @param reflexes the reflexes value
	 */
	public void setReflexes (java.lang.String reflexes) {
		this.reflexes = reflexes;
	}



	/**
	 * Return the value associated with the column: musculoskeletal_muscle_power
	 */
	public java.lang.String getMusculoskeletalMusclePower () {
		return musculoskeletalMusclePower;
	}

	/**
	 * Set the value related to the column: musculoskeletal_muscle_power
	 * @param musculoskeletalMusclePower the musculoskeletal_muscle_power value
	 */
	public void setMusculoskeletalMusclePower (java.lang.String musculoskeletalMusclePower) {
		this.musculoskeletalMusclePower = musculoskeletalMusclePower;
	}



	/**
	 * Return the value associated with the column: musculoskeletal_joints
	 */
	public java.lang.String getMusculoskeletalJoints () {
		return musculoskeletalJoints;
	}

	/**
	 * Set the value related to the column: musculoskeletal_joints
	 * @param musculoskeletalJoints the musculoskeletal_joints value
	 */
	public void setMusculoskeletalJoints (java.lang.String musculoskeletalJoints) {
		this.musculoskeletalJoints = musculoskeletalJoints;
	}



	/**
	 * Return the value associated with the column: plan
	 */
	public java.lang.String getPlan () {
		return plan;
	}

	/**
	 * Set the value related to the column: plan
	 * @param plan the plan value
	 */
	public void setPlan (java.lang.String plan) {
		this.plan = plan;
	}



	/**
	 * Return the value associated with the column: claudication_radiation
	 */
	public java.lang.String getClaudicationRadiation () {
		return claudicationRadiation;
	}

	/**
	 * Set the value related to the column: claudication_radiation
	 * @param claudicationRadiation the claudication_radiation value
	 */
	public void setClaudicationRadiation (java.lang.String claudicationRadiation) {
		this.claudicationRadiation = claudicationRadiation;
	}



	/**
	 * Return the value associated with the column: constipation_duration
	 */
	public java.lang.String getConstipationDuration () {
		return constipationDuration;
	}

	/**
	 * Set the value related to the column: constipation_duration
	 * @param constipationDuration the constipation_duration value
	 */
	public void setConstipationDuration (java.lang.String constipationDuration) {
		this.constipationDuration = constipationDuration;
	}



	/**
	 * Return the value associated with the column: smoking_number
	 */
	public java.lang.String getSmokingNumber () {
		return smokingNumber;
	}

	/**
	 * Set the value related to the column: smoking_number
	 * @param smokingNumber the smoking_number value
	 */
	public void setSmokingNumber (java.lang.String smokingNumber) {
		this.smokingNumber = smokingNumber;
	}



	/**
	 * Return the value associated with the column: smoking_day
	 */
	public java.lang.String getSmokingDay () {
		return smokingDay;
	}

	/**
	 * Set the value related to the column: smoking_day
	 * @param smokingDay the smoking_day value
	 */
	public void setSmokingDay (java.lang.String smokingDay) {
		this.smokingDay = smokingDay;
	}



	/**
	 * Return the value associated with the column: lmp_date
	 */
	public java.util.Date getLmpDate () {
		return lmpDate;
	}

	/**
	 * Set the value related to the column: lmp_date
	 * @param lmpDate the lmp_date value
	 */
	public void setLmpDate (java.util.Date lmpDate) {
		this.lmpDate = lmpDate;
	}



	/**
	 * Return the value associated with the column: ocp
	 */
	public java.lang.String getOcp () {
		return ocp;
	}

	/**
	 * Set the value related to the column: ocp
	 * @param ocp the ocp value
	 */
	public void setOcp (java.lang.String ocp) {
		this.ocp = ocp;
	}



	/**
	 * Return the value associated with the column: infertitility
	 */
	public java.lang.String getInfertitility () {
		return infertitility;
	}

	/**
	 * Set the value related to the column: infertitility
	 * @param infertitility the infertitility value
	 */
	public void setInfertitility (java.lang.String infertitility) {
		this.infertitility = infertitility;
	}



	/**
	 * Return the value associated with the column: general_examination
	 */
	public java.lang.String getGeneralExamination () {
		return generalExamination;
	}

	/**
	 * Set the value related to the column: general_examination
	 * @param generalExamination the general_examination value
	 */
	public void setGeneralExamination (java.lang.String generalExamination) {
		this.generalExamination = generalExamination;
	}



	/**
	 * Return the value associated with the column: bleeding
	 */
	public java.lang.String getBleeding () {
		return bleeding;
	}

	/**
	 * Set the value related to the column: bleeding
	 * @param bleeding the bleeding value
	 */
	public void setBleeding (java.lang.String bleeding) {
		this.bleeding = bleeding;
	}



	/**
	 * Return the value associated with the column: claudication
	 */
	public java.lang.String getClaudication () {
		return claudication;
	}

	/**
	 * Set the value related to the column: claudication
	 * @param claudication the claudication value
	 */
	public void setClaudication (java.lang.String claudication) {
		this.claudication = claudication;
	}



	/**
	 * Return the value associated with the column: constipation
	 */
	public java.lang.String getConstipation () {
		return constipation;
	}

	/**
	 * Set the value related to the column: constipation
	 * @param constipation the constipation value
	 */
	public void setConstipation (java.lang.String constipation) {
		this.constipation = constipation;
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
	 * Return the value associated with the column: dilated_veins
	 */
	public java.lang.String getDilatedVeins () {
		return dilatedVeins;
	}

	/**
	 * Set the value related to the column: dilated_veins
	 * @param dilatedVeins the dilated_veins value
	 */
	public void setDilatedVeins (java.lang.String dilatedVeins) {
		this.dilatedVeins = dilatedVeins;
	}



	/**
	 * Return the value associated with the column: discharge
	 */
	public java.lang.String getDischarge () {
		return discharge;
	}

	/**
	 * Set the value related to the column: discharge
	 * @param discharge the discharge value
	 */
	public void setDischarge (java.lang.String discharge) {
		this.discharge = discharge;
	}



	/**
	 * Return the value associated with the column: discoloration
	 */
	public java.lang.String getDiscoloration () {
		return discoloration;
	}

	/**
	 * Set the value related to the column: discoloration
	 * @param discoloration the discoloration value
	 */
	public void setDiscoloration (java.lang.String discoloration) {
		this.discoloration = discoloration;
	}



	/**
	 * Return the value associated with the column: distension
	 */
	public java.lang.String getDistension () {
		return distension;
	}

	/**
	 * Set the value related to the column: distension
	 * @param distension the distension value
	 */
	public void setDistension (java.lang.String distension) {
		this.distension = distension;
	}



	/**
	 * Return the value associated with the column: dysphagia
	 */
	public java.lang.String getDysphagia () {
		return dysphagia;
	}

	/**
	 * Set the value related to the column: dysphagia
	 * @param dysphagia the dysphagia value
	 */
	public void setDysphagia (java.lang.String dysphagia) {
		this.dysphagia = dysphagia;
	}



	/**
	 * Return the value associated with the column: dyspnea
	 */
	public java.lang.String getDyspnea () {
		return dyspnea;
	}

	/**
	 * Set the value related to the column: dyspnea
	 * @param dyspnea the dyspnea value
	 */
	public void setDyspnea (java.lang.String dyspnea) {
		this.dyspnea = dyspnea;
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
	 * Return the value associated with the column: fever
	 */
	public java.lang.String getFever () {
		return fever;
	}

	/**
	 * Set the value related to the column: fever
	 * @param fever the fever value
	 */
	public void setFever (java.lang.String fever) {
		this.fever = fever;
	}



	/**
	 * Return the value associated with the column: haematochezia
	 */
	public java.lang.String getHaematochezia () {
		return haematochezia;
	}

	/**
	 * Set the value related to the column: haematochezia
	 * @param haematochezia the haematochezia value
	 */
	public void setHaematochezia (java.lang.String haematochezia) {
		this.haematochezia = haematochezia;
	}



	/**
	 * Return the value associated with the column: haemetemesis
	 */
	public java.lang.String getHaemetemesis () {
		return haemetemesis;
	}

	/**
	 * Set the value related to the column: haemetemesis
	 * @param haemetemesis the haemetemesis value
	 */
	public void setHaemetemesis (java.lang.String haemetemesis) {
		this.haemetemesis = haemetemesis;
	}



	/**
	 * Return the value associated with the column: heartburn
	 */
	public java.lang.String getHeartburn () {
		return heartburn;
	}

	/**
	 * Set the value related to the column: heartburn
	 * @param heartburn the heartburn value
	 */
	public void setHeartburn (java.lang.String heartburn) {
		this.heartburn = heartburn;
	}



	/**
	 * Return the value associated with the column: jaundice
	 */
	public java.lang.String getJaundice () {
		return jaundice;
	}

	/**
	 * Set the value related to the column: jaundice
	 * @param jaundice the jaundice value
	 */
	public void setJaundice (java.lang.String jaundice) {
		this.jaundice = jaundice;
	}



	/**
	 * Return the value associated with the column: malena
	 */
	public java.lang.String getMalena () {
		return malena;
	}

	/**
	 * Set the value related to the column: malena
	 * @param malena the malena value
	 */
	public void setMalena (java.lang.String malena) {
		this.malena = malena;
	}



	/**
	 * Return the value associated with the column: nausea
	 */
	public java.lang.String getNausea () {
		return nausea;
	}

	/**
	 * Set the value related to the column: nausea
	 * @param nausea the nausea value
	 */
	public void setNausea (java.lang.String nausea) {
		this.nausea = nausea;
	}



	/**
	 * Return the value associated with the column: pain
	 */
	public java.lang.String getPain () {
		return pain;
	}

	/**
	 * Set the value related to the column: pain
	 * @param pain the pain value
	 */
	public void setPain (java.lang.String pain) {
		this.pain = pain;
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
	 * Return the value associated with the column: trauma
	 */
	public java.lang.String getTrauma () {
		return trauma;
	}

	/**
	 * Set the value related to the column: trauma
	 * @param trauma the trauma value
	 */
	public void setTrauma (java.lang.String trauma) {
		this.trauma = trauma;
	}



	/**
	 * Return the value associated with the column: ulcer
	 */
	public java.lang.String getUlcer () {
		return ulcer;
	}

	/**
	 * Set the value related to the column: ulcer
	 * @param ulcer the ulcer value
	 */
	public void setUlcer (java.lang.String ulcer) {
		this.ulcer = ulcer;
	}



	/**
	 * Return the value associated with the column: urinary_obstruction
	 */
	public java.lang.String getUrinaryObstruction () {
		return urinaryObstruction;
	}

	/**
	 * Set the value related to the column: urinary_obstruction
	 * @param urinaryObstruction the urinary_obstruction value
	 */
	public void setUrinaryObstruction (java.lang.String urinaryObstruction) {
		this.urinaryObstruction = urinaryObstruction;
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
	 * Return the value associated with the column: personal_habits
	 */
	public java.lang.String getPersonalHabits () {
		return personalHabits;
	}

	/**
	 * Set the value related to the column: personal_habits
	 * @param personalHabits the personal_habits value
	 */
	public void setPersonalHabits (java.lang.String personalHabits) {
		this.personalHabits = personalHabits;
	}



	/**
	 * Return the value associated with the column: smoking_value
	 */
	public java.lang.String getSmokingValue () {
		return smokingValue;
	}

	/**
	 * Set the value related to the column: smoking_value
	 * @param smokingValue the smoking_value value
	 */
	public void setSmokingValue (java.lang.String smokingValue) {
		this.smokingValue = smokingValue;
	}



	/**
	 * Return the value associated with the column: alcohol_value
	 */
	public java.lang.String getAlcoholValue () {
		return alcoholValue;
	}

	/**
	 * Set the value related to the column: alcohol_value
	 * @param alcoholValue the alcohol_value value
	 */
	public void setAlcoholValue (java.lang.String alcoholValue) {
		this.alcoholValue = alcoholValue;
	}



	/**
	 * Return the value associated with the column: other_addiction_value
	 */
	public java.lang.String getOtherAddictionValue () {
		return otherAddictionValue;
	}

	/**
	 * Set the value related to the column: other_addiction_value
	 * @param otherAddictionValue the other_addiction_value value
	 */
	public void setOtherAddictionValue (java.lang.String otherAddictionValue) {
		this.otherAddictionValue = otherAddictionValue;
	}



	/**
	 * Return the value associated with the column: swelling_check
	 */
	public java.lang.String getSwellingCheck () {
		return swellingCheck;
	}

	/**
	 * Set the value related to the column: swelling_check
	 * @param swellingCheck the swelling_check value
	 */
	public void setSwellingCheck (java.lang.String swellingCheck) {
		this.swellingCheck = swellingCheck;
	}



	/**
	 * Return the value associated with the column: liver_check
	 */
	public java.lang.String getLiverCheck () {
		return liverCheck;
	}

	/**
	 * Set the value related to the column: liver_check
	 * @param liverCheck the liver_check value
	 */
	public void setLiverCheck (java.lang.String liverCheck) {
		this.liverCheck = liverCheck;
	}



	/**
	 * Return the value associated with the column: eye_opening_response
	 */
	public java.lang.String getEyeOpeningResponse () {
		return eyeOpeningResponse;
	}

	/**
	 * Set the value related to the column: eye_opening_response
	 * @param eyeOpeningResponse the eye_opening_response value
	 */
	public void setEyeOpeningResponse (java.lang.String eyeOpeningResponse) {
		this.eyeOpeningResponse = eyeOpeningResponse;
	}



	/**
	 * Return the value associated with the column: verbal_response
	 */
	public java.lang.String getVerbalResponse () {
		return verbalResponse;
	}

	/**
	 * Set the value related to the column: verbal_response
	 * @param verbalResponse the verbal_response value
	 */
	public void setVerbalResponse (java.lang.String verbalResponse) {
		this.verbalResponse = verbalResponse;
	}



	/**
	 * Return the value associated with the column: motor_response
	 */
	public java.lang.String getMotorResponse () {
		return motorResponse;
	}

	/**
	 * Set the value related to the column: motor_response
	 * @param motorResponse the motor_response value
	 */
	public void setMotorResponse (java.lang.String motorResponse) {
		this.motorResponse = motorResponse;
	}



	/**
	 * Return the value associated with the column: head_injury_classification
	 */
	public java.lang.String getHeadInjuryClassification () {
		return headInjuryClassification;
	}

	/**
	 * Set the value related to the column: head_injury_classification
	 * @param headInjuryClassification the head_injury_classification value
	 */
	public void setHeadInjuryClassification (java.lang.String headInjuryClassification) {
		this.headInjuryClassification = headInjuryClassification;
	}



	/**
	 * Return the value associated with the column: generalized_lymphadenopathy_txt_value
	 */
	public java.lang.String getGeneralizedLymphadenopathyTxtValue () {
		return generalizedLymphadenopathyTxtValue;
	}

	/**
	 * Set the value related to the column: generalized_lymphadenopathy_txt_value
	 * @param generalizedLymphadenopathyTxtValue the generalized_lymphadenopathy_txt_value value
	 */
	public void setGeneralizedLymphadenopathyTxtValue (java.lang.String generalizedLymphadenopathyTxtValue) {
		this.generalizedLymphadenopathyTxtValue = generalizedLymphadenopathyTxtValue;
	}



	/**
	 * Return the value associated with the column: others_data
	 */
	public java.lang.String getOthersData () {
		return othersData;
	}

	/**
	 * Set the value related to the column: others_data
	 * @param othersData the others_data value
	 */
	public void setOthersData (java.lang.String othersData) {
		this.othersData = othersData;
	}



	/**
	 * Return the value associated with the column: fluid_thrill
	 */
	public java.lang.String getFluidThrill () {
		return fluidThrill;
	}

	/**
	 * Set the value related to the column: fluid_thrill
	 * @param fluidThrill the fluid_thrill value
	 */
	public void setFluidThrill (java.lang.String fluidThrill) {
		this.fluidThrill = fluidThrill;
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
	 * Return the value associated with the column: type_of_delivery
	 */
	public jkt.hms.masters.business.MasDeliveryType getTypeOfDelivery () {
		return typeOfDelivery;
	}

	/**
	 * Set the value related to the column: type_of_delivery
	 * @param typeOfDelivery the type_of_delivery value
	 */
	public void setTypeOfDelivery (jkt.hms.masters.business.MasDeliveryType typeOfDelivery) {
		this.typeOfDelivery = typeOfDelivery;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdGeneralSurgerySpeciality)) return false;
		else {
			jkt.hms.masters.business.OpdGeneralSurgerySpeciality opdGeneralSurgerySpeciality = (jkt.hms.masters.business.OpdGeneralSurgerySpeciality) obj;
			if (null == this.getId() || null == opdGeneralSurgerySpeciality.getId()) return false;
			else return (this.getId().equals(opdGeneralSurgerySpeciality.getId()));
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