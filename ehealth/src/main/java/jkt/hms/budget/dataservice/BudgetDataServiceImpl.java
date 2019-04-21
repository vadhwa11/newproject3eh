package jkt.hms.budget.dataservice;

import jkt.hms.account.dataservice.AccountDataServiceImpl;
import jkt.hms.budget.dataservice.BudgetDataService;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import static jkt.hms.util.RequestConstants.*;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;

import static jkt.hms.util.RequestConstants.SELECTED_RADIO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.BitSet; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.BlChargeSlipDetail;
import jkt.hms.masters.business.BlChargeSlipMain;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlPaymentAdviceHeader;
import jkt.hms.masters.business.BlPymntAdviceDispHeader;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.BlRefundHeader;
import jkt.hms.masters.business.BudEstimateEntry;
import jkt.hms.masters.business.BudMajorHead;
import jkt.hms.masters.business.BudMinorSubHead;
import jkt.hms.masters.business.BudObjectHead;
import jkt.hms.masters.business.BudSubMajorHead;
//import jkt.hms.masters.business.FaAccountsParameter;
//import jkt.hms.masters.business.FaBankReconciliationDetails;
//import jkt.hms.masters.business.FaBankReconciliationHeader;
//import jkt.hms.masters.business.FaBranchAccountMaster;
import jkt.hms.masters.business.FaMasAccount;
//import jkt.hms.masters.business.FaMasAccountGroup;
//import jkt.hms.masters.business.FaMasAccountSubGroup;
//import jkt.hms.masters.business.FaMasNarration;
//import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.FaVoucherDetails;
import jkt.hms.masters.business.FaVoucherHeader;
import jkt.hms.masters.business.HesCylinderTypeMaster;
import jkt.hms.masters.business.HesCylinderUsageMaster;
import jkt.hms.masters.business.HmsNoticeBoard;
import jkt.hms.masters.business.MainCharge;
import jkt.hms.masters.business.MasBankMaster;
//import jkt.hms.masters.business.MasBranch;
import jkt.hms.masters.business.BlParameter;
import jkt.hms.masters.business.BlReceiptDetails;
import jkt.hms.masters.business.BudMinorHead;
import jkt.hms.masters.business.BudReAppropEntry;
import jkt.hms.masters.business.BudVoucherDetail;
import jkt.hms.masters.business.BudVoucherHeader;
import jkt.hms.masters.business.BudVoucherReceiptEntry;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasButtonForm;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDietMenuItem;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasPhysiotherapyDetail;
import jkt.hms.masters.business.MasPhysiotherapyHeader;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreIssueM;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrMasFinancialYear;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("unused")
public class BudgetDataServiceImpl extends HibernateDaoSupport implements
BudgetDataService {
	@SuppressWarnings("unchecked")
	public Map checkForExistingMasters(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();
		int id = 0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String pojoPropertyName = "";

		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}
		String name = (String) generalMap.get("name");
		String pojoName = (String) generalMap.get("pojoName");
		String description="";
		String pojoPropertyDescription="";

		if (generalMap.get("description") != null) {
			description = (String) generalMap.get("description");
		}
		if (generalMap.get("pojoPropertyDescription") != null) {
			pojoPropertyDescription = (String) generalMap.get("pojoPropertyDescription");
		}
		if (generalMap.get("pojoPropertyName") != null) {
			pojoPropertyName = (String) generalMap.get("pojoPropertyName");
		}
		if (generalMap.get("pojoPropertyCode") != null) {
			pojoPropertyCode = (String) generalMap.get("pojoPropertyCode");
		}
		if (generalMap.get("pojoPropertyAddress") != null) {
			pojoPropertyAddress = (String) generalMap
					.get("pojoPropertyAddress");
		}

		if (generalMap.get("flag") == null) {

			String code = (String) generalMap.get("code");
			String address = (String) generalMap.get("address");
			if (!pojoPropertyCode.equals("")) {
				duplicateGeneralCodeList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyCode + " ='"
								+ code + "'");
			}
			/*
			 * Code for PO DILIVERY TERM JSP
			 * Code By Mukesh Narayan SIngh
			 * Date 30 Aug 2010
			 */
			if(!description.equals("")){
				if (!pojoPropertyName.equals("") && !description.equals("")) {
					duplicateGeneralNameList = getHibernateTemplate().find(
							"from jkt.hrms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g." + pojoPropertyDescription + " = '"
							+ description + "'");
				}
			}else{
				if (!pojoPropertyName.equals("")) {
					duplicateGeneralNameList = getHibernateTemplate().find(
							"from jkt.hrms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "'");
				}
			}
			if (!pojoPropertyAddress.equals("")) {
				duplicateGeneralAddressList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyAddress
								+ " ='" + address + "'");
			}

		} else if (generalMap.get("flag") != null) {
			duplicateMastersList = getHibernateTemplate().find(
					"from jkt.hrms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.Id != " + id);
		}
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showFinancialyearMaster() {
        Map<String, Object> map = new HashMap<String, Object>();
        
        List<HrMasFinancialYear> searchfinancialyearList = new ArrayList<HrMasFinancialYear>();
        /*searchfinancialyearList = getHibernateTemplate().find(
        l  "from jkt.hms.masters.business.HrMasFinancialYear ");*/
                 Session session =(Session)getSession();
                 searchfinancialyearList = session.createCriteria(HrMasFinancialYear.class).list();
                 map.put("searchfinancialyearList", searchfinancialyearList);
                 return map;
	}

	@Override
	public boolean addfinancialyear(HrMasFinancialYear masFinancialYear) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(masFinancialYear);
		successfullyAdded = true;
		return successfullyAdded;
}

	@Override
	public boolean editfinancialyear(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String financialName = "";
		String financialCode = "";
		Date fromDate =null;
		Date todate =null;
		Date changedByDate=null;
		int financialId = 0;
		String changedBy = "";
		financialId = (Integer) generalMap.get("id");
		financialCode = (String) generalMap.get("code");
		financialName = (String) generalMap.get("name");
		fromDate=(Date)generalMap.get("fromDate");
	    todate=(Date) generalMap.get("toDate");
		changedBy = (String) generalMap.get("changedBy");
		changedByDate = (Date) generalMap.get("changedByDate");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//HrMasFinancialYear master = (HrMasFinancialYear)getHibernateTemplate().get(HrMasFinancialYear.class, financialId);
		HrMasFinancialYear master = (HrMasFinancialYear)hbt.load(HrMasFinancialYear.class, financialId);
		master.setId(financialId);
		master.setYearDescription(financialCode);
		master.setFinancialYear(financialName);
		master.setYearFromDate(fromDate);
		master.setYearToDate(todate);
		//commented for maven
		/*master.setLastChgBy(changedBy);*/
		master.setLastChgDate(changedByDate);
		master.setLastChgTime(currentTime);
		try
		{

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
	public boolean deletefinancialyear(int financilId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		String currentDate = "";
		String currentTime = "";

		changedBy = (String) generalMap.get("changedBy");
		//currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		HrMasFinancialYear master = (HrMasFinancialYear) getHibernateTemplate().get(HrMasFinancialYear.class, financilId);

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

		master.setId(financilId);
		
		//commented for maven
		/*master.setLastChgBy(changedBy);*/
		//master.setLastChgDate(currentDate);
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
	public Map<String, Object> searchfinancialyear(String financialCode,
			String financialName) {
		List<HrMasFinancialYear> searchfinancialyearList = new ArrayList<HrMasFinancialYear>();
		Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();
		try
		{
			if ((financialName != null) || (financialCode == null))
			{
				searchfinancialyearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.like("FinancialYear", financialName+"%")).list();

			}
			else
			{
				searchfinancialyearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.like("YearDescription", financialCode+"%")).list();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		countryFieldsMap.put("searchfinancialyearList", searchfinancialyearList);
		return countryFieldsMap;
		}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showBudgetMajorHead() {
		Map<String, Object> map = new HashMap<String, Object>();
        List<BudMajorHead> searchMajorHeadList = new ArrayList<BudMajorHead>();
        Session session =(Session)getSession();
        searchMajorHeadList = session.createCriteria(BudMajorHead.class).list();
      
        
        map.put("searchMajorHeadList", searchMajorHeadList);
        return map;
}
	@Override
	public boolean addMajorHead(BudMajorHead majorHead) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(majorHead);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@Override
	public boolean deleteMajorHead(int majorheadId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		BudMajorHead master = (BudMajorHead) getHibernateTemplate().get(BudMajorHead.class, majorheadId);

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

		master.setId(majorheadId);
		master.setLastChgeBy(changedBy);
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
	public boolean editmajorhead(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String majorheadName = "";
		String majorheadCode = "";
		int majorheadId = 0;
		int sequenceNo=0;
		String changedBy = "";
		currentDate = new Date();
		majorheadId = (Integer) generalMap.get("id");
		majorheadCode = (String) generalMap.get("code");
		majorheadName = (String) generalMap.get("name");
		sequenceNo =(Integer)generalMap.get("sequenceNo");
		changedBy = (String) generalMap.get("changedBy");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		BudMajorHead master = (BudMajorHead)hbt.load(BudMajorHead.class, majorheadId);
		master.setId(majorheadId);
		master.setMajorHeadCode(majorheadCode);
		master.setMajorHeadName(majorheadName);
		master.setSequenceNo(sequenceNo);
		master.setLastChgeBy(changedBy);
		master.setLastChgDate(currentDate);
		master.setLastChgTime(currentTime);
		try
		{
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
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchmajorhead(String MajorHeadCode,
			String MajorHeadName) {
		List<BudMajorHead> searchMajorHeadList = new ArrayList<BudMajorHead>();
		Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
		Session session =(Session)getSession();
		try
		{
			if ((MajorHeadName != null) || (MajorHeadCode == null))
			{
				searchMajorHeadList = session.createCriteria(BudMajorHead.class).add(Restrictions.like("MajorHeadName", MajorHeadName+"%")).list();

			}
			else
			{
				searchMajorHeadList = session.createCriteria(BudMajorHead.class).add(Restrictions.like("MajorHeadCode", MajorHeadCode+"%")).list();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		countryFieldsMap.put("searchMajorHeadList", searchMajorHeadList);
		return countryFieldsMap;
		}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showSubMajorHead() {
		Date d = new Date();
		String s = d.toString();
		
		Map<String, Object> map = new HashMap<String, Object>();
        List<BudSubMajorHead> searchSubMajorHeadList = new ArrayList<BudSubMajorHead>();
		List<BudMajorHead> majorHeadList = new ArrayList<BudMajorHead>();
		List<BudMajorHead> gridMajorHeadList = new ArrayList<BudMajorHead>();
		searchSubMajorHeadList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.BudSubMajorHead ");
		gridMajorHeadList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.BudMajorHead as isc where isc.Status= 'y' ");
		majorHeadList = getHibernateTemplate()
		.find("from jkt.hms.masters.business.BudMajorHead as isc where isc.Status = 'y'");
		map.put("searchSubMajorHeadList", searchSubMajorHeadList);
		map.put("majorHeadList", majorHeadList);
		map.put("gridMajorHeadList", gridMajorHeadList);
		
		return map;
	}


	@Override
	public boolean addSubMajorHead(BudSubMajorHead subMajorHead) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(subMajorHead);
		successfullyAdded = true;
		return successfullyAdded;
	}

public boolean editSubMajorHead(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = null;
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	String submajorheadName = "";
	String submajorheadCode = "";
	int submajorheadId = 0;
	int sequenceNo=0;
	int majorheadId = 0;
	String changedBy = "";
	currentDate = new Date();
	submajorheadId = (Integer) generalMap.get("subMajorHeadId");
	submajorheadCode = (String) generalMap.get("subMajorHeadCode");
	submajorheadName = (String) generalMap.get("name");
	majorheadId=(Integer) generalMap.get("majorHeadId");
	//sequenceNo =(Integer)generalMap.get("sequenceNo");
	changedBy = (String) generalMap.get("changedBy");
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	BudSubMajorHead master = (BudSubMajorHead)hbt.load(BudSubMajorHead.class, submajorheadId);
	master.setId(submajorheadId);
	master.setSubMajorHeadCode(submajorheadCode);
	master.setSubMajorHeadName(submajorheadName);
	//master.setSequenceNo(sequenceNo);
	master.setLastChgBy(changedBy);
	master.setLastChgTime(currentTime);
	try
	{
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

public boolean deleteSubMajorHead(int submajorheadId,
		Map<String, Object> generalMap) {
	boolean dataDeleted = false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	BudSubMajorHead master = (BudSubMajorHead) getHibernateTemplate().get(BudSubMajorHead.class, submajorheadId);
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
	master.setId(submajorheadId);
	master.setLastChgBy(changedBy);
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
public Map<String, Object> showMinorSubHead() {
	Map<String, Object> map = new HashMap<String, Object>();

	List<BudMinorSubHead> searchMinorSubHeadList = new ArrayList<BudMinorSubHead>();
	List<BudMinorHead> searchMinorHeadList = new ArrayList<BudMinorHead>();
	List<BudSubMajorHead> submajorHeadList = new ArrayList<BudSubMajorHead>();
	List<BudSubMajorHead> gridsubMajorHeadList = new ArrayList<BudSubMajorHead>();
	searchMinorSubHeadList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.BudMinorSubHead ");
	gridsubMajorHeadList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.BudSubMajorHead as isc where isc.Status= 'y' ");
	submajorHeadList = getHibernateTemplate()
	.find("from jkt.hms.masters.business.BudSubMajorHead as isc where isc.Status = 'y'");
	searchMinorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorHead as isc where isc.Status = 'y'");
	map.put("searchMinorSubHeadList", searchMinorSubHeadList);
	map.put("submajorHeadLi", submajorHeadList);
	map.put("gridsubMajorHeadList", gridsubMajorHeadList);
	map.put("searchMinorHeadList", searchMinorHeadList);
	return map;
}

public boolean addMinorSubHead(BudMinorSubHead minorSubHead) {
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(minorSubHead);
	successfullyAdded = true;
	return successfullyAdded;
}
public boolean deleteMinorSubHead(int minorsubheadId,
		Map<String, Object> generalMap) {
	boolean dataDeleted = false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	BudMinorSubHead master = (BudMinorSubHead) getHibernateTemplate().get(BudMinorSubHead.class, minorsubheadId);
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
	master.setId(minorsubheadId);
	master.setLastChgBy(changedBy);
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
public boolean editMinorSubHead(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	int submajorheadId = 0;
	String minorsubheadName = "";
	String minorsubheadCode = "";
	int minorsubheadId = 0;
	String changedBy = "";
	minorsubheadId = (Integer) generalMap.get("id");
	minorsubheadCode = (String) generalMap.get("countryCode");
	minorsubheadName = (String) generalMap.get("name");
	submajorheadId = (Integer) generalMap.get("currencyId");
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	//
	BudMinorSubHead masCountry = (BudMinorSubHead) getHibernateTemplate().get( BudMinorSubHead.class, minorsubheadId);
	//masCountry.setId(minorsubheadId);
	masCountry.setMinorSubHeadName(minorsubheadName);
	BudMinorHead masCurrency = new BudMinorHead();
	masCurrency.setId(submajorheadId);
	masCountry.setMinorHeadId(masCurrency);
	masCountry.setLastChgBy(changedBy);
	masCountry.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masCountry);
	dataUpdated = true;
	return dataUpdated;
}
@SuppressWarnings("unchecked")
public Map<String, Object> searchMinorSubHead(String minorSubHeadCode,
		String minorSubHeadName) {
	Session session = (Session)getSession();
	List<BudMinorSubHead> searchMinorHeadList = new ArrayList<BudMinorSubHead>();
	Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
	try
	{
		if ((minorSubHeadName != null) || (minorSubHeadCode == null))
		{
			searchMinorHeadList = session.createCriteria(BudMinorSubHead.class)
			.add(Restrictions.like("minorSubHeadName", minorSubHeadName+"%")).list();
		}
		else
		{
			searchMinorHeadList = session.createCriteria(BudMinorSubHead.class)
			.add(Restrictions.like("minorSubHeadCode", minorSubHeadCode+"%")).list();
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	countryFieldsMap.put("searchMinorHeadList", searchMinorHeadList);
	return countryFieldsMap;
	}
@SuppressWarnings("unchecked")
public Map<String, Object> showObjectHead() {
	Map<String, Object> map = new HashMap<String, Object>();
	List <BudObjectHead> searchobjectheadList = new ArrayList<BudObjectHead>();
	List <BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
	List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
	List <BudMinorHead> searchminorheadList = new ArrayList<BudMinorHead>();
	searchobjectheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead ");
	searchmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
	searchsubmajorheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
	searchminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead where Status= 'y'");
	gridmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
    gridsubmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
    gridminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
    searchminorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorHead where Status= 'y'");
    map.put("searchobjectheadList", searchobjectheadList);
    map.put("searchmajorheadList",searchmajorheadList);
    map.put("searchsubmajorheadList",searchsubmajorheadList);
    map.put("searchminorsubheadList", searchminorsubheadList);
    map.put("gridmajorheadList",gridmajorheadList);
    map.put("gridsubmajorheadList", gridsubmajorheadList);
    map.put("gridminorsubheadList", gridminorsubheadList);
    map.put("searchminorheadList", searchminorheadList);
    return map;
}
public boolean addObjectHead(BudObjectHead objecthead) {
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(objecthead);
	successfullyAdded = true;
	return successfullyAdded;

}
public boolean editObjectHead(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	int submajorheadId = 0;
	String objectHeadName = "";
	String objectHeadCode = "";
	int minorsubheadId = 0;
	int objectHeadId=0;
	String changedBy = "";
	objectHeadId = (Integer) generalMap.get("id");
	objectHeadCode = (String) generalMap.get("countryCode");
	objectHeadName = (String) generalMap.get("name");
	submajorheadId = (Integer) generalMap.get("currencyId");
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	BudObjectHead masCountry = (BudObjectHead) getHibernateTemplate().get(BudObjectHead.class, objectHeadId);
	masCountry.setId(objectHeadId);
	masCountry.setObjectHeadName(objectHeadName);
	BudSubMajorHead masCurrency = new BudSubMajorHead();
	masCurrency.setId(submajorheadId);
	//masCountry.setSubMajorHeadId(submajorheadId);
	masCountry.setLastChgBy(changedBy);
	masCountry.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masCountry);
	dataUpdated = true;
	return dataUpdated;
}
public boolean deleteObjectHead(int objectheadId,
		Map<String, Object> generalMap) {
	boolean dataDeleted = false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	BudObjectHead master = (BudObjectHead) getHibernateTemplate().get(BudObjectHead.class, objectheadId);
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
	master.setId(objectheadId);
	master.setLastChgBy(changedBy);
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
public Map<String, Object> searchsubmajorHead(String submajorheadCode,
		String submajorheadName) {
	List<BudSubMajorHead> searchSubMajorHeadList = new ArrayList<BudSubMajorHead>();
	List majorHeadList=null;
	Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
	List gridmajorHeadList = null;
	try
	{
		if ((submajorheadName != null) || (submajorheadCode == null))
		{
			searchSubMajorHeadList=getHibernateTemplate().find(
						"from jkt.hms.masters.business.BudSubMajorHead as i where i.SubMajorHeadName like '"
						+ submajorheadName + "%' order by i.SubMajorHeadName");
		}
		else
		{
			searchSubMajorHeadList = getHibernateTemplate().find(

					"from jkt.hms.masters.business.BudSubMajorHead as i where i.SubMajorHeadCode like '"
					+ submajorheadCode + "%' order by i.SubMajorHeadCode");
									}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	majorHeadList = getHibernateTemplate()	.find("from jkt.hms.masters.business.BudMajorHead as isc where isc.Status = 'y'");
	gridmajorHeadList =getHibernateTemplate()	.find("from jkt.hms.masters.business.BudMajorHead as isc where isc.Status = 'y'");
	countryFieldsMap.put("gridmajorHeadList", gridmajorHeadList);
	countryFieldsMap.put("searchSubMajorHeadList", searchSubMajorHeadList);
	countryFieldsMap.put("majorHeadList", majorHeadList);
	return countryFieldsMap;
}
@SuppressWarnings("unchecked")
@Override
public Map<String, Object> searchObjectHead(String objectheadCode,
		String objectheadName) {
	List<BudObjectHead> searchObjectHeadList = new ArrayList<BudObjectHead>();
	Map<String, Object> countryFieldsMap = new HashMap<String, Object>();
	try
	{
		if ((objectheadName != null) || (objectheadCode == null))
		{
			searchObjectHeadList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.BudObjectHead as i where i.ObjectHeadName like '"
							+ objectheadName + "%' order by i.ObjectHeadName");
		}
		else
		{
			searchObjectHeadList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.BudMajorHead as i where i.ObjectHeadCode like '"
							+ objectheadCode + "%' order by i.ObjectHeadCode");
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	countryFieldsMap.put("searchCountryList", searchObjectHeadList);
	return countryFieldsMap;
}

@SuppressWarnings("unchecked")
@Override
public Map<String, Object> showBudgetEstimateEntry() {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate=HMSUtil.convertDateToStringWithoutTime(new Date());
	String financialYear=HMSUtil.getFinancialYearYY_YY(currentDate);
	Session session = (Session)getSession();
	List <BudEstimateEntry> searchEstimateEntryList=new ArrayList<BudEstimateEntry>();
	List <BudEstimateEntry>searchEstimateEntryListSector=new ArrayList<BudEstimateEntry>();
	List <BudEstimateEntry> checkEntryNo=new ArrayList<BudEstimateEntry>();
	List <HrMasFinancialYear>searchFinancialYearList=new ArrayList<HrMasFinancialYear>();
	List <BudObjectHead> searchobjectheadList = new ArrayList<BudObjectHead>();
	List <BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
	List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
	List <BudMinorHead> searchminorheadList = new ArrayList<BudMinorHead>();
	List objectList=new ArrayList(); 
	int sequenceCounter=1;
	try{
        String num="";
        String entryNo="";
        checkEntryNo = getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry as hes order by hes.Id desc");
        
        if(checkEntryNo!=null && checkEntryNo.size()>0){
        	BudEstimateEntry hesEquipmentMaster=new BudEstimateEntry();
            hesEquipmentMaster=checkEntryNo.get(0);
            entryNo=hesEquipmentMaster.getDemandNo();
            
            num=getMaxEquipmentDate(entryNo);
        }
        else{
        	num="MS/VBCH"+"/"+financialYear+"/"+sequenceCounter;
        }
        map.put("num", num);
   }

catch(Exception pe)
{
    pe.printStackTrace();
}
	
	searchEstimateEntryList=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry ");
//	searchEstimateEntryListSector=session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("Id", trainingId)).list();
	searchFinancialYearList= getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear ");
	searchobjectheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead ");
	searchmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
	searchsubmajorheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
	searchminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead where Status= 'y'");
	gridmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
    gridsubmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
    gridminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead where Status= 'y'");
    searchminorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorHead where Status= 'y'");
    map.put("searchEstimateEntryList", searchEstimateEntryList);
    
    map.put("searchFinancialYearList",searchFinancialYearList);
    map.put("searchobjectheadList", searchobjectheadList);
    map.put("searchmajorheadList",searchmajorheadList);
    map.put("searchsubmajorheadList",searchsubmajorheadList);
    map.put("searchminorsubheadList", searchminorsubheadList);
    map.put("gridmajorheadList",gridmajorheadList);
    map.put("gridsubmajorheadList", gridsubmajorheadList);
    map.put("gridminorsubheadList", gridminorsubheadList);
    map.put("searchminorheadList",searchminorheadList);
    
    
    return map;
}


@Override
public boolean submitBudget(BudEstimateEntry estimateentry) {
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	
	hbt.save(estimateentry);
	successfullyAdded = true;
	return successfullyAdded;

}
@SuppressWarnings("unchecked")
public boolean addBudget(BudEstimateEntry estimate,Date encashDate,int objectheadId,String sectorType ) {
	String financialYear=null;
	Session session = (Session)getSession();
	int financialId=0;
	int trainingId=objectheadId;
	String ecash_date=null;
	List<BudEstimateEntry> estimateList=new ArrayList<BudEstimateEntry>();
	estimateList=session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("ObjectHeadId.Id", trainingId)).add(Restrictions.eq("SectorType", sectorType)).list();
	
	boolean successfullyAdded = false;
	if(estimateList.size()==0){
		BudObjectHead object=new BudObjectHead();
		object.setId(trainingId);
		estimate.setObjectHeadId(object);
		estimate.setSectorType(sectorType);
		ecash_date=HMSUtil.convertDateToStringTypeDateOnly(encashDate);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		financialYear=HMSUtil.getfinancialYearyyyy(ecash_date);
		
		financialId=getfinacialId(financialYear);
		
		HrMasFinancialYear financial = new HrMasFinancialYear();
		financial.setId(financialId);
		
		estimate.setFYear(financial);
		hbt.save(estimate);
		successfullyAdded = true;
		return successfullyAdded;
	}	
	else{
	
	successfullyAdded = false;
	return successfullyAdded;
	}
}

@SuppressWarnings("unchecked")
@Override
public Map<String, Object> showsearchBudgetEstimateEntry(String code) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List <BudEstimateEntry> searchEstimateEntryList=new ArrayList<BudEstimateEntry>();
	List <HrMasFinancialYear>searchFinancialYearList=new ArrayList<HrMasFinancialYear>();
	List <BudObjectHead> searchobjectheadList = new ArrayList<BudObjectHead>();
	List <BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
	List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
	searchEstimateEntryList=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry where DemandNo="+code);
	searchFinancialYearList= getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear ");
	searchobjectheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead ");
	searchmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
	searchsubmajorheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
	searchminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead where Status= 'y'");
	gridmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
    gridsubmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
    gridminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
    map.put("searchEstimateEntryList", searchEstimateEntryList);
    map.put("searchFinancialYearList",searchFinancialYearList);
    map.put("searchobjectheadList", searchobjectheadList);
    map.put("searchmajorheadList",searchmajorheadList);
    map.put("searchsubmajorheadList",searchsubmajorheadList);
    map.put("searchminorsubheadList", searchminorsubheadList);
    map.put("gridmajorheadList",gridmajorheadList);
    map.put("gridsubmajorheadList", gridsubmajorheadList);
    map.put("gridminorsubheadList", gridminorsubheadList);
    
    
    return map;
}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> showVoucherContingentBill() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	String currentDate=HMSUtil.convertDateToStringWithoutTime(new Date());
	String financialYear=HMSUtil.getFinancialYearYY_YY(currentDate);
	
	List <BudVoucherDetail> searchBudVoucherDetailList=new ArrayList<BudVoucherDetail>();
	List <BudVoucherHeader> searVoucherHeaderList = new ArrayList<BudVoucherHeader>();
	List <BudVoucherHeader> checkEntryNo = new ArrayList<BudVoucherHeader>();
	List <BudEstimateEntry> searchEstimateEntryList=new ArrayList<BudEstimateEntry>();
	List <HrMasFinancialYear>searchFinancialYearList=new ArrayList<HrMasFinancialYear>();
	List <BudObjectHead> searchobjectheadList = new ArrayList<BudObjectHead>();
	List <BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
	List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
	List <BudMinorHead> searchminorheadList = new ArrayList<BudMinorHead>();
	List objectList=new ArrayList();
	int sequenceCounter=1;
	try{
        String num="";
        String entryNo="";
        checkEntryNo = getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherHeader as hes order by hes.Id desc");
        if(checkEntryNo!=null  && checkEntryNo.size()>0){
        	BudVoucherHeader voucherHeader=new BudVoucherHeader();
        	voucherHeader=checkEntryNo.get(0);
            entryNo=voucherHeader.getBillNo();
            num=getMaxEquipmentDate(entryNo);
        }
        else{
        	num="MS/VBCH"+"/"+financialYear+"/"+sequenceCounter;
        }
        map.put("num", num);
   }

catch(Exception pe)
{
    pe.printStackTrace();
}
	searchBudVoucherDetailList=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherDetail");
	searVoucherHeaderList=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherHeader");
	searchEstimateEntryList=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry ");
	//searchFinancialYearList= getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear ");
	searchobjectheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead ");
	searchmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
	searchsubmajorheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
	searchminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead where Status= 'y'");
	gridmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
    gridsubmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
    gridminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
    searchminorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorHead where Status= 'y'");
    map.put("searchBudVoucherDetailList", searchBudVoucherDetailList);
    map.put("searVoucherHeaderList", searVoucherHeaderList);
    
    map.put("searchEstimateEntryList", searchEstimateEntryList);
    map.put("searchobjectheadList", searchobjectheadList);
    map.put("searchmajorheadList",searchmajorheadList);
    map.put("searchsubmajorheadList",searchsubmajorheadList);
    map.put("searchminorsubheadList", searchminorsubheadList);
    map.put("gridmajorheadList",gridmajorheadList);
    map.put("gridsubmajorheadList", gridsubmajorheadList);
    map.put("gridminorsubheadList", gridminorsubheadList);
    map.put("searchminorheadList", searchminorheadList);
    return map;

}


/*@Override
public boolean addVoucher(BudVoucherHeader voucherHeader) {
	Map<String, Object> map = new HashMap<String, Object>();
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
	Session session = (Session)getSession();
	Transaction tx = null;

	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(voucherHeader);
	successfullyAdded = true;
	return successfullyAdded;

}
*/

@SuppressWarnings("unchecked")
@Override
public synchronized String generateBilltNo(String flag) {
	Integer receiptSeqNo = 0;
	List<BlParameter> rcSeqNoList = new ArrayList<BlParameter>();
	Session session = (Session) getSession();
	try {
		rcSeqNoList = session.createCriteria(BlParameter.class).add(
				Restrictions.eq("Prefix", "RC")).list();
	} catch (HibernateException e) {
		e.printStackTrace();
	}

	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);

	/*receiptHeaderList = session.createCriteria(BlReceiptHeader.class)
			.list();
	String lastRcNo = "";
	if (receiptHeaderList.size() > 0) {
		for (BlReceiptHeader receiptHeader : receiptHeaderList) {
			lastRcNo = receiptHeader.getReceiptNo();
		}
	}*/
	int id = 0;
	int seqNo = 0;
	//String criteria = "";
	if (rcSeqNoList.size() > 0) {
		for (BlParameter blParameter : rcSeqNoList) {
			id = blParameter.getId();
			seqNo = blParameter.getSeqNo();
			//criteria = blParameter.getCriteria();
			receiptSeqNo = ++seqNo;
		}
		//receiptNo = commonSeqNo(receiptSeqNo, criteria, lastRcNo);

		if (flag.equals("save")) {
			BlParameter parameterObj = (BlParameter) hbt.load(
					BlParameter.class, id);
			parameterObj.setSeqNo(receiptSeqNo);
			hbt.update(parameterObj);
		}
	}
	String recNo = receiptSeqNo.toString();
	return recNo;
}


@Override
public String generateOrderNumber() {
	// TODO Auto-generated method stub
	return null;
}


@SuppressWarnings("unchecked")
@Override
public boolean submitVoucher(Box box) {
	boolean succesfullyAdded = false;
	boolean saved = false;
	try
	{
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Vector modalityName =box.getVector("modalityNameId");
		Vector remarks =box.getVector("remarksId");
		List <BudVoucherDetail> voucherList=new ArrayList<BudVoucherDetail>();

		BudVoucherHeader masHeader=new BudVoucherHeader();
		if(box.getString("BillNo")!=null)
	    {
			
	    	 masHeader.setBillNo(box.getString("billNo"));
	    }
		
	    if(box.getString("sectorType")!=null){
	    	masHeader.setSectorType(box.getString("sectorType"));
	    }
	   if(box.getString("MAJOR_HEAD_ID")!=null)
	   {
		   BudMajorHead majorHead=new BudMajorHead();
		   majorHead.setId(box.getInt("MAJOR_HEAD_ID"));
		   masHeader.setMajorHead(majorHead);
	   }
	   if(box.getString("MAJOR_SUB_HEAD_ID")!=null)
	   {
		   BudSubMajorHead subMajorHead=new BudSubMajorHead(); 
		   subMajorHead.setId(box.getInt("MAJOR_SUB_HEAD_ID"));
		   masHeader.setMajorSubHead(subMajorHead);
	   }
	   if(box.getString("MINOR_SUB_HEAD_ID")!=null)
		{
		   BudMinorSubHead minorSubHead= new BudMinorSubHead();
		   minorSubHead.setId(box.getInt("MINOR_SUB_HEAD_ID"));
		 //  masHeader.setMajorSubHeadId(minorSubHead);	

	   }
	   if(box.getString("OBJECT_HEAD_ID")!=null)
	   {
		   BudObjectHead objectHead=new BudObjectHead();
		   objectHead.setId(box.getInt("OBJECT_HEAD_ID"));
		   //masHeader.setObjectHead(objectHead);
	   }
	   if(HMSUtil.convertStringTypeDateToDateType(ENCASH_DATE)!=null)
	   {
	    	masHeader.setEncashDate(HMSUtil.convertStringTypeDateToDateType(ENCASH_DATE));
	   }
	   if(box.getString("SEARCH_NAME")!=null)
	   {
		   masHeader.setDescriptionOfCharge(box.getString("SEARCH_NAME"));
	   }
	   
	   if(box.getString(CHANGED_BY)!=null)
	   {
		   masHeader.setLastChgBy(box.getString(CHANGED_BY));
	   }
	   
	   if(HMSUtil.convertStringTypeDateToDateType(currentDate)!=null)
	   {
	    	masHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
	   }
	   if(time!=null)
	   {
		   masHeader.setLastChgTime(time);
	   }
	   if(STATUS!=null)
	   {
		   masHeader.setStatus(STATUS);
	   }
	   hbt.save(masHeader);
	   hbt.refresh(masHeader);
	   for (int i = 0; i < modalityName.size(); i++) {
			BudVoucherDetail detail=new BudVoucherDetail();
			BigDecimal amount =new BigDecimal(0);
			if (modalityName.get(i) != null && !modalityName.get(i).equals("")) {

               //detail.setBudgetId(masHeader.getId());
               
               detail.setChargeDescription(modalityName.get(i).toString());
               detail.setAmount(amount);
               detail.setStatus(STATUS_YES);
               detail.setLastChgBy(box.getString(USER_NAME));
               detail.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
               detail.setLastChgTime(time);
 			    hbt.save(detail);
			}
		}
		saved = true;

	}catch (Exception e) {
      saved =false;
		e.printStackTrace();

	}
	return succesfullyAdded;
	
}


@SuppressWarnings("unchecked")
@Override
public boolean addVoucher(Box box) {
	boolean succesfullyAdded = false;
	boolean saved = false;
	Session session = (Session) getSession();
	Transaction transaction =null;
	try
	{
	
		transaction = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		String financialYear=null;
		int financialId=0;
		int totalamount=0;
		String encashDate=null;;

		BudVoucherHeader masHeader=new BudVoucherHeader();
		if(box.getString(CODE)!=null)
	    {
	    	 masHeader.setBillNo(box.getString(CODE));
	    	 
	    }
	    if(box.getString(SEARCH_NAME)!=null)
	    {
	    	masHeader.setDescriptionOfCharge(box.get(SEARCH_NAME));
	    
    	}
	    BigDecimal totalamount1=new BigDecimal(0);
	    if((new BigDecimal(box.getString("totalamount")))!=null)
	      {
	    	masHeader.setTotalEstimatedAmount(new BigDecimal(box.getString("totalamount")));
	    }
	    if(HMSUtil.convertStringTypeDateToDateType(box.getString(BILL_DATE))!=null)
		   {
		    	masHeader.setBilldate(HMSUtil.convertStringTypeDateToDateType(box.getString(BILL_DATE)));
		   }
	    if(HMSUtil.convertStringTypeDateToDateType(box.getString(ENCASH_DATE))!=null)
		   {
		    	masHeader.setEncashDate(HMSUtil.convertStringTypeDateToDateType(box.getString(ENCASH_DATE)));
				
		   }
	    
	    String sectorType=box.getString(SECTOR_TYPE);
	    if(box.getString(SECTOR_TYPE)!=null)

	    {
	    	masHeader.setSectorType(box.getString(SECTOR_TYPE));
	    	}
	    if(box.getInt(MAJOR_HEAD_ID)!=0)
	    {
	    	BudMajorHead majorHead = new BudMajorHead();
	    	majorHead.setId(box.getInt(MAJOR_HEAD_ID));
	    		masHeader.setMajorHead(majorHead);
	    }	
	    /*if(box.getString(SECTOR_TYPE)!=null)
	    {
	    		masHeader.setSectorType(box.getString(SECTOR_TYPE));
	    }*/	
	    if(box.get(HOSPITAL_ID)!=null)
	    {
	    	MasHospital masHospital=new MasHospital();
	    	masHospital.setId(box.getInt(HOSPITAL_ID));
	    	masHeader.setHospital(masHospital);
	    }
	 
	    /*if(box.get("totalAmount")!=null)
	    {
	    	masHeader.set(box.getInt("totalAmount"));
	    }*/
	    encashDate=box.getString(ENCASH_DATE);
	    financialYear=HMSUtil.getfinancialYearyyyy(encashDate);
		
		financialId=getfinacialId(financialYear);
	    if(box.get(FINANCIAL_ID)!=null)
	    {
	    	encashDate=box.getString(ENCASH_DATE);
		    financialYear=HMSUtil.getfinancialYearyyyy(encashDate);
			
			financialId=getfinacialId(financialYear);
			
			HrMasFinancialYear financial = new HrMasFinancialYear();
			financial.setId(financialId);
			masHeader.setFinancial(financial);
				    }
	    int  majorheadId=box.getInt(MAJOR_SUB_HEAD_ID);
	    if(box.getInt(MAJOR_SUB_HEAD_ID)!=0)
	    {
				BudSubMajorHead subMajorHead=new BudSubMajorHead();
				subMajorHead.setId(box.getInt(MAJOR_SUB_HEAD_ID));
	    		masHeader.setMajorSubHead(subMajorHead);
	    }
	    int  minorSubHeadId=box.getInt(MINOR_SUB_HEAD_ID);
	    if(box.getInt(MINOR_SUB_HEAD_ID)!=0)
	    {
	    	BudMinorSubHead minorHead=new BudMinorSubHead();
	    	minorHead.setId(box.getInt(MINOR_SUB_HEAD_ID));
	    		masHeader.setMinorSubHead(minorHead);

	    }
	    int minorHeadId=box.getInt("minorHeadId1");
	    
	    if(minorHeadId!=0)
	    {
				BudMinorHead minor=new BudMinorHead();
				minor.setId(box.getInt("minorHeadId1"));
	    		masHeader.setMinorHead(minor);
	    }
	    
	    
	    int objectHeadId=box.getInt(OBJECT_HEAD_ID);
	    if(box.getInt(OBJECT_HEAD_ID)!=0)
	    {
	    		BudObjectHead objectHead=new BudObjectHead();
	    		objectHead.setId(box.getInt(OBJECT_HEAD_ID));
	    		masHeader.setObjectHead(objectHead);
	    }
	   if(box.getString(CHANGED_BY)!=null)
	   {
		   masHeader.setLastChgBy(box.getString(CHANGED_BY));
	   }
	   if(HMSUtil.convertStringTypeDateToDateType(currentDate)!=null)
	   {
	    	masHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
	   }
	   if(time!=null)
	   {
		   masHeader.setLastChgTime(time);
	   }
	   masHeader.setStatus(STATUS_YES);
	hbt.save(masHeader);

	   int counter = box.getInt("hdb");
	   
		for (int i = 1; i <= counter; i++) {
			
			BudVoucherDetail detail=new BudVoucherDetail();
			MasHospital masHospital= new MasHospital();
		
			   detail.setBudVoucherHeader(masHeader);
               // detail.setBudgetId(masHeader.getId());
                if((box.getString("description"+i)!=null))
                {
                
                detail.setChargeDescription(box.getString("description"+i));
                }
                if((new BigDecimal(box.getDouble("amount"+i)))!=null){
               
                detail.setAmount(new BigDecimal(box.getDouble("amount"+i)));
                }
                if(box.getString("subvoucher"+i)!=null){
                	
                	detail.setSubvoucherNo(box.getString("subvoucher"+i));
                }
                if(box.getString("remark"+i)!=null){
                	
                	detail.setRemarks(box.getString("remark"+i));
                }
                
                detail.setStatus(STATUS_YES);
                detail.setLastChgBy(box.getString(CHANGED_BY));
                detail.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
                detail.setLastChgTime(time);
               //  if(box.get(HOSPITAL_ID)!=null){
               // 	detail.setHospitalId(box.getInt(HOSPITAL_ID));
               //  }
               //	detail.setMajorHeadId(majorheadId);
               //	detail.setMinorSubHeadId(minorSubHeadId);
               //   detail.setObjectHeadId(objectHeadId);        
                    hbt.save(detail);
                   
				}
		 List<BudEstimateEntry> budEstimateEntryList = new ArrayList<BudEstimateEntry>();
 		budEstimateEntryList = session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("ObjectHeadId.Id", objectHeadId)).add(Restrictions.eq("SectorType",sectorType)).add(Restrictions.eq("FYear.Id",financialId)).list();
 		try{
 		if(budEstimateEntryList!=null){
 			for(BudEstimateEntry estimate:budEstimateEntryList){
 				BigDecimal amount1= new BigDecimal(box.getString("totalamount"));
 				BigDecimal amount2=estimate.getAmount();
 				BigDecimal amount=amount2.subtract(amount1);
 				estimate.setAmount(amount);
 				hbt.update(estimate);

 			}
 				
 		}
 		}catch(Exception e){
 			e.printStackTrace();
 		}
	   saved = true;
	   transaction.commit();
	}catch (Exception e) {
       saved =false;
		transaction.rollback();
       e.printStackTrace();

	}
	return succesfullyAdded;}
@Override
public Map<String, Object> getConnectionForReport() {
	Map<String, Object> connectionMap = new HashMap<String, Object>();
	Session session = (Session) getSession();
	Connection con = session.connection();
	connectionMap.put("con", con);
	return connectionMap;
}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> searchEstimation(int demandNo) {
	int trainingId=demandNo;
	int doctor_id =1;
	Map<String, Object> map = new HashMap<String, Object>();
	List<BudMinorSubHead> minorList = new ArrayList<BudMinorSubHead>();
	List<BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
	List<BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
	
	List<BudObjectHead> objectList = new ArrayList<BudObjectHead>();
	List<HrMasFinancialYear> searchFinancialYearList = new ArrayList<HrMasFinancialYear>();
	

	List<BudEstimateEntry> budgetEstimateFulList = new ArrayList<BudEstimateEntry>();
	Session session = (Session)getSession();
	budgetEstimateFulList = session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("Id", trainingId)).list();

	//majorList =getHibernateTemplate().find(	"from jkt.hms.masters.business.BudMajorHead");
	minorList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead");
	objectList=getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead");
	searchFinancialYearList = session.createCriteria(HrMasFinancialYear.class).list();
	searchmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead");
	searchsubmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead");
	map.put("searchsubmajorheadList",searchsubmajorheadList);
	map.put("searchmajorheadList", searchmajorheadList);
    map.put("searchFinancialYearList", searchFinancialYearList);
    map.put("minorList", minorList);
	//map.put("majorList", majorList);
	map.put("budgetEstimateFulList", budgetEstimateFulList);
	//map.put("budgetEstimateList", budgetEstimateList);
	map.put("objectList", objectList);

	return map;

}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> showBudgetReappropEntry(int financialId) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	Session session = (Session)getSession();
	List <BudReAppropEntry> searchReAppropList=new ArrayList<BudReAppropEntry>();
	List <BudReAppropEntry> checkEntryNo=new ArrayList<BudReAppropEntry>();
	List <BudEstimateEntry> searchEstimateEntryList=new ArrayList<BudEstimateEntry>();
	List <BudEstimateEntry> searchEstimateEntryListFinancial=new ArrayList<BudEstimateEntry>();
	List <BudEstimateEntry> searchEstimateEntryListObject=new ArrayList<BudEstimateEntry>();
	List <HrMasFinancialYear>searchFinancialYearList=new ArrayList<HrMasFinancialYear>();
	List <BudObjectHead> searchobjectheadList = new ArrayList<BudObjectHead>();
	List <BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
	List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
	List objectList=new ArrayList();
	searchReAppropList=getHibernateTemplate().find("from jkt.hms.masters.business.BudReAppropEntry");
	searchEstimateEntryListObject=session.createCriteria(BudEstimateEntry.class).list();
	 
	searchEstimateEntryListFinancial=session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("Id", financialId)).list();
	
	searchEstimateEntryList=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry ");
	searchFinancialYearList= getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear where Status='y' ");
	searchobjectheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead ");
	searchmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
	searchsubmajorheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
	searchminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead where Status= 'y'");
	String currentDate=null;
    currentDate = (String) utilMap.get("currentDate");
	String financialYear="";
	int sequenceCounter=1;
    financialYear=HMSUtil.getFinancialYearYY_YY(currentDate);
	try{
        String num="";
        String entryNo="";
        checkEntryNo = getHibernateTemplate().find("from jkt.hms.masters.business.BudReAppropEntry as hes order by hes.Id desc");
        
        if(checkEntryNo!=null && checkEntryNo.size()>0){
        	BudReAppropEntry hesEquipmentMaster=new BudReAppropEntry();
            hesEquipmentMaster=checkEntryNo.get(0);
            entryNo=hesEquipmentMaster.getReAppropNo();
            
            num=getMaxEquipmentDate(entryNo);
        }
        else{
            num="MS/VBCH"+"/"+financialYear+"/"+sequenceCounter;
        }
        map.put("num", num);
   }

catch(Exception pe)
{
    pe.printStackTrace();
}
 
    map.put("searchEstimateEntryList", searchEstimateEntryList);
    map.put("searchFinancialYearList",searchFinancialYearList);
    map.put("searchobjectheadList", searchobjectheadList);
    map.put("searchmajorheadList",searchmajorheadList);
    map.put("searchsubmajorheadList",searchsubmajorheadList);
    map.put("searchminorsubheadList", searchminorsubheadList);
    map.put("searchReAppropList", searchReAppropList);
    map.put("searchEstimateEntryListFinancial", searchEstimateEntryListFinancial);
    map.put("searchEstimateEntryListObject",searchEstimateEntryListObject);   
   /* map.put("max", num);*/
    return map;
    
}


@Override
public boolean addBudgetreapprop(BudReAppropEntry estimate,int budgetId) {
	boolean successfullyAdded = false;
	BigDecimal	excessAmount=new BigDecimal(0.0);
	BigDecimal	SavingAmount=new BigDecimal(0.0);
	BigDecimal	amount=new BigDecimal(0.0);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
	hbt.save(estimate);
	if(estimate.getType().equalsIgnoreCase("saving")){
		BudEstimateEntry master = (BudEstimateEntry)hbt.load(BudEstimateEntry.class, budgetId);
		SavingAmount=estimate.getReappamount().add(master.getSavingAmount());
		amount=master.getAmount().subtract(estimate.getReappamount());
		
		master.setSavingAmount(SavingAmount);
		master.setAmount(amount);
		hbt.saveOrUpdate(master);
	}
	else{
		BudEstimateEntry master = (BudEstimateEntry)hbt.load(BudEstimateEntry.class, budgetId);
		excessAmount=estimate.getReappamount().add(master.getExcessAmount());
		amount=master.getAmount().add(estimate.getReappamount());
		master.setExcessAmount(excessAmount);
		master.setAmount(amount);
		hbt.saveOrUpdate(master);
	}
	successfullyAdded = true;
	return successfullyAdded;
}
@SuppressWarnings("unchecked")
@Override
public Map<String, Object> getNameTitle(String demandNo) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudMajorHead> patientNameTitleList=new ArrayList<BudMajorHead>();
	patientNameTitleList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
	map.put("patientNameTitleList", patientNameTitleList);
	return map;
}


@Override
public boolean updateEstimateEntry(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	int submajorheadId = 0;
	BigDecimal amount = new BigDecimal(0);
	String demandNo = "";
	int minorsubheadId = 0;
	int budgetId=0;
	String changedBy = "";
	budgetId = (Integer) generalMap.get("id");
	demandNo = (String) generalMap.get("countryCode");
	amount = (BigDecimal)generalMap.get("name") ;
	submajorheadId = (Integer) generalMap.get("currencyId");
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	BudEstimateEntry masCountry = (BudEstimateEntry) getHibernateTemplate().get(BudEstimateEntry.class, budgetId);
	masCountry.setId(budgetId);
	masCountry.setAmount(amount);
	
	BudSubMajorHead masCurrency = new BudSubMajorHead();
	masCurrency.setId(submajorheadId);
	masCountry.setMajorSubHeadId
	(masCurrency);
	masCountry.setLastChgBy(changedBy);
	masCountry.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masCountry);
	dataUpdated = true;
	return dataUpdated;
}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> searchBudgetEstimateEntry(int code1) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	int trainingId=code1;
	List<BudEstimateEntry> budEstimateEntryList=new ArrayList<BudEstimateEntry>();
	List<BudEstimateEntry> budEstimateEntryListFul=new ArrayList<BudEstimateEntry>();
	List<BudMajorHead> budMajorHeadList=new ArrayList<BudMajorHead>();
	List<BudSubMajorHead>budSubMajorHeadList= new ArrayList<BudSubMajorHead>();
	List<BudMinorSubHead>budMinorSubHeadList= new ArrayList<BudMinorSubHead>();
	List<BudMinorHead>searchminorsubheadList= new ArrayList<BudMinorHead>();
	List<BudObjectHead>budObjectHeadList= new ArrayList<BudObjectHead>();
	List<HrMasFinancialYear>hrMasFinancialYearList= new ArrayList<HrMasFinancialYear>();
	budEstimateEntryList = session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("Id", trainingId)).list();
	budEstimateEntryListFul=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry");
	budMajorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead");
	budSubMajorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead");
	budMinorSubHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead");
	budObjectHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead");
	searchminorsubheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorHead");
	hrMasFinancialYearList=getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear");
    map.put("budEstimateEntryList",budEstimateEntryList);
    map.put("budEstimateEntryListFul",budEstimateEntryListFul);
    map.put("budMajorHeadList",budMajorHeadList);
    map.put("budSubMajorHeadList",budSubMajorHeadList);
    map.put("budMinorSubHeadList",budMinorSubHeadList);
    map.put("budObjectHeadList",budObjectHeadList);
    map.put("hrMasFinancialYearList",hrMasFinancialYearList);
    map.put("searchminorsubheadList",searchminorsubheadList); 
    
	return map;
}
public static String getFinancialYearYY_YY(String currentDate) {
	 String financialYear="";
	 try{
		 String[] str = currentDate.split("/");
		 int month=Integer.parseInt(str[1]);
		 int temp=0;
		 int temp1=0;
		 if(month<=3){
			 temp1=Integer.parseInt(str[2].substring(1));
			 temp=Integer.parseInt(str[2])-1;
			 financialYear=temp+"-"+temp1;
		 }else{
			 temp1=Integer.parseInt(str[2].substring(1));
			 temp=Integer.parseInt(str[2].substring(1))+1;
			 financialYear=temp1+"-"+temp;
		 }
	 }catch (Exception e) {
		 e.printStackTrace();
	 }

	 return financialYear;
}


@Override
public boolean addVoucher(BudVoucherHeader voucherHeader) {
	// TODO Auto-generated method stub
	return false;
}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> showResponse(int objectheadId,int financialId,String sectorType) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	Session session = (Session)getSession();
	
	int trainingId=objectheadId;
	List <BudReAppropEntry> checkEntryNo= new ArrayList<BudReAppropEntry>();
	List <BudReAppropEntry> searchBudReAppropEntry= new ArrayList<BudReAppropEntry>();
	List <BudEstimateEntry> searchEstimateEntryList=new ArrayList<BudEstimateEntry>();
	
	List <HrMasFinancialYear>searchFinancialYearList=new ArrayList<HrMasFinancialYear>();
	List <BudObjectHead> searchobjectheadList = new ArrayList<BudObjectHead>();
	List <BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
	searchEstimateEntryList = session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("ObjectHeadId.Id", objectheadId)).add(Restrictions.eq("FYear.Id", financialId)).add(Restrictions.eq("SectorType", sectorType)).list();
	
	
	/*searchBudReAppropEntry=getHibernateTemplate().find("from jkt.hms.masters.business.BudReAppropEntry");*/
	searchFinancialYearList=getHibernateTemplate().find(" from jkt.hrms.masters.business.HrMasFinancialYear");
	
	searchobjectheadList=getHibernateTemplate().find(" from jkt.hms.masters.business.BudObjectHead");
	
	searchmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead");
	
	searchsubmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead");
	
	searchminorsubheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead");
	searchBudReAppropEntry=getHibernateTemplate().find("from jkt.hms.masters.business.BudReAppropEntry");
	/*map.put("searchBudReAppropEntry", searchBudReAppropEntry);*/
    String currentDate=null;
    currentDate = (String) utilMap.get("currentDate");
	String financialYear="";
	int sequenceCounter=1;
    financialYear=HMSUtil.getFinancialYearYY_YY(currentDate);
    
	try{
        String num="";
        String entryNo="";
        checkEntryNo = getHibernateTemplate().find("from jkt.hms.masters.business.BudReAppropEntry as hes order by hes.Id desc");
    
        if(checkEntryNo!=null && checkEntryNo.size()>0){
        	BudReAppropEntry hesEquipmentMaster=new BudReAppropEntry();
            hesEquipmentMaster=checkEntryNo.get(0);
            entryNo=hesEquipmentMaster.getReAppropNo();
            
            num=getMaxEquipmentDate(entryNo);
        }
        else{
            num="MS/VBCH"+"/"+financialYear+"/"+sequenceCounter;
        }
        map.put("num", num);
   }

catch(Exception pe)
{
    pe.printStackTrace();
}
	
    map.put("searchEstimateEntryList", searchEstimateEntryList);
    map.put("searchFinancialYearList",searchFinancialYearList);
    map.put("searchobjectheadList", searchobjectheadList);
    map.put("searchmajorheadList",searchmajorheadList);
    map.put("searchsubmajorheadList",searchsubmajorheadList);
    map.put("searchminorsubheadList", searchminorsubheadList);
    map.put("searchBudReAppropEntry", searchBudReAppropEntry);
    

    return map;
    }
public String getMaxEquipmentDate(String no) {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	String sequenceNo="";
    String fixedEntryNo="MS/VBCH";
//   int voucherNo = AccountDataServiceImpl.generateVoucherNo(paramMap);
    try{
        Map<String, Object> utilMap = new HashMap<String, Object>();
        utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
        String currentDate="";
        currentDate = (String) utilMap.get("currentDate");
        String financialYear="";
       
       financialYear=HMSUtil.getFinancialYearYY_YY(currentDate);

        if(!no.equalsIgnoreCase("") ){
            
            String[] str = no.split("/");
            
            String seqTemp="";
            
            int sequenceCounter=0;
            sequenceCounter=Integer.parseInt(""+str[3])+1;
                      
        if(no != null || no != ""){
            sequenceNo="MS/VBCH"+"/"+financialYear+"/"+sequenceCounter;
            
        }
        else{
            sequenceNo="MS/VBCH"+"/"+financialYear+"/"+sequenceCounter;
            
        }
    }
    }catch (Exception e) {
        e.printStackTrace();
    }

    return sequenceNo;
 }


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> searchBudgetReAppropEntry(int code1) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	int trainingId=code1;
	List<BudReAppropEntry> budReAppropEntryList=new ArrayList<BudReAppropEntry>();
	List<BudReAppropEntry> budReAppropEntryListFull=new ArrayList<BudReAppropEntry>();
	List<BudEstimateEntry> budEstimateEntryListFul=new ArrayList<BudEstimateEntry>();
	List<BudMajorHead> budMajorHeadList=new ArrayList<BudMajorHead>();
	List<BudSubMajorHead>budSubMajorHeadList= new ArrayList<BudSubMajorHead>();
	List<BudMinorSubHead>budMinorSubHeadList= new ArrayList<BudMinorSubHead>();
	List<BudObjectHead>budObjectHeadList= new ArrayList<BudObjectHead>();
	List<HrMasFinancialYear>hrMasFinancialYearList= new ArrayList<HrMasFinancialYear>();
	budReAppropEntryList = session.createCriteria(BudReAppropEntry.class).add(Restrictions.eq("Id", trainingId)).list();
	budReAppropEntryListFull=getHibernateTemplate().find("from jkt.hms.masters.business.BudReAppropEntry");
	budEstimateEntryListFul=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry");
	budMajorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead");
	budSubMajorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead");
	budMinorSubHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead");
	budObjectHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead");
	hrMasFinancialYearList=getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear");
    map.put("budReAppropEntryList",budReAppropEntryList);
    map.put("budReAppropEntryListFull",budReAppropEntryListFull);
    map.put("budEstimateEntryListFul",budEstimateEntryListFul);
    map.put("budMajorHeadList",budMajorHeadList);
    map.put("budSubMajorHeadList",budSubMajorHeadList);
    map.put("budMinorSubHeadList",budMinorSubHeadList);
    map.put("budObjectHeadList",budObjectHeadList);
    map.put("hrMasFinancialYearList",hrMasFinancialYearList);
	return map;
}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> getMaxEquipmentDate(int financialId) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudEstimateEntry> budEstimateEntryList=new ArrayList<BudEstimateEntry>();
	budEstimateEntryList = session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("financialId", financialId)).list();
	return null;
}
public int getfinacialId(String financialYear) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	int financialId=0;
	String 	currentDate=null;
	
	List<HrMasFinancialYear> masFinancial=new ArrayList<HrMasFinancialYear>();
	masFinancial = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("YearDescription", financialYear)).list();
	
	for(HrMasFinancialYear fy:masFinancial){
	financialId=fy.getId();
	}
	
	
	return financialId;

}


@SuppressWarnings("unchecked")
public Map<String, Object> showVoucherReceiptEntry() {
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
Session session = (Session)getSession();
List <BudVoucherReceiptEntry> searchBudVoucherReceiptEntry=new ArrayList<BudVoucherReceiptEntry>();
List <BudReAppropEntry> searchReAppropList=new ArrayList<BudReAppropEntry>();
List <BudVoucherReceiptEntry> checkEntryNo=new ArrayList<BudVoucherReceiptEntry>();
List <BudEstimateEntry> searchEstimateEntryList=new ArrayList<BudEstimateEntry>();
List <HrMasFinancialYear>searchFinancialYearList=new ArrayList<HrMasFinancialYear>();
List <BudObjectHead> searchobjectheadList = new ArrayList<BudObjectHead>();
List <BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
List objectList=new ArrayList();
searchBudVoucherReceiptEntry=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherReceiptEntry where Status='y'");
searchReAppropList=getHibernateTemplate().find("from jkt.hms.masters.business.BudReAppropEntry where Status='y'");
searchEstimateEntryList=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry where Status='y'");
searchFinancialYearList= getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear where Status='y' ");
searchobjectheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead ");
searchmajorheadList = getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead where Status= 'y'");
searchsubmajorheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead where Status= 'y'");
searchminorsubheadList= getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead where Status= 'y'");
String currentDate=null;
currentDate = (String) utilMap.get("currentDate");
String financialYear="";
int sequenceCounter=1;
financialYear=HMSUtil.getFinancialYearYY_YY(currentDate);
try{
String num="";
String entryNo="";
checkEntryNo = getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherReceiptEntry as hes order by hes.Id desc");

if(checkEntryNo!=null && checkEntryNo.size()>0){
BudVoucherReceiptEntry hesEquipmentMaster=new BudVoucherReceiptEntry();
hesEquipmentMaster=checkEntryNo.get(0);
entryNo=hesEquipmentMaster.getReceiptNo();

num=getMaxEquipmentDate(entryNo);
}
else{
num="MS/VBCH"+"/"+financialYear+"/"+sequenceCounter;
}
map.put("num", num);
}

catch(Exception pe)
{
pe.printStackTrace();
}
map.put("searchEstimateEntryList", searchEstimateEntryList);
map.put("searchFinancialYearList",searchFinancialYearList);
map.put("searchobjectheadList", searchobjectheadList);
map.put("searchmajorheadList",searchmajorheadList);
map.put("searchsubmajorheadList",searchsubmajorheadList);
map.put("searchminorsubheadList", searchminorsubheadList);
map.put("searchReAppropList", searchReAppropList);
map.put("searchBudVoucherReceiptEntry", searchBudVoucherReceiptEntry);

/* map.put("max", num);*/
return map;

}
@Override
public boolean addReceiptVoucher(BudVoucherReceiptEntry estimate,String receiptDate) {
	boolean successfullyAdded = false;
	String financialYear=null;
	int financialId=0;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	financialYear=HMSUtil.getfinancialYearyyyy(receiptDate);
	financialId=getfinacialId(financialYear);
	HrMasFinancialYear financial=new HrMasFinancialYear(); 
	financial.setId(financialId);
	estimate.setFinancial(financial);
	hbt.setCheckWriteOperations(false);	
	hbt.save(estimate);
	
	successfullyAdded = true;
	return successfullyAdded;
}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> searchReceiptNo(int code1) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	int trainingId=code1;
	List<BudVoucherReceiptEntry> budVoucherReceiptEntry=new ArrayList<BudVoucherReceiptEntry>();
	List<BudVoucherReceiptEntry> budVoucherReceiptEntryFull=new ArrayList<BudVoucherReceiptEntry>();
	List<BudEstimateEntry> budEstimateEntryListFul=new ArrayList<BudEstimateEntry>();
	List<BudMajorHead> budMajorHeadList=new ArrayList<BudMajorHead>();
	List<BudSubMajorHead>budSubMajorHeadList= new ArrayList<BudSubMajorHead>();
	List<BudMinorHead>budMinorHeadList= new ArrayList<BudMinorHead>();
	List<BudMinorSubHead>budMinorSubHeadList= new ArrayList<BudMinorSubHead>();
	List<BudObjectHead>budObjectHeadList= new ArrayList<BudObjectHead>();
	List<HrMasFinancialYear>hrMasFinancialYearList= new ArrayList<HrMasFinancialYear>();
	budVoucherReceiptEntry = session.createCriteria(BudVoucherReceiptEntry.class).add(Restrictions.eq("Id", trainingId)).list();
	budVoucherReceiptEntryFull=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherReceiptEntry");
	budEstimateEntryListFul=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry");
	budMajorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead");
	budSubMajorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead");
	budMinorSubHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead");
	budObjectHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead");
	hrMasFinancialYearList=getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear");
	budMinorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorHead");
    map.put("budVoucherReceiptEntry",budVoucherReceiptEntry);
    map.put("budVoucherReceiptEntryFull",budVoucherReceiptEntryFull);    
    map.put("budEstimateEntryListFul",budEstimateEntryListFul);
    map.put("budMajorHeadList",budMajorHeadList);
    map.put("budSubMajorHeadList",budSubMajorHeadList);
    map.put("budMinorSubHeadList",budMinorSubHeadList);
    map.put("budObjectHeadList",budObjectHeadList);
    map.put("hrMasFinancialYearList",hrMasFinancialYearList);
    map.put("budMinorHeadList", budMinorHeadList);
    
	return map;
}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> showMinorHead() {
	Map<String, Object> map = new HashMap<String, Object>();

	List<BudMinorHead> searchMinorHeadList = new ArrayList<BudMinorHead>();
	List<BudSubMajorHead> submajorHeadList = new ArrayList<BudSubMajorHead>();
	List<BudSubMajorHead> gridsubMajorHeadList = new ArrayList<BudSubMajorHead>();
	searchMinorHeadList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.BudMinorHead ");
	gridsubMajorHeadList = getHibernateTemplate().find(
	"from jkt.hms.masters.business.BudSubMajorHead as isc where isc.Status= 'y' ");
	submajorHeadList = getHibernateTemplate()
	.find("from jkt.hms.masters.business.BudSubMajorHead as isc where isc.Status = 'y'");

	map.put("searchMinorHeadList", searchMinorHeadList);
	map.put("submajorHeadList", submajorHeadList);
	map.put("gridsubMajorHeadList", gridsubMajorHeadList);
	return map;
}


@Override
public boolean addMinorHead(BudMinorHead minorHead) {
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(minorHead);
	successfullyAdded = true;
	return successfullyAdded;
}


@Override
public boolean editMinorHead(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	int submajorheadId = 0;
	String minorsubheadName = "";
	String minorsubheadCode = "";
	int minorsubheadId = 0;
	String changedBy = "";
	minorsubheadId = (Integer) generalMap.get("id");
	minorsubheadCode = (String) generalMap.get("countryCode");
	minorsubheadName = (String) generalMap.get("name");
	submajorheadId = (Integer) generalMap.get("currencyId");
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	BudMinorHead masCountry = (BudMinorHead) getHibernateTemplate().get( BudMinorHead.class, minorsubheadId);
	masCountry.setId(minorsubheadId);
	masCountry.setMinorHeadName(minorsubheadName);
	BudSubMajorHead masCurrency = new BudSubMajorHead();
	masCurrency.setId(submajorheadId);
	masCountry.setSubMajorHeadId(masCurrency);
	masCountry.setLastChgBy(changedBy);
	masCountry.setLastChgTime(currentTime);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masCountry);
	dataUpdated = true;
	return dataUpdated;
}


@Override
public boolean deleteMinorHead(int minorsubheadId,
		Map<String, Object> generalMap) {
	boolean dataDeleted = false;
	String changedBy = "";
	Date currentDate = new Date();
	String currentTime = "";
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	BudMinorHead master = (BudMinorHead) getHibernateTemplate().get(BudMinorHead.class, minorsubheadId);
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
	master.setId(minorsubheadId);
	master.setLastChgBy(changedBy);
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
public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
	Map<String, Object> mapResponse = new HashMap<String, Object>();
	Session session = (Session) getSession();
	Integer hospitalId = 0;
	if (mapForDs.get("hospitalId") != null) {
		hospitalId = (Integer) mapForDs.get("hospitalId");
	}
	try {
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		masHospitaList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Id", hospitalId)).add(Restrictions.eq("Status","y")).list();
		mapResponse.put("masHospitaList", masHospitaList);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return mapResponse;}


@Override
public Map<String, Object> showObj(String sectorType) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean editBudget(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	int submajorheadId = 0;
	String demandNo = "";
	String objectHeadCode = "";
	int minorsubheadId = 0;
	int objectHeadId=0;
	String changedBy = "";
	int objectheadId=0;
	int financialId=0;
	int	majorheadId=0;
	int minorheadId=0;
	int minorSubheadId=0;
	int estimateId=0;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	BigDecimal amount=new BigDecimal(0.0);
	//objectheadId = (Integer) generalMap.get("objectheadId");
	objectHeadCode = (String) generalMap.get("countryCode");
	amount =( BigDecimal)generalMap.get("Name") ;
	submajorheadId = (Integer) generalMap.get("submajorheadId");
	
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	financialId=(Integer) generalMap.get("financialId");
	majorheadId=(Integer) generalMap.get("majorheadId");
	estimateId=(Integer) generalMap.get("estimateId");	
	
	
	//norheadId=(Integer) generalMap.get("minorheadId");
	minorSubheadId=(Integer) generalMap.get("minorSubheadId");
	generalMap.put("objectHeadId", objectHeadId);
	generalMap.put("changedBy", changedBy);
	Map<String, Object> listMap = new HashMap<String, Object>();
	generalMap.put("flag", true);
	BudEstimateEntry masCountry = (BudEstimateEntry)hbt.load(BudEstimateEntry.class, estimateId);
	 
	masCountry.setId(estimateId);
	masCountry.setAmount(amount);
	/*BudSubMajorHead masCurrency = new BudSubMajorHead();
	masCurrency.setId(submajorheadId);
	//masCountry.setSubMajorHeadId(submajorheadId);
*/	masCountry.setLastChgBy(changedBy);
	masCountry.setLastChgTime(currentTime);
	//org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masCountry);
	dataUpdated = true;
	return dataUpdated;
}


@SuppressWarnings("unchecked")
@Override
public Map<String, Object> showReceipt(int objectheadId,String sectorType,int financialId) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	Session session = (Session)getSession();
	int trainingId=objectheadId;
	List <BudEstimateEntry> searchBudEstimateEntry= new ArrayList<BudEstimateEntry>();
	List <BudVoucherReceiptEntry> searchBudVoucherReceiptEntry= new ArrayList<BudVoucherReceiptEntry>();
	List <BudVoucherReceiptEntry> checkEntryNo= new ArrayList<BudVoucherReceiptEntry>();
	List <HrMasFinancialYear>searchFinancialYearList=new ArrayList<HrMasFinancialYear>();
	List <BudObjectHead> searchobjectheadList = new ArrayList<BudObjectHead>();
	List <BudMajorHead> searchmajorheadList = new ArrayList<BudMajorHead>();
	List <BudSubMajorHead> searchsubmajorheadList = new ArrayList<BudSubMajorHead>();
	List <BudMinorSubHead> searchminorsubheadList = new ArrayList<BudMinorSubHead>();
	searchBudEstimateEntry=session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("ObjectHeadId.Id", objectheadId)).add(Restrictions.eq("SectorType", sectorType)).add(Restrictions.eq("FYear.Id", financialId)).list();
	searchBudVoucherReceiptEntry=getHibernateTemplate().find(" from jkt.hms.masters.business.BudVoucherReceiptEntry");
	searchobjectheadList = session.createCriteria(BudObjectHead.class).add(Restrictions.eq("Id", objectheadId)).list();
	searchFinancialYearList=getHibernateTemplate().find(" from jkt.hrms.masters.business.HrMasFinancialYear");
	searchobjectheadList=getHibernateTemplate().find(" from jkt.hms.masters.business.BudObjectHead");
	searchmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead");
	searchsubmajorheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead");
	searchminorsubheadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead");
	String currentDate=null;
	currentDate = (String) utilMap.get("currentDate");
	String financialYear="";
	int sequenceCounter=1;
	financialYear=HMSUtil.getFinancialYearYY_YY(currentDate);
	try{
	String num="";
	String entryNo="";
	checkEntryNo = getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherReceiptEntry as hes order by hes.Id desc");
	if(checkEntryNo!=null && checkEntryNo.size()>0){
	BudVoucherReceiptEntry hesEquipmentMaster=new BudVoucherReceiptEntry();
	hesEquipmentMaster=checkEntryNo.get(0);
	entryNo=hesEquipmentMaster.getReceiptNo();
	num=getMaxEquipmentDate(entryNo);
	}
	else{
	num="MS/VBCH"+"/"+financialYear+"/"+sequenceCounter;
	}
	map.put("num", num);
	}

	catch(Exception pe)
	{
	pe.printStackTrace();
	}
	map.put("searchBudVoucherReceiptEntry",searchBudVoucherReceiptEntry);
	map.put("searchFinancialYearList",searchFinancialYearList);
	map.put("searchobjectheadList", searchobjectheadList);
	map.put("searchmajorheadList",searchmajorheadList);
	map.put("searchsubmajorheadList",searchsubmajorheadList);
	map.put("searchminorsubheadList", searchminorsubheadList);
	map.put("searchBudEstimateEntry", searchBudEstimateEntry);
	return map;
	}

@SuppressWarnings("unchecked")
@Override
public Map<String, Object> showReceipts(String sectorType) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	Session session = (Session)getSession();
	
	List <BudEstimateEntry> searchEstimateEntryListObj=new ArrayList<BudEstimateEntry>();
	searchEstimateEntryListObj = session.createCriteria(BudEstimateEntry.class).add(Restrictions.eq("SectorType", sectorType)).list();
    map.put("searchEstimateEntryListObj", searchEstimateEntryListObj);
    
    
    return map;
}
public boolean editReceipt(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	int submajorheadId = 0;
	String demandNo = "";
	String objectHeadCode = "";
	int minorsubheadId = 0;
	int objectHeadId=0;
	String changedBy = "";
	int objectheadId=0;
	int financialId=0;
	int	majorheadId=0;
	int minorheadId=0;
	int minorSubheadId=0;
	int estimateId=0;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	BigDecimal amount=new BigDecimal(0.0);
	//objectheadId = (Integer) generalMap.get("objectheadId");
	objectHeadCode = (String) generalMap.get("countryCode");
	
	amount =( BigDecimal)generalMap.get("Name") ;
	submajorheadId = (Integer) generalMap.get("submajorheadId");
	
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	financialId=(Integer) generalMap.get("financialId");
	majorheadId=(Integer) generalMap.get("majorheadId");
	estimateId=(Integer) generalMap.get("estimateId");	
	
	
	//norheadId=(Integer) generalMap.get("minorheadId");
	minorSubheadId=(Integer) generalMap.get("minorSubheadId");
	generalMap.put("objectHeadId", objectHeadId);
	generalMap.put("changedBy", changedBy);
	Map<String, Object> listMap = new HashMap<String, Object>();
	generalMap.put("flag", true);
	
	BudVoucherReceiptEntry masCountry = (BudVoucherReceiptEntry)hbt.load(BudVoucherReceiptEntry.class, estimateId);
	 
	masCountry.setId(estimateId);
	masCountry.setAmount(amount);
	/*BudSubMajorHead masCurrency = new BudSubMajorHead();
	masCurrency.setId(submajorheadId);
	//masCountry.setSubMajorHeadId(submajorheadId);
*/	masCountry.setLastChgBy(changedBy);
	masCountry.setLastChgTime(currentTime);
	//org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masCountry);
	dataUpdated = true;
	return dataUpdated;
}
public boolean editReApprop(Map<String, Object> generalMap) {
	boolean dataUpdated = false;
	Date currentDate = new Date();
	String currentTime = "";
	currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	int submajorheadId = 0;
	String demandNo = "";
	String objectHeadCode = "";
	int minorsubheadId = 0;
	int objectHeadId=0;
	String changedBy = "";
	int objectheadId=0;
	int financialId=0;
	int	majorheadId=0;
	int minorheadId=0;
	int minorSubheadId=0;
	int estimateId=0;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	BigDecimal amount=new BigDecimal(0.0);
	//objectheadId = (Integer) generalMap.get("objectheadId");
	objectHeadCode = (String) generalMap.get("countryCode");
	
	amount =( BigDecimal)generalMap.get("Name") ;
	submajorheadId = (Integer) generalMap.get("submajorheadId");
	
	changedBy = (String) generalMap.get("changedBy");
	currentDate = (Date) generalMap.get("currentDate");
	currentTime = (String) generalMap.get("currentTime");
	financialId=(Integer) generalMap.get("financialId");
	majorheadId=(Integer) generalMap.get("majorheadId");
	estimateId=(Integer) generalMap.get("estimateId");	
	
	
	//norheadId=(Integer) generalMap.get("minorheadId");
	minorSubheadId=(Integer) generalMap.get("minorSubheadId");
	generalMap.put("objectHeadId", objectHeadId);
	generalMap.put("changedBy", changedBy);
	Map<String, Object> listMap = new HashMap<String, Object>();
	generalMap.put("flag", true);
	
	BudReAppropEntry masCountry = (BudReAppropEntry)hbt.load(BudReAppropEntry.class, estimateId);
	 
	masCountry.setId(estimateId);
	masCountry.setReappamount(amount);
	/*BudSubMajorHead masCurrency = new BudSubMajorHead();
	masCurrency.setId(submajorheadId);
	//masCountry.setSubMajorHeadId(submajorheadId);
*/	masCountry.setLastChgBy(changedBy);
	masCountry.setLastChgTime(currentTime);
	//org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	hbt.update(masCountry);
	dataUpdated = true;
	return dataUpdated;
}

public Map<String, Object> searchBillNo(int code1) {
Map<String, Object> map = new HashMap<String, Object>();
Session session = (Session)getSession();
int trainingId=code1;
List<BudVoucherHeader> budVoucherHeader=new ArrayList<BudVoucherHeader>();
List<BudVoucherHeader> budVoucherHeaderFull=new ArrayList<BudVoucherHeader>();
List<BudEstimateEntry> budEstimateEntryListFul=new ArrayList<BudEstimateEntry>();
List<BudMajorHead> budMajorHeadList=new ArrayList<BudMajorHead>();
List<BudSubMajorHead>budSubMajorHeadList= new ArrayList<BudSubMajorHead>();
List<BudMinorHead>budMinorHeadList= new ArrayList<BudMinorHead>();
List<BudMinorSubHead>budMinorSubHeadList= new ArrayList<BudMinorSubHead>();
List<BudObjectHead>budObjectHeadList= new ArrayList<BudObjectHead>();
List<HrMasFinancialYear>hrMasFinancialYearList= new ArrayList<HrMasFinancialYear>();
budVoucherHeader = session.createCriteria(BudVoucherHeader.class).add(Restrictions.eq("Id", trainingId)).list();
budVoucherHeaderFull=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherHeader");
budEstimateEntryListFul=getHibernateTemplate().find("from jkt.hms.masters.business.BudEstimateEntry");
budMajorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMajorHead");
budSubMajorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudSubMajorHead");
budMinorSubHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorSubHead");
budObjectHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudObjectHead");
hrMasFinancialYearList=getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear");
budMinorHeadList=getHibernateTemplate().find("from jkt.hms.masters.business.BudMinorHead");
map.put("budVoucherHeader",budVoucherHeader);
map.put("budVoucherHeaderFull",budVoucherHeaderFull);    
map.put("budEstimateEntryListFul",budEstimateEntryListFul);
map.put("budMajorHeadList",budMajorHeadList);
map.put("budSubMajorHeadList",budSubMajorHeadList);
map.put("budMinorSubHeadList",budMinorSubHeadList);
map.put("budObjectHeadList",budObjectHeadList);
map.put("hrMasFinancialYearList",hrMasFinancialYearList);
map.put("budMinorHeadList", budMinorHeadList);
return map;
}


@Override
public Map<String, Object> showVoucherReportJsp() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudVoucherHeader>budVoucherHeadersList=new ArrayList<BudVoucherHeader>();
//	=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherHeader");
	budVoucherHeadersList = session.createCriteria(BudVoucherHeader.class).list();
	
	map.put("budVoucherHeadersList", budVoucherHeadersList);	
	return map ;
}
@SuppressWarnings("unchecked")
public Map<String, Object> showAdviceJsp() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudVoucherHeader>budVoucherHeadersList=new ArrayList<BudVoucherHeader>();
//	=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherHeader");
	budVoucherHeadersList = session.createCriteria(BudVoucherHeader.class).list();
	
	map.put("budVoucherHeadersList", budVoucherHeadersList);	
	return map ;
}
@SuppressWarnings("unchecked")
public Map<String, Object> showDetailMonthlyExpenditure() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudEstimateEntry>budVoucherHeadersList=new ArrayList<BudEstimateEntry>();
	List<BudMinorHead>budMinorHeadList=new ArrayList<BudMinorHead>();
//	=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherHeader");
	budVoucherHeadersList =session.createCriteria(BudEstimateEntry.class).list();

	budMinorHeadList=session.createCriteria(BudMinorHead.class).list();
	
	map.put("budVoucherHeadersList", budVoucherHeadersList);	
	map.put("budMinorHeadList", budMinorHeadList);
	return map ;
}
@SuppressWarnings("unchecked")
public Map<String, Object> showApproprationRegister() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudVoucherHeader>budVoucherHeadersList=new ArrayList<BudVoucherHeader>();
	//List<BudMinorHead>budMinorHeadList=new ArrayList<BudMinorHead>();
//	=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherHeader");
	budVoucherHeadersList = session.createCriteria(BudVoucherHeader.class)
	.list();

	//budMinorHeadList=session.createCriteria(BudMinorHead.class).list();
	
	map.put("budVoucherHeadersList", budVoucherHeadersList);	
	//map.put("budMinorHeadList", budMinorHeadList);
	return map ;
}
@SuppressWarnings("unchecked")
public Map<String, Object> showoMnthlyObjectWiseExpenditure() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudEstimateEntry>budEstimateEntryList=new ArrayList<BudEstimateEntry>();
	budEstimateEntryList=session.createCriteria(BudEstimateEntry.class).list();
	
	map.put("budEstimateEntryList", budEstimateEntryList);
		return map ;
}


@Override
public Map<String, Object> showoMnthlyMinorWiseExpenditure() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudEstimateEntry>budEstimateEntryList=new ArrayList<BudEstimateEntry>();
	budEstimateEntryList=session.createCriteria(BudEstimateEntry.class).list();
	
	map.put("budEstimateEntryList", budEstimateEntryList);
		return map ;
}
public Map<String, Object> showoReceiptVoucher() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<BudEstimateEntry>budEstimateEntryList=new ArrayList<BudEstimateEntry>();
	budEstimateEntryList=session.createCriteria(BudEstimateEntry.class).list();
	
	map.put("budEstimateEntryList", budEstimateEntryList);
		return map ;
}
public Map<String, Object> printVoucherReceipt(	Map<String, Object> requestParameters) {
Map<String, Object> map = new HashMap<String, Object>();
List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
Session session = (Session) getSession();
int objectId=0;
if(requestParameters.get("objectId")!=null){
	objectId=(Integer)requestParameters.get("objectId");
}
try{
	String fromDate = (String) requestParameters.get("date1");
	String toDate = (String) requestParameters.get("date2");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
	String date4MySQL1 = formatterOut.format(formatterIn
			.parse(fromDate));
	String date4MySQL2 = formatterOut.format(formatterIn.parse(toDate));
	java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
	java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);
	java.sql.Connection con =(Connection) requestParameters.get("connection");
	String sql="";

		sql = "{call bud_estimate_entry_procedure('" + startDate+ "','"
		+ endDate + "'," + objectId+ ")}";
	
	map.put("startDate", startDate);
	map.put("endDate", endDate);
	map.put("objectId", objectId);

	try {
		if(sql!=""){
			CallableStatement cals = con.prepareCall(sql);
			cals.execute();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (RuntimeException e) {
		e.printStackTrace();
	}
}catch (Exception e) {
	// TODO: handle exception
}
map.put("objectId", objectId);
return map;
}


@SuppressWarnings("unchecked")
@Override
public List<BudVoucherReceiptEntry> getReceiptNumberList() {
	Session session = (Session) getSession();
	List<BudVoucherReceiptEntry> budVoucherReceiptEntryList = session.createCriteria(BudVoucherReceiptEntry.class)
			.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("Id"))
			.list();
	return budVoucherReceiptEntryList;
}


@Override
public Map<String, Object> showPrintVoucherReport() {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	List<BudVoucherHeader>budVoucherHeaderList=new ArrayList<BudVoucherHeader>();
	budVoucherHeaderList=getHibernateTemplate().find("from jkt.hms.masters.business.BudVoucherHeader");
	
	map.put("budVoucherHeaderList", budVoucherHeaderList);
		return map ;

}
}

