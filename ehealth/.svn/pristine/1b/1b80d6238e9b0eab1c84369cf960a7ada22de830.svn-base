package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DIET_ITEMS_ID;
import static jkt.hms.util.RequestConstants.EXTRA_ITEM;
import static jkt.hms.util.RequestConstants.INDENT_GROUP;
import static jkt.hms.util.RequestConstants.ITEM_TYPE;
import static jkt.hms.util.RequestConstants.MENU_TYPE;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.transaction.Transaction;

import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietIndentItem;
import jkt.hms.masters.business.MasDietItems;
import jkt.hms.masters.business.MasDietMenuItem;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMenuType;
import jkt.hms.masters.business.MasMenuType;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CanteenMasterDataServiceImpl extends HibernateDaoSupport implements
		CanteenMasterDataService {

	// -----------------------------Diet
	// Master--------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiet> searchDietList = new ArrayList<MasDiet>();
		List<MasDietType> masDietTypeList = new ArrayList<MasDietType>();

		try {
			searchDietList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDiet ");
			masDietTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDietType ");
			map.put("searchDietList", searchDietList);
			map.put("masDietTypeList", masDietTypeList);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDiet(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();

		boolean successfullyAdded = false;

		List<MasDiet> duplicateList = new ArrayList<MasDiet>();

		String code = (String) generalMap.get("code");
		String name = (String) generalMap.get("name");
		int category = (Integer) generalMap.get("category");
		String changedBy = (String) generalMap.get("changedBy");
		Date currentDate = (Date) generalMap.get("currentDate");
		String currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);


		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			duplicateList = hbt
					.find("from jkt.hms.masters.business.MasDiet as md  where lower(md.DietCode) ='"
							+ code.toLowerCase()
							+ "' and lower(md.DietName) = '"
							+ name.toLowerCase()
							+ "' ");

			if (duplicateList.size() == 0) {

				MasDiet masDiet = new MasDiet();


				masDiet.setDietCode(code);
				masDiet.setDietName(name);
//				MasDietType dietType = new MasDietType();
//				dietType.setId(category);
//				masDiet.setDietType(dietType);
				masDiet.setStatus("y");
				Users users=new Users();
				users.setId(userId);
				masDiet.setLastChgBy(users);
				masDiet.setLastChgDate(currentDate);
				masDiet.setLastChgTime(currentTime);

				hbt.save(masDiet);
				hbt.flush();
				hbt.clear();
				successfullyAdded = true;
			} else {
				map.put("duplicateList", duplicateList);
				successfullyAdded = false;
			}
			map.put("successfullyAdded", successfullyAdded);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean deleteDiet(int dietId, Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasDiet masDiet = new MasDiet();
			masDiet = (MasDiet) hbt.load(MasDiet.class, dietId);

			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masDiet.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masDiet.setStatus("y");
					dataDeleted = false;
				}
			}
			Users users=new Users();
			users.setId(userId);
			masDiet.setLastChgBy(users);
			masDiet.setLastChgDate(currentDate);
			masDiet.setLastChgTime(currentTime);
			hbt.update(masDiet);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editDietToDatabase(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiet> duplicateList = new ArrayList<MasDiet>();

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";

		String dietName = "";
		String dietCode = "";
		int category = 0;
		int dietId = 0;

		dietId = (Integer) generalMap.get("id");
		dietCode = (String) generalMap.get("dietCode");
		dietName = (String) generalMap.get("name");
		category = (Integer) generalMap.get("category");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			duplicateList = hbt
					.find("from jkt.hms.masters.business.MasDiet as md  where lower(md.DietCode) ='"
							+ dietCode
							+ "' and lower(md.DietName) = '"
							+ dietName
							+ "' ");

			if (duplicateList.size() == 0) {
				MasDiet masDiet = (MasDiet) getHibernateTemplate().load(
						MasDiet.class, dietId);

				masDiet.setId(dietId);
				masDiet.setDietName(dietName);
//				MasDietType dietType = new  MasDietType();
//				dietType.setId(category);
//				masDiet.setDietType(dietType);
				Users users=new Users();
				users.setId(userId);
				masDiet.setLastChgBy(users);
				masDiet.setLastChgDate(currentDate);
				masDiet.setLastChgTime(currentTime);
				hbt.update(masDiet);
				hbt.flush();
				hbt.clear();
				dataUpdated = true;
			} else {
				map.put("duplicateList", duplicateList);
				dataUpdated = false;
			}
			map.put("dataUpdated", dataUpdated);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDiet(String dietCode, String dietName) {

		List<MasDiet> searchDietList = new ArrayList<MasDiet>();
		Map<String, Object> dietFieldsMap = new HashMap<String, Object>();
		try {
			if ((dietName != null) || (dietCode == null)) {
				searchDietList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDiet imc where lower(imc.DietName) like '"
								+ dietName.toLowerCase() + "%' order by imc.DietName");
			} else {
				searchDietList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDiet imc where lower(imc.DietCode) like '"
								+ dietCode.toLowerCase() + "%' order by imc.DietCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dietFieldsMap.put("searchDietList", searchDietList);
		return dietFieldsMap;
	}

	// ---------------------------------Diet
	// type---------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietType> searchDietTypeList = new ArrayList<MasDietType>();
		searchDietTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDietType ");
		map.put("searchDietTypeList", searchDietTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietType(String dietTypeCode,
			String dietTypeName) {
		List<MasDietType> searchDietTypeList = new ArrayList<MasDietType>();
		Map<String, Object> dietTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((dietTypeName != null) || (dietTypeCode == null)) {
				searchDietTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDietType imc where lower(imc.DietTypeName) like '"
								+ dietTypeName.toLowerCase() + "%' order by imc.DietTypeName");
			} else {
				searchDietTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDietType imc where imc.DietTypeCode like '"
								+ dietTypeCode + "%' order by imc.DietTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dietTypeFieldsMap.put("searchDietTypeList", searchDietTypeList);
		return dietTypeFieldsMap;
	}

	public boolean addDietType(MasDietType masDietType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDietType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editDietTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String dietTypeName = "";
		@SuppressWarnings("unused")
		String dietTypeCode = "";
		int dietTypeId = 0;

		dietTypeId = (Integer) generalMap.get("id");
		dietTypeCode = (String) generalMap.get("dietTypeCode");
		dietTypeName = (String) generalMap.get("name");
	    int	userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDietType masDietType = (MasDietType) getHibernateTemplate().load(
				MasDietType.class, dietTypeId);

		masDietType.setId(dietTypeId);
		masDietType.setDietTypeName(dietTypeName);
		Users users=new Users();
		users.setId(userId);
		masDietType.setLastChgBy(users);
		masDietType.setLastChgDate(currentDate);
		masDietType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDietType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteDietType(int dietTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=(Integer)generalMap.get("userId");
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDietType masDietType = new MasDietType();
		masDietType = (MasDietType) getHibernateTemplate().load(
				MasDietType.class, dietTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDietType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDietType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masDietType.setLastChgBy(users);
		masDietType.setLastChgDate(currentDate);
		masDietType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDietType);
		return dataDeleted;
	}

	// ----------------------------Diet items---------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietItemsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietItems> searchDietItemsList = new ArrayList<MasDietItems>();
		searchDietItemsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDietItems ");
		map.put("searchDietItemsList", searchDietItemsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietItems(String dietItemsCode,
			String dietItemsName) {
		List<MasDietItems> searchDietItemsList = new ArrayList<MasDietItems>();
		Map<String, Object> dietItemsFieldsMap = new HashMap<String, Object>();
		try {
			if ((dietItemsName != null) || (dietItemsCode == null)) {
				searchDietItemsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDietItems imc where lower(imc.DietItemsName) like '"
								+ dietItemsName.toLowerCase()
								+ "%' order by imc.DietItemsName");
			} else {
				searchDietItemsList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDietItems imc where lower(imc.DietItemsCode) like '"
								+ dietItemsCode.toLowerCase()
								+ "%' order by imc.DietItemsCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dietItemsFieldsMap.put("searchDietItemsList", searchDietItemsList);
		return dietItemsFieldsMap;
	}

	public boolean addDietItems(MasDietItems masDietItems) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDietItems);
		hbt.flush();hbt.clear();
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDietItems(int dietItemsId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDietItems masDietItems = new MasDietItems();
		masDietItems = (MasDietItems) getHibernateTemplate().load(
				MasDietItems.class, dietItemsId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDietItems.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDietItems.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masDietItems.setLastChgBy(users);
		masDietItems.setLastChgDate(currentDate);
		masDietItems.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDietItems);
		return dataDeleted;
	}

	public boolean editDietItemsToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String dietItemsName = "";
		@SuppressWarnings("unused")
		String dietItemsCode = "";
		int dietItemsId = 0;

		dietItemsId = (Integer) generalMap.get("id");
		dietItemsCode = (String) generalMap.get("dietItemsCode");
		dietItemsName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		MasDietItems masDietItems = (MasDietItems) getHibernateTemplate().load(
				MasDietItems.class, dietItemsId);

		masDietItems.setId(dietItemsId);
		masDietItems.setDietItemsName(dietItemsName);
		Users users=new Users();
		users.setId(userId);
		masDietItems.setLastChgBy(users);
		masDietItems.setLastChgDate(currentDate);
		masDietItems.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDietItems);
		dataUpdated = true;
		return dataUpdated;
	}

	// ----------------------------------Diet Diet
	// Type--------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietCombinationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietCombination> searchDietDietTypeList = new ArrayList<MasDietCombination>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasDiet> dietListGrid = new ArrayList<MasDiet>();
		List<MasDietItems> dietItemList = new ArrayList<MasDietItems>();
		List<MasDietItems> dietItemListGrid = new ArrayList<MasDietItems>();
		List<MasMenuType> masMenuTypes = new ArrayList<MasMenuType>();
		List<MasMenuType> masMenuTypesGrid = new ArrayList<MasMenuType>();
		
		searchDietDietTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDietCombination ");
		dietTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDietType as mc where upper(mc.Status) = upper('y')");
		dietListGrid = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDiet");
		dietList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDiet as mc where upper(mc.Status) = upper('y')");
		dietItemList= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDietItems as mc where upper(mc.Status) = upper('y')");
		dietItemListGrid= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDietItems");
		
		masMenuTypes= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMenuType as mc where upper(mc.Status) = upper('y')");
		masMenuTypesGrid= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMenuType");
		
		map.put("searchDietDietTypeList", searchDietDietTypeList);
		
		map.put("dietTypeList", dietTypeList);
		map.put("dietListGrid", dietListGrid);
		map.put("dietList", dietList);
		map.put("dietItemList", dietItemList);
		map.put("masMenuTypes", masMenuTypes);
		map.put("masMenuTypesGrid", masMenuTypesGrid);
		map.put("dietItemListGrid", dietItemListGrid);
		return map;
	}

	public boolean addDietCombination(MasDietCombination masDietCombination) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masDietCombination);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean deleteDietCombination(int dietDietTypeId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		try {
			
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			MasDietCombination masDietCombination = new MasDietCombination();
			masDietCombination = (MasDietCombination) getHibernateTemplate()
					.get(MasDietCombination.class, dietDietTypeId);

			int userId= (Integer) generalMap.get("userId");
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
			Users user=new Users();
			user.setId(userId);
			masDietCombination.setLastChgBy(user);
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

	public boolean editDietCombination(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		int dietDietTypeId = 0;
		int dietId = 0;
		int dietTypeId = 0;
		@SuppressWarnings("unused")
		String dietCategoryName = "";
		String changedBy = "";
		String currentTime = "";
		int userId=(Integer) generalMap.get("userId");
		Date changedDate = new Date();
		dietDietTypeId = (Integer) generalMap.get("id");
		dietId = (Integer) generalMap.get("dietId");
		dietTypeId = (Integer) generalMap.get("dietTypeId");
		dietCategoryName = (String) generalMap.get("dietCategoryName");
		changedBy = (String) generalMap.get("changedBy");
		changedDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		int hsId= (Integer) generalMap.get("hsId");
		int dMenu= (Integer) generalMap.get("dMenu");
		int dItem= (Integer) generalMap.get("dItem");
		//changed for maven
		float dquat= (Float) generalMap.get("dquat");
		
		MasDietCombination masDietCombination = (MasDietCombination) getHibernateTemplate()
				.get(MasDietCombination.class, dietDietTypeId);

		masDietCombination.setId(dietDietTypeId);

		MasDiet masDiet = new MasDiet();
		masDiet.setId(dietId);
		masDietCombination.setDiet(masDiet);

		MasDietType masDietType = new MasDietType();
		masDietType.setId(dietTypeId);
		//masDietCombination.setDietType(masDietType);
		masDietCombination.setDietCombinationName(dietCategoryName);
		masDietCombination.setStatus("y");
	    Users user=new Users();
	    user.setId(userId);
		masDietCombination.setLastChgBy(user);
		masDietCombination.setLastChgDate(changedDate);
		masDietCombination.setLastChgTime(currentTime);
		 MasDietItems masDietItem=new MasDietItems();
         masDietItem.setId(dItem);
	   masDietCombination.setDietItems(masDietItem);
	
	   masDietCombination.setDietQuantity(dquat);
	   MasHospital masHos=new MasHospital();
	   masHos.setId(hsId);
	  masDietCombination.setHospital(masHos);
	  MasMenuType maMenu=new MasMenuType();
	  maMenu.setId(dMenu);
	   masDietCombination.setMenu(maMenu);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masDietCombination);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public Map<String, Object> searchItemGeneric(String itemGenericName) {
		List<MasDietCombination> searchDietDietTypeList = new ArrayList<MasDietCombination>();
		Map<String, Object> dietDietTypeFieldsMap = new HashMap<String, Object>();
		List pharamaIndexList = new ArrayList();
		/*
		 * try{ if((genericName!=null)){
		 * searchDietDietTypeList=getHibernateTemplate().find("from
		 * jkt.hms.masters.business.MasStoreItemGeneric as i where i.GenericName
		 * like '"+ genericName+"%' order by i.GenericName"); } } catch
		 * (Exception e) { } pharamaIndexList = getHibernateTemplate().find( "from
		 * jkt.hms.masters.business.MasStorePharmaIndex as md where md.Status =
		 * 'y' ");
		 * dietDietTypeFieldsMap.put("searchItemGenericList",searchDietDietTypeList
		 * ); dietDietTypeFieldsMap.put("pharamaIndexList",pharamaIndexList);
		 */
		return dietDietTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietCombination(String dietName) {
		List<MasDietCombination> searchDietDietTypeList = new ArrayList<MasDietCombination>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDietType> dietTypeListGrid = new ArrayList<MasDietType>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasDiet> dietListGrid= new ArrayList<MasDiet>();
		List<MasDietItems> dietItemList = new ArrayList<MasDietItems>();
		List<MasMenuType> masMenuTypes = new ArrayList<MasMenuType>();
		Map<String, Object> dietFieldsMap = new HashMap<String, Object>();
		List<MasMenuType> masMenuTypesGrid = new ArrayList<MasMenuType>();
		List<MasDietItems> dietItemListGrid = new ArrayList<MasDietItems>();
		
		try {
			if (dietName != "") {
				searchDietDietTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasDietCombination as i where lower(i.Diet.DietName) like '"
								+ dietName.toLowerCase() + "%' order by i.Diet.DietName ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		
		dietTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDietType as mc where upper(mc.Status) = upper('y')");
		dietTypeListGrid = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDietType");
		dietListGrid = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDiet");

		dietItemListGrid= getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasDietItems");
		dietList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDiet as mc where upper(mc.Status) = upper('y')");
		dietItemList= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDietItems as mc where upper(mc.Status) = upper('y')");
		masMenuTypes= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMenuType as mc where upper(mc.Status) = upper('y')");
		masMenuTypesGrid= getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMenuType");
		
		dietFieldsMap.put("searchDietDietTypeList", searchDietDietTypeList);
		dietFieldsMap.put("dietTypeList", dietTypeList);
		dietFieldsMap.put("dietTypeListGrid", dietTypeListGrid);
		dietFieldsMap.put("dietList", dietList);
		dietFieldsMap.put("dietItemListGrid", dietItemListGrid);
		dietFieldsMap.put("dietListGrid", dietListGrid);
		dietFieldsMap.put("dietItemList", dietItemList);
		dietFieldsMap.put("masMenuTypes", masMenuTypes);
		dietFieldsMap.put("masMenuTypesGrid", masMenuTypesGrid);

		return dietFieldsMap;

	}

	// -------------------------Diet Menu
	// Item---------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietMenuItemJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietMenuItem> menuItemList = new ArrayList<MasDietMenuItem>();
		List<MasDietItems> itemList = new ArrayList<MasDietItems>();

		Session session = (Session) getSession();

		try {
			menuItemList = session.createCriteria(MasDietMenuItem.class).list();
			itemList = session.createCriteria(MasDietItems.class)
					.add(Restrictions.eq("Status", "y")).list();
			map.put("menuItemList", menuItemList);
			map.put("itemList", itemList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addDietMenuItem(Box box) {
		boolean saved = false;

		String menuType = box.getString(MENU_TYPE);
		Vector items = box.getVector("dietMenuItemId");
		int userId=box.getInt("userId");
		String changedDate = box.getString(CHANGED_DATE);
		String changedTime = box.getString(CHANGED_TIME);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i < items.size(); i++) {
			MasDietMenuItem menuItem = new MasDietMenuItem();

			menuItem.setMenuType(menuType);
			if (items.get(i) != "") {
				int itemId = Integer.parseInt((String) items.get(i));
				MasDietItems dietItems = new MasDietItems();
				dietItems.setId(itemId);
				menuItem.setDietItems(dietItems);
			}
		
			menuItem.setLastChgBy(userId);
			menuItem.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(changedDate));
			menuItem.setLastChgTime(changedTime);
			menuItem.setStatus("y");

			hbt.save(menuItem);
			saved = true;
		}

		return saved;
	}
	
	public boolean editDietMenuItemToDatabase(Map<String, Object> generalMap) 
	  {
		Date currentDate = new Date();
		Date changedDate = new Date();
		Boolean dataUpdated;
		String currentTime = "";
		String changedBy = "";
		String dietMenuType="";
		String dietTypeName=""; 
		int dietMenuItemsId=0;
		int dietId=0;
		int userId=(Integer)generalMap.get("userId");
		MasDietMenuItem masdiet =new MasDietMenuItem(); 
		MasDietItems masDietItem=new MasDietItems(); 
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		changedBy= (String)(generalMap.get(changedBy));
		changedDate = (Date) generalMap.get("currentDate");
		dietMenuType= (String) generalMap.get("dietMenuType");
		dietMenuItemsId=(Integer)(generalMap.get("dietMenuItemsId"));
		dietId=(Integer)(generalMap.get("id"));
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try
		{
		masdiet = (MasDietMenuItem) hbt.load(MasDietMenuItem.class,
				dietId);
		
		
		//masdiet.setId(dietMenuItemsId);
		masdiet.setMenuType(dietMenuType);
		masdiet.setLastChgBy(userId);
		masdiet.setLastChgDate(currentDate);
		masdiet.setLastChgTime(currentTime);
		masDietItem.setId(dietMenuItemsId);
		masdiet.setDietItems(masDietItem);
		
		hbt.update(masdiet);
		}
		catch(Exception e)
		{
			
		}
		
		
		dataUpdated = true;
		
		
		return dataUpdated;	
	}

	public boolean deleteDietMenuItem(Box box) {

		boolean dataDeleted = false;
		String changedBy = "";
		String currentDate = "";
		String currentTime = "";
		int menuItemId = 0;
		int userId=box.getInt("userId");
				

		menuItemId = box.getInt(COMMON_ID);
		changedBy = (String) box.getString(CHANGED_BY);
		currentDate = (String) box.getString(CHANGED_DATE);
		currentTime = (String) box.getString(CHANGED_TIME);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasDietMenuItem menuItem = new MasDietMenuItem();
			menuItem = (MasDietMenuItem) hbt.load(MasDietMenuItem.class,
					menuItemId);

			if (box.getString("flag") != null) {
				String flag = (String) box.getString("flag");
				if (flag.equals("InActivate")) {
					menuItem.setStatus("n");
				} else if (flag.equals("Activate")) {
					menuItem.setStatus("y");
				}
			}
			menuItem.setLastChgBy(userId);
			menuItem.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(currentDate));
			menuItem.setLastChgTime(currentTime);
			hbt.update(menuItem);
			dataDeleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietMenuItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietMenuItem> menuItemList = new ArrayList<MasDietMenuItem>();

		Session session = getSession();
		String menuType = box.getString(SEARCH_NAME);

		try {
			menuItemList = session.createCriteria(MasDietMenuItem.class)
					.add(Restrictions.like("MenuType", menuType + "%")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map = showDietMenuItemJsp();
		map.put("menuItemList", menuItemList);
		return map;
	}

	// ----------------------- Diet Indent Item-------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDietIndentItemJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();

		Session session = (Session) getSession();

		try {
			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.list();
			map.put("indentItemList", indentItemList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDietIndentItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		boolean successfullyAdded = false;
		List<MasDietIndentItem> duplicateList = new ArrayList<MasDietIndentItem>();

		String indentItemCode = (String) box.getString(CODE);
		String indentItemName = (String) box.getString(SEARCH_NAME);
		String type = (String) box.getString(ITEM_TYPE);
		int userId=0; 
		userId = (Integer) box.getInt("userId");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Session session = getSession();
			duplicateList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.eq("IndentItemCode", indentItemCode))
					.add(Restrictions.eq("IndentItemName", indentItemName))
					.add(Restrictions.eq("IndentItemType", type)).list();

			if (duplicateList.size() == 0) {

				MasDietIndentItem indentItem = new MasDietIndentItem();
				indentItem.setIndentItemCode(indentItemCode);
				indentItem.setIndentItemName(indentItemName);
				indentItem.setIndentItemType(type);
				indentItem.setIndentGroup(box.getString(INDENT_GROUP));
				indentItem.setExtraItem(box.getString(EXTRA_ITEM));
				
				Users users=new Users();
				users.setId(userId);
				indentItem.setLastChgBy(users);
				
				indentItem.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				indentItem.setLastChgTime(box.getString(CHANGED_TIME));
				indentItem.setStatus("y");
				hbt.save(indentItem);
				successfullyAdded = true;
			} else {
				map.put("duplicateList", duplicateList);
				successfullyAdded = false;
			}
			map.put("successfullyAdded", successfullyAdded);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editDietIndentItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		boolean successfullyUpdate = false;
		List<MasDietIndentItem> duplicateList = new ArrayList<MasDietIndentItem>();

		int indentItemId = (Integer) box.getInt(COMMON_ID);
		String indentItemCode = (String) box.getString(CODE);
		String indentItemName = (String) box.getString(SEARCH_NAME);
		String type = (String) box.getString(ITEM_TYPE);
		int userId=0; 
		userId = (Integer) box.getInt("userId");
	
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Session session = getSession();
			duplicateList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.not(Expression.eq("Id", indentItemId)))
					.add(Restrictions.eq("IndentItemCode", indentItemCode))
					.add(Restrictions.eq("IndentItemName", indentItemName))
					.add(Restrictions.eq("IndentItemType", type)).list();

			if (duplicateList.size() == 0) {

				MasDietIndentItem indentItem = (MasDietIndentItem) hbt.load(
						MasDietIndentItem.class, indentItemId);
				indentItem.setIndentItemName(indentItemName);
				indentItem.setIndentItemType(type);
				indentItem.setIndentGroup(box.getString(INDENT_GROUP));
				indentItem.setExtraItem(box.getString(EXTRA_ITEM));
				//indentItem.setLastChgBy(box.getString(CHANGED_BY));
				Users users=new Users();
				users.setId(userId);
				indentItem.setLastChgBy(users);
				
		
				indentItem.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				indentItem.setLastChgTime(box.getString(CHANGED_TIME));
				indentItem.setStatus("y");
				hbt.update(indentItem);
				successfullyUpdate = true;
			} else {
				map.put("duplicateList", duplicateList);
				successfullyUpdate = false;
			}
			map.put("successfullyUpdate", successfullyUpdate);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public boolean deleteDietIndentItem(Box box) {
		boolean deleted = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int indentItemId = box.getInt(COMMON_ID);
		int changedBy = (Integer)box.getInt("userID");
		Date changedDate = HMSUtil.convertStringTypeDateToDateType((String) box
				.getString(CHANGED_DATE));
		String changedTime = box.getString(CHANGED_TIME);

		try {
			MasDietIndentItem indentItem = (MasDietIndentItem) hbt.load(
					MasDietIndentItem.class, indentItemId);
			indentItem.setStatus("n");
			if (box.getString("flag") != null) {
				String flag = (String) box.getString("flag");
				if (flag.equals("InActivate")) {
					indentItem.setStatus("n");
				} else if (flag.equals("Activate")) {
					indentItem.setStatus("y");
				}
			}
			Users users=new Users();
			users.setId(changedBy);
			indentItem.setLastChgBy(users);
			
	
			indentItem.setLastChgDate(changedDate);
			indentItem.setLastChgTime(changedTime);
			hbt.update(indentItem);
			deleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return deleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDietIndentItem(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();

		Session session = getSession();
		int radioValue = box.getInt(SELECTED_RADIO);
		String searchName = box.getString(SEARCH_FIELD);
		String searchProperty = "";
		map = showDietIndentItemJsp();
		try {
			if (radioValue == 1) {
				searchProperty = "IndentItemCode";
			} else {
				searchProperty = "IndentItemName";
			}
			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.like(searchProperty, searchName + "%"))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("indentItemList", indentItemList);
		return map;
	}
	
	
	// ----------------------------------MenuType------------------------------------

		public boolean addMenuType(MasMenuType masMenuType) {
			boolean saveFlag = false;
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masMenuType);
				saveFlag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return saveFlag;
		}

		@SuppressWarnings("unchecked")
		public boolean deleteMenuType(int menuTypeId, Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasMenuType masMenuType = new MasMenuType();
			masMenuType = (MasMenuType) getHibernateTemplate().load(MasMenuType.class,
					menuTypeId);
			int userId=0; 
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masMenuType.setStatus("N");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masMenuType.setStatus("Y");
					dataDeleted = false;
				}
			}
			
			Users users=new Users();
			users.setId(userId);
			masMenuType.setLastChgBy(users);
			

			masMenuType.setLastChgDate(currentDate);
			masMenuType.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masMenuType);
			return dataDeleted;
		}

		public boolean editMenuType(Map<String, Object> generalMap) {

			boolean dataUpdated = false;

			
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			int menuId = 0;
			String menuName = "";
			String menuCode = "";

			try {
				menuId = (Integer) generalMap.get("id");
				menuCode = (String) generalMap.get("menuCode");
				menuName = (String) generalMap.get("name");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				MasMenuType masMenuType = (MasMenuType) getHibernateTemplate().load(
						MasMenuType.class, menuId);

				masMenuType.setId(menuId);
				masMenuType.setMenuName(menuName);

				
				masMenuType.setStatus("Y");
				Users users=new Users();
				users.setId(userId);
				masMenuType.setLastChgBy(users);
				
							
				masMenuType.setLastChgDate(currentDate);
				masMenuType.setLastChgTime(currentTime);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masMenuType);
				dataUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dataUpdated;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> searchMenuType(String menuCode,String menuName) {
			Session session = (Session) getSession();
			List masMenuTypeList = new ArrayList();
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				if ((menuName != null) || (menuCode == null)) {
					
					
					masMenuTypeList =session.createCriteria(MasMenuType.class).add(Restrictions.like("MenuName","%"+menuName+"%").ignoreCase()).addOrder(Order.asc("MenuName")).list();
				} else if (menuCode != null) {
					
					masMenuTypeList =session.createCriteria(MasMenuType.class).add(Restrictions.like("MenuCode","%"+menuCode+"%").ignoreCase()).addOrder(Order.asc("MenuCode")).list();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("masMenuTypeList", masMenuTypeList);
			return map;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> showMenuType() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasMenuType> masMenuTypeList = new ArrayList<MasMenuType>();
			masMenuTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMenuType as sc order by sc.MenuName");
			
			map.put("masMenuTypeList", masMenuTypeList);
			
			return map;
		}


}