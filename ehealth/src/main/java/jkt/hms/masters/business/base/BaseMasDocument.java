package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_document table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_document"
 */

public abstract class BaseMasDocument  implements Serializable {

	public static String REF = "MasDocument";
	public static String PROP_STATUS = "Status";
	public static String PROP_DOCUMENT_CODE = "DocumentCode";
	public static String PROP_DOCUMENT_NAME = "DocumentName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasDocument () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDocument (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String documentCode;
	private java.lang.String documentName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.InpatientDocument> inpatientDocuments;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="document_id"
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
	 * Return the value associated with the column: document_code
	 */
	public java.lang.String getDocumentCode () {
		return documentCode;
	}

	/**
	 * Set the value related to the column: document_code
	 * @param documentCode the document_code value
	 */
	public void setDocumentCode (java.lang.String documentCode) {
		this.documentCode = documentCode;
	}



	/**
	 * Return the value associated with the column: document_name
	 */
	public java.lang.String getDocumentName () {
		return documentName;
	}

	/**
	 * Set the value related to the column: document_name
	 * @param documentName the document_name value
	 */
	public void setDocumentName (java.lang.String documentName) {
		this.documentName = documentName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients () {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * @param inpatients the Inpatients value
	 */
	public void setInpatients (java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients (jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients()) setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}



	/**
	 * Return the value associated with the column: InpatientDocuments
	 */
	public java.util.Set<jkt.hms.masters.business.InpatientDocument> getInpatientDocuments () {
		return inpatientDocuments;
	}

	/**
	 * Set the value related to the column: InpatientDocuments
	 * @param inpatientDocuments the InpatientDocuments value
	 */
	public void setInpatientDocuments (java.util.Set<jkt.hms.masters.business.InpatientDocument> inpatientDocuments) {
		this.inpatientDocuments = inpatientDocuments;
	}

	public void addToInpatientDocuments (jkt.hms.masters.business.InpatientDocument inpatientDocument) {
		if (null == getInpatientDocuments()) setInpatientDocuments(new java.util.TreeSet<jkt.hms.masters.business.InpatientDocument>());
		getInpatientDocuments().add(inpatientDocument);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDocument)) return false;
		else {
			jkt.hms.masters.business.MasDocument masDocument = (jkt.hms.masters.business.MasDocument) obj;
			if (null == this.getId() || null == masDocument.getId()) return false;
			else return (this.getId().equals(masDocument.getId()));
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