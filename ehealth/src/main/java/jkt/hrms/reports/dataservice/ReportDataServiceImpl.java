package jkt.hrms.reports.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hrms.masters.business.HrMasFinancialYear;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.Holidaycalendar;
import jkt.hrms.masters.business.HrMasLeave;
import jkt.hrms.masters.business.HrMasLeaveTypeMediator;
import jkt.hrms.masters.business.HrMasLocation;
import jkt.hrms.masters.business.HrMasReimbersement;
import jkt.hrms.masters.business.MasEmployeeType;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.MstrProject;
import jkt.hrms.masters.business.MstrPtvisit;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.masters.business.MstrSponsor;
import jkt.hrms.masters.business.MstrTask;
import jkt.hrms.masters.business.MstrTherapeutic;
import jkt.hrms.masters.business.PrjAddPtDetail;
import jkt.hrms.masters.business.PrjAddPtHeader;
import jkt.hrms.masters.business.PrjFesStudyHeader;
import jkt.hrms.masters.business.PrjRoleResMappingDetail;
import jkt.hrms.masters.business.PrjRoleResMappingHeader;
import jkt.hrms.masters.business.PrjSiteMilestone;
import jkt.hrms.masters.business.TblFreezeTimeSheet;
import jkt.hrms.masters.business.Tbltimesheet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ReportDataServiceImpl extends HibernateDaoSupport implements
		ReportDataService {

	public Map<String, Object> showPrintHrEmployeeExpirience() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();

		try {
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y")).list();
			map.put("employeeList", employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> showPrintReimbursement() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();

		try {
			List<HrMasReimbersement> reimbursementList = new ArrayList<HrMasReimbersement>();
			for (HrMasReimbersement hrMasReimbersement : reimbursementList) {
				hrMasReimbersement.getReimbCode();
				hrMasReimbersement.getReimbDesc();
				hrMasReimbersement.getMaxAmount();
				hrMasReimbersement.getTaxable();
			}
			reimbursementList = session
					.createCriteria(HrMasReimbersement.class).list();
			map.put("reimbursementList", reimbursementList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({ "unused", "unchecked", "unused" })
	public Map<String, Object> showPrintLeaveStatement() {
		Map map = new HashMap();
		Session session = getSession();

		try {
			List<HrMasLeave> leaveList = new ArrayList<HrMasLeave>();
			List<HrMasLeaveTypeMediator> leaveTypeMediatorList = new ArrayList<HrMasLeaveTypeMediator>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			leaveTypeMediatorList = session.createCriteria(
					HrMasLeaveTypeMediator.class).list();
			employeeList = session.createCriteria(MasEmployee.class).addOrder(Order.asc("EmployeeName"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("leaveTypeMediatorList", leaveTypeMediatorList);
			map.put("employeeList", employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> showEmployeeLeaveCard() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();

		try {
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y")).list();
			map.put("employeeList", employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> showEmployeeLeaveStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showloanstatement() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();

		try {
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y")).list();
			map.put("employeeList", employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> showEmployeLeaveStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showEmployeeLeaveStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showpayscale() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		Session session = getSession();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y")).list();
		gradeList = session.createCriteria(MasGrade.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("gradeList", gradeList);
		return map;
	}
	
// added by Ramdular from Clinirx 02/02/2011 ++++++++++++++++++++++++++++	
	
	public Map<String, Object> showEmployeeLeaveTypeReport() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		
		employeeList=session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y"))
					//.addOrder(Order.asc("FirstName"))
					.list();
		hospitalList=session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Status", "y"))
					.list();

		map.put("employeeList", employeeList);
		map.put("hospitalList", hospitalList);
		return map;
	}
	
	public Map<String, Object> showDepartmentJsp() {
		Map<String, Object> map=new HashMap<String, Object>();
		List departmentList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		List employeeList = getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");
		List companyList =  getHibernateTemplate().find( "from jkt.hms.masters.business.MasHospital as mh where mh.Status = 'y'");
		
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("companyList", companyList);
		return map;
	}
	public Map showEmployeeWiseSheetJsp(int employeeId) {
		Map<String, Object> map=new HashMap<String, Object>();
		List departmentList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		List employeeList = getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y' and mc.LineManager.Id ='"+employeeId+"' ");
		List companyList =  getHibernateTemplate().find( "from jkt.hms.masters.business.MasHospital as mh where mh.Status = 'y'");
		List<MasEmployee> employeeListForMyTimeSheet = getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y' and mc.Id ='"+employeeId+"' ");
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		int departmentId = 0;
		if(employeeListForMyTimeSheet.size()>0){
			for(MasEmployee masEmployee : employeeListForMyTimeSheet){
				departmentId = masEmployee.getDepartment().getId();
			}
		}
		empList = getHibernateTemplate().find( "from jkt.hms.masters.business.MasEmployee as mc where mc.Status = 'y'");

		List departmentListForMyTimeSheet =getHibernateTemplate().find( "from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y' and mc.Id = '"+departmentId+"'");
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("companyList", companyList);
		map.put("employeeListForMyTimeSheet", employeeListForMyTimeSheet);
		map.put("departmentListForMyTimeSheet", departmentListForMyTimeSheet);
		map.put("empList", empList);
		return map;
	}
	
	
	
	public Map<String, Object> showStatusWiseTimeSheetReportJsp() {
		Map<String, Object> map=new HashMap<String, Object>();
		List departmentList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasDepartment as mc where mc.Status = 'y'");
		
		Criteria criteria = getSession().createCriteria(Tbltimesheet.class);
		criteria = criteria.add(Restrictions.ne("Status", "Saved"));
		map.put("departmentList", departmentList);
		return map;
	}
	
	public Map<String, Object> showEmployeeList() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session = (Session)getSession();
		try
		{
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasLocation> locationList = new ArrayList<MasLocation>();
		
		employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y" )).list();
		locationList = session.createCriteria(MasLocation.class).add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("rankList", rankList);
		map.put("locationList", locationList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object> showTimeSheetProjectWiseJsp(int employeeId) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session = (Session)getSession();
		List masProjectList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrProject");
		List masTaskList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTask");
		Criteria crit = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", employeeId));
		crit.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("Prj"))));
		masProjectList = crit.list();
		map.put("masProjectList", masProjectList);
		map.put("masTaskList", masTaskList);
		
		return map;
	}
	
	public Map<String, Object> showTimeSheetTaskWiseJsp() {
		Map<String, Object> map=new HashMap<String, Object>();
		List masProjectList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrProject");
		List masTaskList=getHibernateTemplate().find( "from jkt.hrms.masters.business.MstrTask");
		map.put("masProjectList", masProjectList);
		map.put("masTaskList", masTaskList);
		
		return map;
	}
	
	public List<MstrTask> getTaskList(Integer projectId)
	{
		List taskList = new ArrayList();
			Session session = (Session)getSession();
			Map map = new HashMap();
		//List<PrjResMap> prjMesMapList = session.createCriteria(PrjResMap.class).createAlias("Prj", "prjid").add(Restrictions.eq("prjid.Id", projectId)).list();
			List<PrjRoleResMappingDetail> prjMesMapList = new ArrayList<PrjRoleResMappingDetail>();
			prjMesMapList = session.createCriteria(PrjRoleResMappingDetail.class).createAlias("RoleResMappingHeader", "header").createAlias("header.Prj", "prjid").add(Restrictions.eq("prjid.Id", projectId))
			.list();
			String task="";
			java.util.Set<Integer> tskSet= new java.util.HashSet<Integer>();
			if(prjMesMapList!=null && prjMesMapList.size()>0){
			for(PrjRoleResMappingDetail obj:prjMesMapList)
			{
				if(obj.getTask() != null){
					tskSet.add(obj.getTask().getId());	
				}
				
			}
			 taskList = session.createCriteria(MstrTask.class).add(Restrictions.in("Id",tskSet)).list();
			}
			
		return taskList;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object>showEmpExpSummary() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrMasLocation> masLocationList = new ArrayList<HrMasLocation>();
		
		try{
			List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			employeeList=session.createCriteria(MasEmployee.class)
								.add(Restrictions.eq("Status", "y"))
								.list();
			departmentList = session.createCriteria(MasDepartment.class)
								.add(Restrictions.eq("Status", "y"))
								.list();	
			masLocationList = session.createCriteria(HrMasLocation.class)
								.add(Restrictions.eq("Status", "y"))
								.list();
			
			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
			map.put("masLocationList", masLocationList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object>showEmpServiceCard() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			employeeList=session.createCriteria(MasEmployee.class)
						.add(Restrictions.eq("Status", "y"))
						.list();
			map.put("employeeList", employeeList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object>showEmployeeTypeReport() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<MasEmployeeType>employeeTypeList=new ArrayList<MasEmployeeType>();
			employeeTypeList=session.createCriteria(MasEmployeeType.class).add(Restrictions.eq("Status", "y")).list();
			map.put("employeeTypeList", employeeTypeList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object>showEmpPerformanceReviewCard() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			map.put("employeeList", employeeList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object>showEmpCTCAnnexure() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			map.put("employeeList", employeeList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object>showEmpSalaryComp() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			map.put("departmentList", departmentList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	//===========Regarding IT & PF by Vishal=====Start================
	
	//-----------------Employee Investment---------------------
	public Map<String, Object>showEmployeeInvestment() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			hrMasFinancialYearList=session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("YearDescription")).list();
			map.put("employeeList", employeeList);
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
			}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//--------TDS Statement--------------------------------------------
	
	public Map<String, Object>showTDSStatement() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
			hrMasFinancialYearList=session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("YearDescription")).list();
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
			}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//-----------------For Income Tax sheet and Form3A ---------------------
	public Map<String, Object>showIncomeTaxSheet() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
			employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			hrMasFinancialYearList=session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("YearDescription")).list();
			map.put("employeeList", employeeList);
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
			}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//-----------------Form 6A  ---------------------
	public Map<String, Object>showForm6A() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		
		try{
			List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
			hrMasFinancialYearList=session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("YearDescription")).list();
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
			}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//-----------------TDS Deposit ---------------------
	public Map<String, Object>showTDSDeposit() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		try{

			List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
			hrMasFinancialYearList=session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("YearDescription")).list();
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
			
			//--
			//	MasHospital hospital =(MasHospital)getHibernateTemplate().load(MasHospital.class , hospitalId);
			//		map.put("hospital",hospital);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//-----------------PF Statement ---------------------
	public Map<String, Object>showPFStatement() {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		try{

			List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
			hrMasFinancialYearList=session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("YearDescription")).list();
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public int getMinHrsForTimeSheet(int noOfDays,int countOfSatSun, Date fromDate,Date toDate)
	{
		int count= 0;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		int firstday = cal.get(Calendar.DATE);
		int endOfFromMonth = cal.getActualMaximum(Calendar.DATE);
		//int noOfDaysOfFromMonth = endOfFromMonth-firstday;
		int fromMonth = (cal.get(Calendar.MONTH))+1;
		int fromYear = (cal.get(Calendar.YEAR));
		
		
		
		cal.setTime(toDate);
		int toMonth = (cal.get(Calendar.MONTH))+1;
		int toYear = (cal.get(Calendar.YEAR));
		if(fromMonth==toMonth && fromYear==toYear)
		{
			TblFreezeTimeSheet obj = (TblFreezeTimeSheet)getSession().createCriteria(TblFreezeTimeSheet.class).add(Restrictions.eq("Year", fromYear+"")).add(Restrictions.eq("Month", fromMonth+"")).uniqueResult();
			if(obj!=null && obj.getMinTime()!=null)
			{
				count = noOfDays * new Integer(obj.getMinTime());
			}
		}else{
			TblFreezeTimeSheet obj = (TblFreezeTimeSheet)getSession().createCriteria(TblFreezeTimeSheet.class).add(Restrictions.eq("Year", toYear+"")).add(Restrictions.eq("Month", toMonth+"")).uniqueResult();
			if(obj!=null && obj.getMinTime()!=null)
			{
				count = noOfDays * new Integer(obj.getMinTime());
			}
		}
		return count;
	}
//==================Project Tracking Report====================================
	public Map<String, Object> showPIReport(){
		Map<String, Object>  map=new HashMap<String, Object>();
		List<MstrTherapeutic> therapeuticList = new ArrayList<MstrTherapeutic>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		
		Session session = (Session)getSession();
		therapeuticList=session.createCriteria(MstrTherapeutic.class).add(Restrictions.eq("Status", "y")).list();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.eq("Status", "y")).list();
		
		map.put("therapeuticList", therapeuticList);
		map.put("projectList", projectList);
		return map;
   }
	@SuppressWarnings("unchecked")
	public Map<String, Object> showProjectResourceTimeReport(){
		Map<String, Object>  map=new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MstrSponsor> sponsorList = new ArrayList<MstrSponsor>();
		List<MstrSiteHeader> mstrSiteHeaderList = new ArrayList<MstrSiteHeader>();
		
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.eq("Status", "y")).list();
		
		/*employeeList = session.createCriteria(MasEmployee.class)
										.add(Restrictions.eq("Status", "y")).list();

		sponsorList = session.createCriteria(MstrSponsor.class)
						.add(Restrictions.eq("Status", "y")).list();

		mstrSiteHeaderList = session.createCriteria(MstrSiteHeader.class)
					.add(Restrictions.eq("Status", "y")).list();*/

		//map.put("sponsorList", sponsorList);
		//map.put("mstrSiteHeaderList", mstrSiteHeaderList);
		map.put("projectList", projectList);
		//map.put("employeeList", employeeList);
		return map;
   }
	public Map<String, Object> showProjectSiteAllocationReport(){
		Map<String, Object>  map=new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		
		Session session = (Session)getSession();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		
		map.put("departmentList", departmentList);
		return map;
   }
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDepartmentForCompany(Map<String, Object> mapForDs) {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		int hospitalId = 0;
		if(mapForDs.get("hospitalId") != null
				&& !mapForDs.get("hospitalId").equals("")){
			hospitalId = (Integer)mapForDs.get("hospitalId");
			
		}
		departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();

		map.put("departmentList", departmentList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getEmpForDepartment(Map<String, Object> mapForDs) {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		int departId = 0;
		if(mapForDs.get("departId") != null
				&& !mapForDs.get("departId").equals("")){
			departId = (Integer)mapForDs.get("departId");
		}
		empList=session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("Department.Id", departId))
					.list();

		map.put("empList", empList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientEnrollmentJsp(Map<String, Object> mapForDs){
		Map<String, Object>  map=new HashMap<String, Object>();
		
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> mstrSiteHeaderList = new ArrayList<MstrSiteHeader>();
		
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class)
								.add(Restrictions.eq("Status", "y"))
								.list();
		
		mstrSiteHeaderList = session.createCriteria(MstrSiteHeader.class)
								.add(Restrictions.eq("Status", "y"))
								.list();

		map.put("mstrSiteHeaderList", mstrSiteHeaderList);
		map.put("projectList", projectList);
		return map;
   }
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> printPatientEnrollmentReportExcel(Map<String, Object> mapForDs){
	    Session session = (Session)getSession();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    int projectId = 0;
	    int siteId = 0;
	    Date fromDate = null;
	    Date toDate = null;
	    
	    if(mapForDs.get("projectId") != null){
	    	projectId = (Integer)mapForDs.get("projectId");
	    }
	    if(mapForDs.get("siteId") != null){
	    	siteId = (Integer)mapForDs.get("siteId");
	    }
	    if(mapForDs.get("fromDate") != null){
	    	fromDate = (Date)mapForDs.get("fromDate");
	    }
	    if(mapForDs.get("toDate") != null){
	    	toDate = (Date)mapForDs.get("toDate");
	    }
	    
		 SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		 String fromDateString = sdf.format(fromDate);
		 String toDateString = sdf.format(toDate);
	    
	    List<Object[]> prjStatusSumList = new ArrayList<Object[]>();
	    List<Object[]> prjStatusList = new ArrayList<Object[]>();
/*	    List<MstrPtvisit> mstrPtvisitList = new ArrayList<MstrPtvisit>();*/
		List<MstrProject> mstrProjectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> mstrSiteHeaderList = new ArrayList<MstrSiteHeader>();
		
/*		mstrPtvisitList = session.createCriteria(MstrPtvisit.class)
								.add(Restrictions.eq("Status", "y"))
								.list();*/
	
		mstrProjectList = session.createCriteria(MstrProject.class)
									.add(Restrictions.eq("Id", projectId))
									.list();

		mstrSiteHeaderList = session.createCriteria(MstrSiteHeader.class)
									.add(Restrictions.eq("Id", siteId))
									.list();

		
		String projectCode = mstrProjectList.get(0).getPrjCode();
		String projectName = mstrProjectList.get(0).getPrjName();
		
		String siteCode = mstrSiteHeaderList.get(0).getSiteCode();
		String siteName = mstrSiteHeaderList.get(0).getSiteName();
		String hospitalName = mstrProjectList.get(0).getHospital().getHospitalName();
		
/*		for(PrjAddPtDetail prjAddPtDetail : prjAddPtDetailList){
			prjAddPtDetail.getPv().getPatientVisit().getPatientVisitName();
			
		}*/
		
		try{
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("PatientEnrollmentReport");
			
			// Create a new font and alter it.
			
			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);
			//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			
			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	
			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);
			
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);
			
			//style1.setLocked(true);
	
			HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue(new HSSFRichTextString(hospitalName));
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));
	
			HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue(new HSSFRichTextString("Patient Enrollment Report"));
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));
	
			HSSFRow row4 = sheet.createRow((short) 4);
				HSSFCell cell40 = row4.createCell((short) 1);
				cell40.setCellStyle(style1);
				cell40.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(4, (short) 1, 4, (short) 7));
	
			HSSFRow row5 = sheet.createRow((short) 5);
				HSSFCell cell51 = row5.createCell((short) 1);
				cell51.setCellValue(new HSSFRichTextString("From  :"));

				HSSFCell cell52 = row5.createCell((short) 3);
				cell52.setCellValue(new HSSFRichTextString(fromDateString));
				
				HSSFCell cell53 = row5.createCell((short) 4);
				cell53.setCellValue(new HSSFRichTextString("To  :"));

				HSSFCell cell56 = row5.createCell((short) 6);
				cell56.setCellValue(new HSSFRichTextString(toDateString));
				
				//sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));
				
			HSSFRow headingRow1 = sheet.createRow((short) 6);
				HSSFCell cell62 = headingRow1.createCell((short) 1);
				cell62.setCellValue(new HSSFRichTextString("Project Code:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));

				HSSFCell cell63 = headingRow1.createCell((short) 3);
				cell63.setCellValue(new HSSFRichTextString(projectCode));

				HSSFCell cell64 = headingRow1.createCell((short) 4);
				cell64.setCellValue(new HSSFRichTextString("Project Name:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(6, (short) 4, 6, (short) 5));

				HSSFCell cell66 = headingRow1.createCell((short) 6);
				cell66.setCellValue(new HSSFRichTextString(projectName));

			HSSFRow headingRow2 = sheet.createRow((short) 7);
				HSSFCell cell72 = headingRow2.createCell((short) 1);
				cell72.setCellValue(new HSSFRichTextString("Site Code:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(7, (short) 1, 7, (short) 2));

				HSSFCell cell73 = headingRow2.createCell((short) 3);
				cell73.setCellValue(new HSSFRichTextString(siteCode));

				HSSFCell cell74 = headingRow2.createCell((short) 4);
				cell74.setCellValue(new HSSFRichTextString("Site Name:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(7, (short) 4, 7, (short) 5));

				HSSFCell cell76 = headingRow2.createCell((short) 6);
				cell76.setCellValue(new HSSFRichTextString(siteName));
				
				
			HSSFRow headingRow3 = sheet.createRow((short) 8);
				HSSFCell cell82 = headingRow3.createCell((short) 1);
				cell82.setCellValue(new HSSFRichTextString(""));
			
			HSSFRow headingRow4 = sheet.createRow((short) 9);
				HSSFCell cell91 = headingRow4.createCell((short) 1);
				cell91.setCellValue(new HSSFRichTextString("Description"));
				cell91.setCellStyle(style);
				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(9, (short) 1, 10, (short) 1));
				
				
				HSSFCell cell93 = headingRow4.createCell((short) 3);
				cell93.setCellValue(new HSSFRichTextString("Visit Name"));
				cell93.setCellStyle(style);
				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				//sheet.addMergedRegion(new Region(9, (short) 1, 10, (short) 2));
			
			HSSFRow headingRowVisitNames = sheet.createRow((short) 10);
				HSSFCell cellblank1 = headingRowVisitNames.createCell((short) 1);
				cellblank1.setCellValue(new HSSFRichTextString(""));
				cellblank1.setCellStyle(style);
				
			HSSFRow headingRow5 = sheet.createRow((short) 11);
				HSSFCell cell102 = headingRow5.createCell((short) 1);
				cell102.setCellValue(new HSSFRichTextString("Completed"));
				
				
			HSSFRow headingRow6 = sheet.createRow((short) 12);
				HSSFCell cell112 = headingRow6.createCell((short) 1);
				cell112.setCellValue(new HSSFRichTextString("Failed"));

			HSSFRow headingRow7 = sheet.createRow((short) 13);
				HSSFCell cell122 = headingRow7.createCell((short) 1);
				cell122.setCellValue(new HSSFRichTextString("Backed Out"));

            List<Object[]> visitSumGroupDifferentList = new ArrayList<Object[]>();
            Map<String,List<Object[]>> listMap = new HashMap<String, List<Object[]>>();
            
           
			prjStatusSumList = session.createCriteria(PrjAddPtDetail.class)
							.createAlias("AddPtHeader", "addPtHeader")
							.createAlias("addPtHeader.Prj", "prjHd")
							.createAlias("addPtHeader.SiteHeader", "siteHd")
							.createAlias("Pv", "pv")
							.createAlias("pv.PatientVisit", "patientVisit")
							.add(Restrictions.eq("prjHd.Id", projectId))
							.add(Restrictions.eq("siteHd.Id", siteId))
							.add(Restrictions.between("addPtHeader.InitialVisitDate", fromDate, toDate)) 
							//.add(Restrictions.eq("patientVisit.Id", mstrPtvisit.getId()))
							.setProjection(Projections.projectionList()
									.add(Projections.groupProperty("patientVisit.PatientVisitName"))
									.add(Projections.groupProperty("ScheduleStatus"))
									.add(Projections.count("ScheduleStatus")))
							.list();
			
			int counterVisit = 0;
			List<String> visitNameList = new ArrayList<String>();
			
            if(prjStatusSumList.size() > 0){
            	visitSumGroupDifferentList.add(prjStatusSumList.get(0));
            	listMap.put(prjStatusSumList.get(0)[0].toString(),visitSumGroupDifferentList);
            	visitNameList.add(prjStatusSumList.get(0)[0].toString());
            	
            	for(int loop = 0; loop < prjStatusSumList.size()-1; loop++){
            		if(!(prjStatusSumList.get(loop)[0]).equals(prjStatusSumList.get(loop+1)[0])){
            			counterVisit++;
            			visitSumGroupDifferentList = new ArrayList<Object[]>();
            			visitSumGroupDifferentList.add(prjStatusSumList.get(loop+1));
            			
            			visitNameList.add(prjStatusSumList.get(loop+1)[0].toString());
            			listMap.put(prjStatusSumList.get(loop+1)[0].toString(),visitSumGroupDifferentList);
            		}else{
            			visitSumGroupDifferentList.add(prjStatusSumList.get(loop+1));
            		}
            	}
            }
            for(String visitName : visitNameList){
				HSSFCell cell = HMSUtil.getNextCell(headingRowVisitNames);
				cell.setCellValue(new HSSFRichTextString(visitName));
				
				boolean completed = false;
				boolean failed = false;
				boolean backedOut = false;
				prjStatusList = listMap.get(visitName); 
					
				for(int ilop=0; ilop < prjStatusList.size(); ilop++) {
					prjStatusList = listMap.get(visitName);
					if(prjStatusList.get(ilop)[1] != null 
							&& ((String)prjStatusList.get(ilop)[1]).equalsIgnoreCase("completed")){
						Integer sumCompleted = ((Integer)prjStatusList.get(ilop)[2]);
						HSSFCell cellCompleted = HMSUtil.getNextCell(headingRow5);
						cellCompleted.setCellValue(sumCompleted.doubleValue());
						
						completed = true;
					}
					if(prjStatusList.get(ilop)[1] != null
							&& ((String)prjStatusList.get(ilop)[1]).equalsIgnoreCase("failed")){
						Integer sumFailed = ((Integer)prjStatusList.get(ilop)[2]);
						HSSFCell cellFailed = HMSUtil.getNextCell(headingRow6);
						cellFailed.setCellValue(sumFailed.doubleValue());
						
						failed = true;
					}
					if(prjStatusList.get(ilop)[1] != null
							&& ((String)prjStatusList.get(ilop)[1]).equalsIgnoreCase("backed-out")){
						Integer sumBackedOut = ((Integer)prjStatusList.get(ilop)[2]);
						HSSFCell cellBackedOut = HMSUtil.getNextCell(headingRow7);
						cellBackedOut.setCellValue(sumBackedOut.doubleValue());
						
						backedOut = true;
					}
				}
				if(!completed){
					HSSFCell cellBackedOutZero = HMSUtil.getNextCell(headingRow5);
					cellBackedOutZero.setCellValue((double)0);
				}
				if(!failed){
					HSSFCell cellFailedZero = HMSUtil.getNextCell(headingRow6);
					cellFailedZero.setCellValue((double)0);
				}
				if(!backedOut){
					HSSFCell cellCompletedZero = HMSUtil.getNextCell(headingRow7);
					cellCompletedZero.setCellValue((double)0);
				}
            }
            
            
/*			for(MstrPtvisit mstrPtvisit : mstrPtvisitList){
					
				HSSFCell cell = HMSUtil.getNextCell(headingRowVisitNames);
				cell.setCellValue(new HSSFRichTextString(mstrPtvisit.getPatientVisitName()));
				
				boolean completed = false;
				boolean failed = false;
				boolean backedOut = false;
				
				for(int ilop=0; ilop < prjStatusSumList.size(); ilop++) {
					if(prjStatusSumList.get(ilop)[0] != null 
							&& ((String)prjStatusSumList.get(ilop)[0]).equalsIgnoreCase("completed")){
						Integer sumCompleted = ((Integer)prjStatusSumList.get(ilop)[1]);
						HSSFCell cellCompleted = HMSUtil.getNextCell(headingRow5);
						cellCompleted.setCellValue(sumCompleted.doubleValue());
						
						completed = true;
					}
					
					if(prjStatusSumList.get(ilop)[0] != null
							&& ((String)prjStatusSumList.get(ilop)[0]).equalsIgnoreCase("failed")){
						Integer sumFailed = ((Integer)prjStatusSumList.get(ilop)[1]);
						HSSFCell cellFailed = HMSUtil.getNextCell(headingRow6);
						cellFailed.setCellValue(sumFailed.doubleValue());
						
						failed = true;
					}

					if(prjStatusSumList.get(ilop)[0] != null
							&& ((String)prjStatusSumList.get(ilop)[0]).equalsIgnoreCase("backed-out")){
						Integer sumBackedOut = ((Integer)prjStatusSumList.get(ilop)[1]);
						HSSFCell cellBackedOut = HMSUtil.getNextCell(headingRow7);
						cellBackedOut.setCellValue(sumBackedOut.doubleValue());
						
						backedOut = true;
					}
				}
				if(!completed){
					HSSFCell cellBackedOutZero = HMSUtil.getNextCell(headingRow5);
					cellBackedOutZero.setCellValue((double)0);
				}
				if(!failed){
					HSSFCell cellFailedZero = HMSUtil.getNextCell(headingRow6);
					cellFailedZero.setCellValue((double)0);
				}
				if(!backedOut){
					HSSFCell cellCompletedZero = HMSUtil.getNextCell(headingRow7);
					cellCompletedZero.setCellValue((double)0);
				}
				
			}*/
			int lastCellNoVisitName = headingRowVisitNames.getLastCellNum();
			//Region(int rowFrom, short colFrom, int rowTo, short colTo)
			sheet.addMergedRegion(new Region(9, (short) 3, 9, (short) lastCellNoVisitName));
			
			map.put("wb", wb);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
   }
	@SuppressWarnings("unchecked")
	public Map<String, Object> printPatientWiseVisitReport(Map<String, Object> mapForDs){
	    Session session = (Session)getSession();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    int projectId = 0;
	    int siteId = 0;
	    Date fromDate = null;
	    Date toDate = null;
	    
	    if(mapForDs.get("projectId") != null){
	    	projectId = (Integer)mapForDs.get("projectId");
	    }
	    if(mapForDs.get("siteId") != null){
	    	siteId = (Integer)mapForDs.get("siteId");
	    }
	    if(mapForDs.get("fromDate") != null){
	    	fromDate = (Date)mapForDs.get("fromDate");
	    }
	    if(mapForDs.get("toDate") != null){
	    	toDate = (Date)mapForDs.get("toDate");
	    }
	    
		 SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		 String fromDateString = sdf.format(fromDate);
		 String toDateString = sdf.format(toDate);
	    
	    List<PrjAddPtHeader> prjAddPtHeaderList = new ArrayList<PrjAddPtHeader>();
		List<MstrPtvisit> mstrPtvisitList = new ArrayList<MstrPtvisit>();
		List<MstrProject> mstrProjectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> mstrSiteHeaderList = new ArrayList<MstrSiteHeader>();
		
		mstrPtvisitList = session.createCriteria(MstrPtvisit.class)
								.add(Restrictions.eq("Status", "y"))
								.addOrder(Order.asc("Id"))
								.list();
	
		mstrProjectList = session.createCriteria(MstrProject.class)
									.add(Restrictions.eq("Id", projectId))
									.list();

		mstrSiteHeaderList = session.createCriteria(MstrSiteHeader.class)
									.add(Restrictions.eq("Id", siteId))
									.list();

		
		String projectCode = mstrProjectList.get(0).getPrjCode();
		String projectName = mstrProjectList.get(0).getPrjName();
		
		String siteCode = mstrSiteHeaderList.get(0).getSiteCode();
		String siteName = mstrSiteHeaderList.get(0).getSiteName();
		String hospitalName = mstrProjectList.get(0).getHospital().getHospitalName();
		
/*		for(PrjAddPtDetail prjAddPtDetail : prjAddPtDetailList){
			prjAddPtDetail.getPv().getPatientVisit().getPatientVisitName();
			
		}*/
		
		try{
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("PatientWiseVisitReport");
			
			// Create a new font and alter it.
			
			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);
			//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			
			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	
			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);
			
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);
			
			//style1.setLocked(true);
	
			HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue(new HSSFRichTextString(hospitalName));
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));
	
			HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue(new HSSFRichTextString("Patient Wise Visit Report"));
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));
	
			HSSFRow row4 = sheet.createRow((short) 4);
				HSSFCell cell40 = row4.createCell((short) 1);
				cell40.setCellStyle(style1);
				cell40.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(4, (short) 1, 4, (short) 7));
	
			HSSFRow row5 = sheet.createRow((short) 5);
				HSSFCell cell51 = row5.createCell((short) 1);
				cell51.setCellValue(new HSSFRichTextString("From  :"));

				HSSFCell cell52 = row5.createCell((short) 3);
				cell52.setCellValue(new HSSFRichTextString(fromDateString));
				
				HSSFCell cell53 = row5.createCell((short) 4);
				cell53.setCellValue(new HSSFRichTextString("To  :"));

				HSSFCell cell56 = row5.createCell((short) 6);
				cell56.setCellValue(new HSSFRichTextString(toDateString));
				
				//sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));
				
			HSSFRow headingRow1 = sheet.createRow((short) 6);
				HSSFCell cell62 = headingRow1.createCell((short) 1);
				cell62.setCellValue(new HSSFRichTextString("Project Code:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));

				HSSFCell cell63 = headingRow1.createCell((short) 3);
				cell63.setCellValue(new HSSFRichTextString(projectCode));

				HSSFCell cell64 = headingRow1.createCell((short) 4);
				cell64.setCellValue(new HSSFRichTextString("Project Name:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(6, (short) 4, 6, (short) 5));

				HSSFCell cell66 = headingRow1.createCell((short) 6);
				cell66.setCellValue(new HSSFRichTextString(projectName));

			HSSFRow headingRow2 = sheet.createRow((short) 7);
				HSSFCell cell72 = headingRow2.createCell((short) 1);
				cell72.setCellValue(new HSSFRichTextString("Site Code:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(7, (short) 1, 7, (short) 2));

				HSSFCell cell73 = headingRow2.createCell((short) 3);
				cell73.setCellValue(new HSSFRichTextString(siteCode));

				HSSFCell cell74 = headingRow2.createCell((short) 4);
				cell74.setCellValue(new HSSFRichTextString("Site Name:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(7, (short) 4, 7, (short) 5));

				HSSFCell cell76 = headingRow2.createCell((short) 6);
				cell76.setCellValue(new HSSFRichTextString(siteName));
				
				
			HSSFRow headingRow3 = sheet.createRow((short) 8);
				HSSFCell cell82 = headingRow3.createCell((short) 1);
				cell82.setCellValue(new HSSFRichTextString(""));
			
			HSSFRow headingRowVisitNames = sheet.createRow((short) 10);
				HSSFCell cell91 = headingRowVisitNames.createCell((short) 1);
				cell91.setCellValue(new HSSFRichTextString("S No."));
				cell91.setCellStyle(style);
				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				//sheet.addMergedRegion(new Region(9, (short) 1, , (short) 1));
				
				
				HSSFCell cell93 = headingRowVisitNames.createCell((short) 2);
				cell93.setCellValue(new HSSFRichTextString("Screening No."));
				cell93.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 2, 10, (short) 2));
				

				HSSFCell cell94 = headingRowVisitNames.createCell((short) 3);
				cell94.setCellValue(new HSSFRichTextString("Randomization No."));
				cell94.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 3, 10, (short) 3));
				
				
				HSSFCell cell95 = headingRowVisitNames.createCell((short) 4);
				cell95.setCellValue(new HSSFRichTextString("DOB"));
				cell95.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 4, 10, (short) 4));
				

				prjAddPtHeaderList = session.createCriteria(PrjAddPtHeader.class)
					.createAlias("Prj", "prjHd")
					.createAlias("SiteHeader", "siteHd")
					.add(Restrictions.eq("prjHd.Id", projectId))
					.add(Restrictions.eq("siteHd.Id", siteId))
					.add(Restrictions
						.between("InitialVisitDate", fromDate, toDate)) 
					.list();
				
			List<Integer> idList = new ArrayList<Integer>();
			Set<MstrPtvisit> ptVisitForProject = new HashSet<MstrPtvisit>();
			
			for(PrjAddPtHeader prjAddPtHeader : prjAddPtHeaderList){
				Set<PrjAddPtDetail> prjAddPtDetailSet = prjAddPtHeader.getPrjAddPtDetails();
				for(PrjAddPtDetail prjAddPtDetail : prjAddPtDetailSet){
			//		ptVisitForProject.add(prjAddPtDetail.getAddPtHeader().getPatientVisit());
				}
			}
			
			for(MstrPtvisit mstrPtvisit : ptVisitForProject){
				HSSFCell cell = HMSUtil.getNextCell(headingRowVisitNames);
				cell.setCellValue(new HSSFRichTextString(mstrPtvisit.getPatientVisitName()));
				cell.setCellStyle(style);
				
				idList.add(mstrPtvisit.getId());
			}
			
			short rowNo = 11;
			int srNo = 1;
			int colNo = 5;
			
			for(PrjAddPtHeader prjAddPtHeader : prjAddPtHeaderList){
				Set<PrjAddPtDetail> prjAddPtDetailSet = prjAddPtHeader.getPrjAddPtDetails();
				HSSFRow patientRows = sheet.createRow(rowNo);

				HSSFCell patientRowsCellSrNo = patientRows.createCell((short) 1);
				patientRowsCellSrNo.setCellValue(new HSSFRichTextString(String.valueOf(srNo)));
				patientRowsCellSrNo.setCellStyle(style);
				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				//sheet.addMergedRegion(new Region(9, (short) 1, , (short) 1));
				
				
				HSSFCell patientRowsCellScreenNo = patientRows.createCell((short) 2);
				patientRowsCellScreenNo.setCellValue(new HSSFRichTextString(prjAddPtHeader.getScreeningNo()));
				patientRowsCellScreenNo.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 2, 10, (short) 2));
				

				HSSFCell patientRowsCellRandomizationNo = patientRows.createCell((short) 3);
				patientRowsCellRandomizationNo.setCellValue(new HSSFRichTextString(prjAddPtHeader.getRandomizationNo()));
				patientRowsCellRandomizationNo.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 3, 10, (short) 3));
				
				
				HSSFCell patientRowsCellDOB = patientRows.createCell((short) 4);
				if(prjAddPtHeader.getDob() != null){
					patientRowsCellDOB.setCellValue(prjAddPtHeader.getDob());					
				}
				patientRowsCellDOB.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 4, 10, (short) 4));
				
				
				
				for(PrjAddPtDetail prjAddPtDetail : prjAddPtDetailSet){
					int indexOfVisit = Collections.binarySearch(idList, prjAddPtDetail.getPv().getPatientVisit().getId());
					HSSFCell cellVisitStatus = patientRows.createCell((short) (colNo + indexOfVisit));

					cellVisitStatus.setCellValue(
							new HSSFRichTextString(prjAddPtDetail.getScheduleStatus()));
					cellVisitStatus.setCellStyle(style);
					
				}
				rowNo++;
			}
			
			//int lastCellNoVisitName = headingRowVisitNames.getLastCellNum();
			//Region(int rowFrom, short colFrom, int rowTo, short colTo)
			//sheet.addMergedRegion(new Region(9, (short) 3, 9, (short) lastCellNoVisitName));
			
			map.put("wb", wb);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
   }
	@SuppressWarnings("unchecked")
	public Map<String, Object> printSitePaymentReport(Map<String, Object> mapForDs){
	    Session session = (Session)getSession();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    int projectId = 0;
	    int siteId = 0;
	    Date fromDate = null;
	    Date toDate = null;
	    
	    if(mapForDs.get("projectId") != null){
	    	projectId = (Integer)mapForDs.get("projectId");
	    }
	    if(mapForDs.get("siteId") != null){
	    	siteId = (Integer)mapForDs.get("siteId");
	    }
	    if(mapForDs.get("fromDate") != null){
	    	fromDate = (Date)mapForDs.get("fromDate");
	    }
	    if(mapForDs.get("toDate") != null){
	    	toDate = (Date)mapForDs.get("toDate");
	    }
	    
		 SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		 String fromDateString = sdf.format(fromDate);
		 String toDateString = sdf.format(toDate);
	    
	    List<PrjAddPtHeader> prjAddPtHeaderList = new ArrayList<PrjAddPtHeader>();
		List<MstrPtvisit> mstrPtvisitList = new ArrayList<MstrPtvisit>();
		List<MstrProject> mstrProjectList = new ArrayList<MstrProject>();
		List<MstrSiteHeader> mstrSiteHeaderList = new ArrayList<MstrSiteHeader>();
		List<Object[]> prjStatusSumList = new ArrayList<Object[]>();
		List<BigDecimal> completedAmountList = new ArrayList<BigDecimal>();
		
		mstrPtvisitList = session.createCriteria(MstrPtvisit.class)
								.add(Restrictions.eq("Status", "y"))
								.addOrder(Order.asc("Id"))
								.list();
	
		mstrProjectList = session.createCriteria(MstrProject.class)
									.add(Restrictions.eq("Id", projectId))
									.list();

		mstrSiteHeaderList = session.createCriteria(MstrSiteHeader.class)
									.add(Restrictions.eq("Id", siteId))
									.list();

		
		String projectCode = mstrProjectList.get(0).getPrjCode();
		String projectName = mstrProjectList.get(0).getPrjName();
		String hospitalName = mstrProjectList.get(0).getHospital().getHospitalName();
		
		String siteCode = mstrSiteHeaderList.get(0).getSiteCode();
		String siteName = mstrSiteHeaderList.get(0).getSiteName();
		
		try{
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Site Payment Report");
			
			// Create a new font and alter it.
			
			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);
			//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			
			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	
			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);
			
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);
			
			//style1.setLocked(true);
	
			HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue(new HSSFRichTextString(hospitalName));
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));
	
			HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue(new HSSFRichTextString("Site Payment Report"));
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));
	
			HSSFRow row4 = sheet.createRow((short) 4);
				HSSFCell cell40 = row4.createCell((short) 1);
				cell40.setCellStyle(style1);
				cell40.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(4, (short) 1, 4, (short) 7));
	
			HSSFRow row5 = sheet.createRow((short) 5);
				HSSFCell cell51 = row5.createCell((short) 1);
				cell51.setCellValue(new HSSFRichTextString("From  :"));

				HSSFCell cell52 = row5.createCell((short) 3);
				cell52.setCellValue(new HSSFRichTextString(fromDateString));
				
				HSSFCell cell53 = row5.createCell((short) 4);
				cell53.setCellValue(new HSSFRichTextString("To  :"));

				HSSFCell cell56 = row5.createCell((short) 6);
				cell56.setCellValue(new HSSFRichTextString(toDateString));
				
				//sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));
				
			HSSFRow headingRow1 = sheet.createRow((short) 6);
				HSSFCell cell62 = headingRow1.createCell((short) 1);
				cell62.setCellValue(new HSSFRichTextString("Project Code:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));

				HSSFCell cell63 = headingRow1.createCell((short) 3);
				cell63.setCellValue(new HSSFRichTextString(projectCode));

				HSSFCell cell64 = headingRow1.createCell((short) 4);
				cell64.setCellValue(new HSSFRichTextString("Project Name:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(6, (short) 4, 6, (short) 5));

				HSSFCell cell66 = headingRow1.createCell((short) 6);
				cell66.setCellValue(new HSSFRichTextString(projectName));

			HSSFRow headingRow2 = sheet.createRow((short) 7);
				HSSFCell cell72 = headingRow2.createCell((short) 1);
				cell72.setCellValue(new HSSFRichTextString("Site Code:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(7, (short) 1, 7, (short) 2));

				HSSFCell cell73 = headingRow2.createCell((short) 3);
				cell73.setCellValue(new HSSFRichTextString(siteCode));

				HSSFCell cell74 = headingRow2.createCell((short) 4);
				cell74.setCellValue(new HSSFRichTextString("Site Name:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(7, (short) 4, 7, (short) 5));

				HSSFCell cell76 = headingRow2.createCell((short) 6);
				cell76.setCellValue(new HSSFRichTextString(siteName));
				
			HSSFRow headingRow3 = sheet.createRow((short) 8);
				HSSFCell cell82 = headingRow3.createCell((short) 1);
				cell82.setCellValue(new HSSFRichTextString(""));

			HSSFRow headingRow4 = sheet.createRow((short) 9);
				HSSFCell cell92 = headingRow4.createCell((short) 1);
				cell92.setCellValue(new HSSFRichTextString("Site Payment Details"));
				//cell92.setCellStyle(style1);
				
			
			short startingColumn = 1;
			HSSFRow headingRowVisitNames = sheet.createRow((short) 11);
				
				HSSFCell cell91 = headingRowVisitNames.createCell((short) startingColumn);
				cell91.setCellValue(new HSSFRichTextString("S No."));
				cell91.setCellStyle(style);
				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				//sheet.addMergedRegion(new Region(9, (short) 1, , (short) 1));
				
				
				HSSFCell cell93 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell93.setCellValue(new HSSFRichTextString("Visit Name"));
				cell93.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 2, 10, (short) 2));
				

				HSSFCell cell94 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell94.setCellValue(new HSSFRichTextString("No. of Completed"));
				cell94.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 3, 10, (short) 3));
				
				
				HSSFCell cell95 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell95.setCellValue(new HSSFRichTextString("Amount"));
				cell95.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 4, 10, (short) 4));
				

				//HSSFCell cell96 = headingRowVisitNames.createCell((short) ++startingColumn);
				//cell96.setCellValue(new HSSFRichTextString("Standard Payout Schedule"));
				//cell96.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 4, 10, (short) 4));
				//
				short rowNo = 12;
				double srNo = 1;

				for(MstrPtvisit mstrPtvisit : mstrPtvisitList){
					prjStatusSumList = session.createCriteria(PrjAddPtDetail.class)
											.createAlias("AddPtHeader", "addPtHeader")
											.createAlias("addPtHeader.Prj", "prjHd")
											.createAlias("addPtHeader.SiteHeader", "siteHd")
											.createAlias("Pv", "pv")
											.createAlias("pv.PatientVisit", "patientVisit")
											.add(Restrictions.eq("prjHd.Id", projectId))
											.add(Restrictions.eq("siteHd.Id", siteId))
											.add(Restrictions.between("addPtHeader.InitialVisitDate", fromDate, toDate)) 
											.add(Restrictions.eq("patientVisit.Id", mstrPtvisit.getId()))
											.add(Restrictions.eq("ScheduleStatus", "completed"))
											.setProjection(Projections.projectionList()
													.add(Projections.groupProperty("ScheduleStatus"))
													.add(Projections.count("ScheduleStatus")))
											.list();

					completedAmountList = session.createCriteria(PrjSiteMilestone.class)
										.add(Restrictions.eq("Prj.Id", projectId))
										.add(Restrictions.eq("SiteHeader.Id", siteId))
										.add(Restrictions.eq("PatientVisit.Id", mstrPtvisit.getId()))
										.setProjection(Projections.property("MilesStoneAmount"))
										.list();
					
					HSSFRow valueRows = sheet.createRow(rowNo);

						HSSFCell patientRowsCellSrNo = valueRows.createCell((short) 1);
						patientRowsCellSrNo.setCellValue(srNo);
						patientRowsCellSrNo.setCellStyle(style);

						HSSFCell cell = HMSUtil.getNextCell(valueRows);
						cell.setCellValue(new HSSFRichTextString(mstrPtvisit.getPatientVisitName()));
						cell.setCellStyle(style);
						
						
						if(prjStatusSumList.size() == 0 ){
							HSSFCell cellSumCompleted = HMSUtil.getNextCell(valueRows);
							cellSumCompleted.setCellValue(0);
							cellSumCompleted.setCellStyle(style);
							
							HSSFCell cellAmountCompleted = HMSUtil.getNextCell(valueRows);
							cellAmountCompleted.setCellValue(0);
							cellAmountCompleted.setCellStyle(style);

						}else{
							HSSFCell cellSumCompleted = HMSUtil.getNextCell(valueRows);
							Integer sumCompleted = ((Integer)prjStatusSumList.get(0)[1]);
							cellSumCompleted.setCellValue(sumCompleted.doubleValue());
							cellSumCompleted.setCellStyle(style);

							double totalAmount = 0.0;
							if(completedAmountList.size() > 0){
								totalAmount = sumCompleted*(completedAmountList.get(0).doubleValue());	
							}
							
							HSSFCell cellAmountCompleted = HMSUtil.getNextCell(valueRows);
							cellAmountCompleted.setCellValue(totalAmount);
							cellAmountCompleted.setCellStyle(style);
						}

					srNo++;
					rowNo++;
				}
			map.put("wb", wb);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
   }
	@SuppressWarnings("unchecked")
	public Map<String, Object> printProjectDetailReport(Map<String, Object> mapForDs){
	    Session session = (Session)getSession();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    int projectId = 0;
	    
	    if(mapForDs.get("projectId") != null){
	    	projectId = (Integer)mapForDs.get("projectId");
	    }
	    
		List<PrjFesStudyHeader> prjFesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
		
		prjFesStudyHeaderList = session.createCriteria(PrjFesStudyHeader.class)
								.add(Restrictions.eq("Prj.Id", projectId))
								.list();
		
		try{
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Project Detail Report");
			
			// Create a new font and alter it.
			
			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor((short) 80);
			font.setItalic(false);
			font.setStrikeout(false);
			//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			
			HSSFFont font1 = wb.createFont();
			font1.setFontHeightInPoints((short) 12);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setColor((short) 80);
			font1.setItalic(false);
			font1.setStrikeout(false);
			font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	
			// Fonts are set into a style so create a new one to
			// use.
			HSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			style.setAlignment((short) 2);
			
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setFont(font1);
			style1.setAlignment((short) 2);
			
			//style1.setLocked(true);
			String hospitalName = "";
			String projectCode = "";
			String projectName = "";
			if(prjFesStudyHeaderList.size() > 0){
				hospitalName = prjFesStudyHeaderList.get(0).getHospital().getHospitalName();	
				projectCode = prjFesStudyHeaderList.get(0).getPrj().getPrjCode();
				projectName = prjFesStudyHeaderList.get(0).getPrj().getPrjName();
			}
			
			HSSFRow row2 = sheet.createRow((short) 2);
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue(new HSSFRichTextString(hospitalName));
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));
	
			HSSFRow row3 = sheet.createRow((short) 3);
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue(new HSSFRichTextString("Project Detail Report"));
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));
	
			HSSFRow row4 = sheet.createRow((short) 4);
				HSSFCell cell40 = row4.createCell((short) 1);
				cell40.setCellStyle(style1);
				cell40.setCellValue(new HSSFRichTextString(""));
				sheet.addMergedRegion(new Region(4, (short) 1, 4, (short) 7));
	
				//sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));
				
			HSSFRow headingRow1 = sheet.createRow((short) 6);
				HSSFCell cell62 = headingRow1.createCell((short) 1);
				cell62.setCellValue(new HSSFRichTextString("Project Code:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));

				HSSFCell cell63 = headingRow1.createCell((short) 3);
				cell63.setCellValue(new HSSFRichTextString(projectCode));

				HSSFCell cell64 = headingRow1.createCell((short) 4);
				cell64.setCellValue(new HSSFRichTextString("Project Name:"));

				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				sheet.addMergedRegion(new Region(6, (short) 4, 6, (short) 5));

				HSSFCell cell66 = headingRow1.createCell((short) 6);
				cell66.setCellValue(new HSSFRichTextString(projectName));

				
			HSSFRow headingRow3 = sheet.createRow((short) 8);
				HSSFCell cell82 = headingRow3.createCell((short) 1);
				cell82.setCellValue(new HSSFRichTextString(""));

			HSSFRow headingRow4 = sheet.createRow((short) 9);
				HSSFCell cell92 = headingRow4.createCell((short) 1);
				cell92.setCellValue(new HSSFRichTextString("Project Details"));
				//cell92.setCellStyle(style1);
				
			
			short startingColumn = 1;
			HSSFRow headingRowVisitNames = sheet.createRow((short) 11);
				
				HSSFCell cell91 = headingRowVisitNames.createCell((short) startingColumn);
				cell91.setCellValue(new HSSFRichTextString("S No."));
				cell91.setCellStyle(style);
				//Region(int rowFrom, short colFrom, int rowTo, short colTo)
				//sheet.addMergedRegion(new Region(9, (short) 1, , (short) 1));
				
				
				HSSFCell cell93 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell93.setCellValue(new HSSFRichTextString("PI Name"));
				cell93.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 2, 10, (short) 2));
				

				HSSFCell cell94 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell94.setCellValue(new HSSFRichTextString("Site Name"));
				cell94.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 3, 10, (short) 3));
				
				
				HSSFCell cell95 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell95.setCellValue(new HSSFRichTextString("Address"));
				cell95.setCellStyle(style);
				//sheet.addMergedRegion(new Region(9, (short) 4, 10, (short) 4));
				

				HSSFCell cell96 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell96.setCellValue(new HSSFRichTextString("Pan No."));
				cell96.setCellStyle(style);
				

				HSSFCell cell97 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell97.setCellValue(new HSSFRichTextString("Bank Name"));
				cell97.setCellStyle(style);
				

				HSSFCell cell98 = headingRowVisitNames.createCell((short) ++startingColumn);
				cell98.setCellValue(new HSSFRichTextString("Account No."));
				cell98.setCellStyle(style);
				
				
				short rowNo = 12;
				double srNo = 1;

				for(PrjFesStudyHeader prjFesStudyHeader : prjFesStudyHeaderList){
					
					HSSFRow valueRows = sheet.createRow(rowNo);

						HSSFCell patientRowsCellSrNo = valueRows.createCell((short) 1);
						patientRowsCellSrNo.setCellValue(srNo);
						patientRowsCellSrNo.setCellStyle(style);

						HSSFCell cell = HMSUtil.getNextCell(valueRows);
						cell.setCellValue(new HSSFRichTextString(prjFesStudyHeader.getPiHeader().getPiName()));
						cell.setCellStyle(style);
						
						
						HSSFCell cellSiteName = HMSUtil.getNextCell(valueRows);
						cellSiteName.setCellValue(new HSSFRichTextString(prjFesStudyHeader.getSiteHeader().getSiteName()));
						cellSiteName.setCellStyle(style);
						
						
						HSSFCell cellAddress = HMSUtil.getNextCell(valueRows);
						cellAddress.setCellValue(new HSSFRichTextString(prjFesStudyHeader.getPiHeader().getPiAddress()));
						cellAddress.setCellStyle(style);
						

						HSSFCell cellPanNo = HMSUtil.getNextCell(valueRows);
						cellPanNo.setCellValue(new HSSFRichTextString(prjFesStudyHeader.getPiHeader().getPiPanNo()));
						cellPanNo.setCellStyle(style);
						

						HSSFCell cellBankName = HMSUtil.getNextCell(valueRows);
						if(prjFesStudyHeader.getPiHeader().getBank() != null){
							cellBankName.setCellValue(new HSSFRichTextString(prjFesStudyHeader.getPiHeader().getBank().getBankName()));
						}else{
							cellBankName.setCellValue(new HSSFRichTextString(""));
						}
						cellBankName.setCellStyle(style);
						
						
						HSSFCell cellAccountNo = HMSUtil.getNextCell(valueRows);
						cellAccountNo.setCellValue(new HSSFRichTextString(prjFesStudyHeader.getPiHeader().getPiAccNo()));
						cellAccountNo.setCellStyle(style);
						

					srNo++;
					rowNo++;
				}
			map.put("wb", wb);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return map;
   }
	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		Map<String, Object>  map=new HashMap<String, Object>();
		int hospitalId = 0;
		if(mapForDs.get("hospitalId") != null){
			hospitalId = (Integer)mapForDs.get("hospitalId");
		}
		
		Session session=getSession();
		try{
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			
			masHospitalList = session.createCriteria(MasHospital.class)
								.add(Restrictions.eq("Id", hospitalId))
								.add(Restrictions.eq("Status", "y"))
								.list();
			
			map.put("masHospitalList", masHospitalList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getEmpCodeSelectedEmployees(Map<String, Object> mapForDs) {
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session=getSession();
		Integer frompen = 0;
		Integer topen = 0;

		if(mapForDs.get("frompen") != null){
			frompen = (Integer)mapForDs.get("frompen");
		}
		if(mapForDs.get("topen") != null){
			topen = (Integer)mapForDs.get("topen");
		}

		try{
			List<MasEmployee> employeeListFirstEmp=new ArrayList<MasEmployee>();
			List<MasEmployee> employeeListSecondEmp=new ArrayList<MasEmployee>();
			
			employeeListFirstEmp = session.createCriteria(MasEmployee.class)
							.add(Restrictions.eq("Id", frompen ))
							.list();
			
			employeeListSecondEmp = session.createCriteria(MasEmployee.class)
							.add(Restrictions.eq("Id", topen))
							.list();

			map.put("employeeListFirstEmp", employeeListFirstEmp);
			map.put("employeeListSecondEmp", employeeListSecondEmp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> showProjectWiseCostReport() {
		Map<String, Object>  map=new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.eq("Status", "y")).list();
		map.put("projectList", projectList);
		return map;
	}

	public Map<String, Object> showAllProjectReport() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showDepartmentWiseProjectTimeReport() {
		Map<String, Object>  map=new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		map.put("projectList", projectList);
		map.put("employeeList",employeeList);
		map.put("departmentList", departmentList);
		return map;
	}

	public Map<String, Object> showDepartmentWiseProjectCostReport() {
		Map<String, Object>  map=new HashMap<String, Object>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		map.put("projectList", projectList);
		map.put("employeeList",employeeList);
		map.put("departmentList", departmentList);
		return map;
	}

	public List getHolidays() {
		Calendar calendar = Calendar.getInstance();
		Integer currentYear =  calendar.get(Calendar.YEAR);
		List<Holidaycalendar> holidays=getHibernateTemplate().find("from jkt.hrms.masters.business.Holidaycalendar as h where h.Rh='no' and HolidayListYear = '" + currentYear.toString() + "'");
		return holidays;
	}

	public Map<String, Object> showEmployeeListReport() {
		Map<String, Object>  map=new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		map.put("hospitalList",hospitalList);
		map.put("employeeList",employeeList);
		map.put("departmentList", departmentList);
		return map;
	}

	public Map<String, Object> showEmployeeWiseTaskList() {
		Map<String, Object>  map=new HashMap<String, Object>();
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showRoleWiseTaskList() {
		Map<String, Object>  map=new HashMap<String, Object>();
		//List<MstrProjectrole> roleList = new ArrayList<MstrProjectrole>();
		List<MasRank> masRankList = new ArrayList<MasRank>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		masRankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		
		map.put("departmentList", departmentList);
		map.put("masRankList", masRankList);
		return map;
	}

	public Map<String, Object> getFinancialYearDate(int year) {
		String sYear = new String();
		sYear = ((Integer)year).toString()   ;
		Map<String, Object>  map=new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
		hrMasFinancialYearList=session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("YearDescription", ((Integer)year).toString())).list();		
		
		map.put("hrMasFinancialYearList", hrMasFinancialYearList);
		
		return map;
	}
// added by Ramdular from Clinirx 02/02/2011 ---------------------	
}
