package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the student table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="student"
 */

public abstract class BaseStudent  implements Serializable {

	public static String REF = "Student";
	public static String PROP_ID = "Id";
	public static String PROP_SCHOOL = "School";
	public static String PROP_HIN = "Hin";
	public static String PROP_ACADEMIC_YEAR = "AcademicYear";
	public static String PROP_GR_NO = "GrNo";


	// constructors
	public BaseStudent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStudent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hin;
	private java.lang.Integer school;
	private java.lang.String grNo;
	private java.lang.Integer academicYear;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="student_id"
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
	 * Return the value associated with the column: hin_id
	 */
	public java.lang.Integer getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (java.lang.Integer hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: school_id
	 */
	public java.lang.Integer getSchool () {
		return school;
	}

	/**
	 * Set the value related to the column: school_id
	 * @param school the school_id value
	 */
	public void setSchool (java.lang.Integer school) {
		this.school = school;
	}



	/**
	 * Return the value associated with the column: gr_no
	 */
	public java.lang.String getGrNo () {
		return grNo;
	}

	/**
	 * Set the value related to the column: gr_no
	 * @param grNo the gr_no value
	 */
	public void setGrNo (java.lang.String grNo) {
		this.grNo = grNo;
	}



	/**
	 * Return the value associated with the column: academic_year_id
	 */
	public java.lang.Integer getAcademicYear () {
		return academicYear;
	}

	/**
	 * Set the value related to the column: academic_year_id
	 * @param academicYear the academic_year_id value
	 */
	public void setAcademicYear (java.lang.Integer academicYear) {
		this.academicYear = academicYear;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Student)) return false;
		else {
			jkt.hms.masters.business.Student student = (jkt.hms.masters.business.Student) obj;
			if (null == this.getId() || null == student.getId()) return false;
			else return (this.getId().equals(student.getId()));
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