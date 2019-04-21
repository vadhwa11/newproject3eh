package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_item_generic table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_item_generic"
 */

public abstract class BaseMasStoreItemGeneric  implements Serializable {

	public static String REF = "MasStoreItemGeneric";
	public static String PROP_PHARMA_INDEX = "PharmaIndex";
	public static String PROP_GENERIC_CLASS = "genericClass";
	public static String PROP_ATC_CLASSIFICATION = "AtcClassification";
	public static String PROP_MECHANISM_OF_ACTION = "MechanismOfAction";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DRUG_INTERACTION = "DrugInteraction";
	public static String PROP_GENERIC_NAME = "GenericName";
	public static String PROP_CONTRA_INDICATION = "ContraIndication";
	public static String PROP_SIDE_EFFECTS = "SideEffects";
	public static String PROP_ATC_CLASSIFICATION_DETAILS = "AtcClassificationDetails";
	public static String PROP_STORAGE = "Storage";
	public static String PROP_PREGNANCY_CATEGORY_US_FDA = "PregnancyCategoryUsFda";
	public static String PROP_OVERDOSAGE = "Overdosage";
	public static String PROP_STATUS = "Status";
	public static String PROP_DOSAGE_CALCULATION = "DosageCalculation";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_INDICATION_DOSAGE = "IndicationDosage";
	public static String PROP_ADMINISTRATION = "Administration";
	public static String PROP_ID = "Id";
	public static String PROP_SPECIAL_PRECAUTION = "SpecialPrecaution";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasStoreItemGeneric () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreItemGeneric (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String genericName;
	private java.lang.String contraIndication;
	private java.lang.String dosageCalculation;
	private java.lang.String drugInteraction;
	private java.lang.String specialPrecaution;
	private java.lang.String sideEffects;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String genericClass;
	private java.lang.String indicationDosage;
	private java.lang.String administration;
	private java.lang.String overdosage;
	private java.lang.String pregnancyCategoryUsFda;
	private java.lang.String storage;
	private java.lang.String mechanismOfAction;
	private java.lang.String atcClassification;
	private java.lang.String atcClassificationDetails;

	// many to one
	private jkt.hms.masters.business.MasStorePharmaIndex pharmaIndex;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;
	private java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="item_generic_id"
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
	 * Return the value associated with the column: generic_name
	 */
	public java.lang.String getGenericName () {
		return genericName;
	}

	/**
	 * Set the value related to the column: generic_name
	 * @param genericName the generic_name value
	 */
	public void setGenericName (java.lang.String genericName) {
		this.genericName = genericName;
	}



	/**
	 * Return the value associated with the column: contra_indication
	 */
	public java.lang.String getContraIndication () {
		return contraIndication;
	}

	/**
	 * Set the value related to the column: contra_indication
	 * @param contraIndication the contra_indication value
	 */
	public void setContraIndication (java.lang.String contraIndication) {
		this.contraIndication = contraIndication;
	}



	/**
	 * Return the value associated with the column: dosage_calculation
	 */
	public java.lang.String getDosageCalculation () {
		return dosageCalculation;
	}

	/**
	 * Set the value related to the column: dosage_calculation
	 * @param dosageCalculation the dosage_calculation value
	 */
	public void setDosageCalculation (java.lang.String dosageCalculation) {
		this.dosageCalculation = dosageCalculation;
	}



	/**
	 * Return the value associated with the column: drug_interaction
	 */
	public java.lang.String getDrugInteraction () {
		return drugInteraction;
	}

	/**
	 * Set the value related to the column: drug_interaction
	 * @param drugInteraction the drug_interaction value
	 */
	public void setDrugInteraction (java.lang.String drugInteraction) {
		this.drugInteraction = drugInteraction;
	}



	/**
	 * Return the value associated with the column: special_precaution
	 */
	public java.lang.String getSpecialPrecaution () {
		return specialPrecaution;
	}

	/**
	 * Set the value related to the column: special_precaution
	 * @param specialPrecaution the special_precaution value
	 */
	public void setSpecialPrecaution (java.lang.String specialPrecaution) {
		this.specialPrecaution = specialPrecaution;
	}



	/**
	 * Return the value associated with the column: side_effects
	 */
	public java.lang.String getSideEffects () {
		return sideEffects;
	}

	/**
	 * Set the value related to the column: side_effects
	 * @param sideEffects the side_effects value
	 */
	public void setSideEffects (java.lang.String sideEffects) {
		this.sideEffects = sideEffects;
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
	 * Return the value associated with the column: generic_class
	 */
	public java.lang.String getGenericClass () {
		return genericClass;
	}

	/**
	 * Set the value related to the column: generic_class
	 * @param genericClass the generic_class value
	 */
	public void setGenericClass (java.lang.String genericClass) {
		this.genericClass = genericClass;
	}



	/**
	 * Return the value associated with the column: indication_Dosage
	 */
	public java.lang.String getIndicationDosage () {
		return indicationDosage;
	}

	/**
	 * Set the value related to the column: indication_Dosage
	 * @param indicationDosage the indication_Dosage value
	 */
	public void setIndicationDosage (java.lang.String indicationDosage) {
		this.indicationDosage = indicationDosage;
	}



	/**
	 * Return the value associated with the column: administration
	 */
	public java.lang.String getAdministration () {
		return administration;
	}

	/**
	 * Set the value related to the column: administration
	 * @param administration the administration value
	 */
	public void setAdministration (java.lang.String administration) {
		this.administration = administration;
	}



	/**
	 * Return the value associated with the column: overdosage
	 */
	public java.lang.String getOverdosage () {
		return overdosage;
	}

	/**
	 * Set the value related to the column: overdosage
	 * @param overdosage the overdosage value
	 */
	public void setOverdosage (java.lang.String overdosage) {
		this.overdosage = overdosage;
	}



	/**
	 * Return the value associated with the column: pregnancy_category_US_FDA
	 */
	public java.lang.String getPregnancyCategoryUsFda () {
		return pregnancyCategoryUsFda;
	}

	/**
	 * Set the value related to the column: pregnancy_category_US_FDA
	 * @param pregnancyCategoryUsFda the pregnancy_category_US_FDA value
	 */
	public void setPregnancyCategoryUsFda (java.lang.String pregnancyCategoryUsFda) {
		this.pregnancyCategoryUsFda = pregnancyCategoryUsFda;
	}



	/**
	 * Return the value associated with the column: storage
	 */
	public java.lang.String getStorage () {
		return storage;
	}

	/**
	 * Set the value related to the column: storage
	 * @param storage the storage value
	 */
	public void setStorage (java.lang.String storage) {
		this.storage = storage;
	}



	/**
	 * Return the value associated with the column: mechanism_of_action
	 */
	public java.lang.String getMechanismOfAction () {
		return mechanismOfAction;
	}

	/**
	 * Set the value related to the column: mechanism_of_action
	 * @param mechanismOfAction the mechanism_of_action value
	 */
	public void setMechanismOfAction (java.lang.String mechanismOfAction) {
		this.mechanismOfAction = mechanismOfAction;
	}



	/**
	 * Return the value associated with the column: atc_classification
	 */
	public java.lang.String getAtcClassification () {
		return atcClassification;
	}

	/**
	 * Set the value related to the column: atc_classification
	 * @param atcClassification the atc_classification value
	 */
	public void setAtcClassification (java.lang.String atcClassification) {
		this.atcClassification = atcClassification;
	}



	/**
	 * Return the value associated with the column: atc_classification_details
	 */
	public java.lang.String getAtcClassificationDetails () {
		return atcClassificationDetails;
	}

	/**
	 * Set the value related to the column: atc_classification_details
	 * @param atcClassificationDetails the atc_classification_details value
	 */
	public void setAtcClassificationDetails (java.lang.String atcClassificationDetails) {
		this.atcClassificationDetails = atcClassificationDetails;
	}



	/**
	 * Return the value associated with the column: pharma_index_id
	 */
	public jkt.hms.masters.business.MasStorePharmaIndex getPharmaIndex () {
		return pharmaIndex;
	}

	/**
	 * Set the value related to the column: pharma_index_id
	 * @param pharmaIndex the pharma_index_id value
	 */
	public void setPharmaIndex (jkt.hms.masters.business.MasStorePharmaIndex pharmaIndex) {
		this.pharmaIndex = pharmaIndex;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: MasStoreItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItem> getMasStoreItems () {
		return masStoreItems;
	}

	/**
	 * Set the value related to the column: MasStoreItems
	 * @param masStoreItems the MasStoreItems value
	 */
	public void setMasStoreItems (java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems) {
		this.masStoreItems = masStoreItems;
	}

	public void addToMasStoreItems (jkt.hms.masters.business.MasStoreItem masStoreItem) {
		if (null == getMasStoreItems()) setMasStoreItems(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItem>());
		getMasStoreItems().add(masStoreItem);
	}



	/**
	 * Return the value associated with the column: MasStoreBrands
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreBrand> getMasStoreBrands () {
		return masStoreBrands;
	}

	/**
	 * Set the value related to the column: MasStoreBrands
	 * @param masStoreBrands the MasStoreBrands value
	 */
	public void setMasStoreBrands (java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands) {
		this.masStoreBrands = masStoreBrands;
	}

	public void addToMasStoreBrands (jkt.hms.masters.business.MasStoreBrand masStoreBrand) {
		if (null == getMasStoreBrands()) setMasStoreBrands(new java.util.TreeSet<jkt.hms.masters.business.MasStoreBrand>());
		getMasStoreBrands().add(masStoreBrand);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreItemGeneric)) return false;
		else {
			jkt.hms.masters.business.MasStoreItemGeneric masStoreItemGeneric = (jkt.hms.masters.business.MasStoreItemGeneric) obj;
			if (null == this.getId() || null == masStoreItemGeneric.getId()) return false;
			else return (this.getId().equals(masStoreItemGeneric.getId()));
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