package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_ps_case_record_orthodotics_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_ps_case_record_orthodotics_details"
 */

public abstract class BaseOpdPsCaseRecordOrthodoticsDetails  implements Serializable {

	public static String REF = "OpdPsCaseRecordOrthodoticsDetails";
	public static String PROP_NO_FOUR = "NoFour";
	public static String PROP_MEASUREMENT = "Measurement";
	public static String PROP_NO_THREE = "NoThree";
	public static String PROP_FLAG = "Flag";
	public static String PROP_KEARAL_NORM = "KearalNorm";
	public static String PROP_VALUE_TEXT = "ValueText";
	public static String PROP_POST_TRT = "PostTrt";
	public static String PROP_NO_FOUR_TEXT = "NoFourText";
	public static String PROP_STEINER_REF_NORM = "SteinerRefNorm";
	public static String PROP_NO_TWO_TEXT = "NoTwoText";
	public static String PROP_DIFF = "Diff";
	public static String PROP_PRE_TRT = "PreTrt";
	public static String PROP_NO_TWO = "NoTwo";
	public static String PROP_NO_ONE_TEXT = "NoOneText";
	public static String PROP_MEAN_VALUE = "MeanValue";
	public static String PROP_NO_THREE_TEXT = "NoThreeText";
	public static String PROP_PARTICULARS = "Particulars";
	public static String PROP_ID = "Id";
	public static String PROP_OPD_PS_CASE_RECORD_ORTHODOTICS = "OpdPsCaseRecordOrthodotics";
	public static String PROP_NO_ONE = "NoOne";


	// constructors
	public BaseOpdPsCaseRecordOrthodoticsDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPsCaseRecordOrthodoticsDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String flag;
	private java.lang.String measurement;
	private java.lang.String steinerRefNorm;
	private java.lang.String kearalNorm;
	private java.lang.String preTrt;
	private java.lang.String postTrt;
	private java.lang.String diff;
	private java.lang.String particulars;
	private java.lang.String meanValue;
	private java.lang.String valueText;
	private java.lang.String noOne;
	private java.lang.String noOneText;
	private java.lang.String noTwo;
	private java.lang.String noTwoText;
	private java.lang.String noThree;
	private java.lang.String noThreeText;
	private java.lang.String noFour;
	private java.lang.String noFourText;

	// many to one
	private jkt.hms.masters.business.OpdPsCaseRecordOrthodotics opdPsCaseRecordOrthodotics;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_ps_case_record_orthodotics_details_id"
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
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: measurement
	 */
	public java.lang.String getMeasurement () {
		return measurement;
	}

	/**
	 * Set the value related to the column: measurement
	 * @param measurement the measurement value
	 */
	public void setMeasurement (java.lang.String measurement) {
		this.measurement = measurement;
	}



	/**
	 * Return the value associated with the column: steiner_ref_norm
	 */
	public java.lang.String getSteinerRefNorm () {
		return steinerRefNorm;
	}

	/**
	 * Set the value related to the column: steiner_ref_norm
	 * @param steinerRefNorm the steiner_ref_norm value
	 */
	public void setSteinerRefNorm (java.lang.String steinerRefNorm) {
		this.steinerRefNorm = steinerRefNorm;
	}



	/**
	 * Return the value associated with the column: kearal_norm
	 */
	public java.lang.String getKearalNorm () {
		return kearalNorm;
	}

	/**
	 * Set the value related to the column: kearal_norm
	 * @param kearalNorm the kearal_norm value
	 */
	public void setKearalNorm (java.lang.String kearalNorm) {
		this.kearalNorm = kearalNorm;
	}



	/**
	 * Return the value associated with the column: pre_trt
	 */
	public java.lang.String getPreTrt () {
		return preTrt;
	}

	/**
	 * Set the value related to the column: pre_trt
	 * @param preTrt the pre_trt value
	 */
	public void setPreTrt (java.lang.String preTrt) {
		this.preTrt = preTrt;
	}



	/**
	 * Return the value associated with the column: post_trt
	 */
	public java.lang.String getPostTrt () {
		return postTrt;
	}

	/**
	 * Set the value related to the column: post_trt
	 * @param postTrt the post_trt value
	 */
	public void setPostTrt (java.lang.String postTrt) {
		this.postTrt = postTrt;
	}



	/**
	 * Return the value associated with the column: diff
	 */
	public java.lang.String getDiff () {
		return diff;
	}

	/**
	 * Set the value related to the column: diff
	 * @param diff the diff value
	 */
	public void setDiff (java.lang.String diff) {
		this.diff = diff;
	}



	/**
	 * Return the value associated with the column: particulars
	 */
	public java.lang.String getParticulars () {
		return particulars;
	}

	/**
	 * Set the value related to the column: particulars
	 * @param particulars the particulars value
	 */
	public void setParticulars (java.lang.String particulars) {
		this.particulars = particulars;
	}



	/**
	 * Return the value associated with the column: mean_value
	 */
	public java.lang.String getMeanValue () {
		return meanValue;
	}

	/**
	 * Set the value related to the column: mean_value
	 * @param meanValue the mean_value value
	 */
	public void setMeanValue (java.lang.String meanValue) {
		this.meanValue = meanValue;
	}



	/**
	 * Return the value associated with the column: value_text
	 */
	public java.lang.String getValueText () {
		return valueText;
	}

	/**
	 * Set the value related to the column: value_text
	 * @param valueText the value_text value
	 */
	public void setValueText (java.lang.String valueText) {
		this.valueText = valueText;
	}



	/**
	 * Return the value associated with the column: no_one
	 */
	public java.lang.String getNoOne () {
		return noOne;
	}

	/**
	 * Set the value related to the column: no_one
	 * @param noOne the no_one value
	 */
	public void setNoOne (java.lang.String noOne) {
		this.noOne = noOne;
	}



	/**
	 * Return the value associated with the column: no_one_text
	 */
	public java.lang.String getNoOneText () {
		return noOneText;
	}

	/**
	 * Set the value related to the column: no_one_text
	 * @param noOneText the no_one_text value
	 */
	public void setNoOneText (java.lang.String noOneText) {
		this.noOneText = noOneText;
	}



	/**
	 * Return the value associated with the column: no_two
	 */
	public java.lang.String getNoTwo () {
		return noTwo;
	}

	/**
	 * Set the value related to the column: no_two
	 * @param noTwo the no_two value
	 */
	public void setNoTwo (java.lang.String noTwo) {
		this.noTwo = noTwo;
	}



	/**
	 * Return the value associated with the column: no_two_text
	 */
	public java.lang.String getNoTwoText () {
		return noTwoText;
	}

	/**
	 * Set the value related to the column: no_two_text
	 * @param noTwoText the no_two_text value
	 */
	public void setNoTwoText (java.lang.String noTwoText) {
		this.noTwoText = noTwoText;
	}



	/**
	 * Return the value associated with the column: no_three
	 */
	public java.lang.String getNoThree () {
		return noThree;
	}

	/**
	 * Set the value related to the column: no_three
	 * @param noThree the no_three value
	 */
	public void setNoThree (java.lang.String noThree) {
		this.noThree = noThree;
	}



	/**
	 * Return the value associated with the column: no_three_text
	 */
	public java.lang.String getNoThreeText () {
		return noThreeText;
	}

	/**
	 * Set the value related to the column: no_three_text
	 * @param noThreeText the no_three_text value
	 */
	public void setNoThreeText (java.lang.String noThreeText) {
		this.noThreeText = noThreeText;
	}



	/**
	 * Return the value associated with the column: no_four
	 */
	public java.lang.String getNoFour () {
		return noFour;
	}

	/**
	 * Set the value related to the column: no_four
	 * @param noFour the no_four value
	 */
	public void setNoFour (java.lang.String noFour) {
		this.noFour = noFour;
	}



	/**
	 * Return the value associated with the column: no_four_text
	 */
	public java.lang.String getNoFourText () {
		return noFourText;
	}

	/**
	 * Set the value related to the column: no_four_text
	 * @param noFourText the no_four_text value
	 */
	public void setNoFourText (java.lang.String noFourText) {
		this.noFourText = noFourText;
	}



	/**
	 * Return the value associated with the column: opd_ps_case_record_orthodotics_id
	 */
	public jkt.hms.masters.business.OpdPsCaseRecordOrthodotics getOpdPsCaseRecordOrthodotics () {
		return opdPsCaseRecordOrthodotics;
	}

	/**
	 * Set the value related to the column: opd_ps_case_record_orthodotics_id
	 * @param opdPsCaseRecordOrthodotics the opd_ps_case_record_orthodotics_id value
	 */
	public void setOpdPsCaseRecordOrthodotics (jkt.hms.masters.business.OpdPsCaseRecordOrthodotics opdPsCaseRecordOrthodotics) {
		this.opdPsCaseRecordOrthodotics = opdPsCaseRecordOrthodotics;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPsCaseRecordOrthodoticsDetails)) return false;
		else {
			jkt.hms.masters.business.OpdPsCaseRecordOrthodoticsDetails opdPsCaseRecordOrthodoticsDetails = (jkt.hms.masters.business.OpdPsCaseRecordOrthodoticsDetails) obj;
			if (null == this.getId() || null == opdPsCaseRecordOrthodoticsDetails.getId()) return false;
			else return (this.getId().equals(opdPsCaseRecordOrthodoticsDetails.getId()));
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