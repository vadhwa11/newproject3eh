package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_surgery_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_surgery_detail"
 */

public abstract class BaseOpdSurgeryDetail  implements Serializable {

	public static String REF = "OpdSurgeryDetail";
	public static String PROP_OPD_SURGERY = "OpdSurgery";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_TENTATIVE_DATE = "TentativeDate";
	public static String PROP_PAC_REQUEST = "PacRequest";
	


	// constructors
	public BaseOpdSurgeryDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdSurgeryDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date tentativeDate;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String pacRequest;
	

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}



	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.OpdSurgeryHeader opdSurgery;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: tentative_date
	 */
	public java.util.Date getTentativeDate () {
		return tentativeDate;
	}

	/**
	 * Set the value related to the column: tentative_date
	 * @param tentativeDate the tentative_date value
	 */
	public void setTentativeDate (java.util.Date tentativeDate) {
		this.tentativeDate = tentativeDate;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}

	public java.lang.String getPacRequest() {
		return pacRequest;
	}

	public void setPacRequest(java.lang.String pacRequest) {
		this.pacRequest = pacRequest;
	}

	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}



	/**
	 * Return the value associated with the column: opd_surgery_id
	 */
	public jkt.hms.masters.business.OpdSurgeryHeader getOpdSurgery () {
		return opdSurgery;
	}

	/**
	 * Set the value related to the column: opd_surgery_id
	 * @param opdSurgery the opd_surgery_id value
	 */
	public void setOpdSurgery (jkt.hms.masters.business.OpdSurgeryHeader opdSurgery) {
		this.opdSurgery = opdSurgery;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdSurgeryDetail)) return false;
		else {
			jkt.hms.masters.business.OpdSurgeryDetail opdSurgeryDetail = (jkt.hms.masters.business.OpdSurgeryDetail) obj;
			if (null == this.getId() || null == opdSurgeryDetail.getId()) return false;
			else return (this.getId().equals(opdSurgeryDetail.getId()));
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