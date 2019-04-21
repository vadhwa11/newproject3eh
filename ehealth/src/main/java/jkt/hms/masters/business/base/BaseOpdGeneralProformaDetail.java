package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_general_proforma_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_general_proforma_detail"
 */

public abstract class BaseOpdGeneralProformaDetail  implements Serializable {

	public static String REF = "OpdGeneralProformaDetail";
	public static String PROP_PRSENTING_COMPLAINTS = "PrsentingComplaints";
	public static String PROP_PIGMENTATION_STATUS = "PigmentationStatus";
	public static String PROP_CHARCTER = "Charcter";
	public static String PROP_MUCOUS_MEMBRANE = "MucousMembrane";
	public static String PROP_PAST_HISTORY = "PastHistory";
	public static String PROP_GENERAL_PROFORMA = "GeneralProforma";
	public static String PROP_SURFACE = "Surface";
	public static String PROP_SYSTEM_ILLNESS = "SystemIllness";
	public static String PROP_PARAMETER_NAME = "ParameterName";
	public static String PROP_AGGRAVATING_FACTORS = "AggravatingFactors";
	public static String PROP_SMALLEST_SIZE = "SmallestSize";
	public static String PROP_PIGMENTATION = "Pigmentation";
	public static String PROP_SITE = "Site";
	public static String PROP_FLAG = "Flag";
	public static String PROP_BORDER = "Border";
	public static String PROP_NUMBER = "Number";
	public static String PROP_TYPE_OF_LESION = "TypeOfLesion";
	public static String PROP_HAIR_ON_LESION = "HairOnLesion";
	public static String PROP_HAIR = "Hair";
	public static String PROP_STATUS = "Status";
	public static String PROP_LARGEST_SIZE = "LargestSize";
	public static String PROP_AGGRAVATING_FACTOR = "AggravatingFactor";
	public static String PROP_LESION = "Lesion";
	public static String PROP_ID = "Id";
	public static String PROP_NAILS = "Nails";


	// constructors
	public BaseOpdGeneralProformaDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGeneralProformaDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String parameterName;
	private java.lang.String status;
	private java.lang.String flag;
	private java.lang.String lesion;
	private java.lang.String number;
	private java.lang.String site;
	private java.lang.String typeOfLesion;
	private java.lang.String pigmentationStatus;
	private java.lang.String pigmentation;
	private java.lang.String charcter;
	private java.lang.String border;
	private java.lang.String surface;
	private java.lang.String smallestSize;
	private java.lang.String largestSize;
	private java.lang.String hairOnLesion;
	private java.lang.String aggravatingFactors;
	private java.lang.String prsentingComplaints;
	private java.lang.String pastHistory;
	private java.lang.String mucousMembrane;
	private java.lang.String hair;
	private java.lang.String nails;
	private java.lang.String systemIllness;
	private java.lang.String aggravatingFactor;

	// many to one
	private jkt.hms.masters.business.OpdGeneralProformaHeader generalProforma;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="general_proforma_detail_id"
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
	 * Return the value associated with the column: parameter_name
	 */
	public java.lang.String getParameterName () {
		return parameterName;
	}

	/**
	 * Set the value related to the column: parameter_name
	 * @param parameterName the parameter_name value
	 */
	public void setParameterName (java.lang.String parameterName) {
		this.parameterName = parameterName;
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
	 * Return the value associated with the column: lesion
	 */
	public java.lang.String getLesion () {
		return lesion;
	}

	/**
	 * Set the value related to the column: lesion
	 * @param lesion the lesion value
	 */
	public void setLesion (java.lang.String lesion) {
		this.lesion = lesion;
	}



	/**
	 * Return the value associated with the column: number
	 */
	public java.lang.String getNumber () {
		return number;
	}

	/**
	 * Set the value related to the column: number
	 * @param number the number value
	 */
	public void setNumber (java.lang.String number) {
		this.number = number;
	}



	/**
	 * Return the value associated with the column: site
	 */
	public java.lang.String getSite () {
		return site;
	}

	/**
	 * Set the value related to the column: site
	 * @param site the site value
	 */
	public void setSite (java.lang.String site) {
		this.site = site;
	}



	/**
	 * Return the value associated with the column: type_of_lesion
	 */
	public java.lang.String getTypeOfLesion () {
		return typeOfLesion;
	}

	/**
	 * Set the value related to the column: type_of_lesion
	 * @param typeOfLesion the type_of_lesion value
	 */
	public void setTypeOfLesion (java.lang.String typeOfLesion) {
		this.typeOfLesion = typeOfLesion;
	}



	/**
	 * Return the value associated with the column: pigmentation_status
	 */
	public java.lang.String getPigmentationStatus () {
		return pigmentationStatus;
	}

	/**
	 * Set the value related to the column: pigmentation_status
	 * @param pigmentationStatus the pigmentation_status value
	 */
	public void setPigmentationStatus (java.lang.String pigmentationStatus) {
		this.pigmentationStatus = pigmentationStatus;
	}



	/**
	 * Return the value associated with the column: pigmentation
	 */
	public java.lang.String getPigmentation () {
		return pigmentation;
	}

	/**
	 * Set the value related to the column: pigmentation
	 * @param pigmentation the pigmentation value
	 */
	public void setPigmentation (java.lang.String pigmentation) {
		this.pigmentation = pigmentation;
	}



	/**
	 * Return the value associated with the column: charcter
	 */
	public java.lang.String getCharcter () {
		return charcter;
	}

	/**
	 * Set the value related to the column: charcter
	 * @param charcter the charcter value
	 */
	public void setCharcter (java.lang.String charcter) {
		this.charcter = charcter;
	}



	/**
	 * Return the value associated with the column: border
	 */
	public java.lang.String getBorder () {
		return border;
	}

	/**
	 * Set the value related to the column: border
	 * @param border the border value
	 */
	public void setBorder (java.lang.String border) {
		this.border = border;
	}



	/**
	 * Return the value associated with the column: surface
	 */
	public java.lang.String getSurface () {
		return surface;
	}

	/**
	 * Set the value related to the column: surface
	 * @param surface the surface value
	 */
	public void setSurface (java.lang.String surface) {
		this.surface = surface;
	}



	/**
	 * Return the value associated with the column: smallest_size
	 */
	public java.lang.String getSmallestSize () {
		return smallestSize;
	}

	/**
	 * Set the value related to the column: smallest_size
	 * @param smallestSize the smallest_size value
	 */
	public void setSmallestSize (java.lang.String smallestSize) {
		this.smallestSize = smallestSize;
	}



	/**
	 * Return the value associated with the column: largest_size
	 */
	public java.lang.String getLargestSize () {
		return largestSize;
	}

	/**
	 * Set the value related to the column: largest_size
	 * @param largestSize the largest_size value
	 */
	public void setLargestSize (java.lang.String largestSize) {
		this.largestSize = largestSize;
	}



	/**
	 * Return the value associated with the column: hair_on_lesion
	 */
	public java.lang.String getHairOnLesion () {
		return hairOnLesion;
	}

	/**
	 * Set the value related to the column: hair_on_lesion
	 * @param hairOnLesion the hair_on_lesion value
	 */
	public void setHairOnLesion (java.lang.String hairOnLesion) {
		this.hairOnLesion = hairOnLesion;
	}



	/**
	 * Return the value associated with the column: aggravating_factors
	 */
	public java.lang.String getAggravatingFactors () {
		return aggravatingFactors;
	}

	/**
	 * Set the value related to the column: aggravating_factors
	 * @param aggravatingFactors the aggravating_factors value
	 */
	public void setAggravatingFactors (java.lang.String aggravatingFactors) {
		this.aggravatingFactors = aggravatingFactors;
	}



	/**
	 * Return the value associated with the column: prsenting_complaints
	 */
	public java.lang.String getPrsentingComplaints () {
		return prsentingComplaints;
	}

	/**
	 * Set the value related to the column: prsenting_complaints
	 * @param prsentingComplaints the prsenting_complaints value
	 */
	public void setPrsentingComplaints (java.lang.String prsentingComplaints) {
		this.prsentingComplaints = prsentingComplaints;
	}



	/**
	 * Return the value associated with the column: past_history
	 */
	public java.lang.String getPastHistory () {
		return pastHistory;
	}

	/**
	 * Set the value related to the column: past_history
	 * @param pastHistory the past_history value
	 */
	public void setPastHistory (java.lang.String pastHistory) {
		this.pastHistory = pastHistory;
	}



	/**
	 * Return the value associated with the column: mucous_membrane
	 */
	public java.lang.String getMucousMembrane () {
		return mucousMembrane;
	}

	/**
	 * Set the value related to the column: mucous_membrane
	 * @param mucousMembrane the mucous_membrane value
	 */
	public void setMucousMembrane (java.lang.String mucousMembrane) {
		this.mucousMembrane = mucousMembrane;
	}



	/**
	 * Return the value associated with the column: hair
	 */
	public java.lang.String getHair () {
		return hair;
	}

	/**
	 * Set the value related to the column: hair
	 * @param hair the hair value
	 */
	public void setHair (java.lang.String hair) {
		this.hair = hair;
	}



	/**
	 * Return the value associated with the column: nails
	 */
	public java.lang.String getNails () {
		return nails;
	}

	/**
	 * Set the value related to the column: nails
	 * @param nails the nails value
	 */
	public void setNails (java.lang.String nails) {
		this.nails = nails;
	}



	/**
	 * Return the value associated with the column: system_illness
	 */
	public java.lang.String getSystemIllness () {
		return systemIllness;
	}

	/**
	 * Set the value related to the column: system_illness
	 * @param systemIllness the system_illness value
	 */
	public void setSystemIllness (java.lang.String systemIllness) {
		this.systemIllness = systemIllness;
	}



	/**
	 * Return the value associated with the column: aggravating_factor
	 */
	public java.lang.String getAggravatingFactor () {
		return aggravatingFactor;
	}

	/**
	 * Set the value related to the column: aggravating_factor
	 * @param aggravatingFactor the aggravating_factor value
	 */
	public void setAggravatingFactor (java.lang.String aggravatingFactor) {
		this.aggravatingFactor = aggravatingFactor;
	}



	/**
	 * Return the value associated with the column: general_proforma_id
	 */
	public jkt.hms.masters.business.OpdGeneralProformaHeader getGeneralProforma () {
		return generalProforma;
	}

	/**
	 * Set the value related to the column: general_proforma_id
	 * @param generalProforma the general_proforma_id value
	 */
	public void setGeneralProforma (jkt.hms.masters.business.OpdGeneralProformaHeader generalProforma) {
		this.generalProforma = generalProforma;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdGeneralProformaDetail)) return false;
		else {
			jkt.hms.masters.business.OpdGeneralProformaDetail opdGeneralProformaDetail = (jkt.hms.masters.business.OpdGeneralProformaDetail) obj;
			if (null == this.getId() || null == opdGeneralProformaDetail.getId()) return false;
			else return (this.getId().equals(opdGeneralProformaDetail.getId()));
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