package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_sanctioned_post_order table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_sanctioned_post_order"
 */

public abstract class BaseHrMasSanctionedPostOrder  implements Serializable {

	public static String REF = "HrMasSanctionedPostOrder";
	public static String PROP_CADRE = "Cadre";
	public static String PROP_STATUS = "Status";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_DATE = "OrderDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_TYPE = "Type";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NO_OF_POSTS = "NoOfPosts";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrMasSanctionedPostOrder () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasSanctionedPostOrder (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String orderNo;
	private java.util.Date orderDate;
	private int noOfPosts;
	private java.lang.String description;
	private java.lang.String type;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasCadre cadre;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="office_order_id"
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
	 * Return the value associated with the column: order_no
	 */
	public java.lang.String getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.String orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: order_date
	 */
	public java.util.Date getOrderDate () {
		return orderDate;
	}

	/**
	 * Set the value related to the column: order_date
	 * @param orderDate the order_date value
	 */
	public void setOrderDate (java.util.Date orderDate) {
		this.orderDate = orderDate;
	}



	/**
	 * Return the value associated with the column: no_of_posts
	 */
	public int getNoOfPosts () {
		return noOfPosts;
	}

	/**
	 * Set the value related to the column: no_of_posts
	 * @param noOfPosts the no_of_posts value
	 */
	public void setNoOfPosts (int noOfPosts) {
		this.noOfPosts = noOfPosts;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
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
	 * Return the value associated with the column: cadre_id
	 */
	public jkt.hms.masters.business.MasCadre getCadre () {
		return cadre;
	}

	/**
	 * Set the value related to the column: cadre_id
	 * @param cadre the cadre_id value
	 */
	public void setCadre (jkt.hms.masters.business.MasCadre cadre) {
		this.cadre = cadre;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasSanctionedPostOrder)) return false;
		else {
			jkt.hms.masters.business.HrMasSanctionedPostOrder hrMasSanctionedPostOrder = (jkt.hms.masters.business.HrMasSanctionedPostOrder) obj;
			if (null == this.getId() || null == hrMasSanctionedPostOrder.getId()) return false;
			else return (this.getId().equals(hrMasSanctionedPostOrder.getId()));
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