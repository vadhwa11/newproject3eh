package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_class_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_class_details"
 */

public abstract class BasePhClassDetails  implements Serializable {

	public static String REF = "PhClassDetails";
	public static String PROP_SURVEY = "Survey";
	public static String PROP_SCHOOL_SECTION = "SchoolSection";
	public static String PROP_SCHOOL_CLASS = "SchoolClass";
	public static String PROP_ID = "Id";


	// constructors
	public BasePhClassDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhClassDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String schoolClass;
	private java.lang.String schoolSection;

	// many to one
	private jkt.hms.masters.business.PhVillageSurvey survey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="class_details"
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
	 * Return the value associated with the column: school_class
	 */
	public java.lang.String getSchoolClass () {
		return schoolClass;
	}

	/**
	 * Set the value related to the column: school_class
	 * @param schoolClass the school_class value
	 */
	public void setSchoolClass (java.lang.String schoolClass) {
		this.schoolClass = schoolClass;
	}



	/**
	 * Return the value associated with the column: school_section
	 */
	public java.lang.String getSchoolSection () {
		return schoolSection;
	}

	/**
	 * Set the value related to the column: school_section
	 * @param schoolSection the school_section value
	 */
	public void setSchoolSection (java.lang.String schoolSection) {
		this.schoolSection = schoolSection;
	}



	/**
	 * Return the value associated with the column: survey_id
	 */
	public jkt.hms.masters.business.PhVillageSurvey getSurvey () {
		return survey;
	}

	/**
	 * Set the value related to the column: survey_id
	 * @param survey the survey_id value
	 */
	public void setSurvey (jkt.hms.masters.business.PhVillageSurvey survey) {
		this.survey = survey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhClassDetails)) return false;
		else {
			jkt.hms.masters.business.PhClassDetails phClassDetails = (jkt.hms.masters.business.PhClassDetails) obj;
			if (null == this.getId() || null == phClassDetails.getId()) return false;
			else return (this.getId().equals(phClassDetails.getId()));
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