package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_result_entry_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_result_entry_detail"
 */

public abstract class BaseDgResultEntryDetail  implements Serializable {

	public static String REF = "DgResultEntryDetail";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_RESULT = "Result";
	public static String PROP_VALIDATED = "Validated";
	public static String PROP_FILM_SIZE = "FilmSize";
	public static String PROP_TEMPLATE = "Template";
	public static String PROP_RESULT_FOR_DISCHARGE_SUMMARY = "ResultForDischargeSummary";
	public static String PROP_SAMPLE = "Sample";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_FIXED_NORMAL_VALUE = "FixedNormalValue";
	public static String PROP_QC_FIXED = "QcFixed";
	public static String PROP_FILM_USED = "FilmUsed";
	public static String PROP_UOM = "Uom";
	public static String PROP_SUB_INVESTIGATION = "SubInvestigation";
	public static String PROP_RESULT_DETAIL_STATUS = "ResultDetailStatus";
	public static String PROP_ITEM = "Item";
	public static String PROP_NORMAL = "Normal";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_RESULT_ENTRY = "ResultEntry";
	public static String PROP_SAMPLE_COLLECTION_DETAILS = "SampleCollectionDetails";
	public static String PROP_ID = "Id";
	public static String PROP_QC_RESULT_TYPE = "QcResultType";
	public static String PROP_FIXED = "Fixed";
	public static String PROP_RESULT_TYPE = "ResultType";
	public static String PROP_QC_RESULT = "QcResult";


	// constructors
	public BaseDgResultEntryDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgResultEntryDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String resultType;
	private java.lang.String result;
	private java.lang.String remarks;
	private java.lang.String validated;
	private java.lang.String resultDetailStatus;
	private java.lang.String empanelledStatus;
	private java.lang.String filmSize;
	private java.lang.Integer filmUsed;
	private java.lang.String resultForDischargeSummary;
	private java.lang.String fixedNormalValue;
	private java.lang.String qcResult;
	private java.lang.String qcResultType;
	private java.lang.String remarksFour;
	private java.lang.String remarksThree;
	private java.lang.String remarksTwo;
	private java.lang.String remarksOne;
	public java.lang.String getRemarksFour() {
		return remarksFour;
	}

	public void setRemarksFour(java.lang.String remarksFour) {
		this.remarksFour = remarksFour;
	}

	public java.lang.String getRemarksThree() {
		return remarksThree;
	}

	public void setRemarksThree(java.lang.String remarksThree) {
		this.remarksThree = remarksThree;
	}

	public java.lang.String getRemarksTwo() {
		return remarksTwo;
	}

	public void setRemarksTwo(java.lang.String remarksTwo) {
		this.remarksTwo = remarksTwo;
	}

	public java.lang.String getRemarksOne() {
		return remarksOne;
	}

	public void setRemarksOne(java.lang.String remarksOne) {
		this.remarksOne = remarksOne;
	}



	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.DgSubMasInvestigation subInvestigation;
	private jkt.hms.masters.business.DgResultEntryHeader resultEntry;
	private jkt.hms.masters.business.DgUom uom;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.DgSampleCollectionDetails sampleCollectionDetails;
	private jkt.hms.masters.business.DgFixedValue qcFixed;
	private jkt.hms.masters.business.DgTemplate template;
	private jkt.hms.masters.business.DgMasInvestigation investigation;
	private jkt.hms.masters.business.MasSample sample;
	private jkt.hms.masters.business.DgFixedValue fixed;
	private jkt.hms.masters.business.DgNormalValue normal;
	private jkt.hms.masters.business.MasEmpaneled empaneled;
											



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="result_entry_detail_id"
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
	 * Return the value associated with the column: result_type
	 */
	public java.lang.String getResultType () {
		return resultType;
	}

	/**
	 * Set the value related to the column: result_type
	 * @param resultType the result_type value
	 */
	public void setResultType (java.lang.String resultType) {
		this.resultType = resultType;
	}



	/**
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * @param result the result value
	 */
	public void setResult (java.lang.String result) {
		this.result = result;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: validated
	 */
	public java.lang.String getValidated () {
		return validated;
	}

	/**
	 * Set the value related to the column: validated
	 * @param validated the validated value
	 */
	public void setValidated (java.lang.String validated) {
		this.validated = validated;
	}



	/**
	 * Return the value associated with the column: result_detail_status
	 */
	public java.lang.String getResultDetailStatus () {
		return resultDetailStatus;
	}

	/**
	 * Set the value related to the column: result_detail_status
	 * @param resultDetailStatus the result_detail_status value
	 */
	public void setResultDetailStatus (java.lang.String resultDetailStatus) {
		this.resultDetailStatus = resultDetailStatus;
	}

	public java.lang.String getEmpanelledStatus() {
		return empanelledStatus;
	}

	public void setEmpanelledStatus(java.lang.String empanelledStatus) {
		this.empanelledStatus = empanelledStatus;
	}

	/**
	 * Return the value associated with the column: film_size
	 */
	public java.lang.String getFilmSize () {
		return filmSize;
	}

	/**
	 * Set the value related to the column: film_size
	 * @param filmSize the film_size value
	 */
	public void setFilmSize (java.lang.String filmSize) {
		this.filmSize = filmSize;
	}



	/**
	 * Return the value associated with the column: film_used
	 */
	public java.lang.Integer getFilmUsed () {
		return filmUsed;
	}

	/**
	 * Set the value related to the column: film_used
	 * @param filmUsed the film_used value
	 */
	public void setFilmUsed (java.lang.Integer filmUsed) {
		this.filmUsed = filmUsed;
	}



	/**
	 * Return the value associated with the column: result_for_discharge_summary
	 */
	public java.lang.String getResultForDischargeSummary () {
		return resultForDischargeSummary;
	}

	/**
	 * Set the value related to the column: result_for_discharge_summary
	 * @param resultForDischargeSummary the result_for_discharge_summary value
	 */
	public void setResultForDischargeSummary (java.lang.String resultForDischargeSummary) {
		this.resultForDischargeSummary = resultForDischargeSummary;
	}



	/**
	 * Return the value associated with the column: fixed_normal_value
	 */
	public java.lang.String getFixedNormalValue () {
		return fixedNormalValue;
	}

	/**
	 * Set the value related to the column: fixed_normal_value
	 * @param fixedNormalValue the fixed_normal_value value
	 */
	public void setFixedNormalValue (java.lang.String fixedNormalValue) {
		this.fixedNormalValue = fixedNormalValue;
	}



	/**
	 * Return the value associated with the column: qc_result
	 */
	public java.lang.String getQcResult () {
		return qcResult;
	}

	/**
	 * Set the value related to the column: qc_result
	 * @param qcResult the qc_result value
	 */
	public void setQcResult (java.lang.String qcResult) {
		this.qcResult = qcResult;
	}



	/**
	 * Return the value associated with the column: qc_result_type
	 */
	public java.lang.String getQcResultType () {
		return qcResultType;
	}

	/**
	 * Set the value related to the column: qc_result_type
	 * @param qcResultType the qc_result_type value
	 */
	public void setQcResultType (java.lang.String qcResultType) {
		this.qcResultType = qcResultType;
	}



	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}



	/**
	 * Return the value associated with the column: sub_investigation_id
	 */
	public jkt.hms.masters.business.DgSubMasInvestigation getSubInvestigation () {
		return subInvestigation;
	}

	/**
	 * Set the value related to the column: sub_investigation_id
	 * @param subInvestigation the sub_investigation_id value
	 */
	public void setSubInvestigation (jkt.hms.masters.business.DgSubMasInvestigation subInvestigation) {
		this.subInvestigation = subInvestigation;
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
	 * Return the value associated with the column: uom_id
	 */
	public jkt.hms.masters.business.DgUom getUom () {
		return uom;
	}

	/**
	 * Set the value related to the column: uom_id
	 * @param uom the uom_id value
	 */
	public void setUom (jkt.hms.masters.business.DgUom uom) {
		this.uom = uom;
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
	 * Return the value associated with the column: sample_collection_details_id
	 */
	public jkt.hms.masters.business.DgSampleCollectionDetails getSampleCollectionDetails () {
		return sampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: sample_collection_details_id
	 * @param sampleCollectionDetails the sample_collection_details_id value
	 */
	public void setSampleCollectionDetails (jkt.hms.masters.business.DgSampleCollectionDetails sampleCollectionDetails) {
		this.sampleCollectionDetails = sampleCollectionDetails;
	}



	/**
	 * Return the value associated with the column: qc_fixed_id
	 */
	public jkt.hms.masters.business.DgFixedValue getQcFixed () {
		return qcFixed;
	}

	/**
	 * Set the value related to the column: qc_fixed_id
	 * @param qcFixed the qc_fixed_id value
	 */
	public void setQcFixed (jkt.hms.masters.business.DgFixedValue qcFixed) {
		this.qcFixed = qcFixed;
	}



	/**
	 * Return the value associated with the column: template_id
	 */
	public jkt.hms.masters.business.DgTemplate getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param template the template_id value
	 */
	public void setTemplate (jkt.hms.masters.business.DgTemplate template) {
		this.template = template;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigation the investigation_id value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: sample_id
	 */
	public jkt.hms.masters.business.MasSample getSample () {
		return sample;
	}

	/**
	 * Set the value related to the column: sample_id
	 * @param sample the sample_id value
	 */
	public void setSample (jkt.hms.masters.business.MasSample sample) {
		this.sample = sample;
	}



	/**
	 * Return the value associated with the column: fixed_id
	 */
	public jkt.hms.masters.business.DgFixedValue getFixed () {
		return fixed;
	}

	/**
	 * Set the value related to the column: fixed_id
	 * @param fixed the fixed_id value
	 */
	public void setFixed (jkt.hms.masters.business.DgFixedValue fixed) {
		this.fixed = fixed;
	}



	/**
	 * Return the value associated with the column: normal_id
	 */
	public jkt.hms.masters.business.DgNormalValue getNormal () {
		return normal;
	}

	/**
	 * Set the value related to the column: normal_id
	 * @param normal the normal_id value
	 */
	public void setNormal (jkt.hms.masters.business.DgNormalValue normal) {
		this.normal = normal;
	}

 
	public jkt.hms.masters.business.MasEmpaneled getEmpaneled() {
		return empaneled;
	}

	public void setEmpaneled(jkt.hms.masters.business.MasEmpaneled empaneled) {
		this.empaneled = empaneled;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgResultEntryDetail)) return false;
		else {
			jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail = (jkt.hms.masters.business.DgResultEntryDetail) obj;
			if (null == this.getId() || null == dgResultEntryDetail.getId()) return false;
			else return (this.getId().equals(dgResultEntryDetail.getId()));
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