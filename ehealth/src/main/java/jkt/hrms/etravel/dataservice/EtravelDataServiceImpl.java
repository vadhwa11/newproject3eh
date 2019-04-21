package jkt.hrms.etravel.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import jkt.hms.masters.business.Department;
import jkt.hms.masters.business.HrEmployeeDeputation;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.EtrApptbl;
import jkt.hrms.masters.business.EtrBookeddtlsAttach;
import jkt.hrms.masters.business.EtrExpdetails;
import jkt.hrms.masters.business.EtrExpsubmit;
import jkt.hrms.masters.business.EtrFillbookeddtls;
import jkt.hrms.masters.business.EtrTicketdetails;
import jkt.hrms.masters.business.EtrTravelreq;
import jkt.hrms.masters.business.EtrTrvdetails;
import jkt.hrms.masters.business.EtrTrvreqcmts;
import jkt.hrms.masters.business.EtrTrvsubAttach;
import jkt.hrms.masters.business.EtrTrvsubapptbl;
import jkt.hrms.masters.business.HrPayrollProcessDetail;
import jkt.hrms.masters.business.HrPayrollProcessHeader;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.MstrCode;
import jkt.hrms.masters.business.MstrPiHeader;
import jkt.hrms.masters.business.MstrProject;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.masters.business.MstrStandardAllowance;
import jkt.hrms.masters.business.PrjRoleResMappingHeader;
import jkt.hrms.masters.business.PrjSiteResMap;
import jkt.hrms.masters.business.TempTickattach;
import jkt.hrms.masters.business.TempTrvsub;
import jkt.hrms.util.LeaveManagementUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import jkt.hrms.util.SendMail;
public class EtravelDataServiceImpl extends HibernateDaoSupport implements EtravelDataService {

	public Map<String, Object> showTravelRequestJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<String> travelRequestList = new ArrayList<String>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		//List<MasLocation> locationList = new ArrayList<MasLocation>();
		//List<MasRank> rankList = new ArrayList<MasRank>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		Session session = (Session)getSession();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		//locationList = session.createCriteria(MasLocation.class).add(Restrictions.eq("Status", "y")).list();
		//rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)) .addOrder(Order.desc("CreatedAt") ).list();
		//map.put("travelRequestList", travelRequestList);
		map.put("employeeList", employeeList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addNewTravelRequest(int empId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MstrProject>mstrProjectList = new ArrayList<MstrProject>();
		List<Object[]>departmentList = new ArrayList<Object[]>();
		List<MstrSiteHeader> mstrSiteList = new ArrayList<MstrSiteHeader>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MasEmployee> employeeforLineManagerList = new ArrayList<MasEmployee>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasEmployee> userEmployeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		userEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empId)).add(Restrictions.eq("Status", "y")).list();
		Criteria crit = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", empId)).createAlias("Prj", "prj_staus").createAlias("prj_staus.ProjectStatus","st").add(Restrictions.eq("st.Id", 1));
		crit.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("Prj"))));
		mstrProjectList = crit.list();
		departmentList=getHibernateTemplate().find("select md.Id, md.DepartmentName,md.Status from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		//mstrSiteList=getHibernateTemplate().find("select msd.Id, msd.SiteName from jkt.hrms.masters.business.MstrSiteHeader as msd ");
		employeeList=getHibernateTemplate().find("select me.Id,me.EmployeeCode, me.FirstName,me.MiddleName,me.LastName,me.LineManager.Id,me.LineManager.FirstName,me.LineManager.MiddleName,me.LineManager.LastName,me.Department.Id,me.Status from jkt.hms.masters.business.MasEmployee as me where me.Status = 'y'");
		//mstrProjectList = session.createCriteria(MstrProject.class).list();
		mstrSiteList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.eq("Status", "y")).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTripList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "Trip")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		//employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		employeeforLineManagerList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empId)).add(Restrictions.eq("Status", "y")).list();
		map.put("mstrProjectList", mstrProjectList);
		map.put("userEmployeeList", userEmployeeList);
		map.put("departmentList", departmentList);
		map.put("mstrSiteList", mstrSiteList);
		map.put("masCityList", masCityList);
		map.put("currencyList", currencyList);
		map.put("mstrCodeForTripList", mstrCodeForTripList);
		map.put("employeeList", employeeList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("countryList", countryList);
		map.put("employeeforLineManagerList", employeeforLineManagerList);
		return map;
	}

	public Map<String, Object> getProjectSiteDetailFromAjax(int projectId,
			int employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrjSiteResMap> prjSiteMapList = new ArrayList<PrjSiteResMap>();
	//	Set<PrjSiteResMap> prjSiteResMapSet = new HashSet<PrjSiteResMap>();
		@SuppressWarnings("unused")
		Session session = (Session)getSession();
		prjSiteMapList = getHibernateTemplate().find("from jkt.hrms.masters.business.PrjSiteResMap as prj where prj.Prj.Id = "+projectId+" and prj.Employee.Id = "+employeeId+"");
		//prjSiteResMapSet.addAll(prjSiteMapList);
		Set<PrjSiteResMap> prjSiteResMapSet = new HashSet(prjSiteMapList);
	        
	    /*Criteria crit1 = session.createCriteria(PrjSiteResMap.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", employeeId));
	    ProjectionList projList = Projections.projectionList();   
		projList.add(Projections.property("Id"));
	    projList.add(Projections.property("Employee"));
	     //projList.add(Projections.property("SiteId"));
	    projList.add(Projections.property("Prj"));
	    projList.add(Projections.property("Pjr"));
	    projList.add(Projections.groupProperty("SiteHeader"));
	    crit1.setProjection(projList);
	    prjSiteMapList= crit1.list();*/
		 map.put("prjSiteMapList", prjSiteMapList);
		 map.put("prjSiteResMapSet", prjSiteResMapSet);
		return map;
	}
	public Map<String, Object> searchTravelRequest(Map<String, Object> generalMap) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int searchRefNoId = 0; 
		if(generalMap.get("searchRefNoId")!= null){
			searchRefNoId = (Integer)generalMap.get("searchRefNoId");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		
		String searchStatusId = "";
		if(generalMap.get("searchStatusId")!= null){
			searchStatusId = (String)generalMap.get("searchStatusId");
		}
		Date fromDate = null;
		if(generalMap.get("fromDate")!= null){
			fromDate = (Date)generalMap.get("fromDate");
		}
		
		Date toDate = null;
		if(generalMap.get("toDate")!= null){
			toDate = (Date)generalMap.get("toDate");
		}
		Session session = (Session)getSession();
		Criteria crit = null;
		crit = session.createCriteria(EtrTravelreq.class);
		if(searchRefNoId != 0){
			crit = crit.add(Restrictions.idEq(searchRefNoId));
		}
		if(employeeId != 0){
			crit = crit.add(Restrictions.eq("Emp.Id",employeeId));
		}
		if(searchStatusId != ""){
			crit = crit.add(Restrictions.eq("TrvStatus", searchStatusId));
		}
		
		if(fromDate != null || toDate!= null ){
			crit = crit.add(Restrictions.gt("Jfdate", fromDate)).add(Restrictions.lt("Jtdate", toDate));
			
		}
		
		etrTravelRequestList = crit.list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitNewTravelRequest(Map<String, Object> generalMap) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<PrjSiteResMap> prjSiteMapList = new ArrayList<PrjSiteResMap>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		EtrTravelreq etrTravelreq = new EtrTravelreq();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List travelModeList =new ArrayList();
		List ticketBookingDateList =new ArrayList();
		List ticketBookingRemarkList =new ArrayList();
		List<String> tripList = new ArrayList<String>();
		List<Integer> approverList = new ArrayList<Integer>();
		//List<String> lineManagerList = new ArrayList<String>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		
		List beforeTimeList = new ArrayList();
		List beforeTimeList1 = new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List<MasDistrict>fromCityList = new ArrayList<MasDistrict>();
		List<MasDistrict>toCityList = new ArrayList<MasDistrict>();
		List<MasCountry>countryList1 = new ArrayList<MasCountry>();
		List<MasCountry>countryList2 = new ArrayList<MasCountry>();
		
		Session session = (Session)getSession();
		if (generalMap.get("etrTravelreq")!= null) {
			etrTravelreq = (EtrTravelreq)generalMap.get("etrTravelreq");
		}
		Date fromDate  = null;
		if (generalMap.get("fromDate")!= null) {
			fromDate = (Date)generalMap.get("fromDate");
		}
		Date toDate = null;
		if (generalMap.get("toDate")!= null) {
			toDate = (Date)generalMap.get("toDate");
		}
		int employeeId = 0;
		if (generalMap.get("employeeId")!= null) {
			employeeId = (Integer)generalMap.get("employeeId");
		}
		if (generalMap.get("fromCountryList")!= null) {
			fromCountryList = (List)generalMap.get("fromCountryList");
		}
		if (generalMap.get("toCountryList")!= null) {
			toCountryList = (List)generalMap.get("toCountryList");
		}
		if (generalMap.get("fromPlaceList")!= null) {
			fromPlaceList = (List)generalMap.get("fromPlaceList");
		}
		if (generalMap.get("toPlaceList")!= null) {
			toPlaceList = (List)generalMap.get("toPlaceList");
		}
		if (generalMap.get("travelModeList")!= null) {
			travelModeList = (List)generalMap.get("travelModeList");
		}
		if (generalMap.get("ticketBookingDateList")!= null) {
			ticketBookingDateList = (List)generalMap.get("ticketBookingDateList");
		}
		if (generalMap.get("ticketBookingRemarkList")!= null) {
			ticketBookingRemarkList = (List)generalMap.get("ticketBookingRemarkList");
		}
		if (generalMap.get("beforeTimeList")!= null) {
			beforeTimeList = (List)generalMap.get("beforeTimeList");
		}
		if (generalMap.get("beforeTimeList1")!= null) {
			beforeTimeList1 = (List)generalMap.get("beforeTimeList1");
		}
		
		int headId =0;
		if (generalMap.get("headId")!= null) {
			headId = (Integer)generalMap.get("headId");
		}
		
		int tripId = etrTravelreq.getTrip().getId();
		int projectId = 0;
		if(! generalMap.get("projectId").equals(0)){
		 projectId = (Integer)generalMap.get("projectId");
		}
		String recipientAddresses = "";
		String ccAddress = ""; 
		String emailMessage = "";	
		String refNo = "";
		String qry = "select concat(left(codedesc,1) ,date_format(now(),'%y'),date_format(now(),'%m'),'000'," +
		"(select count(*)+1 from etr_travelreq where cast(CreatedAt as date)  between  (date_add(last_day(current_date)," +
                     "  interval (-day(last_day(current_date))+1) day)) and (last_day(current_date)))) as refNo from mstr_code where CodeId ="+tripId;
		 
		 tripList = (List) session.createSQLQuery(qry).list();
		 refNo = tripList.get(0);
		 
		 etrTravelreq.setTravelResquestStatus("New");
		 etrTravelreq.setBookStatus("Pending");
		 etrTravelreq.setRefNo(refNo);
		 etrTravelreq.setTrvStatus("NewRequest");
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(etrTravelreq);
			
			String ticketBookingDetailForMail = ""; 
			if(travelModeList.size()>0){
			for(int i = 0; i < travelModeList.size(); i++){
				int fromPalceId = 0;
				int toPlaceId = 0;
				Date ticketbookingDate = null;
				String beforeTime ="";
				String beforeTime1 = "";
				String remarks = "";
				int fromCountryId = 0;
				int toCountryId = 0;
				EtrTrvdetails etrTrvdetails = new EtrTrvdetails();
				if(travelModeList.get(i) != null && !travelModeList.get(i).equals("")){
					int travelModeId = Integer.parseInt(travelModeList.get(i).toString());
					MstrCode mstrCode = new MstrCode();
					mstrCode.setId(travelModeId);
					etrTrvdetails.setTrip(mstrCode);
				
				if(fromCountryList.size()>0 ){
					if(fromCountryList.get(i) != null && !fromCountryList.get(i).equals("") ){
						 fromCountryId = Integer.parseInt(fromCountryList.get(i).toString());
						MasCountry masCountry = new MasCountry();
						masCountry.setId(fromCountryId);
						etrTrvdetails.setFromCountry(masCountry);
					}
				}
				
				if(toCountryList.size()>0){
					if(toCountryList.get(i) != null && !toCountryList.get(i).equals("")){
						 toCountryId = Integer.parseInt(toCountryList.get(i).toString());
						MasCountry masCountry = new MasCountry();
						masCountry.setId(toCountryId);
						etrTrvdetails.setToCountry(masCountry);
					}
				}
				
				if(fromPlaceList.size()>0){
				if(fromPlaceList.get(i) != null && !fromPlaceList.get(i).equals("")){
					fromPalceId = Integer.parseInt(fromPlaceList.get(i).toString());
					//MstrCity mstrCity = new MstrCity();
					//mstrCity.setId(fromPalceId);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(fromPalceId);
					etrTrvdetails.setFrmPlce(masDistrict);
				}
			}
				
				if(toPlaceList.size()>0){
				if(toPlaceList.get(i) != null &&  !toPlaceList.get(i).equals("")){
					toPlaceId = Integer.parseInt(toPlaceList.get(i).toString());
					//MstrCity mstrCity = new MstrCity();
					//mstrCity.setId(toPlaceId);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(toPlaceId);
					etrTrvdetails.setToPlce(masDistrict);
				}
			}
				
				if(ticketBookingDateList.get(i) != null &&  !ticketBookingDateList.get(i).equals("")){
					 ticketbookingDate = HMSUtil.convertStringTypeDateToDateType(ticketBookingDateList.get(i).toString());
					etrTrvdetails.setBDate(ticketbookingDate);
				}
				if(beforeTimeList.get(i) != null  &&  !beforeTimeList.get(i).equals("")){
					 beforeTime = beforeTimeList.get(i).toString();
					etrTrvdetails.setBeforeTime(beforeTime);
				}
				if(beforeTimeList1.get(i) != null  &&  !beforeTimeList1.get(i).equals("")){
					 beforeTime1 = beforeTimeList1.get(i).toString();
					etrTrvdetails.setTimeSlot(beforeTime1);
				}
				
				if(ticketBookingRemarkList.get(i) != null  &&  !ticketBookingRemarkList.get(i).equals("")){
					 remarks = ticketBookingRemarkList.get(i).toString();
					etrTrvdetails.setRemarks(remarks);
				}
				etrTrvdetails.setTrv(etrTravelreq);
				hbt.save(etrTrvdetails);
				}
				fromCityList = session.createCriteria(MasDistrict.class).add(Restrictions.idEq(fromPalceId)).add(Restrictions.eq("Status", "y")).list();
				toCityList = session.createCriteria(MasDistrict.class).add(Restrictions.idEq(toPlaceId)).add(Restrictions.eq("Status", "y")).list();
				countryList1 = session.createCriteria(MasCountry.class).add(Restrictions.idEq(fromCountryId)).add(Restrictions.eq("Status", "y")).list();
				countryList2 = session.createCriteria(MasCountry.class).add(Restrictions.idEq(toCountryId)).add(Restrictions.eq("Status", "y")).list();
				String fromPlace = "";
				String toPlace = "";
				if(fromCityList.size()>0){
					MasDistrict masDistrict = fromCityList.get(0);
					fromPlace = masDistrict.getDistrictName();
				}else if(countryList1.size()>0){
					MasCountry masCountry= countryList1.get(0);
					fromPlace = masCountry.getCountryName();
				}
				if(toCityList.size()>0){
					MasDistrict masDistrict1 = toCityList.get(0);
					toPlace = masDistrict1.getDistrictName();
				}else if(countryList2.size()>0){
					MasCountry masCountry1= countryList2.get(0);
					toPlace = masCountry1.getCountryName();
				}
				
				ticketBookingDetailForMail = ticketBookingDetailForMail+"\n\n Ticket Booking From "+fromPlace+" to "+toPlace+" on "+HMSUtil.convertDateToStringWithoutTime(ticketbookingDate)+"\n" +
						" prefered time slot "+beforeTime+" to "+beforeTime1+" \n" +
						" Remark--"+remarks+"  ";
				
			}
			}
			
			
			EtrTrvreqcmts eTrvreqcmts = new EtrTrvreqcmts();
			EtrApptbl etrApptbl = new EtrApptbl();
			int selectLineManagerAndOther = 1;
			if (generalMap.get("selectLineManagerAndOther")!= null) {
				selectLineManagerAndOther = (Integer)generalMap.get("selectLineManagerAndOther");
			}
			int approverId =  0;
			if (selectLineManagerAndOther ==1) {
				/*String qry1 = "select concat('Request has waiting for Approval', ' ', first_name,' ', middle_name,' ',last_name) from mas_employee " + 
				" where employee_id = (select Line_manager_id from mas_employee where employee_id="+employeeId;*/
				String qry1 = "select Line_manager_id from mas_employee where employee_id="+employeeId;
				approverList = (List) session.createSQLQuery(qry1).list();
				approverId = approverList.get(0);
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(approverId);
				etrApptbl.setAppr(masEmployee);
				etrApptbl.setTrv(etrTravelreq);
				hbt.save(etrApptbl);
			}else{
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(headId);
				etrApptbl.setAppr(masEmployee);
				etrApptbl.setTrv(etrTravelreq);
				hbt.save(etrApptbl);
			}
			String lineManager = "";
			if (selectLineManagerAndOther ==1) {
				/*String qry2 = "select concat('Request has waiting for Approval', ' ', first_name,' ', middle_name,' ',last_name) from mas_employee " +
				" where employee_id = (select Line_manager_id from mas_employee where employee_id=1)";
				lineManagerList = (List) session.createSQLQuery(qry2).list();
				 lineManager = lineManagerList.get(0);*/
				eTrvreqcmts.setStrSts("Waiting");
				eTrvreqcmts.setTrv(etrTravelreq);
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				eTrvreqcmts.setCreatedBY(masEmployee);
				Date currentDate = new Date();
				eTrvreqcmts.setCreatedAt(currentDate);
				hbt.save(eTrvreqcmts);
			}
			List<MasEmployee> lineManagerList = new ArrayList<MasEmployee>();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
			int lineManagerId = 0;
			String lineManagerName = "";
			String applicantName = "";
			String titleName = "";
			String fromAddress = "";
			if(employeeList.size()>0){
				for(MasEmployee masEmployee :employeeList){
					lineManagerId = masEmployee.getLineManager().getId();
					lineManagerName = masEmployee.getLineManager().getFirstName()+" "+masEmployee.getLineManager().getMiddleName()+" "+masEmployee.getLineManager().getLastName();
					recipientAddresses = masEmployee.getLineManager().getEmail();
					//recipientAddresses = "ritu.sahu@jktech.com";
					ccAddress = masEmployee.getEmail();
					//ccAddress = "dipali.shukla@jktech.com";
					fromAddress =  masEmployee.getEmail();
					//fromAddress =  "dipali.shukla@jktech.com";
					applicantName = masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName();
					titleName = masEmployee.getTitle().getTitleName();
				}
			}
			List<String> recipientAddressesList = new ArrayList<String>();
			List<String> ccAddressesList = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();
			
			String ccAddress1  = "adminhelp@clinirx.com";
		//	String ccAddress1  = "mhwani@clinirx.com";
			String subject = "Travel Request";
			Date currentDate = new Date();
			emailMessage = "Dear "+ titleName + " " + lineManagerName+ ",\n";
			
			
			ccAddressesList.add(ccAddress);
			ccAddressesList.add(ccAddress1);
			
			recipientAddressesList.add(recipientAddresses);
			
			emailMessage = emailMessage +"   "+ applicantName+" has made a travel request "+refNo+", on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+" for a travel from "+
			HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
			ticketBookingDetailForMail+
					" \n\n\n\n For details and approval of the same, kindly log in your omega account.\n\n\n\n"+
					"This is an auto generated mail through OMEGA. Do not reply.";
			
			boolean sent=false;
			if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
			}
			
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		prjSiteMapList = getHibernateTemplate().find("from jkt.hrms.masters.business.PrjSiteResMap as prj where prj.Prj.Id = "+projectId+"");

		map = addNewTravelRequest(employeeId);
		map.put("employeeList", employeeList);
		map.put("prjSiteMapList", prjSiteMapList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> viewTravelRequest(int travelRequestId,int employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> viewTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<EtrTravelreq> etrTravelReqList  = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		List<MstrProject>mstrProjectList = new ArrayList<MstrProject>();
		//List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
		List<MstrSiteHeader> mstrSiteList = new ArrayList<MstrSiteHeader>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<EtrApptbl> viewApprTravelList = new ArrayList<EtrApptbl>();
		//List<PrjSiteResMap>prjSiteResMapList=new ArrayList<PrjSiteResMap>();
		mstrProjectList = session.createCriteria(MstrProject.class).list();
		//departmentList = session.createCriteria(MasDepartment.class).list();
		mstrSiteList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.eq("Status", "y")).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		mstrCodeForTripList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "Trip")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		viewTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		viewApprTravelList = session.createCriteria(EtrApptbl.class).add(Restrictions.eq("Trv.Id",travelRequestId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).list();
	
		map.put("mstrProjectList", mstrProjectList);
		map.put("mstrSiteList", mstrSiteList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForTripList", mstrCodeForTripList);
		map.put("employeeList", employeeList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("countryList", countryList);
		map.put("viewTravelRequestList", viewTravelRequestList);
		map.put("currencyList", currencyList);
		map.put("etrTravelReqList", etrTravelReqList);
		map.put("viewApprTravelList", viewApprTravelList);
		return map;
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> editTravelRequest(int travelRequestId,int employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> viewTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<EtrTravelreq> etrTravelReqList  = new ArrayList<EtrTravelreq>();
		PrjSiteResMap prjSiteResMap = new PrjSiteResMap();
		List<PrjSiteResMap>prjSiteResMapList=new ArrayList<PrjSiteResMap>();
		Session session = (Session)getSession();
		List<MstrProject>mstrProjectList = new ArrayList<MstrProject>();
		List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
		List<MstrSiteHeader> mstrSiteList = new ArrayList<MstrSiteHeader>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		mstrProjectList = session.createCriteria(MstrProject.class).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		mstrSiteList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.eq("Status", "y")).list();
		//mstrCityList = session.createCriteria(MstrCity.class).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTripList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "Trip")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		viewTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		int siteId = 0;
		int projectId = 0;
		
		String siteArr [];
		if(viewTravelRequestList.size()>0){
			for(EtrTravelreq etrTravelreq :viewTravelRequestList){
				if(etrTravelreq.getSite()!= null){
					siteId = etrTravelreq.getSite().getId();
				}
				if(etrTravelreq.getPrj()!= null){
					projectId = etrTravelreq.getPrj().getId();
				}
				
				employeeId = etrTravelreq.getEmp().getId();
			}
		}
		prjSiteResMapList = session.createCriteria(PrjSiteResMap.class).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		/*try{
			if(siteName!=null&siteName.split(",").length>0){
				siteArr=siteName.split(",");
				for(int i=0;i<siteName.split(",").length;i++){
					//prjSiteResMap=	(PrjSiteResMap)session.load(PrjSiteResMap.class,Integer.parseInt(siteArr[i]));
					//prjSiteResMapList.add(prjSiteResMap);
					prjSiteResMapList =getHibernateTemplate().find("from jkt.hrms.masters.business.PrjSiteResMap as prj where prj.SiteHeader.Id = "+Integer.parseInt(siteArr[i])+"and prj.Prj.Id = "+projectId+" and prj.Employee.Id = "+employeeId+"");
				}
			}
		}
		catch(Exception e){
			
		}*/
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).list();
		map.put("mstrProjectList", mstrProjectList);
		map.put("departmentList", departmentList);
		map.put("mstrSiteList", mstrSiteList);
		map.put("masCityList", masCityList);
		map.put("prjSiteResMapList", prjSiteResMapList);
		map.put("mstrCodeForTripList", mstrCodeForTripList);
		map.put("employeeList", employeeList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("countryList", countryList);
		map.put("viewTravelRequestList", viewTravelRequestList);
		map.put("currencyList", currencyList);
		map.put("etrTravelReqList", etrTravelReqList);
		return map;
	}

	

	public Map<String, Object> updateTravelRequest(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List travelModeList =new ArrayList();
		List ticketBookingDateList =new ArrayList();
		List ticketBookingRemarkList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List etrTrvDetailIdList =new ArrayList();
		List beforeTimeList = new ArrayList();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		EtrTravelreq etrTravelreq = new EtrTravelreq();
		Session session = (Session)getSession();
		String status = "";
		if (generalMap.get("status")!= null) {
			 status = (String)generalMap.get("status");
		}
		
		if (generalMap.get("fromCountryList")!= null) {
			fromCountryList = (List)generalMap.get("fromCountryList");
		}
		if (generalMap.get("toCountryList")!= null) {
			toCountryList = (List)generalMap.get("toCountryList");
		}
		if (generalMap.get("fromPlaceList")!= null) {
			fromPlaceList = (List)generalMap.get("fromPlaceList");
		}
		if (generalMap.get("toPlaceList")!= null) {
			toPlaceList = (List)generalMap.get("toPlaceList");
		}
		if (generalMap.get("travelModeList")!= null) {
			travelModeList = (List)generalMap.get("travelModeList");
		}
		if (generalMap.get("ticketBookingDateList")!= null) {
			ticketBookingDateList = (List)generalMap.get("ticketBookingDateList");
		}
		if (generalMap.get("ticketBookingRemarkList")!= null) {
			ticketBookingRemarkList = (List)generalMap.get("ticketBookingRemarkList");
		}
		if (generalMap.get("etrTrvDetailIdList")!= null) {
			etrTrvDetailIdList = (List)generalMap.get("etrTrvDetailIdList");
		}
		int travelRequestId= 0;
		if (generalMap.get("travelRequestId")!= null) {
			travelRequestId =(Integer) generalMap.get("travelRequestId");
		}
		int employeeId = 0; 
		if (generalMap.get("employeeId")!= null) {
			employeeId =(Integer) generalMap.get("employeeId");
		}
		Date fromDate = new Date();
		if (generalMap.get("fromDate")!= null) {
			fromDate =(Date) generalMap.get("fromDate");
		}
		Date toDate = new Date();
		if (generalMap.get("toDate")!= null) {
			toDate =(Date) generalMap.get("toDate");
		}
		int projectBasedOrNonPrijectBasedTrip=0;
		if (generalMap.get("projectBasedOrNonPrijectBasedTrip")!= null) {
			projectBasedOrNonPrijectBasedTrip =(Integer) generalMap.get("projectBasedOrNonPrijectBasedTrip");
		}
		String comments = "";
		if (generalMap.get("comments")!= null) {
			comments =(String) generalMap.get("comments");
		}
		int tripId = 0;
		if (generalMap.get("tripId")!= null) {
			tripId =(Integer) generalMap.get("tripId");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate")!= null) {
			currentDate =(Date) generalMap.get("currentDate");
		}
		String hotelDesc = "";
		if (generalMap.get("hotelDesc")!= null) {
			hotelDesc =(String) generalMap.get("hotelDesc");
		}
		String cabDesc= "";
		
		if (generalMap.get("cabDesc")!= null) {
			cabDesc =(String) generalMap.get("cabDesc");
		}
		String needAdvance = "";
		BigDecimal  advanceAmount = new BigDecimal("0");
		Date expectedOnDate = null;
		int currencyId = 0;
		String description = "";
			if(generalMap.get("needAdvance")!= null){
				needAdvance = (String)generalMap.get("needAdvance");
			}
			
			if (generalMap.get("advanceAmount")!= null) {
				advanceAmount =(BigDecimal) generalMap.get("advanceAmount");
			}
			if (generalMap.get("expectedOnDate")!= null) {
				expectedOnDate =(Date) generalMap.get("expectedOnDate");
			}
			if (generalMap.get("currencyId")!= null) {
				currencyId =(Integer) generalMap.get("currencyId");
			}
			if (generalMap.get("description")!= null) {
				description =(String) generalMap.get("description");
			}
	
		String hotelBooking = "";
		if(generalMap.get("hotelBooking")!= null){
			hotelBooking = (String)generalMap.get("hotelBooking");
		}
		
		String cabBooking = "y";
		if(generalMap.get("cabBooking")!= null){
			cabBooking = (String)generalMap.get("cabBooking");
		}
		
		String ticketBooking = "";
		if(generalMap.get("ticketBooking")!= null){
			ticketBooking = (String)generalMap.get("ticketBooking");
		}
		
		int selectLineManagerAndOther=0; 
		if (generalMap.get("selectLineManagerAndOther")!= null) {
			selectLineManagerAndOther =(Integer) generalMap.get("selectLineManagerAndOther");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		 etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		etrTravelreq.setEmp(masEmployee);
		etrTravelreq.setCreatedBy(masEmployee);
		etrTravelreq.setModifiedBy(masEmployee);
		if(status.equalsIgnoreCase("SendBack")){
			etrTravelreq.setTrvStatus(" ReSumitted");
		}
		
		etrTravelreq.setJfdate(fromDate);
		etrTravelreq.setJtdate(toDate);
		etrTravelreq.setProjectTrip(projectBasedOrNonPrijectBasedTrip);
		etrTravelreq.setCreatedAt(currentDate);
		etrTravelreq.setModifiedAt(currentDate);
		etrTravelreq.setComment(comments);
		etrTravelreq.setHotelDesc(hotelDesc);
		etrTravelreq.setLocalCabDesc(cabDesc);
		etrTravelreq.setAdvAmt(advanceAmount);
		etrTravelreq.setAdvExpDate(expectedOnDate);
		etrTravelreq.setAdvDesc(description);
		etrTravelreq.setNAFHotel(hotelBooking);
		etrTravelreq.setNAFLocalCab(cabBooking);
		etrTravelreq.setNAFTicket(ticketBooking);
		etrTravelreq.setAvdReq(needAdvance);
		int siteId= 0;
		if (generalMap.get("siteId")!= null) {
			siteId =(Integer) generalMap.get("siteId");
			MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
			mstrSiteHeader.setId(siteId);
			etrTravelreq.setSite(mstrSiteHeader);
		}
		
		if (generalMap.get("currencyId")!= null) {
			currencyId =(Integer) generalMap.get("currencyId");
			MasCurrency masCurrency = new MasCurrency();
			masCurrency.setId(currencyId);
			etrTravelreq.setAdvcurid(masCurrency);
		}
		
		
		
		int projectId = 0;
		if (generalMap.get("projectId")!= null) {
			projectId =(Integer) generalMap.get("projectId");
			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			etrTravelreq.setPrj(mstrProject);
		}
		
		
		MstrCode mstrCode = new MstrCode();
		mstrCode.setId(tripId);
		etrTravelreq.setTrip(mstrCode);
		EtrTrvdetails etrTrvdetails = new EtrTrvdetails();
		int etrTrvDeatilId = 0;
		if(etrTrvDetailIdList.size()>0){
			for (int i = 0; i < etrTrvDetailIdList.size(); i++) {
				 etrTrvDeatilId = Integer.parseInt(etrTrvDetailIdList.get(i).toString());
				etrTrvdetails = (EtrTrvdetails)hbt.load(EtrTrvdetails.class, etrTrvDeatilId);
				if(fromPlaceList.get(i) != null){
					int fromPlaceId = Integer.parseInt(fromPlaceList.get(i).toString());
					//MstrCity mstrCity = new MstrCity();
					//mstrCity.setId(fromPlaceId);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(fromPlaceId);
					etrTrvdetails.setFrmPlce(masDistrict);
				}
				if(toPlaceList.get(i) != null){
					int toPlaceId = Integer.parseInt(toPlaceList.get(i).toString());
					//MstrCity mstrCity = new MstrCity();
					//mstrCity.setId(toPlaceId);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(toPlaceId);
					etrTrvdetails.setToPlce(masDistrict);
					
				}
				if(fromCountryList.size()>0){
				if(fromCountryList.get(i) != null){
					int fromCountryId = Integer.parseInt(fromCountryList.get(i).toString());
					MasCountry masCountry = new MasCountry();
					masCountry.setId(fromCountryId);
					etrTrvdetails.setFromCountry(masCountry);	
				}
				}
				if(toCountryList.size()>0){
				if(toCountryList.get(i) != null){
					int toCountryId = Integer.parseInt(toCountryList.get(i).toString());
					MasCountry masCountry = new MasCountry();
					masCountry.setId(toCountryId);
					etrTrvdetails.setToCountry(masCountry);	
				}
				}
				if(travelModeList.get(i) != null){
					MstrCode mstrCode2 = new MstrCode();
					int travelModeId  = Integer.parseInt(travelModeList.get(i).toString());
					mstrCode2.setId(travelModeId);
					etrTrvdetails.setTrip(mstrCode2);
				}
				if(ticketBookingDateList.get(i) != null){
					Date ticketBookingDate  = HMSUtil.convertStringTypeDateToDateType(ticketBookingDateList.get(i).toString());
					etrTrvdetails.setBDate(ticketBookingDate);
				}
				if(beforeTimeList.size()>0){
				if(beforeTimeList.get(i) != null){
					String beforeTime  = (String)(beforeTimeList.get(i).toString());		
					etrTrvdetails.setBeforeTime(beforeTime);
				}
				}
				if(ticketBookingRemarkList.size()>0){
				if(ticketBookingRemarkList.get(i) != null){
					String ticketBookingRemark  = (String)(ticketBookingRemarkList.get(i).toString());		
					etrTrvdetails.setRemarks(ticketBookingRemark);
				}
				}
				hbt.update(etrTrvdetails);	
			}
		}
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).addOrder(Order.desc("Jfdate")).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		return map;
	}
// ffff
	public Map<String, Object> cancelNewTravelRequest(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etravelReqList = new ArrayList<EtrTravelreq>();
		Set<EtrTrvreqcmts> etrTrvreqcmtsSet= new HashSet<EtrTrvreqcmts>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> applicantList = new ArrayList<MasEmployee>();
		
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId =(Integer)generalMap.get("travelRequestId");
		}
		String remarksForCancelation = "";
		if(generalMap.get("remarksForCancelation")!= null){
			remarksForCancelation = (String)generalMap.get("remarksForCancelation");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId =(Integer)generalMap.get("employeeId");
		}
		Session session = (Session)getSession();
		etravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		//EtrTravelreq etrTravelreq = etravelReqList.get(0);
		EtrTravelreq etrTravelreq = new EtrTravelreq();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		 etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		
		 etrTravelreq.setTrvStatus("CancelByEmp");
		 etrTravelreq.setCnclCmts(remarksForCancelation);
		 hbt.update(etrTravelreq);
		 
		 for(EtrTravelreq etrTravelreq2 :etravelReqList){
			 etrTrvreqcmtsSet = etrTravelreq2.getEtrTrvreqcmts();
		 }
		 int etrTrvreqcmtsId = 0;
		 for(EtrTrvreqcmts  etrTrvreqcmts:etrTrvreqcmtsSet){
			 etrTrvreqcmtsId = (Integer)etrTrvreqcmts.getId();
		 }
		
		 EtrTrvreqcmts etrTrvreqcmts  = new EtrTrvreqcmts();
		 etrTrvreqcmts = (EtrTrvreqcmts)hbt.load(EtrTrvreqcmts.class, etrTrvreqcmtsId);
		 Date currentDate = new Date();
		 etrTravelreq.setId(travelRequestId);
		 etrTrvreqcmts.setTrv(etrTravelreq);
		 etrTrvreqcmts.setStrSts("Cancel Request");
		 MasEmployee masEmployee = new MasEmployee();
		 masEmployee.setId(employeeId);
		 etrTrvreqcmts.setCreatedBY(masEmployee);
		 etrTrvreqcmts.setCreatedAt(currentDate);
		 hbt.update(etrTrvreqcmts);
		 
			int lineManagerId = 0;
			int applicantId = 0;
			String refNo = "";
			Date fromDate = null;
			Date toDate = null;
			String recipientAddresses = "";
			String fromAddress  = "";
			 String ccAddress = "";
			if(etravelReqList.size()>0){
				for(EtrTravelreq etrTravelreq1 :etravelReqList){
					lineManagerId = etrTravelreq1.getEmp().getLineManager().getId();
					applicantId = etrTravelreq1.getEmp().getId();
					refNo = etrTravelreq1.getRefNo();
					fromDate = etrTravelreq1.getJfdate();
					toDate = etrTravelreq1.getJtdate();
					
				}
			}
		String applicantName ="";
		String approverName = "";
		String titleName = "";
		
		applicantList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(applicantId)).list();
		if(applicantList.size()>0){
			for(MasEmployee employee:applicantList){
			applicantName = employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getLastName();
			approverName = employee.getLineManager().getFirstName()+" "+employee.getLineManager().getMiddleName()+" "+employee.getLineManager().getLastName();
			titleName = employee.getLineManager().getTitle().getTitleName();
			recipientAddresses = employee.getLineManager().getEmail();
			//recipientAddresses = "ritu.sahu@jktech.com";
			fromAddress = employee.getEmail();
			//fromAddress = "vishal.jain@jktech.com";
			ccAddress = employee.getEmail();
			//ccAddress = "vishal.jain@jktech.com";
		}
	}
			String emailMessage = "";
			 emailMessage = "Dear "+ titleName + " " + approverName+ ",\n";
			 emailMessage =emailMessage+" "+applicantName +" has initiated Travel Cancellation against Travel Request  "+
			 refNo+" for "+HMSUtil.convertDateToStringWithoutTime(fromDate)+
				" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n"+
				"For details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
			 
			 List<String> recipientAddressesList = new ArrayList<String>();
				List<String> ccAddressesList = new ArrayList<String>();
				List<String> bccAddresses = new ArrayList<String>();
				
				String subject = "Travel Request Cancellation";
		    	String ccAddress1 = "adminhelp@clinirx.com";
			//	String ccAddress1 = "mhwani@clinirx.com";
				recipientAddressesList.add(recipientAddresses);
				ccAddressesList.add(ccAddress);
				ccAddressesList.add(ccAddress1);
				boolean sent=false;
				if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
					LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
				}
		employeeList  = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		 etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).addOrder(Order.desc("Jfdate")).list();
			map.put("etrTravelRequestList", etrTravelRequestList);
			map.put("employeeList", employeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTravelApprovalRequest(int employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		List<Object[]> departmentList = new ArrayList<Object[]>();
		List<Object[]> organiztionList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").createAlias("emp.LineManager", "lineManager").add(Restrictions.eq("lineManager.Id", employeeId)).addOrder(Order.desc("Jfdate")).list();
		employeeList=getHibernateTemplate().find("select me.Id,me.EmployeeCode, me.FirstName,me.MiddleName,me.LastName,me.LineManager.Id,me.LineManager.FirstName,me.LineManager.MiddleName,me.LineManager.LastName,me.Department.Id,me.Status from jkt.hms.masters.business.MasEmployee as me where me.Status = 'y'and me.LineManager = "+ employeeId);
		departmentList=getHibernateTemplate().find("select md.Id, md.DepartmentName,md.Status from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		organiztionList = getHibernateTemplate().find("select mh.Id, mh.HospitalName,mh.Status from jkt.hms.masters.business.MasHospital as mh where mh.Status = 'y'");
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("organiztionList", organiztionList);
		return map;
	}
	public Map<String, Object> searchTravelApprovalRequest(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		int searchEmployeeId = 0; 
		int employeeId=0;
		if(generalMap.get("searchEmployeeId")!= null){
			searchEmployeeId = (Integer)generalMap.get("searchEmployeeId");
		}
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		int searchRefNoId = 0;
		if(generalMap.get("searchRefNoId")!= null){
			searchRefNoId = (Integer)generalMap.get("searchRefNoId");
		}
		Date fromDate = null;
		if(generalMap.get("fromDate")!= null){
			fromDate = (Date)generalMap.get("fromDate");
		}
		
		Date toDate = null;
		if(generalMap.get("toDate")!= null){
			toDate = (Date)generalMap.get("toDate");
		}
		Session session = (Session)getSession();
		Criteria crit = null;
		crit = session.createCriteria(EtrTravelreq.class);
		
		if(searchEmployeeId != 0){
			crit = crit.createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", searchEmployeeId));
		}	
		else if(employeeId != 0)

		{
			crit = crit.createAlias("Emp", "empl").createAlias("empl.LineManager", "lineManager").add(Restrictions.eq("lineManager.Id", employeeId));
		}
		
		
		
		if(searchRefNoId != 0){
			crit = crit.add(Restrictions.idEq(searchRefNoId));
		}
		
		if(fromDate != null || toDate!= null ){
			crit = crit.add(Restrictions.gt("Jfdate", fromDate)).add(Restrictions.lt("Jtdate", toDate));
			
		}
		
		etrTravelRequestList = crit.list();
		employeeList=getHibernateTemplate().find("select me.Id,me.EmployeeCode, me.FirstName,me.MiddleName,me.LastName,me.LineManager.Id,me.LineManager.FirstName,me.LineManager.MiddleName,me.LineManager.LastName,me.Department.Id,me.Status from jkt.hms.masters.business.MasEmployee as me where me.Status = 'y'and me.LineManager = "+ employeeId);
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList",employeeList);
		return map;
	}

	public Map<String, Object> updateApprovalStatus(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etravelReqList = new ArrayList<EtrTravelreq>();
		List<EtrTrvreqcmts> etrTrvreqcmtsList= new ArrayList<EtrTrvreqcmts>();
		List<EtrApptbl> etrApptblList= new ArrayList<EtrApptbl>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		List<Object[]> departmentList = new ArrayList<Object[]>();
		List<MasEmployee> lineManagerList = new ArrayList<MasEmployee>();
		List travelRequestIdList =new ArrayList();
		String lineManager = "";
		if(generalMap.get("travelRequestIdList")!= null){
			travelRequestIdList = (List)generalMap.get("travelRequestIdList");
		}
		String approvalStatus = "";
		if(generalMap.get("approvalStatus")!= null){
			approvalStatus =(String)generalMap.get("approvalStatus");
		}
		String remark = "";
		if(generalMap.get("remark")!= null){
			remark =(String)generalMap.get("remark");
		}
		int lineManagerId = 0;
		if(generalMap.get("lineManagerId")!= null){
			lineManagerId =(Integer)generalMap.get("lineManagerId");
		}
		int headeId = 0;
		if(generalMap.get("headeId")!= null){
			headeId =(Integer)generalMap.get("headeId");
		}
		String other = "";
		if(generalMap.get("other")!= null){
			other =(String)generalMap.get("other");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		int travelRequestId = 0;
		int employeeId = 0;
		Date fromDate = null;
		Date toDate = null;
		String refNo = "";
		String recipientAddresses = "";
		Date applicationDate = null;
		Date currentDate = new Date();
		 int approverId = 0;
		 String titleName = "";
		 String lineManagerName = "";
		 String applicantName = "";
		 String ccAddress = "";
		 String ticketStatus = "";
		 String advanceStatus = "";
		 String fromAddress  = "";
		
		if(travelRequestIdList.size()>0){
			for (int i = 0; i < travelRequestIdList.size(); i++) {
				if(travelRequestIdList.get(i) != null){
					travelRequestId = Integer.parseInt(travelRequestIdList.get(i).toString());
				}
		
		EtrTravelreq etrTravelreq = new EtrTravelreq();
		Session session = (Session)getSession();
		etravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		 employeeId = etrTravelreq.getEmp().getId();
		 fromDate = etrTravelreq.getJfdate();
		 toDate = etrTravelreq.getJtdate();
		 refNo = etrTravelreq.getRefNo();
		 applicationDate = etrTravelreq.getCreatedAt();
		 ticketStatus = etrTravelreq.getNAFTicket();
		 advanceStatus = etrTravelreq.getAvdReq();
		
		 lineManagerList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).list();
		 if(lineManagerList.size()>0){
			 for(MasEmployee emp :lineManagerList){
				  lineManagerId = emp.getLineManager().getId();
				  //lineManagerName = emp.getLineManager().getFirstName()+"" +emp.getLineManager().getMiddleName()+" "+emp.getLineManager().getLastName();
				  titleName = emp.getTitle().getTitleName();
				  applicantName = emp.getFirstName()+" "+emp.getMiddleName()+" "+emp.getLastName();
				  recipientAddresses = emp.getEmail();
				 //recipientAddresses = "vishal.jain@jktech.com";
				 ccAddress = emp.getLineManager().getEmail();
				 fromAddress = emp.getLineManager().getEmail();
				  //ccAddress = "ritu.sahu@jktech.com";
				// fromAddress = "ritu.sahu@jktech.com";
					
			 }
		 }
		 String emailMessage = "";
		 emailMessage = "Dear "+ titleName + " " + applicantName+ ",\n";
	if(approvalStatus.equals("approve")){
			etrTravelreq.setTrvStatus("Approved");
			if(etrTravelreq.getAvdReq().equals("y")){
				etrTravelreq.setAdvStrSts("Payment Pending");
			}else{
				etrTravelreq.setAdvStrSts("N/A");
			}
			if(etrTravelreq.getNAFHotel().equals("y") || etrTravelreq.getNAFLocalCab().equals("y") || etrTravelreq.getNAFTicket().equals("y")  ){
				etrTravelreq.setBookStatus("Pending");
			}else{
				etrTravelreq.setBookStatus("N/A");
			}
			hbt.update(etrTravelreq);
			
			
			etrApptblList = session.createCriteria(EtrApptbl.class).createAlias("Trv", "trv").add(Restrictions.eq("trv.Id", travelRequestId)).list();
			int etrApptblId = 0;
			if(etrApptblList.size()>0){
			 for(EtrApptbl etrApptbl :etrApptblList){
				 etrApptblId = etrApptbl.getId();
				 //lineManager = etrApptbl.getTrv().getEmp().getLineManager().getFirstName()+" "+etrApptbl.getTrv().getEmp().getLineManager().getLastName();
			 }
			}
			 MasEmployee masEmployee = new MasEmployee();
			try{
			 EtrApptbl etrApptbl = new EtrApptbl();
			 etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
			 etrApptbl.setCmts(remark);
			 etrApptbl.setApprDate(currentDate);
			 etrApptbl.setApprTime(time);
			 etrApptbl.setApprSts("approve");
			 etrTravelreq.setId(travelRequestId);
			 etrApptbl.setTrv(etrTravelreq);
			 masEmployee.setId(lineManagerId);
			 etrApptbl.setAppr(masEmployee);
			 hbt.update(etrApptbl);
			 EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
			 etrTravelreq.setId(travelRequestId);
			 etrTrvreqcmts.setTrv(etrTravelreq);
			 etrTrvreqcmts.setStrSts("Approved");
			 etrTrvreqcmts.setCreatedBY(masEmployee);
			 etrTrvreqcmts.setCreatedAt(currentDate);
			 hbt.save(etrTrvreqcmts);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			 emailMessage = emailMessage = emailMessage +" Your Travel Request "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(applicationDate)+" for a travel "+
				HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
				"has been approved on"+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+"Remark--"+remark+
				
				"\n\nFor details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
			 
		}else if(approvalStatus .equals("reject") ){
			try{
				etrTravelreq.setTrvStatus("Rejected");
				hbt.update(etrTravelreq);
				int etrApptblId = 0;
				etrApptblList = session.createCriteria(EtrApptbl.class).createAlias("Trv", "trv").add(Restrictions.eq("trv.Id", travelRequestId)).list();
				if(etrApptblList.size()>0){
				for(EtrApptbl etrApptbl :etrApptblList){
					 etrApptblId = etrApptbl.getId();
					 lineManager = etrApptbl.getTrv().getEmp().getLineManager().getFirstName()+" "+etrApptbl.getTrv().getEmp().getLineManager().getLastName();
				 }
				}
				//Date currentDate = new Date();
				EtrApptbl etrApptbl = new EtrApptbl();
				etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
				etrApptbl.setCmts(remark);
				 etrApptbl.setApprDate(currentDate);
				 etrApptbl.setApprTime(time);
				 etrApptbl.setApprSts("reject");
				 etrTravelreq.setId(travelRequestId);
				 etrApptbl.setTrv(etrTravelreq);
				 MasEmployee masEmployee = new MasEmployee();
				 masEmployee.setId(lineManagerId);
				 etrApptbl.setAppr(masEmployee);
				 hbt.update(etrApptbl);
				 
				 EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
				 etrTravelreq.setId(travelRequestId);
				 etrTrvreqcmts.setTrv(etrTravelreq);
				 etrTrvreqcmts.setStrSts("Rejected ");
				 etrTrvreqcmts.setCreatedBY(masEmployee);
				 etrTrvreqcmts.setCreatedAt(currentDate);
				 hbt.save(etrTrvreqcmts);
			}catch(Exception e){
				e.printStackTrace();
			}
				 emailMessage = emailMessage = emailMessage +" Your Travel Request "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(applicationDate)+" for a travel "+
					HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
					"has been rejected on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+"Remark--"+remark+
					
					"\n\nFor details of the same, kindly log in your omega account.\n\n\n\n"+
					"This is an auto generated mail through OMEGA. Do not reply.";
		}else if(approvalStatus.equals("forward")){
			
			    try{
				 etrTravelreq.setTrvStatus("Forward");
				 hbt.update(etrTravelreq);
				 int etrApptblId = 0;
				 etrApptblList = session.createCriteria(EtrApptbl.class).createAlias("Trv", "trv").add(Restrictions.eq("trv.Id", travelRequestId)).list();
					if(etrApptblList.size()>0){
					 for(EtrApptbl etrApptbl :etrApptblList){
						 etrApptblId = etrApptbl.getId();
						 lineManager = etrApptbl.getTrv().getEmp().getLineManager().getFirstName()+" "+etrApptbl.getTrv().getEmp().getLineManager().getLastName();
					 }
					}
			//	Date currentDate = new Date();
				EtrApptbl etrApptbl = new EtrApptbl();
				etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
				etrApptbl.setCmts(remark);
				 etrApptbl.setApprDate(currentDate);
				 etrApptbl.setApprTime(time);
				 etrApptbl.setApprSts("forward");
				 etrTravelreq.setId(travelRequestId);
				 etrApptbl.setTrv(etrTravelreq);
				 if(other.equals("y")){
					 MasEmployee masEmployee1 = new MasEmployee();
					 masEmployee1.setId(headeId);
					 etrApptbl.setAppr(masEmployee1);
				 }else if(other.equals("n")){
					 MasEmployee masEmployee2 = new MasEmployee();
					 masEmployee2.setId(lineManagerId);
					 etrApptbl.setAppr(masEmployee2);
				 }
				
				 hbt.update(etrApptbl);
				 
				 EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
				 etrTravelreq.setId(travelRequestId);
				 etrTrvreqcmts.setTrv(etrTravelreq);
				 etrTrvreqcmts.setStrSts("Forwared");
				 MasEmployee masEmployee = new MasEmployee();
				 masEmployee.setId(employeeId);
				 etrTrvreqcmts.setCreatedBY(masEmployee);
				 etrTrvreqcmts.setCreatedAt(currentDate);
				 hbt.save(etrTrvreqcmts);
			    }catch(Exception e){
			    	e.printStackTrace();
			    }
				 emailMessage = emailMessage = emailMessage +" Your Travel Request "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(applicationDate)+" for a travel "+
					HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
					"has been forward on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+"Remark--"+remark+
					"\n\nFor details of the same, kindly log in your omega account.\n\n\n\n"+
					"This is an auto generated mail through OMEGA. Do not reply.";
				}else if(approvalStatus .equals("sendBack") ){
					try{
					etrTravelreq.setTrvStatus("SendBack");
					hbt.update(etrTravelreq);
					int etrApptblId = 0;
					etrApptblList = session.createCriteria(EtrApptbl.class).createAlias("Trv", "trv").add(Restrictions.eq("trv.Id", travelRequestId)).list();
					if(etrApptblList.size()>0){
					for(EtrApptbl etrApptbl :etrApptblList){
						 etrApptblId = etrApptbl.getId();
						 lineManager = etrApptbl.getTrv().getEmp().getLineManager().getFirstName()+" "+etrApptbl.getTrv().getEmp().getLineManager().getLastName();
					 }
					}
				//	Date currentDate = new Date();
					EtrApptbl etrApptbl = new EtrApptbl();
					etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
					etrApptbl.setCmts(remark);
					 etrApptbl.setApprDate(currentDate);
					 etrApptbl.setApprTime(time);
					 etrApptbl.setApprSts("sendBack");
					 etrTravelreq.setId(travelRequestId);
					 etrApptbl.setTrv(etrTravelreq);
					 MasEmployee masEmployee = new MasEmployee();
					 masEmployee.setId(lineManagerId);
					 etrApptbl.setAppr(masEmployee);
					 hbt.update(etrApptbl);
					 
					 EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
					 etrTravelreq.setId(travelRequestId);
					 etrTrvreqcmts.setTrv(etrTravelreq);
					 etrTrvreqcmts.setStrSts("sendBack");
					 etrTrvreqcmts.setCreatedBY(masEmployee);
					 etrTrvreqcmts.setCreatedAt(currentDate);
					 hbt.save(etrTrvreqcmts);
					}catch(Exception e){
						e.printStackTrace();
					}
					 emailMessage = emailMessage = emailMessage +" Your Travel Request "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(applicationDate)+" for a travel "+
						HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
						"has been sendBack on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+"Remark--"+remark+
						"\n\nFor details of the same, kindly log in your omega account.\n\n\n\n"+
						"This is an auto generated mail through OMEGA. Do not reply.";
			}
	List<String> recipientAddressesList = new ArrayList<String>();
	List<String> ccAddressesList = new ArrayList<String>();
	List<String> bccAddresses = new ArrayList<String>();
	
	String subject = "Travel Approval";
		 String ccAddress1  = "adminhelp@clinirx.com";
	//	 String ccAddress1  = "mhwani@clinirx.com";
		String ccAddress2 = "accountshelp@clinirx.com";
	//	 String ccAddress2 = "mhwani@clinirx.com";
	
	if(recipientAddresses != null  && !recipientAddresses.equals("")&& fromAddress != null && !fromAddress.equals("") ){
		recipientAddressesList.add(recipientAddresses);
		  if(ticketStatus.equals("y") && (advanceStatus.equals("y"))){
			//  ccAddress = ccAddress+","+ccAddress1+","+ccAddress2;
			  ccAddressesList.add(ccAddress);
			 ccAddressesList.add(ccAddress1);
			 ccAddressesList.add(ccAddress2);
			 }else if(ticketStatus.equals("y") && (advanceStatus.equals("n"))){
				 ccAddressesList.add(ccAddress);
				  ccAddressesList.add(ccAddress1);
				 //ccAddress = ccAddress+","+ccAddress1;
			 }else if(ticketStatus.equals("n") && (advanceStatus.equals("y"))){
				 ccAddressesList.add(ccAddress);
				 ccAddressesList.add(ccAddress2);
				 //ccAddress = ccAddress+","+ccAddress2;
			 }else if(ticketStatus.equals("n") && (advanceStatus.equals("n"))){
				 //ccAddress = ccAddress;
				ccAddressesList.add(ccAddress);
			 }
		  //ccAddressesList.add(ccAddress);
		LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
	
		}
				
      }
  }	
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").createAlias("emp.LineManager", "lineManager").add(Restrictions.eq("lineManager.Id", lineManagerId)).addOrder(Order.desc("Jfdate")).list();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		employeeList=getHibernateTemplate().find("select me.Id,me.EmployeeCode, me.FirstName,me.MiddleName,me.LastName,me.LineManager.Id,me.LineManager.FirstName,me.LineManager.MiddleName,me.LineManager.LastName,me.Department.Id,me.Status from jkt.hms.masters.business.MasEmployee as me where me.Status = 'y'");
		departmentList=getHibernateTemplate().find("select md.Id, md.DepartmentName,md.Status from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		return map;
	}
	public Map<String, Object> viewTravelApprovalRequest(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> viewTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<EtrTravelreq> etrTravelReqList  = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		List<Object[]>mstrProjectList = new ArrayList<Object[]>();
		List<Object[]>departmentList = new ArrayList<Object[]>();
		List<Object[]> mstrSiteList = new ArrayList<Object[]>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<PrjSiteResMap>prjSiteResMapList=new ArrayList<PrjSiteResMap>();
		
		mstrProjectList=getHibernateTemplate().find("select mp.Id, mp.PrjName from jkt.hrms.masters.business.MstrProject as mp ");
		//mstrProjectList = session.createCriteria(MstrProject.class).list();
		//departmentList = session.createCriteria(MasDepartment.class).list();
		departmentList=getHibernateTemplate().find("select md.Id, md.DepartmentName,md.Status from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		//mstrSiteList = session.createCriteria(MstrSiteHeader.class).list();
		mstrSiteList=getHibernateTemplate().find("select msd.Id, msd.SiteName from jkt.hrms.masters.business.MstrSiteHeader as msd where msd.Status = 'y' ");
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTripList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "Trip")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		viewTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).list();
		int siteId = 0;
		int projectId = 0;
		int employeeId = 0;
		
		if(viewTravelRequestList.size()>0){
			for(EtrTravelreq etrTravelreq :viewTravelRequestList){
				if(etrTravelreq.getSite()!= null){
					siteId = etrTravelreq.getSite().getId();
				}
				if(etrTravelreq.getPrj()!= null){
					projectId = etrTravelreq.getPrj().getId();
				}
				employeeId = etrTravelreq.getEmp().getId();
			}
		}
		prjSiteResMapList = session.createCriteria(PrjSiteResMap.class).createAlias("SiteHeader", "header").add(Restrictions.eq("header.Id", siteId)).createAlias("Prj", "prj").add(Restrictions.eq("prj.Id", projectId)).createAlias("Employee", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		
		map.put("prjSiteResMapList", prjSiteResMapList);
		map.put("mstrProjectList", mstrProjectList);
		map.put("departmentList", departmentList);
		map.put("mstrSiteList", mstrSiteList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForTripList", mstrCodeForTripList);
		map.put("employeeList", employeeList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("countryList", countryList);
		map.put("viewTravelRequestList", viewTravelRequestList);
		map.put("currencyList", currencyList);
		map.put("etrTravelReqList", etrTravelReqList);
		
		return map;
	}

	public Map<String, Object> updateTravelApprovalRequest(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> lineManagerList = new ArrayList<MasEmployee>();
		List<EtrTravelreq> etravelReqList = new ArrayList<EtrTravelreq>();
		List<EtrTrvreqcmts> etrTrvreqcmtsList= new ArrayList<EtrTrvreqcmts>();
		Set<EtrApptbl> etrApptblSet= new HashSet<EtrApptbl>();
		int travelRequestId = 0;
		String lineManager = "";
		String emailIdOfUser = "";
		if(generalMap.get("emailIdOfUser")!= null){
			emailIdOfUser = (String)generalMap.get("emailIdOfUser");
		}
		
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId = (Integer)generalMap.get("travelRequestId");
		}
		String approvalStatus = "";
		if(generalMap.get("approvalStatus")!= null){
			approvalStatus =(String)generalMap.get("approvalStatus");
		}
		String remark = "";
		if(generalMap.get("remark")!= null){
			remark =(String)generalMap.get("remark");
		}
		int lineManagerId = 0;
		if(generalMap.get("lineManagerId")!= null){
			lineManagerId =(Integer)generalMap.get("lineManagerId");
		}
		int headeId = 0;
		if(generalMap.get("headeId")!= null){
			headeId =(Integer)generalMap.get("headeId");
		}
		String other = "";
		if(generalMap.get("other")!= null){
			other =(String)generalMap.get("other");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		Date fromDate = null;
		Date toDate = null;
		String refNo = "";
		String recipientAddresses = "";
		Date applicationDate = null;
		 int approverId = 0;
		 String titleName = "";
		 String lineManagerName = "";
		 String applicantName = "";
		 String ccAddress = "";
		 String ticketStatus = "";
		 String advanceStatus = "";
		 String fromAddress  = "";
		
		EtrTravelreq etrTravelreq = new EtrTravelreq();
		Session session = (Session)getSession();
		etravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		int employeeId1 = etrTravelreq.getEmp().getId();
		fromDate = etrTravelreq.getJfdate();
		 toDate = etrTravelreq.getJtdate();
		 refNo = etrTravelreq.getRefNo();
		 applicationDate = etrTravelreq.getCreatedAt();
		 ticketStatus = etrTravelreq.getNAFTicket();
		 advanceStatus = etrTravelreq.getAvdReq();
		 lineManagerList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId1)).list();
		 int employeeId = 0;
		 if(lineManagerList.size()>0){
			 for(MasEmployee emp :lineManagerList){
				 employeeId = emp.getLineManager().getId();
				 //lineManagerId = emp.getLineManager().getId();
				  //lineManagerName = emp.getLineManager().getFirstName()+"" +emp.getLineManager().getMiddleName()+" "+emp.getLineManager().getLastName();
				  titleName = emp.getTitle().getTitleName();
				  applicantName = emp.getFirstName()+" "+emp.getMiddleName()+" "+emp.getLastName();
				  recipientAddresses = emp.getEmail();
				  //recipientAddresses = "vishal.jain@jktech.com";
				  ccAddress = emp.getLineManager().getEmail();
				  fromAddress = emp.getLineManager().getEmail();
				  //ccAddress = "ritu.sahu@jktech.com";
				 // fromAddress = "ritu.sahu@jktech.com";
				 
			 }
		 }
		 String emailMessage = "";
		 emailMessage = "Dear "+ titleName + " " + applicantName+ ",\n";
	if(approvalStatus.equals("approve")){
			etrTravelreq.setTrvStatus("Approved");
			if(etrTravelreq.getAvdReq().equals("y")){
				etrTravelreq.setAdvStrSts("Payment Pending");
			}else{
				etrTravelreq.setAdvStrSts("N/A");
			}
			if(etrTravelreq.getNAFHotel().equals("y") || etrTravelreq.getNAFLocalCab().equals("y") || etrTravelreq.getNAFTicket().equals("y")  ){
				etrTravelreq.setBookStatus("Pending");
			}else{
				etrTravelreq.setBookStatus("N/A");
			}
			hbt.update(etrTravelreq);
			
			
			//etrApptblList = session.createCriteria(EtrApptbl.class).createAlias("Trv", "trv").add(Restrictions.eq("trv.Id", travelRequestId)).list();
			int etrApptblId = 0;
			 for(EtrTravelreq etrTravelreq2 :etravelReqList){
				 etrApptblSet = etrTravelreq2.getEtrApptbls();
				 lineManager = etrTravelreq2.getEmp().getLineManager().getFirstName()+" "+etrTravelreq2.getEmp().getLineManager().getLastName();
			 }
			 for(EtrApptbl  etrApptbl:etrApptblSet){
				 etrApptblId = (Integer)etrApptbl.getId();
			 }
			 Date currentDate = new Date();
			EtrApptbl etrApptbl = new EtrApptbl();
			etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
			 etrApptbl.setCmts(remark);
			 etrApptbl.setApprDate(currentDate);
			 etrApptbl.setApprTime(time);
			 etrApptbl.setApprSts("approve");
			 etrTravelreq.setId(travelRequestId);
			 etrApptbl.setTrv(etrTravelreq);
			 MasEmployee masEmployee = new MasEmployee();
			 masEmployee.setId(lineManagerId);
			 etrApptbl.setAppr(masEmployee);
			 hbt.update(etrApptbl);
			 
			
			 EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
			 etrTravelreq.setId(travelRequestId);
			 etrTrvreqcmts.setTrv(etrTravelreq);
			 etrTrvreqcmts.setStrSts("Approved");
			 MasEmployee emp = new MasEmployee();
			 emp.setId(employeeId1);
			 etrTrvreqcmts.setCreatedBY( emp);
			 etrTrvreqcmts.setCreatedAt(currentDate);
			 hbt.save(etrTrvreqcmts);
			 emailMessage = emailMessage = emailMessage +" Your Travel Request "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(applicationDate)+" for a travel "+
				HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
				"has been approved on"+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+"Remark--"+remark+
				"\n\nFor details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
	}else if(approvalStatus .equals("reject") ){
			etrTravelreq.setTrvStatus("Rejected");
			hbt.update(etrTravelreq);
			int etrApptblId = 0;
			 for(EtrTravelreq etrTravelreq2 :etravelReqList){
				 etrApptblSet = etrTravelreq2.getEtrApptbls();
				 lineManager = etrTravelreq2.getEmp().getLineManager().getFirstName()+" "+etrTravelreq2.getEmp().getLineManager().getLastName();
			 }
			 for(EtrApptbl  etrApptbl:etrApptblSet){
				 etrApptblId = (Integer)etrApptbl.getId();
			 }
			 Date currentDate = new Date();
			EtrApptbl etrApptbl = new EtrApptbl();
			etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
			etrApptbl.setApprDate(currentDate);
			 etrApptbl.setApprTime(time);
			etrApptbl.setCmts(remark);
			 etrApptbl.setApprSts("reject");
			 etrTravelreq.setId(travelRequestId);
			 etrApptbl.setTrv(etrTravelreq);
			 MasEmployee masEmployee = new MasEmployee();
			 masEmployee.setId(lineManagerId);
			 etrApptbl.setAppr(masEmployee);
			 hbt.update(etrApptbl);
		
			 EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
			 etrTravelreq.setId(travelRequestId);
			 etrTrvreqcmts.setTrv(etrTravelreq);
			 etrTrvreqcmts.setStrSts("Rejected");
			 MasEmployee emp = new MasEmployee();
			 emp.setId(employeeId1);
			 etrTrvreqcmts.setCreatedBY(emp);
			 etrTrvreqcmts.setCreatedAt(currentDate);
			 hbt.save(etrTrvreqcmts);
			 emailMessage = emailMessage = emailMessage +" Your Travel Request "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(applicationDate)+" for a travel "+
				HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
				"has been rejected on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+"Remark--"+remark+
				"\n\nFor details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
	}else if(approvalStatus.equals("forward")){
			 etrTravelreq.setTrvStatus("Forward");
			 hbt.update(etrTravelreq);
			 int etrApptblId = 0;
			 for(EtrTravelreq etrTravelreq2 :etravelReqList){
				 etrApptblSet = etrTravelreq2.getEtrApptbls();
				 lineManager = etrTravelreq2.getEmp().getLineManager().getFirstName()+" "+etrTravelreq2.getEmp().getLineManager().getLastName();
			 }
			 if(etrApptblSet.size()>0){
			 for(EtrApptbl  etrApptbl:etrApptblSet){
				 etrApptblId = (Integer)etrApptbl.getId();
			 }
			}
			 Date currentDate = new Date();
			EtrApptbl etrApptbl = new EtrApptbl();
			etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
			etrApptbl.setApprDate(currentDate);
			 etrApptbl.setApprTime(time);
			etrApptbl.setCmts(remark);
			 etrApptbl.setApprSts("forward");
			 etrTravelreq.setId(travelRequestId);
			 etrApptbl.setTrv(etrTravelreq);
			 
			 if(other.equals("y")){
				 MasEmployee masEmployee1 = new MasEmployee();
				 masEmployee1.setId(headeId);
				 etrApptbl.setAppr(masEmployee1);
			 }else if(other.equals("n")){
				 MasEmployee masEmployee2 = new MasEmployee();
				 masEmployee2.setId(lineManagerId);
				 etrApptbl.setAppr(masEmployee2);
			 }
			 
			 hbt.update(etrApptbl);
			 
			 EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
			 etrTravelreq.setId(travelRequestId);
			 etrTrvreqcmts.setTrv(etrTravelreq);
			 etrTrvreqcmts.setStrSts("Forwared");
			 MasEmployee emp = new MasEmployee();
			 emp.setId(employeeId1);
			 etrTrvreqcmts.setCreatedBY(emp);
			 etrTrvreqcmts.setCreatedAt(currentDate);
			 hbt.save(etrTrvreqcmts);
			 emailMessage = emailMessage = emailMessage +" Your Travel Request "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(applicationDate)+" for a travel "+
				HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
				"has been forward on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+"Remark--"+remark+
				"\n\nFor details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
		}else if(approvalStatus .equals("sendBack") ){
			etrTravelreq.setTrvStatus("SendBack");
			hbt.update(etrTravelreq);
			int etrApptblId = 0;
			 for(EtrTravelreq etrTravelreq2 :etravelReqList){
				 etrApptblSet = etrTravelreq2.getEtrApptbls();
				 lineManager = etrTravelreq2.getEmp().getLineManager().getFirstName()+" "+etrTravelreq2.getEmp().getLineManager().getLastName();
			 }
			 for(EtrApptbl  etrApptbl:etrApptblSet){
				 etrApptblId = (Integer)etrApptbl.getId();
			 }
			 Date currentDate = new Date();
			EtrApptbl etrApptbl = new EtrApptbl();
			etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
			etrApptbl.setApprDate(currentDate);
			 etrApptbl.setApprTime(time);
			etrApptbl.setCmts(remark);
			 etrApptbl.setApprSts("sendBack");
			 etrTravelreq.setId(travelRequestId);
			 etrApptbl.setTrv(etrTravelreq);
			 MasEmployee masEmployee = new MasEmployee();
			 masEmployee.setId(lineManagerId);
			 etrApptbl.setAppr(masEmployee);
			 hbt.update(etrApptbl);
		
			 EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
			 etrTravelreq.setId(travelRequestId);
			 etrTrvreqcmts.setTrv(etrTravelreq);
			 etrTrvreqcmts.setStrSts("sendBack");
			 MasEmployee emp = new MasEmployee();
			 emp.setId(employeeId1);
			 etrTrvreqcmts.setCreatedBY(emp);
			 etrTrvreqcmts.setCreatedAt(currentDate);
			 hbt.save(etrTrvreqcmts);
			 emailMessage = emailMessage = emailMessage +" Your Travel Request "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(applicationDate)+" for a travel "+
				HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
				"has been sendBack on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+"Remark--"+remark+
				"\n\nFor details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
	}
	List<String> recipientAddressesList = new ArrayList<String>();
	List<String> ccAddressesList = new ArrayList<String>();
	List<String> bccAddresses = new ArrayList<String>();
	
	String subject = "Travel Appproval";
	  String ccAddress1  = "adminhelp@clinirx.com";
	// String ccAddress1  = "mhwani@clinirx.com";
		String ccAddress2 = "accountshelp@clinirx.com";
	//	String ccAddress2 = "mhwani@clinirx.com";
		if(ticketStatus.equals("y") && (advanceStatus.equals("y"))){
			ccAddressesList.add(ccAddress);
			ccAddressesList.add(ccAddress1);
			ccAddressesList.add(ccAddress2);
			
	 	 }else if(ticketStatus.equals("y") && (advanceStatus.equals("n"))){
	 		ccAddressesList.add(ccAddress);
			ccAddressesList.add(ccAddress1);
	 	 }else if(ticketStatus.equals("n") && (advanceStatus.equals("y"))){
	 		ccAddressesList.add(ccAddress);
			ccAddressesList.add(ccAddress2);
	 	 }else if(ticketStatus.equals("n") && (advanceStatus.equals("n"))){
	 		ccAddressesList.add(ccAddress);
		 }
		
		recipientAddressesList.add(recipientAddresses);
	boolean sent=false;
	if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
		LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
	}
		 map = showTravelApprovalRequest(employeeId);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTicketUpdateListJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> userEmployeeList = new ArrayList<MasEmployee>();
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		Session session = (Session)getSession();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).list();
		userEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("TrvStatus","Approved")).addOrder(Order.desc("CreatedAt")).list();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		map.put("etrTravelReqList", etrTravelReqList);
		map.put("userEmployeeList", userEmployeeList);
		return map;
	}
	public Map<String, Object> searchTravelBookingUpdateList(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> userEmployeeList = new ArrayList<MasEmployee>();
		int searchEmployeeId = 0; 
		if(generalMap.get("searchEmployeeId")!= null){
			searchEmployeeId = (Integer)generalMap.get("searchEmployeeId");
		}
		
		int searchRefNoId = 0;
		if(generalMap.get("searchRefNoId")!= null){
			searchRefNoId = (Integer)generalMap.get("searchRefNoId");
		}
		Date fromDate = null;
		if(generalMap.get("fromDate")!= null){
			fromDate = (Date)generalMap.get("fromDate");
		}
		
		Date toDate = null;
		if(generalMap.get("toDate")!= null){
			toDate = (Date)generalMap.get("toDate");
		}
		Session session = (Session)getSession();
		Criteria crit = null;
		crit = session.createCriteria(EtrTravelreq.class);
		
		crit = crit.add(Restrictions.eq("TrvStatus","Approved"));
		if(searchEmployeeId != 0){
			crit = crit.createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", searchEmployeeId));
		}
		
		if(searchRefNoId != 0){
			crit = crit.add(Restrictions.idEq(searchRefNoId));
		}
		
		if(fromDate != null || toDate!= null ){
			crit = crit.add(Restrictions.gt("Jfdate", fromDate)).add(Restrictions.lt("Jtdate", toDate));
			
		}
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelRequestList = crit.list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		map.put("etrTravelReqList", etrTravelReqList);
		return map;
	}

	public Map<String, Object> filledBookedDetailsByAdmin(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MstrCode> mstrCodeForTravelClassList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTicketTypeList = new ArrayList<MstrCode>();
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		//mstrCityList = session.createCriteria(MstrCity.class).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")).add(Restrictions.eq("Status", "y")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelClassList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tkclass")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTicketTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tktype")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("countryList", countryList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("currencyList", currencyList);
		map.put("mstrCodeForTravelClassList", mstrCodeForTravelClassList);
		map.put("mstrCodeForTicketTypeList", mstrCodeForTicketTypeList);
		map.put("currencyList", currencyList);
		return map;
	}

	public Map<String, Object> displayAttachment(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		tempTicketAttachList = session.createCriteria(TempTickattach.class).createAlias("TdsaDsid", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("tempTicketAttachList", tempTicketAttachList);
		return map;
	}

	public Map<String, Object> addAttachFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		String comments = "";
		if(generalMap.get("comments")!= null){
			comments =(String) generalMap.get("comments");
		}
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId =(Integer) generalMap.get("travelRequestId");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId =(Integer) generalMap.get("employeeId");
		}
		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				//hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
	    		 file=new File(uploadURL + "/" + filename);
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	     ByteBuffer byteBuff=null;
	    	   //  int modLength=length/
	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;
	    	    	
	    	     }
	    
	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());
	    	         
	    	     }
	    	     is.close();
	        // Close the input stream and return bytes
	    	    // StringTokenizer strToken=new StringTokenizer( filename,".");
		   	
	    	   //  filename=strToken.nextToken();
	    	   //  fileExtension=strToken.nextToken();
	    	     TempTickattach tempTickattach = new TempTickattach();
	    	     tempTickattach.setTdsaDfilename(filename);
	    	     tempTickattach.setTdsaOfilename(filename);
	    	     EtrTravelreq etrTravelreq = new EtrTravelreq();
	    	     etrTravelreq.setId(travelRequestId);
	    	     tempTickattach.setTdsaDsid(etrTravelreq);
	    	     tempTickattach.setTdsaCmts(comments);
	    	     MasEmployee masEmployee = new MasEmployee();
	    	     masEmployee.setId(employeeId);
	    	     tempTickattach.setTdsaUserid(masEmployee);
	    	     hbt.save(tempTickattach);
	      
	    	     //file.delete();
	      
	    
	    }// end of 'try' loop 
		catch (Exception e) {
	    	
	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	    }
		tempTicketAttachList = session.createCriteria(TempTickattach.class).createAlias("TdsaDsid", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		map.put("tempTicketAttachList", tempTicketAttachList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
	}

	public Map<String, Object> deleteAttachFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		List ticketAttachIdList = new ArrayList();
		List uploadFileNameList = new ArrayList();
		List commentsList = new ArrayList();
		List employeeIdList = new ArrayList();
		List travelRequestIdList = new ArrayList();
		
		if(generalMap.get("ticketAttachIdList")!= null){
			ticketAttachIdList =(List)generalMap.get("ticketAttachIdList");
		}
		
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId =(Integer) generalMap.get("travelRequestId");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		// etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		//TempTickattach tempTickattach = (TempTickattach)hbt.load(TempTickattach.class, ticketAttachId);
		//hbt.delete(tempTickattach);
		int ticketAttachId = 0;
		if(ticketAttachIdList.size()>0){
			for (int i = 0; i < ticketAttachIdList.size(); i++) {
				if(ticketAttachIdList.get(i) != null){
					ticketAttachId = Integer.parseInt(ticketAttachIdList.get(i).toString());
					//etrTrvdetails = (EtrTrvdetails)hbt.load(EtrTrvdetails.class, etrTrvDeatilId);
					TempTickattach tempTickattach = (TempTickattach)hbt.load(TempTickattach.class, ticketAttachId);
					hbt.delete(tempTickattach);
				}
			}
		}
		
		tempTicketAttachList = session.createCriteria(TempTickattach.class).createAlias("TdsaDsid", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("tempTicketAttachList", tempTicketAttachList);
		return map;
	}


	public Map<String, Object> sendTicketDetail(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		EtrBookeddtlsAttach etrBookeddtlsAttach = new EtrBookeddtlsAttach();
		EtrFillbookeddtls etrFillbookeddtls = new EtrFillbookeddtls();
		List<MasEmployee> userEmployeeList = new ArrayList<MasEmployee>();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List travelModeList =new ArrayList();
		List ticketclassList =new ArrayList();
		List departureList =new ArrayList();
		List arrivalList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List ticketNoList =new ArrayList();
		List ticketTypeList =new ArrayList();
		List ticketAmtList =new ArrayList();
		List currencyList =new ArrayList();
		int adminEmployeeId = 0;
		if(generalMap.get("adminEmployeeId")!= null){
			adminEmployeeId = (Integer)generalMap.get("adminEmployeeId");
		}
		
		if(generalMap.get("etrBookeddtlsAttach")!= null){
			etrBookeddtlsAttach = (EtrBookeddtlsAttach)generalMap.get("etrBookeddtlsAttach");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		if(generalMap.get("etrFillbookeddtls")!= null){
			etrFillbookeddtls = (EtrFillbookeddtls)generalMap.get("etrFillbookeddtls");
		}
		if (generalMap.get("fromPlaceList")!= null) {
			fromPlaceList = (List)generalMap.get("fromPlaceList");
		}
		if (generalMap.get("toPlaceList")!= null) {
			toPlaceList = (List)generalMap.get("toPlaceList");
		}
		if (generalMap.get("travelModeList")!= null) {
			travelModeList = (List)generalMap.get("travelModeList");
		}
		if (generalMap.get("ticketclassList")!= null) {
			ticketclassList = (List)generalMap.get("ticketclassList");
		}
		if (generalMap.get("departureList")!= null) {
			departureList = (List)generalMap.get("departureList");
		}
		if (generalMap.get("arrivalList")!= null) {
			arrivalList = (List)generalMap.get("arrivalList");
		}
		if (generalMap.get("departureList")!= null) {
			departureList = (List)generalMap.get("departureList");
		}
		if (generalMap.get("fromCountryList")!= null) {
			fromCountryList = (List)generalMap.get("fromCountryList");
		}
		if (generalMap.get("toCountryList")!= null) {
			toCountryList = (List)generalMap.get("toCountryList");
		}
		if (generalMap.get("ticketNoList")!= null) {
			ticketNoList = (List)generalMap.get("ticketNoList");
		}
		if (generalMap.get("ticketTypeList")!= null) {
			ticketTypeList = (List)generalMap.get("ticketTypeList");
		}
		if (generalMap.get("ticketAmtList")!= null) {
			ticketAmtList = (List)generalMap.get("ticketAmtList");
		}
		if (generalMap.get("currencyList")!= null) {
			currencyList = (List)generalMap.get("currencyList");
		}
		int travelRequestId = 0;
		if (generalMap.get("travelRequestId")!= null) {
			travelRequestId = (Integer)generalMap.get("travelRequestId");
		}
		
		 org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(etrFillbookeddtls);
			
			etrBookeddtlsAttach.setFbdt(etrFillbookeddtls);
			hbt.save(etrBookeddtlsAttach);
			
			if(travelRequestId != 0 ){
				EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class,travelRequestId);
				etrTravelreq.setBookStatus("Booked");
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				etrTravelreq.setBookerid(masEmployee);
				hbt.update(etrTravelreq);
			}
			
			if(travelModeList.size()>0){
				for(int i = 0; i < travelModeList.size(); i++){
					EtrTicketdetails etrTicketdetails = new EtrTicketdetails();
					
					if(fromCountryList.size()>0){
						if(fromCountryList.get(i) != null){
							int fromCountryId = Integer.parseInt(fromCountryList.get(i).toString());
							MasCountry masCountry = new MasCountry();
							masCountry.setId(fromCountryId);
							etrTicketdetails.setFromCountry(masCountry);
						}
					}
					
					if(toCountryList.size()>0){
						if(toCountryList.get(i) != null){
							int toCountryId = Integer.parseInt(toCountryList.get(i).toString());
							MasCountry masCountry = new MasCountry();
							masCountry.setId(toCountryId);
							etrTicketdetails.setToCountry(masCountry);
						}
					}
					
					if(fromPlaceList.size()>0){
					if(fromPlaceList.get(i) != null){
						int fromPalceId = Integer.parseInt(fromPlaceList.get(i).toString());
						MasDistrict masDistrict = new MasDistrict();
						masDistrict.setId(fromPalceId);
						etrTicketdetails.setFrmplc(masDistrict);
					}
				}
					if(toPlaceList.size()>0){
					if(toPlaceList.get(i) != null){
						int toPlaceId = Integer.parseInt(toPlaceList.get(i).toString());
						MasDistrict masDistrict = new MasDistrict();
						masDistrict.setId(toPlaceId);
						etrTicketdetails.setFrmto(masDistrict);
					}
				}
					if(travelModeList.get(i) != null){
						int travelModeId = Integer.parseInt(travelModeList.get(i).toString());
						MstrCode mstrCode = new MstrCode();
						mstrCode.setId(travelModeId);
						etrTicketdetails.setMode(mstrCode);
					}
					if(ticketclassList.size()>0){
					if(ticketclassList.get(i) != null){
						int travelClassId = Integer.parseInt(ticketclassList.get(i).toString());
						MstrCode mstrCode2 = new MstrCode();
						mstrCode2.setId(travelClassId);
						etrTicketdetails.setTicketClass(mstrCode2);
					}
					}
					if(departureList.get(i) != null){
						String departureTime = departureList.get(i).toString();
						etrTicketdetails.setDeptTime(departureTime);
					}
					
					if(arrivalList.get(i) != null){
						String arrivalTime = arrivalList.get(i).toString();
						etrTicketdetails.setArrTime(arrivalTime);
					}
					if(ticketNoList.get(i) != null){
						String ticketNo = ticketNoList.get(i).toString();
						etrTicketdetails.setTkNo(ticketNo);
					}
					if(ticketTypeList.get(i) != null){
						int ticketTypeId = Integer.parseInt(ticketTypeList.get(i).toString());
						MstrCode mstrCode3 = new MstrCode();
						mstrCode3.setId(ticketTypeId);
						etrTicketdetails.setTkType(mstrCode3);
					}
					if(ticketAmtList.get(i) != null){
						BigDecimal ticketAmt = new BigDecimal(ticketAmtList.get(i).toString());
						etrTicketdetails.setAmt(ticketAmt);
					}
					if(currencyList.get(i) != null){
						int currencyId = Integer.parseInt(currencyList.get(i).toString());
						MasCurrency masCurrency = new MasCurrency();
						masCurrency.setId(currencyId);
						etrTicketdetails.setCur(masCurrency);
					}
					
					etrTicketdetails.setFbdt(etrFillbookeddtls);
					hbt.save(etrTicketdetails);
				}
				}
			
			etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("TrvStatus","Approved")).addOrder(Order.desc("Jfdate")).list();

			userEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
			map.put("etrTravelRequestList", etrTravelRequestList);
			map.put("userEmployeeList", userEmployeeList);
		return map;
	}
	public Map<String, Object> showUpdateBookedDetails(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		Session session = (Session)getSession();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("BookStatus","Booked")).list();
		
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		return map;
	}
	public Map<String, Object> editBookingDetail(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<EtrTicketdetails> ticketDetailList = new ArrayList<EtrTicketdetails>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelClassList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTicketTypeList = new ArrayList<MstrCode>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId = (Integer)generalMap.get("travelRequestId");
		}
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		ticketDetailList = session.createCriteria(EtrTicketdetails.class).createAlias("Fbdt", "fbdt").createAlias("fbdt.Trv", "trv").add(Restrictions.eq("trv.Id", travelRequestId)).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelClassList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tkclass")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTicketTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tktype")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		map.put("masCityList", masCityList);
		map.put("currencyList", currencyList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("mstrCodeForTravelClassList", mstrCodeForTravelClassList);
		map.put("mstrCodeForTicketTypeList", mstrCodeForTicketTypeList);
		map.put("countryList", countryList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("ticketDetailList", ticketDetailList);
		return map;
	}
	public Map<String, Object> updateBookingDetails(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List travelClassList =new ArrayList();
		List travelModeList =new ArrayList();
		List ticketBookingIdList =new ArrayList();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List departureTimeList =new ArrayList();
		List arrivalTimeList =new ArrayList();
		List ticketNoList =new ArrayList();
		List ticketTypeList =new ArrayList();
		List ticketAmountList =new ArrayList();
		List currencyList =new ArrayList();
		if(generalMap.get("travelClassList")!= null){
			travelClassList = (List)generalMap.get("travelClassList");
		}
		if(generalMap.get("travelModeList")!= null){
			travelModeList = (List)generalMap.get("travelModeList");
		}
		if(generalMap.get("ticketBookingIdList")!= null){
			ticketBookingIdList = (List)generalMap.get("ticketBookingIdList");
		}
		if(generalMap.get("fromPlaceList")!= null){
			fromPlaceList = (List)generalMap.get("fromPlaceList");
		}
		if(generalMap.get("toPlaceList")!= null){
			toPlaceList = (List)generalMap.get("toPlaceList");
		}
		if(generalMap.get("fromCountryList")!= null){
			fromCountryList = (List)generalMap.get("fromCountryList");
		}
		if(generalMap.get("toCountryList")!= null){
			toCountryList = (List)generalMap.get("toCountryList");
		}
		if(generalMap.get("departureTimeList")!= null){
			departureTimeList = (List)generalMap.get("departureTimeList");
		}
		if(generalMap.get("arrivalTimeList")!= null){
			arrivalTimeList = (List)generalMap.get("arrivalTimeList");
		}
		if(generalMap.get("ticketNoList")!= null){
			ticketNoList = (List)generalMap.get("ticketNoList");
		}
		if(generalMap.get("ticketTypeList")!= null){
			ticketTypeList = (List)generalMap.get("ticketTypeList");
		}
		if(generalMap.get("ticketAmountList")!= null){
			ticketAmountList = (List)generalMap.get("ticketAmountList");
		}
		if(generalMap.get("currencyList")!= null){
			currencyList = (List)generalMap.get("currencyList");
		}
		int fillBookingDetailId= 0;
		if(generalMap.get("fillBookingDetailId")!= null){
			fillBookingDetailId = (Integer)generalMap.get("fillBookingDetailId");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		String hotelDesc  = "";
		if(generalMap.get("hotelDesc")!= null){
			hotelDesc = (String)generalMap.get("hotelDesc");
		}
		String cabDesc  = "";
		if(generalMap.get("cabDesc")!= null){
			cabDesc = (String)generalMap.get("cabDesc");
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		 EtrFillbookeddtls etrFillbookeddtls = (EtrFillbookeddtls)hbt.load(EtrFillbookeddtls.class, fillBookingDetailId);
		 etrFillbookeddtls.setHotelDesc(hotelDesc);
		 etrFillbookeddtls.setLocalCABDesc(cabDesc);
		 hbt.update(etrFillbookeddtls);
		
		EtrTicketdetails etrTicketdetails= new EtrTicketdetails();
		int etrTicketDetailId = 0;
		if(ticketBookingIdList.size()>0){
			for (int i = 0; i < ticketBookingIdList.size(); i++) {
				etrTicketDetailId = Integer.parseInt(ticketBookingIdList.get(i).toString());
				etrTicketdetails = (EtrTicketdetails)hbt.load(EtrTicketdetails.class, etrTicketDetailId);
				if(fromPlaceList.size()>0){
				if(fromPlaceList.get(i) != null){
					int fromPlaceId = Integer.parseInt(fromPlaceList.get(i).toString());
					//MstrCity mstrCity = new MstrCity();
					//mstrCity.setId(fromPlaceId);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(fromPlaceId);
					etrTicketdetails.setFrmplc(masDistrict);
				}}
				if(toPlaceList.size()>0){
				if(toPlaceList.get(i) != null){
					int toPlaceId = Integer.parseInt(toPlaceList.get(i).toString());
					//MstrCity mstrCity = new MstrCity();
					//mstrCity.setId(toPlaceId);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(toPlaceId);
					etrTicketdetails.setFrmto(masDistrict);
					
				}}
				if(fromCountryList.size()>0){
				if(fromCountryList.get(i) != null){
					int fromCountryId = Integer.parseInt(fromCountryList.get(i).toString());
					MasCountry masCountry = new MasCountry();
					masCountry.setId(fromCountryId);
					etrTicketdetails.setFromCountry(masCountry);	
					}
				}
				if(toCountryList.size()>0){
				if(toCountryList.get(i) != null){
					int toCountryId = Integer.parseInt(toCountryList.get(i).toString());
					MasCountry masCountry = new MasCountry();
					masCountry.setId(toCountryId);
					etrTicketdetails.setToCountry(masCountry);	
					}
				}
				if(travelModeList.size()>0){
				if(travelModeList.get(i) != null){
					int travelModeId  = Integer.parseInt(travelModeList.get(i).toString());
					MstrCode mstrCode2 = new MstrCode();
					mstrCode2.setId(travelModeId);
					etrTicketdetails.setMode(mstrCode2);
				}}
				
				if(travelClassList.size()>0){
					if(travelClassList.get(i) != null){
						int travelClassId  = Integer.parseInt(travelClassList.get(i).toString());
						MstrCode mstrCode3 = new MstrCode();
						mstrCode3.setId(travelClassId);
						etrTicketdetails.setTicketClass(mstrCode3);
					}}
				
				if(departureTimeList.size()>0){
				if(departureTimeList.get(i) != null){
					String departureTime  = (String)(departureTimeList.get(i).toString());		
					etrTicketdetails.setDeptTime(departureTime);
					}
				}
				if(arrivalTimeList.size()>0){
					if(arrivalTimeList.get(i) != null){
						String arrivalTime  = (String)(arrivalTimeList.get(i).toString());		
						etrTicketdetails.setArrTime(arrivalTime);
					}
				}
				if(ticketNoList.size()>0){
					if(ticketNoList.get(i) != null){
						String ticketNo  = (String)(ticketNoList.get(i).toString());		
						etrTicketdetails.setTkNo(ticketNo);
					}
				}
				if(ticketTypeList.size()>0){
					if(ticketTypeList.get(i) != null){
						int travelTypeId  = Integer.parseInt(ticketTypeList.get(i).toString());
						MstrCode mstrCode4 = new MstrCode();
						mstrCode4.setId(travelTypeId);
						etrTicketdetails.setTkType(mstrCode4);
					}}
				if(ticketAmountList.size()>0){
					if(ticketAmountList.get(i) != null){
						BigDecimal ticketAmont  = new BigDecimal(ticketAmountList.get(i).toString());
						etrTicketdetails.setAmt(ticketAmont);
					}}
				if(currencyList.size()>0){
					if(currencyList.get(i) != null){
						int currencyId  = Integer.parseInt(currencyList.get(i).toString());
						MasCurrency masCurrency = new MasCurrency();
						masCurrency.setId(currencyId);
						etrTicketdetails.setCur(masCurrency);
					}}
				hbt.update(etrTicketdetails);	
			}
		}
		Session session = (Session)getSession();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("BookStatus","Booked")).list();
		
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		return map;
	}
	public Map<String, Object> viewBookedDetails(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<EtrFillbookeddtls> etrFillBookedDetailsList = new ArrayList<EtrFillbookeddtls>();
		List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelClassList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTicketTypeList = new ArrayList<MstrCode>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		Session session = (Session)getSession();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).add(Restrictions.eq("BookStatus","Booked")).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelClassList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tkclass")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTicketTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tktype")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		etrFillBookedDetailsList = session.createCriteria(EtrFillbookeddtls.class).createAlias("Trv", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		int fillBookDetailId = 0;
		if(etrFillBookedDetailsList.size()>0){
			for(EtrFillbookeddtls etrFillbookeddtls :etrFillBookedDetailsList){
				fillBookDetailId = etrFillbookeddtls.getId();
			}
		}
		etrTicketDetailsList = session.createCriteria(EtrTicketdetails.class).createAlias("Fbdt", "fillBookDetail").add(Restrictions.eq("fillBookDetail.Id", fillBookDetailId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		//map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("countryList", countryList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("mstrCodeForTravelClassList", mstrCodeForTravelClassList);
		map.put("mstrCodeForTicketTypeList", mstrCodeForTicketTypeList);
		map.put("currencyList", currencyList);
		map.put("etrTicketDetailsList", etrTicketDetailsList);
		return map;
		
	}

	public Map<String, Object> cancelBookedDetails(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List cancelCheckBoxList = new ArrayList();
		List ticketDetailIdList = new ArrayList();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		List<EtrFillbookeddtls> etrFillBookDetailList = new ArrayList<EtrFillbookeddtls>();
		if(generalMap.get("cancelCheckBoxList")!= null){
			cancelCheckBoxList = (List)generalMap.get("cancelCheckBoxList");
		}
		if(generalMap.get("ticketDetailIdList")!= null){
			ticketDetailIdList = (List)generalMap.get("ticketDetailIdList");
		}
		int fillBookedDetailId = 0;
		if(generalMap.get("fillBookedDetailId")!= null){
			fillBookedDetailId = (Integer)generalMap.get("fillBookedDetailId");
		}
		String cancelHotelCheckBox = "";
		if(generalMap.get("cancelHotelCheckBox")!= null){
			cancelHotelCheckBox = (String)generalMap.get("cancelHotelCheckBox");
		}
		String cancelHotelcomment = "";
		if(generalMap.get("cancelHotelcomment")!= null){
			cancelHotelcomment = (String)generalMap.get("cancelHotelcomment");
		}
		String cancelCabCheckBox = "";
		if(generalMap.get("cancelCabCheckBox")!= null){
			cancelCabCheckBox = (String)generalMap.get("cancelCabCheckBox");
		}
		String cancelCabcomment = "";
		if(generalMap.get("cancelCabcomment")!= null){
			cancelCabcomment = (String)generalMap.get("cancelCabcomment");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if(ticketDetailIdList.size()>0){
			for (int i = 0; i < ticketDetailIdList.size(); i++) {
				
				int ticketDetailId= Integer.parseInt(ticketDetailIdList.get(i).toString());
				EtrTicketdetails etrTicketdetails = (EtrTicketdetails)hbt.load(EtrTicketdetails.class, ticketDetailId);
				if(cancelCheckBoxList.get(i) != null){
					String cancelTicketCheckBox= cancelCheckBoxList.get(i).toString();
					etrTicketdetails.setCancelreq(cancelTicketCheckBox);
				}
				hbt.update(etrTicketdetails);
			}
		}
		EtrFillbookeddtls etrFillbookeddtls = (EtrFillbookeddtls)hbt.load(EtrFillbookeddtls.class, fillBookedDetailId);
		etrFillbookeddtls.setHtlCancelReq(cancelHotelCheckBox);
		etrFillbookeddtls.setHtlCancelDesc(cancelHotelcomment);
		etrFillbookeddtls.setLcbCancelReq(cancelCabCheckBox);
		etrFillbookeddtls.setLcbCancelDesc(cancelCabcomment);
		hbt.update(etrFillbookeddtls);
		
		etrFillBookDetailList = session.createCriteria(EtrFillbookeddtls.class).add(Restrictions.idEq(fillBookedDetailId)).list();
		int travelRequestId = 0;
		if(etrFillBookDetailList.size()>0){
			for(EtrFillbookeddtls etrFillbookeddtls2 :etrFillBookDetailList){
				travelRequestId = (Integer)etrFillbookeddtls2.getTrv().getId();
			}
		}
		EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		etrTravelreq.setBookStatus("Cancellation in Process");
		hbt.update(etrTravelreq);
		int employeeId = etrTravelreq.getEmp().getId();
		/*String qryString = "SELECT Etr_id,RefNo,jfdate,jtdate,cast((select Str_sts from etr_trvreqcmts where cmtsid= " +
		" (select Max(cmtsid) from etr_trvreqcmts where emp_id="+employeeId+" and Trv_id=Etr_id)   )as char) " +
		" as Reqstatus,Advstrsts,BookStatus,Expclaimsts,bookerid,expactsid,TRV_STATUS," +
		"(select count(*) from etr_expsubmit where trv_id=Etr_id) as EXPSUBMIT    from   etr_travelreq " +
		" WHERE eTR_ID IN (SELECT MAX(ETR_ID) FROM etr_travelreq   GROUP BY REFNO) " +
		" and emp_id="+employeeId+" order by etr_id desc";
		travelRequestList = (List) session.createSQLQuery(qryString).list();*/
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		//map.put("travelRequestList", travelRequestList);
		return map;
	}
	public Map<String, Object> showTravelCancellationApproval(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<EtrApptbl> etrApproverList = new ArrayList<EtrApptbl>();
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		Session session = (Session)getSession();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").createAlias("emp.LineManager", "lineManager").add(Restrictions.eq("lineManager.Id", employeeId)).add(Restrictions.eq("TrvStatus", "Approved")).list();
			etrApproverList = session.createCriteria(EtrApptbl.class).createAlias("Appr", "approver").add(Restrictions.eq("approver.Id", employeeId)).createAlias("Trv", "trv")
			.add(Restrictions.eq("trv.TrvStatus", "Approved")).addOrder(Order.desc("trv.Jfdate") ).list();
			
		//map.put("etrTravelRequestList", etrTravelRequestList);
			map.put("etrApproverList", etrApproverList);
		return map;
	}

	public Map<String, Object> approveCancelBookedDetails(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		//List<EtrFillbookeddtls> etrFillBookedDetailsList = new ArrayList<EtrFillbookeddtls>();
		//List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelClassList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTicketTypeList = new ArrayList<MstrCode>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		List<Object[]> departmentList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelClassList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tkclass")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTicketTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tktype")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		//etrFillBookedDetailsList = session.createCriteria(EtrFillbookeddtls.class).createAlias("Trv", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		//int fillBookDetailId = 0;
		//if(etrFillBookedDetailsList.size()>0){
			//for(EtrFillbookeddtls etrFillbookeddtls :etrFillBookedDetailsList){
				//fillBookDetailId = etrFillbookeddtls.getId();
			//}
		//}
		//etrTicketDetailsList = session.createCriteria(EtrTicketdetails.class).createAlias("Fbdt", "fillBookDetail").add(Restrictions.eq("fillBookDetail.Id", fillBookDetailId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		employeeList=getHibernateTemplate().find("select me.Id,me.EmployeeCode, me.FirstName,me.MiddleName,me.LastName,me.LineManager.Id,me.LineManager.FirstName,me.LineManager.MiddleName,me.LineManager.LastName,me.Department.Id,me.Status from jkt.hms.masters.business.MasEmployee as me where me.Status = 'y'");
		departmentList=getHibernateTemplate().find("select md.Id, md.DepartmentName,md.Status from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y'");
		//map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("countryList", countryList);
		map.put("masCityList", masCityList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("mstrCodeForTravelClassList", mstrCodeForTravelClassList);
		map.put("mstrCodeForTicketTypeList", mstrCodeForTicketTypeList);
		map.put("currencyList", currencyList);
		map.put("etrTravelRequestList", etrTravelRequestList);
	//	map.put("etrTicketDetailsList", etrTicketDetailsList);
		return map;


	}

	public Map<String, Object> approveCancelBookedDetailsByAdmin(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<EtrApptbl> etrApproverList = new ArrayList<EtrApptbl>();
		List cancelStatusList = new ArrayList();
		List ticketDetailIdList = new ArrayList();
		List<EtrFillbookeddtls> etrFillBookDetailList = new ArrayList<EtrFillbookeddtls>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> userList  = new ArrayList<MasEmployee>();
		List<EtrTravelreq> etravelReqList = new ArrayList<EtrTravelreq>();
		Set<EtrApptbl> etrApptblSet= new HashSet<EtrApptbl>();
		List<MasEmployee> applicantList  = new ArrayList<MasEmployee>();
		
		Session session = (Session)getSession();
		int userId  = 0;
		if(generalMap.get("userId")!= null){
			userId = (Integer)generalMap.get("userId");
		}
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId = (Integer)generalMap.get("travelRequestId");
		}
		String approvalStatus = "";
		if(generalMap.get("approvalStatus")!= null){
			approvalStatus =(String)generalMap.get("approvalStatus");
		}
		String remark = "";
		if(generalMap.get("remark")!= null){
			remark =(String)generalMap.get("remark");
		}
		int lineManagerId = 0;
		if(generalMap.get("lineManagerId")!= null){
			lineManagerId =(Integer)generalMap.get("lineManagerId");
		}
		int headeId = 0;
		if(generalMap.get("headeId")!= null){
			headeId =(Integer)generalMap.get("headeId");
		}
		String other = "";
		if(generalMap.get("other")!= null){
			other =(String)generalMap.get("other");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		String date = (String)utilMap.get("currentDate");	 
		
		Date currentdate = new Date();
		String cancelTicketStatus = "";
		String emailMessage = "";
		String refNo = "";
		String recipientAddresses = "";
		Date applicationDate = null;
		 int approverId = 0;
		 String titleName = "";
		 String lineManagerName = "";
		 String applicantName = "";
		 String ccAddress = "";
		 String ticketStatus = "";
		 String advanceStatus = "";
		 String fromAddress  = "";
		 int applicantId = 0;
		 userList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(userId)).list();
		 if(userList.size()>0){
			 for(MasEmployee masEmployee :userList){
				fromAddress = masEmployee.getEmail();
				 ccAddress = masEmployee.getEmail();
				 //fromAddress = "ritu.sahu@jktech.com";
				 //ccAddress = "ritu.sahu@jktech.com";
			 }
		 }
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		etravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		if(etravelReqList.size()>0){
			for(EtrTravelreq travel :etravelReqList){
				refNo = travel.getRefNo();
				applicantId = travel.getEmp().getId();
			}
		}
		applicantList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(applicantId)).list();
		if(applicantList.size()>0){
			for(MasEmployee employee:applicantList){
				applicantName = employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getLastName();
				recipientAddresses = employee.getEmail();
				titleName = employee.getTitle().getTitleName();
				//recipientAddresses = "vishal.jain@jktech.com";
			}
		}
		emailMessage = "Dear "+ titleName + " " + applicantName+ ",\n";
		
		EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		
		if(approvalStatus.equals("approve")){
		 etrTravelreq.setBookStatus("Booking Cancellation Approved");
		 hbt.update(etrTravelreq);
		 int etrApptblId = 0;
		 for(EtrTravelreq etrTravelreq2 :etravelReqList){
			 etrApptblSet = etrTravelreq2.getEtrApptbls();
			 //lineManager = etrTravelreq2.getEmp().getLineManager().getFirstName()+" "+etrTravelreq2.getEmp().getLineManager().getLastName();
		 }
		 for(EtrApptbl  etrApptbl:etrApptblSet){
			 etrApptblId = (Integer)etrApptbl.getId();
		 }
		 Date currentDate = new Date();
		EtrApptbl etrApptbl = new EtrApptbl();
		etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
		 etrApptbl.setCmts(remark);
		 etrApptbl.setCancelApprDate(HMSUtil.convertStringTypeDateToDateType(date));
		 etrApptbl.setCancelApprTime(time);
		 etrApptbl.setApprSts("approve");
		 etrTravelreq.setId(travelRequestId);
		 etrApptbl.setTrv(etrTravelreq);
		 MasEmployee masEmployee = new MasEmployee();
		 masEmployee.setId(lineManagerId);
		 etrApptbl.setAppr(masEmployee);
		 hbt.update(etrApptbl);
		 emailMessage =emailMessage +" Your Travel Cancellation Request for Travel Request   "+refNo+" has been approved on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
			"For details of the same, kindly log in your omega account.\n\n\n\n"+
			"This is an auto generated mail through OMEGA. Do not reply.";
		
		}else if(cancelTicketStatus.equals("reject")){
		 etrTravelreq.setBookStatus("Booking Cancellation Rejected");
		 hbt.update(etrTravelreq);
		 int etrApptblId = 0;
		 for(EtrTravelreq etrTravelreq2 :etravelReqList){
			 etrApptblSet = etrTravelreq2.getEtrApptbls();
			// lineManager = etrTravelreq2.getEmp().getLineManager().getFirstName()+" "+etrTravelreq2.getEmp().getLineManager().getLastName();
		 }
		 for(EtrApptbl  etrApptbl:etrApptblSet){
			 etrApptblId = (Integer)etrApptbl.getId();
		 }
		 Date currentDate = new Date();
		EtrApptbl etrApptbl = new EtrApptbl();
		etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
		etrApptbl.setCancelApprDate(HMSUtil.convertStringTypeDateToDateType(date));
		 etrApptbl.setCancelApprTime(time);
		etrApptbl.setCmts(remark);
		 etrApptbl.setApprSts("reject");
		 etrTravelreq.setId(travelRequestId);
		 etrApptbl.setTrv(etrTravelreq);
		 MasEmployee masEmployee = new MasEmployee();
		 masEmployee.setId(lineManagerId);
		 etrApptbl.setAppr(masEmployee);
		 hbt.update(etrApptbl);
		 emailMessage =emailMessage +" Your Travel Cancellation Request for Travel Request   "+refNo+" has been rejected on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
			"For details of the same, kindly log in your omega account.\n\n\n\n"+
			"This is an auto generated mail through OMEGA. Do not reply.";
		}else if(approvalStatus.equals("forward")){
			etrTravelreq.setBookStatus("Booking Cancellation Forward");
			 hbt.update(etrTravelreq);
			 int etrApptblId = 0;
			 for(EtrTravelreq etrTravelreq2 :etravelReqList){
				 etrApptblSet = etrTravelreq2.getEtrApptbls();
				 //lineManager = etrTravelreq2.getEmp().getLineManager().getFirstName()+" "+etrTravelreq2.getEmp().getLineManager().getLastName();
			 }
			 if(etrApptblSet.size()>0){
			 for(EtrApptbl  etrApptbl:etrApptblSet){
				 etrApptblId = (Integer)etrApptbl.getId();
			 }
			}
			 Date currentDate = new Date();
			EtrApptbl etrApptbl = new EtrApptbl();
			etrApptbl = (EtrApptbl)hbt.load(EtrApptbl.class, etrApptblId);
			etrApptbl.setCancelApprDate(HMSUtil.convertStringTypeDateToDateType(date));
			 etrApptbl.setCancelApprTime(time);
			etrApptbl.setCmts(remark);
			 etrApptbl.setApprSts("forward");
			 etrTravelreq.setId(travelRequestId);
			 etrApptbl.setTrv(etrTravelreq);
			 
			 if(other.equals("y")){
				 MasEmployee masEmployee1 = new MasEmployee();
				 masEmployee1.setId(headeId);
				 etrApptbl.setAppr(masEmployee1);
			 }else if(other.equals("n")){
				 MasEmployee masEmployee2 = new MasEmployee();
				 masEmployee2.setId(lineManagerId);
				 etrApptbl.setAppr(masEmployee2);
			 }
			 
			 hbt.update(etrApptbl);
			 emailMessage =emailMessage +" Your Travel Cancellation Request for Travel Request   "+refNo+" has been forward on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
				"For details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
		}
		
		 
		 
		 List<String> recipientAddressesList = new ArrayList<String>();
			List<String> ccAddressesList = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();
			
			String subject = "Cancellation Approval";
			String ccAddress1  = "accountshelp@clinirx.com";
			String ccAddress2  = "adminhelp@clinirx.com";
		//	String ccAddress1  = "mhwani@clinirx.com";
		//	String ccAddress2  = "mhwani@clinirx.com";
			
			recipientAddressesList.add(recipientAddresses);
			ccAddressesList.add(ccAddress);
			ccAddressesList.add(ccAddress1);
			ccAddressesList.add(ccAddress2);
			boolean sent=false;
			if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
			}
			
		//hbt.update(etrTravelreq);
		int employeeId = etrTravelreq.getEmp().getId();
		
		etrApproverList = session.createCriteria(EtrApptbl.class).createAlias("Appr", "approver").add(Restrictions.eq("approver.Id", employeeId)).createAlias("Trv", "trv").add(Restrictions.eq("trv.TrvStatus", "Approved")).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("etrApproverList", etrApproverList);
		return map;
	}

	public Map<String, Object> showTravelAdvanceJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		//etrTravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("AdvStrSts", "Payment Pending")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("AvdReq", "y")).addOrder(Order.desc("Id")).list();
		// employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).list();
		map.put("etrTravelReqList", etrTravelReqList);
		map.put("employeeList", employeeList);
		return map;
	}
	public Map<String, Object> viewTravelRequestForPayAdvance(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> viewTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<EtrTravelreq> etrTravelReqList  = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		List<MstrProject>mstrProjectList = new ArrayList<MstrProject>();
		//List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
		List<MstrSiteHeader> mstrSiteList = new ArrayList<MstrSiteHeader>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		//List<PrjSiteResMap>prjSiteResMapList=new ArrayList<PrjSiteResMap>();
		mstrProjectList = session.createCriteria(MstrProject.class).list();
		//departmentList = session.createCriteria(MasDepartment.class).list();
		mstrSiteList = session.createCriteria(MstrSiteHeader.class).add(Restrictions.eq("Status", "y")).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTripList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "Trip")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		viewTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("AvdReq", "y")).addOrder(Order.desc("Id")).list();

	
		map.put("mstrProjectList", mstrProjectList);
		map.put("mstrSiteList", mstrSiteList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForTripList", mstrCodeForTripList);
		map.put("employeeList", employeeList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("countryList", countryList);
		map.put("viewTravelRequestList", viewTravelRequestList);
		map.put("currencyList", currencyList);
		map.put("etrTravelReqList", etrTravelReqList);
		return map;
	}
	public Map<String, Object> paidTravelAdvanceAmount(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
		List travelRequestIdList = new ArrayList();
		List<EtrExpsubmit> etrExpSubmitList = new ArrayList<EtrExpsubmit>();
		List employeeIdList = new ArrayList();
		Session session = (Session)getSession();
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId = (Integer)generalMap.get("travelRequestId");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		String modeOFPayment = "";
		if(generalMap.get("modeOFPayment")!= null){
			modeOFPayment = (String)generalMap.get("modeOFPayment");
		}
		Date disbursementDate = null;
		if(generalMap.get("disbursementDate")!= null){
			disbursementDate = (Date)generalMap.get("disbursementDate");
		}
		BigDecimal advancePaid = new BigDecimal(0);
		if(generalMap.get("advancePaid")!= null){
			advancePaid = (BigDecimal)generalMap.get("advancePaid");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		String date = (String)utilMap.get("currentDate");	 
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
					
		EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			etrTravelreq.setEmp(masEmployee);
			//etrTravelreq.setExpClaimSts("Paid");
			etrTravelreq.setAdvStatus("Paid");
			etrTravelreq.setAdvStrSts("Paid");
			etrTravelreq.setModeOfPayment(modeOFPayment);
			etrTravelreq.setAdvancePaidAmt(advancePaid);
			etrTravelreq.setDisbursementDate(disbursementDate);
			etrTravelreq.setAdvancePaidDate(HMSUtil.convertStringTypeDateToDateType(date));
			etrTravelreq.setAdvancePaidTime(time);
			hbt.update(etrTravelreq);
		
		/*int etrExpSubmitId = 0;
		etrExpSubmitList = session.createCriteria(EtrExpsubmit.class).createAlias("Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		if(etrExpSubmitList.size()>0){
			for(EtrExpsubmit etrExpsubmit :etrExpSubmitList){
				etrExpSubmitId = etrExpsubmit.getId();
			}
		}
		try {
			EtrExpsubmit etrExpsubmit = (EtrExpsubmit)hbt.load(EtrExpsubmit.class, etrExpSubmitId);
			etrExpsubmit.setDisbursmentDate(disbursementDate);
			etrExpsubmit.setModePfPayment(modeOFPayment);
			etrExpsubmit.setAmountPaid(advancePaid);
				hbt.update(etrExpsubmit);
		} catch (Exception e) {
		
		}*/
			//etrTravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("AdvStrSts", "Payment Pending")).list();
			etrTravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("AvdReq", "y")).addOrder(Order.desc("Id")).list();
//			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class).list();
			map.put("etrTravelReqList", etrTravelReqList);
			map.put("employeeList", employeeList);
		return map;
	}

	
	

	public Map<String, Object> paidTravelAdvanceByAccounts(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List travelRequestIdList = new ArrayList();
		List advancePaidList = new ArrayList();
		List paidStatusList = new ArrayList();
		Session session = (Session)getSession();
		if(generalMap.get("travelRequestIdList")!= null){
			travelRequestIdList = (List)generalMap.get("travelRequestIdList");
		}
		if(generalMap.get("advancePaidList")!= null){
			advancePaidList = (List)generalMap.get("advancePaidList");
		}
		if(generalMap.get("paidStatusList")!= null){
			paidStatusList = (List)generalMap.get("paidStatusList");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		String modeOFPayment = "";
		if(generalMap.get("modeOFPayment")!= null){
			modeOFPayment = (String)generalMap.get("modeOFPayment");
		}
		Date disbursementDate = null;
		if(generalMap.get("disbursementDate")!= null){
			disbursementDate = (Date)generalMap.get("disbursementDate");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		String date = (String)utilMap.get("currentDate");	 
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if(travelRequestIdList.size()>0){
			for (int i = 0; i < travelRequestIdList.size(); i++) {
				
				int travelRequestId= Integer.parseInt(travelRequestIdList.get(i).toString());
				EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
				
				if(advancePaidList.size()>0){
					if(advancePaidList.get(i) != null){
						BigDecimal advancePaidAmt = new BigDecimal(advancePaidList.get(i).toString());
						etrTravelreq.setAdvancePaidAmt(advancePaidAmt);
					}
					
				}
				//if(paidStatusList.size()>0){
					//if(paidStatusList.get(i) != null){
						//String paidStatus = paidStatusList.get(i).toString();
						etrTravelreq.setAdvStatus("Paid");
						etrTravelreq.setAdvStrSts("Paid");
					//}
				//}
				if(employeeId != 0){
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					etrTravelreq.setAdvActs(masEmployee);
				}
				etrTravelreq.setModeOfPayment(modeOFPayment);
				etrTravelreq.setDisbursementDate(disbursementDate);
				etrTravelreq.setAdvancePaidDate(HMSUtil.convertStringTypeDateToDateType(date));
				etrTravelreq.setAdvancePaidTime(time);
				hbt.update(etrTravelreq);
			}
		}
		/*String qryString = "SELECT Etr_id,RefNo,jfdate,jtdate,cast((select Str_sts from etr_trvreqcmts where cmtsid= " +
		" (select Max(cmtsid) from etr_trvreqcmts where emp_id="+employeeId+" and Trv_id=Etr_id)   )as char) " +
		" as Reqstatus,Advstrsts,BookStatus,Expclaimsts,bookerid,expactsid,TRV_STATUS," +
		"(select count(*) from etr_expsubmit where trv_id=Etr_id) as EXPSUBMIT    from   etr_travelreq " +
		" WHERE eTR_ID IN (SELECT MAX(ETR_ID) FROM etr_travelreq   GROUP BY REFNO) " +
		" and emp_id="+employeeId+" order by etr_id desc";
		travelRequestList = (List) session.createSQLQuery(qryString).list();
		map.put("travelRequestList", travelRequestList);*/
		//etrTravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("AdvStrSts", "Payment Pending")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("AvdReq", "y")).addOrder(Order.desc("Id")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("etrTravelReqList", etrTravelReqList);
		return map;
	}

	public Map<String, Object> submitTravelExpenses(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrFillbookeddtls> etrFillBookedDetailsList = new ArrayList<EtrFillbookeddtls>();
		List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelClassList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTicketTypeList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForExpesnseTypeList = new ArrayList<MstrCode>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<EtrTravelreq> etrTravelReqListForEmpList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelReqListForAdvanceList = new ArrayList<EtrTravelreq>();
		List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
		List<EtrTravelreq> etrTravelRequestList  = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).add(Restrictions.eq("BookStatus","Booked")).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelClassList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tkclass")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTicketTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tktype")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		etrFillBookedDetailsList = session.createCriteria(EtrFillbookeddtls.class).createAlias("Trv", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		mstrCodeForExpesnseTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "ExpType")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		int fillBookDetailId = 0;
		if(etrFillBookedDetailsList.size()>0){
			for(EtrFillbookeddtls etrFillbookeddtls :etrFillBookedDetailsList){
				fillBookDetailId = etrFillbookeddtls.getId();
			}
		}
		etrTicketDetailsList = session.createCriteria(EtrTicketdetails.class).createAlias("Fbdt", "fillBookDetail").add(Restrictions.eq("fillBookDetail.Id", fillBookDetailId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqListForEmpList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		int employeeId = 0;
		int designationTypeId = 0;
		if(etrTravelReqListForEmpList.size()>0){
			for(EtrTravelreq etrTravelreq1 :etrTravelReqListForEmpList){
				employeeId = etrTravelreq1.getEmp().getId();
				designationTypeId = etrTravelreq1.getEmp().getRank().getId();
			}
		}
		etrTravelReqListForAdvanceList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		//standardAllowanceList = session.createCriteria(MstrStandardAllowance.class).createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", designationTypeId)).add(Restrictions.eq("Status", "y")).list();
		standardAllowanceList = session.createCriteria(MstrStandardAllowance.class).createAlias("Rank", "rank").createAlias("rank.RankCategory", "rankCategory").add(Restrictions.eq("rankCategory.Id", designationTypeId)).add(Restrictions.eq("Status", "y")).list();

		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		map.put("countryList", countryList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("mstrCodeForTravelClassList", mstrCodeForTravelClassList);
		map.put("mstrCodeForTicketTypeList", mstrCodeForTicketTypeList);
		map.put("mstrCodeForExpesnseTypeList", mstrCodeForExpesnseTypeList);
		map.put("currencyList", currencyList);
		map.put("etrTicketDetailsList", etrTicketDetailsList);
		map.put("standardAllowanceList", standardAllowanceList);
		map.put("etrTravelReqListForAdvanceList", etrTravelReqListForAdvanceList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
	}
	public Map<String, Object> showUpdateExpensesJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MstrCode> mstrCodeForExpesnseTypeList = new ArrayList<MstrCode>();
		List<EtrExpdetails> expenseDetailList = new ArrayList<EtrExpdetails>();
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId = (Integer)generalMap.get("travelRequestId");
		}
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForExpesnseTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "ExpType")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		expenseDetailList  = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "exp").createAlias("exp.Trv", "trv").add(Restrictions.eq("trv.Id", travelRequestId)).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("masCityList", masCityList);
		map.put("countryList", countryList);
		map.put("currencyList", currencyList);
		map.put("expenseDetailList", expenseDetailList);
		map.put("mstrCodeForExpesnseTypeList", mstrCodeForExpesnseTypeList);
		return map;
	}

	public Map<String, Object> updateExpenseDetails(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> userList  = new ArrayList<MasEmployee>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List expenseIdList =new ArrayList();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List fromDateList =new ArrayList();
		List toDateList =new ArrayList();
		List expenseAmountList =new ArrayList();
		List currencyList =new ArrayList();
		List remarkList =new ArrayList();
		List expenseHeadList =new ArrayList();
		int employeeId = 0;
		String emailMessage = "";
		String recipientName = "";
		String applicantName = "";
		String titleName = "";
		String titleName2 = "";
		String fromAddress = "";
		String ccAddress = "";
		String recipientAddresses = "";
		String refNo = "";
		Session session = (Session)getSession();
		Date currentDate = new Date();
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		if(generalMap.get("expenseIdList")!= null){
			expenseIdList = (List)generalMap.get("expenseIdList");
		}
		if(generalMap.get("fromPlaceList")!= null){
			fromPlaceList = (List)generalMap.get("fromPlaceList");
		}
		if(generalMap.get("toPlaceList")!= null){
			toPlaceList = (List)generalMap.get("toPlaceList");
		}
		if(generalMap.get("fromCountryList")!= null){
			fromCountryList = (List)generalMap.get("fromCountryList");
		}
		if(generalMap.get("toCountryList")!= null){
			toCountryList = (List)generalMap.get("toCountryList");
		}
		if(generalMap.get("fromDateList")!= null){
			fromDateList = (List)generalMap.get("fromDateList");
		}
		if(generalMap.get("toDateList")!= null){
			toDateList = (List)generalMap.get("toDateList");
		}
		if(generalMap.get("expenseAmountList")!= null){
			expenseAmountList = (List)generalMap.get("expenseAmountList");
		}
		if(generalMap.get("currencyList")!= null){
			currencyList = (List)generalMap.get("currencyList");
		}
		if(generalMap.get("remarkList")!= null){
			remarkList = (List)generalMap.get("remarkList");
		}
		if(generalMap.get("expenseHeadList")!= null){
			expenseHeadList = (List)generalMap.get("expenseHeadList");
			
		}
		if(generalMap.get("refNo")!= null){
			refNo = (String)generalMap.get("refNo");
		}
		userList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).list();
		 if(userList.size()>0){
			 for(MasEmployee employee :userList){
				 applicantName = employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getLastName();
				 recipientName = employee.getLineManager().getFirstName()+" "+employee.getLineManager().getMiddleName()+" "+employee.getLineManager().getLastName();
				 titleName2    = employee.getTitle().getTitleName();
				 titleName     = employee.getLineManager().getTitle().getTitleName();
				 fromAddress   = employee.getEmail();
				 ccAddress     = employee.getEmail();
				 //recipientAddresses = employee.getLineManager().getEmail();
				 recipientAddresses = "jain.vishal.22@gmail.com";
				 //fromAddress = "ritu.sahu@jktech.com";
				 //ccAddress = "ritu.sahu@jktech.com";
			 }
		 }
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		EtrExpdetails etrExpdetails= new EtrExpdetails();
		int expenseDetailId = 0;
		if(expenseIdList.size()>0){
			for (int i = 0; i < expenseIdList.size(); i++) {
				expenseDetailId = Integer.parseInt(expenseIdList.get(i).toString());
				etrExpdetails = (EtrExpdetails)hbt.load(EtrExpdetails.class, expenseDetailId);
				if(fromPlaceList.size() > 0){
				if(fromPlaceList.get(i) != null){
					int fromPlaceId = Integer.parseInt(fromPlaceList.get(i).toString());
					//MstrCity mstrCity = new MstrCity();
					//mstrCity.setId(fromPlaceId);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(fromPlaceId);
					etrExpdetails.setFromPalce(masDistrict);
				}
				}
				if(toPlaceList.size() > 0){
				if(toPlaceList.get(i) != null){
					int toPlaceId = Integer.parseInt(toPlaceList.get(i).toString());
					//MstrCity mstrCity = new MstrCity();
					//mstrCity.setId(toPlaceId);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(toPlaceId);
					etrExpdetails.setToPlace(masDistrict);
				}	
				}
				if(fromCountryList.size()>0){
				if(fromCountryList.get(i) != null){
					int fromCountryId = Integer.parseInt(fromCountryList.get(i).toString());
					MasCountry masCountry = new MasCountry();
					masCountry.setId(fromCountryId);
					etrExpdetails.setFromCountry(masCountry);	
					}
				}
				if(toCountryList.size()>0){
				if(toCountryList.get(i) != null){
					int toCountryId = Integer.parseInt(toCountryList.get(i).toString());
					MasCountry masCountry = new MasCountry();
					masCountry.setId(toCountryId);
					etrExpdetails.setToCountry(masCountry);	
					}
				}
				
				if(fromDateList.size()>0){
					if(fromDateList.get(i) != null){
						Date fromDateId  = HMSUtil.convertStringTypeDateToDateType(fromDateList.get(i).toString());
						etrExpdetails.setFrmdate(fromDateId);
					}}
				if(toDateList.size()>0){
					if(toDateList.get(i) != null){
						Date toDateId  = HMSUtil.convertStringTypeDateToDateType(toDateList.get(i).toString());
						etrExpdetails.setTodate(toDateId);
					}}
				if(currencyList.size()>0){
					if(currencyList.get(i) != null){
						MasCurrency masCurrency = new MasCurrency();
						int currencyId  = Integer.parseInt(currencyList.get(i).toString());
						masCurrency.setId(currencyId);
						etrExpdetails.setCurid(masCurrency);
					}}
				if(expenseAmountList.size()>0){
					if(expenseAmountList.get(i) != null){
						BigDecimal expenseAmount  = new BigDecimal(expenseAmountList.get(i).toString());
						etrExpdetails.setAmount(expenseAmount);
					}}
				if(remarkList.size()>0){
					if(remarkList.get(i) != null){
						String remark  = (String)(remarkList.get(i).toString());		
						etrExpdetails.setDescription(remark);
					}
				}
				
				 try{
					hbt.update(etrExpdetails);	
					emailMessage = "Dear "+ titleName + " " + recipientName+ ",\n";
					emailMessage =emailMessage + titleName2 + " "+ applicantName + " has been Re Submmited Expenses for Travel Request  "+refNo+" on dated "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
					"For details of the same, kindly log in your omega account.\n\n\n\n"+
					"This is an auto generated mail through OMEGA. Do not reply.";


					List<String> recipientAddressesList = new ArrayList<String>();
					List<String> ccAddressesList = new ArrayList<String>();
					List<String> bccAddresses = new ArrayList<String>();


				//		String ccAddress1  = "vishal.jain@jktech.com";
				//		String ccAddress2  = "vishal.jain@jktech.com";


					String subject = "Expenses Re submitted";
					recipientAddressesList.add(recipientAddresses);
					ccAddressesList.add(ccAddress);
				//	ccAddressesList.add(ccAddress1);
				//	ccAddressesList.add(ccAddress2);
					boolean sent=false;
					if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
						LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
					}
					
					
					
					
					
					
					
					
					
					
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
		}
		//Session session = (Session)getSession();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).addOrder(Order.desc("Jfdate")).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("employeeList", employeeList);
		return map;
	}

	
	/*****************  Methods For E-Travel Reports Start ****************************/
	public Map<String, Object> showTravelsBetweenDates(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MstrProject>   projectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		projectList = session.createCriteria(MstrProject.class).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		map.put("projectList", projectList);
		map.put("departmentList", departmentList);
		return map;
	}
	
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		map.put("con",con);
		return map;
	}
	public Map<String, Object> displaySubmitExpensesAttachment(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTrvsub> temExpensesAttachList = new ArrayList<TempTrvsub>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		temExpensesAttachList = session.createCriteria(TempTrvsub.class).createAlias("TdsaDsid", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("temExpensesAttachList", temExpensesAttachList);
		return map;
	}

	public Map<String, Object> addAttachExpensesFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTrvsub> temExpensesAttachList = new ArrayList<TempTrvsub>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		String comments = "";
		if(generalMap.get("comments")!= null){
			comments =(String) generalMap.get("comments");
		}
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId =(Integer) generalMap.get("travelRequestId");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId =(Integer) generalMap.get("employeeId");
		}
		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				//hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
	    		 file=new File(uploadURL + "/" + filename);
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	     ByteBuffer byteBuff=null;
	    	   //  int modLength=length/
	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;
	    	    	
	    	     }
	    
	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());
	    	         
	    	     }
	    	     is.close();
	        // Close the input stream and return bytes
	    	    // StringTokenizer strToken=new StringTokenizer( filename,".");
		   	
	    	   //  filename=strToken.nextToken();
	    	   //  fileExtension=strToken.nextToken();
	    	     TempTrvsub tempTrvsub = new TempTrvsub();
	    	     tempTrvsub.setTdsaDfilename(filename);
	    	     tempTrvsub.setTdsaOfilename(filename);
	    	     EtrTravelreq etrTravelreq = new EtrTravelreq();
	    	     etrTravelreq.setId(travelRequestId);
	    	     tempTrvsub.setTdsaDsid(etrTravelreq);
	    	     tempTrvsub.setTdsaCmts(comments);
	    	     MasEmployee masEmployee = new MasEmployee();
	    	     masEmployee.setId(employeeId);
	    	     tempTrvsub.setTdsaUserid(masEmployee);
	    	     hbt.save(tempTrvsub);
	      
	    	     //file.delete();
	      
	    
	    }// end of 'try' loop 
		catch (Exception e) {
	    	
	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	    }
		temExpensesAttachList = session.createCriteria(TempTrvsub.class).createAlias("TdsaDsid", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		map.put("temExpensesAttachList", temExpensesAttachList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
	}
	public Map<String, Object> deleteAttachExpenseFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTrvsub> temExpensesAttachList = new ArrayList<TempTrvsub>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		List ticketAttachIdList = new ArrayList();
		List uploadFileNameList = new ArrayList();
		List commentsList = new ArrayList();
		List employeeIdList = new ArrayList();
		List travelRequestIdList = new ArrayList();
		
		if(generalMap.get("ticketAttachIdList")!= null){
			ticketAttachIdList =(List)generalMap.get("ticketAttachIdList");
		}
		
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId =(Integer) generalMap.get("travelRequestId");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		// etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		//TempTickattach tempTickattach = (TempTickattach)hbt.load(TempTickattach.class, ticketAttachId);
		//hbt.delete(tempTickattach);
		int ticketAttachId = 0;
		if(ticketAttachIdList.size()>0){
			for (int i = 0; i < ticketAttachIdList.size(); i++) {
				if(ticketAttachIdList.get(i) != null){
					ticketAttachId = Integer.parseInt(ticketAttachIdList.get(i).toString());
					//etrTrvdetails = (EtrTrvdetails)hbt.load(EtrTrvdetails.class, etrTrvDeatilId);
					TempTrvsub tempTrvsub = (TempTrvsub)hbt.load(TempTrvsub.class, ticketAttachId);
					hbt.delete(tempTrvsub);
				}
			}
		}
		
		temExpensesAttachList = session.createCriteria(TempTrvsub.class).createAlias("TdsaDsid", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		map.put("temExpensesAttachList", temExpensesAttachList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
	}

	public Map<String, Object> saveSubmitExpensesDetails(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		//List<String> travelRequestList = new ArrayList<String>();
		List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> applicantList = new ArrayList<MasEmployee>();
		
		Session session = (Session)getSession();
		List expenseList = new ArrayList();
		List fromdateList = new ArrayList();
		List todateList = new ArrayList();
		List descList = new ArrayList();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List currencyList = new ArrayList();
		List amountList = new ArrayList();
		//Transaction tx=null;
		//tx=(Transaction) session.beginTransaction();
		int employeeId = 0;
		if (generalMap.get("employeeId")!= null) {
			employeeId = (Integer)generalMap.get("employeeId");
		}
		EtrExpsubmit etrExpsubmit = new EtrExpsubmit();
		if (generalMap.get("etrExpsubmit")!= null) {
			etrExpsubmit = (EtrExpsubmit)generalMap.get("etrExpsubmit");
		}
		if (generalMap.get("expenseList")!= null) {
			expenseList = (List)generalMap.get("expenseList");
		}
		if (generalMap.get("fromdateList")!= null) {
			fromdateList = (List)generalMap.get("fromdateList");
		}
		if (generalMap.get("todateList")!= null) {
			todateList = (List)generalMap.get("todateList");
		}
		if (generalMap.get("descList")!= null) {
			descList = (List)generalMap.get("descList");
		}
		if (generalMap.get("fromPlaceList")!= null) {
			fromPlaceList = (List)generalMap.get("fromPlaceList");
		}
		if (generalMap.get("toPlaceList")!= null) {
			toPlaceList = (List)generalMap.get("toPlaceList");
		}
		if (generalMap.get("fromCountryList")!= null) {
			fromCountryList = (List)generalMap.get("fromCountryList");
		}
		if (generalMap.get("toCountryList")!= null) {
			toCountryList = (List)generalMap.get("toCountryList");
		}
		if (generalMap.get("currencyList")!= null) {
			currencyList = (List)generalMap.get("currencyList");
		}
		if (generalMap.get("amountList")!= null) {
			amountList = (List)generalMap.get("amountList");
		}
		int travelRequestId = 0;
		if (generalMap.get("travelRequestId")!= null) {
			travelRequestId = (Integer)generalMap.get("travelRequestId");
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			hbt.save(etrExpsubmit);
			//hbt.refresh(etrExpsubmit);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	if(fromdateList.size()>0){
	    		for(int i = 0; i < fromdateList.size(); i++){
					EtrExpdetails etrExpdetails = new EtrExpdetails();
					String formattedFromDate = "" ;
					String formattedToDate = "";
				
					int expenseTypeId = 0;
					if(expenseList.size()>0){
						if(Integer.parseInt(expenseList.get(i).toString()) != 0){
							expenseTypeId = Integer.parseInt(expenseList.get(i).toString());
							MstrCode expCode = new MstrCode();
							expCode.setId(expenseTypeId);
							etrExpdetails.setExptype(expCode);
						}
					}
					Date fromDate = null;
					if(fromdateList.size()>0){
						if(fromdateList.get(i) != null){
							 fromDate = HMSUtil.dateFormatterDDMMYYYY(fromdateList.get(i).toString());
							//formattedFromDate=sdf.format(fromDate.getTime());
							etrExpdetails.setFrmdate(fromDate);
						}
					}
					Date toDate = null;
					if(todateList.size()>0){
						if(todateList.get(i) != null){
							 toDate = HMSUtil.dateFormatterDDMMYYYY(todateList.get(i).toString());
							//formattedToDate=sdf.format(toDate.getTime());
							 etrExpdetails.setTodate(toDate);
						}
					 }
					String description = "";
					if(descList.size()>0){
						if(descList.get(i) != null){
							 description = descList.get(i).toString();
							etrExpdetails.setDescription(description);
						}
					}
					int fromCountryId = 0;
					if(fromCountryList.size()>0){
						if(fromCountryList.get(i) != null){
							fromCountryId = Integer.parseInt(fromCountryList.get(i).toString());
							MasCountry masCountry = new MasCountry();
							masCountry.setId(fromCountryId);
							etrExpdetails.setFromCountry(masCountry);
						}
					}
					int toCountryId = 0;
					if(toCountryList.size()>0){
						if(toCountryList.get(i) != null){
							toCountryId = Integer.parseInt(toCountryList.get(i).toString());
							MasCountry masCountry1 = new MasCountry();
							masCountry1.setId(toCountryId);
							etrExpdetails.setToCountry(masCountry1);
						}
					}
					int fromPalceId = 0;
					if(fromPlaceList.size()>0){
						if(fromPlaceList.get(i) != null){
							fromPalceId = Integer.parseInt(fromPlaceList.get(i).toString());
							MasDistrict masDistrict = new MasDistrict();
							masDistrict.setId(fromPalceId);
							etrExpdetails.setFromPalce(masDistrict);
							
						}
					}
					int toPlaceId = 0;
					if(toPlaceList.size()>0){
						if(toPlaceList.get(i) != null){
							toPlaceId = Integer.parseInt(toPlaceList.get(i).toString());
							MasDistrict masDistrict1 = new MasDistrict();
							masDistrict1.setId(toPlaceId);
							etrExpdetails.setToPlace(masDistrict1);
						}
					}
					int currencyId = 0;
					if(currencyList.size()>0){
						if(currencyList.get(i) != null){
							currencyId = Integer.parseInt(currencyList.get(i).toString());
							MasCurrency masCurrency = new MasCurrency();
							masCurrency.setId(currencyId);
							etrExpdetails.setCurid(masCurrency);
						}
					}
					BigDecimal amount = new BigDecimal("0");
					if(amountList.size()>0){
						if(amountList.get(i) != null){
							 amount = new BigDecimal(amountList.get(i).toString());
							etrExpdetails.setAmount(amount);
						}
					}
					etrExpdetails.setExp(etrExpsubmit);
					try
					{
						hbt.save(etrExpdetails);
					/*EtrExpdetails t = new EtrExpdetails();
					String qry = "insert into etr_expdetails(exp_id, exptype_id,amount,frmdate,todate," +
							" description,curid,from_palce_id,to_place_id,from_country_id,to_country_id) values (" +etrExpsubmit.getId()+ "," +expenseTypeId  + "," + amount + ",'"+formattedFromDate+" ','"+formattedToDate+" ','"+description+"'," +currencyId +"," +fromPalceId  + "," +toPlaceId  + "," +fromCountryId  + "," +toCountryId  + ")";   
					int s = session.createSQLQuery(qry).executeUpdate();*/
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
	    		}
			}
		
		
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
	
			if(travelRequestId != 0 ){
				EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class,travelRequestId);
				etrTravelreq.setExpClaimSts("Submitted");
				etrTravelreq.setSubmitExpenseDate(HMSUtil.convertStringTypeDateToDateType(date));
				etrTravelreq.setSubmitExpenseTime(time);
				hbt.update(etrTravelreq);
			}
		
			etrTravelReqList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
			int lineManagerId = 0;
			int applicantId = 0;
			String refNo = "";
			Date fromDate = null;
			Date toDate = null;
			String recipientAddresses = "";
			String fromAddress  = "";
			 String ccAddress = "";
			if(etrTravelReqList.size()>0){
				for(EtrTravelreq etrTravelreq :etrTravelReqList){
					lineManagerId = etrTravelreq.getEmp().getLineManager().getId();
					applicantId = etrTravelreq.getEmp().getId();
					refNo = etrTravelreq.getRefNo();
					fromDate = etrTravelreq.getJfdate();
					toDate = etrTravelreq.getJtdate();
					
				}
			}
			String applicantName ="";
			String approverName = "";
			String titleName = "";
		
			applicantList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(applicantId)).list();
			if(applicantList.size()>0){
				for(MasEmployee employee:applicantList){
				applicantName = employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getLastName();
				approverName = employee.getLineManager().getFirstName()+" "+employee.getLineManager().getMiddleName()+" "+employee.getLineManager().getLastName();
				titleName = employee.getLineManager().getTitle().getTitleName();
				recipientAddresses = employee.getLineManager().getEmail();
				//recipientAddresses = "ritu.sahu@jktech.com";
				fromAddress = employee.getEmail();
				//fromAddress = "vishal.jain@jktech.com";
				ccAddress = employee.getEmail();
				//ccAddress = "vishal.jain@jktech.com";
				}
			}
			Date currentdate = new Date();
			EtrTrvsubapptbl etrTrvsubapptbl = new EtrTrvsubapptbl();
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(lineManagerId);
			etrTrvsubapptbl.setAppr(masEmployee);
			etrTrvsubapptbl.setExp(etrExpsubmit);
			etrTrvsubapptbl.setApprDate(currentdate);
			etrTrvsubapptbl.setApprSts("Pending");
			hbt.save(etrTrvsubapptbl);
			
			Date currentDate = new Date();
			String emailMessage = "";
		 	emailMessage = "Dear "+ titleName + " " + approverName+ ",\n";
			 emailMessage =emailMessage+" "+applicantName +" has claimed expenses on  "+HMSUtil.convertDateToStringWithoutTime(currentDate)+" against travel Request  "+
			 refNo+" for travel "+HMSUtil.convertDateToStringWithoutTime(fromDate)+
				" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n"+
				"For details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
		 
		 	List<String> recipientAddressesList = new ArrayList<String>();
			List<String> ccAddressesList = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();
			
			String subject = "Expense Claim";
			
				
			recipientAddressesList.add(recipientAddresses);
			ccAddressesList.add(ccAddress);
			boolean sent=false;
			if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
			}
		
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).add(Restrictions.eq("Status", "y")).list();
			etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).addOrder(Order.desc("Jfdate")).list();
			map.put("etrTravelRequestList", etrTravelRequestList);
			map.put("employeeList", employeeList);
			return map;
	}

	public Map<String, Object> viewTravelExpenses(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrExpsubmit> etrExpSubmitList = new ArrayList<EtrExpsubmit>();
		List<EtrFillbookeddtls> etrFillBookedDetailsList = new ArrayList<EtrFillbookeddtls>();
		List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTravelClassList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForTicketTypeList = new ArrayList<MstrCode>();
		List<MstrCode> mstrCodeForExpesnseTypeList = new ArrayList<MstrCode>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<EtrTravelreq> etrTravelReqListForEmpList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelReqListForAdvanceList = new ArrayList<EtrTravelreq>();
		List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).add(Restrictions.eq("BookStatus","Booked")).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelModeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "mode")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTravelClassList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tkclass")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		mstrCodeForTicketTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "tktype")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		/*etrFillBookedDetailsList = session.createCriteria(EtrFillbookeddtls.class).createAlias("Trv", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		mstrCodeForExpesnseTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "ExpType")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		int fillBookDetailId = 0;
		if(etrFillBookedDetailsList.size()>0){
			for(EtrFillbookeddtls etrFillbookeddtls :etrFillBookedDetailsList){
				fillBookDetailId = etrFillbookeddtls.getId();
			}
		}
		etrTicketDetailsList = session.createCriteria(EtrTicketdetails.class).createAlias("Fbdt", "fillBookDetail").add(Restrictions.eq("fillBookDetail.Id", fillBookDetailId)).list();*/
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		etrExpSubmitList = session.createCriteria(EtrExpsubmit.class).createAlias("Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		etrTravelReqListForEmpList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		int employeeId = 0;
		int designationTypeId = 0;
		if(etrTravelReqListForEmpList.size()>0){
			for(EtrTravelreq etrTravelreq1 :etrTravelReqListForEmpList){
				employeeId = etrTravelreq1.getEmp().getId();
				designationTypeId = etrTravelreq1.getEmp().getRank().getRankCategory().getId();
			}
		}
		etrTravelReqListForAdvanceList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		//standardAllowanceList = session.createCriteria(MstrStandardAllowance.class).createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", designationTypeId)).add(Restrictions.eq("Status", "y")).list();
		standardAllowanceList = session.createCriteria(MstrStandardAllowance.class).createAlias("Rank", "rank").createAlias("rank.RankCategory", "rankCategory").add(Restrictions.eq("rankCategory.Id", designationTypeId)).add(Restrictions.eq("Status", "y")).list();

		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		map.put("standardAllowanceList", standardAllowanceList);
		map.put("etrTravelReqListForAdvanceList", etrTravelReqListForAdvanceList);
		map.put("etrExpSubmitList", etrExpSubmitList);
		map.put("countryList", countryList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForTravelModeList", mstrCodeForTravelModeList);
		map.put("mstrCodeForTravelClassList", mstrCodeForTravelClassList);
		map.put("mstrCodeForTicketTypeList", mstrCodeForTicketTypeList);
		map.put("mstrCodeForExpesnseTypeList", mstrCodeForExpesnseTypeList);
		map.put("currencyList", currencyList);
		map.put("etrTicketDetailsList", etrTicketDetailsList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
	}

	public Map<String, Object> viewExpensesAttachment(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTrvsub> temExpensesAttachList = new ArrayList<TempTrvsub>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		temExpensesAttachList = session.createCriteria(TempTrvsub.class).createAlias("TdsaDsid", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("temExpensesAttachList", temExpensesAttachList);
		return map;
	}
	public Map<String, Object> viewBookingDetailsAttachment(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		tempTicketAttachList = session.createCriteria(TempTickattach.class).createAlias("TdsaDsid", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("tempTicketAttachList", tempTicketAttachList);
		return map;
	}
    

	public Map<String, Object> showTravelExpenseClaimJsp() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
	List<Object[]> etrExpDetailList = new ArrayList<Object[]>();
	Session session = (Session)getSession();
	Criteria crit = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "exp").createAlias("exp.Trv", "trv")
					.createAlias("trv.Emp", "emp")
					.setProjection(Projections.projectionList().add(Projections.property("trv.Id"))
					.add(Projections.property("trv.RefNo"))
					.add(Projections.property("trv.Jfdate"))
					.add(Projections.property("trv.Jtdate"))
					.add(Projections.sum("Amount"))
					.add(Projections.property("emp.FirstName"))
					.add(Projections.property("emp.LastName"))
					.add(Projections.sum("StandardAmount"))
					.add(Projections.property("trv.AdvAmt"))
					.add(Projections.property("trv.AdvancePaidAmt"))
					.add(Projections.property("emp.Id"))
					.add(Projections.sum("ApprovedExpenseAmount"))
					.add(Projections.property("trv.ExpClaimSts"))
					.add(Projections.property("exp.ExpenseSettlementDate"))
					.add(Projections.property("exp.ExpenseSettlementTime"))
					.add(Projections.property("exp.ApproveExpenseDate"))
					.add(Projections.property("exp.ApproveExpenseTime"))
					.add(Projections.property("trv.SubmitExpenseDate"))
					.add(Projections.property("trv.SubmitExpenseTime"))
							.add(Projections.groupProperty("trv.RefNo"))); 
		etrExpDetailList =crit.addOrder(Order.desc("trv.Jfdate")).list(); 
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).list();
		map.put("etrTravelReqList", etrTravelReqList);
		map.put("etrExpDetailList", etrExpDetailList);
		map.put("employeeList", employeeList);
		return map;
		}
	public Map<String, Object> searchTravelExpenseSettlementList(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
		List<Object[]> etrExpDetailList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		
		int searchRefNoId = 0; 
		if(generalMap.get("searchRefNoId")!= null){
			searchRefNoId = (Integer)generalMap.get("searchRefNoId");
		}
		
		int empId = 0;
		if(generalMap.get("empId")!= null){
			empId = (Integer)generalMap.get("empId");
		}
		Date fromDate = null;
		if(generalMap.get("fromDate")!= null){
			fromDate = (Date)generalMap.get("fromDate");
		}
		
		Date toDate = null;
		if(generalMap.get("toDate")!= null){
			toDate = (Date)generalMap.get("toDate");
		}
		Criteria crit = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "exp").createAlias("exp.Trv", "trv")
		.createAlias("trv.Emp", "emp")
		.setProjection(Projections.projectionList().add(Projections.property("trv.Id"))
		.add(Projections.property("trv.RefNo"))
		.add(Projections.property("trv.Jfdate"))
		.add(Projections.property("trv.Jtdate"))
		.add(Projections.sum("Amount"))
		.add(Projections.property("emp.FirstName"))
		.add(Projections.property("emp.LastName"))
		.add(Projections.sum("StandardAmount"))
		.add(Projections.property("trv.AdvAmt"))
		.add(Projections.property("trv.AdvancePaidAmt"))
		.add(Projections.property("emp.Id"))
		.add(Projections.sum("ApprovedExpenseAmount"))
		.add(Projections.property("trv.ExpClaimSts"))
		.add(Projections.property("exp.ExpenseSettlementDate"))
		.add(Projections.property("exp.ExpenseSettlementTime"))
				.add(Projections.groupProperty("trv.RefNo"))); 


		
		if(searchRefNoId != 0){
			crit = crit.add(Restrictions.eq("trv.Id", searchRefNoId));
		}
		
		if(empId !=0){
			crit =crit .add(Restrictions.eq("emp.Id", empId));
		}
		
		if(fromDate != null || toDate!= null ){
			crit = crit.add(Restrictions.gt("trv.Jfdate", fromDate)).add(Restrictions.lt("trv.Jtdate", toDate));
			
		}
		
		etrExpDetailList =crit.list(); 
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).list();
		map.put("etrExpDetailList", etrExpDetailList);
		map.put("employeeList", employeeList);
		map.put("etrTravelReqList", etrTravelReqList);
		return map;
	}


	public Map<String, Object> viewTravelRequestForExpenseClaim(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrExpdetails> etrExpDetailList = new ArrayList<EtrExpdetails>();
		List<EtrExpsubmit> etrExpSubmitList = new ArrayList<EtrExpsubmit>();
		List<EtrFillbookeddtls> etrFillBookedDetailsList = new ArrayList<EtrFillbookeddtls>();
		List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MstrCode> mstrCodeForExpesnseTypeList = new ArrayList<MstrCode>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
		List<EtrTravelreq> etrTravelReqListForAdvanceList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		Session session = (Session)getSession();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).add(Restrictions.eq("BookStatus","Booked")).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		etrFillBookedDetailsList = session.createCriteria(EtrFillbookeddtls.class).createAlias("Trv", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		mstrCodeForExpesnseTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "ExpType")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		int fillBookDetailId = 0;
		if(etrFillBookedDetailsList.size()>0){
			for(EtrFillbookeddtls etrFillbookeddtls :etrFillBookedDetailsList){
				fillBookDetailId = etrFillbookeddtls.getId();
			}
		}
		etrTicketDetailsList = session.createCriteria(EtrTicketdetails.class).createAlias("Fbdt", "fillBookDetail").add(Restrictions.eq("fillBookDetail.Id", fillBookDetailId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		etrExpSubmitList = session.createCriteria(EtrExpsubmit.class).createAlias("Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		int employeeId = 0;
		int designationTypeId = 0;
		if(etrTravelRequestList.size()>0){
			for(EtrTravelreq etrTravelreq:etrTravelRequestList){
				designationTypeId = etrTravelreq.getEmp().getRank().getRankCategory().getId();
				employeeId = etrTravelreq.getEmp().getId();
			}
		}
		etrTravelReqListForAdvanceList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();

		etrExpDetailList = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "expSubmit").createAlias("expSubmit.Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		standardAllowanceList = session.createCriteria(MstrStandardAllowance.class).createAlias("Rank", "rank").createAlias("rank.RankCategory", "rankCategory").add(Restrictions.eq("rankCategory.Id", designationTypeId)).add(Restrictions.eq("Status", "y")).list();
			
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		map.put("etrExpDetailList", etrExpDetailList);
		map.put("etrExpSubmitList", etrExpSubmitList);
		map.put("countryList", countryList);
		map.put("etrTicketDetailsList", etrTicketDetailsList);
		map.put("employeeList", employeeList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForExpesnseTypeList", mstrCodeForExpesnseTypeList);
		map.put("currencyList", currencyList);
		map.put("departmentList", departmentList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		map.put("standardAllowanceList", standardAllowanceList);
		map.put("etrTravelReqListForAdvanceList", etrTravelReqListForAdvanceList);
		return map;
	}

	public Map<String, Object> paidTravelExpensesClaim(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List travelRequestIdList = new ArrayList();
		List<EtrTravelreq>etrTrvList = new ArrayList<EtrTravelreq>();
		List<EtrExpsubmit> etrExpSubmitList = new ArrayList<EtrExpsubmit>();
		List<MasEmployee>userList = new ArrayList<MasEmployee>();
		List employeeIdList = new ArrayList();
		List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
		List<Object[]> etrExpDetailList = new ArrayList<Object[]>();
		List<MasEmployee> applicantList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		int userId = 0;
		if(generalMap.get("userId")!= null){
			userId = (Integer)generalMap.get("userId");
		}
		if(generalMap.get("travelRequestIdList")!= null){
			travelRequestIdList = (List)generalMap.get("travelRequestIdList");
		}
		if(generalMap.get("employeeIdList")!= null){
			employeeIdList = (List)generalMap.get("employeeIdList");
		}
		String modeOFPayment = "";
		if(generalMap.get("modeOFPayment")!= null){
			modeOFPayment = (String)generalMap.get("modeOFPayment");
		}
		Date disbursementDate = null;
		if(generalMap.get("disbursementDate")!= null){
			disbursementDate = (Date)generalMap.get("disbursementDate");
		}
		int travelRequestId = 0;
		Date fromDate = null;
		Date toDate = null;
		String refNo = "";
		String recipientAddresses = "";
		Date settlementDate = null;
		 int approverId = 0;
		 String titleName = "";
		 String lineManagerName = "";
		 String applicantName = "";
		 String ccAddress = "";
		 String fromAddress  = "";
		 int etrExpSubmitId = 0;
		userList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(userId)).list();
		if(userList.size()>0){
			for(MasEmployee employee :userList){
				fromAddress = employee.getEmail();
				//fromAddress = "ritu.sahu@jktech.com";
				ccAddress = employee.getEmail();
				//ccAddress =  "ritu.sahu@jktech.com";
			}
			
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if(travelRequestIdList.size()>0){
			for (int i = 0; i < travelRequestIdList.size(); i++) {
				
				 travelRequestId= Integer.parseInt(travelRequestIdList.get(i).toString());
				EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
				
				if(employeeIdList.size()>0){
					if(employeeIdList.get(i) != null){
						int employeeId = Integer.parseInt(employeeIdList.get(i).toString());
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(employeeId);
						etrTravelreq.setEmp(masEmployee);
					}
				}
					etrTravelreq.setExpClaimSts("Paid");
				
					hbt.update(etrTravelreq);
					int applicantId = 0;
					etrTrvList = session.createCriteria(EtrTravelreq.class).add(Restrictions.eq("Id",travelRequestId)).list();
					if(etrTrvList.size()>0){
						for(EtrTravelreq travel :etrTrvList){
							fromDate = travel.getJfdate();
							toDate = travel.getJtdate();
							refNo = travel.getRefNo();
							applicantId = travel.getEmp().getId();
							
						}
					}
					applicantList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(applicantId)).list();
				if(applicantList.size()>0){
					for(MasEmployee employee:applicantList){
						applicantName = employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getLastName();
						recipientAddresses = employee.getEmail();
						titleName = employee.getTitle().getTitleName();
						//recipientAddresses = "dipali.shukla@jktech.com";
					}
				}
				etrExpSubmitList = session.createCriteria(EtrExpsubmit.class).createAlias("Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
				if(etrExpSubmitList.size()>0){
					for(EtrExpsubmit etrExpsubmit :etrExpSubmitList){
						etrExpSubmitId = etrExpsubmit.getId();
						settlementDate = etrExpsubmit.getExpenseSettlementDate();
					}
				}
				
				Date currentDate = new Date();
				String emailMessage = "";
				 emailMessage = "Dear "+ titleName + " " + applicantName+ ",\n";
				 emailMessage =emailMessage +" Your Expense claim for the Travel Request  "+refNo+" for a travel "+
					HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
					" is settled on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
					"For details of the same, kindly log in your omega account.\n\n\n\n"+
					"This is an auto generated mail through OMEGA. Do not reply.";
				 
				 List<String> recipientAddressesList = new ArrayList<String>();
					List<String> ccAddressesList = new ArrayList<String>();
					List<String> bccAddresses = new ArrayList<String>();
					
					String subject = "Expense Settlement";
				    String ccAddress1  = "accountshelp@clinirx.com";
				//	String ccAddress1  = "vishal.jain@jktech.com";
						
					recipientAddressesList.add(recipientAddresses);
					ccAddressesList.add(ccAddress);
					ccAddressesList.add(ccAddress1);
					boolean sent=false;
					if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
						LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
					}
					
			}
		}
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		EtrExpsubmit etrExpsubmit = (EtrExpsubmit)hbt.load(EtrExpsubmit.class, etrExpSubmitId);
		etrExpsubmit.setDisbursmentDate(disbursementDate);
		etrExpsubmit.setModePfPayment(modeOFPayment);
		etrExpsubmit.setExpenseSettlementDate(HMSUtil.convertStringTypeDateToDateType(date));
		etrExpsubmit.setExpenseSettlementTime(time);
		
			hbt.update(etrExpsubmit);	
			Criteria crit = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "exp").createAlias("exp.Trv", "trv")
			.createAlias("trv.Emp", "emp")
			.setProjection(Projections.projectionList().add(Projections.property("trv.Id"))
			.add(Projections.property("trv.RefNo"))
			.add(Projections.property("trv.Jfdate"))
			.add(Projections.property("trv.Jtdate"))
			.add(Projections.sum("Amount"))
			.add(Projections.property("emp.FirstName"))
			.add(Projections.property("emp.LastName"))
			.add(Projections.sum("StandardAmount"))
			.add(Projections.property("trv.AdvAmt"))
			.add(Projections.property("trv.AdvancePaidAmt"))
			.add(Projections.property("emp.Id"))
			.add(Projections.sum("ApprovedExpenseAmount"))
			.add(Projections.property("trv.ExpClaimSts"))
			.add(Projections.property("exp.ExpenseSettlementDate"))
			.add(Projections.property("exp.ExpenseSettlementTime"))
			.add(Projections.property("exp.ApproveExpenseDate"))
			.add(Projections.property("exp.ApproveExpenseTime"))
			.add(Projections.property("trv.SubmitExpenseDate"))
			.add(Projections.property("trv.SubmitExpenseTime"))
					.add(Projections.groupProperty("trv.RefNo"))); 
		etrExpDetailList =crit.addOrder(Order.desc("trv.Jfdate")).list(); 
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		etrTravelReqList = session.createCriteria(EtrTravelreq.class).list();
		map.put("etrTravelReqList", etrTravelReqList);
		map.put("etrExpDetailList", etrExpDetailList);
		map.put("employeeList", employeeList);
		return map;
	}
	public Map<String, Object> paidTravelExpenseSettlement(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List travelRequestIdList = new ArrayList();
		List<EtrExpsubmit> etrExpSubmitList = new ArrayList<EtrExpsubmit>();
		List<EtrTravelreq> etrTravelReqListForAdvanceList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MasEmployee> userList = new ArrayList<MasEmployee>();
		List<MasEmployee> applicantList = new ArrayList<MasEmployee>();
		List employeeIdList = new ArrayList();
		Session session = (Session)getSession();
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId = (Integer)generalMap.get("travelRequestId");
		}
		int userId = 0;
		if(generalMap.get("userId")!= null){
			userId = (Integer)generalMap.get("userId");
		}
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId = (Integer)generalMap.get("employeeId");
		}
		String modeOFPayment = "";
		if(generalMap.get("modeOFPayment")!= null){
			modeOFPayment = (String)generalMap.get("modeOFPayment");
		}
		Date disbursementDate = null;
		if(generalMap.get("disbursementDate")!= null){
			disbursementDate = (Date)generalMap.get("disbursementDate");
		}
		String fromAddress= "";
		String ccAddress= "";
		userList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(userId)).list();
		if(userList.size()>0){
			for(MasEmployee employee :userList){
				fromAddress = employee.getEmail();
				//fromAddress = "ritu.sahu@jktech.com";
				ccAddress = employee.getEmail();
				//ccAddress =  "ritu.sahu@jktech.com";
			}
			
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
					
		EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			etrTravelreq.setEmp(masEmployee);
			etrTravelreq.setExpClaimSts("Paid");
			hbt.update(etrTravelreq);
		
		int etrExpSubmitId = 0;
		etrExpSubmitList = session.createCriteria(EtrExpsubmit.class).createAlias("Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		if(etrExpSubmitList.size()>0){
			for(EtrExpsubmit etrExpsubmit :etrExpSubmitList){
				etrExpSubmitId = etrExpsubmit.getId();
			}
		}
		try {
			EtrExpsubmit etrExpsubmit = (EtrExpsubmit)hbt.load(EtrExpsubmit.class, etrExpSubmitId);
			etrExpsubmit.setDisbursmentDate(disbursementDate);
			etrExpsubmit.setModePfPayment(modeOFPayment);
			etrExpsubmit.setExpenseSettlementDate(HMSUtil.convertStringTypeDateToDateType(date));
			etrExpsubmit.setExpenseSettlementTime(time);
				hbt.update(etrExpsubmit);
		} catch (Exception e) {
		
		}
		Date fromDate = null;
		int applicantId = 0;
		Date toDate = null;
		String refNo = "";
		String titleName = "";
		String recipientAddresses = "";
		String applicantName = "";
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		if(etrTravelRequestList.size()>0){
			for(EtrTravelreq travel :etrTravelRequestList){
				fromDate = travel.getJfdate();
				toDate = travel.getJtdate();
				refNo = travel.getRefNo();
				applicantId = travel.getEmp().getId();
				
			}
		}
		applicantList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(applicantId)).list();
		if(applicantList.size()>0){
			for(MasEmployee employee:applicantList){
				applicantName = employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getLastName();
				recipientAddresses = employee.getEmail();
				titleName = employee.getTitle().getTitleName();
				//recipientAddresses = "vishal.jain@jktech.com";
			}
		}
		Date currentDate = new Date();
		String emailMessage = "";
		 emailMessage = "Dear "+ titleName + " " + applicantName+ ",\n";
		 emailMessage =emailMessage +" Your Expense claim for the Travel Request  "+refNo+" for a travel "+
			HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
			" is settled on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
			"For details of the same, kindly log in your omega account.\n\n\n\n"+
			"This is an auto generated mail through OMEGA. Do not reply.";
		 
		 List<String> recipientAddressesList = new ArrayList<String>();
			List<String> ccAddressesList = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();
			
			String subject = "Expense Settlement";
			String ccAddress1  = "accountshelp@clinirx.com";
		//	String ccAddress1  = "vishal.jain@jktech.com";
				
			recipientAddressesList.add(recipientAddresses);
			ccAddressesList.add(ccAddress);
			ccAddressesList.add(ccAddress1);
			boolean sent=false;
			if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
			}
		

		etrTravelReqListForAdvanceList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		map.put("etrTravelReqListForAdvanceList", etrTravelReqListForAdvanceList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		map = showTravelExpenseClaimJsp();
		return map;
	}

	public Map<String, Object> showTravelExpenseApprovalJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
		List<Object[]> etrExpDetailList = new ArrayList<Object[]>();
		int lineManagerId = 0;
		if(generalMap.get("lineManagerId")!= null){
			lineManagerId = (Integer)generalMap.get("lineManagerId");
		}
		Session session = (Session)getSession();
		Criteria crit = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "exp").createAlias("exp.Trv", "trv")
						.createAlias("trv.Emp", "emp").add(Restrictions.eq("emp.LineManager.Id", lineManagerId))
						.setProjection(Projections.projectionList().add(Projections.property("trv.Id"))
						.add(Projections.property("trv.RefNo"))
						.add(Projections.property("trv.Jfdate"))
						.add(Projections.property("trv.Jtdate"))
						.add(Projections.sum("Amount"))
						.add(Projections.property("emp.FirstName"))
						.add(Projections.property("emp.LastName"))
						.add(Projections.sum("StandardAmount"))
						.add(Projections.property("trv.ExpClaimSts"))
						.add(Projections.property("exp.ApproveExpenseDate"))
						.add(Projections.property("exp.ApproveExpenseTime"))
						.add(Projections.property("trv.SubmitExpenseDate"))
						.add(Projections.property("trv.SubmitExpenseTime"))
						.add(Projections.property("exp.ExpenseSettlementDate"))
						.add(Projections.property("exp.ExpenseSettlementTime"))
						
								.add(Projections.groupProperty("trv.RefNo"))); 
		
		etrExpDetailList =crit.addOrder(Order.desc("trv.Jfdate")).list(); 
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("LineManager.Id", lineManagerId)).list();
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").createAlias("Emp.LineManager", "lManager").add(Restrictions.eq("lManager.Id", lineManagerId)).add(Restrictions.eq("ExpClaimSts", "Submitted")).list();
		map.put("etrExpDetailList", etrExpDetailList);
		map.put("employeeList", employeeList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
		}
//	iii
	public Map<String, Object> searchTravelExpenseApprovelList(Map<String, Object> generalMap) {
		  Map<String, Object> map = new HashMap<String, Object>();
			List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
			List<Object[]> etrExpDetailList = new ArrayList<Object[]>();
			Session session = (Session)getSession();
			
			int searchRefNoId = 0; 
			if(generalMap.get("searchRefNoId")!= null){
				searchRefNoId = (Integer)generalMap.get("searchRefNoId");
			}
			
			int empId = 0;
			if(generalMap.get("empId")!= null){
				empId = (Integer)generalMap.get("empId");
			}
			int lineManagerId = 0;
			if(generalMap.get("lineManagerId")!= null){
				lineManagerId = (Integer)generalMap.get("lineManagerId");
			}
			
			/*MasEmployee  mEmp = new MasEmployee();
			mEmp.setId(empId);
			int mngId = 0;
			mngId = mEmp.getLineManager().getId();*/
			
			Date fromDate = null;
			if(generalMap.get("fromDate")!= null){
				fromDate = (Date)generalMap.get("fromDate");
			}
			
			Date toDate = null;
			if(generalMap.get("toDate")!= null){
				toDate = (Date)generalMap.get("toDate");
			}
			Criteria crit = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "exp")
			.createAlias("exp.Trv", "trv").createAlias("trv.Emp", "emp")
			.setProjection(Projections.projectionList().add(Projections.property("trv.Id"))
			.add(Projections.property("trv.RefNo"))
			.add(Projections.property("trv.Jfdate"))
			.add(Projections.property("trv.Jtdate"))
			.add(Projections.sum("Amount"))
			.add(Projections.property("emp.FirstName"))
			.add(Projections.property("emp.LastName"))
			.add(Projections.sum("StandardAmount"))
			.add(Projections.property("trv.ExpClaimSts"))
			.add(Projections.property("exp.ApproveExpenseDate"))
			.add(Projections.property("exp.ApproveExpenseTime"))
					.add(Projections.groupProperty("trv.RefNo"))); 

			
			if(searchRefNoId != 0){
				crit = crit.add(Restrictions.eq("trv.Id", searchRefNoId));
			}
			
			if(empId !=0){
				crit =crit .add(Restrictions.eq("emp.Id", empId));
			}
			
			if(fromDate != null || toDate!= null ){
				crit = crit.add(Restrictions.gt("trv.Jfdate", fromDate)).add(Restrictions.lt("trv.Jtdate", toDate));
				
			}
			
			etrExpDetailList =crit.list(); 
			/*String qureyString = "SELECT etr.Etr_id,etr.RefNo,jfdate,jtdate,sum(eed.amount),mm.first_name,mm.last_name,sum(eed.standard_amount),etr.ExpClaimSts,ees.approve_expense_date,ees.approve_expense_time FROM etr_travelreq etr " +
			"right join etr_expsubmit ees on etr.Etr_id = ees.trv_id " +
			"right join etr_expdetails eed on ees.exp_id = eed.exp_id " + 
			"left join mas_employee mm on etr.Emp_id = mm.employee_id group by etr.RefNo ";
			etrExpDetailList = (List) session.createSQLQuery(qureyString).list();*/
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("LineManager.Id", lineManagerId)).list();
			//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).list();
			etrTravelRequestList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").createAlias("Emp.LineManager", "lManager").add(Restrictions.eq("lManager.Id", lineManagerId)).add(Restrictions.eq("ExpClaimSts", "Submitted")).list();
			map.put("etrExpDetailList", etrExpDetailList);
			map.put("employeeList", employeeList);
			map.put("etrTravelRequestList", etrTravelRequestList);
		return map;
	}
	public Map<String, Object> approveTravelExpensesClaim(int travelRequestId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EtrExpdetails> etrExpDetailList = new ArrayList<EtrExpdetails>();
		List<EtrExpsubmit> etrExpSubmitList = new ArrayList<EtrExpsubmit>();
		List<EtrFillbookeddtls> etrFillBookedDetailsList = new ArrayList<EtrFillbookeddtls>();
		List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
		List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MstrCode> mstrCodeForExpesnseTypeList = new ArrayList<MstrCode>();
		List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelReqListForAdvanceList = new ArrayList<EtrTravelreq>();
		List<EtrTravelreq> etrTravelReqListForEmpList = new ArrayList<EtrTravelreq>();
		
		Session session = (Session)getSession();
		//etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).add(Restrictions.eq("BookStatus","Booked")).list();
		masCityList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
		countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
		etrFillBookedDetailsList = session.createCriteria(EtrFillbookeddtls.class).createAlias("Trv", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
		mstrCodeForExpesnseTypeList = session.createCriteria(MstrCode.class).add(Restrictions.eq("CodeType", "ExpType")) .addOrder(Order.asc("CodeDesc")).add(Restrictions.eq("Status", "y")).list();
		int fillBookDetailId = 0;
		if(etrFillBookedDetailsList.size()>0){
			for(EtrFillbookeddtls etrFillbookeddtls :etrFillBookedDetailsList){
				fillBookDetailId = etrFillbookeddtls.getId();
			}
		}
		etrTicketDetailsList = session.createCriteria(EtrTicketdetails.class).createAlias("Fbdt", "fillBookDetail").add(Restrictions.eq("fillBookDetail.Id", fillBookDetailId)).list();
		currencyList = session.createCriteria(MasCurrency.class).add(Restrictions.eq("Status", "y")).list();
		etrExpSubmitList = session.createCriteria(EtrExpsubmit.class).createAlias("Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		int designationTypeId = 0;
		/*if(etrTicketDetailsList.size()>0){
			for(EtrTicketdetails etrTicketdetails:etrTicketDetailsList){
				designationTypeId = etrTicketdetails.getFbdt().getTrv().getEmp().getRank().getRankCategory().getId();
			}
		}*/
		etrTravelReqListForEmpList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		int employeeId = 0;
		if(etrTravelReqListForEmpList.size()>0){
			for(EtrTravelreq etrTravelreq1 :etrTravelReqListForEmpList){
				employeeId = etrTravelreq1.getEmp().getId();
				designationTypeId = etrTravelreq1.getEmp().getRank().getRankCategory().getId();
			}
		}
		etrExpDetailList = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "expSubmit").createAlias("expSubmit.Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		//standardAllowanceList = session.createCriteria(MstrStandardAllowance.class).createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", designationTypeId)).add(Restrictions.eq("Status", "y")).list();
		standardAllowanceList = session.createCriteria(MstrStandardAllowance.class).createAlias("Rank", "rank").createAlias("rank.RankCategory", "rankCategory").add(Restrictions.eq("rankCategory.Id", designationTypeId)).add(Restrictions.eq("Status", "y")).list();

		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		
		etrTravelReqListForAdvanceList = session.createCriteria(EtrTravelreq.class).createAlias("Emp", "emp").add(Restrictions.eq("emp.Id", employeeId)).list();
		map.put("etrExpDetailList", etrExpDetailList);
		map.put("etrExpSubmitList", etrExpSubmitList);
		map.put("countryList", countryList);
		map.put("employeeList", employeeList);
		map.put("masCityList", masCityList);
		map.put("mstrCodeForExpesnseTypeList", mstrCodeForExpesnseTypeList);
		map.put("currencyList", currencyList);
		map.put("departmentList", departmentList);
		map.put("etrTicketDetailsList", etrTicketDetailsList);
		map.put("standardAllowanceList", standardAllowanceList);
		map.put("etrTravelReqListForAdvanceList", etrTravelReqListForAdvanceList);
		map.put("etrTravelRequestList", etrTravelRequestList);
		//map.put("tempList", tempList);
		return map;
	}

	public Map<String, Object> saveStatusOfexpenseDetail(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> etrExpDetailList = new ArrayList<Object[]>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<EtrExpsubmit> etrExpeSubmitList = new ArrayList<EtrExpsubmit>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		List approvedAmountList = new ArrayList();
		List expDetailIdList = new ArrayList();
		List standardAmountList = new ArrayList();
		Session session = (Session)getSession();
		String approvalStatus = "";
		if(generalMap.get("approvalStatus")!= null){
			approvalStatus =(String)generalMap.get("approvalStatus");
		}
		if(generalMap.get("approvedAmountList")!= null){
			approvedAmountList =(List)generalMap.get("approvedAmountList");
		}
		if(generalMap.get("expDetailIdList")!= null){
			expDetailIdList =(List)generalMap.get("expDetailIdList");
		}
		if(generalMap.get("standardAmountList")!= null){
			standardAmountList =(List)generalMap.get("standardAmountList");
		}
		
		String remark = "";
		if(generalMap.get("remark")!= null){
			remark =(String)generalMap.get("remark");
		}
		int lineManagerId = 0;
		if(generalMap.get("lineManagerId")!= null){
			lineManagerId =(Integer)generalMap.get("lineManagerId");
		}
		int travelRequestId = 0;
		if(generalMap.get("travelRequestId")!= null){
			travelRequestId =(Integer)generalMap.get("travelRequestId");
		}
		int headeId = 0;
		if(generalMap.get("headeId")!= null){
			headeId =(Integer)generalMap.get("headeId");
		}
		String other = "";
		if(generalMap.get("other")!= null){
			other =(String)generalMap.get("other");
		}
		int expenseSubmitId = 0;
		if(generalMap.get("expenseSubmitId")!= null){
			expenseSubmitId =(Integer)generalMap.get("expenseSubmitId");
		}
		String emailMessage = "";
		Date fromDate = null;
		Date toDate = null;
		String refNo = "";
		String recipientAddresses = "";
		Date submitExpenseDate = null;
		 String titleName = "";
		 String lineManagerName = "";
		 String applicantName = "";
		 String ccAddress = "";
		 String fromAddress  = "";
		 String ccAddress1 = "";
		 int approverId = 0;
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
		if(etrTravelRequestList.size()>0){
			for(EtrTravelreq etrTravelreq1 :etrTravelRequestList){
				approverId = etrTravelreq1.getEmp().getLineManager().getId();
				recipientAddresses = etrTravelreq1.getEmp().getEmail();
				//recipientAddresses = "vishal.jain@jktech.com";
				fromAddress =etrTravelreq1.getEmp().getLineManager().getEmail(); 
				//fromAddress = "ritu.sahu@jktech.com";
				fromDate =etrTravelreq1.getJfdate();
				toDate = etrTravelreq1.getJtdate();
				refNo = etrTravelreq1.getRefNo();
				titleName = etrTravelreq1.getEmp().getTitle().getTitleName();
				applicantName = etrTravelreq1.getEmp().getFirstName()+" "+etrTravelreq1.getEmp().getMiddleName()+" "+etrTravelreq1.getEmp().getLastName();
				submitExpenseDate = etrTravelreq1.getSubmitExpenseDate();
				ccAddress = "adminhelp@clinirx.com";
				// ccAddress = "mhwani@clinirx.com";
			}
		}
		 emailMessage = "Dear "+ titleName + " " + applicantName+ ",\n";
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		EtrExpsubmit etrExpsubmit1 = (EtrExpsubmit)hbt.load(EtrExpsubmit.class, expenseSubmitId);
		etrExpsubmit1.setApproveExpenseDate(HMSUtil.convertStringTypeDateToDateType(date));
		etrExpsubmit1.setApproveExpenseTime(time);
		
		if(expDetailIdList.size()>0){
			for (int i = 0; i < expDetailIdList.size(); i++) {
				
				int expDetailId = Integer.parseInt(expDetailIdList.get(i).toString());
				EtrExpdetails etrExpdetails = (EtrExpdetails)hbt.load(EtrExpdetails.class, expDetailId);
				
				if(approvedAmountList.size()>0){
					if(approvedAmountList.get(i) != null){
						BigDecimal approvedExpenseAmount = new BigDecimal(approvedAmountList.get(i).toString());
						etrExpdetails.setApprovedExpenseAmount(approvedExpenseAmount);
					}
				}
					if(standardAmountList.size()>0){
					if(standardAmountList.get(i) != null){
						BigDecimal standardExpenseAmount = new BigDecimal(standardAmountList.get(i).toString());
						etrExpdetails.setStandardAmount(standardExpenseAmount);
					}
				}
				
				hbt.update(etrExpdetails);
			}
		}
		etrExpeSubmitList = session.createCriteria(EtrExpsubmit.class).createAlias("Trv", "travelId").add(Restrictions.eq("travelId.Id", travelRequestId)).list();
		Set<EtrTrvsubapptbl> etrTrvsubapptblSet = new HashSet<EtrTrvsubapptbl>();
		if(etrExpeSubmitList.size()>0){
			for(EtrExpsubmit etrExpsubmit :etrExpeSubmitList){
				etrTrvsubapptblSet = etrExpsubmit.getEtrTrvsubapptbls();
				
			}
		}
		
		int etrTrvsubapptblId = 0;
		if(etrTrvsubapptblSet.size()>0){
			for(EtrTrvsubapptbl etrTrvsubapptbl : etrTrvsubapptblSet){
				etrTrvsubapptblId = etrTrvsubapptbl.getAppr().getId();
			}
		}
		Date currentDate = new Date();
		
		
		EtrTravelreq etrTravelreq = (EtrTravelreq)hbt.load(EtrTravelreq.class, travelRequestId);
		if(approvalStatus.equals("approve")){
			etrTravelreq.setExpClaimSts("Approved");
			hbt.update(etrTravelreq);
			EtrTrvsubapptbl etrTrvsubapptbl = (EtrTrvsubapptbl)hbt.load(EtrTrvsubapptbl.class, etrTrvsubapptblId);
			etrTrvsubapptbl.setCmts(remark);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(approverId);
			etrTrvsubapptbl.setAppr(masEmployee);
			etrTrvsubapptbl.setApprSts("Approved");
			etrTrvsubapptbl.setApprDate(currentDate);
			emailMessage = emailMessage = emailMessage +" Your Travel Expense Claim for the Travel Request  "+refNo+", on Dt. "+
			HMSUtil.convertDateToStringWithoutTime(submitExpenseDate)+" for a travel "+HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
			"has been approved on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
			"For details of the same, kindly log in your omega account.\n\n\n\n"+
			"This is an auto generated mail through OMEGA. Do not reply.";
			//etrTrvsubapptbl.setApprTime(time);
			hbt.update(etrTrvsubapptbl);
		}else if(approvalStatus.equals("reject")){
			etrTravelreq.setExpClaimSts("Reject");
			hbt.update(etrTravelreq);
			EtrTrvsubapptbl etrTrvsubapptbl = (EtrTrvsubapptbl)hbt.load(EtrTrvsubapptbl.class, etrTrvsubapptblId);
			etrTrvsubapptbl.setCmts(remark);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(approverId);
			etrTrvsubapptbl.setAppr(masEmployee);
			etrTrvsubapptbl.setApprSts("Reject");
			etrTrvsubapptbl.setApprDate(currentDate);
			//etrTrvsubapptbl.setApprTime(time);
			hbt.update(etrTrvsubapptbl);
			emailMessage = emailMessage = emailMessage +" Your Travel Expense Claim for the Travel Request  "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(submitExpenseDate)+" for a travel "+
			HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
			"has been rejected on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
			"For details of the same, kindly log in your omega account.\n\n\n\n"+
			"This is an auto generated mail through OMEGA. Do not reply.";
			}else if(approvalStatus.equals("forward")){
				etrTravelreq.setExpClaimSts("Forward");
				hbt.update(etrTravelreq);
				EtrTrvsubapptbl etrTrvsubapptbl = (EtrTrvsubapptbl)hbt.load(EtrTrvsubapptbl.class, etrTrvsubapptblId);
				etrTrvsubapptbl.setCmts(remark);
				 if(other.equals("y")){
					 MasEmployee masEmployee1 = new MasEmployee();
					 masEmployee1.setId(headeId);
					 etrTrvsubapptbl.setAppr(masEmployee1);
				 }else if(other.equals("n")){
					 MasEmployee masEmployee2 = new MasEmployee();
					 masEmployee2.setId(lineManagerId);
					 etrTrvsubapptbl.setAppr(masEmployee2);
				 }
				
				etrTrvsubapptbl.setApprSts("Forward");
				etrTrvsubapptbl.setApprDate(currentDate);
				hbt.update(etrTrvsubapptbl);
				emailMessage = emailMessage = emailMessage +" Your Travel Expense Claim for the Travel Request  "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(submitExpenseDate)+" for a travel "+
				HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
				"has been forward on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
				"For details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
				//etrTrvsubapptbl.setApprTime(time);
				
		}	
		else if(approvalStatus.equals("forward")){
				etrTravelreq.setExpClaimSts("Forward");
				hbt.update(etrTravelreq);
				EtrTrvsubapptbl etrTrvsubapptbl = (EtrTrvsubapptbl)hbt.load(EtrTrvsubapptbl.class, etrTrvsubapptblId);
				etrTrvsubapptbl.setCmts(remark);
				 if(other.equals("y")){
					 MasEmployee masEmployee1 = new MasEmployee();
					 masEmployee1.setId(headeId);
					 etrTrvsubapptbl.setAppr(masEmployee1);
				 }else if(other.equals("n")){
					 MasEmployee masEmployee2 = new MasEmployee();
					 masEmployee2.setId(lineManagerId);
					 etrTrvsubapptbl.setAppr(masEmployee2);
				 }
				
				etrTrvsubapptbl.setApprSts("Forward");
				etrTrvsubapptbl.setApprDate(currentDate);
				hbt.update(etrTrvsubapptbl);
				emailMessage = emailMessage = emailMessage +" Your Travel Expense Claim for the Travel Request  "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(submitExpenseDate)+" for a travel "+
				HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
				"has been forward on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
				"For details of the same, kindly log in your omega account.\n\n\n\n"+
				"This is an auto generated mail through OMEGA. Do not reply.";
				//etrTrvsubapptbl.setApprTime(time);
				
		}	
		else if(approvalStatus.equalsIgnoreCase("sendBack")){
			etrTravelreq.setExpClaimSts("sendBack");
			hbt.update(etrTravelreq);
			EtrTrvsubapptbl etrTrvsubapptbl = (EtrTrvsubapptbl)hbt.load(EtrTrvsubapptbl.class, etrTrvsubapptblId);
			etrTrvsubapptbl.setCmts(remark);
			 if(other.equals("y")){
				 MasEmployee masEmployee1 = new MasEmployee();
				 masEmployee1.setId(headeId);
				 etrTrvsubapptbl.setAppr(masEmployee1);
			 }else if(other.equals("n")){
				 MasEmployee masEmployee2 = new MasEmployee();
				 masEmployee2.setId(lineManagerId);
				 etrTrvsubapptbl.setAppr(masEmployee2);
			 }
			
			etrTrvsubapptbl.setApprSts("sendBack");
			etrTrvsubapptbl.setApprDate(currentDate);
			hbt.update(etrTrvsubapptbl);
			emailMessage = emailMessage = emailMessage +" Your Travel Expense Claim for the Travel Request  "+refNo+", on Dt. "+HMSUtil.convertDateToStringWithoutTime(submitExpenseDate)+" for a travel "+
			HMSUtil.convertDateToStringWithoutTime(fromDate)+" to "+HMSUtil.convertDateToStringWithoutTime(toDate)+".\n" +
			"has been Send Back on "+HMSUtil.convertDateToStringWithoutTime(currentDate)+".\n"+
			"For details of the same, kindly log in your omega account.\n\n\n\n"+
			"This is an auto generated mail through OMEGA. Do not reply.";
			//etrTrvsubapptbl.setApprTime(time);
			
	}	
		Criteria crit = session.createCriteria(EtrExpdetails.class).createAlias("Exp", "exp").createAlias("exp.Trv", "trv")
			.createAlias("trv.Emp", "emp").add(Restrictions.eq("emp.LineManager.Id", approverId))
			.setProjection(Projections.projectionList().add(Projections.property("trv.Id"))
			.add(Projections.property("trv.RefNo"))
			.add(Projections.property("trv.Jfdate"))
			.add(Projections.property("trv.Jtdate"))
			.add(Projections.sum("Amount"))
			.add(Projections.property("emp.FirstName"))
			.add(Projections.property("emp.LastName"))
			.add(Projections.sum("StandardAmount"))
			.add(Projections.property("trv.ExpClaimSts"))
			.add(Projections.property("exp.ApproveExpenseDate"))
			.add(Projections.property("exp.ApproveExpenseTime"))
			.add(Projections.property("trv.SubmitExpenseDate"))
			.add(Projections.property("trv.SubmitExpenseTime"))
			.add(Projections.property("exp.ExpenseSettlementDate"))
			.add(Projections.property("exp.ExpenseSettlementTime"))
					.add(Projections.groupProperty("trv.RefNo"))); 
		
			
			etrExpDetailList =crit.addOrder(Order.desc("trv.Jfdate")).list(); 
			List<String> recipientAddressesList = new ArrayList<String>();
			List<String> ccAddressesList = new ArrayList<String>();
			List<String> bccAddresses = new ArrayList<String>();
			
				String subject = "Travel Appproval";
			 
				 ccAddress1 = "adminhelp@clinirx.com";
			//	 ccAddress1 = "mhwani@clinirx.com";
			    String ccAddress2 = "accountshelp@clinirx.com";
		    //    String ccAddress2 = "mhwani@clinirx.com";
					ccAddressesList.add(ccAddress);
					ccAddressesList.add(ccAddress1);
					ccAddressesList.add(ccAddress2);
				recipientAddressesList.add(recipientAddresses);
			boolean sent=false;
			if(recipientAddresses != null  && !recipientAddresses.equals("") && ccAddress != null && !ccAddress.equals("")){
				LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddressesList, fromAddress, ccAddressesList , bccAddresses ,emailMessage, subject);
			}
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			map.put("etrTravelRequestList", etrTravelRequestList);
			map.put("etrExpDetailList", etrExpDetailList);
			map.put("departmentList", departmentList);
		return map;
	}

   public Map<String, Object> showMyTravelReport(Map<String, Object> generalMap){
	   Map<String, Object> map = new HashMap<String, Object>();
	   List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	   List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	   List<MstrProject>   projectList = new ArrayList<MstrProject>();
	   Session session = (Session) getSession();
	   projectList = session.createCriteria(MstrProject.class).list();
	   employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
	   departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
	   map.put("employeeList", employeeList);
	   map.put("projectList", projectList);
	   map.put("departmentList", departmentList);
	   return map;
   }
   public Map<String, Object> getProjectFromAjax(Map<String, Object> generalMap) {
	   Map<String, Object> map = new HashMap<String, Object>();
	   List<MstrProject> projectList = new ArrayList<MstrProject>();
	   int employeeId = 0;
	   if(generalMap.get("employeeId")!= null){
		   employeeId =(Integer)generalMap.get("employeeId");
	   }
	   Session session = (Session) getSession();
	   Criteria crit = session.createCriteria(PrjRoleResMappingHeader.class).createAlias("Employee", "eid").add(Restrictions.eq("eid.Id", employeeId)).createAlias("Prj", "prj_staus").createAlias("prj_staus.ProjectStatus","st").add(Restrictions.eq("st.Id", 1));
		crit.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("Prj"))));
		projectList = crit.list();
		map.put("projectList", projectList);
		return map;
	}

   public Map<String, Object> showEmployeeTravelReport(Map<String, Object> generalMap){
	   Map<String, Object> map = new HashMap<String, Object>();
	   List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	   List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	   List<MstrProject>   projectList = new ArrayList<MstrProject>();
	   Session session = (Session) getSession();
	   projectList = session.createCriteria(MstrProject.class).list();
	   employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
	   departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
	   map.put("employeeList", employeeList);
	   map.put("projectList", projectList);
	   map.put("departmentList", departmentList);
	   return map;
   }
	
   public Map<String, Object> showDepartmentTravelReport(Map<String, Object> generalMap){
	   Map<String, Object> map = new HashMap<String, Object>();
	   //List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	   List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	   //List<MstrProject>   projectList = new ArrayList<MstrProject>();
	   Session session = (Session) getSession();
	   departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
	   map.put("departmentList", departmentList);
	   return map;
   }
   
   public Map<String, Object> showDepartmentWiseTotalTravel(Map<String, Object> generaMap){
	   Map<String, Object> map = new HashMap<String, Object>();
	   List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	   Session session = (Session) getSession();
	   departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
	   map.put("departmentList", departmentList);
	   return map;
	   
   }
       
   public Map<String, Object> showProjectWiseTravelReport(Map<String, Object> generalMap){
	   Map<String, Object> map = new HashMap<String, Object>();
	   List<MstrProject> projectList = new ArrayList<MstrProject>();
	   Session session = (Session)getSession();
	   projectList = session.createCriteria(MstrProject.class).list();
	   map.put("projectList", projectList);
	   return map;
   }
   
   
	public Map<String, Object> showTotalTravelCostReport(Map<String, Object> generalMap){
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	   }
	public Map<String, Object> showEmployeeWiseTravelCost(Map<String, Object> generalMap){
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		return map;

	}

	public Map<String, Object> showEmployeeExpenseReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MstrProject> projectList = new ArrayList<MstrProject>();
		Session session = (Session)getSession();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		projectList = session.createCriteria(MstrProject.class).list();
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("projectList", projectList);
		return map;
	}

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
	

	
   
}
