package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the police_intimation_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="police_intimation_detail"
 */

public abstract class BasePoliceIntimationDetail  implements Serializable {

	public static String REF = "PoliceIntimationDetail";
	public static String PROP_POLICE_STATION = "PoliceStation";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_VISIT = "Visit";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";


	// constructors
	public BasePoliceIntimationDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePoliceIntimationDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serialNo;
	private java.lang.String policeStation;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="police_intimation_detail_id"
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.String serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: police_station
	 */
	public java.lang.String getPoliceStation () {
		return policeStation;
	}

	/**
	 * Set the value related to the column: police_station
	 * @param policeStation the police_station value
	 */
	public void setPoliceStation (java.lang.String policeStation) {
		this.policeStation = policeStation;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PoliceIntimationDetail)) return false;
		else {
			jkt.hms.masters.business.PoliceIntimationDetail policeIntimationDetail = (jkt.hms.masters.business.PoliceIntimationDetail) obj;
			if (null == this.getId() || null == policeIntimationDetail.getId()) return false;
			else return (this.getId().equals(policeIntimationDetail.getId()));
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