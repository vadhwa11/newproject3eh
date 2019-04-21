package jkt.hrms.recruitment.dataservice;

import static jkt.hrms.util.HrmsRequestConstants.EXP_LOWER_RANGE;
import static jkt.hrms.util.HrmsRequestConstants.EXP_UPPER_RANGE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.HrInstitutionalSanctionedPost;
import jkt.hms.masters.business.MasCadre;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrEmployeePayStructure;
import jkt.hrms.masters.business.HrMasApplicationLevel;
import jkt.hrms.masters.business.HrMasShift;
import jkt.hrms.masters.business.HrMasShiftCodes;
import jkt.hrms.masters.business.MasEmployeeType;
import jkt.hrms.masters.business.MasExperience;
import jkt.hrms.masters.business.MasInfrastructureRequerment;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.masters.business.MasVacancyReason;
import jkt.hrms.recruitment.masters.business.HrRequisitionHistory;
import jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus;
import jkt.hrms.recruitment.masters.business.RequestStatusMaster;
import jkt.hrms.recruitment.masters.business.ResourceRequisition;

//commented for maven
/*import org.apache.poi.hssf.record.formula.functions.Int;*/
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RecruitmentDataServiceImpl extends HibernateDaoSupport implements
		RecruitmentDataService {
/*	public Map<String, Object> showResourceReqJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();

		List<MasEmployeeType> masEmployeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasLocation> masLocationList = new ArrayList<MasLocation>();
		List<MasVacancyReason> masVacancyReasonList = new ArrayList<MasVacancyReason>();
		List<MasQualification> masQualificationList = new ArrayList<MasQualification>();
		List<MasEmployee> masManagerList = new ArrayList<MasEmployee>();
		List<MasExperience> masExperienceList = new ArrayList<MasExperience>();
		List<MasInfrastructureRequerment> masInfrastructureRequirmentList = new ArrayList<MasInfrastructureRequerment>();

		masEmployeeTypeList = session.createCriteria(MasEmployeeType.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masEmployeeTypeList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasEmployeeType where ");

		masDepartmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y")).list();
		// masDepartmentList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasDepartment");

		masLocationList = session.createCriteria(MasLocation.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masLocationList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasLocation");

		masVacancyReasonList = session.createCriteria(MasVacancyReason.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masVacancyReasonList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasVacancyReason");

		masQualificationList = session.createCriteria(MasQualification.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		// masQualificationList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasQualification");

		masManagerList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();

		masExperienceList = session.createCriteria(MasExperience.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masExperienceList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasExperience");

		masInfrastructureRequirmentList = session
				.createCriteria(MasInfrastructureRequerment.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masInfrastructureRequirmentList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasInfrastructureRequerment");

		map.put("masEmployeeTypeList", masEmployeeTypeList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masLocationList", masLocationList);
		map.put("masVacancyReasonList", masVacancyReasonList);
		map.put("masQualificationList", masQualificationList);
		map.put("masManagerList", masManagerList);
		map.put("masExperienceList", masExperienceList);
		map.put("masInfrastructureRequirmentList",
				masInfrastructureRequirmentList);
		map.put("hospitalId", hospitalId);

		return map;
	}*/
	
	public Map<String, Object> showResourceReqJsp(Map detailMap){
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasEmployeeType> masEmployeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasLocation> masLocationList = new ArrayList<MasLocation>();
		List<MasVacancyReason> masVacancyReasonList = new ArrayList<MasVacancyReason>();
		List<MasQualification> masQualificationList = new ArrayList<MasQualification>();
		List<MasEmployee> masManagerList = new ArrayList<MasEmployee>();
		List<MasExperience> masExperienceList = new ArrayList<MasExperience>();
		List<MasInfrastructureRequerment> masInfrastructureRequirmentList = new ArrayList<MasInfrastructureRequerment>();
		List<MasCadre> cadreList = new ArrayList<MasCadre>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> designationList = new ArrayList<MasRank>();
		List<MasRank> masRank1 = new ArrayList<MasRank>();
		List<MasHospital> institutionList=new ArrayList<MasHospital>();
		List<HrInstitutionalSanctionedPost> sanctionPostInstituteMasterList = new ArrayList<HrInstitutionalSanctionedPost>();
		
		int hospitalId=Integer.parseInt(""+detailMap.get("hospitalId"));
		/*int cadreId=0;
		int instituteId = 0;
		int departmentId = 0;
		int designationId = 0; 
		
		
		if(detailMap.get("designationId")!= null && !detailMap.get("designationId").equals("")){
			designationId=(Integer)detailMap.get("designationId");
		}
		if(detailMap.get("departmentId")!= null && !detailMap.get("departmentId").equals("")){
			departmentId=(Integer)detailMap.get("departmentId");
		}
		if(detailMap.get("instituteId")!= null && !detailMap.get("instituteId").equals("")){
			instituteId=(Integer)detailMap.get("instituteId");
		}
		if(detailMap.get("cadreId")!= null && !detailMap.get("cadreId").equals("")){
			cadreId=(Integer)detailMap.get("cadreId");
		}*/
		institutionList = session.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();

		masEmployeeTypeList = session.createCriteria(MasEmployeeType.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
		masEmployeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		masLocationList = session.createCriteria(MasLocation.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		masVacancyReasonList = session.createCriteria(MasVacancyReason.class).add(Restrictions.eq("Status","y")).list();
		
		cadreList =  session.createCriteria(MasCadre.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		gradeList =  session.createCriteria(MasGrade.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
/*		masQualificationList = session.createCriteria(MasQualification.class).add(Restrictions.eq("Status","y")).list();*/
	
		masManagerList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("FirstName")).list();
		
		masExperienceList = session.createCriteria(MasExperience.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		masInfrastructureRequirmentList = session.createCriteria(MasInfrastructureRequerment.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		designationList = session.createCriteria(MasRank.class).addOrder(Order.asc("RankName")).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
		/*Criteria c = session.createCriteria(HrInstitutionalSanctionedPost.class)
				//.add(Restrictions.eq("Institution.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase());
		if(instituteId != 0){
			c= c.add(Restrictions.eq("Institution.Id", instituteId));
		}
		if(departmentId != 0){
			c= c.add(Restrictions.eq("Department.Id", departmentId));
		}
		if(designationId != 0){
			c= c.add(Restrictions.eq("Rank.Id", designationId));
		}
		if(cadreId != 0){
			c= c.add(Restrictions.eq("Cadre.Id", cadreId));
		}
		sanctionPostInstituteMasterList= c.list();*/
		
		
		/*masRank1=session.createCriteria(MasRank.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y")).list();
		Criteria crit =session.createCriteria(MasRank.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y"));
		System.out.println(hospitalId +" "+gradeId+"- "+cadreId);
		if(cadreId !=0 ){
			crit = crit.add(Restrictions.eq("Cadre.Id", cadreId));
			
		}
		if(gradeId !=0 ){
			crit = crit.add(Restrictions.eq("Grade.Id", gradeId));
			
		}
		masRank = crit.list();*/
		String qry="select count(rank_id),rank_id from mas_employee group by rank_id having rank_id is not null";
		List rankListFromEmp=session.createSQLQuery(qry).list();
		

		map.put("designationList", designationList);
		map.put("institutionList", institutionList);
		map.put("masEmployeeTypeList", masEmployeeTypeList);
		map.put("masEmployeeDepartmentList", masEmployeeDepartmentList);
		map.put("masLocationList", masLocationList);
		map.put("masVacancyReasonList", masVacancyReasonList);
		map.put("masQualificationList", masQualificationList);
		map.put("masManagerList", masManagerList);
		map.put("masExperienceList", masExperienceList);
		map.put("masInfrastructureRequirmentList", masInfrastructureRequirmentList);
		map.put("hospitalId", hospitalId);
		//map.put("masRank", masRank);
		map.put("masRank1", masRank1);
		map.put("rankListFromEmp", rankListFromEmp);
		map.put("cadreList", cadreList);
		map.put("gradeList", gradeList);
		//map.put("sanctionPostInstituteMasterList", sanctionPostInstituteMasterList);
		return map;
	}
	@Override
	public Map<String, Object> searchResourceReqJsp(Map<String, Object> detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasEmployeeType> masEmployeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasLocation> masLocationList = new ArrayList<MasLocation>();
		List<MasVacancyReason> masVacancyReasonList = new ArrayList<MasVacancyReason>();
		List<MasQualification> masQualificationList = new ArrayList<MasQualification>();
		List<MasEmployee> masManagerList = new ArrayList<MasEmployee>();
		List<MasExperience> masExperienceList = new ArrayList<MasExperience>();
		List<MasInfrastructureRequerment> masInfrastructureRequirmentList = new ArrayList<MasInfrastructureRequerment>();
		List<MasCadre> cadreList = new ArrayList<MasCadre>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> designationList = new ArrayList<MasRank>();
		List<MasRank> masRank1 = new ArrayList<MasRank>();
		List<MasHospital> institutionList=new ArrayList<MasHospital>();
		List<HrInstitutionalSanctionedPost> sanctionPostInstituteMasterList = new ArrayList<HrInstitutionalSanctionedPost>();
		
		int hospitalId=Integer.parseInt(""+detailMap.get("hospitalId"));
		int cadreId=0;
		int instituteId = 0;
		int departmentId = 0;
		int designationId = 0; 
		
		
		if(detailMap.get("designationId")!= null && !detailMap.get("designationId").equals("")){
			designationId=(Integer)detailMap.get("designationId");
		}
		if(detailMap.get("departmentId")!= null && !detailMap.get("departmentId").equals("")){
			departmentId=(Integer)detailMap.get("departmentId");
		}
		if(detailMap.get("instituteId")!= null && !detailMap.get("instituteId").equals("")){
			instituteId=(Integer)detailMap.get("instituteId");
		}
		if(detailMap.get("cadreId")!= null && !detailMap.get("cadreId").equals("")){
			cadreId=(Integer)detailMap.get("cadreId");
		}
		
		institutionList = session.createCriteria(MasHospital.class).addOrder(Order.asc("HospitalName")).add(Restrictions.eq("Status","y").ignoreCase()).list();

		masEmployeeTypeList = session.createCriteria(MasEmployeeType.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
		masEmployeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		
		masLocationList = session.createCriteria(MasLocation.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y")).list();
		
		masVacancyReasonList = session.createCriteria(MasVacancyReason.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		cadreList =  session.createCriteria(MasCadre.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		gradeList =  session.createCriteria(MasGrade.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
/*		masQualificationList = session.createCriteria(MasQualification.class).add(Restrictions.eq("Status","y")).list();*/
	
		masManagerList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("FirstName")).list();
		
		masExperienceList = session.createCriteria(MasExperience.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		masInfrastructureRequirmentList = session.createCriteria(MasInfrastructureRequerment.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		designationList = session.createCriteria(MasRank.class).addOrder(Order.asc("RankName")).add(Restrictions.eq("Status","y").ignoreCase()).list(); 
		
		Criteria c = session.createCriteria(HrInstitutionalSanctionedPost.class);
				//.add(Restrictions.eq("Institution.Id", hospitalId))
					//.add(Restrictions.eq("Status", "y").ignoreCase());
		if(instituteId != 0){
			c= c.add(Restrictions.eq("Institution.Id", instituteId));
		}
		if(departmentId != 0){
			c= c.add(Restrictions.eq("Department.Id", departmentId));
		}
		if(designationId != 0){
			c= c.add(Restrictions.eq("Rank.Id", designationId));
		}
		if(cadreId != 0){
			c= c.add(Restrictions.eq("Cadre.Id", cadreId));
		}
		sanctionPostInstituteMasterList= c.list();
		
		String qry="select count(rank_id),rank_id from mas_employee group by rank_id having rank_id is not null";
		List rankListFromEmp=session.createSQLQuery(qry).list();
		

		map.put("designationList", designationList);
		map.put("institutionList", institutionList);
		map.put("masEmployeeTypeList", masEmployeeTypeList);
		map.put("masEmployeeDepartmentList", masEmployeeDepartmentList);
		map.put("masLocationList", masLocationList);
		map.put("masVacancyReasonList", masVacancyReasonList);
		map.put("masQualificationList", masQualificationList);
		map.put("masManagerList", masManagerList);
		map.put("masExperienceList", masExperienceList);
		map.put("masInfrastructureRequirmentList", masInfrastructureRequirmentList);
		map.put("hospitalId", hospitalId);
		//map.put("masRank", masRank);
		map.put("masRank1", masRank1);
		map.put("rankListFromEmp", rankListFromEmp);
		map.put("cadreList", cadreList);
		map.put("gradeList", gradeList);
		map.put("sanctionPostInstituteMasterList", sanctionPostInstituteMasterList);
		return map;
	}

	public Map<String, Object> saveResourceRequisitionDetail(
			ResourceRequisition resourceRequisition) {
		Map<String, Object> map = new HashMap<String, Object>();

		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			if (resourceRequisition != null) {
				hbt.saveOrUpdate(resourceRequisition);
				hbt.flush();
				hbt.refresh(resourceRequisition);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		successfullyAdded = true;
		String message = "";
		if (successfullyAdded) {
			message = "Record saved sucessfully";
		} else {
			message = "Some Problem Occured!";

		}
		map.put("flag", successfullyAdded);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> updateResourceRequisitionDetail(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<ResourceRequisition> resourceRequisitionList = new ArrayList<ResourceRequisition>();

		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShift> masShiftList = new ArrayList<HrMasShift>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int requisitionId = 0;
		if (parameterMap.get("requisitionId") != null) {
			requisitionId = (Integer) parameterMap.get("requisitionId");
		}

		ResourceRequisition resourceRequisition = (ResourceRequisition) hbt
				.load(ResourceRequisition.class, requisitionId);

		int employeeTypeId = 0;
		if (parameterMap.get("masEmployeeType") != null) {
			employeeTypeId = (Integer) parameterMap.get("employeeTypeId");
			MasEmployeeType masEmployeeType = new MasEmployeeType();
			masEmployeeType.setId(employeeTypeId);
			resourceRequisition.setEmployeeType(masEmployeeType);
		}

		// compeleted upto above
		int departmentId = 0;
		if (parameterMap.get("departmentId") != null) {
			departmentId = (Integer) parameterMap.get("departmentId");
			MasEmployeeDepartment masDepartment = new MasEmployeeDepartment();
			masDepartment.setId(departmentId);
			resourceRequisition.setDepartment(masDepartment);
		}
		int locationId = 0;
		if (parameterMap.get("locationId") != null) {
			locationId = (Integer) parameterMap.get("locationId");
			MasLocation masLocation = new MasLocation();
			masLocation.setId(locationId);
			resourceRequisition.setLocation(masLocation);
		}
		String proposedDesignation = "";
		if (parameterMap.get("proposedDesignation") != null) {
			proposedDesignation = (String) parameterMap
					.get("proposedDesignation");
		}
		resourceRequisition.setProposedDesignation(proposedDesignation);

		int vacancyReasonId = 0;
		if (parameterMap.get("vacancyReasonId") != null) {
			vacancyReasonId = (Integer) parameterMap.get("vacancyReasonId");
			MasVacancyReason masVacancyReason = new MasVacancyReason();
			masVacancyReason.setId(vacancyReasonId);
			resourceRequisition.setVacancyReason(masVacancyReason);
		}

		int reportingManagerEmpId = 0;
		if (parameterMap.get("reportingManagerEmpId") != null) {
			reportingManagerEmpId = (Integer) parameterMap
					.get("reportingManagerEmpId");
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(reportingManagerEmpId);
			resourceRequisition.setRepManager(masEmployee);
		}

		int totalNoPosition = 0;
		if (parameterMap.get("totalNoPosition") != null) {
			totalNoPosition = (Integer) parameterMap.get("totalNoPosition");
			resourceRequisition.setTotalNoPosition(totalNoPosition);
		}

		int qualificationId = 0;
		if (parameterMap.get("qualificationId") != null) {
			qualificationId = (Integer) parameterMap.get("qualificationId");
			MasQualification masQualification = new MasQualification();
			masQualification.setId(qualificationId);
			resourceRequisition.setQualification(masQualification);
		}

		int desirableQlfId = 0;
		if (parameterMap.get("desirableQlfId") != null) {
			desirableQlfId = (Integer) parameterMap.get("desirableQlfId");
			MasQualification masQualification = new MasQualification();
			masQualification.setId(desirableQlfId);
			resourceRequisition.setDesirableQlf(masQualification);
		}

		Integer expLowerRange = null;
		if (parameterMap.get(EXP_LOWER_RANGE) != null) {
			expLowerRange = (Integer) parameterMap.get(EXP_LOWER_RANGE);
			resourceRequisition.setExpLowerRange(expLowerRange);
		}

		Integer expUpperRange = null;
		if (parameterMap.get(EXP_UPPER_RANGE) != null) {
			expUpperRange = (Integer) parameterMap.get(EXP_UPPER_RANGE);
			resourceRequisition.setExpUpperRange(expUpperRange);
		}

		int ageLimit = 0;
		if (parameterMap.get("ageLimit") != null) {
			ageLimit = (Integer) parameterMap.get("ageLimit");
			resourceRequisition.setAgeLimit(ageLimit);
		}

		String positionPurpose = "";
		if (parameterMap.get("positionPurpose") != null) {
			positionPurpose = (String) parameterMap.get("positionPurpose");
		}
		resourceRequisition.setPositionPurpose(positionPurpose);

		String jobDescription = "";
		if (parameterMap.get("jobDescription") != null) {
			jobDescription = (String) parameterMap.get("jobDescription");
		}
		resourceRequisition.setJobDesc(jobDescription);

		String requiredSkill = "";
		if (parameterMap.get("requiredSkill") != null) {
			requiredSkill = (String) parameterMap.get("requiredSkill");
		}
		resourceRequisition.setRequiredSkill(requiredSkill);

		String infrastRequirment = "";
		if (parameterMap.get("infrastRequirment") != null) {
			infrastRequirment = (String) parameterMap.get("infrastRequirment");

			resourceRequisition.setInfrastRequirment(infrastRequirment);
		}
		if (parameterMap.get("salaryLowerRange") != null) {
			int salaryLowerRange = (Integer) parameterMap
					.get("salaryLowerRange");
			resourceRequisition.setSalaryLowerRange(salaryLowerRange);
		}
		if (parameterMap.get("salaryUpperRange") != null) {
			int salaryUpperRange = (Integer) parameterMap
					.get("salaryUpperRange");
			resourceRequisition.setSalaryUpperRange(salaryUpperRange);
		}

		String lastchangeBy = "";
		if (parameterMap.get("lastchangeBy") != null) {
			lastchangeBy = (String) parameterMap.get("lastchangeBy");
		}
		resourceRequisition.setLastChgBy(lastchangeBy);

		Date changedDate = null;
		if (parameterMap.get("changedDate") != null) {
			changedDate = (Date) parameterMap.get("changedDate");
		}
		resourceRequisition.setLastChgDate(changedDate);

		String changedTime = "";
		if (parameterMap.get("changedTime") != null) {
			changedTime = (String) parameterMap.get("changedTime");
		}
		resourceRequisition.setLastChgTime(changedTime);
		boolean flag = false;
		hbt.update(resourceRequisition);
		hbt.refresh(resourceRequisition);
		flag = true;
		String message = "";
		if (flag) {
			message = " Record Updated Successfully.";

		} else {
			message = "Some problem Occured! Try Again.";
		}
		Integer hospitalId = 0;
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		detailsMap.put("hospitalId", hospitalId);
		//map = showResourceReqJsp(hospitalId);
		map = showResourceReqJsp(detailsMap);
		map.put("flag", flag);
		map.put("message", message);
		map.put("resourceRequisition", resourceRequisition);
		return map;
	}

	public Map<String, Object> searchResourceRequests(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ResourceRequisition> resourceRequisition = new ArrayList<ResourceRequisition>();

		Date fromDate = null;
		Date toDate = null;

		Session session = (Session) getSession();

		int reqAddByEmpId = 0;
		if (parameterMap.get("reqAddByEmpId") != null) {
			reqAddByEmpId = (Integer) parameterMap.get("reqAddByEmpId");
		}
		int hospitalId = 0;
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("fromDate") != null) {
			fromDate = (Date) parameterMap.get("fromDate");
		}
		if (parameterMap.get("toDate") != null) {
			toDate = (Date) parameterMap.get("toDate");
		}

		if (fromDate != null && toDate == null) {
			toDate = new Date();
		}
		if (toDate != null && fromDate == null) {
			fromDate = new Date();
		}

		try {
			Criteria crit = session.createCriteria(ResourceRequisition.class);

			if (fromDate != null && toDate != null) {
				crit = crit.add(Restrictions.between("RequisitionDate",
						fromDate, toDate));
			}
			if (hospitalId != 0) {
				crit = crit.add(Restrictions.eq("Company.Id", hospitalId));
			}
			// if(reqAddByEmpId != 0){
			// );
			// crit = crit.add(Restrictions.eq("ReqAddBy.Id", reqAddByEmpId));
			// );
			// }
			crit = crit.add(Restrictions.eq("Status", "y"));
			crit = crit.createAlias("HrResourceRequisitionStatus", "ReqStatus");
			crit = crit.addOrder(Order.desc("ReqStatus.ActionDate"));
			resourceRequisition = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("resourceRequisitionList", resourceRequisition);
		return map;
	}

	public Map getRequistionListForUser(Map map) {

		List resourceRequisitionList = null;
		Session session = getSession();
		Users users = null;
		Integer userId = null;
		Integer hospitalId = null;
		Date fromDate = null;
		Date toDate = null;
		if (map.get("user") != null) {
			users = (Users) map.get("user");
			userId = users.getId();
		}
		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");
		}
		if (map.get("fromDate") != null) {
			fromDate = (Date) map.get("fromDate");
		}
		if (map.get("toDate") != null) {
			toDate = (Date) map.get("toDate");
		}

		if (fromDate != null && toDate == null) {
			toDate = new Date();
		}
		if (toDate != null && fromDate == null) {
			fromDate = new Date();

		}
		Criteria criteria = session.createCriteria(HrMasApplicationLevel.class);
		String recuitmentApplicationId = HMSUtil.getValuesFromPropertiesFile(
				"recruitmentFile.properties", "MasApplication.Id");

		criteria = criteria.add(Restrictions.eq("Application.Id",
				recuitmentApplicationId));

		List applicationLevelList = criteria.list();
		if (applicationLevelList != null && applicationLevelList.size() > 0) {
			HrMasApplicationLevel applicationLevel = (HrMasApplicationLevel) applicationLevelList
					.get(0);
			MasRank intermediateApproverDesignation = applicationLevel
					.getIntermediateApproverDesignation();
			MasRank finalApproverDesignation = applicationLevel
					.getFinalApproverDesignation();

			try {
				Criteria crit = session
						.createCriteria(ResourceRequisition.class);

				// If user is Rep Manager
				if (!users.getEmployee().getRank().getId()
						.equals(intermediateApproverDesignation.getId())
						&& !users.getEmployee().getRank().getId()
								.equals(finalApproverDesignation.getId())) {
					if (userId != 0) {
						crit = crit.add(Restrictions.eq("ApprovingManager.Id",
								users.getEmployee().getId()));
					}
				}

				if (hospitalId != 0) {
					crit = crit.add(Restrictions.eq("Company.Id", hospitalId));
				}
				if (fromDate != null && toDate != null) {
					crit = crit.add(Restrictions.between("RequisitionDate",
							fromDate, toDate));
				}
				crit = crit.add(Restrictions.eq("Status", "y"));
				String approvedLevel = HMSUtil.getValuesFromPropertiesFile(
						"recruitmentFile.properties",
						"hrResourceRequisitionStatus.CurrentLevel");

				crit = crit.createAlias("HrResourceRequisitionStatus",
						"RequisitionStatus").add(
						Restrictions.ne("RequisitionStatus.CurrentLevel",
								new Integer(approvedLevel)));

				// //check if user is HR Head ..
				// if(users.getEmployee().getRank().getId().equals(intermediateApproverDesignation.getId())){
				// crit = crit.add(Restrictions.isNotNull("MarketCtc"));
				// }
				// else
				// {
				//
				// }
				// crit = crit.createCriteria("HrResourceRequisitionStatus");
				//
				// Criteria tempCriteria = null;
				// if(users.getEmployee().getRank().getId().equals(finalApproverDesignation.getId())){
				//
				// crit = crit.add(Restrictions.eq("CurrentLevel", 2));
				//
				// }
				// else
				// if(users.getEmployee().getRank().getId().equals(intermediateApproverDesignation.getId())){
				// crit = crit.add(Restrictions.eq("CurrentLevel", 1));
				// }
				// else
				// {
				// crit = crit.add(Restrictions.eq("CurrentLevel", 0));
				// }
				//
				// crit = crit.createAlias("RequestStatusMaster", "RSM");
				//
				// tempCriteria = crit;
				// if(users.getEmployee().getRank().getId().equals(intermediateApproverDesignation.getId())
				// ){
				//
				// Object[] a = {new Integer(2),new Integer(5),new Integer(7)};
				// crit = crit.add(Restrictions.in("RSM.Id", a));
				// }
				// else if(
				// users.getEmployee().getRank().getId().equals(finalApproverDesignation.getId()))
				// {
				// Object[] a = {new Integer(2),new Integer(3),new Integer(7)};
				// crit = crit.add(Restrictions.in("RSM.Id",a));
				// }
				// else
				// {
				// Object[] a = {new Integer(1),new Integer(3),new Integer(7)};
				// crit = crit.add(Restrictions.in("RSM.Id",a));
				// }

				resourceRequisitionList = crit.list();
				// List requListForView = tempCriteria.list();
				map.put("resourceRequisitionList", resourceRequisitionList);
				// map.put("requListForView", requListForView);
				if (resourceRequisitionList != null
						&& resourceRequisitionList.size() == 0) {
					map.put("message", "Record does not exist");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public Map<String, Object> showResourceDetailForUpdate(int hospitalId,
			int requisitionId) {
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();

		List<MasEmployeeType> masEmployeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasLocation> masLocationList = new ArrayList<MasLocation>();
		List<MasVacancyReason> masVacancyReasonList = new ArrayList<MasVacancyReason>();
		List<MasQualification> masQualificationList = new ArrayList<MasQualification>();
		List<MasEmployee> masManagerList = new ArrayList<MasEmployee>();
		List<MasExperience> masExperienceList = new ArrayList<MasExperience>();
		List<MasInfrastructureRequerment> masInfrastructureRequirmentList = new ArrayList<MasInfrastructureRequerment>();
		List<ResourceRequisition> resourceRequisitionList = new ArrayList<ResourceRequisition>();

		masEmployeeTypeList = session.createCriteria(MasEmployeeType.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masEmployeeTypeList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasEmployeeType where ");

		masDepartmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y")).list();
		// masDepartmentList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasDepartment");

		masLocationList = session.createCriteria(MasLocation.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masLocationList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasLocation");

		masVacancyReasonList = session.createCriteria(MasVacancyReason.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masVacancyReasonList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasVacancyReason");

		masQualificationList = session.createCriteria(MasQualification.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		// masQualificationList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasQualification");

		masManagerList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masManagerList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasEmployee");

		masExperienceList = session.createCriteria(MasExperience.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masExperienceList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasExperience");

		masInfrastructureRequirmentList = session
				.createCriteria(MasInfrastructureRequerment.class)
				.add(Restrictions.eq("Company.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		// masInfrastructureRequirmentList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.MasInfrastructureRequerment");

		resourceRequisitionList = session
				.createCriteria(ResourceRequisition.class)
				.add(Restrictions.eq("Id", requisitionId))
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Company.Id", hospitalId)).list();


		map.put("masEmployeeTypeList", masEmployeeTypeList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masLocationList", masLocationList);
		map.put("masVacancyReasonList", masVacancyReasonList);
		map.put("masQualificationList", masQualificationList);
		map.put("masManagerList", masManagerList);
		map.put("masExperienceList", masExperienceList);
		map.put("masInfrastructureRequirmentList",
				masInfrastructureRequirmentList);
		map.put("resourceRequisitionList", resourceRequisitionList);
		map.put("hospitalId", hospitalId);

		return map;
	}

	public List getRequestStatusMasterList() {
		Session session = getSession();
		Criteria crit = session.createCriteria(RequestStatusMaster.class);
		crit = crit.add(Restrictions.ne("Id", 1)).add(Restrictions.ne("Id", 5))
				.add(Restrictions.ne("Id", 7));
		List list = crit.list();
		return list;
	}

	public List<ResourceRequisition> updateRequisitionStatus(
			List<ResourceRequisition> list) {
		getHibernateTemplate().saveOrUpdateAll(list);
		return list;
	}

	public RequestStatusMaster getRequestStatusMasterById(
			Integer requestStatusId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(RequestStatusMaster.class);
		crit = crit.add(Restrictions.eq("Id", requestStatusId));
		List<RequestStatusMaster> list = crit.list();
		RequestStatusMaster requestStatusMaster = list.get(0);
		return requestStatusMaster;
	}

	public List getAllApprovedRequests() {
		Session session = getSession();
		Criteria crit = session.createCriteria(ResourceRequisition.class);
		String approvedLevel = HMSUtil.getValuesFromPropertiesFile(
				"recruitmentFile.properties",
				"hrResourceRequisitionStatus.CurrentLevel");
		String approvedStatusId = HMSUtil
				.getValuesFromPropertiesFile("recruitmentFile.properties",
						"RequestStatusMaster.approved.Id");
		crit = crit.add(Restrictions.ltProperty("NoOfPositionOccupied",
				"TotalNoPosition"));

		crit = crit.createAlias("HrResourceRequisitionStatus", "reqStatus")

		.add(Restrictions.eq("reqStatus.CurrentLevel", new Integer(
				approvedLevel)));
		crit = crit.createAlias("reqStatus.RequestStatusMaster", "RMS")

		.add(Restrictions.eq("RMS.Id", new Integer(approvedStatusId)));
		// crit = crit.add(Restrictions.gt("NoOfPositionOccupied", 0));
		List list = crit.list();
		return list;
	}

	public void saveOrUpdateResourceRequisitionStatus(
			HrResourceRequisitionStatus hrResourceRequisitionStatus) {
		getHibernateTemplate().saveOrUpdate(hrResourceRequisitionStatus);
		getHibernateTemplate().flush();
		getHibernateTemplate().refresh(hrResourceRequisitionStatus);
	}

	public Map getRequistionListForMarketCTCAnalysis(Map map) {
		List<ResourceRequisition> resourceRequisitionList = null;
		Session session = getSession();
		Integer userId = null;
		Integer hospitalId = null;
		Date fromDate = null;
		Date toDate = null;

		if (map.get("userId") != null) {
			userId = (Integer) map.get("userId");
		}
		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");
		}
		if (map.get("fromDate") != null) {
			fromDate = (Date) map.get("fromDate");
		}
		if (map.get("toDate") != null) {
			toDate = (Date) map.get("toDate");
		}

		if (fromDate != null && toDate == null) {
			toDate = new Date();
		}
		if (toDate != null && fromDate == null) {
			fromDate = new Date();

		}
		Criteria criteria = session.createCriteria(HrMasApplicationLevel.class);
		criteria = criteria.add(Restrictions.eq("Application.Id", "A1"));

		List applicationLevelList = criteria.list();
		HrMasApplicationLevel applicationLevel = (HrMasApplicationLevel) applicationLevelList
				.get(0);
		MasRank intermediateApproverDesignation = applicationLevel
				.getIntermediateApproverDesignation();
		MasRank finalApproverDesignation = applicationLevel
				.getFinalApproverDesignation();
		try {
			Criteria crit = session.createCriteria(ResourceRequisition.class);

			if (hospitalId != 0) {
				crit = crit.add(Restrictions.eq("Company.Id", hospitalId));
			}
			if (fromDate != null && toDate != null) {
				crit = crit.add(Restrictions.between("RequisitionDate",
						fromDate, toDate));
			}
			crit = crit.add(Restrictions.eq("Status", "y"));

			Criteria criteriaForIntermediateApproverAsApprovingManager = crit;

			crit = crit.createCriteria("HrResourceRequisitionStatus");

			crit = crit.add(Restrictions.eq("CurrentLevel", 1));
			crit = crit.createAlias("RequestStatusMaster", "RSM");
			crit = crit.add(Restrictions.eq("RSM.Id", 2));

			resourceRequisitionList = crit.list();

			/*
			 * //add requests launched directly to HrHead as approving manager
			 * criteriaForIntermediateApproverAsApprovingManager =
			 * criteriaForIntermediateApproverAsApprovingManager
			 * .add(Restrictions.eq("ApprovingManager.Rank.Id",
			 * intermediateApproverDesignation.getId()));
			 * criteriaForIntermediateApproverAsApprovingManager =
			 * criteriaForIntermediateApproverAsApprovingManager
			 * .createCriteria("HrResourceRequisitionStatus");
			 * criteriaForIntermediateApproverAsApprovingManager =
			 * criteriaForIntermediateApproverAsApprovingManager
			 * .add(Restrictions.eq("CurrentLevel", 0));
			 * List<ResourceRequisition> listLaunchedforHrHead =
			 * criteriaForIntermediateApproverAsApprovingManager.list();
			 * 
			 * resourceRequisitionList.addAll(listLaunchedforHrHead);
			 */
			map.put("resourceRequisitionList", resourceRequisitionList);
			if (resourceRequisitionList != null
					&& resourceRequisitionList.size() == 0) {
				map.put("message", "Record does not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public void saveOrUpdateRequisitionHistory(
			HrRequisitionHistory requisitionHistory) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(requisitionHistory);
	}

	public List<ResourceRequisition> addDepartmentTotalCTC(
			List<ResourceRequisition> resourceRequisitionList) {

		for (ResourceRequisition resourceRequisition : resourceRequisitionList) {
			List<MasEmployee> list = new ArrayList();
			Float totalDepartmentCTC = 0f;
			Criteria criteria = getSession().createCriteria(MasEmployee.class);
			criteria = criteria.add(Restrictions.eq("Department.Id",
					resourceRequisition.getDepartment().getId()));
			criteria = criteria.add(Restrictions.eq("Status", "y"));
			list = criteria.list();
			BigDecimal totalCTC = new BigDecimal(0);
			for (MasEmployee obj : list) {
				BigDecimal employeeBasic = new BigDecimal(0);
				Set<HrEmployeePayStructure> payStructureSet = obj
						.getPayStructure();
				for (HrEmployeePayStructure employeePayStructure : payStructureSet) {
					employeeBasic = employeeBasic.add(employeePayStructure
							.getBasicPay());
				}

				totalCTC = totalCTC.add(employeeBasic.multiply(new BigDecimal(
						1200 / 35)));

			}
			//resourceRequisition.setTotalDepartmentCTC(totalCTC.floatValue());
		}

		return resourceRequisitionList;

	}

	public Map loadObject(Class klass, Integer id) {
		Criteria criteria = getSession().createCriteria(
				HrMasApplicationLevel.class);
		String recuitmentApplicationId = HMSUtil.getValuesFromPropertiesFile(
				"recruitmentFile.properties", "MasApplication.Id");
		criteria = criteria.add(Restrictions.eq("Application.Id",
				recuitmentApplicationId));

		List applicationLevelList = criteria.list();
		HrMasApplicationLevel applicationLevel = (HrMasApplicationLevel) applicationLevelList
				.get(0);
		MasRank intermediateApproverDesignation = applicationLevel
				.getIntermediateApproverDesignation();
		MasRank finalApproverDesignation = applicationLevel
				.getFinalApproverDesignation();

		MasEmployee approvingManager = (MasEmployee) getHibernateTemplate()
				.load(klass, id);

		Map map = new HashMap();

		map.put("approvingManager", approvingManager);
		map.put("intermediateApproverDesignation",
				intermediateApproverDesignation);
		map.put("finalApproverDesignation", finalApproverDesignation);

		return map;

	}

	@Override
	public Map<String, Object> getEmployeeForPromo(Map<String, Object> detailMap) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		  List<MasEmployee> promoEmpList = new ArrayList<MasEmployee>();
			List<HrInstitutionalSanctionedPost> sanctionPostInstituteMasterList = new ArrayList<HrInstitutionalSanctionedPost>();
			List desigList = new ArrayList();
			Session session = (Session)getSession();
			int cadreId=0;
			int instituteId = 0;
			int departmentId = 0;
			int designationId = 0;
			int designation_order = 0;
			  
		  	if(detailMap.get("id")!= null){
		  		designation_order =Integer.parseInt(""+detailMap.get("id"));
		  	}
			if(detailMap.get("designationId")!= null && !detailMap.get("designationId").equals("")){
				designationId=(Integer)detailMap.get("designationId");
			}
			if(detailMap.get("departmentId")!= null && !detailMap.get("departmentId").equals("")){
				departmentId=(Integer)detailMap.get("departmentId");
			}
		
			
			if(detailMap.get("instituteId")!= null && !detailMap.get("instituteId").equals("")){
				instituteId=(Integer)detailMap.get("instituteId");
			}
			if(detailMap.get("cadreId")!= null && !detailMap.get("cadreId").equals("")){
				cadreId=(Integer)detailMap.get("cadreId");
			}
			System.out.println("designation_order==="+designation_order);
		
		/*  Criteria criteria = getSession().createCriteria(ResourceRequisition.class).add(Restrictions.eq("Id", Integer.parseInt(id)));
		  List<ResourceRequisition> resorceReqList = criteria.list();
		  int designation_order =resorceReqList.get(0).getDesignation().getDesignationOrder();*/
		  
		  
		 // System.out.println(">designation_order>>>>"+designation_order);
		  LogicalExpression exp =  Restrictions.or(Restrictions.eq("DesignationOrder", (designation_order-1)), Restrictions.eq("DesignationOrder", (designation_order-2)));
		  List al = new ArrayList();
		  
		  al.add((designation_order+1)); 
		 // al.add((designation_order+2)); 
		 // al.add((designation_order+3));

		 System.out.println("al=="+al.size());
		  desigList = getSession().createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).add(Restrictions.in("DesignationOrder",al))
				  					.setProjection(Projections.projectionList().add(Projections.groupProperty("Id"))).list();
		 
		  System.out.println("desigList==="+desigList);
		  List<Integer> rankList = new ArrayList<Integer>();
		  if(desigList.size()>0){
			  
			  promoEmpList = getSession().createCriteria(MasEmployee.class).add(Restrictions.in("Rank.Id", desigList)).list();
		  }
		 System.out.println(desigList.size()+">promoEmpList>>>>"+promoEmpList.size());
		  
		  Criteria c = session.createCriteria(HrInstitutionalSanctionedPost.class);
					//.add(Restrictions.eq("Institution.Id", hospitalId))
						//.add(Restrictions.eq("Status", "y").ignoreCase());
			if(instituteId != 0){
				c= c.add(Restrictions.eq("Institution.Id", instituteId));
			}
			if(departmentId != 0){
				c= c.add(Restrictions.eq("Department.Id", departmentId));
			}
			if(designationId != 0){
				c= c.add(Restrictions.eq("Rank.Id", designationId));
			}
			if(cadreId != 0){
				c= c.add(Restrictions.eq("Cadre.Id", cadreId));
			}
			sanctionPostInstituteMasterList= c.list();
			System.out.println("sanctionPostInstituteMasterList==dsssssssss=="+sanctionPostInstituteMasterList.size());	
		 
		 // return promoEmpList;
		  map1.put("designation_order", designation_order);
		  map1.put("promoEmpList", promoEmpList);
		  map.put("sanctionPostInstituteMasterList", sanctionPostInstituteMasterList);
		  return  map1;
	}
	public Map<String, Object> showPostJsp(Map  detailMap){
		Map<String, Object> map = new HashMap<String, Object>();
		
		Session session = (Session)getSession();
		int hospitalId=0;
		int rankId=0;
		if(detailMap.get("hospitalId") != null){
			hospitalId =(Integer)detailMap.get("hospitalId");
		}
		if(detailMap.get("rankId") != null){
			rankId =(Integer)detailMap.get("rankId");
		}
		
		List<MasHospital> masHospital = new ArrayList<MasHospital>();
		List<MasRank> masRank = new ArrayList<MasRank>();
		
		/*List<MasEmployeeType> masEmployeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasLocation> masLocationList = new ArrayList<MasLocation>();
		List<MasVacancyReason> masVacancyReasonList = new ArrayList<MasVacancyReason>();
		List<MasQualification> masQualificationList = new ArrayList<MasQualification>();
		List<MasEmployee> masManagerList = new ArrayList<MasEmployee>();
		List<MasExperience> masExperienceList = new ArrayList<MasExperience>();
		List<MasInfrastructureRequerment> masInfrastructureRequirmentList = new ArrayList<MasInfrastructureRequerment>();
		
		masEmployeeTypeList = session.createCriteria(MasEmployeeType.class).add(Restrictions.eq("Status","y")).list();
		masDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y")).list();
		
		masLocationList = session.createCriteria(MasLocation.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y")).list();
		
		masVacancyReasonList = session.createCriteria(MasVacancyReason.class).add(Restrictions.eq("Status","y")).list();
		
		masQualificationList = session.createCriteria(MasQualification.class).add(Restrictions.eq("Status","y")).list();
	
		masManagerList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).list();
	
		masExperienceList = session.createCriteria(MasExperience.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y")).list();
	
		masInfrastructureRequirmentList = session.createCriteria(MasInfrastructureRequerment.class).add(Restrictions.eq("Company.Id",hospitalId)).add(Restrictions.eq("Status","y")).list();*/
		
		masRank =session.createCriteria(MasRank.class)./*add(Restrictions.eq("Company.Id",hospitalId)).*/add(Restrictions.eq("Status","y")).list(); 
		System.out.println("===Before Querry==");
		
		String qry="select count(rank_id),rank_id,hospital_id from mas_employee where rank_Id="+rankId+" group by hospital_id,rank_id having rank_id is not null";
		
		
		List rankListFromEmp=session.createSQLQuery(qry).list();
		
		masHospital = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y")).list();
		System.out.println(rankListFromEmp.size());
	/*	map.put("masEmployeeTypeList", masEmployeeTypeList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masLocationList", masLocationList);
		map.put("masVacancyReasonList", masVacancyReasonList);
		map.put("masQualificationList", masQualificationList);
		map.put("masManagerList", masManagerList);
		map.put("masExperienceList", masExperienceList);
		map.put("masInfrastructureRequirmentList", masInfrastructureRequirmentList);*/
		map.put("hospitalId", hospitalId);
		map.put("masRank", masRank);
		map.put("rankListFromEmp", rankListFromEmp);
		map.put("masHospital", masHospital);
		return map;
	}
	

	
}
