/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * DietDataServiceImpl.java
 * Purpose of the class - This is for Diet Module.
 * @author  Ritu Sahu
 * Create Date: 5th Sep,2008
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/
package jkt.hms.diet.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_BY;


import static jkt.hms.util.RequestConstants.HEIGHT;
import static jkt.hms.util.RequestConstants.WEIGHT;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CONDITION;
import static jkt.hms.util.RequestConstants.DIET_COMBINATION_ID;
import static jkt.hms.util.RequestConstants.DIET_ID;
import static jkt.hms.util.RequestConstants.DIET_ITEMS_ID;
import static jkt.hms.util.RequestConstants.DIET_TYPE_ID;
import static jkt.hms.util.RequestConstants.EXTRA_SCALE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.ITEM_NAME;
import static jkt.hms.util.RequestConstants.MENU_TYPE;
import static jkt.hms.util.RequestConstants.PATIENT_CATEGORY;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VALID_FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.BED_NO;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.STATUS_YES;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.DietDetails;
import jkt.hms.masters.business.DietExtraItemFormula;
import jkt.hms.masters.business.DietIndentItemFormula;
import jkt.hms.masters.business.DietMenuItemFormula;
import jkt.hms.masters.business.HesMaintenanceJobMaster;
import jkt.hms.masters.business.INPATIENTDIETVIEW;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietIndentItem;
import jkt.hms.masters.business.MasDietItems;
import jkt.hms.masters.business.MasDietMenuItem;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientDietIndoorDetail;
import jkt.hms.masters.business.PatientDietIndoorHeader;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.PRAcroForm;

public class DietDataServiceImpl extends HibernateDaoSupport implements
		DietDataService {

	/**
	 * --------------------------- Method to show Menu Item Formula jsp
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMenuItemFormulaJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<DietMenuItemFormula> menuItemFormulaList = new ArrayList<DietMenuItemFormula>();
		List<MasDietItems> dietItemsList = new ArrayList<MasDietItems>();
		List<String> menuTypeList = new ArrayList<String>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
		List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();
		List<MasDietMenuItem> menuItemList = new ArrayList<MasDietMenuItem>();

		Session session = (Session) getSession();
		try {
			session.clear();
			menuTypeList = session.createCriteria(MasDietMenuItem.class)
					.setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("MenuType"))))
					.list();

			menuItemFormulaList = session.createCriteria(
					DietMenuItemFormula.class).list();
			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();
			dietItemsList = session.createCriteria(MasDietItems.class).add(
					Restrictions.eq("Status", "y")).list();
			uomList = session.createCriteria(MasStoreUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			menuItemList = session.createCriteria(MasDietMenuItem.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("menuItemFormulaList", menuItemFormulaList);
		map.put("dietCombinationList", dietCombinationList);
		map.put("dietItemsList", dietItemsList);
		map.put("uomList", uomList);
		map.put("menuTypeList", menuTypeList);
		map.put("menuItemList", menuItemList);
		return map;
	}

	/**
	 * --------------------------- Method to submit Menu Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addMenuItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		DietMenuItemFormula menuItemFormula = new DietMenuItemFormula();
		List<DietMenuItemFormula> existingList = new ArrayList<DietMenuItemFormula>();
		Session session = getSession();
		boolean saved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int dietCombinationId = box.getInt(DIET_COMBINATION_ID);
		int dietItemsId = box.getInt(DIET_ITEMS_ID);
		String menuType = box.getString(MENU_TYPE);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));
		String patientCategory = box.getString(PATIENT_CATEGORY);

		try {

			MasDietCombination dietCombination = new MasDietCombination();
			dietCombination.setId(dietCombinationId);
			menuItemFormula.setDietCombination(dietCombination);

			MasDietItems dietItems = new MasDietItems();
			dietItems.setId(dietItemsId);
			menuItemFormula.setDietItems(dietItems);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			menuItemFormula.setUnit(storeUnit);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			menuItemFormula.setHospital(hospital);

			menuItemFormula.setMenuType(menuType);
			menuItemFormula
					.setQuantity(new BigDecimal(box.getString(QUANTITY)));
			menuItemFormula.setPatientCategory(patientCategory);
			menuItemFormula.setValidityStartDate(validFromDate);
			menuItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			menuItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			menuItemFormula.setLastChgTime(box.getString(CHANGED_TIME));
			menuItemFormula.setStatus("y");

			existingList = session.createCriteria(DietMenuItemFormula.class)
					.add(Restrictions.eq("MenuType", menuType))
					.add(Restrictions.eq("PatientCategory", patientCategory))
					.createAlias("DietItems", "di").add(
							Restrictions.eq("di.Id", dietItemsId)).createAlias(
							"DietCombination", "dc").add(
							Restrictions.eq("dc.Id", dietCombinationId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietMenuItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietMenuItemFormula itemFormula = (DietMenuItemFormula) hbt
							.load(DietMenuItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					hbt.save(menuItemFormula);
					saved = true;
				} else {
					saved = false;
					map.put("existingList", existingList);
				}

			} else if (existingList.size() == 0) {
				hbt.save(menuItemFormula);
				saved = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------- Method to Edit Menu Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> editMenuItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DietMenuItemFormula> existingList = new ArrayList<DietMenuItemFormula>();
		Session session = getSession();
		boolean updated = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int menuItemFormulaId = box.getInt(COMMON_ID);
		int dietCombinationId = box.getInt(DIET_COMBINATION_ID);
		int dietItemsId = box.getInt(DIET_ITEMS_ID);
		String menuType = box.getString(MENU_TYPE);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));
		String patientCategory = box.getString(PATIENT_CATEGORY);

		try {
			DietMenuItemFormula menuItemFormula = (DietMenuItemFormula) hbt
					.load(DietMenuItemFormula.class, menuItemFormulaId);

			MasDietCombination dietCombination = new MasDietCombination();
			dietCombination.setId(dietCombinationId);
			menuItemFormula.setDietCombination(dietCombination);

			MasDietItems dietItems = new MasDietItems();
			dietItems.setId(dietItemsId);
			menuItemFormula.setDietItems(dietItems);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			menuItemFormula.setUnit(storeUnit);

			menuItemFormula.setMenuType(menuType);
			menuItemFormula
					.setQuantity(new BigDecimal(box.getString(QUANTITY)));
			menuItemFormula.setPatientCategory(patientCategory);
			menuItemFormula.setValidityStartDate(validFromDate);
			menuItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			menuItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			menuItemFormula.setLastChgTime(box.getString(CHANGED_TIME));

			existingList = session.createCriteria(DietMenuItemFormula.class)
					.add(Restrictions.eq("MenuType", menuType))
					.add(Restrictions.eq("PatientCategory", patientCategory))
					.add(
							Restrictions.not(Expression.eq("Id",
									menuItemFormulaId))).createAlias(
							"DietItems", "di").add(
							Restrictions.eq("di.Id", dietItemsId)).createAlias(
							"DietCombination", "dc").add(
							Restrictions.eq("dc.Id", dietCombinationId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietMenuItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietMenuItemFormula itemFormula = (DietMenuItemFormula) hbt
							.load(DietMenuItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					updated = true;
				} else {
					updated = false;
					map.put("existingList", existingList);
				}
			} else if (existingList.size() == 0) {
				hbt.update(menuItemFormula);
				updated = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("updated", updated);
		return map;
	}

	/**
	 * --------------------------- Method to delete Menu Item Formula details
	 * -----------------------------------
	 *
	 */

	public Map<String, Object> deleteMenuItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		boolean deleted = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int menuItemFormulaId = box.getInt(COMMON_ID);
		String changedBy = box.getString(CHANGED_BY);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType((String) box
				.getString(CHANGED_DATE));
		String changedTime = box.getString(CHANGED_TIME);

		try {
			DietMenuItemFormula dietMenuItemFormula = (DietMenuItemFormula) hbt
					.load(DietMenuItemFormula.class, menuItemFormulaId);
			dietMenuItemFormula.setStatus("n");
			dietMenuItemFormula.setLastChgBy(changedBy);
			dietMenuItemFormula.setLastChgDate(changedDate);
			dietMenuItemFormula.setLastChgTime(changedTime);
			hbt.update(dietMenuItemFormula);
			deleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("deleted", deleted);
		return map;
	}

	/**
	 * --------------------------- Method to Search Menu Item Formula
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMenuItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietMenuItemFormula> menuItemFormulaList = new ArrayList<DietMenuItemFormula>();
		Session session = getSession();

		try {
			String itemName = box.getString(ITEM_NAME);
			map = showMenuItemFormulaJsp();
			menuItemFormulaList = session.createCriteria(
					DietMenuItemFormula.class).createAlias("DietItems", "di")
					.add(Restrictions.like("di.DietItemsName", itemName + "%"))
					.list();
			map.put("menuItemFormulaList", menuItemFormulaList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to show Extra Item Formula jsp
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showExtraItemFormulaJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<DietExtraItemFormula> extraItemFormulaList = new ArrayList<DietExtraItemFormula>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
		List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();

		Session session = (Session) getSession();

		try {
			session.clear();
			extraItemFormulaList = session.createCriteria(
					DietExtraItemFormula.class).list();
			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.eq("ExtraItem", "y")).add(
							Restrictions.eq("Status", "y")).list();
			uomList = session.createCriteria(MasStoreUnit.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("extraItemFormulaList", extraItemFormulaList);
		map.put("indentItemList", indentItemList);
		map.put("uomList", uomList);

		return map;
	}

	/**
	 * --------------------------- Method to submit Extra Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addExtraItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		DietExtraItemFormula extraItemFormula = new DietExtraItemFormula();
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();
		Session session = getSession();
		boolean saved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int itemId = box.getInt(ITEM_ID);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));

		try {

			MasDietIndentItem indentItem = new MasDietIndentItem();
			indentItem.setId(itemId);
			extraItemFormula.setIndentItem(indentItem);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			extraItemFormula.setUnit(storeUnit);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			extraItemFormula.setHospital(hospital);

			extraItemFormula.setExtraScale(box.getInt(EXTRA_SCALE));
			extraItemFormula.setValidityStartDate(validFromDate);
			extraItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			extraItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			extraItemFormula.setLastChgTime(box.getString(CHANGED_TIME));
			extraItemFormula.setStatus("y");

			existingList = session.createCriteria(DietExtraItemFormula.class)
					.createAlias("IndentItem", "i").add(
							Restrictions.eq("i.Id", itemId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietExtraItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietExtraItemFormula itemFormula = (DietExtraItemFormula) hbt
							.load(DietExtraItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					hbt.save(extraItemFormula);
					saved = true;
				} else {
					saved = false;
					map.put("existingList", existingList);
				}

			} else if (existingList.size() == 0) {
				hbt.save(extraItemFormula);
				saved = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------- Method to Edit Extra Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> editExtraItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();
		Session session = (Session) getSession();
		boolean updated = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int extraItemFormulaId = box.getInt(COMMON_ID);
		int itemId = box.getInt(ITEM_ID);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));

		try {
			existingList = session.createCriteria(DietExtraItemFormula.class)
					.add(
							Restrictions.not(Expression.eq("Id",
									extraItemFormulaId))).add(
							Restrictions.eq("Status", "y")).createAlias(
							"IndentItem", "i").add(
							Restrictions.eq("i.Id", itemId)).list();

			DietExtraItemFormula extraItemFormula = new DietExtraItemFormula();

			extraItemFormula = (DietExtraItemFormula) hbt.load(
					DietExtraItemFormula.class, extraItemFormulaId);

			MasDietIndentItem indentItem = new MasDietIndentItem();
			indentItem.setId(itemId);
			extraItemFormula.setIndentItem(indentItem);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			extraItemFormula.setUnit(storeUnit);

			extraItemFormula.setExtraScale(box.getInt(EXTRA_SCALE));
			extraItemFormula.setValidityStartDate(validFromDate);
			extraItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			extraItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			extraItemFormula.setLastChgTime(box.getString(CHANGED_TIME));
			extraItemFormula.setStatus("y");

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietExtraItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else if (HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateEqual";
						break;
					}

				}
				if (flag.equals("dateNotEqual")) {
					DietExtraItemFormula itemFormula = (DietExtraItemFormula) hbt
							.load(DietExtraItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					hbt.update(extraItemFormula);
					updated = true;
				} else if (flag.equals("dateEqual")) {
					updated = false;
					map.put("existingList", existingList);

				}
			} else if (existingList.size() == 0) {
				hbt.update(extraItemFormula);
				updated = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("updated", updated);
		return map;
	}

	/**
	 * --------------------------- Method to delete Extra Item Formula details
	 * -----------------------------------
	 *
	 */

	public Map<String, Object> deleteExtraItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		boolean deleted = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int extraItemFormulaId = box.getInt(COMMON_ID);
		String changedBy = box.getString(CHANGED_BY);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType((String) box
				.getString(CHANGED_DATE));
		String changedTime = box.getString(CHANGED_TIME);

		try {
			DietExtraItemFormula dietExtraItemFormula = (DietExtraItemFormula) hbt
					.load(DietExtraItemFormula.class, extraItemFormulaId);
			dietExtraItemFormula.setStatus("n");
			dietExtraItemFormula.setLastChgBy(changedBy);
			dietExtraItemFormula.setLastChgDate(changedDate);
			dietExtraItemFormula.setLastChgTime(changedTime);
			hbt.update(dietExtraItemFormula);
			deleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("deleted", deleted);
		return map;
	}

	/**
	 * --------------------------- Method to Search Extra Item Formula
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchExtraItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietExtraItemFormula> extraItemFormulaList = new ArrayList<DietExtraItemFormula>();
		Session session = getSession();

		try {
			String itemName = box.getString(ITEM_NAME);
			map = showExtraItemFormulaJsp();
			extraItemFormulaList = session
					.createCriteria(DietExtraItemFormula.class)
					.createAlias("IndentItem", "di")
					.add(Restrictions.like("di.IndentItemName", itemName + "%"))
					.list();
			map.put("extraItemFormulaList", extraItemFormulaList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to show Indent Item Formula jsp
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIndentItemFormulaJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<DietIndentItemFormula> indentItemFormulaList = new ArrayList<DietIndentItemFormula>();
		List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
		List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();

		Session session = (Session) getSession();

		try {
			session.clear();
			indentItemFormulaList = session.createCriteria(
					DietIndentItemFormula.class).list();
			indentItemList = session.createCriteria(MasDietIndentItem.class)
					.add(Restrictions.eq("Status", "y")).list();
			uomList = session.createCriteria(MasStoreUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dietCombinationList", dietCombinationList);
		map.put("indentItemFormulaList", indentItemFormulaList);
		map.put("indentItemList", indentItemList);
		map.put("uomList", uomList);

		return map;
	}

	/**
	 * --------------------------- Method to submit Indent Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addIndentItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		DietIndentItemFormula indentItemFormula = new DietIndentItemFormula();
		List<DietIndentItemFormula> existingList = new ArrayList<DietIndentItemFormula>();
		Session session = getSession();
		boolean saved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int dietCombinationId = box.getInt(DIET_COMBINATION_ID);
		int itemsId = box.getInt(ITEM_ID);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));
		String patientCategory = box.getString(PATIENT_CATEGORY);

		try {

			MasDietCombination dietCombination = new MasDietCombination();
			dietCombination.setId(dietCombinationId);
			indentItemFormula.setDietCombination(dietCombination);

			MasDietIndentItem indentItems = new MasDietIndentItem();
			indentItems.setId(itemsId);
			indentItemFormula.setIndentItem(indentItems);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			indentItemFormula.setUnit(storeUnit);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			indentItemFormula.setHospital(hospital);

			indentItemFormula.setQuantity(new BigDecimal(box
					.getString(QUANTITY)));
			indentItemFormula.setPatientCategory(patientCategory);
			indentItemFormula.setValidityStartDate(validFromDate);
			indentItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			indentItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			indentItemFormula.setLastChgTime(box.getString(CHANGED_TIME));
			indentItemFormula.setStatus("y");

			existingList = session.createCriteria(DietIndentItemFormula.class)
					.add(Restrictions.eq("PatientCategory", patientCategory))
					.createAlias("IndentItem", "i").add(
							Restrictions.eq("i.Id", itemsId)).createAlias(
							"DietCombination", "dc").add(
							Restrictions.eq("dc.Id", dietCombinationId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietIndentItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietIndentItemFormula itemFormula = (DietIndentItemFormula) hbt
							.load(DietIndentItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					hbt.save(indentItemFormula);
					saved = true;
				} else {
					saved = false;
					map.put("existingList", existingList);
				}

			} else if (existingList.size() == 0) {
				hbt.save(indentItemFormula);
				saved = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	/**
	 * --------------------------- Method to Edit Indent Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> editIndentItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DietIndentItemFormula> existingList = new ArrayList<DietIndentItemFormula>();
		Session session = getSession();
		boolean updated = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int indentItemFormulaId = box.getInt(COMMON_ID);
		int dietCombinationId = box.getInt(DIET_COMBINATION_ID);
		int itemsId = box.getInt(ITEM_ID);
		Date validFromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(VALID_FROM_DATE));
		String patientCategory = box.getString(PATIENT_CATEGORY);

		try {
			DietIndentItemFormula indentItemFormula = (DietIndentItemFormula) hbt
					.load(DietIndentItemFormula.class, indentItemFormulaId);

			MasDietCombination dietCombination = new MasDietCombination();
			dietCombination.setId(dietCombinationId);
			indentItemFormula.setDietCombination(dietCombination);

			MasDietIndentItem indentItems = new MasDietIndentItem();
			indentItems.setId(itemsId);
			indentItemFormula.setIndentItem(indentItems);

			MasStoreUnit storeUnit = new MasStoreUnit();
			storeUnit.setId(box.getInt(UNIT_ID));
			indentItemFormula.setUnit(storeUnit);

			indentItemFormula.setQuantity(new BigDecimal(box
					.getString(QUANTITY)));
			indentItemFormula.setPatientCategory(patientCategory);
			indentItemFormula.setValidityStartDate(validFromDate);
			indentItemFormula.setLastChgBy(box.getString(CHANGED_BY));
			indentItemFormula.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			indentItemFormula.setLastChgTime(box.getString(CHANGED_TIME));

			existingList = session.createCriteria(DietIndentItemFormula.class)
					.add(Restrictions.eq("PatientCategory", patientCategory))
					.add(
							Restrictions.not(Expression.eq("Id",
									indentItemFormulaId))).createAlias(
							"IndentItem", "i").add(
							Restrictions.eq("i.Id", itemsId)).createAlias(
							"DietCombination", "dc").add(
							Restrictions.eq("dc.Id", dietCombinationId)).list();

			Date validityStartDate = null;
			int id = 0;
			String flag = "";
			if (existingList.size() > 0) {
				for (DietIndentItemFormula obj : existingList) {
					id = obj.getId();
					validityStartDate = obj.getValidityStartDate();
					if (!HMSUtil.changeDateToddMMyyyy(validityStartDate)
							.equals(box.getString(VALID_FROM_DATE))) {
						flag = "dateNotEqual";
					} else {
						flag = "dateEqual";
						break;
					}
				}

				if (flag.equals("dateNotEqual")) {
					DietIndentItemFormula itemFormula = (DietIndentItemFormula) hbt
							.load(DietIndentItemFormula.class, id);
					itemFormula.setStatus("n");
					hbt.update(itemFormula);
					updated = true;
				} else {
					updated = false;
					map.put("existingList", existingList);
				}
			} else if (existingList.size() == 0) {
				hbt.update(indentItemFormula);
				updated = true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		map.put("updated", updated);
		return map;
	}

	/**
	 * --------------------------- Method to delete Indent Item Formula details
	 * -----------------------------------
	 *
	 */

	public Map<String, Object> deleteIndentItemFormula(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();

		boolean deleted = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int indentItemFormulaId = box.getInt(COMMON_ID);
		String changedBy = box.getString(CHANGED_BY);
		Date changedDate = HMSUtil.convertStringTypeDateToDateType((String) box
				.getString(CHANGED_DATE));
		String changedTime = box.getString(CHANGED_TIME);

		try {
			DietIndentItemFormula indentItemFormula = (DietIndentItemFormula) hbt
					.load(DietIndentItemFormula.class, indentItemFormulaId);
			indentItemFormula.setStatus("n");
			indentItemFormula.setLastChgBy(changedBy);
			indentItemFormula.setLastChgDate(changedDate);
			indentItemFormula.setLastChgTime(changedTime);
			hbt.update(indentItemFormula);
			deleted = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("deleted", deleted);
		return map;
	}

	/**
	 * --------------------------- Method to Search Extra Item Formula
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchIndentItemFormula(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DietIndentItemFormula> indentItemFormulaList = new ArrayList<DietIndentItemFormula>();
		Session session = getSession();

		try {
			String itemName = box.getString(ITEM_NAME);
			map = showMenuItemFormulaJsp();
			indentItemFormulaList = session.createCriteria(
					DietIndentItemFormula.class)
					.createAlias("IndentItem", "di").add(
							Restrictions.like("di.IndentItemName", itemName
									+ "%")).list();
			map.put("indentItemFormulaList", indentItemFormulaList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to show Menu Item Formula jsp
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListForDietChange(int departmentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();

		String deptName = "";

		Session session = getSession();

		try {
			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Id", departmentId)).list();

			patientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdStatus", "A")).createAlias("Department",
					"d").add(Restrictions.eq("d.Id", departmentId)).list();

			dietList = session.createCriteria(MasDiet.class).add(
					Restrictions.eq("Status", "y")).list();

			dietTypeList = session.createCriteria(MasDietType.class).add(
					Restrictions.eq("Status", "y")).list();
			dietCombinationList = session.createCriteria(
					MasDietCombination.class).add(
					Restrictions.eq("Status", "y")).list();
			if (deptList.size() > 0) {
				MasDepartment masDepartment = (MasDepartment) deptList.get(0);
				deptName = masDepartment.getDepartmentName();
				map.put("deptName", deptName);
			}

			map.put("dietList", dietList);
			map.put("dietTypeList", dietTypeList);
			map.put("dietCombinationList", dietCombinationList);
			map.put("patientList", patientList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addPatientDietDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		boolean flag = false;

		int hospitalId = box.getInt("hospitalId");

		Vector hinId = box.getVector(HIN_ID);
		Vector inpatientId = box.getVector(INPATIENT_ID);
		Vector dietId = box.getVector(DIET_ID);
		Vector dietTypeId = box.getVector(DIET_TYPE_ID);
		Vector dietCombinationId = box.getVector(DIET_COMBINATION_ID);
		Vector condition = box.getVector(CONDITION);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			for (int i = 0; i < hinId.size(); i++) {
				DietDetails dietDetails = new DietDetails();

				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				dietDetails.setHospital(hospital);

				try {
					Patient patient = new Patient();
					patient.setId(Integer.parseInt((String) hinId.get(i)));
					dietDetails.setHin(patient);

					Inpatient inpatient = new Inpatient();
					inpatient.setId(Integer.parseInt((String) inpatientId
							.get(i)));
					dietDetails.setInpatient(inpatient);

					if (dietId.get(i) != null && !(dietId.get(i).equals(""))) {
						MasDiet diet = new MasDiet();
						diet.setId(Integer.parseInt((String) dietId.get(i)));
						dietDetails.setDiet(diet);
					}

					if (dietTypeId.get(i) != null
							&& !(dietTypeId.get(i).equals(""))) {
						MasDietType dietType = new MasDietType();
						dietType.setId(Integer.parseInt((String) dietTypeId
								.get(i)));
						dietDetails.setDietType(dietType);
					}

					if (dietCombinationId.get(i) != null
							&& !(dietCombinationId.get(i).equals(""))) {
						MasDietCombination dietCombination = new MasDietCombination();
						dietCombination.setId(Integer
								.parseInt((String) dietCombinationId.get(i)));
						dietDetails.setDietCombination(dietCombination);
					}

					if (condition.get(i) != null
							&& !(condition.get(i).equals(""))) {
						dietDetails.setPatientCondition((String) condition
								.get(i));
					}

					dietDetails.setLastChgBy(box.getString("userName"));
					dietDetails.setLastChgDate(changeDate);
					dietDetails.setLastChgTime(time);
					dietDetails.setStatus("y");

					hbt.save(dietDetails);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				flag = true;

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPendingPatientDietList(Map<String, Object> map) {

		List<OpdPatientDetails> pendingPatientDietList = new ArrayList<OpdPatientDetails>();
		Date toDate =null;
		Session session = (Session) getSession();
		String hin_no="";
		String p_first_name="";
		String p_middle_name="";
		String p_last_name="";


		if (map.get("hin_no") != null) {
			hin_no = (String) map.get("hin_no");
		}
		if (map.get("p_first_name") != null) {
			p_first_name = (String) map.get("p_first_name");
		}
		if (map.get("p_middle_name") != null) {
			p_middle_name = (String) map.get("p_middle_name");
		}
		if (map.get("p_last_name") != null) {
			p_last_name = (String) map.get("p_last_name");
		}

		try {
			Criteria crit = session.createCriteria(OpdPatientDetails.class).add(Restrictions.isNotNull("Diet.Id"));
			crit.createAlias("Visit", "v");
			crit.createAlias("v.Hin", "hin");

			 if (!hin_no.equals("")) {
					crit = crit.add(Restrictions.eq("hin.HinNo", hin_no));
				}
				if (!p_first_name.equals("")) {
					crit = crit.add(Restrictions.like("hin.PFirstName",
							p_first_name + "%"));
				}
				if (!p_middle_name.equals("")) {
					crit = crit.add(Restrictions.like("hin.PMiddleName",
							p_middle_name + "%"));
				}
				if (!p_last_name.equals("")) {
					crit = crit.add(Restrictions.like("hin.PLastName", p_last_name
							+ "%"));
				}
				if (map.get("toDate") != null) {

					toDate =(Date)map.get("toDate");
					crit.add(Restrictions.eq("OpdDate", toDate));

				}
			 pendingPatientDietList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("pendingPatientDietList", pendingPatientDietList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPendingPatientDietDetails(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<OpdPatientDetails> pendingDietList = new ArrayList<OpdPatientDetails>();
		int Id = 0;
		if (dataMap.get("id") != null) {
			Id = (Integer) dataMap.get("id");
		}

		try {
			pendingDietList = session.createCriteria(OpdPatientDetails.class)
					.add(Restrictions.eq("Id", Id)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("pendingDietList", pendingDietList);
		return map;
	}
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> updatePatientDiet(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		boolean dataUpdated = false;
		int opdPatientId = box.getInt("opdPatientId");
		Double height = box.getDouble(HEIGHT);
		int weight = box.getInt(WEIGHT);
		String dietPatientHistory = box.getString("dietPatientHistory");
		String dietPrescribedetails = box.getString("dietPrescribedetails");
		String date = (String) utilMap.get("currentDate");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		String time = (String)utilMap.get("currentTime");

		OpdPatientDetails master = (OpdPatientDetails) getHibernateTemplate().get(OpdPatientDetails.class, opdPatientId);

		master.setId(opdPatientId);
		master.setHeight(height);
		master.setWeight(new Double(weight));
		master.setDietPatientHistory(dietPatientHistory);
		master.setDietPrescribedDetails(dietPrescribedetails);
		master.setConsultationDate(changeDate);
		master.setConsultationTime(time);

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(master);
			dataUpdated = true;
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
			dataUpdated = false;
		}

		map.put("flag", dataUpdated);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDietForIndoorPatientList(Map<String, Object> map)
	{
		List indoorPatientDietList = new ArrayList();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<MasDiet> masDietList = new ArrayList<MasDiet>();
		List<PatientDietIndoorHeader> dietIndoorHeaderList = new ArrayList<PatientDietIndoorHeader>();
		List<PatientDietIndoorDetail> dietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();

		Date toDate =null;
		Session session = (Session) getSession();
		String hin_no="";
		String p_first_name="";
		String p_middle_name="";
		String p_last_name="";
		String time ="";
		int departmentId =0;

		if (map.get("hin_no") != null) {
			hin_no = (String) map.get("hin_no");
		}
		if (map.get("p_first_name") != null) {
			p_first_name = (String) map.get("p_first_name");
		}
		if (map.get("p_middle_name") != null) {
			p_middle_name = (String) map.get("p_middle_name");
		}
		if (map.get("p_last_name") != null) {
			p_last_name = (String) map.get("p_last_name");
		}

		if (map.get("departmentId") != null) {
			departmentId = (Integer)map.get("departmentId");
		}

		try {

			Criteria crit = session.createCriteria(Inpatient.class).add(Restrictions.eq("Department.Id", departmentId)).add(Restrictions.eq("AdStatus", "A"));
			crit.createAlias("Hin", "hin");
			 if (!hin_no.equals("")) {
					crit = crit.add(Restrictions.eq("hin.HinNo", hin_no));
				}
				if (!p_first_name.equals("")) {
					crit = crit.add(Restrictions.like("hin.PFirstName",
							p_first_name + "%"));
				}
				if (!p_middle_name.equals("")) {
					crit = crit.add(Restrictions.like("hin.PMiddleName",
							p_middle_name + "%"));
				}
				if (!p_last_name.equals("")) {
					crit = crit.add(Restrictions.like("hin.PLastName", p_last_name
							+ "%"));
				}
				if (map.get("toDate") != null) {

					toDate =(Date)map.get("toDate");
					crit.add(Restrictions.eq("DateOfAddmission", toDate));
				}
				indoorPatientDietList = crit.list();
				if (map.get("time") != null) {
					time = (String)map.get("time");
				}
		dietIndoorHeaderList = session.createCriteria(PatientDietIndoorHeader.class)
										.add(Restrictions.eq("Time", time))
										.add(Restrictions.eq("Dateofcreation", toDate))
										.add(Restrictions.eq("Departments.Id", departmentId)) .list();
		if(dietIndoorHeaderList!=null && dietIndoorHeaderList.size()>0)
		{
			PatientDietIndoorHeader header =(PatientDietIndoorHeader)dietIndoorHeaderList.get(0);
			int headerId = header.getId();
			dietIndoorDetailList = session.createCriteria(PatientDietIndoorDetail.class)
								   .add(Restrictions.eq("HId.Id", headerId)).list();
			//

			if(dietIndoorDetailList!=null && dietIndoorDetailList.size()>0)
			{
				indoorPatientDietList = session.createCriteria(INPATIENTDIETVIEW.class)
										.add(Restrictions.eq("DepartmentId", departmentId))
										.add(Restrictions.eq("Time", time))
										.add(Restrictions.eq("DateOfCreation", toDate)).list();
			}
		}
		masEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Department.Id", departmentId)).list();
		masDietList = session.createCriteria(MasDiet.class).add(Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("indoorPatientDietList", indoorPatientDietList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("masDietList", masDietList);
		map.put("dietIndoorDetailList", dietIndoorDetailList);
		return map;

	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateIndoorPatientDiet(Box box)
	{

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		boolean dataUpdated = false;
		Session session = (Session) getSession();
		Transaction tx = null;
		int counter   = box.getInt("counter");
		String date = (String) utilMap.get("currentDate");

		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);

		String currentTime = (String)utilMap.get("currentTime");
		List<Object[]> indoorHeader = new ArrayList<Object[]>();
	    List<Object[]> indoorDetail = new ArrayList<Object[]>();
		try
		{
				tx = session.beginTransaction();

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				PatientDietIndoorHeader dietHeader = new PatientDietIndoorHeader();

				String strDate =box.getString(TO_DATE).substring(6, 10)+"-"+box.getString(TO_DATE).substring(3, 5)+"-"+box.getString(TO_DATE).substring(0,2);
				indoorHeader = hbt.find("select header.Id,header.Dateofcreation,header.Preparedby from jkt.hms.masters.business.PatientDietIndoorHeader as header join header.Departments as dept  where header.Dateofcreation ='"+strDate+"' and header.Time='"+box.getString("time")+"' and dept.Id="+box.getInt("departmentId"));
				if(indoorHeader.size()>0)
				{
					for(Object[] header : indoorHeader)
					{
						indoorDetail = hbt.find("select detail.Id,detail.MorningTeaBread from jkt.hms.masters.business.PatientDietIndoorDetail as detail join detail.HId as header where header.Id="+Integer.parseInt(header[0].toString()));

						if(indoorDetail.size()>0)
						{
							for(Object[] dtl : indoorDetail)
							{
								Object obj = session.load(PatientDietIndoorDetail.class,Integer.parseInt(dtl[0].toString()));
								session.delete(obj);
							}
						}
						Object object=session.load(PatientDietIndoorHeader.class, Integer.parseInt(header[0].toString()));
						session.delete(object);
					}

				}
				if(box.getString(TO_DATE)!=null)
				{
					dietHeader.setDateofcreation(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
					map.put(TO_DATE, strDate);
				}
				if(box.getString("employeeId")!=null)
				{
					dietHeader.setPreparedby(box.getInt("employeeId"));
				}
				if(box.getString("time")!=null)
				{
					dietHeader.setTime(box.getString("time"));
					map.put("time", box.getString("time"));
				}
				if(box.getString("userName")!=null)
				{
					dietHeader.setLastChgBy(box.getString("userName"));
				}
				if(changeDate!=null)
				{
					dietHeader.setLastChgDate(changeDate);
				}
				if(currentTime!=null)
				{
					dietHeader.setLastChgTime(currentTime);
				}
				dietHeader.setStatus(STATUS_YES);
				MasDepartment department = new  MasDepartment();
				if(box.getInt("departmentId")!=0)
				{
					department.setId(box.getInt("departmentId"));
					dietHeader.setDepartments(department);
				}
				hbt.save(dietHeader);

			if(counter!=0)
			{
				for(int i=1;i<=counter;i++)
				{

					PatientDietIndoorDetail dietDetail = new PatientDietIndoorDetail();

					if(box.getInt("parent"+i)!=0)
					{
						int parent  = box.getInt("parent"+i);
						Inpatient inpatient=new Inpatient();
						inpatient.setId(parent);
						dietDetail.setInpatient(inpatient);
					}

					dietDetail.setHId(dietHeader);

					if(box.getInt(HIN_NO+i)!=0)
					{
						Patient patient = new Patient();
						patient.setId(box.getInt(HIN_NO+i));
						dietDetail.setHin(patient);
					}
					if(box.getInt(BED_NO+i)!=0)
					{
						 MasBed bed = new MasBed();
						 bed.setId(box.getInt(BED_NO+i));
						dietDetail.setBed(bed);
					}
					if(box.getInt("dietType"+i)!=0)
					{
						int dietType = box.getInt("dietType"+i);
						MasDiet diet = new MasDiet();
						diet.setId(dietType);
						dietDetail.setDietId(diet);
					}

					if(box.getString("morningTea"+i)!=null)
					{
						dietDetail.setMorningTeaBread(box.getString("morningTea"+i));
					}
					if(box.getString("eggs"+i)!=null)
					{
						dietDetail.setEggs(box.getString("eggs"+i));
					}
					if(box.getString("lunch"+i)!=null){

						dietDetail.setLunch(box.getString("lunch"+i));
					}
					if(box.getString("eveningTea"+i)!=null){
						dietDetail.setEveningTea(box.getString("eveningTea"+i));
					}
					if(box.getString("banana"+i)!=null){

						dietDetail.setBanana(box.getString("banana"+i));
					}
					if(box.getString("dinner"+i)!=null){

						dietDetail.setDinner(box.getString("dinner"+i));
					}
					//--------------------Code add by anamika------------------------------//
					if(box.getString("remarks"+i)!=null)
					{
						dietDetail.setRemarks(box.getString("remarks"+i));
					}
					//----------------------------------------------------
					dietDetail.setLastChgBy(box.getString("userName"));
					dietDetail.setLastChgDate(changeDate);
					dietDetail.setLastChgTime(currentTime);
					dietDetail.setStatus(STATUS_YES);
					hbt.save(dietDetail);
				  }
				}
				dataUpdated = true;
				tx.commit();
			}catch (DataAccessException e)
			{
				e.printStackTrace();
				dataUpdated = false;
				tx.rollback();
			}
	map.put("flag", dataUpdated);
	return map;
	}

}
