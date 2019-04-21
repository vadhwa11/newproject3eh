package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_mas_investigation_report_template table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_mas_investigation_report_template"
 */

public abstract class BaseDgMasInvestigationReportTemplate  implements Serializable {

	public static String REF = "DgMasInvestigationReportTemplate";
	public static String PROP_SEQ = "Seq";
	public static String PROP_GROUP_NAME = "GroupName";
	public static String PROP_INVESTIGATION_ID = "InvestigationId";
	public static String PROP_GROUP_SEQ = "GroupSeq";
	public static String PROP_REPORT_NAME = "ReportName";
	public static String PROP_ID = "Id";
	public static String PROP_STATUS = "Status";


	// constructors
	public BaseDgMasInvestigationReportTemplate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgMasInvestigationReportTemplate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String groupName;
	private java.lang.String status;
	private java.lang.Integer groupSeq;
	private java.lang.String reportName;
	private java.lang.Integer seq;

	// many to one
	private jkt.hms.masters.business.DgMasInvestigation investigationId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: group_name
	 */
	public java.lang.String getGroupName () {
		return groupName;
	}

	/**
	 * Set the value related to the column: group_name
	 * @param groupName the group_name value
	 */
	public void setGroupName (java.lang.String groupName) {
		this.groupName = groupName;
	}
	
	
	/**
	 * Return the value associated with the column: group_name
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: group_name
	 * @param groupName the group_name value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: group_seq
	 */
	public java.lang.Integer getGroupSeq () {
		return groupSeq;
	}

	/**
	 * Set the value related to the column: group_seq
	 * @param groupSeq the group_seq value
	 */
	public void setGroupSeq (java.lang.Integer groupSeq) {
		this.groupSeq = groupSeq;
	}



	/**
	 * Return the value associated with the column: report_name
	 */
	public java.lang.String getReportName () {
		return reportName;
	}

	/**
	 * Set the value related to the column: report_name
	 * @param reportName the report_name value
	 */
	public void setReportName (java.lang.String reportName) {
		this.reportName = reportName;
	}



	/**
	 * Return the value associated with the column: seq
	 */
	public java.lang.Integer getSeq () {
		return seq;
	}

	/**
	 * Set the value related to the column: seq
	 * @param seq the seq value
	 */
	public void setSeq (java.lang.Integer seq) {
		this.seq = seq;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigationId () {
		return investigationId;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigationId the investigation_id value
	 */
	public void setInvestigationId (jkt.hms.masters.business.DgMasInvestigation investigationId) {
		this.investigationId = investigationId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgMasInvestigationReportTemplate)) return false;
		else {
			jkt.hms.masters.business.DgMasInvestigationReportTemplate dgMasInvestigationReportTemplate = (jkt.hms.masters.business.DgMasInvestigationReportTemplate) obj;
			if (null == this.getId() || null == dgMasInvestigationReportTemplate.getId()) return false;
			else return (this.getId().equals(dgMasInvestigationReportTemplate.getId()));
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