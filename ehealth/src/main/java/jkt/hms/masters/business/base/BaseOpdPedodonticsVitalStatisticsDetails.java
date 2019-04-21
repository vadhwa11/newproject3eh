package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_pedodontics_vital_statistics_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_pedodontics_vital_statistics_details"
 */

public abstract class BaseOpdPedodonticsVitalStatisticsDetails  implements Serializable {

	public static String REF = "OpdPedodonticsVitalStatisticsDetails";
	public static String PROP_BREAKFAST_PREPARATION = "BreakfastPreparation";
	public static String PROP_PEDODONTICS_VITAL_STATISTICS_HEADER = "PedodonticsVitalStatisticsHeader";
	public static String PROP_BEFORE_BED_QUANTITY = "BeforeBedQuantity";
	public static String PROP_DINNER_TYPE_QUANTITY = "DinnerTypeQuantity";
	public static String PROP_LUNCH_PREPARATION = "LunchPreparation";
	public static String PROP_BEFORE_BED_PREPARATION = "BeforeBedPreparation";
	public static String PROP_SNACKS_TYPE_QUANTITY_ONE = "SnacksTypeQuantityOne";
	public static String PROP_LUNCH_TYPE_QUANTITY = "LunchTypeQuantity";
	public static String PROP_ID = "Id";
	public static String PROP_BREAKFAST_TYPE_QUANTITY = "BreakfastTypeQuantity";
	public static String PROP_DINNER_PREPARATION = "DinnerPreparation";
	public static String PROP_SNACKS_PREPARATION = "SnacksPreparation";
	public static String PROP_SNACKS_TYPE_QUANTITY = "SnacksTypeQuantity";
	public static String PROP_SNACKS_PREPARATION_ONE = "SnacksPreparationOne";


	// constructors
	public BaseOpdPedodonticsVitalStatisticsDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPedodonticsVitalStatisticsDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String breakfastTypeQuantity;
	private java.lang.String breakfastPreparation;
	private java.lang.String snacksTypeQuantity;
	private java.lang.String snacksPreparation;
	private java.lang.String lunchTypeQuantity;
	private java.lang.String lunchPreparation;
	private java.lang.String snacksTypeQuantityOne;
	private java.lang.String snacksPreparationOne;
	private java.lang.String dinnerTypeQuantity;
	private java.lang.String dinnerPreparation;
	private java.lang.String beforeBedQuantity;
	private java.lang.String beforeBedPreparation;

	// many to one
	private jkt.hms.masters.business.OpdPedodonticsVitalStatisticsHeader pedodonticsVitalStatisticsHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="pedodontics_vital_statistics_details_id"
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
	 * Return the value associated with the column: breakfast_type_quantity
	 */
	public java.lang.String getBreakfastTypeQuantity () {
		return breakfastTypeQuantity;
	}

	/**
	 * Set the value related to the column: breakfast_type_quantity
	 * @param breakfastTypeQuantity the breakfast_type_quantity value
	 */
	public void setBreakfastTypeQuantity (java.lang.String breakfastTypeQuantity) {
		this.breakfastTypeQuantity = breakfastTypeQuantity;
	}



	/**
	 * Return the value associated with the column: breakfast_preparation
	 */
	public java.lang.String getBreakfastPreparation () {
		return breakfastPreparation;
	}

	/**
	 * Set the value related to the column: breakfast_preparation
	 * @param breakfastPreparation the breakfast_preparation value
	 */
	public void setBreakfastPreparation (java.lang.String breakfastPreparation) {
		this.breakfastPreparation = breakfastPreparation;
	}



	/**
	 * Return the value associated with the column: snacks_type_quantity
	 */
	public java.lang.String getSnacksTypeQuantity () {
		return snacksTypeQuantity;
	}

	/**
	 * Set the value related to the column: snacks_type_quantity
	 * @param snacksTypeQuantity the snacks_type_quantity value
	 */
	public void setSnacksTypeQuantity (java.lang.String snacksTypeQuantity) {
		this.snacksTypeQuantity = snacksTypeQuantity;
	}



	/**
	 * Return the value associated with the column: snacks_preparation
	 */
	public java.lang.String getSnacksPreparation () {
		return snacksPreparation;
	}

	/**
	 * Set the value related to the column: snacks_preparation
	 * @param snacksPreparation the snacks_preparation value
	 */
	public void setSnacksPreparation (java.lang.String snacksPreparation) {
		this.snacksPreparation = snacksPreparation;
	}



	/**
	 * Return the value associated with the column: lunch_type_quantity
	 */
	public java.lang.String getLunchTypeQuantity () {
		return lunchTypeQuantity;
	}

	/**
	 * Set the value related to the column: lunch_type_quantity
	 * @param lunchTypeQuantity the lunch_type_quantity value
	 */
	public void setLunchTypeQuantity (java.lang.String lunchTypeQuantity) {
		this.lunchTypeQuantity = lunchTypeQuantity;
	}



	/**
	 * Return the value associated with the column: lunch_preparation
	 */
	public java.lang.String getLunchPreparation () {
		return lunchPreparation;
	}

	/**
	 * Set the value related to the column: lunch_preparation
	 * @param lunchPreparation the lunch_preparation value
	 */
	public void setLunchPreparation (java.lang.String lunchPreparation) {
		this.lunchPreparation = lunchPreparation;
	}



	/**
	 * Return the value associated with the column: snacks_type_quantity_one
	 */
	public java.lang.String getSnacksTypeQuantityOne () {
		return snacksTypeQuantityOne;
	}

	/**
	 * Set the value related to the column: snacks_type_quantity_one
	 * @param snacksTypeQuantityOne the snacks_type_quantity_one value
	 */
	public void setSnacksTypeQuantityOne (java.lang.String snacksTypeQuantityOne) {
		this.snacksTypeQuantityOne = snacksTypeQuantityOne;
	}



	/**
	 * Return the value associated with the column: snacks_preparation_one
	 */
	public java.lang.String getSnacksPreparationOne () {
		return snacksPreparationOne;
	}

	/**
	 * Set the value related to the column: snacks_preparation_one
	 * @param snacksPreparationOne the snacks_preparation_one value
	 */
	public void setSnacksPreparationOne (java.lang.String snacksPreparationOne) {
		this.snacksPreparationOne = snacksPreparationOne;
	}



	/**
	 * Return the value associated with the column: dinner_type_quantity
	 */
	public java.lang.String getDinnerTypeQuantity () {
		return dinnerTypeQuantity;
	}

	/**
	 * Set the value related to the column: dinner_type_quantity
	 * @param dinnerTypeQuantity the dinner_type_quantity value
	 */
	public void setDinnerTypeQuantity (java.lang.String dinnerTypeQuantity) {
		this.dinnerTypeQuantity = dinnerTypeQuantity;
	}



	/**
	 * Return the value associated with the column: dinner_preparation
	 */
	public java.lang.String getDinnerPreparation () {
		return dinnerPreparation;
	}

	/**
	 * Set the value related to the column: dinner_preparation
	 * @param dinnerPreparation the dinner_preparation value
	 */
	public void setDinnerPreparation (java.lang.String dinnerPreparation) {
		this.dinnerPreparation = dinnerPreparation;
	}



	/**
	 * Return the value associated with the column: before_bed_quantity
	 */
	public java.lang.String getBeforeBedQuantity () {
		return beforeBedQuantity;
	}

	/**
	 * Set the value related to the column: before_bed_quantity
	 * @param beforeBedQuantity the before_bed_quantity value
	 */
	public void setBeforeBedQuantity (java.lang.String beforeBedQuantity) {
		this.beforeBedQuantity = beforeBedQuantity;
	}



	/**
	 * Return the value associated with the column: before_bed_preparation
	 */
	public java.lang.String getBeforeBedPreparation () {
		return beforeBedPreparation;
	}

	/**
	 * Set the value related to the column: before_bed_preparation
	 * @param beforeBedPreparation the before_bed_preparation value
	 */
	public void setBeforeBedPreparation (java.lang.String beforeBedPreparation) {
		this.beforeBedPreparation = beforeBedPreparation;
	}



	/**
	 * Return the value associated with the column: pedodontics_vital_statistics_header_id
	 */
	public jkt.hms.masters.business.OpdPedodonticsVitalStatisticsHeader getPedodonticsVitalStatisticsHeader () {
		return pedodonticsVitalStatisticsHeader;
	}

	/**
	 * Set the value related to the column: pedodontics_vital_statistics_header_id
	 * @param pedodonticsVitalStatisticsHeader the pedodontics_vital_statistics_header_id value
	 */
	public void setPedodonticsVitalStatisticsHeader (jkt.hms.masters.business.OpdPedodonticsVitalStatisticsHeader pedodonticsVitalStatisticsHeader) {
		this.pedodonticsVitalStatisticsHeader = pedodonticsVitalStatisticsHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPedodonticsVitalStatisticsDetails)) return false;
		else {
			jkt.hms.masters.business.OpdPedodonticsVitalStatisticsDetails opdPedodonticsVitalStatisticsDetails = (jkt.hms.masters.business.OpdPedodonticsVitalStatisticsDetails) obj;
			if (null == this.getId() || null == opdPedodonticsVitalStatisticsDetails.getId()) return false;
			else return (this.getId().equals(opdPedodonticsVitalStatisticsDetails.getId()));
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