package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.MasApkVersion;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasTransactionType;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasLeave;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SystemRelatedMasterDataServiceImpl extends HibernateDaoSupport
		implements SystemRelatedMasterDataService {
	Map<String, Object> map = new HashMap<String, Object>();
	static final Logger LOGGER = Logger.getLogger(SystemRelatedMasterDataServiceImpl.class);

	// ------------------------------------------ Department Type
	// -------------------------------
	public boolean addDepartmentType(MasDepartmentType masDepartmentType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDepartmentType);
		hbt.flush();hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDepartmentTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartmentType> searchDepartmentTypeList = new ArrayList<MasDepartmentType>();
		searchDepartmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartmentType ");
		map.put("searchDepartmentTypeList", searchDepartmentTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDepartmentType(String departmentTypeCode,
			String departmentTypeName) {
		List<MasDepartmentType> searchDepartmentTypeList = new ArrayList<MasDepartmentType>();
		Map<String, Object> departmentTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((departmentTypeName != null) || (departmentTypeCode == null)) {

				searchDepartmentTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDepartmentType imc where lower(imc.DepartmentTypeName) like '"
								+ departmentTypeName.toLowerCase()
								+ "%' order by imc.DepartmentTypeName");
			} else {
				searchDepartmentTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDepartmentType imc where lower(imc.DepartmentTypeCode) like '"
								+ departmentTypeCode.toLowerCase()
								+ "%' order by imc.DepartmentTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		departmentTypeFieldsMap.put("searchDepartmentTypeList",
				searchDepartmentTypeList);
		return departmentTypeFieldsMap;

	}

	public boolean editDepartmentTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String departmentTypeName = "";
		@SuppressWarnings("unused")
		String departmentTypeCode = "";
		int departmentTypeId = 0;
		int userId = 0;
		departmentTypeId = (Integer) generalMap.get("id");
		departmentTypeCode = (String) generalMap.get("departmentTypeCode");
		departmentTypeName = (String) generalMap.get("name");
		
		
		String serviceCentreCategoryType="";
		String displayInWebSite="";
		String displayAtTokenCounter="";
		serviceCentreCategoryType = (String) generalMap.get("serviceCentreCategoryType");
		displayInWebSite = (String) generalMap.get("displayInWebSite");
		displayAtTokenCounter = (String) generalMap.get("displayAtTokenCounter");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDepartmentType masDepartmentType = (MasDepartmentType) getHibernateTemplate()
				.load(MasDepartmentType.class, departmentTypeId);

		masDepartmentType.setId(departmentTypeId);
		masDepartmentType.setDepartmentTypeName(departmentTypeName);
		
		Users users=new Users();
		users.setId(userId);
		masDepartmentType.setLastChgBy(users);
		masDepartmentType.setStatus("Y");
		masDepartmentType.setLastChgDate(currentDate);
		masDepartmentType.setLastChgTime(currentTime);
		
		masDepartmentType.setServiceCentreCategoryType(serviceCentreCategoryType);
		masDepartmentType.setDisplayInWebSite(displayInWebSite);
		masDepartmentType.setDisplayAtTokenCounter(displayAtTokenCounter);
		
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartmentType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteDepartmentType(int departmentTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDepartmentType masDepartmentType = new MasDepartmentType();
		masDepartmentType = (MasDepartmentType) getHibernateTemplate().load(
				MasDepartmentType.class, departmentTypeId);
		
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDepartmentType.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDepartmentType.setStatus("Y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masDepartmentType.setLastChgBy(users);

		
		masDepartmentType.setLastChgDate(currentDate);
		masDepartmentType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartmentType);
		return dataDeleted;
	}

	// ------------------------------------------ Transaction Type
	// --------------------------------------------
	public boolean addTransactionType(MasTransactionType masTransactionType) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTransactionType);
		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTransactionTypeJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTransactionType> searchTransactionTypeList = new ArrayList<MasTransactionType>();
		searchTransactionTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTransactionType ");
		map.put("searchTransactionTypeList", searchTransactionTypeList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTransactionType(
			String transactionTypeCode, String transactionTypeName) {
		List<MasTransactionType> searchTransactionTypeList = new ArrayList<MasTransactionType>();
		Map<String, Object> transactionTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((transactionTypeName != null) || (transactionTypeCode == null)) {

				searchTransactionTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasTransactionType imc where imc.TransactionTypeName like '"
								+ transactionTypeName
								+ "%' order by imc.TransactionTypeName");
			} else {
				searchTransactionTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasTransactionType imc where imc.TransactionTypeCode like '"
								+ transactionTypeCode
								+ "%' order by imc.TransactionTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		transactionTypeFieldsMap.put("searchTransactionTypeList",
				searchTransactionTypeList);
		return transactionTypeFieldsMap;
	}

	public boolean editTransactionTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String transactionTypeName = "";
		@SuppressWarnings("unused")
		String transactionTypeCode = "";
		int transactionTypeId = 0;
		String changedBy = "";
		transactionTypeId = (Integer) generalMap.get("id");
		transactionTypeCode = (String) generalMap.get("transactionTypeCode");
		transactionTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasTransactionType masTransactionType = (MasTransactionType) getHibernateTemplate()
				.load(MasTransactionType.class, transactionTypeId);

		masTransactionType.setId(transactionTypeId);
		masTransactionType.setTransactionTypeName(transactionTypeName);
		masTransactionType.setLastChgBy(changedBy);
		masTransactionType.setLastChgDate(currentDate);
		masTransactionType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTransactionType);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean deleteTransactionType(int transactionTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTransactionType masTransactionType = new MasTransactionType();
		masTransactionType = (MasTransactionType) getHibernateTemplate().load(
				MasTransactionType.class, transactionTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTransactionType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTransactionType.setStatus("y");
				dataDeleted = false;
			}
		}
		masTransactionType.setLastChgBy(changedBy);
		masTransactionType.setLastChgDate(currentDate);
		masTransactionType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTransactionType);
		return dataDeleted;

	}

	// ---------------------------------- Frequency
	// -------------------------------------

	public boolean addFrequency(MasFrequency masFrequency) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masFrequency);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteFrequency(int frequencyId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasFrequency masFrequency = new MasFrequency();
		masFrequency = (MasFrequency) getHibernateTemplate().load(
				MasFrequency.class, frequencyId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masFrequency.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masFrequency.setStatus("Y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masFrequency.setLastChgBy(users);
		masFrequency.setLastChgDate(currentDate);
		masFrequency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masFrequency);
		return dataDeleted;
	}

	public boolean editFrequencyToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String frequencyName = "";
		String frequencyType = ""; // added by amit das on 03-04-2017
		@SuppressWarnings("unused")
		String frequencyCode = "";
		int frequencyId = 0;
		int userId = 0;
		frequencyId = (Integer) generalMap.get("id");
		frequencyCode = (String) generalMap.get("frequencyCode");
		frequencyName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int frequencyValue=(Integer)generalMap.get("frequencyValue"); 
		frequencyType = (String) generalMap.get("frequencyType"); // added by amit das on 03-04-2017
		MasFrequency masFrequency = (MasFrequency) getHibernateTemplate().load(
				MasFrequency.class, frequencyId);

		masFrequency.setId(frequencyId);
		masFrequency.setFrequencyName(frequencyName);
		/*//commented for maven*/		
		masFrequency.setFrequencyCount(frequencyValue); // uncommented  by amit das on 03-04-2017
		masFrequency.setFrequencyType(frequencyType); // added by amit das on 03-04-2017
		Users users=new Users();
		users.setId(userId);
		masFrequency.setLastChgBy(users);
		masFrequency.setLastChgDate(currentDate);
		masFrequency.setLastChgTime(currentTime);
		masFrequency.setStatus("Y");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masFrequency);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName) {

		List<MasFrequency> searchFrequencyList = new ArrayList<MasFrequency>();
		Map<String, Object> frequencyFieldsMap = new HashMap<String, Object>();
		try {
			if ((frequencyName != null) || (frequencyCode == null)) {
				searchFrequencyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasFrequency imc where lower(imc.FrequencyName) like '"
								+ frequencyName.toLowerCase()
								+ "%' order by imc.FrequencyName");
			} else {
				searchFrequencyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasFrequency imc where lower(imc.FrequencyCode) like '"
								+ frequencyCode.toLowerCase()
								+ "%' order by imc.FrequencyCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		frequencyFieldsMap.put("searchFrequencyList", searchFrequencyList);
		return frequencyFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showFrequencyJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasFrequency> searchFrequencyList = new ArrayList<MasFrequency>();
		searchFrequencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasFrequency ");
		map.put("searchFrequencyList", searchFrequencyList);
		return map;
	}

	// ------------------------------------------- Department
	// -----------------------------

	public boolean addDepartment(MasDepartment masDepartment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDepartment);
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteDepartment(int departmentId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		Integer changedBy = null;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDepartment masDepartment = new MasDepartment();
		masDepartment = (MasDepartment) getHibernateTemplate().load(
				MasDepartment.class, departmentId);
		@SuppressWarnings("unused")
		Integer departmentTypeId = masDepartment.getDepartmentType().getId();
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDepartment.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDepartment.setStatus("Y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masDepartment.setLastChgBy(users);
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		return dataDeleted;

	}

	public boolean editDepartmentToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int departmentTypeId = 0;
		Integer costCenterId = 0;
		Integer storeType = null;
		String departmentName = "";
		@SuppressWarnings("unused")
		String servicecenter="";
		String departmentCode = "";
		String modalityName = "";
		String deptDescription="";
		int departmentId = 0;
		String webPortalDisplay="";
		int empDeptId=0;
		Integer changedBy = null;
		departmentId = (Integer) generalMap.get("id");
		departmentCode = (String) generalMap.get("departmentCode");
		departmentName = (String) generalMap.get("name");
		modalityName = (String) generalMap.get("modalityName");
		deptDescription = (String) generalMap.get("deptDescription");
		departmentTypeId = (Integer) generalMap.get("departmentTypeId");
		costCenterId = (Integer) generalMap.get("costCenterId");
		storeType = (Integer) generalMap.get("storeType");
		changedBy = (Integer) generalMap.get("changedBy");
		empDeptId = (Integer) generalMap.get("empDeptId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		webPortalDisplay = (String) generalMap.get("webPortalDisplay");
		servicecenter=  (String) generalMap.get("servicecenter");
		String visitApplicable=(String)generalMap.get("visitApplicable");
		String payWard = (String)generalMap.get("payWard");
		
		MasDepartment masDepartment = (MasDepartment) getHibernateTemplate()
				.load(MasDepartment.class, departmentId);

		masDepartment.setId(departmentId);
		masDepartment.setDepartmentName(departmentName);
		masDepartment.setModalityName(modalityName);
		masDepartment.setDeptDescription(deptDescription);
		if(storeType!=null && storeType>0){
		MasDepartment masDept =new MasDepartment();
		masDept.setId(storeType);
		masDepartment.setStoreType(masDept);
		}
		MasDepartmentType masDepartmentType = new MasDepartmentType();
		masDepartmentType.setId(departmentTypeId);
		masDepartment.setDepartmentType(masDepartmentType);
		if(costCenterId!=0)
		{
		MasCostCenter masCostCenter = new MasCostCenter();
		masCostCenter.setId(costCenterId);
		masDepartment.setCostCenter(masCostCenter);
		}
		if(empDeptId!=0)
		{
		MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();
		masEmployeeDepartment.setId(empDeptId);
		masDepartment.setEmpDept(masEmployeeDepartment);
		}
		masDepartment.setServiceCenter(servicecenter);
		if(webPortalDisplay!="")
		{
			masDepartment.setWebPortalDisplay(webPortalDisplay);
		}
		Users users=new Users();
		users.setId(changedBy);
		masDepartment.setLastChgBy(users);
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		masDepartment.setStatus("Y");
		masDepartment.setVisitApplicable(visitApplicable);
		masDepartment.setPaywardCheck(payWard);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDepartment(String departmentCode,
			String departmentName) {
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		List departmentTypeList = null;
		List costCenterList = null;
		Map<String, Object> departmentFieldsMap = new HashMap<String, Object>(); 
		List<MasDepartment> storeTypeList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridStoreTypeList = new ArrayList<MasDepartment>();
		List gridCostCenterList = null;
		List gridEmpDeptList= null;
		List gridDepartmentTypeList = null;
		List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		Session session = (Session) getSession();
		try {
			if ((departmentName != null) || (departmentCode == null)) {

				searchDepartmentList =session.createCriteria(MasDepartment.class)
						.add(Restrictions.like("DepartmentName", departmentName+"%").ignoreCase()).add(Restrictions.eq("Status","Y").ignoreCase())
						.addOrder(Order.asc("DepartmentName")).list();
			} else {
				
				
				searchDepartmentList =session.createCriteria(MasDepartment.class)
						.add(Restrictions.like("DepartmentCode", departmentCode+"%").ignoreCase()).add(Restrictions.eq("Status","Y").ignoreCase())
						.addOrder(Order.asc("DepartmentCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		gridDepartmentTypeList = session.createCriteria(MasDepartmentType.class).list();
			
		departmentTypeList = session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Status","y").ignoreCase()).list();

		
		gridStoreTypeList = session.createCriteria(MasDepartment.class).list();
		storeTypeList = session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", 10)).add(Restrictions.eq("Status","y").ignoreCase()).list();

		gridCostCenterList = session.createCriteria(MasCostCenter.class).list();
		gridEmpDeptList= session.createCriteria(MasEmployeeDepartment.class).list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		masEmployeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.list();
		departmentFieldsMap.put("gridStoreTypeList",gridStoreTypeList);
		departmentFieldsMap.put("gridDepartmentTypeList",gridDepartmentTypeList);
		departmentFieldsMap.put("storeTypeList", storeTypeList);
		departmentFieldsMap.put("gridCostCenterList", gridCostCenterList);
		departmentFieldsMap.put("searchDepartmentList", searchDepartmentList);
		departmentFieldsMap.put("departmentTypeList", departmentTypeList);
		departmentFieldsMap.put("costCenterList", costCenterList);
		departmentFieldsMap.put("masEmployeeDepartmentList", masEmployeeDepartmentList);
		departmentFieldsMap.put("gridEmpDeptList", gridEmpDeptList);
		
		return departmentFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDepartmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		List<MasDepartmentType> departmentTypeList = new ArrayList<MasDepartmentType>();
		List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
		List<MasDepartmentType> gridDepartmentTypeList = new ArrayList<MasDepartmentType>();
		List<MasHospital> instituteList = new ArrayList<MasHospital>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		List<MasEmployeeDepartment> gridEmpDeptList = new ArrayList<MasEmployeeDepartment>();
		List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		List<Object[]> modalityList;
		Session session = (Session) getSession();

		departmentTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartmentType as isc where UPPER(isc.Status) = 'Y'");
		gridDepartmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartmentType as isc");

		gridEmpDeptList = session.createCriteria(MasEmployeeDepartment.class)
				.list();

		searchDepartmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		masEmployeeDepartmentList = session
				.createCriteria(MasEmployeeDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		gridDepartmentTypeList = session
				.createCriteria(MasDepartmentType.class).list();

		departmentTypeList = session.createCriteria(MasDepartmentType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		instituteList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		instituteDepartmentList = session
				.createCriteria(MasInstituteDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		mhospitalTypetList = session.createCriteria(MasHospitalType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		mdistrictList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("State", "State")
				.add(Restrictions.eq("State.Id", 32)).list();
		instituteList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital  as isc where UPPER(isc.Status) = 'Y'  order by HospitalName asc");
		instituteDepartmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasInstituteDepartment  as isc where UPPER(isc.Status) = 'Y' order by isc.Department.Id asc ");
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");

		modalityList = session
				.createCriteria(MasSubChargecode.class)
				.createAlias("MainChargecode", "mcc")
				.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB")
						.ignoreCase())
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("Id"))
								.add(Projections.property("SubChargecodeName")))
				.list();

		map.put("searchDepartmentList", searchDepartmentList);
		map.put("gridDepartmentTypeList", gridDepartmentTypeList);
		map.put("departmentTypeList", departmentTypeList);
		map.put("instituteList", instituteList);
		map.put("instituteDepartmentList", instituteDepartmentList);
		map.put("mhospitalTypetList", mhospitalTypetList);
		map.put("mdistrictList", mdistrictList);
		map.put("masEmployeeDepartmentList", masEmployeeDepartmentList);
		map.put("gridEmpDeptList", gridEmpDeptList);
		map.put("modalityList", modalityList);
		return map;
	}
	
	public Map<String, Object> showDepartInstiHierarchy(Map<String, Object> datamap) {
		

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
		List<MasHospital> instituteList = new ArrayList<MasHospital>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		List<MasEmployeeDepartment> gridEmpDeptList= new ArrayList<MasEmployeeDepartment>();
		List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		Session session = (Session) getSession();
		

		int userType =0;
		int loginUserId = 0;
		if (datamap.get("userType") != null) {
			userType = (Integer)datamap.get("userType");
		}
		if (datamap.get("userId") != null) {
			loginUserId =(Integer)datamap.get("userId");
		}
		
		mdistrictList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("State", "State").add(Restrictions.eq("State.Id", 32))
				.list();
		instituteList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospital  as isc where UPPER(isc.Status) = 'Y'  order by HospitalName asc");
		instituteDepartmentList	 = getHibernateTemplate().find("from jkt.hms.masters.business.MasInstituteDepartment  as isc where UPPER(isc.Status) = 'Y' order by isc.Department.Id asc ");
		mhospitalTypetList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' order by HospitalTypeName asc");
				

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
		
		
		map.put("searchDepartmentList", searchDepartmentList);
		map.put("instituteList", instituteList);
		map.put("instituteDepartmentList", instituteDepartmentList);
		map.put("mhospitalTypetList", mhospitalTypetList);
		map.put("mdistrictList", mdistrictList);
		map.put("masEmployeeDepartmentList", masEmployeeDepartmentList);
		map.put("gridEmpDeptList", gridEmpDeptList);
		return map;
	
	}

	public Map<String, Object> showLeaveJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		masLeaveList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasLeave ");
		hospitalList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasHospital as mh where mh.Status = 'y'");

		map.put("masLeaveList", masLeaveList);
		map.put("hospitalList", hospitalList);

		return map;
	}

	public Map<String, Object> addLeave(HrMasLeave hrMasLeave) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> existingDescriptionList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String description = hrMasLeave.getDescription();
		existingDescriptionList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasLeave as msc where msc.Description = '"
						+ description + "'");
		hospitalList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "y")).list();
		if (existingDescriptionList.size() > 0) {
			message = "Record already exist...";
		} else {
			hbt.save(hrMasLeave);
			message = "Record save successfully !!";
		}
		masLeaveList = session.createCriteria(HrMasLeave.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("masLeaveList", masLeaveList);
		map.put("existingDescriptionList", existingDescriptionList);
		map.put("hospitalList", hospitalList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> editLeave(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> existingDescriptionList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		int leaveId = 0;
		if (generalMap.get("leaveId") != null) {
			leaveId = (Integer) generalMap.get("leaveId");
		}
		int hospitalId = 0;
		if (generalMap.get("hospitalId") != null) {
			hospitalId = (Integer) generalMap.get("hospitalId");
		}
		String description = "";
		if (generalMap.get("description") != null) {
			description = (String) generalMap.get("description");
		}
		int changedBy = 0;
		if (generalMap.get("changedBy") != null) {
			changedBy = (Integer) generalMap.get("changedBy");
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
		HrMasLeave hrMasLeave = (HrMasLeave) hbt
				.load(HrMasLeave.class, leaveId);
		hrMasLeave.setDescription(description);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		hrMasLeave.setCompany(masHospital);

		hrMasLeave.setLastChgBy(changedBy);
		hrMasLeave.setLastChgDate(currentDate);
		hrMasLeave.setLastChgTime(currentTime);
		existingDescriptionList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasLeave as msc where msc.Description = '"
						+ description + "' and msc.Id != '" + leaveId + "'");
		masLeaveList = session.createCriteria(HrMasLeave.class)
				.add(Restrictions.eq("Status", "y")).list();
		hospitalList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "y")).list();
		String message = "";
		if (existingDescriptionList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.update(hrMasLeave);
			message = "Record update successfully !!";
		}

		map.put("masLeaveList", masLeaveList);
		map.put("existingDescriptionList", existingDescriptionList);
		map.put("hospitalList", hospitalList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> searchLeave(String description) {
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>();
		Map<String, Object> leaveFieldsMap = new HashMap<String, Object>();
		try {
			if ((description != null)) {

				masLeaveList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasLeave imc where imc.Description like '"
								+ description + "%' order by imc.Description");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		leaveFieldsMap.put("masLeaveList", masLeaveList);
		return leaveFieldsMap;
	}

	public Map<String, Object> deleteLeave(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> hospitalList = new ArrayList<HrMasLeave>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int leaveId = 0;
		if (generalMap.get("leaveId") != null) {
			leaveId = (Integer) generalMap.get("leaveId");
		}
		int changedBy = 0;
		if (generalMap.get("changedBy") != null) {
			changedBy = (Integer) generalMap.get("changedBy");
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
		HrMasLeave hrMasLeave = (HrMasLeave) hbt
				.load(HrMasLeave.class, leaveId);

		hrMasLeave.setLastChgBy(changedBy);
		hrMasLeave.setLastChgDate(currentDate);
		hrMasLeave.setLastChgTime(currentTime);
		hospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasHospital as isc where isc.Id='"
						+ leaveId + "' and isc.Status='y'");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrMasLeave.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrMasLeave.setStatus("y");
				dataDeleted = false;
			}
			hbt.update(hrMasLeave);
		}
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		masLeaveList = session.createCriteria(HrMasLeave.class).list();
		map.put("masLeaveList", masLeaveList);
		map.put("hospitalList", hospitalList);
		map.put("message", message);
		return map;
	}

	public boolean deleteDietCombination(int dietDietTypeId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		try {
			int userId = 0;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			MasDietCombination masDietCombination = new MasDietCombination();
			masDietCombination = (MasDietCombination) getHibernateTemplate()
					.get(MasDietCombination.class, dietDietTypeId);

			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masDietCombination.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masDietCombination.setStatus("y");
					dataDeleted = false;
				}
			}

			//masDietCombination.setLastChgBy(changedBy);
			Users users=new Users();
			users.setId(userId);
			masDietCombination.setLastChgBy(users);
			
			masDietCombination.setLastChgDate(currentDate);
			masDietCombination.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masDietCombination);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return dataDeleted;
	}

	@Override
	public Map<String, Object> showDeptMapJsp(Integer Inst_id) {
		Map<String,Object>  map=new HashMap<String,Object>();
		//List<MasDepartment>   departmentList = new ArrayList<MasDepartment>();
		//List<MasHospital>   hosList = new ArrayList<MasHospital>();;
		List<MasInstituteDepartment> deptMapList = new ArrayList<MasInstituteDepartment>();
		//List<MstrTask>   mstrTaskList = new ArrayList<MstrTask>();
		try {
		//	hosList  =getHibernateTemplate().find( "from jkt.hms.masters.business.MasHospital where UPPER(status) = 'Y'");
		//	departmentList  =getHibernateTemplate().find( "from jkt.hms.masters.business.MasDepartment where UPPER(status) = 'Y'");
			deptMapList =getHibernateTemplate().find( "from jkt.hms.masters.business.MasInstituteDepartment m where m.Status='y' and  m.Institute.Id = " + Inst_id);
			//mstrTaskList    =getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTask");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}  
		//map.put("hosList",hosList);
		//map.put("departmentList",departmentList);
		map.put("deptMapList",deptMapList);
		return map;
	}

	@Override
	public List<MasInstituteDepartment> getInstituteDeptMap(Map parameterMap) {
		Integer insti_id = (Integer)parameterMap.get("instiId");
		String status  = (String)parameterMap.get("status");
		List deptList  = new ArrayList();
		List<MasInstituteDepartment> midList= new ArrayList<MasInstituteDepartment>();
		deptList  = (List)parameterMap.get("deptList");
	    LOGGER.info(insti_id+"--"+deptList);
	    if(deptList != null){
	    	Criteria criteria =  getSession().createCriteria(MasInstituteDepartment.class)
										 .add(Restrictions.in("Department.Id", deptList))
										 .add(Restrictions.eq("Status", status))
										 .add(Restrictions.eq("Institute.Id", insti_id));
	    	midList = criteria.list();
	    }
		return midList;
	}

	@Override
	public boolean saveDeptMapDB(MasInstituteDepartment o) {
		
			boolean successfullyAdded=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate( o);
			hbt.flush();
			hbt.refresh( o);
			successfullyAdded = true;
			return successfullyAdded;
	}

	@Override
	public List<MasDepartment> getDeptMapFromDB(List duplicateToBeAssignedList) {
		Criteria criteria = getSession().createCriteria(MasDepartment.class)
				.add(Restrictions.in("Id", duplicateToBeAssignedList));
		return criteria.list();
	}

	@Override
	public Map<String, Object> fillInst(String val) {
		Map<String,Object>  map1=new HashMap<String,Object>();
		Session ses = getSession();
		Integer instId = Integer.parseInt(val);
		List<MasInstituteDepartment> insDeptList = ses.createCriteria(MasInstituteDepartment.class).add(Restrictions.eq("Institute.Id", instId)).list();
		List<MasDepartment> deptList = ses.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("DepartmentName")).list();
		List<MasDepartment> deptList1 = new ArrayList<MasDepartment>();
				
		for(MasDepartment md:deptList){
			int j=0;
			
			for(int i=0;i<insDeptList.size();i++){
				
				 
				if(md.getId()==insDeptList.get(i).getDepartment().getId() && insDeptList.get(i).getStatus().equalsIgnoreCase("y")){
					
					j++;
				}
			}
			if(j==0){
				deptList1.add(md);
			}
		}
		map1.put("deptList1", deptList1);
		return map1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showInstituteWiseServiceCentersDetailsJsp(Box box) {
		Map<String,Object>map=new HashMap<String,Object>();
		List<MasInstituteDepartment>instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
		List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
		List<MasDepartmentType>departmentTypeList = new ArrayList<MasDepartmentType>();
		List<MasOpdFrequency> frequencyList = new ArrayList<MasOpdFrequency>();
		List addDeptList = new ArrayList();
		List<MasDepartment>deptList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		instituteDepartmentList = session.createCriteria(MasInstituteDepartment.class).add(Restrictions.eq("Institute.Id", box.getInt("hospitalId")))
										.add(Restrictions.eq("Status", "y")).list();
		if(instituteDepartmentList.size()>0){
			for(MasInstituteDepartment instituteDepartment : instituteDepartmentList){
				addDeptList.add(instituteDepartment.getDepartment().getId());
			}
		}
		if(addDeptList.size() >0){
			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.not(Restrictions.in("Id", addDeptList))).add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("DepartmentName")).list();
		}
		
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
								.list();
		departmentTypeList = session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Status", "y").ignoreCase())
								.list();
		frequencyList = session.createCriteria(MasOpdFrequency.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("Id"))
				.list();
		map.put("frequencyList", frequencyList);
		map.put("deptList", deptList);
		map.put("departmentList", departmentList);
		map.put("departmentTypeList", departmentTypeList);
		map.put("instituteDepartmentList", instituteDepartmentList);
		map.put("hospitalId", box.getInt("hospitalId"));
		map.put("hospitalName", box.getString("hospitalName"));
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchInstituteWiseCenterDetails(Box box) {
		Map<String,Object>map=new HashMap<String,Object>();
		List<MasInstituteDepartment>instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
		List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment>deptList = new ArrayList<MasDepartment>();
		List<MasDepartmentType>departmentTypeList = new ArrayList<MasDepartmentType>();
		List<MasOpdFrequency> frequencyList = new ArrayList<MasOpdFrequency>();
		List addDeptList = new ArrayList();
		Session session = (Session)getSession();
		
		instituteDepartmentList = session.createCriteria(MasInstituteDepartment.class).createAlias("Department", "dept")
								.createAlias("dept.DepartmentType", "deptType").add(Restrictions.eq("deptType.Id", box.getInt("serviceCenterCategory")))
										.add(Restrictions.eq("Institute.Id", box.getInt("hospitalId")))
											.add(Restrictions.eq("Status", "y")).list();
		if(instituteDepartmentList.size()>0){
			for(MasInstituteDepartment instituteDepartment : instituteDepartmentList){
				addDeptList.add(instituteDepartment.getDepartment().getId());
			}
		}
		if(addDeptList.size() > 0)
			deptList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.not(Restrictions.in("Id", addDeptList))).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		else
			deptList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		departmentList = session.createCriteria(MasDepartment.class)
							.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		departmentTypeList = session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Status", "y").ignoreCase())
								.list();
		frequencyList = session.createCriteria(MasOpdFrequency.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("Id"))
				.list();
		map.put("frequencyList", frequencyList);
		map.put("departmentList", departmentList);
		map.put("departmentTypeList", departmentTypeList);
		map.put("instituteDepartmentList", instituteDepartmentList);
		map.put("hospitalId", box.getInt("hospitalId"));
		map.put("hospitalName", box.getString("hospitalName"));
		map.put("deptList",deptList);
		return map;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitInstituteWiseCenterDetails(Box box) {
		Map<String,Object>map=new HashMap<String,Object>();
		List<MasInstituteDepartment>instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
		List<MasDepartment>deptList = new ArrayList<MasDepartment>();
		List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
		List<MasDepartmentType>departmentTypeList = new ArrayList<MasDepartmentType>();
		List<MasOpdFrequency> frequencyList = new ArrayList<MasOpdFrequency>();
		List addDeptList = new ArrayList();
		Session session = (Session)getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		int count = 0;
		boolean flag = false;
		String message = "";
		if(box.getInt("hdb") != 0){
			count = (Integer)box.getInt("hdb");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction trx=session.beginTransaction();
		try{
		LOGGER.info("count "+count);
		List<MasOpdFrequency> freqList=new ArrayList<MasOpdFrequency>();
		freqList=session.createCriteria(MasOpdFrequency.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("Id"))
				.list();
		for (int i = 1; i <= count; i++) {
			String frequencyStr="",frequencyDays="";
			if (box.getString("roomNo" + i) != null) {
				
			if(box.getInt("instituteDepartmentId" + i) != 0){
				MasInstituteDepartment	masInstituteDepartment = (MasInstituteDepartment)hbt.load(MasInstituteDepartment.class,box.getInt("instituteDepartmentId" + i));
				masInstituteDepartment.setRoomNo(box.getString("roomNo" + i));
				if (box.getString("longitude" + i) != null) {
					masInstituteDepartment.setLongitude(box.getString("longitude" + i));
				}
				if (box.getString("latitude" + i) != null) {
					masInstituteDepartment.setLatitude(box.getString("latitude" + i));
				}
				if (box.getString("localName" + i) != null) {
					masInstituteDepartment.setAlternativeName(box.getString("localName" + i));
				}
				if (box.getString("opdTime" + i) != null) {
					masInstituteDepartment.setOpeningTime(box.getString("opdTime" + i));
				}
				if (box.getString("closingTime" + i) != null) {
					masInstituteDepartment.setClosingTime(box.getString("closingTime" + i));
				}
				
				if (box.getInt("avgNoOfPatients" + i) != 0) {
					masInstituteDepartment.setAvgNoOfPatients(box.getInt("avgNoOfPatients" + i));
				}
				/*LOGGER.info("frequencyId=in if=="+box.getInt("frequencyId" + i));
				if (box.getInt("frequencyId" + i) != 0) {
					MasOpdFrequency masOpdFrequency = new MasOpdFrequency();
					masOpdFrequency.setId(box.getInt("frequencyId" + i));
					masInstituteDepartment.setOpdFrequency(masOpdFrequency);
				}*/
				//added by govind 25-07-2017
				Vector frequency=new Vector();
				List<Integer> frequencyList1 = new ArrayList();
				if(box.get("frequencyId"+ i)!=null)
				{
					frequency =box.getVector("frequencyId"+ i); // new_list -----  added from form
				}
				//String frequencyStr="",frequencyDays="";
				for(int j = 0 ; j< frequency.size() ; j++)
				{					
					if(frequency.get(j)!=null){
						Integer fr=Integer.parseInt((String)frequency.get(j));
						for(MasOpdFrequency f:freqList){
							if(fr.equals(f.getId())){
								frequencyDays=getFrequencyDays(f.getFrequencyName(),frequencyDays,j);
								if(j==0){
									frequencyStr=frequencyStr+(String)frequency.get(j);
							     	}else{
							     		frequencyStr=frequencyStr+","+(String)frequency.get(j);
							     }
								break;
							}
						}
	                }
				}
				
				masInstituteDepartment.setFrequency(frequencyStr);
				//System.out.print("frequencyDays "+frequencyDays);
				masInstituteDepartment.setFrequencyDays(frequencyDays);
				//added by govind 25-07-2017
				
				hbt.update(masInstituteDepartment);
				hbt.refresh(masInstituteDepartment);
			}else{
				MasInstituteDepartment	masInstituteDepartment = new MasInstituteDepartment();
				if (box.getInt("serviceCenter" + i) != 0) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(box.getInt("serviceCenter" + i));
					masInstituteDepartment.setDepartment(masDepartment);
					
					masInstituteDepartment.setRoomNo(box.getString("roomNo" + i));
				//}
				if (box.getString("longitude" + i) != null) {
					masInstituteDepartment.setLongitude(box.getString("longitude" + i));
				}
				if (box.getString("latitude" + i) != null) {
					masInstituteDepartment.setLatitude(box.getString("latitude" + i));
				}
				if (box.getString("localName" + i) != null) {
					masInstituteDepartment.setAlternativeName(box.getString("localName" + i));
				}
				if (box.getString("opdTime" + i) != null) {
					masInstituteDepartment.setOpeningTime(box.getString("opdTime" + i));
				}
				if (box.getString("closingTime" + i) != null) {
					masInstituteDepartment.setClosingTime(box.getString("closingTime" + i));
				}
				/*LOGGER.info("frequencyId else==="+box.getInt("frequencyId" + i));
				if (box.getInt("frequencyId" + i) != 0) {
					MasOpdFrequency masOpdFrequency = new MasOpdFrequency();
					masOpdFrequency.setId(box.getInt("frequencyId" + i));
					masInstituteDepartment.setOpdFrequency(masOpdFrequency);
				}*/
				//added by govind 25-07-2017
				Vector frequency=new Vector();
				List<Integer> frequencyList1 = new ArrayList();
				if(box.get("frequencyId"+ i)!=null)
				{
					frequency =box.getVector("frequencyId"+ i); // new_list -----  added from form
				}
				
				//String frequencyStr="",frequencyDays="";
				for(int j = 0 ; j< frequency.size() ; j++)
				{  
                if(frequency.get(j)!=null){
					Integer fr=Integer.parseInt((String)frequency.get(j));
					for(MasOpdFrequency f:freqList){
						if(fr.equals(f.getId())){
							frequencyDays=getFrequencyDays(f.getFrequencyName(),frequencyDays,j);
							if(j==0){
								frequencyStr=frequencyStr+(String)frequency.get(j);
						     	}else{
						     		frequencyStr=frequencyStr+","+(String)frequency.get(j);
						     }
							break;
						}
					}
                }
				}
				masInstituteDepartment.setFrequency(frequencyStr);
				//System.out.print("frequencyDays "+frequencyDays);
				masInstituteDepartment.setFrequencyDays(frequencyDays);
				//added by govind 25-07-2017
				masInstituteDepartment.setStatus("y");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("hospitalId"));
				masInstituteDepartment.setInstitute(masHospital);
				masInstituteDepartment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
				Users users = new Users();
				users.setId(box.getInt("userId"));
				masInstituteDepartment.setLastChgBy(users);
				hbt.save(masInstituteDepartment);
				hbt.refresh(masInstituteDepartment);
			}
			}
		  }
		}
		trx.commit();
		flag = true;
		
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
	
		if (flag) {
			message = "Record Saved Successfully";
		} else {
			message = "Records Not Added/Updated!... Try Again.....";
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		instituteDepartmentList = session.createCriteria(MasInstituteDepartment.class).add(Restrictions.eq("Institute.Id", box.getInt("hospitalId")))
									.add(Restrictions.eq("Status", "y"))
									.addOrder(Order.asc("Id"))
									.list();
		if(instituteDepartmentList.size()>0){
			for(MasInstituteDepartment instituteDepartment : instituteDepartmentList){
				addDeptList.add(instituteDepartment.getDepartment().getId());
			}
		}
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		deptList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.not(Restrictions.in("Id", addDeptList))).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		departmentTypeList = session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		frequencyList = session.createCriteria(MasOpdFrequency.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("Id"))
				.list();
		map.put("frequencyList", frequencyList);
		map.put("departmentTypeList", departmentTypeList);
		map.put("message", message);
		map.put("departmentList", departmentList);
		map.put("instituteDepartmentList", instituteDepartmentList);
		map.put("hospitalId", box.getInt("hospitalId"));
		map.put("hospitalName", box.getString("hospitalName"));
		map.put("deptList",deptList);
		return map;
	}

	
	// ----------------------------------Version------------------------------------

		public boolean addVersion(MasApkVersion masVersion) {
			boolean saveFlag = false;
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masVersion);
				saveFlag = true;
				
				
				int versionId= masVersion.getId();
				
				String versionType=masVersion.getApkVersionType();
				
				List<MasApkVersion> searchVersionList = new ArrayList<MasApkVersion>();
				Session session = getSession();
				searchVersionList = session.createCriteria(MasApkVersion.class)
						.add(Restrictions.eq("ApkVersionType", versionType).ignoreCase())
						.list();
				
				for (MasApkVersion v : searchVersionList) {
					int id = v.getId();
			
					
					LOGGER.info(id+"id");
					LOGGER.info(versionId+"versionId");
					if(id==versionId)
					{
						v.setStatus("Y");
					}
					else{
						v.setStatus("N");
					}
					hbt.update(v);
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return saveFlag;
		}

		@SuppressWarnings("unchecked")
		public boolean deleteVersion(int versionId, Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasApkVersion masVersion = new MasApkVersion();
			masVersion = (MasApkVersion) getHibernateTemplate().load(MasApkVersion.class,
					versionId);
			int userId=0; 
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masVersion.setStatus("N");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masVersion.setStatus("Y");
					dataDeleted = false;
				}
			}
			
			Users users=new Users();
			users.setId(userId);
			masVersion.setLastChgBy(users);
			

			masVersion.setLastChgDate(currentDate);
			masVersion.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masVersion);
			return dataDeleted;
		}

		public boolean editVersion(Map<String, Object> generalMap) {

			boolean dataUpdated = false;

			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			int versionId = 0;
			String versionName = "";
			String versionCode = "";
			String changedBy = "";
			String apkVersionType="";
			try {
				versionId = (Integer) generalMap.get("id");
				versionCode = (String) generalMap.get("versionCode");
				versionName = (String) generalMap.get("name");
				changedBy = (String) generalMap.get("changedBy");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				apkVersionType= (String) generalMap.get("apkVersionType");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				MasApkVersion masVersion = (MasApkVersion) getHibernateTemplate().load(
						MasApkVersion.class, versionId);

				masVersion.setId(versionId);
				masVersion.setVersionName(versionName);

				
				Users users=new Users();
				users.setId(userId);
				masVersion.setLastChgBy(users);
				
						
				masVersion.setLastChgDate(currentDate);
				masVersion.setLastChgTime(currentTime);
				masVersion.setApkVersionType(apkVersionType);
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masVersion);
				dataUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dataUpdated;
		}

		public Map<String, Object> searchVersion(String versionCode,
				String versionName) {
			List searchVersionList = new ArrayList();
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				if ((versionName != null) || (versionCode == null)) {
					searchVersionList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasApkVersion sc where sc.VersionName like '"
									+ versionName + "%' order by sc.VersionName");
				} else if (versionCode != null) {
					searchVersionList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasApkVersion sc where sc.VersionCode like '"
									+ versionCode + "%' order by sc.VersionCode");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			map.put("searchVersionList", searchVersionList);
		
			return map;
		}

		
		public Map<String, Object> showVersion() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasApkVersion> searchVersionList = new ArrayList<MasApkVersion>();
			searchVersionList = getHibernateTemplate().find("from jkt.hms.masters.business.MasApkVersion as sc order by sc.VersionName");
		
			map.put("searchVersionList", searchVersionList);
		
			
			return map;
		}

		@Override
		public Map<String, Object> fillInstHospital(int districtId, int instType) {//added by govind 20-12-2016
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
		//added by govind 01-08-2017 in mas_institute_department Table for GetFrequency day 
		public static String getFrequencyDays(String frequencyName,String frequencyDays,int count){
			String days[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
			if(frequencyName.equalsIgnoreCase("24x7")){									
				for(int d=0;d<7;d++){									
					    if(d==0 && count==0){
						frequencyDays=frequencyDays+days[d];
				     	}else{
				     		frequencyDays=frequencyDays+","+days[d];
				        }
				 }
			}
			else if(frequencyName.equalsIgnoreCase("Everyday")){
				for(int d=0;d<7;d++){									
				    if(d==0 && count==0){
					frequencyDays=frequencyDays+days[d];
			     	}else{
			     		frequencyDays=frequencyDays+","+days[d];
			        }
			      }
			}
			else if(frequencyName.equalsIgnoreCase("Monday to Saturday")){
				for(int d=0;d<6;d++){									
				    if(d==0 && count==0){
					frequencyDays=frequencyDays+days[d];
			     	}else{
			     		frequencyDays=frequencyDays+","+days[d];
			        }
			      }
			}else{
				if(count==0){
					frequencyDays=frequencyDays+frequencyName;
				}else{
				    frequencyDays=frequencyDays+","+frequencyName;
				}
			}
		return frequencyDays;
		}

}
