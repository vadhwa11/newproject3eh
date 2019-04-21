package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the route_of_administration table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="route_of_administration"
 */

public abstract class BaseRouteOfAdministration  implements Serializable {

	public static String REF = "RouteOfAdministration";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ROUTE_NAME = "RouteName";
	public static String PROP_ID = "Id";
	public static String PROP_ROUTE_CODE = "RouteCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseRouteOfAdministration () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRouteOfAdministration (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String routeCode;
	private java.lang.String routeName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer orderNo;

	public java.lang.Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}



	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="route_id"
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
	 * Return the value associated with the column: route_code
	 */
	public java.lang.String getRouteCode () {
		return routeCode;
	}

	/**
	 * Set the value related to the column: route_code
	 * @param routeCode the route_code value
	 */
	public void setRouteCode (java.lang.String routeCode) {
		this.routeCode = routeCode;
	}



	/**
	 * Return the value associated with the column: route_name
	 */
	public java.lang.String getRouteName () {
		return routeName;
	}

	/**
	 * Set the value related to the column: route_name
	 * @param routeName the route_name value
	 */
	public void setRouteName (java.lang.String routeName) {
		this.routeName = routeName;
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
	 * Return the value associated with the column: PatientPrescriptionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionDetails
	 * @param patientPrescriptionDetails the PatientPrescriptionDetails value
	 */
	public void setPatientPrescriptionDetails (java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
	}

	public void addToPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		if (null == getPatientPrescriptionDetails()) setPatientPrescriptionDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionDetails>());
		getPatientPrescriptionDetails().add(patientPrescriptionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.RouteOfAdministration)) return false;
		else {
			jkt.hms.masters.business.RouteOfAdministration routeOfAdministration = (jkt.hms.masters.business.RouteOfAdministration) obj;
			if (null == this.getId() || null == routeOfAdministration.getId()) return false;
			else return (this.getId().equals(routeOfAdministration.getId()));
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