package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the viewMasApplication table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="viewMasApplication"
 */

public abstract class BaseViewMasApplication  implements Serializable {

	public static String REF = "ViewMasApplication";
	public static String PROP_NAME = "Name";
	public static String PROP_STATUS = "Status";
	public static String PROP_PARENT_ID = "ParentId";
	public static String PROP_URL = "Url";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_USER_ID = "UserId";


	// constructors
	public BaseViewMasApplication () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewMasApplication (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String name;
	private java.lang.String parentId;
	private java.lang.String url;
	private java.lang.Integer orderNo;
	private java.lang.Integer userId;
	private String status;
	private java.lang.Integer hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="app_id"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: parent_id
	 */
	public java.lang.String getParentId () {
		return parentId;
	}

	/**
	 * Set the value related to the column: parent_id
	 * @param parentId the parent_id value
	 */
	public void setParentId (java.lang.String parentId) {
		this.parentId = parentId;
	}



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public java.lang.Integer getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param userId the user_id value
	 */
	public void setUserId (java.lang.Integer userId) {
		this.userId = userId;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ViewMasApplication)) return false;
		else {
			jkt.hms.masters.business.ViewMasApplication viewMasApplication = (jkt.hms.masters.business.ViewMasApplication) obj;
			if (null == this.getId() || null == viewMasApplication.getId()) return false;
			else return (this.getId().equals(viewMasApplication.getId()));
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