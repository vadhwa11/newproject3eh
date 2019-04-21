package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tbltimesheet_aprl table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tbltimesheet_aprl"
 */

public abstract class BaseTbltimesheetAprl  implements Serializable {

	public static String REF = "TbltimesheetAprl";
	public static String PROP_TA_STATUS = "TaStatus";
	public static String PROP_APP_HRS = "AppHrs";
	public static String PROP_TMSHT_ID = "TmshtId";
	public static String PROP_APPROVER = "Approver";
	public static String PROP_APP_CMTS = "AppCmts";
	public static String PROP_ID = "Id";


	// constructors
	public BaseTbltimesheetAprl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbltimesheetAprl (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbltimesheetAprl (
		java.lang.Integer id,
		java.lang.Integer tmshtId) {

		this.setId(id);
		this.setTmshtId(tmshtId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer tmshtId;
	private java.lang.Integer approver;
	private java.math.BigDecimal appHrs;
	private java.lang.String appCmts;
	private java.lang.String taStatus;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="TAprl_ID"
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
	 * Return the value associated with the column: Tmsht_ID
	 */
	public java.lang.Integer getTmshtId () {
		return tmshtId;
	}

	/**
	 * Set the value related to the column: Tmsht_ID
	 * @param tmshtId the Tmsht_ID value
	 */
	public void setTmshtId (java.lang.Integer tmshtId) {
		this.tmshtId = tmshtId;
	}



	/**
	 * Return the value associated with the column: Approver
	 */
	public java.lang.Integer getApprover () {
		return approver;
	}

	/**
	 * Set the value related to the column: Approver
	 * @param approver the Approver value
	 */
	public void setApprover (java.lang.Integer approver) {
		this.approver = approver;
	}



	/**
	 * Return the value associated with the column: App_Hrs
	 */
	public java.math.BigDecimal getAppHrs () {
		return appHrs;
	}

	/**
	 * Set the value related to the column: App_Hrs
	 * @param appHrs the App_Hrs value
	 */
	public void setAppHrs (java.math.BigDecimal appHrs) {
		this.appHrs = appHrs;
	}



	/**
	 * Return the value associated with the column: App_Cmts
	 */
	public java.lang.String getAppCmts () {
		return appCmts;
	}

	/**
	 * Set the value related to the column: App_Cmts
	 * @param appCmts the App_Cmts value
	 */
	public void setAppCmts (java.lang.String appCmts) {
		this.appCmts = appCmts;
	}



	/**
	 * Return the value associated with the column: TA_Status
	 */
	public java.lang.String getTaStatus () {
		return taStatus;
	}

	/**
	 * Set the value related to the column: TA_Status
	 * @param taStatus the TA_Status value
	 */
	public void setTaStatus (java.lang.String taStatus) {
		this.taStatus = taStatus;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.TbltimesheetAprl)) return false;
		else {
			jkt.hrms.masters.business.TbltimesheetAprl tbltimesheetAprl = (jkt.hrms.masters.business.TbltimesheetAprl) obj;
			if (null == this.getId() || null == tbltimesheetAprl.getId()) return false;
			else return (this.getId().equals(tbltimesheetAprl.getId()));
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