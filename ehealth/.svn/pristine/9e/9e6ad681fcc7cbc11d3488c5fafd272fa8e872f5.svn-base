package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_anc_termination_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_anc_termination_t"
 */

public abstract class BasePhAncTerminationT  implements Serializable {

	public static String REF = "PhAncTerminationT";
	public static String PROP_ANC_REG_ID = "AncRegId";
	public static String PROP_SERVER_PK = "ServerPk";
	public static String PROP_ID = "Id";
	public static String PROP_GENDER_COUNT = "GenderCount";
	public static String PROP_DELIVERY_OUT_COME = "DeliveryOutCome";
	public static String PROP_GENDER_ID = "GenderId";


	// constructors
	public BasePhAncTerminationT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhAncTerminationT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhAncTerminationT (
		java.lang.Integer id,
		java.lang.String ancRegId) {

		this.setId(id);
		this.setAncRegId(ancRegId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ancRegId;
	private java.lang.Long genderId;
	private java.lang.String deliveryOutCome;
	private java.lang.Long genderCount;
	private java.lang.Long serverPk;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="termination_t_id"
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
	 * Return the value associated with the column: anc_reg_id
	 */
	public java.lang.String getAncRegId () {
		return ancRegId;
	}

	/**
	 * Set the value related to the column: anc_reg_id
	 * @param ancRegId the anc_reg_id value
	 */
	public void setAncRegId (java.lang.String ancRegId) {
		this.ancRegId = ancRegId;
	}



	/**
	 * Return the value associated with the column: gender_id
	 */
	public java.lang.Long getGenderId () {
		return genderId;
	}

	/**
	 * Set the value related to the column: gender_id
	 * @param genderId the gender_id value
	 */
	public void setGenderId (java.lang.Long genderId) {
		this.genderId = genderId;
	}



	/**
	 * Return the value associated with the column: delivery_out_come
	 */
	public java.lang.String getDeliveryOutCome () {
		return deliveryOutCome;
	}

	/**
	 * Set the value related to the column: delivery_out_come
	 * @param deliveryOutCome the delivery_out_come value
	 */
	public void setDeliveryOutCome (java.lang.String deliveryOutCome) {
		this.deliveryOutCome = deliveryOutCome;
	}



	/**
	 * Return the value associated with the column: gender_count
	 */
	public java.lang.Long getGenderCount () {
		return genderCount;
	}

	/**
	 * Set the value related to the column: gender_count
	 * @param genderCount the gender_count value
	 */
	public void setGenderCount (java.lang.Long genderCount) {
		this.genderCount = genderCount;
	}



	/**
	 * Return the value associated with the column: server_pk
	 */
	public java.lang.Long getServerPk () {
		return serverPk;
	}

	/**
	 * Set the value related to the column: server_pk
	 * @param serverPk the server_pk value
	 */
	public void setServerPk (java.lang.Long serverPk) {
		this.serverPk = serverPk;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhAncTerminationT)) return false;
		else {
			jkt.hms.masters.business.PhAncTerminationT phAncTerminationT = (jkt.hms.masters.business.PhAncTerminationT) obj;
			if (null == this.getId() || null == phAncTerminationT.getId()) return false;
			else return (this.getId().equals(phAncTerminationT.getId()));
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