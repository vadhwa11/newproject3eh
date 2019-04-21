package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_survey_target table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_survey_target"
 */

public abstract class BaseMasSurveyTarget  implements Serializable {

	public static String REF = "MasSurveyTarget";
	public static String PROP_MONTHLY_MEMBER_SURVEY_TARGET = "MonthlyMemberSurveyTarget";
	public static String PROP_MONTHLY_HOUSE_SURVEY_TARGET = "MonthlyHouseSurveyTarget";
	public static String PROP_MONTHLY_MEMBER_SURVEY_PERCENT = "MonthlyMemberSurveyPercent";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_UPDATE_DATE = "UpdateDate";
	public static String PROP_UPDATED_BY = "UpdatedBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ANNUAL_HOUSE_SURVEY_PERCENT = "AnnualHouseSurveyPercent";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MONTHLY_HOUSE_SURVEY_PERCENT = "MonthlyHouseSurveyPercent";
	public static String PROP_PHC_ID = "PhcId";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOUSE_SURVEY_ID = "HouseSurveyId";
	public static String PROP_INSTITUTE_ID = "InstituteId";
	public static String PROP_ANNUAL_MEMBER_SURVEY_PERCENT = "AnnualMemberSurveyPercent";
	public static String PROP_DISTRICT_SURVEY = "DistrictSurvey";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_HOSPITAL_TYPE = "HospitalType";
	public static String PROP_ANNUAL_MEMBER_SURVEY_TARGET = "AnnualMemberSurveyTarget";
	public static String PROP_ANNUAL_HOUSE_SURVEY_TARGET = "AnnualHouseSurveyTarget";
	public static String PROP_MEMBER_SURVEY = "MemberSurvey";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_VILLAGE_SURVEY = "VillageSurvey";
	public static String PROP_ID = "Id";
	public static String PROP_HVM_MONTHLY_SURVEY_PERCENT = "HvmMonthlySurveyPercent";
	public static String PROP_SHORT_NAME = "ShortName";
	public static String PROP_CHC_INSTITUTE = "ChcInstitute";
	public static String PROP_HEALTH_BLOCK = "HealthBlock";
	public static String PROP_BASIC_SUB_CENTER_INSTITUTE = "BasicSubCenterInstitute";
	public static String PROP_BASIC_SECTION_SUB_CENTER_NAME = "BasicSectionSubCenterName";
	public static String PROP_HOUSE_SURVEY_FROM_DATE = "HouseSurveyFromDate";
	public static String PROP_HOUSE_SURVEY_TO_DATE = "HouseSurveyToDate";
	public static String PROP_MEMBER_SURVEY_FROM_DATE = "MemberSurveyFromDate";
	public static String PROP_MEMBER_SURVEY_TO_DATE = "MemberSurveyToDate";
	public static String PROP_HOUSE_VISIT_FROM_DATE = "HouseVisitFromDate";
	public static String PROP_HOUSE_VISIT_TO_DATE = "HouseVisitToDate";
	public static String PROP_MONTHLY_HOUSE_VISIT = "MonthlyHouseVisit";
	public static String PROP_ANNUAL_HOUSE_VISIT_COUNT = "AnnualHouseVisitCount";
	
	
	// constructors
	public BaseMasSurveyTarget () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSurveyTarget (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long instituteId;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.Long phcId;
	private java.lang.String status;
	private java.lang.String remarks;
	private java.util.Date createDate;
	private java.util.Date updateDate;
	private java.lang.Long houseSurveyId;
	private java.lang.Long annualHouseSurveyTarget;
	private java.lang.Long annualMemberSurveyTarget;
	private java.lang.Long monthlyHouseSurveyTarget;
	private java.lang.Long monthlyMemberSurveyTarget;
	private java.math.BigDecimal annualHouseSurveyPercent;
	private java.math.BigDecimal annualMemberSurveyPercent;
	private java.math.BigDecimal monthlyHouseSurveyPercent;
	private java.math.BigDecimal monthlyMemberSurveyPercent;
	private java.lang.String shortName;
	private java.lang.String basicSectionSubCenterName;
	private java.util.Date houseSurveyFromDate;
	private java.util.Date houseSurveyToDate;
	private java.util.Date memberSurveyFromDate;
	private java.util.Date memberSurveyToDate;
	private java.util.Date houseVisitFromDate;
	private java.util.Date houseVisitToDate;
	private java.lang.Long monthlyHouseVisit;
	private java.lang.Long annualHouseVisitCount;
	
	// many to one
	private jkt.hms.masters.business.MasHospital basicSubCenterInstitute;
	private jkt.hms.masters.business.PhVillageSurvey villageSurvey;
	private jkt.hms.masters.business.PhMemberSurvey memberSurvey;
	private jkt.hms.masters.business.Users updatedBy;
	private jkt.hms.masters.business.MasHospitalType hospitalType;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDistrict districtSurvey;
	private jkt.hms.masters.business.Users createdBy;
	private jkt.hms.masters.business.MasHospital chcInstitute;
	private jkt.hms.masters.business.MasHospital healthBlock;
	// collections
	private java.util.Set<jkt.hms.masters.business.MasSurveyTargetStatus> masSurveyTargetStatus;


	/**
	 * Return the value associated with the column: monthly_House_Visit
	 */
	public java.lang.Long getMonthlyHouseVisit () {
		return monthlyHouseVisit;
	}

	/**
	 * Set the value related to the column: monthly_House_Visit
	 * @param annualHouseSurveyTarget the monthly_House_Visit value
	 */
	public void setMonthlyHouseVisit (java.lang.Long monthlyHouseVisit) {
		this.monthlyHouseVisit = monthlyHouseVisit;
	}
	/**
	 * Return the value associated with the column: annual_House_Visit_Count
	 */
	public java.lang.Long getAnnualHouseVisitCount () {
		return annualHouseVisitCount;
	}

	/**
	 * Set the value related to the column: annual_House_Visit_Count
	 * @param annualHouseVisitCount the annual_House_Visit_Count value
	 */
	public void setAnnualHouseVisitCount (java.lang.Long annualHouseVisitCount) {
		this.annualHouseVisitCount = annualHouseVisitCount;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="target_id"
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
	 * Return the value associated with the column: institute_id
	 */
	public java.lang.Long getInstituteId () {
		return instituteId;
	}

	/**
	 * Set the value related to the column: institute_id
	 * @param instituteId the institute_id value
	 */
	public void setInstituteId (java.lang.Long instituteId) {
		this.instituteId = instituteId;
	}



	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * Return the value associated with the column: phc_id
	 */
	public java.lang.Long getPhcId () {
		return phcId;
	}

	/**
	 * Set the value related to the column: phc_id
	 * @param phcId the phc_id value
	 */
	public void setPhcId (java.lang.Long phcId) {
		this.phcId = phcId;
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
	 * Return the value associated with the column: create_date
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: create_date
	 * @param createDate the create_date value
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}



	/**
	 * Return the value associated with the column: update_date
	 */
	public java.util.Date getUpdateDate () {
		return updateDate;
	}

	/**
	 * Set the value related to the column: update_date
	 * @param updateDate the update_date value
	 */
	public void setUpdateDate (java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * Return the value associated with the column: house_survey_from_date
	 */
	public java.util.Date getHouseSurveyFromDate () {
		return houseSurveyFromDate;
	}

	/**
	 * Set the value related to the column: house_survey_from_date
	 * @param houseSurveyFromDate the house_survey_from_date value
	 */
	public void setHouseSurveyFromDate (java.util.Date houseSurveyFromDate) {
		this.houseSurveyFromDate = houseSurveyFromDate;
	}



	/**
	 * Return the value associated with the column: house_survey_to_date
	 */
	public java.util.Date getHouseSurveyToDate () {
		return houseSurveyToDate;
	}

	/**
	 * Set the value related to the column: house_survey_to_date
	 * @param houseSurveyToDate the house_survey_to_date value
	 */
	public void setHouseSurveyToDate (java.util.Date houseSurveyToDate) {
		this.houseSurveyToDate = houseSurveyToDate;
	}



	/**
	 * Return the value associated with the column: member_survey_from_date
	 */
	public java.util.Date getMemberSurveyFromDate () {
		return memberSurveyFromDate;
	}

	/**
	 * Set the value related to the column: member_survey_from_date
	 * @param memberSurveyFromDate the member_survey_from_date value
	 */
	public void setMemberSurveyFromDate (java.util.Date memberSurveyFromDate) {
		this.memberSurveyFromDate = memberSurveyFromDate;
	}



	/**
	 * Return the value associated with the column: member_survey_to_date
	 */
	public java.util.Date getMemberSurveyToDate () {
		return memberSurveyToDate;
	}

	/**
	 * Set the value related to the column: member_survey_to_date
	 * @param memberSurveyToDate the member_survey_to_date value
	 */
	public void setMemberSurveyToDate (java.util.Date memberSurveyToDate) {
		this.memberSurveyToDate = memberSurveyToDate;
	}



	/**
	 * Return the value associated with the column: house_visit_from_date
	 */
	public java.util.Date getHouseVisitFromDate () {
		return houseVisitFromDate;
	}

	/**
	 * Set the value related to the column: house_visit_from_date
	 * @param houseVisitFromDate the house_visit_from_date value
	 */
	public void setHouseVisitFromDate (java.util.Date houseVisitFromDate) {
		this.houseVisitFromDate = houseVisitFromDate;
	}



	/**
	 * Return the value associated with the column: house_visit_to_date
	 */
	public java.util.Date getHouseVisitToDate () {
		return houseVisitToDate;
	}

	/**
	 * Set the value related to the column: house_visit_to_date
	 * @param houseVisitToDate the house_visit_to_date value
	 */
	public void setHouseVisitToDate (java.util.Date houseVisitToDate) {
		this.houseVisitToDate = houseVisitToDate;
	}


	
	/**
	 * Return the value associated with the column: short_name
	 */
	public java.lang.String getShortName () {
		return shortName;
	}

	/**
	 * Set the value related to the column: short_name
	 * @param shortName the short_name value
	 */
	public void setShortName (java.lang.String shortName) {
		this.shortName = shortName;
	}

	/**
	 * Return the value associated with the column: house_survey_id
	 */
	public java.lang.Long getHouseSurveyId () {
		return houseSurveyId;
	}

	/**
	 * Set the value related to the column: house_survey_id
	 * @param houseSurveyId the house_survey_id value
	 */
	public void setHouseSurveyId (java.lang.Long houseSurveyId) {
		this.houseSurveyId = houseSurveyId;
	}

	/**
	 * Return the value associated with the column: annual_house_survey_target
	 */
	public java.lang.Long getAnnualHouseSurveyTarget () {
		return annualHouseSurveyTarget;
	}

	/**
	 * Set the value related to the column: annual_house_survey_target
	 * @param annualHouseSurveyTarget the annual_house_survey_target value
	 */
	public void setAnnualHouseSurveyTarget (java.lang.Long annualHouseSurveyTarget) {
		this.annualHouseSurveyTarget = annualHouseSurveyTarget;
	}



	/**
	 * Return the value associated with the column: annual_member_survey_target
	 */
	public java.lang.Long getAnnualMemberSurveyTarget () {
		return annualMemberSurveyTarget;
	}

	/**
	 * Set the value related to the column: annual_member_survey_target
	 * @param annualMemberSurveyTarget the annual_member_survey_target value
	 */
	public void setAnnualMemberSurveyTarget (java.lang.Long annualMemberSurveyTarget) {
		this.annualMemberSurveyTarget = annualMemberSurveyTarget;
	}



	/**
	 * Return the value associated with the column: monthly_house_survey_target
	 */
	public java.lang.Long getMonthlyHouseSurveyTarget () {
		return monthlyHouseSurveyTarget;
	}

	/**
	 * Set the value related to the column: monthly_house_survey_target
	 * @param monthlyHouseSurveyTarget the monthly_house_survey_target value
	 */
	public void setMonthlyHouseSurveyTarget (java.lang.Long monthlyHouseSurveyTarget) {
		this.monthlyHouseSurveyTarget = monthlyHouseSurveyTarget;
	}



	/**
	 * Return the value associated with the column: monthly_member_survey_target
	 */
	public java.lang.Long getMonthlyMemberSurveyTarget () {
		return monthlyMemberSurveyTarget;
	}

	/**
	 * Set the value related to the column: monthly_member_survey_target
	 * @param monthlyMemberSurveyTarget the monthly_member_survey_target value
	 */
	public void setMonthlyMemberSurveyTarget (java.lang.Long monthlyMemberSurveyTarget) {
		this.monthlyMemberSurveyTarget = monthlyMemberSurveyTarget;
	}



	/**
	 * Return the value associated with the column: annual_house_survey_percent
	 */
	public java.math.BigDecimal getAnnualHouseSurveyPercent () {
		return annualHouseSurveyPercent;
	}

	/**
	 * Set the value related to the column: annual_house_survey_percent
	 * @param annualHouseSurveyPercent the annual_house_survey_percent value
	 */
	public void setAnnualHouseSurveyPercent (java.math.BigDecimal annualHouseSurveyPercent) {
		this.annualHouseSurveyPercent = annualHouseSurveyPercent;
	}



	/**
	 * Return the value associated with the column: annual_member_survey_percent
	 */
	public java.math.BigDecimal getAnnualMemberSurveyPercent () {
		return annualMemberSurveyPercent;
	}

	/**
	 * Set the value related to the column: annual_member_survey_percent
	 * @param annualMemberSurveyPercent the annual_member_survey_percent value
	 */
	public void setAnnualMemberSurveyPercent (java.math.BigDecimal annualMemberSurveyPercent) {
		this.annualMemberSurveyPercent = annualMemberSurveyPercent;
	}



	/**
	 * Return the value associated with the column: monthly_house_survey_percent
	 */
	public java.math.BigDecimal getMonthlyHouseSurveyPercent () {
		return monthlyHouseSurveyPercent;
	}

	/**
	 * Set the value related to the column: monthly_house_survey_percent
	 * @param monthlyHouseSurveyPercent the monthly_house_survey_percent value
	 */
	public void setMonthlyHouseSurveyPercent (java.math.BigDecimal monthlyHouseSurveyPercent) {
		this.monthlyHouseSurveyPercent = monthlyHouseSurveyPercent;
	}



	/**
	 * Return the value associated with the column: monthly_member_survey_percent
	 */
	public java.math.BigDecimal getMonthlyMemberSurveyPercent () {
		return monthlyMemberSurveyPercent;
	}

	/**
	 * Set the value related to the column: monthly_member_survey_percent
	 * @param monthlyMemberSurveyPercent the monthly_member_survey_percent value
	 */
	public void setMonthlyMemberSurveyPercent (java.math.BigDecimal monthlyMemberSurveyPercent) {
		this.monthlyMemberSurveyPercent = monthlyMemberSurveyPercent;
	}

	/**
	 * Return the value associated with the column: village_survey_id
	 */
	public jkt.hms.masters.business.PhVillageSurvey getVillageSurvey () {
		return villageSurvey;
	}

	/**
	 * Set the value related to the column: village_survey_id
	 * @param villageSurvey the village_survey_id value
	 */
	public void setVillageSurvey (jkt.hms.masters.business.PhVillageSurvey villageSurvey) {
		this.villageSurvey = villageSurvey;
	}



	/**
	 * Return the value associated with the column: member_survey_id
	 */
	public jkt.hms.masters.business.PhMemberSurvey getMemberSurvey () {
		return memberSurvey;
	}

	/**
	 * Set the value related to the column: member_survey_id
	 * @param memberSurvey the member_survey_id value
	 */
	public void setMemberSurvey (jkt.hms.masters.business.PhMemberSurvey memberSurvey) {
		this.memberSurvey = memberSurvey;
	}



	/**
	 * Return the value associated with the column: updated_by
	 */
	public jkt.hms.masters.business.Users getUpdatedBy () {
		return updatedBy;
	}

	/**
	 * Set the value related to the column: updated_by
	 * @param updatedBy the updated_by value
	 */
	public void setUpdatedBy (jkt.hms.masters.business.Users updatedBy) {
		this.updatedBy = updatedBy;
	}



	/**
	 * Return the value associated with the column: hospital_type_id
	 */
	public jkt.hms.masters.business.MasHospitalType getHospitalType () {
		return hospitalType;
	}

	/**
	 * Set the value related to the column: hospital_type_id
	 * @param hospitalType the hospital_type_id value
	 */
	public void setHospitalType (jkt.hms.masters.business.MasHospitalType hospitalType) {
		this.hospitalType = hospitalType;
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
	 * Return the value associated with the column: district_survey_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrictSurvey () {
		return districtSurvey;
	}

	/**
	 * Set the value related to the column: district_survey_id
	 * @param districtSurvey the district_survey_id value
	 */
	public void setDistrictSurvey (jkt.hms.masters.business.MasDistrict districtSurvey) {
		this.districtSurvey = districtSurvey;
	}
	
	/**
	 * Return the value associated with the column: basic_sub_center_institute_id
	 */
	public jkt.hms.masters.business.MasHospital getBasicSubCenterInstitute () {
		return basicSubCenterInstitute;
	}

	/**
	 * Set the value related to the column: basic_sub_center_institute_id
	 * @param basicSubCenterInstitute the basic_sub_center_institute_id value
	 */
	public void setBasicSubCenterInstitute (jkt.hms.masters.business.MasHospital basicSubCenterInstitute) {
		this.basicSubCenterInstitute = basicSubCenterInstitute;
	}

	/**
	 * Set the value related to the column: chc_institute_id
	 * @param chcInstitute the chc_institute_id value
	 */
	public void setChcInstitute (jkt.hms.masters.business.MasHospital chcInstitute) {
		this.chcInstitute = chcInstitute;
	}
	/**
	 * Return the value associated with the column: chc_institute_id
	 */
	public jkt.hms.masters.business.MasHospital getChcInstitute () {
		return chcInstitute;
	}

	/**
	 * Return the value associated with the column: health_block
	 */
	public jkt.hms.masters.business.MasHospital getHealthBlock () {
		return healthBlock;
	}

	/**
	 * Set the value related to the column: health_block
	 * @param healthBlock the health_block value
	 */
	public void setHealthBlock (jkt.hms.masters.business.MasHospital healthBlock) {
		this.healthBlock = healthBlock;
	}

	/**
	 * Return the value associated with the column: created_by
	 */
	public jkt.hms.masters.business.Users getCreatedBy () {
		return createdBy;
	}

	/**
	 * Set the value related to the column: created_by
	 * @param createdBy the created_by value
	 */
	public void setCreatedBy (jkt.hms.masters.business.Users createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Return the value associated with the column: basic_section_sub_center_name
	 */
	public java.lang.String getBasicSectionSubCenterName () {
		return basicSectionSubCenterName;
	}

	/**
	 * Set the value related to the column: basic_section_sub_center_name
	 * @param basicSectionSubCenterName the basic_section_sub_center_name value
	 */
	public void setBasicSectionSubCenterName (java.lang.String basicSectionSubCenterName) {
		this.basicSectionSubCenterName = basicSectionSubCenterName;
	}

	/**
	 * Return the value associated with the column: MasSurveyTargetStatus
	 */
	public java.util.Set<jkt.hms.masters.business.MasSurveyTargetStatus> getMasSurveyTargetStatus () {
		return masSurveyTargetStatus;
	}

	/**
	 * Set the value related to the column: MasSurveyTargetStatus
	 * @param masSurveyTargetStatus the MasSurveyTargetStatus value
	 */
	public void setMasSurveyTargetStatus (java.util.Set<jkt.hms.masters.business.MasSurveyTargetStatus> masSurveyTargetStatus) {
		this.masSurveyTargetStatus = masSurveyTargetStatus;
	}

	public void addToMasSurveyTargetStatus (jkt.hms.masters.business.MasSurveyTargetStatus masSurveyTargetStatus) {
		if (null == getMasSurveyTargetStatus()) setMasSurveyTargetStatus(new java.util.TreeSet<jkt.hms.masters.business.MasSurveyTargetStatus>());
		getMasSurveyTargetStatus().add(masSurveyTargetStatus);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSurveyTarget)) return false;
		else {
			jkt.hms.masters.business.MasSurveyTarget masSurveyTarget = (jkt.hms.masters.business.MasSurveyTarget) obj;
			if (null == this.getId() || null == masSurveyTarget.getId()) return false;
			else return (this.getId().equals(masSurveyTarget.getId()));
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