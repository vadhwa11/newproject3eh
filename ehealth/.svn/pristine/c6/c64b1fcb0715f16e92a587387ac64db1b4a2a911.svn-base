package jkt.hms.bloodBank.dataservice;

import static jkt.hms.util.RequestConstants.BLOOD_BAG_NO;
import static jkt.hms.util.RequestConstants.BLOOD_COMPONENT_ID;
import static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID;
import static jkt.hms.util.RequestConstants.COLLECTION_DATE;
import static jkt.hms.util.RequestConstants.DONER_NAME;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.EXPIRY_DATE;
import static jkt.hms.util.RequestConstants.GENDER;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.STOCK_NO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.BldCrossmatchBagDetail;
import jkt.hms.masters.business.BldCrossmatchDetail;
import jkt.hms.masters.business.BldCrossmatchingHeader;
import jkt.hms.masters.business.BloodAssessmentEntryM;
import jkt.hms.masters.business.BloodAssessmentEntryT;
import jkt.hms.masters.business.BloodConsent;
import jkt.hms.masters.business.BloodDiscardEntry;
import jkt.hms.masters.business.BloodDonationEntryDetail;
import jkt.hms.masters.business.BloodDonationEntryHeader;
import jkt.hms.masters.business.BloodDonorSampleScreeningDetail;
import jkt.hms.masters.business.BloodDonorSampleScreeningHeader;
import jkt.hms.masters.business.BloodIndentIssueM;
import jkt.hms.masters.business.BloodIndentIssueT;
import jkt.hms.masters.business.BloodIssueDetail;
import jkt.hms.masters.business.BloodIssueHeader;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.BloodOpeningStockDetail;
import jkt.hms.masters.business.BloodOpeningStockMain;
import jkt.hms.masters.business.BloodReactionEntry;
import jkt.hms.masters.business.BloodReactionEntryDetails;
import jkt.hms.masters.business.BloodRequestEntryDetail;
import jkt.hms.masters.business.BloodRequestEntryHeader;
import jkt.hms.masters.business.BloodResultEntryDetails;
import jkt.hms.masters.business.BloodResultEntryHeader;
import jkt.hms.masters.business.BloodSampleCollection;
import jkt.hms.masters.business.BloodSampleScreeningDetail;
import jkt.hms.masters.business.BloodSampleScreeningHeader;
import jkt.hms.masters.business.BloodStockDetail;
import jkt.hms.masters.business.BloodStockMain;
import jkt.hms.masters.business.BloodTestEntryDetail;
import jkt.hms.masters.business.BloodTestEntryHeader;
import jkt.hms.masters.business.BloodTransfusion;
import jkt.hms.masters.business.BloodTransfussionReactionDt;
import jkt.hms.masters.business.BloodTransfussionReactionHd;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAssessment;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasIdCard;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.OtBooking;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Distinct;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BloodBankDataServiceImpl extends HibernateDaoSupport implements
		BloodBankDataService {

	// ------------------------------Blood
	// Component-----------------------------
	@SuppressWarnings("unchecked") 
	public Map<String, Object> showBloodComponentJsp(int hospitalId,int departmentId) {
		Criteria crt=null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
		Date currentDate=new Date();
		Session session=(Session)getSession();
		//List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
		//List<Object[]> bagTypeList = new ArrayList<Object[]>();

		List<MasStoreItem> bloodBagsList = new ArrayList<MasStoreItem>();
	//	List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
		
		
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
        int itemTypeId=Integer.parseInt(prop.getProperty("bbitemTypeId"));
         departmentId=Integer.parseInt(prop.getProperty("departmentId"));
		String itemCategoryforBB="Blood";
        // System.out.println("hospitalId "+hospitalId);
        // System.out.println("departmentId "+departmentId);
       /* crt=session.createCriteria(StoreItemBatchStock.class)
        		.createAlias("Item", "item")
        		.createAlias("Hospital", "hosp")
        		.createAlias("Department", "dept")
        		  
        		.createAlias("item.ItemType", "ItemType")
				.add(Restrictions.eq("item.Status", "y").ignoreCase())
				.add(Restrictions.eq("ItemType.Id", itemTypeId))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("dept.Id", departmentId));*/
         // storeItemBatchStockList=crt.list();
		crt=session.createCriteria(MasStoreItem.class).createAlias("ItemType", "ItemType").createAlias("ItemCategory", "Itemcategory")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				//.add(Restrictions.eq("hosp.Id", hospitalId))
				//.add(Restrictions.eq("ItemType.Id", itemTypeId))
				.add(Restrictions.like("Itemcategory.ItemCategoryName", "%"+itemCategoryforBB + "%"));;
		bloodBagsList=crt.list();
		//System.out.println(" vvavava  "+bloodBagsList.size());
       // storeItemBatchStockList=crt.list();
		
      //  System.out.println("storeItemBatchStockList "+storeItemBatchStockList.size());
		crt=session.createCriteria(BloodMasComponent.class).
				add(Restrictions.eq("Status", "y").ignoreCase());
							
		
		searchBloodComponentList=crt.list();
		
		//map.put("storeItemBatchStockList", storeItemBatchStockList);
		map.put("bloodBagsList", bloodBagsList);
		map.put("searchBloodComponentList", searchBloodComponentList);
		//map.put("bagTypeList", bagTypeList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getBloodSampleCollectionDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		 Criteria crt= null;
		 BloodSampleCollection bloodSampleCollection=null;
		 String batchNo="";
		 String bagType="";
		 
		 int bldSampleId=box.getInt("samplId");
		 int hospitalId=box.getInt("hospitalId");
		 
		 Session session=(Session)getSession();
		 
		  crt=session.createCriteria(BloodSampleCollection.class)
				 .createAlias("Hospital", "bloodBankId")
				 .add(Restrictions.eq("bloodBankId.Id", hospitalId))
				 .add(Restrictions.eq("Id", bldSampleId))
				  .add(Restrictions.eq("AcceptedRejected", "y").ignoreCase());
		 
		 if(null !=crt && null !=crt.list() && null !=crt.list().get(0) && crt.list().size()>0){
			 bloodSampleCollection=(BloodSampleCollection)crt.list().get(0);
		 }
		/*BloodSampleCollection bloodSampleCollection =(BloodSampleCollection)getHibernateTemplate()
				.get(BloodSampleCollection.class, bldSampleId); */
		 map.put("bloodSampleCollection", bloodSampleCollection);
		 if(null !=bloodSampleCollection ){
		  batchNo=bloodSampleCollection.getStockBatchItem().getBatchNo();
		  bagType=bloodSampleCollection.getStockBatchItem().getItem().getNomenclature();
		 }
		 map.put("batchNo", batchNo);
		 map.put("bagType", bagType);
		return map;
	}
	
	public Map<String, Object> showBloodComponentJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session) getSession();
		List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
		/*searchBloodComponentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.BloodMasComponent where Id= ");*/
		Criteria crt=null;
		crt=session.createCriteria(BloodMasComponent.class).add(Restrictions.eq("Id", Id));
		searchBloodComponentList=crt.list();
		map.put("searchBloodComponentList", searchBloodComponentList);
		return map;
	}

	public boolean addBloodComponent(BloodMasComponent bloodMasComponent) {
		boolean successfullyAdded = false;
		Session session=(Session) getSession();
		Transaction tnx=null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		try{
			tnx=session.beginTransaction();
			hbt.setCheckWriteOperations(false);
			hbt.save(bloodMasComponent);
			successfullyAdded = true;
			session.flush();
			tnx.commit();
			
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		
		
		return successfullyAdded;
	}

	public boolean deleteBloodComponent(int bloodComponentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		BloodMasComponent bloodMasComponent = new BloodMasComponent();
		bloodMasComponent = (BloodMasComponent) getHibernateTemplate().get(
				BloodMasComponent.class, bloodComponentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				bloodMasComponent.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				bloodMasComponent.setStatus("y");
				dataDeleted = false;
			}
		}
		bloodMasComponent.setLastChgBy(changedBy);
		bloodMasComponent.setLastChgDate(currentDate);
		bloodMasComponent.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(bloodMasComponent);
		return dataDeleted;
	}

	public boolean editBloodComponent(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bloodComponentName = "";
		String bloodComponentCode = "";
		String changedBy = "";
		String wholeBlood = "";
		int bloodComponentId = 0;
		int qtyUnit = 0;
		int temperature = 0;
		int lifeSpan = 0;

		bloodComponentId = (Integer) generalMap.get("id");
		bloodComponentCode = (String) generalMap.get("bloodComponentCode");
		bloodComponentName = (String) generalMap.get("name");
		wholeBlood = (String) generalMap.get("wholeBlood");
		qtyUnit = (Integer) generalMap.get("qtyUnit");
		temperature = (Integer) generalMap.get("temperature");
		lifeSpan = (Integer) generalMap.get("lifeSpan");
		wholeBlood = (String) generalMap.get("wholeBlood");

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		BloodMasComponent bloodMasComponent = (BloodMasComponent) getHibernateTemplate()
				.get(BloodMasComponent.class, bloodComponentId);

		bloodMasComponent.setId(bloodComponentId);
		bloodMasComponent.setComponentName(bloodComponentName);
		bloodMasComponent.setLifeSpan(lifeSpan);
		bloodMasComponent.setQtyUnit(qtyUnit);
		bloodMasComponent.setTemperature(temperature);
		bloodMasComponent.setWholeBlood(wholeBlood);
		bloodMasComponent.setLastChgBy(changedBy);
		bloodMasComponent.setLastChgDate(currentDate);
		bloodMasComponent.setLastChgTime(currentTime);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(bloodMasComponent);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBloodComponent(String bloodComponentCode,
			String bloodComponentName) {
		List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
		Map bloodComponentFieldsMap = new HashMap();
		try {
			if ((bloodComponentName != null) || (bloodComponentCode == null)) {
				searchBloodComponentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.BloodMasComponent bmc where bmc.ComponentName like '"
								+ bloodComponentName
								+ "%' order by bmc.ComponentName");
			} else {
				searchBloodComponentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.BloodMasComponent mbg where mbg.ComponentCode like '"
								+ bloodComponentCode
								+ "%' order by mbg.ComponentCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bloodComponentFieldsMap.put("searchBloodComponentList",
				searchBloodComponentList);
		return bloodComponentFieldsMap;
	}

	public Map<String, Object> showPatientSearchForBloodTransfusionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		Session session = (Session) getSession();

		try {
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y")).list();
			map.put("rankList", rankList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getPatientForBloodTransfusion(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();

		String hinNo = "";
		String adNo = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}

		try {
			Criteria crit = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdStatus", "A"));
			if (!hinNo.equals("") || !patientFName.equals("")
					|| !patientLName.equals("")) {
				crit = crit.createAlias("Hin", "hn");
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PLastName", patientLName
						+ "%"));
			}
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.like("AdNo", adNo + "%"));
			}

			inpatientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("inpatientList", inpatientList);
		return map;
	}

	public int getTransfusionEntrySeqForDisplay(String string) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		int entrySeqNo = 0;
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "TEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();

			if (seqNoList.get(0) == null || seqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodTransfusion");
				tsObj.setTransactionPrefix("TEN");
				tsObj.setTransactionSequenceName("Entry No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				entrySeqNo = Integer.valueOf(1);
			} else if (seqNoList.get(0) != null) {
				maxSeqNo = seqNoList.get(0);
				entrySeqNo = Integer.valueOf(maxSeqNo + 1);

			} else {
				entrySeqNo = Integer.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	public Map<String, Object> showConsentBloodTransfusion(int inpatientId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		Session session = (Session) getSession();

		try {
			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (componentList.size() > 0) {
				detailsMap.put("componentList", componentList);
			}
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();
			if (inpatientList != null || inpatientList.size() > 0) {
				detailsMap.put("inpatientList", inpatientList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public int generateTransfusionEntryNumber() {
		int entrySeqNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "TEN")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (seqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : seqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				entrySeqNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(entrySeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			entrySeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodTransfusion");
			tsObj.setTransactionPrefix("TEN");
			tsObj.setTransactionSequenceName("Entry No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(entrySeqNo);
		}
		return entrySeqNo;
	}

	public boolean submitBloodTransfusion(BloodTransfusion bloodTransfusion) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(bloodTransfusion);
		successfullyAdded = true;
		return successfullyAdded;
	}

	// ------Blood Request Entry-------------------------------------

	// -----------------method for seaching patient-----
	public Map<String, Object> getPatientForBloodRequest(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<Patient> patientList = new ArrayList<Patient>();
		List<MasDistrict> districtList=new ArrayList<MasDistrict>();
		String hinNo = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;
		String address = "";
		String adNo = "";
		String pType = "";
		int hospitalId=0;

		Session session = (Session) getSession();

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		int districtId=0;
		if (mapForDs.get("districtId") != null) {
			districtId = (Integer) mapForDs.get("districtId");
		}
		
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		
		List<Patient> patientlist = new ArrayList<Patient>();
		
		
		Criteria crt=null;
		crt=session.createCriteria(Patient.class).createAlias("Hospital", "hosp")
				/*.add(Restrictions.eq("hosp.Id", hospitalId))*/
				.add(Restrictions.ne("PatientStatus", "Expired").ignoreCase());
		
		
		if (null != patientFName && !patientFName.equals("")) {
			crt.add(Restrictions.like("PFirstName", patientFName+"%"));
			
		}
		if (!hinNo.equals("")) {
			crt.add(Restrictions.eq("HinNo", hinNo));
			
		}
		if (null != pType && !pType.equals("")) {
			crt.add(Restrictions.eq("PatientStatus", pType));
			
		}
		patientlist=crt.list();
		
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	        Properties prop = new Properties();
	        
	        try {
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
			} catch (Exception e1) {
				
				e1.printStackTrace();
			} 
	       
	        
	        int stateId=Integer.parseInt(prop.getProperty("stateId"));
	     // System.out.println("districtList "+stateId);
			districtList = session.createCriteria(MasDistrict.class)
					.addOrder(Order.asc("DistrictName"))
					.add(Restrictions.eq("State.Id", stateId))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			 
		System.out.println("districtList   "+districtList.size());
		map.put("patientList", patientlist);
		map.put("districtList", districtList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getComponentNameForAutoComplete(
			Map<String, Object> parameterMap) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodMasComponent> bloodComponentList = new ArrayList<BloodMasComponent>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}

		bloodComponentList = session.createCriteria(BloodMasComponent.class)
				.add(Restrictions.like("ComponentName", str).ignoreCase())
				.add(Restrictions.like("Status", "y").ignoreCase()).list();

		if (bloodComponentList.size() > 0) {
			detailsMap.put("componentList", bloodComponentList);
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getComponentNameSeparationForAutoComplete(
			Map<String, Object> parameterMap) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodMasComponent> bloodComponentList = new ArrayList<BloodMasComponent>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}

		bloodComponentList = session.createCriteria(BloodMasComponent.class)
				.add(Restrictions.like("ComponentName", str))
				.add(Restrictions.like("Status", "y"))
				.add(Restrictions.eq("WholeBlood", "n")).list();

		if (bloodComponentList.size() > 0) {
			detailsMap.put("componentList", bloodComponentList);
		}
		return detailsMap;
	}

	// ------------method for component name for Auto Complete...........
	public Map<String, Object> fillItemsForComponentname(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List componentList = new ArrayList();
		List<BloodMasComponent> bloodcomponentList = new ArrayList<BloodMasComponent>();
		Session session = (Session) getSession();
		String componentName = (String) dataMap.get("componentName");
		
		int bloodBankName=0;
		int bloodGroupId=0;
		
		bloodBankName=(Integer) dataMap.get("bloodBankName");
		bloodGroupId=(Integer) dataMap.get("bloodGroupId");
		
		System.out.println("componentName@@@ "+componentName);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Criteria crt=null;

			crt = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.like("ComponentName", componentName +"%").ignoreCase());
			componentList=crt.list();
			bloodcomponentList=crt.list();
			map.put("componentList", componentList);
			
			int componentId=0;
			for (BloodMasComponent bloodMasComponent : bloodcomponentList) {
				
				componentId=bloodMasComponent.getId();
			}
			List<BloodStockDetail> bloodstockDetailList = new ArrayList<BloodStockDetail>();
			crt = session.createCriteria(BloodStockDetail.class)
					.createAlias("Component","Component")
					.createAlias("StockMain", "StockMain")
					.add(Restrictions.eq("Component.Id", componentId))
					.add(Restrictions.eq("StockMain.BloodGroup.Id", bloodGroupId))
					.add(Restrictions.eq("StockMain.Hospital.Id", bloodBankName));
			bloodstockDetailList=crt.list();
			int availableStock=0;
			if(null !=bloodstockDetailList && bloodstockDetailList.size()>0){
				for(BloodStockDetail bsd:bloodstockDetailList){
					availableStock=bsd.getQty();
				}
			}
			map.put("availableStock", availableStock);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (componentList.size() > 0) {
				detailsMap.put("componentList", componentList);
			}
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodRequestEntryJsp(int hinId, String pTye) {
		System.out.println(" hinId "+hinId);
		String ipNumber="";
		int inPatientId=0;
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatient=new ArrayList<Inpatient>(); 
		List<MasBloodGroup> componentList = new ArrayList<MasBloodGroup>();
		List<MasHospital> bloodBankList=new ArrayList<MasHospital>();
		List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
		List<Inpatient>ipList=new ArrayList<Inpatient>();
		List<Visit>visitList=new ArrayList<Visit>();
		Session session = (Session) getSession();
		List<String>aList=new ArrayList<String>();
		aList.add("A");
		aList.add("R");
		int inpatientId=0;
		String icdName="";
		try {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
			for(Patient pt:patientList){
				pTye=pt.getPatientStatus();
			}
			bloodBankList=session.createCriteria(MasHospital.class).add(Restrictions.eq("BbAvailable", "Y").ignoreCase()).list();
		

			ipList=session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id", hinId)).add(Restrictions.in("AdStatus", aList)).list();
			for(Inpatient ip:ipList){
				
			}
			
			visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", hinId)).list();
			List<String>icdList1=new ArrayList<String>();
			
			if(pTye.equals("In Patient")){

				for(Inpatient ip:ipList){
					
					icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Inpatient.Id",ip.getId())).add(Restrictions.eq("DiagnosisStatus","p").ignoreCase()).list();
					for(DischargeIcdCode dsc:icdList){
						icdName=icdName.concat(dsc.getIcd().getIcdName()).concat(" ,");
					}
					
					
				}
				
			}else if(pTye.equalsIgnoreCase("Out Patient")){
			for(Visit visit:visitList){
				
				icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Visit.Id",visit.getId())).add(Restrictions.eq("DiagnosisStatus","p").ignoreCase()).list();
				for(DischargeIcdCode dsc:icdList){
					icdName=icdName.concat(dsc.getIcd().getIcdName()).concat(" ,");
				}
				
				
			}
			}
			
			componentList = session.createCriteria(MasBloodGroup.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (componentList.size() > 0) {
				detailsMap.put("componentList", componentList);
			}
			
			if (patientList != null || patientList.size() > 0) {
				detailsMap.put("patientList", patientList);
			}
			if(hinId>0){
				
				    
			inpatient=(List<Inpatient>) session.createCriteria(Inpatient.class).
					createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", hinId)).list();
						
						
			for(Inpatient ipatient: inpatient){
				ipNumber=ipatient.getAdNo();
				inPatientId=ipatient.getId();
				
				
			}
			detailsMap.put("ipNumber", ipNumber);
			detailsMap.put("inPatientId", inPatientId);
			detailsMap.put("bloodBankList", bloodBankList);
			detailsMap.put("icdName", icdName);
			}
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public String getOrderSeqForDisplay(String string,int hospitalId) {
		List<Object[]> orderSeqNoList = new ArrayList<Object[]>();
		List<BloodRequestEntryHeader> seqNoList = new ArrayList<BloodRequestEntryHeader>();
		String orderSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";
		Date lastChangedate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1=new Date();
		/*String curDate=sdf.format(date);*/
		Date currentDate = null;
		int tsn = 0;
		int id = 0;

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		

		try {
			seqNoList = session.createCriteria(BloodRequestEntryHeader.class)
					.list();
			
			if (seqNoList.size() > 0) {
				for (BloodRequestEntryHeader requestEntryHeader : seqNoList) {
					lastSeqNo = requestEntryHeader.getOrderNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
					
				}
				
			} 
			else {
				
				lastSeqYear = currentYear;
				
			}

			/*orderSeqNoList = session
					.createCriteria(TransactionSequence.class).createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("TransactionPrefix", "RON"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();*/
			
			System.out.println("hospitalId   "+hospitalId);
		 orderSeqNoList = session
					.createCriteria(TransactionSequence.class).createAlias("Hospital", "hosp")
					.add(Restrictions.eq("TransactionPrefix", "RON"))
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.setProjection(Projections.projectionList()
							.add(Projections.property("TransactionSequenceNumber"))
							.add(Projections.property("LastChgDate"))
							.add(Projections.property("Id")))
					.list();
			System.out.println("orderSeqNoList   "+orderSeqNoList.size());
			if (null==orderSeqNoList &&   orderSeqNoList.size() == 0) {
				//System.out.println("orderSeqNoListhhhh "+orderSeqNoList.size());
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BldRequestHeader");
				tsObj.setTransactionPrefix("RON");
				tsObj.setTransactionSequenceName("Order No");
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hosp=new MasHospital();
				hosp.setId(hospitalId);
				tsObj.setHospital(hosp);
				hbt.save(tsObj);
				orderSeqNo = String.valueOf(1);
			} 
			if (orderSeqNoList.size() > 0) {
				Object[] transactionSequence = orderSeqNoList.get(0);
				tsn = Integer.parseInt("" + transactionSequence[0]);
				id = (Integer) transactionSequence[2];
				TransactionSequence transactionSequenceObj = (TransactionSequence) session
						.load(TransactionSequence.class, id);
				// transactionSequenceObj.setTransactionSequenceNumber(1); 
				transactionSequenceObj.setTransactionSequenceNumber(tsn+1); 
				transactionSequenceObj.setLastChgDate(date1);
				hbt.update(transactionSequenceObj);
				orderSeqNo=String.valueOf(tsn+1);
				
			}	
		
			orderSeqNo = orderSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return orderSeqNo;
	}

	@SuppressWarnings("unchecked")
	public String generateOrderNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String orderSeqNo = "";
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodRequestEntryHeader> seqNoList = new ArrayList<BloodRequestEntryHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodRequestEntryHeader.class)
				.list();
		if (seqNoList.size() > 0) {
			for (BloodRequestEntryHeader requestEntryHeader : seqNoList) {
				lastSeqNo = requestEntryHeader.getOrderNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		orderSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "RON")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
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
				orderSeqNo = orderSeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BldRequestHeader");
			tsObj.setTransactionPrefix("RON");
			tsObj.setTransactionSequenceName("Order No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			orderSeqNo = orderSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return orderSeqNo;
	}

	public boolean submitBloodRequestEntry(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		BloodRequestEntryHeader bloodEntryHeader = new BloodRequestEntryHeader();
		List componentList = new ArrayList();
		Box box = null;
		int componentMainIdFromRequest = 0;
		int BloodhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String orderSeqNo = "";
		Vector quantity = null;
		Vector req_date = null;
		Vector bloodComponentId=null;
		int size=0;
		if (infoMap.get("size") != null) {
			size = (Integer) infoMap.get("size");
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) infoMap.get("orderSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		
	
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		Session session = (Session) getSession();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		


		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
				if(size>0){
					for(int i=1;i<=size;i++){
					
						if (infoMap.get("bloodEntryHeader"+i) != null) {
							bloodEntryHeader = (BloodRequestEntryHeader) infoMap
									.get("bloodEntryHeader"+i);
						}
						if (infoMap.get("quantity"+i) != null) {
							quantity = (Vector) infoMap.get("quantity"+i);
						}
						if (infoMap.get("req_date"+i) != null) {
							req_date = (Vector) infoMap.get("req_date"+i);
						}
						
						if (infoMap.get("componentMainIdFromRequest"+i) != null) {
							componentMainIdFromRequest = (Integer) infoMap
									.get("componentMainIdFromRequest"+i);	
						}
						
						
						if (infoMap.get("bloodEntryHeader"+i) != null) {
							bloodEntryHeader = (BloodRequestEntryHeader) infoMap
									.get("bloodEntryHeader"+i);
							bloodEntryHeader.setCrossMatchStatus("P");
							hbt.save(bloodEntryHeader);
							BloodhdId = bloodEntryHeader.getId();
							map.put("BloodhdId"+i, BloodhdId);
						} else {

							BloodRequestEntryHeader bloodEntryHeaderObj = new BloodRequestEntryHeader();
							bloodEntryHeaderObj = (BloodRequestEntryHeader) hbt.load(
									BloodRequestEntryHeader.class,
									componentMainIdFromRequest);
							hbt.update(bloodEntryHeaderObj);
						}
						if (infoMap.get("componentList"+i) != null) {
							componentList = (List) infoMap.get("componentList"+i);
						    
						}
							if (componentList.size() > 0) {
								for (int j =0; j < componentList.size(); j++) {

									BloodRequestEntryDetail bloodEntryDetail = new BloodRequestEntryDetail();
									BloodMasComponent bloodMasComponent = new BloodMasComponent();

									try {
										int z=i-1;
										if (componentList.get(z) != null
												&& !componentList.get(z).equals("")) {
											int componentId = Integer
													.parseInt(componentList.get(z)
															.toString());
											bloodMasComponent.setId(componentId);
											bloodEntryDetail
													.setComponent(bloodMasComponent);
										
											if (quantity != null && !quantity.equals("")) {
												bloodEntryDetail
														.setQty(Integer
																.parseInt((String) quantity
																		.get(j)));
											}
											if(null !=req_date.get(j))
											bloodEntryDetail.setReqDate(HMSUtil.convertStringTypeDateToDateType((String) req_date.get(j)));
											
											bloodEntryDetail.setLastChgBy(userName);
											bloodEntryDetail.setLastChgDate(date);
											bloodEntryDetail.setLastChgTime(time);
											if (infoMap.get("bloodEntryHeader"+i) != null) {
												bloodEntryDetail
														.setRequest(bloodEntryHeader);

											} else {
												BloodRequestEntryHeader entryHeader = new BloodRequestEntryHeader();
												entryHeader
														.setId(componentMainIdFromRequest);
												bloodEntryDetail.setRequest(entryHeader);
											}
											hbt.save(bloodEntryDetail);
											saved = true;
										}

									} catch (RuntimeException e) {
										
									}

								}
							}
							
						
					}
				}
			
			/*hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("bloodEntryHeader") != null) {
				bloodEntryHeader = (BloodRequestEntryHeader) infoMap
						.get("bloodEntryHeader");
				bloodEntryHeader.setCrossMatchStatus("P");
				hbt.save(bloodEntryHeader);
				BloodhdId = bloodEntryHeader.getId();
				map.put("BloodhdId", BloodhdId);
			} else {

				BloodRequestEntryHeader bloodEntryHeaderObj = new BloodRequestEntryHeader();
				bloodEntryHeaderObj = (BloodRequestEntryHeader) hbt.load(
						BloodRequestEntryHeader.class,
						componentMainIdFromRequest);
				hbt.update(bloodEntryHeaderObj);
			}
			if (infoMap.get("componentList") != null) {
				componentList = (List) infoMap.get("componentList");
				if (componentList.size() > 0) {
					for (int i = 0; i < componentList.size(); i++) {

						BloodRequestEntryDetail bloodEntryDetail = new BloodRequestEntryDetail();
						BloodMasComponent bloodMasComponent = new BloodMasComponent();

						try {
							if (componentList.get(i) != null
									&& !componentList.get(i).equals("")) {
								int componentId = Integer
										.parseInt(componentList.get(i)
												.toString());
								bloodMasComponent.setId(componentId);
								bloodEntryDetail
										.setComponent(bloodMasComponent);

								if (quantity != null && !quantity.equals("")) {
									bloodEntryDetail
											.setQty(Integer
													.parseInt((String) quantity
															.get(i)));
								}
								if(null !=req_date.get(i))
								bloodEntryDetail.setReqDate(HMSUtil.convertStringTypeDateToDateType((String) req_date.get(i)));
								
								bloodEntryDetail.setLastChgBy(userName);
								bloodEntryDetail.setLastChgDate(date);
								bloodEntryDetail.setLastChgTime(time);
								if (infoMap.get("bloodEntryHeader") != null) {
									bloodEntryDetail
											.setRequest(bloodEntryHeader);

								} else {
									BloodRequestEntryHeader entryHeader = new BloodRequestEntryHeader();
									entryHeader
											.setId(componentMainIdFromRequest);
									bloodEntryDetail.setRequest(entryHeader);
								}
								hbt.save(bloodEntryDetail);
								saved = true;
							}

						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}*/
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return saved;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodDonationEntryJsp(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		String uhidNo = box.get("donoruhid");
		int hospitalId=box.getInt("hospitalId");
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
       
        
        int stateId=Integer.parseInt(prop.getProperty("stateId"));
      

		List<BloodMasComponent> searchBloodDonationEntryList = new ArrayList<BloodMasComponent>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasPostCode> postcodeList = new ArrayList<MasPostCode>();
		List<MasVillage> villageList = new ArrayList<MasVillage>();
		List<MasLsg> lsgList = new ArrayList<MasLsg>();
		List<MasIdCard> idList = new ArrayList<MasIdCard>();
		List<BloodDonationEntryHeader> donorDetails = null;
		donorDetails = new ArrayList<BloodDonationEntryHeader>();
		
		boolean donorStatus=false;
		
		List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();

	donorDetails = session
				.createCriteria(BloodDonationEntryHeader.class).createAlias("Hospital", "hosp")
				.add(Restrictions.eq("hosp.Id", hospitalId))
				
				.add(Restrictions.eq("DonationNo", uhidNo).ignoreCase()).list();
		if(null !=donorDetails && donorDetails.size()>0){
			donorStatus=true;
			
		}
	
		

		lsgList = session.createCriteria(MasLsg.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		idList = session.createCriteria(MasIdCard.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		stateList = session.createCriteria(MasState.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		
		searchBloodDonationEntryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.BloodMasComponent ");

		
		
		
		occupationList = session.createCriteria(MasOccupation.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.like("Status", "y").ignoreCase())
				.createAlias("Department", "dept")
				.createAlias("dept.DepartmentType", "deptType")
				.add(Restrictions.eq("deptType.Id", 24)).list();
		
		bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		talukList = session.createCriteria(MasTaluk.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		districtList = session.createCriteria(MasDistrict.class).createAlias("State", "state")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("state.Id", stateId)).list();
				
		postcodeList = session.createCriteria(MasPostCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		/*villageList = session.createCriteria(MasVillage.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
		
		
		
		
		Date current=new Date();
		System.out.println("current"+current);
		Criteria crit = null;
		Criteria criteriaCount = null;
		if (null != donorList) {
			donorList.clear();
		}
		
			crit = session.createCriteria(BloodDonationEntryHeader.class).createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.isNull("AssessmetStatus"))
					.add(Restrictions.eq("RegistrationDate", current));
			
			donorList = crit.list();
			map.put("donorList", donorList);	

		map.put("donorStatus", donorStatus)	;
		map.put("donationList", donorDetails);
		
		map.put("idList", idList);
		map.put("lsgList", lsgList);
		map.put("sexList", sexList);
		map.put("employeeList", employeeList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("stateList", stateList);
		map.put("talukList", talukList);
		map.put("villageList", villageList);
		map.put("postcodeList", postcodeList);
		map.put("districtList", districtList);
		map.put("occupationList", occupationList);
		map.put("searchBloodDonationEntryList", searchBloodDonationEntryList);
		return map;
	}

	public Map<String, Object> getDetailsForSampleCollection() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getSampleCollectionGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> patientDetailList = new ArrayList<BloodRequestEntryHeader>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodRequestEntryHeader.class)
					.add(Restrictions.eq("RequestStatus", "P"))
					.add(Restrictions.eq("OrderDate", currentDate));
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBloodSampleCollectionDetails(Map orderMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodRequestEntryHeader> requesthdList = new ArrayList<BloodRequestEntryHeader>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			if (orderMap != null && orderMap.size() > 0) {
				requesthdList = session
						.createCriteria(BloodRequestEntryHeader.class)
						.add(Restrictions.eq("RequestStatus", "P"))
						.add(Restrictions.eq("Id",
								(Integer) orderMap.get("requestId"))).list();
			}
			if (requesthdList != null && requesthdList.size() > 0) {
				detailsMap.put("requesthdList", requesthdList);

				hinId = requesthdList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getPatientDetailSampleCollection(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> patientDetailList = new ArrayList<BloodRequestEntryHeader>();

		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		String patientFName = "";
		String patientLName = "";
		String adNo = "";
		String pType = "";

		int departmentId = 0;

		Criteria crit = null;
		Session session = (Session) getSession();

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}

		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}

		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		try {

			crit = session.createCriteria(BloodRequestEntryHeader.class)
					.add(Restrictions.eq("RequestStatus", "P"))
					.add(Restrictions.between("OrderDate", fromDate, toDate));

			if (!adNo.equals("")) {

				crit = crit.createAlias("Inpatient", "pt").add(
						Restrictions.like("pt.AdNo", adNo + "%"));
				if (departmentId != 0) {
					crit = crit.createAlias("pt.Department", "dp").add(
							Restrictions.eq("dp.Id", departmentId));
				}
			}
			if (!hinNo.equals("") || !patientFName.equals("")
					|| !patientLName.equals("") || !pType.equals("")) {
				crit = crit.createAlias("Hin", "hn");

			}

			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PLastName", patientLName
						+ "%"));
			}

			if (!pType.equals("")) {
				if (pType.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("hn.PatientStatus",
							"In Patient"));
				} else if (pType.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("hn.PatientStatus",
							"Out Patient"));
				}
			}
			patientDetailList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public String getSampleCollectionSeqForDisplay(String string) {
		List<Integer> collectionSeqNoList = new ArrayList<Integer>();
		List<BloodSampleCollection> seqNoList = new ArrayList<BloodSampleCollection>();
		String collectionSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(BloodSampleCollection.class)
					.list();
			if (seqNoList.size() > 0) {
				for (BloodSampleCollection bloodSampleCollection : seqNoList) {
					lastSeqNo = bloodSampleCollection.getSampleCollectionNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			collectionSeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "SCN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (collectionSeqNoList.get(0) == null
					|| collectionSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodSampleCollection");
				tsObj.setTransactionPrefix("SCN");
				tsObj.setTransactionSequenceName("SampleCollection No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				collectionSeqNo = String.valueOf(1);
			} else if (collectionSeqNoList.size() > 0) {
				for (Integer maxOrderNo : collectionSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						collectionSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						collectionSeqNo = String.valueOf(1);
					}
				}
			} else {
				collectionSeqNo = String.valueOf(1);
			}
			collectionSeqNo = collectionSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return collectionSeqNo;
	}

	public String generateSampleCollectionNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String collectionSeqNo = "";
		List<TransactionSequence> collectionSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodSampleCollection> seqNoList = new ArrayList<BloodSampleCollection>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodSampleCollection.class).list();
		if (seqNoList.size() > 0) {
			for (BloodSampleCollection bloodSampleCollection : seqNoList) {
				lastSeqNo = bloodSampleCollection.getSampleCollectionNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		collectionSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "SCN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (collectionSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : collectionSeqNoList) {
				TransactionSequence obj = (TransactionSequence) collectionSeqNoList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

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
				collectionSeqNo = seqNo.toString().concat("/")
						.concat(String.valueOf(lastSeqYear));
			}
		} else if (collectionSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodSampleCollection");
			tsObj.setTransactionPrefix("SCN");
			tsObj.setTransactionSequenceName("SampleCollection No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			collectionSeqNo = collectionSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return collectionSeqNo;
	}

	public Map<String, Object> getSampleCollectionDetailsForNext(
			int newRequestId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> submitBloodSampleCollection(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;

		int hospitalId = 0;
		String userName = "";
		String buttonName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		if (box.get("buttonName") != null) {
			buttonName = box.get("buttonName");
		}

		if (box.getInt("hospitalId") > 0) {
			hospitalId = box.getInt("hospitalId");
		}
		if (box.get("userName") != null) {
			userName = (String) box.get("userName");
		}
		int masStoreId=0;
		if (box.get("typeOfbag") != null) {
			masStoreId =  box.getInt("typeOfbag");
		}
		int batchStockId=0;
		
		if (box.get("batchNumber") != null) {
			batchStockId =  box.getInt("batchNumber");
		}
				

		BloodSampleCollection bloodSampleCollection = new BloodSampleCollection();
		HibernateTemplate hbt = getHibernateTemplate();
		/*
		 * Users user=new Users(); user.setLastChgBy(userName);
		 */
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int donorSampleCollectionId=0;
		int donorSequenceId=0;
		String bagNo="";
		try {
			
			 donorSequenceId = box.getInt("donorSequenceId");
			String reason = null;
			long pulse = box.getInt("pulse");
			String remark = reason = box.get("remark");
			 bagNo = box.get("bagNumber");
			String tubNo = box.get("tubeNumber");
			long systolic = box.getInt("systolic");
			long diastolic = box.getInt("diastolic");
			String processStatus = box.get("status");
			int bldcomponent=box.getInt("bldcomponent");
			
			BloodMasComponent bldComponent=new BloodMasComponent();
			bldComponent.setId(bldcomponent);
			
			int bldComponentquntity=box.getInt("bldComponentquntity");
			
			String quntity = null;
			if (null != processStatus && !processStatus.isEmpty()
					&& processStatus.equalsIgnoreCase("n")) {
				reason = box.get("reason");
			}
			if (null != processStatus && !processStatus.isEmpty()
					&& processStatus.equalsIgnoreCase("Y")) {
				quntity = box.get("quntity");
			}
			int hinId = box.getInt(HIN_ID);

			int collectedBy = box.getInt(EMPLOYEE_ID);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			bloodSampleCollection.setHospital(hospital);
			String batchNo=box.get("batchNumber");
			int typeOfbag=0;
			typeOfbag=box.getInt("typeOfbag");
			System.out.println("typeOfbag typeOfbag  "+typeOfbag);
			
			String exdate=box.get("ExpiryDate");
			String bagExdate=box.get("bagExpiryDate");
			
			
			Criteria crt=session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "Item")
					.add(Restrictions.eq("Id",Integer.parseInt(batchNo) ))
					.add(Restrictions.eq("Item.Id", typeOfbag));
			List<StoreItemBatchStock> stockList=crt.list();
			
			if(null !=stockList && stockList.size()>0 && typeOfbag>0){
				for(StoreItemBatchStock ss:stockList){
					StoreItemBatchStock stock=new StoreItemBatchStock();
					stock.setId(ss.getId());
				bloodSampleCollection.setStockBatchItem(stock);
				bloodSampleCollection.setBatchNo(stock.getBatchNo());
				//bloodAssessmentEntryM.setItemBatchStock(store);
				}
			}
			/*if(typeOfbag>0){
				
			}*/
			bloodSampleCollection.setSampleExpiryDate(HMSUtil.convertStringTypeDateToDateType(exdate));
			bloodSampleCollection.setBagExpiryDate(HMSUtil.convertStringTypeDateToDateType(bagExdate));
			/*
			 * MasEmployee masEmployee = new MasEmployee();
			 * masEmployee.setId(collectedBy);
			 * bloodSampleCollection.setCollectedBy(masEmployee);
			 */

			bloodSampleCollection.setBagNumber(bagNo);
			bloodSampleCollection.setAcceptedRejected(processStatus);
			bloodSampleCollection.setRemarks(remark);
			bloodSampleCollection.setReasonForProcessIncomplete(reason);
			if (null != processStatus && !processStatus.isEmpty()
					&& processStatus.equalsIgnoreCase("Y")) {
				/*bloodSampleCollection.setQuantityCollected(new BigDecimal(
						quntity));*/
				bloodSampleCollection.setComponent(bldComponent);
				bloodSampleCollection.setComponentQuantity(bldComponentquntity);
			}

			bloodSampleCollection.setTubeNumber(tubNo);
			bloodSampleCollection.setPulse(pulse);
			bloodSampleCollection.setBpDiastollic(diastolic);
			bloodSampleCollection.setBpSystollic(systolic);
			//bloodSampleCollection.setSampleCollectionNo(generateSampleCollectionNumber());
			//code by rajat singh 
			bloodSampleCollection.setSampleCollectionNo(bagNo);
			if (null != buttonName && !buttonName.equals("")
					&& buttonName.equalsIgnoreCase("Discard Blood")) {
				bloodSampleCollection.setSampleStatus("I");
			} else {
				bloodSampleCollection.setSampleStatus("B");
			}

			bloodSampleCollection.setSampleCollectionDate(date);
			bloodSampleCollection.setSampleCollectionTime(time);
			// bloodSampleCollection.setLastChgBy(user);
			bloodSampleCollection.setLastChgDate(date);
			bloodSampleCollection.setLastChgTime(time);
			BloodDonationEntryHeader donationEntry = new BloodDonationEntryHeader();
			donationEntry.setId(donorSequenceId);
			bloodSampleCollection.setDonation(donationEntry);
			hbt.save(bloodSampleCollection);
			donorSampleCollectionId=bloodSampleCollection.getId();
			Criteria criteria = session.createCriteria(BloodAssessmentEntryM.class).createAlias("BloodBank", "hosp")
					.createAlias("Donation", "Donation")
					.add(Restrictions.eq("BldCollectionStatus", "P").ignoreCase())
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("Donation.Id", donorSequenceId))
					.add(Restrictions.eq("AssessmentDate", new Date()));
			/*criteria.add(Restrictions.eq("PhysicalExam", "N"));*/

			BloodAssessmentEntryM bloodAssessmentEntry = (BloodAssessmentEntryM) criteria
					.list().get(0);
			bloodAssessmentEntry.setPhysicalExam("Y");
			bloodAssessmentEntry.setBldCollectionStatus("Y");

			hbt.update(bloodAssessmentEntry);
			
			
			StoreItemBatchStock storeItembatchStock=(StoreItemBatchStock) session.load(StoreItemBatchStock.class,batchStockId);
			//.createAlias("Item","item").add(Restrictions.eq("item.Id", masStoreId))
			//.add(Restrictions.eq("Id", batchStockId));
			
			//StoreItemBatchStock storeItembatchStock=(StoreItemBatchStock) crty.list().get(0);
			BigDecimal openning_balance_qty=storeItembatchStock.getOpeningBalanceQty();
			BigDecimal isuuedQuanty=new BigDecimal(0);
			 isuuedQuanty=storeItembatchStock.getIssueQty();

				System.out.println("isuuedQuanty "+isuuedQuanty);
				
			if(null ==isuuedQuanty ){
				storeItembatchStock.setIssueQty((new BigDecimal(1)));
				storeItembatchStock.setClosingStock(openning_balance_qty.subtract(new BigDecimal(1)));
			}
			else{
				storeItembatchStock.setIssueQty((isuuedQuanty.add(new BigDecimal(1))));
				storeItembatchStock.setClosingStock(openning_balance_qty.subtract((isuuedQuanty.add(new BigDecimal(1)))));
			}
			hbt.update(storeItembatchStock);
			hbt.refresh(bloodAssessmentEntry);
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		map.put("donorSequenceId", donorSequenceId);
		map.put("donorSampleCollectionId", donorSampleCollectionId);
		
		map.put("bagNo", bagNo);
		map.put("saved", saved);
		return map;
	}
	public Map<String, Object> submitSampleOfBlood(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false; 
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		int sampleId = box.getInt("sampleId");
		int userId = box.getInt("userId");
		String remark=box.getString("sampleRemarks");
		Session session = (Session) getSession(); 
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate); 
		BloodSampleCollection collection=null;
		try { 
			HibernateTemplate hbt = getHibernateTemplate(); 
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false); 
			 collection=hbt.load(BloodSampleCollection.class, sampleId);
			collection.setBloodSampleDate(date);
			collection.setBloodSampleTime(time);
			Users users=new Users(userId);
			collection.setBloodSampleCollectedBy(users);
			collection.setBloodSampleRemarks(remark);
			collection.setSampleStatus("P");  
			collection.setSampleCrossCheckStatus("P");
			hbt.saveOrUpdate(collection); 
			hbt.flush();
			hbt.clear();  
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 
		map.put("saved", saved);
		map.put("bloodSampleCollection", collection);
		return map;
	}

	public Map<String, Object> showBloodSampleColletionJsp(int requestId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodRequestEntryHeader> requesthdList = new ArrayList<BloodRequestEntryHeader>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			requesthdList = session
					.createCriteria(BloodRequestEntryHeader.class)
					.add(Restrictions.eq("RequestStatus", "P"))
					.add(Restrictions.eq("Id", requestId)).list();
			if (requesthdList != null && requesthdList.size() > 0) {
				detailsMap.put("requesthdList", requesthdList);

				hinId = requesthdList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getDetailsForSampleValidation() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getPatientDetailSampleValidation(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();

		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		int departmentId = 0;
		String patientFName = "";
		String patientLName = "";
		String adNo = "";
		String pType = "";

		Criteria crit = null;
		Session session = (Session) getSession();
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		try {
			crit = session
					.createCriteria(BloodSampleCollection.class)
					.add(Restrictions.eq("SampleStatus", "P"))
					.add(Restrictions.between("SampleCollectionDate", fromDate,
							toDate));
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.like("ip.AdNo", adNo + "%"));

				if (departmentId != 0) {
					crit = crit.createAlias("Inpatient", "ip")
							.createAlias("ip.Department", "dept")
							.add(Restrictions.eq("dept.Id", departmentId));
				}
			}
			if (!hinNo.equals("") || !patientFName.equals("")
					|| !patientLName.equals("") || !pType.equals("")) {
				crit = crit.createAlias("Hin", "pt");

			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PLastName", patientLName
						+ "%"));
			}
			if (!pType.equals("")) {
				if (pType.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"In Patient"));
				} else if (pType.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"Out Patient"));
				}
			}
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> getSampleValidationGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodSampleCollection.class)
					.add(Restrictions.eq("SampleStatus", "P"))
					.add(Restrictions.eq("SampleCollectionDate", currentDate));
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> showBloodSampleValidationJsp(int sampleId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodSampleCollection> sampleList = new ArrayList<BloodSampleCollection>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			sampleList = session.createCriteria(BloodSampleCollection.class)
					.add(Restrictions.eq("SampleStatus", "P"))
					.add(Restrictions.eq("Id", sampleId)).list();
			if (sampleList != null && sampleList.size() > 0) {
				detailsMap.put("sampleList", sampleList);

				hinId = sampleList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public boolean submitBloodSampleValidation(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String dateTime = (String) utilMap.get("dateTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Map<String, Object> date1 = HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		Session session = (Session) getSession();
		boolean updatedSuccessfully = false;
		Box box = null;
		String userName = "";
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}

		int sampleCollectionId = (Integer) box.getInt("sampleCollectionId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			BloodSampleCollection sampleCollection = (BloodSampleCollection) hbt
					.load(BloodSampleCollection.class, sampleCollectionId);
			int employeeId = box.getInt(EMPLOYEE_ID);
			String remarks = box.getString(REMARKS);
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				sampleCollection.setValidatedBy(masEmployee);
			}
			String acceptedRejected = box.getString(SELECTED_RADIO);
			sampleCollection.setSampleValidationDate(date);
			sampleCollection.setSampleValidationTime(time);
			sampleCollection.setRemarks(remarks);
			/* sampleCollection.setLastChgBy(userName); */
			sampleCollection.setLastChgDate(date);
			sampleCollection.setLastChgTime(time);
			sampleCollection.setSampleStatus("V");
			sampleCollection.setAcceptedRejected(acceptedRejected);
			hbt.saveOrUpdate(sampleCollection);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		updatedSuccessfully = true;
		return updatedSuccessfully;
	}

	public Map<String, Object> getPatientDetailBloodSampleScreening(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();

		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		String patientFName = "";
		String patientLName = "";
		String adNo = "";
		String pType = "";
		int hinId = 0;
		int departmentId = 0;

		Criteria crit = null;
		Session session = (Session) getSession();
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		try {
			crit = session
					.createCriteria(BloodSampleCollection.class)
					.add(Restrictions.eq("SampleStatus", "V"))
					.add(Restrictions.between("SampleValidationDate", fromDate,
							toDate));
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.like("ip.AdNo", adNo + "%"));

				if (departmentId != 0) {
					crit = crit.createAlias("Inpatient", "ip")
							.createAlias("ip.Department", "dept")
							.add(Restrictions.eq("dept.Id", departmentId));
				}
			}
			if (!hinNo.equals("") || !patientFName.equals("")
					|| !patientLName.equals("") || !pType.equals("")) {
				crit = crit.createAlias("Hin", "pt");

			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PLastName", patientLName
						+ "%"));
			}

			if (!pType.equals("")) {
				if (pType.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"In Patient"));
				} else if (pType.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"Out Patient"));
				}
			}
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public String getSampleTestSeqForDisplay(String string) {
		List<Integer> testSeqNoList = new ArrayList<Integer>();
		List<BloodSampleScreeningHeader> seqNoList = new ArrayList<BloodSampleScreeningHeader>();
		String testSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session
					.createCriteria(BloodSampleScreeningHeader.class).list();
			if (seqNoList.size() > 0) {
				for (BloodSampleScreeningHeader screeningHeader : seqNoList) {
					lastSeqNo = screeningHeader.getSampleTestNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			testSeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "STN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();

			if (testSeqNoList.get(0) == null || testSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BldScreeningHeader");
				tsObj.setTransactionPrefix("STN");
				tsObj.setTransactionSequenceName("SampleTest No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				testSeqNo = String.valueOf(1);
			} else if (testSeqNoList.size() > 0) {
				for (Integer maxTestNo : testSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						testSeqNo = String.valueOf(maxTestNo + 1);
					} else {
						testSeqNo = String.valueOf(1);
					}
				}
			}
			testSeqNo = testSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return testSeqNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodSampleScreening(int sampleId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodSampleCollection> sampleList = new ArrayList<BloodSampleCollection>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			sampleList = session.createCriteria(BloodSampleCollection.class)
					.add(Restrictions.eq("SampleStatus", "V"))
					.add(Restrictions.eq("Id", sampleId)).list();
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("BloodBankScreenTest", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			if (sampleList != null && sampleList.size() > 0) {
				detailsMap.put("sampleList", sampleList);

				hinId = sampleList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public String generateSampleTestNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String testSeqNo = "";
		List<TransactionSequence> testSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodSampleScreeningHeader> seqNoList = new ArrayList<BloodSampleScreeningHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodSampleScreeningHeader.class)
				.list();
		if (seqNoList.size() > 0) {
			for (BloodSampleScreeningHeader screeningHeader : seqNoList) {
				lastSeqNo = screeningHeader.getSampleTestNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		testSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "STN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (testSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : testSeqNoList) {
				TransactionSequence obj = (TransactionSequence) testSeqNoList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

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
				testSeqNo = seqNo.toString().concat("/")
						.concat(String.valueOf(lastSeqYear));
			}
		} else if (testSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BldScreeningHeader");
			tsObj.setTransactionPrefix("STN");
			tsObj.setTransactionSequenceName("SampleTest No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			testSeqNo = testSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return testSeqNo;
	}

	public Map<String, Object> getDetailsForSampleScreeningTest() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.bloodBank.dataservice.BloodBankDataService#getSampleScreeningTestGrid
	 * (jkt.hms.util.Box)
	 */
	public Map<String, Object> getSampleScreeningTestGrid(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> sampleScreeningList = new ArrayList<BloodSampleCollection>();

		int noOfRecords = 0;
		int noOfPages = 0;

		String tubeNumber = null;
		String bagNumber = null;
		String FROM_DATE = "";
		String TO_DATE = "";
		Date fromdate = null;
		Date toDate = null;

		int page = box.getInt("page");
		int recordsPerPage = box.getInt("recordsPerPage");

		Session session = (Session) getSession();

		Criteria crit = null;
		Criteria criteriaCount = null;

		if (box.get("bagNumber") != null) {
			bagNumber = box.get("bagNumber");
		}
		if (box.get("tubeNumber") != null) {
			tubeNumber = box.get("tubeNumber");
		}
		if (!box.get("fromDate").equals("")) {
			;
			System.out.println(FROM_DATE);
			fromdate = HMSUtil.convertStringTypeDateToDateType(FROM_DATE);
			

		}
		if (!box.get("toDate").equals("")) {
			TO_DATE = box.get("toDate");
			
			toDate = HMSUtil.convertStringTypeDateToDateType(TO_DATE);

		}
		int hospitalId=box.getInt("hospitalId");
		try {
			crit = session.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
			.add(Restrictions.eq("AcceptedRejected", "Y").ignoreCase())
			.add(Restrictions.eq("SampleStatus", "P").ignoreCase())
			.add(Restrictions.eq("SampleCrossCheckStatus", "Y").ignoreCase());

			criteriaCount = session.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
			.add(Restrictions.eq("AcceptedRejected", "Y"))
			.add(Restrictions.eq("SampleStatus", "P").ignoreCase())
			.add(Restrictions.eq("SampleCrossCheckStatus", "Y").ignoreCase())
			.setProjection(Projections.rowCount());

			if (null != bagNumber && !bagNumber.isEmpty()) {
				crit.add(Restrictions.eq("BagNumber", bagNumber));

				criteriaCount = session.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hospital")
						.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("BagNumber", bagNumber))
				.add(Restrictions.eq("AcceptedRejected", "Y"))
				.add(Restrictions.eq("SampleStatus", "P").ignoreCase())
				.add(Restrictions.eq("SampleCrossCheckStatus", "Y").ignoreCase())
				.setProjection(Projections.rowCount());
			}
			if (null != tubeNumber && !tubeNumber.isEmpty()) {

				crit.add(Restrictions.eq("TubeNumber", tubeNumber));

				criteriaCount = session
						.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hospital")
						.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("TubeNumber", tubeNumber))
				.add(Restrictions.eq("AcceptedRejected", "Y"))
				.add(Restrictions.eq("SampleStatus", "P").ignoreCase())
				.add(Restrictions.eq("SampleCrossCheckStatus", "Y").ignoreCase())
				.setProjection(Projections.rowCount());
			}
			if (null != fromdate && null != toDate) {

				crit.add(Restrictions.ge("SampleCollectionDate",
						new java.sql.Date(fromdate.getTime())))
				.add(Restrictions.lt("SampleCollectionDate",
						new java.sql.Date(toDate.getTime())));

				criteriaCount = session
						.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hospital")
						.add(Restrictions.eq("hospital.Id", hospitalId));
				criteriaCount.add(Restrictions.ge("SampleCollectionDate",
						new java.sql.Date(fromdate.getTime())));
				criteriaCount.add(Restrictions.lt("SampleCollectionDate",
						new java.sql.Date(toDate.getTime())));
				criteriaCount.add(Restrictions.eq("AcceptedRejected", "Y"));
				criteriaCount.add(Restrictions.eq("SampleStatus", "P")
						.ignoreCase());
				criteriaCount.add(Restrictions.eq("SampleCrossCheckStatus", "Y").ignoreCase());
				criteriaCount.setProjection(Projections.rowCount());

			}

			noOfRecords = (Integer) criteriaCount.uniqueResult();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			map.put("currentPage", page);
			map.put("noOfPages", noOfPages);
			crit.setFirstResult((page - 1) * recordsPerPage);
			crit.setMaxResults(recordsPerPage);

			sampleScreeningList = crit.list();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("sampleScreeningList", sampleScreeningList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTestName(Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		try {
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.like("InvestigationName", str))
					.add(Restrictions.eq("Status", "y")).list();

			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsForInvestigationName(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List investigationList = new ArrayList();
		Session session = (Session) getSession();
		String investigationName = (String) dataMap.get("investigationName");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.like("InvestigationName",
							investigationName)).list();
			map.put("investigationList", investigationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitBloodSampleScreeningTest(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		
		List mainChargeList = new ArrayList();
		List chargeList = new ArrayList();
		
		BloodSampleScreeningHeader sampleScreeningHeader = new BloodSampleScreeningHeader();

		List investigationList = new ArrayList();
		Session session1 = (Session) getSession();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		
		boolean success = false;
		@SuppressWarnings("unused")
		Box box = null;
		int componentMainIdFromRequest = 0;
		int scrneeinghdId = 0;

		int dgSampleCollectionHeaderId = 0;

		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		int sampleCollectionId = 0;
		String userName = "";
		String testSeqNo = "";
		Vector result = null;
		String discardsample = "";
		
		BloodStockDetail bloodStockDetail=null;
		BloodStockMain bloodStockmain=null;
		
		if (infoMap.get("discardsample") != null) {
			discardsample = (String) infoMap.get("discardsample");
			
		}
		MasHospital hospital=new MasHospital();
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
			hospital.setId(hospitalId);
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}

		if (infoMap.get("sampleScreeningHeader") != null) {
			sampleScreeningHeader = (BloodSampleScreeningHeader) infoMap
					.get("sampleScreeningHeader");
		}
		BloodResultEntryHeader bloodResultEntryHeader=null;
		if (infoMap.get("bloodResultEntryHeader") != null) {
			bloodResultEntryHeader = (BloodResultEntryHeader) infoMap
					.get("bloodResultEntryHeader");
		}
		
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("testSeqNo") != null) {
			testSeqNo = (String) infoMap.get("testSeqNo");
		}
		if (infoMap.get("sampleCollectionId") != null) {
			sampleCollectionId = (Integer) infoMap.get("sampleCollectionId");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("result") != null) {
			result = (Vector) infoMap.get("result");
		}
		int sampleId=0;
		
		if (infoMap.get("sampleId") != null) {
			sampleId = (Integer) infoMap.get("sampleId");
			
		}
		
		String bagNo="";
		String tubeNo="";

		if (infoMap.get("BagNumber") != null) {
			bagNo = (String) infoMap.get("BagNumber");
			
		}
		if (infoMap.get("TubeNumber") != null) {
			tubeNo = (String) infoMap.get("TubeNumber");
			
		}
		if (infoMap.get("sampleScreeningHeader") != null) {
			  sampleScreeningHeader = (BloodSampleScreeningHeader) infoMap.get("sampleScreeningHeader"); 
			  
		 }
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tnx=null;
		
		int bldResultEntryHeaderId=0;
		try {
			tnx=session1.beginTransaction();
			
			hbt.save(sampleScreeningHeader);
			 scrneeinghdId = sampleScreeningHeader.getId();
			  map.put("scrneeinghdId", scrneeinghdId);
			 
			  hbt.save(bloodResultEntryHeader);
			  bldResultEntryHeaderId = bloodResultEntryHeader.getId();
				  map.put("bldResultEntryHeaderId", bldResultEntryHeaderId);
				 
			  
			Criteria crt=null;
			crt=session1.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("Id", sampleId));
			
			BloodSampleCollection bldSamplecollectionObj=(BloodSampleCollection) crt.list().get(0);
			
			
			if (discardsample.equalsIgnoreCase("Discard Blood")) {
				
				
				bldSamplecollectionObj.setSampleStatus("B");
				hbt.update(bldSamplecollectionObj);
				
				int bloodStockMainId=0;
				
				BloodDiscardEntry discardEntry=new BloodDiscardEntry();
				
				crt=session1.createCriteria(BloodStockDetail.class).add(Restrictions.eq("BloodBagNo", bagNo));
				if(null !=crt.list() && crt.list().size()>0){
				bloodStockDetail=(BloodStockDetail) crt.list().get(0);
				
				}
				bloodStockDetail.setBloodDiscard("y");
				hbt.update(bloodStockDetail);
				
				
				discardEntry.setStockDetail(bloodStockDetail);
				discardEntry.setHospital(hospital);
				discardEntry.setDiscardDate(HMSUtil.convertStringTypeDateToDateType(date));
				discardEntry.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
				discardEntry.setLastChgTime(time);
				hbt.save(discardEntry);
				} 
			else{
				
				bldSamplecollectionObj.setSampleStatus("C");
				hbt.save(bldSamplecollectionObj);
				  
			crt=session1.createCriteria(BloodStockDetail.class).add(Restrictions.eq("BloodBagNo", bagNo));
			if(null !=crt.list() && crt.list().size()>0){
			bloodStockDetail=(BloodStockDetail) crt.list().get(0);
			bloodStockmain=bloodStockDetail.getStockMain();
			bloodStockmain.setBloodBagStatus("T");
			}
			//bloodStockDetail.setBloodDiscard("y");
			//hbt.update(bloodStockDetail);
			
			hbt.update(bloodStockmain);
				}
			
			if(infoMap.get("mainChargeList")!=null){
				mainChargeList=(List)infoMap.get("mainChargeList");
				
			}
			if(infoMap.get("chargeList")!=null){
				chargeList=(List)infoMap.get("chargeList");
			}
			
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {
						
						MasChargeCode masChargeCode = new MasChargeCode();
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						int chargeId = 0;
						if (chargeList.get(i) != null
								&& !chargeList.get(i).equals("")) {

							chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							masChargeCode.setId(chargeId);
							
					}
						int mainChargeId = 0;
						if (mainChargeList.get(i) != null
								&& !mainChargeList.get(i).equals("")) {
							mainChargeId = Integer.parseInt(mainChargeList
									.get(i).toString());
							masMainChargecode.setId(mainChargeId);
						}
						
					}
				}
			
			
			if (infoMap.get("investigationList") != null) {
				investigationList = (List) infoMap.get("investigationList");
				if (investigationList.size() > 0) {
					for (int i = 0; i < investigationList.size(); i++) {
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						
						  BloodSampleScreeningDetail sampleScreeningDetail =new BloodSampleScreeningDetail();
						  sampleScreeningDetail.setScreenTest(sampleScreeningHeader);
						  
						 DgMasInvestigation masInvestigation = new DgMasInvestigation();
						 
						 BloodResultEntryDetails bloodResultEntryDetails=new BloodResultEntryDetails();
						 bloodResultEntryDetails.setHeader(bloodResultEntryHeader);
						 
							if (investigationList.get(i) != null && !investigationList.get(i).equals("")) {
								int investigationId = Integer.parseInt(investigationList.get(i).toString());
								masInvestigation.setId(investigationId);
								sampleScreeningDetail.setInvestigation(masInvestigation);
								bloodResultEntryDetails.setInvestigation(masInvestigation);
								int mainChargeId = 0;
								if (mainChargeList.get(i) != null
										&& !mainChargeList.get(i).equals("")) {
									mainChargeId = Integer.parseInt(mainChargeList
											.get(i).toString());
									masMainChargecode.setId(mainChargeId);
									sampleScreeningDetail.setMainCharge(masMainChargecode);
									
								}
								int chargeId = 0;
								MasChargeCode masChargeCode = new MasChargeCode();
								if (chargeList.get(i) != null
										&& !chargeList.get(i).equals("")) {

									chargeId = Integer.parseInt(chargeList.get(i)
											.toString());
									masChargeCode.setId(chargeId);
							}	
							}
							hbt.save(sampleScreeningDetail);
							hbt.save(bloodResultEntryDetails);

							
							if (!tnx.wasCommitted())
							    tnx.commit();
							session1.flush();
							saved = true;
					}
				}
			}
		} catch (RuntimeException e) {
			tnx.rollback();
			e.printStackTrace();
			
		}
		return saved;
	}

	public Map<String, Object> getBloodIssueGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> patientDetailList = new ArrayList<BloodRequestEntryHeader>();
		Date currentDate = new Date();
		
		int hospitalId=(Integer)mapForDs.get("hospitalId");
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodRequestEntryHeader.class).createAlias("Hospital", "hospital")
					.add(Restrictions.eq("ResultEntryStatus", "C").ignoreCase())
					.add(Restrictions.eq("hospital.Id", hospitalId))
					/*.add(Restrictions.eq("SampleTestDate", currentDate))*/;
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> getDetailsForBloodIssue() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> showStockOpeningBalance() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<BloodOpeningStockMain> openingStockList = new ArrayList<BloodOpeningStockMain>();
		Session session = (Session) getSession();

		int hinId = 0;
		try {
			wardList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y")).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class)
					.add(Restrictions.eq("Status", "y")).list();
			// patientList = session.createCriteria(Patient.class).list();
			openingStockList = session.createCriteria(
					BloodOpeningStockMain.class).list();
			map.put("openingStockList", openingStockList);
			/*
			 * if (patientList != null || patientList.size() > 0) {
			 * map.put("patientList", patientList); }
			 */
			map.put("bloodGroupList", bloodGroupList);
			map.put("wardList", wardList);
			map.put("employeeList", employeeList);
			map.put("componentList", componentList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBloodDiscardJsp(int bloodStockDetailId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		Session session = (Session) getSession();
		Date currentDate = new Date();

		int hinId = 0;

		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y").ignoreCase())
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.DepartmentTypeCode", "BB")).list();
			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y")).list();
			stockList = session.createCriteria(BloodStockDetail.class)
					.createAlias("StockMain", "main")
					//.add(Restrictions.le("main.ExpiryDate", currentDate)) //Commented by Arbind on 11-10-2017
					.add(Restrictions.eq("Id", bloodStockDetailId)).list();
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
			if (patientList != null || patientList.size() > 0) {
				map.put("patientList", patientList);
			}
			map.put("wardList", departmentList);
			map.put("employeeList", employeeList);
			map.put("componentList", componentList);
			map.put("stockList", stockList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public String generateOpeningNumber() {
		String stockSeqNo = "";
		int stockNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();
		List<BloodOpeningStockMain> stockSeqNoList = new ArrayList<BloodOpeningStockMain>();
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "BSN")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (seqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : seqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				stockNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(stockNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			stockNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BldOpenStockMain");
			tsObj.setTransactionPrefix("BSN");
			tsObj.setTransactionSequenceName("Stock No");
			tsObj.setTransactionSequenceNumber(stockNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);
		}

		stockSeqNo = String.valueOf(stockNo);
		return stockSeqNo;
	}

	public Map<String, Object> submitStockOpeningBalance(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		String stockSeqNo = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("deptId") != null) {
			deptId = (Integer) infoMap.get("deptId");
		}
		BloodOpeningStockMain bldOpeningStockMain = new BloodOpeningStockMain();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {

			if (hospitalId != 0) {
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				bldOpeningStockMain.setHospital(hospital);
			}

			if (deptId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				bldOpeningStockMain.setDepartment(masDepartment);
			}
			String openingNo = box.getString(STOCK_NO);
			bldOpeningStockMain.setOpeningNo(openingNo);

			int employeeId = box.getInt(EMPLOYEE_ID);
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				bldOpeningStockMain.setApprovedBy(masEmployee);
			}
			String remarks = box.getString(REMARKS);
			if (remarks != null) {
				bldOpeningStockMain.setRemarks(remarks);
			}
			bldOpeningStockMain.setDate1(date);
			bldOpeningStockMain.setLastChgBy(userName);
			bldOpeningStockMain.setLastChgDate(date);
			bldOpeningStockMain.setLastChgTime(time);
			bldOpeningStockMain.setDate1(date);
			hbt.save(bldOpeningStockMain);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		try {
			Vector blood_bag_no = box.getVector(BLOOD_BAG_NO);
			Vector collection_date = box.getVector(COLLECTION_DATE);
			Vector componet_Id = box.getVector(BLOOD_COMPONENT_ID);
			Vector qty = box.getVector(QUANTITY);
			Vector hinId = box.getVector(HIN_ID);
			Vector name = box.getVector(DONER_NAME);
			Vector expiry_date = box.getVector(EXPIRY_DATE);
			Vector bld_group_id = box.getVector(BLOOD_GROUP_ID);

			for (int i = 0; i < blood_bag_no.size(); i++) {
				BloodOpeningStockDetail bloodOpeningStockDetail = new BloodOpeningStockDetail();
				if (blood_bag_no.get(i) != null
						&& !blood_bag_no.get(i).equals("")) {
					bloodOpeningStockDetail.setOpeningMain(bldOpeningStockMain);

					bloodOpeningStockDetail.setBloodBagNo((String) blood_bag_no
							.get(i));

					bloodOpeningStockDetail.setName((String) name.get(i));

					if (componet_Id.get(i) != null
							&& !componet_Id.get(i).equals("")) {
						BloodMasComponent bloodMasComponent = new BloodMasComponent();
						bloodMasComponent.setId(Integer
								.parseInt((String) componet_Id.get(i)));
						bloodOpeningStockDetail.setComponent(bloodMasComponent);
					}
					bloodOpeningStockDetail.setCollectionDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.COLLECTION_DATE)));
					if (qty.get(i) != null) {
						bloodOpeningStockDetail.setQty(Integer
								.parseInt((String) qty.get(i)));
					}
					if (hinId.get(i) != null && !hinId.get(i).equals("")) {
						Patient patient = new Patient();
						patient.setId(Integer.parseInt((String) hinId.get(i)));
						bloodOpeningStockDetail.setHin(patient);
					}

					bloodOpeningStockDetail.setExpiryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.get(RequestConstants.EXPIRY_DATE)));
					if (bld_group_id.get(i) != null
							&& !bld_group_id.get(i).equals("")) {
						MasBloodGroup bloodGroup = new MasBloodGroup();
						bloodGroup.setId(Integer.parseInt((String) bld_group_id
								.get(i)));
						bloodOpeningStockDetail.setBloodGroup(bloodGroup);
					}

					hbt.save(bloodOpeningStockDetail);
				}
			}
			// -Stock Table
			BloodStockMain bloodStockMain = new BloodStockMain();
			HibernateTemplate hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			if (hospitalId != 0) {
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				bloodStockMain.setHospital(hospital);
			}

			if (deptId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				bloodStockMain.setDepartment(masDepartment);
			}

			int bloodGroupId = box.getInt(BLOOD_GROUP_ID);
			if (bloodGroupId != 0) {
				MasBloodGroup bloodGroup = new MasBloodGroup();
				bloodGroup.setId(bloodGroupId);
				bloodStockMain.setBloodGroup(bloodGroup);
			}
			int hinnId = box.getInt(HIN_ID);
			if (hinnId != 0) {
				Patient patient = new Patient();
				patient.setId(hinnId);
				bloodStockMain.setHin(patient);
			}
			String name1 = box.getString(DONER_NAME);
			if (name1 != null) {
				bloodStockMain.setName(name1);
			}
			String expDate = box.getString(EXPIRY_DATE);
			String collectionDate = box.getString(COLLECTION_DATE);
			bloodStockMain.setExpiryDate(HMSUtil
					.convertStringTypeDateToDateType(expDate));
			bloodStockMain.setCollectionDate(HMSUtil
					.convertStringTypeDateToDateType(collectionDate));
			hbt1.save(bloodStockMain);
			for (int i = 0; i < blood_bag_no.size(); i++) {
				BloodStockDetail stockDetail = new BloodStockDetail();
				if (blood_bag_no.get(i) != null
						&& !blood_bag_no.get(i).equals("")) {
					stockDetail.setStockMain(bloodStockMain);

					stockDetail.setBloodBagNo((String) blood_bag_no.get(i));
					if (componet_Id.get(i) != null
							&& !componet_Id.get(i).equals("")) {
						BloodMasComponent bloodMasComponent = new BloodMasComponent();
						bloodMasComponent.setId(Integer
								.parseInt((String) componet_Id.get(i)));
						stockDetail.setComponent(bloodMasComponent);
					}
					if (qty.get(i) != null) {
						stockDetail
								.setQty(Integer.parseInt((String) qty.get(i)));
					}
					stockDetail.setBloodIssued("n");
					hbt1.save(stockDetail);
					hbt1.refresh(stockDetail);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		saved = true;
		// ----End-------Saving Data in stock table-----
		map.put("saved", saved);
		return map;
	}

	public List<Patient> getPateintDetail(String hinNo) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		try {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	public String getStockSeqNoForDisplay(String string) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		String seqNo = "";
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "BSN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (seqNoList.get(0) == null || seqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BldOpenStockMain");
				tsObj.setTransactionPrefix("BSN");
				tsObj.setTransactionSequenceName("Stock No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				seqNo = String.valueOf(1);
			} else if (seqNoList.get(0) != null) {
				maxSeqNo = seqNoList.get(0);
				seqNo = String.valueOf(maxSeqNo + 1);
			} else {
				seqNo = String.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return seqNo;
	}

	public Map<String, Object> getDetailsForBloodRequestEnquiry() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDonationSeqNoForDisplay(String string) {
		List<Integer> donationSeqNoList = new ArrayList<Integer>();
		List<BloodDonationEntryHeader> seqNoList = new ArrayList<BloodDonationEntryHeader>();
		String donationSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(BloodDonationEntryHeader.class)
					.list();
			if (seqNoList.size() > 0) {
				for (BloodDonationEntryHeader bloodDonationEntryHeader : seqNoList) {
					lastSeqNo = bloodDonationEntryHeader.getDonationNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			donationSeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "BDN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (donationSeqNoList.get(0) == null
					|| donationSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BldDonationHeader");
				tsObj.setTransactionPrefix("BDN");
				tsObj.setTransactionSequenceName("Blood Donation No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				donationSeqNo = String.valueOf(1);
			} else if (donationSeqNoList.size() > 0) {
				for (Integer maxOrderNo : donationSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						donationSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						donationSeqNo = String.valueOf(1);
					}
				}
			}
			donationSeqNo = donationSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return donationSeqNo;
	}

	@SuppressWarnings("unchecked")
	public String generateDonationNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String donationSeqNo = "";
		
		List<TransactionSequence> donationSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodDonationEntryHeader> seqNoList = new ArrayList<BloodDonationEntryHeader>();
		
		String lastSeqNo = "";
		String lastSeqYear = "";
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodDonationEntryHeader.class)
				.list();
		if (seqNoList.size() > 0) {
			for (BloodDonationEntryHeader bloodDonationEntryHeader : seqNoList) {
				lastSeqNo = bloodDonationEntryHeader.getDonationNo();
			}
			  String TlastSeqNo[]=lastSeqNo.split("/");
			StringTokenizer str = new StringTokenizer(TlastSeqNo[1], "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		}  if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		/*if (!lastSeqYear.equals("") && !currentYear.equals(lastSeqYear)) {
			lastSeqYear = currentYear;
		}*/
		donationSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "BDN")).list();
		System.out.println("donationSeqNoList "+donationSeqNoList.size());

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (donationSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : donationSeqNoList) {
				TransactionSequence obj = (TransactionSequence) donationSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					lastSeqYear = currentYear;
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				// ++seqNo;
				seqNo = seqNo + 1;
				donationSeqNo = String.valueOf(seqNo);
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				/*donationSeqNo = donationSeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));*/
				
				donationSeqNo =   String.valueOf(lastSeqYear).concat("/").concat(
						donationSeqNo);
				

			}
		} else if (donationSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("Y");
			tsObj.setTablename("BldDonationHeader");
			tsObj.setTransactionPrefix("BDN");
			tsObj.setTransactionSequenceName("Blood Doantion No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("Y");
			hbt.save(tsObj);
			/*donationSeqNo = donationSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));*/
			donationSeqNo =   String.valueOf(lastSeqYear).concat("/").concat(
					donationSeqNo);
			
			
		}
		return donationSeqNo;
	}
	
	@SuppressWarnings("unchecked")
	public String generateIndentOrderNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String indentOrderNo = "";
		
		List<TransactionSequence> indentOrderNoList = new ArrayList<TransactionSequence>();
		List<BloodRequestEntryHeader> seqNoList = new ArrayList<BloodRequestEntryHeader>();
		
		String lastSeqNo = "";
		String lastSeqYear = "";
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodRequestEntryHeader.class)
				.list();
		if (seqNoList.size() > 0) {
			for (BloodRequestEntryHeader bloodRequestEntryHeader : seqNoList) {
				lastSeqNo = bloodRequestEntryHeader.getOrderNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		indentOrderNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "ION")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (indentOrderNoList.size() > 0) {
			for (TransactionSequence transactionSequence : indentOrderNoList) {
				TransactionSequence obj = (TransactionSequence) indentOrderNoList
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
				// ++seqNo;
				seqNo = seqNo + 1;
				indentOrderNo = String.valueOf(seqNo);
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				indentOrderNo = indentOrderNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (indentOrderNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("Y");
			tsObj.setTablename("BloodRequestEntryHeader");
			tsObj.setTransactionPrefix("ION");
			tsObj.setTransactionSequenceName("Indent Order No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("Y");
			hbt.save(tsObj);
			indentOrderNo = indentOrderNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return indentOrderNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jkt.hms.bloodBank.dataservice.BloodBankDataService#
	 * submitBloodDonationEntry(java.util.Map)
	 */
	public Map<String, Object>  submitBloodDonationEntry(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();
		List componentList = new ArrayList();
		List qtyList = new ArrayList();
		Box box = null;
		int donationMainIdFromRequest = 0;
		int donationhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		int rankId = 0;
		String userName = "";
		String donationSeqNo = "";
		Vector quantity = null;
		Vector blood_Bag_No = null;
		Vector blood_donation_detail_id = null;

		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("blood_Bag_No") != null) {
			blood_Bag_No = (Vector) infoMap.get("blood_Bag_No");
		}
		if (infoMap.get("quantity") != null) {
			quantity = (Vector) infoMap.get("quantity");
		}
		if (infoMap.get("blood_donation_detail_id") != null) {
			blood_donation_detail_id = (Vector) infoMap
					.get("blood_donation_detail_id");
		}
		if (infoMap.get("donationEntryHeader") != null) {
			donationEntryHeader = (BloodDonationEntryHeader) infoMap
					.get("donationEntryHeader");
		}
		if (infoMap.get("donationMainIdFromRequest") != null) {
			donationMainIdFromRequest = (Integer) infoMap
					.get("donationMainIdFromRequest");
		}
		if (infoMap.get("donationSeqNo") != null) {
			donationSeqNo = (String) infoMap.get("donationSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		int donorRegSerialNo=0;
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		
		boolean bBAvailabilityStatus=false;
		boolean duplicateRegistration=false;
		String hospitalCode="";
		
		duplicateRegistration=checkDuplicateRegistration(donationEntryHeader);
		dataMap=checkBloodBankAvailability(hospitalId);
		if(null !=dataMap.get("status")){
			bBAvailabilityStatus=(Boolean)dataMap.get("status");
		}
		if(null !=dataMap.get("hospitalCode")){
			hospitalCode=(String)dataMap.get("hospitalCode");
		}
		String tmpDonorRegNo=hospitalCode+"/"+donationSeqNo;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(!duplicateRegistration){
			if (infoMap.get("donationEntryHeader") != null) {
				donationEntryHeader = (BloodDonationEntryHeader) infoMap
						.get("donationEntryHeader");
				donationEntryHeader.setDonationNo(tmpDonorRegNo);
				if(bBAvailabilityStatus){
				hbt.save(donationEntryHeader);
				donorRegSerialNo=donationEntryHeader.getId();
				saved = true;
				}
			}
			
			/*else {

				BloodDonationEntryHeader donationEntryHeaderObj = new BloodDonationEntryHeader();
				donationEntryHeaderObj = (BloodDonationEntryHeader) hbt.load(
						BloodDonationEntryHeader.class,
						donationMainIdFromRequest);
				hbt.update(donationEntryHeaderObj);
			}*/

			

			map.put("donorRegSerialNo", donorRegSerialNo);
			map.put("tmpDonorRegNo", tmpDonorRegNo);
			}
			map.put("duplicateRegistration", duplicateRegistration);
			map.put("saved", saved);
			map.put("bBAvailabilityStatus", bBAvailabilityStatus);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public boolean submitDonerAssesstmentEntry(Map<String, Object> infoMap) {
		boolean saved = false;
		String donorRegistrationNumber = null;

		String deferredStatus = "";
		int assesstmentMid = 0;
		String donorRegNumber = null;
		int donorSequenceNumer = 0;
		
		/*String cellGroupRequired="";
		cellGroupRequired=(String)infoMap.get("cellGroupRequired");*/
		
		BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();
		BloodAssessmentEntryT assesstmentEntryT = new BloodAssessmentEntryT();
		Set<BloodAssessmentEntryT> assesstmentEntryTT = new HashSet<BloodAssessmentEntryT>();

		MasAssessment mm = new MasAssessment();

		if (infoMap.get("donationEntryHeader") != null) {
			donationEntryHeader = (BloodDonationEntryHeader) infoMap
					.get("donationEntryHeader");

			donorRegistrationNumber = donationEntryHeader.getDonationNo();
		}
		if (null != donorRegNumber) {
			donorRegNumber = (String) infoMap.get("donorRegNumber");
			//System.out.println("donorRegNumber " + donorRegNumber);

		}
		if (infoMap.get("donorSequenceNumer") != null) {
			donorSequenceNumer = (Integer) infoMap.get("donorSequenceNumer");
			//System.out.println("donorSequenceNumer " + donorSequenceNumer);

		}
		if (null != infoMap.get("assesstmentEntryT")) {
			assesstmentEntryTT = (Set<BloodAssessmentEntryT>) infoMap
					.get("assesstmentEntryT");

		}
		if (null != infoMap.get("assesstmentMid")) {
			assesstmentMid = (Integer) infoMap.get("assesstmentMid");
			//System.out.println("assesstmentMiddd " + assesstmentMid);
		}
		if (null != infoMap.get("deferredStatus")) {
			deferredStatus = (String) infoMap.get("deferredStatus");
			//System.out.println("deferredStatus " + deferredStatus);

		}
		
		int hospitalId=0;
		if (null != infoMap.get("hospitalId")) {
			hospitalId = (Integer) infoMap.get("hospitalId");
			//System.out.println("deferredStatus " + deferredStatus);

		}

		Session session = (Session) getSession();
		Transaction tnx = session.beginTransaction();
		try {
			for (BloodAssessmentEntryT assesstmentEnt : assesstmentEntryTT) {
				session.save(assesstmentEnt);
				session.flush();
			}

			tnx.commit();
			saved = true;
		} catch (Exception e) {
			e.printStackTrace();
			tnx.rollback();
		}

		Session session1 = (Session) getSession();
		Transaction tnx1 = session1.beginTransaction();
		BloodDonationEntryHeader bloodDonationEntryHeader =null;
		if(donorSequenceNumer>0){
		bloodDonationEntryHeader = (BloodDonationEntryHeader) session1.createCriteria(BloodDonationEntryHeader.class)
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("Id", donorSequenceNumer)).list().get(0);
				//load(BloodDonationEntryHeader.class,donorSequenceNumer);
		}
		if (assesstmentMid > 0) {
			BloodAssessmentEntryM bloodAssessmentEntryM = (BloodAssessmentEntryM) session1
					.load(BloodAssessmentEntryM.class, assesstmentMid);
			/* bloodAssessmentEntryM.setAssessmentResult(deferredStatus); */
			bloodAssessmentEntryM.setFinalResult(deferredStatus);
			session1.saveOrUpdate(bloodAssessmentEntryM);
			

			//System.out.println("donorSequenceNumer "+donorSequenceNumer);
			
			bloodDonationEntryHeader.setDonorStatus(deferredStatus);
				
			
				
		}
		bloodDonationEntryHeader.setAssessmetStatus("C");
		session1.saveOrUpdate(bloodDonationEntryHeader);
		session1.flush();
		tnx1.commit();
		saved = true;
		return saved;
	}

	public Map<String, Object> getDetailsForDonorSampleScreening() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getDonorSampleScreeningGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodDonationEntryDetail> patientDetailList = new ArrayList<BloodDonationEntryDetail>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session
					.createCriteria(BloodDonationEntryDetail.class)
					.add(Restrictions.eq("SampleScreeningTest", "n"))
					.createAlias("Donation", "sampleHeader")
					.add(Restrictions.eq("sampleHeader.CollectionDate",
							currentDate));

			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> showDonorBloodSampleScreeningTest(int donationId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodDonationEntryDetail> doantionDetailList = new ArrayList<BloodDonationEntryDetail>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		int hinId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			doantionDetailList = session
					.createCriteria(BloodDonationEntryDetail.class)
					.add(Restrictions.eq("SampleScreeningTest", "n"))
					.createAlias("Donation", "don")
					.add(Restrictions.eq("don.Id", donationId)).list();
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("BloodBankScreenTest", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			if (doantionDetailList != null && doantionDetailList.size() > 0) {
				detailsMap.put("doantionDetailList", doantionDetailList);
				if (doantionDetailList.get(0).getDonation().getHin() != null) {
					hinId = doantionDetailList.get(0).getDonation().getHin()
							.getId();
				}
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public String getDonorSampleTestSeqForDisplay(String string) {
		List<Integer> testSeqNoList = new ArrayList<Integer>();
		List<BloodDonorSampleScreeningHeader> seqNoList = new ArrayList<BloodDonorSampleScreeningHeader>();
		String testSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(
					BloodDonorSampleScreeningHeader.class).list();
			if (seqNoList.size() > 0) {
				for (BloodDonorSampleScreeningHeader screeningHeader : seqNoList) {
					lastSeqNo = screeningHeader.getSampleTestNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}
			testSeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "DSTN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (testSeqNoList.get(0) == null || testSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BldDnrScreeningHd");
				tsObj.setTransactionPrefix("DSTN");
				tsObj.setTransactionSequenceName("SampleTest No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				testSeqNo = String.valueOf(1);
			} else if (testSeqNoList.size() > 0) {
				for (Integer maxTestNo : testSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						testSeqNo = String.valueOf(maxTestNo + 1);
					} else {
						testSeqNo = String.valueOf(1);
					}
				}
			}
			testSeqNo = testSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return testSeqNo;
	}

	public String generateDonorSampleTestNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String testSeqNo = "";
		List<TransactionSequence> testSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodDonorSampleScreeningHeader> seqNoList = new ArrayList<BloodDonorSampleScreeningHeader>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(
				BloodDonorSampleScreeningHeader.class).list();
		if (seqNoList.size() > 0) {
			for (BloodDonorSampleScreeningHeader screeningHeader : seqNoList) {
				lastSeqNo = screeningHeader.getSampleTestNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		testSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DSTN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (testSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : testSeqNoList) {
				TransactionSequence obj = (TransactionSequence) testSeqNoList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

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
				testSeqNo = seqNo.toString().concat("/")
						.concat(String.valueOf(lastSeqYear));
			}
		} else if (testSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BldDnrScreeningHd");
			tsObj.setTransactionPrefix("DSTN");
			tsObj.setTransactionSequenceName("Sample Test No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			testSeqNo = testSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return testSeqNo;
	}

	// -----------------------Get -Donor Deatil For Sample
	// Screening--------------------------------
	public Map<String, Object> getDonorDetailBloodSampleScreening(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodDonationEntryDetail> patientDetailList = new ArrayList<BloodDonationEntryDetail>();
		Session session = (Session) getSession();

		String hinNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String screeningStatus = "";
		String donationNo = "";
		String patName = "";

		int donationId = 0;
		int hinId = 0;
		Criteria crit = null;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("patName") != null) {
			patName = (String) mapForDs.get("patName");
		}
		if (mapForDs.get("screeningStatus") != null) {
			screeningStatus = (String) mapForDs.get("screeningStatus");
		}
		if (mapForDs.get("donationNo") != null) {
			donationNo = (String) mapForDs.get("donationNo");
		}
		if (mapForDs.get("donationId") != null) {
			donationId = (Integer) mapForDs.get("donationId");
		}
		try {
			crit = session
					.createCriteria(BloodDonationEntryDetail.class)
					.add(Restrictions.eq("SampleScreeningTest", "n"))
					.createAlias("Donation", "bloodHeader")
					.add(Restrictions.between("bloodHeader.CollectionDate",
							fromDate, toDate));

			if (hinNo.equals("")) {
				if (!donationNo.equals("")) {

					crit = crit.add(Restrictions.like("bloodHeader.DonationNo",
							donationNo + "%"));
				}

				if (!patName.equals("")) {
					crit = crit.add(Restrictions.like("bloodHeader.DonerName",
							patName + "%"));
				}
			} else {

				if (!hinNo.equals("")) {
					crit = crit.createAlias("bloodHeader.Hin", "pt").add(
							Restrictions.like("pt.HinNo", hinNo + "%"));
				}

			}
			patientDetailList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public boolean submitDonorBloodSampleScreeningTest(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		BloodDonorSampleScreeningHeader donorSampleScreeningHeader = new BloodDonorSampleScreeningHeader();
		List investigationList = new ArrayList();
		List donationList = new ArrayList();
		Box box = null;
		int componentMainIdFromRequest = 0;
		int scrneeinghdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String testSeqNo = "";
		Vector result = null;
		Vector donation_id = null;
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("donationList") != null) {
			donationList = (List) infoMap.get("donationList");
		}
		if (infoMap.get("donorSampleScreeningHeader") != null) {
			donorSampleScreeningHeader = (BloodDonorSampleScreeningHeader) infoMap
					.get("donorSampleScreeningHeader");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("testSeqNo") != null) {
			testSeqNo = (String) infoMap.get("testSeqNo");
		}
		if (infoMap.get("result") != null) {
			result = (Vector) infoMap.get("result");
		}
		if (infoMap.get("donation_id") != null) {
			donation_id = (Vector) infoMap.get("donation_id");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		int donationId = (Integer) box.getInt("donationId");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("donorSampleScreeningHeader") != null) {
				donorSampleScreeningHeader = (BloodDonorSampleScreeningHeader) infoMap
						.get("donorSampleScreeningHeader");
				hbt.save(donorSampleScreeningHeader);
				scrneeinghdId = donorSampleScreeningHeader.getId();
				map.put("scrneeinghdId", scrneeinghdId);
			} else {

				BloodDonorSampleScreeningHeader bloodSampleScreeningHeader = new BloodDonorSampleScreeningHeader();
				bloodSampleScreeningHeader = (BloodDonorSampleScreeningHeader) hbt
						.load(BloodDonorSampleScreeningHeader.class,
								componentMainIdFromRequest);
				hbt.update(bloodSampleScreeningHeader);
			}

			int sId = donorSampleScreeningHeader.getDonationDetail().getId();
			BloodDonationEntryDetail donationDetails = (BloodDonationEntryDetail) getHibernateTemplate()
					.load(BloodDonationEntryDetail.class, sId);
			donationDetails.setSampleScreeningTest("y");
			hbt.update(donationDetails);
			hbt.refresh(donationDetails);

			if (infoMap.get("investigationList") != null) {
				investigationList = (List) infoMap.get("investigationList");
				if (investigationList.size() > 0) {
					for (int i = 0; i < investigationList.size(); i++) {

						BloodDonorSampleScreeningDetail donorSampleScreeningDetail = new BloodDonorSampleScreeningDetail();
						DgMasInvestigation masInvestigation = new DgMasInvestigation();
						BloodDonationEntryDetail bloodDonationEntryDetail = new BloodDonationEntryDetail();

						try {
							if (investigationList.get(i) != null
									&& !investigationList.get(i).equals("")) {
								int investigationId = Integer
										.parseInt(investigationList.get(i)
												.toString());
								masInvestigation.setId(investigationId);
								donorSampleScreeningDetail
										.setInvestigation(masInvestigation);

								if (result != null && !result.equals("")) {
									donorSampleScreeningDetail
											.setResult((String) result.get(i)
													.toString());
								}
								donorSampleScreeningDetail
										.setLastChgBy(userName);
								donorSampleScreeningDetail
										.setLastChgDate(HMSUtil
												.convertStringTypeDateToDateType(date));
								donorSampleScreeningDetail.setLastChgTime(time);
								if (infoMap.get("donorSampleScreeningHeader") != null) {
									donorSampleScreeningDetail
											.setScreeningHeader(donorSampleScreeningHeader);

								} else {
									BloodDonorSampleScreeningHeader bloodScreeningHeader = new BloodDonorSampleScreeningHeader();
									bloodScreeningHeader
											.setId(componentMainIdFromRequest);
									donorSampleScreeningDetail
											.setScreeningHeader(bloodScreeningHeader);
								}
							}
							hbt.save(donorSampleScreeningDetail);
							saved = true;
						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}

	public Map<String, Object> showBloodComponentSeparationJsp(int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<BloodStockDetail> pendingForComponentSeparationList = new ArrayList<BloodStockDetail>();
		
		stockList = session.createCriteria(BloodStockDetail.class)
				.createAlias("StockMain", "stockMain")
				.createAlias("stockMain.Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("BloodIssued", "n"))
				.createAlias("Component", "cmt")
				//.add(Restrictions.eq("cmt.WholeBlood", "y"))
				//.add(Restrictions.not(Restrictions.eq("BloodIssued", "d")))
				.add(Restrictions.like("cmt.ComponentName", "Whole Blood" +"%"))
				.list();
		
		
		pendingForComponentSeparationList = session.createCriteria(BloodStockDetail.class)
				.createAlias("StockMain", "stockMain")
				.createAlias("stockMain.Hospital", "hosp")
				.createAlias("Component", "cmt")
				.add(Restrictions.eq("stockMain.CollectionDate", new Date()))
				.add(Restrictions.eq("stockMain.BloodBagStatus", "T").ignoreCase())
				.add(Restrictions.eq("hosp.Id", hospitalId))
				//.add(Restrictions.eq("BloodIssued", "n"))
				
				//.add(Restrictions.eq("cmt.WholeBlood", "y"))
				//.add(Restrictions.not(Restrictions.eq("BloodIssued", "d")))
				//.add(Restrictions.like("cmt.ComponentName", "Whole Blood" +"%"))
				.list();
	
		componentList = session.createCriteria(BloodMasComponent.class)
				.add(Restrictions.eq("Status", "y")).list();
		
		bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		map.put("bloodGroupList", bloodGroupList);
		map.put("componentList", componentList);
		map.put("stockList", stockList);
		map.put("pendingComponentSeparationList", pendingForComponentSeparationList);
		return map;
	}

	public Map<String, Object> getBloodBagNoForAutoComplete(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		Session session = (Session) getSession();
		stockList = session.createCriteria(BloodStockDetail.class)
				.add(Restrictions.like("BloodBagNo", str))
				.createAlias("Component", "cmt")
				.add(Restrictions.eq("cmt.WholeBlood", "y"))
				.add(Restrictions.eq("cmt.BloodIssued", "n")).list();

		if (stockList.size() > 0) {
			detailsMap.put("stockList", stockList);
		}

		return detailsMap;
	}

	public Map<String, Object> showBloodTestEntryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		 List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Patient> patientList = new ArrayList<Patient>();

		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		Session session = (Session) getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y")).list();

			 investigationList =session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("Status","y")) .list();

			/*patientList = session.createCriteria(Patient.class).list();
			if (patientList != null || patientList.size() > 0) {
				map.put("patientList", patientList);
			}*/

			map.put("departmentList", departmentList);
			map.put("employeeList", employeeList);
			 map.put("investionList", investigationList);

			map.put("sexList", sexList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getPatientList(String hinNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();

		if (map.get("hinNo") != null) {
			hinNo = (String) map.get("hinNo");
		}
		patientList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", hinNo)).list();
		if (patientList != null || patientList.size() > 0) {
			map.put("patientList", patientList);
		}
		return map;
	}
	

	public boolean submitBloodTestEntryCg(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean success = false;
		boolean saved = false;
		
		BloodTestEntryHeader testEntryHeader = new BloodTestEntryHeader();
		BloodSampleScreeningHeader bsh=new BloodSampleScreeningHeader();
		
		Session session=(Session) getSession();
		Box box = null;
		int componentMainIdFromRequest = 0;
		int testhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String serialSeqNo = "";
		List result = new ArrayList();
		
		int bldSamplescreenHId=0;
		if (infoMap.get("bldSamplescreenHId") != null) {
			bldSamplescreenHId = (Integer) infoMap.get("bldSamplescreenHId");
		}
		if(bldSamplescreenHId>0){
		
		bsh.setId(bldSamplescreenHId);
		}

		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		
		
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		
		int bloodResultEntryHeaderId=0;
		bloodResultEntryHeaderId=box.getInt("bloodResultEntryHeaderId");
		String cgRemark=box.get("cgRemark");
		
		/*Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		*/
		BloodResultEntryHeader resultEntryHeader=null ;
		int resultEntHId=0;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			int bldresultEntryHId=0;
			
			Criteria crt=null;
			
			crt=session.createCriteria(BloodResultEntryHeader.class)
			.createAlias("Hospital","Hospital")
			.add(Restrictions.eq("Hospital.Id", hospitalId))
			.add(Restrictions.eq("Id", bloodResultEntryHeaderId));
			
			/*crt=session.createCriteria(BloodResultEntryHeader.class).createAlias("ScreeningTest","ScreeningTest")
					.createAlias("Hospital","Hospital")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ScreeningTest.Id", bldSamplescreenHId));*/
			if(null !=crt.list() &&crt.list().size()>0 )
			resultEntryHeader=(BloodResultEntryHeader) crt.list().get(0);
			//resultEntryHeader.setCgBloodGroup(cgBloodGroup);
			BloodDonationEntryHeader donorEntryHeader=null;
			/*donorEntryHeader=(BloodDonationEntryHeader) session.load(BloodDonationEntryHeader.class, donationId);
			donorEntryHeader.setBloodGroup(bloodGroup);
			*/
			donorEntryHeader=resultEntryHeader.getDonor();
			int cgBloodGrpId=0;
			cgBloodGrpId=box.getInt("ccbloodGroup");
			
			String rh=box.get("cgRh");
			MasBloodGroup bldgrp=new MasBloodGroup();
			if(cgBloodGrpId>0){
				
			
			bldgrp.setId(cgBloodGrpId);
			resultEntryHeader.setCgBloodGroup(bldgrp);
			resultEntryHeader.setCgRhFactor(rh);
			
			}
			resultEntryHeader.setCgStatus("C");
			resultEntryHeader.setCgRemark(cgRemark);
				hbt.saveOrUpdate(resultEntryHeader);
				if(null !=donorEntryHeader){
				donorEntryHeader.setBloodGroup(bldgrp);
				donorEntryHeader.setRhFactor(rh);
				hbt.saveOrUpdate(donorEntryHeader);
				}
		
			
			saved = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}
	public boolean submitBloodTestEntrySg(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean success = false;
		boolean saved = false;
		
		BloodTestEntryHeader testEntryHeader = new BloodTestEntryHeader();
		Session session=(Session) getSession();
		Box box = null;
		int componentMainIdFromRequest = 0;
		int testhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String serialSeqNo = "";
		List result = new ArrayList();
		//BloodSampleScreeningHeader bsh=new BloodSampleScreeningHeader();
		int bldSamplescreenHId=0;
		if (infoMap.get("bldSamplescreenHId") != null) {
			bldSamplescreenHId = (Integer) infoMap.get("bldSamplescreenHId");
		}
		
		//bsh.setId(bldSamplescreenHId);
int bldSampleCollectionId=0;
if (infoMap.get("bldSampleCollectionId") != null) {
	bldSampleCollectionId = (Integer) infoMap.get("bldSampleCollectionId");
}
		
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		
		
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		String sgRemark=box.get("sgRemark");
		
		/*Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		*/
		BloodResultEntryHeader resultEntryHeader=null;
		
		int resultEntHId=0;
		

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			int bldresultEntryHId=0;
			Criteria crt=null;
			if(bldSamplescreenHId>0){
			crt=session.createCriteria(BloodResultEntryHeader.class).createAlias("ScreeningTest","ScreeningTest")
					.createAlias("Hospital","Hospital")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ScreeningTest.Id", bldSamplescreenHId));
			}else{
				
				crt=session.createCriteria(BloodResultEntryHeader.class).createAlias("SampleCollection","SampleCollection")
						.createAlias("Hospital","Hospital")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("SampleCollection.Id", bldSampleCollectionId));	
			}
			
			
			if(null !=crt.list() &&crt.list().size()>0 )
			resultEntryHeader=(BloodResultEntryHeader) crt.list().get(0);
			//resultEntryHeader.setCgBloodGroup(cgBloodGroup);
			
			int cgBloodGrpId=0;
			cgBloodGrpId=box.getInt("ccbloodGroup");
			//String rh=box.get("cgRh");
			if(cgBloodGrpId>0){
			MasBloodGroup bldgrp=new MasBloodGroup();
			bldgrp.setId(cgBloodGrpId);
			resultEntryHeader.setSgBloodGroup(bldgrp);
			resultEntryHeader.setSgRemark(sgRemark);
			
			
		//	resultEntryHeader.setCgRhFactor(rh);
			}
			resultEntryHeader.setSgStatus("C");
				hbt.saveOrUpdate(resultEntryHeader);
				
			
		
			
			saved = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}
	public boolean submitBloodTestEntry(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean success = false;
		boolean saved = false;
		BloodTestEntryHeader testEntryHeader = new BloodTestEntryHeader();
		List investigationList = new ArrayList();
		Box box = null;
		int componentMainIdFromRequest = 0;
		int testhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String serialSeqNo = "";
		List result = new ArrayList();

		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("testEntryHeader") != null) {
			testEntryHeader = (BloodTestEntryHeader) infoMap
					.get("testEntryHeader");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("serialSeqNo") != null) {
			serialSeqNo = (String) infoMap.get("serialSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("result") != null) {
			result = (List) infoMap.get("result");
		}
		
		int bldSamplescreenHId=0;
		
		if (infoMap.get("bldSamplescreenHId") != null) {
			bldSamplescreenHId = (Integer) infoMap.get("bldSamplescreenHId");
		}
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		
		//BloodResultEntryHeader resultEntryHeader=new BloodResultEntryHeader();
		int resultEntHId=0;
		int samplecollectionId=0;
		Session session=(Session) getSession();
		Transaction tnx=null;

		try {
			
			//tnx=session.beginTransaction();
			
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			BloodSampleScreeningHeader bssh = (BloodSampleScreeningHeader) session.load(BloodSampleScreeningHeader.class, bldSamplescreenHId);
			bssh.setResultEntryStatus("C");
			
			samplecollectionId=bssh.getSampleCollection().getId(); 
			BloodSampleCollection bsc=new BloodSampleCollection();
			bsc.setId(samplecollectionId);
			
			hbt.save(bssh);
			//*********Start
			BloodResultEntryHeader bloodResultEntryHeader=null;
			Criteria crt=session.createCriteria(BloodResultEntryHeader.class)
					.createAlias("SampleCollection", "SampleCollection")
					.add(Restrictions.eq("SampleCollection.Id", samplecollectionId));
			bloodResultEntryHeader=(BloodResultEntryHeader) crt.list().get(0);
			bloodResultEntryHeader.setScreeningTest(bssh);
			//******End
			
			/*if (infoMap.get("resultEntryHeader") != null) {
				resultEntryHeader = (BloodResultEntryHeader) infoMap
						.get("resultEntryHeader");
				resultEntryHeader.setSampleCollection(bsc);
				
				
				
			}*/
			hbt.update(bloodResultEntryHeader);
			
			if (infoMap.get("testEntryHeader") != null) {
				testEntryHeader = (BloodTestEntryHeader) infoMap
						.get("testEntryHeader");
				hbt.save(testEntryHeader);
				testhdId = testEntryHeader.getId();
				map.put("testhdId", testhdId);
			} else {

				BloodTestEntryHeader bloodTestHeaderObj = new BloodTestEntryHeader();
				bloodTestHeaderObj = (BloodTestEntryHeader) hbt.load(
						BloodTestEntryHeader.class, componentMainIdFromRequest);
				hbt.update(bloodTestHeaderObj);
			}
			if (infoMap.get("investigationList") != null) {
				investigationList = (List) infoMap.get("investigationList");

				if (investigationList.size() > 0) {
					for (int i = 0; i < investigationList.size(); i++) {

						BloodTestEntryDetail testEntryDetail = new BloodTestEntryDetail();
						//BloodResultEntryDetails resultEntrydetail=new BloodResultEntryDetails();
						
						DgMasInvestigation masInvestigation = new DgMasInvestigation();
						try {
							if (investigationList.get(i) != null
									&& !investigationList.get(i).equals("0")) {

								int investigationId = Integer
										.parseInt(investigationList.get(i)
												.toString());
								masInvestigation.setId(investigationId);
								testEntryDetail.setInvestigation(masInvestigation);
								//resultEntrydetail.setInvestigation(masInvestigation);

								if (result != null && !result.equals("")) {
									testEntryDetail.setResult((String) result.get(i));
									//resultEntrydetail.setResult((String) result.get(i));
								}
								if (infoMap.get("testEntryHeader") != null) {
									testEntryDetail
											.setTestHeader(testEntryHeader);

								}
								//resultEntrydetail.setHeader(resultEntryHeader);
								
								if (infoMap.get("testEntryHeader") != null) {
									testEntryDetail
											.setTestHeader(testEntryHeader);

								} else {
									BloodTestEntryHeader bloodTestHeader = new BloodTestEntryHeader();
									bloodTestHeader
											.setId(componentMainIdFromRequest);
									testEntryDetail
											.setTestHeader(testEntryHeader);
								}
							}
							//hbt.save(resultEntrydetail);
							hbt.save(testEntryDetail);
							
							
							//tnx.commit();
						       session.flush();
							
							/*BloodSampleScreeningHeader bloodSampleScreenH=new BloodSampleScreeningHeader();
							bloodSampleScreenH.setResultEntryStatus("C");*/
							
							success = true;

						} catch (RuntimeException e) {
							//tnx.rollback();
							e.printStackTrace();
						}

					}
				}
			}
			saved = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.bloodBank.dataservice.BloodBankDataService#saveAssesstment(jkt
	 * .hms.util.Box)
	 */
	public Map<String,Object> saveAssesstment(Box box) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		boolean save = false;
		String name = "";
		String sequenceNumber = "";
		String code = "";
		String defferedType = "";
		String status = "";
		String category = "";

		name = box.getString("assesstmentName");
		code = box.getString("assesstmentCode");
		sequenceNumber = box.getString("sequenceNumber");
		defferedType = box.getString("type");
		status = box.getString("status");
		category = box.getString("category");
		// Date changedTime =
		// HMSUtil.convertStringTypeDateToDateType(box.getString("currentTime"));

		MasAssessment assesstment = new MasAssessment();
		assesstment.setLastChgTime(box.getString("currentTime"));
		// assesstment.setLastChgDate(changedTime);
		/* assesstment.setLastChgBy(lastChgBy); */
		if (!name.equals("")) {
			assesstment.setAssessmentName(name);
		}
		if (!code.equals("")) {
			assesstment.setAssessmentCode(code);
		}
		if (!sequenceNumber.equals("")) {
			assesstment.setAssessmentSeqNo(sequenceNumber);
		}
		if (!defferedType.equals("")) {
			assesstment.setAssessmentType(defferedType);
			;
		}
		if (!status.equals("")) {
			assesstment.setStatus(status);
		}
		if (!category.equals("")) {
			assesstment.setAssessmentCategory(category);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean checkDuplicateAssessstment=checkDuplicateAssessstment(box);
		if(!checkDuplicateAssessstment){
		hbt.saveOrUpdate(assesstment);
		save = true;
		}
		map.put("save", save);
		map.put("checkDuplicateAssessstment", checkDuplicateAssessstment);
		return map;

	}
	
	public boolean checkDuplicateAssessstment(Box box){
		boolean duplicateStatus = false;
		String name = "";
		String sequenceNumber = "";
		String code = "";
		String defferedType = "";
		String status = "";
		String category = "";
 List<MasAssessment> assessmentListy=new ArrayList<MasAssessment>();
 List<MasAssessment> assessmentListname=new ArrayList<MasAssessment>();
		name = box.getString("assesstmentName");
		code = box.getString("assesstmentCode");
		sequenceNumber = box.getString("sequenceNumber");
		defferedType = box.getString("type");
		status = box.getString("status");
		category = box.getString("category");
		// Date changedTime =
		// HMSUtil.convertStringTypeDateToDateType(box.getString("currentTime"));

		MasAssessment assesstment = new MasAssessment();
		assesstment.setLastChgTime(box.getString("currentTime"));
		// assesstment.setLastChgDate(changedTime);
		/* assesstment.setLastChgBy(lastChgBy); */
		if (!name.equals("")) {
			assesstment.setAssessmentName(name);
		}
		if (!code.equals("")) {
			assesstment.setAssessmentCode(code);
		}
		if (!sequenceNumber.equals("")) {
			assesstment.setAssessmentSeqNo(sequenceNumber);
		}
		if (!defferedType.equals("")) {
			assesstment.setAssessmentType(defferedType);
			;
		}
		if (!status.equals("")) {
			assesstment.setStatus(status);
		}
		if (!category.equals("")) {
			assesstment.setAssessmentCategory(category);
		}
		 Session session=(Session) getSession();
		 Criteria crt=null;
		 crt=session.createCriteria(MasAssessment.class)
				 .add(Restrictions.eq("AssessmentSeqNo", sequenceNumber));
		 assessmentListy=crt.list();
		 
		crt=session.createCriteria(MasAssessment.class).add(Restrictions.eq("AssessmentName", name));
		assessmentListname=crt.list();
		 if(null !=assessmentListy && assessmentListy.size()>0){
			 duplicateStatus=true;
		 }
		 if(null !=assessmentListname && assessmentListname.size()>0){
			 duplicateStatus=true;
		 }
		return duplicateStatus;
		
	}

	public Map<String, Object> getPatientDetailBloodIssue(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleScreeningHeader> patientDetailList = new ArrayList<BloodSampleScreeningHeader>();

		Date fromDate = new Date();
		Date toDate = new Date();

		String hinNo = "";
		String serPersonName = "";
		String patientFName = "";
		String patientLName = "";
		String adNo = "";
		String orderNo = "";
		String pType = "";
		int hinId = 0;
		int deptId = 0;
		int sampleId = 0;

		Criteria crit = null;
		Session session = (Session) getSession();

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("departmentId") != null) {
			deptId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}

		try {
			crit = session
					.createCriteria(BloodSampleScreeningHeader.class)
					.add(Restrictions.eq("BloodIssue", "n"))
					.add(Restrictions.between("SampleTestDate", fromDate,
							toDate));
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.like("ip.AdNo", adNo + "%"));

				if (deptId != 0) {
					crit = crit.createAlias("ip.Department", "dept").add(
							Restrictions.eq("dept.Id", deptId));
				}
			}
			if (!hinNo.equals("") || !patientFName.equals("")
					|| !patientLName.equals("") || !pType.equals("")) {
				crit = crit.createAlias("Hin", "pt");

			}

			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PLastName", patientLName
						+ "%"));
			}
			if (!pType.equals("")) {
				if (pType.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"In Patient"));
				} else if (pType.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus",
							"Out Patient"));
				}
			}
			patientDetailList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public String getBloodIssueSeqForDisplay(String string) {
		List<Integer> monthlySeqNoList = new ArrayList<Integer>();
		List<BloodIssueHeader> seqNoList = new ArrayList<BloodIssueHeader>();
		String monthlySeqNo = "";
		String lastSeqNo = "";
		String lastSeqMonth = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session.createCriteria(BloodIssueHeader.class).list();
			if (seqNoList.size() > 0) {
				for (BloodIssueHeader issueHeader : seqNoList) {
					lastSeqNo = issueHeader.getMonthlyNo();
				}
				if(null !=lastSeqNo && !lastSeqNo.isEmpty()){
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqMonth = str.nextToken();
				}
				}
			}
			monthlySeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "MIN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (monthlySeqNoList.get(0) == null || monthlySeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodIssueHeader");
				tsObj.setTransactionPrefix("MIN");
				tsObj.setTransactionSequenceName("Monthly Issue No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				monthlySeqNo = String.valueOf(1);
			} else if (monthlySeqNoList.size() > 0) {
				for (Integer maxOrderNo : monthlySeqNoList) {
					if (currentMonth.equals(lastSeqMonth)) {
						monthlySeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						monthlySeqNo = String.valueOf(1);
					}
				}
			}
			monthlySeqNo = monthlySeqNo.concat("/").concat(
					String.valueOf(currentMonth));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return monthlySeqNo;
	}

	/*public Map<String, Object> showBloodIssueJsp(int screeningId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		Set<BloodMasComponent> componentList = new HashSet<BloodMasComponent>();

		int hinId = 0;
		int requestHdId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			bloodGroupList = session.createCriteria(MasBloodGroup.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (bloodGroupList.size() > 0) {
				detailsMap.put("bloodGroupList", bloodGroupList);
			}
			screeningList = session
					.createCriteria(BloodSampleScreeningHeader.class)
					.add(Restrictions.eq("BloodIssue", "n"))
					.add(Restrictions.eq("Id", screeningId)).list();
			if (screeningList != null && screeningList.size() > 0) {
				Set<BloodRequestEntryDetail> bloodRequestEntryDetailsSet = screeningList
						.get(0).getSampleCollection().getRequest()
						.getBloodRequestEntryDetails();
				for (BloodRequestEntryDetail bloodRequestEntryDetail : bloodRequestEntryDetailsSet) {
					componentList.add(bloodRequestEntryDetail.getComponent());

				}
			}
			// componentList =
			// session.createCriteria(BloodMasComponent.class).add(Restrictions.eq("Status",
			// "y")).list();
			detailsMap.put("componentList", componentList);

			stockList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.BloodStockDetail");
			detailsMap.put("stockList", stockList);

			if (screeningList != null && screeningList.size() > 0) {
				detailsMap.put("screeningList", screeningList);
				hinId = screeningList.get(0).getHin().getId();
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}
*/
	
	public Map<String, Object> showBloodIssueJsp(int crossMatchHeaderId) {
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BldCrossmatchDetail> bldCrossMatchDetalList=new ArrayList<BldCrossmatchDetail>();
		List<BloodRequestEntryDetail> bldRequstEnrtyDetailList=new ArrayList<BloodRequestEntryDetail>();
		List<BldCrossmatchBagDetail> bldcossBagDetailList=new ArrayList<BldCrossmatchBagDetail>();
		
		BldCrossmatchingHeader bldCrossHeader=null;
		int bldrequestheaderId=0;
		
		Session session = (Session) getSession();
		
		 bldCrossHeader=(BldCrossmatchingHeader) session.load(BldCrossmatchingHeader.class, crossMatchHeaderId);
		 bldrequestheaderId=bldCrossHeader.getBldRequest().getId();
		 
		 Criteria crt=null;
		 
		 crt=session.createCriteria(BldCrossmatchBagDetail.class).createAlias("BldCrossmatchingHeader", "header")
				 .add(Restrictions.eq("header.Id", crossMatchHeaderId));
		 bldcossBagDetailList=crt.list();
		 
		 crt=session.createCriteria(BldCrossmatchDetail.class).createAlias("BldCrossmatchingHeader", "header")
				 .add(Restrictions.eq("header.Id", crossMatchHeaderId));
		 
		 bldCrossMatchDetalList=crt.list();
		 
		 crt=session.createCriteria(BloodRequestEntryDetail.class).createAlias("Request", "Request")
				 .add(Restrictions.eq("Request.Id", bldrequestheaderId));
		 bldRequstEnrtyDetailList=crt.list();
		 String ProvisDiagnosis="";
		 for(BloodRequestEntryDetail dtl:bldRequstEnrtyDetailList){
			 ProvisDiagnosis=dtl.getRequest().getRemarks();
		 }
		 
		 
		 
		//System.out.println("bldRequstEnrtyDetailList "+bldRequstEnrtyDetailList.size());
		 
		
		detailsMap.put("crossMatchHeaderId", crossMatchHeaderId);
		detailsMap.put("bldrequestheaderId", bldrequestheaderId);
		 detailsMap.put("bldcossBagDetailList", bldcossBagDetailList);
		 detailsMap.put("bldRequstEnrtyDetailList", bldRequstEnrtyDetailList);
		 detailsMap.put("bldCrossMatchDetalList", bldCrossMatchDetalList);
		 detailsMap.put("bldCrossHeader", bldCrossHeader);
		detailsMap.put("ProvisDiagnosis", ProvisDiagnosis);
		return detailsMap;
	}

	
	public String generateMonthlyNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String monthlySeqNo = "";
		List<TransactionSequence> monthlySeqNoList = new ArrayList<TransactionSequence>();
		List<BloodIssueHeader> seqNoList = new ArrayList<BloodIssueHeader>();
		String lastSeqNo = "";
		String lastSeqMonth = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		Session session = (Session) getSession();

		seqNoList = session.createCriteria(BloodIssueHeader.class).list();
		if (seqNoList.size() > 0) {
			for (BloodIssueHeader bloodIssueHeader : seqNoList) {
				lastSeqNo = bloodIssueHeader.getMonthlyNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqMonth = str.nextToken();

			}
		}
		monthlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MIN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (monthlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : monthlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) monthlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentMonth.equals(lastSeqMonth)) {
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
				monthlySeqNo = monthlySeqNo.concat("/").concat(
						String.valueOf(currentMonth));
			}
		} else if (monthlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodIssueHeader");
			tsObj.setTransactionPrefix("MIN");
			tsObj.setTransactionSequenceName("Monthly Issue No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			monthlySeqNo = monthlySeqNo.concat("/").concat(
					String.valueOf(currentMonth));
		}
		return monthlySeqNo;
	}
	
	public boolean submitBloodIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		
		BloodIssueHeader bloodIssueHeader = new BloodIssueHeader();
		Session session = (Session) getSession();
		 int bloodBankId=box.getInt("hospitalId");
		 int deptId=box.getInt("deptId");
		 MasHospital masHospital=new MasHospital();
		 masHospital.setId(bloodBankId);
		 MasDepartment depart=new MasDepartment();
		 depart.setId(deptId);
		 
			/*int userId =box.getInt("userId ");
			Users user=new Users();
			user.setId(userId);*/
			
			int empId=box.getInt("empId");
			MasEmployee issuedBy=new MasEmployee();
			issuedBy.setId(empId);
		 
		int crossMatchHeaderId=box.getInt("crossMatchHeaderName");
		int bldrequestheaderId=box.getInt("bldrequestHeaderName");
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		
		 BldCrossmatchingHeader crossmatchHeader=null;
		 
		 crossmatchHeader=(BldCrossmatchingHeader) session.createCriteria(BldCrossmatchingHeader.class)
				 .createAlias("BldBankId", "bloodBank")
				 .add(Restrictions.eq("bloodBank.Id", bloodBankId))
				 .add(Restrictions.eq("Id", crossMatchHeaderId)).list().get(0);
		
		 
		 crossmatchHeader.setId(crossMatchHeaderId); 
		 crossmatchHeader.setBloodIssueStatus("C");
		 
		 BloodRequestEntryHeader requestEntryhd=null;
		// requestEntryhd=(BloodRequestEntryHeader) session.load(BloodRequestEntryHeader.class, bldrequestheaderId);
		 requestEntryhd=crossmatchHeader.getBldRequest();
		/* requestEntryhd.setId(bldrequestheaderId);*/
		 requestEntryhd.setBloodRequestStatus("C");
		 
		 bloodIssueHeader.setHin(crossmatchHeader.getBldRequest().getHin());
		 MasHospital bldRequestedHospital=new MasHospital();
		 bldRequestedHospital.setId(crossmatchHeader.getBldRequestHospitalId().getId());
		 bloodIssueHeader.setBldRequestHospitalId(bldRequestedHospital);
		 bloodIssueHeader.setBloodRequestHd(requestEntryhd);
		 bloodIssueHeader.setBloodCrossHd(crossmatchHeader);
		 bloodIssueHeader.setIssueDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		 bloodIssueHeader.setIssueTime(time);
		 bloodIssueHeader.setHospital(masHospital);
		 bloodIssueHeader.setDepartment(depart);
		 bloodIssueHeader.setBldTransfussionStatus("P");
		 bloodIssueHeader.setIssuedBy(issuedBy);
			Transaction tnx=null;
		
		List stockList = new ArrayList();
		List componentList = new ArrayList();
		
		List<String> bags=new ArrayList<String>();
		
		bags=box.getArrayList("reserBag");
		int stockId=0;
		List<BloodStockDetail> stockDetailList=new ArrayList<BloodStockDetail>();
		Criteria crt=null;
		BloodStockDetail stock=new BloodStockDetail();
		try{
			
			tnx=session.beginTransaction();
			 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.saveOrUpdate(requestEntryhd);
				hbt.saveOrUpdate(crossmatchHeader);
				hbt.save(bloodIssueHeader);
				
				for(int i=0;i<bags.size();i++){
					crt=session.createCriteria(BloodStockDetail.class)
							.createAlias("StockMain", "stockMain")
							.createAlias("stockMain.Hospital", "hosp")
							.add(Restrictions.eq("hosp.Id",bloodBankId))
							.add(Restrictions.eq("BloodBagNo",bags.get(i) ));
					// stockDetailList=crt.list();
					stock=(BloodStockDetail) crt.list().get(0);
					//for(BloodStockDetail bsd:stockDetailList){
						stockId=stock.getId();
				//	}
					BloodIssueDetail bldIssueDetail=new BloodIssueDetail();
					
					
					//stock.setId(stockId);
					stock.setBldIssuedHospitalId(bldRequestedHospital);
					stock.setBloodIssued("c");
					hbt.saveOrUpdate(stock);
					
					bldIssueDetail.setStockDetail(stock);
					bldIssueDetail.setIssueHeader(bloodIssueHeader);
					bldIssueDetail.setBldAckPending("P");
					
					hbt.save(bldIssueDetail);
					

					
				}
				
				
				tnx.commit();
				saved=true;
				
		}
		catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		
		return saved;

	

	}


	/*public boolean submitBloodIssue(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		BloodIssueHeader bloodIssueHeader = new BloodIssueHeader();
		List stockList = new ArrayList();
		List componentList = new ArrayList();
		Session session = (Session) getSession();

		int componentMainIdFromRequest = 0;
		int issuehdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String userName = "";
		String testSeqNo = "";
		String result = "";
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("bloodIssueHeader") != null) {
			bloodIssueHeader = (BloodIssueHeader) infoMap
					.get("bloodIssueHeader");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("testSeqNo") != null) {
			testSeqNo = (String) infoMap.get("testSeqNo");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		List<Inpatient> inPatientList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.Inpatient as isc where isc.AdStatus='A' and isc.Hin.Id="
						+ hinId);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int sreeningId = (Integer) box.getInt("sreeningId");
			if (infoMap.get("bloodIssueHeader") != null) {
				bloodIssueHeader = (BloodIssueHeader) infoMap
						.get("bloodIssueHeader");
				if (inPatientList.size() > 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inPatientList.get(0).getId());
					// bloodIssueHeader.setInpatient(inpatient);
				}
				hbt.save(bloodIssueHeader);
				issuehdId = bloodIssueHeader.getId();
				map.put("issuehdId", issuehdId);
			} else {

				BloodIssueHeader issueHeader = new BloodIssueHeader();
				issueHeader = (BloodIssueHeader) hbt.load(
						BloodIssueHeader.class, componentMainIdFromRequest);
				hbt.update(issueHeader);
			}
			int screenHdId = bloodIssueHeader.getScreeningHd().getId();
			BloodSampleScreeningHeader sampleScreening = (BloodSampleScreeningHeader) hbt
					.load(BloodSampleScreeningHeader.class, screenHdId);
			sampleScreening.setBloodIssue("y");
			hbt.update(sampleScreening);
			hbt.refresh(sampleScreening);

			if (infoMap.get("stockList") != null) {
				stockList = (List) infoMap.get("stockList");
				if (stockList.size() > 0) {
					for (int i = 0; i < stockList.size(); i++) {

						BloodIssueDetail bloodIssueDetail = new BloodIssueDetail();
						BloodStockDetail bloodStockDetail = new BloodStockDetail();
						BloodMasComponent masComponent = new BloodMasComponent();
						try {
							if (stockList.get(i) != null
									&& !stockList.get(i).equals("")) {
								int stockDetailId = Integer.parseInt(stockList
										.get(i).toString());
								bloodStockDetail.setId(stockDetailId);
								bloodIssueDetail
										.setStockDetail(bloodStockDetail);

								if (infoMap.get("bloodIssueHeader") != null) {
									bloodIssueDetail
											.setIssueHeader(bloodIssueHeader);

								} else {
									BloodIssueHeader bloodissue = new BloodIssueHeader();
									bloodissue
											.setId(componentMainIdFromRequest);
									bloodIssueDetail.setIssueHeader(bloodissue);
								}

								hbt.save(bloodIssueDetail);

								int stockId = Integer.parseInt(stockList.get(i)
										.toString());
								BloodStockDetail stockDetail = (BloodStockDetail) getHibernateTemplate()
										.load(BloodStockDetail.class, stockId);
								stockDetail.setBloodIssued("y");
								hbt.update(stockDetail);
								hbt.refresh(stockDetail);

								saved = true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;

	}
*/
	public String getDiscardSeqForDisplay(String string) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		String discardSeqNo = "";
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			seqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "DSN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (seqNoList.get(0) == null || seqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodDiscardEntry");
				tsObj.setTransactionPrefix("DSN");
				tsObj.setTransactionSequenceName("Discard No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				discardSeqNo = String.valueOf(1);
			} else if (seqNoList.size() > 0) {
				maxSeqNo = seqNoList.get(0);
				discardSeqNo = String.valueOf(maxSeqNo + 1);
			} else {
				discardSeqNo = String.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return discardSeqNo;
	}

	public String generateDiscardNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String discardSeqNo = "";
		int discardNo = 0;
		List<TransactionSequence> discardSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodDiscardEntry> seqNoList = new ArrayList<BloodDiscardEntry>();
		String lastSeqNo = "";
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodDiscardEntry.class).list();
		if (seqNoList.size() > 0) {
			for (BloodDiscardEntry bloodDiscardEntry : seqNoList) {
				lastSeqNo = bloodDiscardEntry.getDiscardNo();
			}
		}
		discardSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DSN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (discardSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : discardSeqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				discardNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(discardNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (discardSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodDiscardEntry");
			tsObj.setTransactionPrefix("DSN");
			tsObj.setTransactionSequenceName("Discard No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
		}
		discardSeqNo = String.valueOf(discardNo);
		return discardSeqNo;
	}

	public boolean submitBloodDiscard(Map<String, Object> parameterMap) {
		boolean saved = false;
		BloodDiscardEntry bloodDiscardEntry = new BloodDiscardEntry();
		if (parameterMap.get("bloodDiscardEntry") != null) {
			bloodDiscardEntry = (BloodDiscardEntry) parameterMap
					.get("bloodDiscardEntry");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(bloodDiscardEntry);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			int stockDetailId = (Integer) parameterMap.get("stockDetailId");

			BloodStockDetail bloodStockDetail = (BloodStockDetail) hbt1.load(
					BloodStockDetail.class, stockDetailId);
			bloodStockDetail.setBloodIssued("d");
			hbt1.update(bloodStockDetail);
			hbt1.refresh(bloodStockDetail);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		saved = true;
		return saved;
	}

	public Map<String, Object> showSearchPatientForReactionJsp(int hospitalId) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		List<BloodRequestEntryHeader> bldReqHeaderList = new ArrayList<BloodRequestEntryHeader>();
		List<BloodIssueDetail> bldIssudeDetailList = new ArrayList<BloodIssueDetail>();
		
		Session session = (Session) getSession();
		Criteria crit = null;
		try {
			wardList = session.createCriteria(MasDepartment.class)
					
					.add(Restrictions.eq("PaywardCheck", "y").ignoreCase()).list();
			map.put("wardList", wardList);
			
			java.sql.Date sqlDate = new java.sql.Date( new Date().getTime());
		   
			
			crit=session.createCriteria(BloodIssueDetail.class)
					
					.createAlias("IssueHeader", "issueHeader")
					.createAlias("issueHeader.BldRequestHospitalId", "bldRequestHospitalId")
					.createAlias("issueHeader.BloodRequestHd", "bldRequestHeader")
					.add(Restrictions.eq("BldAckPending", "A").ignoreCase())
					.add(Restrictions.eq("issueHeader.BldTransfussionStatus","P").ignoreCase())
					.add(Restrictions.eq("issueHeader.IssueDate", sqlDate))
					.add(Restrictions.or(Restrictions.eq("bldRequestHospitalId.Id", hospitalId), 
							Restrictions.eq("bldRequestHeader.BloodBank.Id", hospitalId)));
					//.add(Restrictions.eq("BloodRequestStatus", "c").ignoreCase());
			bldIssudeDetailList=crit.list();
			
			
			crit=session.createCriteria(BloodRequestEntryHeader.class).createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("BloodRequestStatus", "c").ignoreCase());
			bldReqHeaderList=crit.list();
			
			
			
			map.put("bldIssudeDetailList", bldIssudeDetailList);
			map.put("bldReqHeaderList", bldReqHeaderList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see jkt.hms.bloodBank.dataservice.BloodBankDataService#searchPatientForBloodReaction(java.util.Map)
	 */
	public Map<String, Object> searchPatientForBloodReaction(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> bldReqHeaderList = new ArrayList<BloodRequestEntryHeader>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		String hinNo = "";
		String adNo = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}

		try {
			Criteria crit = null;
			int patientHinId=0;
			
			crit=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo));
			patientList=crit.list();
			if(null !=patientList){
				
			}
			
					
			crit=session.createCriteria(BloodRequestEntryHeader.class)
					.add(Restrictions.eq("RequestStatus", "V").ignoreCase());
			
			/*if (!adNo.equals("")) {
				crit = crit.add(Restrictions.like("Ip.AdNo", adNo + "%"));
			}
			*/
			
			
			if (!hinNo.equals("") || !patientFName.equals("")
					|| !patientLName.equals("")) {
				 crit.createAlias("Hin", "hn");
				if (!hinNo.equals("")) {
					 crit.add(Restrictions.eq("hn.HinNo", hinNo));
				}

				if (!patientFName.equals("")) {
					 crit.add(Restrictions.like("hn.PFirstName",patientFName + "%"));
				}
				

			}
			bldReqHeaderList = crit.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		wardList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("bldReqHeaderList", bldReqHeaderList);
		map.put("wardList", wardList);

		return map;
	}

	public Map<String, Object> showReactionFormEntryJsp(int bldIssueDeatialId,int hospitalId,int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		//List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		//List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<BloodRequestEntryHeader> bldRequestEntryHeaderList=new ArrayList<BloodRequestEntryHeader>();
		List<BldCrossmatchDetail> bldCrossMatchDetailList=new ArrayList<BldCrossmatchDetail>();
		List<BldCrossmatchingHeader> bldCrossMatchHeaderList=new ArrayList<BldCrossmatchingHeader>();
		
		
		List<BloodIssueDetail> bldIssueDetailList=new ArrayList<BloodIssueDetail>();

		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		BloodIssueDetail bldIssueDetail=new BloodIssueDetail();
		BldCrossmatchBagDetail bldCrossMatchBagDetail=new BldCrossmatchBagDetail();
		
		Session session = (Session) getSession();
		int requestId=0;
		int bldHeaderId=0;
		int bldCrossMatchHdId=0;

		try {
			//System.out.println("@@@@@@@@@@bldIssueDeatialId "+bldIssueDeatialId);
			bldIssueDetailList=session.createCriteria(BloodIssueDetail.class)
					
					.createAlias("IssueHeader", "issueHeader")
					.createAlias("issueHeader.BldRequestHospitalId", "bldRequestHospitalId")
					.add(Restrictions.eq("bldRequestHospitalId.Id", hospitalId))
					.add(Restrictions.eq("Id", bldIssueDeatialId))
					//.add(Restrictions.eq("issueHeader.BldTransfussionStatus", "C").ignoreCase())
					.add(Restrictions.eq("BldAckPending", "A").ignoreCase()).list();
			
			//System.out.println("bldIssueDetailList  "+bldIssueDetailList.size());
			if(bldIssueDetailList != null && bldIssueDetailList.size()>0){
				bldIssueDetail = bldIssueDetailList.get(0);	
				bldCrossMatchHdId=bldIssueDetail.getIssueHeader().getBloodCrossHd().getId();
				requestId=bldIssueDetail.getIssueHeader().getBloodRequestHd().getId();
			}
			//System.out.println("bldCrossMatchBagDetail "+bldCrossMatchHdId);
			//System.out.println("hospitalId "+hospitalId);
			
			
			Criteria crt=null;
			if(bldCrossMatchHdId>0){
				 crt= session.createCriteria(BldCrossmatchBagDetail.class)
					.createAlias("BldCrossmatchingHeader", "bldCrossmatchingHeader")
					.createAlias("BldCrossmatchingHeader.BldRequestHospitalId", "bldRequestHospitalId")
					.add(Restrictions.eq("bldRequestHospitalId.Id", hospitalId))
					.add(Restrictions.eq("bldCrossmatchingHeader.Id", bldCrossMatchHdId));
			}
			if(crt !=null && crt.list() !=null && crt.list().size()>0){
				bldCrossMatchBagDetail=(BldCrossmatchBagDetail) crt.list().get(0);
			}
			
			//System.out.println("bldCrossMatchBagDetail "+bldCrossMatchBagDetail.getId() + "size "+crt.list().size());
			
			/*bldRequestEntryHeaderList = session.createCriteria(BloodRequestEntryHeader.class)
					.createAlias("Inpatient", "Ip")
					.add(Restrictions.eq("Ip.Id", inpatientId)).list();*/
			/*if(null !=bldRequestEntryHeaderList && bldRequestEntryHeaderList.size()>0){
				for(BloodRequestEntryHeader breh:bldRequestEntryHeaderList){
					requestId=breh.getId();
					
				}
				
				bldCrossMatchHeaderList=session.createCriteria(BldCrossmatchingHeader.class)
						.createAlias("BldRequest", "bldRequest")
						.add(Restrictions.eq("bldRequest.Id", requestId)).list();
				for(BldCrossmatchingHeader bcmh:bldCrossMatchHeaderList){
					bldHeaderId=bcmh.getId();
				}*/
						
				
				bldCrossMatchDetailList = session.createCriteria(BldCrossmatchDetail.class)
						.createAlias("BldCrossmatchingHeader", "bldCrossmatchingHeader")
						.createAlias("BldCrossmatchingHeader.BldRequestHospitalId", "bldRequestHospitalId")
						.createAlias("BldCrossmatchingHeader.BldRequest", "bldRequest")
						.add(Restrictions.eq("bldRequestHospitalId.Id", hospitalId))
						.add(Restrictions.eq("bldRequest.Id", requestId))
						.add(Restrictions.eq("bldCrossmatchingHeader.Id", bldCrossMatchHdId)).list();
				
			//}
			
			/*inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId))
					.add(Restrictions.eq("AdStatus", "A")).list();*/
			/*if (inpatientList != null || inpatientList.size() > 0) {
				detailsMap.put("inpatientList", inpatientList);
			}*/
			/*employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
			//		.add(Restrictions.eq("Department.Id", deptId))
					
					.list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}*/
			bloodGroupList = session.createCriteria(MasBloodGroup.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (bloodGroupList.size() > 0) {
				detailsMap.put("bloodGroupList", bloodGroupList);
			}

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (sexList.size() > 0) {
				detailsMap.put("sexList", sexList);
			}
			stockList = session.createCriteria(BloodStockDetail.class).list();
			if (stockList.size() > 0) {
				detailsMap.put("stockList", stockList);
			}
			
			detailsMap.put("bldCrossMatchDetailList", bldCrossMatchDetailList);
			detailsMap.put("bldIssueDetailList", bldIssueDetailList);
			detailsMap.put("bldCrossMatchBagDetail", bldCrossMatchBagDetail);
			
		} catch (HibernateException e) {
			String msg="No Blood Transfusion Related Data Available";
			detailsMap.put("msg", msg);	
		}
		return detailsMap;
	}

	public String getEntrySeqForDisplay(String string) {
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodReactionEntry> seqNoList = new ArrayList<BloodReactionEntry>();
		String entrySeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";
		int sequenceNo=0;

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			Criteria crt=null;
			seqNoList = session.createCriteria(BloodReactionEntry.class).list();
			 if(null != crt && null !=crt.list() && null !=crt.list().get(0)){
			 seqNoList=crt.list();
			
				for (BloodReactionEntry bloodReactionEntry : seqNoList) {
					lastSeqNo = bloodReactionEntry.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}
			orderSeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "EN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (orderSeqNoList.get(0) == null || orderSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodReactionEntry");
				tsObj.setTransactionPrefix("EN");
				tsObj.setTransactionSequenceName("Entry No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				sequenceNo = 1;
			} else if (orderSeqNoList.size() > 0) {
				int id =0;
				for (TransactionSequence transactionSequence : orderSeqNoList) {
					TransactionSequence obj = (TransactionSequence) orderSeqNoList.get(0);
				
				 id = obj.getId();
			
					if (currentYear.equals(lastSeqYear)) {
						sequenceNo = transactionSequence.getTransactionSequenceNumber();
					} 
				
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(sequenceNo + 1);
				++sequenceNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
			}
			entrySeqNo = String.valueOf(sequenceNo).concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	@SuppressWarnings("unchecked")
	public String generateEntryNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String entrySeqNo = "";
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<BloodReactionEntry> seqNoList = new ArrayList<BloodReactionEntry>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(BloodReactionEntry.class).list();
		if (seqNoList.size() > 0) {
			for (BloodReactionEntry bloodReactionEntry : seqNoList) {
				lastSeqNo = bloodReactionEntry.getEntryNo();

			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		orderSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "EN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
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
				entrySeqNo = entrySeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodReactionEntry");
			tsObj.setTransactionPrefix("EN");
			tsObj.setTransactionSequenceName("Entry No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return entrySeqNo;
	}

	public boolean submitBloodReactionEntry(
			BloodReactionEntry bldReactionEntry, Box box) {
		//Session session = (Session) getSession();asdasd
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		BloodReactionEntry bldReactionEntryHead1=new  BloodReactionEntry();
		bldReactionEntryHead1=bldReactionEntry;
		
		Session session = (Session) getSession();
		boolean saved = false;
		
		List<BloodStockDetail> bloodStockDetail=new ArrayList<BloodStockDetail>();
		String bloodBag=bldReactionEntryHead1.getBloodBagNo();
		
		String bloodDiscardStatus="";
		if(box.get("returnToBloodBank").equalsIgnoreCase("y")){
			bloodDiscardStatus="y";
			Query query=session.createQuery("update BloodStockDetail set BloodDiscard=:bloodDiscard where BloodBagNo=:bagNo");
			query.setString	("bloodDiscard", bloodDiscardStatus);
			query.setString("bagNo", bloodBag);
			int modifications=query.executeUpdate();
		}else{
			bloodDiscardStatus="n";
		}
		
		int bldIssueDeatialId=box.getInt("bldIssueDeatialId");
		int requestEdBloodBankId=box.getInt("requestEdBloodBankId");
		MasHospital hospital=new MasHospital();
		hospital.setId(requestEdBloodBankId);
		Transaction tnx = null;
		try {
			
			tnx = session.beginTransaction();
			
			BloodIssueDetail bloodIssueDetail=(BloodIssueDetail) session.createCriteria(BloodIssueDetail.class)
					 .createAlias("IssueHeader", "IssueHeader")
					  .createAlias("IssueHeader.BldRequestHospitalId", "hospital")
					  .add(Restrictions.eq("Id", bldIssueDeatialId))
					 .add(Restrictions.eq("BldAckPending", "A").ignoreCase())
					 .add(Restrictions.eq("Id", bldIssueDeatialId)).list().get(0);
			 
			 bloodIssueDetail.setBldAckPending("C");
			 BloodIssueHeader bloodIssueHeader=bloodIssueDetail.getIssueHeader();
			 bloodIssueHeader.setBldTransfussionStatus("C");
			
			 hbt.saveOrUpdate(bloodIssueHeader);
			 hbt.saveOrUpdate(bloodIssueDetail);
			 
			 bldReactionEntryHead1.setBloodBankId(hospital);
			hbt.save(bldReactionEntryHead1);
			int bldReactionHeaderId =bldReactionEntryHead1.getId();
			
			
			if (box.getArrayList("reaction").size() > 0) {
				for (String reaction : (List<String>) box
						.getArrayList("reaction")) {
					BloodReactionEntry bldReactionEntryHead=new  BloodReactionEntry();
					bldReactionEntryHead.setId(bldReactionHeaderId);
					BloodReactionEntryDetails bldReactionDetails = new BloodReactionEntryDetails();
					bldReactionDetails.setEntryHeader(bldReactionEntryHead);
					bldReactionDetails.setHospital(bldReactionEntry
							.getHospital());
					bldReactionDetails.setLastChgBy(bldReactionEntry
							.getLastChgBy());
					bldReactionDetails.setLastChgDate(bldReactionEntry
							.getLastChgDate());
					bldReactionDetails.setLastChgTime(bldReactionEntry
							.getLastChgTime());
					bldReactionDetails.setBloodReactionName(reaction);
					hbt.save(bldReactionDetails);
				}
			}
			 
			/*if (!tnx.wasCommitted()){
				
			}
			  */
			//session.flush();
			session.flush();
	        session.clear();
			tnx.commit();
			//tnx.commit();
			/*hbt.flush();
			hbt.clear();*/
			// session.close();
			
			
			saved = true;

		} catch (Exception e) {
			saved = false;
			e.printStackTrace();
				tnx.rollback();
			
			
		}
		return saved;
	}

	public Map<String, Object> showDirectIndirectRegisterReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		investigationList = session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("investigationList", investigationList);
		return map;
	}

	public String getSerialSeqForDisplay(String string) {
		List<Integer> serialSeqNoList = new ArrayList<Integer>();
		List<BloodTestEntryHeader> seqNoList = new ArrayList<BloodTestEntryHeader>();
		String serialSeqNo = "";
		String lastSeqNo = "";
		String lastSeqMonth = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			seqNoList = session.createCriteria(BloodTestEntryHeader.class)
					.list();
			if (seqNoList.size() > 0) {
				for (BloodTestEntryHeader bloodTestEntryHeader : seqNoList) {
					lastSeqNo = bloodTestEntryHeader.getSerialNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					str.nextToken();
					lastSeqMonth = str.nextToken();
				}
			}

			serialSeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "TSN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (serialSeqNoList.get(0) == null || serialSeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BloodReactionEntry");
				tsObj.setTransactionPrefix("TSN");
				tsObj.setTransactionSequenceName("Serial No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				serialSeqNo = String.valueOf(1);
			} else if (serialSeqNoList.size() > 0) {
				for (Integer maxOrderNo : serialSeqNoList) {
					if (currentMonth.equals(lastSeqMonth)) {
						serialSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						serialSeqNo = String.valueOf(1);
					}
				}
			}

			serialSeqNo = serialSeqNo.concat("/").concat(
					String.valueOf(currentMonth));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return serialSeqNo;
	}

	public String generateSerialNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String serialSeqNo = "";
		List<TransactionSequence> monthlySeqNoList = new ArrayList<TransactionSequence>();
		List<BloodTestEntryHeader> seqNoList = new ArrayList<BloodTestEntryHeader>();
		String lastSeqNo = "";
		String lastSeqMonth = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		Session session = (Session) getSession();

		seqNoList = session.createCriteria(BloodTestEntryHeader.class).list();
		if (seqNoList.size() > 0) {
			for (BloodTestEntryHeader bloodTestEntryHeader : seqNoList) {
				lastSeqNo = bloodTestEntryHeader.getSerialNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqMonth = str.nextToken();

			}
		}
		monthlySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "TSN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (monthlySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : monthlySeqNoList) {
				TransactionSequence obj = (TransactionSequence) monthlySeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if (currentMonth.equals(lastSeqMonth)) {
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
				serialSeqNo = serialSeqNo.concat("/").concat(
						String.valueOf(currentMonth));
			}
		} else if (monthlySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BloodTestEntryHeader");
			tsObj.setTransactionPrefix("TSN");
			tsObj.setTransactionSequenceName("Serial No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			serialSeqNo = serialSeqNo.concat("/").concat(
					String.valueOf(currentMonth));
		}
		return serialSeqNo;
	}

	public Map<String, Object> getDBConnection() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	public Map<String, Object> fillPatientDetail(Map map) {

		Session session = (Session) getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + map.get("hinNo");
			Criteria c = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", str));
			patientList = c.list();
			map.put("patientList", patientList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> showPatientSearchForDonationJsp(
			Map<String, Object> map) {
		
		List<BloodDonationEntryHeader> donorList = null;
		Map<String, Object> donormap = new HashMap<String, Object>();
		donorList = new ArrayList<BloodDonationEntryHeader>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		
		
		Criteria crit = null;
		Criteria criteriaCount = null;
		
		if (null != donorList) {
			donorList.clear();
		}
		Query query = null;
		int noOfRecords = 0;
		int noOfPages = 0;

		String donorName = "";
		String Uid = "";
		String mobilenumber = "";
		String bloodbankname = "";
		String bloodbanknumber = "";
		int genderId = 0;
		String donationReg = "";

		String qry = null;

		Box box = (Box) map.get("box");
		int page = box.getInt("page");
		int recordsPerPage = box.getInt("recordsPerPage");

		Session session = (Session) getSession();
		if (map.get("donationReg") != null) {
			donationReg = (String) map.get("donationReg");

		}
		if (map.get("donorname") != null) {
			donorName = (String) map.get("donorname");

		}
		if (map.get("genderId") != null) {
			genderId = (Integer) map.get("genderId");

		}
		if (map.get("UhID") != null) {
			Uid = (String) map.get("UhID");

		}
		if (map.get("mobilenumber") != null) {
			mobilenumber = (String) map.get("mobilenumber");

		}
		if (map.get("bloodbankname") != null) {
			bloodbankname = (String) map.get("bloodbankname");

		}
		if (map.get("bloodbanknumber") != null) {
			bloodbanknumber = (String) map.get("bloodbanknumber");

		}
		int hospitalId=0;
		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");

		}
		try {

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			donormap.put("sexList", sexList);

			crit = session.createCriteria(BloodDonationEntryHeader.class);
			criteriaCount = session
					.createCriteria(BloodDonationEntryHeader.class)
					.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id", hospitalId));
			
			if (genderId > 0) {

				crit.add(Restrictions.eq("Sex.Id", genderId));
				criteriaCount.add(Restrictions.eq("Sex.Id", genderId));
			}
			if (!donationReg.equals("")) {

				crit.add(Restrictions.like("DonationNo", donationReg));

				criteriaCount.add(Restrictions.like("DonationNo", donationReg));
			}
			if (!Uid.equals("")) {

				crit.add(Restrictions.like("UhidNo", Uid));
				criteriaCount.add(Restrictions.like("UhidNo", Uid));
			}
			if (!donorName.equals("")) {
				
				crit = crit
						.add(Restrictions.like("DonerName", donorName + "%").ignoreCase());
				criteriaCount.add(Restrictions.like("DonerName", donorName
						+ "%"));
			}
			if (!mobilenumber.equals("")) {
				crit = crit.add(Restrictions.like("MobNo", mobilenumber + "%"));
				criteriaCount.add(Restrictions
						.like("MobNo", mobilenumber + "%"));
			}
			if (!bloodbankname.equals("")) {
				crit = session.createCriteria(MasHospital.class).add(
						Restrictions.eq("HospitalName", bloodbankname));

			}

			criteriaCount.setProjection(Projections.rowCount());

			noOfRecords = (Integer) criteriaCount.uniqueResult();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			donormap.put("currentPage", page);
			donormap.put("noOfPages", noOfPages);
			crit.setFirstResult((page - 1) * recordsPerPage);
			crit.setMaxResults(recordsPerPage);

			
			donorList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		donormap.put("donorList", donorList);
		return donormap;
	}

	public Map<String, Object> getPatientForUpdateDonation(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
		Criteria crit = null;

		String hinNo = "";
		String donationNo = "";
		String donorName = "";
		int hinId = 0;

		Session session = (Session) getSession();
		if (mapForDs.get("donationNo") != null) {
			donationNo = (String) mapForDs.get("donationNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("donorName") != null) {
			donorName = (String) mapForDs.get("donorName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		try {
			crit = session.createCriteria(BloodDonationEntryHeader.class).add(
					Restrictions.eq("SampleScreening", "n"));

			if (!hinNo.equals("") || hinId != 0) {
				crit = crit.createAlias("Hin", "hn");
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
			}
			if (hinId != 0) {
				crit = crit.add(Restrictions.like("hn.PFirstName", "%"
						+ donorName));
			} else if (!donorName.equals("")) {
				crit = crit
						.add(Restrictions.like("DonerName", donorName + "%"));
			}
			if (!donationNo.equals("")) {
				crit = crit.add(Restrictions.like("DonationNo", donationNo
						+ "%"));
			}

			donorList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("donorList", donorList);
		return map;
	}

	public Map<String, Object> showUpdateDonationEntry(int bloodDonationId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasState> stateList = new ArrayList<MasState>();

		List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y")).list();
		stateList = session.createCriteria(MasState.class)
				.add(Restrictions.eq("Status", "y")).list();
		donorList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.BloodDonationEntryHeader as bld where bld.Id="
						+ bloodDonationId + " ");

		occupationList = session.createCriteria(MasOccupation.class)
				.add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.like("Status", "y"))
				.createAlias("Department", "dept")
				.createAlias("dept.DepartmentType", "deptType")
				.add(Restrictions.eq("deptType.Id", 24)).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y")).list();

		map.put("sexList", sexList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("employeeList", employeeList);
		map.put("stateList", stateList);

		map.put("occupationList", occupationList);
		map.put("donorList", donorList);
		return map;
	}

	public Map<String, Object> showPopUpBloodIssueJsp(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int bloodComponentId = 0;
		if (map.get("bloodComponentId") != null) {
			bloodComponentId = (Integer) map.get("bloodComponentId");
		}
		List<BloodStockDetail> stocktList = new ArrayList<BloodStockDetail>();
		stocktList = session.createCriteria(BloodStockDetail.class)
				.createAlias("StockMain", "s")
				.add(Restrictions.eq("BloodIssued", "n"))
				.add(Restrictions.eq("Component.Id", bloodComponentId))
				.addOrder(Order.desc("s.ExpiryDate")).list();
		dataMap.put("stockList", stocktList);
		return dataMap;
	}

	public Map<String, Object> showUpdateReactonEntry(int reactionId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();

		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			bloodGroupList = session.createCriteria(MasBloodGroup.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (bloodGroupList.size() > 0) {
				detailsMap.put("bloodGroupList", bloodGroupList);
			}

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (sexList.size() > 0) {
				detailsMap.put("sexList", sexList);
			}
			stockList = session.createCriteria(BloodStockDetail.class).list();
			if (stockList.size() > 0) {
				detailsMap.put("stockList", stockList);
			}
			reactionList = session.createCriteria(BloodReactionEntry.class)
					.add(Restrictions.eq("Id", reactionId)).list();
			if (reactionList != null || reactionList.size() > 0) {
				detailsMap.put("reactionList", reactionList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> searchPatientForUpdateReaction(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		Criteria crit = null;

		String hinNo = "";
		String entryNo = "";
		String patientName = "";
		int hinId = 0;

		Session session = (Session) getSession();

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("entryNo") != null) {
			entryNo = (String) mapForDs.get("entryNo");
		}
		if (mapForDs.get("patientName") != null) {
			patientName = (String) mapForDs.get("patientName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		try {
			crit = session.createCriteria(BloodReactionEntry.class).add(
					Restrictions.eq("Screening", "n"));
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}
			if (!hinNo.equals("") || !patientName.equals("") || hinId != 0) {
				crit = crit.createAlias("Hin", "hn");
			}

			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
			}
			if (hinId != 0) {
				crit = crit.add(Restrictions.like("hn.Id", hinId));
			}
			if (!patientName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PFirstName", patientName
						+ "%"));
			} else {
				crit = crit.add(Restrictions.like("DonorName", patientName
						+ "%"));
			}

			reactionList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("reactionList", reactionList);
		return map;
	}

	public boolean updateBloodReaction(Map<String, Object> generalMap) {
		return false;/*
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String caseTypeName = "";
		@SuppressWarnings("unused")
		String caseTypeCode = "";
		int blooReactionId = 0;
		Date reactionDate = new Date();
		Date issuedDate = new Date();
		Date dateTransfussion = new Date();

		String changedBy = "";
		String date = "";
		String time = "";
		String issuedTime = "";
		String donorName = "";
		String issuedTo = "";
		String entrySeqNo = "";
		String pyrexia = "";
		String itching = "";
		String urticarla = "";
		String elseWehere = "";
		String painBack = "";
		String head = "";
		String chest = "";
		String jaundice = "";
		String anaphylaxia = "";
		String fallOfBp = "";
		String rigor = "";
		String riseTemp = "";
		String haemoglobinuria = "";
		String timeCompleted = "";
		String anuria = "";
		String bloodBagNo = "";
		String tempTransfussion = "";
		String wdNo = "";
		String timeStarted = "";
		String untowardReaction = "";
		String userName = "";

		int hinId = 0;
		int inpatientId = 0;
		int issuedBy = 0;
		int crossMatchedBy = 0;
		int stockDetailId = 0;
		int bloodGroupId = 0;
		blooReactionId = (Integer) generalMap.get("blooReactionId");
		reactionDate = (Date) generalMap.get("currentDate");
		issuedDate = (Date) generalMap.get("currentDate");
		dateTransfussion = (Date) generalMap.get("currentDate");
		time = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		changedBy = (String) generalMap.get("changedBy");
		hinId = (Integer) generalMap.get("hinId");
		inpatientId = (Integer) generalMap.get("inpatientId");
		issuedBy = (Integer) generalMap.get("issuedBy");
		crossMatchedBy = (Integer) generalMap.get("crossMatchedBy");
		bloodGroupId = (Integer) generalMap.get("bloodGroupId");
		issuedTime = (String) generalMap.get("issuedTime");
		donorName = (String) generalMap.get("donorName");
		issuedTo = (String) generalMap.get("issuedTo");
		entrySeqNo = (String) generalMap.get("entrySeqNo");
		pyrexia = (String) generalMap.get("pyrexia");
		itching = (String) generalMap.get("itching");
		urticarla = (String) generalMap.get("urticarla");
		elseWehere = (String) generalMap.get("elseWehere");
		painBack = (String) generalMap.get("painBack");
		head = (String) generalMap.get("head");
		chest = (String) generalMap.get("chest");
		jaundice = (String) generalMap.get("jaundice");
		anaphylaxia = (String) generalMap.get("anaphylaxia ");
		fallOfBp = (String) generalMap.get("fallOfBp");
		rigor = (String) generalMap.get("rigor");
		riseTemp = (String) generalMap.get("riseTemp");
		haemoglobinuria = (String) generalMap.get("haemoglobinuria");
		timeCompleted = (String) generalMap.get("timeCompleted");
		anuria = (String) generalMap.get("anuria");
		bloodBagNo = (String) generalMap.get("bloodBagNo");
		tempTransfussion = (String) generalMap.get("tempTransfussion");
		wdNo = (String) generalMap.get("wdNo");
		timeStarted = (String) generalMap.get("time");
		untowardReaction = (String) generalMap.get("untowardReaction");
		userName = (String) generalMap.get("userName");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("time");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		BloodReactionEntry bloodReactionEntry = (BloodReactionEntry) getHibernateTemplate()
				.get(BloodReactionEntry.class, blooReactionId);
		bloodReactionEntry.setEntryNo(entrySeqNo);
		bloodReactionEntry.setRactionDate(currentDate);

		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodReactionEntry.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			bloodReactionEntry.setInpatient(inpatient);
		}

		bloodReactionEntry.setBloodBagNo(bloodBagNo);
		bloodReactionEntry.setIssuedTo(issuedTo);
		bloodReactionEntry.setIssuedDate(currentDate);
		bloodReactionEntry.setIssuedTime(issuedTime);
		bloodReactionEntry.setDonorName(donorName);
		if (bloodGroupId != 0) {
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			bloodReactionEntry.setBloodGroup(masBloodGroup);
		}
		if (crossMatchedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(crossMatchedBy);
			bloodReactionEntry.setCrossMatchedBy(masEmployee);
		}

		bloodReactionEntry.setIssuedTo(issuedTo);
		if (issuedBy != 0) {
			MasEmployee masEmployee1 = new MasEmployee();
			masEmployee1.setId(issuedBy);
			bloodReactionEntry.setIssuedBy(masEmployee1);
		}
		bloodReactionEntry.setWdNo(wdNo);
		bloodReactionEntry.setTransfussion(tempTransfussion);
		bloodReactionEntry.setDateTransfussion(currentDate);
		bloodReactionEntry.setTimeStarted(timeStarted);
		bloodReactionEntry.setTimeCompleted(timeCompleted);
		bloodReactionEntry.setPyrexia(pyrexia);
		bloodReactionEntry.setRigor(rigor);
		bloodReactionEntry.setRiseTemp(riseTemp);
		bloodReactionEntry.setFallOfBp(fallOfBp);
		bloodReactionEntry.setItching(itching);
		bloodReactionEntry.setUrticarla(urticarla);
		bloodReactionEntry.setAnaphylaxia(anaphylaxia);
		bloodReactionEntry.setPainBack(painBack);
		bloodReactionEntry.setHead(head);
		bloodReactionEntry.setChest(chest);
		bloodReactionEntry.setElseWehere(elseWehere);
		bloodReactionEntry.setJaundice(jaundice);
		bloodReactionEntry.setAnuria(anuria);
		bloodReactionEntry.setHaemoglobinuria(haemoglobinuria);
		bloodReactionEntry.setUntowardReaction(untowardReaction);
		bloodReactionEntry.setLastChgBy(userName);
		bloodReactionEntry.setLastChgDate(currentDate);
		bloodReactionEntry.setLastChgTime(time);

		hbt.update(bloodReactionEntry);
		dataUpdated = true;
		return dataUpdated;
	*/}
	
	public boolean validateResulTestEntryt(Map<String,Object> validatMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		BloodStockMain bloodStockMain=null;
		BloodStockDetail bloodStockDetail=null;
		Box box=(Box) validatMap.get("box");
		Date expiryDate=null;
		
		Date collectionDate=new Date();
		
		String BagNo="";
		String TubeNo="";
		int Quantity=0;
		int componentName=0;
		int hospitalId=0;
		int bldResultEntryHId=0;
		
		int cgBloodGropId=box.getInt("cgBloodGropId"); 
		int sgBloodGropId=box.getInt("cgBloodGropId");
		
		BagNo=box.get("BagNumber");
		TubeNo=box.get("TubeNumber");
		Quantity=box.getInt("Quntity");
		hospitalId=(Integer)validatMap.get("hospitalId");
		MasHospital hosp=new MasHospital();
		hosp.setId(hospitalId);
		
		bldResultEntryHId=box.getInt("bldResultcreenHId");
		
		
	//	bsm.setHospital(hosp);
	//	bsm.setCollectionDate(collectionDate);
		
		Session session = (Session) getSession();
		Transaction tnx=null;
		Criteria crt=null;
		crt=session.createCriteria(BloodStockDetail.class).createAlias("StockMain", "stockMain")
				.createAlias("stockMain.Hospital", "hosp")
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("BloodBagNo", BagNo));
		if(crt !=null && crt.list().get(0) !=null && crt.list().size()>0){
			bloodStockDetail=(BloodStockDetail) crt.list().get(0);
			bloodStockMain=bloodStockDetail.getStockMain();
			bloodStockMain.setCollectionDate(collectionDate);
			bloodStockMain.setBloodBagStatus("T");
		}
		System.out.println("cgBloodGropId"+cgBloodGropId);
		System.out.println("cgBloodGropId"+sgBloodGropId);
		if(cgBloodGropId==sgBloodGropId){
			MasBloodGroup bloodgroup=new MasBloodGroup();
			bloodgroup.setId(cgBloodGropId);
			bloodStockMain.setBloodGroup(bloodgroup);
		}

		try {
			tnx=session.beginTransaction();
			
			BloodResultEntryHeader bred=(BloodResultEntryHeader) session.createCriteria(BloodResultEntryHeader.class).createAlias("Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id",hospitalId))
			.add(Restrictions.eq("Id",bldResultEntryHId)).list().get(0);
					
					
			
			BloodSampleCollection bsc=bred.getSampleCollection();
			int componentId=bsc.getComponent().getId();
			int donationId=bsc.getDonation().getId();
			
			int componentLifeSpan=bsc.getComponent().getLifeSpan();
		//	System.out.println("componentLifeSpan "+componentLifeSpan);
			
			//
					
			Date sampleCollectionDate=bsc.getSampleCollectionDate();
			
			 expiryDate=calculateBagExpiryDate(componentLifeSpan);
			
			
			//System.out.println("sampleCollectionDate "+sampleCollectionDate);
			int bloodGroupId=0;
			
			/*if(null !=bsc.getDonation().getBloodGroup()){
			bloodGroupId=bsc.getDonation().getBloodGroup().getId();
			MasBloodGroup bloodgroup=new MasBloodGroup();
			bloodgroup.setId(bloodGroupId);
			bloodStockMain.setBloodGroup(bloodgroup);
			}*/
			BloodDonationEntryHeader donorHeader=bsc.getDonation();
			donorHeader.setId(donationId);
			if(cgBloodGropId==sgBloodGropId){
				MasBloodGroup bloodgroup=new MasBloodGroup();
				bloodgroup.setId(cgBloodGropId);
				bloodStockMain.setBloodGroup(bloodgroup);
				
				donorHeader.setBloodGroup(bloodgroup);
				bred.setResultEntryValidation("C");
			}
			else{
				bloodStockDetail.setBloodDiscard("y");
				bred.setDiscrepancy(box.get("discrepancy"));
				bred.setResultEntryValidation("D");
			}

			//bsm.setDonation(donorHeader);
			bloodStockMain.setExpiryDate(expiryDate);
			//bsm.setBloodGroup(bloodgroup);
			
			BloodMasComponent bldComponent=new BloodMasComponent();
			bldComponent.setId(componentId);
			
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(bred);
			hbt.update(bloodStockMain);
			hbt.update(donorHeader);
			hbt.update(bred);
			//bsd.setBloodBagNo(BagNo);
			//bsd.setTubeNo(TubeNo);
			//bsd.setQty(Quantity);
			//bsd.setStockMain(bsm);
			bloodStockDetail.setComponent(bldComponent);
			hbt.update(bloodStockDetail);
			tnx.commit();
			
			
		} catch (Exception e) {
			tnx.rollback();
			e.printStackTrace();
		}
		return true;
	}

	
	public Map<String, Object> showPendingForTransfussionReaction() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();

		Session session = (Session) getSession();

		try {
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y")).list();
			map.put("rankList", rankList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> searchPatientForTransfussionReaction(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		Criteria crit = null;

		String bloodBagNo = "";
		String entryNo = "";
		String patientLName = "";
		String patientFName = "";
		String reactionDate = "";
		int hinId = 0;

		String donorName = "";
		Session session = (Session) getSession();

		if (mapForDs.get("bloodBagNo") != null) {
			bloodBagNo = (String) mapForDs.get("bloodBagNo");
		}
		if (mapForDs.get("entryNo") != null) {
			entryNo = (String) mapForDs.get("entryNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("donorName") != null) {
			donorName = (String) mapForDs.get("donorName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}

		try {
			crit = session.createCriteria(BloodReactionEntry.class).add(
					Restrictions.eq("Screening", "n"));

			if (!patientFName.equals("") || !patientLName.equals("")) {
				crit = crit.createAlias("Hin", "hn");
			}
			if (!bloodBagNo.equals("")) {
				crit = crit.add(Restrictions.like("BloodBagNo", bloodBagNo
						+ "%"));
			}
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("EntryNo", entryNo + "%"));
			}
			if (hinId != 0) {
				crit = crit.add(Restrictions.eq("hn.Id", hinId));

			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PFirstName", patientFName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hn.PLastName", patientLName
						+ "%"));
			}
			if (!donorName.equals("")) {
				crit = crit
						.add(Restrictions.like("DonorName", donorName + "%"));
			}

			reactionList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("reactionList", reactionList);
		return map;
	}

	public String getTransfussionTestSeqForDisplay(String string) {
		int maxSeqNo = 0;
		List<Integer> seqNoList = new ArrayList<Integer>();
		String seqNo = "";
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			seqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "TRN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (seqNoList.get(0) == null || seqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BldTransReactHd");
				tsObj.setTransactionPrefix("TRN");
				tsObj.setTransactionSequenceName("Test No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				seqNo = String.valueOf(1);
			} else if (seqNoList.get(0) != null) {
				maxSeqNo = seqNoList.get(0);
				seqNo = String.valueOf(maxSeqNo + 1);
			} else {
				seqNo = String.valueOf(1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return seqNo;
	}

	public Map<String, Object> showTransfussionReaction(int bloodIssudeDetailId, int hospitalId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		
		List<BloodIssueDetail> bloodIssueDetailList = new ArrayList<BloodIssueDetail>();

		int hinId = 0;
		Session session = (Session) getSession();

		try {
			bloodIssueDetailList=session.createCriteria(BloodIssueDetail.class)
					.add(Restrictions.eq("Id", bloodIssudeDetailId)).list();
			
			
					
			detailsMap.put("bloodIssueDetailList", bloodIssueDetailList);
			
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId))
					/*.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24))*/.list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			int bloodReactionId=0;
			if(bloodReactionId>0){
			reactionList = session.createCriteria(BloodReactionEntry.class)
					.add(Restrictions.eq("Screening", "n"))
					.add(Restrictions.eq("Id", bloodReactionId)).list();
			}
			if (reactionList != null) {
				detailsMap.put("reactionList", reactionList);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("BloodReactionTest", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> fillDonorDetail(Map map) {

		Session session = (Session) getSession();
		List<Patient> patientList = new ArrayList<Patient>();

		try {
			String str = "" + map.get("uId");
			if (null != str) {
				System.out.print("uid check " + str);
				Criteria c = session.createCriteria(Patient.class).add(
						Restrictions.eq("HinNo", str));
				patientList = c.list();

				map.put("patientList", patientList);

			}
			/**
			 * Added By Ritu for checking last donation date ---
			 */
			String donoruId = (String) map.get("donoruId");
			if (null != donoruId) {
				List<BloodDonationEntryHeader> donationList = new ArrayList<BloodDonationEntryHeader>();
				donationList = session
						.createCriteria(BloodDonationEntryHeader.class)
						.add(Restrictions.eq("UhidNo", donoruId)).list();
				System.out.println("donationList " + donationList.size());
				map.put("donationList", donationList);
				if (donationList.size() > 0) {
					BloodDonationEntryHeader dontHd = donationList
							.get(donationList.size() - 1);
					Date lastDonationDate = dontHd.getCollectionDate();
					Date currentDate = new Date();
					long mills_per_day = 1000 * 60 * 60 * 24;
					long noOfDays = (currentDate.getTime() - lastDonationDate
							.getTime()) / mills_per_day;
					MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();
					List<MasSetupParameterMaintaince> systemParametersList = new ArrayList<MasSetupParameterMaintaince>();
					Criteria crit = session.createCriteria(
							MasSetupParameterMaintaince.class).addOrder(
							Order.asc("Id"));

					crit.setFirstResult(0);
					crit.setMaxResults(1);
					systemParametersList = crit.list();
					int blddntDays = 0;
					if (systemParametersList != null
							&& systemParametersList.size() > 0) {
						systemParam = systemParametersList.get(0);
						blddntDays = systemParam.getBloodDonGap();
					}
					if (noOfDays <= blddntDays) {
						map.put("ableForDonation", "no");
					} else {
						map.put("ableForDonation", "yes");
					}

				} else {
					map.put("ableForDonation", "yes");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	public boolean submitPopbloodIssue(int stockDetailId,
			Map<String, Object> generalMap) {
		boolean saved = false;
		BloodStockDetail stockDetail = new BloodStockDetail();
		stockDetail = (BloodStockDetail) getHibernateTemplate().get(
				BloodStockDetail.class, stockDetailId);

		stockDetail.setBloodIssued("y");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(stockDetail);
		saved = true;
		return saved;
	}

	public boolean updateBloodDonation(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Transaction tx = null;
		try {/*
			 * tx = session.beginTransaction();
			 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
			 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
			 * hbt.setCheckWriteOperations(false);
			 * 
			 * List<BloodDonationEntryHeader> donationHdList = session
			 * .createCriteria(BloodDonationEntryHeader.class)
			 * .add(Restrictions.eq("Id", box.getInt("donationhdId"))) .list();
			 * BloodDonationEntryHeader bonationEntryHeaderObj =
			 * (BloodDonationEntryHeader) donationHdList .get(0); int
			 * donationHdId = bonationEntryHeaderObj.getId();
			 * BloodDonationEntryHeader donationEntryHeader =
			 * (BloodDonationEntryHeader) hbt
			 * .load(BloodDonationEntryHeader.class,
			 * box.getInt("donationhdId"));
			 * 
			 * if (box.getString("donerName") != null &&
			 * !box.getString("donerName").equals("")) {
			 * donationEntryHeader.setDonerName(box.getString("donerName")); }
			 * 
			 * if (box.getString("fatherName") != null &&
			 * !box.getString("fatherName").equals("")) {
			 * donationEntryHeader.setFatherName(box.getString("fatherName")); }
			 * 
			 * if (box.getString("husbandName") != null &&
			 * !box.getString("husbandName").equals("")) {
			 * donationEntryHeader.setHusbandName("husbandName"); }
			 * 
			 * Patient patient = new Patient(); if (box.getString("hinId") !=
			 * null && !box.getString("hinId").equals("")) {
			 * patient.setId(Integer.parseInt(box.getString("hinId")));
			 * donationEntryHeader.setHin(patient); } MasOccupation
			 * masOccupation = new MasOccupation(); if
			 * (box.getString("occupationId") != null &&
			 * !box.getString("occupationId").equals("")) {
			 * masOccupation.setId(Integer.parseInt(box
			 * .getString("occupationId")));
			 * donationEntryHeader.setOccupation(masOccupation); } if
			 * (box.getString("organization") != null &&
			 * !box.getString("organization").equals("")) {
			 * donationEntryHeader.setOrganization(box
			 * .getString("organization")); }
			 * 
			 * 
			 * MasAdministrativeSex administrativeSex = new
			 * MasAdministrativeSex(); if (box.getString("sexId") != null &&
			 * !box.getString("sexId").equals(""))
			 * administrativeSex.setId(Integer
			 * .parseInt(box.getString("sexId")));
			 * donationEntryHeader.setSex(administrativeSex);
			 * 
			 * 
			 * if (box.getString("age") != null &&
			 * !box.getString("age").equals("")) {
			 * donationEntryHeader.setAge(box.getString("age")); }
			 * 
			 * if (box.getString("teleNo") != null &&
			 * !box.getString("teleNo").equals("")) {
			 * donationEntryHeader.setTelNo(box.getString("teleNo")); }
			 * 
			 * if (box.getString("mobilNo") != null &&
			 * !box.getString("mobilNo").equals("")) {
			 * donationEntryHeader.setMobNo(box.getString("mobilNo")); }
			 * 
			 * MasState state = new MasState(); if (box.getString("stateId") !=
			 * null && !box.getString("stateId").equals("")) {
			 * state.setId(Integer.parseInt(box.getString("stateId")));
			 * donationEntryHeader.setState(state); } MasAdministrativeSex sex =
			 * new MasAdministrativeSex(); if (box.getString("sexId") != null &&
			 * !box.getString("sexId").equals("")) {
			 * sex.setId(Integer.parseInt(box.getString("sexId")));
			 * donationEntryHeader.setSex(sex); } MasBloodGroup masBloodGroup =
			 * new MasBloodGroup(); if (box.getString("bloodGroupId") != null &&
			 * !box.getString("bloodGroupId").equals("")) {
			 * masBloodGroup.setId(Integer.parseInt(box
			 * .getString("bloodGroupId")));
			 * donationEntryHeader.setBloodGroup(masBloodGroup); } if
			 * (box.getString("previoulsyDonated") != null &&
			 * !box.getString("previoulsyDonated").equals("")) {
			 * donationEntryHeader.setPreviouslyDonated("previoulsyDonated"); }
			 * 
			 * if (box.getString("lastDonatedDate") != null &&
			 * !box.getString("lastDonatedDate").equals("")) {
			 * donationEntryHeader.setLastDonated(HMSUtil
			 * .convertStringTypeDateToDateType(box
			 * .getString("lastDonatedDate"))); }
			 * 
			 * if (box.getString("discomfort") != null &&
			 * !box.getString("discomfort").equals("")) {
			 * donationEntryHeader.setDiscomfort(box.getString("discomfort")); }
			 * 
			 * if (box.getString("wellToday") != null &&
			 * !box.getString("wellToday").equals("")) {
			 * donationEntryHeader.setWellToday(box.getString("wellToday")); }
			 * 
			 * if (box.getString("smthingEat") != null &&
			 * !box.getString("smthingEat").equals("")) {
			 * donationEntryHeader.setSmthingEat(box.getString("smthingEat")); }
			 * if (box.getString("sleepLast") != null &&
			 * !box.getString("sleepLast").equals("")) {
			 * donationEntryHeader.setSleepLastNight(box
			 * .getString("sleepLast")); }
			 * 
			 * if (box.getString("infectedDisease") != null &&
			 * !box.getString("infectedDisease").equals("")) {
			 * donationEntryHeader.setHepatitis(box
			 * .getString("infectedDisease")); }
			 * 
			 * if (box.getString("weightLoss") != null &&
			 * !box.getString("weightLoss").equals("")) {
			 * donationEntryHeader.setWeightLoss(box.getString("weightLoss")); }
			 * 
			 * if (box.getString("diarrhoces") != null &&
			 * !box.getString("diarrhoces").equals("")) {
			 * donationEntryHeader.setDiasrrhoes(box.getString("diarrhoces")); }
			 * if (box.getString("swollen") != null &&
			 * !box.getString("swollen;").equals("")) {
			 * donationEntryHeader.setSwollwn(box.getString("swollen")); }
			 * 
			 * if (box.getString("lowGradeFever") != null &&
			 * !box.getString("lowGradeFever").equals("")) {
			 * donationEntryHeader.setLowGradeFever("lowGradeFever"); } if
			 * (box.getString("na1") != null &&
			 * !box.getString("na1").equals("")) {
			 * donationEntryHeader.setNA1(box.getString("na1")); }
			 * 
			 * if (box.getString("tattooing") != null &&
			 * !box.getString("tattooing").equals("")) {
			 * donationEntryHeader.setTattoing(box.getString("tattooing")); }
			 * 
			 * if (box.getString("EarPiercing") != null &&
			 * !box.getString("EarPiercing").equals("")) { donationEntryHeader
			 * .setEarPiercing(box.getString("EarPiercing")); }
			 * 
			 * if (box.getString("dentalExtraction") != null &&
			 * !box.getString("dentalExtraction").equals("")) {
			 * donationEntryHeader.setDentalExtraction(box
			 * .getString("dentalExtraction")); } if (box.getString("na2") !=
			 * null && !box.getString("na2").equals("")) {
			 * donationEntryHeader.setNA2(box.getString("na2")); }
			 * 
			 * if (box.getString("heartDisease") != null &&
			 * !box.getString("heartDisease").equals("")) {
			 * donationEntryHeader.setHeartDisease(box
			 * .getString("heartDisease")); }
			 * 
			 * if (box.getString("lungDisease") != null &&
			 * !box.getString("lungDisease").equals("")) { donationEntryHeader
			 * .setLungDisease(box.getString("lungDisease")); }
			 * 
			 * if (box.getString("kidneyDisease") != null &&
			 * !box.getString("kidneyDisease").equals("")) {
			 * donationEntryHeader.setKidneyDisease(box
			 * .getString("kidneyDisease")); } if (box.getString("cancerisease")
			 * != null && !box.getString("cancerisease").equals("")) {
			 * donationEntryHeader.setCancerDisease(box
			 * .getString("cancerisease")); }
			 * 
			 * if (box.getString("epilepsy") != null &&
			 * !box.getString("epilepsy").equals("")) {
			 * donationEntryHeader.setEpilepsy(box.getString("epilepsy")); } if
			 * (box.getString("cdiabetes") != null &&
			 * !box.getString("cdiabetes").equals("")) {
			 * donationEntryHeader.setCdiabetes(box.getString("cdiabetes")); }
			 * 
			 * if (box.getString("tuberculosis") != null &&
			 * !box.getString("tuberculosis").equals("")) {
			 * donationEntryHeader.setTuberculosis(box
			 * .getString("tuberculosis")); } if
			 * (box.getString("abnormalBleeding") != null &&
			 * !box.getString("abnormalBleeding").equals("")) {
			 * donationEntryHeader.setAbnormalBleeding(box
			 * .getString("abnormalBleeding")); }
			 * 
			 * if (box.getString("dentalExtraction1") != null &&
			 * !box.getString("dentalExtraction1").equals("")) {
			 * donationEntryHeader.setDentalExtraction1(box
			 * .getString("dentalExtraction1")); }
			 * 
			 * if (box.getString("sexuallyTransmittedDisease") != null &&
			 * !box.getString("sexuallyTransmittedDisease").equals("")) {
			 * donationEntryHeader.setSexuallyDisease(box
			 * .getString("sexuallyTransmittedDisease")); } if
			 * (box.getString("jaundicelast") != null &&
			 * !box.getString("jaundicelast").equals("")) {
			 * donationEntryHeader.setJaundiceLastYear(box
			 * .getString("jaundicelast")); }
			 * 
			 * if (box.getString("typhoidLast") != null &&
			 * !box.getString("typhoidLast").equals("")) {
			 * donationEntryHeader.setTyphoidLastOne(box
			 * .getString("typhoidLast")); }
			 * 
			 * if (box.getString("malariaLast") != null &&
			 * !box.getString("malariaLast").equals("")) {
			 * donationEntryHeader.setMalariaSixMonth(box
			 * .getString("malariaLast")); }
			 * 
			 * if (box.getString("faintingSpell") != null &&
			 * !box.getString("faintingSpell").equals("")) {
			 * donationEntryHeader.setFaintingSpells(box
			 * .getString("faintingSpell")); } if (box.getString("leprosy") !=
			 * null && !box.getString("leprosy").equals("")) {
			 * donationEntryHeader.setLeprosy(box.getString("leprosy")); }
			 * 
			 * if (box.getString("schizophernia") != null &&
			 * !box.getString("schizophernia").equals("")) {
			 * donationEntryHeader.setSchizophernia(box
			 * .getString("schizophernia")); } if
			 * (box.getString("endocrineDisorders") != null &&
			 * !box.getString("endocrineDisorders").equals("")) {
			 * donationEntryHeader.setEndocrineDisorders(box
			 * .getString("endocrineDisorders")); }
			 * 
			 * if (box.getString("na3") != null &&
			 * !box.getString("na3").equals("")) {
			 * donationEntryHeader.setNA3(box.getString("na3")); }
			 * 
			 * if (box.getString("abortion") != null &&
			 * !box.getString("abortion").equals("")) {
			 * donationEntryHeader.setAbortion(box.getString("abortion")); }
			 * 
			 * if (box.getString("acuteNephritis") != null &&
			 * !box.getString("acuteNephritis").equals("")) {
			 * donationEntryHeader.setAcuteNephritis(box
			 * .getString("acuteNephritis")); }
			 * 
			 * if (box.getString("bloodTransfusionHo") != null &&
			 * !box.getString("bloodTransfusionHo").equals("")) {
			 * donationEntryHeader.setHoBloodTransfusion(box
			 * .getString("bloodTransfusionHo")); }
			 * 
			 * if (box.getString("ImmunoglobulinNephritis") != null &&
			 * !box.getString("ImmunoglobulinNephritis").equals("")) {
			 * donationEntryHeader.setImmunoglobulinNephritis(box
			 * .getString("ImmunoglobulinNephritis")); }
			 * 
			 * if (box.getString("alcholism") != null &&
			 * !box.getString("alcholism").equals("")) {
			 * donationEntryHeader.setAlcholism(box.getString("alcholism")); }
			 * 
			 * if (box.getString("rabiesVaccination") != null &&
			 * !box.getString("rabiesVaccination").equals("")) {
			 * donationEntryHeader.setRabieVaccination(box
			 * .getString("rabiesVaccination")); } if
			 * (box.getString("minorSurgery") != null &&
			 * !box.getString("minorSurgery").equals("")) {
			 * donationEntryHeader.setMinorSurgery(box
			 * .getString("minorSurgery")); }
			 * 
			 * if (box.getString("majorSurgery") != null &&
			 * !box.getString("majorSurgery").equals("")) {
			 * donationEntryHeader.setMajorSurgery(box
			 * .getString("majorSurgery")); }
			 * 
			 * if (box.getString("hoHepatitis") != null &&
			 * !box.getString("hoHepatitis").equals("")) { donationEntryHeader
			 * .setHoHapatitis(box.getString("hoHepatitis")); }
			 * 
			 * if (box.getString("dentalExtraction1") != null &&
			 * !box.getString("dentalExtraction1").equals("")) {
			 * donationEntryHeader.setDentalExtraction1(box
			 * .getString("dentalExtraction1")); }
			 * 
			 * 
			 * if (box.getString("immunozalic") != null &&
			 * !box.getString("immunozalic").equals(""))
			 * donationEntryHeader.setImmunoglobulinNephritis("immunozalic");
			 * 
			 * if (box.getString("typhoid") != null &&
			 * !box.getString("typhoid").equals("")) {
			 * donationEntryHeader.setTyphoid(box.getString("typhoid")); }
			 * 
			 * if (box.getString("hoMalaria") != null &&
			 * !box.getString("hoMalaria").equals("")) {
			 * donationEntryHeader.setHoMalaria(box.getString("hoMalaria")); }
			 * 
			 * if (box.getString("tattooing1") != null &&
			 * !box.getString("tattooing1").equals("")) {
			 * donationEntryHeader.setTattoing1(box.getString("tattooing1")); }
			 * 
			 * if (box.getString("breastFeeding") != null &&
			 * !box.getString("breastFeeding").equals("")) {
			 * donationEntryHeader.setBreastFeeding(box
			 * .getString("breastFeeding")); } if (box.getString("na4") != null
			 * && !box.getString("na4").equals("")) {
			 * donationEntryHeader.setNA4(box.getString("na4")); }
			 * 
			 * if (box.getString("pregnant") != null &&
			 * !box.getString("pregnant").equals("")) {
			 * donationEntryHeader.setPregnent(box.getString("pregnant")); } if
			 * (box.getString("abortion1") != null &&
			 * !box.getString("abortion1").equals("")) {
			 * donationEntryHeader.setAbortionLastThree(box
			 * .getString("abortion1")); }
			 * 
			 * if (box.getString("childLess") != null &&
			 * !box.getString("childLess").equals("")) {
			 * donationEntryHeader.setChildLess(box.getString("childLess")); }
			 * 
			 * if (box.getString("menses") != null &&
			 * !box.getString("menses").equals("")) {
			 * donationEntryHeader.setMenses(box.getString("menses")); }
			 * 
			 * if (box.getString("na5") != null &&
			 * !box.getString("na5").equals("")) {
			 * donationEntryHeader.setNA5(box.getString("na5")); }
			 * 
			 * if (box.getString("selectedRadio") != null &&
			 * !box.getString("selectedRadio").equals("")) {
			 * donationEntryHeader.setBloodTransfusionSix(box
			 * .getString("selectedRadio")); }
			 * 
			 * if (box.getString("abnormalTestResult") != null &&
			 * !box.getString("abnormalTestResult").equals("")) {
			 * donationEntryHeader.setAbnormalTestResult(box
			 * .getString("abnormalTestResult")); }
			 * 
			 * donationEntryHeader.setCollectionDate(HMSUtil
			 * .convertStringTypeDateToDateType(box
			 * .getString("collectionDate")));
			 * 
			 * if (box.getString("collectionTime") != null &&
			 * !box.getString("collectionTime").equals("")) {
			 * donationEntryHeader.setCollectionTime(box
			 * .getString("collectionTime")); }
			 * 
			 * if (box.getString("general") != null &&
			 * !box.getString("general").equals("")) {
			 * donationEntryHeader.setGeneral(box.getString("general")); } if
			 * (box.getString("height") != null &&
			 * !box.getString("height").equals("")) {
			 * donationEntryHeader.setHeight(box.getInt("height")); }
			 * 
			 * if (box.getString("weight") != null &&
			 * !box.getString("weight").equals("")) {
			 * donationEntryHeader.setWeight(box.getInt("weight")); }
			 * 
			 * if (box.getString("pulse") != null &&
			 * !box.getString("pulse").equals("")) {
			 * donationEntryHeader.setPulse(box.getFloat("pulse")); }
			 * 
			 * if (box.getString("temperature") != null &&
			 * !box.getString("temperature").equals("")) {
			 * donationEntryHeader.setTemp(box.getFloat("temperature")); }
			 * 
			 * if (box.getFloat("hbDl") != 0) {
			 * donationEntryHeader.setHbDl(box.getFloat("hbDl")); }
			 * 
			 * if (box.getString("bp") != null &&
			 * !box.getString("bp").equals("")) {
			 * donationEntryHeader.setBp(box.getString("bp")); }
			 * 
			 * if (box.getString("phlebotomySite") != null &&
			 * !box.getString("phlebotomySite").equals("")) {
			 * donationEntryHeader.setPhlebotomy(box
			 * .getString("phlebotomySite")); }
			 * 
			 * donationEntryHeader.setCollectionDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString("expiryDate")));
			 * 
			 * MasEmployee masEmployee = new MasEmployee(); if
			 * (box.getString("employeeId") != null &&
			 * !box.getString("employeeId").equals("")) { masEmployee
			 * .setId(Integer.parseInt(box.getString("employeeId")));
			 * donationEntryHeader.setCollectedBy(masEmployee); }
			 * 
			 * if (box.getString("volRep") != null &&
			 * !box.getString("volRep").equals("")) {
			 * donationEntryHeader.setVolRep(box.getString("volRep")); }
			 * 
			 * 
			 * MasIcd masIcd = new MasIcd(); if (box.getString("diagnosisId") !=
			 * null && !box.getString("diagnosisId").equals(""))
			 * masIcd.setId(Integer.parseInt(box.getString("diagnosisId")));
			 * donationEntryHeader.set(masIcd);
			 * 
			 * 
			 * 
			 * if (box.getString("appointmentDate") != null &&
			 * !box.getString("appointmentDate").equals(""))
			 * specialInvestigationHd
			 * .setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box
			 * .getString("appointmentDate")));
			 * 
			 * 
			 * donationEntryHeader.setLastChgBy(box.getString("changed_by"));
			 * donationEntryHeader.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box
			 * .getString("changed_date")));
			 * donationEntryHeader.setLastChgTime(box
			 * .getString("changed_time")); hbt.update(donationEntryHeader);
			 * 
			 * int donationHeadId = donationEntryHeader.getId();
			 * List<BloodDonationEntryDetail> donationdetailList = session
			 * .createCriteria(BloodDonationEntryDetail.class)
			 * .createAlias("Donation", "dn") .add(Restrictions.eq("dn.Id",
			 * box.getInt("donationhdId"))) .list();
			 * hbt.deleteAll(donationdetailList);
			 * 
			 * try { Vector blood_bag_no = box.getVector(BLOOD_BAG_NO); Vector
			 * component_id = box.getVector(BLOOD_COMPONENT_ID); Vector qty =
			 * box.getVector(QUANTITY); for (int i = 0; i < blood_bag_no.size();
			 * i++) { if (blood_bag_no.get(i) != null &&
			 * !blood_bag_no.get(i).equals("")) { BloodDonationEntryDetail
			 * donationEntryDetail = new BloodDonationEntryDetail();
			 * donationEntryDetail .setDonation(new BloodDonationEntryHeader(
			 * donationHeadId));
			 * 
			 * if (blood_bag_no.get(i) != null &&
			 * !blood_bag_no.get(i).equals("")) { donationEntryDetail
			 * .setBloodBagNo((String) blood_bag_no.get(i)); } if (qty.get(i) !=
			 * null && !qty.get(i).equals("")) {
			 * donationEntryDetail.setQty(Integer .parseInt((String)
			 * qty.get(i))); } if (component_id.get(i) != null &&
			 * !component_id.get(i).equals("")) { BloodMasComponent
			 * bloodMasComponent = new BloodMasComponent();
			 * bloodMasComponent.setId(Integer .parseInt((String)
			 * component_id.get(i)));
			 * donationEntryDetail.setComponent(bloodMasComponent); }
			 * donationEntryDetail.setSampleScreeningTest("n");
			 * hbt.save(donationEntryDetail); } }
			 * 
			 * } catch (RuntimeException e) { e.printStackTrace(); }
			 * successfullyAdded = true; tx.commit();
			 */
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public boolean updateBloodTestEntry(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<BloodTestEntryHeader> testHdList = session
					.createCriteria(BloodTestEntryHeader.class)
					.add(Restrictions.eq("Id", box.getInt("bloodTestHdId")))
					.list();
			BloodTestEntryHeader testHdObj = (BloodTestEntryHeader) testHdList
					.get(0);
			int reactionHdId = testHdObj.getId();
			BloodTestEntryHeader bloodTestHd = (BloodTestEntryHeader) hbt.load(
					BloodTestEntryHeader.class, box.getInt("bloodTestHdId"));

			Patient patient = new Patient();
			if (box.getString("hinId") != null
					&& !box.getString("hinId").equals("")) {
				patient.setId(Integer.parseInt(box.getString("hinId")));
			}
			bloodTestHd.setHin(patient);

			if (box.getString("name") != null
					&& !box.getString("name").equals("")) {
				bloodTestHd.setName(box.getString("name"));
			}

			MasAdministrativeSex masSex = new MasAdministrativeSex();
			if (box.getString("sexId") != null
					&& !box.getString("sexId").equals("")) {
				masSex.setId(Integer.parseInt(box.getString("sexId")));
			}
			bloodTestHd.setSex(masSex);

			if (box.getString("patientType") != null
					&& !box.getString("patientType").equals("")) {
				bloodTestHd.setType(box.getString("patientType"));
			}

			if (box.getString("contact_number") != null
					&& !box.getString("contact_number").equals("")) {
				bloodTestHd.setTeleNo(box.getString("contact_number"));
			}

			if (box.getString("age") != null
					&& !box.getString("age").equals("")) {
				bloodTestHd.setType(box.getString("age"));
			}

			MasEmployee masEmployee = new MasEmployee();
			if (box.getString("employeeId") != null
					&& !box.getString("employeeId").equals("")) {
				masEmployee
						.setId(Integer.parseInt(box.getString("employeeId")));
			}
			bloodTestHd.setReceivedBy(masEmployee);

			bloodTestHd.setLastChgBy(box.getString("changed_by"));
			bloodTestHd.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changed_date")));
			bloodTestHd.setLastChgTime(box.getString("changed_time"));

			hbt.update(bloodTestHd);
			hbt.refresh(bloodTestHd);

			int testHd = bloodTestHd.getId();
			List<BloodTestEntryDetail> bloodTestDetailList = session
					.createCriteria(BloodTestEntryDetail.class)
					.createAlias("TestHeader", "dn")
					.add(Restrictions.eq("dn.Id", box.getInt("bloodTestHdId")))
					.list();
			hbt.deleteAll(bloodTestDetailList);
			try {
				Vector investigation_id = box.getVector("investigationId");
				Vector result = box.getVector("result");
				for (int i = 0; i < investigation_id.size(); i++) {
					if (investigation_id.get(i) != null
							&& !investigation_id.get(i).equals("")
							&& !investigation_id.get(i).equals("0")) {
						BloodTestEntryDetail bloodTestEntryDetail = new BloodTestEntryDetail();

						bloodTestEntryDetail
								.setTestHeader(new BloodTestEntryHeader(box
										.getInt("bloodTestHdId")));

						if (investigation_id.get(i) != null
								&& !investigation_id.get(i).equals("")) {
							DgMasInvestigation masInvestigation = new DgMasInvestigation();
							masInvestigation
									.setId(Integer
											.parseInt((String) investigation_id
													.get(i)));
							bloodTestEntryDetail
									.setInvestigation(masInvestigation);
						}
						if (result.get(i) != null && !result.get(i).equals("")) {
							bloodTestEntryDetail.setResult((String) result
									.get(i));
						}
						hbt.save(bloodTestEntryDetail);

					}
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			successfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;
	}

	public Map<String, Object> searchPatientForUpdateTest(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodTestEntryHeader> testList = new ArrayList<BloodTestEntryHeader>();
		Criteria crit = null;

		String hinNo = "";
		String entryNo = "";
		String patientName = "";
		int hinId = 0;

		Session session = (Session) getSession();

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("entryNo") != null) {
			entryNo = (String) mapForDs.get("entryNo");
		}
		if (mapForDs.get("patientName") != null) {
			patientName = (String) mapForDs.get("patientName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		try {
			crit = session.createCriteria(BloodTestEntryHeader.class);
			if (!entryNo.equals("")) {
				crit = crit.add(Restrictions.like("SerialNo", entryNo + "%"));
			}
			if (hinId != 0 || !hinNo.equals("")) {
				crit = crit.createAlias("Hin", "hn");
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("hn.HinNo", hinNo + "%"));
			}
			if (hinId != 0) {
				if (patientName != null) {
					crit = crit.add(Restrictions.like("hn.PFirstName",
							patientName + "%"));
				}
			} else {
				crit = crit.add(Restrictions.like("Name", patientName + "%"));
			}

			testList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("testList", testList);
		return map;
	}

	public Map<String, Object> showUpdateTestEntry(int bloodTestId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<BloodTestEntryHeader> testList = new ArrayList<BloodTestEntryHeader>();
		List<BloodTestEntryDetail> bloodTestdtList = new ArrayList<BloodTestEntryDetail>();
		List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		// List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		// List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.like("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.Id", 24)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			/*
			 * rankList =
			 * session.createCriteria(MasRank.class).add(Restrictions.
			 * eq("Status", "y")).list(); if (rankList.size() > 0) {
			 * detailsMap.put("rankList", rankList); }
			 */
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (sexList.size() > 0) {
				detailsMap.put("sexList", sexList);
			}
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (relationList.size() > 0) {
				detailsMap.put("relationList", relationList);
			}
			/*
			 * unitList =
			 * session.createCriteria(MasUnit.class).add(Restrictions.
			 * eq("Status", "y")).list(); if (unitList.size() > 0) {
			 * detailsMap.put("unitList", unitList); }
			 */
			testList = session.createCriteria(BloodTestEntryHeader.class)
					.add(Restrictions.eq("Id", bloodTestId)).list();
			if (testList != null || testList.size() > 0) {
				detailsMap.put("testList", testList);

				bloodTestdtList = session
						.createCriteria(BloodTestEntryDetail.class)
						.add(Restrictions.eq("TestHeader.Id", testList.get(0)
								.getId())).list();
				detailsMap.put("bloodTestdtList", bloodTestdtList);

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public int generateTransfusionTestNumber() {
		int testSeqNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "TRN")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (seqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : seqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				testSeqNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(testSeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			testSeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("BldTransReactHd");
			tsObj.setTransactionPrefix("TRN");
			tsObj.setTransactionSequenceName("Test No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(testSeqNo);
		}
		return testSeqNo;
	}

	public boolean submitTransfussionReaction(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		BloodTransfussionReactionHd transfussionReactionHd = new BloodTransfussionReactionHd();
		BloodIssueHeader bloodIssueHeader = new BloodIssueHeader();
		List investigationList = new ArrayList();
		Session session = (Session) getSession();
		boolean success = false;
		@SuppressWarnings("unused")
		Box box = null;
		int componentMainIdFromRequest = 0;
		int trnasfusionHdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int hinId = 0;
		int reactionId = 0;
		int testSeqNo = 0;
		int bldIssueHdId=0;
		
		String userName = "";
		Vector result = null;
		if (infoMap.get("bldIssueHdId") != null) {
			bldIssueHdId = (Integer) infoMap.get("bldIssueHdId");
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("departmentId") != null) {
			departmentId = (Integer) infoMap.get("departmentId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get("transfussionReactionHd") != null) {
			transfussionReactionHd = (BloodTransfussionReactionHd) infoMap
					.get("transfussionReactionHd");
		}
		if (infoMap.get("componentMainIdFromRequest") != null) {
			componentMainIdFromRequest = (Integer) infoMap
					.get("componentMainIdFromRequest");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("testSeqNo") != null) {
			testSeqNo = (Integer) infoMap.get("testSeqNo");
		}
		if (infoMap.get("reactionId") != null) {
			reactionId = (Integer) infoMap.get("reactionId");
		}
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("result") != null) {
			result = (Vector) infoMap.get("result");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
Transaction tnx=null;

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		try {
			tnx=session.beginTransaction();
	
			hbt.save(transfussionReactionHd);
			bloodIssueHeader=(BloodIssueHeader) session.load(BloodIssueHeader.class, bldIssueHdId);
			bloodIssueHeader.setBldTransfussionStatus("C");
			hbt.saveOrUpdate(bloodIssueHeader);
			//trnasfusionHdId=transfussionReactionHd.getId();
		

		

			if (infoMap.get("investigationList") != null) {
				investigationList = (List) infoMap.get("investigationList");
				if (investigationList.size() > 0) {
					for (int i = 0; i < investigationList.size(); i++) {

						BloodTransfussionReactionDt transfussionReactionDt = new BloodTransfussionReactionDt();
						/*BloodTransfussionReactionHd transfussionHd=new BloodTransfussionReactionHd();
						transfussionHd.setId(trnasfusionHdId);
						*/
						
						DgMasInvestigation masInvestigation = new DgMasInvestigation();

						try {
							if (investigationList.get(i) != null
									&& !investigationList.get(i).equals("")) {
								int investigationId = Integer
										.parseInt(investigationList.get(i)
												.toString());
								masInvestigation.setId(investigationId);
								transfussionReactionDt
										.setInvestigation(masInvestigation);

								if (result != null && !result.equals("")) {
									transfussionReactionDt
											.setResult((String) result.get(i)
													.toString());
								}
								transfussionReactionDt
										.setTransfusionHd(transfussionReactionHd);
								
									hbt.save(transfussionReactionDt);
								
							}

						} catch (RuntimeException e) {
							e.printStackTrace();
						}

					}
					saved = true;
					tnx.commit();
					session.flush();
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return saved;
	}

	public Map<String, Object> fillBloodbagForDiscrad(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		List<BloodStockDetail> bagList = new ArrayList<BloodStockDetail>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + dataMap.get("bloodbagNo");
			Criteria c = session.createCriteria(BloodStockDetail.class)
					.add(Restrictions.eq("BloodBagNo", str))
					.add(Restrictions.eq("BloodIssued", "n"));
			bagList = c.list();
			dataMap.put("bagList", bagList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataMap;

	}

	public Map<String, Object> getTransfusionReactionGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodIssueDetail> bloodIssueDetailList = new ArrayList<BloodIssueDetail>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		try {
			crit = session.createCriteria(BloodIssueDetail.class).createAlias("IssueHeader", "issueHeader")
					.add(Restrictions.eq("BldAckPending", "A").ignoreCase())
					.add(Restrictions.eq("issueHeader.BldTransfussionStatus", "P").ignoreCase())
					.add(Restrictions.eq("issueHeader.IssueDate", currentDate));
			bloodIssueDetailList = crit.list();
			System.out.println("bloodIssueDetailList  "+bloodIssueDetailList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("bloodIssueDetailList", bloodIssueDetailList);
		return map;
	}

	public Map<String, Object> fillBloodbagForReaction(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		List<BloodStockDetail> bagList = new ArrayList<BloodStockDetail>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			String str = "" + dataMap.get("bloodBagNo");
			Criteria c = session.createCriteria(BloodStockDetail.class)
					.add(Restrictions.eq("BloodBagNo", str))
					.add(Restrictions.eq("BloodIssued", "n"));
			bagList = c.list();
			dataMap.put("bagList", bagList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataMap;
	}

	public Map<String, Object> showPendingBloodDiscard(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodStockDetail> stockDetailList = new ArrayList<BloodStockDetail>();
		Session session = (Session) getSession();
		int hospitalId=(Integer)mapForDs.get("hospitalId");
		Date currentDate = new Date();

		int hinId = 0;

		try {
			stockDetailList = session.createCriteria(BloodStockDetail.class)
					//Changed by Arbind on 11-10-2017
					//.add(Restrictions.eq("BloodIssued", "c").ignoreCase())
					.add(Restrictions.or(Restrictions.eq("BloodIssued", "c").ignoreCase(), Restrictions.isNull("BloodIssued")))
					.createAlias("StockMain", "main")
					.createAlias("main.Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id", hospitalId))
			.add(Restrictions.eq("BloodDiscard", "y").ignoreCase())
					.list();
			
			System.out.println(stockDetailList.size()+"akdhakjjjjjjjjjjkhahakd");
			
			//.add(Restrictions.le("main.ExpiryDate", currentDate))
			/*.add(Restrictions.eq("Id", bloodStockDetailId))*/
			map.put("stockDetailList", stockDetailList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> chechBloodBag(Map<String, Object> dataMap) {
		String bloodBagId = "";
		String exists = "no";
		List<BloodDonationEntryDetail> donationdetailList = new ArrayList<BloodDonationEntryDetail>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (dataMap.get("bloodBagId") != null) {
			bloodBagId = "" + dataMap.get("bloodBagId");
		}
		Session session = (Session) getSession();
		donationdetailList = session
				.createCriteria(BloodDonationEntryDetail.class)
				.add(Restrictions.eq("BloodBagNo", bloodBagId)).list();
		if (donationdetailList.size() > 0) {
			exists = "yes";
		}
		map.put("exists", exists);
		return map;
	}

	public Map<String, Object> fillItemsForComponentnameSeparation(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List componentList = new ArrayList();
		Session session = (Session) getSession();
		String componentName = (String) dataMap.get("componentName");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			componentList = session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("ComponentName", componentName))
					.add(Restrictions.eq("WholeBlood", "n")).list();
			map.put("componentList", componentList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> submitBloodComponentSeperation(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int stockMainId = 0;
		int componentMainIdFromRequest = 0;
		Session session = (Session) getSession();
		BloodStockMain stockMain = new BloodStockMain();
		List qtyList = new ArrayList();
		Vector expiry =new Vector<Date>();
		List componentList = new ArrayList();
		Vector quantity = null;
		Vector blood_bag_no = null;
		Vector tube_bag_no = null;
		//Vector stock_mainId = null;
		int stock_mainId = 0;
		int stockDtId = 0;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		if (dataMap.get("stockDtId") != null) {
			stockDtId = (Integer) dataMap.get("stockDtId");
		}
		int stockMaId = 0;
		if (dataMap.get("stockMaId") != null) {
			stockMaId = (Integer) dataMap.get("stockMaId");
		}
		if (dataMap.get("qtyList") != null) {
			qtyList = (List) dataMap.get("qtyList");
		}
		if (dataMap.get("stockMain") != null) {
			stockMain = (BloodStockMain) dataMap.get("stockMain");
		}
		if (dataMap.get("quantity") != null) {
			quantity = (Vector) dataMap.get("quantity");
		}
		if (dataMap.get("blood_bag_no") != null) {
			blood_bag_no = (Vector) dataMap.get("blood_bag_no");
		}
		if (dataMap.get("tube_bag_no") != null) {
			tube_bag_no = (Vector) dataMap.get("tube_bag_no");
		}
		
		if (dataMap.get("stock_mainId") != null) {
			stock_mainId = (Integer) dataMap.get("stock_mainId");
		}
		if (dataMap.get("expiry") != null) {
			expiry = (Vector) dataMap.get("expiry");
		}
		
		
		int deptId=0;
		int hospitalId=0;
		if (dataMap.get("deptId") != null) {
			deptId = (Integer) dataMap.get("deptId");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		
		Transaction tx = null;
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {

			List<BloodStockDetail> stockList = session
					.createCriteria(BloodStockDetail.class)
					.createAlias("StockMain", "sm")
					.add(Restrictions.eq("sm.Id", box.getInt("stockMainId")))
					.list();

		//	hbt.deleteAll(stockList);
			
		//	BloodStockMain bldStockMain=
			

			if (dataMap.get("componentList") != null) {
				componentList = (List) dataMap.get("componentList");
				if (componentList.size() > 0) {
					BloodStockDetail previousBloodStockDetail = (BloodStockDetail) session
							.load(BloodStockDetail.class, stockDtId);
					//hbt.delete(previousBloodStockDetail);
					for (int i = 0; i < componentList.size(); i++) {
						BloodStockDetail bloodStockDetail = new BloodStockDetail();
						BloodMasComponent bloodMasComponent = new BloodMasComponent();
						if (componentList.get(i) != null
								&& !componentList.get(i).equals("")) {

							/*bloodStockDetail.setStockMain(new BloodStockMain(
									Integer.parseInt((String) stock_mainId
											.get(i))));*/
							bloodStockDetail.setStockMain(new BloodStockMain(stock_mainId));
							int componentId = Integer.parseInt(componentList
									.get(i).toString());
							bloodMasComponent.setId(componentId);
							bloodStockDetail.setComponent(bloodMasComponent);

							if (blood_bag_no != null
									&& !blood_bag_no.equals("")) {
								bloodStockDetail.setBloodBagNo((String) blood_bag_no.get(i));
									bloodStockDetail.setTubeNo((String) tube_bag_no.get(i));
							}
							if (quantity != null && !quantity.equals("")) {
								bloodStockDetail.setQty(Integer
										.parseInt((String) quantity.get(i)));
							}
							bloodStockDetail.setBloodIssued("n");
							bloodStockDetail.setExpiryDate((Date)expiry.get(i));
							

							hbt.save(bloodStockDetail);

						}
						saved = true;
					}
				}

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			// throw e; // or display error message
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jkt.hms.bloodBank.dataservice.BloodBankDataService#
	 * showDonorAssesstmentMasterJsp()
	 */
	public Map<String, Object> showDonorAssesstmentMasterJsp(int page,
			int recordsPerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAssessment> assesstmentList = new ArrayList<MasAssessment>();
		Session session = (Session) getSession();
		Criteria criteria = session.createCriteria(MasAssessment.class);
		criteria.setFirstResult((page - 1) * recordsPerPage);
		criteria.setMaxResults(recordsPerPage);
		assesstmentList = criteria.list();

		Criteria criteriaCount = session.createCriteria(MasAssessment.class);
		criteriaCount.setProjection(Projections.rowCount());
		int noOfRecords = (Integer) criteriaCount.uniqueResult();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		map.put("currentPage", page);
		map.put("noOfPages", noOfPages);
		map.put("assesstmentList", assesstmentList);

		return map;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.bloodBank.dataservice.BloodBankDataService#updateAssesstment(
	 * jkt.hms.util.Box)
	 */
	public boolean updateAssesstment(Box box) {
		Session session = (Session) getSession();
		boolean save = false;
		String name = "";
		String sequenceNumber = "";
		String code = "";
		String defferedType = "";
		String status = "";
		String category = "";
		int assesstmentUniqueId = box.getInt("assesstmentUniqueId");

		name = box.get("assesstmentName");
		
		System.out.println("assesstmentUniqueId name "+assesstmentUniqueId);
		System.out.println("name name "+name);
		
		code = box.get("assesstmentCode");
		sequenceNumber = box.getString("sequenceNumber");
		defferedType = box.getString("type");
		status = box.getString("status");
		category = box.getString("category");

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			MasAssessment assesstment = (MasAssessment) session.load(
					MasAssessment.class, assesstmentUniqueId);

			if (!name.equals("")) {
				assesstment.setAssessmentName(name);
			}
			if (!code.equals("")) {

				assesstment.setAssessmentCode(code);
			}
			if (!sequenceNumber.equals("")) {
				assesstment.setAssessmentSeqNo(sequenceNumber);
			}
			if (!defferedType.equals("")) {
				assesstment.setAssessmentType(defferedType);
				;
			}
			if (!status.equals("")) {
				assesstment.setStatus(status);
			}
			if (!category.equals("")) {
				assesstment.setAssessmentCategory(category);
			}

			session.update(assesstment);

			tx.commit();
			session.flush();
			save = true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return save;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.bloodBank.dataservice.BloodBankDataService#searchAssesstment(
	 * jkt.hms.util.Box)
	 */
	public Map<String, Object> searchAssesstment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAssessment> assesstmentList = new ArrayList<MasAssessment>();
		String assesstmentName = box.getString("assesstName");
		String assesstmentCode = box.getString("assesstCode");
		String squenceNmber = box.getString("sequenceNum");

		Session session = (Session) getSession();
		Criteria criteria = session.createCriteria(MasAssessment.class);
		if (null != assesstmentName && !assesstmentName.equals("")) {
			criteria.add(Restrictions.like("AssessmentName", assesstmentName
					+ "%"));
		}
		if (null != assesstmentCode && !assesstmentCode.equals("")) {
			criteria.add(Restrictions.like("AssessmentCode", assesstmentCode
					+ "%"));
		}
		if (null != squenceNmber && !squenceNmber.equals("")) {
			criteria.add(Restrictions.eq("AssessmentSeqNo", squenceNmber));
		}

		assesstmentList = criteria.list();
		System.out.println("assesstmentList " + assesstmentList.size());
		map.put("assesstmentList", assesstmentList);
		return map;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.bloodBank.dataservice.BloodBankDataService#showAssesstmentList()
	 */
	public Map<String, Object> showAssesstmentList(String UhidNo) {
		String registerNum="";
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAssessment> assesstmentDetailList = new ArrayList<MasAssessment>();
		List<BloodDonationEntryHeader> donationEntryHeaderList = new ArrayList<BloodDonationEntryHeader>();

		Session session = (Session) getSession();
		Criteria criteria = session.createCriteria(MasAssessment.class);
		criteria.add(Restrictions.eq("Status", "Active"));
		criteria.addOrder(Order.asc("AssessmentSeqNo"));
		
/*		criteria.setResultTransformer(new DistinctRootEntityResultTransformer());*/
		assesstmentDetailList = criteria.list();
		
		if(null !=UhidNo && !UhidNo.equals("")){
		Criteria crt = session.createCriteria(BloodDonationEntryHeader.class).add(Restrictions.eq("UhidNo", UhidNo));
		donationEntryHeaderList=crt.list();
		
		if(null !=donationEntryHeaderList && donationEntryHeaderList.size()>0){
			String donorSerialNum="";
			for(BloodDonationEntryHeader donation:donationEntryHeaderList){
				registerNum=donation.getDonationNo();
				donorSerialNum=String.valueOf(donation.getId());
				//System.out.println("registerNum "+registerNum);
			}
			map.put("registerNum", registerNum);
			map.put("donorIdNum", donorSerialNum);
		}
		}
		criteria.add(Restrictions.eq("Status", "Active"));
		
		map.put("assesstmentDetailList", assesstmentDetailList);

		return map;

	}

	@Override
	public int saveAssesstmentEntryHeader(
			BloodAssessmentEntryM asssesstmentEntrym) {
		
		String cellGroupRequired="";
		int donationId=0;
		cellGroupRequired=asssesstmentEntrym.getCellGroupingRequest();
		
		BloodResultEntryHeader breh=new BloodResultEntryHeader();
		MasHospital masHospital=asssesstmentEntrym.getBloodBank();
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		
		/*Date currentDate=new Date();
		String currentTime=HMSUtil.getCurrentTimeHHMM();*/
		
		int asssesstmentEntrymId = 0;
		Session session = (Session) getSession();
		Transaction tx = session.beginTransaction();
		try {
			
			
			session.save(asssesstmentEntrym);
			
			if(cellGroupRequired.equals("y")){
				
				
				 donationId=asssesstmentEntrym.getDonation().getId();
				 BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();
				 donationEntryHeader.setId(donationId);
				 breh.setDonor(donationEntryHeader);
				 breh.setCgStatus("P");
				 breh.setResultEntryValidation("P");
				 breh.setHospital(asssesstmentEntrym.getBloodBank());
				 breh.setHospital(masHospital);
				 
				 breh.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				 breh.setLastChgTime(time);
				 session.save(breh);
				
				}
			
			tx.commit();
			

			asssesstmentEntrymId = asssesstmentEntrym.getId();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

		}

		return asssesstmentEntrymId;
	}

	@Override
	public Map<String,Object> submitDonorDeferredStatus(Box box) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		boolean save = false;
		BigDecimal big = new BigDecimal(0.00);
		int donorAssesstMid = box.getInt("donorAssesstMid");

		Date deferredDate = null;
		long height = 0;
		String weight = "";
		String Temperature = "";
		long Pulse = 0;
		String Systolic = "";
		String Diastolic="";

		String general = "";
		String status = "";
		String remark = "";

		Pulse = box.getInt("Pulse");
		Systolic = box.get("Systolic");
		Diastolic=box.get("Diastolic");
		general = box.get("general");
		status = box.get("status");
		remark = box.get("remark");
		int storeItemBatchId=0;
		storeItemBatchId=box.getInt("bagTypename");
		
		String Hemoglobinv="";
		Hemoglobinv=box.get("Hemoglobinv");
		
		String DeferredTillDate = box.get("DeferredTillDate");
		if (null != DeferredTillDate && !DeferredTillDate.isEmpty()) {
			deferredDate = HMSUtil
					.convertStringTypeDateToDateType(DeferredTillDate);
		}
		int bloodAssessmentM = box.getInt("bloodAssessmentM");
		int donorbloodAssessmentEntryM=0;
		Session session = (Session) getSession();
		Transaction tx = session.beginTransaction();

		try {

			if (bloodAssessmentM > 0 && null != DeferredTillDate) {
				Date date = new Date();
				BloodAssessmentEntryM bloodAssessmentEntryM = (BloodAssessmentEntryM) session
						.load(BloodAssessmentEntryM.class, bloodAssessmentM);
				bloodAssessmentEntryM.setDeferredTillDate(deferredDate);
				bloodAssessmentEntryM.setLastChgDate(date);
				session.save(bloodAssessmentEntryM);
				BloodDonationEntryHeader bldHeader=bloodAssessmentEntryM.getDonation();
				bldHeader.setDefferedTillDate(deferredDate);
				
				session.flush();
				tx.commit();
				save = true;
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		}
		/*
		 * Session session1 = (Session) getSession(); Transaction tx1 =
		 * session1.beginTransaction();
		 */
		try {

			if (donorAssesstMid > 0) {
				Date date = new Date();
				BloodAssessmentEntryM bloodAssessmentEntryM = (BloodAssessmentEntryM) session
						.load(BloodAssessmentEntryM.class, donorAssesstMid);
				/*bloodAssessmentEntryM.setHeight(new BigDecimal(box
						.get("height")));*/
				bloodAssessmentEntryM.setWeight(new BigDecimal(box
						.get("weight")));
				bloodAssessmentEntryM.setTemperature(new BigDecimal(box
						.get("Temperature")));
				bloodAssessmentEntryM.setPulse(Pulse);
				bloodAssessmentEntryM.setBp(Systolic);
				bloodAssessmentEntryM.setBpDiastolic(Diastolic);
				bloodAssessmentEntryM.setCollectdVolume(new BigDecimal(box
						.get("volume")));
				bloodAssessmentEntryM.setRemarks(remark);
				/* session.save(bloodAssessmentEntryM); */
				bloodAssessmentEntryM.setPhysicalFit(status);
				bloodAssessmentEntryM.setPhysicalExam("N");
				
				Criteria crt=session.createCriteria(MasStoreItem.class)
						.add(Restrictions.eq("Id", storeItemBatchId));
				List<MasStoreItem> stockList=crt.list();
				
				if(null !=stockList && stockList.size()>0 && storeItemBatchId>0){
					for(MasStoreItem ss:stockList){
						MasStoreItem store=new MasStoreItem();
					store.setId(ss.getId());
					bloodAssessmentEntryM.setMasStoreItem(store);
					}
				}
				/*StoreItemBatchStock store=(StoreItemBatchStock) session.load(StoreItemBatchStock.class, storeItemBatchId);
				
				
				bloodAssessmentEntryM.setItemBatchStock(store);
				*/
				if(!Hemoglobinv.equals("")) {
						
						if( Hemoglobinv.equalsIgnoreCase("y")){
							bloodAssessmentEntryM.setHemoglobin("12.5 ");
						}
						else{
							bloodAssessmentEntryM.setHemoglobin(box.get("lowHemo"));
						}
					
				}
				
				
				session.save(bloodAssessmentEntryM);
				
				
				donorbloodAssessmentEntryM=bloodAssessmentEntryM.getId();
				
			/*	BigDecimal old_closing_qty=store.getClosingStock();
				BigDecimal cur_closing_qty=old_closing_qty.subtract(new BigDecimal(1));
				BigDecimal openning_balance_qty=store.getOpeningBalanceQty();
				BigDecimal issued_qty=openning_balance_qty.subtract(cur_closing_qty);
				
				store.setIssueQty(issued_qty);
				store.setClosingStock(cur_closing_qty);*/
				//session.update(store);
				//System.out.println("donorbloodAssessmentEntryM donorbloodAssessmentEntryMdonorbloodAssessmentEntryM "+donorbloodAssessmentEntryM);
				session.flush();
				tx.commit();
				save = true;
			}
			map.put("donorbloodAssessmentEntryM", donorbloodAssessmentEntryM);
			map.put("save", save);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		}

		return map;
	}

	@Override
	public Map<String, Object> showPendingListBloodSampleCollection(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> sampleScreeningList = new ArrayList<BloodSampleCollection>();

		int noOfRecords = 0;
		int noOfPages = 0;

		String tubeNumber = null;
		String bagNumber = null;
		String FROM_DATE = "";
		String TO_DATE = "";
		Date fromdate = null;
		Date toDate = null;
		int hospitalId=0;
		int page = box.getInt("page");
		int recordsPerPage = box.getInt("recordsPerPage");
		int totalNumberOfRecords = box.getInt("totalNumberOfRecords");

		Session session = (Session) getSession();

		Criteria crit = null;
		Criteria criteriaCount = null;

		if (box.get("bagNumber") != null) {
			bagNumber = box.get("bagNumber");
		}
		if (box.get("tubeNumber") != null) {
			tubeNumber = box.get("tubeNumber");
		}
		if(box.get(RequestConstants.HOSPITAL_ID)!=null){
			hospitalId=box.getInt(RequestConstants.HOSPITAL_ID);
		}
		if (!box.get("fromDate").equals("")) {
			FROM_DATE = box.get("fromDate");
			System.out.println(FROM_DATE);
			fromdate = HMSUtil.convertStringTypeDateToDateType(FROM_DATE);
			System.out.println(fromdate);

		}
		if (!box.get("toDate").equals("")) {
			TO_DATE = box.get("toDate");
			System.out.println(TO_DATE);
			toDate = HMSUtil.convertStringTypeDateToDateType(TO_DATE);

		}

		try {
			crit = session.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hospitalId")
					.add(Restrictions.eq("hospitalId.Id", hospitalId))
			.add(Restrictions.eq("AcceptedRejected", "Y").ignoreCase())
			.add(Restrictions.eq("SampleStatus", "B").ignoreCase());

			criteriaCount = session.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hospitalId")
					.add(Restrictions.eq("hospitalId.Id", hospitalId))
			.add(Restrictions.eq("AcceptedRejected", "Y"))
			.add(Restrictions.eq("SampleStatus", "B").ignoreCase())
			.setProjection(Projections.rowCount());

			if (null != bagNumber && !bagNumber.isEmpty()) {
				crit.add(Restrictions.eq("BagNumber", bagNumber));
				
				criteriaCount = session
						.createCriteria(BloodSampleCollection.class).createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("BagNumber", bagNumber))
				.add(Restrictions.eq("AcceptedRejected", "Y"))
			.add(Restrictions.eq("SampleStatus", "B")
						.ignoreCase());
				criteriaCount.setProjection(Projections.rowCount());
			}
			if (null != tubeNumber && !tubeNumber.isEmpty()) {

				crit.add(Restrictions.eq("TubeNumber", tubeNumber));

				criteriaCount = session
						.createCriteria(BloodSampleCollection.class);
				criteriaCount.add(Restrictions.eq("TubeNumber", tubeNumber));
				criteriaCount.add(Restrictions.eq("AcceptedRejected", "Y"));
				criteriaCount.add(Restrictions.eq("SampleStatus", "B")
						.ignoreCase());
				criteriaCount.setProjection(Projections.rowCount());
			}
			if (null != fromdate && null != toDate) {

				crit.add(Restrictions.ge("SampleCollectionDate",
						new java.sql.Date(fromdate.getTime())));
				crit.add(Restrictions.lt("SampleCollectionDate",
						new java.sql.Date(toDate.getTime())));

				criteriaCount = session
						.createCriteria(BloodSampleCollection.class);
				criteriaCount.add(Restrictions.ge("SampleCollectionDate",
						new java.sql.Date(fromdate.getTime())));
				criteriaCount.add(Restrictions.lt("SampleCollectionDate",
						new java.sql.Date(toDate.getTime())));
				criteriaCount.add(Restrictions.eq("AcceptedRejected", "Y"));
				criteriaCount.add(Restrictions.eq("SampleStatus", "B")
						.ignoreCase());
				criteriaCount.setProjection(Projections.rowCount());

			}

			noOfRecords = (Integer) criteriaCount.uniqueResult();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			map.put("currentPage", page);
			map.put("noOfPages", noOfPages);
			if(hospitalId!=0){
				crit=crit.add(Restrictions.eq("Hospital.Id", hospitalId));
			}
			crit.setFirstResult((page*recordsPerPage) - recordsPerPage);
			crit.setMaxResults(recordsPerPage);
			
			sampleScreeningList = crit.list();
			System.out.println("gk  "+sampleScreeningList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("sampleScreeningList", sampleScreeningList);
		return map;
	}
	
	@Override
	public Map<String, Object> showPendingListBloodCollection(Box box) {
		Query Q = null;
		Query query1=null;
		
		String query = null;
		String countQ = null;
		int noOfRecords = 0;
		int noOfPages = 0;
		List<Object[]> PhysicalfitList = null;

		boolean qst = true;
		String donorRegNo = "";
		String mobile = "";
		long idCardId = 0;
		String idCardNumber = "";
		int gender = 0;
		String donorName = "";
		String dob = "";

		donorRegNo = box.getString("registerNumber");
		mobile = box.get("mobileNumber");
		idCardId = box.getLong("IdCard");
		idCardNumber = box.get("IdCardNumber");
		gender = box.getInt("gender");
		donorName = box.get("donorName");
		dob = box.get("dob");
		/* System.out.println("dob "+dob); */
		Date birthday = null;
		Date date = null;
		if (null != dob && !dob.isEmpty()) {
			date = HMSUtil.convertStringTypeDateToDateType(dob);
			birthday = new java.sql.Date(date.getTime());
			/* System.out.println(birthday); */
		}
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIdCard> mapIdCard = new ArrayList<MasIdCard>();
		List<MasAdministrativeSex> masGender = new ArrayList<MasAdministrativeSex>();

		Criteria criteria = session.createCriteria(MasIdCard.class);
		mapIdCard = criteria.list();

		criteria = session.createCriteria(MasAdministrativeSex.class);
		masGender = criteria.list();
		int page = box.getInt("page");
		int recordsPerPage = box.getInt("recordsPerPage");
		String assestResult = "Non";
		if (null != donorRegNo && !donorRegNo.equals("")) {
			String ss="select bh.doner_name,mas.administrative_sex_name,bh.mob_no,bh.donation_no,bh.date_of_birth,mId.id_card_code,mId.id_card_id,bh.donation_id,bm.pulse,bm.bp,bh.uhid_no,bm.bp_diastolic,ms.item_id "
					+ "from blood_donation_entry_header bh "
					+ "left outer join blood_assessment_entry_m bm on bm.donation_id=bh.donation_id	"
					
					+ "left outer join mas_store_item ms on ms.item_id =bm.item_id "
					+ "left outer join mas_administrative_sex mas on mas.administrative_sex_id =bh.sex_id "
					+ "left outer join mas_id_card mId on mId.id_card_id =bh.identity_card "
					+ "where bm.donation_id=bh.donation_id and bm.physical_fit='Y' and bm.physical_exam='N' and bm.bld_collection_status='P' and bm.final_result like '%Non%' and bh.donation_no=:donation_no";
			
			 query1 = session.createSQLQuery(ss);
			 query1.setParameter("donation_no", donorRegNo );
			 Q = session.createSQLQuery(ss);
				Q.setParameter("donation_no", donorRegNo);
				Q.setFirstResult((page - 1) * recordsPerPage);
				Q.setMaxResults(recordsPerPage);
			PhysicalfitList =Q.list();
			
			noOfRecords = PhysicalfitList.size();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			qst = false;

		}

		if (idCardId > 0 && null != idCardNumber && !idCardNumber.equals("")) {
			String ss="select bh.doner_name,mas.administrative_sex_name,bh.mob_no,bh.donation_no,bh.date_of_birth,mId.id_card_code,mId.id_card_id,bh.donation_id,bm.pulse,bm.bp,bh.uhid_no,bm.bp_diastolic,ms.item_id "
					+ "from blood_donation_entry_header bh "
					+ "left outer join blood_assessment_entry_m bm on bm.donation_id=bh.donation_id	"
					
					+ "left outer join mas_store_item ms on ms.item_id =bm.item_id "
					+ "left outer join mas_administrative_sex mas on mas.administrative_sex_id =bh.sex_id "
					+ "left outer join mas_id_card mId on mId.id_card_id =bh.identity_card "
					+ "where bm.donation_id=bh.donation_id and bm.physical_fit='Y' and bm.physical_exam='N' and bm.bld_collection_status='P'  and bm.final_result like '%Non%' and bh.identity_card_no=:identity_card_no";
			
			 query1 = session.createSQLQuery(ss);
			 query1.setParameter("identity_card_no", idCardNumber );
			 Q = session.createSQLQuery(ss);
				Q.setParameter("identity_card_no", idCardNumber);
				Q.setFirstResult((page - 1) * recordsPerPage);
				Q.setMaxResults(recordsPerPage);
			PhysicalfitList =Q.list();
			noOfRecords = PhysicalfitList.size();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			qst = false;
		}
		if (null != mobile && !mobile.equals("")) {
			System.out.println("mobile " + mobile);

			String ss="select bh.doner_name,mas.administrative_sex_name,bh.mob_no,bh.donation_no,bh.date_of_birth,mId.id_card_code,mId.id_card_id,bh.donation_id,bm.pulse,bm.bp,bh.uhid_no,bm.bp_diastolic,ms.item_id "
					+ "from blood_donation_entry_header bh "
					+ "left outer join blood_assessment_entry_m bm on bm.donation_id=bh.donation_id	"
					
					+ "left outer join mas_store_item ms on ms.item_id =bm.item_id "
					+ "left outer join mas_administrative_sex mas on mas.administrative_sex_id =bh.sex_id "
					+ "left outer join mas_id_card mId on mId.id_card_id =bh.identity_card "
					+ "where bm.donation_id=bh.donation_id and bm.physical_fit='Y' and bm.physical_exam='N' and bm.bld_collection_status='P'  and bm.final_result like '%Non%' and bh.mob_no=:mobNo";
			
			 query1 = session.createSQLQuery(ss);
			 query1.setParameter("mobNo", mobile );
			 Q = session.createSQLQuery(ss);
				Q.setParameter("mobNo", mobile);
				Q.setFirstResult((page - 1) * recordsPerPage);
				Q.setMaxResults(recordsPerPage);
			PhysicalfitList = Q.list();
			noOfRecords = PhysicalfitList.size();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			qst = false;
		}
		if (gender > 0) {
			System.out.println("gender " + gender);
			String ss="select bh.doner_name,mas.administrative_sex_name,bh.mob_no,bh.donation_no,bh.date_of_birth,mId.id_card_code,mId.id_card_id,bh.donation_id,bm.pulse,bm.bp,bh.uhid_no,bm.bp_diastolic,ms.item_id "
					+ "from blood_donation_entry_header bh "
					+ "left outer join blood_assessment_entry_m bm on bm.donation_id=bh.donation_id	"
					
					+ "left outer join mas_store_item ms on ms.item_id =bm.item_id "
					+ "left outer join mas_administrative_sex mas on mas.administrative_sex_id =bh.sex_id "
					+ "left outer join mas_id_card mId on mId.id_card_id =bh.identity_card "
					+ "where bm.donation_id=bh.donation_id and bm.physical_fit='Y' and bm.physical_exam='N' and bm.bld_collection_status='P'  and bm.final_result like '%Non%' and bh.sex_id=:sexId";
			
			 query1 = session.createSQLQuery(ss);
			 query1.setParameter("sexId", gender );
			 Q = session.createSQLQuery(ss);
				Q.setParameter("sexId", gender);
				Q.setFirstResult((page - 1) * recordsPerPage);
				Q.setMaxResults(recordsPerPage);
			PhysicalfitList = Q.list();
			noOfRecords = PhysicalfitList.size();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			qst = false;
		}
		if (null != donorName && !donorName.equals("")) {
			//query = "select bh.DonerName,bh.Sex,bh.MobNo,bh.DonationNo,bh.DateOfBirth,bh.IdentityCardNo,bh.IdentityCard,bh.Id,bm.Pulse,bm.Bp,bh.UhidNo,bm.BpDiastolic,bm.ItemBatchStock.Id,bm.ItemBatchStock.ExpiryDate from BloodAssessmentEntryM bm  join bm.Donation bh where bm.Donation=bh.Id and bm.PhysicalFit='Y' and bm.PhysicalExam='N' and bm.FinalResult ='Non' and bh.DonerName Like ? ";
			//Q = session.createQuery(query);
           
			String ss="select bh.doner_name,mas.administrative_sex_name,bh.mob_no,bh.donation_no,bh.date_of_birth,mId.id_card_code,mId.id_card_id,bh.donation_id,bm.pulse,bm.bp,bh.uhid_no,bm.bp_diastolic,ms.item_id "
					+ "from blood_donation_entry_header bh "
					+ "left outer join blood_assessment_entry_m bm on bm.donation_id=bh.donation_id	"
					
					+ "left outer join mas_store_item ms on ms.item_id =bm.item_id "
					+ "left outer join mas_administrative_sex mas on mas.administrative_sex_id =bh.sex_id "
					+ "left outer join mas_id_card mId on mId.id_card_id =bh.identity_card "
					+ "where bm.donation_id=bh.donation_id and bm.physical_fit='Y' and bm.physical_exam='N' and bm.bld_collection_status='P'  and bm.final_result like '%Non%' and bh.doner_name=:name";
			
			 query1 = session.createSQLQuery(ss);
			 query1.setParameter("name", donorName + "%");
			 Q = session.createSQLQuery(ss);
				Q.setParameter("name", donorName + "%");
				Q.setFirstResult((page - 1) * recordsPerPage);
				Q.setMaxResults(recordsPerPage);
			PhysicalfitList = Q.list();
			noOfRecords = PhysicalfitList.size();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			qst = false;
		}
		List<Object[]> donorPhyList =null;
		if (null != dob && !dob.equals("")) {
			/*query = "select bh.DonerName,bh.Sex,bh.MobNo,bh.DonationNo,bh.DateOfBirth,bh.IdentityCardNo,bh.IdentityCard,bh.Id,bm.Pulse,bm.Bp,bh.UhidNo,"
					+ "bm.BpDiastolic,bm.ItemBatchStock.Id,bm.ItemBatchStock.ExpiryDate from BloodAssessmentEntryM bm  join "
					+ "bm.Donation bh where bm.Donation=bh.Id and bm.PhysicalFit='Y' and bm.PhysicalExam='N'and  bm.FinalResult ='Non' and bh.DateOfBirth=?";
*/
			String ss="select bh.doner_name,mas.administrative_sex_name,bh.mob_no,bh.donation_no,bh.date_of_birth,mId.id_card_code,mId.id_card_id,bh.donation_id,bm.pulse,bm.bp,bh.uhid_no,bm.bp_diastolic,ms.item_id "
					+ "from blood_donation_entry_header bh "
					+ "left outer join blood_assessment_entry_m bm on bm.donation_id=bh.donation_id	"
					
					+ "left outer join mas_store_item ms on ms.item_id =bm.item_id "
					+ "left outer join mas_administrative_sex mas on mas.administrative_sex_id =bh.sex_id "
					+ "left outer join mas_id_card mId on mId.id_card_id =bh.identity_card "
					+ "where bm.donation_id=bh.donation_id and bm.physical_fit='Y' and bm.physical_exam='N' and bm.bld_collection_status='P'  and bm.final_result like '%Non%' and bh.date_of_bithdat=:dob1";
			
			 query1 = session.createSQLQuery(ss);
			 query1.setParameter("dob1", dob);
			 
			Q = session.createSQLQuery(ss);
			Q.setParameter("dob1", dob);
			Q.setFirstResult((page - 1) * recordsPerPage);
			Q.setMaxResults(recordsPerPage);
			PhysicalfitList = Q.list();
			noOfRecords = PhysicalfitList.size();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			qst = false;
		}
Date assessmentCurnDate=new Date();
		if (qst) {
			
			
			String ss="select bh.doner_name,mas.administrative_sex_name,bh.mob_no,bh.donation_no,bh.date_of_birth,mId.id_card_code,mId.id_card_id,bh.donation_id,bm.pulse,bm.bp,bh.uhid_no,bm.bp_diastolic,ms.item_id "
					+ "from blood_donation_entry_header bh "
					+ "left outer join blood_assessment_entry_m bm on bm.donation_id=bh.donation_id	"
					
					+ "left outer join mas_store_item ms on ms.item_id =bm.mas_store_item_id "
					+ "left outer join mas_administrative_sex mas on mas.administrative_sex_id =bh.sex_id "
					+ "left outer join mas_id_card mId on mId.id_card_id =bh.identity_card "
					+ "where bm.donation_id=bh.donation_id and bm.physical_fit='Y'and bm.assessment_date='"+assessmentCurnDate+"' and bm.physical_exam='N' and bm.bld_collection_status='P'  and bm.final_result like '%Non%' ";
			
			 query1 = session.createSQLQuery(ss);
			
			
			//System.out.println("donorPhyList @@@@ "+donorPhyList.size());
			/*query = "select bh.DonerName,bh.Sex,bh.MobNo,bh.DonationNo,bh.DateOfBirth,bh.IdentityCardNo,bh.IdentityCard,bh.Id,bm.Pulse,bm.Bp,bh.UhidNo,bm.BpDiastolic,"
					+ "bm.ItemBatchStock.Id,bm.ItemBatchStock.ExpiryDate from BloodAssessmentEntryM bm ,BloodDonationEntryHeader bh  "
					+ " where bm.Donation.Id=bh.Id and bm.PhysicalFit='Y'  and bm.PhysicalExam='N'  and bm.FinalResult like '%Non%'";
*/
		//	Q1 = session.createQuery(query);
			/* Q.setString("f",assestResult); */
			Q = session.createSQLQuery(ss);
			//donorPhyList = Q.list();
			
			Q.setFirstResult((page - 1) * recordsPerPage);
			Q.setMaxResults(recordsPerPage);
			
			PhysicalfitList = Q.list();
			
			noOfRecords = PhysicalfitList.size();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		}
		donorPhyList = query1.list();
		
		
		String dobdate=null;
		for (Object[] ph : donorPhyList) {

			/*MasAdministrativeSex hh = (MasAdministrativeSex) ph[1];
			ph[1] = hh.getAdministrativeSexName();

			MasIdCard idcard = (MasIdCard) ph[6];
			ph[6] = idcard.getIdCardCode();*/
			dobdate=HMSUtil.convertDateToStringTypeDateOnly((Date) ph[4]);
			ph[4]=dobdate;
			/* phy.add( (Object[]) ph[1]); */

		}
		List<BloodMasComponent> bldcomponent=new ArrayList<BloodMasComponent>();
		Criteria crt=null;
		crt=session.createCriteria(BloodMasComponent.class);
		bldcomponent=crt.list();
		
		map.put("bldcomponent", bldcomponent);
		map.put("currentPage", page);
		map.put("noOfPages", noOfPages);
		map.put("donorPhyList", donorPhyList);
		map.put("mapIdCard", mapIdCard);
		map.put("masGender", masGender); 

		return map;
	}

	public Map<String, Object> showBloodTestList() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DgMasInvestigation> testlist = new ArrayList<DgMasInvestigation>();
		List<DgMasInvestigation> testNonBloodBanklist = new ArrayList<DgMasInvestigation>();

		Criteria criteria = session.createCriteria(DgMasInvestigation.class);
		criteria.add(Restrictions.eq("BloodBankScreenTest", "y").ignoreCase());
		testlist = criteria.list();
		
		
		Criteria crty = session.createCriteria(DgMasInvestigation.class);
		crty.add(Restrictions.eq("BloodBankScreenTest", "n").ignoreCase());
		testNonBloodBanklist = crty.list();

		map.put("testlist", testlist);
		map.put("testNonBloodBanklist", testNonBloodBanklist);

		return map;

	}

	@Override
	public Map<String, Object> showPendingListResultEntry(int hospitalId) {
		String query = "";
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();
		List<Object[]> pendingscreeningList = new ArrayList<Object[]>();

		query = "select bc.BagNumber,bc.TubeNumber,bc.ComponentQuantity,bc.SampleCollectionDate,bc.QuantityCollected,bh.Id "
				+ "from BloodSampleScreeningHeader bh join bh.SampleCollection bc where bh.SampleCollection.Id=bc.Id and bh.Hospital.Id='"+hospitalId+"' "
				+ "and bh.ResultEntryStatus='P' ";
		Query Q = session.createQuery(query);
		pendingscreeningList = Q.list();
		System.out.println("pendingscreeningList "+ pendingscreeningList.size());

		/*
		 * Criteria
		 * crt=session.createCriteria(BloodSampleScreeningHeader.class);
		 * crt.add(Restrictions.eq("ResultEntryStatus", "p").ignoreCase());
		 * screeningList=crt.list(); map.put("screeningList", screeningList);
		 */
		String bloodSampleCollectionDate=null;
		for(Object[] screenList:pendingscreeningList){
			bloodSampleCollectionDate=HMSUtil.convertDateTypeToStringWithoutTime((Date)screenList[3]);
			screenList[3]=bloodSampleCollectionDate;
		}

		map.put("pendingscreeningList", pendingscreeningList);

		return map;
	}
	
	@Override
	public Map<String, Object> showPendingListResultEntryCg(int hospitalId) {
		String query = "";
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();
		List<Object[]> pendingscreeningList = new ArrayList<Object[]>();

		/*query = "select bc.BagNumber,bc.TubeNumber,bc.SampleCollectionDate,bc.QuantityCollected,bh.Id from BloodResultEntryHeader breh, BloodSampleScreeningHeader bh join bh.SampleCollection bc "
				+ "where bh.SampleCollection.Id=bc.Id and bh.ResultEntryStatus='P' and breh.CgStatus='P' and breh.ResultEntryValidation='P'";
		Query Q = session.createQuery(query);*/
		
		Criteria crt=null;
		crt=session.createCriteria(BloodResultEntryHeader.class).add(Restrictions.eq("CgStatus", "p").ignoreCase())
				.add(Restrictions.eq("ResultEntryValidation", "p").ignoreCase()).createAlias("Hospital", "hosp")
				.add(Restrictions.eq("hosp.Id", hospitalId));
		
		
		pendingscreeningList = crt.list();
		

		/*
		 * Criteria
		 * crt=session.createCriteria(BloodSampleScreeningHeader.class);
		 * crt.add(Restrictions.eq("ResultEntryStatus", "p").ignoreCase());
		 * screeningList=crt.list(); map.put("screeningList", screeningList);
		 */

		map.put("pendingscreeningList", pendingscreeningList);

		return map;
	}
	@Override
	public Map<String, Object> showPendingListResultEntrySg(int hospitalId) {
		String query = "";
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();
		List<BloodResultEntryHeader> pendingscreeningList = new ArrayList<BloodResultEntryHeader>();

		/*query = "select bc.BagNumber,bc.TubeNumber,bc.SampleCollectionDate,bc.QuantityCollected,bh.Id from BloodResultEntryHeader breh,BloodSampleScreeningHeader bh join bh.SampleCollection bc "
				+ "where bh.SampleCollection.Id=bc.Id  and breh.SgStatus='P' and breh.ResultEntryValidation='P' ";
		Query Q = session.createQuery(query);*/
		
		Criteria crt=null;
		crt=session.createCriteria(BloodResultEntryHeader.class).createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("SgStatus", "p").ignoreCase())
				.add(Restrictions.eq("ResultEntryValidation", "p").ignoreCase());
		
		pendingscreeningList = crt.list();
		//System.out.println("pendingscreeningList "+ pendingscreeningList.size());
		
		/*
		 * Criteria
		 * crt=session.createCriteria(BloodSampleScreeningHeader.class);
		 * crt.add(Restrictions.eq("ResultEntryStatus", "p").ignoreCase());
		 * screeningList=crt.list(); map.put("screeningList", screeningList);
		 */


		map.put("pendingscreeningList", pendingscreeningList);

		return map;
	}
	
	@Override
	public Map<String, Object> resultEntryFormJsp(int id,int hospitalId) {
		String query = "";
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();
		List<BloodSampleScreeningDetail> screenDetailList = new ArrayList<BloodSampleScreeningDetail>();
		List<DgMasInvestigation> investionList = new ArrayList<DgMasInvestigation>();
		

		Criteria crt=null;
		/*crt=session.createCriteria(BloodSampleScreeningDetail.class).createAlias("ScreenTest", "ScreenTest")
				.add(Restrictions.eq("ScreenTest.ResultEntryStatus", "P").ignoreCase())
				.createAlias("Investigation", "Investigation")
				.add(Restrictions.eq("ScreenTest.Id", id));*/
		
		crt=session.createCriteria(BloodSampleScreeningDetail.class).createAlias("ScreenTest", "screenTest")
				.createAlias("screenTest.Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("screenTest.Id", id));
		screenDetailList = crt.list();
		
		
		
		crt=session.createCriteria(BloodSampleScreeningHeader.class).createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("Id", id));
		
		screeningList=crt.list();
		
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		

		

		map.put("screenDetailList", screenDetailList);
		map.put("screeningList", screeningList);
		map.put("bloodGroupList", bloodGroupList);
		return map;
	}
	
	@Override
	public Map<String, Object> resultEntryFormContJsp(int id,int hospitalId) {
		String query = "";
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodResultEntryHeader> screeningList = new ArrayList<BloodResultEntryHeader>();
		List<BloodResultEntryDetails> screenDetailList = new ArrayList<BloodResultEntryDetails>();
		List<DgMasInvestigation> investionList = new ArrayList<DgMasInvestigation>();
		

		Criteria crt=null;
		/*crt=session.createCriteria(BloodSampleScreeningDetail.class).createAlias("ScreenTest", "ScreenTest")
				.add(Restrictions.eq("ScreenTest.ResultEntryStatus", "P").ignoreCase())
				.createAlias("Investigation", "Investigation")
				.add(Restrictions.eq("ScreenTest.Id", id));*/
		
		
		crt=session.createCriteria(BloodResultEntryDetails.class).createAlias("Header", "header")
				.createAlias("header.Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("Header.Id", id));
		screenDetailList = crt.list();
		
		//System.out.println("screenDetailList "+ screenDetailList.size());
		
		crt=session.createCriteria(BloodResultEntryHeader.class)
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("Id", id));
		
		screeningList=crt.list();
		
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
	

		

		map.put("screenDetailList", screenDetailList);
		map.put("screeningList", screeningList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("bloodResultEntryHeaderId", id);
		return map;
	}

	@Override
	public Map<String, Object> showPendingSampleScreeningTestJsp(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Criteria crt = null;
		int bloodBankId=box.getInt("hospitalId");
		
		List<BloodRequestEntryHeader> bloodRequestList = new ArrayList<BloodRequestEntryHeader>();

		

		crt = session.createCriteria(BloodRequestEntryHeader.class).createAlias("BloodBank", "BloodBankId")
				.add(Restrictions.eq("BloodBankId.Id",bloodBankId ))
				.add(Restrictions.eq("OrderDate",new Date()))
				.add(Restrictions.eq("SampleCollectionStatus", "V").ignoreCase())
				.add(Restrictions.eq("RequestStatus", "P").ignoreCase())
				.add(Restrictions.eq("CrossMatchStatus", "P").ignoreCase());

		bloodRequestList = crt.list();
		
		map.put("bloodRequestList", bloodRequestList);

		return map;
	}


	@Override
	public Map<String, Object> showCrossMatchingJsp(int bloodRequestHeaderId,int hospitalId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Inpatient> inpatient=new ArrayList<Inpatient>();
		
		List<BloodRequestEntryDetail> requestEntryDetails=new ArrayList<BloodRequestEntryDetail>();
		
		List<MasBloodGroup> bloodGroupSample=new ArrayList<MasBloodGroup>();
		
		Session session = (Session) getSession();
		Criteria crt = null;
		
		crt=session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status","y").ignoreCase());
		
		bloodGroupSample=crt.list();

			    	crt=session.createCriteria(BloodRequestEntryDetail.class)
			    			.createAlias("Request", "request").createAlias("request.BloodBank", "bloodBank")
			    			 .add(Restrictions.eq("bloodBank.Id", hospitalId))
				    .add(Restrictions.eq("request.Id", bloodRequestHeaderId));
				    requestEntryDetails=crt.list();
		
		List<DgMasInvestigation> testlist = new ArrayList<DgMasInvestigation>();
		List<DgMasInvestigation> testNonBloodBanklist = new ArrayList<DgMasInvestigation>();

		Criteria criteria = session.createCriteria(DgMasInvestigation.class);
		criteria.add(Restrictions.eq("BloodBankScreenTest", "y").ignoreCase());
		testlist = criteria.list();

		Criteria crty = session.createCriteria(DgMasInvestigation.class);
		crty.add(Restrictions.eq("BloodBankScreenTest", "n").ignoreCase());
		testNonBloodBanklist = crty.list();

		map.put("testlist", testlist);
		map.put("testNonBloodBanklist", testNonBloodBanklist);
		
		map.put("bloodGroupSample", bloodGroupSample);
		//map.put("patientDetailList", patientDetailList);
		
		map.put("requestEntryDetails", requestEntryDetails);
		

		return map;
	}

	
	@Override
	public String getOrderSeqForDisplaysample(String string) {
		
			List<Integer> orderSeqNoList = new ArrayList<Integer>();
			List<DgOrderhd> seqNoList = new ArrayList<DgOrderhd>();
			String orderSeqNo = "";
			String lastSeqNo = "";
			String lastSeqYear = "";
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String currentYear = date.substring(date.lastIndexOf("/") + 1);
			Session session = (Session) getSession();
			try {

				seqNoList = session
						.createQuery(
								"select hd from DgOrderhd hd where hd.Id =(select max(Id) from DgOrderhd)")
						.list();
				if (seqNoList.size() > 0) {
					DgOrderhd dgOrderhd = new DgOrderhd();
					dgOrderhd = (DgOrderhd) seqNoList.get(0);
					lastSeqNo = dgOrderhd.getOrderNo();
					StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
					while (str.hasMoreTokens()) {
						lastSeqYear = str.nextToken();
					}
				} else {
					lastSeqYear = currentYear;
				}

				orderSeqNoList = session
						.createCriteria(TransactionSequence.class)
						.add(Restrictions.eq("TransactionPrefix", "ON"))
						.setProjection(
								Projections.projectionList().add(
										Projections
												.max("TransactionSequenceNumber")))
						.list();
				if (orderSeqNoList.size() > 0) {
					for (Integer maxOrderNo : orderSeqNoList) {
						if (currentYear.equals(lastSeqYear)) {
							orderSeqNo = String.valueOf(maxOrderNo + 1);
						} else {
							orderSeqNo = String.valueOf(1);
						}
					}
				} else {
					orderSeqNo = String.valueOf(1);
				}
				orderSeqNo = orderSeqNo.concat("/").concat(
						String.valueOf(lastSeqYear));
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return orderSeqNo;
		}

	

	@Override
	public Map<String, Object> showBloodBankRegistryJsp(Box box) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<MasDistrict> districtList=new ArrayList<MasDistrict>();
		List<MasTaluk> talukList=new ArrayList<MasTaluk>();
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		
		Session session = (Session) getSession();
		
		String sregNum=box.get("sregNum");
		String sbbName=box.get("sbbName");
		String scontactNum=box.get("scontactNum");
		int sdistrictname=box.getInt("sdistrictname");
		int staluk=box.getInt("staluk");
		
		Criteria crt=null;
		crt=session.createCriteria(MasDistrict.class).createAlias("State", "State")
				.add(Restrictions.eq("State.Id", 18)).addOrder(Order.asc("DistrictName"));
		districtList=crt.list();
		
		crt=session.createCriteria(MasTaluk.class).createAlias("State", "State")
				.add(Restrictions.eq("State.Id", 18)).addOrder(Order.asc("TalukName"));
		talukList=crt.list();
		
		crt=session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("BbAvailable", "y").ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase());
			
		if(sregNum !=null && !sregNum.isEmpty()){
			crt.add(Restrictions.eq("BbRegistrationNumber", sregNum));
		}
		if(sbbName !=null && !sbbName.isEmpty()){
			crt.add(Restrictions.like("HospitalName", sbbName+"%").ignoreCase());
		}
		if(scontactNum !=null && !scontactNum.isEmpty()){
			crt.add(Restrictions.eq("ContactNumber", scontactNum));
		}
		if(sdistrictname >0 ){
			crt.createAlias("District", "district");
			crt.add(Restrictions.eq("district.Id", sdistrictname));
		}
		if(staluk >0 ){
			crt.createAlias("Taluk", "taluk");
			crt.add(Restrictions.eq("taluk.Id", staluk));
		}
		
		hospitalList=crt.list();
		
		map.put("hospitalList", hospitalList);
		map.put("districtList", districtList);
		map.put("talukList", talukList);
		
		return map;
	}

	
	@Override
	public Map<String,Object> registerBloodBank(Box box) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		String registrationNum=box.get("registrationNum");
		String bloodBankName=box.get("bankName");
		String contactNum=box.get("contactNum");
		
		
		int hospitalTypeId=30;
		MasHospitalType hospType=new MasHospitalType();
		hospType.setId(hospitalTypeId);
		
		int districtname=box.getInt("districtname");
		int taluk=box.getInt("taluk");
		
		MasDistrict district=new MasDistrict();
			district.setId(districtname);
			
		MasTaluk mastaluk=new MasTaluk();
		mastaluk.setId(taluk);
		
		String bloodBankType="";
		String Sun=box.get("Sun");
		String Mon=box.get("Mon");
		String Tue=box.get("Tue");
		String Wed=box.get("Wed");
		String Thu=box.get("Thu");
		String Fri=box.get("Fri");
		String Sat=box.get("Sat");
		
		String weeklyOff="";
		if(Sun !=null && !Sun.isEmpty())
		{
			weeklyOff=weeklyOff+Sun+",";
		}
		if(Mon !=null && !Mon.isEmpty())
		{
			weeklyOff=weeklyOff+Mon+",";
		}
		if(Tue !=null && !Tue.isEmpty())
		{
			weeklyOff=weeklyOff+Tue+",";
		}
		if(Wed !=null && !Wed.isEmpty())
		{
			weeklyOff=weeklyOff+Wed+",";
		}
		if(Thu !=null && !Thu.isEmpty())
		{
			weeklyOff=weeklyOff+Thu+",";
		}
		if(Fri !=null && !Fri.isEmpty())
		{
			weeklyOff=weeklyOff+Fri+",";
		}
		if(Sat !=null && !Sat.isEmpty())
		{
			weeklyOff=weeklyOff+Sat+",";
		}
		System.out.println("weeklyOff"+weeklyOff);
		
		String street=box.get("street");
		String landmark=box.get("landmark");
		String interExt=box.get("banktype");
		System.out.println("interExt "+interExt);
		if(interExt.equalsIgnoreCase("gover")){
			bloodBankType="y";
		}else{
			bloodBankType="n";
		}
		String statTime=box.get("statrtTime");
		String endTime=box.get("endTime");
		String validToDate=box.get("datefrom");
		String validfromDate=box.get("dateTo");
		
		MasHospital bloodBank=new MasHospital();
		//bloodBank.setBloodBank(bloodBankName);
		bloodBank.setHospitalCode(registrationNum);
		bloodBank.setBbRegistrationNumber(registrationNum);
		bloodBank.setBbWeeklyOff(weeklyOff);
		bloodBank.setHospitalName(bloodBankName);
		bloodBank.setContactNumber(contactNum);
		bloodBank.setDistrict(district);
		bloodBank.setTaluk(mastaluk);
		bloodBank.setAdd2Street(street);
		bloodBank.setOpeningTime(statTime);
		bloodBank.setClosingTime(endTime);
		bloodBank.setHospitalType(hospType);
		bloodBank.setBbAvailable("y");
		bloodBank.setStatus("y");
		bloodBank.setValidFrom(HMSUtil.convertStringTypeDateToDateType(validfromDate));
		bloodBank.setValidTo(HMSUtil.convertStringTypeDateToDateType(validToDate));
		Session session=(Session) getSession();
		
		List<MasDistrict> districtList=new ArrayList<MasDistrict>();
		Criteria crt=null;
		crt=session.createCriteria(MasDistrict.class).createAlias("State", "State")
				.add(Restrictions.eq("State.Id", 18)).addOrder(Order.asc("DistrictName"));
		districtList=crt.list();
		map.put("districtList", districtList);
		
		Transaction tnx=null;
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		String bloodBankSerialNo=getBloodBankNo();
		
		
		try{
			tnx=session.beginTransaction();
			hbt.setCheckWriteOperations(false);
			bloodBank.setBloodBankNo(bloodBankSerialNo);
			hbt.save(bloodBank);
			successfullyAdded = true;
			session.flush();
			tnx.commit();
			
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		map.put("successfullyAdded",successfullyAdded);
		return map;
	}

	

	@Override
	public Map<String, Object> populateBloodBankRegistryJsp(int hospId) {
List<MasHospital> hospitalList=new ArrayList<MasHospital>();
Map<String,Object> map=new HashMap<String,Object>();
		Session session = (Session) getSession();
		
		Criteria crt=null;
		crt=session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("BbAvailable", "y").ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Id", hospId));
		hospitalList=crt.list();
		System.out.println("hospitalList "+hospitalList.size());
		map.put("hospitalList", hospitalList);
		
		return map;
	}


	@Override
	public Map<String, Object> showPendingForResultValidation(int hospitalId) {
		List<BloodResultEntryHeader> resultList=new ArrayList<BloodResultEntryHeader>();
		Map<String,Object> map=new HashMap<String,Object>();
				Session session = (Session) getSession();
				Criteria crt=null;
				crt=session.createCriteria(BloodResultEntryHeader.class).createAlias("Hospital", "hospitalId")
						.add(Restrictions.eq("hospitalId.Id", hospitalId))
						.add(Restrictions.eq("CgStatus", "c").ignoreCase())
						//Commented by Arbind on 30-10-2017
						//.add(Restrictions.eq("SgStatus", "c").ignoreCase())
						.add(Restrictions.eq("ResultEntryValidation", "p").ignoreCase());
				resultList=crt.list();
				map.put("resultList", resultList);
				
		return map;
	}


	
	@Override
	public Map<String, Object> resultEntryValidationJsp(int resultValidateId,int hospitalId) {
		List<BloodResultEntryHeader> resultList=new ArrayList<BloodResultEntryHeader>();
		
		List<BloodResultEntryDetails> investigationList=new ArrayList<BloodResultEntryDetails>();
		
		Map<String,Object> map=new HashMap<String,Object>();
				Session session = (Session) getSession();
				Criteria crt=null;
				crt=session.createCriteria(BloodResultEntryHeader.class).createAlias("Hospital", "hospital")
						.add(Restrictions.eq("hospital.Id", hospitalId))
						.add(Restrictions.eq("Id", resultValidateId));
				resultList=crt.list();
				
				crt=session.createCriteria(BloodResultEntryDetails.class).createAlias("Header", "Header")
						.createAlias("Header.Hospital", "hospital")
						.add(Restrictions.eq("hospital.Id", hospitalId))
						.add(Restrictions.eq("Header.Id", resultValidateId));
				investigationList=crt.list();
				
				map.put("resultList", resultList);
				map.put("investigationList", investigationList);
				
		return map;
		
	}

	@Override
	public Map<String, Object> showBloodStockRegisterjsp() {
		 Session session = (Session) getSession();
         Map<String, Object> map = new HashMap<String, Object>();
         List<BloodMasComponent> bldMasCompList = new ArrayList<BloodMasComponent>();

         try {
               bldMasCompList = session.createCriteria(BloodMasComponent.class).add(Restrictions.eq("Status", "y")).list();
            
         } catch (HibernateException e) {
               e.printStackTrace();
         }
         map.put("bldMasCompList", bldMasCompList);
         return map;

	}

	
	@Override
	public Map<String, Object> populateComponentdetails(int componentId) {
		 Session session = (Session) getSession();
         Map<String, Object> map = new HashMap<String, Object>();
         List<BloodMasComponent> bldMasCompList = new ArrayList<BloodMasComponent>();
         bldMasCompList = session.createCriteria(BloodMasComponent.class).add(Restrictions.eq("Id", componentId))
        		 .add(Restrictions.eq("Status", "y")).list();
         map.put("bldMasCompList", bldMasCompList);
		return map;
	}

	

	@Override
	public int populateAvailableBlood(int bloodBankId, int comoponentId) {
		 Session session = (Session) getSession();
		 List<BloodStockDetail> bsdList=new ArrayList<BloodStockDetail>();
		 int bloodStockunit=0;
		 Criteria crt=null;
		 crt=session.createCriteria(BloodStockDetail.class).createAlias("StockMain","StockMain")
				 .add(Restrictions.eq("StockMain.Hospital.Id", bloodBankId))
				 .createAlias("Component", "Component").add(Restrictions.eq("Component.Id", comoponentId));
		 bsdList=crt.list();
		
		 if(null !=bsdList && bsdList.size()>0){
			 for(BloodStockDetail bsd:bsdList){
				 bloodStockunit=bloodStockunit+1;
				/* bloodStock=bsd.getQty(); 
				 System.out.println("bloodStock "+bloodStock);*/
			 }
			
		 }
		return bloodStockunit;
	}

	
	@Override
	public Map<String, Object> showPendingSampleValidationJsp(int bloodBankId) {
		Map<String, Object> map=new HashMap<String, Object>();
		 Session session = (Session) getSession();
		 List<BloodRequestEntryHeader> requestheaderList=new ArrayList<BloodRequestEntryHeader>();
		 
		
		
		/* List<BloodRequestEntryDetail> requesDetailList=new ArrayList<BloodRequestEntryDetail>();*/
		 Criteria crt=null;
		 crt=session.createCriteria(BloodRequestEntryHeader.class).createAlias("Hospital", "hospital")
				 //Changed by Arbind on 06-11-2017
				 //.add(Restrictions.eq("hospital.Id",bloodBankId ))
				 .add(Restrictions.eq("SampleCollectionStatus", "p").ignoreCase())
				 .add(Restrictions.eq("RequestStatus", "p").ignoreCase());
		 requestheaderList=crt.list();
		 
		 
		
		 map.put("requestheaderList", requestheaderList);
		
		 
		return map;
	}


	@Override
	public Map<String, Object> bloodtRequestValidationJsp(
			int bloodRequestHeaderId,int hospitalId) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		 Session session = (Session) getSession();
		 List<BloodRequestEntryHeader> requestheaderList=new ArrayList<BloodRequestEntryHeader>();
		 List<BloodRequestEntryDetail> requestdetailList=new ArrayList<BloodRequestEntryDetail>();
		 
		 Criteria crt=null;
		 /*crt=session.createCriteria(BloodRequestEntryHeader.class)
				 .createAlias("Hospital", "hosp")
				
				  .add(Restrictions.eq("hosp.Id", hospitalId))
				 .add(Restrictions.eq("RequestStatus", "p").ignoreCase());
		 requestheaderList=crt.list();*/
		 
		 crt=session.createCriteria(BloodRequestEntryDetail.class).createAlias("Request", "Request")
				 .createAlias("Request.Hospital", "hosp")
				 //Changed by Arbind on 06-11-2017
				 //.add(Restrictions.eq("hosp.Id", hospitalId))
				 .add(Restrictions.eq("Request.Id", bloodRequestHeaderId));
		 requestdetailList=crt.list();
		
		 List<MasBloodGroup> bloodGroupList= new ArrayList<MasBloodGroup>();
		 crt=session.createCriteria(MasBloodGroup.class)
				 .add(Restrictions.eq("Status", "y").ignoreCase());
		 bloodGroupList=crt.list();
		 
		 DgMasCollection conatiner = new DgMasCollection();
		 crt = session.createCriteria(DgMasCollection.class)
				 .add(Restrictions.eq("CollectionName", "Plain Vaccutainer").ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase());
		 
		 if (crt.list().size() > 0) {
			 conatiner= (DgMasCollection) crt.list().get(0);
			 map.put("conatiner", conatiner);
			}
		
		 map.put("bloodGroupList", bloodGroupList);
		 map.put("requestdetailList", requestdetailList);
		 //map.put("requestheaderList", requestheaderList);
		return map;
	}

	

	@Override
	public boolean validatePatientBloodRequest(Map<String, Object> dataMap) {
		 Session session = (Session) getSession();
		 DgMasCollection dgmasCollection=new DgMasCollection();
		 
		 boolean status=false;
		 Transaction tnx=null;
		 Criteria crt=null;
		 
		 int bloodrequestHeaderId=0;
		 String validateStatus="";
		 String validationTime="";
		 int validatedBy=0;
		 int validatebloodGroupId=0;
		 int containerId=0;
		 if(null !=dataMap.get("containerId")){
			 containerId=(Integer)dataMap.get("containerId");
		 }
		if(containerId>0){
			dgmasCollection.setId(containerId);
		}
		 
		 if(null !=dataMap.get("bloodrequestHeaderId")){
			 bloodrequestHeaderId=(Integer)dataMap.get("bloodrequestHeaderId");
		 }
		
		 if(null !=dataMap.get("validateStatus")){
			 validateStatus=(String)dataMap.get("validateStatus");
		 }
		 
		 if(null !=dataMap.get("validationTime")){
			 validationTime=(String)dataMap.get("validationTime");
		 }
		 Users  user=new Users();
		 if(null !=dataMap.get("validatedBy")){
			 validatedBy=(Integer)dataMap.get("validatedBy");
		 }
		 user.setId(validatedBy);
		 
		 if(null !=dataMap.get("validatebloodGroupId")){
			 validatebloodGroupId=(Integer)dataMap.get("validatebloodGroupId");
		 }
		 MasBloodGroup  bloodGroup=new MasBloodGroup();
		 bloodGroup.setId(validatebloodGroupId);
		 
		 
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setCheckWriteOperations(false);
			hbt.setFlushModeName("FLUSH_AUTO");
			try{
				
				hbt.setCheckWriteOperations(false);
				
				// BloodRequestEntryHeader bldrequestEntryHeader=
						 BloodRequestEntryDetail bldrequestEntryDetail=(BloodRequestEntryDetail) session.createCriteria(BloodRequestEntryDetail.class)
					.createAlias("Request", "request").add(Restrictions.eq("request.Id", bloodrequestHeaderId)).list().get(0);
						 
						 BloodRequestEntryHeader bldrequestEntryHeader=bldrequestEntryDetail.getRequest();
						 //(BloodRequestEntryHeader) session.load(BloodRequestEntryHeader.class,bloodrequestHeaderId);
				if(null !=validateStatus && !validateStatus.equals("") && validateStatus.equalsIgnoreCase("y")){
					bldrequestEntryHeader.setSampleCollectionStatus("V");
				}
				else{
					bldrequestEntryHeader.setSampleCollectionStatus("R");
				}
				bldrequestEntryHeader.setValidatedBloodGroup(bloodGroup);
				bldrequestEntryHeader.setSampleValidatedBy(user);
				bldrequestEntryHeader.setSampleValidationDate(new Date());
				bldrequestEntryHeader.setSampleValidationTim(validationTime);
				if(containerId>0){
					bldrequestEntryHeader.setContainer(dgmasCollection);

				}
				hbt.update(bldrequestEntryDetail);
				hbt.update(bldrequestEntryHeader);
				status=true;
				
			
				session.flush();
			}
			catch(Exception e){
				
				e.printStackTrace();
			}
		return status;
	}

	
	@Override
	public Map<String, Object> populateBloodBags(int bloodGroupId,int hospitalId) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session) getSession();
		List<BloodStockMain> bloodstockmainList=new ArrayList<BloodStockMain>();
		List<BloodStockDetail> bloodstockdetailList=new ArrayList<BloodStockDetail>();
		Criteria crt=null;
		
		crt=session.createCriteria(BloodStockMain.class).createAlias("Hospital","hospital")
				.createAlias("BloodGroup","BloodGroup")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("BloodGroup.Id", bloodGroupId));
		
		bloodstockmainList=crt.list();
		
		List<Integer> stockmainList=new ArrayList<Integer>();
		int bloodstockmainId=0;
		if(null !=bloodstockmainList && bloodstockmainList.size()>0){
			for(BloodStockMain bsm:bloodstockmainList){
				bloodstockmainId=bsm.getId();
				
				
				stockmainList.add(bloodstockmainId);
			}
			
			crt=session.createCriteria(BloodStockDetail.class).createAlias("StockMain","stockMain")
					.createAlias("stockMain.Hospital","hospital")
					
					.add(Restrictions.or(Restrictions.ne("BloodIssued", "c").ignoreCase(), Restrictions.isNull("BloodIssued")))
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.or(Restrictions.ne("BloodDiscard", "y").ignoreCase(), Restrictions.isNull("BloodDiscard")))
					.add(Restrictions.in("StockMain.Id", stockmainList));
			bloodstockdetailList=crt.list();
			
			
			
			map.put("bloodstockdetailList", bloodstockdetailList);
		}
		map.put("bloodstockmainList", bloodstockmainList);
		
		return map;
	}


	@Override
	public Map<String, Object> populateBloodBags(String BagNumber,int hospitalId ) {
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		 Session session1=(Session) getSession();
		
		List<BloodStockDetail> bloodstockdetailList=new ArrayList<BloodStockDetail>();
		Criteria crt=null;
		String component="";
		if(null !=BagNumber && !BagNumber.equals("")){
		crt=session1.createCriteria(BloodStockDetail.class)
				.createAlias("StockMain","stockMain")
				.createAlias("stockMain.Hospital","hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.or(Restrictions.ne("BloodIssued", "c").ignoreCase(), Restrictions.isNull("BloodIssued")))
				.add(Restrictions.eq("BloodBagNo", BagNumber))
				.add(Restrictions.or(Restrictions.ne("BloodDiscard", "y").ignoreCase(), Restrictions.isNull("BloodDiscard")) );
		bloodstockdetailList=crt.list();
		
		if(null !=bloodstockdetailList && bloodstockdetailList.size()>0)
		{
		for (BloodStockDetail bsd : bloodstockdetailList) {
			
			component=bsd.getComponent().getComponentName();
			
		}
			
		}
		}
		
		map.put("bloodstockdetailList", bloodstockdetailList);
		map.put("componentName", component);
		
		return map;
	}

	

	@Override
	public Map<String, Object> submitCrossMatching(Box box) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		boolean saveResult=false;
		
		
		List<String> quantityList=box.getArrayList("quantt");
		List<String> bagsList=box.getArrayList("bagnumberI");
		List<String> bldGroupList=box.getArrayList("bldgrp");
		List<String> investigationList=box.getArrayList("crossInvestName");
		List<String> investigationResult=box.getArrayList("investigationNameResult");
		
		int bloodRequestEntryHeaderId=box.getInt("bloodRequestEntryHeaderId");
		BloodStockDetail stockDetail=null;
		
		String crossMatchDate=box.get("currentDate");
		String crossMatchTime=box.get("time");
		int userId=box.getInt("userId");
		Users user=new Users();
		user.setId(userId);
		
	int hospitalId=box.getInt("hospitalId");
	
		Session session=(Session) getSession();
		
		 Transaction tnx=null;
		 int stockId=0;
		try{
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		tnx=session.beginTransaction();
		hbt.setCheckWriteOperations(false);
		BldCrossmatchingHeader crossMatchHeader=new BldCrossmatchingHeader();
		BloodRequestEntryHeader breh=null;
		 breh	=(BloodRequestEntryHeader) session.createCriteria(BloodRequestEntryHeader.class)
						.createAlias("BloodBank", "bloodBank")
						.add(Restrictions.eq("SampleCollectionStatus", "V").ignoreCase())
						.add(Restrictions.eq("CrossMatchStatus", "P").ignoreCase())
						.add(Restrictions.eq("BloodRequestStatus", "P").ignoreCase())
						.add(Restrictions.eq("Id", bloodRequestEntryHeaderId))
						.add(Restrictions.eq("bloodBank.Id", hospitalId)).list().get(0);
			int requestedBloodBankId=breh.getBloodBank().getId();			
				breh.setCrossMatchStatus("C");
		//breh.setId(bloodRequestEntryHeaderId);
		crossMatchHeader.setCrossMatchTime(crossMatchTime);
		crossMatchHeader.setCrossMatchDate(new Date());
		crossMatchHeader.setBldRequest(breh); 
		crossMatchHeader.setCrossMatchStatus("C");
		crossMatchHeader.setBloodIssueStatus("P");
		crossMatchHeader.setCrossMatchBy(user);
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		crossMatchHeader.setBldBankId(hospital);
		MasHospital requestedHospital=new MasHospital();
		requestedHospital.setId(breh.getHospital().getId());
		crossMatchHeader.setBldRequestHospitalId(requestedHospital);
		
		hbt.saveOrUpdate(breh);  
		hbt.save(crossMatchHeader);
		
		if(null !=bagsList && bagsList.size()>0){
			
			for(int j=0;j<bagsList.size();j++)
			{
			
				BldCrossmatchBagDetail bldCrossBags=new BldCrossmatchBagDetail();
				
				bldCrossBags.setBldCrossmatchingHeader(crossMatchHeader);
				
				bldCrossBags.setBagNo(bagsList.get(j));
				
				stockId=getStockIdByBagNo(bagsList.get(j));
				if(stockId>0){
					 stockDetail=new BloodStockDetail();
					 stockDetail.setId(stockId);
				}
				
				if(null !=quantityList && quantityList.size()>0 && null !=quantityList.get(j)){
					
				bldCrossBags.setQuantity(new BigDecimal(quantityList.get(j)) );
				
				}
				hbt.save(bldCrossBags);
			if(null !=investigationList && investigationList.size()>0){
				for(int i=0;i<investigationList.size();i++){
					DgMasInvestigation masInvestigation=new DgMasInvestigation();
					masInvestigation.setId(Integer.parseInt(investigationList.get(i)));
					
					BldCrossmatchDetail bcd=new BldCrossmatchDetail();
					bcd.setInvestigation(masInvestigation);
					bcd.setInvestigationResult(investigationResult.get(i));
					bcd.setBldCrossmatchingHeader(crossMatchHeader);
					bcd.setBagNo(bagsList.get(j));
					bcd.setBldCrossBag(bldCrossBags);
					bcd.setStockDetail(stockDetail);
					hbt.save(bcd);
				}
				
			}
			
			}
		}
		
		tnx.commit();
		session.flush();
		saveResult=true;
	
		}
		catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		map.put("saveResult", saveResult);
		return map;
	}

	public int getStockIdByBagNo(String bagNo){
		
		List<BloodStockDetail> bldStockDetail=new ArrayList<BloodStockDetail>();
		int stockId=0;
		Session session=(Session) getSession();
		Criteria crt=null;
	crt=session.createCriteria(BloodStockDetail.class).add(Restrictions.eq("BloodBagNo", bagNo));
	bldStockDetail=crt.list();
	if(null !=bldStockDetail){
	for(BloodStockDetail stockDetail:bldStockDetail){
		stockId=stockDetail.getId();
		
	}
	}
		return stockId;
		
	}
	

	@Override
	public Map<String, Object> getPendingForBloodIssue(int bloodBankId) {
		
		List<BldCrossmatchingHeader> bldCrossMatchingheaderList=new ArrayList<BldCrossmatchingHeader>();
		
		//List<BloodRequestEntryDetail> bldRequstEnrtyDetailList=new ArrayList<BloodRequestEntryDetail>();
		
		Map<String,Object> map=new HashMap<String,Object>();
		Session session=(Session) getSession();
		Criteria crt=null;
		crt=session.createCriteria(BldCrossmatchingHeader.class).createAlias("BldBankId", "bldBankId")
				.add(Restrictions.eq("bldBankId.Id", bloodBankId))
				//.add(Restrictions.eq("CrossMatchDate",new Date()))
				.add(Restrictions.eq("CrossMatchStatus", "c").ignoreCase())
				.add(Restrictions.eq("BloodIssueStatus", "P").ignoreCase());
		bldCrossMatchingheaderList=crt.list();
		
		
		
		/*int bldRequestHeaderId=0;
		if(null !=bldCrossMatchingheaderList && bldCrossMatchingheaderList.size()>0){
			for(BldCrossmatchingHeader crossHeader:bldCrossMatchingheaderList){
				bldRequestHeaderId=crossHeader.getBldRequest().getId();
			}
			
			if(bldRequestHeaderId>0){
				
				crt=session.createCriteria(BloodRequestEntryDetail.class).createAlias("Request", "request")
						.createAlias("request.BloodBank", "bloodBank")
						.add(Restrictions.eq("request.Id", bldRequestHeaderId))
						.add(Restrictions.eq("bloodBank.Id", bloodBankId))
						.add(Restrictions.eq("request.BloodRequestStatus", "P").ignoreCase());
				bldRequstEnrtyDetailList=crt.list();
				
			}
		}*/
		
		
	map.put("bldCrossMatchingheaderList", bldCrossMatchingheaderList);
	//map.put("bldRequstEnrtyDetailList", bldRequstEnrtyDetailList);
		
		return map;
	}

	public Date calculateBagExpiryDate(int componentLifeSpan){
		
		Calendar now = Calendar.getInstance();
		 now.add(Calendar.DATE, componentLifeSpan);
		 
		// System.out.println(now.getTime());
		
		Date Expirydate=now.getTime();
		return Expirydate;
		

	}

	
	@Override
	public Map<String, Object> populateComponentExpirydetails(
			Map<String, Object> datamap) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		Session session=(Session) getSession();
		int componentId=(Integer)datamap.get("componentId");
		BloodMasComponent component=(BloodMasComponent) session.load(BloodMasComponent.class, componentId);
		int lifeSpan=component.getLifeSpan();
		Date expixyDate=calculateBagExpiryDate(lifeSpan);
		map.put("expixyDate", expixyDate);
		
		return map;
	}

	

	@Override
	public Map<String, Object> showIndentBloodBankJsp() {
		
		Session session=(Session) getSession();
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		List<MasHospital> bloodBankList=new ArrayList<MasHospital>();
		List<MasBloodGroup> bloodGroupList=new ArrayList<MasBloodGroup>();
		
		Criteria crt=null;
		
		crt=session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status","y").ignoreCase());
		bloodGroupList=crt.list();
		
		crt=session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.eq("BbAvailable","y").ignoreCase());
		bloodBankList=crt.list();
		
		map.put("bloodGroupList", bloodGroupList);
		map.put("bloodBankList", bloodBankList);
		return map;
	}

	
	@Override
	public Map<String, Object> submitBloodIndentRequest(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		BloodRequestEntryHeader bldRequestEntryheader=new BloodRequestEntryHeader();
		
		String indentOrderNo=box.get("indentOrderNo");
		String indentdate=box.get("bloodBankIndentDate");
		int inc=box.getInt("hiddenValue");
		
		boolean status=false;
		int bloodBankId=box.getInt("indentToBloodBankName");
		MasHospital bloodBank=new MasHospital();
		bloodBank.setId(bloodBankId);
		
		int bloodComponentId=0;
		
		 Vector bloodGroup=null;
		 Vector componentNameId=null;
		 Vector requestQuantity=null;
		 Vector requestOnDate=null;
		 
		 bloodGroup=new Vector();
		 componentNameId=new Vector();
		 requestQuantity=new Vector();
		 requestOnDate=new Vector();
		 
		 for(int i=1;i<=inc;i++){
			 bloodGroup.add(box.getInt("bloodGroup"+i));
			 bloodComponentId=getComponentId(box.get("bloodComponentName"+i));
			 componentNameId.add(bloodComponentId);
			 requestQuantity.add(Integer.parseInt(box.get("quantity"+i)));
			 requestOnDate.add(box.get("requestOnDate"+i));
		 }
		 bldRequestEntryheader.setOrderDate(HMSUtil.convertStringTypeDateToDateType(indentdate));
		 bldRequestEntryheader.setHospital(bloodBank);
		 bldRequestEntryheader.setRequestType("I");
		 bldRequestEntryheader.setRequestStatus("P");
		 bldRequestEntryheader.setOrderNo(indentOrderNo);
		
		 Session session=(Session) getSession();
			Transaction tnx=null;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setCheckWriteOperations(false);
			hbt.setFlushModeName("FLUSH_AUTO");
			try{
				tnx=session.beginTransaction();
				
				hbt.save(bldRequestEntryheader);
				int bldGroupId=0;
				int compId=0;
				int qunty=0;
				
				 for(int i=0;i<inc;i++){
					 BloodRequestEntryDetail bloodIndentReusetdetail=new BloodRequestEntryDetail();
					 bldGroupId= (Integer)bloodGroup.get(i);
					 
					 MasBloodGroup bldGroup=new MasBloodGroup();
					 bldGroup.setId(bldGroupId);
					 
					 compId=(Integer)componentNameId.get(i);
					 BloodMasComponent component=new BloodMasComponent();
					 component.setId(compId);
					 
					 qunty=(Integer)requestQuantity.get(i);
					 
					 bloodIndentReusetdetail.setBloodGroup(bldGroup);
					 bloodIndentReusetdetail.setComponent(component);
					 bloodIndentReusetdetail.setQty(qunty);
					 bloodIndentReusetdetail.setReqDate(HMSUtil.convertStringTypeDateToDateType((String)requestOnDate.get(i)) );
					 bloodIndentReusetdetail.setRequest(bldRequestEntryheader);
					
					 hbt.save(bloodIndentReusetdetail); 
				 }
				 tnx.commit();
				session.flush();
				
				status=true;
				
			}catch(Exception e){
				tnx.rollback();
				e.printStackTrace();
				
			}
			map.put("status", status);
		 
		return map;
	}
	
	public int getComponentId(String componentName){
		System.out.println("componentName "+componentName);
		
		 String[] parts = componentName.split("\\[");
		 
		  
		  String part2 = parts[1];
		 
		  
		  String[] parts1 = part2.split("\\]");
		  String part11 = parts1[0];
		  System.out.println(part11);
		  return Integer.parseInt(part11);
		  
	}

	

	@Override
	public Map<String, Object> showPendingIndentListJsp(int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> identRequestHeaderList=new ArrayList<BloodRequestEntryHeader>();
		
		Session session=(Session) getSession();
		Criteria crt=null;
		crt=session.createCriteria(BloodRequestEntryHeader.class)
				.createAlias("Hospital", "Hospital")
				.add(Restrictions.eq("RequestType", "I").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId));
		
		identRequestHeaderList=crt.list();
		map.put("identRequestHeaderList", identRequestHeaderList);
		
		return map;
	}

	@Override
	public Map<String, Object> showIssueOfIndentJsp(int requestHeaderId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryDetail> bldRequestEntryDetailsList=new ArrayList<BloodRequestEntryDetail>();
		Session session=(Session) getSession();
		Criteria crt=null;
		
		crt=session.createCriteria(BloodRequestEntryDetail.class)
				.createAlias("Request", "Request")
				.add(Restrictions.eq("Request.Id", requestHeaderId));
		
		bldRequestEntryDetailsList=crt.list();
		map.put("bldRequestEntryDetailsList", bldRequestEntryDetailsList);
		
		return map;
	}

	

	@Override
	public Map<String, Object> populateBagDetalForIndent(Map<String, Object> map) {
		Map<String, Object> datamap = new HashMap<String, Object>();
		
		int componentId=0;
		int bloodGroupId=0;
		
		componentId=(Integer)map.get("componentId");
		bloodGroupId=(Integer)map.get("bloodGroupId");
		
		List<BloodStockDetail> bldStockDetailsList=new ArrayList<BloodStockDetail>();
		Session session=(Session) getSession();
		Criteria crt=null;
		
		crt=session.createCriteria(BloodStockDetail.class)
				.createAlias("StockMain", "StockMain")
				.createAlias("Component", "Component")
				.add(Restrictions.eq("Component.Id", componentId))
				.add(Restrictions.eq("StockMain.BloodGroup.Id", bloodGroupId));
		
		bldStockDetailsList=crt.list();
		datamap.put("bldStockDetailsList", bldStockDetailsList);
		
		return datamap;
	}

	
	@Override
	public Map<String, Object> saveIssueofIndent(Box box) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		boolean status=false;
		
		String bagNum=box.get("bagNum");
		/*int issueQuantity=box.getInt("issueQuantity");*/
		String ExpiryDate=box.get("ExpiryDate");
		
		int incValue=box.getInt("incValue");
		int bldRequestEntryHeaderId=box.getInt("bldRequestEntryHeaderId");
		BloodRequestEntryHeader bldRequestEntryHeader=new BloodRequestEntryHeader();
		bldRequestEntryHeader.setId(bldRequestEntryHeaderId);
		
		int hospitalId=box.getInt("hospitalId");
		BloodIndentIssueM bldIndentIssue=new BloodIndentIssueM();
		
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		
		Date currentdate=new Date();
		
		Date indentDate=HMSUtil.convertStringTypeDateToDateType(box.get("indentDateId"));
		
		bldIndentIssue.setLastChgDate(currentdate);
		bldIndentIssue.setHospital(hospital);
		bldIndentIssue.setRequestHeader(bldRequestEntryHeader);
		bldIndentIssue.setIndentIssueDate(indentDate);
		bldIndentIssue.setAckStatus("P");
		/*Vector bloodGroup=null;
		Vector component=null;
		Vector issueQuantity=null;
		
		bloodGroup=new Vector();
		component=new Vector();
		issueQuantity=new Vector();*/
		
		/*for(int i=1;i<=incValue;i++){
			bloodGroup.add(box.getInt("bloodGroup"+i));
			component.add(box.getInt("componentName"+i));
			issueQuantity.add(box.getInt("requiredQuantity"+i));
		}
		*/

		 Session session=(Session) getSession();
			Transaction tnx=null;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setCheckWriteOperations(false);
			hbt.setFlushModeName("FLUSH_AUTO");
			try{
				
				tnx=session.beginTransaction();
				hbt.save(bldIndentIssue);
				
				int bloodGroupId=0;
				int componentId=0;
				int quantity=0;
				
				/*for(int i=1;i<=incValue;i++){*/
					
					BloodIndentIssueT  bldIndentIssueT=new BloodIndentIssueT();
					
					bloodGroupId=box.getInt("hiddenBloodGroupName") ;
					MasBloodGroup masbloodGroup=new MasBloodGroup();
					masbloodGroup.setId(bloodGroupId);
					
					bldIndentIssueT.setBloodGroup(masbloodGroup);
					
					componentId=box.getInt("hiddenComponentName");
					BloodMasComponent  bldMasComponent=new BloodMasComponent();
					bldMasComponent.setId(componentId);
					
					bldIndentIssueT.setBloodComponent(bldMasComponent);
					
					quantity=box.getInt("issueQuantity");
					
					bldIndentIssueT.setIssuedQuantity(new BigDecimal(quantity));
					
					bldIndentIssueT.setIndentM(bldIndentIssue);
					bldIndentIssueT.setBagNo(bagNum);
					hbt.save(bldIndentIssueT);
					
					
				/*}*/
				tnx.commit();
				session.flush();
				status=true;
				
			}
			catch(Exception e){
				tnx.rollback();
				e.printStackTrace();
				
				
			}
		
		map.put("status", status);
		
		
		return map;
	}


	@Override
	public Map<String, Object> showPendingAcknowledgmentListJsp(int hospitalId) {
		
		Session session=(Session) getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<BloodIndentIssueM>  bldIndentIssueMList=new ArrayList<BloodIndentIssueM>();
		Criteria crt=null;
		
		crt=session.createCriteria(BloodIndentIssueM.class).add(Restrictions.eq("AckStatus", "P").ignoreCase());
		bldIndentIssueMList=crt.list();
		
		map.put("bldIndentIssueMList", bldIndentIssueMList);
		
		return map;
	}

	@Override
	public Map<String, Object> showbldIssueAcknowledgmentListJsp(int hospitalId) {
		
		Session session=(Session) getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<BloodIssueDetail>  bldIssueAckList=new ArrayList<BloodIssueDetail>();
		Criteria crt=null;
		
		crt=session.createCriteria(BloodIssueDetail.class).add(Restrictions.eq("BldAckPending", "P").ignoreCase());
		bldIssueAckList=crt.list();
		System.out.println();
		map.put("bldIssueAckList", bldIssueAckList);
		
		return map;
	}


	@Override
	public Map<String, Object> populateIssueIndentBagDetal(int hospitalId,
			int indentId) {
		
		Session session=(Session) getSession();
		Map<String,Object> map=new HashMap<String,Object>();
	//	List<BloodIndentIssueT>  bldIndentIssueTList=new ArrayList<BloodIndentIssueT>();
		List<BloodIssueDetail>  bldIssueAckList=new ArrayList<BloodIssueDetail>();
		Criteria crt=null;
		
		/*crt=session.createCriteria(BloodIndentIssueT.class)
				.createAlias("IndentM","IndentM")
				.add(Restrictions.eq("IndentM.Id",indentId ))
				.add(Restrictions.eq("IndentM.Hospital.Id",hospitalId ));
		bldIndentIssueTList=crt.list();*/
		crt=session.createCriteria(BloodIssueDetail.class).add(Restrictions.eq("Id", indentId));
		bldIssueAckList=crt.list();
		map.put("bldIssueAckList", bldIssueAckList);
		
		
		//map.put("bldIssueAckList",bldIssueAckList);
		
		return map;
	}

	
	@Override
	public Map<String, Object> populateIssueQuantityDetails(int issueIndentMId,
			int hospitalId) {
		
		Session session=(Session) getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		
		List<BloodIndentIssueM>  bldIndentIssueMList=new ArrayList<BloodIndentIssueM>();
		
		BloodIndentIssueT  bldIndentIssueT=null;
		
		Criteria crt=null;
		crt=session.createCriteria(BloodIndentIssueM.class).createAlias("Hospital", "Hospital")
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Id", issueIndentMId));
		
		bldIndentIssueMList=crt.list();
		
		BigDecimal issuedQuantity=null;
		int bldRequestEntryTId=0;
		int quantity = 0;
		
		crt=session.createCriteria(BloodIndentIssueT.class).createAlias("IndentM", "IndentM")
				.add(Restrictions.eq("IndentM.Id", issueIndentMId));
		if(crt != null && crt.list() != null && crt.list().size() > 0) {
			bldIndentIssueT=(BloodIndentIssueT) crt.list().get(0);
			issuedQuantity=bldIndentIssueT.getIssuedQuantity();
		}
		
			System.out.println("issuedQuantity "+issuedQuantity);
			
		
		
		BloodRequestEntryDetail bloodRequestDetails=null;
		
		
		for(BloodIndentIssueM bldIndentM:bldIndentIssueMList){
			bldRequestEntryTId=bldIndentM.getRequestHeader().getId();
		}
		
		crt=session.createCriteria(BloodRequestEntryDetail.class)
				.createAlias("Request", "Request")
				.add(Restrictions.eq("Request.Id", bldRequestEntryTId));
		
		if(crt != null && crt.list() != null && crt.list().size() > 0) {
			bloodRequestDetails=(BloodRequestEntryDetail) crt.list().get(0);
			quantity = bloodRequestDetails.getQty();
		}

		//map.put("bloodRequestDetails", bloodRequestDetails);
		map.put("quantity", quantity);
		map.put("issuedQuantity", issuedQuantity);
		return map;
	}

	

	@Override
	public Map<String, Object> saveAcknownledgeData(int hospitalId, int indentId) {
		System.out.println("indentId "+indentId);
		
		Session session=(Session) getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		BloodIssueDetail bldIndentIssueM=null;
		boolean status=false;
		Transaction tnx=null;
		try{
			tnx=session.beginTransaction();
		
		
		bldIndentIssueM=(BloodIssueDetail) session.load(BloodIssueDetail.class,indentId);
		bldIndentIssueM.setBldAckPending("A");
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(bldIndentIssueM);
		status=true;
		tnx.commit();
		session.flush();
		}
		catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
		}
		map.put("status", status);
		
		
		return map;
	}

	

	@Override
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();

		map.put("conn", con);
		//
		return map;
	}

	
	

	@Override
	public Map<String, Object> editBloodBank(Box box) {
		
		boolean saveStatus=false;
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		int bloodBankUniqueId=box.getInt("bloodBankUniqueId");
		String contactNum=box.get("contactNum");
		int districtid=box.getInt("districtname");
		int talukid=box.getInt("taluk");
		String street=box.get("street");
		String landMark=box.get("landMark");
		String status=box.get("status");
		String datefrom=box.get("datefrom");
		String dateTo=box.get("dateTo");
		
		String statrtTime=box.get("statrtTime");
		String endTime=box.get("endTime");
		
		
		String bloodBankType="";
		String Sun=box.get("Sun");
		String Mon=box.get("Mon");
		String Tue=box.get("Tue");
		String Wed=box.get("Wed");
		String Thu=box.get("Thu");
		String Fri=box.get("Fri");
		String Sat=box.get("Sat");
		
		String weeklyOff="";
		if(Sun !=null && !Sun.isEmpty())
		{
			weeklyOff=weeklyOff+Sun+",";
		}
		if(Mon !=null && !Mon.isEmpty())
		{
			weeklyOff=weeklyOff+Mon+",";
		}
		if(Tue !=null && !Tue.isEmpty())
		{
			weeklyOff=weeklyOff+Tue+",";
		}
		if(Wed !=null && !Wed.isEmpty())
		{
			weeklyOff=weeklyOff+Wed+",";
		}
		if(Thu !=null && !Thu.isEmpty())
		{
			weeklyOff=weeklyOff+Thu+",";
		}
		if(Fri !=null && !Fri.isEmpty())
		{
			weeklyOff=weeklyOff+Fri+",";
		}
		if(Sat !=null && !Sat.isEmpty())
		{
			weeklyOff=weeklyOff+Sat+",";
		}
		
		
		String interExt=box.get("banktype");
		
		if(interExt.equalsIgnoreCase("gover")){
			bloodBankType="y";
		}else{
			bloodBankType="n";
		}
		
		MasDistrict masDistrict=new MasDistrict();
		masDistrict.setId(districtid);
		
		MasTaluk masTaluk=new MasTaluk();
		
		
		MasHospital bloodBank=new MasHospital();
		
		Session session=(Session) getSession();
		Transaction tnx=null;
		try{
		 tnx=session.beginTransaction();
		
		bloodBank=(MasHospital) session.load(MasHospital.class, bloodBankUniqueId);
		//bloodBank.setHospitalCode(registrationNum);
		//bloodBank.setBbRegistrationNumber(registrationNum);
		bloodBank.setBbWeeklyOff(weeklyOff);
	//	bloodBank.setHospitalName(bloodBankName);
		bloodBank.setContactNumber(contactNum);
		bloodBank.setDistrict(masDistrict);
		
		if(talukid>0){
			masTaluk.setId(talukid);
		bloodBank.setTaluk(masTaluk);
		}
		bloodBank.setAdd2Street(street);
		bloodBank.setOpeningTime(statrtTime);
		bloodBank.setClosingTime(endTime);
	//	bloodBank.setHospitalType(hospType);
		bloodBank.setBbAvailable(bloodBankType);
		//bloodBank.setStatus("y");
		bloodBank.setValidFrom(HMSUtil.convertStringTypeDateToDateType(datefrom));
		bloodBank.setValidTo(HMSUtil.convertStringTypeDateToDateType(dateTo));
		
		session.update(bloodBank);
		tnx.commit();session.flush();
		saveStatus=true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			tnx.rollback();
		}
		map.put("saveStatus",saveStatus);
		
		return map;
	}
	
	@Override
	public Map<String, Object> populateDistrictByStateId(int stateId) {
		List<MasDistrict> districtList=new ArrayList<MasDistrict>();
		Map<String,Object> map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		Criteria crt=null;
		crt=session.createCriteria(MasDistrict.class).createAlias("State", "state")
				.add(Restrictions.eq("state.Id", stateId));
		
		districtList=crt.list();
		
		map.put("districtList", districtList);
		// TODO Auto-generated method stub
		return map;
	}
	
	public Map<String,Object> checkBloodBankAvailability(int hospitalId) {
		
		boolean status=false;
		List<MasHospital> hospList=new ArrayList<MasHospital>();
		Map<String,Object> map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		Criteria crt=null;
		String hospitalCode="";
		System.out.println("hospitalId "+hospitalId);
		
		crt=session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Id", hospitalId)).add(Restrictions.eq("BbAvailable", "y").ignoreCase());
		
		hospList=crt.list();
		if(null !=hospList && hospList.size()>0){
			status=true;
			for(MasHospital hosp:hospList){
				hospitalCode=hosp.getHospitalCode();
			}
		}
		map.put("status", status);
		map.put("hospitalCode", hospitalCode);
		//System.out.println("hospitalCode "+hospitalCode);
		return map;
	}
public boolean checkDuplicateRegistration(BloodDonationEntryHeader donationEntryHeader) {
		
		boolean status=false;
		String donorName="";
		String uhidNo="";
		
		Map<String,Object> map=new HashMap<String,Object>();
		List<BloodDonationEntryHeader> bDehList=new ArrayList<BloodDonationEntryHeader>();
		
		if(null !=donationEntryHeader){
			uhidNo=donationEntryHeader.getUhidNo();
			donorName=donationEntryHeader.getDonerName();
		}
		
		Session session=(Session)getSession();
		Criteria crt=null;
		String hospitalCode="";
		
		
		crt=session.createCriteria(BloodDonationEntryHeader.class)
				.add(Restrictions.eq("DonerName", donorName).ignoreCase())
				.add(Restrictions.eq("UhidNo", uhidNo));
		 
		bDehList=crt.list();
		if(null !=bDehList && bDehList.size()>0){
			status=true;
			
		}
		
		
		//System.out.println("hospitalCode "+hospitalCode);
		return status;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSearchPatientRecordsForVisitJsp(
			Map<String, Object> map) {
		Map<String, Object> getDataMap = new HashMap<String, Object>();
		List<Patient> searchDataList = new ArrayList<Patient>();
		List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		Map<Integer, Object> addressmap = new HashMap<Integer, Object>();
		List<MasScheme> schemeList=new ArrayList<MasScheme>();

		List<MasDepartment> nonClinicaldepartmentList = new ArrayList<MasDepartment>();
		
		List<MasSession> masSessionList = new ArrayList<MasSession>();
		boolean stauts = false;

		String hinNo = "";
		String fullName = "";
		String mobNo = "";

		
		Date dateOfBirth = null;
		
		int hospitalId = 0;
		int deptId = 0;
		int noOfPages = 0;
		int noOfRecords = 0;
		int recordsPerPage = 5;

		String FromAge = "";
		String toAge = "";

		int page = (Integer) map.get("page");

		Criteria crt = null;
		Session session = (Session) getSession();

		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");
		}
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		if (map.get("uhid") != null) {
			hinNo = (String) map.get("uhid");
		}
		if (map.get("fullName") != null) {
			fullName = (String) map.get("fullName");
		}
		if (map.get("mobno") != null) {
			mobNo = (String) map.get("mobno");
		}
		if (map.get("dateOfBirth") != null) {
			dateOfBirth = (Date) map.get("dateOfBirth");
		}
		if (map.get("FromAge") != null) {
			FromAge = (String) map.get("FromAge");
		}
		if (map.get("toAge") != null) {
			toAge = (String) map.get("toAge");
		}

		try {
			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("AuthorizerName")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			crt = session.createCriteria(Patient.class).add(Restrictions.eq("PatientStatus", "Out Patient"))
					;
			crt.setFirstResult(page - 1);
			crt.setMaxResults(recordsPerPage);

			Criteria crty = session.createCriteria(Patient.class).add(Restrictions.eq("PatientStatus", "Out Patient"));
			crty.setProjection(Projections.rowCount());

			if (hinNo != null && !hinNo.equals("") && !hinNo.equals("null")) {
				crt.add(Restrictions.eq("HinNo", hinNo));
				crty.add(Restrictions.eq("HinNo", hinNo));
				stauts = true;
				getDataMap.put("shinNo", hinNo);
			}

			if (fullName != null && !fullName.equals("")
					&& !fullName.equals("null")) {
				crt.add(Restrictions.like("PFirstName", fullName + "%")
						.ignoreCase());
				crty.add(Restrictions.like("PFirstName", fullName + "%")
						.ignoreCase());
				stauts = true;
				getDataMap.put("sfullName", fullName);
			}
			if (mobNo != null && !mobNo.equals("") && !mobNo.equals("null")) {
				crt.add(Restrictions.like("MobileNumber", mobNo + "%"));
				crty.add(Restrictions.like("MobileNumber", mobNo + "%"));
				stauts = true;
				getDataMap.put("smobNo", mobNo);
			}
			/*
			 * if(FromAge!=null && !FromAge.equals("") ){
			 * 
			 * crt.add(Restrictions.eq("Age", FromAge+" Years"));
			 * crty.add(Restrictions.eq("Age", FromAge+" Years")); stauts=true;
			 * getDataMap.put("smobNo", mobNo); }
			 */
			if (dateOfBirth != null && !dateOfBirth.equals("")
					&& !dateOfBirth.equals("null")) {
				crt.add(Restrictions.eq("DateOfBirth", dateOfBirth));
				crty.add(Restrictions.eq("DateOfBirth", dateOfBirth));
				stauts = true;
				getDataMap.put("sdateOfBirth", dateOfBirth);
			}
			if (stauts && crt.list().size() > 0) {
				searchDataList = crt.list();
				
				/*
				 * List<PatientAddress> addressList = new
				 * ArrayList<PatientAddress>();
				 */
				for (Patient patient : searchDataList) {
					int hinId = patient.getId();
					crt = session.createCriteria(PatientAddress.class)
							.createAlias("Hin", "hinId")
							.createAlias("AddressType", "AddressId");
					crt.add(Restrictions.eq("AddressId.Id", 1));
					crt.add(Restrictions.eq("hinId.Id", hinId));
					
					addressmap.put(hinId, crt.list());
				}
			}

			noOfRecords = (Integer) crty.uniqueResult();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			/*complaintList = session.createCriteria(MasComplaint.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y")).list();
*/
			/*departmentList = session.createCriteria(MasDepartment.class).createAlias("Hospital", "hospitalId")
					.add(Restrictions.eq("hospitalId.Id", hospitalId))
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.addOrder(Order.asc("DepartmentName")).list();
			*/
			/*departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();*/
			
		/*	
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType","DepartmentType")
					.add(Restrictions.eq("DepartmentType.Id",1))
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();*/
			
			
			
			/*nonClinicaldepartmentList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.createAlias("dep.DepartmentType","DepartmentType")
			.add(Restrictions.ne("DepartmentType.Id",1))
			.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
			.addOrder(Order.asc("dep.DepartmentName"))
			.list();
			*/

			/*String QueryForEmp = "select * from mas_employee where emp_category_id=1 and status='Y' and hospital_id='"
					+ hospitalId + "' and grade_id is not null";*/
			/*String QueryForEmp = "select * from mas_employee where emp_category_id=1 and status='Y' and hospital_id='"
					+ hospitalId + "'";
			
			doctorList = session.createSQLQuery(QueryForEmp).list();*/
			
			/*doctorList=session.createCriteria(MasEmployee.class).createAlias("Hospital", "Hospital").
					createAlias("EmployeeType", "EmployeeType").add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("EmployeeType.Id", 1)).list();
*/
			/*caseTypeList = session.createCriteria(MasCaseType.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y")).list();

			diagnosisList = session
					.createCriteria(MasDiagnosisConclusion.class)
					.addOrder(Order.asc("DiagnosisConclusionName"))
					.add(Restrictions.eq("Status", "Y")).list();*/
			/*chargeCodeList = session.createCriteria(MasChargeCode.class)
					.addOrder(Order.asc("ChargeCodeName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			*/
			/*masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
					.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			*/
			/*schemeList = session.createCriteria(MasScheme.class)
					.addOrder(Order.asc("SchemeName"))
					.add(Restrictions.eq("Status", "Y")).list();
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		sexList = session.createCriteria(MasAdministrativeSex.class)
				.addOrder(Order.asc("AdministrativeSexName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
		occupationList = session.createCriteria(MasOccupation.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		List<MasState> stateList = new ArrayList<MasState>();
		stateList = session.createCriteria(MasState.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<MasDistrict> districtList=new ArrayList<MasDistrict>();
		
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
       
        
        int stateId=Integer.parseInt(prop.getProperty("stateId"));
      

		districtList = session.createCriteria(MasDistrict.class)
				.addOrder(Order.asc("DistrictName"))
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		
		List<MasLsg> lsgList = new ArrayList<MasLsg>();
		lsgList = session.createCriteria(MasLsg.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<MasPostCode> postcodeList = new ArrayList<MasPostCode>();
		
		postcodeList = session.createCriteria(MasPostCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		getDataMap.put("bloodGroupList", bloodGroupList);
		getDataMap.put("postcodeList", postcodeList);
		getDataMap.put("lsgList", lsgList);
		getDataMap.put("districtList", districtList);
		getDataMap.put("stateList", stateList);
		getDataMap.put("occupationList", occupationList);
		getDataMap.put("sexList", sexList);
		getDataMap.put("schemeList", schemeList);
		getDataMap.put("complaintList", complaintList);
		getDataMap.put("departmentList", departmentList);
		getDataMap.put("doctorList", doctorList);
		getDataMap.put("caseTypeList", caseTypeList);
		getDataMap.put("diagnosisList", diagnosisList);
		getDataMap.put("searchDataList", searchDataList);
		getDataMap.put("chargeCodeList", chargeCodeList);
		getDataMap.put("authorizerList", authorizerList);

		getDataMap.put("noOfPages", noOfPages);
		getDataMap.put("currentPage", page);
		getDataMap.put("addressmap", addressmap);
		getDataMap.put("nonClinicaldepartmentList", nonClinicaldepartmentList);
		getDataMap.put("masSessionList", masSessionList);
		
		return getDataMap;
	}
	
	@Override
	public Map<String, Object> populateDonorRegistrationFrom(int deptId,
			int hospitalId, String hinNo,int page) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<Patient> searchDataList = new ArrayList<Patient>();
		List<PatientAddress> addressList = new ArrayList<PatientAddress>();
		
		int noOfPages = 0;
		int noOfRecords = 0;
		int recordsPerPage = 5;
		
		boolean assestmentStatus=false;
		Criteria crt=null;

		
		try {

			relationList = session.createCriteria(MasRelation.class)
					.addOrder(Order.asc("RelationName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.addOrder(Order.asc("AdministrativeSexName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			

			List<Patient> patientDetailsList = new ArrayList<Patient>();
			List<BloodDonationEntryHeader> donationDetailsList = new ArrayList<BloodDonationEntryHeader>();
			
			
			
			int visitNo = 0;
			String hinNO = hinNo;
			int hinId = 0;

			if (hinNo != null && !hinNo.equals("")) {

				patientDetailsList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNO)).list();

				map.put("patientDetailsList", patientDetailsList);

				if (patientDetailsList.size() != 0) {
					for (Patient patient : patientDetailsList) {
						hinId = patient.getId();

					}
					crt=session.createCriteria(PatientAddress.class).createAlias("Hin", "Hin").add(Restrictions.eq("Hin.Id", hinId));
					addressList=crt.list();
				}
				donationDetailsList = session.createCriteria(BloodDonationEntryHeader.class)
						.add(Restrictions.eq("UhidNo", hinNO)).list();
				if(null !=donationDetailsList && donationDetailsList.size()>0){
					assestmentStatus=true;
				}

			}
			
			
			map.put("relationList", relationList);
			map.put("addressList", addressList);
			map.put("sexList", sexList);
			map.put("assestmentStatus", assestmentStatus);
			map.put("noOfPages", noOfPages);
			map.put("currentPage", page);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	public String getBloodBankNo(){
		
		int entrySeqNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "BBRN")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (seqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : seqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				entrySeqNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(entrySeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			entrySeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("Blood Bank Registraion");
			tsObj.setTransactionPrefix("BBRN");
			tsObj.setTransactionSequenceName("Blood Bank Registraion No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
		}
		String bbNum="";
		
		int length = (int)(Math.log10(entrySeqNo)+1);
		System.out.println("checkinf @@@ lenght "+length);
		if(length==1){
			bbNum="BB00";
		}
		else if(length==2){
			bbNum="BB0";
		}
		else if(length==3){
			bbNum="BB0";
		}
		else{
			bbNum="BB";
		}
		
		return bbNum+entrySeqNo;

	}
	@Override
	public Map<String, Object> getSampleCrossMatchingTestGrid(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodSampleCollection> sampleScreeningList = new ArrayList<BloodSampleCollection>();

		int noOfRecords = 0;
		int noOfPages = 0;

		String tubeNumber = null;
		String bagNumber = null;
		String FROM_DATE = "";
		String TO_DATE = "";
		Date fromdate = null;
		Date toDate = null;

		int page = box.getInt("page");
		int recordsPerPage = box.getInt("recordsPerPage");

		Session session = (Session) getSession();

		Criteria crit = null;
		Criteria criteriaCount = null;

		if (box.get("bagNumber") != null) {
			bagNumber = box.get("bagNumber");
		}
		if (box.get("tubeNumber") != null) {
			tubeNumber = box.get("tubeNumber");
		}
		if (!box.get("fromDate").equals("")) {
			FROM_DATE = box.get("fromDate");
			System.out.println(FROM_DATE);
			fromdate = HMSUtil.convertStringTypeDateToDateType(FROM_DATE);
			System.out.println(fromdate);

		}
		if (!box.get("toDate").equals("")) {
			TO_DATE = box.get("toDate");
			System.out.println(TO_DATE);
			toDate = HMSUtil.convertStringTypeDateToDateType(TO_DATE);

		}

		try {
			crit = session.createCriteria(BloodSampleCollection.class);
			crit.add(Restrictions.eq("AcceptedRejected", "Y").ignoreCase());
			crit.add(Restrictions.eq("SampleStatus", "P").ignoreCase());
			crit.add(Restrictions.eq("SampleCrossCheckStatus", "P").ignoreCase());

			criteriaCount = session.createCriteria(BloodSampleCollection.class);
			criteriaCount.add(Restrictions.eq("AcceptedRejected", "Y"));
			criteriaCount
					.add(Restrictions.eq("SampleStatus", "P").ignoreCase());
			criteriaCount.add(Restrictions.eq("SampleCrossCheckStatus", "P").ignoreCase());
			criteriaCount.setProjection(Projections.rowCount());

			if (null != bagNumber && !bagNumber.isEmpty()) {
				crit.add(Restrictions.eq("BagNumber", bagNumber));

				criteriaCount = session
						.createCriteria(BloodSampleCollection.class);
				criteriaCount.add(Restrictions.eq("BagNumber", bagNumber));
				criteriaCount.add(Restrictions.eq("AcceptedRejected", "Y"));
				criteriaCount.add(Restrictions.eq("SampleStatus", "P")
						.ignoreCase());
				criteriaCount.setProjection(Projections.rowCount());
			}
			if (null != tubeNumber && !tubeNumber.isEmpty()) {

				crit.add(Restrictions.eq("TubeNumber", tubeNumber));

				criteriaCount = session
						.createCriteria(BloodSampleCollection.class);
				criteriaCount.add(Restrictions.eq("TubeNumber", tubeNumber));
				criteriaCount.add(Restrictions.eq("AcceptedRejected", "Y"));
				criteriaCount.add(Restrictions.eq("SampleStatus", "P")
						.ignoreCase());
				criteriaCount.setProjection(Projections.rowCount());
			}
			if (null != fromdate && null != toDate) {

				crit.add(Restrictions.ge("SampleCollectionDate",
						new java.sql.Date(fromdate.getTime())));
				crit.add(Restrictions.lt("SampleCollectionDate",
						new java.sql.Date(toDate.getTime())));

				criteriaCount = session
						.createCriteria(BloodSampleCollection.class);
				criteriaCount.add(Restrictions.ge("SampleCollectionDate",
						new java.sql.Date(fromdate.getTime())));
				criteriaCount.add(Restrictions.lt("SampleCollectionDate",
						new java.sql.Date(toDate.getTime())));
				criteriaCount.add(Restrictions.eq("AcceptedRejected", "Y"));
				criteriaCount.add(Restrictions.eq("SampleStatus", "P")
						.ignoreCase());
				criteriaCount.setProjection(Projections.rowCount());

			}

			noOfRecords = (Integer) criteriaCount.uniqueResult();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			map.put("currentPage", page);
			map.put("noOfPages", noOfPages);
			crit.setFirstResult((page - 1) * recordsPerPage);
			crit.setMaxResults(recordsPerPage);

			sampleScreeningList = crit.list();
			System.out.println(sampleScreeningList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("sampleScreeningList", sampleScreeningList);
		return map;
	}
	
	@Override
	public Map<String, Object> saveUntestedBloodBags(Box box) {
		
		Session session=(Session)getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		
		BloodStockMain bsm=new BloodStockMain();
		BloodStockDetail stockDetail=new BloodStockDetail();
		
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Transaction tnx=null;
		Criteria crt=null;

		
		String bagNum = "";
		String tubNum = "";
		int quantityNum = 0;
		int hospitalId=0;
		
		boolean status=false;
		
		bagNum=box.get("BagNumber");
		tubNum=box.get("TubeNumber");
		quantityNum=box.getInt("Quntity");
		hospitalId=box.getInt("hospitalId");
		if(hospitalId>0){
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			bsm.setHospital(hospital);
		}
		bsm.setBloodBagStatus("U");
		bsm.setCollectionDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		int stockMainId=0;
		
		int samplId =box.getInt("samplId");
		
		try{
			tnx=session.beginTransaction();
			
			int userId = box.getInt("userId");
			String remark=box.getString("sampleRemarks");
			 
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate); 
			BloodSampleCollection collection=null;
		
				int bloodComponentId=0;
			 collection=hbt.load(BloodSampleCollection.class, samplId);
			 bloodComponentId=collection.getComponent().getId();
			collection.setBloodSampleDate(date);
				collection.setBloodSampleTime(time);
				Users users=new Users(userId);
				collection.setBloodSampleCollectedBy(users);
				collection.setBloodSampleRemarks(remark);
				collection.setSampleStatus("P");  
				collection.setSampleCrossCheckStatus("Y");
				bsm.setExpiryDate(collection.getBagExpiryDate());
				
				hbt.save(bsm);
				hbt.saveOrUpdate(collection); 
				
		
				BloodMasComponent bloodmascomponent=new BloodMasComponent();
				bloodmascomponent.setId(bloodComponentId);
				
				stockDetail.setComponent(bloodmascomponent);
			stockDetail.setStockMain(bsm);
			stockDetail.setBloodBagNo(bagNum);
			stockDetail.setTubeNo(tubNum);
			stockDetail.setQty(quantityNum);
			hbt.save(stockDetail);
			/*BloodSampleCollection smapleCollection=(BloodSampleCollection) session.load(BloodSampleCollection.class, samplId);
			smapleCollection.setSampleCrossCheckStatus("y");
			*/
			tnx.commit();
			session.flush();
			status=true;
		}
		catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		map.put("status", status);
		
		return map;
	}
	
	@Override
	public Map<String, Object> populateItemDetailFromStock(int deptId,
			int hospitalId, int itemId) {
		
		Session session=(Session)getSession();
		
		Criteria crt=null;
		List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
      Map<String,Object> map=new HashMap<String,Object>();
		//List<MasStoreItem> bloodBagsList = new ArrayList<MasStoreItem>();
		
		
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
        int itemTypeId=Integer.parseInt(prop.getProperty("itemTypeId"));
        int departmentId=Integer.parseInt(prop.getProperty("departmentId"));
		
		
		
		crt=session.createCriteria(StoreItemBatchStock.class).createAlias("Department", "department").createAlias("Item", "item")
				.add(Restrictions.ge("ClosingStock",new BigDecimal(0))).add(Restrictions.ge("OpeningBalanceQty",new BigDecimal(0)))
				.add(Restrictions.ge("ExpiryDate", new Date()))
				.add(Restrictions.ge("item.Id",itemId ))
				.add(Restrictions.eq("department.Id", departmentId));
		
				
		bagTypeList =crt.list();		
		map.put("bagTypeList", bagTypeList);
		
		return map;
	}
	
	@Override
	public Map<String, Object> populateBagVolume(int deptId, int hospitalId,
			int itemId) {
		
		Session session=(Session)getSession();
		
		Criteria crt=null;
		List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
      Map<String,Object> map=new HashMap<String,Object>();
		//List<MasStoreItem> bloodBagsList = new ArrayList<MasStoreItem>();
		
		
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
        int itemTypeId=Integer.parseInt(prop.getProperty("itemTypeId"));
        int departmentId=Integer.parseInt(prop.getProperty("departmentId"));
		
		crt=session.createCriteria(StoreItemBatchStock.class).createAlias("Department", "department").createAlias("Item", "item")
				.add(Restrictions.ge("ClosingStock",new BigDecimal(0))).add(Restrictions.ge("OpeningBalanceQty",new BigDecimal(0)))
				.add(Restrictions.ge("ExpiryDate", new Date()))
				.add(Restrictions.eq("Id",itemId ))
				.add(Restrictions.eq("department.Id", departmentId));
				
		bagTypeList =crt.list();		
		map.put("bagTypeList", bagTypeList);
		
		return map;
	}
	
	@Override
	public Map<String, Object> showTransfussionFeedback(int hospitalId) {
		Map<String,Object> map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		
		Criteria crt=null;
		//List<BloodTransfussionReactionHd> transfusionList = new ArrayList<BloodTransfussionReactionHd>();
		
		List<BloodReactionEntryDetails> transfusionFeedbackList = new ArrayList<BloodReactionEntryDetails>();
		
		/*crt=session.createCriteria(BloodTransfussionReactionHd.class)
				
				.createAlias("Hospital", "hosp")
				.add(Restrictions.ge("TestDate", new Date()))
				.add(Restrictions.eq("hosp.Id", hospitalId));
				
		transfusionList=crt.list();*/
		
			crt=session.createCriteria(BloodReactionEntryDetails.class).createAlias("EntryHeader", "entryHeader")

				.createAlias("entryHeader.BloodBankId", "bloodBankId")
				.add(Restrictions.ge("entryHeader.RactionDate", new Date()))
				.add(Restrictions.eq("bloodBankId.Id", hospitalId));
				
				transfusionFeedbackList=crt.list();

		//map.put("transfusionList", transfusionList);
		map.put("transfusionFeedbackList", transfusionFeedbackList);
		return map;
	}
	
	@Override
	public Map<String, Object> showtransfussionDetails(int hospitalId,int bldReactionEntryDetaiId) {
		Map<String,Object> map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		
		Criteria crt=null;
		List<BloodTransfussionReactionDt> transfusionList = new ArrayList<BloodTransfussionReactionDt>();
		
		/*crt=session.createCriteria(BloodTransfussionReactionDt.class)
				
				.createAlias("TransfusionHd", "transfusionHd")
				.createAlias("transfusionHd.Hospital", "hosp")
				.add(Restrictions.ge("transfusionHd.TestDate", new Date()))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("transfusionHd.Id", transfussionHDId));
				
		transfusionList=crt.list();*/
		
		
		List<BloodReactionEntryDetails> transfusionFeedbackList = new ArrayList<BloodReactionEntryDetails>();
			crt=session.createCriteria(BloodReactionEntryDetails.class).createAlias("EntryHeader", "entryHeader")
					.createAlias("entryHeader.BloodBankId", "bloodBankId")
				.add(Restrictions.ge("entryHeader.RactionDate", new Date()))
				.add(Restrictions.eq("bloodBankId.Id", hospitalId))
				.add(Restrictions.eq("Id", bldReactionEntryDetaiId));
				
transfusionFeedbackList=crt.list();
	//	map.put("transfusionList", transfusionList);
		map.put("transfusionFeedbackList", transfusionFeedbackList);
		return map;
	}

	@Override
	public Map<String,Object> submitDonorDeferredDate(Box box) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		boolean save = false;
		BigDecimal big = new BigDecimal(0.00);
		int donorAssesstMid = box.getInt("donorAssesstMid");

		Date deferredDate = null;
		long height = 0;
		String weight = "";
		String Temperature = "";
		long Pulse = 0;
		String Systolic = "";
		String Diastolic="";

		String general = "";
		String status = "";
		String remark = "";

		/*Pulse = box.getInt("Pulse");
		Systolic = box.get("Systolic");
		Diastolic=box.get("Diastolic");
		general = box.get("general");
		status = box.get("status");
		remark = box.get("remark");*/
		/*int storeItemBatchId=0;
		storeItemBatchId=box.getInt("bagTypename");
		*/
		/*String Hemoglobinv="";
		Hemoglobinv=box.get("Hemoglobinv");
		*/
		String DeferredTillDate = box.get("DeferredTillDate");
		if (null != DeferredTillDate && !DeferredTillDate.isEmpty()) {
			deferredDate = HMSUtil
					.convertStringTypeDateToDateType(DeferredTillDate);
		}
		int bloodAssessmentM = box.getInt("bloodAssessmentM");
		int donorbloodAssessmentEntryM=0;
		Session session = (Session) getSession();
		Transaction tx = session.beginTransaction();

		try {

			if (bloodAssessmentM > 0 && null != DeferredTillDate) {
				Date date = new Date();
				BloodAssessmentEntryM bloodAssessmentEntryM = (BloodAssessmentEntryM) session
						.load(BloodAssessmentEntryM.class, bloodAssessmentM);
				/*bloodAssessmentEntryM.setDeferredTillDate(deferredDate);
				bloodAssessmentEntryM.setLastChgDate(date);
				session.save(bloodAssessmentEntryM);*/
				BloodDonationEntryHeader bldHeader=bloodAssessmentEntryM.getDonation();
				bldHeader.setDefferedTillDate(deferredDate);
				session.save(bldHeader);
				session.flush();
				tx.commit();
				save = true;
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		}
		/*
		 * Session session1 = (Session) getSession(); Transaction tx1 =
		 * session1.beginTransaction();
		 */
		try {

			if (donorAssesstMid > 0) {/*
				Date date = new Date();
				BloodAssessmentEntryM bloodAssessmentEntryM = (BloodAssessmentEntryM) session
						.load(BloodAssessmentEntryM.class, donorAssesstMid);
				bloodAssessmentEntryM.setHeight(new BigDecimal(box
						.get("height")));
				bloodAssessmentEntryM.setWeight(new BigDecimal(box
						.get("weight")));
				bloodAssessmentEntryM.setTemperature(new BigDecimal(box
						.get("Temperature")));
				bloodAssessmentEntryM.setPulse(Pulse);
				bloodAssessmentEntryM.setBp(Systolic);
				bloodAssessmentEntryM.setBpDiastolic(Diastolic);
				bloodAssessmentEntryM.setCollectdVolume(new BigDecimal(box
						.get("volume")));
				bloodAssessmentEntryM.setRemarks(remark);
				 session.save(bloodAssessmentEntryM); 
				bloodAssessmentEntryM.setPhysicalFit(status);
				bloodAssessmentEntryM.setPhysicalExam("N");
				
				Criteria crt=session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "Item")
						.add(Restrictions.eq("Item.Id", storeItemBatchId));
				List<StoreItemBatchStock> stockList=crt.list();
				
				if(null !=stockList && stockList.size()>0 && storeItemBatchId>0){
					for(StoreItemBatchStock ss:stockList){
					StoreItemBatchStock store=new StoreItemBatchStock();
					store.setId(ss.getId());
					bloodAssessmentEntryM.setItemBatchStock(store);
					}
				}
				if(!Hemoglobinv.equals("")) {
						
						if( Hemoglobinv.equalsIgnoreCase("y")){
							bloodAssessmentEntryM.setHemoglobin("12.5 ");
						}
						else{
							bloodAssessmentEntryM.setHemoglobin(box.get("lowHemo"));
						}
					
				}
				
				
				session.save(bloodAssessmentEntryM);
				donorbloodAssessmentEntryM=bloodAssessmentEntryM.getId();
				System.out.println("donorbloodAssessmentEntryM donorbloodAssessmentEntryMdonorbloodAssessmentEntryM "+donorbloodAssessmentEntryM);
				session.flush();
				tx.commit();
				save = true;
			*/}
			map.put("donorbloodAssessmentEntryM", donorbloodAssessmentEntryM);
			map.put("save", save);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		}

		return map;
	}
	
	@SuppressWarnings("unchecked") 
	public Map<String, Object> showBloodCollectionDetail(int itemId,int hospitalId) {
		Criteria crt=null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
		Date currentDate=new Date();
		Session session=(Session)getSession();
		//List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
		//List<Object[]> bagTypeList = new ArrayList<Object[]>();

		List<MasStoreItem> bloodBagsList = new ArrayList<MasStoreItem>();
		
		
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
        int itemTypeId=Integer.parseInt(prop.getProperty("bbitemTypeId"));
        int departmentId=Integer.parseInt(prop.getProperty("bbdepartmentId"));
		
		crt=session.createCriteria(MasStoreItem.class).createAlias("ItemType", "ItemType")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("ItemType.Id", itemTypeId));
		bloodBagsList=crt.list();
		
		
/*List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
		
		
       
        crt=session.createCriteria(StoreItemBatchStock.class)
        		.createAlias("Item", "item")
        		.createAlias("Hospital", "hosp")
        		.createAlias("Department", "dept")
        		  
        		.createAlias("item.ItemType", "ItemType")
				.add(Restrictions.eq("item.Status", "y").ignoreCase())
				.add(Restrictions.eq("ItemType.Id", itemTypeId))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("dept.Id", departmentId));
          storeItemBatchStockList=crt.list();*/
		/*crt=session.createCriteria(MasStoreItem.class).createAlias("ItemType", "ItemType").createAlias("Hospital", "hosp")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("ItemType.Id", itemTypeId));
		bloodBagsList=crt.list();*/
       // storeItemBatchStockList=crt.list();
		
		
			
		crt=session.createCriteria(BloodMasComponent.class).
				add(Restrictions.eq("Status", "y").ignoreCase());
							
		
		searchBloodComponentList=crt.list();
		
		
		List<StoreItemBatchStock> bagTypeList1 =null;
		bagTypeList1=new ArrayList<StoreItemBatchStock>();
		
		//System.out.println("itemId "+itemId);
		//System.out.println("hospitalId "+hospitalId);
		//System.out.println("departmentId "+departmentId);
		//System.out.println("itemId "+itemId);
		crt=session.createCriteria(StoreItemBatchStock.class)
				.createAlias("Department", "department")
				.createAlias("Item", "item")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.ge("ClosingStock",new BigDecimal(0))).add(Restrictions.ge("OpeningBalanceQty",new BigDecimal(0)))
				.add(Restrictions.ge("ExpiryDate", new Date()))
				.add(Restrictions.eq("item.Id",itemId ))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("department.Id", departmentId));
		
				
		bagTypeList1 =crt.list();	
		
		
		map.put("bagTypeList", bagTypeList1);
		
		
		
		map.put("bloodBagsList", bloodBagsList);
		map.put("searchBloodComponentList", searchBloodComponentList);
		//map.put("bagTypeList", bagTypeList);
		return map;
	}
	
	
	@Override
	public Map<String, Object> populateBloodRequestForm(
			Map<String, Object> mapForDs) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> districtList=new ArrayList<MasDistrict>();
		List<Patient> patientList=new ArrayList<Patient>();
		List<OtBooking> bloodRequiredPatients=new ArrayList<OtBooking>();
		List<String> visitIdList=new ArrayList<String>();
		
		int hinId = 0;
		
		int hospitalId=0;

		Session session = (Session) getSession();
		
		
		int districtId=0;
		if (mapForDs.get("districtId") != null) {
			districtId = (Integer) mapForDs.get("districtId");
		}
		
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	        Properties prop = new Properties();
	        
	        try {
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
			} catch (Exception e1) {
				
				e1.printStackTrace();
			} 
	       
	        
	        int stateId=Integer.parseInt(prop.getProperty("stateId"));
	      System.out.println("districtList "+stateId);
			districtList = session.createCriteria(MasDistrict.class)
					.addOrder(Order.asc("DistrictName"))
					.add(Restrictions.eq("State.Id", stateId))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			bloodRequiredPatients=session.createCriteria(OtBooking.class).add(Restrictions.eq("BloodRequire","y").ignoreCase()).list();
			
			if(bloodRequiredPatients.size()>0){
				for(OtBooking bloodRequirePatient:bloodRequiredPatients){
					
					if(bloodRequirePatient.getInpatient()!=null){
						
						int inpatientId=bloodRequirePatient.getInpatient().getId();
						List inpatientList=session.createCriteria(BloodRequestEntryHeader.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
						if(inpatientList.size()==0){
							visitIdList.add("");
							patientList.add(bloodRequirePatient.getHin());
						}
					}else if(bloodRequirePatient.getVisit()!=null){
						
						int visitId=bloodRequirePatient.getVisit().getId();
						List outPatientList=session.createCriteria(BloodRequestEntryHeader.class).add(Restrictions.eq("Visit.Id", visitId)).list();
						if(outPatientList.size()==0){
							patientList.add(bloodRequirePatient.getHin());
							visitIdList.add(String.valueOf(visitId));
						}
						
					}
					
				}
			}
			 
		System.out.println("districtList   "+districtList.size());
		
		map.put("patientList", patientList);
		map.put("districtList", districtList);
		map.put("visitIdList", visitIdList);
		return map;
	
	}
	
	@Override
	public Map<String, Object> showPendingbloodRequestJsp(Map<String,Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		 Session session = (Session) getSession();
		 List<BloodRequestEntryHeader> requestheaderList=new ArrayList<BloodRequestEntryHeader>();
		/* List<BloodRequestEntryDetail> requesDetailList=new ArrayList<BloodRequestEntryDetail>();*/
		 int hospital_id=0;
		 if(null !=dataMap.get("hospitalId")){
			 hospital_id=(Integer) dataMap.get("hospitalId");
		 }
		 
		 Criteria crt=null;
		 crt=session.createCriteria(BloodRequestEntryHeader.class).createAlias("Hospital", "hosp")
				 .add(Restrictions.eq("hosp.Id", hospital_id))
				 .add(Restrictions.eq("SampleCollectionStatus", "p").ignoreCase())
				 .add(Restrictions.eq("RequestStatus", "p").ignoreCase());
		 requestheaderList=crt.list();
		 map.put("requestheaderList", requestheaderList);
		 
		return map;
	}
	
	@Override
	public Map<String, Object> populatebloodBankQuantity(Map<String, Object> mapForDs) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		 Session session = (Session) getSession();
		 List<BloodStockDetail> bloodStockList=new ArrayList<BloodStockDetail>();
		/* List<BloodRequestEntryDetail> requesDetailList=new ArrayList<BloodRequestEntryDetail>();*/
		 int bloodBankId = 0;
			int bloodGroupId = 0;
			String componentName="";
			
		 if(null !=mapForDs.get("bloodBankId")){
			 bloodBankId=(Integer) mapForDs.get("bloodBankId");
		 }
		 
		
		 if(null !=mapForDs.get("bloodGroupId")){
			 bloodGroupId=(Integer) mapForDs.get("bloodGroupId");
		 }
		 
		 int componentId=0;
		 if(null !=mapForDs.get("componentName")){
			 componentName=(String) mapForDs.get("componentName");
			 if(null !=componentName && !componentName.equals("")){
			 String component[]=componentName.trim().split("\\[");
			  String index=component[1];
			  String componentNameId[]=index.trim().split("\\]");
			  componentId=Integer.parseInt(componentNameId[0]);
			 }
		 }
		 
		 System.out.println("componentId"+componentId);
		 System.out.println("bloodBankId"+bloodBankId);
		 System.out.println("bloodGroupId"+bloodGroupId);
		 List<BloodStockDetail> bloodStockList1=new ArrayList<BloodStockDetail>();
		  Criteria crt=null;
		  crt=session.createCriteria(BloodStockDetail.class)
				  .createAlias("StockMain", "stockMain")
				    .createAlias("Component", "component")
				     .createAlias("stockMain.BloodGroup", "bloodGroup")
				  
				  .createAlias("stockMain.Hospital", "hosp")
				   .add(Restrictions.eq("bloodGroup.Id", bloodGroupId))
				  .add(Restrictions.eq("hosp.Id", bloodBankId))
				   .add(Restrictions.eq("component.Id", componentId))
					.add(Restrictions.or(Restrictions.ne("BloodIssued", "c").ignoreCase(), Restrictions.isNull("BloodIssued")))
					
					.add(Restrictions.or(Restrictions.ne("BloodDiscard", "y").ignoreCase(), Restrictions.isNull("BloodDiscard")));
		  
		  bloodStockList1=crt.list();
		  //System.out.println("sssisiis   "+bloodStockList1.size());
		
		/* String queryforbagCount="select count(*) from blood_stock_main sm inner join blood_stock_detail sd on sm.stock_id=sd.stock_main_id "
		 		+ "where sm.hospital_id='"+bloodBankId+"' and sd.component_id='"+componentId+"'"
		 		+ "and sm.blood_bag_status='T' and sd.blood_issued IS NULL and sd.blood_discard IS NULL and sm.blood_group_id='"+bloodGroupId+"'";
		 Query query = session.createSQLQuery(queryforbagCount);
				 
				 List result = query.list();
				 System.out.println("result"+result.size());*/
				 
				 //System.out.println("bloodBankId &&&&& "+bloodBankId);
				// System.out.println("componentId &&&&& "+componentId);
				// System.out.println("bloodGroupId &&&&& "+bloodGroupId);
				// System.out.println("count&&&&& "+result.size());
		// System.out.println("count&&&&& "+result.size());
		 map.put("count", bloodStockList1.size());
		
		return map;
	}
	
	@Override
	public Map<String, Object> searchPatientConsentDetails(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> patientList = new ArrayList<BloodRequestEntryHeader>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		String hinNo = "";
		String patientName = "";
		int hospitalId = 0;
		int gender = 0;

		Session session = (Session) getSession();

		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);;
		}
		if (mapForDS.get("patientName") != null) {
			patientName = (String) mapForDS.get("patientName");
		}
		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		Criteria crit = session.createCriteria(BloodRequestEntryHeader.class,"BloodReq")
				.createAlias("BloodBank", "hosp").createAlias("Hin", "h").createAlias("Inpatient", "inpatient")
				.createAlias("h.Sex", "sex")
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("SampleCollectionStatus", "P").ignoreCase())
				.add(Restrictions.or(Restrictions.ne("BloodConsentStatus", "y").ignoreCase(),
						Restrictions.isNull("BloodConsentStatus")));
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("h.HinNo", hinNo));
		}
		if (!patientName.equals("")) {
			crit = crit.add(Restrictions.like("h.PFirstName", patientName + "%"));
		}
		if (gender != 0) {
			crit.createAlias("h.Sex", "s");
			crit.add(Restrictions.eq("s.Id", gender));
		}
		
		patientList = crit.addOrder(Order.desc("Id")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);
		map.put("patientList", patientList);
		return map;
	}

	@Override
	public Map<String, Object> showConsentEntryJsp(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<Patient> patientDetailList = new ArrayList<Patient>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}

		try {
			patientDetailList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo.trim())).list();
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("relationList", relationList);
		return map;

	}

	@Override
	public Map<String, Object> submitConsentForBlood(BloodConsent bloodConsent, Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(bloodConsent);
		successfullyAdded = true;
		String save = "save";
		if (successfullyAdded) {
			map.put("save", save);
		}
		List<BloodRequestEntryHeader> bldEntry = new ArrayList<BloodRequestEntryHeader>();
		bldEntry = session.createCriteria(BloodRequestEntryHeader.class)
				.add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
				.add(Restrictions.isNull("BloodConsentStatus")).list();
		for (BloodRequestEntryHeader bld : bldEntry) {
			bld.setBloodConsentStatus("y");
			hbt.update(bld);
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getHospitalName(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		String hospitalName = "";
		String address = "";
		hospitalList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Id", hospitalId)).list();

		for (MasHospital masStoreItem : hospitalList) {
			hospitalName = masStoreItem.getHospitalName();
			address = masStoreItem.getAddress();
		}
		map.put("hospitalName", hospitalName);
		map.put("address", address);
		return map;
	}

	@Override
	public Map<String, Object> searchBloodPatientConsentLetter(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		String hinNo = "";
		String patientName = "";
		int gender = 0;

		Session session = (Session) getSession();

		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("patientName") != null) {
			patientName = (String) mapForDS.get("patientName");
		}
		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		Criteria crit = session.createCriteria(BloodRequestEntryHeader.class)
				.add(Restrictions.eq("BloodConsentStatus", "y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", (Integer) mapForDS.get(HOSPITAL_ID)))
				.createAlias("Hin", "p");

		if (!patientName.equals("")) {
			crit = crit.add(Restrictions.like("p.PFirstName", patientName + "%"));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("p.HinNo", hinNo));
		}
		if (gender != 0) {
			crit.createAlias("p.Sex", "s");
			crit.add(Restrictions.eq("s.Id", gender));
		}
		patientList = crit.addOrder(Order.asc("Id")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);
		map.put("patientList", patientList);
		return map;

	}

	@Override
	public Map<String, Object> uploadBloodConsentLetter(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<Patient> patientDetailList = new ArrayList<Patient>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
	
		try {
			patientDetailList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo.trim())).list();
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("relationList", relationList);
		return map;

	}


	
	@Override
	public Map<String, Object> uploadAndViewDocuments(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		Session session = (Session) getSession();
		int hinId = 0;
		int visitId = 0;
		int inpatientId = 0;
		String flag = "n";
		String message = "";
		String uploadFrom = "NA";
		boolean fileuploaded = false;

		if (generalMap.get("hinId") != null) {
			hinId = (Integer) generalMap.get("hinId");
		}
		if (generalMap.get("visitId") != null) {
			visitId = (Integer) generalMap.get("visitId");
		}
		if (generalMap.get("inpatientId") != null) {
			inpatientId = (Integer) generalMap.get("inpatientId");
		}
		if (generalMap.get("flag") != null) {
			flag = (String) generalMap.get("flag");
		}
		if (generalMap.get("uploadFrom") != null) {
			uploadFrom = (String) generalMap.get("uploadFrom");
		}

		String filename = "";
		if (generalMap.get("filename") != null) {
			filename = (String) generalMap.get("filename");
		}
		String uploadURL = "";
		if (generalMap.get("uploadURL") != null) {
			uploadURL = (String) generalMap.get("uploadURL");
		}
		String comments = "";
		if (generalMap.get("comments") != null) {
			comments = (String) generalMap.get("comments");
		}

		if (flag.equalsIgnoreCase("y")) {

			String fileExtension = null;
			File file = null;
			try {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				System.out.println(uploadURL + " -- " + filename);
				file = new File(uploadURL + "/" + filename);
				System.out.println("path>>" + file.getPath());

				FileInputStream is = new FileInputStream(file);
				long length = file.length();
				ByteBuffer byteBuff = null;
				// int modLength=length/
				if (length > Integer.MAX_VALUE) {
					// File is too large
				}
				// Create the byte array to hold the data
				byte[] bytes = new byte[(int) length];
				int offset = 0;
				int numRead = 0;
				while (offset < bytes.length
						&& (numRead = is.read(bytes, offset, bytes.length
								- offset)) >= 0) {
					offset += numRead;

				}

				if (offset < bytes.length) {
					throw new IOException("Could not completely read file "
							+ file.getName());

				}
				is.close();

				UploadDocuments document = new UploadDocuments();
				document.setPatientDocument(bytes);
				int indexNo = filename.lastIndexOf(".");
				String actualfileName = filename.substring(0, indexNo);
				fileExtension = filename.substring(indexNo + 1);
				document.setFileName(actualfileName);
				document.setFileExtension(fileExtension);
				Date d = new Date();
				document.setUploadDate(d);

				if (visitId != 0) {
					Visit visit = new Visit();
					visit.setId(visitId);
					document.setVisit(visit);
				}
				if (inpatientId != 0) {
					Inpatient ip = new Inpatient();
					ip.setId(inpatientId);
					document.setInpatient(ip);
				}

				Patient hinNo = new Patient();
				hinNo.setId(hinId);
				document.setHin(hinNo);

				document.setDescription(comments);
				document.setBloodConsentLetter("y");
				hbt.save(document);
				hbt.flush();
				hbt.refresh(document);
				message = "File uploaded Sucessfully";
				fileuploaded = true;

			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error: " + e.getMessage());
				message = "File is not uploaded Sucessfully, some error is occurred";
				e.printStackTrace();
			}

		}

		uploadDocuments = session.createCriteria(UploadDocuments.class)
				.createAlias("Hin", "hin")
				.add(Restrictions.eq("hin.Id", hinId))
				.add(Restrictions.eq("BloodConsentLetter", "y").ignoreCase()).list();
		map.put("visitId", visitId);
		map.put("inpatientId", inpatientId);
		map.put("uploadDocuments", uploadDocuments);
		map.put("message", message);
		map.put("fileuploaded", fileuploaded);
		return map;
	}


}
