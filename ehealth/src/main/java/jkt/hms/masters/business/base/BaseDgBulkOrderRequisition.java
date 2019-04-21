package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_bulk_order_requisition table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_bulk_order_requisition"
 */

public abstract class BaseDgBulkOrderRequisition  implements Serializable {

	public static String REF = "DgBulkOrderRequisition";
	public static String PROP_ORDER_TIME = "OrderTime";
	public static String PROP_ORDER_DATE = "OrderDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_ORDER_BY = "OrderBy";
	public static String PROP_ORDER_TYPE = "OrderType";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_INSTITUTE = "Institute";


	// constructors
	public BaseDgBulkOrderRequisition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgBulkOrderRequisition (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String orderType;
	private java.lang.String orderNo;
	private java.util.Date orderDate;
	private java.lang.String orderTime;
	private java.lang.String remark;

	// many to one
	private jkt.hms.masters.business.MasHospital institute;
	private jkt.hms.masters.business.Users orderBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="bulk_order_id"
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
	 * Return the value associated with the column: order_type
	 */
	public java.lang.String getOrderType () {
		return orderType;
	}

	/**
	 * Set the value related to the column: order_type
	 * @param orderType the order_type value
	 */
	public void setOrderType (java.lang.String orderType) {
		this.orderType = orderType;
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
	 * Return the value associated with the column: order_time
	 */
	public java.lang.String getOrderTime () {
		return orderTime;
	}

	/**
	 * Set the value related to the column: order_time
	 * @param orderTime the order_time value
	 */
	public void setOrderTime (java.lang.String orderTime) {
		this.orderTime = orderTime;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
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



	/**
	 * Return the value associated with the column: order_by
	 */
	public jkt.hms.masters.business.Users getOrderBy () {
		return orderBy;
	}

	/**
	 * Set the value related to the column: order_by
	 * @param orderBy the order_by value
	 */
	public void setOrderBy (jkt.hms.masters.business.Users orderBy) {
		this.orderBy = orderBy;
	}



	/**
	 * Return the value associated with the column: DgOrderhds
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderhd> getDgOrderhds () {
		return dgOrderhds;
	}

	/**
	 * Set the value related to the column: DgOrderhds
	 * @param dgOrderhds the DgOrderhds value
	 */
	public void setDgOrderhds (java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds) {
		this.dgOrderhds = dgOrderhds;
	}

	public void addToDgOrderhds (jkt.hms.masters.business.DgOrderhd dgOrderhd) {
		if (null == getDgOrderhds()) setDgOrderhds(new java.util.TreeSet<jkt.hms.masters.business.DgOrderhd>());
		getDgOrderhds().add(dgOrderhd);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgBulkOrderRequisition)) return false;
		else {
			jkt.hms.masters.business.DgBulkOrderRequisition dgBulkOrderRequisition = (jkt.hms.masters.business.DgBulkOrderRequisition) obj;
			if (null == this.getId() || null == dgBulkOrderRequisition.getId()) return false;
			else return (this.getId().equals(dgBulkOrderRequisition.getId()));
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