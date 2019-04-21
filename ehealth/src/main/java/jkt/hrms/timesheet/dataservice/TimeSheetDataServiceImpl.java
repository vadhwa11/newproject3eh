package jkt.hrms.timesheet.dataservice;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hrms.masters.business.TblTimeSheetSubmission;
import jkt.hms.util.HMSUtil;

import jkt.hrms.masters.business.MstrDeptTaskMap;
import jkt.hrms.masters.business.MstrProject;
import jkt.hrms.masters.business.MstrRoleTaskMap;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.masters.business.MstrTask;
import jkt.hrms.masters.business.PrjRoleResMappingDetail;
import jkt.hrms.masters.business.PrjRoleResMappingHeader;
import jkt.hrms.masters.business.PrjSiteResMap;
import jkt.hrms.masters.business.TblFreezeTimeSheet;
import jkt.hrms.masters.business.Tbltimesheet;
import jkt.hrms.masters.business.TbltimesheetAprl;

import org.apache.taglibs.standard.lang.jstl.OrOperator;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cache.OptimisticTreeCache.CircumventChecksDataVersion;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TimeSheetDataServiceImpl extends HibernateDaoSupport implements TimeSheetDataService 
{

	@SuppressWarnings("unchecked")
	public Map showTimeSheetJsp(int empId,Date date)
	{
		String dt = HMSUtil.convertDateToStringTypeDate(date);
		Date dateR = HMSUtil.convertStringTypeDateToDateType(dt);

		//Calendar cal = Calendar.getInstance();
		//String year = cal.get(Calendar.YEAR)+"";
		//String month = (cal.get(Calendar.MONTH)+1)+"";
		TblFreezeTimeSheet tblFreezeTimeSheet = new TblFreezeTimeSheet();
		TblFreezeTimeSheet tblFreezeTimeSheet1 = new TblFreezeTimeSheet();
		TblFreezeTimeSheet btblFreezeTimeSheet1 = new TblFreezeTimeSheet();
		Map map = new HashMap();
		MasEmployee masEmployee = new MasEmployee();
		List prjSiteList = new ArrayList();
		List<MstrTask> prjTaskList = new ArrayList<MstrTask>();
		List<Tbltimesheet> tblTimeSheetList = new ArrayList<Tbltimesheet>();
		List<TbltimesheetAprl> tbltimesheetAprlList = new ArrayList<TbltimesheetAprl>();
		List<MstrProject> mstrProjectList = new ArrayList<MstrProject>();
		List<MasEmployee> lineManagetList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeListForApprover = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		
		Session session = (Session)getSession();
		masEmployee =(MasEmployee)session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).uniqueResult();
		
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String year = cal.get(Calendar.YEAR)+"";
		String month = (cal.get(Calendar.MONTH)+1)+"";
		String nextMonth =  (cal.get(Calendar.MONTH) + 2)+"";
	    tblFreezeTimeSheet =(TblFreezeTimeSheet)session.createCriteria(TblFreezeTimeSheet.class).add(Restrictions.eq("Year", year)).add(Restrictions.eq("Month", month)).uniqueResult();
		tblFreezeTimeSheet1 =(TblFreezeTimeSheet)session.createCriteria(TblFreezeTimeSheet.class).add(Restrictions.eq("Year", year)).add(Restrictions.eq("Month", nextMonth)).uniqueResult();

	    //=================change by anamika   
		//Criteria crit = session.createCriteria(PrjResMap.class).createAlias("EmpId", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("Prj", "prj_staus").createAlias("prj_staus.PrjStatus","st").add(Restrictions.eq("st.Id", 1));
		//Criteria crit = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("Prj", "prj_staus").createAlias("prj_staus.ProjectStatus","st").add(Restrictions.eq("st.Id", 16));
		Criteria crit = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("Prj", "prj_staus").createAlias("prj_staus.ProjectStatus","st").add(Restrictions.eq("st.Id", 16));
		crit.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("Prj"))));
		mstrProjectList = crit.list();
		
		//Integer submitCount = (Integer)session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("EntryDate", dateR)).createAlias("EmpId", "emp").add(Restrictions.eq("emp.Id", empId)).add(Restrictions.eq("Status", "submitted")).list().size();
		TblTimeSheetSubmission tblTimeSheetSubmission = (TblTimeSheetSubmission)session.createCriteria(TblTimeSheetSubmission.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", empId)).add(Restrictions.eq("SubmitDate", dateR)).uniqueResult();
		Criteria crit1 = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", empId));
	    ProjectionList projList = Projections.projectionList();   
		projList.add(Projections.property("Id"));
	    projList.add(Projections.property("Employee"));
	     //projList.add(Projections.property("SiteId"));
	    projList.add(Projections.property("Prj"));
	    projList.add(Projections.property("Pjr"));
	    projList.add(Projections.groupProperty("SiteHeader"));
	    projList.add(Projections.groupProperty("Id"));
	    projList.add(Projections.groupProperty("Employee"));
	    projList.add(Projections.groupProperty("Pjr"));
	    projList.add(Projections.groupProperty("Prj"));
	    crit1.setProjection(projList);
	    prjSiteList= crit1.list();
	    	 
		tblTimeSheetList = session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("EntryDate", dateR)).createAlias("EmpId", "emp").add(Restrictions.eq("emp.Id", empId)).list();
		//prjTaskList= session.createCriteria(MstrTask.class).list();
		tbltimesheetAprlList = session.createCriteria(TbltimesheetAprl.class).list();
		//===========================================
		int lineManagerId = 0;
		if(masEmployee.getLineManager()!= null){
		lineManagerId = masEmployee.getLineManager().getId();
		}
		lineManagetList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(lineManagerId)).add(Restrictions.eq("Status", "y")).list();
		employeeListForApprover = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		
		
		map.put("departmentList", departmentList);
		map.put("date", date);
		map.put("btblFreezeTimeSheet1", btblFreezeTimeSheet1);
		map.put("lineManagetList", lineManagetList);
		map.put("employeeListForApprover", employeeListForApprover);
		map.put("masEmployee", masEmployee);
		map.put("tbltimesheetAprlList", tbltimesheetAprlList);
		map.put("tblTimeSheetList", tblTimeSheetList);
		map.put("prjSiteList", prjSiteList);
		map.put("mstrProjectList", mstrProjectList);
		map.put("datePrev",date);
		map.put("tblFreezeTimeSheet",tblFreezeTimeSheet);
		map.put("tblTimeSheetSubmission", tblTimeSheetSubmission);
		map.put("tblFreezeTimeSheet1", tblFreezeTimeSheet1);
		return map;}
	
	@SuppressWarnings("unchecked")
	public Map getTaskList(int empId, int prjId)
 {
  Session session = (Session)getSession();
  
  Map map = new HashMap();
  List<PrjRoleResMappingDetail> prjMesMapList = new ArrayList<PrjRoleResMappingDetail>();
  //List mstrDeptTaskMapList = new ArrayList();
  List <MstrTask>taskList = new ArrayList<MstrTask>();
  List <MstrTask>taskList1 = new ArrayList<MstrTask>();
   //=================change by anamika   
  //prjMesMapList = session.createCriteria(PrjResMap.class).createAlias("EmpId", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("Prj", "prjid").add(Restrictions.eq("prjid.Id", prjId)).add(Restrictions.eq("Type", "PRJROLETASK")).list();
  prjMesMapList = session.createCriteria(PrjRoleResMappingDetail.class).createAlias("RoleResMappingHeader", "header").createAlias("header.Employee", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("header.Prj", "prjid").add(Restrictions.eq("prjid.Id", prjId)).add(Restrictions.eq("TypeOfTask", "A"))
       .list();
  //mstrDeptTaskMapList = session.createQuery("from MstrRoleTaskMap roleTask left join fetch roleTask.Taskid where deptTask.Id=90").list();
   // criteria =  session.createCriteria(MstrRoleTaskMap.class);//.createAlias("Role", "role").add(Restrictions.eq("role.Id", 2))
   
   MasEmployee emp = (MasEmployee)session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).add(Restrictions.eq("Status", "y")).uniqueResult();
   //int roleID= emp.getRank().getId();
  // int departmentId = emp.getDepartment().getId();
   int roleID  = 0;
   if(emp!= null){
	   roleID =   emp.getRank().getId();
   }
   int departmentId = 0;
   
   if(emp!= null){
	   departmentId =   emp.getDepartment().getId();
   }
   
   emp=null;
   
   /*criteria = criteria.createAlias("Rank","role");
   criteria = criteria.add(Restrictions.eq("role.Id",new Integer(roleID)));
   ProjectionList projList = Projections.projectionList();   
   projList.add(Projections.property("Task"));
   criteria.setProjection(projList);*/
  // List<MstrRoleTaskMap> listRole = new ArrayList<MstrRoleTaskMap>();
   //listRole = session.createCriteria(MstrRoleTaskMap.class).createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", roleID)).createAlias("Department", "dept").add(Restrictions.eq("dept.Id", departmentId)).list();
  List<MstrRoleTaskMap> listRole = new ArrayList<MstrRoleTaskMap>();
  // List<MstrDeptTaskMap> listRole = new ArrayList<MstrDeptTaskMap>()
   listRole = session.createCriteria(MstrRoleTaskMap.class).createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", roleID)).createAlias("Department", "dept").add(Restrictions.eq("dept.Id", departmentId)).add(Restrictions.eq("Status", "y")).list();
  // List<MstrRoleTaskMap> listRole = session.createCriteria(MstrRoleTaskMap.class).createAlias("Rank","rank").add(Restrictions.eq("rank.Id", value));
  //mstrDeptTaskMapList =session.createCriteria(MstrDeptTaskMap.class).add(Restrictions.in("Taskid",listRole )).list();
   
 java.util.Set<Integer> tskSet= new java.util.HashSet<Integer>();
 java.util.Set<Integer> tskSet1= new java.util.HashSet<Integer>();
   //int task=0;
	  if(prjMesMapList!=null && prjMesMapList.size()>0){
	  for(PrjRoleResMappingDetail prjResMappingDetail:prjMesMapList)
	  {
		  tskSet.add(prjResMappingDetail.getTask().getId());
	  }
	  taskList = session.createCriteria(MstrTask.class).add(Restrictions.in("Id",tskSet)).addOrder(Order.asc("TaskName")).list();
	  }
	  if(listRole!=null && listRole.size()>0)
	  {
	   for(MstrRoleTaskMap mstrRoleTaskMap :listRole){
		   tskSet1.add(mstrRoleTaskMap.getTask().getId());
		   
	   }
	   
	   taskList1 = session.createCriteria(MstrTask.class).add(Restrictions.in("Id",tskSet1)).addOrder(Order.asc("TaskName")).list();
	  }
	  
	  

	 /* if(task!=0 )
	  {
	  //task = task.substring(1);
	 // StringTokenizer token = new StringTokenizer(task,",");
	 // while(token.hasMoreTokens())
	 // {
	   tskSet.add(task);
	 // }
	 //}
	  */
	  
	
  map.put("taskList", taskList);
  map.put("taskList1", taskList1);
  return map;
 }
	
	/*public Map getTaskList(int empId, int prjId)
	 {
	  Session session = (Session)getSession();
	  Map map = new HashMap();
	  List<PrjResMap> prjMesMapList = new ArrayList<PrjResMap>();
	  List mstrDeptTaskMapList = new ArrayList();
	  
	  List taskList = new ArrayList();
	  prjMesMapList = session.createCriteria(PrjResMap.class).createAlias("EmpId", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("Prj", "prjid").add(Restrictions.eq("prjid.Id", prjId)).add(Restrictions.eq("Type", "PRJROLETASK")).list();
	  //mstrDeptTaskMapList = session.createQuery("from MstrRoleTaskMap roleTask left join fetch roleTask.Taskid where deptTask.Id=90").list();
	  //List<MstrRoleTaskMap> listRole = getHibernateTemplate().find("from MstrRoleTaskMap where MstrRoleTaskMap.Role =2");
	   Criteria criteria =  session.createCriteria(MstrRoleTaskMap.class);//.createAlias("Role", "role").add(Restrictions.eq("role.Id", 2))
	   
	   MasEmployee emp = (MasEmployee)session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).add(Restrictions.eq("Status", "y")).uniqueResult();
	   int roleID= emp.getRank().getId();
	   emp=null;
	   criteria = criteria.createAlias("Role","role");
	   criteria = criteria.add(Restrictions.eq("role.Id",new Integer(roleID)));
	   ProjectionList projList = Projections.projectionList();   
	   projList.add(Projections.property("Task"));
	   criteria.setProjection(projList);
	   List<MstrRoleTaskMap> listRole = criteria.list();
	  //mstrDeptTaskMapList =session.createCriteria(MstrDeptTaskMap.class).add(Restrictions.in("Taskid",listRole )).list();
	  String task="";
	  if(prjMesMapList!=null && prjMesMapList.size()>0){
	  for(PrjResMap obj:prjMesMapList)
	  {
	   task += obj.getTaskId();
	  }
	  java.util.Set<Integer> tskSet= new java.util.HashSet<Integer>();
	  
	  if(listRole!=null && listRole.size()>0)
	  {
	   for (Iterator iterator = listRole.iterator(); iterator.hasNext();) 
	   {
	    MstrDeptTaskMap obj = (MstrDeptTaskMap) iterator.next();
	    tskSet.add(obj.getTaskid());
	   }
	   
	  }
	  
	  if(task!=null && task.length()>0)
	  {
	  task = task.substring(1);
	  StringTokenizer token = new StringTokenizer(task,",");
	  while(token.hasMoreTokens())
	  {
	   tskSet.add(new Integer((String)token.nextElement()));
	  }
	  taskList = session.createCriteria(MstrTask.class).add(Restrictions.in("Id",tskSet)).list();
	  }
	  }
	  map.put("taskList", taskList);
	  return map;
	 }
	
	
	*/
	
	public boolean submitTimeSheet(Tbltimesheet tbltimesheet) {
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(tbltimesheet);
		hbt.refresh(tbltimesheet);
		
		return  true;
	}

	public boolean submitTimeSheet(int prjId) 
	{
	try{
		Session session = (Session)getSession();
		Date date = new Date();
		getHibernateTemplate().setCheckWriteOperations(false);
		Tbltimesheet tbSheet =(Tbltimesheet) session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("Id", prjId)).uniqueResult();
		
		List<TbltimesheetAprl> tbObjList =(List<TbltimesheetAprl>)session.createCriteria(TbltimesheetAprl.class).add(Restrictions.eq("TmshtId", prjId)).add(Restrictions.eq("TaStatus", "Back")).list();
		if(tbObjList!=null && tbObjList.size()>0)
		{
			TbltimesheetAprl obj=tbObjList.get(0);
			obj.setTaStatus("waiting");
			session.update(obj);
			session.refresh(obj);
			
		}
		
		tbSheet.setStatus("submitted");
		tbSheet.setSubmtDate(date);
		session.update(tbSheet);
		session.flush();
		
		session.refresh(tbSheet);
		return true;
	}catch (Exception e) {
		return false;
	}
	}
	public Map<String, Object> copyOtherDateTimeSheet(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Tbltimesheet> tblTimeSheetList1 = new ArrayList<Tbltimesheet>();
		List<Tbltimesheet> tblTimeSheetList = new ArrayList<Tbltimesheet>();
		Calendar cal = Calendar.getInstance();
		String year = cal.get(Calendar.YEAR)+"";
		String month = (cal.get(Calendar.MONTH)+1)+"";
		TblFreezeTimeSheet tblFreezeTimeSheet = new TblFreezeTimeSheet();
		MasEmployee masEmployee = new MasEmployee();
		List prjSiteList = new ArrayList();
		List<MstrTask> prjTaskList = new ArrayList<MstrTask>();
		List<TbltimesheetAprl> tbltimesheetAprlList = new ArrayList<TbltimesheetAprl>();
		List<MstrProject> mstrProjectList = new ArrayList<MstrProject>();
		List<MasEmployee> lineManagetList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeListForApprover = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		Date date = new Date();
		if(generalMap.get("date")!= null){
			date = (Date)generalMap.get("date");
		}
		Date timesheetDate = null;
		if(generalMap.get("timesheetDate")!= null){
			timesheetDate = (Date)generalMap.get("timesheetDate");
		}
		int empId=0;
		if(generalMap.get("currentEmpId")!= null){
			empId = (Integer)generalMap.get("currentEmpId");
		}
		Session session = (Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		tblTimeSheetList1 = session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("EntryDate", timesheetDate)).createAlias("EmpId", "emp").add(Restrictions.eq("emp.Id", empId)).list();
		if(tblTimeSheetList1.size()>0){
			for(Tbltimesheet tbltimesheet :tblTimeSheetList1){
				Tbltimesheet timesheetObj = new Tbltimesheet();
				int employeeId = tbltimesheet.getEmpId().getId();
				int projectId = tbltimesheet.getProjectID().getId();
				int taskId = tbltimesheet.getTaskID().getId();
				if(tbltimesheet.getSiteID()!= null){
					int siteId = tbltimesheet.getSiteID().getId();
					MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
					mstrSiteHeader.setId(siteId);
					timesheetObj.setSiteID(mstrSiteHeader);
				}
				
				BigDecimal hrsWorked = tbltimesheet.getHrsWorked();
				String comment = tbltimesheet.getComments();
				int totalMin = tbltimesheet.getTotalMin();
				int deprtmentId = tbltimesheet.getDepartmentID().getId();
				int companyId = tbltimesheet.getCompanyID().getId();
				if(tbltimesheet.getApproverId()!= null){
					int approverId = tbltimesheet.getApproverId().getId();
					MasEmployee masEmployee2 = new MasEmployee();
					masEmployee2.setId(approverId);
					timesheetObj.setApproverId(masEmployee2);
				}
				if(tbltimesheet.getOtherApproverId()!= null){
					int otherApproverId = tbltimesheet.getOtherApproverId().getId();
					MasEmployee masEmployee3 = new MasEmployee();
					masEmployee3.setId(otherApproverId);
					timesheetObj.setOtherApproverId(masEmployee3);
				}
				
				MasHospital masHospital = new MasHospital();
				masHospital.setId(companyId);
				timesheetObj.setCompanyID(masHospital);
				
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deprtmentId);
				timesheetObj.setDepartmentID(masDepartment);
				
				MasEmployee emp = new MasEmployee();
				emp.setId(employeeId);
				timesheetObj.setEmpId(emp);
				
				MstrProject mstrProject = new MstrProject();
				mstrProject.setId(projectId);
				timesheetObj.setProjectID(mstrProject);
				
				
				
				MstrTask mstrTask = new MstrTask();
				mstrTask.setId(taskId);
				timesheetObj.setTaskID(mstrTask);
				
				timesheetObj.setTotalMin(totalMin);
				timesheetObj.setHrsWorked(hrsWorked);
				timesheetObj.setComments(comment);
				timesheetObj.setStatus("Saved");
				timesheetObj.setEntryDate(date);
				
				
				hbt.save(timesheetObj);
				hbt.refresh(timesheetObj);
			}
		}
		
		
		tblTimeSheetList = session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("EntryDate", date)).createAlias("EmpId", "emp").add(Restrictions.eq("emp.Id", empId)).list();

		
		masEmployee =(MasEmployee)session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).uniqueResult();
		
		tblFreezeTimeSheet =(TblFreezeTimeSheet)session.createCriteria(TblFreezeTimeSheet.class).add(Restrictions.eq("Year", year)).add(Restrictions.eq("Month", month)).uniqueResult();
	    //=================change by anamika   
		//Criteria crit = session.createCriteria(PrjResMap.class).createAlias("EmpId", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("Prj", "prj_staus").createAlias("prj_staus.PrjStatus","st").add(Restrictions.eq("st.Id", 1));
		Criteria crit = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("Prj", "prj_staus").createAlias("prj_staus.ProjectStatus","st").add(Restrictions.eq("st.Id", 1));
		crit.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("Prj"))));
		mstrProjectList = crit.list();
		
		//Integer submitCount = (Integer)session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("EntryDate", dateR)).createAlias("EmpId", "emp").add(Restrictions.eq("emp.Id", empId)).add(Restrictions.eq("Status", "submitted")).list().size();
		TblTimeSheetSubmission tblTimeSheetSubmission = (TblTimeSheetSubmission)session.createCriteria(TblTimeSheetSubmission.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", empId)).add(Restrictions.eq("SubmitDate", date)).uniqueResult();
		Criteria crit1 = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", empId));
	    ProjectionList projList = Projections.projectionList();   
		projList.add(Projections.property("Id"));
	    projList.add(Projections.property("Employee"));
	     //projList.add(Projections.property("SiteId"));
	    projList.add(Projections.property("Prj"));
	    projList.add(Projections.property("Pjr"));
	    projList.add(Projections.groupProperty("SiteHeader"));
	    crit1.setProjection(projList);
	    prjSiteList= crit1.list();
	    	 
		//prjTaskList= session.createCriteria(MstrTask.class).list();
		tbltimesheetAprlList = session.createCriteria(TbltimesheetAprl.class).list();
		//===========================================
		int lineManagerId = 0;
		if(masEmployee.getLineManager()!= null){
		lineManagerId = masEmployee.getLineManager().getId();
		}
		lineManagetList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(lineManagerId)).add(Restrictions.eq("Status", "y")).list();
		employeeListForApprover = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		map.put("departmentList", departmentList);
		map.put("lineManagetList", lineManagetList);
		map.put("employeeListForApprover", employeeListForApprover);
		map.put("masEmployee", masEmployee);
		map.put("tbltimesheetAprlList", tbltimesheetAprlList);
		map.put("tblTimeSheetList", tblTimeSheetList);
		map.put("prjSiteList", prjSiteList);
		map.put("mstrProjectList", mstrProjectList);
		map.put("datePrev",date);
		map.put("tblFreezeTimeSheet",tblFreezeTimeSheet);
		map.put("tblTimeSheetSubmission", tblTimeSheetSubmission);
		map.put("date", date);
		return map;
	}
	
	
	public boolean deleteTimeSheet(int prjId) {
		Session session = (Session)getSession();
		Date date = null;
		getHibernateTemplate().setCheckWriteOperations(false);
		Tbltimesheet tbSheet =(Tbltimesheet) session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("Id", prjId)).uniqueResult();
		//tbSheet.setStatus("submitted");
		//tbSheet.setSubmtDate(date);
		session.delete(tbSheet);
		session.flush();
		
		//session.refresh(tbSheet);
		return false;
	}

	@SuppressWarnings("unchecked")
	public Map showTimeSheetApprovalJsp(int empId) {

	Session session = (Session)getSession();
		 
		Map map = new HashMap();
		List tbltimesheetList = new ArrayList();
//		Criterion submitted = Restrictions.eq("Status","submitted");
       // Criterion fwded = Restrictions.eq("Status","Forwarded");
		Criteria crit= session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("Status","submitted"));
		
		ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("Id"));
        projList.add(Projections.property("EmpId"));
        projList.add(Projections.property("SiteID"));
        projList.add(Projections.property("ProjectID"));
        projList.add(Projections.property("TaskID"));
        projList.add(Projections.property("EntryDate"));
        projList.add(Projections.property("Status"));
        projList.add(Projections.sum("HrsWorked"));
        projList.add(Projections.property("TotalMin"));
        projList.add(Projections.property("ApproverId"));
        projList.add(Projections.property("OtherApproverId"));
        projList.add(Projections.groupProperty("EmpId"))
        .add(Projections.groupProperty("EntryDate"))
        .add(Projections.groupProperty("Id"))
        .add(Projections.groupProperty("SiteID"))
        .add(Projections.groupProperty("DepartmentID"))
        .add(Projections.groupProperty("ProjectID"))
        .add(Projections.groupProperty("CompanyID"))
        .add(Projections.groupProperty("ApproverId"))
        .add(Projections.groupProperty("OtherApproverId"))
        .add(Projections.groupProperty("TaskID"))
        .add(Projections.groupProperty("Status"))
        .add(Projections.groupProperty("TotalMin"))
         ;
        
        crit.setProjection(projList);
        tbltimesheetList = crit.list();
      //  tbltimesheetList=session.getNamedQuery("getCalculateworkinghrs").list();
        List<Tbltimesheet> fwdTbltimesheetList = new ArrayList<Tbltimesheet>();
        
        fwdTbltimesheetList=session.createCriteria(Tbltimesheet.class).add(Restrictions.eq("Status","Forwarded")).list();
        
        List<TbltimesheetAprl> tbltimesheetAprlList = new ArrayList<TbltimesheetAprl>();
        Criteria crit1= session.createCriteria(TbltimesheetAprl.class).add(Restrictions.eq("TaStatus","waiting")).add(Restrictions.eq("Approver", empId));
		tbltimesheetAprlList = crit1.list();
        
        MasEmployee emp = (MasEmployee)session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).add(Restrictions.eq("Status", "y")).uniqueResult();
		
		map.put("fwdTbltimesheetList", fwdTbltimesheetList);
		map.put("tbltimesheetList", tbltimesheetList);
		map.put("tbltimesheetAprlList", tbltimesheetAprlList);
		map.put("emp",emp);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map loadTimeSheet(int empId, Date date,int currentEmpId, int approverId, int otherId) {
		
		
		Session session = (Session)getSession();
		Map map = new HashMap();
		List tbltimesheetList = new ArrayList();
		List<TbltimesheetAprl> tblTimeSheetAprList = new ArrayList<TbltimesheetAprl>();
		List<MasEmployee> managerList= new ArrayList<MasEmployee>();
		managerList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", currentEmpId)).list();
		Criterion submitted = Restrictions.eq("Status","submitted");
        Criterion fwded = Restrictions.eq("Status","Forwarded");
		Criteria crit= session.createCriteria(Tbltimesheet.class).createAlias("EmpId", "emp").add(Restrictions.eq("emp.Id", empId)).add(Restrictions.eq("EntryDate", date)).add(Restrictions.or(submitted,fwded));
		if(approverId != 0 && otherId == 0){
			crit.add(Restrictions.eq("ApproverId.Id", approverId)).add(Restrictions.isNull("OtherApproverId"));
		}
		if(otherId != 0){
			crit.add(Restrictions.eq("OtherApproverId.Id", otherId));
		}
		tblTimeSheetAprList =session.createCriteria(TbltimesheetAprl.class).add(Restrictions.eq("TaStatus", "waiting")).list();
		tbltimesheetList  = crit.list();
		map.put("managerList", managerList);
		map.put("currentEmpId", new Integer(currentEmpId));
		map.put("tblTimeSheetAprList", tblTimeSheetAprList);
		map.put("tbltimesheetList", tbltimesheetList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map setTimeSheetStatus(int id,String status,TbltimesheetAprl tbltimesheetAprl,int manager)
	{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<TbltimesheetAprl> tblTimeSheetAprObj = new ArrayList<TbltimesheetAprl>();
			Tbltimesheet tbltimesheet =(Tbltimesheet)hbt.load(Tbltimesheet.class, id);
			tblTimeSheetAprObj =(List<TbltimesheetAprl>)hbt.find("from TbltimesheetAprl as tb where tb.TmshtId="+id +" and tb.TaStatus='waiting'"); 
//			(TbltimesheetAprl.class).add(Restrictions.eq("TaStatus", "waiting")).list();
			
			if(status.equalsIgnoreCase("a"))
			{
				tbltimesheet.setStatus("Approved");
				if(tblTimeSheetAprObj!=null && tblTimeSheetAprObj.size()>0)
				{
					tblTimeSheetAprObj.get(0).setTaStatus("Approved");
					hbt.update(tblTimeSheetAprObj.get(0));
					hbt.refresh(tblTimeSheetAprObj.get(0));
				}else{
					tbltimesheetAprl.setTaStatus("Approved");
					tbltimesheetAprl.setApprover(0);
					hbt.save(tbltimesheetAprl);
					hbt.refresh(tbltimesheetAprl);
				}
				
			
			}
			if(status.equalsIgnoreCase("b"))
			{
				tbltimesheet.setStatus("Back");
				if(tblTimeSheetAprObj!=null && tblTimeSheetAprObj.size()>0)
				{
					tblTimeSheetAprObj.get(0).setTaStatus("Back");
					hbt.update(tblTimeSheetAprObj.get(0));
					hbt.refresh(tblTimeSheetAprObj.get(0));
				}else{
					tbltimesheetAprl.setTaStatus("Back");
					tbltimesheetAprl.setApprover(0);
					hbt.save(tbltimesheetAprl);
					hbt.refresh(tbltimesheetAprl);
				}
				
			
			}
			if(status.equalsIgnoreCase("r"))
			{
				tbltimesheet.setStatus("Rejected");
				if(tblTimeSheetAprObj!=null && tblTimeSheetAprObj.size()>0)
				{
					tblTimeSheetAprObj.get(0).setTaStatus("Rejected");
					hbt.update(tblTimeSheetAprObj.get(0));
					hbt.refresh(tblTimeSheetAprObj.get(0));
				}else{
				tbltimesheetAprl.setTaStatus("Rejected");
				tbltimesheetAprl.setApprover(0);
				hbt.save(tbltimesheetAprl);
				hbt.refresh(tbltimesheetAprl);
				}
			}
			if(status.equalsIgnoreCase("f"))
			{
				
				tbltimesheet.setStatus("Forwarded");
				if(tblTimeSheetAprObj!=null && tblTimeSheetAprObj.size()>0)
				{
					tblTimeSheetAprObj.get(0).setTaStatus("Forwarded");
					hbt.update(tblTimeSheetAprObj.get(0));
					hbt.refresh(tblTimeSheetAprObj.get(0));
				}else{
				tbltimesheetAprl.setTaStatus("Forwarded");
				
				hbt.save(tbltimesheetAprl);
				hbt.refresh(tbltimesheetAprl);
				}
				TbltimesheetAprl newobj = new TbltimesheetAprl();
				newobj.setAppCmts("");
				newobj.setTmshtId(tbltimesheetAprl.getTmshtId());
				newobj.setAppHrs(tbltimesheetAprl.getAppHrs());
				newobj.setTaStatus("waiting");
				newobj.setApprover(manager);
				hbt.save(newobj);
				hbt.refresh(newobj);
				
			}
			
			hbt.update(tbltimesheet);
			hbt.refresh(tbltimesheet);
		
		
			
			
		return null;
	}

	public boolean editTimeSheet(Map map) {
	
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int id=0;
		int prjId=0;
		int taskId=0;
		int siteId=0;
		Date date= null;
		String comment = "";
		float hours =0f;
		int approverId= 0;
		int otherApproverId= 0;
		if(map!=null)
		{
			Tbltimesheet editableObj = new Tbltimesheet();
		
			if((map.get("timeSheetId")!=null) && !(map.get("timeSheetId").equals(new Integer(0))))
			{
				id=(Integer)map.get("timeSheetId");
				editableObj = (Tbltimesheet)hbt.load(Tbltimesheet.class, id);
				if((map.get("prjId")!=null) && !(map.get("prjId").equals(new Integer(0))))
				{
					prjId=(Integer)map.get("prjId");
					MstrProject project = new MstrProject();
					project.setId(prjId);
					editableObj.setProjectID(project);
				
				}
				if((map.get("siteId")!=null) && !(map.get("siteId").equals(new Integer(0))))
				{
					siteId=(Integer)map.get("siteId");
					MstrSiteHeader site = new MstrSiteHeader();
					site.setId(siteId);
					//editableObj.setSite(site);
				}
				if((map.get("taskId")!=null) && !(map.get("taskId").equals(new Integer(0))))
				{
					taskId=(Integer)map.get("taskId");
					MstrTask task = new MstrTask();
					task.setId(taskId);
					editableObj.setTaskID(task);
				}
				//====================
				if((map.get("approverId")!=null) && !(map.get("approverId").equals(new Integer(0))))
				{
					approverId=(Integer)map.get("approverId");
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(approverId);
					editableObj.setApproverId(masEmployee);
				}
				if((map.get("otherApproverId")!=null) && !(map.get("otherApproverId").equals(new Integer(0))))
				{
					otherApproverId=(Integer)map.get("otherApproverId");
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(otherApproverId);
					editableObj.setOtherApproverId(masEmployee);
				}
				
				if((map.get("hrWorked")!=null) && !(map.get("hrWorked").equals(new Integer(0))))
				{
					hours=(Float)map.get("hrWorked");
					editableObj.setHrsWorked(new BigDecimal(hours));
				}
				if((map.get("comment")!=null) && !(map.get("comment").equals("")))
				{
					comment=(String)map.get("comment");
					editableObj.setComments(comment);
				}
				if((map.get("lastSubmitDate")!=null))
				{
					Date lastSubmitDate = (Date)map.get("lastSubmitDate");
					editableObj.setLastSubmissionDate(lastSubmitDate);
				}
				
				if((map.get("date")!=null))
				{
					date= (Date)map.get("date");
					editableObj.setEntryDate(date);
				}
				editableObj.setStatus("Saved");
			}
			hbt.update(editableObj);
			hbt.flush();
			hbt.refresh(editableObj);
			return true;
		}
		else{
			return false;
		}
		
		
		
	}

	@SuppressWarnings("unchecked")
	public boolean approveAll(Date fromDate, Date toDate,int currentEmpId) {
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<TbltimesheetAprl> tblTimeSheetAprList = new ArrayList<TbltimesheetAprl>();
		List<Tbltimesheet> tbltimesheetList = new ArrayList<Tbltimesheet>();
		tbltimesheetList =	(List<Tbltimesheet>)hbt.find("from jkt.hrms.masters.business.Tbltimesheet as tb where tb.EmpId in (select emp.Id from jkt.hms.masters.business.MasEmployee as emp where emp.LineManager="+currentEmpId+") and tb.EntryDate between '"+HMSUtil.getDateFormat(fromDate, "yyyy-MM-dd")+"' and '"+HMSUtil.getDateFormat(toDate, "yyyy-MM-dd")+"' and tb.Status !='Approved'");
		for (Iterator iterator = tbltimesheetList.iterator(); iterator.hasNext();) 
		{
			Tbltimesheet tbltimesheet = (Tbltimesheet) iterator.next();
			tblTimeSheetAprList = (List<TbltimesheetAprl>)hbt.find("from jkt.hrms.masters.business.TbltimesheetAprl where TaStatus in('waiting','Back') and TmshtId="+tbltimesheet.getId()+" and Approver="+currentEmpId);
			if(tblTimeSheetAprList!=null && tblTimeSheetAprList.size()>0)
			{
				TbltimesheetAprl obj = tblTimeSheetAprList.get(0);
				obj.setTaStatus("Approved");
				hbt.update(obj);
				hbt.flush();
				hbt.refresh(obj);
			}
			if(!(tbltimesheet.getStatus().equalsIgnoreCase("Forwarded")) && !(tbltimesheet.getStatus().equalsIgnoreCase("Back"))&& !(tbltimesheet.getStatus().equalsIgnoreCase("Rejected")) )
			{
				tbltimesheet.setStatus("Approved");
			}
			hbt.update(tbltimesheet);
			hbt.flush();
			hbt.refresh(tbltimesheet);
			
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public Map showFreezTimeSheet(String year) 
	{
		Map map = new HashMap();
		
		List<TblFreezeTimeSheet> tblFreezeTimeSheetList = new ArrayList<TblFreezeTimeSheet>();
		Session session = (Session)getSession();
		tblFreezeTimeSheetList =(List<TblFreezeTimeSheet>) session.createCriteria(TblFreezeTimeSheet.class).add(Restrictions.eq("Year", year)).list();
		if(tblFreezeTimeSheetList != null)
		{
			map.put("tblFreezeTimeSheetList", tblFreezeTimeSheetList);
		}
		map.put("year", year);
		return map;
	}

	public boolean saveFreezTimeSheet(Map map)
	{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String year=(String) map.get("year");
		List list = hbt.find("from TblFreezeTimeSheet where year='"+year+"'");
		if(list!=null && list.size()>0)
		{
			hbt.deleteAll(list);
		}
		
		
		for(int ilop=1;ilop<=12;ilop++)
		{
		TblFreezeTimeSheet obj =(TblFreezeTimeSheet)map.get("tblFreezeTimeSheet"+ilop);
		
		if(obj!=null)
		{
			hbt.save(obj);
			hbt.refresh(obj);
		}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean markNoOfSubmission(int empId, Date date)
	
	{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<TblTimeSheetSubmission> objList =(List<TblTimeSheetSubmission>) hbt.find("from TblTimeSheetSubmission where SubmitDate='"+HMSUtil.getDateFormat(date, "yyyy-MM-dd")+"' and Emp.Id="+empId);
		if(objList!=null && objList.size()>0)
		{
		 int noOfSubBeforeSubmit = objList.get(0).getNoOfTimeSubmit();
		 int noOfSubAfterSubmit= noOfSubBeforeSubmit+1;
		 objList.get(0).setNoOfTimeSubmit(noOfSubAfterSubmit);
		 hbt.update(objList.get(0));
		 hbt.refresh(objList.get(0));
		}
		else{
			TblTimeSheetSubmission newObj = new TblTimeSheetSubmission();
			MasEmployee emp = new MasEmployee();
			emp.setId(empId);
			newObj.setEmp(emp);
			newObj.setSubmitDate(date);
			newObj.setNoOfTimeSubmit(1);
			hbt.save(newObj);
			hbt.refresh(newObj);
		}
		return false;
	}

	

}
