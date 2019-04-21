package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ip_dialysis_req_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ip_dialysis_req_details"
 */

public abstract class BaseIpDialysisDetails  implements Serializable {

	public static String REF = "IpDialysisDetails";
	public static String PROP_IP_REQ_HEADER = "IpReqHeader";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_ID = "Id";


	// constructors
	public BaseIpDialysisDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpDialysisDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.IpPhysioReqHeader ipReqHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: ip_req_header_id
	 */
	public jkt.hms.masters.business.IpPhysioReqHeader getIpReqHeader () {
		return ipReqHeader;
	}

	/**
	 * Set the value related to the column: ip_req_header_id
	 * @param ipReqHeader the ip_req_header_id value
	 */
	public void setIpReqHeader (jkt.hms.masters.business.IpPhysioReqHeader ipReqHeader) {
		this.ipReqHeader = ipReqHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpDialysisDetails)) return false;
		else {
			jkt.hms.masters.business.IpDialysisDetails ipDialysisDetails = (jkt.hms.masters.business.IpDialysisDetails) obj;
			if (null == this.getId() || null == ipDialysisDetails.getId()) return false;
			else return (this.getId().equals(ipDialysisDetails.getId()));
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