package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_pedodontics_vital_statistics_diet_analysis table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_pedodontics_vital_statistics_diet_analysis"
 */

public abstract class BaseOpdPedodonticsVitalStatisticsDietAnalysis  implements Serializable {

	public static String REF = "OpdPedodonticsVitalStatisticsDietAnalysis";
	public static String PROP_FOOD_CONSUMPTIONS_IN_SERVING_FIVE = "FoodConsumptionsInServingFive";
	public static String PROP_PEDODONTICS_VITAL_STATISTICS_HEADER = "PedodonticsVitalStatisticsHeader";
	public static String PROP_DIFFERENCE = "Difference";
	public static String PROP_FOOD_CONSUMPTIONS_IN_SERVING_ONE = "FoodConsumptionsInServingOne";
	public static String PROP_FOOD_GROUP = "FoodGroup";
	public static String PROP_ID = "Id";
	public static String PROP_FOOD_CONSUMPTIONS_IN_SERVING_SIX = "FoodConsumptionsInServingSix";
	public static String PROP_FOOD_CONSUMPTIONS_IN_SERVING_TWO = "FoodConsumptionsInServingTwo";
	public static String PROP_TOTAL_CONSUMPTION = "TotalConsumption";
	public static String PROP_FOOD_CONSUMPTIONS_IN_SERVING_FOUR = "FoodConsumptionsInServingFour";
	public static String PROP_DAILY_RECOMMENDED_SERVINGS = "DailyRecommendedServings";
	public static String PROP_FOOD_CONSUMPTIONS_IN_SERVING_THREE = "FoodConsumptionsInServingThree";


	// constructors
	public BaseOpdPedodonticsVitalStatisticsDietAnalysis () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPedodonticsVitalStatisticsDietAnalysis (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String foodGroup;
	private java.lang.String foodConsumptionsInServingOne;
	private java.lang.String foodConsumptionsInServingTwo;
	private java.lang.String foodConsumptionsInServingThree;
	private java.lang.String foodConsumptionsInServingFour;
	private java.lang.String foodConsumptionsInServingFive;
	private java.lang.String foodConsumptionsInServingSix;
	private java.lang.String totalConsumption;
	private java.lang.String dailyRecommendedServings;
	private java.lang.String difference;

	// many to one
	private jkt.hms.masters.business.OpdPedodonticsVitalStatisticsHeader pedodonticsVitalStatisticsHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="pedodontics_vital_statistics_diet_analysis_id"
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
	 * Return the value associated with the column: food_group
	 */
	public java.lang.String getFoodGroup () {
		return foodGroup;
	}

	/**
	 * Set the value related to the column: food_group
	 * @param foodGroup the food_group value
	 */
	public void setFoodGroup (java.lang.String foodGroup) {
		this.foodGroup = foodGroup;
	}



	/**
	 * Return the value associated with the column: food_consumptions_in_serving_one
	 */
	public java.lang.String getFoodConsumptionsInServingOne () {
		return foodConsumptionsInServingOne;
	}

	/**
	 * Set the value related to the column: food_consumptions_in_serving_one
	 * @param foodConsumptionsInServingOne the food_consumptions_in_serving_one value
	 */
	public void setFoodConsumptionsInServingOne (java.lang.String foodConsumptionsInServingOne) {
		this.foodConsumptionsInServingOne = foodConsumptionsInServingOne;
	}



	/**
	 * Return the value associated with the column: food_consumptions_in_serving_two
	 */
	public java.lang.String getFoodConsumptionsInServingTwo () {
		return foodConsumptionsInServingTwo;
	}

	/**
	 * Set the value related to the column: food_consumptions_in_serving_two
	 * @param foodConsumptionsInServingTwo the food_consumptions_in_serving_two value
	 */
	public void setFoodConsumptionsInServingTwo (java.lang.String foodConsumptionsInServingTwo) {
		this.foodConsumptionsInServingTwo = foodConsumptionsInServingTwo;
	}



	/**
	 * Return the value associated with the column: food_consumptions_in_serving_three
	 */
	public java.lang.String getFoodConsumptionsInServingThree () {
		return foodConsumptionsInServingThree;
	}

	/**
	 * Set the value related to the column: food_consumptions_in_serving_three
	 * @param foodConsumptionsInServingThree the food_consumptions_in_serving_three value
	 */
	public void setFoodConsumptionsInServingThree (java.lang.String foodConsumptionsInServingThree) {
		this.foodConsumptionsInServingThree = foodConsumptionsInServingThree;
	}



	/**
	 * Return the value associated with the column: food_consumptions_in_serving_four
	 */
	public java.lang.String getFoodConsumptionsInServingFour () {
		return foodConsumptionsInServingFour;
	}

	/**
	 * Set the value related to the column: food_consumptions_in_serving_four
	 * @param foodConsumptionsInServingFour the food_consumptions_in_serving_four value
	 */
	public void setFoodConsumptionsInServingFour (java.lang.String foodConsumptionsInServingFour) {
		this.foodConsumptionsInServingFour = foodConsumptionsInServingFour;
	}



	/**
	 * Return the value associated with the column: food_consumptions_in_serving_five
	 */
	public java.lang.String getFoodConsumptionsInServingFive () {
		return foodConsumptionsInServingFive;
	}

	/**
	 * Set the value related to the column: food_consumptions_in_serving_five
	 * @param foodConsumptionsInServingFive the food_consumptions_in_serving_five value
	 */
	public void setFoodConsumptionsInServingFive (java.lang.String foodConsumptionsInServingFive) {
		this.foodConsumptionsInServingFive = foodConsumptionsInServingFive;
	}



	/**
	 * Return the value associated with the column: food_consumptions_in_serving_six
	 */
	public java.lang.String getFoodConsumptionsInServingSix () {
		return foodConsumptionsInServingSix;
	}

	/**
	 * Set the value related to the column: food_consumptions_in_serving_six
	 * @param foodConsumptionsInServingSix the food_consumptions_in_serving_six value
	 */
	public void setFoodConsumptionsInServingSix (java.lang.String foodConsumptionsInServingSix) {
		this.foodConsumptionsInServingSix = foodConsumptionsInServingSix;
	}



	/**
	 * Return the value associated with the column: total_consumption
	 */
	public java.lang.String getTotalConsumption () {
		return totalConsumption;
	}

	/**
	 * Set the value related to the column: total_consumption
	 * @param totalConsumption the total_consumption value
	 */
	public void setTotalConsumption (java.lang.String totalConsumption) {
		this.totalConsumption = totalConsumption;
	}



	/**
	 * Return the value associated with the column: daily_recommended_servings
	 */
	public java.lang.String getDailyRecommendedServings () {
		return dailyRecommendedServings;
	}

	/**
	 * Set the value related to the column: daily_recommended_servings
	 * @param dailyRecommendedServings the daily_recommended_servings value
	 */
	public void setDailyRecommendedServings (java.lang.String dailyRecommendedServings) {
		this.dailyRecommendedServings = dailyRecommendedServings;
	}



	/**
	 * Return the value associated with the column: difference
	 */
	public java.lang.String getDifference () {
		return difference;
	}

	/**
	 * Set the value related to the column: difference
	 * @param difference the difference value
	 */
	public void setDifference (java.lang.String difference) {
		this.difference = difference;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdPedodonticsVitalStatisticsDietAnalysis)) return false;
		else {
			jkt.hms.masters.business.OpdPedodonticsVitalStatisticsDietAnalysis opdPedodonticsVitalStatisticsDietAnalysis = (jkt.hms.masters.business.OpdPedodonticsVitalStatisticsDietAnalysis) obj;
			if (null == this.getId() || null == opdPedodonticsVitalStatisticsDietAnalysis.getId()) return false;
			else return (this.getId().equals(opdPedodonticsVitalStatisticsDietAnalysis.getId()));
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