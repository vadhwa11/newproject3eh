package jkt.hms.hes.dataservice;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.CommunicationMessages;
import jkt.hms.masters.business.HesCylinderStock;
import jkt.hms.masters.business.HesCylinderTypeMaster;
import jkt.hms.masters.business.HesCylinderUsageEntryDetail;
import jkt.hms.masters.business.HesCylinderUsageEntryHeader;
import jkt.hms.masters.business.HesCylinderUsageMaster;
import jkt.hms.masters.business.HesEmergencyEquipmentBreakdown;
import jkt.hms.masters.business.HesEmptyCylinderDetail;
import jkt.hms.masters.business.HesEmptyCylinderHeader;
import jkt.hms.masters.business.HesEquipmentAmcDetailsEntry;
import jkt.hms.masters.business.HesEquipmentAssessories;
import jkt.hms.masters.business.HesEquipmentBreakdownEntry;
import jkt.hms.masters.business.HesEquipmentCallLogEntry;
import jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown;
import jkt.hms.masters.business.HesEquipmentMaintenance;
import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.HesMaintenanceJobMaster;
import jkt.hms.masters.business.HesMinorRoutineWork;
import jkt.hms.masters.business.HesMinorRoutineWorkDetail;
import jkt.hms.masters.business.HesRefilledCylinderDeliveryDetail;
import jkt.hms.masters.business.HesRefilledCylinderDeliveryHeader;
import jkt.hms.masters.business.HesWorkParticularMaster;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSupplierGroup;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HesDataServiceImpl extends HibernateDaoSupport implements HesDataService
{
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchMaintenanceType(String maintenanceCode,String maintenanceName)
	{
		List<HesMaintenanceJobMaster> searchCountryList = new ArrayList<HesMaintenanceJobMaster>();
		Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
		try
		{
			if ((maintenanceName != null) || (maintenanceCode == null))
			{
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HesMaintenanceJobMaster as i where i.MaintenanceName like '"
								+ maintenanceName + "%' order by i.MaintenanceName");
			}
			else
			{
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HesMaintenanceJobMaster as i where i.MaintenanceCode like '"
								+ maintenanceCode + "%' order by i.MaintenanceCode");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		countryFieldsMap.put("searchCountryList", searchCountryList);
		return countryFieldsMap;
	}
	
	@Override
	public boolean deleteMaintenanceType(int cylinderId,Map<String, Object> generalMap)
	{
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		HesMaintenanceJobMaster master = (HesMaintenanceJobMaster) getHibernateTemplate().get(HesMaintenanceJobMaster.class, cylinderId);

		if (generalMap.get("flag") != null) 
		{
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) 
			{
				master.setStatus("n");
				dataDeleted = true;
			}
			else if (flag.equals("Activate"))
			{
				 master.setStatus("y");
				 dataDeleted = false;
			}
		}
		
		master.setId(cylinderId);
		Users users =new Users();
		users.setId(userId);
		master.setLastChgBy(users);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(master);
			
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return dataDeleted;
	}

	@Override
	public boolean editMaintenanceType(Map<String, Object> generalMap)
	{
		boolean dataUpdated = false;
		Date currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String cylinderName = "";
		String cylinderCode = "";
		int cylinderId = 0;
		String changedBy = "";
		currentDate = new Date();
		int userId=0;

		cylinderId = (Integer) generalMap.get("id");
		cylinderCode = (String) generalMap.get("code");
		cylinderName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");

		HesMaintenanceJobMaster master = (HesMaintenanceJobMaster) getHibernateTemplate().get(HesMaintenanceJobMaster.class, cylinderId);

		master.setId(cylinderId);
		master.setMaintenanceName(cylinderName);
		Users users=new Users();
		users.setId(userId);
		master.setLastChgBy(users);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);

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
			dataUpdated = false;
			e.printStackTrace();
		}
		return dataUpdated;
	}
	
	@Override
	public boolean addMaintenanceType(HesMaintenanceJobMaster master)
	{
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(master);
			hbt.flush();
			hbt.clear();
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded = false;
		}
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> showMaintenanceJobMasterJsp()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesMaintenanceJobMaster> searchCountryList = new ArrayList<HesMaintenanceJobMaster>();
		searchCountryList = getHibernateTemplate().find("from jkt.hms.masters.business.HesMaintenanceJobMaster ");
		map.put("searchCountryList", searchCountryList);			
		return map;
	}
	
	@Override
	public Map<String, Object> showCylinderUsageMasterJsp()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesCylinderUsageMaster> searchCountryList = new ArrayList<HesCylinderUsageMaster>();
		searchCountryList = getHibernateTemplate().find("from jkt.hms.masters.business.HesCylinderUsageMaster ");
		map.put("searchCountryList", searchCountryList);			
		return map;
	}
	
	@Override
	public boolean addCylinderUsage(HesCylinderUsageMaster master)
	{
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(master);
			hbt.flush();
			hbt.clear();
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded = false;
		}
		return successfullyAdded;
	}
	
	@Override
	public boolean editCylinderUsage(Map<String, Object> generalMap)
	{
		boolean dataUpdated = false;
		Date currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String cylinderName = "";
		String cylinderCode = "";
		int cylinderId = 0;
		String changedBy = "";
		int userId=0;
		currentDate = new Date();

		cylinderId = (Integer) generalMap.get("id");
		cylinderCode = (String) generalMap.get("code");
		cylinderName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");

		HesCylinderUsageMaster master = (HesCylinderUsageMaster) getHibernateTemplate().get(HesCylinderUsageMaster.class, cylinderId);

		master.setId(cylinderId);
		master.setCylinderUsageName(cylinderName);
		Users users=new Users();
		users.setId(userId);
		master.setLastChgBy(users);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);

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
			dataUpdated = false;
			e.printStackTrace();
		}
		return dataUpdated;
	}
	
	@Override
	public boolean deleteCylinderUsage(int cylinderId,Map<String, Object> generalMap)
	{
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		HesCylinderUsageMaster master = (HesCylinderUsageMaster) getHibernateTemplate().get(HesCylinderUsageMaster.class, cylinderId);

		if (generalMap.get("flag") != null) 
		{
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) 
			{
				master.setStatus("n");
				dataDeleted = true;
			}
			else if (flag.equals("Activate"))
			{
				 master.setStatus("y");
				 dataDeleted = false;
			}
		}
		
		master.setId(cylinderId);
		Users users=new Users();
		//commented for maven
		/*users.setLastChgBy(changedBy);*/
		master.setLastChgBy(users);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(master);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}

		return dataDeleted;
	}
	
	@Override
	public Map<String, Object> searchCylinderUsage(String cylinderUsageCode,String cylinderUsageName)
	{
		List<HesCylinderTypeMaster> searchCountryList = new ArrayList<HesCylinderTypeMaster>();
		Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
		try
		{
			if ((cylinderUsageName != null) || (cylinderUsageCode == null))
			{
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HesCylinderUsageMaster as i where i.CylinderUsageName like '"
								+ cylinderUsageName + "%' order by i.CylinderUsageName");
			}
			else
			{
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HesCylinderUsageMaster as i where i.CylinderUsageCode like '"
								+ cylinderUsageCode + "%' order by i.CylinderUsageCode");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		countryFieldsMap.put("searchCountryList", searchCountryList);
		return countryFieldsMap;
	}
	
	//Usage Master End
	
	@Override
	public Map<String, Object> showCylinderTypeMasterJsp()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesCylinderTypeMaster> searchCountryList = new ArrayList<HesCylinderTypeMaster>();
		searchCountryList = getHibernateTemplate().find("from jkt.hms.masters.business.HesCylinderTypeMaster ");
		map.put("searchCountryList", searchCountryList);			
		return map;
	}
	
	@Override
	public boolean addCylinderType(HesCylinderTypeMaster cylinderTypeMaster)
	{
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(cylinderTypeMaster);
			hbt.flush();
			hbt.clear();
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded = false;
		}
		return successfullyAdded;
	}
	
	@Override
	public boolean editCylinderType(Map<String, Object> generalMap)
	{
		boolean dataUpdated = false;
		Date currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String cylinderName = "";
		String cylinderCode = "";
		int cylinderId = 0;
		String changedBy = "";
		int userId=0;
		currentDate = new Date();

		cylinderId = (Integer) generalMap.get("id");
		cylinderCode = (String) generalMap.get("code");
		cylinderName = (String) generalMap.get("name");
		userId = (Integer) generalMap.get("userId");

		HesCylinderTypeMaster master = (HesCylinderTypeMaster) getHibernateTemplate().get(HesCylinderTypeMaster.class, cylinderId);

		master.setId(cylinderId);
		master.setCylinderTypeName(cylinderName);
		Users users=new Users();
		users.setId(userId);
		master.setLastChgBy(users);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);

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
			dataUpdated = false;
			e.printStackTrace();
		}
		return dataUpdated;
	}
	
	@Override
	public boolean deleteCylinderType(int cylinderId,Map<String, Object> generalMap)
	{
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int userId=0;
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		HesCylinderTypeMaster master = (HesCylinderTypeMaster) getHibernateTemplate().get(HesCylinderTypeMaster.class, cylinderId);

		if (generalMap.get("flag") != null) 
		{
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) 
			{
				master.setStatus("n");
				dataDeleted = true;
			}
			else if (flag.equals("Activate"))
			{
				 master.setStatus("y");
				 dataDeleted = false;
			}
		}
		
		master.setId(cylinderId);
		Users users=new Users();
		users.setId(userId);
		master.setLastChgBy(users);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(master);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}

		return dataDeleted;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchCylinderType(String cylinderTypeCode,String cylinderTypeName)
	{
		List<HesCylinderTypeMaster> searchCountryList = new ArrayList<HesCylinderTypeMaster>();
		Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
		try
		{
			if ((cylinderTypeName != null) || (cylinderTypeCode == null))
			{
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HesCylinderTypeMaster as i where i.CylinderTypeName like '"
								+ cylinderTypeName + "%' order by i.CylinderTypeName");
			}
			else
			{
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HesCylinderTypeMaster as i where i.CylinderTypeCode like '"
								+ cylinderTypeCode + "%' order by i.CylinderTypeCode");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		countryFieldsMap.put("searchCountryList", searchCountryList);
		return countryFieldsMap;
	}
	
	// Cylinder type master END
	
	@Override
	public Map<String, Object> showWorkParticularMasterJsp()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesWorkParticularMaster> searchCountryList = new ArrayList<HesWorkParticularMaster>();
		searchCountryList = getHibernateTemplate().find("from jkt.hms.masters.business.HesWorkParticularMaster ");
		map.put("searchCountryList", searchCountryList);			
		return map;
	}

	@Override
	public boolean addWorkParticularData(HesWorkParticularMaster hesWork)
	{
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(hesWork);
			hbt.flush();
			hbt.clear();
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded = false;
		}
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> searchWorkParticular(String countryCode,String countryName)
	{
		List<HesWorkParticularMaster> searchCountryList = new ArrayList<HesWorkParticularMaster>();
		Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
		
		try
		{
			if ((countryName != null) || (countryCode == null))
			{
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HesWorkParticularMaster as i where i.WorkParticularName like '"
								+ countryName + "%' order by i.WorkParticularName");
			}
			else
			{
				searchCountryList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HesWorkParticularMaster as i where i.WorkParticularCode like '"
								+ countryCode + "%' order by i.WorkParticularCode");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		countryFieldsMap.put("searchCountryList", searchCountryList);
		
		return countryFieldsMap;
	}

	@Override
	public boolean editWorkParticularToDatabase(Map<String, Object> generalMap)
	{
		boolean dataUpdated = false;
		Date currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String workName = "";
		String workCode = "";
		int workId = 0;
		//String changedBy = "";
		int userId=0; 
		currentDate = new Date();

		workId = (Integer) generalMap.get("id");
		workCode = (String) generalMap.get("workCode");
		workName = (String) generalMap.get("name");
		//changedBy = (String) generalMap.get("changedBy");
		userId = (Integer) generalMap.get("userId");

		HesWorkParticularMaster master = (HesWorkParticularMaster) getHibernateTemplate().get(HesWorkParticularMaster.class, workId);

		master.setId(workId);
		master.setWorkParticularName(workName);
		Users users=new Users();
		users.setId(userId);
		master.setLastChgBy(users);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);

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
			dataUpdated = false;
			e.printStackTrace();
		}

		return dataUpdated;
	}

	@Override
	public boolean deleteWorkParticularMaster(int workId,Map<String, Object> generalMap)
	{
		boolean dataDeleted = false;
		//String changedBy = "";
		int userId=0;
		Date currentDate = new Date();
		String currentTime = "";
		
		//changedBy = (String) generalMap.get("changedBy");
		userId=(Integer)generalMap.get("userId");;
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		
		HesWorkParticularMaster master = (HesWorkParticularMaster) getHibernateTemplate().get(HesWorkParticularMaster.class, workId);

		if (generalMap.get("flag") != null) 
		{
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) 
			{
				master.setStatus("n");
				dataDeleted = true;
			}
			else if (flag.equals("Activate"))
			{
				 master.setStatus("y");
				 dataDeleted = false;
			}
		}
		
		master.setId(workId);
		Users users=new Users();
		users.setId(userId);
		master.setLastChgBy(users);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(master);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}

		return dataDeleted;
	}
	
	// Work Particular master END
	
	@Override
	public Map<String, Object> showMinorRoutineWorkJsp(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List masDepartmentList = new ArrayList();
		List masEmployeeList = new ArrayList();
		List hesWorkList = new ArrayList();
		List entryNoList = new ArrayList();
		String EntryNo = "";
		int hospitalId=(box.getInt("hospitalId"));
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			masDepartmentList = hbt.find("from jkt.hms.masters.business.MasDepartment m where m.Status = 'Y'");
			masEmployeeList = hbt.find("from jkt.hms.masters.business.MasEmployee m where m.Status = 'Y' "
					+ "and m.Hospital ="
					+ hospitalId +"");
			hesWorkList = hbt.find("from jkt.hms.masters.business.HesWorkParticularMaster i where i.Status = 'y'");
			entryNoList = hbt.find("from jkt.hms.masters.business.HesMinorRoutineWork hesMinor where hesMinor.Status = 'y' "
					+ "and hesMinor.Hospital.Id= "
					+ hospitalId
					);
			try
			{
				EntryNo = getEntrySeqForDisplay("HES");
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			
			map.put("masDepartmentList", masDepartmentList);
			map.put("masEmployeeList", masEmployeeList);
			map.put("hesWorkList", hesWorkList);
			map.put("hesEntryList", entryNoList);
			map.put("EntryNo", EntryNo);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return map;
	}
		
	public String getEntrySeqForDisplay(String prefix) throws ParseException
	{
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String entrySeqNo = "";
		DateFormat formatter ; 
		Calendar cal = Calendar.getInstance();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		int nextYear = (cal.get(Calendar.YEAR)+1);
		String finanicalYear = currentYear+"-"+Integer.toString(nextYear);
		String compareDate = "01/04/"+Integer.toString(nextYear);
		
		Date currentDate = formatter.parse(date);
		Date newFinanicalDate = formatter.parse(compareDate);
		
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false); 
		
		try
		{
			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", prefix)).list();
						
			if ((orderSeqNoList == null || orderSeqNoList.size() == 0))
			{
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("HesMinorRoutineWork");
				tsObj.setTransactionPrefix(prefix);
				tsObj.setTransactionSequenceName("Entry No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				tsObj.setFinanicalYear(finanicalYear);
				hbt.save(tsObj);
				entrySeqNo = String.valueOf(1);
			}
			else if (orderSeqNoList.size() > 0) 
			{
				for(TransactionSequence transactionSequence : orderSeqNoList)
				{
					if(finanicalYear.equals(transactionSequence.getFinanicalYear()))
					{
						entrySeqNo = Integer.toString(transactionSequence.getTransactionSequenceNumber()+1);
					}
					else
					{
						int val = currentDate.compareTo(newFinanicalDate);
						
						if(val >= 0)
						{
							transactionSequence.setTransactionSequenceNumber(0);
							transactionSequence.setFinanicalYear(finanicalYear);
							hbt.saveOrUpdate(transactionSequence);
							entrySeqNo = String.valueOf(1);
						}
						else
						{
							entrySeqNo = Integer.toString(transactionSequence.getTransactionSequenceNumber()+1);
						}
					}
				}
			}
			entrySeqNo = entrySeqNo.concat("/").concat(String.valueOf(currentYear));
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	@Override
	public Map<String, Object> getItemNamesForAutocomplete(Map<String, Object> dataMap)
	{

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List cssdMaterialMasterList = new ArrayList();
		List hesWorkList = new ArrayList();
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "%" + dataMap.get("autoHint") + "%";
			
			StringBuffer sb = new StringBuffer();
			sb.append("select item.Nomenclature , item.PvmsNo from jkt.hms.masters.business.StoreItemBatchStock stock , ");
			sb.append("jkt.hms.masters.business.MasStoreItem item where stock.ClosingStock > 0 and ");
			sb.append("stock.Item = item.Id and item.Nomenclature like '"+str+"' ");
			sb.append(" and stock.Department.Id = '"+dataMap.get("deptId")+"' group by item.Id , item.Nomenclature , item.PvmsNo");

			/*Criteria c = session.createCriteria(StoreItemBatchStock.class)
			.add(Restrictions.gt("ClosingStock", new BigDecimal(0)))
			.createAlias("Item", "item")
			.add(Restrictions.like("item.Nomenclature", str));
			c.setFirstResult(0);
			c.setMaxResults(10);
			cssdMaterialMasterList = c.list();*/
			hesWorkList = hbt.find(sb.toString());
			if(hesWorkList.size() > 10)
			{
				cssdMaterialMasterList = hesWorkList.subList(0, 11);
			}
			else
			{
				cssdMaterialMasterList = hesWorkList.subList(0, hesWorkList.size());
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		map.put("cssdItemMasterList", cssdMaterialMasterList);
		return map;
	}

	@Override
	public Map<String, Object> getItemClosingStock(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String pvms_code = "";
		List hesWorkList = new ArrayList();
		if (dataMap.get("pvmsNo") != null) 
		{
			pvms_code = (String) dataMap.get("pvmsNo");
		}
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append("select SUM(stock.ClosingStock), item.Id from jkt.hms.masters.business.StoreItemBatchStock stock , ");
			sb.append("jkt.hms.masters.business.MasStoreItem item where stock.ClosingStock > 0 and ");
			sb.append("stock.Item = item.Id and item.PvmsNo = '"+pvms_code+"' ");
			sb.append(" and stock.Department.Id = '"+dataMap.get("deptId")+"' group by item.Id ");

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hesWorkList = hbt.find(sb.toString());
			map.put("hesWorkList", hesWorkList);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateMinorRoutineWorksEntry(Box box,Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> hesWorkList = new ArrayList<Object[]>();
		List<StoreItemBatchStock> stockList = new ArrayList<StoreItemBatchStock>();
		List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
		boolean saved = false;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String entryNo = box.getString("entryNo");
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.DELIVERY_DATE));
		int workParticularId = box.getInt("workParticular");
		int deptNameId = box.getInt("deptName");
		String remarks = box.getString("remarks");
		int minorId = box.getInt("minorId");
		int completedBy = box.getInt("completedBy");
		int hiddenValueCharge = box.getInt("hiddenValueCharge");
		int deptId = box.getInt("deptId");
		String changedBy = box.getString("lastChgBy");
		String currentTime = box.getString("lastChgTime");
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		HesWorkParticularMaster hesWorkParticularMaster = new HesWorkParticularMaster();
		MasDepartment department = new MasDepartment();
		MasEmployee employee = new MasEmployee();

		Vector materialCode = box.getVector("materialCode");
		Vector quantity = box.getVector("qty");
		Vector materialName = box.getVector("materialName");
		Vector ItemID = box.getVector("ItemID");
		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try
		{
			HesMinorRoutineWork hesMinorRoutineWork = (HesMinorRoutineWork) getHibernateTemplate()
			.get(HesMinorRoutineWork.class, minorId);

			hesMinorRoutineWork.setEntryNo(entryNo);
			hesMinorRoutineWork.setEntryDate(entryDate);

			hesWorkParticularMaster.setId(workParticularId);
			hesMinorRoutineWork.setWorkParticularName(hesWorkParticularMaster);

			department.setId(deptNameId);
			hesMinorRoutineWork.setDepartment(department);

			employee.setId(completedBy);
			hesMinorRoutineWork.setEmpWorkCompleted(employee);

			hesMinorRoutineWork.setRemarks(remarks);
			hesMinorRoutineWork.setStatus("y");
			Users users=new Users();
			//commented for maven
			/*users.setLastChgBy(changedBy);*/
			hesMinorRoutineWork.setLastChgBy(users);
			hesMinorRoutineWork.setLastChgDate(date);
			hesMinorRoutineWork.setLastChgTime(currentTime);

			hbt.saveOrUpdate(hesMinorRoutineWork);
			hbt.refresh(hesMinorRoutineWork);
			hesWorkList = hbt.find("select workDetail.Item.Id , workDetail.Quantity , workDetail.BatchNo, workDetail.Id from jkt.hms.masters.business.HesMinorRoutineWork routineWork , jkt.hms.masters.business.HesMinorRoutineWorkDetail workDetail where routineWork.Id = workDetail.Minorid and workDetail.Minorid = '"+minorId+"' ");
			if(hesWorkList.size() > 0)
			{
				for (Object[] object : hesWorkList)
				{
					int primaryId = Integer.parseInt(object[3].toString());
					int item_id = Integer.parseInt(object[0].toString());
					int qty = Integer.parseInt(object[1].toString());
					stockList = session.createCriteria(StoreItemBatchStock.class)
					.add(Restrictions.eq("Item.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("BatchNo", object[2])).list();
					if (stockList.size() > 0)
					{
						for (StoreItemBatchStock stock : stockList) 
						{
							MasStoreItem item = new MasStoreItem();
							BigDecimal sum = new BigDecimal (0.0D) ; 
							BigDecimal cStock = stock.getClosingStock();
							BigDecimal updatedStock = BigDecimal.valueOf(qty);
							sum = cStock.add(updatedStock);
							stock.setId(stock.getId());
							stock.setClosingStock(sum);
							item.setId(item_id);
							stock.setItem(item);
							stock.setBatchNo(stock.getBatchNo());
							hbt.update(stock);
						}
						Object detail = session.load(HesMinorRoutineWorkDetail.class, primaryId);
						session.delete(detail);
					}
				}
			}

			for (int i = 0; i < materialCode.size(); i++) 
			{
				if (materialCode.get(i) != null && !materialCode.get(i).equals("")) 
				{
					int item_id = Integer.parseInt((String)ItemID.get(i));
					int qty = Integer.parseInt(quantity.get(i).toString());
					itemList = session.createCriteria(StoreItemBatchStock.class)
					.add(Restrictions.eq("Item.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.gt("ClosingStock", new BigDecimal(0))).list();
					if (itemList.size() > 0)
					{
						int remStock = 0;
						boolean flag = false;
						
						for (StoreItemBatchStock stock : itemList) 
						{
							Integer cStock = stock.getClosingStock().intValue();
							String stockBatchNo = stock.getBatchNo();
							if(flag == false)
							{
								if(qty <= stock.getClosingStock().intValue())
								{
									HesMinorRoutineWorkDetail hesMinorRoutineWorkDetail = new HesMinorRoutineWorkDetail();
									MasStoreItem item = new MasStoreItem();
									Integer newStock = cStock - qty;
									BigDecimal updatedStock = BigDecimal.valueOf(newStock);
									stock.setClosingStock(updatedStock);
									stock.setId(stock.getId());
									stock.setBatchNo(stock.getBatchNo());

									hesMinorRoutineWorkDetail.setQuantity(qty);
									item.setId(item_id);
									hesMinorRoutineWorkDetail.setItem(item);
									hesMinorRoutineWorkDetail.setStatus("y");
									hesMinorRoutineWorkDetail.setMinorid(hesMinorRoutineWork);
									hesMinorRoutineWorkDetail.setBatchNo(stockBatchNo);
									hbt.saveOrUpdate(hesMinorRoutineWorkDetail);
									hbt.update(stock);
									break;
								}
								else if(qty > stock.getClosingStock().intValue())
								{
									HesMinorRoutineWorkDetail hesMinorRoutineWorkDetail = new HesMinorRoutineWorkDetail();
									MasStoreItem item = new MasStoreItem();
									remStock = qty - cStock;
									BigDecimal updatedStock = BigDecimal.valueOf(0);
									stock.setClosingStock(updatedStock);
									stock.setId(stock.getId());
									stock.setBatchNo(stock.getBatchNo());
									hesMinorRoutineWorkDetail.setQuantity(cStock);
									item.setId(item_id);
									hesMinorRoutineWorkDetail.setItem(item);
									hesMinorRoutineWorkDetail.setStatus("y");
									hesMinorRoutineWorkDetail.setMinorid(hesMinorRoutineWork);
									hesMinorRoutineWorkDetail.setBatchNo(stockBatchNo);
									hbt.saveOrUpdate(hesMinorRoutineWorkDetail);
									hbt.update(stock);
									flag = true;
								}
							}
							else
							{
								if(remStock != 0)
								{
									HesMinorRoutineWorkDetail hesMinorRoutineWorkDetail = new HesMinorRoutineWorkDetail();
									MasStoreItem item = new MasStoreItem();
									BigDecimal updatedStock = BigDecimal.valueOf(0);
									int closing_Stock = 0;

									if(cStock > remStock)
									{
										closing_Stock = cStock - remStock;
										hesMinorRoutineWorkDetail.setQuantity(remStock);
										updatedStock = BigDecimal.valueOf(closing_Stock);
										remStock = 0;
									}
									else if(remStock > cStock)
									{
										remStock = remStock - cStock;
										hesMinorRoutineWorkDetail.setQuantity(cStock);
										updatedStock = BigDecimal.valueOf(0);
									}
									else if(cStock == remStock || remStock > cStock)
									{
										updatedStock = BigDecimal.valueOf(0);
										remStock = 0;
										hesMinorRoutineWorkDetail.setQuantity(cStock);
									}
									stock.setClosingStock(updatedStock);
									stock.setId(stock.getId());
									stock.setBatchNo(stock.getBatchNo());
									hbt.update(stock);
									item.setId(item_id);
									hesMinorRoutineWorkDetail.setItem(item);
									hesMinorRoutineWorkDetail.setStatus("y");
									hesMinorRoutineWorkDetail.setMinorid(hesMinorRoutineWork);
									hesMinorRoutineWorkDetail.setBatchNo(stockBatchNo);
									hbt.saveOrUpdate(hesMinorRoutineWorkDetail);
									flag = true;
								}
								else
								{	
									break;
								}
							}
						}
					}
				}
			}
			saved = true;
		}
		catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public boolean submitMinorRoutineWorksEntry(Box box,Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
		boolean saved = false;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}

		String entryNo = box.getString("entryNo");
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.DELIVERY_DATE));
		int workParticularId = box.getInt("workParticular");
		int deptNameId = box.getInt("deptName");
		String remarks = box.getString("remarks");
		int completedBy = box.getInt("completedBy");
		int hiddenValueCharge = box.getInt("hiddenValueCharge");
		String changedBy = box.getString("lastChgBy");
		String currentTime = box.getString("lastChgTime");
		int deptId = box.getInt("deptId");
		int userId = box.getInt("userId");
		int hospitalId = box.getInt("hospitalId");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		HesMinorRoutineWork hesMinorRoutineWork = new HesMinorRoutineWork();
		HesWorkParticularMaster hesWorkParticularMaster = new HesWorkParticularMaster();
		MasDepartment department = new MasDepartment();
		MasEmployee employee = new MasEmployee();

		Vector materialCode = box.getVector("materialCode");
		Vector quantity = box.getVector("qty");
		Vector materialName = box.getVector("materialName");
		Vector ItemID = box.getVector("ItemID");

		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try 
		{
			tx = session.beginTransaction();
			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "HES")).list();
			if (orderSeqNoList.size() > 0)
			{
				for (TransactionSequence sequence : orderSeqNoList )
				{
					Integer seqNo = sequence.getTransactionSequenceNumber();
					sequence.setTransactionSequenceNumber((seqNo+1));
					hbt.saveOrUpdate(sequence);
				}
			}
			hesMinorRoutineWork.setEntryNo(entryNo);
			hesMinorRoutineWork.setEntryDate(entryDate);

			hesWorkParticularMaster.setId(workParticularId);
			hesMinorRoutineWork.setWorkParticularName(hesWorkParticularMaster);

			department.setId(deptNameId);
			hesMinorRoutineWork.setDepartment(department);

			employee.setId(completedBy);
			hesMinorRoutineWork.setEmpWorkCompleted(employee);

			hesMinorRoutineWork.setRemarks(remarks);
			hesMinorRoutineWork.setStatus("y");
			Users users =new Users();
			users.setId(userId);
			hesMinorRoutineWork.setLastChgBy(users);
			hesMinorRoutineWork.setLastChgDate(date);
			hesMinorRoutineWork.setLastChgTime(currentTime);
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			hesMinorRoutineWork.setHospital(masHospital);

			hbt.saveOrUpdate(hesMinorRoutineWork);
			hbt.refresh(hesMinorRoutineWork);
			for (int i = 0; i < materialCode.size(); i++) 
			{
				if (materialCode.get(i) != null && !materialCode.get(i).equals("")) 
				{
					int item_id = Integer.parseInt((String)ItemID.get(i));
					int qty = Integer.parseInt(quantity.get(i).toString());
					itemList = session.createCriteria(StoreItemBatchStock.class)
					.add(Restrictions.eq("Item.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.gt("ClosingStock", new BigDecimal(0))).list();
					
					if (itemList.size() > 0)
					{
						int remStock = 0;
						boolean flag = false;
						
						for (StoreItemBatchStock stock : itemList) 
						{
							Integer cStock = stock.getClosingStock().intValue();
							String stockBatchNo = stock.getBatchNo();
							
							if(flag == false)
							{
								if(qty <= stock.getClosingStock().intValue())
								{
									HesMinorRoutineWorkDetail hesMinorRoutineWorkDetail = new HesMinorRoutineWorkDetail();
									MasStoreItem item = new MasStoreItem();
									Integer newStock = cStock - qty;
									BigDecimal updatedStock = BigDecimal.valueOf(newStock);
									stock.setClosingStock(updatedStock);
									stock.setId(stock.getId());
									stock.setBatchNo(stock.getBatchNo());

									hesMinorRoutineWorkDetail.setQuantity(qty);
									item.setId(item_id);
									hesMinorRoutineWorkDetail.setItem(item);
									hesMinorRoutineWorkDetail.setStatus("y");
									hesMinorRoutineWorkDetail.setMinorid(hesMinorRoutineWork);
									hesMinorRoutineWorkDetail.setBatchNo(stockBatchNo);
									hbt.saveOrUpdate(hesMinorRoutineWorkDetail);
									hbt.update(stock);
									break;
								}
								else if(qty > stock.getClosingStock().intValue())
								{
									HesMinorRoutineWorkDetail hesMinorRoutineWorkDetail = new HesMinorRoutineWorkDetail();
									MasStoreItem item = new MasStoreItem();
									remStock = qty - cStock;
									BigDecimal updatedStock = BigDecimal.valueOf(0);
									stock.setClosingStock(updatedStock);
									stock.setId(stock.getId());
									stock.setBatchNo(stock.getBatchNo());
									hesMinorRoutineWorkDetail.setQuantity(cStock);
									item.setId(item_id);
									hesMinorRoutineWorkDetail.setItem(item);
									hesMinorRoutineWorkDetail.setStatus("y");
									hesMinorRoutineWorkDetail.setMinorid(hesMinorRoutineWork);
									hesMinorRoutineWorkDetail.setBatchNo(stockBatchNo);
									hbt.saveOrUpdate(hesMinorRoutineWorkDetail);
									hbt.update(stock);
									flag = true;
								}
							}
							else
							{
								if(remStock != 0)
								{
									HesMinorRoutineWorkDetail hesMinorRoutineWorkDetail = new HesMinorRoutineWorkDetail();
									MasStoreItem item = new MasStoreItem();
									BigDecimal updatedStock = BigDecimal.valueOf(0);
									int closing_Stock = 0;

									if(cStock > remStock)
									{
										closing_Stock = cStock - remStock;
										hesMinorRoutineWorkDetail.setQuantity(remStock);
										updatedStock = BigDecimal.valueOf(closing_Stock);
										remStock = 0;
									}
									else if(remStock > cStock)
									{
										remStock = remStock - cStock;
										hesMinorRoutineWorkDetail.setQuantity(cStock);
										updatedStock = BigDecimal.valueOf(0);
									}
									else if(cStock == remStock || remStock > cStock)
									{
										updatedStock = BigDecimal.valueOf(0);
										remStock = 0;
										hesMinorRoutineWorkDetail.setQuantity(cStock);
									}
									stock.setClosingStock(updatedStock);
									stock.setId(stock.getId());
									stock.setBatchNo(stock.getBatchNo());
									hbt.update(stock);
									
									item.setId(item_id);
									hesMinorRoutineWorkDetail.setItem(item);
									hesMinorRoutineWorkDetail.setStatus("y");
									hesMinorRoutineWorkDetail.setMinorid(hesMinorRoutineWork);
									hesMinorRoutineWorkDetail.setBatchNo(stockBatchNo);
									hbt.saveOrUpdate(hesMinorRoutineWorkDetail);
									flag = true;
								}
								else
								{	
									break;
								}
							}
						}
					}
				}
			}
			saved = true;
			tx.commit();
		}
		catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public Map<String, Object> searchMinorRoutine(Map<String, Object> searchFieldMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String toDate = "";
		int searchWorkParticularId = 0;
		int searchEntryNoId = 0;
		int searchDeptNameId = 0;
		StringBuffer sb = new StringBuffer();
		List searchList = new ArrayList();
		Date date4MySQL2 = null;
		String outFormat = null;

		if (searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")) 
		{
			toDate = (String)searchFieldMap.get("toDate");
			SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
				outFormat = outFmt.format(inFmt.parse(toDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//date4MySQL2 = HMSUtil.dateFormatterDDMMYYYY(toDate);
		}

		if (searchFieldMap.get("searchWorkParticularId") != null) 
		{
			searchWorkParticularId = (Integer)searchFieldMap.get("searchWorkParticularId");
		}

		if (searchFieldMap.get("searchEntryNoId") != null) 
		{
			searchEntryNoId = (Integer)searchFieldMap.get("searchEntryNoId");
		}

	

		try
		{
			sb.append("select minor.Id, minor.EntryNo , minor.EntryDate , dept.DepartmentName , hesMaster.WorkParticularName , minor.Status ");
			sb.append(" from HesMinorRoutineWork minor , HesWorkParticularMaster hesMaster , MasDepartment dept ");
			sb.append(" where minor.WorkParticularName = hesMaster.Id and minor.Department = dept.Id and ");
			sb.append(" minor.Status = 'y' ");
			
			if(outFormat != null && !outFormat.equals(""))
			{
				sb.append(" and minor.EntryDate = '"+outFormat+"' ");
			}
			if(searchWorkParticularId != 0)
			{
				sb.append(" and minor.WorkParticularName = '"+searchWorkParticularId+"' ");
			}
			if(searchEntryNoId != 0)
			{
				sb.append(" and minor.Id = '"+searchEntryNoId+"' ");
			}
			if(searchDeptNameId != 0)
			{
				sb.append(" and minor.Department = '"+searchDeptNameId+"' ");
			}
			sb.append(" order by minor.Id ");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			searchList = hbt.find(sb.toString());
			map.put("searchList", searchList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> modifyMinorRoutine(int radio_str,int deptId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesMinorRoutineWork> orderSeqNoList = new ArrayList<HesMinorRoutineWork>();
		List<Object[]> orderminorList = new ArrayList<Object[]>();
		List hesWorkList = new ArrayList();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List tempList = new ArrayList();
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append("select detail.Item.Id , item.Nomenclature, item.PvmsNo , SUM(detail.Quantity) from jkt.hms.masters.business.HesMinorRoutineWorkDetail detail , ");
			sb.append("jkt.hms.masters.business.MasStoreItem item where detail.Item = item.Id ");
			sb.append(" and detail.Minorid = '"+radio_str+"' group by detail.Item.Id , item.Nomenclature, item.PvmsNo");
			
			orderminorList = hbt.find(sb.toString());
			
			orderSeqNoList = session.createCriteria(HesMinorRoutineWork.class)
			.add(Restrictions.eq("Id", radio_str)).list();
			
			if(orderminorList.size() > 0)
			{
				for (Object[] object : orderminorList)
				{
					int i = 0;
					hesWorkList = hbt.find("select item.Id , SUM(stock.ClosingStock) from jkt.hms.masters.business.StoreItemBatchStock stock , jkt.hms.masters.business.MasStoreItem item where stock.ClosingStock > 0 and stock.Item = item.Id and item.Id = '"+object[0]+"' and stock.Department.Id = '"+deptId+"'  group by item.Id ");
					tempList.add(i, hesWorkList);
					i++;
				}
			}
			map.put("hesClosingList", tempList);
			map.put("hesRoutineWorkList", orderSeqNoList);
			map.put("orderminorList", orderminorList);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	// Methods for Cylinder Usage Entry ------- START
	@Override
	public Map<String, Object> showCylinderUsageEntryJsp(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List hesWorkList = new ArrayList();
		List entryNoList = new ArrayList();
		List headerList = new ArrayList();
		String EntryNo = "";
		int hospitalId= 0; 
		try
		{   hospitalId=box.getInt("hospitalId");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			headerList = hbt.find("from jkt.hms.masters.business.HesCylinderUsageEntryHeader i where i.Status = 'y' and i.Hospital.id="+hospitalId);
			entryNoList = hbt.find("from jkt.hms.masters.business.HesCylinderTypeMaster i where i.Status = 'y'");
			hesWorkList = hbt.find("from jkt.hms.masters.business.HesCylinderUsageMaster cum where cum.Status = 'y' and cum.Hospital.id="+hospitalId);
			try
			{
				EntryNo = getEntrySeqForDisplay("CUE");
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			map.put("hesWorkList", hesWorkList);
			map.put("headerList", headerList);
			map.put("hesEntryList", entryNoList);
			map.put("EntryNo", EntryNo);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateCylinderUsageFormEntry(Box box,Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<HesCylinderStock> itemList = new ArrayList<HesCylinderStock>();
		List<Object[]> hesWorkList = new ArrayList<Object[]>();
		List<HesCylinderStock> stockList = new ArrayList<HesCylinderStock>();
		boolean saved = false;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		
		String entryNo = box.getString("entryNo");
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.DELIVERY_DATE));
		int hiddenValueCharge = box.getInt("hiddenValueCharge");
		String changedBy = box.getString("lastChgBy");
		String currentTime = box.getString("lastChgTime");
		int deptId = box.getInt("deptId");
		int minorId = box.getInt("minorId");
		
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		Vector Usagedate = box.getVector(RequestConstants.CHALLAN_DATE);
		Vector materialName = box.getVector("materialName");
		Vector quantity = box.getVector("qty");
		Vector usedFor = box.getVector("usedFor");
		Vector usedHead = box.getVector("usedHead");
		Vector remarks = box.getVector("remarks");		
		Vector ItemID = box.getVector("ItemID");
		Vector primaryID = box.getVector("primaryID");
		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
				
		try
		{
			tx = session.beginTransaction();
			HesCylinderUsageEntryHeader header = (HesCylinderUsageEntryHeader)
			getHibernateTemplate().get(HesCylinderUsageEntryHeader.class, minorId);
			
			header.setEntryDate(entryDate);
			header.setEntryNo(entryNo);
			Users users=new Users();
			//commented for maven
			/*users.setLastChgBy(changedBy);*/
			header.setLastChgBy(users);
			header.setLastChgDate(date);
			header.setLastChgTime(currentTime);
			header.setStatus("y");
			
			hbt.saveOrUpdate(header);
			hbt.refresh(header);
			hesWorkList = hbt.find("select detail.Id ,detail.Cylinderid.Id , detail.Quantity from jkt.hms.masters.business.HesCylinderUsageEntryDetail detail , jkt.hms.masters.business.HesCylinderUsageEntryHeader header where detail.CylinderUsage = header.Id and detail.CylinderUsage = '"+minorId+"' ");
			if(hesWorkList.size() > 0)
			{
				for (Object[] object : hesWorkList)
				{
					int primaryId = Integer.parseInt(object[0].toString());
					int item_id = Integer.parseInt(object[1].toString());
					int qty = Integer.parseInt(object[2].toString());
					stockList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId)).list();
					if (stockList.size() > 0)
					{
						for (HesCylinderStock stock : stockList) 
						{
							Integer usageStock = stock.getUsageEmptyCylinder();
							Integer updatedUsageStock = usageStock - qty ;
							if(updatedUsageStock < 0)
							{
								updatedUsageStock = 0;
							}
							stock.setId(stock.getId());
							stock.setUsageEmptyCylinder(updatedUsageStock);
							hbt.update(stock);
						}
						Object detail = session.load(HesCylinderUsageEntryDetail.class, primaryId);
						session.delete(detail);
					}
				}
			}
			
			for (int i = 0; i < materialName.size(); i++) 
			{
				if (materialName.get(i) != null && !materialName.get(i).equals("")) 
				{
					Date Udate = HMSUtil.dateFormatterDDMMYYYY((String)Usagedate.get(i));
					int usedForVector = Integer.parseInt((String)usedFor.get(i));
					String usedHeadVector = (String)usedHead.get(i);
					String remarksVector = (String)remarks.get(i);
					int item_id = Integer.parseInt((String)ItemID.get(i));
					int qty = Integer.parseInt(quantity.get(i).toString());
					itemList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId)).list();
					if (itemList.size() > 0)
					{	
						for (HesCylinderStock stock : itemList) 
						{
							Integer usageEmptyStock = stock.getUsageEmptyCylinder();
							Integer newStock = usageEmptyStock + qty;
							stock.setUsageEmptyCylinder(newStock);
							stock.setId(stock.getId());
							HesCylinderUsageEntryDetail usageEntryDetail = new HesCylinderUsageEntryDetail();
							HesCylinderTypeMaster hesCylinderTypeMaster = new HesCylinderTypeMaster();
							HesCylinderUsageMaster usageMaster = new HesCylinderUsageMaster();
							
							usageEntryDetail.setCylinderHead(usedHeadVector);
							usageEntryDetail.setCylinderRemarks(remarksVector);
							usageEntryDetail.setCylinderUsageDate(Udate);
							usageEntryDetail.setQuantity(qty);
							usageEntryDetail.setStatus("y");
							
							hesCylinderTypeMaster.setId(item_id);
							usageEntryDetail.setCylinderid(hesCylinderTypeMaster);
							
							usageMaster.setId(usedForVector);
							usageEntryDetail.setCylinder(usageMaster);
							
							usageEntryDetail.setCylinderUsage(header);
							
							hbt.saveOrUpdate(usageEntryDetail);
							hbt.update(stock);
						}
					}
				}
			}
			saved = true;
			tx.commit();
		}
		catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}
		return saved;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean submitCylinderUsageFormEntry(Box box,Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<HesCylinderStock> itemList = new ArrayList<HesCylinderStock>();
		boolean saved = false;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		
		String entryNo = box.getString("entryNo");
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.DELIVERY_DATE));
		int hiddenValueCharge = box.getInt("hiddenValueCharge");
		String changedBy = box.getString("lastChgBy");
		String currentTime = box.getString("lastChgTime");
		int deptId = box.getInt("deptId");
		int userId=box.getInt("userId");
		int hospitalId=box.getInt("hospitalId");
		
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		Vector Usagedate = box.getVector(RequestConstants.CHALLAN_DATE);
		Vector materialName = box.getVector("materialName");
		Vector quantity = box.getVector("qty");
		Vector usedFor = box.getVector("usedFor");
		Vector usedHead = box.getVector("usedHead");
		Vector remarks = box.getVector("remarks");		
		Vector ItemID = box.getVector("ItemID");
				
		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		HesCylinderUsageEntryHeader usageEntryHeader = new HesCylinderUsageEntryHeader();
		try
		{
			tx = session.beginTransaction();
			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "CUE")).list();
			if (orderSeqNoList.size() > 0)
			{
				for (TransactionSequence sequence : orderSeqNoList )
				{
					Integer seqNo = sequence.getTransactionSequenceNumber();
					sequence.setTransactionSequenceNumber((seqNo+1));
					hbt.saveOrUpdate(sequence);
				}
			}
			usageEntryHeader.setEntryNo(entryNo);
			usageEntryHeader.setEntryDate(entryDate);
			usageEntryHeader.setStatus("y");
			Users users =new Users();
			users.setId(userId);
			usageEntryHeader.setLastChgBy(users);
            MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			usageEntryHeader.setHospital(masHospital);
			usageEntryHeader.setLastChgDate(date);
			usageEntryHeader.setLastChgTime(currentTime);
						
			hbt.saveOrUpdate(usageEntryHeader);
			hbt.refresh(usageEntryHeader);
			for (int i = 0; i < materialName.size(); i++) 
			{
				if (materialName.get(i) != null && !materialName.get(i).equals("")) 
				{
					Date Udate = HMSUtil.dateFormatterDDMMYYYY((String)Usagedate.get(i));
					int usedForVector = Integer.parseInt((String)usedFor.get(i));
					String usedHeadVector = (String)usedHead.get(i);
					String remarksVector = (String)remarks.get(i);
					if(ItemID.get(i)!=null && !ItemID.get(i).equals(""))
					{
					int item_id = Integer.parseInt((String)ItemID.get(i));
					int qty = Integer.parseInt(quantity.get(i).toString());
					
					itemList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", deptId)).list();
					
					if (itemList.size() > 0)
					{	
						for (HesCylinderStock stock : itemList) 
						{
							Integer usageEmptyStock = stock.getUsageEmptyCylinder();
							Integer newStock = usageEmptyStock + qty;
														
							stock.setUsageEmptyCylinder(newStock);
							stock.setId(stock.getId());

							HesCylinderUsageEntryDetail usageEntryDetail = new HesCylinderUsageEntryDetail();
							HesCylinderTypeMaster hesCylinderTypeMaster = new HesCylinderTypeMaster();
							HesCylinderUsageMaster usageMaster = new HesCylinderUsageMaster();
							
							usageEntryDetail.setCylinderHead(usedHeadVector);
							usageEntryDetail.setCylinderRemarks(remarksVector);
							usageEntryDetail.setCylinderUsageDate(Udate);
							usageEntryDetail.setQuantity(qty);
							usageEntryDetail.setStatus("y");
							
							hesCylinderTypeMaster.setId(item_id);
							usageEntryDetail.setCylinderid(hesCylinderTypeMaster);
							
							usageMaster.setId(usedForVector);
							usageEntryDetail.setCylinder(usageMaster);
							
							usageEntryDetail.setCylinderUsage(usageEntryHeader);
							
							hbt.saveOrUpdate(usageEntryDetail);
							hbt.update(stock);
						}
					}
				}
				}
			}
			saved = true;
			tx.commit();	
		}
		catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}
		return saved;
	}
	@Override
	public Map<String, Object> searchCylinderUsageForm(Map<String, Object> searchFieldMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String toDate = "";
		String searchHead = null;
		int searchEntryNoId = 0;
		int searchCylinderTypeId = 0;
		StringBuffer sb = new StringBuffer();
		List searchList = new ArrayList();
		String outFormat = null;

		if (searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")) 
		{
			toDate = (String)searchFieldMap.get("toDate");
			SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
				outFormat = outFmt.format(inFmt.parse(toDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (searchFieldMap.get("searchHead") != null) 
		{
			searchHead = (String)searchFieldMap.get("searchHead");
		}

		if (searchFieldMap.get("searchEntryNoId") != null) 
		{
			searchEntryNoId = (Integer)searchFieldMap.get("searchEntryNoId");
		}

		if (searchFieldMap.get("searchCylinderTypeId") != null) 
		{
			searchCylinderTypeId = (Integer)searchFieldMap.get("searchCylinderTypeId");
		}

		try
		{
			sb.append("select distinct(header.Id), header.EntryNo , header.EntryDate , header.Status ");
			sb.append(" from HesCylinderUsageEntryHeader header , HesCylinderUsageEntryDetail detail , HesCylinderTypeMaster mast ");
			sb.append(" where  header.Id = detail.CylinderUsage.Id and detail.Cylinderid.Id = mast.Id and header.Status = 'y' ");
			
			if(outFormat != null && !outFormat.equals(""))
			{
				sb.append(" and header.EntryDate = '"+outFormat+"' ");
			}
			if(searchEntryNoId != 0)
			{
				sb.append(" and header.Id = '"+searchEntryNoId+"' ");
			}
			if(searchHead != null && !searchHead.equals("0"))
			{
				sb.append(" and detail.CylinderHead = '"+searchHead+"' ");
			}
			if(searchCylinderTypeId != 0)
			{
				sb.append(" and detail.Cylinderid.Id = '"+searchCylinderTypeId+"' ");
			}
			sb.append(" group by header.Id , header.EntryNo , header.EntryDate , header.Status ");
			sb.append(" order by header.Id ");
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			searchList = hbt.find(sb.toString());
			map.put("searchList", searchList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> modifyCylinderUsageForm(int radio_str, int deptId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesCylinderUsageEntryHeader> orderSeqNoList = new ArrayList<HesCylinderUsageEntryHeader>();
		List<Object[]> orderminorList = new ArrayList<Object[]>();
		List<HesCylinderStock> hesWorkList = new ArrayList<HesCylinderStock>();
		List tempList = new ArrayList();
		
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append(" select detail.Id , detail.CylinderUsageDate , detail.Cylinderid.Id , detail.Quantity , detail.Cylinder.Id , detail.CylinderHead , detail.CylinderRemarks ");
			sb.append(" from HesCylinderUsageEntryDetail detail , HesCylinderTypeMaster mast , HesCylinderUsageMaster Umast ");
			sb.append(" where detail.Cylinderid.Id = mast.Id and detail.Cylinder.Id = Umast.Id and detail.CylinderUsage.Id = '"+radio_str+"' ");
			sb.append(" group by detail.Id , detail.CylinderUsageDate , detail.Cylinderid.Id , detail.Quantity , detail.Cylinder.Id , detail.CylinderHead , detail.CylinderRemarks ");
			orderminorList = hbt.find(sb.toString());
			
			orderSeqNoList = session.createCriteria(HesCylinderUsageEntryHeader.class)
			.add(Restrictions.eq("Id", radio_str)).list();
					
			if(orderminorList.size() > 0)
			{
				for (Object[] object : orderminorList)
				{
					int i = 0;
					hesWorkList = hbt.find("select stock.Cylinderid.Id , SUM(stock.UsageEmptyCylinder) from jkt.hms.masters.business.HesCylinderStock stock , jkt.hms.masters.business.HesCylinderTypeMaster mast where stock.Cylinderid = mast.Id and stock.Cylinderid.Id = '"+object[2]+"' and stock.Department.Id = '"+deptId+"'  group by stock.Cylinderid.Id ");
					tempList.add(i, hesWorkList);
					i++;
				}
			}
			map.put("hesClosingList", tempList);
			map.put("orderminorList", orderminorList);
			map.put("hesRoutineWorkList", orderSeqNoList);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return map;
	}
	// Methods for Cylinder Usage Entry ------- END
	
	// Refilled Cylinder Delivery Entry START
	@Override
	public Map<String, Object> showRefilledCylinderRequestJsp(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List masEmployeeList = new ArrayList();
		List hesWorkList = new ArrayList();
		List entryNoList = new ArrayList();
		String EntryNo = "";
		int hospitalId=0;
		try
		{
			hospitalId=box.getInt("hospitalId");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			masEmployeeList = hbt.find("from jkt.hms.masters.business.MasEmployee m where m.Status = 'Y'"
					+ " and m.Department.Id = '"
					+ box.getInt("deptId")
					+"' and m.Hospital.Id = "
					+ hospitalId
					+"");
			entryNoList = hbt.find("from jkt.hms.masters.business.HesCylinderTypeMaster i where i.Status = 'y'");
			hesWorkList = hbt.find("from jkt.hms.masters.business.HesRefilledCylinderDeliveryHeader rcd where rcd.Status = 'y'");
			try
			{
				EntryNo = getEntrySeqForDisplay("RCD");
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			map.put("masEmployeeList", masEmployeeList);
			map.put("hesWorkList", hesWorkList);
			map.put("hesEntryList", entryNoList);
			map.put("EntryNo", EntryNo);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean submitRefilledCylinderDeliveryEntry(Box box,Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<HesCylinderStock> itemList = new ArrayList<HesCylinderStock>();
		boolean saved = false;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		
		String entryNo = box.getString("entryNo");
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.DELIVERY_DATE));
		String challanNo = box.getString("ChallanNo");
		Date challanDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.CHALLAN_DATE));
		String vehicleNo = box.getString("VehicleNo");
		int completedBy = box.getInt("completedBy");
		int hiddenValueCharge = box.getInt("hiddenValueCharge");
		String changedBy = box.getString("lastChgBy");
		String currentTime = box.getString("lastChgTime");
		int deptId = box.getInt("deptId");
		int userId= box.getInt("userId");
		int hospitalId= box.getInt("hospitalId");
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		HesRefilledCylinderDeliveryHeader hesRefilledCylinderDeliveryHeader = new HesRefilledCylinderDeliveryHeader();
		MasEmployee employee = new MasEmployee();

		Vector quantity = box.getVector("qty");
		Vector materialName = box.getVector("materialName");
		Vector ItemID = box.getVector("ItemID");
		
		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try
		{
			tx = session.beginTransaction();
			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "RCD")).list();
			if (orderSeqNoList.size() > 0)
			{
				for (TransactionSequence sequence : orderSeqNoList )
				{
					Integer seqNo = sequence.getTransactionSequenceNumber();
					sequence.setTransactionSequenceNumber((seqNo+1));
					hbt.saveOrUpdate(sequence);
				}
			}
			hesRefilledCylinderDeliveryHeader.setEntryNo(entryNo);
			hesRefilledCylinderDeliveryHeader.setEntryDate(entryDate);
			hesRefilledCylinderDeliveryHeader.setChallanNo(challanNo);
			hesRefilledCylinderDeliveryHeader.setChallanDate(challanDate);
			hesRefilledCylinderDeliveryHeader.setVehicleNo(vehicleNo);
			
			employee.setId(completedBy);
			hesRefilledCylinderDeliveryHeader.setAcMen(employee);
			hesRefilledCylinderDeliveryHeader.setStatus("y");
			Users users =new Users();
			users.setId(userId);
			hesRefilledCylinderDeliveryHeader.setLastChgBy(users);
			hesRefilledCylinderDeliveryHeader.setLastChgDate(date);
			hesRefilledCylinderDeliveryHeader.setLastChgTime(currentTime);
			MasHospital masHospital=new MasHospital();
			masHospital.setId(hospitalId);
			hesRefilledCylinderDeliveryHeader.setHospital(masHospital);
						
			hbt.saveOrUpdate(hesRefilledCylinderDeliveryHeader);
			hbt.refresh(hesRefilledCylinderDeliveryHeader);
			for (int i = 0; i < materialName.size(); i++) 
			{
				if (materialName.get(i) != null && !materialName.get(i).equals("")) 
				{	 
					if(ItemID.get(i)!=null && !ItemID.get(i).equals(""))
					{
					int item_id = Integer.parseInt((String)ItemID.get(i));
					int qty = Integer.parseInt(quantity.get(i).toString());
					itemList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", deptId)).list();
					
					if (itemList.size() > 0)
					{	
						for (HesCylinderStock stock : itemList) 
						{
							Integer cStock = stock.getClosingStock();
							Integer receiveQty = stock.getReceivedQty();
							HesRefilledCylinderDeliveryDetail hesRefilledCylinderDeliveryDetail = new HesRefilledCylinderDeliveryDetail();
							HesCylinderTypeMaster hesCylinderTypeMaster = new HesCylinderTypeMaster();
									
							Integer newStock = cStock + qty;
							Integer newReceiveQty = receiveQty + qty;
							stock.setClosingStock(newStock);
							stock.setReceivedQty(newReceiveQty);
							stock.setId(stock.getId());

							hesRefilledCylinderDeliveryDetail.setQuantity(qty);
							hesRefilledCylinderDeliveryDetail.setStatus("y");
							hesRefilledCylinderDeliveryDetail.setRefilled(hesRefilledCylinderDeliveryHeader);
									
							hesCylinderTypeMaster.setId(item_id);
							hesRefilledCylinderDeliveryDetail.setCylinderid(hesCylinderTypeMaster);
								
							hbt.saveOrUpdate(hesRefilledCylinderDeliveryDetail);
							hbt.update(stock);
							
						}
					}
				}
				}
			}
			saved = true;
			tx.commit();			
		}
		catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}
		return saved;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateRefilledCylinderDeliveryEntry(Box box,Map<String, Object> dataMap)
	{
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<Object[]> hesWorkList = new ArrayList<Object[]>();
		List<HesCylinderStock> stockList = new ArrayList<HesCylinderStock>();
		List<HesCylinderStock> itemList = new ArrayList<HesCylinderStock>();
		boolean saved = false;
		
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		
		String entryNo = box.getString("entryNo");
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.DELIVERY_DATE));
		String challanNo = box.getString("ChallanNo");
		Date challanDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.CHALLAN_DATE));
		String vehicleNo = box.getString("VehicleNo");
		int completedBy = box.getInt("completedBy");
		int hiddenValueCharge = box.getInt("hiddenValueCharge");
		String changedBy = box.getString("lastChgBy");
		String currentTime = box.getString("lastChgTime");
		int deptId = box.getInt("deptId");
		int minorId = box.getInt("minorId");
				
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		MasEmployee employee = new MasEmployee();

		Vector quantity = box.getVector("qty");
		Vector materialName = box.getVector("materialName");
		Vector ItemID = box.getVector("ItemID");				
		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try
		{
			tx = session.beginTransaction();
			HesRefilledCylinderDeliveryHeader hesRefilledCylinderDeliveryHeader = (HesRefilledCylinderDeliveryHeader)
			getHibernateTemplate().get(HesRefilledCylinderDeliveryHeader.class, minorId);
			
			employee.setId(completedBy);
			hesRefilledCylinderDeliveryHeader.setAcMen(employee);
			
			hesRefilledCylinderDeliveryHeader.setChallanDate(challanDate);
			hesRefilledCylinderDeliveryHeader.setChallanNo(challanNo);
			hesRefilledCylinderDeliveryHeader.setEntryDate(entryDate);
			hesRefilledCylinderDeliveryHeader.setEntryNo(entryNo);
			Users users=new Users();
			//commented for maven
			/*users.setLastChgBy(changedBy);*/
			hesRefilledCylinderDeliveryHeader.setLastChgBy(users);
			hesRefilledCylinderDeliveryHeader.setLastChgDate(date);
			hesRefilledCylinderDeliveryHeader.setLastChgTime(currentTime);
			hesRefilledCylinderDeliveryHeader.setVehicleNo(vehicleNo);
			hesRefilledCylinderDeliveryHeader.setStatus("y");
			
			hbt.saveOrUpdate(hesRefilledCylinderDeliveryHeader);
			hbt.refresh(hesRefilledCylinderDeliveryHeader);
			hesWorkList = hbt.find("select detail.Id ,detail.Cylinderid.Id , detail.Quantity from jkt.hms.masters.business.HesRefilledCylinderDeliveryDetail detail , jkt.hms.masters.business.HesRefilledCylinderDeliveryHeader header where detail.Refilled = header.Id and detail.Refilled = '"+minorId+"' ");
			if(hesWorkList.size() > 0)
			{
				for (Object[] object : hesWorkList)
				{
					int primaryId = Integer.parseInt(object[0].toString());
					int item_id = Integer.parseInt(object[1].toString());
					int qty = Integer.parseInt(object[2].toString());
					stockList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId)).list();
					
					if (stockList.size() > 0)
					{
						for (HesCylinderStock stock : stockList) 
						{
							Integer cStock = stock.getClosingStock();
							Integer receiveQty = stock.getReceivedQty();
							Integer updatedStock = cStock - qty ;
							Integer updatedRecieveQty = receiveQty - qty;
							stock.setId(stock.getId());
							stock.setClosingStock(updatedStock);
							stock.setReceivedQty(updatedRecieveQty);
							hbt.update(stock);
						}
						Object detail = session.load(HesRefilledCylinderDeliveryDetail.class, primaryId);
						session.delete(detail);
					}
				}
			}
			
			for (int i = 0; i < materialName.size(); i++) 
			{
				if (materialName.get(i) != null && !materialName.get(i).equals("")) 
				{
					int item_id = Integer.parseInt((String)ItemID.get(i));
					int qty = Integer.parseInt(quantity.get(i).toString());
					
					itemList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId)).list();
					
					if (itemList.size() > 0)
					{	
						for (HesCylinderStock stock : itemList) 
						{
							Integer cStock = stock.getClosingStock();
							Integer receiveQty = stock.getReceivedQty();
							HesRefilledCylinderDeliveryDetail hesRefilledCylinderDeliveryDetail = new HesRefilledCylinderDeliveryDetail();
							HesCylinderTypeMaster hesCylinderTypeMaster = new HesCylinderTypeMaster();
									
							Integer newStock = cStock + qty;
							Integer newReceiveQty = receiveQty + qty;
							stock.setClosingStock(newStock);
							stock.setReceivedQty(newReceiveQty);
							stock.setId(stock.getId());

							hesRefilledCylinderDeliveryDetail.setQuantity(qty);
							hesRefilledCylinderDeliveryDetail.setStatus("y");
							hesRefilledCylinderDeliveryDetail.setRefilled(hesRefilledCylinderDeliveryHeader);
									
							hesCylinderTypeMaster.setId(item_id);
							hesRefilledCylinderDeliveryDetail.setCylinderid(hesCylinderTypeMaster);
								
							hbt.saveOrUpdate(hesRefilledCylinderDeliveryDetail);
							hbt.update(stock);
						}
					}
				}
			}
			saved = true;
			tx.commit();
		}
		catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public Map<String, Object> searchRefilledCylinderDeliveryForm(Map<String, Object> searchFieldMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String toDate = "";
		String searchChallanNo = null;
		int searchEntryNoId = 0;
		String searchVehicleNo = null;
		StringBuffer sb = new StringBuffer();
		List searchList = new ArrayList();
		Date date4MySQL2 = null;
		String outFormat = null;

		if (searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")) 
		{
			toDate = (String)searchFieldMap.get("toDate");
			SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
				outFormat = outFmt.format(inFmt.parse(toDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (searchFieldMap.get("searchChallanNo") != null) 
		{
			searchChallanNo = (String)searchFieldMap.get("searchChallanNo");
		}

		if (searchFieldMap.get("searchEntryNoId") != null) 
		{
			searchEntryNoId = (Integer)searchFieldMap.get("searchEntryNoId");
		}

		if (searchFieldMap.get("searchVehicleNo") != null) 
		{
			searchVehicleNo = (String)searchFieldMap.get("searchVehicleNo");
		}

		try
		{
			sb.append("select header.Id, header.EntryNo , header.EntryDate , header.ChallanNo , header.ChallanDate , emp.FirstName , emp.LastName , header.Status ");
			sb.append(" from HesRefilledCylinderDeliveryHeader header , MasEmployee emp ");
			sb.append(" where header.AcMen = emp.Id and header.Status = 'y' ");
			
			if(outFormat != null && !outFormat.equals(""))
			{
				sb.append(" and header.EntryDate = '"+outFormat+"' ");
			}
			if(searchChallanNo != null && !searchChallanNo.equals("0"))
			{
				sb.append(" and header.ChallanNo = '"+searchChallanNo+"' ");
			}
			if(searchEntryNoId != 0)
			{
				sb.append(" and header.Id = '"+searchEntryNoId+"' ");
			}
			if(searchVehicleNo != null && !searchVehicleNo.equals("0"))
			{
				sb.append(" and header.VehicleNo = '"+searchVehicleNo+"' ");
			}
			sb.append(" order by header.Id ");
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			searchList = hbt.find(sb.toString());
			map.put("searchList", searchList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> modifyRefilledCylinderDeliveryForm(int radio_str, int deptId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesRefilledCylinderDeliveryHeader> orderSeqNoList = new ArrayList<HesRefilledCylinderDeliveryHeader>();
		List<Object[]> orderminorList = new ArrayList<Object[]>();
		List<HesCylinderStock> hesWorkList = new ArrayList<HesCylinderStock>();
		List tempList = new ArrayList();
		
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append("select detail.Id , detail.Cylinderid.Id , SUM(detail.Quantity) from jkt.hms.masters.business.HesRefilledCylinderDeliveryDetail detail , ");
			sb.append("jkt.hms.masters.business.HesCylinderTypeMaster mast where mast.Id = detail.Cylinderid.Id ");
			sb.append(" and detail.Refilled.Id = '"+radio_str+"' group by detail.Id , detail.Cylinderid.Id ");
			orderminorList = hbt.find(sb.toString());
			
			orderSeqNoList = session.createCriteria(HesRefilledCylinderDeliveryHeader.class)
			.add(Restrictions.eq("Id", radio_str)).list();
					
			if(orderminorList.size() > 0)
			{
				for (Object[] object : orderminorList)
				{
					int i = 0;
					hesWorkList = hbt.find("select stock.Cylinderid.Id , SUM(stock.ClosingStock) from jkt.hms.masters.business.HesCylinderStock stock , jkt.hms.masters.business.HesCylinderTypeMaster mast where stock.ClosingStock > 0 and stock.Cylinderid = mast.Id and stock.Cylinderid.Id = '"+object[1]+"' and stock.Department.Id = '"+deptId+"'  group by stock.Cylinderid.Id ");
					tempList.add(i, hesWorkList);
					i++;
				}
			}
			map.put("hesClosingList", tempList);
			map.put("orderminorList", orderminorList);
			map.put("hesRoutineWorkList", orderSeqNoList);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return map;
	}
		
	// Refilled Cylinder Delivery Entry END
	
	// Empty Cylinder Dispatch Entry START
	@Override
	public Map<String, Object> showEmptyCylinderRequestJsp(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List masEmployeeList = new ArrayList();
		List hesWorkList = new ArrayList();
		List entryNoList = new ArrayList();
		String EntryNo = "";
		int hospitalId=0;
		
		try
		{
			hospitalId=box.getInt("hospitalId");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			masEmployeeList = hbt.find("from jkt.hms.masters.business.MasEmployee m where m.Status = 'Y' and m.Department.Id = '"
			+ box.getInt("deptId")
			+ "' and m.Hospital.Id = '"
			+ hospitalId +"'");
			entryNoList = hbt.find("from jkt.hms.masters.business.HesCylinderTypeMaster i where i.Status = 'y'");
			hesWorkList = hbt.find("from jkt.hms.masters.business.HesEmptyCylinderHeader hesMinor where hesMinor.Status = 'y'");
			try
			{
				EntryNo = getEntrySeqForDisplay("ECD");
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			map.put("masEmployeeList", masEmployeeList);
			map.put("hesWorkList", hesWorkList);
			map.put("hesEntryList", entryNoList);
			map.put("EntryNo", EntryNo);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getCylinderClosingStock(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String pvms_code = "";
		List hesWorkList = new ArrayList();
		if (dataMap.get("pvmsNo") != null) 
		{
			pvms_code = (String) dataMap.get("pvmsNo");
		}
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append("select SUM(stock.ClosingStock), item.Id from jkt.hms.masters.business.HesCylinderStock stock , ");
			sb.append("jkt.hms.masters.business.HesCylinderTypeMaster item where stock.ClosingStock > 0 and ");
			sb.append("stock.Cylinderid = item.Id and item.Id = '"+pvms_code+"' ");
			sb.append(" and stock.Department.Id = '"+dataMap.get("deptId")+"' group by item.Id ");

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hesWorkList = hbt.find(sb.toString());
			map.put("hesWorkList", hesWorkList);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean submitEmptyCylinderDispatchEntry(Box box,Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<HesCylinderStock> itemList = new ArrayList<HesCylinderStock>();
		boolean saved = false;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		
		String entryNo = box.getString("entryNo");
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.DELIVERY_DATE));
		String challanNo = box.getString("ChallanNo");
		Date challanDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.CHALLAN_DATE));
		String vehicleNo = box.getString("VehicleNo");
		int completedBy = box.getInt("completedBy");
		int hiddenValueCharge = box.getInt("hiddenValueCharge");
		String changedBy = box.getString("lastChgBy");
		String currentTime = box.getString("lastChgTime");
		int deptId = box.getInt("deptId");
		int userId = box.getInt("userId");
		int hospitalId = box.getInt("hospitalId");
		
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		HesEmptyCylinderHeader emptyCylinderHeader = new HesEmptyCylinderHeader();
		MasEmployee employee = new MasEmployee();

		Vector quantity = box.getVector("qty");
		Vector materialName = box.getVector("materialName");
		Vector ItemID = box.getVector("ItemID");

		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try
		{
			tx = session.beginTransaction();
			orderSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "ECD")).list();
			if (orderSeqNoList.size() > 0)
			{
				for (TransactionSequence sequence : orderSeqNoList )
				{
					Integer seqNo = sequence.getTransactionSequenceNumber();
					sequence.setTransactionSequenceNumber((seqNo+1));
					hbt.saveOrUpdate(sequence);
				}
			}
			emptyCylinderHeader.setEntryNo(entryNo);
			emptyCylinderHeader.setEntryDate(entryDate);
			emptyCylinderHeader.setChallanNo(challanNo);
			emptyCylinderHeader.setChallanDate(challanDate);
			emptyCylinderHeader.setVehicleNo(vehicleNo);
			MasHospital masHospital=new  MasHospital() ;
			masHospital.setId(hospitalId);
			emptyCylinderHeader.setHospital(masHospital);;
			
			employee.setId(completedBy);
			emptyCylinderHeader.setAcMen(employee);
			emptyCylinderHeader.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			emptyCylinderHeader.setLastChgBy(users);
			emptyCylinderHeader.setLastChgDate(date);
			emptyCylinderHeader.setLastChgTime(currentTime);
						
			hbt.saveOrUpdate(emptyCylinderHeader);
			hbt.refresh(emptyCylinderHeader);
			
			for (int i = 0; i < materialName.size(); i++) 
			{
				if (materialName.get(i) != null && !materialName.get(i).equals("")) 
				{
					
					if(ItemID.get(i) != null && !ItemID.get(i).equals("")){
					int item_id = Integer.parseInt((String)ItemID.get(i));
					
					int qty = Integer.parseInt(quantity.get(i).toString());
										
					itemList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.gt("ClosingStock", new Integer(0))).list();
					
					if (itemList.size() > 0)
					{	
						for (HesCylinderStock stock : itemList) 
						{
							Integer cStock = stock.getClosingStock();
							Integer issueQty = stock.getIssueQty();
							if(qty <= stock.getClosingStock())
							{
									HesEmptyCylinderDetail hesEmptyCylinderDetail = new HesEmptyCylinderDetail();
									HesCylinderTypeMaster hesCylinderTypeMaster = new HesCylinderTypeMaster();
									
									Integer newStock = cStock - qty;
									Integer newIssueQty = issueQty + qty;
									stock.setClosingStock(newStock);
									stock.setIssueQty(newIssueQty);
									stock.setId(stock.getId());

									hesEmptyCylinderDetail.setQuantity(qty);
									hesEmptyCylinderDetail.setStatus("y");
									hesEmptyCylinderDetail.setCylinderHeader(emptyCylinderHeader);
									
									hesCylinderTypeMaster.setId(item_id);
									hesEmptyCylinderDetail.setCylinderid(hesCylinderTypeMaster);
								
									hbt.saveOrUpdate(hesEmptyCylinderDetail);
									hbt.update(stock);
							}
						}
					}
				}
				}
			}	
			saved = true;
			tx.commit();
		}
		catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}
		return saved;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateEmptyCylinderDispatchEntry(Box box,Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<Object[]> hesWorkList = new ArrayList<Object[]>();
		List<HesCylinderStock> stockList = new ArrayList<HesCylinderStock>();
		List<HesCylinderStock> itemList = new ArrayList<HesCylinderStock>();
		boolean saved = false;
		
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String entryNo = box.getString("entryNo");
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.DELIVERY_DATE));
		String challanNo = box.getString("ChallanNo");
		Date challanDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(RequestConstants.CHALLAN_DATE));
		String vehicleNo = box.getString("VehicleNo");
		int completedBy = box.getInt("completedBy");
		int hiddenValueCharge = box.getInt("hiddenValueCharge");
		String changedBy = box.getString("lastChgBy");
		String currentTime = box.getString("lastChgTime");
		int deptId = box.getInt("deptId");
		int minorId = box.getInt("minorId");
				
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		MasEmployee employee = new MasEmployee();

		Vector quantity = box.getVector("qty");
		Vector materialName = box.getVector("materialName");
		Vector ItemID = box.getVector("ItemID");
		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try
		{
			tx = session.beginTransaction();
			HesEmptyCylinderHeader emptyCylinderHeader = (HesEmptyCylinderHeader) getHibernateTemplate()
			.get(HesEmptyCylinderHeader.class, minorId);
			
			employee.setId(completedBy);
			emptyCylinderHeader.setAcMen(employee);
			
			emptyCylinderHeader.setChallanDate(challanDate);
			emptyCylinderHeader.setChallanNo(challanNo);
			emptyCylinderHeader.setEntryDate(entryDate);
			emptyCylinderHeader.setEntryNo(entryNo);
			Users users=new Users();
			//commented for maven
			/*users.setLastChgBy(changedBy);*/
			emptyCylinderHeader.setLastChgBy(users);
			emptyCylinderHeader.setLastChgDate(date);
			emptyCylinderHeader.setLastChgTime(currentTime);
			emptyCylinderHeader.setVehicleNo(vehicleNo);
			emptyCylinderHeader.setStatus("y");
			
			hbt.saveOrUpdate(emptyCylinderHeader);
			hbt.refresh(emptyCylinderHeader);
			
			hesWorkList = hbt.find("select detail.Id ,detail.Cylinderid.Id , detail.Quantity from jkt.hms.masters.business.HesEmptyCylinderDetail detail , jkt.hms.masters.business.HesEmptyCylinderHeader header where detail.CylinderHeader = header.Id and detail.CylinderHeader = '"+minorId+"' ");
			if(hesWorkList.size() > 0)
			{
				for (Object[] object : hesWorkList)
				{
					int primaryId = Integer.parseInt(object[0].toString());
					int item_id = Integer.parseInt(object[1].toString());
					int qty = Integer.parseInt(object[2].toString());
					stockList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId)).list();
					
					if (stockList.size() > 0)
					{
						for (HesCylinderStock stock : stockList) 
						{
							Integer cStock = stock.getClosingStock();
							Integer issueQty = stock.getIssueQty();
							Integer updatedStock = qty + cStock;
							Integer updatedIssueQty = issueQty - qty;
							stock.setId(stock.getId());
							stock.setClosingStock(updatedStock);
							stock.setIssueQty(updatedIssueQty);
							hbt.update(stock);
						}
						Object detail = session.load(HesEmptyCylinderDetail.class, primaryId);
						session.delete(detail);
					}
				}
			}
			
			for (int i = 0; i < materialName.size(); i++) 
			{
				if (materialName.get(i) != null && !materialName.get(i).equals("")) 
				{
					int item_id = Integer.parseInt((String)ItemID.get(i));
					int qty = Integer.parseInt(quantity.get(i).toString());
					itemList = session.createCriteria(HesCylinderStock.class)
					.add(Restrictions.eq("Cylinderid.Id", item_id))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.gt("ClosingStock", new Integer(0))).list();
					
					if (itemList.size() > 0)
					{	
						for (HesCylinderStock stock : itemList) 
						{
							Integer cStock = stock.getClosingStock();
							Integer issueQty = stock.getIssueQty();
							if(qty <= stock.getClosingStock())
							{
									HesEmptyCylinderDetail hesEmptyCylinderDetail = new HesEmptyCylinderDetail();
									HesCylinderTypeMaster hesCylinderTypeMaster = new HesCylinderTypeMaster();
									
									Integer newStock = cStock - qty;
									Integer newIssueQty = issueQty + qty;
									stock.setClosingStock(newStock);
									stock.setIssueQty(newIssueQty);
									stock.setId(stock.getId());

									hesEmptyCylinderDetail.setQuantity(qty);
									hesEmptyCylinderDetail.setStatus("y");
									hesEmptyCylinderDetail.setCylinderHeader(emptyCylinderHeader);
									
									hesCylinderTypeMaster.setId(item_id);
									hesEmptyCylinderDetail.setCylinderid(hesCylinderTypeMaster);
								
									hbt.saveOrUpdate(hesEmptyCylinderDetail);
									hbt.update(stock);
							}
						}
					}
				}
			}
			saved = true;
			tx.commit();
		}
		catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public Map<String, Object> searchEmptyCylinderDispatchForm(Map<String, Object> searchFieldMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String toDate = "";
		String searchChallanNo = null;
		int searchEntryNoId = 0;
		String searchVehicleNo = null;
		StringBuffer sb = new StringBuffer();
		List searchList = new ArrayList();
		Date date4MySQL2 = null;
		String outFormat = null;

		if (searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")) 
		{
			toDate = (String)searchFieldMap.get("toDate");
			SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
				outFormat = outFmt.format(inFmt.parse(toDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (searchFieldMap.get("searchChallanNo") != null) 
		{
			searchChallanNo = (String)searchFieldMap.get("searchChallanNo");
		}

		if (searchFieldMap.get("searchEntryNoId") != null) 
		{
			searchEntryNoId = (Integer)searchFieldMap.get("searchEntryNoId");
		}

		if (searchFieldMap.get("searchVehicleNo") != null) 
		{
			searchVehicleNo = (String)searchFieldMap.get("searchVehicleNo");
		}

		try
		{
			sb.append("select header.Id, header.EntryNo , header.EntryDate , header.ChallanNo , header.ChallanDate , emp.FirstName , emp.LastName , header.Status ");
			sb.append(" from HesEmptyCylinderHeader header , MasEmployee emp ");
			sb.append(" where header.AcMen = emp.Id and header.Status = 'y' ");
			
			if(outFormat != null && !outFormat.equals(""))
			{
				sb.append(" and header.EntryDate = '"+outFormat+"' ");
			}
			if(searchChallanNo != null && !searchChallanNo.equals("0"))
			{
				sb.append(" and header.ChallanNo = '"+searchChallanNo+"' ");
			}
			if(searchEntryNoId != 0)
			{
				sb.append(" and header.Id = '"+searchEntryNoId+"' ");
			}
			if(searchVehicleNo != null && !searchVehicleNo.equals("0"))
			{
				sb.append(" and header.VehicleNo = '"+searchVehicleNo+"' ");
			}
			sb.append(" order by header.Id ");
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			searchList = hbt.find(sb.toString());
			map.put("searchList", searchList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> modifyEmptyCylinderDispatchForm(int radio_str,int deptId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesEmptyCylinderHeader> orderSeqNoList = new ArrayList<HesEmptyCylinderHeader>();
		List<Object[]> orderminorList = new ArrayList<Object[]>();
		List<HesCylinderStock> hesWorkList = new ArrayList<HesCylinderStock>();
		List tempList = new ArrayList();
		
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append("select detail.Id , detail.Cylinderid.Id , SUM(detail.Quantity) from jkt.hms.masters.business.HesEmptyCylinderDetail detail , ");
			sb.append("jkt.hms.masters.business.HesCylinderTypeMaster mast where mast.Id = detail.Cylinderid.Id ");
			sb.append(" and detail.CylinderHeader.Id = '"+radio_str+"' group by detail.Id , detail.Cylinderid.Id ");
			orderminorList = hbt.find(sb.toString());
			
			orderSeqNoList = session.createCriteria(HesEmptyCylinderHeader.class)
			.add(Restrictions.eq("Id", radio_str)).list();
					
			if(orderminorList.size() > 0)
			{
				for (Object[] object : orderminorList)
				{
					int i = 0;
					hesWorkList = hbt.find("select stock.Cylinderid.Id , SUM(stock.ClosingStock) from jkt.hms.masters.business.HesCylinderStock stock , jkt.hms.masters.business.HesCylinderTypeMaster mast where stock.ClosingStock > 0 and stock.Cylinderid = mast.Id and stock.Cylinderid.Id = '"+object[1]+"' and stock.Department.Id = '"+deptId+"'  group by stock.Cylinderid.Id ");
					tempList.add(i, hesWorkList);
					i++;
				}
			}
			map.put("hesClosingList", tempList);
			map.put("orderminorList", orderminorList);
			map.put("hesRoutineWorkList", orderSeqNoList);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return map;
	}
	// Empty Cylinder Dispatch Entry END
	
	//Entry Date Code for generating the Equipment Entry No By Amit
	
	public String getMaxEquipmentDate(String no) {
		String sequenceNo="";
		String fixedEntryNo="BMES/EQP-";
		
		try{
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate="";
			currentDate = (String) utilMap.get("currentDate");
			String financialYear="";
			int sequenceCounter=0;
			financialYear=HMSUtil.getfinancialYear(currentDate);

			if(!no.equalsIgnoreCase("") ){
				
				String[] str = no.split("/");
				String seqTemp="";
				if(str[1]!=""){
					seqTemp=str[1];
					String[] strSeq = seqTemp.split("-");
					
					if(strSeq[1]!=""){
						sequenceCounter=Integer.parseInt(""+strSeq[1])+1;
					}
					else{
						sequenceCounter=1;
					}
				}
				
			}else{
				sequenceCounter=1;
			}
			if(no != null || no != ""){
				sequenceNo=fixedEntryNo+""+sequenceCounter+"/"+financialYear;
			}
			else{
				sequenceNo="BMES/EQP-"+""+sequenceCounter+"/"+financialYear;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sequenceNo;
	}
	
	//--------------END METHOD---------------
	
	// Start For Equipment Details Entry
	
	@Override
	public Map<String, Object> showEquipmentDetailsMasterJsp(int hospitalId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesEquipmentMaster> checkEntryNo = new ArrayList<HesEquipmentMaster>(); 
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try{
			    String num="";
		    	String entryNo="";
		    	checkEntryNo = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster as hes where hes.Hospital.Id="+ hospitalId +"order by hes.Id desc");
		    	if(checkEntryNo.size()>0){
		    		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
		    		hesEquipmentMaster=checkEntryNo.get(0);
		    		entryNo=hesEquipmentMaster.getEntryNo();
		    		num=getMaxEquipmentDate(entryNo);
		    	}
		    	else{
		    		num=getMaxEquipmentDate(entryNo);
		    	}
		    	departmentList = hbt.find("from jkt.hms.masters.business.MasDepartment as m where m.Status = 'Y'");
				 map.put("num", num);
		    	map.put("departmentList",departmentList);
		   }
		
		catch(Exception pe)
		{
			pe.printStackTrace();
		}
		return map;
	}
	
	//Method for Submit form with save at Equipment Entry Details
		
	public boolean submitEquipmentEntry(Map<String, Object> dataMap)
	{
		List<HesEquipmentAssessories> hesEquipmentAssessoriesList=new ArrayList<HesEquipmentAssessories>();
		boolean saved = false;
		int hospitalId=0;
		
    	HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
    	if(dataMap.get("hesEquipmentMaster")!=null || dataMap.get("hesEquipmentMaster")!=""){
    		hesEquipmentMaster=(HesEquipmentMaster)dataMap.get("hesEquipmentMaster");
		}
    	if(dataMap.get("hesEquipmentAssessoriesList")!=null || dataMap.get("hesEquipmentAssessoriesList")!=""){
    		hesEquipmentAssessoriesList=(List<HesEquipmentAssessories>)dataMap.get("hesEquipmentAssessoriesList");
		}
        Session session =(Session)getSession();
        HibernateTemplate hbt = getHibernateTemplate();
        hbt.setFlushModeName("FLUSH_EAGER");
        hbt.setCheckWriteOperations(false);
       
        try{
        	
        	hesEquipmentMaster =(HesEquipmentMaster)dataMap.get("hesEquipmentMaster");
        	MasHospital masHospital=new MasHospital();
        	masHospital=hesEquipmentMaster.getHospital();
        	hospitalId=masHospital.getId();
        	List<HesEquipmentMaster> checkEntryNo = new ArrayList<HesEquipmentMaster>(); 
	    	String num="";
	    	String serialNo="";
	    	String entryNo="";
	    	checkEntryNo = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster as hes where hes.Hospital.Id="+ hospitalId +"order by hes.Id desc");
	    	if(checkEntryNo.size()>0){
	    		HesEquipmentMaster hesEquipmentMasterDetails=new HesEquipmentMaster();
	    		hesEquipmentMasterDetails=checkEntryNo.get(0);
	    		//serialNo=hesEquipmentMasterDetails.getSerialNo();
	    		entryNo=hesEquipmentMasterDetails.getEntryNo();
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	else{
	    		num=getMaxEquipmentDate(entryNo);
	    	}
        	session.save(hesEquipmentMaster);
        	if(hesEquipmentAssessoriesList.size()>0){
                for(HesEquipmentAssessories hesEquipmentAssery : hesEquipmentAssessoriesList){
                	hesEquipmentAssery.setEquipment(hesEquipmentMaster);
                	hbt.save(hesEquipmentAssery);
                }
                }
        	saved=true;
        }
        catch (Exception e) {
        	saved=false;
			e.printStackTrace();
		}
            return saved;
	}
	
///////////////////////////////Method for Search Equipment Entry No///////////////////////
	
	
	
	public Map<String, Object> searchEquipmentEntry(Map<String, Object> searchFieldMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String entryIdTemp ="";
		List<HesEquipmentMaster> searchEquipmentList = new ArrayList<HesEquipmentMaster>();
		List<Object> assessoryList = new ArrayList<Object>();
		for (Iterator iterator = assessoryList.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
		}
		
		if(searchFieldMap.get("entryIdTemp")!=null){
			entryIdTemp=(String)searchFieldMap.get("entryIdTemp");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		String query="";
		try
		{	
			assessoryList = hbt.find("select hea , em from jkt.hms.masters.business.HesEquipmentAssessories as hea join  hea.EquipmentMaster as em  where em.EntryNo='"+entryIdTemp+"' and  hea.Status='y'");
			
			Criteria crit = session.createCriteria(HesEquipmentMaster.class).add(Restrictions.eq("EntryNo", entryIdTemp));
			searchEquipmentList = crit.list();
			for (Iterator iterator = assessoryList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
	     }
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		map.put("assessoryList", assessoryList);
		map.put("searchEquipmentList", searchEquipmentList);
		return map;
	}
	
	
	
	public Map<String,Object> getEntryListForEquipment(Map<String,Object> getMap){
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesEquipmentMaster> equipmentNoList = new ArrayList<HesEquipmentMaster>();
		Session session = (Session)getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
			try {
				String str = (String)getMap.get("autoHint")+ "%";
				Criteria crt = session.createCriteria(HesEquipmentMaster.class).add(
						Restrictions.like("EntryNo", str));
				
				crt.setFirstResult(0);
				crt.setMaxResults(10);
				equipmentNoList = crt.list();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		map.put("equipmentNoList", equipmentNoList);
		return map;
	}
	
public Map<String,Object> getEquipmentBreakdown(Map<String,Object> getMap){
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesEquipmentBreakdownEntry> equipmentBreakdownList = new ArrayList<HesEquipmentBreakdownEntry>();
		Session session = (Session)getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
			try {
				String str = (String)getMap.get("autoHint")+ "%";
				Criteria crt = session.createCriteria(HesEquipmentBreakdownEntry.class).add(
						Restrictions.like("EntryNo", str));
				crt.setFirstResult(0);
				crt.setMaxResults(10);
				equipmentBreakdownList = crt.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		map.put("equipmentBreakdownList", equipmentBreakdownList);
		return map;
	}
	/////////////////////////////////////////////

public Map<String, Object> searchEquipmentBreakdownEntry(Map<String, Object> searchFieldMap)
{
	Map<String, Object> map = new HashMap<String, Object>();
	List employeeListTo = new ArrayList();
	List employeeListFrom = new ArrayList();
	List<HesEquipmentMaster> hesEqpMaster = new ArrayList<HesEquipmentMaster>(); 
	String entryNo = "";
	String num="";
  
	org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
	hbt1.setFlushModeName("FLUSH_EAGER");
	hbt1.setCheckWriteOperations(false);
	
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session = (Session) getSession();
	String query="";
	List departmentList = new ArrayList();
	try{
		hesEqpMaster = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster as hes where hes.Status='y' order by hes.Id desc");
    	
    	String entryIdBreakdown ="";
    	List<HesEquipmentBreakdownEntry> searchEquipmentBreakdownList = new ArrayList<HesEquipmentBreakdownEntry>();
    		if(searchFieldMap.get("entryIdBreakdown")!=null){
    		entryIdBreakdown=(String)searchFieldMap.get("entryIdBreakdown");
    	}

    		Criteria crit = session.createCriteria(HesEquipmentBreakdownEntry.class).add(Restrictions.eq("EntryNo", entryIdBreakdown));
    		searchEquipmentBreakdownList = crit.list();
    		if(hesEqpMaster.size()>0){
    		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
    		hesEquipmentMaster=hesEqpMaster.get(0);
    		entryNo=hesEquipmentMaster.getEntryNo();
    		num=getMaxEquipmentDate(entryNo);
    	}
    	else{
    		num=getMaxEquipmentDate(entryNo);
    	}
    	departmentList = hbt.find("from jkt.hms.masters.business.MasDepartment as m where m.Status = 'y'");
		employeeListTo = hbt1.find("from jkt.hms.masters.business.MasEmployee as me where me.Status = 'y'");
		employeeListFrom = hbt1.find("from jkt.hms.masters.business.MasEmployee as me where me.Status = 'y'");
		map.put("num", num);
		map.put("departmentList", departmentList);
		map.put("employeeListTo", employeeListTo);
		map.put("employeeListFrom", employeeListFrom);
		map.put("equipmentNameList", hesEqpMaster);
		map.put("searchEquipmentBreakdownList", searchEquipmentBreakdownList);
	}
	catch(Exception e)
	{	
		e.printStackTrace();
	}
	return map;

}
/////////////////////////////////////////////////////////////////////////


	
	
//////////////////Code for show Equipment Preventive Maintenance Entry/////////////////
	
	public Map<String, Object> showEquipmentMaintenanceEntryJsp(Map<String, Object> showMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List departmentList = new ArrayList();
		List employeeList = new ArrayList();
		List jobMaintenanceList = new ArrayList();
		List<HesEquipmentMaintenance> entryNoList = new ArrayList<HesEquipmentMaintenance>();
		List<HesEquipmentMaintenance> 		hesEqpMaster = new ArrayList<HesEquipmentMaintenance>();
		List<HesEquipmentMaster> 		hesEqpuipmentMaster = new ArrayList<HesEquipmentMaster>();		
		String entryNo = "";
		String num="";
		int hospitalId=0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try{
			
			hospitalId=(Integer) showMap.get("hospitalId");
			hesEqpMaster = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaintenance as hes where hes.Status='y'"
					+ "and hes.Hospital.Id ="
					+ hospitalId
					+ " order by hes.Id desc");
	    	if(hesEqpMaster.size()>0){
	    		HesEquipmentMaintenance hesEquipmentMaster=new HesEquipmentMaintenance();
	    		hesEquipmentMaster=hesEqpMaster.get(0);
	    		entryNo=hesEquipmentMaster.getEntryNo();
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	else{
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	entryNoList=getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaintenance as hem where hem.Hospital.Id="+hospitalId);
	    	hesEqpuipmentMaster=getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster as hem where hem.Hospital.Id ="
	    			+ hospitalId);
	    	departmentList = hbt.find("from jkt.hms.masters.business.MasDepartment as m where m.Status = 'Y'");
			employeeList = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Status = 'Y' "
					+ " and me.Hospital.Id= "
					+hospitalId);
			jobMaintenanceList = hbt.find("from jkt.hms.masters.business.HesMaintenanceJobMaster as jm where jm.Status = 'y'");
			
			map.put("num", num);
			map.put("entryNoList", entryNoList);
			map.put("departmentList", departmentList);
			map.put("employeeList", employeeList);
			map.put("jobMaintenanceList", jobMaintenanceList);
			map.put("equipmentNameList", hesEqpMaster);
			map.put("hesEqpuipmentMaster", hesEqpuipmentMaster);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return map;
		}
	
//////////////////Code for Submit Equipment Preventive Maintenance Entry/////////////////
	
		
   public Map<String,Object> submitEquipmentMaintenanceEntryJsp(Map<String, Object> dataMap){

	Map<String, Object> map = new HashMap<String, Object>();   
      
	List<HesEquipmentMaster> hesEqupmentList = new ArrayList<HesEquipmentMaster>(); 
    HesEquipmentMaintenance hesEquipmentMaintenance = new HesEquipmentMaintenance();
	boolean saved = false;
	String entryNo="";
	String num="";
	int hospitalId=0;

	if(dataMap.get("hesEqpMaintenance")!=null || dataMap.get("hesEqpMaintenance")!=""){
		hesEquipmentMaintenance=(HesEquipmentMaintenance)dataMap.get("hesEqpMaintenance");
	}
    HibernateTemplate hbt = getHibernateTemplate();
    hbt.setFlushModeName("FLUSH_EAGER");
    hbt.setCheckWriteOperations(false);
    	try{
    		hospitalId=(Integer) dataMap.get("hospitalId");
    		hesEqupmentList = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster as hes where hes.Status='y' "
    				+ "and hes.Hospital.Id ="
    				+ hospitalId
    				+"order by hes.Id desc");
	    	if(hesEqupmentList.size()>0){
	    		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
	    		hesEquipmentMaster=hesEqupmentList.get(0);
	    		entryNo=hesEquipmentMaster.getEntryNo();
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	else{
	    		num=getMaxEquipmentDate(entryNo);
	    	}
    	hbt.save(hesEquipmentMaintenance);
    }
    catch (Exception e) {
		e.printStackTrace();
	}
        return dataMap;	
}   
 
   public Map<String, Object> searchMaintenanceEntry(Map<String, Object> searchFieldMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String toDate= "";
		int equipmentName=0;
		int searchEntryNo=0;
		List<HesEquipmentMaintenance> entryNoList = new ArrayList<HesEquipmentMaintenance>();
		List<HesEquipmentMaster> 		hesEqpuipmentMaster = new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentMaintenance> searchEquipmentMaintenanceList = new ArrayList<HesEquipmentMaintenance>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String date_to=null;
		
		if(searchFieldMap.get("toDate")!=null){
			toDate= (String)searchFieldMap.get("toDate");
		}
		if(searchFieldMap.get("searchEquipmentName")!=null){
			equipmentName= (Integer)searchFieldMap.get("searchEquipmentName");
		}
		
		if(searchFieldMap.get("searchEntryNo")!=null){
			searchEntryNo= (Integer)searchFieldMap.get("searchEntryNo");
		}
		entryNoList=getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaintenance");
	    hesEqpuipmentMaster=getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster");
	    searchEquipmentMaintenanceList=getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaintenance");
  	   for (Iterator iterator = searchEquipmentMaintenanceList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
       }
		map.put("searchEquipmentMaintenanceList", searchEquipmentMaintenanceList);
		map.put("entryNoList", entryNoList);
		map.put("hesEqpuipmentMaster", hesEqpuipmentMaster);
		return map;
	}
   
   
//////////////////Code for show Equipment call log Entry/////////////////
	
	public Map<String, Object> showEquipmentCallLogEntryJsp(Map<String, Object> showMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List departmentList = new ArrayList();
		List employeeList = new ArrayList();
		List<HesEquipmentMaster> hesEqpMaster = new ArrayList<HesEquipmentMaster>(); 
		List<HesEquipmentCallLogEntry> callLogEntryList = new ArrayList<HesEquipmentCallLogEntry>();
		String entryNo = "";
		String num="";
		int hospitalId=0;
      
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try{
			hospitalId=(Integer) showMap.get("hospitalId");
			hesEqpMaster=getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster as hem where hem.Status='y'"
					+" and hem.Hospital.Id ="
					+ hospitalId
					+ "order by hem.Id desc");
			callLogEntryList = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentCallLogEntry as hes where hes.Status='y'"
					+" and hes.Hospital.Id ="
					+ hospitalId 
					+" order by hes.Id desc");
	    	if(callLogEntryList.size()>0){
	    		HesEquipmentCallLogEntry callLogEntryObj = new HesEquipmentCallLogEntry();
	    		callLogEntryObj=callLogEntryList.get(0);
	    		entryNo=callLogEntryObj.getEntryNo();
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	else{
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	departmentList = hbt.find("from jkt.hms.masters.business.MasDepartment as m where m.Status = 'Y'");
			employeeList = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Title!=5 and me.Status = 'Y'" 
					+ " and me.Hospital.Id="
					+ hospitalId);
			map.put("num", num);
			map.put("departmentList", departmentList);
			map.put("employeeList", employeeList);
			map.put("hesEqpMaster", hesEqpMaster);
			map.put("callLogEntryList", callLogEntryList);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return map;
		}
	
	 public Map<String,Object> submitEquipmentCallLogEntryJsp(Map<String, Object> dataMap){

			Map<String, Object> map = new HashMap<String, Object>();   
		      
			List<HesEquipmentMaster> hesEqupmentList = new ArrayList<HesEquipmentMaster>(); 
			HesEquipmentCallLogEntry hesEquipmentCallLog = new HesEquipmentCallLogEntry();
			boolean saved = false;
			String entryNo="";
			String num="";
			int hospitalId=0;

			if(dataMap.get("hesEqpCall")!=null || dataMap.get("hesEqpCall")!=""){
				hesEquipmentCallLog=(HesEquipmentCallLogEntry)dataMap.get("hesEqpCall");
			}
			dataMap.put("hesEquipmentCallLog", hesEquipmentCallLog);

		    HibernateTemplate hbt = getHibernateTemplate();
		    hbt.setFlushModeName("FLUSH_EAGER");
		    hbt.setCheckWriteOperations(false);
		    	try{
		    		hospitalId=	(Integer)dataMap.get("hospitalId");	    		
		    		hesEqupmentList = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster as hem where hem.Hospital.Id="
		    				+hospitalId);
			    	if(hesEqupmentList.size()>0){
			    		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
			    		hesEquipmentMaster=hesEqupmentList.get(0);
			    		entryNo=hesEquipmentMaster.getEntryNo();
			    		num=getMaxEquipmentDate(entryNo);
			    	}
			    	else{
			    		num=getMaxEquipmentDate(entryNo);
			    	}
		    	 
		    	hbt.save(hesEquipmentCallLog);
		    }
		    catch (Exception e) {
				e.printStackTrace();
			}
		        return dataMap;	
		}
   
	 
	 
//////////////////Code for show Equipment breakdown Entry/////////////////
		
		
		
		public Map<String, Object> showEquipmentBreakdownEntryJsp(Map<String, Object> showMap)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			List employeeListTo = new ArrayList();
			List employeeListFrom = new ArrayList();
			List<HesEquipmentBreakdownEntry> hesEqpMaster = new ArrayList<HesEquipmentBreakdownEntry>(); 
			List<HesEquipmentMaster> eqpMasterList = new ArrayList<HesEquipmentMaster>();
			String entryNo = "";
			String num="";
			int hospitalId=0;
	      
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			try{
				hospitalId=(Integer) showMap.get("hospitalId");
				hesEqpMaster = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentBreakdownEntry as heb  where heb.Hospital.Id = "+ hospitalId
						+" order by heb.Id desc");
		    	
		    	if(hesEqpMaster.size()>0){
		    		HesEquipmentBreakdownEntry hesEquipmentMaster=new HesEquipmentBreakdownEntry();
		    		hesEquipmentMaster=hesEqpMaster.get(0);
		    		entryNo=hesEquipmentMaster.getEntryNo();
		    		num=getMaxEquipmentDate(entryNo);
		    	}
		    	else{
		    		num=getMaxEquipmentDate(entryNo);
		    	}
				employeeListTo = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Title!=5 and me.Status = 'y' and me.Hospital.Id="+hospitalId);
				employeeListFrom = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Title!=5 and me.Status = 'y' and me.Hospital.Id="+hospitalId);
				eqpMasterList=hbt.find("from jkt.hms.masters.business.HesEquipmentMaster as he where he.Status='y' and he.Hospital.Id="+ hospitalId +"order by he.Id desc");
				map.put("num", num);
				map.put("employeeListTo", employeeListTo);
				map.put("employeeListFrom", employeeListFrom);
				map.put("eqpMasterList", eqpMasterList);
				map.put("hesEqpMaster", hesEqpMaster);
			}
			catch (DataAccessException e)
			{
				e.printStackTrace();
			}
			return map;
			}
	   
	   
		public Map<String,Object> submitEquipmentBreakdownEntryJsp(Map<String, Object> dataMap){

			Map<String, Object> map = new HashMap<String, Object>();   
			List<HesEquipmentBreakdownEntry> hesEqupmentList = new ArrayList<HesEquipmentBreakdownEntry>();
			HesEquipmentBreakdownEntry hesEquipmentBreakEntry = new HesEquipmentBreakdownEntry();
			boolean saved = false;
			String entryNo="";
			String num="";
			int hospitalId=0;
			if(dataMap.get("masterBreakdown")!=null || dataMap.get("masterBreakdown")!=""){
				hesEquipmentBreakEntry=(HesEquipmentBreakdownEntry)dataMap.get("masterBreakdown");
			}
		    HibernateTemplate hbt = getHibernateTemplate();
		    hbt.setFlushModeName("FLUSH_EAGER");
		    hbt.setCheckWriteOperations(false);
		    	try{
		    		
		    		hesEquipmentBreakEntry=(HesEquipmentBreakdownEntry)dataMap.get("masterBreakdown");
		    		MasHospital masHospital =new MasHospital();
		    		masHospital=hesEquipmentBreakEntry.getHospital();
		    		hospitalId=masHospital.getId();
		    		
		    		hesEqupmentList = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentBreakdownEntry as heb where heb.Hospital.Id="+hospitalId);
			    	if(hesEqupmentList.size()>0){
			    		HesEquipmentBreakdownEntry hesEquipmentMaster=new HesEquipmentBreakdownEntry();
			    		hesEquipmentMaster=hesEqupmentList.get(0);
			    		entryNo=hesEquipmentMaster.getEntryNo();
			    		num=getMaxEquipmentDate(entryNo);
			    	}
			    	else{
			    		num=getMaxEquipmentDate(entryNo);
			    	}
		    	hbt.save(hesEquipmentBreakEntry);
		    }
		    catch (Exception e) {
				e.printStackTrace();
			}
		        return dataMap;	
		}

		public Map<String, Object> searchEquipmentBreakdownForm(Map<String, Object> searchFieldMap)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			String toDate = "";
			String searchEquipmentName = null;
			String searchEntryNoId = null;
			StringBuffer sb = new StringBuffer();
			List searchList = new ArrayList();
			Date date4MySQL2 = null;
			String outFormat = null;
			if (searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")) 
			{
				toDate = (String)searchFieldMap.get("toDate");
				SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd");
				try
				{
					outFormat = outFmt.format(inFmt.parse(toDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
            if (searchFieldMap.get("searchEquipmentName") != null) 
			{
				searchEquipmentName = (String)searchFieldMap.get("searchEquipmentName");
			}
			if (searchFieldMap.get("searchEntryNoId") != null) 
			{
				searchEntryNoId = (String)searchFieldMap.get("searchEntryNoId");
			}
			String query="";
            if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEquipmentName") != null)
            		&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EquipmentMaster.Id="+searchEquipmentName+" and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEquipmentName") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EquipmentMaster.Id="+searchEquipmentName;
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("searchEquipmentName") != null)&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.EquipmentMaster.Id="+searchEquipmentName+" and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")))
            {
            	query+="hebe.Date='"+outFormat+"'";
            }else if((searchFieldMap.get("searchEquipmentName") != null))
            {
            	query+="hebe.EquipmentMaster.Id="+searchEquipmentName;
            }else if(searchFieldMap.get("searchEntryNoId") != null)
            {
            	query+=" hebe.EntryNo='"+searchEntryNoId+"'";
            }
			try
			{
				String finalQuery="select hebe from HesEquipmentBreakdownEntry hebe where "+query;
				searchList=session.createQuery(finalQuery).list();
				map.put("searchList", searchList);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return map;
		}
		

		public Map<String, Object> searchEquipmentCallLogEntryForm(Map<String, Object> searchFieldMap)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			String toDate = "";
			String searchEquipmentName = null;
			String searchEntryNoId = null;
			StringBuffer sb = new StringBuffer();
			List searchList = new ArrayList();
			Date date4MySQL2 = null;
			String outFormat = null;
			if (searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")) 
			{
				toDate = (String)searchFieldMap.get("toDate");
				SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd");
				try
				{
					outFormat = outFmt.format(inFmt.parse(toDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
            if (searchFieldMap.get("searchEquipmentName") != null) 
			{
				searchEquipmentName = (String)searchFieldMap.get("searchEquipmentName");
			}

			if (searchFieldMap.get("searchEntryNoId") != null) 
			{
				searchEntryNoId = (String)searchFieldMap.get("searchEntryNoId");
			}
			String query="";
            if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEquipmentName") != null)
            		&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EquipmentMaster.Id="+searchEquipmentName+" and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEquipmentName") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EquipmentMaster.Id="+searchEquipmentName;
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("searchEquipmentName") != null)&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.EquipmentMaster.Id="+searchEquipmentName+" and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")))
            {
            	query+="hebe.Date='"+outFormat+"'";
            }else if((searchFieldMap.get("searchEquipmentName") != null))
            {
            	query+="hebe.EquipmentMaster.Id="+searchEquipmentName;
            }else if(searchFieldMap.get("searchEntryNoId") != null)
            {
            	query+=" hebe.EntryNo='"+searchEntryNoId+"'";
            }
            
			try
			{
				String finalQuery="select hebe from HesEquipmentCallLogEntry hebe where "+query;
				searchList=session.createQuery(finalQuery).list();
				map.put("searchList", searchList);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return map;
		}
		
		public Map<String, Object> searchEquipmentMaintenanceForm(Map<String, Object> searchFieldMap)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			String toDate = "";
			String searchEquipmentName = null;
			String searchEntryNoId = null;
			StringBuffer sb = new StringBuffer();
			List searchList = new ArrayList();
			Date date4MySQL2 = null;
			String outFormat = null;
			if (searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")) 
			{
				toDate = (String)searchFieldMap.get("toDate");
				SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd");
				try
				{
					outFormat = outFmt.format(inFmt.parse(toDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
            if (searchFieldMap.get("searchEquipmentName") != null) 
			{
				searchEquipmentName = (String)searchFieldMap.get("searchEquipmentName");
			}
			if (searchFieldMap.get("searchEntryNoId") != null) 
			{
				searchEntryNoId = (String)searchFieldMap.get("searchEntryNoId");
			}
			String query="";
            if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEquipmentName") != null)
            		&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EquipmentMaster.Id="+searchEquipmentName+" and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEquipmentName") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EquipmentMaster.Id="+searchEquipmentName;
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals(""))&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.Date='"+outFormat+"' and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("searchEquipmentName") != null)&&(searchFieldMap.get("searchEntryNoId") != null))
            {
            	query+="hebe.EquipmentMaster.Id="+searchEquipmentName+" and hebe.EntryNo='"+searchEntryNoId+"'";
            }else if((searchFieldMap.get("toDate") != null && !searchFieldMap.get("toDate").equals("")))
            {
            	query+="hebe.Date='"+outFormat+"'";
            }else if((searchFieldMap.get("searchEquipmentName") != null))
            {
            	query+="hebe.EquipmentMaster.Id="+searchEquipmentName;
            }else if(searchFieldMap.get("searchEntryNoId") != null)
            {
            	query+=" hebe.EntryNo='"+searchEntryNoId+"'";
            }
			try
			{
				String finalQuery="select hebe from HesEquipmentMaintenance hebe where "+query;
				searchList=session.createQuery(finalQuery).list();
				map.put("searchList", searchList);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return map;
		}
		
		public boolean modifyEquipmentBreakdown(Map<String, Object> generalMap) {

			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			int deptId = 0;
			String url = "";
			int equipmentId=0;
			int employeeIdTo=0;
			int employeeIdFrom=0;
			String remarks="";
			Date date1 = new Date();
			String date = "";
			String natureOfBreakdown="";
			String message = null;
			String lastChangedTime="";
		    Date changedDate= new Date();
		    String userName="";
		    int radio_str=0;
		    date1=(Date)generalMap.put("date1", date1);
			deptId=(Integer) generalMap.get("deptId");
			equipmentId=(Integer)generalMap.get("equipmentId");
			employeeIdTo=(Integer)generalMap.get("employeeIdTo");    
			natureOfBreakdown=(String)generalMap.get("natureOfBreakdown"); 
			remarks=(String)generalMap.get("remarks");
			userName=(String)generalMap.get("userName");
			changedDate=(Date)generalMap.get("changedDate");
			radio_str=(Integer)generalMap.get("radio_str");
		    HesEquipmentBreakdownEntry masCountry = (HesEquipmentBreakdownEntry) getHibernateTemplate().get( HesEquipmentBreakdownEntry.class, radio_str);
			masCountry.setId(radio_str);
			masCountry.setDate(date1);
			HesEquipmentMaster master=new HesEquipmentMaster();
			master.setId(equipmentId);
			masCountry.setEquipment(master);
			MasEmployee masEmployeeTo = new MasEmployee();
		    masEmployeeTo.setId(employeeIdTo);
		    masCountry.setEmployeeIdTo(masEmployeeTo);
		    masCountry.setNatureOfBreakdown(natureOfBreakdown);	 
		    masCountry.setRemarks(remarks);
		    masCountry.setStatus("n");
			masCountry.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masCountry);
			dataUpdated = true;
			return dataUpdated;		
		
		}	
		
		
		public boolean modifyCallLogEntry(Map<String, Object> generalMap) {

			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			int deptId = 0;
			String url = "";
			int equipmentId=0;
			int employeeIdTo=0;
			String remarks="";
			Date date1 = new Date();
			String date = "";
			String message = null;
			String lastChangedTime="";
		    Date changedDate= new Date();
		    String userName="";
		    int radio_str=0;
		    date1=(Date)generalMap.put("date1", date1);
			deptId=(Integer) generalMap.get("deptId");
			equipmentId=(Integer)generalMap.get("equipmentId");
			employeeIdTo=(Integer)generalMap.get("employeeIdTo");    
			remarks=(String)generalMap.get("remarks");
			userName=(String)generalMap.get("userName");
			changedDate=(Date)generalMap.get("changedDate");
			radio_str=(Integer)generalMap.get("radio_str");
		    HesEquipmentCallLogEntry masCountry = (HesEquipmentCallLogEntry) getHibernateTemplate().get( HesEquipmentCallLogEntry.class, radio_str);
		  //commented for maven
		   /* masCountry.setId(radio_str);*/
			masCountry.setDate(date1);
			HesEquipmentMaster master=new HesEquipmentMaster();
			master.setId(equipmentId);
			masCountry.setEquipment(master);
			MasEmployee masEmployeeTo = new MasEmployee();
		    masEmployeeTo.setId(employeeIdTo);
		    masCountry.setEmployee(masEmployeeTo);
		    masCountry.setRemarks(remarks);
		    masCountry.setStatus("y");
			masCountry.setLastChgTime(currentTime);
			Users users=new Users();
			//commented for maven
			/*users.setLastChgBy(userName);*/
			masCountry.setLastChgBy(users);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masCountry);
			dataUpdated = true;
			return dataUpdated;		
		}
		public boolean modifyMaintenanceEntry(Map<String, Object> generalMap) {

			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			int deptId = 0;
			int equipmentId=0;
			int employeeIdTo=0;
			int jobMaintenanceId = 0;
			Date date1 = new Date();
			String date = "";
			String message = null;
			String lastChangedTime="";
		    Date changedDate= new Date();
		    String userName="";
		    int radio_str=0;
		    date1=(Date)generalMap.put("date1", date1);
			deptId=(Integer) generalMap.get("deptId");
			equipmentId=(Integer)generalMap.get("equipmentId");
			employeeIdTo=(Integer)generalMap.get("employeeIdTo");
			jobMaintenanceId = (Integer)generalMap.get("jobMaintenanceId");
			userName=(String)generalMap.get("userName");
			changedDate=(Date)generalMap.get("changedDate");
			radio_str=(Integer)generalMap.get("radio_str");
		    HesEquipmentMaintenance equpMaintenance = (HesEquipmentMaintenance) getHibernateTemplate().get(HesEquipmentMaintenance.class, radio_str);
		    equpMaintenance.setId(radio_str);
		    equpMaintenance.setDate(date1);
			HesEquipmentMaster master=new HesEquipmentMaster();
			master.setId(equipmentId);
			equpMaintenance.setEquipment(master);
			MasEmployee masEmployeeTo = new MasEmployee();
		    masEmployeeTo.setId(employeeIdTo);
		    equpMaintenance.setEmployee(masEmployeeTo);
		    equpMaintenance.setStatus("y");
		    HesMaintenanceJobMaster hesMaintenanceObj = new HesMaintenanceJobMaster();
		    hesMaintenanceObj.setId(jobMaintenanceId);
		    equpMaintenance.setMaintenance(hesMaintenanceObj);
		    equpMaintenance.setLastChgTime(currentTime);
		    Users users=new Users();
		  //commented for maven
		    /*users.setLastChgBy(userName);*/
		    equpMaintenance.setLastChgBy(users);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(equpMaintenance);
			dataUpdated = true;
			return dataUpdated;		
		
		}

		public Map<String,Object> submitEmergencyEquipmentBreakdownEntryJsp(Map<String, Object> dataMap){

			Map<String, Object> map = new HashMap<String, Object>();   
			List<HesEquipmentMaster> hesEqupmentList = new ArrayList<HesEquipmentMaster>(); 
			HesEmergencyEquipmentBreakdown hesEmergencyEquipmentBreakEntry = new HesEmergencyEquipmentBreakdown();
			boolean saved = false;
			String entryNo="";
			String num="";
			if(dataMap.get("masterEmpergencyBreakdown")!=null || dataMap.get("masterEmpergencyBreakdown")!=""){
				hesEmergencyEquipmentBreakEntry=(HesEmergencyEquipmentBreakdown)dataMap.get("masterEmpergencyBreakdown");
			}
		    HibernateTemplate hbt = getHibernateTemplate();
		    hbt.setFlushModeName("FLUSH_EAGER");
		    hbt.setCheckWriteOperations(false);
		    	try{
		    		hesEqupmentList = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaster as hes where hes.Status='y' order by hes.Id desc");
			    	if(hesEqupmentList.size()>0){
			    		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
			    		hesEquipmentMaster=hesEqupmentList.get(0);
			    		entryNo=hesEquipmentMaster.getEntryNo();
			    		num=getMaxEquipmentDate(entryNo);
			    	}
			    	else{
			    		num=getMaxEquipmentDate(entryNo);
			    	}
		    	hbt.save(hesEmergencyEquipmentBreakEntry);
		    }
		    catch (Exception e) {
				e.printStackTrace();
			}
		        return dataMap;	
		}
		
		
//////////////////Code for show Equipment breakdown Entry/////////////////
		
		public Map<String, Object> showEmergencyEquipmentBreakdownCallEntry(Map<String, Object> showMap)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			List<HesEquipmentBreakdownEntry> searchCountryList = new ArrayList<HesEquipmentBreakdownEntry>();
			searchCountryList=getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentBreakdownEntry");
			map.put("searchCountryList", searchCountryList);
			List<HesEquipmentEmergencyMaintenanceBreakdown> eqpMaintenacneMaster = new ArrayList<HesEquipmentEmergencyMaintenanceBreakdown>(); 
			String entryNo = "";
			String num="";
			int hospitalId=0;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			try{
				//hospitalId=(Integer) showMap.get(hospitalId);
				eqpMaintenacneMaster = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown as hes where hes.Status='y' order by hes.Id desc");
		    	if(eqpMaintenacneMaster.size()>0){
		    		HesEquipmentEmergencyMaintenanceBreakdown hesEquipmentMaster=new HesEquipmentEmergencyMaintenanceBreakdown();
		    		hesEquipmentMaster=eqpMaintenacneMaster.get(0);
		    		entryNo=hesEquipmentMaster.getEntryNo();
		    		num=getMaxEquipmentDate(entryNo);
		    	}
		    	else{
		    		num=getMaxEquipmentDate(entryNo);
		    	}			
				map.put("num", num);
			}
			catch (DataAccessException e)
			{
				e.printStackTrace();
			}
			return map;
		}
		
		public Map<String, Object> searchEmergencyEquipmentBreakdown(String departmentName)
		{
			Map<String, Object> map = new HashMap<String, Object>(); 
			List< HesEquipmentBreakdownEntry> searchCountryList = new ArrayList<HesEquipmentBreakdownEntry>();
			Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
			Session session = (Session) getSession();
			List<HesEquipmentEmergencyMaintenanceBreakdown> eqpMaintenacneMaster = new ArrayList<HesEquipmentEmergencyMaintenanceBreakdown>(); 
			String entryNo = "";
			String num="";
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			try
			{
				if ((departmentName != null) || (departmentName == null))
				{
					searchCountryList=session.createCriteria(HesEquipmentBreakdownEntry.class).createAlias("Department", "dept")
					.add(Restrictions.like("dept.DepartmentName", departmentName)).list();
				}
				eqpMaintenacneMaster = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown as hes where hes.Status='y' order by hes.Id desc");
		    	if(eqpMaintenacneMaster.size()>0){
		    		HesEquipmentEmergencyMaintenanceBreakdown hesEquipmentMaster=new HesEquipmentEmergencyMaintenanceBreakdown();
		    		hesEquipmentMaster=eqpMaintenacneMaster.get(0);
		    		entryNo=hesEquipmentMaster.getEntryNo();
		    		num=getMaxEquipmentDate(entryNo);
		    	}
		    	else{
		    		num=getMaxEquipmentDate(entryNo);
		    	}			
				
			}
			catch (Exception e)
			{
					e.printStackTrace();			}
					countryFieldsMap.put("num", num);
					countryFieldsMap.put("searchCountryList", searchCountryList);
					return countryFieldsMap;
		}
		
		public boolean addEquipmentBreakdownEntry(HesEquipmentEmergencyMaintenanceBreakdown master , int equipmentBreakdownId)
		{	
			boolean successfullyAdded = false;
			int equipmentBreakId= 0;
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(master);
				HesEquipmentBreakdownEntry equpBreakdownEntry = new HesEquipmentBreakdownEntry();
				equpBreakdownEntry = (HesEquipmentBreakdownEntry)hbt.load(HesEquipmentBreakdownEntry.class, equipmentBreakdownId);
				equpBreakdownEntry.setStatus("y");
				hbt.update(equpBreakdownEntry);
				successfullyAdded = true;
			} catch (Exception e) {
				e.printStackTrace();
				successfullyAdded = false;
			}
			return successfullyAdded;
		}
		
		public boolean editEquipmentBreakdownEntryInEmergency(Map<String, Object> generalMap)
		{
			boolean dataUpdated = false;
			Date currentDate = null;
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			String cylinderName = "";
			int empergencyEquipmentId = 0;
			String changedBy = "";
			currentDate = new Date();
			empergencyEquipmentId = (Integer) generalMap.get("id");
			cylinderName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			HesEquipmentEmergencyMaintenanceBreakdown master = (HesEquipmentEmergencyMaintenanceBreakdown) getHibernateTemplate().get(HesEquipmentEmergencyMaintenanceBreakdown.class, empergencyEquipmentId);
			master.setId(empergencyEquipmentId);
			master.setLastChgBy(changedBy);
			master.setLastChgDate(currentDate);
			master.setLastChgTime(currentTime);
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
				dataUpdated = false;
				e.printStackTrace();
			}
			return dataUpdated;
		}
		
		
		
		public boolean deleteEmergencyEquipmentBreakdown(int equipmentBreakId,Map<String, Object> generalMap)
		{
			boolean dataDeleted = false;
			String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			HesEquipmentBreakdownEntry master = (HesEquipmentBreakdownEntry) getHibernateTemplate().get(HesEquipmentBreakdownEntry.class, equipmentBreakId);
			if (generalMap.get("flag") != null) 
			{
				String flag = (String) generalMap.get("flag");
				if (flag.equals("Pending")) 
				{
					master.setStatus("n");
					dataDeleted = true;
				}
				else if (flag.equals("Completed"))
				{
					 master.setStatus("y");
					 dataDeleted = false;
				}
			}
			master.setId(equipmentBreakId);
			Users users=new Users();
			//commented for maven
			/*users.setLastChgBy(changedBy);*/
			master.setLastChgBy(users);
			master.setLastChgDate(currentDate);
			master.setLastChgTime(currentTime);
			try
			{
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(master);
			}
			catch (DataAccessException e)
			{
				e.printStackTrace();
			}

			return dataDeleted;
		}

   
	//////////////////////////////////Code for Communication///////////////////////////////////////////
	
	public Map<String, Object> showCommunicationJsp(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<CommunicationMessages> communicationMessagesList=new ArrayList<CommunicationMessages>();
		List<CommunicationMessages> communicationMessagesSentList=new ArrayList<CommunicationMessages>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int empId=0;
		if(dataMap.get("empId")!=null){
			empId=(Integer)dataMap.get("empId");
		}
		Session session =(Session)getSession();
		try{
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			masEmployeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as me where me.Status='y' order by me.FirstName,me.LastName");
			map.put("masEmployeeList", masEmployeeList);
			communicationMessagesList=session.createCriteria(CommunicationMessages.class).createAlias("ToEmployee", "toEmp").add(Restrictions.eq("toEmp.Id", empId)).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("MessageDate", HMSUtil.convertStringTypeDateToDateType(currentDate))).addOrder(Order.desc("Id")).list();
			communicationMessagesSentList=session.createCriteria(CommunicationMessages.class).createAlias("FromEmployee", "fromEmp").add(Restrictions.eq("fromEmp.Id", empId)).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("MessageDate", HMSUtil.convertStringTypeDateToDateType(currentDate))).addOrder(Order.desc("Id")).list();
			map.put("communicationMessagesList", communicationMessagesList);
			map.put("communicationMessagesSentList", communicationMessagesSentList);
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object> submitCommunicationMessageJsp(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		int empSessionId=0;
		if(dataMap.get("empId")!=null){
			empSessionId=(Integer)dataMap.get("empId");
		}
		 String[] toEmpIdArray = null;
		 if(dataMap.get("toEmpIdArray")!=null){
			 toEmpIdArray=(String[])dataMap.get("toEmpIdArray");
			}
		 List<CommunicationMessages> commMsgList = new ArrayList<CommunicationMessages>();
		 if(dataMap.get("commMsgList")!=null){
			 commMsgList=(List<CommunicationMessages>)dataMap.get("commMsgList");
			}
		Session session =(Session)getSession();
		try{
			masEmployeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as me where me.Status='y'order by me.FirstName,me.LastName");
			map.put("masEmployeeList", masEmployeeList);
			boolean checkedAllFlag=false;
			if(dataMap.get("checkedAllFlag")!=null){
				checkedAllFlag=(Boolean)dataMap.get("checkedAllFlag");
			}
			if(commMsgList.size()>0){
				for (CommunicationMessages communicationMessages : commMsgList) {
					session.save(communicationMessages);
				}
			}	
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");
			List<CommunicationMessages> communicationMessagesList=new ArrayList<CommunicationMessages>();
			List<CommunicationMessages> communicationMessagesSentList=new ArrayList<CommunicationMessages>();
			communicationMessagesList=session.createCriteria(CommunicationMessages.class).createAlias("ToEmployee", "toEmp").add(Restrictions.eq("toEmp.Id", empSessionId)).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("MessageDate",HMSUtil.convertStringTypeDateToDateType(currentDate))).addOrder(Order.desc("Id")).list();
			communicationMessagesSentList=session.createCriteria(CommunicationMessages.class).createAlias("FromEmployee", "fromEmp").add(Restrictions.eq("fromEmp.Id", empSessionId)).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("MessageDate", HMSUtil.convertStringTypeDateToDateType(currentDate))).addOrder(Order.desc("Id")).list();
			map.put("communicationMessagesList", communicationMessagesList);
			map.put("communicationMessagesSentList", communicationMessagesSentList);
					
					}catch (DataAccessException e)
					{
						e.printStackTrace();
					}
					return map;
	}

	@Override
	public Map<String, Object> showEquipmentBreakdownUpdateJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List departmentList = new ArrayList();
		List employeeListTo = new ArrayList();
		List employeeListFrom = new ArrayList();
		List<HesEquipmentBreakdownEntry> hesEqpMaster = new ArrayList<HesEquipmentBreakdownEntry>(); 
		List<HesEquipmentMaster> eqpMasterList = new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentBreakdownEntry> searchList = new ArrayList<HesEquipmentBreakdownEntry>();
		Session session =(Session)getSession(); 
		String entryNo = "";
		String num="";
		int radio_str = 0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		try{
			hesEqpMaster = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentBreakdownEntry");
	    	if(hesEqpMaster.size()>0){
	    		HesEquipmentBreakdownEntry hesEquipmentMaster=new HesEquipmentBreakdownEntry();
	    		hesEquipmentMaster=hesEqpMaster.get(0);
	    		entryNo=hesEquipmentMaster.getEntryNo();
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	else{
	    		num=getMaxEquipmentDate(entryNo);
	    	}
			employeeListTo = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Title!=5 and me.Status = 'y'");
			employeeListFrom = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Title!=5 and me.Status = 'y'");
			eqpMasterList=hbt.find("from jkt.hms.masters.business.HesEquipmentMaster as he where he.Status='y' order by he.Id desc");
	    	radio_str=(Integer)dataMap.get("radio_str");
	    	searchList= session.createCriteria(HesEquipmentBreakdownEntry.class).add(Restrictions.like("Id", radio_str)).list();
			map.put("searchList", searchList);
			map.put("num", num);
			map.put("employeeListTo", employeeListTo);
			map.put("employeeListFrom", employeeListFrom);
			map.put("eqpMasterList", eqpMasterList);
			map.put("hesEqpMaster", hesEqpMaster);	
			}
				catch (DataAccessException e)
				{
					e.printStackTrace();
				}
				return map;
		}
	
	
	public Map<String, Object> showEquipmentCallLogUpdateJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List departmentList = new ArrayList();
		List employeeListTo = new ArrayList();
		List employeeListFrom = new ArrayList();
		List<HesEquipmentCallLogEntry> hesEqpMaster = new ArrayList<HesEquipmentCallLogEntry>(); 
		List<HesEquipmentMaster> equipmentList = new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentCallLogEntry> searchList = new ArrayList<HesEquipmentCallLogEntry>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session =(Session)getSession(); 
		String entryNo = "";
		String num="";
		int radio_str = 0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		try{
			hesEqpMaster = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentCallLogEntry");
	    	if(hesEqpMaster.size()>0){
	    		HesEquipmentCallLogEntry hesEquipmentMaster=new HesEquipmentCallLogEntry();
	    		hesEquipmentMaster=hesEqpMaster.get(0);
	    		entryNo=hesEquipmentMaster.getEntryNo();
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	else{
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	departmentList = hbt.find("from jkt.hms.masters.business.MasDepartment as m where m.Status = 'y'");
			employeeListTo = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Title!=5 and me.Status = 'y'");
			//employeeListFrom = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Title!=5 and me.Status = 'y'");
			equipmentList=hbt.find("from jkt.hms.masters.business.HesEquipmentMaster as he where he.Status='y' order by he.Id desc");
	    	radio_str=(Integer)dataMap.get("radio_str");
	    	
	    	searchList= session.createCriteria(HesEquipmentCallLogEntry.class).add(Restrictions.like("Id", radio_str)).list();
			map.put("searchList", searchList);
			map.put("num", num);
			map.put("departmentList", departmentList);
			map.put("employeeListTo", employeeListTo);
			map.put("equipmentList", equipmentList);
			map.put("hesEqpMaster", hesEqpMaster);	
	}
	catch (DataAccessException e)
	{
		e.printStackTrace();
	}
	return map;
	}

	
	public Map<String, Object> showEquipmentMaintenanceUpdateJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List employeeListTo = new ArrayList();
		List<HesEquipmentMaintenance> hesEqpMaster = new ArrayList<HesEquipmentMaintenance>(); 
		List<HesEquipmentMaster> equipmentList = new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentMaintenance> searchList = new ArrayList<HesEquipmentMaintenance>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HesMaintenanceJobMaster> jobMaintenanceList = new ArrayList<HesMaintenanceJobMaster>();
		Session session =(Session)getSession(); 
		String entryNo = "";
		String num="";
		int radio_str = 0;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		try{
			hesEqpMaster = getHibernateTemplate().find("from jkt.hms.masters.business.HesEquipmentMaintenance");
	    	if(hesEqpMaster.size()>0){
	    		HesEquipmentMaintenance hesEquipmentMaster=new HesEquipmentMaintenance();
	    		hesEquipmentMaster=hesEqpMaster.get(0);
	    		entryNo=hesEquipmentMaster.getEntryNo();
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	else{
	    		num=getMaxEquipmentDate(entryNo);
	    	}
	    	jobMaintenanceList = hbt.find("from jkt.hms.masters.business.HesMaintenanceJobMaster as jm  where jm.Status = 'y'");
	    	departmentList = hbt.find("from jkt.hms.masters.business.MasDepartment as m where m.Status = 'y'");
			employeeListTo = hbt.find("from jkt.hms.masters.business.MasEmployee as me where me.Title!=5 and me.Status = 'y'");
			equipmentList=hbt.find("from jkt.hms.masters.business.HesEquipmentMaster as he where he.Status='y' order by he.Id desc");
	    	radio_str=(Integer)dataMap.get("radio_str");
	    	searchList= session.createCriteria(HesEquipmentMaintenance.class).add(Restrictions.like("Id", radio_str)).list();
			map.put("searchList", searchList);
			map.put("num", num);
			map.put("jobMaintenanceList", jobMaintenanceList);
			map.put("departmentList", departmentList);
			map.put("employeeListTo", employeeListTo);
			map.put("equipmentList", equipmentList);
			map.put("hesEqpMaster", hesEqpMaster);	
	}
	catch (DataAccessException e)
	{
		e.printStackTrace();
	}
	return map;
	}
	
	
	public Map<String, Object> showEquipmentAmcDetails(Map<String, Object> searchFieldMap)
	{ 
		Session session = (Session)getSession();  
		Map<String, Object> map = new HashMap<String, Object>();
		List<HesEquipmentMaster> equipmentMasList = new ArrayList<HesEquipmentMaster>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreSupplierGroup> supplierGroupList = new ArrayList<MasStoreSupplierGroup>();
		List<HesEquipmentAmcDetailsEntry> amcDetailsList = new ArrayList<HesEquipmentAmcDetailsEntry>();
		HibernateTemplate hbt = getHibernateTemplate();
		int hospitalId=0;
		try {
			hospitalId=(Integer) searchFieldMap.get("hospitalId");
			departmentList = hbt.find("from jkt.hms.masters.business.MasDepartment as dept where dept.Status='Y' ");
			equipmentMasList=hbt.find("from jkt.hms.masters.business.HesEquipmentMaster as equpM where equpM.Status='y' and equpM.Hospital.Id="+hospitalId + "order by equpM.Id desc");
			amcDetailsList = hbt.find("from jkt.hms.masters.business.HesEquipmentAmcDetailsEntry as ead where ead.Status='y' and ead.Hospital.Id="+hospitalId);
			supplierGroupList =hbt.find("from jkt.hms.masters.business.MasStoreSupplierGroup as mssg where mssg.Group.GroupName='Equipment'");
			//supplierGroupList=session.createCriteria(MasStoreSupplierGroup.class).add(Restrictions.like("", ));
			map.put("departmentList", departmentList);
			map.put("equipmentMasList", equipmentMasList);
			map.put("supplierGroupList", supplierGroupList);
			map.put("amcDetailsList", amcDetailsList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 
		return map;
	}
	
	 
	public Map<String, Object> showEquipmentMasterModify(Map<String, Object> searchFieldMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<HesEquipmentMaster> hesEquipmentMasterList = new ArrayList<HesEquipmentMaster>();
		List<Object> assessoryList = new ArrayList<Object>();
		for (Iterator iterator = assessoryList.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
		}
		int radioId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String query="";
		try
		{	
			/*assessoryList = hbt.find("select hea , em from jkt.hms.masters.business.HesEquipmentAssessories as hea join  hea.EquipmentMaster em where hea.Status='y'");
			for (Iterator iterator = assessoryList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
	     }*/
			radioId =(Integer)map.get("radioId");
			hesEquipmentMasterList = session.createCriteria(HesEquipmentMaster.class).add(Restrictions.like("Id",radioId )).list();
			
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		map.put("hesEquipmentMasterList",hesEquipmentMasterList);
		map.put("assessoryList", assessoryList);
		
		return map;
	}
	
	public Map<String,Object> submitEquipmentAMCDetalis(Map<String, Object> dataMap){

		Map<String, Object> map = new HashMap<String, Object>();   
		HesEquipmentAmcDetailsEntry amcDetailObject = new HesEquipmentAmcDetailsEntry();
		boolean saved = false;
		if(dataMap.get("amcDetailMaster")!=null || dataMap.get("amcDetailMaster")!=""){
			amcDetailObject=(HesEquipmentAmcDetailsEntry)dataMap.get("amcDetailMaster");
		}
	    HibernateTemplate hbt = getHibernateTemplate();
	     hbt.setFlushModeName("FLUSH_EAGER");
	     hbt.setCheckWriteOperations(false);
	    	try{
	    	    hbt.save(amcDetailObject);
	           }
	    catch (Exception e) {
			e.printStackTrace();
		}
	        return dataMap;	
	}

public Map<String,Object> getEquipmentAMCDetails(Map<String,Object> dataMap){
		
		Map<String, Object> map = new HashMap<String, Object>();
		int equipmentId =0 ;
		int hospitalId=0;
		List<HesEquipmentMaster> equipmentMasList = new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentAmcDetailsEntry> amcDetailsList = new ArrayList<HesEquipmentAmcDetailsEntry>();
		List<MasStoreSupplierGroup> masStoreSuplierGroupList = new ArrayList<MasStoreSupplierGroup>();
		if(dataMap.get("hospitalId") !=null){
			hospitalId=(Integer)dataMap.get("hospitalId");	
		}
		if(dataMap.get("equipmentId") !=null){
			equipmentId=(Integer)dataMap.get("equipmentId");	
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
			try {
				equipmentMasList=hbt.find("from jkt.hms.masters.business.HesEquipmentMaster as equpM where equpM.Status='y'and equpM.Hospital.Id=" + hospitalId +  "and equpM.Id='"+equipmentId+"'");
				amcDetailsList = hbt.find("from jkt.hms.masters.business.HesEquipmentAmcDetailsEntry as amc where amc.Status='y' and amc.Hospital.Id=" + hospitalId);
				masStoreSuplierGroupList = hbt.find("from jkt.hms.masters.business.MasStoreSupplierGroup");
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
		map.put("equipmentMasList", equipmentMasList);
		map.put("amcDetailsList", amcDetailsList);
		map.put("masStoreSuplierGroupList", masStoreSuplierGroupList);
		return map;
	}
	
}