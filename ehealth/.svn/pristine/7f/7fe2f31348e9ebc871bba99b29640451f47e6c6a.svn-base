package jkt.hms.account.dataservice;

import static jkt.hms.util.RequestConstants.ACCOUNT_GROUP_ID;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_ID;
import static jkt.hms.util.RequestConstants.ACCOUNT_NAME;
import static jkt.hms.util.RequestConstants.ACCOUNT_NARRATION;
import static jkt.hms.util.RequestConstants.ACCOUNT_NARRATION_BANK;
import static jkt.hms.util.RequestConstants.ACCOUNT_SUB_GROUP_ID;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.AMOUNT_BANK;
import static jkt.hms.util.RequestConstants.BANK_ACCOUNT;
import static jkt.hms.util.RequestConstants.BANK_NAME;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHEQUE_DATE;
import static jkt.hms.util.RequestConstants.CHEQUE_NO;
import static jkt.hms.util.RequestConstants.COST_CENTER_ID;
import static jkt.hms.util.RequestConstants.CR_AMOUNT;
import static jkt.hms.util.RequestConstants.DR_AMOUNT;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.NARRATION;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SUB_LDEGER_NAME;
import static jkt.hms.util.RequestConstants.SUB_LEDGER_CODE;
import static jkt.hms.util.RequestConstants.SUB_LEDGER_CODE_BANK;
import static jkt.hms.util.RequestConstants.SUB_LEDGER_ID;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.TOTAL_CR_AMOUNT;
import static jkt.hms.util.RequestConstants.TOTAL_DR_AMOUNT;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.VOUCHER_DATE;
import static jkt.hms.util.RequestConstants.VOUCHER_DT_ID;
import static jkt.hms.util.RequestConstants.VOUCHER_HD_ID;
import static jkt.hms.util.RequestConstants.SUBLEDGER_ID;
import static jkt.hms.util.RequestConstants.OPENING_DATE;
import static jkt.hms.util.RequestConstants.OPENING_BALANCE;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.PAYMENT_MODE;
import static jkt.hms.util.RequestConstants.CLEAR_DATE;
import static jkt.hms.util.RequestConstants.BALANCE_TYPE;
import static jkt.hms.util.RequestConstants.COMPANY_BALANCE;
import static jkt.hms.util.RequestConstants.CHEQUE_STATUS;
import static jkt.hms.util.RequestConstants.VOUCHER_TYPE;
import static jkt.hms.util.RequestConstants.AS_ON_DATE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import jkt.hms.masters.business.AccountGroupTransac;
import jkt.hms.masters.business.AccountMainTransac;
import jkt.hms.masters.business.AccountSubGroupTransac;
import jkt.hms.masters.business.AccountSubLedTransac;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlPaymentAdviceHeader;
import jkt.hms.masters.business.BlPymntAdviceDispHeader;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.BlRefundHeader;
import jkt.hms.masters.business.FaAccountHospitalTypeMapping;
import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.FaAccountHospitalTypeMapping;
import jkt.hms.masters.business.FaAccountOpening;
import jkt.hms.masters.business.FaAccountParameter;
import jkt.hms.masters.business.FaBankReconciliationDetails;
import jkt.hms.masters.business.FaBankReconciliationHeader;
import jkt.hms.masters.business.FaBranchAccountMaster;
import jkt.hms.masters.business.FaEmdRegister;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasAccountGroup;
import jkt.hms.masters.business.FaMasAccountSubGroup;
import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.FaSchemeAccountMapping;
import jkt.hms.masters.business.FaSchemeSanctionAmount;
import jkt.hms.masters.business.FaVoucherDetails;
import jkt.hms.masters.business.FaVoucherHeader;
import jkt.hms.masters.business.HrInstituteAuthLevel;
import jkt.hms.masters.business.MasAccountSchedule;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBranch;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.FaSchemeWiseFundAllocate;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.ViewData;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.HrMasFinancialYear;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class AccountDataServiceImpl extends HibernateDaoSupport implements
		AccountDataService {

	/**
	 * --------------------------- Method Start from here
	 * -----------------------------------
	 *
	 */



	//--------------------------------Code by anamika----------------------------------------------------------------//
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountsGroupMasterJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> faMasAccountGroupList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		int fYear = 0;
		int locationId = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class)
				//.add(Restrictions.eq("Status", "y"))
								//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))								
								.list();
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountGroupBalance(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> faMasAccountGroupList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
									.add(Restrictions.eq("Status", "y"))
										.list();
		int financialYearId = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				financialYearId = financialYear.getId();
			}
		}
		int branchId  = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		String qry = "select ma.account_group_id,ma.account_group_code,ma.account_group_desc," +
						" sum(isnull(v.dr_amount,0))as dr_amount ,sum(isnull(v.cr_amount,0))as cr_amount," +
						" sum(isnull(v.opening_amt_cr,0))as opening_amt_cr,sum(isnull(v.opening_amt_dr,0))as opening_amt_dr," +
						" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))as TotalDr, " +
						" (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) as TotalCR," +
						" DrBalance=case when (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) > " +
						" (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) then " +
						"(sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))" +
						" - (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) end," +
						" CrBalance=case when (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0)))" +
						"  > (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))then " +
						"(sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) - " +
						"(sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) else 0 end, v.branch_id,v.f_year_id  from vwFinalAccountsBalance v " +
						" right outer join fa_mas_account_group ma on v.account_group_id= ma.account_group_id  " +
						" where v.branch_id = "+branchId+" and v.f_year_id = "+financialYearId+" group by ma.account_group_id,ma.account_group_code,ma.account_group_desc " +
						",v.branch_id,v.f_year_id";
		faMasAccountGroupList =session.createSQLQuery(qry).list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountGroup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = getSession();
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);

		crit = session.createCriteria(FaMasAccountGroup.class);
					
		if (searchRadio == 1) {
			crit = crit.add(Restrictions.eq("AccountGroupCode", Integer.parseInt(searchField)));

		} else {
			crit = crit.add(Restrictions.ilike("AccountGroupDesc", searchField+"%"));
		}

		faMasAccountGroupList = crit.add(Restrictions.eq("Status", "y"))
								.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
									.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountMasterJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<MasBankMaster> bankMasterList = new ArrayList<MasBankMaster>();
		Session session = (Session)getSession();
		/*List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.eq("Status", "y"))
									.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}*/
	/*	int branchId  = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}*/
		int accountSubGroupId =0;
		if(generalMap.get("accountSubGroupId") != null){
			accountSubGroupId = (Integer)generalMap.get("accountSubGroupId");
		}
		
		int fYear = 0;
		if(generalMap.get("fYear") != null){
			fYear = (Integer)generalMap.get("fYear");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId") != null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		System.out.println("hospitalId=="+hospitalId);
		System.out.println("fYear=="+fYear);
		accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		if(accountSubGroupId != 0){
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("AccountSubGroup.Id", accountSubGroupId))
									.addOrder(Order.asc("AccCode")).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("FYear.Id", fYear)).list();
		}else{
			accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
								.addOrder(Order.asc("AccCode")).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("FYear.Id", fYear)).list();
		}
		System.out.println("accountList=="+accountList.size());
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		bankMasterList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		map.put("accountSubGroupList", accountSubGroupList);
		map.put("accountList", accountList);
		map.put("accountGroupList", accountGroupList);
		map.put("accountList", accountList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountMasterBalance(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountListForBalance = new ArrayList<FaMasAccount>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		int branchId = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.eq("Status", "y"))
									.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}
		String qry = "select ma.acc_id,ma.acc_code,ma.acc_desc, " +
		" sum(isnull(v.dr_amount,0))as dr_amount ,sum(isnull(v.cr_amount,0))as cr_amount, " +
		" sum(isnull(v.opening_amt_cr,0))as opening_amt_cr,sum(isnull(v.opening_amt_dr,0))as opening_amt_dr, " +
		" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))as TotalDr, " +
		" (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) as TotalCR, " +
		" DrBalance=case when (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
		" > (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
		" then (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
		" - (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) end, " +
		" CrBalance=case when (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) > " +
		" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
		" then (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
		" - (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
		" else 0 end, v.branch_id,v.f_year_id  from vwFinalAccountsBalance v " +
		" right outer join fa_mas_account ma on v.account_id= ma.acc_id  " +
		" where v.branch_id = "+branchId+" and v.f_year_id = "+fYear+"  group by ma.acc_id,ma.acc_code,ma.acc_desc ,v.branch_id,v.f_year_id";

		accountListForBalance =session.createSQLQuery(qry).list();
		map.put("accountListForBalance", accountListForBalance);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getAccCodeForAccSubGrp(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<Integer> maxAccIdList = new ArrayList<Integer>();
		List<Integer> accCodeList = new ArrayList<Integer>();
		Session session = getSession();
		int accSubGrpId = box.getInt(ACCOUNT_SUB_GROUP_ID);
		Integer subGrpCode = box.getInt("subGrpCode");
		maxAccIdList = session.createCriteria(FaMasAccount.class)
						.createAlias("AccountSubGroup", "subGrp").add(Restrictions.eq("subGrp.Id", accSubGrpId))
						.setProjection(Projections.max("Id"))
						.list();

		int maxAccId = 0;
		Integer accCode = 0;
		if(maxAccIdList.size() > 0 && maxAccIdList.get(0)!= null){
			maxAccId = maxAccIdList.get(0);

			accCodeList = session.createCriteria(FaMasAccount.class)
							.add(Restrictions.idEq(maxAccId))
							.setProjection(Projections.property("AccCode")).list();
			if(accCodeList.size() > 0){
				accCode = Integer.parseInt(accCodeList.get(0).toString())+1;
			}

		}else{

			String acccodestr = "";
			acccodestr =  subGrpCode.toString().concat("01");
			accCode = Integer.parseInt(acccodestr);

		}
		map.put("accCode", accCode);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addAccountMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> existingAccountList = new ArrayList<FaMasAccount>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int  financialYearId = 0;
		int locationId = 0;
		String message = "";
		try {
			FaMasAccount faMasAccount = new FaMasAccount();
			if(generalMap.get("faMasAccount")!= null){
				faMasAccount = (FaMasAccount)generalMap.get("faMasAccount");
			}
			
			Box box =null;
			if(generalMap.get("box")!= null){
				box = (Box)generalMap.get("box");
			}
			Integer accountCode = faMasAccount.getAccCode();
			String accountName = faMasAccount.getAccDesc();
			
			if(generalMap.get("fYear")!= null){
				financialYearId =(Integer)generalMap.get("fYear");
			}
			if(generalMap.get("locationId")!= null){
				locationId =(Integer)generalMap.get("locationId");
			}
			int accountId = 0;
			if(generalMap.get("accountId")!= null){
				accountId = (Integer)generalMap.get("accountId");
			}
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			int subGroupId =0;
			if(generalMap.get("accountSubGroupId")!= null){
				subGroupId = (Integer)generalMap.get("accountSubGroupId");
			}
			List hospitalTypeAccountList = new ArrayList();
			if(generalMap.get("hospitalTypeAccountList")!= null){
				hospitalTypeAccountList = (List)generalMap.get("hospitalTypeAccountList");
			}
			System.out.println("hospitalTypeAccountList=11111111111111=="+hospitalTypeAccountList.size());
			BigDecimal openingBalanceDr = new BigDecimal(0);
			BigDecimal openingBalanceCr = new BigDecimal(0);
			if(generalMap.get("opDrBalance")!= null){
				openingBalanceDr =(BigDecimal)generalMap.get("opDrBalance");
			}else if(generalMap.get("opCrBalance")!= null){
				openingBalanceCr =(BigDecimal)generalMap.get("opCrBalance");
			}
			existingAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccCode", accountCode))
									//.add(Restrictions.eq("FYear.Id", financialYearId))
									.list();
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			} else {
				
				hbt.save(faMasAccount);
				if(hospitalTypeAccountList.size()>0){
					for(int i=0;i<hospitalTypeAccountList.size();i++){
						FaAccountHospitalTypeMapping accountHospitalTypeMapping = new FaAccountHospitalTypeMapping();
						FaMasAccount acc = new FaMasAccount();
						//System.out.println("accountId==22222222222========"+accountId);
						//acc.setId(groupId);
						accountHospitalTypeMapping.setAccount(faMasAccount);
						MasHospitalType hospitalType = new MasHospitalType();
						hospitalType.setId(Integer.parseInt(hospitalTypeAccountList.get(i).toString()));
						accountHospitalTypeMapping.setHospitalType(hospitalType);
						accountHospitalTypeMapping.setStatus("y");
						hbt.save(accountHospitalTypeMapping);
						
					 }
				}
				
				message = "Record saved sucessfully!";

//-----------------------For Branch Account master------------------------------------------
		//---------commented by anamika on 10/08/2014----------------
				/*int count = 0;
				if(box.getInt("totalBranchId")!= 0){
					count = box.getInt("totalBranchId");
				}
				for (int i = 1; i <= count; i++) {
					FaBranchAccountMaster branchAccountMaster = new FaBranchAccountMaster();
					if(box.getInt("branchId"+i)!=0 ){
						MasBranch masBranch = new MasBranch();
						masBranch.setId(box.getInt("branchId"+i));
						branchAccountMaster.setBranch(masBranch);
						branchAccountMaster.setAccount(faMasAccount);

						if(!box.getString("opBalanceDr"+i).equals("") ){
							branchAccountMaster.setOpBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
							branchAccountMaster.setClBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
						}else if(!box.getString("opBalanceCr"+i).equals("")){
							branchAccountMaster.setOpBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
							branchAccountMaster.setClBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
						}
						hbt.save(branchAccountMaster);

					}
				}*/

			//----------------update account group--------------
			/*BigDecimal groupClBalanceDr = new BigDecimal(0);
			BigDecimal groupClBalanceCr = new BigDecimal(0);

			 FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
			 if(faMasAccountGroup.getClBalanceDr() != null)
				 groupClBalanceDr =  faMasAccountGroup.getClBalanceDr();
			 if(faMasAccountGroup.getClBalanceCr() != null)
				 groupClBalanceCr = faMasAccountGroup.getClBalanceCr();

			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(groupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
				 	 if(groupClBalanceCr.compareTo(openingBalanceDr) > 0 ){
						  groupClBalanceCr = groupClBalanceCr.subtract(openingBalanceDr);
						  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
						  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr) > 0 ){
				 		 groupClBalanceDr =openingBalanceDr.subtract(groupClBalanceCr);
				 		 faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 		}else if(groupClBalanceDr.compareTo(openingBalanceCr)==0){
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr)==0 ){
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }
				 }else {
						  groupClBalanceDr = groupClBalanceDr.add(openingBalanceDr);
						  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					  }

			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				if(groupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
				  if(groupClBalanceDr.compareTo(openingBalanceCr) > 0){
					  
					  groupClBalanceDr =groupClBalanceDr.subtract(openingBalanceCr);
					  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupClBalanceDr) > 0 ){
				 		 groupClBalanceCr =openingBalanceCr.subtract(groupClBalanceDr);
				 		 faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupClBalanceDr) == 0 ){
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }
				}else{
					  
					  groupClBalanceCr = groupClBalanceCr.add(openingBalanceCr);
					  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
				  }
			}
			
//-----------------------------------opening Balance--------------------------------------//
			 BigDecimal groupOpBalanceDr = new BigDecimal(0);
				BigDecimal groupOPBalanceCr = new BigDecimal(0);

				 if(faMasAccountGroup.getOpBalanceDr() != null)
					 groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				 if(faMasAccountGroup.getOpBalanceCr() != null)
					 groupOPBalanceCr = faMasAccountGroup.getOpBalanceCr();
			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(groupOPBalanceCr.compareTo(new BigDecimal(0)) > 0){
				 	 if(groupOPBalanceCr.compareTo(openingBalanceDr) > 0 ){
				 		groupOPBalanceCr = groupOPBalanceCr.subtract(openingBalanceDr);
						  faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
						  faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupOPBalanceCr) > 0 ){
				 		groupOpBalanceDr =openingBalanceDr.subtract(groupOPBalanceCr);
				 		 faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
				 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupOPBalanceCr)== 0 ){
					 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
					 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
					 	 }
				 }else {
					 groupOpBalanceDr = groupOpBalanceDr.add(openingBalanceDr);
						  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
					  }

			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				if(groupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
				  if(groupOpBalanceDr.compareTo(openingBalanceCr) > 0){
					  
					  groupOpBalanceDr =groupOpBalanceDr.subtract(openingBalanceCr);
					  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
					  faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupOpBalanceDr) > 0 ){
					 
					  groupOPBalanceCr =openingBalanceCr.subtract(groupOpBalanceDr);
				 		 faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
				 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceCr.compareTo(groupOpBalanceDr) == 0 ){
				 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }
				}else{
					
					groupOPBalanceCr = groupOPBalanceCr.add(openingBalanceCr);
					  faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
				  }
			}
			hbt.update(faMasAccountGroup);

				//--------------------------------------------update subGroup group--------------
				BigDecimal subGroupClBalanceDr = new BigDecimal(0);
				BigDecimal subGroupClBalanceCr = new BigDecimal(0);

				FaMasAccountSubGroup faMasAccountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				if(faMasAccountSubGroup.getClBalanceDr() != null)
					subGroupClBalanceDr =  faMasAccountSubGroup.getClBalanceDr();
				if(faMasAccountSubGroup.getClBalanceCr() != null)
					subGroupClBalanceCr = faMasAccountSubGroup.getClBalanceCr();


				 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(subGroupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupClBalanceCr.compareTo(openingBalanceDr) > 0){
					 		 subGroupClBalanceDr = subGroupClBalanceCr.subtract(openingBalanceDr);
					 		 faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceDr);
					 		 faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr) > 0 ){
					 		subGroupClBalanceDr =openingBalanceDr.subtract(subGroupClBalanceCr);
					 		faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
					 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr)== 0 ){
						 		faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						 	 }
					 }else{

						  subGroupClBalanceDr = subGroupClBalanceDr.add(openingBalanceDr);
						  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
					  }
				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					 if(subGroupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupClBalanceDr.compareTo(openingBalanceCr) > 0){

							  subGroupClBalanceCr = subGroupClBalanceDr.subtract(openingBalanceCr);
							  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceCr);
							  faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) > 0 ){
							  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
							  	faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
							  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) == 0 ){
								  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
								  	faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
								  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
							 	 }
					 }
					 else{
						  subGroupClBalanceCr = subGroupClBalanceCr.add(openingBalanceCr);
						  faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
					  }
				}
//--------------------------opening Balance------------------------------------------//
				 BigDecimal subGroupOpBalanceDr = new BigDecimal(0);
					BigDecimal subGroupOpBalanceCr = new BigDecimal(0);

					if(faMasAccountSubGroup.getOpBalanceDr() != null)
						subGroupOpBalanceDr =  faMasAccountSubGroup.getOpBalanceDr();
					if(faMasAccountSubGroup.getOpBalanceCr() != null)
						subGroupOpBalanceCr = faMasAccountSubGroup.getOpBalanceCr();


					 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(subGroupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupOpBalanceCr.compareTo(openingBalanceDr) > 0){
								 subGroupOpBalanceDr = subGroupOpBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceDr);
						 		 faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr) > 0 ){
						 		subGroupOpBalanceDr =openingBalanceDr.subtract(subGroupOpBalanceCr);
						 		faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
						 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr)== 0 ){
							 		faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
							 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
							 	 }
						 }else{

							 subGroupOpBalanceDr = subGroupOpBalanceDr.add(openingBalanceDr);
							  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(subGroupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupOpBalanceDr.compareTo(openingBalanceCr) > 0){

								 subGroupOpBalanceCr = subGroupOpBalanceDr.subtract(openingBalanceCr);
								  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceCr);
								  faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) > 0 ){
								  subGroupOpBalanceCr =openingBalanceCr.subtract(subGroupOpBalanceDr);
								  	faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
								  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
							 	 }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) == 0 ){
									  	faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
									  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
								 	 }
						 }
						 else{
							 subGroupOpBalanceCr = subGroupOpBalanceCr.add(openingBalanceCr);
							  faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
						  }
					}

			 	hbt.update(faMasAccountSubGroup);
			}*/}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		
		faMasAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
								.list();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		gridMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		hospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("faMasAccountList",faMasAccountList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		map.put("message", message);
		map.put("hospitalTypeList", hospitalTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editAccountMaster(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountIdList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session)getSession();
		accountIdList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(box.getInt("accountId"))).list();
		accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
									.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		accountList = session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AccCode")).list();
		map.put("accountSubGroupList", accountSubGroupList);
		map.put("accountGroupList", accountGroupList);
		map.put("accountList", accountList);
		map.put("accountIdList", accountIdList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateAccountMaster(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> existingAccountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			existingAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccDesc", box.getString(ACCOUNT_NAME))).add(Restrictions.ne("Id", box.getInt("accountId"))).list();
			
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			} else {

			FaMasAccount faMasAccount = (FaMasAccount) hbt.load(FaMasAccount.class,box.getInt("accountId"));
			faMasAccount.setAccDesc(box.getString(ACCOUNT_NAME));
			
			FaMasAccountSubGroup faMasAccountSubGroup1 = new FaMasAccountSubGroup();
			faMasAccountSubGroup1.setId(box.getInt(ACCOUNT_SUB_GROUP_ID));
			faMasAccount.setAccountSubGroup(faMasAccountSubGroup1);
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faMasAccount.setFYear(masStoreFinancial);
			if(box.getString("parentStatus")!= null){
				faMasAccount.setParentStatus("y");
			}else{
				faMasAccount.setParentStatus("n");
			}
			if(box.getString("subLedgerStatus")!= null){
				faMasAccount.setSubLedger("y");
			}else{
				faMasAccount.setSubLedger("n");
			}
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(box.getInt(ACCOUNT_ID));
			faMasAccount.setParent(masAccount);
			BigDecimal opBalanceDr = new BigDecimal(0.0);
			BigDecimal opBalanceCr = new BigDecimal(0.0);
			if(box.getString("accountTypeA").equals("Dr")){
				faMasAccount.setOpBalanceDr(new BigDecimal(box.getString("openingBalance")));
				faMasAccount.setOpBalanceCr(new BigDecimal(0.0));
				faMasAccount.setClBalanceDr(new BigDecimal(box.getString("openingBalance")));
				faMasAccount.setClBalanceCr(new BigDecimal(0.0));
				opBalanceDr = new BigDecimal(box.getString("openingBalance"));
			}else if(box.getString("accountTypeA").equals("Cr")){
				faMasAccount.setOpBalanceCr(new BigDecimal(box.getString("openingBalance")));
				faMasAccount.setClBalanceCr(new BigDecimal(box.getString("openingBalance")));
				faMasAccount.setOpBalanceDr(new BigDecimal(0.0));
				faMasAccount.setClBalanceDr(new BigDecimal(0.0));
				opBalanceCr = new BigDecimal(box.getString("openingBalance"));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			faMasAccount.setLastChgBy(user);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faMasAccount.setHospital(masHospital);
			
			faMasAccount.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faMasAccount.setLastChgTime(box.getString(CHANGED_TIME));
			hbt.update(faMasAccount);
			message = "Record update sucessfully!";
//----------------------------------------------calculation for last Balance---------------------------------
			BigDecimal lastOpeningDrBalance = new BigDecimal(0.0);
			BigDecimal lastOpeningCrBalance = new BigDecimal(0.0);
			BigDecimal openingBalanceDr = new BigDecimal(0.0);
			BigDecimal openingBalanceCr = new BigDecimal(0.0);
			
			if(!box.getString("lastOpeningBalanceDr").equals("") ){
				lastOpeningDrBalance = new BigDecimal(box.getString("lastOpeningBalanceDr"));
			}else if(!box.getString("lastOpeningBalanceCr").equals("")){
				lastOpeningCrBalance = new BigDecimal(box.getString("lastOpeningBalanceCr"));
			}
			
			
			 if(opBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(lastOpeningCrBalance.compareTo(new BigDecimal(0)) > 0){
				 	 if(lastOpeningCrBalance.compareTo(opBalanceDr) > 0 ){
				 		openingBalanceCr = lastOpeningCrBalance.subtract(opBalanceDr);
				 	 	}else if(opBalanceDr.compareTo(lastOpeningCrBalance) > 0 ){
				 	 		openingBalanceDr =opBalanceDr.subtract(lastOpeningCrBalance);
				 	 	}
				 	 }else if(lastOpeningDrBalance.compareTo(new BigDecimal(0)) > 0) {
				 		 if(opBalanceDr.compareTo(lastOpeningDrBalance)>0){
				 			 openingBalanceDr = opBalanceDr.subtract(lastOpeningDrBalance);
				 		 }else if(lastOpeningDrBalance.compareTo(opBalanceDr)>0){
				 			 
				 			openingBalanceCr = lastOpeningDrBalance.subtract(opBalanceDr);
				 		 }
					  }
				
			 }else if(opBalanceCr.compareTo(new BigDecimal(0))>0){
					if(lastOpeningDrBalance.compareTo(new BigDecimal(0)) > 0){
					  if(lastOpeningDrBalance.compareTo(opBalanceCr) > 0){
						  openingBalanceDr =lastOpeningDrBalance.subtract(opBalanceCr);
					  	}else if(opBalanceCr.compareTo(lastOpeningDrBalance) > 0 ){
						  	openingBalanceCr =opBalanceCr.subtract(lastOpeningDrBalance);
					 	 }
					}else{
						  
						openingBalanceCr = lastOpeningCrBalance.subtract(opBalanceCr);
						if(opBalanceCr.compareTo(lastOpeningCrBalance)>0){
							openingBalanceCr = opBalanceCr.subtract(lastOpeningCrBalance);
				 		 }else if(lastOpeningCrBalance.compareTo(opBalanceCr)>0){
				 			openingBalanceDr = lastOpeningCrBalance.subtract(opBalanceCr);
				 		 }
						
				  }
			 }
//-----------------------------------------------update account group------------------------------------
			BigDecimal groupClBalanceDr = new BigDecimal(0);
			BigDecimal groupClBalanceCr = new BigDecimal(0);

			 FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt(ACCOUNT_GROUP_ID));
			 if(faMasAccountGroup.getClBalanceDr() != null)
				 groupClBalanceDr =  faMasAccountGroup.getClBalanceDr();
			 if(faMasAccountGroup.getClBalanceCr() != null)
				 groupClBalanceCr = faMasAccountGroup.getClBalanceCr();

			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(groupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
				 	 if(groupClBalanceCr.compareTo(openingBalanceDr) > 0 ){
						  groupClBalanceCr = groupClBalanceCr.subtract(openingBalanceDr);
						  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
						  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr) > 0 ){
				 		 groupClBalanceDr =openingBalanceDr.subtract(groupClBalanceCr);
				 		 faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
				 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }
				 }else {
						  groupClBalanceDr = groupClBalanceDr.add(openingBalanceDr);
						  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					  }

			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				if(groupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
				  if(groupClBalanceDr.compareTo(openingBalanceCr) > 0){
					  
					  groupClBalanceDr =groupClBalanceDr.subtract(openingBalanceCr);
					  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
					  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupClBalanceDr) > 0 ){
					
				 		 groupClBalanceCr =openingBalanceCr.subtract(groupClBalanceDr);
				 		 faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
				 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				 	 }
				}else{
					  
					  groupClBalanceCr = groupClBalanceCr.add(openingBalanceCr);
					  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
				  }
			}
			
//-----------------------------------opening Balance--------------------------------------//
			 BigDecimal groupOpBalanceDr = new BigDecimal(0);
				BigDecimal groupOPBalanceCr = new BigDecimal(0);

				 if(faMasAccountGroup.getOpBalanceDr() != null)
					 groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				 if(faMasAccountGroup.getOpBalanceCr() != null)
					 groupOPBalanceCr = faMasAccountGroup.getOpBalanceCr();
			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(groupOPBalanceCr.compareTo(new BigDecimal(0)) > 0){
				 	 if(groupOPBalanceCr.compareTo(openingBalanceDr) > 0 ){
				 		groupOPBalanceCr = groupOPBalanceCr.subtract(openingBalanceDr);
						  faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
						  faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(groupOPBalanceCr) > 0 ){
				 		groupOpBalanceDr =openingBalanceDr.subtract(groupOPBalanceCr);
				 		 faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
				 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				 	 }
				 }else {
					 groupOpBalanceDr = groupOpBalanceDr.add(openingBalanceDr);
						  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
					  }

			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				if(groupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
				  if(groupOpBalanceDr.compareTo(openingBalanceCr) > 0){
					  
					  groupOpBalanceDr =groupOpBalanceDr.subtract(openingBalanceCr);
					  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
					  faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
				  }else if(openingBalanceCr.compareTo(groupOpBalanceDr) > 0 ){
					 
					  groupOPBalanceCr =openingBalanceCr.subtract(groupOpBalanceDr);
				 		 faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
				 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
				 	 }
				}else{
					
					groupOPBalanceCr = groupOPBalanceCr.add(openingBalanceCr);
					  faMasAccountGroup.setOpBalanceCr(groupOPBalanceCr);
				  }
			}
			hbt.update(faMasAccountGroup);		
//--------------------------------------------update subGroup group--------------
			BigDecimal subGroupClBalanceDr = new BigDecimal(0);
			BigDecimal subGroupClBalanceCr = new BigDecimal(0);

			FaMasAccountSubGroup faMasAccountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt(ACCOUNT_SUB_GROUP_ID));
			if(faMasAccountSubGroup.getClBalanceDr() != null)
				subGroupClBalanceDr =  faMasAccountSubGroup.getClBalanceDr();
			if(faMasAccountSubGroup.getClBalanceCr() != null)
				subGroupClBalanceCr = faMasAccountSubGroup.getClBalanceCr();


			 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(subGroupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
					 if(subGroupClBalanceCr.compareTo(openingBalanceDr) > 0){
				 		 subGroupClBalanceDr = subGroupClBalanceCr.subtract(openingBalanceDr);
				 		 faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceDr);
				 		 faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
				 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr) > 0 ){
				 		subGroupClBalanceDr =openingBalanceDr.subtract(subGroupClBalanceCr);
				 		faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
				 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
				 	 }
				 }else{

					  subGroupClBalanceDr = subGroupClBalanceDr.add(openingBalanceDr);
					  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
				  }
			}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
				 if(subGroupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
					 if(subGroupClBalanceDr.compareTo(openingBalanceCr) > 0){

						  subGroupClBalanceCr = subGroupClBalanceDr.subtract(openingBalanceCr);
						  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceCr);
						  faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					  }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) > 0 ){
						  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
						  	faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
						  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					 	 }
				 }
				 else{
					  subGroupClBalanceCr = subGroupClBalanceCr.add(openingBalanceCr);
					  faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
				  }
			}
//--------------------------opening Balance------------------------------------------//
			 BigDecimal subGroupOpBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0);

				if(faMasAccountSubGroup.getOpBalanceDr() != null)
					subGroupOpBalanceDr =  faMasAccountSubGroup.getOpBalanceDr();
				if(faMasAccountSubGroup.getOpBalanceCr() != null)
					subGroupOpBalanceCr = faMasAccountSubGroup.getOpBalanceCr();


				 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
					 if(subGroupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupOpBalanceCr.compareTo(openingBalanceDr) > 0){
							 subGroupOpBalanceDr = subGroupOpBalanceCr.subtract(openingBalanceDr);
					 		 faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceDr);
					 		 faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
					 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr) > 0 ){
					 		subGroupOpBalanceDr =openingBalanceDr.subtract(subGroupOpBalanceCr);
					 		faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
					 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
					 	 }
					 }else{

						 subGroupOpBalanceDr = subGroupOpBalanceDr.add(openingBalanceDr);
						  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
					  }
				}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
					 if(subGroupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
						 if(subGroupOpBalanceDr.compareTo(openingBalanceCr) > 0){

							 subGroupOpBalanceCr = subGroupOpBalanceDr.subtract(openingBalanceCr);
							  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceCr);
							  faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) > 0 ){
							  subGroupOpBalanceCr =openingBalanceCr.subtract(subGroupOpBalanceDr);
							  	faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
							  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
						 	 }
					 }
					 else{
						 subGroupOpBalanceCr = subGroupOpBalanceCr.add(openingBalanceCr);
						  faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
					  }
				}

		 	hbt.update(faMasAccountSubGroup);
			
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
									.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
		accountList = session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AccCode")).list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).add(Restrictions.eq("Status", "y")).list();
	
		map.put("message", message);
		map.put("accountSubGroupList", accountSubGroupList);
		map.put("accountList", accountList);
		map.put("accountGroupList", accountGroupList);
		return map;
	}
			
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountMaster(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session = getSession();
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);

		crit = session.createCriteria(FaMasAccount.class);
	if (searchRadio == 1) {
			crit = crit.add(Restrictions.eq("AccCode", Integer.parseInt(searchField)));

		} else {
			crit = crit.add(Restrictions.ilike("AccDesc", searchField+"%"));
		}

		accountList = crit.list();
		map.put("faMasAccountList", accountList);
System.out.println("accountList.size()---------->>"+accountList.size());
		/*Map<String, Object> map = new HashMap<String, Object>();*/
		/*List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();*/
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		/*Session session = (Session)getSession();
		int fYear = 0;
		int locationId = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}*/
		/*faMasAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
				//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
				.list();*/
		int fYear=1;
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
								.list();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
				.list();
		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
				.list();
		gridMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
				.list();
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		//map.put("faMasAccountList",faMasAccountList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
	
	
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCashVoucherJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		Object[] selectedId = {"1","2"};
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
		.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
			.add(Restrictions.eq("Status", "y"))
				.list();
		int financialYearId = 0;
		String fYearDesc = "";
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				financialYearId = financialYear.getId();
				fYearDesc = financialYear.getYearDescription();
			}
		}
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "RV");
		paramMap.put("voucherType", "Reciept");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		accList = session.createCriteria(FaMasAccount.class)
					     .createAlias("AccountSubGroup", "subGroup")
					     .add(Restrictions.in("subGroup.Flag", selectedId))
					     .list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		

		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);
		
		
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		map.put("branchList", branchList);
		return map;
	}
	/*@SuppressWarnings("unchecked")
	public Map<String, Object> getFinancialYear(String voucherDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		Object[] selectedId = {"Bank A/C","Cash In Hand"};
		
		//String currentYear = voucherDate.substring(6, 10);
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(voucherDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(voucherDate)))
						.add(Restrictions.eq("Status", "y"))
						.list();
	
		int financialYearId = 0;
		String fYearDesc = "";
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				financialYearId = financialYear.getId();
				fYearDesc = financialYear.getYearDescription();
			}
		}
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "RV");
		paramMap.put("voucherType", "Reciept");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		accList = session.createCriteria(FaMasAccount.class)
					.add(Restrictions.eq("ParentStatus", "n")).add(Restrictions.eq("FYear.Id", financialYearId)).createAlias("AccountSubGroup", "subGroup")
						.add(Restrictions.or(Restrictions.eq("subGroup.AccountSubGroupName", "Bank A/C"),
						Restrictions.eq("subGroup.AccountSubGroupName", "Cash In Hand"))).list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		map.put("branchList", branchList);
		map.put("financialYearId", financialYearId);
		map.put("fYearDesc", fYearDesc);
		return map;
	}
*/

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAccountCodeForAutoComplete(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaAccountHospitalTypeMapping> accList = new ArrayList<FaAccountHospitalTypeMapping>();
		List<FaSchemeAccountMapping> accList1 = new ArrayList<FaSchemeAccountMapping>();
		String accountNameStr = "";
		int hospitalId=0;
		if(parameterMap.get("accountNameStr")!= null){
			accountNameStr = (String)parameterMap.get("accountNameStr");
		}
		if(parameterMap.get("locationId")!= null){
			hospitalId = (Integer)parameterMap.get("locationId");
		}
		System.out.println("hospitalId"+hospitalId);
		String amtType = "";
		if(parameterMap.get("amtType")!= null){
			amtType =(String)parameterMap.get("amtType");
		}
		int scheme=0;
		int hospitalTypeId=0;
		if(parameterMap.get("scheme")!= null){
			scheme =(Integer)parameterMap.get("scheme");
		}
		if(parameterMap.get("hospitalTypeId")!= null){
			hospitalTypeId =(Integer)parameterMap.get("hospitalTypeId");
		}
		
		System.out.println(hospitalTypeId+"<<<hospitalTypeId=====scheme==========>>>"+scheme);
		String voucherType = "";
		if(parameterMap.get("salesVoucherType")!= null){
			voucherType =(String)parameterMap.get("salesVoucherType");
		}
		/*int financialYearId = 0;
		if(parameterMap.get("financialYearId")!= null){
			financialYearId = (Integer)parameterMap.get("financialYearId");
		}*/
		
		
		Session session = (Session)getSession();
		
		//int hospitalTypeId=0;
		
		
		Criteria crit =null;
		if(scheme==0){
			System.out.println("when 0");
		crit=session.createCriteria(FaAccountHospitalTypeMapping.class)
				//.createAlias("HospitalType", "HospitalType").add(Restrictions.eq("HospitalType.Id", hospitalTypeId))
				.createAlias("Account", "Account")
				
				
				//createCriteria(FaMasAccount.class)
		//.add(Restrictions.eq("ParentStatus", "n")).add(Restrictions.eq("FYear.Id", financialYearId))
		.add(Restrictions.ilike("Account.AccDesc","%"+accountNameStr+"%"));
		
		/*if(voucherType.equals("salesReturn")){
			if(amtType.equals("cr")){
				crit = crit.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 20));
			}else{
				crit = crit.createAlias("AccountSubGroup", "subGroup");

			}
		}else if(voucherType.equals("purchase")){
			if(amtType.equals("dr")){
					crit = crit.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 23));
				}
		}else{
		if(amtType.equals("dr")){
				crit = crit.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 20));
			}else{
				crit = crit.createAlias("AccountSubGroup", "subGroup");

			}
		}*/
		Object[] jSelectedId = {1,2};
		Object[] salesSelectedId = {20,18,8};
		Object[] purchaseSelectedId = {23,15};
		if(voucherType.equals("journal")){
			crit = crit.createAlias("Account.AccountSubGroup", "subGroup").add(Restrictions.not(Restrictions.in("subGroup.Id", jSelectedId)));

			}else if(voucherType.equals("salesReturn") && voucherType.equals("sales")){
				
				crit = crit.createAlias("Account.AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", salesSelectedId));

			}else if(voucherType.equals("purchase") && voucherType.equals("purchaseReturn")){
				
				crit = crit.createAlias("Account.AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", purchaseSelectedId));

			}else{
				crit = crit.createAlias("Account.AccountSubGroup", "subGroup");
				
			}
		accList = crit.list();
		}else if(scheme!=0){
			System.out.println("when not 0");
			crit=session.createCriteria(FaSchemeAccountMapping.class)
					.createAlias("Scheme", "Scheme")
					.createAlias("Account", "Account")
					//.createAlias("Account.Hospital", "Hospital").add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Scheme.Id", scheme))
					
					//createCriteria(FaMasAccount.class)
			//.add(Restrictions.eq("ParentStatus", "n")).add(Restrictions.eq("FYear.Id", financialYearId))
			.add(Restrictions.ilike("Account.AccDesc",accountNameStr+"%"));
			
			/*if(voucherType.equals("salesReturn")){
				if(amtType.equals("cr")){
					crit = crit.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 20));
				}else{
					crit = crit.createAlias("AccountSubGroup", "subGroup");

				}
			}else if(voucherType.equals("purchase")){
				if(amtType.equals("dr")){
						crit = crit.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 23));
					}
			}else{
			if(amtType.equals("dr")){
					crit = crit.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 20));
				}else{
					crit = crit.createAlias("AccountSubGroup", "subGroup");

				}
			}*/
			Object[] jSelectedId = {1,2};
			Object[] salesSelectedId = {20,18,8};
			Object[] purchaseSelectedId = {23,15};
			if(voucherType.equals("journal")){
				crit = crit.createAlias("Account.AccountSubGroup", "subGroup").add(Restrictions.not(Restrictions.in("subGroup.Id", jSelectedId)));

				}else if(voucherType.equals("salesReturn") && voucherType.equals("sales")){
					
					crit = crit.createAlias("Account.AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", salesSelectedId));

				}else if(voucherType.equals("purchase") && voucherType.equals("purchaseReturn")){
					
					crit = crit.createAlias("Account.AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", purchaseSelectedId));

				}else{
					crit = crit.createAlias("Account.AccountSubGroup", "subGroup");
					
				}
			accList1=crit.list();
			}
		
			
		map.put("accList", accList);
		map.put("accList1",accList1);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSubLedgerForAccount(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasSubLed> subLedgerList = new ArrayList<FaMasSubLed>();
		List<FaMasAccount>accountIdList = new ArrayList<FaMasAccount>();
		/*List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		int financialYearId = 0;
		if(parameterMap.get("financialYearId")!= null){
			financialYearId = (Integer)parameterMap.get("financialYearId");
		}*/
		String accName = "";
		if(parameterMap.get("accountName")!= null){
			accName = (String)parameterMap.get("accountName");
		}
System.out.println("accName-------->>>>>"+accName);
		Session session = (Session)getSession();
		
		subLedgerList = session.createCriteria(FaMasSubLed.class).createAlias("Account", "acc")
								//.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", financialYearId))
								.add(Restrictions.eq("acc.AccCode",Integer.parseInt(accName)))
								
								//.add(Restrictions.eq("acc.SubLedger", "y"))
								.list();

		accountIdList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccCode", Integer.parseInt(accName))).list();
		int accountId = 0;
		int groupId = 0;
		int subGroupId = 0;
		BigDecimal closingBalance = new BigDecimal(0.0);
		if(accountIdList.size()>0){
			for(FaMasAccount faMasAccount :accountIdList){
				accountId = faMasAccount.getId();
				groupId = faMasAccount.getAccountSubGroup().getAccountGroup().getId();
				subGroupId = faMasAccount.getAccountSubGroup().getId();
				if(faMasAccount.getClBalanceCr()!= null){
					closingBalance = faMasAccount.getClBalanceCr();
				}else{
					closingBalance = faMasAccount.getClBalanceDr();
				}
			}
		}

		map.put("closingBalance", closingBalance);
		map.put("accountId", accountId);
		map.put("groupId", groupId);
		map.put("subGroupId", subGroupId);
		map.put("subLedgerList", subLedgerList);
		return map;
	}

	/*@SuppressWarnings("unchecked")
	public Map<String, Object> getNarrationForAutoComplete(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasNarration> voucherNarationList  = new ArrayList<FaMasNarration>();
		String narrationStr = "";
		if(parameterMap.get("narrationStr")!= null){
			narrationStr = (String)parameterMap.get("narrationStr");
		}

		Session session =  (Session)getSession();
		voucherNarationList = session.createCriteria(FaMasNarration.class).add(Restrictions.ilike("NarrationDesc",narrationStr+"%"))
					.list();
		map.put("voucherNarationList", voucherNarationList);
		return map;

	}

	public Map<String, Object> addVoucherNarration(FaMasNarration faMasNarration) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		boolean saved = false;
		String message = "";
		try {
			hbt.save(faMasNarration);
			saved = true;
			if(saved == true){
				message = "Narration saved";
			}else{
				message = "Some Problem Occured";
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("message", message);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountBalance(int accountId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session = (Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
		map.put("accountList", accountList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAccountNarrationForAutoComplete(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasNarration> voucherNarationList  = new ArrayList<FaMasNarration>();
		String accountNarration = "";
		if(parameterMap.get("accountNarration")!= null){
			accountNarration = (String)parameterMap.get("accountNarration");
		}

		Session session =  (Session)getSession();
		voucherNarationList = session.createCriteria(FaMasNarration.class).add(Restrictions.ilike("NarrationDesc",accountNarration+"%"))
					.list();
		map.put("voucherNarationList", voucherNarationList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitReceiptVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> maxAccountIdList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		
		int voucherNo = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int accountListLength = box.getInt("hiddenValueCharge");
		int accountListLengthForBank = box.getInt("hiddenValueChargeForBank");
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(box.getString(VOUCHER_DATE))))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(box.getString(VOUCHER_DATE))))
						.add(Restrictions.eq("Status", "y"))
						.list();
	
		int financialYearId = 0;
		String fYearDesc = "";
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				financialYearId = financialYear.getId();
				fYearDesc = financialYear.getYearDescription();
			}
		}
		
		try {
			tx = session.beginTransaction();
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("hospitalId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			//MasBranch masBranch = new MasBranch();
			//masBranch.setId( box.getInt("branchId"));
			//faVoucherHeader.setBranch(masBranch);
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("RV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
				faVoucherHeader.setCrAmount(totalAmountDr);
			}
			if (box.getInt(COST_CENTER_ID) != 0) {
				MasCostCenter masCostCenter = new MasCostCenter();
				masCostCenter.setId(box.getInt(COST_CENTER_ID));
				faVoucherHeader.setCostCenter(masCostCenter);
			}

			HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
			hrMasFinancialYear.setId(financialYearId);
			faVoucherHeader.setFYear(hrMasFinancialYear);
			paramMap.put("suffix", fYearDesc);
			paramMap.put("flag", "save");
			paramMap.put("prefix", "RV");
			paramMap.put("voucherType", "Reciept");
			voucherNo = generateVoucherNo(paramMap);
			faVoucherHeader.setVoucherNo(voucherNo);

			FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			faMasAccountSubGroup.setId(box.getInt("subGroupId"));
			faVoucherHeader.setAccountSubGroup(faMasAccountSubGroup);
			hbt.save(faVoucherHeader);
			

			FaVoucherDetails voucherDetails = new FaVoucherDetails();
			voucherDetails.setVoucherHeader(faVoucherHeader);
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt(ACCOUNT_ID));
				voucherDetails.setAccount(masAccount);
				voucherDetails.setDrAmount(totalAmountDr);
				voucherDetails.setNarration(box.getString(NARRATION));
//------------------------------code for account id report--------------------------------------
				if(accountListLength > 0){
					if (box.getInt("accountId1") != 0) {
						FaMasAccount account = new FaMasAccount();
						account.setId(box.getInt("accountId1") );
						voucherDetails.setAccountIdForReport(account);
					}

					if (box.getInt(SUB_LEDGER_CODE+"1") != 0) {
						FaMasSubLed subLed = new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE+"1"));
						voucherDetails.setSubLedIdForReport(subLed);
					}
				}
				//------------------------------code for Sub Ledger id report--------------------------------------
				if(accountListLengthForBank > 0){

					if (box.getInt("accountId1") != 0) {
						FaMasAccount account = new FaMasAccount();
						account.setId(box.getInt("accountId1") );
						voucherDetails.setAccountIdForReport(account);
					}

					if (box.getInt(SUB_LEDGER_CODE_BANK+"1") != 0) {
						FaMasSubLed subLed = new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+"1"));
						voucherDetails.setSubLedIdForReport(subLed);
					}
				}
				hbt.save(voucherDetails);
				//-------------------------update account group-------------------------------------------------
				BigDecimal groupOPBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				 FaMasAccountGroup faMasAccountGroup2 = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"));
				 	if(faMasAccountGroup2.getOpBalanceDr()!= null){
				 		groupOPBalanceDr =  faMasAccountGroup2.getOpBalanceDr();
				 	}
				 	if(faMasAccountGroup2.getOpBalanceCr()!= null){
				 		groupOpBalanceCr = faMasAccountGroup2.getOpBalanceCr();
				 	}
					if(faMasAccountGroup2.getYtdAmountDr()!= null){
						groupYtdBalanceDr = faMasAccountGroup2.getYtdAmountDr();
					}
					if(faMasAccountGroup2.getYtdAmountCr()!= null){
						groupYtdBalanceCr = faMasAccountGroup2.getYtdAmountCr();
					}
					if(totalAmountDr.compareTo(new BigDecimal(0))>0){
						groupYtdBalanceDr = groupYtdBalanceDr.add(totalAmountDr);
						 faMasAccountGroup2.setYtdAmountDr(groupYtdBalanceDr);
					 }
					crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					drGroupAmount = groupOPBalanceDr.add(groupYtdBalanceDr);

					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup2.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						faMasAccountGroup2.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup2.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						faMasAccountGroup2.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup2.setClBalanceCr(new BigDecimal(0.00));
						faMasAccountGroup2.setClBalanceDr(new BigDecimal(0.00));
					}
			 	hbt.update(faMasAccountGroup2);

			 	//-------------------------update account Sub group-------------------------------------------------
				BigDecimal subGroupOPBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

			 FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"));
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOpBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(totalAmountDr.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(totalAmountDr);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 crSubGroupAmount = subGroupOpBalanceCr.add(subGroupYtdBalanceCr);
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);

					if(drSubGroupAmount.compareTo(crSubGroupAmount)>0){
						accountSubGroup.setClBalanceDr(drSubGroupAmount.subtract(crSubGroupAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crSubGroupAmount.compareTo(drSubGroupAmount)>0){
						accountSubGroup.setClBalanceCr(crSubGroupAmount.subtract(drSubGroupAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crSubGroupAmount.compareTo(drSubGroupAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}
			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------
		 	BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
	 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
	 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
	 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
	 		BigDecimal drAccountAmount = new BigDecimal(0.0);
	 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
	 		FaMasAccount masAccount2 = (FaMasAccount)hbt.load(FaMasAccount.class, box.getInt(ACCOUNT_ID));

	 		if(masAccount2.getOpBalanceDr()!= null){
	 			accountOpBalanceDr =  masAccount2.getOpBalanceDr();
	 		}
	 		if(masAccount2.getOpBalanceCr()!= null){
	 			accountOpBalanceCr = masAccount2.getOpBalanceCr();
	 		}
	 		 if(masAccount2.getYtdAmountDr() != null){
	 			 accountYtdBalanceDr = masAccount2.getYtdAmountDr();
	 		 }
	 		 if(masAccount2.getYtdAmountCr() != null){
	 			accountYtdBalanceCr = masAccount2.getYtdAmountCr();
	 		 }
	 		if(totalAmountDr.compareTo(new BigDecimal(0))>0){
				 accountYtdBalanceDr = accountYtdBalanceDr.add(totalAmountDr);
				 masAccount2.setYtdAmountDr(accountYtdBalanceDr);
			 }
	 		crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
	 		drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				if(drAccountAmount.compareTo(crAccountAmount)>0){
					masAccount2.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
					masAccount2.setClBalanceCr(new BigDecimal(0.00));
				}else if(crAccountAmount.compareTo(drAccountAmount)>0){
					masAccount2.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
					masAccount2.setClBalanceDr(new BigDecimal(0.00));
				}else if(crAccountAmount.compareTo(drAccountAmount)==0){
					masAccount2.setClBalanceCr(new BigDecimal(0.00));
					masAccount2.setClBalanceDr(new BigDecimal(0.00));
				}
	 	hbt.update(masAccount2);
		//--------------------------------------------------------------
		if(accountListLength > 0){
			for (int i = 1; i <= accountListLength; i++) {
				FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
					if(!box.getString(AMOUNT+i).equals("") ){
						faVoucherDetails.setVoucherHeader(faVoucherHeader);
					BigDecimal amountCr = new BigDecimal(box.getString(AMOUNT+ i));
					faVoucherDetails.setCrAmount(amountCr);

				int cashAccountId = 0;
						if (box.getInt("accountId"+ i) != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						cashAccountId= box.getInt("accountId"+ i);
						faMasAccount.setId(cashAccountId);
						faVoucherDetails.setAccount(faMasAccount);
					}
					if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
						faVoucherDetails.setSubLed(faMasSubLed);
					}
					if (box.getInt(COST_CENTER_ID+ i) != 0) {
						MasCostCenter masCostCenter = new MasCostCenter();
						masCostCenter.setId(box.getInt(COST_CENTER_ID+ i));
						faVoucherDetails.setCostCenter(masCostCenter);
					}
					if (box.getInt(BRANCH_ID+ i) != 0) {
						MasBranch masBranch = new MasBranch();
						masBranch.setId(box.getInt(BRANCH_ID+ i));
						faVoucherDetails.setBranch(masBranch);
					}

					if (!box.getString(ACCOUNT_NARRATION + i).equals("")) {
						faVoucherDetails.setNarration(box.getString(ACCOUNT_NARRATION + i));
					}
					FaMasAccount acc = new FaMasAccount();
					acc.setId(box.getInt(ACCOUNT_ID));
					faVoucherDetails.setAccountIdForReport(acc);
					faVoucherDetails.setReconcile("n");
					hbt.save(faVoucherDetails);
		//-----------------------------update account group-------------------------------
					BigDecimal groupOpBalanceDrForCash = new  BigDecimal(0.0);
			 		BigDecimal groupOpBalanceCrForCash = new  BigDecimal(0.0);
			 		BigDecimal groupYtdBalanceDrForCash = new BigDecimal(0.0);
			 		BigDecimal groupYtdBalanceCrForCash = new  BigDecimal(0.0);
			 		BigDecimal drGroupAmountForCash = new BigDecimal(0.0);
			 		BigDecimal crGroupAmountForCash = new  BigDecimal(0.0);
					FaMasAccountGroup masAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"+ i));
					if(masAccountGroup.getOpBalanceCr()!= null){
						groupOpBalanceCrForCash =  masAccountGroup.getOpBalanceCr();
					}
					if(masAccountGroup.getOpBalanceDr()!= null){
						groupOpBalanceDrForCash = masAccountGroup.getOpBalanceDr();
					}
					if(masAccountGroup.getYtdAmountCr() != null){
						groupYtdBalanceCrForCash = masAccountGroup.getYtdAmountCr();
					}
					if(masAccountGroup.getYtdAmountDr() != null){
						groupYtdBalanceDrForCash = masAccountGroup.getYtdAmountDr();
					}
					if(amountCr.compareTo(new BigDecimal(0))>0){
						groupYtdBalanceCrForCash = groupYtdBalanceCrForCash.add(amountCr);
						 masAccountGroup.setYtdAmountCr(groupYtdBalanceCrForCash);
					 }
					crGroupAmountForCash = groupOpBalanceCrForCash.add(groupYtdBalanceCrForCash);
					drGroupAmountForCash = groupOpBalanceDrForCash.add(groupYtdBalanceDrForCash);

						if(drGroupAmountForCash.compareTo(crGroupAmountForCash)>0){
							masAccountGroup.setClBalanceDr(drGroupAmountForCash.subtract(crGroupAmountForCash));
							masAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmountForCash.compareTo(drGroupAmountForCash)>0){
							masAccountGroup.setClBalanceCr(crGroupAmountForCash.subtract(drGroupAmountForCash));
							masAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmountForCash.compareTo(drGroupAmountForCash)==0){
							masAccountGroup.setClBalanceCr(new BigDecimal(0.00));
							masAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						}
				 hbt.update(masAccountGroup);

				//-------------------------update account Sub group-------------------------------------------------
				 	BigDecimal subGroupOpBalanceDrForCash = new  BigDecimal(0.0);
			 		BigDecimal subGroupOpBalanceCrForCash = new  BigDecimal(0.0);
			 		BigDecimal subGroupYtdBalanceDrForCash = new BigDecimal(0.0);
			 		BigDecimal subGroupYtdBalanceCrForCash = new  BigDecimal(0.0);
			 		BigDecimal drSubGroupAmountForCash = new BigDecimal(0.0);
			 		BigDecimal crSubGroupAmountForCash = new  BigDecimal(0.0);
			 		FaMasAccountSubGroup accountSubGroup2 = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"+ i));
					 if(accountSubGroup2.getOpBalanceDr()!= null){
						 subGroupOpBalanceDrForCash =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup2.getOpBalanceCr()!= null){
						 subGroupOpBalanceCrForCash = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup2.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDrForCash = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup2.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCrForCash = accountSubGroup.getYtdAmountCr();
					 }
					 if(amountCr.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceCrForCash = subGroupYtdBalanceCrForCash.add(amountCr);
						 accountSubGroup2.setYtdAmountCr(subGroupYtdBalanceCrForCash);
					 }
					 crSubGroupAmountForCash = subGroupOpBalanceCrForCash.add(subGroupYtdBalanceCrForCash);
					 drSubGroupAmountForCash = subGroupOpBalanceDrForCash.add(subGroupYtdBalanceDrForCash);

							if(drSubGroupAmountForCash.compareTo(crSubGroupAmountForCash)>0){
								accountSubGroup2.setClBalanceDr(drSubGroupAmountForCash.subtract(crSubGroupAmountForCash));
								accountSubGroup2.setClBalanceCr(new BigDecimal(0.00));
							}else if(crSubGroupAmountForCash.compareTo(drSubGroupAmountForCash)>0){
								accountSubGroup2.setClBalanceCr(crSubGroupAmountForCash.subtract(drSubGroupAmountForCash));
								accountSubGroup2.setClBalanceDr(new BigDecimal(0.00));
							}else if(crSubGroupAmountForCash.compareTo(drSubGroupAmountForCash)==0){
								accountSubGroup2.setClBalanceCr(new BigDecimal(0.00));
								accountSubGroup2.setClBalanceDr(new BigDecimal(0.00));
							}
						 hbt.update(accountSubGroup2);
					//------------------------update account master-------------------------------------//
						 BigDecimal accYtdBalanceDr = new BigDecimal(0.0);
				 		BigDecimal accYtdBalanceCr = new  BigDecimal(0.0);
				 		BigDecimal accOpBalanceDr = new BigDecimal(0.0);
				 		BigDecimal accOpBalanceCr = new  BigDecimal(0.0);
				 		BigDecimal drAmountAccount = new BigDecimal(0.0);
				 		BigDecimal crAmountAccount = new BigDecimal(0.0);
					 FaMasAccount masAccount3= (FaMasAccount)hbt.load(FaMasAccount.class, cashAccountId);

					 if(masAccount3.getOpBalanceCr()!= null){
						 accOpBalanceCr =  masAccount3.getOpBalanceCr();
					 }
					 if(masAccount3.getOpBalanceDr()!= null){
						 accOpBalanceDr = masAccount3.getOpBalanceDr();
					 }
					if(masAccount3.getYtdAmountCr()!= null){
						accYtdBalanceCr = masAccount3.getYtdAmountCr();
					}
					if(masAccount3.getYtdAmountDr()!= null){
						accYtdBalanceDr = masAccount3.getYtdAmountDr();
					}


					if(amountCr.compareTo(new BigDecimal(0))>0){
						 accYtdBalanceCr = accYtdBalanceCr.add(amountCr);
						 masAccount3.setYtdAmountCr(accYtdBalanceCr);
					 }
					crAmountAccount = accOpBalanceCr.add(accYtdBalanceCr);
					drAmountAccount = accOpBalanceDr.add(accYtdBalanceDr);
					if(drAmountAccount.compareTo(crAmountAccount)>0){
						masAccount3.setClBalanceDr(drAmountAccount.subtract(crAmountAccount));
					    masAccount3.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountAccount.compareTo(drAmountAccount)>0){
						 masAccount3.setClBalanceCr(crAmountAccount.subtract(drAmountAccount));
						  masAccount3.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountAccount.compareTo(drAmountAccount)==0){
						masAccount3.setClBalanceCr(new BigDecimal(0.00));
				 		masAccount3.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(masAccount3);
			//-----------------------update account sub ledger==================================
				 if(box.getInt(SUB_LEDGER_CODE+ i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE+ i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}

					if(amountCr.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(amountCr);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);

					 }
					crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
					 }

					}

				}
		}
		if(accountListLengthForBank > 0 ){
			for (int j = 1; j <= accountListLengthForBank; j++) {
				FaVoucherDetails voucherDetailsObj = new FaVoucherDetails();
					if(!box.getString(AMOUNT_BANK + j).equals("") ){
						voucherDetailsObj.setVoucherHeader(faVoucherHeader);
					BigDecimal amountCr = new BigDecimal(box.getString(AMOUNT_BANK + j));
					voucherDetailsObj.setCrAmount(amountCr);

					int bankAccounId = 0;
					if (box.getInt("accountId"+ j) != 0) {
						voucherDetailsObj.setVoucherHeader(faVoucherHeader);
						FaMasAccount faMasAccount = new FaMasAccount();
						bankAccounId = box.getInt("accountId"+ j);
						faMasAccount.setId(bankAccounId);
						voucherDetailsObj.setAccount(faMasAccount);
					}

					if (box.getInt(SUB_LEDGER_CODE_BANK+ j) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+ j));
						voucherDetailsObj.setSubLed(faMasSubLed);
					}
					if (!box.getString(ACCOUNT_NARRATION_BANK + j).equals("")) {
						voucherDetailsObj.setNarration(box.getString(ACCOUNT_NARRATION_BANK + j));
					}
					if (!box.getString(BANK_NAME + j).equals("")) {
						voucherDetailsObj.setBankName(box.getString(BANK_NAME + j));
					}
					if (!box.getString(CHEQUE_DATE + j).equals("")) {
						voucherDetailsObj.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE + j)));
					}
					if (!box.getString(CHEQUE_NO + j).equals("")) {
						voucherDetailsObj.setChequeNo(box.getString(CHEQUE_NO + j));
					}
					voucherDetailsObj.setReconcile("n");

					FaMasAccount acc = new FaMasAccount();
					acc.setId(box.getInt(ACCOUNT_ID));
					voucherDetailsObj.setAccountIdForReport(acc);
					hbt.save(voucherDetailsObj);
					//----------------------------update account group--------------------------------
					BigDecimal groupOPBalanceDrForBank = new BigDecimal(0.0);
					BigDecimal groupOPBalanceCrForBank = new BigDecimal(0.0);
					BigDecimal groupYTDBalanceDrForBank = new BigDecimal(0.0);
					BigDecimal groupYTDBalanceCrForBank = new BigDecimal(0.0);
					BigDecimal drAmountGroupForBank = new BigDecimal(0.0);
				    BigDecimal crAmountGroupForBank = new BigDecimal(0.0);

					FaMasAccountGroup accountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"+j));
					if(accountGroup.getOpBalanceDr()!= null){
						groupOPBalanceDrForBank =  accountGroup.getOpBalanceDr();
					}
				 	if(accountGroup.getOpBalanceCr()!= null){
				 		groupOPBalanceCrForBank = accountGroup.getOpBalanceCr();
				 	}
					if(accountGroup.getYtdAmountCr()!= null){
						groupYTDBalanceCrForBank = accountGroup.getYtdAmountCr();
					}
					if(accountGroup.getYtdAmountDr() != null){
						groupYTDBalanceDrForBank = accountGroup.getYtdAmountDr();
					}
					if(amountCr.compareTo(new BigDecimal(0))>0){
						groupYTDBalanceCrForBank = groupYTDBalanceCrForBank.add(amountCr);
						accountGroup.setYtdAmountCr(groupYTDBalanceCrForBank);

					 }

					crAmountGroupForBank = groupOPBalanceCrForBank.add(groupYTDBalanceCrForBank);
					drAmountGroupForBank = groupOPBalanceDrForBank.add(groupYTDBalanceDrForBank);

					if(drAmountGroupForBank.compareTo(crAmountGroupForBank)>0){
						accountGroup.setClBalanceDr(drAmountGroupForBank.subtract(crAmountGroupForBank));
						accountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountGroupForBank.compareTo(drAmountGroupForBank)>0){
						accountGroup.setClBalanceCr(crAmountGroupForBank.subtract(drAmountGroupForBank));
						accountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountGroupForBank.compareTo(drAmountGroupForBank)==0){
						accountGroup.setClBalanceCr(new BigDecimal(0.00));
						accountGroup.setClBalanceDr(new BigDecimal(0.00));
					}
					 hbt.update(accountGroup);

					//-------------------------update account Sub group-------------------------------------------------
					 	BigDecimal  subGroupOPBalanceDrForBank = new BigDecimal(0.0);
						BigDecimal  subGroupOPBalanceCrForBank = new BigDecimal(0.0);
						BigDecimal  subGroupYTDBalanceDrForBank = new BigDecimal(0.0);
						BigDecimal  subGroupYTDBalanceCrForBank = new BigDecimal(0.0);
						BigDecimal drAmountSubGroupForBank = new BigDecimal(0.0);
					    BigDecimal crAmountSubGroupForBank = new BigDecimal(0.0);


					 FaMasAccountSubGroup subGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"+ j));
						 if(subGroup.getOpBalanceDr()!= null){
							 subGroupOPBalanceDrForBank =  subGroup.getOpBalanceDr();
						 }
						 if(subGroup.getOpBalanceCr()!= null){
							 subGroupOPBalanceCrForBank = subGroup.getOpBalanceCr();
						 }
						 if(subGroup.getYtdAmountDr()!= null){
							 subGroupYTDBalanceDrForBank = subGroup.getYtdAmountDr();
						 }
						 if(subGroup.getYtdAmountCr()!= null){
							 subGroupYTDBalanceCrForBank = subGroup.getYtdAmountCr();
						 }
						 if(amountCr.compareTo(new BigDecimal(0))>0){
							 subGroupYTDBalanceCrForBank = subGroupYTDBalanceCrForBank.add(amountCr);
							 subGroup.setYtdAmountCr(subGroupYTDBalanceCrForBank);

						 }
						 crAmountSubGroupForBank = subGroupOPBalanceCrForBank.add(subGroupYTDBalanceCrForBank);
						 drAmountSubGroupForBank = subGroupOPBalanceDrForBank.add(subGroupYTDBalanceDrForBank);

							if(drAmountSubGroupForBank.compareTo(crAmountSubGroupForBank)>0){
								subGroup.setClBalanceDr(drAmountSubGroupForBank.subtract(crAmountSubGroupForBank));
								subGroup.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountSubGroupForBank.compareTo(drAmountSubGroupForBank)>0){
								subGroup.setClBalanceCr(crAmountSubGroupForBank.subtract(drAmountSubGroupForBank));
								subGroup.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountSubGroupForBank.compareTo(drAmountSubGroupForBank)==0){
								subGroup.setClBalanceCr(new BigDecimal(0.00));
								subGroup.setClBalanceDr(new BigDecimal(0.00));
							}
							 hbt.update(subGroup);
		//------------------------update account master-------------------------------------//
							BigDecimal  accountOPBalanceDrForBank = new BigDecimal(0.0);
							BigDecimal   accountOPBalanceCrForBank = new BigDecimal(0.0);
							 BigDecimal accYtdBalanceDr1 = new BigDecimal(0.0);
					 		BigDecimal accYtdBalanceCr1 = new  BigDecimal(0.0);
					 		BigDecimal drAmountAccountForBank = new BigDecimal(0.0);
						    BigDecimal crAmountAccountForBank = new BigDecimal(0.0);

					 FaMasAccount masAcc= (FaMasAccount)hbt.load(FaMasAccount.class, bankAccounId);
					 if(masAcc.getOpBalanceCr()!= null){
						 accountOPBalanceCrForBank =  masAcc.getOpBalanceCr();
					 }
					 if(masAcc.getOpBalanceDr()!= null){
						 accountOPBalanceDrForBank = masAcc.getOpBalanceDr();
					 }

						if(masAcc.getYtdAmountCr()!= null){
							accYtdBalanceCr1 = masAcc.getYtdAmountCr();
						}
						if(masAcc.getYtdAmountDr()!= null){
							accYtdBalanceDr1 = masAcc.getYtdAmountDr();
						}
						if(amountCr.compareTo(new BigDecimal(0))>0){
							 accYtdBalanceCr1 = accYtdBalanceCr1.add(amountCr);
							 masAcc.setYtdAmountCr(accYtdBalanceCr1);

						 }
						crAmountAccountForBank = accountOPBalanceCrForBank.add(accYtdBalanceCr1);
						drAmountAccountForBank = accountOPBalanceDrForBank.add(accYtdBalanceDr1);

							if(drAmountAccountForBank.compareTo(crAmountAccountForBank)>0){
								masAcc.setClBalanceDr(drAmountAccountForBank.subtract(crAmountAccountForBank));
								masAcc.setClBalanceCr(new BigDecimal(0.00));
							}else if(crAmountAccountForBank.compareTo(drAmountAccountForBank)>0){
								masAcc.setClBalanceCr(crAmountAccountForBank.subtract(drAmountAccountForBank));
								masAcc.setClBalanceDr(new BigDecimal(0.00));
							}else if(crAmountAccountForBank.compareTo(drAmountAccountForBank)==0){
								masAcc.setClBalanceCr(new BigDecimal(0.00));
								masAcc.setClBalanceDr(new BigDecimal(0.00));
							}
						 hbt.update(masAcc);

						//-----------------------update account sub ledger==================================
						 if(box.getInt(SUB_LEDGER_CODE_BANK+ j)!=0){
							 BigDecimal subLedOPBalanceCr = new BigDecimal(0.0);
							 BigDecimal subLedOPBalanceDr = new BigDecimal(0.0);
							 BigDecimal subLedYTDBalanceDr = new BigDecimal(0.0);
							 BigDecimal subLedYTDBalanceCr = new BigDecimal(0.0);
							 BigDecimal drAmountSubLedForBank = new BigDecimal(0.0);
						    BigDecimal crAmountSubLedForBank = new BigDecimal(0.0);
							 FaMasSubLed faSubLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ j));

							 if(faSubLed.getOpBalanceCr()!= null){
								 subLedOPBalanceCr =  faSubLed.getOpBalanceCr();
							 }
							 if(faSubLed.getOpBalanceDr()!= null){
								 subLedOPBalanceDr = faSubLed.getOpBalanceDr();
							 }

							if(faSubLed.getYtdAmountCr()!= null){
								subLedYTDBalanceCr = faSubLed.getYtdAmountCr();
							}
							if(faSubLed.getYtdAmountDr()!= null){
								subLedYTDBalanceDr = faSubLed.getYtdAmountDr();
							}
							if(amountCr.compareTo(new BigDecimal(0))>0){
								 subLedYTDBalanceCr = subLedYTDBalanceCr.add(amountCr);
								 faSubLed.setYtdAmountCr(subLedYTDBalanceCr);

							 }
							crAmountSubLedForBank = subLedOPBalanceCr.add(subLedYTDBalanceCr);
							drAmountSubLedForBank = subLedOPBalanceDr.add(subLedYTDBalanceDr);

								if(drAmountSubLedForBank.compareTo(crAmountSubLedForBank)>0){
									faSubLed.setClBalanceDr(drAmountSubLedForBank.subtract(crAmountSubLedForBank));
									faSubLed.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedForBank.compareTo(drAmountSubLedForBank)>0){
									faSubLed.setClBalanceCr(crAmountSubLedForBank.subtract(drAmountSubLedForBank));
									faSubLed.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedForBank.compareTo(drAmountSubLedForBank)==0){
									faSubLed.setClBalanceCr(new BigDecimal(0.00));
									faSubLed.setClBalanceDr(new BigDecimal(0.00));
								}
								 hbt.update(faSubLed);
							 }

					}
				}
			}
					tx.commit();
					saved = true;

				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				//Object[] selectedId = {1,2};
				//accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
						//.createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId)).list();

				//costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
				//branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();

				//map.put("costCenterList", costCenterList);

				map.put("mainAccountId", box.getInt(ACCOUNT_ID));
				map.put("accList", accList);
				paramMap.put("suffix", fYearDesc);
				paramMap.put("flag", "display");
				paramMap.put("prefix", "RV");
				paramMap.put("voucherType", "Reciept");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
				map.put("financialYearId", financialYearId);
				return map;
		}

*/	
	
	/*@SuppressWarnings("unchecked")
	public Map<String, Object> showPaymentVoucherJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		Session session = (Session)getSession();
		Object[] selectedId = {1,2};
		
		paramMap.put("hospitalId", box.getInt("hospitalId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PV");
		paramMap.put("voucherType", "Payment");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		accList = session.createCriteria(FaMasAccount.class)
							//.add(Restrictions.eq("ParentStatus", "n"))
					.add(Restrictions.eq("FYear.Id", box.getInt("fYear"))).createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId)).list();
		
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("voucherNo", voucherNo);
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		return map;
	}*/
	/*@SuppressWarnings("unchecked")
	public Map<String, Object> getFinancialYearForPaymentVoucher(String voucherDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		Session session = (Session)getSession();
		Object[] selectedId = {"Bank A/C","Cash In Hand"};
		
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(voucherDate)))
		.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(voucherDate)))
			.add(Restrictions.eq("Status", "y"))
				.list();

		int financialYearId = 0;
		String fYearDesc = "";
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				financialYearId = financialYear.getId();
				fYearDesc = financialYear.getYearDescription();
			}
		}
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PV");
		paramMap.put("voucherType", "Payment");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
					.add(Restrictions.eq("FYear.Id", financialYearId)).createAlias("AccountSubGroup", "subGroup")
					.add(Restrictions.or(Restrictions.eq("subGroup.AccountSubGroupName", "Bank A/C"),
						Restrictions.eq("subGroup.AccountSubGroupName", "Cash In Hand"))).list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).list();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		map.put("voucherNo", voucherNo);
		map.put("branchList", branchList);
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		map.put("financialYearId", financialYearId);
		map.put("fYearDesc", fYearDesc);
		return map;
	}*/
	/*@SuppressWarnings("unchecked")
	public Map<String, Object> submitPaymentVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int vhId=0;
		int voucherNo=0;
		int accountListLength = box.getInt("hiddenValueCharge");
		//int accountListLengthForBank = box.getInt("hiddenValueChargeForBank");

		try {
			tx = session.beginTransaction();
			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId(box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("PV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
			}
			faVoucherHeader.setDrAmount(totalAmountCr);
			faVoucherHeader.setCrAmount(totalAmountCr);

			HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
			hrMasFinancialYear.setId(box.getInt("fyear"));
			faVoucherHeader.setFYear(hrMasFinancialYear);
			
			if (!box.getString(CHEQUE_DATE).equals("")) {
				faVoucherHeader.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE)));
			}
			if (!box.getString(CHEQUE_NO).equals("")) {
				faVoucherHeader.setChequeNo(box.getString(CHEQUE_NO));
			}
			if (box.getInt(COST_CENTER_ID) != 0) {
				MasCostCenter masCostCenter = new MasCostCenter();
				masCostCenter.setId(box.getInt(COST_CENTER_ID));
				faVoucherHeader.setCostCenter(masCostCenter);
			}
			paramMap.put("hospitalId", box.getInt("hospitalId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "PV");
			paramMap.put("voucherType", "Payment");
			voucherNo = generateVoucherNo(paramMap);
			faVoucherHeader.setVoucherNo(voucherNo);
			FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			faMasAccountSubGroup.setId(box.getInt("subGroupId"));
			faVoucherHeader.setAccountSubGroup(faMasAccountSubGroup);
			
			hbt.save(faVoucherHeader);

			FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt(ACCOUNT_ID));
				voucherDetails.setAccount(masAccount);
				voucherDetails.setCrAmount(totalAmountCr);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				voucherDetails.setNarration(box.getString(NARRATION));
				//------------------------------code for account id report--------------------------------------
				if(accountListLength > 0){
					if (box.getInt("accountId1") != 0) {
						FaMasAccount account = new FaMasAccount();
						account.setId(box.getInt("accountId1") );
						voucherDetails.setAccountIdForReport(account);
					}
					System.out.println("subledger=="+box.getInt(SUB_LEDGER_CODE+"1"));
					if (box.getInt(SUB_LEDGER_CODE+"1") != 0) {
						FaMasSubLed subLed = new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE+"1"));
						voucherDetails.setSubLedIdForReport(subLed);
					}
				}
				//------------------------------code for Sub Ledger id report-------commented by anamika on 20th august-------------------------------
				if(accountListLengthForBank > 0){
					if (box.getInt("accountId1") != 0) {
						FaMasAccount account = new FaMasAccount();
						account.setId(box.getInt("accountId1") );
						voucherDetails.setAccountIdForReport(account);
					}
					if (box.getInt(SUB_LEDGER_CODE_BANK+"1") != 0) {
						FaMasSubLed subLed = new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+"1"));
						voucherDetails.setSubLedIdForReport(subLed);
					}
				}
				hbt.save(voucherDetails);
				//-------------------------update account group-------------------------------------------------
				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);
				 FaMasAccountGroup faMasAccountGroup2 = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"));
				 if(faMasAccountGroup2.getOpBalanceDr() != null){
					 groupOpBalanceDr =  faMasAccountGroup2.getOpBalanceDr();
				 }
				 if(faMasAccountGroup2.getOpBalanceCr() != null){
					 groupOpBalanceCr = faMasAccountGroup2.getOpBalanceCr();
				 }
				 if(faMasAccountGroup2.getYtdAmountDr() != null){
					 groupYtdBalanceDr = faMasAccountGroup2.getYtdAmountDr();
				 }
				 if(faMasAccountGroup2.getYtdAmountCr() != null){
					 groupYtdBalanceCr = faMasAccountGroup2.getYtdAmountCr();
				 }
				 if(totalAmountCr.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(totalAmountCr);
					 faMasAccountGroup2.setYtdAmountCr(groupYtdBalanceCr);

				 }
				 drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				 crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				 if(drGroupAmount.compareTo(crGroupAmount)>0){
					 faMasAccountGroup2.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				     faMasAccountGroup2.setClBalanceCr(new BigDecimal(0.00));
				 }else if(crGroupAmount.compareTo(drGroupAmount)>0){
					 faMasAccountGroup2.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
			 		 faMasAccountGroup2.setClBalanceDr(new BigDecimal(0.00));
				 }else if(drGroupAmount.compareTo(crGroupAmount)==0){
					 faMasAccountGroup2.setClBalanceCr(new BigDecimal(0.00));
					 faMasAccountGroup2.setClBalanceDr(new BigDecimal(0.00));
				 }
			 	hbt.update(faMasAccountGroup2);
			 	//-------------------------update account Sub group-------------------------------------------------
				BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);
			 FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"));
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOpBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOpBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(totalAmountCr.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(totalAmountCr);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);

				 }
				 drSubGroupAmount = subGroupOpBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOpBalanceCr.add(subGroupYtdBalanceCr);
				 
				 if(drSubGroupAmount.compareTo(crSubGroupAmount)>0){
					 accountSubGroup.setClBalanceDr(drSubGroupAmount.subtract(crSubGroupAmount));
					 accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
				 }else if(crSubGroupAmount.compareTo(drSubGroupAmount)>0){
					 accountSubGroup.setClBalanceCr(crSubGroupAmount.subtract(drSubGroupAmount));
					 accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
				 }else if(drSubGroupAmount.compareTo(crSubGroupAmount)==0){
					 accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					 accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
				 }
			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------
		 	BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
	 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
	 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
	 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
	 		BigDecimal drAccountAmount = new BigDecimal(0.0);
	 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
	 		
	 		FaMasAccount masAccount2 = (FaMasAccount)hbt.load(FaMasAccount.class, box.getInt(ACCOUNT_ID));
	 		if(masAccount2.getOpBalanceDr()!= null){
	 			accountOpBalanceDr =  masAccount2.getOpBalanceDr();
	 		}
	 		if(masAccount2.getOpBalanceCr()!= null){
	 			accountOpBalanceCr = masAccount2.getOpBalanceCr();
	 		}

	 		 if(masAccount2.getYtdAmountDr() != null){
	 			 accountYtdBalanceDr = masAccount2.getYtdAmountDr();
	 		 }
	 		 if(masAccount2.getYtdAmountCr() != null){
	 			accountYtdBalanceCr = masAccount2.getYtdAmountCr();
	 		 }
	 		if(totalAmountCr.compareTo(new BigDecimal(0))>0){
				 accountYtdBalanceCr = accountYtdBalanceCr.add(totalAmountCr);
				 masAccount2.setYtdAmountCr(accountYtdBalanceCr);

			 }
	 		drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
	 		crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
			 
			 if(drAccountAmount.compareTo(crAccountAmount)>0){
				 masAccount2.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
				 masAccount2.setClBalanceCr(new BigDecimal(0.00));
			 }else if(crAccountAmount.compareTo(drAccountAmount)>0){
				 masAccount2.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
				 masAccount2.setClBalanceDr(new BigDecimal(0.00));
			 }else if(drAccountAmount.compareTo(crAccountAmount)==0){
				 masAccount2.setClBalanceCr(new BigDecimal(0.00));
				 masAccount2.setClBalanceDr(new BigDecimal(0.00));
			 }

	 	hbt.update(masAccount2);

		//--------------------------------------------------------------
		if(accountListLength > 0){
			for (int i = 1; i <= accountListLength; i++) {
				FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
					if(!box.getString(AMOUNT+i).equals("") ){
						faVoucherDetails.setVoucherHeader(faVoucherHeader);
					BigDecimal amountDr = new BigDecimal(box.getString(AMOUNT+ i));
					faVoucherDetails.setDrAmount(amountDr);
					int cashAccountId = 0;
					if (box.getInt("accountId"+ i) != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						cashAccountId = box.getInt("accountId"+ i);
						faMasAccount.setId(cashAccountId);
						faVoucherDetails.setAccount(faMasAccount);
					}

					if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
						faVoucherDetails.setSubLed(faMasSubLed);
					}
					
					if (box.getInt(COST_CENTER_ID+ i) != 0) {
						MasCostCenter masCostCenter = new MasCostCenter();
						masCostCenter.setId(box.getInt(COST_CENTER_ID+ i));
						faVoucherDetails.setCostCenter(masCostCenter);
					}
					if (!box.getString(ACCOUNT_NARRATION + i).equals("")) {
						faVoucherDetails.setNarration(box.getString(ACCOUNT_NARRATION + i));
					}
					faVoucherDetails.setReconcile("n");	

					hbt.save(faVoucherDetails);

//-----------------------------update account group---------------------------------------------------------------//
					BigDecimal groupOpBalanceDrCash = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCrCash = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDrCash = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCrCash = new BigDecimal(0.0);
					BigDecimal drGroupAmountForCash = new BigDecimal(0.0);
					BigDecimal crGroupAmountForCash = new BigDecimal(0.0);
			FaMasAccountGroup masAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"+ i));
					if(masAccountGroup.getOpBalanceDr()!= null){
						groupOpBalanceDrCash =  masAccountGroup.getOpBalanceDr();
					}
					if(masAccountGroup.getOpBalanceCr() != null){
						groupOpBalanceCrCash = masAccountGroup.getOpBalanceCr();
					}
					if(masAccountGroup.getYtdAmountCr() != null){
						groupYtdBalanceCrCash = masAccountGroup.getYtdAmountCr();
					}
					if(masAccountGroup.getYtdAmountDr() != null){
						groupYtdBalanceDrCash = masAccountGroup.getYtdAmountDr();
					}
					if(amountDr.compareTo(new BigDecimal(0))>0){
						groupYtdBalanceDrCash = groupYtdBalanceDrCash.add(amountDr);
						 masAccountGroup.setYtdAmountDr(groupYtdBalanceDrCash);
					 }
					drGroupAmountForCash = groupOpBalanceDrCash.add(groupYtdBalanceDrCash);
					crGroupAmountForCash = groupOpBalanceCrCash.add(groupYtdBalanceCrCash);
					
					if(drGroupAmountForCash.compareTo(crGroupAmountForCash)>0){
						masAccountGroup.setClBalanceDr(drGroupAmountForCash.subtract(crGroupAmountForCash));
						masAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					 }else if(crGroupAmountForCash.compareTo(drGroupAmountForCash)>0){
						 masAccountGroup.setClBalanceCr(crGroupAmountForCash.subtract(drGroupAmountForCash));
						 masAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					 }else if(drGroupAmountForCash.compareTo(crGroupAmountForCash)==0){
						 masAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						 masAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					 }
					
				 hbt.update(masAccountGroup);
//-------------------------update account Sub group------------------------------------------------------------------
				 	BigDecimal subGroupOpBalanceDrCash = new BigDecimal(0.0);
					BigDecimal subGroupOpBalanceCrCash = new BigDecimal(0.0);
					BigDecimal subGroupYtdBalanceDrCash = new BigDecimal(0.0);
					BigDecimal subGroupYtdBalanceCrCash = new BigDecimal(0.0);
					BigDecimal drSubGroupAmountForCash = new BigDecimal(0.0);
					BigDecimal crSubGroupAmountForCash = new BigDecimal(0.0);
				 FaMasAccountSubGroup accSubGroup1 = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"+ i));
					 if(accSubGroup1.getOpBalanceDr()!= null){
						 subGroupOpBalanceDrCash =  accSubGroup1.getOpBalanceDr();
					 }
					 if(accSubGroup1.getOpBalanceCr()!= null){
						 subGroupOpBalanceCrCash = accSubGroup1.getOpBalanceCr();
					 }
					 if(accSubGroup1.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDrCash = accSubGroup1.getYtdAmountDr();
					 }
					 if(accSubGroup1.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCrCash = accSubGroup1.getYtdAmountCr();
					 }
					 if(amountDr.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceDrCash = subGroupYtdBalanceDrCash.add(amountDr);
						 accSubGroup1.setYtdAmountDr(subGroupYtdBalanceDrCash);
					 }
					 drSubGroupAmountForCash = subGroupOpBalanceDrCash.add(subGroupYtdBalanceDrCash);
					 crSubGroupAmountForCash = subGroupOpBalanceCrCash.add(subGroupYtdBalanceCrCash);
						
						if(drSubGroupAmountForCash.compareTo(crSubGroupAmountForCash)>0){
							accSubGroup1.setClBalanceDr(drSubGroupAmountForCash.subtract(crSubGroupAmountForCash));
							accSubGroup1.setClBalanceCr(new BigDecimal(0.00));
						 }else if(crSubGroupAmountForCash.compareTo(drSubGroupAmountForCash)>0){
							 accSubGroup1.setClBalanceCr(crSubGroupAmountForCash.subtract(drSubGroupAmountForCash));
							 accSubGroup1.setClBalanceDr(new BigDecimal(0.00));
						 }else if(drSubGroupAmountForCash.compareTo(crSubGroupAmountForCash)==0){
							 accSubGroup1.setClBalanceCr(new BigDecimal(0.00));
							 accSubGroup1.setClBalanceDr(new BigDecimal(0.00));
						 }
						 hbt.update(accSubGroup1);

//------------------------update account master-----------------------------------------------------------------------//
				 	BigDecimal accYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountOpBalanceDrCash = new BigDecimal(0.0);
			 		BigDecimal accountOpBalanceCrCash = new  BigDecimal(0.0);
			 		BigDecimal drAccountAmountForCash = new BigDecimal(0.0);
			 		BigDecimal crAccountAmountForCash = new  BigDecimal(0.0);
					 FaMasAccount masAccount3= (FaMasAccount)hbt.load(FaMasAccount.class, cashAccountId);
					 
					 if(masAccount3.getOpBalanceCr()!= null){
						 accountOpBalanceCrCash =  masAccount3.getOpBalanceCr();
					 }
					 if(masAccount3.getOpBalanceDr()!= null){
						 accountOpBalanceDrCash = masAccount3.getOpBalanceDr();
					 }

						if(masAccount3.getYtdAmountCr()!= null){
							accYtdBalanceCr = masAccount3.getYtdAmountCr();
						}
						if(masAccount3.getYtdAmountDr()!= null){
							accYtdBalanceDr = masAccount3.getYtdAmountDr();
						}
						 if(amountDr.compareTo(new BigDecimal(0))>0){
							 accYtdBalanceDr = accYtdBalanceDr.add(amountDr);
							 masAccount3.setYtdAmountDr(accYtdBalanceDr);
						 }
						 drAccountAmountForCash = accountOpBalanceDrCash.add(accYtdBalanceDr);
						 crAccountAmountForCash = accountOpBalanceCrCash.add(accYtdBalanceCr);
							
							if(drAccountAmountForCash.compareTo(crAccountAmountForCash)>0){
								masAccount3.setClBalanceDr(drAccountAmountForCash.subtract(crAccountAmountForCash));
								masAccount3.setClBalanceCr(new BigDecimal(0.00));
							 }else if(crAccountAmountForCash.compareTo(drAccountAmountForCash)>0){
								 masAccount3.setClBalanceCr(crAccountAmountForCash.subtract(drAccountAmountForCash));
								 masAccount3.setClBalanceDr(new BigDecimal(0.00));
							 }else if(drAccountAmountForCash.compareTo(crAccountAmountForCash)==0){
								 masAccount3.setClBalanceCr(new BigDecimal(0.00));
								 masAccount3.setClBalanceDr(new BigDecimal(0.00));
							 }
						 hbt.update(masAccount3);
//-----------------------update account sub ledger==================================
					 if(box.getInt(SUB_LEDGER_CODE+ i)!=0){
						 BigDecimal subLedgerOpBalanceCr = new BigDecimal(0.0);
						 BigDecimal subLedgerOpBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drSubLedAmountForCash = new BigDecimal(0.0);
						 BigDecimal crSubLedAmountForCash = new BigDecimal(0.0);
						 
						 
						 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE+ i));
						 if(subLed.getOpBalanceCr()!= null){
							 subLedgerOpBalanceCr =  subLed.getOpBalanceCr();
						 }
						 if(subLed.getOpBalanceDr()!= null){
							 subLedgerOpBalanceDr = subLed.getOpBalanceDr();
						 }

							if(subLed.getYtdAmountDr()!= null){
								subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
							}
							if(subLed.getYtdAmountCr()!= null){
								subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
							}
							if(amountDr.compareTo(new BigDecimal(0))>0){
								 subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(amountDr);
								 subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
							 }
							
							drSubLedAmountForCash = subLedgerOpBalanceDr.add(subLedgerYTDBalanceDr);
							crSubLedAmountForCash = subLedgerOpBalanceCr.add(subLedgerYTDBalanceCr);
								
								if(drSubLedAmountForCash.compareTo(crSubLedAmountForCash)>0){
									subLed.setClBalanceDr(drSubLedAmountForCash.subtract(crSubLedAmountForCash));
									subLed.setClBalanceCr(new BigDecimal(0.00));
								 }else if(crSubLedAmountForCash.compareTo(drSubLedAmountForCash)>0){
									 subLed.setClBalanceCr(crSubLedAmountForCash.subtract(drSubLedAmountForCash));
									 subLed.setClBalanceDr(new BigDecimal(0.00));
								 }else if(drSubLedAmountForCash.compareTo(crSubLedAmountForCash)==0){
									 subLed.setClBalanceCr(new BigDecimal(0.00));
									 subLed.setClBalanceDr(new BigDecimal(0.00));
								 }
							 hbt.update(subLed);
						 }	 
					}

				}
		}
		

		
		if(accountListLengthForBank > 0 ){
			for (int j = 1; j <= accountListLengthForBank; j++) {
				FaVoucherDetails voucherDetailsObj = new FaVoucherDetails();
					if(!box.getString(AMOUNT_BANK + j).equals("") ){
						voucherDetailsObj.setVoucherHeader(faVoucherHeader);
					BigDecimal amountDr = new BigDecimal(box.getString(AMOUNT_BANK + j));
					voucherDetailsObj.setDrAmount(amountDr);
					int bankAccountId = 0;
					if (box.getInt("accountId"+ j) != 0) {
						voucherDetailsObj.setVoucherHeader(faVoucherHeader);
						FaMasAccount faMasAccount = new FaMasAccount();
						bankAccountId =box.getInt("accountId"+ j); 
						faMasAccount.setId(bankAccountId);
						voucherDetailsObj.setAccount(faMasAccount);
					}
					if (box.getInt(SUB_LEDGER_CODE_BANK+ j) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+ j));
						voucherDetailsObj.setSubLed(faMasSubLed);
					}
					if (box.getInt(COST_CENTER_ID_BANK+ j) != 0) {
						MasCostCenter masCostCenter = new MasCostCenter();
						masCostCenter.setId(box.getInt(COST_CENTER_ID_BANK+ j));
						voucherDetailsObj.setCostCenter(masCostCenter);
					}
					if (!box.getString(ACCOUNT_NARRATION_BANK + j).equals("")) {
						voucherDetailsObj.setNarration(box.getString(ACCOUNT_NARRATION_BANK + j));
					}
					if (!box.getString(BANK_NAME + j).equals("")) {
						voucherDetailsObj.setBankName(box.getString(BANK_NAME + j));
					}
					if (!box.getString(CHEQUE_DATE + j).equals("")) {
						voucherDetailsObj.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE + j)));
					}
					if (!box.getString(CHEQUE_NO + j).equals("")) {
						voucherDetailsObj.setChequeNo(box.getString(CHEQUE_NO + j));
					}
					voucherDetailsObj.setReconcile("n");
					FaMasAccount acc = new FaMasAccount();
					acc.setId(box.getInt(ACCOUNT_ID));
					voucherDetailsObj.setAccountIdForReport(acc);

					hbt.save(voucherDetailsObj);
					//-----------------------------update account group---------------------------------------------------------------//
					BigDecimal groupOpBalanceDrBank = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCrBank = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDrBank = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCrBank = new BigDecimal(0.0);
					BigDecimal drGroupAmountForBank = new BigDecimal(0.0);
					BigDecimal crGroupAmountForBank = new BigDecimal(0.0);
					FaMasAccountGroup accountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"+ j));
							if(accountGroup.getOpBalanceDr()!= null){
								groupOpBalanceDrBank =  accountGroup.getOpBalanceDr();
							}
							if(accountGroup.getOpBalanceCr() != null){
								groupOpBalanceCrBank = accountGroup.getOpBalanceCr();
							}
							if(accountGroup.getYtdAmountCr() != null){
								groupYtdBalanceCrBank = accountGroup.getYtdAmountCr();
							}
							if(accountGroup.getYtdAmountDr() != null){
								groupYtdBalanceDrBank = accountGroup.getYtdAmountDr();
							}
							if(amountDr.compareTo(new BigDecimal(0))>0){
								groupYtdBalanceDrBank = groupYtdBalanceDrBank.add(amountDr);
								accountGroup.setYtdAmountDr(groupYtdBalanceDrBank);
							 }
							drGroupAmountForBank = groupOpBalanceDrBank.add(groupYtdBalanceDrBank);
							crGroupAmountForBank = groupOpBalanceCrBank.add(groupYtdBalanceCrBank);
								
								if(drGroupAmountForBank.compareTo(crGroupAmountForBank)>0){
									accountGroup.setClBalanceDr(drGroupAmountForBank.subtract(crGroupAmountForBank));
									accountGroup.setClBalanceCr(new BigDecimal(0.00));
								 }else if(crGroupAmountForBank.compareTo(drGroupAmountForBank)>0){
									 accountGroup.setClBalanceCr(crGroupAmountForBank.subtract(drGroupAmountForBank));
									 accountGroup.setClBalanceDr(new BigDecimal(0.00));
								 }else if(drGroupAmountForBank.compareTo(crGroupAmountForBank)==0){
									 accountGroup.setClBalanceCr(new BigDecimal(0.00));
									 accountGroup.setClBalanceDr(new BigDecimal(0.00));
								 }

						 hbt.update(accountGroup);
		//-------------------------update account Sub group------------------------------------------------------------------
						 	BigDecimal subGroupOpBalanceDrBank = new BigDecimal(0.0);
							BigDecimal subGroupOpBalanceCrBank = new BigDecimal(0.0);
							BigDecimal subGroupYtdBalanceDrBank = new BigDecimal(0.0);
							BigDecimal subGroupYtdBalanceCrBank = new BigDecimal(0.0);
							BigDecimal drSubGroupAmountForBank = new BigDecimal(0.0);
							BigDecimal crSubGroupAmountForBank = new BigDecimal(0.0);
						 FaMasAccountSubGroup subGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"+ j));
							 if(subGroup.getOpBalanceDr()!= null){
								 subGroupOpBalanceDrBank =  subGroup.getOpBalanceDr();
							 }
							 if(subGroup.getOpBalanceCr()!= null){
								 subGroupOpBalanceCrBank = subGroup.getOpBalanceCr();
							 }
							 if(subGroup.getYtdAmountDr()!= null){
								 subGroupYtdBalanceDrBank = subGroup.getYtdAmountDr();
							 }
							 if(subGroup.getYtdAmountCr()!= null){
								 subGroupYtdBalanceCrBank = subGroup.getYtdAmountCr();
							 }
							 if(amountDr.compareTo(new BigDecimal(0))>0){
								 subGroupYtdBalanceDrBank = subGroupYtdBalanceDrBank.add(amountDr);
								 subGroup.setYtdAmountDr(subGroupYtdBalanceDrBank);
							 }
							 drSubGroupAmountForBank = subGroupOpBalanceDrBank.add(subGroupYtdBalanceDrBank);
							 crSubGroupAmountForBank = subGroupOpBalanceCrBank.add(subGroupYtdBalanceCrBank);
								
								if(drSubGroupAmountForBank.compareTo(crSubGroupAmountForBank)>0){
									subGroup.setClBalanceDr(drSubGroupAmountForBank.subtract(crSubGroupAmountForBank));
									subGroup.setClBalanceCr(new BigDecimal(0.00));
								 }else if(crSubGroupAmountForBank.compareTo(drSubGroupAmountForBank)>0){
									 subGroup.setClBalanceCr(crSubGroupAmountForBank.subtract(drSubGroupAmountForBank));
									 subGroup.setClBalanceDr(new BigDecimal(0.00));
								 }else if(drSubGroupAmountForBank.compareTo(crSubGroupAmountForBank)==0){
									 subGroup.setClBalanceCr(new BigDecimal(0.00));
									 subGroup.setClBalanceDr(new BigDecimal(0.00));
								 }

								 hbt.update(subGroup);

		//------------------------update account master-----------------------------------------------------------------------//
							 BigDecimal accountOpBalanceDrBank = new BigDecimal(0.0);
					 		 BigDecimal accountOpBalanceCrBank = new  BigDecimal(0.0);
							 BigDecimal accountYtdBalanceDr1 = new BigDecimal(0.0);
					 		 BigDecimal accountYtdBalanceCr1 = new  BigDecimal(0.0);
					 		 BigDecimal drAccountAmountForBank = new BigDecimal(0.0);
					 		 BigDecimal crAccountAmountForBank = new  BigDecimal(0.0);
							 FaMasAccount accountMaster= (FaMasAccount)hbt.load(FaMasAccount.class, bankAccountId);
							 if(accountMaster.getOpBalanceCr()!= null){
								 accountOpBalanceCrBank =  accountMaster.getOpBalanceCr();
							 }
							 if(accountMaster.getOpBalanceDr()!= null){
								 accountOpBalanceDrBank = accountMaster.getOpBalanceDr();
							 }
							if(accountMaster.getYtdAmountDr()!= null){
								accountYtdBalanceDr1 = accountMaster.getYtdAmountDr();
							}
							if(accountMaster.getYtdAmountCr()!= null){
								accountYtdBalanceCr1 = accountMaster.getYtdAmountCr();
							}
							 if(amountDr.compareTo(new BigDecimal(0))>0){
								 accountYtdBalanceDr1 = accountYtdBalanceDr1.add(amountDr);
								 accountMaster.setYtdAmountDr(accountYtdBalanceDr1);
							 }
							 drAccountAmountForBank = accountOpBalanceDrBank.add(accountYtdBalanceDr1);
							 crAccountAmountForBank = accountOpBalanceCrBank.add(accountYtdBalanceCr1);
								
							if(drAccountAmountForBank.compareTo(crAccountAmountForBank)>0){
								accountMaster.setClBalanceDr(drAccountAmountForBank.subtract(crAccountAmountForBank));
								accountMaster.setClBalanceCr(new BigDecimal(0.00));
							 }else if(crAccountAmountForBank.compareTo(drAccountAmountForBank)>0){
								 accountMaster.setClBalanceCr(crAccountAmountForBank.subtract(drAccountAmountForBank));
								 accountMaster.setClBalanceDr(new BigDecimal(0.00));
							 }else if(drAccountAmountForBank.compareTo(crAccountAmountForBank)==0){
								 accountMaster.setClBalanceCr(new BigDecimal(0.00));
								 accountMaster.setClBalanceDr(new BigDecimal(0.00));
							 }
							 hbt.update(accountMaster);
								//-----------------------update account sub ledger==================================
					if(box.getInt(SUB_LEDGER_CODE_BANK+ j)!=0){
						BigDecimal subLedgerOpBalanceCrForBank = new BigDecimal(0.0);
						BigDecimal subLedgerOpBalanceDrForBank = new BigDecimal(0.0);
						BigDecimal subLedgerYTDBalanceDrForBank = new BigDecimal(0.0);
						BigDecimal subLedgerYTDBalanceCrForBank = new BigDecimal(0.0);
						BigDecimal drSubLedAmountForBank = new BigDecimal(0.0);
						BigDecimal crSubLedAmountForBank = new BigDecimal(0.0);
						 
						 FaMasSubLed faSubLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ j));
						 if(faSubLed.getOpBalanceCr()!= null){
							 subLedgerOpBalanceCrForBank =  faSubLed.getOpBalanceCr();
						 }
						 if(faSubLed.getOpBalanceDr()!= null){
							 subLedgerOpBalanceDrForBank = faSubLed.getOpBalanceDr();
						 }

						if(faSubLed.getYtdAmountDr()!= null){
							subLedgerYTDBalanceDrForBank = faSubLed.getYtdAmountDr();
						}
						if(faSubLed.getYtdAmountCr()!= null){
							subLedgerYTDBalanceCrForBank = faSubLed.getYtdAmountCr();
						}
						if(amountDr.compareTo(new BigDecimal(0))>0){
							subLedgerYTDBalanceDrForBank = subLedgerYTDBalanceDrForBank.add(amountDr);
							 faSubLed.setYtdAmountDr(subLedgerYTDBalanceDrForBank);
						 }
							drSubLedAmountForBank = subLedgerOpBalanceDrForBank.add(subLedgerYTDBalanceDrForBank);
							crSubLedAmountForBank = subLedgerOpBalanceCrForBank.add(subLedgerYTDBalanceCrForBank);
								
							if(drSubLedAmountForBank.compareTo(crSubLedAmountForBank)>0){
								faSubLed.setClBalanceDr(drSubLedAmountForBank.subtract(crSubLedAmountForBank));
								faSubLed.setClBalanceCr(new BigDecimal(0.00));
							 }else if(crSubLedAmountForBank.compareTo(drSubLedAmountForBank)>0){
								 faSubLed.setClBalanceCr(crSubLedAmountForBank.subtract(drSubLedAmountForBank));
								 faSubLed.setClBalanceDr(new BigDecimal(0.00));
							 }else if(drSubLedAmountForBank.compareTo(crSubLedAmountForBank)==0){
								 faSubLed.setClBalanceCr(new BigDecimal(0.00));
								 faSubLed.setClBalanceDr(new BigDecimal(0.00));
							 }
									 
									 hbt.update(faSubLed);
						} 
					}
				}
		}			vhId=faVoucherHeader.getId();
					tx.commit();
					saved = true;
				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}
		Object[] selectedId = {1,2};
		accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
						.add(Restrictions.eq("FYear.Id", box.getInt("fyear"))).createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId)).list();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("costCenterList", costCenterList);
		map.put("accList", accList);
		paramMap.put("hospitalId", box.getInt("hospitalId"));
	 	paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PV");
		paramMap.put("voucherType", "Payment");
		//int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("saved", saved);
		map.put("vhId", vhId);
		System.out.println(vhId);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		return map;
	}*/
//--------------------------------------------Sales Voucher----------------------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSalesVoucherJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<MasWard>wardList=new ArrayList<MasWard>();
		List<Object[]>amountList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		String fYearDesc = "";
		if(generalMap.get("fYearDesc")!= null){
			fYearDesc = (String)generalMap.get("fYearDesc");
		}
		int fyear = 0;
		if(generalMap.get("fyear")!= null){
			fyear = (Integer)generalMap.get("fyear");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		amountList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("header.Hospital", "hospital")
				.createAlias("header.FYear", "fYear").add(Restrictions.eq("fYear.Id", fyear))
						.add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("header.VoucherType", "SV"))
						.setProjection(Projections.projectionList().add(
							Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
							Projections.groupProperty("header.VoucherType"))).list();
		

		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		wardList=session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);
		map.put("amountList", amountList);
		
		
		paramMap.put("hospitalId", hospitalId);
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SV");
		paramMap.put("voucherType", "Sales");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("wardList",wardList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSalesVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();

		int vhId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int voucherNo=0;
		int authLevel=0;
		if(box.getInt("authLevel")!=0){
			authLevel=box.getInt("authLevel");
		}

		try {
			tx = session.beginTransaction();;
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial financial=new MasStoreFinancial();
			financial.setId(box.getInt("fYear"));
			/*HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
			hrMasFinancialYear.setId(box.getInt("fYear"));*/
			voucherHeader.setFYear(financial);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("SV");
			voucherHeader.setRejected("n");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			if(box.getInt("supplierId")!= 0){
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(box.getInt("supplierId"));
				voucherHeader.setSupplier(masStoreSupplier);
			}
			if(!box.getString("poNo").equals("")){
				voucherHeader.setPoNo(box.getString("poNo"))	;
			}
			if(!box.getString("poDate").equals("")){
				voucherHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box.getString("poDate")));
			}
			if(!box.getString("poAmount").equals("")){
				voucherHeader.setPoAmount(new BigDecimal(box.getString("poAmount")));
			}
			if(!box.getString("invoiceNo").equals("")){
				voucherHeader.setInvoiceNo(box.getString("invoiceNo"))	;
			}
			if(!box.getString("invoiceDate").equals("")){
				voucherHeader.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(box.getString("invoiceDate")));
			}
			if(!box.getString("invoiceAmount").equals("")){
				voucherHeader.setInvoiceAmount(new BigDecimal(box.getString("invoiceAmount")));
			}
			
			if (box.getInt("schemeId") != 0) {
				MasScheme masScheme = new MasScheme();
				masScheme.setId(box.getInt("schemeId"));
				voucherHeader.setScheme(masScheme);
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			System.out.println("--loc-->>"+ box.getInt("locationId"));
			System.out.println("--financial-->>"+ box.getInt("fYear"));
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "SV");
			paramMap.put("voucherType", "Sales");
			paramMap.put("financialYearId",box.getInt("fYear"));
			
			voucherNo = generateVoucherNo(paramMap);
			voucherHeader.setVoucherNo("SV/"+voucherNo);
			if(authLevel==0){
				authLevel=getAuthLevel(box.getInt("locationId"));
			}
			if(authLevel==1){
				voucherHeader.setAuthLevelOne("w");
			}else if(authLevel==2){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				
			}else if(authLevel==3){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				voucherHeader.setAuthLevelThree("w");
			}else if(authLevel==4){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				voucherHeader.setAuthLevelThree("w");
				voucherHeader.setAuthLevelFour("w");
			}
			int wardId=0;
			if(box.getInt("wardId")!=0){
				wardId=(box.getInt("wardId"));
			}
			if(wardId!=0){
			MasWard masWard=new MasWard();
			masWard.setId(wardId);
			voucherHeader.setWard(masWard);
			}
			hbt.save(voucherHeader);

			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				voucherDetails.setVoucherHeader(voucherHeader);
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				if(box.getInt(SUB_LEDGER_CODE_BANK+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+i));
					voucherDetails.setSubLed(subLed);
				}
				if(box.getInt(COST_CENTER_ID+i) != 0){
					MasCostCenter costCenter = new MasCostCenter();
					costCenter.setId(box.getInt(COST_CENTER_ID+i));
					voucherDetails.setCostCenter(costCenter);
				}
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				hbt.save(voucherDetails);
				updateTransaction(box.getInt(SUB_LEDGER_CODE+i), accountId, box.getInt("fYear"), box.getInt("locationId"), ""+crAmt, ""+drAmt);

//-------------------------update account group-------------------------------------------------
				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);
				
				int groupId = box.getInt("groupId"+i);
				int subGroupId = box.getInt("subGroupId"+i);

				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceDr() != null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
			 	if(faMasAccountGroup.getOpBalanceCr()!= null){
			 		groupOpBalanceCr = faMasAccountGroup.getOpBalanceCr();
			 	}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr = faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr = faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					 faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}
			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOpBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOpBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOpBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOpBalanceCr.add(subGroupYtdBalanceCr);
				if(drSubGroupAmount.compareTo(crSubGroupAmount)>0){
					accountSubGroup.setClBalanceDr(drSubGroupAmount.subtract(crSubGroupAmount));
					accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crSubGroupAmount.compareTo(drSubGroupAmount)>0){
					accountSubGroup.setClBalanceCr(crSubGroupAmount.subtract(drSubGroupAmount));
					accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crSubGroupAmount.compareTo(drSubGroupAmount)==0){
					accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
				}
			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		 if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
				if(drAccountAmount.compareTo(crAccountAmount)>0){
					masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
					masAccount.setClBalanceCr(new BigDecimal(0.00));
				}else if(crAccountAmount.compareTo(drAccountAmount)>0){
					masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
					masAccount.setClBalanceDr(new BigDecimal(0.00));
				}else if(crAccountAmount.compareTo(drAccountAmount)==0){
					masAccount.setClBalanceCr(new BigDecimal(0.00));
					masAccount.setClBalanceDr(new BigDecimal(0.00));
				}
				 hbt.update(masAccount);
				 
				//-----------------------update account sub ledger==================================
				 if(box.getInt(SUB_LEDGER_CODE_BANK+ i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
					 
					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					
					
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
					
					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
				 }
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}


		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);
		
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		paramMap.put("hospitalId", box.getInt("hospitalId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SV");
		paramMap.put("voucherType", "Sales");
		map.put("voucherNo", voucherNo);
		map.put("vhId", vhId);
		map.put("saved", saved);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSalesReturnVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();

		int vhId=0;
		int voucherNo=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int authLevel=0;
		if(box.getInt("authLevel")!=0){
			authLevel=box.getInt("authLevel");
		}

		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial hrMasFinancialYear = new MasStoreFinancial();
			hrMasFinancialYear.setId(box.getInt("fYear"));
			voucherHeader.setFYear(hrMasFinancialYear);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("SR");
			voucherHeader.setRejected("n");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			if(box.getInt("supplierId")!= 0){
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(box.getInt("supplierId"));
				voucherHeader.setSupplier(masStoreSupplier);
			}
			if(!box.getString("poNo").equals("")){
				voucherHeader.setPoNo(box.getString("poNo"))	;
			}
			if(!box.getString("poDate").equals("")){
				voucherHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box.getString("poDate")));
			}
			if(!box.getString("poAmount").equals("")){
				voucherHeader.setPoAmount(new BigDecimal(box.getString("poAmount")));
			}
			if(!box.getString("invoiceNo").equals("")){
				voucherHeader.setInvoiceNo(box.getString("invoiceNo"))	;
			}
			if(!box.getString("invoiceDate").equals("")){
				voucherHeader.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(box.getString("invoiceDate")));
			}
			if(!box.getString("invoiceAmount").equals("")){
				voucherHeader.setInvoiceAmount(new BigDecimal(box.getString("invoiceAmount")));
			}
			
			if (box.getInt("schemeId") != 0) {
				MasScheme masScheme = new MasScheme();
				masScheme.setId(box.getInt("schemeId"));
				voucherHeader.setScheme(masScheme);
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "SR");
			paramMap.put("voucherType", "SalesReturn");
			paramMap.put("financialYearId", box.getInt("fYear"));
			 voucherNo = generateVoucherNo(paramMap);
			voucherHeader.setVoucherNo("SRV/"+voucherNo);
			//----------commented by anamika on 13/08/2014------------------
			/*FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			faMasAccountSubGroup.setId(box.getInt("subGroupId"));
			voucherHeader.setAccountSubGroup(faMasAccountSubGroup);*/
			if(authLevel==0){
				authLevel=getAuthLevel(box.getInt("locationId"));
			}
			if(authLevel==1){
				voucherHeader.setAuthLevelOne("w");
			}else if(authLevel==2){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				
			}else if(authLevel==3){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				voucherHeader.setAuthLevelThree("w");
			}else if(authLevel==4){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				voucherHeader.setAuthLevelThree("w");
				voucherHeader.setAuthLevelFour("w");
			}
			int wardId=0;
			if(box.getInt("wardId")!=0){
				wardId=(box.getInt("wardId"));
			}
			if(wardId!=0){
			MasWard masWard=new MasWard();
			masWard.setId(wardId);
			voucherHeader.setWard(masWard);
			}
			hbt.save(voucherHeader);

			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				voucherDetails.setVoucherHeader(voucherHeader);
				System.out.println("account==="+box.getInt("accountId"+i));
				if(box.getInt("accountId"+i) != 0){
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				}
				if(box.getInt(SUB_LEDGER_CODE+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE+i));
					voucherDetails.setSubLed(subLed);
				}
				if(box.getInt(COST_CENTER_ID+i) != 0){
					MasCostCenter costCenter = new MasCostCenter();
					costCenter.setId(box.getInt(COST_CENTER_ID+i));
					voucherDetails.setCostCenter(costCenter);
				}
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				hbt.save(voucherDetails);
				updateTransaction(box.getInt(SUB_LEDGER_CODE+i), accountId, box.getInt("fYear"), box.getInt("locationId"), ""+crAmt, ""+drAmt);

//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);
				int groupId = box.getInt("groupId"+i);
				int subGroupId = box.getInt("subGroupId"+i);

				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceDr() != null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
			 	if(faMasAccountGroup.getOpBalanceCr()!= null){
			 		groupOpBalanceCr = faMasAccountGroup.getOpBalanceCr();
			 	}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr = faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr = faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					 faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}
			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);
				
				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOpBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOpBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOpBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOpBalanceCr.add(subGroupYtdBalanceCr);
					if(drSubGroupAmount.compareTo(crSubGroupAmount)>0){
						accountSubGroup.setClBalanceDr(drSubGroupAmount.subtract(crSubGroupAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crSubGroupAmount.compareTo(drSubGroupAmount)>0){
						accountSubGroup.setClBalanceCr(crSubGroupAmount.subtract(drSubGroupAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crSubGroupAmount.compareTo(drSubGroupAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}
			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
				BigDecimal crAccountAmount = new BigDecimal(0.0);
		 		
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						accountSubGroup.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						accountSubGroup.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}

		 		
				 hbt.update(masAccount);
				//-----------------------update account sub ledger==================================
				 if(box.getInt(SUB_LEDGER_CODE_BANK+ i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
					 
					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					
					
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
					
					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
				 }
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);
		
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		paramMap.put("hospitalId", box.getInt("hospitalId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SR");
		paramMap.put("voucherType", "SalesReturn");
		map.put("voucherNo", voucherNo);
		map.put("vhId", vhId);
		map.put("saved", saved);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		return map;
	}
		
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSalesReturnVoucherJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<Object[]> amountList = new ArrayList<Object[]>();
		List<MasWard>wardList=new ArrayList<MasWard>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		Session session = (Session)getSession();
		String fYearDesc = "";
		if(generalMap.get("fYearDesc")!= null){
			fYearDesc = (String)generalMap.get("fYearDesc");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		int fYear = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		amountList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("header.Hospital", "hospital")
				.createAlias("header.FYear", "fYear").add(Restrictions.eq("fYear.Id", fYear))
						.add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("header.VoucherType", "SR"))
						.setProjection(Projections.projectionList().add(
							Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
							Projections.groupProperty("header.VoucherType"))).list();

		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		wardList=session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);
		
		paramMap.put("hospitalId", hospitalId);
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SR");
		paramMap.put("voucherType", "SalesReturn");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("amountList", amountList);
		map.put("wardList",wardList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPurchaseVoucherJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<MasWard>wardList=new ArrayList<MasWard>();
		List<Object[]> amountList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		String fYearDesc = "";
		int hospitalId = 0;
		int fYear = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("fYearDesc")!= null){
			fYearDesc = (String)generalMap.get("fYearDesc");
		}
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		amountList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("header.Hospital", "hospital")
				.createAlias("header.FYear", "fYear").add(Restrictions.eq("fYear.Id", fYear))
						.add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("header.VoucherType", "PU"))
						.setProjection(Projections.projectionList().add(
							Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
							Projections.groupProperty("header.VoucherType"))).list();

		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		wardList=session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);
		
		paramMap.put("hospitalId", hospitalId);
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PU");
		paramMap.put("voucherType", "Purchase");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("amountList", amountList);
		map.put("wardList", wardList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPurchaseVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		int vhId=0;
		int voucherNo=0;
		boolean saved = false;
		int authLevel=0;
		if(box.getInt("authLevel")!=0){
			authLevel=box.getInt("authLevel");
		}

		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial hrMasFinancialYear= new MasStoreFinancial();
			hrMasFinancialYear.setId(box.getInt("fYear"));
			voucherHeader.setFYear(hrMasFinancialYear);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("PU");
			voucherHeader.setRejected("n");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			if(box.getInt("supplierId")!= 0){
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(box.getInt("supplierId"));
				voucherHeader.setSupplier(masStoreSupplier);
			}
			if(!box.getString("poNo").equals("")){
				voucherHeader.setPoNo(box.getString("poNo"))	;
			}
			if(!box.getString("poDate").equals("")){
				voucherHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box.getString("poDate")));
			}
			if(!box.getString("poAmount").equals("")){
				voucherHeader.setPoAmount(new BigDecimal(box.getString("poAmount")));
			}
			if(!box.getString("invoiceNo").equals("")){
				voucherHeader.setInvoiceNo(box.getString("invoiceNo"))	;
			}
			if(!box.getString("invoiceDate").equals("")){
				voucherHeader.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(box.getString("invoiceDate")));
			}
			if(!box.getString("invoiceAmount").equals("")){
				voucherHeader.setInvoiceAmount(new BigDecimal(box.getString("invoiceAmount")));
			}
			
			if (box.getInt("schemeId") != 0) {
				MasScheme masScheme = new MasScheme();
				masScheme.setId(box.getInt("schemeId"));
				voucherHeader.setScheme(masScheme);
			}
			
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "PU");
			paramMap.put("voucherType", "Purchase");
			paramMap.put("financialYearId",  box.getInt("fYear"));
			voucherNo = generateVoucherNo(paramMap);
			voucherHeader.setVoucherNo("PUV/"+voucherNo);
			//FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			//faMasAccountSubGroup.setId(box.getInt("subGroupId"));
			//voucherHeader.setAccountSubGroup(faMasAccountSubGroup);
			if(authLevel==0){
				authLevel=getAuthLevel(box.getInt("locationId"));
			}
			if(authLevel==1){
				voucherHeader.setAuthLevelOne("w");
			}else if(authLevel==2){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				
			}else if(authLevel==3){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				voucherHeader.setAuthLevelThree("w");
			}else if(authLevel==4){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				voucherHeader.setAuthLevelThree("w");
				voucherHeader.setAuthLevelFour("w");
			}
			int wardId=0;
			if(box.getInt("wardId")!=0){
				wardId=(box.getInt("wardId"));
			}
			if(wardId!=0){
			MasWard masWard=new MasWard();
			masWard.setId(wardId);
			voucherHeader.setWard(masWard);
			}
			hbt.save(voucherHeader);

			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				voucherDetails.setVoucherHeader(voucherHeader);
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				if(box.getInt(SUB_LEDGER_CODE_BANK+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+i));
					voucherDetails.setSubLed(subLed);
				}
				if(box.getInt(COST_CENTER_ID+i) != 0){
					MasCostCenter costCenter = new MasCostCenter();
					costCenter.setId(box.getInt(COST_CENTER_ID+i));
					voucherDetails.setCostCenter(costCenter);
				}
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				hbt.save(voucherDetails);
				updateTransaction(box.getInt(SUB_LEDGER_CODE+i), accountId, box.getInt("fYear"), box.getInt("locationId"), ""+crAmt, ""+drAmt);

//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);
				int groupId = box.getInt("groupId"+i);
				int subGroupId = box.getInt("subGroupId"+i);

				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceDr() != null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
			 	if(faMasAccountGroup.getOpBalanceCr()!= null){
			 		groupOpBalanceCr = faMasAccountGroup.getOpBalanceCr();
			 	}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr = faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr = faMasAccountGroup.getYtdAmountCr();
				}
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);

				 }
				 drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				 crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						 faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}
			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOpBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOpBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOpBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOpBalanceCr.add(subGroupYtdBalanceCr);
					if(drSubGroupAmount.compareTo(crSubGroupAmount)>0){
						accountSubGroup.setClBalanceDr(drSubGroupAmount.subtract(crSubGroupAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crSubGroupAmount.compareTo(drSubGroupAmount)>0){
						accountSubGroup.setClBalanceCr(crSubGroupAmount.subtract(drSubGroupAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crSubGroupAmount.compareTo(drSubGroupAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}
			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount= new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
		 		 
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}
				 hbt.update(masAccount);
				 
				//-----------------------update account sub ledger==================================
				 if(box.getInt(SUB_LEDGER_CODE_BANK+ i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
					 
					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					
					
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
					
					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
				 }
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		

		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);

		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		paramMap.put("hospitalId", box.getInt("hospitalId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PU");
		paramMap.put("voucherType", "Purchase");
		//int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("vhId", vhId);
		map.put("saved", saved);
		map.put("supplierList", supplierList);
		map.put("costCenterList", costCenterList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPurchaseReturnVoucherJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<MasWard>wardList=new ArrayList<MasWard>();
		List<Object[]> amountList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		String fYearDesc = "";
		if(generalMap.get("fYearDesc")!= null){
			fYearDesc = (String)generalMap.get("fYearDesc");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		int fYear = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		amountList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("header.Hospital", "hospital")
				.createAlias("header.FYear", "fYear").add(Restrictions.eq("fYear.Id", fYear))
						.add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("header.VoucherType", "PR"))
						.setProjection(Projections.projectionList().add(
							Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
							Projections.groupProperty("header.VoucherType"))).list();

		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);
		wardList=session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		paramMap.put("hospitalId", hospitalId);
		paramMap.put("suffix", fYearDesc);
		paramMap.put("flag", "display");
		paramMap.put("prefix", "PR");
		paramMap.put("voucherType", "PurchaseReturn");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		map.put("amountList", amountList);
		map.put("wardList",wardList);
		return map;
	}


	public Map<String, Object> showAccountSubGroup(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<Integer> lastSubGroupCodeList = new ArrayList<Integer>();
		int accountGroupId = 0;
		int fYear = 0;
		if(generalMap.get("accountGroupId")!= null){
			accountGroupId = (Integer)generalMap.get("accountGroupId");
		}
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId")!= null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		Session session = (Session)getSession();
		lastSubGroupCodeList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Hospital.Id", hospitalId))
		.setProjection(Projections.projectionList().add(
				Projections.max("AccountSubGroupCode"))).list();
		
		if(lastSubGroupCodeList.size()>0){
			int lastSubGroupCode = 0;
			if(lastSubGroupCodeList.get(0) != null){
			 lastSubGroupCode = (lastSubGroupCodeList.get(0));
			}
			map.put("lastSubGroupCode", lastSubGroupCode);
		}
		Criteria crit = null;

		crit = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
									.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId));
								
		if(accountGroupId != 0){
			crit = crit.createAlias("AccountGroup", "group").add(Restrictions.eq("group.Id", accountGroupId));
		}
		accountSubGrpList = crit.list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> addAccountSubGroup(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> existingAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		//List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<Integer> lastSubGroupCodeList = new ArrayList<Integer>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int  fYear = 0;
		String message = "";
		int hospitalId = 0;
		try {
			FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			if(generalMap.get("faMasAccountSubGroup")!= null){
				faMasAccountSubGroup = (FaMasAccountSubGroup)generalMap.get("faMasAccountSubGroup");
			}
			if(generalMap.get("fYear")!= null){
				fYear = (Integer)generalMap.get("fYear");
			}
			if(generalMap.get("hospitalId")!= null){
				hospitalId = (Integer)generalMap.get("hospitalId");
			}
			Integer accountSubGroupCode = faMasAccountSubGroup.getAccountSubGroupCode();
			//String accountSubGroupName = faMasAccountSubGroup.getAccountSubGroupName();
			
			/*int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}*/
			
			existingAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("AccountSubGroupCode", accountSubGroupCode))
											.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			if (existingAccountSubGroupList.size() > 0) {
				message = "Record already Exist";
			} else {
				
				hbt.save(faMasAccountSubGroup);
				message = "Record saved sucessfully!";

			}
			lastSubGroupCodeList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("FYear.Id", fYear))
									.add(Restrictions.eq("Hospital.Id", hospitalId))
											.setProjection(Projections.projectionList().add(
														Projections.max("AccountSubGroupCode"))).list();

			if(lastSubGroupCodeList.size()>0){
			int lastSubGroupCode = lastSubGroupCodeList.get(0);
			map.put("lastSubGroupCode", lastSubGroupCode);
			}
			accountSubGrpList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
								.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("message", message);
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateAccountSubGroup(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> existingAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		//List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<Integer> lastSubGroupCodeList = new ArrayList<Integer>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//int  financialYearId = 0;
		String message = "";
		try {
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			int subGroupId = 0;
			if(generalMap.get("subGroupId") != null){
				subGroupId = (Integer)generalMap.get("subGroupId");
			}
			int accountSubGroupCode = 0;
			if(generalMap.get("accountSubGroupCode") != null){
				accountSubGroupCode = (Integer)generalMap.get("accountSubGroupCode");
			}
			String accounSubGroupName = "";
			if(generalMap.get("accounSubGroupName") != null){
				accounSubGroupName = (String)generalMap.get("accounSubGroupName");
			}
			
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			int changedBy = 0;
			if(generalMap.get("changedBy")!= null){
				changedBy = (Integer)generalMap.get("changedBy");
			}
			int fYear = 0; 
			if(generalMap.get("fYear") != null){
				fYear = (Integer)generalMap.get("fYear");
			}
			int hospitalId = 0;
			if(generalMap.get("hospitalId") != null){
				hospitalId = (Integer)generalMap.get("hospitalId");
			}
			lastSubGroupCodeList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId))
			.setProjection(Projections.projectionList().add(
					Projections.max("AccountSubGroupCode"))).list();
			
			if(lastSubGroupCodeList.size()>0){
				int lastSubGroupCode = lastSubGroupCodeList.get(0);
				map.put("lastSubGroupCode", lastSubGroupCode);
			}
			existingAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("AccountSubGroupName", accounSubGroupName))
											.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			if (existingAccountSubGroupList.size() > 0) {
				message = "Record already Exist";
			} else {
				FaMasAccountSubGroup faMasAccountSubGroup =(FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				faMasAccountSubGroup.setAccountSubGroupCode(accountSubGroupCode);
				faMasAccountSubGroup.setAccountSubGroupName(accounSubGroupName);
				FaMasAccountGroup accountGroup = new FaMasAccountGroup();
				accountGroup.setId(groupId);
				faMasAccountSubGroup.setAccountGroup(accountGroup);
				 Users user = new Users();
				 user.setId(changedBy);
				 faMasAccountSubGroup.setLastChgBy(user);
				 faMasAccountSubGroup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
				 faMasAccountSubGroup.setLastChgTime(time);
				 faMasAccountSubGroup.setStatus("y");
				 hbt.update(faMasAccountSubGroup);
				message = "Record update sucessfully!";

			}
			accountSubGrpList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
			.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
							.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("message", message);
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> editAccountSubGroup(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		int fYear = 0; 
		if(generalMap.get("fYear") != null){
			fYear = (Integer)generalMap.get("fYear");
		}
		int accountSubGroupId = 0;
		if(generalMap.get("accountSubGroupId") != null){
			accountSubGroupId = (Integer)generalMap.get("accountSubGroupId");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId") != null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		List<FaMasAccountSubGroup> accountSubGroupIdList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.idEq(accountSubGroupId)).list();
		accountSubGrpList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
									.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id",hospitalId)).list();
		accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								.add(Restrictions.eq("FYear.Id", fYear)).add(Restrictions.eq("Hospital.Id",hospitalId)).list();
		map.put("accountGroupList", accountGroupList);
		map.put("accountSubGrpList", accountSubGrpList);
		map.put("accountSubGroupIdList", accountSubGroupIdList);
		return map;
	}
	public Map<String, Object> showAccountSubGroupBalance(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<Object[]> accountSubGrpList = new ArrayList<Object[]>();
		
		int branchId = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		Session session = (Session)getSession();
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.eq("Status", "y"))
									.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}
		String qry = "select ma.account_sub_group_id,ma.account_sub_group_code,ma.account_sub_group_name," +
						" sum(isnull(v.dr_amount,0))as dr_amount ,sum(isnull(v.cr_amount,0))as cr_amount, " +
						" sum(isnull(v.opening_amt_cr,0))as opening_amt_cr,sum(isnull(v.opening_amt_dr,0))as opening_amt_dr," +
						" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))as TotalDr," +
						" (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) as TotalCR, " +
						" DrBalance=case  when (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
						" > (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0)))  then (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
						" - (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) end, " +
						" CrBalance=case when (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) > " +
						" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) then (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
						" - (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
						" else 0 end, v.branch_id,v.f_year_id  from vwFinalAccountsBalance v " +
						" right outer join fa_mas_account_sub_group ma on v.account_sub_group_id= ma.account_sub_group_id  " +
						" where v.branch_id = "+branchId+" and v.f_year_id = "+fYear+" group by ma.account_sub_group_id,ma.account_sub_group_code,ma.account_sub_group_name " +
						" ,v.branch_id,v.f_year_id";
		accountSubGrpList =session.createSQLQuery(qry).list();
		
		/*Criteria crit = null;

		crit = session.createCriteria(FaMasAccountSubGroup.class);
								
		if(accountId != 0){
			crit = crit.createAlias("AccountGroup", "group").add(Restrictions.eq("group.Id", accountId));
		}
		accountSubGrpList = crit.list();*/
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}

	

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountSubGroup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> accountSubGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = getSession();
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);
		
		/*int fYear = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}*/
		/*String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		String currentYear = currentDate.substring(6, 10);
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("YearDescription", currentYear))
						.add(Restrictions.eq("Status", "y"))
						.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}*/
		crit = session.createCriteria(FaMasAccountSubGroup.class);
					
		if (searchRadio == 1) {
			crit = crit.add(Restrictions.eq("AccountSubGroupCode", Integer.parseInt(searchField)));

		} else {
			crit = crit.add(Restrictions.ilike("AccountSubGroupName", searchField+"%"));
		}

		accountSubGrpList = crit.list();
		map.put("accountSubGrpList", accountSubGrpList);
		return map;
	}


	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountSubLedgerJsp(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridAccGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridSubAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> gridaccList = new ArrayList<FaMasAccount>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasEmployee>employeeListJphn=new ArrayList<MasEmployee>();
		List<MasEmployee>employeeListJhi=new ArrayList<MasEmployee>();
		List<MasWard>wardList=new ArrayList<MasWard>();
		Session session = (Session)getSession();
		int fYear = 1;
		if(detailsMap.get("fYear") != null){
			fYear = (Integer)detailsMap.get("fYear");
		}
		int locationId = 0;
		int hospitalid=0;
		if(detailsMap.get("locationId") != null){
			locationId = (Integer)detailsMap.get("locationId");
		}
		
		if(detailsMap.get(RequestConstants.HOSPITAL_ID) != null){
			hospitalid = (Integer)detailsMap.get(RequestConstants.HOSPITAL_ID);
		}

		try{

			subLedList = session.createCriteria(FaMasSubLed.class).createAlias("FYear", "fy")
							/*.add(Restrictions.eq("fy.Id", fYear))
							.add(Restrictions.eq("Hospital.Id", hospitalid))*/.add(Restrictions.eq("Hospital.Id", locationId)).list();

			accGrpList =session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
							.add(Restrictions.eq("fy.Id", fYear))
							/*.add(Restrictions.eq("Hospital.Id", locationId))*/
							.list();
			gridAccGrpList=session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", fYear))
					/*.add(Restrictions.eq("Hospital.Id", locationId))*/
					.list();

			subAccGrpList =session.createCriteria(FaMasAccountSubGroup.class)
					.createAlias("FYear", "fy")
							.add(Restrictions.eq("fy.Id", fYear))
							/*.add(Restrictions.eq("Hospital.Id", locationId))*/
							.list();
			gridSubAccGrpList=session.createCriteria(FaMasAccountSubGroup.class)
					.createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", fYear))
					/*.add(Restrictions.eq("Hospital.Id", locationId))*/
					.list();
			accList =session.createCriteria(FaMasAccount.class)
					/*//.createAlias("FYear", "fy")
							.add(Restrictions.eq("fy.Id", fYear))
					.add(Restrictions.eq("Hospital.Id", hospitalid))
							.add(Restrictions.eq("SubLedger", "y"))*/
					.addOrder(Order.asc("AccDesc"))
							.list();
			
			gridaccList=session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", fYear))
					.add(Restrictions.eq("Hospital.Id", hospitalid))
					.add(Restrictions.eq("SubLedger", "y")).list();
			hospitalList=session.createCriteria(MasHospital.class)
//					.add(Restrictions.ne("UnitType", "HO"))
					.add(Restrictions.eq("Status", "y")).list();
			Object[] selectdIdJPHN={251,252};
			Object[] selectdIdJHI={404,405};
			employeeListJphn=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", locationId))
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.in("Rank.Id", selectdIdJPHN))		
							.list();
			employeeListJhi=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", locationId))
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.in("Rank.Id", selectdIdJHI))		
							.list();
			map.put("subLedList", subLedList);
			map.put("accGrpList", accGrpList);
			map.put("subAccGrpList", subAccGrpList);
			map.put("gridAccGrpList",gridAccGrpList);
			map.put("gridSubAccGrpList",gridSubAccGrpList);
			map.put("gridaccList",gridaccList);
			map.put("accList", accList);
			map.put("employeeListJphn", employeeListJphn);
			map.put("employeeListJhi", employeeListJhi);
			map.put("wardList",wardList);
			map.put("hospitalList", hospitalList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}


	
	public Map<String, Object> showAccountSubLedgerBalance(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> subLedgerBalanceList = new ArrayList<Object[]>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		int branchId = 0;
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
							.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
								.add(Restrictions.eq("Status", "y"))
									.list();
		int fYear = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear financialYear : financialYearList){
				fYear = financialYear.getId();
			}
		}
		String qry = "select ma.sub_led_id,ma.sub_led_code,ma.sub_led_desc," +
				" sum(isnull(v.dr_amount,0))as dr_amount ,sum(isnull(v.cr_amount,0))as cr_amount, " +
				" sum(isnull(v.opening_amt_cr,0))as opening_amt_cr,sum(isnull(v.opening_amt_dr,0))as opening_amt_dr," +
				" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0)))as TotalDr, " +
				" (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) as TotalCR," +
				" DrBalance=case when (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
				" > (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
				" then (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
				" - (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
				" end, CrBalance=case when (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) " +
				" > (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) " +
				" then (sum(isnull(v.cr_amount,0)) +  sum(isnull(v.opening_amt_cr,0))) - " +
				" (sum(isnull(v.dr_amount,0))+ sum(isnull(v.opening_amt_dr,0))) else 0 " +
				" end, v.branch_id,v.f_year_id from vwFinalAccountsBalance v right outer join fa_mas_sub_led ma on " +
				" v.sub_led_id= ma.sub_led_id where v.branch_id = "+branchId+" and v.f_year_id = "+fYear+"  group by ma.sub_led_id,ma.sub_led_code,ma.sub_led_desc " +
				" ,v.branch_id,v.f_year_id";
		subLedgerBalanceList =session.createSQLQuery(qry).list();
		map.put("subLedgerBalanceList", subLedgerBalanceList);
		return map;
	}
	

	



	/*@SuppressWarnings("unchecked")
	public Map<String, Object> showJournalVoucherJsp(Box box) {
		System.out.println("inside method");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		Session session = (Session)getSession();
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		System.out.println("costCenterList==="+costCenterList.size());
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("hospitalId", box.getInt("hospitalId"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "JV");
		paramMap.put("voucherType", "Journal");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("voucherNo", voucherNo);
		map.put("costCenterList", costCenterList);
		return map;
	}
	*/
	@SuppressWarnings("unchecked")
	private synchronized int  generateVoucherNo(Map<String, Object> paramMap) {
		int voucherNo = 0;
		int tsn = 0;
		int id= 0;
		String suffix = "";
		String prefix = "";
		String voucherType = "";
		String flag = "";
		int locationId = 0;
		if(paramMap.get("suffix") != null){
			suffix = (String)paramMap.get("suffix");
		}
		if(paramMap.get("prefix") != null){
			prefix = (String)paramMap.get("prefix");
		}
		if(paramMap.get("voucherType") != null){
			voucherType = (String)paramMap.get("voucherType");
		}
		if(paramMap.get("flag") != null){
			flag = (String)paramMap.get("flag");
		}
		if(paramMap.get("locationId") != null){
			locationId = (Integer)paramMap.get("locationId");
		}
//		paramMap.put("financialYearId", box.getInt("fYear"));
		int financialYearId=0;
		if(paramMap.get("financialYearId")!=null){
			financialYearId=(Integer)paramMap.get("financialYearId");
		}
		Session session = getSession();
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();
		List<MasStoreFinancial> MasStoreFinancialList = new ArrayList<MasStoreFinancial>();
		MasStoreFinancialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(financialYearId)).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		seqNoList = session.createCriteria(TransactionSequence.class)
						/*.add(Restrictions.eq("TransactionPrefix", prefix))
						.add(Restrictions.eq("TransactionSuffix", suffix))*/
						.add(Restrictions.eq("VoucherType", voucherType))
						.add(Restrictions.eq("Hospital.Id", locationId))
						.add(Restrictions.eq("FYear.Id", financialYearId))
						.list();
		System.out.println("----seqNoList------>"+seqNoList.size());
		if(seqNoList.size() > 0){
				for (TransactionSequence transactionSequence : seqNoList) {
					tsn = Integer.parseInt("" + transactionSequence.getTransactionSequenceNumber());
					id = transactionSequence.getId();
				}
				if(flag.equals("save")){
					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt.load(TransactionSequence.class, id);
					transactionSequenceObj.setTransactionSequenceNumber(tsn + 1);
					hbt.update(transactionSequenceObj);
				}
				voucherNo = tsn+1;
		}else{
			if(flag.equals("save")){
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("FaVoucherHeader");
				tsObj.setTransactionPrefix(prefix);
				tsObj.setTransactionSequenceName(voucherType+" Voucher No");
				for(MasStoreFinancial MSF:MasStoreFinancialList){
					suffix=MSF.getYearDescription();
				}
				tsObj.setTransactionSuffix(suffix);
				tsObj.setVoucherType(voucherType);
				tsObj.setTransactionSequenceNumber(1);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(locationId);
				tsObj.setHospital(masHospital);
				MasStoreFinancial mf=new MasStoreFinancial();
				mf.setId(financialYearId);
				tsObj.setFYear(mf);

				//tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				voucherNo = tsObj.getTransactionSequenceNumber();
			}else{
				voucherNo = 1;
			}

		}

		return voucherNo;
	}
	
	
	/*public Map<String, Object> submitJournalVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int vhId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int voucherNo=0;
		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			HrMasFinancialYear hrMasFinancialYear =new HrMasFinancialYear();
			hrMasFinancialYear.setId(box.getInt("fYear"));
			voucherHeader.setFYear(hrMasFinancialYear);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("JV");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			paramMap.put("hospitalId", box.getInt("hospitalId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "JV");
			paramMap.put("voucherType", "Journal");
			voucherNo = generateVoucherNo(paramMap);
			//voucherHeader.setVoucherNo(voucherNo);
			
			hbt.save(voucherHeader);
			
			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(voucherHeader);
				if(box.getInt(SUB_LEDGER_CODE_BANK+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+i));
					voucherDetails.setSubLed(subLed);
					
				}
				if(box.getInt(COST_CENTER_ID+i) != 0){
					MasCostCenter costCenter = new MasCostCenter();
					costCenter.setId(box.getInt(COST_CENTER_ID+i));
					voucherDetails.setCostCenter(costCenter);
				}
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				
				hbt.save(voucherDetails);


//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);
				
				int groupId = box.getInt("groupId"+i);
				int subGroupId = box.getInt("subGroupId"+i);

				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}

		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 if(accountClosingBalanceCr.compareTo(new BigDecimal(0)) > 0){
					 	 if(accountClosingBalanceCr.compareTo(drAmt) > 0 ){
					 		accountClosingBalanceCr = accountClosingBalanceCr.subtract(drAmt);
					 		masAccount.setClBalanceCr(accountClosingBalanceCr);
					 		masAccount.setClBalanceDr(new BigDecimal(0.00));
					 	 }else if(drAmt.compareTo(accountClosingBalanceCr) > 0 ){
					 		accountClosingBalanceDr =drAmt.subtract(accountClosingBalanceCr);
					 		masAccount.setClBalanceDr(accountClosingBalanceDr);
					 		masAccount.setClBalanceCr(new BigDecimal(0.00));
					 	 }
					 }else {
					 		  accountClosingBalanceDr = accountClosingBalanceDr.add(drAmt);
					 		 masAccount.setClBalanceDr(accountClosingBalanceDr);
						  }

				}else if(crAmt.compareTo(new BigDecimal(0))>0){
					if(accountClosingBalanceDr.compareTo(new BigDecimal(0)) > 0){
					  if(accountClosingBalanceDr.compareTo(crAmt) > 0){
						  accountClosingBalanceDr =accountClosingBalanceDr.subtract(crAmt);
						  masAccount.setClBalanceDr(accountClosingBalanceDr);
						  masAccount.setClBalanceCr(new BigDecimal(0.00));
					  }else if(crAmt.compareTo(accountClosingBalanceDr) > 0 ){
						  accountClosingBalanceCr =crAmt.subtract(accountClosingBalanceDr);
						  masAccount.setClBalanceCr(accountClosingBalanceCr);
						  masAccount.setClBalanceDr(new BigDecimal(0.00));
					 	 }
					}else{
						accountClosingBalanceCr = accountClosingBalanceCr.add(crAmt);
						masAccount.setClBalanceCr(accountClosingBalanceCr);
					  }
				}
				 
				 hbt.update(masAccount);
				//-----------------------update account sub ledger==================================
				 if(box.getInt(SUB_LEDGER_CODE_BANK+ i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
					 
					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					
					
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
					
					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
				 }
				 
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		map = showJournalVoucherJsp(box);
		map.put("saved", saved);
		map.put("vhId", vhId);
		map.put("voucherNo", voucherNo);
		
		return map;
	}
*/
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPurchaseReturnVoucher(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		int vhId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;
		int authLevel=0;
		if(box.getInt("authLevel")!=0){
			authLevel=box.getInt("authLevel");
		}

		try {
			tx = session.beginTransaction();
			FaVoucherHeader voucherHeader = new FaVoucherHeader();
			MasStoreFinancial hrMasFinancialYear = new MasStoreFinancial();
			hrMasFinancialYear.setId(box.getInt("fYear"));
			voucherHeader.setFYear(hrMasFinancialYear);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("locationId"));
			voucherHeader.setHospital(hospital);
			voucherHeader.setVoucherType("PR");
			voucherHeader.setRejected("n");
			voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			voucherHeader.setStatus("y");
			voucherHeader.setNarration(box.getString(NARRATION));
			if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
				voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
			}
			if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
				voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
			}
			if(box.getInt("supplierId")!= 0){
				MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
				masStoreSupplier.setId(box.getInt("supplierId"));
				voucherHeader.setSupplier(masStoreSupplier);
			}
			if(!box.getString("poNo").equals("")){
				voucherHeader.setPoNo(box.getString("poNo"))	;
			}
			if(!box.getString("poDate").equals("")){
				voucherHeader.setPoDate(HMSUtil.convertStringTypeDateToDateType(box.getString("poDate")));
			}
			if(!box.getString("poAmount").equals("")){
				voucherHeader.setPoAmount(new BigDecimal(box.getString("poAmount")));
			}
			if(!box.getString("invoiceNo").equals("")){
				voucherHeader.setInvoiceNo(box.getString("invoiceNo"))	;
			}
			if(!box.getString("invoiceDate").equals("")){
				voucherHeader.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(box.getString("invoiceDate")));
			}
			if(!box.getString("invoiceAmount").equals("")){
				voucherHeader.setInvoiceAmount(new BigDecimal(box.getString("invoiceAmount")));
			}
			
			if (box.getInt("schemeId") != 0) {
				MasScheme masScheme = new MasScheme();
				masScheme.setId(box.getInt("schemeId"));
				voucherHeader.setScheme(masScheme);
			}
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			voucherHeader.setLastChgBy(user);

			voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "PR");
			paramMap.put("voucherType", "PurchaseReturn");
			paramMap.put("financialYearId",box.getInt("fYear"));
			int voucherNo = generateVoucherNo(paramMap);
			voucherHeader.setVoucherNo("PRV/"+voucherNo);
			//------------commented by anamika on 13/08/2014--------------------
			//FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			//faMasAccountSubGroup.setId(box.getInt("subGroupId"));
			//voucherHeader.setAccountSubGroup(faMasAccountSubGroup);
			if(authLevel==0){
				authLevel=getAuthLevel(box.getInt("locationId"));
			}
			if(authLevel==1){
				voucherHeader.setAuthLevelOne("w");
			}else if(authLevel==2){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				
			}else if(authLevel==3){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				voucherHeader.setAuthLevelThree("w");
			}else if(authLevel==4){
				voucherHeader.setAuthLevelOne("w");
				voucherHeader.setAuthLevelTwo("w");
				voucherHeader.setAuthLevelThree("w");
				voucherHeader.setAuthLevelFour("w");
			}
			int wardId=0;
			if(box.getInt("wardId")!=0){
				wardId=(box.getInt("wardId"));
			}
			if(wardId!=0){
			MasWard masWard=new MasWard();
			masWard.setId(wardId);
			voucherHeader.setWard(masWard);
			}
			hbt.save(voucherHeader);

			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				voucherDetails.setVoucherHeader(voucherHeader);
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accountId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				if(box.getInt(SUB_LEDGER_CODE_BANK+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+i));
					voucherDetails.setSubLed(subLed);
				}
				if(box.getInt(COST_CENTER_ID+i) != 0){
					MasCostCenter costCenter = new MasCostCenter();
					costCenter.setId(box.getInt(COST_CENTER_ID+i));
					voucherDetails.setCostCenter(costCenter);
				}
				voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
				voucherDetails.setReconcile("n");
				if(!box.getString(CR_AMOUNT+i).equals("")){
					crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString(DR_AMOUNT+i).equals("")){
					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					voucherDetails.setDrAmount(drAmt);
				}
				hbt.save(voucherDetails);


//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drGroupAmount = new BigDecimal(0);
				BigDecimal crGroupAmount = new BigDecimal(0);
				int groupId = box.getInt("groupId"+i);
				int subGroupId = box.getInt("subGroupId"+i);

				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceDr() != null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
			 	if(faMasAccountGroup.getOpBalanceCr()!= null){
			 		groupOpBalanceCr = faMasAccountGroup.getOpBalanceCr();
			 	}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr = faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr = faMasAccountGroup.getYtdAmountCr();
				}
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);

				 }
				 crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				 drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
					
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}
			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOpBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOpBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOpBalanceCr.add(subGroupYtdBalanceCr);
				 crSubGroupAmount = subGroupOpBalanceDr.add(subGroupYtdBalanceDr);
					
					if(drSubGroupAmount.compareTo(crSubGroupAmount)>0){
						accountSubGroup.setClBalanceDr(drSubGroupAmount.subtract(crSubGroupAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crSubGroupAmount.compareTo(drSubGroupAmount)>0){
						accountSubGroup.setClBalanceCr(crSubGroupAmount.subtract(drSubGroupAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crSubGroupAmount.compareTo(drSubGroupAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}
			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
				 crAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
					
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}
				 hbt.update(masAccount);
				//-----------------------update account sub ledger==================================
				 if(box.getInt(SUB_LEDGER_CODE_BANK+ i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
					 
					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }
					
					
					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
					
					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);
				 }
			}
			vhId=voucherHeader.getId();
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
		masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masSchemeList", masSchemeList);
		costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		paramMap.put("hospitalId", box.getInt("hospitalId"));
		paramMap.put("suffix", box.getString("fYearDesc"));
		paramMap.put("flag", "display");
		paramMap.put("prefix", "SR");
		paramMap.put("voucherType", "SalesReturn");
		int voucherNo = generateVoucherNo(paramMap);
		map.put("vhId", vhId);
		map.put("voucherNo", voucherNo);
		map.put("saved", saved);
		map.put("costCenterList", costCenterList);
		map.put("supplierList", supplierList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountOpeningJsp(int branchId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		List<Integer> maxAccOpeningList = new ArrayList<Integer>();
		List<String> accountOpeningList = new ArrayList<String>();
		List<FaAccountOpening> faAccountOpeningList = new ArrayList<FaAccountOpening>();
		Session session = (Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).list();
		subLedList = session.createCriteria(FaMasSubLed.class).list();
		String currentDate = HMSUtil.convertDateToStringTypeDate(new Date());
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
		.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(currentDate)))
			.add(Restrictions.eq("Status", "y"))
				.list();
		String financialYear = "";
		String branchCode = "";
		if(financialYearList.size()>0){
			for(HrMasFinancialYear fYear : financialYearList){
				financialYear = fYear.getFinancialYear();
			}
		}
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.idEq(branchId)).add(Restrictions.eq("Status", "y")).list();
		if(branchList.size()>0){
			for(MasBranch masBranch :branchList){
				branchCode = masBranch.getBranchCode();
			}
		} 
		maxAccOpeningList = session.createCriteria(FaAccountOpening.class).setProjection(Projections.max("Id")).list();
		int maxAccOpeningId = 0;
		
		String openingNo = "";
		if(maxAccOpeningList.size() > 0 && maxAccOpeningList.get(0)!= null){
			maxAccOpeningId = maxAccOpeningList.get(0);
		
			accountOpeningList = session.createCriteria(FaAccountOpening.class)
					.add(Restrictions.idEq(maxAccOpeningId))
					.setProjection(Projections.property("OpeningNo")).list();
		if(accountOpeningList.size() > 0){
			String opNo =accountOpeningList.get(0);
			String autoNo = opNo.substring(opNo.lastIndexOf("/")+1);
			int accOpNo = Integer.parseInt(autoNo);
			Integer aNo = accOpNo+1;
			openingNo =  financialYear+"/"+branchCode+"/"+ aNo.toString();
		//accCode = Integer.parseInt(accountOpeningList.get(0).toString())+1;
		}
		
		}else{
		
		 openingNo = financialYear+"/"+branchCode+"/"+ 1;
		}
		//String openingNo = financialYear+"/"+branchCode+"/"+ 1;
		faAccountOpeningList = session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("Branch.Id", branchId)).list();
		map.put("accountList", accountList);
		map.put("subLedList", subLedList);
		map.put("openingNo", openingNo);
		map.put("faAccountOpeningList", faAccountOpeningList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveAccountOpening(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		List<Integer> maxAccOpeningList = new ArrayList<Integer>();
		List<String> accountOpeningList = new ArrayList<String>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaAccountOpening> faAccountOpeningList = new ArrayList<FaAccountOpening>();
		List<FaAccountOpening> existingAccountOpeningList = new ArrayList<FaAccountOpening>();
		Session session = (Session)getSession();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		HibernateTemplate hbt = getHibernateTemplate();
		boolean saved = false;
		String openingNo = "";
		String message = "";
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			String openingDate = (box.getString(OPENING_DATE));
			financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
									.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
										.add(Restrictions.eq("Status", "y")).list();
			String financialYear = "";
			String branchCode = "";
			int financialYearId = 0;
			if(financialYearList.size()>0){
				for(HrMasFinancialYear fYear : financialYearList){
					financialYear = fYear.getFinancialYear();
					financialYearId = fYear.getId();
				}
			}
			branchList = session.createCriteria(MasBranch.class).add(Restrictions.idEq(box.getInt("branchId"))).add(Restrictions.eq("Status", "y")).list();
			if(branchList.size()>0){
				for(MasBranch masBranch :branchList){
					branchCode = masBranch.getBranchCode();
				}
			}
			maxAccOpeningList = session.createCriteria(FaAccountOpening.class).setProjection(Projections.max("Id")).list();
				int maxAccOpeningId = 0;
				if(maxAccOpeningList.size() > 0 && maxAccOpeningList.get(0)!= null){
					maxAccOpeningId = maxAccOpeningList.get(0);
				
					accountOpeningList = session.createCriteria(FaAccountOpening.class)
							.add(Restrictions.idEq(maxAccOpeningId))
							.setProjection(Projections.property("OpeningNo")).list();
				if(accountOpeningList.size() > 0){
					String opNo =accountOpeningList.get(0);
					String autoNo = opNo.substring(opNo.lastIndexOf("/")+1);
					int accOpNo = Integer.parseInt(autoNo);
					Integer aNo = accOpNo+1;
					openingNo =  financialYear+"/"+branchCode+"/"+ aNo.toString();
				//accCode = Integer.parseInt(accountOpeningList.get(0).toString())+1;
				}
				
				}else{
				
				 openingNo = financialYear+"/"+branchCode+"/"+ 1;
				}
				FaAccountOpening accountOpening = new FaAccountOpening();
				if(box.getInt(ACCOUNT_ID)!= 0){
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(box.getInt(ACCOUNT_ID));
					accountOpening.setAccount(masAccount);
				}
				if(box.getInt(SUBLEDGER_ID)!= 0){
					FaMasSubLed masSubLed = new FaMasSubLed();
					masSubLed.setId(box.getInt(SUBLEDGER_ID));
					accountOpening.setSubLedger(masSubLed);
				}
				if(!box.getString(OPENING_DATE).equals("")){
					accountOpening.setOpeningDate(HMSUtil.convertStringTypeDateToDateType(box.getString(OPENING_DATE)));
				}
				String accountType = "";
				if(!box.getString("accountType").equals("")){
					accountType = box.getString("accountType");
				}
				BigDecimal opBalanceCr = new BigDecimal(0.0);
				BigDecimal opBalanceDr = new BigDecimal(0.0);
				if(accountType.equals("Dr")){
				if (!box.getString(OPENING_BALANCE).equals("")) {
					opBalanceDr = new BigDecimal(box.getString(OPENING_BALANCE));
					accountOpening.setOpeningAmtDr(opBalanceDr);
				}
				}else{
					opBalanceCr = new BigDecimal(box.getString(OPENING_BALANCE));
					accountOpening.setOpeningAmtCr(opBalanceCr);
				}
				
				if(box.getInt("hospitalId")!= 0){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					accountOpening.setHospital(masHospital);
				}
				accountOpening.setOpeningNo(openingNo);
				Users users = new Users();
				users.setId(box.getInt("changedBy"));
				accountOpening.setLastChgBy(users);
				accountOpening.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				accountOpening.setLastChgTime(box.getString(CHANGED_TIME));
				accountOpening.setStatus("y");
				HrMasFinancialYear masFinancialYear = new HrMasFinancialYear();
				masFinancialYear.setId(financialYearId);
				accountOpening.setFYear(masFinancialYear);
				MasBranch masBranch = new MasBranch();
				masBranch.setId(box.getInt("branchId"));
				accountOpening.setBranch(masBranch);
				existingAccountOpeningList =session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("Branch.Id", box.getInt("branchId")))
											.add(Restrictions.eq("SubLedger.Id",box.getInt(SUBLEDGER_ID))).list();
											
				if(existingAccountOpeningList.size()>0){
					message = "Data already exist.";
				}else{
					hbt.save(accountOpening);
					message = "Data saved Successfully!";
				}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = showAccountOpeningJsp(box.getInt("branchId"));
		map.put("message", message);
			/*faAccountOpeningList = session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("Status", "y")).list();
			map.put("faAccountOpeningList", faAccountOpeningList);
			accountList = session.createCriteria(FaMasAccount.class).list();
			subLedList = session.createCriteria(FaMasSubLed.class).list();
			map.put("accountList", accountList);
			map.put("subLedList", subLedList);
			map.put("openingNo", openingNo);*/
			return map;
		}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateAccountOpening(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		//List<Integer> maxAccOpeningList = new ArrayList<Integer>();
		//List<String> accountOpeningList = new ArrayList<String>();
		//List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		//List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		//List<FaAccountOpening> faAccountOpeningList = new ArrayList<FaAccountOpening>();
		List<FaAccountOpening> existingAccountOpeningList = new ArrayList<FaAccountOpening>();
		Session session = (Session)getSession();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		HibernateTemplate hbt = getHibernateTemplate();
		//String openingNo = "";
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String message = "";
		//boolean updated = false;
		try {
			String openingDate = (box.getString(OPENING_DATE));
			financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
									.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
										.add(Restrictions.eq("Status", "y")).list();
			//String financialYear = "";
			String branchCode = "";
			int financialYearId = 0;
			if(financialYearList.size()>0){
				for(HrMasFinancialYear fYear : financialYearList){
					//financialYear = fYear.getFinancialYear();
					financialYearId = fYear.getId();
				}
			}
			/*branchList = session.createCriteria(MasBranch.class).add(Restrictions.idEq(box.getInt("branchId"))).add(Restrictions.eq("Status", "y")).list();
			if(branchList.size()>0){
				for(MasBranch masBranch :branchList){
					branchCode = masBranch.getBranchCode();
				}
			}*/
			
				FaAccountOpening accountOpening = (FaAccountOpening) hbt.load(FaAccountOpening.class,box.getInt(COMMON_ID));

				if(box.getInt(ACCOUNT_ID)!= 0){
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(box.getInt(ACCOUNT_ID));
					accountOpening.setAccount(masAccount);
				}
				if(box.getInt(SUBLEDGER_ID)!= 0){
					FaMasSubLed masSubLed = new FaMasSubLed();
					masSubLed.setId(box.getInt(SUBLEDGER_ID));
					accountOpening.setSubLedger(masSubLed);
				}
				if(!box.getString(OPENING_DATE).equals("")){
					accountOpening.setOpeningDate(HMSUtil.convertStringTypeDateToDateType(box.getString(OPENING_DATE)));
				}
				String accountType = "";
				if(!box.getString("accountType").equals("")){
					accountType = box.getString("accountType");
				}
				BigDecimal opBalanceCr = new BigDecimal(0.0);
				BigDecimal opBalanceDr = new BigDecimal(0.0);
				if(accountType.equals("Dr")){
				if (!box.getString(OPENING_BALANCE).equals("")) {
					opBalanceDr = new BigDecimal(box.getString(OPENING_BALANCE));
					accountOpening.setOpeningAmtDr(opBalanceDr);
					accountOpening.setOpeningAmtCr(new BigDecimal(0.0));
				}
				}else if(accountType.equals("Cr")){
					opBalanceCr = new BigDecimal(box.getString(OPENING_BALANCE));
					accountOpening.setOpeningAmtCr(opBalanceCr);
					accountOpening.setOpeningAmtDr(new BigDecimal(0.0));
				}
				
				if(box.getInt("hospitalId")!= 0){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					accountOpening.setHospital(masHospital);
				}
				
				Users users = new Users();
				users.setId(box.getInt("changedBy"));
				accountOpening.setLastChgBy(users);
				accountOpening.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				accountOpening.setLastChgTime(box.getString(CHANGED_TIME));
				accountOpening.setStatus("y");
				HrMasFinancialYear masFinancialYear = new HrMasFinancialYear();
				masFinancialYear.setId(financialYearId);
				accountOpening.setFYear(masFinancialYear);
				MasBranch masBranch = new MasBranch();
				masBranch.setId(box.getInt("branchId"));
				accountOpening.setBranch(masBranch);
				 existingAccountOpeningList =session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("Branch.Id", box.getInt("branchId")))
					.add(Restrictions.eq("SubLedger.Id",box.getInt(SUBLEDGER_ID))).list();
				if(existingAccountOpeningList.size()>0){
					message = "Data already exist.";
				}else{
					hbt.update(accountOpening);
					message = "Data updated Successfully!";
				}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = showAccountOpeningJsp(box.getInt("branchId"));
		map.put("message", message);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> deleteAccountOpening(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		List<String> accountOpeningList = new ArrayList<String>();
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String openingDate = (box.getString(OPENING_DATE));
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
								.add(Restrictions.ge("YearToDate", HMSUtil.dateFormatterDDMMYYYY(openingDate)))
									.add(Restrictions.eq("Status", "y")).list();
		String financialYear = "";
		String branchCode = "";
		int financialYearId = 0;
		if(financialYearList.size()>0){
			for(HrMasFinancialYear fYear : financialYearList){
				financialYear = fYear.getFinancialYear();
				financialYearId = fYear.getId();
			}
		}
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.idEq(box.getInt("branchId"))).add(Restrictions.eq("Status", "y")).list();
		if(branchList.size()>0){
			for(MasBranch masBranch :branchList){
				branchCode = masBranch.getBranchCode();
			}
		}
		FaAccountOpening accountOpening = (FaAccountOpening) hbt.load(FaAccountOpening.class,box.getInt(COMMON_ID));
		boolean dataDeleted = false;
		if (box.getString("flag") != null) {
			String flag = (String) box.getString("flag");
			if (flag.equals("InActivate")) {
				accountOpening.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				accountOpening.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(accountOpening);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		map = showAccountOpeningJsp(box.getInt("branchId"));
		map.put("message", message);
		return map;
	}

	
	
	
	@SuppressWarnings("unchecked")
	/*public Map<String, Object> showAccountParameterJsp(int fYear) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountListForCash = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountListForBank = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		List<FaAccountsParameter> accountParameterList = new ArrayList<FaAccountsParameter>();
		Session session = (Session)getSession();
		Object[] selectedCode = {"COM","PRJ"};
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear)).list();
		accountListForCash = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear))
								.add(Restrictions.eq("AccountSubGroup.Id", 2)).list();
		accountListForBank = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYear))
		.add(Restrictions.eq("AccountSubGroup.Id", 1)).list();
		subLedList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("FYear.Id", fYear)).list();
		mainChargeCodeList = session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Status", "y")).list();
		companyList = session.createCriteria(MasCompany.class).add(Restrictions.eq("Status", "y")).list();
		patientTypeList = session.createCriteria(MasPatientType.class).add(Restrictions.eq("Status", "y"))
							.add(Restrictions.not(Restrictions.in("PatientTypeCode", selectedCode))).list();
		accountParameterList = session.createCriteria(FaAccountsParameter.class).list();
		map.put("accountList", accountList);
		map.put("accountListForCash", accountListForCash);
		map.put("accountListForBank", accountListForBank);
		map.put("subLedList", subLedList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("companyList", companyList);
		map.put("patientTypeList", patientTypeList);
		map.put("accountParameterList", accountParameterList);
		return map;
	}

	public Map<String, Object> submitAccountsParameter(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();

	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);

	try {
		Vector accId = box.getVector("acc_id");
		Vector subLedId = box.getVector("sub_led_id");
		Vector accountType = box.getVector("accountType");
		if(accountType.size()>0){
		for (int i = 0; i < accountType.size(); i++) {
			FaAccountsParameter faAccountsParameter = new FaAccountsParameter();
			if (accountType.get(i) != null && !accountType.get(i).equals("")) {
				faAccountsParameter.setAccountType((String) accountType.get(i));

				if (accId.size() > 0) {
					if (accId.get(i) != null && !accId.get(i).equals("0")) {
						FaMasAccount masAccount = new FaMasAccount();
						masAccount.setId(Integer.parseInt(accId.get(i).toString()));
						faAccountsParameter.setAccount(masAccount);
					}
				}
				if (subLedId.size() > 0) {
					if (subLedId.get(i) != null && !subLedId.get(i).equals("0")) {
						FaMasSubLed masSubLed = new FaMasSubLed();
						masSubLed.setId(Integer.parseInt(subLedId.get(i).toString()));
						faAccountsParameter.setSubLed(masSubLed);
					}
				}
				if(box.getInt("hospitalId")!= 0){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("userId"));
					faAccountsParameter.setHospital(masHospital);
				}
				if(box.getInt("userId")!= 0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					faAccountsParameter.setLastChgBy(users);
				}
				if(!box.getString(CHANGED_DATE).equals("")){
					faAccountsParameter.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				if(!box.getString(CHANGED_TIME).equals("")){
					faAccountsParameter.setLastChgTime(box.getString(CHANGED_TIME));
				}
				faAccountsParameter.setStatus("y");
				hbt.save(faAccountsParameter);
			}

		}
		}
		int chargeListLength = box.getInt("hiddenValueForAccounts");


		if(chargeListLength > 0){
				for(int i=0; i<= chargeListLength; i++){
					int mainchargeId  = 0;
					if (box.getInt(MAIN_CHARGECODE_ID+ i) != 0) {
						MasMainChargecode mainChargecode = new MasMainChargecode();
						 mainchargeId = box.getInt(MAIN_CHARGECODE_ID+ i);
					}
					if( box.getInt(MAIN_CHARGECODE_ID+ i)!= 0){
					MasMainChargecode masMainChargecode = (MasMainChargecode)hbt.load(MasMainChargecode.class, mainchargeId);
					if (box.getString(BILL_TYPE+ i) != "") {
						masMainChargecode.setBillType(box.getString(BILL_TYPE+ i));
					}
					if (box.getInt(ACCOUNT_ID+ i) != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						faMasAccount.setId(box.getInt(ACCOUNT_ID+ i));
						masMainChargecode.setAccount(faMasAccount);
					}
					if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
						masMainChargecode.setSubLed(faMasSubLed);
					}

					hbt.update(masMainChargecode);

					}
					}
				}

		int count = 0;
		if(box.getInt("counter")!= 0){
			count = box.getInt("counter");
		}
		for (int i = 1; i <= count; i++) {
			int companyId  = 0;
			if (box.getInt("companyCheckBoxId"+ i) != 0) {
				MasCompany masCompany = new MasCompany();
				companyId = box.getInt("companyCheckBoxId"+ i);
			}
			if( box.getInt("companyCheckBoxId"+ i)!= 0){
			MasCompany masCompany = (MasCompany)hbt.load(MasCompany.class, companyId);
			if (box.getInt("acc_id"+ i) != 0) {
				FaMasAccount faMasAccount = new FaMasAccount();
				faMasAccount.setId(box.getInt("acc_id"+ i));
				masCompany.setAccount(faMasAccount);
			}

			if (box.getInt(SUB_LEDGER_ID+ i) != 0) {
				FaMasSubLed faMasSubLed = new FaMasSubLed();
				faMasSubLed.setId(box.getInt(SUB_LEDGER_ID+ i));
				masCompany.setSubLed(faMasSubLed);
			}

				hbt.update(masCompany);
			}

			}
//=================================================================================================
		int cnt = 0;
		if(box.getInt("cnt")!= 0){
			cnt = box.getInt("cnt");
		}
		for (int j= 1; j <= cnt; j++) {
			int patientTypeId  = 0;
			if (box.getInt("patientTypeCheckBoxId"+ j) != 0) {
				MasPatientType masPatientType = new MasPatientType();
				patientTypeId = box.getInt("patientTypeCheckBoxId"+ j);
			}
			if(box.getInt("patientTypeCheckBoxId"+ j)!= 0){
			MasPatientType masPatientType= (MasPatientType)hbt.load(MasPatientType.class, patientTypeId);
			if (box.getInt("accPatienType_id"+ j) != 0) {
				FaMasAccount faMasAccount = new FaMasAccount();
				faMasAccount.setId(box.getInt("accPatienType_id"+ j));
				masPatientType.setAcc(faMasAccount);
			}

			if (box.getInt("subLedId"+ j) != 0) {
				FaMasSubLed faMasSubLed = new FaMasSubLed();
				faMasSubLed.setId(box.getInt("subLedId"+ j));
				masPatientType.setSubLed(faMasSubLed);
			}

				hbt.update(masPatientType);

			}
		}

	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	map = showAccountParameterJsp(box.getInt("fYear"));
		return map;
	}*/
	public Map<String, Object> getBillingAmountForAccounts() {
		Map<String, Object> map = new HashMap<String, Object>();

		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBranchBalancePopupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		Session session = (Session)getSession();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		map.put("branchList", branchList);
		return map;
	}
	public Map<String, Object> showBranchSubLedBalancePopupJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBranch> branchList = new ArrayList<MasBranch>();
		Session session = (Session)getSession();
		branchList = session.createCriteria(MasBranch.class).add(Restrictions.eq("Status", "y")).list();
		map.put("branchList", branchList);
		return map;
	}
	public Map<String, Object> showVoucherMappingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> dispalySalesBillingAmount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> mainChargeAmountList = new ArrayList<Object[]>();
		List<Object[]> companyAmountList = new ArrayList<Object[]>();
		List<Object[]> cashAmountList  = new ArrayList<Object[]>();
		List<Object[]> bankAmountList  = new ArrayList<Object[]>();
		List<Object[]> creditCardAmountList  = new ArrayList<Object[]>();
		List<Object[]> discountAmountList  = new ArrayList<Object[]>();
		List<Object[]> charityAmountList  = new ArrayList<Object[]>();
		List<Object[]> stdAmountList  = new ArrayList<Object[]>();
		List<Object[]> roundOffAmountList  = new ArrayList<Object[]>();
		List<Object[]> patientTypeAmountList  = new ArrayList<Object[]>();
		List<Object[]> salesMedicineAmountList  = new ArrayList<Object[]>();
		Session session = (Session)getSession();

		try {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//-----------------------For Total Billing--------------------------------------
			String mainChargeQueryString = "select acc.acc_desc,subled.sub_led_desc,mcc.account_id,mcc.sub_led_id, main_chargecode_name,mc.main_chargecode_id,"
					+ " subgrp.account_sub_group_id,grp.account_group_id, sum(coalesce(rate,0)*coalesce(quantity,0)) as bill_amt from bl_op_bill_details detail"
					+ " left join bl_op_bill_header header on header.op_bill_header_id=detail.op_bill_header_id "
					+ " left join mas_charge_code mc on detail.charge_code_id=mc.charge_code_id "
					+ " left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id  "
					+ " left join fa_mas_account acc on acc.acc_id = mcc.account_id "
					+ " left join fa_mas_sub_led subled on subled.sub_led_id = mcc.sub_led_id  "
					+ " left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id  "
					+ " left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id  "
					+ " where header.bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id is not null "
					+ " group by acc.acc_desc,subled.sub_led_desc,mcc.account_id,mcc.sub_led_id, main_chargecode_name,mc.main_chargecode_id,"
					+ " subgrp.account_sub_group_id,grp.account_group_id"
					+ " union "
					+ " select (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt, "
					+ " (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled,"
					+ " (select acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as account_id, "
					+ " (select sub_led_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as sub_led_id,"
					+ " main_chargecode_name, mc.main_chargecode_id,(select subgrp.account_sub_group_id from fa_account_parameter fp "
					+ " left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id "
					+ " left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, "
					+ " (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join "
					+ " fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join "
					+ " fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group, "
					+ "  sum(coalesce(rate,0)*coalesce(quantity,0)) as bill_amt from bl_op_bill_details detail  "
					+ " left join bl_op_bill_header header on header.op_bill_header_id=detail.op_bill_header_id left join mas_charge_code mc on detail.charge_code_id=mc.charge_code_id "
					+ " left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id left join fa_mas_account acc on acc.acc_id = mcc.account_id "
					+ " left join fa_mas_sub_led subled on subled.sub_led_id = mcc.sub_led_id where header.bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id is null group by  main_chargecode_name, mc.main_chargecode_id" ;
			mainChargeAmountList = session.createSQLQuery(mainChargeQueryString).list();
			String dispensingQueryString = "select sum(coalesce(bill_amt,0)),accountqry.acc_desc,accountqry.acc_id,accountqry.sub_led_desc,accountqry.sub_led_id,accountqry.account_group_id,accountqry.account_sub_group_id from "
					+ " (select acc_desc,acc_id,sub_led_desc,subled.sub_led_id,grp.account_group_id,subgrp.account_sub_group_id from fa_account_parameter fp "
					+ " left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id "
					+ " left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id  "
					+ " left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Sales Medicine')as accountqry, bl_dispensing_header disphd "
					+ " where bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and inpatient_id is null group by accountqry.acc_desc,accountqry.acc_id,accountqry.sub_led_desc,accountqry.sub_led_id,accountqry.account_group_id,accountqry.account_sub_group_id " ;
			salesMedicineAmountList= session.createSQLQuery(dispensingQueryString).list();
			/*String companyQueryString = " select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, acc.acc_id ,subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(outstanding,0.0)),0.0) as op_amt from bl_op_bill_header as obh where patient_type_id =1 and obh.company_id is not null and obh.status='y' and obh.company_id=com.company_id and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')+  " +
					" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as op_amt from bl_dispensing_header as obh where patient_type_id =1 and obh.company_id is not null and inpatient_id is null and obh.status='y' " +
					" and obh.company_id=com.company_id and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' as com_acc from mas_company com left join fa_mas_account acc on acc.acc_id = com.account_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
					" on subgrp.account_group_id = grp.account_group_id where com.account_id is not null " +
					"union " +
					" select com.company_name, (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
					" (select acc.acc_id  from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, " +
					" (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group, (select ifnull(sum(ifnull(outstanding,0.0)),0.0) as op_amt " +
					" from bl_op_bill_header as obh where patient_type_id =1 and obh.company_id is not null and obh.status='y' " +
					" and obh.company_id=com.company_id and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')+ (select  ifnull(sum(ifnull(outstanding,0.0)),0) as op_amt " +
					" from bl_dispensing_header as obh where patient_type_id =1 and obh.company_id is not null and inpatient_id is null and obh.status='y' and obh.company_id=com.company_id and bill_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc from  mas_company com where  com.account_id is null";


			companyAmountList = session.createSQLQuery(companyQueryString).list();*/
			String cashQueryString = "select sum(coalesce(rd.amount,0)), (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Cash') as subled, (select acc.acc_id  from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Cash') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Cash') as account_group " +
					" from bl_receipt_details rd left join bl_receipt_header rh on rh.receipt_header_id=rd.receipt_header_id where rd.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('opb','bld' ) and rh.inpatient_id is null and payment_mode='C'";
			cashAmountList = session.createSQLQuery(cashQueryString).list();
			String bankQueryString = "select sum(coalesce(rd.amount,0)), (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Bank') as subled, (select acc.acc_id  from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Bank') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Bank') as account_group " +
					" from bl_receipt_details rd left join bl_receipt_header rh on rh.receipt_header_id=rd.receipt_header_id where rd.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('opb','bld' ) and rh.inpatient_id is null and payment_mode='Q'";
			bankAmountList = session.createSQLQuery(bankQueryString).list();
			String creditCardQueryString = "select sum(coalesce(rd.amount,0)), (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Credit Card') as subled, (select acc.acc_id  from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Credit Card') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Credit Card') as account_group " +
					" from bl_receipt_details rd left join bl_receipt_header rh on rh.receipt_header_id=rd.receipt_header_id where rd.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('opb','bld' ) and rh.inpatient_id is null and payment_mode='R'";
			creditCardAmountList = session.createSQLQuery(creditCardQueryString).list();

			String discountString = "select coalesce((select coalesce(sum(coalesce(discount_amt,0))+sum(coalesce(discount,0)),0) as op_amt from bl_op_bill_header as obh where bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'),0)+ "
					+ " coalesce((select  coalesce(sum(coalesce(discount_amt,0))+sum(coalesce(discount,0)),0) as op_amt from bl_dispensing_header dh  where inpatient_id is null and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'),0)as dis, " +
					" (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Discount') as disAcc, " +
					" (select acc.acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Discount') as disAccId, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Discount') as disSubled, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Discount') as disSubledId," +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Discount') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Discount') as account_group; ";
			discountAmountList = session.createSQLQuery(discountString).list();
			String charityString = "select coalesce((select sum(coalesce(obh.charity,0.0)) as op_amt from bl_op_bill_header as obh  where bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'),0)+ "
					+ " coalesce((select  sum(coalesce(dh.charity,0.0)) as op_amt from bl_dispensing_header dh  where inpatient_id is null and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ),0)+ coalesce((select  sum(coalesce(dh.charity_amt,0.0)) as op_amt from bl_refund_header dh  "
					+ " where inpatient_id is null and refund_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ),0)as charity, " +
					" (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Charity') as disAcc, " +
					" (select acc.acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Charity') as disAccId, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Charity') as disSubled, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Charity') as disSubledId," +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Charity') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Charity') as account_group;";
				charityAmountList = session.createSQLQuery(charityString).list();
			/*String sdString = "select sum(ifnull(std_deduction_gen,0)+ifnull(std_deduction_spl,0))as sd," +
					" (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Std Deduction') as sdAcc, " +
					" (select acc.acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Std Deduction') as sdAccId," +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Std Deduction') as sdSubled, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Std Deduction') as sdSubledId , " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					"left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Std Deduction') as account_sub_group, " +
					"(select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					"left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Std Deduction')"+
					"from bl_op_bill_details where bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
				stdAmountList = session.createSQLQuery(sdString).list();*/
				String roundOffString = "select (select  sum((coalesce(bill_amt,0)-coalesce(discount_amt,0))-round(coalesce(bill_amt,0)-coalesce(discount_amt,0))) as op_amt from bl_op_bill_header as obh where bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ " +
					"(select   sum((coalesce(bill_amt,0)-coalesce(dh.discount_amt,0))-round(coalesce(bill_amt,0)-coalesce(dh.discount_amt,0))) as op_amt " +
					" from bl_dispensing_details as dd left join bl_dispensing_header dh on dd.dispensing_header_id=dh.dispensing_header_id where inpatient_id is null and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as dis, " +
					" (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Round Off') as disAcc, " +
					" (select acc.acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Round Off') as disAccId, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Round Off') as disSubled, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Round Off') as disSubledId," +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Round Off') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Round Off') as account_group;";
			roundOffAmountList = session.createSQLQuery(roundOffString).list();
			/*String patientTypeString = "select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, acc.acc_id ,subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(outstanding,0.0)),0.0) as op_amt from bl_op_bill_header as obh left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id where  pt.patient_type_code not in('COM','PRJ') " +
					" and pt.acc_id is not null and  bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' and ptmain.patient_type_id=obh.patient_type_id )+" +
					" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as op_amt from bl_dispensing_header as obh " +
					" left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id where  pt.patient_type_code not in('COM','PRJ') and inpatient_id is null  and pt.acc_id is not null and  bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y'and ptmain.patient_type_id=obh.patient_type_id ) as onacc from mas_patient_type ptmain left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is not null and ptmain.status='y' " +
					" union " +
					" select ptmain.patient_type_name, (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
					" (select acc.acc_id  from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group, (select ifnull(sum(ifnull(outstanding,0.0)),0.0) as op_amt from bl_op_bill_header as obh left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id where  pt.patient_type_code not in('COM','PRJ') and pt.acc_id is null and  bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y'  and ptmain.patient_type_id=obh.patient_type_id )+ " +
					"(select  ifnull(sum(ifnull(outstanding,0.0)),0) as op_amt " +
					" from bl_dispensing_header as obh left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id where  pt.patient_type_code not in('COM','PRJ') and inpatient_id is null and pt.acc_id is null and  bill_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' and ptmain.patient_type_id=obh.patient_type_id ) as onacc from  mas_patient_type ptmain where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is null and status='y'";
			patientTypeAmountList = session.createSQLQuery(patientTypeString).list();*/


		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("mainChargeAmountList", mainChargeAmountList);
		map.put("salesMedicineAmountList", salesMedicineAmountList);
		map.put("companyAmountList", companyAmountList);
		map.put("cashAmountList", cashAmountList);
		map.put("bankAmountList", bankAmountList);
		map.put("creditCardAmountList", creditCardAmountList);
		map.put("stdAmountList", stdAmountList);
		map.put("discountAmountList", discountAmountList);
		map.put("charityAmountList", charityAmountList);
		map.put("roundOffAmountList", roundOffAmountList);
		map.put("patientTypeAmountList", patientTypeAmountList);
		return map;
	}
	public Map<String, Object> postSalesVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> maxAccountIdList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<BlOpBillHeader> opBilHeaderList = new ArrayList<BlOpBillHeader>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();
		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			opBilHeaderList = session.createCriteria(BlOpBillHeader.class).add(Restrictions.between("BillDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("hospitalId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("SV");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			/*MasStoreFinancial hrMasFinancialYear3 = new MasStoreFinancial();
			hrMasFinancialYear3.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(hrMasFinancialYear3);*/
			paramMap.put("locationId", box.getInt("hospitalId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "SV");
			paramMap.put("voucherType", "Sales");
			paramMap.put("financialYearId",box.getInt("fYear"));
			 voucherNo = generateVoucherNo(paramMap);
			 faVoucherHeader.setVoucherNo("SV/"+voucherNo);

			hbt.save(faVoucherHeader);
//======================================
			/*if(opBilHeaderList.size()>0){
				for(BlOpBillHeader opBillHeader : opBilHeaderList){
					int opBilingId = opBillHeader.getId();
					BlOpBillHeader opBillHeader2= (BlOpBillHeader)hbt.load(BlOpBillHeader.class, opBilingId);
					opBillHeader2.setVoucherNo(voucherNo);
					hbt.update(opBillHeader2);
				}
			}
			if(receiptHeaderList.size()>0){
				for(BlReceiptHeader receiptHeader : receiptHeaderList){
					int receiptHeaderId = receiptHeader.getId();
					BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, receiptHeaderId);
					receiptHeader2.setVoucherNo(voucherNo);
					hbt.update(receiptHeader2);
				}
			}*/

			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}
				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}

				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						accountSubGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						accountSubGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				/* int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);
*/


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/*BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);
*/
				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "SV");
				paramMap.put("voucherType", "Sales");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
		return map;
	}

	public Map<String, Object> showIpSalesVoucherMappingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
	public Map<String, Object> dispalyIpSalesBillingAmount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> mainChargeAmountList = new ArrayList<Object[]>();
		List<Object[]> companyAmountList = new ArrayList<Object[]>();
		List<Object[]> cashAmountList  = new ArrayList<Object[]>();
		List<Object[]> bankAmountList  = new ArrayList<Object[]>();
		List<Object[]> creditCardAmountList  = new ArrayList<Object[]>();
		List<Object[]> discountAmountList  = new ArrayList<Object[]>();
		List<Object[]> charityAmountList  = new ArrayList<Object[]>();
		List<Object[]> stdAmountList  = new ArrayList<Object[]>();
		List<Object[]> roundOffAmountList  = new ArrayList<Object[]>();
		List<Object[]> patientTypeAmountList  = new ArrayList<Object[]>();
		List<Object[]> salesMedicineAmountList  = new ArrayList<Object[]>();
		Session session = (Session)getSession();

		try {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//-----------------------For Total Billing--------------------------------------
			String mainChargeQueryString = "select acc.acc_desc,subled.sub_led_desc,mcc.account_id,mcc.sub_led_id, main_chargecode_name, mc.main_chargecode_id,subgrp.account_sub_group_id,grp.account_group_id,sum(ifnull(rate,0)*ifnull(quantity,0)) as bill_amt " +
					" from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join mas_charge_code mc on chargedetail.charge_code_id=mc.charge_code_id left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id left join fa_mas_account acc on acc.acc_id = mcc.account_id left join fa_mas_sub_led subled " +
					" on subled.sub_led_id = mcc.sub_led_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where finaldetail.final_bill_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id is not null group by mc.main_chargecode_id " +
					" union " +
					" select (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as subled, (select acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as account_id, (select sub_led_id from fa_account_parameter fp left join  fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') " +
					" as sub_led_id,main_chargecode_name, mc.main_chargecode_id, (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group, " +
					" sum(ifnull(rate,0)*ifnull(quantity,0)) as bill_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join mas_charge_code mc on chargedetail.charge_code_id=mc.charge_code_id left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id " +
					" left join fa_mas_account acc on acc.acc_id = mcc.account_id left join fa_mas_sub_led subled on subled.sub_led_id = mcc.sub_led_id where finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id is null group by mc.main_chargecode_id" ;
			mainChargeAmountList = session.createSQLQuery(mainChargeQueryString).list();

			String dispensingQueryString = "select sum(ifnull(bill_amt,0)),accountqry.* from (select acc_desc,acc_id,sub_led_desc,subled.sub_led_id, grp.account_group_id,subgrp.account_sub_group_id " +
					" from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Sales Medicine')as accountqry, bl_dispensing_header disphd where bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and inpatient_id is  not null";

			salesMedicineAmountList= session.createSQLQuery(dispensingQueryString).list();

			String companyQueryString = " select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, acc.acc_id , subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(os_amt,0.0)),0.0) as ip_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id " +
					" where main.patient_type_id =1 and main.company_id is not null and main.status='y' and main.company_id=com.company_id and finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+  " +
					" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as ip_amt from bl_final_bill_details finaldetail left join  bl_dispensing_header as obh on obh.ip_final_bill_id =finaldetail.final_bill_details_id " +
					" where obh.patient_type_id =1 and obh.company_id is not null and obh.inpatient_id is  not null and obh.status='y' and obh.company_id=com.company_id and finaldetail.final_bill_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc from mas_company com left join fa_mas_account acc on acc.acc_id = com.account_id left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where com.account_id is not null " +
					" union " +
					" select com.company_name, (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_account_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
					" (select acc.acc_id  from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_account_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group, " +
					" (select ifnull(sum(ifnull(os_amt,0.0)),0.0) as ip_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main " +
					" on main.final_bill_id =finaldetail.final_bill_details_id where main.patient_type_id =1 and main.company_id is not null and main.status='y' " +
					" and main.company_id=com.company_id and finaldetail.final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')+ " +
					" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as ip_amt from bl_final_bill_details finaldetail left join  bl_dispensing_header as obh on obh.ip_final_bill_id =finaldetail.final_bill_details_id where obh.patient_type_id =1 " +
					" and obh.company_id is not null and obh.inpatient_id is not null and obh.status='y' and obh.company_id=com.company_id and finaldetail.final_bill_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc from  mas_company com where  com.account_id is null ";

			companyAmountList = session.createSQLQuery(companyQueryString).list();

			String cashQueryString = "select sum(ifnull(rd.amount,0)), (select acc_desc from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Cash') as subled," +
					" (select acc.acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Cash') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Cash') as account_group from bl_final_bill_details finaldetail " +
					" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join bl_receipt_header rh on rh.charge_slip_main_id = main.charge_slip_main_id left join bl_receipt_details rd on rh.receipt_header_id=rd.receipt_header_id " +
					" where finaldetail.final_bill_date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('chs','bld' ) and rh.inpatient_id is  not null and payment_mode='c'";

			cashAmountList = session.createSQLQuery(cashQueryString).list();

			String bankQueryString = "select sum(ifnull(rd.amount,0)), (select acc_desc from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Bank') as subled," +
					" (select acc.acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Bank') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Bank') as account_group from bl_final_bill_details finaldetail " +
					" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join bl_receipt_header rh on rh.charge_slip_main_id = main.charge_slip_main_id left join bl_receipt_details rd on rh.receipt_header_id=rd.receipt_header_id " +
					" where finaldetail.final_bill_date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('chs','bld' ) and rh.inpatient_id is  not null and payment_mode='Q'";
			bankAmountList = session.createSQLQuery(bankQueryString).list();

			String creditCardQueryString = "select sum(ifnull(rd.amount,0)), (select acc_desc from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
					" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Credit Card') as subled," +
					" (select acc.acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
					" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Credit Card') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Credit Card') as account_group from bl_final_bill_details finaldetail " +
					" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
					" left join bl_receipt_header rh on rh.charge_slip_main_id = main.charge_slip_main_id left join bl_receipt_details rd on rh.receipt_header_id=rd.receipt_header_id " +
					" where finaldetail.final_bill_date between  '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  receipt_type in ('chs','bld' ) and rh.inpatient_id is  not null and payment_mode='R'";
			creditCardAmountList = session.createSQLQuery(creditCardQueryString).list();

			String discountString = " select (select ifnull(sum(ifnull(chargedetail.discount_amt,0.0)),0.0) as ip_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id " +
					" left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id where finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) " +
					" + (select  ifnull(sum(ifnull(main.discount_amt,0.0)),0) as ip_amt from  bl_final_bill_details finaldetail left join bl_dispensing_header main on main.ip_final_bill_id =finaldetail.final_bill_details_id " +
					" where main.inpatient_id is not null and finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as dis, " +
					" (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Discount') as disAcc, (select acc.acc_id from fa_account_parameter fp left join " +
					" fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Discount') as disAccId, (select sub_led_desc from fa_account_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Discount') as disSubled, " +
					"(select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Discount') as disSubledId, (select subgrp.account_sub_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
					" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Discount') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Discount') as account_group";

				discountAmountList = session.createSQLQuery(discountString).list();

				String sdString = "select (select sum(ifnull(std_deduction_gen,0)+ifnull(std_deduction_spl,0))as sd from bl_final_bill_details finaldetail " +
						" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id " +
						" where finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) stde , (select acc_desc from fa_account_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Std Deduction') as stdeAcc, (select acc.acc_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Std Deduction') as stdeAccId, " +
						" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Std Deduction') as stdeSubled, " +
						" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Std Deduction') as stdeSubledId, " +
						" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Std Deduction') as account_sub_group, " +
						" (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on " +
						" subgrp.account_group_id = grp.account_group_id where account_type='Std Deduction') as account_group ";
			 stdAmountList = session.createSQLQuery(sdString).list();

			 String roundOffString = " select (select  sum((ifnull(chg_slp_amt,0)-ifnull(main.discount_amt,0))-round(ifnull(chg_slp_amt,0)-ifnull(main.discount_amt,0)))  as ip_amt " +
			 		" from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id " +
			 		" left join bl_charge_slip_detail  chargedetail on chargedetail.charge_slip_main_id = main.charge_slip_main_id where finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) + " +
			 		" (select  sum((ifnull(bill_amt,0)-ifnull(main.discount_amt,0))-round(ifnull(bill_amt,0)-ifnull(main.discount_amt,0))) as ip_amt " +
			 		" from  bl_final_bill_details finaldetail left join bl_dispensing_header main on main.ip_final_bill_id =finaldetail.final_bill_details_id " +
			 		" where main.inpatient_id is not null and finaldetail.final_bill_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as roundoff, " +
			 		" (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			 		" where account_type='Round Off') as roundOffAcc, (select acc.acc_id from fa_account_parameter fp left join " +
			 		" fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Round Off') as roundOffId, " +
			 		" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
			 		" where account_type='Round Off') as roundOffSubled, (select subled.sub_led_id from fa_account_parameter fp " +
			 		" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Round Off') as roundOffSubledId, " +
			 		" (select subgrp.account_sub_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Round Off') as account_sub_group, " +
			 		" (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Round Off') as account_group;";
		roundOffAmountList = session.createSQLQuery(roundOffString).list();



				String charityString = "select (select ifnull(sum(ifnull(proportional_discount_amount,0.0)),0.0) " +
						" as op_amt from bl_final_bill_details finaldetail left join bl_charge_slip_main main " +
						" on main.final_bill_id =finaldetail.final_bill_details_id left join bl_charge_slip_detail  chargedetail " +
						" on chargedetail.charge_slip_main_id = main.charge_slip_main_id where final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ " +
						"(select  ifnull(sum(ifnull(proportional_dis_amt,0.0)),0) as op_amt from bl_final_bill_details finaldetail " +
						" left join bl_dispensing_header main on main.ip_final_bill_id =finaldetail.final_bill_details_id " +
						" left join bl_dispensing_details as dd on main.dispensing_header_id = dd.dispensing_header_id where main.inpatient_id " +
						" is  not null and final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) + (select  ifnull(sum(ifnull(final_bill_charity,0.0)),0) as op_amt " +
						" from bl_final_bill_details finaldetail where final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) as charity, " +
						" (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" where account_type='Charity') as disAcc, (select acc.acc_id from fa_account_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Charity') as disAccId, " +
						" (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Charity') as disSubled, " +
						" (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Charity') as disSubledId, (select subgrp.account_sub_group_id from fa_account_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Discount') as account_sub_group, (select grp.account_group_id from fa_account_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on " +
						" subgrp.account_group_id = grp.account_group_id where account_type='Charity') as account_group;";
			 charityAmountList = session.createSQLQuery(charityString).list();

			 String patientTypeString = " select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, acc.acc_id , " +
			 		" subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, (select ifnull(sum(ifnull(os_amt,0.0)),0.0) as ip_amt " +
			 		" from bl_final_bill_details finaldetail left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join mas_patient_type pt " +
			 		" on pt.patient_type_id = main.patient_type_id where pt.patient_type_code not in('COM','PRJ') and pt.acc_id is not null and " +
			 		" final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' and ptmain.patient_type_id=main.patient_type_id )+ " +
			 		" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as ip_amt from bl_final_bill_details finaldetail left join bl_dispensing_header main on " +
			 		" main.ip_final_bill_id =finaldetail.final_bill_details_id left join mas_patient_type pt on pt.patient_type_id = main.patient_type_id where " +
			 		" pt.patient_type_code not in('COM','PRJ') and pt.acc_id is not null  and main.inpatient_id is not null and final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
			 		"  and pt.status='y'and ptmain.patient_type_id=main.patient_type_id ) as onacc from " +
			 		" mas_patient_type ptmain left join fa_mas_account acc on acc.acc_id = ptmain.acc_id left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id " +
			 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
			 		" where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is not null and ptmain.status='y' " +
			 		" union " +
			 		" select ptmain.patient_type_name, (select acc_desc from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id where " +
			 		" account_type='Mis.Account') as acnt, (select sub_led_desc from fa_account_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
			 		" where account_type='Mis.Account') as subled, (select acc.acc_id  from fa_account_parameter fp " +
			 		" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_account_parameter fp left join fa_mas_sub_led subled " +
			 		" on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, (select subgrp.account_sub_group_id from " +
			 		" fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id  where account_type='Mis.Account') as account_sub_group," +
			 		" (select grp.account_group_id from fa_account_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group, " +
			 		" (select ifnull(sum(ifnull(os_amt,0.0)),0.0) as ip_amt from bl_final_bill_details finaldetail " +
			 		" left join bl_charge_slip_main main on main.final_bill_id =finaldetail.final_bill_details_id left join mas_patient_type pt " +
			 		" on pt.patient_type_id = main.patient_type_id where  pt.patient_type_code not in('COM','PRJ') and pt.acc_id is null and final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' " +
			 		" and ptmain.patient_type_id=main.patient_type_id )+ (select  ifnull(sum(ifnull(outstanding,0.0)),0) as ip_amt from bl_final_bill_details finaldetail " +
			 		" left join  bl_dispensing_header as obh on obh.ip_final_bill_id =finaldetail.final_bill_details_id " +
			 		" left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id where  pt.patient_type_code " +
			 		" not in('COM','PRJ') and obh.inpatient_id is not null and pt.acc_id is null and  final_bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' " +
			 		" and ptmain.patient_type_id=obh.patient_type_id ) as onacc from mas_patient_type ptmain where  ptmain.patient_type_code not in('COM','PRJ') " +
			 		" and ptmain.acc_id is null and status='y';";
			 patientTypeAmountList = session.createSQLQuery(patientTypeString).list();


		} catch (HibernateException e) {
			// TODO Auto-gen0erated catch block
			e.printStackTrace();
		}
		map.put("mainChargeAmountList", mainChargeAmountList);
		map.put("salesMedicineAmountList", salesMedicineAmountList);
		map.put("companyAmountList", companyAmountList);
		map.put("cashAmountList", cashAmountList);
		map.put("bankAmountList", bankAmountList);
		map.put("creditCardAmountList", creditCardAmountList);
		map.put("stdAmountList", stdAmountList);
		map.put("discountAmountList", discountAmountList);
		map.put("charityAmountList", charityAmountList);
		map.put("roundOffAmountList", roundOffAmountList);
		map.put("patientTypeAmountList", patientTypeAmountList);
		return map;
	}
	public Map<String, Object> postSalesIpVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> maxAccountIdList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<BlOpBillHeader> opBilHeaderList = new ArrayList<BlOpBillHeader>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();
		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			opBilHeaderList = session.createCriteria(BlOpBillHeader.class).add(Restrictions.between("BillDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("hospitalId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("SV");
			faVoucherHeader.setRejected("n");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial hrMasFinancialYear = new MasStoreFinancial();
			hrMasFinancialYear.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(hrMasFinancialYear);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "SV");
			paramMap.put("voucherType", "Sales");
			 voucherNo = generateVoucherNo(paramMap);
			faVoucherHeader.setVoucherNo(""+voucherNo);

			hbt.save(faVoucherHeader);
//======================================
			/*if(opBilHeaderList.size()>0){
				for(BlOpBillHeader opBillHeader : opBilHeaderList){
					int opBilingId = opBillHeader.getId();
					BlOpBillHeader opBillHeader2= (BlOpBillHeader)hbt.load(BlOpBillHeader.class, opBilingId);
					opBillHeader2.setVoucherNo(voucherNo);
					hbt.update(opBillHeader2);
				}
			}
			if(receiptHeaderList.size()>0){
				for(BlReceiptHeader receiptHeader : receiptHeaderList){
					int receiptHeaderId = receiptHeader.getId();
					BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, receiptHeaderId);
					receiptHeader2.setVoucherNo(voucherNo);
					hbt.update(receiptHeader2);
				}
			}*/

			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}

				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}


				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				 int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
			 	if(branchAccountId != 0){
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);

			 	}


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/* BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);
							//-------------------------update Branch account master-------------------------------------------------

						 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
						 	if(branchAccountMasterList.size()>0){
						 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
						 			 branchAccountId = faBranchAccountMaster.getId();
						 		}
						 	}

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);*/

				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "SV");
				paramMap.put("voucherType", "Sales");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
		return map;
	}
	public Map<String, Object> dispalyRefundBillingAmount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> mainChargeAmountList = new ArrayList<Object[]>();
		List<Object[]> companyAmountList = new ArrayList<Object[]>();
		List<Object[]> cashAmountList  = new ArrayList<Object[]>();
		List<Object[]> bankAmountList  = new ArrayList<Object[]>();
		List<Object[]> creditCardAmountList  = new ArrayList<Object[]>();
		List<Object[]> discountAmountList  = new ArrayList<Object[]>();
		List<Object[]> charityAmountList  = new ArrayList<Object[]>();
		List<Object[]> stdAmountList  = new ArrayList<Object[]>();
		List<Object[]> roundOffAmountList  = new ArrayList<Object[]>();
		List<Object[]> patientTypeAmountList  = new ArrayList<Object[]>();
		List<Object[]> salesMedicineAmountList  = new ArrayList<Object[]>();
		Session session = (Session)getSession();

		try {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//-----------------------For Total Billing--------------------------------------
			String mainChargeQueryString = "select acc.acc_desc,subled.sub_led_desc,mcc.account_id,mcc.sub_led_id, " +
					" main_chargecode_name,mc.main_chargecode_id,subgrp.account_sub_group_id, grp.account_group_id, detail.advice_amt as bill_amt from bl_payment_advice_header header" +
					" inner join bl_payment_advice_details detail on header.payment_advice_header_id=detail.payment_advice_header_id " +
					" left join mas_charge_code mc on detail.charge_id=mc.charge_code_id left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id " +
					" left join fa_mas_account acc on acc.acc_id = mcc.account_id left join fa_mas_sub_led subled on subled.sub_led_id = mcc.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where header.payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id " +
					" is not null group by mc.main_chargecode_id " +
					" union " +
					" select (select acc_desc from fa_account_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acnt, " +
					" (select sub_led_desc from fa_account_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
					" (select acc_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as account_id, (select sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as sub_led_id,main_chargecode_name, " +
					"  mc.main_chargecode_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, " +
					" (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group, detail.advice_amt as bill_amt " +
					" from bl_payment_advice_header header inner join bl_payment_advice_details detail on " +
					" header.payment_advice_header_id=detail.payment_advice_header_id " +
					" left join mas_charge_code mc on detail.charge_id=mc.charge_code_id " +
					" left join mas_main_chargecode mcc on mc.main_chargecode_id = mcc.main_chargecode_id " +
					" left join fa_mas_account acc on acc.acc_id = mcc.account_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = mcc.sub_led_id " +
					" where header.payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and mcc.account_id is null group by mc.main_chargecode_id" ;
			mainChargeAmountList = session.createSQLQuery(mainChargeQueryString).list();

			String dispensingQueryString = " select sum(ifnull(total_advice_amt,0)),accountqry.* from " +
					" (select acc_desc,acc_id,sub_led_desc,subled.sub_led_id, grp.account_group_id," +
					" subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id" +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on " +
					" acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Sales Medicine')as accountqry, " +
					" bl_pymnt_advice_disp_header header where payment_advice_date between " +
					" '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and inpatient_id is null " ;
			salesMedicineAmountList= session.createSQLQuery(dispensingQueryString).list();
			String companyQueryString = "select com.company_name, acc.acc_desc as acnt," +
					" subled.sub_led_desc as subled, acc.acc_id ,subled.sub_led_id," +
					" subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(on_account_amt,0.0)),0.0) as op_amt " +
					" from bl_payment_advice_header  pah left join " +
					" bl_op_bill_header  obh  on pah.bill_id = obh.op_bill_header_id where patient_type_id =1 " +
					" and obh.company_id is not null and obh.status='y' and obh.company_id=com.company_id " +
					" and payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')+  " +
					" (select  ifnull(sum(ifnull(on_account_amt,0.0)),0) as op_amt " +
					" from bl_pymnt_advice_disp_header adh left join bl_dispensing_header  obh " +
					" on adh.bill_dispensing_id =obh.dispensing_header_id  where patient_type_id =1 " +
					" and obh.company_id is not null and adh.inpatient_id is null and obh.status='y' " +
					" and obh.company_id=com.company_id and payment_advice_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc " +
					" from mas_company com left join fa_mas_account acc on acc.acc_id = com.account_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp " +
					" on subgrp.account_group_id = grp.account_group_id where com.account_id is not null " +
					" union " +
					" select com.company_name, (select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, " +
					" (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group, " +
					"(select ifnull(on_account_amt,0.0) as op_amt from bl_payment_advice_header as pah " +
					" left join bl_op_bill_header obh on pah.bill_id = obh.op_bill_header_id " +
					" where patient_type_id =1 and obh.company_id is not null and obh.status='y' " +
					" and obh.company_id=com.company_id and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')+  " +
					" (select  ifnull(on_account_amt,0.0) as op_amt from bl_pymnt_advice_disp_header adh " +
					" left join bl_dispensing_header  obh on adh.bill_dispensing_id =obh.dispensing_header_id " +
					" where patient_type_id =1 and obh.company_id is not null and adh.inpatient_id is null " +
					" and obh.status='y' and obh.company_id=com.company_id and bill_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"') as com_acc " +
					" from  mas_company com where  com.account_id is null";

				companyAmountList = session.createSQLQuery(companyQueryString).list();

				String cashQueryString = "select sum(ifnull(rd.refund_amount,0))as refundAmt, (select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as sub_led_id, (select subgrp.account_sub_group_id from " +
						" fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_group from  bl_refund_header rh left join bl_refund_details rd on rh.refund_header_id = rd.refund_header_id " +
						" where rh.refund_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and rh.inpatient_id is null and payment_mode='C'";

				cashAmountList = session.createSQLQuery(cashQueryString).list();

				String bankQueryString = "select sum(ifnull(rd.refund_amount,0))as refundAmt, (select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Bank') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Bank') as sub_led_id, (select subgrp.account_sub_group_id from " +
						" fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Bank') as account_group from  bl_refund_header rh left join bl_refund_details rd on rh.refund_header_id = rd.refund_header_id " +
						" where rh.refund_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and rh.inpatient_id is null and payment_mode='Q'";
				bankAmountList = session.createSQLQuery(bankQueryString).list();

			String creditCardQueryString = "select sum(ifnull(rd.refund_amount,0))as refundAmt, (select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Credit Card') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Credit Card') as sub_led_id, (select subgrp.account_sub_group_id from " +
						" fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Credit Card') as account_group from  bl_refund_header rh left join bl_refund_details rd on rh.refund_header_id = rd.refund_header_id " +
						" where rh.refund_date  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and rh.inpatient_id is null and payment_mode='R'";
				creditCardAmountList = session.createSQLQuery(creditCardQueryString).list();

				String discountString = "select (select ifnull(sum(ifnull(obd.discount_amt,0.0)),0.0) as op_amt " +
						" from bl_payment_advice_header pah left join bl_op_bill_header obh on obh.op_bill_header_id = pah.bill_id " +
						" left join bl_op_bill_details obd on obh.op_bill_header_id = obd.op_bill_header_id " +
						" where payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ (select  ifnull(sum(ifnull(dd.discount_amt,0.0)),0) as op_amt " +
						" from bl_pymnt_advice_disp_header adh left join bl_dispensing_header dh on adh.bill_dispensing_id = dh.dispensing_header_id " +
						" left join bl_dispensing_details  dd on dd.dispensing_header_id=dh.dispensing_header_id where adh.inpatient_id is null " +
						" and payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as dis, " +
						" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" where account_type='Discount') as disAcc, (select acc.acc_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Discount') as disAccId, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Discount') as disSubled, (select subled.sub_led_id from fa_accounts_parameter fp " +
						" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Discount') as disSubledId, " +
						" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Discount') as account_sub_group, " +
						" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Discount') as account_group;";

			discountAmountList = session.createSQLQuery(discountString).list();

			String sdString = " select sum(ifnull(std_deduction_gen,0)+ifnull(std_deduction_spl,0))as sd," +
					" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Std Deduction') as sdAcc, (select acc.acc_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Std Deduction') as sdAccId, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Std Deduction') as sdSubled,(select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Std Deduction') as sdSubledId , " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Std Deduction') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
					" on subgrp.account_group_id = grp.account_group_id where account_type='Std Deduction') from  bl_payment_advice_header pah " +
					" left join bl_op_bill_header obh on obh.op_bill_header_id = pah.bill_id left join bl_op_bill_details obd on obh.op_bill_header_id = obd.op_bill_header_id " +
					" where payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'";
		 stdAmountList = session.createSQLQuery(sdString).list();

		 String charityString = "select (select ifnull(sum(ifnull(total_advice_charity_amt,0.0)),0.0) as op_amt " +
		 		" from bl_payment_advice_header pah where inpatient_id is null and payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ " +
		 		" (select  ifnull(sum(ifnull(total_advice_charity_amt,0.0)),0.0) as op_amt from bl_payment_advice_header pah " +
		 		" where inpatient_id is null and payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"')as dis, " +
		 		" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
		 		" where account_type='Charity') as disAcc, (select acc.acc_id from fa_accounts_parameter fp " +
		 		" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Charity') as disAccId, " +
		 		" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
		 		" where account_type='Charity') as disSubled, (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
		 		" where account_type='Charity') as disSubledId,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
		 		" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
		 		" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
		 		" where account_type='Charity') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
		 		" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
		 		" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
		 		" on subgrp.account_group_id = grp.account_group_id where account_type='Charity') as account_group";
		charityAmountList = session.createSQLQuery(charityString).list();

		String roundOffString = "select (select  sum((ifnull(total_refund_amt,0)-round(ifnull(total_refund_amt,0)))) " +
				" as op_amt from bl_refund_header as rh where pymnt_adv_disp_id is null  and refund_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )+ " +
				" (select sum((ifnull(total_refund_amt,0)-round(ifnull(total_refund_amt,0)))) as op_amt from bl_refund_header as rh " +
				" where inpatient_id is null and pymnt_adv_serv_id is null and refund_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' )as dis, " +
				" (select acc_desc from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" where account_type='Round Off') as disAcc, (select acc.acc_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Round Off') as disAccId, " +
				" (select sub_led_desc from fa_accounts_parameter fp " +
				" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Round Off') as disSubled, " +
				"(select subled.sub_led_id from fa_accounts_parameter fp " +
				" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				" where account_type='Round Off') as disSubledId, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Round Off') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Round Off') as account_group;";
	roundOffAmountList = session.createSQLQuery(roundOffString).list();
	String patientTypeString = " select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, acc.acc_id , " +
			" subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
			" (select ifnull(sum(ifnull(on_account_amt,0.0)),0.0) as op_amt from bl_payment_advice_header as pah " +
			" inner join bl_op_bill_header obh on pah.bill_id=obh.op_bill_header_id left join mas_patient_type pt " +
			" on pt.patient_type_id = obh.patient_type_id where  pt.patient_type_code not in('COM','PRJ') " +
			" and pt.acc_id is not null and  payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' " +
			" and ptmain.patient_type_id=obh.patient_type_id )+ (select  ifnull(sum(ifnull(on_account_amt,0.0)),0) as op_amt " +
			" from bl_pymnt_advice_disp_header as pah inner join bl_dispensing_header as obh " +
			" on pah.bill_dispensing_id=obh.dispensing_header_id left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id " +
			" where  pt.patient_type_code not in('COM','PRJ') and pah.inpatient_id is null  and pt.acc_id is not null " +
			" and  payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y'and ptmain.patient_type_id=obh.patient_type_id ) as onacc " +
			" from mas_patient_type ptmain left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
			" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id " +
			" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where  ptmain.patient_type_code not in('COM','PRJ') " +
			" and ptmain.acc_id is not null and ptmain.status='y' " +
			" union " +
			" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp " +
			" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			" where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp " +
			" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
			" where account_type='Mis.Account') as subled, " +
			" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			" where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_accounts_parameter fp " +
			" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
			" where account_type='Mis.Account') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
			" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			" left join fa_mas_account_sub_group subgrp " +
			" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on " +
			" subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, " +
			" (select grp.account_group_id from fa_accounts_parameter fp " +
			" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
			" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
			" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
			" where account_type='Mis.Account') as account_group, " +
			" (select ifnull(sum(ifnull(on_account_amt,0.0)),0.0) as op_amt " +
			" from bl_payment_advice_header as pah inner join bl_op_bill_header obh on pah.bill_id=obh.op_bill_header_id " +
			" left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id " +
			"  where  pt.patient_type_code not in('COM','PRJ') and pt.acc_id is null and  payment_advice_date " +
			" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' and ptmain.patient_type_id=obh.patient_type_id )+ " +
			" (select  ifnull(sum(ifnull(outstanding,0.0)),0) as op_amt from bl_pymnt_advice_disp_header as pah " +
			" inner join bl_dispensing_header as obh on pah.bill_dispensing_id=obh.dispensing_header_id " +
			" left join mas_patient_type pt on pt.patient_type_id = obh.patient_type_id " +
			" where  pt.patient_type_code not in('COM','PRJ') and pah.inpatient_id is null and pt.acc_id is null " +
			" and  payment_advice_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"'  and pt.status='y' and ptmain.patient_type_id=obh.patient_type_id ) as onacc " +
			" from  mas_patient_type ptmain where ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is null and status='y'";
		patientTypeAmountList = session.createSQLQuery(patientTypeString).list();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("mainChargeAmountList", mainChargeAmountList);
		map.put("salesMedicineAmountList", salesMedicineAmountList);
		map.put("companyAmountList", companyAmountList);
		map.put("cashAmountList", cashAmountList);
		map.put("bankAmountList", bankAmountList);
		map.put("creditCardAmountList", creditCardAmountList);
		map.put("stdAmountList", stdAmountList);
		map.put("discountAmountList", discountAmountList);
		map.put("charityAmountList", charityAmountList);
		map.put("roundOffAmountList", roundOffAmountList);
		map.put("patientTypeAmountList", patientTypeAmountList);
		return map;
	}
	public Map<String, Object> postRefundVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> maxAccountIdList = new ArrayList<FaMasAccount>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<BlPaymentAdviceHeader> paymentAdviceHeaderList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> paymentAdviceDispensingHeaderList = new ArrayList<BlPymntAdviceDispHeader>();
		List<BlRefundHeader> refundHeaderList = new ArrayList<BlRefundHeader>();
		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			paymentAdviceHeaderList = session.createCriteria(BlPaymentAdviceHeader.class).add(Restrictions.between("payment_advice_date", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();
			paymentAdviceDispensingHeaderList = session.createCriteria(BlPymntAdviceDispHeader.class).add(Restrictions.between("payment_advice_date", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();
			refundHeaderList = session.createCriteria(BlPymntAdviceDispHeader.class).add(Restrictions.between("payment_advice_date", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("hospitalId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("RE");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
			hrMasFinancialYear.setId(box.getInt("fYear"));
		//	faVoucherHeader.setFYear(hrMasFinancialYear);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "RE");
			paramMap.put("voucherType", "Refund");
			 voucherNo = generateVoucherNo(paramMap);
			//faVoucherHeader.setVoucherNo(voucherNo);

			hbt.save(faVoucherHeader);
//======================================
			/*if(paymentAdviceHeaderList.size()>0){
				for(BlPaymentAdviceHeader paymentAdviceHeader : paymentAdviceHeaderList){
					int paymentAdviceHeaderId = paymentAdviceHeader.getId();
					BlPaymentAdviceHeader paymentAdviceHeader2= (BlPaymentAdviceHeader)hbt.load(BlPaymentAdviceHeader.class, paymentAdviceHeaderId);
					paymentAdviceHeader2.setVoucherNo(voucherNo);
					hbt.update(paymentAdviceHeader2);
				}
			}
			if(paymentAdviceDispensingHeaderList.size()>0){
				for(BlPymntAdviceDispHeader pymntAdviceDispHeader: paymentAdviceDispensingHeaderList){
					int pymentAdviceDispensingId = pymntAdviceDispHeader.getId();
					BlPymntAdviceDispHeader pymntAdviceDispHeader2= (BlPymntAdviceDispHeader)hbt.load(BlPymntAdviceDispHeader.class, pymentAdviceDispensingId);
					pymntAdviceDispHeader2.setVoucherNo(voucherNo);
					hbt.update(pymntAdviceDispHeader2);
				}
			}

			if(refundHeaderList.size()>0){
				for(BlRefundHeader refundHeader: refundHeaderList){
					int refundHeaderId  = refundHeader.getId();
					BlRefundHeader refundHeader2= (BlRefundHeader)hbt.load(BlRefundHeader.class, refundHeaderId);
					refundHeader2.setVoucherNo(voucherNo);
					hbt.update(refundHeader2);
				}
			}
*/
			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}

				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}


				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				 int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
			 	if(branchAccountId != 0){
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);

			 	}


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/* BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);
							//-------------------------update Branch account master-------------------------------------------------

						 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
						 	if(branchAccountMasterList.size()>0){
						 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
						 			 branchAccountId = faBranchAccountMaster.getId();
						 		}
						 	}

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);*/

				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "display");
				paramMap.put("prefix", "RE");
				paramMap.put("voucherType", "Refund");
				int voucherNo = generateVoucherNo(paramMap);
				map.put("voucherNo", voucherNo);
				map.put("saved", saved);
		return map;
	}
	public Map<String, Object> displayAdvanceVoucherBillingAmount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Object[]> companyAmountList = new ArrayList<Object[]>();
		List<Object[]> cashAmountList  = new ArrayList<Object[]>();
		List<Object[]> bankAmountList  = new ArrayList<Object[]>();
		List<Object[]> creditCardAmountList  = new ArrayList<Object[]>();
		List<Object[]> patientTypeAmountList  = new ArrayList<Object[]>();

		Session session = (Session)getSession();

		try {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//-----------------------For Total Billing--------------------------------------
			String companyQueryString = " select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
					" acc.acc_id , subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(rd.amount,0.0)),0.0) as adv_amt from  bl_receipt_details  rd " +
					" left join bl_receipt_header header  on header.receipt_header_id = rd.receipt_header_id " +
					" left join mas_company com on com.company_id = header.company_id " +
					" where header.company_id =1 and header.company_id is not null " +
					" and com.status='y' and header.company_id=com.company_id and header.receipt_date " +
					" between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) as com_acc from mas_company com " +
					" left join fa_mas_account acc on acc.acc_id = com.account_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where com.account_id is not null " +
					" union " +
					" select com.company_name,(select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acnt, (select sub_led_desc from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as subled, " +
					" (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, " +
					" (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group," +
					" (select ifnull(sum(ifnull(rd.amount,0.0)),0.0) as adv_amt " +
					" from bl_receipt_details  rd " +
					" left join bl_receipt_header header  on header.receipt_header_id = rd.receipt_header_id left join mas_company com " +
					" on com.company_id = header.company_id where header.company_id =1 " +
					" and header.company_id is not null and com.status='y' " +
					" and header.company_id=com.company_id and header.receipt_date " +
					"  between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' ) as com_acc " +
					" from  mas_company com where  com.account_id is null";

			companyAmountList = session.createSQLQuery(companyQueryString).list();

			String cashQueryString = "select sum(ifnull(rd.amount,0))as advanAmt,(select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Cash') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Cash') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp" +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Cash') as account_group " +
					" from  bl_receipt_header rh inner join bl_receipt_details rd on rh.receipt_header_id = rd.receipt_header_id " +
					" where rh.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  rh.receipt_type ='adv' and  payment_mode='C' ";
			cashAmountList = session.createSQLQuery(cashQueryString).list();
			String bankQueryString = "select sum(ifnull(rd.amount,0))as advanAmt,(select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Bank') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Bank') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp" +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Bank') as account_group " +
					" from  bl_receipt_header rh inner join bl_receipt_details rd on rh.receipt_header_id = rd.receipt_header_id " +
					" where rh.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  rh.receipt_type ='adv' and  payment_mode='Q'";
			bankAmountList = session.createSQLQuery(bankQueryString).list();
			String creditCardQueryString = "select sum(ifnull(rd.amount,0))as advanAmt,(select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Credit Card') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
					" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
					" where account_type='Credit Card') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp" +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
					" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Credit Card') as account_group " +
					" from  bl_receipt_header rh inner join bl_receipt_details rd on rh.receipt_header_id = rd.receipt_header_id " +
					" where rh.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and  rh.receipt_type ='adv' and  payment_mode='R'";
			creditCardAmountList = session.createSQLQuery(creditCardQueryString).list();

			String patientTypeString = " select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
					" acc.acc_id ,subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
					" (select ifnull(sum(ifnull(rd.amount,0.0)),0.0) as adv_amt from bl_receipt_details  rd " +
					" left join bl_receipt_header header  on header.receipt_header_id = rd.receipt_header_id " +
					" left join mas_patient_type pt on pt.patient_type_id = header.patient_type_id " +
					" where pt.patient_type_code not in('COM','PRJ') and pt.acc_id is not null and " +
					" header.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' and pt.status='y' and receipt_type='adv' " +
					" and ptmain.patient_type_id=header.patient_type_id )as advAcc from mas_patient_type ptmain " +
					" left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is not null and ptmain.status='y' " +
					" union " +
					" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt," +
					" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled " +
					" on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
					" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_accounts_parameter fp " +
					" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
					" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
					" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
					" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
					" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
					" where account_type='Mis.Account') as account_group, (select ifnull(sum(ifnull(rd.amount,0.0)),0.0) as adv_amt " +
					" from bl_receipt_details  rd left join bl_receipt_header header  on header.receipt_header_id = rd.receipt_header_id left join mas_patient_type pt on pt.patient_type_id = header.patient_type_id " +
					" where  pt.patient_type_code not in('COM','PRJ') and pt.acc_id is null and header.receipt_date between '"+java.sql.Date.valueOf(fromDate4MySQL)+"' and '"+java.sql.Date.valueOf(toDate4MySQL)+"' " +
					" and pt.status='y' and ptmain.patient_type_id=header.patient_type_id )as adv_acc " +
					" from mas_patient_type ptmain where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is null and status='y'";
		patientTypeAmountList = session.createSQLQuery(patientTypeString).list();



		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("cashAmountList", cashAmountList);
		map.put("bankAmountList", bankAmountList);
		map.put("creditCardAmountList", creditCardAmountList);
		map.put("patientTypeAmountList", patientTypeAmountList);
		map.put("companyAmountList", companyAmountList);

		return map;
	}
	public Map<String, Object> postAdvanceVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();

		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;


		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("hospitalId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("RE");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			/*HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
			hrMasFinancialYear.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(hrMasFinancialYear);*/
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "AD");
			paramMap.put("voucherType", "Advance");
			 voucherNo = generateVoucherNo(paramMap);
			//faVoucherHeader.setVoucherNo(voucherNo);

			hbt.save(faVoucherHeader);
//======================================
			/*if(receiptHeaderList.size()>0){
				for(BlReceiptHeader receiptHeader : receiptHeaderList){
					int receiptHeaderId = receiptHeader.getId();
					BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, receiptHeaderId);
					receiptHeader2.setVoucherNo(voucherNo);
					hbt.update(receiptHeader2);
				}
			}*/

			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}

				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}


				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				 int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
			 	if(branchAccountId != 0){
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);

			 	}


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/* BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);
							//-------------------------update Branch account master-------------------------------------------------

						 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
						 	if(branchAccountMasterList.size()>0){
						 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
						 			 branchAccountId = faBranchAccountMaster.getId();
						 		}
						 	}

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);*/

				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "AD");
			paramMap.put("voucherType", "Advance");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			map.put("saved", saved);
		return map;
	}
	public Map<String, Object> dispalyFinalSettlementVoucherAmount(Box box) {
		  Map<String, Object> map = new HashMap<String, Object>();
		  List<Object[]> mainChargeAmountList = new ArrayList<Object[]>();
			List<Object[]> companyRefundAmountList = new ArrayList<Object[]>();
			List<Object[]> companyReceiptAmountList = new ArrayList<Object[]>();
			List<Object[]> cashReceiptAmountList  = new ArrayList<Object[]>();
			List<Object[]> cashRefundAmountList  = new ArrayList<Object[]>();
			List<Object[]> bankReceiptAmountList  = new ArrayList<Object[]>();
			List<Object[]> bankRefundAmountList  = new ArrayList<Object[]>();
			List<Object[]> creditCardReceiptAmountList  = new ArrayList<Object[]>();
			List<Object[]> creditCardRefundAmountList  = new ArrayList<Object[]>();
			List<Object[]> patientTypeReceiptAmountList  = new ArrayList<Object[]>();
			List<Object[]> patientTypeRefundAmountList  = new ArrayList<Object[]>();
			Session session = (Session)getSession();

			try {
				SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
				String fromDate4MySQL = "";
				String toDate4MySQL = "";
				try {
					fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
					 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				//-----------------------For Total Billing--------------------------------------


				String companyReceiptQueryString = "select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
						" acc.acc_id , subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
						" (select ifnull(sum(ifnull(detail.amount,0.0)),0.0) as adv_amt from  bl_final_bill_details finalDetail inner join " +
						" bl_receipt_header header on header.ip_final_bill_id = finalDetail.final_bill_details_id " +
						" inner join bl_receipt_details detail on detail.receipt_header_id = header.receipt_header_id " +
						" inner join mas_company com on com.company_id = header.company_id " +
						" where header.company_id =1 and header.company_id is not null and com.status='y' " +
						" and header.company_id=com.company_id and header.receipt_date between '2010-10-01' and '2010-11-15' ) as com_acc from mas_company com " +
						" left join fa_mas_account acc on acc.acc_id = com.account_id left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where com.account_id is not null " +
						" union " +
						" select com.company_name,(select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" where account_type='Mis.Account') as acnt,(select sub_led_desc from fa_accounts_parameter fp " +
						" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Mis.Account') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Mis.Account') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
						" on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, " +
						" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_group," +
						" (select ifnull(sum(ifnull(detail.amount,0.0)),0.0) as adv_amt from bl_final_bill_details finalDetail inner join " +
						" bl_receipt_header header on header.ip_final_bill_id = finalDetail.final_bill_details_id " +
						" inner join bl_receipt_details detail on detail.receipt_header_id = header.receipt_header_id " +
						" left join mas_company com on com.company_id = header.company_id " +
						" where header.company_id =1 and header.company_id is not null and com.status='y' " +
						" and header.company_id=com.company_id and header.receipt_date between '2010-10-01' and '2010-11-12' ) as com_acc from  mas_company com where  com.account_id is null ";

				companyReceiptAmountList = session.createSQLQuery(companyReceiptQueryString).list();

				String companyRefundQueryString = " select com.company_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
						" acc.acc_id , subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
						" (select ifnull(sum(ifnull(rfDetail.refund_amount,0.0)),0.0) as adv_amt from  bl_refund_details rfDetail inner join " +
						" bl_refund_header header on header.refund_header_id = rfDetail.refund_header_id " +
						" inner join bl_final_bill_details detail on detail.final_bill_details_id = header.final_bill_id " +
						" inner join mas_company com on com.company_id = detail.company_id where detail.company_id =1 and detail.company_id is not null " +
						" and com.status='y' and detail.company_id=com.company_id and header.refund_date between '2010-10-01' and '2010-11-15' ) as com_acc from mas_company com " +
						" left join fa_mas_account acc on acc.acc_id = com.account_id left join fa_mas_sub_led subled on subled.sub_led_id = com.sub_led_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where com.account_id is not null " +
						" union " +
						" select com.company_name,(select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt," +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Mis.Account') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Mis.Account') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
						" on subgrp.account_group_id = grp.account_group_id where account_type='Mis.Account') as account_sub_group, " +
						" (select grp.account_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id  where account_type='Mis.Account') as account_group," +
						" (select ifnull(sum(ifnull(rfDetail.refund_amount,0.0)),0.0) as adv_amt from  bl_refund_details rfDetail inner join " +
						" bl_refund_header header on header.refund_header_id = rfDetail.refund_header_id inner join bl_final_bill_details detail " +
						" on detail.final_bill_details_id = header.final_bill_id left join mas_company com on com.company_id = detail.company_id " +
						" where detail.company_id =1 and detail.company_id is not null and com.status='y'" +
						" and detail.company_id=com.company_id and header.refund_date between '2010-10-01' and '2010-11-12' ) as com_acc" +
						" from  mas_company com where  com.account_id is null";

		companyRefundAmountList = session.createSQLQuery(companyRefundQueryString).list();


				String cashReceiptQueryString = "select sum(ifnull(rcDetail.amount,0)), (select acc_desc from fa_accounts_parameter fp" +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_sub_group,(select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_group from bl_final_bill_details blDetail left join bl_receipt_header rh " +
						" on rh.ip_final_bill_id=blDetail.final_bill_details_id inner join bl_receipt_details rcDetail on rcDetail.receipt_header_id = rh.receipt_header_id " +
						" where rh.receipt_date between '2010-10-01' and '2010-11-15' and payment_mode='c' and receipt_type ='fs' ";

				cashReceiptAmountList = session.createSQLQuery(cashReceiptQueryString).list();

				String cashRefundQueryString = "select sum(ifnull(rfDetail.refund_amount,0)),(select acc_desc from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Cash') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Cash') as subled, " +
						" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" where account_type='Cash') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp " +
						" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						"  where account_type='Cash') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
						" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
						" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp" +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Cash') as account_group from bl_final_bill_details blDetail left join bl_refund_header rh " +
						" on rh.final_bill_id=blDetail.final_bill_details_id inner join bl_refund_details rfDetail on rfDetail.refund_header_id = rh.refund_header_id " +
						" where rh.refund_date between '2010-10-01' and '2010-11-15' and payment_mode='c'";

				cashRefundAmountList = session.createSQLQuery(cashRefundQueryString).list();

				String bankQueryReceiptString = "select sum(ifnull(rcDetail.amount,0)), (select acc_desc from fa_accounts_parameter fp" +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Bank') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Bank') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Bank') as account_sub_group,(select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Bank') as account_group from bl_final_bill_details blDetail left join bl_receipt_header rh " +
						" on rh.ip_final_bill_id=blDetail.final_bill_details_id inner join bl_receipt_details rcDetail on rcDetail.receipt_header_id = rh.receipt_header_id " +
						" where rh.receipt_date between '2010-10-01' and '2010-11-15' and payment_mode='Q' and receipt_type ='fs' ";
				bankReceiptAmountList = session.createSQLQuery(bankQueryReceiptString).list();

				String bankQueryRefundString = "select sum(ifnull(rfDetail.refund_amount,0)),(select acc_desc from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Bank') as acnt, " +
				" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				" where account_type='Bank') as subled, " +
				" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" where account_type='Bank') as acc_id, " +
				" (select subled.sub_led_id from fa_accounts_parameter fp " +
				" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				"  where account_type='Bank') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Bank') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp" +
				" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Bank') as account_group from bl_final_bill_details blDetail left join bl_refund_header rh " +
				" on rh.final_bill_id=blDetail.final_bill_details_id inner join bl_refund_details rfDetail on rfDetail.refund_header_id = rh.refund_header_id " +
				" where rh.refund_date between '2010-10-01' and '2010-11-15' and payment_mode='Q'";
				bankReceiptAmountList = session.createSQLQuery(bankQueryRefundString).list();

				String creditCardReceiptQueryString = "select sum(ifnull(rcDetail.amount,0)), (select acc_desc from fa_accounts_parameter fp" +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
						" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Credit Card') as subled, (select acc.acc_id  from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acc_id, " +
						" (select subled.sub_led_id from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
						" where account_type='Credit Card') as sub_led_id, (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp on " +
						" acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Credit Card') as account_sub_group,(select grp.account_group_id from fa_accounts_parameter fp " +
						" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
						" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
						" where account_type='Credit Card') as account_group from bl_final_bill_details blDetail left join bl_receipt_header rh " +
						" on rh.ip_final_bill_id=blDetail.final_bill_details_id inner join bl_receipt_details rcDetail on rcDetail.receipt_header_id = rh.receipt_header_id " +
						" where rh.receipt_date between '2010-10-01' and '2010-11-15' and payment_mode='R' and receipt_type ='fs'";
				creditCardReceiptAmountList = session.createSQLQuery(creditCardReceiptQueryString).list();

				String creditCardRefundQueryString = "select sum(ifnull(rfDetail.refund_amount,0)),(select acc_desc from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Credit Card') as acnt, " +
				" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				" where account_type='Credit Card') as subled, " +
				" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" where account_type='Credit Card') as acc_id, " +
				" (select subled.sub_led_id from fa_accounts_parameter fp " +
				" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id " +
				"  where account_type='Credit Card') as sub_led_id,(select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Credit Card') as account_sub_group, (select grp.account_group_id from fa_accounts_parameter fp " +
				" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp" +
				" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				" where account_type='Credit Card') as account_group from bl_final_bill_details blDetail left join bl_refund_header rh " +
				" on rh.final_bill_id=blDetail.final_bill_details_id inner join bl_refund_details rfDetail on rfDetail.refund_header_id = rh.refund_header_id " +
				" where rh.refund_date between '2010-10-01' and '2010-11-15' and payment_mode='R'";
				creditCardRefundAmountList = session.createSQLQuery(creditCardRefundQueryString).list();

				 String patientTypeReceiptString = "select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled," +
				 		" acc.acc_id ,subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
				 		" (select ifnull(sum(ifnull(detail.amount,0.0)),0.0) as adv_amt from bl_receipt_details detail inner join " +
				 		" bl_receipt_header header on header.receipt_header_id = detail.receipt_header_id " +
				 		" inner join bl_final_bill_details finaldetail on finaldetail.final_bill_details_id = header.ip_final_bill_id " +
				 		" left join mas_patient_type pt on pt.patient_type_id = header.patient_type_id where pt.patient_type_code not in('COM','PRJ') " +
				 		" and pt.acc_id is not null and header.receipt_date between '2010-10-01' and '2010-11-15' and pt.status='y' " +
				 		" and receipt_type='fs' and ptmain.patient_type_id=header.patient_type_id )as advAcc " +
				 		" from mas_patient_type ptmain left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
				 		" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id left join fa_mas_account_sub_group subgrp " +
				 		" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
				 		" on subgrp.account_group_id = grp.account_group_id where  ptmain.patient_type_code not in('COM','PRJ') " +
				 		" and ptmain.acc_id is not null and ptmain.status='y' " +
				 		" union " +
				 		" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id where account_type='Mis.Account') as acnt," +
				 		" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled " +
				 		" on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as subled, " +
				 		" (select acc.acc_id  from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" where account_type='Mis.Account') as acc_id, (select subled.sub_led_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
				 		" (select subgrp.account_sub_group_id from fa_accounts_parameter fp left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				 		" where account_type='Mis.Account') as account_sub_group,(select grp.account_group_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id left join fa_mas_account_sub_group subgrp " +
				 		" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				 		" where account_type='Mis.Account') as account_group, (select ifnull(sum(ifnull(detail.amount,0.0)),0.0) as adv_amt " +
				 		" from bl_receipt_details detail inner join bl_receipt_header header on header.receipt_header_id = detail.receipt_header_id " +
				 		" inner join bl_final_bill_details finaldetail on finaldetail.final_bill_details_id = header.ip_final_bill_id " +
				 		" left join mas_patient_type pt on pt.patient_type_id = header.patient_type_id where  pt.patient_type_code not in('COM','PRJ') " +
				 		" and pt.acc_id is null and header.receipt_date between '2010-10-01' and '2010-11-15' and pt.status='y' " +
				 		" and ptmain.patient_type_id=header.patient_type_id )as adv_acc from mas_patient_type ptmain " +
				 		" where  ptmain.patient_type_code not in('COM','PRJ') and ptmain.acc_id is null and status='y'";
				 patientTypeReceiptAmountList = session.createSQLQuery(patientTypeReceiptString).list();

				 String patientTypeRefundString = "select ptmain.patient_type_name, acc.acc_desc as acnt, subled.sub_led_desc as subled, " +
				 		" acc.acc_id ,subled.sub_led_id,subgrp.account_sub_group_id,grp.account_group_id, " +
				 		" (select ifnull(sum(ifnull(detail.refund_amount,0.0)),0.0) as adv_amt from bl_refund_details detail inner join " +
				 		" bl_refund_header header on header.refund_header_id = detail.refund_header_id " +
				 		" inner join bl_final_bill_details finaldetail on finaldetail.final_bill_details_id = header.final_bill_id " +
				 		" left join mas_patient_type pt on pt.patient_type_id = finaldetail.patient_type_id " +
				 		" where pt.patient_type_code not in('COM','PRJ') and pt.acc_id is not null and " +
				 		" header.refund_date between '2010-10-01' and '2010-11-15' and pt.status='y' and header.final_bill_id is not null " +
				 		" and ptmain.patient_type_id=finaldetail.patient_type_id )as advAcc from mas_patient_type ptmain " +
				 		" left join fa_mas_account acc on acc.acc_id = ptmain.acc_id " +
				 		" left join fa_mas_sub_led subled on subled.sub_led_id = ptmain.sub_led_id left join fa_mas_account_sub_group subgrp " +
				 		" on acc.account_sub_group_id = subgrp.account_sub_group_id left join fa_mas_account_group grp " +
				 		" on subgrp.account_group_id = grp.account_group_id where  ptmain.patient_type_code not in('COM','PRJ') " +
				 		" and ptmain.acc_id is not null and ptmain.status='y' " +
				 		" union " +
				 		" select ptmain.patient_type_name, (select acc_desc from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id where " +
				 		" account_type='Mis.Account') as acnt," +
				 		" (select sub_led_desc from fa_accounts_parameter fp left join fa_mas_sub_led subled " +
				 		" on subled.sub_led_id = fp.sub_led_id " +
				 		" where account_type='Mis.Account') as subled, " +
				 		" (select acc.acc_id  from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" where account_type='Mis.Account') as acc_id, " +
				 		" (select subled.sub_led_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_sub_led subled on subled.sub_led_id = fp.sub_led_id where account_type='Mis.Account') as sub_led_id, " +
				 		" (select subgrp.account_sub_group_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" left join fa_mas_account_sub_group subgrp on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				 		" where account_type='Mis.Account') as account_sub_group, " +
				 		" (select grp.account_group_id from fa_accounts_parameter fp " +
				 		" left join fa_mas_account acc on acc.acc_id = fp.account_id " +
				 		" left join fa_mas_account_sub_group subgrp " +
				 		" on acc.account_sub_group_id = subgrp.account_sub_group_id " +
				 		" left join fa_mas_account_group grp on subgrp.account_group_id = grp.account_group_id " +
				 		" where account_type='Mis.Account') as account_group, " +
				 		" (select ifnull(sum(ifnull(detail.refund_amount,0.0)),0.0) as adv_amt " +
				 		" from bl_refund_details detail inner join bl_refund_header header " +
				 		"on header.refund_header_id = detail.refund_header_id inner join bl_final_bill_details finaldetail " +
				 		" on finaldetail.final_bill_details_id = header.final_bill_id left join mas_patient_type pt " +
				 		" on pt.patient_type_id = finaldetail.patient_type_id where  pt.patient_type_code not in('COM','PRJ') " +
				 		" and pt.acc_id is null and header.final_bill_id is not null and header.refund_date between '2010-10-01' and '2010-11-15' " +
				 		"and pt.status='y' and ptmain.patient_type_id=finaldetail.patient_type_id )as adv_acc " +
				 		" from mas_patient_type ptmain where  ptmain.patient_type_code not in('COM','PRJ') " +
				 		" and ptmain.acc_id is null and status='y'";
			 patientTypeReceiptAmountList = session.createSQLQuery(patientTypeRefundString).list();

			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("companyReceiptAmountList", companyReceiptAmountList);
			map.put("companyRefundAmountList", companyRefundAmountList);
			map.put("cashReceiptAmountList", cashReceiptAmountList);
			map.put("cashRefundAmountList", cashRefundAmountList);
			map.put("bankReceiptAmountList", bankReceiptAmountList);
			map.put("bankRefundAmountList", bankRefundAmountList);
			map.put("creditCardReceiptAmountList", creditCardReceiptAmountList);
			map.put("creditCardRefundAmountList", creditCardRefundAmountList);
			map.put("patientTypeReceiptAmountList", patientTypeReceiptAmountList);
			map.put("patientTypeRefundAmountList", patientTypeRefundAmountList);
		return map;
	}
	public Map<String, Object> postFinalSettlementVoucherMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();

		List<FaBranchAccountMaster> branchAccountMasterList = new ArrayList<FaBranchAccountMaster>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean saved = false;

		try {
			tx = session.beginTransaction();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate4MySQL = "";
			String toDate4MySQL = "";
			int voucherNo = 0;
			try {
				fromDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(FROM_DATE)));
				 toDate4MySQL = formatterOut.format(formatterIn.parse(box.getString(TO_DATE)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.between("ReceiptDate", java.sql.Date.valueOf(fromDate4MySQL), java.sql.Date.valueOf(toDate4MySQL))).list();


			FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId( box.getInt("hospitalId"));
			faVoucherHeader.setHospital(masHospital);
			faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setNarration(box.getString(NARRATION));
			Users users = new Users();
			users.setId( box.getInt("changedBy"));
			faVoucherHeader.setLastChgBy(users);
			faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			faVoucherHeader.setVoucherType("FS");
			faVoucherHeader.setStatus("y");
			BigDecimal totalAmountDr = new BigDecimal(0.0);
			BigDecimal totalAmountCr = new BigDecimal(0.0);
			if (!box.getString(TOTAL_DR_AMOUNT).equals("")) {
				totalAmountDr = new BigDecimal(box.getString(TOTAL_DR_AMOUNT));
				faVoucherHeader.setDrAmount(totalAmountDr);
			}
			if (!box.getString(TOTAL_CR_AMOUNT).equals("")) {
				totalAmountCr = new BigDecimal(box.getString(TOTAL_CR_AMOUNT));
				faVoucherHeader.setCrAmount(totalAmountCr);
			}
			MasStoreFinancial hrMasFinancialYear = new MasStoreFinancial();
			hrMasFinancialYear.setId(box.getInt("fYear"));
			faVoucherHeader.setFYear(hrMasFinancialYear);
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "save");
			paramMap.put("prefix", "FS");
			paramMap.put("voucherType", "FinalSettlement");
			 voucherNo = generateVoucherNo(paramMap);
			//faVoucherHeader.setVoucherNo(voucherNo);

			hbt.save(faVoucherHeader);
//======================================
			/*if(receiptHeaderList.size()>0){
				for(BlReceiptHeader receiptHeader : receiptHeaderList){
					int receiptHeaderId = receiptHeader.getId();
					BlReceiptHeader receiptHeader2= (BlReceiptHeader)hbt.load(BlReceiptHeader.class, receiptHeaderId);
					receiptHeader2.setVoucherNo(voucherNo);
					hbt.update(receiptHeader2);
				}
			}*/

			int counter = box.getInt("counter");
			for (int i = 1; i < counter; i++) {
				int accountId = 0;
				BigDecimal crAmt = new BigDecimal(0.00);
				BigDecimal drAmt = new BigDecimal(0.00);

				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				FaMasAccount account = new FaMasAccount();
				accountId = box.getInt("accId"+i);
				account.setId(accountId);
				voucherDetails.setAccount(account);
				voucherDetails.setVoucherHeader(faVoucherHeader);
				if(box.getInt("subLedId"+i) != 0){
					FaMasSubLed subLed= new FaMasSubLed();
					subLed.setId(box.getInt("subLedId"+i));
					voucherDetails.setSubLed(subLed);
				}
				voucherDetails.setReconcile("n");
				if(!box.getString("crAmtId"+i).equals("")){
					crAmt = new BigDecimal(box.getString("crAmtId"+i));
					voucherDetails.setCrAmount(crAmt);
				}

				if(!box.getString("drAmtId"+i).equals("")){
					drAmt = new BigDecimal(box.getString("drAmtId"+i));
					voucherDetails.setDrAmount(drAmt);
				}


				hbt.save(voucherDetails);

				//-------------------------update account group-------------------------------------------------

				BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
				BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
				BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
				BigDecimal drGroupAmount = new BigDecimal(0.0);
				BigDecimal crGroupAmount = new BigDecimal(0.0);

				int groupId = box.getInt("grpId"+i);
				int subGroupId = box.getInt("subGroupId"+i);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
				if(faMasAccountGroup.getOpBalanceCr()!= null){
					groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
				}
				if(faMasAccountGroup.getOpBalanceDr()!= null){
					groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
				}
				if(faMasAccountGroup.getYtdAmountDr()!= null){
					groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
				}
				if(faMasAccountGroup.getYtdAmountCr()!= null){
					groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
				}
				if(drAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
					 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
				 }
				if(crAmt.compareTo(new BigDecimal(0))>0){
					 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
					 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
				 }
				drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
				crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
				if(drGroupAmount.compareTo(crGroupAmount)>0){
					faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
				    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)>0){
					faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}else if(crGroupAmount.compareTo(drGroupAmount)==0){
					faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
				    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
				}

			 	hbt.update(faMasAccountGroup);

	//-------------------------update account Sub group-------------------------------------------------

			 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
				BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
				BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
				BigDecimal drSubGroupAmount = new BigDecimal(0.0);
				BigDecimal crSubGroupAmount = new BigDecimal(0.0);

				FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
				 if(accountSubGroup.getOpBalanceDr()!= null){
					 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
				 }
				 if(accountSubGroup.getOpBalanceCr()!= null){
					 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
				 }
				 if(accountSubGroup.getYtdAmountDr()!= null){
					 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
				 }
				 if(accountSubGroup.getYtdAmountCr()!= null){
					 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
				 }
				 if(drAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
					 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
					 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
				 }
				 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
				 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

			 	hbt.update(accountSubGroup);

	//-------------------------update account master-------------------------------------------------

				BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
		 		if(masAccount.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
		 		}
		 		if(masAccount.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount.getOpBalanceCr();
		 		}

		 		 if(masAccount.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
		 		 }
		 		 if(masAccount.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
		 		 }
		 		if(drAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
					 masAccount.setYtdAmountDr(accountYtdBalanceDr);
				 }
				 if(crAmt.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
					 masAccount.setYtdAmountCr(accountYtdBalanceCr);
				 }
				 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
				 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount.setClBalanceCr(new BigDecimal(0.00));
						masAccount.setClBalanceDr(new BigDecimal(0.00));
					}


				 hbt.update(masAccount);
//------------------------------------------
				//-------------------------update Branch account master-------------------------------------------------
				 int branchAccountId = 0;
				 int branchSubLedId = 0;
				 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
				 	if(branchAccountMasterList.size()>0){
				 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
				 			 branchAccountId = faBranchAccountMaster.getId();
				 		}
				 	}
			 	if(branchAccountId != 0){
					BigDecimal accountBranchOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountBranchYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountBranchAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountBranchAmount = new  BigDecimal(0.0);
			 		FaBranchAccountMaster faBranchAccountMaster = (FaBranchAccountMaster)hbt.load(FaBranchAccountMaster.class,branchAccountId);
			 		if(faBranchAccountMaster.getOpBalanceDr()!= null){
			 			accountBranchOpBalanceDr =  faBranchAccountMaster.getOpBalanceDr();
			 		}
			 		if(faBranchAccountMaster.getOpBalanceCr()!= null){
			 			accountBranchOpBalanceCr = faBranchAccountMaster.getOpBalanceCr();
			 		}

			 		 if(faBranchAccountMaster.getYtdBalanceDr() != null){
			 			accountBranchYtdBalanceDr = faBranchAccountMaster.getYtdBalanceDr();
			 		 }
			 		 if(faBranchAccountMaster.getYtdBalanceCr() != null){
			 			accountBranchYtdBalanceCr = faBranchAccountMaster.getYtdBalanceCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
			 			accountBranchYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountBranchYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountBranchAmount = accountBranchOpBalanceDr.add(accountBranchYtdBalanceDr);
					 crAccountBranchAmount = accountBranchOpBalanceCr.add(accountBranchYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							faBranchAccountMaster.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							faBranchAccountMaster.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							faBranchAccountMaster.setClBalanceCr(new BigDecimal(0.00));
							faBranchAccountMaster.setClBalanceDr(new BigDecimal(0.00));
						}


					 hbt.update(faBranchAccountMaster);

			 	}


				//-----------------------update account sub ledger==================================

				 if(box.getInt("subLedId"+i)!=0){
					 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
					 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
					 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
					 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
					 BigDecimal crAmountSubLedger = new BigDecimal(0.0);

					 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
					 if(subLed.getOpBalanceCr()!= null){
						 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
					 }
					 if(subLed.getOpBalanceDr()!= null){
						 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
					 }

					if(subLed.getYtdAmountCr()!= null){
						subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
					}
					if(subLed.getYtdAmountDr()!= null){
						subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
						subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
						 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
					 }


					 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
					drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);

					if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
						subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
						subLed.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
						subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
						subLed.setClBalanceCr(new BigDecimal(0.00));
						subLed.setClBalanceDr(new BigDecimal(0.00));
					}
						 hbt.update(subLed);

//=============================================For update Sub Led Branch ===================

						/* BigDecimal subBranchLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subBranchLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drBranchAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crBranchAmountSubLedger = new BigDecimal(0.0);
							//-------------------------update Branch account master-------------------------------------------------

						 branchAccountMasterList = session.createCriteria(FaBranchAccountMaster.class).add(Restrictions.eq("Account.Id", accountId)).list();
						 	if(branchAccountMasterList.size()>0){
						 		for(FaBranchAccountMaster faBranchAccountMaster :branchAccountMasterList){
						 			 branchAccountId = faBranchAccountMaster.getId();
						 		}
						 	}

						 FaMasSubLed subLed1 = (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt("subLedId"+i));
						 if(subLed1.getOpBalanceCr()!= null){
							 subBranchLedgerOPBalanceCr =  subLed1.getOpBalanceCr();
						 }
						 if(subLed1.getOpBalanceDr()!= null){
							 subBranchLedgerOPBalanceDr = subLed1.getOpBalanceDr();
						 }

						if(subLed1.getYtdAmountCr()!= null){
							subBranchLedgerYTDBalanceCr = subLed1.getYtdAmountCr();
						}
						if(subLed1.getYtdAmountDr()!= null){
							subBranchLedgerYTDBalanceDr = subLed1.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subBranchLedgerYTDBalanceDr = subBranchLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subBranchLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subBranchLedgerYTDBalanceCr = subBranchLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subBranchLedgerYTDBalanceCr);
						 }


						 crAmountSubLedger = subBranchLedgerOPBalanceCr.add(subBranchLedgerYTDBalanceCr);
						drAmountSubLedger = subBranchLedgerOPBalanceDr.add(subBranchLedgerYTDBalanceDr);

						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed1.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed1.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed1.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed1.setClBalanceCr(new BigDecimal(0.00));
							subLed1.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed1);*/

				 }
			}
			tx.commit();
			saved = true;

			} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}

			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "FS");
			paramMap.put("voucherType", "FinalSettlement");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			map.put("saved", saved);
		return map;
	}
	public Map<String, Object> closingFinancialYear(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> prevFinancialYearList = new ArrayList<HrMasFinancialYear>();
		List<FaMasAccount> currentYearAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> sudLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		String finYear = box.getString("finYear");
		int finYearId = box.getInt("fYear");

		String firstYear = finYear.substring(0, 4);
		String lastYear = finYear.substring(2, 4);
		String previousyear = Integer.parseInt(firstYear)-(1)+"-"+lastYear;
		Session session = (Session)getSession();

		prevFinancialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("FinancialYear", previousyear)).list();
		int fYearId = prevFinancialYearList.get(0).getId();
		currentYearAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", finYearId)).list();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("FYear.Id", fYearId)).list();
		int currentYearAccountId = 0;
		int prevYearAccountId = 0;
		
		if(currentYearAccountList.size()>0){
		for(FaMasAccount faMasAccount :currentYearAccountList ){
			 currentYearAccountId = faMasAccount.getId();
		 }
		}
		if(accountList.size()>0){
			for(FaMasAccount acc :accountList){
				prevYearAccountId = acc.getId();
			}
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int accountId = 0;
		if(currentYearAccountId == prevYearAccountId ){
			if(accountList.size()>0){
				for(FaMasAccount masAccount : accountList){
					int hospitalId = masAccount.getHospital().getId();
					int accCode = masAccount.getAccCode();
					String accDesc = masAccount.getAccDesc();
					int accounSubGroupId = masAccount.getAccountSubGroup().getId();
					String status = masAccount.getStatus();
					int lastChgBy = masAccount.getLastChgBy().getId();
					Date lastChgDate = masAccount.getLastChgDate();
					String lastChgTime = masAccount.getLastChgTime();
					BigDecimal clBalanceCr = masAccount.getClBalanceCr();
					BigDecimal  clBalanceDr = masAccount.getClBalanceDr();
					int schedule = masAccount.getScheduleDr().getId();
					int parentId = 0;
					if(masAccount.getParent() != null){
						 parentId = masAccount.getParent().getId();
					}
					String parentStatus = masAccount.getParentStatus();
					String subLedger = masAccount.getSubLedger();
					FaMasAccount account = (FaMasAccount) hbt.load(FaMasAccount.class,currentYearAccountId);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					account.setHospital(masHospital);
					account.setAccCode(accCode);
					account.setAccDesc(accDesc);
					account.setStatus(status);
					MasAccountSchedule scheduleObj = new MasAccountSchedule();
					scheduleObj.setId(schedule);
					account.setScheduleDr(scheduleObj);
					account.setOpBalanceCr(clBalanceCr);
					account.setOpBalanceDr(clBalanceDr);
					account.setYtdAmountCr(new BigDecimal(0.00));
					account.setYtdAmountDr(new BigDecimal(0.00));
					account.setClBalanceCr(clBalanceCr);
					account.setClBalanceDr(clBalanceDr);
					account.setParentStatus(parentStatus);
					account.setSubLedger(subLedger);
					account.setLastChgDate(lastChgDate);
					account.setLastChgTime(lastChgTime);
					/*if(lastChgBy != 0){
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(lastChgBy);
						account.setLastChgBy(masEmployee);
					}*/
					if(parentId !=0){
						FaMasAccount acc = new FaMasAccount();
						acc.setId(parentId);
						account.setParent(acc);
					}
					FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
					faMasAccountSubGroup.setId(accounSubGroupId);
					account.setAccountSubGroup(faMasAccountSubGroup);

					/*HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
					hrMasFinancialYear.setId(finYearId);
					account.setFYear(hrMasFinancialYear);
*/
					hbt.update(account);


				}
			}

		}else{

		//if(prevFinancialYearList.size()>0){
			if(accountList.size()>0){
				for(FaMasAccount masAccount : accountList){
					int hospitalId = masAccount.getHospital().getId();
					int accCode = masAccount.getAccCode();
					String accDesc = masAccount.getAccDesc();
					int accounSubGroupId = masAccount.getAccountSubGroup().getId();
					String status = masAccount.getStatus();
					int lastChgBy = masAccount.getLastChgBy().getId();
					Date lastChgDate = masAccount.getLastChgDate();
					String lastChgTime = masAccount.getLastChgTime();
					BigDecimal clBalanceCr = masAccount.getClBalanceCr();
					BigDecimal  clBalanceDr = masAccount.getClBalanceDr();
					int schedule = masAccount.getScheduleDr().getId();
					int parentId = 0;
					if(masAccount.getParent() != null){
						 parentId = masAccount.getParent().getId();
					}
					String parentStatus = masAccount.getParentStatus();
					String subLedger = masAccount.getSubLedger();

					FaMasAccount account = new FaMasAccount();
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					account.setHospital(masHospital);
					account.setAccCode(accCode);
					account.setAccDesc(accDesc);
					account.setStatus(status);
					MasAccountSchedule scheduleObj = new MasAccountSchedule();
					scheduleObj.setId(schedule);
					account.setScheduleDr(scheduleObj);
					account.setOpBalanceCr(clBalanceCr);
					account.setOpBalanceDr(clBalanceDr);
					account.setYtdAmountCr(new BigDecimal(0.00));
					account.setYtdAmountDr(new BigDecimal(0.00));
					account.setClBalanceCr(clBalanceCr);
					account.setClBalanceDr(clBalanceDr);
					account.setParentStatus(parentStatus);
					account.setSubLedger(subLedger);
					account.setLastChgDate(lastChgDate);
					account.setLastChgTime(lastChgTime);
					/*if(lastChgBy != 0){
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(lastChgBy);
						account.setLastChgBy(masEmployee);
					}*/
					if(parentId !=0){
						FaMasAccount acc = new FaMasAccount();
						acc.setId(parentId);
						account.setParent(acc);
					}
					FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
					faMasAccountSubGroup.setId(accounSubGroupId);
					account.setAccountSubGroup(faMasAccountSubGroup);

					/*HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
					hrMasFinancialYear.setId(finYearId);
					account.setFYear(hrMasFinancialYear);*/

					hbt.save(account);


				}
			}
		}

//=============================For SubLedger==============================================


					sudLedList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("FYear.Id", fYearId)).list();
					if(sudLedList.size()>0){
						for(FaMasSubLed faMasSubLed :sudLedList){

						FaMasSubLed subLed = new FaMasSubLed();

						MasHospital hospital = new MasHospital();
						hospital.setId(faMasSubLed.getHospital().getId());
						subLed.setHospital(hospital);
						subLed.setSubLedCode(faMasSubLed.getSubLedCode());
						subLed.setSubLedDesc(faMasSubLed.getSubLedDesc());

						FaMasAccount account2 = new FaMasAccount();
						account2.setId(faMasSubLed.getAccount().getId());
						subLed.setAccount(account2);

						subLed.setStatus(faMasSubLed.getStatus());
						subLed.setLastChgDate(faMasSubLed.getLastChgDate());
						subLed.setLastChgTime(faMasSubLed.getLastChgTime());
						//HrMasFinancialYear hrMasFinancialYear2 = new HrMasFinancialYear();
						//hrMasFinancialYear2.setId(finYearId);
						//subLed.setFYear(hrMasFinancialYear2);

						Users users = new Users();
						users.setId(faMasSubLed.getLastChgBy().getId());
						subLed.setLastChgBy(users);
						subLed.setOpBalanceCr(faMasSubLed.getClBalanceCr());
						subLed.setOpBalanceDr(faMasSubLed.getClBalanceDr());
						subLed.setYtdAmountCr(new BigDecimal(0.00));
						subLed.setYtdAmountDr(new BigDecimal(0.00));
						subLed.setClBalanceCr(faMasSubLed.getClBalanceCr());
						subLed.setClBalanceDr(faMasSubLed.getClBalanceDr());
						hbt.save(subLed);
					}
				}
				accountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("FYear.Id", fYearId)).list();
			if(accountGroupList.size()>0){
			  for(FaMasAccountGroup faMasAccountGroup :accountGroupList){

				FaMasAccountGroup masAccountGroup = new FaMasAccountGroup();
				masAccountGroup.setAccountGroupCode(faMasAccountGroup.getAccountGroupCode());
				masAccountGroup.setAccountGroupDesc(faMasAccountGroup.getAccountGroupDesc());
				masAccountGroup.setStatus(faMasAccountGroup.getStatus());
				masAccountGroup.setLastChgBy(faMasAccountGroup.getLastChgBy());
				masAccountGroup.setLastChgDate(faMasAccountGroup.getLastChgDate());
				masAccountGroup.setLastChgTime(faMasAccountGroup.getLastChgTime());
				MasHospital masHospital2 = new MasHospital();
				masHospital2.setId(faMasAccountGroup.getHospital().getId());
				masAccountGroup.setHospital(masHospital2);

				//HrMasFinancialYear masFinancialYear = new HrMasFinancialYear();
				//masFinancialYear.setId(finYearId);
				//masAccountGroup.setFYear(masFinancialYear);
				masAccountGroup.setOpBalanceCr(faMasAccountGroup.getClBalanceCr());
				masAccountGroup.setOpBalanceDr(faMasAccountGroup.getClBalanceDr());
				masAccountGroup.setYtdAmountCr(new BigDecimal(0.00));
				masAccountGroup.setYtdAmountDr(new BigDecimal(0.00));
				masAccountGroup.setClBalanceCr(faMasAccountGroup.getClBalanceCr());
				masAccountGroup.setClBalanceDr(faMasAccountGroup.getClBalanceDr());
				hbt.save(masAccountGroup);
			}
		}
				accountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("FYear.Id", fYearId)).list();
				if(accountSubGroupList.size()>0){
					for(FaMasAccountSubGroup faMasAccountSubGroup: accountSubGroupList){
						FaMasAccountSubGroup masAccountSubGroup = new FaMasAccountSubGroup();
						masAccountSubGroup.setAccountSubGroupCode(faMasAccountSubGroup.getAccountSubGroupCode());
						masAccountSubGroup.setAccountSubGroupName(faMasAccountSubGroup.getAccountSubGroupName());
						masAccountSubGroup.setStatus(faMasAccountSubGroup.getStatus());
						masAccountSubGroup.setLastChgBy(faMasAccountSubGroup.getLastChgBy());
						masAccountSubGroup.setLastChgDate(faMasAccountSubGroup.getLastChgDate());
						masAccountSubGroup.setLastChgTime(faMasAccountSubGroup.getLastChgTime());
						MasHospital masHospital = new MasHospital();
						masHospital.setId(faMasAccountSubGroup.getHospital().getId());
						masAccountSubGroup.setHospital(masHospital);

						//HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
						//hrMasFinancialYear.setId(finYearId);
						//masAccountSubGroup.setFYear(hrMasFinancialYear);

						FaMasAccountGroup masAccountGroup = new FaMasAccountGroup();
						masAccountGroup.setId(faMasAccountSubGroup.getAccountGroup().getId());
						masAccountSubGroup.setAccountGroup(masAccountGroup);

						masAccountSubGroup.setOpBalanceCr(faMasAccountSubGroup.getClBalanceCr());
						masAccountSubGroup.setOpBalanceDr(faMasAccountSubGroup.getClBalanceDr());
						masAccountSubGroup.setYtdAmountCr(new BigDecimal(0.00));
						masAccountSubGroup.setYtdAmountDr(new BigDecimal(0.00));
						masAccountSubGroup.setClBalanceCr(faMasAccountSubGroup.getClBalanceCr());
						masAccountSubGroup.setClBalanceDr(faMasAccountSubGroup.getClBalanceDr());
						hbt.save(masAccountSubGroup);

					}
				}

			//}
		//}

		return map;
	}


//===================================================Report's Code=================================================
	public Map<String, Object> showTrialBalanceReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> fYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		fYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).list();
		map.put("fYearList", fYearList);
		return map;
	}
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
//--------------------- Sub Led Report By Mansi

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSubLedJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<HrMasFinancialYear> fYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		accountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).list();
		fYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).list();
		map.put("accountList", accountList);
		map.put("fYearList", fYearList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public List<HrMasFinancialYear> getFinancialYearDate(int fYearId) {
		List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		financialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.idEq(fYearId)).list();
		return financialYearList;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOpeningBalance(Map<String, Object>generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaVoucherDetails> VoucherDtListList = new ArrayList<FaVoucherDetails>();

		String prevdate=null;
		String finFromDate=null;
		Date fromDate=null;
		Date fDate = null;
		Date to_date=null;
		if(generalMap.get("prevdate")!= null){
			prevdate = (String)generalMap.get("prevdate");
		}
		if(generalMap.get("finFromDate")!= null){
			finFromDate = (String)generalMap.get("finFromDate");
		}
		if(generalMap.get("from_date")!= null){
			fromDate = (Date)generalMap.get("from_date");
		}
		if(generalMap.get("to_date")!= null){
			to_date = (Date)generalMap.get("to_date");
		}
		if(generalMap.get("fDate")!= null){
			fDate = (Date)generalMap.get("fDate");
		}
		int accountId = 0;
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String prevdate1 = "";
		String finFromDate1= "";
		try {
			 prevdate1 = formatterOut.format(formatterIn.parse(prevdate));
			 finFromDate1 = formatterOut.format(formatterIn.parse(finFromDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BigDecimal accountDrOpBalance = new BigDecimal(0.0);
		BigDecimal accountCrOpBalance = new BigDecimal(0.0);
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
		if(accountList.size()>0){
			for(FaMasAccount faMasAccount :accountList){
				if(faMasAccount.getOpBalanceCr()!= null){
					accountCrOpBalance = faMasAccount.getOpBalanceCr();
				}
				if(faMasAccount.getOpBalanceDr()!= null){
					accountDrOpBalance = faMasAccount.getOpBalanceDr();
				}
			}
		}
		BigDecimal ytdDrAmount = new BigDecimal(0.0);
		BigDecimal ytdCrAmount = new BigDecimal(0.0);
		BigDecimal drAccountAmount = new BigDecimal(0.0);
		BigDecimal crAccountAmount = new BigDecimal(0.0);
		BigDecimal crAccountClBalance = new BigDecimal(0.0);
		BigDecimal drAccountClBalance = new BigDecimal(0.0);
		BigDecimal totalYtdCrAmount = new BigDecimal(0.0);
		BigDecimal totalYtdDrAmount = new BigDecimal(0.0);


		if(HMSUtil.convertDateToStringWithoutTime(fDate).equals(HMSUtil.convertDateToStringWithoutTime(fromDate))){

			voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
			.createAlias("VoucherHeader", "header")
			.add(Restrictions.between("header.VoucherDate",  (fDate),  (fromDate)))
			.add(Restrictions.eq("header.AccountSubGroup.Id", 2)).list();
			if(voucherDetailList.size()>0){
				for(FaVoucherDetails faVoucherDetails :voucherDetailList){
					if(faVoucherDetails.getCrAmount()!= null){
					 ytdCrAmount = faVoucherDetails.getCrAmount();
					 totalYtdCrAmount = totalYtdCrAmount.add(ytdCrAmount);


					}
					if(faVoucherDetails.getDrAmount()!= null){
					 ytdDrAmount = faVoucherDetails.getDrAmount();
					 totalYtdDrAmount = totalYtdDrAmount.add(ytdDrAmount);

				}
				}
			}
		}else{
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
			.createAlias("VoucherHeader", "header")
			.add(Restrictions.between("header.VoucherDate",  java.sql.Date.valueOf(finFromDate1),  java.sql.Date.valueOf(prevdate1)))
			.add(Restrictions.eq("header.AccountSubGroup.Id", 2)).list();
			if(voucherDetailList.size()>0){
				for(FaVoucherDetails faVoucherDetails :voucherDetailList){
					if(faVoucherDetails.getCrAmount()!= null){
					 ytdCrAmount = faVoucherDetails.getCrAmount();
					 totalYtdCrAmount = totalYtdCrAmount.add(ytdCrAmount);


					}
					if(faVoucherDetails.getDrAmount()!= null){
					 ytdDrAmount = faVoucherDetails.getDrAmount();
					 totalYtdDrAmount = totalYtdDrAmount.add(ytdDrAmount);

				}
				}
			}


		//String sqlStr = "select detail.dr_amount,detail.cr_amount,account.op_balance_cr,account.op_balance_dr from fa_voucher_details detail left join  fa_voucher_header header on detail.voucher_header_id=header.voucher_header_id left join fa_mas_account account on detail.account_id =account.acc_id left join fa_mas_account_sub_group  subgroup on subgroup.account_sub_group_id = header.account_sub_group_id  where header.voucher_date between '"+finFromDate1+"' and '"+prevdate1+"' and subgroup.account_sub_group_id = 2 and account.acc_id = "+accountId+" ";




	}
			crAccountAmount = accountCrOpBalance.add(totalYtdCrAmount);
			drAccountAmount = 	accountDrOpBalance.add(totalYtdDrAmount);

			if(drAccountAmount.compareTo(crAccountAmount)>0){
				drAccountClBalance = drAccountAmount.subtract(crAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)>0){
				crAccountClBalance = crAccountAmount.subtract(drAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)==0){
				crAccountClBalance = new BigDecimal(0.00);
				drAccountClBalance= new BigDecimal(0.00);

			}
			map.put("voucherDetailList", voucherDetailList);
			map.put("drAccountClBalance", drAccountClBalance);
			map.put("crAccountClBalance", crAccountClBalance);

		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showCashRegisterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session =(Session)getSession();
		List<String>aList=new ArrayList<String>();
		aList.add("1");
		aList.add("2");
		Object[] jSelectedId = {1,2};

		accountList = session.createCriteria(FaMasAccount.class)
		//.add(Restrictions.eq("FYear.Id", fYearId))
		.createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Flag", jSelectedId)).list();
		map.put("accountList", accountList);
		return map;
	}
	public Map<String, Object> showLedgerBookJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subledgerList = new ArrayList<FaMasSubLed>();
		Object[] selectedId = {1,2};
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class)
		//.add(Restrictions.eq("FYear.Id", fYearId))
		.createAlias("AccountSubGroup", "subGroup").add(Restrictions.not(Restrictions.in("subGroup.Id", selectedId))).list();
			map.put("accountList", accountList);
		subledgerList = session.createCriteria(FaMasSubLed.class).list();
			map.put("subledgerList", subledgerList);
		return map;
	}

	//-----------------------fa_voucherJsp By Ujjwal------------------------------------------------

	public Map<String, Object> showfavoucherJsp(int fYearId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherHeader> voucherlist = new ArrayList<FaVoucherHeader>();
		Session session =(Session)getSession();
		voucherlist = session.createCriteria(FaVoucherHeader.class)
		.add(Restrictions.eq("FYear.Id", fYearId)).list();
		map.put("voucherlist", voucherlist);
		return map;
	}
	@SuppressWarnings("unchecked")




	public Map<String, Object> getVoucherList(Map<String, Object> generalMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		Date todate=null;

		Date fromDate=null;
		//Date toDate = null;
		if(generalMap.get("to_date")!= null){
			todate = (Date)generalMap.get("to_date");
		}

		if(generalMap.get("from_date")!= null){
			fromDate = (Date)generalMap.get("from_date");
		}

		int accountId = 0;
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		int subLedgerId = 0;
		if(generalMap.get("subLedgerId")!= null){
			subLedgerId = (Integer)generalMap.get("subLedgerId");
		}
		
		
		Session session =(Session)getSession();
		Criteria criteria =  session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
								.createAlias("VoucherHeader", "header")
									.add(Restrictions.between("header.VoucherDate",(fromDate),(todate)));
		if(subLedgerId != 0){
		criteria = criteria.add(Restrictions.eq("SubLed.Id", subLedgerId));
		}
		voucherDetailList = criteria.list();

		map.put("voucherDetailList", voucherDetailList);

		return map;
	}

	public Map<String, Object> showBankRegisterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class)
		//.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 1)).list();//added by govind 19-11-2016
	   .createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.AccountSubGroupCode", 16)).list();
		map.put("accountList", accountList);
		return map;
	}

	public Map<String, Object> showLedgerAnalysisJsp()
	{
	  Map<String, Object> map = new HashMap<String, Object>();
	  List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	  List<FaMasSubLed> subledgerList = new ArrayList<FaMasSubLed>();
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).list();
		map.put("accountList", accountList);
		subledgerList = session.createCriteria(FaMasSubLed.class).list();
		map.put("subledgerList", subledgerList);
		return map;

	}
	public Map<String, Object> showVoucherReportJsp()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear>  fYearList = new ArrayList<HrMasFinancialYear>();
		Session session =(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		fYearList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasFinancialYear " );
		map.put("fYearList", fYearList);
		return map;
		
	}
	
	public int getFinancialYearList(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> fromFinancialYearList = new ArrayList<HrMasFinancialYear>();
		List<HrMasFinancialYear> toFinancialYearList = new ArrayList<HrMasFinancialYear>();
		Date fromDate = null;
		Date toDate = null;
		Session session = (Session)getSession();
		if(generalMap.get("from_date") != null){
			fromDate = (Date)generalMap.get("from_date");
		}
		if(generalMap.get("to_date") != null){
			toDate = (Date)generalMap.get("from_date");
		}
		fromFinancialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", fromDate))
							.add(Restrictions.ge("YearToDate", fromDate))
						.add(Restrictions.eq("Status", "y"))
						.list();
	
		toFinancialYearList = session.createCriteria(HrMasFinancialYear.class).add(Restrictions.le("YearFromDate", toDate))
								.add(Restrictions.ge("YearToDate", toDate))
										.add(Restrictions.eq("Status", "y")).list();
		int fromFinancialYearId = 0;
		int toFinancialYearId = 0;
		int financialYearId = 0;
		if(fromFinancialYearList.size()>0){
			for(HrMasFinancialYear financialYear : fromFinancialYearList){
				fromFinancialYearId = financialYear.getId();
			}
		}
		if(toFinancialYearList.size()>0){
			for(HrMasFinancialYear financialYear : toFinancialYearList){
				toFinancialYearId = financialYear.getId();
			}
		}
		if(fromFinancialYearId == toFinancialYearId){
			financialYearId = fromFinancialYearId;
		}
		return financialYearId;
	}
	@SuppressWarnings("unchecked")
/*	public Map<String, Object> getOpeningBalance(Map<String, Object>generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaVoucherDetails> VoucherDtListList = new ArrayList<FaVoucherDetails>();

		String prevdate=null;
		String finFromDate=null;
		Date fromDate=null;
		Date fDate = null;
		Date to_date=null;
		if(generalMap.get("prevdate")!= null){
			prevdate = (String)generalMap.get("prevdate");
		}
		if(generalMap.get("finFromDate")!= null){
			finFromDate = (String)generalMap.get("finFromDate");
		}
		if(generalMap.get("fromDate")!= null){
			fromDate = (Date)generalMap.get("fromDate");
		}
		if(generalMap.get("to_date")!= null){
			to_date = (Date)generalMap.get("to_date");
		}
		if(generalMap.get("fDate")!= null){
			fDate = (Date)generalMap.get("fDate");
		}
		int accountId = 0;
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String prevdate1 = "";
		String finFromDate1= "";
		try {
			 prevdate1 = formatterOut.format(formatterIn.parse(prevdate));
			 finFromDate1 = formatterOut.format(formatterIn.parse(finFromDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BigDecimal accountDrOpBalance = new BigDecimal(0.0);
		BigDecimal accountCrOpBalance = new BigDecimal(0.0);
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
		if(accountList.size()>0){
			for(FaMasAccount faMasAccount :accountList){
				if(faMasAccount.getOpBalanceCr()!= null){
					accountCrOpBalance = faMasAccount.getOpBalanceCr();
				}
				if(faMasAccount.getOpBalanceDr()!= null){
					accountDrOpBalance = faMasAccount.getOpBalanceDr();
				}
			}
		}
		BigDecimal ytdDrAmount = new BigDecimal(0.0);
		BigDecimal ytdCrAmount = new BigDecimal(0.0);
		BigDecimal drAccountAmount = new BigDecimal(0.0);
		BigDecimal crAccountAmount = new BigDecimal(0.0);
		BigDecimal crAccountClBalance = new BigDecimal(0.0);
		BigDecimal drAccountClBalance = new BigDecimal(0.0);
		BigDecimal totalYtdCrAmount = new BigDecimal(0.0);
		BigDecimal totalYtdDrAmount = new BigDecimal(0.0);


		if(HMSUtil.convertDateToStringWithoutTime(fDate).equals(HMSUtil.convertDateToStringWithoutTime(fromDate))){

			voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
			.createAlias("VoucherHeader", "header")
			.add(Restrictions.between("header.VoucherDate",  (fDate),  (fromDate)))
			.add(Restrictions.eq("header.AccountSubGroup.Id", 2)).list();
			if(voucherDetailList.size()>0){
				for(FaVoucherDetails faVoucherDetails :voucherDetailList){
					if(faVoucherDetails.getCrAmount()!= null){
					 ytdCrAmount = faVoucherDetails.getCrAmount();
					 totalYtdCrAmount = totalYtdCrAmount.add(ytdCrAmount);


					}
					if(faVoucherDetails.getDrAmount()!= null){
					 ytdDrAmount = faVoucherDetails.getDrAmount();
					 totalYtdDrAmount = totalYtdDrAmount.add(ytdDrAmount);

				}
				}
			}
		}else{
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
			.createAlias("VoucherHeader", "header")
			.add(Restrictions.between("header.VoucherDate",  java.sql.Date.valueOf(finFromDate1),  java.sql.Date.valueOf(prevdate1)))
			.add(Restrictions.eq("header.AccountSubGroup.Id", 2)).list();
			if(voucherDetailList.size()>0){
				for(FaVoucherDetails faVoucherDetails :voucherDetailList){
					if(faVoucherDetails.getCrAmount()!= null){
					 ytdCrAmount = faVoucherDetails.getCrAmount();
					 totalYtdCrAmount = totalYtdCrAmount.add(ytdCrAmount);


					}
					if(faVoucherDetails.getDrAmount()!= null){
					 ytdDrAmount = faVoucherDetails.getDrAmount();
					 totalYtdDrAmount = totalYtdDrAmount.add(ytdDrAmount);

				}
				}
			}


		//String sqlStr = "select detail.dr_amount,detail.cr_amount,account.op_balance_cr,account.op_balance_dr from fa_voucher_details detail left join  fa_voucher_header header on detail.voucher_header_id=header.voucher_header_id left join fa_mas_account account on detail.account_id =account.acc_id left join fa_mas_account_sub_group  subgroup on subgroup.account_sub_group_id = header.account_sub_group_id  where header.voucher_date between '"+finFromDate1+"' and '"+prevdate1+"' and subgroup.account_sub_group_id = 2 and account.acc_id = "+accountId+" ";




	}
			crAccountAmount = accountCrOpBalance.add(totalYtdCrAmount);
			drAccountAmount = 	accountDrOpBalance.add(totalYtdDrAmount);

			if(drAccountAmount.compareTo(crAccountAmount)>0){
				drAccountClBalance = drAccountAmount.subtract(crAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)>0){
				crAccountClBalance = crAccountAmount.subtract(drAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)==0){
				crAccountClBalance = new BigDecimal(0.00);
				drAccountClBalance= new BigDecimal(0.00);

			}
			map.put("voucherDetailList", voucherDetailList);
			map.put("drAccountClBalance", drAccountClBalance);
			map.put("crAccountClBalance", crAccountClBalance);

		return map;
	}
	*/
	
	public Map<String, Object> getOpeningBalanceFromOpeningEntry(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaAccountOpening> accountOpeningList = new ArrayList<FaAccountOpening>();
		List<Object[]> voucherDetailList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		int accountId=0;
		int financialYearId = 0;
		int branchId = 0;
		String prevdate = "";
		Date fromDate = null;
		Date toDate = null;
		String fDate = null;
		String tDate = null;
		String qry=null;
		if(generalMap.get("prevdate")!= null){
			prevdate = (String)generalMap.get("prevdate");
		}
		if(generalMap.get("from_date")!= null){
			fromDate = (Date)generalMap.get("from_date");
		}
		if(generalMap.get("to_date")!= null){
			toDate = (Date)generalMap.get("to_date");
		}
		if(generalMap.get("accountId")!= null){
			accountId = (Integer)generalMap.get("accountId");
		}
		if(generalMap.get("branchId")!= null){
			branchId = (Integer)generalMap.get("branchId");
		}
		if(generalMap.get("financialYearId")!= null){
			financialYearId = (Integer)generalMap.get("financialYearId");
		}
		int subLedgerId = 0;
		if(generalMap.get("subLedgerId")!= null){
			subLedgerId = (Integer)generalMap.get("subLedgerId");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fDate=sdf.format(fromDate);
		tDate=sdf.format(toDate);
		
		try {
			Connection con = session.connection();
			/*if(accountId==1 ||accountId==4 || accountId==6 )*/
			if(subLedgerId == 0){
			 qry = "{call get_opening_amount ('" + accountId + "','" + subLedgerId + "'," +
					"'" + branchId + "','" + fDate + "','" + tDate + "')}";
			}
			else{
			 qry = "{call get_opening_amount_sub ('" + accountId + "','" + subLedgerId + "'," +
				"'" + branchId + "','" + fDate + "','" + tDate + "')}";
						
			}
			CallableStatement cals = con.prepareCall(qry);
			cals.execute();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Date openingDate = null;
		BigDecimal accountOpBalanceDr = new BigDecimal(0.00);
		BigDecimal accountOpBalanceCr = new BigDecimal(0.00);
		Criteria criteria = session.createCriteria(FaAccountOpening.class).add(Restrictions.eq("FYear.Id", financialYearId))
							.add(Restrictions.eq("Branch.Id", branchId)).add(Restrictions.eq("Account.Id", accountId));
		if(subLedgerId != 0){
		criteria = criteria.add(Restrictions.eq("SubLedger.Id", subLedgerId));
		}
		accountOpeningList = criteria.list();
		if(accountOpeningList.size()>0){
			for(FaAccountOpening accountOpening : accountOpeningList){
				if(accountOpening.getOpeningDate()!= null && !(accountOpening.getOpeningDate().equals("null"))){
					openingDate = accountOpening.getOpeningDate();
				}
				if(accountOpening.getOpeningAmtCr() != null && accountOpening.getOpeningAmtCr().compareTo(new BigDecimal(0.00))>0){
					accountOpBalanceCr = accountOpening.getOpeningAmtCr();
				}else if(accountOpening.getOpeningAmtDr() != null && accountOpening.getOpeningAmtDr().compareTo(new BigDecimal(0.00))>0){
					accountOpBalanceDr = accountOpening.getOpeningAmtDr();
				}
			}
		}
		BigDecimal voucherBalanceDr = new BigDecimal(0.0);
		BigDecimal voucherBalanceCr = new BigDecimal(0.0);
		BigDecimal totalYtdCrAmount = new BigDecimal(0.0);
		BigDecimal totalYtdDrAmount = new BigDecimal(0.0);
		if(openingDate != null){
		if(HMSUtil.convertDateToStringWithoutTime(fromDate).equals(HMSUtil.convertDateToStringWithoutTime(openingDate))){
			Criteria crit =session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
							.createAlias("VoucherHeader", "header").add(Restrictions.between("header.VoucherDate", openingDate, HMSUtil.convertStringTypeDateToDateType(prevdate)))
					.setProjection(Projections.projectionList().add(Projections.sum("CrAmount")).add(Projections.sum("DrAmount")))
						.setProjection(Projections.sum("CrAmount")).setProjection(Projections.sum("DrAmount"));
			if(subLedgerId != 0){
			crit = crit.add(Restrictions.eq("SubLed.Id", subLedgerId));
			}
			voucherDetailList = crit.list();
				
			if(voucherDetailList.size()>0 && voucherDetailList != null){
				for(Object[] voucherDetails :voucherDetailList){
					if(voucherDetails != null){
					if(voucherDetails[0]!= null && (((BigDecimal)voucherDetails[0]).compareTo(new BigDecimal(0.00)))>0){
						voucherBalanceCr = (BigDecimal)voucherDetails[0];
					}
					if(voucherDetails[1]!= null && ((BigDecimal)voucherDetails[1]).compareTo(new BigDecimal(0.00))>0){
						voucherBalanceDr = (BigDecimal)voucherDetails[1];

					}
				}
				}
			}
		}else{
			Criteria crit =session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("Account.Id", accountId))
						.createAlias("VoucherHeader", "header").add(Restrictions.between("header.VoucherDate", openingDate, HMSUtil.convertStringTypeDateToDateType(prevdate)))
						.setProjection(Projections.projectionList().add(Projections.sum("CrAmount")).add(Projections.sum("DrAmount")))
							.setProjection(Projections.sum("CrAmount")).setProjection(Projections.sum("DrAmount"));
			if(subLedgerId != 0){
			crit = crit.add(Restrictions.eq("SubLed.Id", subLedgerId));
			}
			voucherDetailList = crit.list();
			if(voucherDetailList.size()>0 && voucherDetailList.get(0)!= null){
				for(Object[] voucherDetails :voucherDetailList){
					if(voucherDetails != null){
					if(voucherDetails[0]!= null && ((BigDecimal)voucherDetails[0]).compareTo(new BigDecimal(0.00))>0){
						voucherBalanceCr = (BigDecimal)voucherDetails[0];
					}
					if(voucherDetails[1]!= null && ((BigDecimal)voucherDetails[1]).compareTo(new BigDecimal(0.00))>0){
						voucherBalanceDr = (BigDecimal)voucherDetails[1];

					}
				}
				}
			}
			}
		}
		   BigDecimal crAccountAmount = accountOpBalanceCr.add(voucherBalanceCr);
	       BigDecimal  drAccountAmount = 	accountOpBalanceDr.add(voucherBalanceDr);
	       BigDecimal drAccountClBalance = new BigDecimal(0.00);
	       BigDecimal crAccountClBalance = new BigDecimal(0.00);
			if(drAccountAmount.compareTo(crAccountAmount)>0){
				drAccountClBalance = drAccountAmount.subtract(crAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)>0){
				crAccountClBalance = crAccountAmount.subtract(drAccountAmount);
			}else if(crAccountAmount.compareTo(drAccountAmount)==0){
				crAccountClBalance = new BigDecimal(0.00);
				drAccountClBalance= new BigDecimal(0.00);
	
			}
			map.put("drAccountClBalance", drAccountClBalance);
			map.put("crAccountClBalance", crAccountClBalance);
			map.put("voucherDetailList", voucherDetailList);*/
		return map;
		
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountParameterJsp(int fYear) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<FaAccountParameter> accountParameterList = new ArrayList<FaAccountParameter>();
		Session session = (Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).list();
		subLedList = session.createCriteria(FaMasSubLed.class).list();
		mainChargeCodeList = session.createCriteria(MasMainChargecode.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		accountParameterList = session.createCriteria(FaAccountParameter.class).list();
		map.put("accountList", accountList);
		map.put("subLedList", subLedList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("accountParameterList", accountParameterList);
		map.put("subChargeCodeList", subChargeCodeList);
		return map;
	}

	public Map<String, Object> submitAccountsParameter(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			Vector accId = box.getVector("acc_id");
			Vector subLedId = box.getVector("sub_led_id");
			Vector accountType = box.getVector(PAYMENT_MODE);
			System.out.println("accId==="+accId.size());
		
			for (int i = 0; i<accId.size(); i++) {
				FaAccountParameter faAccountsParameter = new FaAccountParameter();
				if (accId.size()>0) {
					if (accId.get(i) != null && !accId.get(i).equals("0")) {
						FaMasAccount masAccount = new FaMasAccount();
						masAccount.setId(Integer.parseInt(accId.get(i).toString()));
						faAccountsParameter.setAccount(masAccount);
					
				
				if (accountType.get(i) != null && !accountType.get(i).equals("")) {
					faAccountsParameter.setAccountType((String) accountType.get(i));
				}
					
					if (subLedId.size() > 0) {
						if (subLedId.get(i) != null && !subLedId.get(i).equals("0")) {
							FaMasSubLed masSubLed = new FaMasSubLed();
							masSubLed.setId(Integer.parseInt(subLedId.get(i).toString()));
							faAccountsParameter.setSubLed(masSubLed);
						}
					}
					if(box.getInt("hospitalId")!= 0){
						MasHospital masHospital = new MasHospital();
						masHospital.setId(box.getInt("userId"));
						faAccountsParameter.setHospital(masHospital);
					}
					if(box.getInt("userId")!= 0){
						Users users = new Users();
						users.setId(box.getInt("userId"));
						faAccountsParameter.setLastChgBy(users);
					}
					if(!box.getString(CHANGED_DATE).equals("")){
						faAccountsParameter.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					}
					if(!box.getString(CHANGED_TIME).equals("")){
						faAccountsParameter.setLastChgTime(box.getString(CHANGED_TIME));
					}
					faAccountsParameter.setStatus("y");
					hbt.save(faAccountsParameter);
				}	
				}	
			}
			/*int chargeListLength = box.getInt("hiddenValueForAccounts");
			if(chargeListLength > 0){
					for(int i=0; i<= chargeListLength; i++){
						int mainchargeId  = 0;
						if (box.getInt(MAIN_CHARGECODE_ID+ i) != 0) {
							MasMainChargecode mainChargecode = new MasMainChargecode();
							 mainchargeId = box.getInt(MAIN_CHARGECODE_ID+ i);
						}
						MasMainChargecode masMainChargecode = (MasMainChargecode)hbt.load(MasMainChargecode.class, mainchargeId);
						if (box.getString(BILL_TYPE+ i) != "") {
							//masMainChargecode.setBillType(box.getString(BILL_TYPE+ i));
						}
						if (box.getInt(ACCOUNT_ID+ i) != 0) {
							FaMasAccount faMasAccount = new FaMasAccount();
							faMasAccount.setId(box.getInt(ACCOUNT_ID+ i));
							//masMainChargecode.setAccount(faMasAccount);
						}
						if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
							FaMasSubLed faMasSubLed = new FaMasSubLed();
							faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
							//masMainChargecode.setSubLed(faMasSubLed);
						}

						hbt.update(masMainChargecode);

						}
					}
	*/
			int count = 0;
			if(box.getInt("counter")!= 0){
				count = box.getInt("counter");
			}
			System.out.println("count==="+count);
			/*for (int i = 1; i <= count; i++) {
				int vendorId  = 0;
				if (box.getInt("vendorCheckBoxId"+ i) != 0) {
					MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
					vendorId = box.getInt("vendorCheckBoxId"+ i);
				
				MasStoreSupplier supplier = (MasStoreSupplier)hbt.load(MasStoreSupplier.class, vendorId);

				if (box.getInt("acc_id"+ i) != 0) {
					FaMasAccount faMasAccount = new FaMasAccount();
					faMasAccount.setId(box.getInt("acc_id"+ i));
					supplier.setAcc(faMasAccount);
				}

				if (box.getInt(SUB_LEDGER_ID+ i) != 0) {
					FaMasSubLed faMasSubLed = new FaMasSubLed();
					faMasSubLed.setId(box.getInt(SUB_LEDGER_ID+ i));
					supplier.setSubLed(faMasSubLed);
				}

					hbt.update(supplier);

				}
			}*/
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = showAccountParameterJsp(box.getInt("fYear"));
			return map;
		}

	public int getFinancialYearId(Date voucherDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasFinancialYear> fromFinancialYearList = new ArrayList<HrMasFinancialYear>();
		List<HrMasFinancialYear> toFinancialYearList = new ArrayList<HrMasFinancialYear>();
		Session session = (Session)getSession();
		int financialId=0;
		String fDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fDate=sdf.format(voucherDate);
		String qury="";
		qury="select hmfy from jkt.hrms.masters.business.HrMasFinancialYear as hmfy where '"+fDate+"' between " +
		"hmfy.YearFromDate and hmfy.YearToDate";
		fromFinancialYearList =session.createQuery(qury).list();			
		if(fromFinancialYearList.size()>0){
			for(HrMasFinancialYear financialYear : fromFinancialYearList){
				financialId = financialYear.getId();
			}
		}
		return financialId;
	}
	@Override
	public Map<String, Object> getAccountId(Map<String, Object> remap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<FaMasAccount> accountL= new ArrayList<FaMasAccount>();
		String accountNameId1="";
		String accountCode="";
		String accountNameId2="";
		String accountCode2="";
		if(remap.get("accountNameId1")!= null){
			accountNameId1 = (String)(remap.get("accountNameId1"));
			accountNameId2 =""+accountNameId1.trim()+" %";
		}
		if(remap.get("accountCode")!= null){
			accountCode = (String)(remap.get("accountCode"));
			accountCode2=""+accountCode.trim();
		}
		try{
			accountL=session.createQuery("select fma from jkt.hms.masters.business.FaMasAccount as fma where " +
					"fma.AccCode like '"+accountCode2+"' and fma.AccDesc like '"+accountNameId2+"'").list();
			map.put("accountL", accountL);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	/*@Override
	public Map<String, Object> showAccountBalanceall(Map<String, Object> remap) {
				Map<String, Object> map = new HashMap<String, Object>();
			List<ViewData> accountList = new ArrayList<ViewData>();
			String qry="";
			int resrate=0;
			int accountId=0;
			int financialId=0;
			int branchId=0;
			Session session = (Session)getSession();
			
			try {
				Connection con = session.connection();
				qry="{ call get_data_from_view }";
				CallableStatement cals = con.prepareCall(qry);
				cals.execute();
			}
				catch (HibernateException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try{
					if(remap.get("financialId")!=null && remap.get("financialId")!=""){
						financialId=(Integer)remap.get("financialId");
					}
					if(remap.get("branchId")!=null && remap.get("branchId")!=""){
						branchId=(Integer)remap.get("branchId");
					}
					if(remap.get("accountId")!=null && remap.get("accountId")!=""){
						accountId=(Integer)remap.get("accountId");
					}
					if(remap.get("resrate")!=null && remap.get("resrate")!=""){
						resrate=(Integer)remap.get("resrate");
					}
					if(resrate==0){
					accountList=session.createQuery("select fao from jkt.hms.masters.business.ViewData as fao where fao.AccountId=" +
							""+accountId+"and fao.BranchId="+branchId+" and fao.FYearId="+financialId).list();
					}
					else if(resrate>0)
					{
						accountList=session.createQuery("select fao from jkt.hms.masters.business.ViewData as fao where fao.AccountId" +
								"="+accountId+"and fao.SubLedId="+resrate+"and fao.BranchId="+branchId+" and fao.FYearId="+financialId).list();
					}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			map.put("accountList", accountList);
			return map;
		}*/
	@SuppressWarnings("unchecked")
	public Map<String, Object> showCashRegisterJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		Session session =(Session)getSession();
		accountList = session.createCriteria(FaMasAccount.class)
						/*.add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
								.createAlias("AccountSubGroup", "subGroup").add(Restrictions.eq("subGroup.Id", 2))*/.list();
		map.put("accountList", accountList);
		return map;
	}
	@Override
	public Map<String, Object> displayCashBook(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
		List<FaVoucherDetails> cashVoucherDetailList= new ArrayList<FaVoucherDetails>();
		List<FaMasAccount> cashAccountList = new ArrayList<FaMasAccount>();
		List<AccountMainTransac>accountTransacList=new ArrayList<AccountMainTransac>();
		Session session = (Session)getSession();
		System.out.println("box.getInt(fYear)---->>"+box.getInt("fYear"));
		
		System.out.println("box.getInt(hospitalId)---->>"+box.getInt("locationId"));
		voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
							.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
							.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
							//.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
							.list();
		cashVoucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
									.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
								.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
							.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))

								.list();
		System.out.println("account Id-->>"+box.getInt(ACCOUNT_ID));
		cashAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(box.getInt(ACCOUNT_ID))).list();
		accountTransacList=session.createCriteria(AccountMainTransac.class)
				.createAlias("FYear", "FYear")
				.add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
				.createAlias("Location", "Location")
				.add(Restrictions.eq("Location.Id", box.getInt("locationId")))
				.add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
				.list();
		System.out.println("accountTransacList.size()-------......>>>>"+accountTransacList.size());
		map.put("cashAccountList", cashAccountList);
		map.put("voucherDetailList", voucherDetailList);
		map.put("cashVoucherDetailList", cashVoucherDetailList);
		map.put("accountTransacList", accountTransacList);
		return map;
	}
	
	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Integer storeId = 0;
		if (mapForDs.get("storeId") != null) {
			storeId = (Integer) mapForDs.get("storeId");
		}
		try {
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			masHospitaList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", storeId)).list();
			mapResponse.put("masHospitaList", masHospitaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapResponse;
	}
	/*public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Integer hospitalId = 0;
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		try {
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			masHospitaList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", hospitalId)).list();
			mapResponse.put("masHospitaList", masHospitaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapResponse;
	}*/
	
	@Override
	public Map<String, Object> showAccountSubGroupNew(Map<String, Object> generalMap) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		int fYear = 0;
		int locationId = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y").ignoreCase())
								
								.list();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y").ignoreCase())
				
				.list();
		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class)//.add(Restrictions.eq("Status", "y"))
				
				.list();
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		return map;
	}
	
	@Override
	public Map<String, Object> showAccountMasterNew(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<MasAccountSchedule> scheduleList = new ArrayList<MasAccountSchedule>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		Session session = (Session)getSession();
		int fYear = 0;
		int locationId = 0;
		if(generalMap.get("fYear")!= null){
			fYear = (Integer)generalMap.get("fYear");
		}
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		scheduleList = session.createCriteria(MasAccountSchedule.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		faMasAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
								.list();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		gridMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		hospitalTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("HospitalTypeName")).list();
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("faMasAccountList",faMasAccountList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		map.put("scheduleList",scheduleList);
		map.put("hospitalTypeList",hospitalTypeList);
		return map;
	}
	
	@Override
	public Map<String, Object> showChequeDetailJsp(Box box) {
		Map<String, Object>  map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		Session session = (Session)getSession();
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		map.put("bankList", bankList);
		return map;
	}
	
	@Override
	public Map<String, Object> showChequePrintingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherHeader> voucherHeaderList = new ArrayList<FaVoucherHeader>();
		Session session = (Session)getSession();
		voucherHeaderList = session.createCriteria(FaVoucherHeader.class).add(Restrictions.eq("VoucherType", "PV")).list();
		map.put("voucherHeaderList", voucherHeaderList);
		return map;
	}
	
	@Override
	public Map<String, Object> showFixedDepositRegisterJsp(Box box) {
		Map<String, Object> map  = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		//List<FaMasFdRegister> fdRegisterList = new ArrayList<FaMasFdRegister>();
		Session session = (Session)getSession();
		bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
		//fdRegisterList = session.createCriteria(FaMasFdRegister.class).add(Restrictions.eq("Status", "y")).list();
		map.put("bankList", bankList);
	//	map.put("fdRegisterList", fdRegisterList);
		return map;
	}
	
	@Override
	public Map<String, Object> showHrInsuranceDetailsJsp(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
	//	List<HrMasInsurance> hrMasInsuranceList = new ArrayList<HrMasInsurance>();
	//	List<HrInsuranceDetails> searchHrInsuranceDetailsList = new ArrayList<HrInsuranceDetails>();
		Session session = (Session)getSession();
		int locationId = 0;
		if(generalMap.get("locationId") != null){
			locationId = (Integer)generalMap.get("locationId");
		}
	//	searchHrInsuranceDetailsList = session.createCriteria(HrInsuranceDetails.class)
				//.add(Restrictions.eq("Status", "y")).list();
									
		
		/*hrMasInsuranceList = session.createCriteria(HrMasInsurance.class).add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("Company.Id", locationId)).list();*/
		
		//map.put("hrMasInsuranceList", hrMasInsuranceList);
	//	map.put("searchHrInsuranceDetailsList", searchHrInsuranceDetailsList);
		return map;
	}
	
	@Override
	public Map<String, Object> searchAccountGroupNew(Map<String, Object> generalMap) {
		Map<String, Object>map=new HashMap<String,Object>();
		String accountGroupName="";
		if(generalMap.get("accountGroupName")!=null && !generalMap.get("accountGroupName").equals("")){
			accountGroupName=(String)generalMap.get("accountGroupName");
		}
		Session session=(Session)getSession();
		List<FaMasAccountGroup>faMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
		
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class)//.add(Restrictions.eq("Status", "y"))
		.add(Restrictions.ilike("AccountGroupDesc", "%"+accountGroupName+"%")).list();
		
		map.put("faMasAccountGroupList",faMasAccountGroupList);
		return map;
		
	}
	
	@Override
	public Map<String, Object> addAccountGroupNew(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup>faMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> existingAccountGroupList = new ArrayList<FaMasAccountGroup>();
		
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int  financialYearId = 0;
	
		String message = "";
		try {
			FaMasAccountGroup faMasAccountGroup = new FaMasAccountGroup();
			if(generalMap.get("fag")!= null){
				faMasAccountGroup = (FaMasAccountGroup)generalMap.get("fag");
			}
			Box box =null;
			if(generalMap.get("box")!= null){
				box = (Box)generalMap.get("box");
			}
			Integer groupCode = faMasAccountGroup.getAccountGroupCode();
			String groupDesc = faMasAccountGroup.getAccountGroupDesc();
			
			if(generalMap.get("fYear")!= null){
				financialYearId =(Integer)generalMap.get("fYear");
			}
			
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			int subGroupId =0;
			if(generalMap.get("accountSubGroupId")!= null){
				subGroupId = (Integer)generalMap.get("accountSubGroupId");
			}
			
			BigDecimal openingBalanceDr = new BigDecimal(0);
			BigDecimal openingBalanceCr = new BigDecimal(0);
			if(generalMap.get("opDrBalance")!= null){
				openingBalanceDr =(BigDecimal)generalMap.get("opDrBalance");
			}else if(generalMap.get("opCrBalance")!= null){
				openingBalanceCr =(BigDecimal)generalMap.get("opCrBalance");
			}
			System.out.println("groupCode==>"+groupCode);
			System.out.println("financialYearId==>"+financialYearId);
			existingAccountGroupList = session.createCriteria(FaMasAccountGroup.class)
					.add(Restrictions.eq("AccountGroupCode", groupCode))
									.add(Restrictions.eq("FYear.Id", 1))
									
									.list();
			
			System.out.println("existingAccountGroupList.size()==>"+existingAccountGroupList.size());
			if (existingAccountGroupList.size() > 0) {
				message = "Record already Exist";
			} else {
				hbt.save(faMasAccountGroup);
				message = "Record saved sucessfully!";

//-----------------------For Branch Account master------------------------------------------
		//---------commented by anamika on 10/08/2014----------------
				/*int count = 0;
				if(box.getInt("totalBranchId")!= 0){
					count = box.getInt("totalBranchId");
				}
				for (int i = 1; i <= count; i++) {
					FaBranchAccountMaster branchAccountMaster = new FaBranchAccountMaster();
					if(box.getInt("branchId"+i)!=0 ){
						MasBranch masBranch = new MasBranch();
						masBranch.setId(box.getInt("branchId"+i));
						branchAccountMaster.setBranch(masBranch);
						branchAccountMaster.setAccount(faMasAccount);

						if(!box.getString("opBalanceDr"+i).equals("") ){
							branchAccountMaster.setOpBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
							branchAccountMaster.setClBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
						}else if(!box.getString("opBalanceCr"+i).equals("")){
							branchAccountMaster.setOpBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
							branchAccountMaster.setClBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
						}
						hbt.save(branchAccountMaster);

					}
				}*/

			//----------------update account group--------------
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				.createAlias("FYear", "fy")
				.add(Restrictions.eq("fy.Id", 1))
				
				.list();
System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("message", message);
		return map;
	}
	
	@Override
	public Map<String, Object> searchAccountSubGroup(
			Map<String, Object> generalMap) {
		Map<String, Object>map=new HashMap<String,Object>();
		String accountGroupName="";
		if(generalMap.get("accountGroupName")!=null && !generalMap.get("accountGroupName").equals("")){
			accountGroupName=(String)generalMap.get("accountGroupName");
		}
		int radioValue=0;
		if(generalMap.get("radioValue")!=null && !generalMap.get("radioValue").equals("0")){
			radioValue=(Integer)generalMap.get("radioValue");
		}
		Session session=(Session)getSession();
		
		List<FaMasAccountSubGroup>faMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup>gridMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
		gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y")).list();
		System.out.println("generalMap dataservice===>"+generalMap);
		if(radioValue==1){
			faMasAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class)//.add(Restrictions.eq("Status", "y"))
		.add(Restrictions.eq("AccountSubGroupCode", Integer.parseInt(accountGroupName))).list();
		}else if(radioValue==2){
			faMasAccountSubGroupList = session.createCriteria(FaMasAccountSubGroup.class)//.add(Restrictions.eq("Status", "y"))
		.add(Restrictions.ilike("AccountSubGroupName","%"+accountGroupName+"%")).list();
		}
		
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		return map;
		
	}
	
	@Override
	public Map<String, Object> addAccountSubGroupNew(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> existingAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int  financialYearId = 0;
	
		String message = "";
		try {
			FaMasAccountSubGroup faMasAccountGroup = new FaMasAccountSubGroup();
			if(generalMap.get("fasg")!= null){
				faMasAccountGroup = (FaMasAccountSubGroup)generalMap.get("fasg");
			}
			Box box =null;
			if(generalMap.get("box")!= null){
				box = (Box)generalMap.get("box");
			}
			Integer groupCode = faMasAccountGroup.getAccountSubGroupCode();
			String groupDesc = faMasAccountGroup.getAccountSubGroupName();
			
			if(generalMap.get("fYear")!= null){
				financialYearId =(Integer)generalMap.get("fYear");
			}
			
			int groupId =0;
			if(generalMap.get("accountgroupId")!= null){
				groupId = (Integer)generalMap.get("accountgroupId");
			}
			int subGroupId =0;
			if(generalMap.get("accountSubGroupId")!= null){
				subGroupId = (Integer)generalMap.get("accountSubGroupId");
			}
			
			BigDecimal openingBalanceDr = new BigDecimal(0);
			BigDecimal openingBalanceCr = new BigDecimal(0);
			if(generalMap.get("opDrBalance")!= null){
				openingBalanceDr =(BigDecimal)generalMap.get("opDrBalance");
			}else if(generalMap.get("opCrBalance")!= null){
				openingBalanceCr =(BigDecimal)generalMap.get("opCrBalance");
			}
			System.out.println("groupCode==>"+groupCode);
			System.out.println("financialYearId==>"+financialYearId);
			existingAccountSubGroupList = 					
							session.createCriteria(FaMasAccountSubGroup.class)
							.add(Expression.or(
							Expression.eq("AccountSubGroupCode", groupCode ) ,
							Expression.eq("AccountSubGroupName", groupDesc ) ))
							.list(); 
					
					
/*					.add(Restrictions.eq("AccountSubGroupCode", groupCode))
					
									
									.list();
*/			
			System.out.println("existingAccountSubGroupList.size()==>"+existingAccountSubGroupList.size());
			if (existingAccountSubGroupList.size() > 0) {
				message = "Record already Exist";
			} else {
				hbt.save(faMasAccountGroup);
				message = "Record saved sucessfully!";

//-----------------------For Branch Account master------------------------------------------
		//---------commented by anamika on 10/08/2014----------------
				/*int count = 0;
				if(box.getInt("totalBranchId")!= 0){
					count = box.getInt("totalBranchId");
				}
				for (int i = 1; i <= count; i++) {
					FaBranchAccountMaster branchAccountMaster = new FaBranchAccountMaster();
					if(box.getInt("branchId"+i)!=0 ){
						MasBranch masBranch = new MasBranch();
						masBranch.setId(box.getInt("branchId"+i));
						branchAccountMaster.setBranch(masBranch);
						branchAccountMaster.setAccount(faMasAccount);

						if(!box.getString("opBalanceDr"+i).equals("") ){
							branchAccountMaster.setOpBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
							branchAccountMaster.setClBalanceDr(new BigDecimal(box.getString("opBalanceDr"+i)));
						}else if(!box.getString("opBalanceCr"+i).equals("")){
							branchAccountMaster.setOpBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
							branchAccountMaster.setClBalanceCr(new BigDecimal(box.getString("opBalanceCr"+i)));
						}
						hbt.save(branchAccountMaster);

					}
				}*/

			//----------------update account group--------------
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))
				.list();
gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))
.list();
faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))

.list();
System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
map.put("faMasAccountGroupList", faMasAccountGroupList);
map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("message", message);
		return map;
	}
	
	
	@Override
	public Map<String, Object> updateAccountGroupNew(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
	
		List<FaMasAccountGroup> existingAccountList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			existingAccountList = session.createCriteria(FaMasAccountGroup.class)
					.add(Restrictions.eq("AccountGroupCode", box.getInt(RequestConstants.SEARCH_NAME)))
					.add(Restrictions.ne("Id", box.getInt("accountId")))
					.list();
			System.out.println("existingAccountList.size()=====>>"+existingAccountList.size());
			/*if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			}*/// else {
System.out.println("box.getInt(accountId)============>>"+box.getInt("accountId"));
System.out.println("code====>>>"+box.getString(RequestConstants.SEARCH_NAME));

				for(FaMasAccountGroup faMasAccountGroup:existingAccountList){// = (FaMasAccountGroup) hbt.load(FaMasAccount.class,box.getInt("accountId"));
				faMasAccountGroup.setAccountGroupDesc(box.getString("discription"));
			
			
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faMasAccountGroup.setFYear(masStoreFinancial);
			
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			faMasAccountGroup.setLastChgBy(user);
			
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			faMasAccountGroup.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			faMasAccountGroup.setLastChgTime(time);
			hbt.update(faMasAccountGroup);
			message = "Record update sucessfully!";
//----------------------------------------------calculation for last Balance---------------------------------
			
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				.createAlias("FYear", "fy")
				//.add(Restrictions.eq("fy.Id", box.getInt("fYear")))
				
				.list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("message",message);
		return map;
	}
	@Override
	public Map<String, Object> deleteAccountGroupNew(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
	
		List<FaMasAccountGroup> existingAccountList = new ArrayList<FaMasAccountGroup>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			existingAccountList = session.createCriteria(FaMasAccountGroup.class)
					.add(Restrictions.eq("AccountGroupCode", box.getInt(RequestConstants.SEARCH_NAME)))
					.add(Restrictions.ne("Id", box.getInt("accountId")))
					.list();
			System.out.println("existingAccountList.size()=====>>"+existingAccountList.size());
			/*if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			}*/// else {
System.out.println("box.getInt(accountId)============>>"+box.getInt("accountId"));
System.out.println("code====>>>"+box.getString(RequestConstants.SEARCH_NAME));

				for(FaMasAccountGroup faMasAccountGroup:existingAccountList){// = (FaMasAccountGroup) hbt.load(FaMasAccount.class,box.getInt("accountId"));

					if(box.getString("flag").equals("InActivate")){
						faMasAccountGroup.setStatus("n");
					}else if(box.getString("flag").equals("Activate")){
						faMasAccountGroup.setStatus("y");
					}
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			faMasAccountGroup.setFYear(masStoreFinancial);
			
			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			faMasAccountGroup.setLastChgBy(user);
			
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");

			faMasAccountGroup.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			faMasAccountGroup.setLastChgTime(time);
			hbt.update(faMasAccountGroup);
			message = "Record update sucessfully!";
//----------------------------------------------calculation for last Balance---------------------------------
			
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class)//.add(Restrictions.eq("Status", "y"))
				.createAlias("FYear", "fy")
				.add(Restrictions.eq("fy.Id", box.getInt("fYear")))
				
				.list();
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("message",message);
		return map;
	}
	
	@Override
	public boolean updateAccountSubGroupNew(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int districtId = 0;
		String blockName = "";
		@SuppressWarnings("unused")
		String blockCode = "";
		int blockId = 0;
		Integer userId= 0;
		blockId = (Integer) generalMap.get("id");
		blockCode = (String) generalMap.get("blockCode");
		blockName = (String) generalMap.get("name");
		districtId = (Integer) generalMap.get("districtId");
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		String subGroupType = "";
		
		FaMasAccountSubGroup masBlock = (FaMasAccountSubGroup) getHibernateTemplate().get(
				FaMasAccountSubGroup.class, blockId);

		masBlock.setId(blockId);
		masBlock.setAccountSubGroupName(blockName);

		   if(districtId != 0){
			   FaMasAccountGroup district = new FaMasAccountGroup();
			   district.setId(districtId);
			   masBlock.setAccountGroup(district);
			   }
		   if(generalMap.get("subGroupType") != null){
				subGroupType = (String)generalMap.get("subGroupType");
				System.out.println("subGroupType=="+subGroupType);
				masBlock.setFlag(subGroupType);
			}

		Users user = new Users();
		user.setId(userId);
		masBlock.setLastChgBy(user);
		
		masBlock.setLastChgDate(currentDate);
		masBlock.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBlock);
		dataUpdated = true;
		return dataUpdated;
	}
	@Override
	public boolean deleteAccountSubGroupNew(int accountGroupId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Session session = (Session)getSession();
		int userId = 0;
		
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
			FaMasAccountSubGroup masBlock = new FaMasAccountSubGroup();
			masBlock = (FaMasAccountSubGroup) getHibernateTemplate().get(
					FaMasAccountSubGroup.class, accountGroupId);
			@SuppressWarnings("unused")
			Integer districtId = masBlock.getAccountGroup().getId();
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			
			List disrictList = session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Id", districtId))
					//.add(Restrictions.eq("Status", "y"))
					.list();
			
			if (flag.equals("InActivate")) {
				masBlock.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBlock.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masBlock.setLastChgBy(user);
		
		masBlock.setLastChgDate(currentDate);
		masBlock.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBlock);
		return dataDeleted;
	}
	
	@Override
	public boolean editAccountMaster(Map<String, Object> generalMap) {
		System.out.println("in account dataservice");
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int accountGroupId = 0;
		int accountSubGroupId=0;
		String blockName = "";
		@SuppressWarnings("unused")
		String blockCode = "";
		int blockId = 0;
		Integer userId= 0;
		int scheduleDrId = 0;
		int scheduleCrId = 0;
		blockId = (Integer) generalMap.get("id");
		blockCode = (String) generalMap.get("blockCode");
		blockName = (String) generalMap.get("name");
		accountGroupId = (Integer) generalMap.get("accountGroupId");
		
		accountSubGroupId=(Integer) generalMap.get("accountSubGroupId");
		
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		System.out.println("scheduleDre=in ds=="+generalMap.get("scheduleDrId"));
		if(generalMap.get("scheduleDrId") != null){
			scheduleDrId = (Integer)generalMap.get("scheduleDrId");
		}
		if(generalMap.get("scheduleCrId") != null){
			scheduleCrId = (Integer)generalMap.get("scheduleCrId");
		}
		List hospitalTypeAccountList = new ArrayList();
		if(generalMap.get("hospitalTypeAccountList") != null){
			hospitalTypeAccountList = (List)generalMap.get("hospitalTypeAccountList");
		}
		
		
		List<FaMasAccount>existingAccountList=new ArrayList<FaMasAccount>();
		List<FaAccountHospitalTypeMapping> existingAccountHospitalTypeMappingList = new ArrayList<FaAccountHospitalTypeMapping>();
		Session session=(Session)getSession();
		existingAccountList = 					
				session.createCriteria(FaMasAccount.class)
				.add(Restrictions.eq("AccDesc", blockName ) )
				.add(Restrictions.ne("Id", blockId))
				.list(); 
		System.out.println("blockId=="+blockId);
		existingAccountHospitalTypeMappingList = session.createCriteria(FaAccountHospitalTypeMapping.class).add(Restrictions.eq("Account.Id", blockId)).list();
		
		if(existingAccountList.size()>0){
			dataUpdated=false;
		}else{
		
		FaMasAccount masAccount = (FaMasAccount) getHibernateTemplate().get(
				FaMasAccount.class, blockId);

		//masBlock.setId(blockId);
		masAccount.setAccDesc(blockName);
		   if(accountSubGroupId != 0){
			   FaMasAccountSubGroup fmasg = new FaMasAccountSubGroup();
			   fmasg.setId(accountSubGroupId);
			   masAccount.setAccountSubGroup(fmasg);
			   }
		   /*if(accountGroupId != 0){
			   FaMasAccountGroup district = new FaMasAccountGroup();
			   district.setId(accountGroupId);
			   masAccount.set
			   }*/
		Users user = new Users();
		user.setId(userId);
		masAccount.setLastChgBy(user);
		
		if(scheduleDrId != 0){
			MasAccountSchedule accountScheduleDr = new MasAccountSchedule();
			accountScheduleDr.setId(scheduleDrId);
			masAccount.setScheduleDr(accountScheduleDr);
		}
		if(scheduleCrId != 0){
			MasAccountSchedule accountScheduleCr = new MasAccountSchedule();
			accountScheduleCr.setId(scheduleCrId);
			masAccount.setScheduleCr(accountScheduleCr);
		}
		
		masAccount.setLastChgDate(currentDate);
		masAccount.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAccount);
		dataUpdated = true;
		System.out.println("existingAccountHospitalTypeMappingList===="+existingAccountHospitalTypeMappingList.size());
			if(existingAccountHospitalTypeMappingList.size()>0){
				for(FaAccountHospitalTypeMapping hospitalTypeMapping : existingAccountHospitalTypeMappingList){
					hbt.delete(hospitalTypeMapping);
				}
			}
			if(hospitalTypeAccountList.size()>0){	
				for(int i=0;i<hospitalTypeAccountList.size();i++){
					FaAccountHospitalTypeMapping accountHospitalTypeMapping = new FaAccountHospitalTypeMapping();
					FaMasAccount acc = new FaMasAccount();
					acc.setId(accountGroupId);
					accountHospitalTypeMapping.setAccount(masAccount);
					MasHospitalType hospitalType = new MasHospitalType();
					hospitalType.setId(Integer.parseInt(hospitalTypeAccountList.get(i).toString()));
					accountHospitalTypeMapping.setHospitalType(hospitalType);
					accountHospitalTypeMapping.setStatus("y");
					hbt.save(accountHospitalTypeMapping);
			      }
			   }
			}	
		
		
		return dataUpdated;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> addAccountSubLedger(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountGroup> gridAccGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccountSubGroup> gridSubAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasAccount> gridaccList = new ArrayList<FaMasAccount>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasEmployee>employeeListJphn=new ArrayList<MasEmployee>();
		List<MasEmployee>employeeListJhi=new ArrayList<MasEmployee>();
		List<MasWard>wardList=new ArrayList<MasWard>();
		List<FaMasSubLed>existingAccountList=new ArrayList<FaMasSubLed>();
		Session session = (Session) getSession();
		FaMasSubLed faMasSubLed = new FaMasSubLed();
		if(generalMap.get("faMasSubLed")!= null){
			faMasSubLed = (FaMasSubLed)generalMap.get("faMasSubLed");
		}
		int locationId = 0;
		if(generalMap.get("locationId")!= null){
			locationId = (Integer)generalMap.get("locationId");
		}
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int fYear = 0;
		try {
			Box box =null;
			if(generalMap.get("box")!= null){
				box = (Box)generalMap.get("box");
			}
			String subLedgerName = faMasSubLed.getSubLedDesc();
			String subLedgerCode=faMasSubLed.getSubLedCode();
			int accountMasterId = (Integer)generalMap.get("accountMasterId");
			fYear = faMasSubLed.getFYear().getId();
			existingAccountList = session.createCriteria(FaMasSubLed.class)//.add(Restrictions.eq("Account.Id", accountMasterId))
					.add(Restrictions.eq("SubLedCode", subLedgerCode))
										/*.add(Restrictions.eq("Hospital.Id", locationId))
										
										.add(Restrictions.eq("FYear.Id",fYear))*/.list();
			System.out.println("existingAccountList.size()----->>>"+existingAccountList.size());
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			} else {		
				hbt.save(faMasSubLed);
				message = "Record saved sucessfully!";
}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//--------------------------------------------------------------------------		 	
		 	


		subLedList = session.createCriteria(FaMasSubLed.class).createAlias("FYear", "fy")
						/*.add(Restrictions.eq("fy.Id", fYear))
						.add(Restrictions.eq("Hospital.Id", hospitalid))*/.list();

		accGrpList =session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
						.add(Restrictions.eq("fy.Id", fYear))
						/*.add(Restrictions.eq("Hospital.Id", locationId))*/
						.list();
		gridAccGrpList=session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
				.add(Restrictions.eq("fy.Id", fYear))
				/*.add(Restrictions.eq("Hospital.Id", locationId))*/
				.list();

		subAccGrpList =session.createCriteria(FaMasAccountSubGroup.class)
				.createAlias("FYear", "fy")
						.add(Restrictions.eq("fy.Id", fYear))
						/*.add(Restrictions.eq("Hospital.Id", locationId))*/
						.list();
		gridSubAccGrpList=session.createCriteria(FaMasAccountSubGroup.class)
				.createAlias("FYear", "fy")
				.add(Restrictions.eq("fy.Id", fYear))
				/*.add(Restrictions.eq("Hospital.Id", locationId))*/
				.list();
		accList =session.createCriteria(FaMasAccount.class)
				/*//.createAlias("FYear", "fy")
						.add(Restrictions.eq("fy.Id", fYear))
				.add(Restrictions.eq("Hospital.Id", hospitalid))
						.add(Restrictions.eq("SubLedger", "y"))*/
				.addOrder(Order.asc("AccDesc"))
						.list();
		
		gridaccList=session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
				//.add(Restrictions.eq("fy.Id", fYear))
				//.add(Restrictions.eq("Hospital.Id", hospitalid))
				//.add(Restrictions.eq("SubLedger", "y"))
				.list();
		hospitalList=session.createCriteria(MasHospital.class)
//				.add(Restrictions.ne("UnitType", "HO"))
				.add(Restrictions.eq("Status", "y")).list();
		Object[] selectdIdJPHN={251,252};
		Object[] selectdIdJHI={404,405};
		employeeListJphn=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", locationId))
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.in("Rank.Id", selectdIdJPHN))		
						.list();
		employeeListJhi=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", locationId))
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.in("Rank.Id", selectdIdJHI))		
						.list();
		map.put("subLedList", subLedList);
		map.put("accGrpList", accGrpList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("gridAccGrpList",gridAccGrpList);
		map.put("gridSubAccGrpList",gridSubAccGrpList);
		map.put("gridaccList",gridaccList);
		map.put("accList", accList);
		map.put("employeeListJphn", employeeListJphn);
		map.put("employeeListJhi", employeeListJhi);
		map.put("wardList",wardList);
		map.put("hospitalList", hospitalList);
	
		map.put("subLedList", subLedList);
		map.put("accGrpList", accGrpList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("accList", accList);
		map.put("gridaccList",gridaccList);
		map.put("message", message);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAccountSubLedger(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasSubLed> searchSubLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		Session session = getSession();
		int searchRadio = 0;
		String searchField = "";
		Criteria crit = null;
		searchField = box.getString(SEARCH_FIELD);
		searchRadio = box.getInt(SELECTED_RADIO);
		int fYear = box.getInt("fYear");
		crit = session.createCriteria(FaMasSubLed.class)
					.createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id",box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId")));
		if (searchRadio == 1) {
			crit = crit.add(Restrictions.eq("SubLedCode", searchField));

		} else {
			crit = crit.add(Restrictions.ilike("SubLedDesc", searchField+"%"));
		}

		subLedList = crit.list();
		
		accGrpList =session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
			.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();

		subAccGrpList =session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		//subLedList = session.createCriteria(FaMasSubLed.class).createAlias("FYear", "fy")
			//.add(Restrictions.eq("fy.Id", financialYearId)).list();
		accList =session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
		.add(Restrictions.eq("fy.Id", fYear)).add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
			.list();
		map.put("subLedList", subLedList);
		map.put("accGrpList", accGrpList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("accList", accList);
		map.put("searchSubLedList", searchSubLedList);
		map.put("searchCreteria", "searchCreteria");
		List<FaMasAccount>faMasAccountList=new ArrayList<FaMasAccount>();
		faMasAccountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		List<FaMasAccountGroup>faMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
		faMasAccountGroupList = session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
								/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
								.list();
		
		List<FaMasAccountGroup>gridMasAccountGroupList=new ArrayList<FaMasAccountGroup>();
			gridMasAccountGroupList=session.createCriteria(FaMasAccountGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
			List<FaMasAccountSubGroup>faMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();

		faMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		List<FaMasAccountSubGroup>gridMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
		gridMasAccountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Status", "y"))
				/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", 1))*/
				.list();
		System.out.println("faMasAccountGroupList=====>>"+faMasAccountGroupList.size());
		map.put("faMasAccountGroupList", faMasAccountGroupList);
		map.put("faMasAccountSubGroupList",faMasAccountSubGroupList);
		map.put("gridMasAccountGroupList",gridMasAccountGroupList);
		map.put("faMasAccountList",faMasAccountList);
		map.put("gridMasAccountSubGroupList",gridMasAccountSubGroupList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> editAccountSubLedger(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasSubLed> subLedIdList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session)getSession();
		subAccGrpList = session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
				.add(Restrictions.eq("fy.Id", box.getInt("fYear")))
								//.add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
								.add(Restrictions.eq("Status", "y")).list();
		subLedList = session.createCriteria(FaMasSubLed.class)
				.createAlias("FYear", "fy")
				.add(Restrictions.eq("fy.Id",  box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		accGrpList = session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
				.add(Restrictions.eq("fy.Id",  box.getInt("fYear")))
							//.add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
							.add(Restrictions.eq("Status", "y")).list();
		accList =session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
				.add(Restrictions.eq("fy.Id",  box.getInt("fYear")))
								.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		subLedIdList = session.createCriteria(FaMasSubLed.class)
				.add(Restrictions.idEq(box.getInt("accountSubledgerId"))).list();
		map.put("subLedIdList", subLedIdList);
		map.put("subLedList", subLedList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("accGrpList", accGrpList);
		map.put("accList", accList);
		
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> updateAccountSubLedger(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
		List<FaMasSubLed> existingAccountList = new ArrayList<FaMasSubLed>();
		List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			
			existingAccountList = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID))).add(Restrictions.eq("SubLedDesc", box.getString(SUB_LDEGER_NAME)))
									.add(Restrictions.ne("Id", box.getInt("accountSubLedgerId"))).add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
			if (existingAccountList.size() > 0) {
				message = "Record already Exist";
			} else {
			FaMasSubLed faMasSubLed = (FaMasSubLed) hbt.load(FaMasSubLed.class,box.getInt("accountSubLedgerId"));
			faMasSubLed.setSubLedDesc(box.getString(SUB_LDEGER_NAME));
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(box.getInt("fYear"));
			
			FaMasAccount masAccount = new FaMasAccount();
			masAccount.setId(box.getInt(ACCOUNT_ID));
			faMasSubLed.setAccount(masAccount);
			BigDecimal opBalanceDr = new BigDecimal(0.0);
			BigDecimal opBalanceCr = new BigDecimal(0.0);
			if(box.getString("accountTypeA").equals("Dr")){
				if(!box.getString("openingBalance").equals("")){
					faMasSubLed.setOpBalanceDr(new BigDecimal(box.getString("openingBalance")));
					opBalanceDr = new BigDecimal(box.getString("openingBalance"));
				}
				faMasSubLed.setOpBalanceCr(new BigDecimal(0.0));
				if(!box.getString("openingBalance").equals("")){
					faMasSubLed.setClBalanceDr(new BigDecimal(box.getString("openingBalance")));
				}
				faMasSubLed.setClBalanceCr(new BigDecimal(0.0));
			}else if(box.getString("accountTypeA").equals("Cr")){
				if(!box.getString("openingBalance").equals("")){
					faMasSubLed.setOpBalanceCr(new BigDecimal(box.getString("openingBalance")));
					opBalanceCr = new BigDecimal(box.getString("openingBalance"));
				}
				if(!box.getString("openingBalance").equals("")){
					faMasSubLed.setClBalanceCr(new BigDecimal(box.getString("openingBalance")));
				}
				faMasSubLed.setOpBalanceDr(new BigDecimal(0.0));
				faMasSubLed.setClBalanceDr(new BigDecimal(0.0));
				
			}
			Users users = new Users();
			users.setId(box.getInt("changedBy"));
			faMasSubLed.setLastChgBy(users);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("locationId"));
			faMasSubLed.setHospital(masHospital);
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			faMasSubLed.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			faMasSubLed.setLastChgTime(time);
			hbt.update(faMasSubLed);
			message = "Record update sucessfully!";
			
//----------------------------------------------calculation for last Balance---------------------------------
			BigDecimal lastOpeningDrBalance = new BigDecimal(0.0);
			BigDecimal lastOpeningCrBalance = new BigDecimal(0.0);
			BigDecimal openingBalanceDr = new BigDecimal(0.0);
			BigDecimal openingBalanceCr = new BigDecimal(0.0);
			
			if(!box.getString("lastOpeningBalanceDr").equals("") ){
				lastOpeningDrBalance = new BigDecimal(box.getString("lastOpeningBalanceDr"));
			}else if(!box.getString("lastOpeningBalanceCr").equals("")){
				lastOpeningCrBalance = new BigDecimal(box.getString("lastOpeningBalanceCr"));
			}
			 if(opBalanceDr.compareTo(new BigDecimal(0))>0){
				 if(lastOpeningCrBalance.compareTo(new BigDecimal(0)) > 0){
				 	 if(lastOpeningCrBalance.compareTo(opBalanceDr) > 0 ){
				 		openingBalanceCr = lastOpeningCrBalance.subtract(opBalanceDr);
				 	 	}else if(opBalanceDr.compareTo(lastOpeningCrBalance) > 0 ){
				 	 		openingBalanceDr =opBalanceDr.subtract(lastOpeningCrBalance);
				 	 	}
				 	 }else if(lastOpeningDrBalance.compareTo(new BigDecimal(0)) > 0) {
				 		 if(opBalanceDr.compareTo(lastOpeningDrBalance)>0){
				 			 openingBalanceDr = opBalanceDr.subtract(lastOpeningDrBalance);
				 		 }else if(lastOpeningDrBalance.compareTo(opBalanceDr)>0){
				 			openingBalanceCr = lastOpeningDrBalance.subtract(opBalanceDr);
				 		 }
					  }
				
			 }else if(opBalanceCr.compareTo(new BigDecimal(0))>0){
					if(lastOpeningDrBalance.compareTo(new BigDecimal(0)) > 0){
					  if(lastOpeningDrBalance.compareTo(opBalanceCr) > 0){
						  openingBalanceDr =lastOpeningDrBalance.subtract(opBalanceCr);
					  	}else if(opBalanceCr.compareTo(lastOpeningDrBalance) > 0 ){
						  	openingBalanceCr =opBalanceCr.subtract(lastOpeningDrBalance);
					 	 }
					}else{
						  
						openingBalanceCr = lastOpeningCrBalance.subtract(opBalanceCr);
						if(opBalanceCr.compareTo(lastOpeningCrBalance)>0){
							openingBalanceCr = opBalanceCr.subtract(lastOpeningCrBalance);
				 		 }else if(lastOpeningCrBalance.compareTo(opBalanceCr)>0){
				 			openingBalanceDr = lastOpeningCrBalance.subtract(opBalanceCr);
				 		 }
						
				  }
			 }
			//----------------update account group--------------
				BigDecimal groupClBalanceDr = new BigDecimal(0.0);
				BigDecimal groupClBalanceCr = new BigDecimal(0.0);
				FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt(ACCOUNT_GROUP_ID));
				if( faMasAccountGroup.getClBalanceDr() != null)
					groupClBalanceDr =  faMasAccountGroup.getClBalanceDr();
				if(faMasAccountGroup.getClBalanceCr() != null)
					groupClBalanceCr = faMasAccountGroup.getClBalanceCr();

					 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(groupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 	 if(groupClBalanceCr.compareTo(openingBalanceDr) > 0 ){
								  groupClBalanceCr = groupClBalanceCr.subtract(openingBalanceDr);
								  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
								  faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(groupClBalanceCr) > 0 ){
						 		 groupClBalanceDr =openingBalanceDr.subtract(groupClBalanceCr);
						 		 faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
						 		 faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else {
								  groupClBalanceDr = groupClBalanceDr.add(openingBalanceDr);
								  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
							  }

					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						if(groupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
						  if(groupClBalanceDr.compareTo(openingBalanceCr) > 0){
							  groupClBalanceDr =groupClBalanceDr.subtract(openingBalanceCr);
							  faMasAccountGroup.setClBalanceDr(groupClBalanceDr);
							  faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						  }else if(openingBalanceCr.compareTo(groupClBalanceDr) > 0 ){
						 		 groupClBalanceCr =openingBalanceCr.subtract(groupClBalanceDr);
						 		 faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
						 		 faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }
						}else{
							  groupClBalanceCr = groupClBalanceCr.add(openingBalanceCr);
							  faMasAccountGroup.setClBalanceCr(groupClBalanceCr);
						  }
					}
	//---------------------------------------update opening Balance------------------------------------------------//
					 BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
						BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
						if( faMasAccountGroup.getOpBalanceDr() != null)
							groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
						if(faMasAccountGroup.getOpBalanceCr() != null)
							groupOpBalanceCr = faMasAccountGroup.getOpBalanceCr();

							 if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
								 if(groupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
								 	 if(groupOpBalanceCr.compareTo(openingBalanceDr) > 0 ){
								 		groupOpBalanceCr = groupOpBalanceCr.subtract(openingBalanceDr);
										  faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
										  faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
								 	 }else if(openingBalanceDr.compareTo(groupOpBalanceCr) > 0 ){
								 		groupOpBalanceDr =openingBalanceDr.subtract(groupOpBalanceCr);
								 		 faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
								 		 faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
								 	 }
								 }else {
									 groupOpBalanceDr = groupOpBalanceDr.add(openingBalanceDr);
										  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
									  }

							}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
								if(groupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
								  if(groupOpBalanceDr.compareTo(openingBalanceCr) > 0){
									  groupOpBalanceDr =groupOpBalanceDr.subtract(openingBalanceCr);
									  faMasAccountGroup.setOpBalanceDr(groupOpBalanceDr);
									  faMasAccountGroup.setOpBalanceCr(new BigDecimal(0.00));
								  }else if(openingBalanceCr.compareTo(groupOpBalanceDr) > 0 ){
									  groupOpBalanceCr =openingBalanceCr.subtract(groupOpBalanceDr);
								 		 faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
								 		 faMasAccountGroup.setOpBalanceDr(new BigDecimal(0.00));
								 	 }
								}else{
									groupOpBalanceCr = groupOpBalanceCr.add(openingBalanceCr);
									  faMasAccountGroup.setOpBalanceCr(groupOpBalanceCr);
								  }
							}
					 
					hbt.update(faMasAccountGroup);

	//--------------------------------------------update subGroup group--------------
					BigDecimal subGroupClBalanceDr = new BigDecimal(0.0);
					BigDecimal subGroupClBalanceCr = new BigDecimal(0.0);
					FaMasAccountSubGroup faMasAccountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt(ACCOUNT_SUB_GROUP_ID));
					if(faMasAccountSubGroup.getClBalanceDr() != null)
						subGroupClBalanceDr =  faMasAccountSubGroup.getClBalanceDr();

					if(faMasAccountSubGroup.getClBalanceCr() != null)
						subGroupClBalanceCr = faMasAccountSubGroup.getClBalanceCr();

					if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(subGroupClBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupClBalanceCr.compareTo(openingBalanceDr) > 0){
						 		 subGroupClBalanceDr = subGroupClBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceDr);
						 		 faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(subGroupClBalanceCr) > 0 ){
						 		subGroupClBalanceDr =openingBalanceDr.subtract(subGroupClBalanceCr);
						 		faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
						 		faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else{

							  subGroupClBalanceDr = subGroupClBalanceDr.add(openingBalanceDr);
							  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(subGroupClBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupClBalanceDr.compareTo(openingBalanceCr) > 0){

								  subGroupClBalanceCr = subGroupClBalanceDr.subtract(openingBalanceCr);
								  faMasAccountSubGroup.setClBalanceDr(subGroupClBalanceCr);
								  faMasAccountSubGroup.setClBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(subGroupClBalanceDr) > 0 ){
								  	subGroupClBalanceCr =openingBalanceCr.subtract(subGroupClBalanceDr);
								  	faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
								  	faMasAccountSubGroup.setClBalanceDr(new BigDecimal(0.00));
							 	 }
						 }
						 else{
							  subGroupClBalanceCr = subGroupClBalanceCr.add(openingBalanceCr);
							  faMasAccountSubGroup.setClBalanceCr(subGroupClBalanceCr);
						  }
					}
	//-------------------------------------------update sub group opening Balance------------------------------------//
					BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
					if(faMasAccountSubGroup.getOpBalanceDr() != null)
						subGroupOpBalanceDr =  faMasAccountSubGroup.getOpBalanceDr();

					if(faMasAccountSubGroup.getOpBalanceCr() != null)
						subGroupOpBalanceCr = faMasAccountSubGroup.getOpBalanceCr();

					if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(subGroupOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupOpBalanceCr.compareTo(openingBalanceDr) > 0){
								 subGroupOpBalanceDr = subGroupOpBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceDr);
						 		 faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(subGroupOpBalanceCr) > 0 ){
						 		subGroupOpBalanceDr =openingBalanceDr.subtract(subGroupOpBalanceCr);
						 		faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
						 		faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else{

							 subGroupOpBalanceDr = subGroupOpBalanceDr.add(openingBalanceDr);
							  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(subGroupOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(subGroupOpBalanceDr.compareTo(openingBalanceCr) > 0){

								 subGroupOpBalanceCr = subGroupOpBalanceDr.subtract(openingBalanceCr);
								  faMasAccountSubGroup.setOpBalanceDr(subGroupOpBalanceCr);
								  faMasAccountSubGroup.setOpBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(subGroupOpBalanceDr) > 0 ){
								  subGroupOpBalanceCr =openingBalanceCr.subtract(subGroupOpBalanceDr);
								  	faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
								  	faMasAccountSubGroup.setOpBalanceDr(new BigDecimal(0.00));
							 	 }
						 }
						 else{
							 subGroupOpBalanceCr = subGroupOpBalanceCr.add(openingBalanceCr);
							  faMasAccountSubGroup.setOpBalanceCr(subGroupOpBalanceCr);
						  }
					}
					hbt.update(faMasAccountSubGroup);


	//--------------------------------------------update accountMaster--------------
					BigDecimal accountClBalanceDr = new BigDecimal(0.0);
					BigDecimal accountBalanceCr = new BigDecimal(0.0);

					FaMasAccount faMasAccount = (FaMasAccount)hbt.load(FaMasAccount.class, box.getInt(ACCOUNT_ID));
					if(faMasAccount.getClBalanceDr() != null)
						accountClBalanceDr =  faMasAccount.getClBalanceDr();
					if(faMasAccount.getClBalanceCr() != null)
						accountBalanceCr = faMasAccount.getClBalanceCr();

					if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(accountBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(accountBalanceCr.compareTo(openingBalanceDr) > 0){
						 		 accountClBalanceDr = accountBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccount.setClBalanceCr(accountClBalanceDr);
						 		 faMasAccount.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(accountBalanceCr) > 0 ){
						 		accountClBalanceDr =openingBalanceDr.subtract(accountBalanceCr);
						 		faMasAccount.setClBalanceDr(accountClBalanceDr);
						 		faMasAccount.setClBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else{

							  accountClBalanceDr = accountClBalanceDr.add(openingBalanceDr);
							  faMasAccount.setClBalanceDr(accountClBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(accountClBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(accountClBalanceDr.compareTo(openingBalanceCr) > 0){

								  accountBalanceCr = accountClBalanceDr.subtract(openingBalanceCr);
								  faMasAccount.setClBalanceDr(accountBalanceCr);
								  faMasAccount.setClBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(accountClBalanceDr) > 0 ){
								  	accountBalanceCr =openingBalanceCr.subtract(accountClBalanceDr);
								  	faMasAccount.setClBalanceCr(accountBalanceCr);
								  	faMasAccount.setClBalanceDr(new BigDecimal(0.00));
							 	 }
						 }
						 else{
							  accountBalanceCr = accountBalanceCr.add(openingBalanceCr);
							  faMasAccount.setClBalanceCr(accountBalanceCr);
						  }
					}
	//-------------------------------update account opening Balance-----------------------------------------------//
					BigDecimal accountOpBalanceDr = new BigDecimal(0.0);
					BigDecimal accountOpBalanceCr = new BigDecimal(0.0);

					if(faMasAccount.getOpBalanceDr() != null)
						accountOpBalanceDr =  faMasAccount.getOpBalanceDr();
					if(faMasAccount.getOpBalanceCr() != null)
						accountOpBalanceCr = faMasAccount.getOpBalanceCr();

					if(openingBalanceDr.compareTo(new BigDecimal(0))>0){
						 if(accountOpBalanceCr.compareTo(new BigDecimal(0)) > 0){
							 if(accountOpBalanceCr.compareTo(openingBalanceDr) > 0){
								 accountOpBalanceDr = accountOpBalanceCr.subtract(openingBalanceDr);
						 		 faMasAccount.setOpBalanceCr(accountOpBalanceDr);
						 		 faMasAccount.setOpBalanceDr(new BigDecimal(0.00));
						 	 }else if(openingBalanceDr.compareTo(accountOpBalanceCr) > 0 ){
						 		accountOpBalanceDr =openingBalanceDr.subtract(accountOpBalanceCr);
						 		faMasAccount.setOpBalanceDr(accountOpBalanceDr);
						 		faMasAccount.setOpBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else{

							 accountOpBalanceDr = accountOpBalanceDr.add(openingBalanceDr);
							  faMasAccount.setOpBalanceDr(accountOpBalanceDr);
						  }
					}else if(openingBalanceCr.compareTo(new BigDecimal(0))>0){
						 if(accountOpBalanceDr.compareTo(new BigDecimal(0)) > 0){
							 if(accountOpBalanceDr.compareTo(openingBalanceCr) > 0){

								 accountOpBalanceCr = accountOpBalanceDr.subtract(openingBalanceCr);
								  faMasAccount.setOpBalanceDr(accountOpBalanceCr);
								  faMasAccount.setOpBalanceCr(new BigDecimal(0.00));
							  }else if(openingBalanceCr.compareTo(accountOpBalanceDr) > 0 ){
								  accountOpBalanceCr =openingBalanceCr.subtract(accountOpBalanceDr);
								  	faMasAccount.setOpBalanceCr(accountOpBalanceCr);
								  	faMasAccount.setOpBalanceDr(new BigDecimal(0.00));
							 	 }
						 }
						 else{
							 accountOpBalanceCr = accountOpBalanceCr.add(openingBalanceCr);
							  faMasAccount.setOpBalanceCr(accountOpBalanceCr);
						  }
					}
				 	hbt.update(faMasAccount);
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------------------		 	
	 	
	 	accGrpList =session.createCriteria(FaMasAccountGroup.class).createAlias("FYear", "fy")
		 						.add(Restrictions.eq("fy.Id", box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();

	 	subAccGrpList =session.createCriteria(FaMasAccountSubGroup.class).createAlias("FYear", "fy")
		 						.add(Restrictions.eq("fy.Id", box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		subLedList = session.createCriteria(FaMasSubLed.class).createAlias("FYear", "fy")
							.add(Restrictions.eq("fy.Id", box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId"))).list();
		accList =session.createCriteria(FaMasAccount.class).createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id",  box.getInt("fYear"))).add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
							.list();
		map.put("subLedList", subLedList);
		map.put("accGrpList", accGrpList);
		map.put("subAccGrpList", subAccGrpList);
		map.put("accList", accList);
		map.put("message", message);
		return map;
	}
	/**
	 *  Code By Ritu For Bank Reconciliation
	 */

	@Override
		@SuppressWarnings("unchecked")
		public Map<String, Object> showBankReconciliationJsp(int fYear) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
			Session session = getSession();

			try {
				accountList = session.createCriteria(FaMasAccount.class)
									/*.createAlias("AccountSubGroup", "sg")
									.add(Restrictions.eq("sg.Id", 31378))*/
									.add(Restrictions.eq("ParentStatus", "n")).list();
				map.put("accountList", accountList);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return map;
		}
	
	

		@Override
		@SuppressWarnings("unchecked")
		public Map<String, Object> getBankAccountDetailsForReconciliation(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasAccount> accountBalanceList1 = new ArrayList<FaMasAccount>();
			List<AccountMainTransac> accountBalanceList = new ArrayList<AccountMainTransac>();
			List<FaVoucherDetails> vrDtAccountList = new ArrayList<FaVoucherDetails>();
			List<FaVoucherDetails> voucherDtList = new ArrayList<FaVoucherDetails>();
			Session session = getSession();
			int fYear = box.getInt("fYear");
			Object voucherType[] = {"PV","RV","PRV"};
			try {
				accountBalanceList1 = session.createCriteria(FaMasAccount.class)
										/*.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))*/
										.add(Restrictions.eq("Id", box.getInt(BANK_ACCOUNT)))
										.list();
				
				accountBalanceList = session.createCriteria(AccountMainTransac.class)
						.createAlias("FYear", "fy").add(Restrictions.eq("fy.Id", fYear))
						.createAlias("Location", "location").add(Restrictions.eq("location.Id", box.getInt("locationId")))
						.createAlias("Account", "acc").add(Restrictions.eq("acc.Id", box.getInt(BANK_ACCOUNT)))					
						.list();
				
				
				FaMasAccount masAccount = new FaMasAccount();
				if(accountBalanceList1.size() > 0){
					masAccount = accountBalanceList1.get(0);
				}
				Set<FaVoucherDetails> voucherDetailsSet =  new HashSet<FaVoucherDetails>();
				if(masAccount.getFaVoucherDetails() != null){
					voucherDetailsSet = masAccount.getFaVoucherDetails();
					for (FaVoucherDetails faVoucherDetails : voucherDetailsSet) {
						int vrHdId = faVoucherDetails.getVoucherHeader().getId();
						vrDtAccountList = session.createCriteria(FaVoucherDetails.class)
										.createAlias("VoucherHeader", "vh").add(Restrictions.eq("vh.Id", vrHdId)).add(Restrictions.eq("vh.VoucherType", "PV"))
										.createAlias("Account", "acc").add(Restrictions.eq("acc.Id", box.getInt(BANK_ACCOUNT)))
										//.add(Restrictions.eq("Reconcile", "n"))
										.list();
						voucherDtList.addAll(vrDtAccountList);
					}
				}
				map.put("voucherDtList", voucherDtList);
				map.put("accountBalanceList", accountBalanceList);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return map;
		}

		@Override
		public boolean saveBankReconciliationDetails(Box box) {
			boolean saved = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Transaction tx= null;
			Session session =getSession();
			try {
				tx= session.beginTransaction();
				int counter = box.getInt("counter");
				System.out.println("box.getInt--->>>"+box.getInt("counter"));
				FaBankReconciliationHeader reconciliationHeader = new FaBankReconciliationHeader();
				reconciliationHeader.setReconciliationDate(HMSUtil.convertStringTypeDateToDateType(box.getString(AS_ON_DATE)));
				FaMasAccount account = new FaMasAccount();
				account.setId(box.getInt(BANK_ACCOUNT));
				reconciliationHeader.setAccount(account);
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("locationId"));
				reconciliationHeader.setHospital(hospital);
				if(box.getString(BALANCE_TYPE).equalsIgnoreCase("dr")){
					reconciliationHeader.setDrBlncAsPerCompany(new BigDecimal(box.getString(COMPANY_BALANCE)));
				}else if(box.getString(BALANCE_TYPE).equalsIgnoreCase("cr")){
					reconciliationHeader.setCrBlncAsPerCompany(new BigDecimal(box.getString(COMPANY_BALANCE)));
				}
				if(box.getString("bankBlncType").equalsIgnoreCase("dr")){
					reconciliationHeader.setDrBlncAsPerBank(new BigDecimal(box.getString("bankBlnc")));
				}else if(box.getString(BALANCE_TYPE).equalsIgnoreCase("cr")){
					reconciliationHeader.setCrBlncAsPerBank(new BigDecimal(box.getString("bankBlnc")));
				}
				if(!box.getString("difference").equals("")){
					reconciliationHeader.setDiffAmt(new BigDecimal(box.getString("difference")));
				}
				Users users = new Users();
				users.setId(box.getInt("userId"));
				reconciliationHeader.setLastChgBy(users);
				reconciliationHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				reconciliationHeader.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(reconciliationHeader);

				
				for (int i = 1; i <= counter; i++) {
					System.out.println("box.getString=--->>"+box.getString("transactionDate"+i));
					if(box.getString("transactionDate")!=null && !box.getString("transactionDate").equals("")){
						FaBankReconciliationDetails reconciliationDetails = new FaBankReconciliationDetails();
						reconciliationDetails.setClearingDate(HMSUtil.convertStringTypeDateToDateType(box.getString("transactionDate")));
						reconciliationDetails.setChequeAmt(new BigDecimal(box.getString("transactionAmount")));
						/*FaVoucherHeader voucherHeader = new FaVoucherHeader();
						voucherHeader.setId(box.getInt(VOUCHER_HD_ID));
						reconciliationDetails.setVoucherHeader(voucherHeader);*/
						reconciliationDetails.setVoucherType(box.getString("transactionType"));
						reconciliationDetails.setNarration(box.getString("Narration"));
						reconciliationDetails.setBankReconciliationHeader(reconciliationHeader);
						hbt.save(reconciliationDetails);
					}
					
					
					System.out.println("box.getString=--->>"+box.getString(CHEQUE_STATUS+i));
					System.out.println("CHEQUE_NO  ---   "+box.getString(CHEQUE_NO+i));
					
					if(!box.getString(CHEQUE_STATUS+i).equals("") && !box.getString(CHEQUE_STATUS+i).equals("cleared")){
						FaBankReconciliationDetails reconciliationDetails = new FaBankReconciliationDetails();
						reconciliationDetails.setBankReconciliationHeader(reconciliationHeader);
						reconciliationDetails.setChequeAmt(new BigDecimal(box.getString(AMOUNT+i)));
						reconciliationDetails.setChequeStatus(box.getString(CHEQUE_STATUS+i));
						if(box.getString(CHEQUE_DATE+i)!=null && !box.getString(CHEQUE_DATE+i).equals("")){
						//reconciliationDetails.setChequeDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE+i).substring(0,)));
						}
						reconciliationDetails.setChequeNo(box.getString(CHEQUE_NO+i));
						reconciliationDetails.setVoucherType(box.getString(VOUCHER_TYPE+i));
						reconciliationDetails.setClearingDate(new Date());
						/*FaVoucherHeader voucherHeader = new FaVoucherHeader();
						voucherHeader.setId(box.getInt(VOUCHER_HD_ID+i));
						reconciliationDetails.setVoucherHeader(voucherHeader);*/
						hbt.save(reconciliationDetails);
					}else{
						if(!box.getString("clearingDate"+i).equals("")){
						FaBankReconciliationDetails reconciliationDetails = new FaBankReconciliationDetails();
						reconciliationDetails.setBankReconciliationHeader(reconciliationHeader);
						reconciliationDetails.setChequeAmt(new BigDecimal(box.getString(AMOUNT+i)));
						reconciliationDetails.setChequeStatus(box.getString(CHEQUE_STATUS+i));
						reconciliationDetails.setChequeDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE+i)));
						reconciliationDetails.setChequeNo(box.getString(CHEQUE_NO+i));
						reconciliationDetails.setVoucherType(box.getString(VOUCHER_TYPE+i));
						FaVoucherHeader voucherHeader = new FaVoucherHeader();
						voucherHeader.setId(box.getInt(VOUCHER_HD_ID+i));
						reconciliationDetails.setVoucherHeader(voucherHeader);
						reconciliationDetails.setClearingDate(HMSUtil.convertStringTypeDateToDateType(box.getString("clearingDate"+i)));
						hbt.save(reconciliationDetails);
						}
						
					}
					/*if(!box.getString(CHEQUE_STATUS+i).equals("")){
						int voucherDtId  = box.getInt(VOUCHER_DT_ID+i);
						FaVoucherDetails voucherDetails = (FaVoucherDetails)hbt.load(FaVoucherDetails.class, voucherDtId);
						voucherDetails.setReconcile("y");
						hbt.update(voucherDetails);
					}*/
				}
				saved = true;
				tx.commit();
			} catch (DataAccessException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}

			return saved;
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public Map<String, Object> showCashVoucherJsp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
			List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
			List<Object[]> amountList = new ArrayList<Object[]>();
			List<MasWard>wardList=new ArrayList<MasWard>();
			
			Session session = (Session)getSession();
			String codeoffamasaccountsubgroupforreceiptVouch = "";
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("account.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				codeoffamasaccountsubgroupforreceiptVouch = prop
						.getProperty("codeoffamasaccountsubgroupforreceiptVouch");
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*String[] temp=codeoffamasaccountsubgroupforreceiptVouch.split(",");
			ArrayList<Integer> selectedId=new ArrayList<Integer>();
			for (int i = 0; i < temp.length; i++) {
				selectedId.add(Integer.parseInt(temp[i]));
			}*/
			Object[] selectedId = {"1","2"};
			
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "RV");
			paramMap.put("voucherType", "Reciept");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			System.out.println("selectedId--->"+selectedId);
			accList = session.createCriteria(FaMasAccount.class)
						.createAlias("AccountSubGroup", "subGroup")
						.add(Restrictions.in("subGroup.Flag", selectedId))
						//.add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
						
						.list();
			amountList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("header.Hospital", "hospital")
					.createAlias("header.FYear", "fYear").add(Restrictions.eq("fYear.Id", box.getInt("fYear")))
							.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("header.VoucherType", "RV"))
							.setProjection(Projections.projectionList().add(
								Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
								Projections.groupProperty("header.VoucherType"))).list();
			
			List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
			masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("masSchemeList", masSchemeList);
			costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase())
			.addOrder(Order.asc("CostCenterName") ).list();
			System.out.println("<<===costCenterList.size()=====>>"+costCenterList.size());
			wardList=session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("costCenterList", costCenterList);
			map.put("accList", accList);
			map.put("amountList", amountList);
			map.put("wardList", wardList);
			return map;
		}
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> getNarrationForAutoComplete(Map<String, Object> parameterMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasNarration> voucherNarationList  = new ArrayList<FaMasNarration>();
			String narrationStr = "";
			if(parameterMap.get("narrationStr")!= null){
				narrationStr = (String)parameterMap.get("narrationStr");
			}

			Session session =  (Session)getSession();
			voucherNarationList = session.createCriteria(FaMasNarration.class).add(Restrictions.ilike("NarrationDesc",narrationStr+"%"))
						.list();
			map.put("voucherNarationList", voucherNarationList);
			return map;

		}

		public Map<String, Object> addVoucherNarration(FaMasNarration faMasNarration) {
			Map<String, Object> map = new HashMap<String, Object>();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			boolean saved = false;
			String message = "";
			try {
				hbt.save(faMasNarration);
				saved = true;
				if(saved == true){
					message = "Narration saved";
				}else{
					message = "Some Problem Occured";
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			map.put("message", message);
			return map;

		}

		/*@SuppressWarnings("unchecked")
		public Map<String, Object> showAccountBalance(int accountId) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
			Session session = (Session)getSession();
			accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
			map.put("accountList", accountList);

			return map;
		}
*/

		@SuppressWarnings("unchecked")
		public Map<String, Object> getAccountNarrationForAutoComplete(
				Map<String, Object> parameterMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasNarration> voucherNarationList  = new ArrayList<FaMasNarration>();
			String accountNarration = "";
			if(parameterMap.get("accountNarration")!= null){
				accountNarration = (String)parameterMap.get("accountNarration");
			}

			Session session =  (Session)getSession();
			voucherNarationList = session.createCriteria(FaMasNarration.class).add(Restrictions.ilike("NarrationDesc",accountNarration+"%"))
						.list();
			map.put("voucherNarationList", voucherNarationList);
			return map;
		}
		@SuppressWarnings("unchecked")
		public Map<String, Object> submitReceiptVoucher(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
			List<FaMasAccount> maxAccountIdList = new ArrayList<FaMasAccount>();
			List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
			int vhId=0;
			String voucherNo1="";
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session)getSession();
			Transaction tx = null;
			boolean saved = false;
			int accountListLength = box.getInt("hiddenValueCharge");
			//int accountListLengthForBank = box.getInt("hiddenValueChargeForBank");
			int authLevel=0;
			if(box.getInt("authLevel")!=0){
				authLevel=box.getInt("authLevel");
			}
			String locationCode="";
			String yearDesc="";
			try {
				tx = session.beginTransaction();
				FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("locationId"));
			/*	String item1[] = box.getString("accountName").split("\\[");
				String item11[] = item1[1].split("]");
				String item111 = item11[0];
				System.out.println("accountCode------>>"+item111);
				int accountId2=getAccountId(item111);
				int subGroupId=0;
				subGroupId=getSubGroupId(accountId2);
				int groupId=0;
				groupId=getGroupId(subGroupId);
*/
				
				faVoucherHeader.setHospital(masHospital);
				faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
				faVoucherHeader.setNarration(box.getString(NARRATION));
				Users users = new Users();
				users.setId( box.getInt("changedBy"));
				faVoucherHeader.setLastChgBy(users);
				faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
				faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
				faVoucherHeader.setVoucherType("RV");
				faVoucherHeader.setStatus("y");
				BigDecimal totalAmountDr = new BigDecimal(0.0);
				if (!box.getString(TOTAL_AMOUNT).equals("")) {
					totalAmountDr = new BigDecimal(box.getString(TOTAL_AMOUNT));
					faVoucherHeader.setDrAmount(totalAmountDr);
					faVoucherHeader.setCrAmount(totalAmountDr);
				}

				MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
				masStoreFinancial.setId(box.getInt("fYear"));
				faVoucherHeader.setFYear(masStoreFinancial);
				if (!box.getString(BANK_NAME).equals("")) {
					faVoucherHeader.setBankName(box.getString(BANK_NAME));
				}
				if (!box.getString(CHEQUE_DATE).equals("")) {
					faVoucherHeader.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE )));
				}
				if (!box.getString(CHEQUE_NO).equals("")) {
					faVoucherHeader.setChequeNo(box.getString(CHEQUE_NO));
				}
				
				if (box.getInt("schemeId") != 0) {
					MasScheme masScheme = new MasScheme();
					masScheme.setId(box.getInt("schemeId"));
					faVoucherHeader.setScheme(masScheme);
				}
				int wardId=0;
				if(box.getInt("wardId")!=0){
					wardId=(box.getInt("wardId"));
				}
				if(wardId!=0){
				MasWard masWard=new MasWard();
				masWard.setId(wardId);
				faVoucherHeader.setWard(masWard);
				}
				
				paramMap.put("locationId", box.getInt("locationId"));
				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "save");
				paramMap.put("prefix", "RV");
				paramMap.put("voucherType", "Reciept");
				paramMap.put("financialYearId", box.getInt("fYear"));
				
				int voucherNo = generateVoucherNo(paramMap);
				
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo("RV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
				
				voucherNo1=locationCode+"/"+yearDesc+"/"+voucherNo;
				FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
				faMasAccountSubGroup.setId(box.getInt("subGroupId"));
				/*faVoucherHeader.setAccountSubGroup(faMasAccountSubGroup);*/
				if(authLevel==0){
					authLevel=getAuthLevel(box.getInt("locationId"));
				}
				if(authLevel==1){
					faVoucherHeader.setAuthLevelOne("w");
				}else if(authLevel==2){
					faVoucherHeader.setAuthLevelOne("w");
					faVoucherHeader.setAuthLevelTwo("w");
					
				}else if(authLevel==3){
					faVoucherHeader.setAuthLevelOne("w");
					faVoucherHeader.setAuthLevelTwo("w");
					faVoucherHeader.setAuthLevelThree("w");
				}else if(authLevel==4){
					faVoucherHeader.setAuthLevelOne("w");
					faVoucherHeader.setAuthLevelTwo("w");
					faVoucherHeader.setAuthLevelThree("w");
					faVoucherHeader.setAuthLevelFour("w");
				}
				faVoucherHeader.setRejected("n");
				hbt.save(faVoucherHeader);
				map.put("voucherType", faVoucherHeader.getVoucherType());
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
				voucherDetails.setVoucherHeader(faVoucherHeader);
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(box.getInt(ACCOUNT_ID));
					voucherDetails.setAccount(masAccount);
					voucherDetails.setDrAmount(totalAmountDr);
					voucherDetails.setNarration(box.getString(NARRATION));
	//------------------------------code for account id report--------------------------------------
					if(accountListLength > 0){
						if (box.getInt("accountId1") != 0) {
							FaMasAccount account = new FaMasAccount();
							account.setId(box.getInt("accountId1") );
							voucherDetails.setAccountIdForReport(account);
						}
						if (box.getInt(SUB_LEDGER_CODE+"1") != 0) {
							FaMasSubLed subLed = new FaMasSubLed();
							subLed.setId(box.getInt(SUB_LEDGER_CODE+"1"));
							voucherDetails.setSubLedIdForReport(subLed);
						}
					}
					//------------------------------code for Sub Ledger id report-------commented by anamika on 20th August-------------------------------
					/*if(accountListLengthForBank > 0){
						if (box.getInt("accountId1") != 0) {
							FaMasAccount account = new FaMasAccount();
							account.setId(box.getInt("accountId1") );
							voucherDetails.setAccountIdForReport(account);
						}
						if (box.getInt(SUB_LEDGER_CODE_BANK+"1") != 0) {
							FaMasSubLed subLed = new FaMasSubLed();
							subLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+"1"));
							voucherDetails.setSubLedIdForReport(subLed);
						}
					}*/

					hbt.save(voucherDetails);
					
					updateTransaction(box.getInt(SUB_LEDGER_CODE+"1"), box.getInt(ACCOUNT_ID), box.getInt("fYear"), box.getInt("locationId"), "0.00", ""+totalAmountDr);

					//-------------------------update account group-------------------------------------------------
					BigDecimal groupOPBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drGroupAmount = new BigDecimal(0.0);
					BigDecimal crGroupAmount = new BigDecimal(0.0);

					 /*FaMasAccountGroup faMasAccountGroup2 = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"));
					 	if(faMasAccountGroup2.getOpBalanceDr()!= null){
					 		groupOPBalanceDr =  faMasAccountGroup2.getOpBalanceDr();
					 	}
					 	if(faMasAccountGroup2.getOpBalanceCr()!= null){
					 		groupOpBalanceCr = faMasAccountGroup2.getOpBalanceCr();
					 	}
						if(faMasAccountGroup2.getYtdAmountDr()!= null){
							groupYtdBalanceDr = faMasAccountGroup2.getYtdAmountDr();
						}
						if(faMasAccountGroup2.getYtdAmountCr()!= null){
							groupYtdBalanceCr = faMasAccountGroup2.getYtdAmountCr();
						}
						if(totalAmountDr.compareTo(new BigDecimal(0))>0){
							groupYtdBalanceDr = groupYtdBalanceDr.add(totalAmountDr);
							 faMasAccountGroup2.setYtdAmountDr(groupYtdBalanceDr);
						 }
						crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
						drGroupAmount = groupOPBalanceDr.add(groupYtdBalanceDr);
						
						if(drGroupAmount.compareTo(crGroupAmount)>0){
							faMasAccountGroup2.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
							faMasAccountGroup2.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)>0){
							faMasAccountGroup2.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
							faMasAccountGroup2.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)==0){
							faMasAccountGroup2.setClBalanceCr(new BigDecimal(0.00));
							faMasAccountGroup2.setClBalanceDr(new BigDecimal(0.00));
						}
				 	hbt.update(faMasAccountGroup2);

				 	//-------------------------update account Sub group-------------------------------------------------
					BigDecimal subGroupOPBalanceDr = new BigDecimal(0.0);
					BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal subGroupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal subGroupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drSubGroupAmount = new BigDecimal(0.0);
					BigDecimal crSubGroupAmount = new BigDecimal(0.0);
					
				 FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"));
					 if(accountSubGroup.getOpBalanceDr()!= null){
						 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup.getOpBalanceCr()!= null){
						 subGroupOpBalanceCr = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
					 }
					 if(totalAmountDr.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(totalAmountDr);
						 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
					 }
					 crSubGroupAmount = subGroupOpBalanceCr.add(subGroupYtdBalanceCr);
					 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
						
						if(drSubGroupAmount.compareTo(crSubGroupAmount)>0){
							accountSubGroup.setClBalanceDr(drSubGroupAmount.subtract(crSubGroupAmount));
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crSubGroupAmount.compareTo(drSubGroupAmount)>0){
							accountSubGroup.setClBalanceCr(crSubGroupAmount.subtract(drSubGroupAmount));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crSubGroupAmount.compareTo(drSubGroupAmount)==0){
							accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
							accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
						}
				 	hbt.update(accountSubGroup);

		//-------------------------update account master-------------------------------------------------
			 	BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		FaMasAccount masAccount2 = (FaMasAccount)hbt.load(FaMasAccount.class, box.getInt(ACCOUNT_ID));
		 		
		 		if(masAccount2.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount2.getOpBalanceDr();
		 		}
		 		if(masAccount2.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount2.getOpBalanceCr();
		 		}
		 		 if(masAccount2.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount2.getYtdAmountDr();
		 		 }
		 		 if(masAccount2.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount2.getYtdAmountCr();
		 		 }
		 		if(totalAmountDr.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceDr = accountYtdBalanceDr.add(totalAmountDr);
					 masAccount2.setYtdAmountDr(accountYtdBalanceDr);
				 }
		 		crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
		 		drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
					if(drAccountAmount.compareTo(crAccountAmount)>0){
						masAccount2.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
						masAccount2.setClBalanceCr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)>0){
						masAccount2.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
						masAccount2.setClBalanceDr(new BigDecimal(0.00));
					}else if(crAccountAmount.compareTo(drAccountAmount)==0){
						masAccount2.setClBalanceCr(new BigDecimal(0.00));
						masAccount2.setClBalanceDr(new BigDecimal(0.00));
					}
		 	hbt.update(masAccount2);*/
			//--------------------------------------------------------------
			if(accountListLength > 0){
				for (int i = 1; i <= accountListLength; i++) {
					FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
						if(!box.getString(AMOUNT+i).equals("") ){
							faVoucherDetails.setVoucherHeader(faVoucherHeader);
						BigDecimal amountCr = new BigDecimal(box.getString(AMOUNT+ i));
						faVoucherDetails.setCrAmount(amountCr);
						
					int cashAccountId = 0;
							if (box.getInt("accountId"+ i) != 0) {
							FaMasAccount faMasAccount = new FaMasAccount();
							cashAccountId= box.getInt("accountId"+ i);
							faMasAccount.setId(cashAccountId);
							faVoucherDetails.setAccount(faMasAccount);
						}
						if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
							FaMasSubLed faMasSubLed = new FaMasSubLed();
							faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
							faVoucherDetails.setSubLed(faMasSubLed);
						}
						if (box.getInt(COST_CENTER_ID+ i) != 0) {
							MasCostCenter masCostCenter = new MasCostCenter();
							masCostCenter.setId(box.getInt(COST_CENTER_ID+ i));
							faVoucherDetails.setCostCenter(masCostCenter);
						}
						
						if (!box.getString(ACCOUNT_NARRATION + i).equals("")) {
							faVoucherDetails.setNarration(box.getString(ACCOUNT_NARRATION + i));
						}
						FaMasAccount acc = new FaMasAccount();
						acc.setId(box.getInt(ACCOUNT_ID));
						faVoucherDetails.setAccountIdForReport(acc);
						faVoucherDetails.setReconcile("n");
						hbt.save(faVoucherDetails);
						//updateTransaction(box.getInt(SUB_LEDGER_CODE+ i), box.getInt("accountId"+ i), box.getInt("fYear"), box.getInt("locationId"),"0.00", ""+totalAmountDr );
						updateTransaction(box.getInt(SUB_LEDGER_CODE+ i), box.getInt("accountId"+ i), box.getInt("fYear"), box.getInt("locationId"), box.getString(AMOUNT+ i), "0.00");
						}
				  }
			  }
						/*
			//-----------------------------update account group-------------------------------
						BigDecimal groupOpBalanceDrForCash = new  BigDecimal(0.0);
				 		BigDecimal groupOpBalanceCrForCash = new  BigDecimal(0.0);
				 		BigDecimal groupYtdBalanceDrForCash = new BigDecimal(0.0);
				 		BigDecimal groupYtdBalanceCrForCash = new  BigDecimal(0.0);
				 		BigDecimal drGroupAmountForCash = new BigDecimal(0.0);
				 		BigDecimal crGroupAmountForCash = new  BigDecimal(0.0);
						FaMasAccountGroup masAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"+ i));
						if(masAccountGroup.getOpBalanceCr()!= null){
							groupOpBalanceCrForCash =  masAccountGroup.getOpBalanceCr();
						}
						if(masAccountGroup.getOpBalanceDr()!= null){
							groupOpBalanceDrForCash = masAccountGroup.getOpBalanceDr();
						}
						if(masAccountGroup.getYtdAmountCr() != null){
							groupYtdBalanceCrForCash = masAccountGroup.getYtdAmountCr();
						}
						if(masAccountGroup.getYtdAmountDr() != null){
							groupYtdBalanceDrForCash = masAccountGroup.getYtdAmountDr();
						}
						if(amountCr.compareTo(new BigDecimal(0))>0){
							groupYtdBalanceCrForCash = groupYtdBalanceCrForCash.add(amountCr);
							 masAccountGroup.setYtdAmountCr(groupYtdBalanceCrForCash);

						 }
						crGroupAmountForCash = groupOpBalanceCrForCash.add(groupYtdBalanceCrForCash);
						drGroupAmountForCash = groupOpBalanceDrForCash.add(groupYtdBalanceDrForCash);
							
							if(drGroupAmountForCash.compareTo(crGroupAmountForCash)>0){
								masAccountGroup.setClBalanceDr(drGroupAmountForCash.subtract(crGroupAmountForCash));
								masAccountGroup.setClBalanceCr(new BigDecimal(0.00));
							}else if(crGroupAmountForCash.compareTo(drGroupAmountForCash)>0){
								masAccountGroup.setClBalanceCr(crGroupAmountForCash.subtract(drGroupAmountForCash));
								masAccountGroup.setClBalanceDr(new BigDecimal(0.00));
							}else if(crGroupAmountForCash.compareTo(drGroupAmountForCash)==0){
								masAccountGroup.setClBalanceCr(new BigDecimal(0.00));
								masAccountGroup.setClBalanceDr(new BigDecimal(0.00));
							}
					 hbt.update(masAccountGroup);

					//-------------------------update account Sub group-------------------------------------------------
					 BigDecimal subGroupOpBalanceDrForCash = new  BigDecimal(0.0);
				 		BigDecimal subGroupOpBalanceCrForCash = new  BigDecimal(0.0);
				 		BigDecimal subGroupYtdBalanceDrForCash = new BigDecimal(0.0);
				 		BigDecimal subGroupYtdBalanceCrForCash = new  BigDecimal(0.0);
				 		BigDecimal drSubGroupAmountForCash = new BigDecimal(0.0);
				 		BigDecimal crSubGroupAmountForCash = new  BigDecimal(0.0);
					 FaMasAccountSubGroup accountSubGroup2 = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"+ i));
						 if(accountSubGroup2.getOpBalanceDr()!= null){
							 subGroupOpBalanceDrForCash =  accountSubGroup.getOpBalanceDr();
						 }
						 if(accountSubGroup2.getOpBalanceCr()!= null){
							 subGroupOpBalanceCrForCash = accountSubGroup.getOpBalanceCr();
						 }
						 if(accountSubGroup2.getYtdAmountDr()!= null){
							 subGroupYtdBalanceDrForCash = accountSubGroup.getYtdAmountDr();
						 }
						 if(accountSubGroup2.getYtdAmountCr()!= null){
							 subGroupYtdBalanceCrForCash = accountSubGroup.getYtdAmountCr();
						 }
						 if(amountCr.compareTo(new BigDecimal(0))>0){
							 subGroupYtdBalanceCrForCash = subGroupYtdBalanceCrForCash.add(amountCr);
							 accountSubGroup2.setYtdAmountCr(subGroupYtdBalanceCrForCash);
						 }
						 crSubGroupAmountForCash = subGroupOpBalanceCrForCash.add(subGroupYtdBalanceCrForCash);
						 drSubGroupAmountForCash = subGroupOpBalanceDrForCash.add(subGroupYtdBalanceDrForCash);
								
								if(drSubGroupAmountForCash.compareTo(crSubGroupAmountForCash)>0){
									accountSubGroup2.setClBalanceDr(drSubGroupAmountForCash.subtract(crSubGroupAmountForCash));
									accountSubGroup2.setClBalanceCr(new BigDecimal(0.00));
								}else if(crSubGroupAmountForCash.compareTo(drSubGroupAmountForCash)>0){
									accountSubGroup2.setClBalanceCr(crSubGroupAmountForCash.subtract(drSubGroupAmountForCash));
									accountSubGroup2.setClBalanceDr(new BigDecimal(0.00));
								}else if(crSubGroupAmountForCash.compareTo(drSubGroupAmountForCash)==0){
									accountSubGroup2.setClBalanceCr(new BigDecimal(0.00));
									accountSubGroup2.setClBalanceDr(new BigDecimal(0.00));
								}
							 hbt.update(accountSubGroup2);
						//------------------------update account master-------------------------------------//
							 BigDecimal accYtdBalanceDr = new BigDecimal(0.0);
					 		BigDecimal accYtdBalanceCr = new  BigDecimal(0.0);
					 		BigDecimal accOpBalanceDr = new BigDecimal(0.0);
					 		BigDecimal accOpBalanceCr = new  BigDecimal(0.0);
					 		BigDecimal drAmountAccount = new BigDecimal(0.0);
					 		BigDecimal crAmountAccount = new BigDecimal(0.0);
						 FaMasAccount masAccount3= (FaMasAccount)hbt.load(FaMasAccount.class, cashAccountId);
						
						 if(masAccount3.getOpBalanceCr()!= null){
							 accOpBalanceCr =  masAccount3.getOpBalanceCr();
						 }
						 if(masAccount3.getOpBalanceDr()!= null){
							 accOpBalanceDr = masAccount3.getOpBalanceDr();
						 }
						if(masAccount3.getYtdAmountCr()!= null){
							accYtdBalanceCr = masAccount3.getYtdAmountCr();
						}
						if(masAccount3.getYtdAmountDr()!= null){
							accYtdBalanceDr = masAccount3.getYtdAmountDr();
						}


						if(amountCr.compareTo(new BigDecimal(0))>0){
							 accYtdBalanceCr = accYtdBalanceCr.add(amountCr);
							 masAccount3.setYtdAmountCr(accYtdBalanceCr);
						 }
						crAmountAccount = accOpBalanceCr.add(accYtdBalanceCr);
						drAmountAccount = accOpBalanceDr.add(accYtdBalanceDr);
						if(drAmountAccount.compareTo(crAmountAccount)>0){
							masAccount3.setClBalanceDr(drAmountAccount.subtract(crAmountAccount));
						    masAccount3.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountAccount.compareTo(drAmountAccount)>0){
							 masAccount3.setClBalanceCr(crAmountAccount.subtract(drAmountAccount));
							  masAccount3.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountAccount.compareTo(drAmountAccount)==0){
							masAccount3.setClBalanceCr(new BigDecimal(0.00));
					 		masAccount3.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(masAccount3);
				//-----------------------update account sub ledger==================================
					 if(box.getInt(SUB_LEDGER_CODE+ i)!=0){
						 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
						 
						 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE+ i));
						 if(subLed.getOpBalanceCr()!= null){
							 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
						 }
						 if(subLed.getOpBalanceDr()!= null){
							 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
						 }

						if(subLed.getYtdAmountCr()!= null){
							subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
						}
						if(subLed.getYtdAmountDr()!= null){
							subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
						}
						
						if(amountCr.compareTo(new BigDecimal(0))>0){
							 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(amountCr);
							 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);

						 }
						crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
						drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
						
						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed.setClBalanceCr(new BigDecimal(0.00));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed);
						 }	
							 
						}

					}
			}*/
			//---------------------------------------commented by anamika on 20th august----------------------------------
			/*if(accountListLengthForBank > 0 ){
				for (int j = 1; j <= accountListLengthForBank; j++) {
					FaVoucherDetails voucherDetailsObj = new FaVoucherDetails();
						if(!box.getString(AMOUNT_BANK + j).equals("") ){
							voucherDetailsObj.setVoucherHeader(faVoucherHeader);
						BigDecimal amountCr = new BigDecimal(box.getString(AMOUNT_BANK + j));
						voucherDetailsObj.setCrAmount(amountCr);

						int bankAccounId = 0;
						if (box.getInt("accountId"+ j) != 0) {
							voucherDetailsObj.setVoucherHeader(faVoucherHeader);
							FaMasAccount faMasAccount = new FaMasAccount();
							bankAccounId = box.getInt("accountId"+ j);
							faMasAccount.setId(bankAccounId);
							voucherDetailsObj.setAccount(faMasAccount);
						}
						if (box.getInt(SUB_LEDGER_CODE_BANK+ j) != 0) {
							FaMasSubLed faMasSubLed = new FaMasSubLed();
							faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+ j));
							voucherDetailsObj.setSubLed(faMasSubLed);
						}
						if (box.getInt(COST_CENTER_ID_BANK+ j) != 0) {
							MasCostCenter masCostCenter = new MasCostCenter();
							masCostCenter.setId(box.getInt(COST_CENTER_ID_BANK+ j));
							voucherDetailsObj.setCostCenter(masCostCenter);
						}
						if (!box.getString(ACCOUNT_NARRATION_BANK + j).equals("")) {
							voucherDetailsObj.setNarration(box.getString(ACCOUNT_NARRATION_BANK + j));
						}
						if (!box.getString(BANK_NAME + j).equals("")) {
							voucherDetailsObj.setBankName(box.getString(BANK_NAME + j));
						}
						if (!box.getString(CHEQUE_DATE + j).equals("")) {
							voucherDetailsObj.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE + j)));
						}
						if (!box.getString(CHEQUE_NO + j).equals("")) {
							voucherDetailsObj.setChequeNo(box.getString(CHEQUE_NO + j));
						}
						voucherDetailsObj.setReconcile("n");

						FaMasAccount acc = new FaMasAccount();
						acc.setId(box.getInt(ACCOUNT_ID));
						voucherDetailsObj.setAccountIdForReport(acc);
						hbt.save(voucherDetailsObj);
						//----------------------------update account group--------------------------------
						BigDecimal groupOPBalanceDrForBank = new BigDecimal(0.0);
						BigDecimal groupOPBalanceCrForBank = new BigDecimal(0.0);
						BigDecimal groupYTDBalanceDrForBank = new BigDecimal(0.0);
						BigDecimal groupYTDBalanceCrForBank = new BigDecimal(0.0);
						BigDecimal drAmountGroupForBank = new BigDecimal(0.0);
					    BigDecimal crAmountGroupForBank = new BigDecimal(0.0);
						
						FaMasAccountGroup accountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"+j));
						if(accountGroup.getOpBalanceDr()!= null){
							groupOPBalanceDrForBank =  accountGroup.getOpBalanceDr();
						}
					 	if(accountGroup.getOpBalanceCr()!= null){
					 		groupOPBalanceCrForBank = accountGroup.getOpBalanceCr();	
					 	}
						if(accountGroup.getYtdAmountCr()!= null){
							groupYTDBalanceCrForBank = accountGroup.getYtdAmountCr();
						}
						if(accountGroup.getYtdAmountDr() != null){
							groupYTDBalanceDrForBank = accountGroup.getYtdAmountDr();
						}
						if(amountCr.compareTo(new BigDecimal(0))>0){
							groupYTDBalanceCrForBank = groupYTDBalanceCrForBank.add(amountCr);
							accountGroup.setYtdAmountCr(groupYTDBalanceCrForBank);

						 }
						
						crAmountGroupForBank = groupOPBalanceCrForBank.add(groupYTDBalanceCrForBank);
						drAmountGroupForBank = groupOPBalanceDrForBank.add(groupYTDBalanceDrForBank);
						
						if(drAmountGroupForBank.compareTo(crAmountGroupForBank)>0){
							accountGroup.setClBalanceDr(drAmountGroupForBank.subtract(crAmountGroupForBank));
							accountGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountGroupForBank.compareTo(drAmountGroupForBank)>0){
							accountGroup.setClBalanceCr(crAmountGroupForBank.subtract(drAmountGroupForBank));
							accountGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountGroupForBank.compareTo(drAmountGroupForBank)==0){
							accountGroup.setClBalanceCr(new BigDecimal(0.00));
							accountGroup.setClBalanceDr(new BigDecimal(0.00));
						}
						 hbt.update(accountGroup);

						//-------------------------update account Sub group-------------------------------------------------
						 	BigDecimal  subGroupOPBalanceDrForBank = new BigDecimal(0.0);
							BigDecimal  subGroupOPBalanceCrForBank = new BigDecimal(0.0);
							BigDecimal  subGroupYTDBalanceDrForBank = new BigDecimal(0.0);
							BigDecimal  subGroupYTDBalanceCrForBank = new BigDecimal(0.0);
							BigDecimal drAmountSubGroupForBank = new BigDecimal(0.0);
						    BigDecimal crAmountSubGroupForBank = new BigDecimal(0.0);
						 
						 
						 FaMasAccountSubGroup subGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"+ j));
							 if(subGroup.getOpBalanceDr()!= null){
								 subGroupOPBalanceDrForBank =  subGroup.getOpBalanceDr();
							 }
							 if(subGroup.getOpBalanceCr()!= null){
								 subGroupOPBalanceCrForBank = subGroup.getOpBalanceCr();
							 }
							 if(subGroup.getYtdAmountDr()!= null){
								 subGroupYTDBalanceDrForBank = subGroup.getYtdAmountDr();
							 }
							 if(subGroup.getYtdAmountCr()!= null){
								 subGroupYTDBalanceCrForBank = subGroup.getYtdAmountCr();
							 }
							 if(amountCr.compareTo(new BigDecimal(0))>0){
								 subGroupYTDBalanceCrForBank = subGroupYTDBalanceCrForBank.add(amountCr);
								 subGroup.setYtdAmountCr(subGroupYTDBalanceCrForBank);

							 }
							 crAmountSubGroupForBank = subGroupOPBalanceCrForBank.add(subGroupYTDBalanceCrForBank);
							 drAmountSubGroupForBank = subGroupOPBalanceDrForBank.add(subGroupYTDBalanceDrForBank);
								
								if(drAmountSubGroupForBank.compareTo(crAmountSubGroupForBank)>0){
									subGroup.setClBalanceDr(drAmountSubGroupForBank.subtract(crAmountSubGroupForBank));
									subGroup.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubGroupForBank.compareTo(drAmountSubGroupForBank)>0){
									subGroup.setClBalanceCr(crAmountSubGroupForBank.subtract(drAmountSubGroupForBank));
									subGroup.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubGroupForBank.compareTo(drAmountSubGroupForBank)==0){
									subGroup.setClBalanceCr(new BigDecimal(0.00));
									subGroup.setClBalanceDr(new BigDecimal(0.00));
								}
								 hbt.update(subGroup);
			//------------------------update account master-------------------------------------//
								 BigDecimal  accountOPBalanceDrForBank = new BigDecimal(0.0);
								BigDecimal   accountOPBalanceCrForBank = new BigDecimal(0.0);
								 BigDecimal accYtdBalanceDr1 = new BigDecimal(0.0);
						 		BigDecimal accYtdBalanceCr1 = new  BigDecimal(0.0);
						 		BigDecimal drAmountAccountForBank = new BigDecimal(0.0);
							    BigDecimal crAmountAccountForBank = new BigDecimal(0.0);
							    
						 FaMasAccount masAcc= (FaMasAccount)hbt.load(FaMasAccount.class, bankAccounId);
						 if(masAcc.getOpBalanceCr()!= null){
							 accountOPBalanceCrForBank =  masAcc.getOpBalanceCr();
						 }
						 if(masAcc.getOpBalanceDr()!= null){
							 accountOPBalanceDrForBank = masAcc.getOpBalanceDr();
						 }

							if(masAcc.getYtdAmountCr()!= null){
								accYtdBalanceCr1 = masAcc.getYtdAmountCr();
							}
							if(masAcc.getYtdAmountDr()!= null){
								accYtdBalanceDr1 = masAcc.getYtdAmountDr();
							}
							if(amountCr.compareTo(new BigDecimal(0))>0){
								 accYtdBalanceCr1 = accYtdBalanceCr1.add(amountCr);
								 masAcc.setYtdAmountCr(accYtdBalanceCr1);

							 }
							crAmountAccountForBank = accountOPBalanceCrForBank.add(accYtdBalanceCr1);
							drAmountAccountForBank = accountOPBalanceDrForBank.add(accYtdBalanceDr1);
								
								if(drAmountAccountForBank.compareTo(crAmountAccountForBank)>0){
									masAcc.setClBalanceDr(drAmountAccountForBank.subtract(crAmountAccountForBank));
									masAcc.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountAccountForBank.compareTo(drAmountAccountForBank)>0){
									masAcc.setClBalanceCr(crAmountAccountForBank.subtract(drAmountAccountForBank));
									masAcc.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountAccountForBank.compareTo(drAmountAccountForBank)==0){
									masAcc.setClBalanceCr(new BigDecimal(0.00));
									masAcc.setClBalanceDr(new BigDecimal(0.00));
								}
							 hbt.update(masAcc);
							 
							//-----------------------update account sub ledger==================================
							 if(box.getInt(SUB_LEDGER_CODE_BANK+ j)!=0){
								 BigDecimal subLedOPBalanceCr = new BigDecimal(0.0);
								 BigDecimal subLedOPBalanceDr = new BigDecimal(0.0);
								 BigDecimal subLedYTDBalanceDr = new BigDecimal(0.0);
								 BigDecimal subLedYTDBalanceCr = new BigDecimal(0.0);
								 BigDecimal drAmountSubLedForBank = new BigDecimal(0.0);
							    BigDecimal crAmountSubLedForBank = new BigDecimal(0.0);
								 FaMasSubLed faSubLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ j));
								
								 if(faSubLed.getOpBalanceCr()!= null){
									 subLedOPBalanceCr =  faSubLed.getOpBalanceCr();
								 }
								 if(faSubLed.getOpBalanceDr()!= null){
									 subLedOPBalanceDr = faSubLed.getOpBalanceDr();
								 }

								if(faSubLed.getYtdAmountCr()!= null){
									subLedYTDBalanceCr = faSubLed.getYtdAmountCr();
								}
								if(faSubLed.getYtdAmountDr()!= null){
									subLedYTDBalanceDr = faSubLed.getYtdAmountDr();
								}
								if(amountCr.compareTo(new BigDecimal(0))>0){
									 subLedYTDBalanceCr = subLedYTDBalanceCr.add(amountCr);
									 faSubLed.setYtdAmountCr(subLedYTDBalanceCr);

								 }
								crAmountSubLedForBank = subLedOPBalanceCr.add(subLedYTDBalanceCr);
								drAmountSubLedForBank = subLedOPBalanceDr.add(subLedYTDBalanceDr);
									
									if(drAmountSubLedForBank.compareTo(crAmountSubLedForBank)>0){
										faSubLed.setClBalanceDr(drAmountSubLedForBank.subtract(crAmountSubLedForBank));
										faSubLed.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedForBank.compareTo(drAmountSubLedForBank)>0){
										faSubLed.setClBalanceCr(crAmountSubLedForBank.subtract(drAmountSubLedForBank));
										faSubLed.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedForBank.compareTo(drAmountSubLedForBank)==0){
										faSubLed.setClBalanceCr(new BigDecimal(0.00));
										faSubLed.setClBalanceDr(new BigDecimal(0.00));
									}
									 hbt.update(faSubLed);
								 }

						}
					}
				}
					*/
				vhId=faVoucherHeader.getId();
						tx.commit();
						saved = true;
						
					} catch (RuntimeException e) {
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					}

					Object[] selectedId = {1,2};
					accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
							.add(Restrictions.eq("FYear.Id", box.getInt("fYear"))).createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId)).list();
					
					

					List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
					masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
					map.put("masSchemeList", masSchemeList);
					
					costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
					
					map.put("costCenterList", costCenterList);
					
					map.put("mainAccountId", box.getInt(ACCOUNT_ID));
					map.put("accList", accList);
					paramMap.put("locationId", box.getInt("locationId"));
					paramMap.put("suffix", box.getString("fYearDesc"));
					paramMap.put("flag", "display");
					paramMap.put("prefix", "SV");
					paramMap.put("voucherType", "Sales");
					int voucherNo = generateVoucherNo(paramMap);
					map.put("voucherNo", ""+locationCode+"/"+yearDesc+"/"+voucherNo);
					map.put("vhId", vhId);
					map.put("saved", saved);
					map.put("voucherNo1",voucherNo1);
					return map;
			}
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> showPaymentVoucherJsp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String voucherNo1="";
			List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
			List<AccountMainTransac> accTransactionList = new ArrayList<AccountMainTransac>();
			List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
			List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
			List<MasWard>wardList=new ArrayList<MasWard>();
			List<Object[]> amountList = new ArrayList<Object[]>();
			Session session = (Session)getSession();
			Object[] selectedId = {"1","2"};
			
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "PV");
			paramMap.put("voucherType", "Payment");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y"))
								//.add(Restrictions.eq("ParentStatus", "n"))
					/* //.add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
						.createAlias("AccountSubGroup", "subGroup")
						.add(Restrictions.in("subGroup.Id", selectedId))*/.createAlias("AccountSubGroup", "subGroup")
						.add(Restrictions.in("subGroup.Flag", selectedId)).list();
			
			accTransactionList = session.createCriteria(AccountMainTransac.class).createAlias("Account", "acc")
								.add(Restrictions.eq("acc.Status", "y")).createAlias("acc.AccountSubGroup", "subGroup")
								.add(Restrictions.in("subGroup.Flag", selectedId)).add(Restrictions.gt("YtdAmountDr", new BigDecimal(0))).list();
			
			
			amountList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("header.Hospital", "hospital")
					.createAlias("header.FYear", "fYear").add(Restrictions.eq("fYear.Id", box.getInt("fYear")))
							.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("header.VoucherType", "PV"))
							.setProjection(Projections.projectionList().add(
								Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
								Projections.groupProperty("header.VoucherType"))).list();
			
			costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			wardList=session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("voucherNo", voucherNo);
			map.put("amountList", amountList);
			map.put("costCenterList", costCenterList);
			map.put("accTransactionList", accTransactionList);
			map.put("masSchemeList", masSchemeList);
			map.put("wardList",wardList);
			return map;
		}
		@SuppressWarnings("unchecked")
		public Map<String, Object> submitPaymentVoucher(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String locationCode="";
			String yearDesc="";
			List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
			List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session)getSession();
			Transaction tx = null;
			boolean saved = false;
			int vhId=0;
			int accountListLength = box.getInt("hiddenValueCharge");
			//int accountListLengthForBank = box.getInt("hiddenValueChargeForBank");
			int authLevel=0;
			if(box.getInt("authLevel")!=0){
				authLevel=box.getInt("authLevel");
			}
			
			try {
				tx = session.beginTransaction();
				FaVoucherHeader faVoucherHeader = new FaVoucherHeader();
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("locationId"));
				faVoucherHeader.setHospital(masHospital);
				faVoucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
				faVoucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
				faVoucherHeader.setNarration(box.getString(NARRATION));
				Users users = new Users();
				users.setId(box.getInt("changedBy"));
				faVoucherHeader.setLastChgBy(users);
				faVoucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				faVoucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
				faVoucherHeader.setVoucherType("PV");
				faVoucherHeader.setRejected("n");
				faVoucherHeader.setStatus("y");
				BigDecimal totalAmountCr = new BigDecimal(0.0);
				if (!box.getString(TOTAL_AMOUNT).equals("")) {
					totalAmountCr = new BigDecimal(box.getString(TOTAL_AMOUNT));
				}
				faVoucherHeader.setDrAmount(totalAmountCr);
				faVoucherHeader.setCrAmount(totalAmountCr);

				MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
				masStoreFinancial.setId(box.getInt("fyear"));
				faVoucherHeader.setFYear(masStoreFinancial);
				
				if (!box.getString(CHEQUE_DATE).equals("")) {
					faVoucherHeader.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE)));
				}
				if (!box.getString(CHEQUE_NO).equals("")) {
					faVoucherHeader.setChequeNo(box.getString(CHEQUE_NO));
				}
				if (box.getInt(COST_CENTER_ID) != 0) {
					MasCostCenter masCostCenter = new MasCostCenter();
					masCostCenter.setId(box.getInt(COST_CENTER_ID));
					faVoucherHeader.setCostCenter(masCostCenter);
				}
				if (box.getInt("schemeId") != 0) {
					MasScheme masScheme = new MasScheme();
					masScheme.setId(box.getInt("schemeId"));
					faVoucherHeader.setScheme(masScheme);
				}
				paramMap.put("locationId", box.getInt("locationId"));
				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "save");
				paramMap.put("prefix", "PV");
				paramMap.put("voucherType", "Payment");
				paramMap.put("financialYearId", box.getInt("fyear"));
				int voucherNo = generateVoucherNo(paramMap);
				
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class)
						.add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				faVoucherHeader.setVoucherNo("PV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
				
				FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
				faMasAccountSubGroup.setId(box.getInt("subGroupId"));
				/*faVoucherHeader.setAccountSubGroup(faMasAccountSubGroup);*/
				if(authLevel==1){
					faVoucherHeader.setAuthLevelOne("w");
				}else if(authLevel==2){
					faVoucherHeader.setAuthLevelOne("w");
					faVoucherHeader.setAuthLevelTwo("w");
					
				}else if(authLevel==3){
					faVoucherHeader.setAuthLevelOne("w");
					faVoucherHeader.setAuthLevelTwo("w");
					faVoucherHeader.setAuthLevelThree("w");
				}else if(authLevel==4){
					faVoucherHeader.setAuthLevelOne("w");
					faVoucherHeader.setAuthLevelTwo("w");
					faVoucherHeader.setAuthLevelThree("w");
					faVoucherHeader.setAuthLevelFour("w");
				}
				int wardId=0;
				if(box.getInt("wardId")!=0){
					wardId=(box.getInt("wardId"));
				}
				if(wardId!=0){
				MasWard masWard=new MasWard();
				masWard.setId(wardId);
				faVoucherHeader.setWard(masWard);
				}
				hbt.save(faVoucherHeader);
				map.put("voucherType", faVoucherHeader.getVoucherType());
				FaVoucherDetails voucherDetails = new FaVoucherDetails();
					FaMasAccount masAccount = new FaMasAccount();
					masAccount.setId(box.getInt(ACCOUNT_ID));
					voucherDetails.setAccount(masAccount);
					voucherDetails.setCrAmount(totalAmountCr);
					voucherDetails.setVoucherHeader(faVoucherHeader);
					voucherDetails.setNarration(box.getString(NARRATION));
					
					//------------------------------code for account id report--------------------------------------
					if(accountListLength > 0){
						if (box.getInt("accountId1") != 0) {
							FaMasAccount account = new FaMasAccount();
							account.setId(box.getInt("accountId1") );
							voucherDetails.setAccountIdForReport(account);
							voucherDetails.setAdvAcc(account);
						}
						
						if (box.getInt(SUB_LEDGER_CODE+"1") != 0) {
							FaMasSubLed subLed = new FaMasSubLed();
							subLed.setId(box.getInt(SUB_LEDGER_CODE+"1"));
							voucherDetails.setSubLedIdForReport(subLed);
						}
					}
					//------------------------------code for Sub Ledger id report-------commented by anamika on 20th august-------------------------------
				/*	if(accountListLengthForBank > 0){
						if (box.getInt("accountId1") != 0) {
							FaMasAccount account = new FaMasAccount();
							account.setId(box.getInt("accountId1") );
							voucherDetails.setAccountIdForReport(account);
						}
						if (box.getInt(SUB_LEDGER_CODE_BANK+"1") != 0) {
							FaMasSubLed subLed = new FaMasSubLed();
							subLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+"1"));
							voucherDetails.setSubLedIdForReport(subLed);
						}
					}*/
					hbt.save(voucherDetails);
					int subLedId=0;
					updateTransaction(subLedId, box.getInt(ACCOUNT_ID), box.getInt("fyear"), box.getInt("locationId"), ""+totalAmountCr, "0.00");
					
					
					//-------------------------update account group-------------------------------------------------
					/*BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drGroupAmount = new BigDecimal(0.0);
					BigDecimal crGroupAmount = new BigDecimal(0.0);
					 FaMasAccountGroup faMasAccountGroup2 = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"));
					 if(faMasAccountGroup2.getOpBalanceDr() != null){
						 groupOpBalanceDr =  faMasAccountGroup2.getOpBalanceDr();
					 }
					 if(faMasAccountGroup2.getOpBalanceCr() != null){
						 groupOpBalanceCr = faMasAccountGroup2.getOpBalanceCr();
					 }
					 if(faMasAccountGroup2.getYtdAmountDr() != null){
						 groupYtdBalanceDr = faMasAccountGroup2.getYtdAmountDr();
					 }
					 if(faMasAccountGroup2.getYtdAmountCr() != null){
						 groupYtdBalanceCr = faMasAccountGroup2.getYtdAmountCr();
					 }
					 if(totalAmountCr.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceCr = groupYtdBalanceCr.add(totalAmountCr);
						 faMasAccountGroup2.setYtdAmountCr(groupYtdBalanceCr);

					 }
					 drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
					 crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					 if(drGroupAmount.compareTo(crGroupAmount)>0){
						 faMasAccountGroup2.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					     faMasAccountGroup2.setClBalanceCr(new BigDecimal(0.00));
					 }else if(crGroupAmount.compareTo(drGroupAmount)>0){
						 faMasAccountGroup2.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
				 		 faMasAccountGroup2.setClBalanceDr(new BigDecimal(0.00));
					 }else if(drGroupAmount.compareTo(crGroupAmount)==0){
						 faMasAccountGroup2.setClBalanceCr(new BigDecimal(0.00));
						 faMasAccountGroup2.setClBalanceDr(new BigDecimal(0.00));
					 }
				 	hbt.update(faMasAccountGroup2);
				 	//-------------------------update account Sub group-------------------------------------------------
					BigDecimal subGroupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal subGroupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal subGroupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal subGroupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drSubGroupAmount = new BigDecimal(0.0);
					BigDecimal crSubGroupAmount = new BigDecimal(0.0);
				 FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"));
					 if(accountSubGroup.getOpBalanceDr()!= null){
						 subGroupOpBalanceDr =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup.getOpBalanceCr()!= null){
						 subGroupOpBalanceCr = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
					 }
					 if(totalAmountCr.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(totalAmountCr);
						 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);

					 }
					 drSubGroupAmount = subGroupOpBalanceDr.add(subGroupYtdBalanceDr);
					 crSubGroupAmount = subGroupOpBalanceCr.add(subGroupYtdBalanceCr);
					 
					 if(drSubGroupAmount.compareTo(crSubGroupAmount)>0){
						 accountSubGroup.setClBalanceDr(drSubGroupAmount.subtract(crSubGroupAmount));
						 accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
					 }else if(crSubGroupAmount.compareTo(drSubGroupAmount)>0){
						 accountSubGroup.setClBalanceCr(crSubGroupAmount.subtract(drSubGroupAmount));
						 accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					 }else if(drSubGroupAmount.compareTo(crSubGroupAmount)==0){
						 accountSubGroup.setClBalanceCr(new BigDecimal(0.00));
						 accountSubGroup.setClBalanceDr(new BigDecimal(0.00));
					 }
				 	hbt.update(accountSubGroup);

		//-------------------------update account master-------------------------------------------------
			 	BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
		 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
		 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
		 		BigDecimal drAccountAmount = new BigDecimal(0.0);
		 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
		 		
		 		FaMasAccount masAccount2 = (FaMasAccount)hbt.load(FaMasAccount.class, box.getInt(ACCOUNT_ID));
		 		if(masAccount2.getOpBalanceDr()!= null){
		 			accountOpBalanceDr =  masAccount2.getOpBalanceDr();
		 		}
		 		if(masAccount2.getOpBalanceCr()!= null){
		 			accountOpBalanceCr = masAccount2.getOpBalanceCr();
		 		}

		 		 if(masAccount2.getYtdAmountDr() != null){
		 			 accountYtdBalanceDr = masAccount2.getYtdAmountDr();
		 		 }
		 		 if(masAccount2.getYtdAmountCr() != null){
		 			accountYtdBalanceCr = masAccount2.getYtdAmountCr();
		 		 }
		 		if(totalAmountCr.compareTo(new BigDecimal(0))>0){
					 accountYtdBalanceCr = accountYtdBalanceCr.add(totalAmountCr);
					 masAccount2.setYtdAmountCr(accountYtdBalanceCr);

				 }
		 		drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
		 		crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
				 
				 if(drAccountAmount.compareTo(crAccountAmount)>0){
					 masAccount2.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
					 masAccount2.setClBalanceCr(new BigDecimal(0.00));
				 }else if(crAccountAmount.compareTo(drAccountAmount)>0){
					 masAccount2.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
					 masAccount2.setClBalanceDr(new BigDecimal(0.00));
				 }else if(drAccountAmount.compareTo(crAccountAmount)==0){
					 masAccount2.setClBalanceCr(new BigDecimal(0.00));
					 masAccount2.setClBalanceDr(new BigDecimal(0.00));
				 }

		 	hbt.update(masAccount2);*/

			//--------------------------------------------------------------
			if(accountListLength > 0){
				for (int i = 1; i <= accountListLength; i++) {
					FaVoucherDetails faVoucherDetails = new FaVoucherDetails();
						if(!box.getString(AMOUNT+i).equals("") ){
							faVoucherDetails.setVoucherHeader(faVoucherHeader);
						BigDecimal amountDr = new BigDecimal(box.getString(AMOUNT+ i));
						faVoucherDetails.setDrAmount(amountDr);
						int cashAccountId = 0;
						if (box.getInt("accountId"+ i) != 0) {
							FaMasAccount faMasAccount = new FaMasAccount();
							cashAccountId = box.getInt("accountId"+ i);
							faMasAccount.setId(cashAccountId);
							faVoucherDetails.setAccount(faMasAccount);
						}

						if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
							FaMasSubLed faMasSubLed = new FaMasSubLed();
							faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
							faVoucherDetails.setSubLed(faMasSubLed);
						}
						
						if (box.getInt(COST_CENTER_ID+ i) != 0) {
							MasCostCenter masCostCenter = new MasCostCenter();
							masCostCenter.setId(box.getInt(COST_CENTER_ID+ i));
							faVoucherDetails.setCostCenter(masCostCenter);
						}
						if (!box.getString(ACCOUNT_NARRATION + i).equals("")) {
							faVoucherDetails.setNarration(box.getString(ACCOUNT_NARRATION + i));
						}
						faVoucherDetails.setReconcile("n");	

						hbt.save(faVoucherDetails);
						updateTransaction(box.getInt(SUB_LEDGER_CODE+ i), box.getInt("accountId"+ i), box.getInt("fyear"), box.getInt("locationId"),"0.00", ""+amountDr );

					}
				}
			}			
/*
	//-----------------------------update account group---------------------------------------------------------------//
						BigDecimal groupOpBalanceDrCash = new BigDecimal(0.0);
						BigDecimal groupOpBalanceCrCash = new BigDecimal(0.0);
						BigDecimal groupYtdBalanceDrCash = new BigDecimal(0.0);
						BigDecimal groupYtdBalanceCrCash = new BigDecimal(0.0);
						BigDecimal drGroupAmountForCash = new BigDecimal(0.0);
						BigDecimal crGroupAmountForCash = new BigDecimal(0.0);
				FaMasAccountGroup masAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"+ i));
						if(masAccountGroup.getOpBalanceDr()!= null){
							groupOpBalanceDrCash =  masAccountGroup.getOpBalanceDr();
						}
						if(masAccountGroup.getOpBalanceCr() != null){
							groupOpBalanceCrCash = masAccountGroup.getOpBalanceCr();
						}
						if(masAccountGroup.getYtdAmountCr() != null){
							groupYtdBalanceCrCash = masAccountGroup.getYtdAmountCr();
						}
						if(masAccountGroup.getYtdAmountDr() != null){
							groupYtdBalanceDrCash = masAccountGroup.getYtdAmountDr();
						}
						if(amountDr.compareTo(new BigDecimal(0))>0){
							groupYtdBalanceDrCash = groupYtdBalanceDrCash.add(amountDr);
							 masAccountGroup.setYtdAmountDr(groupYtdBalanceDrCash);
						 }
						drGroupAmountForCash = groupOpBalanceDrCash.add(groupYtdBalanceDrCash);
						crGroupAmountForCash = groupOpBalanceCrCash.add(groupYtdBalanceCrCash);
						
						if(drGroupAmountForCash.compareTo(crGroupAmountForCash)>0){
							masAccountGroup.setClBalanceDr(drGroupAmountForCash.subtract(crGroupAmountForCash));
							masAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						 }else if(crGroupAmountForCash.compareTo(drGroupAmountForCash)>0){
							 masAccountGroup.setClBalanceCr(crGroupAmountForCash.subtract(drGroupAmountForCash));
							 masAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						 }else if(drGroupAmountForCash.compareTo(crGroupAmountForCash)==0){
							 masAccountGroup.setClBalanceCr(new BigDecimal(0.00));
							 masAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						 }
						
					 hbt.update(masAccountGroup);
	//-------------------------update account Sub group------------------------------------------------------------------
					 	BigDecimal subGroupOpBalanceDrCash = new BigDecimal(0.0);
						BigDecimal subGroupOpBalanceCrCash = new BigDecimal(0.0);
						BigDecimal subGroupYtdBalanceDrCash = new BigDecimal(0.0);
						BigDecimal subGroupYtdBalanceCrCash = new BigDecimal(0.0);
						BigDecimal drSubGroupAmountForCash = new BigDecimal(0.0);
						BigDecimal crSubGroupAmountForCash = new BigDecimal(0.0);
					 FaMasAccountSubGroup accSubGroup1 = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"+ i));
						 if(accSubGroup1.getOpBalanceDr()!= null){
							 subGroupOpBalanceDrCash =  accSubGroup1.getOpBalanceDr();
						 }
						 if(accSubGroup1.getOpBalanceCr()!= null){
							 subGroupOpBalanceCrCash = accSubGroup1.getOpBalanceCr();
						 }
						 if(accSubGroup1.getYtdAmountDr()!= null){
							 subGroupYtdBalanceDrCash = accSubGroup1.getYtdAmountDr();
						 }
						 if(accSubGroup1.getYtdAmountCr()!= null){
							 subGroupYtdBalanceCrCash = accSubGroup1.getYtdAmountCr();
						 }
						 if(amountDr.compareTo(new BigDecimal(0))>0){
							 subGroupYtdBalanceDrCash = subGroupYtdBalanceDrCash.add(amountDr);
							 accSubGroup1.setYtdAmountDr(subGroupYtdBalanceDrCash);
						 }
						 drSubGroupAmountForCash = subGroupOpBalanceDrCash.add(subGroupYtdBalanceDrCash);
						 crSubGroupAmountForCash = subGroupOpBalanceCrCash.add(subGroupYtdBalanceCrCash);
							
							if(drSubGroupAmountForCash.compareTo(crSubGroupAmountForCash)>0){
								accSubGroup1.setClBalanceDr(drSubGroupAmountForCash.subtract(crSubGroupAmountForCash));
								accSubGroup1.setClBalanceCr(new BigDecimal(0.00));
							 }else if(crSubGroupAmountForCash.compareTo(drSubGroupAmountForCash)>0){
								 accSubGroup1.setClBalanceCr(crSubGroupAmountForCash.subtract(drSubGroupAmountForCash));
								 accSubGroup1.setClBalanceDr(new BigDecimal(0.00));
							 }else if(drSubGroupAmountForCash.compareTo(crSubGroupAmountForCash)==0){
								 accSubGroup1.setClBalanceCr(new BigDecimal(0.00));
								 accSubGroup1.setClBalanceDr(new BigDecimal(0.00));
							 }
							 hbt.update(accSubGroup1);

	//------------------------update account master-----------------------------------------------------------------------//
					 	BigDecimal accYtdBalanceDr = new BigDecimal(0.0);
				 		BigDecimal accYtdBalanceCr = new  BigDecimal(0.0);
				 		BigDecimal accountOpBalanceDrCash = new BigDecimal(0.0);
				 		BigDecimal accountOpBalanceCrCash = new  BigDecimal(0.0);
				 		BigDecimal drAccountAmountForCash = new BigDecimal(0.0);
				 		BigDecimal crAccountAmountForCash = new  BigDecimal(0.0);
						 FaMasAccount masAccount3= (FaMasAccount)hbt.load(FaMasAccount.class, cashAccountId);
						 
						 if(masAccount3.getOpBalanceCr()!= null){
							 accountOpBalanceCrCash =  masAccount3.getOpBalanceCr();
						 }
						 if(masAccount3.getOpBalanceDr()!= null){
							 accountOpBalanceDrCash = masAccount3.getOpBalanceDr();
						 }

							if(masAccount3.getYtdAmountCr()!= null){
								accYtdBalanceCr = masAccount3.getYtdAmountCr();
							}
							if(masAccount3.getYtdAmountDr()!= null){
								accYtdBalanceDr = masAccount3.getYtdAmountDr();
							}
							 if(amountDr.compareTo(new BigDecimal(0))>0){
								 accYtdBalanceDr = accYtdBalanceDr.add(amountDr);
								 masAccount3.setYtdAmountDr(accYtdBalanceDr);
							 }
							 drAccountAmountForCash = accountOpBalanceDrCash.add(accYtdBalanceDr);
							 crAccountAmountForCash = accountOpBalanceCrCash.add(accYtdBalanceCr);
								
								if(drAccountAmountForCash.compareTo(crAccountAmountForCash)>0){
									masAccount3.setClBalanceDr(drAccountAmountForCash.subtract(crAccountAmountForCash));
									masAccount3.setClBalanceCr(new BigDecimal(0.00));
								 }else if(crAccountAmountForCash.compareTo(drAccountAmountForCash)>0){
									 masAccount3.setClBalanceCr(crAccountAmountForCash.subtract(drAccountAmountForCash));
									 masAccount3.setClBalanceDr(new BigDecimal(0.00));
								 }else if(drAccountAmountForCash.compareTo(crAccountAmountForCash)==0){
									 masAccount3.setClBalanceCr(new BigDecimal(0.00));
									 masAccount3.setClBalanceDr(new BigDecimal(0.00));
								 }
							 hbt.update(masAccount3);
	//-----------------------update account sub ledger==================================
						 if(box.getInt(SUB_LEDGER_CODE+ i)!=0){
							 BigDecimal subLedgerOpBalanceCr = new BigDecimal(0.0);
							 BigDecimal subLedgerOpBalanceDr = new BigDecimal(0.0);
							 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
							 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
							 BigDecimal drSubLedAmountForCash = new BigDecimal(0.0);
							 BigDecimal crSubLedAmountForCash = new BigDecimal(0.0);
							 
							 
							 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE+ i));
							 if(subLed.getOpBalanceCr()!= null){
								 subLedgerOpBalanceCr =  subLed.getOpBalanceCr();
							 }
							 if(subLed.getOpBalanceDr()!= null){
								 subLedgerOpBalanceDr = subLed.getOpBalanceDr();
							 }

								if(subLed.getYtdAmountDr()!= null){
									subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
								}
								if(subLed.getYtdAmountCr()!= null){
									subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
								}
								if(amountDr.compareTo(new BigDecimal(0))>0){
									 subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(amountDr);
									 subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
								 }
								
								drSubLedAmountForCash = subLedgerOpBalanceDr.add(subLedgerYTDBalanceDr);
								crSubLedAmountForCash = subLedgerOpBalanceCr.add(subLedgerYTDBalanceCr);
									
									if(drSubLedAmountForCash.compareTo(crSubLedAmountForCash)>0){
										subLed.setClBalanceDr(drSubLedAmountForCash.subtract(crSubLedAmountForCash));
										subLed.setClBalanceCr(new BigDecimal(0.00));
									 }else if(crSubLedAmountForCash.compareTo(drSubLedAmountForCash)>0){
										 subLed.setClBalanceCr(crSubLedAmountForCash.subtract(drSubLedAmountForCash));
										 subLed.setClBalanceDr(new BigDecimal(0.00));
									 }else if(drSubLedAmountForCash.compareTo(crSubLedAmountForCash)==0){
										 subLed.setClBalanceCr(new BigDecimal(0.00));
										 subLed.setClBalanceDr(new BigDecimal(0.00));
									 }
								 hbt.update(subLed);
							 }	 
						}

					}
			}
			*/

			
			/*if(accountListLengthForBank > 0 ){
				for (int j = 1; j <= accountListLengthForBank; j++) {
					FaVoucherDetails voucherDetailsObj = new FaVoucherDetails();
						if(!box.getString(AMOUNT_BANK + j).equals("") ){
							voucherDetailsObj.setVoucherHeader(faVoucherHeader);
						BigDecimal amountDr = new BigDecimal(box.getString(AMOUNT_BANK + j));
						voucherDetailsObj.setDrAmount(amountDr);
						int bankAccountId = 0;
						if (box.getInt("accountId"+ j) != 0) {
							voucherDetailsObj.setVoucherHeader(faVoucherHeader);
							FaMasAccount faMasAccount = new FaMasAccount();
							bankAccountId =box.getInt("accountId"+ j); 
							faMasAccount.setId(bankAccountId);
							voucherDetailsObj.setAccount(faMasAccount);
						}
						if (box.getInt(SUB_LEDGER_CODE_BANK+ j) != 0) {
							FaMasSubLed faMasSubLed = new FaMasSubLed();
							faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE_BANK+ j));
							voucherDetailsObj.setSubLed(faMasSubLed);
						}
						if (box.getInt(COST_CENTER_ID_BANK+ j) != 0) {
							MasCostCenter masCostCenter = new MasCostCenter();
							masCostCenter.setId(box.getInt(COST_CENTER_ID_BANK+ j));
							voucherDetailsObj.setCostCenter(masCostCenter);
						}
						if (!box.getString(ACCOUNT_NARRATION_BANK + j).equals("")) {
							voucherDetailsObj.setNarration(box.getString(ACCOUNT_NARRATION_BANK + j));
						}
						if (!box.getString(BANK_NAME + j).equals("")) {
							voucherDetailsObj.setBankName(box.getString(BANK_NAME + j));
						}
						if (!box.getString(CHEQUE_DATE + j).equals("")) {
							voucherDetailsObj.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE + j)));
						}
						if (!box.getString(CHEQUE_NO + j).equals("")) {
							voucherDetailsObj.setChequeNo(box.getString(CHEQUE_NO + j));
						}
						voucherDetailsObj.setReconcile("n");
						FaMasAccount acc = new FaMasAccount();
						acc.setId(box.getInt(ACCOUNT_ID));
						voucherDetailsObj.setAccountIdForReport(acc);

						hbt.save(voucherDetailsObj);
						//-----------------------------update account group---------------------------------------------------------------//
						BigDecimal groupOpBalanceDrBank = new BigDecimal(0.0);
						BigDecimal groupOpBalanceCrBank = new BigDecimal(0.0);
						BigDecimal groupYtdBalanceDrBank = new BigDecimal(0.0);
						BigDecimal groupYtdBalanceCrBank = new BigDecimal(0.0);
						BigDecimal drGroupAmountForBank = new BigDecimal(0.0);
						BigDecimal crGroupAmountForBank = new BigDecimal(0.0);
						FaMasAccountGroup accountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, box.getInt("groupId"+ j));
								if(accountGroup.getOpBalanceDr()!= null){
									groupOpBalanceDrBank =  accountGroup.getOpBalanceDr();
								}
								if(accountGroup.getOpBalanceCr() != null){
									groupOpBalanceCrBank = accountGroup.getOpBalanceCr();
								}
								if(accountGroup.getYtdAmountCr() != null){
									groupYtdBalanceCrBank = accountGroup.getYtdAmountCr();
								}
								if(accountGroup.getYtdAmountDr() != null){
									groupYtdBalanceDrBank = accountGroup.getYtdAmountDr();
								}
								if(amountDr.compareTo(new BigDecimal(0))>0){
									groupYtdBalanceDrBank = groupYtdBalanceDrBank.add(amountDr);
									accountGroup.setYtdAmountDr(groupYtdBalanceDrBank);
								 }
								drGroupAmountForBank = groupOpBalanceDrBank.add(groupYtdBalanceDrBank);
								crGroupAmountForBank = groupOpBalanceCrBank.add(groupYtdBalanceCrBank);
									
									if(drGroupAmountForBank.compareTo(crGroupAmountForBank)>0){
										accountGroup.setClBalanceDr(drGroupAmountForBank.subtract(crGroupAmountForBank));
										accountGroup.setClBalanceCr(new BigDecimal(0.00));
									 }else if(crGroupAmountForBank.compareTo(drGroupAmountForBank)>0){
										 accountGroup.setClBalanceCr(crGroupAmountForBank.subtract(drGroupAmountForBank));
										 accountGroup.setClBalanceDr(new BigDecimal(0.00));
									 }else if(drGroupAmountForBank.compareTo(crGroupAmountForBank)==0){
										 accountGroup.setClBalanceCr(new BigDecimal(0.00));
										 accountGroup.setClBalanceDr(new BigDecimal(0.00));
									 }

							 hbt.update(accountGroup);
			//-------------------------update account Sub group------------------------------------------------------------------
							 	BigDecimal subGroupOpBalanceDrBank = new BigDecimal(0.0);
								BigDecimal subGroupOpBalanceCrBank = new BigDecimal(0.0);
								BigDecimal subGroupYtdBalanceDrBank = new BigDecimal(0.0);
								BigDecimal subGroupYtdBalanceCrBank = new BigDecimal(0.0);
								BigDecimal drSubGroupAmountForBank = new BigDecimal(0.0);
								BigDecimal crSubGroupAmountForBank = new BigDecimal(0.0);
							 FaMasAccountSubGroup subGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, box.getInt("subGroupId"+ j));
								 if(subGroup.getOpBalanceDr()!= null){
									 subGroupOpBalanceDrBank =  subGroup.getOpBalanceDr();
								 }
								 if(subGroup.getOpBalanceCr()!= null){
									 subGroupOpBalanceCrBank = subGroup.getOpBalanceCr();
								 }
								 if(subGroup.getYtdAmountDr()!= null){
									 subGroupYtdBalanceDrBank = subGroup.getYtdAmountDr();
								 }
								 if(subGroup.getYtdAmountCr()!= null){
									 subGroupYtdBalanceCrBank = subGroup.getYtdAmountCr();
								 }
								 if(amountDr.compareTo(new BigDecimal(0))>0){
									 subGroupYtdBalanceDrBank = subGroupYtdBalanceDrBank.add(amountDr);
									 subGroup.setYtdAmountDr(subGroupYtdBalanceDrBank);
								 }
								 drSubGroupAmountForBank = subGroupOpBalanceDrBank.add(subGroupYtdBalanceDrBank);
								 crSubGroupAmountForBank = subGroupOpBalanceCrBank.add(subGroupYtdBalanceCrBank);
									
									if(drSubGroupAmountForBank.compareTo(crSubGroupAmountForBank)>0){
										subGroup.setClBalanceDr(drSubGroupAmountForBank.subtract(crSubGroupAmountForBank));
										subGroup.setClBalanceCr(new BigDecimal(0.00));
									 }else if(crSubGroupAmountForBank.compareTo(drSubGroupAmountForBank)>0){
										 subGroup.setClBalanceCr(crSubGroupAmountForBank.subtract(drSubGroupAmountForBank));
										 subGroup.setClBalanceDr(new BigDecimal(0.00));
									 }else if(drSubGroupAmountForBank.compareTo(crSubGroupAmountForBank)==0){
										 subGroup.setClBalanceCr(new BigDecimal(0.00));
										 subGroup.setClBalanceDr(new BigDecimal(0.00));
									 }

									 hbt.update(subGroup);

			//------------------------update account master-----------------------------------------------------------------------//
								 BigDecimal accountOpBalanceDrBank = new BigDecimal(0.0);
						 		 BigDecimal accountOpBalanceCrBank = new  BigDecimal(0.0);
								 BigDecimal accountYtdBalanceDr1 = new BigDecimal(0.0);
						 		 BigDecimal accountYtdBalanceCr1 = new  BigDecimal(0.0);
						 		 BigDecimal drAccountAmountForBank = new BigDecimal(0.0);
						 		 BigDecimal crAccountAmountForBank = new  BigDecimal(0.0);
								 FaMasAccount accountMaster= (FaMasAccount)hbt.load(FaMasAccount.class, bankAccountId);
								 if(accountMaster.getOpBalanceCr()!= null){
									 accountOpBalanceCrBank =  accountMaster.getOpBalanceCr();
								 }
								 if(accountMaster.getOpBalanceDr()!= null){
									 accountOpBalanceDrBank = accountMaster.getOpBalanceDr();
								 }
								if(accountMaster.getYtdAmountDr()!= null){
									accountYtdBalanceDr1 = accountMaster.getYtdAmountDr();
								}
								if(accountMaster.getYtdAmountCr()!= null){
									accountYtdBalanceCr1 = accountMaster.getYtdAmountCr();
								}
								 if(amountDr.compareTo(new BigDecimal(0))>0){
									 accountYtdBalanceDr1 = accountYtdBalanceDr1.add(amountDr);
									 accountMaster.setYtdAmountDr(accountYtdBalanceDr1);
								 }
								 drAccountAmountForBank = accountOpBalanceDrBank.add(accountYtdBalanceDr1);
								 crAccountAmountForBank = accountOpBalanceCrBank.add(accountYtdBalanceCr1);
									
								if(drAccountAmountForBank.compareTo(crAccountAmountForBank)>0){
									accountMaster.setClBalanceDr(drAccountAmountForBank.subtract(crAccountAmountForBank));
									accountMaster.setClBalanceCr(new BigDecimal(0.00));
								 }else if(crAccountAmountForBank.compareTo(drAccountAmountForBank)>0){
									 accountMaster.setClBalanceCr(crAccountAmountForBank.subtract(drAccountAmountForBank));
									 accountMaster.setClBalanceDr(new BigDecimal(0.00));
								 }else if(drAccountAmountForBank.compareTo(crAccountAmountForBank)==0){
									 accountMaster.setClBalanceCr(new BigDecimal(0.00));
									 accountMaster.setClBalanceDr(new BigDecimal(0.00));
								 }
								 hbt.update(accountMaster);
									//-----------------------update account sub ledger==================================
						if(box.getInt(SUB_LEDGER_CODE_BANK+ j)!=0){
							BigDecimal subLedgerOpBalanceCrForBank = new BigDecimal(0.0);
							BigDecimal subLedgerOpBalanceDrForBank = new BigDecimal(0.0);
							BigDecimal subLedgerYTDBalanceDrForBank = new BigDecimal(0.0);
							BigDecimal subLedgerYTDBalanceCrForBank = new BigDecimal(0.0);
							BigDecimal drSubLedAmountForBank = new BigDecimal(0.0);
							BigDecimal crSubLedAmountForBank = new BigDecimal(0.0);
							 
							 FaMasSubLed faSubLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ j));
							 if(faSubLed.getOpBalanceCr()!= null){
								 subLedgerOpBalanceCrForBank =  faSubLed.getOpBalanceCr();
							 }
							 if(faSubLed.getOpBalanceDr()!= null){
								 subLedgerOpBalanceDrForBank = faSubLed.getOpBalanceDr();
							 }

							if(faSubLed.getYtdAmountDr()!= null){
								subLedgerYTDBalanceDrForBank = faSubLed.getYtdAmountDr();
							}
							if(faSubLed.getYtdAmountCr()!= null){
								subLedgerYTDBalanceCrForBank = faSubLed.getYtdAmountCr();
							}
							if(amountDr.compareTo(new BigDecimal(0))>0){
								subLedgerYTDBalanceDrForBank = subLedgerYTDBalanceDrForBank.add(amountDr);
								 faSubLed.setYtdAmountDr(subLedgerYTDBalanceDrForBank);
							 }
								drSubLedAmountForBank = subLedgerOpBalanceDrForBank.add(subLedgerYTDBalanceDrForBank);
								crSubLedAmountForBank = subLedgerOpBalanceCrForBank.add(subLedgerYTDBalanceCrForBank);
									
								if(drSubLedAmountForBank.compareTo(crSubLedAmountForBank)>0){
									faSubLed.setClBalanceDr(drSubLedAmountForBank.subtract(crSubLedAmountForBank));
									faSubLed.setClBalanceCr(new BigDecimal(0.00));
								 }else if(crSubLedAmountForBank.compareTo(drSubLedAmountForBank)>0){
									 faSubLed.setClBalanceCr(crSubLedAmountForBank.subtract(drSubLedAmountForBank));
									 faSubLed.setClBalanceDr(new BigDecimal(0.00));
								 }else if(drSubLedAmountForBank.compareTo(crSubLedAmountForBank)==0){
									 faSubLed.setClBalanceCr(new BigDecimal(0.00));
									 faSubLed.setClBalanceDr(new BigDecimal(0.00));
								 }
										 
										 hbt.update(faSubLed);
							} 
						}
					}
			}*/			vhId=faVoucherHeader.getId();
						tx.commit();
						saved = true;
					} catch (RuntimeException e) {
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					}
			Object[] selectedId = {1,2};
			accList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("ParentStatus", "n"))
							.add(Restrictions.eq("FYear.Id", box.getInt("fyear"))).createAlias("AccountSubGroup", "subGroup").add(Restrictions.in("subGroup.Id", selectedId)).list();
			

			List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
			masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("masSchemeList", masSchemeList);
			
			costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("costCenterList", costCenterList);
			map.put("accList", accList);
			paramMap.put("locationId", box.getInt("locationId"));
		 	paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "PV");
			paramMap.put("voucherType", "Payment");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", "PV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
			map.put("saved", saved);
			map.put("vhId", vhId);
			System.out.println(vhId);
			map.put("mainAccountId", box.getInt(ACCOUNT_ID));
			return map;
		}
	
		@SuppressWarnings("unchecked")
		public Map<String, Object> showAccountBalance(int accountId) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
			Session session = (Session)getSession();
			accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
			map.put("accountList", accountList);

			return map;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> showJournalVoucherJsp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
			List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
			List<Object[]>amountList = new ArrayList<Object[]>();
			List<MasWard>wardList=new ArrayList<MasWard>();
			Session session = (Session)getSession();
			costCenterList = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			masSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			System.out.println("fyear=="+box.getInt("fYear"));
			System.out.println("hospitalId=="+box.getInt("hospitalId"));
			amountList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("header.Hospital", "hospital")
								.createAlias("header.FYear", "fYear").add(Restrictions.eq("fYear.Id", box.getInt("fYear")))
										.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("header.VoucherType", "JV"))
										.setProjection(Projections.projectionList().add(
											Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
											Projections.groupProperty("header.VoucherType"))).list();
		/*	String qry = "select a.voucher_type, sum(b.dr_amount) as dr, sum(b.cr_amount) as cr from fa_voucher_header a,  fa_voucher_details b  "
					+ " where a.hospital_id = "+box.getInt("hospitalId")+" and f_year_id = "+box.getInt("fYear")+" and voucher_type = 'JV' and  a.voucher_header_id = b.voucher_header_id   group by  a.voucher_type";
			
			amountList = session.createSQLQuery(qry).list();
			if(amountList.size()>0){
				for(Object[] obj : amountList){
					BigDecimal totalAmountDr = new BigDecimal(0);
					BigDecimal totalAmountCr = new BigDecimal(0);
					totalAmountDr = (BigDecimal)obj[1];
					System.out.println("totalAmountDr=="+totalAmountDr);
					totalAmountCr = (BigDecimal)obj[2];
					System.out.println("totalAmountCr=="+totalAmountCr);
				}
			}*/
			wardList=session.createCriteria(MasWard.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			paramMap.put("suffix", box.getString("fYearDesc"));
			paramMap.put("locationId", box.getInt("locationId"));
			paramMap.put("flag", "display");
			paramMap.put("prefix", "JV");
			paramMap.put("voucherType", "Journal");
			int voucherNo = generateVoucherNo(paramMap);
			map.put("voucherNo", voucherNo);
			map.put("costCenterList", costCenterList);
			map.put("masSchemeList", masSchemeList);
			map.put("amountList", amountList);
			map.put("wardList",wardList);
			return map;
		}
		
		public Map<String, Object> submitJournalVoucher(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			int vhId=0;
			String locationCode="";
			String yearDesc="";
			String voucherNo1="";
			int voucherNo=0;
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session)getSession();
			Transaction tx = null;
			boolean saved = false;
			int authLevel=0;
			if(box.getInt("authLevel")!=0){
				authLevel=box.getInt("authLevel");
			}
			try {
				tx = session.beginTransaction();
				FaVoucherHeader voucherHeader = new FaVoucherHeader();
				MasStoreFinancial masStoreFinancial =new MasStoreFinancial();
				masStoreFinancial.setId(box.getInt("fYear"));
				voucherHeader.setFYear(masStoreFinancial);
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("locationId"));
				voucherHeader.setHospital(hospital);
				voucherHeader.setVoucherType("JV");
				voucherHeader.setRejected("n");
				voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
				voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
				voucherHeader.setStatus("y");
				voucherHeader.setNarration(box.getString(NARRATION));
				if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
					voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
				}
				if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
					voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
				}
				if (box.getInt("schemeId") != 0) {
					MasScheme masScheme = new MasScheme();
					masScheme.setId(box.getInt("schemeId"));
					voucherHeader.setScheme(masScheme);
				}
				Users user = new Users();
				user.setId(box.getInt("changedBy"));
				voucherHeader.setLastChgBy(user);

				voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
				paramMap.put("locationId", box.getInt("locationId"));
				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "save");
				paramMap.put("prefix", "JV");
				paramMap.put("voucherType", "Journal");
				paramMap.put("financialYearId", box.getInt("fYear"));
				 voucherNo = generateVoucherNo(paramMap);
				
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				voucherHeader.setVoucherNo("JV/"+locationCode+"/"+yearDesc+"/"+voucherNo);
				voucherNo1=locationCode+"/"+yearDesc+"/"+voucherNo;
				if(authLevel==0){
					authLevel=getAuthLevel(box.getInt("locationId"));
				}
				if(authLevel==1){
					voucherHeader.setAuthLevelOne("w");
				}else if(authLevel==2){
					voucherHeader.setAuthLevelOne("w");
					voucherHeader.setAuthLevelTwo("w");
					
				}else if(authLevel==3){
					voucherHeader.setAuthLevelOne("w");
					voucherHeader.setAuthLevelTwo("w");
					voucherHeader.setAuthLevelThree("w");
				}else if(authLevel==4){
					voucherHeader.setAuthLevelOne("w");
					voucherHeader.setAuthLevelTwo("w");
					voucherHeader.setAuthLevelThree("w");
					voucherHeader.setAuthLevelFour("w");
				}
				
				int wardId=0;
				if(box.getInt("wardId")!=0){
					wardId=(box.getInt("wardId"));
				}
				if(wardId!=0){
				MasWard masWard=new MasWard();
				masWard.setId(wardId);
				voucherHeader.setWard(masWard);
				}
				hbt.save(voucherHeader);
				map.put("voucherType", voucherHeader.getVoucherType());
				int counter = box.getInt("hiddenValueCharge");
				for (int i = 1; i <= counter; i++) {
					int accountId = 0;
					BigDecimal crAmt = new BigDecimal(0.00);
					BigDecimal drAmt = new BigDecimal(0.00);

					FaVoucherDetails voucherDetails = new FaVoucherDetails();
					FaMasAccount account = new FaMasAccount();
					accountId = box.getInt("accountId"+i);
					account.setId(accountId);
					voucherDetails.setAccount(account);
					voucherDetails.setVoucherHeader(voucherHeader);
					if(box.getInt(SUB_LEDGER_CODE+i) != 0){
						FaMasSubLed subLed= new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE+i));
						voucherDetails.setSubLed(subLed);
						
					}
					if(box.getInt(COST_CENTER_ID+i) != 0){
						MasCostCenter costCenter = new MasCostCenter();
						costCenter.setId(box.getInt(COST_CENTER_ID+i));
						voucherDetails.setCostCenter(costCenter);
					}
					voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
					voucherDetails.setReconcile("n");
					if(!box.getString(CR_AMOUNT+i).equals("")){
						crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						voucherDetails.setCrAmount(crAmt);
					}
					if(!box.getString(DR_AMOUNT+i).equals("")){
						drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						voucherDetails.setDrAmount(drAmt);
					}
					
					hbt.save(voucherDetails);

					List<AccountGroupTransac>actList=new ArrayList<AccountGroupTransac>();
					actList=session.createCriteria(AccountGroupTransac.class)
								    .add(Restrictions.eq("Group.Id", box.getInt("groupId"+i)))
								    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
								    
								    .add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
							.list();
					if(actList.size()==0){
						AccountGroupTransac agt=new AccountGroupTransac();
						
						FaMasAccountGroup fmag=new FaMasAccountGroup();					
						fmag.setId(box.getInt("groupId"+i));
						agt.setGroup(fmag);
						
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							agt.setYtdAmountCr(crAmt);
							agt.setClBalanceCr(crAmt);
							agt.setYtdAmountDr(new BigDecimal(0));
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setClBalanceDr(new BigDecimal(0));
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							agt.setYtdAmountDr(drAmt);
							agt.setClBalanceDr(drAmt);
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceCr(new BigDecimal(0));
							agt.setYtdAmountCr(new BigDecimal(0));
						}
						
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);

						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(box.getInt("fYear"));
						agt.setFYear(msf);
						
						MasHospital mh =new MasHospital();
						mh.setId(box.getInt("locationId"));
						agt.setLocation(mh);
						
						agt.setFYear(masStoreFinancial);
						
						
						hbt.save(agt);
						
					}else if(actList.size()>0){
						for(AccountGroupTransac acgt:actList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							acgt.setTransactionTime(time);
							if(!box.getString(CR_AMOUNT+i).equals("")){
								crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
									drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
									
									
								acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(crAmt));
							/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
							}
							if(!box.getString(DR_AMOUNT+i).equals("")){
								drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
									drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
								
								
								
	/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
								acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(drAmt));
							}
							
							hbt.update(acgt);
							
						}
						
					}
					List<AccountSubGroupTransac>acstList=new ArrayList<AccountSubGroupTransac>();
					acstList=session.createCriteria(AccountSubGroupTransac.class)
								    .add(Restrictions.eq("SubGroup.Id",box.getInt("subGroupId"+i)))
								    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
								    
								    .add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
							.list();
					if(actList.size()==0){
						AccountSubGroupTransac agt=new AccountSubGroupTransac();
						
						FaMasAccountSubGroup fmasg=new FaMasAccountSubGroup();					
						fmasg.setId(box.getInt("subGroupId"+i));
						agt.setSubGroup(fmasg);
						
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							agt.setYtdAmountCr(crAmt);
							agt.setYtdAmountDr(new BigDecimal(0));
							agt.setClBalanceCr(crAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setClBalanceDr(new BigDecimal(0));
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							agt.setYtdAmountDr(drAmt);
							agt.setClBalanceDr(drAmt);
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceCr(new BigDecimal(0));
							agt.setYtdAmountCr(new BigDecimal(0));
						}
						
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);
					
						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(box.getInt("fYear"));
						agt.setFYear(msf);
						
						MasHospital mh =new MasHospital();
						mh.setId(box.getInt("locationId"));
						agt.setLocation(mh);
						
						
						hbt.save(agt);
						
					}else if(actList.size()>0){
						for(AccountSubGroupTransac acgt:acstList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							acgt.setTransactionTime(time);
							if(!box.getString(CR_AMOUNT+i).equals("")){
								crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
									drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
									
									
								acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(crAmt));
							/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
							}
							if(!box.getString(DR_AMOUNT+i).equals("")){
								drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
									drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
								
								
								
	/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
								acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(drAmt));
							}
							
							hbt.update(acgt);
							
						}
						
					}				
					
					List<AccountMainTransac>amtList=new ArrayList<AccountMainTransac>();
					amtList=session.createCriteria(AccountMainTransac.class)
								    .add(Restrictions.eq("Account.Id",box.getInt("accountId"+i)))
								    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
								    .add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
							.list();
					if(actList.size()==0){
						AccountMainTransac agt=new AccountMainTransac();
						
						FaMasAccount fmasg=new FaMasAccount();					
						fmasg.setId(box.getInt("accountId"+i));
						agt.setAccount(fmasg);
						
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							agt.setYtdAmountCr(crAmt);
							agt.setYtdAmountDr(new BigDecimal(0));
							agt.setClBalanceCr(crAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setClBalanceDr(new BigDecimal(0));
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							agt.setYtdAmountDr(drAmt);
							agt.setClBalanceDr(drAmt);
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceCr(new BigDecimal(0));
							agt.setYtdAmountCr(new BigDecimal(0));
						}
						
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);
						
						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(box.getInt("fYear"));
						agt.setFYear(msf);
						
						MasHospital mh =new MasHospital();
						mh.setId(box.getInt("locationId"));
						agt.setLocation(mh);
						
						
						hbt.save(agt);
						
					}else if(actList.size()>0){
						for(AccountMainTransac acgt:amtList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							acgt.setTransactionTime(time);
							if(!box.getString(CR_AMOUNT+i).equals("")){
								crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
									drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
									
									
								acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(crAmt));
							/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
							}
							if(!box.getString(DR_AMOUNT+i).equals("")){
								drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
									drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
								
								
								
	/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
								acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(drAmt));
							}
							
							
							hbt.update(acgt);
							
						}
						
					}								
					System.out.println("sub ledger code------>>"+box.getInt(SUB_LEDGER_CODE_BANK+i));
					if(box.getInt(SUB_LEDGER_CODE+i) != 0){
					List<AccountSubLedTransac>asltList=new ArrayList<AccountSubLedTransac>();
					asltList=session.createCriteria(AccountSubLedTransac.class)
								    .add(Restrictions.eq("SubLed.Id",box.getInt(SUB_LEDGER_CODE+i)))
								    
								    .add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
							.list();
					
	System.out.println("actList SIZE FOR SUB LEDGER-------------->>"+actList.size());
					if(asltList.size()==0){
						AccountSubLedTransac agt=new AccountSubLedTransac();
						
						FaMasSubLed fmasg=new FaMasSubLed();					
						fmasg.setId(box.getInt(SUB_LEDGER_CODE+i));
						agt.setSubLed(fmasg);//(fmasg);
						
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							agt.setYtdAmountCr(crAmt);
							agt.setYtdAmountDr(new BigDecimal(0));
							agt.setClBalanceCr(crAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setClBalanceDr(new BigDecimal(0));
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							agt.setYtdAmountDr(drAmt);
							agt.setClBalanceDr(drAmt);
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceCr(new BigDecimal(0));
							agt.setYtdAmountCr(new BigDecimal(0));
						}
						
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);
						
						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(box.getInt("fYear"));
						agt.setFYear(msf);
						
						/*MasHospital mh =new MasHospital();
						mh.setId(box.getInt("locationId"));
						agt.set(mh);
						*/
						
						hbt.save(agt);
						
					}else if(asltList.size()>0){
						for(AccountSubLedTransac acgt:asltList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							acgt.setTransactionTime(time);
							if(!box.getString(CR_AMOUNT+i).equals("")){
								crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
									drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
									
									
								acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(crAmt));
							/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
							}
							if(!box.getString(DR_AMOUNT+i).equals("")){
								drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
									drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
								
								
								
	/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
								acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(drAmt));
							}
							
							
							hbt.update(acgt);
							
						}
						
					}				
					}
					
					

	//-------------------------update account group-------------------------------------------------

					BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drGroupAmount = new BigDecimal(0.0);
					BigDecimal crGroupAmount = new BigDecimal(0.0);
					
					int groupId = box.getInt("groupId"+i);
					int subGroupId = box.getInt("subGroupId"+i);

					FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
					if(faMasAccountGroup.getOpBalanceCr()!= null){
						groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
					}
					if(faMasAccountGroup.getOpBalanceDr()!= null){
						groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
					}
					if(faMasAccountGroup.getYtdAmountDr()!= null){
						groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
					}
					if(faMasAccountGroup.getYtdAmountCr()!= null){
						groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
						 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
					 }
					if(crAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
						 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
					 }
					drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
					crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

				 	hbt.update(faMasAccountGroup);

		//-------------------------update account Sub group-------------------------------------------------

				 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
					BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
					BigDecimal drSubGroupAmount = new BigDecimal(0.0);
					BigDecimal crSubGroupAmount = new BigDecimal(0.0);

					FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
					 if(accountSubGroup.getOpBalanceDr()!= null){
						 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup.getOpBalanceCr()!= null){
						 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
					 }
					 if(drAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
						 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
						 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
					 }
					 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
					 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
						if(drGroupAmount.compareTo(crGroupAmount)>0){
							faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)>0){
							faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)==0){
							faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						}

				 	hbt.update(accountSubGroup);

		//-------------------------update account master-------------------------------------------------

		//-------------------------update account master-------------------------------------------------

					BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
			 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId);
			 		if(masAccount.getOpBalanceDr()!= null){
			 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
			 		}
			 		if(masAccount.getOpBalanceCr()!= null){
			 			accountOpBalanceCr = masAccount.getOpBalanceCr();
			 		}

			 		 if(masAccount.getYtdAmountDr() != null){
			 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
			 		 }
			 		 if(masAccount.getYtdAmountCr() != null){
			 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
					 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							masAccount.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							masAccount.setClBalanceCr(new BigDecimal(0.00));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}

			 		/*if(drAmt.compareTo(new BigDecimal(0))>0){
						 if(accountClosingBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 	 if(accountClosingBalanceCr.compareTo(drAmt) > 0 ){
						 		accountClosingBalanceCr = accountClosingBalanceCr.subtract(drAmt);
						 		masAccount.setClBalanceCr(accountClosingBalanceCr);
						 		masAccount.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(drAmt.compareTo(accountClosingBalanceCr) > 0 ){
						 		accountClosingBalanceDr =drAmt.subtract(accountClosingBalanceCr);
						 		masAccount.setClBalanceDr(accountClosingBalanceDr);
						 		masAccount.setClBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else {
						 		  accountClosingBalanceDr = accountClosingBalanceDr.add(drAmt);
						 		 masAccount.setClBalanceDr(accountClosingBalanceDr);
							  }

					}else if(crAmt.compareTo(new BigDecimal(0))>0){
						if(accountClosingBalanceDr.compareTo(new BigDecimal(0)) > 0){
						  if(accountClosingBalanceDr.compareTo(crAmt) > 0){
							  accountClosingBalanceDr =accountClosingBalanceDr.subtract(crAmt);
							  masAccount.setClBalanceDr(accountClosingBalanceDr);
							  masAccount.setClBalanceCr(new BigDecimal(0.00));
						  }else if(crAmt.compareTo(accountClosingBalanceDr) > 0 ){
							  accountClosingBalanceCr =crAmt.subtract(accountClosingBalanceDr);
							  masAccount.setClBalanceCr(accountClosingBalanceCr);
							  masAccount.setClBalanceDr(new BigDecimal(0.00));
						 	 }
						}else{
							accountClosingBalanceCr = accountClosingBalanceCr.add(crAmt);
							masAccount.setClBalanceCr(accountClosingBalanceCr);
						  }
					}*/
					 
					 hbt.update(masAccount);
					//-----------------------update account sub ledger==================================
					 if(box.getInt(SUB_LEDGER_CODE_BANK+ i)!=0){
						 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
						 
						 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE_BANK+ i));
						 if(subLed.getOpBalanceCr()!= null){
							 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
						 }
						 if(subLed.getOpBalanceDr()!= null){
							 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
						 }

						if(subLed.getYtdAmountCr()!= null){
							subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
						}
						if(subLed.getYtdAmountDr()!= null){
							subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
						 }
						
						
						 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
						drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
						
						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed.setClBalanceCr(new BigDecimal(0.00));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed);
					 }
					 
					 
				}
				vhId=voucherHeader.getId();
				tx.commit();
				saved = true;
			} catch (Exception e) {
				if(tx != null){
					tx.rollback();
				}
				e.printStackTrace();
			}

			map = showJournalVoucherJsp(box);
			map.put("saved", saved);
			map.put("vhId", vhId);
			//map.put("voucherNo1",voucherNo1);
			map.put("voucherNo", ""+locationCode+"/"+yearDesc+"/"+voucherNo);
			return map;
		}
		
		
		@Override
		public Map<String, Object> showLedgerJsp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
			Session session = (Session)getSession();
			accountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y")).list();
			map.put("accountList", accountList);
			return map;
		}
		
		@Override
		public Map<String, Object> displayLedgerBook(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaVoucherDetails> voucherDetailList = new ArrayList<FaVoucherDetails>();
			List<FaVoucherDetails> ledgerVoucherDetailList= new ArrayList<FaVoucherDetails>();
			List<FaMasAccount> ledgerAccountList = new ArrayList<FaMasAccount>();
			Session session = (Session)getSession();
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
					//.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
								.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
								.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
								.list();
			ledgerVoucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
										//.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
										.add(Restrictions.eq("Account.Id", box.getInt(ACCOUNT_ID)))
									.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
								.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))

									.list();
			System.out.println("accc--->>"+box.getInt(ACCOUNT_ID));
			ledgerAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(box.getInt(ACCOUNT_ID))).list();
			
			map.put("ledgerAccountList", ledgerAccountList);
			map.put("voucherDetailList", voucherDetailList);
			map.put("ledgerVoucherDetailList", ledgerVoucherDetailList);
			return map;
		}
		@Override
		public Map<String, Object> showSubLedgerPopupJsp(Map<String, Object> generalMap) {

			Map<String, Object> map = new HashMap<String, Object>();
			List<AccountSubLedTransac> subLedList = new ArrayList<AccountSubLedTransac>();
			Session session = (Session)getSession();
			int accountId = 0;
			int locationId =0;
			
			if(generalMap.get("accountId")!= null){
				accountId = (Integer)generalMap.get("accountId");
			}
			if(generalMap.get("locationId")!= null){
				locationId = (Integer)generalMap.get("locationId");
			}
			subLedList = session.createCriteria(AccountSubLedTransac.class).createAlias("SubLed", "masSubLed").createAlias("masSubLed.Account", "masAccount").add(Restrictions.eq("masAccount.Id", accountId)).list();
			map.put("subLedList", subLedList);
			return map;
		
		}
		
		@Override
		public Map<String, Object> getTrialBalance(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Object[]> voucherDetailList = new ArrayList<Object[]>();
			Session session = (Session)getSession();
			if(box.getString("accountType").equalsIgnoreCase("group")){
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
									.createAlias("account.AccountSubGroup", "subGroup").createAlias("subGroup.AccountGroup", "group")
									//.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
									.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
									.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
										.setProjection(Projections.projectionList().add(
											Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
											Projections.groupProperty("group.Id")).add(Projections.property("group.AccountGroupDesc"))).list();
			
			}else if(box.getString("accountType").equalsIgnoreCase("subgroup")){
				voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
										.createAlias("account.AccountSubGroup", "subGroup")
											//.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
												.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
													.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
													.setProjection(Projections.projectionList().add(
															Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
																	Projections.groupProperty("subGroup.Id")).add(Projections.property("subGroup.AccountSubGroupName"))).list();
				
			}else if(box.getString("accountType").equalsIgnoreCase("account")){
				System.out.println("for ledger");
				voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header")
						.createAlias("Account", "account")
						//.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear")))
						.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
						.add(Restrictions.between("header.VoucherDate",HMSUtil.dateFormatterDDMMYYYY(box.getString(FROM_DATE)),HMSUtil.dateFormatterDDMMYYYY(box.getString(TO_DATE))))
						.setProjection(Projections.projectionList()
						.add(Projections.sum("DrAmount")).add(Projections.sum("CrAmount"))
						.add(Projections.groupProperty("account.Id")).add(Projections.property("account.AccDesc"))).list();
			}
			System.out.println("acc type-----"+box.getString("accountType"));
			System.out.println("fYear----->"+box.getInt("fYear"));
			System.out.println("locationId----->"+box.getInt("locationId"));
			System.out.println("fdate-----"+box.getString(FROM_DATE));
			System.out.println("todate-----"+box.getString(TO_DATE));
			System.out.println("size----"+voucherDetailList.size());
			map.put("voucherDetailList", voucherDetailList);
			return map;
		}
		
		@Override
		public Map<String, Object> getSubGroupWiseTrialBalance(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Object[]> voucherDetailList = new ArrayList<Object[]>();
			Session session = (Session)getSession();
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
									.createAlias("account.AccountSubGroup", "subGroup").createAlias("subGroup.AccountGroup", "group").add(Restrictions.eq("group.Id", box.getInt("groupId")))
									.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
										.setProjection(Projections.projectionList().add(Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
											Projections.groupProperty("subGroup.Id")).add(Projections.property("subGroup.AccountSubGroupName"))).list();
			map.put("voucherDetailList", voucherDetailList);
			return map;
		}
		@Override
		public Map<String, Object> getAccountWiseTrialBalance(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<Object[]> voucherDetailList = new ArrayList<Object[]>();
				Session session = (Session)getSession();
				voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
										.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).createAlias("account.AccountSubGroup", "subGroup")
										.add(Restrictions.eq("subGroup.Id", box.getInt("subGroupId")))
											.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
											.setProjection(Projections.projectionList().add(
												Projections.sum("DrAmount")).add(Projections.sum("CrAmount")).add(
												Projections.groupProperty("account.Id")).add(Projections.property("account.AccDesc"))).list();
				map.put("voucherDetailList", voucherDetailList);
				return map;
			}
		@Override
		public Map<String, Object> getVoucherWiseWiseTrialBalance(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Object[]> voucherDetailList = new ArrayList<Object[]>();
			Session session = (Session)getSession();
			voucherDetailList = session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "header").createAlias("Account", "account")
									.add(Restrictions.eq("header.FYear.Id", box.getInt("fYear"))).add(Restrictions.eq("account.Id", box.getInt("accountId")))
										.add(Restrictions.eq("header.Hospital.Id", box.getInt("locationId")))
										.setProjection(Projections.projectionList().add(
											Projections.sum("header.DrAmount")).add(Projections.sum("header.CrAmount"))
											.add(Projections.groupProperty("header.Id"))
											.add(Projections.property("header.VoucherType"))).list();
			map.put("voucherDetailList", voucherDetailList);
			return map;
		}
		
		@Override
		public Map<String, Object> showBalanceSheet(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasAccount> currentFinancialYearAccountList = new ArrayList<FaMasAccount>();
			List<FaMasAccount> lastFinancialYearAccountList = new ArrayList<FaMasAccount>();
			List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
			List<MasStoreFinancial> lastFinancialYearList = new ArrayList<MasStoreFinancial>();
			List<MasHospital>hospitalList=new ArrayList<MasHospital>();
			String hospitalName="";
			Session session = (Session)getSession();
			currentFinancialYearAccountList = session.createCriteria(FaMasAccount.class)
											.add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
													.add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
													.list();
			financialYearList = session.createCriteria(MasStoreFinancial.class)
					.add(Restrictions.idEq(box.getInt("fYear"))).list();
			int lastFinancialYearId = 0;
			String lastYearDesc = "";
			String currentYearDesc = "";
			if(financialYearList.size()>0){
				currentYearDesc = financialYearList.get(0).getYearDescription();
				lastYearDesc = ""+(Integer.parseInt(currentYearDesc)-1);
				lastFinancialYearList = session.createCriteria(MasStoreFinancial.class)
						.add(Restrictions.eq("YearDescription", lastYearDesc)).list();
				lastFinancialYearId = lastFinancialYearList.get(0).getId();
			}
			lastFinancialYearAccountList = session.createCriteria(FaMasAccount.class)
											.add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
												.add(Restrictions.eq("FYear.Id", lastFinancialYearId)).list();
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
			for(MasHospital mh:hospitalList){
				hospitalName=mh.getHospitalName();
			}
			map.put("currentFinancialYearAccountList", currentFinancialYearAccountList);
			map.put("lastFinancialYearAccountList", lastFinancialYearAccountList);
			map.put("currentYearDesc", currentYearDesc);
			map.put("lastYearDesc", lastYearDesc);
			map.put("hospitalName",hospitalName);
			
			return map;
		}
		
		
		@Override
		public Map<String, Object> generateBalanceSheetJsp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
			List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
			List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
			List<MasStoreFinancial> lastFinancialYearList = new ArrayList<MasStoreFinancial>();
			Session session = (Session)getSession();
			currentFinancialYearAccountList = session.createCriteria(AccountMainTransac.class)
											.add(Restrictions.eq("Location.Id", box.getInt("locationId")))
													.add(Restrictions.eq("FYear.Id", box.getInt("fYear"))).list();
			financialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
			int lastFinancialYearId = 0;
			String lastYearDesc = "";
			String currentYearDesc = "";
			if(financialYearList.size()>0){
				currentYearDesc = financialYearList.get(0).getYearDescription();
				lastYearDesc = ""+(Integer.parseInt(currentYearDesc)-1);
				lastFinancialYearList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", lastYearDesc)).list();
				lastFinancialYearId = lastFinancialYearList.get(0).getId();
			}
			lastFinancialYearAccountList = session.createCriteria(AccountMainTransac.class)
					.add(Restrictions.eq("Location.Id", box.getInt("locationId")))
					.add(Restrictions.eq("FYear.Id", lastFinancialYearId)).list();
			
			map.put("currentFinancialYearAccountList", currentFinancialYearAccountList);
			map.put("lastFinancialYearAccountList", lastFinancialYearAccountList);
			map.put("currentYearDesc", Integer.parseInt(currentYearDesc)+1);
			map.put("lastYearDesc", Integer.parseInt(lastYearDesc)+1);
			
			if (currentFinancialYearAccountList.size() > 0)
				map.put("sucFlag", true);
			else
				map.put("sucFlag", false);
		
			return map;
		}
		
		@Override
		public Map<String, Object> displayScheduleDetail(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasAccount> currentScheduleAccountList = new ArrayList<FaMasAccount>();
			List<FaMasAccount> lastScheduleAccountList = new ArrayList<FaMasAccount>();
			List<MasStoreFinancial> lastFinancialIdList = new ArrayList<MasStoreFinancial>();
			List<MasStoreFinancial> currentFinancialIdList = new ArrayList<MasStoreFinancial>();
			Session session = (Session)getSession();
			currentScheduleAccountList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Schedule", box.getInt("schedule")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
												.add(Restrictions.eq("FYear.Id",  box.getInt("fYear"))).list();
			lastFinancialIdList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", box.getString("lastYearDesc"))).list();
			int lastFinancialId = 0;
			Date fromDate = null;
			Date toDate = null;
			if(lastFinancialIdList.size()>0){
				lastFinancialId = lastFinancialIdList.get(0).getId();
			}
			currentFinancialIdList = session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("YearDescription", box.getString("currentYearDesc"))).list();
			if(currentFinancialIdList.size()>0){
				fromDate = currentFinancialIdList.get(0).getStartDate(); 
				toDate = currentFinancialIdList.get(0).getEndDate();
			}
			lastScheduleAccountList =session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Schedule", box.getInt("schedule")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("locationId")))
												.add(Restrictions.eq("FYear.Id",  lastFinancialId)).list();
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);
			map.put("currentScheduleAccountList", currentScheduleAccountList);
			map.put("lastScheduleAccountList", lastScheduleAccountList);
			return map;
		}
		@Override
		public Map<String, Object> deleteAccountSubLedger(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasSubLed> faMasSubLedList = new ArrayList<FaMasSubLed>();
		
			List<FaMasSubLed> existingAccountList = new ArrayList<FaMasSubLed>();
			Session session = (Session)getSession();
			String message = "";
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			try {
				existingAccountList = session.createCriteria(FaMasSubLed.class)
						.add(Restrictions.eq("SubLedDesc", box.getString(RequestConstants.SEARCH_NAME)))
						//.add(Restrictions.ne("Id", box.getInt("accountId")))
						.list();
				System.out.println("existingAccountList.size()=====>>"+existingAccountList.size());
				/*if (existingAccountList.size() > 0) {
					message = "Record already Exist";
				}*/// else {
	System.out.println("box.getInt(accountId)============>>"+box.getInt("accountId"));
	System.out.println("code====>>>"+box.getString(RequestConstants.SEARCH_NAME));

					for(FaMasSubLed faMasAccountGroup:existingAccountList){// = (FaMasAccountGroup) hbt.load(FaMasAccount.class,box.getInt("accountId"));

						if(box.getString("flag").equals("InActivate")){
							faMasAccountGroup.setStatus("n");
						}else if(box.getString("flag").equals("Activate")){
							faMasAccountGroup.setStatus("y");
						}
				MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
				masStoreFinancial.setId(box.getInt("fYear"));
				faMasAccountGroup.setFYear(masStoreFinancial);
				
				Users user = new Users();
				user.setId(box.getInt("changedBy"));
				faMasAccountGroup.setLastChgBy(user);
				
				
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");

				faMasAccountGroup.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				faMasAccountGroup.setLastChgTime(time);
				hbt.update(faMasAccountGroup);
				message = "Record update sucessfully!";
	//----------------------------------------------calculation for last Balance---------------------------------
				
				}
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			faMasSubLedList = session.createCriteria(FaMasSubLed.class)//.add(Restrictions.eq("Status", "y"))
					.createAlias("FYear", "fy")
					.add(Restrictions.eq("fy.Id", box.getInt("fYear")))
					
					.list();
			map.put("faMasAccountGroupList", faMasSubLedList);
			map.put("message",message);
			return map;
		}
		@Override
		public Map<String, Object> showAccountBalance(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
			Session session = (Session)getSession();
			int locationId = box.getInt("locationId");
			int fyear = box.getInt("fyear");
			int accountId = box.getInt("accountId");
			System.out.println("locationId="+locationId+"&year="+fyear+"&accountId="+accountId);
			accountList = session.createCriteria(AccountMainTransac.class)
					.createAlias("Account", "acc")
					.createAlias("Location", "location")
					.createAlias("FYear", "yr")
					.add(Restrictions.eq("yr.Id",fyear)).add(Restrictions.eq("location.Id",locationId)).add(Restrictions.eq("acc.Id",accountId)).list();
			map.put("accountList", accountList);
			System.out.println("accountList="+accountList.size());

			return map;
		}
		
		public synchronized Map<String,Object> updateTransaction(int subLedId,int accountId,int fYearId,int locationId,String crAmount,String drAmount){
			System.out.println("accountId=---------------->>"+accountId);
			System.out.println("crAmount=---------------->>"+crAmount);
			System.out.println("drAmount=---------------->>"+drAmount);
			System.out.println("fYearId=---------------->>"+fYearId);
			Map<String,Object>map=new HashMap<String,Object>();
			Session session=(Session)getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			boolean flag=false;
			Transaction tx = null;		
			try{
				tx=session.beginTransaction();
				// transaction for Account
				List<AccountMainTransac>amtList=new ArrayList<AccountMainTransac>();
				amtList=session.createCriteria(AccountMainTransac.class)
							    .add(Restrictions.eq("Account.Id",accountId))
							    .add(Restrictions.eq("FYear.Id",fYearId))
							    .add(Restrictions.eq("Location.Id",locationId))
						.list();
				if(amtList.size()==0){
					AccountMainTransac agt=new AccountMainTransac();
					FaMasAccount fmasg=new FaMasAccount();					
					fmasg.setId(accountId);
					agt.setAccount(fmasg);
						//crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						agt.setOpBalanceCr(new BigDecimal(0));
						agt.setClBalanceCr(new BigDecimal(crAmount));
//						drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						agt.setOpBalanceDr(new BigDecimal(0));
						agt.setClBalanceDr(new BigDecimal(drAmount));
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					agt.setTransactionTime(time);
					agt.setYtdAmountCr(new BigDecimal(crAmount));
					agt.setYtdAmountDr(new BigDecimal(drAmount));
					MasStoreFinancial msf=new MasStoreFinancial();
					msf.setId(fYearId);
					agt.setFYear(msf);
					MasHospital mh =new MasHospital();
					mh.setId(locationId);
					agt.setLocation(mh);
					hbt.save(agt);
				}else if(amtList.size()>0){
					for(AccountMainTransac acgt:amtList){
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");
						acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						acgt.setTransactionTime(time);
						if(!crAmount.equals("")){
						//	crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							 
							BigDecimal crAmountSubLedger1=new BigDecimal(0);
							BigDecimal drAmountSubLedger1=new BigDecimal(0);
								crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(new BigDecimal(crAmount));
								drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
								
								if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
									acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
									acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
								
								
							acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(new BigDecimal(crAmount)));
							//acgt.setClBalanceCr(acgt.getClBalanceCr().add(new BigDecimal(crAmount)));
						}
						if(!drAmount.equals("") ){
						//	drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							BigDecimal crAmountSubLedger11=new BigDecimal(0);
							BigDecimal drAmountSubLedger11=new BigDecimal(0);
								crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
								drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(new BigDecimal(drAmount));
								
								if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
									acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
									acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
							
							
							
	/*						acgt.setClBalanceDr(acgt.getClBalanceDr().add(new BigDecimal(drAmount)));
	*/						acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(new BigDecimal(drAmount)));
						}
						
						hbt.update(acgt);
					}

			}
				List<AccountMainTransac>amtListDelete=new ArrayList<AccountMainTransac>();
				amtListDelete=session.createCriteria(AccountMainTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
						.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
						.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
						.list();
				for(AccountMainTransac amt1:amtListDelete){
					session.delete(amt1);
				}
				// transaction for Subgroup
				int groupId=0;
				int subGroupId=0;
				List<FaMasAccount>accList=new ArrayList<FaMasAccount>();
				accList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Id", accountId)).list();
				for(FaMasAccount acc:accList){
					groupId=acc.getAccountSubGroup().getAccountGroup().getId();
					subGroupId=acc.getAccountSubGroup().getId();
				}
				List<AccountSubGroupTransac>subGroupTransacList=new ArrayList<AccountSubGroupTransac>();
				subGroupTransacList=session.createCriteria(AccountSubGroupTransac.class)
					    .add(Restrictions.eq("SubGroup.Id",subGroupId))
					    .add(Restrictions.eq("FYear.Id",fYearId))
					    .add(Restrictions.eq("Location.Id",locationId))
				.list();
				
				if(subGroupTransacList.size()==0){
					AccountSubGroupTransac accountSubGroupTransac=new AccountSubGroupTransac();
					FaMasAccountSubGroup fmasg=new FaMasAccountSubGroup();					
					fmasg.setId(subGroupId);
					accountSubGroupTransac.setSubGroup(fmasg);
					accountSubGroupTransac.setOpBalanceCr(new BigDecimal(0));
					accountSubGroupTransac.setClBalanceCr(new BigDecimal(crAmount));
//					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					accountSubGroupTransac.setOpBalanceDr(new BigDecimal(0));
					accountSubGroupTransac.setClBalanceDr(new BigDecimal(drAmount));
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					accountSubGroupTransac.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					accountSubGroupTransac.setTransactionTime(time);
					accountSubGroupTransac.setYtdAmountCr(new BigDecimal(crAmount));
					accountSubGroupTransac.setYtdAmountDr(new BigDecimal(drAmount));
					MasStoreFinancial msf=new MasStoreFinancial();
					msf.setId(fYearId);
					accountSubGroupTransac.setFYear(msf);
					MasHospital mh =new MasHospital();
					mh.setId(locationId);
					accountSubGroupTransac.setLocation(mh);	
					hbt.save(accountSubGroupTransac);
				}else if(subGroupTransacList.size()>0){
					for(AccountSubGroupTransac acgt:subGroupTransacList){
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");
						acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						acgt.setTransactionTime(time);
						if(!crAmount.equals("")){
						//	crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							 
							BigDecimal crAmountSubLedger1=new BigDecimal(0);
							BigDecimal drAmountSubLedger1=new BigDecimal(0);
								crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(new BigDecimal(crAmount));
								drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
								
								if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
									acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
									acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
								
								
							acgt.setYtdAmountCr(acgt.getYtdAmountCr().add(new BigDecimal(crAmount)));
							/*acgt.setClBalanceCr(acgt.getClBalanceCr().add(new BigDecimal(crAmount)));*/
						}
						if(!drAmount.equals("") ){
						//	drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							BigDecimal crAmountSubLedger11=new BigDecimal(0);
							BigDecimal drAmountSubLedger11=new BigDecimal(0);
								crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
								drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(new BigDecimal(drAmount));
								
								if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
									acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
									acgt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
									acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
									acgt.setClBalanceCr(new BigDecimal(0.00));
									acgt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
							
							
							
									/*acgt.setClBalanceDr(acgt.getClBalanceDr().add(new BigDecimal(drAmount)));*/
							acgt.setYtdAmountDr(acgt.getYtdAmountDr().add(new BigDecimal(drAmount)));
						}
						
						hbt.update(acgt);
					}

			
				}
				List<AccountSubGroupTransac>asgtListDelete=new ArrayList<AccountSubGroupTransac>();
				asgtListDelete=session.createCriteria(AccountSubGroupTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
						.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
						.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
						.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
						.list();
				for(AccountSubGroupTransac asgt1:asgtListDelete){
					session.delete(asgt1);
				}
				
				// transaction for group
				List<AccountGroupTransac>groupTransacList=new ArrayList<AccountGroupTransac>();
				groupTransacList=session.createCriteria(AccountGroupTransac.class)
					    .add(Restrictions.eq("Group.Id",groupId))
					    .add(Restrictions.eq("FYear.Id",fYearId))
					    .add(Restrictions.eq("Location.Id",locationId))
				.list();
				
				if(groupTransacList.size()==0){
					AccountGroupTransac accountGroupTransac=new AccountGroupTransac();
					
					FaMasAccountGroup fmag=new FaMasAccountGroup();					
					fmag.setId(groupId);
					accountGroupTransac.setGroup(fmag);
					
					accountGroupTransac.setOpBalanceCr(new BigDecimal(0));
					accountGroupTransac.setClBalanceCr(new BigDecimal(crAmount));
					
				
				
//					drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
					accountGroupTransac.setOpBalanceDr(new BigDecimal(0));
					
					accountGroupTransac.setClBalanceDr(new BigDecimal(drAmount));
					
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map) HMSUtil.getCurrentDateAndTime();
					String date = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");

					
					accountGroupTransac.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
					accountGroupTransac.setTransactionTime(time);
					accountGroupTransac.setYtdAmountCr(new BigDecimal(crAmount));
					accountGroupTransac.setYtdAmountDr(new BigDecimal(drAmount));
					MasStoreFinancial msf=new MasStoreFinancial();
					msf.setId(fYearId);
					accountGroupTransac.setFYear(msf);
					
					MasHospital mh =new MasHospital();
					mh.setId(locationId);
					accountGroupTransac.setLocation(mh);	
					hbt.save(accountGroupTransac);
					
				}else if(groupTransacList.size()>0){
					for(AccountGroupTransac agt:groupTransacList){
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);
						if(!crAmount.equals("") ){
						//	crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							 
							BigDecimal crAmountSubLedger1=new BigDecimal(0);
							BigDecimal drAmountSubLedger1=new BigDecimal(0);
								crAmountSubLedger1 = agt.getOpBalanceCr().add(agt.getYtdAmountCr()).add(new BigDecimal(crAmount));
								drAmountSubLedger1 = agt.getOpBalanceDr().add(agt.getYtdAmountDr());
								
								if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
									agt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
									agt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
									agt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
									agt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
									agt.setClBalanceCr(new BigDecimal(0.00));
									agt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
								
								
								agt.setYtdAmountCr(agt.getYtdAmountCr().add(new BigDecimal(crAmount)));
	/*							agt.setClBalanceCr(agt.getClBalanceCr().add(new BigDecimal(crAmount)));
	*/					}
						if(!drAmount.equals("")){
						//	drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							BigDecimal crAmountSubLedger11=new BigDecimal(0);
							BigDecimal drAmountSubLedger11=new BigDecimal(0);
								crAmountSubLedger11 = agt.getOpBalanceCr().add(agt.getYtdAmountCr());
								drAmountSubLedger11 = agt.getOpBalanceDr().add(agt.getYtdAmountDr()).add(new BigDecimal(drAmount));
								
								if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
									agt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
									agt.setClBalanceCr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
									agt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
									agt.setClBalanceDr(new BigDecimal(0.00));
								}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
									agt.setClBalanceCr(new BigDecimal(0.00));
									agt.setClBalanceDr(new BigDecimal(0.00));
								}
								
								
							
							
							
	/*							agt.setClBalanceDr(agt.getClBalanceDr().add(new BigDecimal(drAmount)));
	*/							agt.setYtdAmountDr(agt.getYtdAmountDr().add(new BigDecimal(drAmount)));
						}
						
						hbt.update(agt);
					}
					List<AccountGroupTransac>agtListDelete=new ArrayList<AccountGroupTransac>();
					asgtListDelete=session.createCriteria(AccountGroupTransac.class).add(Restrictions.eq("ClBalanceDr",new BigDecimal(0.00)))
							.add(Restrictions.eq("ClBalanceCr",new BigDecimal(0.00)))
							.add(Restrictions.eq("YtdAmountCr",new BigDecimal(0.00)))
							.add(Restrictions.eq("YtdAmountDr",new BigDecimal(0.00)))
							.add(Restrictions.eq("OpBalanceCr",new BigDecimal(0.00)))
							.add(Restrictions.eq("OpBalanceDr",new BigDecimal(0.00)))
							.list();
					for(AccountGroupTransac agt1:agtListDelete){
						session.delete(agt1);
					}
					
					if(subLedId!=0){

						List<AccountSubLedTransac>asltList=new ArrayList<AccountSubLedTransac>();
						asltList=session.createCriteria(AccountSubLedTransac.class)
									    .add(Restrictions.eq("SubLed.Id",subLedId))
									    .add(Restrictions.eq("Location.Id",locationId))
									    .add(Restrictions.eq("FYear.Id", fYearId))
								.list();
						
		System.out.println("actList SIZE FOR SUB LEDGER-------------->>"+asltList.size());
						if(asltList.size()==0){
							AccountSubLedTransac agt=new AccountSubLedTransac();
							
							FaMasSubLed fmasg=new FaMasSubLed();					
							fmasg.setId(subLedId);
							agt.setSubLed(fmasg);//(fmasg);
							
							MasHospital location = new MasHospital();
							location.setId(locationId);
							agt.setLocation(location);
							
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setClBalanceCr(new BigDecimal(crAmount));
							agt.setClBalanceDr(new BigDecimal(drAmount));
							agt.setYtdAmountCr(new BigDecimal(crAmount));
							agt.setYtdAmountDr(new BigDecimal(drAmount));					
							
							
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");

							
							agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							agt.setTransactionTime(time);
							
							MasStoreFinancial msf=new MasStoreFinancial();
							msf.setId(fYearId);
							agt.setFYear(msf);
							
							/*MasHospital mh =new MasHospital();
							mh.setId(box.getInt("locationId"));
							agt.set(mh);*/
						
							
							hbt.save(agt);
							
						}else if(asltList.size()>0){
							for(AccountSubLedTransac agt:asltList){
								Map<String, Object> utilMap = new HashMap<String, Object>();
								utilMap = (Map) HMSUtil.getCurrentDateAndTime();
								String date = (String) utilMap.get("currentDate");
								String time = (String) utilMap.get("currentTime");
								agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
								agt.setTransactionTime(time);
								if(!crAmount.equals("") ){
								//	crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
									 
									BigDecimal crAmountSubLedger1=new BigDecimal(0);
									BigDecimal drAmountSubLedger1=new BigDecimal(0);
										crAmountSubLedger1 = agt.getOpBalanceCr().add(agt.getYtdAmountCr()).add(new BigDecimal(crAmount));
										drAmountSubLedger1 = agt.getOpBalanceDr().add(agt.getYtdAmountDr());
										
										if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
											agt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
											agt.setClBalanceCr(new BigDecimal(0.00));
										}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
											agt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
											agt.setClBalanceDr(new BigDecimal(0.00));
										}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
											agt.setClBalanceCr(new BigDecimal(0.00));
											agt.setClBalanceDr(new BigDecimal(0.00));
										}
										
										
										
										
										agt.setYtdAmountCr(agt.getYtdAmountCr().add(new BigDecimal(crAmount)));
	/*									agt.setClBalanceCr(agt.getClBalanceCr().add(new BigDecimal(crAmount)));
	*/							}
								if(!drAmount.equals("")){
								//	drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
									BigDecimal crAmountSubLedger11=new BigDecimal(0);
									BigDecimal drAmountSubLedger11=new BigDecimal(0);
										crAmountSubLedger11 = agt.getOpBalanceCr().add(agt.getYtdAmountCr());
										drAmountSubLedger11 = agt.getOpBalanceDr().add(agt.getYtdAmountDr()).add(new BigDecimal(drAmount));
										
										if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
											agt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
											agt.setClBalanceCr(new BigDecimal(0.00));
										}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
											agt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
											agt.setClBalanceDr(new BigDecimal(0.00));
										}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
											agt.setClBalanceCr(new BigDecimal(0.00));
											agt.setClBalanceDr(new BigDecimal(0.00));
										}		
										
									
									
									
	/*									agt.setClBalanceDr(agt.getClBalanceDr().add(new BigDecimal(drAmount)));
	*/									agt.setYtdAmountDr(agt.getYtdAmountDr().add(new BigDecimal(drAmount)));
								}
								
								hbt.update(agt);
							}
							
						}				
						
					}
					
					
					
					
					
					
					
				}
			}catch(Exception e){
				if(tx != null){
					tx.rollback();
				}
				e.printStackTrace();
			}
			return map;	
		}
		@Override
		public Map<String, Object> submitOpeningBalance(Box box) {
			System.out.println("in opening Balance Data Service ");
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String voucherNo1="";
			int vhId=0;
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session)getSession();
			Transaction tx = null;
			boolean saved = false;
			int authLevel=0;
			if(box.getInt("authLevel")!=0){
				authLevel=box.getInt("authLevel");
			}

			try {
				tx = session.beginTransaction();
				FaVoucherHeader voucherHeader = new FaVoucherHeader();
				MasStoreFinancial masStoreFinancial =new MasStoreFinancial();
				masStoreFinancial.setId(box.getInt("fYear"));
				voucherHeader.setFYear(masStoreFinancial);
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("locationId"));
				voucherHeader.setHospital(hospital);
				voucherHeader.setVoucherType("OP");
				voucherHeader.setVoucherDate(HMSUtil.convertStringTypeDateToDateType(box.getString(VOUCHER_DATE)));
				voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
				voucherHeader.setStatus("y");
				voucherHeader.setNarration(box.getString(NARRATION));
				if(!box.getString(TOTAL_DR_AMOUNT).equals("")){
					voucherHeader.setDrAmount(new BigDecimal(box.getString(TOTAL_DR_AMOUNT)));
				}
				if(!box.getString(TOTAL_CR_AMOUNT).equals("")){
					voucherHeader.setCrAmount(new BigDecimal(box.getString(TOTAL_CR_AMOUNT)));
				}
				Users user = new Users();
				user.setId(box.getInt("changedBy"));
				voucherHeader.setLastChgBy(user);

				voucherHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
				paramMap.put("locationId", box.getInt("locationId"));
				paramMap.put("suffix", box.getString("fYearDesc"));
				paramMap.put("flag", "save");
				paramMap.put("prefix", "OP");
				paramMap.put("voucherType", "Opening");
				paramMap.put("financialYearId", box.getInt("fYear"));
				int voucherNo = generateVoucherNo(paramMap);
				String locationCode="";
				String yearDesc="";
				List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
				List<MasHospital>hospitalList=new ArrayList<MasHospital>();
				hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("locationId"))).list();
				for(MasHospital mg:hospitalList){
					locationCode=mg.getHospitalCode();
				}
				financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(box.getInt("fYear"))).list();
				for(MasStoreFinancial msf1:financialList){
					yearDesc=msf1.getYearDescription();
				}
				voucherHeader.setVoucherNo(locationCode+"/"+yearDesc+"/"+voucherNo);
				voucherNo1=locationCode+"/"+yearDesc+"/"+voucherNo;
				if(authLevel==0){
					authLevel=getAuthLevel(box.getInt("locationId"));
				}
				if(authLevel==1){
					voucherHeader.setAuthLevelOne("w");
				}else if(authLevel==2){
					voucherHeader.setAuthLevelOne("w");
					voucherHeader.setAuthLevelTwo("w");
					
				}else if(authLevel==3){
					voucherHeader.setAuthLevelOne("w");
					voucherHeader.setAuthLevelTwo("w");
					voucherHeader.setAuthLevelThree("w");
				}else if(authLevel==4){
					voucherHeader.setAuthLevelOne("w");
					voucherHeader.setAuthLevelTwo("w");
					voucherHeader.setAuthLevelThree("w");
					voucherHeader.setAuthLevelFour("w");
				}
				hbt.save(voucherHeader);

				int counter = box.getInt("hiddenValueCharge");
			System.out.println("counter----val------->>"+counter);
				for (int i = 1; i <= counter; i++) {
					int accountId = 0;
					BigDecimal crAmt = new BigDecimal(0.00);
					BigDecimal drAmt = new BigDecimal(0.00);

					FaVoucherDetails voucherDetails = new FaVoucherDetails();
					
					System.out.println("accountName------>>"+box.getString("accountName"+i));
					String item1[] = box.getString("accountName"+i).split("\\[");
					String item11[] = item1[1].split("]");
					String item111 = item11[0];
					System.out.println("accountCode------>>"+item111);
					int accountId2=getAccountId(item111);
					int subGroupId=0;
					subGroupId=getSubGroupId(accountId2);
					int groupId=0;
					groupId=getGroupId(subGroupId);
					
					
					FaMasAccount account = new FaMasAccount();					
					/*accountId = box.getInt("accountId"+i);*/
					System.out.println("accountId2------>>"+accountId2);
					System.out.println("subGroupId------>>"+subGroupId);
					System.out.println("groupId------>>"+groupId);
					account.setId(accountId2);
					voucherDetails.setAccount(account);

					
					voucherDetails.setVoucherHeader(voucherHeader);
					if(box.getInt(SUB_LEDGER_CODE+i) != 0){					
						FaMasSubLed subLed= new FaMasSubLed();
						subLed.setId(box.getInt(SUB_LEDGER_CODE+i));
						voucherDetails.setSubLed(subLed);
						
					}
					if(box.getInt(COST_CENTER_ID+i) != 0){
						MasCostCenter costCenter = new MasCostCenter();
						costCenter.setId(box.getInt(COST_CENTER_ID+i));
						voucherDetails.setCostCenter(costCenter);
					}
					voucherDetails.setNarration(box.getString(ACCOUNT_NARRATION+i));
					voucherDetails.setReconcile("n");
					if(!box.getString(CR_AMOUNT+i).equals("")){
						crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
						voucherDetails.setCrAmount(crAmt);
					}
					if(!box.getString(DR_AMOUNT+i).equals("")){
						drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
						voucherDetails.setDrAmount(drAmt);
					}
					
					hbt.save(voucherDetails);

					List<AccountGroupTransac>actList=new ArrayList<AccountGroupTransac>();
					actList=session.createCriteria(AccountGroupTransac.class)
								    .add(Restrictions.eq("Group.Id", box.getInt("groupId"+i)))
								    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
								    .add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
							.list();
					if(actList.size()==0){
						AccountGroupTransac agt=new AccountGroupTransac();
						
						FaMasAccountGroup fmag=new FaMasAccountGroup();					
						fmag.setId(groupId);
						agt.setGroup(fmag);
						
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							agt.setOpBalanceCr(crAmt);
							agt.setClBalanceCr(crAmt);
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setClBalanceDr(new BigDecimal(0));
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							agt.setOpBalanceDr(drAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceDr(drAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceCr(new BigDecimal(0));
						}
						
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);
						agt.setYtdAmountCr(new BigDecimal(0));
						agt.setYtdAmountDr(new BigDecimal(0));
						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(box.getInt("fYear"));
						agt.setFYear(msf);
						
						MasHospital mh =new MasHospital();
						mh.setId(box.getInt("locationId"));
						agt.setLocation(mh);
						
						
						hbt.save(agt);
						
					}else if(actList.size()>0){
						for(AccountGroupTransac acgt:actList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							acgt.setTransactionTime(time);
							if(!box.getString(CR_AMOUNT+i).equals("")){
								crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
									drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
									
									
								acgt.setOpBalanceCr(acgt.getOpBalanceCr().add(crAmt));
							/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
							}
							if(!box.getString(DR_AMOUNT+i).equals("")){
								drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
									drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
								
								
								
	/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
								acgt.setOpBalanceDr(acgt.getOpBalanceDr().add(drAmt));
							}
							hbt.update(acgt);
							
						}
						
					}
					List<AccountSubGroupTransac>acstList=new ArrayList<AccountSubGroupTransac>();
					acstList=session.createCriteria(AccountSubGroupTransac.class)
								    .add(Restrictions.eq("SubGroup.Id",box.getInt("subGroupId"+i)))
								    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
								    .add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
							.list();
					if(actList.size()==0){
						AccountSubGroupTransac agt=new AccountSubGroupTransac();
						
						FaMasAccountSubGroup fmasg=new FaMasAccountSubGroup();					
						fmasg.setId(subGroupId);
						agt.setSubGroup(fmasg);
						
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							agt.setOpBalanceCr(crAmt);
							agt.setClBalanceCr(crAmt);
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setClBalanceDr(new BigDecimal(0));
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							agt.setOpBalanceDr(drAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceDr(drAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceCr(new BigDecimal(0));
						}
						
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);
						agt.setYtdAmountCr(new BigDecimal(0));
						agt.setYtdAmountDr(new BigDecimal(0));
						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(box.getInt("fYear"));
						agt.setFYear(msf);
						
						MasHospital mh =new MasHospital();
						mh.setId(box.getInt("locationId"));
						agt.setLocation(mh);
						
						
						hbt.save(agt);
						
					}else if(actList.size()>0){
						for(AccountSubGroupTransac acgt:acstList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							acgt.setTransactionTime(time);
							if(!box.getString(CR_AMOUNT+i).equals("")){
								crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
									drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
									
									
									acgt.setOpBalanceCr(acgt.getOpBalanceCr().add(crAmt));
							/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
							}
							if(!box.getString(DR_AMOUNT+i).equals("")){
								drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
									drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
								
								
								
	/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
									acgt.setOpBalanceDr(acgt.getOpBalanceDr().add(drAmt));
							}
							
							hbt.update(acgt);
							
						}
						
					}				
					
					List<AccountMainTransac>amtList=new ArrayList<AccountMainTransac>();
					amtList=session.createCriteria(AccountMainTransac.class)
								    .add(Restrictions.eq("Account.Id",box.getInt("accountId"+i)))
	   							    .add(Restrictions.eq("Location.Id",box.getInt("locationId")))
								    .add(Restrictions.eq("FYear.Id", box.getInt("fYear")))
							.list();
					if(actList.size()==0){
						AccountMainTransac agt=new AccountMainTransac();
						
						FaMasAccount fmasg=new FaMasAccount();					
						fmasg.setId(accountId2);
						agt.setAccount(fmasg);
						
						if(!box.getString(CR_AMOUNT+i).equals("")){
							crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
							agt.setOpBalanceCr(crAmt);
							agt.setClBalanceCr(crAmt);
							agt.setOpBalanceDr(new BigDecimal(0));
							agt.setClBalanceDr(new BigDecimal(0));
						}
						if(!box.getString(DR_AMOUNT+i).equals("")){
							drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
							agt.setOpBalanceDr(drAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceDr(drAmt);
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setOpBalanceCr(new BigDecimal(0));
							agt.setClBalanceCr(new BigDecimal(0));
						}
						
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map) HMSUtil.getCurrentDateAndTime();
						String date = (String) utilMap.get("currentDate");
						String time = (String) utilMap.get("currentTime");

						
						agt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
						agt.setTransactionTime(time);
						agt.setYtdAmountCr(new BigDecimal(0));
						agt.setYtdAmountDr(new BigDecimal(0));
						MasStoreFinancial msf=new MasStoreFinancial();
						msf.setId(box.getInt("fYear"));
						agt.setFYear(msf);
						
						MasHospital mh =new MasHospital();
						mh.setId(box.getInt("locationId"));
						agt.setLocation(mh);
						
						
						hbt.save(agt);
						
					}else if(actList.size()>0){
						for(AccountMainTransac acgt:amtList){
							Map<String, Object> utilMap = new HashMap<String, Object>();
							utilMap = (Map) HMSUtil.getCurrentDateAndTime();
							String date = (String) utilMap.get("currentDate");
							String time = (String) utilMap.get("currentTime");
							acgt.setTransactionDate(HMSUtil.convertStringTypeDateToDateType(date));
							acgt.setTransactionTime(time);
							if(!box.getString(CR_AMOUNT+i).equals("")){
								crAmt = new BigDecimal(box.getString(CR_AMOUNT+i));
								 
								BigDecimal crAmountSubLedger1=new BigDecimal(0);
								BigDecimal drAmountSubLedger1=new BigDecimal(0);
									crAmountSubLedger1 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr()).add(crAmt);
									drAmountSubLedger1 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr());
									
									if(drAmountSubLedger1.compareTo(crAmountSubLedger1)>0){
										acgt.setClBalanceDr(drAmountSubLedger1.subtract(crAmountSubLedger1));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)>0){
										acgt.setClBalanceCr(crAmountSubLedger1.subtract(drAmountSubLedger1));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger1.compareTo(drAmountSubLedger1)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
									
									
									acgt.setOpBalanceCr(acgt.getOpBalanceCr().add(crAmt));
							/*	acgt.setClBalanceCr(acgt.getClBalanceCr().add(crAmt));*/
							}
							if(!box.getString(DR_AMOUNT+i).equals("")){
								drAmt = new BigDecimal(box.getString(DR_AMOUNT+i));
								BigDecimal crAmountSubLedger11=new BigDecimal(0);
								BigDecimal drAmountSubLedger11=new BigDecimal(0);
									crAmountSubLedger11 = acgt.getOpBalanceCr().add(acgt.getYtdAmountCr());
									drAmountSubLedger11 = acgt.getOpBalanceDr().add(acgt.getYtdAmountDr()).add(drAmt);
									
									if(drAmountSubLedger11.compareTo(crAmountSubLedger11)>0){
										acgt.setClBalanceDr(drAmountSubLedger11.subtract(crAmountSubLedger11));
										acgt.setClBalanceCr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)>0){
										acgt.setClBalanceCr(crAmountSubLedger11.subtract(drAmountSubLedger11));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}else if(crAmountSubLedger11.compareTo(drAmountSubLedger11)==0){
										acgt.setClBalanceCr(new BigDecimal(0.00));
										acgt.setClBalanceDr(new BigDecimal(0.00));
									}
									
									
								
								
								
	/*							acgt.setClBalanceDr(acgt.getClBalanceDr().add(drAmt));*/
									acgt.setOpBalanceDr(acgt.getOpBalanceDr().add(drAmt));
							}
							
							hbt.update(acgt);
							
						}
						
					}								
					
					
					

	//-------------------------update account group-------------------------------------------------

					BigDecimal groupOpBalanceDr = new BigDecimal(0.0);
					BigDecimal groupOpBalanceCr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceDr = new BigDecimal(0.0);
					BigDecimal groupYtdBalanceCr = new BigDecimal(0.0);
					BigDecimal drGroupAmount = new BigDecimal(0.0);
					BigDecimal crGroupAmount = new BigDecimal(0.0);
					
					/*int groupId = box.getInt("groupId"+i);
					int subGroupId = box.getInt("subGroupId"+i);*/

					FaMasAccountGroup faMasAccountGroup = (FaMasAccountGroup)hbt.load(FaMasAccountGroup.class, groupId);
					if(faMasAccountGroup.getOpBalanceCr()!= null){
						groupOpBalanceCr =  faMasAccountGroup.getOpBalanceCr();
					}
					if(faMasAccountGroup.getOpBalanceDr()!= null){
						groupOpBalanceDr =  faMasAccountGroup.getOpBalanceDr();
					}
					if(faMasAccountGroup.getYtdAmountDr()!= null){
						groupYtdBalanceDr =  faMasAccountGroup.getYtdAmountDr();
					}
					if(faMasAccountGroup.getYtdAmountCr()!= null){
						groupYtdBalanceCr =  faMasAccountGroup.getYtdAmountCr();
					}
					if(drAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceDr = groupYtdBalanceDr.add(drAmt);
						 faMasAccountGroup.setYtdAmountDr(groupYtdBalanceDr);
					 }
					if(crAmt.compareTo(new BigDecimal(0))>0){
						 groupYtdBalanceCr = groupYtdBalanceCr.add(crAmt);
						 faMasAccountGroup.setYtdAmountCr(groupYtdBalanceCr);
					 }
					drGroupAmount = groupOpBalanceDr.add(groupYtdBalanceDr);
					crGroupAmount = groupOpBalanceCr.add(groupYtdBalanceCr);
					if(drGroupAmount.compareTo(crGroupAmount)>0){
						faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
					    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)>0){
						faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}else if(crGroupAmount.compareTo(drGroupAmount)==0){
						faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
					    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
					}

				 	hbt.update(faMasAccountGroup);

		//-------------------------update account Sub group-------------------------------------------------

				 	BigDecimal subGroupOPBalanceDr = new BigDecimal(0);
					BigDecimal subGroupOPBalanceCr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceDr = new BigDecimal(0);
					BigDecimal subGroupYtdBalanceCr = new BigDecimal(0);
					BigDecimal drSubGroupAmount = new BigDecimal(0.0);
					BigDecimal crSubGroupAmount = new BigDecimal(0.0);

					FaMasAccountSubGroup accountSubGroup = (FaMasAccountSubGroup)hbt.load(FaMasAccountSubGroup.class, subGroupId);
					 if(accountSubGroup.getOpBalanceDr()!= null){
						 subGroupOPBalanceDr =  accountSubGroup.getOpBalanceDr();
					 }
					 if(accountSubGroup.getOpBalanceCr()!= null){
						 subGroupOPBalanceCr = accountSubGroup.getOpBalanceCr();
					 }
					 if(accountSubGroup.getYtdAmountDr()!= null){
						 subGroupYtdBalanceDr = accountSubGroup.getYtdAmountDr();
					 }
					 if(accountSubGroup.getYtdAmountCr()!= null){
						 subGroupYtdBalanceCr = accountSubGroup.getYtdAmountCr();
					 }
					 if(drAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceDr = subGroupYtdBalanceDr.add(drAmt);
						 accountSubGroup.setYtdAmountDr(subGroupYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 subGroupYtdBalanceCr = subGroupYtdBalanceCr.add(crAmt);
						 accountSubGroup.setYtdAmountCr(subGroupYtdBalanceCr);
					 }
					 drSubGroupAmount = subGroupOPBalanceDr.add(subGroupYtdBalanceDr);
					 crSubGroupAmount = subGroupOPBalanceCr.add(subGroupYtdBalanceCr);
						if(drGroupAmount.compareTo(crGroupAmount)>0){
							faMasAccountGroup.setClBalanceDr(drGroupAmount.subtract(crGroupAmount));
						    faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)>0){
							faMasAccountGroup.setClBalanceCr(crGroupAmount.subtract(drGroupAmount));
						    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						}else if(crGroupAmount.compareTo(drGroupAmount)==0){
							faMasAccountGroup.setClBalanceCr(new BigDecimal(0.00));
						    faMasAccountGroup.setClBalanceDr(new BigDecimal(0.00));
						}

				 	hbt.update(accountSubGroup);

		//-------------------------update account master-------------------------------------------------

		//-------------------------update account master-------------------------------------------------

					BigDecimal accountOpBalanceDr = new  BigDecimal(0.0);
			 		BigDecimal accountOpBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceDr = new BigDecimal(0.0);
			 		BigDecimal accountYtdBalanceCr = new  BigDecimal(0.0);
			 		BigDecimal drAccountAmount = new BigDecimal(0.0);
			 		BigDecimal crAccountAmount = new  BigDecimal(0.0);
			 		FaMasAccount masAccount = (FaMasAccount)hbt.load(FaMasAccount.class,accountId2);
			 		if(masAccount.getOpBalanceDr()!= null){
			 			accountOpBalanceDr =  masAccount.getOpBalanceDr();
			 		}
			 		if(masAccount.getOpBalanceCr()!= null){
			 			accountOpBalanceCr = masAccount.getOpBalanceCr();
			 		}

			 		 if(masAccount.getYtdAmountDr() != null){
			 			 accountYtdBalanceDr = masAccount.getYtdAmountDr();
			 		 }
			 		 if(masAccount.getYtdAmountCr() != null){
			 			accountYtdBalanceCr = masAccount.getYtdAmountCr();
			 		 }
			 		if(drAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceDr = accountYtdBalanceDr.add(drAmt);
						 masAccount.setYtdAmountDr(accountYtdBalanceDr);
					 }
					 if(crAmt.compareTo(new BigDecimal(0))>0){
						 accountYtdBalanceCr = accountYtdBalanceCr.add(crAmt);
						 masAccount.setYtdAmountCr(accountYtdBalanceCr);
					 }
					 drAccountAmount = accountOpBalanceDr.add(accountYtdBalanceDr);
					 crAccountAmount = accountOpBalanceCr.add(accountYtdBalanceCr);
						if(drAccountAmount.compareTo(crAccountAmount)>0){
							masAccount.setClBalanceDr(drAccountAmount.subtract(crAccountAmount));
							masAccount.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)>0){
							masAccount.setClBalanceCr(crAccountAmount.subtract(drAccountAmount));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAccountAmount.compareTo(drAccountAmount)==0){
							masAccount.setClBalanceCr(new BigDecimal(0.00));
							masAccount.setClBalanceDr(new BigDecimal(0.00));
						}

			 		/*if(drAmt.compareTo(new BigDecimal(0))>0){
						 if(accountClosingBalanceCr.compareTo(new BigDecimal(0)) > 0){
						 	 if(accountClosingBalanceCr.compareTo(drAmt) > 0 ){
						 		accountClosingBalanceCr = accountClosingBalanceCr.subtract(drAmt);
						 		masAccount.setClBalanceCr(accountClosingBalanceCr);
						 		masAccount.setClBalanceDr(new BigDecimal(0.00));
						 	 }else if(drAmt.compareTo(accountClosingBalanceCr) > 0 ){
						 		accountClosingBalanceDr =drAmt.subtract(accountClosingBalanceCr);
						 		masAccount.setClBalanceDr(accountClosingBalanceDr);
						 		masAccount.setClBalanceCr(new BigDecimal(0.00));
						 	 }
						 }else {
						 		  accountClosingBalanceDr = accountClosingBalanceDr.add(drAmt);
						 		 masAccount.setClBalanceDr(accountClosingBalanceDr);
							  }

					}else if(crAmt.compareTo(new BigDecimal(0))>0){
						if(accountClosingBalanceDr.compareTo(new BigDecimal(0)) > 0){
						  if(accountClosingBalanceDr.compareTo(crAmt) > 0){
							  accountClosingBalanceDr =accountClosingBalanceDr.subtract(crAmt);
							  masAccount.setClBalanceDr(accountClosingBalanceDr);
							  masAccount.setClBalanceCr(new BigDecimal(0.00));
						  }else if(crAmt.compareTo(accountClosingBalanceDr) > 0 ){
							  accountClosingBalanceCr =crAmt.subtract(accountClosingBalanceDr);
							  masAccount.setClBalanceCr(accountClosingBalanceCr);
							  masAccount.setClBalanceDr(new BigDecimal(0.00));
						 	 }
						}else{
							accountClosingBalanceCr = accountClosingBalanceCr.add(crAmt);
							masAccount.setClBalanceCr(accountClosingBalanceCr);
						  }
					}*/
					 
					 hbt.update(masAccount);
					//-----------------------update account sub ledger==================================
					 if(box.getInt(SUB_LEDGER_CODE+ i)!=0){
						 BigDecimal subLedgerOPBalanceCr = new BigDecimal(0.0);
						 BigDecimal subLedgerOPBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceDr = new BigDecimal(0.0);
						 BigDecimal subLedgerYTDBalanceCr = new BigDecimal(0.0);
						 BigDecimal drAmountSubLedger = new BigDecimal(0.0);
						 BigDecimal crAmountSubLedger = new BigDecimal(0.0);
						 
						 FaMasSubLed subLed= (FaMasSubLed)hbt.load(FaMasSubLed.class, box.getInt(SUB_LEDGER_CODE+ i));
						 if(subLed.getOpBalanceCr()!= null){
							 subLedgerOPBalanceCr =  subLed.getOpBalanceCr();
						 }
						 if(subLed.getOpBalanceDr()!= null){
							 subLedgerOPBalanceDr = subLed.getOpBalanceDr();
						 }

						if(subLed.getYtdAmountCr()!= null){
							subLedgerYTDBalanceCr = subLed.getYtdAmountCr();
						}
						if(subLed.getYtdAmountDr()!= null){
							subLedgerYTDBalanceDr = subLed.getYtdAmountDr();
						}
						if(drAmt.compareTo(new BigDecimal(0))>0){
							subLedgerYTDBalanceDr = subLedgerYTDBalanceDr.add(drAmt);
							subLed.setYtdAmountDr(subLedgerYTDBalanceDr);
						 }
						 if(crAmt.compareTo(new BigDecimal(0))>0){
							 subLedgerYTDBalanceCr = subLedgerYTDBalanceCr.add(crAmt);
							 subLed.setYtdAmountCr(subLedgerYTDBalanceCr);
						 }
						
						
						 crAmountSubLedger = subLedgerOPBalanceCr.add(subLedgerYTDBalanceCr);
						drAmountSubLedger = subLedgerOPBalanceDr.add(subLedgerYTDBalanceDr);
						
						if(drAmountSubLedger.compareTo(crAmountSubLedger)>0){
							subLed.setClBalanceDr(drAmountSubLedger.subtract(crAmountSubLedger));
							subLed.setClBalanceCr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)>0){
							subLed.setClBalanceCr(crAmountSubLedger.subtract(drAmountSubLedger));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}else if(crAmountSubLedger.compareTo(drAmountSubLedger)==0){
							subLed.setClBalanceCr(new BigDecimal(0.00));
							subLed.setClBalanceDr(new BigDecimal(0.00));
						}
							 hbt.update(subLed);
					 }
					 
					 
				}
				vhId=voucherHeader.getId();
				tx.commit();
				saved = true;
			} catch (Exception e) {
				if(tx != null){
					tx.rollback();
				}
				e.printStackTrace();
			}

			map = showJournalVoucherJsp(box);
			map.put("saved", saved);
			map.put("vhId", vhId);
			map.put("voucherNo1",voucherNo1);
			return map;
		}
		
		private int getGroupId(int subGroupId) {
			int groupId=0;
			Session session=(Session)getSession();
			List<FaMasAccountSubGroup>accountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
			accountSubGroupList=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Id", subGroupId)).list();
			for(FaMasAccountSubGroup acc:accountSubGroupList){
				groupId=acc.getAccountGroup().getId();
			}
			return groupId;
			
			
		}
		
		private int getSubGroupId(int accountId2) {
			int subGroupId=0;
			Session session=(Session)getSession();
			List<FaMasAccount>accountList=new ArrayList<FaMasAccount>();
			accountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Id", accountId2)).list();
			for(FaMasAccount acc:accountList){
				subGroupId=acc.getAccountSubGroup().getId();
			}
			return subGroupId;
			
			
		}
		private int getAccountId(String item111) {
			int accountId=0;
			Session session=(Session)getSession();
			List<FaMasAccount>accountList=new ArrayList<FaMasAccount>();
			accountList=session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccCode", Integer.parseInt(item111))).list();
			for(FaMasAccount acc:accountList){
				accountId=acc.getId();
			}
			return accountId;
			
			
		}
		@Override
		public int getAccountSubGroup(int accountId) {
			int accountSubGroupId=0;
			Session session=(Session)getSession();
			List<FaMasAccount>accList=new ArrayList<FaMasAccount>();
			System.out.println("accountId data service-------->>"+accountId);
			accList=session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
			for(FaMasAccount FaMasAccount:accList){
				accountSubGroupId=FaMasAccount.getAccountSubGroup().getId();
			}
			System.out.println("accountSubGroupId in data------>>"+accountSubGroupId);
			return accountSubGroupId;
		}
		@Override
		public List<Object[]> getCentreList() {
			
			List<Object[]> centreList = new ArrayList<Object[]>();
			Session session = (Session) getSession();
			
			Criteria cr = null;
			
			cr = session.createCriteria(MasHospital.class)
					//.add(Restrictions.eq("UnitType", "Centre").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("Id"))						
							.add(Projections.property("HospitalName")));
			cr = cr.addOrder(Order.asc("HospitalName"));
			centreList = cr.list();
			return centreList;
		}
		@Override
		public List<Object[]> getAccountList(Box box) {
			List<Object[]> accountList = new ArrayList<Object[]>();		
			Session session = getSession();
			Criteria cr = null;
			cr = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("Status", "y").ignoreCase());
			
			cr = cr.add(Restrictions.eq("AccountRight", "Al").ignoreCase());
			
			cr = cr.setProjection(Projections.projectionList()
					.add(Projections.property("Id"))
					.add(Projections.property("AccDesc")));
			accountList = cr.list();		
			
			return accountList;
			
		}
		@Override
		public List<Object[]> getSubledgerList(Box box) {
			List<Object[]> subledgerList = new ArrayList<Object[]>();		
			Session session = getSession();
			Criteria cr = null;
			cr = session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("Status", "y").ignoreCase());	
			cr = cr.createAlias("Hospital", "location",CriteriaSpecification.LEFT_JOIN);
			cr = cr.createAlias("Account", "account",CriteriaSpecification.LEFT_JOIN);
			cr = cr.add(Restrictions.eq("location.Id", box.getInt("locationId")));
			
			/*subledgerList= cr.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("account.Id"))
					.add(Projections.sqlProjection("cast(group_concat(distinct sub_led_id order by sub_led_desc) as char) as sub_led_id", new String[]{"sub_led_id"}, new Type[]{new StringType()}))
					.add(Projections.sqlProjection("group_concat(distinct sub_led_desc order by sub_led_desc) as sub_led_desc", new String[]{"sub_led_desc"}, new Type[]{new StringType()})))
					.list();	*/
			System.out.println("subledgerList="+subledgerList.size());
			
			return subledgerList;
		}
		@Override
		public Map<String, Object> getConsolidatedTransactionDetails(Box box) {
			Map<String,Object> datamap = new HashMap<String,Object>();
			
			List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
			List<AccountSubLedTransac> subledgerList = new ArrayList<AccountSubLedTransac>();
			
			Session session = (Session) getSession();
			int pagingSize = 10;
			int pageNo = 1;		
			int ddlAccountList = 0;	
			int ddlSubledgerList = 0;
			int ddlYear = 0;
			int locationId = 0;		 
			String TransactionType = "" ; // Awaiting/Saved/Approved
			
			
			pageNo = Integer.parseInt(box.getString("PN"));		
			ddlAccountList = box.getInt("ddlAccountList");
			ddlSubledgerList =  box.getInt("ddlSubledgerList");		
			ddlYear = box.getInt("ddlYear");
			
			locationId = box.getInt("locationId");		
			TransactionType = box.getString("TransactionType");
			
			
			Criteria cr = null;
			if(TransactionType.equalsIgnoreCase("Account"))
			{
				cr = session.createCriteria(AccountMainTransac.class);
				if(locationId != 0)
				{
					cr= cr.createAlias("Location", "location").add(Restrictions.eq("location.Id", locationId));
				}
				if(ddlAccountList != 0)
				{
					cr= cr.createAlias("Account", "account").add(Restrictions.eq("account.Id", ddlAccountList));
				}
				List totalMatches = cr.list();
				cr = cr.setFirstResult(pagingSize * (pageNo - 1));
				cr = cr.setMaxResults(pagingSize);
				accountList = cr.list();
				
				int totalRecords = totalMatches.size();
				totalMatches.clear();		

				datamap.put("accountList", accountList);
				datamap.put("totalRecords", totalRecords);
			}
			if(TransactionType.equalsIgnoreCase("Subledger"))
			{
				cr = session.createCriteria(AccountSubLedTransac.class).createAlias("SubLed", "masSubLed");
				if(ddlSubledgerList != 0)
				{
					cr= cr.add(Restrictions.eq("masSubLed.Id", ddlSubledgerList));
				}
				if(locationId != 0)
				{
					cr = cr.createAlias("masSubLed.Hospital", "location").add(Restrictions.eq("location.Id", locationId));
				}
				
				List totalMatches = cr.list();
				cr = cr.setFirstResult(pagingSize * (pageNo - 1));
				cr = cr.setMaxResults(pagingSize);
				subledgerList = cr.list();
				
				int totalRecords = totalMatches.size();
				totalMatches.clear();		

				datamap.put("subledgerList", subledgerList);
				datamap.put("totalRecords", totalRecords);
			}
			
			

			return datamap;

		}
		@Override
		public Map<String, Object> getTransactionHistory(Box box) {
			Map<String,Object> datamap = new HashMap<String,Object>();
			List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();
			
			Session session = (Session) getSession();
			int pagingSize = 10;
			int pageNo = 1;
		
			int Id = 0;		
			String TransactionType = "";
			int locationId = 0;
			
			String ProjectionType = "";
			if (box.getString("PN") != null)
			{
				pageNo = Integer.parseInt(box.getString("PN"));	
			}
			
			
				Id = box.getInt("Id");		
			    locationId = box.getInt("locationId");		
				TransactionType = box.getString("TransactionType");
			
			
			Criteria cr = null;
			cr = session.createCriteria(FaVoucherDetails.class);
			cr = cr.createAlias("VoucherHeader", "header");
				
			
			if(TransactionType.equalsIgnoreCase("S"))
			{
				if (Id != 0 ) {
					cr = cr.createAlias("SubLed", "subledger");
					cr = cr.add(Restrictions.eq("subledger.Id", Id));
				}
			}
			
			if(TransactionType.equalsIgnoreCase("A"))
			{
				if (Id != 0 ) {
					cr = cr.createAlias("Account", "account");
					cr = cr.add(Restrictions.eq("account.Id", Id));
				}
			}		
			
			if (locationId != 0 ) {
				cr = cr.createAlias("header.Hospital", "location");
				cr = cr.add(Restrictions.eq("location.Id", locationId));
			}
			
			
			 cr = cr.addOrder(Order.desc("header.VoucherDate"));
			
			
			List totalMatches = cr.list();
			cr = cr.setFirstResult(pagingSize * (pageNo - 1));
			cr = cr.setMaxResults(pagingSize);
			voucherDetails = cr.list();

			System.out.println("Total records=" + totalMatches.size());
			int totalRecords = totalMatches.size();
			totalMatches.clear();

			System.out.println("Size of voucherDetails in dataservice="
					+ voucherDetails.size());

			datamap.put("voucherDetails", voucherDetails);
			datamap.put("totalRecords", totalRecords);
			

			return datamap;
		}
		@Override
		public Map<String, Object> showBankReconcillationReportJsp(Box box) {
			Map<String,Object>map=new HashMap<String,Object>();
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			Session session=(Session)getSession();
			financialList=session.createCriteria(MasStoreFinancial.class)//.add(Restrictions.eq("Status", "y")).
.addOrder(Order.asc("YearDescription"))					.list();
			map.put("financialList",financialList);
			//financialList.
			return map;
		}
		@Override
		public Map<String, Object> showIncomeExpenditureReportJsp(Box box) {
			Map<String,Object>map=new HashMap<String,Object>();
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			Session session=(Session)getSession();
			financialList=session.createCriteria(MasStoreFinancial.class)//.add(Restrictions.eq("Status", "y")).
.addOrder(Order.asc("YearDescription"))					.list();
			map.put("financialList",financialList);
			//financialList.
			return map;
		}
		@Override
		public String getFinancialYear(int financialYearId) {
			Session session=(Session)getSession();
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			String financialYear="";
			financialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.idEq(financialYearId)).list();
			for(MasStoreFinancial financial:financialList){
				financialYear=financial.getFinancialYear();
			}
			System.out.println("financialYear===========>>"+financialYear);
			return financialYear;
			
		}
		@Override
		public Map<String, Object> showFixedAssetReportJsp(Box box) {
			Map<String,Object>map=new HashMap<String,Object>();
			List<MasStoreFinancial>financialList=new ArrayList<MasStoreFinancial>();
			Session session=(Session)getSession();
			financialList=session.createCriteria(MasStoreFinancial.class)//.add(Restrictions.eq("Status", "y")).
.addOrder(Order.asc("YearDescription"))					.list();
			map.put("financialList",financialList);
			//financialList.
			return map;
		}

		
		public Map<String, Object> showSchemeWiseFundAllocateJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
			List<FaSchemeWiseFundAllocate> faSchemeWiseFundAllocateList = new ArrayList<FaSchemeWiseFundAllocate>();

			List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
			financialYearList= session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("financialYearList", financialYearList);
			
			faSchemeWiseFundAllocateList= session.createCriteria(FaSchemeWiseFundAllocate.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			masSchemeList= session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			map.put("masSchemeList", masSchemeList);
			map.put("faSchemeWiseFundAllocateList", faSchemeWiseFundAllocateList);
			return map;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> addSchemeWiseFundAllocate(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = getSession();
			String message ="";
			try {
				List<FaSchemeWiseFundAllocate> faSchemeWiseFundAllocateList = new ArrayList<FaSchemeWiseFundAllocate>();
				List<FaSchemeSanctionAmount> schemeSanctionAmountList = new ArrayList<FaSchemeSanctionAmount>();

				faSchemeWiseFundAllocateList = session.createCriteria(FaSchemeWiseFundAllocate.class)
						.add(Restrictions.eq("Scheme.Id", box.getInt("schemeId")))
						.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
						.add(Restrictions.eq("FYear.Id", box.getInt("financialYear")))
						.list();
				schemeSanctionAmountList = session.createCriteria(FaSchemeSanctionAmount.class).add(Restrictions.eq("Scheme.Id", box.getInt("schemeId")))
						.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
						.add(Restrictions.eq("FYear.Id", box.getInt("financialYear")))
						.list();
				
				System.out.println("schemeSanctionAmountList==="+schemeSanctionAmountList.size());
				//if(faSchemeWiseFundAllocateList.size()  == 0){
					FaSchemeWiseFundAllocate faSchemeWiseFundAllocate = new FaSchemeWiseFundAllocate();

					MasScheme masScheme = new MasScheme();
					masScheme.setId(box.getInt("schemeId"));
					faSchemeWiseFundAllocate.setScheme(masScheme);
					
					if(!box.getString("letterNo").equals("")){
						faSchemeWiseFundAllocate.setLetterNo(box.getString("letterNo"));
					}
					
					MasHospital hospital = new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					faSchemeWiseFundAllocate.setHospital(hospital);

					MasStoreFinancial f = new MasStoreFinancial();
					f.setId(box.getInt("financialYear"));
					faSchemeWiseFundAllocate.setFYear(f);
					faSchemeWiseFundAllocate.setStatus("Y");
					BigDecimal sanctionedAmount = new BigDecimal(box.getString("sanctionedAmount"));
					faSchemeWiseFundAllocate.setSanctionedAmt(sanctionedAmount);
					
					faSchemeWiseFundAllocate.setSpentAmt(new BigDecimal(0));
					faSchemeWiseFundAllocate.setUnspentAmt(new BigDecimal(0));
					
					
					Users users = new Users();
					users.setId(box.getInt("changedBy"));
					faSchemeWiseFundAllocate.setLastChgBy(users);
					
					faSchemeWiseFundAllocate.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					faSchemeWiseFundAllocate.setLastChgTime(box.getString(CHANGED_TIME));
					faSchemeWiseFundAllocate.setSanctionDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					hbt.save(faSchemeWiseFundAllocate);
					successfullyAdded = true;
				if(schemeSanctionAmountList.size()>0){
					
					int sanctionAmountId = schemeSanctionAmountList.get(0).getId();
					BigDecimal sAmount = schemeSanctionAmountList.get(0).getTotalAmount();
					System.out.println("sAmount=="+sAmount);
					FaSchemeSanctionAmount schemeSanctionAmount = (FaSchemeSanctionAmount)hbt.load(FaSchemeSanctionAmount.class, sanctionAmountId);	
					if(!box.getString("sanctionedAmount").equals("")){
						BigDecimal totalAmount = new BigDecimal(box.getString("sanctionedAmount"));
						System.out.println("totalAmount=="+totalAmount);
						schemeSanctionAmount.setTotalAmount(totalAmount.add(sAmount));
					}
					hbt.update(schemeSanctionAmount);
					
				}else{
					FaSchemeSanctionAmount schemeWiseSanctionAmount = new FaSchemeSanctionAmount();
						MasStoreFinancial fYear = new MasStoreFinancial();
						fYear.setId(box.getInt("financialYear"));
						schemeWiseSanctionAmount.setFYear(fYear);
						
						MasHospital masHospital = new MasHospital();
						masHospital.setId(box.getInt("hospitalId"));
						schemeWiseSanctionAmount.setHospital(hospital);
						
						MasScheme scheme = new MasScheme();
						masScheme.setId(box.getInt("schemeId"));
						schemeWiseSanctionAmount.setScheme(masScheme);
						
						if(!box.getString("sanctionedAmount").equals("")){
							BigDecimal totalAmount = new BigDecimal(box.getString("sanctionedAmount"));
							schemeWiseSanctionAmount.setTotalAmount(totalAmount);
						}

						hbt.save(schemeWiseSanctionAmount);
					
					
					
				}
					
				/*}
				else{
						message = "Scheme already exist.";
					}*/
					
				
				
			 
			}catch (DataAccessException e) {
				e.printStackTrace();
			}
			map = showSchemeWiseFundAllocateJsp();
			map.put("successfullyAdded", successfullyAdded);
			map.put("message", message);
			return map;
		}
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> updateSchemeWiseFundAllocate(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			boolean successfullyAdded = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = getSession();
			String message ="";
			try {
				List<FaSchemeWiseFundAllocate> faSchemeWiseFundAllocateList = new ArrayList<FaSchemeWiseFundAllocate>();
				faSchemeWiseFundAllocateList = session.createCriteria(FaSchemeWiseFundAllocate.class).add(Restrictions.ne("Id", box.getInt(COMMON_ID))).add(Restrictions.eq("Scheme.Id", box.getInt("schemeId")))
						.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
						.add(Restrictions.eq("FYear.Id", box.getInt("financialYear")))
						.list();
				if(faSchemeWiseFundAllocateList.size()  == 0){
					FaSchemeWiseFundAllocate faSchemeWiseFundAllocate = (FaSchemeWiseFundAllocate) hbt.load(FaSchemeWiseFundAllocate.class,box.getInt(COMMON_ID));

					MasScheme masScheme = new MasScheme();
					masScheme.setId(box.getInt("schemeId"));
					faSchemeWiseFundAllocate.setScheme(masScheme);
					
					MasStoreFinancial f = new MasStoreFinancial();
					f.setId(box.getInt("financialYear"));
					faSchemeWiseFundAllocate.setFYear(f);
					
				
					
					faSchemeWiseFundAllocate.setStatus("Y");

					BigDecimal sanctionedAmount = new BigDecimal(box.getString("sanctionedAmount"));
					faSchemeWiseFundAllocate.setSanctionedAmt(sanctionedAmount);
					
					
					if(!box.getString("letterNo").equals("")){
						faSchemeWiseFundAllocate.setLetterNo(box.getString("letterNo"));
					}
					
					faSchemeWiseFundAllocate.setSpentAmt(new BigDecimal(0));
					faSchemeWiseFundAllocate.setUnspentAmt(new BigDecimal(0));
					
					Users users = new Users();
					users.setId(box.getInt("changedBy"));
					faSchemeWiseFundAllocate.setLastChgBy(users);
					
					
					faSchemeWiseFundAllocate.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					faSchemeWiseFundAllocate.setLastChgTime(box.getString(CHANGED_TIME));
					faSchemeWiseFundAllocate.setSanctionDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					hbt.update(faSchemeWiseFundAllocate);
					successfullyAdded = true;
				}else{
					message = "Record already exists.";
					
				}
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			map = showSchemeWiseFundAllocateJsp();
			map.put("successfullyAdded", successfullyAdded);
			map.put("message", message);
			return map;
		}
		@Override
		public boolean deleteSchemeWiseFundAllocate(Box box) {
			boolean dataDeleted = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			FaSchemeWiseFundAllocate faSchemeWiseFundAllocate = (FaSchemeWiseFundAllocate) hbt.load(FaSchemeWiseFundAllocate.class,box.getInt(COMMON_ID));

			if (!box.getString("flag").equals("")) {
				String flag = box.getString("flag");
				if (flag.equals("InActivate")) {
					faSchemeWiseFundAllocate.setStatus("N");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					faSchemeWiseFundAllocate.setStatus("Y");
					dataDeleted = true;
				}
			}
			Users users = new Users();
			users.setId(box.getInt("changedBy"));
			faSchemeWiseFundAllocate.setLastChgBy(users);
			
			
			faSchemeWiseFundAllocate.setLastChgDate(currentDate);
			faSchemeWiseFundAllocate.setLastChgTime(currentTime);
			hbt.update(faSchemeWiseFundAllocate);
			return dataDeleted;
		}
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> searchSchemeWiseFundAllocate(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaSchemeWiseFundAllocate> faSchemeWiseFundAllocateList = new ArrayList<FaSchemeWiseFundAllocate>();
			
			List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
			
			Session session = getSession();
			Criteria crit = null;
			crit = session.createCriteria(FaSchemeWiseFundAllocate.class);
			if(box.getInt("schemeId")!=0){
				crit = crit.add(Restrictions.eq("Scheme.Id", box.getInt("schemeIds")));
			}
			
			faSchemeWiseFundAllocateList = crit.list();
			
			List<MasStoreFinancial> financialYearList = new ArrayList<MasStoreFinancial>();
			financialYearList= session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("financialYearList", financialYearList);
			
			masSchemeList= session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "Y")).list();
			map.put("masSchemeList", masSchemeList);
			map.put("faSchemeWiseFundAllocateList", faSchemeWiseFundAllocateList);
			return map;
		}
		@Override
		public String getAccountSubGroupFlag(int accountId) {
			String flag="";
			Session session=(Session)getSession();
			List<FaMasAccount>accList=new ArrayList<FaMasAccount>();
			System.out.println("accountId data service-------->>"+accountId);
			int accountSubGroupId=0;
			accList=session.createCriteria(FaMasAccount.class).add(Restrictions.idEq(accountId)).list();
			for(FaMasAccount FaMasAccount:accList){
				accountSubGroupId=FaMasAccount.getAccountSubGroup().getId();
			}
			List<FaMasAccountSubGroup>accList1=new ArrayList<FaMasAccountSubGroup>();
			accList1=session.createCriteria(FaMasAccountSubGroup.class).add(Restrictions.eq("Id", accountSubGroupId)).list();
			for(FaMasAccountSubGroup fmasg:accList1){
				flag=fmasg.getFlag();
			}
			return flag;
		}
		@Override
		public Map<String, Object> submitAccountsParameterMainCharge(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			try {
				Vector mainChargeId = box.getVector(MAIN_CHARGECODE_ID);
				Vector subLedId = box.getVector("sub_led_id");
				Vector accountType = box.getVector("accountType");
				Vector accId=box.getVector(ACCOUNT_ID);
				System.out.println("accId==="+accId.size());
			
				for (int i = 0; i<mainChargeId.size(); i++) {
					FaAccountParameter faAccountsParameter = new FaAccountParameter();
					if (mainChargeId.size()>0) {
						if (mainChargeId.get(i) != null && !mainChargeId.get(i).equals("0")) {
							MasMainChargecode masAccount = new MasMainChargecode();
							masAccount.setId(Integer.parseInt(mainChargeId.get(i).toString()));
							faAccountsParameter.setMainChargeId(Integer.parseInt(mainChargeId.get(i).toString()));
						
							if (accId.get(i) != null && !accId.get(i).equals("0")) {
								FaMasAccount masAccount2 = new FaMasAccount();
								masAccount2.setId(Integer.parseInt(accId.get(i).toString()));
								faAccountsParameter.setAccount(masAccount2);
							}
					/*if (accountType.get(i) != null && !accountType.get(i).equals("")) {
						faAccountsParameter.setAccountType((String) accountType.get(i));
					}*/
						
						/*if (subLedId.size() > 0) {
							if (subLedId.get(i) != null && !subLedId.get(i).equals("0")) {
								FaMasSubLed masSubLed = new FaMasSubLed();
								masSubLed.setId(Integer.parseInt(subLedId.get(i).toString()));
								faAccountsParameter.setSubLed(masSubLed);
							}
						}*/
						if(box.getInt("hospitalId")!= 0){
							MasHospital masHospital = new MasHospital();
							masHospital.setId(box.getInt("userId"));
							faAccountsParameter.setHospital(masHospital);
						}
						if(box.getInt("userId")!= 0){
							Users users = new Users();
							users.setId(box.getInt("userId"));
							faAccountsParameter.setLastChgBy(users);
						}
						if(!box.getString(CHANGED_DATE).equals("")){
							faAccountsParameter.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						}
						if(!box.getString(CHANGED_TIME).equals("")){
							faAccountsParameter.setLastChgTime(box.getString(CHANGED_TIME));
						}
						faAccountsParameter.setStatus("y");
						hbt.save(faAccountsParameter);
					}	
					}	
				}
				/*int chargeListLength = box.getInt("hiddenValueForAccounts");
				if(chargeListLength > 0){
						for(int i=0; i<= chargeListLength; i++){
							int mainchargeId  = 0;
							if (box.getInt(MAIN_CHARGECODE_ID+ i) != 0) {
								MasMainChargecode mainChargecode = new MasMainChargecode();
								 mainchargeId = box.getInt(MAIN_CHARGECODE_ID+ i);
							}
							MasMainChargecode masMainChargecode = (MasMainChargecode)hbt.load(MasMainChargecode.class, mainchargeId);
							if (box.getString(BILL_TYPE+ i) != "") {
								//masMainChargecode.setBillType(box.getString(BILL_TYPE+ i));
							}
							if (box.getInt(ACCOUNT_ID+ i) != 0) {
								FaMasAccount faMasAccount = new FaMasAccount();
								faMasAccount.setId(box.getInt(ACCOUNT_ID+ i));
								//masMainChargecode.setAccount(faMasAccount);
							}
							if (box.getInt(SUB_LEDGER_CODE+ i) != 0) {
								FaMasSubLed faMasSubLed = new FaMasSubLed();
								faMasSubLed.setId(box.getInt(SUB_LEDGER_CODE+ i));
								//masMainChargecode.setSubLed(faMasSubLed);
							}

							hbt.update(masMainChargecode);

							}
						}
		*/
				int count = 0;
				if(box.getInt("counter")!= 0){
					count = box.getInt("counter");
				}
				System.out.println("count==="+count);
				for (int i = 1; i <= count; i++) {
					int vendorId  = 0;
					if (box.getInt("vendorCheckBoxId"+ i) != 0) {
						MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
						vendorId = box.getInt("vendorCheckBoxId"+ i);
					
					MasStoreSupplier supplier = (MasStoreSupplier)hbt.load(MasStoreSupplier.class, vendorId);

					/*if (box.getInt("acc_id"+ i) != 0) {
						FaMasAccount faMasAccount = new FaMasAccount();
						faMasAccount.setId(box.getInt("acc_id"+ i));
						supplier.setAcc(faMasAccount);
					}

					if (box.getInt(SUB_LEDGER_ID+ i) != 0) {
						FaMasSubLed faMasSubLed = new FaMasSubLed();
						faMasSubLed.setId(box.getInt(SUB_LEDGER_ID+ i));
						supplier.setSubLed(faMasSubLed);
					}*/

						hbt.update(supplier);

					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map = showAccountParameterJsp(box.getInt("fYear"));
				return map;
			}
		@Override
		public String getEmployeeName(int empId) {
			String name="";
			Session session=(Session)getSession();
			List<MasEmployee>empList=new ArrayList<MasEmployee>();
			empList=session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empId)).list();
			for(MasEmployee me:empList){
				name=me.getFirstName();
			}
			return name;
		}
		@Override
		public Map<String, Object> showIncomeExpenditureReportWardLevelJsp(
				Box box) {
			Session session=(Session)getSession();
			List<FaMasAccount>accList=new ArrayList<FaMasAccount>();
			Map<String,Object>map=new HashMap<String,Object>();
			return map;
		}
		@Override
		public Map<String, Object> getSubLedgerForAccount1(
				Map<String, Object> parameterMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaMasSubLed> subLedgerList = new ArrayList<FaMasSubLed>();
			List<FaMasAccount>accountIdList = new ArrayList<FaMasAccount>();
			/*List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
			int financialYearId = 0;
			if(parameterMap.get("financialYearId")!= null){
				financialYearId = (Integer)parameterMap.get("financialYearId");
			}*/
			String accName = "";
			if(parameterMap.get("accountName")!= null){
				accName = (String)parameterMap.get("accountName");
			}
			int hospitalId=0;
			if(parameterMap.get("locationId")!= null){
				hospitalId=(Integer)parameterMap.get("locationId");
			}
	System.out.println("accName-------->>>>>"+accName);
			Session session = (Session)getSession();
			
			subLedgerList = session.createCriteria(FaMasSubLed.class).createAlias("Account", "acc")
									.createAlias("Hospital", "Hospital").add(Restrictions.eq("Hospital.Id", hospitalId))
									.add(Restrictions.eq("acc.AccCode",Integer.parseInt(accName)))
									
									//.add(Restrictions.eq("acc.SubLedger", "y"))
									.list();
System.out.println("subLedgerList --    "+subLedgerList.size());
			accountIdList = session.createCriteria(FaMasAccount.class).add(Restrictions.eq("AccCode", Integer.parseInt(accName))).list();
			int accountId = 0;
			int groupId = 0;
			int subGroupId = 0;
			BigDecimal closingBalance = new BigDecimal(0.0);
			if(accountIdList.size()>0){
				for(FaMasAccount faMasAccount :accountIdList){
					accountId = faMasAccount.getId();
					groupId = faMasAccount.getAccountSubGroup().getAccountGroup().getId();
					subGroupId = faMasAccount.getAccountSubGroup().getId();
					if(faMasAccount.getClBalanceCr()!= null){
						closingBalance = faMasAccount.getClBalanceCr();
					}else{
						closingBalance = faMasAccount.getClBalanceDr();
					}
				}
			}

			map.put("closingBalance", closingBalance);
			map.put("accountId", accountId);
			map.put("groupId", groupId);
			map.put("subGroupId", subGroupId);
			map.put("subLedgerList", subLedgerList);
			return map;
		}
		@Override
		public Map<String, Object> showFundReceiveAndExpenseReport(Map<String, Object> map) {
			Session session=(Session)getSession();
			Map<String,Object>map1=new HashMap<String,Object>();
			List<FaMasSubLed>subLedList=new ArrayList<FaMasSubLed>();
			int hospitalId=0;
			if(map.get("hospitalId")!=null){
				hospitalId=(Integer)map.get("hospitalId");
			}
			List<Object[]>aList=new ArrayList<Object[]>();
			String query="select a.hospital_id,b.ward_id, c.ward_name, d.employee_id, d.first_name from location_parameter_mapping a, ph_mas_locality b , mas_ward c, mas_employee d where a.locality_id = b.locality_id and b.ward_id = c.ward_id and d.hospital_id = a.hospital_id  and d.rank_id in (251,252,404,405)and a.hospital_id="+hospitalId+" group by a.hospital_id,b.ward_id,c.ward_name, d.employee_id order by b.ward_id ";
			subLedList=session.createCriteria(FaMasSubLed.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
System.out.println(""+query);
			aList=session.createSQLQuery(query).list();
			map.put("subLedList",subLedList);
			map.put("aList",aList);
			return map;
		}
		@Override
		public Map<String, Object> getValueForchequeNo(int chqueId) {
			Session session=(Session)getSession();
			Map<String,Object>map=new HashMap<String,Object>();
			Map<String,Object>map1=new HashMap<String,Object>();
			List<FaVoucherDetails>voucherHeaderList=new ArrayList<FaVoucherDetails>();
			voucherHeaderList=session.createCriteria(FaVoucherDetails.class).createAlias("VoucherHeader", "VoucherHeader")
					.add(Restrictions.eq("VoucherHeader.Id", chqueId))
					.add(Restrictions.isNotNull("DrAmount")).list();
			map.put("voucherHeaderList",voucherHeaderList);
			
			return map;
		}
		@Override
		public Map<String, Object> getDataForExcel(
				Map<String, Object> generalMap) {
			Session session=(Session)getSession();
			Map<String,Object>map=new HashMap<String,Object>();
			int hospitalId=0;
			if(generalMap.get("hospitalId")!=null){
				hospitalId=(Integer.parseInt(""+generalMap.get("hospitalId")));
			}
			String query="select h.voucher_date,sum(coalesce(d.dr_amount,null)) from fa_voucher_details  d "+
			" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id "+
			" left outer join fa_mas_account a on a.acc_id=d.account_id "+
			" where h.voucher_type='RV' and h.hospital_id="+hospitalId+" and d.dr_amount is not null  group by h.voucher_date";
			System.out.println("query=======>>"+query);
			List<Object[]>aList=new ArrayList<Object[]>();
			aList=session.createSQLQuery(query).list();
			
			String queryForOtherExpense="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d   "+
" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null  and d.account_id not in(1495,1602,1693,1680)  "+
" group by h.voucher_date";
			System.out.println("queryForOtherExpense------------>>>>>>"+queryForOtherExpense);
			List<Object[]>otherExpenseList=new ArrayList<Object[]>();
			otherExpenseList=session.createSQLQuery(queryForOtherExpense).list();
			
			
			String queryForTotalExpense=" select h.voucher_date,sum(coalesce(d.cr_amount,null))  "+
					" from fa_voucher_details  d "+  
					" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id "+  
					" left outer join fa_mas_account a on a.acc_id=d.account_id   "+
					" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id=1712 "+
					" group by h.voucher_date";
			System.out.println("queryForTotalExpense----=======>>"+queryForTotalExpense);
			List<Object[]>TotalExpense=new ArrayList<Object[]>();
			TotalExpense=session.createSQLQuery(queryForTotalExpense).list();
			List<Object[]>cleaningAccountList=new ArrayList<Object[]>();
			String queryforCleaningAccount="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d  "+
" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id  in(1495)   "+
" group by h.voucher_date";
			cleaningAccountList=session.createSQLQuery(queryforCleaningAccount).list();
			List<Object[]>minorModificationAccount=new ArrayList<Object[]>();
			String queryForminorModification="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d  "+
					" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
					" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
					" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id  in(1602)   "+
					" group by h.voucher_date";
			minorModificationAccount=session.createSQLQuery(queryForminorModification).list();
				List<Object[]>	transportForEmergenciesList=new ArrayList<Object[]>();
				String queryFortransportForEmergencies="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d  "+
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
						" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
						" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id  in(1693)   "+
						" group by h.voucher_date";
				transportForEmergenciesList=session.createSQLQuery(queryFortransportForEmergencies).list();
				List<Object[]>	rewardToAshaList=new ArrayList<Object[]>();
				String queryForRewardToASHA="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d  "+
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
						" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
						" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id  in(1680)   "+
						" group by h.voucher_date";
				rewardToAshaList=session.createSQLQuery(queryForRewardToASHA).list();
			map.put("rewardToAshaList",rewardToAshaList);			
			map.put("transportForEmergenciesList", transportForEmergenciesList);
			map.put("cleaningAccountList",cleaningAccountList);
			map.put("aList",aList);
			map.put("otherExpenseList",otherExpenseList);
			map.put("TotalExpense",TotalExpense);
			map.put("minorModificationAccount",minorModificationAccount);
			return map;
		}
		@Override
		public Map<String, Object> getDataForReport(Date fromDate,Date toDate) {
			Session session=(Session)getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			Map<String,Object> map=new HashMap<String, Object>();
			hbt.setCheckWriteOperations(false);
			List<Object[]>objList=new ArrayList<Object[]>();
			List<Object[]>objList1=new ArrayList<Object[]>();
			List<FaVoucherDetails>FaVoucherDetailsList=new ArrayList<FaVoucherDetails>();
			FaVoucherDetailsList=session.createCriteria(FaVoucherDetails.class).list();
			map.put("FaVoucherDetailsList",FaVoucherDetailsList);

			return map;
}
		@Override
		public Map<String, Object> printPettyCashVoucherVHNSCExcel(
				Map<String, Object> generalMap) {Session session=(Session)getSession();
				Map<String,Object>map=new HashMap<String,Object>();
				int hospitalId=0;
				if(generalMap.get("hospitalId")!=null){
					hospitalId=(Integer.parseInt(""+generalMap.get("hospitalId")));
				}
				String query="select h.voucher_date,sum(coalesce(d.dr_amount,null)) from fa_voucher_details  d "+
				" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id "+
				" left outer join fa_mas_account a on a.acc_id=d.account_id "+
				" where h.voucher_type='RV' and h.hospital_id="+hospitalId+" and d.dr_amount is not null  group by h.voucher_date";
				System.out.println("query=======>>"+query);
				List<Object[]>aList=new ArrayList<Object[]>();
				aList=session.createSQLQuery(query).list();
				String queryForTotalExpense=" select h.voucher_date,sum(coalesce(d.cr_amount,null))  "+
						" from fa_voucher_details  d "+  
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id "+  
						" left outer join fa_mas_account a on a.acc_id=d.account_id   "+
						" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id=1713 "+
						" group by h.voucher_date";
				System.out.println("queryForTotalExpense----=======>>"+queryForTotalExpense);
				List<Object[]>TotalExpense=new ArrayList<Object[]>();
				TotalExpense=session.createSQLQuery(queryForTotalExpense).list();

				String queryForVillageHealthActivity="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d  "+
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
						" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
						" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id  in(1519)   "+
						" group by h.voucher_date";
				List<Object[]>VillageHealthActivityList=new ArrayList<Object[]>();
				VillageHealthActivityList=session.createSQLQuery(queryForVillageHealthActivity).list();
				
				
				String queryForRevolvingFunds="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d  "+
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
						" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
						" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id  in(1714)   "+
						" group by h.voucher_date";
				
				List<Object[]>RevolvingFundsList=new ArrayList<Object[]>();
				RevolvingFundsList=session.createSQLQuery(queryForRevolvingFunds).list();
				
				String queryForNutrition="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d  "+
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
						" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
						" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id  in(1605)   "+
						" group by h.voucher_date";
				
				List<Object[]>NutritionList=new ArrayList<Object[]>();
				NutritionList=session.createSQLQuery(queryForNutrition).list();
				
				String queryForEducationandSanitization="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d  "+
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
						" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
						" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null and d.account_id  in(1519)   "+
						" group by h.voucher_date";
				List<Object[]>EducationandSanitizationList=new ArrayList<Object[]>();
				EducationandSanitizationList=session.createSQLQuery(queryForEducationandSanitization).list();
				
				String queryForOtherExpense="select h.voucher_date,sum(coalesce(d.cr_amount,null)) from fa_voucher_details  d   "+
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id    "+
						" left outer join fa_mas_account a on a.acc_id=d.account_id    "+
						" where  h.hospital_id="+hospitalId+" and d.cr_amount is not null  and d.account_id not in(1519,1605,1714)  "+
						" group by h.voucher_date";
									System.out.println("queryForOtherExpense------------>>>>>>"+queryForOtherExpense);
									List<Object[]>otherExpenseList=new ArrayList<Object[]>();
									otherExpenseList=session.createSQLQuery(queryForOtherExpense).list();
				
				map.put("aList",aList);
				map.put("TotalExpense",TotalExpense);
				map.put("VillageHealthActivityList",VillageHealthActivityList);
				map.put("RevolvingFundsList",RevolvingFundsList);
				map.put("NutritionList",NutritionList);
				map.put("EducationandSanitizationList",EducationandSanitizationList);
				map.put("queryForOtherExpense", queryForOtherExpense);
				
			return map;
		}
		@Override
		public Map<String, Object> printDoubleColumnCashBook(
				Map<String, Object> generalMap) {Session session=(Session)getSession();
				Map<String,Object>map=new HashMap<String,Object>();
				int hospitalId=0;
				if(generalMap.get("hospitalId")!=null){
					hospitalId=(Integer.parseInt(""+generalMap.get("hospitalId")));
				}
				String query="select h.voucher_date,sum(coalesce(d.dr_amount,null)),a.acc_desc from fa_voucher_details  d "+
				" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id "+
				" left outer join fa_mas_account a on a.acc_id=d.account_id "+
				" where h.voucher_type='RV' and h.hospital_id="+hospitalId+" and d.dr_amount is not null  group by h.voucher_date,a.acc_desc ";
				System.out.println("query=======>>"+query);
				List<Object[]>aList=new ArrayList<Object[]>();
				aList=session.createSQLQuery(query).list();
				String queryForTotalExpense=" select h.voucher_date,sum(coalesce(d.cr_amount,null)),a.acc_desc  "+
						" from fa_voucher_details  d "+  
						" left outer join fa_voucher_header h on h.voucher_header_id=d.voucher_header_id "+  
						" left outer join fa_mas_account a on a.acc_id=d.account_id   "+
						" where  a.acc_desc ='Cash' and h.hospital_id="+hospitalId+" and d.cr_amount is not null "+
						" group by h.voucher_date,a.acc_desc ";
				System.out.println("queryForTotalExpense----=======>>"+queryForTotalExpense);
				List<Object[]>TotalExpense=new ArrayList<Object[]>();
				TotalExpense=session.createSQLQuery(queryForTotalExpense).list();

				
				
				map.put("aList",aList);
				map.put("TotalExpense",TotalExpense);
				
				
			return map;
		}
		public int getAuthLevel(int hospitalId) {
			List<HrInstituteAuthLevel>hospitalList=new ArrayList<HrInstituteAuthLevel>();
			Session session=(Session)getSession();
			int authLevel=0;
			hospitalList=session.createCriteria(HrInstituteAuthLevel.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			for(HrInstituteAuthLevel mh:hospitalList){
				authLevel=mh.getAuthLevel();
			}
			return authLevel;
		}
		@Override
		public Map<String, Object> getWaitingListForVoucherApproval(
				int employeeLevel,int hospitalId) {
			Map<String,Object>map=new HashMap<String,Object>();
			Session session=(Session)getSession();
			List<FaVoucherHeader>faVoucherHeaderList=new ArrayList<FaVoucherHeader>();
			if(employeeLevel==1){
				faVoucherHeaderList=session.createCriteria(FaVoucherHeader.class).add(Restrictions.eq("Rejected", "n")).add(Restrictions.eq("AuthLevelOne", "w")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			}else if(employeeLevel==2){
				faVoucherHeaderList=session.createCriteria(FaVoucherHeader.class).add(Restrictions.eq("Rejected", "n")).add(Restrictions.eq("AuthLevelTwo", "w")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				
			}else if(employeeLevel==3){
				faVoucherHeaderList=session.createCriteria(FaVoucherHeader.class).add(Restrictions.eq("Rejected", "n")).add(Restrictions.eq("AuthLevelThree", "w")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				
			}else if(employeeLevel==4){
				faVoucherHeaderList=session.createCriteria(FaVoucherHeader.class).add(Restrictions.eq("Rejected", "n")).add(Restrictions.eq("AuthLevelFour", "w")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				
			}
			System.out.println("faVoucherHeaderList.size()-------------->>>>>>"+faVoucherHeaderList.size());
			map.put("faVoucherHeaderList",faVoucherHeaderList);
			return map;
		}
		@Override
		public Map<String, Object> getDetailsForVoucherApproval(int voucherId) {
			Map<String,Object>map=new HashMap<String,Object>();
			Session session=(Session)getSession();
			List<FaVoucherDetails>faVoucherDetailList=new ArrayList<FaVoucherDetails>();
			faVoucherDetailList=session.createCriteria(FaVoucherDetails.class).add(Restrictions.eq("VoucherHeader.Id", voucherId)).list();
			System.out.println("faVoucherHeaderList.size()-------------->>>>>>"+faVoucherDetailList.size());
			map.put("faVoucherDetailList",faVoucherDetailList);
			return map;
		}
		@Override
		public boolean aproveVoucher(int employeeLevel, int voucherId) {
			Map<String,Object>map=new HashMap<String,Object>();
			Session session=(Session)getSession();
			boolean approved=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<FaVoucherHeader>faVoucherHeaderList=new ArrayList<FaVoucherHeader>();
			faVoucherHeaderList=session.createCriteria(FaVoucherHeader.class).add(Restrictions.idEq(voucherId)).list();
			for(FaVoucherHeader faVoucherHeader:faVoucherHeaderList){
				if(employeeLevel==1){
					faVoucherHeader.setAuthLevelOne("y");
				}else if(employeeLevel==2){
					faVoucherHeader.setAuthLevelOne("y");
					faVoucherHeader.setAuthLevelTwo("y");
					
				}else if(employeeLevel==3){
					faVoucherHeader.setAuthLevelOne("y");
					faVoucherHeader.setAuthLevelTwo("y");
					faVoucherHeader.setAuthLevelThree("y");

				}else if(employeeLevel==4){
					faVoucherHeader.setAuthLevelOne("y");
					faVoucherHeader.setAuthLevelTwo("y");
					faVoucherHeader.setAuthLevelThree("y");
					faVoucherHeader.setAuthLevelFour("y");

				}
			hbt.update(faVoucherHeader);
			}
			approved=true;
			return approved;
		}
		@Override
		public boolean rejectVoucher(int employeeLevel, int voucherId,String remarksForReject) {
			Map<String,Object>map=new HashMap<String,Object>();
			Session session=(Session)getSession();
			boolean approved=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<FaVoucherHeader>faVoucherHeaderList=new ArrayList<FaVoucherHeader>();
			faVoucherHeaderList=session.createCriteria(FaVoucherHeader.class).add(Restrictions.idEq(voucherId)).list();
			for(FaVoucherHeader faVoucherHeader:faVoucherHeaderList){
				faVoucherHeader.setRejected("y");
				faVoucherHeader.setRemarksForRejection(remarksForReject);
				hbt.update(faVoucherHeader);
			}
			approved=true;
			return approved;
		}
		@Override
		public List<MasStoreFinancial> getmasStoreFinancialList(int fYearId) {
			Session session=(Session)getSession();
			List<MasStoreFinancial>masStoreFinancialList=new ArrayList<MasStoreFinancial>();
			masStoreFinancialList=session.createCriteria(MasStoreFinancial.class).add(Restrictions.eq("Id", fYearId)).list();
			return masStoreFinancialList;
		}
		@Override
		public Map<String, Object> getSchemeDetails() {
			Map<String,Object>map=new HashMap<String,Object>();
			List<MasScheme>schemeList=new ArrayList<MasScheme>();
			Session session=(Session)getSession();
			schemeList=session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("schemeList",schemeList);
			System.out.println("schemeList.size()  --------   >>"+schemeList.size());
			return map;
		}
		@Override
		public Map<String, Object> showEMDRegisterJsp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
			List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
			Session session = (Session)getSession();
			bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
			emdRegisterList = session.createCriteria(FaEmdRegister.class).add(Restrictions.eq("Status", "y")).list();
			map.put("emdRegisterList", emdRegisterList);
			map.put("bankList", bankList);
			return map;
		}
		public Map<String, Object> submitEMDRegister(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
			List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
			Session session = (Session)getSession();
			boolean saved = false;
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			int emdRegId=0;
		try{
			FaEmdRegister  emdRegister = new FaEmdRegister();
			if(box.getInt("bankId") != 0){
				MasBankMaster masBankMaster = new MasBankMaster();
				masBankMaster.setId(box.getInt("bankId"));
				emdRegister.setBank(masBankMaster);
			}
			if(!box.getString("tenderNo").equals("")){
				emdRegister.setTenderNo(box.getString("tenderNo"));
			}
			if(!box.getString("soNo").equals("")){
				emdRegister.setSoNo(box.getString("soNo"));
			}
			if(!box.getString("organisation").equals("")){
				emdRegister.setOrganization(box.getString("organisation"));
			}
			if(!box.getString("date").equals("")){
				emdRegister.setDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
			}
			if(!box.getString("fromDate").equals("")){
				emdRegister.setFromDate(HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
			}
			if(!box.getString("amount").equals("")){
				emdRegister.setEmdAmount(new BigDecimal(box.getString("amount")));
			}
			if(!box.getString("toDate").equals("")){
				emdRegister.setToDate(HMSUtil.convertStringTypeDateToDateType(box.getString("toDate")));
			}
			if(!box.getString("remarks").equals("")){
				emdRegister.setRemarks(box.getString("remarks"));
			}
		
			emdRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			emdRegister.setLastChgTime(time);
			emdRegister.setStatus("y");
			if(box.getInt("userId") != 0){
				Users user = new Users();
				user.setId(box.getInt("userId"));
				emdRegister.setLastChgBy(user);
			}
			if(box.getInt("locationId") != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("locationId"));
				emdRegister.setLocation(masHospital);
			}

			hbt.save(emdRegister);
			emdRegId=emdRegister.getId();
			saved = true;
			} catch (Exception e) {
				emdRegId=0;
			e.printStackTrace();
		}
			bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
			emdRegisterList = session.createCriteria(FaEmdRegister.class).add(Restrictions.eq("Status", "y")).list();
			map.put("saved", saved);
			map.put("emdRegisterList", emdRegisterList);
			map.put("bankList", bankList);
			map.put("emdRegId", emdRegId);
			return map;
		}
		@Override
		public Map<String, Object> editEMDRegister(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FaEmdRegister> emdRegisterList = new ArrayList<FaEmdRegister>();
			List<FaEmdRegister> emdRegisterIdList = new ArrayList<FaEmdRegister>();
			List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
			Session session = (Session)getSession();
			emdRegisterIdList = session.createCriteria(FaEmdRegister.class).add(Restrictions.idEq(box.getInt("emdRegisterId"))).add(Restrictions.eq("Status", "y")).list();
			emdRegisterList = session.createCriteria(FaEmdRegister.class).add(Restrictions.eq("Status", "y")).list();
			bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
			map.put("bankList", bankList);
			map.put("emdRegisterList", emdRegisterList);
			map.put("emdRegisterIdList", emdRegisterIdList);
			return map;
		}
}
