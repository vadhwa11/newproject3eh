package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_antcard_menstrual_histry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_antcard_menstrual_histry"
 */

public abstract class BaseOpdAntcardMenstrualHistry  implements Serializable {

	public static String REF = "OpdAntcardMenstrualHistry";
	public static String PROP_MENST_HIST_PL = "MenstHistPl";
	public static String PROP_VOLUME = "Volume";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MENST_HIST_TIME = "MenstHistTime";
	public static String PROP_REGULR_CYCLE = "RegulrCycle";
	public static String PROP_VISIT = "Visit";
	public static String PROP_CHAR_STICT = "CharStict";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PMP_DATE = "PmpDate";
	public static String PROP_OPD_ANTENATAL_CARD = "OpdAntenatalCard";
	public static String PROP_MENST_HIST_DATE = "MenstHistDate";
	public static String PROP_LMP_DATE = "LmpDate";
	public static String PROP_CYCLE_DURATION = "CycleDuration";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ASSOC_COMPL = "AssocCompl";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOpdAntcardMenstrualHistry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdAntcardMenstrualHistry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date menstHistDate;
	private java.lang.String menstHistTime;
	private java.lang.Long menstHistPl;
	private java.util.Date lmpDate;
	private java.util.Date pmpDate;
	private java.lang.Long regulrCycle;
	private java.lang.String cycleDuration;
	private java.lang.Long frequency;
	private java.lang.String duration;
	private java.lang.Long volume;
	private java.lang.String charStict;
	private java.lang.String assocCompl;
	private java.lang.Long lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_antcard_menst_hist_id"
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
	 * Return the value associated with the column: menst_hist_date
	 */
	public java.util.Date getMenstHistDate () {
		return menstHistDate;
	}

	/**
	 * Set the value related to the column: menst_hist_date
	 * @param menstHistDate the menst_hist_date value
	 */
	public void setMenstHistDate (java.util.Date menstHistDate) {
		this.menstHistDate = menstHistDate;
	}



	/**
	 * Return the value associated with the column: menst_hist_time
	 */
	public java.lang.String getMenstHistTime () {
		return menstHistTime;
	}

	/**
	 * Set the value related to the column: menst_hist_time
	 * @param menstHistTime the menst_hist_time value
	 */
	public void setMenstHistTime (java.lang.String menstHistTime) {
		this.menstHistTime = menstHistTime;
	}



	/**
	 * Return the value associated with the column: menst_hist_pl
	 */
	public java.lang.Long getMenstHistPl () {
		return menstHistPl;
	}

	/**
	 * Set the value related to the column: menst_hist_pl
	 * @param menstHistPl the menst_hist_pl value
	 */
	public void setMenstHistPl (java.lang.Long menstHistPl) {
		this.menstHistPl = menstHistPl;
	}



	/**
	 * Return the value associated with the column: lmp_date
	 */
	public java.util.Date getLmpDate () {
		return lmpDate;
	}

	/**
	 * Set the value related to the column: lmp_date
	 * @param lmpDate the lmp_date value
	 */
	public void setLmpDate (java.util.Date lmpDate) {
		this.lmpDate = lmpDate;
	}



	/**
	 * Return the value associated with the column: pmp_date
	 */
	public java.util.Date getPmpDate () {
		return pmpDate;
	}

	/**
	 * Set the value related to the column: pmp_date
	 * @param pmpDate the pmp_date value
	 */
	public void setPmpDate (java.util.Date pmpDate) {
		this.pmpDate = pmpDate;
	}



	/**
	 * Return the value associated with the column: regulr_cycle
	 */
	public java.lang.Long getRegulrCycle () {
		return regulrCycle;
	}

	/**
	 * Set the value related to the column: regulr_cycle
	 * @param regulrCycle the regulr_cycle value
	 */
	public void setRegulrCycle (java.lang.Long regulrCycle) {
		this.regulrCycle = regulrCycle;
	}



	/**
	 * Return the value associated with the column: cycle_duration
	 */
	public java.lang.String getCycleDuration () {
		return cycleDuration;
	}

	/**
	 * Set the value related to the column: cycle_duration
	 * @param cycleDuration the cycle_duration value
	 */
	public void setCycleDuration (java.lang.String cycleDuration) {
		this.cycleDuration = cycleDuration;
	}



	/**
	 * Return the value associated with the column: frequency
	 */
	public java.lang.Long getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency
	 * @param frequency the frequency value
	 */
	public void setFrequency (java.lang.Long frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: volume
	 */
	public java.lang.Long getVolume () {
		return volume;
	}

	/**
	 * Set the value related to the column: volume
	 * @param volume the volume value
	 */
	public void setVolume (java.lang.Long volume) {
		this.volume = volume;
	}



	/**
	 * Return the value associated with the column: char_stict
	 */
	public java.lang.String getCharStict () {
		return charStict;
	}

	/**
	 * Set the value related to the column: char_stict
	 * @param charStict the char_stict value
	 */
	public void setCharStict (java.lang.String charStict) {
		this.charStict = charStict;
	}



	/**
	 * Return the value associated with the column: assoc_compl
	 */
	public java.lang.String getAssocCompl () {
		return assocCompl;
	}

	/**
	 * Set the value related to the column: assoc_compl
	 * @param assocCompl the assoc_compl value
	 */
	public void setAssocCompl (java.lang.String assocCompl) {
		this.assocCompl = assocCompl;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Long getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Long lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: opd_antenatal_card_id
	 */
	public jkt.hms.masters.business.OpdAntenatalCard getOpdAntenatalCard () {
		return opdAntenatalCard;
	}

	/**
	 * Set the value related to the column: opd_antenatal_card_id
	 * @param opdAntenatalCard the opd_antenatal_card_id value
	 */
	public void setOpdAntenatalCard (jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard) {
		this.opdAntenatalCard = opdAntenatalCard;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdAntcardMenstrualHistry)) return false;
		else {
			jkt.hms.masters.business.OpdAntcardMenstrualHistry opdAntcardMenstrualHistry = (jkt.hms.masters.business.OpdAntcardMenstrualHistry) obj;
			if (null == this.getId() || null == opdAntcardMenstrualHistry.getId()) return false;
			else return (this.getId().equals(opdAntcardMenstrualHistry.getId()));
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