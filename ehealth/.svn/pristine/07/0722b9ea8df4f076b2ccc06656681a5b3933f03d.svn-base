package jkt.hms.masters.business.base;

import java.io.Serializable;

import jkt.hms.masters.business.BloodAssessmentEntryM;
import jkt.hms.masters.business.MasAssessment;


/**
 * This is an object that contains data related to the blood_assessment_entry_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_assessment_entry_t"
 */

public abstract class BaseBloodAssessmentEntryT  implements Serializable {

	public static String REF = "BloodAssessmentEntryT";
	public static String PROP_ASSESSMENT = "Assessment";
	public static String PROP_ENTRY_M = "EntryM";
	public static String PROP_ASSESSMENT_RESULT = "AssessmentResult";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBloodAssessmentEntryT () {
		initialize();
	}
	
	

	/**
	 * Constructor for primary key
	 */
	public BaseBloodAssessmentEntryT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String assessmentResult;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasAssessment assessment;
	private jkt.hms.masters.business.BloodAssessmentEntryM entryM;


	public  BaseBloodAssessmentEntryT(String assessmentResult,MasAssessment assessment,BloodAssessmentEntryM entryM){
	this.assessment=assessment;
	this.entryM=entryM;
	this.assessmentResult=assessmentResult;
	
	
}
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="entry_t_id"
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
	 * Return the value associated with the column: assessment_result
	 */
	public java.lang.String getAssessmentResult () {
		return assessmentResult;
	}

	/**
	 * Set the value related to the column: assessment_result
	 * @param assessmentResult the assessment_result value
	 */
	public void setAssessmentResult (java.lang.String assessmentResult) {
		this.assessmentResult = assessmentResult;
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
	 * Return the value associated with the column: assessment_id
	 */
	public jkt.hms.masters.business.MasAssessment getAssessment () {
		return assessment;
	}

	/**
	 * Set the value related to the column: assessment_id
	 * @param assessment the assessment_id value
	 */
	public void setAssessment (jkt.hms.masters.business.MasAssessment assessment) {
		this.assessment = assessment;
	}



	/**
	 * Return the value associated with the column: entry_m_id
	 */
	public jkt.hms.masters.business.BloodAssessmentEntryM getEntryM () {
		return entryM;
	}

	/**
	 * Set the value related to the column: entry_m_id
	 * @param entryM the entry_m_id value
	 */
	public void setEntryM (jkt.hms.masters.business.BloodAssessmentEntryM entryM) {
		this.entryM = entryM;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodAssessmentEntryT)) return false;
		else {
			jkt.hms.masters.business.BloodAssessmentEntryT bloodAssessmentEntryT = (jkt.hms.masters.business.BloodAssessmentEntryT) obj;
			if (null == this.getId() || null == bloodAssessmentEntryT.getId()) return false;
			else return (this.getId().equals(bloodAssessmentEntryT.getId()));
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