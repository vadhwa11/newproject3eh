package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_transfer_application_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_transfer_application_t"
 */

public abstract class BaseHrTransferApplicationT  implements Serializable {

	public static String REF = "HrTransferApplicationT";
	public static String PROP_DISTRICT = "District";
	public static String PROP_TRANSFER_APP = "TransferApp";
	public static String PROP_ID = "Id";
	public static String PROP_INSTITUTE = "Institute";
	public static String PROP_PRIORITY = "Priority";


	// constructors
	public BaseHrTransferApplicationT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTransferApplicationT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String priority;

	// many to one
	private jkt.hms.masters.business.HrTransferApplicationM transferApp;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasHospital institute;



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
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: transfer_app_id
	 */
	public jkt.hms.masters.business.HrTransferApplicationM getTransferApp () {
		return transferApp;
	}

	/**
	 * Set the value related to the column: transfer_app_id
	 * @param transferApp the transfer_app_id value
	 */
	public void setTransferApp (jkt.hms.masters.business.HrTransferApplicationM transferApp) {
		this.transferApp = transferApp;
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
	 * Return the value associated with the column: institute_id
	 */
	public jkt.hms.masters.business.MasHospital getInstitute () {
		return institute;
	}

	/**
	 * Set the value related to the column: institute_id
	 * @param institute the institute_id value
	 */
	public void setInstitute (jkt.hms.masters.business.MasHospital institute) {
		this.institute = institute;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrTransferApplicationT)) return false;
		else {
			jkt.hms.masters.business.HrTransferApplicationT hrTransferApplicationT = (jkt.hms.masters.business.HrTransferApplicationT) obj;
			if (null == this.getId() || null == hrTransferApplicationT.getId()) return false;
			else return (this.getId().equals(hrTransferApplicationT.getId()));
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