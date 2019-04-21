package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_lionc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_lionc"
 */

public abstract class BaseMasLionc  implements Serializable {

	public static String REF = "MasLionc";
	public static String PROP_EXTERNAL_COPYRIGHT_NOTICE = "ExternalCopyrightNotice";
	public static String PROP_PROPERTY = "Property";
	public static String PROP_SPECIES = "Species";
	public static String PROP_PANELELEMENTS = "Panelelements";
	public static String PROP_HL7_V3_DATATYPE = "Hl7V3Datatype";
	public static String PROP_CODE_TABLE = "CodeTable";
	public static String PROP_RELAT_NMS = "RelatNms";
	public static String PROP_FINAL = "Final";
	public static String PROP_MAP_TO = "MapTo";
	public static String PROP_CONSUMER_NAME = "ConsumerName";
	public static String PROP_EXAMPLE_UNITS = "ExampleUnits";
	public static String PROP_SCALE_TYP = "ScaleTyp";
	public static String PROP_FORMULA = "Formula";
	public static String PROP_SURVEY_QUEST_TEXT = "SurveyQuestText";
	public static String PROP_UNITSREQUIRED = "Unitsrequired";
	public static String PROP_CLASSTYPE = "Classtype";
	public static String PROP_HL7_V2_DATATYPE = "Hl7V2Datatype";
	public static String PROP_TIME_ASPCT = "TimeAspct";
	public static String PROP_INPC_PERCENTAGE = "InpcPercentage";
	public static String PROP_IPCC_UNITS = "IpccUnits";
	public static String PROP_STATUS = "Status";
	public static String PROP_SETROOT = "Setroot";
	public static String PROP_HL7_FIELD_SUBFIELD_ID = "Hl7FieldSubfieldId";
	public static String PROP_SHORTNAME = "Shortname";
	public static String PROP_ORDER_OBS = "OrderObs";
	public static String PROP_COMPONENT = "Component";
	public static String PROP_MAS_CLASS = "MasClass";
	public static String PROP_DT_LAST_CH = "DtLastCh";
	public static String PROP_CDISC_COMMON_TESTS = "CdiscCommonTests";
	public static String PROP_MOLAR_MASS = "MolarMass";
	public static String PROP_DEFINITION_DESCRIPTION_HELP = "DefinitionDescriptionHelp";
	public static String PROP_ACSSYM = "Acssym";
	public static String PROP_EXMPL_ANSWERS = "ExmplAnswers";
	public static String PROP_LONG_COMMON_NAME = "LongCommonName";
	public static String PROP_RELATEDNAMES2 = "Relatednames2";
	public static String PROP_SCOPE = "Scope";
	public static String PROP_SURVEY_QUEST_SRC = "SurveyQuestSrc";
	public static String PROP_METHOD_TYP = "MethodTyp";
	public static String PROP_CURATED_RANGE_AND_UNITS = "CuratedRangeAndUnits";
	public static String PROP_CHNG_TYPE = "ChngType";
	public static String PROP_ANSWERLIST = "Answerlist";
	public static String PROP_SOURCE = "Source";
	public static String PROP_SUBMITTED_UNITS = "SubmittedUnits";
	public static String PROP_REFERENCE = "Reference";
	public static String PROP_SYSTEM = "System";
	public static String PROP_EXACT_CMP_SY = "ExactCmpSy";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_BASE_NAME = "BaseName";
	public static String PROP_NAACCR_ID = "NaaccrId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMasLionc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasLionc (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasLionc (
		java.lang.String id,
		java.lang.String component,
		java.lang.Integer classtype,
		java.lang.String m_final,
		boolean setroot,
		java.lang.String inpcPercentage) {

		this.setId(id);
		this.setComponent(component);
		this.setClasstype(classtype);
		this.setFinal(m_final);
		this.setSetroot(setroot);
		this.setInpcPercentage(inpcPercentage);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String component;
	private java.lang.String property;
	private java.lang.String timeAspct;
	private java.lang.String system;
	private java.lang.String scaleTyp;
	private java.lang.String methodTyp;
	private java.lang.String relatNms;
	private java.lang.String masClass;
	private java.lang.String source;
	private java.lang.String dtLastCh;
	private java.lang.String chngType;
	private java.lang.String comments;
	private java.lang.String answerlist;
	private java.lang.String status;
	private java.lang.String mapTo;
	private java.lang.String scope;
	private java.lang.String consumerName;
	private java.lang.String ipccUnits;
	private java.lang.String reference;
	private java.lang.String exactCmpSy;
	private java.lang.String molarMass;
	private java.lang.Integer classtype;
	private java.lang.String formula;
	private java.lang.String species;
	private java.lang.String exmplAnswers;
	private java.lang.String acssym;
	private java.lang.String baseName;
	private java.lang.String m_final;
	private java.lang.String naaccrId;
	private java.lang.String codeTable;
	private boolean setroot;
	private java.lang.String panelelements;
	private java.lang.String surveyQuestText;
	private java.lang.String surveyQuestSrc;
	private java.lang.String unitsrequired;
	private java.lang.String submittedUnits;
	private java.lang.String relatednames2;
	private java.lang.String shortname;
	private java.lang.String orderObs;
	private java.lang.String cdiscCommonTests;
	private java.lang.String hl7FieldSubfieldId;
	private java.lang.String externalCopyrightNotice;
	private java.lang.String exampleUnits;
	private java.lang.String inpcPercentage;
	private java.lang.String longCommonName;
	private java.lang.String hl7V2Datatype;
	private java.lang.String hl7V3Datatype;
	private java.lang.String curatedRangeAndUnits;
	private java.lang.String definitionDescriptionHelp;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="LOINC_NUM"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: COMPONENT
	 */
	public java.lang.String getComponent () {
		return component;
	}

	/**
	 * Set the value related to the column: COMPONENT
	 * @param component the COMPONENT value
	 */
	public void setComponent (java.lang.String component) {
		this.component = component;
	}



	/**
	 * Return the value associated with the column: PROPERTY
	 */
	public java.lang.String getProperty () {
		return property;
	}

	/**
	 * Set the value related to the column: PROPERTY
	 * @param property the PROPERTY value
	 */
	public void setProperty (java.lang.String property) {
		this.property = property;
	}



	/**
	 * Return the value associated with the column: TIME_ASPCT
	 */
	public java.lang.String getTimeAspct () {
		return timeAspct;
	}

	/**
	 * Set the value related to the column: TIME_ASPCT
	 * @param timeAspct the TIME_ASPCT value
	 */
	public void setTimeAspct (java.lang.String timeAspct) {
		this.timeAspct = timeAspct;
	}



	/**
	 * Return the value associated with the column: SYSTEM
	 */
	public java.lang.String getSystem () {
		return system;
	}

	/**
	 * Set the value related to the column: SYSTEM
	 * @param system the SYSTEM value
	 */
	public void setSystem (java.lang.String system) {
		this.system = system;
	}



	/**
	 * Return the value associated with the column: SCALE_TYP
	 */
	public java.lang.String getScaleTyp () {
		return scaleTyp;
	}

	/**
	 * Set the value related to the column: SCALE_TYP
	 * @param scaleTyp the SCALE_TYP value
	 */
	public void setScaleTyp (java.lang.String scaleTyp) {
		this.scaleTyp = scaleTyp;
	}



	/**
	 * Return the value associated with the column: METHOD_TYP
	 */
	public java.lang.String getMethodTyp () {
		return methodTyp;
	}

	/**
	 * Set the value related to the column: METHOD_TYP
	 * @param methodTyp the METHOD_TYP value
	 */
	public void setMethodTyp (java.lang.String methodTyp) {
		this.methodTyp = methodTyp;
	}



	/**
	 * Return the value associated with the column: RELAT_NMS
	 */
	public java.lang.String getRelatNms () {
		return relatNms;
	}

	/**
	 * Set the value related to the column: RELAT_NMS
	 * @param relatNms the RELAT_NMS value
	 */
	public void setRelatNms (java.lang.String relatNms) {
		this.relatNms = relatNms;
	}



	/**
	 * Return the value associated with the column: CLASS
	 */
	public java.lang.String getMasClass () {
		return masClass;
	}

	/**
	 * Set the value related to the column: CLASS
	 * @param masClass the CLASS value
	 */
	public void setMasClass (java.lang.String masClass) {
		this.masClass = masClass;
	}



	/**
	 * Return the value associated with the column: SOURCE
	 */
	public java.lang.String getSource () {
		return source;
	}

	/**
	 * Set the value related to the column: SOURCE
	 * @param source the SOURCE value
	 */
	public void setSource (java.lang.String source) {
		this.source = source;
	}



	/**
	 * Return the value associated with the column: DT_LAST_CH
	 */
	public java.lang.String getDtLastCh () {
		return dtLastCh;
	}

	/**
	 * Set the value related to the column: DT_LAST_CH
	 * @param dtLastCh the DT_LAST_CH value
	 */
	public void setDtLastCh (java.lang.String dtLastCh) {
		this.dtLastCh = dtLastCh;
	}



	/**
	 * Return the value associated with the column: CHNG_TYPE
	 */
	public java.lang.String getChngType () {
		return chngType;
	}

	/**
	 * Set the value related to the column: CHNG_TYPE
	 * @param chngType the CHNG_TYPE value
	 */
	public void setChngType (java.lang.String chngType) {
		this.chngType = chngType;
	}



	/**
	 * Return the value associated with the column: COMMENTS
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: COMMENTS
	 * @param comments the COMMENTS value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
	}



	/**
	 * Return the value associated with the column: ANSWERLIST
	 */
	public java.lang.String getAnswerlist () {
		return answerlist;
	}

	/**
	 * Set the value related to the column: ANSWERLIST
	 * @param answerlist the ANSWERLIST value
	 */
	public void setAnswerlist (java.lang.String answerlist) {
		this.answerlist = answerlist;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: MAP_TO
	 */
	public java.lang.String getMapTo () {
		return mapTo;
	}

	/**
	 * Set the value related to the column: MAP_TO
	 * @param mapTo the MAP_TO value
	 */
	public void setMapTo (java.lang.String mapTo) {
		this.mapTo = mapTo;
	}



	/**
	 * Return the value associated with the column: SCOPE
	 */
	public java.lang.String getScope () {
		return scope;
	}

	/**
	 * Set the value related to the column: SCOPE
	 * @param scope the SCOPE value
	 */
	public void setScope (java.lang.String scope) {
		this.scope = scope;
	}



	/**
	 * Return the value associated with the column: CONSUMER_NAME
	 */
	public java.lang.String getConsumerName () {
		return consumerName;
	}

	/**
	 * Set the value related to the column: CONSUMER_NAME
	 * @param consumerName the CONSUMER_NAME value
	 */
	public void setConsumerName (java.lang.String consumerName) {
		this.consumerName = consumerName;
	}



	/**
	 * Return the value associated with the column: IPCC_UNITS
	 */
	public java.lang.String getIpccUnits () {
		return ipccUnits;
	}

	/**
	 * Set the value related to the column: IPCC_UNITS
	 * @param ipccUnits the IPCC_UNITS value
	 */
	public void setIpccUnits (java.lang.String ipccUnits) {
		this.ipccUnits = ipccUnits;
	}



	/**
	 * Return the value associated with the column: REFERENCE
	 */
	public java.lang.String getReference () {
		return reference;
	}

	/**
	 * Set the value related to the column: REFERENCE
	 * @param reference the REFERENCE value
	 */
	public void setReference (java.lang.String reference) {
		this.reference = reference;
	}



	/**
	 * Return the value associated with the column: EXACT_CMP_SY
	 */
	public java.lang.String getExactCmpSy () {
		return exactCmpSy;
	}

	/**
	 * Set the value related to the column: EXACT_CMP_SY
	 * @param exactCmpSy the EXACT_CMP_SY value
	 */
	public void setExactCmpSy (java.lang.String exactCmpSy) {
		this.exactCmpSy = exactCmpSy;
	}



	/**
	 * Return the value associated with the column: MOLAR_MASS
	 */
	public java.lang.String getMolarMass () {
		return molarMass;
	}

	/**
	 * Set the value related to the column: MOLAR_MASS
	 * @param molarMass the MOLAR_MASS value
	 */
	public void setMolarMass (java.lang.String molarMass) {
		this.molarMass = molarMass;
	}



	/**
	 * Return the value associated with the column: CLASSTYPE
	 */
	public java.lang.Integer getClasstype () {
		return classtype;
	}

	/**
	 * Set the value related to the column: CLASSTYPE
	 * @param classtype the CLASSTYPE value
	 */
	public void setClasstype (java.lang.Integer classtype) {
		this.classtype = classtype;
	}



	/**
	 * Return the value associated with the column: FORMULA
	 */
	public java.lang.String getFormula () {
		return formula;
	}

	/**
	 * Set the value related to the column: FORMULA
	 * @param formula the FORMULA value
	 */
	public void setFormula (java.lang.String formula) {
		this.formula = formula;
	}



	/**
	 * Return the value associated with the column: SPECIES
	 */
	public java.lang.String getSpecies () {
		return species;
	}

	/**
	 * Set the value related to the column: SPECIES
	 * @param species the SPECIES value
	 */
	public void setSpecies (java.lang.String species) {
		this.species = species;
	}



	/**
	 * Return the value associated with the column: EXMPL_ANSWERS
	 */
	public java.lang.String getExmplAnswers () {
		return exmplAnswers;
	}

	/**
	 * Set the value related to the column: EXMPL_ANSWERS
	 * @param exmplAnswers the EXMPL_ANSWERS value
	 */
	public void setExmplAnswers (java.lang.String exmplAnswers) {
		this.exmplAnswers = exmplAnswers;
	}



	/**
	 * Return the value associated with the column: ACSSYM
	 */
	public java.lang.String getAcssym () {
		return acssym;
	}

	/**
	 * Set the value related to the column: ACSSYM
	 * @param acssym the ACSSYM value
	 */
	public void setAcssym (java.lang.String acssym) {
		this.acssym = acssym;
	}



	/**
	 * Return the value associated with the column: BASE_NAME
	 */
	public java.lang.String getBaseName () {
		return baseName;
	}

	/**
	 * Set the value related to the column: BASE_NAME
	 * @param baseName the BASE_NAME value
	 */
	public void setBaseName (java.lang.String baseName) {
		this.baseName = baseName;
	}



	/**
	 * Return the value associated with the column: FINAL
	 */
	public java.lang.String getFinal () {
		return m_final;
	}

	/**
	 * Set the value related to the column: FINAL
	 * @param m_final the FINAL value
	 */
	public void setFinal (java.lang.String m_final) {
		this.m_final = m_final;
	}



	/**
	 * Return the value associated with the column: NAACCR_ID
	 */
	public java.lang.String getNaaccrId () {
		return naaccrId;
	}

	/**
	 * Set the value related to the column: NAACCR_ID
	 * @param naaccrId the NAACCR_ID value
	 */
	public void setNaaccrId (java.lang.String naaccrId) {
		this.naaccrId = naaccrId;
	}



	/**
	 * Return the value associated with the column: CODE_TABLE
	 */
	public java.lang.String getCodeTable () {
		return codeTable;
	}

	/**
	 * Set the value related to the column: CODE_TABLE
	 * @param codeTable the CODE_TABLE value
	 */
	public void setCodeTable (java.lang.String codeTable) {
		this.codeTable = codeTable;
	}



	/**
	 * Return the value associated with the column: SETROOT
	 */
	public boolean isSetroot () {
		return setroot;
	}

	/**
	 * Set the value related to the column: SETROOT
	 * @param setroot the SETROOT value
	 */
	public void setSetroot (boolean setroot) {
		this.setroot = setroot;
	}



	/**
	 * Return the value associated with the column: PANELELEMENTS
	 */
	public java.lang.String getPanelelements () {
		return panelelements;
	}

	/**
	 * Set the value related to the column: PANELELEMENTS
	 * @param panelelements the PANELELEMENTS value
	 */
	public void setPanelelements (java.lang.String panelelements) {
		this.panelelements = panelelements;
	}



	/**
	 * Return the value associated with the column: SURVEY_QUEST_TEXT
	 */
	public java.lang.String getSurveyQuestText () {
		return surveyQuestText;
	}

	/**
	 * Set the value related to the column: SURVEY_QUEST_TEXT
	 * @param surveyQuestText the SURVEY_QUEST_TEXT value
	 */
	public void setSurveyQuestText (java.lang.String surveyQuestText) {
		this.surveyQuestText = surveyQuestText;
	}



	/**
	 * Return the value associated with the column: SURVEY_QUEST_SRC
	 */
	public java.lang.String getSurveyQuestSrc () {
		return surveyQuestSrc;
	}

	/**
	 * Set the value related to the column: SURVEY_QUEST_SRC
	 * @param surveyQuestSrc the SURVEY_QUEST_SRC value
	 */
	public void setSurveyQuestSrc (java.lang.String surveyQuestSrc) {
		this.surveyQuestSrc = surveyQuestSrc;
	}



	/**
	 * Return the value associated with the column: UNITSREQUIRED
	 */
	public java.lang.String getUnitsrequired () {
		return unitsrequired;
	}

	/**
	 * Set the value related to the column: UNITSREQUIRED
	 * @param unitsrequired the UNITSREQUIRED value
	 */
	public void setUnitsrequired (java.lang.String unitsrequired) {
		this.unitsrequired = unitsrequired;
	}



	/**
	 * Return the value associated with the column: SUBMITTED_UNITS
	 */
	public java.lang.String getSubmittedUnits () {
		return submittedUnits;
	}

	/**
	 * Set the value related to the column: SUBMITTED_UNITS
	 * @param submittedUnits the SUBMITTED_UNITS value
	 */
	public void setSubmittedUnits (java.lang.String submittedUnits) {
		this.submittedUnits = submittedUnits;
	}



	/**
	 * Return the value associated with the column: RELATEDNAMES2
	 */
	public java.lang.String getRelatednames2 () {
		return relatednames2;
	}

	/**
	 * Set the value related to the column: RELATEDNAMES2
	 * @param relatednames2 the RELATEDNAMES2 value
	 */
	public void setRelatednames2 (java.lang.String relatednames2) {
		this.relatednames2 = relatednames2;
	}



	/**
	 * Return the value associated with the column: SHORTNAME
	 */
	public java.lang.String getShortname () {
		return shortname;
	}

	/**
	 * Set the value related to the column: SHORTNAME
	 * @param shortname the SHORTNAME value
	 */
	public void setShortname (java.lang.String shortname) {
		this.shortname = shortname;
	}



	/**
	 * Return the value associated with the column: ORDER_OBS
	 */
	public java.lang.String getOrderObs () {
		return orderObs;
	}

	/**
	 * Set the value related to the column: ORDER_OBS
	 * @param orderObs the ORDER_OBS value
	 */
	public void setOrderObs (java.lang.String orderObs) {
		this.orderObs = orderObs;
	}



	/**
	 * Return the value associated with the column: CDISC_COMMON_TESTS
	 */
	public java.lang.String getCdiscCommonTests () {
		return cdiscCommonTests;
	}

	/**
	 * Set the value related to the column: CDISC_COMMON_TESTS
	 * @param cdiscCommonTests the CDISC_COMMON_TESTS value
	 */
	public void setCdiscCommonTests (java.lang.String cdiscCommonTests) {
		this.cdiscCommonTests = cdiscCommonTests;
	}



	/**
	 * Return the value associated with the column: HL7_FIELD_SUBFIELD_ID
	 */
	public java.lang.String getHl7FieldSubfieldId () {
		return hl7FieldSubfieldId;
	}

	/**
	 * Set the value related to the column: HL7_FIELD_SUBFIELD_ID
	 * @param hl7FieldSubfieldId the HL7_FIELD_SUBFIELD_ID value
	 */
	public void setHl7FieldSubfieldId (java.lang.String hl7FieldSubfieldId) {
		this.hl7FieldSubfieldId = hl7FieldSubfieldId;
	}



	/**
	 * Return the value associated with the column: EXTERNAL_COPYRIGHT_NOTICE
	 */
	public java.lang.String getExternalCopyrightNotice () {
		return externalCopyrightNotice;
	}

	/**
	 * Set the value related to the column: EXTERNAL_COPYRIGHT_NOTICE
	 * @param externalCopyrightNotice the EXTERNAL_COPYRIGHT_NOTICE value
	 */
	public void setExternalCopyrightNotice (java.lang.String externalCopyrightNotice) {
		this.externalCopyrightNotice = externalCopyrightNotice;
	}



	/**
	 * Return the value associated with the column: EXAMPLE_UNITS
	 */
	public java.lang.String getExampleUnits () {
		return exampleUnits;
	}

	/**
	 * Set the value related to the column: EXAMPLE_UNITS
	 * @param exampleUnits the EXAMPLE_UNITS value
	 */
	public void setExampleUnits (java.lang.String exampleUnits) {
		this.exampleUnits = exampleUnits;
	}



	/**
	 * Return the value associated with the column: INPC_PERCENTAGE
	 */
	public java.lang.String getInpcPercentage () {
		return inpcPercentage;
	}

	/**
	 * Set the value related to the column: INPC_PERCENTAGE
	 * @param inpcPercentage the INPC_PERCENTAGE value
	 */
	public void setInpcPercentage (java.lang.String inpcPercentage) {
		this.inpcPercentage = inpcPercentage;
	}



	/**
	 * Return the value associated with the column: LONG_COMMON_NAME
	 */
	public java.lang.String getLongCommonName () {
		return longCommonName;
	}

	/**
	 * Set the value related to the column: LONG_COMMON_NAME
	 * @param longCommonName the LONG_COMMON_NAME value
	 */
	public void setLongCommonName (java.lang.String longCommonName) {
		this.longCommonName = longCommonName;
	}



	/**
	 * Return the value associated with the column: HL7_V2_DATATYPE
	 */
	public java.lang.String getHl7V2Datatype () {
		return hl7V2Datatype;
	}

	/**
	 * Set the value related to the column: HL7_V2_DATATYPE
	 * @param hl7V2Datatype the HL7_V2_DATATYPE value
	 */
	public void setHl7V2Datatype (java.lang.String hl7V2Datatype) {
		this.hl7V2Datatype = hl7V2Datatype;
	}



	/**
	 * Return the value associated with the column: HL7_V3_DATATYPE
	 */
	public java.lang.String getHl7V3Datatype () {
		return hl7V3Datatype;
	}

	/**
	 * Set the value related to the column: HL7_V3_DATATYPE
	 * @param hl7V3Datatype the HL7_V3_DATATYPE value
	 */
	public void setHl7V3Datatype (java.lang.String hl7V3Datatype) {
		this.hl7V3Datatype = hl7V3Datatype;
	}



	/**
	 * Return the value associated with the column: CURATED_RANGE_AND_UNITS
	 */
	public java.lang.String getCuratedRangeAndUnits () {
		return curatedRangeAndUnits;
	}

	/**
	 * Set the value related to the column: CURATED_RANGE_AND_UNITS
	 * @param curatedRangeAndUnits the CURATED_RANGE_AND_UNITS value
	 */
	public void setCuratedRangeAndUnits (java.lang.String curatedRangeAndUnits) {
		this.curatedRangeAndUnits = curatedRangeAndUnits;
	}



	/**
	 * Return the value associated with the column: DEFINITION_DESCRIPTION_HELP
	 */
	public java.lang.String getDefinitionDescriptionHelp () {
		return definitionDescriptionHelp;
	}

	/**
	 * Set the value related to the column: DEFINITION_DESCRIPTION_HELP
	 * @param definitionDescriptionHelp the DEFINITION_DESCRIPTION_HELP value
	 */
	public void setDefinitionDescriptionHelp (java.lang.String definitionDescriptionHelp) {
		this.definitionDescriptionHelp = definitionDescriptionHelp;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasLionc)) return false;
		else {
			jkt.hms.masters.business.MasLionc masLionc = (jkt.hms.masters.business.MasLionc) obj;
			if (null == this.getId() || null == masLionc.getId()) return false;
			else return (this.getId().equals(masLionc.getId()));
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