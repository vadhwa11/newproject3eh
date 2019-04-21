package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import jkt.hms.masters.business.CssdInstrumentMaster;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.FaSchemeAccountMapping;
import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasEmpaneledHospital;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasSalesTaxType;
import jkt.hms.masters.business.MasSalesType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreBudgetT;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreItemDetails;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStoreOutItem;
import jkt.hms.masters.business.MasStorePharmaIndex;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierGroup;
import jkt.hms.masters.business.MasStoreSupplierType;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.MasStoreVendorWiseManufacturer;
import jkt.hms.masters.business.RouteOfAdministration;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PharmacyMasterDataServiceImpl extends HibernateDaoSupport
		implements PharmacyMasterDataService {

	/*
	 * Code for read from property file from src package
	 * Code By Mukesh Narayan SIngh
	 * Date 01 Oct 2010
	 */
	Properties properties = new Properties();{
	try{
				ClassLoader loader =getClass().getClassLoader();
				InputStream inStream = loader.getResourceAsStream("stores.properties");
		        properties.load(inStream);
		        }catch (IOException e) {
		    	//
		    	e.printStackTrace();
		       }
	}
	// ----------------------------------Item
	// Type-------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasItemType> searchItemTypeList = new ArrayList<MasItemType>();
		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
		Session session = (Session)getSession();
		searchItemTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasItemType");
		itemGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("searchItemTypeList", searchItemTypeList);
		map.put("itemGroupList", itemGroupList);
		return map;
	}

	public boolean addItemType(MasItemType masItemType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masItemType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteItemType(int itemTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasItemType masItemType = new MasItemType();
		masItemType = (MasItemType) getHibernateTemplate().load(
				MasItemType.class, itemTypeId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masItemType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masItemType.setStatus("y");
				dataDeleted = false;
			}
		}
		//masItemType.setLastChgBy(changedBy);
		Users users = new Users();
		users.setId(userId);
		masItemType.setLastChgBy(users);
		masItemType.setLastChgDate(currentDate);
		masItemType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masItemType);
		return dataDeleted;
	}

	public boolean editItemTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String itemTypeName = "";
		@SuppressWarnings("unused")
		String itemTypeCode = "";
		int itemTypeId = 0;
		int userId=0;
		int itemGroupId = 0;
		itemTypeId = (Integer) generalMap.get("id");
		itemTypeCode = (String) generalMap.get("itemTypeCode");
		itemTypeName = (String) generalMap.get("name");
		itemGroupId = (Integer) generalMap.get("itemGroupId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasItemType masItemType = (MasItemType) getHibernateTemplate().load(
				MasItemType.class, itemTypeId);
		masItemType.setId(itemTypeId);
		masItemType.setItemTypeName(itemTypeName);
		MasStoreGroup masStoreGroup = new MasStoreGroup();
		masStoreGroup.setId(itemGroupId);
		masItemType.setGroup(masStoreGroup);
		Users users = new Users();
		users.setId(userId);
		masItemType.setLastChgBy(users);
		masItemType.setLastChgDate(currentDate);
		masItemType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masItemType);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchItemType(String itemTypeCode,
			String itemTypeName) {
		List<MasItemType> searchItemTypeList = new ArrayList<MasItemType>();
		Map<String, Object> itemTypeFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();
		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
			
		try {
			if ((itemTypeName != null) || (itemTypeCode == null)) {
				searchItemTypeList =session.createCriteria(MasItemType.class).add(Restrictions.like("ItemTypeName","%"+itemTypeName+"%").ignoreCase()).addOrder(Order.asc("ItemTypeName")).list();
				
			} else {
				searchItemTypeList =session.createCriteria(MasItemType.class).add(Restrictions.like("ItemTypeCode","%"+itemTypeCode+"%").ignoreCase()).addOrder(Order.asc("ItemTypeCode")).list();
				
				
			}
			itemGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		itemTypeFieldsMap.put("searchItemTypeList", searchItemTypeList);
		itemTypeFieldsMap.put("itemGroupList", itemGroupList);
		return itemTypeFieldsMap;
	}

	// ------------------------------------Manufacturer---------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showManufacturerJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasManufacturer> searchManufacturerList = new ArrayList<MasManufacturer>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		//List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		//List<MasState> gridStateList = new ArrayList<MasState>();

		Session session = getSession();
		searchManufacturerList = session.createCriteria(MasManufacturer.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
//		gridDistrictList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
//		gridStateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
		stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		map.put("searchManufacturerList", searchManufacturerList);
		map.put("districtList", districtList);
		//map.put("gridDistrictList", gridDistrictList);
		map.put("stateList", stateList);
		//map.put("gridStateList", gridStateList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchManufacturer(String manufacturerCode,
			String manufacturerName) {
		List<MasManufacturer> searchManufacturerList = new ArrayList<MasManufacturer>();
		Map<String, Object> manufacturerFieldsMap = new HashMap<String, Object>();
		List<MasDistrict> districtList = null;
		List<MasDistrict> gridDistrictList = null;
		List<MasState> stateList = null;
		List<MasState> gridStateList = null;
		Session session = getSession();
		try {
			if ((manufacturerName != null) || (manufacturerCode == null)) {
							
				searchManufacturerList =session.createCriteria(MasManufacturer.class).add(Restrictions.like("ManufacturerName","%"+manufacturerName+"%").ignoreCase()).addOrder(Order.asc("ManufacturerName")).list();
			} else {
								
				searchManufacturerList =session.createCriteria(MasManufacturer.class).add(Restrictions.like("ManufacturerCode","%"+manufacturerCode+"%").ignoreCase()).addOrder(Order.asc("ManufacturerCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		gridDistrictList = session.createCriteria(MasDistrict.class).list();
		
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
		

		gridStateList = session.createCriteria(MasState.class).list();
			
		stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		manufacturerFieldsMap.put("districtList", districtList);
		manufacturerFieldsMap.put("gridDistrictList", gridDistrictList);
		manufacturerFieldsMap.put("stateList", stateList);
		manufacturerFieldsMap.put("gridStateList", gridStateList);
		manufacturerFieldsMap.put("searchManufacturerList",
				searchManufacturerList);
		return manufacturerFieldsMap;
	}

	public boolean addManufacturer(MasManufacturer masManufacturer) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masManufacturer);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editManufacturerToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String manufacturerName = "";
		@SuppressWarnings("unused")
		String manufacturerCode = "";
		int manufacturerId = 0;
		int userId = 0;
		String contactPerson = "";
		int cityId1 = 0;
		int cityId2 = 0;
		int cityId3 = 0;
		int stateId1 = 0;
		int stateId2 = 0;
		int stateId3 = 0;
		String mobileNo1 = "";
		int  mobileNo2 = 0;
		int mobileNo3 = 0;
		String emailId1 = "";
		String emailId2 = "";
		String emailId3 = "";
		//String faxNo = "";
		String url1 = "";
		String url2 = "";
		String url3 = "";
		String licenceNo1 = "";
		String licenceNo2 = "";
		String licenceNo3 = "";
		//String salesTaxNo = "";

		String cfDistributorName1 = "";
		String cfDistributorName2 = "";
		String cfDistributorName3 = "";
		String cfDistributorAddress1 = "";
		String cfDistributorAddress2 = "";
		String cfDistributorAddress3 = "";

		int pinCode1 = 0;
		int pinCode2 = 0;
		int pinCode3 = 0;
		int tinNo1 = 0;
		int tinNo2 = 0;
		int tinNo3 = 0;
		manufacturerId = (Integer) generalMap.get("id");
		manufacturerCode = (String) generalMap.get("manufacturerCode");
		manufacturerName = (String) generalMap.get("name");
		contactPerson = (String) generalMap.get("contactPerson");
		
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("cfDistributorName1") != null) {
			cfDistributorName1 = (String) generalMap.get("cfDistributorName1");
		}
		if (generalMap.get("cfDistributorName2") != null) {
			cfDistributorName2 = (String) generalMap.get("cfDistributorName2");
		}
		if (generalMap.get("cfDistributorName3") != null) {
			cfDistributorName3 = (String) generalMap.get("cfDistributorName3");
		}
		if (generalMap.get("cfDistributorAddress2") != null) {
			cfDistributorAddress2 = (String) generalMap
					.get("cfDistributorAddress2");
		}
		if (generalMap.get("cfDistributorAddress1") != null) {
			cfDistributorAddress1 = (String) generalMap
					.get("cfDistributorAddress1");
		}
		if (generalMap.get("cfDistributorAddress3") != null) {
			cfDistributorAddress3 = (String) generalMap
					.get("cfDistributorAddress3");
		}
		if(generalMap.get("cityId1") != null){
			cityId1 = (Integer) generalMap.get("cityId1");
		}
		if(generalMap.get("cityId2") != null){
			cityId2 = (Integer) generalMap.get("cityId2");
		}
		if(generalMap.get("cityId3") != null){
			cityId3 = (Integer) generalMap.get("cityId3");
		}
		if(generalMap.get("stateId1") != null){
			stateId1 = (Integer) generalMap.get("stateId1");
		}
		if(generalMap.get("stateId2") != null){
			stateId2 = (Integer) generalMap.get("stateId2");
		}
		if(generalMap.get("stateId3") != null){
			stateId3 = (Integer) generalMap.get("stateId3");
		}
		if(generalMap.get("pinCode1") != null){
			pinCode1 = (Integer) generalMap.get("pinCode1");
		}
		if(generalMap.get("pinCode2") != null){
			pinCode2 = (Integer) generalMap.get("pinCode2");
		}
		if(generalMap.get("pinCode3") != null){
			pinCode3 = (Integer) generalMap.get("pinCode3");
		}
		if(generalMap.get("mobileNo1") != null){
			mobileNo1 = (String) generalMap.get("mobileNo1");
		}
		if(generalMap.get("mobileNo2") != null){
			mobileNo2 = (Integer) generalMap.get("mobileNo2");
		}
		if(generalMap.get("mobileNo3") != null){
			mobileNo3 = (Integer) generalMap.get("mobileNo3");
		}
		if(generalMap.get("tinNo1") != null){
			tinNo1 = (Integer) generalMap.get("tinNo1");
		}
		if(generalMap.get("tinNo2") != null){
			tinNo2 = (Integer) generalMap.get("tinNo2");
		}
		if(generalMap.get("tinNo3") != null){
			tinNo3 = (Integer) generalMap.get("tinNo3");
		}
		if(generalMap.get("licenceNo1") != null){
			licenceNo1 = (String) generalMap.get("licenceNo1");
		}
		if(generalMap.get("licenceNo2") != null){
			licenceNo2 = (String) generalMap.get("licenceNo2");
		}
		if(generalMap.get("licenceNo3") != null){
			licenceNo3 = (String) generalMap.get("licenceNo3");
		}
		if(generalMap.get("emailId1") != null){
			emailId1 = (String) generalMap.get("emailId1");
		}
		if(generalMap.get("emailId2") != null){
			emailId2 = (String) generalMap.get("emailId2");
		}
		if(generalMap.get("emailId3") != null){
			emailId3 = (String) generalMap.get("emailId3");
		}
		if(generalMap.get("url1") != null){
			url1 = (String) generalMap.get("url1");
		}
		if(generalMap.get("url2") != null){
			url2 = (String) generalMap.get("url2");
		}
		if(generalMap.get("url3") != null){
			url3 = (String) generalMap.get("url3");
		}
		
		MasManufacturer masManufacturer = (MasManufacturer) getHibernateTemplate()
				.load(MasManufacturer.class, manufacturerId);

		masManufacturer.setId(manufacturerId);
		masManufacturer.setManufacturerName(manufacturerName);
		masManufacturer.setContactPerson(contactPerson);
	
		masManufacturer.setCfLocalDistributorName(cfDistributorName1);
		masManufacturer.setCfLocalDistributorAddress1(cfDistributorAddress1);
		if (cityId1 != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(cityId1);
			masManufacturer.setCity(masDistrict);
		}

		if (stateId1 != 0) {
			MasState masState = new MasState();
			masState.setId(stateId1);
			masManufacturer.setState(masState);
		}

		masManufacturer.setLicenceNo(licenceNo1);
		masManufacturer.setTinNo1(tinNo1);
		masManufacturer.setPinCode(pinCode1);
		masManufacturer.setMobileno(mobileNo1);
		masManufacturer.setEmailId(emailId1);
		masManufacturer.setUrl(url1);
		
		masManufacturer.setCfLocalDistributorName2(cfDistributorName2);
		masManufacturer.setCfLocalDistributorAddress2(cfDistributorAddress2);
		if (cityId2 != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(cityId2);
			masManufacturer.setDistrict2(masDistrict);
		}

		if (stateId2 != 0) {
			MasState masState = new MasState();
			masState.setId(stateId2);
			masManufacturer.setState2(masState);
		}

		masManufacturer.setLicenceNo2(licenceNo2);
		masManufacturer.setTinNo2(tinNo2);
		masManufacturer.setPinCode2(pinCode2);
		masManufacturer.setMobileno2(mobileNo2);
		masManufacturer.setEmailId2(emailId2);
		masManufacturer.setUrl2(url2);
		
		masManufacturer.setCfLocalDistributorName3(cfDistributorName3);
		masManufacturer.setCfLocalDistributorAddress3(cfDistributorAddress3);
		if (cityId3 != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(cityId3);
			masManufacturer.setDistrict3(masDistrict);
		}

		if (stateId3 != 0) {
			MasState masState = new MasState();
			masState.setId(stateId3);
			masManufacturer.setState3(masState);
		}

		masManufacturer.setLicenceNo3(licenceNo3);
		masManufacturer.setTinNo3(tinNo3);
		masManufacturer.setPinCode3(pinCode3);
		masManufacturer.setMobileno3(mobileNo3);
		masManufacturer.setEmailId3(emailId3);
		masManufacturer.setUrl3(url3);

		Users users = new Users();
		users.setId(userId);
		masManufacturer.setLastChgBy(users);
		
		masManufacturer.setLastChgDate(currentDate);
		masManufacturer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masManufacturer);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteManufacturer(int manufacturerId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasManufacturer masManufacturer = new MasManufacturer();
		masManufacturer = (MasManufacturer) getHibernateTemplate().load(
				MasManufacturer.class, manufacturerId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masManufacturer.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masManufacturer.setStatus("y");
				dataDeleted = false;
			}
		}
		
		Users users = new Users();
		users.setId(userId);
		masManufacturer.setLastChgBy(users);
		
		
		masManufacturer.setLastChgDate(currentDate);
		masManufacturer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masManufacturer);
		return dataDeleted;
	}

	// --------------------------------------- Supplier
	// -------------------------------------

	public boolean addStoreSupplier(MasStoreSupplier masStoreSupplier,
			Map<String, Object> generalMap) {

		boolean successfullyAdded = false;
		MasManufacturer masManufacturer = new MasManufacturer();
		Date currentDate = new Date();
		String currentTime = "";

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreSupplier);
		hbt.refresh(masStoreSupplier);

		int supplierId = masStoreSupplier.getId();
		String manufacturerStr = "";
		String groupStr = "";
		int userId = (Integer) generalMap.get("userId");
		if (generalMap.get("manufacturerStr") != null) {
			manufacturerStr = (String) generalMap.get("manufacturerStr");
		}
		if (generalMap.get("groupStr") != null) {
			groupStr = (String) generalMap.get("groupStr");
		}

		if (generalMap.get("masManufacturer") != null) {
			masManufacturer = (MasManufacturer) generalMap
					.get("masManufacturer");
			hbt.save(masManufacturer);
			hbt.refresh(masManufacturer);
		}

		Users user= new Users();
		user.setId(userId);
		masStoreSupplier.setLastChgBy(user);	
		
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		StringTokenizer str = new StringTokenizer(manufacturerStr, ",");
		StringTokenizer strForGroup = new StringTokenizer(groupStr, ",");
		
		while (str.hasMoreTokens()) {
			MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = new MasStoreVendorWiseManufacturer();

			int manufacturerId = Integer.parseInt(str.nextToken());
			MasManufacturer masManufacturer1 = new MasManufacturer();
			masManufacturer1.setId(manufacturerId);
			masStoreVendorWiseManufacturer.setManufacturer(masManufacturer1);

			
			//MasStoreSupplier masSupplier = new MasStoreSupplier();
			//masSupplier.setId(supplierId);
			
			masStoreVendorWiseManufacturer.setSupplier(masStoreSupplier);
	

			masStoreVendorWiseManufacturer.setLastChgBy(user);
			
			
			masStoreVendorWiseManufacturer.setLastChgDate(currentDate);
			masStoreVendorWiseManufacturer.setLastChgTime(currentTime);
			masStoreVendorWiseManufacturer.setStatus("y");
			hbt.save(masStoreVendorWiseManufacturer);
		//	hbt.refresh(masStoreVendorWiseManufacturer);

		}

		while (strForGroup.hasMoreTokens()) {
			MasStoreSupplierGroup masStoreSupplierGroup = new MasStoreSupplierGroup();

			int groupId = Integer.parseInt(strForGroup.nextToken());
			MasStoreGroup group = new MasStoreGroup();
			group.setId(groupId);
			masStoreSupplierGroup.setGroup(group);

			MasStoreSupplier masSupplier = new MasStoreSupplier();
			masSupplier.setId(supplierId);
			masStoreSupplierGroup.setSupplier(masSupplier);

			hbt.save(masStoreSupplierGroup);
			hbt.refresh(masStoreSupplierGroup);
		}

		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public boolean deleteStoreSupplier(Integer storeSupplierId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
		masStoreSupplier = (MasStoreSupplier) getHibernateTemplate().load(
				MasStoreSupplier.class, storeSupplierId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Integer storeSupplieTypeId = masStoreSupplier.getSupplierType().getId();

		if (generalMap.get("flag") != null) {
			List storeSupplierList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSupplierType as mit where mit.Id='"
							+ storeSupplieTypeId + "' and mit.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreSupplier.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreSupplier.setStatus("y");
				dataDeleted = false;
			}
		}
		
		Users user= new Users();
		user.setId(userId);
		masStoreSupplier.setLastChgBy(user);
		
		masStoreSupplier.setLastChgDate(currentDate);
		masStoreSupplier.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSupplier);
		return dataDeleted;
	}

	public boolean editStoreSupplierToDatabase(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		int storeSupplierId = 0;
		int storeSupplierTypeId = 0;
		String storeSupplierCode = "";
		String storeSupplierName = "";
		String pinNo = "";
		String tinNo = "";
		String licenceNo = "";
		String salesTaxNo = "";
		String typeOfReg = "";
		String address1 = "";
		String address2 = "";
		int city = 0;
		int state = 0;
		String phoneNo = "";
		String mobileNo = "";
		String pinCode = "";
		String emailId = "";
		String faxNo = "";
		String url = "";
		String localAddress1 = "";
		String localAddress2 = "";
		int localCity = 0;
		String localPhoneNo = "";
		String localPinCode = "";
		int localState = 0;
		int userId=0;
		String cfDistributorName = "";
		String cfDistributorAddress1 = "";
		String cfDistributorAddress2 = "";
		String fdrReceiptAttached = "";

		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";

		String manufacturerStr = "";
		String groupStr = "";

		if (generalMap.get("manufacturerStr") != null) {
			manufacturerStr = (String) generalMap.get("manufacturerStr");
		}

		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		if (generalMap.get("groupStr") != null) {
			groupStr = (String) generalMap.get("groupStr");
		}
		StringTokenizer str = new StringTokenizer(manufacturerStr, ",");
		StringTokenizer strForGroup = new StringTokenizer(groupStr, ",");

		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			storeSupplierId = (Integer) generalMap.get("id");
			storeSupplierTypeId = (Integer) generalMap
					.get("storeSupplierTypeId");
			storeSupplierCode = (String) generalMap.get("code");
			storeSupplierName = (String) generalMap.get("name");
			address1 = (String) generalMap.get("address1");
			address2 = (String) generalMap.get("address2");
			city = (Integer) generalMap.get("city");
			state = (Integer) generalMap.get("state");
			faxNo = (String) generalMap.get("faxNo");
			url = (String) generalMap.get("url");
			phoneNo = (String) generalMap.get("phoneNo");
			mobileNo = (String) generalMap.get("mobileNo");
			pinCode = (String) generalMap.get("pinCode");
			emailId = (String) generalMap.get("emailId");

			localAddress1 = (String) generalMap.get("localAddress1");
			localAddress2 = (String) generalMap.get("localAddress2");
			localCity = (Integer) generalMap.get("localCity");
			localState = (Integer) generalMap.get("localState");

			localPinCode = (String) generalMap.get("localPinCode");
			localPhoneNo = (String) generalMap.get("localPhoneNo");

			cfDistributorName = (String) generalMap.get("cfDistributorName");
			cfDistributorAddress1 = (String) generalMap
					.get("cfDistributorAddress1");
			cfDistributorAddress2 = (String) generalMap
					.get("cfDistributorAddress2");
			fdrReceiptAttached = (String) generalMap.get("fdrReceiptAttached");

			salesTaxNo = (String) generalMap.get("salesTaxNo");
			typeOfReg = (String) generalMap.get("typeOfReg");
			licenceNo = (String) generalMap.get("licenceNo");
			tinNo = (String) generalMap.get("tinNo");
			pinNo = (String) generalMap.get("pinNo");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			List<MasStoreSupplierGroup> groupListBySupplier = hbt
					.find("from jkt.hms.masters.business.MasStoreSupplierGroup as inp where inp.Supplier.Id = "
							+ storeSupplierId);

			for (MasStoreSupplierGroup masStoreSupplierGroup : groupListBySupplier) {
				int id = masStoreSupplierGroup.getId();
				String hql = "delete from jkt.hms.masters.business.MasStoreSupplierGroup as a where a.Id = "
						+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			List<MasStoreVendorWiseManufacturer> manufacturerListBySupplier = hbt
					.find("from jkt.hms.masters.business.MasStoreVendorWiseManufacturer as inp where inp.Supplier.Id = "
							+ storeSupplierId);

			for (MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer : manufacturerListBySupplier) {
				int id = masStoreVendorWiseManufacturer.getId();
				String hql = "delete from jkt.hms.masters.business.MasStoreVendorWiseManufacturer as a where a.Id = "
						+ id;
				Query query = session.createQuery(hql);
				int row = query.executeUpdate();
			}

			while (str.hasMoreTokens()) {
				MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = new MasStoreVendorWiseManufacturer();

				int manufacturerId = Integer.parseInt(str.nextToken());

				MasManufacturer masManufacturer = new MasManufacturer();
				masManufacturer.setId(manufacturerId);
				masStoreVendorWiseManufacturer.setManufacturer(masManufacturer);

				MasStoreSupplier masSupplier = new MasStoreSupplier();
				masSupplier.setId(storeSupplierId);
				masStoreVendorWiseManufacturer.setSupplier(masSupplier);
				
				Users users = new Users();
				users.setId(userId);
				masStoreVendorWiseManufacturer.setLastChgBy(users);
				
				masStoreVendorWiseManufacturer.setLastChgDate(currentDate);
				masStoreVendorWiseManufacturer.setLastChgTime(currentTime);
				masStoreVendorWiseManufacturer.setStatus("y");
				hbt.save(masStoreVendorWiseManufacturer);
			}

			while (strForGroup.hasMoreTokens()) {
				MasStoreSupplierGroup masStoreSupplierGroup = new MasStoreSupplierGroup();

				int groupId = Integer.parseInt(strForGroup.nextToken());
				MasStoreGroup group = new MasStoreGroup();
				group.setId(groupId);
				masStoreSupplierGroup.setGroup(group);

				MasStoreSupplier masSupplier = new MasStoreSupplier();
				masSupplier.setId(storeSupplierId);
				masStoreSupplierGroup.setSupplier(masSupplier);

				hbt.save(masStoreSupplierGroup);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			MasStoreSupplier masStoreSupplier = (MasStoreSupplier) getHibernateTemplate()
					.load(MasStoreSupplier.class, storeSupplierId);

			masStoreSupplier.setId(storeSupplierId);
			masStoreSupplier.setSupplierName(storeSupplierName);

			MasStoreSupplierType masStoreSupplierType = new MasStoreSupplierType();
			masStoreSupplierType.setId(storeSupplierTypeId);
			masStoreSupplier.setSupplierType(masStoreSupplierType);

			masStoreSupplier.setTinNo(tinNo);
			masStoreSupplier.setSalesTaxNo(salesTaxNo);
			masStoreSupplier.setTypeOfReg(typeOfReg);
			masStoreSupplier.setLicenceNo(licenceNo);
			masStoreSupplier.setPinNo(pinNo);

			masStoreSupplier.setAddress1(address1);
			masStoreSupplier.setAddress2(address2);

			if (city != 0) {
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(city);
				masStoreSupplier.setCity(masDistrict);
			} else {
				masStoreSupplier.setCity(null);
			}

			if (state != 0) {
				MasState masState = new MasState();
				masState.setId(state);
				masStoreSupplier.setState(masState);
			} else {
				masStoreSupplier.setState(null);
			}

			masStoreSupplier.setFaxNumber(faxNo);
			masStoreSupplier.setPhoneNo(phoneNo);
			masStoreSupplier.setMobileNo(mobileNo);
			if(!pinCode.equals(""))
			{
			masStoreSupplier.setPinCode(Integer.parseInt(pinCode));
			}
			masStoreSupplier.setEmailId(emailId);
			masStoreSupplier.setUrl(url);
			masStoreSupplier.setLocalAddress1(localAddress1);
			masStoreSupplier.setLocalAddress2(localAddress2);

			if (localCity != 0) {
				MasDistrict masDistrictLocal = new MasDistrict();
				masDistrictLocal.setId(localCity);
				masStoreSupplier.setLocalCity(masDistrictLocal);
			} else {
				masStoreSupplier.setLocalCity(null);
			}

			if (localState != 0) {
				MasState masStateLocal = new MasState();
				masStateLocal.setId(localState);
				masStoreSupplier.setLocalState(masStateLocal);
			} else {
				masStoreSupplier.setLocalState(null);
			}
           if(!localPinCode.equals("")){
			masStoreSupplier.setLocalPinCode(Integer.parseInt(localPinCode));}
			masStoreSupplier.setLocalPhoneNo(localPhoneNo);

			masStoreSupplier.setCfLocalDistributorName(cfDistributorName);
			masStoreSupplier
					.setCfLocalDistributorAddress1(cfDistributorAddress1);
			masStoreSupplier
					.setCfLocalDistributorAddress2(cfDistributorAddress2);
			masStoreSupplier.setFdrReceiptAttached(fdrReceiptAttached);

			Users user= new Users();
			user.setId(userId);
			masStoreSupplier.setLastChgBy(user);
			
			masStoreSupplier.setLastChgDate(currentDate);
			masStoreSupplier.setLastChgTime(currentTime);

			hbt.update(masStoreSupplier);

			/*
			 * If supplier type is Manufacturer, then the same record will be
			 * stored in Mas Manufacturer table also apart from
			 * mas_store_Supplier.
			 */

			if (storeSupplierTypeId == 2) {
				List masManfList = new ArrayList<MasManufacturer>();
				masManfList = session
						.createCriteria(MasManufacturer.class)
						.add(Restrictions.eq("ManufacturerCode",
								storeSupplierCode)).list();
				if (masManfList != null && masManfList.size() > 0) {
					MasManufacturer masManufacturer = (MasManufacturer) masManfList
							.get(0);
					masManufacturer.setSalesTaxNo(salesTaxNo);
					masManufacturer.setLicenceNo(licenceNo);
					masManufacturer.setAddress1(address1);
					masManufacturer.setAddress2(address2);
					masManufacturer
							.setCfLocalDistributorName(cfDistributorName);
					masManufacturer
							.setCfLocalDistributorAddress1(cfDistributorAddress1);
					masManufacturer
							.setCfLocalDistributorAddress2(cfDistributorAddress2);

					if (city != 0) {
						MasDistrict masDistrict = new MasDistrict();
						masDistrict.setId(city);
						masStoreSupplier.setCity(masDistrict);
						masManufacturer.setCity(masDistrict);
					} else {
						masStoreSupplier.setCity(null);
						masManufacturer.setCity(null);
					}

					if (state != 0) {
						MasState masState = new MasState();
						masState.setId(state);
						masStoreSupplier.setState(masState);
						masManufacturer.setState(masState);
					} else {
						masStoreSupplier.setState(null);
						masManufacturer.setState(null);
					}

					masManufacturer.setFaxNumber(faxNo);

					masManufacturer.setPhoneno(phoneNo);

					masManufacturer.setMobileno(mobileNo);
					masManufacturer.setPinCode(Integer.parseInt(pinCode));
					masManufacturer.setEmailId(emailId);
					masManufacturer.setUrl(url);
					
					Users users = new Users();
					users.setId(userId);
					masManufacturer.setLastChgBy(users);
					
					
					masManufacturer.setLastChgDate(currentDate);
					masManufacturer.setLastChgTime(currentTime);
					hbt.update(masManufacturer);
				}
			}
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStoreSupplierJsp() {
		List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();

		List<MasStoreSupplierType> masStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();
		List<MasStoreSupplierType> gridStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();

		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<MasStoreGroup> gridMasStoreGroupList = new ArrayList<MasStoreGroup>();

		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<MasManufacturer> gridManufacturerList = new ArrayList<MasManufacturer>();

		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasState> gridStateList = new ArrayList<MasState>();

		List<MasDistrict> localDistrictList = new ArrayList<MasDistrict>();
		List<MasDistrict> gridLocalDistrictList = new ArrayList<MasDistrict>();
		List<MasState> localStateList = new ArrayList<MasState>();
		List<MasState> gridLocalStateList = new ArrayList<MasState>();
		List<MasStoreSupplierGroup> masStoreSupplierGroupList = new ArrayList<MasStoreSupplierGroup>();
		List<MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();
		Session session = (Session) getSession();
		Map map = new HashMap();
		try {

			
			gridDistrictList = session.createCriteria(MasDistrict.class).list();
			
			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
			

			gridStateList = session.createCriteria(MasState.class).list();
				
			stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
			
			gridLocalDistrictList = session.createCriteria(MasDistrict.class).list();
			
			localDistrictList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
			
			gridLocalStateList = session.createCriteria(MasState.class).list();
			
			localStateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
			
		
			masStoreSupplierList = session.createCriteria(MasStoreSupplier.class).list();
			
			gridStoreSupplierTypeList = session.createCriteria(MasStoreSupplierType.class).list();
			
			masStoreSupplierTypeList = session.createCriteria(MasStoreSupplierType.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
			
			
			gridManufacturerList = session.createCriteria(MasManufacturer.class).list();
			
			manufacturerList = session.createCriteria(MasManufacturer.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
			
			
			gridMasStoreGroupList = session.createCriteria(MasStoreGroup.class).list();
			
			masStoreGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
			masStoreSupplierGroupList = session.createCriteria(MasStoreSupplierGroup.class).list();
			
			masStoreVendorWiseManufacturerList = session.createCriteria(MasStoreVendorWiseManufacturer.class).list();


			map.put("districtList", districtList);
			map.put("gridDistrictList", gridDistrictList);
			map.put("stateList", stateList);
			map.put("gridStateList", gridStateList);
			map.put("gridLocalStateList", gridLocalStateList);
			map.put("localStateList", localStateList);
			map.put("gridLocalDistrictList", gridLocalDistrictList);
			map.put("localDistrictList", localDistrictList);
			map.put("masStoreSupplierList", masStoreSupplierList);
			map.put("masStoreSupplierTypeList", masStoreSupplierTypeList);
			map.put("gridStoreSupplierTypeList", gridStoreSupplierTypeList);
			map.put("manufacturerList", manufacturerList);
			map.put("gridManufacturerList", gridManufacturerList);

			map.put("masStoreGroupList", masStoreGroupList);
			map.put("gridMasStoreGroupList", gridMasStoreGroupList);
			map.put("masStoreSupplierGroupList", masStoreSupplierGroupList);
			map.put("masStoreVendorWiseManufacturerList",
					masStoreVendorWiseManufacturerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map searchStoreSupplier(String storeSupplierCode,
			String storeSupplierName) {
		List masStoreSupplierList = new ArrayList();
		List masStoreSupplierTypeList = new ArrayList();
		List<MasManufacturer> manufacturerList = null;
		List<MasManufacturer> gridManufacturerList = null;

		List<MasDistrict> districtList = null;
		List<MasDistrict> gridDistrictList = null;
		List<MasState> stateList = null;
		List<MasState> gridStateList = null;
		Session session = (Session) getSession();
		List<MasDistrict> localDistrictList = null;
		List<MasDistrict> gridLocalDistrictList = null;
		List<MasState> localStateList = null;
		List<MasState> gridLocalStateList = null;
		Map map = new HashMap();
		List gridStoreSupplierTypeList = new ArrayList();

		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<MasStoreGroup> gridMasStoreGroupList = new ArrayList<MasStoreGroup>();

		List<MasStoreSupplierGroup> masStoreSupplierGroupList = new ArrayList<MasStoreSupplierGroup>();
		List<MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();

		try {
			if ((storeSupplierName != null) || (storeSupplierCode == null)) {
							
				masStoreSupplierList =session.createCriteria(MasStoreSupplier.class).add(Restrictions.like("SupplierName", storeSupplierName).ignoreCase()).addOrder(Order.asc("SupplierName")).list();

			} else {
			
				
				masStoreSupplierList =session.createCriteria(MasStoreSupplier.class).add(Restrictions.like("SupplierCode", storeSupplierCode).ignoreCase()).addOrder(Order.asc("SupplierCode")).list();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		gridDistrictList = session.createCriteria(MasDistrict.class).list();
		
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
		gridStateList = session.createCriteria(MasState.class).list();
			
		stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		gridLocalDistrictList = session.createCriteria(MasDistrict.class).list();
		
		localDistrictList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		gridLocalStateList = session.createCriteria(MasState.class).list();
		
		localStateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
	
		masStoreSupplierList = session.createCriteria(MasStoreSupplier.class).list();
		
		gridStoreSupplierTypeList = session.createCriteria(MasStoreSupplierType.class).list();
		
		masStoreSupplierTypeList = session.createCriteria(MasStoreSupplierType.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		
		gridManufacturerList = session.createCriteria(MasManufacturer.class).list();
		
		manufacturerList = session.createCriteria(MasManufacturer.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		
		gridMasStoreGroupList = session.createCriteria(MasStoreGroup.class).list();
		
		masStoreGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.eq("Status","y").ignoreCase()).list();

		masStoreSupplierGroupList = session.createCriteria(MasStoreSupplierGroup.class).list();
		
		masStoreVendorWiseManufacturerList = session.createCriteria(MasStoreVendorWiseManufacturer.class).list();


		map.put("districtList", districtList);
		map.put("gridDistrictList", gridDistrictList);
		map.put("stateList", stateList);
		map.put("gridStateList", gridStateList);
		map.put("gridLocalStateList", gridLocalStateList);
		map.put("localStateList", localStateList);
		map.put("gridLocalDistrictList", gridLocalDistrictList);
		map.put("localDistrictList", localDistrictList);
		map.put("manufacturerList", manufacturerList);
		map.put("gridManufacturerList", gridManufacturerList);
		map.put("masStoreSupplierList", masStoreSupplierList);
		map.put("masStoreSupplierTypeList", masStoreSupplierTypeList);
		map.put("gridStoreSupplierTypeList", gridStoreSupplierTypeList);

		map.put("masStoreGroupList", masStoreGroupList);
		map.put("gridMasStoreGroupList", gridMasStoreGroupList);
		map.put("masStoreSupplierGroupList", masStoreSupplierGroupList);
		map.put("masStoreVendorWiseManufacturerList",
				masStoreVendorWiseManufacturerList);

		return map;
	}

	// ------------------------------ Supplier Type ---------------------

	public boolean addStoreSupplierType(
			MasStoreSupplierType masStoreSupplierType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreSupplierType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchStoreSupplierType(
			String storeSupplierTypeCode, String storeSupplierTypeName) {
		Session session = (Session) getSession();
		List<MasStoreSupplierType> searchStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();
		Map<String, Object> storeSupplierTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((storeSupplierTypeName != null)
					|| (storeSupplierTypeCode == null)) {
				/*searchStoreSupplierTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreSupplierType imc where imc.SupplierTypeName like '"
								+ storeSupplierTypeName
								+ "%' order by imc.SupplierTypeName");*/
				
				searchStoreSupplierTypeList =session.createCriteria(MasStoreSupplierType.class).add(Restrictions.like("SupplierTypeName","%"+storeSupplierTypeName+"%").ignoreCase()).addOrder(Order.asc("SupplierTypeName")).list();
				
				
				
			} else {
			/*	searchStoreSupplierTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreSupplierType imc where imc.SupplierTypeCode like '"
								+ storeSupplierTypeCode
								+ "%' order by imc.SupplierTypeCode");*/
				
				searchStoreSupplierTypeList =session.createCriteria(MasStoreSupplierType.class).add(Restrictions.like("SupplierTypeCode","%"+storeSupplierTypeCode+"%").ignoreCase()).addOrder(Order.asc("SupplierTypeCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		storeSupplierTypeFieldsMap.put("searchStoreSupplierTypeList",searchStoreSupplierTypeList);
		return storeSupplierTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStoreSupplierTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplierType> searchStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();
		searchStoreSupplierTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreSupplierType ");
		map.put("searchStoreSupplierTypeList", searchStoreSupplierTypeList);
		return map;
	}

	public boolean editStoreSupplierTypeToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String storeSupplierTypeName = "";
		@SuppressWarnings("unused")
		String storeSupplierTypeCode = "";
		int storeSupplierTypeId = 0;
		int userId = 0;
		storeSupplierTypeId = (Integer) generalMap.get("id");
		storeSupplierTypeCode = (String) generalMap
				.get("storeSupplierTypeCode");
		storeSupplierTypeName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreSupplierType masStoreSupplierType = (MasStoreSupplierType) getHibernateTemplate()
				.load(MasStoreSupplierType.class, storeSupplierTypeId);

		masStoreSupplierType.setId(storeSupplierTypeId);
		masStoreSupplierType.setSupplierTypeName(storeSupplierTypeName);
		Users users = new Users();
		users.setId(userId);
		masStoreSupplierType.setLastChgBy(users);

		masStoreSupplierType.setLastChgDate(currentDate);
		masStoreSupplierType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSupplierType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteStoreSupplierType(int storeSupplierTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreSupplierType masStoreSupplierType = new MasStoreSupplierType();
		masStoreSupplierType = (MasStoreSupplierType) getHibernateTemplate()
				.load(MasStoreSupplierType.class, storeSupplierTypeId);
		userId = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreSupplierType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreSupplierType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masStoreSupplierType.setLastChgBy(users);
		masStoreSupplierType.setLastChgDate(currentDate);
		masStoreSupplierType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSupplierType);
		return dataDeleted;
	}

	// ---------------------------------- Item
	// Category-------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<MasItemCategory> searchItemCategoryList = new ArrayList<MasItemCategory>();
			List<MasItemType> sectionList = new ArrayList<MasItemType>();
			List<MasItemType> gridSectionList = new ArrayList<MasItemType>();
			Session session = (Session) getSession();
			searchItemCategoryList = session.createCriteria(MasItemCategory.class).list();
			sectionList = session.createCriteria(MasStoreSection.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
			gridSectionList = session.createCriteria(MasStoreSection.class).list();
			map.put("searchItemCategoryList", searchItemCategoryList);
			map.put("sectionList", sectionList);
			map.put("gridSectionList", gridSectionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean addItemCategory(MasItemCategory masItemCategory) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masItemCategory);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteItemCategory(int itemCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId = 0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasItemCategory masItemCategory = new MasItemCategory();
			masItemCategory = (MasItemCategory) getHibernateTemplate().load(
					MasItemCategory.class, itemCategoryId);
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			if (generalMap.get("flag") != null) {

				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masItemCategory.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masItemCategory.setStatus("y");
					dataDeleted = false;
				}
			}
		
			Users users = new Users();
			users.setId(userId);
			masItemCategory.setLastChgBy(users);
			
			masItemCategory.setLastChgDate(currentDate);
			masItemCategory.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masItemCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public boolean editItemCategoryToDatabase(Map<String, Object> generalMap) {
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
		int itemTypeId = 0;
		int userId = 0;
		itemCategoryId = (Integer) generalMap.get("id");
		itemCategoryCode = (String) generalMap.get("itemCategoryCode");
		itemCategoryName = (String) generalMap.get("name");
		itemTypeId = (Integer) generalMap.get("itemTypeId");
		sectionId = (Integer) generalMap.get("sectionId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasItemCategory masItemCategory = (MasItemCategory) getHibernateTemplate()
				.load(MasItemCategory.class, itemCategoryId);

		masItemCategory.setId(itemCategoryId);
		masItemCategory.setItemCategoryName(itemCategoryName);
		if (itemTypeId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(itemTypeId);
			masItemCategory.setDepartment(masDepartment);
		}
		if (sectionId != 0) {
			MasStoreSection masStoreSection = new MasStoreSection();
			masStoreSection.setId(sectionId);
			masItemCategory.setSection(masStoreSection);
		}
		
		Users users = new Users();
		users.setId(userId);
		masItemCategory.setLastChgBy(users);
		
		masItemCategory.setLastChgDate(currentDate);
		masItemCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masItemCategory);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map searchItemCategory(String itemCategoryCode,
			String itemCategoryName) {
		List<MasItemCategory> searchItemCategoryList = new ArrayList<MasItemCategory>();
		List<MasItemType> gridSectionList = new ArrayList<MasItemType>();
		List sectionList = null;
		Map itemCategoryFieldsMap = new HashMap();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
		try {
			if ((itemCategoryName != null) || (itemCategoryCode == null)) {
			
				searchItemCategoryList =session.createCriteria(MasItemCategory.class).add(Restrictions.like("ItemCategoryName","%"+itemCategoryName+"%").ignoreCase()).addOrder(Order.asc("ItemCategoryName")).list();
			} else {
						
				searchItemCategoryList =session.createCriteria(MasItemCategory.class).add(Restrictions.like("ItemCategoryCode","%"+itemCategoryCode+"%").ignoreCase()).addOrder(Order.asc("ItemCategoryCode")).list();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sectionList = session.createCriteria(MasStoreSection.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		gridSectionList = session.createCriteria(MasStoreSection.class).addOrder(Order.asc("SectionCode")).list();

		
		departmentList1 = session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", 3)).add(Restrictions.eq("Status","y").ignoreCase()).list();
		itemCategoryFieldsMap.put("gridSectionList", gridSectionList);
		itemCategoryFieldsMap.put("searchItemCategoryList",searchItemCategoryList);
		itemCategoryFieldsMap.put("sectionList", sectionList);
		itemCategoryFieldsMap.put("departmentList1", departmentList1);
		return itemCategoryFieldsMap;

	}

	// ----------------------------------Sales
	// Type-------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSalesTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSalesType> searchSalesTypeList = new ArrayList<MasSalesType>();
		searchSalesTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSalesType ");
		map.put("searchSalesTypeList", searchSalesTypeList);
		return map;
	}

	public boolean addSalesType(MasSalesType masSalesType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masSalesType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteSalesType(Integer salesTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSalesType masSalesType = new MasSalesType();
		masSalesType = (MasSalesType) getHibernateTemplate().load(
				MasSalesType.class, salesTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSalesType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSalesType.setStatus("y");
				dataDeleted = false;
			}
		}
		masSalesType.setLastChgBy(changedBy);
		masSalesType.setLastChgDate(currentDate);
		masSalesType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSalesType);
		return dataDeleted;
	}

	public boolean editSalesType(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int salesTypeId = 0;
		String salesTypeName = "";
		@SuppressWarnings("unused")
		String salesTypeCode = "";
		int salesTypeValue = 0;
		String changedBy = "";
		try {
			salesTypeId = (Integer) generalMap.get("id");
			salesTypeCode = (String) generalMap.get("salesTypeCode");
			salesTypeName = (String) generalMap.get("name");
			salesTypeValue = (Integer) generalMap.get("salesTypeValue");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			MasSalesType masSalesType = (MasSalesType) getHibernateTemplate()
					.load(MasSalesType.class, salesTypeId);

			masSalesType.setId(salesTypeId);
			masSalesType.setSalesTypeCode(salesTypeCode);
			masSalesType.setSalesTypeName(salesTypeName);

			masSalesType.setSalesTypeValue(salesTypeValue);
			masSalesType.setLastChgBy(changedBy);
			masSalesType.setLastChgDate(currentDate);
			masSalesType.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masSalesType);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map searchSalesType(String salesTypeCode, String salesTypeName) {
		List searchSalesTypeList = new ArrayList();
		Map salesTypeFieldMap = new HashMap();
		try {
			if ((salesTypeName != null) || (salesTypeCode == null)) {
				searchSalesTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSalesType sc where sc.SalesTypeName like '"
								+ salesTypeName
								+ "%' order by sc.SalesTypeName");
			} else {
				searchSalesTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasSalesType sc where sc.SalesTypeCode like '"
								+ salesTypeCode
								+ "%' order by sc.SalesTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		salesTypeFieldMap.put("searchSalesTypeList", searchSalesTypeList);
		return salesTypeFieldMap;
	}

	// ---------------------------------- Item
	// Class-------------------------------------
	
	  @SuppressWarnings("unchecked")
	  public Map<String, Object> showItemClassJsp(){
		  Map<String,Object> map=new HashMap<String,Object>();
	  try{ 
		  List<MasItemClass> searchItemClassList = new ArrayList<MasItemClass>();
		  List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		  Session session = (Session)getSession();
		  searchItemClassList = getHibernateTemplate().find( "from jkt.hms.masters.business.MasItemClass");
		  sectionList = session.createCriteria(MasStoreSection.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		  map.put("searchItemClassList",searchItemClassList);
		  map.put("sectionList",sectionList);
		  }catch (Exception e) {
		  } 
	  return map; }
	 
	  public boolean addItemClass(MasItemClass masItemClass) {
		  boolean successfullyAdded=false;
		  try {
		  org.springframework.orm.hibernate3.HibernateTemplate 
		  hbt = getHibernateTemplate();
		  hbt.setFlushModeName("FLUSH_EAGER");
		  hbt.setCheckWriteOperations(false); 
		  hbt.save(masItemClass);
		  successfullyAdded = true; 
		  } catch (DataAccessException e) 
		  {
		  e.printStackTrace(); 
		  } 
	  return successfullyAdded; 
	  }
	 
	  @SuppressWarnings("unchecked") public boolean deleteItemClass(int itemClassId,Map<String, Object> generalMap) {
		  boolean dataDeleted=false;
		  int userId = 0;
		  Date currentDate = new Date();
		  String currentTime= "";
		  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		  try{
		  MasItemClass masItemClass= new MasItemClass();
		  masItemClass=(MasItemClass)getHibernateTemplate().load(MasItemClass.class,itemClassId); 
		  userId =(Integer)generalMap.get("changedBy");
		  currentDate=(Date)generalMap.get("currentDate");
		  currentTime=(String)generalMap.get("currentTime");
		  if (masItemClass.getStatus().equalsIgnoreCase("y")){
		  masItemClass.setStatus("n");
		  dataDeleted=true; 
		  }else{
		  masItemClass.setStatus("y");
		  dataDeleted=false;
		  }
		  Users users = new Users();
		  users.setId(userId);
		  masItemClass.setLastChgBy(users);
		  masItemClass.setLastChgDate(currentDate);
		  masItemClass.setLastChgTime(currentTime);
		  org.springframework.orm.hibernate3.HibernateTemplate hbt =
		  getHibernateTemplate();
		  hbt.setFlushModeName("FLUSH_EAGER");
		  hbt.setCheckWriteOperations(false);
		  hbt.update(masItemClass);
		  }catch
		  (Exception e) { 
		  } return dataDeleted;
	  }
	 
	  public boolean editItemClassToDatabase(Map<String, Object> generalMap) {
		  boolean dataUpdated=false;
		  Date currentDate = new Date();
		  String currentTime = "";
		  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		  String itemClassName=""; 
		 String itemClassCode="";
		 int itemClassId=0;
		 int sectionId = 0;
		 int userId = 0;
		  itemClassId=(Integer)generalMap.get("id");
		  sectionId=(Integer)generalMap.get("sectionId");
		  itemClassCode=(String)generalMap.get("itemClassCode");
		  itemClassName=(String)generalMap.get("name");
		  userId = (Integer)generalMap.get("changedBy");
		  currentDate=(Date)generalMap.get("currentDate");
		  currentTime=(String)generalMap.get("currentTime");
		  System.out.println("itemClassId---------"+itemClassId);
		  System.out.println("sectionId---------"+sectionId);
		  
		  MasItemClass masItemClass =(MasItemClass)getHibernateTemplate().load(MasItemClass.class, itemClassId);
		  
		  masItemClass.setId(itemClassId);
		  
		  masItemClass.setItemClassName(itemClassName);
		  
		  MasStoreSection masStoreSection = new MasStoreSection();
		  masStoreSection.setId(sectionId);
		  masItemClass.setSection(masStoreSection);
		  
		  Users users = new Users();
		  users.setId(userId);
		  masItemClass.setLastChgBy(users);
		  
		  masItemClass.setLastChgDate(currentDate);
		  masItemClass.setLastChgTime(currentTime);
		  org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		  hbt.setFlushModeName("FLUSH_EAGER");
		  hbt.setCheckWriteOperations(false);
		  hbt.update(masItemClass);
		  dataUpdated = true; 
	  return dataUpdated;
	  }
	 
	  @SuppressWarnings("unchecked") public Map searchItemClass(String itemClassCode,String itemClassName) { 
		  List<MasItemClass>searchItemClassList=new ArrayList<MasItemClass>();
		  Map itemClassFieldsMap = new HashMap();
			Session session =(Session)getSession();
		  try{
		  if((itemClassName!=null) ||(itemClassCode==null)){
			  
			  searchItemClassList =session.createCriteria(MasItemClass.class).add(Restrictions.like("ItemClassName","%"+itemClassName+"%").ignoreCase()).addOrder(Order.asc("ItemClassName")).list();
	  	 } else{
	  		 
	  		searchItemClassList =session.createCriteria(MasItemClass.class).add(Restrictions.like("ItemClassCode","%"+itemClassCode+"%").ignoreCase()).addOrder(Order.asc("ItemClassCode")).list();
	  		 }
		  }catch (Exception e) {
	   }
	  itemClassFieldsMap.put("searchItemClassList",searchItemClassList);
	  return itemClassFieldsMap;
	  }
	 

	// ----------------------------- Item Wise
	// Supplier-----------------------------------
	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object>
	 * getItemWiseSupplier() { List<MasStoreSupplier> masItemWiseSupplierList =
	 * new ArrayList<MasStoreSupplier>(); @SuppressWarnings("unused")
	 * List<MasStoreItem> masItemList = new ArrayList<MasStoreItem>();
	 * List<MasStoreItem> gridItemList = new ArrayList<MasStoreItem>();
	 * List<MasStoreSupplier> masSupplierList = new
	 * ArrayList<MasStoreSupplier>(); List<MasStoreSupplier> gridSupplierList =
	 * new ArrayList<MasStoreSupplier>(); Map<String,Object> map=new
	 * HashMap<String,Object>(); try{ masItemWiseSupplierList =
	 * getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasItemWiseSupplier");
	 *
	 * masSupplierList = getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasStoreSupplier as id"); gridSupplierList =
	 * getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasStoreSupplier as mss where mss.Status =
	 * 'y'");
	 *
	 * masItemList = getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasStoreItem as id"); gridItemList =
	 * getHibernateTemplate().find( "from jkt.hms.masters.business.MasStoreItem
	 * as mst where mst.Status = 'y'");
	 *
	 * map.put("masItemWiseSupplierList",masItemWiseSupplierList);
	 * map.put("masItemList",masItemList); map.put("gridItemList",gridItemList);
	 * map.put("masSupplierList",masSupplierList);
	 * map.put("gridSupplierList",gridSupplierList); }catch (Exception e) {
	 *  } return map; }
	 *
	 * public boolean addItemWiseSupplier(MasItemWiseSupplier
	 * masItemWiseSupplier) { boolean saveFlag = false; try{
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_AUTO");
	 * hbt.setCheckWriteOperations(false); hbt.save(masItemWiseSupplier);
	 * saveFlag = true; }catch (Exception e) {  } return saveFlag; }
	 *
	 * @SuppressWarnings("unchecked") public boolean
	 * deleteItemWiseSupplier(Integer itemWiseSupplierId,Map<String, Object>
	 * generalMap) { boolean dataDeleted=false; String changedBy = ""; Date
	 * currentDate = new Date(); String currentTime = ""; currentTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 * MasItemWiseSupplier masItemWiseSupplier= new MasItemWiseSupplier();
	 * masItemWiseSupplier
	 * =(MasItemWiseSupplier)getHibernateTemplate().load(MasItemWiseSupplier
	 * .class,itemWiseSupplierId); changedBy =
	 * (String)generalMap.get("changedBy");
	 * currentDate=(Date)generalMap.get("currentDate");
	 * currentTime=(String)generalMap.get("currentTime"); if
	 * (masItemWiseSupplier.getStatus().equals("y")){
	 * masItemWiseSupplier.setStatus("n"); dataDeleted=true; }else{
	 * masItemWiseSupplier.setStatus("y"); dataDeleted=false; }
	 * masItemWiseSupplier.setLastChgBy(changedBy);
	 * masItemWiseSupplier.setLastChgDate(currentDate);
	 * masItemWiseSupplier.setLastChgTime(currentTime);
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); hbt.update(masItemWiseSupplier);
	 * return dataDeleted; }
	 *
	 * public boolean editItemWiseSupplier(Map<String, Object> generalMap) {
	 * boolean dataUpdated = false; int itemWiseId=0; int itemId=0; int
	 * supplierId=0; Date changedDate = new Date(); String changedTime = "";
	 * String changedBy = null;
	 *
	 * itemWiseId=(Integer)generalMap.get("itemWiseId");
	 * itemId=(Integer)generalMap.get("itemId");
	 * supplierId=(Integer)generalMap.get("supplierId");
	 *
	 * changedTime=(String)generalMap.get("changedTime");
	 * changedBy=(String)generalMap.get("changedBy");
	 * changedDate=(Date)generalMap.get("changedDate");
	 *
	 * MasItemWiseSupplier
	 * masSupplierItemWiseSupplier=(MasItemWiseSupplier)getHibernateTemplate
	 * ().load(MasItemWiseSupplier.class,itemWiseId); try{
	 * masSupplierItemWiseSupplier.setId(itemWiseId); MasStoreItem masItem=new
	 * MasStoreItem(); masItem.setId(itemId);
	 * masSupplierItemWiseSupplier.setItem(masItem);
	 *
	 * MasStoreSupplier masSupplier=new MasStoreSupplier();
	 * masSupplier.setId(supplierId);
	 * masSupplierItemWiseSupplier.setSupplier(masSupplier);
	 *
	 * masSupplierItemWiseSupplier.setLastChgBy(changedBy);
	 * masSupplierItemWiseSupplier.setLastChgDate(changedDate);
	 * masSupplierItemWiseSupplier.setLastChgTime(changedTime); }catch
	 * (Exception e) {  }
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false);
	 * hbt.update(masSupplierItemWiseSupplier); dataUpdated = true;
	 *
	 * return dataUpdated; }
	 *
	 * @SuppressWarnings("unchecked") public Map searchItemWiseSupplier(String
	 * itemName,String supplier1) { @SuppressWarnings("unused") List item = new
	 * ArrayList(); List masItemWiseSupplierList = new ArrayList();
	 *
	 * List masSupplierList = new ArrayList(); List gridSupplierList = new
	 * ArrayList(); List masItemList = new ArrayList(); List gridItemList = new
	 * ArrayList();
	 *
	 * List itemList = new ArrayList(); @SuppressWarnings("unused") List
	 * supplierList = new ArrayList(); Map map = new HashMap();
	 *
	 * @SuppressWarnings("unused") List gridSupplierTypeList = new ArrayList();
	 * int itemId=0; int SupplieId=0;
	 *
	 * try{ if((itemName!=null) || (supplier1==null)){ itemList =
	 * getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItem
	 * as ms where ms.Nomenclature like '"+ itemName+"%' order by
	 * ms.Nomenclature"); Iterator iterator=itemList.iterator(); MasStoreItem
	 * masItem = (MasStoreItem)iterator.next(); itemId=masItem.getId();
	 * masItemWiseSupplierList = getHibernateTemplate().find("from
	 * jkt.hms.masters.business.MasItemWiseSupplier ms where ms.Item like '"+
	 * itemId+"%' order by ms.Item");
	 *
	 * }else{ supplierList=getHibernateTemplate().find("from
	 * jkt.hms.masters.business.MasStoreSupplier as ms where ms.SupplierName
	 * like '"+ supplier1+"%' order by ms.SupplierName"); Iterator
	 * iterator2=itemList.iterator(); MasStoreSupplier
	 * masSupplier=(MasStoreSupplier)iterator2.next();
	 * SupplieId=masSupplier.getId();  masItemWiseSupplierList = getHibernateTemplate().find("from
	 * jkt.hms.masters.business.MasItemWiseSupplier sc where sc.Supplier like
	 * '"+ SupplieId+"%' order by sc.Supplier"); } }catch (Exception e) {
	 *  }
	 *
	 * masSupplierList = getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasStoreSupplier as id"); gridSupplierList =
	 * getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasStoreSupplier as mit where mit.Status =
	 * 'y'");
	 *
	 * masItemList = getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasStoreItem as id"); gridItemList =
	 * getHibernateTemplate().find( "from jkt.hms.masters.business.MasStoreItem
	 * as mit where mit.Status = 'y'");
	 *
	 * map.put("masItemWiseSupplierList",masItemWiseSupplierList);
	 * map.put("masItemList",masItemList); map.put("gridItemList",gridItemList);
	 * map.put("masSupplierList",masSupplierList);
	 * map.put("gridSupplierList",gridSupplierList); return map; } public
	 * Map<String, Object> searchItemWiseSupplier(String itemWiseSupplierCode,
	 * String itemWiseSupplierName) { // TODO Auto-generated method stub return
	 * null; }
	 *
	 * @SuppressWarnings("unchecked") public boolean checkItem(int itemId) {
	 * List tempList=new ArrayList(); boolean flag=false;
	 * tempList=getHibernateTemplate().find("from
	 * jkt.hms.masters.business.MasItemWiseSupplier as mit where
	 * mit.Id='"+itemId+"' "); if(tempList.size()==0) { flag=false; }else{
	 * flag=true; } return flag; }
	 */
	// -----------------------------------------item
	// master---------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGroupDepartmentWise(
			Map<String, Object> generalMap) {
		int deptId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		deptId = (Integer) generalMap.get("departmentId");
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		//List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		groupList = session.createCriteria(MasStoreGroup.class)
				.add(Restrictions.eq("Department.Id", deptId)).list();
		//itemCategoryList = session.createCriteria(MasItemCategory.class).add(Restrictions.eq("Department.Id", deptId)).list();

		map.put("groupList", groupList);
		//map.put("itemCategoryList", itemCategoryList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemJsp(int deptId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
			List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
			List<MasStoreItemGeneric> itemGenericList = new ArrayList<MasStoreItemGeneric>();
			List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
			List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
			List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
			List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
			List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
			List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
			List<FaMasSubLed> faSubMasAccountList = new ArrayList<FaMasSubLed>();
			List<MasSalesTaxType> masSaleTaxTypeList = new ArrayList<MasSalesTaxType>();
			List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
			String transactionSequenceName = "Item Code";
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			int orderNo = 0;
			sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",transactionSequenceName)).list();
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = sequenceNo + 1;
			
			// Criteria c = session.createCriteria(MasStoreItem.class)
			// .add(Restrictions.eq("Department.Id", deptId));
			// c.setFirstResult(0);
			// c.setMaxResults(1000);
			// searchItemList = c.list();
			
			masItemClassList= getHibernateTemplate()
			.find("from jkt.hms.masters.business.MasItemClass where upper(Status)='Y'");


			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			hospitalParametersList=session.createCriteria(HospitalParameters.class).list();
			int departmentIdForRKS=0;
			int departmentIdForVBCH=0;
		 	if(hospitalParametersList.size()>0){
				 for (HospitalParameters hospitalParameters : hospitalParametersList) {
					departmentIdForRKS=hospitalParameters.getDeptIdStoreCodeRKS();
					departmentIdForVBCH=hospitalParameters.getDeptIdStoreCodeVBCH();
				}
		 	}
		 	
		 	searchItemList = session.createCriteria(MasStoreItem.class).list();
		 	//searchItemList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItem as inp  where inp.Status = 'Y' || inp.Status = 'y'");
			/*if(deptId==departmentIdForRKS || deptId==departmentIdForVBCH)
			{
			 searchItemList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreItem as inp");
			}
			else
			{
				searchItemList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreItem as inp where inp.Department.Id = "
								+ deptId);
 			}*/
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection as id");
			itemGenericList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreItemGeneric as id");
			itemTypeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemType as mc where upper(mc.Status) = 'Y'");
			itemCategoryList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemCategory as mc where upper(mc.Status) = 'Y'");
			itemConversionList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreItemConversion as mc where upper(mc.Status) = 'Y'");
			groupList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) = 'Y'");

			map.put("faMasAccountList", faMasAccountList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("searchItemList", searchItemList);
			map.put("storeSectionList", sectionList);
			map.put("itemGenericList", itemGenericList);
			map.put("itemTypeList", itemTypeList);
			map.put("itemCategoryList", itemCategoryList);
			map.put("itemConversionList", itemConversionList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("masSaleTaxTypeList", masSaleTaxTypeList);
			map.put("manufacturerList", manufacturerList);
			map.put("storeSupplierList", supplierList);
			map.put("departmentList", departmentList);
			map.put("departmentList1", departmentList1);
			map.put("groupList", groupList);
			map.put("brandList", brandList);
			map.put("gridBrandList", gridBrandList);
			map.put("employeeList", employeeList);
			map.put("masItemClassList", masItemClassList);
			map.put("orderNo", orderNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> searchItem(String pvmsNo, String nomenclature) {
		List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> itemFieldsMap = new HashMap<String, Object>();
		List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
		List<MasStoreItemGeneric> itemGenericList = new ArrayList<MasStoreItemGeneric>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		Session session = (Session) getSession();
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		try {
			if ((pvmsNo != null)) {
				searchItemList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreItem as  mb where mb.PvmsNo like '"
								+ pvmsNo + "%' order by mb.PvmsNo");
				
				searchItemList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo")).list();
				
				
			}

			if ((nomenclature != null)) {
				searchItemList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature")).list();
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		storeSectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreSection as mr where mr.Status = 'y' ");
		itemGenericList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreItemGeneric as mbs where mbs.Status = 'y' ");
		itemTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemType as mbs where mbs.Status = 'y' ");
		itemConversionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreItemConversion as mbs where mbs.Status = 'y' ");
		itemCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemCategory as mbs where mbs.Status = 'y' ");
		
		groupList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreGroup as mg where mg.Status = 'y'");
		masItemClassList= getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasItemClass where Status='y'");


		itemFieldsMap.put("searchItemList", searchItemList);
		itemFieldsMap.put("masItemClassList", masItemClassList);
		itemFieldsMap.put("storeSectionList", storeSectionList);
		itemFieldsMap.put("itemGenericList", itemGenericList);
		itemFieldsMap.put("itemTypeList", itemTypeList);
		itemFieldsMap.put("itemConversionList", itemConversionList);
		itemFieldsMap.put("itemCategoryList", itemCategoryList);
		itemFieldsMap.put("groupList", groupList);
		
		return itemFieldsMap;
	}

	public boolean addItem(MasStoreItem masItem,Map<String, Object> map) {

		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masItem);
		Session session = (Session) getSession();
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		String transactionSequenceName = "Item Code";
		sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",	transactionSequenceName)).list();
		TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		int orderNo = transactionSequence.getTransactionSequenceNumber();
		orderNo = orderNo + 1;
		
		int id = transactionSequence.getId();
		TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		transactionSequence2.setTransactionSequenceNumber(orderNo);
		hbt.update(transactionSequence2);
		
		successfullyAdded = true;
		return successfullyAdded;
		
		
	}

	@SuppressWarnings("unchecked")
	public boolean deleteItem(Integer itemId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasStoreItem masItem = new MasStoreItem();
			masItem = (MasStoreItem) getHibernateTemplate().load(
					MasStoreItem.class, itemId);
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			//Integer itemTypeId = masItem.getItemType().getId();
			//Integer itemGenericId = masItem.getItemGeneric().getId();
			if (generalMap.get("flag") != null) {
				/*List itemTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasItemType as itemType where itemType.Id='"
								+ itemTypeId + "' and itemType.Status='y'");
				List itemGenericList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasItemGeneric as itemGeneric where itemGeneric.Id='"
								+ itemGenericId
								+ "' and itemGeneric.Status='y'");*/

				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masItem.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masItem.setStatus("y");
					dataDeleted = false;
				}
			}
			Users users = new Users();
			users.setId(userId);
			masItem.setLastChgBy(users);
		
			masItem.setLastChgDate(currentDate);
			masItem.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public List<MasStoreItem> checkForExistingPvmsNo(String pvmsNo) {
		List<MasStoreItem> existingPvmsNoList = new ArrayList<MasStoreItem>();

		Session session = (Session) getSession();
		existingPvmsNoList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.like("PvmsNo", pvmsNo)).list();
		return existingPvmsNoList;
	}

	// -------------------------------------ITEM
	// GENERIC-------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemGenericJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItemGeneric> searchItemGenericList = new ArrayList<MasStoreItemGeneric>();
		List<MasStorePharmaIndex> pharmaIndexList = new ArrayList<MasStorePharmaIndex>();
		List<MasStorePharmaIndex> gridPharmaIndexList = new ArrayList<MasStorePharmaIndex>();

		Session session = (Session) getSession();
		searchItemGenericList = session.createCriteria(MasStoreItemGeneric.class).list();
		pharmaIndexList = session.createCriteria(MasStorePharmaIndex.class).list();
		gridPharmaIndexList = session.createCriteria(MasStorePharmaIndex.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		
		map.put("searchItemGenericList", searchItemGenericList);
		map.put("pharamaIndexList", pharmaIndexList);
		map.put("gridPharmaIndexList", gridPharmaIndexList);
		return map;
	}

	public boolean addItemGeneric(MasStoreItemGeneric masStoreItemGeneric) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreItemGeneric);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean editItemGeneric(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String genericName = "";
		int itemGenericId = 0;
		int pharmaIndexId = 0;
		String contraIndication = "";
		String dosageCalculation = "";
		String drugInteraction = "";
		String specialPrecaution = "";
		@SuppressWarnings("unused")
		String sideEffects = "";
		int userId = 0;
		String currentTime = "";
		Date changedDate = new Date();

		itemGenericId = (Integer) generalMap.get("id");
		genericName = (String) generalMap.get("itemGenericName");

		pharmaIndexId=(Integer)generalMap.get("pharmaIndexId");
		contraIndication=(String)generalMap.get("contraIndication");
		dosageCalculation=(String)generalMap.get("dosageCalculation");
		drugInteraction=(String)generalMap.get("drugInteraction");
		specialPrecaution=(String)generalMap.get("specialPrecaution");

		sideEffects = (String) generalMap.get("sideEffects");

		userId = (Integer) generalMap.get("userId");
		changedDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStoreItemGeneric masStoreItemGeneric = (MasStoreItemGeneric) getHibernateTemplate()
				.get(MasStoreItemGeneric.class, itemGenericId);

		masStoreItemGeneric.setId(itemGenericId);
		masStoreItemGeneric.setGenericName(genericName);

		/*
		 * MasStorePharmaIndex masStorePharmaIndex = new MasStorePharmaIndex();
		 * masStorePharmaIndex.setId(pharmaIndexId);
		 * masStoreItemGeneric.setPharmaIndex(masStorePharmaIndex);
		 */
		masStoreItemGeneric.setContraIndication(contraIndication);
		masStoreItemGeneric.setDosageCalculation(dosageCalculation);
		masStoreItemGeneric.setDrugInteraction(drugInteraction);
		masStoreItemGeneric.setSpecialPrecaution(specialPrecaution);

		masStoreItemGeneric.setSideEffects(sideEffects);

		masStoreItemGeneric.setStatus("y");
		Users users = new Users();
		users.setId(userId);
		masStoreItemGeneric.setLastChgBy(users);
		
		masStoreItemGeneric.setLastChgDate(changedDate);
		masStoreItemGeneric.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masStoreItemGeneric);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteItemGeneric(int itemGenericId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
		masStoreItemGeneric = (MasStoreItemGeneric) getHibernateTemplate().get(
				MasStoreItemGeneric.class, itemGenericId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Session session = (Session) getSession();
		
		if (generalMap.get("flag") != null) {
			//List itemGenericList = getHibernateTemplate().find(	"from jkt.hms.masters.business.MasStorePharmaIndex as isc where isc.Id='"+ itemGenericId + "' and isc.Status='y'");
			
			
			
			List itemGenericList = session.createCriteria(MasStorePharmaIndex.class).add(Restrictions.eq("Id", itemGenericId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreItemGeneric.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreItemGeneric.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masStoreItemGeneric.setLastChgBy(users);
		
		masStoreItemGeneric.setLastChgDate(currentDate);
		masStoreItemGeneric.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItemGeneric);
		return dataDeleted;
	}

	public Map<String, Object> searchItemGeneric(String genericName) {
		List<MasStoreItemGeneric> searchItemGenericList = new ArrayList<MasStoreItemGeneric>();
		Map<String, Object> itemGenericFieldsMap = new HashMap<String, Object>();
		List pharamaIndexList = new ArrayList();
		Session session = (Session) getSession();
		try {
			if ((genericName != null)) {
				//searchItemGenericList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItemGeneric as i where i.GenericName like '"+ genericName + "%' order by i.GenericName");
				searchItemGenericList =session.createCriteria(MasStoreItemGeneric.class).add(Restrictions.like("GenericName", "%"+genericName+"%").ignoreCase()).addOrder(Order.asc("GenericName")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pharamaIndexList = session.createCriteria(MasStorePharmaIndex.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		itemGenericFieldsMap.put("searchItemGenericList", searchItemGenericList);
		itemGenericFieldsMap.put("pharamaIndexList", pharamaIndexList);
		return itemGenericFieldsMap;
	}

	// ------------------------------------------StoreVendorWiseManufacturer----------------------------

	public boolean addStoreVendorWiseManufacturer(
			MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreVendorWiseManufacturer);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteStoreVendorWiseManufacturer(
			int storeVendorWiseManufacturerId, Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = new MasStoreVendorWiseManufacturer();
		masStoreVendorWiseManufacturer = (MasStoreVendorWiseManufacturer) getHibernateTemplate()
				.load(MasStoreVendorWiseManufacturer.class,
						storeVendorWiseManufacturerId);
		
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer) generalMap.get("userId");
		@SuppressWarnings("unused")
		Integer manufacturerId = masStoreVendorWiseManufacturer
				.getManufacturer().getId();
		if (generalMap.get("flag") != null) {
			List manufacturerList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasManufacturer as isc where isc.Id='"
							+ storeVendorWiseManufacturerId
							+ "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreVendorWiseManufacturer.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreVendorWiseManufacturer.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masStoreVendorWiseManufacturer.setLastChgBy(users);
		
		masStoreVendorWiseManufacturer.setLastChgDate(currentDate);
		masStoreVendorWiseManufacturer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreVendorWiseManufacturer);
		return dataDeleted;

	}

	public boolean editStoreVendorWiseManufacturerToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int manufacturerId = 0;
		int storeVendorWiseManufacturerId = 0;
		int userId = 0;
		String currentTime = "";
		Date changedDate = new Date();
		String storeVendorWiseManufacturerCode = "";
		storeVendorWiseManufacturerId = (Integer) generalMap.get("id");
		storeVendorWiseManufacturerCode = (String) generalMap
				.get("storeVendorWiseManufacturerCode");
		manufacturerId = (Integer) generalMap.get("manufacturerId");
		userId = (Integer) generalMap.get("userId");
		changedDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = (MasStoreVendorWiseManufacturer) getHibernateTemplate()
				.load(MasStoreVendorWiseManufacturer.class,
						storeVendorWiseManufacturerId);
		masStoreVendorWiseManufacturer.setId(storeVendorWiseManufacturerId);

		MasManufacturer masManufacturer = new MasManufacturer();
		masManufacturer.setId(manufacturerId);
		masStoreVendorWiseManufacturer.setManufacturer(masManufacturer);
		masStoreVendorWiseManufacturer.setStatus("y");
		

		Users users = new Users();
		users.setId(userId);
		masStoreVendorWiseManufacturer.setLastChgBy(users);
		
		masStoreVendorWiseManufacturer.setLastChgDate(changedDate);
		masStoreVendorWiseManufacturer.setLastChgTime(currentTime);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masStoreVendorWiseManufacturer);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchStoreVendorWiseManufacturer(
			String storeVendorWiseManufacturerCode) {
		List<MasStoreVendorWiseManufacturer> searchStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();
		List manufacturerList = null;
		Map<String, Object> storeVendorWiseManufacturerFieldsMap = new HashMap<String, Object>();
		List gridManufacturerList = null;
		try {
			if (storeVendorWiseManufacturerCode != null) {
				searchStoreVendorWiseManufacturerList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreVendorWiseManufacturer as i where i.VendorCode like '"
								+ storeVendorWiseManufacturerCode
								+ "%' order by i.VendorCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Session session = (Session)getSession();
		manufacturerList=	session.createCriteria(MasManufacturer.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		 
		gridManufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer as isc");
		storeVendorWiseManufacturerFieldsMap.put("gridManufacturerList",
				gridManufacturerList);
		storeVendorWiseManufacturerFieldsMap.put(
				"searchStoreVendorWiseManufacturerList",
				searchStoreVendorWiseManufacturerList);
		storeVendorWiseManufacturerFieldsMap.put("manufacturerList",
				manufacturerList);

		return storeVendorWiseManufacturerFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStoreVendorWiseManufacturerJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreVendorWiseManufacturer> searchStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<MasManufacturer> gridManufacturerList = new ArrayList<MasManufacturer>();
		searchStoreVendorWiseManufacturerList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreVendorWiseManufacturer ");
		gridManufacturerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasManufacturer as isc");
		Session session = (Session)getSession();
		manufacturerList=	session.createCriteria(MasManufacturer.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		map.put("searchStoreVendorWiseManufacturerList",
				searchStoreVendorWiseManufacturerList);
		map.put("manufacturerList", manufacturerList);
		map.put("gridManufacturerList", gridManufacturerList);
		return map;
	}

	// ----------------------------Store
	// Section----------------------------------------

	public Map<String, Object> showStoreSectionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSection> searchStoreSectionList = new ArrayList<MasStoreSection>();
		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		Session session = (Session)getSession();
		searchStoreSectionList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreSection as isc where upper(isc.Status) =upper('y')");
		itemGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.eq("Status", "y")).list();
		itemTypeList = session.createCriteria(MasItemType.class).add(Restrictions.eq("Status", "y")).list();
		map.put("searchStoreSectionList", searchStoreSectionList);
		map.put("itemGroupList", itemGroupList);
		map.put("itemTypeList", itemTypeList);
		return map;
	}

	public boolean addStoreSection(MasStoreSection masStoreSection) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreSection);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteStoreSection(int sectionId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreSection masStoreSection = new MasStoreSection();
		masStoreSection = (MasStoreSection) getHibernateTemplate().get(
				MasStoreSection.class, sectionId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreSection.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreSection.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masStoreSection.setLastChgBy(users);
		masStoreSection.setLastChgDate(currentDate);
		masStoreSection.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSection);
		return dataDeleted;
	}

	public boolean editStoreSectionToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String sectionName = "";
		@SuppressWarnings("unused")
		String sectionCode = "";
		int sectionId = 0;
		int userId = 0;
		int itemTypeId = 0;
		
		sectionId = (Integer) generalMap.get("id");
		sectionCode = (String) generalMap.get("sectionCode");
		sectionName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if(generalMap.get("itemTypeId") != null){
			itemTypeId = (Integer)generalMap.get("itemTypeId");
		}
		MasStoreSection masStoreSection = (MasStoreSection) getHibernateTemplate()
				.get(MasStoreSection.class, sectionId);
		masStoreSection.setId(sectionId);
		masStoreSection.setSectionName(sectionName);
		Users users = new Users();
		users.setId(userId);
		masStoreSection.setLastChgBy(users);
		masStoreSection.setLastChgDate(currentDate);
		masStoreSection.setLastChgTime(currentTime);
		MasItemType masItemType = new MasItemType();
		masItemType.setId(itemTypeId);
		masStoreSection.setItemType(masItemType);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreSection);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchStoreSection(String sectionCode,
			String sectionName) {

		List<MasStoreSection> searchStoreSectionList = new ArrayList<MasStoreSection>();
		Map<String, Object> sectionieldsMap = new HashMap<String, Object>();
		try {
			if ((sectionName != null) || (sectionCode == null)) {
				searchStoreSectionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreSection imc where imc.SectionName like '"
								+ sectionName + "%' order by imc.SectionName");
			} else {
				searchStoreSectionList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreSection imc where imc.SectionCode like '"
								+ sectionCode + "%' order by imc.SectionCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sectionieldsMap.put("searchStoreSectionList", searchStoreSectionList);
		return sectionieldsMap;
	}

	// -----------------------Financial-----------------------
	public Map<String, Object> showFinancialJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreFinancial> searchFinancialList = new ArrayList<MasStoreFinancial>();
		searchFinancialList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreFinancial ");
		map.put("searchFinancialList", searchFinancialList);
		return map;
	}

	public Map<String, Object> searchFinancial(Date startDate, Date endDate) {
		List<MasItemType> searchFinancialList = new ArrayList<MasItemType>();
		Map<String, Object> financialFieldsMap = new HashMap<String, Object>();
		try {
			if ((startDate != null) || (endDate == null)) {

				searchFinancialList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreFinancial sc where sc.StartDate like '"
								+ startDate + "%' order by sc.StartDate");
			} else {
				searchFinancialList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreFinancial sc where sc.EndDate like '"
								+ endDate + "%' order by sc.EndDate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		financialFieldsMap.put("searchFinancialList", searchFinancialList);
		return financialFieldsMap;
	}

	public boolean addFinancial(MasStoreFinancial masStoreFinancial) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreFinancial);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteFinancial(int financialId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		masStoreFinancial = (MasStoreFinancial) getHibernateTemplate().load(
				MasStoreFinancial.class, financialId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreFinancial.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreFinancial.setStatus("y");
				dataDeleted = false;
			}
		}
		//masStoreFinancial.setLastChgBy(changedBy);
		masStoreFinancial.setLastChgDate(currentDate);
		masStoreFinancial.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreFinancial);
		return dataDeleted;
	}

	public boolean editFinancialToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int financialId = 0;
		Date startDate = null;
		Date endDate = null;
		String changedBy = "";
		financialId = (Integer) generalMap.get("id");
		startDate = (Date) generalMap.get("startDate");
		endDate = (Date) generalMap.get("endDate");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStoreFinancial masStoreFinancial = (MasStoreFinancial) getHibernateTemplate()
				.load(MasStoreFinancial.class, financialId);
		masStoreFinancial.setId(financialId);
		masStoreFinancial.setStartDate(startDate);
		masStoreFinancial.setEndDate(endDate);
//		masStoreFinancial.setLastChgBy(changedBy);
		masStoreFinancial.setLastChgDate(currentDate);
		masStoreFinancial.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreFinancial);
		dataUpdated = true;
		return dataUpdated;
	}

	// -----------------------PharmaIndex-----------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPharmaIndexJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStorePharmaIndex> searchPharmaIndexList = new ArrayList<MasStorePharmaIndex>();
		searchPharmaIndexList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStorePharmaIndex ");
		map.put("searchPharmaIndexList", searchPharmaIndexList);
		return map;
	}

	public boolean addPharmaIndex(MasStorePharmaIndex masStorePharmaIndex) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStorePharmaIndex);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deletePharmaIndex(int pharmaIndexId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStorePharmaIndex masStorePharmaIndex = new MasStorePharmaIndex();
		masStorePharmaIndex = (MasStorePharmaIndex) getHibernateTemplate()
				.load(MasStorePharmaIndex.class, pharmaIndexId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStorePharmaIndex.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStorePharmaIndex.setStatus("y");
				dataDeleted = false;
			}
		}
		masStorePharmaIndex.setLastChgBy(changedBy);
		masStorePharmaIndex.setLastChgDate(currentDate);
		masStorePharmaIndex.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStorePharmaIndex);
		return dataDeleted;
	}

	public boolean editPharmaIndexToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String pharmaIndexName = "";
		int pharmaIndexId = 0;
		String changedBy = "";

		pharmaIndexId = (Integer) generalMap.get("id");
		pharmaIndexName = (String) generalMap.get("pharmaIndexName");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStorePharmaIndex masStorePharmaIndex = (MasStorePharmaIndex) getHibernateTemplate()
				.load(MasStorePharmaIndex.class, pharmaIndexId);
		masStorePharmaIndex.setId(pharmaIndexId);
		masStorePharmaIndex.setPharmaIndexName(pharmaIndexName);
		masStorePharmaIndex.setLastChgBy(changedBy);
		masStorePharmaIndex.setLastChgDate(currentDate);
		masStorePharmaIndex.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStorePharmaIndex);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPharmaIndex(String pharmaIndexName) {
		List<MasStorePharmaIndex> searchPharmaIndexList = new ArrayList<MasStorePharmaIndex>();
		Map<String, Object> pharmaIndexFieldsMap = new HashMap<String, Object>();
		try {
			if ((pharmaIndexName != null)) {
				searchPharmaIndexList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStorePharmaIndex as  mb where mb.PharmaIndexName like '"
								+ pharmaIndexName
								+ "%' order by mb.PharmaIndexName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pharmaIndexFieldsMap
				.put("searchPharmaIndexList", searchPharmaIndexList);
		return pharmaIndexFieldsMap;
	}

	// --------------------------------Store Unit------------------------

	public Map<String, Object> showItemUnitJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreUnit> searchItemUnitList = new ArrayList<MasStoreUnit>();
		searchItemUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreUnit ");
		map.put("searchItemUnitList", searchItemUnitList);
		return map;
	}

	public Map<String, Object> searchItemUnit(String unitName) {
		List<MasStoreUnit> searchItemUnitList = new ArrayList<MasStoreUnit>();
		Map<String, Object> storeUnitFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			if ((unitName != null)) {
				
				searchItemUnitList =session.createCriteria(MasStoreUnit.class).add(Restrictions.like("UnitName", unitName).ignoreCase()).addOrder(Order.asc("UnitName")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		storeUnitFieldsMap.put("searchItemUnitList", searchItemUnitList);
		return storeUnitFieldsMap;
	}

	public boolean addItemUnit(MasStoreUnit masStoreUnit) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreUnit);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteItemUnit(int itemUnitId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreUnit masStoreUnit = new MasStoreUnit();
		masStoreUnit = (MasStoreUnit) getHibernateTemplate().load(
				MasStoreUnit.class, itemUnitId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreUnit.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreUnit.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masStoreUnit.setLastChgBy(user);
		masStoreUnit.setLastChgDate(currentDate);
		masStoreUnit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreUnit);
		return dataDeleted;
	}

	public boolean editItemUnitToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String unitName = "";
		int itemUnitId = 0;
		int userId = 0;

		itemUnitId = (Integer) generalMap.get("id");
		unitName = (String) generalMap.get("unitName");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStoreUnit masStoreUnit = (MasStoreUnit) getHibernateTemplate().load(
				MasStoreUnit.class, itemUnitId);
		masStoreUnit.setId(itemUnitId);
		masStoreUnit.setUnitName(unitName);
		Users user = new Users();
		user.setId(userId);
		masStoreUnit.setLastChgBy(user);
		masStoreUnit.setLastChgDate(currentDate);
		masStoreUnit.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreUnit);
		dataUpdated = true;
		return dataUpdated;
	}

	// ----------------------------Item Conversion---------------------------------------------
	public Map<String, Object> showItemConversionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreUnit> itemPurchaseUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreUnit> itemIntermediateUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreUnit> itemIssueUnitList = new ArrayList<MasStoreUnit>();
		Session session = (Session) getSession();
		List<MasStoreItemConversion> searchItemConversionList = new ArrayList<MasStoreItemConversion>();

		itemPurchaseUnitList =session.createCriteria(MasStoreUnit.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		itemIntermediateUnitList = session.createCriteria(MasStoreUnit.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		itemIssueUnitList = session.createCriteria(MasStoreUnit.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		searchItemConversionList = session.createCriteria(MasStoreItemConversion.class).list();
		map.put("itemPurchaseUnitList", itemPurchaseUnitList);
		map.put("itemIntermediateUnitList", itemIntermediateUnitList);
		map.put("itemIssueUnitList", itemIssueUnitList);
		map.put("searchItemConversionList", searchItemConversionList);
		return map;
	}

	public Map<String, Object> searchItemConversion(String itemUnitName) {
		List<MasBed> searchItemConversionList = new ArrayList<MasBed>();
		Map<String, Object> itemConversionFieldsMap = new HashMap<String, Object>();
		List<MasStoreUnit> itemPurchaseUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreUnit> itemIntermediateUnitList = new ArrayList<MasStoreUnit>();
		List<MasStoreUnit> itemIssueUnitList = new ArrayList<MasStoreUnit>();
		Session session = (Session) getSession();
		try {
			if ((itemUnitName != null)) {
				
				searchItemConversionList =session.createCriteria(MasStoreItemConversion.class).add(Restrictions.like("ItemUnitName", "%"+itemUnitName+"%").ignoreCase()).addOrder(Order.asc("ItemUnitName")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		itemPurchaseUnitList =session.createCriteria(MasStoreUnit.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		itemIntermediateUnitList = session.createCriteria(MasStoreUnit.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		itemIssueUnitList = session.createCriteria(MasStoreUnit.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		itemConversionFieldsMap.put("searchItemConversionList",	searchItemConversionList);
		itemConversionFieldsMap.put("itemPurchaseUnitList",	itemPurchaseUnitList);
		itemConversionFieldsMap.put("itemIntermediateUnitList",itemIntermediateUnitList);
		itemConversionFieldsMap.put("itemIssueUnitList", itemIssueUnitList);
		return itemConversionFieldsMap;

	}

	public boolean addItemConversion(
			MasStoreItemConversion masStoreItemConversion) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreItemConversion);
		successfullyAdded = true;
		return successfullyAdded;
	}

	// ---------------------------PO Delivery
	// Terms------------------------------------
	public Map<String, Object> showPoDeliveryTermsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStorePoDeliveryTerms> searchPoDeliveryTermsList = new ArrayList<MasStorePoDeliveryTerms>();
		searchPoDeliveryTermsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStorePoDeliveryTerms ");
		map.put("searchPoDeliveryTermsList", searchPoDeliveryTermsList);
		return map;
	}

	public Map<String, Object> searchPoDeliveryTerms(String poDeliveryType) {
		List<MasBed> searchPoDeliveryTermsList = new ArrayList<MasBed>();
		Map<String, Object> poDeliveryTermsFieldsMap = new HashMap<String, Object>();

		try {
			if ((poDeliveryType != null)) {
				searchPoDeliveryTermsList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStorePoDeliveryTerms as  mb where mb.PoDeliveryTermsName like '"
								+ poDeliveryType
								+ "%' order by mb.PoDeliveryTermsName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		poDeliveryTermsFieldsMap.put("searchPoDeliveryTermsList",
				searchPoDeliveryTermsList);
		return poDeliveryTermsFieldsMap;
	}

	public boolean addPoDeliveryTerms(
			MasStorePoDeliveryTerms masStorePoDeliveryTerms) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masStorePoDeliveryTerms);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean deletePoDeliveryTerms(int poTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStorePoDeliveryTerms masStorePoDeliveryTerms = new MasStorePoDeliveryTerms();
		masStorePoDeliveryTerms = (MasStorePoDeliveryTerms) getHibernateTemplate()
				.get(MasStorePoDeliveryTerms.class, poTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStorePoDeliveryTerms.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStorePoDeliveryTerms.setStatus("y");
				dataDeleted = false;
			}
		}
		masStorePoDeliveryTerms.setLastChgBy(changedBy);
		masStorePoDeliveryTerms.setLastChgDate(currentDate);
		masStorePoDeliveryTerms.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStorePoDeliveryTerms);
		return dataDeleted;
	}

	public boolean editPoDeliveryTermsToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String poType = "";
		int poDeliveryTermsId = 0;
		String description = "";
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();
		poDeliveryTermsId = (Integer) generalMap.get("id");
		poType = (String) generalMap.get("poType");
		description = (String) generalMap.get("description");

		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStorePoDeliveryTerms masStorePoDeliveryTerms = (MasStorePoDeliveryTerms) getHibernateTemplate()
				.get(MasStorePoDeliveryTerms.class, poDeliveryTermsId);

		masStorePoDeliveryTerms.setId(poDeliveryTermsId);
		masStorePoDeliveryTerms.setPoDeliveryTermsName(poType);
		masStorePoDeliveryTerms.setPoDeliveryTermsDescription(description);
		masStorePoDeliveryTerms.setStatus("y");
		masStorePoDeliveryTerms.setLastChgBy(changedBy);
		masStorePoDeliveryTerms.setLastChgDate(changedDate);
		masStorePoDeliveryTerms.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masStorePoDeliveryTerms);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/*
	 * public Map<String, Object> searchBudget(String budgetCode) {
	 * List<MasStoreBudget> searchBudgetList=new ArrayList<MasStoreBudget>();
	 * Map<String,Object> budgetFieldsMap = new HashMap<String,Object>(); List
	 * financialList = new ArrayList(); List gridFinancialList=null; try{
	 * searchBudgetList=getHibernateTemplate().find("from
	 * jkt.hms.masters.business.MasStoreBudget as msb where msb.BudgetCode like
	 * '"+ budgetCode+"%' order by msb.BudgetCode"); } catch (Exception e) {
	 * } financialList =
	 * getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasStoreFinancial as msf where msf.Status = 'y'
	 * "); gridFinancialList=getHibernateTemplate().find( "from
	 * jkt.hms.masters.business.MasStoreFinancial as msf where msf.Status = 'y'
	 * "); budgetFieldsMap.put("searchBudgetList",searchBudgetList);
	 * budgetFieldsMap.put("financialList",financialList);
	 * budgetFieldsMap.put("gridFinancialList",gridFinancialList); return
	 * budgetFieldsMap; } public boolean addBudget(MasStoreBudget
	 * masStoreBudget) { boolean successfullyAdded=false;
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_AUTO");
	 * hbt.setCheckWriteOperations(false); hbt.save(masStoreBudget);
	 * successfullyAdded = true; return successfullyAdded; } public boolean
	 * deleteBudget(int budgetId,Map<String, Object> generalMap) { boolean
	 * dataDeleted=false; String changedBy = ""; Date currentDate = new Date();
	 * String currentTime = ""; currentTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 * MasStoreBudget masStoreBudget= new MasStoreBudget();
	 * masStoreBudget=(MasStoreBudget
	 * )getHibernateTemplate().get(MasStoreBudget.class,budgetId); changedBy =
	 * (String)generalMap.get("changedBy");
	 * currentDate=(Date)generalMap.get("currentDate");
	 * currentTime=(String)generalMap.get("currentTime");
	 *
	 * @SuppressWarnings("unused") Integer
	 * financialId=masStoreBudget.getFinancial().getId(); if
	 * (masStoreBudget.getStatus().equals("y")){ @SuppressWarnings("unused")
	 * List financialList=getHibernateTemplate().find("from
	 * jkt.hms.masters.business.MasStoreFinancial as msf where
	 * msf.Id='"+budgetId+"' and msf.Status='y'");
	 * masStoreBudget.setStatus("n"); dataDeleted=true; }else{
	 * masStoreBudget.setStatus("y"); dataDeleted=false; }
	 * masStoreBudget.setLastChgBy(changedBy);
	 * masStoreBudget.setLastChgDate(currentDate);
	 * masStoreBudget.setLastChgTime(currentTime);
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); hbt.update(masStoreBudget); return
	 * dataDeleted; } public boolean editBudgetToDatabase(Map<String, Object>
	 * generalMap) { boolean dataUpdated=false; int budgetId=0; int financialId
	 * = 0; String budgetCode = ""; Float totalAllocatedAmount = null; Float
	 * crvComittedAmount = null; Float poCommitedAmount = null; Float
	 * utilizedAmount = null; String changedBy = ""; String currentTime=""; Date
	 * changedDate = new Date(); budgetId=(Integer)generalMap.get("id");
	 * budgetCode=(String)generalMap.get("code");
	 * financialId=(Integer)generalMap.get("financialId");
	 * totalAllocatedAmount=(Float)generalMap.get("totalAllocatedAmount");
	 * crvComittedAmount=(Float)generalMap.get("crvComittedAmount");
	 * poCommitedAmount=(Float)generalMap.get("poCommitedAmount");
	 * utilizedAmount=(Float)generalMap.get("utilizedAmount"); changedBy =
	 * (String)generalMap.get("changedBy");
	 * changedDate=(Date)generalMap.get("changedDate");
	 * currentTime=(String)generalMap.get("currentTime");
	 *
	 * MasStoreBudget
	 * masStoreBudget=(MasStoreBudget)getHibernateTemplate().get(MasStoreBudget
	 * .class,budgetId);
	 *
	 * masStoreBudget.setId(budgetId); masStoreBudget.setBudgetCode(budgetCode);
	 *
	 * if(financialId != 0){ MasStoreFinancial masStoreFinancial = new
	 * MasStoreFinancial(); masStoreFinancial.setId(financialId);
	 * masStoreBudget.setFinancial(masStoreFinancial); }
	 *
	 * totalAllocatedAmount=(Float)generalMap.get("totalAllocatedAmount");
	 * crvComittedAmount=(Float)generalMap.get("crvComittedAmount");
	 * poCommitedAmount=(Float)generalMap.get("poCommitedAmount");
	 * utilizedAmount=(Float)generalMap.get("utilizedAmount");
	 * masStoreBudget.setStatus("y"); masStoreBudget.setLastChgBy(changedBy);
	 * masStoreBudget.setLastChgDate(changedDate);
	 * masStoreBudget.setLastChgTime(currentTime); try{
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); hbt.update(masStoreBudget);
	 * dataUpdated = true; }catch (Exception e) {  } return dataUpdated; }
	 */
	// -----------------------Me Scale--------------------------
	public Map<String, Object> showMeScaleJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();

		searchMeScaleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreMeScale ");
		map.put("searchMeScaleList", searchMeScaleList);
		return map;
	}

	public boolean addMeScale(MasStoreMeScale masStoreMeScale) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreMeScale);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteMeScale(int meScaleId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
		masStoreMeScale = (MasStoreMeScale) getHibernateTemplate().get(
				MasStoreMeScale.class, meScaleId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreMeScale.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreMeScale.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreMeScale.setLastChgBy(changedBy);
		masStoreMeScale.setLastChgDate(currentDate);
		masStoreMeScale.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreMeScale);
		return dataDeleted;
	}

	public boolean editMeScaleToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String meScaleDescription = "";
		@SuppressWarnings("unused")
		int meScaleNumber = 0;
		int meScaleId = 0;

		meScaleId = (Integer) generalMap.get("id");
		meScaleNumber = (Integer) generalMap.get("meScaleNumber");
		meScaleDescription = (String) generalMap.get("meScaleDescription");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreMeScale masStoreMeScale = (MasStoreMeScale) getHibernateTemplate()
				.load(MasStoreMeScale.class, meScaleId);

		masStoreMeScale.setId(meScaleId);
		masStoreMeScale.setMeScaleDescription(meScaleDescription);
		masStoreMeScale.setLastChgBy(changedBy);
		masStoreMeScale.setLastChgDate(currentDate);
		masStoreMeScale.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreMeScale);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchMeScale1(int meScaleNumber) {
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		Map<String, Object> meScaleFieldsMap = new HashMap<String, Object>();
		try {
			if ((meScaleNumber != 0)) {
				searchMeScaleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreMeScale as  mb where mb.MeScale like '"
								+ meScaleNumber + "%' order by mb.MeScale");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		meScaleFieldsMap.put("searchMeScaleList", searchMeScaleList);
		return meScaleFieldsMap;

	}

	// ----------------------------- AirForceUnitDepot--------------------------
	public boolean addAirForceUnitDepot(
			MasStoreAirForceDepot masStoreAirForceDepot) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreAirForceDepot);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public Map<String, Object> showAirForceUnitDepotJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreAirForceDepot> searchAirForceUnitDepotList = new ArrayList<MasStoreAirForceDepot>();

		searchAirForceUnitDepotList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreAirForceDepot ");
		map.put("searchAirForceUnitDepotList", searchAirForceUnitDepotList);
		return map;
	}

	public boolean editAirForceUnitDepotToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String airForceDepotName = "";
		int airForceDepotId = 0;
		String type = "";
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();
		airForceDepotId = (Integer) generalMap.get("id");
		airForceDepotName = (String) generalMap.get("airForceDepotName");
		type = (String) generalMap.get("type");
		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");

		MasStoreAirForceDepot masStoreAirForceDepot = (MasStoreAirForceDepot) getHibernateTemplate()
				.get(MasStoreAirForceDepot.class, airForceDepotId);

		masStoreAirForceDepot.setId(airForceDepotId);
		masStoreAirForceDepot.setAirForceDepotName(airForceDepotName);
		masStoreAirForceDepot.setAirForceDepotType(type);
		masStoreAirForceDepot.setStatus("y");
		masStoreAirForceDepot.setLastChgBy(changedBy);
		masStoreAirForceDepot.setLastChgDate(changedDate);
		masStoreAirForceDepot.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masStoreAirForceDepot);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteAirForceUnitDepot(int airForceDepotId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
		masStoreAirForceDepot = (MasStoreAirForceDepot) getHibernateTemplate()
				.get(MasStoreAirForceDepot.class, airForceDepotId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreAirForceDepot.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreAirForceDepot.setStatus("y");
				dataDeleted = false;
			}
		}
		masStoreAirForceDepot.setLastChgBy(changedBy);
		masStoreAirForceDepot.setLastChgDate(currentDate);
		masStoreAirForceDepot.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreAirForceDepot);
		return dataDeleted;
	}

	public Map<String, Object> searchAirForceUnitDepot(String airForceDepotName) {
		List<MasStoreAirForceDepot> searchAirForceUnitDepotList = new ArrayList<MasStoreAirForceDepot>();
		Map<String, Object> airForceUnitDepotFieldsMap = new HashMap<String, Object>();

		try {
			if ((airForceDepotName != null)) {
				searchAirForceUnitDepotList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasStoreAirForceDepot as  mb where mb.AirForceDepotName like '"
								+ airForceDepotName
								+ "%' order by mb.AirForceDepotName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		airForceUnitDepotFieldsMap.put("searchAirForceUnitDepotList",
				searchAirForceUnitDepotList);
		return airForceUnitDepotFieldsMap;
	}

	public boolean editItem(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		int itemId = 0;
		int groupId = 0;
		int itemClassId = 0;
		int sectionId = 0;
		int itemGenericId = 0;
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemConversionId = 0;
		String pvms = "";
		String commonName = "";
		String dangerousDrug = "";
		String controlledDrug = "";
		String highValueDrug = "";
		String rateContractItem = "";
		BigDecimal minStock  = new BigDecimal(0);
		BigDecimal maxStock  = new BigDecimal(0);
		String leadTime = "";
		int hospitalId = 0;
		int userId = 0;
		String specification = "";
		String nomenclature = "";
		String allergy = "";
		int slowMovingDays = 0;
		int fastMovingDays = 0;
		int nonMovingDays = 0;
		String tempreture = "";
		BigDecimal minTempreture  = new BigDecimal(0);
		BigDecimal maxTempreture  = new BigDecimal(0);
		String abc = "";
		String ved ="";
		String standardAvailability="";
		String expiry="";
		itemId = (Integer) generalMap.get("id");
		ved = (String) generalMap.get("ved");
		abc = (String) generalMap.get("abc");
		pvms = (String) generalMap.get("pvms");
		commonName = (String) generalMap.get("commonName");
		maxTempreture = (BigDecimal) generalMap.get("maxTempreture");
		tempreture = (String) generalMap.get("tempreture");
		minTempreture = (BigDecimal) generalMap.get("minTempreture");
		nomenclature = (String) generalMap.get("name");
		itemClassId = (Integer) generalMap.get("itemClassId");
		sectionId = (Integer) generalMap.get("sectionId");
		groupId = (Integer) generalMap.get("groupId");
		itemGenericId = (Integer) generalMap.get("itemGenericId");
		itemTypeId = (Integer) generalMap.get("itemTypeId");
		itemCategoryId = (Integer) generalMap.get("itemCategoryId");
		itemConversionId = (Integer) generalMap.get("itemConversionId");
		pvms = (String) generalMap.get("pvms");
		dangerousDrug = (String) generalMap.get("dangerousDrug");
		controlledDrug = (String) generalMap.get("controlledDrug");
		highValueDrug = (String) generalMap.get("highValueDrug");
		rateContractItem = (String) generalMap.get("rateContractItem");
		minStock = (BigDecimal) generalMap.get("minStock");
		maxStock = (BigDecimal) generalMap.get("maxStock");
		leadTime = (String) generalMap.get("leadTime");
		hospitalId = (Integer) generalMap.get("hospitalId");
		userId= (Integer) generalMap.get("userId");
		specification = (String) generalMap.get("specification");
		slowMovingDays = (Integer) generalMap.get("slowMovingDays");
		fastMovingDays = (Integer) generalMap.get("fastMovingDays");
		nonMovingDays = (Integer) generalMap.get("nonMovingDays");
		expiry = (String) generalMap.get("expiry");
		allergy = (String) generalMap.get("allergy");
		currentDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		standardAvailability = (String) generalMap.get("standardAvailability");
		MasStoreItem masStoreItem = (MasStoreItem) getHibernateTemplate().get(
				MasStoreItem.class, itemId);

		masStoreItem.setId(itemId);
		masStoreItem.setNomenclature(nomenclature);
		masStoreItem.setPvmsNo(pvms);
		masStoreItem.setCommonName(commonName);

		MasStoreSection masStoreSection = new MasStoreSection();
		masStoreSection.setId(sectionId);
		masStoreItem.setSection(masStoreSection);

		if (itemGenericId != 0) {
			MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
			masStoreItemGeneric.setId(itemGenericId);
			masStoreItem.setItemGeneric(masStoreItemGeneric);
			
		}
	
		
	

		if (groupId != 0) {
			MasStoreGroup masStoreGroup = new MasStoreGroup();
			masStoreGroup.setId(groupId);
			masStoreItem.setGroup(masStoreGroup);
		} else {
			masStoreItem.setGroup(null);
		}

		 MasItemType masStoreItemType = new MasItemType();
		 masStoreItemType.setId(itemTypeId);
		 masStoreItem.setItemType(masStoreItemType);

		if (itemCategoryId != 0) {
			MasItemCategory masStoreItemCategory = new MasItemCategory();
			masStoreItemCategory.setId(itemCategoryId);
			masStoreItem.setItemCategory(masStoreItemCategory);
		}
		if (itemClassId != 0) {
			masStoreItem.setItemClass(new MasItemClass(itemClassId));
		}
		if(abc !="")
		{
			masStoreItem.setAbc(abc);
		}
		if(ved !="")
		{
			masStoreItem.setVed(ved);
		}
		
		if(standardAvailability!="")
		{
			masStoreItem.setStandardAvailability(standardAvailability);
		}
		masStoreItem.setDangerousDrug(dangerousDrug);
		masStoreItem.setControlledDrug(controlledDrug);
		masStoreItem.setHighValueDrug(highValueDrug);
		masStoreItem.setRateContractItem(rateContractItem);

		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		masStoreItemConversion.setId(itemConversionId);
		masStoreItem.setItemConversion(masStoreItemConversion);

	
	

		if (itemTypeId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(itemTypeId);
			masStoreItem.setDepartment(masDepartment);
		}
		if (!tempreture.equals("")) {
			masStoreItem.setTemprature(tempreture);
		}
		
		

		
		
			
			if (minTempreture != null && !minTempreture.equals("")) {
				masStoreItem.setTempratureMin(minTempreture);
					}
					if (maxTempreture != null && !maxTempreture.equals("")) {

						masStoreItem.setTempratureMax(maxTempreture);
							}
					
					
		
	
			if (minStock != null && !minStock.equals("")) {
		masStoreItem.setMinStock(minStock);
			}
			if (maxStock != null && !maxStock.equals("")) {
				masStoreItem.setMaxStock(maxStock);
					}
		
		masStoreItem.setLeadTime(leadTime);
		
		
		if (!standardAvailability.equals("")) {
			masStoreItem.setStandardAvailability(standardAvailability);
		}
	
		masStoreItem.setSpecification(specification);

		masStoreItem.setSlowMovingDays(slowMovingDays);
		masStoreItem.setFastMovingDays(fastMovingDays);
		masStoreItem.setNonMovingDays(nonMovingDays);
		masStoreItem.setExpiry(expiry);
		masStoreItem.setAllergy(allergy);

		Users users = new Users();
		users.setId(userId);
		masStoreItem.setLastChgBy(users);
	
		
		masStoreItem.setLastChgDate(currentDate);
		masStoreItem.setLastChgTime(currentTime);
		
		MasHospital h = new MasHospital();
		h.setId(hospitalId);
		masStoreItem.setHospital(h);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItem);
		/**
		 * Code for CSSD
		 * Code By Mukesh Narayan SIngh
		 * Date 03 Dec 2010
		 *//*
		
			List<CssdInstrumentMaster> cssdInstrumentMasterList=new ArrayList<CssdInstrumentMaster>();
			cssdInstrumentMasterList=getHibernateTemplate().find("from jkt.hms.masters.business.CssdInstrumentMaster as cim where cim.ItemId.Id="+itemId);
			int cssdId=0;
			if(cssdInstrumentMasterList.size()>0){
			 	for(CssdInstrumentMaster cInstrumentMaster:cssdInstrumentMasterList){
					cssdId=cInstrumentMaster.getId();
				}
				
			}
			if(masStoreItem.getCssdItem().equalsIgnoreCase("y"))
			 {		
				if(cssdId>0){
					CssdInstrumentMaster cssdInstrumentMaster = (CssdInstrumentMaster) getHibernateTemplate().get(
							CssdInstrumentMaster.class, cssdId);
					cssdInstrumentMaster.setInstrumentCode(masStoreItem.getPvmsNo());
					cssdInstrumentMaster.setInstrumentName(masStoreItem.getNomenclature());
					cssdInstrumentMaster.setLastChgBy(masStoreItem.getLastChgBy());
					cssdInstrumentMaster.setLastChgDate(masStoreItem.getLastChgDate());
					cssdInstrumentMaster.setLastChgTime(masStoreItem.getLastChgTime());
					cssdInstrumentMaster.setType("Instrument");
					try{
						int deptId=0;
						deptId = (Integer) generalMap.get("deptId");
						MasDepartment masdep =new MasDepartment();
						masdep.setId(2);
						cssdInstrumentMaster.setDepartment(masdep);
					}catch (Exception e) {
						e.printStackTrace();
					}
					cssdInstrumentMaster.setStatus("y");
					hbt.update(cssdInstrumentMaster);
				}
  				HibernateTemplate hbt1 = getHibernateTemplate();
				hbt1.setFlushModeName("FLUSH_AUTO");
				hbt1.setCheckWriteOperations(false);
				CssdInstrumentMaster cssdInstrumentMaster = new CssdInstrumentMaster();
				cssdInstrumentMaster.setItemId(masStoreItem);
				cssdInstrumentMaster.setInstrumentCode(masStoreItem.getPvmsNo());
				cssdInstrumentMaster.setInstrumentName(masStoreItem.getNomenclature());
				cssdInstrumentMaster.setLastChgBy(masStoreItem.getLastChgBy());
				cssdInstrumentMaster.setLastChgDate(masStoreItem.getLastChgDate());
				cssdInstrumentMaster.setLastChgTime(masStoreItem.getLastChgTime());
				cssdInstrumentMaster.setType("Instrument");
				int deptId=0;
				try{
						//int deptId=0;
						deptId = (Integer) generalMap.get("deptId");
						MasDepartment masdep =new MasDepartment();
						masdep.setId((Integer)generalMap.get("deptId"));
						cssdInstrumentMaster.setDepartment(masdep);
					}catch (Exception e) {
					e.printStackTrace();
				}
			cssdInstrumentMaster.setStatus("y");
				hbt1.save(cssdInstrumentMaster);

			}
			else if(masStoreItem.getCssdItem().equalsIgnoreCase("n")){
				if(cssdId>0){
					CssdInstrumentMaster cssdInstrumentMaster = new CssdInstrumentMaster();
 					cssdInstrumentMaster = (CssdInstrumentMaster) getHibernateTemplate().load(
							CssdInstrumentMaster.class, cssdId);			
		 			org.springframework.orm.hibernate3.HibernateTemplate hbt2 = getHibernateTemplate();
					hbt2.setFlushModeName("FLUSH_EAGER");
					hbt2.setCheckWriteOperations(false);
			 		hbt2.delete(cssdInstrumentMaster);
 				}
   			} 
	 	*//**
		 * Code for CSSD
		 * Code By Mukesh Narayan SIngh
		 * Date 03 Dec 2010
		 */
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean editItemConversionToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int itemConversionId = 0;
		String itemUnitName = "";
		@SuppressWarnings("unused")
		int conversionFactor1 = 0;
		int conversionFactor2 = 0;
		int purchaseUnitId = 0;
		int intermediateUnitid = 0;
		int issueUnitId = 0;
		int userId = 0;
		itemConversionId = (Integer) generalMap.get("id");
		itemUnitName = (String) generalMap.get("name");
		conversionFactor1 = (Integer) generalMap.get("conversionFactor1");
		conversionFactor2 = (Integer) generalMap.get("conversionFactor2");
		purchaseUnitId = (Integer) generalMap.get("purchaseUnitId");
		intermediateUnitid = (Integer) generalMap.get("intermediateUnitid");
		issueUnitId = (Integer) generalMap.get("issueUnitId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreItemConversion masStoreItemConversion = (MasStoreItemConversion) getHibernateTemplate()
				.get(MasStoreItemConversion.class, itemConversionId);

		masStoreItemConversion.setId(itemConversionId);
		masStoreItemConversion.setItemUnitName(itemUnitName);
		masStoreItemConversion.setConversionFactor1(conversionFactor1);
		masStoreItemConversion.setConversionFactor2(conversionFactor2);

		MasStoreUnit masStoreUnit1 = new MasStoreUnit();
		masStoreUnit1.setId(purchaseUnitId);
		masStoreItemConversion.setPurchaseUnit(masStoreUnit1);

		MasStoreUnit masStoreUnit2 = new MasStoreUnit();
		masStoreUnit2.setId(intermediateUnitid);
		masStoreItemConversion.setIntermediateUnit(masStoreUnit2);

		MasStoreUnit masStoreUnit3 = new MasStoreUnit();
		masStoreUnit3.setId(issueUnitId);
		masStoreItemConversion.setIssueUnit(masStoreUnit3);
		
		Users users = new Users();
		users.setId(userId);
		masStoreItemConversion.setLastChgBy(users);
		
		masStoreItemConversion.setLastChgDate(currentDate);
		masStoreItemConversion.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItemConversion);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteItemConversion(int itemConversionId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		masStoreItemConversion = (MasStoreItemConversion) getHibernateTemplate()
				.get(MasStoreItemConversion.class, itemConversionId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreItemConversion.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreItemConversion.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masStoreItemConversion.setLastChgBy(users);
		masStoreItemConversion.setLastChgDate(currentDate);
		masStoreItemConversion.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItemConversion);
		return dataDeleted;
	}

	// -------------------------------------- Budget Entry
	// ----------------------------

	public Map<String, Object> showBudgetJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> searchBudgetList = new ArrayList<MasStoreBudget>();
		List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreBudgetT> budgetDetailsList = new ArrayList<MasStoreBudgetT>();
		int grnStartNo = 0;
		int grnMaxNo = 0;
		try {
			searchBudgetList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBudget ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			financialList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreFinancial as msf where msf.Status = 'y' ");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			storeFyDocumentNoList = (List) getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreFyDocumentNo ");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getDepartment().getId() == 1) {
					if (grnMaxNo == 0) {
						grnMaxNo = grnStartNo;
						grnMaxNo = grnMaxNo + 1;
					} else {
						grnMaxNo = grnMaxNo + 1;
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Session session = (Session)getSession(); String sql = "SELECT
		 * b.sr_no,b.authority_letter_no,b.project_amount,b.budgeted_amount,b.
		 * additional_amount FROM mas_store_budget a, mas_store_budget_t b where
		 * a.budget_id=b.budget_id and financial_id = 2;"; budgetDetailsList =
		 * session.createSQLQuery(sql).list();
		 *
		 * //getHibernateTemplate().find("from
		 * jkt.hms.masters.business.MasStoreBudgetT as msb where
		 * msb.Budget.Financial.Id=13"); 
		 */

		map.put("financialList", financialList);
		map.put("searchBudgetList", searchBudgetList);
		// map.put("budgetDetailsList",budgetDetailsList);
		map.put("budgetCode", grnMaxNo);
		return map;
	}

	public boolean addBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList,
			Map<String, Object> infoMap) {

		boolean successfullyAdded = false;
		MasStoreBudget masStoreBudget2 = new MasStoreBudget();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");

		hbt.setCheckWriteOperations(false);
		if (!(infoMap.get("headerStored") + "").equals("yes")) {

			try {
				hbt.save(masStoreBudget);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {

			if (masStoreBudgetTList.size() > 0) {
				if ((infoMap.get("headerStored") + "").equals("yes")) {
					int id = Integer.parseInt("" + infoMap.get("budgetId"));
					masStoreBudget2.setId(id);
				}
				for (int i = 0; i < masStoreBudgetTList.size(); i++) {
					MasStoreBudgetT masStoreBudgetTObj = new MasStoreBudgetT();
					masStoreBudgetTObj = (MasStoreBudgetT) masStoreBudgetTList
							.get(i);
					if ((infoMap.get("headerStored") + "").equals("yes")) {
						masStoreBudgetTObj.setBudget(masStoreBudget2);
					} else {
						masStoreBudgetTObj.setBudget(masStoreBudget);
					}
					hbt.save(masStoreBudgetTObj);
				}
				int pageNo = 0;
				pageNo = Integer.parseInt("" + infoMap.get("pageNo"));
				if (pageNo == 1) {
					int StoreFyDocumentNoId = 1;
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
							.load(StoreFyDocumentNo.class, StoreFyDocumentNoId);
					HibernateTemplate hbt2 = getHibernateTemplate();
					hbt2.setFlushModeName("FLUSH_EAGER");
					hbt2.update(storeFyDocumentNo);
				}
			}
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public int getMasStoreBudgetId(int budgetCode) {
		int budgetId = 0;
		List<MasStoreBudget> list = new ArrayList<MasStoreBudget>();
		list = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreBudget as pod where pod.BudgetCode = '"
						+ budgetCode + "'");
		for (MasStoreBudget masStoreBudget2 : list) {
			budgetId = Integer.parseInt("" + masStoreBudget2.getId());
		}
		return budgetId;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMasStoreBudget(
			Map<String, Object> searchFieldMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> gridIndentHeaderList = new ArrayList<MasStoreBudget>();
		List<MasStoreBudgetT> gridIndentDetailList = new ArrayList<MasStoreBudgetT>();
		List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
		int financialId = 0;
		// List<MasStoreFinancial> gridFinancialList=null;

		try {
			if ((Integer) searchFieldMap.get("financialId") != 0) {
				financialId = (Integer) searchFieldMap.get("financialId");

				gridIndentDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreBudgetT ");
				gridIndentHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreBudget as msf where msf.Financial.Id='"
								+ financialId + "'");
				// financialList =getHibernateTemplate().find( "from
				// jkt.hms.masters.business.MasStoreFinancial as msf where
				// msf.Id = '"+financialId+"'");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		financialList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreFinancial as msf where msf.Status = 'y' ");
		// map.put("gridFinancialList",gridFinancialList);
		map.put("financialList", financialList);
		map.put("gridIndentDetailList", gridIndentDetailList);
		map.put("gridIndentHeaderList", gridIndentHeaderList);

		return map;
	}

	public Map<String, Object> getBudgetEntryModifyMap(int radio_str) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> gridStoreBudgetList = new ArrayList<MasStoreBudget>();
		List<MasStoreBudgetT> gridMasStoreBudgetTList = new ArrayList<MasStoreBudgetT>();
		List<MasStoreFinancial> gridMasStoreFinancialList = new ArrayList<MasStoreFinancial>();
		int id = 0;
		gridStoreBudgetList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreBudget as md where md.Id = '"
						+ radio_str + "'");
		for (MasStoreBudget masStoreBudget : gridStoreBudgetList) {
			id = masStoreBudget.getId();
		}

		gridMasStoreBudgetTList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreBudgetT st where st.Budget.Id = '"
						+ radio_str + "'");
		gridMasStoreFinancialList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreFinancial ");

		map.put("budgetList", gridStoreBudgetList);
		map.put("budgetTList", gridMasStoreBudgetTList);
		map.put("financialList", gridMasStoreFinancialList);
		map.put("budgetId", id);

		return map;

	}

	public Map<String, Object> getBudgetAndTUpdate(int budgetId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> gridMasStoreBudgetList = new ArrayList<MasStoreBudget>();
		List<MasStoreBudgetT> gridMasStoreBudgetTList = new ArrayList<MasStoreBudgetT>();
		List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();

		try {
			gridMasStoreBudgetList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBudget as sm where sm.Id='"
							+ budgetId + "'");
			gridMasStoreBudgetTList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBudgetT as st where st.Budget.Id='"
							+ budgetId + "'  ");
			financialList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreFinancial as mi where mi.Status = 'y' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("budgetList", gridMasStoreBudgetList);
		map.put("budgetTList", gridMasStoreBudgetTList);
		map.put("financialList", financialList);

		return map;
	}

	public boolean updateBudgetEntry(MasStoreBudget masStoreBudget,
			List<MasStoreBudgetT> masStoreBudgetTList) {
		boolean successfullyAdded = false;
		MasStoreBudget masStoreBudget2 = new MasStoreBudget();
		masStoreBudget2 = masStoreBudget;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");

		hbt.setCheckWriteOperations(false);

		try {

			hbt.update(masStoreBudget2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			if (masStoreBudgetTList.size() > 0) {
				for (int i = 0; i < masStoreBudgetTList.size(); i++) {
					MasStoreBudgetT masStoreBudgetTObj = new MasStoreBudgetT();
					masStoreBudgetTObj = (MasStoreBudgetT) masStoreBudgetTList
							.get(i);
					hbt.update(masStoreBudgetTObj);
				}

			}
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getFinancialYearDetails(int financialId) {
		List<MasStoreBudget> budgetDetailsList = new ArrayList<MasStoreBudget>();
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();
		List<MasStoreBudget> financialYearList = session
				.createCriteria(MasStoreBudget.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Financial.Id", financialId)).list();

		String sql = "SELECT b.sr_no,b.authority_letter_no,b.project_amount,b.budgeted_amount,b.additional_amount FROM mas_store_budget a, mas_store_budget_t b where a.budget_id=b.budget_id and financial_id = "
				+ financialId;
		budgetDetailsList = session.createSQLQuery(sql).list();

		// getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasStoreBudgetT as msb where
		// msb.Budget.Financial.Id=13");

		map.put("budgetDetailsList", budgetDetailsList);
		map.put("financialYearList", financialYearList);
		return map;
	}

	public boolean addBudgetDetails(Map<String, Object> budgetMap) {
		boolean flag = false;
		MasStoreBudgetT masStoreBudgetT = null;
		int budgetId = 0;

		float prevSpendAmount = 0.0f;
		float currentSpendAmount = 0.0f;
		float balanceAmount = 0.0f;

		String currentDate = "";
		String currentTime = "";

		int srNo = 0;

		if (budgetMap.get("masStoreBudgetT") != null) {
			masStoreBudgetT = (MasStoreBudgetT) budgetMap
					.get("masStoreBudgetT");
		}
		if (budgetMap.get("prevSpendAmount") != null) {
			prevSpendAmount = (Float) budgetMap.get("prevSpendAmount");
		}
		if (budgetMap.get("currentSpendAmount") != null) {
			currentSpendAmount = (Float) budgetMap.get("currentSpendAmount");
		}
		if (budgetMap.get("balanceAmount") != null) {
			balanceAmount = (Float) budgetMap.get("balanceAmount");
		}
		if (budgetMap.get("currentDate") != null) {
			currentDate = (String) budgetMap.get("currentDate");
		}
		if (budgetMap.get("currentTime") != null) {
			currentTime = (String) budgetMap.get("currentTime");
		}
		if (!budgetMap.get("budgetId").equals("0")) {
			budgetId = (Integer) budgetMap.get("budgetId");
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<MasStoreBudgetT> list = hbt
				.find("from jkt.hms.masters.business.MasStoreBudgetT as sm where sm.Budget.Id='"
						+ budgetId + "' order by sm.SrNo desc");

		if (list != null && list.size() > 0) {
			srNo = list.get(0).getSrNo().intValue();
		}
		masStoreBudgetT.setSrNo(++srNo);
		hbt.save(masStoreBudgetT);

		MasStoreBudget obj = (MasStoreBudget) hbt.load(MasStoreBudget.class,
				budgetId);
		/*
		 * obj.setSpendAmount(prevSpendAmount+currentSpendAmount);
		 * obj.setBalanceAmount(balanceAmount);
		 */

		obj.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		obj.setLastChgTime(currentTime);
		obj.setLastChgBy("admin");
		obj.setStatus("y");

		hbt.update(obj);
		flag = true;
		return flag;
	}

	public Map<String, Object> getConnection() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	// --------------------------------Mas Store
	// Group------------------------------
	public Map<String, Object> showStoreGroupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> searchGroupList = new ArrayList<MasStoreGroup>();
		List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList1 = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		try{
			
			searchGroupList = session.createCriteria(MasStoreGroup.class).list();
			departmentList1 = session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", 3)).add(Restrictions.eq("Status","y").ignoreCase()).list();
			gridDepartmentList1 = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchGroupList", searchGroupList);
		map.put("departmentList1", departmentList1);
		map.put("gridDepartmentList1", gridDepartmentList1);
		return map;
	}

	public boolean addStoreGroup(MasStoreGroup masStoreGroup) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masStoreGroup);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteStoreGroup(int groupId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasStoreGroup masStoreGroup = new MasStoreGroup();
		masStoreGroup = (MasStoreGroup) getHibernateTemplate().get(
				MasStoreGroup.class, groupId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masStoreGroup.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masStoreGroup.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masStoreGroup.setLastChgBy(users);
		masStoreGroup.setLastChgDate(currentDate);
		masStoreGroup.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreGroup);
		return dataDeleted;
	}

	public boolean editGroupToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String groupName = "";
		@SuppressWarnings("unused")
		String groupCode = "";
		int groupId = 0;
		int itemTypeId = 0;
		int userId = 0;
		groupId = (Integer) generalMap.get("id");
		groupCode = (String) generalMap.get("relationCode");
		groupName = (String) generalMap.get("name");
		itemTypeId = (Integer) generalMap.get("itemTypeId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasStoreGroup masStoreGroup = (MasStoreGroup) getHibernateTemplate()
				.get(MasStoreGroup.class, groupId);

		masStoreGroup.setId(groupId);
		masStoreGroup.setGroupName(groupName);
		if (itemTypeId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(itemTypeId);
			masStoreGroup.setDepartment(masDepartment);
		}
		
		
		Users users = new Users();
		users.setId(userId);
		masStoreGroup.setLastChgBy(users);
		masStoreGroup.setLastChgDate(currentDate);
		masStoreGroup.setLastChgTime(currentTime);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreGroup);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchStoreGroup(String groupCode,
			String groupName) {
		List<MasStoreGroup> searchGroupList = new ArrayList<MasStoreGroup>();
		Map<String, Object> groupFieldsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList1 = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		try {
			if ((groupName != null) || (groupCode == null)) {
				searchGroupList = session.createCriteria(MasStoreGroup.class).add(Restrictions.like("GroupName","%"+groupName+"%").ignoreCase()).addOrder(Order.asc("GroupName")).list();
			} else {
				searchGroupList =session.createCriteria(MasStoreGroup.class).add(Restrictions.like("GroupCode", "%"+groupCode+"%").ignoreCase()).addOrder(Order.asc("GroupCode")).list();
			}

			
			departmentList1 = session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", 3)).add(Restrictions.eq("Status","y").ignoreCase()).list();
			gridDepartmentList1 = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		groupFieldsMap.put("searchGroupList", searchGroupList);
		groupFieldsMap.put("gridDepartmentList1", gridDepartmentList1);
		groupFieldsMap.put("departmentList1", departmentList1);
		return groupFieldsMap;
	}

	public Map<String, Object> getSubAccountList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		try {
			List<FaMasSubLed> subAccountList = session
					.createCriteria(FaMasSubLed.class)
					.add(Restrictions.eq("Account.Id", box.getInt("accountId")))
					.list();
			map.put("subAccountList", subAccountList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@Override
	public Map<String, Object> getItemTypeList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasItemType> masItemTypeList = new ArrayList<MasItemType>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int group = 0;
		try {
			
			if(dataMap.get("group") != null ){
				group = (Integer)dataMap.get("group");
			}
			masItemTypeList = session.createCriteria(MasItemType.class)
						.createAlias("Group", "g")
						.add(Restrictions.eq("g.Id",group))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();



			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masItemTypeList", masItemTypeList);
		return map;

}

	@Override
	public Map<String, Object> getSectionList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSection> masStoreSectionList = new ArrayList<MasStoreSection>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int itemType = 0;
		try {
			
			if(dataMap.get("itemType") != null ){
				itemType = (Integer)dataMap.get("itemType");
			}
			masStoreSectionList = session.createCriteria(MasStoreSection.class)
						.createAlias("ItemType", "g")
						.add(Restrictions.eq("g.Id",itemType))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();



			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masStoreSectionList", masStoreSectionList);
		return map;

}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemGlobalMedJsp(int deptId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
			List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
			List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
			List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
			List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
			List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
			List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
			List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
			List<FaMasSubLed> faSubMasAccountList = new ArrayList<FaMasSubLed>();
			List<MasSalesTaxType> masSaleTaxTypeList = new ArrayList<MasSalesTaxType>();
			List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
			List<RouteOfAdministration> routeOfAdministrationList= new ArrayList<RouteOfAdministration>();
			String transactionSequenceName = "Item Code";
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			int orderNo = 0;
			sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",transactionSequenceName)).list();
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = sequenceNo + 1;
			
			// Criteria c = session.createCriteria(MasStoreItem.class)
			// .add(Restrictions.eq("Department.Id", deptId));
			// c.setFirstResult(0);
			// c.setMaxResults(1000);
			// searchItemList = c.list();
			
			masItemClassList= getHibernateTemplate()
			.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");


			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			hospitalParametersList=session.createCriteria(HospitalParameters.class).list();
			int departmentIdForRKS=0;
			int departmentIdForVBCH=0;
		 	if(hospitalParametersList.size()>0){
				 for (HospitalParameters hospitalParameters : hospitalParametersList) {
					departmentIdForRKS=hospitalParameters.getDeptIdStoreCodeRKS();
					departmentIdForVBCH=hospitalParameters.getDeptIdStoreCodeVBCH();
				}
		 	}
		 	
		 	searchItemList = session.createCriteria(MasStoreItem.class)
		 			.createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase())
		 			.list();
		 	//searchItemList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItem as inp  where inp.Status = 'Y' || inp.Status = 'y'");
			/*if(deptId==departmentIdForRKS || deptId==departmentIdForVBCH)
			{
			 searchItemList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreItem as inp");
			}
			else
			{
				searchItemList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreItem as inp where inp.Department.Id = "
								+ deptId);
 			}*/
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection as s where upper(s.Status) =upper('y')");
		
			List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
			masHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType as mc where upper(mc.Status) =upper('y')");
			map.put("masHospitalTypeList", masHospitalTypeList);
			
			itemTypeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemType as mc where upper(mc.Status) = upper('y')");
			itemCategoryList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemCategory as mc where upper(mc.Status) = upper('y')");
			itemConversionList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreItemConversion as mc where upper(mc.Status) = upper('y')");
			groupList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
			routeOfAdministrationList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.RouteOfAdministration as mg where upper(mg.Status) =upper('y')");
			map.put("faMasAccountList", faMasAccountList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("searchItemList", searchItemList);
			map.put("storeSectionList", sectionList);
			map.put("itemTypeList", itemTypeList);
			map.put("itemCategoryList", itemCategoryList);
			map.put("itemConversionList", itemConversionList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("masSaleTaxTypeList", masSaleTaxTypeList);
			map.put("manufacturerList", manufacturerList);
			map.put("storeSupplierList", supplierList);
			map.put("departmentList", departmentList);
			map.put("departmentList1", departmentList1);
			map.put("groupList", groupList);
			map.put("brandList", brandList);
			map.put("gridBrandList", gridBrandList);
			map.put("employeeList", employeeList);
			map.put("masItemClassList", masItemClassList);
			map.put("routeOfAdministrationList", routeOfAdministrationList);
			
			map.put("orderNo", orderNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> searchItemGlobalMed(String pvmsNo, String nomenclature) {
		List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> itemFieldsMap = new HashMap<String, Object>();
		List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		Session session = (Session) getSession();
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		List<RouteOfAdministration> routeOfAdministrationList= new ArrayList<RouteOfAdministration>();
		try {
			if ((pvmsNo != null)) {
	
				
			 	searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo")).createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase()).list();
			}

			if ((nomenclature != null)) {

			 	searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature")).createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase()).list();
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		masHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType as mc where upper(mc.Status) =upper('y')");
		itemFieldsMap.put("masHospitalTypeList", masHospitalTypeList);
		
		storeSectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreSection as mr where  upper(mr.Status) =upper('y')");
		
		itemTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemType as mbs where  upper(mbs.Status) =upper('y')");
		itemConversionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreItemConversion as mbs where upper(mbs.Status) =upper('y')");
		itemCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemCategory as mbs where  upper(mbs.Status) =upper('y')");
		
		groupList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
		masItemClassList= getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");

		routeOfAdministrationList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.RouteOfAdministration as mg where upper(mg.Status) =upper('y')");
		itemFieldsMap.put("searchItemList", searchItemList);
		itemFieldsMap.put("masItemClassList", masItemClassList);
		itemFieldsMap.put("storeSectionList", storeSectionList);
		itemFieldsMap.put("itemTypeList", itemTypeList);
		itemFieldsMap.put("itemConversionList", itemConversionList);
		itemFieldsMap.put("itemCategoryList", itemCategoryList);
		itemFieldsMap.put("groupList", groupList);
		itemFieldsMap.put("routeOfAdministrationList", routeOfAdministrationList);
		
		return itemFieldsMap;
	}

	public boolean addItemGlobalMed(MasStoreItem masItem,Map<String, Object> map) {

		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masItem);
		Session session = (Session) getSession();
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		String transactionSequenceName = "Item Code";
		sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",	transactionSequenceName)).list();
		TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		int orderNo = transactionSequence.getTransactionSequenceNumber();
		orderNo = orderNo + 1;
		
		int id = transactionSequence.getId();
		TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		transactionSequence2.setTransactionSequenceNumber(orderNo);
		hbt.update(transactionSequence2);
		
		successfullyAdded = true;
		return successfullyAdded;
		
		
	}

	@SuppressWarnings("unchecked")
	public boolean deleteItemGlobalMed(Integer itemId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasStoreItem masItem = new MasStoreItem();
			masItem = (MasStoreItem) getHibernateTemplate().load(
					MasStoreItem.class, itemId);
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			//Integer itemTypeId = masItem.getItemType().getId();
			//Integer itemGenericId = masItem.getItemGeneric().getId();
			if (generalMap.get("flag") != null) {
				/*List itemTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasItemType as itemType where itemType.Id='"
								+ itemTypeId + "' and itemType.Status='y'");
				List itemGenericList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasItemGeneric as itemGeneric where itemGeneric.Id='"
								+ itemGenericId
								+ "' and itemGeneric.Status='y'");*/

				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masItem.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masItem.setStatus("y");
					dataDeleted = false;
				}
			}
			Users users = new Users();
			users.setId(userId);
			masItem.setLastChgBy(users);
		
			masItem.setLastChgDate(currentDate);
			masItem.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}
	public boolean editItemGlobalMed(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		int itemId = 0;
		int groupId = 0;
		int itemClassId = 0;
		int sectionId = 0;
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemConversionId = 0;
		int expiryDays = 0;
		String pvms = "";
		String commonName = "";
		String dangerousDrug = "";
		String phItem="";
		String controlledDrug = "";
		String highValueDrug = "";
		String rateContractItem = "";
		String otc = "";
		int hospitalId = 0;
		int userId = 0;
		String specification = "";
		String nomenclature = "";
		String tempreture = "";
		BigDecimal minTempreture  = null;
		BigDecimal maxTempreture  = null;
		BigDecimal uomQty=null;
		int route=0;
		String tapered="";
		// added by amit das on 21-11-2016
		String mixable = null;
		int mixtureQuantity = 0;
		String mixtureUnit = null;
		
		String standardAvailability="";
		String expiry="";
		itemId = (Integer) generalMap.get("id");
		String insulin="";
		//added by govind 17-11-2016
		String bagQuantity="";
		if (generalMap.get("bagQuantity") != null) {
			bagQuantity = (String)generalMap.get("bagQuantity");
		}
		//added by govind 17-11-2016 end
		pvms = (String) generalMap.get("pvms");
		commonName = (String) generalMap.get("commonName");
		if(generalMap.get("maxTempreture") != null){
			maxTempreture = (BigDecimal) generalMap.get("maxTempreture");
		}
		tempreture = (String) generalMap.get("tempreture");
		if(generalMap.get("minTempreture") != null){
			minTempreture = (BigDecimal) generalMap.get("minTempreture");
		}
		if(generalMap.get("uomQty") != null){
			uomQty = (BigDecimal) generalMap.get("uomQty");
		}
		phItem= (String) generalMap.get("phItem");
		nomenclature = (String) generalMap.get("name");
		itemClassId = (Integer) generalMap.get("itemClassId");
		sectionId = (Integer) generalMap.get("sectionId");
		groupId = (Integer) generalMap.get("groupId");
		itemTypeId = (Integer) generalMap.get("itemTypeId");
		itemCategoryId = (Integer) generalMap.get("itemCategoryId");
		itemConversionId = (Integer) generalMap.get("itemConversionId");
		pvms = (String) generalMap.get("pvms");
		dangerousDrug = (String) generalMap.get("dangerousDrug");
		controlledDrug = (String) generalMap.get("controlledDrug");
		highValueDrug = (String) generalMap.get("highValueDrug");
		rateContractItem = (String) generalMap.get("rateContractItem");
		otc = (String) generalMap.get("otc");
		insulin= (String) generalMap.get("insulin");
		hospitalId = (Integer) generalMap.get("hospitalId");
		userId= (Integer) generalMap.get("userId");
		specification = (String) generalMap.get("specification");
		expiry = (String) generalMap.get("expiry");
		route = (Integer) generalMap.get("route");
		tapered = (String) generalMap.get("tapered");
		// added by amit das on 21-11-2016
		mixable = (String) generalMap.get("mixable");
		if(null !=generalMap.get("mixtureQuantity"))
		mixtureQuantity = (Integer) generalMap.get("mixtureQuantity");
		
		if(null !=generalMap.get("mixtureUnit"))
			mixtureUnit = (String) generalMap.get("mixtureUnit");
		
		
		currentDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		standardAvailability = (String) generalMap.get("standardAvailability");
		String kmscl_item_code="";
		kmscl_item_code = (String) generalMap.get("kmscl_item_code");
		String kmsclCategory = "";
		if(generalMap.get("kmsclCategory") != null){
			kmsclCategory = (String)generalMap.get("kmsclCategory");
		}
		String dispensingUnit ="";
		if(generalMap.get("dispensingUnit") != null){
			dispensingUnit = (String)generalMap.get("dispensingUnit");
		}
		if(generalMap.get("expiryDays") != null){
			expiryDays = (Integer)generalMap.get("expiryDays");
		}
		MasStoreItem masStoreItem = (MasStoreItem) getHibernateTemplate().get(
				MasStoreItem.class, itemId);

		masStoreItem.setId(itemId);
		masStoreItem.setNomenclature(nomenclature);
		masStoreItem.setPvmsNo(pvms);
		masStoreItem.setCommonName(commonName);
		masStoreItem.setExpiryDays(expiryDays);

		MasStoreSection masStoreSection = new MasStoreSection();
		masStoreSection.setId(sectionId);
		masStoreItem.setSection(masStoreSection);
		masStoreItem.setPhItem(phItem);
		masStoreItem.setBagQuantity(bagQuantity);
		
		// added by amit das on 21-11-2016
		masStoreItem.setMixable(mixable);
		masStoreItem.setMixtureQuantity(mixtureQuantity);
		masStoreItem.setMixtureUnit(mixtureUnit);
	
		masStoreItem.setKmsclItemCode(kmscl_item_code);
		System.out.println("kmsclCategory=="+kmsclCategory);
		if(dispensingUnit != null){
			masStoreItem.setDispUnit(dispensingUnit);
		}
		
			masStoreItem.setADispQty(uomQty);
					

		if(kmsclCategory != null){
			masStoreItem.setKmsclCategory(kmsclCategory);
		}
	
		
		
		if (route != 0) {
			 RouteOfAdministration routeOfAdministration = new RouteOfAdministration();
			 routeOfAdministration.setId(route);
			 masStoreItem.setRoute(routeOfAdministration);
		}
		masStoreItem.setTapered(tapered);
	
		if (groupId != 0) {
			MasStoreGroup masStoreGroup = new MasStoreGroup();
			masStoreGroup.setId(groupId);
			masStoreItem.setGroup(masStoreGroup);
		} else {
			masStoreItem.setGroup(null);
		}

		 MasItemType masStoreItemType = new MasItemType();
		 masStoreItemType.setId(itemTypeId);
		 masStoreItem.setItemType(masStoreItemType);

		if (itemCategoryId != 0) {
			MasItemCategory masStoreItemCategory = new MasItemCategory();
			masStoreItemCategory.setId(itemCategoryId);
			masStoreItem.setItemCategory(masStoreItemCategory);
		}
		if (itemClassId != 0) {
			masStoreItem.setItemClass(new MasItemClass(itemClassId));
		}
		
		
		if(standardAvailability!="")
		{
			masStoreItem.setStandardAvailability(standardAvailability);
		}
		masStoreItem.setDangerousDrug(dangerousDrug);
		masStoreItem.setControlledDrug(controlledDrug);
		masStoreItem.setHighValueDrug(highValueDrug);
		masStoreItem.setRateContractItem(rateContractItem);
		masStoreItem.setOtcType(otc);

		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		masStoreItemConversion.setId(itemConversionId);
		masStoreItem.setItemConversion(masStoreItemConversion);

		masStoreItem.setInsulinInjection(insulin);
	

	/*	if (itemTypeId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(itemTypeId);
			masStoreItem.setDepartment(masDepartment);
		}*/
		if (!tempreture.equals("")) {
			masStoreItem.setTemprature(tempreture);
		}
		
		

		
		
			
			if (minTempreture != null && !minTempreture.equals("")) {
				masStoreItem.setTempratureMin(minTempreture);
					}
					if (maxTempreture != null && !maxTempreture.equals("")) {

						masStoreItem.setTempratureMax(maxTempreture);
							}
				


		
		
		if (!standardAvailability.equals("")) {
			masStoreItem.setStandardAvailability(standardAvailability);
		}
	
		masStoreItem.setSpecification(specification);


		masStoreItem.setExpiry(expiry);


		Users users = new Users();
		users.setId(userId);
		masStoreItem.setLastChgBy(users);
	
		
		masStoreItem.setLastChgDate(currentDate);
		masStoreItem.setLastChgTime(currentTime);
		
		MasHospital h = new MasHospital();
		h.setId(hospitalId);
		masStoreItem.setHospital(h);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItem);
		
		dataUpdated = true;
		return dataUpdated;

	}
	
	//-----------------------------
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showItemGlobalNonMedJsp(int deptId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
			List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
			List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
			List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
			List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
			List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
			List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
			List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
			List<FaMasSubLed> faSubMasAccountList = new ArrayList<FaMasSubLed>();
			List<MasSalesTaxType> masSaleTaxTypeList = new ArrayList<MasSalesTaxType>();
			List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
			String transactionSequenceName = "Item Code";
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			int orderNo = 0;
			sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",transactionSequenceName)).list();
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = sequenceNo + 1;
			
			// Criteria c = session.createCriteria(MasStoreItem.class)
			// .add(Restrictions.eq("Department.Id", deptId));
			// c.setFirstResult(0);
			// c.setMaxResults(1000);
			// searchItemList = c.list();
			
			masItemClassList= getHibernateTemplate()
			.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");


			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			hospitalParametersList=session.createCriteria(HospitalParameters.class).list();
			int departmentIdForRKS=0;
			int departmentIdForVBCH=0;
		 	if(hospitalParametersList.size()>0){
				 for (HospitalParameters hospitalParameters : hospitalParametersList) {
					departmentIdForRKS=hospitalParameters.getDeptIdStoreCodeRKS();
					departmentIdForVBCH=hospitalParameters.getDeptIdStoreCodeVBCH();
				}
		 	}
			String[] typeArr = {"NON MEDICAL CONSUMABLE","NON MEDICAL ASSET","MEDICAL ASSET"};
		 	//searchItemList = session.createCriteria(MasStoreItem.class).list();
			searchItemList = session.createCriteria(MasStoreItem.class).createAlias("ItemType", "it")
					//.add(Restrictions.eq("it.ItemTypeName","Non medicinal").ignoreCase())
					.add(Restrictions.in("it.ItemTypeName",typeArr)).list();
		 	//searchItemList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItem as inp  where inp.Status = 'Y' || inp.Status = 'y'");
			/*if(deptId==departmentIdForRKS || deptId==departmentIdForVBCH)
			{
			 searchItemList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreItem as inp");
			}
			else
			{
				searchItemList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreItem as inp where inp.Department.Id = "
								+ deptId);
 			}*/
			
			List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
			masHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType as mc where upper(mc.Status) =upper('y')");
			map.put("masHospitalTypeList", masHospitalTypeList);
			
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection as s where upper(s.Status) =upper('y')");
			
			itemTypeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemType as mc where upper(mc.Status) =upper('y')");
			itemCategoryList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemCategory as mc where upper(mc.Status) =upper('y')");
			itemConversionList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreItemConversion as mc where upper(mc.Status) =upper('y')");
			groupList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");

			map.put("faMasAccountList", faMasAccountList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("searchItemList", searchItemList);
			map.put("storeSectionList", sectionList);
			map.put("itemTypeList", itemTypeList);
			map.put("itemCategoryList", itemCategoryList);
			map.put("itemConversionList", itemConversionList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("masSaleTaxTypeList", masSaleTaxTypeList);
			map.put("manufacturerList", manufacturerList);
			map.put("storeSupplierList", supplierList);
			map.put("departmentList", departmentList);
			map.put("departmentList1", departmentList1);
			map.put("groupList", groupList);
			map.put("brandList", brandList);
			map.put("gridBrandList", gridBrandList);
			map.put("employeeList", employeeList);
			map.put("masItemClassList", masItemClassList);
			map.put("orderNo", orderNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> searchItemGlobalNonMed(String pvmsNo, String nomenclature) {
		List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> itemFieldsMap = new HashMap<String, Object>();
		List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		Session session = (Session) getSession();
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		String[] typeArr = {"NON MEDICAL CONSUMABLE","NON MEDICAL ASSET","MEDICAL ASSET"};
		
		try {
			if ((pvmsNo != null)) {
				System.out.println("@#@#@# " +pvmsNo);
				
				
				//searchItemList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo")).list();
				searchItemList = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase())
						.addOrder(Order.asc("PvmsNo")).createAlias("ItemType", "it")
						//.add(Restrictions.eq("it.ItemTypeName","Non medicinal")
						.add(Restrictions.in("it.ItemTypeName",typeArr)
								).list();
				
			}
			System.out.println("SSS     "+searchItemList.size());

			if ((nomenclature != null)) {
				//searchItemList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature")).list();
				
				searchItemList = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature")).createAlias("ItemType", "it")
						/*.add(Restrictions.eq("it.ItemTypeName","Non medicinal").ignoreCase())*/
						.add(Restrictions.in("it.ItemTypeName",typeArr)).list();
				
			}
			
			System.out.println("AAAAAAAAAA     "+searchItemList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		masHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType as mc where upper(mc.Status) =upper('y')");
		itemFieldsMap.put("masHospitalTypeList", masHospitalTypeList);
		
		storeSectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreSection as mr where upper(mr.Status) =upper('y')");
		
		itemTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemType as mbs where upper(mbs.Status) =upper('y')");
		itemConversionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreItemConversion as mbs where upper(mbs.Status) =upper('y')");
		itemCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemCategory as mbs where upper(mbs.Status) =upper('y')"); 
		
		groupList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
		masItemClassList= getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasItemClass where  upper(Status) =upper('y')");


		itemFieldsMap.put("searchItemList", searchItemList);
		itemFieldsMap.put("masItemClassList", masItemClassList);
		itemFieldsMap.put("storeSectionList", storeSectionList);
		itemFieldsMap.put("itemTypeList", itemTypeList);
		itemFieldsMap.put("itemConversionList", itemConversionList);
		itemFieldsMap.put("itemCategoryList", itemCategoryList);
		itemFieldsMap.put("groupList", groupList);
		
		return itemFieldsMap;
	}

	public boolean addItemGlobalNonMed(MasStoreItem masItem,Map<String, Object> map) {

		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masItem);
		Session session = (Session) getSession();
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		String transactionSequenceName = "Item Code";
		sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",	transactionSequenceName)).list();
		TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		int orderNo = transactionSequence.getTransactionSequenceNumber();
		orderNo = orderNo + 1;
		
		int id = transactionSequence.getId();
		TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		transactionSequence2.setTransactionSequenceNumber(orderNo);
		hbt.update(transactionSequence2);
		
		successfullyAdded = true;
		return successfullyAdded;
		
		
	}

	@SuppressWarnings("unchecked")
	public boolean deleteItemGlobalNonMed(Integer itemId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasStoreItem masItem = new MasStoreItem();
			masItem = (MasStoreItem) getHibernateTemplate().load(
					MasStoreItem.class, itemId);
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			//Integer itemTypeId = masItem.getItemType().getId();
			//Integer itemGenericId = masItem.getItemGeneric().getId();
			if (generalMap.get("flag") != null) {
				/*List itemTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasItemType as itemType where itemType.Id='"
								+ itemTypeId + "' and itemType.Status='y'");
				List itemGenericList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasItemGeneric as itemGeneric where itemGeneric.Id='"
								+ itemGenericId
								+ "' and itemGeneric.Status='y'");*/

				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masItem.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masItem.setStatus("y");
					dataDeleted = false;
				}
			}
			Users users = new Users();
			users.setId(userId);
			masItem.setLastChgBy(users);
		
			masItem.setLastChgDate(currentDate);
			masItem.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}
	public boolean editItemGlobalNonMed(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		int itemId = 0;
		int groupId = 0;
		int itemClassId = 0;
		int sectionId = 0;
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemConversionId = 0;
		String pvms = "";
		String commonName = "";
		
		int hospitalId = 0;
		int userId = 0;
		String specification = "";
		String nomenclature = "";
		
		String standardAvailability="";
		String expiry="";
		itemId = (Integer) generalMap.get("id");
		
		pvms = (String) generalMap.get("pvms");
		commonName = (String) generalMap.get("commonName");
		
		nomenclature = (String) generalMap.get("name");
		itemClassId = (Integer) generalMap.get("itemClassId");
		sectionId = (Integer) generalMap.get("sectionId");
		groupId = (Integer) generalMap.get("groupId");
		itemTypeId = (Integer) generalMap.get("itemTypeId");
		itemCategoryId = (Integer) generalMap.get("itemCategoryId");
		itemConversionId = (Integer) generalMap.get("itemConversionId");
		pvms = (String) generalMap.get("pvms");
		
		hospitalId = (Integer) generalMap.get("hospitalId");
		userId= (Integer) generalMap.get("userId");
		specification = (String) generalMap.get("specification");
		expiry = (String) generalMap.get("expiry");
		currentDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		standardAvailability = (String) generalMap.get("standardAvailability");
		String kmscl_item_code="";
		kmscl_item_code = (String) generalMap.get("kmscl_item_code");
		String kmsclCategory ="";
		if(generalMap.get("kmsclCategory") != null){
			kmsclCategory = (String)generalMap.get("kmsclCategory");
		}
		MasStoreItem masStoreItem = (MasStoreItem) getHibernateTemplate().get(
				MasStoreItem.class, itemId);

		masStoreItem.setId(itemId);
		masStoreItem.setNomenclature(nomenclature);
		masStoreItem.setPvmsNo(pvms);
		masStoreItem.setCommonName(commonName);

		MasStoreSection masStoreSection = new MasStoreSection();
		masStoreSection.setId(sectionId);
		masStoreItem.setSection(masStoreSection);

		masStoreItem.setKmsclItemCode(kmscl_item_code);
		if(kmsclCategory != null){
			masStoreItem.setKmsclCategory(kmsclCategory);
		}
		if (groupId != 0) {
			MasStoreGroup masStoreGroup = new MasStoreGroup();
			masStoreGroup.setId(groupId);
			masStoreItem.setGroup(masStoreGroup);
		} else {
			masStoreItem.setGroup(null);
		}

		 MasItemType masStoreItemType = new MasItemType();
		 masStoreItemType.setId(itemTypeId);
		 masStoreItem.setItemType(masStoreItemType);

		if (itemCategoryId != 0) {
			MasItemCategory masStoreItemCategory = new MasItemCategory();
			masStoreItemCategory.setId(itemCategoryId);
			masStoreItem.setItemCategory(masStoreItemCategory);
		}
		if (itemClassId != 0) {
			masStoreItem.setItemClass(new MasItemClass(itemClassId));
		}
		
		
		if(standardAvailability!="")
		{
			masStoreItem.setStandardAvailability(standardAvailability);
		}
	
		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		masStoreItemConversion.setId(itemConversionId);
		masStoreItem.setItemConversion(masStoreItemConversion);

	
	

		if (itemTypeId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(itemTypeId);
			masStoreItem.setDepartment(masDepartment);
		}
		
		if (!standardAvailability.equals("")) {
			masStoreItem.setStandardAvailability(standardAvailability);
		}
	
		masStoreItem.setSpecification(specification);


		masStoreItem.setExpiry(expiry);


		Users users = new Users();
		users.setId(userId);
		masStoreItem.setLastChgBy(users);
	
		
		masStoreItem.setLastChgDate(currentDate);
		masStoreItem.setLastChgTime(currentTime);
		
		MasHospital h = new MasHospital();
		h.setId(hospitalId);
		masStoreItem.setHospital(h);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masStoreItem);
		
		dataUpdated = true;
		return dataUpdated;

	}

	@Override
	public boolean editItemLocalMed(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		int itemId = 0;
	//	int groupId = 0;
//		int itemClassId = 0;
//		int sectionId = 0;
//		int itemGenericId = 0;
//		int itemTypeId = 0;
//		int itemCategoryId = 0;
//		int itemConversionId = 0;
		String pvms = "";
//		String commonName = "";
//		String dangerousDrug = "";
//		String controlledDrug = "";
//		String highValueDrug = "";
//		String rateContractItem = "";
		BigDecimal minStock  = new BigDecimal(0);
		BigDecimal maxStock  = new BigDecimal(0);
		String leadTime = "";
		int hospitalId = 0;
		int userId = 0;
		String rol="";
		int route=0;
		String tapered="";
	//	String specification = "";
		String nomenclature = "";
	//	String allergy = "";
		int slowMovingDays = 0;
		int fastMovingDays = 0;
		int nonMovingDays = 0;
	//	String tempreture = "";
	//	BigDecimal minTempreture  = new BigDecimal(0);
	//	BigDecimal maxTempreture  = new BigDecimal(0);
		String abc = "";
		String ved ="";
	//	String standardAvailability="";
	//	String expiry="";
		itemId = (Integer) generalMap.get("id");
		ved = (String) generalMap.get("ved");
		abc = (String) generalMap.get("abc");
//		pvms = (String) generalMap.get("pvms");
		rol = (String) generalMap.get("rol");
		route = (Integer) generalMap.get("route");
		tapered = (String) generalMap.get("tapered");
		
	//	commonName = (String) generalMap.get("commonName");
	//	maxTempreture = (BigDecimal) generalMap.get("maxTempreture");
	//	tempreture = (String) generalMap.get("tempreture");
	//	minTempreture = (BigDecimal) generalMap.get("minTempreture");
	//	nomenclature = (String) generalMap.get("name");
	//	itemClassId = (Integer) generalMap.get("itemClassId");
	//	sectionId = (Integer) generalMap.get("sectionId");
	//	groupId = (Integer) generalMap.get("groupId");
	//	itemGenericId = (Integer) generalMap.get("itemGenericId");
	//	itemTypeId = (Integer) generalMap.get("itemTypeId");
	//	itemCategoryId = (Integer) generalMap.get("itemCategoryId");
	//	itemConversionId = (Integer) generalMap.get("itemConversionId");
		pvms = (String) generalMap.get("pvms");
	//	dangerousDrug = (String) generalMap.get("dangerousDrug");
	//	controlledDrug = (String) generalMap.get("controlledDrug");
	//	highValueDrug = (String) generalMap.get("highValueDrug");
	//	rateContractItem = (String) generalMap.get("rateContractItem");
		minStock = (BigDecimal) generalMap.get("minStock");
		maxStock = (BigDecimal) generalMap.get("maxStock");
		leadTime = (String) generalMap.get("leadTime");
		hospitalId = (Integer) generalMap.get("hospitalId");
		userId= (Integer) generalMap.get("userId");
	//	specification = (String) generalMap.get("specification");
		slowMovingDays = (Integer) generalMap.get("slowMovingDays");
		fastMovingDays = (Integer) generalMap.get("fastMovingDays");
		nonMovingDays = (Integer) generalMap.get("nonMovingDays");
	//	expiry = (String) generalMap.get("expiry");
	//	allergy = (String) generalMap.get("allergy");
		currentDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		String kmscl_item_code="";
		kmscl_item_code = (String) generalMap.get("kmscl_item_code");
		String kmsclCategory ="";
		if(generalMap.get("kmsclCategory") != null){
			kmsclCategory = (String)generalMap.get("kmsclCategory");
		}
		int storeItemDetailsId = 0;
		if( generalMap.get("storeItemDetailsId")!=null){
			storeItemDetailsId = (Integer) generalMap.get("storeItemDetailsId");
		}
		
	//	standardAvailability = (String) generalMap.get("standardAvailability");
	/*	MasStoreItem masStoreItem = (MasStoreItem) getHibernateTemplate().get(
				MasStoreItem.class, itemId);

		masStoreItem.setId(itemId);*/
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasStoreItemDetails storeItemDetails = new MasStoreItemDetails();
		
		if(storeItemDetailsId!=0){
			storeItemDetails = (MasStoreItemDetails)hbt.load(MasStoreItemDetails.class,storeItemDetailsId);
		}
		
		
		MasStoreItem masStoreItem = new MasStoreItem();
		masStoreItem.setId(itemId);
		storeItemDetails.setItem(masStoreItem);
		if(abc !="")
		{
			storeItemDetails.setAbc(abc);
		}
		if(ved !="")
		{
			storeItemDetails.setVed(ved);
		}
		//masStoreItem.setKmsclItemCode(kmscl_item_code);
		/*if(standardAvailability!="")
		{
			masStoreItem.setStandardAvailability(standardAvailability);
		}
		masStoreItem.setDangerousDrug(dangerousDrug);
		masStoreItem.setControlledDrug(controlledDrug);
		masStoreItem.setHighValueDrug(highValueDrug);
		masStoreItem.setRateContractItem(rateContractItem);

		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		masStoreItemConversion.setId(itemConversionId);
		masStoreItem.setItemConversion(masStoreItemConversion);

	
	

		if (itemTypeId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(itemTypeId);
			masStoreItem.setDepartment(masDepartment);
		}
		if (!tempreture.equals("")) {
			masStoreItem.setTemprature(tempreture);
		}*/
		if (!rol.equals("")) {
			storeItemDetails.setRol(rol);
		}
		
	
		
		
		/*	
			if (minTempreture != null && !minTempreture.equals("")) {
				masStoreItem.setTempratureMin(minTempreture);
					}
					if (maxTempreture != null && !maxTempreture.equals("")) {

						masStoreItem.setTempratureMax(maxTempreture);
							}
					
					*/
		
	
			if (minStock != null && !minStock.equals("")) {
				storeItemDetails.setMinStock(minStock);
			}
			if (maxStock != null && !maxStock.equals("")) {
				storeItemDetails.setMaxStock(maxStock);
					}
		
			storeItemDetails.setLeadTime(leadTime);
		
		
	/*	if (!standardAvailability.equals("")) {
			masStoreItem.setStandardAvailability(standardAvailability);
		}*/
	
//		masStoreItem.setSpecification(specification);
			
			storeItemDetails.setSlowMovingDays(slowMovingDays);
			storeItemDetails.setFastMovingDays(fastMovingDays);
			storeItemDetails.setNonMovingDays(nonMovingDays);
	//	masStoreItem.setExpiry(expiry);
	//	masStoreItem.setAllergy(allergy);

		/*Users users = new Users();
		users.setId(userId);
		masStoreItem.setLastChgBy(users);
	
		
		masStoreItem.setLastChgDate(currentDate);
		masStoreItem.setLastChgTime(currentTime);*/
		
		MasHospital h = new MasHospital();
		h.setId(hospitalId);
		storeItemDetails.setHospital(h);

		
		hbt.saveOrUpdate(storeItemDetails);
		
		dataUpdated = true;
		return dataUpdated;

	}
	public Map<String, Object> searchItemLocalMed(String pvmsNo, String nomenclature) {
		List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> itemFieldsMap = new HashMap<String, Object>();
		List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		Session session = (Session) getSession();
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		try {
			if ((pvmsNo != null)) {

				
				//searchItemList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo")).list();
				searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo"))
						.createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase())
						//.createAlias("Section", "s").add(Restrictions.eq("s.SectionName","Medicinal").ignoreCase())
						.list();
				
				
			}

			if ((nomenclature != null)) {
				//searchItemList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature")).list();
				searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature"))
						.createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase())
						//.createAlias("Section", "s").add(Restrictions.eq("s.SectionName","Medicinal").ignoreCase())
						.list();
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		storeSectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreSection as mr where  upper(mr.Status) =upper('y')");
	
		itemTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemType as mbs where upper(mbs.Status) =upper('y')"); 
		itemConversionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreItemConversion as mbs where upper(mbs.Status) =upper('y')");
		itemCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemCategory as mbs where upper(mbs.Status) =upper('y')");
		
		groupList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
		masItemClassList= getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");

			
		
		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		masHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType as mc where upper(mc.Status) =upper('y')");
		itemFieldsMap.put("masHospitalTypeList", masHospitalTypeList);

		itemFieldsMap.put("searchItemList", searchItemList);
		itemFieldsMap.put("masItemClassList", masItemClassList);
		itemFieldsMap.put("storeSectionList", storeSectionList);
		itemFieldsMap.put("itemTypeList", itemTypeList);
		itemFieldsMap.put("itemConversionList", itemConversionList);
		itemFieldsMap.put("itemCategoryList", itemCategoryList);
		itemFieldsMap.put("groupList", groupList);
		
		return itemFieldsMap;
	}
	@SuppressWarnings("unchecked")
	public boolean deleteItemLocalMed(Integer itemId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasStoreItem masItem = new MasStoreItem();
			masItem = (MasStoreItem) getHibernateTemplate().load(
					MasStoreItem.class, itemId);
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (generalMap.get("flag") != null) {
			

				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masItem.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masItem.setStatus("y");
					dataDeleted = false;
				}
			}
			Users users = new Users();
			users.setId(userId);
			masItem.setLastChgBy(users);
		
			masItem.setLastChgDate(currentDate);
			masItem.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}
	
	public Map<String, Object> showItemLocalMedJsp(int deptId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
			List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
			List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
			List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
			List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
			List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
			List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
			List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
			List<FaMasSubLed> faSubMasAccountList = new ArrayList<FaMasSubLed>();
			List<MasSalesTaxType> masSaleTaxTypeList = new ArrayList<MasSalesTaxType>();
			List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
			String transactionSequenceName = "Item Code";
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			int orderNo = 0;
			sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",transactionSequenceName)).list();
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = sequenceNo + 1;
			
			// Criteria c = session.createCriteria(MasStoreItem.class)
			// .add(Restrictions.eq("Department.Id", deptId));
			// c.setFirstResult(0);
			// c.setMaxResults(1000);
			// searchItemList = c.list();
			
			masItemClassList= getHibernateTemplate()
			.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");


			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			hospitalParametersList=session.createCriteria(HospitalParameters.class).list();
			int departmentIdForRKS=0;
			int departmentIdForVBCH=0;
		 	if(hospitalParametersList.size()>0){
				 for (HospitalParameters hospitalParameters : hospitalParametersList) {
					departmentIdForRKS=hospitalParameters.getDeptIdStoreCodeRKS();
					departmentIdForVBCH=hospitalParameters.getDeptIdStoreCodeVBCH();
				}
		 	}
		 	searchItemList = session.createCriteria(MasStoreItem.class)
		 			.createAlias("ItemType", "it").add(Restrictions.eq("it.ItemTypeName","MEDICAL CONSUMABLE").ignoreCase())
		 			.list();
		 //	searchItemList = session.createCriteria(MasStoreItem.class).list();
		 	//searchItemList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItem as inp  where inp.Status = 'Y' || inp.Status = 'y'");
			/*if(deptId==departmentIdForRKS || deptId==departmentIdForVBCH)
			{
			 searchItemList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreItem as inp");
			}
			else
			{
				searchItemList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreItem as inp where inp.Department.Id = "
								+ deptId);
 			}*/
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection where upper(Status) =upper('y')");
		
			itemTypeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemType as mc where upper(mc.Status) =upper('y')");
			itemCategoryList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemCategory as mc where upper(mc.Status) =upper('y')");
			itemConversionList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreItemConversion as mc where upper(mc.Status) =upper('y')");
			groupList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
			
			
			List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
			masHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType as mc where upper(mc.Status) =upper('y')");
			map.put("masHospitalTypeList", masHospitalTypeList);
			
			map.put("faMasAccountList", faMasAccountList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("searchItemList", searchItemList);
			map.put("storeSectionList", sectionList);
			map.put("itemTypeList", itemTypeList);
			map.put("itemCategoryList", itemCategoryList);
			map.put("itemConversionList", itemConversionList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("masSaleTaxTypeList", masSaleTaxTypeList);
			map.put("manufacturerList", manufacturerList);
			map.put("storeSupplierList", supplierList);
			map.put("departmentList", departmentList);
			map.put("departmentList1", departmentList1);
			map.put("groupList", groupList);
			map.put("brandList", brandList);
			map.put("gridBrandList", gridBrandList);
			map.put("employeeList", employeeList);
			map.put("masItemClassList", masItemClassList);
			map.put("orderNo", orderNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	

	@Override
	public boolean editItemLocalNonMed(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		int itemId = 0;
	//	int groupId = 0;
//		int itemClassId = 0;
//		int sectionId = 0;
//		int itemGenericId = 0;
//		int itemTypeId = 0;
//		int itemCategoryId = 0;
//		int itemConversionId = 0;
	//	String pvms = "";
//		String commonName = "";
//		String dangerousDrug = "";
//		String controlledDrug = "";
//		String highValueDrug = "";
//		String rateContractItem = "";
		BigDecimal minStock  = new BigDecimal(0);
		BigDecimal maxStock  = new BigDecimal(0);
		String leadTime = "";
		int hospitalId = 0;
		int userId = 0;
		String rol="";
	//	String specification = "";
	//	String nomenclature = "";
	//	String allergy = "";
		int slowMovingDays = 0;
		int fastMovingDays = 0;
		int nonMovingDays = 0;
	//	String tempreture = "";
	//	BigDecimal minTempreture  = new BigDecimal(0);
	//	BigDecimal maxTempreture  = new BigDecimal(0);
		String abc = "";
		String ved ="";
	//	String standardAvailability="";
	//	String expiry="";
		itemId = (Integer) generalMap.get("id");
		ved = (String) generalMap.get("ved");
		abc = (String) generalMap.get("abc");
	//	pvms = (String) generalMap.get("pvms");
		rol = (String) generalMap.get("rol");
	//	commonName = (String) generalMap.get("commonName");
	//	maxTempreture = (BigDecimal) generalMap.get("maxTempreture");
	//	tempreture = (String) generalMap.get("tempreture");
	//	minTempreture = (BigDecimal) generalMap.get("minTempreture");
	//	nomenclature = (String) generalMap.get("name");
	//	itemClassId = (Integer) generalMap.get("itemClassId");
	//	sectionId = (Integer) generalMap.get("sectionId");
	//	groupId = (Integer) generalMap.get("groupId");
	//	itemGenericId = (Integer) generalMap.get("itemGenericId");
	//	itemTypeId = (Integer) generalMap.get("itemTypeId");
	//	itemCategoryId = (Integer) generalMap.get("itemCategoryId");
	//	itemConversionId = (Integer) generalMap.get("itemConversionId");
	//	pvms = (String) generalMap.get("pvms");
	//	dangerousDrug = (String) generalMap.get("dangerousDrug");
	//	controlledDrug = (String) generalMap.get("controlledDrug");
	//	highValueDrug = (String) generalMap.get("highValueDrug");
	//	rateContractItem = (String) generalMap.get("rateContractItem");
		minStock = (BigDecimal) generalMap.get("minStock");
		maxStock = (BigDecimal) generalMap.get("maxStock");
		leadTime = (String) generalMap.get("leadTime");
		hospitalId = (Integer) generalMap.get("hospitalId");
		userId= (Integer) generalMap.get("userId");
	//	specification = (String) generalMap.get("specification");
		slowMovingDays = (Integer) generalMap.get("slowMovingDays");
		fastMovingDays = (Integer) generalMap.get("fastMovingDays");
		nonMovingDays = (Integer) generalMap.get("nonMovingDays");
	//	expiry = (String) generalMap.get("expiry");
	//	allergy = (String) generalMap.get("allergy");
		currentDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		String kmscl_item_code="";
		kmscl_item_code = (String) generalMap.get("kmscl_item_code");

		int storeItemDetailsId = 0;
		if( generalMap.get("storeItemDetailsId")!=null){
			storeItemDetailsId = (Integer) generalMap.get("storeItemDetailsId");
		}
		
	//	standardAvailability = (String) generalMap.get("standardAvailability");
	/*	MasStoreItem masStoreItem = (MasStoreItem) getHibernateTemplate().get(
				MasStoreItem.class, itemId);

		masStoreItem.setId(itemId);*/
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasStoreItemDetails storeItemDetails = new MasStoreItemDetails();
		
		if(storeItemDetailsId!=0){
			storeItemDetails = (MasStoreItemDetails)hbt.load(MasStoreItemDetails.class,storeItemDetailsId);
		}
		
		
		MasStoreItem masStoreItem = new MasStoreItem();
		masStoreItem.setId(itemId);
		
		storeItemDetails.setItem(masStoreItem);
		
	//	masStoreItem.setNomenclature(nomenclature);
	//	masStoreItem.setPvmsNo(pvms);
	//	masStoreItem.setCommonName(commonName);
/*
		MasStoreSection masStoreSection = new MasStoreSection();
		masStoreSection.setId(sectionId);
		masStoreItem.setSection(masStoreSection);

		if (itemGenericId != 0) {
			MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
			masStoreItemGeneric.setId(itemGenericId);
			masStoreItem.setItemGeneric(masStoreItemGeneric);
			
		}
	
		
	

		if (groupId != 0) {
			MasStoreGroup masStoreGroup = new MasStoreGroup();
			masStoreGroup.setId(groupId);
			masStoreItem.setGroup(masStoreGroup);
		} else {
			masStoreItem.setGroup(null);
		}

		 MasItemType masStoreItemType = new MasItemType();
		 masStoreItemType.setId(itemTypeId);
		 masStoreItem.setItemType(masStoreItemType);

		if (itemCategoryId != 0) {
			MasItemCategory masStoreItemCategory = new MasItemCategory();
			masStoreItemCategory.setId(itemCategoryId);
			masStoreItem.setItemCategory(masStoreItemCategory);
		}
		if (itemClassId != 0) {
			masStoreItem.setItemClass(new MasItemClass(itemClassId));
		}*/
		if(abc !="")
		{
			storeItemDetails.setAbc(abc);
		}
		if(ved !="")
		{
			storeItemDetails.setVed(ved);
		}
		
		/*if(standardAvailability!="")
		{
			masStoreItem.setStandardAvailability(standardAvailability);
		}
		masStoreItem.setDangerousDrug(dangerousDrug);
		masStoreItem.setControlledDrug(controlledDrug);
		masStoreItem.setHighValueDrug(highValueDrug);
		masStoreItem.setRateContractItem(rateContractItem);

		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		masStoreItemConversion.setId(itemConversionId);
		masStoreItem.setItemConversion(masStoreItemConversion);

	
	

		if (itemTypeId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(itemTypeId);
			masStoreItem.setDepartment(masDepartment);
		}
		if (!tempreture.equals("")) {
			masStoreItem.setTemprature(tempreture);
		}*/
		if (!rol.equals("")) {
			storeItemDetails.setRol(rol);
		}
		

		
		
		/*	
			if (minTempreture != null && !minTempreture.equals("")) {
				masStoreItem.setTempratureMin(minTempreture);
					}
					if (maxTempreture != null && !maxTempreture.equals("")) {

						masStoreItem.setTempratureMax(maxTempreture);
							}
					
					*/
		
	
			if (minStock != null && !minStock.equals("")) {
				storeItemDetails.setMinStock(minStock);
			}
			if (maxStock != null && !maxStock.equals("")) {
				storeItemDetails.setMaxStock(maxStock);
					}
		
			storeItemDetails.setLeadTime(leadTime);
		
		
	/*	if (!standardAvailability.equals("")) {
			masStoreItem.setStandardAvailability(standardAvailability);
		}*/
	
//		masStoreItem.setSpecification(specification);

			storeItemDetails.setSlowMovingDays(slowMovingDays);
			storeItemDetails.setFastMovingDays(fastMovingDays);
			storeItemDetails.setNonMovingDays(nonMovingDays);
	//	masStoreItem.setExpiry(expiry);
	//	masStoreItem.setAllergy(allergy);

		
		
		MasHospital h = new MasHospital();
		h.setId(hospitalId);
		storeItemDetails.setHospital(h);

	
		hbt.saveOrUpdate(storeItemDetails);
		
		dataUpdated = true;
		return dataUpdated;

	}
	public Map<String, Object> searchItemLocalNonMed(String pvmsNo, String nomenclature) {
		List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> itemFieldsMap = new HashMap<String, Object>();
		List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		Session session = (Session) getSession();
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		String[] typeArr = {"NON MEDICAL","Immovable Assets","Movable Assets"};
		
		
		try {
			if ((pvmsNo != null)) {
				
				
				//searchItemList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo")).list();
				
				searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo","%"+pvmsNo+"%").ignoreCase()).addOrder(Order.asc("PvmsNo"))
						.createAlias("ItemType", "it")
						.add(Restrictions.in("it.ItemTypeName",typeArr))
						/*.add(Restrictions.eq("it.ItemTypeName","Non medicinal").ignoreCase())*/
								.list();
				
				
			}
			if ((nomenclature != null)) {
				//searchItemList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature")).list();
				
				searchItemList = session.createCriteria(MasStoreItem.class).add(Restrictions.like("Nomenclature","%"+nomenclature+"%").ignoreCase()).addOrder(Order.asc("Nomenclature"))
						.createAlias("ItemType", "it")
						.add(Restrictions.in("it.ItemTypeName",typeArr))
						/*.add(Restrictions.eq("it.ItemTypeName","Non medicinal").ignoreCase())*/
						.list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		storeSectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreSection as mr where  upper(mr.Status) =upper('y')");
	
		itemTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemType as mbs where upper(mbs.Status) =upper('y')");
		itemConversionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreItemConversion as mbs where upper(mbs.Status) =upper('y')");
		itemCategoryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasItemCategory as mbs where upper(mbs.Status) =upper('y')");
		
		groupList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
		masItemClassList= getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasItemClass where upper(Status) =upper('y')");

		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		masHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType as mc where upper(mc.Status) =upper('y')");
		itemFieldsMap.put("masHospitalTypeList", masHospitalTypeList);
		itemFieldsMap.put("searchItemList", searchItemList);
		itemFieldsMap.put("masItemClassList", masItemClassList);
		itemFieldsMap.put("storeSectionList", storeSectionList);
		itemFieldsMap.put("itemTypeList", itemTypeList);
		itemFieldsMap.put("itemConversionList", itemConversionList);
		itemFieldsMap.put("itemCategoryList", itemCategoryList);
		itemFieldsMap.put("groupList", groupList);
		
		return itemFieldsMap;
	}
	@SuppressWarnings("unchecked")
	public boolean deleteItemLocalNonMed(Integer itemId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			MasStoreItem masItem = new MasStoreItem();
			masItem = (MasStoreItem) getHibernateTemplate().load(
					MasStoreItem.class, itemId);
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (generalMap.get("flag") != null) {
			
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masItem.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masItem.setStatus("y");
					dataDeleted = false;
				}
			}
			Users users = new Users();
			users.setId(userId);
			masItem.setLastChgBy(users);
		
			masItem.setLastChgDate(currentDate);
			masItem.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}
	
	public Map<String, Object> showItemLocalNonMedJsp(int deptId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
			List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
			List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
			List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
			List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
			List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
			List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
			List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
			List<FaMasSubLed> faSubMasAccountList = new ArrayList<FaMasSubLed>();
			List<MasSalesTaxType> masSaleTaxTypeList = new ArrayList<MasSalesTaxType>();
			List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
			String transactionSequenceName = "Item Code";
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			int orderNo = 0;
			sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",transactionSequenceName)).list();
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = sequenceNo + 1;
			
			// Criteria c = session.createCriteria(MasStoreItem.class)
			// .add(Restrictions.eq("Department.Id", deptId));
			// c.setFirstResult(0);
			// c.setMaxResults(1000);
			// searchItemList = c.list();
			
			masItemClassList= getHibernateTemplate()
			.find("from jkt.hms.masters.business.MasItemClass where Lower(Status)='y'");


			List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
			hospitalParametersList=session.createCriteria(HospitalParameters.class).list();
			int departmentIdForRKS=0;
			int departmentIdForVBCH=0;
		 	if(hospitalParametersList.size()>0){
				 for (HospitalParameters hospitalParameters : hospitalParametersList) {
					departmentIdForRKS=hospitalParameters.getDeptIdStoreCodeRKS();
					departmentIdForVBCH=hospitalParameters.getDeptIdStoreCodeVBCH();
				}
		 	}
		 	//String[] typeArr = {"Non medicinal","Immovable Assets","Movable Assets","NON MEDICAL CONSUMABLE"};
		 	String[] typeArr = {"NON MEDICAL CONSUMABLE","NON MEDICAL ASSET","MEDICAL ASSET"};
			 
		 	searchItemList = session.createCriteria(MasStoreItem.class).createAlias("ItemType", "it")
		 			/*.add(Restrictions.eq("it.ItemTypeName","Non medicinal").ignoreCase())*/
		 			.add(Restrictions.in("it.ItemTypeName",typeArr)).list();
		 	//searchItemList = session.createCriteria(MasStoreItem.class).list();
		 	//searchItemList = getHibernateTemplate().find("from jkt.hms.masters.business.MasStoreItem as inp  where inp.Status = 'Y' || inp.Status = 'y'");
			/*if(deptId==departmentIdForRKS || deptId==departmentIdForVBCH)
			{
			 searchItemList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreItem as inp");
			}
			else
			{
				searchItemList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasStoreItem as inp where inp.Department.Id = "
								+ deptId);
 			}*/
			sectionList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreSection where upper(Status) =upper('y')");
		
			itemTypeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemType as mc where upper(mc.Status) =upper('y')");
			itemCategoryList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasItemCategory as mc where upper(mc.Status) =upper('y')");
			itemConversionList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreItemConversion as mc where upper(mc.Status) =upper('y')");
			groupList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreGroup as mg where upper(mg.Status) =upper('y')");
			
			List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
			masHospitalTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasHospitalType as mc where upper(mc.Status) =upper('y')");
			map.put("masHospitalTypeList", masHospitalTypeList);

			map.put("faMasAccountList", faMasAccountList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("searchItemList", searchItemList);
			map.put("storeSectionList", sectionList);
			map.put("itemTypeList", itemTypeList);
			map.put("itemCategoryList", itemCategoryList);
			map.put("itemConversionList", itemConversionList);
			map.put("faSubMasAccountList", faSubMasAccountList);
			map.put("masSaleTaxTypeList", masSaleTaxTypeList);
			map.put("manufacturerList", manufacturerList);
			map.put("storeSupplierList", supplierList);
			map.put("departmentList", departmentList);
			map.put("departmentList1", departmentList1);
			map.put("groupList", groupList);
			map.put("brandList", brandList);
			map.put("gridBrandList", gridBrandList);
			map.put("employeeList", employeeList);
			map.put("masItemClassList", masItemClassList);
			map.put("orderNo", orderNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> getItemTypeGLList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasItemType> masItemTypeList = new ArrayList<MasItemType>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int group = 0;
		try {
			
			if(dataMap.get("group") != null ){
				group = (Integer)dataMap.get("group");
			}
			masItemTypeList = session.createCriteria(MasItemType.class)
						.createAlias("Group", "g")
						.add(Restrictions.eq("g.Id",group))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();



			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masItemTypeList", masItemTypeList);
		return map;

}

	@Override
	public Map<String, Object> getSectionGLList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSection> masStoreSectionList = new ArrayList<MasStoreSection>();
		Session session = (Session) getSession();
		
		session = (Session) getSession();
		int itemType = 0;
		try {
			
			if(dataMap.get("itemType") != null ){
				itemType = (Integer)dataMap.get("itemType");
			}
			masStoreSectionList = session.createCriteria(MasStoreSection.class)
						.createAlias("ItemType", "g")
						.add(Restrictions.eq("g.Id",itemType))
						//.add(Restrictions.eq("SectionName","Medicinal"))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();



			

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masStoreSectionList", masStoreSectionList);
		return map;

}

	@Override
	public Map<String, Object> getCategoryList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
		List<MasItemClass> classList = new ArrayList<MasItemClass>();
		Session session = (Session) getSession();
		try {
			categoryList = session.createCriteria(MasItemCategory.class)
					.createAlias("Section", "section")
					.add(Restrictions.eq("section.Id", box.getInt("section")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			classList = session.createCriteria(MasItemClass.class)
					.createAlias("Section", "section")
					.add(Restrictions.eq("section.Id", box.getInt("section")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("categoryList", categoryList);
		map.put("classList", classList);
		return map;

	}

	@Override
	public Map<String, Object> showHospitalWiseItemDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreItemDetails> itemDetailsList = new ArrayList<MasStoreItemDetails>();
		Session session = (Session) getSession();
		itemList = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Id", box.getInt("itemId"))).list();
		itemDetailsList = session.createCriteria(MasStoreItemDetails.class).add(Restrictions.eq("Item.Id", box.getInt("itemId"))).list();
		map.put("itemList", itemList);
		map.put("itemDetailsList", itemDetailsList);
		return map;
	}
	

@Override
public Map showEmpaneled() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmpaneled> searchEmpaneledList = new ArrayList<MasEmpaneled>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasState> gridStateList = new ArrayList<MasState>();
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	List<MasDepartment> masDepartments = new ArrayList<MasDepartment>();
	Session session = getSession();
	searchEmpaneledList = session.createCriteria(MasEmpaneled.class).list();
	
	gridDistrictList = session.createCriteria(MasDistrict.class).list();

	districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();

	gridStateList = session.createCriteria(MasState.class).list();
		
	stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	
	masHospitalList= session.createCriteria(MasHospital.class)
			.add(Restrictions.eq("Status","y").ignoreCase())
			.addOrder(Order.asc("HospitalName")).list();
	
	masDepartments= session.createCriteria(MasDepartment.class)
			.add(Restrictions.eq("Status","y").ignoreCase())
			.addOrder(Order.asc("DepartmentName")).list();

	map.put("searchEmpaneledList", searchEmpaneledList);
	map.put("districtList", districtList);
	map.put("gridDistrictList", gridDistrictList);
	map.put("stateList", stateList);
	map.put("gridStateList", gridStateList);
	map.put("masHospitalList",masHospitalList);
	map.put("masDepartments", masDepartments);

	return map;
}

@Override
public boolean deleteEmpaneled(int empaneledId, Map<String, Object> generalMap) {
	boolean dataDeleted = false;
	int userId = 0;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");
	MasEmpaneled masEmpaneled = new MasEmpaneled();
	masEmpaneled = (MasEmpaneled) getHibernateTemplate().load(
			MasEmpaneled.class, empaneledId);
	userId = (Integer) generalMap.get("userId");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	if (generalMap.get("flag") != null) {
		String flag = (String) generalMap.get("flag");
		if (flag.equals("InActivate")) {
			masEmpaneled.setStatus("n");
			dataDeleted = true;
		} else if (flag.equals("Activate")) {
			masEmpaneled.setStatus("y");
			dataDeleted = false;
		}
	}
	
	Users users = new Users();
	users.setId(userId);
	masEmpaneled.setLastChgBy(users);
	
	
	masEmpaneled.setLastChgDate(currentDate);
	masEmpaneled.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masEmpaneled);
	return dataDeleted;
}

@Override
public Map<String, Object> searchEmpaneled(String empaneledCode,
		String empaneledName) {
	List<MasEmpaneled> searchEmpaneledList = new ArrayList<MasEmpaneled>();
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();

	Map<String, Object> empaneledsMap = new HashMap<String, Object>();
	List<MasDistrict> districtList = null;
	List<MasDistrict> gridDistrictList = null;
	List<MasState> stateList = null;
	List<MasState> gridStateList = null;
	
	Session session = getSession();

System.out.println(empaneledName);
System.out.println(empaneledCode);
	try {
		if ((empaneledName != null) || (empaneledCode == null)) {
						
			searchEmpaneledList =session.createCriteria(MasEmpaneled.class).add(Restrictions.like("EmpaneledName","%"+empaneledName+"%").ignoreCase()).addOrder(Order.asc("EmpaneledName")).list();
		} else {
							
			searchEmpaneledList =session.createCriteria(MasEmpaneled.class).add(Restrictions.like("EmpaneledCode","%"+empaneledCode+"%").ignoreCase()).addOrder(Order.asc("EmpaneledCode")).list();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
System.out.println(searchEmpaneledList.size()+"searchEmpaneledList");
	gridDistrictList = session.createCriteria(MasDistrict.class).list();
	
	districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y").ignoreCase()).list();

	
	masHospitalList= session.createCriteria(MasHospital.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	gridStateList = session.createCriteria(MasState.class).list();
		
	stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
	empaneledsMap.put("districtList", districtList);
	empaneledsMap.put("gridDistrictList", gridDistrictList);
	empaneledsMap.put("stateList", stateList);
	empaneledsMap.put("gridStateList", gridStateList);
	empaneledsMap.put("searchEmpaneledList",searchEmpaneledList);
	empaneledsMap.put("masHospitalList",masHospitalList);
	return empaneledsMap;
}

@Override
public boolean editEmpaneled(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");
	String empaneledName = "";
	String empaneledCode = "";
	int empaneledId = 0;
	int userId = 0;
	String contactPerson = "";
	int cityId1 = 0;
	int stateId1 = 0;
	String mobileNo1 = "";
	String cpMobileNo = "";
	String emailId1 = "";
	String licenceNo1 = "";
	String loginName = "";
	String address = "";

	int pinCode1 = 0;
	int tinNo1 = 0;
	empaneledId = (Integer) generalMap.get("id");
	empaneledCode = (String) generalMap.get("empaneledCode");
	empaneledName = (String) generalMap.get("name");
	contactPerson = (String) generalMap.get("contactPerson");
	loginName = (String) generalMap.get("loginName");
	String password = (String)generalMap.get("password");
	userId = (Integer) generalMap.get("userId");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	if (generalMap.get("address") != null) {
		address = (String) generalMap.get("address");
	}
	
	if(generalMap.get("cityId1") != null){
		cityId1 = (Integer) generalMap.get("cityId1");
	}
	
	if(generalMap.get("stateId1") != null){
		stateId1 = (Integer) generalMap.get("stateId1");
	}
	
	if(generalMap.get("pinCode1") != null){
		pinCode1 = (Integer) generalMap.get("pinCode1");
	}
	
	if(generalMap.get("mobileNo1") != null){
		mobileNo1 = (String) generalMap.get("mobileNo1");
	}
	if(generalMap.get("cpMobileNo") != null){
		cpMobileNo = (String) generalMap.get("cpMobileNo");
	}
	
	if(generalMap.get("tinNo1") != null){
		tinNo1 = (Integer) generalMap.get("tinNo1");
	}

	if(generalMap.get("licenceNo1") != null){
		licenceNo1 = (String) generalMap.get("licenceNo1");
	}
	
	if(generalMap.get("emailId1") != null){
		emailId1 = (String) generalMap.get("emailId1");
	}

	MasEmpaneled masEmpaneled = (MasEmpaneled) getHibernateTemplate()
			.load(MasEmpaneled.class, empaneledId);

	masEmpaneled.setId(empaneledId);
	masEmpaneled.setEmpaneledName(empaneledName);
	masEmpaneled.setContactPerson(contactPerson);

	masEmpaneled.setAddress(address);
	if (cityId1 != 0) {
		MasDistrict masDistrict = new MasDistrict();
		masDistrict.setId(cityId1);
		masEmpaneled.setCity(masDistrict);
	}

	if (stateId1 != 0) {
		MasState masState = new MasState();
		masState.setId(stateId1);
		masEmpaneled.setState(masState);
	}

	masEmpaneled.setLicenceNo(licenceNo1);
	masEmpaneled.setTinNo(tinNo1);
	masEmpaneled.setPinCode(pinCode1);
	masEmpaneled.setMobileno(mobileNo1);
	masEmpaneled.setEmailId(emailId1);
	masEmpaneled.setCpMobileNo(cpMobileNo);
	masEmpaneled.setLoginName(loginName);
	if(generalMap.get("departmentId") != null){
		MasDepartment department=new MasDepartment(Integer.parseInt(generalMap.get("departmentId").toString()));
		masEmpaneled.setDepartment(department);
	}
	masEmpaneled.setPassword(HMSUtil.encryptPassword(password));
	Users users = new Users();
	users.setId(userId);
	masEmpaneled.setLastChgBy(users);
	
	masEmpaneled.setLastChgDate(currentDate);
	masEmpaneled.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masEmpaneled);

	Session session = null;
	session = (Session) getSession();
	
	List<MasEmpaneledHospital> masEmpaneledHospitalList = new ArrayList<MasEmpaneledHospital>();
	
	masEmpaneledHospitalList = session.createCriteria(MasEmpaneledHospital.class)
			.createAlias("Empaneled","e")
			.add(Restrictions.eq("e.Id", empaneledId))					
			.list();
	
		if(masEmpaneledHospitalList.size()>0){
			hbt.deleteAll(masEmpaneledHospitalList);
		}
	
	if (generalMap.get("hospitalList") != null) {

		String[] hosp = (String[]) generalMap.get("hospitalList");
		if (hosp != null && hosp.length > 0) {
			for (String a : hosp) {
				MasEmpaneledHospital fsam = new MasEmpaneledHospital();
				
				MasHospital masHospital = new MasHospital();
				if (null != a && !a.equals("0"))
					masHospital.setId(Integer.parseInt(a));
				
				fsam.setHospital(masHospital);
				fsam.setEmpaneled(masEmpaneled);
				fsam.setStatus("Y");
				hbt.save(fsam);
				hbt.refresh(fsam);
				hbt.refresh(masEmpaneled);
			}

		}

	}
	hbt.flush();
	hbt.clear(); 
	dataUpdated = true;
	return dataUpdated;
}

@Override
public boolean addEmpaneled(MasEmpaneled masEmpaneled, Map<String, Object> objectMap) {
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.save(masEmpaneled);
	
	
	if (objectMap.get("hospitalList") != null) {

		String[] acc = (String[]) objectMap.get("hospitalList");
		if (acc != null && acc.length > 0) {
			for (String a : acc) {
				MasEmpaneledHospital fsam = new MasEmpaneledHospital();
				
				MasHospital masHospital = new MasHospital();
				if (null != a && !a.equals("0"))
					masHospital.setId(Integer.parseInt(a));
				
				fsam.setHospital(masHospital);
				fsam.setEmpaneled(masEmpaneled);
				fsam.setStatus("Y");
				hbt.save(fsam);
				hbt.refresh(fsam);
				hbt.refresh(masEmpaneled);

			}

		}

	}
	successfullyAdded = true;
	return successfullyAdded;
}

	@Override
	public Map<String, Object> addOutsideMedicineJsp(Map maps) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = HMSUtil.getCurrentDateAndTime();
		try {
			List<MasStoreOutItem> masStoreOutItemList = new ArrayList<MasStoreOutItem>();
			MasStoreOutItem masStoreOutItem =new  MasStoreOutItem();
			String nomenclature=null;
			int deptId=0,hospitalId = 0,userId=0;
			if (maps.get("deptId") != null) {
				deptId=(int) maps.get("deptId");
			}
			if (maps.get("hospitalId") != null) {
				hospitalId=(int) maps.get("hospitalId");
			}
			if (maps.get("userId") != null) {
				userId=(int) maps.get("userId");
			}
			String item="";
			String[] medicineArray = null;
			List<String> itemListNew = new ArrayList<String>();
			List<String> itemList = new ArrayList<String>();
			if (maps.get("nomenclature") != null) {
				nomenclature= (String) maps.get("nomenclature");
				medicineArray=nomenclature.split(",");
			}
			
			for (int i = 0; i <= medicineArray.length-1; i++) {
				String element = medicineArray[i];
				itemListNew.add(element);
				itemList.addAll(itemListNew);
			}
			for (int k = 0; k < itemList.size(); k++) {
				
				if(itemList.get(k)!=null){
					masStoreOutItem.setNomenclature(itemList.get(k));
					masStoreOutItem.setCreatedOn(new Date());
					
					Users users = new Users();
					users.setId(userId);
					masStoreOutItem.setCreatedBy(users);
					masStoreOutItem.setLastChgBy(users);
					masStoreOutItem.setLastChgDate(new Date());
					masStoreOutItem.setLastChgTime((String) utilMap.get("currentTime"));
					masStoreOutItem.setStatus("Y");
					
					MasDepartment department= new MasDepartment();
					department.setId(deptId);
					masStoreOutItem.setDepartment(department);
					
					MasHospital hospital =new MasHospital();
					hospital.setId(hospitalId);
					masStoreOutItem.setHospital(hospital);
				}
				hbt.save(masStoreOutItem);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}


}
