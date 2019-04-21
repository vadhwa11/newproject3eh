package jkt.hrms.masters.dataservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.MstrCode;
import jkt.hrms.masters.business.MstrStandardAllowance;

import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EtravelMasterDataServiceImpl extends HibernateDaoSupport implements EtravelMasterDataService {
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showETravelMasterJsp() {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MstrCode> searchMstrCodeMasterList=new ArrayList<MstrCode>();
		
		searchMstrCodeMasterList = getHibernateTemplate().find("from jkt.hrms.masters.business.MstrCode");
		map.put("searchMstrCodeMasterList", searchMstrCodeMasterList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchExpenseHead(String expenseCode,String expenseDesc) {
		List<MstrCode> searchMstrCodeMasterList=new ArrayList<MstrCode>();
		Map<String,Object>  expenseHeadFieldsMap = new HashMap<String,Object>();
		
		try{
			if((expenseDesc!=null) || (expenseCode==null)){
				searchMstrCodeMasterList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrCode as i where i.CodeDesc like '"+ expenseDesc+"%' order by i.CodeDesc");
			} else {
				searchMstrCodeMasterList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrCode as i where i.ExpenseCode like '"+ expenseCode+"%' order by i.ExpenseCode");
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
	
		expenseHeadFieldsMap.put("searchMstrCodeMasterList",searchMstrCodeMasterList);
		return expenseHeadFieldsMap;	
	}
	@SuppressWarnings("unchecked")
	public boolean addExpenseHead(MstrCode mstrCode) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrCode);
		hbt.refresh(mstrCode);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@SuppressWarnings("unchecked")
	public boolean editExpenseHead(Map<String, Object> generalMap) {

		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		String expenseHead="";
		String expenseCode="";
		String comments = "";
		int mstrCodeId=0;
		int changedBy = 0;
		mstrCodeId=(Integer)generalMap.get("id");
		expenseCode=(String)generalMap.get("expenseCode");
		expenseHead=(String)generalMap.get("name");
		comments=(String)generalMap.get("comments");
		String fiftyPercentExpnse = "";
		if(generalMap.get("fiftyPercentExpnse")!= null){
			fiftyPercentExpnse = (String)generalMap.get("fiftyPercentExpnse");
		}
		changedBy = (Integer)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		MstrCode mstrCode = (MstrCode)getHibernateTemplate().load(MstrCode.class,mstrCodeId);
		
		mstrCode.setExpenseCode(expenseCode);
		mstrCode.setCodeType("ExpType");
		mstrCode.setCodeDesc(expenseHead);
		mstrCode.setCodeRemarks(comments);
		mstrCode.setFiftyPercentExpensePaid(fiftyPercentExpnse);
		mstrCode.setStatus("y");

		Users users = new Users();
		users.setId(changedBy);
		mstrCode.setLastChgBy(users);

		mstrCode.setLastChgDate(currentDate);
		mstrCode.setLastChgTime(currentTime);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrCode);
		hbt.refresh(mstrCode);
		dataUpdated = true;
		return dataUpdated;
	}
	@SuppressWarnings("unchecked")
	public boolean deleteExpenseHead(int mstrCodeId,Map<String, Object> generalMap) {

		boolean dataDeleted=false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrCode mstrCode= new MstrCode();
		mstrCode = (MstrCode)getHibernateTemplate().load(MstrCode.class,mstrCodeId);

		changedBy = (Integer)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		
		if(generalMap.get("flag") != null){
			String flag = (String)generalMap.get("flag");
			if (flag.equals("InActivate")){
				mstrCode.setStatus("n");
				dataDeleted=true;
			}else if(flag.equals("Activate")){
				mstrCode.setStatus("y");
				dataDeleted=false;
			}
		}
		Users users = new Users();
		users.setId(changedBy);
		mstrCode.setLastChgBy(users);
		
		mstrCode.setLastChgDate(currentDate);
		mstrCode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrCode);
		hbt.refresh(mstrCode);
		return dataDeleted;
	
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showStandardAllowanceMasterJsp() {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MstrStandardAllowance> searchMstrStandardAllowanceList=new ArrayList<MstrStandardAllowance>();
		List<MasRank> masRankList=new ArrayList<MasRank>();
		List<MasRankCategory> masRankCategoryList=new ArrayList<MasRankCategory>();
		List<MasCurrency> masCurrencyList=new ArrayList<MasCurrency>();
		List<MstrCode> expenseAndTripTypeList=new ArrayList<MstrCode>();
		
		searchMstrStandardAllowanceList = getHibernateTemplate().find("from jkt.hrms.masters.business.MstrStandardAllowance");
		Session session = (Session)getSession();
		
		masRankCategoryList = session.createCriteria(MasRankCategory.class)
							.add(Restrictions.eq("Status", "y"))
							.list();
		
		masRankList = session.createCriteria(MasRank.class)
							.add(Restrictions.eq("Status", "y"))
							.list();
		
		expenseAndTripTypeList = session.createCriteria(MstrCode.class)
									.add(Restrictions.or(
											Restrictions.eq("CodeType", "ExpType"), 
											Restrictions.eq("CodeType", "trip")))
											.add(Restrictions.eq("Status", "y"))
									.list();
		masCurrencyList = session.createCriteria(MasCurrency.class)
								.add(Restrictions.eq("Status", "y"))
								.list();
		
		
		map.put("searchMstrStandardAllowanceList", searchMstrStandardAllowanceList);
		map.put("masRankList", masRankList);
		map.put("masRankCategoryList", masRankCategoryList);
		map.put("expenseAndTripTypeList", expenseAndTripTypeList);
		map.put("masCurrencyList", masCurrencyList);
		
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchStandardAllowance(String standardAllowanceCode,String standardAllowanceDesc) {
		List<MstrStandardAllowance> searchMstrStandardAllowanceList=new ArrayList<MstrStandardAllowance>();
		Map<String,Object>  standardAllowanceFieldsMap = new HashMap<String,Object>();
		List<MasRank> masRankList=new ArrayList<MasRank>();
		List<MasCurrency> masCurrencyList=new ArrayList<MasCurrency>();
		List<MstrCode> expenseAndTripTypeList=new ArrayList<MstrCode>();

		try{
			if((standardAllowanceDesc!=null) || (standardAllowanceCode==null)){
				searchMstrStandardAllowanceList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrStandardAllowance as i where i.AllowanceDesc like '"+ standardAllowanceDesc+"%' order by i.AllowanceDesc");
			} else {
				searchMstrStandardAllowanceList=getHibernateTemplate().find("from jkt.hrms.masters.business.MstrStandardAllowance as i where i.AllowanceCode like '"+ standardAllowanceCode+"%' order by i.AllowanceCode");
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
	
		Session session = (Session)getSession();
		
		masRankList = session.createCriteria(MasRank.class)
		.add(Restrictions.eq("Status", "y"))
		.list();

		
		expenseAndTripTypeList = session.createCriteria(MstrCode.class)
									.add(Restrictions.and(
											Restrictions.eq("CodeType", "ExpType"), 
											Restrictions.eq("CodeType", "trip")))
											.add(Restrictions.eq("Status", "y"))
									.list();
		masCurrencyList = session.createCriteria(MasCurrency.class)
								.add(Restrictions.eq("Status", "y"))
								.list();
		
		standardAllowanceFieldsMap.put("searchMstrStandardAllowanceList", searchMstrStandardAllowanceList);
		standardAllowanceFieldsMap.put("masRankList", masRankList);
		standardAllowanceFieldsMap.put("expenseAndTripTypeList", expenseAndTripTypeList);
		standardAllowanceFieldsMap.put("masCurrencyList", masCurrencyList);
		
		return standardAllowanceFieldsMap;	
	}
	@SuppressWarnings("unchecked")
	public boolean addStandardAllowance(MstrStandardAllowance mstrStandardAllowance) {
		boolean successfullyAdded=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(mstrStandardAllowance);
		hbt.refresh(mstrStandardAllowance);
		successfullyAdded = true;
		return successfullyAdded;
	}
	@SuppressWarnings("unchecked")
	public boolean editStandardAllowance(Map<String, Object> generalMap) {

		boolean dataUpdated=false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");

		String name="";
		String code="";
		int mstrStandardAllowanceId=0;
		int changedBy = 0;

		int rankId = 0;
		int expenseType = 0;
		int trip = 0;
		int currency = 0;
		BigDecimal amount = BigDecimal.ZERO;
		String districtType = "";
		mstrStandardAllowanceId=(Integer)generalMap.get("id");
		code=(String)generalMap.get("code");
		name=(String)generalMap.get("name");
		rankId=(Integer)generalMap.get("rankId");
		expenseType=(Integer)generalMap.get("expenseType");
		trip=(Integer)generalMap.get("trip");
		currency=(Integer)generalMap.get("currency");
		amount=(BigDecimal)generalMap.get("amount");
		if(generalMap.get("districtType")!= null){
			districtType = (String)generalMap.get("districtType");
		}
		changedBy = (Integer)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		
		MstrStandardAllowance mstrStandardAllowance = (MstrStandardAllowance)getHibernateTemplate().load(MstrStandardAllowance.class,mstrStandardAllowanceId);
		
		mstrStandardAllowance.setAllowanceCode(code);
		mstrStandardAllowance.setAllowanceDesc(name);
		
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		mstrStandardAllowance.setRank(masRank);
		
		MstrCode mstrCode = new MstrCode();
		mstrCode.setId(expenseType);
		mstrStandardAllowance.setExpenseType(mstrCode);
		
		MstrCode mstrCodeForTrip = new MstrCode();
		mstrCodeForTrip.setId(trip);
		mstrStandardAllowance.setTrip(mstrCodeForTrip);

		MasCurrency masCurrency = new MasCurrency();
		masCurrency.setId(currency);
		mstrStandardAllowance.setCurrency(masCurrency);
		
		mstrStandardAllowance.setAmount(amount);
		mstrStandardAllowance.setCityTypeFlag(districtType);
		mstrStandardAllowance.setStatus("y");

		Users users = new Users();
		users.setId(changedBy);
		mstrStandardAllowance.setLastChgBy(users);

		mstrStandardAllowance.setLastChgDate(currentDate);
		mstrStandardAllowance.setLastChgTime(currentTime);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrStandardAllowance);
		hbt.refresh(mstrStandardAllowance);
		dataUpdated = true;
		return dataUpdated;
	}
	@SuppressWarnings("unchecked")
	public boolean deleteStandardAllowance(int mstrStandardAllowanceId,Map<String, Object> generalMap) {

		boolean dataDeleted=false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		MstrStandardAllowance mstrStandardAllowance= new MstrStandardAllowance();
		mstrStandardAllowance = (MstrStandardAllowance)getHibernateTemplate().load(MstrStandardAllowance.class,mstrStandardAllowanceId);

		changedBy = (Integer)generalMap.get("changedBy");
		currentDate=(Date)generalMap.get("currentDate");
		currentTime=(String)generalMap.get("currentTime");
		
		if(generalMap.get("flag") != null){
			String flag = (String)generalMap.get("flag");
			if (flag.equals("InActivate")){
				mstrStandardAllowance.setStatus("n");
				dataDeleted=true;
			}else if(flag.equals("Activate")){
				mstrStandardAllowance.setStatus("y");
				dataDeleted=false;
			}
		}
		Users users = new Users();
		users.setId(changedBy);
		mstrStandardAllowance.setLastChgBy(users);
		
		mstrStandardAllowance.setLastChgDate(currentDate);
		mstrStandardAllowance.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(mstrStandardAllowance);
		hbt.refresh(mstrStandardAllowance);
		return dataDeleted;
	
	}

}
