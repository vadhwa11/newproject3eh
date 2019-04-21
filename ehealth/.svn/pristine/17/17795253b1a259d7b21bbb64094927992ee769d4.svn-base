package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_schedule_document table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_schedule_document"
 */

public abstract class BasePrjScheduleDocument  implements Serializable {

	public static String REF = "PrjScheduleDocument";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_ID = "Id";
	public static String PROP_SCHEDULE_DETAIL = "ScheduleDetail";


	// constructors
	public BasePrjScheduleDocument () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjScheduleDocument (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fileName;
	private java.lang.String comment;

	// many to one
	private jkt.hrms.masters.business.PrjScheduleDetail scheduleDetail;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="schedule_document_id"
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
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: comment
	 */
	public java.lang.String getComment () {
		return comment;
	}

	/**
	 * Set the value related to the column: comment
	 * @param comment the comment value
	 */
	public void setComment (java.lang.String comment) {
		this.comment = comment;
	}



	/**
	 * Return the value associated with the column: schedule_detail_id
	 */
	public jkt.hrms.masters.business.PrjScheduleDetail getScheduleDetail () {
		return scheduleDetail;
	}

	/**
	 * Set the value related to the column: schedule_detail_id
	 * @param scheduleDetail the schedule_detail_id value
	 */
	public void setScheduleDetail (jkt.hrms.masters.business.PrjScheduleDetail scheduleDetail) {
		this.scheduleDetail = scheduleDetail;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjScheduleDocument)) return false;
		else {
			jkt.hrms.masters.business.PrjScheduleDocument prjScheduleDocument = (jkt.hrms.masters.business.PrjScheduleDocument) obj;
			if (null == this.getId() || null == prjScheduleDocument.getId()) return false;
			else return (this.getId().equals(prjScheduleDocument.getId()));
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