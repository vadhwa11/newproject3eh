package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_mas_organism table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_mas_organism"
 */

public abstract class BaseDgMasOrganism  implements Serializable {

	public static String REF = "DgMasOrganism";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORGANISM_NAME = "OrganismName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ORGANISM_CODE = "OrganismCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseDgMasOrganism () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgMasOrganism (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String organismCode;
	private java.lang.String organismName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgOrgGrpDtl> dgOrgGrpDtls;
	private java.util.Set<jkt.hms.masters.business.DgMasOrgDtl> dgMasOrgDtls;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> dgResultEntryDetailSens;
	private java.util.Set<jkt.hms.masters.business.DgOrgDtl> dgOrgDtls;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="organism_id"
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
	 * Return the value associated with the column: organism_code
	 */
	public java.lang.String getOrganismCode () {
		return organismCode;
	}

	/**
	 * Set the value related to the column: organism_code
	 * @param organismCode the organism_code value
	 */
	public void setOrganismCode (java.lang.String organismCode) {
		this.organismCode = organismCode;
	}



	/**
	 * Return the value associated with the column: organism_name
	 */
	public java.lang.String getOrganismName () {
		return organismName;
	}

	/**
	 * Set the value related to the column: organism_name
	 * @param organismName the organism_name value
	 */
	public void setOrganismName (java.lang.String organismName) {
		this.organismName = organismName;
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
	 * Return the value associated with the column: DgOrgGrpDtls
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrgGrpDtl> getDgOrgGrpDtls () {
		return dgOrgGrpDtls;
	}

	/**
	 * Set the value related to the column: DgOrgGrpDtls
	 * @param dgOrgGrpDtls the DgOrgGrpDtls value
	 */
	public void setDgOrgGrpDtls (java.util.Set<jkt.hms.masters.business.DgOrgGrpDtl> dgOrgGrpDtls) {
		this.dgOrgGrpDtls = dgOrgGrpDtls;
	}

	public void addToDgOrgGrpDtls (jkt.hms.masters.business.DgOrgGrpDtl dgOrgGrpDtl) {
		if (null == getDgOrgGrpDtls()) setDgOrgGrpDtls(new java.util.TreeSet<jkt.hms.masters.business.DgOrgGrpDtl>());
		getDgOrgGrpDtls().add(dgOrgGrpDtl);
	}



	/**
	 * Return the value associated with the column: DgMasOrgDtls
	 */
	public java.util.Set<jkt.hms.masters.business.DgMasOrgDtl> getDgMasOrgDtls () {
		return dgMasOrgDtls;
	}

	/**
	 * Set the value related to the column: DgMasOrgDtls
	 * @param dgMasOrgDtls the DgMasOrgDtls value
	 */
	public void setDgMasOrgDtls (java.util.Set<jkt.hms.masters.business.DgMasOrgDtl> dgMasOrgDtls) {
		this.dgMasOrgDtls = dgMasOrgDtls;
	}

	public void addToDgMasOrgDtls (jkt.hms.masters.business.DgMasOrgDtl dgMasOrgDtl) {
		if (null == getDgMasOrgDtls()) setDgMasOrgDtls(new java.util.TreeSet<jkt.hms.masters.business.DgMasOrgDtl>());
		getDgMasOrgDtls().add(dgMasOrgDtl);
	}



	/**
	 * Return the value associated with the column: DgResultEntryDetailSens
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> getDgResultEntryDetailSens () {
		return dgResultEntryDetailSens;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetailSens
	 * @param dgResultEntryDetailSens the DgResultEntryDetailSens value
	 */
	public void setDgResultEntryDetailSens (java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> dgResultEntryDetailSens) {
		this.dgResultEntryDetailSens = dgResultEntryDetailSens;
	}

	public void addToDgResultEntryDetailSens (jkt.hms.masters.business.DgResultEntryDetailSen dgResultEntryDetailSen) {
		if (null == getDgResultEntryDetailSens()) setDgResultEntryDetailSens(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetailSen>());
		getDgResultEntryDetailSens().add(dgResultEntryDetailSen);
	}



	/**
	 * Return the value associated with the column: DgOrgDtls
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrgDtl> getDgOrgDtls () {
		return dgOrgDtls;
	}

	/**
	 * Set the value related to the column: DgOrgDtls
	 * @param dgOrgDtls the DgOrgDtls value
	 */
	public void setDgOrgDtls (java.util.Set<jkt.hms.masters.business.DgOrgDtl> dgOrgDtls) {
		this.dgOrgDtls = dgOrgDtls;
	}

	public void addToDgOrgDtls (jkt.hms.masters.business.DgOrgDtl dgOrgDtl) {
		if (null == getDgOrgDtls()) setDgOrgDtls(new java.util.TreeSet<jkt.hms.masters.business.DgOrgDtl>());
		getDgOrgDtls().add(dgOrgDtl);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgMasOrganism)) return false;
		else {
			jkt.hms.masters.business.DgMasOrganism dgMasOrganism = (jkt.hms.masters.business.DgMasOrganism) obj;
			if (null == this.getId() || null == dgMasOrganism.getId()) return false;
			else return (this.getId().equals(dgMasOrganism.getId()));
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