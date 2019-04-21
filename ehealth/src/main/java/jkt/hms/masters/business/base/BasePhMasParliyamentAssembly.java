package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_mas_parliyament_assembly table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_mas_parliyament_assembly"
 */

public abstract class BasePhMasParliyamentAssembly  implements Serializable {

	public static String REF = "PhMasParliyamentAssembly";
	public static String PROP_NAME = "Name";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISTRICT = "District";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CODE = "Code";
	public static String PROP_PARLIYAMENT = "Parliyament";


	// constructors
	public BasePhMasParliyamentAssembly () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhMasParliyamentAssembly (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String category;
	private java.lang.String code;
	private java.lang.String name;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.PhMasParliyamentAssembly parliyament;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhMasParliyamentAssembly> phMasParliyamentAssemblies;
	private java.util.Set<jkt.hms.masters.business.PhMasPanchayat> phMasPanchayats;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="parliyament_assembly_id"
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
	 * Return the value associated with the column: category
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: code
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: code
	 * @param code the code value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
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
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}



	/**
	 * Return the value associated with the column: parliyament_id
	 */
	public jkt.hms.masters.business.PhMasParliyamentAssembly getParliyament () {
		return parliyament;
	}

	/**
	 * Set the value related to the column: parliyament_id
	 * @param parliyament the parliyament_id value
	 */
	public void setParliyament (jkt.hms.masters.business.PhMasParliyamentAssembly parliyament) {
		this.parliyament = parliyament;
	}



	/**
	 * Return the value associated with the column: PhMasParliyamentAssemblies
	 */
	public java.util.Set<jkt.hms.masters.business.PhMasParliyamentAssembly> getPhMasParliyamentAssemblies () {
		return phMasParliyamentAssemblies;
	}

	/**
	 * Set the value related to the column: PhMasParliyamentAssemblies
	 * @param phMasParliyamentAssemblies the PhMasParliyamentAssemblies value
	 */
	public void setPhMasParliyamentAssemblies (java.util.Set<jkt.hms.masters.business.PhMasParliyamentAssembly> phMasParliyamentAssemblies) {
		this.phMasParliyamentAssemblies = phMasParliyamentAssemblies;
	}

	public void addToPhMasParliyamentAssemblies (jkt.hms.masters.business.PhMasParliyamentAssembly phMasParliyamentAssembly) {
		if (null == getPhMasParliyamentAssemblies()) setPhMasParliyamentAssemblies(new java.util.TreeSet<jkt.hms.masters.business.PhMasParliyamentAssembly>());
		getPhMasParliyamentAssemblies().add(phMasParliyamentAssembly);
	}



	/**
	 * Return the value associated with the column: PhMasPanchayats
	 */
	public java.util.Set<jkt.hms.masters.business.PhMasPanchayat> getPhMasPanchayats () {
		return phMasPanchayats;
	}

	/**
	 * Set the value related to the column: PhMasPanchayats
	 * @param phMasPanchayats the PhMasPanchayats value
	 */
	public void setPhMasPanchayats (java.util.Set<jkt.hms.masters.business.PhMasPanchayat> phMasPanchayats) {
		this.phMasPanchayats = phMasPanchayats;
	}

	public void addToPhMasPanchayats (jkt.hms.masters.business.PhMasPanchayat phMasPanchayat) {
		if (null == getPhMasPanchayats()) setPhMasPanchayats(new java.util.TreeSet<jkt.hms.masters.business.PhMasPanchayat>());
		getPhMasPanchayats().add(phMasPanchayat);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhMasParliyamentAssembly)) return false;
		else {
			jkt.hms.masters.business.PhMasParliyamentAssembly phMasParliyamentAssembly = (jkt.hms.masters.business.PhMasParliyamentAssembly) obj;
			if (null == this.getId() || null == phMasParliyamentAssembly.getId()) return false;
			else return (this.getId().equals(phMasParliyamentAssembly.getId()));
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