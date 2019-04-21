package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_antenatal_card_pregnancy table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_antenatal_card_pregnancy"
 */

public abstract class BaseOpdAntenatalCardPregnancy  implements Serializable {

	public static String REF = "OpdAntenatalCardPregnancy";
	public static String PROP_AGE = "Age";
	public static String PROP_PREGNANCY_OUTCOME_PRE_TERM_VALUE = "PregnancyOutcomePreTermValue";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NO_OF_PREGNANCY = "NoOfPregnancy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VISIT = "Visit";
	public static String PROP_YEAR = "Year";
	public static String PROP_INTRA_PARTUM = "IntraPartum";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PREGNANCY_OUTCOME = "PregnancyOutcome";
	public static String PROP_ANTENATAL = "Antenatal";
	public static String PROP_OPD_ANTENATAL_CARD = "OpdAntenatalCard";
	public static String PROP_BIRTH_WEIGHT = "BirthWeight";
	public static String PROP_PLACE_DELIVERY = "PlaceDelivery";
	public static String PROP_ID = "Id";
	public static String PROP_POST_PARTUM = "PostPartum";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_PLACE_OF_DELIVERY_OTHERS_VALUE = "PlaceOfDeliveryOthersValue";
	public static String PROP_DELIVERY_OUTCOME = "DeliveryOutcome";
	public static String PROP_PREVIOUS_GESTATIONAL_AGE = "PreviousGestationalAge";
	public static String PROP_BLOOD_TRANSFUSION = "BloodTransfusion";
	public static String PROP_SEX = "Sex";


	// constructors
	public BaseOpdAntenatalCardPregnancy () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdAntenatalCardPregnancy (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String year;
	private java.lang.Integer age;
	private java.lang.String pregnancyOutcome;
	private java.lang.String placeDelivery;
	private java.lang.String deliveryOutcome;
	private java.lang.String sex;
	private java.lang.Double birthWeight;
	private java.lang.String antenatal;
	private java.lang.String intraPartum;
	private java.lang.String postPartum;
	private java.lang.String bloodTransfusion;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String placeOfDeliveryOthersValue;
	private java.lang.String pregnancyOutcomePreTermValue;
	private int noOfPregnancy;
	private java.lang.String remarks;
	private java.lang.String previousGestationalAge;

	// many to one
	private jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_antenatal_card_pregnancy_id"
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
	 * Return the value associated with the column: place_delivery
	 */
	public java.lang.String getPlaceDelivery () {
		return placeDelivery;
	}

	/**
	 * Set the value related to the column: place_delivery
	 * @param placeDelivery the place_delivery value
	 */
	public void setPlaceDelivery (java.lang.String placeDelivery) {
		this.placeDelivery = placeDelivery;
	}



	/**
	 * Return the value associated with the column: delivery_outcome
	 */
	public java.lang.String getDeliveryOutcome () {
		return deliveryOutcome;
	}

	/**
	 * Set the value related to the column: delivery_outcome
	 * @param deliveryOutcome the delivery_outcome value
	 */
	public void setDeliveryOutcome (java.lang.String deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
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
	public java.lang.Double getBirthWeight () {
		return birthWeight;
	}

	/**
	 * Set the value related to the column: birth_weight
	 * @param birthWeight the birth_weight value
	 */
	public void setBirthWeight (java.lang.Double birthWeight) {
		this.birthWeight = birthWeight;
	}



	/**
	 * Return the value associated with the column: antenatal
	 */
	public java.lang.String getAntenatal () {
		return antenatal;
	}

	/**
	 * Set the value related to the column: antenatal
	 * @param antenatal the antenatal value
	 */
	public void setAntenatal (java.lang.String antenatal) {
		this.antenatal = antenatal;
	}



	/**
	 * Return the value associated with the column: intra_partum
	 */
	public java.lang.String getIntraPartum () {
		return intraPartum;
	}

	/**
	 * Set the value related to the column: intra_partum
	 * @param intraPartum the intra_partum value
	 */
	public void setIntraPartum (java.lang.String intraPartum) {
		this.intraPartum = intraPartum;
	}



	/**
	 * Return the value associated with the column: post_partum
	 */
	public java.lang.String getPostPartum () {
		return postPartum;
	}

	/**
	 * Set the value related to the column: post_partum
	 * @param postPartum the post_partum value
	 */
	public void setPostPartum (java.lang.String postPartum) {
		this.postPartum = postPartum;
	}



	/**
	 * Return the value associated with the column: blood_transfusion
	 */
	public java.lang.String getBloodTransfusion () {
		return bloodTransfusion;
	}

	/**
	 * Set the value related to the column: blood_transfusion
	 * @param bloodTransfusion the blood_transfusion value
	 */
	public void setBloodTransfusion (java.lang.String bloodTransfusion) {
		this.bloodTransfusion = bloodTransfusion;
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
	 * Return the value associated with the column: place_of_delivery_others_value
	 */
	public java.lang.String getPlaceOfDeliveryOthersValue () {
		return placeOfDeliveryOthersValue;
	}

	/**
	 * Set the value related to the column: place_of_delivery_others_value
	 * @param placeOfDeliveryOthersValue the place_of_delivery_others_value value
	 */
	public void setPlaceOfDeliveryOthersValue (java.lang.String placeOfDeliveryOthersValue) {
		this.placeOfDeliveryOthersValue = placeOfDeliveryOthersValue;
	}



	/**
	 * Return the value associated with the column: pregnancy_outcome_pre_term_value
	 */
	public java.lang.String getPregnancyOutcomePreTermValue () {
		return pregnancyOutcomePreTermValue;
	}

	/**
	 * Set the value related to the column: pregnancy_outcome_pre_term_value
	 * @param pregnancyOutcomePreTermValue the pregnancy_outcome_pre_term_value value
	 */
	public void setPregnancyOutcomePreTermValue (java.lang.String pregnancyOutcomePreTermValue) {
		this.pregnancyOutcomePreTermValue = pregnancyOutcomePreTermValue;
	}



	/**
	 * Return the value associated with the column: no_of_pregnancy
	 */
	public int getNoOfPregnancy () {
		return noOfPregnancy;
	}

	/**
	 * Set the value related to the column: no_of_pregnancy
	 * @param noOfPregnancy the no_of_pregnancy value
	 */
	public void setNoOfPregnancy (int noOfPregnancy) {
		this.noOfPregnancy = noOfPregnancy;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: previous_gestational_age
	 */
	public java.lang.String getPreviousGestationalAge () {
		return previousGestationalAge;
	}

	/**
	 * Set the value related to the column: previous_gestational_age
	 * @param previousGestationalAge the previous_gestational_age value
	 */
	public void setPreviousGestationalAge (java.lang.String previousGestationalAge) {
		this.previousGestationalAge = previousGestationalAge;
	}



	/**
	 * Return the value associated with the column: opd_antenatal_card_id
	 */
	public jkt.hms.masters.business.OpdAntenatalCard getOpdAntenatalCard () {
		return opdAntenatalCard;
	}

	/**
	 * Set the value related to the column: opd_antenatal_card_id
	 * @param opdAntenatalCard the opd_antenatal_card_id value
	 */
	public void setOpdAntenatalCard (jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard) {
		this.opdAntenatalCard = opdAntenatalCard;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdAntenatalCardPregnancy)) return false;
		else {
			jkt.hms.masters.business.OpdAntenatalCardPregnancy opdAntenatalCardPregnancy = (jkt.hms.masters.business.OpdAntenatalCardPregnancy) obj;
			if (null == this.getId() || null == opdAntenatalCardPregnancy.getId()) return false;
			else return (this.getId().equals(opdAntenatalCardPregnancy.getId()));
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