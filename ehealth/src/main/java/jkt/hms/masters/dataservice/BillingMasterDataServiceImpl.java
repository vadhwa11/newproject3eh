package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.ACCOUNT_ID;
import static jkt.hms.util.RequestConstants.BILL_TYPE_ID;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE_CODE;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CHARGE_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_ID;
import static jkt.hms.util.RequestConstants.DISCOUNT_PERCENTAGE;
import static jkt.hms.util.RequestConstants.DISCOUNT_TYPE;
import static jkt.hms.util.RequestConstants.DISCOUNT_VALUE;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE_FROM;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE_TO;
import static jkt.hms.util.RequestConstants.GROUP_ID;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.ITEM_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.ITEM_CLASS_ID;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.ITEM_TYPE;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.PATIENT_CATEGORY;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.ROOM_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.USERID;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VISIT_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import jkt.hms.billing.dataservice.OpBillingDataService;
import jkt.hms.masters.business.BlDispensingDetails;
import jkt.hms.masters.business.BlDispensingHeader;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlPriority;
import jkt.hms.masters.business.DailyChargeSetup;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasAccountGroup;
import jkt.hms.masters.business.FaMasAccountSubGroup;
import jkt.hms.masters.business.FaMasAccountType;
import jkt.hms.masters.business.FaSchemeAccountMapping;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBillScheme;
import jkt.hms.masters.business.MasBillType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasDiscountDiagnosis;
import jkt.hms.masters.business.MasDiscountExclude;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalwiseChargecode;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasSalesTaxType;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreItemBatchStock;
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.examples.ExampleReceiverApplication;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.message.ORU_R01;
import ca.uhn.hl7v2.model.v22.segment.MSH;
import ca.uhn.hl7v2.model.v22.segment.OBR;
import ca.uhn.hl7v2.model.v22.segment.ORC;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.model.v23.message.ACK;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

import java.io.*;
import java.net.*;

public class BillingMasterDataServiceImpl extends HibernateDaoSupport implements
		BillingMasterDataService {
	
private OpBillingDataService opBillingDataService = null;
	
	

	public OpBillingDataService getOpBillingDataService() {
	   return opBillingDataService;
    }

    public void setOpBillingDataService(OpBillingDataService opBillingDataService) {
	   this.opBillingDataService = opBillingDataService;
    }

	Map<String, Object> map = new HashMap<String, Object>();

	// ----------------------------------Bill
	// Type----------------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBillTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBillType> searchBillTypeList = new ArrayList<MasBillType>();
		searchBillTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBillType ");
		map.put("searchBillTypeList", searchBillTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBillType(String billTypeCode,
			String billTypeName) {
		List<MasBillType> searchBillTypeList = new ArrayList<MasBillType>();
		Map billTypeFieldsMap = new HashMap();
		try {
			if ((billTypeName != null) || (billTypeCode == null)) {
				searchBillTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBillType mbt where lower(mbt.BillTypeName) like '"
								+ billTypeName.toLowerCase() + "%' order by mbt.BillTypeName");
			} else {
				searchBillTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasBillType mbt where lower(mbt.BillTypeCode) like '"
								+ billTypeCode.toLowerCase() + "%' order by mbt.BillTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		billTypeFieldsMap.put("searchBillTypeList", searchBillTypeList);
		return billTypeFieldsMap;
	}

	public boolean addBillType(MasBillType masBillType) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBillType);
		hbt.flush();hbt.clear();
		dataSaved = true;
		return dataSaved;
	}

	public boolean deleteBillType(int billTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBillType masBillType = new MasBillType();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		masBillType = (MasBillType) getHibernateTemplate().load(
				MasBillType.class, billTypeId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBillType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBillType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masBillType.setLastChgBy(users);
		masBillType.setLastChgDate(currentDate);
		masBillType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBillType);
		return dataDeleted;
	}

	public boolean editBillTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		String changedBy = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String billTypeName = "";
		@SuppressWarnings("unused")
		String billTypeCode = "";
		int billTypeId = 0;

		billTypeId = (Integer) generalMap.get("id");
		billTypeCode = (String) generalMap.get("billTypeCode");
		billTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);

		MasBillType masBillType = (MasBillType) getHibernateTemplate().load(
				MasBillType.class, billTypeId);

		masBillType.setId(billTypeId);
		masBillType.setBillTypeName(billTypeName);
		Users users=new Users();
		users.setId(userId);
		masBillType.setLastChgBy(users);
		masBillType.setLastChgDate(currentDate);
		masBillType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBillType);
		dataUpdated = true;
		return dataUpdated;
	}

	// ---------------------------------------Account Type
	// ----------------------

	public boolean addAccountType(FaMasAccountType faMasAccountType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(faMasAccountType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editAccountTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String accountTypeName = "";
		@SuppressWarnings("unused")
		String accountTypeCode = "";
		int accountTypeId = 0;
		String changedBy = "";
		accountTypeId = (Integer) generalMap.get("id");
		accountTypeCode = (String) generalMap.get("accountTypeCode");
		accountTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		FaMasAccountType faMasAccountType = (FaMasAccountType) getHibernateTemplate()
				.load(FaMasAccountType.class, accountTypeId);

		faMasAccountType.setId(accountTypeId);
		faMasAccountType.setAccountTypeName(accountTypeName);
		//commented for maven
		/*faMasAccountType.setLastChgBy(changedBy);*/
		faMasAccountType.setLastChgDate(currentDate);
		faMasAccountType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(faMasAccountType);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountType(String accountTypeCode,
			String accountTypeName) {
		List<FaMasAccountType> searchAccountTypeList = new ArrayList<FaMasAccountType>();
		Map<String, Object> accountTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((accountTypeName != null) || (accountTypeCode == null)) {
				searchAccountTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.FaMasAccountType imc where imc.AccountTypeName like '"
								+ accountTypeName
								+ "%' order by imc.AccountTypeName");
			} else {
				searchAccountTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.FaMasAccountType imc where imc.AccountTypeCode like '"
								+ accountTypeCode
								+ "%' order by imc.AccountTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		accountTypeFieldsMap
				.put("searchAccountTypeList", searchAccountTypeList);
		return accountTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountType> searchAccountTypeList = new ArrayList<FaMasAccountType>();
		searchAccountTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.FaMasAccountType ");
		map.put("searchAccountTypeList", searchAccountTypeList);
		return map;
	}

	public boolean deleteAccountType(int accountTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		FaMasAccountType faMasAccountType = new FaMasAccountType();
		faMasAccountType = (FaMasAccountType) getHibernateTemplate().load(
				FaMasAccountType.class, accountTypeId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				faMasAccountType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				faMasAccountType.setStatus("y");
				dataDeleted = false;
			}
		}
		//commented for maven
		/*faMasAccountType.setLastChgBy(changedBy);*/
		faMasAccountType.setLastChgDate(currentDate);
		faMasAccountType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(faMasAccountType);
		return dataDeleted;
	}

	// ----------------------------------------------Charge
	// Type-----------------------------------

	public boolean addChargeType(MasChargeType masChargeType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masChargeType);
		// getHibernateTemplate().save(masChargeType);
		successfullyAdded = true;
		hbt.flush();hbt.clear();
		return successfullyAdded;
	}

	public boolean editChargeTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String chargeTypeName = "";
		@SuppressWarnings("unused")
		String chargeTypeCode = "";
		int chargeTypeId = 0;
		String changedBy = "";

		chargeTypeId = (Integer) generalMap.get("id");
		chargeTypeCode = (String) generalMap.get("chargeTypeCode");
		chargeTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		String chargeTypeStatus=(String) generalMap.get("chargeTypeStatus");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);
		
		MasChargeType masChargeType = (MasChargeType) getHibernateTemplate()
				.load(MasChargeType.class, chargeTypeId);

		masChargeType.setId(chargeTypeId);
		masChargeType.setChargeTypeName(chargeTypeName);
		Users users=new Users();
		users.setId(userId);
		masChargeType.setLastChgBy(users);
		masChargeType.setLastChgDate(currentDate);
		masChargeType.setLastChgTime(currentTime);
		masChargeType.setChargeTypeStatus(chargeTypeStatus);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masChargeType);
		// getHibernateTemplate().update(masChargeType);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchChargeType(String chargeTypeCode,
			String chargeTypeName) {
		List<MasChargeType> searchChargeTypeList = new ArrayList<MasChargeType>();
		Map<String, Object> chargeTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((chargeTypeName != null) || (chargeTypeCode == null)) {
				searchChargeTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasChargeType imc where lower(imc.ChargeTypeName) like '"
								+ chargeTypeName.toLowerCase()
								+ "%' order by imc.ChargeTypeName");
			} else {
				searchChargeTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasChargeType imc where lower(imc.ChargeTypeCode) like '"
								+ chargeTypeCode.toLowerCase()
								+ "%' order by imc.ChargeTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chargeTypeFieldsMap.put("searchChargeTypeList", searchChargeTypeList);
		return chargeTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showChargeTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeType> searchChargeTypeList = new ArrayList<MasChargeType>();
		searchChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType ");
		map.put("searchChargeTypeList", searchChargeTypeList);
		return map;
	}

	public boolean deleteChargeType(int chargeTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasChargeType masChargeType = new MasChargeType();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId = (Integer) generalMap.get(RequestConstants.USER_ID);
		masChargeType = (MasChargeType) getHibernateTemplate().load(
				MasChargeType.class, chargeTypeId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masChargeType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masChargeType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masChargeType.setLastChgBy(users);
		masChargeType.setLastChgDate(currentDate);
		masChargeType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masChargeType);
		return dataDeleted;
	}

	// -------------------------------------Bank Master-------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBank(String bankCode, String bankName) {
		List<MasBankMaster> searchBankList = new ArrayList<MasBankMaster>();
		Map<String, Object> bankFieldsMap = new HashMap<String, Object>();
		try {
			if ((bankName != null) || (bankCode == null)) {
				searchBankList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBankMaster bm where bm.BankName like '"
								+ bankName + "%' order by bm.BankName");
			} else {
				searchBankList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBankMaster bm where bm.BankCode like '"
								+ bankCode + "%' order by bm.BankCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		bankFieldsMap.put("searchBankList", searchBankList);
		return bankFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBankJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> searchBankList = new ArrayList<MasBankMaster>();
		searchBankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBankMaster ");
		map.put("searchBankList", searchBankList);
		return map;
	}

	public boolean addBank(MasBankMaster masBank) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBank);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editBankToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String bankName = "";
		@SuppressWarnings("unused")
		String bankCode = "";
		int bankId = 0;
		int changedBy = 0;

		bankId = (Integer) generalMap.get("id");
		bankCode = (String) generalMap.get("bankCode");
		bankName = (String) generalMap.get("name");
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBankMaster masBank = (MasBankMaster) getHibernateTemplate().load(
				MasBankMaster.class, bankId);

		masBank.setId(bankId);
		masBank.setBankName(bankName);
		
		Users users=new Users();
		users.setId(changedBy);
		masBank.setLastChgBy(users);
		
		masBank.setLastChgDate(currentDate);
		masBank.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBank);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteBank(int bankId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBankMaster masBank = new MasBankMaster();
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		masBank = (MasBankMaster) getHibernateTemplate().load(
				MasBankMaster.class, bankId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBank.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBank.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(changedBy);
		masBank.setLastChgBy(users);
		
		masBank.setLastChgDate(currentDate);
		masBank.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBank);
		return dataDeleted;
	}

	// ---------------------------------Sales Tax
	// Type----------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchSalesTaxType(String salesTaxTypeCode,
			String salesTaxTypeName) {
		List<MasSalesTaxType> searchSalesTaxTypeList = new ArrayList<MasSalesTaxType>();
		Map<String, Object> salesTaxTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((salesTaxTypeName != null) || (salesTaxTypeCode == null)) {
				searchSalesTaxTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSalesTaxType stt where stt.SalesTaxTypeName like '"
								+ salesTaxTypeName
								+ "%' order by stt.SalesTaxTypeName");
			} else {
				searchSalesTaxTypeList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasSalesTaxType stt where stt.SalesTaxTypeCode like '"
								+ salesTaxTypeCode
								+ "%' order by stt.SalesTaxTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		salesTaxTypeFieldsMap.put("searchSalesTaxTypeList",
				searchSalesTaxTypeList);
		return salesTaxTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSalesTaxTypeJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSalesTaxType> searchSalesTaxTypeList = new ArrayList<MasSalesTaxType>();
		searchSalesTaxTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSalesTaxType");
		map.put("searchSalesTaxTypeList", searchSalesTaxTypeList);
		return map;
	}

	public boolean addSalesTaxType(MasSalesTaxType masSalesTaxType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masSalesTaxType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editSalesTaxTypeToDatabase(Map<String, Object> generalMap) {
		BigDecimal saleTax = new BigDecimal(0);
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String salesTaxTypeName = "";
		@SuppressWarnings("unused")
		String salesTaxTypeCode = "";
		int salesTaxTypeId = 0;
		String changedBy = "";

		salesTaxTypeId = (Integer) generalMap.get("id");
		salesTaxTypeCode = (String) generalMap.get("Code");
		salesTaxTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		saleTax = (BigDecimal) generalMap.get("saleTax");

		MasSalesTaxType masSalesTaxType = (MasSalesTaxType) getHibernateTemplate()
				.load(MasSalesTaxType.class, salesTaxTypeId);

		masSalesTaxType.setId(salesTaxTypeId);
		masSalesTaxType.setSalesTaxTypeName(salesTaxTypeName);
		masSalesTaxType.setLastChgBy(changedBy);
		masSalesTaxType.setLastChgDate(currentDate);
		masSalesTaxType.setLastChgTime(currentTime);
		masSalesTaxType.setSaleTax(saleTax);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSalesTaxType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteSalesTaxType(int salesTaxTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSalesTaxType masSalesTaxType = new MasSalesTaxType();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		masSalesTaxType = (MasSalesTaxType) getHibernateTemplate().load(
				MasSalesTaxType.class, salesTaxTypeId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSalesTaxType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSalesTaxType.setStatus("y");
				dataDeleted = false;
			}
		}
		masSalesTaxType.setLastChgBy(changedBy);
		masSalesTaxType.setLastChgDate(currentDate);
		masSalesTaxType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSalesTaxType);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDiscountJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		
		boolean localdiscount=box.getBoolean("localdiscount");
		int hospitalId=box.getInt(HOSPITAL_ID);
		String serviceName="";
		if(box.get("serviceName")!=null){
			serviceName=box.get("serviceName");
			
		}
		String schemeName="";
		if(box.get("schemeName")!=null){
			schemeName=box.get("schemeName");
			
		}
		//newly added
		
		List<MasScheme> schemeList = new ArrayList<MasScheme>();
		List<MasPatientType> patientTypeForSocialCategory=new ArrayList<MasPatientType>();
		List<MasPatientType> patientTypeForOtherCategory=new ArrayList<MasPatientType>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		List<MasDepartment> departments=new ArrayList<MasDepartment>();
		//ArrayList<Integer>  chargeCodes = new ArrayList<Integer>();
		//end of newly ended

		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasBillType> billTypeList = new ArrayList<MasBillType>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<Object[]> ChargeCodeList = new ArrayList<Object[]>();
		List<MasChargeCode> newChargeCodeList = new ArrayList<MasChargeCode>();
		// List<MasEmployee> employeeList = new ArrayList<MasEmployee>(); //commented by amit das on 11-05-2017
		List<Object[]> employeeList = new ArrayList<Object[]>(); // added by amit das on 11-05-2017
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<Object[]> storeItemList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		
		String billtypedispensing="";
		String billtypeservic="";
		java.net.URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop
					.getProperty("billtypedispensing");
			billtypeservic = prop
					.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String mas_department_type_ward=null;
		 resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mas_department_type_ward=prop.getProperty("mas_department_type_ward");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 Criteria disCriteria=session.createCriteria(MasDiscount.class);
		
		 if(!serviceName.equals("")){
			
			            disCriteria.createAlias("ChargeCode", "cc")
			            .add(Restrictions.like("cc.ChargeCodeName",serviceName+"%")
					    .ignoreCase())
					    .add(Restrictions.like("Status", "y")
					    .ignoreCase());
			}
			
		if(!schemeName.equals("")){
			disCriteria.createAlias("Scheme", "Scheme")
			.add(Restrictions.like("Scheme.SchemeName",schemeName+"%")
					.ignoreCase())
					.add(Restrictions.like("Status", "y")
					    .ignoreCase());
		}
		if(localdiscount)
		{
			disCriteria.createAlias("Hospital", "hospital")
			.add(Restrictions.eq("hospital.Id", hospitalId));
			
			
		}
		else
		{
			//disCriteria.add(Restrictions.isNull("Hospital"));
		 disCriteria.list();
		}
        
		discountList = disCriteria.list();
		groupList =session.createCriteria(MasStoreGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		patientTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("PatientTypeName"))
				.list();
		
		companyList = session.createCriteria(MasCompany.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		billTypeList = session.createCriteria(MasBillType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.or(Restrictions.eq("BillTypeCode",billtypeservic.toLowerCase()).ignoreCase(),
						Restrictions.eq("BillTypeCode", billtypedispensing.toLowerCase()).ignoreCase()))
						.addOrder(Order.asc("BillTypeName")).list();
		
		roomTypeList = session.createCriteria(MasRoomType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		mainChargeCodeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("MainChargecodeName")).list();
		
		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("SubChargecodeName")).list();
		
		newChargeCodeList=session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("ChargeCodeName")).list();
		
		/*if(discountList!=null){
			for(MasDiscount discount : discountList){
				if(discount.getChargeCode()!=null)
				chargeCodes.add(discount.getChargeCode().getId());
			}
			
		}*/
		
		
		// ChargeCodeList
		
		Criteria criteria  = session
				.createCriteria(MasChargeCode.class);
				
		
		/*if(chargeCodes!=null && chargeCodes.size()>0)
			criteria = criteria.add(Restrictions.in("Id", chargeCodes));
		*/			
				
				
		ChargeCodeList =   criteria.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("ChargeCodeName"))
								.add(Projections.property("Id"))
								.add(Projections.property("SubChargecode.Id"))
								.add(Projections.property("MainChargecode.Id")))
				// .addOrder(Order.asc("ChargeCodeCode")).list(); // commented by amit das on 31-05-2017
								.addOrder(Order.asc("ChargeCodeName")).list(); // added by amit das on 31-05-2017
		
		/*employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
		// commented by amit das on 11-05-2017
		
		// added by amit das on 11-05-2017
		employeeList = session.createCriteria(MasEmployee.class)
		.add(Restrictions.eq("Status", "y").ignoreCase())
		.setProjection(
				Projections.projectionList()
						.add(Projections.property("Id"))		
						.add(Projections.property("FirstName"))).list();
		
		employeeDependentList = session
				.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		accountList = session.createCriteria(FaMasAccount.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		/*String qry = "";
		qry = "Select item_id,nomenclature from mas_store_item where status='y' ";
		storeItemList = session.createSQLQuery(qry).list();*/
		
		/*storeItemList = getHibernateTemplate().find("select item.Id ,"
				+ " item.Nomenclature from jkt.hms.masters.business.MasStoreItem item "
				+ "where item.Status = 'y' group by item.Id , item.Nomenclature "
				+ "order by item.Nomenclature ");*/

		
		patientTypeForSocialCategory=session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Type", "s").ignoreCase()).list();
		
		patientTypeForOtherCategory=session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Type", "o").ignoreCase()).list();
		
		schemeList=session.createCriteria(MasScheme.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		
		departments=session
				.createCriteria(MasDepartment.class,"msd")
				.createAlias("msd.DepartmentType", "mdt")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", mas_department_type_ward))
				.list();
		
		
		map.put("schemeName", schemeName);
		map.put("serviceName", serviceName);
		map.put("patientTypeList", patientTypeList);
		map.put("companyList", companyList);
		map.put("billTypeList", billTypeList);
		map.put("roomTypeList", roomTypeList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("subChargeCodeList", subChargeCodeList);
		map.put("ChargeCodeList", ChargeCodeList);
		map.put("employeeList", employeeList);
		map.put("employeeDependentList", employeeDependentList);
		map.put("accountList", accountList);
		map.put("storeItemList", storeItemList);
		map.put("discountList", discountList);
		
		map.put("patientTypeForSocialCategory", patientTypeForSocialCategory);
		map.put("patientTypeForOtherCategory", patientTypeForOtherCategory);
		map.put("groupList", groupList);
		map.put("schemeList", schemeList);
		map.put("departments", departments);
		//serviceAutoBilling(box);
		
		return map;
	}
	@SuppressWarnings("unchecked")
	public boolean deleteDiscount(int discountId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDiscount masDiscount = new MasDiscount();
		
		
		masDiscount = (MasDiscount) getHibernateTemplate().load(MasDiscount.class,
				discountId);
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDiscount.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDiscount.setStatus("y");
				dataDeleted = false;
			}
		}
		
		Users users=new Users();
		users.setId(userId);
		masDiscount.setLastChgBy(users);
		

		masDiscount.setLastChgDate(currentDate);
		masDiscount.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDiscount);
		return dataDeleted;
	}
	
	@Override
	public Map<String, Object> getDrugNamesForAutocomplete(Map<String, Object> dataMap)
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
			String str = "%" + dataMap.get("autoHint") + "%";
			
			StringBuffer sb = new StringBuffer();
			sb.append("select item.Id , item.Nomenclature from ");
			sb.append(" jkt.hms.masters.business.MasStoreItem item where ");
			sb.append(" item.Nomenclature like '"+str+"' and item.Status = 'y' ");
			sb.append(" group by item.Id , item.Nomenclature ");

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

	public Map<String, Object> saveDiscount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String message="";
		/*
		 * hbt.save(masDiscount); dataSaved = true; String message = "";
		 */
		boolean localdiscount=box.getBoolean("localdiscount");
		int hospitalId=box.getInt(HOSPITAL_ID);
		int deptId = box.getInt(DEPT_ID);
		int userId = box.getInt(USER_ID);
		int empId = box.getInt("empId");
		Transaction transaction = null;
		try {

			String billtypedispensing = "";
			String billtypeservic = "";
			java.net.URL resourcePath = Thread.currentThread()
					.getContextClassLoader().getResource("account.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				billtypedispensing = prop.getProperty("billtypedispensing");
				billtypeservic = prop.getProperty("billtypeservic");
			} catch (IOException e) {
				e.printStackTrace();
			}

			transaction = session.beginTransaction();
			MasDiscount masDiscount = new MasDiscount();

			if(localdiscount)
			{
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			masDiscount.setHospital(masHospital);
			}
			if (box.getInt("schemeId") != 0) {
				MasScheme scheme = new MasScheme();
				scheme.setId(box.getInt("schemeId"));
				masDiscount.setScheme(scheme);
			}

			if (box.getString("bplStatus").equalsIgnoreCase("bpl")) {
				masDiscount.setBplStatus("y");
			} else if (box.getString("bplStatus").equalsIgnoreCase("apl")) {
				masDiscount.setBplStatus("n");
			} else {
				masDiscount.setBplStatus(null);
			}

			if (box.getInt("patientTypeId") != 0) {
				MasPatientType socialcategory = new MasPatientType();
				socialcategory.setId(box.getInt("patientTypeId"));
				masDiscount.setPatientType(socialcategory);
			}

			if (box.getInt("otherCategory") != 0) {
				MasPatientType socialcategory = new MasPatientType();
				socialcategory.setId(box.getInt("otherCategory"));
				masDiscount.setOtherCategory(socialcategory);
			}

			if (!box.getString(PATIENT_CATEGORY).equalsIgnoreCase("")
					&& !box.getString(PATIENT_CATEGORY).equalsIgnoreCase("0")) {
				String patientCategory = box.getString(PATIENT_CATEGORY);
				masDiscount.setPatientCategory(patientCategory);
				if (patientCategory.equalsIgnoreCase("ip")
						&& box.getInt(DEPARTMENT_ID) != 0) {
					int departmentId = box.getInt(DEPARTMENT_ID);
					if(departmentId!=0)
					{
					MasDepartment department = new MasDepartment();
					department.setId(box.getInt(DEPARTMENT_ID));
					masDiscount.setDepartment(department);
					if(box.getInt(ROOM_TYPE_ID)!=0)
					{
					MasRoomType masRoom=new MasRoomType();
					masRoom.setId(box.getInt(ROOM_TYPE_ID));
					masDiscount.setRoomType(masRoom);
					}
					}
					// need to set department
				}
			}
			
			hbt.save(masDiscount);

			if (box.getInt(BILL_TYPE_ID) != 0) {
				MasBillType billType = (MasBillType) hbt.get(MasBillType.class,
						box.getInt(BILL_TYPE_ID));
				masDiscount.setBillType(billType);
				if (billType.getBillTypeCode().equalsIgnoreCase(
						billtypedispensing)) {
					if (box.getInt(GROUP_ID) != 0) {
						MasStoreGroup group = new MasStoreGroup();
						group.setId(box.getInt(GROUP_ID));
						masDiscount.setGroup(group);
						if (box.getInt(ITEM_TYPE) != 0) {
							MasItemType itemType = new MasItemType();
							itemType.setId(box.getInt(ITEM_TYPE));
							masDiscount.setItemType(itemType);
							if (box.getInt(SECTION_ID) != 0) {
								MasStoreSection storeSection = new MasStoreSection();
								storeSection.setId(box.getInt(SECTION_ID));
								masDiscount.setItemSection(storeSection);
								if (box.getInt(ITEM_CATEGORY_ID) != 0) {
									MasItemCategory itemCategory = new MasItemCategory();
									itemCategory.setId(box
											.getInt(ITEM_CATEGORY_ID));
									masDiscount.setItemCategory(itemCategory);
								} else {
									masDiscount.setItemCategory(null);
								}

								if (box.getInt(ITEM_CLASS_ID) != 0) {
									MasItemClass itemClass = new MasItemClass();
									itemClass.setId(box.getInt(ITEM_CLASS_ID));
									masDiscount.setItemClass(itemClass);
								} else {
									masDiscount.setItemClass(null);
								}

								if (box.getInt("drug") != 0) {
									MasStoreItem item = new MasStoreItem();
									item.setId(box.getInt("drug"));
									masDiscount.setItem(item);
								} else {
									masDiscount.setItem(null);
								}
							} else {
								masDiscount.setItemSection(null);
								masDiscount.setItemCategory(null);
								masDiscount.setItemClass(null);
								masDiscount.setItem(null);
							}
						} else {
							masDiscount.setItemType(null);
							masDiscount.setItemSection(null);
							masDiscount.setItemCategory(null);
							masDiscount.setItemClass(null);
							masDiscount.setItem(null);
						}

						Vector<String> chargeList = box
								.getVector("excludeitemId");
						if (chargeList != null && chargeList.size() > 0) {
							for (String chargeId : chargeList) {
								MasDiscountExclude discountExclude = new MasDiscountExclude();
								discountExclude.setDiscount(masDiscount);
								MasStoreItem item = new MasStoreItem();
								item.setId(Integer.parseInt(chargeId));
								discountExclude.setItem(item);
								discountExclude.setStatus("y");
								hbt.save(discountExclude);
							}
						}
					} else {
						masDiscount.setGroup(null);
						masDiscount.setItemType(null);
						masDiscount.setItemSection(null);
						masDiscount.setItemCategory(null);
						masDiscount.setItemClass(null);
						masDiscount.setItem(null);

					}

				} else if (billType.getBillTypeCode().equalsIgnoreCase(
						billtypeservic)) {
					if (box.getInt(MAIN_CHARGECODE_ID) != 0) {
						int mainchargeCodeId = box.getInt(MAIN_CHARGECODE_ID);
						MasMainChargecode mainChargecode = new MasMainChargecode();
						mainChargecode.setId(mainchargeCodeId);
						masDiscount.setMainChargecode(mainChargecode);

						if (box.getInt(SUB_CHARGECODE_ID) != 0) {
							MasSubChargecode subChargecode = new MasSubChargecode();
							subChargecode.setId(box.getInt(SUB_CHARGECODE_ID));
							masDiscount.setSubChargecode(subChargecode);
							if (box.getInt(CHARGE_CODE_ID) != 0) {
								MasChargeCode chargeCode = new MasChargeCode();
								chargeCode.setId(box.getInt(CHARGE_CODE_ID));
								masDiscount.setChargeCode(chargeCode);
							} else {
								masDiscount.setChargeCode(null);
							}
						} else {
							masDiscount.setSubChargecode(null);
							masDiscount.setChargeCode(null);
						}
						
						Vector<String> chargeList = box.getVector("excludechargeId");
						if (chargeList != null && chargeList.size() > 0) {
							for (String chargeId : chargeList) {
								MasDiscountExclude discountExclude = new MasDiscountExclude();
								discountExclude.setDiscount(masDiscount);
								MasChargeCode chargeCode = new MasChargeCode();
								chargeCode.setId(Integer.parseInt(chargeId));
								discountExclude.setCharge(chargeCode);
								discountExclude.setStatus("y");
								hbt.save(discountExclude);
							}
						}
					} else {
						masDiscount.setMainChargecode(null);
					}
					
					
				}

			}

			if (box.getInt("fromAge") != 0) {
				masDiscount.setFromAge(new BigDecimal(box.getInt("fromAge")));
				if (box.getInt("toAge") != 0) {
					masDiscount.setToAge(new BigDecimal(box.getInt("toAge")));
				}
			}

			if (!box.getString(EFFECTIVE_DATE_FROM).equals("")) {
				Date effectiveDateFrom = HMSUtil.dateFormatterDDMMYYYY(box
						.getString(EFFECTIVE_DATE_FROM));
				masDiscount.setEffectiveDateFrom(effectiveDateFrom);
				if (!box.getString(EFFECTIVE_DATE_TO).equals("")) {
					Date effectiveDateTo = HMSUtil.dateFormatterDDMMYYYY(box
							.getString(EFFECTIVE_DATE_FROM));
					masDiscount.setEffectiveDateTo(effectiveDateTo);
				}
			}

			if (!box.getString(DISCOUNT_TYPE).equalsIgnoreCase("")
					&& !box.getString(DISCOUNT_TYPE).equalsIgnoreCase("0")) {
				String discountType = box.getString(DISCOUNT_TYPE);
				masDiscount.setDiscountType(discountType);
				if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("d")) {
					if (box.getFloat(DISCOUNT_PERCENTAGE) != 0.0) {
						masDiscount.setDiscountPercentage(new BigDecimal(box
								// .getInt(DISCOUNT_PERCENTAGE))); // commented by amit das on 31-05-2017
								.getFloat(DISCOUNT_PERCENTAGE))); // added by amit das on 31-05-2017
					} else if (box.getInt(DISCOUNT_VALUE) != 0) {
						masDiscount
								.setDiscountValue(new BigDecimal(box.getInt(DISCOUNT_VALUE)));
					}
				} else if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("t")) {
					if (box.getFloat(DISCOUNT_PERCENTAGE) != 0.0) {
						masDiscount.setDiscountPercentage(new BigDecimal(box
								// .getInt(DISCOUNT_PERCENTAGE))); // commented by amit das on 31-05-2017
								.getFloat(DISCOUNT_PERCENTAGE))); // added by amit das on 31-05-2017
					} else if (box.getInt(DISCOUNT_VALUE) != 0) {
						masDiscount
								.setDiscountValue(new BigDecimal(box.getInt(DISCOUNT_VALUE)));
					}
				} else if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("f")) {
					if (box.getFloat(DISCOUNT_VALUE) != 0) {
					   	masDiscount.setDiscountValue(new BigDecimal(box.getFloat(DISCOUNT_VALUE)));  
					}
				}
			}

			if (box.getInt(ACCOUNT_ID) != 0) {
				int accountId = box.getInt(ACCOUNT_ID);
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(accountId);
				masDiscount.setAccountId(accountId);
			}
			
			Vector<String> diagnosisList = box.getVector(DIAGNOSIS_ID);
			if (diagnosisList != null && diagnosisList.size() > 0) {
				for (String diagnosisid : diagnosisList) {
					MasDiscountDiagnosis discountDiagnosis = new MasDiscountDiagnosis();
					discountDiagnosis.setDiscount(masDiscount);
					MasIcd masIcd=new MasIcd();
					masIcd.setId(Integer.parseInt(diagnosisid));
					discountDiagnosis.setIcd(masIcd);
					discountDiagnosis.setStatus("y");
					hbt.save(discountDiagnosis);
				}
			}

			/*
			 * if (request.getParameter(CHANGED_BY) != null &&
			 * !(request.getParameter(CHANGED_BY).equals(""))) { String
			 * changedBy = request.getParameter(CHANGED_BY);
			 * masDiscount.setLastChgBy(changedBy); }
			 */
			Map<String, Object> utilMap = new HashMap<String, Object>();

			utilMap = HMSUtil.getCurrentDateAndTime();

			Users user = new Users();
			user.setId(userId);
			masDiscount.setLastChgBy(user);

			Date currentDate = HMSUtil.dateFormatterDDMMYYYY((String) utilMap
					.get("currentDate"));
			masDiscount.setLastChgDate(currentDate);

			String currentTime = (String) utilMap.get("currentTime");
			masDiscount.setLastChgTime(currentTime);

			masDiscount.setStatus("y");

			hbt.update(masDiscount);
			transaction.commit();
			hbt.flush();
			hbt.clear();
			dataSaved = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (dataSaved) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		//map = showDiscountJsp();
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDiscountList(Box box) {
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		List<MasDiscount> discountListRecieved = new ArrayList<MasDiscount>();
		//newly added
		
		List<MasScheme> schemeList = new ArrayList<MasScheme>();
		List<MasPatientType> patientTypeForSocialCategory=new ArrayList<MasPatientType>();
		List<MasPatientType> patientTypeForOtherCategory=new ArrayList<MasPatientType>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		List<MasDepartment> departments=new ArrayList<MasDepartment>();

		//end of newly ended

		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasBillType> billTypeList = new ArrayList<MasBillType>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<Object[]> ChargeCodeList = new ArrayList<Object[]>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<Object[]> storeItemList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		
		String billtypedispensing="";
		String billtypeservic="";
		java.net.URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop
					.getProperty("billtypedispensing");
			billtypeservic = prop
					.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String mas_department_type_ward=null;
		 resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mas_department_type_ward=prop.getProperty("mas_department_type_ward");
		} catch (IOException e) {
			e.printStackTrace();
		}
        
//		discountList = session.createCriteria(MasDiscount.class).list();
		
		Criteria crit = session.createCriteria(MasDiscount.class);
		
		
		
		if (box.getInt("patientTypeId") != 0) {
			crit = crit.createAlias("PatientType", "pt").add(
					Restrictions.eq("pt.Id", box.getInt("patientTypeId")));
		}
		
		if (box.getInt("otherCategory") != 0) {
			crit = crit.createAlias("OtherCategory", "pt1").add(
					Restrictions.eq("pt1.Id", box.getInt("otherCategory")));
		}
		
			

//		if (box.getInt("patientTypeSearch") != 0) {
//			crit = crit.createAlias("PatientType", "pt").add(
//					Restrictions.eq("pt.Id", box.getInt("patientTypeSearch")));
//		}
		
		if (!box.getString("patientCatSearch").equals("")) {
			crit = crit.add(Restrictions.eq("PatientCategory",
					box.getString("patientCatSearch").toLowerCase()).ignoreCase());
		}
		if (box.getInt("billTypeSearch") != 0) {
			crit = crit.createAlias("BillType", "bl").add(
					Restrictions.eq("bl.Id", box.getInt("billTypeSearch")));
		}
		/*if (box.getInt("itemSearch") != 0) {
			crit = crit.createAlias("Item", "it").add(
					Restrictions.eq("it.Id", box.getInt("itemSearch")));
		}
		if (box.getInt("mainChargeSearch") != 0) {
			crit = crit.createAlias("MainChargecode", "mcc").add(
					Restrictions.eq("mcc.Id", box.getInt("mainChargeSearch")));
		}
		if (box.getInt("subChargeSearch") != 0) {
			crit = crit.createAlias("SubChargecode", "scc").add(
					Restrictions.eq("scc.Id", box.getInt("subChargeSearch")));
		}
		if (box.getInt("chargeCodeSearch") != 0) {
			crit = crit.createAlias("ChargeCode", "cc").add(
					Restrictions.eq("cc.Id", box.getInt("chargeCodeSearch")));
		}*/

		discountList = crit.list();
	
		groupList =session.createCriteria(MasStoreGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		patientTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("PatientTypeName"))
				.list();
		companyList = session.createCriteria(MasCompany.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		billTypeList = session.createCriteria(MasBillType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.or(Restrictions.eq("BillTypeCode",billtypeservic.toLowerCase()).ignoreCase(),
						Restrictions.eq("BillTypeCode", billtypedispensing.toLowerCase()).ignoreCase()))
						.addOrder(Order.asc("BillTypeName")).list();
		roomTypeList = session.createCriteria(MasRoomType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		mainChargeCodeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("MainChargecodeName")).list();
		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("SubChargecodeName")).list();
		ChargeCodeList = session
				.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("ChargeCodeName"))
								.add(Projections.property("Id"))
								.add(Projections.property("SubChargecode.Id"))
								.add(Projections.property("MainChargecode.Id")))
				.addOrder(Order.asc("ChargeCodeCode")).list();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		employeeDependentList = session
				.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		accountList = session.createCriteria(FaMasAccount.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		/*String qry = "";
		qry = "Select item_id,nomenclature from mas_store_item where status='y' ";
		storeItemList = session.createSQLQuery(qry).list();*/
		
		/*storeItemList = getHibernateTemplate().find("select item.Id ,"
				+ " item.Nomenclature from jkt.hms.masters.business.MasStoreItem item "
				+ "where item.Status = 'y' group by item.Id , item.Nomenclature "
				+ "order by item.Nomenclature ");*/

		
		patientTypeForSocialCategory=session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Type", "s").ignoreCase()).list();
		
		patientTypeForOtherCategory=session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Type", "o").ignoreCase()).list();
		
		schemeList=session.createCriteria(MasScheme.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		
		departments=session
				.createCriteria(MasDepartment.class,"msd")
				.createAlias("msd.DepartmentType", "mdt")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", mas_department_type_ward))
				.list();
		
		
		
		map.put("patientTypeList", patientTypeList);
		map.put("companyList", companyList);
		map.put("billTypeList", billTypeList);
		map.put("roomTypeList", roomTypeList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("subChargeCodeList", subChargeCodeList);
		map.put("ChargeCodeList", ChargeCodeList);
		map.put("employeeList", employeeList);
		map.put("employeeDependentList", employeeDependentList);
		map.put("accountList", accountList);
		map.put("storeItemList", storeItemList);
		map.put("discountList", discountList);
		
		map.put("patientTypeForSocialCategory", patientTypeForSocialCategory);
		map.put("patientTypeForOtherCategory", patientTypeForOtherCategory);
		map.put("groupList", groupList);
		map.put("schemeList", schemeList);
		map.put("departments", departments);		
		return map;
		/*
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();

		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasBillType> billTypeList = new ArrayList<MasBillType>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<Object[]> ChargeCodeList = new ArrayList<Object[]>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<Object[]> storeItemList = new ArrayList<Object[]>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		
		int hospitalTypeId = 0;
		int hospitalId = 0;
		Session session = getSession();
		Criteria crit = null;
		
		
		hospitalTypeId = box.getInt("instTypeId");
		hospitalId = box.getInt("hospitalId");
		int sessionHospitalId = box.getInt("sessionHospitalId");
		
		crit = session.createCriteria(MasDiscount.class);
		
		if (hospitalId != 0) {
			crit = crit.add(Restrictions.eq("Hospital.Id", hospitalId));

		} else {
			crit = crit.add(Restrictions.eq("Hospital.Id", sessionHospitalId));
		}
		
		if (box.getInt("patientTypeSearch") != 0) {
			System.out.println("box.getIn   adfas    "+box.getInt("patientTypeSearch"));
			crit = crit.createAlias("PatientType", "pt").add(
					Restrictions.eq("pt.Id", box.getInt("patientTypeSearch")));
		}
		if (box.getInt("companySearch") != 0) {
			crit = crit.createAlias("Company", "com").add(
					Restrictions.eq("com.Id", box.getInt("companySearch")));
		}
		if (box.getInt("employeeSearch") != 0) {
			crit = crit.createAlias("Employee", "emp").add(
					Restrictions.eq("emp.Id", box.getInt("employeeSearch")));
		}
		if (box.getInt("empDependentSearch") != 0) {
			crit = crit.createAlias("EmployeeDependent", "ed").add(
					Restrictions.eq("ed.Id", box.getInt("empDependentSearch")));
		}
		if (box.getInt("projectSearch") != 0) {
			crit = crit.createAlias("Company", "com").add(
					Restrictions.eq("com.Id", box.getInt("projectSearch")));
		}
		if (!box.getString("patientCatSearch").equals("")) {
			System.out.println("box.getIn   rrrrrrrrrr	    "+box.getString("patientCatSearch"));
			crit = crit.add(Restrictions.eq("PatientCategory",
					box.getString("patientCatSearch")));
		}
		if (box.getInt("billTypeSearch") != 0) {
			crit = crit.createAlias("BillType", "bl").add(
					Restrictions.eq("bl.Id", box.getInt("billTypeSearch")));
		}
		if (box.getInt("itemSearch") != 0) {
			crit = crit.createAlias("Item", "it").add(
					Restrictions.eq("it.Id", box.getInt("itemSearch")));
		}
		if (box.getInt("mainChargeSearch") != 0) {
			crit = crit.createAlias("MainChargecode", "mcc").add(
					Restrictions.eq("mcc.Id", box.getInt("mainChargeSearch")));
		}
		if (box.getInt("subChargeSearch") != 0) {
			crit = crit.createAlias("SubChargecode", "scc").add(
					Restrictions.eq("scc.Id", box.getInt("subChargeSearch")));
		}
		if (box.getInt("chargeCodeSearch") != 0) {
			crit = crit.createAlias("ChargeCode", "cc").add(
					Restrictions.eq("cc.Id", box.getInt("chargeCodeSearch")));
		}

		discountList = crit.list();

		patientTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		companyList = session.createCriteria(MasCompany.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		billTypeList = session.createCriteria(MasBillType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		roomTypeList = session.createCriteria(MasRoomType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		mainChargeCodeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		// ChargeCodeList =
		// session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status",
		// "y")).list();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		employeeDependentList = session
				.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		accountList = session.createCriteria(FaMasAccount.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		// storeItemList =
		// session.createCriteria(MasStoreItem.class).add(Restrictions.eq("Status",
		// "y")).list();
		ChargeCodeList = session
				.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y"))
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("ChargeCodeName"))
								.add(Projections.property("Id"))
								.add(Projections.property("SubChargecode.Id"))
								.add(Projections.property("MainChargecode.Id")))
				.list();

		String qry = "";
		qry = "Select item_id,nomenclature from mas_store_item where status='y' ";

		storeItemList = session.createSQLQuery(qry).list();

		map.put("patientTypeList", patientTypeList);
		map.put("companyList", companyList);
		map.put("billTypeList", billTypeList);
		map.put("roomTypeList", roomTypeList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("subChargeCodeList", subChargeCodeList);
		map.put("ChargeCodeList", ChargeCodeList);
		map.put("employeeList", employeeList);
		map.put("employeeDependentList", employeeDependentList);
		map.put("accountList", accountList);
		map.put("storeItemList", storeItemList);

		map.put("discountList", discountList);

		return map;*/
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDiscountDetailsForEdit(int discountId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiscount> disList = new ArrayList<MasDiscount>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();

		Session session = getSession();
		disList = session.createCriteria(MasDiscount.class)
				.add(Restrictions.eq("Id", discountId)).list();

		/*
		 * List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		 */
		// newly added

		List<MasScheme> schemeList = new ArrayList<MasScheme>();
		List<MasPatientType> patientTypeForSocialCategory = new ArrayList<MasPatientType>();
		List<MasPatientType> patientTypeForOtherCategory = new ArrayList<MasPatientType>();
		List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
		List<MasDepartment> departments = new ArrayList<MasDepartment>();

		// end of newly ended

		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasBillType> billTypeList = new ArrayList<MasBillType>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<Object[]> ChargeCodeList = new ArrayList<Object[]>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
		List<Object[]> storeItemList = new ArrayList<Object[]>();
		List<Object[]> departmentList = new ArrayList<Object[]>(); // added by amit das on 19-05-2016
		List<Object[]> subChargeCodeArray = new ArrayList<Object[]>(); // added by amit das on 19-05-2016
		List<Integer> employeeArray = new ArrayList<Integer>(); // added by amit das on 19-05-2016
		
		List<Object[]> itemList = new ArrayList<Object[]>();
		List<Object[]> chargeCodeList=new ArrayList<Object[]>();
		MasDepartment masDepartment = null; // added by amit das on 19-05-2016
		MasSubChargecode masSubChargecode  = null; // added by amit das on 19-05-2016
		MasEmployee masEmployee  = null; // added by amit das on 19-05-2016
		
		List<MasDiscountExclude> discountExcludeList = new ArrayList<MasDiscountExclude>();
		List<MasDiscountDiagnosis> diagnosiList = new ArrayList<MasDiscountDiagnosis>();



		String billtypedispensing = "";
		String billtypeservic = "";
		java.net.URL resourcePath = Thread.currentThread()
				.getContextClassLoader().getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop.getProperty("billtypedispensing");
			billtypeservic = prop.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}

		String mas_department_type_ward = null;
		resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mas_department_type_ward = prop
					.getProperty("mas_department_type_ward");
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * discountList = session.createCriteria(MasDiscount.class).list();
		 */
		groupList = session.createCriteria(MasStoreGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		patientTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("PatientTypeName")).list();
		companyList = session.createCriteria(MasCompany.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		billTypeList = session
				.createCriteria(MasBillType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.or(
						Restrictions.eq("BillTypeCode",
								billtypeservic.toLowerCase()).ignoreCase(),
						Restrictions.eq("BillTypeCode",
								billtypedispensing.toLowerCase()).ignoreCase()))
				.addOrder(Order.asc("BillTypeName")).list();
		roomTypeList = session.createCriteria(MasRoomType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		mainChargeCodeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("MainChargecodeName")).list();
		
		
		if (disList.size() > 0) {
			MasDiscount discount = disList.get(0);
			if (discount.getMainChargecode() != null) {
				
				subChargeCodeArray = session
						.createCriteria(MasSubChargecode.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("MainChargecode.Id", discount
								.getMainChargecode().getId()))
						.addOrder(Order.asc("SubChargecodeName")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SubChargecodeName"))).list();
				
				if(subChargeCodeArray!=null && subChargeCodeArray.size()>0){
					for(Object[] objects : subChargeCodeArray){	
						masSubChargecode = new MasSubChargecode();
						masSubChargecode.setId((Integer)objects[0]);
						masSubChargecode.setSubChargecodeName((String)objects[1]);
						subChargeCodeList.add(masSubChargecode);
					}
				}
			}
		}

		if (disList.size() > 0) {
			MasDiscount discount = disList.get(0);
			if (discount.getSubChargecode() != null) {

				ChargeCodeList = session
						.createCriteria(MasChargeCode.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("SubChargecode.Id", discount
								.getSubChargecode().getId()))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.property("ChargeCodeName"))
										.add(Projections.property("Id"))
										.add(Projections
												.property("SubChargecode.Id"))
										.add(Projections
												.property("MainChargecode.Id")))
						.addOrder(Order.asc("ChargeCodeCode")).list();
			}
		}
		
		if (disList.size() > 0) {
			MasDiscount discount = disList.get(0);
		if(discount.getChargeCode()!=null)
		{
			
		}
		else if(discount.getSubChargecode()!=null)
		{
			chargeCodeList=session.createCriteria(MasChargeCode.class)
					.createAlias("SubChargecode", "subcharge")
					.createAlias("subcharge.MainChargecode", "mainCharge")
					.add(Restrictions.eq("subcharge.Id",discount.getSubChargecode().getId()))
					.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.property("ChargeCodeName"))
										.add(Projections.property("Id"))
										.add(Projections
												.property("subcharge.Id"))
										.add(Projections
												.property("mainCharge.Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		}
		else if(discount.getMainChargecode()!=null)
		{
			chargeCodeList=session.createCriteria(MasChargeCode.class)
					.createAlias("SubChargecode", "subcharge")
					.createAlias("subcharge.MainChargecode", "mainCharge")
					.add(Restrictions.eq("mainCharge.Id", discount.getMainChargecode().getId()))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.property("ChargeCodeName"))
										.add(Projections.property("Id"))
										.add(Projections
												.property("subcharge.Id"))
										.add(Projections
												.property("mainCharge.Id")))
						.addOrder(Order.asc("ChargeCodeCode"))
					.list();
		}
		}
		
		

		employeeArray = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.projectionList().add(Projections.property("Id"))).list();
		if(employeeArray!=null && employeeArray.size()>0){
			for(Integer id : employeeArray){
				masEmployee = new MasEmployee();
				masEmployee.setId(id);
				employeeList.add(masEmployee);
			}
		}
		
		
		employeeDependentList = session
				.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		accountList = session.createCriteria(FaMasAccount.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasItemCategory> categorieList = new ArrayList<MasItemCategory>();
		List<MasItemClass> itemClasseList = new ArrayList<MasItemClass>();

		//groupList = session.createCriteria(MasStoreGroup.class)
			//	.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (disList.size() > 0) {
			MasDiscount discount = disList.get(0);
			if (discount.getGroup() != null) {
				itemTypeList = session
						.createCriteria(MasItemType.class)
						.add(Restrictions.eq("Group.Id", discount.getGroup()
								.getId()))
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();
				if (discount.getItemType() != null) {
					/*sectionList = session
							.createCriteria(MasStoreSection.class)
							.add(Restrictions.eq("ItemType.Id", discount
									.getItemType().getId()))
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.list();*/  // commented by amit das on 19-05-2016

					if (discount.getItemSection() != null) {
						/*categorieList = session
								.createCriteria(MasItemCategory.class)
								.add(Restrictions.eq("Section.Id", discount
										.getItemSection().getId()))
								.add(Restrictions.eq("Status", "y")
										.ignoreCase()).list();*/ // commented by amit das on 19-05-2016

						itemClasseList = session
								.createCriteria(MasItemClass.class)
								.add(Restrictions.eq("Section.Id", discount
										.getItemSection().getId()))
								.add(Restrictions.eq("Status", "y")
										.ignoreCase()).list();

						if (discount.getItemCategory() != null
								&& discount.getItemClass() != null) {
							Criteria criteria = session
									.createCriteria(MasStoreItem.class)
									.add(Restrictions.eq("Status", "y")
											.ignoreCase())
									.add(Restrictions
											.eq("ItemClass.Id", discount
													.getItemClass().getId()))
									.add(Restrictions
											.eq("ItemCategory.Id", discount
													.getItemCategory().getId()))
									.setProjection(
											Projections
													.projectionList()
													.add(Projections.property("Id"))
										.add(Projections
												.property("Nomenclature")))
									.addOrder(Order.asc("Nomenclature"));
							storeItemList = criteria.list();

						}

					}
				}
			}

		}

		
		if (disList.size() > 0) {
			MasDiscount discount = disList.get(0);
			if (discount.getGroup() != null) {
		Criteria criteria=session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("Status", "y")
						.ignoreCase())
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.property("Id"))
					.add(Projections
							.property("Nomenclature")));
		if(discount.getItemCategory()!=null && discount.getItemClass()!=null)
		{
			criteria.createAlias("ItemClass", "itemClass")
			.createAlias("ItemCategory", "itemCategory")
			.add(Restrictions.eq("itemClass.Id", discount.getItemClass().getId()))
			.add(Restrictions.eq("itemCategory.Id", discount.getItemCategory().getId()));
		}
		else if(discount.getItemClass()!=null)
		{
			criteria.createAlias("ItemClass", "itemClass")
			.add(Restrictions.eq("itemClass.Id", discount.getItemClass().getId()));
		}
		else if(discount.getItemCategory()!=null)
		{
			criteria.createAlias("ItemCategory", "itemCategory")
			.add(Restrictions.eq("itemCategory.Id", discount.getItemCategory().getId()));
		}
		else if(discount.getItemSection()!=null)
		{
			criteria.createAlias("Section", "section")
			.add(Restrictions.eq("section.Id", discount.getItemSection().getId()));
		}
		else if(discount.getItemType()!=null)
		{
			criteria.createAlias("ItemType", "itemType")
			.add(Restrictions.eq("itemType.Id", discount.getItemType().getId()));
		}
		else
		{
			criteria.createAlias("Group", "group")
			.add(Restrictions.eq("group.Id", discount.getGroup().getId()));
		}
		criteria.addOrder(Order.asc("Nomenclature"));
				
		itemList=criteria.list();
		}
		}
		
//		public static String REF = "MasDiscountExclude";
//		public static String PROP_STATUS = "Status";
//		public static String PROP_ITEM = "Item";
//		public static String PROP_ID = "Id";
//		public static String PROP_DISCOUNT = "Discount";
//		public static String PROP_CHARGE = "Charge";
		
		if (disList.size() > 0) {
			MasDiscount discount = disList.get(0);
			discountExcludeList=session.createCriteria(MasDiscountExclude.class)
					.add(Restrictions.eq("Discount.Id", discount.getId()))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			diagnosiList=session.createCriteria(MasDiscountDiagnosis.class)
					.add(Restrictions.eq("Discount.Id", discount.getId()))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
					           
					
		}

		patientTypeForSocialCategory = session
				.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Type", "s").ignoreCase()).list();

		patientTypeForOtherCategory = session
				.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Type", "o").ignoreCase()).list();

		schemeList = session.createCriteria(MasScheme.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		// changed by amit das on 19-05-2016
		departmentList = session
				.createCriteria(MasDepartment.class, "msd")
				.createAlias("msd.DepartmentType", "mdt")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode",
						mas_department_type_ward)).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("DepartmentName"))).list();
		
		if(departmentList!=null && departmentList.size()>0){
			for(Object[] objects : departmentList){
				masDepartment = new MasDepartment();
				masDepartment.setId((Integer)objects[0]);
				masDepartment.setDepartmentName((String)objects[1]);
				departments.add(masDepartment);
			}
		}
		
		
		map.put("patientTypeList", patientTypeList);
		map.put("companyList", companyList);
		map.put("billTypeList", billTypeList);
		map.put("roomTypeList", roomTypeList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("subChargeCodeList", subChargeCodeList);
		map.put("ChargeCodeList", ChargeCodeList);
		map.put("employeeList", employeeList);
		map.put("employeeDependentList", employeeDependentList);
		map.put("accountList", accountList);
		map.put("storeItemList", storeItemList);
		/*
		 * map.put("discountList", discountList);
		 */
		map.put("patientTypeForSocialCategory", patientTypeForSocialCategory);
		map.put("patientTypeForOtherCategory", patientTypeForOtherCategory);
		map.put("groupList", groupList);
		map.put("schemeList", schemeList);
		map.put("departments", departments);
		map.put("disList", disList);
		map.put("accountList", accountList);
		
		map.put("groupList", groupList);
		map.put("itemTypeList", itemTypeList);
		map.put("sectionList", sectionList);
		map.put("categorieList", categorieList);
		map.put("itemClasseList", itemClasseList);
		map.put("itemList", itemList);
		map.put("chargeCodeList", chargeCodeList);
		
		map.put("discountExcludeList", discountExcludeList);
		map.put("diagnosiList", diagnosiList);


		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editDiscountDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Session session = getSession();
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String message="";
		int hospitalId = box.getInt(HOSPITAL_ID);
		int deptId = box.getInt(DEPT_ID);
		int userId = box.getInt(USER_ID);
		int empId = box.getInt("empId");
		Transaction transaction = null;
		try {

			String billtypedispensing = "";
			String billtypeservic = "";
			java.net.URL resourcePath = Thread.currentThread()
					.getContextClassLoader().getResource("account.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				billtypedispensing = prop.getProperty("billtypedispensing");
				billtypeservic = prop.getProperty("billtypeservic");
			} catch (IOException e) {
				e.printStackTrace();
			}

			transaction = session.beginTransaction();
			MasDiscount masDiscount = (MasDiscount) hbt.load(MasDiscount.class,
					box.getInt("discountId"));

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			masDiscount.setHospital(masHospital);
			if (box.getInt("schemeId") != 0) {
				MasScheme scheme = new MasScheme();
				scheme.setId(box.getInt("schemeId"));
				masDiscount.setScheme(scheme);
			}
			else
			{
				masDiscount.setScheme(null);
			}

			if (box.getString("bplStatus").equalsIgnoreCase("bpl")) {
				masDiscount.setBplStatus("y");
			} else if (box.getString("bplStatus").equalsIgnoreCase("apl")) {
				masDiscount.setBplStatus("n");
			} else {
				masDiscount.setBplStatus(null);
			}

			if (box.getInt("patientTypeId") != 0) {
				MasPatientType socialcategory = new MasPatientType();
				socialcategory.setId(box.getInt("patientTypeId"));
				masDiscount.setPatientType(socialcategory);
			}
			else
			{
				masDiscount.setPatientType(null);
			}

			if (box.getInt("otherCategory") != 0) {
				MasPatientType socialcategory = new MasPatientType();
				socialcategory.setId(box.getInt("otherCategory"));
				masDiscount.setOtherCategory(socialcategory);
			}
			else
			{
				masDiscount.setOtherCategory(null);
			}

			if (!box.getString(PATIENT_CATEGORY).equalsIgnoreCase("")
					&& !box.getString(PATIENT_CATEGORY).equalsIgnoreCase("0")) {
				String patientCategory = box.getString(PATIENT_CATEGORY);
				masDiscount.setPatientCategory(patientCategory);
				if (patientCategory.equalsIgnoreCase("ip")
						&& box.getInt(DEPARTMENT_ID) != 0) {
					int departmentId = box.getInt(DEPARTMENT_ID);
					if(departmentId!=0)
					{
					MasDepartment department = new MasDepartment();
					department.setId(box.getInt(DEPARTMENT_ID));
					masDiscount.setDepartment(department);
					}
					else
					{
						masDiscount.setDepartment(null);
					}
					if(box.getInt(ROOM_TYPE_ID)!=0)
					{
					MasRoomType masRoom=new MasRoomType();
					masRoom.setId(box.getInt(ROOM_TYPE_ID));
					masDiscount.setRoomType(masRoom);
					}
					else
					{
						masDiscount.setRoomType(null);

					}
					// need to set department
				}
				else
				{
					masDiscount.setDepartment(null);
					masDiscount.setRoomType(null);

				}
			}
			else
			{
				masDiscount.setPatientCategory(null);
			}

			List<MasDiscountExclude> discountExcludeList=new ArrayList<MasDiscountExclude>();
			List<MasDiscountDiagnosis> diagnosiList=new ArrayList<MasDiscountDiagnosis>();
			
			discountExcludeList=session.createCriteria(MasDiscountExclude.class)
			.add(Restrictions.eq("Discount.Id", masDiscount.getId()))
			.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			for (MasDiscountExclude masDiscountExclude : discountExcludeList) {
				masDiscountExclude.setStatus("n");						
			}
	
	diagnosiList=session.createCriteria(MasDiscountDiagnosis.class)
			.add(Restrictions.eq("Discount.Id", masDiscount.getId()))
			.add(Restrictions.eq("Status", "y").ignoreCase()).list();
	
	for (MasDiscountDiagnosis masDiscountDiagnosis : diagnosiList) {
		masDiscountDiagnosis.setStatus("n");
	}
	
			if (box.getInt(BILL_TYPE_ID) != 0) {
				MasBillType billType = (MasBillType) hbt.get(MasBillType.class,
						box.getInt(BILL_TYPE_ID));
				masDiscount.setBillType(billType);
				masDiscount.setMainChargecode(null);
				masDiscount.setSubChargecode(null);
				masDiscount.setChargeCode(null);
				masDiscount.setGroup(null);
				masDiscount.setItemType(null);
				masDiscount.setItemSection(null);
				masDiscount.setItemCategory(null);
				masDiscount.setItemClass(null);
				masDiscount.setItem(null);
				if (billType.getBillTypeCode().equalsIgnoreCase(
						billtypedispensing)) {
					
					
					
					if (box.getInt(GROUP_ID) != 0) {
						MasStoreGroup group = new MasStoreGroup();
						group.setId(box.getInt(GROUP_ID));
						masDiscount.setGroup(group);
						if (box.getInt(ITEM_TYPE) != 0) {
							MasItemType itemType = new MasItemType();
							itemType.setId(box.getInt(ITEM_TYPE));
							masDiscount.setItemType(itemType);
							if (box.getInt(SECTION_ID) != 0) {
								MasStoreSection storeSection = new MasStoreSection();
								storeSection.setId(box.getInt(SECTION_ID));
								masDiscount.setItemSection(storeSection);
								if (box.getInt(ITEM_CATEGORY_ID) != 0) {
									MasItemCategory itemCategory = new MasItemCategory();
									itemCategory.setId(box
											.getInt(ITEM_CATEGORY_ID));
									masDiscount.setItemCategory(itemCategory);
								} else {
									masDiscount.setItemCategory(null);
								}

								if (box.getInt(ITEM_CLASS_ID) != 0) {
									MasItemClass itemClass = new MasItemClass();
									itemClass.setId(box.getInt(ITEM_CLASS_ID));
									masDiscount.setItemClass(itemClass);
								} else {
									masDiscount.setItemClass(null);
								}

								if (box.getInt("drug") != 0) {
									MasStoreItem item = new MasStoreItem();
									item.setId(box.getInt("drug"));
									masDiscount.setItem(item);
								} else {
									masDiscount.setItem(null);
								}
							} else {
								masDiscount.setItemSection(null);
								masDiscount.setItemCategory(null);
								masDiscount.setItemClass(null);
								masDiscount.setItem(null);
							}
						} else {
							masDiscount.setItemType(null);
							masDiscount.setItemSection(null);
							masDiscount.setItemCategory(null);
							masDiscount.setItemClass(null);
							masDiscount.setItem(null);
						}

						Vector<String> chargeList = box
								.getVector("excludeitemId");
						if (chargeList != null && chargeList.size() > 0) {
							for (String chargeId : chargeList) {
								MasDiscountExclude discountExclude=null;
								int id=Integer.parseInt(chargeId);
								for (MasDiscountExclude masDiscountExclude : discountExcludeList) {
									if(masDiscountExclude.getItem()!=null && masDiscountExclude.getItem().getId()==id)
									{
										discountExclude=masDiscountExclude;
										break;
									}
								}
								if(discountExclude!=null)
								{
									discountExclude.setStatus("y");
									hbt.update(discountExclude);
								}
								else
								{
									 discountExclude = new MasDiscountExclude();
									discountExclude.setDiscount(masDiscount);
									MasStoreItem item = new MasStoreItem();
									item.setId(id);
									discountExclude.setItem(item);
									discountExclude.setStatus("y");
									hbt.save(discountExclude);
								}
								
								
							}
						}
					} else {
						masDiscount.setGroup(null);
						masDiscount.setItemType(null);
						masDiscount.setItemSection(null);
						masDiscount.setItemCategory(null);
						masDiscount.setItemClass(null);
						masDiscount.setItem(null);

					}

				} else if (billType.getBillTypeCode().equalsIgnoreCase(
						billtypeservic)) {
					
					
					if (box.getInt(MAIN_CHARGECODE_ID) != 0) {
						int mainchargeCodeId = box.getInt(MAIN_CHARGECODE_ID);
						MasMainChargecode mainChargecode = new MasMainChargecode();
						mainChargecode.setId(mainchargeCodeId);
						masDiscount.setMainChargecode(mainChargecode);

						if (box.getInt(SUB_CHARGECODE_ID) != 0) {
							MasSubChargecode subChargecode = new MasSubChargecode();
							subChargecode.setId(box.getInt(SUB_CHARGECODE_ID));
							masDiscount.setSubChargecode(subChargecode);
							if (box.getInt(CHARGE_CODE_ID) != 0) {
								MasChargeCode chargeCode = new MasChargeCode();
								chargeCode.setId(box.getInt(CHARGE_CODE_ID));
								masDiscount.setChargeCode(chargeCode);
							} else {
								masDiscount.setChargeCode(null);
							}
						} else {
							masDiscount.setSubChargecode(null);
							masDiscount.setChargeCode(null);
						}
						
						Vector<String> chargeList = box.getVector("excludechargeId");
						if (chargeList != null && chargeList.size() > 0) {
							for (String chargeId : chargeList) {
								MasDiscountExclude discountExclude=null;
								int id=Integer.parseInt(chargeId);
								for (MasDiscountExclude masDiscountExclude : discountExcludeList) {
									if(masDiscountExclude.getItem()!=null && masDiscountExclude.getItem().getId()==id)
									{
										discountExclude=masDiscountExclude;
										break;
									}
								}
								if(discountExclude!=null)
								{
									discountExclude.setStatus("y");
									hbt.update(discountExclude);
								}
								else
								{
									discountExclude = new MasDiscountExclude();
									discountExclude.setDiscount(masDiscount);
									MasChargeCode chargeCode = new MasChargeCode();
									chargeCode.setId(id);
									discountExclude.setCharge(chargeCode);
									discountExclude.setStatus("y");
									hbt.save(discountExclude);
								}
								
							}
						}
					} else {
						masDiscount.setMainChargecode(null);
					}
					
					
				}

			}

			if (box.getInt("fromAge") != 0) {
				masDiscount.setFromAge(new BigDecimal(box.getInt("fromAge")));
				if (box.getInt("toAge") != 0) {
					masDiscount.setToAge(new BigDecimal(box.getInt("toAge")));
				}
				else
				{
					masDiscount.setToAge(null);
				}
			}
			else
			{
				masDiscount.setFromAge(null);
					masDiscount.setToAge(null);
			}

			if (!box.getString(EFFECTIVE_DATE_FROM).equals("")) {
				Date effectiveDateFrom = HMSUtil.dateFormatterDDMMYYYY(box
						.getString(EFFECTIVE_DATE_FROM));
				masDiscount.setEffectiveDateFrom(effectiveDateFrom);
				if (!box.getString(EFFECTIVE_DATE_TO).equals("")) {
					Date effectiveDateTo = HMSUtil.dateFormatterDDMMYYYY(box
							.getString(EFFECTIVE_DATE_TO));
					masDiscount.setEffectiveDateTo(effectiveDateTo);
				}
				else
				{
					masDiscount.setEffectiveDateTo(null);
				}
			}
			else
			{
				masDiscount.setEffectiveDateTo(null);
				masDiscount.setEffectiveDateTo(null);
			}

			if (!box.getString(DISCOUNT_TYPE).equalsIgnoreCase("")
					&& !box.getString(DISCOUNT_TYPE).equalsIgnoreCase("0")) {
				String discountType = box.getString(DISCOUNT_TYPE);
				masDiscount.setDiscountType(discountType);
				masDiscount.setDiscountPercentage(null);
				masDiscount.setDiscountValue(null);
				masDiscount.setFixedValue(null);
				if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("d")) {
					if (box.getInt(DISCOUNT_PERCENTAGE) != 0) {
						masDiscount.setDiscountPercentage(new BigDecimal(box
								.getInt(DISCOUNT_PERCENTAGE)));
					} else if (box.getFloat(DISCOUNT_VALUE) != 0) {
						masDiscount
								.setDiscountValue(new BigDecimal(box.getFloat(DISCOUNT_VALUE)));
					}
				} else if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("t")) {
					if (box.getInt(DISCOUNT_PERCENTAGE) != 0) {
						masDiscount.setDiscountPercentage(new BigDecimal(box
								.getInt(DISCOUNT_PERCENTAGE)));
					} else if (box.getFloat(DISCOUNT_VALUE) != 0) {
						masDiscount
								.setDiscountValue(new BigDecimal(box.getFloat(DISCOUNT_VALUE)));
					}
				} else if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("f")) {
					if (box.getFloat(DISCOUNT_VALUE) != 0) {
				     //  masDiscount.setFixedValue(new BigDecimal(box.getFloat(DISCOUNT_VALUE))); //commented by amit das on 02-06-2017
						masDiscount.setDiscountValue(new BigDecimal(box.getFloat(DISCOUNT_VALUE))); //added by amit das on 02-06-2017
					}
				}
			}

			if (box.getInt(ACCOUNT_ID) != 0) {
				int accountId = box.getInt(ACCOUNT_ID);
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(accountId);
				masDiscount.setAccountId(accountId);
			}
			else
			{
				masDiscount.setAccountId(null);

			}
			
			Vector<String> diagnosisList = box.getVector(DIAGNOSIS_ID);
			System.out.println("diagonesList"+diagnosisList.size());
			if (diagnosisList != null && diagnosisList.size() > 0) {
				for (String diagnosisid : diagnosisList) {
					System.out.println("diagonesList"+diagnosisid);
					MasDiscountDiagnosis discountDiagnosis=null;
					int id=Integer.parseInt(diagnosisid);
					for (MasDiscountDiagnosis masDiscountDiagnosis : diagnosiList) {
						if(masDiscountDiagnosis.getIcd()!=null && masDiscountDiagnosis.getIcd().getId()==id)
						{
							discountDiagnosis=masDiscountDiagnosis;
							break;
						}
					}
					if(discountDiagnosis!=null)
					{
						discountDiagnosis.setStatus("y");
						hbt.update(discountDiagnosis);
					}
					else
					{
						 discountDiagnosis = new MasDiscountDiagnosis();
						discountDiagnosis.setDiscount(masDiscount);
						MasIcd masIcd=new MasIcd();
						masIcd.setId(id);
						discountDiagnosis.setIcd(masIcd);
						discountDiagnosis.setStatus("y");
						hbt.save(discountDiagnosis);
					}
					
				
					
					
				}
			}

			/*
			 * if (request.getParameter(CHANGED_BY) != null &&
			 * !(request.getParameter(CHANGED_BY).equals(""))) { String
			 * changedBy = request.getParameter(CHANGED_BY);
			 * masDiscount.setLastChgBy(changedBy); }
			 */
			Map<String, Object> utilMap = new HashMap<String, Object>();

			utilMap = HMSUtil.getCurrentDateAndTime();

			Users user = new Users();
			user.setId(userId);
			masDiscount.setLastChgBy(user);

			Date currentDate = HMSUtil.dateFormatterDDMMYYYY((String) utilMap
					.get("currentDate"));
			masDiscount.setLastChgDate(currentDate);

			String currentTime = (String) utilMap.get("currentTime");
			masDiscount.setLastChgTime(currentTime);

			masDiscount.setStatus("y");

			hbt.save(masDiscount);
			transaction.commit();
			hbt.flush();
			hbt.clear();
			dataSaved = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (dataSaved) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}
		//map = showDiscountJsp();
		map.put("message", message);
		return map;
		
		/*boolean dataSaved = false;
		BigDecimal discountValue = new BigDecimal(0);
		BigDecimal fixedValue = new BigDecimal(0);
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			MasDiscount discount = (MasDiscount) hbt.load(MasDiscount.class,
					box.getInt("discountId"));

			if (!box.getString(EFFECTIVE_DATE_TO).equals("")) {
				discount.setEffectiveDateTo(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(EFFECTIVE_DATE_TO)));
			}
			discount.setDiscountType(box.getString(DISCOUNT_TYPE));
			
			if (!box.getString(DISCOUNT_PERCENTAGE).equals("")) {
				discount.setDiscountPercentage(new BigDecimal(box
						.getString(DISCOUNT_PERCENTAGE)));
			}

			if(!box.getString(DISCOUNT_TYPE).equalsIgnoreCase("F"))
			{
				if (box.getString(DISCOUNT_VALUE) != null
						&& !box.getString(DISCOUNT_VALUE).equals("")) {
					discountValue = new BigDecimal(box.getString(DISCOUNT_VALUE));
				}
				else
				{
					discountValue = new BigDecimal(0);
				}
				discount.setDiscountValue(discountValue);
			}	
			
			if(box.getString(DISCOUNT_TYPE) != null && 
			   !box.getString(DISCOUNT_TYPE).equals(""))
			{
				if(box.getString(DISCOUNT_TYPE).equalsIgnoreCase("F"))
				{
					if (box.getString(DISCOUNT_VALUE) != null
							&& !box.getString(DISCOUNT_VALUE).equals("")) {
						fixedValue = new BigDecimal(box.getString(DISCOUNT_VALUE));
					}
					else
					{
						fixedValue = new BigDecimal(0);
					}
					discount.setFixedValue(fixedValue);
				}
			}
							
			if (box.getInt(ACCOUNT_ID) != 0) {
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt(ACCOUNT_ID));
				discount.setAccount(masAccount);
			}
		
			hbt.update(discount);
			dataSaved = true;

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		String message = "";
		if (dataSaved) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}
		map = showDiscountJsp();
		map.put("message", message);
		return map;*/
	}

	@SuppressWarnings("unchecked")
	public List<MasDiscount> checkExistingDiscountDetails(
			Map<String, Object> parameterMap,Box box) {
		List<MasDiscount> existingMasDiscountList = new ArrayList<MasDiscount>();
		/*Session session = (Session) getSession();
		int patientTypeId = 0;
		int companyId = 0;
		String patientCategory = "";
		int billTypeId = 0;
		int drugId = 0;
		Date effectiveDateFrom = new Date();
		Date effectiveDateTo = new Date();
		int chargeCodeId = 0;
		int roomTypeId = 0;
		int mainchargeCodeId = 0;
		int subChargeCodeId = 0;

		Criteria crit = null;
		if (parameterMap.get("effectiveDateFrom") != null) {
			effectiveDateFrom = (Date) parameterMap.get("effectiveDateFrom");
		}
		if (parameterMap.get("effectiveDateTo") != null) {
			effectiveDateTo = (Date) parameterMap.get("effectiveDateTo");
		}

		crit = session.createCriteria(MasDiscount.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.le("EffectiveDateFrom", effectiveDateFrom));

		if (parameterMap.get("patientTypeId") != null) {
			patientTypeId = (Integer) parameterMap.get("patientTypeId");
			crit = crit.createAlias("PatientType", "pt").add(
					Restrictions.eq("pt.Id", patientTypeId));
		}
		if (parameterMap.get("companyId") != null) {
			companyId = (Integer) parameterMap.get("companyId");
			crit = crit.createAlias("Company", "c").add(
					Restrictions.eq("c.Id", companyId));
		}
		if (parameterMap.get("patientCategory") != null) {
			patientCategory = (String) parameterMap.get("patientCategory");
			crit = crit
					.add(Restrictions.eq("PatientCategory", patientCategory));
		}
		if (parameterMap.get("billTypeId") != null) {
			billTypeId = (Integer) parameterMap.get("billTypeId");
			crit = crit.createAlias("BillType", "bt").add(
					Restrictions.eq("bt.Id", billTypeId));
		}
		if (parameterMap.get("drugId") != null) {
			drugId = (Integer) parameterMap.get("drugId");
			crit = crit.createAlias("Item", "i").add(
					Restrictions.eq("i.Id", drugId));
		}
		if (parameterMap.get("roomTypeId") != null) {
			roomTypeId = (Integer) parameterMap.get("roomTypeId");
			crit = crit.createAlias("RoomType", "rt").add(
					Restrictions.eq("rt.Id", roomTypeId));
		}
		if (parameterMap.get("mainchargeCodeId") != null) {
			mainchargeCodeId = (Integer) parameterMap.get("mainchargeCodeId");
			crit = crit.createAlias("MainChargecode", "mcc").add(
					Restrictions.eq("mcc.Id", mainchargeCodeId));
		}
		if (parameterMap.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) parameterMap.get("subChargeCodeId");
			crit = crit.createAlias("SubChargecode", "scc").add(
					Restrictions.eq("scc.Id", subChargeCodeId));
		}
		if (parameterMap.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) parameterMap.get("chargeCodeId");
			crit = crit.createAlias("ChargeCode", "cc").add(
					Restrictions.eq("cc.Id", chargeCodeId));
		}
		existingMasDiscountList = crit.list();*/
		boolean localdiscount=box.getBoolean("localdiscount");
		int hospitalId=box.getInt(HOSPITAL_ID);
		List<MasDiscount> localDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> discountList=new ArrayList<MasDiscount>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String billtypedispensing="";
		String billtypeservic="";
		java.net.URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop
					.getProperty("billtypedispensing");
			billtypeservic = prop
					.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	//	if(box.getInt("schemeId")==0)   //commented by amit das on 31-05-2017
		// {		
		String hql = "select masdiscount from jkt.hms.masters.business.MasDiscount as masdiscount "
				+ "inner join masdiscount.BillType as billType"
				+ " left outer join masdiscount.PatientType as patientType"
				+ " left outer join masdiscount.OtherCategory as otherCategory"
				+ " left outer join masdiscount.Department as department"
				+ " left outer join masdiscount.RoomType as roomType"
				+ " left outer join masdiscount.MainChargecode as mainChargecode"
				+ " left outer join masdiscount.SubChargecode as subChargecode"
				+ " left outer join masdiscount.ChargeCode as chargeCode"
				+ " left outer join masdiscount.Group as storegroup"
				+ " left outer join masdiscount.ItemType as itemType"
				+ " left outer join masdiscount.ItemSection as itemSection"
				+ " left outer join masdiscount.ItemCategory as itemCategory"
				+ " left outer join masdiscount.ItemClass as itemClass"
				+ " left outer join masdiscount.Item as item"
				+ " left outer join masdiscount.Hospital as hospital "
				+ " where masdiscount.Scheme is null "
				;
		if(localdiscount)
		{
			hql +=" and hospital.Id="+hospitalId;
		}
		else
		{
			hql +=" and hospital.Id is null ";
		}

		if (box.getString("bplStatus").equalsIgnoreCase("bpl")) {
			hql +=" and masdiscount.BplStatus='y'";
		} else if (box.getString("bplStatus").equalsIgnoreCase("apl")) {
			hql +=" and masdiscount.BplStatus='n'";
		} else {
			hql +=" and masdiscount.BplStatus is null";
		}

		if (box.getInt("patientTypeId") != 0) {
			hql +=" and patientType.Id="+box.getInt("patientTypeId");
		}
		else
		{
			hql +=" and patientType is null";

		}

		if (box.getInt("otherCategory") != 0) {
			hql +=" and otherCategory.Id="+box.getInt("otherCategory");
		}
		else
		{
			hql +=" and otherCategory is null";
		}

		if (!box.getString(PATIENT_CATEGORY).equalsIgnoreCase("")
				&& !box.getString(PATIENT_CATEGORY).equalsIgnoreCase("0")) {
			String patientCategory = box.getString(PATIENT_CATEGORY);
			hql +=" and masdiscount.PatientCategory='"+patientCategory+"'";
			if (patientCategory.equalsIgnoreCase("ip")
					&& box.getInt(DEPARTMENT_ID) != 0) {
				int departmentId = box.getInt(DEPARTMENT_ID);
				hql +="  and department.Id="+departmentId;
				if(box.getInt(ROOM_TYPE_ID)!=0)
				{
					hql +="  and roomType.Id="+box.getInt(ROOM_TYPE_ID);
				}
			}
			else
			{
				hql +="  and department is null  "
						+ " and roomType is null ";
			}
		}
		else
		{
			hql +=" and masdiscount.PatientCategory is null "
					+ " and department is null  "
					+ " and roomType is null ";
		}
		
		if (box.getInt(BILL_TYPE_ID) != 0) {
			MasBillType billType = (MasBillType) hbt.get(MasBillType.class,
					box.getInt(BILL_TYPE_ID));
			hql +=" and billType.Id="+billType.getId();
			if (billType.getBillTypeCode().equalsIgnoreCase(
					billtypedispensing)) {
				if (box.getInt(GROUP_ID) != 0) {
					hql +=" and storegroup.Id="+box.getInt(GROUP_ID);
					if (box.getInt(ITEM_TYPE) != 0) {
						hql +=" and itemType.Id="+box.getInt(GROUP_ID);
						if (box.getInt(SECTION_ID) != 0) {
							hql +=" and itemSection.Id="+box.getInt(GROUP_ID);
							if (box.getInt(ITEM_CATEGORY_ID) != 0) {
								hql +=" and itemCategory.Id="+box.getInt(ITEM_CATEGORY_ID);
							} else {
								hql +=" and itemCategory is null";
							}

							if (box.getInt(ITEM_CLASS_ID) != 0) {
								hql +=" and itemClass.Id="+box.getInt(ITEM_CLASS_ID);
							} else {
								hql +=" and itemClass is null";
							}

							if (box.getInt("drug") != 0) {
								hql +=" and item.Id="+box.getInt("drug");
							} else {
								hql +=" and item is null";
							}
						} else {
							hql +=" and itemSection is null";
							hql +=" and itemCategory is null";
							hql +=" and itemClass is null";
							hql +=" and item is null";

					
						}
					} else {
						hql +=" and itemType is null";
						hql +=" and itemSection is null";
						hql +=" and itemCategory is null";
						hql +=" and itemClass is null";
						hql +=" and item is null";

					}
					
					

//					Vector<String> chargeList = box
//							.getVector("excludeitemId");
//					if (chargeList != null && chargeList.size() > 0) {
//						for (String chargeId : chargeList) {
//							MasDiscountExclude discountExclude = new MasDiscountExclude();
//							discountExclude.setDiscount(masDiscount);
//							MasStoreItem item = new MasStoreItem();
//							item.setId(Integer.parseInt(chargeId));
//							discountExclude.setItem(item);
//							discountExclude.setStatus("y");
//							hbt.save(discountExclude);
//						}
//					}
				} else {
					hql +=" and storegroup is null";
					hql +=" and itemType is null";
					hql +=" and itemSection is null";
					hql +=" and itemCategory is null";
					hql +=" and itemClass is null";
					hql +=" and item is null";

				}

			} else if (billType.getBillTypeCode().equalsIgnoreCase(
					billtypeservic)) {
				if (box.getInt(MAIN_CHARGECODE_ID) != 0) {
					hql +=" and mainChargecode.Id="+box.getInt(MAIN_CHARGECODE_ID);
					if (box.getInt(SUB_CHARGECODE_ID) != 0) {
						hql +=" and subChargecode.Id="+box.getInt(SUB_CHARGECODE_ID);
						if (box.getInt(CHARGE_CODE_ID) != 0) {
							hql +=" and chargeCode.Id="+box.getInt(CHARGE_CODE_ID);
						} else {
							hql +=" and chargeCode is null";
						}
					} else {
						hql +=" and subChargecode is null";
						hql +=" and chargeCode is null";
					}
					
//					Vector<String> chargeList = box.getVector("excludechargeId");
//					if (chargeList != null && chargeList.size() > 0) {
//						for (String chargeId : chargeList) {
//							MasDiscountExclude discountExclude = new MasDiscountExclude();
//							discountExclude.setDiscount(masDiscount);
//							MasChargeCode chargeCode = new MasChargeCode();
//							chargeCode.setId(Integer.parseInt(chargeId));
//							discountExclude.setCharge(chargeCode);
//							discountExclude.setStatus("y");
//							hbt.save(discountExclude);
//						}
//					}
				} else {
					
//					mainChargecode"
//							+ " left outer join masdiscount.SubChargecode as subChargecode"
//							+ " left outer join masdiscount.ChargeCode as chargeCode
					hql +=" and mainChargecode is null";
					hql +=" and subChargecode is null";
					hql +=" and chargeCode is null";
				}				
			}

		}
		
		
		Query query=session.createQuery(hql);
		
		existingMasDiscountList=query.list();
	// 	}
		
	/*else
		{
			String hql = "select masdiscount from jkt.hms.masters.business.MasDiscount as masdiscount "
					+ " left outer join masdiscount.Hospital as hospital "
				    + " where "; // added by amit das on 31-05-2017
					// + " where masdiscount.Scheme is not null and masdiscount.Scheme.Id="+box.getInt("schemeId"); // commented by amit das on 31-05-2017
			if(localdiscount)
			{
				// hql +=" and hospital.Id="+hospitalId; // commented by amit das on 31-05-2017
				hql +="hospital.Id="+hospitalId; // added by amit das on 31-05-2017
			}
			else
			{
				// hql +=" and hospital.Id is null "; // commented by amit das on 31-05-2017
				hql +="hospital.Id is null "; // added by amit das on 31-05-2017
			}
			
			
			
					Query query=session.createQuery(hql);
					
					existingMasDiscountList=query.list();
		}*/   // WHOLE ELSE BLOCK IS COMMENTED BY AMIT DAS ON 31-05-2017

		return existingMasDiscountList;
	}

	public Map<String, Object> showAccountMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountType> accountTypeList = new ArrayList<FaMasAccountType>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();

		Session session = (Session) getSession();
		accountTypeList = session.createCriteria(FaMasAccountType.class)
				.add(Restrictions.eq("Status", "y")).list();
		accountList = session.createCriteria(FaMasAccount.class).list();
		accountGroupList= session.createCriteria(FaMasAccountGroup.class).list();
		accountSubGroupList= session.createCriteria(FaMasAccountSubGroup.class).list();
		
		map.put("accountTypeList", accountTypeList);
		map.put("accountList", accountList);
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGroupList", accountSubGroupList);
		return map;
	}

	public Map<String, Object> addAccountMaster(FaMasAccount faMasAccount) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountType> accountTypeList = new ArrayList<FaMasAccountType>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> existingAccountList = new ArrayList<FaMasAccount>();
		Session session = (Session) getSession();

		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//String accountCode = faMasAccount.getAccCode();
		String accountName = faMasAccount.getAccDesc();
		/*existingAccountList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.FaMasAccount as acc where acc.AccCode = '"
						+ accountCode + "' and acc.AccDesc = '" + accountName
						+ "'");*/
		if (existingAccountList.size() > 0) {
			message = "Record already Exist";
		} else {
			hbt.save(faMasAccount);
			message = "Record saved sucessfully!";

		}
		accountTypeList = session.createCriteria(FaMasAccountType.class)
				.add(Restrictions.eq("Status", "y")).list();
		accountList = session.createCriteria(FaMasAccount.class).list();
		map.put("accountTypeList", accountTypeList);
		map.put("accountList", accountList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> editAccountMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> existingAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountType> accountTypeList = new ArrayList<FaMasAccountType>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session = (Session) getSession();
		int accountMasterId = 0;
		if (generalMap.get("accountMasterId") != null) {
			accountMasterId = (Integer) generalMap.get("accountMasterId");
		}
		String accountCode = "";
		if (generalMap.get("accountCode") != null) {
			accountCode = (String) generalMap.get("accountCode");
		}
		String accountName = "";
		if (generalMap.get("accountName") != null) {
			accountName = (String) generalMap.get("accountName");
		}
		int accountTypeId = 0;
		if (generalMap.get("accountTypeId") != null) {
			accountTypeId = (Integer) generalMap.get("accountTypeId");
		}
		BigDecimal drBalance = new BigDecimal("0");
		if (generalMap.get("drBalance") != null) {
			drBalance = (BigDecimal) generalMap.get("drBalance");
		}
		BigDecimal crBalance = new BigDecimal("0");
		if (generalMap.get("crBalance") != null) {
			crBalance = (BigDecimal) generalMap.get("crBalance");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
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
		FaMasAccount faMasAccount = (FaMasAccount) hbt.load(FaMasAccount.class,
				accountMasterId);
		//faMasAccount.setAccCode(accountCode);
		faMasAccount.setAccDesc(accountName);
		//faMasAccount.setLastChgBy(changedBy);
		faMasAccount.setLastChgDate(currentDate);
		faMasAccount.setLastChgTime(currentTime);
		//faMasAccount.setDrBalance(drBalance);
		//faMasAccount.setCrBalance(crBalance);
		FaMasAccountType faMasAccountType = new FaMasAccountType();
		faMasAccountType.setId(accountTypeId);
		//faMasAccount.setAccType(faMasAccountType);

		existingAccountList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.FaMasAccount as acc where acc.AccCode = '"
						+ accountCode + "' and acc.AccDesc = '" + accountName
						+ "' and acc.Id != '" + accountMasterId + "' ");
		String message = "";
		if (existingAccountList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.update(faMasAccount);
			message = "Record update successfully";
		}
		accountTypeList = session.createCriteria(FaMasAccountType.class)
				.add(Restrictions.eq("Status", "y")).list();
		accountList = session.createCriteria(FaMasAccount.class).list();
		map.put("accountTypeList", accountTypeList);
		map.put("accountList", accountList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> deleteAccountMaster(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountType> accountTypeList = new ArrayList<FaMasAccountType>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int accountMasterId = 0;
		if (generalMap.get("accountMasterId") != null) {
			accountMasterId = (Integer) generalMap.get("accountMasterId");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
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
		FaMasAccount faMasAccount = (FaMasAccount) hbt.load(FaMasAccount.class,
				accountMasterId);
		//faMasAccount.setLastChgBy(changedBy);
		faMasAccount.setLastChgDate(currentDate);
		faMasAccount.setLastChgTime(currentTime);

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				faMasAccount.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				faMasAccount.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(faMasAccount);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		accountList = session.createCriteria(FaMasAccount.class).list();
		accountTypeList = session.createCriteria(FaMasAccountType.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("accountTypeList", accountTypeList);
		map.put("accountList", accountList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> searchAccountMaster(String accountCode,
			String accountName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountType> accountTypeList = new ArrayList<FaMasAccountType>();
		Session session = (Session) getSession();
		try {
			if ((accountCode == null) || (accountName != null)) {

				accountList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.FaMasAccount acc where acc.AccDesc like '"
								+ accountName + "%' order by acc.AccDesc");
			} else {
				accountList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.FaMasAccount acc where acc.AccCode like '"
								+ accountCode + "%' order by acc.AccCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		accountTypeList = session.createCriteria(FaMasAccountType.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("accountTypeList", accountTypeList);
		map.put("accountList", accountList);
		map.put("accountCode", accountCode);
		map.put("accountName", accountName);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDailyChargeSetupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		List<DailyChargeSetup> dailyChargeSetupList = new ArrayList<DailyChargeSetup>();
		Session session = getSession();
		try {
			dailyChargeSetupList = session.createCriteria(DailyChargeSetup.class).list();
			chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
			map.put("dailyChargeSetupList", dailyChargeSetupList);
			map.put("chargeList", chargeList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> addChargeForDailyChargeSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		DailyChargeSetup dailyChargeSetup = new DailyChargeSetup();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean saved = false;
		try {
			MasChargeCode chargeCode = new MasChargeCode();
			chargeCode.setId(box.getInt(CHARGE_CODE));
			dailyChargeSetup.setChargeCode(chargeCode);
			dailyChargeSetup.setQuantity(box.getInt(QUANTITY));

			Users user = new Users();
			user.setId(box.getInt("userId"));
			dailyChargeSetup.setLastChgBy(user);

			dailyChargeSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			dailyChargeSetup.setLastChgTime(box.getString(CHANGED_TIME));
			dailyChargeSetup.setDailyChargeStatus("y");

			hbt.save(dailyChargeSetup);
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> editChargeForDailyChargeSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean saved = false;
		try {
			int chargeSetupId = box.getInt("chargeSetupId");

			DailyChargeSetup dailyChargeSetup = (DailyChargeSetup)hbt.load(DailyChargeSetup.class, chargeSetupId);

			MasChargeCode chargeCode = new MasChargeCode();
			chargeCode.setId(box.getInt(CHARGE_CODE));
			dailyChargeSetup.setChargeCode(chargeCode);
			dailyChargeSetup.setQuantity(box.getInt(QUANTITY));

			Users user = new Users();
			user.setId(box.getInt("userId"));
			dailyChargeSetup.setLastChgBy(user);

			dailyChargeSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			dailyChargeSetup.setLastChgTime(box.getString(CHANGED_TIME));
			dailyChargeSetup.setDailyChargeStatus("y");

			hbt.update(dailyChargeSetup);
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> deleteChargeForDailyChargeSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean statusChanged = false;
		try {
			int chargeSetupId = box.getInt("chargeSetupId");
			DailyChargeSetup dailyChargeSetup = (DailyChargeSetup)hbt.load(DailyChargeSetup.class, chargeSetupId);

			if (box.getString("flag") != null) {
				String flag = (String) box.getString("flag");
				if (flag.equals("InActivate")) {
					dailyChargeSetup.setDailyChargeStatus("n");
					statusChanged = true;
				} else if (flag.equals("Activate")) {
					dailyChargeSetup.setDailyChargeStatus("y");
					statusChanged = false;
				}
			}

			Users user = new Users();
			user.setId(box.getInt("userId"));
			dailyChargeSetup.setLastChgBy(user);
			dailyChargeSetup.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			dailyChargeSetup.setLastChgTime(box.getString(CHANGED_TIME));

			hbt.update(dailyChargeSetup);
			statusChanged = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("statusChanged", statusChanged);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDailyChargeSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		List<DailyChargeSetup> dailyChargeSetupList = new ArrayList<DailyChargeSetup>();
		Session session = getSession();
		String chargeCode = box.getString(SEARCH_FIELD);
		try {
			dailyChargeSetupList = session.createCriteria(DailyChargeSetup.class)
									.createAlias("ChargeCode", "charge")
									.add(Restrictions.like("charge.ChargeCodeName", chargeCode+"%")).list();
			chargeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
			map.put("dailyChargeSetupList", dailyChargeSetupList);
			map.put("chargeList", chargeList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Boolean checkMasChargeCodeStatus(int chargeCodeId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String discountValue = "";
		Boolean discStatus = false;
		List<MasChargeCode> searchChargeTypeList = new ArrayList<MasChargeCode>();
		searchChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeCode as mcc where and mcc.status='n' and mcc.Id = "+chargeCodeId);
		
		discountValue = searchChargeTypeList.get(0).getDiscountable();
		//
		if(discountValue.equalsIgnoreCase("n"))
		{
			discStatus = true;
			//
		}
		else
		{
			discStatus = false;
			//

		}
		return discStatus;
	}

	@Override
	public Map<String, Object> showBillingSchemeMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountType> searchAccountTypeList = new ArrayList<FaMasAccountType>();
		searchAccountTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasScheme ");
		map.put("searchAccountTypeList", searchAccountTypeList);
		return map;
	}

	@Override
	public boolean addBillingSchemeMaster(MasBillScheme faMasAccountType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(faMasAccountType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public boolean editBillingSchemeMaster(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String accountTypeName = "";
		@SuppressWarnings("unused")
		String accountTypeCode = "";
		int accountTypeId = 0;
		String changedBy = "";
		String discount="";
		accountTypeId = (Integer) generalMap.get("id");
		accountTypeCode = (String) generalMap.get("accountTypeCode");
		accountTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		discount=(String)generalMap.get("discount");
		MasBillScheme faMasAccountType = (MasBillScheme) getHibernateTemplate()
				.load(MasBillScheme.class, accountTypeId);

		faMasAccountType.setId(accountTypeId);
		faMasAccountType.setBillSchemeName(accountTypeName);
		faMasAccountType.setLastChgBy(changedBy);
		faMasAccountType.setLastChgDate(currentDate);
		faMasAccountType.setLastChgTime(currentTime);
		faMasAccountType.setDiscount(discount);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(faMasAccountType);
		dataUpdated = true;
		return dataUpdated;
	}

	@Override
	public boolean deleteBillingSchemeMaster(int accountTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBillScheme faMasAccountType = new MasBillScheme();
		faMasAccountType = (MasBillScheme) getHibernateTemplate().load(
				MasBillScheme.class, accountTypeId);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				faMasAccountType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				faMasAccountType.setStatus("y");
				dataDeleted = false;
			}
		}
		faMasAccountType.setLastChgBy(changedBy);
		faMasAccountType.setLastChgDate(currentDate);
		faMasAccountType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(faMasAccountType);
		return dataDeleted;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemCategoryDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreGroup> groupList=new ArrayList<MasStoreGroup>();
		List<MasItemType> itemTypeList=new ArrayList<MasItemType>();
		List<MasStoreSection> sectionList=new ArrayList<MasStoreSection>();
		List<MasItemCategory> categorieList=new ArrayList<MasItemCategory>();
		List<MasItemClass> itemClasseList=new ArrayList<MasItemClass>();
		
		
		Session session=(Session)getSession();
		
		groupList =session.createCriteria(MasStoreGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if(box.getInt(GROUP_ID)!=0)
		{
			itemTypeList=session.createCriteria(MasItemType.class)
					.add(Restrictions.eq("Group.Id", box.getInt(GROUP_ID)))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if(box.getInt(ITEM_TYPE)!=0)
			{
				sectionList=session.createCriteria(MasStoreSection.class)
						.add(Restrictions.eq("ItemType.Id", box.getInt(ITEM_TYPE)))
						.add(Restrictions.eq("Status", "y").ignoreCase()).list();
				
				if(box.getInt(SECTION_ID)!=0)
				{
					categorieList=session.createCriteria(MasItemCategory.class)
							.add(Restrictions.eq("Section.Id", box.getInt(SECTION_ID)))
							.add(Restrictions.eq("Status", "y").ignoreCase()).list();
					
					itemClasseList=session.createCriteria(MasItemClass.class)
							.add(Restrictions.eq("Section.Id", box.getInt(SECTION_ID)))
							.add(Restrictions.eq("Status", "y").ignoreCase()).list();
					
				}
			}
		}
		
		
		
		map.put("groupList", groupList);
		map.put("itemTypeList", itemTypeList);
		map.put("sectionList", sectionList);
		map.put("categorieList", categorieList);
		map.put("itemClasseList", itemClasseList);
		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getChargeForExclude(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();
		
		Session session=(Session)getSession();
		if(box.getInt(CHARGE_CODE_ID)!=0)
		{
			
		}
		else if(box.getInt(SUB_CHARGECODE_ID)!=0)
		{
			chargeCodeList=session.createCriteria(MasChargeCode.class)
					.createAlias("SubChargecode", "subcharge")
					.add(Restrictions.eq("subcharge.Id", box.getInt(SUB_CHARGECODE_ID)))
					.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("ChargeCodeName")).list(); //edited by amit das on 31-05-2017
		}
		else if(box.getInt(MAIN_CHARGECODE_ID)!=0)
		{
			chargeCodeList=session.createCriteria(MasChargeCode.class)
					.createAlias("SubChargecode", "subcharge")
					.createAlias("subcharge.MainChargecode", "mainCharge")
					.add(Restrictions.eq("mainCharge.Id", box.getInt(MAIN_CHARGECODE_ID)))
					.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("ChargeCodeName")).list(); //edited by amit das on 31-05-2017
		}
		
		
		
		map.put("chargeCodeList", chargeCodeList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemForExclude(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
		
		Session session=(Session)getSession();
		
		if(box.getInt(GROUP_ID)!=0)
		{
		Criteria criteria=session.createCriteria(MasStoreItem.class);
		if(box.getInt(ITEM_CATEGORY_ID)!=0 && box.getInt(ITEM_CLASS_ID)!=0)
		{
			criteria.createAlias("ItemClass", "itemClass")
			.createAlias("ItemCategory", "itemCategory")
			.add(Restrictions.eq("itemClass.Id", box.getInt(ITEM_CLASS_ID)))
			.add(Restrictions.eq("itemCategory.Id", box.getInt(ITEM_CATEGORY_ID)));
		}
		else if(box.getInt(ITEM_CLASS_ID)!=0)
		{
			criteria.createAlias("ItemClass", "itemClass")
			.add(Restrictions.eq("itemClass.Id", box.getInt(ITEM_CLASS_ID)));
		}
		else if(box.getInt(ITEM_CATEGORY_ID)!=0)
		{
			criteria.createAlias("ItemCategory", "itemCategory")
			.add(Restrictions.eq("itemCategory.Id", box.getInt(ITEM_CATEGORY_ID)));
		}
		else if(box.getInt(SECTION_ID)!=0)
		{
			criteria.createAlias("Section", "section")
			.add(Restrictions.eq("section.Id", box.getInt(SECTION_ID)));
		}
		else if(box.getInt(ITEM_TYPE)!=0)
		{
			criteria.createAlias("ItemType", "itemType")
			.add(Restrictions.eq("itemType.Id", box.getInt(ITEM_TYPE)));
		}
		else
		{
			criteria.createAlias("Group", "group")
			.add(Restrictions.eq("group.Id", box.getInt(GROUP_ID)));
		}
		
		criteria.add(Restrictions.eq("Status", "y").ignoreCase());
		
		itemList=criteria.list();
		}		
		map.put("itemList", itemList);
		return map;
	}
	
	@Override
	public List<MasDiscount> serviceDispensingAutoBilling(Box box) {
		List<MasDiscount> tempDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> localDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> discountList=new ArrayList<MasDiscount>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int patientId=box.getInt(HIN_ID);
		int chargeId=box.getInt(CHARGE_ID);
		int itemId=box.getInt(ITEM_ID);
		int inpatientId=box.getInt(INPATIENT_ID);
		int visitId=box.getInt(VISIT_ID);
		int roomTypeId=box.getInt("roomtypeId");
		int paywardId=box.getInt("ward");
		int hospitalId=box.getInt(HOSPITAL_ID);
		boolean isPaywardBooking=box.getBoolean("isPaywardBooking");
		
		Patient patient=null;
		MasChargeCode chargeCode=null;
		MasStoreItem item=null;
		Inpatient inpatient=null;
		
		String billtypedispensing="";
		String billtypeservic="";
		java.net.URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop
					.getProperty("billtypedispensing");
			billtypeservic = prop
					.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			patient=(Patient)hbt.get(Patient.class, patientId);
		if(chargeId!=0)
		{
			chargeCode=(MasChargeCode)hbt.get(MasChargeCode.class, chargeId);
		}
		if(itemId!=0)
		{
			item=(MasStoreItem)hbt.get(MasStoreItem.class, itemId);
		}
		if(inpatientId!=0)
		{
			inpatient=(Inpatient)hbt.get(Inpatient.class, inpatientId);
			if(roomTypeId==0)
			{
				roomTypeId=inpatient.getBed().getRoom().getRoomType().getId();
			}
			if(paywardId==0)
			{
				paywardId=inpatient.getDepartment().getId();
			}
		}
		
		
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		if(patient.getDateOfBirth()!=null)
		cal.setTime(patient.getDateOfBirth());
		int calculatedYear;
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		calculatedYear = currentYear - birthYear;
		
		
		String hql = "select masdiscount from jkt.hms.masters.business.MasDiscount as masdiscount "
				+ "inner join masdiscount.BillType as billType"
				+ " left outer join masdiscount.PatientType as patientType"
				+ " left outer join masdiscount.OtherCategory as otherCategory"
				+ " left outer join masdiscount.Department as department"
				+ " left outer join masdiscount.RoomType as roomType"
				+ " left outer join masdiscount.MainChargecode as mainChargecode"
				+ " left outer join masdiscount.SubChargecode as subChargecode"
				+ " left outer join masdiscount.ChargeCode as chargeCode"
				+ " left outer join masdiscount.Group as storegroup"
				+ " left outer join masdiscount.ItemType as itemType"
				+ " left outer join masdiscount.ItemSection as itemSection"
				+ " left outer join masdiscount.ItemCategory as itemCategory"
				+ " left outer join masdiscount.ItemClass as itemClass"
				+ " left outer join masdiscount.Item as item"
				+ " where masdiscount.Scheme is null and "
				+ " (masdiscount.BplStatus is null or (masdiscount.BplStatus=:bplStatus))"
				+ " and ( patientType is null or patientType.Id=:socialCategoryid )"
				+ " and ( otherCategory is null or otherCategory.Id in "
				+ "(select otherCat.Id FROM  jkt.hms.masters.business.PatientCategoryDetails oCategory "
				+ " inner join oCategory.OtherCategory otherCat "
				+ " inner join oCategory.Hin hin where hin.Id=:patientId ) )"
				+ " and (masdiscount.PatientCategory is null "
				+ " or (masdiscount.PatientCategory=:patientStatus and "
				+ "(department is null or department.Id=:departmentId) "
				+ " and (roomType is null or roomType.Id=:roomTypeId)))"
				
				/*+ " and (masdiscount.PatientCategory is null "
				+ " or (masdiscount.PatientCategory='IP' and (masdiscount.PatientCategory=:patientStatus and "
				+ "(department is null or(department.Id=:departmentId))) )"
				+ " or (masdiscount.PatientCategory='OP' and masdiscount.PatientCategory=:patientStatus ))"*/

				+ " and ((billType.BillTypeCode=:billTypeService "
				+ " and (mainChargecode is null or mainChargecode.Id=:mainChargecodeId)"
				+ " and (subChargecode is null or subChargecode.Id=:subChargecodeId)"
				+ " and (chargeCode is null or chargeCode.Id=:chargeCodeId)"
				+ " and :chargeCodeId not in(select charge.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Charge charge where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y') )"
				+ "  or (billType.BillTypeCode=:billTypeDispensing "
				+ " and ( storegroup is null or storegroup.Id=:groupId)"
				+ " and ( itemType is null or itemType.Id=:itemTypeId) "
				+ " and ( itemSection is null or itemSection.Id=:itemSectionId) "
				+ " and ( itemCategory is null or itemCategory.Id=:itemCategoryId) "
				+ " and ( itemClass is null or itemClass.Id=:itemClassId) "
				+ " and ( item is null or item.Id=:itemId) "				
				+ " and :itemId not in(select item.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Item item where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y')  ) )"
                
				/*+ " and (masdiscount.FromAge is null or (masdiscount.FromAge>=:age))"
				+ " and (masdiscount.ToAge is null or (masdiscount.ToAge<=:age))"*/

				+ " and (masdiscount.EffectiveDateFrom is null or (masdiscount.EffectiveDateFrom<=:currentDate))"
				+ " and (masdiscount.EffectiveDateTo is null or (masdiscount.EffectiveDateTo>=:currentDate))"

				+ "";

		Query query=session.createQuery(hql);
		query.setParameter("bplStatus", patient.getBplStatus());
		query.setParameter("socialCategoryid", patient.getPatientType()!=null?patient.getPatientType().getId():0);
		query.setParameter("patientId",patientId);
		if(!isPaywardBooking)
		{
		if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("In Patient"))
		{
		query.setParameter("patientStatus","IP");
		} else if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("Out Patient"))
		{
		query.setParameter("patientStatus","OP");
		}
		else 
		{
		query.setParameter("patientStatus",null);
		}
		}
		else
		{
			query.setParameter("patientStatus","IP");
		}
		
		query.setParameter("departmentId",paywardId);
		query.setParameter("roomTypeId",roomTypeId);
		
		query.setParameter("billTypeService",billtypeservic);
		if( chargeCode !=null)
		{
		query.setParameter("mainChargecodeId",chargeCode.getMainChargecode().getId());
		query.setParameter("subChargecodeId",chargeCode.getSubChargecode().getId());
		query.setParameter("chargeCodeId",chargeCode.getId());
		}
		else
		{
			query.setParameter("mainChargecodeId",0);
			query.setParameter("subChargecodeId",0);
			query.setParameter("chargeCodeId",0);
		}
		query.setParameter("billTypeDispensing",billtypedispensing);
		if(item!=null)
		{
		query.setParameter("groupId",item.getGroup().getId());
		query.setParameter("itemTypeId",item.getItemType()!=null?item.getItemType().getId():0);
		query.setParameter("itemCategoryId",item.getItemCategory()!=null?item.getItemCategory().getId():0);
		query.setParameter("itemSectionId",item.getSection()!=null?item.getSection().getId():0);
		query.setParameter("itemClassId",item.getItemClass()!=null?item.getItemClass().getId():0);
		query.setParameter("itemId",item.getId());
		}
		else
		{
			query.setParameter("groupId",0);
			query.setParameter("itemTypeId",0);
			query.setParameter("itemCategoryId",0);
			query.setParameter("itemSectionId",0);
			query.setParameter("itemClassId",0);
			query.setParameter("itemId",0);
		}
		
//		query.setParameter("age",new BigDecimal(calculatedYear));
		query.setParameter("currentDate",HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
		
		tempDiscountList=query.list();
		
		
		// ---------------------------Calculation for last cost
		// price---------------------------------//
		BigDecimal totalCostPriceForConsumption = new BigDecimal(0.00);
		if(itemId!=0)
		{
		List<Integer> storeItemBatchStockList = new ArrayList<Integer>();
		List<StoreItemBatchStock> storeItemBatchStockForLastCostPrice = new ArrayList<StoreItemBatchStock>();
		
		Criteria criteria = session.createCriteria(
				StoreItemBatchStock.class).createAlias("Item", "item")
				.add(Restrictions.eq("item.Id", itemId)).createAlias(
						"Department", "dept");
		if(inpatient==null)
		{					
						criteria.add(
						Restrictions.eq("dept.DepartmentCode", "PHAR"));				
		}
		else
		{
			criteria.add(
					Restrictions.eq("dept.Id", inpatient.getDepartment().getId()));
		}
		criteria.setProjection(Projections.max("Id"));
		storeItemBatchStockList=criteria.list();
		if (storeItemBatchStockList.size() > 0
				&& storeItemBatchStockList.get(0) != null) {
			int storeItemBatchStockId = storeItemBatchStockList.get(0);
			storeItemBatchStockForLastCostPrice = session
					.createCriteria(StoreItemBatchStock.class).add(
							Restrictions.idEq(storeItemBatchStockId))
					.list();
			if (storeItemBatchStockForLastCostPrice.size() > 0) {
				for (StoreItemBatchStock storeItemBatchStock : storeItemBatchStockForLastCostPrice) {
					BigDecimal costPrice = storeItemBatchStock
							.getCostPrice();
					if(costPrice!=null && !costPrice.equals(""))
					totalCostPriceForConsumption = totalCostPriceForConsumption
							.add(costPrice);
				}
			}
		}
		}
		BigDecimal chargeAmt = new BigDecimal(0.00);
		if(chargeId!=0)
		{
			List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.idEq(chargeId)).list();
					
					
			MasChargeCode masChargeCode = new MasChargeCode();
			if (chargeCodeList.size() > 0) {
				masChargeCode = chargeCodeList.get(0);
				if(masChargeCode.getCharge()!=null){
					chargeAmt = new BigDecimal(masChargeCode.getCharge());
				}
				
				List<MasChargeCodeRates> chargeCodeRates=new ArrayList<MasChargeCodeRates>();
				chargeCodeRates=session.createCriteria(MasChargeCodeRates.class)
						 .add(Restrictions.eq("ChargeCode.Id", masChargeCode.getId()))
						 .add(Restrictions.eq("Hospital.Id", hospitalId))
						.list();
				if(chargeCodeRates.size()>0 && chargeCodeRates.get(0).getRate()!=null)
				{
					chargeAmt=chargeCodeRates.get(0).getRate();
				}
				else if(masChargeCode.getCharge()!=null)
				{
					chargeAmt=new BigDecimal(masChargeCode.getCharge());
				}
				
				/*// BigDecimal chargeAmt = new BigDecimal(masChargeCode.getCharge());

				Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
				// if (masChargeCode.getMasChargeCodeRates() != null &&
				// masChargeCode.getMasChargeCodeRates().size() >0) {
				chargeSet = masChargeCode.getMasChargeCodeRates();
				if (chargeSet.size() > 0) {
					for (MasChargeCodeRates chargeRate : chargeSet) {
						if (currentDate
								.compareTo(chargeRate.getEffectiveFromDate()) >= 0
								&& (chargeRate.getEffectiveToDate() == null || currentDate
										.compareTo(chargeRate.getEffectiveToDate()) <= 0)) {
							// ---Added by dipali for nabh And cghs
							if (nabhHospital.equalsIgnoreCase("y")	&& patientTypeId == 1) {
								if (rateApplicable == 4) {
									chargeAmt = new BigDecimal(String
											.valueOf(chargeRate.getChargeCode()
													.getChargeNabh()));
								} else {
									chargeAmt = chargeRate.getRate();
								}
							} else if (nabhHospital.equalsIgnoreCase("n")
									&& patientTypeId == 1) {
								if (rateApplicable != 0 && rateApplicable == 4) {
									chargeAmt = new BigDecimal(String
											.valueOf(chargeRate.getChargeCode()
													.getChargeNonNabh()));
								} else {
									chargeAmt = chargeRate.getRate();
								}
							} else {

								chargeAmt = chargeRate.getRate();
							}
							// ----------------------------------------
							// chargeAmt = chargeRate.getRate();
							break;
						} else {
							chargeAmt = new BigDecimal(masChargeCode.getCharge());
						}

					}

				} else {
					if (nabhHospital.equalsIgnoreCase("y") && patientTypeId == 1) {
						if (rateApplicable == 4) {
							chargeAmt = new BigDecimal(String.valueOf(masChargeCode
									.getChargeNabh()));
						} else {
							chargeAmt = new BigDecimal(masChargeCode.getCharge());
						}
					} else if (nabhHospital.equalsIgnoreCase("n") && patientTypeId == 1) {
						if (rateApplicable == 4) {
							chargeAmt = new BigDecimal(String.valueOf(masChargeCode
									.getChargeNonNabh()));
						} else {
							chargeAmt = new BigDecimal(masChargeCode.getCharge());
						}
					} else {
						chargeAmt = new BigDecimal(masChargeCode.getCharge());
					}
					// ----------------------------------------
					// chargeAmt = chargeRate.getRate();
				}
				actAmount = chargeAmt.add(balaceId);*/

			}
		}
		
		
		for (MasDiscount masDiscount : tempDiscountList) {
			if(masDiscount.getHospital()!=null && masDiscount.getHospital().getId()==hospitalId)
			{
				localDiscountList.add(masDiscount);
			}
		}
		if(localDiscountList.size()==0)
		{
			localDiscountList=tempDiscountList;
		}
		
		
		
		for (MasDiscount masDiscount : localDiscountList) {
			List<MasDiscountDiagnosis> diagnosiList=new ArrayList<MasDiscountDiagnosis>();
			diagnosiList=session.createCriteria(MasDiscountDiagnosis.class)
					.createAlias("Discount","discount")
					.add(Restrictions.eq("discount.Id", masDiscount.getId()))
					.list();
			List<DischargeIcdCode> dischargeIcdCodeList=new ArrayList<DischargeIcdCode>();
			if(inpatient!=null)
			{
				dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
			             .add(Restrictions.eq("Inpatient.Id", inpatient.getId())).list();
			}
			else
			{
				dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
			             .add(Restrictions.eq("Visit.Id", visitId)).list();
			}
			if(diagnosiList.size()!=0)
			{			
				boolean diagnosismatched=false;
				for (MasDiscountDiagnosis masDiscountDiagnosis : diagnosiList) {
					for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
						if(masDiscountDiagnosis.getIcd().getId()==dischargeIcdCode.getIcd().getId())
						{
							diagnosismatched=true;
							break;
						}
					}
					if(diagnosismatched)
					{
						break;
					}
				}
				if(!diagnosismatched)
				{
					continue;
				}
			}
			if(masDiscount.getDiscountType().equalsIgnoreCase("d"))
			{
			if (masDiscount.getDiscountPercentage() != null) {
				if(masDiscount.getDiscountPercentage().compareTo(new BigDecimal(100))>=0)
				{
				discountList.add(masDiscount);	
				}
			}
			if (masDiscount.getDiscountValue() != null) {
				if(itemId!=0 )
				{
					 int res=(masDiscount.getDiscountValue()).compareTo(totalCostPriceForConsumption);					 
					if(res>=0)
					{
					discountList.add(masDiscount);	
					}
				}
				else if(chargeId!=0 )
				{
					 int res=(masDiscount.getDiscountValue()).compareTo(chargeAmt);					 
						if(res>=0)
						{
						discountList.add(masDiscount);	
						}
				}
			}
			}
			else if(masDiscount.getDiscountType().equalsIgnoreCase("t"))
			{
				if(itemId!=0)
				{
					if(masDiscount.getDiscountPercentage()!=null && totalCostPriceForConsumption.compareTo(new BigDecimal(0))<=0)
					{
					discountList.add(masDiscount);	
					}
					else if(masDiscount.getDiscountValue()!=null && totalCostPriceForConsumption.add(masDiscount.getDiscountValue()).compareTo(new BigDecimal(0))<=0)
					{
					
					}
				}
				else if(chargeId!=0 )
				{
					if(masDiscount.getDiscountPercentage()!=null && chargeAmt.compareTo(new BigDecimal(0))<=0)
					{
					discountList.add(masDiscount);	
					}
					else if(masDiscount.getDiscountValue()!=null && chargeAmt.add(masDiscount.getDiscountValue()).compareTo(new BigDecimal(0))<=0)
					{
					discountList.add(masDiscount);	
					}
				}
			}
			else if(masDiscount.getDiscountType().equalsIgnoreCase("f"))
			{
				if(masDiscount.getFixedValue()!=null && masDiscount.getFixedValue().compareTo(BigDecimal.ZERO)<=0)
				{
					discountList.add(masDiscount);	
				}
			}
		}
		return discountList;
	}
	
	@Override
	public List<MasDiscount> serviceDispensingDiscount(Box box) {
		List<MasDiscount> tempDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> localDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> discountList=new ArrayList<MasDiscount>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int patientId=box.getInt(HIN_ID);
		int chargeId=box.getInt(CHARGE_ID);
		int itemId=box.getInt(ITEM_ID);
		int inpatientId=box.getInt(INPATIENT_ID);
		int visitId=box.getInt(VISIT_ID);
		int roomTypeId=box.getInt("roomtypeId");
		int paywardId=box.getInt("ward");
		int hospitalId=box.getInt(HOSPITAL_ID);
		boolean isPaywardBooking=box.getBoolean("isPaywardBooking");
		
		Patient patient=null;
		MasChargeCode chargeCode=null;
		MasStoreItem item=null;
		Inpatient inpatient=null;
		
		String billtypedispensing="";
		String billtypeservic="";
		java.net.URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop
					.getProperty("billtypedispensing");
			billtypeservic = prop
					.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			patient=(Patient)hbt.get(Patient.class, patientId);
		if(chargeId!=0)
		{
			chargeCode=(MasChargeCode)hbt.get(MasChargeCode.class, chargeId);
		}
		if(itemId!=0)
		{
			item=(MasStoreItem)hbt.get(MasStoreItem.class, itemId);
		}
		if(inpatientId!=0)
		{
			inpatient=(Inpatient)hbt.get(Inpatient.class, inpatientId);
			if(roomTypeId==0)
			{
				roomTypeId=inpatient.getBed().getRoom().getRoomType().getId();
			}
			if(paywardId==0)
			{
				paywardId=inpatient.getDepartment().getId();
			}
		}
		
		
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		if(patient.getDateOfBirth()!=null)
		cal.setTime(patient.getDateOfBirth());
		
		int calculatedYear;
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		calculatedYear = currentYear - birthYear;
		
		
		String hql = "select masdiscount from jkt.hms.masters.business.MasDiscount as masdiscount "
				+ "inner join masdiscount.BillType as billType"
				+ " left outer join masdiscount.PatientType as patientType"
				+ " left outer join masdiscount.OtherCategory as otherCategory"
				+ " left outer join masdiscount.Department as department"
				+ " left outer join masdiscount.RoomType as roomType"
				+ " left outer join masdiscount.MainChargecode as mainChargecode"
				+ " left outer join masdiscount.SubChargecode as subChargecode"
				+ " left outer join masdiscount.ChargeCode as chargeCode"
				+ " left outer join masdiscount.Group as storegroup"
				+ " left outer join masdiscount.ItemType as itemType"
				+ " left outer join masdiscount.ItemSection as itemSection"
				+ " left outer join masdiscount.ItemCategory as itemCategory"
				+ " left outer join masdiscount.ItemClass as itemClass"
				+ " left outer join masdiscount.Item as item"
				+ " where masdiscount.Scheme is null and "
				+ " (masdiscount.BplStatus is null or (masdiscount.BplStatus=:bplStatus))"
				+ " and ( patientType is null or patientType.Id=:socialCategoryid )"
				+ " and ( otherCategory is null or otherCategory.Id in "
				+ "(select otherCat.Id FROM  jkt.hms.masters.business.PatientCategoryDetails oCategory "
				+ " inner join oCategory.OtherCategory otherCat "
				+ " inner join oCategory.Hin hin where hin.Id=:patientId ) )"
				+ " and (masdiscount.PatientCategory is null "
				+ " or (masdiscount.PatientCategory=:patientStatus and "
				+ "(department is null or department.Id=:departmentId) "
				+ " and (roomType is null or roomType.Id=:roomTypeId)))"
				
/*+ " and (masdiscount.PatientCategory is null "
+ " or (masdiscount.PatientCategory='IP' and (masdiscount.PatientCategory=:patientStatus and "
+ "(department is null or(department.Id=:departmentId))) )"
+ " or (masdiscount.PatientCategory='OP' and masdiscount.PatientCategory=:patientStatus ))"*/

				+ " and ((billType.BillTypeCode=:billTypeService "
				+ " and (mainChargecode is null or mainChargecode.Id=:mainChargecodeId)"
				+ " and (subChargecode is null or subChargecode.Id=:subChargecodeId)"
				+ " and (chargeCode is null or chargeCode.Id=:chargeCodeId)"
				+ " and :chargeCodeId not in(select charge.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Charge charge where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y') )"
				+ "  or (billType.BillTypeCode=:billTypeDispensing "
				+ " and ( storegroup is null or storegroup.Id=:groupId)"
				+ " and ( itemType is null or itemType.Id=:itemTypeId) "
				+ " and ( itemSection is null or itemSection.Id=:itemSectionId) "
				+ " and ( itemCategory is null or itemCategory.Id=:itemCategoryId) "
				+ " and ( itemClass is null or itemClass.Id=:itemClassId) "
				+ " and ( item is null or item.Id=:itemId) "				
				+ " and :itemId not in(select item.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Item item where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y')  ) )"
                
				/*+ " and (masdiscount.FromAge is null or (masdiscount.FromAge>=:age))"
				+ " and (masdiscount.ToAge is null or (masdiscount.ToAge<=:age))"*/
				+ " and masdiscount.Status='y'"
				+ " and (masdiscount.EffectiveDateFrom is null or (masdiscount.EffectiveDateFrom<=:currentDate))"
				+ " and (masdiscount.EffectiveDateTo is null or (masdiscount.EffectiveDateTo>=:currentDate))"

				+ "";

		Query query=session.createQuery(hql);
		query.setParameter("bplStatus", patient.getBplStatus());
		query.setParameter("socialCategoryid", patient.getPatientType()!=null?patient.getPatientType().getId():0);
		query.setParameter("patientId",patientId);
		if(!isPaywardBooking)
		{
		if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("In Patient"))
		{
		query.setParameter("patientStatus","IP");
		} else if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("Out Patient"))
		{
		query.setParameter("patientStatus","OP");
		}
		else 
		{
		query.setParameter("patientStatus",null);
		}
		}
		else
		{
			query.setParameter("patientStatus","IP");
		}
		
		query.setParameter("departmentId",paywardId);
		query.setParameter("roomTypeId",roomTypeId);
		
		query.setParameter("billTypeService",billtypeservic);
		if( chargeCode !=null)
		{
		query.setParameter("mainChargecodeId",chargeCode.getMainChargecode().getId());
		query.setParameter("subChargecodeId",chargeCode.getSubChargecode().getId());
		query.setParameter("chargeCodeId",chargeCode.getId());
		}
		else
		{
			query.setParameter("mainChargecodeId",0);
			query.setParameter("subChargecodeId",0);
			query.setParameter("chargeCodeId",0);
		}
		query.setParameter("billTypeDispensing",billtypedispensing);
		if(item!=null)
		{
		query.setParameter("groupId",item.getGroup().getId());
		query.setParameter("itemTypeId",item.getItemType()!=null?item.getItemType().getId():0);
		query.setParameter("itemCategoryId",item.getItemCategory()!=null?item.getItemCategory().getId():0);
		query.setParameter("itemSectionId",item.getSection()!=null?item.getSection().getId():0);
		query.setParameter("itemClassId",item.getItemClass()!=null?item.getItemClass().getId():0);
		query.setParameter("itemId",item.getId());
		}
		else
		{
			query.setParameter("groupId",0);
			query.setParameter("itemTypeId",0);
			query.setParameter("itemCategoryId",0);
			query.setParameter("itemSectionId",0);
			query.setParameter("itemClassId",0);
			query.setParameter("itemId",0);
		}
		
//		query.setParameter("age",new BigDecimal(calculatedYear));
		query.setParameter("currentDate",HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
		
		tempDiscountList=query.list();
		
		
		// ---------------------------Calculation for last cost
		// price---------------------------------//
		BigDecimal totalCostPriceForConsumption = new BigDecimal(0.00);
		if(itemId!=0)
		{
		List<Integer> storeItemBatchStockList = new ArrayList<Integer>();
		List<StoreItemBatchStock> storeItemBatchStockForLastCostPrice = new ArrayList<StoreItemBatchStock>();
		
		Criteria criteria = session.createCriteria(
				StoreItemBatchStock.class).createAlias("Item", "item")
				.add(Restrictions.eq("item.Id", itemId)).createAlias(
						"Department", "dept");
		if(inpatient==null)
		{					
						criteria.add(
						Restrictions.eq("dept.DepartmentCode", "PHAR"));				
		}
		else
		{
			criteria.add(
					Restrictions.eq("dept.Id", inpatient.getDepartment().getId()));
		}
		criteria.setProjection(Projections.max("Id"));
		storeItemBatchStockList=criteria.list();
		if (storeItemBatchStockList.size() > 0
				&& storeItemBatchStockList.get(0) != null) {
			int storeItemBatchStockId = storeItemBatchStockList.get(0);
			storeItemBatchStockForLastCostPrice = session
					.createCriteria(StoreItemBatchStock.class).add(
							Restrictions.idEq(storeItemBatchStockId))
					.list();
			if (storeItemBatchStockForLastCostPrice.size() > 0) {
				for (StoreItemBatchStock storeItemBatchStock : storeItemBatchStockForLastCostPrice) {
					BigDecimal costPrice = storeItemBatchStock
							.getCostPrice();
					if(costPrice!=null && !costPrice.equals(""))
					totalCostPriceForConsumption = totalCostPriceForConsumption
							.add(costPrice);
				}
			}
		}
		}
		BigDecimal chargeAmt = new BigDecimal(0.00);
		if(chargeId!=0)
		{
			List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.idEq(chargeId)).list();
					
					
			MasChargeCode masChargeCode = new MasChargeCode();
			if (chargeCodeList.size() > 0) {
				masChargeCode = chargeCodeList.get(0);
				chargeAmt = new BigDecimal(masChargeCode.getCharge());
				List<MasChargeCodeRates> chargeCodeRates=new ArrayList<MasChargeCodeRates>();
				chargeCodeRates=session.createCriteria(MasChargeCodeRates.class)
						 .add(Restrictions.eq("ChargeCode.Id", masChargeCode.getId()))
						 .add(Restrictions.eq("Hospital.Id", hospitalId))
						.list();
				if(chargeCodeRates.size()>0 && chargeCodeRates.get(0).getRate()!=null)
				{
					chargeAmt=chargeCodeRates.get(0).getRate();
				}
				else if(masChargeCode.getCharge()!=null)
				{
					chargeAmt=new BigDecimal(masChargeCode.getCharge());
				}
				
			}
		}
		
		
		for (MasDiscount masDiscount : tempDiscountList) {
			if(masDiscount.getHospital()!=null && masDiscount.getHospital().getId()==hospitalId)
			{
				localDiscountList.add(masDiscount);
			}
		}
		if(localDiscountList.size()==0)
		{
			localDiscountList=tempDiscountList;
		}
		 System.out.println("discountlist"+localDiscountList.size());
		BigDecimal rate=new BigDecimal(0.00);  
		
		if(itemId!=0 )
		{
			rate=totalCostPriceForConsumption;
		}
		else if(chargeId!=0 )
		{
			rate=chargeAmt;
		}
		
		for (MasDiscount masDiscount : localDiscountList) {
			BigDecimal maxDiscount=new BigDecimal(0.00);
			BigDecimal currentDiscount=new BigDecimal(0.00);
			MasDiscount maxMasDiscount=null;
			List<MasDiscountDiagnosis> diagnosiList=new ArrayList<MasDiscountDiagnosis>();
			diagnosiList=session.createCriteria(MasDiscountDiagnosis.class)
					.createAlias("Discount","discount")
					.add(Restrictions.eq("discount.Id", masDiscount.getId()))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			List<DischargeIcdCode> dischargeIcdCodeList=new ArrayList<DischargeIcdCode>();
			if(inpatient!=null)
			{
				dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
			             .add(Restrictions.eq("Inpatient.Id", inpatient.getId())).list();
			}
			else
			{
				dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
			             .add(Restrictions.eq("Visit.Id", visitId)).list();
			}
			if(diagnosiList.size()!=0)
			{			
				boolean diagnosismatched=false;
				for (MasDiscountDiagnosis masDiscountDiagnosis : diagnosiList) {
					for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
						if(masDiscountDiagnosis.getIcd().getId()==dischargeIcdCode.getIcd().getId())
						{
							diagnosismatched=true;
							break;
						}
					}
					if(diagnosismatched)
					{
						break;
					}
				}
				if(!diagnosismatched)
				{
					continue;
				}
			}
			if(masDiscount.getDiscountType().equalsIgnoreCase("d"))
			{
			if (masDiscount.getDiscountPercentage() != null) {
				currentDiscount=(masDiscount.getDiscountPercentage().multiply(rate)).divide(new BigDecimal(100));
			}
			if (masDiscount.getDiscountValue() != null) {
				currentDiscount=masDiscount.getDiscountValue();
			}
			}
			else if(masDiscount.getDiscountType().equalsIgnoreCase("t"))
			{
				
					if(masDiscount.getDiscountPercentage()!=null)
					{
						currentDiscount=((masDiscount.getDiscountPercentage().multiply(rate)).divide(new BigDecimal(100))).multiply(new BigDecimal(-1));
					}
					else if(masDiscount.getDiscountValue()!=null)
					{
						currentDiscount=masDiscount.getDiscountValue().multiply(new BigDecimal(-1));
					}
				
			}
			else if(masDiscount.getDiscountType().equalsIgnoreCase("f"))
			{
				currentDiscount=rate.subtract(masDiscount.getFixedValue());
			}
			if(currentDiscount.compareTo(maxDiscount)>=0)
			{
				discountList.clear();
				discountList.add(masDiscount);	
			}
		}
		if(discountList.size()==0 && localDiscountList.size()>0)
		{
			discountList.add(localDiscountList.get(0));	
		}
		 System.out.println("discountlist===="+discountList.size());
		return discountList;
	}
	
	@Override
	public Map<String, Object> internalBillingForService(
			Map<String, Object> detailsMap) {
		Box box = new Box("box");
		int patientId = 0;
		int visitId = 0;
		 int hospitalId=0;
		
		
		String hinNo = "";
		int userId = 0;
		int orderId = 0;
		if (detailsMap.get(HIN_ID) != null) {
			patientId = (Integer) detailsMap.get(HIN_ID);
			box.put(HIN_ID, (Integer) detailsMap.get(HIN_ID));
		}
		
		if (detailsMap.get(VISIT_ID) != null) {
			visitId = (Integer) detailsMap.get(VISIT_ID);
			box.put(VISIT_ID, (Integer) detailsMap.get(VISIT_ID));
		}
		if (detailsMap.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) detailsMap.get(HOSPITAL_ID);
			box.put(HOSPITAL_ID, (Integer) detailsMap.get(HOSPITAL_ID));
			
		}
		if (detailsMap.get(HIN_NO) != null) {
			hinNo = (String) detailsMap.get(HIN_NO);
			box.put(HIN_NO, (Integer) detailsMap.get(HIN_NO));
		}
		if (detailsMap.get(USER_ID) != null) {
			userId = (Integer) detailsMap.get(USER_ID);
			box.put(USER_ID, (Integer) detailsMap.get(USER_ID));
		}
		if (detailsMap.get("orderId") != null) {
			orderId = (Integer) detailsMap.get("orderId");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = HMSUtil.getCurrentDateAndTime();

		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Visit visit = (Visit) hbt.get(Visit.class, visitId);
		Patient patient = (Patient) hbt.get(Patient.class, patientId);

		// opBillHeader.setBillNo(billNo);
		DgOrderhd dgOrderhd = (DgOrderhd) hbt.get(DgOrderhd.class, orderId);
		// dgOrderHd.setBillChargeSlpNo(billNo);
		// hbt.update(dgOrderHd);
		List<DgOrderdt> dgOrderdts = new ArrayList<DgOrderdt>();
		dgOrderdts = session.createCriteria(DgOrderdt.class)
				   .add(Restrictions.eq("Orderhd.Id", orderId)).list();
		Iterator<DgOrderdt> iterator = dgOrderdts.iterator();
		BlOpBillHeader opBillHeader = null;
		BigDecimal totalAmmount=new BigDecimal(0);
		while (iterator.hasNext()) {
			DgOrderdt dgOrderdt = (DgOrderdt) iterator.next();
			box.put(CHARGE_ID, dgOrderdt.getChargeCode().getId());
			List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		//	discountList = this.serviceDispensingAutoBilling(box); // commented by amit das on 27-06-2017
//			if (discountList.size() > 0) {
			
				BigDecimal chargeAmt = new BigDecimal(0.00);
				if (dgOrderdt.getChargeCode().getId() != 0) {
					List<MasChargeCodeRates> chargecodes=new ArrayList<MasChargeCodeRates>();
					   chargecodes=session
								.createCriteria(MasChargeCodeRates.class).createAlias("ChargeCode", "cc")
								.add(Restrictions.eq("cc.Id",dgOrderdt.getChargeCode().getId())).list();
					  /* Set<MasChargeCodeRates> rateSet = new HashSet<MasChargeCodeRates>();
						if(chargecodes.get(0).getChargeCode().getMasChargeCodeRates() != null){
							rateSet = chargecodes.get(0).getChargeCode().getMasChargeCodeRates();
						}*/
						if(chargecodes.size() > 0){
							for(MasChargeCodeRates chargeCodeRates :chargecodes){
								chargeAmt = chargeCodeRates.getRate();
								}
							}
					   else
					   {
					List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
					chargeCodeList = session
							.createCriteria(MasChargeCode.class)
							.add(Restrictions.idEq(dgOrderdt.getChargeCode().getId())).list();

					MasChargeCode masChargeCode = new MasChargeCode();
					if (chargeCodeList.size() > 0) {
						masChargeCode = chargeCodeList.get(0);
						chargeAmt = new BigDecimal(masChargeCode.getCharge());
					}
				}}
				totalAmmount.add(chargeAmt);
				if(discountList.size() > 0 || chargeAmt.compareTo(BigDecimal.ZERO)==0)
				{
					MasDiscount masDiscount =null;
					if(discountList.size() > 0)
					{
					masDiscount =discountList.get(0);
					}

				if (opBillHeader == null) {
					MasHospital hospital = new MasHospital();
					hospital.setId(hospitalId);
					opBillHeader = new BlOpBillHeader();
					String billNo = "";
					String billType = "OS";
					billNo = opBillingDataService.generateBillNo(billType, "save",hospitalId);
					opBillHeader.setBillNo(billNo);

					opBillHeader.setHospital(hospital);

					opBillHeader.setHin(patient);
					opBillHeader.setPatientStatus("r");
					opBillHeader.setHinNo(hinNo);
					opBillHeader.setVisit(visit);
					// opBillHeader.setTokenNo(Integer.parseInt(request.getParameter(TOKEN_NO)));
					opBillHeader.setPatientType(patient.getPatientType());
					opBillHeader.setPatientName(patient.getPFirstName());
					// opBillHeader.setAge(request.getParameter(AGE));
					opBillHeader.setSex(patient.getSex());
					if (visit.getDoctor() != null) {
						opBillHeader.setConsultant(visit.getDoctor());
						opBillHeader.setConsultantName(visit.getDoctor()
								.getEmployeeName());
					}
					  opBillHeader.setNetAmt(new BigDecimal(0));
					opBillHeader.setRoundOff(new BigDecimal(0));
					opBillHeader.setAdvanceAdjustment(new BigDecimal(0));
					opBillHeader.setOutstanding(new BigDecimal(0));
					opBillHeader.setDiscountOnBill(new BigDecimal(0));
					opBillHeader.setPayableAmt(new BigDecimal(0));
					opBillHeader.setActualCollectedAmt(new BigDecimal(0));
					opBillHeader.setBillDate(HMSUtil
							.convertStringTypeDateToDateType((String) utilMap
									.get("currentDate")));
					opBillHeader.setBillTime((String) utilMap
							.get("currentTime"));
					Users users = new Users();
					users.setId(userId);
					opBillHeader.setChangedBy(users);
					opBillHeader.setStatus("y");
					hbt.save(opBillHeader);

				}

				BlOpBillDetails opBillDetail = new BlOpBillDetails();
				opBillDetail.setChargeCode(dgOrderdt.getChargeCode());
				opBillDetail.setRate(chargeAmt);
				opBillDetail.setAmount(chargeAmt);
				if(discountList.size()>0)
				{

				if (masDiscount.getDiscountType().equalsIgnoreCase("d")) {
					if (masDiscount.getDiscountPercentage() != null) {
						opBillDetail.setDiscountPercent(masDiscount
								.getDiscountPercentage());
						opBillDetail.setDiscountAmt(chargeAmt);
					} else if (masDiscount.getDiscountValue() != null) {
						opBillDetail.setDiscountAmt(chargeAmt);
					}
				} else if (masDiscount.getDiscountType().equalsIgnoreCase("t")) {
					if (masDiscount.getDiscountPercentage() != null
							&& chargeAmt.compareTo(new BigDecimal(0)) <= 0) {
						opBillDetail.setDiscountPercent(masDiscount
								.getDiscountPercentage());
						opBillDetail.setDiscountAmt(chargeAmt);
					} else if (masDiscount.getDiscountValue() != null
							&& chargeAmt.add(masDiscount.getDiscountValue())
									.compareTo(new BigDecimal(0)) <= 0) {
						opBillDetail.setDiscountAmt(chargeAmt);
					}
				} else if (masDiscount.getDiscountType().equalsIgnoreCase("f")) {
					if (masDiscount.getFixedValue() != null
							&& masDiscount.getFixedValue().compareTo(
									BigDecimal.ZERO) <= 0) {
						opBillDetail.setDiscountAmt(BigDecimal.ZERO);
					}
				}
				}
				else
				{
					opBillDetail.setDiscountAmt(BigDecimal.ZERO);
				}

				BigDecimal proportionalDiscount = new BigDecimal(0);
				opBillDetail
						.setProportionalDiscountAmount(proportionalDiscount);

				BigDecimal netAmount = new BigDecimal(0);
				opBillDetail.setNetAmt(netAmount);

				opBillDetail.setQuantity(1);

				opBillDetail.setBillDate(HMSUtil
						.convertStringTypeDateToDateType((String) utilMap
								.get("currentDate")));
				opBillDetail.setBillTime((String) utilMap.get("currentTime"));
				Users users = new Users();
				users.setId(userId);
				opBillDetail.setChangedBy(users);
				opBillDetail.setOpBillHeader(opBillHeader);

				try {
					opBillHeader.setBillAmt(totalAmmount);
					opBillHeader.setDiscountAmt(chargeAmt);
					hbt.save(opBillDetail);
					opBillDetail.setRefundableStatus("y");
					dgOrderdt.setPaymentMade("y");
					dgOrderdt.setBill(opBillHeader);
					hbt.update(dgOrderdt);
					hbt.update(opBillHeader);
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				String patientUhid="";
				/*
				List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
				chargeCodeList = session
						.createCriteria(MasChargeCode.class)
						.add(Restrictions.eq("Id", dgOrderdt.getChargeCode().getId())).list();
				if (chargeCodeList.size() > 0) {
					MasChargeCode chargeCode = chargeCodeList.get(0);
				
				
				if(chargeCode.getDepartment()
						.getDepartmentType().getDepartmentTypeCode()
						.equals("RADIO")){*/
			/*	try {
					pacsMethodForPacsServer(hospitalId,orderId,patientUhid);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					new Thread(){
						
						public void run(){
							
								try {
									pacsMethodForPacsServerReceiver();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
						}
					}.start(); */
				 
				/*try{
					System.out.println("batch"); 
			        String[] command = {"cmd.exe", "/C", "Start", "D:\\PACSBat\\pac.bat"};
			        Process p =  Runtime.getRuntime().exec(command);   
					
				}catch(Exception e){
				e.printStackTrace();
				}*/

			//}
				
				//}
				}
				hbt.flush();

		}
		return null;

	}
	
	
	@Override
	public Map<String, Object> internalBillingForDispensing(
			Map<String, Object> detailsMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = HMSUtil.getCurrentDateAndTime();

		int hospitalId = 0;
		if(null !=detailsMap.get(HOSPITAL_ID))
		hospitalId=(Integer) detailsMap.get(HOSPITAL_ID);
		
		int userId =0;
		if(null !=detailsMap.get(USERID)){
			userId=	(Integer) detailsMap.get(USERID);
		}
		int hinId = 0;
		if(null !=detailsMap.get(HIN_ID)){
			hinId=	(Integer) detailsMap.get(HIN_ID);
		}
				
		int visitId = 0;
		if(null !=detailsMap.get(VISIT_ID)){
			visitId=	(Integer) detailsMap.get(VISIT_ID);
		}
		
		List<Integer> stocks = new ArrayList<Integer>();
        stocks=(List<Integer>)detailsMap.get("stock");
		List<BigDecimal> quantity = new ArrayList<BigDecimal>();
		quantity=(List<BigDecimal>)detailsMap.get("quantity");
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		BlDispensingHeader dispensingHeader = new BlDispensingHeader();
		String billNo = "";
		String billType = "OD";
		billNo = opBillingDataService.generateBillNo(billType, "save",hospitalId);
		dispensingHeader.setBillNo(billNo);

		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		dispensingHeader.setHospital(hospital);
		Patient patient = (Patient) hbt.get(Patient.class, hinId);
		Visit visit = (Visit) hbt.get(Visit.class, visitId);
         if(null !=patient){
		dispensingHeader.setHin(patient);
		dispensingHeader.setPatientStatus("r");
		dispensingHeader.setHinNo(patient.getHinNo());

		dispensingHeader.setPatientName(patient.getPFirstName());
		dispensingHeader.setAge(patient.getAge());

		dispensingHeader.setSex(patient.getSex());
         }
		if (null !=visit && visit.getDoctor() != null) {
			dispensingHeader
					.setConsultantName(visit.getDoctor().getFirstName());
		}

		dispensingHeader.setRoundOff(BigDecimal.ZERO);
		dispensingHeader.setNetAmt(BigDecimal.ZERO);
		dispensingHeader.setAdvAdjustment(BigDecimal.ZERO);
		dispensingHeader.setOutstanding(BigDecimal.ZERO);
		dispensingHeader.setDiscountOnBill(BigDecimal.ZERO);
		dispensingHeader.setPayableAmt(BigDecimal.ZERO);
		/*
		 * if (request.getParameter(AUTHORIZER_ID) != null &&
		 * !(request.getParameter(AUTHORIZER_ID).equals("0"))) { MasAuthorizer
		 * authorizer = new MasAuthorizer();
		 * authorizer.setId(Integer.parseInt(request
		 * .getParameter(AUTHORIZER_ID)));
		 * dispensingHeader.setAuthorizer(authorizer); }
		 */

		/*
		 * if (request.getParameter(EMPLOYEE_ID) != null &&
		 * !(request.getParameter(EMPLOYEE_ID).equals("0"))) { int empId =
		 * Integer.parseInt(request.getParameter(EMPLOYEE_ID)); MasEmployee
		 * employee = new MasEmployee(); employee.setId(empId);
		 * dispensingHeader.setConsultant(employee); }
		 */
		dispensingHeader.setActualCollectedAmt(BigDecimal.ZERO);
		dispensingHeader.setDiscount(new BigDecimal(100));
		dispensingHeader.setCharity(BigDecimal.ZERO);

		/*
		 * if (request.getParameter(PATIENT_TYPE_ID) != null) { MasPatientType
		 * patientType = new MasPatientType();
		 * patientType.setId(Integer.parseInt(request
		 * .getParameter(PATIENT_TYPE_ID)));
		 * dispensingHeader.setPatientType(patientType); }
		 */

		/*
		 * if (request.getParameter("companyId") != null &&
		 * !(request.getParameter("companyId").equals("0"))) { MasCompany
		 * company = new MasCompany();
		 * company.setId(Integer.parseInt(request.getParameter("companyId")));
		 * dispensingHeader.setCompany(company); }
		 */
		dispensingHeader.setBillDate(HMSUtil
				.convertStringTypeDateToDateType((String) utilMap
						.get("currentDate")));
		dispensingHeader.setBillTime((String) utilMap.get("currentTime"));

		Users userObj = new Users();
		userObj.setId(userId);

		dispensingHeader.setChangedBy(userObj);
		dispensingHeader.setStatus("y");
		/*
		 * detailsMap.put("dispensingHeader", dispensingHeader);
		 * 
		 * if (detailsMap.get("dispensingHeader") != null) dispensingHeader =
		 * (BlDispensingHeader) detailsMap .get("dispensingHeader");
		 */

		hbt.save(dispensingHeader);
		
		/*
		 * itemWiseListLength = box.getInt("hiddenValueItem");
		 * batchWiseItemListLength = box.getInt("batchNoCounter"); payListLength
		 * = box.getInt("hiddenValuePayment");
		 */
		List<BlDispensingDetails> blDispensingDetailsList=new ArrayList<BlDispensingDetails>();
		BigDecimal totalAmmDecimal = new BigDecimal(0.00);
		for (int i = 0; i < stocks.size(); i++) {
			BlDispensingDetails dispensingDetails = new BlDispensingDetails();
			dispensingDetails.setDispensingHeader(dispensingHeader);
			StoreItemBatchStock itemBatchStock = (StoreItemBatchStock) hbt.get(
					StoreItemBatchStock.class, stocks.get(i));

			dispensingDetails.setItem(itemBatchStock.getItem());
			dispensingDetails.setBatch(itemBatchStock);
			dispensingDetails.setQty(quantity.get(i));
			BigDecimal desprice=new BigDecimal(0);
			if(itemBatchStock.getDispencingPrice()!=null){
				desprice=itemBatchStock.getDispencingPrice();
			}
			dispensingDetails.setAmount(desprice
					.multiply(quantity.get(i)));
			totalAmmDecimal.add(desprice.multiply(
					quantity.get(i)));
			dispensingDetails.setDiscountPercent(new BigDecimal(100));
			dispensingDetails.setDiscountAmt(desprice.multiply(quantity.get(i)));
			dispensingDetails.setProportionalDisAmt(BigDecimal.ZERO);
			BigDecimal saleTax=new BigDecimal(0);
			if(itemBatchStock.getSalesTax()!=null){
				saleTax=itemBatchStock.getSalesTax();
			}
			dispensingDetails.setSalesTaxAmt(saleTax
					.multiply(quantity.get(i)));
			dispensingDetails.setNetAmt(BigDecimal.ZERO);
			dispensingDetails.setRefundableStatus("n");
			dispensingDetails.setIssued("y");
			hbt.save(dispensingDetails);
			blDispensingDetailsList.add(dispensingDetails);
		}
		dispensingHeader.setBillAmt(totalAmmDecimal);

		dispensingHeader.setDiscountAmt(totalAmmDecimal);
		hbt.update(dispensingHeader); 		
		hbt.flush();
		hbt.clear();
		map.put("dispensingHeader", dispensingHeader);
		map.put("blDispensingDetailsList", blDispensingDetailsList);
		return map;

	}
	
	
	@Override
	public List<MasDiscount> serviceDispensingForBilling(Box box) {
		List<MasDiscount> localDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> discountList=new ArrayList<MasDiscount>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int patientId=box.getInt(HIN_ID);
		int chargeId=box.getInt(CHARGE_ID);
		int itemId=box.getInt(ITEM_ID);
		int inpatientId=box.getInt(INPATIENT_ID);
		int visitId=box.getInt(VISIT_ID);
		Patient patient=null;
		MasChargeCode chargeCode=null;
		MasStoreItem item=null;
		Inpatient inpatient=null;
		
		String billtypedispensing="";
		String billtypeservic="";
		java.net.URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop
					.getProperty("billtypedispensing");
			billtypeservic = prop
					.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			patient=(Patient)hbt.get(Patient.class, patientId);
		if(chargeId!=0)
		{
			chargeCode=(MasChargeCode)hbt.get(MasChargeCode.class, chargeId);
		}
		if(itemId!=0)
		{
			item=(MasStoreItem)hbt.get(MasStoreItem.class, itemId);
		}
		if(inpatientId!=0)
		{
			inpatient=(Inpatient)hbt.get(Inpatient.class, inpatientId);
		}
		
		
		
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		if(patient.getDateOfBirth()!=null)
			cal.setTime(patient.getDateOfBirth());
		int calculatedYear;
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		calculatedYear = currentYear - birthYear;
		
		
		String hql = "select masdiscount from jkt.hms.masters.business.MasDiscount as masdiscount "
				+ "inner join masdiscount.BillType as billType"
				+ " left outer join masdiscount.PatientType as patientType"
				+ " left outer join masdiscount.OtherCategory as otherCategory"
				+ " left outer join masdiscount.Department as department"
				+ " left outer join masdiscount.MainChargecode as mainChargecode"
				+ " left outer join masdiscount.SubChargecode as subChargecode"
				+ " left outer join masdiscount.ChargeCode as chargeCode"
				+ " left outer join masdiscount.Group as storegroup"
				+ " left outer join masdiscount.ItemType as itemType"
				+ " left outer join masdiscount.ItemSection as itemSection"
				+ " left outer join masdiscount.ItemCategory as itemCategory"
				+ " left outer join masdiscount.ItemClass as itemClass"
				+ " left outer join masdiscount.Item as item"
				+ " where (masdiscount.BplStatus is null or (masdiscount.BplStatus=:bplStatus))"
				+ " and ( patientType is null or patientType.Id=:socialCategoryid )"
				+ " and ( otherCategory is null or otherCategory.Id in "
				+ "(select otherCat.Id FROM  jkt.hms.masters.business.PatientCategoryDetails oCategory "
				+ " inner join oCategory.OtherCategory otherCat "
				+ " inner join oCategory.Hin hin where hin.Id=:patientId ) )"
				+ " and (masdiscount.PatientCategory is null "
				+ " or (masdiscount.PatientCategory='IP' and (masdiscount.PatientCategory=:patientStatus and "
				+ "(department is null or(department.Id=:departmentId))) )"
				+ " or (masdiscount.PatientCategory='OP' and masdiscount.PatientCategory=:patientStatus ))"

				+ " and ((billType.BillTypeCode=:billTypeService "
				+ " and (mainChargecode is null or mainChargecode.Id=:mainChargecodeId)"
				+ " and (subChargecode is null or subChargecode.Id=:subChargecodeId)"
				+ " and (chargeCode is null or chargeCode.Id=:chargeCodeId)"
				+ " and :chargeCodeId not in(select charge.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Charge charge where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y') )"
				+ "  or (billType.BillTypeCode=:billTypeDispensing "
				+ " and ( storegroup is null or storegroup.Id=:groupId)"
				+ " and ( itemType is null or itemType.Id=:itemTypeId) "
				+ " and ( itemSection is null or itemSection.Id=:itemSectionId) "
				+ " and ( itemCategory is null or itemCategory.Id=:itemCategoryId) "
				+ " and ( itemClass is null or itemClass.Id=:itemClassId) "
				+ " and ( item is null or item.Id=:itemId) "				
				+ " and :itemId not in(select item.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Item item where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y')  ) )"
                
				/*+ " and (masdiscount.FromAge is null or (masdiscount.FromAge>=:age))"
				+ " and (masdiscount.ToAge is null or (masdiscount.ToAge<=:age))"*/

				+ " and (masdiscount.EffectiveDateFrom is null or (masdiscount.EffectiveDateFrom<=:currentDate))"
				+ " and (masdiscount.EffectiveDateTo is null or (masdiscount.EffectiveDateTo>=:currentDate))"

				+ "";

		Query query=session.createQuery(hql);
		query.setParameter("bplStatus", patient.getBplStatus());
		query.setParameter("socialCategoryid", patient.getPatientType()!=null?patient.getPatientType().getId():0);
		query.setParameter("patientId",patientId);
		if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("In Patient"))
		{
		query.setParameter("patientStatus","IP");
		} else if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("Out Patient"))
		{
		query.setParameter("patientStatus","OP");
		}
		else 
		{
		query.setParameter("patientStatus",null);
		}
		if(inpatient!=null)
		{
			query.setParameter("departmentId",inpatient.getDepartment().getId());
		}
		else
		{
			query.setParameter("departmentId",0);

		}
		
		query.setParameter("billTypeService",billtypeservic);
		if( chargeCode !=null)
		{
		query.setParameter("mainChargecodeId",chargeCode.getMainChargecode().getId());
		query.setParameter("subChargecodeId",chargeCode.getSubChargecode().getId());
		query.setParameter("chargeCodeId",chargeCode.getId());
		}
		else
		{
			query.setParameter("mainChargecodeId",0);
			query.setParameter("subChargecodeId",0);
			query.setParameter("chargeCodeId",chargeCode.getId());
		}
		query.setParameter("billTypeDispensing",billtypedispensing);
		if(item!=null)
		{
		query.setParameter("groupId",item.getGroup().getId());
		query.setParameter("itemTypeId",item.getItemType()!=null?item.getItemType().getId():0);
		query.setParameter("itemCategoryId",item.getItemCategory()!=null?item.getItemCategory().getId():0);
		query.setParameter("itemSectionId",item.getSection()!=null?item.getSection().getId():0);
		query.setParameter("itemClassId",item.getItemClass()!=null?item.getItemClass().getId():0);
		query.setParameter("itemId",item.getId());
		}
		else
		{
			query.setParameter("groupId",0);
			query.setParameter("itemTypeId",0);
			query.setParameter("itemCategoryId",0);
			query.setParameter("itemSectionId",0);
			query.setParameter("itemClassId",0);
			query.setParameter("itemId",0);
		}
		
/*		query.setParameter("age",new BigDecimal(calculatedYear));
*/		
		query.setParameter("currentDate",HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
		
		localDiscountList=query.list();
		
		
		// ---------------------------Calculation for last cost
		// price---------------------------------//
		BigDecimal totalCostPriceForConsumption = new BigDecimal(0.00);
		if(itemId!=0)
		{
		List<Integer> storeItemBatchStockList = new ArrayList<Integer>();
		List<StoreItemBatchStock> storeItemBatchStockForLastCostPrice = new ArrayList<StoreItemBatchStock>();
		
		Criteria criteria = session.createCriteria(
				StoreItemBatchStock.class).createAlias("Item", "item")
				.add(Restrictions.eq("item.Id", itemId)).createAlias(
						"Department", "dept");
		if(inpatient==null)
		{					
						criteria.add(
						Restrictions.eq("dept.DepartmentCode", "PHAR"));				
		}
		else
		{
			criteria.add(
					Restrictions.eq("dept.Id", inpatient.getDepartment().getId()));
		}
		criteria.setProjection(Projections.max("Id"));
		storeItemBatchStockList=criteria.list();
		if (storeItemBatchStockList.size() > 0
				&& storeItemBatchStockList.get(0) != null) {
			int storeItemBatchStockId = storeItemBatchStockList.get(0);
			storeItemBatchStockForLastCostPrice = session
					.createCriteria(StoreItemBatchStock.class).add(
							Restrictions.idEq(storeItemBatchStockId))
					.list();
			if (storeItemBatchStockForLastCostPrice.size() > 0) {
				for (StoreItemBatchStock storeItemBatchStock : storeItemBatchStockForLastCostPrice) {
					BigDecimal costPrice = storeItemBatchStock
							.getCostPrice();
					if(costPrice!=null && !costPrice.equals(""))
					totalCostPriceForConsumption = totalCostPriceForConsumption
							.add(costPrice);
				}
			}
		}
		}
		BigDecimal chargeAmt = new BigDecimal(0.00);
		if(chargeId!=0)
		{
			List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.idEq(chargeId)).list();
					
					
			MasChargeCode masChargeCode = new MasChargeCode();
			if (chargeCodeList.size() > 0) {
				masChargeCode = chargeCodeList.get(0);
				chargeAmt = new BigDecimal(masChargeCode.getCharge());
				
				/*// BigDecimal chargeAmt = new BigDecimal(masChargeCode.getCharge());

				Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
				// if (masChargeCode.getMasChargeCodeRates() != null &&
				// masChargeCode.getMasChargeCodeRates().size() >0) {
				chargeSet = masChargeCode.getMasChargeCodeRates();
				if (chargeSet.size() > 0) {
					for (MasChargeCodeRates chargeRate : chargeSet) {
						if (currentDate
								.compareTo(chargeRate.getEffectiveFromDate()) >= 0
								&& (chargeRate.getEffectiveToDate() == null || currentDate
										.compareTo(chargeRate.getEffectiveToDate()) <= 0)) {
							// ---Added by dipali for nabh And cghs
							if (nabhHospital.equalsIgnoreCase("y")	&& patientTypeId == 1) {
								if (rateApplicable == 4) {
									chargeAmt = new BigDecimal(String
											.valueOf(chargeRate.getChargeCode()
													.getChargeNabh()));
								} else {
									chargeAmt = chargeRate.getRate();
								}
							} else if (nabhHospital.equalsIgnoreCase("n")
									&& patientTypeId == 1) {
								if (rateApplicable != 0 && rateApplicable == 4) {
									chargeAmt = new BigDecimal(String
											.valueOf(chargeRate.getChargeCode()
													.getChargeNonNabh()));
								} else {
									chargeAmt = chargeRate.getRate();
								}
							} else {

								chargeAmt = chargeRate.getRate();
							}
							// ----------------------------------------
							// chargeAmt = chargeRate.getRate();
							break;
						} else {
							chargeAmt = new BigDecimal(masChargeCode.getCharge());
						}

					}

				} else {
					if (nabhHospital.equalsIgnoreCase("y") && patientTypeId == 1) {
						if (rateApplicable == 4) {
							chargeAmt = new BigDecimal(String.valueOf(masChargeCode
									.getChargeNabh()));
						} else {
							chargeAmt = new BigDecimal(masChargeCode.getCharge());
						}
					} else if (nabhHospital.equalsIgnoreCase("n") && patientTypeId == 1) {
						if (rateApplicable == 4) {
							chargeAmt = new BigDecimal(String.valueOf(masChargeCode
									.getChargeNonNabh()));
						} else {
							chargeAmt = new BigDecimal(masChargeCode.getCharge());
						}
					} else {
						chargeAmt = new BigDecimal(masChargeCode.getCharge());
					}
					// ----------------------------------------
					// chargeAmt = chargeRate.getRate();
				}
				actAmount = chargeAmt.add(balaceId);*/

			}
		}
		
		discountList=localDiscountList;
		return discountList;
	}
	
	@Override
	public List<MasDiscount> serviceDispensingScheme(Box box) {
		List<MasDiscount> tempDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> localDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> discountList=new ArrayList<MasDiscount>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int patientId=box.getInt(HIN_ID);
		int chargeId=box.getInt(CHARGE_ID);
		int itemId=box.getInt(ITEM_ID);
		int inpatientId=box.getInt(INPATIENT_ID);
		int visitId=box.getInt(VISIT_ID);
		int roomTypeId=box.getInt("roomtypeId");
		int paywardId=box.getInt("ward");
		int schemeId=box.getInt("schemeId");
		int hospitalId=box.getInt(HOSPITAL_ID);
		boolean isPaywardBooking=box.getBoolean("isPaywardBooking");
		
		Patient patient=null;
		MasChargeCode chargeCode=null;
		MasStoreItem item=null;
		Inpatient inpatient=null;
		
		String billtypedispensing="";
		String billtypeservic="";
		java.net.URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop
					.getProperty("billtypedispensing");
			billtypeservic = prop
					.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}		
			patient=(Patient)hbt.get(Patient.class, patientId);
		if(chargeId!=0)
		{
			chargeCode=(MasChargeCode)hbt.get(MasChargeCode.class, chargeId);
		}
		if(itemId!=0)
		{
			item=(MasStoreItem)hbt.get(MasStoreItem.class, itemId);
		}
		if(inpatientId!=0)
		{
			inpatient=(Inpatient)hbt.get(Inpatient.class, inpatientId);
			if(roomTypeId==0)
			{
				roomTypeId=inpatient.getBed().getRoom().getRoomType().getId();
			}
			if(paywardId==0)
			{
				paywardId=inpatient.getDepartment().getId();
			}
		}		
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		if(patient.getDateOfBirth()!=null)
			cal.setTime(patient.getDateOfBirth());
		int calculatedYear;
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		calculatedYear = currentYear - birthYear;
		
		
		String hql = "select masdiscount from jkt.hms.masters.business.MasDiscount as masdiscount "
				+ "inner join masdiscount.BillType as billType"
				+ " left outer join masdiscount.PatientType as patientType"
				+ " left outer join masdiscount.OtherCategory as otherCategory"
				+ " left outer join masdiscount.Department as department"
				+ " left outer join masdiscount.RoomType as roomType"
				+ " left outer join masdiscount.MainChargecode as mainChargecode"
				+ " left outer join masdiscount.SubChargecode as subChargecode"
				+ " left outer join masdiscount.ChargeCode as chargeCode"
				+ " left outer join masdiscount.Group as storegroup"
				+ " left outer join masdiscount.ItemType as itemType"
				+ " left outer join masdiscount.ItemSection as itemSection"
				+ " left outer join masdiscount.ItemCategory as itemCategory"
				+ " left outer join masdiscount.ItemClass as itemClass"
				+ " left outer join masdiscount.Item as item"
				+ " where masdiscount.Scheme is not null and masdiscount.Scheme.Id=:schemeId and "
				+ " (masdiscount.BplStatus is null or (masdiscount.BplStatus=:bplStatus))"
				+ " and ( patientType is null or patientType.Id=:socialCategoryid )"
				+ " and ( otherCategory is null or otherCategory.Id in "
				+ "(select otherCat.Id FROM  jkt.hms.masters.business.PatientCategoryDetails oCategory "
				+ " inner join oCategory.OtherCategory otherCat "
				+ " inner join oCategory.Hin hin where hin.Id=:patientId ) )"
				+ " and (masdiscount.PatientCategory is null "
				+ " or (masdiscount.PatientCategory=:patientStatus and "
				+ "(department is null or department.Id=:departmentId) "
				+ " and (roomType is null or roomType.Id=:roomTypeId)))"
				
/*+ " and (masdiscount.PatientCategory is null "
+ " or (masdiscount.PatientCategory='IP' and (masdiscount.PatientCategory=:patientStatus and "
+ "(department is null or(department.Id=:departmentId))) )"
+ " or (masdiscount.PatientCategory='OP' and masdiscount.PatientCategory=:patientStatus ))"*/

				+ " and ((billType.BillTypeCode=:billTypeService "
				+ " and (mainChargecode is null or mainChargecode.Id=:mainChargecodeId)"
				+ " and (subChargecode is null or subChargecode.Id=:subChargecodeId)"
				+ " and (chargeCode is null or chargeCode.Id=:chargeCodeId)"
				+ " and :chargeCodeId not in(select charge.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Charge charge where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y') )"
				+ "  or (billType.BillTypeCode=:billTypeDispensing "
				+ " and ( storegroup is null or storegroup.Id=:groupId)"
				+ " and ( itemType is null or itemType.Id=:itemTypeId) "
				+ " and ( itemSection is null or itemSection.Id=:itemSectionId) "
				+ " and ( itemCategory is null or itemCategory.Id=:itemCategoryId) "
				+ " and ( itemClass is null or itemClass.Id=:itemClassId) "
				+ " and ( item is null or item.Id=:itemId) "				
				+ " and :itemId not in(select item.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Item item where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y')  ) )"
                
				+ " and (masdiscount.FromAge is null or (masdiscount.FromAge<=:age))"
				+ " and (masdiscount.ToAge is null or (masdiscount.ToAge>=:age))"

				+ " and (masdiscount.EffectiveDateFrom is null or (masdiscount.EffectiveDateFrom<=:currentDate))"
				+ " and (masdiscount.EffectiveDateTo is null or (masdiscount.EffectiveDateTo>=:currentDate))"

				+ "";

		Query query=session.createQuery(hql);
		query.setParameter("schemeId", schemeId);
		query.setParameter("bplStatus", patient.getBplStatus());
		query.setParameter("socialCategoryid", patient.getPatientType()!=null?patient.getPatientType().getId():0);
		query.setParameter("patientId",patientId);
		if(!isPaywardBooking)
		{
		if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("In Patient"))
		{
		query.setParameter("patientStatus","IP");
		} else if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("Out Patient"))
		{
		query.setParameter("patientStatus","OP");
		}
		else 
		{
		query.setParameter("patientStatus",null);
		}
		}
		else
		{
			query.setParameter("patientStatus","IP");
		}
		
		query.setParameter("departmentId",paywardId);
		query.setParameter("roomTypeId",roomTypeId);
		
		query.setParameter("billTypeService",billtypeservic);
		if( chargeCode !=null)
		{
		query.setParameter("mainChargecodeId",chargeCode.getMainChargecode().getId());
		query.setParameter("subChargecodeId",chargeCode.getSubChargecode().getId());
		query.setParameter("chargeCodeId",chargeCode.getId());
		}
		else
		{
			query.setParameter("mainChargecodeId",0);
			query.setParameter("subChargecodeId",0);
			query.setParameter("chargeCodeId",0);
		}
		query.setParameter("billTypeDispensing",billtypedispensing);
		if(item!=null)
		{
		query.setParameter("groupId",item.getGroup().getId());
		query.setParameter("itemTypeId",item.getItemType()!=null?item.getItemType().getId():0);
		query.setParameter("itemCategoryId",item.getItemCategory()!=null?item.getItemCategory().getId():0);
		query.setParameter("itemSectionId",item.getSection()!=null?item.getSection().getId():0);
		query.setParameter("itemClassId",item.getItemClass()!=null?item.getItemClass().getId():0);
		query.setParameter("itemId",item.getId());
		}
		else
		{
			query.setParameter("groupId",0);
			query.setParameter("itemTypeId",0);
			query.setParameter("itemCategoryId",0);
			query.setParameter("itemSectionId",0);
			query.setParameter("itemClassId",0);
			query.setParameter("itemId",0);
		}
		
		query.setParameter("age",new BigDecimal(calculatedYear));
		query.setParameter("currentDate",HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
		
		tempDiscountList=query.list();
		
		
		// ---------------------------Calculation for last cost
		// price---------------------------------//
		BigDecimal totalCostPriceForConsumption = new BigDecimal(0.00);
		if(itemId!=0)
		{
		List<Integer> storeItemBatchStockList = new ArrayList<Integer>();
		List<StoreItemBatchStock> storeItemBatchStockForLastCostPrice = new ArrayList<StoreItemBatchStock>();
		
		Criteria criteria = session.createCriteria(
				StoreItemBatchStock.class).createAlias("Item", "item")
				.add(Restrictions.eq("item.Id", itemId)).createAlias(
						"Department", "dept");
		if(inpatient==null)
		{					
						criteria.add(
						Restrictions.eq("dept.DepartmentCode", "PHAR"));				
		}
		else
		{
			criteria.add(
					Restrictions.eq("dept.Id", inpatient.getDepartment().getId()));
		}
		criteria.setProjection(Projections.max("Id"));
		storeItemBatchStockList=criteria.list();
		if (storeItemBatchStockList.size() > 0
				&& storeItemBatchStockList.get(0) != null) {
			int storeItemBatchStockId = storeItemBatchStockList.get(0);
			storeItemBatchStockForLastCostPrice = session
					.createCriteria(StoreItemBatchStock.class).add(
							Restrictions.idEq(storeItemBatchStockId))
					.list();
			if (storeItemBatchStockForLastCostPrice.size() > 0) {
				for (StoreItemBatchStock storeItemBatchStock : storeItemBatchStockForLastCostPrice) {
					BigDecimal costPrice = storeItemBatchStock
							.getCostPrice();
					if(costPrice!=null && !costPrice.equals(""))
					totalCostPriceForConsumption = totalCostPriceForConsumption
							.add(costPrice);
				}
			}
		}
		}
		BigDecimal chargeAmt = new BigDecimal(0.00);
		if(chargeId!=0)
		{
			List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.idEq(chargeId)).list();
					
					
			MasChargeCode masChargeCode = new MasChargeCode();
			if (chargeCodeList.size() > 0) {
				masChargeCode = chargeCodeList.get(0);
				chargeAmt = new BigDecimal(masChargeCode.getCharge());
				List<MasChargeCodeRates> chargeCodeRates=new ArrayList<MasChargeCodeRates>();
				chargeCodeRates=session.createCriteria(MasChargeCodeRates.class)
						 .add(Restrictions.eq("ChargeCode.Id", masChargeCode.getId()))
						 .add(Restrictions.eq("Hospital.Id", hospitalId))
						.list();
				if(chargeCodeRates.size()>0 && chargeCodeRates.get(0).getRate()!=null)
				{
					chargeAmt=chargeCodeRates.get(0).getRate();
				}
				else if(masChargeCode.getCharge()!=null)
				{
					chargeAmt=new BigDecimal(masChargeCode.getCharge());
				}
				
			}
		}
		
		
		for (MasDiscount masDiscount : tempDiscountList) {
			if(masDiscount.getHospital()!=null && masDiscount.getHospital().getId()==hospitalId)
			{
				localDiscountList.add(masDiscount);
			}
		}
		if(localDiscountList.size()==0)
		{
			localDiscountList=tempDiscountList;
		}
		
		BigDecimal rate=new BigDecimal(0.00);  
		
		if(itemId!=0 )
		{
			rate=totalCostPriceForConsumption;
		}
		else if(chargeId!=0 )
		{
			rate=chargeAmt;
		}
		
		for (MasDiscount masDiscount : localDiscountList) {
			BigDecimal maxDiscount=new BigDecimal(0.00);
			BigDecimal currentDiscount=new BigDecimal(0.00);
			MasDiscount maxMasDiscount=null;
			List<MasDiscountDiagnosis> diagnosiList=new ArrayList<MasDiscountDiagnosis>();
			diagnosiList=session.createCriteria(MasDiscountDiagnosis.class)
					.createAlias("Discount","discount")
					.add(Restrictions.eq("discount.Id", masDiscount.getId()))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			List<DischargeIcdCode> dischargeIcdCodeList=new ArrayList<DischargeIcdCode>();
			if(inpatient!=null)
			{
				dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
			             .add(Restrictions.eq("Inpatient.Id", inpatient.getId())).list();
			}
			else
			{
				dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
			             .add(Restrictions.eq("Visit.Id", visitId)).list();
			}
			if(diagnosiList.size()!=0)
			{			
				boolean diagnosismatched=false;
				for (MasDiscountDiagnosis masDiscountDiagnosis : diagnosiList) {
					for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
						if(masDiscountDiagnosis.getIcd().getId()==dischargeIcdCode.getIcd().getId())
						{
							diagnosismatched=true;
							break;
						}
					}
					if(diagnosismatched)
					{
						break;
					}
				}
				if(!diagnosismatched)
				{
					continue;
				}
			}
			if(masDiscount.getDiscountType().equalsIgnoreCase("d"))
			{
			if (masDiscount.getDiscountPercentage() != null) {
				currentDiscount=(masDiscount.getDiscountPercentage().multiply(rate)).divide(new BigDecimal(100));
			}
			if (masDiscount.getDiscountValue() != null) {
				currentDiscount=masDiscount.getDiscountValue();
			}
			}
			else if(masDiscount.getDiscountType().equalsIgnoreCase("t"))
			{
				
					if(masDiscount.getDiscountPercentage()!=null)
					{
						currentDiscount=((masDiscount.getDiscountPercentage().multiply(rate)).divide(new BigDecimal(100))).multiply(new BigDecimal(-1));
					}
					else if(masDiscount.getDiscountValue()!=null)
					{
						currentDiscount=masDiscount.getDiscountValue().multiply(new BigDecimal(-1));
					}
				
			}
			else if(masDiscount.getDiscountType().equalsIgnoreCase("f"))
			{
				currentDiscount=rate.subtract(masDiscount.getFixedValue());
			}
			if(currentDiscount.compareTo(maxDiscount)>=0)
			{
				discountList.clear();
				discountList.add(masDiscount);	
			}
		}
		if(discountList.size()==0 && localDiscountList.size()>0)
		{
			discountList.add(localDiscountList.get(0));	
		}
		return discountList;
	}
	
	@Override
	public List<MasScheme> listScheme(Box box)
	{
		List<MasDiscount> localDiscountList=new ArrayList<MasDiscount>();
		List<MasDiscount> discountList=new ArrayList<MasDiscount>();
		List<MasScheme> schemeList=new ArrayList<MasScheme>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int patientId=box.getInt(HIN_ID);
		//int chargeId=box.getInt(CHARGE_ID);
		//int itemId=box.getInt(ITEM_ID);
		int inpatientId=box.getInt(INPATIENT_ID);
		int visitId=box.getInt(VISIT_ID);
		int roomTypeId=box.getInt("roomtypeId");
		int paywardId=box.getInt("ward");
		boolean isPaywardBooking=box.getBoolean("isPaywardBooking");
		
		
		String rsbyCardFlag=box.getString("rsbyCardFlag");
		
		Patient patient=null;
//		MasChargeCode chargeCode=null;
//		MasStoreItem item=null;
		Inpatient inpatient=null;
		
		String billtypedispensing="";
		String billtypeservic="";
		java.net.URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("account.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			billtypedispensing = prop
					.getProperty("billtypedispensing");
			billtypeservic = prop
					.getProperty("billtypeservic");
		} catch (IOException e) {
			e.printStackTrace();
		}		
			if(patientId==0 && inpatientId!=0){
				inpatient=(Inpatient)hbt.get(Inpatient.class, inpatientId);
				patientId = inpatient.getHin().getId();
			}
			patient=(Patient)hbt.get(Patient.class, patientId);
//		if(chargeId!=0)
//		{
//			chargeCode=(MasChargeCode)hbt.get(MasChargeCode.class, chargeId);
//		}
//		if(itemId!=0)
//		{
//			item=(MasStoreItem)hbt.get(MasStoreItem.class, itemId);
//		}
		if(inpatientId!=0)
		{
			inpatient=(Inpatient)hbt.get(Inpatient.class, inpatientId);
			if(roomTypeId==0)
			{
				roomTypeId=inpatient.getBed().getRoom().getRoomType().getId();
			}
			if(paywardId==0)
			{
				paywardId=inpatient.getDepartment().getId();
			}
		}		
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		if(patient!=null && patient.getDateOfBirth()!=null)
		cal.setTime(patient.getDateOfBirth());
		int calculatedYear;
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);
		calculatedYear = currentYear - birthYear;
		
		
		String hql = "select masdiscount from jkt.hms.masters.business.MasDiscount as masdiscount "
				+ "inner join masdiscount.BillType as billType"
				+ " left outer join masdiscount.PatientType as patientType"
				+ " left outer join masdiscount.OtherCategory as otherCategory"
				+ " left outer join masdiscount.Department as department"
				+ " left outer join masdiscount.RoomType as roomType"
				+ " left outer join masdiscount.MainChargecode as mainChargecode"
				+ " left outer join masdiscount.SubChargecode as subChargecode"
				+ " left outer join masdiscount.ChargeCode as chargeCode"
				+ " left outer join masdiscount.Group as storegroup"
				+ " left outer join masdiscount.ItemType as itemType"
				+ " left outer join masdiscount.ItemSection as itemSection"
				+ " left outer join masdiscount.ItemCategory as itemCategory"
				+ " left outer join masdiscount.ItemClass as itemClass"
				+ " left outer join masdiscount.Item as item"
				+ " where masdiscount.Scheme is not null "
				+ " and ( patientType is null or patientType.Id=:socialCategoryid )"
				+ " and ( otherCategory is null or otherCategory.Id in "
				+ "(select otherCat.Id FROM  jkt.hms.masters.business.PatientCategoryDetails oCategory "
				+ " inner join oCategory.OtherCategory otherCat "
				+ " inner join oCategory.Hin hin where hin.Id=:patientId ) )"
				+ " and (masdiscount.PatientCategory is null "
				+ " or masdiscount.PatientCategory=:patientStatus) and "
				+ "(department is null or department.Id=:departmentId) "
				+ " and (roomType is null or roomType.Id=:roomTypeId)"
				+ " and (masdiscount.RsbyCard is null or masdiscount.RsbyCard=:rsbyCard)"  // added by Amit Das on 05-03-2016
				
/*+ " and (masdiscount.PatientCategory is null "
+ " or (masdiscount.PatientCategory='IP' and (masdiscount.PatientCategory=:patientStatus and "
+ "(department is null or(department.Id=:departmentId))) )"
+ " or (masdiscount.PatientCategory='OP' and masdiscount.PatientCategory=:patientStatus ))"*/

				/*+ " and ((billType.BillTypeCode=:billTypeService "
				+ " and (mainChargecode is null or mainChargecode.Id=:mainChargecodeId)"
				+ " and (subChargecode is null or subChargecode.Id=:subChargecodeId)"
				+ " and (chargeCode is null or chargeCode.Id=:chargeCodeId)"
				+ " and :chargeCodeId not in(select charge.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Charge charge where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y') )"
				+ "  or (billType.BillTypeCode=:billTypeDispensing "
				+ " and ( storegroup is null or storegroup.Id=:groupId)"
				+ " and ( itemType is null or itemType.Id=:itemTypeId) "
				+ " and ( itemSection is null or itemSection.Id=:itemSectionId) "
				+ " and ( itemCategory is null or itemCategory.Id=:itemCategoryId) "
				+ " and ( itemClass is null or itemClass.Id=:itemClassId) "
				+ " and ( item is null or item.Id=:itemId) "				
				+ " and :itemId not in(select item.Id from jkt.hms.masters.business.MasDiscountExclude disexcl "
				+ " inner join  disexcl.Discount discount inner join  disexcl.Item item where "
				+ "   discount.Id=masdiscount.Id and lower(disexcl.Status)='y')  ) )"*/
                
				+ " and (masdiscount.FromAge is null or (masdiscount.FromAge<=:age))"
				+ " and (masdiscount.ToAge is null or (masdiscount.ToAge>=:age))"

				+ " and (masdiscount.EffectiveDateFrom is null or (masdiscount.EffectiveDateFrom<=:currentDate))"
				+ " and (masdiscount.EffectiveDateTo is null or (masdiscount.EffectiveDateTo>=:currentDate))"

				+ "";
		
		String patientBplStatus = patient.getBplStatus();
		
		// added by amit das on 20-05-2017
		/*if(patientBplStatus!=null && !patientBplStatus.trim().equals("")){
			hql  = hql+ " and (masdiscount.BplStatus=:bplStatus)";
		}else{
			hql  = hql+ " and (masdiscount.BplStatus is null or masdiscount.BplStatus = '')";
		}
		 */
		// commenetd by amit das on 02-06-2017
		
		Query query=session.createQuery(hql);
		

		// added by amit das on 20-05-2017
		
		/*if(patientBplStatus!=null && !patientBplStatus.trim().equals(""))
		query.setParameter("bplStatus", patient.getBplStatus());
		*/
		// commenetd by amit das on 02-06-2017
		
		
		query.setParameter("socialCategoryid", patient.getPatientType()!=null?patient.getPatientType().getId():0);
		
		
		query.setParameter("patientId",patientId);
		if(!isPaywardBooking)
		{
		if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("In Patient"))
		{
		query.setParameter("patientStatus","IP");
		} else if(patient.getPatientStatus()!=null && patient.getPatientStatus().equalsIgnoreCase("Out Patient"))
		{
		query.setParameter("patientStatus","OP");
		}
		else 
		{
		query.setParameter("patientStatus",null);
		}
		}
		else
		{
			query.setParameter("patientStatus","IP");
		}
		
		query.setParameter("departmentId",paywardId);
		query.setParameter("roomTypeId",roomTypeId);
		
		query.setParameter("rsbyCard",rsbyCardFlag);
		
		
		
		query.setParameter("age",new BigDecimal(calculatedYear));
		query.setParameter("currentDate",HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
		
		
		localDiscountList=query.list();
		
		
		
		/*for (MasDiscount masDiscount : localDiscountList) {
			List<MasDiscountDiagnosis> diagnosiList=new ArrayList<MasDiscountDiagnosis>();
			diagnosiList=session.createCriteria(MasDiscountDiagnosis.class)
					.createAlias("Discount","discount")
					.add(Restrictions.eq("discount.Id", masDiscount.getId()))
										.add(Restrictions.eq("Status", "y").ignoreCase()).list();

					//System.out.println("digons-----"+diagnosiList.size());
			
			List<DischargeIcdCode> dischargeIcdCodeList=new ArrayList<DischargeIcdCode>();
			if(inpatient!=null)
			{
				dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
			             .add(Restrictions.eq("Inpatient.Id", inpatient.getId())).list();
			}
			else
			{  //System.out.println("visit"+visitId);
				dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
			             .add(Restrictions.eq("Visit.Id", visitId)).list();
			}
			if(diagnosiList.size()!=0)
			{			
				boolean diagnosismatched=false;
				for (MasDiscountDiagnosis masDiscountDiagnosis : diagnosiList) {
					for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
						if(masDiscountDiagnosis.getIcd().getId()==dischargeIcdCode.getIcd().getId())
						{
							diagnosismatched=true;
							break;
						}
					}
					if(diagnosismatched)
					{
						break;
					}
				}
				if(!diagnosismatched)
				{
					continue;
				}
			}
			discountList.add(masDiscount);
		
		}*/
		//for (MasDiscount discount : discountList) {
		for (MasDiscount discount : localDiscountList) {
			MasScheme masScheme=(MasScheme) hbt.get(MasScheme.class, discount.getScheme().getId());
			schemeList.add(masScheme);
		}
		//System.out.println("schemelist"+schemeList.size());
		return schemeList;
	
		
	}

	// ----------------------------------Scheme------------------------------------

	public boolean addScheme(MasScheme masScheme,Map<String, Object> objectMap) {
		boolean saveFlag = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masScheme);
			
			
			if (objectMap.get("accountList") != null) {

				String[] acc = (String[]) objectMap.get("accountList");
				if (acc != null && acc.length > 0) {
					for (String a : acc) {
						FaSchemeAccountMapping fsam = new FaSchemeAccountMapping();
						
						FaMasAccount account = new FaMasAccount();
						if (null != a && !a.equals("0"))
							account.setId(Integer.parseInt(a));
						
						fsam.setAccount(account);
						fsam.setScheme(masScheme);
						
						hbt.save(fsam);
						hbt.refresh(fsam);
						hbt.refresh(masScheme);
					}

				}

			}
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteScheme(int schemeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasScheme masScheme = new MasScheme();
		masScheme = (MasScheme) getHibernateTemplate().load(MasScheme.class,
				schemeId);
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masScheme.setStatus("N");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masScheme.setStatus("Y");
				dataDeleted = false;
			}
		}
		
		Users users=new Users();
		users.setId(userId);
		masScheme.setLastChgBy(users);
		

		masScheme.setLastChgDate(currentDate);
		masScheme.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masScheme);
		return dataDeleted;
	}

	public boolean editScheme(Map<String, Object> generalMap) {

		boolean dataUpdated = false;

		
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int schemeId = 0;
		String schemeName = "";
		@SuppressWarnings("unused")
		String schemeCode = "";
		String letterFlag = "";
		String schemeType="";
		int genderId=0;
		Integer fromAge=null;
		Integer toAge=null;
		int priority = 0;
		String pkgFlag ="";
		long limit=0;
		String fromAgeUnit="";
		String toAgeUnit="";
		String patientStatus = "";
		try {
			schemeId = (Integer) generalMap.get("id");
			schemeCode = (String) generalMap.get("schemeCode");
			schemeName = (String) generalMap.get("name");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if(generalMap.get("letterFlag") != null){
				letterFlag = (String)generalMap.get("letterFlag");
			}
			if(generalMap.get("schemeType") != null){
				schemeType = (String)generalMap.get("schemeType");
			}
			if(generalMap.get("pkgFlag") != null){
				pkgFlag = (String)generalMap.get("pkgFlag");
			}
			
			
			// Added by Amit Das on 26-02-2016
			if(generalMap.get("patientStatus") != null){
				patientStatus = (String)generalMap.get("patientStatus");
			}
			if(generalMap.get("fromAge") != null){
				fromAge = (Integer)generalMap.get("fromAge");
			}
			if(generalMap.get("toAge") != null){
				toAge = (Integer)generalMap.get("toAge");
			}
			if(generalMap.get("genderId") != null){
				genderId = (Integer)generalMap.get("genderId");
			}
			if(generalMap.get("toAgeUnit") != null){
				toAgeUnit = (String)generalMap.get("toAgeUnit");
			}
			if(generalMap.get("fromAgeUnit") != null){
				fromAgeUnit = (String)generalMap.get("fromAgeUnit");
			}
			if(generalMap.get("limit") != null){
				limit = (Long)generalMap.get("limit");
			}
			if(generalMap.get("priority") != null){
				priority = (Integer)generalMap.get("priority");
			}
			
			
			// Ended by Amit Das on 26-02-2016
			
			
			int userId=0; 
			userId = (Integer) generalMap.get("userId");
			
			MasScheme masScheme = (MasScheme) getHibernateTemplate().load(
					MasScheme.class, schemeId);

			masScheme.setId(schemeId);
			masScheme.setSchemeName(schemeName);
			if(letterFlag.equalsIgnoreCase("y")){
				masScheme.setLetterFlag(letterFlag);
			}else{
				masScheme.setLetterFlag("n");
			}
			
		
			masScheme.setStatus("Y");
			Users users=new Users();
			users.setId(userId);
			masScheme.setLastChgBy(users);
			masScheme.setSchemeType(schemeType);
						
			masScheme.setLastChgDate(currentDate);
			masScheme.setLastChgTime(currentTime);
			
			/*Added by Amit Das on 26-02-2016*/
			if(pkgFlag.equalsIgnoreCase("y")){
				masScheme.setPackageFlag(pkgFlag);
			}else{
				masScheme.setPackageFlag("n");
			}
			
			if(fromAge!=null)
				masScheme.setFromAge(new BigDecimal(fromAge));
			if(toAge!=null)
				masScheme.setToAge(new BigDecimal(toAge));
			if(fromAgeUnit!=null)
				masScheme.setFromAgeUnit(fromAgeUnit);
			if(toAgeUnit!=null)
				masScheme.setToAgeUnit(toAgeUnit);
			if(genderId!=0){
				MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
				masAdministrativeSex.setId(genderId);
				masScheme.setSex(masAdministrativeSex);
			}
			if(priority!=0)
				masScheme.setPriority(priority);
			
			masScheme.setAmountLimit(limit);
			masScheme.setPatientStatus(patientStatus);	
			/*Ended by Amit Das on 26-02-2016*/
			

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masScheme);
			
			Session session = null;
			session = (Session) getSession();
			
			List<FaSchemeAccountMapping> fsamList = new ArrayList<FaSchemeAccountMapping>();
			
			fsamList = session.createCriteria(FaSchemeAccountMapping.class)
					.createAlias("Scheme","e")
					.add(Restrictions.eq("e.Id", schemeId))					
					.list();
			System.out.println(fsamList.size() +"fsamList");
			
				if(fsamList.size()>0){
					hbt.deleteAll(fsamList);
				}
			
			if (generalMap.get("accountList") != null) {

				String[] acc = (String[]) generalMap.get("accountList");
				if (acc != null && acc.length > 0) {
					for (String a : acc) {
						FaSchemeAccountMapping fsam = new FaSchemeAccountMapping();
						
						FaMasAccount account = new FaMasAccount();
						if (null != a && !a.equals("0"))
							account.setId(Integer.parseInt(a));
						
						fsam.setAccount(account);
						fsam.setScheme(masScheme);
						
						hbt.save(fsam);
						hbt.refresh(fsam);
						hbt.refresh(masScheme);
					}

				}

			}
			
			
			
			
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchScheme(String schemeCode,
			String schemeName) {
		Session session = null;
		session = (Session) getSession();

		List masSchemeList = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((schemeName != null) || (schemeCode == null)) {

				
				masSchemeList =session.createCriteria(MasScheme.class).add(Restrictions.like("SchemeName","%"+schemeName+"%").ignoreCase()).addOrder(Order.asc("SchemeName")).list();
			} else if (schemeCode != null) {
				
				
				masSchemeList =session.createCriteria(MasScheme.class).add(Restrictions.like("SchemeCode","%"+schemeCode+"%").ignoreCase()).addOrder(Order.asc("SchemeCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		faMasAccountList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.FaMasAccount as sc order by sc.AccDesc");
		
		map.put("masSchemeList", masSchemeList);
		
		map.put("faMasAccountList", faMasAccountList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showScheme() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = null;
		MasScheme masScheme = null;
		Criteria  criteria = null;
		Session session = null;
		
		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasScheme as sc order by sc.SchemeName");
		
		
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		faMasAccountList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.FaMasAccount as sc order by sc.AccDesc");
		
		// Added by Amit Das on 26-02-2016
		List<MasAdministrativeSex> masAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
		masAdministrativeSexList = getHibernateTemplate().find("from jkt.hms.masters.business.MasAdministrativeSex as msx order by msx.id");
		
		// Added by Amit Das on 26-05-2016
		List<MasScheme> masSchemePriorityList = new ArrayList<MasScheme>();
		session = getSession();
		criteria = session.createCriteria(MasScheme.class);
		list = criteria.setProjection(Projections.property("Priority")).list();
		
		for(Object object : list){
			masScheme = new MasScheme();
			masScheme.setPriority((Integer)object);
			masSchemePriorityList.add(masScheme);
		}
		
	
		map.put("masSchemeList", masSchemeList);
		map.put("masSchemePriorityList", masSchemePriorityList);
		map.put("faMasAccountList", faMasAccountList);
		map.put("masAdministrativeSexList", masAdministrativeSexList); // Added by Amit Das on 26-02-2016
		
		return map;
	}
	
		@Override
		public Map<String, Object>  showLocalCharge(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasChargeCodeRates> masChargeCodeRates = new ArrayList<MasChargeCodeRates>();
		List<MasChargeCode> chargecodes=new ArrayList<MasChargeCode>();
		List<MasChargeCode> chargecodesAll=new ArrayList<MasChargeCode>();
		int hospitalId=(Integer)generalMap.get(HOSPITAL_ID);
		masChargeCodeRates=session.createCriteria(MasChargeCodeRates.class)
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId)).list();
		
		chargecodes=session.createCriteria(MasHospitalwiseChargecode.class)
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.projectionList().add(Projections.property("ChargeCode")))
				.list();
		chargecodesAll=session.createCriteria(MasHospitalwiseChargecode.class)
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.setProjection(Projections.projectionList().add(Projections.property("ChargeCode")))
				.list();
		
		map.put("masChargeCodeRates", masChargeCodeRates);
		map.put("chargecodes", chargecodes);
		map.put("chargecodesAll", chargecodesAll);
			return map;
		}
		
		@Override
		public Map<String, Object>  checkDuplicateLocalCharge(int chargeId,int hospitalId) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasChargeCodeRates> masChargeCodeRates=new ArrayList<MasChargeCodeRates>();
			Session session = (Session) getSession();
			masChargeCodeRates=session.createCriteria(MasChargeCodeRates.class)
					.createAlias("ChargeCode", "chargeCode")
					.createAlias("Hospital", "hospital")
					.add(Restrictions.eq("chargeCode.Id", chargeId))
					.add(Restrictions.eq("hospital.Id", hospitalId)).list();
			map.put("masChargeCodeRates", masChargeCodeRates);
			return map;
		}
		
		@Override
			public boolean LocalCharge(MasChargeCodeRates chargeCodeRates) {
			boolean saveFlag = false;
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(chargeCodeRates);
				hbt.flush();
				saveFlag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return saveFlag;
			}
		
		@Override
			public boolean editLocalCharge(Map<String, Object> generalMap) {
			boolean dataUpdated = false;

			
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			int localChargeId = 0;
			BigDecimal charge=new BigDecimal(0.00);

			try {
				localChargeId = (Integer) generalMap.get("id");
				charge = (BigDecimal) generalMap.get("charge");
				currentDate = (Date) generalMap.get("currentDate");
				currentTime = (String) generalMap.get("currentTime");
				int userId=0; 
				userId = (Integer) generalMap.get("userId");
				
				MasChargeCodeRates masChargeCodeRate = (MasChargeCodeRates) getHibernateTemplate().get(
						MasChargeCodeRates.class, localChargeId);

				masChargeCodeRate.setRate(charge);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masChargeCodeRate);
				hbt.flush();
				dataUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dataUpdated;
			}
		
		@Override
			public Map<String, Object> searchLocalCharge(String chargeCode,
					String chargeName, int hospitalId) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			List<MasChargeCodeRates> masChargeCodeRates = new ArrayList<MasChargeCodeRates>();
			List<MasChargeCode> chargecodes=new ArrayList<MasChargeCode>();
			List<MasChargeCode> chargecodesAll=new ArrayList<MasChargeCode>();			
			if ((chargeName != null) || (chargeCode == null)) {				
				masChargeCodeRates =session.createCriteria(MasChargeCodeRates.class)
						.createAlias("Hospital", "hospital")
						.createAlias("ChargeCode", "chargeCode")
						.add(Restrictions.like("chargeCode.ChargeCodeName","%"+chargeName.toLowerCase()+"%").ignoreCase()).list();
			} else if (chargeCode != null) {				
				masChargeCodeRates =session.createCriteria(MasChargeCodeRates.class)
						.createAlias("Hospital", "hospital")
						.createAlias("ChargeCode", "chargeCode")
						.add(Restrictions.like("chargeCode.ChargeCodeCode","%"+chargeCode.toLowerCase()+"%").ignoreCase()).list();
			}
			chargecodes=session.createCriteria(MasHospitalwiseChargecode.class)
					.createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("ChargeCode")))
					.list();
			chargecodesAll=session.createCriteria(MasHospitalwiseChargecode.class)
					.createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.setProjection(Projections.projectionList().add(Projections.property("ChargeCode")))
					.list();
			
			map.put("masChargeCodeRates", masChargeCodeRates);
			map.put("chargecodes", chargecodes);
			map.put("chargecodesAll", chargecodesAll);
				return map;
			}
		public void pacsMethodForPacsServer(int hospitalId,int orderId,String patientId) throws FileNotFoundException, IOException
			{
				
			 System.out.println("res_mainChargeCode patientId patientId "+patientId);
			Session session=getSession();
				//System.out.println("in main");

				//String path=" cmd /c start    C:\\Users\\javed.khan\\Desktop\\PACSBat\\pac.bat";
				//Runtime rn=Runtime.getRuntime();
				//Process pr1=rn.exec(path);

				//System.out.println("----");
				//Runtime.getRuntime().exec("cmd.exe", "/c", "./com/projct/util/server.bat");
				//"cmd /c start D:\\temp\\a.bat"
				
				
				java.sql.Connection con = null;
				// String url = "jdbc:sqlserver://192.168.203.136:1433;database=VBCHLIVE";
				/*String url = "jdbc:sqlserver://192.168.203.196:1433;database=SILVASSHMS";
				String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    
			    String userName = "sa";
			    String password = "Hms@2013";*/
				URL	resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("jktPacs1.properties");
			
					Properties pacProper = new Properties();
					pacProper.load(new FileInputStream(new File(resourcePath.getFile())));
					 
				
				//Properties pacProper = new Properties();
				//InputStream input = new FileInputStream("D:\\PACSBat\\jktPacs.properties");
				//pacProper.load(input);
				System.out.println("Database_URl>>"+pacProper.getProperty("Database_URl"));
				System.out.println("PACS_URL>>>"+pacProper.getProperty("PACS_URL"));
				System.out.println("PACS_PORT>>"+pacProper.getProperty("PACS_PORT"));
				System.out.println("driverName>>>"+pacProper.getProperty("driverName"));
				System.out.println("user>:>"+pacProper.getProperty("user"));
				System.out.println("user>:>"+pacProper.getProperty("password"));
				//System.exit(0);
				//String url="jdbc:mysql://192.168.203.196:3306/4b";
				String url = pacProper.getProperty("Database_URl");
				//String driverName = "com.mysql.jdbc.Driver";
				String driverName =pacProper.getProperty("driverName");
				// String userName = "root";
				String userName = pacProper.getProperty("user");
				//  String password = "root";
				String password = pacProper.getProperty("password");
			    // int port = 5555;
				
			
				LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(); // The transport protocol
				PipeParser parser = new PipeParser(); // The message parser
				//SimpleServer server = new SimpleServer(port, llp, parser);
				//SimpleServer server = new SimpleServer(llp, parser);

					
				/*
				* The server may have any number of "application" objects registered to handle messages. We
				* are going to create an application to listen to ADT^A01 messages.
				*/
					 
				Application handler = new ExampleReceiverApplication();
				//server.registerApplication("ADT", "A01", handler);
					   
				/*
				* We are going to register the same application to handle ADT^A02 messages. Of course, we
				* could just as easily have specified a different handler.
				*/
				
				//server.registerApplication("ADT", "A02", handler);
				//server.registerApplication("ORM", "O01", handler);
					 
				/*
				* Another option would be to specify a single application to handle all messages, like
				* this:
				* 
				* server.registerApplication("*", "*", handler);
				*/
					   
				// Start the server listening for messages
				//server.start();
				//System.out.println("server main "+server);
					   
				/*
				* Now, create a connection to that server, and send a message
				*/
				if(url!=null) {
				try
				{
					int port = Integer.parseInt(pacProper.getProperty("PACS_PORT"));
					
					 Class.forName(driverName).newInstance();
				     con = DriverManager.getConnection(url, userName, password);
				     Connection connection = null;
				     try
				     {
				          Statement st = con.createStatement();
				          Statement st2 = con.createStatement(
		                          ResultSet.TYPE_SCROLL_INSENSITIVE,
		                          ResultSet.CONCUR_READ_ONLY);
				          Statement st3 = con.createStatement();
				          Statement st4 = con.createStatement();

				          String query = "SELECT  * FROM dg_orderhd dg left outer join dg_orderdt dt on dt.orderhd_id = dg.orderhd_id "+
				          " left outer join  patient p on  p.hin_id = dg.hin_id  "+
				          " left outer join mas_administrative_sex sexid on sexid.administrative_sex_id  = p.sex_id "+
				          " left outer join  mas_employee emp on dg.prescribed_by = emp.employee_id "+ 
				          " left outer join inpatient inp on dg.inpatient_id = inp.inpatient_id "+
				          " left outer join mas_charge_code mcc on dt.charge_code_id = mcc.charge_code_id "+ 
				          " left outer join mas_sub_chargecode mscc on dt.sub_chargeid = mscc.sub_chargecode_id "+
				          " WHERE dt.msg_sent = 'n'  and dg.hospital_id='"+hospitalId+"' and  dg.order_date='"+new Date()+"' and  dg.orderhd_id='"+orderId+"'";
				          
				          
				          ResultSet res = st.executeQuery(query);
					      Date DOB = null;
					      Date DOA = null;
					      String TOA = null;
					      String adtym = "";
					      String doa_val = null;
					    //  String query = "SELECT  * FROM patient where hin_id     
					      while (res.next())
					      {
					    	  int mainChargeCodeId = res.getInt("main_chargecode_id");
					    	  System.out.println("mainChargeCodeId main>>> "+mainChargeCodeId);
					    	  
					    	  String mainQuery = "select main_chargecode_name from mas_main_chargecode where main_chargecode_id = "+mainChargeCodeId;
					    	  System.out.println("mainQuery main "+mainQuery);
					    	  ResultSet res_mainChargeCode = st2.executeQuery(mainQuery);
					    	  String a1 = "";
					    	
					    	  a1 = res.getString("orderhd_id");
					    	  String mainQuery1 = "select d.orderdt_id from dg_orderdt d where d.orderhd_id = '"+a1+"'";

					    	  System.out.println("javed>>"+mainQuery1);
					    	  ResultSet res_orderdt_id = st3.executeQuery(mainQuery1);
					    	  String a = "";
					    	  while(res_orderdt_id.next())
					    	  {
						    	//System.out.println(res_orderdt_id.getInt(1));
						    	a=""+(res_orderdt_id.getInt(1));
					    	  }
					    	  System.out.println("res_mainChargeCode");
					    	  while(res_mainChargeCode.next())
					    	  {
					    	  System.out.println("orderdt_id>>"+a);
					    	  
					    		  String mainCName = res_mainChargeCode.getString("main_chargecode_name");
					    		  System.out.println("mainCName main "+mainCName);
					    		  if(mainCName.equalsIgnoreCase("XRAY") || mainCName.equalsIgnoreCase("ULTRASOUND") || mainCName.equalsIgnoreCase("SONOGRAPHY")
					    			 || mainCName.equalsIgnoreCase("CT SCAN") || mainCName.equalsIgnoreCase("MRI"))
					    		 //if(mainCName.equalsIgnoreCase("Radiology Services"))
					    		  {
					    			  //Start creating message
								  	  ADT_A01 adt1 = new ADT_A01();
								  	  ORU_R01 message1 = new ORU_R01();
								  		
								  	  message1.getMSH().getEncodingCharacters().setValue("^~\\&");
								  	  message1.getMSH().getFieldSeparator().setValue("|");
								  	  ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
								  	  
								  	  // Populate the MSH Segment
								  	  MSH mshSegment = adt1.getMSH();
								  	  mshSegment.getMsh1_FieldSeparator().setValue("|");
								  	  mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
								  	  //mshSegment.getMsh3_SendingApplication().setValue("HIS");...........
								  	  mshSegment.getMsh3_SendingApplication().setValue("HMS");
								  	  //mshSegment.getMsh4_SendingFacility().setValue("RIH");
								  	  mshSegment.getMsh5_ReceivingApplication().setValue("INSTAPACS");
								  	  //mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
								  	  //mshSegment.getMsh6_ReceivingFacility().setValue("EKG"); 
								  	  mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
								  	  mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
								  	  mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
								  	  //mshSegment.getMsh10_MessageControlID().setValue("1001");
								  	  mshSegment.getMsh10_MessageControlID().setValue(""+a);
								  	  mshSegment.getMsh11_ProcessingID().setValue("P");
								  	  mshSegment.getMsh12_VersionID().setValue("2.3");
								  	  DOB = res.getDate("date_of_birth");
								  	  String pAge= res.getString("age");
								  	  String abc="";
								  	  if(DOB!=null){
								  		  abc= HMSUtil.convertDatetoString(DOB);
								  	  }else if(pAge!=null){
								  		  abc=HMSUtil.calculateAgeForADT(pAge, new Date()); 
								  	  }else{
								  		 abc = HMSUtil.convertDatetoString(new Date());
								  	  }
								  	  // Populate the PID Segment
								  	  PID pid = adt1.getPID();
								  	 // pid.getPid3_PatientIDInternalID(0).getCm_pat_id1_IDNumber().setValue(res.getString("hin_id"));
								  	  pid.getPid3_PatientIDInternalID(0).getCm_pat_id1_IDNumber().setValue((patientId));

								  	  pid.getPid4_AlternatePatientID().setValue(res.getString("hin_id"));
								  	  pid.getPid5_PatientName().getFamilyName().setValue(res.getString("p_last_name"));
								  	  pid.getPid5_PatientName().getGivenName().setValue(res.getString("p_first_name"));
								  	  if(abc!=null && !"".equals(abc)){
								  		 pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
								  	  } else{
								  		 pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(HMSUtil.convertDatetoString(new Date()));
								  	  }
								  	  pid.getPid8_Sex().setValue(res.getString("administrative_sex_code"));
									        
								  	  PV1 pv1 = adt1.getPV1();
								  	  pv1.getPv12_PatientClass().setValue(res.getString("patient_type"));
								  	  pv1.getPv18_ReferringDoctor().getIDNumber().setValue(res.getString("pe_no"));
								  	  //pv1.getPv18_ReferringDoctor().getGivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));
								  	     
								  	  String visitId = HMSUtil.convertSimple(res.getInt("visit_id"));
								  	  pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().setValue(visitId);
								  	  if(res.getString("patient_type").equalsIgnoreCase("IP")){
								  	  if(res.getDate("date_of_addmission") != null || res.getString("time_of_addmission") != null)
								  	  {
								  		  DOA = res.getDate("date_of_addmission");
								  		  TOA = res.getString("time_of_addmission");
									  	      
									  	  TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
									  	 // TOA =  TOA.substring(0, 4).concat(TOA.substring(5));
										  	     
										  doa_val = HMSUtil.convertDatetoString(DOA);

										  adtym = adtym.concat(doa_val).concat(TOA);
										  pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
								  	  }
								  	  }else{ // for OP 
								  		  
								  		DOA = res.getDate("order_date");
								  		  TOA = res.getString("order_time");
									  	      
									  	  TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
									  	 // TOA =  TOA.substring(0, 4).concat(TOA.substring(5));
										  	     
										  doa_val = HMSUtil.convertDatetoString(DOA);

										  adtym = adtym.concat(doa_val).concat(TOA);
										  pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
								  		  
								  		  
								  	  }
								  	
								  	  // Populate the ORC
								  	  ORC orc = orderObservation.getORC();
								  	  orc.getOrc1_OrderControl().setValue("NW");            // New order
								  	  // orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
								  	  orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(""+a);
								  	 // orc.getOrc3_FillerOrderNumber().getCm_filler1_UniqueFillerId().setValue(res.getInt("bill_id")+"");
								  	  orc.getOrc3_FillerOrderNumber().getCm_filler1_UniqueFillerId().setValue(""+a);
								  	  orc.getOrc5_OrderStatus().setValue("SC");             // ( = In Progress Scheduled)
								  	  orc.getDateTimeOfTransaction().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
										      
								  	  orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue(res.getString("hin_no")); //Order Entry Person (ID)
								  	  orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue(res.getString("full_name")); //Order Entry Person (Name)
								  	  //orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue(""+res.getInt("employee_id")); //Order Entry Person (ID)
								  	  //orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue("Abhi Gupta"); //Order Entry Person (Name)
									
								  	  //added by govind for removing speacial character,space
								  	  String chargeCodeName=res.getString("charge_code_name");
								  	chargeCodeName=chargeCodeName.replace("(", "");
								  	chargeCodeName=chargeCodeName.replace(")", "");
								  	chargeCodeName=chargeCodeName.replace(" ", "");
								  	chargeCodeName=chargeCodeName.replace("-", "");
								  	  //added by govind
								  	  
									  // Populate the OBR
								  	  OBR obr = orderObservation.getOBR();
								  	  //obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
								  	  obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(""+a);
								  	  obr.getObr3_FillerOrderNumber().getCm_filler1_UniqueFillerId().setValue(res.getInt("bill_id")+""); 
								  	  //obr.getObr4_UniversalServiceID().getCe1_Identifier().setValue(res.getString("charge_code_code"));
								  	  obr.getObr4_UniversalServiceID().getCe1_Identifier().setValue(""+res.getInt("charge_code_id"));
								  	  //obr.getObr4_UniversalServiceID().getCe2_Text().setValue(res.getString("charge_code_name"));
								  	  //obr.getObr4_UniversalServiceID().getCe2_Text().setValue(res.getString("charge_code_name"));
								      obr.getObr4_UniversalServiceID().getCe2_Text().setValue(chargeCodeName);
								  	  obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
								  	  obr.getObr13_RelevantClinicalInformation().setValue(res.getString("clinical_note"));
								  	
								  	  obr.getObr16_OrderingProvider().getCn1_IDNumber().setValue(res.getString("pe_no"));
								  	  //obr.getObr16_OrderingProvider().getCn3_GivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));
								  	  //  obr.getObr24_DiagnosticServiceSectionID().setValue(res.getString("charge_code_code"));
								  	  obr.getObr24_DiagnosticServiceSectionID().setValue(""+res.getInt("charge_code_id"));
										      
								  	  obr.getObr36_ScheduledDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
								  	  //Order Scheduling Details (will not be present if HIS does not have scheduling engine
								  
								  	  // Now, let's encode the message and look at the output
								  	  Parser p1 = new PipeParser(); 
								  	  String encodedMessage = p1.encode(adt1); 
								  	  encodedMessage = encodedMessage.substring(0, encodedMessage.length() - 1);
								      String encMsg = p1.encode(message1);
								      String newString = encMsg.substring(8);
								  	  System.out.println("<-- Final newString-->\n"+newString);
								  	/*System.out.println("rajat "+message1);
								  	  System.out.println("Start String"); 
									  System.out.println(encMsg+"<---rajat---->"+newString);
									  System.out.println("End String"); */
								  	 
								  	  Parser p = new GenericParser();
								  	  
									  	newString=encodedMessage+newString;
								 StringBuffer strBuf=new StringBuffer(newString);
								 String finalStr=strBuf.toString();
								 finalStr=finalStr.replace("\n", "");
                                  System.out.println("<-- Final Request msg-->\n"+finalStr);
								  	//Message adt = p.parse(newString);

								  	  //Message adt = p.parse(encodedMessage+newString);
								  	//Message adt = p.parse(finalStr);
									  // The connection hub connects to listening servers
									//  ConnectionHub connectionHub = ConnectionHub.getInstance();
									 // System.out.println("javed khan 2");
									  
									  // A connection object represents a socket attached to an HL7 server
									 // String pacsServer="192.168.203.195";
									  String pacsServer= pacProper.getProperty("PACS_URL");
									  
									  //connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
									 // connection = connectionHub.attach(pacsServer, port, new PipeParser(), MinLowerLayerProtocol.class);
									 // connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
									 
									  // The initiator is used to transmit unsolicited messages
									 //Initiator initiator = connection.getInitiator();
									  //System.setProperty("ca.uhn.hl7v2.app.initiator.timeout",Integer.toString(9000000));
									  //System.setProperty("ca.uhn.hl7v2.app.initiator.timeout",Integer.toString(60000000));
									 // System.out.println(initiator+"-**-"+connection+"   "+adt.getName());
									 // Message response = initiator.sendAndReceive(adt);
									  
										//added by govind 11-12-2017
									    String responseString="";
									    Socket smtpSocket = null;  
								        DataOutputStream os = null;
								        DataInputStream is = null;
								       // BufferedReader r=null;
								        String charset = "ISO-8859-1";
								       // InputStream inStream=null;
								        byte[] readBuffer=new byte[1024];
								// Initialization section:
								// Try to open a socket on port 25
								// Try to open input and output streams
								        try {
								            smtpSocket = new Socket(pacsServer, port);
								            os = new DataOutputStream(smtpSocket.getOutputStream());
								            is = new DataInputStream(smtpSocket.getInputStream());
								        } catch (UnknownHostException e) {
								            System.err.println("Don't know about host: hostname");
								        } catch (IOException e) {
								            System.err.println("Couldn't get I/O for the connection to: hostname");
								        }
								        try{
								        	if (smtpSocket != null && os != null) {
									           os.writeBytes(finalStr);
									         }
								        	StringBuffer desc = new StringBuffer();
								        	char ch;
                                            int co=0;
								            while ((ch = (char) is.read()) != -1){
								            	co++;
								            	System.out.println("Response Msge inside while\n" + ch);
								            	if(co==1){
								            		
								            	}else{
								            	desc.append(ch);
								            	}
								            	System.out.println("Append StringBuffer " + desc.toString());
								            	System.out.println("Count-->"+co);
								            	if(co==78){
								            		break;
								            	}
								            }
								            os.close();
								            is.close();
								            System.out.println("Response Msge out while\n" + desc.toString());   
								            responseString=desc.toString();
								        }catch (UnknownHostException e) {
							                System.err.println("Trying to connect to unknown host: " + e);
							            } catch (IOException e) {
							                System.err.println("IOException:  " + e);
							            }finally{
							            	 os.close();
								             is.close();
							            	// inStream.close();
								             smtpSocket.close();   
							            }
									  System.out.println("Received response:\n" + responseString);
									 //added by govind 11-12-2017 end  	 
									  Parser response_parser = new GenericParser();
								      Message hapiMsg;
								      try
								      {
								    	  // The parse method performs the actual parsing
								       	  hapiMsg = response_parser.parse(responseString);
								        	
								       	  if (hapiMsg instanceof ACK)
								          {
								       		  ACK ack = (ACK) hapiMsg;
								                
								              /*System.out.println("inside ach msh"+ack.getMSH().getMsh3_SendingApplication());
								              System.out.println("inside ach msh"+ack.getMSH().getMsh5_ReceivingApplication());
								              System.out.println("inside ach msh"+ack.getMSH().getMsh4_SendingFacility());
								              System.out.println("inside ach msh"+ack.getMSH().getMsh6_ReceivingFacility());
								              */
								       		  
								       		  System.out.println("Recieve acknowledge");
								                
								                  
								              if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AA") 
								                   && ack.getMSA().getMsa3_TextMessage().getValue() == null 
								                   && ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null)
								              {  System.out.println("update ");
								              //added by govind 14-12-2017
								                 System.out.println("orderhd_id-->"+res.getInt("orderhd_id"));
								                 System.out.println("orderdt_id-->"+res.getInt("orderdt_id"));
								                	String sql = "UPDATE dg_orderdt SET  msg_sent='y' WHERE  orderhd_id = "+res.getInt("orderhd_id")+" and orderdt_id = "+res.getInt("orderdt_id");
								                	//int updateCount = st4.executeUpdate(sql); 
								               Query upQuery=session.createSQLQuery(sql);
								                upQuery.executeUpdate();
								                	// updateCount contains the number of updated rows 
								              //added by govind 14-12-2017 end
								                	//System.exit(0);
								            
								              }	
								              
								          }else{
								        	  System.out.println("exit");
								          }
								      }
								      catch (EncodingNotSupportedException e)
								      {
								    	  e.printStackTrace();
								    	  return;
								      }
								      catch (HL7Exception e)
								      {
								    	  e.printStackTrace();
								    	  return;
								      }
								      
								      adtym = "";
					    		  }
					    		  else
					    		  {
					    			  System.out.println("Different Charge Code......");
					    		  }
					    	  }
					    	  System.out.println("Inside of while rs.next ");
					      }
					      System.out.println("Out of while rs.next");
				     }
					 catch(SQLException s)
					 {
						 s.printStackTrace();
					     System.out.println("SQL query does not execute."+s);
					 }
					 finally
					 {
						 con.close();
						 //Close the connection and server
					     //connection.close();
					    // server.stop();
					 }
				}
			
				catch (Exception e)
				{
				    e.printStackTrace();
				}
				}
		}

		@Override
		public Map<String, Object> showPriorityJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<BlPriority> blPriorities = new ArrayList<BlPriority>();
			blPriorities = getHibernateTemplate().find(
					"from jkt.hms.masters.business.BlPriority");
			map.put("blPriorities", blPriorities);
			return map;
		}

		@Override
		public boolean addPriorityType(BlPriority blPriority) {
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(blPriority);
			successfullyAdded = true;
			return successfullyAdded;
		}

		@Override
		public Map<String, Object> searchPriorityType(String priorityCode,
				String priorityName) {
			List<BlPriority> blPriorities = new ArrayList<BlPriority>();
			Map<String, Object> priorityMap = new HashMap<String, Object>();
			
			System.out.println(priorityName+"===="+priorityCode);
			try {
				if ((priorityCode != null) && (priorityName == null)) {
					blPriorities = getHibernateTemplate()
							.find("from jkt.hms.masters.business.BlPriority stt where stt.PriorityCode like '"
									+ priorityCode
									+ "%' order by stt.PriorityCode");
				} else {
					blPriorities = getHibernateTemplate()
							.find("from jkt.hms.masters.business.BlPriority stt where stt.PriorityNam like '"
									+ priorityName
									+ "%' order by stt.PriorityNam");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			priorityMap.put("blPriorities",
					blPriorities);
			System.out.println("===="+blPriorities.size());
			return priorityMap;
		}

		@Override
		public boolean deletePriorityType(int priorityId,
				Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			
			BlPriority blPriority=new BlPriority();
			blPriority = (BlPriority) getHibernateTemplate().load(
					BlPriority.class, priorityId);
			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					blPriority.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					blPriority.setStatus("y");
					dataDeleted = false;
				}
			}
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(blPriority);
			return dataDeleted;
		}

		@Override
		public boolean editPriorityType(Map<String, Object> generalMap) {
			// TODO Auto-generated method stub
			boolean dataUpdated = false;
			@SuppressWarnings("unused")
			String salesTaxTypeCode = "";
			int salesTaxTypeId = 0;
			String changedBy = "";

			int priorityId = (Integer) generalMap.get("id");
			String priorityCode = (String) generalMap.get("code");
			String priorityName = (String) generalMap.get("name");
			String priority = (String) generalMap.get("priority");
			String bed = (String) generalMap.get("bed");
			System.out.println("code"+priorityCode);
			BlPriority blPriority = (BlPriority) getHibernateTemplate()
					.load(BlPriority.class, priorityId);

			blPriority.setId(priorityId);
			blPriority.setBed(bed);
			blPriority.setPriorityCode(priorityCode);
			blPriority.setPriorityNam(priorityName);
            blPriority.setPriority(priority);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(blPriority);
			dataUpdated = true;
			return dataUpdated;
		}
		
		// Added by Amit Das on 29-02-2016
		@Override
		public List<MasScheme> listSchemeForDiscount(Box box)
		{
			List<MasScheme> schemeList=new ArrayList<MasScheme>();
			if(box!=null){
				String patientType = "";
				patientType = box.getString("patientType");
				Session session = (Session) getSession();
				Criteria criteria = session.createCriteria(MasScheme.class);
				if(patientType!=null && !patientType.trim().equals("") && !patientType.equals("0"))
					criteria.add(Restrictions.or(Restrictions.eq("PatientStatus", patientType), Restrictions.eq("PatientStatus", "")));
					
				schemeList = criteria.list();
			}
			
			
			return schemeList;
		}
		public void pacsMethodForPacsServerReceiver() throws FileNotFoundException, IOException
		{
			System.out.println("********************Receiver function started  ******************************");
			
			URL	resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jktPacs1.properties");
		
				Properties pacProper = new Properties();
				pacProper.load(new FileInputStream(new File(resourcePath.getFile())));
				 
			String url = pacProper.getProperty("Database_URl");
			String driverName =pacProper.getProperty("driverName");
			String userName = pacProper.getProperty("user");
			String password = pacProper.getProperty("password");
			int port = Integer.parseInt(pacProper.getProperty("PACS_PORT"));
			LowerLayerProtocol llp;
			llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.SERVER);

			//LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(); // The transport protocol
			/*PipeParser parser = new PipeParser(); // The message parser
			SimpleServer server = new SimpleServer(port, llp, parser);
			*/
			PipeParser parser = PipeParser.getInstanceWithNoValidation();
			//int port = 8080;
			SimpleServer server = new SimpleServer(port, llp, parser);

				 
			/*Application handler = new ExampleReceiverApplication();
			server.registerApplication("ADT", "A01", handler);
				   
			
			server.registerApplication("ADT", "A02", handler);
			server.registerApplication("ORM", "O01", handler);*/
			server.registerApplication("*", "*", (ReceivingApplication)new DefaultApplication());
			server.start();

			
			System.out.println("receving message from pacs server  "+server.toString());
				   	
		
	}

		

		
}
