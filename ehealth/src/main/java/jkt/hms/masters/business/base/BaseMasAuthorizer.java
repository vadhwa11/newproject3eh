package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_authorizer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_authorizer"
 */

public abstract class BaseMasAuthorizer  implements Serializable {

	public static String REF = "MasAuthorizer";
	public static String PROP_SATISFACTORY_PERFORMANCE_CERTIFICATE = "SatisfactoryPerformanceCertificate";
	public static String PROP_DGAFMS_SOC = "DgafmsSoc";
	public static String PROP_BOARD_OF_SURVEY = "BoardOfSurvey";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DISPOSAL_ENTRY_MORE_THIRTY = "DisposalEntryMoreThirty";
	public static String PROP_INDENT_DEPOT = "IndentDepot";
	public static String PROP_WORK_ORDER = "WorkOrder";
	public static String PROP_DEFECTIVE_DRUGS_RETURN = "DefectiveDrugsReturn";
	public static String PROP_AUTHORIZER_CODE = "AuthorizerCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DGAFMS_MMF = "DgafmsMmf";
	public static String PROP_STOCK_TAKING = "StockTaking";
	public static String PROP_VENDOR_RETURN = "VendorReturn";
	public static String PROP_CRV = "Crv";
	public static String PROP_EQUIPMENT_REPAIR_CIVIL = "EquipmentRepairCivil";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BOO = "Boo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LOCAL_PO = "LocalPo";
	public static String PROP_ISSUE_TO_DISPENSARY = "IssueToDispensary";
	public static String PROP_DISPOSAL_ENTRY_LESS_THIRTY = "DisposalEntryLessThirty";
	public static String PROP_QUATER_RETURN_SOP_EQUIP = "QuaterReturnSopEquip";
	public static String PROP_STATUS = "Status";
	public static String PROP_AUTHORIZER_NAME = "AuthorizerName";
	public static String PROP_ISSUE_TO_OTHER_UNITS = "IssueToOtherUnits";
	public static String PROP_ID = "Id";
	public static String PROP_MIN_AUTHORIZE_AMT = "MinAuthorizeAmt";
	public static String PROP_MAX_AUTHORIZE_AMT = "MaxAuthorizeAmt";
	public static String PROP_RETURN_FROM_DISPENSARY = "ReturnFromDispensary";


	// constructors
	public BaseMasAuthorizer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAuthorizer (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String authorizerCode;
	private java.lang.String authorizerName;
	private java.lang.String status;
	private java.lang.Long lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String dgafmsMmf;
	private java.lang.String indentDepot;
	private java.lang.String dgafmsSoc;
	private java.lang.String localPo;
	private java.lang.String crv;
	private java.lang.String boo;
	private java.lang.String vendorReturn;
	private java.lang.String issueToDispensary;
	private java.lang.String issueToOtherUnits;
	private java.lang.String returnFromDispensary;
	private java.lang.String defectiveDrugsReturn;
	private java.lang.String stockTaking;
	private java.lang.String satisfactoryPerformanceCertificate;
	private java.lang.String workOrder;
	private java.lang.String equipmentRepairCivil;
	private java.lang.String boardOfSurvey;
	private java.lang.String disposalEntryMoreThirty;
	private java.lang.String disposalEntryLessThirty;
	private java.lang.String quaterReturnSopEquip;
	private java.math.BigDecimal maxAuthorizeAmt;
	private java.math.BigDecimal minAuthorizeAmt;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="authorizer_id"
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
	 * Return the value associated with the column: authorizer_code
	 */
	public java.lang.String getAuthorizerCode () {
		return authorizerCode;
	}

	/**
	 * Set the value related to the column: authorizer_code
	 * @param authorizerCode the authorizer_code value
	 */
	public void setAuthorizerCode (java.lang.String authorizerCode) {
		this.authorizerCode = authorizerCode;
	}



	/**
	 * Return the value associated with the column: authorizer_name
	 */
	public java.lang.String getAuthorizerName () {
		return authorizerName;
	}

	/**
	 * Set the value related to the column: authorizer_name
	 * @param authorizerName the authorizer_name value
	 */
	public void setAuthorizerName (java.lang.String authorizerName) {
		this.authorizerName = authorizerName;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Long getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Long lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: dgafms_mmf
	 */
	public java.lang.String getDgafmsMmf () {
		return dgafmsMmf;
	}

	/**
	 * Set the value related to the column: dgafms_mmf
	 * @param dgafmsMmf the dgafms_mmf value
	 */
	public void setDgafmsMmf (java.lang.String dgafmsMmf) {
		this.dgafmsMmf = dgafmsMmf;
	}



	/**
	 * Return the value associated with the column: indent_depot
	 */
	public java.lang.String getIndentDepot () {
		return indentDepot;
	}

	/**
	 * Set the value related to the column: indent_depot
	 * @param indentDepot the indent_depot value
	 */
	public void setIndentDepot (java.lang.String indentDepot) {
		this.indentDepot = indentDepot;
	}



	/**
	 * Return the value associated with the column: dgafms_soc
	 */
	public java.lang.String getDgafmsSoc () {
		return dgafmsSoc;
	}

	/**
	 * Set the value related to the column: dgafms_soc
	 * @param dgafmsSoc the dgafms_soc value
	 */
	public void setDgafmsSoc (java.lang.String dgafmsSoc) {
		this.dgafmsSoc = dgafmsSoc;
	}



	/**
	 * Return the value associated with the column: local_po
	 */
	public java.lang.String getLocalPo () {
		return localPo;
	}

	/**
	 * Set the value related to the column: local_po
	 * @param localPo the local_po value
	 */
	public void setLocalPo (java.lang.String localPo) {
		this.localPo = localPo;
	}



	/**
	 * Return the value associated with the column: crv
	 */
	public java.lang.String getCrv () {
		return crv;
	}

	/**
	 * Set the value related to the column: crv
	 * @param crv the crv value
	 */
	public void setCrv (java.lang.String crv) {
		this.crv = crv;
	}



	/**
	 * Return the value associated with the column: boo
	 */
	public java.lang.String getBoo () {
		return boo;
	}

	/**
	 * Set the value related to the column: boo
	 * @param boo the boo value
	 */
	public void setBoo (java.lang.String boo) {
		this.boo = boo;
	}



	/**
	 * Return the value associated with the column: vendor_return
	 */
	public java.lang.String getVendorReturn () {
		return vendorReturn;
	}

	/**
	 * Set the value related to the column: vendor_return
	 * @param vendorReturn the vendor_return value
	 */
	public void setVendorReturn (java.lang.String vendorReturn) {
		this.vendorReturn = vendorReturn;
	}



	/**
	 * Return the value associated with the column: issue_to_dispensary
	 */
	public java.lang.String getIssueToDispensary () {
		return issueToDispensary;
	}

	/**
	 * Set the value related to the column: issue_to_dispensary
	 * @param issueToDispensary the issue_to_dispensary value
	 */
	public void setIssueToDispensary (java.lang.String issueToDispensary) {
		this.issueToDispensary = issueToDispensary;
	}



	/**
	 * Return the value associated with the column: issue_to_other_units
	 */
	public java.lang.String getIssueToOtherUnits () {
		return issueToOtherUnits;
	}

	/**
	 * Set the value related to the column: issue_to_other_units
	 * @param issueToOtherUnits the issue_to_other_units value
	 */
	public void setIssueToOtherUnits (java.lang.String issueToOtherUnits) {
		this.issueToOtherUnits = issueToOtherUnits;
	}



	/**
	 * Return the value associated with the column: return_from_dispensary
	 */
	public java.lang.String getReturnFromDispensary () {
		return returnFromDispensary;
	}

	/**
	 * Set the value related to the column: return_from_dispensary
	 * @param returnFromDispensary the return_from_dispensary value
	 */
	public void setReturnFromDispensary (java.lang.String returnFromDispensary) {
		this.returnFromDispensary = returnFromDispensary;
	}



	/**
	 * Return the value associated with the column: defective_drugs_return
	 */
	public java.lang.String getDefectiveDrugsReturn () {
		return defectiveDrugsReturn;
	}

	/**
	 * Set the value related to the column: defective_drugs_return
	 * @param defectiveDrugsReturn the defective_drugs_return value
	 */
	public void setDefectiveDrugsReturn (java.lang.String defectiveDrugsReturn) {
		this.defectiveDrugsReturn = defectiveDrugsReturn;
	}



	/**
	 * Return the value associated with the column: stock_taking
	 */
	public java.lang.String getStockTaking () {
		return stockTaking;
	}

	/**
	 * Set the value related to the column: stock_taking
	 * @param stockTaking the stock_taking value
	 */
	public void setStockTaking (java.lang.String stockTaking) {
		this.stockTaking = stockTaking;
	}



	/**
	 * Return the value associated with the column: satisfactory_performance_certificate
	 */
	public java.lang.String getSatisfactoryPerformanceCertificate () {
		return satisfactoryPerformanceCertificate;
	}

	/**
	 * Set the value related to the column: satisfactory_performance_certificate
	 * @param satisfactoryPerformanceCertificate the satisfactory_performance_certificate value
	 */
	public void setSatisfactoryPerformanceCertificate (java.lang.String satisfactoryPerformanceCertificate) {
		this.satisfactoryPerformanceCertificate = satisfactoryPerformanceCertificate;
	}



	/**
	 * Return the value associated with the column: work_order
	 */
	public java.lang.String getWorkOrder () {
		return workOrder;
	}

	/**
	 * Set the value related to the column: work_order
	 * @param workOrder the work_order value
	 */
	public void setWorkOrder (java.lang.String workOrder) {
		this.workOrder = workOrder;
	}



	/**
	 * Return the value associated with the column: equipment_repair_civil
	 */
	public java.lang.String getEquipmentRepairCivil () {
		return equipmentRepairCivil;
	}

	/**
	 * Set the value related to the column: equipment_repair_civil
	 * @param equipmentRepairCivil the equipment_repair_civil value
	 */
	public void setEquipmentRepairCivil (java.lang.String equipmentRepairCivil) {
		this.equipmentRepairCivil = equipmentRepairCivil;
	}



	/**
	 * Return the value associated with the column: board_of_survey
	 */
	public java.lang.String getBoardOfSurvey () {
		return boardOfSurvey;
	}

	/**
	 * Set the value related to the column: board_of_survey
	 * @param boardOfSurvey the board_of_survey value
	 */
	public void setBoardOfSurvey (java.lang.String boardOfSurvey) {
		this.boardOfSurvey = boardOfSurvey;
	}



	/**
	 * Return the value associated with the column: disposal_entry_more_thirty
	 */
	public java.lang.String getDisposalEntryMoreThirty () {
		return disposalEntryMoreThirty;
	}

	/**
	 * Set the value related to the column: disposal_entry_more_thirty
	 * @param disposalEntryMoreThirty the disposal_entry_more_thirty value
	 */
	public void setDisposalEntryMoreThirty (java.lang.String disposalEntryMoreThirty) {
		this.disposalEntryMoreThirty = disposalEntryMoreThirty;
	}



	/**
	 * Return the value associated with the column: disposal_entry_less_thirty
	 */
	public java.lang.String getDisposalEntryLessThirty () {
		return disposalEntryLessThirty;
	}

	/**
	 * Set the value related to the column: disposal_entry_less_thirty
	 * @param disposalEntryLessThirty the disposal_entry_less_thirty value
	 */
	public void setDisposalEntryLessThirty (java.lang.String disposalEntryLessThirty) {
		this.disposalEntryLessThirty = disposalEntryLessThirty;
	}



	/**
	 * Return the value associated with the column: quater_return_sop_equip
	 */
	public java.lang.String getQuaterReturnSopEquip () {
		return quaterReturnSopEquip;
	}

	/**
	 * Set the value related to the column: quater_return_sop_equip
	 * @param quaterReturnSopEquip the quater_return_sop_equip value
	 */
	public void setQuaterReturnSopEquip (java.lang.String quaterReturnSopEquip) {
		this.quaterReturnSopEquip = quaterReturnSopEquip;
	}



	/**
	 * Return the value associated with the column: max_authorize_amt
	 */
	public java.math.BigDecimal getMaxAuthorizeAmt () {
		return maxAuthorizeAmt;
	}

	/**
	 * Set the value related to the column: max_authorize_amt
	 * @param maxAuthorizeAmt the max_authorize_amt value
	 */
	public void setMaxAuthorizeAmt (java.math.BigDecimal maxAuthorizeAmt) {
		this.maxAuthorizeAmt = maxAuthorizeAmt;
	}



	/**
	 * Return the value associated with the column: min_authorize_amt
	 */
	public java.math.BigDecimal getMinAuthorizeAmt () {
		return minAuthorizeAmt;
	}

	/**
	 * Set the value related to the column: min_authorize_amt
	 * @param minAuthorizeAmt the min_authorize_amt value
	 */
	public void setMinAuthorizeAmt (java.math.BigDecimal minAuthorizeAmt) {
		this.minAuthorizeAmt = minAuthorizeAmt;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAuthorizer)) return false;
		else {
			jkt.hms.masters.business.MasAuthorizer masAuthorizer = (jkt.hms.masters.business.MasAuthorizer) obj;
			if (null == this.getId() || null == masAuthorizer.getId()) return false;
			else return (this.getId().equals(masAuthorizer.getId()));
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