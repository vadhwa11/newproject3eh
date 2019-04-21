package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_result_entry_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_result_entry_details"
 */

public abstract class BaseBloodResultEntryDetails  implements Serializable {

	public static String REF = "BloodResultEntryDetails";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_RESULT = "Result";
	public static String PROP_HEADER = "Header";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBloodResultEntryDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodResultEntryDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String result;

	// many to one
	private jkt.hms.masters.business.BloodResultEntryHeader header;
	private jkt.hms.masters.business.DgMasInvestigation investigation;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="details_id"
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
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * @param result the result value
	 */
	public void setResult (java.lang.String result) {
		this.result = result;
	}



	/**
	 * Return the value associated with the column: header_id
	 */
	public jkt.hms.masters.business.BloodResultEntryHeader getHeader () {
		return header;
	}

	/**
	 * Set the value related to the column: header_id
	 * @param header the header_id value
	 */
	public void setHeader (jkt.hms.masters.business.BloodResultEntryHeader header) {
		this.header = header;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigation the investigation_id value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodResultEntryDetails)) return false;
		else {
			jkt.hms.masters.business.BloodResultEntryDetails bloodResultEntryDetails = (jkt.hms.masters.business.BloodResultEntryDetails) obj;
			if (null == this.getId() || null == bloodResultEntryDetails.getId()) return false;
			else return (this.getId().equals(bloodResultEntryDetails.getId()));
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