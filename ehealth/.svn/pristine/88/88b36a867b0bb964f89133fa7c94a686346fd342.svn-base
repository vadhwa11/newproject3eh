package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tbl_time_sheet_submission table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tbl_time_sheet_submission"
 */

public abstract class BaseTblTimeSheetSubmission  implements Serializable {

	public static String REF = "TblTimeSheetSubmission";
	public static String PROP_SUBMIT_DATE = "SubmitDate";
	public static String PROP_EMP = "Emp";
	public static String PROP_NO_OF_TIME_SUBMIT = "NoOfTimeSubmit";
	public static String PROP_ID = "Id";


	// constructors
	public BaseTblTimeSheetSubmission () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTblTimeSheetSubmission (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date submitDate;
	private java.lang.Integer noOfTimeSubmit;

	// many to one
	private jkt.hms.masters.business.MasEmployee emp;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: submit_date
	 */
	public java.util.Date getSubmitDate () {
		return submitDate;
	}

	/**
	 * Set the value related to the column: submit_date
	 * @param submitDate the submit_date value
	 */
	public void setSubmitDate (java.util.Date submitDate) {
		this.submitDate = submitDate;
	}



	/**
	 * Return the value associated with the column: no_of_time_submit
	 */
	public java.lang.Integer getNoOfTimeSubmit () {
		return noOfTimeSubmit;
	}

	/**
	 * Set the value related to the column: no_of_time_submit
	 * @param noOfTimeSubmit the no_of_time_submit value
	 */
	public void setNoOfTimeSubmit (java.lang.Integer noOfTimeSubmit) {
		this.noOfTimeSubmit = noOfTimeSubmit;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp () {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param emp the emp_id value
	 */
	public void setEmp (jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.TblTimeSheetSubmission)) return false;
		else {
			jkt.hrms.masters.business.TblTimeSheetSubmission tblTimeSheetSubmission = (jkt.hrms.masters.business.TblTimeSheetSubmission) obj;
			if (null == this.getId() || null == tblTimeSheetSubmission.getId()) return false;
			else return (this.getId().equals(tblTimeSheetSubmission.getId()));
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