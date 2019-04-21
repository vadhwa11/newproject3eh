package jkt.hms.stores.dataservice;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StoreAdjustmentM;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreRefrigeratorAllocation;
import jkt.hms.masters.business.StoreTemperatureMonitoringM;
import jkt.hms.masters.business.StoreTemperatureMonitoringT;
import jkt.hms.masters.business.StoreTemperatureValidation;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




public class ColdChainDataServiceImpl extends HibernateDaoSupport implements ColdChainDataService {

	@Override
	public Map<String, Object> showColdChainManagementJsp(Box box,Map<String, Object> dataMap) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> showTemperatureTrackerJsp(Box box,Map<String, Object> dataMap) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPendingListForRefrigeratorAllocation(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> pendingListForRefrigeratorAllocationList = new ArrayList<Object[]>();
		List<Object[]> grnMList = new ArrayList<Object[]>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		Session session = (Session)getSession();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		grnMList =  session.createCriteria(StoreGrnT.class).createAlias("GrnMaster", "header")
							.createAlias("Item", "item").add(Restrictions.isNotNull("item.TempratureMin")).add(Restrictions.isNotNull("item.TempratureMax"))
							.setProjection(Projections.projectionList().add(Projections.groupProperty("header.GrnNo")).add((Projections.groupProperty("header.InvoiceNo"))))
							.createAlias("header.Hospital", "hospital").add(Restrictions.eq("hospital.Id", box.getInt("hospitalId"))).list();
		
		pendingListForRefrigeratorAllocationList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item")
										.add(Restrictions.eq("item.Status", "y").ignoreCase()).createAlias("item.ItemConversion", "unit")
										.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))//.add(Restrictions.eq("item.Temprature", "y"))
										//.add(Restrictions.isNotNull("item.TempratureMin")).add(Restrictions.isNotNull("item.TempratureMax"))
										.add(Restrictions.isNull("RefrigeratorStatus"))
										.add(Restrictions.isNotNull("item.TempratureMin"))
									.add(Restrictions.isNotNull("item.TempratureMax"))
										//.add(Restrictions.and(Restrictions.isNotNull("item.TempratureMin"), Restrictions.gt("item.TempratureMin", new BigDecimal(0))))
										//.add(Restrictions.and(Restrictions.isNotNull("item.TempratureMax"), Restrictions.gt("item.TempratureMax", new BigDecimal(0))))
										.setProjection(Projections.projectionList().add(Projections.groupProperty("item.Id"))
												.add(Projections.groupProperty("item.Nomenclature")).add(Projections.groupProperty("item.PvmsNo"))
												.add(Projections.groupProperty("item.TempratureMin")).add(Projections.groupProperty("item.TempratureMax"))
												.add(Projections.groupProperty("unit.ItemUnitName"))).list();
		
	/*pendingListForRefrigeratorAllocationList = session.createCriteria(StoreGrnT.class).createAlias("GrnMaster", "header").createAlias("Item", "item")
				.createAlias("header.Hospital", "hospital").add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.isNotNull("item.TempratureMin")).add(Restrictions.isNotNull("item.TempratureMax")).add(Restrictions.isNull("RefrigeratorStatus"))
				.add(Restrictions.eq("item.Temprature", "y")).list();*/
		
		map.put("pendingListForRefrigeratorAllocationList", pendingListForRefrigeratorAllocationList);
		map.put("supplierList", supplierList);
		map.put("grnMList", grnMList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchForRefrigeratorAllocation(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> pendingListForRefrigeratorAllocationList = new ArrayList<Object[]>();
		List<Object[]> grnMList = new ArrayList<Object[]>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		Criteria criteria = null;
		Session session = (Session)getSession();
		criteria = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").createAlias("item.ItemConversion", "unit")
				.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("item.Status", "y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))//.add(Restrictions.eq("item.Temprature", "y"))
				.add(Restrictions.isNotNull("item.TempratureMin")).add(Restrictions.isNotNull("item.TempratureMax"))
				.add(Restrictions.isNull("RefrigeratorStatus"))
				//.add(Restrictions.and(Restrictions.isNotNull("item.TempratureMin"), Restrictions.gt("item.TempratureMin", new BigDecimal(0))))
				//.add(Restrictions.and(Restrictions.isNotNull("item.TempratureMax"), Restrictions.gt("item.TempratureMax", new BigDecimal(0))))
				.setProjection(Projections.projectionList().add(Projections.groupProperty("item.Id"))
						.add(Projections.groupProperty("item.Nomenclature")).add(Projections.groupProperty("item.PvmsNo"))
						.add(Projections.groupProperty("item.TempratureMin")).add(Projections.groupProperty("item.TempratureMax"))
						.add(Projections.groupProperty("unit.ItemUnitName")));
		if(!box.getString("fromDate").equals("") && !box.getString("toDate").equals("")){
			criteria = criteria.add(Restrictions.between("OpeningBalanceDate", HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")), HMSUtil.convertStringTypeDateToDateType(box.getString("toDate"))));
		}
		if(!box.getString("grnNo").equals("0")){
			criteria = criteria.createAlias("StoreGrnTs", "grn").createAlias("grn.GrnMaster", "header").add(Restrictions.eq("header.GrnNo",box.getString("grnNo")));
		}

		/*criteria = session.createCriteria(StoreGrnT.class).createAlias("GrnMaster", "header").createAlias("Item", "item")
				.add(Restrictions.eq("item.Temprature", "y"));
		
		if(box.getString("grnNo") != null){
			criteria = criteria.add(Restrictions.eq("header.GrnNo",box.getString("grnNo")));
		}
		else if(!box.getString("fromDate").equals("") && !box.getString("toDate").equals("")){
			criteria = criteria.add(Restrictions.between("header.GrnDate", HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")), HMSUtil.convertStringTypeDateToDateType(box.getString("toDate"))));
		}
		else if(!box.getString("grnDate").equals("")){
			criteria = criteria.add(Restrictions.eq("header.GrnDate",HMSUtil.convertStringTypeDateToDateType(box.getString("grnDate"))));
		}
		else if(box.getString("deliveryChallanNo") != null){
			criteria = criteria.add(Restrictions.eq("header.ChallanNo",box.getString("deliveryChallanNo")));
		}
		else if(box.getString("supplierId") != null){
			criteria = criteria.createAlias("header.Supplier", "supplier").add(Restrictions.eq("supplier.Id",box.getInt("supplierId")));
		}
		else if(box.getString("invoiceNo") != null){
			criteria = criteria.add(Restrictions.eq("header.InvoiceNo",box.getString("invoiceNo")));
		}*/
		pendingListForRefrigeratorAllocationList = criteria.list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		grnMList =  session.createCriteria(StoreGrnT.class).createAlias("GrnMaster", "header").createAlias("Item", "item")
				.add(Restrictions.isNotNull("item.TempratureMin")).add(Restrictions.isNotNull("item.TempratureMax"))
							.setProjection(Projections.projectionList().add(Projections.groupProperty("header.GrnNo")).add((Projections.groupProperty("header.InvoiceNo")))).list();
	
		map.put("pendingListForRefrigeratorAllocationList", pendingListForRefrigeratorAllocationList);
		map.put("supplierList", supplierList);
		map.put("grnMList", grnMList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showRefrigeratorColdRoomAllocationJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		double min=box.getDouble("min");
		double max=box.getDouble("max");
		
		
		BigDecimal decmin = BigDecimal.valueOf(min);
		
		BigDecimal decmax = BigDecimal.valueOf(max);
		
		
		
		List<Object[]> refrigeratorAllocationList = new ArrayList<Object[]>();
		/*List<HesEquipmentMaster> equipmentMasterList = new ArrayList<HesEquipmentMaster>();*/
		List<Object[]>refrigeratorList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		
		/*refrigeratorAllocationList = session.createCriteria(StoreGrnT.class).createAlias("GrnMaster", "header").
				createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")))
											.add(Restrictions.isNotNull("item.TempratureMin")).add(Restrictions.isNotNull("item.TempratureMax")).list();*/
		refrigeratorAllocationList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").createAlias("item.ItemConversion", "unit")
									.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("item.Id", box.getInt("itemId")))
									.add(Restrictions.eq("item.Status", "y").ignoreCase())
									.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))//.add(Restrictions.eq("item.Temprature", "y"))
									.add(Restrictions.isNotNull("item.TempratureMin")).add(Restrictions.isNotNull("item.TempratureMax"))
									.setProjection(Projections.projectionList().add(Projections.groupProperty("item.Id"))
											.add(Projections.groupProperty("item.Nomenclature")).add(Projections.groupProperty("item.PvmsNo"))
											.add(Projections.groupProperty("item.TempratureMin")).add(Projections.groupProperty("item.TempratureMax"))
											.add(Projections.groupProperty("unit.ItemUnitName"))
											.add(Projections.sum("ClosingStock"))
											//.add(Projections.groupProperty("BatchNo"))
											/*.add(Projections.groupProperty("Id"))*/).list();
		
		/*equipmentMasterList = session.createCriteria(HesEquipmentMaster.class).createAlias("Item", "item")
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.ge("item.TempratureMin", decmin))
				.add(Restrictions.le("item.TempratureMax", decmax))
				.list();*/
		refrigeratorList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").add(Restrictions.eq("item.Status", "y").ignoreCase())
						.createAlias("item.ItemClass", "category").add(Restrictions.eq("category.ItemClassName", "REFRIGERATORS").ignoreCase())
							.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
							.add(Restrictions.gt("ClosingStock", new BigDecimal (0)))
							.setProjection(Projections.projectionList().add(Projections.groupProperty("item.Id")).add(Projections.groupProperty("item.Nomenclature"))
									).list();
					
							
		
		map.put("refrigeratorAllocationList", refrigeratorAllocationList);
		map.put("refrigeratorList", refrigeratorList);
		return map;
	}
	//---------------------"a" status for Reffigerator Allocation--------------------
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitColdRoomAllocation(Box box) {
		Map<String, Object> map = new HashMap<String,Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector itemId = box.getVector("itemId");
		Vector batchName = box.getVector("batchName");
		Vector grnQty = box.getVector("grnQty");
		Vector storedQty = box.getVector("storedQty");
		Vector pendingQty = box.getVector("pendingQty");
		Vector minTemperature = box.getVector("minTemperature");
		Vector maxTemperature = box.getVector("maxTemperature");
		Vector serialNo = box.getVector("serialNo");
		
		String date = "";
		String time = "";
		boolean flag = false;
		Session session = (Session)getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		int itemIdStock = 0;
		try {
			for (int i =0; i < grnQty.size(); i++) {
			StoreRefrigeratorAllocation storeRefrigeratorAllocation = new StoreRefrigeratorAllocation();
			
			if (itemId.get(i) != null && !itemId.get(i).equals("")) {
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(Integer.parseInt(itemId.get(i).toString()));
				itemIdStock = Integer.parseInt(itemId.get(i).toString());
				storeRefrigeratorAllocation.setItem(masStoreItem);
			}
			/*if (batchId.get(i) != null && !batchId.get(i).equals("")) {
				StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
				storeItemBatchStock.setId(Integer.parseInt(batchId.get(i).toString()));
				storeRefrigeratorAllocation.setStock(storeItemBatchStock);
			}*/
			if (serialNo.get(i) != null && !serialNo.get(i).equals("")) {
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(Integer.parseInt(serialNo.get(i).toString()));
				storeRefrigeratorAllocation.setRefrigeratorNo(masStoreItem);
			}
			if (grnQty.get(i) != null && !grnQty.get(i).equals("")) {
				storeRefrigeratorAllocation.setGrnQty(new BigDecimal(grnQty.get(i).toString()));
			}
			if (batchName.get(i) != null && !batchName.get(i).equals("")) {
				storeRefrigeratorAllocation.setRefBatchNo(batchName.get(i).toString());
			}
			if (storedQty.get(i) != null && !storedQty.get(i).equals("")) {
				storeRefrigeratorAllocation.setStoredQty(new BigDecimal(storedQty.get(i).toString()));
			}
			if (pendingQty.get(i) != null && !pendingQty.get(i).equals("")) {
				storeRefrigeratorAllocation.setPendingQty(new BigDecimal(pendingQty.get(i).toString()));
			}
			/*if (minTemperature.get(i) != null && !minTemperature.get(i).equals("")) {
				storeRefrigeratorAllocation.setMinTemp(new BigDecimal(minTemperature.get(i).toString()));
			}
			if (maxTemperature.get(i) != null && !maxTemperature.get(i).equals("")) {
				storeRefrigeratorAllocation.setMaxTemp(new BigDecimal(maxTemperature.get(i).toString()));
			}*/
			
			storeRefrigeratorAllocation.setStatus("a");
			Users users = new Users();
			users.setId(box.getInt("userId"));
			storeRefrigeratorAllocation.setLastChgBy(users);
			storeRefrigeratorAllocation.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			storeRefrigeratorAllocation.setLastChgTime(time);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			storeRefrigeratorAllocation.setHospital(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			storeRefrigeratorAllocation.setDepartment(masDepartment);
			storeRefrigeratorAllocation.setDiscard_Retain("n");
			storeRefrigeratorAllocation.setTransfer("n");
			
			hbt.save(storeRefrigeratorAllocation);
			flag = true;
			List<StoreItemBatchStock>itemBatchStockList = new ArrayList<StoreItemBatchStock>();
			itemBatchStockList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item")
										.createAlias("Department", "dept").createAlias("Hospital", "hospital").add(Restrictions.eq("item.Id", itemIdStock)).
										add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
							.list();
			if(itemBatchStockList.size()>0){
				for(StoreItemBatchStock storeItemBatchStock :itemBatchStockList){
				StoreItemBatchStock itemBatchStock = (StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, storeItemBatchStock.getId());
				itemBatchStock.setRefrigeratorStatus("Allocate");
				hbt.update(itemBatchStock);
				}
			 }
			}
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	//---------------------"m" status for Temperature Monitor--------------------
	public Map<String, Object> showTemperatureMonitoringJsp(Box box) {
		Map<String, Object> map = new HashMap<String,Object>();
		List<StoreRefrigeratorAllocation> refrigeratorAllocationList = new ArrayList<StoreRefrigeratorAllocation>();
		List<StoreTemperatureMonitoringT>tempMonitoringTList = new ArrayList<StoreTemperatureMonitoringT>();
		Date currentDate=new Date();
		String[] statusArr= {"a","r"};
		Session session = (Session)getSession();
		refrigeratorAllocationList = session.createCriteria(StoreRefrigeratorAllocation.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
										.add(Restrictions.eq("Discard_Retain", "n")).add(Restrictions.eq("Transfer", "n"))
										.add(Restrictions.in("Status", statusArr))
										//.add(Restrictions.eq("LastChgDate", currentDate))
										.list();
		System.out.println("monitoringDate====="+box.getString("monitoringDate"));
		if(!box.getString("monitoringDate").equals("")){
			tempMonitoringTList = session.createCriteria(StoreTemperatureMonitoringT.class).createAlias("MonitoringM", "header")
									.add(Restrictions.eq("header.MonitoringDate", HMSUtil.convertStringTypeDateToDateType(box.getString("monitoringDate")))).list();
		}
		map.put("refrigeratorAllocationList", refrigeratorAllocationList);
		map.put("tempMonitoringTList", tempMonitoringTList);
		return map;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, Object> submitTemperatureMonitoring(Box box) {
		Map<String, Object> map = new HashMap<String,Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector refrigeratorId = box.getVector("refrigeratorId");
		Vector refBatchNo = box.getVector("refBatchNo");
		Vector storedQty = box.getVector("storedQty");
		Vector minTemperature = box.getVector("minTemperature");
		Vector maxTemperature = box.getVector("maxTemperature");
	
		Vector tempA = box.getVector("tempA");
		Vector timeA = box.getVector("timeA");
		Vector tempB = box.getVector("tempB");
		Vector timeB = box.getVector("timeB");
		Vector tempC = box.getVector("tempC");
		Vector timeC = box.getVector("timeC");
		Vector tempD = box.getVector("tempD");
		Vector timeD = box.getVector("timeD");
		Vector refrigeratorAllocationId = box.getVector("refrigeratorAllocationId");
		
		String date = "";
		String time = "";
		boolean flag = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		try {
			for (int i =0; i < refrigeratorId.size(); i++) {
		if(box.getInt("storeTempMontoringMId"+i)!= 0){
			StoreTemperatureMonitoringM temperatureMonitoringM = (StoreTemperatureMonitoringM)hbt.load(StoreTemperatureMonitoringM.class, box.getInt("storeTempMontoringMId"+i));
			if (!box.getString("potency"+i).equals("") && box.getString("potency"+i).equals("y")) {
				temperatureMonitoringM.setPotencyCheck("y");
			}else{
				temperatureMonitoringM.setPotencyCheck("n");
			}
			
			if (!box.getString("transfer"+i).equals("") &&  box.getString("transfer"+i).equals("t")) {
				temperatureMonitoringM.setTransfer("t");
			}else{
				temperatureMonitoringM.setTransfer("n");
			}
			hbt.update(temperatureMonitoringM);
			int refrigeratorAllocateId =Integer.parseInt(refrigeratorAllocationId.get(i).toString());
			StoreRefrigeratorAllocation storeRefrigeratorAllocation = new StoreRefrigeratorAllocation();
			storeRefrigeratorAllocation = (StoreRefrigeratorAllocation)hbt.load(StoreRefrigeratorAllocation.class, refrigeratorAllocateId);
			storeRefrigeratorAllocation.setStatus("m");
			hbt.update(storeRefrigeratorAllocation);
			
		}else{
			StoreTemperatureMonitoringM temperatureMonitoringM = new StoreTemperatureMonitoringM();
			//if (minTemperature != null && minTemperature.size()>0 && !minTemperature.get(i).equals("")) {
				//temperatureMonitoringM.setMinTemp(new BigDecimal(minTemperature.get(i).toString()));
			if (refrigeratorId != null && !refrigeratorId.get(i).equals("")) {
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(Integer.parseInt(refrigeratorId.get(i).toString()));
				temperatureMonitoringM.setRefrigerator(masStoreItem);
			
			if (storedQty != null && !storedQty.get(i).equals("")) {
				temperatureMonitoringM.setStoredQty(new BigDecimal(storedQty.get(i).toString()));
			}
			if (refBatchNo != null && !refBatchNo.get(i).equals("")) {
				temperatureMonitoringM.setRefBatchNo(refBatchNo.get(i).toString());
			}
			
			//temperatureMonitoringM.setStatus("y");
			Users users = new Users();
			users.setId(box.getInt("userId"));
			temperatureMonitoringM.setLastChgBy(users);
			temperatureMonitoringM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			temperatureMonitoringM.setLastChgTime(time);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			temperatureMonitoringM.setHospital(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			temperatureMonitoringM.setDepartment(masDepartment);
			temperatureMonitoringM.setMonitoringDate(HMSUtil.convertStringTypeDateToDateType(date));
			hbt.save(temperatureMonitoringM);
			
			
			if (tempA.get(i) != null && !tempA.get(i).equals("")) {
				StoreTemperatureMonitoringT temperatureMonitoringA = new StoreTemperatureMonitoringT();
				temperatureMonitoringA.setTemperature(new BigDecimal(tempA.get(i).toString()));
			
			if (timeA.get(i) != null && !timeA.get(i).equals("")) {
				temperatureMonitoringA.setMonitoringTime(timeA.get(i).toString());
			 }
				temperatureMonitoringA.setMonitoringM(temperatureMonitoringM);
				hbt.save(temperatureMonitoringA);
				
			}
			
			if (tempB.get(i) != null && !tempB.get(i).equals("")) {
				StoreTemperatureMonitoringT temperatureMonitoringB = new StoreTemperatureMonitoringT();
				temperatureMonitoringB.setTemperature(new BigDecimal(tempB.get(i).toString()));
			
			if (timeB.get(i) != null && !timeB.get(i).equals("")) {
				temperatureMonitoringB.setMonitoringTime(timeB.get(i).toString());
				}
				temperatureMonitoringB.setMonitoringM(temperatureMonitoringM);
				hbt.save(temperatureMonitoringB);
			}
			
			if (tempC.get(i) != null && !tempC.get(i).equals("")) {
				StoreTemperatureMonitoringT temperatureMonitoringC = new StoreTemperatureMonitoringT();
				temperatureMonitoringC.setTemperature(new BigDecimal(tempC.get(i).toString()));
		
			if (timeC.get(i) != null && !timeC.get(i).equals("")) {
				temperatureMonitoringC.setMonitoringTime(timeC.get(i).toString());
			}
				temperatureMonitoringC.setMonitoringM(temperatureMonitoringM);
				hbt.save(temperatureMonitoringC);
				
			}
			if (tempD.get(i) != null && !tempD.get(i).equals("")) {
				StoreTemperatureMonitoringT temperatureMonitoringD = new StoreTemperatureMonitoringT();
				temperatureMonitoringD.setTemperature(new BigDecimal(tempD.get(i).toString()));
		
			if (timeD.get(i) != null && !timeD.get(i).equals("")) {
				temperatureMonitoringD.setMonitoringTime(timeD.get(i).toString());
			 }
				temperatureMonitoringD.setMonitoringM(temperatureMonitoringM);
				hbt.save(temperatureMonitoringD);
			}
		 }
		}
			flag = true;
	}
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPendingListForPotencyCheck(Box box) {
		Map<String, Object> map =  new HashMap<String,Object>();
		List<StoreTemperatureMonitoringM> potencyCheckList = new ArrayList<StoreTemperatureMonitoringM>();
		Session session = (Session)getSession();
		potencyCheckList = session.createCriteria(StoreTemperatureMonitoringM.class).add(Restrictions.eq("PotencyCheck", "y"))
							.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("Department.Id", box.getInt("deptId"))).list();
		map.put("potencyCheckList", potencyCheckList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showTemperatureValidationJsp(Box box) {
		Map<String, Object> map =  new HashMap<String,Object>();
		List<StoreRefrigeratorAllocation> refrigeratorAllocationList = new ArrayList<StoreRefrigeratorAllocation>();
		List<StoreTemperatureMonitoringT> temperatureMonitoringTList = new ArrayList<StoreTemperatureMonitoringT>();
		Session session = (Session)getSession();
		refrigeratorAllocationList = session.createCriteria(StoreRefrigeratorAllocation.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
											.add(Restrictions.eq("RefrigeratorNo.Id", box.getInt("refrigeratoreId"))).list();
		temperatureMonitoringTList = session.createCriteria(StoreTemperatureMonitoringT.class).createAlias("MonitoringM", "header").createAlias("header.Refrigerator", "refrigerator")
										.add(Restrictions.eq("refrigerator.Id", box.getInt("refrigeratoreId"))).createAlias("header.Hospital", "hospital").createAlias("header.Department", "dept")
										.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("dept.Id", box.getInt("deptId"))).list();
		map.put("refrigeratorAllocationList", refrigeratorAllocationList);
		map.put("temperatureMonitoringTList", temperatureMonitoringTList);
		
		return map;
	}

	@Override
	public Map<String, Object> submitTemperatureValidation(Box box) {
		Map<String, Object> map =  new HashMap<String,Object>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int count = 0;
		if(box.getInt("count") != 0){
			count = (Integer)box.getInt("count");
		}
		
		String date = "";
		String time = "";
		boolean flag = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		try {
			
			StoreTemperatureValidation temperatureValidation =new StoreTemperatureValidation();
			temperatureValidation.setValidationRemarks(box.getString("remarks"));
			temperatureValidation.setValidationDate(HMSUtil.convertStringTypeDateToDateType(date));
			StoreTemperatureMonitoringM temperatureMonitoringM = new StoreTemperatureMonitoringM();
			temperatureMonitoringM.setId(box.getInt("monitorongMId"));
			temperatureValidation.setMonitoringM(temperatureMonitoringM);
			temperatureValidation.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			temperatureValidation.setLastChgTime(time);
			Users users = new Users();
			users.setId(box.getInt("userId"));
			temperatureValidation.setLastChgBy(users);
			hbt.save(temperatureValidation);
			
			if(box.getInt("monitorongMId") != 0){
			StoreTemperatureMonitoringM storeTemperatureMonitoringM = (StoreTemperatureMonitoringM)hbt.load(StoreTemperatureMonitoringM.class, box.getInt("monitorongMId")) ;
			
			storeTemperatureMonitoringM.setPotencyCheck("v");
			hbt.update(storeTemperatureMonitoringM);
			}
			for (int i =1; i <= count; i++) {
			if(box.getInt("refrigeratorAllocationId"+i) != 0){
			StoreRefrigeratorAllocation storeRefrigeratorAllocation = (StoreRefrigeratorAllocation)hbt.load(StoreRefrigeratorAllocation.class, box.getInt("refrigeratorAllocationId"+i));
			if (box.getString("discard"+i).equals("discard")) {
				storeRefrigeratorAllocation.setDiscard_Retain("discard");
			}
			if (box.getString("retain"+i).equals("retain")) {
				storeRefrigeratorAllocation.setDiscard_Retain("retain");
			}
			
			/*if (!box.getString("transfer"+i).equals("") &&  box.getString("transfer"+i).equals("y")) {
				storeRefrigeratorAllocation.setTransfer("y");
			}else{
				storeRefrigeratorAllocation.setTransfer("n");
			}*/
			hbt.update(storeRefrigeratorAllocation);
			
			}
			}
			
			flag = true;
			
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showTransferPendingList(Box box) {
		Map<String, Object> map = new HashMap<String,Object>();
		Session session = (Session)getSession();
		List<StoreTemperatureMonitoringM> transferPendingList = new ArrayList<StoreTemperatureMonitoringM>();
		transferPendingList =session.createCriteria(StoreTemperatureMonitoringM.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("Transfer", "t").ignoreCase()).list();
		map.put("transferPendingList", transferPendingList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showRefrigeratorColdRoomReAllocationJsp(Box box) {
		Map<String, Object> map = new HashMap<String,Object>();
		List<StoreRefrigeratorAllocation> refrigeratorReAllocationList = new ArrayList<StoreRefrigeratorAllocation>();
		List<StoreItemBatchStock> refrigeratorList = new ArrayList<StoreItemBatchStock>();
		Session session = (Session)getSession();
		refrigeratorReAllocationList = session.createCriteria(StoreRefrigeratorAllocation.class).createAlias("RefrigeratorNo", "refrigerator")
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("Department.Id", box.getInt("deptId")))
										.add(Restrictions.eq("refrigerator.Id", box.getInt("refrigeratorId"))).list();
		/*equipmentMasterList = session.createCriteria(HesEquipmentMaster.class).add(Restrictions.eq("Status", "y")).list();*/
		
		/*refrigeratorList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").add(Restrictions.eq("item.Status", "y").ignoreCase())
				.createAlias("item.ItemClass", "category").add(Restrictions.eq("category.ItemClassName", "REFRIGERATORS").ignoreCase())
					.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
					.add(Restrictions.gt("ClosingStock", new BigDecimal (0)))
					.setProjection(Projections.projectionList().add(Projections.groupProperty("item.Id")).add(Projections.groupProperty("item.Nomenclature"))
							).list();*/
		
		refrigeratorList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item")
				.createAlias("item.ItemClass", "class").add(Restrictions.eq("class.ItemClassName", "REFRIGERATORS").ignoreCase())
					.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
					.list();
		map.put("refrigeratorReAllocationList", refrigeratorReAllocationList);
		map.put("refrigeratorList", refrigeratorList);
		map.put("temperatureMonitoringId", box.getInt("temperatureMonitoringId"));
		return map;
	}
//-------------------status "r" for reAllocation of Refrigerator--------------------------"
	@Override
	public Map<String, Object> submitColdRoomReAllocation(Box box) {
		Map<String, Object> map = new HashMap<String,Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector itemId = box.getVector("itemId");
		Vector batchId = box.getVector("batchId");
		//Vector grnQty = box.getVector("grnQty");
		Vector storedQty = box.getVector("storedQty");
		//Vector pendingQty = box.getVector("pendingQty");
		Vector minTemperature = box.getVector("minTemperature");
		Vector maxTemperature = box.getVector("maxTemperature");
		Vector serialNo = box.getVector("serialNo");
		Vector reAllocationId = box.getVector("reAllocationId");
		String date = "";
		String time = "";
		boolean flag = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		try {
			for (int i =0; i < storedQty.size(); i++) {
			StoreRefrigeratorAllocation storeRefrigeratorAllocation = new StoreRefrigeratorAllocation();
			if (itemId.get(i) != null && !itemId.get(i).equals("")) {
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(Integer.parseInt(itemId.get(i).toString()));
				storeRefrigeratorAllocation.setItem(masStoreItem);
			}
			/*if (batchId.get(i) != null && !batchId.get(i).equals("")) {
				StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
				storeItemBatchStock.setId(Integer.parseInt(batchId.get(i).toString()));
				storeRefrigeratorAllocation.setStock(storeItemBatchStock);
			}*/
			if (serialNo.get(i) != null && !serialNo.get(i).equals("")) {
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(Integer.parseInt(serialNo.get(i).toString()));
				storeRefrigeratorAllocation.setRefrigeratorNo(masStoreItem);
			}
			
			if (storedQty.get(i) != null && !storedQty.get(i).equals("")) {
				storeRefrigeratorAllocation.setStoredQty(new BigDecimal(storedQty.get(i).toString()));
			}
			
			/*if (minTemperature.get(i) != null && !minTemperature.get(i).equals("")) {
				storeRefrigeratorAllocation.setMinTemp(new BigDecimal(minTemperature.get(i).toString()));
			}
			if (maxTemperature.get(i) != null && !maxTemperature.get(i).equals("")) {
				storeRefrigeratorAllocation.setMaxTemp(new BigDecimal(maxTemperature.get(i).toString()));
			}*/
			
			storeRefrigeratorAllocation.setStatus("r");
			storeRefrigeratorAllocation.setDiscard_Retain("n");
			storeRefrigeratorAllocation.setTransfer("n");
			Users users = new Users();
			users.setId(box.getInt("userId"));
			storeRefrigeratorAllocation.setLastChgBy(users);
			storeRefrigeratorAllocation.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			storeRefrigeratorAllocation.setLastChgTime(time);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			storeRefrigeratorAllocation.setHospital(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			storeRefrigeratorAllocation.setDepartment(masDepartment);
			
			hbt.save(storeRefrigeratorAllocation);
			
			flag = true;
			if(box.getInt("batchId") != 0){
				StoreItemBatchStock itemBatchStock = (StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, box.getInt("batchId"));
				itemBatchStock.setRefrigeratorStatus("ReAllocate");
				hbt.update(itemBatchStock);
			 }
			if(box.getInt("reAllocationId") != 0){
				StoreRefrigeratorAllocation refrigeratorAllocation = (StoreRefrigeratorAllocation)hbt.load(StoreRefrigeratorAllocation.class, box.getInt("reAllocationId"));
				refrigeratorAllocation.setTransfer("r");
				hbt.update(refrigeratorAllocation);
			 }
			if(box.getInt("temperatureMonitoringId") != 0){
				StoreTemperatureMonitoringM storeTemperatureMonitoringM = (StoreTemperatureMonitoringM)hbt.load(StoreTemperatureMonitoringM.class, box.getInt("temperatureMonitoringId"));
				storeTemperatureMonitoringM.setTransfer("r");
				hbt.update(storeTemperatureMonitoringM);
			 }
			}
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showDashBoardOfTemperatureMonitoringJsp(Box box) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Object[]> refrigeratorAllocationList = new ArrayList<Object[]>();
		List<StoreTemperatureMonitoringT> temperatureMonitoringTList = new ArrayList<StoreTemperatureMonitoringT>();
		List<StoreTemperatureMonitoringT> tempMonlist = new ArrayList<StoreTemperatureMonitoringT>();
		
	//	List<StoreTemperatureMonitoringM> temperatureMonitoringMList = new ArrayList<StoreTemperatureMonitoringM>();
		
		Session session = (Session)getSession();
		Date d=new Date();
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		hospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status", "y")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		refrigeratorAllocationList = session.createCriteria(StoreRefrigeratorAllocation.class).createAlias("RefrigeratorNo", "item")
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.add(Restrictions.eq("LastChgDate", d)).setProjection(Projections.projectionList().add(Projections.groupProperty("item.Id"))
						.add(Projections.groupProperty("item.Nomenclature")).add(Projections.groupProperty("RefBatchNo")).add(Projections.groupProperty("LastChgDate"))
						).list();
											//.add(Restrictions.eq("RefrigeratorNo.Id", box.getInt("refrigeratoreId")))
				
		
		/*temperatureMonitoringMList=session.createCriteria(StoreTemperatureMonitoringM.class)
				.createAlias("Hospital", "hosId").add(Restrictions.eq("hosId.Id", box.getInt("hospitalId")))
				.createAlias("LastChgDate", "d").list();*/
		
		/*temperatureMonitoringTList = session.createCriteria(StoreTemperatureMonitoringT.class).createAlias("MonitoringM", "header")
				.createAlias("header.Refrigerator", "refrigerator")
										//.add(Restrictions.eq("refrigerator.Id", box.getInt("refrigeratoreId")))
										.createAlias("header.Hospital", "hospital")
										.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")))
										.add(Restrictions.eq("header.LastChgDate", d)).list();*/
	//	Date d=new Date();
	//	System.out.println("==Before Querry===");
	//	System.out.println(new java.sql.Date(d.getTime()));
		/* String query="select t.MonitoringTime,t.Temperature,m.Refrigerator.LastChgDate,m.Refrigerator.Nomenclature,m.Refrigerator.Id from StoreTemperatureMonitoringT t,"
		 		+ "StoreTemperatureMonitoringM m where t.MonitoringM.Id= m.Id and m.Hospital.Id =:hospId and m.Department.Id =:deptId and m.LastChgDate =:date";
			
		
		 Query q = session.createQuery(query);
		 q.setParameter("hospId", box.getInt("hospitalId"));
		 q.setParameter("deptId", box.getInt("deptId"));
		 q.setParameter("date", new java.sql.Date(d.getTime()) );*/
		 
	 tempMonlist = session.createCriteria(StoreTemperatureMonitoringT.class).createAlias("MonitoringM","header")
				 .add(Restrictions.eq("header.Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("header.Department.Id", box.getInt("deptId")))
				 .add(Restrictions.eq("header.LastChgDate", new Date())).list();
		 
		// List<Object[]> tempMonlist=q.list();
		
		
	 	map.put("tempMonlist", tempMonlist);
		map.put("refrigeratorAllocationList", refrigeratorAllocationList);
		map.put("temperatureMonitoringTList", temperatureMonitoringTList);
		map.put("districtList", districtList);
		map.put("hospitalTypeList", hospitalTypeList);
		map.put("hospitalList", hospitalList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchForTemperatureMonitoringDashBord(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTemperatureMonitoringT> tempMonlist = new ArrayList<StoreTemperatureMonitoringT>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<StoreRefrigeratorAllocation> refrigeratorAllocationList = new ArrayList<StoreRefrigeratorAllocation>();
		List<StoreTemperatureMonitoringT> temperatureMonitoringTList = new ArrayList<StoreTemperatureMonitoringT>();
		
		Criteria criteria = null;
		Session session = (Session)getSession();
		Date d=new Date();
		criteria = session.createCriteria(StoreTemperatureMonitoringT.class).createAlias("MonitoringM","header");
				
		if(box.getInt("hospitalId") != 0){
			criteria = criteria.add(Restrictions.eq("header.Hospital.Id",box.getInt("hospitalId"))).add(Restrictions.eq("header.Department.Id", box.getInt("deptId")));
		}
		 if(!box.getString("fromDate").equals("") && !box.getString("toDate").equals("")){
			criteria = criteria.add(Restrictions.between("header.LastChgDate", HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")), HMSUtil.convertStringTypeDateToDateType(box.getString("toDate"))));
		}
		/*else if(box.getString("instituteType") != null){
			criteria = criteria.add(Restrictions.eq("header.ChallanNo",box.getString("deliveryChallanNo")));
		}
		else if(box.getString("district") != null){
			criteria = criteria.createAlias("header.Supplier", "supplier").add(Restrictions.eq("supplier.Id",box.getInt("supplierId")));
		}*/
		/*else if(box.getString("invoiceNo") != null){
			criteria = criteria.add(Restrictions.eq("header.InvoiceNo",box.getString("invoiceNo")));
		}*/
		
		districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		hospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status", "y")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		refrigeratorAllocationList = session.createCriteria(StoreRefrigeratorAllocation.class)
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				//.add(Restrictions.eq("LastChgDate", d))
											//.add(Restrictions.eq("RefrigeratorNo.Id", box.getInt("refrigeratoreId")))
				.list();
		 
		 
		tempMonlist = criteria.list();
		map.put("tempMonlist", tempMonlist);
		map.put("refrigeratorAllocationList", refrigeratorAllocationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showRefrigeratorAllocationPopup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreRefrigeratorAllocation> refrigeratorAllocationList = new ArrayList<StoreRefrigeratorAllocation>();
		/*List<StoreItemBatchStock> stockList = new ArrayList<StoreItemBatchStock>();*/
		Session session = (Session)getSession();
		/*stockList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").createAlias("Department", "dept").createAlias("Hospital", "hospital")
				.add(Restrictions.eq("item.Id", box.getInt("itemId"))).add(Restrictions.eq("dept.Id", box.getInt("deptId")))
						.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId"))).list();
		map.put("stockList", stockList);*/
		refrigeratorAllocationList = session.createCriteria(StoreRefrigeratorAllocation.class).add(Restrictions.eq("RefrigeratorNo.Id", box.getInt("refrigeratorId")))
				.add(Restrictions.eq("RefBatchNo", box.getString("refBatchNo"))).list();
		map.put("refrigeratorAllocationList", refrigeratorAllocationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getRefrigeratorTemperature(Box box) {
		Map<String, Object> map = new HashMap<String,Object>();
		List<HesEquipmentMaster>eqipmentMasterList = new ArrayList<HesEquipmentMaster>();
		Session session = (Session)getSession();
		eqipmentMasterList = session.createCriteria(HesEquipmentMaster.class).add(Restrictions.idEq(box.getInt("serialId"))).list();
		map.put("eqipmentMasterList", eqipmentMasterList);
		return map;
	}

	@Override
	public Map<String, Object> getRefrigeratorSerialNo(Box box) {
		Map<String, Object> map = new HashMap<String,Object>();
		List<StoreItemBatchStock>itemBatchStockList = new ArrayList<StoreItemBatchStock>();
		List<MasStoreItem>itemList = new ArrayList<MasStoreItem>();
		Session session = (Session)getSession();
		itemBatchStockList = session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("Item.Id", box.getInt("refId"))).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		itemList = session.createCriteria(MasStoreItem.class).add(Restrictions.idEq(box.getInt("refId"))).list();
		map.put("itemBatchStockList", itemBatchStockList);
		map.put("itemList", itemList);
		return map;
	}
}
