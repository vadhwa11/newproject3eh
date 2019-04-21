package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_fes_study_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_fes_study_detail"
 */

public abstract class BasePrjFesStudyDetail  implements Serializable {

	public static String REF = "PrjFesStudyDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_CALL_DATE = "CallDate";
	public static String PROP_ID = "Id";
	public static String PROP_CALL_RESPONSE = "CallResponse";
	public static String PROP_FES_STUDY_HEADER = "FesStudyHeader";


	// constructors
	public BasePrjFesStudyDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjFesStudyDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date callDate;
	private java.lang.String callResponse;
	private java.lang.String status;

	// many to one
	private jkt.hrms.masters.business.PrjFesStudyHeader fesStudyHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="fes_study_detail_id"
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
	 * Return the value associated with the column: call_date
	 */
	public java.util.Date getCallDate () {
		return callDate;
	}

	/**
	 * Set the value related to the column: call_date
	 * @param callDate the call_date value
	 */
	public void setCallDate (java.util.Date callDate) {
		this.callDate = callDate;
	}



	/**
	 * Return the value associated with the column: call_response
	 */
	public java.lang.String getCallResponse () {
		return callResponse;
	}

	/**
	 * Set the value related to the column: call_response
	 * @param callResponse the call_response value
	 */
	public void setCallResponse (java.lang.String callResponse) {
		this.callResponse = callResponse;
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
	 * Return the value associated with the column: fes_study_header_id
	 */
	public jkt.hrms.masters.business.PrjFesStudyHeader getFesStudyHeader () {
		return fesStudyHeader;
	}

	/**
	 * Set the value related to the column: fes_study_header_id
	 * @param fesStudyHeader the fes_study_header_id value
	 */
	public void setFesStudyHeader (jkt.hrms.masters.business.PrjFesStudyHeader fesStudyHeader) {
		this.fesStudyHeader = fesStudyHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjFesStudyDetail)) return false;
		else {
			jkt.hrms.masters.business.PrjFesStudyDetail prjFesStudyDetail = (jkt.hrms.masters.business.PrjFesStudyDetail) obj;
			if (null == this.getId() || null == prjFesStudyDetail.getId()) return false;
			else return (this.getId().equals(prjFesStudyDetail.getId()));
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