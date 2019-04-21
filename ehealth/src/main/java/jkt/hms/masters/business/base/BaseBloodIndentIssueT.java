package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_indent_issue_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_indent_issue_t"
 */

public abstract class BaseBloodIndentIssueT  implements Serializable {

	public static String REF = "BloodIndentIssueT";
	public static String PROP_INDENT_M = "IndentM";
	public static String PROP_BAG_NO = "BagNo";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_ISSUED_QUANTITY = "IssuedQuantity";
	public static String PROP_BLOOD_COMPONENT = "BloodComponent";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBloodIndentIssueT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodIndentIssueT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBloodIndentIssueT (
		java.lang.Integer id,
		jkt.hms.masters.business.BloodIndentIssueM indentM) {

		this.setId(id);
		this.setIndentM(indentM);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal issuedQuantity;
	private java.lang.String bagNo;

	// many to one
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.BloodMasComponent bloodComponent;
	private jkt.hms.masters.business.BloodIndentIssueM indentM;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="indent_t_id"
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
	 * Return the value associated with the column: issued_quantity
	 */
	public java.math.BigDecimal getIssuedQuantity () {
		return issuedQuantity;
	}

	/**
	 * Set the value related to the column: issued_quantity
	 * @param issuedQuantity the issued_quantity value
	 */
	public void setIssuedQuantity (java.math.BigDecimal issuedQuantity) {
		this.issuedQuantity = issuedQuantity;
	}



	/**
	 * Return the value associated with the column: bag_no
	 */
	public java.lang.String getBagNo () {
		return bagNo;
	}

	/**
	 * Set the value related to the column: bag_no
	 * @param bagNo the bag_no value
	 */
	public void setBagNo (java.lang.String bagNo) {
		this.bagNo = bagNo;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroup the blood_group_id value
	 */
	public void setBloodGroup (jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: blood_component_id
	 */
	public jkt.hms.masters.business.BloodMasComponent getBloodComponent () {
		return bloodComponent;
	}

	/**
	 * Set the value related to the column: blood_component_id
	 * @param bloodComponent the blood_component_id value
	 */
	public void setBloodComponent (jkt.hms.masters.business.BloodMasComponent bloodComponent) {
		this.bloodComponent = bloodComponent;
	}



	/**
	 * Return the value associated with the column: indent_m_id
	 */
	public jkt.hms.masters.business.BloodIndentIssueM getIndentM () {
		return indentM;
	}

	/**
	 * Set the value related to the column: indent_m_id
	 * @param indentM the indent_m_id value
	 */
	public void setIndentM (jkt.hms.masters.business.BloodIndentIssueM indentM) {
		this.indentM = indentM;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodIndentIssueT)) return false;
		else {
			jkt.hms.masters.business.BloodIndentIssueT bloodIndentIssueT = (jkt.hms.masters.business.BloodIndentIssueT) obj;
			if (null == this.getId() || null == bloodIndentIssueT.getId()) return false;
			else return (this.getId().equals(bloodIndentIssueT.getId()));
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