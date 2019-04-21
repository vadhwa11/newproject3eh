package jkt.hms.stores.dataservice;

import static jkt.hms.util.RequestConstants.AU;
import static jkt.hms.util.RequestConstants.BACKLOADED;
import static jkt.hms.util.RequestConstants.BOARD_DESTROYED;
import static jkt.hms.util.RequestConstants.BOARD_SERVICABLE;
import static jkt.hms.util.RequestConstants.BOARD_UN_SERVICABLE;
import static jkt.hms.util.RequestConstants.BOS_DATE;
import static jkt.hms.util.RequestConstants.BOS_ID;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COST;
import static jkt.hms.util.RequestConstants.CRV_COST;
import static jkt.hms.util.RequestConstants.ITEMS_TO_BE_ADDED;
import static jkt.hms.util.RequestConstants.ITEMS_TO_BE_DELETED;
import static jkt.hms.util.RequestConstants.ME_SCALE_NUMBER;
import static jkt.hms.util.RequestConstants.NOMENCLATURE;
import static jkt.hms.util.RequestConstants.OBS;
import static jkt.hms.util.RequestConstants.PVMS_NO;
import static jkt.hms.util.RequestConstants.QTY;
import static jkt.hms.util.RequestConstants.REDUCED_TO;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.REPAIRABLE;
import static jkt.hms.util.RequestConstants.SERIAL_NUMBER;
import static jkt.hms.util.RequestConstants.SERVICABLE;
import static jkt.hms.util.RequestConstants.SOURCE_OF_SUPPLY;
import static jkt.hms.util.RequestConstants.SR_NO;
import static jkt.hms.util.RequestConstants.SUPPLIER_ID;
import static jkt.hms.util.RequestConstants.UN_SERVICABLE;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StoreAmcM;
import jkt.hms.masters.business.StoreAmcT;
import jkt.hms.masters.business.StoreBosM;
import jkt.hms.masters.business.StoreBosT;
import jkt.hms.masters.business.StoreCondemnationM;
import jkt.hms.masters.business.StoreCondemnationT;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StoreMeScaleDetails;
import jkt.hms.masters.business.StoreMmfDepartmentT;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreRepairCivilFirm;
import jkt.hms.masters.business.StoreWorkOrderM;
import jkt.hms.masters.business.StoreWorkOrderT;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PageUtil;
import jkt.hms.util.PagedArray;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class NonExpendableStoresDataServiceImpl extends HibernateDaoSupport
		implements NonExpendableStoresDataService {

	HibernateTransactionManager transactionManager = null;
	Session session;

	/*
	 * This method is user to evaluate auto generated number based on the year
	 * It takes one parameter that is coming from store_fy_document_no
	 */

	public String getMaxNo(String no) {
		String maxNo = "";
		String y1 = "";
		String y2 = "";
		String y3 = "";
		int tempMonth = 0;
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);
		try {

			if ((Integer.parseInt(currentYear.substring(2)) - 1) <= 9) {
				y1 = "0" + (Integer.parseInt(currentYear.substring(2)) - 1);
			} else {
				y1 = "" + (Integer.parseInt(currentYear.substring(2)) - 1);
			}

			if (Integer.parseInt(currentYear.substring(2)) <= 9) {
				y2 = "0" + Integer.parseInt(currentYear.substring(2));
			} else {
				y2 = "" + Integer.parseInt(currentYear.substring(2));
			}
			if ((Integer.parseInt(currentYear.substring(2)) + 1) <= 9) {
				y3 = "0" + (Integer.parseInt(currentYear.substring(2)) + 1);
			} else {
				y3 = "" + (Integer.parseInt(currentYear.substring(2)) + 1);
			}
		} catch (Exception e) {
		}
		try {
			if (!no.equals("")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				tempMonth = Integer.parseInt(stringTokenizer.nextToken());

				tempMonth++;

				if (currentMonth < 4) {

					maxNo = tempMonth + "/" + y1 + "-" + y2;
				} else {
					maxNo = tempMonth + "/" + y2 + "-" + y3;
				}

			} else {
				if (currentMonth < 4) {
					maxNo = "01" + "/" + y1 + "-" + y2;
				} else {
					maxNo = "01" + "/" + y2 + "-" + y3;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}

	// =======================================================================
	// ======================= methods by abha ===========================
	// =======================================================================
	// --- for non expendable grn

	public Map<String, Object> showNeGrnJsp(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<StoreGrnM> searchGrnList = new ArrayList<StoreGrnM>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreIndentM> indentForAfmsdList = new ArrayList<StoreIndentM>();
		List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
		List<StoreGrnM> grnList = new ArrayList<StoreGrnM>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreMeScale> meScaleList = new ArrayList<MasStoreMeScale>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();

		int poId = 0;
		String max = "";
		String startNo = "";
		String no = "";

		Session session = (Session) getSession();
		try {
			supplierList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreSupplier as ms where ms.Status = 'y'");
			manufacturerList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasManufacturer as mi where mi.Status = 'y'");
			searchGrnList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreGrnM as mi where mi.Department.Id='"
							+ deptId + "'");
			employeeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasEmployee as mi where mi.Status = 'y'");
			indentForAfmsdList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.StoreIndentM as mi where mi.IndentType = 'd'");
			meScaleList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreMeScale as me where me.Status = 'y'");
			unitList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status = 'y'");
			grnList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreGrnM as sgm");
			brandList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBrand as msb");
			storeFyDocumentNoList = session.createCriteria(
					StoreFyDocumentNo.class).list();
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getGrnNo() != null) {
					no = ("" + storeFyDocumentNo.getGrnNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("supplierList", supplierList);
		map.put("manufacturerList", manufacturerList);
		map.put("searchGrnList", searchGrnList);
		map.put("employeeList", employeeList);
		map.put("indentForAfmsdList", indentForAfmsdList);

		map.put("unitList", unitList);
		map.put("grnList", grnList);
		map.put("brandList", brandList);
		map.put("meScaleList", meScaleList);
		map.put("max", no);
		return map;

	}

	// add grn method
	public boolean addGrns(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		StoreGrnM storeGrnM = (StoreGrnM) infoMap.get("storeGrnM");
		MasStoreBudget masStoreBudget = (MasStoreBudget) infoMap
				.get("masStoreBudget");
		List<StoreGrnT> storeGrnTlist = (ArrayList<StoreGrnT>) infoMap
				.get("storeGrnTlist");
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		String userName = "";
		int deptId = 0;
		// int hospitalId = 0;
		String max = "";
		String no = "";

		if (infoMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + infoMap.get("deptId"));
		}
		// if(infoMap.get("hospitalId") !=null)
		// hospitalId = Integer.parseInt(""+infoMap.get("hospitalId"));
		// if(infoMap.get("userName") !=null)
		// userName = (""+infoMap.get("userName"));
		int storeFyId = 0;

		boolean successfullyAdded = false;
		StoreGrnM storeGrnM2 = new StoreGrnM();
		int indentId = 0;
		if (infoMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + infoMap.get("indentId"));
		}
		String sos = "";
		if (infoMap.get("sourceOfSupply") != ""
				|| infoMap.get("sourceOfSupply") != null) {
			sos = (String) infoMap.get("sourceOfSupply");
		}
		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			if (!(infoMap.get("headerStored") + "").equals("yes")) {
				hbt.save(storeGrnM);
				String grnNo = "";
				grnNo = (String) infoMap.get("grnNo");
				Criteria c = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId));
				storeFyDocumentNoList = c.list();
				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
				}
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setGrnNo(grnNo);
				hbt.update(storeFyDocumentNo);

				HibernateTemplate hbt3 = getHibernateTemplate();
				hbt3.setFlushModeName("FLUSH_EAGER");
				hbt3.setCheckWriteOperations(false);
				if ((sos.equalsIgnoreCase("d"))) {
					StoreIndentM storeIndentM = (StoreIndentM) getHibernateTemplate()
							.load(StoreIndentM.class, indentId);
					storeIndentM.setStatus("p");
					hbt3.update(storeIndentM);
				}

				List<MasStoreBudget> grnList = new ArrayList<MasStoreBudget>();
				int tempId = 0;
				grnList = hbt
						.find("from jkt.hms.masters.business.MasStoreBudget");
				for (MasStoreBudget masStoreBudget2 : grnList) {

					tempId = Integer.parseInt("" + masStoreBudget2.getId());

					BigDecimal bigDecimal = new BigDecimal(""
							+ storeGrnM.getGrnValue());

					String qry = "update mas_store_budget as s set s.crv_comitted_amount =(s.crv_comitted_amount+'"
							+ bigDecimal
							+ "') where budget_id='"
							+ tempId
							+ "' ";
					Query query2 = session.createSQLQuery(qry);
					int row2 = query2.executeUpdate();
				}

			}

			List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
			StoreItemBatchStock storeItemBatchStock = null;

			if (storeGrnTlist.size() > 0) {
				if ((infoMap.get("headerStored") + "").equals("yes")) {
					int id = Integer.parseInt("" + infoMap.get("grnId"));
					storeGrnM2.setId(id);
				}
				for (int i = 0; i < storeGrnTlist.size(); i++) {
					StoreGrnT storeGrnTObj = new StoreGrnT();
					storeGrnTObj = (StoreGrnT) storeGrnTlist.get(i);
					if ((infoMap.get("headerStored") + "").equals("yes")) {
						storeGrnTObj.setGrnMaster(storeGrnM2);
					} else {
						storeGrnTObj.setGrnMaster(storeGrnM);
					}

					hbt.save(storeGrnTObj);
					hbt.refresh(storeGrnTObj);

					int item_id = storeGrnTObj.getItem().getId();
					String batch_no = "";
					batch_no = storeGrnTObj.getBatchNo();
					int department_id = storeGrnM.getDepartment().getId();
					BigDecimal cost_price = storeGrnTObj.getFinalCostPrice();

					storeItemBatchStockList = hbt
							.find("from jkt.hms.masters.business.StoreItemBatchStock as inp where inp.Item.Id = "
									+ item_id
									+ "and inp.Department.Id= "
									+ department_id
									+ "and inp.BatchNo ="
									+ batch_no.valueOf("batch_no"));
					if (storeItemBatchStockList != null
							&& storeItemBatchStockList.size() > 0) {

						int free_qty = 0;
						free_qty = storeGrnTObj.getFreeQty();
						storeItemBatchStock = storeItemBatchStockList.get(0);
						BigDecimal existing_qty = storeItemBatchStock
								.getReceivedQty();
						BigDecimal recd_qty = storeGrnTObj.getReceivedQty();

						BigDecimal new_qty = new BigDecimal(0);
						new_qty = existing_qty.add(recd_qty);
						BigDecimal existing_closing_stock = storeItemBatchStock
								.getClosingStock();
						BigDecimal new_closing_stock = new BigDecimal(0);
						new_closing_stock = existing_closing_stock
								.add(recd_qty);
						BigDecimal cost_prices = storeItemBatchStock
								.getCostPrice();

						int id = storeItemBatchStock.getId();
						storeItemBatchStock = (StoreItemBatchStock) getHibernateTemplate()
								.load(StoreItemBatchStock.class, id);
						storeItemBatchStock.setReceivedQty(new_qty
								.add(new BigDecimal(free_qty)));
						storeItemBatchStock.setClosingStock(new_closing_stock
								.add(new BigDecimal(free_qty)));
						storeItemBatchStock.setBatchNo(storeGrnTObj
								.getBatchNo());
						storeItemBatchStock.setItem(storeGrnTObj.getItem());
						if (storeItemBatchStock.getCostPrice() != null) {
							BigDecimal new_cost_price = new BigDecimal(0);
							new_cost_price = cost_prices.add(cost_price);
							storeItemBatchStock.setCostPrice(new_cost_price);
						} else {
							storeItemBatchStock.setCostPrice(null);
						}

						HibernateTemplate hbt1 = getHibernateTemplate();
						hbt1.setFlushModeName("FLUSH_EAGER");
						hbt1.setCheckWriteOperations(false);
						hbt1.update(storeItemBatchStock);

					} else {
						storeItemBatchStock = new StoreItemBatchStock();
						storeItemBatchStock.setDepartment(storeGrnM
								.getDepartment());
						storeItemBatchStock.setLotNo(storeGrnTObj.getLotNo());
						storeItemBatchStock.setReceivedQty(storeGrnTObj
								.getReceivedQty());
						storeItemBatchStock.setFreeItem(storeGrnTObj
								.getFreeItem());
						storeItemBatchStock.setClosingStock(storeGrnTObj
								.getReceivedQty());
						storeItemBatchStock.setItem(storeGrnTObj.getItem());
						if (storeGrnTObj.getBatchNo().equals("0")) {
							storeItemBatchStock.setCostPrice(storeGrnTObj
									.getFinalCostPrice());
							storeItemBatchStock.setBatchNo("0");
						} else {
							storeItemBatchStock.setBatchNo(storeGrnTObj
									.getBatchNo());
							storeItemBatchStock.setCostPrice(null);
						}

						HibernateTemplate hbt1 = getHibernateTemplate();
						hbt1.setFlushModeName("FLUSH_AUTO");
						hbt1.setCheckWriteOperations(false);
						hbt1.save(storeItemBatchStock);
					}
				}
			}

			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			// throw e; // or display error message
			e.printStackTrace();
		}
		map.put("maxIndentNo", no);

		return successfullyAdded;

	}

	// end of add method
	public Map<String, Object> getListForNeGrn(String choice) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();

		if (choice.equalsIgnoreCase("P")) {
			supplierList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y'");
			map.put("first_combo", supplierList);
		} else if (choice.equalsIgnoreCase("D")) {
			unitList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status= 'y'and mi.AirForceDepotType='d'");
			map.put("first_combo", unitList);

		} else if (choice.equalsIgnoreCase("s")) {
			supplierList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y'");
			map.put("first_combo", supplierList);
		} else if (choice.equalsIgnoreCase("g")) {
			unitList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status= 'y'");
			map.put("first_combo", unitList);
		} else {
			supplierList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreSupplier as mi where mi.Status= 'y'");
			map.put("first_combo", supplierList);
		}
		map.put("choice", choice);
		return map;
	}

	public Map getResponseIndentList(Box box) {

		Map map = new HashMap();
		List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
		map.put("choice", box.getString(SOURCE_OF_SUPPLY));

		if (box.getString(SOURCE_OF_SUPPLY).equalsIgnoreCase("D")) {
			indentList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.StoreIndentM as md where md.IndentType ='d' and md.SuppliedBy.Id = "
							+ box.getInt(SUPPLIER_ID)
							+ " and md.Department.Id = " + box.getInt("deptId"));
			map.put("second_combo", indentList);
		}
		if (box.getString(SOURCE_OF_SUPPLY).equalsIgnoreCase("S")) {
			indentList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.StoreIndentM as mi where mi.IndentType ='s' and mi.SuppliedBy.Id = "
							+ box.getInt(SUPPLIER_ID)
							+ " and mi.Department.Id = " + box.getInt("deptId"));
			map.put("second_combo", indentList);
		}
		return map;
	}

	public Map<String, Object> showGridJsp(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

		List<StoreIndentT> storeIndentTList = new ArrayList<StoreIndentT>();
		List<StorePoDetail> storePoDetailList = new ArrayList<StorePoDetail>();

		int poId = 0;
		String max = "";
		String startNo = "";
		String no = "";

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			if (box.getString("sourceOfSupply").equals("d")) {
				// indent
				storeIndentTList = hbt
						.find("from jkt.hms.masters.business.StoreIndentT as inp where inp.Indent.Id = "
								+ box.getInt("indentId")
								+ " and inp.Indent.IndentType='d' ");
				for (Iterator iterator = storeIndentTList.iterator(); iterator
						.hasNext();) {
					StoreIndentT storeIndentT = (StoreIndentT) iterator.next();
					itemList.add(storeIndentT.getItem());

				}
			} else if (box.getString("sourceOfSupply").equals("s")) {
				// indent
				storeIndentTList = hbt
						.find("from jkt.hms.masters.business.StoreIndentT as inp where inp.Indent.Id = "
								+ box.getInt("indentId")
								+ " and inp.Indent.IndentType !='d' ");
				for (Iterator iterator = storeIndentTList.iterator(); iterator
						.hasNext();) {
					StoreIndentT storeIndentT = (StoreIndentT) iterator.next();
					itemList.add(storeIndentT.getItem());

				}
			}

			else if (box.getString("sourceOfSupply").equals("g")
					|| box.getString("sourceOfSupply").equals("m")) {
				itemList = hbt
						.find("from jkt.hms.masters.business.MasStoreItem");
			} else if (box.getString("sourceOfSupply").equals("p")) {
				// store po detail
				storePoDetailList = hbt
						.find("from jkt.hms.masters.business.StorePoDetail as inp where inp.Po.Id = "
								+ box.getInt("indentId"));
				for (Iterator iterator = storePoDetailList.iterator(); iterator
						.hasNext();) {
					StorePoDetail storePoDetail = (StorePoDetail) iterator
							.next();
					itemList.add(storePoDetail.getItem());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (itemList != null && itemList.size() > 0) {
			for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
				MasStoreItem masStoreItem = (MasStoreItem) iterator.next();

			}
		}

		map.put("itemList", itemList);

		return map;

	}

	// --------- new GRid----------------------

	public Map<String, Object> getItemListForGrnByAutocomplete(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Box box = (Box) dataMap.get("box");
		String sos = box.getString("sourceOfSupply").trim();
		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;

		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";
			if (sos.equalsIgnoreCase("s")) {
				String qry = "Select item_id from store_indent_t where indent_id in(select indent_id  from store_indent_m where indent_id ='"
						+ indentId + "')";
				objectList = (List) session.createSQLQuery(qry).list();

				Criteria c = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.in("Id", objectList));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}
			if ((sos.equalsIgnoreCase("p")) || sos.equalsIgnoreCase("g")
					|| sos.equalsIgnoreCase("m")) {

				String qry = "Select item_id from mas_store_item where department_id ='"
						+ deptId + "';";
				objectList = (List) session.createSQLQuery(qry).list();
				Criteria c = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.in("Id", objectList));

				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}

			if (sos.equalsIgnoreCase("d")) {
				String qry = "Select item_id from store_indent_t where indent_id in(select indent_id  from store_indent_m where indent_id ='"
						+ indentId + "')";
				objectList = (List) session.createSQLQuery(qry).list();
				Criteria c = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.in("Id", objectList));
				c.setFirstResult(0);
				c.setMaxResults(10);
				itemList = c.list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	public Map<String, Object> fillItemsForGrn(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		session = (Session) getSession();
		String pvms = null;

		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		int indentId = 0;
		if (dataMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + dataMap.get("indentId"));
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(str, "%");

			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\\%");
				}
			}

			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			int itemId = 0;
			for (MasStoreItem masStoreItem : itemList) {
				itemId = masStoreItem.getId();

			}
			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map searchGrn(Map searchFieldMap) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		List<StoreGrnM> gridGrnHeaderList = new ArrayList<StoreGrnM>();
		List<StoreGrnT> gridGrnDetailList = new ArrayList<StoreGrnT>();
		String grnNo = "";
		try {
			if ((!searchFieldMap.get("fromDate").equals(""))
					&& (!searchFieldMap.get("toDate").equals(""))) {
				fromDate = (String) searchFieldMap.get("fromDate");
				toDate = (String) searchFieldMap.get("toDate");

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL1 = formatterOut.format(formatterIn
						.parse(fromDate));
				String date4MySQL2 = formatterOut.format(formatterIn
						.parse(toDate));
				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
				java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);

				gridGrnDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreGrnT ");
				gridGrnHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreGrnM as poh where "
								+ " poh.GrnDate between '" + startDate
								+ "' and '" + endDate + "'");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!searchFieldMap.get("grnNo").equals("0")) {

				grnNo = (String) searchFieldMap.get("grnNo");
				gridGrnDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreGrnT ");
				gridGrnHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreGrnM as pod where pod.GrnNo = '"
								+ grnNo + "'");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("gridGrnDetailList", gridGrnDetailList);
		map.put("gridGrnHeaderList", gridGrnHeaderList);

		return map;
	}

	// ----------------- NON EXPANDABLE LOANIN---------------------

	public Map showNeLoanInJsp(Box box, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<StoreLoaninM> searchLoanInList = new ArrayList<StoreLoaninM>();
		List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<StoreGrnM> grnList = new ArrayList<StoreGrnM>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreMeScale> meScaleList = new ArrayList<MasStoreMeScale>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();

		String max = "";
		String startNo = "";
		String no = "";

		Session session = (Session) getSession();
		try {
			searchLoanInList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreLoaninM as sl");
			supplierList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreSupplier as ms where ms.Status = 'y'");
			manufacturerList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasManufacturer as mi where mi.Status = 'y'");
			employeeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasEmployee as mi where mi.Status = 'y'");
			unitList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreAirForceDepot as mi where mi.Status = 'y'");
			poList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.StorePoHeader as mi where mi.Status = 'y'");
			meScaleList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreMeScale as me where me.Status = 'y'");
			brandList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasStoreBrand as msb");
			storeFyDocumentNoList = (List) getHibernateTemplate()
					.find("from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
							+ deptId + "'");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getLoaninNo() != null) {
					no = ("" + storeFyDocumentNo.getLoaninNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("supplierList", supplierList);
		map.put("manufacturerList", manufacturerList);
		map.put("employeeList", employeeList);
		map.put("unitList", unitList);
		map.put("grnList", grnList);
		map.put("brandList", brandList);
		map.put("meScaleList", meScaleList);
		map.put("poList", poList);
		map.put("searchLoanInList", searchLoanInList);
		map.put("max", no);
		return map;

	}

	// ---------- adding loanin
	public boolean addLoanIn(Map<String, Object> infoMap) {
		StoreLoaninM storeLoaninM = (StoreLoaninM) infoMap.get("storeLoaninM");
		List<StoreLoaninT> storeLoaninTlist = (ArrayList<StoreLoaninT>) infoMap
				.get("storeLoaninTlist");
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		boolean successfullyAdded = false;
		StoreItemBatchStock storeItemBatchStock1 = new StoreItemBatchStock();
		StoreLoaninM storeLoaninM2 = new StoreLoaninM();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String max = "";
		String no = "";

		if (infoMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + infoMap.get("deptId"));
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + infoMap.get("hospitalId"));
		}
		if (infoMap.get("userName") != null) {
			userName = ("" + infoMap.get("userName"));
		}
		int storeFyId = 0;

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (!(infoMap.get("headerStored") + "").equals("yes")) {

				hbt.save(storeLoaninM);
				int poId = storeLoaninM.getId();
				String loanInNo = "";
				loanInNo = (String) infoMap.get("loanInNo");
				Criteria c = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId));
				storeFyDocumentNoList = c.list();
				for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
					storeFyId = documentNo.getId();
				}
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
						.load(StoreFyDocumentNo.class, storeFyId);
				storeFyDocumentNo.setLoaninNo(loanInNo);
				hbt.update(storeFyDocumentNo);

			}

			List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();

			StoreItemBatchStock storeItemBatchStock = null;

			if (storeLoaninTlist.size() > 0) {

				if ((infoMap.get("headerStored") + "").equals("yes")) {
					int id = Integer.parseInt("" + infoMap.get("loanInId"));
					storeLoaninM2.setId(id);
				}

				for (int i = 0; i < storeLoaninTlist.size(); i++) {
					StoreLoaninT StoreLoaninTObj = new StoreLoaninT();
					StoreLoaninTObj = (StoreLoaninT) storeLoaninTlist.get(i);
					if ((infoMap.get("headerStored") + "").equals("yes")) {

						StoreLoaninTObj.setLoaninMaster(storeLoaninM2);
					} else {
						StoreLoaninTObj.setLoaninMaster(storeLoaninM);
					}
					hbt.save(StoreLoaninTObj);

					int item_id = StoreLoaninTObj.getItem().getId();

					String batch_no = StoreLoaninTObj.getBatchNo();
					int department_id = storeLoaninM.getDepartment().getId();
					BigDecimal cost_price = StoreLoaninTObj.getFinalCostPrice();

					storeItemBatchStockList = hbt
							.find("from jkt.hms.masters.business.StoreItemBatchStock as inp where inp.Item.Id = "
									+ item_id
									+ " and inp.Department.Id= "
									+ department_id
									+ " and inp.BatchNo ="
									+ batch_no.valueOf("batch_no"));
					if (storeItemBatchStockList != null
							&& storeItemBatchStockList.size() > 0) {

						int free_qty = 0;
						free_qty = StoreLoaninTObj.getFreeQty();
						storeItemBatchStock = storeItemBatchStockList.get(0);
						BigDecimal existing_qty = storeItemBatchStock
								.getReceivedQty();
						BigDecimal recd_qty = StoreLoaninTObj.getReceivedQty();

						BigDecimal new_qty = new BigDecimal(0);
						new_qty = existing_qty.add(recd_qty);
						BigDecimal existing_closing_stock = storeItemBatchStock
								.getClosingStock();
						BigDecimal new_closing_stock = new BigDecimal(0);
						new_closing_stock = existing_closing_stock
								.add(recd_qty);
						BigDecimal cost_prices = storeItemBatchStock
								.getCostPrice();

						int id = storeItemBatchStock.getId();
						storeItemBatchStock = (StoreItemBatchStock) getHibernateTemplate()
								.load(StoreItemBatchStock.class, id);
						storeItemBatchStock.setReceivedQty(new_qty
								.add(new BigDecimal(free_qty)));
						storeItemBatchStock.setClosingStock(new_closing_stock
								.add(new BigDecimal(free_qty)));
						storeItemBatchStock.setBatchNo(StoreLoaninTObj
								.getBatchNo());
						storeItemBatchStock.setItem(StoreLoaninTObj.getItem());
						if (storeItemBatchStock.getCostPrice() != null) {
							BigDecimal new_cost_price = new BigDecimal(0);
							new_cost_price = cost_prices.add(cost_price);
							storeItemBatchStock.setCostPrice(new_cost_price);
						} else {
							storeItemBatchStock.setCostPrice(null);
						}

						HibernateTemplate hbt1 = getHibernateTemplate();
						hbt1.setFlushModeName("FLUSH_EAGER");
						hbt1.setCheckWriteOperations(false);
						hbt1.update(storeItemBatchStock);

					} else {
						storeItemBatchStock = new StoreItemBatchStock();
						storeItemBatchStock.setDepartment(storeLoaninM
								.getDepartment());
						storeItemBatchStock
								.setLotNo(StoreLoaninTObj.getLotNo());
						storeItemBatchStock.setReceivedQty(StoreLoaninTObj
								.getReceivedQty());
						storeItemBatchStock.setFreeItem(StoreLoaninTObj
								.getFreeItem());
						storeItemBatchStock.setClosingStock(StoreLoaninTObj
								.getReceivedQty());
						storeItemBatchStock.setItem(StoreLoaninTObj.getItem());
						if (StoreLoaninTObj.getBatchNo().equals("0")) {
							storeItemBatchStock.setCostPrice(StoreLoaninTObj
									.getFinalCostPrice());
							storeItemBatchStock.setBatchNo("0");
						} else {
							storeItemBatchStock.setBatchNo(StoreLoaninTObj
									.getBatchNo());
							storeItemBatchStock.setCostPrice(null);
						}

						HibernateTemplate hbt1 = getHibernateTemplate();
						hbt1.setFlushModeName("FLUSH_AUTO");
						hbt1.setCheckWriteOperations(false);
						hbt1.save(storeItemBatchStock);
						hbt.refresh(storeItemBatchStock);

					}
				}
			}

			successfullyAdded = true;
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}

		return successfullyAdded;
	}

	public Map searchLoanin(Map searchFieldMap) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		List<StoreLoaninM> gridLoaninHeaderList = new ArrayList<StoreLoaninM>();
		List<StoreLoaninT> gridLoaninDetailList = new ArrayList<StoreLoaninT>();
		String loanInNo = "";
		try {
			if ((!searchFieldMap.get("fromDate").equals(""))
					&& (!searchFieldMap.get("toDate").equals(""))) {
				fromDate = (String) searchFieldMap.get("fromDate");
				toDate = (String) searchFieldMap.get("toDate");

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL1 = formatterOut.format(formatterIn
						.parse(fromDate));
				String date4MySQL2 = formatterOut.format(formatterIn
						.parse(toDate));
				java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
				java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);

				gridLoaninDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreLoaninT ");
				gridLoaninHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreLoaninM as poh where "
								+ " poh.GrnDate between '" + startDate
								+ "' and '" + endDate + "'");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!searchFieldMap.get("loanInNo").equals("0")) {
				loanInNo = (String) searchFieldMap.get("loanInNo");
				gridLoaninDetailList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreLoaninT ");
				gridLoaninHeaderList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreLoaninM as pod where pod.LoaninNo = '"
								+ loanInNo + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("gridLoaninDetailList", gridLoaninDetailList);
		map.put("gridLoaninHeaderList", gridLoaninHeaderList);

		return map;
	}

	public Map<String, Object> modifyLoanin(int loanInId, int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreLoaninT> storeLoanInTList = new ArrayList<StoreLoaninT>();
		List<StoreLoaninM> storeLoanInMList = new ArrayList<StoreLoaninM>();

		int firstResult = 0;
		int maxResults = 10;

		if (pageNo != 0) {
			firstResult = firstResult + (pageNo) * 10;
		}

		Session session = (Session) getSession();
		Criteria c = session.createCriteria(StoreLoaninT.class).add(
				Restrictions.eq("LoaninMaster.Id", loanInId));
		c.setFirstResult(firstResult);
		c.setMaxResults(maxResults);
		storeLoanInTList = c.list();

		storeLoanInMList = session.createCriteria(StoreLoaninM.class)
				.add(Restrictions.eq("Id", loanInId)).list();

		map.put("storeLoanInTList", storeLoanInTList);
		map.put("storeLoanInMList", storeLoanInMList);
		return map;
	}

	// --------- new GRid----------------------

	public Map<String, Object> getItemListForLoanInByAutocomplete(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Box box = (Box) dataMap.get("box");
		String sos = box.getString("sourceOfSupply").trim();
		String pvmsNo = null;
		int deptId = 0;
		int indentId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		indentId = Integer.parseInt("" + dataMap.get("indentId"));
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";

			String qry = "Select item_id from mas_store_item where department_id ='"
					+ deptId + "';";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.like("Nomenclature", str))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.in("Id", objectList));

			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	public Map<String, Object> fillItemsForLoanIn(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		session = (Session) getSession();
		String pvms = null;

		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		int indentId = 0;
		if (dataMap.get("indentId") != null) {
			indentId = Integer.parseInt("" + dataMap.get("indentId"));
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("nomenclature");
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(str, "%");

			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\\%");
				}
			}

			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			int itemId = 0;
			for (MasStoreItem masStoreItem : itemList) {
				itemId = masStoreItem.getId();

			}
			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	// =================== WORK ORDER=================
	public Map<String, Object> showWorkOrderJsp(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		String departmentName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}
		if (dataMap.get("departmentName") != null) {
			departmentName = ("" + dataMap.get("departmentName"));
		}

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreWorkOrderM> searchWorkOrderList = new ArrayList<StoreWorkOrderM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();

		String max = "";
		String startNo = "";
		String no = "";

		Session session = (Session) getSession();
		try {
			departmentList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasDepartment as ms where ms.Status = 'y'");
			searchWorkOrderList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreWorkOrderM as mi");
			storeFyDocumentNoList = (List) getHibernateTemplate()
					.find("from jkt.hms.masters.business.StoreFyDocumentNo as sfdn where sfdn.Department.Id='"
							+ deptId + "'");
			for (StoreFyDocumentNo storeFyDocumentNo : storeFyDocumentNoList) {
				if (storeFyDocumentNo.getWorkOrderNo() != null) {
					no = ("" + storeFyDocumentNo.getWorkOrderNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("departmentList", departmentList);
		map.put("searchWorkOrderList", searchWorkOrderList);

		map.put("max", no);
		return map;

	}

	public Map<String, Object> getItemListForWorkOrderByAutocomplete(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Box box = (Box) dataMap.get("box");

		String pvmsNo = null;
		int deptId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		List objectList = new ArrayList();
		try {
			String str = dataMap.get("autoHint") + "%";

			String qry = "SELECT item_id FROM store_item_batch_stock where department_id='"
					+ deptId + "';";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.like("Nomenclature", str))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		map.put("objectList", objectList);
		return map;
	}

	public Map<String, Object> fillItemsForWorkOrder(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		session = (Session) getSession();
		String pvms = null;

		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "" + dataMap.get("pvmsNo");
			StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(str, "%");

			while (s.hasMoreTokens()) {
				output_str.append(s.nextToken());
				if (s.hasMoreTokens()) {
					output_str.append("\\%");
				}
			}

			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			int itemId = 0;
			for (MasStoreItem masStoreItem : itemList) {
				itemId = masStoreItem.getId();

			}
			if (itemId != 0) {
				Criteria c3 = session.createCriteria(StoreItemBatchStock.class)
						.add(Restrictions.eq("Item.Id", itemId))
						.add(Restrictions.eq("Department.Id", deptId));
				batchList = c3.list();
			}
			map.put("batchList", batchList);
			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	public List<StoreWorkOrderM> getWorkOrderList() {
		Session session = (Session) getSession();
		List<StoreWorkOrderM> workOrderList = session
				.createCriteria(StoreWorkOrderM.class)
				.add(Restrictions.eq("Status", "o")).list();
		return workOrderList;
	}

	// ========== method for report ==========

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	// ========= end of method for report ================

	public boolean addWorkOrder(Map<String, Object> infoMap) {
		StoreWorkOrderM storeWorkOrderM = (StoreWorkOrderM) infoMap
				.get("storeWorkOrderM");
		List<StoreWorkOrderT> storeWorkOrderTlist = (ArrayList<StoreWorkOrderT>) infoMap
				.get("storeWorkOrderTlist");
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		boolean successfullyAdded = false;
		@SuppressWarnings("unused")
		int pageNo = 0;
		String workOrderNo = "";
		int storeFyId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (infoMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + infoMap.get("deptId"));
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + infoMap.get("hospitalId"));
		}
		if (infoMap.get("userName") != null) {
			userName = ("" + infoMap.get("userName"));
		}

		StoreWorkOrderM storeWorkOrderM2 = new StoreWorkOrderM();

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hbt.save(storeWorkOrderM);
			workOrderNo = (String) infoMap.get("workOrderNo");
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			storeFyDocumentNoList = c.list();
			for (StoreFyDocumentNo documentNo : storeFyDocumentNoList) {
				storeFyId = documentNo.getId();
			}
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) getHibernateTemplate()
					.load(StoreFyDocumentNo.class, storeFyId);
			storeFyDocumentNo.setWorkOrderNo(workOrderNo);

			hbt.update(storeFyDocumentNo);
			if (storeWorkOrderTlist.size() > 0) {
				if ((infoMap.get("headerStored") + "").equals("yes")) {
					int id = Integer.parseInt("" + infoMap.get("workOrderId"));
					storeWorkOrderM2.setId(id);
				}
				for (int i = 0; i < storeWorkOrderTlist.size(); i++) {
					StoreWorkOrderT storeWorkOrderTObj = new StoreWorkOrderT();
					storeWorkOrderTObj = (StoreWorkOrderT) storeWorkOrderTlist
							.get(i);
					if ((infoMap.get("headerStored") + "").equals("yes")) {
						storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM2);
					} else {
						storeWorkOrderTObj.setWorkOrderM(storeWorkOrderM);
					}
					hbt.save(storeWorkOrderTObj);
				}

			}
			successfullyAdded = true;
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}

		return successfullyAdded;
	}

	public Map getWorkOrderModify(int workOrderId, int pageNo) {

		Map map = new HashMap();
		List<StoreWorkOrderM> gridWorkOrderMList = new ArrayList<StoreWorkOrderM>();
		List<StoreWorkOrderT> gridWorkOrderTList = new ArrayList<StoreWorkOrderT>();
		@SuppressWarnings("unused")
		int id = 0;
		int firstResult = 0;
		int maxResults = 8;

		List<StoreWorkOrderM> searchWorkOrderList = new ArrayList<StoreWorkOrderM>();
		List<StoreWorkOrderM> list = new ArrayList<StoreWorkOrderM>();
		List<StoreFyDocumentNo> storeFyDocumentNoList = new ArrayList<StoreFyDocumentNo>();
		session = (Session) getSession();
		List objectList = new ArrayList();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		session = (Session) getSession();
		Transaction tx = null;
		try {
			// --------------Transaction Started----------
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(StoreWorkOrderT.class).add(
					Restrictions.eq("WorkOrderM.Id", workOrderId));
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			gridWorkOrderTList = c.list();
			gridWorkOrderMList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreWorkOrderM as md where md.Id = '"
							+ workOrderId + "' and md.Status='o'");
			String qry = "select item_id,pvms_no,nomenclature from mas_store_item ";
			objectList = (List) session.createSQLQuery(qry).list();

			// --------------Transaction Ended----------
			tx.commit();

		} catch (Exception e) {
			// --------------In case of Transaction Failure----------
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

		}

		map.put("gridWorkOrderMList", gridWorkOrderMList);
		map.put("gridWorkOrderTList", gridWorkOrderTList);
		map.put("workOrderId", workOrderId);
		map.put("objectList", objectList);

		return map;
	}

	public Map<String, Object> modifyGrn(int grnId, int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreGrnM> gridGrnMList = new ArrayList<StoreGrnM>();
		List<StoreGrnT> gridGrnTList = new ArrayList<StoreGrnT>();
		int firstResult = 0;
		int maxResults = 10;

		if (pageNo != 0) {
			firstResult = firstResult + (pageNo) * 10;
		}

		Session session = (Session) getSession();
		Criteria c = session.createCriteria(StoreGrnT.class).add(
				Restrictions.eq("GrnMaster.Id", grnId));
		c.setFirstResult(firstResult);
		c.setMaxResults(maxResults);
		gridGrnTList = c.list();
		gridGrnMList = session.createCriteria(StoreGrnM.class)
				.add(Restrictions.eq("Id", grnId)).list();

		map.put("gridGrnTList", gridGrnTList);
		map.put("gridGrnMList", gridGrnMList);
		return map;
	}

	public List<StoreGrnM> getCrvNumberList(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		// Map<String, Object>dataMap = new HashMap<String, Object>();
		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		List<StoreGrnM> crvNumberList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreGrnM as md where md.Department.Id="
						+ deptId + " and md.Status='o'");
		return crvNumberList;
	}

	public List<StoreLoaninM> getloanList(Map<String, Object> dataMap) {
		List<StoreLoaninM> loaninList = new ArrayList<StoreLoaninM>();
		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		loaninList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreLoaninM as md where md.Department.Id="
						+ deptId + " and  md.Status = 'o'");
		return loaninList;
	}

	public List<StoreLoaninT> getLoanInListForMoreInfo(int loaninDetailId) {
		Session session = (Session) getSession();
		List<StoreLoaninT> loanInMoreInfoList = session
				.createCriteria(StoreLoaninT.class)
				.add(Restrictions.eq("Id", loaninDetailId)).list();
		return loanInMoreInfoList;
	}

	public List<StoreGrnT> getStoreGrnTListForMoreInfo(int storeGrnTId) {
		Session session = (Session) getSession();
		List<StoreGrnT> storeGrnTMoreInfoList = session
				.createCriteria(StoreGrnT.class)
				.add(Restrictions.eq("Id", storeGrnTId)).list();
		return storeGrnTMoreInfoList;
	}

	// =============================================================================================
	// ======================= end of methods by abha ============
	// ===========================================================================================

	// ===========hitesh methods started =======//
	public Map<String, Object> showAmcMaintenanceJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List departmentList = new ArrayList();

		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment  as md order by md.Id");
		map.put("departmentList", departmentList);
		return map;

	}

	public Map getNomenclature(int departmentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List itemList = new ArrayList();
		List<MasStoreItem> nomencalatureList = new ArrayList<MasStoreItem>();
		itemList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItem  as msi where msi.Department.Id = "
						+ departmentId);
		if (itemList != null && itemList.size() > 0) {
			for (int i = 0; i < itemList.size(); i++) {
				MasStoreItem sibs = (MasStoreItem) itemList.get(i);
				nomencalatureList.add(sibs);
			}
		}
		map.put("nomenclatureList", nomencalatureList);
		return map;
	}

	public Map getPvmsNoAndGetSerialNo(int nomenclatureId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String pvmsNo = "";
		String BatchNo = "";
		String auNo = "";
		String serialNo = "";
		List serialNoList = new ArrayList();
		List serialList = new ArrayList();
		List<MasStoreItem> pvmsNoList = new ArrayList<MasStoreItem>();
		List<MasStoreItemConversion> auList = new ArrayList<MasStoreItemConversion>();
		auList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItemConversion as msic where msic.Id="
						+ nomenclatureId);
		if (auList != null && auList.size() > 0) {
			for (int i = 0; i < auList.size(); i++) {
				MasStoreItemConversion misc = (MasStoreItemConversion) auList
						.get(i);
				auNo = misc.getItemUnitName();
				map.put("auNo", auNo);
			}
		}
		pvmsNoList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreItem as msi where msi.Id="
						+ nomenclatureId);
		if (pvmsNoList != null && pvmsNoList.size() > 0) {
			for (int i = 0; i < pvmsNoList.size(); i++) {
				MasStoreItem mis = (MasStoreItem) pvmsNoList.get(i);
				pvmsNo = mis.getPvmsNo();
				Set<StoreItemBatchStock> storeItemBatchStockSet = mis
						.getStoreItemBatchStocks();
				for (Iterator stoteItemBatchStockSetItr = storeItemBatchStockSet
						.iterator(); stoteItemBatchStockSetItr.hasNext();) {
					StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) stoteItemBatchStockSetItr
							.next();
					serialNoList.add(storeItemBatchStock);
				}
				map.put("pvmsNo", pvmsNo);
				map.put("serialNoList", serialNoList);

			}
			serialList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreItemBatchStock as sibs where sibs.Item.Id="
							+ nomenclatureId);
			if (serialList.size() > 0 && !serialList.isEmpty()) {
				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) serialList
						.get(0);
				serialNo = storeItemBatchStock.getBatchNo();
			}
		}
		map.put("serialNo", serialNo);
		return map;
	}

	public Map getSerialNoDetails(String serialNo, int itemId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int id = 0;
		StoreAmcM storeAmcM = null;
		StoreGrnT storeGrnT = null;
		StoreAmcT storeAmcT = null;
		List<StoreAmcM> serialNoDetailList = new ArrayList<StoreAmcM>();
		List<StoreGrnT> serialNoDetailsList = new ArrayList<StoreGrnT>();
		List<StoreAmcT> amcTDetailsList = new ArrayList<StoreAmcT>();

		serialNoDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreAmcM as sam where sam.SerialNo='"
						+ serialNo + "'  and sam.Item =" + itemId);
		if (serialNoDetailList.size() > 0 && !serialNoDetailList.isEmpty()) {
			storeAmcM = (StoreAmcM) serialNoDetailList.get(0);
			map.put("storeAmcM", storeAmcM);
			id = storeAmcM.getId();
			amcTDetailsList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreAmcT as sat where sat.AmcM="
							+ id);
			if (amcTDetailsList.size() > 0 && !amcTDetailsList.isEmpty()) {
				storeAmcT = (StoreAmcT) amcTDetailsList.get(0);
			}
			map.put("storeAmcT", storeAmcT);
			map.put("amcTDetailsList", amcTDetailsList);
		}

		List entryNo = getAmcMList();
		if (serialNoDetailList.size() == 0 && serialNoDetailList.isEmpty()) {
			serialNoDetailsList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreGrnT as sgt where sgt.BatchNo='"
							+ serialNo + "'  and sgt.Item =" + itemId);
		}

		if (serialNoDetailsList.size() > 0 && !serialNoDetailsList.isEmpty()) {
			storeGrnT = (StoreGrnT) serialNoDetailsList.get(0);
		}
		map.put("StoreGrnT", storeGrnT);
		map.put("entryNoList", entryNo);

		return map;
	}

	public List getSupplierList() {
		List<MasStoreSupplier> suppList = null;
		suppList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreSupplier  as mss order by mss.Id");
		return suppList;
	}

	public boolean addAmcMDetailsandaddAmcTDetails(StoreAmcM storeAmcM,
			List<StoreAmcT> storeList) throws Exception {

		Session sess = (Session) getSession();
		Transaction tx = null;
		boolean record_added = false;
		List<StoreAmcM> amcM = new ArrayList<StoreAmcM>();
		List<StoreAmcT> amcT = new ArrayList<StoreAmcT>();
		try {
			tx = sess.beginTransaction();
			String entryNo = storeAmcM.getEntryNo();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			amcM = hbt
					.find("from jkt.hms.masters.business.StoreAmcM as sam where sam.EntryNo='"
							+ entryNo + "'");

			if (amcM != null && amcM.size() > 0) {
				// Master Already Exists
				storeAmcM = amcM.get(0);
			} else {
				// Master Records Not Created
				hbt.save(storeAmcM);
			}

			// Delete existing records from StoreAmcT for particular EntryNo

			amcT = hbt
					.find("from jkt.hms.masters.business.StoreAmcT as sam where sam.AmcM.EntryNo='"
							+ entryNo + "'");
			for (Iterator iterator = amcT.iterator(); iterator.hasNext();) {
				StoreAmcT storeAmcT = (StoreAmcT) iterator.next();
				hbt.delete(storeAmcT);
			}

			for (Iterator iterator = storeList.iterator(); iterator.hasNext();) {
				StoreAmcT storeAmcT = (StoreAmcT) iterator.next();
				storeAmcT.setAmcM(storeAmcM);
				hbt.save(storeAmcT);
			}
			tx.commit();
			record_added = true;

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				return false;
			}
		}
		if (record_added) {
			return true;
		} else {
			return false;
		}
	}

	public List getAmcMList() {
		StoreAmcM storeAmcM = null;
		String entryNo = "";
		List<StoreAmcM> amcMList = null;
		List<String> entryNoList = new ArrayList<String>();
		amcMList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreAmcM  as sam order by sam.Id");
		if (amcMList != null) {
			if (amcMList.size() > 0 && !amcMList.isEmpty()) {
				for (int i = 0; i < amcMList.size(); i++) {
					storeAmcM = (StoreAmcM) amcMList.get(i);
					entryNo = storeAmcM.getEntryNo();

				}
			}
		}
		String entryno = getMaxNo(entryNo);
		entryNoList.add(entryno);

		return entryNoList;
	}

	public List getRepairNoList() {
		StoreRepairCivilFirm storeRepairCivilFirm = null;
		String repairNo = "";
		List<StoreRepairCivilFirm> storerepairList = null;
		List<String> repairNoList = new ArrayList<String>();
		storerepairList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreRepairCivilFirm  as srcf order by srcf.Id");
		if (storerepairList != null) {
			if (storerepairList.size() > 0 && !storerepairList.isEmpty()) {
				for (int i = 0; i < storerepairList.size(); i++) {
					storeRepairCivilFirm = (StoreRepairCivilFirm) storerepairList
							.get(i);
					repairNo = storeRepairCivilFirm.getRepairNo();
				}
			}
		}
		String repairno = getMaxNo(repairNo);
		repairNoList.add(repairno);
		return repairNoList;
	}

	public List getRepairNo() {
		StoreRepairCivilFirm storeRepairCivilFirm = null;
		String repairNo = "";
		List<StoreRepairCivilFirm> storerepairList = null;
		List<String> repairNoList = new ArrayList<String>();
		storerepairList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreRepairCivilFirm  as srcf order by srcf.Id");
		return storerepairList;
	}

	public List getDocEntryNo() {
		StoreAmcM storeAmcM = null;
		String docentryNo = "";
		List<StoreAmcM> docentryNoList = null;
		docentryNoList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreAmcM  as sam order by sam.Id");
		return docentryNoList;
	}

	public Map addStoreRepairCivilFirm(StoreRepairCivilFirm storeRepairCivilFirm)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		int nomenclatureId = storeRepairCivilFirm.getItem().getId();
		String repariNo = storeRepairCivilFirm.getRepairNo();
		session = (Session) getSession();
		Transaction tx = null;
		List civilFirmList = new ArrayList();
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(storeRepairCivilFirm);
			tx.commit();
			successfullyAdded = true;

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}

		if (successfullyAdded) {
			map = getAmcRepairDetails(nomenclatureId, repariNo);

		}

		return map;
	}

	public Map updateStoreRepairCivilFirm(
			StoreRepairCivilFirm storeRepairCivilFirm) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		int nomenclatureId = storeRepairCivilFirm.getItem().getId();
		String repariNo = storeRepairCivilFirm.getRepairNo();
		session = (Session) getSession();
		Transaction tx = null;
		List civilFirmList = new ArrayList();
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int id = storeRepairCivilFirm.getId();
			StoreRepairCivilFirm civilFirm = (StoreRepairCivilFirm) hbt.load(
					StoreRepairCivilFirm.class, id);
			storeRepairCivilFirm.setId(civilFirm.getId());
			hbt.update(storeRepairCivilFirm);
			tx.commit();
			successfullyAdded = true;
			if (successfullyAdded) {
				map = getAmcRepairDetails(nomenclatureId, repariNo);

			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			// throw e; // or display error message
			e.printStackTrace();
		} finally {
			session.close();
		}
		return map;
	}

	public Map getAmcRepairDetails(int nomenclatureId, String repairNO) {
		Map<String, Object> map = new HashMap<String, Object>();
		List amcRepairDetails = new ArrayList();
		try {
			if (nomenclatureId != 0 && repairNO != "") {
				amcRepairDetails = getHibernateTemplate()
						.find("from jkt.hms.masters.business.StoreRepairCivilFirm as srcf where srcf.RepairNo='"
								+ repairNO
								+ "' and srcf.Item ='"
								+ nomenclatureId + "'");
			}

			if (nomenclatureId != 0 && repairNO == "") {
				amcRepairDetails = getHibernateTemplate()
						.find("from jkt.hms.masters.business.StoreRepairCivilFirm as srcf where srcf.Item = '"
								+ nomenclatureId + "'");
			}

			if (repairNO != "" && nomenclatureId == 0) {
				amcRepairDetails = getHibernateTemplate()
						.find("from jkt.hms.masters.business.StoreRepairCivilFirm as srcf where srcf.RepairNo ='"
								+ repairNO + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("amcRepairDetails", amcRepairDetails);

		return map;

	}

	public Map getAmcSearchResult(Map searchFieldMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreAmcM> amcMaintenanceDetails = new ArrayList<StoreAmcM>();
		List<MasStoreItem> nomenclatureList = new ArrayList<MasStoreItem>();
		List departmentList = new ArrayList();
		String docEntryNo = "";
		int departmentCode = 0;
		int itemId = 0;
		String serialNo = "";
		try {
			if ((!searchFieldMap.get("docentryno").equals(""))) {
				docEntryNo = (String) searchFieldMap.get("docentryno");
			}
			if ((!searchFieldMap.get("departmentId").equals(""))) {
				departmentCode = (Integer) searchFieldMap.get("departmentId");
			}
			if ((!searchFieldMap.get("nomenclature").equals(0))) {
				itemId = (Integer) searchFieldMap.get("nomenclature");
			}
			if ((!searchFieldMap.get("SERIAL_NUMBER").equals(""))) {
				serialNo = (String) searchFieldMap.get("SERIAL_NUMBER");
			}

			if (docEntryNo != "") {
				amcMaintenanceDetails = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreAmcM as sam where sam.EntryNo='"
								+ docEntryNo + "'");
			}

			if (docEntryNo != "" && departmentCode != 0 && itemId != 0
					&& serialNo != "") {
				amcMaintenanceDetails = getHibernateTemplate().find(
						"from jkt.hms.masters.business.StoreAmcM as sam where sam.EntryNo = '"
								+ docEntryNo + "' and sam.Department="
								+ departmentCode + "and sam.Item='" + itemId
								+ "'and sam.SerialNo='" + serialNo + "'");
			}

			departmentList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasDepartment  as md order by md.Id");
			map.put("departmentList", departmentList);

			nomenclatureList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreItem  as msi order by msi.Id");
			map.put("nomenclatureList", nomenclatureList);
		} catch (Exception e) {
		}
		map.put("amcMaintenanceDetails", amcMaintenanceDetails);

		return map;
	}

	public List getStoreAmcT(int id) {

		List<StoreAmcT> storeamcList = new ArrayList<StoreAmcT>();
		storeamcList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreAmcT as sat where sat.AmcM="
						+ id);
		return storeamcList;
	}

	public Map showBoardOfSurvey() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		String BosNo = "";
		StoreBosM storeBosM = null;
		storeBosMList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreBosM as sbm order by sbm.Id");
		if (storeBosMList.size() > 0 && !storeBosMList.isEmpty()) {
			for (int i = 0; i < storeBosMList.size(); i++) {
				storeBosM = storeBosMList.get(i);
				BosNo = storeBosM.getBosNo();
			}
		}
		BosNo = getMaxNo(BosNo);
		// String Bono= BosNo.substring(0, 1);
		map.put("BosNo", BosNo);
		map.put("StoreBosMList", storeBosMList);
		return map;
	}

	public Map createAndImportBosData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreCondemnationT> condemnationList = new ArrayList<StoreCondemnationT>();
		// StoreCondemnationM storeCondemnationM = null;
		StoreCondemnationT storeCondemnationT = null;
		String pvms = null;
		String ser = null;
		String obs = null;
		int us = 0;
		String backloaded = null;
		String rep = null;
		String nomenclature = null;
		String destroyed = null;
		String recser = null;
		String bunser = null;
		String boardreduced = null;
		String remarks = null;
		Date bosdate = null;
		String bosno = null;
		String au = null;
		String itemId = null;
		BigDecimal costprice = null;
		int Srno = 0;
		int qty = 0;
		String crvno = null;
		BigDecimal cost = null;
		String crvnocost = null;
		String serialNo = null;
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		Set<StoreGrnT> storeSet = new HashSet<StoreGrnT>();
		String bosNo = box.get(BOS_ID);
		String bosDate = box.get(BOS_DATE);
		Date bosDate1 = HMSUtil.convertStringTypeDateToDateType(bosDate);
		String username = box.get(CHANGED_BY);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		String lastchangedtime = box.get(CHANGED_TIME);
		String lastchangedDate = box.get(CHANGED_DATE);
		Date lastchgdate = HMSUtil
				.convertStringTypeDateToDateType(lastchangedDate);
		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			condemnationList = hbt
					.find("from jkt.hms.masters.business.StoreCondemnationT as sct where sct.CondemM.Status = 'o'");
			if (condemnationList.size() > 0 && !condemnationList.isEmpty()) {
				for (int i = 0; i < condemnationList.size(); i++) {
					storeCondemnationT = (StoreCondemnationT) condemnationList
							.get(i);

					// int id = storeCondemnationT.getId();
					// storeCondemnationM=(StoreCondemnationM)hbt.load(StoreCondemnationM.class,
					// id);
					List storelist = hbt
							.find("from jkt.hms.masters.business.StoreCondemnationM as scm where scm.Status = 'o' ");
					if (storelist != null && !storelist.isEmpty()) {
						for (int j = 0; j < storelist.size(); j++) {
							StoreCondemnationM storeCondemnationM = (StoreCondemnationM) storelist
									.get(j);
							storeCondemnationM.setStatus("p");
							hbt.update(storeCondemnationM);
						}

					}

				}
				// ====== saving the bos m=======//
				StoreBosM storeBosM = new StoreBosM();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeBosM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeBosM.setHospital(masHospital);
				storeBosM.setBosDate(bosDate1);
				storeBosM.setBosNo(bosNo);
				storeBosM.setLastChgBy(username);
				storeBosM.setLastChgDate(lastchgdate);
				storeBosM.setLastChgTime(lastchangedtime);
				storeBosM.setStatus("o");
				hbt.save(storeBosM);

				for (Iterator iterator = condemnationList.iterator(); iterator
						.hasNext();) {
					StoreCondemnationT storeCondemnationT1 = (StoreCondemnationT) iterator
							.next();

					try {
						if (storeCondemnationT1.getId() != null) {
							Srno = storeCondemnationT1.getId();
						} else {
							Srno = 0;
						}
					} catch (Exception e) {
						Srno = 0;
					}

					try {
						if (storeCondemnationT1.getItem().getPvmsNo() != null) {
							pvms = storeCondemnationT1.getItem().getPvmsNo();
						} else {
							pvms = "";
						}
					} catch (Exception e) {
						pvms = "";
					}

					try {
						if (storeCondemnationT1.getItem().getNomenclature() != null) {
							nomenclature = storeCondemnationT1.getItem()
									.getNomenclature();
						} else {
							nomenclature = "";
						}
					} catch (Exception e) {
						nomenclature = "";
					}

					try {
						if (storeCondemnationT1.getItem().getItemConversion()
								.getItemUnitName() != null) {
							au = storeCondemnationT1.getItem()
									.getItemConversion().getItemUnitName();
						} else {
							au = "";
						}

					} catch (Exception e) {
						au = "";
					}

					try {
						if (storeCondemnationT1.getSerialNo() != null) {
							serialNo = storeCondemnationT1.getSerialNo();
						} else {
							serialNo = "";
						}
					} catch (Exception e) {
						serialNo = "";
					}
					try {
						if (storeCondemnationT1.getQty() != null) {
							qty = storeCondemnationT1.getQty();
						} else {
							qty = 0;
						}
					} catch (Exception e) {
						qty = 0;
					}
					try {
						ser = "";
					} catch (Exception e) {
						ser = "";
					}
					try {
						obs = "";
					} catch (Exception e) {
						obs = "";
					}
					try {
						rep = "";
					} catch (Exception e) {
						rep = "";
					}
					try {
						if (storeCondemnationT1.getQty() != null) {
							us = storeCondemnationT1.getQty();
						} else {
							us = 0;
						}
					} catch (Exception e) {
						us = 0;
					}
					try {
						backloaded = "";
					} catch (Exception e) {
						backloaded = "";
					}
					try {
						destroyed = "";
					}

					catch (Exception e) {
						destroyed = "";
					}
					try {
						recser = "";
					} catch (Exception e) {
						recser = "";
					}
					try {
						boardreduced = "";
					} catch (Exception e) {
						boardreduced = "";
					}
					MasStoreItem item = storeCondemnationT1.getItem();
					int id = item.getId();
					Criteria c = session.createCriteria(StoreGrnT.class).add(
							Restrictions.eq("Item.Id", id));
					List storeGrntList = c.list();

					if (storeGrntList != null && !storeGrntList.isEmpty()) {
						for (int k = 0; k < storeGrntList.size(); k++) {
							StoreGrnT storeGrnT = (StoreGrnT) storeGrntList
									.get(k);

							if (storeGrnT.getFinalCostPrice() != null) {
								cost = storeGrnT.getFinalCostPrice();
							} else {
								BigDecimal costval = new BigDecimal(0);
								cost = costval;
							}
							Date dt = null;
							if (storeGrnT.getGrnMaster().getGrnDate() != null) {
								dt = storeGrnT.getGrnMaster().getGrnDate();
							} else {
								dt = null;
							}
							crvno = storeGrnT.getGrnMaster().getGrnNo();

							try {
								if ((dt != null) && (crvno != null)) {
									crvnocost = crvno.concat(dt.toString()
											+ cost.toString());
								}
							} catch (Exception e) {
								crvnocost = "";
							}
							try {
								costprice = storeGrnT.getFinalCostPrice();
							} catch (Exception e) {
								costprice = new BigDecimal("0");
							}
						}
					} else {
						costprice = new BigDecimal("0");
						crvnocost = "";
					}
					try {
						remarks = "";
					} catch (Exception e) {
						remarks = "";
					}
					try {
						bosdate = null;
					} catch (Exception e) {
						bosdate = null;
					}
					try {
						bunser = "";
					} catch (Exception e) {
						bunser = "";
					}
					hData = new HashMap<String, Object>();
					hData.put("Srno", Srno);
					hData.put("pvms", pvms);
					hData.put("nomenclature", nomenclature);
					hData.put("au", au);
					hData.put("serialNo", serialNo);
					hData.put("qty", qty);
					hData.put("ser", ser);
					hData.put("obs", obs);
					hData.put("rep", rep);
					hData.put("us", us);
					hData.put("backloaded", backloaded);
					hData.put("destroyed", destroyed);
					hData.put("recser", recser);
					hData.put("boardreduced", boardreduced);
					hData.put("crvnocost", crvnocost);
					hData.put("cost", cost);
					hData.put("remarks", remarks);
					hData.put("bosno", bosno);
					hData.put("bosdate", bosdate);
					hData.put("bunser", bunser);
					vResult.add(hData);

					// ====== saving the bos t=======//

					StoreBosT storeBosT = new StoreBosT();
					storeBosT.setBosM(storeBosM);
					// storeBosT.setCostDetails(costprice);
					storeBosT.setCrvnoDate(crvnocost);
					storeBosT.setItem(item);
					storeBosT.setQty(qty);
					storeBosT.setSerialNo(serialNo);
					storeBosT.setSrNo(Srno);
					storeBosT.setConditionUs(String.valueOf(us));
					hbt.save(storeBosT);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pagedArray", pagedArray);
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		String BosNo = "";
		StoreBosM storeBosM = null;
		storeBosMList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreBosM as sbm order by sbm.Id");
		if (storeBosMList.size() > 0 && !storeBosMList.isEmpty()) {
			for (int i = 0; i < storeBosMList.size(); i++) {
				storeBosM = storeBosMList.get(i);
				BosNo = storeBosM.getBosNo();
			}
		}

		// String Bono= BosNo.substring(0, 1);
		map.put("BosNo", BosNo);
		map.put("StoreBosMList", storeBosMList);
		return map;
	}

	public Map updateGridItemsBos(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean updategrid = false;

		Vector srno = box.getVector(SR_NO);
		Vector pvms = box.getVector(PVMS_NO);
		Vector items = box.getVector(NOMENCLATURE);
		Vector au = box.getVector(AU);
		Vector serialNo = box.getVector(SERIAL_NUMBER);
		Vector qty = box.getVector(QTY);
		Vector servicable = box.getVector(SERVICABLE);
		Vector repairable = box.getVector(REPAIRABLE);
		Vector unservicable = box.getVector(UN_SERVICABLE);
		Vector obs = box.getVector(OBS);
		Vector boardservicable = box.getVector(BOARD_SERVICABLE);
		Vector backloaded = box.getVector(BACKLOADED);
		Vector boardunservicable = box.getVector(BOARD_UN_SERVICABLE);
		Vector destyroyed = box.getVector(BOARD_DESTROYED);
		Vector reducedTo = box.getVector(REDUCED_TO);
		Vector crvcost = box.getVector(CRV_COST);
		Vector costprice = box.getVector(COST);
		Vector remarks = box.getVector(REMARKS);
		String bosNo = box.get(BOS_ID);
		String bosDate = box.get(BOS_DATE);
		Date bosDate1 = HMSUtil.convertStringTypeDateToDateType(bosDate);
		String username = box.get(CHANGED_BY);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		int sr_no = 0;
		String lastchangedtime = box.get(CHANGED_TIME);
		String lastchangedDate = box.get(CHANGED_DATE);
		Date lastchgdate = HMSUtil
				.convertStringTypeDateToDateType(lastchangedDate);

		try {
			List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
			List<StoreBosT> storeBosTList = new ArrayList<StoreBosT>();
			StoreBosM storeBosM = new StoreBosM();

			session = (Session) getSession();
			Transaction tx = null;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			storeBosMList = hbt
					.find("from jkt.hms.masters.business.StoreBosM as a where a.BosNo ='"
							+ bosNo + "'");

			if (storeBosMList.size() > 0) {
				storeBosM = (StoreBosM) storeBosMList.get(0);
				hbt.update(storeBosM);
				tx.commit();
			} else {

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeBosM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeBosM.setHospital(masHospital);
				storeBosM.setBosDate(bosDate1);
				storeBosM.setBosNo(bosNo);
				storeBosM.setLastChgBy(username);
				storeBosM.setLastChgDate(lastchgdate);
				storeBosM.setLastChgTime(lastchangedtime);
				storeBosM.setStatus("o");
				hbt.save(storeBosM);
				tx.commit();

			}

			for (int i = 0; i < srno.size(); i++) {
				StoreBosT storeBosT = null;
				String srNo = srno.get(i).toString();
				tx = session.beginTransaction();
				storeBosTList = (List) hbt
						.find("from jkt.hms.masters.business.StoreBosT as a where a.SrNo ='"
								+ srNo + "'");
				if (storeBosTList.size() > 0 && !storeBosTList.isEmpty()) {
					for (Iterator iterator = storeBosTList.iterator(); iterator
							.hasNext();) {
						storeBosT = (StoreBosT) iterator.next();

					}
				}

				String item_id = items.get(i).toString();
				MasStoreItem item = null;
				List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

				itemList = hbt
						.find("from jkt.hms.masters.business.MasStoreItem as a where a.Nomenclature ='"
								+ item_id + "'");
				if (itemList.size() > 0) {
					item = itemList.get(0);
				}
				storeBosT.setBoardBackload(backloaded.get(i).toString());
				storeBosT.setBoardDestroy(destyroyed.get(i).toString());
				storeBosT.setBoardRecSer(boardservicable.get(i).toString());
				storeBosT.setBoardReduced(reducedTo.get(i).toString());
				storeBosT.setBoardUs(boardunservicable.get(i).toString());
				storeBosT.setBosM(storeBosM);
				storeBosT.setConditionObs(obs.get(i).toString());
				storeBosT.setConditionRep(repairable.get(i).toString());
				storeBosT.setConditionSer(servicable.get(i).toString());
				storeBosT.setConditionUs(unservicable.get(i).toString());
				if ((costprice.get(i) != null)
						&& (!costprice.get(i).equals("") && !costprice.get(i)
								.equals("null"))) {
					// storeBosT.setCostDetails(new
					// BigDecimal(costprice.get(i).toString()));
				} else {
					BigDecimal costpricefinal = new BigDecimal(0);
					// storeBosT.setCostDetails(costpricefinal);
				}
				storeBosT.setCrvnoDate(crvcost.get(i).toString());
				storeBosT.setItem(item);
				storeBosT.setQty(new Integer(qty.get(i).toString()));
				storeBosT.setRemarks(remarks.get(i).toString());
				storeBosT.setSerialNo(serialNo.get(i).toString());
				storeBosT.setSrNo(new Integer(srno.get(i).toString()));

				hbt.update(storeBosT);
				tx.commit();

			}

			updategrid = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (updategrid) {
			map = searchBosData(bosNo, box);

		}

		return map;
	}

	public Map searchBosData(String BosNo, Box box) {
		String pvms = null;
		String ser = null;
		String obs = null;
		String us = null;
		String backloaded = null;
		String rep = null;
		String nomenclature = null;
		String destroyed = null;
		String recser = null;
		String bunser = null;
		String boardreduced = null;
		String remarks = null;
		Date bosdate = null;
		String bosno = null;
		String au = null;
		String itemId = null;
		String costprice = null;
		int Srno = 0;
		int qty = 0;
		String crvno = null;
		BigDecimal cost = null;
		String crvnocost = null;
		String serialNo = null;
		String bosStatus = "o";
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		StoreBosT storeBosT = null;
		StoreBosM storeBosM = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List storeBosList = new ArrayList();
		session = (Session) getSession();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		tx = session.beginTransaction();
		storeBosList = hbt
				.find("from jkt.hms.masters.business.StoreBosT as b where b.BosM.BosNo ='"
						+ BosNo + "'");
		if (storeBosList.size() > 0 && !storeBosList.isEmpty()) {
			for (int i = 0; i < storeBosList.size(); i++) {
				storeBosT = (StoreBosT) storeBosList.get(i);
				int id = storeBosT.getBosM().getId();
				storeBosM = (StoreBosM) hbt.get(StoreBosM.class, id);
				bosStatus = storeBosM.getStatus();
			}

			tx.commit();
			for (Iterator iterator = storeBosList.iterator(); iterator
					.hasNext();) {
				StoreBosT storeBosT1 = (StoreBosT) iterator.next();
				try {
					if (storeBosT1.getId() != null) {
						Srno = storeBosT1.getId();
					} else {
						Srno = 0;
					}
				} catch (Exception e) {
					Srno = 0;
				}

				try {
					if (storeBosT1.getItem().getPvmsNo() != null) {
						pvms = storeBosT1.getItem().getPvmsNo();
					} else {
						pvms = "";
					}
				} catch (Exception e) {
					pvms = "";
				}

				try {
					if (storeBosT1.getItem().getNomenclature() != null) {
						nomenclature = storeBosT1.getItem().getNomenclature();
					} else {
						nomenclature = "";
					}
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					if (storeBosT1.getItem().getItemConversion()
							.getItemUnitName() != null) {
						au = storeBosT1.getItem().getItemConversion()
								.getItemUnitName();
					} else {
						au = "";
					}

				} catch (Exception e) {
					au = "";
				}

				try {
					if (storeBosT1.getSerialNo() != null) {
						serialNo = storeBosT1.getSerialNo();
					} else {
						serialNo = "";
					}
				} catch (Exception e) {
					serialNo = "";
				}
				try {
					if (storeBosT1.getQty() != null) {
						qty = storeBosT1.getQty();
					} else {
						qty = 0;
					}
				} catch (Exception e) {
					qty = 0;
				}
				try {
					if (storeBosT1.getConditionSer() != null) {
						ser = storeBosT1.getConditionSer();
					} else {
						ser = "";
					}
				} catch (Exception e) {
					ser = "";
				}
				try {
					if (storeBosT1.getConditionObs() != null) {
						obs = storeBosT1.getConditionObs();
					} else {
						obs = "";
					}
				} catch (Exception e) {
					obs = "";
				}
				try {
					if (storeBosT1.getConditionRep() != null) {
						rep = storeBosT1.getConditionRep();
					} else {
						rep = "";
					}
				} catch (Exception e) {
					rep = "";
				}
				try {
					if (storeBosT1.getConditionUs() != null) {
						us = storeBosT1.getConditionUs();
					} else {
						us = "";
					}
				} catch (Exception e) {
					us = "";
				}
				try {
					if (storeBosT1.getBoardBackload() != null) {
						backloaded = storeBosT1.getBoardBackload();
					} else {
						backloaded = "";
					}
				} catch (Exception e) {
					backloaded = "";
				}
				try {
					if (storeBosT1.getBoardDestroy() != null) {
						destroyed = storeBosT1.getBoardDestroy();
					} else {
						destroyed = "";
					}

				} catch (Exception e) {
					destroyed = "";
				}
				try {
					if (storeBosT1.getBoardRecSer() != null) {
						recser = storeBosT1.getBoardRecSer();
					} else {
						recser = "";
					}
				} catch (Exception e) {
					recser = "";
				}
				try {
					if (storeBosT1.getBoardReduced() != null) {
						boardreduced = storeBosT1.getBoardReduced();
					} else {
						boardreduced = "";
					}
				} catch (Exception e) {
					boardreduced = "";
				}
				try {
					if (storeBosT1.getCrvnoDate() != null) {
						crvnocost = storeBosT1.getCrvnoDate();
					} else {
						crvnocost = "";
					}
				} catch (Exception e) {
					crvnocost = "";
				}
				try {
					if (storeBosT1.getCostDetails() != null) {
						// cost = storeBosT1.getCostDetails();
					} else {
						cost = null;
					}
				} catch (Exception e) {
					cost = null;
				}
				try {
					if (storeBosT1.getRemarks() != null) {
						remarks = storeBosT1.getRemarks();
					} else {
						remarks = "";
					}
				} catch (Exception e) {
					remarks = "";
				}

				try {

					bosno = storeBosT1.getBosM().getBosNo();
				} catch (Exception e) {
					bosno = "";
				}
				try {
					bosdate = storeBosT1.getBosM().getBosDate();
				} catch (Exception e) {
					bosdate = null;
				}
				try {
					if (storeBosT1.getBoardUs() != null) {
						bunser = storeBosT1.getBoardUs();
					} else {
						bunser = "";
					}
				} catch (Exception e) {
					bunser = "";
				}
				hData = new HashMap<String, Object>();
				hData.put("Srno", Srno);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("serialNo", serialNo);
				hData.put("qty", qty);
				hData.put("ser", ser);
				hData.put("obs", obs);
				hData.put("rep", rep);
				hData.put("us", us);
				hData.put("backloaded", backloaded);
				hData.put("destroyed", destroyed);
				hData.put("recser", recser);
				hData.put("boardreduced", boardreduced);
				hData.put("crvnocost", crvnocost);
				hData.put("cost", cost);
				hData.put("remarks", remarks);
				hData.put("bosno", bosno);
				hData.put("bosdate", bosdate);
				hData.put("bunser", bunser);
				vResult.add(hData);
			}
		}
		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		storeBosMList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreBosM as sbm order by sbm.Id");
		map.put("StoreBosMList", storeBosMList);
		map.put("pagedArray", pagedArray);
		map.put("bosno", bosno);
		map.put("bosStatus", bosStatus);
		return map;
	}

	public Map updateSearchGridItemsBos(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean updategrid = false;
		Vector srno = box.getVector(SR_NO);
		Vector pvms = box.getVector(PVMS_NO);
		Vector items = box.getVector(NOMENCLATURE);
		Vector au = box.getVector(AU);
		Vector serialNo = box.getVector(SERIAL_NUMBER);
		Vector qty = box.getVector(QTY);
		Vector servicable = box.getVector(SERVICABLE);
		Vector repairable = box.getVector(REPAIRABLE);
		Vector unservicable = box.getVector(UN_SERVICABLE);
		Vector obs = box.getVector(OBS);
		Vector boardservicable = box.getVector(BOARD_SERVICABLE);
		Vector backloaded = box.getVector(BACKLOADED);
		Vector boardunservicable = box.getVector(BOARD_UN_SERVICABLE);
		Vector destyroyed = box.getVector(BOARD_DESTROYED);
		Vector reducedTo = box.getVector(REDUCED_TO);
		Vector crvcost = box.getVector(CRV_COST);
		Vector costprice = box.getVector(COST);
		Vector remarks = box.getVector(REMARKS);
		String bosNo = box.get(BOS_ID);
		String bosDate = box.get(BOS_DATE);
		Date bosDate1 = HMSUtil.convertStringTypeDateToDateType(bosDate);
		String username = box.get(CHANGED_BY);
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		int sr_no = 0;
		String lastchangedtime = box.get(CHANGED_TIME);
		String lastchangedDate = box.get(CHANGED_DATE);
		Date lastchgdate = HMSUtil
				.convertStringTypeDateToDateType(lastchangedDate);

		try {
			List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
			List<StoreBosT> storeBosTList = new ArrayList<StoreBosT>();
			StoreBosM storeBosM = new StoreBosM();

			session = (Session) getSession();
			Transaction tx = null;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			storeBosMList = hbt
					.find("from jkt.hms.masters.business.StoreBosM as a where a.BosNo ='"
							+ bosNo + "'");

			if (storeBosMList.size() > 0 && !storeBosMList.isEmpty()) {
				storeBosM = (StoreBosM) storeBosMList.get(0);
				hbt.update(storeBosM);
				tx.commit();
			} else {

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeBosM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeBosM.setHospital(masHospital);
				storeBosM.setBosDate(bosDate1);
				storeBosM.setBosNo(bosNo);
				storeBosM.setLastChgBy(username);
				storeBosM.setLastChgDate(lastchgdate);
				storeBosM.setLastChgTime(lastchangedtime);
				storeBosM.setStatus("o");
				hbt.save(storeBosM);
				tx.commit();

			}

			for (int i = 0; i < srno.size(); i++) {
				StoreBosT storeBosT = new StoreBosT();
				tx = session.beginTransaction();
				storeBosTList = hbt
						.find("from jkt.hms.masters.business.StoreBosT as b where b.BosM.BosNo ='"
								+ bosNo + "'");
				if (storeBosTList.size() > 0 && !storeBosTList.isEmpty()) {
					storeBosT = storeBosTList.get(i);
					storeBosT.setBosM(storeBosTList.get(i).getBosM());
					String item_id = items.get(i).toString();
					MasStoreItem item = null;
					List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

					itemList = hbt
							.find("from jkt.hms.masters.business.MasStoreItem as a where a.Nomenclature ='"
									+ item_id + "'");
					if (itemList.size() > 0) {
						item = itemList.get(0);
					}
					storeBosT.setItem(item);
					{
						try {
							sr_no = storeBosTList.get(i).getSrNo().intValue();
							storeBosT.setSrNo(sr_no);
						} catch (Exception e) {
							storeBosT.setSrNo(0);
						}

						try {
							storeBosT.setSerialNo(serialNo.get(i).toString());
						} catch (Exception e) {
							storeBosT.setSerialNo("");
						}
						try {
							storeBosT.setRemarks(remarks.get(i).toString());
						} catch (Exception e) {
							storeBosT.setRemarks("");
						}

						try {
							storeBosT
									.setQty(new Integer(qty.get(i).toString()));
						} catch (Exception e) {
							storeBosT.setQty(0);
						}
						try {
							storeBosT.setCrvnoDate(crvcost.get(i).toString());
						} catch (Exception e) {
							storeBosT.setCrvnoDate("");
						}
						try {
							BigDecimal costprice1 = new BigDecimal(costprice
									.get(i).toString());
							// storeBosT.setCostDetails(costprice1);
						} catch (Exception e) {
							storeBosT.setCostDetails(null);
						}

						try {
							storeBosT.setConditionUs(unservicable.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setConditionUs("");
						}
						try {
							storeBosT.setCrvnoDate(crvcost.get(i).toString());
						} catch (Exception e) {
							storeBosT.setCrvnoDate("");
						}
						try {
							storeBosT.setConditionSer(servicable.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setConditionSer("");
						}
						try {
							storeBosT.setConditionRep(repairable.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setConditionRep("");
						}
						try {
							storeBosT.setConditionObs(obs.get(i).toString());
						} catch (Exception e) {
							storeBosT.setConditionObs("");
						}
						try {
							storeBosT.setBoardUs(boardunservicable.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardUs("");
						}
						try {
							storeBosT.setBoardReduced(reducedTo.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardReduced("");
						}
						try {
							storeBosT.setBoardRecSer(boardservicable.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardRecSer("");
						}
						try {
							storeBosT.setBoardDestroy(destyroyed.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardDestroy("");
						}
						try {
							storeBosT.setBoardBackload(backloaded.get(i)
									.toString());
						} catch (Exception e) {
							storeBosT.setBoardBackload("");
						}
						hbt.update(storeBosT);
						tx.commit();
					}
				} else {
					{

						tx = session.beginTransaction();
						String item_id = items.get(i).toString();
						MasStoreItem item = null;
						List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

						itemList = hbt
								.find("from jkt.hms.masters.business.MasStoreItem as a where a.Nomenclature ='"
										+ item_id + "'");
						if (itemList.size() > 0) {
							item = itemList.get(0);
						}
						storeBosT
								.setBoardBackload(backloaded.get(i).toString());
						storeBosT.setBoardDestroy(destyroyed.get(i).toString());
						storeBosT.setBoardRecSer(boardservicable.get(i)
								.toString());
						storeBosT.setBoardReduced(reducedTo.get(i).toString());
						storeBosT.setBoardUs(boardunservicable.get(i)
								.toString());
						storeBosT.setBosM(storeBosM);
						storeBosT.setConditionObs(obs.get(i).toString());
						storeBosT.setConditionRep(repairable.get(i).toString());
						storeBosT.setConditionSer(servicable.get(i).toString());
						storeBosT
								.setConditionUs(unservicable.get(i).toString());
						if (costprice.get(i).toString() != null) {
							BigDecimal costBigDecimal = new BigDecimal(
									costprice.get(i).toString());
							// storeBosT.setCostDetails(costBigDecimal);
						}
						storeBosT.setCrvnoDate(crvcost.get(i).toString());
						storeBosT.setItem(item);
						storeBosT.setQty(new Integer(qty.get(i).toString()));
						storeBosT.setRemarks(remarks.get(i).toString());
						storeBosT.setSerialNo(serialNo.get(i).toString());
						storeBosT.setSrNo(new Integer(srno.get(i).toString()));

						hbt.save(storeBosT);
						tx.commit();

					}
				}
			}
			updategrid = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = searchBosData(bosNo, box);
		return map;
	}

	public Map getBosData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<StoreBosT> storeBosList = new ArrayList<StoreBosT>();
		// StoreCondemnationM storeCondemnationM = null;
		StoreCondemnationT storeCondemnationT = null;
		String pvms = null;
		String nomenclature = null;
		String au = null;
		String itemId = null;
		String ser = null;
		String obs = null;
		String unser = null;
		String backloaded = null;
		String rep = null;
		String destroyed = null;
		String recser = null;
		String bunser = null;
		String boardreduced = null;
		String remarks = null;
		Date bosdate = null;
		String bosno = null;
		int Srno = 0;
		int qty = 0;
		String crvno = null;
		BigDecimal cost = null;
		BigDecimal costprice = null;
		String crvnocost = null;
		String serialNo = null;
		String bosNo = box.get(BOS_ID);
		int departmentId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		Set<StoreGrnT> storeSet = new HashSet<StoreGrnT>();
		session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			storeBosList = hbt
					.find("from jkt.hms.masters.business.StoreBosT as sbt where sbt.BosM.BosNo ='"
							+ bosNo
							+ "' and sbt.BosM.Department.Id='"
							+ departmentId
							+ "'and sbt.BosM.Hospital.Id='"
							+ hospitalId + "'");

			for (Iterator iterator = storeBosList.iterator(); iterator
					.hasNext();) {
				StoreBosT storeBosT = (StoreBosT) iterator.next();

				try {
					if (storeBosT.getId() != null) {
						Srno = storeBosT.getId();
					} else {
						Srno = 0;
					}
				} catch (Exception e) {
					Srno = 0;
				}

				try {
					if (storeBosT.getItem().getPvmsNo() != null) {
						pvms = storeBosT.getItem().getPvmsNo();
					} else {
						pvms = "";
					}
				} catch (Exception e) {
					pvms = "";
				}

				try {
					if (storeBosT.getItem().getNomenclature() != null) {
						nomenclature = storeBosT.getItem().getNomenclature();
					} else {
						nomenclature = "";
					}
				} catch (Exception e) {
					nomenclature = "";
				}

				try {
					if (storeBosT.getItem().getItemConversion()
							.getItemUnitName() != null) {
						au = storeBosT.getItem().getItemConversion()
								.getItemUnitName();
					} else {
						au = "";
					}

				} catch (Exception e) {
					au = "";
				}

				try {
					if (storeBosT.getSerialNo() != null) {
						serialNo = storeBosT.getSerialNo();
					} else {
						serialNo = "";
					}
				} catch (Exception e) {
					serialNo = "";
				}
				try {
					if (storeBosT.getQty() != null) {
						qty = storeBosT.getQty();
					} else {
						qty = 0;
					}
				} catch (Exception e) {
					qty = 0;
				}
				try {
					if (storeBosT.getConditionSer() != null) {
						ser = storeBosT.getConditionSer();
					} else {
						ser = "";
					}
				} catch (Exception e) {
					ser = "";
				}
				try {
					if (storeBosT.getConditionObs() != null) {
						obs = storeBosT.getConditionObs();
					} else {
						obs = "";
					}
				} catch (Exception e) {
					obs = "";
				}
				try {
					if (storeBosT.getConditionRep() != null) {
						rep = storeBosT.getConditionRep();
					} else {
						rep = "";
					}
				} catch (Exception e) {
					rep = "";
				}
				try {
					if (storeBosT.getConditionUs() != null) {
						unser = storeBosT.getConditionUs();
					} else {
						unser = "";
					}
				} catch (Exception e) {
					unser = "";
				}
				try {
					if (storeBosT.getBoardBackload() != null) {
						backloaded = storeBosT.getBoardBackload();
					} else {
						backloaded = "";
					}
				} catch (Exception e) {
					backloaded = "";
				}
				try {
					if (storeBosT.getBoardDestroy() != null) {
						destroyed = storeBosT.getBoardDestroy();
					} else {
						destroyed = "";
					}

				} catch (Exception e) {
					destroyed = "";
				}
				try {
					if (storeBosT.getBoardRecSer() != null) {
						recser = storeBosT.getBoardRecSer();
					} else {
						recser = "";
					}
				} catch (Exception e) {
					recser = "";
				}
				try {
					if (storeBosT.getBoardReduced() != null) {
						boardreduced = storeBosT.getBoardReduced();
					} else {
						boardreduced = "";
					}
				} catch (Exception e) {
					boardreduced = "";
				}
				try {
					if (storeBosT.getCrvnoDate() != null) {
						crvnocost = storeBosT.getCrvnoDate();
					} else {
						crvnocost = "";
					}
				} catch (Exception e) {
					crvnocost = "";
				}
				try {
					if (storeBosT.getCostDetails() != null) {
						// cost = storeBosT.getCostDetails();
					} else {
						cost = null;
					}
				} catch (Exception e) {
					cost = null;
				}
				try {
					if (storeBosT.getRemarks() != null) {
						remarks = storeBosT.getRemarks();
					} else {
						remarks = "";
					}
				} catch (Exception e) {
					remarks = "";
				}

				try {

					bosno = storeBosT.getBosM().getBosNo();
				} catch (Exception e) {
					bosno = "";
				}
				try {
					bosdate = storeBosT.getBosM().getBosDate();
				} catch (Exception e) {
					bosdate = null;
				}
				try {
					if (storeBosT.getBoardUs() != null) {
						bunser = storeBosT.getBoardUs();
					} else {
						bunser = "";
					}
				} catch (Exception e) {
					bunser = "";
				}

				hData = new HashMap<String, Object>();
				hData.put("Srno", Srno);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("au", au);
				hData.put("serialNo", serialNo);
				hData.put("qty", qty);
				hData.put("ser", ser);
				hData.put("obs", obs);
				hData.put("rep", rep);
				hData.put("unser", unser);
				hData.put("backloaded", backloaded);
				hData.put("destroyed", destroyed);
				hData.put("recser", recser);
				hData.put("boardreduced", boardreduced);
				hData.put("crvnocost", crvnocost);
				hData.put("cost", cost);
				hData.put("remarks", remarks);
				hData.put("bosno", bosno);
				hData.put("bosdate", bosdate);
				hData.put("bunser", bunser);
				vResult.add(hData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("pagedArray", pagedArray);
		List<StoreBosM> storeBosMList = new ArrayList<StoreBosM>();
		String BosNo = "";
		StoreBosM storeBosM = null;
		storeBosMList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreBosM as sbm order by sbm.Id");
		if (storeBosMList.size() > 0 && !storeBosMList.isEmpty()) {
			for (int i = 0; i < storeBosMList.size(); i++) {
				storeBosM = storeBosMList.get(i);
				BosNo = storeBosM.getBosNo();
			}
		}

		map.put("BosNo", BosNo);
		map.put("StoreBosMList", storeBosMList);
		return map;

	}

	// ==========hitesh methods end=====//

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek ------------------------------------------
	// ****************************************************************************************************************

	// ============================Start of ME Scale Equipment
	// Details==============================

	public Map getMeScaleDescription(int meScaleNumber, Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreMeScale masStoreMeScale = null;
		StoreMeScaleDetails meScaleDetails = null;
		MasStoreItem masStoreItem = null;
		String meScaleDescription = "";
		Session session = (Session) getSession();
		String pvms = null;
		String oldpvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String section = "";
		int id = 0;
		int itemConversionId = 0;
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------
		int meScaleMasterId = 0;
		if (box.get(ME_SCALE_NUMBER) != null) {
			meScaleMasterId = Integer.parseInt("" + box.get(ME_SCALE_NUMBER));
		}
		List<MasStoreMeScale> tempList = new ArrayList<MasStoreMeScale>();
		String meScaleDesc = "";
		tempList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Id='"
						+ meScaleMasterId + "' ");
		for (MasStoreMeScale masStoreMeScale2 : tempList) {
			meScaleDesc = "" + masStoreMeScale2.getMeScaleDescription();
		}
		List<StoreMeScaleDetails> storeMeScaleDetailsList = new ArrayList<StoreMeScaleDetails>();
		storeMeScaleDetailsList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreMeScaleDetails as masms where masms.MeScale.id='"
						+ meScaleMasterId
						+ "' and masms.Department.Id='"
						+ deptId
						+ "'  and masms.Hospital.Id='"
						+ hospitalId
						+ "'");
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		searchMeScaleList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Status='y'");
		if (storeMeScaleDetailsList.size() > 0) {

		} else {

		}
		map.put("storeMeScaleDetailsList", storeMeScaleDetailsList);
		for (Iterator iterator = storeMeScaleDetailsList.iterator(); iterator
				.hasNext();) {

			StoreMeScaleDetails storeMeScaleDetails = (StoreMeScaleDetails) iterator
					.next();

			try {
				id = Integer.parseInt("" + storeMeScaleDetails.getId());
			} catch (Exception e) {
				id = 0;
			}
			try {
				pvms = "" + storeMeScaleDetails.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}
			try {
				oldpvms = storeMeScaleDetails.getItem().getOldNivNo();
			} catch (Exception e) {
				oldpvms = "";
			}
			try {
				nomenclature = storeMeScaleDetails.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}
			try {
				au = storeMeScaleDetails.getItem().getItemConversion()
						.getItemUnitName();
			} catch (Exception e) {
				au = "";
			}
			try {
				section = storeMeScaleDetails.getItem().getSection()
						.getSectionName();
			} catch (Exception e) {
				section = "";
			}
			try {
				qty = new BigDecimal("" + storeMeScaleDetails.getQty());
			} catch (Exception e) {
				qty = new BigDecimal(0);
			}
			hData = new HashMap<String, Object>();
			hData.put("pvms", pvms);
			hData.put("nomenclature", nomenclature);
			hData.put("oldpvms", oldpvms);
			hData.put("section", section);
			hData.put("au", au);
			hData.put("qty", qty);
			hData.put("id", id);
			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("pagedArray", pagedArray);
		map.put("searchMeScaleList", searchMeScaleList);
		map.put("meScaleDesc", meScaleDesc);
		return map;
	}

	public Map<String, Object> getMeScaleData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreMeScale masStoreMeScale = null;
		StoreMeScaleDetails meScaleDetails = null;
		MasStoreItem masStoreItem = null;
		String meScaleDescription = "";
		Session session = (Session) getSession();
		String pvms = null;
		String oldpvms = null;
		String nomenclature = null;
		String au = null;
		BigDecimal qty = null;
		String section = "";
		int id = 0;
		int itemConversionId = 0;
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------
		int meScaleMasterId = 0;
		if (box.get(ME_SCALE_NUMBER) != null) {
			meScaleMasterId = Integer.parseInt("" + box.get(ME_SCALE_NUMBER));
		}
		List<MasStoreMeScale> tempList = new ArrayList<MasStoreMeScale>();
		String meScaleDesc = "";
		tempList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Id='"
						+ meScaleMasterId + "' ");
		for (MasStoreMeScale masStoreMeScale2 : tempList) {
			meScaleDesc = "" + masStoreMeScale2.getMeScaleDescription();
		}
		List<StoreMeScaleDetails> storeMeScaleDetailsList = new ArrayList<StoreMeScaleDetails>();
		storeMeScaleDetailsList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.StoreMeScaleDetails as masms where masms.MeScale.id='"
						+ meScaleMasterId
						+ "' and masms.Department.Id='"
						+ deptId
						+ "'  and masms.Hospital.Id='"
						+ hospitalId
						+ "'");
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		searchMeScaleList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Status='y'");
		if (storeMeScaleDetailsList.size() > 0) {

		} else {
		}
		map.put("storeMeScaleDetailsList", storeMeScaleDetailsList);
		for (Iterator iterator = storeMeScaleDetailsList.iterator(); iterator
				.hasNext();) {

			StoreMeScaleDetails storeMeScaleDetails = (StoreMeScaleDetails) iterator
					.next();

			try {
				id = Integer.parseInt("" + storeMeScaleDetails.getId());
			} catch (Exception e) {
				id = 0;
			}
			try {
				pvms = "" + storeMeScaleDetails.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}
			try {
				oldpvms = storeMeScaleDetails.getItem().getOldNivNo();
			} catch (Exception e) {
				oldpvms = "";
			}
			try {
				nomenclature = storeMeScaleDetails.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}
			try {
				au = storeMeScaleDetails.getItem().getItemConversion()
						.getItemUnitName();
			} catch (Exception e) {
				au = "";
			}
			try {
				section = storeMeScaleDetails.getItem().getSection()
						.getSectionName();
			} catch (Exception e) {
				section = "";
			}
			try {
				qty = new BigDecimal("" + storeMeScaleDetails.getQty());
			} catch (Exception e) {
				qty = new BigDecimal(0);
			}
			hData = new HashMap<String, Object>();
			hData.put("pvms", pvms);
			hData.put("nomenclature", nomenclature);
			hData.put("oldpvms", oldpvms);
			hData.put("section", section);
			hData.put("au", au);
			hData.put("qty", qty);
			hData.put("id", id);
			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("pagedArray", pagedArray);
		map.put("searchMeScaleList", searchMeScaleList);
		map.put("meScaleDesc", meScaleDesc);
		return map;
	}

	public Map<String, Object> updateGridItemsInViewMeScale(Box box) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreMeScaleDetails> storeMeScaleDetailsList = new ArrayList<StoreMeScaleDetails>();
		List<MasStoreMeScale> meScaleDescriptionList = new ArrayList<MasStoreMeScale>();
		StoreMeScaleDetails storeMeScaleDetails = new StoreMeScaleDetails();
		;
		Session session = (Session) getSession();
		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------

		Vector qty = box.getVector("qty");
		Vector id = box.getVector("id");
		int meScaleNumber = Integer.parseInt(box.get(ME_SCALE_NUMBER)
				.toString());
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String obj = null;
			for (int i = 0; i < id.size(); i++) {
				int tempId = Integer.parseInt(id.get(i).toString());
				StoreMeScaleDetails tObj = (StoreMeScaleDetails) hbt.load(
						StoreMeScaleDetails.class, tempId);
				BigDecimal val = new BigDecimal(Integer.parseInt(qty.get(i)
						.toString()));
				tObj.setQty(val);
				hbt.update(tObj);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = getMeScaleDescription(meScaleNumber, box);
		return map;
	}

	public Map<String, Object> searchItemsForMEScale(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

		String pvms = null;
		String nomenclature = null;
		String strength = null;
		String au = null;
		Integer qtymmf = null;
		// BigDecimal qty = null;
		int item_id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector meItems = new Vector();
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<StoreMeScaleDetails> storeMeScaleList = new ArrayList<StoreMeScaleDetails>();
		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------
		int meScaleMasterId = 0;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			meScaleMasterId = Integer.parseInt("" + box.get("meScaleMasterId"));
			if (box.getInt("meScaleMasterId") != 0) {
				storeMeScaleList = hbt
						.find("from jkt.hms.masters.business.StoreMeScaleDetails as smsd where smsd.MeScale.Id='"
								+ meScaleMasterId
								+ "' and smsd.Department.Id='"
								+ deptId
								+ "' and smsd.Hospital.Id='" + hospitalId + "'");
			}

			for (Iterator iterator = storeMeScaleList.iterator(); iterator
					.hasNext();) {
				StoreMeScaleDetails details = (StoreMeScaleDetails) iterator
						.next();
				meItems.add(details.getItem().getId());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		try {
			List objectList = new ArrayList();
			String str = box.getString("search_text") + "%";
			String qry1 = "SELECT  mesc.item_id FROM store_me_scale_details mesc where mesc.me_scale_id='"
					+ meScaleMasterId
					+ "' and mesc.department_id='"
					+ deptId
					+ "' ";
			objectList = (List) session.createSQLQuery(qry1).list();
			if (objectList.size() != 0) {
				Criteria c = session
						.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.not(Restrictions.in("Id", objectList)));

				itemList = c.list();
			} else {
				Criteria c = session.createCriteria(MasStoreItem.class)
						.add(Restrictions.like("Nomenclature", str))
						.add(Restrictions.eq("Department.Id", deptId));

				itemList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			MasStoreItem masStoreItem = (MasStoreItem) iterator.next();

			try {
				pvms = masStoreItem.getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = masStoreItem.getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				strength = masStoreItem.getStrength();
			} catch (Exception e) {
				strength = "";
			}

			try {
				au = masStoreItem.getItemConversion().getItemUnitName();
			} catch (Exception e) {
				au = "";
			}

			try {
				item_id = masStoreItem.getId();
			} catch (Exception e) {
				item_id = 0;
			}

			if (!meItems.contains(item_id)) {
				hData = new HashMap<String, Object>();
				hData.put("itemId", item_id);
				hData.put("pvms", pvms);
				hData.put("nomenclature", nomenclature);
				hData.put("strength", strength);
				hData.put("qtymmf", 0);
				hData.put("au", au);

				vResult.add(hData);
			}
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("pagedArray", pagedArray);

		return map;
	}

	public Map<String, Object> addItemToMeScale(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreMeScaleDetails> storeMeScaleDetailsList = new ArrayList<StoreMeScaleDetails>();
		Vector items = box.getVector("itemId");
		Vector items_to_be_added = box.getVector(ITEMS_TO_BE_ADDED);
		int meScaleMasterId = Integer.parseInt(""
				+ box.getInt("meScaleMasterId"));
		// ---------Session Information------------------
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (box.get("deptId") != null) {
			deptId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + box.get("hospitalId"));
		}
		// ---------------------------------------------------
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date cuurentDate = null;
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = "";

		try {
			date4MySQL = formatterOut.format(formatterIn.parse("" + date));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		cuurentDate = java.sql.Date.valueOf(date4MySQL);
		MasStoreItem masStoreItem = null;

		int sr_no = 0;

		try {

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (box.getInt("meScaleMasterId") != 0) {

				storeMeScaleDetailsList = hbt
						.find("from jkt.hms.masters.business.StoreMeScaleDetails as smsd where smsd.MeScale.Id='"
								+ meScaleMasterId
								+ "' and smsd.Department.Id='"
								+ deptId
								+ "' and smsd.Hospital.Id='" + hospitalId + "'");

				for (int i = 0; i < items_to_be_added.size(); i++) {
					StoreMeScaleDetails meScaleDetails = new StoreMeScaleDetails();

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					meScaleDetails.setDepartment(masDepartment);

					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					meScaleDetails.setHospital(masHospital);

					MasStoreItem item = new MasStoreItem();
					item.setId(Integer.parseInt("" + items_to_be_added.get(i)));
					meScaleDetails.setItem(item);

					MasStoreMeScale meScale = new MasStoreMeScale();
					meScale.setId(meScaleMasterId);
					meScaleDetails.setMeScale(meScale);

					meScaleDetails.setLastChgBy(userName);
					meScaleDetails.setLastChgDate(cuurentDate);
					meScaleDetails.setLastChgTime(time);
					hbt.save(meScaleDetails);
					hbt.refresh(meScaleDetails);
				}

			}
			box.put("deptId", deptId);
			box.put("hospitalId", hospitalId);
			box.put("meScaleMasterId", meScaleMasterId);

			map = searchItemsForMEScale(box);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;

	}

	public Map<String, Object> deleteMeScaleItems(Box box) {

		Session session = (Session) getSession();
		List<StoreMmfDepartmentT> storeMmfDepartmentTList = new ArrayList<StoreMmfDepartmentT>();
		StoreMmfDepartmentT storeMmfDepartmentT = new StoreMmfDepartmentT();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HibernateTemplate hbt = getHibernateTemplate();

			Vector items = box.getVector("id");
			Vector delete = box.getVector(ITEMS_TO_BE_DELETED);

			String obj = null;
			for (int i = 0; i < delete.size(); i++) {
				int itemId = Integer.parseInt(delete.get(i).toString());
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				String hql = "delete from jkt.hms.masters.business.StoreMeScaleDetails as a where a.Id like :itemId";
				Query query = session.createQuery(hql).setParameter("itemId",
						itemId);
				int row = query.executeUpdate();
			}
			map.put("total_records", items.size());
			map.put("deleted_records", delete.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (Integer.parseInt(map.get("total_records").toString()) == Integer
				.parseInt(map.get("deleted_records").toString())) {
			if (box.getInt("currPage") > 1) {
				box.put("currPage", box.getInt("currPage") - 1);
			}
		}
		int meScaleMasterId = 0;
		map = getMeScaleDescription(meScaleMasterId, box);
		return map;

	}

	public Map<String, Object> viewMeScaleJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreMeScale masStoreMeScale = null;
		StoreMeScaleDetails storeMeScaleDetails = null;
		String meScaleDescription = "";
		Session session = (Session) getSession();
		List<MasStoreMeScale> searchMeScaleList = new ArrayList<MasStoreMeScale>();
		searchMeScaleList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasStoreMeScale as msms where msms.Status='y'");
		List<StoreMeScaleDetails> viewMeScaleList = new ArrayList<StoreMeScaleDetails>();
		viewMeScaleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.StoreMeScaleDetails ");

		map.put("searchMeScaleList", searchMeScaleList);
		map.put("viewMeScaleList", viewMeScaleList);
		return map;

	}

	// ============================End of ME Scale Equipment
	// Details==============================
	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// ============ reports by abha

	public Map<String, Object> showWorkRegisterReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreWorkOrderT> searchMasStoreItemList = new ArrayList<StoreWorkOrderT>();
		session = (Session) getSession();
		String pvmsNo = "";
		pvmsNo = (String) map.get("pvmsNo");

		try {
			searchMasStoreItemList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.StoreWorkOrderT ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchMasStoreItemList", searchMasStoreItemList);
		return map;
	}

}
