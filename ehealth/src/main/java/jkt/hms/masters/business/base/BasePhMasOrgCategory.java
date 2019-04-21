package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_mas_org_category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_mas_org_category"
 */

public abstract class BasePhMasOrgCategory  implements Serializable {

	public static String REF = "PhMasOrgCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY_CODE = "CategoryCode";
	public static String PROP_CATEGORY_NAME = "CategoryName";
	public static String PROP_TYPE = "Type";
	public static String PROP_ID = "Id";


	// constructors
	public BasePhMasOrgCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhMasOrgCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String type;
	private java.lang.String categoryCode;
	private java.lang.String categoryName;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveiesBySurveyType;
	private java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveiesByCategoryCode;
	private java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveiesByTypeCode;
	private java.util.Set<jkt.hms.masters.business.PhHouseSurvey> phHouseSurveies;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="category_id"
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
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: category_code
	 */
	public java.lang.String getCategoryCode () {
		return categoryCode;
	}

	/**
	 * Set the value related to the column: category_code
	 * @param categoryCode the category_code value
	 */
	public void setCategoryCode (java.lang.String categoryCode) {
		this.categoryCode = categoryCode;
	}



	/**
	 * Return the value associated with the column: category_name
	 */
	public java.lang.String getCategoryName () {
		return categoryName;
	}

	/**
	 * Set the value related to the column: category_name
	 * @param categoryName the category_name value
	 */
	public void setCategoryName (java.lang.String categoryName) {
		this.categoryName = categoryName;
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
	 * Return the value associated with the column: PhVillageSurveiesBySurveyType
	 */
	public java.util.Set<jkt.hms.masters.business.PhVillageSurvey> getPhVillageSurveiesBySurveyType () {
		return phVillageSurveiesBySurveyType;
	}

	/**
	 * Set the value related to the column: PhVillageSurveiesBySurveyType
	 * @param phVillageSurveiesBySurveyType the PhVillageSurveiesBySurveyType value
	 */
	public void setPhVillageSurveiesBySurveyType (java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveiesBySurveyType) {
		this.phVillageSurveiesBySurveyType = phVillageSurveiesBySurveyType;
	}



	/**
	 * Return the value associated with the column: PhVillageSurveiesByCategoryCode
	 */
	public java.util.Set<jkt.hms.masters.business.PhVillageSurvey> getPhVillageSurveiesByCategoryCode () {
		return phVillageSurveiesByCategoryCode;
	}

	/**
	 * Set the value related to the column: PhVillageSurveiesByCategoryCode
	 * @param phVillageSurveiesByCategoryCode the PhVillageSurveiesByCategoryCode value
	 */
	public void setPhVillageSurveiesByCategoryCode (java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveiesByCategoryCode) {
		this.phVillageSurveiesByCategoryCode = phVillageSurveiesByCategoryCode;
	}



	/**
	 * Return the value associated with the column: PhVillageSurveiesByTypeCode
	 */
	public java.util.Set<jkt.hms.masters.business.PhVillageSurvey> getPhVillageSurveiesByTypeCode () {
		return phVillageSurveiesByTypeCode;
	}

	/**
	 * Set the value related to the column: PhVillageSurveiesByTypeCode
	 * @param phVillageSurveiesByTypeCode the PhVillageSurveiesByTypeCode value
	 */
	public void setPhVillageSurveiesByTypeCode (java.util.Set<jkt.hms.masters.business.PhVillageSurvey> phVillageSurveiesByTypeCode) {
		this.phVillageSurveiesByTypeCode = phVillageSurveiesByTypeCode;
	}



	/**
	 * Return the value associated with the column: PhHouseSurveies
	 */
	public java.util.Set<jkt.hms.masters.business.PhHouseSurvey> getPhHouseSurveies () {
		return phHouseSurveies;
	}

	/**
	 * Set the value related to the column: PhHouseSurveies
	 * @param phHouseSurveies the PhHouseSurveies value
	 */
	public void setPhHouseSurveies (java.util.Set<jkt.hms.masters.business.PhHouseSurvey> phHouseSurveies) {
		this.phHouseSurveies = phHouseSurveies;
	}

	public void addToPhHouseSurveies (jkt.hms.masters.business.PhHouseSurvey phHouseSurvey) {
		if (null == getPhHouseSurveies()) setPhHouseSurveies(new java.util.TreeSet<jkt.hms.masters.business.PhHouseSurvey>());
		getPhHouseSurveies().add(phHouseSurvey);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhMasOrgCategory)) return false;
		else {
			jkt.hms.masters.business.PhMasOrgCategory phMasOrgCategory = (jkt.hms.masters.business.PhMasOrgCategory) obj;
			if (null == this.getId() || null == phMasOrgCategory.getId()) return false;
			else return (this.getId().equals(phMasOrgCategory.getId()));
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