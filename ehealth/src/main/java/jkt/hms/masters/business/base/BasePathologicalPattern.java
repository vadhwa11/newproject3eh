package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pathological_pattern table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pathological_pattern"
 */

public abstract class BasePathologicalPattern  implements Serializable {

	public static String REF = "PathologicalPattern";
	public static String PROP_PSYCOLOGICAL_PATHOLOGICAL_PATTERN = "PsycologicalPathologicalPattern";
	public static String PROP_TOLERANCE_PATHOLOGICAL_PATTERN = "TolerancePathologicalPattern";
	public static String PROP_TOTAL_SOURCE = "TotalSource";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PHYSICALLY_HAZARDOUS_PATHOLOGICAL_PATTERN = "PhysicallyHazardousPathologicalPattern";
	public static String PROP_DESIRE_PATHOLOGICAL_PATTERN = "DesirePathologicalPattern";
	public static String PROP_RECURRENT_PATHOLOGICAL_PATTERN = "RecurrentPathologicalPattern";
	public static String PROP_VISIT = "Visit";
	public static String PROP_WITHDRAWAL_PATHOLOGICAL_PATTERN = "WithdrawalPathologicalPattern";
	public static String PROP_ALCOHOL_PATHOLIGICAL_PATTERN = "AlcoholPatholigicalPattern";
	public static String PROP_PERSISTENT_PATHOLOGICAL_PATTERN = "PersistentPathologicalPattern";
	public static String PROP_CONTINUED_ALCOHOL_USE = "ContinuedAlcoholUse";
	public static String PROP_WHAT_ABOUT = "WhatAbout";
	public static String PROP_DRINKING_PATHOLOGICAL_PATTERN = "DrinkingPathologicalPattern";
	public static String PROP_ACTIVITIES_PATHOLOGICAL_PATTERN = "ActivitiesPathologicalPattern";
	public static String PROP_ID = "Id";
	public static String PROP_DID_YOU = "DidYou";


	// constructors
	public BasePathologicalPattern () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePathologicalPattern (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String alcoholPatholigicalPattern;
	private java.lang.String persistentPathologicalPattern;
	private java.lang.String drinkingPathologicalPattern;
	private java.lang.String desirePathologicalPattern;
	private java.lang.String recurrentPathologicalPattern;
	private java.lang.String continuedAlcoholUse;
	private java.lang.String activitiesPathologicalPattern;
	private java.lang.String physicallyHazardousPathologicalPattern;
	private java.lang.String psycologicalPathologicalPattern;
	private java.lang.String tolerancePathologicalPattern;
	private java.lang.String withdrawalPathologicalPattern;
	private java.lang.Integer totalSource;
	private java.lang.String didYou;
	private java.lang.String whatAbout;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="pathological_pattern_id"
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
	 * Return the value associated with the column: alcohol_patholigical_pattern
	 */
	public java.lang.String getAlcoholPatholigicalPattern () {
		return alcoholPatholigicalPattern;
	}

	/**
	 * Set the value related to the column: alcohol_patholigical_pattern
	 * @param alcoholPatholigicalPattern the alcohol_patholigical_pattern value
	 */
	public void setAlcoholPatholigicalPattern (java.lang.String alcoholPatholigicalPattern) {
		this.alcoholPatholigicalPattern = alcoholPatholigicalPattern;
	}



	/**
	 * Return the value associated with the column: persistent_pathological_pattern
	 */
	public java.lang.String getPersistentPathologicalPattern () {
		return persistentPathologicalPattern;
	}

	/**
	 * Set the value related to the column: persistent_pathological_pattern
	 * @param persistentPathologicalPattern the persistent_pathological_pattern value
	 */
	public void setPersistentPathologicalPattern (java.lang.String persistentPathologicalPattern) {
		this.persistentPathologicalPattern = persistentPathologicalPattern;
	}



	/**
	 * Return the value associated with the column: drinking_pathological_pattern
	 */
	public java.lang.String getDrinkingPathologicalPattern () {
		return drinkingPathologicalPattern;
	}

	/**
	 * Set the value related to the column: drinking_pathological_pattern
	 * @param drinkingPathologicalPattern the drinking_pathological_pattern value
	 */
	public void setDrinkingPathologicalPattern (java.lang.String drinkingPathologicalPattern) {
		this.drinkingPathologicalPattern = drinkingPathologicalPattern;
	}



	/**
	 * Return the value associated with the column: desire_pathological_pattern
	 */
	public java.lang.String getDesirePathologicalPattern () {
		return desirePathologicalPattern;
	}

	/**
	 * Set the value related to the column: desire_pathological_pattern
	 * @param desirePathologicalPattern the desire_pathological_pattern value
	 */
	public void setDesirePathologicalPattern (java.lang.String desirePathologicalPattern) {
		this.desirePathologicalPattern = desirePathologicalPattern;
	}



	/**
	 * Return the value associated with the column: recurrent_pathological_pattern
	 */
	public java.lang.String getRecurrentPathologicalPattern () {
		return recurrentPathologicalPattern;
	}

	/**
	 * Set the value related to the column: recurrent_pathological_pattern
	 * @param recurrentPathologicalPattern the recurrent_pathological_pattern value
	 */
	public void setRecurrentPathologicalPattern (java.lang.String recurrentPathologicalPattern) {
		this.recurrentPathologicalPattern = recurrentPathologicalPattern;
	}



	/**
	 * Return the value associated with the column: continued_alcohol_use
	 */
	public java.lang.String getContinuedAlcoholUse () {
		return continuedAlcoholUse;
	}

	/**
	 * Set the value related to the column: continued_alcohol_use
	 * @param continuedAlcoholUse the continued_alcohol_use value
	 */
	public void setContinuedAlcoholUse (java.lang.String continuedAlcoholUse) {
		this.continuedAlcoholUse = continuedAlcoholUse;
	}



	/**
	 * Return the value associated with the column: activities_pathological_pattern
	 */
	public java.lang.String getActivitiesPathologicalPattern () {
		return activitiesPathologicalPattern;
	}

	/**
	 * Set the value related to the column: activities_pathological_pattern
	 * @param activitiesPathologicalPattern the activities_pathological_pattern value
	 */
	public void setActivitiesPathologicalPattern (java.lang.String activitiesPathologicalPattern) {
		this.activitiesPathologicalPattern = activitiesPathologicalPattern;
	}



	/**
	 * Return the value associated with the column: physically_hazardous_pathological_pattern
	 */
	public java.lang.String getPhysicallyHazardousPathologicalPattern () {
		return physicallyHazardousPathologicalPattern;
	}

	/**
	 * Set the value related to the column: physically_hazardous_pathological_pattern
	 * @param physicallyHazardousPathologicalPattern the physically_hazardous_pathological_pattern value
	 */
	public void setPhysicallyHazardousPathologicalPattern (java.lang.String physicallyHazardousPathologicalPattern) {
		this.physicallyHazardousPathologicalPattern = physicallyHazardousPathologicalPattern;
	}



	/**
	 * Return the value associated with the column: psycological_pathological_pattern
	 */
	public java.lang.String getPsycologicalPathologicalPattern () {
		return psycologicalPathologicalPattern;
	}

	/**
	 * Set the value related to the column: psycological_pathological_pattern
	 * @param psycologicalPathologicalPattern the psycological_pathological_pattern value
	 */
	public void setPsycologicalPathologicalPattern (java.lang.String psycologicalPathologicalPattern) {
		this.psycologicalPathologicalPattern = psycologicalPathologicalPattern;
	}



	/**
	 * Return the value associated with the column: tolerance_pathological_pattern
	 */
	public java.lang.String getTolerancePathologicalPattern () {
		return tolerancePathologicalPattern;
	}

	/**
	 * Set the value related to the column: tolerance_pathological_pattern
	 * @param tolerancePathologicalPattern the tolerance_pathological_pattern value
	 */
	public void setTolerancePathologicalPattern (java.lang.String tolerancePathologicalPattern) {
		this.tolerancePathologicalPattern = tolerancePathologicalPattern;
	}



	/**
	 * Return the value associated with the column: withdrawal_pathological_pattern
	 */
	public java.lang.String getWithdrawalPathologicalPattern () {
		return withdrawalPathologicalPattern;
	}

	/**
	 * Set the value related to the column: withdrawal_pathological_pattern
	 * @param withdrawalPathologicalPattern the withdrawal_pathological_pattern value
	 */
	public void setWithdrawalPathologicalPattern (java.lang.String withdrawalPathologicalPattern) {
		this.withdrawalPathologicalPattern = withdrawalPathologicalPattern;
	}



	/**
	 * Return the value associated with the column: total_source
	 */
	public java.lang.Integer getTotalSource () {
		return totalSource;
	}

	/**
	 * Set the value related to the column: total_source
	 * @param totalSource the total_source value
	 */
	public void setTotalSource (java.lang.Integer totalSource) {
		this.totalSource = totalSource;
	}



	/**
	 * Return the value associated with the column: did_you
	 */
	public java.lang.String getDidYou () {
		return didYou;
	}

	/**
	 * Set the value related to the column: did_you
	 * @param didYou the did_you value
	 */
	public void setDidYou (java.lang.String didYou) {
		this.didYou = didYou;
	}



	/**
	 * Return the value associated with the column: what_about
	 */
	public java.lang.String getWhatAbout () {
		return whatAbout;
	}

	/**
	 * Set the value related to the column: what_about
	 * @param whatAbout the what_about value
	 */
	public void setWhatAbout (java.lang.String whatAbout) {
		this.whatAbout = whatAbout;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PathologicalPattern)) return false;
		else {
			jkt.hms.masters.business.PathologicalPattern pathologicalPattern = (jkt.hms.masters.business.PathologicalPattern) obj;
			if (null == this.getId() || null == pathologicalPattern.getId()) return false;
			else return (this.getId().equals(pathologicalPattern.getId()));
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