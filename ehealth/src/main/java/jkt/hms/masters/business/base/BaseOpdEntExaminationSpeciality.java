package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_ent_examination_speciality table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_ent_examination_speciality"
 */

public abstract class BaseOpdEntExaminationSpeciality  implements Serializable {

	public static String REF = "OpdEntExaminationSpeciality";
	public static String PROP_VESTIBULE_AND_COLUMELLA = "VestibuleAndColumella";
	public static String PROP_LEFT_POSTERIOR_TURBINATES = "LeftPosteriorTurbinates";
	public static String PROP_SIZE = "Size";
	public static String PROP_RIGHT_MT = "RightMt";
	public static String PROP_RIGHT_CHOANE_VALUE = "RightChoaneValue";
	public static String PROP_NOSE_RIGHT_IM = "noseRightIm";
	public static String PROP_LEFT_PARSE_TENSA = "LeftParseTensa";
	public static String PROP_RIGHT_TRAGAL_TENDERNESS = "RightTragalTenderness";
	public static String PROP_LEFT_MASTOID_TENDERNESS = "LeftMastoidTenderness";
	public static String PROP_NOSE_RIGHT_IT = "noseRightIt";
	public static String PROP_WEBER = "Weber";
	public static String PROP_NOSE_LEFT_FLOOR = "noseLeftFloor";
	public static String PROP_PARSE_FLACCIDA_VALUE_RIGHT = "ParseFlaccidaValueRight";
	public static String PROP_LEFT_FRONTAL = "LeftFrontal";
	public static String PROP_RIGHT_POSTERIOR_TURBINATES_VALUE = "RightPosteriorTurbinatesValue";
	public static String PROP_THYROID = "Thyroid";
	public static String PROP_LYMPHNODES = "Lymphnodes";
	public static String PROP_BUCCAL_MUCOSA = "BuccalMucosa";
	public static String PROP_BRUIT = "Bruit";
	public static String PROP_POSTERIO_PHARYNGEAL_WALL = "PosterioPharyngealWall";
	public static String PROP_RIGHT_MASTOID_TENDERNESS = "RightMastoidTenderness";
	public static String PROP_LEFT_TYMPANIC_MEMBRANE = "LeftTympanicMembrane";
	public static String PROP_LARYNGEAL_FRAMEWORK_VALUE = "LaryngealFrameworkValue";
	public static String PROP_RIGHT_PINNA = "RightPinna";
	public static String PROP_MOVEMENTS_ON_DEGLUTITION = "MovementsOnDeglutition";
	public static String PROP_RIGHT_TRAGAL_TENDERNESS_VALUE = "RightTragalTendernessValue";
	public static String PROP_PULSATION = "Pulsation";
	public static String PROP_EYE_AND_ORBIT = "EyeAndOrbit";
	public static String PROP_LIPS = "Lips";
	public static String PROP_TYMPANIC_RIGHT_PERFORATION = "TympanicRightPerforation";
	public static String PROP_LEFT_CENTRAL = "LeftCentral";
	public static String PROP_LEFT_CHOANE_VALUE = "LeftChoaneValue";
	public static String PROP_RIGHT_POSTERIOR_PILLAR = "RightPosteriorPillar";
	public static String PROP_LEFT_PINNA = "LeftPinna";
	public static String PROP_SURFACE = "Surface";
	public static String PROP_RIGHT_CONSISTENCY = "RightConsistency";
	public static String PROP_MARGINAL_VALUE_LEFT = "MarginalValueLeft";
	public static String PROP_SPONTANEOUS_NYSTAGMUS_DIRECTION = "SpontaneousNystagmusDirection";
	public static String PROP_LYMPHENODES_VALUE = "LymphenodesValue";
	public static String PROP_CLUBBING = "Clubbing";
	public static String PROP_EDEMA = "Edema";
	public static String PROP_LEFT256HZ_RINNES = "Left256hzRinnes";
	public static String PROP_SEPTUM = "Septum";
	public static String PROP_LEFT_SURFACE = "LeftSurface";
	public static String PROP_LEFT_MOBILITY_VALUE = "LeftMobilityValue";
	public static String PROP_RIGHT_MAXILLARY = "RightMaxillary";
	public static String PROP_RIGHT_MM = "RightMm";
	public static String PROP_LEFT_DISCHARGE = "LeftDischarge";
	public static String PROP_RIGHT_MIDDLE_EAR_MUCOSA = "RightMiddleEarMucosa";
	public static String PROP_LARYNGEAL_FRAMEWORK = "LaryngealFramework";
	public static String PROP_LEFT_TRAGAL_TENDERNESS_VALUE = "LeftTragalTendernessValue";
	public static String PROP_LOWER_LIPS = "LowerLips";
	public static String PROP_TONGUE = "Tongue";
	public static String PROP_ANY_OTHER = "AnyOther";
	public static String PROP_RIGHT_IM = "RightIm";
	public static String PROP_LEFT_SIZE = "LeftSize";
	public static String PROP_GUMS_VALUE = "GumsValue";
	public static String PROP_RIGHT_IT = "RightIt";
	public static String PROP_FIXITY_TO_DEEPER_STRUCTURES = "FixityToDeeperStructures";
	public static String PROP_RIGHT_VESTIBULE = "RightVestibule";
	public static String PROP_ANY_OTHER_FINDING = "AnyOtherFinding";
	public static String PROP_LEFT_MAXILLARY = "LeftMaxillary";
	public static String PROP_RIGHT_FISTULA_SIGN_DIRECTION = "RightFistulaSignDirection";
	public static String PROP_ENGORGED_VEINS = "EngorgedVeins";
	public static String PROP_RIGHT_POSTNATAL_ROOF = "RightPostnatalRoof";
	public static String PROP_LEFT_ANTERIOR_PILLAR = "LeftAnteriorPillar";
	public static String PROP_TYMPANIC_MEMBRANE = "TympanicMembrane";
	public static String PROP_GINGIVO_BUCCAL_SULCUS = "GingivoBuccalSulcus";
	public static String PROP_LEFT_FISTULA_SIGN_DEGREE = "LeftFistulaSignDegree";
	public static String PROP_MOVEMENTS_WITH_PROTRUSION_OF_TONGUE = "MovementsWithProtrusionOfTongue";
	public static String PROP_ICTERUS = "Icterus";
	public static String PROP_NOSE_SEPTUM = "noseSeptum";
	public static String PROP_RIGHT_FISTULA_SIGN_DEGREE = "RightFistulaSignDegree";
	public static String PROP_LEFT_GRADING = "LeftGrading";
	public static String PROP_VESTIBULE_AND_COLUMELLA_VALUE = "VestibuleAndColumellaValue";
	public static String PROP_DEVIATION = "Deviation";
	public static String PROP_GINGIVO_LABIAL_SULCUS = "GingivoLabialSulcus";
	public static String PROP_RIGHT_EXTERNAL_AUDITORY_CANAL = "RightExternalAuditoryCanal";
	public static String PROP_LEFT_IM = "LeftIm";
	public static String PROP_RIGHT_GRADING = "RightGrading";
	public static String PROP_SKIN_OVER_SWELLING = "SkinOverSwelling";
	public static String PROP_EXTERNAL_APPEARANCE = "ExternalAppearance";
	public static String PROP_MOUTH_OPENING_VALUE = "MouthOpeningValue";
	public static String PROP_LEFT_SURFACE_VALUE = "LeftSurfaceValue";
	public static String PROP_LEFT_IT = "LeftIt";
	public static String PROP_LEFT_ET_ONLIAE_VALUE = "LeftEtOnliaeValue";
	public static String PROP_COLD_SPATULA_TEST = "ColdSpatulaTest";
	public static String PROP_RIGHT_FACIAL_NREVE = "RightFacialNreve";
	public static String PROP_LEFT_CHOANE = "LeftChoane";
	public static String PROP_LEFT_RETRO_MOLAR_TRIGONE = "LeftRetroMolarTrigone";
	public static String PROP_LEFT_POSTERIOR_TURBINATES_VALUE = "LeftPosteriorTurbinatesValue";
	public static String PROP_RIGHT_CHOANE = "RightChoane";
	public static String PROP_TONGUE_VALUE = "TongueValue";
	public static String PROP_LEFT_PREAURICULAR_AREA = "LeftPreauricularArea";
	public static String PROP_OPENING_OF_SALIVARY_DUCT = "OpeningOfSalivaryDuct";
	public static String PROP_PALLOR = "Pallor";
	public static String PROP_RIGHT_FISTULA_SIGN_VALUE = "RightFistulaSignValue";
	public static String PROP_PALPABLE_PULSATION = "PalpablePulsation";
	public static String PROP_NOSE_LEFT_ROOF = "noseLeftRoof";
	public static String PROP_FIXITY_TO_DEEPER_STRUCTURES_VALUE = "FixityToDeeperStructuresValue";
	public static String PROP_INTERNAL_JUGULAR_VEIN = "InternalJugularVein";
	public static String PROP_LEFT_EXTERNAL_AUDITORY_CANAL = "LeftExternalAuditoryCanal";
	public static String PROP_GUMS = "Gums";
	public static String PROP_SPONTANEOUS_NYSTAGMUS = "SpontaneousNystagmus";
	public static String PROP_RIGHT_DISCHARGE = "RightDischarge";
	public static String PROP_RIGHT_FISTULA_SIGN = "RightFistulaSign";
	public static String PROP_RIGHT_ROOF = "RightRoof";
	public static String PROP_LEFT_RETRO_MOLAR_TRIGONE_VALUE = "LeftRetroMolarTrigoneValue";
	public static String PROP_NOSE_LEFT_IT = "noseLeftIt";
	public static String PROP_MOUTH_OPENING = "MouthOpening";
	public static String PROP_LEFT_POSTNATAL_ROOF_VALUE = "LeftPostnatalRoofValue";
	public static String PROP_SWELLING = "Swelling";
	public static String PROP_NOSE_LEFT_IM = "noseLeftIm";
	public static String PROP_EXTERNAL_APPEARANCE_VALUE = "ExternalAppearanceValue";
	public static String PROP_LEFT_POSTERIOR_PILLAR = "LeftPosteriorPillar";
	public static String PROP_OLFACTION_VALUE_LEFT = "OlfactionValueLeft";
	public static String PROP_LEFT_MIDDLE_EAR_MUCOSA = "LeftMiddleEarMucosa";
	public static String PROP_RIGHT_TYMPANIC_MEMBRANE = "RightTympanicMembrane";
	public static String PROP_RIGHT_COLUMELLA = "RightColumella";
	public static String PROP_RIGHT_ANTERIOR_PILLAR = "RightAnteriorPillar";
	public static String PROP_RIGHT_CENTRAL = "RightCentral";
	public static String PROP_SPONTANEOUS_NYSTAGMUS_DIRECTION_VALUE = "SpontaneousNystagmusDirectionValue";
	public static String PROP_RIGHT_MOBILITY_VALUE = "RightMobilityValue";
	public static String PROP_RINNE_OTHER_VALUE_LEFT = "RinneOtherValueLeft";
	public static String PROP_LYMPHADENOPATHY = "Lymphadenopathy";
	public static String PROP_FRENULUM = "Frenulum";
	public static String PROP_LEFT_FISTULA_SIGN = "LeftFistulaSign";
	public static String PROP_LEFT_TRAGAL_TENDERNESS = "LeftTragalTenderness";
	public static String PROP_ABSOLUTE_BONE_CONDUCTION_TEST = "AbsoluteBoneConductionTest";
	public static String PROP_LEFT_MARGINS = "LeftMargins";
	public static String PROP_CAROTID = "Carotid";
	public static String PROP_LEFT_ETHMOID = "LeftEthmoid";
	public static String PROP_ID = "Id";
	public static String PROP_LEFT_MT = "LeftMt";
	public static String PROP_SHAPE = "Shape";
	public static String PROP_RIGHT_PHARYNGEAL_WALL = "RightPharyngealWall";
	public static String PROP_LARYNGEAL_CREPITUS = "LaryngealCrepitus";
	public static String PROP_LEFT_PHARYNGEAL_WALL = "LeftPharyngealWall";
	public static String PROP_RIGHT_PREAURICULAR_AREA = "RightPreauricularArea";
	public static String PROP_LEFT_MM = "LeftMm";
	public static String PROP_RIGHT1024HZ_RINNES = "Right1024hzRinnes";
	public static String PROP_TEETH_VALUE = "TeethValue";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_RIGHT_SURFACE_VALUE = "RightSurfaceValue";
	public static String PROP_RIGHT_VESTIBULE_VALUE = "RightVestibuleValue";
	public static String PROP_CYANOSIS = "Cyanosis";
	public static String PROP_LEFT_DEVIATION = "LeftDeviation";
	public static String PROP_OLFACTION_VALUE_RIGHT = "OlfactionValueRight";
	public static String PROP_LEFT512HZ_RINNES = "Left512hzRinnes";
	public static String PROP_LEFT_FISTULA_SIGN_VALUE = "LeftFistulaSignValue";
	public static String PROP_LEFT_COLUMELLA_VALUE = "LeftColumellaValue";
	public static String PROP_LEFT_FISTULA_SIGN_DIRECTION = "LeftFistulaSignDirection";
	public static String PROP_RIGHT_FOR = "RightFor";
	public static String PROP_HIN = "Hin";
	public static String PROP_APPEARANCE = "Appearance";
	public static String PROP_POSTERIOR_SEPTUM_VALUE = "PosteriorSeptumValue";
	public static String PROP_RIGHT_RETRO_MOLAR_TRIGONE_VALUE = "RightRetroMolarTrigoneValue";
	public static String PROP_PARSE_FLACCIDA_VALUE_LEFT = "ParseFlaccidaValueLeft";
	public static String PROP_IMAGE_NAME = "ImageName";
	public static String PROP_LEFT_FACIAL_NREVE = "LeftFacialNreve";
	public static String PROP_LEFT_SOFT_PALETTE = "LeftSoftPalette";
	public static String PROP_RIGHT_RETRO_MOLAR_TRIGONE = "RightRetroMolarTrigone";
	public static String PROP_LEFT_FOR_VALUE = "LeftForValue";
	public static String PROP_LIPS_VALUE = "LipsValue";
	public static String PROP_NOSE_RIGHT_FLOOR = "noseRightFloor";
	public static String PROP_LARYNGEAL_CREPITUS_ANOTHER = "LaryngealCrepitusAnother";
	public static String PROP_LOWER_LIPS_VALUE = "LowerLipsValue";
	public static String PROP_SKULL_AND_SPINE = "SkullAndSpine";
	public static String PROP_NOSE_RIGHT_MM = "noseRightMm";
	public static String PROP_NOSE_RIGHT_MT = "noseRightMt";
	public static String PROP_IDL_FINDINGS = "IdlFindings";
	public static String PROP_LYMPHADENOPATHY_VALUE = "LymphadenopathyValue";
	public static String PROP_LEFT_POST_AURICULAR_AREA = "LeftPostAuricularArea";
	public static String PROP_NOSE_LEFT_MT = "noseLeftMt";
	public static String PROP_RIGHT_FRONTAL = "RightFrontal";
	public static String PROP_RIGHT_ET_ONLIAE_VALUE = "RightEtOnliaeValue";
	public static String PROP_NOSE_LEFT_MM = "noseLeftMm";
	public static String PROP_RINNE_OTHER_VALUE_RIGHT = "RinneOtherValueRight";
	public static String PROP_LEFT_FOR = "LeftFor";
	public static String PROP_CEREBELLAR_SIGNS = "CerebellarSigns";
	public static String PROP_LEFT_CONSISTENCY = "LeftConsistency";
	public static String PROP_TEETH = "Teeth";
	public static String PROP_LEFT_LEVEL = "LeftLevel";
	public static String PROP_RIGHT_DEVIATION = "RightDeviation";
	public static String PROP_PALPABLE_PULSATION_VALUE = "PalpablePulsationValue";
	public static String PROP_RIGHT_ET_ONLIAE = "RightEtOnliae";
	public static String PROP_ANY_OTHER_SWELLING = "AnyOtherSwelling";
	public static String PROP_RIGHT_MOBILITY = "RightMobility";
	public static String PROP_LEFT_VESTIBULE = "LeftVestibule";
	public static String PROP_RIGHT256HZ_RINNES = "Right256hzRinnes";
	public static String PROP_RIGHT_ETHMOID = "RightEthmoid";
	public static String PROP_RIGHT_MARGINS = "RightMargins";
	public static String PROP_FLOOR_OF_MOUTH = "FloorOfMouth";
	public static String PROP_LEFT_ET_ONLIAE = "LeftEtOnliae";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LEFT1024HZ_RINNES = "Left1024hzRinnes";
	public static String PROP_LEFT_FLOOR = "LeftFloor";
	public static String PROP_RIGHT_SOFT_PALETTE = "RightSoftPalette";
	public static String PROP_RIGHT_FLOOR = "RightFloor";
	public static String PROP_RIGHT_SURFACE = "RightSurface";
	public static String PROP_LEFT_VESTIBULE_VALUE = "LeftVestibuleValue";
	public static String PROP_RIGHT_FOR_VALUE = "RightForValue";
	public static String PROP_NOSE_RIGHT_ROOF = "noseRightRoof";
	public static String PROP_RIGHT_POSTNATAL_ROOF_VALUE = "RightPostnatalRoofValue";
	public static String PROP_RIGHT_PARSE_TENSA = "RightParseTensa";
	public static String PROP_LEFT_TONSIL = "LeftTonsil";
	public static String PROP_SPONTANEOUS_NYSTAGMUS_DEGREE = "SpontaneousNystagmusDegree";
	public static String PROP_TENDERNESS = "Tenderness";
	public static String PROP_RIGHT_ABSOLUTE_BONE_CONDUCTION_TEST = "RightAbsoluteBoneConductionTest";
	public static String PROP_HARD_PALATE = "HardPalate";
	public static String PROP_LEFT_ROOF = "LeftRoof";
	public static String PROP_RIGHT_LEVEL = "RightLevel";
	public static String PROP_RIGHT_TONSIL = "RightTonsil";
	public static String PROP_LEFT_COLUMELLA = "LeftColumella";
	public static String PROP_POSTERIOR_SEPTUM = "PosteriorSeptum";
	public static String PROP_SIGNS_OF_MENINGEAL_IRRITATION = "SignsOfMeningealIrritation";
	public static String PROP_RIGHT_COLUMELLA_VALUE = "RightColumellaValue";
	public static String PROP_MARGINAL_VALUE_RIGHT = "MarginalValueRight";
	public static String PROP_RIGHT_POST_AURICULAR_AREA = "RightPostAuricularArea";
	public static String PROP_LEFT_MOBILITY = "LeftMobility";
	public static String PROP_TYMPANIC_LEFT_PERFORATION = "TympanicLeftPerforation";
	public static String PROP_LEFT_POSTNATAL_ROOF = "LeftPostnatalRoof";
	public static String PROP_RIGHT_SIZE = "RightSize";
	public static String PROP_RIGHT512HZ_RINNES = "Right512hzRinnes";
	public static String PROP_RIGHT_POSTERIOR_TURBINATES = "RightPosteriorTurbinates";


	// constructors
	public BaseOpdEntExaminationSpeciality () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdEntExaminationSpeciality (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String rightPinna;
	private java.lang.String leftPinna;
	private java.lang.String rightPreauricularArea;
	private java.lang.String leftPreauricularArea;
	private java.lang.String rightPostAuricularArea;
	private java.lang.String leftPostAuricularArea;
	private java.lang.String rightTragalTenderness;
	private java.lang.String leftTragalTenderness;
	private java.lang.String rightExternalAuditoryCanal;
	private java.lang.String leftExternalAuditoryCanal;
	private java.lang.String left256hzRinnes;
	private java.lang.String right256hzRinnes;
	private java.lang.String left512hzRinnes;
	private java.lang.String right512hzRinnes;
	private java.lang.String left1024hzRinnes;
	private java.lang.String right1024hzRinnes;
	private java.lang.String weber;
	private java.lang.String rightAbsoluteBoneConductionTest;
	private java.lang.String absoluteBoneConductionTest;
	private java.lang.String leftMastoidTenderness;
	private java.lang.String rightMastoidTenderness;
	private java.lang.String leftFacialNreve;
	private java.lang.String rightFacialNreve;
	private java.lang.String leftGrading;
	private java.lang.String rightGrading;
	private java.lang.String spontaneousNystagmusDegree;
	private java.lang.String spontaneousNystagmusDirection;
	private java.lang.String leftFistulaSign;
	private java.lang.String leftFistulaSignValue;
	private java.lang.String rightFistulaSign;
	private java.lang.String rightFistulaSignValue;
	private java.lang.String skullAndSpine;
	private java.lang.String cerebellarSigns;
	private java.lang.String externalAppearance;
	private java.lang.String coldSpatulaTest;
	private java.lang.String vestibuleAndColumella;
	private java.lang.String leftMaxillary;
	private java.lang.String rightMaxillary;
	private java.lang.String leftFrontal;
	private java.lang.String rightFrontal;
	private java.lang.String leftEthmoid;
	private java.lang.String rightEthmoid;
	private java.lang.String lips;
	private java.lang.String gums;
	private java.lang.String gumsValue;
	private java.lang.String gingivoLabialSulcus;
	private java.lang.String floorOfMouth;
	private java.lang.String buccalMucosa;
	private java.lang.String posterioPharyngealWall;
	private java.lang.String idlFindings;
	private java.lang.String swelling;
	private java.lang.String size;
	private java.lang.String shape;
	private java.lang.String surface;
	private java.lang.String skinOverSwelling;
	private java.lang.String movementsOnDeglutition;
	private java.lang.String engorgedVeins;
	private java.lang.String pulsation;
	private java.lang.String tenderness;
	private java.lang.String fixityToDeeperStructures;
	private java.lang.String palpablePulsation;
	private java.lang.String laryngealCrepitus;
	private java.lang.String laryngealCrepitusAnother;
	private java.lang.String bruit;
	private java.lang.String leftTragalTendernessValue;
	private java.lang.String rightTragalTendernessValue;
	private java.lang.String spontaneousNystagmusDirectionValue;
	private java.lang.String leftFistulaSignDegree;
	private java.lang.String leftFistulaSignDirection;
	private java.lang.String rightFistulaSignDegree;
	private java.lang.String rightFistulaSignDirection;
	private java.lang.String tympanicMembrane;
	private java.lang.String externalAppearanceValue;
	private java.lang.String vestibuleAndColumellaValue;
	private java.lang.String lowerLips;
	private java.lang.String lowerLipsValue;
	private java.lang.String lipsValue;
	private java.lang.String movementsWithProtrusionOfTongue;
	private java.lang.String fixityToDeeperStructuresValue;
	private java.lang.String spontaneousNystagmus;
	private java.lang.String leftTympanicMembrane;
	private java.lang.String rightTympanicMembrane;
	private java.lang.String leftVestibule;
	private java.lang.String leftColumella;
	private java.lang.String leftVestibuleValue;
	private java.lang.String leftColumellaValue;
	private java.lang.String rightVestibule;
	private java.lang.String rightVestibuleValue;
	private java.lang.String rightColumella;
	private java.lang.String rightColumellaValue;
	private java.lang.String septum;
	private java.lang.String leftIt;
	private java.lang.String rightIt;
	private java.lang.String leftIm;
	private java.lang.String rightIm;
	private java.lang.String leftMt;
	private java.lang.String rightMt;
	private java.lang.String leftMm;
	private java.lang.String rightMm;
	private java.lang.String leftFloor;
	private java.lang.String rightFloor;
	private java.lang.String leftRoof;
	private java.lang.String rightRoof;
	private java.lang.String posteriorSeptum;
	private java.lang.String posteriorSeptumValue;
	private java.lang.String leftChoane;
	private java.lang.String rightChoane;
	private java.lang.String leftPostnatalRoof;
	private java.lang.String rightPostnatalRoof;
	private java.lang.String leftEtOnliae;
	private java.lang.String rightEtOnliae;
	private java.lang.String leftFor;
	private java.lang.String rightFor;
	private java.lang.String leftPosteriorTurbinates;
	private java.lang.String rightPosteriorTurbinates;
	private java.lang.String teeth;
	private java.lang.String teethValue;
	private java.lang.String frenulum;
	private java.lang.String openingOfSalivaryDuct;
	private java.lang.String anyOtherFinding;
	private java.lang.String leftRetroMolarTrigone;
	private java.lang.String leftRetroMolarTrigoneValue;
	private java.lang.String rightRetroMolarTrigone;
	private java.lang.String rightRetroMolarTrigoneValue;
	private java.lang.String mouthOpening;
	private java.lang.String mouthOpeningValue;
	private java.lang.String appearance;
	private java.lang.String deviation;
	private java.lang.String leftSoftPalette;
	private java.lang.String rightSoftPalette;
	private java.lang.String leftAnteriorPillar;
	private java.lang.String rightAnteriorPillar;
	private java.lang.String leftTonsil;
	private java.lang.String rightTonsil;
	private java.lang.String leftPosteriorPillar;
	private java.lang.String rightPosteriorPillar;
	private java.lang.String leftPharyngealWall;
	private java.lang.String rightPharyngealWall;
	private java.lang.String lymphnodes;
	private java.lang.String lymphenodesValue;
	private java.lang.String rightLevel;
	private java.lang.String leftLevel;
	private java.lang.String rightSize;
	private java.lang.String leftSize;
	private java.lang.String rightConsistency;
	private java.lang.String leftConsistency;
	private java.lang.String rightSurface;
	private java.lang.String rightSurfaceValue;
	private java.lang.String leftSurface;
	private java.lang.String leftSurfaceValue;
	private java.lang.String rightMargins;
	private java.lang.String leftMargins;
	private java.lang.String rightMobility;
	private java.lang.String rightMobilityValue;
	private java.lang.String leftMobility;
	private java.lang.String leftMobilityValue;
	private java.lang.String laryngealFramework;
	private java.lang.String laryngealFrameworkValue;
	private java.lang.String thyroid;
	private java.lang.String carotid;
	private java.lang.String internalJugularVein;
	private java.lang.String anyOtherSwelling;
	private java.lang.String pallor;
	private java.lang.String icterus;
	private java.lang.String cyanosis;
	private java.lang.String clubbing;
	private java.lang.String lymphadenopathy;
	private java.lang.String edema;
	private java.lang.String anyOther;
	private java.lang.String leftChoaneValue;
	private java.lang.String rightChoaneValue;
	private java.lang.String leftPostnatalRoofValue;
	private java.lang.String rightPostnatalRoofValue;
	private java.lang.String leftEtOnliaeValue;
	private java.lang.String rightEtOnliaeValue;
	private java.lang.String leftForValue;
	private java.lang.String rightForValue;
	private java.lang.String leftPosteriorTurbinatesValue;
	private java.lang.String rightPosteriorTurbinatesValue;
	private java.lang.String tongue;
	private java.lang.String tongueValue;
	private java.lang.String leftDeviation;
	private java.lang.String rightDeviation;
	private java.lang.String lymphadenopathyValue;
	private java.lang.String signsOfMeningealIrritation;
	private java.lang.String eyeAndOrbit;
	private java.lang.String gingivoBuccalSulcus;
	private java.lang.String hardPalate;
	private java.lang.String palpablePulsationValue;
	private java.lang.String noseSeptum;
	private java.lang.String noseLeftIt;
	private java.lang.String noseRightIt;
	private java.lang.String noseLeftIm;
	private java.lang.String noseRightIm;
	private java.lang.String noseLeftMt;
	private java.lang.String noseRightMt;
	private java.lang.String noseLeftMm;
	private java.lang.String noseRightMm;
	private java.lang.String noseLeftFloor;
	private java.lang.String noseRightFloor;
	private java.lang.String noseLeftRoof;
	private java.lang.String noseRightRoof;
	private java.lang.String rinneOtherValueLeft;
	private java.lang.String rinneOtherValueRight;
	private java.lang.String olfactionValueLeft;
	private java.lang.String olfactionValueRight;
	private java.lang.String tympanicLeftPerforation;
	private java.lang.String parseFlaccidaValueLeft;
	private java.lang.String leftParseTensa;
	private java.lang.String rightCentral;
	private java.lang.String marginalValueLeft;
	private java.lang.String leftMiddleEarMucosa;
	private java.lang.String leftDischarge;
	private java.lang.String tympanicRightPerforation;
	private java.lang.String parseFlaccidaValueRight;
	private java.lang.String rightParseTensa;
	private java.lang.String leftCentral;
	private java.lang.String marginalValueRight;
	private java.lang.String rightMiddleEarMucosa;
	private java.lang.String rightDischarge;
	private java.lang.String imageName;

	// many to one
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ent_examination_id"
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
	 * Return the value associated with the column: right_pinna
	 */
	public java.lang.String getRightPinna () {
		return rightPinna;
	}

	/**
	 * Set the value related to the column: right_pinna
	 * @param rightPinna the right_pinna value
	 */
	public void setRightPinna (java.lang.String rightPinna) {
		this.rightPinna = rightPinna;
	}



	/**
	 * Return the value associated with the column: left_pinna
	 */
	public java.lang.String getLeftPinna () {
		return leftPinna;
	}

	/**
	 * Set the value related to the column: left_pinna
	 * @param leftPinna the left_pinna value
	 */
	public void setLeftPinna (java.lang.String leftPinna) {
		this.leftPinna = leftPinna;
	}



	/**
	 * Return the value associated with the column: right_preauricular_area
	 */
	public java.lang.String getRightPreauricularArea () {
		return rightPreauricularArea;
	}

	/**
	 * Set the value related to the column: right_preauricular_area
	 * @param rightPreauricularArea the right_preauricular_area value
	 */
	public void setRightPreauricularArea (java.lang.String rightPreauricularArea) {
		this.rightPreauricularArea = rightPreauricularArea;
	}



	/**
	 * Return the value associated with the column: left_preauricular_area
	 */
	public java.lang.String getLeftPreauricularArea () {
		return leftPreauricularArea;
	}

	/**
	 * Set the value related to the column: left_preauricular_area
	 * @param leftPreauricularArea the left_preauricular_area value
	 */
	public void setLeftPreauricularArea (java.lang.String leftPreauricularArea) {
		this.leftPreauricularArea = leftPreauricularArea;
	}



	/**
	 * Return the value associated with the column: right_post_auricular_area
	 */
	public java.lang.String getRightPostAuricularArea () {
		return rightPostAuricularArea;
	}

	/**
	 * Set the value related to the column: right_post_auricular_area
	 * @param rightPostAuricularArea the right_post_auricular_area value
	 */
	public void setRightPostAuricularArea (java.lang.String rightPostAuricularArea) {
		this.rightPostAuricularArea = rightPostAuricularArea;
	}



	/**
	 * Return the value associated with the column: left_post_auricular_area
	 */
	public java.lang.String getLeftPostAuricularArea () {
		return leftPostAuricularArea;
	}

	/**
	 * Set the value related to the column: left_post_auricular_area
	 * @param leftPostAuricularArea the left_post_auricular_area value
	 */
	public void setLeftPostAuricularArea (java.lang.String leftPostAuricularArea) {
		this.leftPostAuricularArea = leftPostAuricularArea;
	}



	/**
	 * Return the value associated with the column: right_tragal_tenderness
	 */
	public java.lang.String getRightTragalTenderness () {
		return rightTragalTenderness;
	}

	/**
	 * Set the value related to the column: right_tragal_tenderness
	 * @param rightTragalTenderness the right_tragal_tenderness value
	 */
	public void setRightTragalTenderness (java.lang.String rightTragalTenderness) {
		this.rightTragalTenderness = rightTragalTenderness;
	}



	/**
	 * Return the value associated with the column: left_tragal_tenderness
	 */
	public java.lang.String getLeftTragalTenderness () {
		return leftTragalTenderness;
	}

	/**
	 * Set the value related to the column: left_tragal_tenderness
	 * @param leftTragalTenderness the left_tragal_tenderness value
	 */
	public void setLeftTragalTenderness (java.lang.String leftTragalTenderness) {
		this.leftTragalTenderness = leftTragalTenderness;
	}



	/**
	 * Return the value associated with the column: right_external_auditory_canal
	 */
	public java.lang.String getRightExternalAuditoryCanal () {
		return rightExternalAuditoryCanal;
	}

	/**
	 * Set the value related to the column: right_external_auditory_canal
	 * @param rightExternalAuditoryCanal the right_external_auditory_canal value
	 */
	public void setRightExternalAuditoryCanal (java.lang.String rightExternalAuditoryCanal) {
		this.rightExternalAuditoryCanal = rightExternalAuditoryCanal;
	}



	/**
	 * Return the value associated with the column: left_external_auditory_canal
	 */
	public java.lang.String getLeftExternalAuditoryCanal () {
		return leftExternalAuditoryCanal;
	}

	/**
	 * Set the value related to the column: left_external_auditory_canal
	 * @param leftExternalAuditoryCanal the left_external_auditory_canal value
	 */
	public void setLeftExternalAuditoryCanal (java.lang.String leftExternalAuditoryCanal) {
		this.leftExternalAuditoryCanal = leftExternalAuditoryCanal;
	}



	/**
	 * Return the value associated with the column: left_256hz_rinnes
	 */
	public java.lang.String getLeft256hzRinnes () {
		return left256hzRinnes;
	}

	/**
	 * Set the value related to the column: left_256hz_rinnes
	 * @param left256hzRinnes the left_256hz_rinnes value
	 */
	public void setLeft256hzRinnes (java.lang.String left256hzRinnes) {
		this.left256hzRinnes = left256hzRinnes;
	}



	/**
	 * Return the value associated with the column: right_256hz_rinnes
	 */
	public java.lang.String getRight256hzRinnes () {
		return right256hzRinnes;
	}

	/**
	 * Set the value related to the column: right_256hz_rinnes
	 * @param right256hzRinnes the right_256hz_rinnes value
	 */
	public void setRight256hzRinnes (java.lang.String right256hzRinnes) {
		this.right256hzRinnes = right256hzRinnes;
	}



	/**
	 * Return the value associated with the column: left_512hz_rinnes
	 */
	public java.lang.String getLeft512hzRinnes () {
		return left512hzRinnes;
	}

	/**
	 * Set the value related to the column: left_512hz_rinnes
	 * @param left512hzRinnes the left_512hz_rinnes value
	 */
	public void setLeft512hzRinnes (java.lang.String left512hzRinnes) {
		this.left512hzRinnes = left512hzRinnes;
	}



	/**
	 * Return the value associated with the column: right_512hz_rinnes
	 */
	public java.lang.String getRight512hzRinnes () {
		return right512hzRinnes;
	}

	/**
	 * Set the value related to the column: right_512hz_rinnes
	 * @param right512hzRinnes the right_512hz_rinnes value
	 */
	public void setRight512hzRinnes (java.lang.String right512hzRinnes) {
		this.right512hzRinnes = right512hzRinnes;
	}



	/**
	 * Return the value associated with the column: left_1024hz_rinnes
	 */
	public java.lang.String getLeft1024hzRinnes () {
		return left1024hzRinnes;
	}

	/**
	 * Set the value related to the column: left_1024hz_rinnes
	 * @param left1024hzRinnes the left_1024hz_rinnes value
	 */
	public void setLeft1024hzRinnes (java.lang.String left1024hzRinnes) {
		this.left1024hzRinnes = left1024hzRinnes;
	}



	/**
	 * Return the value associated with the column: right_1024hz_rinnes
	 */
	public java.lang.String getRight1024hzRinnes () {
		return right1024hzRinnes;
	}

	/**
	 * Set the value related to the column: right_1024hz_rinnes
	 * @param right1024hzRinnes the right_1024hz_rinnes value
	 */
	public void setRight1024hzRinnes (java.lang.String right1024hzRinnes) {
		this.right1024hzRinnes = right1024hzRinnes;
	}



	/**
	 * Return the value associated with the column: weber
	 */
	public java.lang.String getWeber () {
		return weber;
	}

	/**
	 * Set the value related to the column: weber
	 * @param weber the weber value
	 */
	public void setWeber (java.lang.String weber) {
		this.weber = weber;
	}



	/**
	 * Return the value associated with the column: right_absolute_bone_conduction_test
	 */
	public java.lang.String getRightAbsoluteBoneConductionTest () {
		return rightAbsoluteBoneConductionTest;
	}

	/**
	 * Set the value related to the column: right_absolute_bone_conduction_test
	 * @param rightAbsoluteBoneConductionTest the right_absolute_bone_conduction_test value
	 */
	public void setRightAbsoluteBoneConductionTest (java.lang.String rightAbsoluteBoneConductionTest) {
		this.rightAbsoluteBoneConductionTest = rightAbsoluteBoneConductionTest;
	}



	/**
	 * Return the value associated with the column: absolute_bone_conduction_test
	 */
	public java.lang.String getAbsoluteBoneConductionTest () {
		return absoluteBoneConductionTest;
	}

	/**
	 * Set the value related to the column: absolute_bone_conduction_test
	 * @param absoluteBoneConductionTest the absolute_bone_conduction_test value
	 */
	public void setAbsoluteBoneConductionTest (java.lang.String absoluteBoneConductionTest) {
		this.absoluteBoneConductionTest = absoluteBoneConductionTest;
	}



	/**
	 * Return the value associated with the column: left_mastoid_tenderness
	 */
	public java.lang.String getLeftMastoidTenderness () {
		return leftMastoidTenderness;
	}

	/**
	 * Set the value related to the column: left_mastoid_tenderness
	 * @param leftMastoidTenderness the left_mastoid_tenderness value
	 */
	public void setLeftMastoidTenderness (java.lang.String leftMastoidTenderness) {
		this.leftMastoidTenderness = leftMastoidTenderness;
	}



	/**
	 * Return the value associated with the column: right_mastoid_tenderness
	 */
	public java.lang.String getRightMastoidTenderness () {
		return rightMastoidTenderness;
	}

	/**
	 * Set the value related to the column: right_mastoid_tenderness
	 * @param rightMastoidTenderness the right_mastoid_tenderness value
	 */
	public void setRightMastoidTenderness (java.lang.String rightMastoidTenderness) {
		this.rightMastoidTenderness = rightMastoidTenderness;
	}



	/**
	 * Return the value associated with the column: left_facial_nreve
	 */
	public java.lang.String getLeftFacialNreve () {
		return leftFacialNreve;
	}

	/**
	 * Set the value related to the column: left_facial_nreve
	 * @param leftFacialNreve the left_facial_nreve value
	 */
	public void setLeftFacialNreve (java.lang.String leftFacialNreve) {
		this.leftFacialNreve = leftFacialNreve;
	}



	/**
	 * Return the value associated with the column: right_facial_nreve
	 */
	public java.lang.String getRightFacialNreve () {
		return rightFacialNreve;
	}

	/**
	 * Set the value related to the column: right_facial_nreve
	 * @param rightFacialNreve the right_facial_nreve value
	 */
	public void setRightFacialNreve (java.lang.String rightFacialNreve) {
		this.rightFacialNreve = rightFacialNreve;
	}



	/**
	 * Return the value associated with the column: left_grading
	 */
	public java.lang.String getLeftGrading () {
		return leftGrading;
	}

	/**
	 * Set the value related to the column: left_grading
	 * @param leftGrading the left_grading value
	 */
	public void setLeftGrading (java.lang.String leftGrading) {
		this.leftGrading = leftGrading;
	}



	/**
	 * Return the value associated with the column: right_grading
	 */
	public java.lang.String getRightGrading () {
		return rightGrading;
	}

	/**
	 * Set the value related to the column: right_grading
	 * @param rightGrading the right_grading value
	 */
	public void setRightGrading (java.lang.String rightGrading) {
		this.rightGrading = rightGrading;
	}



	/**
	 * Return the value associated with the column: spontaneous_nystagmus_degree
	 */
	public java.lang.String getSpontaneousNystagmusDegree () {
		return spontaneousNystagmusDegree;
	}

	/**
	 * Set the value related to the column: spontaneous_nystagmus_degree
	 * @param spontaneousNystagmusDegree the spontaneous_nystagmus_degree value
	 */
	public void setSpontaneousNystagmusDegree (java.lang.String spontaneousNystagmusDegree) {
		this.spontaneousNystagmusDegree = spontaneousNystagmusDegree;
	}



	/**
	 * Return the value associated with the column: spontaneous_nystagmus_direction
	 */
	public java.lang.String getSpontaneousNystagmusDirection () {
		return spontaneousNystagmusDirection;
	}

	/**
	 * Set the value related to the column: spontaneous_nystagmus_direction
	 * @param spontaneousNystagmusDirection the spontaneous_nystagmus_direction value
	 */
	public void setSpontaneousNystagmusDirection (java.lang.String spontaneousNystagmusDirection) {
		this.spontaneousNystagmusDirection = spontaneousNystagmusDirection;
	}



	/**
	 * Return the value associated with the column: left_fistula_sign
	 */
	public java.lang.String getLeftFistulaSign () {
		return leftFistulaSign;
	}

	/**
	 * Set the value related to the column: left_fistula_sign
	 * @param leftFistulaSign the left_fistula_sign value
	 */
	public void setLeftFistulaSign (java.lang.String leftFistulaSign) {
		this.leftFistulaSign = leftFistulaSign;
	}



	/**
	 * Return the value associated with the column: left_fistula_sign_value
	 */
	public java.lang.String getLeftFistulaSignValue () {
		return leftFistulaSignValue;
	}

	/**
	 * Set the value related to the column: left_fistula_sign_value
	 * @param leftFistulaSignValue the left_fistula_sign_value value
	 */
	public void setLeftFistulaSignValue (java.lang.String leftFistulaSignValue) {
		this.leftFistulaSignValue = leftFistulaSignValue;
	}



	/**
	 * Return the value associated with the column: right_fistula_sign
	 */
	public java.lang.String getRightFistulaSign () {
		return rightFistulaSign;
	}

	/**
	 * Set the value related to the column: right_fistula_sign
	 * @param rightFistulaSign the right_fistula_sign value
	 */
	public void setRightFistulaSign (java.lang.String rightFistulaSign) {
		this.rightFistulaSign = rightFistulaSign;
	}



	/**
	 * Return the value associated with the column: right_fistula_sign_value
	 */
	public java.lang.String getRightFistulaSignValue () {
		return rightFistulaSignValue;
	}

	/**
	 * Set the value related to the column: right_fistula_sign_value
	 * @param rightFistulaSignValue the right_fistula_sign_value value
	 */
	public void setRightFistulaSignValue (java.lang.String rightFistulaSignValue) {
		this.rightFistulaSignValue = rightFistulaSignValue;
	}



	/**
	 * Return the value associated with the column: skull_and_spine
	 */
	public java.lang.String getSkullAndSpine () {
		return skullAndSpine;
	}

	/**
	 * Set the value related to the column: skull_and_spine
	 * @param skullAndSpine the skull_and_spine value
	 */
	public void setSkullAndSpine (java.lang.String skullAndSpine) {
		this.skullAndSpine = skullAndSpine;
	}



	/**
	 * Return the value associated with the column: cerebellar_signs
	 */
	public java.lang.String getCerebellarSigns () {
		return cerebellarSigns;
	}

	/**
	 * Set the value related to the column: cerebellar_signs
	 * @param cerebellarSigns the cerebellar_signs value
	 */
	public void setCerebellarSigns (java.lang.String cerebellarSigns) {
		this.cerebellarSigns = cerebellarSigns;
	}



	/**
	 * Return the value associated with the column: external_appearance
	 */
	public java.lang.String getExternalAppearance () {
		return externalAppearance;
	}

	/**
	 * Set the value related to the column: external_appearance
	 * @param externalAppearance the external_appearance value
	 */
	public void setExternalAppearance (java.lang.String externalAppearance) {
		this.externalAppearance = externalAppearance;
	}



	/**
	 * Return the value associated with the column: cold_spatula_test
	 */
	public java.lang.String getColdSpatulaTest () {
		return coldSpatulaTest;
	}

	/**
	 * Set the value related to the column: cold_spatula_test
	 * @param coldSpatulaTest the cold_spatula_test value
	 */
	public void setColdSpatulaTest (java.lang.String coldSpatulaTest) {
		this.coldSpatulaTest = coldSpatulaTest;
	}



	/**
	 * Return the value associated with the column: vestibule_and_columella
	 */
	public java.lang.String getVestibuleAndColumella () {
		return vestibuleAndColumella;
	}

	/**
	 * Set the value related to the column: vestibule_and_columella
	 * @param vestibuleAndColumella the vestibule_and_columella value
	 */
	public void setVestibuleAndColumella (java.lang.String vestibuleAndColumella) {
		this.vestibuleAndColumella = vestibuleAndColumella;
	}



	/**
	 * Return the value associated with the column: left_maxillary
	 */
	public java.lang.String getLeftMaxillary () {
		return leftMaxillary;
	}

	/**
	 * Set the value related to the column: left_maxillary
	 * @param leftMaxillary the left_maxillary value
	 */
	public void setLeftMaxillary (java.lang.String leftMaxillary) {
		this.leftMaxillary = leftMaxillary;
	}



	/**
	 * Return the value associated with the column: right_maxillary
	 */
	public java.lang.String getRightMaxillary () {
		return rightMaxillary;
	}

	/**
	 * Set the value related to the column: right_maxillary
	 * @param rightMaxillary the right_maxillary value
	 */
	public void setRightMaxillary (java.lang.String rightMaxillary) {
		this.rightMaxillary = rightMaxillary;
	}



	/**
	 * Return the value associated with the column: left_frontal
	 */
	public java.lang.String getLeftFrontal () {
		return leftFrontal;
	}

	/**
	 * Set the value related to the column: left_frontal
	 * @param leftFrontal the left_frontal value
	 */
	public void setLeftFrontal (java.lang.String leftFrontal) {
		this.leftFrontal = leftFrontal;
	}



	/**
	 * Return the value associated with the column: right_frontal
	 */
	public java.lang.String getRightFrontal () {
		return rightFrontal;
	}

	/**
	 * Set the value related to the column: right_frontal
	 * @param rightFrontal the right_frontal value
	 */
	public void setRightFrontal (java.lang.String rightFrontal) {
		this.rightFrontal = rightFrontal;
	}



	/**
	 * Return the value associated with the column: left_ethmoid
	 */
	public java.lang.String getLeftEthmoid () {
		return leftEthmoid;
	}

	/**
	 * Set the value related to the column: left_ethmoid
	 * @param leftEthmoid the left_ethmoid value
	 */
	public void setLeftEthmoid (java.lang.String leftEthmoid) {
		this.leftEthmoid = leftEthmoid;
	}



	/**
	 * Return the value associated with the column: right_ethmoid
	 */
	public java.lang.String getRightEthmoid () {
		return rightEthmoid;
	}

	/**
	 * Set the value related to the column: right_ethmoid
	 * @param rightEthmoid the right_ethmoid value
	 */
	public void setRightEthmoid (java.lang.String rightEthmoid) {
		this.rightEthmoid = rightEthmoid;
	}



	/**
	 * Return the value associated with the column: lips
	 */
	public java.lang.String getLips () {
		return lips;
	}

	/**
	 * Set the value related to the column: lips
	 * @param lips the lips value
	 */
	public void setLips (java.lang.String lips) {
		this.lips = lips;
	}



	/**
	 * Return the value associated with the column: gums
	 */
	public java.lang.String getGums () {
		return gums;
	}

	/**
	 * Set the value related to the column: gums
	 * @param gums the gums value
	 */
	public void setGums (java.lang.String gums) {
		this.gums = gums;
	}



	/**
	 * Return the value associated with the column: gums_value
	 */
	public java.lang.String getGumsValue () {
		return gumsValue;
	}

	/**
	 * Set the value related to the column: gums_value
	 * @param gumsValue the gums_value value
	 */
	public void setGumsValue (java.lang.String gumsValue) {
		this.gumsValue = gumsValue;
	}



	/**
	 * Return the value associated with the column: gingivo_labial_sulcus
	 */
	public java.lang.String getGingivoLabialSulcus () {
		return gingivoLabialSulcus;
	}

	/**
	 * Set the value related to the column: gingivo_labial_sulcus
	 * @param gingivoLabialSulcus the gingivo_labial_sulcus value
	 */
	public void setGingivoLabialSulcus (java.lang.String gingivoLabialSulcus) {
		this.gingivoLabialSulcus = gingivoLabialSulcus;
	}



	/**
	 * Return the value associated with the column: floor_of_mouth
	 */
	public java.lang.String getFloorOfMouth () {
		return floorOfMouth;
	}

	/**
	 * Set the value related to the column: floor_of_mouth
	 * @param floorOfMouth the floor_of_mouth value
	 */
	public void setFloorOfMouth (java.lang.String floorOfMouth) {
		this.floorOfMouth = floorOfMouth;
	}



	/**
	 * Return the value associated with the column: buccal_mucosa
	 */
	public java.lang.String getBuccalMucosa () {
		return buccalMucosa;
	}

	/**
	 * Set the value related to the column: buccal_mucosa
	 * @param buccalMucosa the buccal_mucosa value
	 */
	public void setBuccalMucosa (java.lang.String buccalMucosa) {
		this.buccalMucosa = buccalMucosa;
	}



	/**
	 * Return the value associated with the column: posterio_pharyngeal_wall
	 */
	public java.lang.String getPosterioPharyngealWall () {
		return posterioPharyngealWall;
	}

	/**
	 * Set the value related to the column: posterio_pharyngeal_wall
	 * @param posterioPharyngealWall the posterio_pharyngeal_wall value
	 */
	public void setPosterioPharyngealWall (java.lang.String posterioPharyngealWall) {
		this.posterioPharyngealWall = posterioPharyngealWall;
	}



	/**
	 * Return the value associated with the column: idl_findings
	 */
	public java.lang.String getIdlFindings () {
		return idlFindings;
	}

	/**
	 * Set the value related to the column: idl_findings
	 * @param idlFindings the idl_findings value
	 */
	public void setIdlFindings (java.lang.String idlFindings) {
		this.idlFindings = idlFindings;
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
	 * Return the value associated with the column: size
	 */
	public java.lang.String getSize () {
		return size;
	}

	/**
	 * Set the value related to the column: size
	 * @param size the size value
	 */
	public void setSize (java.lang.String size) {
		this.size = size;
	}



	/**
	 * Return the value associated with the column: shape
	 */
	public java.lang.String getShape () {
		return shape;
	}

	/**
	 * Set the value related to the column: shape
	 * @param shape the shape value
	 */
	public void setShape (java.lang.String shape) {
		this.shape = shape;
	}



	/**
	 * Return the value associated with the column: surface
	 */
	public java.lang.String getSurface () {
		return surface;
	}

	/**
	 * Set the value related to the column: surface
	 * @param surface the surface value
	 */
	public void setSurface (java.lang.String surface) {
		this.surface = surface;
	}



	/**
	 * Return the value associated with the column: skin_over_swelling
	 */
	public java.lang.String getSkinOverSwelling () {
		return skinOverSwelling;
	}

	/**
	 * Set the value related to the column: skin_over_swelling
	 * @param skinOverSwelling the skin_over_swelling value
	 */
	public void setSkinOverSwelling (java.lang.String skinOverSwelling) {
		this.skinOverSwelling = skinOverSwelling;
	}



	/**
	 * Return the value associated with the column: movements_on_deglutition
	 */
	public java.lang.String getMovementsOnDeglutition () {
		return movementsOnDeglutition;
	}

	/**
	 * Set the value related to the column: movements_on_deglutition
	 * @param movementsOnDeglutition the movements_on_deglutition value
	 */
	public void setMovementsOnDeglutition (java.lang.String movementsOnDeglutition) {
		this.movementsOnDeglutition = movementsOnDeglutition;
	}



	/**
	 * Return the value associated with the column: engorged_veins
	 */
	public java.lang.String getEngorgedVeins () {
		return engorgedVeins;
	}

	/**
	 * Set the value related to the column: engorged_veins
	 * @param engorgedVeins the engorged_veins value
	 */
	public void setEngorgedVeins (java.lang.String engorgedVeins) {
		this.engorgedVeins = engorgedVeins;
	}



	/**
	 * Return the value associated with the column: pulsation
	 */
	public java.lang.String getPulsation () {
		return pulsation;
	}

	/**
	 * Set the value related to the column: pulsation
	 * @param pulsation the pulsation value
	 */
	public void setPulsation (java.lang.String pulsation) {
		this.pulsation = pulsation;
	}



	/**
	 * Return the value associated with the column: tenderness
	 */
	public java.lang.String getTenderness () {
		return tenderness;
	}

	/**
	 * Set the value related to the column: tenderness
	 * @param tenderness the tenderness value
	 */
	public void setTenderness (java.lang.String tenderness) {
		this.tenderness = tenderness;
	}



	/**
	 * Return the value associated with the column: fixity_to_deeper_structures
	 */
	public java.lang.String getFixityToDeeperStructures () {
		return fixityToDeeperStructures;
	}

	/**
	 * Set the value related to the column: fixity_to_deeper_structures
	 * @param fixityToDeeperStructures the fixity_to_deeper_structures value
	 */
	public void setFixityToDeeperStructures (java.lang.String fixityToDeeperStructures) {
		this.fixityToDeeperStructures = fixityToDeeperStructures;
	}



	/**
	 * Return the value associated with the column: palpable_pulsation
	 */
	public java.lang.String getPalpablePulsation () {
		return palpablePulsation;
	}

	/**
	 * Set the value related to the column: palpable_pulsation
	 * @param palpablePulsation the palpable_pulsation value
	 */
	public void setPalpablePulsation (java.lang.String palpablePulsation) {
		this.palpablePulsation = palpablePulsation;
	}



	/**
	 * Return the value associated with the column: laryngeal_crepitus
	 */
	public java.lang.String getLaryngealCrepitus () {
		return laryngealCrepitus;
	}

	/**
	 * Set the value related to the column: laryngeal_crepitus
	 * @param laryngealCrepitus the laryngeal_crepitus value
	 */
	public void setLaryngealCrepitus (java.lang.String laryngealCrepitus) {
		this.laryngealCrepitus = laryngealCrepitus;
	}



	/**
	 * Return the value associated with the column: laryngeal_crepitus_another
	 */
	public java.lang.String getLaryngealCrepitusAnother () {
		return laryngealCrepitusAnother;
	}

	/**
	 * Set the value related to the column: laryngeal_crepitus_another
	 * @param laryngealCrepitusAnother the laryngeal_crepitus_another value
	 */
	public void setLaryngealCrepitusAnother (java.lang.String laryngealCrepitusAnother) {
		this.laryngealCrepitusAnother = laryngealCrepitusAnother;
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
	 * Return the value associated with the column: left_tragal_tenderness_value
	 */
	public java.lang.String getLeftTragalTendernessValue () {
		return leftTragalTendernessValue;
	}

	/**
	 * Set the value related to the column: left_tragal_tenderness_value
	 * @param leftTragalTendernessValue the left_tragal_tenderness_value value
	 */
	public void setLeftTragalTendernessValue (java.lang.String leftTragalTendernessValue) {
		this.leftTragalTendernessValue = leftTragalTendernessValue;
	}



	/**
	 * Return the value associated with the column: right_tragal_tenderness_value
	 */
	public java.lang.String getRightTragalTendernessValue () {
		return rightTragalTendernessValue;
	}

	/**
	 * Set the value related to the column: right_tragal_tenderness_value
	 * @param rightTragalTendernessValue the right_tragal_tenderness_value value
	 */
	public void setRightTragalTendernessValue (java.lang.String rightTragalTendernessValue) {
		this.rightTragalTendernessValue = rightTragalTendernessValue;
	}



	/**
	 * Return the value associated with the column: spontaneous_nystagmus_direction_value
	 */
	public java.lang.String getSpontaneousNystagmusDirectionValue () {
		return spontaneousNystagmusDirectionValue;
	}

	/**
	 * Set the value related to the column: spontaneous_nystagmus_direction_value
	 * @param spontaneousNystagmusDirectionValue the spontaneous_nystagmus_direction_value value
	 */
	public void setSpontaneousNystagmusDirectionValue (java.lang.String spontaneousNystagmusDirectionValue) {
		this.spontaneousNystagmusDirectionValue = spontaneousNystagmusDirectionValue;
	}



	/**
	 * Return the value associated with the column: left_fistula_sign_degree
	 */
	public java.lang.String getLeftFistulaSignDegree () {
		return leftFistulaSignDegree;
	}

	/**
	 * Set the value related to the column: left_fistula_sign_degree
	 * @param leftFistulaSignDegree the left_fistula_sign_degree value
	 */
	public void setLeftFistulaSignDegree (java.lang.String leftFistulaSignDegree) {
		this.leftFistulaSignDegree = leftFistulaSignDegree;
	}



	/**
	 * Return the value associated with the column: left_fistula_sign_direction
	 */
	public java.lang.String getLeftFistulaSignDirection () {
		return leftFistulaSignDirection;
	}

	/**
	 * Set the value related to the column: left_fistula_sign_direction
	 * @param leftFistulaSignDirection the left_fistula_sign_direction value
	 */
	public void setLeftFistulaSignDirection (java.lang.String leftFistulaSignDirection) {
		this.leftFistulaSignDirection = leftFistulaSignDirection;
	}



	/**
	 * Return the value associated with the column: right_fistula_sign_degree
	 */
	public java.lang.String getRightFistulaSignDegree () {
		return rightFistulaSignDegree;
	}

	/**
	 * Set the value related to the column: right_fistula_sign_degree
	 * @param rightFistulaSignDegree the right_fistula_sign_degree value
	 */
	public void setRightFistulaSignDegree (java.lang.String rightFistulaSignDegree) {
		this.rightFistulaSignDegree = rightFistulaSignDegree;
	}



	/**
	 * Return the value associated with the column: right_fistula_sign_direction
	 */
	public java.lang.String getRightFistulaSignDirection () {
		return rightFistulaSignDirection;
	}

	/**
	 * Set the value related to the column: right_fistula_sign_direction
	 * @param rightFistulaSignDirection the right_fistula_sign_direction value
	 */
	public void setRightFistulaSignDirection (java.lang.String rightFistulaSignDirection) {
		this.rightFistulaSignDirection = rightFistulaSignDirection;
	}



	/**
	 * Return the value associated with the column: tympanic_membrane
	 */
	public java.lang.String getTympanicMembrane () {
		return tympanicMembrane;
	}

	/**
	 * Set the value related to the column: tympanic_membrane
	 * @param tympanicMembrane the tympanic_membrane value
	 */
	public void setTympanicMembrane (java.lang.String tympanicMembrane) {
		this.tympanicMembrane = tympanicMembrane;
	}



	/**
	 * Return the value associated with the column: external_appearance_value
	 */
	public java.lang.String getExternalAppearanceValue () {
		return externalAppearanceValue;
	}

	/**
	 * Set the value related to the column: external_appearance_value
	 * @param externalAppearanceValue the external_appearance_value value
	 */
	public void setExternalAppearanceValue (java.lang.String externalAppearanceValue) {
		this.externalAppearanceValue = externalAppearanceValue;
	}



	/**
	 * Return the value associated with the column: vestibule_and_columella_value
	 */
	public java.lang.String getVestibuleAndColumellaValue () {
		return vestibuleAndColumellaValue;
	}

	/**
	 * Set the value related to the column: vestibule_and_columella_value
	 * @param vestibuleAndColumellaValue the vestibule_and_columella_value value
	 */
	public void setVestibuleAndColumellaValue (java.lang.String vestibuleAndColumellaValue) {
		this.vestibuleAndColumellaValue = vestibuleAndColumellaValue;
	}



	/**
	 * Return the value associated with the column: lower_lips
	 */
	public java.lang.String getLowerLips () {
		return lowerLips;
	}

	/**
	 * Set the value related to the column: lower_lips
	 * @param lowerLips the lower_lips value
	 */
	public void setLowerLips (java.lang.String lowerLips) {
		this.lowerLips = lowerLips;
	}



	/**
	 * Return the value associated with the column: lower_lips_value
	 */
	public java.lang.String getLowerLipsValue () {
		return lowerLipsValue;
	}

	/**
	 * Set the value related to the column: lower_lips_value
	 * @param lowerLipsValue the lower_lips_value value
	 */
	public void setLowerLipsValue (java.lang.String lowerLipsValue) {
		this.lowerLipsValue = lowerLipsValue;
	}



	/**
	 * Return the value associated with the column: lips_value
	 */
	public java.lang.String getLipsValue () {
		return lipsValue;
	}

	/**
	 * Set the value related to the column: lips_value
	 * @param lipsValue the lips_value value
	 */
	public void setLipsValue (java.lang.String lipsValue) {
		this.lipsValue = lipsValue;
	}



	/**
	 * Return the value associated with the column: movements_with_protrusion_of_tongue
	 */
	public java.lang.String getMovementsWithProtrusionOfTongue () {
		return movementsWithProtrusionOfTongue;
	}

	/**
	 * Set the value related to the column: movements_with_protrusion_of_tongue
	 * @param movementsWithProtrusionOfTongue the movements_with_protrusion_of_tongue value
	 */
	public void setMovementsWithProtrusionOfTongue (java.lang.String movementsWithProtrusionOfTongue) {
		this.movementsWithProtrusionOfTongue = movementsWithProtrusionOfTongue;
	}



	/**
	 * Return the value associated with the column: fixity_to_deeper_structures_value
	 */
	public java.lang.String getFixityToDeeperStructuresValue () {
		return fixityToDeeperStructuresValue;
	}

	/**
	 * Set the value related to the column: fixity_to_deeper_structures_value
	 * @param fixityToDeeperStructuresValue the fixity_to_deeper_structures_value value
	 */
	public void setFixityToDeeperStructuresValue (java.lang.String fixityToDeeperStructuresValue) {
		this.fixityToDeeperStructuresValue = fixityToDeeperStructuresValue;
	}



	/**
	 * Return the value associated with the column: spontaneous_nystagmus
	 */
	public java.lang.String getSpontaneousNystagmus () {
		return spontaneousNystagmus;
	}

	/**
	 * Set the value related to the column: spontaneous_nystagmus
	 * @param spontaneousNystagmus the spontaneous_nystagmus value
	 */
	public void setSpontaneousNystagmus (java.lang.String spontaneousNystagmus) {
		this.spontaneousNystagmus = spontaneousNystagmus;
	}



	/**
	 * Return the value associated with the column: left_tympanic_membrane
	 */
	public java.lang.String getLeftTympanicMembrane () {
		return leftTympanicMembrane;
	}

	/**
	 * Set the value related to the column: left_tympanic_membrane
	 * @param leftTympanicMembrane the left_tympanic_membrane value
	 */
	public void setLeftTympanicMembrane (java.lang.String leftTympanicMembrane) {
		this.leftTympanicMembrane = leftTympanicMembrane;
	}



	/**
	 * Return the value associated with the column: right_tympanic_membrane
	 */
	public java.lang.String getRightTympanicMembrane () {
		return rightTympanicMembrane;
	}

	/**
	 * Set the value related to the column: right_tympanic_membrane
	 * @param rightTympanicMembrane the right_tympanic_membrane value
	 */
	public void setRightTympanicMembrane (java.lang.String rightTympanicMembrane) {
		this.rightTympanicMembrane = rightTympanicMembrane;
	}



	/**
	 * Return the value associated with the column: left_vestibule
	 */
	public java.lang.String getLeftVestibule () {
		return leftVestibule;
	}

	/**
	 * Set the value related to the column: left_vestibule
	 * @param leftVestibule the left_vestibule value
	 */
	public void setLeftVestibule (java.lang.String leftVestibule) {
		this.leftVestibule = leftVestibule;
	}



	/**
	 * Return the value associated with the column: left_columella
	 */
	public java.lang.String getLeftColumella () {
		return leftColumella;
	}

	/**
	 * Set the value related to the column: left_columella
	 * @param leftColumella the left_columella value
	 */
	public void setLeftColumella (java.lang.String leftColumella) {
		this.leftColumella = leftColumella;
	}



	/**
	 * Return the value associated with the column: left_vestibule_value
	 */
	public java.lang.String getLeftVestibuleValue () {
		return leftVestibuleValue;
	}

	/**
	 * Set the value related to the column: left_vestibule_value
	 * @param leftVestibuleValue the left_vestibule_value value
	 */
	public void setLeftVestibuleValue (java.lang.String leftVestibuleValue) {
		this.leftVestibuleValue = leftVestibuleValue;
	}



	/**
	 * Return the value associated with the column: left_columella_value
	 */
	public java.lang.String getLeftColumellaValue () {
		return leftColumellaValue;
	}

	/**
	 * Set the value related to the column: left_columella_value
	 * @param leftColumellaValue the left_columella_value value
	 */
	public void setLeftColumellaValue (java.lang.String leftColumellaValue) {
		this.leftColumellaValue = leftColumellaValue;
	}



	/**
	 * Return the value associated with the column: right_vestibule
	 */
	public java.lang.String getRightVestibule () {
		return rightVestibule;
	}

	/**
	 * Set the value related to the column: right_vestibule
	 * @param rightVestibule the right_vestibule value
	 */
	public void setRightVestibule (java.lang.String rightVestibule) {
		this.rightVestibule = rightVestibule;
	}



	/**
	 * Return the value associated with the column: right_vestibule_value
	 */
	public java.lang.String getRightVestibuleValue () {
		return rightVestibuleValue;
	}

	/**
	 * Set the value related to the column: right_vestibule_value
	 * @param rightVestibuleValue the right_vestibule_value value
	 */
	public void setRightVestibuleValue (java.lang.String rightVestibuleValue) {
		this.rightVestibuleValue = rightVestibuleValue;
	}



	/**
	 * Return the value associated with the column: right_columella
	 */
	public java.lang.String getRightColumella () {
		return rightColumella;
	}

	/**
	 * Set the value related to the column: right_columella
	 * @param rightColumella the right_columella value
	 */
	public void setRightColumella (java.lang.String rightColumella) {
		this.rightColumella = rightColumella;
	}



	/**
	 * Return the value associated with the column: right_columella_value
	 */
	public java.lang.String getRightColumellaValue () {
		return rightColumellaValue;
	}

	/**
	 * Set the value related to the column: right_columella_value
	 * @param rightColumellaValue the right_columella_value value
	 */
	public void setRightColumellaValue (java.lang.String rightColumellaValue) {
		this.rightColumellaValue = rightColumellaValue;
	}



	/**
	 * Return the value associated with the column: septum
	 */
	public java.lang.String getSeptum () {
		return septum;
	}

	/**
	 * Set the value related to the column: septum
	 * @param septum the septum value
	 */
	public void setSeptum (java.lang.String septum) {
		this.septum = septum;
	}



	/**
	 * Return the value associated with the column: left_it
	 */
	public java.lang.String getLeftIt () {
		return leftIt;
	}

	/**
	 * Set the value related to the column: left_it
	 * @param leftIt the left_it value
	 */
	public void setLeftIt (java.lang.String leftIt) {
		this.leftIt = leftIt;
	}



	/**
	 * Return the value associated with the column: right_it
	 */
	public java.lang.String getRightIt () {
		return rightIt;
	}

	/**
	 * Set the value related to the column: right_it
	 * @param rightIt the right_it value
	 */
	public void setRightIt (java.lang.String rightIt) {
		this.rightIt = rightIt;
	}



	/**
	 * Return the value associated with the column: left_im
	 */
	public java.lang.String getLeftIm () {
		return leftIm;
	}

	/**
	 * Set the value related to the column: left_im
	 * @param leftIm the left_im value
	 */
	public void setLeftIm (java.lang.String leftIm) {
		this.leftIm = leftIm;
	}



	/**
	 * Return the value associated with the column: right_im
	 */
	public java.lang.String getRightIm () {
		return rightIm;
	}

	/**
	 * Set the value related to the column: right_im
	 * @param rightIm the right_im value
	 */
	public void setRightIm (java.lang.String rightIm) {
		this.rightIm = rightIm;
	}



	/**
	 * Return the value associated with the column: left_mt
	 */
	public java.lang.String getLeftMt () {
		return leftMt;
	}

	/**
	 * Set the value related to the column: left_mt
	 * @param leftMt the left_mt value
	 */
	public void setLeftMt (java.lang.String leftMt) {
		this.leftMt = leftMt;
	}



	/**
	 * Return the value associated with the column: right_mt
	 */
	public java.lang.String getRightMt () {
		return rightMt;
	}

	/**
	 * Set the value related to the column: right_mt
	 * @param rightMt the right_mt value
	 */
	public void setRightMt (java.lang.String rightMt) {
		this.rightMt = rightMt;
	}



	/**
	 * Return the value associated with the column: left_mm
	 */
	public java.lang.String getLeftMm () {
		return leftMm;
	}

	/**
	 * Set the value related to the column: left_mm
	 * @param leftMm the left_mm value
	 */
	public void setLeftMm (java.lang.String leftMm) {
		this.leftMm = leftMm;
	}



	/**
	 * Return the value associated with the column: right_mm
	 */
	public java.lang.String getRightMm () {
		return rightMm;
	}

	/**
	 * Set the value related to the column: right_mm
	 * @param rightMm the right_mm value
	 */
	public void setRightMm (java.lang.String rightMm) {
		this.rightMm = rightMm;
	}



	/**
	 * Return the value associated with the column: left_floor
	 */
	public java.lang.String getLeftFloor () {
		return leftFloor;
	}

	/**
	 * Set the value related to the column: left_floor
	 * @param leftFloor the left_floor value
	 */
	public void setLeftFloor (java.lang.String leftFloor) {
		this.leftFloor = leftFloor;
	}



	/**
	 * Return the value associated with the column: right_floor
	 */
	public java.lang.String getRightFloor () {
		return rightFloor;
	}

	/**
	 * Set the value related to the column: right_floor
	 * @param rightFloor the right_floor value
	 */
	public void setRightFloor (java.lang.String rightFloor) {
		this.rightFloor = rightFloor;
	}



	/**
	 * Return the value associated with the column: left_roof
	 */
	public java.lang.String getLeftRoof () {
		return leftRoof;
	}

	/**
	 * Set the value related to the column: left_roof
	 * @param leftRoof the left_roof value
	 */
	public void setLeftRoof (java.lang.String leftRoof) {
		this.leftRoof = leftRoof;
	}



	/**
	 * Return the value associated with the column: right_roof
	 */
	public java.lang.String getRightRoof () {
		return rightRoof;
	}

	/**
	 * Set the value related to the column: right_roof
	 * @param rightRoof the right_roof value
	 */
	public void setRightRoof (java.lang.String rightRoof) {
		this.rightRoof = rightRoof;
	}



	/**
	 * Return the value associated with the column: posterior_septum
	 */
	public java.lang.String getPosteriorSeptum () {
		return posteriorSeptum;
	}

	/**
	 * Set the value related to the column: posterior_septum
	 * @param posteriorSeptum the posterior_septum value
	 */
	public void setPosteriorSeptum (java.lang.String posteriorSeptum) {
		this.posteriorSeptum = posteriorSeptum;
	}



	/**
	 * Return the value associated with the column: posterior_septum_value
	 */
	public java.lang.String getPosteriorSeptumValue () {
		return posteriorSeptumValue;
	}

	/**
	 * Set the value related to the column: posterior_septum_value
	 * @param posteriorSeptumValue the posterior_septum_value value
	 */
	public void setPosteriorSeptumValue (java.lang.String posteriorSeptumValue) {
		this.posteriorSeptumValue = posteriorSeptumValue;
	}



	/**
	 * Return the value associated with the column: left_choane
	 */
	public java.lang.String getLeftChoane () {
		return leftChoane;
	}

	/**
	 * Set the value related to the column: left_choane
	 * @param leftChoane the left_choane value
	 */
	public void setLeftChoane (java.lang.String leftChoane) {
		this.leftChoane = leftChoane;
	}



	/**
	 * Return the value associated with the column: right_choane
	 */
	public java.lang.String getRightChoane () {
		return rightChoane;
	}

	/**
	 * Set the value related to the column: right_choane
	 * @param rightChoane the right_choane value
	 */
	public void setRightChoane (java.lang.String rightChoane) {
		this.rightChoane = rightChoane;
	}



	/**
	 * Return the value associated with the column: left_postnatal_roof
	 */
	public java.lang.String getLeftPostnatalRoof () {
		return leftPostnatalRoof;
	}

	/**
	 * Set the value related to the column: left_postnatal_roof
	 * @param leftPostnatalRoof the left_postnatal_roof value
	 */
	public void setLeftPostnatalRoof (java.lang.String leftPostnatalRoof) {
		this.leftPostnatalRoof = leftPostnatalRoof;
	}



	/**
	 * Return the value associated with the column: right_postnatal_roof
	 */
	public java.lang.String getRightPostnatalRoof () {
		return rightPostnatalRoof;
	}

	/**
	 * Set the value related to the column: right_postnatal_roof
	 * @param rightPostnatalRoof the right_postnatal_roof value
	 */
	public void setRightPostnatalRoof (java.lang.String rightPostnatalRoof) {
		this.rightPostnatalRoof = rightPostnatalRoof;
	}



	/**
	 * Return the value associated with the column: left_et_onliae
	 */
	public java.lang.String getLeftEtOnliae () {
		return leftEtOnliae;
	}

	/**
	 * Set the value related to the column: left_et_onliae
	 * @param leftEtOnliae the left_et_onliae value
	 */
	public void setLeftEtOnliae (java.lang.String leftEtOnliae) {
		this.leftEtOnliae = leftEtOnliae;
	}



	/**
	 * Return the value associated with the column: right_et_onliae
	 */
	public java.lang.String getRightEtOnliae () {
		return rightEtOnliae;
	}

	/**
	 * Set the value related to the column: right_et_onliae
	 * @param rightEtOnliae the right_et_onliae value
	 */
	public void setRightEtOnliae (java.lang.String rightEtOnliae) {
		this.rightEtOnliae = rightEtOnliae;
	}



	/**
	 * Return the value associated with the column: left_for
	 */
	public java.lang.String getLeftFor () {
		return leftFor;
	}

	/**
	 * Set the value related to the column: left_for
	 * @param leftFor the left_for value
	 */
	public void setLeftFor (java.lang.String leftFor) {
		this.leftFor = leftFor;
	}



	/**
	 * Return the value associated with the column: right_for
	 */
	public java.lang.String getRightFor () {
		return rightFor;
	}

	/**
	 * Set the value related to the column: right_for
	 * @param rightFor the right_for value
	 */
	public void setRightFor (java.lang.String rightFor) {
		this.rightFor = rightFor;
	}



	/**
	 * Return the value associated with the column: left_posterior_turbinates
	 */
	public java.lang.String getLeftPosteriorTurbinates () {
		return leftPosteriorTurbinates;
	}

	/**
	 * Set the value related to the column: left_posterior_turbinates
	 * @param leftPosteriorTurbinates the left_posterior_turbinates value
	 */
	public void setLeftPosteriorTurbinates (java.lang.String leftPosteriorTurbinates) {
		this.leftPosteriorTurbinates = leftPosteriorTurbinates;
	}



	/**
	 * Return the value associated with the column: right_posterior_turbinates
	 */
	public java.lang.String getRightPosteriorTurbinates () {
		return rightPosteriorTurbinates;
	}

	/**
	 * Set the value related to the column: right_posterior_turbinates
	 * @param rightPosteriorTurbinates the right_posterior_turbinates value
	 */
	public void setRightPosteriorTurbinates (java.lang.String rightPosteriorTurbinates) {
		this.rightPosteriorTurbinates = rightPosteriorTurbinates;
	}



	/**
	 * Return the value associated with the column: teeth
	 */
	public java.lang.String getTeeth () {
		return teeth;
	}

	/**
	 * Set the value related to the column: teeth
	 * @param teeth the teeth value
	 */
	public void setTeeth (java.lang.String teeth) {
		this.teeth = teeth;
	}



	/**
	 * Return the value associated with the column: teeth_value
	 */
	public java.lang.String getTeethValue () {
		return teethValue;
	}

	/**
	 * Set the value related to the column: teeth_value
	 * @param teethValue the teeth_value value
	 */
	public void setTeethValue (java.lang.String teethValue) {
		this.teethValue = teethValue;
	}



	/**
	 * Return the value associated with the column: frenulum
	 */
	public java.lang.String getFrenulum () {
		return frenulum;
	}

	/**
	 * Set the value related to the column: frenulum
	 * @param frenulum the frenulum value
	 */
	public void setFrenulum (java.lang.String frenulum) {
		this.frenulum = frenulum;
	}



	/**
	 * Return the value associated with the column: opening_of_salivary_duct
	 */
	public java.lang.String getOpeningOfSalivaryDuct () {
		return openingOfSalivaryDuct;
	}

	/**
	 * Set the value related to the column: opening_of_salivary_duct
	 * @param openingOfSalivaryDuct the opening_of_salivary_duct value
	 */
	public void setOpeningOfSalivaryDuct (java.lang.String openingOfSalivaryDuct) {
		this.openingOfSalivaryDuct = openingOfSalivaryDuct;
	}



	/**
	 * Return the value associated with the column: any_other_finding
	 */
	public java.lang.String getAnyOtherFinding () {
		return anyOtherFinding;
	}

	/**
	 * Set the value related to the column: any_other_finding
	 * @param anyOtherFinding the any_other_finding value
	 */
	public void setAnyOtherFinding (java.lang.String anyOtherFinding) {
		this.anyOtherFinding = anyOtherFinding;
	}



	/**
	 * Return the value associated with the column: left_retro_molar_trigone
	 */
	public java.lang.String getLeftRetroMolarTrigone () {
		return leftRetroMolarTrigone;
	}

	/**
	 * Set the value related to the column: left_retro_molar_trigone
	 * @param leftRetroMolarTrigone the left_retro_molar_trigone value
	 */
	public void setLeftRetroMolarTrigone (java.lang.String leftRetroMolarTrigone) {
		this.leftRetroMolarTrigone = leftRetroMolarTrigone;
	}



	/**
	 * Return the value associated with the column: left_retro_molar_trigone_value
	 */
	public java.lang.String getLeftRetroMolarTrigoneValue () {
		return leftRetroMolarTrigoneValue;
	}

	/**
	 * Set the value related to the column: left_retro_molar_trigone_value
	 * @param leftRetroMolarTrigoneValue the left_retro_molar_trigone_value value
	 */
	public void setLeftRetroMolarTrigoneValue (java.lang.String leftRetroMolarTrigoneValue) {
		this.leftRetroMolarTrigoneValue = leftRetroMolarTrigoneValue;
	}



	/**
	 * Return the value associated with the column: right_retro_molar_trigone
	 */
	public java.lang.String getRightRetroMolarTrigone () {
		return rightRetroMolarTrigone;
	}

	/**
	 * Set the value related to the column: right_retro_molar_trigone
	 * @param rightRetroMolarTrigone the right_retro_molar_trigone value
	 */
	public void setRightRetroMolarTrigone (java.lang.String rightRetroMolarTrigone) {
		this.rightRetroMolarTrigone = rightRetroMolarTrigone;
	}



	/**
	 * Return the value associated with the column: right_retro_molar_trigone_value
	 */
	public java.lang.String getRightRetroMolarTrigoneValue () {
		return rightRetroMolarTrigoneValue;
	}

	/**
	 * Set the value related to the column: right_retro_molar_trigone_value
	 * @param rightRetroMolarTrigoneValue the right_retro_molar_trigone_value value
	 */
	public void setRightRetroMolarTrigoneValue (java.lang.String rightRetroMolarTrigoneValue) {
		this.rightRetroMolarTrigoneValue = rightRetroMolarTrigoneValue;
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
	 * Return the value associated with the column: appearance
	 */
	public java.lang.String getAppearance () {
		return appearance;
	}

	/**
	 * Set the value related to the column: appearance
	 * @param appearance the appearance value
	 */
	public void setAppearance (java.lang.String appearance) {
		this.appearance = appearance;
	}



	/**
	 * Return the value associated with the column: deviation
	 */
	public java.lang.String getDeviation () {
		return deviation;
	}

	/**
	 * Set the value related to the column: deviation
	 * @param deviation the deviation value
	 */
	public void setDeviation (java.lang.String deviation) {
		this.deviation = deviation;
	}



	/**
	 * Return the value associated with the column: left_soft_palette
	 */
	public java.lang.String getLeftSoftPalette () {
		return leftSoftPalette;
	}

	/**
	 * Set the value related to the column: left_soft_palette
	 * @param leftSoftPalette the left_soft_palette value
	 */
	public void setLeftSoftPalette (java.lang.String leftSoftPalette) {
		this.leftSoftPalette = leftSoftPalette;
	}



	/**
	 * Return the value associated with the column: right_soft_palette
	 */
	public java.lang.String getRightSoftPalette () {
		return rightSoftPalette;
	}

	/**
	 * Set the value related to the column: right_soft_palette
	 * @param rightSoftPalette the right_soft_palette value
	 */
	public void setRightSoftPalette (java.lang.String rightSoftPalette) {
		this.rightSoftPalette = rightSoftPalette;
	}



	/**
	 * Return the value associated with the column: left_anterior_pillar
	 */
	public java.lang.String getLeftAnteriorPillar () {
		return leftAnteriorPillar;
	}

	/**
	 * Set the value related to the column: left_anterior_pillar
	 * @param leftAnteriorPillar the left_anterior_pillar value
	 */
	public void setLeftAnteriorPillar (java.lang.String leftAnteriorPillar) {
		this.leftAnteriorPillar = leftAnteriorPillar;
	}



	/**
	 * Return the value associated with the column: right_anterior_pillar
	 */
	public java.lang.String getRightAnteriorPillar () {
		return rightAnteriorPillar;
	}

	/**
	 * Set the value related to the column: right_anterior_pillar
	 * @param rightAnteriorPillar the right_anterior_pillar value
	 */
	public void setRightAnteriorPillar (java.lang.String rightAnteriorPillar) {
		this.rightAnteriorPillar = rightAnteriorPillar;
	}



	/**
	 * Return the value associated with the column: left_tonsil
	 */
	public java.lang.String getLeftTonsil () {
		return leftTonsil;
	}

	/**
	 * Set the value related to the column: left_tonsil
	 * @param leftTonsil the left_tonsil value
	 */
	public void setLeftTonsil (java.lang.String leftTonsil) {
		this.leftTonsil = leftTonsil;
	}



	/**
	 * Return the value associated with the column: right_tonsil
	 */
	public java.lang.String getRightTonsil () {
		return rightTonsil;
	}

	/**
	 * Set the value related to the column: right_tonsil
	 * @param rightTonsil the right_tonsil value
	 */
	public void setRightTonsil (java.lang.String rightTonsil) {
		this.rightTonsil = rightTonsil;
	}



	/**
	 * Return the value associated with the column: left_posterior_pillar
	 */
	public java.lang.String getLeftPosteriorPillar () {
		return leftPosteriorPillar;
	}

	/**
	 * Set the value related to the column: left_posterior_pillar
	 * @param leftPosteriorPillar the left_posterior_pillar value
	 */
	public void setLeftPosteriorPillar (java.lang.String leftPosteriorPillar) {
		this.leftPosteriorPillar = leftPosteriorPillar;
	}



	/**
	 * Return the value associated with the column: right_posterior_pillar
	 */
	public java.lang.String getRightPosteriorPillar () {
		return rightPosteriorPillar;
	}

	/**
	 * Set the value related to the column: right_posterior_pillar
	 * @param rightPosteriorPillar the right_posterior_pillar value
	 */
	public void setRightPosteriorPillar (java.lang.String rightPosteriorPillar) {
		this.rightPosteriorPillar = rightPosteriorPillar;
	}



	/**
	 * Return the value associated with the column: left_pharyngeal_wall
	 */
	public java.lang.String getLeftPharyngealWall () {
		return leftPharyngealWall;
	}

	/**
	 * Set the value related to the column: left_pharyngeal_wall
	 * @param leftPharyngealWall the left_pharyngeal_wall value
	 */
	public void setLeftPharyngealWall (java.lang.String leftPharyngealWall) {
		this.leftPharyngealWall = leftPharyngealWall;
	}



	/**
	 * Return the value associated with the column: right_pharyngeal_wall
	 */
	public java.lang.String getRightPharyngealWall () {
		return rightPharyngealWall;
	}

	/**
	 * Set the value related to the column: right_pharyngeal_wall
	 * @param rightPharyngealWall the right_pharyngeal_wall value
	 */
	public void setRightPharyngealWall (java.lang.String rightPharyngealWall) {
		this.rightPharyngealWall = rightPharyngealWall;
	}



	/**
	 * Return the value associated with the column: lymphnodes
	 */
	public java.lang.String getLymphnodes () {
		return lymphnodes;
	}

	/**
	 * Set the value related to the column: lymphnodes
	 * @param lymphnodes the lymphnodes value
	 */
	public void setLymphnodes (java.lang.String lymphnodes) {
		this.lymphnodes = lymphnodes;
	}



	/**
	 * Return the value associated with the column: lymphenodes_value
	 */
	public java.lang.String getLymphenodesValue () {
		return lymphenodesValue;
	}

	/**
	 * Set the value related to the column: lymphenodes_value
	 * @param lymphenodesValue the lymphenodes_value value
	 */
	public void setLymphenodesValue (java.lang.String lymphenodesValue) {
		this.lymphenodesValue = lymphenodesValue;
	}



	/**
	 * Return the value associated with the column: right_level
	 */
	public java.lang.String getRightLevel () {
		return rightLevel;
	}

	/**
	 * Set the value related to the column: right_level
	 * @param rightLevel the right_level value
	 */
	public void setRightLevel (java.lang.String rightLevel) {
		this.rightLevel = rightLevel;
	}



	/**
	 * Return the value associated with the column: left_level
	 */
	public java.lang.String getLeftLevel () {
		return leftLevel;
	}

	/**
	 * Set the value related to the column: left_level
	 * @param leftLevel the left_level value
	 */
	public void setLeftLevel (java.lang.String leftLevel) {
		this.leftLevel = leftLevel;
	}



	/**
	 * Return the value associated with the column: right_size
	 */
	public java.lang.String getRightSize () {
		return rightSize;
	}

	/**
	 * Set the value related to the column: right_size
	 * @param rightSize the right_size value
	 */
	public void setRightSize (java.lang.String rightSize) {
		this.rightSize = rightSize;
	}



	/**
	 * Return the value associated with the column: left_size
	 */
	public java.lang.String getLeftSize () {
		return leftSize;
	}

	/**
	 * Set the value related to the column: left_size
	 * @param leftSize the left_size value
	 */
	public void setLeftSize (java.lang.String leftSize) {
		this.leftSize = leftSize;
	}



	/**
	 * Return the value associated with the column: right_consistency
	 */
	public java.lang.String getRightConsistency () {
		return rightConsistency;
	}

	/**
	 * Set the value related to the column: right_consistency
	 * @param rightConsistency the right_consistency value
	 */
	public void setRightConsistency (java.lang.String rightConsistency) {
		this.rightConsistency = rightConsistency;
	}



	/**
	 * Return the value associated with the column: left_consistency
	 */
	public java.lang.String getLeftConsistency () {
		return leftConsistency;
	}

	/**
	 * Set the value related to the column: left_consistency
	 * @param leftConsistency the left_consistency value
	 */
	public void setLeftConsistency (java.lang.String leftConsistency) {
		this.leftConsistency = leftConsistency;
	}



	/**
	 * Return the value associated with the column: right_surface
	 */
	public java.lang.String getRightSurface () {
		return rightSurface;
	}

	/**
	 * Set the value related to the column: right_surface
	 * @param rightSurface the right_surface value
	 */
	public void setRightSurface (java.lang.String rightSurface) {
		this.rightSurface = rightSurface;
	}



	/**
	 * Return the value associated with the column: right_surface_value
	 */
	public java.lang.String getRightSurfaceValue () {
		return rightSurfaceValue;
	}

	/**
	 * Set the value related to the column: right_surface_value
	 * @param rightSurfaceValue the right_surface_value value
	 */
	public void setRightSurfaceValue (java.lang.String rightSurfaceValue) {
		this.rightSurfaceValue = rightSurfaceValue;
	}



	/**
	 * Return the value associated with the column: left_surface
	 */
	public java.lang.String getLeftSurface () {
		return leftSurface;
	}

	/**
	 * Set the value related to the column: left_surface
	 * @param leftSurface the left_surface value
	 */
	public void setLeftSurface (java.lang.String leftSurface) {
		this.leftSurface = leftSurface;
	}



	/**
	 * Return the value associated with the column: left_surface_value
	 */
	public java.lang.String getLeftSurfaceValue () {
		return leftSurfaceValue;
	}

	/**
	 * Set the value related to the column: left_surface_value
	 * @param leftSurfaceValue the left_surface_value value
	 */
	public void setLeftSurfaceValue (java.lang.String leftSurfaceValue) {
		this.leftSurfaceValue = leftSurfaceValue;
	}



	/**
	 * Return the value associated with the column: right_margins
	 */
	public java.lang.String getRightMargins () {
		return rightMargins;
	}

	/**
	 * Set the value related to the column: right_margins
	 * @param rightMargins the right_margins value
	 */
	public void setRightMargins (java.lang.String rightMargins) {
		this.rightMargins = rightMargins;
	}



	/**
	 * Return the value associated with the column: left_margins
	 */
	public java.lang.String getLeftMargins () {
		return leftMargins;
	}

	/**
	 * Set the value related to the column: left_margins
	 * @param leftMargins the left_margins value
	 */
	public void setLeftMargins (java.lang.String leftMargins) {
		this.leftMargins = leftMargins;
	}



	/**
	 * Return the value associated with the column: right_mobility
	 */
	public java.lang.String getRightMobility () {
		return rightMobility;
	}

	/**
	 * Set the value related to the column: right_mobility
	 * @param rightMobility the right_mobility value
	 */
	public void setRightMobility (java.lang.String rightMobility) {
		this.rightMobility = rightMobility;
	}



	/**
	 * Return the value associated with the column: right_mobility_value
	 */
	public java.lang.String getRightMobilityValue () {
		return rightMobilityValue;
	}

	/**
	 * Set the value related to the column: right_mobility_value
	 * @param rightMobilityValue the right_mobility_value value
	 */
	public void setRightMobilityValue (java.lang.String rightMobilityValue) {
		this.rightMobilityValue = rightMobilityValue;
	}



	/**
	 * Return the value associated with the column: left_mobility
	 */
	public java.lang.String getLeftMobility () {
		return leftMobility;
	}

	/**
	 * Set the value related to the column: left_mobility
	 * @param leftMobility the left_mobility value
	 */
	public void setLeftMobility (java.lang.String leftMobility) {
		this.leftMobility = leftMobility;
	}



	/**
	 * Return the value associated with the column: left_mobility_value
	 */
	public java.lang.String getLeftMobilityValue () {
		return leftMobilityValue;
	}

	/**
	 * Set the value related to the column: left_mobility_value
	 * @param leftMobilityValue the left_mobility_value value
	 */
	public void setLeftMobilityValue (java.lang.String leftMobilityValue) {
		this.leftMobilityValue = leftMobilityValue;
	}



	/**
	 * Return the value associated with the column: laryngeal_framework
	 */
	public java.lang.String getLaryngealFramework () {
		return laryngealFramework;
	}

	/**
	 * Set the value related to the column: laryngeal_framework
	 * @param laryngealFramework the laryngeal_framework value
	 */
	public void setLaryngealFramework (java.lang.String laryngealFramework) {
		this.laryngealFramework = laryngealFramework;
	}



	/**
	 * Return the value associated with the column: laryngeal_framework_value
	 */
	public java.lang.String getLaryngealFrameworkValue () {
		return laryngealFrameworkValue;
	}

	/**
	 * Set the value related to the column: laryngeal_framework_value
	 * @param laryngealFrameworkValue the laryngeal_framework_value value
	 */
	public void setLaryngealFrameworkValue (java.lang.String laryngealFrameworkValue) {
		this.laryngealFrameworkValue = laryngealFrameworkValue;
	}



	/**
	 * Return the value associated with the column: thyroid
	 */
	public java.lang.String getThyroid () {
		return thyroid;
	}

	/**
	 * Set the value related to the column: thyroid
	 * @param thyroid the thyroid value
	 */
	public void setThyroid (java.lang.String thyroid) {
		this.thyroid = thyroid;
	}



	/**
	 * Return the value associated with the column: carotid
	 */
	public java.lang.String getCarotid () {
		return carotid;
	}

	/**
	 * Set the value related to the column: carotid
	 * @param carotid the carotid value
	 */
	public void setCarotid (java.lang.String carotid) {
		this.carotid = carotid;
	}



	/**
	 * Return the value associated with the column: internal_jugular_vein
	 */
	public java.lang.String getInternalJugularVein () {
		return internalJugularVein;
	}

	/**
	 * Set the value related to the column: internal_jugular_vein
	 * @param internalJugularVein the internal_jugular_vein value
	 */
	public void setInternalJugularVein (java.lang.String internalJugularVein) {
		this.internalJugularVein = internalJugularVein;
	}



	/**
	 * Return the value associated with the column: any_other_swelling
	 */
	public java.lang.String getAnyOtherSwelling () {
		return anyOtherSwelling;
	}

	/**
	 * Set the value related to the column: any_other_swelling
	 * @param anyOtherSwelling the any_other_swelling value
	 */
	public void setAnyOtherSwelling (java.lang.String anyOtherSwelling) {
		this.anyOtherSwelling = anyOtherSwelling;
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
	 * Return the value associated with the column: any_other
	 */
	public java.lang.String getAnyOther () {
		return anyOther;
	}

	/**
	 * Set the value related to the column: any_other
	 * @param anyOther the any_other value
	 */
	public void setAnyOther (java.lang.String anyOther) {
		this.anyOther = anyOther;
	}



	/**
	 * Return the value associated with the column: left_choane_value
	 */
	public java.lang.String getLeftChoaneValue () {
		return leftChoaneValue;
	}

	/**
	 * Set the value related to the column: left_choane_value
	 * @param leftChoaneValue the left_choane_value value
	 */
	public void setLeftChoaneValue (java.lang.String leftChoaneValue) {
		this.leftChoaneValue = leftChoaneValue;
	}



	/**
	 * Return the value associated with the column: right_choane_value
	 */
	public java.lang.String getRightChoaneValue () {
		return rightChoaneValue;
	}

	/**
	 * Set the value related to the column: right_choane_value
	 * @param rightChoaneValue the right_choane_value value
	 */
	public void setRightChoaneValue (java.lang.String rightChoaneValue) {
		this.rightChoaneValue = rightChoaneValue;
	}



	/**
	 * Return the value associated with the column: left_postnatal_roof_value
	 */
	public java.lang.String getLeftPostnatalRoofValue () {
		return leftPostnatalRoofValue;
	}

	/**
	 * Set the value related to the column: left_postnatal_roof_value
	 * @param leftPostnatalRoofValue the left_postnatal_roof_value value
	 */
	public void setLeftPostnatalRoofValue (java.lang.String leftPostnatalRoofValue) {
		this.leftPostnatalRoofValue = leftPostnatalRoofValue;
	}



	/**
	 * Return the value associated with the column: right_postnatal_roof_value
	 */
	public java.lang.String getRightPostnatalRoofValue () {
		return rightPostnatalRoofValue;
	}

	/**
	 * Set the value related to the column: right_postnatal_roof_value
	 * @param rightPostnatalRoofValue the right_postnatal_roof_value value
	 */
	public void setRightPostnatalRoofValue (java.lang.String rightPostnatalRoofValue) {
		this.rightPostnatalRoofValue = rightPostnatalRoofValue;
	}



	/**
	 * Return the value associated with the column: left_ET_onliae_value
	 */
	public java.lang.String getLeftEtOnliaeValue () {
		return leftEtOnliaeValue;
	}

	/**
	 * Set the value related to the column: left_ET_onliae_value
	 * @param leftEtOnliaeValue the left_ET_onliae_value value
	 */
	public void setLeftEtOnliaeValue (java.lang.String leftEtOnliaeValue) {
		this.leftEtOnliaeValue = leftEtOnliaeValue;
	}



	/**
	 * Return the value associated with the column: right_ET_onliae_value
	 */
	public java.lang.String getRightEtOnliaeValue () {
		return rightEtOnliaeValue;
	}

	/**
	 * Set the value related to the column: right_ET_onliae_value
	 * @param rightEtOnliaeValue the right_ET_onliae_value value
	 */
	public void setRightEtOnliaeValue (java.lang.String rightEtOnliaeValue) {
		this.rightEtOnliaeValue = rightEtOnliaeValue;
	}



	/**
	 * Return the value associated with the column: left_for_value
	 */
	public java.lang.String getLeftForValue () {
		return leftForValue;
	}

	/**
	 * Set the value related to the column: left_for_value
	 * @param leftForValue the left_for_value value
	 */
	public void setLeftForValue (java.lang.String leftForValue) {
		this.leftForValue = leftForValue;
	}



	/**
	 * Return the value associated with the column: right_for_value
	 */
	public java.lang.String getRightForValue () {
		return rightForValue;
	}

	/**
	 * Set the value related to the column: right_for_value
	 * @param rightForValue the right_for_value value
	 */
	public void setRightForValue (java.lang.String rightForValue) {
		this.rightForValue = rightForValue;
	}



	/**
	 * Return the value associated with the column: left_posterior_turbinates_value
	 */
	public java.lang.String getLeftPosteriorTurbinatesValue () {
		return leftPosteriorTurbinatesValue;
	}

	/**
	 * Set the value related to the column: left_posterior_turbinates_value
	 * @param leftPosteriorTurbinatesValue the left_posterior_turbinates_value value
	 */
	public void setLeftPosteriorTurbinatesValue (java.lang.String leftPosteriorTurbinatesValue) {
		this.leftPosteriorTurbinatesValue = leftPosteriorTurbinatesValue;
	}



	/**
	 * Return the value associated with the column: right_posterior_turbinates_value
	 */
	public java.lang.String getRightPosteriorTurbinatesValue () {
		return rightPosteriorTurbinatesValue;
	}

	/**
	 * Set the value related to the column: right_posterior_turbinates_value
	 * @param rightPosteriorTurbinatesValue the right_posterior_turbinates_value value
	 */
	public void setRightPosteriorTurbinatesValue (java.lang.String rightPosteriorTurbinatesValue) {
		this.rightPosteriorTurbinatesValue = rightPosteriorTurbinatesValue;
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
	 * Return the value associated with the column: tongue_value
	 */
	public java.lang.String getTongueValue () {
		return tongueValue;
	}

	/**
	 * Set the value related to the column: tongue_value
	 * @param tongueValue the tongue_value value
	 */
	public void setTongueValue (java.lang.String tongueValue) {
		this.tongueValue = tongueValue;
	}



	/**
	 * Return the value associated with the column: left_deviation
	 */
	public java.lang.String getLeftDeviation () {
		return leftDeviation;
	}

	/**
	 * Set the value related to the column: left_deviation
	 * @param leftDeviation the left_deviation value
	 */
	public void setLeftDeviation (java.lang.String leftDeviation) {
		this.leftDeviation = leftDeviation;
	}



	/**
	 * Return the value associated with the column: right_deviation
	 */
	public java.lang.String getRightDeviation () {
		return rightDeviation;
	}

	/**
	 * Set the value related to the column: right_deviation
	 * @param rightDeviation the right_deviation value
	 */
	public void setRightDeviation (java.lang.String rightDeviation) {
		this.rightDeviation = rightDeviation;
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
	 * Return the value associated with the column: signs_of_meningeal_irritation
	 */
	public java.lang.String getSignsOfMeningealIrritation () {
		return signsOfMeningealIrritation;
	}

	/**
	 * Set the value related to the column: signs_of_meningeal_irritation
	 * @param signsOfMeningealIrritation the signs_of_meningeal_irritation value
	 */
	public void setSignsOfMeningealIrritation (java.lang.String signsOfMeningealIrritation) {
		this.signsOfMeningealIrritation = signsOfMeningealIrritation;
	}



	/**
	 * Return the value associated with the column: eye_and_orbit
	 */
	public java.lang.String getEyeAndOrbit () {
		return eyeAndOrbit;
	}

	/**
	 * Set the value related to the column: eye_and_orbit
	 * @param eyeAndOrbit the eye_and_orbit value
	 */
	public void setEyeAndOrbit (java.lang.String eyeAndOrbit) {
		this.eyeAndOrbit = eyeAndOrbit;
	}



	/**
	 * Return the value associated with the column: gingivo_buccal_sulcus
	 */
	public java.lang.String getGingivoBuccalSulcus () {
		return gingivoBuccalSulcus;
	}

	/**
	 * Set the value related to the column: gingivo_buccal_sulcus
	 * @param gingivoBuccalSulcus the gingivo_buccal_sulcus value
	 */
	public void setGingivoBuccalSulcus (java.lang.String gingivoBuccalSulcus) {
		this.gingivoBuccalSulcus = gingivoBuccalSulcus;
	}



	/**
	 * Return the value associated with the column: hard_palate
	 */
	public java.lang.String getHardPalate () {
		return hardPalate;
	}

	/**
	 * Set the value related to the column: hard_palate
	 * @param hardPalate the hard_palate value
	 */
	public void setHardPalate (java.lang.String hardPalate) {
		this.hardPalate = hardPalate;
	}



	/**
	 * Return the value associated with the column: palpable_pulsation_value
	 */
	public java.lang.String getPalpablePulsationValue () {
		return palpablePulsationValue;
	}

	/**
	 * Set the value related to the column: palpable_pulsation_value
	 * @param palpablePulsationValue the palpable_pulsation_value value
	 */
	public void setPalpablePulsationValue (java.lang.String palpablePulsationValue) {
		this.palpablePulsationValue = palpablePulsationValue;
	}



	/**
	 * Return the value associated with the column: nose_septum
	 */
	public java.lang.String getNoseSeptum () {
		return noseSeptum;
	}

	/**
	 * Set the value related to the column: nose_septum
	 * @param noseSeptum the nose_septum value
	 */
	public void setNoseSeptum (java.lang.String noseSeptum) {
		this.noseSeptum = noseSeptum;
	}



	/**
	 * Return the value associated with the column: nose_left_it
	 */
	public java.lang.String getNoseLeftIt () {
		return noseLeftIt;
	}

	/**
	 * Set the value related to the column: nose_left_it
	 * @param noseLeftIt the nose_left_it value
	 */
	public void setNoseLeftIt (java.lang.String noseLeftIt) {
		this.noseLeftIt = noseLeftIt;
	}



	/**
	 * Return the value associated with the column: nose_right_it
	 */
	public java.lang.String getNoseRightIt () {
		return noseRightIt;
	}

	/**
	 * Set the value related to the column: nose_right_it
	 * @param noseRightIt the nose_right_it value
	 */
	public void setNoseRightIt (java.lang.String noseRightIt) {
		this.noseRightIt = noseRightIt;
	}



	/**
	 * Return the value associated with the column: nose_left_im
	 */
	public java.lang.String getNoseLeftIm () {
		return noseLeftIm;
	}

	/**
	 * Set the value related to the column: nose_left_im
	 * @param noseLeftIm the nose_left_im value
	 */
	public void setNoseLeftIm (java.lang.String noseLeftIm) {
		this.noseLeftIm = noseLeftIm;
	}



	/**
	 * Return the value associated with the column: nose_right_im
	 */
	public java.lang.String getNoseRightIm () {
		return noseRightIm;
	}

	/**
	 * Set the value related to the column: nose_right_im
	 * @param noseRightIm the nose_right_im value
	 */
	public void setNoseRightIm (java.lang.String noseRightIm) {
		this.noseRightIm = noseRightIm;
	}



	/**
	 * Return the value associated with the column: nose_left_mt
	 */
	public java.lang.String getNoseLeftMt () {
		return noseLeftMt;
	}

	/**
	 * Set the value related to the column: nose_left_mt
	 * @param noseLeftMt the nose_left_mt value
	 */
	public void setNoseLeftMt (java.lang.String noseLeftMt) {
		this.noseLeftMt = noseLeftMt;
	}



	/**
	 * Return the value associated with the column: nose_right_mt
	 */
	public java.lang.String getNoseRightMt () {
		return noseRightMt;
	}

	/**
	 * Set the value related to the column: nose_right_mt
	 * @param noseRightMt the nose_right_mt value
	 */
	public void setNoseRightMt (java.lang.String noseRightMt) {
		this.noseRightMt = noseRightMt;
	}



	/**
	 * Return the value associated with the column: nose_left_mm
	 */
	public java.lang.String getNoseLeftMm () {
		return noseLeftMm;
	}

	/**
	 * Set the value related to the column: nose_left_mm
	 * @param noseLeftMm the nose_left_mm value
	 */
	public void setNoseLeftMm (java.lang.String noseLeftMm) {
		this.noseLeftMm = noseLeftMm;
	}



	/**
	 * Return the value associated with the column: nose_right_mm
	 */
	public java.lang.String getNoseRightMm () {
		return noseRightMm;
	}

	/**
	 * Set the value related to the column: nose_right_mm
	 * @param noseRightMm the nose_right_mm value
	 */
	public void setNoseRightMm (java.lang.String noseRightMm) {
		this.noseRightMm = noseRightMm;
	}



	/**
	 * Return the value associated with the column: nose_left_floor
	 */
	public java.lang.String getNoseLeftFloor () {
		return noseLeftFloor;
	}

	/**
	 * Set the value related to the column: nose_left_floor
	 * @param noseLeftFloor the nose_left_floor value
	 */
	public void setNoseLeftFloor (java.lang.String noseLeftFloor) {
		this.noseLeftFloor = noseLeftFloor;
	}



	/**
	 * Return the value associated with the column: nose_right_floor
	 */
	public java.lang.String getNoseRightFloor () {
		return noseRightFloor;
	}

	/**
	 * Set the value related to the column: nose_right_floor
	 * @param noseRightFloor the nose_right_floor value
	 */
	public void setNoseRightFloor (java.lang.String noseRightFloor) {
		this.noseRightFloor = noseRightFloor;
	}



	/**
	 * Return the value associated with the column: nose_left_roof
	 */
	public java.lang.String getNoseLeftRoof () {
		return noseLeftRoof;
	}

	/**
	 * Set the value related to the column: nose_left_roof
	 * @param noseLeftRoof the nose_left_roof value
	 */
	public void setNoseLeftRoof (java.lang.String noseLeftRoof) {
		this.noseLeftRoof = noseLeftRoof;
	}



	/**
	 * Return the value associated with the column: nose_right_roof
	 */
	public java.lang.String getNoseRightRoof () {
		return noseRightRoof;
	}

	/**
	 * Set the value related to the column: nose_right_roof
	 * @param noseRightRoof the nose_right_roof value
	 */
	public void setNoseRightRoof (java.lang.String noseRightRoof) {
		this.noseRightRoof = noseRightRoof;
	}



	/**
	 * Return the value associated with the column: rinne_other_value_left
	 */
	public java.lang.String getRinneOtherValueLeft () {
		return rinneOtherValueLeft;
	}

	/**
	 * Set the value related to the column: rinne_other_value_left
	 * @param rinneOtherValueLeft the rinne_other_value_left value
	 */
	public void setRinneOtherValueLeft (java.lang.String rinneOtherValueLeft) {
		this.rinneOtherValueLeft = rinneOtherValueLeft;
	}



	/**
	 * Return the value associated with the column: rinne_other_value_right
	 */
	public java.lang.String getRinneOtherValueRight () {
		return rinneOtherValueRight;
	}

	/**
	 * Set the value related to the column: rinne_other_value_right
	 * @param rinneOtherValueRight the rinne_other_value_right value
	 */
	public void setRinneOtherValueRight (java.lang.String rinneOtherValueRight) {
		this.rinneOtherValueRight = rinneOtherValueRight;
	}



	/**
	 * Return the value associated with the column: olfaction_value_left
	 */
	public java.lang.String getOlfactionValueLeft () {
		return olfactionValueLeft;
	}

	/**
	 * Set the value related to the column: olfaction_value_left
	 * @param olfactionValueLeft the olfaction_value_left value
	 */
	public void setOlfactionValueLeft (java.lang.String olfactionValueLeft) {
		this.olfactionValueLeft = olfactionValueLeft;
	}



	/**
	 * Return the value associated with the column: olfaction_value_right
	 */
	public java.lang.String getOlfactionValueRight () {
		return olfactionValueRight;
	}

	/**
	 * Set the value related to the column: olfaction_value_right
	 * @param olfactionValueRight the olfaction_value_right value
	 */
	public void setOlfactionValueRight (java.lang.String olfactionValueRight) {
		this.olfactionValueRight = olfactionValueRight;
	}



	/**
	 * Return the value associated with the column: tympanic_left_perforation
	 */
	public java.lang.String getTympanicLeftPerforation () {
		return tympanicLeftPerforation;
	}

	/**
	 * Set the value related to the column: tympanic_left_perforation
	 * @param tympanicLeftPerforation the tympanic_left_perforation value
	 */
	public void setTympanicLeftPerforation (java.lang.String tympanicLeftPerforation) {
		this.tympanicLeftPerforation = tympanicLeftPerforation;
	}



	/**
	 * Return the value associated with the column: parse_flaccida_value_left
	 */
	public java.lang.String getParseFlaccidaValueLeft () {
		return parseFlaccidaValueLeft;
	}

	/**
	 * Set the value related to the column: parse_flaccida_value_left
	 * @param parseFlaccidaValueLeft the parse_flaccida_value_left value
	 */
	public void setParseFlaccidaValueLeft (java.lang.String parseFlaccidaValueLeft) {
		this.parseFlaccidaValueLeft = parseFlaccidaValueLeft;
	}



	/**
	 * Return the value associated with the column: left_parse_tensa
	 */
	public java.lang.String getLeftParseTensa () {
		return leftParseTensa;
	}

	/**
	 * Set the value related to the column: left_parse_tensa
	 * @param leftParseTensa the left_parse_tensa value
	 */
	public void setLeftParseTensa (java.lang.String leftParseTensa) {
		this.leftParseTensa = leftParseTensa;
	}



	/**
	 * Return the value associated with the column: right_central
	 */
	public java.lang.String getRightCentral () {
		return rightCentral;
	}

	/**
	 * Set the value related to the column: right_central
	 * @param rightCentral the right_central value
	 */
	public void setRightCentral (java.lang.String rightCentral) {
		this.rightCentral = rightCentral;
	}



	/**
	 * Return the value associated with the column: marginal_value_left
	 */
	public java.lang.String getMarginalValueLeft () {
		return marginalValueLeft;
	}

	/**
	 * Set the value related to the column: marginal_value_left
	 * @param marginalValueLeft the marginal_value_left value
	 */
	public void setMarginalValueLeft (java.lang.String marginalValueLeft) {
		this.marginalValueLeft = marginalValueLeft;
	}



	/**
	 * Return the value associated with the column: left_middle_ear_mucosa
	 */
	public java.lang.String getLeftMiddleEarMucosa () {
		return leftMiddleEarMucosa;
	}

	/**
	 * Set the value related to the column: left_middle_ear_mucosa
	 * @param leftMiddleEarMucosa the left_middle_ear_mucosa value
	 */
	public void setLeftMiddleEarMucosa (java.lang.String leftMiddleEarMucosa) {
		this.leftMiddleEarMucosa = leftMiddleEarMucosa;
	}



	/**
	 * Return the value associated with the column: left_discharge
	 */
	public java.lang.String getLeftDischarge () {
		return leftDischarge;
	}

	/**
	 * Set the value related to the column: left_discharge
	 * @param leftDischarge the left_discharge value
	 */
	public void setLeftDischarge (java.lang.String leftDischarge) {
		this.leftDischarge = leftDischarge;
	}



	/**
	 * Return the value associated with the column: tympanic_right_perforation
	 */
	public java.lang.String getTympanicRightPerforation () {
		return tympanicRightPerforation;
	}

	/**
	 * Set the value related to the column: tympanic_right_perforation
	 * @param tympanicRightPerforation the tympanic_right_perforation value
	 */
	public void setTympanicRightPerforation (java.lang.String tympanicRightPerforation) {
		this.tympanicRightPerforation = tympanicRightPerforation;
	}



	/**
	 * Return the value associated with the column: parse_flaccida_value_right
	 */
	public java.lang.String getParseFlaccidaValueRight () {
		return parseFlaccidaValueRight;
	}

	/**
	 * Set the value related to the column: parse_flaccida_value_right
	 * @param parseFlaccidaValueRight the parse_flaccida_value_right value
	 */
	public void setParseFlaccidaValueRight (java.lang.String parseFlaccidaValueRight) {
		this.parseFlaccidaValueRight = parseFlaccidaValueRight;
	}



	/**
	 * Return the value associated with the column: right_parse_tensa
	 */
	public java.lang.String getRightParseTensa () {
		return rightParseTensa;
	}

	/**
	 * Set the value related to the column: right_parse_tensa
	 * @param rightParseTensa the right_parse_tensa value
	 */
	public void setRightParseTensa (java.lang.String rightParseTensa) {
		this.rightParseTensa = rightParseTensa;
	}



	/**
	 * Return the value associated with the column: left_central
	 */
	public java.lang.String getLeftCentral () {
		return leftCentral;
	}

	/**
	 * Set the value related to the column: left_central
	 * @param leftCentral the left_central value
	 */
	public void setLeftCentral (java.lang.String leftCentral) {
		this.leftCentral = leftCentral;
	}



	/**
	 * Return the value associated with the column: marginal_value_right
	 */
	public java.lang.String getMarginalValueRight () {
		return marginalValueRight;
	}

	/**
	 * Set the value related to the column: marginal_value_right
	 * @param marginalValueRight the marginal_value_right value
	 */
	public void setMarginalValueRight (java.lang.String marginalValueRight) {
		this.marginalValueRight = marginalValueRight;
	}



	/**
	 * Return the value associated with the column: right_middle_ear_mucosa
	 */
	public java.lang.String getRightMiddleEarMucosa () {
		return rightMiddleEarMucosa;
	}

	/**
	 * Set the value related to the column: right_middle_ear_mucosa
	 * @param rightMiddleEarMucosa the right_middle_ear_mucosa value
	 */
	public void setRightMiddleEarMucosa (java.lang.String rightMiddleEarMucosa) {
		this.rightMiddleEarMucosa = rightMiddleEarMucosa;
	}



	/**
	 * Return the value associated with the column: right_discharge
	 */
	public java.lang.String getRightDischarge () {
		return rightDischarge;
	}

	/**
	 * Set the value related to the column: right_discharge
	 * @param rightDischarge the right_discharge value
	 */
	public void setRightDischarge (java.lang.String rightDischarge) {
		this.rightDischarge = rightDischarge;
	}



	/**
	 * Return the value associated with the column: image_name
	 */
	public java.lang.String getImageName () {
		return imageName;
	}

	/**
	 * Set the value related to the column: image_name
	 * @param imageName the image_name value
	 */
	public void setImageName (java.lang.String imageName) {
		this.imageName = imageName;
	}



	/**
	 * Return the value associated with the column: opd_patient_details
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details
	 * @param opdPatientDetails the opd_patient_details value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdEntExaminationSpeciality)) return false;
		else {
			jkt.hms.masters.business.OpdEntExaminationSpeciality opdEntExaminationSpeciality = (jkt.hms.masters.business.OpdEntExaminationSpeciality) obj;
			if (null == this.getId() || null == opdEntExaminationSpeciality.getId()) return false;
			else return (this.getId().equals(opdEntExaminationSpeciality.getId()));
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