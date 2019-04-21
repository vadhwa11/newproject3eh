package jkt.hms.masters.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.Department;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.HrEmployeeAddress;
import jkt.hms.masters.business.HrEmployeeExitInterview;
import jkt.hms.masters.business.HrEmployeePerformanceReview;
import jkt.hms.masters.business.HrExitInterviewAnswers;
import jkt.hms.masters.business.HrInstEmpDept;
import jkt.hms.masters.business.HrPerformanceReviewRatings;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasCadre;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasCategory;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasEmployeeTemp;
import jkt.hms.masters.business.MasFormation;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasIdCard;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasLsgType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasReferralDoctor;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasStream;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasVisaType;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.MasWing;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasLocalityType;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.UserUsergroupApplication;
import jkt.hms.masters.business.UsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.EmployeeEducationComparator;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrAccruelRecord;
import jkt.hrms.masters.business.HrEmployeeBalanceNew;
import jkt.hrms.masters.business.HrEmployeeExperience;
import jkt.hrms.masters.business.HrEmployeePayElements;
import jkt.hrms.masters.business.HrEmployeePayStructure;
import jkt.hrms.masters.business.HrEmployeePersonelDetails;
import jkt.hrms.masters.business.HrMasCourse;
import jkt.hrms.masters.business.HrMasEmployeeEducation;
import jkt.hrms.masters.business.HrMasInstitute;
import jkt.hrms.masters.business.HrMasLeaveTypeMediator;
import jkt.hrms.masters.business.HrMasPayElement;
import jkt.hrms.masters.business.HrMasPayroll;
import jkt.hrms.masters.business.HrMasQualification;
import jkt.hrms.masters.business.HrMasShiftCodes;
import jkt.hrms.masters.business.HrMasSpecialQualification;
import jkt.hrms.masters.business.HrPayrollProcessDetail;
import jkt.hrms.masters.business.MasEmployeeContract;
import jkt.hrms.masters.business.MasEmployeeType;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.MasShift;
import jkt.hrms.masters.business.UserManager;
import jkt.hrms.recruitment.masters.business.Resumeskillmaster;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PersonnelMasterDataServiceImpl extends HibernateDaoSupport
		implements PersonnelMasterDataService {

	// ---------------------------- Employee Dependent
	// -----------------------------
	public boolean addEmployeeDependent(
			MasEmployeeDependent masEmployeeDependent) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masEmployeeDependent);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteEmployeeDependent(int employeeDependentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasEmployeeDependent masEmployeeDependent = new MasEmployeeDependent();
			masEmployeeDependent = (MasEmployeeDependent) getHibernateTemplate()
					.load(MasEmployeeDependent.class, employeeDependentId);
			Integer employeecodeId = masEmployeeDependent.getEmployee().getId();
			Integer relationcodeId = masEmployeeDependent.getRelation().getId();

			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (masEmployeeDependent.getStatus().equals("y")) {
				@SuppressWarnings("unused")
				List employeecodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as employee where employee.Id='"
								+ employeecodeId + "' and employee.Status='y'");
				@SuppressWarnings("unused")
				List relationcodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRelation as relation where relation.Id='"
								+ relationcodeId + "' and relation.Status='y'");
				masEmployeeDependent.setStatus("n");
				dataDeleted = true;
			} else {
				masEmployeeDependent.setStatus("y");
				dataDeleted = false;
			}
			masEmployeeDependent.setLastChgDate(currentDate);
			masEmployeeDependent.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masEmployeeDependent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	@SuppressWarnings("unused")
	public boolean editEmployeeDependent(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int relationcodeId = 0;
		String employeeDependentName = "";
		String employeeDependentCode = "";
		Date dob = new Date();
		int employeeDependentGender = 0;
		String employeeDependentAddress = "";
		int employeeDependentcodeId = 0;
		int empNameId = 0;
		Integer changedBy = null;

		employeeDependentcodeId = (Integer) generalMap.get("id");
		empNameId = (Integer) generalMap.get("empNameId");
		relationcodeId = (Integer) generalMap.get("relationcodeId");
		employeeDependentName = (String) generalMap.get("name");
		employeeDependentCode = (String) generalMap
				.get("employeeDependentCode");
		if (generalMap.get("employeeDependentGender") != null) {
			employeeDependentGender = (Integer) generalMap
					.get("employeeDependentGender");
		}
		employeeDependentAddress = (String) generalMap
				.get("employeeDependentAddress");

		dob = (Date) generalMap.get("employeeDependentDOB");

		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasEmployeeDependent masEmployeeDependent = (MasEmployeeDependent) getHibernateTemplate()
				.load(MasEmployeeDependent.class, employeeDependentcodeId);

		masEmployeeDependent.setId(employeeDependentcodeId);
		if (empNameId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(empNameId);
			masEmployeeDependent.setEmployee(masEmployee);
		}
		masEmployeeDependent.setEmployeeDependentName(employeeDependentName);
		masEmployeeDependent.setEmployeeDependentCode(employeeDependentCode);
		masEmployeeDependent.setDateOfBirth(dob);

		if (employeeDependentGender != 0) {
			masEmployeeDependent.setGender(new MasAdministrativeSex(
					employeeDependentGender));
		}
		masEmployeeDependent.setAddress(employeeDependentAddress);

		MasRelation masRelation = new MasRelation();
		masRelation.setId(relationcodeId);
		masEmployeeDependent.setRelation(masRelation);
		if (changedBy != null) {
			masEmployeeDependent.setLastChgBy(new Users(changedBy));
		}
		masEmployeeDependent.setLastChgDate(currentDate);
		masEmployeeDependent.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmployeeDependent);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public Map<String, Object> searchEmployeeDependent(
			String employeeDependentCode, String employeeDependentName) {
		List<MasEmployeeDependent> searchEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		List hospitalCodeList = null;
		List employeeCodeList = null;
		List relationCodeList = null;
		Map<String, Object> employeeDependentFieldsMap = new HashMap<String, Object>();
		List<MasAdministrativeSex> gridAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		List gridHospitalList = null;
		List gridEmployeeList = null;
		List gridRelationList = null;
		Session session = (Session) getSession();
		try {
			if ((employeeDependentName != null)
					|| (employeeDependentCode == null)) {
				searchEmployeeDependentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasEmployeeDependent sc where lower(sc.EmployeeDependentName) like '"
								+ employeeDependentName.toLowerCase()
								+ "%' order by sc.EmployeeDependentName");
			} else {

				searchEmployeeDependentList = session
						.createCriteria(MasEmployeeDependent.class)
						.createAlias("Employee", "emp")
						.add(Restrictions
								.like("emp.PEN", employeeDependentCode)
								.ignoreCase()).addOrder(Order.asc("emp.PEN"))
						.list();

				/*
				 * searchEmployeeDependentList = getHibernateTemplate() .find(
				 * "from jkt.hms.masters.business.MasEmployeeDependent sc where lower(sc.EmployeeDependentCode) like '"
				 * + employeeDependentCode.toLowerCase() +
				 * "%' order by sc.EmployeeDependentCode");
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		hospitalCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc where mc.Status = 'y'");
		gridHospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasHospital as HospitalCode");
		employeeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");
		gridEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee as EmployeeCode");
		relationCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRelation as mc where mc.Status = 'y'");
		gridRelationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRelation as RelationCode");
		gridAdministrativeSexList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasAdministrativeSex where Status='y'");
		employeeDependentFieldsMap.put("gridHospitalList", gridHospitalList);
		employeeDependentFieldsMap.put("gridEmployeeList", gridEmployeeList);
		employeeDependentFieldsMap.put("gridRelationList", gridRelationList);
		employeeDependentFieldsMap.put("searchEmployeeDependentList",
				searchEmployeeDependentList);
		employeeDependentFieldsMap.put("hospitalCodeList", hospitalCodeList);
		employeeDependentFieldsMap.put("employeeCodeList", employeeCodeList);
		employeeDependentFieldsMap.put("relationCodeList", relationCodeList);
		employeeDependentFieldsMap.put("gridAdministrativeSexList",
				gridAdministrativeSexList);
		return employeeDependentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmployeeDependentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<MasEmployeeDependent> searchEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
			//List<MasHospital> hospitalCodeList = new ArrayList<MasHospital>();
			//List<MasHospital> gridHospitalList = new ArrayList<MasHospital>();
			//List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
			//List<MasEmployee> gridEmployeeList = new ArrayList<MasEmployee>();
			//List<MasRelation> relationCodeList = new ArrayList<MasRelation>();
			//List<MasRelation> gridRelationList = new ArrayList<MasRelation>();
			List<MasAdministrativeSex> gridAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
			List<HrMasQualification> qualificationList = new ArrayList<HrMasQualification>();
			List<HrMasCourse> coursesList = new ArrayList<HrMasCourse>();
		//	List<HrMasSpecialQualification> splQualificationList = new ArrayList<HrMasSpecialQualification>();
			//List<HrMasInstitute> institutesList = new ArrayList<HrMasInstitute>();
			//List<Resumeskillmaster> skillMasterList = new ArrayList<Resumeskillmaster>();
			//List<MasCountry> countryList = new ArrayList<MasCountry>();

			searchEmployeeDependentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployeeDependent");

			/*gridHospitalList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasHospital as id where UPPER(id.Status)='Y'");*/
			/*hospitalCodeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasHospital as mc where UPPER(mc.Status) = 'Y'");*/
			/*gridEmployeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee as id");*/
			/*employeeCodeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasEmployee as mc where UPPER(mc.Status) = 'Y' order by FirstName ");*/
			/*gridRelationList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRelation as id");*/
			/*relationCodeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasRelation as mc where  UPPER(mc.Status) = 'Y' order by RelationName ");*/
			qualificationList = getHibernateTemplate()
					.find("from jkt.hrms.masters.business.HrMasQualification as mq where  UPPER(mq.Status) = 'Y'");
			coursesList = getHibernateTemplate()
					.find("from jkt.hrms.masters.business.HrMasCourse as mc where  UPPER(mc.Status) = 'Y'");
			/*splQualificationList = getHibernateTemplate()
					.find("from jkt.hrms.masters.business.HrMasSpecialQualification as mc where mc.Status = 'Y'");*/
			/*institutesList = getHibernateTemplate()
					.find("from jkt.hrms.masters.business.HrMasInstitute as mc where mc.Status = 'Y'");*/
			/*skillMasterList = getHibernateTemplate()
					.find("from jkt.hrms.recruitment.masters.business.Resumeskillmaster");*/
			/*countryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasCountry");*/
			map.put("searchEmployeeDependentList", searchEmployeeDependentList);
			gridAdministrativeSexList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasAdministrativeSex mc where  UPPER(mc.Status)='Y'");
			/*map.put("hospitalCodeList", hospitalCodeList);
			map.put("gridHospitalList", gridHospitalList);
			map.put("employeeCodeList", employeeCodeList);
			map.put("gridEmployeeList", gridEmployeeList);
			map.put("relationCodeList", relationCodeList);
			map.put("gridRelationList", gridRelationList);*/
			//map.put("skillMasterList", skillMasterList);
			map.put("gridAdministrativeSexList", gridAdministrativeSexList);
			map.put("qualificationList", qualificationList);
			map.put("coursesList", coursesList);
			//map.put("splQualificationList", splQualificationList);
			//map.put("institutesList", institutesList);
		//	map.put("countryList", countryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// -------------------------------------- Emp Status
	// ----------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmpStatus(String empStatusCode,
			String empStatusName) {
		List<MasEmpStatus> searchEmpStatusList = new ArrayList<MasEmpStatus>();
		Map<String, Object> empStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((empStatusName != null) || (empStatusCode == null)) {
				searchEmpStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasEmpStatus es where lower(es.EmpStatusName) like '"
								+ empStatusName.toLowerCase()
								+ "%' order by es.EmpStatusName");
			} else {
				searchEmpStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasEmpStatus es where lower(es.EmpStatusCode) like '"
								+ empStatusCode.toLowerCase()
								+ "%' order by es.EmpStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		empStatusFieldsMap.put("searchEmpStatusList", searchEmpStatusList);
		return empStatusFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmpStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpStatus> searchEmpStatusList = new ArrayList<MasEmpStatus>();
		searchEmpStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmpStatus ");
		map.put("searchEmpStatusList", searchEmpStatusList);
		return map;
	}

	public boolean addEmpStatus(MasEmpStatus masEmpStatus) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masEmpStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editEmpStatusToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String empStatusName = "";
		@SuppressWarnings("unused")
		String empStatusCode = "";
		int empStatusId = 0;
		empStatusId = (Integer) generalMap.get("id");
		empStatusCode = (String) generalMap.get("empStatusCode");
		empStatusName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasEmpStatus masEmpStatus = (MasEmpStatus) getHibernateTemplate().load(
				MasEmpStatus.class, empStatusId);
		masEmpStatus.setId(empStatusId);
		masEmpStatus.setEmpStatusName(empStatusName);
		masEmpStatus.setLastChgDate(currentDate);
		masEmpStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmpStatus);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean deleteEmpStatus(int empStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasEmpStatus masEmpStatus = new MasEmpStatus();
		masEmpStatus = (MasEmpStatus) getHibernateTemplate().load(
				MasEmpStatus.class, empStatusId);

		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masEmpStatus.getStatus().equals("y")) {
			masEmpStatus.setStatus("n");
			dataDeleted = true;
		} else {
			masEmpStatus.setStatus("y");
			dataDeleted = false;
		}

		masEmpStatus.setLastChgDate(currentDate);
		masEmpStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmpStatus);
		return dataDeleted;
	}

	// ------------------------------------------ Referral Doctor
	// --------------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showReferralDoctorJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasReferralDoctor> searchReferralDoctorList = new ArrayList<MasReferralDoctor>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		searchReferralDoctorList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasReferralDoctor ");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where UPPER(isc.Status) = 'Y'");
		map.put("searchReferralDoctorList", searchReferralDoctorList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("departmentList", departmentList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchReferralDoctor(String referralDoctorName) {
		List<MasReferralDoctor> searchReferralDoctorList = new ArrayList<MasReferralDoctor>();
		List<MasDepartment> departmentList = null;
		Map<String, Object> referralDoctorMap = new HashMap<String, Object>();
		List<MasDepartment> gridDepartmentList = null;
		Session session = (Session) getSession();
		try {
			if (referralDoctorName != null) {
				searchReferralDoctorList = session
						.createCriteria(MasReferralDoctor.class)
						.add(Restrictions
								.like("DoctorName", referralDoctorName))
						.addOrder(Order.asc("DoctorName")).list();
				// getHibernateTemplate().find("from jkt.hms.masters.business.MasReferralDoctor mrd where mrd.DoctorName like '"+
				// referralDoctorName + "%' order by mrd.DoctorName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();// getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		gridDepartmentList = session.createCriteria(MasDepartment.class).list();// getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment as md");
		referralDoctorMap.put("searchReferralDoctorList",
				searchReferralDoctorList);
		referralDoctorMap.put("departmentList", departmentList);
		referralDoctorMap.put("gridDepartmentList", gridDepartmentList);

		return referralDoctorMap;
	}

	public boolean editReferralDoctorToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int departmentId = 0;
		String referralDoctorName = "";
		@SuppressWarnings("unused")
		int referralDoctorId = 0;
		int changedBy = 0;
		@SuppressWarnings("unused")
		String address1 = "";
		String address2 = "";
		String phoneNo = "";
		String mobileNo = "";
		int referralType = 0;

		referralDoctorId = (Integer) generalMap.get("id");
		referralDoctorName = (String) generalMap.get("name");
		address1 = (String) generalMap.get("addressOne");
		address2 = (String) generalMap.get("addressTwo");
		phoneNo = (String) generalMap.get("phoneNo");
		mobileNo = (String) generalMap.get("mobileNo");
		referralType = (Integer) generalMap.get("referralType");
		departmentId = (Integer) generalMap.get("departmentId");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasReferralDoctor masReferralDoctor = (MasReferralDoctor) getHibernateTemplate()
				.load(MasReferralDoctor.class, referralDoctorId);

		masReferralDoctor.setId(referralDoctorId);
		masReferralDoctor.setDoctorName(referralDoctorName);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masReferralDoctor.setDepartment(masDepartment);
		masReferralDoctor.setAddress1(address1);
		masReferralDoctor.setAddress2(address2);
		masReferralDoctor.setPhoneNo(phoneNo);
		masReferralDoctor.setMobileNo(mobileNo);
		masReferralDoctor.setReferralType(referralType);
		Users users = new Users();
		users.setId(changedBy);
		masReferralDoctor.setLastChgBy(users);
		masReferralDoctor.setLastChgDate(currentDate);
		masReferralDoctor.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReferralDoctor);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public boolean addReferralDoctor(MasReferralDoctor masReferralDoctor) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masReferralDoctor);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteReferralDoctor(int referralDoctorId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasReferralDoctor masReferralDoctor = new MasReferralDoctor();
		masReferralDoctor = (MasReferralDoctor) getHibernateTemplate().load(
				MasReferralDoctor.class, referralDoctorId);
		@SuppressWarnings("unused")
		Integer departmentId = masReferralDoctor.getDepartment().getId();
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masReferralDoctor.getStatus().equals("y")) {
			@SuppressWarnings("unused")
			List<MasDepartment> departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ referralDoctorId + "' and isc.Status='y'");
			masReferralDoctor.setStatus("n");
			dataDeleted = true;
		} else {
			masReferralDoctor.setStatus("y");
			dataDeleted = false;
		}
		Users users = new Users();
		users.setId(changedBy);
		masReferralDoctor.setLastChgBy(users);
		masReferralDoctor.setLastChgDate(currentDate);
		masReferralDoctor.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masReferralDoctor);
		return dataDeleted;

	}

	// -------------------------------Employee Pay Structure -------------------
	public Map<String, Object> showEmployeePayStructureJsp() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeListForSearch = new ArrayList<MasEmployee>();
		List<HrMasPayroll> payRollList = new ArrayList<HrMasPayroll>();
		List<HrEmployeePayStructure> searchEmployeePayStructureList = new ArrayList<HrEmployeePayStructure>();

		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee e where e.Status='y' order by e.FirstName");
		employeeListForSearch = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee e order by e.FirstName");
		payRollList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasPayroll");
		searchEmployeePayStructureList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeePayStructure ");
		map.put("employeeList", employeeList);
		map.put("employeeListForSearch", employeeListForSearch);
		map.put("payRollList", payRollList);
		map.put("searchEmployeePayStructureList",
				searchEmployeePayStructureList);
		return map;
	}

	public Map<String, Object> searchEmployeePayStructure(Integer employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasPayroll> payRollList = new ArrayList<HrMasPayroll>();
		List<HrEmployeePayStructure> searchEmployeePayStructureList = new ArrayList<HrEmployeePayStructure>();

		employeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ");

		Session session = getSession();
		Criteria criteria = session.createCriteria(HrMasPayroll.class);
		payRollList = criteria.list();

		searchEmployeePayStructureList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrEmployeePayStructure eps where eps.Employee.Id ="
						+ employeeId);
		map.put("employeeList", employeeList);
		map.put("payRollList", payRollList);
		map.put("searchEmployeePayStructureList",
				searchEmployeePayStructureList);
		return map;

	}

	public void addEmployeePayStructure(
			HrEmployeePayStructure employeePayStructure) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(employeePayStructure);
		hbt.flush();
		hbt.refresh(employeePayStructure);
	}

	@SuppressWarnings("unchecked")
	public boolean deleteEmployeePayStructure(int employeePayStructureId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrEmployeePayStructure hrEmployeePayStructure = new HrEmployeePayStructure();
			hrEmployeePayStructure = (HrEmployeePayStructure) getHibernateTemplate()
					.load(HrEmployeePayStructure.class, employeePayStructureId);
			Integer employeecodeId = hrEmployeePayStructure.getEmployee()
					.getId();

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrEmployeePayStructure.getStatus().equals("y")) {
				@SuppressWarnings("unused")
				List employeecodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as employee where employee.Id='"
								+ employeecodeId + "' and employee.Status='y'");
				hrEmployeePayStructure.setStatus("n");
				dataDeleted = true;
			} else {
				hrEmployeePayStructure.setStatus("y");
				dataDeleted = false;
			}
			hrEmployeePayStructure.setLastChgBy(changedBy);
			hrEmployeePayStructure.setLastChgDate(currentDate);
			hrEmployeePayStructure.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrEmployeePayStructure);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	// -------------------------------Employee Pay Structure -------------------
	public Map<String, Object> showEmployeePayElementsJsp() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeListForSearch = new ArrayList<MasEmployee>();
		List<HrMasPayElement> payElementsList = new ArrayList<HrMasPayElement>();
		List<HrEmployeePayElements> searchEmployeePayElementsList = new ArrayList<HrEmployeePayElements>();

		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee e where e.Status='y' order by e.FirstName");
		employeeListForSearch = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee e order by e.FirstName");
		payElementsList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasPayElement as pe where pe.Status ='y' ");
		searchEmployeePayElementsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeePayElements ");
		map.put("employeeList", employeeList);
		map.put("employeeListForSearch", employeeListForSearch);
		map.put("payElementsList", payElementsList);
		map.put("searchEmployeePayElementsList", searchEmployeePayElementsList);
		return map;
	}

	public Map<String, Object> searchEmployeePayElement(Integer employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasPayroll> payRollList = new ArrayList<HrMasPayroll>();
		List<HrEmployeePayElements> searchEmployeePayElementsList = new ArrayList<HrEmployeePayElements>();

		employeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ");
		searchEmployeePayElementsList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrEmployeePayElements eps where eps.Employee.Id ="
						+ employeeId);
		map = showEmployeePayElementsJsp();
		map.put("searchEmployeePayElementsList", searchEmployeePayElementsList);
		return map;

	}

	public Map<String, Object> addEmployeePayElement(
			HrEmployeePayElements employeePayElement) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		List existingEmpPayElementList = (List) getSession()
				.createCriteria(HrEmployeePayElements.class)
				.add(Restrictions.eq("Employee.Id", employeePayElement
						.getEmployee().getId()))
				.add(Restrictions.eq("PayElement.Id", employeePayElement
						.getPayElement().getId()))
				.add(Restrictions.eq("Status", "y")).list();
		String message = null;
		if (employeePayElement.getId() == null
				&& existingEmpPayElementList != null
				&& existingEmpPayElementList.size() > 0) {
			message = "Pay Element already added ";
		} else {

			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			hbt.saveOrUpdate(employeePayElement);
			hbt.flush();
			hbt.refresh(employeePayElement);
		}
		Map map = showEmployeePayElementsJsp();
		map.put("messageForDuplicate", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteEmployeePayElement(int employeePayElementId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrEmployeePayElements hrEmployeePayElements = new HrEmployeePayElements();
			hrEmployeePayElements = (HrEmployeePayElements) getHibernateTemplate()
					.load(HrEmployeePayElements.class, employeePayElementId);
			Integer employeecodeId = hrEmployeePayElements.getEmployee()
					.getId();

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrEmployeePayElements.getStatus().equals("y")) {
				@SuppressWarnings("unused")
				List employeecodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as employee where employee.Id='"
								+ employeecodeId + "' and employee.Status='y'");
				hrEmployeePayElements.setStatus("n");
				dataDeleted = true;
			} else {
				hrEmployeePayElements.setStatus("y");
				dataDeleted = false;
			}
			hrEmployeePayElements.setLastChgBy(changedBy);
			hrEmployeePayElements.setLastChgDate(currentDate);
			hrEmployeePayElements.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrEmployeePayElements);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map<String, Object> showAddEmployeePayElementJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasPayElement> payElementsList = new ArrayList<HrMasPayElement>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y"))
				.addOrder(Order.asc("FirstName")).list();
		payElementsList = session.createCriteria(HrMasPayElement.class)
				.add(Restrictions.eq("Status", "y")).list();

		map.put("employeeList", employeeList);
		map.put("payElementsList", payElementsList);
		return map;
	}

	public Map<String, Object> addMultipleEmployeePayElement(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List payElementIdList = new ArrayList();
		List payelementEmployeeList = new ArrayList();
		List payElementAmountList = new ArrayList();
		List payElementStartDateList = new ArrayList();
		List payElementTypeList = new ArrayList();
		List changedByList = new ArrayList();
		List currentTimeList = new ArrayList();
		List currentDateList = new ArrayList();

		if (generalMap.get("payElementIdList") != null) {
			payElementIdList = (List) generalMap.get("payElementIdList");
		}
		if (generalMap.get("payelementEmployeeList") != null) {
			payelementEmployeeList = (List) generalMap
					.get("payelementEmployeeList");
		}

		if (generalMap.get("payElementAmountList") != null) {
			payElementAmountList = (List) generalMap
					.get("payElementAmountList");
		}
		if (generalMap.get("payElementTypeList") != null) {
			payElementTypeList = (List) generalMap.get("payElementTypeList");
		}
		if (generalMap.get("payElementStartDateList") != null) {
			payElementStartDateList = (List) generalMap
					.get("payElementStartDateList");
		}
		if (generalMap.get("payElementStartDateList") != null) {
			payElementStartDateList = (List) generalMap
					.get("payElementStartDateList");
		}
		if (generalMap.get("changedByList") != null) {
			changedByList = (List) generalMap.get("changedByList");
		}
		if (generalMap.get("currentTimeList") != null) {
			currentTimeList = (List) generalMap.get("currentTimeList");
		}
		if (generalMap.get("currentDateList") != null) {
			currentDateList = (List) generalMap.get("currentDateList");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		if (payElementIdList.size() > 0) {
			for (int i = 0; i < payElementIdList.size(); i++) {
				HrEmployeePayElements employeePayElements = new HrEmployeePayElements();
				if (payElementIdList.get(i) != null) {
					int payElementId = Integer.parseInt(payElementIdList.get(i)
							.toString());
					HrMasPayElement hrMasPayElement = new HrMasPayElement();
					hrMasPayElement.setId(payElementId);
					employeePayElements.setPayElement(hrMasPayElement);
				}
				if (payelementEmployeeList.size() > 0) {
					if (payelementEmployeeList.get(i) != null) {
						int employeeId = Integer
								.parseInt(payelementEmployeeList.get(i)
										.toString());
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(employeeId);
						employeePayElements.setEmployee(masEmployee);
					}
				}
				if (payElementAmountList.get(i) != null) {
					BigDecimal payElementAmount = new BigDecimal(
							payElementAmountList.get(i).toString());
					employeePayElements.setPayAmount(payElementAmount);

				}
				if (payElementTypeList.get(i) != null) {
					String elementType = (String) payElementTypeList.get(i);
					employeePayElements.setPayElementType(elementType);
				}
				if (payElementStartDateList.size() > 0) {
					if (payElementStartDateList.get(i) != null) {
						Date startDate = HMSUtil
								.convertStringTypeDateToDateType(payElementStartDateList
										.get(i).toString());
						employeePayElements.setStartDate(startDate);
					}
				}
				if (changedByList.size() > 0) {
					if (changedByList.get(i) != null) {
						String changedBy = (String) changedByList.get(i);
						employeePayElements.setLastChgBy(changedBy);
					}
				}
				if (currentDateList.size() > 0) {
					if (currentDateList.get(i) != null) {
						Date currentDate = HMSUtil
								.convertStringTypeDateToDateType(currentDateList
										.get(i).toString());
						employeePayElements.setLastChgDate(currentDate);
					}
				}
				if (currentTimeList.size() > 0) {
					if (currentTimeList.get(i) != null) {
						String currentTime = (String) currentTimeList.get(i);
						employeePayElements.setLastChgTime(currentTime);
					}
				}
				employeePayElements.setStatus("y");

				hbt.save(employeePayElements);
				hbt.flush();
				hbt.refresh(employeePayElements);

			}

		}
		map = showAddEmployeePayElementJsp();
		return map;
	}

	// -------------------------------Employee Contract -------------------
	public Map<String, Object> showEmployeeContractJsp() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeListForSearch = new ArrayList<MasEmployee>();
		List<MasEmployeeContract> searchEmployeeContractList = new ArrayList<MasEmployeeContract>();
		String employeeTypeId = HMSUtil.getValuesFromPropertiesFile(
				"HR.properties", "EmployeeType.Id");

		employeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ec where ec.EmployeeType.Id="
						+ new Integer(employeeTypeId)
						+ " order by ec.EmployeeName,ec.Status");
		System.out.println(employeeTypeId + ">>>>>>>>>>>>"
				+ employeeList.size());
		employeeListForSearch = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ec where ec.EmployeeType.Id="
						+ new Integer(employeeTypeId)
						+ " order by ec.EmployeeName");
		searchEmployeeContractList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.MasEmployeeContract where Status='y'");
		map.put("employeeList", employeeList);
		map.put("employeeListForSearch", employeeListForSearch);
		map.put("searchEmployeeContractList", searchEmployeeContractList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmployeeContract(Integer employeeId) {

		List<MasEmployeeContract> searchEmployeeContractList = new ArrayList<MasEmployeeContract>();
		Map<String, Object> employeeFieldsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		String employeeTypeId = HMSUtil.getValuesFromPropertiesFile(
				"HR.properties", "EmployeeType.Id");

		try {
			if (employeeId != null) {
				searchEmployeeContractList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.MasEmployeeContract as  me where me.Employee.Id = "
								+ employeeId + "order by me.Id");

				employeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee ec where ec.EmployeeType.Id="
								+ new Integer(employeeTypeId)
								+ " order by ec.EmployeeName,ec.Status");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// employeeFieldsMap.put("searchEmployeeList",
		// searchEmployeeContractList);
		employeeFieldsMap.put("searchEmployeeContractList",
				searchEmployeeContractList);
		employeeFieldsMap.put("employeeList", employeeList);
		return employeeFieldsMap;
	}

	// ---------------------------- Employee -----------------------------
	@SuppressWarnings("unchecked")
	public List<MasTitle> getTitleList() {
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		titleList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasTitle as mt where mt.Status = 'y'");
		return titleList;
	}

	@SuppressWarnings("unchecked")
	public List<MasEmpStatus> getEmpStatusList() {
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		empStatusList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmpStatus as mes where mes.Status = 'y'");
		return empStatusList;
	}

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getDepartmentList() {
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		return departmentList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmployeeJsp(Map<String, Object> datamap) {
		Session ses = null;
		ses = getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		//List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasUnit> gridUnitList = new ArrayList<MasUnit>();
		List<MasEmployeeType> employeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasAdministrativeSex> masAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasLocation> locationList = new ArrayList<MasLocation>();
		List<MasReligion> religionList = new ArrayList<MasReligion>();
		List<MasCaste> casteList = new ArrayList<MasCaste>();
		List<MasCategory> masCategoryList = new ArrayList<MasCategory>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<HrEmployeeAddress> hrEmployeeAddress = new ArrayList<HrEmployeeAddress>();
		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		
		int hospitalId = 0;
		String userName = "";
		int userType = 0;
		int userId = 0;
		int districtId = (Integer) datamap.get("districtId");

		if (datamap.get("hospitalId") != null) {
			hospitalId = (Integer) datamap.get("hospitalId");
		}
		if (datamap.get("userName") != null) {
			userName = (String) datamap.get("userName");
		}
		if (datamap.get("userType") != null) {
			userType = (Integer) datamap.get("userType");
		}
		if (datamap.get("userId") != null) {
			userId = (Integer) datamap.get("userId");
		}
		
		employeeList = ses.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			

		HibernateTemplate hbt = getHibernateTemplate();
	
		titleList = hbt
				.find("from jkt.hms.masters.business.MasTitle as tm where UPPER(tm.Status) = 'Y' and tm.Id in (1,2,3,5)");//changed by govind 14-12-2016

		departmentList = ses.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("Department", "dep")
				.addOrder(Order.asc("dep.DepartmentName")).list();
		
		List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
		hrInstWiseEmpDeptStringList = ses
				.createCriteria(HrInstEmpDept.class)
				.createAlias("Institute", "i")
				.add(Restrictions.eq("i.Id", hospitalId))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.property("EmployeeDepartment"))
								.add(Projections.property("Id"))).list();

		List<Integer> hidList = new ArrayList<Integer>();
		
		if (hrInstWiseEmpDeptStringList.size() > 0) {

			Object[] obj = hrInstWiseEmpDeptStringList.get(0);
			String hIds = (String) obj[0];
			int hrInsitEmpDepId = (Integer) obj[1];
			String[] houseId = hIds.split(",");
			for (int i = 0; i < houseId.length; i++) {
				hidList.add(Integer.parseInt(houseId[i].trim()));
			}
			

			List<MasEmployeeDepartment> employeeDepartmentList = ses
					.createCriteria(MasEmployeeDepartment.class)
					.add(Restrictions.in("Id", hidList)).list();


			map.put("employeeDepartmentList", employeeDepartmentList);

		}

		empCategoryList = hbt
				.find("from jkt.hms.masters.business.MasEmpCategory as mec where UPPER(mec.Status) = 'Y' order by EmpCategoryName asc");
		empStatusList = hbt
				.find("from jkt.hms.masters.business.MasEmpStatus as mes where UPPER(mes.Status) = 'Y'");
	
		gradeList = hbt
				.find("from jkt.hms.masters.business.MasGrade as mg where UPPER(mg.Status) = 'Y'");
		rankList = hbt
				.find("from jkt.hms.masters.business.MasRank as mg where UPPER(mg.Status) = 'Y' order by RankName asc");
		employeeTypeList = hbt
				.find("from jkt.hrms.masters.business.MasEmployeeType as mg where UPPER(mg.Status) = 'Y'");
		masAdministrativeSexList = hbt
				.find("from jkt.hms.masters.business.MasAdministrativeSex as mg where UPPER(mg.Status) = 'Y'");

		districtList = hbt.find("from jkt.hms.masters.business.MasDistrict as md where lower(md.Status)='y'");
		maritalStatusList = hbt
				.find("from jkt.hms.masters.business.MasMaritalStatus as mms where lower(mms.Status)='y'");
		religionList = hbt
				.find("from jkt.hms.masters.business.MasReligion as mr where UPPER(mr.Status) = 'Y'");
		casteList = hbt
				.find("from jkt.hms.masters.business.MasCaste as mc where UPPER(mc.Status) = 'Y'");
		masCategoryList = hbt
				.find("from jkt.hms.masters.business.MasCategory as mc where UPPER(mc.Status) = 'Y'");
		Session session = getSession();
		Criteria crit = null;
		crit = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("HospitalName"));
		
		if(userType<2){//changed by govind 31-05-2017 for all hosptial to state admin
			
		}
		else if (userType ==2) {/* District Admin */
			crit = crit.add(Restrictions.eq("District.Id", districtId));
		}
		else{
			crit = crit.add(Restrictions.eq("Id", hospitalId));
		}
		masHospitalList = crit.list();

		hrEmployeeAddress = hbt
				.find("from jkt.hms.masters.business.HrEmployeeAddress as mc ");
		
		masHospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		/**
		 * For PH Admin
		 */
		if(userType==5){
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
					.add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
			map.put("bsScInstList", bsScInstList);
		}
		
		map.put("gridUnitList", gridUnitList);
		map.put("locationList", locationList);
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("empStatusList", empStatusList);
		map.put("empCategoryList", empCategoryList);
		map.put("gradeList", gradeList);
		//map.put("searchEmployeeList", searchEmployeeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("religionList", religionList);
		map.put("casteList", casteList);
		map.put("tradeList", tradeList);
		map.put("employeeTypeList", employeeTypeList);
		map.put("masAdministrativeSexList", masAdministrativeSexList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("employeeList", employeeList);
		map.put("masHospitalList", masHospitalList);
		map.put("hrEmployeeAddress", hrEmployeeAddress);
		map.put("masCategoryList", masCategoryList);
		map.put("masHospitalTypeList", masHospitalTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addEmployee(MasEmployee masEmployee,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		Session session = getSession();
		String lastEmployeeCode = "";
		String nextEmployeeCode = "";
		try {
			try {

				Criteria c = session.createCriteria(MasEmployee.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.addOrder(Order.desc("Id"));
				c.setFirstResult(0);
				c.setMaxResults(1);
				List<MasEmployee> employeeList = c.list();
				if (employeeList != null && employeeList.size() > 0) {
					lastEmployeeCode = employeeList.get(0).getEmployeeCode();
				} else {
					nextEmployeeCode = "E1";
				}

			} catch (Exception e) {
				nextEmployeeCode = "E1";
			}
			if (!lastEmployeeCode.equals("")) {
				if (!lastEmployeeCode.contains("E")) {
					nextEmployeeCode = "E"
							+ Integer
									.toString(((new Integer(lastEmployeeCode)) + 1));
				} else {
					int index = lastEmployeeCode.lastIndexOf('E');
					lastEmployeeCode = lastEmployeeCode.substring(index + 1);
					nextEmployeeCode = "E"
							+ Integer
									.toString(((new Integer(lastEmployeeCode)) + 1));
				}
			}
			masEmployee.setEmployeeCode(nextEmployeeCode);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masEmployee);
			hbt.flush();
			hbt.refresh(masEmployee);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("nextEmployeeCode", nextEmployeeCode);
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	public boolean addEmployee(MasEmployee masEmployee) {

		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masEmployee);
			//hbt.flush();
			//hbt.refresh(masEmployee);
			// addleaveBalanceToEmp(masEmployee);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean editEmployeeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;

		String firstName = "";
		String lastName = "";
		String middleName = "";
		@SuppressWarnings("unused")
		String employeeCode = "";
		// String serviceNo="";
		int employeeId = 0;
		int titleId = 0;
		int departmentId = 0;
		// int costCenterId = 0;
		int empStatusId = 0;
		// int empCategoryId = 0;
		int gradeId = 0;
		// int tradeId = 0;
		int unitId = 0;
		int rankId = 0;
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		Date joinDate = new Date();
		String jobCode = "";
		String email = "";
		String bankCode = "";
		String accounthead = "";
		String bankAccountNumber = "";
		String bankAccountCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		@SuppressWarnings("unused")
		// String grade = "";
		Date changedDate = new Date();
		Users changedBy = null;
		String currentTime = "";
		Date currentDate = new Date();
		int hospitalId = 0;
		String bankBranch = "";
		String ifscCode = "";
		employeeId = (Integer) generalMap.get("id");
		hospitalId = (Integer) generalMap.get("hospitalId");
		// employeeCode=(String)generalMap.get("employeeCode");
		// serviceNo=(String)generalMap.get("serviceNo");
		firstName = (String) generalMap.get("firstName");
		lastName = (String) generalMap.get("lastName");
		middleName = (String) generalMap.get("middleName");
		employeePhoto = (String) generalMap.get("employeePhoto");
		// jobCode=(String)generalMap.get("jobCode");
		appointmentDate = (Date) generalMap.get("appointmentDate");
		joinDate = (Date) generalMap.get("joinDate");
		titleId = (Integer) generalMap.get("titleId");
		gradeId = (Integer) generalMap.get("gradeId");
		departmentId = (Integer) generalMap.get("departmentId");
		// costCenterId=(Integer)generalMap.get("costCenterId");
		empStatusId = (Integer) generalMap.get("empStatusId");
		// empCategoryId=(Integer)generalMap.get("empCategoryId");
		rankId = (Integer) generalMap.get("rankId");
		// tradeId=(Integer)generalMap.get("tradeId");
		unitId = (Integer) generalMap.get("unitId");
		emergencyTellNumber = (String) generalMap.get("emergencyTellNumber");
		emergencyCellNumber = (String) generalMap.get("emergencyCellNumber");
		residenceTellNumber = (String) generalMap.get("residenceTellNumber");
		officeTellNumber = (String) generalMap.get("officeTellNumber");
		email = (String) generalMap.get("email");
		employeeUrl = (String) generalMap.get("employeeUrl");
		bankCode = (String) generalMap.get("bankCode");
		accounthead = (String) generalMap.get("accounthead");
		bankAccountCode = (String) generalMap.get("bankAccountCode");
		bankBranch = (String) generalMap.get("bankBranch");
		ifscCode = (String) generalMap.get("ifscCode");
		// grade=(String)generalMap.get("grade");
		bankAccountNumber = (String) generalMap.get("bankAccountNumber");

		changedBy = (Users) generalMap.get("changedBy");
		currentTime = (String) generalMap.get("currentTime");
		MasEmployee masEmployee = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, employeeId);

		masEmployee.setId(employeeId);
		// masEmployee.setEmployeeCode(employeeCode);
		// masEmployee.setServiceNo(serviceNo);
		masEmployee.setFirstName(firstName);
		masEmployee.setLastName(lastName);
		masEmployee.setMiddleName(middleName);
		masEmployee.setAccountHead(accounthead);
		masEmployee.setBankAccountNumber(bankAccountNumber);

		masEmployee.setBankCode(bankCode);
		masEmployee.setEmployeePhoto(employeePhoto);
		masEmployee.setUrl(employeeUrl);

		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		masEmployee.setHospital(hospital);

		if (titleId != 0) {
			MasTitle masTitle = new MasTitle();
			masTitle.setId(titleId);
			masEmployee.setTitle(masTitle);
		}
		/*
		 * if (departmentId != 0) { MasDepartment masDepartment = new
		 * MasDepartment(); masDepartment.setId(departmentId);
		 * masEmployee.setDepartment(masDepartment); }
		 */

		if (departmentId != 0) {
			MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();
			masEmployeeDepartment.setId(departmentId);
			masEmployee.setEmployeeDepartment(masEmployeeDepartment);
		}
		if (empStatusId != 0) {
			MasEmpStatus masEmpStatus = new MasEmpStatus();
			masEmpStatus.setId(empStatusId);
			masEmployee.setEmployeeStatus(masEmpStatus);
		}
		/*
		 * if(costCenterId != 0){ MasCostCenter masCostCenter = new
		 * MasCostCenter(); masCostCenter.setId(costCenterId);
		 * masEmployee.setCostCenter(masCostCenter); }
		 */
		/*
		 * if(empCategoryId != 0){ MasEmpCategory masEmpCategory = new
		 * MasEmpCategory(); masEmpCategory.setId(empCategoryId);
		 * masEmployee.setEmpCategory(masEmpCategory); }
		 */
		/*
		 * if(tradeId != 0){ MasTrade masTrade = new MasTrade();
		 * masTrade.setId(tradeId); masEmployee.setTrade(masTrade); }
		 */
		if (rankId != 0) {
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			masEmployee.setRank(masRank);
		}

		if (unitId != 0) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			masEmployee.setUnit(masUnit);
		}

		if (gradeId != 0) {
			MasGrade masGrade = new MasGrade();
			masGrade.setId(gradeId);
			masEmployee.setGrade(masGrade);
		}

		// masEmployee.setJobCode(jobCode);
		masEmployee.setAppointmentDate(appointmentDate);
		masEmployee.setEmail(email);
		masEmployee.setTelNoEmergency(emergencyTellNumber);
		masEmployee.setCellNoEmergency(emergencyCellNumber);
		masEmployee.setTelNoResidence(residenceTellNumber);
		masEmployee.setTelNoOffice(officeTellNumber);
		masEmployee.setJoinDate(joinDate);
		masEmployee.setBankAccountCode(bankAccountCode);
		masEmployee.setBankBranch(bankBranch);
		masEmployee.setIfscCode(ifscCode);
		masEmployee.setStatus("y");
		masEmployee.setLastChgBy(changedBy);
		masEmployee.setLastChgDate(currentDate);
		masEmployee.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masEmployee);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteEmployee(int employeeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Users changedBy = null;
		Date currentDate = new Date();
		String currentTime = "";
		int hospitalId = 0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasEmployee masEmployee = new MasEmployee();
		masEmployee = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, employeeId);
		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masEmployee.getStatus().equals("Y")) {
			masEmployee.setStatus("N");
			dataDeleted = true;
		} else {
			masEmployee.setStatus("Y");
			dataDeleted = false;
		}
		masEmployee.setLastChgBy(changedBy);
		masEmployee.setLastChgDate(currentDate);
		masEmployee.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masEmployee);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEmployee(String employeeCode,
			String firstName, String lastName, int hospitalId) {

		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		Map<String, Object> employeeFieldsMap = new HashMap<String, Object>();
		/*
		 * List titleList = new ArrayList(); List departmentList = new
		 * ArrayList(); List costCenterList = new ArrayList(); List
		 * empStatusList = new ArrayList(); List empCategoryList = new
		 * ArrayList(); List gradeList = new ArrayList();
		 */
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List gridUnitList = null;
		try {
			if ((employeeCode != null) && (firstName == null)
					&& (lastName == null)) {
				searchEmployeeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasEmployee as  me where lower(me.Status)='y' and  UPPER(me.PEN) like UPPER('"
								+ employeeCode
								+ "%') and me.Hospital.Id="
								+ hospitalId + " order by me.Id");
			} else if ((employeeCode == null) && (firstName != null)
					&& (lastName == null)) {
				/*
				 * searchEmployeeList = getHibernateTemplate().find(
				 * "from jkt.hms.masters.business.MasEmployee as me where UPPER(me.FirstName) like UPPER('"
				 * + firstName +
				 * "%') and me.Hospital.Id="+hospitalId+" order by me.FirstName"
				 * );
				 */
				searchEmployeeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasEmployee as me where lower(me.Status)='y' and UPPER(me.EmployeeName) like UPPER('"
								+ firstName
								+ "%') and me.Hospital.Id="
								+ hospitalId + " order by me.EmployeeName");

			} else if ((employeeCode == null) && (firstName == null)
					&& (lastName != null)) {
				searchEmployeeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasEmployee me where lower(me.Status)='y' and UPPER(me.LastName) like UPPER('"
								+ lastName
								+ "%') and me.Hospital.Id="
								+ hospitalId + " order by me.LastName");
			}else{
				searchEmployeeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasEmployee me where lower(me.Status)='y' and me.Hospital.Id="
								+ hospitalId + " order by me.EmployeeName");
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * gridUnitList = getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasUnit as isc"); titleList =
		 * getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasTitle as mt where mt.Status = 'Y'"
		 * ); departmentList = getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasDepartment as md where md.Status = 'Y'"
		 * ); costCenterList = getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasCostCenter as md where md.Status = 'Y' "
		 * ); empStatusList = getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasEmpStatus as md where md.Status = 'Y'"
		 * ); empCategoryList = getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasEmpCategory as md where md.Status = 'Y'"
		 * ); gradeList = getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasGrade as mg where mg.Status = 'Y'"
		 * ); rankList = getHibernateTemplate()
		 * .find("from jkt.hms.masters.business.MasRank as mg where mg.Status = 'Y'"
		 * ); unitList = getHibernateTemplate()
		 * .find("from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'Y'"
		 * ); tradeList = getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'Y'"
		 * );
		 * 
		 * 
		 * employeeDepartmentList = getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasTrade as mg where mg.Status = 'Y'"
		 * ); employeeFieldsMap = showEmployeeJsp( hospitalId);
		 */
		// employeeFieldsMap = showEmployeeJsp( hospitalId);
		employeeFieldsMap.put("searchEmployeeList", searchEmployeeList);

		/*
		 * employeeFieldsMap.put("gridUnitList",gridUnitList);
		 * employeeFieldsMap.put("titleList",titleList);
		 * employeeFieldsMap.put("departmentList",departmentList);
		 * employeeFieldsMap.put("costCenterList",costCenterList);
		 * employeeFieldsMap.put("empStatusList",empStatusList);
		 * employeeFieldsMap.put("empCategoryList",empCategoryList);
		 * employeeFieldsMap.put("gradeList",gradeList);
		 * employeeFieldsMap.put("rankList", rankList);
		 * employeeFieldsMap.put("unitList",unitList);
		 * employeeFieldsMap.put("tradeList", tradeList);
		 * employeeFieldsMap.put("employeeDepartmentList",
		 * employeeDepartmentList);
		 */
		return employeeFieldsMap;
	}

	// ---------------------------------- Rank -------------------------
	public boolean addRank(MasRank masRank) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRank);
		hbt.flush();
		hbt.refresh(masRank);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteRank(int rankId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		/* String changedBy = ""; */
		Users changedBy = null;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRank masRank = new MasRank();
		masRank = (MasRank) getHibernateTemplate().load(MasRank.class, rankId);
		/* Integer serviceTypeId = masRank.getServiceType().getId(); */
		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			List serviceTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceType as isc where isc.Id='"
							+ rankId + "' and isc.Status='y'");
			List rankCategoryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRankCategory as isc where isc.Id='"
							+ rankId + "' and isc.Status='y'");
			List serviceStatusList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceStatus as isc where isc.Id='"
							+ rankId + "' and isc.Status='y'");
			if (flag.equals("InActivate")) {
				masRank.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masRank.setStatus("Y");
				dataDeleted = false;
			}
		}
		masRank.setLastChgBy(changedBy);
		masRank.setLastChgDate(currentDate);
		masRank.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRank);
		return dataDeleted;
	}

	public boolean editRankToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int serviceTypeId = 0;
		int rankCategoryId = 0;
		int serviceStatusId = 0;
		int rankId = 0;
		String rankName = "";
		@SuppressWarnings("unused")
		String rankCode = "";
		/* String changedBy = ""; */
		Users changedBy = null;
		rankId = (Integer) generalMap.get("id");
		rankCode = (String) generalMap.get("rankCode");
		rankName = (String) generalMap.get("name");
		int grade_id = Integer.parseInt("" + generalMap.get("grade"));
		int wing_id = Integer.parseInt("" + generalMap.get("wing"));
		int stream_id = Integer.parseInt("" + generalMap.get("stream"));
		int cadre_id = Integer.parseInt("" + generalMap.get("cadre"));
		int designationOrder = Integer.parseInt(""
				+ generalMap.get("designationOrder"));
		String desc = "" + generalMap.get("desc");
		/*
		 * serviceStatusId=(Integer)generalMap.get("serviceStatusId");
		 * serviceTypeId=(Integer)generalMap.get("serviceTypeId");
		 * rankCategoryId=(Integer)generalMap.get("rankCategoryId");
		 */changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRank masRank = (MasRank) getHibernateTemplate().load(MasRank.class,
				rankId);

		masRank.setId(rankId);
		masRank.setRankName(rankName);

		/*
		 * MasServiceStatus masServiceStatus= new MasServiceStatus();
		 * masServiceStatus.setId(serviceStatusId);
		 * masRank.setServiceStatus(masServiceStatus);
		 * 
		 * MasServiceType masServiceType= new MasServiceType();
		 * masServiceType.setId(serviceTypeId);
		 * masRank.setServiceType(masServiceType);
		 * 
		 * MasRankCategory masRankCategory= new MasRankCategory();
		 * masRankCategory.setId(rankCategoryId);
		 * masRank.setRankCategory(masRankCategory);
		 */

		MasWing mw = new MasWing();
		mw.setId(wing_id);
		masRank.setWing(mw);

		MasGrade mg = new MasGrade();
		mg.setId(grade_id);
		masRank.setGrade(mg);

		MasStream ms = new MasStream();
		ms.setId(stream_id);
		masRank.setStream(ms);

		MasCadre mc = new MasCadre();
		mc.setId(cadre_id);
		masRank.setCadre(mc);

		masRank.setDesignationOrder(designationOrder);
		masRank.setDescription(desc);

		masRank.setLastChgBy(changedBy);
		masRank.setLastChgDate(currentDate);
		masRank.setLastChgTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRank);
		hbt.refresh(masRank);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchRank(String rankCode, String rankName) {
		List<MasRank> searchRankList = new ArrayList<MasRank>();
		List serviceTypeList = null;
		List serviceStatusList = null;
		List rankCategoryList = null;
		Map<String, Object> rankFieldsMap = new HashMap<String, Object>();
		List gridServiceTypeList = null;
		//added by govind 28-09-2016
		List<MasWing> masWingList = new ArrayList<MasWing>();
		List<MasGrade> masGradeList = new ArrayList<MasGrade>();
		List<MasStream> masStreamList = new ArrayList<MasStream>();
		List<MasCadre> masCadreList = new ArrayList<MasCadre>();
		//added by govind 28-09-2016 end
		try {
			if ((rankName != null) || (rankCode == null)) {
				searchRankList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasRank as i where  UPPER( i.RankName ) like UPPER( '"
								+ rankName + "%') order by i.RankName");
			} else {
				searchRankList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasRank as i where  i.RankCode like '"
								+ rankCode + "%' order by i.RankCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		serviceStatusList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceStatus as isc where isc.Status = 'y'");
		rankCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRankCategory as isc where isc.Status = 'y'");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		//added by govind 28-09-2016 
		masWingList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasWing as isc where UPPER(isc.Status) = 'Y' order by WingName asc ");
		masGradeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasGrade as isc where UPPER(isc.Status) = 'Y'");
		masStreamList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStream as isc where UPPER(isc.Status) = 'Y'");
		masCadreList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCadre as isc where UPPER(isc.Status) = 'Y'  order by CadreName asc ");

	
		rankFieldsMap.put("masWingList", masWingList);
		rankFieldsMap.put("masGradeList", masGradeList);
		rankFieldsMap.put("masStreamList", masStreamList);
		rankFieldsMap.put("masCadreList", masCadreList);
		//added by govind 28-09-2016 end
		rankFieldsMap.put("gridServiceTypeList", gridServiceTypeList);
		rankFieldsMap.put("searchRankList", searchRankList);
		rankFieldsMap.put("serviceTypeList", serviceTypeList);
		rankFieldsMap.put("serviceStatusList", serviceStatusList);
		rankFieldsMap.put("rankCategoryList", rankCategoryList);
		return rankFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRankJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
       	List<MasRank> searchRankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceType> gridServiceTypeList = new ArrayList<MasServiceType>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
		List<MasWing> masWingList = new ArrayList<MasWing>();
		List<MasGrade> masGradeList = new ArrayList<MasGrade>();
		List<MasStream> masStreamList = new ArrayList<MasStream>();
		List<MasCadre> masCadreList = new ArrayList<MasCadre>();

		searchRankList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRank ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		serviceTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		rankCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRankCategory as isc where isc.Status = 'y'");
		serviceStatusList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceStatus as isc where isc.Status = 'y'");
		masWingList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasWing as isc where UPPER(isc.Status) = 'Y' order by WingName asc ");
		masGradeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasGrade as isc where UPPER(isc.Status) = 'Y'");
		masStreamList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStream as isc where UPPER(isc.Status) = 'Y'");
		masCadreList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCadre as isc where UPPER(isc.Status) = 'Y'  order by CadreName asc ");

		map.put("searchRankList", searchRankList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("gridServiceTypeList", gridServiceTypeList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("masWingList", masWingList);
		map.put("masGradeList", masGradeList);
		map.put("masStreamList", masStreamList);
		map.put("masCadreList", masCadreList);
		return map;
	}

	// ---------------------------------------- Formation
	// ---------------------------------
	public boolean addFormation(MasFormation masFormation) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masFormation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteFormation(int formationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasFormation masFormation = new MasFormation();
		masFormation = (MasFormation) getHibernateTemplate().load(
				MasFormation.class, formationId);
		@SuppressWarnings("unused")
		Integer serviceTypeId = masFormation.getServiceType().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masFormation.getStatus().equals("y")) {
			@SuppressWarnings("unused")
			List serviceTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceType as isc where isc.Id='"
							+ formationId + "' and isc.Status='y'");
			masFormation.setStatus("n");
			dataDeleted = true;
		} else {
			masFormation.setStatus("y");
			dataDeleted = false;
		}
		masFormation.setLastChgBy(changedBy);
		masFormation.setLastChgDate(currentDate);
		masFormation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masFormation);
		return dataDeleted;

	}

	public boolean editFormationToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int serviceTypeId = 0;
		String formationName = "";
		@SuppressWarnings("unused")
		String formationCode = "";
		int formationId = 0;
		String changedBy = "";
		formationId = (Integer) generalMap.get("id");
		formationCode = (String) generalMap.get("formationCode");
		formationName = (String) generalMap.get("name");
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasFormation masFormation = (MasFormation) getHibernateTemplate().load(
				MasFormation.class, formationId);

		masFormation.setId(formationId);
		masFormation.setFormationName(formationName);
		MasServiceType masServiceType = new MasServiceType();
		masServiceType.setId(serviceTypeId);
		masFormation.setServiceType(masServiceType);
		masFormation.setLastChgBy(changedBy);
		masFormation.setLastChgDate(currentDate);
		masFormation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masFormation);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchFormation(String formationCode,
			String formationName) {
		List<MasFormation> searchFormationList = new ArrayList<MasFormation>();
		List serviceTypeList = null;
		Map<String, Object> formationFieldsMap = new HashMap<String, Object>();
		List gridServiceTypeList = null;
		try {
			if ((formationName != null) || (formationCode == null)) {
				searchFormationList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasFormation as i where i.FormationName like '"
								+ formationName + "%' order by i.FormationName");
			} else {
				searchFormationList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasFormation as i where i.FormationCode like '"
								+ formationCode + "%' order by i.FormationCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		formationFieldsMap.put("gridServiceTypeList", gridServiceTypeList);
		formationFieldsMap.put("searchFormationList", searchFormationList);
		formationFieldsMap.put("serviceTypeList", serviceTypeList);
		return formationFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showFormationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasFormation> searchFormationList = new ArrayList<MasFormation>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceType> gridServiceTypeList = new ArrayList<MasServiceType>();
		searchFormationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasFormation ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		serviceTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		map.put("searchFormationList", searchFormationList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("gridServiceTypeList", gridServiceTypeList);
		return map;
	}

	// --------------------------------------------Trade------------------------------
	public boolean addTrade(MasTrade masTrade) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTrade);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteTrade(int tradeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTrade masTrade = new MasTrade();
		masTrade = (MasTrade) getHibernateTemplate().load(MasTrade.class,
				tradeId);
		@SuppressWarnings("unused")
		Integer serviceTypeId = masTrade.getServiceType().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masTrade.getStatus().equals("y")) {
			@SuppressWarnings("unused")
			List serviceTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceType as isc where isc.Id='"
							+ tradeId + "' and isc.Status='y'");
			masTrade.setStatus("n");
			dataDeleted = true;
		} else {
			masTrade.setStatus("y");
			dataDeleted = false;
		}
		masTrade.setLastChgBy(changedBy);
		masTrade.setLastChgDate(currentDate);
		masTrade.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTrade);
		return dataDeleted;
	}

	public boolean editTradeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int serviceTypeId = 0;
		String tradeName = "";
		@SuppressWarnings("unused")
		int tradeId = 0;
		String changedBy = "";
		tradeId = (Integer) generalMap.get("id");
		tradeName = (String) generalMap.get("name");
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasTrade masTrade = (MasTrade) getHibernateTemplate().load(
				MasTrade.class, tradeId);
		masTrade.setId(tradeId);
		masTrade.setTradeName(tradeName);
		MasServiceType masServiceType = new MasServiceType();
		masServiceType.setId(serviceTypeId);
		masTrade.setServiceType(masServiceType);
		masTrade.setLastChgBy(changedBy);
		masTrade.setLastChgDate(currentDate);
		masTrade.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTrade);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTrade(String tradeName) {
		List<MasTrade> searchTradeList = new ArrayList<MasTrade>();
		List<MasServiceType> serviceTypeList = null;
		Map<String, Object> tradeFieldsMap = new HashMap<String, Object>();
		List<MasServiceType> gridServiceTypeList = null;
		try {
			if (tradeName != null) {
				searchTradeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasTrade as i where lower(i.TradeName) like '"
								+ tradeName.toLowerCase()
								+ "%' order by i.TradeName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		serviceTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		tradeFieldsMap.put("gridServiceTypeList", gridServiceTypeList);
		tradeFieldsMap.put("searchTradeList", searchTradeList);
		tradeFieldsMap.put("serviceTypeList", serviceTypeList);
		return tradeFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTradeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTrade> searchTradeList = new ArrayList<MasTrade>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceType> gridServiceTypeList = new ArrayList<MasServiceType>();

		searchTradeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTrade ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		serviceTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		map.put("searchTradeList", searchTradeList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("gridServiceTypeList", gridServiceTypeList);
		return map;
	}

	// ---------------------------------------------Unit
	// -------------------------------------------
	public boolean addUnit(MasUnit masUnit) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masUnit);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteUnit(int unitId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasUnit masUnit = new MasUnit();
		masUnit = (MasUnit) getHibernateTemplate().load(MasUnit.class, unitId);

		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masUnit.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masUnit.setStatus("y");
				dataDeleted = false;
			}
		}

		masUnit.setLastChgDate(currentDate);
		masUnit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUnit);
		return dataDeleted;
	}

	public boolean editUnitToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String unitName = "";
		@SuppressWarnings("unused")
		String unitAddress = "";
		int unitId = 0;
		String local = "";
		unitId = (Integer) generalMap.get("id");
		unitAddress = (String) generalMap.get("unitAddress");
		unitName = (String) generalMap.get("name");
		local = (String) generalMap.get("local");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasUnit masUnit = (MasUnit) getHibernateTemplate().load(MasUnit.class,
				unitId);

		masUnit.setId(unitId);
		masUnit.setUnitName(unitName);
		masUnit.setUnitAddress(unitAddress);
		masUnit.setLocalUnit(local);
		masUnit.setLastChgDate(currentDate);
		masUnit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masUnit);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchUnit(String unitName) {
		List<MasUnit> searchUnitList = new ArrayList<MasUnit>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		try {
			if ((unitName != null)) {
				searchUnitList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasUnit imc where lower(imc.UnitName) like '"
								+ unitName.toLowerCase()
								+ "%' order by imc.UnitName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("searchUnitList", searchUnitList);
		return unitFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showUnitJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> searchUnitList = new ArrayList<MasUnit>();
		searchUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit ");
		map.put("searchUnitList", searchUnitList);
		return map;
	}

	// ----------------------------------RecordOfficeAddress------------------------------------------
	public Map<String, Object> showRecordOfficeAddressJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRecordOfficeAddress> searchRecordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceType> gridServiceTypeList = new ArrayList<MasServiceType>();

		searchRecordOfficeAddressList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRecordOfficeAddress ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		serviceTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceType as isc where isc.Status = 'y'");
		map.put("searchRecordOfficeAddressList", searchRecordOfficeAddressList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("gridServiceTypeList", gridServiceTypeList);
		return map;
	}

	public boolean addRecordOfficeAddress(
			MasRecordOfficeAddress masRecordOfficeAddress) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRecordOfficeAddress);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteRecordOfficeAddress(int recordOfficeAddressId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
		masRecordOfficeAddress = (MasRecordOfficeAddress) getHibernateTemplate()
				.load(MasRecordOfficeAddress.class, recordOfficeAddressId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		@SuppressWarnings("unused")
		Integer serviceTypeId = masRecordOfficeAddress.getServiceType().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masRecordOfficeAddress.getStatus().equals("y")) {
			@SuppressWarnings("unused")
			List serviceTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasServiceType as isc where isc.Id='"
							+ recordOfficeAddressId + "' and isc.Status='y'");
			masRecordOfficeAddress.setStatus("n");
			dataDeleted = true;
		} else {
			masRecordOfficeAddress.setStatus("y");
			dataDeleted = false;
		}
		masRecordOfficeAddress.setLastChgBy(changedBy);
		masRecordOfficeAddress.setLastChgDate(currentDate);
		masRecordOfficeAddress.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRecordOfficeAddress);
		return dataDeleted;
	}

	public boolean editRecordOfficeAddress(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int serviceTypeId = 0;
		String recordOfficeAddress = "";
		@SuppressWarnings("unused")
		int recordOfficeAddressId = 0;
		String changedBy = "";
		recordOfficeAddressId = (Integer) generalMap.get("id");
		recordOfficeAddress = (String) generalMap.get("name");
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRecordOfficeAddress masRecordOfficeAddress = (MasRecordOfficeAddress) getHibernateTemplate()
				.load(MasRecordOfficeAddress.class, recordOfficeAddressId);
		masRecordOfficeAddress.setId(recordOfficeAddressId);
		masRecordOfficeAddress.setAddress(recordOfficeAddress);
		MasServiceType masServiceType = new MasServiceType();
		masServiceType.setId(serviceTypeId);
		masRecordOfficeAddress.setServiceType(masServiceType);
		masRecordOfficeAddress.setLastChgBy(changedBy);
		masRecordOfficeAddress.setLastChgDate(currentDate);
		masRecordOfficeAddress.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRecordOfficeAddress);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchRecordOfficeAddress(
			String recordOfficeAddress) {
		List<MasUnit> searchRecordOfficeAddressList = new ArrayList<MasUnit>();
		Map<String, Object> recordOfficeAddressFieldsMap = new HashMap<String, Object>();
		List serviceTypeList = new ArrayList();
		List gridServiceTypeList = null;
		try {
			if ((recordOfficeAddress != null)) {
				searchRecordOfficeAddressList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasRecordOfficeAddress imc where imc.Address like '"
								+ recordOfficeAddress
								+ "%' order by imc.Address");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasServiceType as md where md.Status = 'y' ");
		gridServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType as isc");
		recordOfficeAddressFieldsMap.put("searchRecordOfficeAddressList",
				searchRecordOfficeAddressList);
		recordOfficeAddressFieldsMap.put("serviceTypeList", serviceTypeList);
		recordOfficeAddressFieldsMap.put("gridServiceTypeList",
				gridServiceTypeList);
		return recordOfficeAddressFieldsMap;
	}

	// ------------------------------- Rank Category
	// -------------------------------------------

	public Map<String, Object> showRankCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> searchRankCategoryList = new ArrayList<MasRankCategory>();
		searchRankCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRankCategory ");
		map.put("searchRankCategoryList", searchRankCategoryList);
		return map;
	}

	public Map<String, Object> searchRankCategory(String rankCategoryCode,
			String rankCategoryName) {
		List<MasRankCategory> searchRankCategoryList = new ArrayList<MasRankCategory>();
		Map rankCategoryFieldsMap = new HashMap();
		try {
			if ((rankCategoryName != null) || (rankCategoryCode == null)) {
				searchRankCategoryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasRankCategory sc where lower(sc.RankCategoryName) like '"
								+ rankCategoryName.toLowerCase()
								+ "%' order by sc.RankCategoryName");
			} else {
				searchRankCategoryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasRankCategory sc where lower(sc.RankCategoryCode) like '"
								+ rankCategoryCode.toLowerCase()
								+ "%' order by sc.RankCategoryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rankCategoryFieldsMap.put("searchRankCategoryList",
				searchRankCategoryList);
		return rankCategoryFieldsMap;
	}

	public boolean editRankCategoryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String rankCategoryName = "";
		@SuppressWarnings("unused")
		String rankCategoryCode = "";
		int rankCategoryId = 0;

		rankCategoryId = (Integer) generalMap.get("id");
		rankCategoryCode = (String) generalMap.get("rankCategoryCode");
		rankCategoryName = (String) generalMap.get("name");

		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRankCategory masRankCategory = (MasRankCategory) getHibernateTemplate()
				.get(MasRankCategory.class, rankCategoryId);

		masRankCategory.setId(rankCategoryId);
		masRankCategory.setRankCategoryName(rankCategoryName);

		masRankCategory.setLastChgDate(currentDate);
		masRankCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRankCategory);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addRankCategory(MasRankCategory masRankCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRankCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteRankCategory(int rankCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRankCategory masRankCategory = new MasRankCategory();
		masRankCategory = (MasRankCategory) getHibernateTemplate().get(
				MasRankCategory.class, rankCategoryId);

		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masRankCategory.getStatus().equals("y")) {
			masRankCategory.setStatus("n");
			dataDeleted = true;
		} else {
			masRankCategory.setStatus("y");
			dataDeleted = false;
		}

		masRankCategory.setLastChgDate(currentDate);
		masRankCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRankCategory);
		return dataDeleted;
	}

	// ------------------------Brand Master----------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBrandJsp() {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> searchBrandList = new ArrayList<MasStoreBrand>();
		// List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();

		searchBrandList = session.createCriteria(MasStoreBrand.class).list();
		// itemList=getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasStoreItem as sc");

		manufacturerList = session.createCriteria(MasManufacturer.class)
				.addOrder(Order.asc("ManufacturerName"))
				.list();
		map.put("searchBrandList", searchBrandList);
		// map.put("itemList",itemList);
		map.put("manufacturerList", manufacturerList);

		return map;
	}

	public Map<String, Object> searchBrand(String brandCode, String brandName) {
		List<MasStoreBrand> searchBrandList = new ArrayList<MasStoreBrand>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map brandFieldsMap = new HashMap();
		Session session = getSession();
		try {
			if ((brandName != null) || (brandCode == null)) {
				// searchBrandList =
				// getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreBrand as sc where sc.BrandName like '"
				// + brandName + "%' order by sc.BrandName");
				searchBrandList = session
						.createCriteria(MasStoreBrand.class)
						.add(Restrictions.like("BrandName", brandName)
								.ignoreCase()).addOrder(Order.asc("BrandName"))
						.list();
			} else {
				// searchBrandList =
				// getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreBrand as sc where sc.BrandCode like '"+
				// brandCode + "%' order by sc.BrandCode");

				searchBrandList = session
						.createCriteria(MasStoreBrand.class)
						.add(Restrictions.like("BrandCode", brandCode)
								.ignoreCase()).addOrder(Order.asc("BrandCode"))
						.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		manufacturerList = session.createCriteria(MasManufacturer.class).list();
		itemList = session.createCriteria(MasStoreItem.class).list();

		brandFieldsMap.put("searchBrandList", searchBrandList);
		brandFieldsMap.put("manufacturerList", manufacturerList);
		brandFieldsMap.put("itemList", itemList);
		return brandFieldsMap;
	}

	public boolean editBrandToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		int itemGenericId = 0;
		int manufacturerId = 0;
		int itemId = 0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String brandName = "";
		@SuppressWarnings("unused")
		String brandCode = "";
		int brandId = 0;
		int userId = 0;
		brandId = (Integer) generalMap.get("id");
		brandCode = (String) generalMap.get("brandCode");
		brandName = (String) generalMap.get("name");
		// itemGenericId=(Integer)generalMap.get("itemGenericId");
		manufacturerId = (Integer) generalMap.get("manufacturerId");
		itemId = (Integer) generalMap.get("itemId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreBrand masBrand = (MasStoreBrand) getHibernateTemplate().get(
				MasStoreBrand.class, brandId);

		masBrand.setId(brandId);
		masBrand.setBrandName(brandName);

		MasStoreItem masStoreItem = new MasStoreItem();
		masStoreItem.setId(itemId);
		masBrand.setItem(masStoreItem);

		MasManufacturer masManufacturer = new MasManufacturer();
		masManufacturer.setId(manufacturerId);
		masBrand.setManufacturer(masManufacturer);
		masStoreItem.setManufacturer(masManufacturer);
		/*
		 * MasStoreItemGeneric masStoreItemGeneric= new MasStoreItemGeneric();
		 * masStoreItemGeneric.setId(itemGenericId);
		 * masBrand.setItemGeneric(masStoreItemGeneric);
		 */

		Users user = new Users();
		user.setId(userId);
		masBrand.setLastChgBy(user);
		masBrand.setLastChgDate(currentDate);
		masBrand.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBrand);
		hbt.refresh(masBrand);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addBrand(MasStoreBrand masBrand) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBrand);
		hbt.refresh(masBrand);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBrand(int brandId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		Session session = getSession();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreBrand masBrand = new MasStoreBrand();
		masBrand = (MasStoreBrand) getHibernateTemplate().get(
				MasStoreBrand.class, brandId);
		Integer itemId = masBrand.getItem().getId();
		Integer itemGenericId = masBrand.getItemGeneric().getId();
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (masBrand.getStatus().equals("y")) {
			/*
			 * List itemList = getHibernateTemplate().find(
			 * "from jkt.hms.masters.business.MasStoreItem as isc where isc.Id='"
			 * + brandId + "' and isc.Status='y'"); List itemGenericList =
			 * getHibernateTemplate().find(
			 * "from jkt.hms.masters.business.MasStoreItemGeneric as isc where isc.Id='"
			 * + brandId + "' and isc.Status='y'");
			 */

			List itemList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("Id", brandId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			List itemGenericList = session
					.createCriteria(MasStoreItemGeneric.class)
					.add(Restrictions.eq("Id", brandId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			masBrand.setStatus("n");
			dataDeleted = true;
		} else {
			masBrand.setStatus("y");
			dataDeleted = false;
		}

		Users user = new Users();
		user.setId(userId);
		masBrand.setLastChgBy(user);

		masBrand.setLastChgDate(currentDate);
		masBrand.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBrand);
		return dataDeleted;
	}

	public Map<String, Object> getConnection() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public int getItemId(String pvms) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		itemList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItem as sc where sc.PvmsNo ='"
						+ pvms + "'");
		MasStoreItem masStoreItem = (MasStoreItem) itemList.get(0);
		int itemId = masStoreItem.getId();
		return itemId;
	}

	public void addEmployeeEducation(HrMasEmployeeEducation employeeEducation) {
		//System.out.println("employeeEducation---"+employeeEducation.getCourse().getId());
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if(null !=employeeEducation){
		hbt.saveOrUpdate(employeeEducation);
		}
	}

	public void addEmployeeExperience(HrEmployeeExperience employeeExperience) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(employeeExperience);
	}

	public Boolean addEmployeeContract(MasEmployeeContract employeeContract) {
		Boolean successful = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(employeeContract);
			hbt.flush();
			hbt.refresh(employeeContract);
			successful = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successful;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteEmployeeContract(int employeeContractId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasEmployeeContract masEmployeeContract = new MasEmployeeContract();
			masEmployeeContract = (MasEmployeeContract) getHibernateTemplate()
					.load(MasEmployeeContract.class, employeeContractId);
			Integer employeecodeId = masEmployeeContract.getEmployee().getId();

			Users changedBy = (Users) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (masEmployeeContract.getStatus().equals("y")) {
				@SuppressWarnings("unused")
				List employeecodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as employee where employee.Id='"
								+ employeecodeId + "' and employee.Status='y'");
				masEmployeeContract.setStatus("n");
				dataDeleted = true;
			} else {
				masEmployeeContract.setStatus("y");
				dataDeleted = false;
			}
			masEmployeeContract.setLastChgBy(changedBy);
			masEmployeeContract.setLastChgDate(currentDate);
			masEmployeeContract.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masEmployeeContract);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public MasEmployeeContract getEmployeeContract(Integer empContractId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(MasEmployeeContract.class);
		crit = crit.add(Restrictions.eq("Id", empContractId));
		List empContractList = crit.list();
		MasEmployeeContract employee = (MasEmployeeContract) empContractList
				.get(0);
		return employee;
	}

	public MasHospital getCompany(Integer hospitalId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(MasHospital.class);
		crit = crit.add(Restrictions.eq("Id", hospitalId));
		List companyList = crit.list();
		MasHospital company = (MasHospital) companyList.get(0);
		return company;
	}

	public MasEmployee getLastAddedEmployee() {
		List list = getHibernateTemplate().find(
				"select max(company.Id) from MasEmployee company");
		Integer employeeId = (Integer) list.get(0);

		Session session = getSession();
		Criteria crit = session.createCriteria(MasEmployee.class);
		crit = crit.add(Restrictions.eq("Id", employeeId));
		List employeeList = crit.list();
		MasEmployee employee = (MasEmployee) employeeList.get(0);
		return employee;

	}

	public MasEmployeeType getEmployeeType(Integer employeeTypeId) {
		Session session = getSession();
		Criteria crit = session.createCriteria(MasEmployeeType.class);
		crit = crit.add(Restrictions.eq("Id", employeeTypeId));
		List employeeTypeList = crit.list();
		MasEmployeeType employeeType = (MasEmployeeType) employeeTypeList
				.get(0);
		return employeeType;
	}

	public void addEmployeePersonelDetails(
			HrEmployeePersonelDetails employeePersonelDetails) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(employeePersonelDetails);
	}

	public MasEmployee getEmployee(Integer employeeId) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(MasEmployee.class);
		criteria = criteria.add(Restrictions.eq("Id", employeeId));
		List employeeList = criteria.list();
		MasEmployee employee = (MasEmployee) employeeList.get(0);
		return employee;
	}

	public HrEmployeePayElements getEmployeePayElement(Integer commonId) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(HrEmployeePayElements.class);
		criteria = criteria.add(Restrictions.eq("Id", commonId));
		List employeePayElementList = criteria.list();
		HrEmployeePayElements employeePayElement = (HrEmployeePayElements) employeePayElementList
				.get(0);
		return employeePayElement;
	}

	public Map showEmployeeExitInterviewJsp() {
		Map map = new HashMap();
		return map;
	}

	public HrEmployeePayStructure getEmployeePayStructure(Integer payStructureId) {
		Session session = getSession();
		Criteria criteria = session
				.createCriteria(HrEmployeePayStructure.class);
		criteria = criteria.add(Restrictions.eq("Id", payStructureId));
		List employeePayStructureList = criteria.list();
		HrEmployeePayStructure employeePayStructure = (HrEmployeePayStructure) employeePayStructureList
				.get(0);
		return employeePayStructure;
	}

	public Map showEmployeePerformanceReviewJsp(Map parameterMap) {
		Map map = new HashMap<String, Object>();
		MasHospital hospital = null;

		if (parameterMap != null && parameterMap.get("hospital") != null) {
			hospital = (MasHospital) parameterMap.get("hospital");
		}

		Criteria criteria = getSession().createCriteria(MasEmployee.class);
		if (hospital != null) {
			criteria = criteria.add(Restrictions.eq("Hospital.Id",
					hospital.getId()));
		}
		criteria = criteria.addOrder(Order.asc("FirstName"));

		List employeeListForSearch = criteria.list();
		map.put("employeeListForSearch", employeeListForSearch);

		criteria = criteria.add(Restrictions.eq("Status", "y"));
		List employeeList = criteria.list();
		map.put("employeeList", employeeList);

		// ---------employee Perfromance review list----
		criteria = getSession().createCriteria(
				HrEmployeePerformanceReview.class);
		if (hospital != null) {
			criteria = criteria.add(Restrictions.eq("Company.Id",
					hospital.getId()));
		}

		List searchEmpPerformanceReviewList = criteria.list();
		map.put("searchEmpPerformanceReviewList",
				searchEmpPerformanceReviewList);

		// --------------performncae review Rating List
		criteria = getSession()
				.createCriteria(HrPerformanceReviewRatings.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		if (hospital != null) {
			criteria = criteria.add(Restrictions.eq("Company.Id",
					hospital.getId()));
		}

		List performanceReviewRatingsList = criteria.list();
		map.put("performanceReviewRatingsList", performanceReviewRatingsList);

		return map;

	}

	public void addOrUpdateEmployeePerformanceReview(
			HrEmployeePerformanceReview performanceReview) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(performanceReview);
		hbt.refresh(performanceReview);
	}

	public Map<String, Object> searchEmployeePerformanceReview(Map parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer employeeId = null;

		if (parameterMap.get("employeeId") != null) {
			employeeId = (Integer) parameterMap.get("employeeId");
		}
		List<HrEmployeePerformanceReview> searchEmpPerformanceReviewList = new ArrayList<HrEmployeePerformanceReview>();

		Session session = getSession();
		Criteria criteria = session
				.createCriteria(HrEmployeePerformanceReview.class);
		criteria = criteria.add(Restrictions.eq("Employee.Id", employeeId));
		searchEmpPerformanceReviewList = criteria.list();
		map = showEmployeePerformanceReviewJsp(parameterMap);
		map.put("searchEmpPerformanceReviewList",
				searchEmpPerformanceReviewList);
		return map;

	}

	public HrEmployeePerformanceReview getEmployeePerformanceReview(
			Integer commonId) {
		HrEmployeePerformanceReview performanceReview = (HrEmployeePerformanceReview) getHibernateTemplate()
				.load(HrEmployeePerformanceReview.class, commonId);
		return performanceReview;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteEmployeePerformanceReview(
			int employeePerformanceReview, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrEmployeePerformanceReview hrEmployeePerformanceReview = new HrEmployeePerformanceReview();
			hrEmployeePerformanceReview = (HrEmployeePerformanceReview) getHibernateTemplate()
					.load(HrEmployeePerformanceReview.class,
							employeePerformanceReview);
			Integer employeecodeId = hrEmployeePerformanceReview.getEmployee()
					.getId();

			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrEmployeePerformanceReview.getStatus().equals("y")) {
				@SuppressWarnings("unused")
				List employeecodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee as employee where employee.Id='"
								+ employeecodeId + "' and employee.Status='y'");
				hrEmployeePerformanceReview.setStatus("n");
				dataDeleted = true;
			} else {
				hrEmployeePerformanceReview.setStatus("y");
				dataDeleted = false;
			}
			hrEmployeePerformanceReview.setLastChgBy(changedBy);
			hrEmployeePerformanceReview.setLastChgDate(null);
			hrEmployeePerformanceReview.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrEmployeePerformanceReview);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map showEmployeeExitInterviewJsp(Map parameterMap) {
		Map map = new HashMap<String, Object>();
		MasHospital hospital = null;
		Session session = (Session) getSession();
		if (parameterMap != null && parameterMap.get("hospital") != null) {
			hospital = (MasHospital) parameterMap.get("hospital");
		}

		// Employee List------------------------
		List employeeList = new ArrayList();
		Criteria criteria = session.createCriteria(MasEmployee.class);
		employeeList = criteria.list();

		map.put("employeeList", employeeList);

		return map;
	}

	public void addOrUpdateEmployeeExitInterview(
			HrEmployeeExitInterview exitInterview) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(exitInterview);
	}

	public void addOrUpdateExitInterviewAnswers(
			List<HrExitInterviewAnswers> exitInterviewAnswersList) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdateAll(exitInterviewAnswersList);
		hbt.flush();

	}

	public void addUserManager(UserManager userManager) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		try {
			if (userManager.getManagerId() == null
					&& userManager.getId() != null) {
				hbt.delete(userManager);
			} else {
				hbt.saveOrUpdate(userManager);
			}
			hbt.flush();
			// hbt.refresh(userManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MasEmployee> getSubordinatesList(Integer employeeId) {
		Criteria criteria = getSession().createCriteria(UserManager.class);
		criteria = criteria.add(Restrictions.eq("managers.Id", employeeId));
		List<UserManager> userManagerList = criteria.list();
		List<MasEmployee> subordinatesList = new ArrayList();
		for (UserManager manager : userManagerList) {
			subordinatesList.add(manager.getUsers());
		}
		return subordinatesList;
	}

	// ---------------------------------- Item
	// Category-------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showLocationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<MasLocation> searchLocationList = new ArrayList<MasLocation>();

			searchLocationList = getHibernateTemplate().find(
					"from jkt.hrms.masters.business.MasLocation ");

			map.put("searchLocationList", searchLocationList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean addLocation(MasLocation masLocation) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masLocation);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteLocation(int locationId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasLocation masLocation = new MasLocation();
			masLocation = (MasLocation) getHibernateTemplate().load(
					MasLocation.class, locationId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			// Integer sectionId = masItemCategory.getSection().getId();

			if (generalMap.get("flag") != null) {
				// List sectionCodeList = getHibernateTemplate().find("from
				// jkt.hms.masters.business.MasStoreSection as a where
				// a.Id='"+sectionId+"' and a.Status='y'");
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masLocation.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masLocation.setStatus("y");
					dataDeleted = false;
				}
			}
			masLocation.setLastChgBy(changedBy);
			masLocation.setLastChgDate(currentDate);
			masLocation.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public boolean editLocationToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int sectionId = 0;
		String itemCategoryName = "";
		@SuppressWarnings("unused")
		String itemCategoryCode = "";
		int itemCategoryId = 0;
		String changedBy = "";
		itemCategoryId = (Integer) generalMap.get("id");
		itemCategoryCode = (String) generalMap.get("itemCategoryCode");
		int hospitalId = 0;
		hospitalId = (Integer) generalMap.get("hospitalId");
		itemCategoryName = (String) generalMap.get("name");
		// sectionId = (Integer)generalMap.get("sectionId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasLocation masLocation = (MasLocation) getHibernateTemplate().load(
				MasLocation.class, itemCategoryId);

		masLocation.setId(itemCategoryId);
		masLocation.setLocationName(itemCategoryName);
		masLocation.setCompany(new MasHospital(hospitalId));
		masLocation.setLastChgBy(changedBy);
		masLocation.setLastChgDate(currentDate);
		masLocation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masLocation);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map searchLocation(String itemCategoryCode, String itemCategoryName) {
		List<MasLocation> searchLocationList = new ArrayList<MasLocation>();

		Map itemCategoryFieldsMap = new HashMap();
		List gridSectionList = null;
		try {
			if ((itemCategoryName != null) || (itemCategoryCode == null)) {
				searchLocationList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.MasLocation sc where lower(sc.LocationName) like '"
								+ itemCategoryName.toLowerCase()
								+ "%' order by sc.LocationName");
			} else {
				searchLocationList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.MasLocation sc where lower(sc.LocationCode) like '"
								+ itemCategoryCode.toLowerCase()
								+ "%' order by sc.LocationCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		itemCategoryFieldsMap.put("searchLocationList", searchLocationList);

		return itemCategoryFieldsMap;

	}

	public Map<String, Object> addEmployeeCategory(MasEmpCategory masEmpCategory) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		List<MasEmpCategory> existingMasEmpCategoryList = new ArrayList<MasEmpCategory>();
		Session session = (Session) getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String empCategoryCode = masEmpCategory.getEmpCategoryCode();
		String empCategoryName = masEmpCategory.getEmpCategoryName();
		existingMasEmpCategoryList = session
				.createCriteria(MasEmpCategory.class)
				.add(Restrictions.eq("EmpCategoryCode", empCategoryCode))
				.add(Restrictions.eq("EmpCategoryName", empCategoryName))
				.list();
		if (existingMasEmpCategoryList.size() > 0) {
			message = "Record already Exist";
		} else {
			hbt.save(masEmpCategory);
			message = "Record saved sucessfully!";

		}
		masEmpCategoryList = session.createCriteria(MasEmpCategory.class)
				.list();
		map.put("message", message);
		map.put("masEmpCategoryList", masEmpCategoryList);
		return map;
	}

	public Map<String, Object> showEmployeeCategory() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		masEmpCategoryList = session.createCriteria(MasEmpCategory.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		map.put("masEmpCategoryList", masEmpCategoryList);
		return map;
	}

	public Map<String, Object> editEmployeeCategory(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		List<MasEmpCategory> existingMasEmpCategoryList = new ArrayList<MasEmpCategory>();

		Session session = (Session) getSession();
		int empCategoryId = 0;
		if (generalMap.get("empCategoryId") != null) {
			empCategoryId = (Integer) generalMap.get("empCategoryId");
		}
		String empCategoryCode = "";
		if (generalMap.get("empCategoryCode") != null) {
			empCategoryCode = (String) generalMap.get("empCategoryCode");
		}
		String empCategoryName = "";
		if (generalMap.get("empCategoryName") != null) {
			empCategoryName = (String) generalMap.get("empCategoryName");
		}
		String empCategoryDesc = "";
		if (generalMap.get("empCategoryDesc") != null) {
			empCategoryDesc = (String) generalMap.get("empCategoryDesc");
		}
		Users changedBy = null;
		if (generalMap.get("changedBy") != null) {
			changedBy = (Users) generalMap.get("changedBy");
		}
		Date currentDate = null;
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasEmpCategory masEmpCategory = (MasEmpCategory) hbt.load(
				MasEmpCategory.class, empCategoryId);
		masEmpCategory.setEmpCategoryCode(empCategoryCode);
		masEmpCategory.setEmpCategoryName(empCategoryName);
		masEmpCategory.setEmpCategoryDesc(empCategoryDesc);
		masEmpCategory.setLastChgBy(changedBy);
		masEmpCategory.setLastChgDate(currentDate);
		masEmpCategory.setLastChgTime(currentTime);
		// existingPayrollList =
		// session.createCriteria(HrMasPayroll.class).add(Restrictions.eq("PayrollCode",
		// payrollCode)) .add(Restrictions.eq("PayrollDescription",
		// payrollDescription)).list();
		existingMasEmpCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmpCategory as category where category.EmpCategoryCode = ?"
						+ " and category.EmpCategoryName = ?"
						+ " and category.Id != ?",empCategoryCode, empCategoryName,empCategoryId);
		String message = "";
		if (existingMasEmpCategoryList.size() > 0) {
			message = "Record already exist";
		} else {
			System.out.println("yes");
			hbt.update(masEmpCategory);
			// hbt.refresh(hrMasPayroll);
			message = "Record update successfully";
		}
		masEmpCategoryList = session.createCriteria(MasEmpCategory.class)
				.list();
		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> deleteEmployeeCategory(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int empCategoryId = 0;
		if (generalMap.get("empCategoryId") != null) {
			empCategoryId = (Integer) generalMap.get("empCategoryId");
		}
		Users changedBy = null;
		if (generalMap.get("changedBy") != null) {
			changedBy = (Users) generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasEmpCategory masEmpCategory = (MasEmpCategory) hbt.load(
				MasEmpCategory.class, empCategoryId);
		masEmpCategory.setLastChgBy(changedBy);
		masEmpCategory.setLastChgDate(currentDate);
		masEmpCategory.setLastChgTime(currentTime);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masEmpCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masEmpCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(masEmpCategory);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		masEmpCategoryList = session.createCriteria(MasEmpCategory.class)
				.list();
		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> searchEmpCategory(String empCategoryCode,
			String empCategoryName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		Session session = (Session) getSession();
		try {
			if ((empCategoryCode == null) || (empCategoryName != null)) {

				masEmpCategoryList = session
						.createCriteria(MasEmpCategory.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.like("EmpCategoryName",
								empCategoryName + "%").ignoreCase())
						.addOrder(Property.forName("EmpCategoryName").asc())
						.list();
			} else {
				masEmpCategoryList = session
						.createCriteria(MasEmpCategory.class)
						.add(Restrictions.like("EmpCategoryCode",
								empCategoryCode + "%"))
						.addOrder(Property.forName("EmpCategoryCode").asc())
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("empCategoryCode", empCategoryCode);
		map.put("empCategoryName", empCategoryName);
		return map;
	}

	public Map<String, Object> generateReportForEmployeeInformationExcel(
			Map<String, Object> mapForDs) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<Integer, Object> headingMap = new HashMap<Integer, Object>();
		String hospitalName = "";

		int counter = 0;
		// int columnCount = 1;
		int columnNo = 1;

		if (mapForDs.get("counter") != null) {
			counter = (Integer) mapForDs.get("counter");
		}
		if (mapForDs.get("headingMap") != null) {
			headingMap = (Map<Integer, Object>) mapForDs.get("headingMap");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();

		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("EmployeeReport");

			// Create a new font and alter it.
			HSSFFont fontSmallHeading = wb.createFont();
			fontSmallHeading.setFontHeightInPoints((short) 10);
			fontSmallHeading.setFontName(HSSFFont.FONT_ARIAL);
			fontSmallHeading.setColor((short) 80);
			fontSmallHeading.setItalic(false);
			fontSmallHeading.setStrikeout(false);
			fontSmallHeading.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont fontNormalText = wb.createFont();
			fontNormalText.setFontHeightInPoints((short) 10);
			fontNormalText.setFontName(HSSFFont.FONT_ARIAL);
			fontNormalText.setColor((short) 80);
			fontNormalText.setItalic(false);
			fontNormalText.setStrikeout(false);
			// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont fontHeading = wb.createFont();
			fontHeading.setFontHeightInPoints((short) 12);
			fontHeading.setFontName(HSSFFont.FONT_ARIAL);
			fontHeading.setColor((short) 80);
			fontHeading.setItalic(false);
			fontHeading.setStrikeout(false);
			fontHeading.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle styleNormal = wb.createCellStyle();
			styleNormal.setFont(fontNormalText);
			styleNormal.setAlignment((short) 2);

			HSSFCellStyle styleSmallHeading = wb.createCellStyle();
			styleSmallHeading.setFont(fontSmallHeading);
			styleSmallHeading.setAlignment((short) 2);

			HSSFCellStyle styleHeadings = wb.createCellStyle();
			styleHeadings.setFont(fontHeading);
			styleHeadings.setAlignment((short) 2);

			if (employeeList.size() > 0) {
				hospitalName = employeeList.get(0).getHospital()
						.getHospitalName();

				HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell cellhospitalName = row2.createCell((short) 3);
				cellhospitalName.setCellValue(new HSSFRichTextString(
						hospitalName));
				cellhospitalName.setCellStyle(styleHeadings);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

				HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cellHeadingMain = row3.createCell((short) 3);
				cellHeadingMain.setCellValue(new HSSFRichTextString(
						"Employee Details Report"));
				cellHeadingMain.setCellStyle(styleHeadings);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

				HSSFRow row5 = sheet.createRow((short) 5);
				for (int i = 1; i <= counter; i++) {
					String column1 = (String) headingMap.get(i);
					if (!column1.equals("")) {
						HSSFCell cell = row5.createCell((short) columnNo);
						cell.setCellValue(new HSSFRichTextString(column1));
						cell.setCellStyle(styleSmallHeading);
						// sheet.setautoSizeColumn( columnNo );
						columnNo++;
					}
				}

				short rowNo = 6;
				for (MasEmployee employee : employeeList) {
					HSSFRow row = sheet.createRow(rowNo);
					Set<HrEmployeePayElements> empPayElements = employee
							.getPayElements();
					List<HrMasEmployeeEducation> educationList = new ArrayList<HrMasEmployeeEducation>();
					educationList.addAll(employee.getEmployeeEducation());
					Collections.sort(educationList,
							new EmployeeEducationComparator());
					Integer educationListSize = educationList.size();
					columnNo = 1;
					double totalBasicHraAndAddition = 0;
					double totalReimbursement = 0;
					double totalPerMonth = 0;
					double totalPerAnnum = 0;

					for (int i = 1; i <= counter; i++) {
						String column1 = (String) headingMap.get(i);
						if (!column1.equals("")) {
							switch (i) {
							case 1:
								HSSFCell cell1 = row
										.createCell((short) columnNo);
								cell1.setCellValue(new HSSFRichTextString(
										employee.getEmployeeCode()));

								columnNo++;
								break;

							case 2:
								HSSFCell cell2 = row
										.createCell((short) columnNo);
								cell2.setCellValue(new HSSFRichTextString(
										employee.getTitle().getTitleName()));

								columnNo++;
								break;

							case 3:
								HSSFCell cell3 = row
										.createCell((short) columnNo);
								cell3.setCellValue(new HSSFRichTextString(
										employee.getFirstName()));

								columnNo++;
								break;

							case 4:
								HSSFCell cell4 = row
										.createCell((short) columnNo);
								cell4.setCellValue(new HSSFRichTextString(
										employee.getMiddleName()));

								columnNo++;
								break;

							case 5:
								HSSFCell cell5 = row
										.createCell((short) columnNo);
								cell5.setCellValue(new HSSFRichTextString(
										employee.getLastName()));

								columnNo++;
								break;

							case 6:
								HSSFCell cell6 = row
										.createCell((short) columnNo);
								cell6.setCellValue(new HSSFRichTextString(
										employee.getDepartment()
												.getDepartmentName()));

								columnNo++;
								break;

							case 7:
								HSSFCell cell7 = row
										.createCell((short) columnNo);
								// cell7.setCellValue(new
								// HSSFRichTextString(employee.getLocation().getLocationName()));
								cell7.setCellValue(new HSSFRichTextString(""));

								columnNo++;
								break;

							case 8:
								HSSFCell cell8 = row
										.createCell((short) columnNo);
								cell8.setCellValue(new HSSFRichTextString(
										employee.getLineManager()
												.getFirstName()
												+ " "
												+ employee.getLineManager()
														.getMiddleName()
												+ " "
												+ employee.getLineManager()
														.getLastName()));

								columnNo++;
								break;

							case 9:
								HSSFCell cell9 = row
										.createCell((short) columnNo);
								cell9.setCellValue(new HSSFRichTextString(
										employee.getLineManager()
												.getEmployeeCode()));

								columnNo++;
								break;

							case 10:
								HSSFCell cell10 = row
										.createCell((short) columnNo);
								String designation = "";
								if (employee.getRank() != null) {
									designation = employee.getRank()
											.getRankName();
								}
								cell10.setCellValue(new HSSFRichTextString(
										designation));

								columnNo++;
								break;

							case 11:
								HSSFCell cell11 = row
										.createCell((short) columnNo);
								String equivalentDesignation = "";
								if (employee.getEquivalentDesignation() != null) {
									equivalentDesignation = employee
											.getEquivalentDesignation();
								}
								cell11.setCellValue(new HSSFRichTextString(
										equivalentDesignation));

								columnNo++;
								break;

							case 12:
								HSSFCell cell12 = row
										.createCell((short) columnNo);
								String gender = "";
								// if(employee.getEmployeePersonalDetails() !=
								// null
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getGender() != null) {
									gender = employee.getPersonalDetails()
											.getGender()
											.getAdministrativeSexName();
								}
								cell12.setCellValue(new HSSFRichTextString(
										gender));

								columnNo++;
								break;

							case 13:
								HSSFCell cell13 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getDateOfBirth() != null) {
									cell13.setCellValue(new HSSFRichTextString(
											sdf.format(employee
													.getPersonalDetails()
													.getDateOfBirth())));
								}

								columnNo++;
								break;

							case 14:
								HSSFCell cell14 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null) {
									cell14.setCellValue(new HSSFRichTextString(
											employee.getPersonalDetails()
													.getPassportNo()));
								}

								columnNo++;
								break;

							case 15:
								HSSFCell cell15 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getPassportIssueDate() != null) {
									cell15.setCellValue(new HSSFRichTextString(
											sdf.format(employee
													.getPersonalDetails()
													.getPassportIssueDate())));
								}

								columnNo++;
								break;

							case 16:
								HSSFCell cell16 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getPassportExpiryDate() != null) {
									cell16.setCellValue(new HSSFRichTextString(
											sdf.format(employee
													.getPersonalDetails()
													.getPassportExpiryDate())));
								}

								columnNo++;
								break;

							case 17:
								HSSFCell cell17 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getPassportIssuePlace() != null) {
									cell17.setCellValue(new HSSFRichTextString(
											employee.getPersonalDetails()
													.getPassportIssuePlace()));
								}

								columnNo++;
								break;

							case 18:
								HSSFCell cell18 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getVisaDetails() != null) {
									cell18.setCellValue(new HSSFRichTextString(
											employee.getPersonalDetails()
													.getVisaDetails()));
								}

								columnNo++;
								break;

							case 19:
								HSSFCell cell19 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getPanNo() != null) {
									cell19.setCellValue(new HSSFRichTextString(
											employee.getPersonalDetails()
													.getPanNo()));
								}

								columnNo++;
								break;

							case 20:
								HSSFCell cell20 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getDrivingLicence() != null) {
									cell20.setCellValue(new HSSFRichTextString(
											employee.getPersonalDetails()
													.getDrivingLicence()));
								}

								columnNo++;
								break;

							case 21:
								HSSFCell cell21 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getMaritalStatus() != null) {
									cell21.setCellValue(new HSSFRichTextString(
											employee.getPersonalDetails()
													.getMaritalStatus()
													.getMaritalStatusName()));
								}

								columnNo++;
								break;

							case 22:
								HSSFCell cell22 = row
										.createCell((short) columnNo);
								if (employee.getPersonalDetails() != null
										&& employee.getPersonalDetails()
												.getMarriageDate() != null) {
									cell22.setCellValue(new HSSFRichTextString(
											sdf.format(employee
													.getPersonalDetails()
													.getMarriageDate())));
								}

								columnNo++;
								break;

							case 23:
								HSSFCell cell23 = row
										.createCell((short) columnNo);
								if (employee.getBankCode() != null
										&& employee.getBankCode() != null) {
									cell23.setCellValue(new HSSFRichTextString(
											employee.getBankCode()));
								}

								columnNo++;
								break;

							case 24:
								HSSFCell cell24 = row
										.createCell((short) columnNo);
								if (employee.getBankAccountCode() != null) {
									cell24.setCellValue(new HSSFRichTextString(
											employee.getBankAccountCode()));
								}

								columnNo++;
								break;

							case 25:
								HSSFCell cell25 = row
										.createCell((short) columnNo);
								if (employee.getBankAccountNumber() != null) {
									cell25.setCellValue(new HSSFRichTextString(
											employee.getBankAccountNumber()));
								}

								columnNo++;
								break;

							case 26:
								HSSFCell cell26 = row
										.createCell((short) columnNo);
								if (employee.getAccountHead() != null) {
									cell26.setCellValue(new HSSFRichTextString(
											employee.getAccountHead()));
								}

								columnNo++;
								break;

							case 27:
								HSSFCell cell27 = row
										.createCell((short) columnNo);
								if (employee.getPermanentAddress() != null) {
									cell27.setCellValue(new HSSFRichTextString(
											employee.getPermanentAddress()));
								}

								columnNo++;
								break;

							case 28:
								HSSFCell cell28 = row
										.createCell((short) columnNo);
								if (employee.getResidentialAddress() != null) {
									cell28.setCellValue(new HSSFRichTextString(
											employee.getResidentialAddress()));
								}

								columnNo++;
								break;

							case 29:
								HSSFCell cell29 = row
										.createCell((short) columnNo);
								if (employee.getCellNoEmergency() != null) {
									cell29.setCellValue(new HSSFRichTextString(
											employee.getCellNoEmergency()));
								}

								columnNo++;
								break;

							case 30:
								HSSFCell cell30 = row
										.createCell((short) columnNo);
								if (employee.getTelNoOffice() != null) {
									cell30.setCellValue(new HSSFRichTextString(
											employee.getTelNoOffice()));
								}

								columnNo++;
								break;

							case 31:
								HSSFCell cell31 = row
										.createCell((short) columnNo);
								if (employee.getTelNoResidence() != null) {
									cell31.setCellValue(new HSSFRichTextString(
											employee.getTelNoResidence()));
								}

								columnNo++;
								break;

							case 32:
								HSSFCell cell32 = row
										.createCell((short) columnNo);
								if (employee.getEmail() != null) {
									cell32.setCellValue(new HSSFRichTextString(
											employee.getEmail()));
								}

								columnNo++;
								break;

							case 33:
								HSSFCell cell33 = row
										.createCell((short) columnNo);
								/*
								 * if(){
								 * 
								 * 
								 * }
								 */
								// if(employee.getEmployeeEducation().){

								// }
								cell33.setCellValue(new HSSFRichTextString(""));

								columnNo++;
								break;

							case 34:
								HSSFCell cell34 = row
										.createCell((short) columnNo);
								String qualificationObtained1 = "";
								if (educationListSize >= 1
										&& educationList.get(0)
												.getQualification() != null) {
									qualificationObtained1 = educationList
											.get(0).getQualification()
											.getQualificationName();
								}
								cell34.setCellValue(new HSSFRichTextString(
										qualificationObtained1));

								columnNo++;
								break;

							case 35:
								HSSFCell cell35 = row
										.createCell((short) columnNo);
								String institute1 = "";
								if (educationListSize >= 1
										&& educationList.get(0).getInstitute() != null) {
									institute1 = educationList.get(0)
											.getInstitute().getInstituteName();
								}
								cell35.setCellValue(new HSSFRichTextString(
										institute1));

								columnNo++;
								break;

							case 36:
								HSSFCell cell36 = row
										.createCell((short) columnNo);
								String qualificationObtained2 = "";
								if (educationListSize >= 2
										&& educationList.get(1)
												.getQualification() != null) {
									qualificationObtained2 = educationList
											.get(1).getQualification()
											.getQualificationName();
								}
								cell36.setCellValue(new HSSFRichTextString(
										qualificationObtained2));

								columnNo++;
								break;

							case 37:
								HSSFCell cell37 = row
										.createCell((short) columnNo);
								String institute2 = "";
								if (educationListSize >= 2
										&& educationList.get(1).getInstitute() != null) {
									institute2 = educationList.get(1)
											.getInstitute().getInstituteName();
								}
								cell37.setCellValue(new HSSFRichTextString(
										institute2));

								columnNo++;
								break;

							case 38:
								HSSFCell cell38 = row
										.createCell((short) columnNo);
								String qualificationObtained3 = "";
								if (educationListSize >= 3
										&& educationList.get(2)
												.getQualification() != null) {
									qualificationObtained3 = educationList
											.get(2).getQualification()
											.getQualificationName();
								}
								cell38.setCellValue(new HSSFRichTextString(
										qualificationObtained3));

								columnNo++;
								break;

							case 39:
								HSSFCell cell39 = row
										.createCell((short) columnNo);
								String institute3 = "";
								if (educationListSize >= 3
										&& educationList.get(2).getInstitute() != null) {
									institute3 = educationList.get(2)
											.getInstitute().getInstituteName();
								}
								cell39.setCellValue(new HSSFRichTextString(
										institute3));

								columnNo++;
								break;

							case 40:
								HSSFCell cell40 = row
										.createCell((short) columnNo);
								String prevEmployee = "";
								/*
								 * if(employee.getEmployeeExperience() != null
								 * && employee.getEmployeeExperience().
								 * getPreviousEmployer() != null){ prevEmployee
								 * = employee.getEmployeeExperience().
								 * getPreviousEmployer(); }
								 */
								cell40.setCellValue(new HSSFRichTextString(
										prevEmployee));

								columnNo++;
								break;

							case 41:
								HSSFCell cell41 = row
										.createCell((short) columnNo);
								String prevDesignation = "";
								/*
								 * if(employee.getEmployeeExperience() != null
								 * &&
								 * employee.getEmployeeExperience().getDesignation
								 * () != null){ prevDesignation =
								 * employee.getEmployeeExperience
								 * ().getDesignation(); }
								 */
								cell41.setCellValue(new HSSFRichTextString(
										prevDesignation));

								columnNo++;
								break;

							case 42:
								HSSFCell cell42 = row
										.createCell((short) columnNo);
								String handicapStatus = "";
								if (employee.getHandicapStatus() != null) {
									handicapStatus = employee
											.getHandicapStatus();
								}
								cell42.setCellValue(new HSSFRichTextString(
										handicapStatus));

								columnNo++;
								break;

							case 43:
								HSSFCell cell43 = row
										.createCell((short) columnNo);
								Date currentDate = new Date();
								// Show Basic
								Set<HrEmployeePayStructure> empPayStructure = employee
										.getPayStructure();
								for (HrEmployeePayStructure payStructure : empPayStructure) {
									if (currentDate.compareTo(payStructure
											.getFromDate()) > 0
											&& currentDate
													.compareTo(payStructure
															.getToDate()) < 0) {
										cell43.setCellValue(payStructure
												.getBasicPay().doubleValue());
										totalBasicHraAndAddition += payStructure
												.getBasicPay().doubleValue();
										// totalBasicHraAndAddition.add(payStructure.getBasicPay());
									}
								}

								columnNo++;
								break;

							case 44:
								HSSFCell cell44 = row
										.createCell((short) columnNo);
								// Show Hra
								for (HrEmployeePayElements payElements : empPayElements) {
									if (payElements.getStatus() != null
											&& payElements.getStatus().equals(
													"y")
											&& payElements.getPayElement()
													.getId() == 1
											&& payElements.getPayAmount() != null) {
										cell44.setCellValue(payElements
												.getPayAmount().doubleValue());
										totalBasicHraAndAddition += payElements
												.getPayAmount().doubleValue();
										// totalBasicHraAndAddition.add(payElements.getPayAmount());
									}
								}

								columnNo++;
								break;

							case 45:
								HSSFCell cell45 = row
										.createCell((short) columnNo);
								// Show Special Allowances
								for (HrEmployeePayElements payElements : empPayElements) {
									if (payElements.getStatus() != null
											&& payElements.getStatus().equals(
													"y")
											&& payElements.getPayElement()
													.getId() == 2
											&& payElements.getPayAmount() != null) {
										cell45.setCellValue(payElements
												.getPayAmount().doubleValue());
										totalBasicHraAndAddition += payElements
												.getPayAmount().doubleValue();
										// totalBasicHraAndAddition.add(payElements.getPayAmount());
									}
								}

								columnNo++;
								break;

							case 46:
								HSSFCell cell46 = row
										.createCell((short) columnNo);
								// Show P.Pay Against Benefit in Kinds
								for (HrEmployeePayElements payElements : empPayElements) {
									if (payElements.getStatus() != null
											&& payElements.getStatus().equals(
													"y")
											&& payElements.getPayElement()
													.getId() == 3
											&& payElements.getPayAmount() != null) {
										cell46.setCellValue(payElements
												.getPayAmount().doubleValue());
										totalBasicHraAndAddition += payElements
												.getPayAmount().doubleValue();
										// totalBasicHraAndAddition.add(payElements.getPayAmount());
									}
								}

								columnNo++;
								break;

							case 47:
								HSSFCell cell47 = row
										.createCell((short) columnNo);
								// Show P.A Against HRA
								for (HrEmployeePayElements payElements : empPayElements) {
									if (payElements.getStatus() != null
											&& payElements.getStatus().equals(
													"y")
											&& payElements.getPayElement()
													.getId() == 16
											&& payElements.getPayAmount() != null) {
										cell47.setCellValue(payElements
												.getPayAmount().doubleValue());
										totalBasicHraAndAddition += payElements
												.getPayAmount().doubleValue();
										// totalBasicHraAndAddition.add(payElements.getPayAmount());
									}
								}

								columnNo++;
								break;

							case 48:
								HSSFCell cell48 = row
										.createCell((short) columnNo);
								cell48.setCellValue(totalBasicHraAndAddition);

								columnNo++;
								break;

							case 49:
								HSSFCell cell49 = row
										.createCell((short) columnNo);
								// Show Reimbursement conveyance
								for (HrEmployeePayElements payElements : empPayElements) {
									if (payElements.getStatus() != null
											&& payElements.getStatus().equals(
													"y")
											&& payElements.getPayElement()
													.getId() == 4
											&& payElements.getPayAmount() != null) {
										cell49.setCellValue(payElements
												.getPayAmount().doubleValue());
										totalReimbursement += payElements
												.getPayAmount().doubleValue();
										// totalReimbursement.add(payElements.getPayAmount());
									}
								}

								columnNo++;
								break;

							case 50:
								HSSFCell cell50 = row
										.createCell((short) columnNo);
								// Show Reimbursement medical
								for (HrEmployeePayElements payElements : empPayElements) {
									if (payElements.getStatus() != null
											&& payElements.getStatus().equals(
													"y")
											&& payElements.getPayElement()
													.getId() == 5
											&& payElements.getPayAmount() != null) {
										cell50.setCellValue(payElements
												.getPayAmount().doubleValue());
										totalReimbursement += payElements
												.getPayAmount().doubleValue();
										// totalReimbursement.add(payElements.getPayAmount());
									}
								}

								columnNo++;
								break;

							case 51:
								HSSFCell cell51 = row
										.createCell((short) columnNo);
								// Show Reimbursement LTA
								for (HrEmployeePayElements payElements : empPayElements) {
									if (payElements.getStatus() != null
											&& payElements.getStatus().equals(
													"y")
											&& payElements.getPayElement()
													.getId() == 6
											&& payElements.getPayAmount() != null) {
										cell51.setCellValue(payElements
												.getPayAmount().doubleValue());
										totalReimbursement += payElements
												.getPayAmount().doubleValue();
										// totalReimbursement.add(payElements.getPayAmount());
									}
								}

								columnNo++;
								break;

							case 52:
								HSSFCell cell52 = row
										.createCell((short) columnNo);
								// Show Reimbursement Meal Voucher
								for (HrEmployeePayElements payElements : empPayElements) {
									if (payElements.getStatus() != null
											&& payElements.getStatus().equals(
													"y")
											&& payElements.getPayElement()
													.getId() == 7
											&& payElements.getPayAmount() != null) {
										cell52.setCellValue(payElements
												.getPayAmount().doubleValue());
										totalReimbursement += payElements
												.getPayAmount().doubleValue();
										// totalReimbursement.add(payElements.getPayAmount());
									}
								}

								columnNo++;
								break;

							case 53:
								HSSFCell cell53 = row
										.createCell((short) columnNo);
								// Show Reimbursement Total
								cell53.setCellValue(totalReimbursement);

								columnNo++;
								break;

							/*
							 * case 54: HSSFCell cell54 = row.createCell((short)
							 * columnNo); //Show Retirement Benefit P.F
							 * for(HrEmployeePayElements payElements :
							 * empPayElements){ if(payElements.getStatus() !=
							 * null && payElements.getStatus().equals("y") &&
							 * payElements.getPayElement().getId() == 7){
							 * cell54.
							 * setCellValue(payElements.getPayAmount().doubleValue
							 * ());
							 * totalReimbursement.add(payElements.getPayAmount
							 * ()); } }
							 * 
							 * columnNo++; break;
							 * 
							 * case 55: HSSFCell cell55 = row.createCell((short)
							 * columnNo); //Show Retirement Benefit P.F
							 * for(HrEmployeePayElements payElements :
							 * empPayElements){ if(payElements.getStatus() !=
							 * null && payElements.getStatus().equals("y") &&
							 * payElements.getPayElement().getId() == 7){
							 * cell55.
							 * setCellValue(payElements.getPayAmount().doubleValue
							 * ());
							 * totalReimbursement.add(payElements.getPayAmount
							 * ()); } }
							 * 
							 * columnNo++; break;
							 * 
							 * case 56: HSSFCell cell56 = row.createCell((short)
							 * columnNo); //Show Retirement Benefit P.F
							 * for(HrEmployeePayElements payElements :
							 * empPayElements){ if(payElements.getStatus() !=
							 * null && payElements.getStatus().equals("y") &&
							 * payElements.getPayElement().getId() == 7){
							 * cell56.
							 * setCellValue(payElements.getPayAmount().doubleValue
							 * ());
							 * totalReimbursement.add(payElements.getPayAmount
							 * ()); } }
							 * 
							 * columnNo++; break;
							 * 
							 * case 57: HSSFCell cell57 = row.createCell((short)
							 * columnNo); //Show Retiral Benefits Total
							 * for(HrEmployeePayElements payElements :
							 * empPayElements){ if(payElements.getStatus() !=
							 * null && payElements.getStatus().equals("y") &&
							 * payElements.getPayElement().getId() == 7){
							 * cell57.
							 * setCellValue(payElements.getPayAmount().doubleValue
							 * ());
							 * totalReimbursement.add(payElements.getPayAmount
							 * ()); } }
							 * 
							 * columnNo++; break;
							 */

							case 54:
								HSSFCell cell54 = row
										.createCell((short) columnNo);
								totalPerMonth = totalBasicHraAndAddition
										+ totalReimbursement;

								cell54.setCellValue(totalPerMonth);

								columnNo++;
								break;

							case 55:
								HSSFCell cell55 = row
										.createCell((short) columnNo);
								totalPerAnnum = totalPerMonth * 12;
								cell55.setCellValue(totalPerAnnum);

								columnNo++;
								break;
							/*
							 * case 60: HSSFCell cell60 = row.createCell((short)
							 * columnNo); cell60.setCellValue(new
							 * HSSFRichTextString(employee.getEmployeeCode()));
							 * 
							 * columnNo++; break;
							 * 
							 * case 61: HSSFCell cell61 = row.createCell((short)
							 * columnNo); cell61.setCellValue(new
							 * HSSFRichTextString(employee.getEmployeeCode()));
							 * 
							 * columnNo++; break;
							 * 
							 * case 62: HSSFCell cell62 = row.createCell((short)
							 * columnNo); cell62.setCellValue(new
							 * HSSFRichTextString(employee.getEmployeeCode()));
							 * 
							 * columnNo++; break;
							 * 
							 * case 63: HSSFCell cell63 = row.createCell((short)
							 * columnNo); cell63.setCellValue(new
							 * HSSFRichTextString(employee.getEmployeeCode()));
							 * 
							 * columnNo++; break;
							 * 
							 * case 64: HSSFCell cell64 = row.createCell((short)
							 * columnNo); cell64.setCellValue(new
							 * HSSFRichTextString(employee.getEmployeeCode()));
							 * 
							 * columnNo++; break;
							 */
							}
						}
					}
					rowNo++;
				}

			} else {
				HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue(new HSSFRichTextString("No Record Found."));
				cell30.setCellStyle(styleHeadings);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));
			}
			map.put("wb", wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public void refreshObject(Object o) {
		getHibernateTemplate().refresh(o);
	}

	@Override
	public Map<String, Object> showWingJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWing> wingList = new ArrayList<MasWing>();
		wingList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasWing where lower(Status)='y' ");

		map.put("wingList", wingList);
		return map;
	}

	@Override
	public boolean addWing(MasWing masWing) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masWing);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editWing(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String empStatusName = "";
		@SuppressWarnings("unused")
		String empStatusCode = "";
		int empStatusId = 0;
		Users changedBy = null;
		empStatusId = (Integer) generalMap.get("id");
		empStatusCode = (String) generalMap.get("empStatusCode");
		empStatusName = (String) generalMap.get("name");
		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasWing masWing = (MasWing) getHibernateTemplate().load(MasWing.class,
				empStatusId);

		masWing.setId(empStatusId);
		masWing.setWingName(empStatusName);
		masWing.setLastChgBy(changedBy);
		masWing.setLastChgDate(currentDate);
		masWing.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masWing);
		dataUpdated = true;
		return dataUpdated;

	}

	@Override
	public boolean deleteWing(int wingId, Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		Users changedBy = null;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasWing masWing = new MasWing();
		masWing = (MasWing) getHibernateTemplate().load(MasWing.class, wingId);

		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (masWing.getStatus().equalsIgnoreCase("y")) {
			masWing.setStatus("N");
			dataDeleted = true;
		} else {
			masWing.setStatus("Y");
			dataDeleted = false;
		}
		masWing.setLastChgBy(changedBy);
		masWing.setLastChgDate(currentDate);
		masWing.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masWing);
		return dataDeleted;

	}

	public Map<String, Object> wingSearch(String wingCode, String wingName) {

		
		List<MasWing> wingList = new ArrayList<MasWing>();
		Map<String, Object> empStatusFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			if ((wingName != null) || (wingCode == null)) {
				//wingList = getHibernateTemplate().find("from jkt.hms.masters.business.MasWing es where lower(es.Status)='y' and UPPER(es.WingName) like UPPER('"+ wingName + "%') order by es.WingName");
				
				
				wingList = session.createCriteria(MasWing.class)
						.add(Restrictions.like("WingName",wingName+"%").ignoreCase()).list();
			} else {
				
				wingList = session.createCriteria(MasWing.class)
						.add(Restrictions.like("WingCode", wingCode+"%").ignoreCase()).list();
				//wingList = getHibernateTemplate().find("from jkt.hms.masters.business.MasWing es where lower(es.Status)='y' and UPPER(es.WingCode) like UPPER('"+ wingCode + "%') order by es.WingCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		empStatusFieldsMap.put("wingList", wingList);
		return empStatusFieldsMap;
	}

	@Override
	public Map<String, Object> showEmployeeApprovedJsp(int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		//List<MasUnit> gridUnitList = new ArrayList<MasUnit>();
		List<MasEmployeeType> employeeTypeList = new ArrayList<MasEmployeeType>();
		List<MasAdministrativeSex> masAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasLocation> locationList = new ArrayList<MasLocation>();
		List<MasReligion> religionList = new ArrayList<MasReligion>();
		List<MasCaste> casteList = new ArrayList<MasCaste>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as emp where UPPER(emp.Status) = 'E' and emp.Hospital.Id = "
						+ hospitalId);
		HibernateTemplate hbt = getHibernateTemplate();
		locationList = hbt
				.find("from jkt.hrms.masters.business.MasLocation as i where i.Status='Y'");
		titleList = hbt
				.find("from jkt.hms.masters.business.MasTitle as tm where UPPER(tm.Status) = 'Y'");
		departmentList = hbt
				.find("from jkt.hms.masters.business.MasDepartment as md where  UPPER(md.Status) = 'Y'");
		costCenterList = hbt
				.find("from jkt.hms.masters.business.MasCostCenter as mcc where mcc.Status = 'Y'");
		empCategoryList = hbt
				.find("from jkt.hms.masters.business.MasEmpCategory as mec where UPPER(mec.Status) = 'Y'");
		empStatusList = hbt
				.find("from jkt.hms.masters.business.MasEmpStatus as mes where UPPER(mes.Status) = 'Y'");
		searchEmployeeList = hbt
				.find("from jkt.hms.masters.business.MasEmployee as emp where UPPER(emp.Status) = 'E' and emp.Hospital.Id = "
						+ hospitalId);
		gradeList = hbt
				.find("from jkt.hms.masters.business.MasGrade as mg where UPPER(mg.Status) = 'Y'");
		rankList = hbt
				.find("from jkt.hms.masters.business.MasRank as mg where UPPER(mg.Status) = 'Y'");
		unitList = hbt
				.find("from jkt.hms.masters.business.MasUnit as mg where mg.Status = 'Y'");
		/*tradeList = hbt
				.find("from jkt.hms.masters.business.MasTrade as mg where UPPER(mg.Status) = 'Y'");*/
		employeeTypeList = hbt
				.find("from jkt.hrms.masters.business.MasEmployeeType as mg where UPPER(mg.Status) = 'Y'");
		masAdministrativeSexList = hbt
				.find("from jkt.hms.masters.business.MasAdministrativeSex as mg where UPPER(mg.Status) = 'Y'");
		System.out
				.println(searchEmployeeList.size() + " in data " + hospitalId);
		countryList = hbt.find("from jkt.hms.masters.business.MasCountry");
		stateList = hbt.find("from jkt.hms.masters.business.MasState");
		districtList = hbt.find("from jkt.hms.masters.business.MasDistrict where State.Id=18");
		
		maritalStatusList = hbt
				.find("from jkt.hms.masters.business.MasMaritalStatus");
		religionList = hbt
				.find("from jkt.hms.masters.business.MasReligion as mr where UPPER(mr.Status) = 'Y'");
		casteList = hbt
				.find("from jkt.hms.masters.business.MasCaste as mc where mc.Status = 'Y'");
		masHospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mc where UPPER(mc.Status) = 'Y'");
		//map.put("gridUnitList", gridUnitList);
		map.put("locationList", locationList);
		map.put("titleList", titleList);
		map.put("departmentList", departmentList);
		map.put("costCenterList", costCenterList);
		map.put("empStatusList", empStatusList);
		map.put("empCategoryList", empCategoryList);
		map.put("gradeList", gradeList);
		map.put("searchEmployeeList", searchEmployeeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("religionList", religionList);
		map.put("casteList", casteList);
	//	map.put("tradeList", tradeList);
		map.put("employeeTypeList", employeeTypeList);
		map.put("masAdministrativeSexList", masAdministrativeSexList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("employeeList", employeeList);
		map.put("masHospitalList", masHospitalList);
		return map;
	}

	@Override
	public boolean submitApproveEmployee(Map<String, Object> map) {

		boolean successfullyAdded = false;
		MasEmployee masEmployee;
		List employeeList = (List) map.get("employeeList");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (employeeList != null && employeeList.size() > 0) {
				Iterator iterator = employeeList.iterator();
				while (iterator.hasNext()) {
					int employeeId = (Integer) iterator.next();
					masEmployee = (MasEmployee) getHibernateTemplate().load(
							MasEmployee.class, employeeId);

					masEmployee.setStatus("e");

					hbt.update(masEmployee);

					successfullyAdded = true;

				}

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> showShiftParameterMasterJsp(Map parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		List<HrMasShiftCodes> masShiftCodeList = new ArrayList<HrMasShiftCodes>();
		Session session = (Session) getSession();
		masEmpCategoryList = session.createCriteria(MasEmpCategory.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("EmpCategoryName")).list();
		masShiftCodeList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("ShiftName")).list();
		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("masShiftCodesList", masShiftCodeList);
		return map;

	}

	@Override
	public MasEmployeeTemp getEmployeeTemp(int employeeId) {
		Session session = getSession();
		MasEmployeeTemp employeeTemp = null;
		Criteria criteria = session.createCriteria(MasEmployeeTemp.class);
		criteria = criteria.add(Restrictions.eq("Employee.Id", employeeId));
		List employeeTempList = criteria.list();
		if (employeeTempList.size() > 0) {
			employeeTemp = (MasEmployeeTemp) employeeTempList.get(0);
		}
		return employeeTemp;
	}

	@Override
	public boolean addEmployeeTemp(Map map1) {
		boolean successfullyAdded = false;
		Session session = getSession();
		try {

			MasEmployeeTemp masEmployeeTemp = (MasEmployeeTemp) map1
					.get("masEmployee");
			MasEmployee masEmployee = (MasEmployee) map1.get("me");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			// org.springframework.orm.hibernate3.HibernateTemplate hbt1 =
			// getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			// hbt1.setFlushModeName("FLUSH_EAGER");
			// hbt1.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masEmployeeTemp);
			// hbt1.saveOrUpdate(masEmployee);
			hbt.flush();

			hbt.refresh(masEmployeeTemp);
			// hbt1.refresh(masEmployee);
			// hbt1.flush();
			// addleaveBalanceToEmp(masEmployee);
			String qry = "update mas_employee set status='e' where employee_id="
					+ masEmployeeTemp.getEmployee().getId();
			System.out.println("" + qry);
			session.createSQLQuery(
					"update mas_employee set status='e' where employee_id="
							+ masEmployeeTemp.getEmployee().getId())
					.executeUpdate();
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@Override
	public List<HrMasLeaveTypeMediator> getMasLeaveTypeMediatorList() {
		List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediatorList = new ArrayList<HrMasLeaveTypeMediator>();
		Session session = (Session) getSession();
		hrMasLeaveTypeMediatorList = session
				.createCriteria(HrMasLeaveTypeMediator.class)
				.createAlias("LeaveType", "lt")
				.add(Restrictions.eq("lt.Status", "y").ignoreCase()).list();
		return hrMasLeaveTypeMediatorList;
	}

	@Override
	public void addEmployeeBalanceDetails(
			HrEmployeeBalanceNew hrEmployeeBalanceNew) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		System.out.println(hrEmployeeBalanceNew.getLeaveType().getId());
		hbt.save(hrEmployeeBalanceNew);
		// hbt.refresh(hrEmployeeBalanceNew);

		Calendar cal = Calendar.getInstance();

		HrAccruelRecord hrAccruelRecord = new HrAccruelRecord();
		hrAccruelRecord.setAccrued(hrEmployeeBalanceNew.getEarned());
		hrAccruelRecord.setMonth(String.valueOf(cal.get(Calendar.MONTH) + 1));
		hrAccruelRecord.setYear(String.valueOf(cal.get(Calendar.YEAR)));
		hrAccruelRecord.setEmp(hrEmployeeBalanceNew.getEmp());
		hrAccruelRecord.setBalance(hrEmployeeBalanceNew);
		hrAccruelRecord.setLeaveType(hrEmployeeBalanceNew.getLeaveType());
		hbt.save(hrAccruelRecord);
		// hbt.refresh(hrAccruelRecord);
	}

	@Override
	public Map<String, Object> getEmployeeCode(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();
		String PEN = "";
		int item_id = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		List objectList = new ArrayList();
		PEN = "" + dataMap.get("PEN");
		try {
			// String qry="select
			// mas.item_id,mas.pvms_no,mas.nomenclature,mas.strength,con.item_unit_name
			// from mas_store_item mas inner join mas_store_item_conversion con
			// on mas.item_conversion_id = con.item_conversion_id ";
			String qry = "select count(*) from mas_employee mas where mas.pe_no='"
					+ PEN + "'";
			// System.out.println(qry);
			objectList = (List) session.createSQLQuery(qry).list();
			int val = Integer.parseInt("" + objectList.get(0));
			if (val > 0)
				map.put("status", "yes");
			else
				map.put("status", "no");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// map.put("objectList", objectList);
		return map;
	}

	@Override
	public Map<String, Object> getListForEmpAddress() {

		Session session = (Session) getSession();
		Map<String, Object> map1 = new HashMap<String, Object>();

		List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
		List<MasVillage> villageList = new ArrayList<MasVillage>();
		List<HrMasQualification> educationList = new ArrayList<HrMasQualification>();
		List<MasLsg> lsgNameList = new ArrayList<MasLsg>();
		List<MasLsgType> lsgTypeList = new ArrayList<MasLsgType>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		List<MasIdCard> idCardList = new ArrayList<MasIdCard>();
		List<MasVisaType> visaTypeList = new ArrayList<MasVisaType>();
		//List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<PhMasLocality> localityList = new ArrayList<PhMasLocality>();
	//	List<MasCountry> countryList = new ArrayList<MasCountry>();
		//List<MasWard> wardList = new ArrayList<MasWard>();

		/*visaTypeList = session.createCriteria(MasVisaType.class)
				.addOrder(Order.asc("VisaTypeName"))
				.add(Restrictions.eq("Status", "Y")).list();*/

		localityList = session.createCriteria(PhMasLocality.class)
				.addOrder(Order.asc("LocalityName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		districtList = session.createCriteria(MasDistrict.class)
				.addOrder(Order.asc("DistrictName"))
				.add(Restrictions.eq("State.Id", 32))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

	/*	countryList = session.createCriteria(MasCountry.class)
				.addOrder(Order.asc("CountryName"))
				.add(Restrictions.eq("Status", "Y")).list();*/
		/*stateList = session.createCriteria(MasState.class)
				.addOrder(Order.asc("StateName").ignoreCase())
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();*/
		/*villageList = session.createCriteria(MasVillage.class)
				.addOrder(Order.asc("VillageName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();*/
		postCodeList = session.createCriteria(MasPostCode.class)
				.addOrder(Order.asc("PostCodeName"))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		lsgNameList = session.createCriteria(MasLsg.class)
				.addOrder(Order.asc("LsgTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		lsgTypeList = session.createCriteria(MasLsgType.class)
				.addOrder(Order.asc("LsgTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		talukList = session.createCriteria(MasTaluk.class)
				.addOrder(Order.asc("TalukName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
/*
		wardList = session.createCriteria(MasWard.class)
				.addOrder(Order.asc("WardName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();*/

		map1.put("localityList", localityList);
		//map1.put("countryList", countryList);
		map1.put("villageList", villageList);
		map1.put("postCodeList", postCodeList);
		map1.put("lsgNameList", lsgNameList);
		map1.put("lsgTypeList", lsgTypeList);
		map1.put("talukList", talukList);
		map1.put("districtList", districtList);
		//map1.put("visaTypeList", visaTypeList);
		//map1.put("stateList", stateList);
	//	map1.put("wardList", wardList);

		return map1;
	}

	@Override
	public void addEmployeeAddress(Map AddressMap) {

		Session session = (Session) getSession();
		HrEmployeeAddress employeeAddressPerma = new HrEmployeeAddress();

		HrEmployeeAddress employeeAddressTemp = new HrEmployeeAddress();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (AddressMap.get("employeeAddressPerma") != null) {
			employeeAddressPerma = (HrEmployeeAddress) AddressMap
					.get("employeeAddressPerma");
//System.out.println("employeeAddressPerma--"+employeeAddressPerma.getDistrict().getId());
			hbt.save(employeeAddressPerma);
			/*
			 * session.save(employeeAddressPerma); session.flush();
			 * session.refresh(employeeAddressPerma);
			 */
		}

		if (AddressMap.get("employeeAddressTemp") != null) {
			employeeAddressTemp = (HrEmployeeAddress) AddressMap
					.get("employeeAddressTemp");
		
			hbt.save(employeeAddressTemp);
			/*
			 * session.save(employeeAddressTemp); session.flush();
			 * session.refresh(employeeAddressTemp);
			 */
		}

	}

	@Override
	public Map<String, Object> getEducationAndExperForEdit(int empId) {
		Map<String, Object> dMap = new HashMap();
		Session session = (Session) getSession();
		List<HrMasEmployeeEducation> educationList = new ArrayList<HrMasEmployeeEducation>();
		List<HrEmployeeExperience> expList = new ArrayList<HrEmployeeExperience>();
		List<HrMasQualification> qualificationList = new ArrayList<HrMasQualification>();
		List<HrMasCourse> coursesList = new ArrayList<HrMasCourse>();
		educationList = session.createCriteria(HrMasEmployeeEducation.class)
				.add(Restrictions.eq("Employee.Id", empId)).list();
		expList = session.createCriteria(HrEmployeeExperience.class)
				.add(Restrictions.eq("Employee.Id", empId)).list();

		qualificationList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasQualification as mq where  UPPER(mq.Status) = 'Y'");
		coursesList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasCourse as mc where  UPPER(mc.Status) = 'Y'");

		dMap.put("expList", expList);
		dMap.put("educationList", educationList);
		dMap.put("coursesList", coursesList);
		dMap.put("qualificationList", qualificationList);
		return dMap;
	}

	@Override
	public boolean removeOldExper(MasEmployee masEmployee) {
		Session session = (Session) getSession();
		boolean b = false;
		int id = masEmployee.getId();
		// System.out.println("del>>>id>>>"+id);
		int a = session.createSQLQuery(
				"delete from  hr_employee_experience where employee_id=" + id)
				.executeUpdate();
		// System.out.println("a>>>>"+a);
		if (a > 0)
			b = true;
		else
			b = false;
		return b;
	}

	@Override
	public boolean removeOldEdu(MasEmployee masEmployee) {
		Session session = (Session) getSession();
		boolean b = false;
		int id = masEmployee.getId();
		// System.out.println("del>>>id>>>"+id);
		int a = session.createSQLQuery(
				"delete from   hr_mas_employee_education where employee_id="
						+ id).executeUpdate();
		// System.out.println("a>>>>"+a);
		if (a > 0)
			b = true;
		else
			b = false;
		return b;
	}

	public boolean removeEmployee(int employeeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Users changedBy = null;
		Date currentDate = new Date();
		String currentTime = "";
		int hospitalId = 0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		Session session = (Session) getSession();
		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasEmployee masEmployee = new MasEmployee();
		System.out.println("employeeId "+employeeId);
		masEmployee = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, employeeId);
		// changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		masEmployee.setStatus("D"); // for remove
		dataDeleted = true;

		masEmployee.setLastChgBy(changedBy);
		masEmployee.setLastChgDate(currentDate);
		masEmployee.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<Users> users = session.createCriteria(Users.class)
				.createAlias("Employee","emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		if(users.size()>0) {
			Users user=new Users();
			user = (Users) users.get(0);
			user.setSimSerialNo("0");
			user.setImeiNo(0l);
			user.setLastChgDate(currentDate);
			user.setLastChgTime(currentTime);
			user.setLastChgBy(changedBy);
			hbt.update(user);
		}
		hbt.update(masEmployee);
		return dataDeleted;
	}

	@Override
	public boolean deleteEmpAddress(int employeeId) {
		Session session = (Session) getSession();
		boolean b = false;
		// System.out.println("del>>>id>>>"+id);
		int a = session.createSQLQuery(
				"delete from   hr_employee_address where employee_id="
						+ employeeId).executeUpdate();
		// System.out.println("a>>>>"+a);
		if (a > 0)
			b = true;
		else
			b = false;
		return b;
	}

	@Override
	public Map<String, Object> getMasInstituteDepartment(Map<String, Object> map) {
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		int hospitalId = (Integer) map.get("hospitalId");
		departmentList = session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("Department", "dep")
				.addOrder(Order.asc("dep.DepartmentName")).list();
		map.put("departmentList", departmentList);
		return map;
	}

	@Override
	public Map<String, Object> getMasInstituteEmployeeDepartment(
			Map<String, Object> map) {
		Session session = (Session) getSession();

		int hospitalId = (Integer) map.get("hospitalId");
		List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
		hrInstWiseEmpDeptStringList = session
				.createCriteria(HrInstEmpDept.class)
				.createAlias("Institute", "i")
				.add(Restrictions.eq("i.Id", hospitalId))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.property("EmployeeDepartment"))
								.add(Projections.property("Id"))).list();

		List<Integer> hidList = new ArrayList<Integer>();

		if (hrInstWiseEmpDeptStringList.size() > 0) {

			Object[] obj = hrInstWiseEmpDeptStringList.get(0);
			String hIds = (String) obj[0];
			int hrInsitEmpDepId = (Integer) obj[1];
			String[] houseId = hIds.split(",");
			for (int i = 0; i < houseId.length; i++) {
				hidList.add(Integer.parseInt(houseId[i].trim()));
			}
			System.out.println(hidList);

			List<MasEmployeeDepartment> employeeDepartmentList = session
					.createCriteria(MasEmployeeDepartment.class)
					.add(Restrictions.in("Id", hidList)).list();

			System.out.println(employeeDepartmentList.size()
					+ "-----------------");

			map.put("employeeDepartmentList", employeeDepartmentList);

		}

		return map;
	}

	@Override
	public Map<String, Object> showRemovedEmployeeInstitutionMappingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasEmployee> removedEmployeeList = new ArrayList<MasEmployee>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasEmpCategory> categoryList = new ArrayList<MasEmpCategory>();
		int userType =0;
		int userId = 0;
		if (box.getInt("userType") != 0) {
			userType = box.getInt("userType");
		}
		if (box.getInt("userId") != 0) {
			userId = box.getInt("userId");
		}
		
		List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		removedEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "D").ignoreCase())
									.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y").ignoreCase())
				  .add(Restrictions.eq("State.Id", 32))//added govind 15-12-2016
				  .list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("HospitalName"))//added govind 15-12-2016
				.list();
		hospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status", "y").ignoreCase())
				           .addOrder(Order.asc("HospitalTypeName"))//added govind 15-12-2016
				           .list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("RankName"))//added govind 15-12-2016
				.list();
		categoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("EmpCategoryName"))//added govind 15-12-2016
				.list();
		employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("EmpDeptName"))//added govind 15-12-2016
				.list();
		
		/**
		 * For PH Admin
		 */
		if(userType==5){
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
					.add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
			map.put("bsScInstList", bsScInstList);
		}
		
		map.put("removedEmployeeList", removedEmployeeList);
		map.put("districtList", districtList);
		map.put("hospitalList", hospitalList);
		map.put("hospitalTypeList", hospitalTypeList);
		map.put("rankList", rankList);
		map.put("categoryList", categoryList);
		map.put("employeeDepartmentList", employeeDepartmentList);
		return map;
	}

	@Override
	public Map<String, Object> showRemovedEmployeeDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasEmpCategory> categoryList = new ArrayList<MasEmpCategory>();
		List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasEmployee> removedEmployeeList = new ArrayList<MasEmployee>();
		
		int userType =0;
		int userId = 0;
		if (box.getInt("userType") != 0) {
			userType = box.getInt("userType");
		}
		if (box.getInt("userId") != 0) {
			userId = box.getInt("userId");
		}
		
		Session session = (Session) getSession();
		if(!box.getString("pen").equals("")){
			removedEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "D").ignoreCase()).add(Restrictions.eq("PEN", box.getString("pen")))
					.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		}else{
			removedEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "D").ignoreCase())
										.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.idEq(box.getInt("employeeId"))).list(); //Added By Om Tripathi 23/11/2017
		}
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(box.getInt("employeeId"))).list();
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y").ignoreCase())
				  .add(Restrictions.eq("State.Id", 32))//added govind 15-12-2016
				  .list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("HospitalName"))//added govind 15-12-2016
				.list();
		hospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status", "y").ignoreCase())
		           .addOrder(Order.asc("HospitalTypeName"))//added govind 15-12-2016
		           .list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("RankName"))//added govind 15-12-2016
				.list();
		categoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("EmpCategoryName"))//added govind 15-12-2016
				.list();
		employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("EmpDeptName"))//added govind 15-12-2016
				.list();
		
		/**
		 * For PH Admin
		 */
		if(userType==5){
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
					.add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
			map.put("bsScInstList", bsScInstList);
		}
		
		map.put("removedEmployeeList", removedEmployeeList);		
		map.put("employeeList", employeeList);
		map.put("districtList", districtList);
		map.put("hospitalList", hospitalList);
		map.put("hospitalTypeList", hospitalTypeList);
		map.put("rankList", rankList);
		map.put("categoryList", categoryList);
		map.put("employeeDepartmentList", employeeDepartmentList);
		return map;
	}
	@Override
	public Map<String, Object> searchRemovedEmployeeInstitutionMappingJsp(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*List<MasEmployee> employeeList = new ArrayList<MasEmployee>();*/
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasEmpCategory> categoryList = new ArrayList<MasEmpCategory>();
		List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasEmployee> removedEmployeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		int radio=0;  //Added By Om Tripathi 23/11/2017
		int userType=0;
		if(box.getInt("userType")!=0){
			userType = box.getInt("userType");
		}
		
		int userId = 0;
		if (box.getInt("userId") != 0) {
			userId = box.getInt("userId");
		}
		if(box.getInt("radio")==1 && !box.getString("searchField").equals("") && userType !=4){
			removedEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "D").ignoreCase()).add(Restrictions.eq("PEN", box.getString("searchField")))
					.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		}else if(box.getInt("radio")==2  && !box.getString("searchField").equals("") && userType !=4){ //Added By Om Tripathi 23/11/2017
			removedEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "D").ignoreCase()).add(Restrictions.ilike("FirstName", box.getString("searchField")+"%"))
					.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		}else if(userType !=4){
			removedEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "D").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		}
		
	/*	employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(box.getInt("employeeId"))).list();*/
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("State.Id", 32))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		hospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		categoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		/**
		 * For PH Admin
		 */
		if(userType==5){
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
					.add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
			map.put("bsScInstList", bsScInstList);
		}
		
		map.put("removedEmployeeList", removedEmployeeList);		
		/*map.put("employeeList", employeeList);*/
		map.put("districtList", districtList);
		map.put("hospitalList", hospitalList);
		map.put("hospitalTypeList", hospitalTypeList);
		map.put("rankList", rankList);
		map.put("categoryList", categoryList);
		map.put("employeeDepartmentList", employeeDepartmentList);
		return map;
	}

	@Override
	public Map<String, Object> assignInstituteForRemovedEmployee(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasEmpCategory> categoryList = new ArrayList<MasEmpCategory>();
		List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasEmployee> removedEmployeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String date = "";
		String time = "";
		int empId=0;
		
		int userType =0;
		int loginUserId = 0;
		if (box.getInt("userType") != 0) {
			userType = box.getInt("userType");
		}
		if (box.getInt("userId") != 0) {
			loginUserId = box.getInt("userId");
		}
		
		boolean successfullyAdded = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		MasEmployee masEmployee = null;//changed by govind 15-12-2016
		if(box.getInt("employeeId") != 0){
			System.out.println("employeeId "+box.getInt("employeeId"));
			empId=box.getInt("employeeId");
		    masEmployee = (MasEmployee) hbt.load(MasEmployee.class, box.getInt("employeeId"));
			// masEmployee.setStatus("E");
		}
		if(box.getInt("lastInstitutionId")!= 0){
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("lastInstitutionId"));
			masEmployee.setHospital(masHospital);
		}
		if(box.getInt("title")!= 0){
			MasTitle masTitle = new MasTitle();
			masTitle.setId(box.getInt("title"));
			masEmployee.setTitle(masTitle);
		}
		if(!box.getString("firstName").equals("")){
			masEmployee.setFirstName(box.getString("firstName"));
		}
		if(!box.getString("middleName").equals("")){
			masEmployee.setMiddleName(box.getString("middleName"));
		}
		if(!box.getString("lastName").equals("")){
			masEmployee.setLastName(box.getString("lastName"));
		}
		if (box.getInt("empDeptId")!= 0) {
			MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();
			masEmployeeDepartment.setId(box.getInt("empDeptId"));
			masEmployee.setEmployeeDepartment(masEmployeeDepartment);
		}
		if (box.getInt("employeeStatusId")!= 0) {
			MasEmpStatus masEmpStatus = new MasEmpStatus();
			masEmpStatus.setId(box.getInt("employeeStatusId"));
			masEmployee.setEmployeeStatus(masEmpStatus);
		}
		masEmployee.setStatus("y");
		if(box.getInt("userId") != 0){
			Users users = new Users();
			users.setId(box.getInt("userId"));
			masEmployee.setLastChgBy(users);
		}
		masEmployee.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		masEmployee.setLastChgTime(time);
		if (box.getInt("categoryId")!= 0) {
			MasEmpCategory masEmpCategory = new MasEmpCategory();
			masEmpCategory.setId(box.getInt("categoryId"));
			masEmployee.setEmpCategory(masEmpCategory);
		}
		if (box.getInt("rankId")!= 0) {
			MasRank masRank = new MasRank();
			masRank.setId(box.getInt("rankId"));
			masEmployee.setRank(masRank);
		}
		if (box.getInt("employeeTypeId")!= 0) {
			MasEmployeeType masEmployeeType = new MasEmployeeType();
			masEmployeeType.setId(box.getInt("employeeTypeId"));
			masEmployee.setEmployeeType(masEmployeeType);
		}
		if(!box.getString("pen").equals("")){
			masEmployee.setPEN(box.getString("pen"));
		}
		if(!box.getString("employeeName").equals("")){
			masEmployee.setEmployeeName(box.getString("employeeName"));
		}
		if(!box.getString("uhid").equals("")){
			masEmployee.setUHID(box.getString("uhid"));
		}
		if(!box.getString("fatherHusbandName").equals("")){
			masEmployee.setFatherHusbandName(box.getString("fatherHusbandName"));
		}
		if (box.getInt("personaDetaisId")!= 0) {
			HrEmployeePersonelDetails  employeePersonelDetails = new HrEmployeePersonelDetails();
			employeePersonelDetails.setId(box.getInt("personaDetaisId"));
			masEmployee.setPersonalDetails(employeePersonelDetails);
		}
		String simSerialNo="";  //Added By Om Tripathi 23/11/2017
		if (box.getString("simSerialNo")!= null && box.getString("simSerialNo")!= "") {
			simSerialNo= box.getString("simSerialNo");
		}
		long imeiNo=0l;
		if (box.getLong("imeiNo")!= 0) {
			imeiNo=box.getLong("imeiNo");
		}
		//added by govind 15-12-2016
		MasHospital masHospital=new MasHospital();
		if (box.getInt("hospitalId")!= 0) {
			
			
			masHospital.setId(box.getInt("hospitalId"));
			masEmployee.setHospital(masHospital);
		}
		System.out.println("new hospitalId "+masEmployee.getHospital().getId());
		int userId=0;
		if(empId>0){
			List<Users> userList=session.createCriteria(Users.class).add(Restrictions.eq("Employee.Id", empId)).list();
			
			System.out.println("userList "+userList.size());
			
			if(userList.size()>0){
				Users user=userList.get(0);
				user.setHospital(masHospital);
				user.setImeiNo(imeiNo);
				user.setSimSerialNo(simSerialNo);
				user.setImeiNo(imeiNo);
				hbt.saveOrUpdate(user);				
				userId=userList.get(0).getId();
							
				List<UserHospital> userHospitalList=session.createCriteria(UserHospital.class).add(Restrictions.eq("User.Id", userId)).list();
				
				System.out.println("userHospitalList "+userHospitalList.size());
				
				if(userHospitalList.size()>0){
					UserHospital userHospital=userHospitalList.get(0);
					userHospital.setHospital(masHospital);
					hbt.update(userHospital);
				}
			}
		}
		
		//hbt.save(masEmployee);//commented by govind
		/*if(box.getInt("employeeId") != 0){
			System.out.println("employeeId "+box.getInt("employeeId"));
			MasEmployee  emp = (MasEmployee) hbt.load(MasEmployee.class, box.getInt("employeeId"));
			emp=masEmployee;
			emp.setStatus("E");*/
		//hbt.update(emp);//commented by govind
		//}
		if(masEmployee!=null){
			hbt.update(masEmployee);
		}
		successfullyAdded = true;
		removedEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "D").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		//employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(box.getInt("employeeId"))).list();
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		hospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		categoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	
		
		/**
		 * For PH Admin
		 */
		if(userType==5){
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
					.add(Restrictions.eq("User.Id", loginUserId)).add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
			map.put("bsScInstList", bsScInstList);
		}
		
		
		map.put("removedEmployeeList", removedEmployeeList);		
		map.put("employeeList", employeeList);
		map.put("districtList", districtList);
		map.put("hospitalList", hospitalList);
		map.put("hospitalTypeList", hospitalTypeList);
		map.put("rankList", rankList);
		map.put("categoryList", categoryList);
		map.put("employeeDepartmentList", employeeDepartmentList);
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@Override
	public Map<String, Object> fillInstHospital(int districtId, int instType) {
		List<MasHospital> instituteList = new ArrayList<MasHospital>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		instituteList=session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("District.Id", districtId))
				.add(Restrictions.eq("HospitalType.Id", instType))
				.list();
		map.put("instituteList",instituteList);
		return map;
	}

	@Override
	public Map<String, Object> showTabletDetails(String hospitalName,int districtId) {
		List<MasHospital> tabletDetails = new ArrayList<MasHospital>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		tabletDetails = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("District.Id", districtId))
				.add(Restrictions.like("ShortName", hospitalName,MatchMode.START)).addOrder(Order.desc("Id"))
				.list();
		map.put("tabletDetails",tabletDetails);
		return map;
	}

	@Override
	public Map<String, Object> hrInstituteWiseDeptList(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
		hrInstWiseEmpDeptStringList = session
				.createCriteria(HrInstEmpDept.class)
				.createAlias("Institute", "i")
				.add(Restrictions.eq("i.Id", hospitalId))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.property("EmployeeDepartment"))
								.add(Projections.property("Id"))).list();

		List<Integer> hidList = new ArrayList<Integer>();
		
		if (hrInstWiseEmpDeptStringList.size() > 0) {

			Object[] obj = hrInstWiseEmpDeptStringList.get(0);
			String hIds = (String) obj[0];
			int hrInsitEmpDepId = (Integer) obj[1];
			String[] houseId = hIds.split(",");
			for (int i = 0; i < houseId.length; i++) {
				hidList.add(Integer.parseInt(houseId[i].trim()));
			}
			

			List<MasEmployeeDepartment> employeeDepartmentList = session
					.createCriteria(MasEmployeeDepartment.class)
					.add(Restrictions.in("Id", hidList)).list();


			map.put("employeeDepartmentList", employeeDepartmentList);
		
	}
		return map;	
	}
	
}