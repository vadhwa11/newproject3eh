package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_community_oral_health_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_community_oral_health_detail"
 */

public abstract class BaseOpdCommunityOralHealthDetail  implements Serializable {

	public static String REF = "OpdCommunityOralHealthDetail";
	public static String PROP_FORM_OF_FOOD = "FormOfFood";
	public static String PROP_TIME_OF_INTAKE = "TimeOfIntake";
	public static String PROP_TYPE_OF_FOOD = "TypeOfFood";
	public static String PROP_COMMUNITY_ORAL_HEALTH_HEADER = "CommunityOralHealthHeader";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_POINTS = "Points";
	public static String PROP_QUANTITY_SUGAR_EXPOSURE = "QuantitySugarExposure";


	// constructors
	public BaseOpdCommunityOralHealthDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdCommunityOralHealthDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String formOfFood;
	private java.lang.String typeOfFood;
	private java.lang.String timeOfIntake;
	private java.lang.String quantitySugarExposure;
	private java.lang.String frequency;
	private java.lang.String points;

	// many to one
	private jkt.hms.masters.business.OpdCommunityOralHealthHeader communityOralHealthHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="community_oral_health_detail_id"
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
	 * Return the value associated with the column: form_of_food
	 */
	public java.lang.String getFormOfFood () {
		return formOfFood;
	}

	/**
	 * Set the value related to the column: form_of_food
	 * @param formOfFood the form_of_food value
	 */
	public void setFormOfFood (java.lang.String formOfFood) {
		this.formOfFood = formOfFood;
	}



	/**
	 * Return the value associated with the column: type_of_food
	 */
	public java.lang.String getTypeOfFood () {
		return typeOfFood;
	}

	/**
	 * Set the value related to the column: type_of_food
	 * @param typeOfFood the type_of_food value
	 */
	public void setTypeOfFood (java.lang.String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}



	/**
	 * Return the value associated with the column: time_of_intake
	 */
	public java.lang.String getTimeOfIntake () {
		return timeOfIntake;
	}

	/**
	 * Set the value related to the column: time_of_intake
	 * @param timeOfIntake the time_of_intake value
	 */
	public void setTimeOfIntake (java.lang.String timeOfIntake) {
		this.timeOfIntake = timeOfIntake;
	}



	/**
	 * Return the value associated with the column: quantity_sugar_exposure
	 */
	public java.lang.String getQuantitySugarExposure () {
		return quantitySugarExposure;
	}

	/**
	 * Set the value related to the column: quantity_sugar_exposure
	 * @param quantitySugarExposure the quantity_sugar_exposure value
	 */
	public void setQuantitySugarExposure (java.lang.String quantitySugarExposure) {
		this.quantitySugarExposure = quantitySugarExposure;
	}



	/**
	 * Return the value associated with the column: frequency
	 */
	public java.lang.String getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency
	 * @param frequency the frequency value
	 */
	public void setFrequency (java.lang.String frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: points
	 */
	public java.lang.String getPoints () {
		return points;
	}

	/**
	 * Set the value related to the column: points
	 * @param points the points value
	 */
	public void setPoints (java.lang.String points) {
		this.points = points;
	}



	/**
	 * Return the value associated with the column: community_oral_health_header_id
	 */
	public jkt.hms.masters.business.OpdCommunityOralHealthHeader getCommunityOralHealthHeader () {
		return communityOralHealthHeader;
	}

	/**
	 * Set the value related to the column: community_oral_health_header_id
	 * @param communityOralHealthHeader the community_oral_health_header_id value
	 */
	public void setCommunityOralHealthHeader (jkt.hms.masters.business.OpdCommunityOralHealthHeader communityOralHealthHeader) {
		this.communityOralHealthHeader = communityOralHealthHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdCommunityOralHealthDetail)) return false;
		else {
			jkt.hms.masters.business.OpdCommunityOralHealthDetail opdCommunityOralHealthDetail = (jkt.hms.masters.business.OpdCommunityOralHealthDetail) obj;
			if (null == this.getId() || null == opdCommunityOralHealthDetail.getId()) return false;
			else return (this.getId().equals(opdCommunityOralHealthDetail.getId()));
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