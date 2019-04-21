package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_prescription_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_prescription_details"
 */

public abstract class BasePatientPrescriptionDetails  implements Serializable {

	public static String REF = "PatientPrescriptionDetails";
	public static String PROP_TYPE = "Type";
	public static String PROP_INJECTION_STATUS = "InjectionStatus";
	public static String PROP_ISSUED_STATUS = "IssuedStatus";
	public static String PROP_PRESCRIPTION = "Prescription";
	public static String PROP_TOTAL_STORE_ISSUED_QTY = "TotalStoreIssuedQty";
	public static String PROP_CT = "Ct";
	public static String PROP_NURSING_STATUS = "NursingStatus";
	public static String PROP_NURSING_DATE = "NursingDate";
	public static String PROP_EMP_REQUEST_QTY = "EmpRequestQty";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_ITEM = "Item";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_ACTUAL_TOTAL = "ActualTotal";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_NOT_AVAILABLE = "NotAvailable";
	public static String PROP_TOTAL_EMP_ISSUED_QTY = "TotalEmpIssuedQty";
	public static String PROP_ROUTE = "Route";
	public static String PROP_INJ_GIVEN_QTY = "InjGivenQty";
	public static String PROP_NURSING_TIME = "NursingTime";
	public static String PROP_ITEM_OUT = "ItemOut";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_BRAND_ID = "BrandId";
	public static String PROP_INSRTUCTION = "Insrtuction";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_DISPENSING_PRICE = "DispensingPrice";
	public static String PROP_DOSAGE = "Dosage";
	public static String PROP_SPL_INSTRUCTION = "SplInstruction";
	public static String PROP_ID = "Id";
	public static String PROP_CUR_STORE_ISSUED_QTY = "CurStoreIssuedQty";
	public static String PROP_REFER_TO_EMPANELLED = "ReferToEmpanelled";
	public static String PROP_TOTAL = "Total";
	public static String PROP_EMP_ISSUED_QTY = "EmpIssuedQty";


	// constructors
	public BasePatientPrescriptionDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientPrescriptionDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Float dosage;
	private java.lang.Integer noOfDays;
	private java.lang.Float total;
	private java.lang.String type;
	private java.lang.Float dispensingPrice;
	private java.lang.Integer brandId;
	private java.lang.Float totalStoreIssuedQty;
	private java.lang.String issuedStatus;
	private java.lang.String splInstruction;
	private java.lang.Float curStoreIssuedQty;
	private java.lang.String referToEmpanelled;
	private java.lang.String notAvailable;
	private java.lang.Float empRequestQty;
	private java.lang.Float empIssuedQty;
	private java.lang.Float totalEmpIssuedQty;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.lang.String nursingStatus;
	private java.lang.String nursingTime;
	private java.util.Date nursingDate;
	private java.lang.String injectionStatus;
	private java.lang.Long injGivenQty;
	private java.lang.String ct;
	private java.lang.Float actualTotal;

	// many to one
	private jkt.hms.masters.business.OpdInstructionTreatment insrtuction;
	private jkt.hms.masters.business.RouteOfAdministration route;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasStoreOutItem itemOut;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.PatientPrescriptionHeader prescription;
	private jkt.hms.masters.business.MasFrequency frequency;



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
	 * Return the value associated with the column: dosage
	 */
	public java.lang.Float getDosage () {
		return dosage;
	}

	/**
	 * Set the value related to the column: dosage
	 * @param dosage the dosage value
	 */
	public void setDosage (java.lang.Float dosage) {
		this.dosage = dosage;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: total
	 */
	public java.lang.Float getTotal () {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * @param total the total value
	 */
	public void setTotal (java.lang.Float total) {
		this.total = total;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: dispensing_price
	 */
	public java.lang.Float getDispensingPrice () {
		return dispensingPrice;
	}

	/**
	 * Set the value related to the column: dispensing_price
	 * @param dispensingPrice the dispensing_price value
	 */
	public void setDispensingPrice (java.lang.Float dispensingPrice) {
		this.dispensingPrice = dispensingPrice;
	}



	/**
	 * Return the value associated with the column: brand_id
	 */
	public java.lang.Integer getBrandId () {
		return brandId;
	}

	/**
	 * Set the value related to the column: brand_id
	 * @param brandId the brand_id value
	 */
	public void setBrandId (java.lang.Integer brandId) {
		this.brandId = brandId;
	}



	/**
	 * Return the value associated with the column: total_store_issued_qty
	 */
	public java.lang.Float getTotalStoreIssuedQty () {
		return totalStoreIssuedQty;
	}

	/**
	 * Set the value related to the column: total_store_issued_qty
	 * @param totalStoreIssuedQty the total_store_issued_qty value
	 */
	public void setTotalStoreIssuedQty (java.lang.Float totalStoreIssuedQty) {
		this.totalStoreIssuedQty = totalStoreIssuedQty;
	}



	/**
	 * Return the value associated with the column: issued_status
	 */
	public java.lang.String getIssuedStatus () {
		return issuedStatus;
	}

	/**
	 * Set the value related to the column: issued_status
	 * @param issuedStatus the issued_status value
	 */
	public void setIssuedStatus (java.lang.String issuedStatus) {
		this.issuedStatus = issuedStatus;
	}



	/**
	 * Return the value associated with the column: spl_instruction
	 */
	public java.lang.String getSplInstruction () {
		return splInstruction;
	}

	/**
	 * Set the value related to the column: spl_instruction
	 * @param splInstruction the spl_instruction value
	 */
	public void setSplInstruction (java.lang.String splInstruction) {
		this.splInstruction = splInstruction;
	}



	/**
	 * Return the value associated with the column: cur_store_issued_qty
	 */
	public java.lang.Float getCurStoreIssuedQty () {
		return curStoreIssuedQty;
	}

	/**
	 * Set the value related to the column: cur_store_issued_qty
	 * @param curStoreIssuedQty the cur_store_issued_qty value
	 */
	public void setCurStoreIssuedQty (java.lang.Float curStoreIssuedQty) {
		this.curStoreIssuedQty = curStoreIssuedQty;
	}



	/**
	 * Return the value associated with the column: refer_to_empanelled
	 */
	public java.lang.String getReferToEmpanelled () {
		return referToEmpanelled;
	}

	/**
	 * Set the value related to the column: refer_to_empanelled
	 * @param referToEmpanelled the refer_to_empanelled value
	 */
	public void setReferToEmpanelled (java.lang.String referToEmpanelled) {
		this.referToEmpanelled = referToEmpanelled;
	}



	/**
	 * Return the value associated with the column: not_available
	 */
	public java.lang.String getNotAvailable () {
		return notAvailable;
	}

	/**
	 * Set the value related to the column: not_available
	 * @param notAvailable the not_available value
	 */
	public void setNotAvailable (java.lang.String notAvailable) {
		this.notAvailable = notAvailable;
	}



	/**
	 * Return the value associated with the column: emp_request_qty
	 */
	public java.lang.Float getEmpRequestQty () {
		return empRequestQty;
	}

	/**
	 * Set the value related to the column: emp_request_qty
	 * @param empRequestQty the emp_request_qty value
	 */
	public void setEmpRequestQty (java.lang.Float empRequestQty) {
		this.empRequestQty = empRequestQty;
	}



	/**
	 * Return the value associated with the column: emp_issued_qty
	 */
	public java.lang.Float getEmpIssuedQty () {
		return empIssuedQty;
	}

	/**
	 * Set the value related to the column: emp_issued_qty
	 * @param empIssuedQty the emp_issued_qty value
	 */
	public void setEmpIssuedQty (java.lang.Float empIssuedQty) {
		this.empIssuedQty = empIssuedQty;
	}



	/**
	 * Return the value associated with the column: total_emp_issued_qty
	 */
	public java.lang.Float getTotalEmpIssuedQty () {
		return totalEmpIssuedQty;
	}

	/**
	 * Set the value related to the column: total_emp_issued_qty
	 * @param totalEmpIssuedQty the total_emp_issued_qty value
	 */
	public void setTotalEmpIssuedQty (java.lang.Float totalEmpIssuedQty) {
		this.totalEmpIssuedQty = totalEmpIssuedQty;
	}



	/**
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * @param startDate the start_date value
	 */
	public void setStartDate (java.util.Date startDate) {
		this.startDate = startDate;
	}



	/**
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
	}



	/**
	 * Return the value associated with the column: nursing_status
	 */
	public java.lang.String getNursingStatus () {
		return nursingStatus;
	}

	/**
	 * Set the value related to the column: nursing_status
	 * @param nursingStatus the nursing_status value
	 */
	public void setNursingStatus (java.lang.String nursingStatus) {
		this.nursingStatus = nursingStatus;
	}



	/**
	 * Return the value associated with the column: nursing_time
	 */
	public java.lang.String getNursingTime () {
		return nursingTime;
	}

	/**
	 * Set the value related to the column: nursing_time
	 * @param nursingTime the nursing_time value
	 */
	public void setNursingTime (java.lang.String nursingTime) {
		this.nursingTime = nursingTime;
	}



	/**
	 * Return the value associated with the column: nursing_date
	 */
	public java.util.Date getNursingDate () {
		return nursingDate;
	}

	/**
	 * Set the value related to the column: nursing_date
	 * @param nursingDate the nursing_date value
	 */
	public void setNursingDate (java.util.Date nursingDate) {
		this.nursingDate = nursingDate;
	}



	/**
	 * Return the value associated with the column: injection_status
	 */
	public java.lang.String getInjectionStatus () {
		return injectionStatus;
	}

	/**
	 * Set the value related to the column: injection_status
	 * @param injectionStatus the injection_status value
	 */
	public void setInjectionStatus (java.lang.String injectionStatus) {
		this.injectionStatus = injectionStatus;
	}



	/**
	 * Return the value associated with the column: inj_given_qty
	 */
	public java.lang.Long getInjGivenQty () {
		return injGivenQty;
	}

	/**
	 * Set the value related to the column: inj_given_qty
	 * @param injGivenQty the inj_given_qty value
	 */
	public void setInjGivenQty (java.lang.Long injGivenQty) {
		this.injGivenQty = injGivenQty;
	}



	/**
	 * Return the value associated with the column: CT
	 */
	public java.lang.String getCt () {
		return ct;
	}

	/**
	 * Set the value related to the column: CT
	 * @param ct the CT value
	 */
	public void setCt (java.lang.String ct) {
		this.ct = ct;
	}



	/**
	 * Return the value associated with the column: actual_total
	 */
	public java.lang.Float getActualTotal () {
		return actualTotal;
	}

	/**
	 * Set the value related to the column: actual_total
	 * @param actualTotal the actual_total value
	 */
	public void setActualTotal (java.lang.Float actualTotal) {
		this.actualTotal = actualTotal;
	}



	/**
	 * Return the value associated with the column: insrtuction_id
	 */
	public jkt.hms.masters.business.OpdInstructionTreatment getInsrtuction () {
		return insrtuction;
	}

	/**
	 * Set the value related to the column: insrtuction_id
	 * @param insrtuction the insrtuction_id value
	 */
	public void setInsrtuction (jkt.hms.masters.business.OpdInstructionTreatment insrtuction) {
		this.insrtuction = insrtuction;
	}



	/**
	 * Return the value associated with the column: route_id
	 */
	public jkt.hms.masters.business.RouteOfAdministration getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: route_id
	 * @param route the route_id value
	 */
	public void setRoute (jkt.hms.masters.business.RouteOfAdministration route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: item_out_id
	 */
	public jkt.hms.masters.business.MasStoreOutItem getItemOut () {
		return itemOut;
	}

	/**
	 * Set the value related to the column: item_out_id
	 * @param itemOut the item_out_id value
	 */
	public void setItemOut (jkt.hms.masters.business.MasStoreOutItem itemOut) {
		this.itemOut = itemOut;
	}



	/**
	 * Return the value associated with the column: manufacturer_id
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturer () {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer_id
	 * @param manufacturer the manufacturer_id value
	 */
	public void setManufacturer (jkt.hms.masters.business.MasManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}



	/**
	 * Return the value associated with the column: prescription_id
	 */
	public jkt.hms.masters.business.PatientPrescriptionHeader getPrescription () {
		return prescription;
	}

	/**
	 * Set the value related to the column: prescription_id
	 * @param prescription the prescription_id value
	 */
	public void setPrescription (jkt.hms.masters.business.PatientPrescriptionHeader prescription) {
		this.prescription = prescription;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientPrescriptionDetails)) return false;
		else {
			jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails = (jkt.hms.masters.business.PatientPrescriptionDetails) obj;
			if (null == this.getId() || null == patientPrescriptionDetails.getId()) return false;
			else return (this.getId().equals(patientPrescriptionDetails.getId()));
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