package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_fp_reg_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_fp_reg_detail"
 */

public abstract class BasePhFpRegDetail  implements Serializable {

	public static String REF = "PhFpRegDetail";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_METHOD_NAME = "MethodName";
	public static String PROP_TYPE = "Type";
	public static String PROP_COMPLICATION = "Complication";
	public static String PROP_USER_F = "UserF";
	public static String PROP_ITEM_NO = "ItemNo";
	public static String PROP_METHOD_TYPE = "MethodType";
	public static String PROP_REG_ID = "RegId";
	public static String PROP_ITEM_ISSUE = "ItemIssue";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_ADOPTION = "DateOfAdoption";


	// constructors
	public BasePhFpRegDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhFpRegDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String regId;
	private java.lang.String methodType;
	private java.lang.String userF;
	private java.lang.String methodName;
	private java.util.Date dateOfAdoption;
	private java.lang.String complication;
	private java.lang.String itemIssue;
	private java.util.Date issueDate;
	private java.lang.Long itemNo;
	private java.lang.String type;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="fp_reg_detail_id"
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
	 * Return the value associated with the column: reg_id
	 */
	public java.lang.String getRegId () {
		return regId;
	}

	/**
	 * Set the value related to the column: reg_id
	 * @param regId the reg_id value
	 */
	public void setRegId (java.lang.String regId) {
		this.regId = regId;
	}



	/**
	 * Return the value associated with the column: method_type
	 */
	public java.lang.String getMethodType () {
		return methodType;
	}

	/**
	 * Set the value related to the column: method_type
	 * @param methodType the method_type value
	 */
	public void setMethodType (java.lang.String methodType) {
		this.methodType = methodType;
	}



	/**
	 * Return the value associated with the column: user_f
	 */
	public java.lang.String getUserF () {
		return userF;
	}

	/**
	 * Set the value related to the column: user_f
	 * @param userF the user_f value
	 */
	public void setUserF (java.lang.String userF) {
		this.userF = userF;
	}



	/**
	 * Return the value associated with the column: method_name
	 */
	public java.lang.String getMethodName () {
		return methodName;
	}

	/**
	 * Set the value related to the column: method_name
	 * @param methodName the method_name value
	 */
	public void setMethodName (java.lang.String methodName) {
		this.methodName = methodName;
	}



	/**
	 * Return the value associated with the column: date_of_adoption
	 */
	public java.util.Date getDateOfAdoption () {
		return dateOfAdoption;
	}

	/**
	 * Set the value related to the column: date_of_adoption
	 * @param dateOfAdoption the date_of_adoption value
	 */
	public void setDateOfAdoption (java.util.Date dateOfAdoption) {
		this.dateOfAdoption = dateOfAdoption;
	}



	/**
	 * Return the value associated with the column: complication
	 */
	public java.lang.String getComplication () {
		return complication;
	}

	/**
	 * Set the value related to the column: complication
	 * @param complication the complication value
	 */
	public void setComplication (java.lang.String complication) {
		this.complication = complication;
	}



	/**
	 * Return the value associated with the column: item_issue
	 */
	public java.lang.String getItemIssue () {
		return itemIssue;
	}

	/**
	 * Set the value related to the column: item_issue
	 * @param itemIssue the item_issue value
	 */
	public void setItemIssue (java.lang.String itemIssue) {
		this.itemIssue = itemIssue;
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
	 * Return the value associated with the column: item_no
	 */
	public java.lang.Long getItemNo () {
		return itemNo;
	}

	/**
	 * Set the value related to the column: item_no
	 * @param itemNo the item_no value
	 */
	public void setItemNo (java.lang.Long itemNo) {
		this.itemNo = itemNo;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhFpRegDetail)) return false;
		else {
			jkt.hms.masters.business.PhFpRegDetail phFpRegDetail = (jkt.hms.masters.business.PhFpRegDetail) obj;
			if (null == this.getId() || null == phFpRegDetail.getId()) return false;
			else return (this.getId().equals(phFpRegDetail.getId()));
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