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
	public static String PROP_MEMBER_SURVEY_HVM = "MemberSurveyHvm";
	public static String PROP_ANNUAL_HOUSE_SURVEY_PERCENT = "AnnualHouseSurveyPercent";
	public static String PROP_HOUSE_SURVEY_ID = "HouseSurveyId";
	public static String PROP_MEMBER_SURVEY = "MemberSurvey";
	public static String PROP_MEMBER_SURVEY_HVM_PERCENT = "MemberSurveyHvmPercent";
	public static String PROP_HOUSE_SURVEY_TARGET = "HouseSurveyTarget";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_PHC_ID = "PhcId";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_MEMBER_SURVEY_TARGET = "MemberSurveyTarget";
	public static String PROP_MONTHLY_HOUSE_SURVEY_TARGET = "MonthlyHouseSurveyTarget";
	public static String PROP_ANNUAL_MEMBER_SURVEY_PERCENT = "AnnualMemberSurveyPercent";
	public static String PROP_HVM_RATIO = "HvmRatio";
	public static String PROP_MEMBER_SURVEY_PERCENT = "MemberSurveyPercent";
	public static String PROP_ANNUAL_HOUSE_SURVEY_TARGET = "AnnualHouseSurveyTarget";
	public static String PROP_HVM_MONTHLY_SURVEY_PERCENT = "HvmMonthlySurveyPercent";
	public static String PROP_UPDATED_BY = "UpdatedBy";
	public static String PROP_MONTHLY_MEMBER_SURVEY_PERCENT = "MonthlyMemberSurveyPercent";
	public static String PROP_HVM_HOUSE_SURVEY_PERCENT = "HvmHouseSurveyPercent";
	public static String PROP_CREATED_TIME = "CreatedTime";
	public static String PROP_ANNUAL_MEMBER_SURVEY_TARGET = "AnnualMemberSurveyTarget";
	public static String PROP_HVM_PERCENT = "HvmPercent";
	public static String PROP_HOSPITAL_TYPE = "HospitalType";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_UPDATED_TIME = "UpdatedTime";
	public static String PROP_HOUSE_SURVEY_HVM = "HouseSurveyHvm";
	public static String PROP_MONTHLY_HOUSE_SURVEY_PERCENT = "MonthlyHouseSurveyPercent";
	public static String PROP_INSTITUTE_ID = "InstituteId";
	public static String PROP_DISTRICT_SURVEY = "DistrictSurvey";
	public static String PROP_STATUS = "Status";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_WARD_SURVEY_TARGET = "WardSurveyTarget";
	public static String PROP_HOUSE_SURVEY_PERCENT = "HouseSurveyPercent";
	public static String PROP_VILLAGE_SURVEY = "VillageSurvey";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_MONTHLY_MEMBER_SURVEY_TARGET = "MonthlyMemberSurveyTarget";
	public static String PROP_ID = "Id";
	public static String PROP_UPDATE_DATE = "UpdateDate";
	public static String PROP_HOUSE_SURVEY_HVM_PERCENT = "HouseSurveyHvmPercent";


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
	private java.lang.Long houseSurveyTarget;
	private java.lang.Long memberSurveyTarget;
	private java.lang.Long wardSurveyTarget;
	private java.lang.Long phcId;
	private java.lang.String status;
	private java.util.Date createDate;
	private java.util.Date updateDate;
	private java.lang.Long houseSurveyId;
	private java.lang.String remarks;
	private java.lang.String createdTime;
	private java.lang.String updatedTime;
	private java.lang.String memberSurveyPercent;
	private java.lang.String houseSurveyPercent;
	private java.lang.String hvmRatio;
	private java.lang.String hvmPercent;
	private java.lang.Long annualHouseSurveyTarget;
	private java.lang.Long annualMemberSurveyTarget;
	private java.lang.Long monthlyHouseSurveyTarget;
	private java.lang.Long monthlyMemberSurveyTarget;
	private java.lang.String annualHouseSurveyPercent;
	private java.lang.String annualMemberSurveyPercent;
	private java.lang.String monthlyHouseSurveyPercent;
	private java.lang.String monthlyMemberSurveyPercent;
	private java.lang.Long houseSurveyHvm;
	private java.lang.Long memberSurveyHvm;
	private java.lang.String houseSurveyHvmPercent;
	private java.lang.String memberSurveyHvmPercent;
	private java.lang.String hvmMonthlySurveyPercent;
	private java.lang.String hvmHouseSurveyPercent;

	// many to one
	private jkt.hms.masters.business.Users createdBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasHospitalType hospitalType;
	private jkt.hms.masters.business.Users updatedBy;
	private jkt.hms.masters.business.PhVillageSurvey villageSurvey;
	private jkt.hms.masters.business.PhMemberSurvey memberSurvey;
	private jkt.hms.masters.business.MasDistrict districtSurvey;



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
	 * Return the value associated with the column: house_survey_target
	 */
	public java.lang.Long getHouseSurveyTarget () {
		return houseSurveyTarget;
	}

	/**
	 * Set the value related to the column: house_survey_target
	 * @param houseSurveyTarget the house_survey_target value
	 */
	public void setHouseSurveyTarget (java.lang.Long houseSurveyTarget) {
		this.houseSurveyTarget = houseSurveyTarget;
	}



	/**
	 * Return the value associated with the column: member_survey_target
	 */
	public java.lang.Long getMemberSurveyTarget () {
		return memberSurveyTarget;
	}

	/**
	 * Set the value related to the column: member_survey_target
	 * @param memberSurveyTarget the member_survey_target value
	 */
	public void setMemberSurveyTarget (java.lang.Long memberSurveyTarget) {
		this.memberSurveyTarget = memberSurveyTarget;
	}



	/**
	 * Return the value associated with the column: ward_survey_target
	 */
	public java.lang.Long getWardSurveyTarget () {
		return wardSurveyTarget;
	}

	/**
	 * Set the value related to the column: ward_survey_target
	 * @param wardSurveyTarget the ward_survey_target value
	 */
	public void setWardSurveyTarget (java.lang.Long wardSurveyTarget) {
		this.wardSurveyTarget = wardSurveyTarget;
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
	 * Return the value associated with the column: created_time
	 */
	public java.lang.String getCreatedTime () {
		return createdTime;
	}

	/**
	 * Set the value related to the column: created_time
	 * @param createdTime the created_time value
	 */
	public void setCreatedTime (java.lang.String createdTime) {
		this.createdTime = createdTime;
	}



	/**
	 * Return the value associated with the column: updated_time
	 */
	public java.lang.String getUpdatedTime () {
		return updatedTime;
	}

	/**
	 * Set the value related to the column: updated_time
	 * @param updatedTime the updated_time value
	 */
	public void setUpdatedTime (java.lang.String updatedTime) {
		this.updatedTime = updatedTime;
	}



	/**
	 * Return the value associated with the column: member_survey_percent
	 */
	public java.lang.String getMemberSurveyPercent () {
		return memberSurveyPercent;
	}

	/**
	 * Set the value related to the column: member_survey_percent
	 * @param memberSurveyPercent the member_survey_percent value
	 */
	public void setMemberSurveyPercent (java.lang.String memberSurveyPercent) {
		this.memberSurveyPercent = memberSurveyPercent;
	}



	/**
	 * Return the value associated with the column: house_survey_percent
	 */
	public java.lang.String getHouseSurveyPercent () {
		return houseSurveyPercent;
	}

	/**
	 * Set the value related to the column: house_survey_percent
	 * @param houseSurveyPercent the house_survey_percent value
	 */
	public void setHouseSurveyPercent (java.lang.String houseSurveyPercent) {
		this.houseSurveyPercent = houseSurveyPercent;
	}



	/**
	 * Return the value associated with the column: hvm_ratio
	 */
	public java.lang.String getHvmRatio () {
		return hvmRatio;
	}

	/**
	 * Set the value related to the column: hvm_ratio
	 * @param hvmRatio the hvm_ratio value
	 */
	public void setHvmRatio (java.lang.String hvmRatio) {
		this.hvmRatio = hvmRatio;
	}



	/**
	 * Return the value associated with the column: hvm_percent
	 */
	public java.lang.String getHvmPercent () {
		return hvmPercent;
	}

	/**
	 * Set the value related to the column: hvm_percent
	 * @param hvmPercent the hvm_percent value
	 */
	public void setHvmPercent (java.lang.String hvmPercent) {
		this.hvmPercent = hvmPercent;
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
	public java.lang.String getAnnualHouseSurveyPercent () {
		return annualHouseSurveyPercent;
	}

	/**
	 * Set the value related to the column: annual_house_survey_percent
	 * @param annualHouseSurveyPercent the annual_house_survey_percent value
	 */
	public void setAnnualHouseSurveyPercent (java.lang.String annualHouseSurveyPercent) {
		this.annualHouseSurveyPercent = annualHouseSurveyPercent;
	}



	/**
	 * Return the value associated with the column: annual_member_survey_percent
	 */
	public java.lang.String getAnnualMemberSurveyPercent () {
		return annualMemberSurveyPercent;
	}

	/**
	 * Set the value related to the column: annual_member_survey_percent
	 * @param annualMemberSurveyPercent the annual_member_survey_percent value
	 */
	public void setAnnualMemberSurveyPercent (java.lang.String annualMemberSurveyPercent) {
		this.annualMemberSurveyPercent = annualMemberSurveyPercent;
	}



	/**
	 * Return the value associated with the column: monthly_house_survey_percent
	 */
	public java.lang.String getMonthlyHouseSurveyPercent () {
		return monthlyHouseSurveyPercent;
	}

	/**
	 * Set the value related to the column: monthly_house_survey_percent
	 * @param monthlyHouseSurveyPercent the monthly_house_survey_percent value
	 */
	public void setMonthlyHouseSurveyPercent (java.lang.String monthlyHouseSurveyPercent) {
		this.monthlyHouseSurveyPercent = monthlyHouseSurveyPercent;
	}



	/**
	 * Return the value associated with the column: monthly_member_survey_percent
	 */
	public java.lang.String getMonthlyMemberSurveyPercent () {
		return monthlyMemberSurveyPercent;
	}

	/**
	 * Set the value related to the column: monthly_member_survey_percent
	 * @param monthlyMemberSurveyPercent the monthly_member_survey_percent value
	 */
	public void setMonthlyMemberSurveyPercent (java.lang.String monthlyMemberSurveyPercent) {
		this.monthlyMemberSurveyPercent = monthlyMemberSurveyPercent;
	}



	/**
	 * Return the value associated with the column: house_survey_hvm
	 */
	public java.lang.Long getHouseSurveyHvm () {
		return houseSurveyHvm;
	}

	/**
	 * Set the value related to the column: house_survey_hvm
	 * @param houseSurveyHvm the house_survey_hvm value
	 */
	public void setHouseSurveyHvm (java.lang.Long houseSurveyHvm) {
		this.houseSurveyHvm = houseSurveyHvm;
	}



	/**
	 * Return the value associated with the column: member_survey_hvm
	 */
	public java.lang.Long getMemberSurveyHvm () {
		return memberSurveyHvm;
	}

	/**
	 * Set the value related to the column: member_survey_hvm
	 * @param memberSurveyHvm the member_survey_hvm value
	 */
	public void setMemberSurveyHvm (java.lang.Long memberSurveyHvm) {
		this.memberSurveyHvm = memberSurveyHvm;
	}



	/**
	 * Return the value associated with the column: house_survey_hvm_percent
	 */
	public java.lang.String getHouseSurveyHvmPercent () {
		return houseSurveyHvmPercent;
	}

	/**
	 * Set the value related to the column: house_survey_hvm_percent
	 * @param houseSurveyHvmPercent the house_survey_hvm_percent value
	 */
	public void setHouseSurveyHvmPercent (java.lang.String houseSurveyHvmPercent) {
		this.houseSurveyHvmPercent = houseSurveyHvmPercent;
	}



	/**
	 * Return the value associated with the column: member_survey_hvm_percent
	 */
	public java.lang.String getMemberSurveyHvmPercent () {
		return memberSurveyHvmPercent;
	}

	/**
	 * Set the value related to the column: member_survey_hvm_percent
	 * @param memberSurveyHvmPercent the member_survey_hvm_percent value
	 */
	public void setMemberSurveyHvmPercent (java.lang.String memberSurveyHvmPercent) {
		this.memberSurveyHvmPercent = memberSurveyHvmPercent;
	}



	/**
	 * Return the value associated with the column: hvm_monthly_survey_percent
	 */
	public java.lang.String getHvmMonthlySurveyPercent () {
		return hvmMonthlySurveyPercent;
	}

	/**
	 * Set the value related to the column: hvm_monthly_survey_percent
	 * @param hvmMonthlySurveyPercent the hvm_monthly_survey_percent value
	 */
	public void setHvmMonthlySurveyPercent (java.lang.String hvmMonthlySurveyPercent) {
		this.hvmMonthlySurveyPercent = hvmMonthlySurveyPercent;
	}



	/**
	 * Return the value associated with the column: hvm_house_survey_percent
	 */
	public java.lang.String getHvmHouseSurveyPercent () {
		return hvmHouseSurveyPercent;
	}

	/**
	 * Set the value related to the column: hvm_house_survey_percent
	 * @param hvmHouseSurveyPercent the hvm_house_survey_percent value
	 */
	public void setHvmHouseSurveyPercent (java.lang.String hvmHouseSurveyPercent) {
		this.hvmHouseSurveyPercent = hvmHouseSurveyPercent;
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