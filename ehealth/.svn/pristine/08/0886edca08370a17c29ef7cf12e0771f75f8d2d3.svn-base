package jkt.hms.laundry.dataservice;

import static jkt.hms.util.RequestConstants.ACK_BY;
import static jkt.hms.util.RequestConstants.ACK_DATE;
import static jkt.hms.util.RequestConstants.APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.DEMAND_DATE;
import static jkt.hms.util.RequestConstants.DEMAND_NO;
import static jkt.hms.util.RequestConstants.FROM_WARD;
import static jkt.hms.util.RequestConstants.ISSUE_DEPT;
import static jkt.hms.util.RequestConstants.ISSUE_NO;
import static jkt.hms.util.RequestConstants.ITEMS_TO_BE_ADDED;
import static jkt.hms.util.RequestConstants.ITEMS_TO_BE_DELETED;
import static jkt.hms.util.RequestConstants.REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT;
import static jkt.hms.util.RequestConstants.TO_WARD;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.CarDiaryEntry;
import jkt.hms.masters.business.MachineActivity;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLaundryMachine;
import jkt.hms.masters.business.MasLinenWeight;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreInternalIndentM;
import jkt.hms.masters.business.StoreInternalIndentT;
import jkt.hms.masters.business.StoreIssueM;
import jkt.hms.masters.business.StoreIssueT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.WorkLoadEntry;
import jkt.hms.masters.business.WorkLoadEntryDetail;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PageUtil;
import jkt.hms.util.PagedArray;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LaundryDataServiceImpl extends HibernateDaoSupport implements
		LaundryDataService {

	// ---------------------------- method to get laundry machine list
	// -----------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLaundryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLaundryMachine> searchLaundryList = new ArrayList<MasLaundryMachine>();
		searchLaundryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLaundryMachine ");
		map.put("searchLaundryList", searchLaundryList);
		return map;
	}

	public boolean addLaundry(MasLaundryMachine masLaundryMachine) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masLaundryMachine);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editLaundry(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String machineName = (String) generalMap.get("machineName");

		int laundryId = 0;
		String changedBy = "";
		try {
			laundryId = (Integer) generalMap.get("id");
			machineName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
						e.printStackTrace();
		}

		MasLaundryMachine masLaundryMachine = (MasLaundryMachine) getHibernateTemplate()
				.get(MasLaundryMachine.class, laundryId);

		masLaundryMachine.setId(laundryId);
		masLaundryMachine.setMahineName(machineName);
		masLaundryMachine.setLastChgBy(changedBy);
		masLaundryMachine.setLastChgDate(currentDate);
		masLaundryMachine.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masLaundryMachine);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteLaundry(int laundryId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasLaundryMachine masLaundryMachine = new MasLaundryMachine();
		masLaundryMachine = (MasLaundryMachine) getHibernateTemplate().get(
				MasLaundryMachine.class, laundryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masLaundryMachine.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masLaundryMachine.setStatus("y");
				dataDeleted = false;
			}
		}
		masLaundryMachine.setLastChgBy(changedBy);
		masLaundryMachine.setLastChgDate(currentDate);
		masLaundryMachine.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masLaundryMachine);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchLaundry(String machineName) {
		List<MasLaundryMachine> searchLaundryList = new ArrayList<MasLaundryMachine>();
		Map<String, Object> machineFieldsMap = new HashMap<String, Object>();
		try {
			if (machineName != null) {

				searchLaundryList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasLaundryMachine imc where imc.MahineName like '"
								+ machineName + "%' order by imc.MahineName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		machineFieldsMap.put("searchLaundryList", searchLaundryList);
		return machineFieldsMap;
	}

	/**
	 * ------------------------------ method to show linen weight
	 * master----------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLinenWeightJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLinenWeight> searchLinenWeightList = new ArrayList<MasLinenWeight>();
		searchLinenWeightList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLinenWeight ");
		map.put("searchLinenWeightList", searchLinenWeightList);
		return map;
	}

	public boolean addLinenWeight(MasLinenWeight masLinen) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masLinen);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editLinenWeight(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = (String) generalMap.get("name");
		String code = (String) generalMap.get("code");
		BigDecimal weight = (BigDecimal) generalMap.get("weight");

		int linenId = 0;
		String changedBy = "";
		try {
			linenId = (Integer) generalMap.get("id");
			name = (String) generalMap.get("name");
			code = (String) generalMap.get("code");
			weight = (BigDecimal) generalMap.get("weight");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasLinenWeight masLinenWeight = (MasLinenWeight) getHibernateTemplate()
				.get(MasLinenWeight.class, linenId);

		masLinenWeight.setId(linenId);
		masLinenWeight.setItemCode(code);
		masLinenWeight.setItemName(name);
		masLinenWeight.setWeight(weight);
		masLinenWeight.setLastChgBy(changedBy);
		masLinenWeight.setLastChgDate(currentDate);
		masLinenWeight.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masLinenWeight);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteLinenWeight(int linenId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasLinenWeight masLinen = new MasLinenWeight();
		masLinen = (MasLinenWeight) getHibernateTemplate().get(
				MasLinenWeight.class, linenId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masLinen.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masLinen.setStatus("y");
				dataDeleted = false;
			}
		}
		masLinen.setLastChgBy(changedBy);
		masLinen.setLastChgDate(currentDate);
		masLinen.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masLinen);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchLinenWeight(String linenCode,
			String linenName) {
		List<MasLinenWeight> searchLinenWeightList = new ArrayList<MasLinenWeight>();
		Map<String, Object> linenFieldsMap = new HashMap<String, Object>();
		try {
			if ((linenName != null) || (linenCode == null)) {

				searchLinenWeightList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasLinenWeight imc where imc.ItemName like '"
								+ linenName + "%' order by imc.ItemName");
			} else {
				searchLinenWeightList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasLinenWeight imc where imc.ItemCode like '"
								+ linenCode + "%' order by imc.ItemCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		linenFieldsMap.put("searchLinenWeightList", searchLinenWeightList);
		return linenFieldsMap;
	}

	/**
	 * --------------------------------------method for machine activity
	 * entry------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMachineActivityEntry() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MachineActivity> machineActivityList = new ArrayList<MachineActivity>();
		List<MasLaundryMachine> laundryList = new ArrayList<MasLaundryMachine>();
		List<MasLaundryMachine> gridLaundryList = new ArrayList<MasLaundryMachine>();
		machineActivityList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MachineActivity");
		laundryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasLaundryMachine where Status='y'");
		gridLaundryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLaundryMachine as isc");
		map.put("machineActivityList", machineActivityList);
		map.put("laundryList", laundryList);
		map.put("gridLaundryList", gridLaundryList);
		return map;
	}

	/**
	 * ------------------------ method to get entry no in machine activity entry
	 * -----------------------------------
	 */

	@SuppressWarnings("unchecked")
	public String generateEntryNumber(Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<MachineActivity> seqNoList = new ArrayList<MachineActivity>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String entryNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(MachineActivity.class).list();
		if (seqNoList.size() > 0) {
			for (MachineActivity mac : seqNoList) {
				lastSeqNo = mac.getEntryNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MEN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (yearlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : yearlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) yearlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				entryNo = entryNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}

		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MachineActivity");
			tsObj.setTransactionPrefix("MEN");
			tsObj.setTransactionSequenceName("MachineEntryNo");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public String getEntryNumber(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<MachineActivity> seqNoList = new ArrayList<MachineActivity>();
		String entryNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(MachineActivity.class).list();
			if (seqNoList.size() > 0) {
				for (MachineActivity accom : seqNoList) {
					lastSeqNo = accom.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "MEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entryNo = String.valueOf(maxOrderNo + 1);
					} else {
						entryNo = String.valueOf(1);
					}
				}
			} else {
				entryNo = String.valueOf(1);
			}

			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entryNo;
	}

	public boolean addMachineActivityEntry(MachineActivity machineActivity) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(machineActivity);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unused")
	public boolean editMachineActivity(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int machineActivityId = 0;
		Date entryDate = new Date();
		Date activityDate = new Date();
		int machineName = 0;
		String timeOn = "";
		String timeOff = "";
		String totalTime = "";
		String entry = "";

		String changedBy = "";
		try {
			machineActivityId = (Integer) generalMap.get("id");
			activityDate = (Date) generalMap.get("activityDate");
			entryDate = (Date) generalMap.get("entryDate");
			machineName = (Integer) generalMap.get("machineName");
			timeOn = (String) generalMap.get("timeOn");
			timeOff = (String) generalMap.get("timeOff");
			totalTime = (String) generalMap.get("totalTime");
			currentDate = (Date) generalMap.get("currentDate");
			changedBy = (String) generalMap.get("changedBy");
			entry = (String) generalMap.get("entry");

			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MachineActivity obj = (MachineActivity) getHibernateTemplate().get(
				MachineActivity.class, machineActivityId);

		obj.setId(machineActivityId);
		obj.setEntryNo(entry);
		obj.setActivityDate(activityDate);
		obj.setEntryDate(entryDate);
		obj.setTimeOff(timeOff);
		obj.setTimeOn(timeOn);
		obj.setTotalHrs(totalTime);
		obj.setLastChgBy(changedBy);
		obj.setLastChgDate(currentDate);
		obj.setLastChgTime(currentTime);
		if (machineName != '0') {
			MasLaundryMachine maslaun = new MasLaundryMachine();
			maslaun.setId(machineName);
			obj.setMachine(maslaun);
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(obj);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteMachineActivity(int machineActivityId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MachineActivity machineActivity = new MachineActivity();
		machineActivity = (MachineActivity) getHibernateTemplate().get(
				MachineActivity.class, machineActivityId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				machineActivity.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				machineActivity.setStatus("y");
				dataDeleted = false;
			}
		}
		machineActivity.setLastChgBy(changedBy);
		machineActivity.setLastChgDate(currentDate);
		machineActivity.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(machineActivity);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMachineActivity(String entryId,
			Date entryDate) {
		List<MachineActivity> machineActivityList = new ArrayList<MachineActivity>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLaundryMachine> laundryList = new ArrayList<MasLaundryMachine>();
		List<MasLaundryMachine> gridLaundryList = new ArrayList<MasLaundryMachine>();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("entryDate") != null) {
			entryDate = (Date) mapForDs.get("entryDate");
		}
		if (mapForDs.get("entryId") != null) {
			entryId = (String) mapForDs.get("entryId");
		}

		try {
			crit = session.createCriteria(MachineActivity.class);
			if (!entryId.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryId + "%"));
			}
			if (!entryDate.equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", entryDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		machineActivityList = crit.list();

		laundryList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasLaundryMachine where Status='y'");
		gridLaundryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasLaundryMachine as isc");
		map.put("laundryList", laundryList);
		map.put("machineActivityList", machineActivityList);
		map.put("gridLaundryList", gridLaundryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String generateEntryNumberForDiaryEntry(Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<CarDiaryEntry> seqNoList = new ArrayList<CarDiaryEntry>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String entryNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(CarDiaryEntry.class).list();
		if (seqNoList.size() > 0) {
			for (CarDiaryEntry mac : seqNoList) {
				lastSeqNo = mac.getEntryNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DEN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (yearlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : yearlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) yearlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				entryNo = entryNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}

		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("CarDiaryEntry");
			tsObj.setTransactionPrefix("DEN");
			tsObj.setTransactionSequenceName("DiaryEntryNo");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public String getEntryNumberForDiaryEntry(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<CarDiaryEntry> seqNoList = new ArrayList<CarDiaryEntry>();
		String entryNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(CarDiaryEntry.class).list();
			if (seqNoList.size() > 0) {
				for (CarDiaryEntry accom : seqNoList) {
					lastSeqNo = accom.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "DEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entryNo = String.valueOf(maxOrderNo + 1);
					} else {
						entryNo = String.valueOf(1);
					}
				}
			} else {
				entryNo = String.valueOf(1);
			}

			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entryNo;
	}

	/**
	 * -------------- method to show jsp of Drivers Car Diary
	 * Entry----------------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCarDiaryEntry() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CarDiaryEntry> carDiaryEntryList = new ArrayList<CarDiaryEntry>();
		carDiaryEntryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.CarDiaryEntry");
		map.put("carDiaryEntryList", carDiaryEntryList);
		return map;
	}

	/**
	 * ------------------- method to add car diary entry-------------------
	 */

	public boolean addCarDiaryEntry(CarDiaryEntry carDiaryEntry) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(carDiaryEntry);
		successfullyAdded = true;
		return successfullyAdded;
	}

	/**
	 * --------------- method to delete car diary
	 * entry------------------------------
	 */
	public boolean deleteCarDiaryEntry(int carEntryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		CarDiaryEntry carDiaryEntry = new CarDiaryEntry();
		carDiaryEntry = (CarDiaryEntry) getHibernateTemplate().get(
				CarDiaryEntry.class, carEntryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				carDiaryEntry.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				carDiaryEntry.setStatus("y");
				dataDeleted = false;
			}
		}
		carDiaryEntry.setLastChgBy(changedBy);
		carDiaryEntry.setLastChgDate(currentDate);
		carDiaryEntry.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(carDiaryEntry);
		return dataDeleted;
	}

	/**
	 * -----------------------method to edit car diary
	 * entry-----------------------
	 */
	@SuppressWarnings("unused")
	public boolean editCarDiaryEntry(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int carEntryId = 0;
		Date entryDate = new Date();
		String specification = "";
		String fromPlace = "";
		String toPlace = "";
		BigDecimal totalKm = null;

		String changedBy = "";
		try {
			carEntryId = (Integer) generalMap.get("id");
			entryDate = (Date) generalMap.get("entryDate");

			specification = (String) generalMap.get("specification");
			fromPlace = (String) generalMap.get("fromPlace");
			toPlace = (String) generalMap.get("toPlace");
			totalKm = (BigDecimal) generalMap.get("totalKm");
			currentDate = (Date) generalMap.get("currentDate");
			changedBy = (String) generalMap.get("changedBy");

			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}
		CarDiaryEntry obj = (CarDiaryEntry) getHibernateTemplate().get(
				CarDiaryEntry.class, carEntryId);

		obj.setId(carEntryId);
		obj.setEntryDate(entryDate);
		obj.setFromPlace(fromPlace);
		obj.setToPlace(toPlace);
		obj.setSpecificationOfDuty(specification);
		obj.setTotalKm(totalKm);
		obj.setLastChgBy(changedBy);
		obj.setLastChgDate(currentDate);
		obj.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(obj);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCarDiaryEntry(String entryNo,
			Date entryDate) {
		List<CarDiaryEntry> carDiaryEntryList = new ArrayList<CarDiaryEntry>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("entryDate") != null) {
			entryDate = (Date) mapForDs.get("entryDate");
		}
		if (mapForDs.get("entryNo") != null) {
			entryNo = (String) mapForDs.get("entryNo");
		}
		try {
			crit = session.createCriteria(CarDiaryEntry.class);
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}
			if (!entryDate.equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", entryDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		carDiaryEntryList = crit.list();
		map.put("carDiaryEntryList", carDiaryEntryList);
		return map;
	}

	/**
	 * ------------------- method to generate entry no for daily
	 * workload------------------
	 */
	@SuppressWarnings("unchecked")
	public String generateEntryNumberForDailyWorkLoad(
			Map<String, Object> diagMap) {
		List<TransactionSequence> yearlySeqNoList = new ArrayList<TransactionSequence>();
		List<WorkLoadEntry> seqNoList = new ArrayList<WorkLoadEntry>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		String entryNo = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(WorkLoadEntry.class).list();
		if (seqNoList.size() > 0) {
			for (WorkLoadEntry mac : seqNoList) {
				lastSeqNo = mac.getEntryNo();
			}

			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		yearlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DWEN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (yearlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : yearlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) yearlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				entryNo = entryNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (yearlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("WorkLoadEntry");
			tsObj.setTransactionPrefix("DWEN");
			tsObj.setTransactionSequenceName("WorkLoadEntryNo");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public String getEntryNumberForWorkLoad(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<WorkLoadEntry> seqNoList = new ArrayList<WorkLoadEntry>();
		String entryNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(WorkLoadEntry.class).list();
			if (seqNoList.size() > 0) {
				for (WorkLoadEntry accom : seqNoList) {
					lastSeqNo = accom.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "DWEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entryNo = String.valueOf(maxOrderNo + 1);
					} else {
						entryNo = String.valueOf(1);
					}
				}
			} else {
				entryNo = String.valueOf(1);
			}

			entryNo = entryNo.concat("/").concat(String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entryNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDailyWorkLoad() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as md where md.DepartmentType.Id='"
						+ 10 + "' and md.Status='y'");
		map.put("departmentList", departmentList);
		return map;
	}

	Session session;

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLinenWeight> itemList = new ArrayList<MasLinenWeight>();
		session = (Session) getSession();

		try {
			String str = dataMap.get("autoHint") + "%";
			itemList = session.createCriteria(MasLinenWeight.class)
					.add(Restrictions.like("ItemName", str))
					.add(Restrictions.like("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("itemList", itemList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDailyWorkLoad(String entryNo, Date entryDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<WorkLoadEntry> workLoadList = new ArrayList<WorkLoadEntry>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (diagMap.get("entryDate") != null) {
			entryDate = (Date) diagMap.get("entryDate");
		}

		if (diagMap.get("entryNo") != null) {
			entryNo = (String) diagMap.get("entryNo");
		}

		try {
			crit = session.createCriteria(WorkLoadEntry.class);
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}
			if (!entryDate.equals("")) {
				crit = crit.add(Restrictions.eq("EntryDate", entryDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		workLoadList = crit.list();

		String wrkLoadNo = "";
		List<WorkLoadEntryDetail> workLoadDetailList = new ArrayList<WorkLoadEntryDetail>();
		for (WorkLoadEntry workLoad : workLoadList) {
			wrkLoadNo = workLoad.getEntryNo();
			workLoadDetailList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.WorkLoadEntryDetail as wd where wd.WorkLoad.EntryNo='"
							+ wrkLoadNo + "'");
		}

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as md where md.DepartmentType.Id='"
						+ 10 + "' and md.Status='y'");
		map.put("departmentList", departmentList);
		map.put("workLoadList", workLoadList);
		map.put("workLoadDetailList", workLoadDetailList);
		return map;
	}

	/**
	 * ----------------- method to add daily work load details
	 * --------------------------
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDailyWorkLoadEntry(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		WorkLoadEntry workLoadEntry = new WorkLoadEntry();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		String entryNo = box.getString(RequestConstants.ENTRY_NO);
		Date entryDate = HMSUtil.dateFormatterDDMMYYYY(box
				.getString(RequestConstants.ENTRY_DATE));
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		String changedBy = box.getString(RequestConstants.CHANGED_BY);
		String currentTime = box.getString(RequestConstants.CHANGED_TIME);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		workLoadEntry.setEntryNo(entryNo);
		workLoadEntry.setEntryDate(entryDate);
		MasDepartment masDept = new MasDepartment();
		masDept.setId(deptId);
		workLoadEntry.setDepartment(masDept);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		workLoadEntry.setHospital(masHospital);
		workLoadEntry.setLastChgBy(changedBy);
		workLoadEntry.setLastChgTime(currentTime);
		workLoadEntry.setStatus("y");
		workLoadEntry.setLastChgDate(date);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(workLoadEntry);

			Integer departmentId = box.getInt(RequestConstants.DEPARTMENT_ID);
			Vector item = box.getVector(RequestConstants.ITEM_ID);
			Vector quantity = box.getVector(RequestConstants.QUANTITY);
			Vector select = box.getVector("select");

			for (int i = 0; i < select.size(); i++) {
				if (select.get(i) != null && !select.get(i).equals("")) {
					int item_id = Integer.parseInt((String) item.get(i));
					WorkLoadEntryDetail workLoadEntryDetail = new WorkLoadEntryDetail();
					workLoadEntryDetail.setWorkLoad(workLoadEntry);

					if (departmentId != null && !departmentId.equals("")) {
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(departmentId);
						workLoadEntryDetail.setDepartment(masDepartment);
					}

					workLoadEntryDetail.setQuantity(new BigDecimal(quantity
							.get(i).toString()));
					if (select != null && !select.equals("")) {
						workLoadEntryDetail.setSelectStatus("y");
					}

					MasLinenWeight masLinenWeight = new MasLinenWeight();
					masLinenWeight.setId(item_id);
					workLoadEntryDetail.setLinenWeight(masLinenWeight);

					hbt.save(workLoadEntryDetail);
				}
			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItems(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List itemList = new ArrayList();
		Session session = (Session) getSession();
		String itemName = (String) dataMap.get("itemName");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			itemList = session.createCriteria(MasLinenWeight.class)
					.add(Restrictions.eq("ItemName", itemName))
					.add(Restrictions.eq("Status", "y")).list();
			map.put("itemList", itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editDailyWorkLoadEntry(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		WorkLoadEntry workLoadEntry = new WorkLoadEntry();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		int workId = box.getInt("workId");
		String entryNo = box.getString(RequestConstants.ENTRY_NO);
		Date entryDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(RequestConstants.ENTRY_DATE));
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		String changedBy = box.getString(RequestConstants.CHANGED_BY);
		String currentTime = box.getString(RequestConstants.CHANGED_TIME);

		workLoadEntry.setId(workId);
		workLoadEntry.setEntryNo(entryNo);
		workLoadEntry.setEntryDate(entryDate);
		MasDepartment masDept = new MasDepartment();
		masDept.setId(deptId);
		workLoadEntry.setDepartment(masDept);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		workLoadEntry.setHospital(masHospital);
		workLoadEntry.setLastChgBy(changedBy);
		workLoadEntry.setLastChgTime(currentTime);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<WorkLoadEntryDetail> workDetailList = new ArrayList<WorkLoadEntryDetail>();
			workDetailList = session.createCriteria(WorkLoadEntryDetail.class)
					.add(Restrictions.eq("WorkLoad.Id", workId)).list();
			hbt.deleteAll(workDetailList);

			Vector departmentId = box.getVector(RequestConstants.DEPARTMENT_ID);
			Vector item = box.getVector(RequestConstants.ITEM_ID);
			Vector quantity = box.getVector(RequestConstants.QUANTITY);
			Vector select = box.getVector("select");
			for (int i = 0; i < select.size(); i++) {
				if (select.get(i) != null && !select.get(i).equals("")) {

					WorkLoadEntryDetail workLoadEntryDetail = new WorkLoadEntryDetail();
					workLoadEntryDetail.setWorkLoad(workLoadEntry);

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(Integer.parseInt((String) departmentId
							.get(i)));
					workLoadEntryDetail.setDepartment(masDepartment);
					workLoadEntryDetail.setQuantity(new BigDecimal(quantity
							.get(i).toString()));
					if (select != null && !select.equals("")) {
						workLoadEntryDetail.setSelectStatus("y");
					}
					if (item.get(i) != null && !item.get(i).equals("")) {
						int item_id = Integer.parseInt((String) item.get(i));
						MasLinenWeight masLinenWeight = new MasLinenWeight();
						masLinenWeight.setId(item_id);
						workLoadEntryDetail.setLinenWeight(masLinenWeight);
					}
					hbt.save(workLoadEntryDetail);
				}
			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkForExistingMasters(
			Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLaundryMachine> duplicateGeneralNameList = new ArrayList<MasLaundryMachine>();

		int id = 0;

		String pojoPropertyName = "";

		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}

		String machineName = (String) generalMap.get("machineName");
		if (generalMap.get("pojoPropertyName") != null) {
			pojoPropertyName = (String) generalMap.get("pojoPropertyName");
		}
		if (!pojoPropertyName.equals("")) {

			duplicateGeneralNameList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasLaundryMachine as g where g.MahineName='"
							+ machineName + "'");
		}

		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		return map;
	}

	/**
	 * method for report connection
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getConnectionForReport() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		return map;

	}

	@Override
	public Map<String, Object> getHospitalDetail(
			Map<String, Object> hospitalParameter) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		if(hospitalParameter.get("hospitalId")!=null){
			hospitalId=(Integer)hospitalParameter.get("hospitalId");
		}
		try{
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			masHospitalList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasHospital as hosp where hosp.Id="+hospitalId);
			map.put("masHospitalList", masHospitalList);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
/**
 * Code for Laundry Indent
 */
	public Map<String, Object> showLaundryIndent(int deptId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> searchStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreFyDocumentNo> demandNoList = new ArrayList<StoreFyDocumentNo>();

		int storeFyDocumentNoId = 0;
		String demandNo = "";
		String finalDemandNo = "";
		session = (Session) getSession();
		try {
			sectionList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasStoreSection as ms where ms.Status = 'y'");
			departmentList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasDepartment as mi where mi.Status = 'y'");
			departmentList1 = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasDepartment as mc where mc.DepartmentType = 3 and mc.Status = 'y'");
			requestByEmployeeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasEmployee as mi where mi.Status = 'y'  and Department.Id="+deptId);
			approvedByEmployeeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasEmployee as mi where mi.Status = 'y'  and Department.Id ="+deptId);
			searchStoreInternalIndentMList = session
					.createCriteria(StoreInternalIndentM.class)
					.add(Restrictions.eq("Department.Id", deptId))
					.addOrder(Order.desc("Id")).list();
			/*
			     Code for demand No
			     code by Mukesh Narayan Singh
			     Date 24 Jan 2011
			    */
			List<Object[]> storeInternalIndentMDemandNoList = new ArrayList<Object[]>();
			String qry = "";
			   qry = "select sim.id,sim.demand_no,sim.demand_date from store_internal_indent_m sim left join store_internal_indent_t sit on " +
			     " sim.id = sit.internal_id where sim.department_id="+deptId+
			     " group by sim.demand_no,sim.id,sim.demand_date order by sim.demand_date desc";
			   storeInternalIndentMDemandNoList = session.createSQLQuery(qry).list();
			   map.put("storeInternalIndentMDemandNoList", storeInternalIndentMDemandNoList);
			   /*
			    * End Of Code for demand No
			    * code by Mukesh Narayan Singh
			    * Date 24 Jan 2011
			    */
			demandNoList = session.createCriteria(StoreFyDocumentNo.class)
					.add(Restrictions.eq("Department.Id", deptId)).list();
		
		List<MasDepartment> departmentForIndentNoList = new ArrayList<MasDepartment>();
		departmentForIndentNoList=getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment as mi where mi.Status = 'y' and mi.Id="+deptId+"");
		String deptType="";
		if(departmentForIndentNoList.size()>0){
			for (MasDepartment masDepartment : departmentForIndentNoList) {
				deptType="IND_"+masDepartment.getDepartmentType().getDepartmentTypeCode();
			}
		}
		Map<String, Object> maxMap=new HashMap<String, Object>();
		maxMap.put("deptType", deptType);
		if (demandNoList != null && demandNoList.size() > 0) {
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) demandNoList
					.get(0);
			demandNo = ("" + storeFyDocumentNo.getDemandNo());
			storeFyDocumentNoId = storeFyDocumentNo.getId();
				maxMap.put("no", demandNo);
				//demandNo =getMaxNoByDeptCode(maxMap);
				finalDemandNo=getMaxNoByDeptCode(maxMap);
				//finalDemandNo = getMaxNo(demandNo);
			map.put("demandNoList", demandNoList);
			map.put("storeFyDocumentNoId", storeFyDocumentNoId);
			map.put("finalDemandNo", finalDemandNo);
		} else {
			maxMap.put("no", demandNo);
			//demandNo =getMaxNoByDeptCode(maxMap);
			finalDemandNo=getMaxNoByDeptCode(maxMap);
			//finalDemandNo = getMaxNo(demandNo);
			map.put("finalDemandNo", finalDemandNo);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}//finally{
			/**
			 * session.close() is done By Ramdular Prajapati
			 * Date 12 May 2010
			 */
			/*if(session!=null){
				session.close();
			}
		}*/

		map.put("sectionList", sectionList);
		map.put("departmentList", departmentList);
		map.put("departmentList1", departmentList1);
		map.put("approvedByEmployeeList", approvedByEmployeeList);
		map.put("requestByEmployeeList", requestByEmployeeList);
		map.put("searchStoreInternalIndentMList",
				searchStoreInternalIndentMList);
		return map;

	}
	 /**
 	 * return financial year on the behalf of parameter date
 	 * @author Mukesh.narayan
 	 * @param date in this "11/04/2010" format
 	 * @return sequence No
 	 * @date 30 Nov 2010
 	 */
	public String getMaxNoByDeptCode(Map<String, Object> dataMap) {
		String maxNo = "";
		/*String y1 = "";
		String y2 = "";
		String y3 = "";
		int tempMonth = 0;*/
		String financialYear="";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		financialYear=HMSUtil.getFinancialYearYY_YY(currentDate);
		String no="";
		if(dataMap.get("no")!=null){
			no=(String)dataMap.get("no");
		}
		String deptType="";
		if(dataMap.get("deptType")!=null){
			deptType=(String)dataMap.get("deptType");
		}
		try {
			if (!no.equals("") && !no.equals("0")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				String arr[] = no.split("/");
				int seqNo=0;
				seqNo=Integer.parseInt(arr[1]);
				++seqNo;
				maxNo = deptType + "/"+seqNo+"/"+ financialYear;
			} else {
					maxNo = deptType + "/" + "01"+ "/" + financialYear;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getLaundryIndentData(Box box) {


		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		String pvms = null;
		String nomenclature = null;
		String au = null;
		Integer qtymmf = null;
		Integer qtyRequest = null;
		Integer stock = null;

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		//List<StoreInternalIndentT> storeInternalIndentTList1 = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> departmentList1 = new ArrayList<MasDepartment>();
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentM> searchStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//StoreInternalIndentT storeInternalIndentT1 = new StoreInternalIndentT();
		//int sno = 0;
		String demandNo = box.get(DEMAND_NO);
		String status1 = box.get("status1");
		int deptId=0;
		deptId=Integer.parseInt(""+box.get(FROM_WARD));

		storeInternalIndentMList = hbt
				.find("from jkt.hms.masters.business.StoreInternalIndentM as inp where inp.DemandNo = '"
						+ demandNo
						+ "' and inp.Department.Id="
						+ box.get(FROM_WARD));

		map.put("storeInternalIndentMList", storeInternalIndentMList);
		if (box.getString("pvmsNo").length() > 0) {
			String strForPvms = box.getString("pvmsNo");
			strForPvms = strForPvms.replace(" ", "%") + "%";
			storeInternalIndentTList = hbt
					.find("from jkt.hms.masters.business.StoreInternalIndentT as inp where inp.Internal.DemandNo = '"
							+ demandNo
							+ "' and inp.Internal.Department.Id='"
							+ box.get(FROM_WARD)
							+ "' and inp.Item.PvmsNo like '" + strForPvms + "'");
		} else {
			storeInternalIndentTList = session
					.createCriteria(StoreInternalIndentT.class)
					.createAlias("Internal", "m")
					.add(Restrictions.eq("m.DemandNo", demandNo))
					.add(Restrictions.eq("m.Department.Id",
							box.getInt(FROM_WARD))).list();
			// hbt.find("from jkt.hms.masters.business.StoreInternalIndentT as
			// inp where inp.Internal.DemandNo = '" + demandNo + "' and
			// inp.Internal.Department.Id=" + box.get(FROM_WARD));
		}
		// Check for existence of previous year records
		/*storeInternalIndentTList1 = hbt
				.find("from jkt.hms.masters.business.StoreInternalIndentT as inp where inp.Internal.DemandNo = '"
						+ demandNo
						+ "' and inp.Internal.Department.Id="
						+ box.get(FROM_WARD) + " order by inp.SrNo desc");*/
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mi where mi.Status = 'y'");
		departmentList1 = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as mc where mc.DepartmentType = 3 and mc.Status = 'y'");
		/*approvedByEmployeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as mi where mi.EmpCategory.Id='1' ");
		requestByEmployeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as mi where mi.EmpCategory.Id='1'");
*/
		requestByEmployeeList = getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasEmployee as mi where mi.Status = 'y'  and Department.Id="+deptId);
approvedByEmployeeList = getHibernateTemplate()
		.find("from jkt.hms.masters.business.MasEmployee as mi where mi.Status = 'y'  and Department.Id ="+deptId);
		// search list for Demand no for search criteria on each page

		searchStoreInternalIndentMList = session
				.createCriteria(StoreInternalIndentM.class)
				.add(Restrictions.eq("Department.Id", box.getInt(FROM_WARD)))
				.addOrder(Order.desc("Id")).list();
		/*
	     Code for demand No
	     code by Mukesh Narayan Singh
	     Date 24 Jan 2011
	    */
	List<Object[]> storeInternalIndentMDemandNoList = new ArrayList<Object[]>();
	String qry = "";
	   qry = "select sim.id,sim.demand_no,sim.demand_date from store_internal_indent_m sim left join store_internal_indent_t sit on " +
	     " sim.id = sit.internal_id where sim.department_id="+deptId+
	     " group by sim.demand_no,sim.id,sim.demand_date order by sim.demand_date desc";
	   storeInternalIndentMDemandNoList = session.createSQLQuery(qry).list();
	   map.put("storeInternalIndentMDemandNoList", storeInternalIndentMDemandNoList);
	   /*
	    * End Of Code for demand No
	    * code by Mukesh Narayan Singh
	    * Date 24 Jan 2011
	    */
		map.put("departmentList", departmentList);
		map.put("departmentList1", departmentList1);
		map.put("approvedByEmployeeList", approvedByEmployeeList);
		map.put("requestByEmployeeList", requestByEmployeeList);
		map.put("searchStoreInternalIndentMList",
				searchStoreInternalIndentMList);
		map.put("newDemandNo", demandNo);
		map.put("status1", status1);

		if (storeInternalIndentTList != null
				&& storeInternalIndentTList.size() > 0) {
			int internalIndentId = storeInternalIndentTList.get(0)
					.getInternal().getId();
			map.put("internalIndentId", internalIndentId);

		}
		for (Iterator iterator = storeInternalIndentTList.iterator(); iterator
				.hasNext();) {
			StoreInternalIndentT storeInternalIndentT = (StoreInternalIndentT) iterator
					.next();

			try {
				id = storeInternalIndentT.getId();
			} catch (Exception e) {
				id = 0;
			}

			try {
				pvms = storeInternalIndentT.getItem().getPvmsNo();
			} catch (Exception e) {
				pvms = "";
			}

			try {
				nomenclature = storeInternalIndentT.getItem().getNomenclature();
			} catch (Exception e) {
				nomenclature = "";
			}

			try {
				au = storeInternalIndentT.getItem().getItemConversion()
						.getPurchaseUnit().getUnitName();
			} catch (Exception e) {
				au = "";
			}

			try {
				qtyRequest = storeInternalIndentT.getQtyRequest();
			} catch (Exception e) {
				qtyRequest = 0;
			}
			try {
				stock = storeInternalIndentT.getStockInHand();
			} catch (Exception e) {
				stock = 0;
			}

			hData = new HashMap<String, Object>();

			// Map<String, Object> groupByItemMap = new HashMap<String,
			// Object>();
			// String str = "select inp.item_id,sum(inp.closing_stock) from
			// store_item_batch_stock as inp where department_id =
			// "+box.get(TO_WARD)+" group by inp.item_id";
			// List<StoreItemBatchStock> groupByItemList =
			// session.createSQLQuery(str).list();
			//
			// for (Iterator iterator2 = groupByItemList.iterator();
			// iterator2.hasNext();)
			// {
			// Object[] obj =(Object[]) iterator2.next();
			// //Integer itemId = (Integer) obj[0];
			// BigDecimal closingStock = (BigDecimal) obj[1];
			//
			// groupByItemMap.put(obj[0].toString(),closingStock);
			// }

			hData.put("id", id);

			hData.put("stock", stock);

			hData.put("pvms", pvms);
			hData.put("nomenclature", nomenclature);
			hData.put("au", au);
			hData.put("qtymmf", qtymmf);
			hData.put("qtyRequest", qtyRequest);

			vResult.add(hData);
		}

		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		try {
			pagedArray = new PageUtil().convertToPagedArrayIndex(testPageData,
					box);
			// metyhod------"+pagedArray.getBeginPage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("demandNo", box.get(DEMAND_NO));
		map.put("pagedArray", pagedArray);
		map.put("storeInternalIndentTList", storeInternalIndentTList);
		return map;
	}

	@Override
	public Map<String, Object> showAddDepartmentIndentLaundry(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		String pvms = null;
		String nomenclature = null;
		String au = null;
		Integer qtymmf = null;
		Integer qtyRequest = null;
		Integer stock = null;

		int id = 0;

		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;

		List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<StoreInternalIndentT> storeInternalIndentTList1 = new ArrayList<StoreInternalIndentT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
		List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentM> searchStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		StoreInternalIndentT storeInternalIndentT1 = new StoreInternalIndentT();
		int sno = 0;
		String demandNo = box.get(DEMAND_NO);
		List storeItemBatchStockList = new ArrayList();
		try {
			int pageNo = box.getInt("pageNo");

			storeInternalIndentMList = hbt
					.find("from jkt.hms.masters.business.StoreInternalIndentM as inp where inp.DemandNo = '"
							+ demandNo
							+ "' and inp.Department.Id="
							+ box.get(FROM_WARD));

			map.put("storeInternalIndentMList", storeInternalIndentMList);

			Criteria c = session
					.createCriteria(StoreInternalIndentT.class)
					.createAlias("Internal", "m")
					.add(Restrictions.eq("m.DemandNo", demandNo))
					.add(Restrictions.eq("m.Department.Id",
							box.getInt(FROM_WARD)));

			int firstResult = 0;
			int maxResults = 14;

			if (pageNo != 1) {
				firstResult = firstResult + (pageNo - 1) * 14;
			}
			c.setFirstResult(firstResult);
			c.setMaxResults(maxResults);
			storeInternalIndentTList = c.list();


			Criteria c1 = session
					.createCriteria(StoreInternalIndentT.class)
					.createAlias("Internal", "m")
					.add(Restrictions.eq("m.DemandNo", demandNo))
					.add(Restrictions.eq("m.Department.Id",
							box.getInt(FROM_WARD)));
			int sizeOfStoreInternalIndentT = 0;
			if (c1.list() != null && c1.list().size() > 0) {
				sizeOfStoreInternalIndentT = c1.list().size();
				for (StoreInternalIndentT storeInternalIndentT : storeInternalIndentTList) {
					String qry = "select sum(closing_stock) from store_item_batch_stock i where i.item_id="
							+ storeInternalIndentT.getItem().getId() + " ";
					List<Object> objectList = session.createSQLQuery(qry)
							.list();
					storeItemBatchStockList.add((BigDecimal) objectList.get(0));
				}
			}
			map.put("storeItemBatchStockList", storeItemBatchStockList);
			map.put("sizeOfStoreInternalIndentT", sizeOfStoreInternalIndentT);


			map.put("storeInternalIndentTList", storeInternalIndentTList);
			map.put("pageNo", pageNo);
			map.put("newDemandNo", demandNo);

			if (storeInternalIndentTList != null
					&& storeInternalIndentTList.size() > 0) {
				int internalIndentId = storeInternalIndentTList.get(0)
						.getInternal().getId();
				map.put("internalIndentId", internalIndentId);

			}
			map.put("demandNo", box.get(DEMAND_NO));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	
	}

	@Override
	public Map<String, Object> getOtherItemsForIndentLaundry(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		//List<StoreItemBatchStock> itemBatchStockList = new ArrayList<StoreItemBatchStock>();
		try {
			String str = "";
			str = box.get("requiredField");
			str = str.trim();
			itemList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", str)).list();
			map.put("itemList", itemList);
			String qry = "select sum(inp.closing_stock) from store_item_batch_stock as inp where department_id = "
					+ box.getInt(FROM_WARD)
					+ " and item_id="
					+ itemList.get(0).getId() + " group by inp.item_id ";
			List<Object> objectList = session.createSQLQuery(qry).list();
			if (objectList != null && objectList.size() > 0) {
				for (Object obj : objectList) {
					map.put("stock", (BigDecimal) obj);
				}

			} else {
				map.put("stock", new BigDecimal(0));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	
	}

	@Override
	public Map<String, Object> deleteGridItemsForDepartmentIndentLaundry(Box box) {

		Session session = (Session) getSession();
		//List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		//StoreInternalIndentT storeInternalIndentT = new StoreInternalIndentT();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HibernateTemplate hbt = getHibernateTemplate();

			Vector srno = box.getVector("srno");
			// Vector annreq = box.getVector(TENDER_ANNREQ);
			Vector items = box.getVector("id");
			Vector delete = box.getVector(ITEMS_TO_BE_DELETED);

			String obj = null;
			for (int i = 0; i < delete.size(); i++) {
				int itemId = Integer.parseInt(delete.get(i).toString());
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				String hql = "delete from jkt.hms.masters.business.StoreInternalIndentT as a where a.Id like :itemId";
				Query query = session.createQuery(hql).setParameter("itemId",
						itemId);
				int row = query.executeUpdate();

			}
			map.put("total_records", srno.size());
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

		map = getLaundryIndentData(box);
		return map;

	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> doAddInternalIndentItemsLaundry(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		//List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		session = (Session) getSession();

		Vector items1 = box.getVector("itemId");
		Vector items = new Vector();
		try {
			for (int i = 0; i < items1.size(); i++) {
				if (!items1.get(i).toString().equals("")) {
					items.add(items1.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Vector qtymmf = box.getVector("qtymmf");
		Vector qtyRequest = box.getVector("qtyRequest");
		Vector stock = box.getVector("stock");
		Vector items_to_be_added = box.getVector(ITEMS_TO_BE_ADDED);
		// Vector annreq = box.getVector(TENDER_ANNREQ);

		int deptId = box.getInt(FROM_WARD);
		int internalIndentId = box.getInt("internalIndentId");
		String demandNo = box.get(DEMAND_NO);
		int newinternalIndentId = 0;

		StoreInternalIndentM storeInternalIndentM = null;
		StoreInternalIndentM newMObj = null;
		StoreInternalIndentT storeInternalIndentT = null;
		MasStoreItem masStoreItem = null;
		int sr_no = 0;
		// int currentYear = box.getInt(MMF_DEPARTMENT_DATE);
		Transaction tx =null;
		try {
			tx = session.beginTransaction();
			List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
			List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (box.getInt("internalIndentId") != 0) {
				// storeMmfDepartmentMList = hbt.find("from
				// jkt.hms.masters.business.StoreMmfDepartmentM as a where a.Id
				// ="+mmfMasterId+" and a.StoreWardDept.Id=" +
				// box.get(STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT));
				storeInternalIndentMList = hbt
						.find("from jkt.hms.masters.business.StoreInternalIndentM as a where a.Id ="
								+ internalIndentId);
				// storeMmfDepartmentTList = hbt.find("from
				// jkt.hms.masters.business.StoreMmfDepartmentT as b where
				// b.StoreMmfDepartmentM.Id ="+mmfMasterId+" and
				// b.StoreMmfDepartmentM.MmfForTheYear = " +
				// box.getInt(MMF_DEPARTMENT_DATE) + " order by b.SrNo desc");
				storeInternalIndentTList = hbt
						.find("from jkt.hms.masters.business.StoreInternalIndentT as b where b.Internal.Id ="
								+ internalIndentId + " order by b.SrNo desc");

				if (storeInternalIndentMList != null
						&& storeInternalIndentMList.size() > 0) {
					storeInternalIndentM = (StoreInternalIndentM) storeInternalIndentMList
							.get(0);
				}

				if (storeInternalIndentTList != null
						&& storeInternalIndentTList.size() > 0) {
					sr_no = storeInternalIndentTList.get(0).getSrNo()
							.intValue();
				}
				newinternalIndentId = storeInternalIndentM.getId();
			} else {
				/*
				 * Code for Duplicate Indent No
				 * Date 21 Jan 2011
				 */
				List<StoreInternalIndentM> storeInternalIndentMForDemandNoList = new ArrayList<StoreInternalIndentM>();
				storeInternalIndentMForDemandNoList=hbt.find("from jkt.hms.masters.business.StoreInternalIndentM as siim where siim.Department.Id="+deptId+" and siim.DemandNo='"+demandNo+"'");

				if(storeInternalIndentMForDemandNoList.size()>0){
					/*String finalDemandNo="";
					List<StoreFyDocumentNo> demandNoForDuplicateList = new ArrayList<StoreFyDocumentNo>();
					demandNoForDuplicateList = session.createCriteria(StoreFyDocumentNo.class)
					.add(Restrictions.eq("Department.Id", deptId)).list();*/

					List<MasDepartment> departmentForIndentNoList = new ArrayList<MasDepartment>();
					departmentForIndentNoList=getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment as mi where mi.Status = 'y' and mi.Id="+deptId+"");
					String deptType="";
					if(departmentForIndentNoList.size()>0){
						for (MasDepartment masDepartment : departmentForIndentNoList) {
							deptType="LDN_"+masDepartment.getDepartmentType().getDepartmentTypeCode();
						}
					}
					Map<String, Object> maxMap=new HashMap<String, Object>();
					maxMap.put("deptType", deptType);
						try {
							maxMap.put("no", demandNo);
							demandNo=getMaxNoByDeptCode(maxMap);
						} catch (Exception e) {
							e.printStackTrace();
						}
					/*
					 * End Of caode for duplicate Indent Id
					 * Date 21 Jan 2011
					 * Date 21 Jan 2011
					 */
				}




				newMObj = new StoreInternalIndentM();
				if (box.getInt(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT) != 0) {
					MasEmployee masEmployee1 = new MasEmployee();
					masEmployee1.setId(box
							.getInt(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT));
					newMObj.setApprovedBy(masEmployee1);
				}

				if (box.getInt(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT) != 0) {
					MasEmployee masEmployee2 = new MasEmployee();
					masEmployee2.setId(box
							.getInt(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT));
					newMObj.setRequestedBy(masEmployee2);
				}
				int storeDepartmentId = 0;
				if (box.get("storeDepartmentId") != null
						&& !box.get("storeDepartmentId").equals("")) {
					storeDepartmentId = box.getInt("storeDepartmentId");

				}
				if (storeDepartmentId != 0) {
					MasDepartment masdepartment1 = new MasDepartment();
					masdepartment1.setId(storeDepartmentId);
					newMObj.setStoreDepartment(masdepartment1);
				}

				newMObj.setDemandNo(demandNo);
				//commented for maven
				/*newMObj.setLastChgBy(box.get(CHANGED_BY));*/

				newMObj.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				//status ='o' from department indent and status ='p' from laundry indent after acknowledge from Laundry it will convert to status ='o'
				/*
				 * IndentFlag=ALL means All Item Except Laundry Item
				 * IndentFlag=LDN means Indent Only Laundry Item
				 */
				newMObj.setStatus("p");
				newMObj.setIndentFlag("LDN");
				MasDepartment fromDept = new MasDepartment();
				fromDept.setId(box.getInt(FROM_WARD));
				newMObj.setDepartment(fromDept);

				MasDepartment toDept = new MasDepartment();
				toDept.setId(box.getInt(TO_WARD));
				newMObj.setToStore(toDept);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("hospitalId"));
				newMObj.setHospital(masHospital);

				newMObj.setDemandDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(DEMAND_DATE)));
				/*hbt.save(newMObj);
				hbt.refresh(newMObj);*/

				session.save(newMObj);
				session.refresh(newMObj);
				newinternalIndentId = newMObj.getId();

				// Auto-Increment No for demand No of Department Indent

				List<StoreFyDocumentNo> demandNoList = new ArrayList<StoreFyDocumentNo>();
				demandNoList = session.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id", deptId)).list();
				if (demandNoList.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) demandNoList
							.get(0);
					storeFyDocumentNo.setDemandNo(demandNo);

					hbt.save(storeFyDocumentNo);
					hbt.refresh(storeFyDocumentNo);
					//session.saveOrUpdate(storeFyDocumentNo);
					//session.refresh(storeFyDocumentNo);
				} else {
					StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
					storeFyDocumentNo.setAdjustmentNo("0");
					storeFyDocumentNo.setAdjustmentStartNo("0");
					storeFyDocumentNo.setBalanceNo("0");
					storeFyDocumentNo.setBalanceStartNo("0");
					storeFyDocumentNo.setDefectEntryNo("0");
					storeFyDocumentNo.setDefectEntryStartNo("0");
					storeFyDocumentNo.setDemandNo(demandNo);
					storeFyDocumentNo.setDemandStartNo("0");
					storeFyDocumentNo.setDepartment(new MasDepartment(box
							.getInt(FROM_WARD)));
					storeFyDocumentNo.setGrnNo("0");
					storeFyDocumentNo.setGrnStartNo("0");
					storeFyDocumentNo.setIssueDeptNo("0");
					storeFyDocumentNo.setIssueDeptReturnNo("0");
					storeFyDocumentNo.setIssueDeptReturnStartNo("0");
					storeFyDocumentNo.setIssueDeptStartNo("0");
					storeFyDocumentNo.setVendorReturnNo("0");
					storeFyDocumentNo.setVendorReturnStartNo("0");
					String issueDeptNo = "";
					issueDeptNo = getMaxNo("0");
					String issueDeptStartNo = issueDeptNo;
					storeFyDocumentNo.setIssueDeptNo(issueDeptNo);
					storeFyDocumentNo.setIssueDeptStartNo(issueDeptStartNo);
					hbt.save(storeFyDocumentNo);
					hbt.refresh(storeFyDocumentNo);
					//session.save(storeFyDocumentNo);
					//session.refresh(storeFyDocumentNo);

				}
			}

			for (int i = 0; i < items1.size(); i++) {
				if (items1.get(i) != null
						&& !items1.get(i).toString().equals("")) {

					masStoreItem = new MasStoreItem();
					masStoreItem.setId(Integer
							.valueOf(items1.get(i).toString()));

					storeInternalIndentT = new StoreInternalIndentT();

					storeInternalIndentT.setItem(masStoreItem);
					if (box.getInt("internalIndentId") != 0) {
						// Master already exists
						storeInternalIndentT.setInternal(storeInternalIndentM);
					} else {
						// Create new department Master record
						storeInternalIndentT.setInternal(newMObj);
					}
					// storeInternalIndentT.setMmfQty(Integer.valueOf(qtymmf.get(i).toString()));

					int stockQnt = 0;
					stockQnt = new BigDecimal(stock.get(i).toString())
							.intValue();
					int qauntityRecd = new BigDecimal(qtyRequest.get(i)
							.toString()).intValue();
					storeInternalIndentT.setSrNo(++sr_no);
					storeInternalIndentT.setQtyRequest(qauntityRecd);
					String qry = "select sum(closing_stock) from store_item_batch_stock where item_id="
							+ masStoreItem.getId()
							+ " and department_id="
							+ box.get(FROM_WARD) + " ";
					List<Object> storeItemBatchstockList = session
							.createSQLQuery(qry).list();
					if (storeItemBatchstockList != null
							&& storeItemBatchstockList.size() > 0) {
						if (storeItemBatchstockList.get(0) != null) {
							storeInternalIndentT
									.setStockInHand(((BigDecimal) storeItemBatchstockList
											.get(0)).intValue());
						} else {
							storeInternalIndentT.setStockInHand(0);
						}
					} else {
						storeInternalIndentT.setStockInHand(0);
					}
					MasDepartment department = new MasDepartment();
					department.setId(box.getInt(FROM_WARD));
					storeInternalIndentT.setDepartment(department);

				/*	hbt.save(storeInternalIndentT);
					hbt.refresh(storeInternalIndentT);*/
					session.save(storeInternalIndentT);
					session.refresh(storeInternalIndentT);

				}
			}

			box.put("internalIndentId", newinternalIndentId);
			if (!box.getString("itemIdForNextRecord").equals("null")) {
				// map = getItemDetailsForDepartmentIndentForNextRecord(box);
			} else {
				// map = getItemDetailsForDepartmentIndent(box);
			}
			List<StoreInternalIndentM> storeInternalIndentMList2 = session
					.createCriteria(StoreInternalIndentM.class)
					.add(Restrictions.eq("Id", newinternalIndentId)).list();
			box.put(DEMAND_NO, storeInternalIndentMList2.get(0).getDemandNo());
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}//finally{
			/**
			 * session.close() is done By Ramdular Prajapati
			 * Date 12 May 2010
			 */
			/*if(session!=null){
				session.close();
			}
		}*/

		map.put("newinternalIndentId", newinternalIndentId);

		return map;
	
	}

	@Override
	public Map<String, Object> updateGridItemsInDepartmentIndentLaundry(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		//List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		//StoreInternalIndentT storeInternalIndentT = null;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			//int deptId = box.getInt(TO_WARD);
			//int approvedByEmpId = box.getInt(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT);
			//int requestBYEmpId = box.getInt(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT);
			//String demandNo = box.getString(DEMAND_NO);
			int internalIndentId = box.getInt("internalIndentId");
			StoreInternalIndentM mObj = (StoreInternalIndentM) hbt.load(
					StoreInternalIndentM.class, internalIndentId);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt(TO_WARD));
			mObj.setToStore(masDepartment);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box
					.getInt(APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT));
			mObj.setApprovedBy(masEmployee);
			String status1 = box.get("status1");
			map.put("status1", status1);
			MasEmployee masEmployee2 = new MasEmployee();
			masEmployee2.setId(box
					.getInt(REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT));
			mObj.setRequestedBy(masEmployee2);
			hbt.update(mObj);

			Vector srno = box.getVector("srno");
			// Vector qtymmf = box.getVector("qtymmf");
			Vector items = box.getVector("id");
			Vector qtyRequest = box.getVector("qtyRequest");
			Vector stock = box.getVector("stock");

			String obj = null;
			for (int i = 0; i < srno.size(); i++) {
				int itemId = Integer.parseInt(items.get(i).toString());
				StoreInternalIndentT tObj = (StoreInternalIndentT) hbt.load(
						StoreInternalIndentT.class, itemId);
				//int qm = 0;
				int qr = 0;
				int st = 0;
				// try
				// {
				// qm = Integer.parseInt(qtymmf.get(i).toString());
				// }
				// catch(Exception e)
				// {
				// qm = 0;
				// }

				try {
					qr = Integer.parseInt(qtyRequest.get(i).toString());
				} catch (Exception e) {
					qr = 0;
				}

				try {
					st = Integer.parseInt(stock.get(i).toString());
				} catch (Exception e) {
					st = 0;
				}

				// tObj.setMmfQty(qm);
				tObj.setQtyRequest(qr);
				tObj.setStockInHand(st);
				hbt.update(tObj);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		boolean updated = false;
		updated = true;
		String message = "";
		if (updated) {
			message = "Data update Successfully.";
		} else {
			message = "Some Problem Occured.";
		}
		map = getLaundryIndentData(box);
		map.put("message", message);
		return map;
	
	}
	public String getMaxNo(String no) {
		String maxNo = "";
		String y1 = "";
		String y2 = "";
		String y3 = "";
		int tempMonth = 0;

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);

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

		try {
			if (!no.equals("") && !no.equals("0")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				tempMonth = Integer.parseInt(stringTokenizer.nextToken());

				String arr[] = no.split("/");
				// for no also containging month

				if (arr.length > 2) {
					if (currentMonth == (Integer.parseInt(arr[1]))) {
						tempMonth++;
					} else {
						tempMonth = 01;
					}
				}

				if (currentMonth < 4) {

					maxNo = tempMonth + "/" + currentMonth + "/" + currentYear;
				} else {
					maxNo = tempMonth + "/" + currentMonth + "/" + currentYear;
				}

			} else {
				if (currentMonth < 4) {
					maxNo = "01" + "/" + currentMonth + "/" + currentYear;
				} else {
					maxNo = "01" + "/" + currentMonth + "/" + currentYear;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemListForIndentLaundry(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> itemList = new ArrayList<Object>();

		session = (Session) getSession();

		int deptId = 0;
		deptId = box.getInt("deptId");
		int toWard=0;
		toWard=box.getInt("toWard");
		int fromWard=0;
		fromWard=box.getInt("fromWard");
		List<Integer> objectList = new ArrayList<Integer>();
		int internalIndentId = 0;

		if (box.get("internalIndentId") != null
				&& !box.get("internalIndentId").equals("")) {
			internalIndentId = box.getInt("internalIndentId");
		}
		
		try {
			String str = box.get("autoHint") + "%";
			String qry = "select t.item_id from store_internal_indent_m m,store_internal_indent_t t where  m.id=t.internal_id and m.id="
					+ internalIndentId;
			objectList = session.createSQLQuery(qry).list();

			// add(Restrictions.like("Nomenclature",str))
			/*Criteria c = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Status", "y")).add(
					Restrictions.like("Nomenclature", str));*/
		//	c.add(Restrictions.eq("Department.Id", storeDepartmentId));
			String sql="";
			if (objectList != null && objectList.size() > 0) {

				//c.add(Restrictions.not(Restrictions.in("Id", objectList)));
				int counter=0;
				for (Integer object : objectList) {
					if(counter==0){
						sql=""+object.intValue();
					}else{
						sql=sql+","+object.intValue();
					}
					++counter;
				}
			}
/*
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();
*/
			String query = "";
			
			// In Laundry Indent Process 
			if(fromWard>0){
				/*
				 * This Case Deaprtment Indent
				 * Code By Mukesh Narayan SIngh
				 * Date 22/01/2011
				 */
				fromWard=fromWard;
			}else{
				/*
				 * This Case Deaprtment Issue Without Indent
				 * Code By Mukesh Narayan SIngh
				 * Date 22/01/2011
				 */
				fromWard=deptId;
			}
			/*
			 * In Normal Indent Process
			 * if(toWard>0){
				
				 * This Case Deaprtment Indent
				 * Code By Mukesh Narayan SIngh
				 * Date 22/01/2011
				 
				toWard=toWard;
			}else{
				
				 * This Case Deaprtment Issue Without Indent
				 * Code By Mukesh Narayan SIngh
				 * Date 22/01/2011
				 
				toWard=deptId;
			}*/
			if(sql==""){
				query = "select mst.Id,mst.PvmsNo,mst.Nomenclature from MasStoreItem as mst,StoreItemBatchStock stock where mst.Id= stock.Item and stock.Department.Id in ("+fromWard+") and mst.Status='y' and stock.ClosingStock>0 and  mst.Nomenclature like '"
				+ str + "' group by mst.Id,mst.PvmsNo,mst.Nomenclature";
			}else{
				query = "select mst.Id,mst.PvmsNo,mst.Nomenclature from MasStoreItem as mst,StoreItemBatchStock stock where mst.Id= stock.Item and stock.Department.Id in ("+fromWard+") and mst.Id not in("+sql+") and mst.Status='y' and stock.ClosingStock>0 and  mst.Nomenclature like '"
				+ str + "' group by mst.Id,mst.PvmsNo,mst.Nomenclature";
			}
		Query q = session.createQuery(query);
		q.setFirstResult(0);
		q.setMaxResults(10);
		itemList = q.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("itemList", itemList);
		map.put("objectList", objectList);
		return map;
	
	}

	/**
	 * Code for (Laundry) Acknowledgment for Department Issue  
	 *  Date 07 July 2011 
	 *  Code by Mukesh Narayan Singh
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> createGridLaundryIssueData(Box box) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();
		List<StoreIssueM> storeIssueMList1 = new ArrayList<StoreIssueM>();
		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		int itemId = 0;
		String pvms = null;
		String nomenclature = null;
		String au = null;
		int brand = 0;
		String brandname = null;

		String batchNo = null;
		BigDecimal qtyRequest = null;
		BigDecimal qtyIssued = null;
		String expiry_date = null;
		int id = 0;
		int issueId = 0;
		PagedArray pagedArray = null;
		HashMap<String, Object> hData = null;
		Vector<HashMap> vResult = new Vector<HashMap>();
		HashMap[] testPageData = null;
		List<StoreIssueM> issueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		//int issueDeptId = box.getInt(ISSUE_DEPT);
		int issueNo = box.getInt(ISSUE_NO);
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("stores.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
		try {
			storeInternalPendingIndentList = session
			.createCriteria(StoreInternalIndentM.class)
			.add(Restrictions.eq("Status", "p"))
			.createAlias("ToStore", "d")
			.add(Restrictions.eq("d.Id", box.getInt("deptId")))
			.addOrder(Order.desc("Id")).list();


			List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();

			departmentList = getHibernateTemplate()
			.find("select distinct mi.Department from jkt.hms.masters.business.StoreInternalIndentM as mi where mi.ToStore.Id='"
					+ box.getInt("deptId") + "' and mi.Status='p'");
			approvedByEmployeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee  where Department.Id ="+box.getInt("deptId"));

			storeInternalIndentTList=getHibernateTemplate().find("" +
					"select siit from jkt.hms.masters.business.StoreInternalIndentT as siit join siit.Internal as siim where siim.Id="+issueNo+" and siim.Status='p'");
			/*issueMList = session.createCriteria(StoreIssueM.class)
					.add(Restrictions.eq("Id", issueNo)).add(Restrictions.eq("Status", "o")).list();*/
			//approvedByEmployeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee ");
			/*storeIssueMList = getHibernateTemplate()
					.find("select distinct mi.IssueM from jkt.hms.masters.business.StoreIssueT as mi where mi.ReceivedBy = "
							+ null
							+ " and mi.AckDate = "
							+ null
							+ " and  mi.Issued = 'y' and mi.IssueM.ToStore.Id = "
							+ box.getInt("deptId"));
			departmentList = getHibernateTemplate()
					.find("select distinct mi.Department from jkt.hms.masters.business.StoreIssueM as mi where mi.ToStore.Id="
							+ box.getInt("deptId") + " and mi.Status='o'");*/

			for (StoreIssueM storeIssueM : storeIssueMList) {
				if (storeIssueM.getIssueType().equalsIgnoreCase("i")
						&& storeIssueM.getStatus().equalsIgnoreCase("o")) {
					int storeIssueMId = storeIssueM.getId();
					storeIssueTList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.StoreIssueT as mi where mi.IssueM.Id = "
							+ storeIssueMId + " and mi.ReceivedBy = "
							+ null + " and mi.AckDate = " + null
							+ " and  mi.Issued = 'y' ");
					if (storeIssueTList != null && storeIssueTList.size() > 0) {
						storeIssueMList1.add(storeIssueM);
					}

				}
			}

			/*if (storeInternalIndentList != null && storeInternalIndentList.size() > 0) {
				StoreInternalIndentM mObj = (StoreInternalIndentM) storeInternalIndentList.get(0);
				int storeIssueMId = mObj.getId();

				if (mObj.getIssueType().equalsIgnoreCase("i")) {
					storeIssueTList = session.createCriteria(StoreIssueT.class)
							.add(Restrictions.eq("IssueM.Id", storeIssueMId))
							.add(Restrictions.eq("Issued", "y"))
							.add(Restrictions.isNull("AckDate"))
							.add(Restrictions.isNull("ReceivedBy")).list();
				}
			}*/

			if (storeInternalIndentTList != null && storeInternalIndentTList.size() > 0) {
				for (Iterator iterator = storeInternalIndentTList.iterator(); iterator
				.hasNext();) {
					StoreInternalIndentT tObj = (StoreInternalIndentT) iterator.next();

					try {
						expiry_date =null;
					} catch (Exception e) {
						expiry_date = null;
					}

					try {
						itemId = tObj.getItem().getId();
					} catch (Exception e) {
						itemId = 0;
					}
					try {
						issueId = tObj.getInternal().getId();
					} catch (Exception e) {
						issueId = 0;
					}

					try {
						id = tObj.getId();
					} catch (Exception e) {
						id = 0;
					}
					try {
						pvms = tObj.getItem().getPvmsNo();
					} catch (Exception e) {
						pvms = "";
					}

					try {
						nomenclature = tObj.getItem().getNomenclature();
					} catch (Exception e) {
						nomenclature = "";
					}

					try {
						//brand = tObj.getBrand().getId();
						brand = 0;
					} catch (Exception e) {
						brand = 0;
					}
					try {
						//brandname = tObj.getBrand().getBrandName();
						brandname ="";
					} catch (Exception e) {
						brandname = "";
					}

					try {
						au = tObj.getItem().getItemConversion()
						.getPurchaseUnit().getUnitName();
					} catch (Exception e) {
						au = "";
					}

					try {
						//batchNo = tObj.getBatchNo();
						batchNo = "";
					} catch (Exception e) {
						batchNo = "";
					}

					try {
						qtyRequest = new BigDecimal(tObj.getQtyRequest());
					} catch (Exception e) {
						qtyRequest = new BigDecimal(0);
					}
					try {
						qtyIssued = new BigDecimal(tObj.getQtyRequest());
					} catch (Exception e) {
						qtyIssued = new BigDecimal(0);
					}

					hData = new HashMap<String, Object>();
					hData.put("issueId", issueId);
					hData.put("itemId", itemId);
					hData.put("pvms", pvms);
					hData.put("nomenclature", nomenclature);
					hData.put("brand", brand);
					hData.put("brandname", brandname);
					hData.put("au", au);
					hData.put("batchNo", batchNo);
					hData.put("qtyRequest", qtyRequest);
					hData.put("qtyIssued", qtyIssued);
					hData.put("expiry_date", expiry_date);

					vResult.add(hData);
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
		map.put("approvedByEmployeeList", approvedByEmployeeList);
		map.put("storeIssueMList", storeIssueMList1);
		map.put("departmentList", departmentList);
		map.put("storeInternalPendingIndentList", storeInternalPendingIndentList);
		return map;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAckForIssueLaundry(int deptId) {

		Map<String, Object> map = new HashMap<String, Object>();
		/*List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
		List<StoreIssueM> storeIssueMList1 = new ArrayList<StoreIssueM>();
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();*/
		List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		//List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
		List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
		
		session = (Session) getSession();

		try {
			storeInternalPendingIndentList = session
			.createCriteria(StoreInternalIndentM.class)
			.add(Restrictions.eq("Status", "p"))
			.createAlias("ToStore", "d")
			.add(Restrictions.eq("d.Id", deptId))
			.addOrder(Order.desc("Id")).list();
			
			departmentList = getHibernateTemplate()
			.find("select distinct mi.Department from jkt.hms.masters.business.StoreInternalIndentM as mi where mi.ToStore.Id='"
					+ deptId + "' and mi.Status='p'");
			approvedByEmployeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee  where Department.Id ="+deptId);
			
			/*
			storeIssueMList = getHibernateTemplate()
					.find("select distinct mi.IssueM from jkt.hms.masters.business.StoreIssueT as mi where mi.ReceivedBy = "
							+ null
							+ " and mi.AckDate = "
							+ null
							+ " and  mi.Issued = 'y' and mi.IssueM.ToStore.Id = "
							+ deptId);
			for (StoreIssueM storeIssueM : storeIssueMList) {
				if (storeIssueM.getIssueType().equalsIgnoreCase("i")) {
					int storeIssueMId = storeIssueM.getId();
					storeIssueTList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.StoreIssueT as mi where mi.IssueM.Id = "
							+ storeIssueMId
							+ " and mi.ReceivedBy = "
							+ null
							+ " and mi.AckDate = "
							+ null
							+ " and  mi.Issued = 'y'");

					if (storeIssueTList != null && storeIssueTList.size() > 0) {
						storeIssueMList1.add(storeIssueM);
					}

				} else {
					storeIssueMList1.add(storeIssueM);
				}
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeInternalPendingIndentList", storeInternalPendingIndentList);
		map.put("approvedByEmployeeList", approvedByEmployeeList);
		//map.put("storeIssueMList", storeIssueMList1);
		map.put("departmentList", departmentList);


		return map;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> addAckLaundry(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
		session = (Session) getSession();
		//Date ackDate = HMSUtil.dateFormatterDDMMYYYY(box.getString(ACK_DATE));
		//int ackBy = box.getInt(ACK_BY);
		//int deptId = box.getInt(ISSUE_DEPT);
		Date expiryDate = new Date();
		String batchNo = null;
		int issueMasterId = box.getInt(ISSUE_NO);
		int issueDept=box.getInt(ISSUE_DEPT);
		Transaction tx = null;
		boolean flag = false;
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			tx = session.beginTransaction();
			
			
			List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			//List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
			List<StoreInternalIndentM> storeInternalPendingIndentList = new ArrayList<StoreInternalIndentM>();
			storeInternalPendingIndentList = session
			.createCriteria(StoreInternalIndentM.class)
			.add(Restrictions.eq("Status", "p"))
			.createAlias("ToStore", "d")
			.add(Restrictions.eq("d.Id", box.getInt("deptId")))
			.addOrder(Order.desc("Id")).list();
			
			departmentList = getHibernateTemplate()
			.find("select distinct mi.Department from jkt.hms.masters.business.StoreInternalIndentM as mi where mi.ToStore.Id='"
					+ box.getInt("deptId") + "' and mi.Status='p'");
			approvedByEmployeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee  where Department.Id ="+box.getInt("deptId"));
			
			
			map.put("storeInternalPendingIndentList", storeInternalPendingIndentList);
			map.put("approvedByEmployeeList", approvedByEmployeeList);
			//map.put("storeIssueMList", storeIssueMList1);
			map.put("departmentList", departmentList);
			//BigDecimal dispencingPrice = new BigDecimal(0);
			//BigDecimal mrp = new BigDecimal(0);
			List storeInternalIndentMList = session.createCriteria(StoreInternalIndentM.class)
					.add(Restrictions.eq("Id", issueMasterId)).list();
			
			if (storeInternalIndentMList != null && storeInternalIndentMList.size() > 0) {
				StoreInternalIndentM storeInternalIndentM = (StoreInternalIndentM) storeInternalIndentMList.get(0);
				List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();

				storeInternalIndentTList = session.createCriteria(StoreInternalIndentT.class)
							.add(Restrictions.eq("Internal.Id", storeInternalIndentM.getId())).list();
					// .add(Restrictions.eq("ItemOrder", "3")).list();

				for (StoreInternalIndentT storeInternalIndentT : storeInternalIndentTList) {
					List storeItemBatchStockIndentDeptList = session.createQuery(
							"select sib  from StoreItemBatchStock as sib where sib.Item.Id ="
									+ storeInternalIndentT.getItem().getId()
									+ "   and sib.Department.Id = "
									+ issueDept).list();
					List storeItemBatchStockLaundryList = session.createQuery(
							"select sib  from StoreItemBatchStock as sib where sib.Item.Id ="
									+ storeInternalIndentT.getItem().getId()
									+ "   and sib.Department.Id = "
									+ box.getInt("deptId")).list();
					// If alreay Item exists in Item Batch Stock, then update
					// the stock
					if (storeItemBatchStockIndentDeptList != null
							&& storeItemBatchStockIndentDeptList.size() > 0) {
						StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) storeItemBatchStockIndentDeptList
								.get(0);
						int storeItemBatchStockId = storeItemBatchStock.getId();
						StoreItemBatchStock storeItemBatchStockObj = (StoreItemBatchStock) hbt
								.load(StoreItemBatchStock.class,storeItemBatchStockId);
						
						BigDecimal closingStock = (BigDecimal) storeItemBatchStock.getClosingStock();
						BigDecimal issueQty = (BigDecimal) storeItemBatchStock.getIssueQty();
						if (issueQty == null) {
							issueQty = new BigDecimal(0);
						}
						if (storeInternalIndentT.getQtyRequest().equals(new BigDecimal(0))) {
							closingStock = (BigDecimal) storeItemBatchStock.getClosingStock();
						} else {
							closingStock = closingStock.subtract(new BigDecimal(storeInternalIndentT.getQtyRequest()));
						}
						storeItemBatchStockObj.setClosingStock(closingStock);

						if (storeInternalIndentT.getQtyRequest().equals(new BigDecimal(0))) {
							issueQty = (BigDecimal) storeItemBatchStock.getIssueQty();
						} else {
							issueQty = issueQty.add(new BigDecimal(storeInternalIndentT.getQtyRequest()));
						}
						expiryDate = storeItemBatchStock.getExpiryDate();
						batchNo = storeItemBatchStock.getBatchNo();
						//storeItemBatchStockObj.setReceivedQty(receivedQty);
						storeItemBatchStockObj.setIssueQty(issueQty);
						// storeItemBatchStockObj.setId(null);
						hbt.update(storeItemBatchStockObj);
					} else // If item not found in item batch stock, add the
					// item with stock
					{
						List<StoreItemBatchStock> storeItemBatchStockList1 = session
								.createCriteria(StoreItemBatchStock.class)
								.add(Restrictions.eq("Item.Id", storeInternalIndentT
										.getItem().getId())).add(Restrictions.eq("Department.Id", issueDept)).list();
								//.add(Restrictions.eq("BatchNo",storeInternalIndentT.getBatchNo())).list();
						StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
						storeItemBatchStock.setItem(new MasStoreItem(
								storeInternalIndentT.getItem().getId()));
						if(storeItemBatchStockList1.size()>0){
							StoreItemBatchStock storeItemBatchStock1 = (StoreItemBatchStock) storeItemBatchStockList1.get(0);
							try {
								storeItemBatchStock.setMrp(storeItemBatchStock1.getMrp());
							} catch (Exception e) {
								storeItemBatchStock.setMrp(new BigDecimal(0));
							}
							try {
								storeItemBatchStock
										.setDispencingPrice(storeItemBatchStock1.getDispencingPrice());
							} catch (Exception e) {
								storeItemBatchStock.setDispencingPrice(new BigDecimal(0));
							}
						}else{
							storeItemBatchStock.setMrp(new BigDecimal(0));
							storeItemBatchStock.setDispencingPrice(new BigDecimal(0));
						}
						storeItemBatchStock.setDepartment(new MasDepartment(box.getInt("deptId")));
						try {
							storeItemBatchStock.setClosingStock(new BigDecimal(storeInternalIndentT.getQtyRequest()));
						} catch (Exception e) {
							storeItemBatchStock.setClosingStock(new BigDecimal(0));
						}
						try {
							/*
							 * This Code is commented By Mukesh 
							 * Date 24 Feb 2011
							 * Region:- Opening Balance + Recived Qty =Closing Stock 
							 * In Case of without opening balance depart recive item then issue is genrating 
							 */
							
							//storeItemBatchStock.setOpeningBalanceQty(storeInternalIndentT.getQtyRequest());
							storeItemBatchStock.setOpeningBalanceQty(new BigDecimal(0));
						} catch (Exception e) {
							storeItemBatchStock.setOpeningBalanceQty(new BigDecimal(0));
						}

						try {
							storeItemBatchStock.setReceivedQty(new BigDecimal(storeInternalIndentT.getQtyRequest()));
						} catch (Exception e) {
							storeItemBatchStock.setIssueQty(new BigDecimal(0));
						}
						expiryDate = storeItemBatchStock.getExpiryDate();
						batchNo = storeItemBatchStock.getBatchNo();
						hbt.save(storeItemBatchStock);
					}

					//hbt.update(storeInternalIndentT);
					/**
					 * Code for Laundry Department Added Stock and Loss  Stock of Indent Department 
					 */
					// If alreay Item exists in Item Batch Stock, then update
					// the stock
					// code updated by manjul to add ack item to laundry stock
					if (storeItemBatchStockLaundryList != null
							&& storeItemBatchStockLaundryList.size() > 0) {
						StoreItemBatchStock storeItemBatchStockLaundry = (StoreItemBatchStock) storeItemBatchStockLaundryList
								.get(0);
						int storeItemBatchStockId = storeItemBatchStockLaundry.getId();
						StoreItemBatchStock storeItemBatchStockObj = (StoreItemBatchStock) hbt
								.load(StoreItemBatchStock.class,storeItemBatchStockId);

						BigDecimal closingStock = (BigDecimal) storeItemBatchStockLaundry.getClosingStock();
						BigDecimal receivedQty = (BigDecimal) storeItemBatchStockLaundry.getReceivedQty();
						if (receivedQty == null) {
							receivedQty = new BigDecimal(0);
						}
						if (storeInternalIndentT.getQtyRequest().equals(new BigDecimal(0))) {
							closingStock = (BigDecimal) storeItemBatchStockLaundry.getClosingStock();
						} else {
							closingStock = closingStock.add(new BigDecimal(storeInternalIndentT.getQtyRequest()));
						}
						storeItemBatchStockObj.setClosingStock(closingStock);

						if (storeInternalIndentT.getQtyRequest()
								.equals(new BigDecimal(0))) {
							receivedQty = (BigDecimal) storeItemBatchStockLaundry.getReceivedQty();
						} else {
							receivedQty = receivedQty.add(new BigDecimal(storeInternalIndentT.getQtyRequest()));
						}
						storeItemBatchStockObj.setReceivedQty(receivedQty);
						//storeItemBatchStockObj.setIssueQty(issueQty);
						// storeItemBatchStockObj.setId(null);
						storeItemBatchStockObj.setExpiryDate(expiryDate);
						storeItemBatchStockObj.setBatchNo(batchNo);
						hbt.update(storeItemBatchStockObj);
					} else // If item not found in item batch stock, add the
					// item with stock
					{
						List<StoreItemBatchStock> storeItemBatchStockList1 = session
								.createCriteria(StoreItemBatchStock.class)
								.add(Restrictions.eq("Item.Id", storeInternalIndentT
										.getItem().getId())).add(Restrictions.eq("Department.Id", box.getInt("deptId"))).list();
								//.add(Restrictions.eq("BatchNo",storeInternalIndentT.getBatchNo())).list();

						StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
						storeItemBatchStock.setItem(new MasStoreItem(storeInternalIndentT.getItem().getId()));
						if(storeItemBatchStockList1.size()>0){
							StoreItemBatchStock storeItemBatchStock1 = (StoreItemBatchStock) storeItemBatchStockList1
							.get(0);
							try {
								storeItemBatchStock.setMrp(storeItemBatchStock1.getMrp());
							} catch (Exception e) {
								storeItemBatchStock.setMrp(new BigDecimal(0));
							}
							try {
								storeItemBatchStock.setDispencingPrice(storeItemBatchStock1
												.getDispencingPrice());
							} catch (Exception e) {
								storeItemBatchStock.setDispencingPrice(new BigDecimal(0));
							}
						}else{
							storeItemBatchStock.setMrp(new BigDecimal(0));
							storeItemBatchStock.setDispencingPrice(new BigDecimal(0));
						}

						
						storeItemBatchStock.setDepartment(new MasDepartment(box.getInt("deptId")));


						try {
							storeItemBatchStock.setClosingStock(new BigDecimal(storeInternalIndentT.getQtyRequest()));
						} catch (Exception e) {
							storeItemBatchStock.setClosingStock(new BigDecimal(0));
						}

						try {
							/*
							 * This Code is commented By Mukesh 
							 * Date 24 Feb 2011
							 * Region:- Opening Balance + Recived Qty =Closing Stock 
							 * In Case of without opening balance depart recive item then issue is genrating 
							 */
							
							//storeItemBatchStock.setOpeningBalanceQty(storeInternalIndentT.getQtyRequest());
							storeItemBatchStock.setOpeningBalanceQty(new BigDecimal(0));
						} catch (Exception e) {
							storeItemBatchStock.setOpeningBalanceQty(new BigDecimal(0));
						}

						try {
							storeItemBatchStock.setReceivedQty(new BigDecimal(storeInternalIndentT.getQtyRequest()));
						} catch (Exception e) {
							storeItemBatchStock.setReceivedQty(new BigDecimal(0));
						}
						storeItemBatchStock.setExpiryDate(expiryDate);
						storeItemBatchStock.setBatchNo(batchNo);
						hbt.save(storeItemBatchStock);
					}
				}
				storeInternalIndentM.setStatus("o");
				hbt.update(storeInternalIndentM);
				flag = true;
				
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> showInternalIssueReportLaundryJsp(Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session=getSession();
		try {
			Criteria c = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName"));
			masDepartmentList = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masDepartmentList", masDepartmentList);
		return map;

	}
	
}
