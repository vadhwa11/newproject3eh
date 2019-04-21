package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_physiotherapy_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_physiotherapy_detail"
 */

public abstract class BaseMasPhysiotherapyDetail  implements Serializable {

	public static String REF = "MasPhysiotherapyDetail";
	public static String PROP_MODALITY_CODE = "ModalityCode";
	public static String PROP_MODALITY_REMARKS = "ModalityRemarks";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasPhysiotherapyDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPhysiotherapyDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String modalityCode;
	private java.lang.String modalityRemarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPhysiotherapyHeader mpId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="mpd_id"
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
	 * Return the value associated with the column: modality_code
	 */
	public java.lang.String getModalityCode () {
		return modalityCode;
	}

	/**
	 * Set the value related to the column: modality_code
	 * @param modalityCode the modality_code value
	 */
	public void setModalityCode (java.lang.String modalityCode) {
		this.modalityCode = modalityCode;
	}



	/**
	 * Return the value associated with the column: modality_remarks
	 */
	public java.lang.String getModalityRemarks () {
		return modalityRemarks;
	}

	/**
	 * Set the value related to the column: modality_remarks
	 * @param modalityRemarks the modality_remarks value
	 */
	public void setModalityRemarks (java.lang.String modalityRemarks) {
		this.modalityRemarks = modalityRemarks;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
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
	 * Return the value associated with the column: mp_id
	 */
	public jkt.hms.masters.business.MasPhysiotherapyHeader getMpId () {
		return mpId;
	}

	/**
	 * Set the value related to the column: mp_id
	 * @param mpId the mp_id value
	 */
	public void setMpId (jkt.hms.masters.business.MasPhysiotherapyHeader mpId) {
		this.mpId = mpId;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPhysiotherapyDetail)) return false;
		else {
			jkt.hms.masters.business.MasPhysiotherapyDetail masPhysiotherapyDetail = (jkt.hms.masters.business.MasPhysiotherapyDetail) obj;
			if (null == this.getId() || null == masPhysiotherapyDetail.getId()) return false;
			else return (this.getId().equals(masPhysiotherapyDetail.getId()));
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