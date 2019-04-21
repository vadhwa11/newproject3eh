package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the child_expected_wt_ht_chart table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="child_expected_wt_ht_chart"
 */

public abstract class BaseChildExpectedWtHtChart  implements Serializable {

	public static String REF = "ChildExpectedWtHtChart";
	public static String PROP_CHILD_HEIGHT = "ChildHeight";
	public static String PROP_CHILD_WEIGHT = "ChildWeight";
	public static String PROP_ID = "Id";
	public static String PROP_CHILD_AGE_IN_DAYS = "ChildAgeInDays";
	public static String PROP_CHILD_GENDER = "ChildGender";


	// constructors
	public BaseChildExpectedWtHtChart () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseChildExpectedWtHtChart (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.Integer childAgeInDays;
	private java.math.BigDecimal childHeight;
	private java.math.BigDecimal childWeight;

	// many to one
	private jkt.hms.masters.business.MasAdministrativeSex childGender;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: child_age_in_days
	 */
	public java.lang.Integer getChildAgeInDays () {
		return childAgeInDays;
	}

	/**
	 * Set the value related to the column: child_age_in_days
	 * @param childAgeInDays the child_age_in_days value
	 */
	public void setChildAgeInDays (java.lang.Integer childAgeInDays) {
		this.childAgeInDays = childAgeInDays;
	}



	/**
	 * Return the value associated with the column: child_height
	 */
	public java.math.BigDecimal getChildHeight () {
		return childHeight;
	}

	/**
	 * Set the value related to the column: child_height
	 * @param childHeight the child_height value
	 */
	public void setChildHeight (java.math.BigDecimal childHeight) {
		this.childHeight = childHeight;
	}



	/**
	 * Return the value associated with the column: child_weight
	 */
	public java.math.BigDecimal getChildWeight () {
		return childWeight;
	}

	/**
	 * Set the value related to the column: child_weight
	 * @param childWeight the child_weight value
	 */
	public void setChildWeight (java.math.BigDecimal childWeight) {
		this.childWeight = childWeight;
	}



	/**
	 * Return the value associated with the column: child_gender
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getChildGender () {
		return childGender;
	}

	/**
	 * Set the value related to the column: child_gender
	 * @param childGender the child_gender value
	 */
	public void setChildGender (jkt.hms.masters.business.MasAdministrativeSex childGender) {
		this.childGender = childGender;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ChildExpectedWtHtChart)) return false;
		else {
			jkt.hms.masters.business.ChildExpectedWtHtChart childExpectedWtHtChart = (jkt.hms.masters.business.ChildExpectedWtHtChart) obj;
			if (null == this.getId() || null == childExpectedWtHtChart.getId()) return false;
			else return (this.getId().equals(childExpectedWtHtChart.getId()));
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