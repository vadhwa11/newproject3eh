package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_internal_indent_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_internal_indent_m"
 */

public abstract class BaseStoreInternalIndentM  implements Serializable {

	public static String REF = "StoreInternalIndentM";
	public static String PROP_SMO_REMARKS = "Smo_Remarks";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_DEMAND_DATE = "DemandDate";
	public static String PROP_DME_REMARKS = "Dme_Remarks";
	public static String PROP_KMCL_REMARKS = "Kmcl_Remarks";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RESPONSIBLE_PERSON = "ResponsiblePerson";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_REFERENCE_DEMAND_NO = "ReferenceDemandNo";
	public static String PROP_TO_STORE = "ToStore";
	public static String PROP_PE_NO = "PeNo";
	public static String PROP_STORE_DEPARTMENT = "StoreDepartment";
	public static String PROP_REQUESTED_BY = "RequestedBy";
	public static String PROP_DMO_REMARKS = "Dmo_Remarks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEMAND_NO = "DemandNo";
	public static String PROP_KMSCL_PROCESS_DATE = "KmsclProcessDate";
	public static String PROP_INDENT_TYPE = "IndentType";
	public static String PROP_STATUS = "Status";
	public static String PROP_STATE = "State";
	public static String PROP_DISTRICT = "District";
	public static String PROP_ID = "Id";
	public static String PROP_INDENT_FLAG = "IndentFlag";
	public static String PROP_INSTITUTE = "Institute";


	// constructors
	public BaseStoreInternalIndentM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreInternalIndentM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String demandNo;
	private java.util.Date demandDate;
	private java.util.Date lastChgDate;
	private java.lang.String status;
	private java.lang.String indentFlag;
	private java.lang.String indentType;
	private java.lang.String remarks;
	private java.lang.String smo_Remarks;
	private java.lang.String dmo_Remarks;
	private java.lang.String dme_Remarks;
	private java.lang.String kmcl_Remarks;
	private java.util.Date kmsclProcessDate;
	private java.lang.String referenceDemandNo;
	private java.lang.String peNo;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee requestedBy;
	private jkt.hms.masters.business.MasDepartment toStore;
	private jkt.hms.masters.business.MasDepartment storeDepartment;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasHospital institute;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasEmployee responsiblePerson;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByToDepot;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByRequestNo;



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
	 * Return the value associated with the column: demand_no
	 */
	public java.lang.String getDemandNo () {
		return demandNo;
	}

	/**
	 * Set the value related to the column: demand_no
	 * @param demandNo the demand_no value
	 */
	public void setDemandNo (java.lang.String demandNo) {
		this.demandNo = demandNo;
	}



	/**
	 * Return the value associated with the column: demand_date
	 */
	public java.util.Date getDemandDate () {
		return demandDate;
	}

	/**
	 * Set the value related to the column: demand_date
	 * @param demandDate the demand_date value
	 */
	public void setDemandDate (java.util.Date demandDate) {
		this.demandDate = demandDate;
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
	 * Return the value associated with the column: indent_flag
	 */
	public java.lang.String getIndentFlag () {
		return indentFlag;
	}

	/**
	 * Set the value related to the column: indent_flag
	 * @param indentFlag the indent_flag value
	 */
	public void setIndentFlag (java.lang.String indentFlag) {
		this.indentFlag = indentFlag;
	}



	/**
	 * Return the value associated with the column: indent_type
	 */
	public java.lang.String getIndentType () {
		return indentType;
	}

	/**
	 * Set the value related to the column: indent_type
	 * @param indentType the indent_type value
	 */
	public void setIndentType (java.lang.String indentType) {
		this.indentType = indentType;
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
	 * Return the value associated with the column: smo_remarks
	 */
	public java.lang.String getSmo_Remarks () {
		return smo_Remarks;
	}

	/**
	 * Set the value related to the column: smo_remarks
	 * @param smo_Remarks the smo_remarks value
	 */
	public void setSmo_Remarks (java.lang.String smo_Remarks) {
		this.smo_Remarks = smo_Remarks;
	}



	/**
	 * Return the value associated with the column: dmo_remarks
	 */
	public java.lang.String getDmo_Remarks () {
		return dmo_Remarks;
	}

	/**
	 * Set the value related to the column: dmo_remarks
	 * @param dmo_Remarks the dmo_remarks value
	 */
	public void setDmo_Remarks (java.lang.String dmo_Remarks) {
		this.dmo_Remarks = dmo_Remarks;
	}



	/**
	 * Return the value associated with the column: dme_remarks
	 */
	public java.lang.String getDme_Remarks () {
		return dme_Remarks;
	}

	/**
	 * Set the value related to the column: dme_remarks
	 * @param dme_Remarks the dme_remarks value
	 */
	public void setDme_Remarks (java.lang.String dme_Remarks) {
		this.dme_Remarks = dme_Remarks;
	}



	/**
	 * Return the value associated with the column: kmcl_remarks
	 */
	public java.lang.String getKmcl_Remarks () {
		return kmcl_Remarks;
	}

	/**
	 * Set the value related to the column: kmcl_remarks
	 * @param kmcl_Remarks the kmcl_remarks value
	 */
	public void setKmcl_Remarks (java.lang.String kmcl_Remarks) {
		this.kmcl_Remarks = kmcl_Remarks;
	}



	/**
	 * Return the value associated with the column: kmscl_process_date
	 */
	public java.util.Date getKmsclProcessDate () {
		return kmsclProcessDate;
	}

	/**
	 * Set the value related to the column: kmscl_process_date
	 * @param kmsclProcessDate the kmscl_process_date value
	 */
	public void setKmsclProcessDate (java.util.Date kmsclProcessDate) {
		this.kmsclProcessDate = kmsclProcessDate;
	}



	/**
	 * Return the value associated with the column: reference_demand_no
	 */
	public java.lang.String getReferenceDemandNo () {
		return referenceDemandNo;
	}

	/**
	 * Set the value related to the column: reference_demand_no
	 * @param referenceDemandNo the reference_demand_no value
	 */
	public void setReferenceDemandNo (java.lang.String referenceDemandNo) {
		this.referenceDemandNo = referenceDemandNo;
	}



	/**
	 * Return the value associated with the column: pe_no
	 */
	public java.lang.String getPeNo () {
		return peNo;
	}

	/**
	 * Set the value related to the column: pe_no
	 * @param peNo the pe_no value
	 */
	public void setPeNo (java.lang.String peNo) {
		this.peNo = peNo;
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
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



	/**
	 * Return the value associated with the column: requested_by
	 */
	public jkt.hms.masters.business.MasEmployee getRequestedBy () {
		return requestedBy;
	}

	/**
	 * Set the value related to the column: requested_by
	 * @param requestedBy the requested_by value
	 */
	public void setRequestedBy (jkt.hms.masters.business.MasEmployee requestedBy) {
		this.requestedBy = requestedBy;
	}



	/**
	 * Return the value associated with the column: to_store
	 */
	public jkt.hms.masters.business.MasDepartment getToStore () {
		return toStore;
	}

	/**
	 * Set the value related to the column: to_store
	 * @param toStore the to_store value
	 */
	public void setToStore (jkt.hms.masters.business.MasDepartment toStore) {
		this.toStore = toStore;
	}



	/**
	 * Return the value associated with the column: store_department
	 */
	public jkt.hms.masters.business.MasDepartment getStoreDepartment () {
		return storeDepartment;
	}

	/**
	 * Set the value related to the column: store_department
	 * @param storeDepartment the store_department value
	 */
	public void setStoreDepartment (jkt.hms.masters.business.MasDepartment storeDepartment) {
		this.storeDepartment = storeDepartment;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}



	/**
	 * Return the value associated with the column: institute_id
	 */
	public jkt.hms.masters.business.MasHospital getInstitute () {
		return institute;
	}

	/**
	 * Set the value related to the column: institute_id
	 * @param institute the institute_id value
	 */
	public void setInstitute (jkt.hms.masters.business.MasHospital institute) {
		this.institute = institute;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param state the state_id value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: responsible_person
	 */
	public jkt.hms.masters.business.MasEmployee getResponsiblePerson () {
		return responsiblePerson;
	}

	/**
	 * Set the value related to the column: responsible_person
	 * @param responsiblePerson the responsible_person value
	 */
	public void setResponsiblePerson (jkt.hms.masters.business.MasEmployee responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
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
	 * Return the value associated with the column: StoreIssueMsByToDepot
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByToDepot () {
		return storeIssueMsByToDepot;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByToDepot
	 * @param storeIssueMsByToDepot the StoreIssueMsByToDepot value
	 */
	public void setStoreIssueMsByToDepot (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByToDepot) {
		this.storeIssueMsByToDepot = storeIssueMsByToDepot;
	}

	public void addToStoreIssueMsByToDepot (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByToDepot()) setStoreIssueMsByToDepot(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByToDepot().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByRequestNo
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByRequestNo () {
		return storeIssueMsByRequestNo;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByRequestNo
	 * @param storeIssueMsByRequestNo the StoreIssueMsByRequestNo value
	 */
	public void setStoreIssueMsByRequestNo (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByRequestNo) {
		this.storeIssueMsByRequestNo = storeIssueMsByRequestNo;
	}

	public void addToStoreIssueMsByRequestNo (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByRequestNo()) setStoreIssueMsByRequestNo(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByRequestNo().add(storeIssueM);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreInternalIndentM)) return false;
		else {
			jkt.hms.masters.business.StoreInternalIndentM storeInternalIndentM = (jkt.hms.masters.business.StoreInternalIndentM) obj;
			if (null == this.getId() || null == storeInternalIndentM.getId()) return false;
			else return (this.getId().equals(storeInternalIndentM.getId()));
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