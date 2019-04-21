package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the uploads table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="uploads"
 */

public abstract class BaseUploads implements Serializable {

	public static String REF = "Uploads";
	public static String PROP_BINARYFILE = "Binaryfile";
	public static String PROP_FILENAME = "Filename";
	public static String PROP_ID = "Id";

	// constructors
	public BaseUploads() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUploads(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String filename;
	private byte[] binaryfile;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="assigned" column="UPLOADID"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: FILENAME
	 */
	public java.lang.String getFilename() {
		return filename;
	}

	/**
	 * Set the value related to the column: FILENAME
	 * 
	 * @param filename
	 *            the FILENAME value
	 */
	public void setFilename(java.lang.String filename) {
		this.filename = filename;
	}

	/**
	 * Return the value associated with the column: BINARYFILE
	 */
	public byte[] getBinaryfile() {
		return binaryfile;
	}

	/**
	 * Set the value related to the column: BINARYFILE
	 * 
	 * @param binaryfile
	 *            the BINARYFILE value
	 */
	public void setBinaryfile(byte[] binaryfile) {
		this.binaryfile = binaryfile;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Uploads)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Uploads uploads = (jkt.hrms.recruitment.masters.business.Uploads) obj;
			if (null == this.getId() || null == uploads.getId()) {
				return false;
			} else {
				return (this.getId().equals(uploads.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}