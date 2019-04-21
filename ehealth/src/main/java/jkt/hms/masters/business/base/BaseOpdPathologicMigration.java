package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_pathologic_migration table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_pathologic_migration"
 */

public abstract class BaseOpdPathologicMigration  implements Serializable {

	public static String REF = "OpdPathologicMigration";
	public static String PROP_FLAG = "Flag";
	public static String PROP_TEETH8 = "Teeth8";
	public static String PROP_TEETH9 = "Teeth9";
	public static String PROP_TOOTH = "Tooth";
	public static String PROP_VISIT = "Visit";
	public static String PROP_TEETH16 = "Teeth16";
	public static String PROP_TEETH1 = "Teeth1";
	public static String PROP_TEETH15 = "Teeth15";
	public static String PROP_TEETH3 = "Teeth3";
	public static String PROP_TEETH2 = "Teeth2";
	public static String PROP_TEETH12 = "Teeth12";
	public static String PROP_TEETH5 = "Teeth5";
	public static String PROP_TEETH11 = "Teeth11";
	public static String PROP_TEETH4 = "Teeth4";
	public static String PROP_TEETH14 = "Teeth14";
	public static String PROP_TEETH7 = "Teeth7";
	public static String PROP_CASE_RECORD_PERIODONTICS_HEADER = "CaseRecordPeriodonticsHeader";
	public static String PROP_TEETH13 = "Teeth13";
	public static String PROP_TEETH6 = "Teeth6";
	public static String PROP_ID = "Id";
	public static String PROP_TEETH10 = "Teeth10";


	// constructors
	public BaseOpdPathologicMigration () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPathologicMigration (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String tooth;
	private java.lang.String flag;
	private java.lang.String teeth1;
	private java.lang.String teeth2;
	private java.lang.String teeth3;
	private java.lang.String teeth4;
	private java.lang.String teeth5;
	private java.lang.String teeth6;
	private java.lang.String teeth7;
	private java.lang.String teeth8;
	private java.lang.String teeth9;
	private java.lang.String teeth10;
	private java.lang.String teeth11;
	private java.lang.String teeth12;
	private java.lang.String teeth13;
	private java.lang.String teeth14;
	private java.lang.String teeth15;
	private java.lang.String teeth16;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader caseRecordPeriodonticsHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="pathologic_migration_id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: tooth
	 */
	public java.lang.String getTooth () {
		return tooth;
	}

	/**
	 * Set the value related to the column: tooth
	 * @param tooth the tooth value
	 */
	public void setTooth (java.lang.String tooth) {
		this.tooth = tooth;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: teeth_1
	 */
	public java.lang.String getTeeth1 () {
		return teeth1;
	}

	/**
	 * Set the value related to the column: teeth_1
	 * @param teeth1 the teeth_1 value
	 */
	public void setTeeth1 (java.lang.String teeth1) {
		this.teeth1 = teeth1;
	}



	/**
	 * Return the value associated with the column: teeth_2
	 */
	public java.lang.String getTeeth2 () {
		return teeth2;
	}

	/**
	 * Set the value related to the column: teeth_2
	 * @param teeth2 the teeth_2 value
	 */
	public void setTeeth2 (java.lang.String teeth2) {
		this.teeth2 = teeth2;
	}



	/**
	 * Return the value associated with the column: teeth_3
	 */
	public java.lang.String getTeeth3 () {
		return teeth3;
	}

	/**
	 * Set the value related to the column: teeth_3
	 * @param teeth3 the teeth_3 value
	 */
	public void setTeeth3 (java.lang.String teeth3) {
		this.teeth3 = teeth3;
	}



	/**
	 * Return the value associated with the column: teeth_4
	 */
	public java.lang.String getTeeth4 () {
		return teeth4;
	}

	/**
	 * Set the value related to the column: teeth_4
	 * @param teeth4 the teeth_4 value
	 */
	public void setTeeth4 (java.lang.String teeth4) {
		this.teeth4 = teeth4;
	}



	/**
	 * Return the value associated with the column: teeth_5
	 */
	public java.lang.String getTeeth5 () {
		return teeth5;
	}

	/**
	 * Set the value related to the column: teeth_5
	 * @param teeth5 the teeth_5 value
	 */
	public void setTeeth5 (java.lang.String teeth5) {
		this.teeth5 = teeth5;
	}



	/**
	 * Return the value associated with the column: teeth_6
	 */
	public java.lang.String getTeeth6 () {
		return teeth6;
	}

	/**
	 * Set the value related to the column: teeth_6
	 * @param teeth6 the teeth_6 value
	 */
	public void setTeeth6 (java.lang.String teeth6) {
		this.teeth6 = teeth6;
	}



	/**
	 * Return the value associated with the column: teeth_7
	 */
	public java.lang.String getTeeth7 () {
		return teeth7;
	}

	/**
	 * Set the value related to the column: teeth_7
	 * @param teeth7 the teeth_7 value
	 */
	public void setTeeth7 (java.lang.String teeth7) {
		this.teeth7 = teeth7;
	}



	/**
	 * Return the value associated with the column: teeth_8
	 */
	public java.lang.String getTeeth8 () {
		return teeth8;
	}

	/**
	 * Set the value related to the column: teeth_8
	 * @param teeth8 the teeth_8 value
	 */
	public void setTeeth8 (java.lang.String teeth8) {
		this.teeth8 = teeth8;
	}



	/**
	 * Return the value associated with the column: teeth_9
	 */
	public java.lang.String getTeeth9 () {
		return teeth9;
	}

	/**
	 * Set the value related to the column: teeth_9
	 * @param teeth9 the teeth_9 value
	 */
	public void setTeeth9 (java.lang.String teeth9) {
		this.teeth9 = teeth9;
	}



	/**
	 * Return the value associated with the column: teeth_10
	 */
	public java.lang.String getTeeth10 () {
		return teeth10;
	}

	/**
	 * Set the value related to the column: teeth_10
	 * @param teeth10 the teeth_10 value
	 */
	public void setTeeth10 (java.lang.String teeth10) {
		this.teeth10 = teeth10;
	}



	/**
	 * Return the value associated with the column: teeth_11
	 */
	public java.lang.String getTeeth11 () {
		return teeth11;
	}

	/**
	 * Set the value related to the column: teeth_11
	 * @param teeth11 the teeth_11 value
	 */
	public void setTeeth11 (java.lang.String teeth11) {
		this.teeth11 = teeth11;
	}



	/**
	 * Return the value associated with the column: teeth_12
	 */
	public java.lang.String getTeeth12 () {
		return teeth12;
	}

	/**
	 * Set the value related to the column: teeth_12
	 * @param teeth12 the teeth_12 value
	 */
	public void setTeeth12 (java.lang.String teeth12) {
		this.teeth12 = teeth12;
	}



	/**
	 * Return the value associated with the column: teeth_13
	 */
	public java.lang.String getTeeth13 () {
		return teeth13;
	}

	/**
	 * Set the value related to the column: teeth_13
	 * @param teeth13 the teeth_13 value
	 */
	public void setTeeth13 (java.lang.String teeth13) {
		this.teeth13 = teeth13;
	}



	/**
	 * Return the value associated with the column: teeth_14
	 */
	public java.lang.String getTeeth14 () {
		return teeth14;
	}

	/**
	 * Set the value related to the column: teeth_14
	 * @param teeth14 the teeth_14 value
	 */
	public void setTeeth14 (java.lang.String teeth14) {
		this.teeth14 = teeth14;
	}



	/**
	 * Return the value associated with the column: teeth_15
	 */
	public java.lang.String getTeeth15 () {
		return teeth15;
	}

	/**
	 * Set the value related to the column: teeth_15
	 * @param teeth15 the teeth_15 value
	 */
	public void setTeeth15 (java.lang.String teeth15) {
		this.teeth15 = teeth15;
	}



	/**
	 * Return the value associated with the column: teeth_16
	 */
	public java.lang.String getTeeth16 () {
		return teeth16;
	}

	/**
	 * Set the value related to the column: teeth_16
	 * @param teeth16 the teeth_16 value
	 */
	public void setTeeth16 (java.lang.String teeth16) {
		this.teeth16 = teeth16;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: case_record_periodontics_header_id
	 */
	public jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader getCaseRecordPeriodonticsHeader () {
		return caseRecordPeriodonticsHeader;
	}

	/**
	 * Set the value related to the column: case_record_periodontics_header_id
	 * @param caseRecordPeriodonticsHeader the case_record_periodontics_header_id value
	 */
	public void setCaseRecordPeriodonticsHeader (jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader caseRecordPeriodonticsHeader) {
		this.caseRecordPeriodonticsHeader = caseRecordPeriodonticsHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPathologicMigration)) return false;
		else {
			jkt.hms.masters.business.OpdPathologicMigration opdPathologicMigration = (jkt.hms.masters.business.OpdPathologicMigration) obj;
			if (null == this.getId() || null == opdPathologicMigration.getId()) return false;
			else return (this.getId().equals(opdPathologicMigration.getId()));
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