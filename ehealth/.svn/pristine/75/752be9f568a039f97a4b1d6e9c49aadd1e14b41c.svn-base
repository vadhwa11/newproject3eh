package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_diet_requisition_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_diet_requisition_details"
 */

public abstract class BaseIpdDietRequisitionDetails  implements Serializable {

	public static String REF = "IpdDietRequisitionDetails";
	public static String PROP_DIET_COMBINATION = "DietCombination";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_DIET_ITEMS = "DietItems";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_ISSUE_REMARKS = "IssueRemarks";
	public static String PROP_DIET_REQUISITION_HEADER = "DietRequisitionHeader";
	public static String PROP_ISSUE_STATUS = "IssueStatus";


	// constructors
	public BaseIpdDietRequisitionDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdDietRequisitionDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIpdDietRequisitionDetails (
		java.lang.Integer id,
		java.lang.String issueStatus) {

		this.setId(id);
		this.setIssueStatus(issueStatus);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date issueDate;
	private java.lang.String issueRemarks;
	private java.lang.String issueStatus;
	private java.lang.Float quantity;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasDietCombination dietCombination;
	private jkt.hms.masters.business.MasDietItems dietItems;
	private jkt.hms.masters.business.IpdDietRequisitionHeader dietRequisitionHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="diet_requisition_details_id"
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
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
	}



	/**
	 * Return the value associated with the column: issue_remarks
	 */
	public java.lang.String getIssueRemarks () {
		return issueRemarks;
	}

	/**
	 * Set the value related to the column: issue_remarks
	 * @param issueRemarks the issue_remarks value
	 */
	public void setIssueRemarks (java.lang.String issueRemarks) {
		this.issueRemarks = issueRemarks;
	}



	/**
	 * Return the value associated with the column: issue_status
	 */
	public java.lang.String getIssueStatus () {
		return issueStatus;
	}

	/**
	 * Set the value related to the column: issue_status
	 * @param issueStatus the issue_status value
	 */
	public void setIssueStatus (java.lang.String issueStatus) {
		this.issueStatus = issueStatus;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Float getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Float quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: diet_combination_id
	 */
	public jkt.hms.masters.business.MasDietCombination getDietCombination () {
		return dietCombination;
	}

	/**
	 * Set the value related to the column: diet_combination_id
	 * @param dietCombination the diet_combination_id value
	 */
	public void setDietCombination (jkt.hms.masters.business.MasDietCombination dietCombination) {
		this.dietCombination = dietCombination;
	}



	/**
	 * Return the value associated with the column: diet_items_id
	 */
	public jkt.hms.masters.business.MasDietItems getDietItems () {
		return dietItems;
	}

	/**
	 * Set the value related to the column: diet_items_id
	 * @param dietItems the diet_items_id value
	 */
	public void setDietItems (jkt.hms.masters.business.MasDietItems dietItems) {
		this.dietItems = dietItems;
	}



	/**
	 * Return the value associated with the column: diet_requisition_header_id
	 */
	public jkt.hms.masters.business.IpdDietRequisitionHeader getDietRequisitionHeader () {
		return dietRequisitionHeader;
	}

	/**
	 * Set the value related to the column: diet_requisition_header_id
	 * @param dietRequisitionHeader the diet_requisition_header_id value
	 */
	public void setDietRequisitionHeader (jkt.hms.masters.business.IpdDietRequisitionHeader dietRequisitionHeader) {
		this.dietRequisitionHeader = dietRequisitionHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdDietRequisitionDetails)) return false;
		else {
			jkt.hms.masters.business.IpdDietRequisitionDetails ipdDietRequisitionDetails = (jkt.hms.masters.business.IpdDietRequisitionDetails) obj;
			if (null == this.getId() || null == ipdDietRequisitionDetails.getId()) return false;
			else return (this.getId().equals(ipdDietRequisitionDetails.getId()));
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