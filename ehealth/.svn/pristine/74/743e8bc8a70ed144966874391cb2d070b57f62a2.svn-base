package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.HmsNoticeBoard;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.HrInstEmpDept;
import jkt.hms.masters.business.MasActionTaken;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasComplication;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasHospitalwiseChargecode;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasIcdMainCategory;
import jkt.hms.masters.business.MasIcdSubCategory;
import jkt.hms.masters.business.MasIcdcausegrp;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMajorCategoryCode;
import jkt.hms.masters.business.MasPatientStatus;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasServiceCentreCounter;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSubTest;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MultiDepartmentMapping;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PrinterCofiguration;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.HospitalUnitDays;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


public class HospitalDetailsMasterDataServiceImpl extends HibernateDaoSupport
		implements HospitalDetailsMasterDataService {

	// -----------------------------------Case Type--------------------- -------
	public boolean addCaseType(MasCaseType masCaseType) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCaseType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteCaseType(int caseTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCaseType masCaseType = new MasCaseType();
		masCaseType = (MasCaseType) getHibernateTemplate().get(
				MasCaseType.class, caseTypeId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCaseType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCaseType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user= new Users();
		user.setId(changedBy);
		masCaseType.setLastChgBy(user);
		masCaseType.setLastChgDate(currentDate);
		masCaseType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaseType);
		return dataDeleted;
	}

	public boolean editCaseTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String caseTypeName = "";
		String caseTypeCode = "";
		int caseTypeId = 0;
		int changedBy = 0;
		caseTypeId = (Integer) generalMap.get("id");
		
		caseTypeCode = (String) generalMap.get("caseTypeCode");
		caseTypeName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCaseType masCaseType = (MasCaseType) getHibernateTemplate().get(
				MasCaseType.class, caseTypeId);

		masCaseType.setId(caseTypeId);
		masCaseType.setCaseTypeName(caseTypeName);
		Users user= new Users();
		user.setId(changedBy);
		masCaseType.setLastChgBy(user);
		masCaseType.setLastChgDate(currentDate);
		masCaseType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaseType);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showCaseTypeJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCaseType> searchCaseTypeList = new ArrayList<MasCaseType>();
		searchCaseTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCaseType ");
		map.put("searchCaseTypeList", searchCaseTypeList);
		return map;
	}

	public Map<String, Object> searchCaseType(String caseTypeCode,
			String caseTypeName) {
		List<MasCaseType> searchCaseTypeList = new ArrayList<MasCaseType>();
		Map<String, Object> caseTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((caseTypeName != null) || (caseTypeCode == null)) {
				searchCaseTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasCaseType imc where imc.CaseTypeName like '"
								+ caseTypeName + "%' order by imc.CaseTypeName");
			} else {
				searchCaseTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasCaseType imc where imc.CaseTypeCode like '"
								+ caseTypeCode + "%' order by imc.CaseTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		caseTypeFieldsMap.put("searchCaseTypeList", searchCaseTypeList);
		return caseTypeFieldsMap;
	}

	// -----------------------------Main Charge Code
	// -------------------------------------

	public boolean addMainChargecode(MasMainChargecode masMainChargecode) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMainChargecode);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteMainChargecode(int mainChargecodeId,
			Map<String, Object> generalMap) {
		Date currentDate = new Date();
		boolean dataDeleted = false;
	//	String changedBy = "";
		String currentTime = "";
		Users user = new Users();
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode = (MasMainChargecode) getHibernateTemplate().get(
				MasMainChargecode.class, mainChargecodeId);
		user = (Users) generalMap.get("user");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			if (flag.equals("InActivate")) {
				masMainChargecode.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masMainChargecode.setStatus("Y");
				dataDeleted = false;
			}
		}
		masMainChargecode.setLastChgBy(user);
		masMainChargecode.setLastChgDate(currentDate);
		masMainChargecode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMainChargecode);
		hbt.flush();
		hbt.clear();
		return dataDeleted;
	}

	public boolean editMainChargecodeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String mainChargecodeName = "";
		String mainChargecodeCode = "";
		String mainChargeType = "";
		int departmentId = 0;
		int mainChargecodeId = 0;
		String changedBy = "";

		if (generalMap.get("id") != null && !((Integer) generalMap.get("id")).equals(0))
		{
			mainChargecodeId = (Integer) generalMap.get("id");
		}

		MasMainChargecode masMainChargecode = (MasMainChargecode) getHibernateTemplate()
		.get(MasMainChargecode.class, mainChargecodeId);
		
		if (generalMap.get("code") != null
				&& !((String) generalMap.get("code")).equals("")) {
			mainChargecodeCode = (String) generalMap.get("code");
			masMainChargecode.setMainChargecodeCode(mainChargecodeCode);
		}
		
		if (generalMap.get("departmentId") != null
				&& !((Integer) generalMap.get("departmentId")).equals(0)) {
			departmentId = (Integer) generalMap.get("departmentId");
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masMainChargecode.setDepartment(masDepartment);
		}
					
		if (generalMap.get("name") != null
				&& !((String) generalMap.get("name")).equals("")) {
			mainChargecodeName = (String) generalMap.get("name");
			masMainChargecode.setMainChargecodeName(mainChargecodeName);
		}
		/*if (generalMap.get("mainChargeType") != null
				&& !((String) generalMap.get("mainChargeType")).equals("")) {
			mainChargeType = (String) generalMap.get("mainChargeType");
		}*/
		if (generalMap.get("changedBy") != null
				&& !((String) generalMap.get("changedBy")).equals("")) {
			changedBy = (String) generalMap.get("changedBy");
			Users users=new Users();
			users.setId((Integer)generalMap.get(RequestConstants.USER_ID));
			masMainChargecode.setLastChgBy(users);
		}
		
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
			masMainChargecode.setLastChgDate(currentDate);
		}
		if (generalMap.get("currentTime") != null
				&& !((String) generalMap.get("currentTime")).equals("")) {
			currentTime = (String) generalMap.get("currentTime");
			masMainChargecode.setLastChgTime(currentTime);
		}
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masMainChargecode);
			hbt.flush();
			hbt.clear();
			dataUpdated = true;
		}
		catch (DataAccessException e)
		{
			dataUpdated = false;
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean editPrinterDetails(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String sysTemIP = "";
		String printerName = "";
		String Type = "";
		List printerList = null;
		boolean printernameList = true;
		String systemIP="";
		String type="";
		Integer id=0;

	   id=(Integer)generalMap.get("id");
	   systemIP=(String)generalMap.get("systemIp");
	   type=(String)generalMap.get("type");
	   printerName=(String)generalMap.get("printerName");

		PrinterCofiguration printerCofiguration = (PrinterCofiguration) getHibernateTemplate()
		.get(PrinterCofiguration.class, id);
		printerCofiguration.setId(id);
		printerCofiguration.setPrinterName(printerName);
		printerCofiguration.setSystemIp(systemIP);
		printerCofiguration.setReportType(type);


		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(printerCofiguration);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> searchMainChargecode(String mainChargecodeCode,
			String mainChargecodeName) {

		
		List<MasMainChargecode> searchMainChargecodeList = new ArrayList<MasMainChargecode>();
		Map<String, Object> mainChargecodeFieldsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");	
		
		try {
			if ((mainChargecodeName != null) || (mainChargecodeCode == null)) {
				searchMainChargecodeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasMainChargecode imc where imc.MainChargecodeName like '"
								+ mainChargecodeName
								+ "%' order by imc.MainChargecodeName");
			} else {
				searchMainChargecodeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasMainChargecode imc where imc.MainChargecodeCode like '"
								+ mainChargecodeCode
								+ "%' order by imc.MainChargecodeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mainChargecodeFieldsMap.put("searchMainChargecodeList",
				searchMainChargecodeList);
		mainChargecodeFieldsMap.put("gridDepartmentList", gridDepartmentList);
		mainChargecodeFieldsMap.put("departmentList", departmentList);
		return mainChargecodeFieldsMap;
	}

	public Map<String, Object> showMainChargecodeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMainChargecode> searchMainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		searchMainChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode where Lower(Status)='y'");
		map.put("searchMainChargecodeList", searchMainChargecodeList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("departmentList", departmentList);
		return map;
	}


	public Map<String, Object> showPrinterDetails() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrinterCofiguration> searchPrinterList = new ArrayList<PrinterCofiguration>();



		searchPrinterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.PrinterCofiguration ");
		map.put("searchPrinterList", searchPrinterList);
		return map;
	}
	// -----------------------------Cost Center
	// --------------------------------------
	public Map<String, Object> showCostCenterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCostCenter> searchCostCenterList = new ArrayList<MasCostCenter>();
		searchCostCenterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCostCenter ");
		map.put("searchCostCenterList", searchCostCenterList);
		return map;
	}

	public boolean addCostCenter(MasCostCenter masCostCenter) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCostCenter);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteCostCenter(int costCenterId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCostCenter masCostCenter = new MasCostCenter();
		masCostCenter = (MasCostCenter) getHibernateTemplate().get(
				MasCostCenter.class, costCenterId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCostCenter.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCostCenter.setStatus("y");
				dataDeleted = false;
			}
		}
		masCostCenter.setLastChgBy(changedBy);
		masCostCenter.setLastChgDate(currentDate);
		masCostCenter.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCostCenter);
		return dataDeleted;
	}

	public boolean editCostCenterToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String costCenterName = "";
		@SuppressWarnings("unused")
		String costCenterCode = "";
		int costCenterId = 0;
		String changedBy = "";
		costCenterId = (Integer) generalMap.get("id");
		costCenterCode = (String) generalMap.get("costCenterCode");
		costCenterName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCostCenter masCostCenter = (MasCostCenter) getHibernateTemplate()
				.get(MasCostCenter.class, costCenterId);
		masCostCenter.setId(costCenterId);
		masCostCenter.setCostCenterName(costCenterName);
		masCostCenter.setLastChgBy(changedBy);
		masCostCenter.setLastChgDate(currentDate);
		masCostCenter.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCostCenter);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchCostCenter(String costCenterCode,
			String costCenterName) {
		List<MasCostCenter> searchCostCenterList = new ArrayList<MasCostCenter>();
		Map costCenterFieldsMap = new HashMap();
		try {
			if ((costCenterName != null) || (costCenterCode == null)) {
				searchCostCenterList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCostCenter sc where sc.CostCenterName like '"
								+ costCenterName
								+ "%' order by sc.CostCenterName");
			} else {
				searchCostCenterList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCostCenter sc where sc.CostCenterCode like '"
								+ costCenterCode
								+ "%' order by sc.CostCenterCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		costCenterFieldsMap.put("searchCostCenterList", searchCostCenterList);
		return costCenterFieldsMap;
	}

	// -----------------------------Major Category Code
	// --------------------------------------

	public Map<String, Object> showMajorCategoryCodeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMajorCategoryCode> searchMajorCategoryCodeList = new ArrayList<MasMajorCategoryCode>();
		searchMajorCategoryCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMajorCategoryCode ");
		map.put("searchMajorCategoryCodeList", searchMajorCategoryCodeList);
		return map;
	}

	public Map<String, Object> searchMajorCategoryCode(
			String majorCategoryCode, String majorCategoryName) {
		List<MasMajorCategoryCode> searchMajorCategoryCodeList = new ArrayList<MasMajorCategoryCode>();
		Map majorCategoryFieldsMap = new HashMap();
		try {
			if ((majorCategoryName != null) || (majorCategoryCode == null)) {
				searchMajorCategoryCodeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasMajorCategoryCode sc where sc.MajorCategoryName like '"
								+ majorCategoryName
								+ "%' order by sc.MajorCategoryName");
			} else {
				searchMajorCategoryCodeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasMajorCategoryCode sc where sc.MajorCategoryCode like '"
								+ majorCategoryCode
								+ "%' order by sc.MajorCategoryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		majorCategoryFieldsMap.put("searchMajorCategoryCodeList",
				searchMajorCategoryCodeList);
		return majorCategoryFieldsMap;
	}

	public boolean addMajorCategoryCode(
			MasMajorCategoryCode masMajorCategoryCode) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMajorCategoryCode);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteMajorCategoryCode(int majorCategoryCodeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasMajorCategoryCode masMajorCategoryCode = new MasMajorCategoryCode();
		masMajorCategoryCode = (MasMajorCategoryCode) getHibernateTemplate()
				.get(MasMajorCategoryCode.class, majorCategoryCodeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masMajorCategoryCode.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masMajorCategoryCode.setStatus("y");
				dataDeleted = false;
			}
		}
		masMajorCategoryCode.setLastChgBy(changedBy);
		masMajorCategoryCode.setLastChgDate(currentDate);
		masMajorCategoryCode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMajorCategoryCode);
		return dataDeleted;
	}

	public boolean editMajorCategoryCodeToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String majorCategoryName = "";
		@SuppressWarnings("unused")
		String majorCategoryCode = "";
		int majorCategoryId = 0;
		String changedBy = "";
		majorCategoryId = (Integer) generalMap.get("id");
		majorCategoryCode = (String) generalMap.get("majorCategoryCode");
		majorCategoryName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasMajorCategoryCode masMajorCategoryCode = (MasMajorCategoryCode) getHibernateTemplate()
				.get(MasMajorCategoryCode.class, majorCategoryId);
		masMajorCategoryCode.setId(majorCategoryId);
		masMajorCategoryCode.setMajorCategoryName(majorCategoryName);
		masMajorCategoryCode.setLastChgBy(changedBy);
		masMajorCategoryCode.setLastChgDate(currentDate);
		masMajorCategoryCode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMajorCategoryCode);
		dataUpdated = true;
		return dataUpdated;
	}

	// ------------------------------- Death Cause
	// -------------------------------------------

	public Map<String, Object> showDeathCauseJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDeathCause> searchDeathCauseList = new ArrayList<MasDeathCause>();
		searchDeathCauseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDeathCause ");
		map.put("searchDeathCauseList", searchDeathCauseList);
		return map;
	}

	public Map<String, Object> searchDeathCause(String deathCauseCode,
			String deathCauseName) {
		List<MasDeathCause> searchDeathCauseList = new ArrayList<MasDeathCause>();
		Map deathCauseFieldsMap = new HashMap();
		try {
			if ((deathCauseName != null) || (deathCauseCode == null)) {
				searchDeathCauseList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDeathCause sc where lower(sc.DeathCauseName) like '"
								+ deathCauseName.toLowerCase()
								+ "%' order by sc.DeathCauseName");
			} else {
				searchDeathCauseList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDeathCause sc where lower(sc.DeathCauseCode) like '"
								+ deathCauseCode.toLowerCase()
								+ "%' order by sc.DeathCauseCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		deathCauseFieldsMap.put("searchDeathCauseList", searchDeathCauseList);
		return deathCauseFieldsMap;
	}

	public boolean editDeathCauseToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String deathCauseName = "";
		@SuppressWarnings("unused")
		String deathCauseCode = "";
		int deathCauseId = 0;
		String changedBy = "";
		deathCauseId = (Integer) generalMap.get("id");
		deathCauseCode = (String) generalMap.get("deathCauseCode");
		deathCauseName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		MasDeathCause masDeathCause = (MasDeathCause) getHibernateTemplate()
				.get(MasDeathCause.class, deathCauseId);

		masDeathCause.setId(deathCauseId);
		masDeathCause.setDeathCauseName(deathCauseName);
		Users users=new Users();
		users.setId(userId);
		masDeathCause.setLastChgBy(users);
		masDeathCause.setLastChgDate(currentDate);
		masDeathCause.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDeathCause);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addDeathCause(MasDeathCause masDeathCause) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDeathCause);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDeathCause(int deathCauseId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDeathCause masDeathCause = new MasDeathCause();
		masDeathCause = (MasDeathCause) getHibernateTemplate().get(
				MasDeathCause.class, deathCauseId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDeathCause.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDeathCause.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masDeathCause.setLastChgBy(users);
		masDeathCause.setLastChgDate(currentDate);
		masDeathCause.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDeathCause);
		return dataDeleted;
	}

	// ------------------------------------Patient
	// Status------------------------------------------
	public Map<String, Object> showPatientStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPatientStatus> searchPatientStatusList = new ArrayList<MasPatientStatus>();
		searchPatientStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPatientStatus ");
		map.put("searchPatientStatusList", searchPatientStatusList);
		return map;
	}

	public Map<String, Object> searchPatientStatus(String patientStatusCode,
			String patientStatusName) {
		List<MasPatientStatus> searchPatientStatusList = new ArrayList<MasPatientStatus>();
		Map patientStatusFieldsMap = new HashMap();
		try {
			if ((patientStatusName != null) || (patientStatusCode == null)) {
				searchPatientStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasPatientStatus mbg where mbg.PatientStatusName like '"
								+ patientStatusName
								+ "%' order by mbg.PatientStatusName");
			} else {
				searchPatientStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasPatientStatus mbg where mbg.PatientStatusCode like '"
								+ patientStatusCode
								+ "%' order by mbg.PatientStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientStatusFieldsMap.put("searchPatientStatusList",
				searchPatientStatusList);
		return patientStatusFieldsMap;
	}

	public boolean addPatientStatus(MasPatientStatus masPatientStatus) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masPatientStatus);
		dataSaved = true;
		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public boolean deletePatientStatus(int patientStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPatientStatus masPatientStatus = new MasPatientStatus();
		masPatientStatus = (MasPatientStatus) getHibernateTemplate().get(
				MasPatientStatus.class, patientStatusId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPatientStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPatientStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		
		Users user = new Users();
		user.setId(changedBy);
		masPatientStatus.setLastChgBy(user);
		
		masPatientStatus.setLastChgDate(currentDate);
		masPatientStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPatientStatus);
		return dataDeleted;
	}

	public boolean editPatientStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String patientStatusName = "";
		@SuppressWarnings("unused")
		String patientStatusCode = "";
		int patientStatusId = 0;
		int changedBy = 0;
		patientStatusId = (Integer) generalMap.get("id");
		patientStatusCode = (String) generalMap.get("patientStatusCode");
		patientStatusName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasPatientStatus masPatientStatus = (MasPatientStatus) getHibernateTemplate()
				.get(MasPatientStatus.class, patientStatusId);
		masPatientStatus.setId(patientStatusId);
		masPatientStatus.setPatientStatusName(patientStatusName);
		Users user = new Users();
		user.setId(changedBy);
		masPatientStatus.setLastChgBy(user);
		
		masPatientStatus.setLastChgDate(currentDate);
		masPatientStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPatientStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	// -------------------------------- Bed
	// Master-----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBedJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRoom> roomList = new ArrayList<MasRoom>();
		List<MasBedStatus> bedStatusList = new ArrayList<MasBedStatus>();
		
		List<MasDepartment> departmentListGrid = new ArrayList<MasDepartment>();
		List<MasRoom> roomListGrid = new ArrayList<MasRoom>();
		List<MasBedStatus> bedStatusListGrid = new ArrayList<MasBedStatus>();
		
		
		List<MasBed> searchBedList = new ArrayList<MasBed>();

		departmentList = getHibernateTemplate()
				.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where lower(md.Status) = 'y' and upper(dt.DepartmentTypeCode) ='WARD' or upper(dt.DepartmentTypeCode) ='DLS' ");
		roomList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRoom as mr where lower(mr.Status) = 'y'");
		bedStatusList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasBedStatus as mbs where lower(mbs.Status) = 'y'");
		
		
		departmentListGrid = getHibernateTemplate()
				.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where  upper(dt.DepartmentTypeCode) ='WARD' or upper(dt.DepartmentTypeCode) ='DLS'");
		roomListGrid = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRoom as mr ");
		bedStatusListGrid = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasBedStatus as mbs");
		searchBedList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBed where flag ='WARD' and hospital_id='"+hospitalId+"'"); 
		map.put("departmentList", departmentList);
		map.put("roomList", roomList);
		map.put("bedStatusList", bedStatusList);
		
		map.put("departmentListGrid", departmentListGrid);
		map.put("roomListGrid", roomListGrid);
		map.put("bedStatusListGrid", bedStatusListGrid);
		
		map.put("searchBedList", searchBedList);
		return map;
	}

	public Map<String, Object> searchBed(String bedNumber, int hospitalId) {
		List<MasBed> searchBedList = new ArrayList<MasBed>();
		Map<String, Object> bedFieldsMap = new HashMap<String, Object>();
		List departmentList = new ArrayList();
		List roomList = new ArrayList();
		List bedStatusList = new ArrayList();
		List<MasDepartment> departmentListGrid = new ArrayList<MasDepartment>();
		List<MasRoom> roomListGrid = new ArrayList<MasRoom>();
		List<MasBedStatus> bedStatusListGrid = new ArrayList<MasBedStatus>();
		Session session = (Session) getSession();
		try {
			if ((bedNumber != null)) {
			/*	searchBedList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBed as mb where  mb.Flag ='WARD' and lower(mb.BedNo) like '"
								+ bedNumber.toLowerCase() + "%'  order by mb.BedNo");
				*/
				
				searchBedList = session.createCriteria(MasBed.class).add(Restrictions.like("BedNo", bedNumber).ignoreCase())
						.add(Restrictions.eq("Flag", "WARD")).add(Restrictions.eq("Hospital.Id", hospitalId))
						.addOrder(Order.asc("BedNo")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = getHibernateTemplate()
				.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where lower(md.Status) = 'y' and upper(dt.DepartmentTypeCode) ='WARD'");
		roomList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRoom as mr where lower(mr.Status) = 'y'");
		bedStatusList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasBedStatus as mbs where lower(mbs.Status) = 'y'");
		
		
		departmentListGrid = getHibernateTemplate()
				.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where  upper(dt.DepartmentTypeCode) ='WARD'");
		roomListGrid = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRoom as mr ");
		bedStatusListGrid = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasBedStatus as mbs");
		bedFieldsMap.put("departmentListGrid", departmentListGrid);
		bedFieldsMap.put("roomListGrid", roomListGrid);
		bedFieldsMap.put("bedStatusListGrid", bedStatusListGrid);
		bedFieldsMap.put("searchBedList", searchBedList);
		bedFieldsMap.put("departmentList", departmentList);
		bedFieldsMap.put("roomList", roomList);
		bedFieldsMap.put("bedStatusList", bedStatusList);
		return bedFieldsMap;
	}

	public boolean addBed(MasBed masBed) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBed);
		hbt.flush();
		hbt.clear();
		
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBed(int bedId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBed masBed = new MasBed();
		masBed = (MasBed) getHibernateTemplate().get(MasBed.class, bedId);
		@SuppressWarnings("unused")
		Integer departmentId = masBed.getDepartment().getId();
		Integer bedStatusId = masBed.getBedStatus().getId();
		Integer roomId = masBed.getRoom().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=(Integer)generalMap.get(RequestConstants.USER_ID);

		if (generalMap.get("flag") != null) {
			List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ bedId + "' and lower(isc.Status)='y'");
			List bedStatusList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasBedStatus as isc where isc.Id='"
							+ bedId + "' and lower(isc.Status)='y'");
			List roomList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRoom as isc where isc.Id='"
							+ bedId + "' and lower(isc.Status)='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBed.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBed.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masBed.setLastChgBy(users);
		masBed.setLastChgDate(currentDate);
		masBed.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBed);
		return dataDeleted;
	}

	public boolean editBedToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String bedNumber = "";
		int bedId = 0;
		int roomId = 0;
		int bedStatusId = 0;
		int departmentId = 0;
		String adNo = "";
		String dietType = "";
		String attached = "";
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();
		bedId = (Integer) generalMap.get("id");
		bedNumber = (String) generalMap.get("bedNumber");
		departmentId = (Integer) generalMap.get("departmentId");
		roomId = (Integer) generalMap.get("roomId");
		bedStatusId = (Integer) generalMap.get("bedStatusId");
		adNo = (String) generalMap.get("adNo");
		dietType = (String) generalMap.get("dietType");
		attached = (String) generalMap.get("attached");
		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=(Integer)generalMap.get(RequestConstants.USER_ID);

		MasBed masBed = (MasBed) getHibernateTemplate()
				.get(MasBed.class, bedId);

		masBed.setId(bedId);
		masBed.setBedNo(bedNumber);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masBed.setDepartment(masDepartment);

		MasBedStatus masBedStatus = new MasBedStatus();
		masBedStatus.setId(bedStatusId);
		masBed.setBedStatus(masBedStatus);

		MasRoom masRoom = new MasRoom();
		masRoom.setId(roomId);
		masBed.setRoom(masRoom);

		masBed.setDietType(dietType);
		masBed.setAdNo(adNo);
		masBed.setAttached(attached);
		masBed.setFlag("WARD");
		masBed.setStatus("y");
		Users users=new Users();
		users.setId(userId);
		masBed.setLastChgBy(users);
		masBed.setLastChgDate(changedDate);
		masBed.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masBed);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	// ----------------------------------COMPLAINT--------------
	public Map<String, Object> showComplaintJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasComplaint> searchComplaintList = new ArrayList<MasComplaint>();
		searchComplaintList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaint ");
		map.put("searchComplaintList", searchComplaintList);
		return map;
	}

	public Map<String, Object> searchComplaint(String complaintCode,
			String complaintName) {

		List<MasComplaint> searchComplaintList = new ArrayList<MasComplaint>();
		Map<String, Object> complaintFieldsMap = new HashMap<String, Object>();
		try {
			if ((complaintName != null) || (complaintCode == null)) {
				searchComplaintList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasComplaint imc where imc.ComplaintName like '"
								+ complaintName
								+ "%' order by imc.ComplaintName");
			} else {
				searchComplaintList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasComplaint imc where imc.ComplaintCode like '"
								+ complaintCode
								+ "%' order by imc.ComplaintCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		complaintFieldsMap.put("searchComplaintList", searchComplaintList);
		return complaintFieldsMap;
	}

	public boolean addComplaint(MasComplaint masComplaint) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masComplaint);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean addprinterDetails(PrinterCofiguration printerCofiguration) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(printerCofiguration);
		successfullyAdded = true;
		return successfullyAdded;
	}


	public boolean editComplaintToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String complaintName = "";
		@SuppressWarnings("unused")
		String complaintCode = "";
		int complaintId = 0;
		int changedBy = 0;
		complaintId = (Integer) generalMap.get("id");
		complaintCode = (String) generalMap.get("complaintCode");
		complaintName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasComplaint masComplaint = (MasComplaint) getHibernateTemplate().get(
				MasComplaint.class, complaintId);
		masComplaint.setId(complaintId);
		masComplaint.setComplaintName(complaintName);
		Users users=new Users();
		users.setId(changedBy);
		masComplaint.setLastChgBy(users);
		masComplaint.setLastChgDate(currentDate);
		masComplaint.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masComplaint);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteComplaint(int complaintId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasComplaint masComplaint = new MasComplaint();
		masComplaint = (MasComplaint) getHibernateTemplate().get(
				MasComplaint.class, complaintId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masComplaint.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masComplaint.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masComplaint.setLastChgBy(users);
		
		masComplaint.setLastChgDate(currentDate);
		masComplaint.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masComplaint);
		return dataDeleted;
	}

	// -----------------------------------------Main Charge
	// Code-------------------------------------
	public boolean addMainChargecode(Map<String, Object> mainChargecodeMap) {
		boolean saveFlag = false;
		Date finalCurrentDate = new Date();
		String mainChargecodeCode = (String) mainChargecodeMap
				.get("mainChargecodeCode");
		String mainChargecodeName = (String) mainChargecodeMap
				.get("mainChargecodeName");
		String status = (String) mainChargecodeMap.get("status");
		String changedBy = (String) mainChargecodeMap.get("changedBy");
		String currentDate = (String) mainChargecodeMap.get("currentDate");
		String currentTime = (String) mainChargecodeMap.get("currentTime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			finalCurrentDate = sdf.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setMainChargecodeCode(mainChargecodeCode);
		masMainChargecode.setMainChargecodeName(mainChargecodeName);
		masMainChargecode.setStatus(status);
		//commented for maven
		/*masMainChargecode.setLastChgBy(changedBy);*/
		masMainChargecode.setLastChgDate(finalCurrentDate);
		masMainChargecode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMainChargecode);
		saveFlag = true;
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public List getMainChargecodeListByName(
			Map<String, Object> mainChargecodeEnquiryMap) {
		List listByMainChargecodeName = new ArrayList();
		String mainChargecodeName = (String) mainChargecodeEnquiryMap
				.get("mainChargecodeName");
		listByMainChargecodeName = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode  as mcm order by ctm.MainChargecodeName "
						+ "where mcm.Status = 'y' and mcm.MainChargecodeName like '"
						+ mainChargecodeName + "%'");
		return listByMainChargecodeName;
	}



	// --------------------------------------------------COMPLICATION-----------------------------

	public boolean addComplication(MasComplication masComplication) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masComplication);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editComplicationToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String complicationName = "";
		@SuppressWarnings("unused")
		String complicationCode = "";
		int complicationId = 0;
		int changedBy = 0;
		complicationId = (Integer) generalMap.get("id");
		complicationCode = (String) generalMap.get("complicationCode");
		complicationName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasComplication masComplication = (MasComplication) getHibernateTemplate()
				.get(MasComplication.class, complicationId);

		masComplication.setId(complicationId);
		masComplication.setComplicationName(complicationName);
		Users users=new Users();
		users.setId(changedBy);
		masComplication.setLastChgBy(users);
		
		masComplication.setLastChgDate(currentDate);
		masComplication.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masComplication);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> searchComplication(String complicationCode,
			String complicationName) {
		List<MasComplication> searchComplicationList = new ArrayList<MasComplication>();
		Map<String, Object> complicationFieldsMap = new HashMap<String, Object>();
		try {
			if ((complicationName != null) || (complicationCode == null)) {
				searchComplicationList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasComplication imc where imc.ComplicationName like '"
								+ complicationName
								+ "%' order by imc.ComplicationName");
			} else {
				searchComplicationList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasComplication imc where imc.ComplicationCode like '"
								+ complicationCode
								+ "%' order by imc.ComplicationCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		complicationFieldsMap.put("searchComplicationList",
				searchComplicationList);
		return complicationFieldsMap;
	}

	public Map<String, Object> showComplicationJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasComplication> searchComplicationList = new ArrayList<MasComplication>();
		searchComplicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplication ");
		map.put("searchComplicationList", searchComplicationList);
		return map;

	}

	public boolean deleteComplication(int complicationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasComplication masComplication = new MasComplication();
		masComplication = (MasComplication) getHibernateTemplate().get(
				MasComplication.class, complicationId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masComplication.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masComplication.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masComplication.setLastChgBy(users);
		
		masComplication.setLastChgDate(currentDate);
		masComplication.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masComplication);

		return dataDeleted;
	}

	// ------------------------------- Authoraizer
	// -------------------------------

	public boolean addAuthorizer(MasAuthorizer masAuthorizer) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAuthorizer);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editAuthorizerToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String authorizerName = "";
		@SuppressWarnings("unused")
		String authorizerCode = "";
		int authorizerId = 0;
		String changedBy = "";
		BigDecimal maxAuthorizeAmt = new BigDecimal(0);
		BigDecimal minAuthorizeAmt = new BigDecimal(0);

		authorizerId = (Integer) generalMap.get("id");
		authorizerCode = (String) generalMap.get("authorizerCode");
		authorizerName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAuthorizer masAuthorizer = (MasAuthorizer) getHibernateTemplate()
				.get(MasAuthorizer.class, authorizerId);

		masAuthorizer.setId(authorizerId);
		masAuthorizer.setAuthorizerName(authorizerName);
		if (generalMap.get("maxAuthorizeAmt") != null) {
			maxAuthorizeAmt = (BigDecimal) generalMap.get("maxAuthorizeAmt");
			masAuthorizer.setMaxAuthorizeAmt(maxAuthorizeAmt);
		}
		if (generalMap.get("minAuthorizeAmt") != null) {
			minAuthorizeAmt = (BigDecimal) generalMap.get("minAuthorizeAmt");
			masAuthorizer.setMinAuthorizeAmt(minAuthorizeAmt);
		}
//		masAuthorizer.setLastChgBy(changedBy);
		masAuthorizer.setLastChgDate(currentDate);
		masAuthorizer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAuthorizer);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchAuthorizer(String authorizerCode,
			String authorizerName) {

		List<MasAuthorizer> searchAuthorizerList = new ArrayList<MasAuthorizer>();
		Map<String, Object> authorizerFieldsMap = new HashMap<String, Object>();
		try {
			if ((authorizerName != null) || (authorizerCode == null)) {
				searchAuthorizerList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasAuthorizer imc where lower(imc.AuthorizerName) like '"
								+ authorizerName.toLowerCase()
								+ "%' order by imc.AuthorizerName");
			} else {
				searchAuthorizerList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasAuthorizer imc where lower(imc.AuthorizerCode) like '"
								+ authorizerCode.toLowerCase()
								+ "%' order by imc.AuthorizerCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		authorizerFieldsMap.put("searchAuthorizerList", searchAuthorizerList);
		return authorizerFieldsMap;
	}

	public Map<String, Object> showAuthorizerJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAuthorizer> searchAuthorizerList = new ArrayList<MasAuthorizer>();
		searchAuthorizerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAuthorizer ");
		map.put("searchAuthorizerList", searchAuthorizerList);
		return map;
	}

	public boolean deleteAuthorizer(int authorizerId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAuthorizer masAuthorizer = new MasAuthorizer();
		masAuthorizer = (MasAuthorizer) getHibernateTemplate().get(
				MasAuthorizer.class, authorizerId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAuthorizer.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAuthorizer.setStatus("y");
				dataDeleted = false;
			}
		}
//		masAuthorizer.setLastChgBy(changedBy);
		masAuthorizer.setLastChgDate(currentDate);
		masAuthorizer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAuthorizer);
		return dataDeleted;
	}

	// --------------------------------Department ---------------------

	@SuppressWarnings("unchecked")
	public List<MasDepartmentType> getDepartmentTypeList() {
		List<MasDepartmentType> departmentTypeList = new ArrayList<MasDepartmentType>();
		departmentTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartmentType as dtm where lower(dtm.Status) = 'y'");
		return departmentTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<MasCostCenter> getCostCenterList() {
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		costCenterList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasCostCenter as dtm where lower(dtm.Status) = 'y'");
		return costCenterList;
	}

	public boolean addDepartment(MasDepartment masDepartment) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDepartment);
		dataSaved = true;
		return dataSaved;
	}

	public boolean updateDepartment(Map<String, Object> generalMap) {
		boolean dataFixed = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int departmentId = 0;
		String departmentName = "";
		int departmentTypeId = 0;
		int costCenterId = 0;
		String status = "";
		String changedBy = "";
		departmentId = (Integer) generalMap.get("id");
		departmentName = (String) generalMap.get("name");
		departmentTypeId = (Integer) generalMap.get("departmentTypeId");
		costCenterId = (Integer) generalMap.get("costCenterId");
		status = (String) generalMap.get("status");
		changedBy = (String) generalMap.get("userName");

		MasDepartment masDepartment = (MasDepartment) getHibernateTemplate()
				.get(MasDepartment.class, departmentId);

		masDepartment.setDepartmentName(departmentName);

		MasDepartmentType masDepartmentType = new MasDepartmentType();
		masDepartmentType.setId(departmentTypeId);
		masDepartment.setDepartmentType(masDepartmentType);

		MasCostCenter masCostCenter = new MasCostCenter();
		masCostCenter.setId(costCenterId);
		masDepartment.setCostCenter(masCostCenter);

		masDepartment.setStatus(status);
		//commented for maven
		/*masDepartment.setLastChgBy(changedBy);*/
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		dataFixed = true;

		return dataFixed;
	}

	public boolean deleteDepartment(int departmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDepartment masDepartment = new MasDepartment();
		masDepartment = (MasDepartment) getHibernateTemplate().get(
				MasDepartment.class, departmentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDepartment.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDepartment.setStatus("y");
				dataDeleted = false;
			}
		}
		
		//commented for maven
		/*masDepartment.setLastChgBy(changedBy);*/
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		return dataDeleted;
	}

	// ---------------------------- Room ---------------------------

	public boolean addRoom(MasRoom masRoom) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRoom);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editRoomToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int roomTypeId = 0;
		int departmentId = 0;
		@SuppressWarnings("unused")
		String roomCode = "";
		int roomId = 0;
		String changedBy = "";
		roomId = (Integer) generalMap.get("id");
		roomCode = (String) generalMap.get("roomCode");
		roomTypeId = (Integer) generalMap.get("roomTypeId");
		departmentId = (Integer) generalMap.get("departmentId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		MasRoom masRoom = (MasRoom) getHibernateTemplate().get(MasRoom.class,
				roomId);
		
		masRoom.setId(roomId);

		MasRoomType masRoomType = new MasRoomType();
		masRoomType.setId(roomTypeId);
		masRoom.setRoomType(masRoomType);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masRoom.setDepartment(masDepartment);

		Users users=new Users();
		users.setId(userId);
		masRoom.setLastChgBy(users);
		masRoom.setLastChgDate(currentDate);
		masRoom.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRoom);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchRoom(String roomCode) {
		List<MasRoom> searchRoomList = new ArrayList<MasRoom>();
		List roomTypeList = null;
		List departmentList = null;
		Map<String, Object> roomFieldsMap = new HashMap<String, Object>();
		List gridRoomTypeList = null;
		List gridDepartmentList = null;
		try {
			if (roomCode != null) {
				searchRoomList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRoom as i where lower(i.RoomCode) like '"
								+ roomCode.toLowerCase() + "%' order by i.RoomCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRoomType as isc where lower(isc.Status) = 'y'");
		gridRoomTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRoomType");

		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y' ");

		roomFieldsMap.put("gridRoomTypeList", gridRoomTypeList);
		roomFieldsMap.put("gridDepartmentList", gridDepartmentList);
		roomFieldsMap.put("searchRoomList", searchRoomList);
		roomFieldsMap.put("roomTypeList", roomTypeList);
		roomFieldsMap.put("departmentList", departmentList);
		return roomFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRoomJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRoom> searchRoomList = new ArrayList<MasRoom>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasRoomType> gridRoomTypeList = new ArrayList<MasRoomType>();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		searchRoomList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRoom ");
		gridRoomTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRoomType as isc");
		roomTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasRoomType as isc where lower(isc.Status) = 'y'");

		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y'");
		map.put("searchRoomList", searchRoomList);
		map.put("roomTypeList", roomTypeList);
		map.put("gridRoomTypeList", gridRoomTypeList);
		map.put("departmentList", departmentList);
		map.put("gridDepartmentList", gridDepartmentList);
		return map;
	}

	public boolean deleteRoom(int roomId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRoom masRoom = new MasRoom();
		masRoom = (MasRoom) getHibernateTemplate().get(MasRoom.class, roomId);
		@SuppressWarnings("unused")
		Integer roomTypeId = masRoom.getRoomType().getId();
		Integer departmentId = masRoom.getDepartment().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		if (generalMap.get("flag") != null) {
			@SuppressWarnings("unused")
			List roomTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRoomType as isc where isc.Id='"
							+ roomId + "' and lower(isc.Status)='y'");
			List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ roomId + "' and lower(isc.Status)='y'");

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masRoom.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masRoom.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masRoom.setLastChgBy(users);
		masRoom.setLastChgDate(currentDate);
		masRoom.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRoom);
		return dataDeleted;
	}

	// -----------------------ICD Sub Category
	// -----------------------------------
	public boolean addIcdSubCategory(MasIcdSubCategory masIcdSubCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masIcdSubCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteIcdSubCategory(int icdSubCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasIcdSubCategory masIcdSubCategory = new MasIcdSubCategory();
		masIcdSubCategory = (MasIcdSubCategory) getHibernateTemplate().get(
				MasIcdSubCategory.class, icdSubCategoryId);
		@SuppressWarnings("unused")
		Integer icdMainCategoryId = masIcdSubCategory.getIcdMaincategory()
				.getId();
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			List icdMainCategoryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasIcdMainCategory as isc where isc.Id='"
							+ icdSubCategoryId + "' and lower(isc.Status)='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masIcdSubCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masIcdSubCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		
		Users users=new Users();
		users.setId(changedBy);
		masIcdSubCategory.setLastChgBy(users);
		masIcdSubCategory.setLastChgDate(currentDate);
		masIcdSubCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdSubCategory);
		return dataDeleted;
	}

	public boolean editIcdSubCategoryToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int icdMainCategoryId = 0;
		String icdSubCategoryName = "";
		@SuppressWarnings("unused")
		String icdSubCategoryCode = "";
		int icdSubCategoryId = 0;
		int changedBy = 0;
		icdSubCategoryId = (Integer) generalMap.get("id");
		icdSubCategoryCode = (String) generalMap.get("icdSubCategoryCode");
		icdSubCategoryName = (String) generalMap.get("name");
		icdMainCategoryId = (Integer) generalMap.get("icdMainCategoryId");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasIcdSubCategory masIcdSubCategory = (MasIcdSubCategory) getHibernateTemplate()
				.get(MasIcdSubCategory.class, icdSubCategoryId);

		masIcdSubCategory.setId(icdSubCategoryId);
		masIcdSubCategory.setIcdSubCategoryName(icdSubCategoryName);

		MasIcdMainCategory masIcdMainCategory = new MasIcdMainCategory();
		masIcdMainCategory.setId(icdMainCategoryId);
		masIcdSubCategory.setIcdMaincategory(masIcdMainCategory);

		Users users=new Users();
		users.setId(changedBy);
		masIcdSubCategory.setLastChgBy(users);
		masIcdSubCategory.setLastChgDate(currentDate);
		masIcdSubCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdSubCategory);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchIcdSubCategory(String icdSubCategoryCode,
			String icdSubCategoryName) {
		List<MasIcdSubCategory> searchIcdSubCategoryList = new ArrayList<MasIcdSubCategory>();
		List icdMainCategoryList = null;
		Map<String, Object> icdSubCategoryFieldsMap = new HashMap<String, Object>();
		List gridIcdMainCategoryList = null;
		try {
			if ((icdSubCategoryName != null) || (icdSubCategoryCode == null)) {
				searchIcdSubCategoryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasIcdSubCategory as i where i.IcdSubCategoryName like '"
								+ icdSubCategoryName
								+ "%' order by i.IcdSubCategoryName");
			} else {
				searchIcdSubCategoryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasIcdSubCategory as i where i.IcdSubCategoryCode like '"
								+ icdSubCategoryCode
								+ "%' order by i.IcdSubCategoryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		icdMainCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasIcdMainCategory as isc where lower(isc.Status) = 'y'");
		gridIcdMainCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdMainCategory as isc");
		icdSubCategoryFieldsMap.put("gridIcdMainCategoryList",
				gridIcdMainCategoryList);
		icdSubCategoryFieldsMap.put("searchIcdSubCategoryList",
				searchIcdSubCategoryList);
		icdSubCategoryFieldsMap.put("icdMainCategoryList", icdMainCategoryList);
		return icdSubCategoryFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIcdSubCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcdSubCategory> searchIcdSubCategoryList = new ArrayList<MasIcdSubCategory>();
		List<MasIcdMainCategory> icdMainCategoryList = new ArrayList<MasIcdMainCategory>();
		List<MasIcdMainCategory> gridIcdMainCategoryList = new ArrayList<MasIcdMainCategory>();
		searchIcdSubCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdSubCategory ");
		gridIcdMainCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdMainCategory as isc");
		icdMainCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasIcdMainCategory as isc where lower(isc.Status) = 'y'");
		map.put("searchIcdSubCategoryList", searchIcdSubCategoryList);
		map.put("icdMainCategoryList", icdMainCategoryList);
		map.put("gridIcdMainCategoryList", gridIcdMainCategoryList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getDepartmentList() {
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as dm where lower(dm.Status)='y'");
		return departmentList;
	}

	// -------------------------------------Charge Code
	// Master--------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchChargeCode(Map<String, Object> map) {
		List<MasChargeCode> searchChargeCodeList = new ArrayList<MasChargeCode>();
		List chargeTypeList = null;
		List departmentList = null;
		List mainChargeList = null;
		List subChargecodeList = null;
		List sampleList = null;
		List unitOfMeasurementList = null;
		List subTestList = null;

		List gridChargeTypeList = null;
		List gridDepartmentList = null;
		List gridMainChargecodeList = null;
		List gridSubChargecodeList = null;
		List gridUnitOfMeasurementList = null;
		List gridSampleList = null;
		List gridSubTestList = null;
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subAccountList = new ArrayList<FaMasSubLed>();
		int mas_main_charge_id=0;
		String chargeCodeName=null;
		String chargeCodeCode=null;
		if(map.get("mas_main_charge_id")!=null){
			mas_main_charge_id=(Integer)map.get("mas_main_charge_id");
		}
		if(map.get("mas_main_charge_id")!=null){
			chargeCodeName=(String)map.get("chargeCodeName");
		}
		if(map.get("mas_main_charge_id")!=null){
			chargeCodeCode=(String)map.get("chargeCodeCode");
		}
		try {
			if (mas_main_charge_id == 0) {
				if ((chargeCodeName != null) || (chargeCodeCode == null)) {
					
					searchChargeCodeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasChargeCode as i where upper(i.ChargeCodeName) like upper('"
									+ chargeCodeName
									+ "%') order by i.ChargeCodeName");
				} else {
					searchChargeCodeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasChargeCode as i where i.ChargeCodeCode like '"
									+ chargeCodeCode
									+ "%' order by i.ChargeCodeCode");
				}
			} else{
				if ((chargeCodeName != null) || (chargeCodeCode == null)) {
					
					searchChargeCodeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasChargeCode as i where upper(i.ChargeCodeName) like upper('"
									+ chargeCodeName
									+ "%') and i.MainChargecode = "
									+ mas_main_charge_id
									+ " order by i.ChargeCodeName");
				}
				if ((chargeCodeName == null) || (chargeCodeCode != null)) {
					searchChargeCodeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasChargeCode as i where i.ChargeCodeCode like '"
									+ chargeCodeCode
									+ "%' and i.MainChargecode = "
									+ mas_main_charge_id
									+ " order by i.ChargeCodeCode");
				}
				if ((chargeCodeName == null) || (chargeCodeCode == null)) {
					
					searchChargeCodeList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasChargeCode as i where i.MainChargecode = "
									+ mas_main_charge_id
									+ " order by i.ChargeCodeName");
				}
				
				
			} 
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		chargeTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasChargeType as isc where lower(isc.Status) = 'y' order by ChargeTypeName");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y' order by DepartmentName");
		subChargecodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubChargecode as isc where lower(isc.Status) = 'y' order by SubChargecodeName");
		sampleList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSample as isc where lower(isc.Status) = 'y' order by SampleDescription");
		mainChargeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as isc where lower(isc.Status) = 'y' order by MainChargecodeName");
		unitOfMeasurementList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasUnitOfMeasurement as uomm where lower(uomm.Status)='y'");
		subTestList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubTest as stm where lower(stm.Status) = 'y'");

		accountList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.FaMasAccount as isc where lower(isc.Status) = 'y'");
		subAccountList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.FaMasSubLed as stm where lower(stm.Status) = 'y'");

		gridChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType as stm where lower(stm.Status) = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as stm where lower(stm.Status) = 'y'");
		gridSubChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode as stm where lower(stm.Status) = 'y'");
		gridSampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample as stm where lower(stm.Status) = 'y'");
		gridMainChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode as stm where lower(stm.Status) = 'y'");
		gridUnitOfMeasurementList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnitOfMeasurement as stm where lower(stm.Status) = 'y'");
		gridSubTestList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubTest as stm where lower(stm.Status) = 'y'");

		map.put("gridChargeTypeList", gridChargeTypeList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("gridSubChargecodeList", gridSubChargecodeList);
		map.put("gridSubTestList", gridSubTestList);
		map.put("gridSampleList", gridSampleList);
		map.put("gridMainChargecodeList", gridMainChargecodeList);
		map.put("gridUnitOfMeasurementList", gridUnitOfMeasurementList);
		map.put("accountList", accountList);
		map.put("subAccountList", subAccountList);

		map.put("searchChargeCodeList", searchChargeCodeList);
		map.put("subTestList", subTestList);
		map.put("chargeTypeList", chargeTypeList);
		map.put("subChargeList", subChargecodeList);
		map.put("departmentList", departmentList);
		map.put("mainChargeList", mainChargeList);
		map.put("subChargecodeList", subChargecodeList);
		map.put("sampleList", sampleList);
		map.put("unitOfMeasurementList", unitOfMeasurementList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public List<MasUnitOfMeasurement> getUnitOfMeasurementList() {
		List<MasUnitOfMeasurement> unitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		unitOfMeasurementList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasUnitOfMeasurement as uomm where lower(uomm.Status)='y'");
		return unitOfMeasurementList;
	}

	public boolean addChargeCode(Map<String, Object> dataMap) {
		MasChargeCode masChargeCode = new MasChargeCode();
		MasChargeCodeRates chargeCodeRates = new MasChargeCodeRates();
		if (dataMap.get("masChargeCode") != null) {
			masChargeCode = (MasChargeCode) dataMap.get("masChargeCode");
		}
		if (dataMap.get("chargeCodeRates") != null) {
			chargeCodeRates = (MasChargeCodeRates) dataMap
					.get("chargeCodeRates");
		}

		boolean dataSaved = false;
		Transaction tx = null;
		Session session = (Session) getSession();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masChargeCode);

			chargeCodeRates.setChargeCode(masChargeCode);
			hbt.save(chargeCodeRates);
			hbt.flush();
			hbt.clear();
			dataSaved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showChargeCodeJsp(Map<String, Object> map) {
		List<MasChargeCode> searchChargeCodeList = new ArrayList<MasChargeCode>();
		List<MasChargeType> chargeTypeList = new ArrayList<MasChargeType>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeList = new ArrayList<MasSubChargecode>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subAccountList = new ArrayList<FaMasSubLed>();

		/*searchChargeCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeCode");*/ /* where Lower(Status)='y'"Lower(Status)='y'  and*/
		/*searchChargeCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasHospitalwiseChargecode where  Hospital="+hospitalId+"");*/
		mainChargeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as isc where upper(isc.Status) = upper('y') order by MainChargecodeName");
		subChargeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubChargecode as isc where upper(isc.Status) = upper('y') order by SubChargecodeName");
		chargeTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasChargeType as isc where upper(isc.Status) = upper('y') order by ChargeTypeName");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where upper(isc.Status) = upper('y') order by DepartmentName");
		accountList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.FaMasAccount as isc where upper(isc.Status) = upper('y') ");
		subAccountList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.FaMasSubLed as stm where upper(stm.Status) = upper('y')");

		map.put("searchChargeCodeList", searchChargeCodeList);
		map.put("chargeTypeList", chargeTypeList);
		map.put("departmentList", departmentList);
		map.put("subChargeList", subChargeList);
		map.put("accountList", accountList);
		map.put("mainChargeList", mainChargeList);
		map.put("subAccountList", subAccountList);

		return map;
	}

	public boolean deleteSubTest(Integer subTestId) {
		@SuppressWarnings("unused")
		boolean deletedSuccesfully = false;
		try {
			MasSubTest test = (MasSubTest) getHibernateTemplate().get(
					MasSubTest.class, subTestId);
			test.setStatus("n");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(test);
			deletedSuccesfully = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedSuccesfully;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteChargeCode(Integer chargeCodeId) {

		boolean dataDeleted = false;
		List<MasSubTest> subTestListForSaving = new ArrayList<MasSubTest>();
		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode = (MasChargeCode) getHibernateTemplate().get(
				MasChargeCode.class, chargeCodeId);
		@SuppressWarnings("unused")
		Integer mainChargecodeId = masChargeCode.getMainChargecode().getId();
		Integer subChargecodeId = masChargeCode.getSubChargecode().getId();
		Integer departmentId = masChargeCode.getDepartment().getId();
		Integer chargeTypeId = masChargeCode.getChargeType().getId();
		Integer accTypeId = masChargeCode.getAccount().getId();
		if (masChargeCode.getStatus().equals("y")) {
			List subTestList = (List) masChargeCode.getMasSubTests();

			if (subTestList != null) {
				for (Iterator subTestIterator = subTestList.iterator(); subTestIterator
						.hasNext();) {
					MasSubTest subTest = (MasSubTest) subTestIterator.next();
					subTest.setStatus("n");
					MasChargeCode masChargeCode1 = new MasChargeCode();
					masChargeCode1.setId(masChargeCode.getId());
					subTest.setChargeCode(masChargeCode);
					subTestListForSaving.add(subTest);
				}
			}
			@SuppressWarnings("unused")
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ chargeCodeId + "' and lower(isc.Status)='y'");
			List subChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ chargeCodeId + "' and lower(isc.Status)='y'");
			List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ chargeCodeId + "' and lower(isc.Status)='y'");
			List chargeTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasChargeType as isc where isc.Id='"
							+ chargeCodeId + "' and lower(isc.Status)='y'");
			List accTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasAccountType as isc where isc.Id='"
							+ chargeCodeId + "' and lower(isc.Status)='y'");
			masChargeCode.setStatus("n");
			dataDeleted = true;
		} else {
			masChargeCode.setStatus("y");
			List subTestList = (List) masChargeCode.getMasSubTests();
			if (subTestList != null) {
				for (Iterator subTestIterator = subTestList.iterator(); subTestIterator
						.hasNext();) {
					MasSubTest subTest = (MasSubTest) subTestIterator.next();
					subTest.setStatus("y");
					MasChargeCode masChargeCode1 = new MasChargeCode();
					masChargeCode1.setId(masChargeCode.getId());
					subTest.setChargeCode(masChargeCode);
					subTestListForSaving.add(subTest);
				}
			}
			dataDeleted = false;
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masChargeCode);
		if (!subTestListForSaving.isEmpty()) {
			for (int k = 0; k < subTestListForSaving.size(); k++) {
				MasSubTest subTest = subTestListForSaving.get(k);
				getHibernateTemplate().saveOrUpdate(subTest);
			}

		}

		return dataDeleted;

	}

	@SuppressWarnings("unchecked")
	public boolean checkChargeCodeExsist(String chargeCodeCode,
			String chargeCodeName) {
		List chargeCodeExsistList = null;
		boolean chargeCodeExsist = true;
		try {
			chargeCodeExsistList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasChargeCode as ccm where ccm.ChargeCodeCode = '"
							+ chargeCodeCode
							+ "' or ccm.ChargeCodeName = '"
							+ chargeCodeName + "' ");
			if (chargeCodeExsistList.size() > 0) {
				chargeCodeExsist = false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return chargeCodeExsist;
	}

	@SuppressWarnings("unchecked")
	public boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
			String chargeCodeName) {
		List chargeCodeExsistList = null;
		boolean chargeCodeNameExsistForEdition = true;
		chargeCodeExsistList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasChargeCode as ccm where ccm.ChargeCodeName = '"
						+ chargeCodeName + "'and ccm.Id != " + chargeCodeId);
		if (chargeCodeExsistList.size() > 0) {
			chargeCodeNameExsistForEdition = false;
		}
		return chargeCodeNameExsistForEdition;
	}

	@SuppressWarnings("unchecked")
	public boolean editChargeCode(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int mainChargeId = 0;
		int departmentId = 0;
		int subChargeId = 0;
		int chargeTypeId = 0;
		int accountId = 0;
		int subAccountId = 0;
		int chargeId = 0;
		float charge = 0;

		String chargeName = "";
		String chargeCode = "";
		String changedBy = "";
		String currentTime = "";
		String editable = "";
		String discountable = "";
		String drAccountRequired = "";
		String opd_related_services ="";
		String proceCode = "";
		String pacsInteg = "";
		String telemediInteg = "";
		Date currentDate = new Date();
		Date effactiveFromDate = new Date();
		Date effactiveToDate = new Date();
		String CommonChargeCodeStatus=null;
		BigDecimal discountPercentage = new BigDecimal(0);
		BigDecimal stdDeductionGen = new BigDecimal(0.00);
		BigDecimal stdDeductionSpl = new BigDecimal(0.00);
		
		Session session = (Session) getSession();
		Transaction tnx=null;
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try
		{
			tnx=session.beginTransaction();
			chargeId = (Integer) generalMap.get("id");
			mainChargeId = (Integer) generalMap.get("mainChargeId");
			subChargeId = (Integer) generalMap.get("subchargeId");
			departmentId = (Integer) generalMap.get("departmentId");
			accountId = (Integer) generalMap.get("accountId");
			CommonChargeCodeStatus = (String) generalMap.get("CommonChargeCodeStatus");
			subAccountId = (Integer) generalMap.get("subAccountId");
			chargeTypeId = (Integer) generalMap.get("chargeTypeId");

			charge = (Float) generalMap.get("charge");
			chargeCode = (String) generalMap.get("chargeCode");
			chargeName = (String) generalMap.get("chargeName");
			editable = (String) generalMap.get("editable");
			discountable = (String) generalMap.get("discountable");
			drAccountRequired = (String) generalMap.get("drAccountRequired");
			opd_related_services = (String) generalMap.get("opd_related_services");

			discountPercentage = (BigDecimal) generalMap.get("discountPercentage");
			effactiveFromDate = (Date) generalMap.get("effactiveFromDate");
			effactiveToDate = (Date) generalMap.get("effactiveToDate");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			currentTime = (String) generalMap.get("currentTime");
			stdDeductionGen = (BigDecimal) generalMap.get("stdDeductionGen");
			stdDeductionSpl = (BigDecimal) generalMap.get("stdDeductionSpl");
			
			proceCode = (String) generalMap.get("proceCode");
			pacsInteg = (String) generalMap.get("pacsInteg");
			telemediInteg = (String) generalMap.get("telemediInteg");

			MasChargeCode masCharge = (MasChargeCode) getHibernateTemplate()
			.get(MasChargeCode.class, chargeId);
			masCharge.setCommonChargeCodeStatus(CommonChargeCodeStatus);
			masCharge.setId(chargeId);
			masCharge.setChargeCodeCode(chargeCode);
			masCharge.setChargeCodeName(chargeName);
			masCharge.setEditable(editable);
			masCharge.setDiscountable(discountable);
			masCharge.setDrAccountingRequired(drAccountRequired);
			masCharge.setDateEffectiveFrom(effactiveFromDate);
			// masCharge.setDateEffectiveTo(effactiveToDate);
			masCharge.setDiscountPercentage(discountPercentage);
			masCharge.setStdDeductionGen(stdDeductionGen);
			masCharge.setStdDeductionSpl(stdDeductionSpl);
			masCharge.setOpdRelatedServices(opd_related_services);
			masCharge.setProcedureCode(proceCode);
			masCharge.setChargePacsStatus(pacsInteg);
			masCharge.setTelemedicineStatus(telemediInteg);
			
			if (chargeTypeId != 0) {
				MasChargeType masChargeType = new MasChargeType();
				masChargeType.setId(chargeTypeId);
				masCharge.setChargeType(masChargeType);
			}
			if (mainChargeId != 0) {
				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				masCharge.setMainChargecode(masMainChargecode);
			}
			if (subChargeId != 0) {
				MasSubChargecode masSub = new MasSubChargecode();
				masSub.setId(subChargeId);
				masCharge.setSubChargecode(masSub);
			}
			if (departmentId != 0) {
				MasDepartment masDep = new MasDepartment();
				masDep.setId(departmentId);
				masCharge.setDepartment(masDep);
			}
			if (accountId != 0) {
				FaMasAccount faMasAccount = new FaMasAccount();
				faMasAccount.setId(accountId);
				masCharge.setAccount(faMasAccount);
			}
			if (subAccountId != 0) {
				FaMasSubLed masSubLed = new FaMasSubLed();
				masSubLed.setId(subAccountId);
				masCharge.setSubAccount(masSubLed);
			}
			 masCharge.setCharge(charge);
			Users users=new Users();
			users.setId((Integer)generalMap.get(RequestConstants.USER_ID));
			masCharge.setLastChgBy(users);
			masCharge.setLastChgDate(currentDate);
			masCharge.setLastChgTime(currentTime);
			
			hbt.update(masCharge);
			tnx.commit();session.flush();

			/**
			 *
			 * ----------------- Added By Ritu For Charge Code Rate
			 * -----------------------
			 *
			 */

			

			/*List<MasChargeCodeRates> chargeRateList = new ArrayList<MasChargeCodeRates>();
			chargeRateList = session.createCriteria(MasChargeCodeRates.class)
					.createAlias("ChargeCode", "cc")
					.add(Restrictions.eq("cc.Id", chargeId)).list();
			if (chargeRateList.size() > 0) {
				for (MasChargeCodeRates chargeRates : chargeRateList) {
					if (chargeRates.getEffectiveToDate() == null) {
						if (chargeRates.getRate().compareTo(
								new BigDecimal(charge)) != 0) {
							MasChargeCodeRates chargeCodeRates = new MasChargeCodeRates();
							MasChargeCode masChargeCode = new MasChargeCode();
							masChargeCode.setId(chargeId);
							chargeCodeRates.setChargeCode(masChargeCode);
							chargeCodeRates.setEffectiveFromDate(effactiveFromDate);
							chargeCodeRates.setRate(new BigDecimal(charge));
							hbt.save(chargeCodeRates);

							MasChargeCodeRates chargeRateObj = (MasChargeCodeRates) hbt
							.load(MasChargeCodeRates.class,	chargeRates.getId());
							int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String prevDate = dateFormat.format(effactiveFromDate.getTime()- MILLIS_IN_DAY);
							chargeRateObj.setEffectiveToDate(HMSUtil.convertStringTypeDateToDateType(prevDate));
							hbt.update(chargeRateObj);
						}
					}
				}

			} else {
				MasChargeCodeRates chargeCodeRates = new MasChargeCodeRates();
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(chargeId);
				chargeCodeRates.setChargeCode(masChargeCode);
				chargeCodeRates.setEffectiveFromDate(effactiveFromDate);
				chargeCodeRates.setRate(new BigDecimal(charge));
				hbt.save(chargeCodeRates);

			}*/
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	// --------------------------sub charge code-----------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSubChargeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> searchSubChargeList = new ArrayList<MasSubChargecode>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasMainChargecode> gridMainChargeList = new ArrayList<MasMainChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		
	
		mainChargeCodeList = session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("MainChargecodeName")).list();
		
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where upper(isc.Status) = upper('y')");
		
		searchSubChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode ");
		gridMainChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode as id");
		/*mainChargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as mc where upper(mc.Status) = upper('y')");*/
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		
		map.put("searchSubChargeList", searchSubChargeList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("gridMainChargeList", gridMainChargeList);
		map.put("departmentList", departmentList);
		map.put("gridDepartmentList", gridDepartmentList);
		return map;
	}

	public boolean addSubCharge(MasSubChargecode subChargecodeMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(subChargecodeMaster);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public Map searchSubCharge(String subChargecodeCode,
			String subChargecodeName) {

		List<MasSubChargecode> searchSubChargeList = new ArrayList<MasSubChargecode>();
		List mainChargeCodeList = null;
		Map subChargeFieldsMap = new HashMap();
		List gridMainChargeList = null;
		try {
			if ((subChargecodeName != null) || (subChargecodeCode == null)) {

				searchSubChargeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSubChargecode sc where sc.SubChargecodeName like '"
								+ subChargecodeName
								+ "%' order by sc.SubChargecodeName");
			} else {

				searchSubChargeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSubChargecode sc where sc.SubChargecodeCode like '"
								+ subChargecodeCode
								+ "%' order by sc.SubChargecodeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mainChargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as mc where lower(mc.Status) = 'y'");
		gridMainChargeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as mainChargecodeCode");
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where upper(isc.Status) = upper('y')");
gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
subChargeFieldsMap.put("departmentList", departmentList);
subChargeFieldsMap.put("gridDepartmentList", gridDepartmentList);
		subChargeFieldsMap.put("gridMainChargeList", gridMainChargeList);
		subChargeFieldsMap.put("searchSubChargeList", searchSubChargeList);
		subChargeFieldsMap.put("mainChargeCodeList", mainChargeCodeList);
		return subChargeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteSubCharge(Integer subChargecodeId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		Users changedBy = new Users();;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode = (MasSubChargecode) getHibernateTemplate().get(
				MasSubChargecode.class, subChargecodeId);

		// Integer
		// mainChargeCodeId=masSubChargecode.getMainChargecode().getId();
		changedBy = (Users) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			// @SuppressWarnings("unused")
			// List mainChargeCodeList=getHibernateTemplate().find("from
			// jkt.hms.masters.business.MasMainChargecode as isc where
			// isc.Id='"+subChargecodeId+"' and isc.Status='y'");

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSubChargecode.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSubChargecode.setStatus("y");
				dataDeleted = false;
			}
		}
		masSubChargecode.setLastChgBy(changedBy);
		masSubChargecode.setLastChgDate(currentDate);
		masSubChargecode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSubChargecode);
		return dataDeleted;
	}

	public boolean editSubChargeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int mainChargecodeId = 0;
		String subChargecodeName = "";
		@SuppressWarnings("unused")
		String subChargecodeCode = "";
		int subChargecodeId = 0;
		Users user = new Users();
		int departmentId = 0;
		if (generalMap.get("departmentId") != null) {
			departmentId = (Integer) generalMap.get("departmentId");
		}
		if (generalMap.get("id") != null) {
			subChargecodeId = (Integer) generalMap.get("id");
		}
		if (generalMap.get("subChargecodeCode") != null) {
			subChargecodeCode = (String) generalMap.get("subChargecodeCode");
		}
		if (generalMap.get("name") != null) {
			subChargecodeName = (String) generalMap.get("name");
		}

		if (generalMap.get("mainChargecodeId") != null) {
			mainChargecodeId = (Integer) generalMap.get("mainChargecodeId");
		}
		if (generalMap.get("changedBy") != null) {
			user = (Users) generalMap.get("changedBy");
		}
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		MasSubChargecode subChargecodeMaster = (MasSubChargecode) getHibernateTemplate()
				.load(MasSubChargecode.class, subChargecodeId);

		subChargecodeMaster.setId(subChargecodeId);
		subChargecodeMaster.setSubChargecodeName(subChargecodeName);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargecodeId);
		subChargecodeMaster.setMainChargecode(masMainChargecode);
		MasDepartment masDep = new MasDepartment();
		masDep.setId(departmentId);
		subChargecodeMaster.setDepartment(masDep);
		subChargecodeMaster.setLastChgBy(user);
		subChargecodeMaster.setLastChgDate(currentDate);
		subChargecodeMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(subChargecodeMaster);
		dataUpdated = true;
		return dataUpdated;

	}

	// -----------------------------I C D
	// MASTER--------------------------------------------
	public boolean addIcd(MasIcd masIcd) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masIcd);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteIcd(int icdId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasIcd masIcd = new MasIcd();
		masIcd = (MasIcd) getHibernateTemplate().get(MasIcd.class, icdId);
		@SuppressWarnings("unused")
		Integer icdSubCategoryId = masIcd.getIcdSubCategory().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			List icdSubCategoryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasIcdSubCategory as isc where isc.Id='"
							+ icdId + "' and lower(isc.Status)='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masIcd.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masIcd.setStatus("y");
				dataDeleted = false;
			}
		}
		
		//commented for maven
		/*masIcd.setLastChgBy(changedBy);*/
		masIcd.setLastChgDate(currentDate);
		masIcd.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcd);
		return dataDeleted;

	}

	public boolean editIcdToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int icdSubCategoryId = 0;
		int icdCauseId = 0;
		String icdName = "";
		@SuppressWarnings("unused")
		String icdCode = "";
		int icdId = 0;
		String changedBy = "";
		String phAlert= "";
		String alertType = "";
		Session session = (Session)getSession();
		icdId = (Integer) generalMap.get("id");
		icdCode = (String) generalMap.get("icdCode");
		icdName = (String) generalMap.get("name");
		icdSubCategoryId = (Integer) generalMap.get("icdSubCategoryId");
		icdCauseId = (Integer) generalMap.get("icdCauseId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasIcd masIcd = (MasIcd) getHibernateTemplate().get(MasIcd.class, icdId);
		String icd_code=null;
		if(masIcd!=null){
			icd_code=masIcd.getIcdCode();
		}
		
		masIcd.setId(icdId);
		masIcd.setIcdName(icdName);
		
		if (generalMap.get("phAlert") != null) {
			phAlert = (String)generalMap.get("phAlert");
		}
		
		if (generalMap.get("alertType") != null) {
			alertType = (String)generalMap.get("alertType");
		}
		
		if(phAlert.equalsIgnoreCase("y")){
			masIcd.setPhAlert("y");
			if(!alertType.equals("")){
				masIcd.setAlertType(alertType);
			}
		}else{
			masIcd.setPhAlert("n");
		}
		
		if (icdSubCategoryId != 0) {
			MasIcdSubCategory masIcdSubCategory = new MasIcdSubCategory();
			masIcdSubCategory.setId(icdSubCategoryId);
			masIcd.setIcdSubCategory(masIcdSubCategory);
		}
		if (icdCauseId != 0) {
			MasIcdcausegrp masIcdcausegrp = new MasIcdcausegrp();
			masIcdcausegrp.setId(icdCauseId);
			//commented for maven
			/*masIcd.setIcdCause(masIcdcausegrp);*/
		}
		//commented for maven
		/*masIcd.setLastChgBy(changedBy);*/
		masIcd.setLastChgDate(currentDate);
		masIcd.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		//updating all icd for a snomed..
		List<MasIcd>icdList=session.createCriteria(MasIcd.class).add(Restrictions.eq("IcdCode", icd_code)).list();
		if(generalMap.get("notifiableDisease") != null) {
			for(MasIcd icd:icdList){
				icd.setNotifiableDesease("n");
				hbt.update(icd);
			}
		}else if(generalMap.get("pregister") != null) {
			for(MasIcd icd:icdList){
				icd.setPRegister("p");
				hbt.update(icd);
			}
		}else{
			hbt.update(masIcd);
		}
		
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchIcd(String icdCode, String icdName) {
		List<MasIcd> searchIcdList = new ArrayList<MasIcd>();
		List icdSubCategoryList = null;
		Map<String, Object> icdFieldsMap = new HashMap<String, Object>();
		List<MasIcdcausegrp> icdCauseList = new ArrayList<MasIcdcausegrp>();
		List gridIcdSubCategoryList = null;
		List gridIcdCauseList = null;
		Session session = (Session)getSession();
		try {
			if ((icdName != null) || (icdCode == null)) {
				/*searchIcdList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasIcd as i where i.IcdName ilike '"
								+ icdName + "%' order by i.IcdName");*/
				searchIcdList = session.createCriteria(MasIcd.class).add(Restrictions.ilike("IcdName",icdName+"%")).addOrder(Order.asc("IcdName")).list();

			} else {
				/*searchIcdList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasIcd as i where i.IcdCode ilike '"
								+ icdCode + "%' order by i.IcdCode");*/
				searchIcdList = session.createCriteria(MasIcd.class).add(Restrictions.ilike("IcdCode",icdCode+"%")).addOrder(Order.asc("IcdName")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		icdSubCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasIcdSubCategory as isc where lower(isc.Status) = 'y'");
		gridIcdSubCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdSubCategory as isc");
		icdCauseList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasIcdcausegrp as isc where lower(isc.Status) = 'y'");
		gridIcdCauseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdcausegrp as isc");
		icdFieldsMap.put("gridIcdSubCategoryList", gridIcdSubCategoryList);
		icdFieldsMap.put("gridIcdCauseList", gridIcdCauseList);
		icdFieldsMap.put("searchIcdList", searchIcdList);
		icdFieldsMap.put("icdSubCategoryList", icdSubCategoryList);
		icdFieldsMap.put("icdCauseList", icdCauseList);
		return icdFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIcdJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> searchIcdList = new ArrayList<MasIcd>();
		List<MasIcdSubCategory> icdSubCategoryList = new ArrayList<MasIcdSubCategory>();
		List<MasIcdSubCategory> gridIcdSubCategoryList = new ArrayList<MasIcdSubCategory>();
		List<MasIcdcausegrp> icdCauseList = new ArrayList<MasIcdcausegrp>();
		List<MasIcdcausegrp> gridIcdCauseList = new ArrayList<MasIcdcausegrp>();

		/*searchIcdList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcd ");*/
		gridIcdSubCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdSubCategory as isc");
		icdSubCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasIcdSubCategory as isc where lower(isc.Status) = 'y'");
		icdCauseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdcausegrp as isc");
		gridIcdCauseList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasIcdcausegrp as isc where lower(isc.Status) = 'y'");

		map.put("searchIcdList", searchIcdList);
		map.put("icdSubCategoryList", icdSubCategoryList);
		map.put("gridIcdSubCategoryList", gridIcdSubCategoryList);
		map.put("icdCauseList", icdCauseList);
		map.put("gridIcdCauseList", gridIcdCauseList);
		return map;
	}

	// ---------------------------ICD Main
	// Category-------------------------------------

	public Map<String, Object> searchIcdMainCategory(
			String icdMainCategoryCode, String icdMainCategoryName) {
		List<MasIcdMainCategory> searchIcdMainCategoryList = new ArrayList<MasIcdMainCategory>();
		Map<String, Object> icdMainCategoryFieldsMap = new HashMap<String, Object>();
		try {
			if ((icdMainCategoryName != null) || (icdMainCategoryCode == null)) {
				searchIcdMainCategoryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasIcdMainCategory as i where i.IcdMaincategoryName like '"
								+ icdMainCategoryName
								+ "%' order by i.IcdMaincategoryName");
			} else {
				searchIcdMainCategoryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasIcdMainCategory as i where i.IcdMaincategoryCode like '"
								+ icdMainCategoryCode
								+ "%' order by i.IcdMaincategoryCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		icdMainCategoryFieldsMap.put("searchIcdMainCategoryList",
				searchIcdMainCategoryList);

		return icdMainCategoryFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIcdMainCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcdMainCategory> searchIcdMainCategoryList = new ArrayList<MasIcdMainCategory>();
		searchIcdMainCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdMainCategory ");
		map.put("searchIcdMainCategoryList", searchIcdMainCategoryList);
		return map;
	}

	public boolean addIcdMainCategory(MasIcdMainCategory masIcdMainCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masIcdMainCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editIcdMainCategoryToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String icdMainCategoryName = "";
		@SuppressWarnings("unused")
		String icdMainCategoryCode = "";
		int icdMainCategoryId = 0;
		int changedBy = 0;
		icdMainCategoryId = (Integer) generalMap.get("id");
		icdMainCategoryCode = (String) generalMap.get("icdMainCategoryCode");
		icdMainCategoryName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasIcdMainCategory masIcdMainCategory = (MasIcdMainCategory) getHibernateTemplate()
				.get(MasIcdMainCategory.class, icdMainCategoryId);

		masIcdMainCategory.setId(icdMainCategoryId);
		masIcdMainCategory.setIcdMaincategoryName(icdMainCategoryName);
		Users users=new Users();
		users.setId(changedBy);
		masIcdMainCategory.setLastChgBy(users);
		masIcdMainCategory.setLastChgDate(currentDate);
		masIcdMainCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdMainCategory);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean deleteIcdMainCategory(int icdMainCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasIcdMainCategory masIcdMainCategory = new MasIcdMainCategory();
		masIcdMainCategory = (MasIcdMainCategory) getHibernateTemplate().get(
				MasIcdMainCategory.class, icdMainCategoryId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masIcdMainCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masIcdMainCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masIcdMainCategory.setLastChgBy(users);
		masIcdMainCategory.setLastChgDate(currentDate);
		masIcdMainCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdMainCategory);
		return dataDeleted;

	}

	// ------------------------------------------ Service Type
	// ---------------------------

	public boolean addServiceType(MasServiceType masServiceType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masServiceType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteServiceType(int serviceTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasServiceType masServiceType = new MasServiceType();
		masServiceType = (MasServiceType) getHibernateTemplate().get(
				MasServiceType.class, serviceTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masServiceType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masServiceType.setStatus("y");
				dataDeleted = false;
			}
		}
		masServiceType.setLastChgBy(changedBy);
		masServiceType.setLastChgDate(currentDate);
		masServiceType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceType);
		return dataDeleted;
	}

	public boolean editServiceTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String serviceTypeName = "";
		@SuppressWarnings("unused")
		String serviceTypeCode = "";
		String shortDescription = "";
		int serviceTypeId = 0;
		String changedBy = "";
		serviceTypeId = (Integer) generalMap.get("id");
		serviceTypeCode = (String) generalMap.get("serviceTypeCode");
		serviceTypeName = (String) generalMap.get("name");
		shortDescription = (String) generalMap.get("shortDescription");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasServiceType masServiceType = (MasServiceType) getHibernateTemplate()
				.get(MasServiceType.class, serviceTypeId);

		masServiceType.setId(serviceTypeId);
		masServiceType.setServiceTypeName(serviceTypeName);
		masServiceType.setServiceNameShortDesc(shortDescription);
		masServiceType.setLastChgBy(changedBy);
		masServiceType.setLastChgDate(currentDate);
		masServiceType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceType);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showServiceTypeJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> searchServiceTypeList = new ArrayList<MasServiceType>();
		searchServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType ");
		map.put("searchServiceTypeList", searchServiceTypeList);
		return map;
	}

	public Map<String, Object> searchServiceType(String serviceTypeCode,
			String serviceTypeName) {
		List<MasServiceType> searchServiceTypeList = new ArrayList<MasServiceType>();
		Map<String, Object> serviceTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((serviceTypeName != null) || (serviceTypeCode == null)) {
				searchServiceTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasServiceType imc where imc.ServiceTypeName like '"
								+ serviceTypeName
								+ "%' order by imc.ServiceTypeName");
			} else {
				searchServiceTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasServiceType imc where imc.ServiceTypeCode like '"
								+ serviceTypeCode
								+ "%' order by imc.ServiceTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceTypeFieldsMap
				.put("searchServiceTypeList", searchServiceTypeList);
		return serviceTypeFieldsMap;
	}

	// --------------------------------------- Service Status-------
	// ---------------------------

	public boolean addServiceStatus(MasServiceStatus masServiceStatus) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masServiceStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteServiceStatus(int serviceStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasServiceStatus masServiceStatus = new MasServiceStatus();
		masServiceStatus = (MasServiceStatus) getHibernateTemplate().get(
				MasServiceStatus.class, serviceStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masServiceStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masServiceStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masServiceStatus.setLastChgBy(changedBy);
		masServiceStatus.setLastChgDate(currentDate);
		masServiceStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceStatus);
		return dataDeleted;
	}

	public boolean editServiceStatusToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String serviceStatusName = "";
		@SuppressWarnings("unused")
		String serviceStatusCode = "";
		int serviceStatusId = 0;
		String changedBy = "";
		serviceStatusId = (Integer) generalMap.get("id");
		serviceStatusCode = (String) generalMap.get("serviceStatusCode");
		serviceStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasServiceStatus masServiceStatus = (MasServiceStatus) getHibernateTemplate()
				.get(MasServiceStatus.class, serviceStatusId);

		masServiceStatus.setId(serviceStatusId);
		masServiceStatus.setServiceStatusName(serviceStatusName);
		masServiceStatus.setLastChgBy(changedBy);
		masServiceStatus.setLastChgDate(currentDate);
		masServiceStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchServiceStatus(String serviceStatusCode,
			String serviceStatusName) {
		List<MasServiceStatus> searchServiceStatusList = new ArrayList<MasServiceStatus>();
		Map<String, Object> serviceStatusFieldsMap = new HashMap<String, Object>();
		try {
			if ((serviceStatusName != null) || (serviceStatusCode == null)) {
				searchServiceStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasServiceStatus imc where imc.ServiceStatusName like '"
								+ serviceStatusName
								+ "%' order by imc.ServiceStatusName");
			} else {
				searchServiceStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasServiceStatus imc where imc.ServiceStatusCode like '"
								+ serviceStatusCode
								+ "%' order by imc.ServiceStatusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceStatusFieldsMap.put("searchServiceStatusList",
				searchServiceStatusList);
		return serviceStatusFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showServiceStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceStatus> searchServiceStatusList = new ArrayList<MasServiceStatus>();
		searchServiceStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceStatus ");
		map.put("searchServiceStatusList", searchServiceStatusList);
		return map;

	}

	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSetupParameterMap(Map<String, Object> dataMap) {
		int hospitalId = 0;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();

		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		System.out.println("hospit"+hospitalId);
		try{
			masSetupParameterMaintainceList = session
			.createCriteria(MasSetupParameterMaintaince.class)
			/*.add(Restrictions.eq("Hospital.Id", hospitalId))*/.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//finally{
			/**
			 * session.close() is done By Mukesh Narayan Singh
			 * Date 07 Oct 2010
			 */
			//if(session!=null){
			//	session.close();
			//}
		//}

		map.put("masSetupParameterMaintainceList",
				masSetupParameterMaintainceList);
		return map;
	}

	// ---------------------------------Patient
	// Type----------------------------------

	public boolean addPatientType(MasPatientType masPatientType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Transaction tnx=null;
		Session session=(Session)getSession();
		try{
			tnx=session.beginTransaction();
			hbt.save(masPatientType);
			successfullyAdded = true;
			tnx.commit();
			session.flush();
		}
		catch(Exception e){
			e.printStackTrace();
			tnx.rollback();
			
	
		}
		
		return successfullyAdded;
	}

	public boolean editPatientTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String patientTypeName = "";
		@SuppressWarnings("unused")
		String patientTypeCode = "";
		int patientTypeId = 0;
		int changedBy = 0;
		String dischargeFlag = "";
		int validityDays =0;
		String categoryTypeName="";
		patientTypeId = (Integer) generalMap.get("id");
		patientTypeCode = (String) generalMap.get("patientTypeCode");
		patientTypeName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		dischargeFlag = (String) generalMap.get("dischargeFlag");
		validityDays =(Integer)generalMap.get("validityDays");
		categoryTypeName = (String)generalMap.get("categoryTypeName");
		MasPatientType masPatientType = (MasPatientType) getHibernateTemplate()
				.get(MasPatientType.class, patientTypeId);

		masPatientType.setId(patientTypeId);
		masPatientType.setPatientTypeName(patientTypeName);
		masPatientType.setDischargeWithoutSettlement(dischargeFlag);
		Users user = new Users();
		user.setId(changedBy);
		masPatientType.setLastChgBy(user);
		
		masPatientType.setLastChgDate(currentDate);
		masPatientType.setLastChgTime(currentTime);
		masPatientType.setValidity(validityDays);
		masPatientType.setType(categoryTypeName);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPatientType);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientType(String patientTypeCode,
			String patientTypeName) {
		List<MasPatientType> searchPatientTypeList = new ArrayList<MasPatientType>();
		Map<String, Object> patientTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((patientTypeName != null) || (patientTypeCode == null)) {
				searchPatientTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasPatientType imc where imc.PatientTypeName like '"
								+ patientTypeName
								+ "%' order by imc.PatientTypeName");
			} else {
				searchPatientTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasPatientType imc where imc.PatientTypeCode like '"
								+ patientTypeCode
								+ "%' order by imc.PatientTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientTypeFieldsMap
				.put("searchPatientTypeList", searchPatientTypeList);
		return patientTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPatientType> searchPatientTypeList = new ArrayList<MasPatientType>();
		searchPatientTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPatientType ");
		map.put("searchPatientTypeList", searchPatientTypeList);
		return map;
	}

	public boolean deletePatientType(int patientTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPatientType masPatientType = new MasPatientType();
		masPatientType = (MasPatientType) getHibernateTemplate().get(
				MasPatientType.class, patientTypeId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPatientType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPatientType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(changedBy);
		masPatientType.setLastChgBy(user);
		
		masPatientType.setLastChgDate(currentDate);
		masPatientType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPatientType);
		return dataDeleted;
	}

	// --------------------------------IcdCausegrp----------------------------
	public Map<String, Object> showIcdCauseJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcdcausegrp> searchCauseList = new ArrayList<MasIcdcausegrp>();
		searchCauseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdcausegrp ");
		map.put("searchCauseList", searchCauseList);
		return map;
	}

	public Map<String, Object> searchIcdCause(String causeCode, String causeName) {
		List<MasIcdcausegrp> searchCauseList = new ArrayList<MasIcdcausegrp>();
		Map causeFieldsMap = new HashMap();
		try {
			if ((causeName != null) || (causeCode == null)) {
				searchCauseList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasIcdcausegrp sc where sc.IcdCauseName like '"
								+ causeName + "%' order by sc.IcdCauseName");
			} else {
				searchCauseList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasIcdcausegrp sc where sc.IcdCauseCode like '"
								+ causeCode + "%' order by sc.IcdCauseCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		causeFieldsMap.put("searchCauseList", searchCauseList);
		return causeFieldsMap;
	}

	public boolean editIcdCauseToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String causeName = "";
		@SuppressWarnings("unused")
		String causeCode = "";
		int causeId = 0;
		int changedBy = 0;
		causeId = (Integer) generalMap.get("id");
		causeCode = (String) generalMap.get("deathCauseCode");
		causeName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasIcdcausegrp masIcdcausegrp = (MasIcdcausegrp) getHibernateTemplate()
				.get(MasIcdcausegrp.class, causeId);

		masIcdcausegrp.setId(causeId);
		masIcdcausegrp.setIcdCauseName(causeName);
		
		Users users=new Users();
		users.setId(changedBy);
		masIcdcausegrp.setLastChgBy(users);
		
		masIcdcausegrp.setLastChgDate(currentDate);
		masIcdcausegrp.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdcausegrp);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addIcdCause(MasIcdcausegrp masDeathCause) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDeathCause);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteIcdCause(int causeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasIcdcausegrp masIcdcausegrp = new MasIcdcausegrp();
		masIcdcausegrp = (MasIcdcausegrp) getHibernateTemplate().get(
				MasIcdcausegrp.class, causeId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masIcdcausegrp.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masIcdcausegrp.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masIcdcausegrp.setLastChgBy(users);
		masIcdcausegrp.setLastChgDate(currentDate);
		masIcdcausegrp.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdcausegrp);
		return dataDeleted;
	}

	public boolean deleteChargeCode1(int chargeCodeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		MasChargeCode masChargeCode = new MasChargeCode();
		Session session=(Session)getSession();
		masChargeCode = (MasChargeCode) getHibernateTemplate().get(MasChargeCode.class, chargeCodeId);
		//lokesh singh
		/*MasHospitalwiseChargecode masHospitalwiseChargecode=new MasHospitalwiseChargecode();
		List<MasHospitalwiseChargecode> chargecode=new ArrayList<MasHospitalwiseChargecode>();
		chargecode=session.createCriteria(MasHospitalwiseChargecode.class, "mhwc").createAlias("mhwc.ChargeCode", "chc").add(Restrictions.eq("chc.Id",chargeCodeId )).list();
			for(MasHospitalwiseChargecode chargecode2:chargecode){
		masHospitalwiseChargecode=(MasHospitalwiseChargecode) getHibernateTemplate().get(MasHospitalwiseChargecode.class,chargecode.get(0).getId());}*/
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		if (generalMap.get("flag") != null)
		{
			String flag = (String) generalMap.get("flag");
			/*List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List subChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List chargeTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasChargeType as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List sampleList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSample as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List unitOfMeasurementList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasUnitOfMeasurement as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
*/
			
			if (flag.equals("InActivate")) {
				masChargeCode.setStatus("n");
				//masHospitalwiseChargecode.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masChargeCode.setStatus("y");
				//masHospitalwiseChargecode.setStatus("y");
				dataDeleted = false;
			}
		}
		//masChargeCode.setLastChgBy(changedBy);
		masChargeCode.setLastChgDate(currentDate);
		masChargeCode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masChargeCode);
		hbt.flush();
		hbt.clear();
		return dataDeleted;
	}

	// ---------------------------Notice
	// Board--------------------------------------

	public boolean addNotice(HmsNoticeBoard hmsNoticeBoard) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hmsNoticeBoard);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editNoticeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String noticeName = "";
		@SuppressWarnings("unused")
		String noticeCode = "";
		int noticeId = 0;
		String changedBy = "";
		noticeId = (Integer) generalMap.get("id");
		noticeCode = (String) generalMap.get("noticeCode");
		noticeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HmsNoticeBoard hmsNoticeBoard = (HmsNoticeBoard) getHibernateTemplate()
				.get(HmsNoticeBoard.class, noticeId);

		hmsNoticeBoard.setId(noticeId);
		hmsNoticeBoard.setDesc(noticeName);
		hmsNoticeBoard.setLastChangedBy(changedBy);
		hmsNoticeBoard.setLastChangedDate(currentDate);
		hmsNoticeBoard.setLastChangedTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hmsNoticeBoard);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchNotice(String noticeCode, String noticeName) {
		List<HmsNoticeBoard> searchNoticeList = new ArrayList<HmsNoticeBoard>();
		Map<String, Object> noticeFieldsMap = new HashMap<String, Object>();
		try {
			if ((noticeName != null) || (noticeCode == null)) {
				searchNoticeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HmsNoticeBoard imc where imc.Desc like '"
								+ noticeName + "%' order by imc.Desc");
			} else {
				searchNoticeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HmsNoticeBoard imc where imc.NoticeCode like '"
								+ noticeCode + "%' order by imc.NoticeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		noticeFieldsMap.put("searchNoticeList", searchNoticeList);
		return noticeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showNoticeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HmsNoticeBoard> searchNoticeList = new ArrayList<HmsNoticeBoard>();
		searchNoticeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HmsNoticeBoard ");
		map.put("searchNoticeList", searchNoticeList);
		return map;
	}

	public boolean deleteNotice(int noticeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HmsNoticeBoard hmsNoticeBoard = new HmsNoticeBoard();
		hmsNoticeBoard = (HmsNoticeBoard) getHibernateTemplate().get(
				HmsNoticeBoard.class, noticeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hmsNoticeBoard.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hmsNoticeBoard.setStatus("y");
				dataDeleted = false;
			}
		}
		hmsNoticeBoard.setLastChangedBy(changedBy);
		hmsNoticeBoard.setLastChangedDate(currentDate);
		hmsNoticeBoard.setLastChangedTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hmsNoticeBoard);
		return dataDeleted;
	}

	/**
	 * Added By Ritu For Exisiting Charge code in given date range
	 */
	public Map<String, Object> checkForExistingChargeCode(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasChargeCode> chargeNameList = new ArrayList<MasChargeCode>();
		String code = (String) generalMap.get("code");
		String name = (String) generalMap.get("name");
		// Date effactiveFromDate = (Date)generalMap.get("effactiveFromDate");
		// Date effactiveToDate = (Date)generalMap.get("effactiveToDate");
		Session session = (Session) getSession();

		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("ChargeCodeCode", code)).list();

		chargeNameList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("ChargeCodeName", name)).list();

		if (chargeCodeList.size() > 0) {
			map.put("chargeCodeList", chargeCodeList);
		}
		if (chargeNameList.size() > 0) {
			map.put("chargeNameList", chargeNameList);
		}
		return map;
	}

	public Map checkForExistingMastersForHospital(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();
		int id = 0;
		int hospitalid=0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String pojoPropertyName = "";
		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}
		hospitalid=(Integer)generalMap.get("hospitalid");
		String name = (String) generalMap.get("name");
		String pojoName = (String) generalMap.get("pojoName");
		if (generalMap.get("pojoPropertyName") != null) {
			pojoPropertyName = (String) generalMap.get("pojoPropertyName");
		}

		if (generalMap.get("pojoPropertyCode") != null) {
			pojoPropertyCode = (String) generalMap.get("pojoPropertyCode");
		}
		if (generalMap.get("pojoPropertyAddress") != null) {
			pojoPropertyAddress = (String) generalMap
					.get("pojoPropertyAddress");
		}
System.out.println("pojoPropertyCode  "+pojoPropertyCode);
System.out.println("pojoPropertyName  "+pojoPropertyName);
System.out.println("pojoName  "+pojoName);
		if (generalMap.get("flag") == null) {

			int code = Integer.parseInt(generalMap.get("code").toString());
			String address = (String) generalMap.get("address");
			if (!pojoPropertyCode.equals("")) {
				duplicateGeneralCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyCode + " ='"
								+ code + "' and " + pojoPropertyName + " ='"
								+ name + "' and g.Hospital"+"='"+hospitalid+"'");
			}

		} else if (generalMap.get("flag") != null) {
			duplicateMastersList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.Id != '" + id+"' and g.Hospital"+"='"+hospitalid+"' ");
		}
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean checkprinterDetails(Map<String, Object> generalMap)
	{
		List printerList = null;
		boolean printernameList = true;
		String systemIP="";
		String  printerName="";
		String type="";
		systemIP=(String)generalMap.get("systemIp");
		type=(String)generalMap.get("type");
		printerName=(String)generalMap.get("printerName");
		try
		{
			printerList = getHibernateTemplate()
			.find("from jkt.hms.masters.business.PrinterCofiguration as ccm where ccm.SystemIp = '"
			+ systemIP+ "' and ccm.Type = '"+ type + "' and ccm.PrinterName = '"+printerName+"' ");
			
			if (printerList.size() > 0)
			{
				printernameList = false;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return printernameList;
	}

	public boolean deleteMajorCategoryCode(Map<String, Object> generalMap) {
		return false;
	}

	@Override
	public Map<String, Object> checkChargeTypeName(int chargeTypeId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeType> searchChargeTypeList = new ArrayList<MasChargeType>();
		searchChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType as mct where mct.Id = "+chargeTypeId);
		map.put("searchChargeTypeList", searchChargeTypeList);
		return map;
	}

	@Override
	public Map<String, Object> checkMasChargeCodeName(int chargeCodeId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> searchChargeTypeList = new ArrayList<MasChargeCode>();
		searchChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeCode as mcc where mcc.Id = "+chargeCodeId);
		map.put("searchChargeTypeList", searchChargeTypeList);
		return map;
	}

	@Override
	public int getChargeTypeId(String chargeTypeName)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int chargeTypeId = 0;
		List<MasChargeType> searchChargeTypeList = new ArrayList<MasChargeType>();
		searchChargeTypeList = getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasChargeType as mct where mct.ChargeTypeName = '"+chargeTypeName+"' ");
		chargeTypeId = searchChargeTypeList.get(0).getId();
		return chargeTypeId;
	}

	@Override
	public Boolean checkStatusMasCharge(int chargeTypeId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> searchChargeTypeList = new ArrayList<MasChargeCode>();
		Boolean status = false;
		
		searchChargeTypeList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasChargeCode as mcc where mcc.ChargeType.Id = '"+chargeTypeId+"' and lower(mcc.Status) = 'y' ");
		
		if(searchChargeTypeList.size() > 0)
		{
			status = true;
		}
		else
		{
			status = false;
		}
		return status;
	}

	@Override
	public Map<String, Object> checkMasChargeCodeType(Integer chargeTypeNameId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> searchChargeTypeList = new ArrayList<MasChargeCode>();
		searchChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeCode as mcc where mcc.ChargeType.Id = "+chargeTypeNameId);
		map.put("checkMasChargeCodeType", searchChargeTypeList);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalList(Map<String, Object> dataMap) {
		int hospitalId = 0;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();

		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		try{
			masHospitalList = session
			.createCriteria(MasHospital.class)
			.add(Restrictions.eq("Id", hospitalId)).list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masHospitalList",masHospitalList);
		return map;
	}
	
	
	// -------------------------------------- Hospital Type Master
	// --------------------------------

	public boolean addHospitalType(MasHospitalType masHospitalType) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masHospitalType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteHospitalType(int hospitalTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasHospitalType masHospitalType = new MasHospitalType();
		masHospitalType = (MasHospitalType) getHibernateTemplate().get(
				MasHospitalType.class, hospitalTypeId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masHospitalType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masHospitalType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masHospitalType.setLastChgBy(users);
		
		masHospitalType.setLastChgDate(currentDate);
		masHospitalType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masHospitalType);
		return dataDeleted;
	}

	@SuppressWarnings("unused")
	public boolean editHospitalTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String hospitalTypeName = "";
		@SuppressWarnings("unused")
		String hospitalTypeCode = "";
		String description = "";
		int hospitalTypeId = 0;
		String changedBy = "";
		try {
			hospitalTypeId = (Integer) generalMap.get("id");
			hospitalTypeCode = (String) generalMap.get("hospitalTypeCode");
			hospitalTypeName = (String) generalMap.get("name");
			description = (String) generalMap.get("description");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasHospitalType masHospitalType = (MasHospitalType) getHibernateTemplate().get(
				MasHospitalType.class, hospitalTypeId);

		masHospitalType.setId(hospitalTypeId);
		masHospitalType.setHospitalTypeName(hospitalTypeName);
		masHospitalType.setDescription(description);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masHospitalType);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> searchHospitalType(String hospitalTypeCode,
			String hospitalTypeName) {
		List<MasHospital> searchHospitalTypeList = new ArrayList<MasHospital>();
		Session session =(Session)getSession();
		Map<String, Object> userGroupsFieldsMap = new HashMap<String, Object>();
		try {
			if ((hospitalTypeName != null) || (hospitalTypeCode == null)) {

				/*searchHospitalTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospitalType imc where imc.HospitalTypeName like '"
								+ hospitalTypeName + "%' order by imc.HospitalTypeName");
				*/
				searchHospitalTypeList =session.createCriteria(MasHospitalType.class).add(Restrictions.like("HospitalTypeName", hospitalTypeName+"%").ignoreCase()).addOrder(Order.asc("HospitalTypeName")).list();

			} else {
			/*	searchHospitalTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospitalType imc where imc.HospitalTypeCode like '"
								+ hospitalTypeCode + "%' order by imc.HospitalTypeCode");
			*/	searchHospitalTypeList =session.createCriteria(MasHospitalType.class).add(Restrictions.like("HospitalTypeCode", hospitalTypeCode+"%").ignoreCase()).addOrder(Order.asc("HospitalTypeCode")).list();
				
			


			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userGroupsFieldsMap.put("searchHospitalTypeList", searchHospitalTypeList);
		return userGroupsFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showHospitalTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospitalType> searchHospitalTypeList = new ArrayList<MasHospitalType>();
		searchHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType ");
		map.put("searchHospitalTypeList", searchHospitalTypeList);
		return map;
	}

	@Override
	public Map<String, Object> showBillInstituteWiseServicesJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalid=box.getInt(RequestConstants.HOSPITAL_ID);
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		List<Object[]> rows = null;
	
		rows = session.createCriteria(MasHospital.class).setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("HospitalName")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("HospitalName"))
				.list();
	
		for(Object[] object : rows){
			MasHospital masHospital = new MasHospital();
			masHospital.setId((Integer)object[0]);
			masHospital.setHospitalName((String)object[1]);
			hospitalNameList.add(masHospital);
		}
	
	
		List<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
		rows = session.createCriteria(MasMainChargecode.class).setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("MainChargecodeName")))   
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("MainChargecodeName")).list();
	
		for(Object[] object : rows){
			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId((Integer)object[0]);
			masMainChargecode.setMainChargecodeName((String)object[1]);
			mainChargeList.add(masMainChargecode);
		}
	
		List<MasSubChargecode> subChargeList = new ArrayList<MasSubChargecode>();
		rows = session.createCriteria(MasSubChargecode.class).setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("SubChargecodeName"))
				.add(Projections.property("MainChargecode")))
				.add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("SubChargecodeName")).list();

		for(Object[] object : rows){
			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId((Integer)object[0]);
			masSubChargecode.setSubChargecodeName((String)object[1]);
			masSubChargecode.setMainChargecode((MasMainChargecode)object[2]);
			subChargeList.add(masSubChargecode);
		}

	
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		rows = session.createCriteria(MasChargeCode.class).setProjection(Projections.projectionList()
				.add(Projections.property("Id"))
				.add(Projections.property("ChargeCodeName"))
				.add(Projections.property("MainChargecode"))
				.add(Projections.property("SubChargecode")))
				.add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("ChargeCodeName")).list();		
	
		for(Object[] object : rows){
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode.setId((Integer)object[0]);
			masChargeCode.setChargeCodeName((String)object[1]);
			masChargeCode.setMainChargecode((MasMainChargecode)object[2]);
			masChargeCode.setSubChargecode((MasSubChargecode)object[3]);
			chargeList.add(masChargeCode);
		}
	
	
		List<MasHospitalwiseChargecode> masHospitalwiseChargecodeList = new ArrayList<MasHospitalwiseChargecode>();
		masHospitalwiseChargecodeList=session.createCriteria(MasHospitalwiseChargecode.class)
				.createAlias("ChargeCode", "chargeCode")
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalid))
				/*.add(Restrictions.eq("Status","y").ignoreCase())*/.addOrder(Order.asc("chargeCode.ChargeCodeName")).list();
	
		//Added by Arbind on 27-06-2017
		List<MasHospital> instituteList = new ArrayList<MasHospital>();
		instituteList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Id",hospitalid))
				.add(Restrictions.eq("Status","y").ignoreCase()).list();
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		mdistrictList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("State", "State").add(Restrictions.eq("State.Id", 32)).list();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
	
		System.out.println("========================="+hospitalid);
	
		map.put("hospitalNameList", hospitalNameList);
		map.put("mainChargeList", mainChargeList);
		map.put("subChargeList", subChargeList);
		map.put("chargeList", chargeList);
		map.put("masHospitalwiseChargecodeList", masHospitalwiseChargecodeList);
		map.put("instituteList", instituteList);
		map.put("mdistrictList", mdistrictList);
		map.put("mhospitalTypetList", mhospitalTypetList);


		return map;
	}

	@Override
	public Map<String, Object> submitBillInstituteWiseServicesJsp(Box box) {
		//org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		//hbt.setFlushModeName("FLUSH_EAGER");
		//hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = HMSUtil.getCurrentDateAndTime();
		int hospitalId = box.getInt(RequestConstants.HOSPITAL_ID);
		int userId = box.getInt(RequestConstants.USER_ID);
		Transaction transaction = null;
		int hospitalid=box.getInt("hospital");
		//System.out.println("hospitalid"+hospitalid);
		MasHospital hospital = new MasHospital();
		hospital.setId(box.getInt("hospital"));
		Users users = new Users();
		users.setId(userId);
		Date currentDate = HMSUtil.convertStringTypeDateToDateType((String) utilMap.get("currentDate"));
		String currentTime = (String) utilMap.get("currentTime");
		try {
			//System.out.println(box.getString("removeData")+"======array"+box.getArrayList("tempId"));
			List<Integer> dataId=new ArrayList<Integer>();
			for(int i=1;i<box.getString("removeData").split("@").length;i++)
				dataId.add(Integer.parseInt(box.getString("removeData").split("@")[i]));
			transaction=session.beginTransaction();
			//System.out.println("size"+dataId.size());
			if(dataId.size()>0){
				String hql = "delete from jkt.hms.masters.business.MasHospitalwiseChargecode where Hospital.Id=:hospitalid and ChargeCode.Id IN(:idData) ";
				Query query = session.createQuery(hql);
				query.setParameter("hospitalid", hospitalid);
				query.setParameterList("idData", dataId);
				query.executeUpdate();
			}
			List<String> chargeids = box.getArrayList("tempId");
	
			//System.out.println("list"+chargeids.size());
			for (String chargeId : chargeids) {
				//System.out.println("chargeId---"+chargeId);
				MasHospitalwiseChargecode hospitalwiseChargecode=null;
				Criteria criteria=session.createCriteria(MasHospitalwiseChargecode.class,"mwc")
						.createAlias("mwc.Hospital", "hosp")
						.createAlias("mwc.ChargeCode", "cc")
						.add(Restrictions.eq("hosp.Id", hospitalid)).add(Restrictions.eq("cc.Id", Integer.parseInt(chargeId)));
				// hospitalwiseChargecode =(MasHospitalwiseChargecode) criteria.uniqueResult();
				List<MasHospitalwiseChargecode> hospitalWiseChargeList = new ArrayList<MasHospitalwiseChargecode>();
				hospitalWiseChargeList =  criteria.list();
				if(hospitalWiseChargeList.size()>0){
					hospitalwiseChargecode = hospitalWiseChargeList.get(0);
				}
				if(hospitalwiseChargecode!=null){
					MasChargeCode chargeCode = new MasChargeCode();
					chargeCode.setId(Integer.parseInt(chargeId));
					hospitalwiseChargecode.setChargeCode(chargeCode);
					hospitalwiseChargecode.setHospital(hospital);
					hospitalwiseChargecode.setLastChgBy(users);
					hospitalwiseChargecode.setLastChgDate(currentDate);
					hospitalwiseChargecode.setLastChgTime(currentTime);
					hospitalwiseChargecode.setStatus("y");
					session.update(hospitalwiseChargecode);
					map.put("message","Charge code updated successfully!");
				}else{
					hospitalwiseChargecode = new MasHospitalwiseChargecode();  
				 	MasChargeCode chargeCode = new MasChargeCode();
					chargeCode.setId(Integer.parseInt(chargeId));
					hospitalwiseChargecode.setChargeCode(chargeCode);
					hospitalwiseChargecode.setHospital(hospital);
					hospitalwiseChargecode.setLastChgBy(users);
					hospitalwiseChargecode.setLastChgDate(currentDate);
					hospitalwiseChargecode.setLastChgTime(currentTime);
					hospitalwiseChargecode.setStatus("y");
					session.save(hospitalwiseChargecode);
					map.put("message","Charge code saved successfully!");
				}
			}
		
			//hbt.flush();
			//hbt.clear();
			session.flush();
			transaction.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return map;
	}
	
	// ----------------------------------RoomType------------------------------------

			public boolean addRoomType(MasRoomType masRoomType) {
				boolean saveFlag = false;
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(masRoomType);
					saveFlag = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return saveFlag;
			}

			@SuppressWarnings("unchecked")
			public boolean deleteRoomType(int roomTypeId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasRoomType masRoomType = new MasRoomType();
				masRoomType = (MasRoomType) getHibernateTemplate().load(MasRoomType.class,
						roomTypeId);
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");

				if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masRoomType.setStatus("N");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masRoomType.setStatus("Y");
						dataDeleted = false;
					}
				}
				
				Users users=new Users();
				users.setId(userId);
				masRoomType.setLastChgBy(users);
				

				masRoomType.setLastChgDate(currentDate);
				masRoomType.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masRoomType);
				return dataDeleted;
			}

			public boolean editRoomType(Map<String, Object> generalMap) {

				boolean dataUpdated = false;

				
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				int roomTypeId = 0;
				String roomTypeName = "";
				String roomTypeCode = "";

				try {
					roomTypeId = (Integer) generalMap.get("id");
					roomTypeCode = (String) generalMap.get("roomTypeCode");
					roomTypeName = (String) generalMap.get("name");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					int userId=0; 
					userId = (Integer) generalMap.get("userId");
					MasRoomType masRoomType = (MasRoomType) getHibernateTemplate().load(
							MasRoomType.class, roomTypeId);

					masRoomType.setId(roomTypeId);
					masRoomType.setRoomTypeName(roomTypeName);

					
					masRoomType.setStatus("Y");
					Users users=new Users();
					users.setId(userId);
					masRoomType.setLastChgBy(users);
					
								
					masRoomType.setLastChgDate(currentDate);
					masRoomType.setLastChgTime(currentTime);

					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masRoomType);
					dataUpdated = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return dataUpdated;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> searchRoomType(String roomTypeCode,
					String roomTypeName) {
				Session session = (Session) getSession();
				List masRoomTypeList = new ArrayList();
				Map<String, Object> map = new HashMap<String, Object>();
				try {
					if ((roomTypeName != null) || (roomTypeCode == null)) {
						
						
						masRoomTypeList =session.createCriteria(MasRoomType.class).add(Restrictions.like("RoomTypeName","%"+roomTypeName+"%").ignoreCase()).addOrder(Order.asc("RoomTypeName")).list();
					} else if (roomTypeCode != null) {
						
						masRoomTypeList =session.createCriteria(MasRoomType.class).add(Restrictions.like("RoomTypeCode","%"+roomTypeCode+"%").ignoreCase()).addOrder(Order.asc("RoomTypeCode")).list();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("masRoomTypeList", masRoomTypeList);
				return map;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> showRoomType() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasRoomType> masRoomTypeList = new ArrayList<MasRoomType>();
				masRoomTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRoomType as sc order by sc.RoomTypeName");
				
				map.put("masRoomTypeList", masRoomTypeList);
				
				return map;
			}

			@Override
			public Map<String, Object> showHospitalUnitJsp(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				Session session = (Session)getSession();
				int hospitalId=0;
				hospitalId = (Integer)box.getInt("hospitalId");
				
			//	List<MasEmployee> empList = session.createCriteria(MasEmployee.class).addOrder(Order.asc("EmployeeName")).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				List<Object[]> empList = session.createCriteria(MasEmployee.class).addOrder(Order.asc("EmployeeName"))
						.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("EmpCategory.Id", 4))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("EmployeeName"))).list();
				List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
				hrInstWiseEmpDeptStringList = session.createCriteria(HrInstEmpDept.class).createAlias("Institute", "i").add(Restrictions.eq("i.Id",hospitalId))
							.setProjection(Projections.projectionList().add(Projections.property("EmployeeDepartment")).add(Projections.property("Id"))).list();
				System.out.println(hrInstWiseEmpDeptStringList.size()+"----------hrInstWiseEmpDeptStringList-------");
				
				List<Integer> hidList = new ArrayList<Integer>();
	
				if(hrInstWiseEmpDeptStringList.size() > 0){
					
					Object[] obj = hrInstWiseEmpDeptStringList.get(0);
					int hrInsitEmpDepId = (Integer)obj[1];
					String hIds = (String)obj[0];
					String[] houseId = hIds.split(",");
					for (int i = 0; i < houseId.length; i++) {
						hidList.add(Integer.parseInt(houseId[i].trim()));
					}
					System.out.println(hidList);
					System.out.println(hrInsitEmpDepId+"hrInsitEmpDepId");
				List<MasEmployeeDepartment> employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.in("Id", hidList)).list();
				System.out.println(employeeDepartmentList.size()+"-----------------");
				map.put("employeeDepartmentList", employeeDepartmentList);
				}
				map.put("empList", empList);
				
				return map;
			}
			public Map<String, Object> getDesigationForAutoComplete(Map<String, Object> parameterMap) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> empList = new ArrayList<MasEmployee>();
				String empNameStr = "";
				if(parameterMap.get("empNameStr")!= null){
					empNameStr = (String)parameterMap.get("empNameStr");
				}
				
				Session session = (Session)getSession();
				
				Criteria crit = session.createCriteria(MasEmployee.class)
				.add(Restrictions.ilike("EmployeeName",empNameStr+"%"));

	
				empList = crit.list();
				map.put("empList", empList);
				return map;
			}

			@SuppressWarnings("unchecked")
			public Map<String, Object> getRankDesignation(Map<String, Object> parameterMap) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
				int val = 0;
				if (parameterMap.get("val") != null) {
					val = (Integer) parameterMap.get("val");
				}
				Session session = (Session)getSession();
				
				masEmployeeList = session.createCriteria(MasEmployee.class)
										.add(Restrictions.eq("Id",val)).list();

				

				map.put("masEmployeeList", masEmployeeList);
				return map;
			}

			
			
			@SuppressWarnings("unchecked")
			public Map<String, Object> submitHospitalUnit(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<HospitalDoctorUnitM> unitList=new ArrayList<HospitalDoctorUnitM>();
				
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Session session = (Session)getSession();
				Transaction tx = null;
				boolean saved = false;
				int huMId=(Integer)box.getInt("huMId");

				try {
					tx = session.beginTransaction();
					HospitalDoctorUnitM hpdm = new HospitalDoctorUnitM();
					
					if(huMId!=0){
						String[] unitDays = {};
						if(box.get("unitradio")!=null && box.get("unitradio")!=""){
							unitDays=box.get("unitradio").split(",");
						}
						
						hpdm = (HospitalDoctorUnitM) getHibernateTemplate().get(HospitalDoctorUnitM.class, huMId);
						if(unitDays != null && unitDays.length >  0){
							List<String> unitDayList = Arrays.asList(unitDays);
							if(unitDayList.contains(HospitalUnitDays.MONDAY.getLabelValue())){
								hpdm.setMonday("y");
							}else{
								hpdm.setMonday(null);
							}
							if(unitDayList.contains(HospitalUnitDays.TUESDAY.getLabelValue())){
								hpdm.setTuesday("y");
							}else{
								hpdm.setTuesday(null);
							}							
							
							if(unitDayList.contains(HospitalUnitDays.WEDNESDAY.getLabelValue())){
								hpdm.setWednesday("y");
							}else{
								hpdm.setWednesday(null);
							}
							
							if(unitDayList.contains(HospitalUnitDays.THURSDAY.getLabelValue())){
								hpdm.setThursday("y");
							}else{
								hpdm.setThursday(null);
							}
							
							if(unitDayList.contains(HospitalUnitDays.FRIDAY.getLabelValue())){
								hpdm.setFriday("y");
							}else{
								hpdm.setFriday(null);
							}
							if(unitDayList.contains(HospitalUnitDays.SATURDAY.getLabelValue())){
								hpdm.setSaturday("y");
							}else{
								hpdm.setSaturday(null);
							}
							if(unitDayList.contains(HospitalUnitDays.SUNDAY.getLabelValue())){
								hpdm.setSunday("y");
							}else{
								hpdm.setSunday(null);
							}
							
						}else{
							hpdm.setMonday(null);
							hpdm.setTuesday(null);
							hpdm.setWednesday(null);
							hpdm.setThursday(null);
							hpdm.setFriday(null);
							hpdm.setSaturday(null);
							hpdm.setSunday(null);
						   
						}
						
						MasHospital masHospital = new MasHospital();
						masHospital.setId(box.getInt("hospitalId"));
						hpdm.setHospital(masHospital);
						
						MasEmployeeDepartment empDept = new MasEmployeeDepartment();
						empDept.setId(box.getInt("empDeptId"));
						hpdm.setEmpDept(empDept);	
						
						hpdm.setUnitCode(box.getString("unitCode"));
						
						Users users = new Users();
						users.setId(box.getInt("changedBy"));
						hpdm.setLastChgBy(users);
						hpdm.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						hpdm.setLastChgTime(box.getString(CHANGED_TIME));
						hpdm.setStatus("y");
					
							hbt.update(hpdm);
						
						int counter = box.getInt("hiddenValueCharge");
				
						for (int i = 1; i <= counter; i++) {	
							int huDId=0;
							huDId=box.getInt("huDId"+i);
							System.out.println(huDId);
							if(huDId!=0)
							{	if (box.getInt("empNameId"+i)!= 0) {
								HospitalDoctorUnitT hpdt = (HospitalDoctorUnitT) hbt.load(HospitalDoctorUnitT.class, huDId);
								if(!box.getString("huDId"+i).equals("0") && box.getString("huDId"+i)!=null){
									
									if (box.getInt("empNameId"+i)!= 0) {
										MasEmployee e = new MasEmployee();
										e.setId(box.getInt("empNameId"+i) );
										hpdt.setEmployee(e);
									}
									if (box.getString("hiddenHeadValue"+i)!="") {
										hpdt.setHeadFleg(box.getString("hiddenHeadValue"+i));
									}
									hpdt.setUnitM(hpdm);
									hpdt.setStatus("y");
									
									
									hbt.update(hpdt);
								}
								}
							}else{
								if (box.getInt("empNameId"+i)!= 0) {
								HospitalDoctorUnitT hpdt = new HospitalDoctorUnitT();
								if (box.getInt("empNameId"+i)!= 0) {
									MasEmployee e = new MasEmployee();
									e.setId(box.getInt("empNameId"+i) );
									hpdt.setEmployee(e);
								}
								if (box.getString("hiddenHeadValue"+i)!="") {
									hpdt.setHeadFleg(box.getString("hiddenHeadValue"+i));
								}
								hpdt.setUnitM(hpdm);
								hpdt.setStatus("y");
								
								
								hbt.save(hpdt);
								}
								}
								
								}
						tx.commit();
						saved = true;
						
					}else{
						// changed by srikanth start
						String[] unitDays={};
						Multimap<String, String> unitMap = ArrayListMultimap.create();
						List<HospitalDoctorUnitM> dayUnitList = new ArrayList<HospitalDoctorUnitM>();
						if(box.get("unitradio")!=null && box.get("unitradio")!=""){
							unitDays=box.get("unitradio").split(",");
						}
						for(int i=0;i<unitDays.length;i++){
							
							Criteria crt=session.createCriteria(HospitalDoctorUnitM.class)
									 .createAlias("EmpDept", "EmpDept")
									 .createAlias("Hospital", "Hospital")
									 .add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
									 .add(Restrictions.eq(((String) unitDays[i].subSequence(0,1)).toUpperCase()+unitDays[i].substring(1),"y"))
									  .add(Restrictions.eq("EmpDept.Id", box.getInt("empDeptId")));
							 
							 unitList=crt.list();
							 for(HospitalDoctorUnitM codes:unitList){
								 unitMap.put(codes.getUnitCode(),unitDays[i]);
							 }
						}
						
						if(unitMap!=null && unitMap.size()!=0){
							
							if(unitMap.containsKey(box.getString("unitCode"))){
								Collection<String> s=unitMap.get(box.getString("unitCode"));
								String day=s.iterator().next();
								map.put("codeExisted",day);
								saved = false;
							}
							
							else{
								 MasHospital masHospital = new MasHospital();
									masHospital.setId(box.getInt("hospitalId"));
									hpdm.setHospital(masHospital);
									
									MasEmployeeDepartment empDept = new MasEmployeeDepartment();
									empDept.setId(box.getInt("empDeptId"));
									hpdm.setEmpDept(empDept);					
									
									hpdm.setUnitCode(box.getString("unitCode"));
									
									// changed by srikanth start
									if(box.get("unitradio")!="" && box.get("unitradio")!= null){
										//String[] unitDays=box.get("unitradio").split(",");
										for(String unitDay:unitDays){
											switch(unitDay){
											case "monday":
												hpdm.setMonday("y");
												break;
											case "tuesday":
												hpdm.setTuesday("y");
												break;
											case "wednesday":
												hpdm.setWednesday("y");
												break;
											case "thursday":
												hpdm.setThursday("y");
												break;
											case "friday":
												hpdm.setFriday("y");
												break;
											case "saturday":
												hpdm.setSaturday("y");
												break;
											case "sunday":
												hpdm.setSunday("y");
												break;
											
											}
										}
									}
									//changed by Srikanth end
									Users users = new Users();
									users.setId(box.getInt("changedBy"));
									hpdm.setLastChgBy(users);
									hpdm.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
									hpdm.setLastChgTime(box.getString(CHANGED_TIME));
									hpdm.setStatus("y");
								
									hbt.save(hpdm);
								
									int counter = box.getInt("hiddenValueCharge");
									
									for (int i = 1; i <= counter; i++) {	
										if (box.getInt("empNameId"+i)!= 0) {
											
											HospitalDoctorUnitT hpdt = new HospitalDoctorUnitT();
											if (box.getInt("empNameId"+i)!= 0) {
												MasEmployee e = new MasEmployee();
												e.setId(box.getInt("empNameId"+i) );
												hpdt.setEmployee(e);
											}
											if (box.getString("hiddenHeadValue"+i)!="") {
												hpdt.setHeadFleg(box.getString("hiddenHeadValue"+i));
											}
											hpdt.setUnitM(hpdm);
											hpdt.setStatus("y");
											
											
											hbt.save(hpdt);
											
											}
									}
									tx.commit();
									saved = true;
							 }
							 
						 }
						 else{
							 
							 MasHospital masHospital = new MasHospital();
								masHospital.setId(box.getInt("hospitalId"));
								hpdm.setHospital(masHospital);
								
								MasEmployeeDepartment empDept = new MasEmployeeDepartment();
								empDept.setId(box.getInt("empDeptId"));
								hpdm.setEmpDept(empDept);					
								
								hpdm.setUnitCode(box.getString("unitCode"));
								
								// changed by srikanth start
								if(box.get("unitradio")!="" && box.get("unitradio")!= null){
									//String[] unitDays=box.get("unitradio").split(",");
									for(String unitDay:unitDays){
										switch(unitDay){
										case "monday":
											hpdm.setMonday("y");
											break;
										case "tuesday":
											hpdm.setTuesday("y");
											break;
										case "wednesday":
											hpdm.setWednesday("y");
											break;
										case "thursday":
											hpdm.setThursday("y");
											break;
										case "friday":
											hpdm.setFriday("y");
											break;
										case "saturday":
											hpdm.setSaturday("y");
											break;
										case "sunday":
											hpdm.setSunday("y");
											break;
										
										}
									}
								}
								// changed by srikanth end
								
								Users users = new Users();
								users.setId(box.getInt("changedBy"));
								hpdm.setLastChgBy(users);
								hpdm.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
								hpdm.setLastChgTime(box.getString(CHANGED_TIME));
								hpdm.setStatus("y");
							
								hbt.save(hpdm);
							
								int counter = box.getInt("hiddenValueCharge");
								
								for (int i = 1; i <= counter; i++) {	
									if (box.getInt("empNameId"+i)!= 0) {
										
										HospitalDoctorUnitT hpdt = new HospitalDoctorUnitT();
										if (box.getInt("empNameId"+i)!= 0) {
											MasEmployee e = new MasEmployee();
											e.setId(box.getInt("empNameId"+i) );
											hpdt.setEmployee(e);
										}
										if (box.getString("hiddenHeadValue"+i)!="") {
											hpdt.setHeadFleg(box.getString("hiddenHeadValue"+i));
										}
										hpdt.setUnitM(hpdm);
										hpdt.setStatus("y");
										
										
										hbt.save(hpdt);
										
										}
								}
								tx.commit();
								saved = true;
						 }
				
					}
							
						} catch (RuntimeException e) {
							if (tx != null)
								tx.rollback();
							e.printStackTrace();
						}
				
				map.put("saved", saved);
				return map;
			}
			
			// -------------------------------- Ot			// Master-----------------------------------
			@SuppressWarnings("unchecked")
			public Map<String, Object> showOtJsp() {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<MasBedStatus> bedStatusList = new ArrayList<MasBedStatus>();
				
				List<MasDepartment> departmentListGrid = new ArrayList<MasDepartment>();
				List<MasRoom> roomListGrid = new ArrayList<MasRoom>();
				List<MasBedStatus> bedStatusListGrid = new ArrayList<MasBedStatus>();
				
				
				List<MasBed> searchBedList = new ArrayList<MasBed>();

				departmentList = getHibernateTemplate()
						.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where lower(md.Status) = 'y' and upper(dt.DepartmentTypeCode) ='OPR'");
				
				bedStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBedStatus as mbs where lower(mbs.Status) = 'y'");
				
				
				departmentListGrid = getHibernateTemplate()
						.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where  upper(dt.DepartmentTypeCode) ='OPR'");
				
				bedStatusListGrid = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBedStatus as mbs");
				searchBedList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBed where flag='OT'");
				map.put("departmentList", departmentList);
				map.put("bedStatusList", bedStatusList);
				
				map.put("departmentListGrid", departmentListGrid);
				map.put("roomListGrid", roomListGrid);
				map.put("bedStatusListGrid", bedStatusListGrid);
				
				map.put("searchBedList", searchBedList);
				return map;
			}

			public Map<String, Object> searchOt(String bedNumber) {
				List<MasBed> searchBedList = new ArrayList<MasBed>();
				Map<String, Object> bedFieldsMap = new HashMap<String, Object>();
				List departmentList = new ArrayList();
				List roomList = new ArrayList();
				List bedStatusList = new ArrayList();
				List<MasDepartment> departmentListGrid = new ArrayList<MasDepartment>();
				List<MasBedStatus> bedStatusListGrid = new ArrayList<MasBedStatus>();
				Session session = (Session)getSession();
				try {
					if ((bedNumber != null)) {
					/*	searchBedList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasBed as mb where  mb.flag ='OT' and lower(mb.BedNo) like '"
										+ bedNumber.toLowerCase() + "%'  order by mb.BedNo");
						*/
						
						searchBedList = session.createCriteria(MasBed.class).add(Restrictions.like("BedNo", bedNumber).ignoreCase())
								.add(Restrictions.eq("Flag", "OT"))
								.addOrder(Order.asc("BedNo")).list();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				departmentList = getHibernateTemplate()
						.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where lower(md.Status) = 'y' and upper(dt.DepartmentTypeCode) ='OPR'");
				
				bedStatusList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBedStatus as mbs where lower(mbs.Status) = 'y'");
				
				
				departmentListGrid = getHibernateTemplate()
						.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where  upper(dt.DepartmentTypeCode) ='OPR'");
			
				bedStatusListGrid = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBedStatus as mbs");
				bedFieldsMap.put("departmentListGrid", departmentListGrid);
				bedFieldsMap.put("bedStatusListGrid", bedStatusListGrid);
				bedFieldsMap.put("searchBedList", searchBedList);
				bedFieldsMap.put("departmentList", departmentList);
				bedFieldsMap.put("roomList", roomList);
				bedFieldsMap.put("bedStatusList", bedStatusList);
				return bedFieldsMap;
			}

			public boolean addOt(MasBed masBed) {
				boolean successfullyAdded = false;
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masBed);
				hbt.flush();
				hbt.clear();
				
				successfullyAdded = true;
				return successfullyAdded;
			}

			public boolean deleteOt(int bedId, Map<String, Object> generalMap) {
				boolean dataDeleted = false;
				String changedBy = "";
				Date currentDate = new Date();
				String currentTime = "";
				currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");
				MasBed masBed = new MasBed();
				masBed = (MasBed) getHibernateTemplate().get(MasBed.class, bedId);
				@SuppressWarnings("unused")
				Integer departmentId = masBed.getDepartment().getId();
				Integer bedStatusId = masBed.getBedStatus().getId();
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=(Integer)generalMap.get(RequestConstants.USER_ID);

				if (generalMap.get("flag") != null) {
					List departmentList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
									+ bedId + "' and lower(isc.Status)='y'");
					List bedStatusList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasBedStatus as isc where isc.Id='"
									+ bedId + "' and lower(isc.Status)='y'");
				
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						masBed.setStatus("n");
						dataDeleted = true;
					} else if (flag.equals("Activate")) {
						masBed.setStatus("y");
						dataDeleted = false;
					}
				}
				Users users=new Users();
				users.setId(userId);
				masBed.setLastChgBy(users);
				masBed.setLastChgDate(currentDate);
				masBed.setLastChgTime(currentTime);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masBed);
				return dataDeleted;
			}

			public boolean editOtToDatabase(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				String bedNumber = "";
				int bedId = 0;
				int bedStatusId = 0;
				int departmentId = 0;
				String adNo = "";
				String dietType = "";
				String attached = "";
				String currentTime = "";
				Date changedDate = new Date();
				bedId = (Integer) generalMap.get("id");
				bedNumber = (String) generalMap.get("bedNumber");
				departmentId = (Integer) generalMap.get("departmentId");
				bedStatusId = (Integer) generalMap.get("bedStatusId");
				adNo = (String) generalMap.get("adNo");
				dietType = (String) generalMap.get("dietType");
				attached = (String) generalMap.get("attached");
				changedDate = (Date) generalMap.get("changedDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=(Integer)generalMap.get(RequestConstants.USER_ID);

				MasBed masBed = (MasBed) getHibernateTemplate()
						.get(MasBed.class, bedId);

				masBed.setId(bedId);
				masBed.setBedNo(bedNumber);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masBed.setDepartment(masDepartment);

				MasBedStatus masBedStatus = new MasBedStatus();
				masBedStatus.setId(bedStatusId);
				masBed.setBedStatus(masBedStatus);

			

				masBed.setDietType(dietType);
				masBed.setAdNo(adNo);
				masBed.setAttached(attached);
				
				masBed.setFlag("OT");
				
				masBed.setStatus("y");
				Users users=new Users();
				users.setId(userId);
				masBed.setLastChgBy(users);
				masBed.setLastChgDate(changedDate);
				masBed.setLastChgTime(currentTime);
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masBed);
					dataUpdated = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return dataUpdated;
			}

			@Override
			public Map<String, Object> getEmpDepartmentSearch(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<HospitalDoctorUnitM> hospitalDoctorUnitMList = new ArrayList<HospitalDoctorUnitM>();
				int empDepSearchId = box.getInt("empDepSearchId");
				Session session = (Session)getSession();
				
				int hospitalId=0;
				hospitalId = (Integer)box.getInt("hospitalId");
				
				hospitalDoctorUnitMList = session.createCriteria(HospitalDoctorUnitM.class)
						.createAlias("EmpDept", "ed")
						.createAlias("Hospital", "hospital")
						.add(Restrictions.eq("hospital.Id", hospitalId))
						.add(Restrictions.eq("ed.Id",empDepSearchId)).list();

				
				List<MasEmployee> empList = session.createCriteria(MasEmployee.class).addOrder(Order.asc("EmployeeName"))
						.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("EmpCategory.Id", 4))
						.list();
				List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
				hrInstWiseEmpDeptStringList = session.createCriteria(HrInstEmpDept.class).createAlias("Institute", "i").add(Restrictions.eq("i.Id",hospitalId))
							.setProjection(Projections.projectionList().add(Projections.property("EmployeeDepartment")).add(Projections.property("Id"))).list();
				System.out.println(hrInstWiseEmpDeptStringList.size()+"----------hrInstWiseEmpDeptStringList-------");
				
				List<Integer> hidList = new ArrayList<Integer>();
	
				if(hrInstWiseEmpDeptStringList.size() > 0){
					
					Object[] obj = hrInstWiseEmpDeptStringList.get(0);
					int hrInsitEmpDepId = (Integer)obj[1];
					String hIds = (String)obj[0];
					String[] houseId = hIds.split(",");
					for (int i = 0; i < houseId.length; i++) {
						hidList.add(Integer.parseInt(houseId[i].trim()));
					}
					System.out.println(hidList);
					System.out.println(hrInsitEmpDepId+"hrInsitEmpDepId");
				List<MasEmployeeDepartment> employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.in("Id", hidList)).list();
				System.out.println(employeeDepartmentList.size()+"-----------------");
				map.put("employeeDepartmentList", employeeDepartmentList);
				}
				map.put("empList", empList);
				
				map.put("hospitalDoctorUnitMList", hospitalDoctorUnitMList);
				return map;
			}

			@Override
			public Map<String, Object> showDataFromSearch(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<HospitalDoctorUnitT> dataUnitTList = new ArrayList<HospitalDoctorUnitT>();
				int unitCodeId = box.getInt("unitCodeId");
				Session session = (Session)getSession();
				
				dataUnitTList = session.createCriteria(HospitalDoctorUnitT.class)
						.createAlias("UnitM", "h")
						.add(Restrictions.eq("h.Id",unitCodeId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
				boolean headDocFlag=false;
				if(dataUnitTList!=null && dataUnitTList.size()>0){
					for(HospitalDoctorUnitT doc:dataUnitTList){
						if(doc.getHeadFleg().equalsIgnoreCase("y")){
							headDocFlag=true;
						}
					}
				}
				
				int hospitalId=0;
				hospitalId = (Integer)box.getInt("hospitalId");
				
				List<MasEmployee> empList = session.createCriteria(MasEmployee.class).addOrder(Order.asc("EmployeeName"))
						.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("EmpCategory.Id", 4))
						.list();
				List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
				hrInstWiseEmpDeptStringList = session.createCriteria(HrInstEmpDept.class).createAlias("Institute", "i").add(Restrictions.eq("i.Id",hospitalId))
							.setProjection(Projections.projectionList().add(Projections.property("EmployeeDepartment")).add(Projections.property("Id"))).list();
				System.out.println(hrInstWiseEmpDeptStringList.size()+"----------hrInstWiseEmpDeptStringList-------");
				
				List<Integer> hidList = new ArrayList<Integer>();
	
				if(hrInstWiseEmpDeptStringList.size() > 0){
					
					Object[] obj = hrInstWiseEmpDeptStringList.get(0);
					int hrInsitEmpDepId = (Integer)obj[1];
					String hIds = (String)obj[0];
					String[] houseId = hIds.split(",");
					for (int i = 0; i < houseId.length; i++) {
						hidList.add(Integer.parseInt(houseId[i].trim()));
					}
					System.out.println(hidList);
					System.out.println(hrInsitEmpDepId+"hrInsitEmpDepId");
				List<MasEmployeeDepartment> employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.in("Id", hidList)).list();
				System.out.println(employeeDepartmentList.size()+"-----------------");
				map.put("employeeDepartmentList", employeeDepartmentList);
				}
				map.put("empList", empList);
				
				map.put("dataUnitTList", dataUnitTList);
				map.put("headDocFlag", headDocFlag);
				return map;
			}
            //local charge code master=====
			@Override
			public Map<String, Object> showLocalChargeCodeJsp(int hospitalId) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasChargeCode> searchChargeCodeList = new ArrayList<MasChargeCode>();
					List<MasChargeType> chargeTypeList = new ArrayList<MasChargeType>();
					List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
					List<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
					List<MasSubChargecode> subChargeList = new ArrayList<MasSubChargecode>();
					List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
					List<FaMasSubLed> subAccountList = new ArrayList<FaMasSubLed>();

					/*searchChargeCodeList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasChargeCode");  where Lower(Status)='y'"Lower(Status)='y'  and*/
					searchChargeCodeList = getHibernateTemplate().find(
							"select mhcc from jkt.hms.masters.business.MasHospitalwiseChargecode as mhcc join mhcc.ChargeCode as mcc where  mhcc.Hospital="+hospitalId+" order by mcc.ChargeCodeName");
					mainChargeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasMainChargecode as isc where upper(isc.Status) = upper('y')");
					subChargeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasSubChargecode as isc where upper(isc.Status) = upper('y')");
					chargeTypeList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasChargeType as isc where upper(isc.Status) = upper('y')");
					departmentList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasDepartment as isc where upper(isc.Status) = upper('y')");
					accountList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.FaMasAccount as isc where upper(isc.Status) = upper('y')");
					subAccountList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.FaMasSubLed as stm where upper(stm.Status) = upper('y')");

					map.put("searchChargeCodeList", searchChargeCodeList);
					map.put("chargeTypeList", chargeTypeList);
					map.put("departmentList", departmentList);
					map.put("subChargeList", subChargeList);
					map.put("accountList", accountList);
					map.put("mainChargeList", mainChargeList);
					map.put("subAccountList", subAccountList);

					return map;
				}
 //==============method for search local charge master================================
			@Override
			public Map<String, Object> searchLocalChargeCode(
					String chargeCodeCode, String chargeCodeName,
					Integer mas_main_charge_id, int hospitalId) {
				List<MasChargeCode> searchChargeCodeList = new ArrayList<MasChargeCode>();
				List chargeTypeList = null;
				List departmentList = null;
				List mainChargeList = null;
				List subChargecodeList = null;
				List sampleList = null;
				List unitOfMeasurementList = null;
				List subTestList = null;

				List gridChargeTypeList = null;
				List gridDepartmentList = null;
				List gridMainChargecodeList = null;
				List gridSubChargecodeList = null;
				List gridUnitOfMeasurementList = null;
				List gridSampleList = null;
				List gridSubTestList = null;
				List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
				List<FaMasSubLed> subAccountList = new ArrayList<FaMasSubLed>();
				System.out.println(chargeCodeName+"----"+chargeCodeName);
				Map<String, Object> map = new HashMap<String, Object>();
				try {
					if (mas_main_charge_id == 0) {
						if ((chargeCodeName != null) || (chargeCodeCode == null)) {
							
							searchChargeCodeList = getHibernateTemplate()
									.find("from jkt.hms.masters.business.MasHospitalwiseChargecode as i where i.Hospital.Id="+hospitalId+" and lower(i.ChargeCode.ChargeCodeName) like lower('"
											+ chargeCodeName
											+ "%') order by i.ChargeCode.ChargeCodeName");
						} else {
							searchChargeCodeList = getHibernateTemplate()
									.find("from jkt.hms.masters.business.MasHospitalwiseChargecode as i where i.Hospital.Id="+hospitalId+" and lower(i.ChargeCode.ChargeCodeCode) like lower('"
											+ chargeCodeCode
											+ "%') order by i.ChargeCode.ChargeCodeCode");
						}
					} else {

						/*searchChargeCodeList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasChargeCode as i where i.MainChargecode = "
										+ mas_main_charge_id
										+ " order by i.ChargeCodeName");*/
						
						searchChargeCodeList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasHospitalwiseChargecode as i where i.Hospital.Id="+hospitalId+" and i.ChargeCode.MainChargecode.Id = "
										+ mas_main_charge_id
										+ " order by i.ChargeCode.ChargeCodeName");

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				chargeTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasChargeType as isc where lower(isc.Status) = 'y'");
				departmentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y'");
				subChargecodeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSubChargecode as isc where lower(isc.Status) = 'y'");
				sampleList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSample as isc where lower(isc.Status) = 'y'");
				mainChargeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasMainChargecode as isc where lower(isc.Status) = 'y'");
				unitOfMeasurementList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasUnitOfMeasurement as uomm where lower(uomm.Status)='y'");
				subTestList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSubTest as stm where lower(stm.Status) = 'y'");

				accountList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.FaMasAccount as isc where lower(isc.Status) = 'y'");
				subAccountList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.FaMasSubLed as stm where lower(stm.Status) = 'y'");

				gridChargeTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasChargeType as stm where lower(stm.Status) = 'y'");
				gridDepartmentList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDepartment as stm where lower(stm.Status) = 'y'");
				gridSubChargecodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSubChargecode as stm where lower(stm.Status) = 'y'");
				gridSampleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSample as stm where lower(stm.Status) = 'y'");
				gridMainChargecodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasMainChargecode as stm where lower(stm.Status) = 'y'");
				gridUnitOfMeasurementList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasUnitOfMeasurement as stm where lower(stm.Status) = 'y'");
				gridSubTestList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSubTest as stm where lower(stm.Status) = 'y'");

				map.put("gridChargeTypeList", gridChargeTypeList);
				map.put("gridDepartmentList", gridDepartmentList);
				map.put("gridSubChargecodeList", gridSubChargecodeList);
				map.put("gridSubTestList", gridSubTestList);
				map.put("gridSampleList", gridSampleList);
				map.put("gridMainChargecodeList", gridMainChargecodeList);
				map.put("gridUnitOfMeasurementList", gridUnitOfMeasurementList);
				map.put("accountList", accountList);
				map.put("subAccountList", subAccountList);

				map.put("searchChargeCodeList", searchChargeCodeList);
				map.put("subTestList", subTestList);
				map.put("chargeTypeList", chargeTypeList);
				map.put("subChargeList", subChargecodeList);
				map.put("departmentList", departmentList);
				map.put("mainChargeList", mainChargeList);
				map.put("subChargecodeList", subChargecodeList);
				map.put("sampleList", sampleList);
				map.put("unitOfMeasurementList", unitOfMeasurementList);

				return map;

			}
//==========================end of search local charge master======================================================================
     //====================method for edit local charges============================
			@Override
			public boolean editLocalChargeCode(Map<String, Object> generalMap) {
				boolean dataUpdated = false;
				int mainChargeId = 0;
				int departmentId = 0;
				int subChargeId = 0;
				int chargeTypeId = 0;
				int accountId = 0;
				int subAccountId = 0;
				int chargeId = 0;
				float charge = 0;

				String chargeName = "";
				String chargeCode = "";
				String changedBy = "";
				String currentTime = "";
				String editable = "";
				String discountable = "";
				String drAccountRequired = "";
				String opd_related_services ="";
				String proceCode = "";
				String pacsInteg = "";
				String telemediInteg = "";
				Date currentDate = new Date();
				Date effactiveFromDate = new Date();
				Date effactiveToDate = new Date();

				BigDecimal discountPercentage = new BigDecimal(0);
				BigDecimal stdDeductionGen = new BigDecimal(0.00);
				BigDecimal stdDeductionSpl = new BigDecimal(0.00);
				
				Session session = (Session) getSession();
				Transaction tnx=null;
				
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				try
				{
					tnx=session.beginTransaction();
					chargeId = (Integer) generalMap.get("id");
					mainChargeId = (Integer) generalMap.get("mainChargeId");
					subChargeId = (Integer) generalMap.get("subchargeId");
					departmentId = (Integer) generalMap.get("departmentId");
					accountId = (Integer) generalMap.get("accountId");

					subAccountId = (Integer) generalMap.get("subAccountId");
					chargeTypeId = (Integer) generalMap.get("chargeTypeId");

					charge = (Float) generalMap.get("charge");
					chargeCode = (String) generalMap.get("chargeCode");
					chargeName = (String) generalMap.get("chargeName");
					editable = (String) generalMap.get("editable");
					discountable = (String) generalMap.get("discountable");
					drAccountRequired = (String) generalMap.get("drAccountRequired");
					opd_related_services = (String) generalMap.get("opd_related_services");

					discountPercentage = (BigDecimal) generalMap.get("discountPercentage");
					effactiveFromDate = (Date) generalMap.get("effactiveFromDate");
					effactiveToDate = (Date) generalMap.get("effactiveToDate");
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
					currentTime = (String) generalMap.get("currentTime");
					stdDeductionGen = (BigDecimal) generalMap.get("stdDeductionGen");
					stdDeductionSpl = (BigDecimal) generalMap.get("stdDeductionSpl");
					
					proceCode = (String) generalMap.get("proceCode");
					pacsInteg = (String) generalMap.get("pacsInteg");
					telemediInteg = (String) generalMap.get("telemediInteg");
					MasHospital hospital=new MasHospital();
					MasChargeCode masCharge = (MasChargeCode) getHibernateTemplate()
					.get(MasChargeCode.class, chargeId);

					/*masCharge.setId(chargeId);
					masCharge.setChargeCodeCode(chargeCode);
					masCharge.setChargeCodeName(chargeName);
					masCharge.setEditable(editable);
					masCharge.setDiscountable(discountable);
					masCharge.setDrAccountingRequired(drAccountRequired);
					masCharge.setDateEffectiveFrom(effactiveFromDate);
					// masCharge.setDateEffectiveTo(effactiveToDate);
					masCharge.setDiscountPercentage(discountPercentage);
					masCharge.setStdDeductionGen(stdDeductionGen);
					masCharge.setStdDeductionSpl(stdDeductionSpl);
					masCharge.setOpdRelatedServices(opd_related_services);
					masCharge.setProcedureCode(proceCode);
					masCharge.setChargePacsStatus(pacsInteg);
					masCharge.setTelemedicineStatus(telemediInteg);
					
					if (chargeTypeId != 0) {
						MasChargeType masChargeType = new MasChargeType();
						masChargeType.setId(chargeTypeId);
						masCharge.setChargeType(masChargeType);
					}
					if (mainChargeId != 0) {
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						masMainChargecode.setId(mainChargeId);
						masCharge.setMainChargecode(masMainChargecode);
					}
					if (subChargeId != 0) {
						MasSubChargecode masSub = new MasSubChargecode();
						masSub.setId(subChargeId);
						masCharge.setSubChargecode(masSub);
					}
					if (departmentId != 0) {
						MasDepartment masDep = new MasDepartment();
						masDep.setId(departmentId);
						masCharge.setDepartment(masDep);
					}
					if (accountId != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						faMasAccount.setId(accountId);
						masCharge.setAccount(faMasAccount);
					}
					if (subAccountId != 0) {
						FaMasSubLed masSubLed = new FaMasSubLed();
						masSubLed.setId(subAccountId);
						masCharge.setSubAccount(masSubLed);
					}
					// masCharge.setCharge(charge);
					Users users=new Users();
					users.setId((Integer)generalMap.get(RequestConstants.USER_ID));
					masCharge.setLastChgBy(users);
					masCharge.setLastChgDate(currentDate);
					masCharge.setLastChgTime(currentTime);
					*/
					hbt.update(masCharge);
					tnx.commit();
					session.flush();

					List<MasChargeCodeRates> chargeRateList = new ArrayList<MasChargeCodeRates>();
					chargeRateList = session.createCriteria(MasChargeCodeRates.class)
							.createAlias("ChargeCode", "cc")
							.add(Restrictions.eq("cc.Id", chargeId)).add(Restrictions.eq("Hospital.Id", (Integer)generalMap.get(RequestConstants.HOSPITAL_ID))).list();
					System.out.println("list"+chargeRateList.size());
					if (chargeRateList.size() > 0) {
						for (MasChargeCodeRates chargeRates : chargeRateList) {
							/*	if (chargeRates.getRate().compareTo(
										new BigDecimal(charge)) != 0) {*/
									/*
									MasChargeCodeRates chargeCodeRates = new MasChargeCodeRates();
									MasChargeCode masChargeCode = new MasChargeCode();
									masChargeCode.setId(chargeId);
									chargeCodeRates.setChargeCode(masChargeCode);
									chargeCodeRates.setEffectiveFromDate(effactiveFromDate);
									chargeCodeRates.setRate(new BigDecimal(charge));
									hospital.setId((Integer)generalMap.get(RequestConstants.HOSPITAL_ID));
									chargeCodeRates.setHospital(hospital);
									if (departmentId != 0) {
										MasDepartment masDep = new MasDepartment();
										masDep.setId(departmentId);
										chargeCodeRates.setDepartment(masDep);
									}
									hbt.save(chargeCodeRates);*/

									MasChargeCodeRates chargeRateObj = (MasChargeCodeRates) hbt
									.load(MasChargeCodeRates.class,	chargeRates.getId());
									int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
									SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
									String prevDate = dateFormat.format(effactiveFromDate.getTime()- MILLIS_IN_DAY);
									chargeRateObj.setEffectiveToDate(HMSUtil.convertStringTypeDateToDateType(prevDate));
									hospital.setId((Integer)generalMap.get(RequestConstants.HOSPITAL_ID));
									chargeRateObj.setHospital(hospital);
									chargeRateObj.setRate(new BigDecimal(charge));
									if (departmentId != 0) {
										MasDepartment masDep = new MasDepartment();
										masDep.setId(departmentId);
										chargeRateObj.setDepartment(masDep);
									}
									hbt.update(chargeRateObj);
								}
						/*	}*/

					} else {
						MasChargeCodeRates chargeCodeRates = new MasChargeCodeRates();
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(chargeId);
						chargeCodeRates.setChargeCode(masChargeCode);
						chargeCodeRates.setEffectiveFromDate(effactiveFromDate);
						chargeCodeRates.setRate(new BigDecimal(charge));
						hospital.setId((Integer)generalMap.get(RequestConstants.HOSPITAL_ID));
						chargeCodeRates.setHospital(hospital);
						if (departmentId != 0) {
							MasDepartment masDep = new MasDepartment();
							masDep.setId(departmentId);
							chargeCodeRates.setDepartment(masDep);
						}
						hbt.save(chargeCodeRates);

					}
					dataUpdated = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return dataUpdated;

			}
  //=========================method end of edit local charge master=============================================================

			@Override
			public boolean deleteLocalChargeCode1(int chargeCodeId,
					Map<String, Object> generalMap) {
			
					boolean dataDeleted = false;
					String changedBy = "";
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
					Session session=(Session)getSession();
					/*MasChargeCode masChargeCode = new MasChargeCode();
					
					masChargeCode = (MasChargeCode) getHibernateTemplate().get(MasChargeCode.class, chargeCodeId);*/
					//lokesh singh
					MasHospitalwiseChargecode masHospitalwiseChargecode=new MasHospitalwiseChargecode();
					List<MasHospitalwiseChargecode> chargecode=new ArrayList<MasHospitalwiseChargecode>();
					chargecode=session.createCriteria(MasHospitalwiseChargecode.class, "mhwc").createAlias("mhwc.ChargeCode", "chc").add(Restrictions.eq("chc.Id",chargeCodeId )).list();
					/*	for(MasHospitalwiseChargecode chargecode2:chargecode){*/
					masHospitalwiseChargecode=(MasHospitalwiseChargecode) getHibernateTemplate().get(MasHospitalwiseChargecode.class,chargecode.get(0).getId());
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					
					if (generalMap.get("flag") != null)
					{
						String flag = (String) generalMap.get("flag");
					
						System.out.println("==="+flag);
						if (flag.equals("InActivate")) {
							//masChargeCode.setStatus("n");
							masHospitalwiseChargecode.setStatus("n");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							//masChargeCode.setStatus("y");
							masHospitalwiseChargecode.setStatus("y");
							dataDeleted = false;
						}
					}
					//masChargeCode.setLastChgBy(changedBy);
					masHospitalwiseChargecode.setLastChgDate(currentDate);
					masHospitalwiseChargecode.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masHospitalwiseChargecode);
					hbt.flush();
					hbt.clear();
			/*}*/
			return dataDeleted;
}
			// ---------------------------------------------Session
						// -------------------------------------------
						public boolean addSession(MasSession masSession,String hospitalCode) {
							boolean successfullyAdded = false;
							String tokenSeqNameForDept="";
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							
							Session session=(Session) getSession();
							int hospitalId=masSession.getHospital().getId();
							hbt.save(masSession);
							int sessionId=masSession.getId();
							
							List<Object[]> departmentList=null;
							departmentList=new ArrayList<Object[]>();
							Criteria crt=session.createCriteria(MasInstituteDepartment.class)
									.setProjection(Projections.property("Department"))
									.add(Restrictions.eq("Institute.Id",hospitalId))
									.add(Restrictions.eq("Status","y").ignoreCase())
									.createAlias("Department", "dep")
									.createAlias("dep.DepartmentType","DepartmentType")
									//.add(Restrictions.eq("DepartmentType.Id",1))
									.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
									.addOrder(Order.asc("dep.DepartmentName"));
							
							ProjectionList projection=Projections.projectionList();
							projection.add(Projections.property("dep.Id"));
							crt.setProjection(projection);
							departmentList=crt.list();
							System.out.println("departmentList "+departmentList.size());
							Iterator it=departmentList.iterator();
							  Connection conn =null;
							 
							
							
							while(it.hasNext())
							{
								int  deptId = (Integer)it.next();
								tokenSeqNameForDept="token_"+deptId+"_"+hospitalCode+"_"+sessionId+"_seq";
								System.out.println("tokenSeqNameForDept  "+tokenSeqNameForDept);
								HMSUtil.generateSequence(tokenSeqNameForDept);
							}
							
							successfullyAdded = true;
							return successfullyAdded;
						}

						public boolean deleteSession(int sessionId, Map<String, Object> generalMap) {
							boolean dataDeleted = false;
							String changedBy = "";
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");

							MasSession masSession = new MasSession();
							masSession = (MasSession) getHibernateTemplate().load(MasSession.class, sessionId);
							int userId=0; 
							userId = (Integer) generalMap.get("userId");
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							if (generalMap.get("flag") != null) {
								String flag = (String) generalMap.get("flag");
								if (flag.equals("InActivate")) {
									masSession.setStatus("N");
									dataDeleted = true;
								} else if (flag.equals("Activate")) {
									masSession.setStatus("Y");
									dataDeleted = false;
								}
							}
							Users users = new Users();
							users.setId(userId);
							masSession.setLastChgBy(users);
							masSession.setLastChgDate(currentDate);
							masSession.setLastChgTime(currentTime);
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.update(masSession);
							return dataDeleted;
						}

						public boolean editSessionToDatabase(Map<String, Object> generalMap) {

							boolean dataUpdated = false;
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							String sessionName = "";
							int sessionId = 0;
							int userId=0;
							int hospitalId=0;
							String fromTime="";
							String toTime="";
							int deptId=(Integer)generalMap.get("deptId");
							hospitalId=(Integer) generalMap.get("hospitalId");
							userId = (Integer) generalMap.get("userId");
							sessionId = (Integer) generalMap.get("id");
							sessionName = (String) generalMap.get("name");
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							fromTime = (String) generalMap.get("fromTime");
							toTime = (String) generalMap.get("toTime");
							MasSession masSession = (MasSession) getHibernateTemplate().load(MasSession.class,
									sessionId);

							masSession.setId(sessionId);
							masSession.setSessionName(sessionName);
							
							masSession.setFromTime(fromTime);
							masSession.setToTime(toTime);
							Users users = new Users();
							users.setId(userId);
							masSession.setLastChgBy(users);
							masSession.setLastChgDate(currentDate);
							
							masSession.setLastChgTime(currentTime);
							
							MasHospital masHospital = new MasHospital();
							masHospital.setId(hospitalId);
							masSession.setHospital(masHospital);
							if(deptId!=0){
								MasDepartment department=new MasDepartment();
								department.setId(deptId);
								masSession.setDepartment(department);
							}else if(deptId==0){
								masSession.setDepartment(null);
							}
							
							
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.update(masSession);
							dataUpdated = true;
							return dataUpdated;
						}

						@SuppressWarnings("unchecked")
						public Map<String, Object> searchSession(String sessionName,Integer hospitalId) {
							List<MasSession> searchSessionList = new ArrayList<MasSession>();
							Map<String, Object> sessionFieldsMap = new HashMap<String, Object>();
							Session session=(Session)getSession();
							
							List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
							try {
								if ((sessionName != null)) {
									searchSessionList = getHibernateTemplate().find(
											"from jkt.hms.masters.business.MasSession imc where imc.SessionName like '"
													+ sessionName + "%' order by imc.SessionName");
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							sessionFieldsMap.put("searchSessionList", searchSessionList);
							
							departmentList=session.createCriteria(MasInstituteDepartment.class)
									.setProjection(Projections.property("Department"))
									.add(Restrictions.eq("Institute.Id",hospitalId))
									.add(Restrictions.eq("Status","y").ignoreCase())
									.createAlias("Department", "dep")
									.createAlias("dep.DepartmentType","DepartmentType")
									.add(Restrictions.eq("dep.Status","y").ignoreCase())
									.addOrder(Order.asc("dep.DepartmentName"))
									.list();
							sessionFieldsMap.put("departmentList", departmentList);
							
							return sessionFieldsMap;
						}

						@SuppressWarnings("unchecked")
						public Map<String, Object> showSessionJsp(Box box) {
							Map<String, Object> map = new HashMap<String, Object>();
							int hospitalId=0;
							List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
							if(box.get(RequestConstants.HOSPITAL_ID)!=null){
								hospitalId=box.getInt(RequestConstants.HOSPITAL_ID);
							}
							List<MasSession> searchSessionList = new ArrayList<MasSession>();
							Session session=(Session)getSession();
							 Criteria criteria=session.createCriteria(MasSession.class)
							.add(Restrictions.eq("Hospital.Id", hospitalId));
							 searchSessionList=criteria.list();
							/*searchSessionList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.MasSession ");*/
							map.put("searchSessionList", searchSessionList);
							
							departmentList=session.createCriteria(MasInstituteDepartment.class)
									.setProjection(Projections.property("Department"))
									.add(Restrictions.eq("Institute.Id",hospitalId))
									.add(Restrictions.eq("Status","y").ignoreCase())
									.createAlias("Department", "dep")
									.createAlias("dep.DepartmentType","DepartmentType")
									.add(Restrictions.eq("dep.Status","y").ignoreCase())
									.addOrder(Order.asc("dep.DepartmentName"))
									.list();
							map.put("departmentList", departmentList);
							
							
							return map;
						}

						@Override
						public Map<String, Object> checkSession(
								Map<String, Object> dataMap) {
							Session session=(Session)getSession();
							Map<String, Object> map = new HashMap<String, Object>();
							List<MasSession> searchSessionList = new ArrayList<MasSession>();
							List<MasSession> searchSessionListTemp = null;  // addded by amit das on 21-08-2017
							int hospitalId=0;
							String visitSessionName="";
							int departmentId = 0; // added by amit das on 21-08-2017 
							String fromTimeStr = null; // added by amit das on 21-08-2017
							String toTimeStr = null; // added by amit das on 21-08-2017
							int fromTime = 0; // added by amit das on 21-08-2017
							int toTime = 0; // added by amit das on 21-08-2017
							int fromTimeFromData = 0; // added by amit das on 21-08-2017
							int toTimeFromData = 0; // added by amit das on 21-08-2017
							
							
							DateFormat dateFormat = new SimpleDateFormat("hh:mm a"); // added by amit das on 21-08-2017
							Calendar cal = Calendar.getInstance();
							
							try{
							Criteria criteria = null;
							if(dataMap.get(RequestConstants.HOSPITAL_ID)!=null){
								hospitalId=Integer.parseInt(dataMap.get(RequestConstants.HOSPITAL_ID).toString());
							}
							if(dataMap.get("name")!=null){
								visitSessionName=dataMap.get("name").toString();
							}
							
							//  added by amit das on 21-08-2017
							if(dataMap.get("departmentId")!=null){
								departmentId = (Integer)dataMap.get("departmentId");
							}
							
							
							if(dataMap.get("fromTime")!=null){
								fromTimeStr =   (String)dataMap.get("fromTime");
								cal.setTime(dateFormat.parse(fromTimeStr));
								fromTime = Integer.parseInt(cal.get(Calendar.HOUR_OF_DAY)+""+(cal.get(Calendar.MINUTE)!=0?cal.get(Calendar.MINUTE):cal.get(Calendar.MINUTE)+"0"));
							}
							
							if(dataMap.get("toTime")!=null){
								toTimeStr   =   (String)dataMap.get("toTime");
								cal.setTime(dateFormat.parse(toTimeStr));
								toTime = Integer.parseInt(cal.get(Calendar.HOUR_OF_DAY)+""+(cal.get(Calendar.MINUTE)!=0?cal.get(Calendar.MINUTE):cal.get(Calendar.MINUTE)+"0"));
							}
							
							// if condition added by amit das on 21-08-2017
							if(departmentId!=0){
							 criteria = session.createCriteria(MasSession.class)
										.add(Restrictions.eq("Hospital.Id", hospitalId))
										.add(Restrictions.eq("Department.Id", departmentId));
							 
							 searchSessionListTemp=criteria.list();
							 
						}else {
							 criteria = session.createCriteria(MasSession.class)
									.add(Restrictions.eq("Hospital.Id", hospitalId))
									.add(Restrictions.eq("SessionName", visitSessionName.trim()).ignoreCase());
									 
							 searchSessionListTemp = criteria.list();
						}
							
							if(searchSessionListTemp!=null && searchSessionListTemp.size()>0){
								 for(MasSession masSession : searchSessionListTemp){
									 	cal.setTime(dateFormat.parse(masSession.getFromTime()));
										fromTimeFromData = Integer.parseInt(cal.get(Calendar.HOUR_OF_DAY)+""+(cal.get(Calendar.MINUTE)!=0?cal.get(Calendar.MINUTE):cal.get(Calendar.MINUTE)+"0"));
										cal.setTime(dateFormat.parse(masSession.getToTime()));
										toTimeFromData = Integer.parseInt(cal.get(Calendar.HOUR_OF_DAY)+""+(cal.get(Calendar.MINUTE)!=0?cal.get(Calendar.MINUTE):cal.get(Calendar.MINUTE)+"0"));
										if(masSession.getSessionName().trim().equalsIgnoreCase(visitSessionName)){
											searchSessionList.add(masSession);
											break;
										}else if(fromTime<=fromTimeFromData){
											if(toTime>fromTimeFromData){
												searchSessionList.add(masSession);
												break;
											}
										}else if(fromTime>=toTimeFromData){
											if(toTime<toTimeFromData){
												searchSessionList.add(masSession);
												break;
											}
										}else {
											searchSessionList.add(masSession);
											break;
										}
								 }
							 }	
							
							
							}catch(Exception e){
								e.printStackTrace();
							}
							
							map.put("duplicateGeneralNameList", searchSessionList);
							return map;
						}

						@Override
						public Map<String, Object> showLocalChargeCodeBlockUnblockJsp(
								Box box) {
							Map<String, Object>map=new HashMap<String, Object>();
							int deptId=0;
							int hospitalId=0;
							if(box.getInt("deptId")!=0){
								deptId=box.getInt("deptId");
							}
							if(box.getInt("hospitalId")!=0){
								hospitalId=box.getInt("hospitalId");
							}
							List<MasHospitalwiseChargecode>chargeCodeList=new ArrayList<MasHospitalwiseChargecode>();
							List<MasHospitalwiseChargecode>blockedchargeCodeList=new ArrayList<MasHospitalwiseChargecode>();
							Session session=(Session)getSession();
							chargeCodeList=session.createCriteria(MasHospitalwiseChargecode.class)
									.add(Restrictions.eq("Hospital.Id", hospitalId))
									.createAlias("ChargeCode", "ChargeCode")
									.add(Restrictions.eq("ChargeCode.Department.Id", deptId))
									.add(Restrictions.or(Restrictions.eq("Blocked", "n").ignoreCase(), Restrictions.isNull("Blocked")))
									.addOrder(Order.asc("ChargeCode.ChargeCodeName"))
									.list();
							blockedchargeCodeList=session.createCriteria(MasHospitalwiseChargecode.class)
									.add(Restrictions.eq("Hospital.Id", hospitalId))
									.createAlias("ChargeCode", "ChargeCode")
									.add(Restrictions.eq("ChargeCode.Department.Id", deptId))
									.add(Restrictions.eq("Blocked", "y").ignoreCase())
									.addOrder(Order.asc("ChargeCode.ChargeCodeName"))
									.list();
							map.put("masHospitalwiseChargecodeList", chargeCodeList);
							map.put("blockedchargeCodeList", blockedchargeCodeList);
							return map;
						}

						@Override
						public Map<String, Object> saveForBlockUnBlock(List<Integer> invFinalList1, String status,int hospitalId,String reasonToBlock) {
							Map<String, Object>map=new HashMap<String,Object>();
							Session session=(Session)getSession();
							
							List<MasHospitalwiseChargecode>chargeCodeList=new ArrayList<MasHospitalwiseChargecode>();
							chargeCodeList=session.createCriteria(MasHospitalwiseChargecode.class)
									.add(Restrictions.in("ChargeCode.Id", invFinalList1)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							boolean updated=false;
							for(MasHospitalwiseChargecode masHospitalwiseChargecode:chargeCodeList){
								masHospitalwiseChargecode.setBlocked(status);
								masHospitalwiseChargecode.setReasonToBlocked(reasonToBlock);
								hbt.update(masHospitalwiseChargecode);
								updated=true;
							}
							map.put("updated",updated);
							return map;
						}

						@Override
						public Map<String, Object> getReasonForBlock(int chargeCodeId, int hospitalId, int deptId) {
							Session session=(Session)getSession();
							Map<String, Object>map=new HashMap<String,Object>();
							List<MasHospitalwiseChargecode>chargeCodeList=new ArrayList<MasHospitalwiseChargecode>();
							String reasonForblock="";
							
							chargeCodeList=session.createCriteria(MasHospitalwiseChargecode.class)
									.add(Restrictions.eq("ChargeCode.Id", chargeCodeId)).add(Restrictions.eq("Blocked", "y").ignoreCase())
									.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
									for(MasHospitalwiseChargecode MasHospitalwiseChargecode:chargeCodeList){
										reasonForblock=MasHospitalwiseChargecode.getReasonToBlocked();
									}
									map.put("reasonForblock",reasonForblock);
							return map;
						}
					 
						//----------------  Action Taken ----------------
						

						public boolean addActionTaken(Map<String, Object> ActionTakenMap) {
							
							boolean successfullyAdded = false;
							MasActionTaken masActionTaken=new MasActionTaken();
							if(ActionTakenMap.get("masActionTaken")!=null){
								masActionTaken=(MasActionTaken)ActionTakenMap.get("masActionTaken");
							}
							int hospitalId=0;
							if(ActionTakenMap.get("hospitalId")!=null){
								hospitalId=(Integer)ActionTakenMap.get("hospitalId");
							}
							try{
								org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
								hbt.setFlushModeName("FLUSH_EAGER");
								hbt.setCheckWriteOperations(false);
								
								hbt.save(masActionTaken);
								
								
								successfullyAdded = true;
							}catch (Exception e) {
								successfullyAdded=false;
								e.printStackTrace();
							}
							return successfullyAdded;
						}

						public boolean editActionTaken(Map<String, Object> generalMap) {
							boolean dataUpdated = false;
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							int stateId = 0;
							String ActionTakenName = "";
							@SuppressWarnings("unused")
							String ActionTakenCode = "";
							int ActionTakenId = 0;
							ActionTakenId = (Integer) generalMap.get("id");
							ActionTakenCode = (String) generalMap.get("ActionTakenCode");
							ActionTakenName = (String) generalMap.get("name");
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							int userId=0; 
							userId = (Integer) generalMap.get("userId");
							MasActionTaken masActionTaken = (MasActionTaken) getHibernateTemplate().get(
									MasActionTaken.class, ActionTakenId);

							masActionTaken.setId(ActionTakenId);
							masActionTaken.setActionTakenName(ActionTakenName);

						

							masActionTaken.setLastChgDate(currentDate);
							masActionTaken.setLastChgTime(currentTime);
							
							
							Users users = new Users();
							users.setId(userId);
							masActionTaken.setLastChgBy(users);
							
							try
							{
								org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
								hbt.setFlushModeName("FLUSH_EAGER");
								hbt.setCheckWriteOperations(false);
								hbt.update(masActionTaken);
								dataUpdated = true;
							}
							catch (DataAccessException e)
							{
								dataUpdated = false;
								e.printStackTrace();
							}
							return dataUpdated;
						}

						@SuppressWarnings("unchecked")
						public Map<String, Object> searchActionTaken(String ActionTakenCode,
								String ActionTakenName) {
							List<MasActionTaken> searchActionTakenList = new ArrayList<MasActionTaken>();
							Map<String, Object> ActionTakenFieldsMap = new HashMap<String, Object>();
							try {
								if ((ActionTakenName != null) || (ActionTakenCode == null)) {
									searchActionTakenList = getHibernateTemplate()
											.find("from jkt.hms.masters.business.MasActionTaken as dis where dis.ActionTakenName like '"
													+ ActionTakenName + "%' order by dis.ActionTakenName");
								} else {
									searchActionTakenList = getHibernateTemplate()
											.find("from jkt.hms.masters.business.MasActionTaken as dis where dis.ActionTakenCode like '"
													+ ActionTakenCode + "%' order by dis.ActionTakenCode");
									
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							ActionTakenFieldsMap.put("searchActionTakenList", searchActionTakenList);
							
							return ActionTakenFieldsMap;
						}

						@SuppressWarnings("unchecked")
						public Map<String, Object> showActionTaken() {
							Map<String, Object> map = new HashMap<String, Object>();
							List<MasActionTaken> searchActionTakenList = new ArrayList<MasActionTaken>();
							try{
								searchActionTakenList = getHibernateTemplate().find("from jkt.hms.masters.business.MasActionTaken");
							}catch (Exception e) {
								e.printStackTrace();
							}
							
							map.put("searchActionTakenList", searchActionTakenList);
							return map;
						}

						@SuppressWarnings("unchecked")
						public boolean deleteActionTaken(int ActionTakenId, Map<String, Object> generalMap) {
							boolean dataDeleted = false;
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							MasActionTaken masActionTaken = new MasActionTaken();
							masActionTaken = (MasActionTaken) getHibernateTemplate().get(
									MasActionTaken.class, ActionTakenId);
							
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							int userId=0; 
							userId = (Integer) generalMap.get("userId");
							if (generalMap.get("flag") != null) {
								String flag = (String) generalMap.get("flag");
								if (flag.equals("InActivate")) {
									masActionTaken.setStatus("n");
									dataDeleted = true;
								} else if (flag.equals("Activate")) {
									masActionTaken.setStatus("y");
									dataDeleted = false;
								}
							}
							Users users = new Users();
							users.setId(userId);
							masActionTaken.setLastChgBy(users);
							masActionTaken.setLastChgDate(currentDate);
							masActionTaken.setLastChgTime(currentTime);
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.update(masActionTaken);
							return dataDeleted;
						}	
	
						@Override
						public Map<String, Object> addSnomedChargeCode(Map<String, Object> map) {
							Session session=(Session)getSession();
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							
							int mainChargecodeId=(Integer)map.get("mainChargecodeId");
							int subChargecodeId=(Integer)map.get("subChargecodeId");
							int chargeTypeId=(Integer)map.get("chargeTypeId");
							int departmentId=(Integer)map.get("departmentId");
							Date effactiveFromDate=(Date)map.get("effactiveFromDate");
							
							Users user =(Users)map.get("user");
							String currentTime =(String)map.get("currentTime");
							
							List<String>codeList=	(List<String>)map.get("codeList");
							List<String>chargeList=	(List<String>)map.get("chargeList");
							List<String>chargeIdList=(List<String>)map.get("chargeIdList");
							List<Float>chargerateList=(List<Float>)map.get("chargerateList");
							
							for(int index=0;index<chargeList.size();index++){
								String name="";
								if(chargeList.size()>0 && chargeList.get(index)!=null){
									name=chargeList.get(index);
								}
								if(!name.equals("")){
									List<Integer> existingChargeList = new ArrayList<Integer>();
									existingChargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("ChargeCodeName", name).ignoreCase())
											.setProjection(Projections.property("Id")).list();
									
									if(existingChargeList.size()==0){
										MasChargeCode masChargeCode=new MasChargeCode();
										MasMainChargecode masMainChargecode = new MasMainChargecode();
										MasSubChargecode masSubChargecode = new MasSubChargecode();
										MasChargeType masChargeType = new MasChargeType();
										MasDepartment masDepartment = new MasDepartment();
										MasChargeCodeRates chargeCodeRates = new MasChargeCodeRates();

										masChargeCode.setChargeCodeName(name);

										if(codeList.size()>0 && codeList.get(index)!=null){
											String code=codeList.get(index);
											masChargeCode.setChargeCodeCode(code);
										}
										
										if(chargeIdList.size()>0 && chargeIdList.get(index)!=null){
											String codeId=chargeIdList.get(index);
											masChargeCode.setSnomedConceptId(codeId);
										}

										if(chargerateList.size()>0 && chargerateList.get(index)!=null){
											Float amount=chargerateList.get(index);
											masChargeCode.setCharge(amount);
											chargeCodeRates.setRate(new BigDecimal(amount));
										}

										masMainChargecode.setId(mainChargecodeId);
										masChargeCode.setMainChargecode(masMainChargecode);

										masSubChargecode.setId(subChargecodeId);
										masChargeCode.setSubChargecode(masSubChargecode);

										masChargeType.setId(chargeTypeId);
										masChargeCode.setChargeType(masChargeType);

										masDepartment.setId(departmentId);
										masChargeCode.setDepartment(masDepartment);

										masChargeCode.setDateEffectiveFrom(effactiveFromDate);
										masChargeCode.setLastChgBy(user);
										masChargeCode.setLastChgDate(new Date());
										masChargeCode.setLastChgTime(currentTime);
										masChargeCode.setOpdRelatedServices("n");
										masChargeCode.setEditable("n");
										masChargeCode.setDiscountable("n");
										masChargeCode.setDrAccountingRequired("n");
										masChargeCode.setOpdRelatedServices("n");
										masChargeCode.setStatus("y");
										chargeCodeRates.setChargeCode(masChargeCode);
										hbt.save(masChargeCode);

										chargeCodeRates.setEffectiveFromDate(effactiveFromDate);
										hbt.save(chargeCodeRates);
									}else{
										MasChargeCode masChargeCode = hbt.load(MasChargeCode.class, existingChargeList.get(0));
										masChargeCode.setStatus("y");
										if(chargeIdList.size()>0 && chargeIdList.get(index)!=null){
											String codeId=chargeIdList.get(index);
											masChargeCode.setSnomedConceptId(codeId);
										}
										hbt.update(masChargeCode);
									}
								}
								map.put("message","charge code save successfully!");
							}
							return map;
						}

						@Override
						public Map<String, Object> showServiceCentreCounterJsp(int hospitalId) {
							Map<String, Object> map = new HashMap<String, Object>();
							Session session=(Session)getSession();
							List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
							List<MasServiceCentreCounter> searchServiceCentreCounterList = new ArrayList<MasServiceCentreCounter>();
							//List<MasInstituteDepartment> masInstituteDepartmentList = new ArrayList<MasInstituteDepartment>();
							searchServiceCentreCounterList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.MasServiceCentreCounter " +
											"as mscc where mscc.Hospital.Id =" + hospitalId); //Added by Arbind on 24-04-2017
							map.put("searchServiceCentreCounterList", searchServiceCentreCounterList);
							List<Object> masInstituteDepartmentList = new ArrayList<Object>();
							
							Criteria criteria = session
									.createCriteria(MasInstituteDepartment.class)
									.createAlias("Institute", "h")
									.createAlias("Department", "d")
									.add(Restrictions.eq("h.Id", hospitalId))
									.add(Restrictions.eq("Status", 'y').ignoreCase())
									.setProjection(
											Projections
													.projectionList()
													.add(Projections
															.groupProperty("d.Id"))
													.add(Projections
															.property("d.DepartmentName")))
									.addOrder(Order.asc("d.DepartmentName"));//Added by Arbind on 24-04-2017

							masInstituteDepartmentList = session.createCriteria(MasInstituteDepartment.class)
									.add(Restrictions.eq("Institute.Id", hospitalId)).list();
											masInstituteDepartmentList = criteria.list();
							map.put("masInstituteDepartmentList", masInstituteDepartmentList);
							departmentList = getHibernateTemplate()
									.find("from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y'");
							map.put("departmentList", departmentList);
							
							return map;
						}

						@Override
						public Map<String, Object> checkForExistingServiceCentreCounter(
								Map<String, Object> generalMap) {
							Session session=(Session)getSession();
							Map<String, Object> map = new HashMap<String, Object>();
							List duplicateChargeCodeNameList = new ArrayList();
							String counterNo = (String) generalMap.get("counterNo");
							int departmentId= (Integer) generalMap.get("departmentId");
							int hospitalId= (Integer) generalMap.get("hospitalId");
							try {
								
								
								
								duplicateChargeCodeNameList = 
										session.createCriteria(MasServiceCentreCounter.class).add(Restrictions.eq("CounterNo", counterNo))
										.add(Restrictions.eq("Department.Id", departmentId)).add(Restrictions.eq("Hospital.Id", hospitalId))
									//	.add(Restrictions.ne("Id", serviceCentreCounterId))
										.list();
								map.put("duplicateChargeCodeNameList", duplicateChargeCodeNameList);
							} catch (DataAccessException e) {
								e.printStackTrace();
							}

							return map;

						}

						@Override
						public Map<String, Object> checkForExistingServiceCentreCounterId(
								Map<String, Object> generalMap) {
							Session session=(Session)getSession();
							Map<String, Object> map = new HashMap<String, Object>();
							List duplicateChargeCodeNameList = new ArrayList();
							String counterNo = (String) generalMap.get("counterNo");
							int departmentId= (Integer) generalMap.get("departmentId");
							int serviceCentreCounterId= (Integer) generalMap.get("id");
							int hospitalId= (Integer) generalMap.get("hospitalId");
							try {
								
								
								
								duplicateChargeCodeNameList = 
										session.createCriteria(MasServiceCentreCounter.class).add(Restrictions.eq("CounterNo", counterNo))
										.add(Restrictions.eq("Department.Id", departmentId)).add(Restrictions.eq("Hospital.Id", hospitalId))
										.add(Restrictions.ne("Id", serviceCentreCounterId))
										.list();
								map.put("duplicateChargeCodeNameList", duplicateChargeCodeNameList);
							} catch (DataAccessException e) {
								e.printStackTrace();
							}

							return map;

						}

						@Override
						public boolean editServiceCentreCounter(
								Map<String, Object> generalMap) {

							boolean dataUpdated = false;
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							
							String counterNo = "";
							int serviceCentreCounterId = 0;
							int departmentId = 0;
							int changedBy = 0;
							int hospitalId=0;
							serviceCentreCounterId = (Integer) generalMap.get("id");
							
							counterNo = (String) generalMap.get("counterNo");
							departmentId = (Integer) generalMap.get("departmentId");
							changedBy = (Integer) generalMap.get("changedBy");
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							hospitalId=(Integer) generalMap.get("hospitalId");
							MasServiceCentreCounter masServiceCentreCounter = (MasServiceCentreCounter) getHibernateTemplate().get(
									MasServiceCentreCounter.class, serviceCentreCounterId);

							

							if (departmentId != 0) {
								MasDepartment masDepartment=new MasDepartment();
								masDepartment.setId(departmentId);
								masServiceCentreCounter.setDepartment(masDepartment);
							}

							masServiceCentreCounter.setCounterNo(counterNo);
							
							masServiceCentreCounter.setStatus("y");
							Users users = new Users();
							users.setId(changedBy);
							masServiceCentreCounter.setLastChgBy(users);
							masServiceCentreCounter.setLastChgDate(currentDate);
							masServiceCentreCounter.setLastChgTime(currentTime);
							
							MasHospital hospital=new MasHospital();
							hospital.setId(hospitalId);
							masServiceCentreCounter.setHospital(hospital);
							
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.update(masServiceCentreCounter);
							dataUpdated = true;
							return dataUpdated;
						}

						@Override
						public boolean deleteServiceCentreCounter(
								int serviceCentreCounterId,
								Map<String, Object> generalMap) {
							boolean dataDeleted = false;
							int changedBy = 0;
							Date currentDate = new Date();
							String currentTime = "";
							currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
									"currentTime");
							MasServiceCentreCounter masServiceCentreCounter = new MasServiceCentreCounter();
							masServiceCentreCounter = (MasServiceCentreCounter) getHibernateTemplate().get(
									MasServiceCentreCounter.class, serviceCentreCounterId);
							changedBy = (Integer) generalMap.get("changedBy");
							currentDate = (Date) generalMap.get("currentDate");
							currentTime = (String) generalMap.get("currentTime");
							if (generalMap.get("flag") != null) {
								String flag = (String) generalMap.get("flag");
								if (flag.equals("InActivate")) {
									masServiceCentreCounter.setStatus("n");
									dataDeleted = true;
								} else if (flag.equals("Activate")) {
									masServiceCentreCounter.setStatus("y");
									dataDeleted = false;
								}
							}
							Users user= new Users();
							user.setId(changedBy);
							masServiceCentreCounter.setLastChgBy(user);
							masServiceCentreCounter.setLastChgDate(currentDate);
							masServiceCentreCounter.setLastChgTime(currentTime);
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.update(masServiceCentreCounter);
							return dataDeleted;
						}

						@Override
						public Map<String, Object> searchServiceCentreCounter(
								int departmentId, String counterNo,int hospitalId) {
							Map<String, Object> map = new HashMap<String, Object>();
							
							List<MasServiceCentreCounter> searchServiceCentreCounterList = new ArrayList<MasServiceCentreCounter>();
							List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
							//List<MasInstituteDepartment> masInstituteDepartmentList = new ArrayList<MasInstituteDepartment>();				
							Session session=(Session)getSession();
							try {
								if ((departmentId != 0) || (counterNo == null)) {
									searchServiceCentreCounterList = session.createCriteria(MasServiceCentreCounter.class)
											.add(Restrictions.eq("Department.Id", departmentId))
											.add(Restrictions.eq("Hospital.Id", hospitalId)).list(); //Added by Arbind on 18-12-2017
								} else {
									searchServiceCentreCounterList = session.createCriteria(MasServiceCentreCounter.class)
											.add(Restrictions.eq("CounterNo", counterNo))
											.add(Restrictions.eq("Hospital.Id", hospitalId)).list(); //Added by Arbind on 18-12-2017
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							/*masInstituteDepartmentList = session.createCriteria(MasInstituteDepartment.class)
									.add(Restrictions.eq("Institute.Id", hospitalId)).list();*/
							departmentList = getHibernateTemplate()
									.find("from jkt.hms.masters.business.MasDepartment as isc where lower(isc.Status) = 'y'");
							List<Object> masInstituteDepartmentList = new ArrayList<Object>();
							
							
							Criteria criteria = session
									.createCriteria(MasInstituteDepartment.class)
									.createAlias("Institute", "h")
									.createAlias("Department", "d")
									.add(Restrictions.eq("h.Id", hospitalId))
									.add(Restrictions.eq("Status", 'y').ignoreCase())
									.setProjection(
											Projections
													.projectionList()
													.add(Projections
															.groupProperty("d.Id"))
													.add(Projections
															.property("d.DepartmentName")));
													
							/*masInstituteDepartmentList = session.createCriteria(MasInstituteDepartment.class)
									.add(Restrictions.eq("Institute.Id", hospitalId)).list();*/
											masInstituteDepartmentList = criteria.list();
											map.put("masInstituteDepartmentList", masInstituteDepartmentList);
							map.put("departmentList", departmentList);
							map.put("searchServiceCentreCounterList", searchServiceCentreCounterList);
							return map;
						}

						@Override
						public boolean addServiceCentreCounter(
								MasServiceCentreCounter masServiceCentreCounter) {

							boolean successfullyAdded = false;
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							hbt.save(masServiceCentreCounter);
							successfullyAdded = true;
							return successfullyAdded;
						
							
						
						}
						
						
						

						@Override
						public boolean removeDoctorFromUnit(String unit_t_id) {
							HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							Session session = (Session)getSession();
							Transaction tx = null;
							boolean updated = false;
							
							try{
								tx = session.beginTransaction();
								HospitalDoctorUnitT hpdt = (HospitalDoctorUnitT) hbt.load(HospitalDoctorUnitT.class, Integer.parseInt(unit_t_id));
								hpdt.setStatus("n");
								hbt.update(hpdt);
								tx.commit();
								updated=true;
							}catch(Exception e){
								e.printStackTrace();
								updated=false;
							}
							
							return updated;
						}	
						
	@Override
	public Map<String, Object> getMultiDepartmentMappings(
			Map<String, Object> map) {
		Map<String, Object> multiDepartmentMappingsMap = new HashMap<>();
		Session session = (Session) getSession();
		int hospitalId = 0;
		List<Object[]> multiDepartmentMappingsList;
		List<MasInstituteDepartment> serviceCenterList;
		List<MasInstituteDepartment> childPharmacyServiceCenterList;
		List<MasInstituteDepartment> childLabServiceCenterList;
		List<MasInstituteDepartment> childBillingServiceCenterList;
		List<MasInstituteDepartment> childSampleCollectionServiceCenterList;
		List<String> departmentTypeList;
		String[] departmentTypeCodes = {"PHR","DIAG"};

		hospitalId = (Integer) map.get("hospitalId");

		multiDepartmentMappingsList = session
				.createCriteria(MultiDepartmentMapping.class)
				.createAlias("ServiceCenter", "p")
				.createAlias("p.Department", "d")
				.createAlias("p.Institute", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				.setProjection(Projections.projectionList().add(Projections.groupProperty("ParentServiceCenter")).add(Projections.groupProperty("d.DepartmentType")))
				.list();

		serviceCenterList = session
				.createCriteria(MasInstituteDepartment.class)
				.createAlias("Institute", "h")
				.createAlias("Department", "d")
				.createAlias("d.DepartmentType", "dt")
				.add(Restrictions.in("dt.DepartmentTypeCode", new String[]{"CR","DIAG"}))
				.add(Restrictions.eq("h.Id", hospitalId))
				.list();

		childPharmacyServiceCenterList = session
				.createCriteria(MasInstituteDepartment.class)
				.createAlias("Institute", "h")
				.createAlias("Department", "d")
				.createAlias("d.DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode", "PHR")
						.ignoreCase()).add(Restrictions.eq("h.Id", hospitalId))
				.list();

		childLabServiceCenterList = session
				.createCriteria(MasInstituteDepartment.class)
				.createAlias("Institute", "h")
				.createAlias("Department", "d")
				.createAlias("d.DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode", "DIAG")
						.ignoreCase()).add(Restrictions.eq("h.Id", hospitalId))
				.list();

		departmentTypeList = session
				.createCriteria(MasDepartmentType.class)
				.add(Restrictions.in("DepartmentTypeCode", departmentTypeCodes))
				.setProjection(Projections.property("DepartmentTypeName"))
				.list();

		multiDepartmentMappingsMap.put("multiDepartmentMappingsList",
				multiDepartmentMappingsList);
		multiDepartmentMappingsMap.put("serviceCenterList", serviceCenterList);
		multiDepartmentMappingsMap.put("childPharmacyServiceCenterList",
				childPharmacyServiceCenterList);
		multiDepartmentMappingsMap.put("childLabServiceCenterList",
				childLabServiceCenterList);
		multiDepartmentMappingsMap
				.put("departmentTypeList", departmentTypeList);

		return multiDepartmentMappingsMap;
	}

	@Override
	public Map<String, Object> addMultiDepartmentMapping(Map<String, Object> map) {
		Map<String, Object> multiDepartmentMappingsMap = new HashMap<>();

		Session session = (Session) getSession();
		Transaction transaction = null;

		int parentServiceCenterId = 0;
		boolean result = false;
		String[] serviceCenterIdArray;
		String departmentTypeName;
		String serviceCenterId;

		MultiDepartmentMapping multiDepartmentMapping = null;
		List<MultiDepartmentMapping> departmentMappingsList;
		List<MasInstituteDepartment> opClinincCenterList;
		List<MasInstituteDepartment> pharmacyCenterList;

		String deleteQuery = "delete MultiDepartmentMapping mdm "
				+ "where mdm.ParentServiceCenter.Id =:parentServiceCenterId and "
				+ "mdm.ServiceCenter.Id in "
				+ "(select id from MasInstituteDepartment mid where mid.Department.DepartmentType.DepartmentTypeName =:departmentTypeName)";

		if (map.get("parentServiceCenterId") != null)
			parentServiceCenterId = (Integer) map.get("parentServiceCenterId");

		serviceCenterIdArray = (String[]) map.get("serviceCenterIdArray");
		departmentTypeName = (String) map.get("departmentTypeName");

		try {
			if (departmentTypeName != null
					&& !departmentTypeName.trim().equals("")) {
				if (parentServiceCenterId != 0 && serviceCenterIdArray != null) {
					transaction = session.beginTransaction();
					Query query = session.createQuery(deleteQuery);
					query.setParameter("parentServiceCenterId",
							parentServiceCenterId);
					query.setParameter("departmentTypeName", departmentTypeName);
					query.executeUpdate();

					for (int i = 0; i < serviceCenterIdArray.length; i++) {
						serviceCenterId = serviceCenterIdArray[i];
						if (!serviceCenterId.equals("0")) {
							multiDepartmentMapping = new MultiDepartmentMapping();
							multiDepartmentMapping
									.setServiceCenter(new MasInstituteDepartment(
											Integer.parseInt(serviceCenterId)));
							multiDepartmentMapping
									.setParentServiceCenter(new MasInstituteDepartment(
											parentServiceCenterId));
							session.save(multiDepartmentMapping);
							session.flush();
						}
						result = true;
					}

					transaction.commit();
				}
			}
		} catch (Exception e) {
			if(transaction!=null)
				transaction.rollback();
			logger.error(e);
		} finally {
			session.close();
		}

		multiDepartmentMappingsMap = getMultiDepartmentMappings(map);
		multiDepartmentMappingsMap.put("result", result);
		return multiDepartmentMappingsMap;
	}

	@Override
	public Map<String, Object> deleteMultiDepartmentMapping(
			Map<String, Object> map) {
		Map<String, Object> multiDepartmentMappingsMap;
		
		Session session = (Session) getSession();
		Transaction transaction;

		MultiDepartmentMapping multiDepartmentMapping;
		String[] parentServiceCenterIdArray;
		String deleteQuery = "delete MultiDepartmentMapping mdm where mdm.ParentServiceCenter.Id = :parentServiceCenterId";

		parentServiceCenterIdArray = (String[]) map.get("parentServiceCenterIdArray");

		try {
			if (parentServiceCenterIdArray != null) {
				transaction = session.beginTransaction();
				Query query = session.createQuery(deleteQuery);

				for (int i = 0; i < parentServiceCenterIdArray.length; i++) {
					query.setParameter("parentServiceCenterId",
							Integer.parseInt(parentServiceCenterIdArray[i]));
					query.executeUpdate();
				}

				transaction.commit();
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			session.close();
		}

		multiDepartmentMappingsMap = getMultiDepartmentMappings(map);
		return multiDepartmentMappingsMap;
	}

	@Override
	public Map<String, Object> showDoctorCounterMapping(Map<String, Object> map) {
		Session session = (Session) getSession();
		int hospitalId=(Integer)map.get("hospitalId");
		
		List<MasInstituteDepartment> departmentList = new ArrayList<MasInstituteDepartment>();
	
		departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType","DepartmentType")
					.add(Restrictions.eq("DepartmentType.DepartmentTypeName","OP Clinic"))
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			map.put("departmentList", departmentList);
			
		return map;
	}

	@Override
	public Map showDoctorCounterValues(Map generalMap) {
		Session session = (Session) getSession();
		 int departmentId=(Integer)generalMap.get("departmentId");
		 int hospitalId=(Integer)generalMap.get("hospitalId");
		 Map<String, Object> map = new HashMap<String, Object>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id",departmentId)).list();
		/*	int empDeptId=0;
			if(departmentList.size()>0){
				empDeptId	= departmentList.get(0).getEmpDept().getId();
				
			}*/
		
			List<MasEmployeeDepartment> MasEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
			List<Integer> empDeptIdList=new ArrayList<Integer>();
			
			for(MasDepartment empDep:departmentList){
				empDeptIdList.add(empDep.getEmpDept().getId());
			}
			
			String unitDay=HMSUtil.getDayOfWeek().toLowerCase();		
			List<Object[]> hospitalDoctorUnitMList = new ArrayList<Object[]>();
			if(empDeptIdList.size()>0)
			{
			hospitalDoctorUnitMList = session.createCriteria(HospitalDoctorUnitM.class).createAlias("EmpDept", "EmpDept")
				    .createAlias("Hospital", "Hospital")
					 .add(Restrictions.eq("Hospital.Id",hospitalId))
					 .add(Restrictions.in("EmpDept.Id",empDeptIdList))
					 .add(Restrictions.eq(((String) unitDay.subSequence(0,1)).toUpperCase()+unitDay.substring(1),"y"))//Added By OM Tripathi
					.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("Id"))).add(Projections.property("UnitCode")))
					.list();
			}
			map.put("hospitalDoctorUnitMList", hospitalDoctorUnitMList);
			
			
		/*	List<MasServiceCentreCounter> masServiceCentreCounterList = new ArrayList<MasServiceCentreCounter>();
			masServiceCentreCounterList = session.createCriteria(MasServiceCentreCounter.class)
			.createAlias("Department", "dept")
		     .add(Restrictions.eq("dept.Id",departmentId))
			.list();
		
			map.put("masServiceCentreCounterList", masServiceCentreCounterList);*/
			map.put("departmentId", departmentId);
			
			
		return map;
	}

	
	@Override
	public Map showEmpValues(Map generalMap) {
		Session session = (Session) getSession();
		 int hospitalDoctorUnitId=(Integer)generalMap.get("hospitalDoctorUnitId");
		 int departmentId=(Integer)generalMap.get("departmentId");
		 int hospitalId=(Integer)generalMap.get("hospitalId");
		 Map<String, Object> map = new HashMap<String, Object>();
		
		 
			 
			List<HospitalDoctorUnitT> hospitalDoctorUnitTList = new ArrayList<HospitalDoctorUnitT>();
			List<HospitalDoctorUnitT> finalHospitalDoctorUnitTList = new ArrayList<HospitalDoctorUnitT>();
			
			hospitalDoctorUnitTList = session.createCriteria(HospitalDoctorUnitT.class)
					 .createAlias("UnitM", "hd")
					.add(Restrictions.eq("hd.Id",hospitalDoctorUnitId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			
					
			List<Users> userList = new ArrayList<Users>();
			List<Integer> empIdList=new ArrayList<Integer>();
			
			for(HospitalDoctorUnitT emp:hospitalDoctorUnitTList){
				
				if(emp.getEmployee().getUsers()!=null && emp.getEmployee().getUsers().size()>0){
						finalHospitalDoctorUnitTList.add(emp);
						 empIdList.add(emp.getEmployee().getId());
				}
			}
			
			if(empIdList.size() > 0){
				userList = session.createCriteria(Users.class).createAlias("Employee", "e").add(Restrictions.in("e.Id", empIdList)).list();
				
			}
			map.put("userList", userList);
			
			/*List<Integer> masServiceCentreCounterList = new ArrayList<Integer>();
			masServiceCentreCounterList = session.createCriteria(MasServiceCentreCounter.class).createAlias("Department", "dept").add(Restrictions.eq("dept.Id",departmentId))
					.setProjection(Projections.count("Id")).list();
		
			
			int noOfCounter=0;
			if(masServiceCentreCounterList.size()>0){
				noOfCounter	= masServiceCentreCounterList.get(0);
				
			}*/
			
			List<MasServiceCentreCounter> masServiceCentreCounterList = new ArrayList<MasServiceCentreCounter>();
			masServiceCentreCounterList = session.createCriteria(MasServiceCentreCounter.class)
			.createAlias("Department", "dept")
			.createAlias("Hospital", "hosp")   //Added By OM Tripathi 16/1/2018
		     .add(Restrictions.eq("dept.Id",departmentId))
		      .add(Restrictions.eq("hosp.Id",hospitalId)) //Added By OM Tripathi 16/1/2018
		      .addOrder(Order.asc("CounterNo"))
		      .list();
		
			
			
			
			
			map.put("masServiceCentreCounterList", masServiceCentreCounterList);
			map.put("hospitalDoctorUnitTList", finalHospitalDoctorUnitTList);
		return map;
	}

	@Override
	public boolean editDoctorCounterMapping(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		//int cntId=0; 
		int userId = 0;
		int usersId=0;String status=null;int servicecenterId=0;
		//List<Integer> counterIdList = new ArrayList<>();
		List<Integer> userIdList = new ArrayList<>();
		List<String> StatusList = new ArrayList<>();
		//counterIdList = (List<Integer>) generalMap.get("counterIdList");
		try{
		userIdList = (List<Integer>) generalMap.get("userIdList");
		StatusList = (List<String>) generalMap.get("StatusList");
		
		usersId =(int) generalMap.get("usersId");
		 if(generalMap.get("servicecenterId")!=null){
			 servicecenterId =Integer.parseInt(generalMap.get("servicecenterId").toString());
		 }
		for(int i =0;i<userIdList.size();i++){
		userId = userIdList.get(i);
		//cntId = counterIdList.get(i);
		status = StatusList.get(i);
		
		Users user = (Users) getHibernateTemplate().get(Users.class, userId);
		if(status!=null){
			user.setAvailableToday(status);  //Added By OM Tripathi 16/1/2018
			MasDepartment department= new MasDepartment();
			department.setId(servicecenterId);
			user.setDepartment(department);
		//MasServiceCentreCounter cc = new MasServiceCentreCounter();
		//cc.setId(cntId);
		//user.setCurrentCounter(cc);
		}/*else{
			//user.setAvailableToday(null);
		}*/
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(user);
			/*if(cntId!=0){
				MasServiceCentreCounter masServiceCentreCounter = (MasServiceCentreCounter) getHibernateTemplate().get(MasServiceCentreCounter.class, cntId);
				//masServiceCentreCounter.setStatus("b");
				masServiceCentreCounter.setLastChgDate(new Date());
				masServiceCentreCounter.setLastChgTime((String)HMSUtil.getCurrentDateAndTime().get("currentTime"));
				Users users =new Users();
				users.setId(usersId);
				masServiceCentreCounter.setLastChgBy(users);

				hbt.update(masServiceCentreCounter); //Added By OM Tripathi 16/1/2018
			}*/
			dataUpdated = true;
		}
		catch (DataAccessException e)
		{
			dataUpdated = false;
			e.printStackTrace();
		}
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return dataUpdated;
	}
			
}