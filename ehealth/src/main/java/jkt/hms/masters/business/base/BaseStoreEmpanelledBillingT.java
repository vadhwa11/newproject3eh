package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_empanelled_billing_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_empanelled_billing_t"
 */

public abstract class BaseStoreEmpanelledBillingT  implements Serializable {

	public static String REF = "StoreEmpanelledBillingT";
	public static String PROP_STATUS = "Status";
	public static String PROP_EM_BILLING_M = "EmBillingM";
	public static String PROP_ITEM = "Item";
	public static String PROP_ISSUE_QTY = "IssueQty";
	public static String PROP_ID = "Id";
	public static String PROP_REQ_QTY = "ReqQty";
	public static String PROP_UNIT_RATE = "UnitRate";


	// constructors
	public BaseStoreEmpanelledBillingT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreEmpanelledBillingT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreEmpanelledBillingT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item,
		jkt.hms.masters.business.StoreEmpanelledBillingM emBillingM) {

		this.setId(id);
		this.setItem(item);
		this.setEmBillingM(emBillingM);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal reqQty;
	private java.math.BigDecimal issueQty;
	private java.math.BigDecimal unitRate;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreEmpanelledBillingM emBillingM;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="em_billing_t_id"
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
	 * Return the value associated with the column: req_qty
	 */
	public java.math.BigDecimal getReqQty () {
		return reqQty;
	}

	/**
	 * Set the value related to the column: req_qty
	 * @param reqQty the req_qty value
	 */
	public void setReqQty (java.math.BigDecimal reqQty) {
		this.reqQty = reqQty;
	}



	/**
	 * Return the value associated with the column: issue_qty
	 */
	public java.math.BigDecimal getIssueQty () {
		return issueQty;
	}

	/**
	 * Set the value related to the column: issue_qty
	 * @param issueQty the issue_qty value
	 */
	public void setIssueQty (java.math.BigDecimal issueQty) {
		this.issueQty = issueQty;
	}



	/**
	 * Return the value associated with the column: unit_rate
	 */
	public java.math.BigDecimal getUnitRate () {
		return unitRate;
	}

	/**
	 * Set the value related to the column: unit_rate
	 * @param unitRate the unit_rate value
	 */
	public void setUnitRate (java.math.BigDecimal unitRate) {
		this.unitRate = unitRate;
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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: em_billing_m_id
	 */
	public jkt.hms.masters.business.StoreEmpanelledBillingM getEmBillingM () {
		return emBillingM;
	}

	/**
	 * Set the value related to the column: em_billing_m_id
	 * @param emBillingM the em_billing_m_id value
	 */
	public void setEmBillingM (jkt.hms.masters.business.StoreEmpanelledBillingM emBillingM) {
		this.emBillingM = emBillingM;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreEmpanelledBillingT)) return false;
		else {
			jkt.hms.masters.business.StoreEmpanelledBillingT storeEmpanelledBillingT = (jkt.hms.masters.business.StoreEmpanelledBillingT) obj;
			if (null == this.getId() || null == storeEmpanelledBillingT.getId()) return false;
			else return (this.getId().equals(storeEmpanelledBillingT.getId()));
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