package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * bl_pymnt_advice_disp_details table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_pymnt_advice_disp_details"
 */

public abstract class BaseBlPymntAdviceDispDetails implements Serializable {

	public static String REF = "BlPymntAdviceDispDetails";
	public static String PROP_ADVICE_QTY = "AdviceQty";
	public static String PROP_BATCH = "Batch";
	public static String PROP_REFUNDED = "Refunded";
	public static String PROP_ITEM = "Item";
	public static String PROP_ADVICE_AMT = "AdviceAmt";
	public static String PROP_ADVICE_CHARITY_AMT = "AdviceCharityAmt";
	public static String PROP_PYMNT_ADVICE_DISP_HEADER = "PymntAdviceDispHeader";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlPymntAdviceDispDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPymntAdviceDispDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal adviceQty;
	private java.math.BigDecimal adviceAmt;
	private java.math.BigDecimal adviceCharityAmt;
	private java.lang.String refunded;

	// many to one
	private jkt.hms.masters.business.StoreItemBatchStock batch;
	private jkt.hms.masters.business.BlPymntAdviceDispHeader pymntAdviceDispHeader;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="pymnt_advice_disp_details_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: advice_qty
	 */
	public java.math.BigDecimal getAdviceQty() {
		return adviceQty;
	}

	/**
	 * Set the value related to the column: advice_qty
	 * 
	 * @param adviceQty
	 *            the advice_qty value
	 */
	public void setAdviceQty(java.math.BigDecimal adviceQty) {
		this.adviceQty = adviceQty;
	}

	/**
	 * Return the value associated with the column: advice_amt
	 */
	public java.math.BigDecimal getAdviceAmt() {
		return adviceAmt;
	}

	/**
	 * Set the value related to the column: advice_amt
	 * 
	 * @param adviceAmt
	 *            the advice_amt value
	 */
	public void setAdviceAmt(java.math.BigDecimal adviceAmt) {
		this.adviceAmt = adviceAmt;
	}

	/**
	 * Return the value associated with the column: advice_charity_amt
	 */
	public java.math.BigDecimal getAdviceCharityAmt() {
		return adviceCharityAmt;
	}

	/**
	 * Set the value related to the column: advice_charity_amt
	 * 
	 * @param adviceCharityAmt
	 *            the advice_charity_amt value
	 */
	public void setAdviceCharityAmt(java.math.BigDecimal adviceCharityAmt) {
		this.adviceCharityAmt = adviceCharityAmt;
	}

	/**
	 * Return the value associated with the column: refunded
	 */
	public java.lang.String getRefunded() {
		return refunded;
	}

	/**
	 * Set the value related to the column: refunded
	 * 
	 * @param refunded
	 *            the refunded value
	 */
	public void setRefunded(java.lang.String refunded) {
		this.refunded = refunded;
	}

	/**
	 * Return the value associated with the column: batch_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getBatch() {
		return batch;
	}

	/**
	 * Set the value related to the column: batch_id
	 * 
	 * @param batch
	 *            the batch_id value
	 */
	public void setBatch(jkt.hms.masters.business.StoreItemBatchStock batch) {
		this.batch = batch;
	}

	/**
	 * Return the value associated with the column: pymnt_advice_disp_header_id
	 */
	public jkt.hms.masters.business.BlPymntAdviceDispHeader getPymntAdviceDispHeader() {
		return pymntAdviceDispHeader;
	}

	/**
	 * Set the value related to the column: pymnt_advice_disp_header_id
	 * 
	 * @param pymntAdviceDispHeader
	 *            the pymnt_advice_disp_header_id value
	 */
	public void setPymntAdviceDispHeader(
			jkt.hms.masters.business.BlPymntAdviceDispHeader pymntAdviceDispHeader) {
		this.pymntAdviceDispHeader = pymntAdviceDispHeader;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlPymntAdviceDispDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.BlPymntAdviceDispDetails blPymntAdviceDispDetails = (jkt.hms.masters.business.BlPymntAdviceDispDetails) obj;
			if (null == this.getId()
					|| null == blPymntAdviceDispDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(blPymntAdviceDispDetails.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}