package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the upload_documents table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="upload_documents"
 */

public abstract class BaseUploadDocuments  implements Serializable {

	public static String REF = "UploadDocuments";
	public static String PROP_UPLOAD_DATE = "UploadDate";
	public static String PROP_AGE = "Age";
	public static String PROP_STORE_INTERNAL_T = "StoreInternalT";
	public static String PROP_FILE_EXTENSION = "FileExtension";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REQUEST = "Request";
	public static String PROP_PATIENT_DOCUMENT = "PatientDocument";
	public static String PROP_STOCK = "Stock";
	public static String PROP_VENDOR_DETILS = "VendorDetils";
	public static String PROP_DEPUTATION = "Deputation";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CONSENT_LETTER = "ConsentLetter";
	public static String PROP_BLOOD_CONSENT_LETTER = "BloodConsentLetter";
	public static String PROP_RESULT_ENTRY = "ResultEntry";
	public static String PROP_ASSET = "Asset";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SEX = "Sex";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_VISIT = "Visit";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LEAVE_DETAIL = "LeaveDetail";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_STATUS = "Status";


	// constructors
	public BaseUploadDocuments () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUploadDocuments (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patientName;
	private java.lang.String age;
	private java.lang.String sex;
	private java.lang.String address;
	private byte[] patientDocument;
	private java.lang.String fileName;
	private java.lang.String fileExtension;
	private java.lang.String description;
	private java.util.Date uploadDate;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String consentLetter;
	private java.lang.String bloodConsentLetter;
	private java.lang.String status;
	
	// many to one
	private jkt.hms.masters.business.PrqAssetDetails asset;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MmServiceRequest request;
	private jkt.hms.masters.business.HrEmployeeDeputation deputation;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.StoreItemBatchStock stock;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.PrqQuotationVendorDetails vendorDetils;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.DgResultEntryHeader resultEntry;
	private jkt.hrms.masters.business.HrLeaveDetails leaveDetail;
	private jkt.hms.masters.business.StoreInternalIndentT storeInternalT;



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
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * @param patientName the patient_name value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * @param sex the sex value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: patient_document
	 */
	public byte[] getPatientDocument () {
		return patientDocument;
	}

	/**
	 * Set the value related to the column: patient_document
	 * @param patientDocument the patient_document value
	 */
	public void setPatientDocument (byte[] patientDocument) {
		this.patientDocument = patientDocument;
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}


	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: upload_date
	 */
	public java.util.Date getUploadDate () {
		return uploadDate;
	}

	/**
	 * Set the value related to the column: upload_date
	 * @param uploadDate the upload_date value
	 */
	public void setUploadDate (java.util.Date uploadDate) {
		this.uploadDate = uploadDate;
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
	 * Return the value associated with the column: consent_letter
	 */
	public java.lang.String getConsentLetter () {
		return consentLetter;
	}

	/**
	 * Set the value related to the column: consent_letter
	 * @param consentLetter the consent_letter value
	 */
	public void setConsentLetter (java.lang.String consentLetter) {
		this.consentLetter = consentLetter;
	}

	
	/**
	 * Return the value associated with the column: blood_consent_letter
	 */
	public java.lang.String getBloodConsentLetter () {
		return bloodConsentLetter;
	}

	/**
	 * Set the value related to the column: blood_consent_letter
	 * @param bloodConsentLetter the blood_consent_letter value
	 */
	public void setBloodConsentLetter (java.lang.String bloodConsentLetter) {
		this.bloodConsentLetter = bloodConsentLetter;
	}
	
	

	/**
	 * Return the value associated with the column: asset_id
	 */
	public jkt.hms.masters.business.PrqAssetDetails getAsset () {
		return asset;
	}

	/**
	 * Set the value related to the column: asset_id
	 * @param asset the asset_id value
	 */
	public void setAsset (jkt.hms.masters.business.PrqAssetDetails asset) {
		this.asset = asset;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.MmServiceRequest getRequest () {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * @param request the request_id value
	 */
	public void setRequest (jkt.hms.masters.business.MmServiceRequest request) {
		this.request = request;
	}



	/**
	 * Return the value associated with the column: deputation_id
	 */
	public jkt.hms.masters.business.HrEmployeeDeputation getDeputation () {
		return deputation;
	}

	/**
	 * Set the value related to the column: deputation_id
	 * @param deputation the deputation_id value
	 */
	public void setDeputation (jkt.hms.masters.business.HrEmployeeDeputation deputation) {
		this.deputation = deputation;
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
	 * Return the value associated with the column: stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getStock () {
		return stock;
	}

	/**
	 * Set the value related to the column: stock_id
	 * @param stock the stock_id value
	 */
	public void setStock (jkt.hms.masters.business.StoreItemBatchStock stock) {
		this.stock = stock;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: vendor_detils_id
	 */
	public jkt.hms.masters.business.PrqQuotationVendorDetails getVendorDetils () {
		return vendorDetils;
	}

	/**
	 * Set the value related to the column: vendor_detils_id
	 * @param vendorDetils the vendor_detils_id value
	 */
	public void setVendorDetils (jkt.hms.masters.business.PrqQuotationVendorDetails vendorDetils) {
		this.vendorDetils = vendorDetils;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: result_entry_id
	 */
	public jkt.hms.masters.business.DgResultEntryHeader getResultEntry () {
		return resultEntry;
	}

	/**
	 * Set the value related to the column: result_entry_id
	 * @param resultEntry the result_entry_id value
	 */
	public void setResultEntry (jkt.hms.masters.business.DgResultEntryHeader resultEntry) {
		this.resultEntry = resultEntry;
	}



	/**
	 * Return the value associated with the column: leave_detail_id
	 */
	public jkt.hrms.masters.business.HrLeaveDetails getLeaveDetail () {
		return leaveDetail;
	}

	/**
	 * Set the value related to the column: leave_detail_id
	 * @param leaveDetail the leave_detail_id value
	 */
	public void setLeaveDetail (jkt.hrms.masters.business.HrLeaveDetails leaveDetail) {
		this.leaveDetail = leaveDetail;
	}



	/**
	 * Return the value associated with the column: store_internal_t_id
	 */
	public jkt.hms.masters.business.StoreInternalIndentT getStoreInternalT () {
		return storeInternalT;
	}

	/**
	 * Set the value related to the column: store_internal_t_id
	 * @param storeInternalT the store_internal_t_id value
	 */
	public void setStoreInternalT (jkt.hms.masters.business.StoreInternalIndentT storeInternalT) {
		this.storeInternalT = storeInternalT;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.UploadDocuments)) return false;
		else {
			jkt.hms.masters.business.UploadDocuments uploadDocuments = (jkt.hms.masters.business.UploadDocuments) obj;
			if (null == this.getId() || null == uploadDocuments.getId()) return false;
			else return (this.getId().equals(uploadDocuments.getId()));
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