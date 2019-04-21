package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_ph_reports_parameters table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_ph_reports_parameters"
 */

public abstract class BaseMasPhReportsParameters  implements Serializable {

	public static String REF = "MasPhReportsParameters";
	public static String PROP_INTERNAL_REPORT_QUARTERLY_DISTRICT_PARAMETER = "InternalReportQuarterlyDistrictParameter";
	public static String PROP_INTERNAL_REPORT_ANNUALLY_DISTRICT_ID = "InternalReportAnnuallyDistrictId";
	public static String PROP_NVBDCP_REPORT_ID = "NvbdcpReportId";
	public static String PROP_GOI_ANNUALLY_ID = "GoiAnnuallyId";
	public static String PROP_INTERNAL_REPORT_MONTHLY_DISTRICT_HOSPITAL_PARAMETER = "InternalReportMonthlyDistrictHospitalParameter";
	public static String PROP_NVBDCP_REPORT_PARAMETER = "NvbdcpReportParameter";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_DISTRICT2_ID = "InfrastructurelReportMonthlyDistrict2Id";
	public static String PROP_INTERNAL_REPORT_MONTHLY_SC_PARAMETER = "InternalReportMonthlyScParameter";
	public static String PROP_GOI_MONTHLY_PARAMETER = "GoiMonthlyParameter";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_DISTRICT1_ID = "InfrastructurelReportMonthlyDistrict1Id";
	public static String PROP_INTERNAL_REPORT_MONTHLY_DISTRICT_PARAMETER = "InternalReportMonthlyDistrictParameter";
	public static String PROP_INTERNAL_REPORT_MONTHLY_CHC_ID = "InternalReportMonthlyChcId";
	public static String PROP_INTERNAL_REPORT_MONTHLY_SUB_DISTRICT_PARAMETER = "InternalReportMonthlySubDistrictParameter";
	public static String PROP_HMIS_PARAMETER = "HmisParameter";
	public static String PROP_INTERNAL_REPORT_QUARTERLY_STATE_PARAMETER = "InternalReportQuarterlyStateParameter";
	public static String PROP_GOI_ANNUALLY_PARAMETER = "GoiAnnuallyParameter";
	public static String PROP_HMIS_TYPE = "HmisType";
	public static String PROP_INTERNAL_REPORT_MONTHLY_SUB_DISTRICT_ID = "InternalReportMonthlySubDistrictId";
	public static String PROP_INTERNAL_REPORT_QUARTERLY_DISTRICT_ID = "InternalReportQuarterlyDistrictId";
	public static String PROP_GOI_QUARTERLY_ID = "GoiQuarterlyId";
	public static String PROP_INTERNAL_REPORT_ANNUALLY_STATE_PARAMETER = "InternalReportAnnuallyStateParameter";
	public static String PROP_INTERNAL_REPORT_MONTHLY_SC_ID = "InternalReportMonthlyScId";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_DISTRICT3_ID = "InfrastructurelReportMonthlyDistrict3Id";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_DISTRICT2_PARAMETER = "InfrastructurelReportMonthlyDistrict2Parameter";
	public static String PROP_INTERNAL_REPORT_MONTHLY_DISTRICT_ID = "InternalReportMonthlyDistrictId";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_SUB_DISTRICT1_ID = "InfrastructurelReportMonthlySubDistrict1Id";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_DISTRICT3_PARAMETER = "InfrastructurelReportMonthlyDistrict3Parameter";
	public static String PROP_INTERNAL_REPORT_MONTHLY_PHC_ID = "InternalReportMonthlyPhcId";
	public static String PROP_GOI_QUARTERLY_PARAMETER = "GoiQuarterlyParameter";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_SUB_DISTRICT1_PARAMETER = "InfrastructurelReportMonthlySubDistrict1Parameter";
	public static String PROP_INTERNAL_REPORT_ANNUALLY_DISTRICT_PARAMETER = "InternalReportAnnuallyDistrictParameter";
	public static String PROP_INTERNAL_REPORT_MONTHLY_DISTRICT_HOSPITAL_ID = "InternalReportMonthlyDistrictHospitalId";
	public static String PROP_HMIS_ID = "HmisId";
	public static String PROP_STATUS = "Status";
	public static String PROP_INTERNAL_REPORT_MONTHLY_PHC_PARAMETER = "InternalReportMonthlyPhcParameter";
	public static String PROP_INTERNAL_REPORT_MONTHLY_CHC_PARAMETER = "InternalReportMonthlyChcParameter";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_DISTRICT1_PARAMETER = "InfrastructurelReportMonthlyDistrict1Parameter";
	public static String PROP_ID = "Id";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_SUB_DISTRICT2_PARAMETER = "InfrastructurelReportMonthlySubDistrict2Parameter";
	public static String PROP_INTERNAL_REPORT_ANNUALLY_STATE_ID = "InternalReportAnnuallyStateId";
	public static String PROP_GOI_MONTHLY_ID = "GoiMonthlyId";
	public static String PROP_INFRASTRUCTUREL_REPORT_MONTHLY_SUB_DISTRICT2_ID = "InfrastructurelReportMonthlySubDistrict2Id";
	public static String PROP_INTERNAL_REPORT_QUARTERLY_STATE_ID = "InternalReportQuarterlyStateId";


	// constructors
	public BaseMasPhReportsParameters () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPhReportsParameters (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String hmisId;
	private java.lang.String hmisParameter;
	private java.lang.String hmisType;
	private java.lang.String goiMonthlyId;
	private java.lang.String goiMonthlyParameter;
	private java.lang.String goiQuarterlyId;
	private java.lang.String goiQuarterlyParameter;
	private java.lang.String goiAnnuallyId;
	private java.lang.String goiAnnuallyParameter;
	private java.lang.String internalReportMonthlyDistrictId;
	private java.lang.String internalReportMonthlyDistrictParameter;
	private java.lang.String internalReportQuarterlyDistrictId;
	private java.lang.String internalReportQuarterlyDistrictParameter;
	private java.lang.String internalReportAnnuallyDistrictId;
	private java.lang.String internalReportAnnuallyDistrictParameter;
	private java.lang.String internalReportQuarterlyStateId;
	private java.lang.String internalReportQuarterlyStateParameter;
	private java.lang.String internalReportAnnuallyStateId;
	private java.lang.String internalReportAnnuallyStateParameter;
	private java.lang.String internalReportMonthlyScId;
	private java.lang.String internalReportMonthlyScParameter;
	private java.lang.String internalReportMonthlyChcId;
	private java.lang.String internalReportMonthlyChcParameter;
	private java.lang.String internalReportMonthlyPhcId;
	private java.lang.String internalReportMonthlyPhcParameter;
	private java.lang.String internalReportMonthlySubDistrictId;
	private java.lang.String internalReportMonthlySubDistrictParameter;
	private java.lang.String infrastructurelReportMonthlySubDistrict1Id;
	private java.lang.String infrastructurelReportMonthlySubDistrict1Parameter;
	private java.lang.String infrastructurelReportMonthlySubDistrict2Id;
	private java.lang.String infrastructurelReportMonthlySubDistrict2Parameter;
	private java.lang.String infrastructurelReportMonthlyDistrict1Id;
	private java.lang.String infrastructurelReportMonthlyDistrict1Parameter;
	private java.lang.String infrastructurelReportMonthlyDistrict2Id;
	private java.lang.String infrastructurelReportMonthlyDistrict2Parameter;
	private java.lang.String infrastructurelReportMonthlyDistrict3Id;
	private java.lang.String infrastructurelReportMonthlyDistrict3Parameter;
	private java.lang.String nvbdcpReportId;
	private java.lang.String nvbdcpReportParameter;
	private java.lang.String status;
	private java.lang.String internalReportMonthlyDistrictHospitalId;
	private java.lang.String internalReportMonthlyDistrictHospitalParameter;



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
	 * Return the value associated with the column: hmis_id
	 */
	public java.lang.String getHmisId () {
		return hmisId;
	}

	/**
	 * Set the value related to the column: hmis_id
	 * @param hmisId the hmis_id value
	 */
	public void setHmisId (java.lang.String hmisId) {
		this.hmisId = hmisId;
	}



	/**
	 * Return the value associated with the column: hmis_parameter
	 */
	public java.lang.String getHmisParameter () {
		return hmisParameter;
	}

	/**
	 * Set the value related to the column: hmis_parameter
	 * @param hmisParameter the hmis_parameter value
	 */
	public void setHmisParameter (java.lang.String hmisParameter) {
		this.hmisParameter = hmisParameter;
	}



	/**
	 * Return the value associated with the column: hmis_type
	 */
	public java.lang.String getHmisType () {
		return hmisType;
	}

	/**
	 * Set the value related to the column: hmis_type
	 * @param hmisType the hmis_type value
	 */
	public void setHmisType (java.lang.String hmisType) {
		this.hmisType = hmisType;
	}



	/**
	 * Return the value associated with the column: goi_monthly_id
	 */
	public java.lang.String getGoiMonthlyId () {
		return goiMonthlyId;
	}

	/**
	 * Set the value related to the column: goi_monthly_id
	 * @param goiMonthlyId the goi_monthly_id value
	 */
	public void setGoiMonthlyId (java.lang.String goiMonthlyId) {
		this.goiMonthlyId = goiMonthlyId;
	}



	/**
	 * Return the value associated with the column: goi_monthly_parameter
	 */
	public java.lang.String getGoiMonthlyParameter () {
		return goiMonthlyParameter;
	}

	/**
	 * Set the value related to the column: goi_monthly_parameter
	 * @param goiMonthlyParameter the goi_monthly_parameter value
	 */
	public void setGoiMonthlyParameter (java.lang.String goiMonthlyParameter) {
		this.goiMonthlyParameter = goiMonthlyParameter;
	}



	/**
	 * Return the value associated with the column: goi_quarterly_id
	 */
	public java.lang.String getGoiQuarterlyId () {
		return goiQuarterlyId;
	}

	/**
	 * Set the value related to the column: goi_quarterly_id
	 * @param goiQuarterlyId the goi_quarterly_id value
	 */
	public void setGoiQuarterlyId (java.lang.String goiQuarterlyId) {
		this.goiQuarterlyId = goiQuarterlyId;
	}



	/**
	 * Return the value associated with the column: goi_quarterly_parameter
	 */
	public java.lang.String getGoiQuarterlyParameter () {
		return goiQuarterlyParameter;
	}

	/**
	 * Set the value related to the column: goi_quarterly_parameter
	 * @param goiQuarterlyParameter the goi_quarterly_parameter value
	 */
	public void setGoiQuarterlyParameter (java.lang.String goiQuarterlyParameter) {
		this.goiQuarterlyParameter = goiQuarterlyParameter;
	}



	/**
	 * Return the value associated with the column: goi_annually_id
	 */
	public java.lang.String getGoiAnnuallyId () {
		return goiAnnuallyId;
	}

	/**
	 * Set the value related to the column: goi_annually_id
	 * @param goiAnnuallyId the goi_annually_id value
	 */
	public void setGoiAnnuallyId (java.lang.String goiAnnuallyId) {
		this.goiAnnuallyId = goiAnnuallyId;
	}



	/**
	 * Return the value associated with the column: goi_annually_parameter
	 */
	public java.lang.String getGoiAnnuallyParameter () {
		return goiAnnuallyParameter;
	}

	/**
	 * Set the value related to the column: goi_annually_parameter
	 * @param goiAnnuallyParameter the goi_annually_parameter value
	 */
	public void setGoiAnnuallyParameter (java.lang.String goiAnnuallyParameter) {
		this.goiAnnuallyParameter = goiAnnuallyParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_district_id
	 */
	public java.lang.String getInternalReportMonthlyDistrictId () {
		return internalReportMonthlyDistrictId;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_district_id
	 * @param internalReportMonthlyDistrictId the internal_report_monthly_district_id value
	 */
	public void setInternalReportMonthlyDistrictId (java.lang.String internalReportMonthlyDistrictId) {
		this.internalReportMonthlyDistrictId = internalReportMonthlyDistrictId;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_district_parameter
	 */
	public java.lang.String getInternalReportMonthlyDistrictParameter () {
		return internalReportMonthlyDistrictParameter;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_district_parameter
	 * @param internalReportMonthlyDistrictParameter the internal_report_monthly_district_parameter value
	 */
	public void setInternalReportMonthlyDistrictParameter (java.lang.String internalReportMonthlyDistrictParameter) {
		this.internalReportMonthlyDistrictParameter = internalReportMonthlyDistrictParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_quarterly_district_id
	 */
	public java.lang.String getInternalReportQuarterlyDistrictId () {
		return internalReportQuarterlyDistrictId;
	}

	/**
	 * Set the value related to the column: internal_report_quarterly_district_id
	 * @param internalReportQuarterlyDistrictId the internal_report_quarterly_district_id value
	 */
	public void setInternalReportQuarterlyDistrictId (java.lang.String internalReportQuarterlyDistrictId) {
		this.internalReportQuarterlyDistrictId = internalReportQuarterlyDistrictId;
	}



	/**
	 * Return the value associated with the column: internal_report_quarterly_district_parameter
	 */
	public java.lang.String getInternalReportQuarterlyDistrictParameter () {
		return internalReportQuarterlyDistrictParameter;
	}

	/**
	 * Set the value related to the column: internal_report_quarterly_district_parameter
	 * @param internalReportQuarterlyDistrictParameter the internal_report_quarterly_district_parameter value
	 */
	public void setInternalReportQuarterlyDistrictParameter (java.lang.String internalReportQuarterlyDistrictParameter) {
		this.internalReportQuarterlyDistrictParameter = internalReportQuarterlyDistrictParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_annually_district_id
	 */
	public java.lang.String getInternalReportAnnuallyDistrictId () {
		return internalReportAnnuallyDistrictId;
	}

	/**
	 * Set the value related to the column: internal_report_annually_district_id
	 * @param internalReportAnnuallyDistrictId the internal_report_annually_district_id value
	 */
	public void setInternalReportAnnuallyDistrictId (java.lang.String internalReportAnnuallyDistrictId) {
		this.internalReportAnnuallyDistrictId = internalReportAnnuallyDistrictId;
	}



	/**
	 * Return the value associated with the column: internal_report_annually_district_parameter
	 */
	public java.lang.String getInternalReportAnnuallyDistrictParameter () {
		return internalReportAnnuallyDistrictParameter;
	}

	/**
	 * Set the value related to the column: internal_report_annually_district_parameter
	 * @param internalReportAnnuallyDistrictParameter the internal_report_annually_district_parameter value
	 */
	public void setInternalReportAnnuallyDistrictParameter (java.lang.String internalReportAnnuallyDistrictParameter) {
		this.internalReportAnnuallyDistrictParameter = internalReportAnnuallyDistrictParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_quarterly_state_id
	 */
	public java.lang.String getInternalReportQuarterlyStateId () {
		return internalReportQuarterlyStateId;
	}

	/**
	 * Set the value related to the column: internal_report_quarterly_state_id
	 * @param internalReportQuarterlyStateId the internal_report_quarterly_state_id value
	 */
	public void setInternalReportQuarterlyStateId (java.lang.String internalReportQuarterlyStateId) {
		this.internalReportQuarterlyStateId = internalReportQuarterlyStateId;
	}



	/**
	 * Return the value associated with the column: internal_report_quarterly_state_parameter
	 */
	public java.lang.String getInternalReportQuarterlyStateParameter () {
		return internalReportQuarterlyStateParameter;
	}

	/**
	 * Set the value related to the column: internal_report_quarterly_state_parameter
	 * @param internalReportQuarterlyStateParameter the internal_report_quarterly_state_parameter value
	 */
	public void setInternalReportQuarterlyStateParameter (java.lang.String internalReportQuarterlyStateParameter) {
		this.internalReportQuarterlyStateParameter = internalReportQuarterlyStateParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_annually_state_id
	 */
	public java.lang.String getInternalReportAnnuallyStateId () {
		return internalReportAnnuallyStateId;
	}

	/**
	 * Set the value related to the column: internal_report_annually_state_id
	 * @param internalReportAnnuallyStateId the internal_report_annually_state_id value
	 */
	public void setInternalReportAnnuallyStateId (java.lang.String internalReportAnnuallyStateId) {
		this.internalReportAnnuallyStateId = internalReportAnnuallyStateId;
	}



	/**
	 * Return the value associated with the column: internal_report_annually_state_parameter
	 */
	public java.lang.String getInternalReportAnnuallyStateParameter () {
		return internalReportAnnuallyStateParameter;
	}

	/**
	 * Set the value related to the column: internal_report_annually_state_parameter
	 * @param internalReportAnnuallyStateParameter the internal_report_annually_state_parameter value
	 */
	public void setInternalReportAnnuallyStateParameter (java.lang.String internalReportAnnuallyStateParameter) {
		this.internalReportAnnuallyStateParameter = internalReportAnnuallyStateParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_sc_id
	 */
	public java.lang.String getInternalReportMonthlyScId () {
		return internalReportMonthlyScId;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_sc_id
	 * @param internalReportMonthlyScId the internal_report_monthly_sc_id value
	 */
	public void setInternalReportMonthlyScId (java.lang.String internalReportMonthlyScId) {
		this.internalReportMonthlyScId = internalReportMonthlyScId;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_sc_parameter
	 */
	public java.lang.String getInternalReportMonthlyScParameter () {
		return internalReportMonthlyScParameter;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_sc_parameter
	 * @param internalReportMonthlyScParameter the internal_report_monthly_sc_parameter value
	 */
	public void setInternalReportMonthlyScParameter (java.lang.String internalReportMonthlyScParameter) {
		this.internalReportMonthlyScParameter = internalReportMonthlyScParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_chc_id
	 */
	public java.lang.String getInternalReportMonthlyChcId () {
		return internalReportMonthlyChcId;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_chc_id
	 * @param internalReportMonthlyChcId the internal_report_monthly_chc_id value
	 */
	public void setInternalReportMonthlyChcId (java.lang.String internalReportMonthlyChcId) {
		this.internalReportMonthlyChcId = internalReportMonthlyChcId;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_chc_parameter
	 */
	public java.lang.String getInternalReportMonthlyChcParameter () {
		return internalReportMonthlyChcParameter;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_chc_parameter
	 * @param internalReportMonthlyChcParameter the internal_report_monthly_chc_parameter value
	 */
	public void setInternalReportMonthlyChcParameter (java.lang.String internalReportMonthlyChcParameter) {
		this.internalReportMonthlyChcParameter = internalReportMonthlyChcParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_phc_id
	 */
	public java.lang.String getInternalReportMonthlyPhcId () {
		return internalReportMonthlyPhcId;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_phc_id
	 * @param internalReportMonthlyPhcId the internal_report_monthly_phc_id value
	 */
	public void setInternalReportMonthlyPhcId (java.lang.String internalReportMonthlyPhcId) {
		this.internalReportMonthlyPhcId = internalReportMonthlyPhcId;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_phc_parameter
	 */
	public java.lang.String getInternalReportMonthlyPhcParameter () {
		return internalReportMonthlyPhcParameter;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_phc_parameter
	 * @param internalReportMonthlyPhcParameter the internal_report_monthly_phc_parameter value
	 */
	public void setInternalReportMonthlyPhcParameter (java.lang.String internalReportMonthlyPhcParameter) {
		this.internalReportMonthlyPhcParameter = internalReportMonthlyPhcParameter;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_sub_district_id
	 */
	public java.lang.String getInternalReportMonthlySubDistrictId () {
		return internalReportMonthlySubDistrictId;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_sub_district_id
	 * @param internalReportMonthlySubDistrictId the internal_report_monthly_sub_district_id value
	 */
	public void setInternalReportMonthlySubDistrictId (java.lang.String internalReportMonthlySubDistrictId) {
		this.internalReportMonthlySubDistrictId = internalReportMonthlySubDistrictId;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_sub_district_parameter
	 */
	public java.lang.String getInternalReportMonthlySubDistrictParameter () {
		return internalReportMonthlySubDistrictParameter;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_sub_district_parameter
	 * @param internalReportMonthlySubDistrictParameter the internal_report_monthly_sub_district_parameter value
	 */
	public void setInternalReportMonthlySubDistrictParameter (java.lang.String internalReportMonthlySubDistrictParameter) {
		this.internalReportMonthlySubDistrictParameter = internalReportMonthlySubDistrictParameter;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_sub_district1_id
	 */
	public java.lang.String getInfrastructurelReportMonthlySubDistrict1Id () {
		return infrastructurelReportMonthlySubDistrict1Id;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_sub_district1_id
	 * @param infrastructurelReportMonthlySubDistrict1Id the infrastructurel_report_monthly_sub_district1_id value
	 */
	public void setInfrastructurelReportMonthlySubDistrict1Id (java.lang.String infrastructurelReportMonthlySubDistrict1Id) {
		this.infrastructurelReportMonthlySubDistrict1Id = infrastructurelReportMonthlySubDistrict1Id;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_sub_district1_parameter
	 */
	public java.lang.String getInfrastructurelReportMonthlySubDistrict1Parameter () {
		return infrastructurelReportMonthlySubDistrict1Parameter;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_sub_district1_parameter
	 * @param infrastructurelReportMonthlySubDistrict1Parameter the infrastructurel_report_monthly_sub_district1_parameter value
	 */
	public void setInfrastructurelReportMonthlySubDistrict1Parameter (java.lang.String infrastructurelReportMonthlySubDistrict1Parameter) {
		this.infrastructurelReportMonthlySubDistrict1Parameter = infrastructurelReportMonthlySubDistrict1Parameter;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_sub_district2_id
	 */
	public java.lang.String getInfrastructurelReportMonthlySubDistrict2Id () {
		return infrastructurelReportMonthlySubDistrict2Id;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_sub_district2_id
	 * @param infrastructurelReportMonthlySubDistrict2Id the infrastructurel_report_monthly_sub_district2_id value
	 */
	public void setInfrastructurelReportMonthlySubDistrict2Id (java.lang.String infrastructurelReportMonthlySubDistrict2Id) {
		this.infrastructurelReportMonthlySubDistrict2Id = infrastructurelReportMonthlySubDistrict2Id;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_sub_district2_parameter
	 */
	public java.lang.String getInfrastructurelReportMonthlySubDistrict2Parameter () {
		return infrastructurelReportMonthlySubDistrict2Parameter;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_sub_district2_parameter
	 * @param infrastructurelReportMonthlySubDistrict2Parameter the infrastructurel_report_monthly_sub_district2_parameter value
	 */
	public void setInfrastructurelReportMonthlySubDistrict2Parameter (java.lang.String infrastructurelReportMonthlySubDistrict2Parameter) {
		this.infrastructurelReportMonthlySubDistrict2Parameter = infrastructurelReportMonthlySubDistrict2Parameter;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_district1_id
	 */
	public java.lang.String getInfrastructurelReportMonthlyDistrict1Id () {
		return infrastructurelReportMonthlyDistrict1Id;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_district1_id
	 * @param infrastructurelReportMonthlyDistrict1Id the infrastructurel_report_monthly_district1_id value
	 */
	public void setInfrastructurelReportMonthlyDistrict1Id (java.lang.String infrastructurelReportMonthlyDistrict1Id) {
		this.infrastructurelReportMonthlyDistrict1Id = infrastructurelReportMonthlyDistrict1Id;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_district1_parameter
	 */
	public java.lang.String getInfrastructurelReportMonthlyDistrict1Parameter () {
		return infrastructurelReportMonthlyDistrict1Parameter;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_district1_parameter
	 * @param infrastructurelReportMonthlyDistrict1Parameter the infrastructurel_report_monthly_district1_parameter value
	 */
	public void setInfrastructurelReportMonthlyDistrict1Parameter (java.lang.String infrastructurelReportMonthlyDistrict1Parameter) {
		this.infrastructurelReportMonthlyDistrict1Parameter = infrastructurelReportMonthlyDistrict1Parameter;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_district2_id
	 */
	public java.lang.String getInfrastructurelReportMonthlyDistrict2Id () {
		return infrastructurelReportMonthlyDistrict2Id;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_district2_id
	 * @param infrastructurelReportMonthlyDistrict2Id the infrastructurel_report_monthly_district2_id value
	 */
	public void setInfrastructurelReportMonthlyDistrict2Id (java.lang.String infrastructurelReportMonthlyDistrict2Id) {
		this.infrastructurelReportMonthlyDistrict2Id = infrastructurelReportMonthlyDistrict2Id;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_district2_parameter
	 */
	public java.lang.String getInfrastructurelReportMonthlyDistrict2Parameter () {
		return infrastructurelReportMonthlyDistrict2Parameter;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_district2_parameter
	 * @param infrastructurelReportMonthlyDistrict2Parameter the infrastructurel_report_monthly_district2_parameter value
	 */
	public void setInfrastructurelReportMonthlyDistrict2Parameter (java.lang.String infrastructurelReportMonthlyDistrict2Parameter) {
		this.infrastructurelReportMonthlyDistrict2Parameter = infrastructurelReportMonthlyDistrict2Parameter;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_district3_id
	 */
	public java.lang.String getInfrastructurelReportMonthlyDistrict3Id () {
		return infrastructurelReportMonthlyDistrict3Id;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_district3_id
	 * @param infrastructurelReportMonthlyDistrict3Id the infrastructurel_report_monthly_district3_id value
	 */
	public void setInfrastructurelReportMonthlyDistrict3Id (java.lang.String infrastructurelReportMonthlyDistrict3Id) {
		this.infrastructurelReportMonthlyDistrict3Id = infrastructurelReportMonthlyDistrict3Id;
	}



	/**
	 * Return the value associated with the column: infrastructurel_report_monthly_district3_parameter
	 */
	public java.lang.String getInfrastructurelReportMonthlyDistrict3Parameter () {
		return infrastructurelReportMonthlyDistrict3Parameter;
	}

	/**
	 * Set the value related to the column: infrastructurel_report_monthly_district3_parameter
	 * @param infrastructurelReportMonthlyDistrict3Parameter the infrastructurel_report_monthly_district3_parameter value
	 */
	public void setInfrastructurelReportMonthlyDistrict3Parameter (java.lang.String infrastructurelReportMonthlyDistrict3Parameter) {
		this.infrastructurelReportMonthlyDistrict3Parameter = infrastructurelReportMonthlyDistrict3Parameter;
	}



	/**
	 * Return the value associated with the column: nvbdcp_report_id
	 */
	public java.lang.String getNvbdcpReportId () {
		return nvbdcpReportId;
	}

	/**
	 * Set the value related to the column: nvbdcp_report_id
	 * @param nvbdcpReportId the nvbdcp_report_id value
	 */
	public void setNvbdcpReportId (java.lang.String nvbdcpReportId) {
		this.nvbdcpReportId = nvbdcpReportId;
	}



	/**
	 * Return the value associated with the column: nvbdcp_report_parameter
	 */
	public java.lang.String getNvbdcpReportParameter () {
		return nvbdcpReportParameter;
	}

	/**
	 * Set the value related to the column: nvbdcp_report_parameter
	 * @param nvbdcpReportParameter the nvbdcp_report_parameter value
	 */
	public void setNvbdcpReportParameter (java.lang.String nvbdcpReportParameter) {
		this.nvbdcpReportParameter = nvbdcpReportParameter;
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
	 * Return the value associated with the column: internal_report_monthly_district_hospital_id
	 */
	public java.lang.String getInternalReportMonthlyDistrictHospitalId () {
		return internalReportMonthlyDistrictHospitalId;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_district_hospital_id
	 * @param internalReportMonthlyDistrictHospitalId the internal_report_monthly_district_hospital_id value
	 */
	public void setInternalReportMonthlyDistrictHospitalId (java.lang.String internalReportMonthlyDistrictHospitalId) {
		this.internalReportMonthlyDistrictHospitalId = internalReportMonthlyDistrictHospitalId;
	}



	/**
	 * Return the value associated with the column: internal_report_monthly_district_hospital_parameter
	 */
	public java.lang.String getInternalReportMonthlyDistrictHospitalParameter () {
		return internalReportMonthlyDistrictHospitalParameter;
	}

	/**
	 * Set the value related to the column: internal_report_monthly_district_hospital_parameter
	 * @param internalReportMonthlyDistrictHospitalParameter the internal_report_monthly_district_hospital_parameter value
	 */
	public void setInternalReportMonthlyDistrictHospitalParameter (java.lang.String internalReportMonthlyDistrictHospitalParameter) {
		this.internalReportMonthlyDistrictHospitalParameter = internalReportMonthlyDistrictHospitalParameter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPhReportsParameters)) return false;
		else {
			jkt.hms.masters.business.MasPhReportsParameters masPhReportsParameters = (jkt.hms.masters.business.MasPhReportsParameters) obj;
			if (null == this.getId() || null == masPhReportsParameters.getId()) return false;
			else return (this.getId().equals(masPhReportsParameters.getId()));
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