package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_department table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_department"
 */

public abstract class BaseMasDepartment  implements Serializable {

	public static String REF = "MasDepartment";
	public static String PROP_DEPT_DESCRIPTION = "DeptDescription";
	public static String PROP_MODALITY_NAME = "ModalityName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DEPARTMENT_TYPE = "DepartmentType";
	public static String PROP_SERVICE_CENTER = "ServiceCenter";
	public static String PROP_PAYWARD_CHECK = "PaywardCheck";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COST_CENTER = "CostCenter";
	public static String PROP_BED_STRENGTH = "BedStrength";
	public static String PROP_STORE_TYPE = "StoreType";
	public static String PROP_EMP_DEPT = "EmpDept";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_NAME_IMAGE = "DepartmentNameImage";
	public static String PROP_DEPARTMENT_CODE = "DepartmentCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT_NAME = "DepartmentName";
	public static String PROP_WEB_PORTAL_DISPLAY = "WebPortalDisplay";
	public static String PROP_VISIT_APPLICABLE = "VisitApplicable";


	// constructors
	public BaseMasDepartment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDepartment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasDepartment (
		java.lang.Integer id,
		java.lang.String departmentCode) {

		this.setId(id);
		this.setDepartmentCode(departmentCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String departmentCode;
	private java.lang.String departmentName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer bedStrength;
	private java.lang.String modalityName;
	private java.lang.String deptDescription;
	private java.lang.String paywardCheck;
	private java.lang.String serviceCenter;
	private java.lang.String webPortalDisplay;
	private java.lang.String visitApplicable;
	private byte[] departmentNameImage;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployeeDepartment empDept;
	private jkt.hms.masters.business.MasCostCenter costCenter;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment storeType;
	private jkt.hms.masters.business.MasDepartmentType departmentType;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails;
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoos;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs;
	private java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries;
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;
	private java.util.Set<jkt.hms.masters.business.StoreAmcM> storeAmcMsByDepartment;
	private java.util.Set<jkt.hms.masters.business.StoreAmcM> storeAmcMsByEquipmentDept;
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers;
	private java.util.Set<jkt.hms.masters.business.StoreTenderProposal> storeTenderProposals;
	private java.util.Set<jkt.hms.masters.business.StoreBalanceM> storeBalanceMs;
	private java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> opdTemplateInvestigations;
	private java.util.Set<jkt.hms.masters.business.StorePoHeader> storePoHeaders;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMs;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopies;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByDepartment;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByToStore;
	private java.util.Set<jkt.hms.masters.business.StoreStockTakingM> storeStockTakingMs;
	private java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs;
	private java.util.Set<jkt.hms.masters.business.StoreCondemnationM> storeCondemnationMs;
	private java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails;
	private java.util.Set<jkt.hms.masters.business.StoreSoc> storeSocs;
	private java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments;
	private java.util.Set<jkt.hms.masters.business.AppPatientAppointments> appPatientAppointments;
	private java.util.Set<jkt.hms.masters.business.NursingfoodTest> nursingfoodTests;
	private java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> opdTemplateTreatments;
	private java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMsByDepartment;
	private java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMsByItemReqDept;
	private java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> storeMmfDepartmentMs;
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;
	private java.util.Set<jkt.hms.masters.business.AppInvestigationAppointments> appInvestigationAppointments;
	private java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> storeItemLogTransactions;
	private java.util.Set<jkt.hms.masters.business.OpdPatientHistory> opdPatientHistories;
	private java.util.Set<jkt.hms.masters.business.StoreFyDocumentNo> storeFyDocumentNos;
	private java.util.Set<jkt.hms.masters.business.OpdTemplate> opdTemplates;
	private java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByFromDepartment;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByToDepartment;
	private java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans;
	private java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> storeWorkOrderMs;
	private java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets;
	private java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails;
	private java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> masStoreItemTemplates;
	private java.util.Set<jkt.hms.masters.business.StoreBosM> storeBosMs;
	private java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> storeItemBatchStocks;
	private java.util.Set<jkt.hms.masters.business.UserDepartment> userDepartments;
	private java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestM> storeQuotationRequestMs;
	private java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> appInvestigationSetups;
	private java.util.Set<jkt.hms.masters.business.StoreQuaterReturnM> storeQuaterReturnMs;
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs;
	private java.util.Set<jkt.hms.masters.business.MasRoom> masRooms;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs;
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> storeDefectiveDrugMs;
	private java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> storeRepairCivilFirms;
	private java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes;
	private java.util.Set<jkt.hms.masters.business.MasReferralDoctor> masReferralDoctors;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts;
	private java.util.Set<jkt.hms.masters.business.StoreSetup> storeSetupsByStoreExpendable;
	private java.util.Set<jkt.hms.masters.business.StoreSetup> storeSetupsByStoreDispensary;
	private java.util.Set<jkt.hms.masters.business.StoreSetup> storeSetupsByStoreEchs;
	private java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeadersByPrescribedDepartment;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeadersBySurgicalDept;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopies;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes;
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;
	private java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards;
	private java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals;
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMsByDepartment;
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMsByToStore;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds;
	private java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> storeTenderTechnicalBidMs;
	private java.util.Set<jkt.hms.masters.business.Visit> visits;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptM> storeQuotationReceiptMs;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs;
	private java.util.Set<jkt.hms.masters.business.StoreDisposalM> storeDisposalMs;
	private java.util.Set<jkt.hms.masters.business.StoreTenderM> storeTenderMs;
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.WardRemarks> wardRemarks;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfersByToWard;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfersByFromWard;
	private java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders;
	private java.util.Set<jkt.hms.masters.business.MasOtDistribution> masOtDistributions;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.MasBed> masBeds;
	private java.util.Set<jkt.hms.masters.business.AppSetup> appSetups;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> opdGravidagramGestationalDiabitiesTwos;
	private java.util.Set<jkt.hrms.masters.business.MstrDeptTaskMap> deptTaskMaps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="department_id"
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
	 * Return the value associated with the column: department_code
	 */
	public java.lang.String getDepartmentCode () {
		return departmentCode;
	}

	/**
	 * Set the value related to the column: department_code
	 * @param departmentCode the department_code value
	 */
	public void setDepartmentCode (java.lang.String departmentCode) {
		this.departmentCode = departmentCode;
	}



	/**
	 * Return the value associated with the column: department_name
	 */
	public java.lang.String getDepartmentName () {
		return departmentName;
	}

	/**
	 * Set the value related to the column: department_name
	 * @param departmentName the department_name value
	 */
	public void setDepartmentName (java.lang.String departmentName) {
		this.departmentName = departmentName;
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
	 * Return the value associated with the column: bed_strength
	 */
	public java.lang.Integer getBedStrength () {
		return bedStrength;
	}

	/**
	 * Set the value related to the column: bed_strength
	 * @param bedStrength the bed_strength value
	 */
	public void setBedStrength (java.lang.Integer bedStrength) {
		this.bedStrength = bedStrength;
	}



	/**
	 * Return the value associated with the column: modality_name
	 */
	public java.lang.String getModalityName () {
		return modalityName;
	}

	/**
	 * Set the value related to the column: modality_name
	 * @param modalityName the modality_name value
	 */
	public void setModalityName (java.lang.String modalityName) {
		this.modalityName = modalityName;
	}



	/**
	 * Return the value associated with the column: dept_description
	 */
	public java.lang.String getDeptDescription () {
		return deptDescription;
	}

	/**
	 * Set the value related to the column: dept_description
	 * @param deptDescription the dept_description value
	 */
	public void setDeptDescription (java.lang.String deptDescription) {
		this.deptDescription = deptDescription;
	}



	/**
	 * Return the value associated with the column: payward_check
	 */
	public java.lang.String getPaywardCheck () {
		return paywardCheck;
	}

	/**
	 * Set the value related to the column: payward_check
	 * @param paywardCheck the payward_check value
	 */
	public void setPaywardCheck (java.lang.String paywardCheck) {
		this.paywardCheck = paywardCheck;
	}



	/**
	 * Return the value associated with the column: service_center
	 */
	public java.lang.String getServiceCenter () {
		return serviceCenter;
	}

	/**
	 * Set the value related to the column: service_center
	 * @param serviceCenter the service_center value
	 */
	public void setServiceCenter (java.lang.String serviceCenter) {
		this.serviceCenter = serviceCenter;
	}



	/**
	 * Return the value associated with the column: web_portal_display
	 */
	public java.lang.String getWebPortalDisplay () {
		return webPortalDisplay;
	}

	/**
	 * Set the value related to the column: web_portal_display
	 * @param webPortalDisplay the web_portal_display value
	 */
	public void setWebPortalDisplay (java.lang.String webPortalDisplay) {
		this.webPortalDisplay = webPortalDisplay;
	}



	/**
	 * Return the value associated with the column: visit_applicable
	 */
	public java.lang.String getVisitApplicable () {
		return visitApplicable;
	}

	/**
	 * Set the value related to the column: visit_applicable
	 * @param visitApplicable the visit_applicable value
	 */
	public void setVisitApplicable (java.lang.String visitApplicable) {
		this.visitApplicable = visitApplicable;
	}



	/**
	 * Return the value associated with the column: department_name_image
	 */
	public byte[] getDepartmentNameImage () {
		return departmentNameImage;
	}

	/**
	 * Set the value related to the column: department_name_image
	 * @param departmentNameImage the department_name_image value
	 */
	public void setDepartmentNameImage (byte[] departmentNameImage) {
		this.departmentNameImage = departmentNameImage;
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
	 * Return the value associated with the column: emp_dept_id
	 */
	public jkt.hms.masters.business.MasEmployeeDepartment getEmpDept () {
		return empDept;
	}

	/**
	 * Set the value related to the column: emp_dept_id
	 * @param empDept the emp_dept_id value
	 */
	public void setEmpDept (jkt.hms.masters.business.MasEmployeeDepartment empDept) {
		this.empDept = empDept;
	}



	/**
	 * Return the value associated with the column: cost_center_id
	 */
	public jkt.hms.masters.business.MasCostCenter getCostCenter () {
		return costCenter;
	}

	/**
	 * Set the value related to the column: cost_center_id
	 * @param costCenter the cost_center_id value
	 */
	public void setCostCenter (jkt.hms.masters.business.MasCostCenter costCenter) {
		this.costCenter = costCenter;
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
	 * Return the value associated with the column: store_type
	 */
	public jkt.hms.masters.business.MasDepartment getStoreType () {
		return storeType;
	}

	/**
	 * Set the value related to the column: store_type
	 * @param storeType the store_type value
	 */
	public void setStoreType (jkt.hms.masters.business.MasDepartment storeType) {
		this.storeType = storeType;
	}



	/**
	 * Return the value associated with the column: department_type_id
	 */
	public jkt.hms.masters.business.MasDepartmentType getDepartmentType () {
		return departmentType;
	}

	/**
	 * Set the value related to the column: department_type_id
	 * @param departmentType the department_type_id value
	 */
	public void setDepartmentType (jkt.hms.masters.business.MasDepartmentType departmentType) {
		this.departmentType = departmentType;
	}



	/**
	 * Return the value associated with the column: Discharges
	 */
	public java.util.Set<jkt.hms.masters.business.Discharge> getDischarges () {
		return discharges;
	}

	/**
	 * Set the value related to the column: Discharges
	 * @param discharges the Discharges value
	 */
	public void setDischarges (java.util.Set<jkt.hms.masters.business.Discharge> discharges) {
		this.discharges = discharges;
	}

	public void addToDischarges (jkt.hms.masters.business.Discharge discharge) {
		if (null == getDischarges()) setDischarges(new java.util.TreeSet<jkt.hms.masters.business.Discharge>());
		getDischarges().add(discharge);
	}



	/**
	 * Return the value associated with the column: OpdCardiologyDepartmentDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> getOpdCardiologyDepartmentDetails () {
		return opdCardiologyDepartmentDetails;
	}

	/**
	 * Set the value related to the column: OpdCardiologyDepartmentDetails
	 * @param opdCardiologyDepartmentDetails the OpdCardiologyDepartmentDetails value
	 */
	public void setOpdCardiologyDepartmentDetails (java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails) {
		this.opdCardiologyDepartmentDetails = opdCardiologyDepartmentDetails;
	}

	public void addToOpdCardiologyDepartmentDetails (jkt.hms.masters.business.OpdCardiologyDepartmentDetails opdCardiologyDepartmentDetails) {
		if (null == getOpdCardiologyDepartmentDetails()) setOpdCardiologyDepartmentDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdCardiologyDepartmentDetails>());
		getOpdCardiologyDepartmentDetails().add(opdCardiologyDepartmentDetails);
	}



	/**
	 * Return the value associated with the column: StoreBoos
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoos () {
		return storeBoos;
	}

	/**
	 * Set the value related to the column: StoreBoos
	 * @param storeBoos the StoreBoos value
	 */
	public void setStoreBoos (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoos) {
		this.storeBoos = storeBoos;
	}

	public void addToStoreBoos (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoos()) setStoreBoos(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoos().add(storeBoo);
	}



	/**
	 * Return the value associated with the column: IpdIntakeOutputs
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> getIpdIntakeOutputs () {
		return ipdIntakeOutputs;
	}

	/**
	 * Set the value related to the column: IpdIntakeOutputs
	 * @param ipdIntakeOutputs the IpdIntakeOutputs value
	 */
	public void setIpdIntakeOutputs (java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs) {
		this.ipdIntakeOutputs = ipdIntakeOutputs;
	}

	public void addToIpdIntakeOutputs (jkt.hms.masters.business.IpdIntakeOutput ipdIntakeOutput) {
		if (null == getIpdIntakeOutputs()) setIpdIntakeOutputs(new java.util.TreeSet<jkt.hms.masters.business.IpdIntakeOutput>());
		getIpdIntakeOutputs().add(ipdIntakeOutput);
	}



	/**
	 * Return the value associated with the column: StoreSupplyOrderEntries
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> getStoreSupplyOrderEntries () {
		return storeSupplyOrderEntries;
	}

	/**
	 * Set the value related to the column: StoreSupplyOrderEntries
	 * @param storeSupplyOrderEntries the StoreSupplyOrderEntries value
	 */
	public void setStoreSupplyOrderEntries (java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries) {
		this.storeSupplyOrderEntries = storeSupplyOrderEntries;
	}

	public void addToStoreSupplyOrderEntries (jkt.hms.masters.business.StoreSupplyOrderEntry storeSupplyOrderEntry) {
		if (null == getStoreSupplyOrderEntries()) setStoreSupplyOrderEntries(new java.util.TreeSet<jkt.hms.masters.business.StoreSupplyOrderEntry>());
		getStoreSupplyOrderEntries().add(storeSupplyOrderEntry);
	}



	/**
	 * Return the value associated with the column: MlcCases
	 */
	public java.util.Set<jkt.hms.masters.business.MlcCase> getMlcCases () {
		return mlcCases;
	}

	/**
	 * Set the value related to the column: MlcCases
	 * @param mlcCases the MlcCases value
	 */
	public void setMlcCases (java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases) {
		this.mlcCases = mlcCases;
	}

	public void addToMlcCases (jkt.hms.masters.business.MlcCase mlcCase) {
		if (null == getMlcCases()) setMlcCases(new java.util.TreeSet<jkt.hms.masters.business.MlcCase>());
		getMlcCases().add(mlcCase);
	}



	/**
	 * Return the value associated with the column: StoreAmcMsByDepartment
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAmcM> getStoreAmcMsByDepartment () {
		return storeAmcMsByDepartment;
	}

	/**
	 * Set the value related to the column: StoreAmcMsByDepartment
	 * @param storeAmcMsByDepartment the StoreAmcMsByDepartment value
	 */
	public void setStoreAmcMsByDepartment (java.util.Set<jkt.hms.masters.business.StoreAmcM> storeAmcMsByDepartment) {
		this.storeAmcMsByDepartment = storeAmcMsByDepartment;
	}

	public void addToStoreAmcMsByDepartment (jkt.hms.masters.business.StoreAmcM storeAmcM) {
		if (null == getStoreAmcMsByDepartment()) setStoreAmcMsByDepartment(new java.util.TreeSet<jkt.hms.masters.business.StoreAmcM>());
		getStoreAmcMsByDepartment().add(storeAmcM);
	}



	/**
	 * Return the value associated with the column: StoreAmcMsByEquipmentDept
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAmcM> getStoreAmcMsByEquipmentDept () {
		return storeAmcMsByEquipmentDept;
	}

	/**
	 * Set the value related to the column: StoreAmcMsByEquipmentDept
	 * @param storeAmcMsByEquipmentDept the StoreAmcMsByEquipmentDept value
	 */
	public void setStoreAmcMsByEquipmentDept (java.util.Set<jkt.hms.masters.business.StoreAmcM> storeAmcMsByEquipmentDept) {
		this.storeAmcMsByEquipmentDept = storeAmcMsByEquipmentDept;
	}

	public void addToStoreAmcMsByEquipmentDept (jkt.hms.masters.business.StoreAmcM storeAmcM) {
		if (null == getStoreAmcMsByEquipmentDept()) setStoreAmcMsByEquipmentDept(new java.util.TreeSet<jkt.hms.masters.business.StoreAmcM>());
		getStoreAmcMsByEquipmentDept().add(storeAmcM);
	}



	/**
	 * Return the value associated with the column: StoreInternalIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> getStoreInternalIndentTs () {
		return storeInternalIndentTs;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentTs
	 * @param storeInternalIndentTs the StoreInternalIndentTs value
	 */
	public void setStoreInternalIndentTs (java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs) {
		this.storeInternalIndentTs = storeInternalIndentTs;
	}

	public void addToStoreInternalIndentTs (jkt.hms.masters.business.StoreInternalIndentT storeInternalIndentT) {
		if (null == getStoreInternalIndentTs()) setStoreInternalIndentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentT>());
		getStoreInternalIndentTs().add(storeInternalIndentT);
	}



	/**
	 * Return the value associated with the column: StoreIndentSocTrackers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> getStoreIndentSocTrackers () {
		return storeIndentSocTrackers;
	}

	/**
	 * Set the value related to the column: StoreIndentSocTrackers
	 * @param storeIndentSocTrackers the StoreIndentSocTrackers value
	 */
	public void setStoreIndentSocTrackers (java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers) {
		this.storeIndentSocTrackers = storeIndentSocTrackers;
	}

	public void addToStoreIndentSocTrackers (jkt.hms.masters.business.StoreIndentSocTracker storeIndentSocTracker) {
		if (null == getStoreIndentSocTrackers()) setStoreIndentSocTrackers(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentSocTracker>());
		getStoreIndentSocTrackers().add(storeIndentSocTracker);
	}



	/**
	 * Return the value associated with the column: StoreTenderProposals
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderProposal> getStoreTenderProposals () {
		return storeTenderProposals;
	}

	/**
	 * Set the value related to the column: StoreTenderProposals
	 * @param storeTenderProposals the StoreTenderProposals value
	 */
	public void setStoreTenderProposals (java.util.Set<jkt.hms.masters.business.StoreTenderProposal> storeTenderProposals) {
		this.storeTenderProposals = storeTenderProposals;
	}

	public void addToStoreTenderProposals (jkt.hms.masters.business.StoreTenderProposal storeTenderProposal) {
		if (null == getStoreTenderProposals()) setStoreTenderProposals(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderProposal>());
		getStoreTenderProposals().add(storeTenderProposal);
	}



	/**
	 * Return the value associated with the column: StoreBalanceMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBalanceM> getStoreBalanceMs () {
		return storeBalanceMs;
	}

	/**
	 * Set the value related to the column: StoreBalanceMs
	 * @param storeBalanceMs the StoreBalanceMs value
	 */
	public void setStoreBalanceMs (java.util.Set<jkt.hms.masters.business.StoreBalanceM> storeBalanceMs) {
		this.storeBalanceMs = storeBalanceMs;
	}

	public void addToStoreBalanceMs (jkt.hms.masters.business.StoreBalanceM storeBalanceM) {
		if (null == getStoreBalanceMs()) setStoreBalanceMs(new java.util.TreeSet<jkt.hms.masters.business.StoreBalanceM>());
		getStoreBalanceMs().add(storeBalanceM);
	}



	/**
	 * Return the value associated with the column: OpdTemplateInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> getOpdTemplateInvestigations () {
		return opdTemplateInvestigations;
	}

	/**
	 * Set the value related to the column: OpdTemplateInvestigations
	 * @param opdTemplateInvestigations the OpdTemplateInvestigations value
	 */
	public void setOpdTemplateInvestigations (java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> opdTemplateInvestigations) {
		this.opdTemplateInvestigations = opdTemplateInvestigations;
	}

	public void addToOpdTemplateInvestigations (jkt.hms.masters.business.OpdTemplateInvestigation opdTemplateInvestigation) {
		if (null == getOpdTemplateInvestigations()) setOpdTemplateInvestigations(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplateInvestigation>());
		getOpdTemplateInvestigations().add(opdTemplateInvestigation);
	}



	/**
	 * Return the value associated with the column: StorePoHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoHeader> getStorePoHeaders () {
		return storePoHeaders;
	}

	/**
	 * Set the value related to the column: StorePoHeaders
	 * @param storePoHeaders the StorePoHeaders value
	 */
	public void setStorePoHeaders (java.util.Set<jkt.hms.masters.business.StorePoHeader> storePoHeaders) {
		this.storePoHeaders = storePoHeaders;
	}

	public void addToStorePoHeaders (jkt.hms.masters.business.StorePoHeader storePoHeader) {
		if (null == getStorePoHeaders()) setStorePoHeaders(new java.util.TreeSet<jkt.hms.masters.business.StorePoHeader>());
		getStorePoHeaders().add(storePoHeader);
	}



	/**
	 * Return the value associated with the column: StoreGrnReturnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> getStoreGrnReturnMs () {
		return storeGrnReturnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnMs
	 * @param storeGrnReturnMs the StoreGrnReturnMs value
	 */
	public void setStoreGrnReturnMs (java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMs) {
		this.storeGrnReturnMs = storeGrnReturnMs;
	}

	public void addToStoreGrnReturnMs (jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM) {
		if (null == getStoreGrnReturnMs()) setStoreGrnReturnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnM>());
		getStoreGrnReturnMs().add(storeGrnReturnM);
	}



	/**
	 * Return the value associated with the column: OpdGastroEnterologyColonoscopies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> getOpdGastroEnterologyColonoscopies () {
		return opdGastroEnterologyColonoscopies;
	}

	/**
	 * Set the value related to the column: OpdGastroEnterologyColonoscopies
	 * @param opdGastroEnterologyColonoscopies the OpdGastroEnterologyColonoscopies value
	 */
	public void setOpdGastroEnterologyColonoscopies (java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopies) {
		this.opdGastroEnterologyColonoscopies = opdGastroEnterologyColonoscopies;
	}

	public void addToOpdGastroEnterologyColonoscopies (jkt.hms.masters.business.OpdGastroEnterologyColonoscopy opdGastroEnterologyColonoscopy) {
		if (null == getOpdGastroEnterologyColonoscopies()) setOpdGastroEnterologyColonoscopies(new java.util.TreeSet<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy>());
		getOpdGastroEnterologyColonoscopies().add(opdGastroEnterologyColonoscopy);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByDepartment
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByDepartment () {
		return storeIssueMsByDepartment;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByDepartment
	 * @param storeIssueMsByDepartment the StoreIssueMsByDepartment value
	 */
	public void setStoreIssueMsByDepartment (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByDepartment) {
		this.storeIssueMsByDepartment = storeIssueMsByDepartment;
	}

	public void addToStoreIssueMsByDepartment (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByDepartment()) setStoreIssueMsByDepartment(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByDepartment().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByToStore
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByToStore () {
		return storeIssueMsByToStore;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByToStore
	 * @param storeIssueMsByToStore the StoreIssueMsByToStore value
	 */
	public void setStoreIssueMsByToStore (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByToStore) {
		this.storeIssueMsByToStore = storeIssueMsByToStore;
	}

	public void addToStoreIssueMsByToStore (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByToStore()) setStoreIssueMsByToStore(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByToStore().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: StoreStockTakingMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreStockTakingM> getStoreStockTakingMs () {
		return storeStockTakingMs;
	}

	/**
	 * Set the value related to the column: StoreStockTakingMs
	 * @param storeStockTakingMs the StoreStockTakingMs value
	 */
	public void setStoreStockTakingMs (java.util.Set<jkt.hms.masters.business.StoreStockTakingM> storeStockTakingMs) {
		this.storeStockTakingMs = storeStockTakingMs;
	}

	public void addToStoreStockTakingMs (jkt.hms.masters.business.StoreStockTakingM storeStockTakingM) {
		if (null == getStoreStockTakingMs()) setStoreStockTakingMs(new java.util.TreeSet<jkt.hms.masters.business.StoreStockTakingM>());
		getStoreStockTakingMs().add(storeStockTakingM);
	}



	/**
	 * Return the value associated with the column: StoreTenderCommBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> getStoreTenderCommBidMs () {
		return storeTenderCommBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderCommBidMs
	 * @param storeTenderCommBidMs the StoreTenderCommBidMs value
	 */
	public void setStoreTenderCommBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs) {
		this.storeTenderCommBidMs = storeTenderCommBidMs;
	}

	public void addToStoreTenderCommBidMs (jkt.hms.masters.business.StoreTenderCommBidM storeTenderCommBidM) {
		if (null == getStoreTenderCommBidMs()) setStoreTenderCommBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderCommBidM>());
		getStoreTenderCommBidMs().add(storeTenderCommBidM);
	}



	/**
	 * Return the value associated with the column: StoreCondemnationMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreCondemnationM> getStoreCondemnationMs () {
		return storeCondemnationMs;
	}

	/**
	 * Set the value related to the column: StoreCondemnationMs
	 * @param storeCondemnationMs the StoreCondemnationMs value
	 */
	public void setStoreCondemnationMs (java.util.Set<jkt.hms.masters.business.StoreCondemnationM> storeCondemnationMs) {
		this.storeCondemnationMs = storeCondemnationMs;
	}

	public void addToStoreCondemnationMs (jkt.hms.masters.business.StoreCondemnationM storeCondemnationM) {
		if (null == getStoreCondemnationMs()) setStoreCondemnationMs(new java.util.TreeSet<jkt.hms.masters.business.StoreCondemnationM>());
		getStoreCondemnationMs().add(storeCondemnationM);
	}



	/**
	 * Return the value associated with the column: Ipdcaredetails
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdcaredetail> getIpdcaredetails () {
		return ipdcaredetails;
	}

	/**
	 * Set the value related to the column: Ipdcaredetails
	 * @param ipdcaredetails the Ipdcaredetails value
	 */
	public void setIpdcaredetails (java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails) {
		this.ipdcaredetails = ipdcaredetails;
	}

	public void addToIpdcaredetails (jkt.hms.masters.business.Ipdcaredetail ipdcaredetail) {
		if (null == getIpdcaredetails()) setIpdcaredetails(new java.util.TreeSet<jkt.hms.masters.business.Ipdcaredetail>());
		getIpdcaredetails().add(ipdcaredetail);
	}



	/**
	 * Return the value associated with the column: StoreSocs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSoc> getStoreSocs () {
		return storeSocs;
	}

	/**
	 * Set the value related to the column: StoreSocs
	 * @param storeSocs the StoreSocs value
	 */
	public void setStoreSocs (java.util.Set<jkt.hms.masters.business.StoreSoc> storeSocs) {
		this.storeSocs = storeSocs;
	}

	public void addToStoreSocs (jkt.hms.masters.business.StoreSoc storeSoc) {
		if (null == getStoreSocs()) setStoreSocs(new java.util.TreeSet<jkt.hms.masters.business.StoreSoc>());
		getStoreSocs().add(storeSoc);
	}



	/**
	 * Return the value associated with the column: UserHospitalDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> getUserHospitalDepartments () {
		return userHospitalDepartments;
	}

	/**
	 * Set the value related to the column: UserHospitalDepartments
	 * @param userHospitalDepartments the UserHospitalDepartments value
	 */
	public void setUserHospitalDepartments (java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments) {
		this.userHospitalDepartments = userHospitalDepartments;
	}

	public void addToUserHospitalDepartments (jkt.hms.masters.business.UserHospitalDepartment userHospitalDepartment) {
		if (null == getUserHospitalDepartments()) setUserHospitalDepartments(new java.util.TreeSet<jkt.hms.masters.business.UserHospitalDepartment>());
		getUserHospitalDepartments().add(userHospitalDepartment);
	}



	/**
	 * Return the value associated with the column: AppPatientAppointments
	 */
	public java.util.Set<jkt.hms.masters.business.AppPatientAppointments> getAppPatientAppointments () {
		return appPatientAppointments;
	}

	/**
	 * Set the value related to the column: AppPatientAppointments
	 * @param appPatientAppointments the AppPatientAppointments value
	 */
	public void setAppPatientAppointments (java.util.Set<jkt.hms.masters.business.AppPatientAppointments> appPatientAppointments) {
		this.appPatientAppointments = appPatientAppointments;
	}

	public void addToAppPatientAppointments (jkt.hms.masters.business.AppPatientAppointments appPatientAppointments) {
		if (null == getAppPatientAppointments()) setAppPatientAppointments(new java.util.TreeSet<jkt.hms.masters.business.AppPatientAppointments>());
		getAppPatientAppointments().add(appPatientAppointments);
	}



	/**
	 * Return the value associated with the column: NursingfoodTests
	 */
	public java.util.Set<jkt.hms.masters.business.NursingfoodTest> getNursingfoodTests () {
		return nursingfoodTests;
	}

	/**
	 * Set the value related to the column: NursingfoodTests
	 * @param nursingfoodTests the NursingfoodTests value
	 */
	public void setNursingfoodTests (java.util.Set<jkt.hms.masters.business.NursingfoodTest> nursingfoodTests) {
		this.nursingfoodTests = nursingfoodTests;
	}

	public void addToNursingfoodTests (jkt.hms.masters.business.NursingfoodTest nursingfoodTest) {
		if (null == getNursingfoodTests()) setNursingfoodTests(new java.util.TreeSet<jkt.hms.masters.business.NursingfoodTest>());
		getNursingfoodTests().add(nursingfoodTest);
	}



	/**
	 * Return the value associated with the column: OpdTemplateTreatments
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> getOpdTemplateTreatments () {
		return opdTemplateTreatments;
	}

	/**
	 * Set the value related to the column: OpdTemplateTreatments
	 * @param opdTemplateTreatments the OpdTemplateTreatments value
	 */
	public void setOpdTemplateTreatments (java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> opdTemplateTreatments) {
		this.opdTemplateTreatments = opdTemplateTreatments;
	}

	public void addToOpdTemplateTreatments (jkt.hms.masters.business.OpdTemplateTreatment opdTemplateTreatment) {
		if (null == getOpdTemplateTreatments()) setOpdTemplateTreatments(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplateTreatment>());
		getOpdTemplateTreatments().add(opdTemplateTreatment);
	}



	/**
	 * Return the value associated with the column: StoreIndentMsByDepartment
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentM> getStoreIndentMsByDepartment () {
		return storeIndentMsByDepartment;
	}

	/**
	 * Set the value related to the column: StoreIndentMsByDepartment
	 * @param storeIndentMsByDepartment the StoreIndentMsByDepartment value
	 */
	public void setStoreIndentMsByDepartment (java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMsByDepartment) {
		this.storeIndentMsByDepartment = storeIndentMsByDepartment;
	}

	public void addToStoreIndentMsByDepartment (jkt.hms.masters.business.StoreIndentM storeIndentM) {
		if (null == getStoreIndentMsByDepartment()) setStoreIndentMsByDepartment(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentM>());
		getStoreIndentMsByDepartment().add(storeIndentM);
	}



	/**
	 * Return the value associated with the column: StoreIndentMsByItemReqDept
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentM> getStoreIndentMsByItemReqDept () {
		return storeIndentMsByItemReqDept;
	}

	/**
	 * Set the value related to the column: StoreIndentMsByItemReqDept
	 * @param storeIndentMsByItemReqDept the StoreIndentMsByItemReqDept value
	 */
	public void setStoreIndentMsByItemReqDept (java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMsByItemReqDept) {
		this.storeIndentMsByItemReqDept = storeIndentMsByItemReqDept;
	}

	public void addToStoreIndentMsByItemReqDept (jkt.hms.masters.business.StoreIndentM storeIndentM) {
		if (null == getStoreIndentMsByItemReqDept()) setStoreIndentMsByItemReqDept(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentM>());
		getStoreIndentMsByItemReqDept().add(storeIndentM);
	}



	/**
	 * Return the value associated with the column: StoreMmfDepartmentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> getStoreMmfDepartmentMs () {
		return storeMmfDepartmentMs;
	}

	/**
	 * Set the value related to the column: StoreMmfDepartmentMs
	 * @param storeMmfDepartmentMs the StoreMmfDepartmentMs value
	 */
	public void setStoreMmfDepartmentMs (java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> storeMmfDepartmentMs) {
		this.storeMmfDepartmentMs = storeMmfDepartmentMs;
	}

	public void addToStoreMmfDepartmentMs (jkt.hms.masters.business.StoreMmfDepartmentM storeMmfDepartmentM) {
		if (null == getStoreMmfDepartmentMs()) setStoreMmfDepartmentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreMmfDepartmentM>());
		getStoreMmfDepartmentMs().add(storeMmfDepartmentM);
	}



	/**
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees () {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * @param masEmployees the MasEmployees value
	 */
	public void setMasEmployees (java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees (jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees()) setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
	}



	/**
	 * Return the value associated with the column: AppInvestigationAppointments
	 */
	public java.util.Set<jkt.hms.masters.business.AppInvestigationAppointments> getAppInvestigationAppointments () {
		return appInvestigationAppointments;
	}

	/**
	 * Set the value related to the column: AppInvestigationAppointments
	 * @param appInvestigationAppointments the AppInvestigationAppointments value
	 */
	public void setAppInvestigationAppointments (java.util.Set<jkt.hms.masters.business.AppInvestigationAppointments> appInvestigationAppointments) {
		this.appInvestigationAppointments = appInvestigationAppointments;
	}

	public void addToAppInvestigationAppointments (jkt.hms.masters.business.AppInvestigationAppointments appInvestigationAppointments) {
		if (null == getAppInvestigationAppointments()) setAppInvestigationAppointments(new java.util.TreeSet<jkt.hms.masters.business.AppInvestigationAppointments>());
		getAppInvestigationAppointments().add(appInvestigationAppointments);
	}



	/**
	 * Return the value associated with the column: StoreItemLogTransactions
	 */
	public java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> getStoreItemLogTransactions () {
		return storeItemLogTransactions;
	}

	/**
	 * Set the value related to the column: StoreItemLogTransactions
	 * @param storeItemLogTransactions the StoreItemLogTransactions value
	 */
	public void setStoreItemLogTransactions (java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> storeItemLogTransactions) {
		this.storeItemLogTransactions = storeItemLogTransactions;
	}

	public void addToStoreItemLogTransactions (jkt.hms.masters.business.StoreItemLogTransaction storeItemLogTransaction) {
		if (null == getStoreItemLogTransactions()) setStoreItemLogTransactions(new java.util.TreeSet<jkt.hms.masters.business.StoreItemLogTransaction>());
		getStoreItemLogTransactions().add(storeItemLogTransaction);
	}



	/**
	 * Return the value associated with the column: OpdPatientHistories
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientHistory> getOpdPatientHistories () {
		return opdPatientHistories;
	}

	/**
	 * Set the value related to the column: OpdPatientHistories
	 * @param opdPatientHistories the OpdPatientHistories value
	 */
	public void setOpdPatientHistories (java.util.Set<jkt.hms.masters.business.OpdPatientHistory> opdPatientHistories) {
		this.opdPatientHistories = opdPatientHistories;
	}

	public void addToOpdPatientHistories (jkt.hms.masters.business.OpdPatientHistory opdPatientHistory) {
		if (null == getOpdPatientHistories()) setOpdPatientHistories(new java.util.TreeSet<jkt.hms.masters.business.OpdPatientHistory>());
		getOpdPatientHistories().add(opdPatientHistory);
	}



	/**
	 * Return the value associated with the column: StoreFyDocumentNos
	 */
	public java.util.Set<jkt.hms.masters.business.StoreFyDocumentNo> getStoreFyDocumentNos () {
		return storeFyDocumentNos;
	}

	/**
	 * Set the value related to the column: StoreFyDocumentNos
	 * @param storeFyDocumentNos the StoreFyDocumentNos value
	 */
	public void setStoreFyDocumentNos (java.util.Set<jkt.hms.masters.business.StoreFyDocumentNo> storeFyDocumentNos) {
		this.storeFyDocumentNos = storeFyDocumentNos;
	}

	public void addToStoreFyDocumentNos (jkt.hms.masters.business.StoreFyDocumentNo storeFyDocumentNo) {
		if (null == getStoreFyDocumentNos()) setStoreFyDocumentNos(new java.util.TreeSet<jkt.hms.masters.business.StoreFyDocumentNo>());
		getStoreFyDocumentNos().add(storeFyDocumentNo);
	}



	/**
	 * Return the value associated with the column: OpdTemplates
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplate> getOpdTemplates () {
		return opdTemplates;
	}

	/**
	 * Set the value related to the column: OpdTemplates
	 * @param opdTemplates the OpdTemplates value
	 */
	public void setOpdTemplates (java.util.Set<jkt.hms.masters.business.OpdTemplate> opdTemplates) {
		this.opdTemplates = opdTemplates;
	}

	public void addToOpdTemplates (jkt.hms.masters.business.OpdTemplate opdTemplate) {
		if (null == getOpdTemplates()) setOpdTemplates(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplate>());
		getOpdTemplates().add(opdTemplate);
	}



	/**
	 * Return the value associated with the column: StoreAdjustmentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> getStoreAdjustmentMs () {
		return storeAdjustmentMs;
	}

	/**
	 * Set the value related to the column: StoreAdjustmentMs
	 * @param storeAdjustmentMs the StoreAdjustmentMs value
	 */
	public void setStoreAdjustmentMs (java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs) {
		this.storeAdjustmentMs = storeAdjustmentMs;
	}

	public void addToStoreAdjustmentMs (jkt.hms.masters.business.StoreAdjustmentM storeAdjustmentM) {
		if (null == getStoreAdjustmentMs()) setStoreAdjustmentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreAdjustmentM>());
		getStoreAdjustmentMs().add(storeAdjustmentM);
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnMsByFromDepartment
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> getStoreInternalReturnMsByFromDepartment () {
		return storeInternalReturnMsByFromDepartment;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnMsByFromDepartment
	 * @param storeInternalReturnMsByFromDepartment the StoreInternalReturnMsByFromDepartment value
	 */
	public void setStoreInternalReturnMsByFromDepartment (java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByFromDepartment) {
		this.storeInternalReturnMsByFromDepartment = storeInternalReturnMsByFromDepartment;
	}

	public void addToStoreInternalReturnMsByFromDepartment (jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM) {
		if (null == getStoreInternalReturnMsByFromDepartment()) setStoreInternalReturnMsByFromDepartment(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnM>());
		getStoreInternalReturnMsByFromDepartment().add(storeInternalReturnM);
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnMsByToDepartment
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> getStoreInternalReturnMsByToDepartment () {
		return storeInternalReturnMsByToDepartment;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnMsByToDepartment
	 * @param storeInternalReturnMsByToDepartment the StoreInternalReturnMsByToDepartment value
	 */
	public void setStoreInternalReturnMsByToDepartment (java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByToDepartment) {
		this.storeInternalReturnMsByToDepartment = storeInternalReturnMsByToDepartment;
	}

	public void addToStoreInternalReturnMsByToDepartment (jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM) {
		if (null == getStoreInternalReturnMsByToDepartment()) setStoreInternalReturnMsByToDepartment(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnM>());
		getStoreInternalReturnMsByToDepartment().add(storeInternalReturnM);
	}



	/**
	 * Return the value associated with the column: OpdVaccinationPlans
	 */
	public java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> getOpdVaccinationPlans () {
		return opdVaccinationPlans;
	}

	/**
	 * Set the value related to the column: OpdVaccinationPlans
	 * @param opdVaccinationPlans the OpdVaccinationPlans value
	 */
	public void setOpdVaccinationPlans (java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans) {
		this.opdVaccinationPlans = opdVaccinationPlans;
	}

	public void addToOpdVaccinationPlans (jkt.hms.masters.business.OpdVaccinationPlan opdVaccinationPlan) {
		if (null == getOpdVaccinationPlans()) setOpdVaccinationPlans(new java.util.TreeSet<jkt.hms.masters.business.OpdVaccinationPlan>());
		getOpdVaccinationPlans().add(opdVaccinationPlan);
	}



	/**
	 * Return the value associated with the column: StoreWorkOrderMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> getStoreWorkOrderMs () {
		return storeWorkOrderMs;
	}

	/**
	 * Set the value related to the column: StoreWorkOrderMs
	 * @param storeWorkOrderMs the StoreWorkOrderMs value
	 */
	public void setStoreWorkOrderMs (java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> storeWorkOrderMs) {
		this.storeWorkOrderMs = storeWorkOrderMs;
	}

	public void addToStoreWorkOrderMs (jkt.hms.masters.business.StoreWorkOrderM storeWorkOrderM) {
		if (null == getStoreWorkOrderMs()) setStoreWorkOrderMs(new java.util.TreeSet<jkt.hms.masters.business.StoreWorkOrderM>());
		getStoreWorkOrderMs().add(storeWorkOrderM);
	}



	/**
	 * Return the value associated with the column: PatientInvestigationHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> getPatientInvestigationHeaders () {
		return patientInvestigationHeaders;
	}

	/**
	 * Set the value related to the column: PatientInvestigationHeaders
	 * @param patientInvestigationHeaders the PatientInvestigationHeaders value
	 */
	public void setPatientInvestigationHeaders (java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders) {
		this.patientInvestigationHeaders = patientInvestigationHeaders;
	}

	public void addToPatientInvestigationHeaders (jkt.hms.masters.business.PatientInvestigationHeader patientInvestigationHeader) {
		if (null == getPatientInvestigationHeaders()) setPatientInvestigationHeaders(new java.util.TreeSet<jkt.hms.masters.business.PatientInvestigationHeader>());
		getPatientInvestigationHeaders().add(patientInvestigationHeader);
	}



	/**
	 * Return the value associated with the column: OpdCaseSheets
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCaseSheet> getOpdCaseSheets () {
		return opdCaseSheets;
	}

	/**
	 * Set the value related to the column: OpdCaseSheets
	 * @param opdCaseSheets the OpdCaseSheets value
	 */
	public void setOpdCaseSheets (java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets) {
		this.opdCaseSheets = opdCaseSheets;
	}

	public void addToOpdCaseSheets (jkt.hms.masters.business.OpdCaseSheet opdCaseSheet) {
		if (null == getOpdCaseSheets()) setOpdCaseSheets(new java.util.TreeSet<jkt.hms.masters.business.OpdCaseSheet>());
		getOpdCaseSheets().add(opdCaseSheet);
	}



	/**
	 * Return the value associated with the column: StoreMeScaleDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> getStoreMeScaleDetails () {
		return storeMeScaleDetails;
	}

	/**
	 * Set the value related to the column: StoreMeScaleDetails
	 * @param storeMeScaleDetails the StoreMeScaleDetails value
	 */
	public void setStoreMeScaleDetails (java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails) {
		this.storeMeScaleDetails = storeMeScaleDetails;
	}

	public void addToStoreMeScaleDetails (jkt.hms.masters.business.StoreMeScaleDetails storeMeScaleDetails) {
		if (null == getStoreMeScaleDetails()) setStoreMeScaleDetails(new java.util.TreeSet<jkt.hms.masters.business.StoreMeScaleDetails>());
		getStoreMeScaleDetails().add(storeMeScaleDetails);
	}



	/**
	 * Return the value associated with the column: MasStoreItemTemplates
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> getMasStoreItemTemplates () {
		return masStoreItemTemplates;
	}

	/**
	 * Set the value related to the column: MasStoreItemTemplates
	 * @param masStoreItemTemplates the MasStoreItemTemplates value
	 */
	public void setMasStoreItemTemplates (java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> masStoreItemTemplates) {
		this.masStoreItemTemplates = masStoreItemTemplates;
	}

	public void addToMasStoreItemTemplates (jkt.hms.masters.business.MasStoreItemTemplate masStoreItemTemplate) {
		if (null == getMasStoreItemTemplates()) setMasStoreItemTemplates(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItemTemplate>());
		getMasStoreItemTemplates().add(masStoreItemTemplate);
	}



	/**
	 * Return the value associated with the column: StoreBosMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBosM> getStoreBosMs () {
		return storeBosMs;
	}

	/**
	 * Set the value related to the column: StoreBosMs
	 * @param storeBosMs the StoreBosMs value
	 */
	public void setStoreBosMs (java.util.Set<jkt.hms.masters.business.StoreBosM> storeBosMs) {
		this.storeBosMs = storeBosMs;
	}

	public void addToStoreBosMs (jkt.hms.masters.business.StoreBosM storeBosM) {
		if (null == getStoreBosMs()) setStoreBosMs(new java.util.TreeSet<jkt.hms.masters.business.StoreBosM>());
		getStoreBosMs().add(storeBosM);
	}



	/**
	 * Return the value associated with the column: StoreItemBatchStocks
	 */
	public java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> getStoreItemBatchStocks () {
		return storeItemBatchStocks;
	}

	/**
	 * Set the value related to the column: StoreItemBatchStocks
	 * @param storeItemBatchStocks the StoreItemBatchStocks value
	 */
	public void setStoreItemBatchStocks (java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> storeItemBatchStocks) {
		this.storeItemBatchStocks = storeItemBatchStocks;
	}

	public void addToStoreItemBatchStocks (jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock) {
		if (null == getStoreItemBatchStocks()) setStoreItemBatchStocks(new java.util.TreeSet<jkt.hms.masters.business.StoreItemBatchStock>());
		getStoreItemBatchStocks().add(storeItemBatchStock);
	}



	/**
	 * Return the value associated with the column: UserDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.UserDepartment> getUserDepartments () {
		return userDepartments;
	}

	/**
	 * Set the value related to the column: UserDepartments
	 * @param userDepartments the UserDepartments value
	 */
	public void setUserDepartments (java.util.Set<jkt.hms.masters.business.UserDepartment> userDepartments) {
		this.userDepartments = userDepartments;
	}

	public void addToUserDepartments (jkt.hms.masters.business.UserDepartment userDepartment) {
		if (null == getUserDepartments()) setUserDepartments(new java.util.TreeSet<jkt.hms.masters.business.UserDepartment>());
		getUserDepartments().add(userDepartment);
	}



	/**
	 * Return the value associated with the column: StoreTenderLocalPurchaseMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> getStoreTenderLocalPurchaseMs () {
		return storeTenderLocalPurchaseMs;
	}

	/**
	 * Set the value related to the column: StoreTenderLocalPurchaseMs
	 * @param storeTenderLocalPurchaseMs the StoreTenderLocalPurchaseMs value
	 */
	public void setStoreTenderLocalPurchaseMs (java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMs) {
		this.storeTenderLocalPurchaseMs = storeTenderLocalPurchaseMs;
	}

	public void addToStoreTenderLocalPurchaseMs (jkt.hms.masters.business.StoreTenderLocalPurchaseM storeTenderLocalPurchaseM) {
		if (null == getStoreTenderLocalPurchaseMs()) setStoreTenderLocalPurchaseMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderLocalPurchaseM>());
		getStoreTenderLocalPurchaseMs().add(storeTenderLocalPurchaseM);
	}



	/**
	 * Return the value associated with the column: StoreQuotationRequestMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationRequestM> getStoreQuotationRequestMs () {
		return storeQuotationRequestMs;
	}

	/**
	 * Set the value related to the column: StoreQuotationRequestMs
	 * @param storeQuotationRequestMs the StoreQuotationRequestMs value
	 */
	public void setStoreQuotationRequestMs (java.util.Set<jkt.hms.masters.business.StoreQuotationRequestM> storeQuotationRequestMs) {
		this.storeQuotationRequestMs = storeQuotationRequestMs;
	}

	public void addToStoreQuotationRequestMs (jkt.hms.masters.business.StoreQuotationRequestM storeQuotationRequestM) {
		if (null == getStoreQuotationRequestMs()) setStoreQuotationRequestMs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationRequestM>());
		getStoreQuotationRequestMs().add(storeQuotationRequestM);
	}



	/**
	 * Return the value associated with the column: AppInvestigationSetups
	 */
	public java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> getAppInvestigationSetups () {
		return appInvestigationSetups;
	}

	/**
	 * Set the value related to the column: AppInvestigationSetups
	 * @param appInvestigationSetups the AppInvestigationSetups value
	 */
	public void setAppInvestigationSetups (java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> appInvestigationSetups) {
		this.appInvestigationSetups = appInvestigationSetups;
	}

	public void addToAppInvestigationSetups (jkt.hms.masters.business.AppInvestigationSetup appInvestigationSetup) {
		if (null == getAppInvestigationSetups()) setAppInvestigationSetups(new java.util.TreeSet<jkt.hms.masters.business.AppInvestigationSetup>());
		getAppInvestigationSetups().add(appInvestigationSetup);
	}



	/**
	 * Return the value associated with the column: StoreQuaterReturnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuaterReturnM> getStoreQuaterReturnMs () {
		return storeQuaterReturnMs;
	}

	/**
	 * Set the value related to the column: StoreQuaterReturnMs
	 * @param storeQuaterReturnMs the StoreQuaterReturnMs value
	 */
	public void setStoreQuaterReturnMs (java.util.Set<jkt.hms.masters.business.StoreQuaterReturnM> storeQuaterReturnMs) {
		this.storeQuaterReturnMs = storeQuaterReturnMs;
	}

	public void addToStoreQuaterReturnMs (jkt.hms.masters.business.StoreQuaterReturnM storeQuaterReturnM) {
		if (null == getStoreQuaterReturnMs()) setStoreQuaterReturnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuaterReturnM>());
		getStoreQuaterReturnMs().add(storeQuaterReturnM);
	}



	/**
	 * Return the value associated with the column: StoreIpIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIpIssueM> getStoreIpIssueMs () {
		return storeIpIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIpIssueMs
	 * @param storeIpIssueMs the StoreIpIssueMs value
	 */
	public void setStoreIpIssueMs (java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs) {
		this.storeIpIssueMs = storeIpIssueMs;
	}

	public void addToStoreIpIssueMs (jkt.hms.masters.business.StoreIpIssueM storeIpIssueM) {
		if (null == getStoreIpIssueMs()) setStoreIpIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIpIssueM>());
		getStoreIpIssueMs().add(storeIpIssueM);
	}



	/**
	 * Return the value associated with the column: MasRooms
	 */
	public java.util.Set<jkt.hms.masters.business.MasRoom> getMasRooms () {
		return masRooms;
	}

	/**
	 * Set the value related to the column: MasRooms
	 * @param masRooms the MasRooms value
	 */
	public void setMasRooms (java.util.Set<jkt.hms.masters.business.MasRoom> masRooms) {
		this.masRooms = masRooms;
	}

	public void addToMasRooms (jkt.hms.masters.business.MasRoom masRoom) {
		if (null == getMasRooms()) setMasRooms(new java.util.TreeSet<jkt.hms.masters.business.MasRoom>());
		getMasRooms().add(masRoom);
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> getStoreOpPatientIssueMs () {
		return storeOpPatientIssueMs;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueMs
	 * @param storeOpPatientIssueMs the StoreOpPatientIssueMs value
	 */
	public void setStoreOpPatientIssueMs (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs) {
		this.storeOpPatientIssueMs = storeOpPatientIssueMs;
	}

	public void addToStoreOpPatientIssueMs (jkt.hms.masters.business.StoreOpPatientIssueM storeOpPatientIssueM) {
		if (null == getStoreOpPatientIssueMs()) setStoreOpPatientIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueM>());
		getStoreOpPatientIssueMs().add(storeOpPatientIssueM);
	}



	/**
	 * Return the value associated with the column: StoreDefectiveDrugMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> getStoreDefectiveDrugMs () {
		return storeDefectiveDrugMs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugMs
	 * @param storeDefectiveDrugMs the StoreDefectiveDrugMs value
	 */
	public void setStoreDefectiveDrugMs (java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> storeDefectiveDrugMs) {
		this.storeDefectiveDrugMs = storeDefectiveDrugMs;
	}

	public void addToStoreDefectiveDrugMs (jkt.hms.masters.business.StoreDefectiveDrugM storeDefectiveDrugM) {
		if (null == getStoreDefectiveDrugMs()) setStoreDefectiveDrugMs(new java.util.TreeSet<jkt.hms.masters.business.StoreDefectiveDrugM>());
		getStoreDefectiveDrugMs().add(storeDefectiveDrugM);
	}



	/**
	 * Return the value associated with the column: StoreRepairCivilFirms
	 */
	public java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> getStoreRepairCivilFirms () {
		return storeRepairCivilFirms;
	}

	/**
	 * Set the value related to the column: StoreRepairCivilFirms
	 * @param storeRepairCivilFirms the StoreRepairCivilFirms value
	 */
	public void setStoreRepairCivilFirms (java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> storeRepairCivilFirms) {
		this.storeRepairCivilFirms = storeRepairCivilFirms;
	}

	public void addToStoreRepairCivilFirms (jkt.hms.masters.business.StoreRepairCivilFirm storeRepairCivilFirm) {
		if (null == getStoreRepairCivilFirms()) setStoreRepairCivilFirms(new java.util.TreeSet<jkt.hms.masters.business.StoreRepairCivilFirm>());
		getStoreRepairCivilFirms().add(storeRepairCivilFirm);
	}



	/**
	 * Return the value associated with the column: OpdObgs
	 */
	public java.util.Set<jkt.hms.masters.business.OpdObg> getOpdObgs () {
		return opdObgs;
	}

	/**
	 * Set the value related to the column: OpdObgs
	 * @param opdObgs the OpdObgs value
	 */
	public void setOpdObgs (java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs) {
		this.opdObgs = opdObgs;
	}

	public void addToOpdObgs (jkt.hms.masters.business.OpdObg opdObg) {
		if (null == getOpdObgs()) setOpdObgs(new java.util.TreeSet<jkt.hms.masters.business.OpdObg>());
		getOpdObgs().add(opdObg);
	}



	/**
	 * Return the value associated with the column: DgOrderhds
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderhd> getDgOrderhds () {
		return dgOrderhds;
	}

	/**
	 * Set the value related to the column: DgOrderhds
	 * @param dgOrderhds the DgOrderhds value
	 */
	public void setDgOrderhds (java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds) {
		this.dgOrderhds = dgOrderhds;
	}

	public void addToDgOrderhds (jkt.hms.masters.business.DgOrderhd dgOrderhd) {
		if (null == getDgOrderhds()) setDgOrderhds(new java.util.TreeSet<jkt.hms.masters.business.DgOrderhd>());
		getDgOrderhds().add(dgOrderhd);
	}



	/**
	 * Return the value associated with the column: MasChargeCodes
	 */
	public java.util.Set<jkt.hms.masters.business.MasChargeCode> getMasChargeCodes () {
		return masChargeCodes;
	}

	/**
	 * Set the value related to the column: MasChargeCodes
	 * @param masChargeCodes the MasChargeCodes value
	 */
	public void setMasChargeCodes (java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes) {
		this.masChargeCodes = masChargeCodes;
	}

	public void addToMasChargeCodes (jkt.hms.masters.business.MasChargeCode masChargeCode) {
		if (null == getMasChargeCodes()) setMasChargeCodes(new java.util.TreeSet<jkt.hms.masters.business.MasChargeCode>());
		getMasChargeCodes().add(masChargeCode);
	}



	/**
	 * Return the value associated with the column: MasReferralDoctors
	 */
	public java.util.Set<jkt.hms.masters.business.MasReferralDoctor> getMasReferralDoctors () {
		return masReferralDoctors;
	}

	/**
	 * Set the value related to the column: MasReferralDoctors
	 * @param masReferralDoctors the MasReferralDoctors value
	 */
	public void setMasReferralDoctors (java.util.Set<jkt.hms.masters.business.MasReferralDoctor> masReferralDoctors) {
		this.masReferralDoctors = masReferralDoctors;
	}

	public void addToMasReferralDoctors (jkt.hms.masters.business.MasReferralDoctor masReferralDoctor) {
		if (null == getMasReferralDoctors()) setMasReferralDoctors(new java.util.TreeSet<jkt.hms.masters.business.MasReferralDoctor>());
		getMasReferralDoctors().add(masReferralDoctor);
	}



	/**
	 * Return the value associated with the column: IpdIntakeOutputCharts
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> getIpdIntakeOutputCharts () {
		return ipdIntakeOutputCharts;
	}

	/**
	 * Set the value related to the column: IpdIntakeOutputCharts
	 * @param ipdIntakeOutputCharts the IpdIntakeOutputCharts value
	 */
	public void setIpdIntakeOutputCharts (java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts) {
		this.ipdIntakeOutputCharts = ipdIntakeOutputCharts;
	}

	public void addToIpdIntakeOutputCharts (jkt.hms.masters.business.IpdIntakeOutputChart ipdIntakeOutputChart) {
		if (null == getIpdIntakeOutputCharts()) setIpdIntakeOutputCharts(new java.util.TreeSet<jkt.hms.masters.business.IpdIntakeOutputChart>());
		getIpdIntakeOutputCharts().add(ipdIntakeOutputChart);
	}



	/**
	 * Return the value associated with the column: StoreSetupsByStoreExpendable
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSetup> getStoreSetupsByStoreExpendable () {
		return storeSetupsByStoreExpendable;
	}

	/**
	 * Set the value related to the column: StoreSetupsByStoreExpendable
	 * @param storeSetupsByStoreExpendable the StoreSetupsByStoreExpendable value
	 */
	public void setStoreSetupsByStoreExpendable (java.util.Set<jkt.hms.masters.business.StoreSetup> storeSetupsByStoreExpendable) {
		this.storeSetupsByStoreExpendable = storeSetupsByStoreExpendable;
	}

	public void addToStoreSetupsByStoreExpendable (jkt.hms.masters.business.StoreSetup storeSetup) {
		if (null == getStoreSetupsByStoreExpendable()) setStoreSetupsByStoreExpendable(new java.util.TreeSet<jkt.hms.masters.business.StoreSetup>());
		getStoreSetupsByStoreExpendable().add(storeSetup);
	}



	/**
	 * Return the value associated with the column: StoreSetupsByStoreDispensary
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSetup> getStoreSetupsByStoreDispensary () {
		return storeSetupsByStoreDispensary;
	}

	/**
	 * Set the value related to the column: StoreSetupsByStoreDispensary
	 * @param storeSetupsByStoreDispensary the StoreSetupsByStoreDispensary value
	 */
	public void setStoreSetupsByStoreDispensary (java.util.Set<jkt.hms.masters.business.StoreSetup> storeSetupsByStoreDispensary) {
		this.storeSetupsByStoreDispensary = storeSetupsByStoreDispensary;
	}

	public void addToStoreSetupsByStoreDispensary (jkt.hms.masters.business.StoreSetup storeSetup) {
		if (null == getStoreSetupsByStoreDispensary()) setStoreSetupsByStoreDispensary(new java.util.TreeSet<jkt.hms.masters.business.StoreSetup>());
		getStoreSetupsByStoreDispensary().add(storeSetup);
	}



	/**
	 * Return the value associated with the column: StoreSetupsByStoreEchs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSetup> getStoreSetupsByStoreEchs () {
		return storeSetupsByStoreEchs;
	}

	/**
	 * Set the value related to the column: StoreSetupsByStoreEchs
	 * @param storeSetupsByStoreEchs the StoreSetupsByStoreEchs value
	 */
	public void setStoreSetupsByStoreEchs (java.util.Set<jkt.hms.masters.business.StoreSetup> storeSetupsByStoreEchs) {
		this.storeSetupsByStoreEchs = storeSetupsByStoreEchs;
	}

	public void addToStoreSetupsByStoreEchs (jkt.hms.masters.business.StoreSetup storeSetup) {
		if (null == getStoreSetupsByStoreEchs()) setStoreSetupsByStoreEchs(new java.util.TreeSet<jkt.hms.masters.business.StoreSetup>());
		getStoreSetupsByStoreEchs().add(storeSetup);
	}



	/**
	 * Return the value associated with the column: IpdClinicalCharts
	 */
	public java.util.Set<jkt.hms.masters.business.IpdClinicalChart> getIpdClinicalCharts () {
		return ipdClinicalCharts;
	}

	/**
	 * Set the value related to the column: IpdClinicalCharts
	 * @param ipdClinicalCharts the IpdClinicalCharts value
	 */
	public void setIpdClinicalCharts (java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts) {
		this.ipdClinicalCharts = ipdClinicalCharts;
	}

	public void addToIpdClinicalCharts (jkt.hms.masters.business.IpdClinicalChart ipdClinicalChart) {
		if (null == getIpdClinicalCharts()) setIpdClinicalCharts(new java.util.TreeSet<jkt.hms.masters.business.IpdClinicalChart>());
		getIpdClinicalCharts().add(ipdClinicalChart);
	}



	/**
	 * Return the value associated with the column: StoreGrnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnM> getStoreGrnMs () {
		return storeGrnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnMs
	 * @param storeGrnMs the StoreGrnMs value
	 */
	public void setStoreGrnMs (java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs) {
		this.storeGrnMs = storeGrnMs;
	}

	public void addToStoreGrnMs (jkt.hms.masters.business.StoreGrnM storeGrnM) {
		if (null == getStoreGrnMs()) setStoreGrnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnM>());
		getStoreGrnMs().add(storeGrnM);
	}



	/**
	 * Return the value associated with the column: OpdEnts
	 */
	public java.util.Set<jkt.hms.masters.business.OpdEnt> getOpdEnts () {
		return opdEnts;
	}

	/**
	 * Set the value related to the column: OpdEnts
	 * @param opdEnts the OpdEnts value
	 */
	public void setOpdEnts (java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts) {
		this.opdEnts = opdEnts;
	}

	public void addToOpdEnts (jkt.hms.masters.business.OpdEnt opdEnt) {
		if (null == getOpdEnts()) setOpdEnts(new java.util.TreeSet<jkt.hms.masters.business.OpdEnt>());
		getOpdEnts().add(opdEnt);
	}



	/**
	 * Return the value associated with the column: OpdSurgeryHeadersByPrescribedDepartment
	 */
	public java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> getOpdSurgeryHeadersByPrescribedDepartment () {
		return opdSurgeryHeadersByPrescribedDepartment;
	}

	/**
	 * Set the value related to the column: OpdSurgeryHeadersByPrescribedDepartment
	 * @param opdSurgeryHeadersByPrescribedDepartment the OpdSurgeryHeadersByPrescribedDepartment value
	 */
	public void setOpdSurgeryHeadersByPrescribedDepartment (java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeadersByPrescribedDepartment) {
		this.opdSurgeryHeadersByPrescribedDepartment = opdSurgeryHeadersByPrescribedDepartment;
	}

	public void addToOpdSurgeryHeadersByPrescribedDepartment (jkt.hms.masters.business.OpdSurgeryHeader opdSurgeryHeader) {
		if (null == getOpdSurgeryHeadersByPrescribedDepartment()) setOpdSurgeryHeadersByPrescribedDepartment(new java.util.TreeSet<jkt.hms.masters.business.OpdSurgeryHeader>());
		getOpdSurgeryHeadersByPrescribedDepartment().add(opdSurgeryHeader);
	}



	/**
	 * Return the value associated with the column: OpdSurgeryHeadersBySurgicalDept
	 */
	public java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> getOpdSurgeryHeadersBySurgicalDept () {
		return opdSurgeryHeadersBySurgicalDept;
	}

	/**
	 * Set the value related to the column: OpdSurgeryHeadersBySurgicalDept
	 * @param opdSurgeryHeadersBySurgicalDept the OpdSurgeryHeadersBySurgicalDept value
	 */
	public void setOpdSurgeryHeadersBySurgicalDept (java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeadersBySurgicalDept) {
		this.opdSurgeryHeadersBySurgicalDept = opdSurgeryHeadersBySurgicalDept;
	}

	public void addToOpdSurgeryHeadersBySurgicalDept (jkt.hms.masters.business.OpdSurgeryHeader opdSurgeryHeader) {
		if (null == getOpdSurgeryHeadersBySurgicalDept()) setOpdSurgeryHeadersBySurgicalDept(new java.util.TreeSet<jkt.hms.masters.business.OpdSurgeryHeader>());
		getOpdSurgeryHeadersBySurgicalDept().add(opdSurgeryHeader);
	}



	/**
	 * Return the value associated with the column: OpdGastroEnterologyEndoscopies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> getOpdGastroEnterologyEndoscopies () {
		return opdGastroEnterologyEndoscopies;
	}

	/**
	 * Set the value related to the column: OpdGastroEnterologyEndoscopies
	 * @param opdGastroEnterologyEndoscopies the OpdGastroEnterologyEndoscopies value
	 */
	public void setOpdGastroEnterologyEndoscopies (java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopies) {
		this.opdGastroEnterologyEndoscopies = opdGastroEnterologyEndoscopies;
	}

	public void addToOpdGastroEnterologyEndoscopies (jkt.hms.masters.business.OpdGastroEnterologyEndoscopy opdGastroEnterologyEndoscopy) {
		if (null == getOpdGastroEnterologyEndoscopies()) setOpdGastroEnterologyEndoscopies(new java.util.TreeSet<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy>());
		getOpdGastroEnterologyEndoscopies().add(opdGastroEnterologyEndoscopy);
	}



	/**
	 * Return the value associated with the column: OpdGravidagramGestationalDiabitiesOnes
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> getOpdGravidagramGestationalDiabitiesOnes () {
		return opdGravidagramGestationalDiabitiesOnes;
	}

	/**
	 * Set the value related to the column: OpdGravidagramGestationalDiabitiesOnes
	 * @param opdGravidagramGestationalDiabitiesOnes the OpdGravidagramGestationalDiabitiesOnes value
	 */
	public void setOpdGravidagramGestationalDiabitiesOnes (java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes) {
		this.opdGravidagramGestationalDiabitiesOnes = opdGravidagramGestationalDiabitiesOnes;
	}

	public void addToOpdGravidagramGestationalDiabitiesOnes (jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne opdGravidagramGestationalDiabitiesOne) {
		if (null == getOpdGravidagramGestationalDiabitiesOnes()) setOpdGravidagramGestationalDiabitiesOnes(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne>());
		getOpdGravidagramGestationalDiabitiesOnes().add(opdGravidagramGestationalDiabitiesOne);
	}



	/**
	 * Return the value associated with the column: MasStoreItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItem> getMasStoreItems () {
		return masStoreItems;
	}

	/**
	 * Set the value related to the column: MasStoreItems
	 * @param masStoreItems the MasStoreItems value
	 */
	public void setMasStoreItems (java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems) {
		this.masStoreItems = masStoreItems;
	}

	public void addToMasStoreItems (jkt.hms.masters.business.MasStoreItem masStoreItem) {
		if (null == getMasStoreItems()) setMasStoreItems(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItem>());
		getMasStoreItems().add(masStoreItem);
	}



	/**
	 * Return the value associated with the column: OpdAntenatalCards
	 */
	public java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> getOpdAntenatalCards () {
		return opdAntenatalCards;
	}

	/**
	 * Set the value related to the column: OpdAntenatalCards
	 * @param opdAntenatalCards the OpdAntenatalCards value
	 */
	public void setOpdAntenatalCards (java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards) {
		this.opdAntenatalCards = opdAntenatalCards;
	}

	public void addToOpdAntenatalCards (jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard) {
		if (null == getOpdAntenatalCards()) setOpdAntenatalCards(new java.util.TreeSet<jkt.hms.masters.business.OpdAntenatalCard>());
		getOpdAntenatalCards().add(opdAntenatalCard);
	}



	/**
	 * Return the value associated with the column: Ipdclinicals
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdclinical> getIpdclinicals () {
		return ipdclinicals;
	}

	/**
	 * Set the value related to the column: Ipdclinicals
	 * @param ipdclinicals the Ipdclinicals value
	 */
	public void setIpdclinicals (java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals) {
		this.ipdclinicals = ipdclinicals;
	}

	public void addToIpdclinicals (jkt.hms.masters.business.Ipdclinical ipdclinical) {
		if (null == getIpdclinicals()) setIpdclinicals(new java.util.TreeSet<jkt.hms.masters.business.Ipdclinical>());
		getIpdclinicals().add(ipdclinical);
	}



	/**
	 * Return the value associated with the column: StoreInternalIndentMsByDepartment
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> getStoreInternalIndentMsByDepartment () {
		return storeInternalIndentMsByDepartment;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentMsByDepartment
	 * @param storeInternalIndentMsByDepartment the StoreInternalIndentMsByDepartment value
	 */
	public void setStoreInternalIndentMsByDepartment (java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMsByDepartment) {
		this.storeInternalIndentMsByDepartment = storeInternalIndentMsByDepartment;
	}

	public void addToStoreInternalIndentMsByDepartment (jkt.hms.masters.business.StoreInternalIndentM storeInternalIndentM) {
		if (null == getStoreInternalIndentMsByDepartment()) setStoreInternalIndentMsByDepartment(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentM>());
		getStoreInternalIndentMsByDepartment().add(storeInternalIndentM);
	}



	/**
	 * Return the value associated with the column: StoreInternalIndentMsByToStore
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> getStoreInternalIndentMsByToStore () {
		return storeInternalIndentMsByToStore;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentMsByToStore
	 * @param storeInternalIndentMsByToStore the StoreInternalIndentMsByToStore value
	 */
	public void setStoreInternalIndentMsByToStore (java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMsByToStore) {
		this.storeInternalIndentMsByToStore = storeInternalIndentMsByToStore;
	}

	public void addToStoreInternalIndentMsByToStore (jkt.hms.masters.business.StoreInternalIndentM storeInternalIndentM) {
		if (null == getStoreInternalIndentMsByToStore()) setStoreInternalIndentMsByToStore(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentM>());
		getStoreInternalIndentMsByToStore().add(storeInternalIndentM);
	}



	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set<jkt.hms.masters.business.AttachInpatient> getAttachInpatients () {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * @param attachInpatients the AttachInpatients value
	 */
	public void setAttachInpatients (java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients (jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients()) setAttachInpatients(new java.util.TreeSet<jkt.hms.masters.business.AttachInpatient>());
		getAttachInpatients().add(attachInpatient);
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
	 * Return the value associated with the column: PatientAllergicDrugsHds
	 */
	public java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> getPatientAllergicDrugsHds () {
		return patientAllergicDrugsHds;
	}

	/**
	 * Set the value related to the column: PatientAllergicDrugsHds
	 * @param patientAllergicDrugsHds the PatientAllergicDrugsHds value
	 */
	public void setPatientAllergicDrugsHds (java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds) {
		this.patientAllergicDrugsHds = patientAllergicDrugsHds;
	}

	public void addToPatientAllergicDrugsHds (jkt.hms.masters.business.PatientAllergicDrugsHd patientAllergicDrugsHd) {
		if (null == getPatientAllergicDrugsHds()) setPatientAllergicDrugsHds(new java.util.TreeSet<jkt.hms.masters.business.PatientAllergicDrugsHd>());
		getPatientAllergicDrugsHds().add(patientAllergicDrugsHd);
	}



	/**
	 * Return the value associated with the column: StoreTenderTechnicalBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> getStoreTenderTechnicalBidMs () {
		return storeTenderTechnicalBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderTechnicalBidMs
	 * @param storeTenderTechnicalBidMs the StoreTenderTechnicalBidMs value
	 */
	public void setStoreTenderTechnicalBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> storeTenderTechnicalBidMs) {
		this.storeTenderTechnicalBidMs = storeTenderTechnicalBidMs;
	}

	public void addToStoreTenderTechnicalBidMs (jkt.hms.masters.business.StoreTenderTechnicalBidM storeTenderTechnicalBidM) {
		if (null == getStoreTenderTechnicalBidMs()) setStoreTenderTechnicalBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderTechnicalBidM>());
		getStoreTenderTechnicalBidMs().add(storeTenderTechnicalBidM);
	}



	/**
	 * Return the value associated with the column: Visits
	 */
	public java.util.Set<jkt.hms.masters.business.Visit> getVisits () {
		return visits;
	}

	/**
	 * Set the value related to the column: Visits
	 * @param visits the Visits value
	 */
	public void setVisits (java.util.Set<jkt.hms.masters.business.Visit> visits) {
		this.visits = visits;
	}

	public void addToVisits (jkt.hms.masters.business.Visit visit) {
		if (null == getVisits()) setVisits(new java.util.TreeSet<jkt.hms.masters.business.Visit>());
		getVisits().add(visit);
	}



	/**
	 * Return the value associated with the column: OpdGravidagramHtns
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> getOpdGravidagramHtns () {
		return opdGravidagramHtns;
	}

	/**
	 * Set the value related to the column: OpdGravidagramHtns
	 * @param opdGravidagramHtns the OpdGravidagramHtns value
	 */
	public void setOpdGravidagramHtns (java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns) {
		this.opdGravidagramHtns = opdGravidagramHtns;
	}

	public void addToOpdGravidagramHtns (jkt.hms.masters.business.OpdGravidagramHtn opdGravidagramHtn) {
		if (null == getOpdGravidagramHtns()) setOpdGravidagramHtns(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramHtn>());
		getOpdGravidagramHtns().add(opdGravidagramHtn);
	}



	/**
	 * Return the value associated with the column: StoreQuotationReceiptMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptM> getStoreQuotationReceiptMs () {
		return storeQuotationReceiptMs;
	}

	/**
	 * Set the value related to the column: StoreQuotationReceiptMs
	 * @param storeQuotationReceiptMs the StoreQuotationReceiptMs value
	 */
	public void setStoreQuotationReceiptMs (java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptM> storeQuotationReceiptMs) {
		this.storeQuotationReceiptMs = storeQuotationReceiptMs;
	}

	public void addToStoreQuotationReceiptMs (jkt.hms.masters.business.StoreQuotationReceiptM storeQuotationReceiptM) {
		if (null == getStoreQuotationReceiptMs()) setStoreQuotationReceiptMs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationReceiptM>());
		getStoreQuotationReceiptMs().add(storeQuotationReceiptM);
	}



	/**
	 * Return the value associated with the column: StoreLoaninMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninM> getStoreLoaninMs () {
		return storeLoaninMs;
	}

	/**
	 * Set the value related to the column: StoreLoaninMs
	 * @param storeLoaninMs the StoreLoaninMs value
	 */
	public void setStoreLoaninMs (java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs) {
		this.storeLoaninMs = storeLoaninMs;
	}

	public void addToStoreLoaninMs (jkt.hms.masters.business.StoreLoaninM storeLoaninM) {
		if (null == getStoreLoaninMs()) setStoreLoaninMs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninM>());
		getStoreLoaninMs().add(storeLoaninM);
	}



	/**
	 * Return the value associated with the column: StoreDisposalMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDisposalM> getStoreDisposalMs () {
		return storeDisposalMs;
	}

	/**
	 * Set the value related to the column: StoreDisposalMs
	 * @param storeDisposalMs the StoreDisposalMs value
	 */
	public void setStoreDisposalMs (java.util.Set<jkt.hms.masters.business.StoreDisposalM> storeDisposalMs) {
		this.storeDisposalMs = storeDisposalMs;
	}

	public void addToStoreDisposalMs (jkt.hms.masters.business.StoreDisposalM storeDisposalM) {
		if (null == getStoreDisposalMs()) setStoreDisposalMs(new java.util.TreeSet<jkt.hms.masters.business.StoreDisposalM>());
		getStoreDisposalMs().add(storeDisposalM);
	}



	/**
	 * Return the value associated with the column: StoreTenderMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderM> getStoreTenderMs () {
		return storeTenderMs;
	}

	/**
	 * Set the value related to the column: StoreTenderMs
	 * @param storeTenderMs the StoreTenderMs value
	 */
	public void setStoreTenderMs (java.util.Set<jkt.hms.masters.business.StoreTenderM> storeTenderMs) {
		this.storeTenderMs = storeTenderMs;
	}

	public void addToStoreTenderMs (jkt.hms.masters.business.StoreTenderM storeTenderM) {
		if (null == getStoreTenderMs()) setStoreTenderMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderM>());
		getStoreTenderMs().add(storeTenderM);
	}



	/**
	 * Return the value associated with the column: PatientPrescriptionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> getPatientPrescriptionHeaders () {
		return patientPrescriptionHeaders;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionHeaders
	 * @param patientPrescriptionHeaders the PatientPrescriptionHeaders value
	 */
	public void setPatientPrescriptionHeaders (java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders) {
		this.patientPrescriptionHeaders = patientPrescriptionHeaders;
	}

	public void addToPatientPrescriptionHeaders (jkt.hms.masters.business.PatientPrescriptionHeader patientPrescriptionHeader) {
		if (null == getPatientPrescriptionHeaders()) setPatientPrescriptionHeaders(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionHeader>());
		getPatientPrescriptionHeaders().add(patientPrescriptionHeader);
	}



	/**
	 * Return the value associated with the column: DgResultEntryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> getDgResultEntryHeaders () {
		return dgResultEntryHeaders;
	}

	/**
	 * Set the value related to the column: DgResultEntryHeaders
	 * @param dgResultEntryHeaders the DgResultEntryHeaders value
	 */
	public void setDgResultEntryHeaders (java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders) {
		this.dgResultEntryHeaders = dgResultEntryHeaders;
	}

	public void addToDgResultEntryHeaders (jkt.hms.masters.business.DgResultEntryHeader dgResultEntryHeader) {
		if (null == getDgResultEntryHeaders()) setDgResultEntryHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryHeader>());
		getDgResultEntryHeaders().add(dgResultEntryHeader);
	}



	/**
	 * Return the value associated with the column: WardRemarks
	 */
	public java.util.Set<jkt.hms.masters.business.WardRemarks> getWardRemarks () {
		return wardRemarks;
	}

	/**
	 * Set the value related to the column: WardRemarks
	 * @param wardRemarks the WardRemarks value
	 */
	public void setWardRemarks (java.util.Set<jkt.hms.masters.business.WardRemarks> wardRemarks) {
		this.wardRemarks = wardRemarks;
	}

	public void addToWardRemarks (jkt.hms.masters.business.WardRemarks wardRemarks) {
		if (null == getWardRemarks()) setWardRemarks(new java.util.TreeSet<jkt.hms.masters.business.WardRemarks>());
		getWardRemarks().add(wardRemarks);
	}



	/**
	 * Return the value associated with the column: TransfersByToWard
	 */
	public java.util.Set<jkt.hms.masters.business.Transfer> getTransfersByToWard () {
		return transfersByToWard;
	}

	/**
	 * Set the value related to the column: TransfersByToWard
	 * @param transfersByToWard the TransfersByToWard value
	 */
	public void setTransfersByToWard (java.util.Set<jkt.hms.masters.business.Transfer> transfersByToWard) {
		this.transfersByToWard = transfersByToWard;
	}

	public void addToTransfersByToWard (jkt.hms.masters.business.Transfer transfer) {
		if (null == getTransfersByToWard()) setTransfersByToWard(new java.util.TreeSet<jkt.hms.masters.business.Transfer>());
		getTransfersByToWard().add(transfer);
	}



	/**
	 * Return the value associated with the column: TransfersByFromWard
	 */
	public java.util.Set<jkt.hms.masters.business.Transfer> getTransfersByFromWard () {
		return transfersByFromWard;
	}

	/**
	 * Set the value related to the column: TransfersByFromWard
	 * @param transfersByFromWard the TransfersByFromWard value
	 */
	public void setTransfersByFromWard (java.util.Set<jkt.hms.masters.business.Transfer> transfersByFromWard) {
		this.transfersByFromWard = transfersByFromWard;
	}

	public void addToTransfersByFromWard (jkt.hms.masters.business.Transfer transfer) {
		if (null == getTransfersByFromWard()) setTransfersByFromWard(new java.util.TreeSet<jkt.hms.masters.business.Transfer>());
		getTransfersByFromWard().add(transfer);
	}



	/**
	 * Return the value associated with the column: SilDilStatus
	 */
	public java.util.Set<jkt.hms.masters.business.SilDilStatus> getSilDilStatus () {
		return silDilStatus;
	}

	/**
	 * Set the value related to the column: SilDilStatus
	 * @param silDilStatus the SilDilStatus value
	 */
	public void setSilDilStatus (java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus) {
		this.silDilStatus = silDilStatus;
	}

	public void addToSilDilStatus (jkt.hms.masters.business.SilDilStatus silDilStatus) {
		if (null == getSilDilStatus()) setSilDilStatus(new java.util.TreeSet<jkt.hms.masters.business.SilDilStatus>());
		getSilDilStatus().add(silDilStatus);
	}



	/**
	 * Return the value associated with the column: DgSampleCollectionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> getDgSampleCollectionHeaders () {
		return dgSampleCollectionHeaders;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionHeaders
	 * @param dgSampleCollectionHeaders the DgSampleCollectionHeaders value
	 */
	public void setDgSampleCollectionHeaders (java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders) {
		this.dgSampleCollectionHeaders = dgSampleCollectionHeaders;
	}

	public void addToDgSampleCollectionHeaders (jkt.hms.masters.business.DgSampleCollectionHeader dgSampleCollectionHeader) {
		if (null == getDgSampleCollectionHeaders()) setDgSampleCollectionHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionHeader>());
		getDgSampleCollectionHeaders().add(dgSampleCollectionHeader);
	}



	/**
	 * Return the value associated with the column: MasOtDistributions
	 */
	public java.util.Set<jkt.hms.masters.business.MasOtDistribution> getMasOtDistributions () {
		return masOtDistributions;
	}

	/**
	 * Set the value related to the column: MasOtDistributions
	 * @param masOtDistributions the MasOtDistributions value
	 */
	public void setMasOtDistributions (java.util.Set<jkt.hms.masters.business.MasOtDistribution> masOtDistributions) {
		this.masOtDistributions = masOtDistributions;
	}

	public void addToMasOtDistributions (jkt.hms.masters.business.MasOtDistribution masOtDistribution) {
		if (null == getMasOtDistributions()) setMasOtDistributions(new java.util.TreeSet<jkt.hms.masters.business.MasOtDistribution>());
		getMasOtDistributions().add(masOtDistribution);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}



	/**
	 * Return the value associated with the column: MasBeds
	 */
	public java.util.Set<jkt.hms.masters.business.MasBed> getMasBeds () {
		return masBeds;
	}

	/**
	 * Set the value related to the column: MasBeds
	 * @param masBeds the MasBeds value
	 */
	public void setMasBeds (java.util.Set<jkt.hms.masters.business.MasBed> masBeds) {
		this.masBeds = masBeds;
	}

	public void addToMasBeds (jkt.hms.masters.business.MasBed masBed) {
		if (null == getMasBeds()) setMasBeds(new java.util.TreeSet<jkt.hms.masters.business.MasBed>());
		getMasBeds().add(masBed);
	}



	/**
	 * Return the value associated with the column: AppSetups
	 */
	public java.util.Set<jkt.hms.masters.business.AppSetup> getAppSetups () {
		return appSetups;
	}

	/**
	 * Set the value related to the column: AppSetups
	 * @param appSetups the AppSetups value
	 */
	public void setAppSetups (java.util.Set<jkt.hms.masters.business.AppSetup> appSetups) {
		this.appSetups = appSetups;
	}

	public void addToAppSetups (jkt.hms.masters.business.AppSetup appSetup) {
		if (null == getAppSetups()) setAppSetups(new java.util.TreeSet<jkt.hms.masters.business.AppSetup>());
		getAppSetups().add(appSetup);
	}



	/**
	 * Return the value associated with the column: OpdGravidagramGestationalDiabitiesTwos
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> getOpdGravidagramGestationalDiabitiesTwos () {
		return opdGravidagramGestationalDiabitiesTwos;
	}

	/**
	 * Set the value related to the column: OpdGravidagramGestationalDiabitiesTwos
	 * @param opdGravidagramGestationalDiabitiesTwos the OpdGravidagramGestationalDiabitiesTwos value
	 */
	public void setOpdGravidagramGestationalDiabitiesTwos (java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> opdGravidagramGestationalDiabitiesTwos) {
		this.opdGravidagramGestationalDiabitiesTwos = opdGravidagramGestationalDiabitiesTwos;
	}

	public void addToOpdGravidagramGestationalDiabitiesTwos (jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo opdGravidagramGestationalDiabitiesTwo) {
		if (null == getOpdGravidagramGestationalDiabitiesTwos()) setOpdGravidagramGestationalDiabitiesTwos(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo>());
		getOpdGravidagramGestationalDiabitiesTwos().add(opdGravidagramGestationalDiabitiesTwo);
	}



	/**
	 * Return the value associated with the column: DeptTaskMaps
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrDeptTaskMap> getDeptTaskMaps () {
		return deptTaskMaps;
	}

	/**
	 * Set the value related to the column: DeptTaskMaps
	 * @param deptTaskMaps the DeptTaskMaps value
	 */
	public void setDeptTaskMaps (java.util.Set<jkt.hrms.masters.business.MstrDeptTaskMap> deptTaskMaps) {
		this.deptTaskMaps = deptTaskMaps;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDepartment)) return false;
		else {
			jkt.hms.masters.business.MasDepartment masDepartment = (jkt.hms.masters.business.MasDepartment) obj;
			if (null == this.getId() || null == masDepartment.getId()) return false;
			else return (this.getId().equals(masDepartment.getId()));
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