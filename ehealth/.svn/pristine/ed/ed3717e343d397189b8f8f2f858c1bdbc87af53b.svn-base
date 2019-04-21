package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_images_display table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_images_display"
 */

public abstract class BaseMasImagesDisplay  implements Serializable {

	public static String REF = "MasImagesDisplay";
	public static String PROP_USER_TEXT = "UserText";
	public static String PROP_IMAGES_PATH = "ImagesPath";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VIDEO_PATH = "VideoPath";
	public static String PROP_UPLOAD_IMAGES = "UploadImages";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_DOCUMENT_CONTENT_TYPE = "DocumentContentType";
	public static String PROP_VIDEO = "Video";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_TIMING = "Timing";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseMasImagesDisplay () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasImagesDisplay (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private byte[] uploadImages;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.String timing;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String imagesPath;
	private java.lang.String userText;
	private java.lang.String documentContentType;
	private byte[] video;
	private java.lang.String videoPath;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;



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
	 * Return the value associated with the column: upload_images
	 */
	public byte[] getUploadImages () {
		return uploadImages;
	}

	/**
	 * Set the value related to the column: upload_images
	 * @param uploadImages the upload_images value
	 */
	public void setUploadImages (byte[] uploadImages) {
		this.uploadImages = uploadImages;
	}



	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
	}



	/**
	 * Return the value associated with the column: timing
	 */
	public java.lang.String getTiming () {
		return timing;
	}

	/**
	 * Set the value related to the column: timing
	 * @param timing the timing value
	 */
	public void setTiming (java.lang.String timing) {
		this.timing = timing;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: images_path
	 */
	public java.lang.String getImagesPath () {
		return imagesPath;
	}

	/**
	 * Set the value related to the column: images_path
	 * @param imagesPath the images_path value
	 */
	public void setImagesPath (java.lang.String imagesPath) {
		this.imagesPath = imagesPath;
	}



	/**
	 * Return the value associated with the column: user_text
	 */
	public java.lang.String getUserText () {
		return userText;
	}

	/**
	 * Set the value related to the column: user_text
	 * @param userText the user_text value
	 */
	public void setUserText (java.lang.String userText) {
		this.userText = userText;
	}



	/**
	 * Return the value associated with the column: document_content_type
	 */
	public java.lang.String getDocumentContentType () {
		return documentContentType;
	}

	/**
	 * Set the value related to the column: document_content_type
	 * @param documentContentType the document_content_type value
	 */
	public void setDocumentContentType (java.lang.String documentContentType) {
		this.documentContentType = documentContentType;
	}



	/**
	 * Return the value associated with the column: video
	 */
	public byte[] getVideo () {
		return video;
	}

	/**
	 * Set the value related to the column: video
	 * @param video the video value
	 */
	public void setVideo (byte[] video) {
		this.video = video;
	}



	/**
	 * Return the value associated with the column: video_path
	 */
	public java.lang.String getVideoPath () {
		return videoPath;
	}

	/**
	 * Set the value related to the column: video_path
	 * @param videoPath the video_path value
	 */
	public void setVideoPath (java.lang.String videoPath) {
		this.videoPath = videoPath;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasImagesDisplay)) return false;
		else {
			jkt.hms.masters.business.MasImagesDisplay masImagesDisplay = (jkt.hms.masters.business.MasImagesDisplay) obj;
			if (null == this.getId() || null == masImagesDisplay.getId()) return false;
			else return (this.getId().equals(masImagesDisplay.getId()));
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