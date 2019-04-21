package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseBloodAssessmentEntryT;



public class BloodAssessmentEntryT extends BaseBloodAssessmentEntryT {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BloodAssessmentEntryT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BloodAssessmentEntryT (java.lang.Integer id) {
		super(id);
	}

	public  BloodAssessmentEntryT(String assessmentResult,MasAssessment assessment,BloodAssessmentEntryM entryM){
		
		super(assessmentResult,assessment,entryM);
	}
/*[CONSTRUCTOR MARKER END]*/


}