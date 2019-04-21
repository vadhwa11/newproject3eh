package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_tender_invitation_letter table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_tender_invitation_letter"
 */

public abstract class BaseStoreTenderInvitationLetter  implements Serializable {

	public static String REF = "StoreTenderInvitationLetter";
	public static String PROP_FILE_NO = "FileNo";
	public static String PROP_SUBJECT = "Subject";
	public static String PROP_FILE_EXTENSION = "FileExtension";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_ID = "Id";
	public static String PROP_LETTER_DATE = "LetterDate";
	public static String PROP_FILE_DOCUMENT = "FileDocument";
	public static String PROP_CONTENT = "Content";


	// constructors
	public BaseStoreTenderInvitationLetter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderInvitationLetter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fileNo;
	private java.util.Date letterDate;
	private java.lang.String subject;
	private java.lang.String content;
	private byte[] fileDocument;
	private java.lang.String fileName;
	private java.lang.String fileExtension;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> storeTenderInvitaLetterToVenders;



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
	 * Return the value associated with the column: file_no
	 */
	public java.lang.String getFileNo () {
		return fileNo;
	}

	/**
	 * Set the value related to the column: file_no
	 * @param fileNo the file_no value
	 */
	public void setFileNo (java.lang.String fileNo) {
		this.fileNo = fileNo;
	}



	/**
	 * Return the value associated with the column: letter_date
	 */
	public java.util.Date getLetterDate () {
		return letterDate;
	}

	/**
	 * Set the value related to the column: letter_date
	 * @param letterDate the letter_date value
	 */
	public void setLetterDate (java.util.Date letterDate) {
		this.letterDate = letterDate;
	}



	/**
	 * Return the value associated with the column: subject
	 */
	public java.lang.String getSubject () {
		return subject;
	}

	/**
	 * Set the value related to the column: subject
	 * @param subject the subject value
	 */
	public void setSubject (java.lang.String subject) {
		this.subject = subject;
	}



	/**
	 * Return the value associated with the column: content
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: content
	 * @param content the content value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}



	/**
	 * Return the value associated with the column: file_document
	 */
	public byte[] getFileDocument () {
		return fileDocument;
	}

	/**
	 * Set the value related to the column: file_document
	 * @param fileDocument the file_document value
	 */
	public void setFileDocument (byte[] fileDocument) {
		this.fileDocument = fileDocument;
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
	 * Return the value associated with the column: file_extension
	 */
	public java.lang.String getFileExtension () {
		return fileExtension;
	}

	/**
	 * Set the value related to the column: file_extension
	 * @param fileExtension the file_extension value
	 */
	public void setFileExtension (java.lang.String fileExtension) {
		this.fileExtension = fileExtension;
	}



	/**
	 * Return the value associated with the column: StoreTenderInvitaLetterToVenders
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> getStoreTenderInvitaLetterToVenders () {
		return storeTenderInvitaLetterToVenders;
	}

	/**
	 * Set the value related to the column: StoreTenderInvitaLetterToVenders
	 * @param storeTenderInvitaLetterToVenders the StoreTenderInvitaLetterToVenders value
	 */
	public void setStoreTenderInvitaLetterToVenders (java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> storeTenderInvitaLetterToVenders) {
		this.storeTenderInvitaLetterToVenders = storeTenderInvitaLetterToVenders;
	}

	public void addToStoreTenderInvitaLetterToVenders (jkt.hms.masters.business.StoreTenderInvitaLetterToVender storeTenderInvitaLetterToVender) {
		if (null == getStoreTenderInvitaLetterToVenders()) setStoreTenderInvitaLetterToVenders(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderInvitaLetterToVender>());
		getStoreTenderInvitaLetterToVenders().add(storeTenderInvitaLetterToVender);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderInvitationLetter)) return false;
		else {
			jkt.hms.masters.business.StoreTenderInvitationLetter storeTenderInvitationLetter = (jkt.hms.masters.business.StoreTenderInvitationLetter) obj;
			if (null == this.getId() || null == storeTenderInvitationLetter.getId()) return false;
			else return (this.getId().equals(storeTenderInvitationLetter.getId()));
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