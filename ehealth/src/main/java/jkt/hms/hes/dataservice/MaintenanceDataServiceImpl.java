package jkt.hms.hes.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.HesEquipmentAmcDetailsEntry;
import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.Hospital;
import jkt.hms.masters.business.HrEmployeeDeputation;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasPriorityCodes;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierType;
import jkt.hms.masters.business.MmAuctionParticipent;
import jkt.hms.masters.business.MmCondemnationCommitee;
import jkt.hms.masters.business.MmCondemnationCommiteeMembers;
import jkt.hms.masters.business.MmInspectionReport;
import jkt.hms.masters.business.MmMasRequestStatus;
import jkt.hms.masters.business.MmPreventiveCheckList;
import jkt.hms.masters.business.MmPreventiveCheckListDetails;
import jkt.hms.masters.business.MmRequestConfig;
import jkt.hms.masters.business.MmSafetyProcedureMaterials;
import jkt.hms.masters.business.MmServiceRequest;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.EtrTravelreq;
import jkt.hrms.masters.business.MasInstitute;
import jkt.hrms.masters.business.TempTickattach;

import org.apache.derby.tools.sysinfo;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Join;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class MaintenanceDataServiceImpl extends HibernateDaoSupport implements MaintenanceDataService{

	@Override
	public Map<String, Object> getDepartment(int hospitalId) {
		Map<String,Object> map=new HashMap<String,Object>();
		Session session = (Session) getSession();
//		List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
		List<MasInstituteDepartment> masInstituteDepartments=new ArrayList<MasInstituteDepartment>();
//		Criteria criteria = session.createCriteria(MasDepartment.class).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("DepartmentName"));
		masInstituteDepartments=session.createCriteria(MasInstituteDepartment.class, "mid").createAlias("mid.Institute", "h").createAlias("mid.Department", "d").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("d.DepartmentName")).list();
//		departmentList=criteria.list();
		map.put("departmentList", masInstituteDepartments);
		return map;
	}
	
	@Override
	public List<HesEquipmentMaster> getEquipmentList(Map<String, Object> details) {
		List<HesEquipmentMaster> list=new ArrayList<HesEquipmentMaster>();
		Session session = (Session) getSession();
		int departmentId = 0;
		int hospitalId = 0;
		if(details!=null){
			departmentId=(Integer)details.get("departmentId");
			hospitalId=(Integer)details.get("hospitalId");
		}
		Criteria criteria= session.createCriteria(HesEquipmentMaster.class).createAlias("Hospital", "h").createAlias("Department", "d").add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("d.Id", departmentId));
		list=criteria.list();
		return list;
	}
	//----   For Equipment Details  ------------
	public List<HesEquipmentMaster> getEquipment(Map<String, Object> details){
		Session session=(Session)getSession();
		List<HesEquipmentMaster> hesEquipmentMasters=new ArrayList<HesEquipmentMaster>();
		Criteria criteria=session.createCriteria(HesEquipmentMaster.class, "em")
				.createAlias("em.Hospital", "h")
				.createAlias("em.Department", "d")
				.createAlias("em.Item", "i")
				.createAlias("em.Manufacturer", "m", CriteriaSpecification.LEFT_JOIN)
				.createAlias("em.GrnT", "g", CriteriaSpecification.LEFT_JOIN);
		if(details.get("hospitalId")!=null){
			criteria=criteria.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
		}
		if(details.get("department")!=null){
			criteria=criteria.add(Restrictions.eq("d.Id", (Integer.parseInt(""+details.get("department")))));
		}
		if(details.get("itemType")!=null){
			criteria=criteria.createAlias("i.ItemType", "it").add(Restrictions.eq("it.Id", (Integer.parseInt(""+details.get("itemType")))));
		}
		if(details.get("section")!=null){
			criteria=criteria.createAlias("i.Section", "s").add(Restrictions.eq("s.Id", (Integer.parseInt(""+details.get("section")))));
		}
		if(details.get("category")!=null){
			criteria=criteria.createAlias("i.ItemCategory", "ic").add(Restrictions.eq("ic.Id", (Integer.parseInt(""+details.get("category")))));
		}
		if(details.get("class")!=null){
			criteria=criteria.createAlias("i.ItemClass", "icl").add(Restrictions.eq("icl.Id", (Integer.parseInt(""+details.get("class")))));
		}
		if(details.get("requestId")!=null){
			criteria=criteria.add(Restrictions.eq("em.Id", (Integer.parseInt(""+details.get("requestId")))));
		}
		if(details.get("equipmentId")!=null){
			criteria=criteria.add(Restrictions.eq("em.Id", (Integer.parseInt(""+details.get("equipmentId")))));
		}
		hesEquipmentMasters = criteria.addOrder(Order.asc("i.Nomenclature")).createAlias("em.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.or(Restrictions.isNull("em.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD"))).list();
		return hesEquipmentMasters;
	}
	
	//-------- Service Request
	public List<MmServiceRequest> getServiceRequestDetails(Map<String, Object> details, Integer[] status){
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=null;
		Date toDate=null;
		Session session= (Session)getSession();
		Criteria criteria=session.createCriteria(MmServiceRequest.class, "sr")
				.createAlias("sr.Equipment", "e")
				.createAlias("sr.RequestStatus", "rs")
				.createAlias("sr.Hospital", "h");
		if(details.get("equipmentId")!=null)
				criteria=criteria.add(Restrictions.eq("e.Id", Integer.parseInt((String)details.get("equipmentId"))));
		if(status!=null)
			criteria=criteria.add(Restrictions.in("rs.Id", status));
		if(details.get("hospitalId")!=null){
			criteria=criteria.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
		}
		if(details.get("requestId")!=null){
			criteria=criteria.add(Restrictions.eq("sr.Id", (Integer)details.get("requestId")));
		}
		if(details.get("fromDate")!=null && details.get("toDate")!=null){
			try{
				fromDate=sdf.parse((String)details.get("fromDate"));
				toDate=sdf.parse((String)details.get("toDate"));
			}catch(Exception e){e.printStackTrace();}
			criteria=criteria.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
		}
		mmServiceRequests = criteria.list();
		return mmServiceRequests;
	}
	public List<MmServiceRequest> getServiceRequestDetails(Map<String, Object> details, List<Integer> status){
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=null;
		Date toDate=null;
		Session session= (Session)getSession();
		Criteria criteria=session.createCriteria(MmServiceRequest.class, "sr")
				.createAlias("sr.Equipment", "e")
				.createAlias("sr.RequestStatus", "rs")
				.createAlias("sr.Hospital", "h")
				.createAlias("sr.LastChgBy", "u");
		if(details.get("equipmentId")!=null)
				criteria=criteria.add(Restrictions.eq("e.Id", Integer.parseInt((String)details.get("equipmentId"))));
		if(status!=null)
			criteria=criteria.add(Restrictions.in("rs.Id", status));
		if(details.get("hospitalId")!=null){
			criteria=criteria.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
		}
		if(details.get("requestId")!=null){
			criteria=criteria.add(Restrictions.eq("sr.Id", (Integer)details.get("requestId")));
		}
		if(details.get("fromDate")!=null && details.get("toDate")!=null){
			try{
				fromDate=sdf.parse((String)details.get("fromDate"));
				toDate=sdf.parse((String)details.get("toDate"));
			}catch(Exception e){e.printStackTrace();}
			criteria=criteria.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
		}
//		if(details.get("userId")!=null){
//			criteria=criteria.add(Restrictions.eq("u.Id", (Integer)details.get("userId")));
//		}
		mmServiceRequests = criteria.createAlias("e.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN).add(Restrictions.or(Restrictions.isNull("e.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD"))).list();
		return mmServiceRequests;
	}
	//---------------      AMC Details
	public List<HesEquipmentAmcDetailsEntry> getAMCDetails(Map<String, Object> details){
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		Session session= (Session)getSession();
		Criteria criteria=session.createCriteria(HesEquipmentAmcDetailsEntry.class, "sr")
				.createAlias("sr.Epuipment", "e");
		if(details.get("equipmentId")!=null)
				criteria=criteria.add(Restrictions.eq("e.Id", Integer.parseInt((String)details.get("equipmentId"))));
		if(details.get("requestId")!=null)
			criteria=criteria.add(Restrictions.eq("e.Id", Integer.parseInt((String)details.get("requestId"))));
		hesEquipmentAmcDetailsEntry = criteria.addOrder(Order.desc("sr.Id")).list();
		return hesEquipmentAmcDetailsEntry;
	}
	@Override
	public Map<String, Object> getEquipmentDetail(Map<String, Object> details) {
		Map<String,Object> map=new HashMap<String,Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		MmServiceRequest reRequest=new MmServiceRequest();
		List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
		List<MasItemType> masItemTypes=new ArrayList<MasItemType>();
		List<MasItemClass> masItemClass=new ArrayList<MasItemClass>();
		List<MasItemCategory> masCategories=new ArrayList<MasItemCategory>();
		List<MasStoreSection> masStoreSection=new ArrayList<MasStoreSection>();
		List<MasPriorityCodes> masPriorityCodes=new ArrayList<MasPriorityCodes>();
		List<MmServiceRequest> masServiceRequests=new ArrayList<MmServiceRequest>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
//		String[] statusCode={"PN", "AP", "ATE", "UO", "SC", "WO", "TA", "CA", "WOC", "SOC", "SOCL", "RAS", "SCH", "OH"};
		String[] priorityCode=null;
		String[] statusCode = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("create.request.list").split("#");
			priorityCode = prop.getProperty("priority.code.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
//		Integer[] status={1,2,3,4,7,8,9,11,13,14,15,16,17,18};
//		String[] priorityCode={"NOR", "URG", "CRT"};
		List<Integer> priority=getMaintenancePriorityId(getMaintenancePriorityCode(priorityCode));
		if(details.get("requestId")!=null){
			Map<String, Object> rquestDetail=new HashMap<String, Object>();
			rquestDetail.put("equipmentId", details.get("requestId"));
			masServiceRequests=getServiceRequestDetails(rquestDetail, status);
			hesEquipmentAmcDetailsEntry = getAMCDetails(rquestDetail);
		}
		if(details.get("department")!=null || details.get("requestId")!=null){
			hesEquipmentMaster=getEquipment(details);
		}
		masItemTypes=session.createCriteria(MasItemType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemTypeName")).list();
		masItemClass=session.createCriteria(MasItemClass.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemClassName")).list();
		masCategories=session.createCriteria(MasItemCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemCategoryName")).list();
		masStoreSection=session.createCriteria(MasStoreSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();
		masPriorityCodes=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).add(Restrictions.in("Id", priority)).addOrder(Order.asc("CodesName")).list();
		if(details.get("serviceRequestId")!=null){
			reRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, Integer.parseInt((String)details.get("serviceRequestId")));
		}
		map.put("masItemTypes", masItemTypes);
		map.put("masItemClass", masItemClass);
		map.put("masCategories", masCategories);
		map.put("masStoreSection", masStoreSection);
		map.put("hesEquipmentMaster", hesEquipmentMaster);
		map.put("priority", masPriorityCodes);
		map.put("masServiceRequests", masServiceRequests);
		map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
		map.put("reRequest", reRequest);
		return map;
	}
	
	@Override
	public Map<String, Object> saveServiceDetails(Map<String, Object> details) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Session session=(Session)getSession();
		Map<String, Object> map=new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
		MasPriorityCodes masPriorityCodes=new MasPriorityCodes();
		MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
		HesEquipmentAmcDetailsEntry hesEquipmentAmcDetailsEntry=new HesEquipmentAmcDetailsEntry();
		Users user=new Users();
		MasHospital masHospital=new MasHospital();
		Date cd=new Date();
		Date requiredDate=null;
		Date lastChangeDate=null;
		int i=0;
		Transaction tx=null;
		String msg="";
		try{
			tx=session.beginTransaction();
				if(details.get("serviceRequestId")!=null){
					mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, Integer.parseInt((String)details.get("serviceRequestId")));
				}
				if(details.get("RequestType")!=null)
					mmServiceRequest.setRequestType((String)details.get("RequestType"));
				if(details.get("equipmentId")!=null){
					hesEquipmentMaster.setId(Integer.parseInt((String)details.get("equipmentId")));
					mmServiceRequest.setEquipment(hesEquipmentMaster);
				}
				if(details.get("requestType")!=null)
					mmServiceRequest.setRequestType((String)details.get("requestType"));
				if(details.get("priority")!=null){
					List<MasPriorityCodes> preorityCode=new ArrayList<MasPriorityCodes>();
					String[] data={(String)details.get("priority")};
					preorityCode=getMaintenancePriorityCode(data);
					masPriorityCodes.setId(preorityCode.get(0).getId());
					mmServiceRequest.setPriority(masPriorityCodes);
				}
				if(details.get("requiredDate")!=null){
					try{
						requiredDate=sdf.parse((String)details.get("requiredDate"));
					}catch(Exception e){e.printStackTrace();}
					mmServiceRequest.setRequiredDate(requiredDate);;
				}
				if(details.get("description")!=null)
					mmServiceRequest.setDescription((String)details.get("description"));
				if(details.get("userId")!=null){
					user.setId((Integer)details.get("userId"));
					mmServiceRequest.setLastChgBy(user);
				}
				if(details.get("hospitalId")!=null){
					masHospital.setId((Integer)details.get("hospitalId"));
					mmServiceRequest.setHospital(masHospital);
				}
				if(details.get("lastChgDate")!=null){
					try{
						lastChangeDate=sdf.parse((String)details.get("lastChgDate"));
					}catch(Exception e){e.printStackTrace();}
					mmServiceRequest.setLastChgDate(lastChangeDate);
					mmServiceRequest.setRequestDate(lastChangeDate);
				}
				if(details.get("amcId")!=null){
					hesEquipmentAmcDetailsEntry.setId(Integer.parseInt((String)details.get("amcId")));
					mmServiceRequest.setAmc(hesEquipmentAmcDetailsEntry);
				}
				if(details.get("warranty")!=null){
					mmServiceRequest.setWarrentyStatus((String)details.get("warranty"));
					if(!details.get("warranty").toString().equalsIgnoreCase("None")){
						masRequestStatus.setId(2);
					}else{
						masRequestStatus.setId(1);
					}
				}
				
				mmServiceRequest.setRequestStatus(masRequestStatus);
				if(details.get("lastChgTime")!=null){
					mmServiceRequest.setLastChgTime((String)details.get("lastChgTime"));
					mmServiceRequest.setRequestTime((String)details.get("lastChgTime"));
				}
				if(details.get("serviceRequestId")==null){
					Integer requestNo=(Integer)hbt.save(mmServiceRequest);
					hbt.flush();
					hbt.clear();
					String requestId="RID"+requestNo+"/"+details.get("lastChgDate");
					mmServiceRequest.setServiceRequestNo(requestId);
				}
				hbt.update(mmServiceRequest);
				//-------SMS and mail Alert Start---
				String warrantyStatus=(String)details.get("warrantyStatus");
				if(details.get("sms")!=null && details.get("sms")=="y"){
					if(warrantyStatus.equalsIgnoreCase("warranty")){
						OneToOne oneToOne=new OneToOne();
						String sms="Department of "+hesEquipmentMaster.getDepartment().getDepartmentName()+" the equipment request Number "+mmServiceRequest.getServiceRequestNo()+" - "+hesEquipmentMaster.getItem().getNomenclature()+" is under maintenance kindly attend to the same immediately";
						String mobileNumber=hesEquipmentMaster.getGrnT().getGrnMaster().getSupplier().getMobileNo();
						System.out.println(mobileNumber+"==="+sms);
						if(mobileNumber!=null){
							oneToOne.setMobileNo(mobileNumber);
							oneToOne.setMessage(sms);
							oneToOne.setStatus("U");
							oneToOne.setType("T");
							oneToOne.setSentTime((String)details.get("lastChgTime"));
							oneToOne.setSentDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("lastChgDate")));
							oneToOne.setHospital(masHospital);
							hbt.save(oneToOne);
						}
					}
				}
				if(details.get("mail")!=null && details.get("mail")=="y"){
					
				}
				//-------SMS and mail Alert End---
				hbt.flush();
				hbt.clear();
				tx.commit();
				msg="<span style='color: green'>Request Created Successfully. Request Number: "+mmServiceRequest.getServiceRequestNo()+".</span>";
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			msg="<span style='color: red'>Try Again.</span>";
		}
		map.put("msg",msg);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getEquipmentHistory(Map<String, Object> details) {
		Session session=(Session)getSession();
		Map<String, Object> map=new HashMap<String, Object>();
		List<HesEquipmentMaster> equipmentMaster=new ArrayList<HesEquipmentMaster>();
		List<MmServiceRequest> serviceDetail = new ArrayList<MmServiceRequest>(); 
		Criteria cr=session.createCriteria(HesEquipmentMaster.class).add(Restrictions.eq("Id", (Integer)details.get("eqId")));
		equipmentMaster=cr.list();
		serviceDetail=session.createCriteria(MmServiceRequest.class,"sr").createAlias("sr.Equipment", "e")
				.createAlias("sr.Hospital", "h")
				.add(Restrictions.eq("e.Id", (Integer)details.get("eqId"))).add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")))
				.addOrder(Order.desc("RequestDate")).list();
		map.put("equipmentMaster", equipmentMaster);
		map.put("serviceDetail", serviceDetail);
		return map;
	}
	
	@Override
	public Map<String, Object> getPendingServiceRequest(
			Map<String, Object> details) {
		Session session=(Session)getSession();
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
		List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		if(details.get("hospitalId")!=null){
			hospitalId=Integer.parseInt(details.get("hospitalId").toString());
		}
		Criteria cr=session.createCriteria(MmServiceRequest.class,"sr")
				.createAlias("sr.Equipment", "em")
				.createAlias("sr.RequestStatus", "rs")
				.createAlias("em.Hospital", "h")
				.createAlias("sr.Priority", "pr")
				.createAlias("em.Department", "d")
				.createAlias("sr.LastChgBy", "u")
				//.setProjection(Projections.projectionList().add(Projections.property("sr.Id")).add(Projections.property("sr.RequestDate")).add(Projections.property("sr.ServiceRequestNo")).add(Projections.property("em.EntryNo")).add(Projections.property("em.EquipmentName")).add(Projections.property("pr.CodesName")).add(Projections.property("u.UserName")).add(Projections.property("d.DepartmentName")).add(Projections.property("rs.StatusName")))
				.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("rs.StatusCode", "PN"));
		if(details.get("fromDate")!=null && details.get("fromDate")!="" && details.get("toDate")!=null && details.get("toDate")!=""){
			try{
			fromDate=sdf.parse(details.get("fromDate").toString());
			toDate=sdf.parse(details.get("toDate").toString());
			}catch(Exception e){e.printStackTrace();}
			cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
		}
		if(details.get("requestId")!=null && details.get("requestId")!=""){
			cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", details.get("requestId")));
		}
		if(details.get("itemCode")!=null && details.get("itemCode")!=""){
			cr=cr.add(Restrictions.eq("em.EntryNo", details.get("itemCode")));
		}
		if(details.get("priority")!=null && details.get("priority")!=""){
			cr=cr.add(Restrictions.eq("pr.Id", Integer.parseInt(details.get("priority").toString())));
		}
//		if(details.get("user")!=null && details.get("user")!=""){
//			cr=cr.add(Restrictions.eq("u.Id", (Integer)details.get("user")));
//		}
		
		mmServiceRequest=cr.list();
		priority=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).list();
		map.put("mmServiceRequest", mmServiceRequest);
		map.put("priority", priority);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getRequestDetails(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> serviceDetail=new ArrayList<MmServiceRequest>();
		List<HesEquipmentMaster> hesEquipmentMasters=new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		List<MmMasRequestStatus> status=new ArrayList<MmMasRequestStatus>();
		List<MasInstituteDepartment> department=new ArrayList<MasInstituteDepartment>();
		String[] statusCode = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("service.request.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Session session=(Session)getSession();
		serviceDetail=session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Id", Integer.parseInt(details.get("requestId").toString()))).list();
		status=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.in("StatusCode", statusCode)).list();
		department=session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "dt").createAlias("Hospital", "h")
				.addOrder(Order.asc("DepartmentName")).add(Restrictions.eq("dt.DepartmentTypeCode", "MNT").ignoreCase()).add(Restrictions.eq("h.Id", Integer.parseInt(details.get("hospitalId").toString()))).list();
		department = session.createCriteria(MasInstituteDepartment.class).createAlias("Department", "dept")
										.createAlias("dept.DepartmentType", "dt").createAlias("Institute", "h").addOrder(Order.asc("dept.DepartmentName"))
										.add(Restrictions.eq("dt.DepartmentTypeCode", "MNT").ignoreCase())
										.add(Restrictions.eq("h.Id", Integer.parseInt(details.get("hospitalId").toString()))).list();

		Map<String, Object> data=new HashMap<String, Object>();
		data.put("equipmentId", serviceDetail.get(0).getEquipment().getId().toString());
		hesEquipmentMasters=getEquipment(data);
		hesEquipmentAmcDetailsEntry=getAMCDetails(data);
		map.put("department", department);
		map.put("serviceDetail", serviceDetail);
		map.put("status", status);
		map.put("hesEquipmentMaster", hesEquipmentMasters);
		map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
		return map;
	}
	
	@Override
	public Map<String, Object> saveServiceRequest(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		MmMasRequestStatus status=new MmMasRequestStatus();
		MasDepartment department=new MasDepartment();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Session session =(Session)getSession();
		Date currentDate=new Date();
		Users users=new Users();
		String msg="";
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
		MmServiceRequest mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, (Integer.parseInt((String)details.get("requestId"))));
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		String[] data={(String)details.get("status")};
		mmMasRequestStatus=getMaintenanceStatus(data);
		status.setId(mmMasRequestStatus.get(0).getId());
		mmServiceRequest.setRequestStatus(status);
		if(!details.get("forwardTo").equals("")){
		department.setId(Integer.parseInt((String)details.get("forwardTo")));
		mmServiceRequest.setForwardDepartment(department);
		}
		if(!details.get("Remark").equals(""))
		mmServiceRequest.setRemarks((String)details.get("Remark"));
		users.setId((Integer)details.get("approvedBy"));
		mmServiceRequest.setApprovedBy(users);
		mmServiceRequest.setApprovedDate(currentDate);
		hbt.update(mmServiceRequest);
		hbt.flush();
		hbt.clear();
		tx.commit();
		msg="<span style='color: green'>Successfully Saved.</span>";
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			msg="<span style='color: red'>Try Again.</span>";
		}
		
		map.put("msg", msg);
		return map;
	}
	
	@Override
	public Map<String, Object> getPendingListOfInspection(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
		List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
//		Integer[] status={2,16};
		String[] statusCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			if(prop.getProperty("pending.list.inspection.status")!=null)
			statusCode = prop.getProperty("pending.list.inspection.status").split("#");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(details.get("hospitalId")!=null && details.get("hospitalId")!=""){
			hospitalId=(Integer)details.get("hospitalId");
		}
		Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h").createAlias("sr.RequestStatus", "rs")
				.createAlias("sr.Priority", "pr").createAlias("sr.Equipment", "em").createAlias("em.Department", "de")
				.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("RequestDate"));
		System.out.println("statusCode=="+statusCode.toString());
		if(statusCode!=null){
			cr=cr.add(Restrictions.in("rs.StatusCode", statusCode));
		}
		if(details.get("fromDate")!=null && details.get("fromDate")!="" && details.get("toDate")!=null && details.get("toDate")!=""){
			try{
			fromDate=sdf.parse(details.get("fromDate").toString());
			toDate=sdf.parse(details.get("toDate").toString());
			}catch(Exception e){e.printStackTrace();}
			cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
		}
		if(details.get("requestId")!=null && details.get("requestId")!=""){
			cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", details.get("requestId")));
		}
		if(details.get("itemCode")!=null && details.get("itemCode")!=""){
			cr=cr.add(Restrictions.eq("em.EntryNo", details.get("itemCode")));
		}
		if(details.get("priority")!=null && details.get("priority")!=""){
			cr=cr.add(Restrictions.eq("pr.Id", Integer.parseInt(details.get("priority").toString())));
		}
		if(details.get("RequestedFrom")!=null && details.get("RequestedFrom")!=""){
			cr=cr.add(Restrictions.eq("de.Id", Integer.parseInt(details.get("RequestedFrom").toString())));
		}
		mmServiceRequests=cr.list();
		priority=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).list();
		departmentList=session.createCriteria(MasDepartment.class,"d").createAlias("d.Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("d.DepartmentName")).list();
		map.put("mmServiceRequests", mmServiceRequests);
		map.put("priority", priority);
		map.put("departmentList", departmentList);
		return map;
	}
	@Override
	public Map<String, Object> getAssignResource(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		List<MasPriorityCodes> masPriorityCodes=new ArrayList<MasPriorityCodes>();
		Map<String, Object> data=new HashMap<String, Object>();
		
		Session session=(Session)getSession();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<MasDepartment> masDepartment=new ArrayList<MasDepartment>();
		List<MasInstituteDepartment> masInstituteDepartments=new ArrayList<MasInstituteDepartment>();
		
		mmServiceRequests=session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Id", Integer.parseInt(details.get("requestId").toString()))).list();
		masDepartment=session.createCriteria(MasDepartment.class, "d").createAlias("d.Hospital", "h").addOrder(Order.asc("DepartmentName")).add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId"))).list();
		masPriorityCodes=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "r").ignoreCase()).list();
		masInstituteDepartments=session.createCriteria(MasInstituteDepartment.class, "mid").createAlias("mid.Institute", "h").createAlias("mid.Department", "d").add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId"))).addOrder(Order.asc("d.DepartmentName")).list();
		data.put("equipmentId", mmServiceRequests.get(0).getEquipment().getId().toString());
		
		hesEquipmentMaster=getEquipment(data);
		hesEquipmentAmcDetailsEntry=getAMCDetails(data);
		map.put("mmServiceRequests", mmServiceRequests);
		map.put("masDepartment", masDepartment);
		map.put("hesEquipmentMaster", hesEquipmentMaster);
		map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
		map.put("masInstituteDepartments", masInstituteDepartments);
		map.put("masPriorityCodes", masPriorityCodes);
		return map;
	}
	
	@Override
	public Map<String, Object> showRequestTrackerConfig(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<MmRequestConfig> mmRequestConfigs=new ArrayList<MmRequestConfig>();
		List<MasInstituteDepartment> masInstituteDepartments=new ArrayList<MasInstituteDepartment>();
		masInstituteDepartments=session.createCriteria(MasInstituteDepartment.class, "mid").createAlias("mid.Institute", "h").createAlias("mid.Department", "d").add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId"))).addOrder(Order.asc("d.DepartmentName")).list();
		mmRequestConfigs=session.createCriteria(MmRequestConfig.class,"rc").createAlias("rc.Hospital", "h").add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId"))).list();
		map.put("masInstituteDepartments", masInstituteDepartments);
		map.put("mmRequestConfigs", mmRequestConfigs);
		return map;
	}
	
	@Override
	public Map<String, Object> addConfig(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		MmRequestConfig mmRequestConfig=new MmRequestConfig();
		MasEmployee masEmployee=new MasEmployee();
		MasDepartment masDepartment=new MasDepartment();
		MasHospital masHospital=new MasHospital();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		Transaction tx=null;
		String msg="";
		try{
			tx=session.beginTransaction();
			if(details.get("configId")!=null){
				mmRequestConfig=(MmRequestConfig)hbt.get(MmRequestConfig.class, (Integer)details.get("configId"));
			}
			masEmployee.setId((Integer)details.get("employeeId"));
			mmRequestConfig.setEmployee(masEmployee);
			masDepartment.setId((Integer)details.get("departmentId"));
			mmRequestConfig.setDepartment(masDepartment);
			masHospital.setId((Integer)details.get("hospitalId"));
			mmRequestConfig.setHospital(masHospital);
			mmRequestConfig.setDesignationLevel((Integer)details.get("designationLabel"));
			mmRequestConfig.setFromDay((Integer)details.get("fromDay"));
			mmRequestConfig.setToDay((Integer)details.get("toDay"));
			mmRequestConfig.setStatus("y");
			mmRequestConfig.setLastChgBy(new Users((Integer)details.get("userId")));
			mmRequestConfig.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("lastChgDate")));
			mmRequestConfig.setLastChgTime((String)details.get("lastChgTime"));
			hbt.saveOrUpdate(mmRequestConfig);
			hbt.flush();
			hbt.clear();
			tx.commit();
			msg="<span>Successfully Save.</span>";
		}catch (Exception ex){
			if(tx==null){
				msg="<span>Try Again!</span>";
			}
			ex.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@Override
	public Map<String, Object> getResourceList(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
//		List<UserDepartment> userList=new ArrayList<UserDepartment>();
		List<EmpScMapping> empScMappings=new ArrayList<EmpScMapping>();
		empScMappings=session.createCriteria(EmpScMapping.class,"esm")
				.createAlias("esm.Department", "d").createAlias("esm.Hospital", "hos")
				.add(Restrictions.eq("d.Id", (Integer)details.get("departmentId")))
						.add(Restrictions.eq("hos.Id", (Integer)details.get("hospitalId"))).list(); // hospital_id restriction added by Amit Das on 29-03-2016
		/*userList=session.createCriteria(UserDepartment.class, "ud")
				//.createAlias("ud.User","us")
				//.createAlias("us.Hospital", "hos")
				.createAlias("ud.Department", "d")
				//.add(Restrictions.eq("hos.Id", (Integer)details.get("hospitalId")))
				.add(Restrictions.eq("d.Id", (Integer)details.get("departmentId"))).list();
		System.out.println("----"+(Integer)details.get("hospitalId"));
		map.put("userList", userList);*/
		map.put("empScMappings", empScMappings);
		return map;
	}
	@Override
	public Map<String, Object> getResourceListForConfig(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<EmpScMapping> empScMappings=new ArrayList<EmpScMapping>();
		empScMappings=session.createCriteria(EmpScMapping.class,"esm")
				.createAlias("esm.Employee", "e")
				.createAlias("esm.Department", "d")
				.createAlias("e.Ranks", "r")
				.add(Restrictions.isNotNull("r.DesignationOrder"))
				.add(Restrictions.eq("d.Id", (Integer)details.get("departmentId"))).list();
		map.put("empScMappings", empScMappings);
		return map;
	}
	@Override
	public Map<String, Object> saveAssignResource(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		String msg="";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
		MmMasRequestStatus mmMasRequestStatusRe=new MmMasRequestStatus();
		Integer priorityId=0;
		if(details.get("priorityId")!=null&&!"".equalsIgnoreCase(details.get("priorityId").toString())){
			priorityId=Integer.parseInt(details.get("priorityId").toString());
		}
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		MasEmployee masEmployee=new MasEmployee();
		Session session=(Session)getSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
		mmMasRequestStatus=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", "ATE").ignoreCase()).list();
		MmServiceRequest mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, (Integer.parseInt((String)details.get("RequestNo"))));
		if(mmServiceRequest.getRequestStatus().getStatusCode().equalsIgnoreCase("RAS")){
			mmMasRequestStatusRe.setId(mmServiceRequest.getTrReqStatus().getId());
			mmServiceRequest.setRequestStatus(mmMasRequestStatusRe);
		}else{
			masRequestStatus.setId(mmMasRequestStatus.get(0).getId());
			mmServiceRequest.setRequestStatus(masRequestStatus);
		}
		if(priorityId!=0){
			MasPriorityCodes priority=new MasPriorityCodes();
			priority.setId(priorityId);
			mmServiceRequest.setPriority(priority);
			
		}
	
		masEmployee.setId(Integer.parseInt((String)details.get("Resource")));
		if(details.get("department")!=null){
			MasDepartment forwordDepartment = new MasDepartment();
			forwordDepartment.setId(Integer.parseInt((String)details.get("department")));
			mmServiceRequest.setForwardDepartment(forwordDepartment);
		}
		
		mmServiceRequest.setResourceUser(masEmployee);
		mmServiceRequest.setResourceRemarks((String)details.get("ResourceRemark"));
		hbt.update(mmServiceRequest);
		hbt.flush();
		hbt.clear();
		msg="<span style='color: green'>Successfully Assigned To Engineer.</span>";
		tx.commit();
		}catch (Exception e){
			e.printStackTrace();
			tx.rollback();
			msg="<span style='color: red'>Try Again.</span>";
		}
		map.put("msg", msg);
		return map;
	}
	@Override
	public Map<String, Object> getPendingServiceRequestList(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
		List<MmMasRequestStatus>masRequestStatus=new ArrayList<MmMasRequestStatus>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		String[] statusCode=null;
		String[] priorityCode=null;
		String flag = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("pending.service.request.status.list").split("#");
			priorityCode = prop.getProperty("priority.code.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
		if(details.get("hospitalId")!=null && details.get("hospitalId")!=""){
			hospitalId=(Integer)details.get("hospitalId");
		}
		if(details.get("flag")!=null && details.get("flag")!=""){
			flag=(String)details.get("flag");
		}
		if(flag.equalsIgnoreCase("all")){
				Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h").createAlias("sr.RequestStatus", "rs")
						.createAlias("sr.Priority", "pr").createAlias("sr.Equipment", "em").createAlias("sr.ResourceUser", "ru").createAlias("em.Item", "i")
						.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.in("rs.Id", status))
						.add(Restrictions.eq("ru.Id", (Integer)details.get("empId")))
						.addOrder(Order.desc("RequestDate"));
				mmServiceRequests=cr.list();
		}else{
				Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h").createAlias("sr.RequestStatus", "rs")
						.createAlias("sr.Priority", "pr").createAlias("sr.Equipment", "em").createAlias("sr.ResourceUser", "ru").createAlias("em.Item", "i")
						.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.in("rs.Id", status))
						.add(Restrictions.eq("ru.Id", (Integer)details.get("empId")));
				if(details.get("fromDate")!=null && details.get("fromDate")!="" && details.get("toDate")!=null && details.get("toDate")!=""){
					try{
					fromDate=sdf.parse(details.get("fromDate").toString());
					toDate=sdf.parse(details.get("toDate").toString());
					}catch(Exception e){e.printStackTrace();}
					cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
				}
				if(details.get("requestId")!=null && details.get("requestId")!=""){
					cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", details.get("requestId")));
				}
				if(details.get("itemCode")!=null && details.get("itemCode")!=""){
					cr=cr.add(Restrictions.eq("i.PvmsNo", details.get("itemCode")));
				}
				if(details.get("priority")!=null && details.get("priority")!=""){
					cr=cr.add(Restrictions.eq("pr.Id", Integer.parseInt(details.get("priority").toString())));
				}
				if(details.get("ItemName")!=null && details.get("ItemName")!=""){
					cr=cr.add(Restrictions.eq("i.Nomenclature", details.get("ItemName").toString()));
				}
				if(details.get("status")!=null && details.get("status")!=""){
					cr=cr.add(Restrictions.eq("rs.Id",  Integer.parseInt(details.get("status").toString())));
				}
				mmServiceRequests=cr.list();
		}
		priority=session.createCriteria(MasPriorityCodes.class).add(Restrictions.in("CodesCode", priorityCode)).list();
		masRequestStatus=session.createCriteria(MmMasRequestStatus.class).list(); 
		List<MmServiceRequest> finalList=new ArrayList<MmServiceRequest>();
		List<MmServiceRequest> criticalList=new ArrayList<MmServiceRequest>();
		List<MmServiceRequest> urgentList=new ArrayList<MmServiceRequest>();
		List<MmServiceRequest> normalList=new ArrayList<MmServiceRequest>();
        for(MmServiceRequest orginal:mmServiceRequests){
        	if("CRT".equalsIgnoreCase(orginal.getPriority().getCodesCode())){
        		criticalList.add(orginal);
        	}else if("URG".equalsIgnoreCase(orginal.getPriority().getCodesCode())){
        		urgentList.add(orginal);
        	}else if("NOR".equalsIgnoreCase(orginal.getPriority().getCodesCode())){
        		normalList.add(orginal);
        	}else{
        		normalList.add(orginal);
        	}
        }
        finalList.addAll(criticalList);
        finalList.addAll(urgentList);
        finalList.addAll(normalList);
		map.put("masRequestStatus", masRequestStatus);
		map.put("priority", priority);
		map.put("mmServiceRequest", finalList);
		return map;
	}
	
	public List<MmPreventiveCheckList> getCheckList(Map<String, Object> details){
		List<MmPreventiveCheckList> mmPreventiveCheckList=new ArrayList<MmPreventiveCheckList>();
		Criteria criteria = getSession().createCriteria(MmPreventiveCheckList.class, "cl");
		if(details.get("equipmentId")!=null){
			criteria=criteria.createAlias("cl.Equipment", "e").add(Restrictions.eq("e.Id", Integer.parseInt((String)details.get("equipmentId"))));
		}
		if(details.get("amcId")!=null){
			criteria=criteria.createAlias("cl.Amc", "amc").add(Restrictions.eq("amc.Id", (Integer)details.get("amcId")));
		}
		mmPreventiveCheckList=criteria.list();
		return mmPreventiveCheckList;
	}
	@Override
	public Map<String, Object> getInspectionDetails(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		HibernateTemplate hbt=getHibernateTemplate();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<MasCostCenter> costCenter=new ArrayList<MasCostCenter>();
		List<MasStoreSupplierType> supplierType=new ArrayList<MasStoreSupplierType>();
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		List<MmInspectionReport> mmInspectionReport=new ArrayList<MmInspectionReport>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
		List<MasStoreSupplier> suppliers=new ArrayList<MasStoreSupplier>();
		List<MmPreventiveCheckList> mmPreventiveCheckList=new ArrayList<MmPreventiveCheckList>();
		List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();
		List<FaMasAccount> faMasAccounts=new ArrayList<FaMasAccount>();
		Map<String, Object> data=new HashMap<String, Object>();
		Session session=(Session)getSession();
		String[] statusCode={"SC", "UO", "WO", "SCH", "OH", "CND"};
//		List<MmMasRequestStatus> status=getMaintenanceStatus(statusCode);
		Integer[] status={7,4,8,17,18,19};
		Integer[] sup={1,2,3,4};
		mmServiceRequests=session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Id", Integer.parseInt(details.get("requestId").toString()))).list();
		costCenter=session.createCriteria(MasCostCenter.class).addOrder(Order.asc("CostCenterName")).list();
		supplierType=session.createCriteria(MasStoreSupplierType.class).add(Restrictions.eq("Status", "y")).list();
		mmMasRequestStatus=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.in("Id", status)).list();
		mmInspectionReport=session.createCriteria(MmInspectionReport.class, "ir")
				.createAlias("ir.Request", "sr")
				.add(Restrictions.eq("sr.Id", mmServiceRequests.get(0).getId())).list();
		suppliers=session.createCriteria(MasStoreSupplier.class,"s").createAlias("s.SupplierType", "st").add(Restrictions.in("st.Id", sup)).addOrder(Order.asc("SupplierName")).list();
		if(mmInspectionReport.size()!=0){
		mmPreventiveCheckListDetails=session.createCriteria(MmPreventiveCheckListDetails.class,"pcld")
				.createAlias("pcld.InspectionReport", "ir")
				.add(Restrictions.eq("ir.Id", mmInspectionReport.get(0).getId())).add(Restrictions.eq("pcld.Status", "y")).list();
		}
		data.put("equipmentId", mmServiceRequests.get(0).getEquipment().getId().toString());
		hesEquipmentMaster=getEquipment(data);
		hesEquipmentAmcDetailsEntry=getAMCDetails(data);
		if(mmServiceRequests.get(0).getRequestType().equalsIgnoreCase("Preventive")){
			if(mmServiceRequests.get(0).getAmc()!=null){
				data.put("amcId", mmServiceRequests.get(0).getAmc().getId());
				mmPreventiveCheckList=getCheckList(data);
			}else{
				mmPreventiveCheckList=getCheckList(data);
			}
		}
		Criteria faAccount=session.createCriteria(FaMasAccount.class);
		if(details.get("hospitalId")!=null){
			faAccount.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
		}
		faMasAccounts=faAccount.list();
		map.put("faMasAccounts", faMasAccounts);
		map.put("suppliers", suppliers);
		map.put("mmServiceRequests", mmServiceRequests);
		map.put("costCenter", costCenter);
		map.put("supplierType", supplierType);
		map.put("mmMasRequestStatus", mmMasRequestStatus);
		map.put("mmInspectionReport", mmInspectionReport);
		map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
		map.put("hesEquipmentMaster", hesEquipmentMaster);
		map.put("mmPreventiveCheckList", mmPreventiveCheckList);
		map.put("mmPreventiveCheckListDetails", mmPreventiveCheckListDetails);
		return map;
	}
	
	@Override
	public Map<String, Object> getItemListForAutoComplet(
			Map<String, Object> details) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		// String pvmsNo = null;
		// Box box = (Box) dataMap.get("box");
		int deptId = 0;
		int hospitalId = 0;
//		deptId = Integer.parseInt("" + details.get("departmentId"));
//		hospitalId = Integer.parseInt("" + details.get("hospitalId"));
		List objectList = new ArrayList();
		String[] equipmentCategoryCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			equipmentCategoryCode = prop.getProperty("maitenance.equipment.category.code1").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String str = (String) details.get("query") + "%";
			String qry = "SELECT distinct item_id FROM store_item_batch_stock ";
			objectList = (List) session.createSQLQuery(qry).list();
			Criteria c = session.createCriteria(MasStoreItem.class).createAlias("ItemCategory", "ic").add(
					Restrictions.like("Nomenclature", str).ignoreCase()).add(Restrictions.in("ic.ItemCategoryCode", equipmentCategoryCode));
			// .add(Restrictions.in("Id", objectList));
			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		map.put("objectList", objectList);
		return map;
	}
	@Override
	public Map<String, Object> getSupplierList(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasStoreSupplier> suppliers=new ArrayList<MasStoreSupplier>();
		Session session=(Session)getSession();
		suppliers=session.createCriteria(MasStoreSupplier.class,"s").createAlias("s.SupplierType", "st").add(Restrictions.eq("st.Id", (Integer)details.get("supplierTypeId"))).addOrder(Order.asc("SupplierName")).list();
		map.put("suppliers", suppliers);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitInspectionReport(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session= (Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		String msg="";
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		MmInspectionReport mmInspectionReport=new MmInspectionReport();
		HesEquipmentAmcDetailsEntry hesEquipmentAmcDetailsEntry=new HesEquipmentAmcDetailsEntry();
		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
		MmSafetyProcedureMaterials mmSafetyProcedureMaterial=new MmSafetyProcedureMaterials();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		MasStoreItem masStoreItem=new MasStoreItem();
		MasHospital hospital=new MasHospital();
		Users user=new Users();
		MasStoreSupplier masStoreSupplier=new MasStoreSupplier();
		List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterials=new ArrayList<MmSafetyProcedureMaterials>();
		List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();
		List<Integer> mmCheckLists=new ArrayList<Integer>();
		List<Integer> allCheckLists=new ArrayList<Integer>();
		List<MmPreventiveCheckList> mmPreventiveCheckLists=new ArrayList<MmPreventiveCheckList>();
		List<MmPreventiveCheckList> preventiveCheckLists=new ArrayList<MmPreventiveCheckList>();
		Date lastChgDate=null;
		String lastChgTime="";
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			tx = session.beginTransaction();
			//-------    Populate Value ---------
			if(details.get("ServiceRequestId")!=null){
				mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, Integer.parseInt((String)details.get("ServiceRequestId")));
				if(mmServiceRequest.getId()!=null){
					List<MmInspectionReport> mmIns=new ArrayList<MmInspectionReport>();
					mmIns=session.createCriteria(MmInspectionReport.class, "ins").createAlias("ins.Request", "r")
							.add(Restrictions.eq("r.Id", mmServiceRequest.getId())).list();
					if(mmIns.size()!=0)
					mmInspectionReport=(MmInspectionReport)hbt.get(MmInspectionReport.class, mmIns.get(0).getId());
				}
				if(mmInspectionReport.getId()!=null){
					mmSafetyProcedureMaterials=session.createCriteria(MmSafetyProcedureMaterials.class)
							.createAlias("InspectionReport", "ir")
							.add(Restrictions.eq("ir.Id", mmInspectionReport.getId())).list();
					mmPreventiveCheckListDetails=session.createCriteria(MmPreventiveCheckListDetails.class)
							.createAlias("InspectionReport", "ir")
							.add(Restrictions.eq("ir.Id", mmInspectionReport.getId())).list();
				}
			}
		
			//-------    Inspection Details Set Data----------
			if(details.get("hospitalId")!=null){
				hospital.setId((Integer)details.get("hospitalId"));
				mmInspectionReport.setHospital(hospital);
			}
			if(details.get("userId")!=null){
				user.setId((Integer)details.get("userId"));
				mmInspectionReport.setLastChgBy(user);
			}
			if(mmServiceRequest.getId()!=null){
				mmInspectionReport.setRequest(mmServiceRequest);
				hesEquipmentMaster.setId(mmServiceRequest.getEquipment().getId());
				mmInspectionReport.setEquipment(hesEquipmentMaster);
				if(details.get("ActionType")!=null){
					if(details.get("ActionType").equals("SC")){
						hesEquipmentMaster=hbt.get(HesEquipmentMaster.class,mmServiceRequest.getEquipment().getId());
						hesEquipmentMaster.setPreventiveCompletedCycle(mmServiceRequest.getEquipment().getPreventiveCompletedCycle()+1);
						hesEquipmentMaster.setId(mmServiceRequest.getEquipment().getId());
						hbt.update(hesEquipmentMaster);
						hbt.flush();
					}
				}
			}
			if(details.get("SupplierName")!=null){
				masStoreSupplier.setId(Integer.parseInt((String)details.get("SupplierName")));
				mmInspectionReport.setVendor(masStoreSupplier);
			}
			if(details.get("lastChgDate")!=null){
				lastChgDate=sdf.parse((String)details.get("lastChgDate"));
				mmInspectionReport.setLastChgDate(lastChgDate);
			}
			if(details.get("lastChgTime")!=null){
				lastChgTime=(String)details.get("lastChgTime");
				mmInspectionReport.setLastChgTime(lastChgTime);
			}
			if(details.get("ActionType")!=null){
				List<MmMasRequestStatus> mmMasRequestStatus2=new ArrayList<MmMasRequestStatus>();
				String[] data={(String)details.get("ActionType")};
				mmMasRequestStatus2=getMaintenanceStatus(data);
				mmMasRequestStatus.setId(mmMasRequestStatus2.get(0).getId());
				mmInspectionReport.setRequestStatus(mmMasRequestStatus);
				mmServiceRequest.setRequestStatus(mmMasRequestStatus);
				if(details.get("ActionType").equals("SC")){
					mmServiceRequest.setCloseDate(lastChgDate);
					mmServiceRequest.setCloseTime(lastChgTime);
				}
			}
			
			if(details.get("CloseType")!=null){
				mmInspectionReport.setCloseType((String)details.get("CloseType"));
			}
			if(details.get("WorkOrderType")!=null){
				mmInspectionReport.setWorkOrderType((String)details.get("WorkOrderType"));
			}
			if(details.get("ResourceRequirment")!=null){
				mmInspectionReport.setResourceRequirement((String)details.get("ResourceRequirment"));
			}
			if(details.get("DescriptionOfWork")!=null){
				mmInspectionReport.setDescriptionOfWork((String)details.get("DescriptionOfWork"));
			}
			if(details.get("obDate")!=null){
				Date obDate=sdf.parse((String)details.get("obDate"));
				mmInspectionReport.setObservationDate(obDate);
			}
			if(details.get("ObservationTime")!=null){
				mmInspectionReport.setObservationTime((String)details.get("ObservationTime"));
			}
			if(details.get("ObservationRemark")!=null){
				mmInspectionReport.setObservationRemark((String)details.get("ObservationRemark"));
			}
			if(details.get("ServiceCost")!=null){
				mmInspectionReport.setServiceCost(new BigDecimal((String)details.get("ServiceCost")));
			}
			if(details.get("MeterialCost")!=null){
				mmInspectionReport.setMaterialCost(new BigDecimal((String)details.get("MeterialCost")));
			}
			if(details.get("PlannedCost")!=null){
				mmInspectionReport.setPlannedCost(new BigDecimal((String)details.get("PlannedCost")));
			}
			if(details.get("WorkOrderRemark")!=null){
				mmInspectionReport.setWoRemarks((String)details.get("WorkOrderRemark"));
			}
			if(details.get("PreventiveDoneOn")!=null){
				Date preventiveDoneOn=sdf.parse((String)details.get("PreventiveDoneOn"));
				mmInspectionReport.setPreventiveDoneOn(preventiveDoneOn);
			}
			if(details.get("ScheduledDate")!=null){
				Date scheduledDate=sdf.parse((String)details.get("ScheduledDate"));
				mmInspectionReport.setScheduledDate(scheduledDate);
			}
			if(details.get("ScheduledTime")!=null){
				mmInspectionReport.setScheduledTime((String)details.get("ScheduledTime"));
			}
			if(details.get("ContactPerson")!=null){
				mmInspectionReport.setContactPerson((String)details.get("ContactPerson"));
			}
			if(details.get("OnHoldReason")!=null){
				mmInspectionReport.setReason((String)details.get("OnHoldReason"));
			}
			if(details.get("WORequiredDate")!=null){
				mmInspectionReport.setWoReqDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("WORequiredDate")));;
			}
			if(details.get("PlannedEndDate")!=null){
				mmInspectionReport.setPlannedEndDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("PlannedEndDate")));;
			}
			if(details.get("PlannedStartDate")!=null){
				mmInspectionReport.setPlannedStartDate(HMSUtil.convertStringTypeDateToDateType((String)details.get("PlannedStartDate")));;
			}
			if(details.get("Account")!=null){
				FaMasAccount faMasAccount=new FaMasAccount();
				faMasAccount.setId(Integer.parseInt((String)details.get("Account")));
				mmInspectionReport.setAccount(faMasAccount);;
			}
			//----- For Emergency Indent
			if(details.get("ImergencyIndent")!=null){
				List<MmMasRequestStatus> mmMasRequestStatus4=new ArrayList<MmMasRequestStatus>();
				mmInspectionReport.setEmergencyIndent((String)details.get("ImergencyIndent"));
				mmMasRequestStatus4=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.eq("StatusCode", "CA")).list();
				MmMasRequestStatus status=new MmMasRequestStatus(mmMasRequestStatus4.get(0).getId());
				mmInspectionReport.setRequestStatus(status);
				mmServiceRequest.setRequestStatus(status);
			}else{
				mmInspectionReport.setEmergencyIndent("n");
			}
			
			hbt.saveOrUpdate(mmInspectionReport);
			hbt.flush();
			hbt.clear();
			hbt.update(mmServiceRequest);
			hbt.flush();
			hbt.clear();
			if(details.get("ItemId")!=null && details.get("RequiredQty")!=null){
				Object[] data=(Object[])details.get("ItemId");
				Object[] requiredQty=(Object[])details.get("RequiredQty");
				int i=0;
				if(data.length>0){
				for(Object ob:data){
					mmSafetyProcedureMaterial.setInspectionReport(mmInspectionReport);
					masStoreItem.setId(Integer.parseInt((String)ob));
					mmSafetyProcedureMaterial.setItem(masStoreItem);
					mmSafetyProcedureMaterial.setRequiredQty(new BigDecimal((String)requiredQty[i]));
					if(details.get("specification") != null){
						Object[] specification = (Object[])details.get("specification");
						mmSafetyProcedureMaterial.setSpecification((String)specification[i]);
					}
					mmSafetyProcedureMaterial.setLastChgBy(user);
					mmSafetyProcedureMaterial.setLastChgDate(new Date());
					if(details.get("ImergencyIndent")!=null){
						mmSafetyProcedureMaterial.setStatus("c");
					}else{mmSafetyProcedureMaterial.setStatus("p");}
					mmSafetyProcedureMaterial.setLastChgBy(user);
					mmSafetyProcedureMaterial.setLastChgDate(lastChgDate);
					mmSafetyProcedureMaterial.setLastChgTime(lastChgTime);
					hbt.save(mmSafetyProcedureMaterial);
					hbt.flush();
					hbt.clear();
					++i;
				}
				}
			}
			if(details.get("AllCheckList")!=null){
				allCheckLists.addAll((List<Integer>)details.get("AllCheckList"));
				if(details.get("mmCheckLists")!=null){
					mmCheckLists.addAll((List<Integer>)details.get("mmCheckLists"));
				}
				if(allCheckLists.size()!=0)
				mmPreventiveCheckLists=session.createCriteria(MmPreventiveCheckList.class).add(Restrictions.in("Id", allCheckLists)).list();
				if(mmCheckLists.size()!=0)
				preventiveCheckLists=session.createCriteria(MmPreventiveCheckList.class).add(Restrictions.in("Id", mmCheckLists)).list();
				for(MmPreventiveCheckList mmCheckList:mmPreventiveCheckLists){
					MmPreventiveCheckListDetails mmPreventiveCheckListDetails2=new MmPreventiveCheckListDetails();
					if(mmPreventiveCheckListDetails.size()!=0){
						List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails3=new ArrayList<MmPreventiveCheckListDetails>();
						mmPreventiveCheckListDetails3=session.createCriteria(MmPreventiveCheckListDetails.class, "pcl")
								.createAlias("pcl.CheckList", "cl")
								.createAlias("pcl.InspectionReport", "ir")
								.createAlias("ir.Request", "r")
								.add(Restrictions.eq("cl.Id", mmCheckList.getId())).add(Restrictions.eq("r.Id", mmServiceRequest.getId())).list();
						if(mmPreventiveCheckListDetails3.size()!=0){
							mmPreventiveCheckListDetails2=(MmPreventiveCheckListDetails)hbt.get(MmPreventiveCheckListDetails.class, mmPreventiveCheckListDetails3.get(0).getId());
						}
					}

					mmPreventiveCheckListDetails2.setCheckList(mmCheckList);
					mmPreventiveCheckListDetails2.setRequest(mmServiceRequest);
					mmPreventiveCheckListDetails2.setPreventiveNo(1);
					mmPreventiveCheckListDetails2.setHospital(hospital);
					mmPreventiveCheckListDetails2.setInspectionReport(mmInspectionReport);
					String status="n";
					for(MmPreventiveCheckList  preventiveStatus:preventiveCheckLists){
						if(preventiveStatus.getId()==mmCheckList.getId()){
							status="y";
						}
					}
					mmPreventiveCheckListDetails2.setStatus(status);
					hbt.saveOrUpdate(mmPreventiveCheckListDetails2);
					hbt.flush();
					hbt.clear();
				}
			}
			tx.commit();
			msg="<span style='color: green'>Successfully Saved.</span>";
			} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			msg="<span style='color: red'>Try Again...</span>";
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		/*Map<String, Object> map=new HashMap<String, Object>();
			MmInspectionReport mmInspectionReport=new MmInspectionReport();
			MmServiceRequest mmServiceRequest=new MmServiceRequest();
			MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
			HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
			MasCostCenter masCostCenter=new MasCostCenter();
			MasStoreSupplier masStoreSupplier=new MasStoreSupplier();
			MmSafetyProcedureMaterials mmSafetyProcedureMaterials=new MmSafetyProcedureMaterials();
			MasStoreItem masStoreItem=new MasStoreItem();
			Users user=new Users();
			MasHospital hospital=new MasHospital();
			List<MmInspectionReport> flag=new ArrayList<MmInspectionReport>();
			List<MmSafetyProcedureMaterials> flag1=new ArrayList<MmSafetyProcedureMaterials>();
			List<Integer> mmCheckLists=new ArrayList<Integer>();
			List<MmPreventiveCheckList> mmPreventiveCheckLists=new ArrayList<MmPreventiveCheckList>();
			List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();
			Session session=(Session)getSession();	
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date pfromDate=new Date();
			Date ptoDate=new Date();
			String msg="";
			boolean WOflag=false;
			int ServiceRequestId=0;
			if(details.get("ServiceRequestId")!=null)
				ServiceRequestId=Integer.parseInt((String)details.get("ServiceRequestId"));
			flag=session.createCriteria(MmInspectionReport.class).createAlias("Request", "r").add(Restrictions.eq("r.Id", ServiceRequestId)).list();
			if(flag.size()!=0){
				mmInspectionReport=(MmInspectionReport) hbt.get(MmInspectionReport.class, flag.get(0).getId());
				flag1=session.createCriteria(MmSafetyProcedureMaterials.class).createAlias("InspectionReport", "ir").add(Restrictions.eq("ir.Id", flag.get(0).getId())).list();
				if(flag1.size()!=0){
					mmSafetyProcedureMaterials=(MmSafetyProcedureMaterials)hbt.get(MmSafetyProcedureMaterials.class, flag1.get(0).getId());
				}
			}
			if(details.get("CloseType")!=null){
				mmInspectionReport.setCloseType((String)details.get("CloseType"));
			}
			if(details.get("ServiceRequestId")!=null){
				mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, Integer.parseInt(details.get("ServiceRequestId").toString()));
				mmInspectionReport.setRequest(mmServiceRequest);
			}
			if(details.get("mmCheckLists")!=null){
				mmCheckLists.addAll((List<Integer>)details.get("mmCheckLists"));
				mmPreventiveCheckLists=session.createCriteria(MmPreventiveCheckList.class).add(Restrictions.in("Id", mmCheckLists)).list();
				for(MmPreventiveCheckList mmCheckList:mmPreventiveCheckLists){
					MmPreventiveCheckListDetails mmPreventiveCheckListDetails2=new MmPreventiveCheckListDetails();
					mmPreventiveCheckListDetails2.setCheckList(mmCheckList);
					mmPreventiveCheckListDetails2.setRequest(mmServiceRequest);
					hbt.save(mmPreventiveCheckListDetails2);
					hbt.flush();
					hbt.clear();
				}
				System.out.println("===="+mmPreventiveCheckLists.size());
			}
			hesEquipmentMaster=(HesEquipmentMaster) hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
			if(details.get("ActionType")!=null){
				mmMasRequestStatus=(MmMasRequestStatus) hbt.get(MmMasRequestStatus.class, Integer.parseInt((String)details.get("ActionType")));
				mmServiceRequest.setRequestStatus(mmMasRequestStatus);
				mmInspectionReport.setRequestStatus(mmMasRequestStatus);
				if(details.get("ActionType").equals("8")){
					WOflag=true;
				}
			}
			if(details.get("WorkOrderType")!=null){
				mmInspectionReport.setWorkOrderType((String)details.get("WorkOrderType"));
			}
			if(details.get("ResourceRequirment")!=null){
				mmInspectionReport.setResourceRequirement((String)details.get("ResourceRequirment"));				
			}
			if(details.get("DescriptionOfWork")!=null){
				mmInspectionReport.setDescriptionOfWork((String)details.get("DescriptionOfWork"));
			}
			if(details.get("obDate")!=null){
				Date obDate=null;
				try{
					obDate=sdf.parse(details.get("obDate").toString());
					}catch(Exception e){e.printStackTrace();}
				mmInspectionReport.setObservationDate(obDate);
			}
			if(details.get("ObservationTime")!=null){
				mmInspectionReport.setObservationTime((String)details.get("ObservationTime"));
			}
			if(details.get("WorkOrderRemark")!=null){
				mmInspectionReport.setWorkOrderRemark((String)details.get("WorkOrderRemark"));
			}
			if(details.get("ObservationRemark")!=null){
				mmInspectionReport.setObservationRemark((String)details.get("ObservationRemark"));
			}
			if(details.get("equipmentId")!=null){
//				hesEquipmentMaster.setId(Integer.parseInt(details.get("equipmentId").toString()));
				mmInspectionReport.setEquipment(hesEquipmentMaster);
			}
			if(details.get("mmCheckLists")!=null){
				
			}
			if(mmServiceRequest.getRequestType().equalsIgnoreCase("Preventive") && Integer.parseInt((String)details.get("ActionType"))==7){
				hesEquipmentMaster.setPreventiveCompletedCycle(hesEquipmentMaster.getPreventiveCompletedCycle()+1);
				hbt.update(hesEquipmentMaster);
				hbt.flush();
				hbt.clear();
			}
			if(details.get("ServiceCost")!=null){
				mmInspectionReport.setServiceCost(new BigDecimal((String)details.get("ServiceCost")));
			}
			if(details.get("MeterialCost")!=null){
				mmInspectionReport.setMaterialCost(new BigDecimal((String)details.get("MeterialCost")));
			}
			if(details.get("PlannedCost")!=null && details.get("PlannedCost")!=""){
				mmInspectionReport.setPlannedCost(new BigDecimal(""+details.get("PlannedCost")));
			}
			if(details.get("SupplierName")!=null && details.get("SupplierName")!=""){
				masStoreSupplier.setId(Integer.parseInt((String)details.get("SupplierName")));
				mmInspectionReport.setVendor(masStoreSupplier);
			}
			if(details.get("WorkOrderRemark")!=null){
				mmInspectionReport.setRemarks((String)details.get("WorkOrderRemark"));
			}
			if(details.get("hospitalId")!=null){
				hospital.setId((Integer)details.get("hospitalId"));
				mmInspectionReport.setHospital(hospital);
			}
			if(details.get("userId")!=null){
				user.setId((Integer)details.get("userId"));
				mmInspectionReport.setLastChgBy(user);
				mmInspectionReport.setLastChgDate(new Date());
			}
			
			if(flag.size()==0){
				int workOrderNo=(Integer)hbt.save(mmInspectionReport);
				Date workOrderDate=new Date();
				String workOrder="WO"+workOrderNo+"/"+workOrderDate.getYear()+"/"+workOrderDate.getMonth()+"/"+workOrderDate.getDay();
				if(WOflag){
					mmInspectionReport=(MmInspectionReport) hbt.get(MmInspectionReport.class, workOrderNo);
					mmInspectionReport.setWorkOrderNo(workOrder);
					mmInspectionReport.setWorkOrderDate(workOrderDate);
					hbt.update(mmInspectionReport);
				}
				hbt.flush();
				hbt.clear();
			}else{
				hbt.update(mmInspectionReport);
				hbt.flush();
				hbt.clear();
			}
			if(details.get("ItemId")!=null){
				Object[] data=(Object[])details.get("ItemId");
				Object[] requiredQty=(Object[])details.get("RequiredQty");
				int i=0;
				if(data.length>0){
				for(Object ob:data){
					mmSafetyProcedureMaterials.setInspectionReport(mmInspectionReport);
					masStoreItem.setId(Integer.parseInt((String)ob));
					mmSafetyProcedureMaterials.setItem(masStoreItem);
					mmSafetyProcedureMaterials.setRequiredQty(new BigDecimal((String)requiredQty[i]));
					mmSafetyProcedureMaterials.setLastChgBy(user);
					mmSafetyProcedureMaterials.setLastChgDate(new Date());
					mmSafetyProcedureMaterials.setStatus("p");
					hbt.save(mmSafetyProcedureMaterials);
					hbt.flush();
					hbt.clear();
					++i;
				}
				}
			}
			if(details.get("ServiceRequestId")!=null){
			hbt.update(mmServiceRequest);
			hbt.flush();
			hbt.clear();
			}*/
			
			map.put("msg", msg);
		return map;
	}
	
	@Override
	public Map<String, Object> getItemDetail(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<String> item=new ArrayList<String>();
		MasStoreItem masStoreItem=new MasStoreItem();
		StoreItemBatchStock storeItemBatchStock=new StoreItemBatchStock();
		List<StoreItemBatchStock> storeItemBatchStocks=new ArrayList<StoreItemBatchStock>();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		if(details.get("requestId")!=null && details.get("requestId")!="")
		masStoreItem=(MasStoreItem) hbt.get(MasStoreItem.class, Integer.parseInt(details.get("requestId").toString()));
		storeItemBatchStocks=session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("Item.Id", masStoreItem.getId())).addOrder(Order.desc("ClosingStock")).list();
		System.out.println("list"+storeItemBatchStocks.size());
		if(storeItemBatchStocks.size()>0)
		storeItemBatchStock=(StoreItemBatchStock)hbt.get(StoreItemBatchStock.class, storeItemBatchStocks.get(0).getId());
		map.put("masStoreItem", masStoreItem);
		map.put("storeItemBatchStock", storeItemBatchStock);
		return map;
	}
	
	@Override
	public Map<String, Object> getPendingServiceServiceOrderList(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmInspectionReport> inspectionReports=new ArrayList<MmInspectionReport>();
		List<MasPriorityCodes> priorityCodes=new ArrayList<MasPriorityCodes>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Session session=(Session)getSession();
		String flag = "";
		if(details.get("flag") != null){
			flag = (String)details.get("flag");
		}
		/*String query="select spm.Id, ir.Id, ir.WorkOrderDate, ir.WorkOrderNo, sr.ServiceRequestNo,e.EquipmentName, p.CodesName, "
				+ "rb.UserName, d.DepartmentName from MmSafetyProcedureMaterials spm  join spm.InspectionReport ir join ir.Request sr join sr.Equipment e "
				+ "join sr.Priority p join sr.LastChgBy rb join e.Department d join ir.Hospital h where spm.Id=ir.Id and ir.Request=sr.Id and e.Id=sr.Equipment and p.Id=sr.Priority and sr.LastChgBy=rb.Id and e.Department=d.Id and spm.Status='a' ";
		if(details.get("hospitalId")!=null){
			query+=" and h.Id="+details.get("hospitalId");
		}
		if(details.get("RequestNo")!=null){
			query+=" and sr.ServiceRequestNo='"+details.get("RequestNo")+"'";
		}
		if(details.get("Priority")!=null){
			query+=" and p.Id="+Integer.parseInt((String)details.get("Priority"));
		}
		if(details.get("WorkOrderNo")!=null){
			query+=" and ir.WorkOrderNo='"+details.get("WorkOrderNo")+"'";
		}
		Date fromDate=null;
		Date toDate=null;
		if(details.get("fromDate")!=null &&  details.get("toDate")!=null){
			
			try{
				fromDate=sdf.parse((String)details.get("fromDate"));
				toDate=sdf.parse((String)details.get("toDate"));
				query+=" and ir.WorkOrderDate BETWEEN :fromDate and :toDate";

			}catch(Exception e){e.printStackTrace();}
		}
		Query query2=session.createQuery(query);
		if(details.get("fromDate")!=null &&  details.get("toDate")!=null){
		query2.setParameter("fromDate", fromDate);
		query2.setParameter("toDate", toDate);
		}
		mmSafetyProcedureMaterials=query2.list();*/
		String[] statusCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("service.order.complition.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=session.createCriteria(MmInspectionReport.class, "ir")
					.createAlias("ir.Request", "sr").createAlias("sr.Priority", "p").createAlias("sr.RequestStatus", "srs")
					.createAlias("sr.ResourceUser", "ru")
					.createAlias("ir.Hospital", "h").add(Restrictions.eq("h.Id", details.get("hospitalId")));
			if(statusCode!=null){
				cr=cr.add(Restrictions.in("srs.StatusCode", statusCode));
			}
			if(map.get("user")!=null){
				cr=cr.add(Restrictions.eq("ru.Id", (Integer)map.get("user")));
			}
			inspectionReports = cr.list();
			
		}else{
				Criteria cr=session.createCriteria(MmInspectionReport.class, "ir")
						.createAlias("ir.Request", "sr").createAlias("sr.Priority", "p").createAlias("sr.RequestStatus", "srs")
						.createAlias("sr.ResourceUser", "ru").createAlias("ir.Hospital", "h").add(Restrictions.eq("h.Id", details.get("hospitalId")));
				if(details.get("fromDate")!=null &&  details.get("toDate")!=null){
					Date fromDate=null;
					Date toDate=null;
					try{
						fromDate=sdf.parse((String)details.get("fromDate"));
						toDate=sdf.parse((String)details.get("toDate"));
					}catch(Exception e){e.printStackTrace();}
					cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
				}
				if(details.get("RequestNo")!=null){
					cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", (String)details.get("RequestNo")));
				}
				if(details.get("Priority")!=null){
					cr=cr.add(Restrictions.eq("p.Id", Integer.parseInt((String)details.get("Priority"))));
				}
				if(details.get("WorkOrderNo")!=null){
					cr=cr.add(Restrictions.eq("ir.WorkOrderNo", (String)details.get("WorkOrderNo")));
				}
				if(map.get("user")!=null){
					cr=cr.add(Restrictions.eq("ru.Id", (Integer)map.get("user")));
				}
		//		cr.setProjection(Projections.groupProperty("ir.Id"));
		//		cr.setProjection(Projections.groupProperty("ir.WorkOrderNo"));
				if(statusCode!=null){
					cr=cr.add(Restrictions.in("srs.StatusCode", statusCode));
				}
				inspectionReports = cr.list();
		}
		priorityCodes = session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).list();
		map.put("inspectionReports", inspectionReports);	
		map.put("priorityCodes", priorityCodes);
		return map;
	}
	@Override
	public Map<String, Object> getServiceOrderDetails(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmInspectionReport> mmInspectionReport=new ArrayList<MmInspectionReport>();
		List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterials=new ArrayList<MmSafetyProcedureMaterials>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
		List<MmPreventiveCheckList> mmPreventiveCheckList=new ArrayList<MmPreventiveCheckList>();
		List<MmPreventiveCheckListDetails> mmPreventiveCheckListDetails=new ArrayList<MmPreventiveCheckListDetails>();	
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		Map<String, Object> data=new HashMap<String, Object>();
		Session session=(Session)getSession();
		String[] statusCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("service.order.completion.workOrderStatus.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		mmInspectionReport=session.createCriteria(MmInspectionReport.class).add(Restrictions.eq("Id", Integer.parseInt((String)details.get("requestId")))).list();
		mmSafetyProcedureMaterials=session.createCriteria(MmSafetyProcedureMaterials.class,"spm").createAlias("spm.InspectionReport", "ir").add(Restrictions.eq("ir.Id", Integer.parseInt((String)details.get("requestId")))).list();
		data.put("equipmentId", mmInspectionReport.get(0).getRequest().getEquipment().getId().toString());
		hesEquipmentMaster=getEquipment(data);
		hesEquipmentAmcDetailsEntry=getAMCDetails(data);
		if(mmInspectionReport.get(0).getRequest().getEquipment()!=null){
			mmPreventiveCheckList=getCheckList(data);
		}else{
			data.put("amcId", mmInspectionReport.get(0).getRequest().getAmc().getId());
			mmPreventiveCheckList=getCheckList(data);
		}
		mmPreventiveCheckListDetails=session.createCriteria(MmPreventiveCheckListDetails.class, "cld")
				.createAlias("cld.Request", "r")
				.add(Restrictions.eq("r.Id", mmInspectionReport.get(0).getRequest().getId())).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if(statusCode!=null)
			mmMasRequestStatus=session.createCriteria(MmMasRequestStatus.class).add(Restrictions.in("StatusCode", statusCode)).list();
		map.put("mmInspectionReport", mmInspectionReport);
		map.put("mmSafetyProcedureMaterials", mmSafetyProcedureMaterials);
		map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
		map.put("hesEquipmentMaster", hesEquipmentMaster);
		map.put("mmPreventiveCheckList", mmPreventiveCheckList);
		map.put("mmPreventiveCheckListDetails", mmPreventiveCheckListDetails);
		map.put("mmMasRequestStatus", mmMasRequestStatus);
		return map;
	}
	@Override
	public Map<String, Object> submitServiceOrderCompletion(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		MmInspectionReport mmInspectionReport=new MmInspectionReport();
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date closeDate=null;
		Date challanDate=null;
		Date serviceReportDate=null;
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String msg="";
		Session session=(Session)getSession();
		mmInspectionReport=(MmInspectionReport) hbt.get(MmInspectionReport.class, Integer.parseInt(details.get("InspectionReportId").toString()));
		mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, Integer.parseInt((String)details.get("ServiceRequestId")));
		hesEquipmentMaster=(HesEquipmentMaster) hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
		String[] statusCode=null;
		Transaction tx=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("service.order.completion.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
	try{
		tx=session.beginTransaction();
		List<Integer> completionStatus=getMaintenanceId(getMaintenanceStatus(statusCode));
		if(mmServiceRequest.getRequestType().equalsIgnoreCase("Preventive") && hesEquipmentMaster.getPreventiveCompletedCycle()!=null)
		hesEquipmentMaster.setPreventiveCompletedCycle(hesEquipmentMaster.getPreventiveCompletedCycle()+1);
		if(details.get("WorkedOn")!=null){
			mmInspectionReport.setWorkedOn((String)details.get("WorkedOn"));
		}
		if(details.get("WORemark")!=null){
			mmInspectionReport.setWoRemarks((String)details.get("WORemark"));
		}
//		if(details.get("WorkOrderStatus")!=null){
//			mmInspectionReport.setWoStatus((String)details.get("WorkOrderStatus"));
//		}
		if(details.get("closeDate")!=null){
			try{
				closeDate=sdf.parse((String)details.get("closeDate"));
				challanDate=sdf.parse((String)details.get("ChallanDate"));
				serviceReportDate=sdf.parse((String)details.get("ServiceReportDate"));
			}catch(Exception e){e.printStackTrace();}
			mmInspectionReport.setWoCloseDate(closeDate);
			if(details.get("lastChgDate")!=null){
				Date requestCloseDate=null;
				try{
					requestCloseDate=sdf.parse((String)details.get("lastChgDate"));
				}catch(Exception e){e.printStackTrace();}
				mmServiceRequest.setCloseDate(requestCloseDate);
			}
			if(details.get("lastChgTime")!=null){
				mmServiceRequest.setCloseTime((String)details.get("lastChgTime"));
			}
			if(details.get("ChallanDate")!=null)
			mmInspectionReport.setWoChallanDate(challanDate);
			if(details.get("ServiceReportDate")!=null)
			mmInspectionReport.setServiceReportDate(serviceReportDate);
		}
		if(details.get("WOChallanNo")!=null){
			mmInspectionReport.setWoChallanNo((String)details.get("WOChallanNo"));
		}
		if(details.get("ServiceReportNo")!=null){
			mmInspectionReport.setServiceReportNo((String)details.get("ServiceReportNo"));
		}
		if(details.get("WOChallanAmount")!=null){
			mmInspectionReport.setWoChallanAmount(new BigDecimal((String)details.get("WOChallanAmount")));
		}
		if(details.get("WorkOrderStatus")!=null){
			MmMasRequestStatus masRequestStatus=new MmMasRequestStatus();
			masRequestStatus.setId(Integer.parseInt((String)details.get("WorkOrderStatus")));
			mmInspectionReport.setRequestStatus(masRequestStatus);
			mmServiceRequest.setRequestStatus(masRequestStatus);
		}
		hbt.update(mmInspectionReport);
		hbt.flush();
		hbt.clear();
		hbt.update(hesEquipmentMaster);
		hbt.flush();
		hbt.clear();
		hbt.update(mmServiceRequest);
		hbt.flush();
		hbt.clear();
		if(details.get("SafetyProcedureMaterialId")!=null){
			Object[] spmId=(Object[])details.get("SafetyProcedureMaterialId");
			Object[] SerialNo=(Object[])details.get("SerialNo");
			Object[] ModelNo=(Object[])details.get("ModelNo");
			Object[] ItemRemark=(Object[])details.get("ItemRemark");
			MmSafetyProcedureMaterials mmSafetyProcedureMaterials=null;
			for(int i=0;i<spmId.length;i++){
				mmSafetyProcedureMaterials=new MmSafetyProcedureMaterials();
				mmSafetyProcedureMaterials=(MmSafetyProcedureMaterials)hbt.get(MmSafetyProcedureMaterials.class, Integer.parseInt((String)spmId[i]));
				/*mmSafetyProcedureMaterials.setItemSerialNo((String)SerialNo[i]);
				mmSafetyProcedureMaterials.setItemModelNo((String)ModelNo[i]);
				mmSafetyProcedureMaterials.setItemRemarks((String)ItemRemark[i]);*/
				mmSafetyProcedureMaterials.setStatus("c");
				hbt.update(mmSafetyProcedureMaterials);
				hbt.flush();
				hbt.clear();
			}
		}
		tx.commit();
		msg="<span style='color: green'>Work Order Proceed Successfully.</span>";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null){
				tx.rollback();
				msg="<span style='color: green'>Try Again...</span>";
			}
				
		}
		
		map.put("msg", msg);
		return map;
	}
	@Override
	public Map<String, Object> getTransferServiceRequestList(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<MasPriorityCodes> mmMasPriorityCodes=new ArrayList<MasPriorityCodes>();
		List<MmInspectionReport> mmInspectionReports=new ArrayList<MmInspectionReport>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Session session=(Session)getSession();
//		Integer[] status={3,4,8,9,11,13,14,17,18};
		String flag = "";
		String[] statusCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("transfer.request.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(details.get("flag")!= null){
			flag = (String)details.get("flag");
		}
		mmMasPriorityCodes=session.createCriteria(MasPriorityCodes.class, "pc").add(Restrictions.eq("pc.Status", "y")).list();
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h")
					.createAlias("sr.Priority", "p").createAlias("sr.Equipment", "e").createAlias("sr.RequestStatus", "rs")
					.createAlias("sr.ResourceUser", "ru")
					.add(Restrictions.isNotNull("sr.ResourceUser")).add(Restrictions.eq("ru.Id", (Integer)map.get("user")))
					.add(Restrictions.in("rs.StatusCode", statusCode)).add(Restrictions.eq("h.Id", Integer.parseInt(details.get("hospitalId").toString())));
			mmServiceRequests=cr.list();
		}else{
			Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h")
					.createAlias("sr.Priority", "p").createAlias("sr.Equipment", "e").createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.isNotNull("sr.ResourceUser")).add(Restrictions.in("rs.StatusCode", statusCode)).add(Restrictions.eq("h.Id", Integer.parseInt(details.get("hospitalId").toString())));
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				Date fromDate=new Date();
				Date toDate=new Date();
					try {
						fromDate=sdf.parse((String)details.get("fromDate"));
						toDate=sdf.parse((String)details.get("toDate"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
			}
			if(details.get("RequestNo")!=null){
				cr=cr.add(Restrictions.eq("sr.ServiceNo", (String)details.get("RequestNo")));
			}
			if(details.get("EquipmentNo")!=null){
				cr=cr.add(Restrictions.eq("e.EntryNo", (String)details.get("EquipmentNo")));
			}
			if(details.get("Priority")!=null){
				cr=cr.add(Restrictions.eq("p.Id", Integer.parseInt((String)details.get("Priority"))));
			}
			if(details.get("user")!=null){
				cr=cr.createAlias("sr.ResourceUser", "u").add(Restrictions.eq("u.Id", (Integer)details.get("user")));
			}
			mmServiceRequests=cr.list();
	 }
		map.put("mmServiceRequests", mmServiceRequests);
		map.put("mmMasPriorityCodes", mmMasPriorityCodes);
		return map;
	}
	@Override
	public Map<String, Object> getTransferEquipmentDetails(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		Map<String, Object> data=new HashMap<String, Object>();
		List<HesEquipmentMaster> hesEquipmentMaster=new ArrayList<HesEquipmentMaster>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		int requestId=0;
		if(details.get("requestId")!=null){
			requestId=Integer.parseInt((String)details.get("requestId"));
		}
		mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, requestId);
		data.put("equipmentId", mmServiceRequest.getEquipment().getId().toString());
		hesEquipmentMaster=getEquipment(data);
		hesEquipmentAmcDetailsEntry=getAMCDetails(data);
		map.put("mmServiceRequest", mmServiceRequest);
		map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
		map.put("hesEquipmentMaster", hesEquipmentMaster);
		return map;
	}
	@Override
	public Map<String, Object> submitTransferServiceRequst(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		MmMasRequestStatus mmMasRequestStatusRe=new MmMasRequestStatus();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		int requestId=0;
		String msg="";
		Integer statusReminder=null;
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			if(details.get("requestId")!=null){
				requestId=Integer.parseInt((String)details.get("requestId"));
			}
			mmServiceRequest=(MmServiceRequest) hbt.get(MmServiceRequest.class, requestId);
			mmMasRequestStatusRe.setId(mmServiceRequest.getRequestStatus().getId());
			mmServiceRequest.setTrReqStatus(mmMasRequestStatusRe);
			mmMasRequestStatus.setId(16);
			mmServiceRequest.setRequestStatus(mmMasRequestStatus);
			if(details.get("TransferDetails")!=null){
				mmServiceRequest.setTransferDetail((String)details.get("TransferDetails"));
			}
			hbt.update(mmServiceRequest);
			hbt.flush();
			hbt.clear();
			tx.commit();
			msg="<span style='color: green'>Request Transfer Successfully.</span>";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null)
				tx.rollback();
			msg="<span style='color: red'>Try Again...</span>";
		}
		map.put("msg", msg);
		return map;
	}
	@Override
	public Map<String, Object> getPreventiveMaintenanceList(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<HesEquipmentMaster> hesEquipmentMasters=new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentAmcDetailsEntry> hesEquipmentAmcDetailsEntry=new ArrayList<HesEquipmentAmcDetailsEntry>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String flag = "";
		if(details.get("flag")!= null){
			flag = (String)details.get("flag");
		}
		
		Criteria amc=getSession().createCriteria(HesEquipmentAmcDetailsEntry.class, "amc")
				.createAlias("amc.Hospital", "h")
				.createAlias("amc.Epuipment", "e")
				.createAlias("e.Item", "i")
				.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")));
		if(details.get("fromDate")!=null && details.get("toDate")!=null){
			Date fromDate=new Date();
			Date toDate=new Date();
			try {
				fromDate=sdf.parse((String)details.get("fromDate"));
				toDate=sdf.parse((String)details.get("toDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
//			cr=cr.add(Restrictions.between("", fromDate, toDate));
		}
		if(details.get("ItemCode")!=null){
			amc=amc.add(Restrictions.eq("i.PvmsNo", (String)details.get("ItemCode")));
		}
		if(details.get("ItemName")!=null){
			amc=amc.add(Restrictions.eq("i.Nomenclature", (String)details.get("ItemName")));
		}
		if(details.get("ModelNo")!=null){
			amc=amc.add(Restrictions.eq("e.ModelName", (String)details.get("ModelNo")));
		}
		
		amc=amc.add(Restrictions.gt("amc.AmcWarrentyEndDate", new Date())).createAlias("e.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.or(Restrictions.isNull("e.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD")));
	
		hesEquipmentAmcDetailsEntry=amc.list();
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=getSession().createCriteria(HesEquipmentMaster.class, "e")
					.createAlias("e.Hospital", "h")
					.createAlias("e.Item", "i")
					.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")))
					.add(Restrictions.leProperty("e.PreventiveCompletedCycle", "e.PreventiveCycle"));
			cr=cr.add(Restrictions.gt("e.WarrentyEndDate", new Date())).createAlias("e.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.or(Restrictions.isNull("e.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD")));
			hesEquipmentMasters=cr.list();
			
		}else{
			Criteria cr=getSession().createCriteria(HesEquipmentMaster.class, "e")
					.createAlias("e.Hospital", "h")
					.createAlias("e.Item", "i")
					.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")))
					.add(Restrictions.leProperty("e.PreventiveCompletedCycle", "e.PreventiveCycle"));
			if(details.get("ItemCode")!=null){
				cr=cr.add(Restrictions.eq("i.PvmsNo", (String)details.get("ItemCode")));
				amc=amc.add(Restrictions.eq("i.PvmsNo", (String)details.get("ItemCode")));
			}
			if(details.get("ItemName")!=null){
				cr=cr.add(Restrictions.eq("i.Nomenclature", (String)details.get("ItemName")));
			}
			if(details.get("ModelNo")!=null){
				cr=cr.add(Restrictions.eq("e.ModelName", (String)details.get("ModelNo")));
			}
			cr=cr.add(Restrictions.gt("e.WarrentyEndDate", new Date())).createAlias("e.EquipStatus", "es", CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.or(Restrictions.isNull("e.EquipStatus"), Restrictions.ne("es.StatusCode", "CNMD")));
			hesEquipmentMasters=cr.list();
			
		}
		map.put("hesEquipmentMasters", hesEquipmentMasters);
		map.put("hesEquipmentAmcDetailsEntry", hesEquipmentAmcDetailsEntry);
		return map;
	}
	
	@Override
	public Map<String, Object> addAttachFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>();
		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();*/
		
		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		Session session = (Session)getSession();
		int request_id = 0;
		if(generalMap.get("request_id")!= null){
			request_id =(Integer) generalMap.get("request_id");
		}
		System.out.println("==="+generalMap.get("request_id"));
	if(generalMap.get("flag")==null){
		
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
		int employeeId = 0;
		if(generalMap.get("employeeId")!= null){
			employeeId =(Integer) generalMap.get("employeeId");
		}
		String fileExtension=null;
		 File file=null;
		 try { 
				HibernateTemplate hbt=getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				System.out.println(uploadURL+" -- "+filename);
				 file=new File(uploadURL + "/" + filename);
	    		 System.out.println("path>>"+file.getPath());
	    		
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
	    	     /*TempTickattach tempTickattach = new TempTickattach();
	    	     tempTickattach.setTdsaDfilename(filename);
	    	     tempTickattach.setTdsaOfilename(filename);
	    	     EtrTravelreq etrTravelreq = new EtrTravelreq();
	    	     etrTravelreq.setId(travelRequestId);
	    	     tempTickattach.setTdsaDsid(etrTravelreq);
	    	     tempTickattach.setTdsaCmts(comments);
	    	     MasEmployee masEmployee = new MasEmployee();
	    	     masEmployee.setId(employeeId);
	    	     tempTickattach.setTdsaUserid(masEmployee);
	    	     hbt.save(tempTickattach);*/
	    	     
	    	     
	      
	    	     //file.delete();
	    	     
	    	     UploadDocuments maintenanceDoc = new UploadDocuments();
	    	     maintenanceDoc.setPatientDocument(bytes);
	    	     maintenanceDoc.setFileName(filename);
	    	   
	    	     MmServiceRequest mmServiceRequest= new MmServiceRequest();
	    	     mmServiceRequest.setId(request_id);
	    	     maintenanceDoc.setRequest(mmServiceRequest);
	    	     maintenanceDoc.setDescription(comments);
	    	     hbt.save(maintenanceDoc);
	    	     hbt.flush();
	    	     hbt.refresh(maintenanceDoc);
	      
	    
	    }
		catch (Exception e) {
	    	e.printStackTrace();
	      System.err.println("Error: " + e.getMessage());
	      e.printStackTrace();
	    }
		}
		 uploadDocuments = session.createCriteria(UploadDocuments.class).createAlias("Request", "r").add(Restrictions.eq("r.Id", request_id)).list();
		// System.out.println("afterSave>>..>>"+tempdocAttachList.size());
		map.put("uploadDocuments", uploadDocuments);
		return map;
	}
	
	@Override
	public Map<String, Object> deleteAttachFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
//		List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>();
//		List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
		List<UploadDocuments> uploadDocuments=new ArrayList<UploadDocuments>();
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
		Integer requestId=0;
		Integer ticketAttachId = 0;
		if(ticketAttachIdList.size()>0){
			for (int i = 0; i < ticketAttachIdList.size(); i++) {
				if(ticketAttachIdList.get(i) != null){
					ticketAttachId = (Integer)ticketAttachIdList.get(i);
					//etrTrvdetails = (EtrTrvdetails)hbt.load(EtrTrvdetails.class, etrTrvDeatilId);
					UploadDocuments uploadDocument = (UploadDocuments)hbt.load(UploadDocuments.class, ticketAttachId);
					requestId=uploadDocument.getRequest().getId();
					hbt.delete(uploadDocument);
				}
			}
		}
		
//		tempTicketAttachList = session.createCriteria(TempTickattach.class).createAlias("TdsaDsid", "travel").add(Restrictions.eq("travel.Id", travelRequestId)).list();
//		etrTravelRequestList = session.createCriteria(EtrTravelreq.class).add(Restrictions.idEq(travelRequestId)).list();
//		map.put("etrTravelRequestList", etrTravelRequestList);
//		map.put("tempTicketAttachList", tempTicketAttachList);
		uploadDocuments=session.createCriteria(UploadDocuments.class, "ud").createAlias("ud.Request", "r")
				.add(Restrictions.eq("r.Id", requestId)).list();
		map.put("uploadDocuments", uploadDocuments);
		return map;
	}
	
	@Override
	public Map<String, Object> getRequestTrackerList(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<MmRequestConfig> mmRequestConfigs=new ArrayList<MmRequestConfig>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String flag = "";
		mmRequestConfigs=getSession().createCriteria(MmRequestConfig.class,"rc").createAlias("rc.Employee", "e").add(Restrictions.eq("e.Id", (Integer)details.get("empId"))).list();
		if(mmRequestConfigs.size()>0){
			Map<String, Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String	currentDate = (String) utilMap.get("currentDate");
			Date fromDate1=null;
			Date toDate1=null;
			try{
				fromDate1=HMSUtil.addDaysToDate(currentDate, -(mmRequestConfigs.get(0).getToDay()));
				toDate1=HMSUtil.addDaysToDate(currentDate, -(mmRequestConfigs.get(0).getFromDay()));
			}catch(Exception e){}
		if(details.get("flag") != null){
		flag = (String)details.get("flag");
		}
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h")
					.createAlias("sr.Equipment", "e")
//					.createAlias("sr.LastChgBy", "u")
					.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")))
					.add(Restrictions.between("sr.RequestDate", fromDate1, toDate1)).addOrder(Order.asc("Id"));
			mmServiceRequests=cr.list();
			
		}else{
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h")
					.createAlias("sr.Equipment", "e")
					.createAlias("sr.LastChgBy", "u")
					.add(Restrictions.eq("h.Id", (Integer)details.get("hospitalId")))
					.add(Restrictions.eq("u.Id", (Integer)details.get("user")));
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				Date fromDate=null;
				Date toDate=null;
				try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("sr.RequiredDate", fromDate, toDate));
			}
			if(details.get("RequestNo")!=null){
				cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", details.get("RequestNo")));
			}
			if(details.get("ItemName")!=null){
				cr=cr.add(Restrictions.like("e.EquipmentName", details.get("ItemName")));
			}
			mmServiceRequests=cr.add(Restrictions.between("sr.RequestDate", fromDate1, toDate1)).addOrder(Order.asc("Id")).list();	
		}
		}
		map.put("mmServiceRequests", mmServiceRequests);
		return map;
	}
	
	@Override
	public Map<String, Object> getRejectedRquest(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> serviceRequests=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Integer hospitalId=0;
		Integer userId=0;
		String flag = "";
		String[] statusCode={"RJ", "TR", "CR"};
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
		Date fromDate=null;
		Date toDate=null;
		if(details.get("hospitalId")!=null){
			hospitalId=(Integer)details.get("hospitalId");
		}
		if(details.get("hospitalId")!=null){
			userId=(Integer)details.get("userId");
		}
		if(details.get("flag")!=null){
			flag=(String)details.get("flag");
		}
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					/*.createAlias("sr.LastChgBy", "us")*/
					/*.createAlias("sr.ResourceUser", "ru")*/
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.eq("h.Id", hospitalId))
					/*.add(Restrictions.eq("ru.Id", userId))*/
					.add(Restrictions.in("rs.Id", status));
			serviceRequests=cr.list();
		
		}else{
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					/*.createAlias("sr.LastChgBy", "us")*/
					.createAlias("sr.Hospital", "h")
					/*.createAlias("sr.ResourceUser", "ru")*/
					.createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.eq("h.Id", hospitalId))
					/*.add(Restrictions.eq("ru.Id", userId))*/
					.add(Restrictions.in("rs.Id", status));
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("RequestDate", fromDate, toDate));
			}
			if(details.get("WorkOrderNo")!=null){
				cr=cr.add(Restrictions.eq("ServiceRequestNo", (String)details.get("WorkOrderNo")));
			}
			serviceRequests=cr.list();
			System.out.println(" serviceRequests "+serviceRequests.size());
	}
		map.put("serviceRequest", serviceRequests);
		return map;
	}
	
	@Override
	public Map<String, Object> getFeedBack(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> serviceRequests=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Integer hospitalId=0;
		Integer userId=0;
		String flag = "";
		String[] statusCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("pending.service.request.feedback.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
		Date fromDate=null;
		Date toDate=null;
		if(details.get("hospitalId")!=null){
			hospitalId=(Integer)details.get("hospitalId");
		}
		if(details.get("flag")!=null){
			flag=(String)details.get("flag");
		}
		if(details.get("hospitalId")!=null){
			userId=(Integer)details.get("userId");
		}
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.LastChgBy", "us")
					.createAlias("sr.ResourceUser", "ru")
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("ru.Id", userId))
					.add(Restrictions.in("rs.Id", status))
					.add(Restrictions.isNull("FeedbackSatisfaction"));
			serviceRequests=cr.list();
		
		}else{
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.LastChgBy", "us")
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.ResourceUser", "ru")
					.createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("ru.Id", userId))
					.add(Restrictions.in("rs.Id", status))
					.add(Restrictions.isNull("FeedbackSatisfaction"));
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("RequestDate", fromDate, toDate));
			}
			if(details.get("WorkOrderNo")!=null){
				cr=cr.add(Restrictions.eq("ServiceRequestNo", (String)details.get("WorkOrderNo")));
			}
			serviceRequests=cr.list();
	}
		map.put("serviceRequest", serviceRequests);
		return map;
	}
	@Override
	public Map<String, Object> equipmentDashBoard(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
		List<Integer> status=null;
		String[] statusCode={"CL", "SC"};
		status=getMaintenanceId(getMaintenanceStatus(statusCode));
		mmServiceRequest=getServiceRequestDetails(details, status);
		map.put("mmServiceRequest", mmServiceRequest);
		return map;
	}
	
	@Override
	public Map<String, Object> getRequestTrackerDetail(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
		Integer[] status=null;
		mmServiceRequest=getServiceRequestDetails(details, status);
		map.put("mmServiceRequest", mmServiceRequest);
		return map;
	}
	
	@Override
	public Map<String, Object> getCancelRquest(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		String msg="";
		if(details.get("requestId")!=null)
		mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, Integer.parseInt((String)details.get("requestId")));
		Transaction tx=null;
		try{
			tx=getSession().beginTransaction();
			mmMasRequestStatus.setId(20);
			mmServiceRequest.setRequestStatus(mmMasRequestStatus);
			hbt.update(mmServiceRequest);
			tx.commit();
			hbt.flush();
			hbt.clear();
			msg="<span style='color: red'>Request Cancel Successfully</span>";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null)
				tx.rollback();
				msg="<span style='color: red'>Try Again.....</span>";
		}
		map.put("msg", msg);
		return map;
	}
	
	//------  For Get Maitenance Status ------
	
	public List<MmMasRequestStatus> getMaintenanceStatus(String[] statusCode){
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		Session session=(Session)getSession();
		
		Criteria cr=session.createCriteria(MmMasRequestStatus.class);
		if(statusCode!=null){
		if(statusCode.length!=0){
			cr=cr.add(Restrictions.in("StatusCode", statusCode));
		}
		}
		cr=cr.add(Restrictions.eq("Status", "y").ignoreCase());
		mmMasRequestStatus=cr.list();
		return mmMasRequestStatus;
	}
	
	//------------    For Get MasPriorityCode --------
	public List<MasPriorityCodes> getMaintenancePriorityCode(String[] priorityCode){
		List<MasPriorityCodes> masPriorityCodes=new ArrayList<MasPriorityCodes>();
		Session session=(Session)getSession();
		Criteria cr=session.createCriteria(MasPriorityCodes.class);
		if(priorityCode!=null){
		if(priorityCode.length!=0){
			cr=cr.add(Restrictions.in("CodesCode", priorityCode));
		}
		}
		cr=cr.add(Restrictions.eq("Status", "y").ignoreCase());
		masPriorityCodes=cr.list();
		return masPriorityCodes;
	}
	
	//----   For Get Id 
	public List<Integer> getMaintenanceId(List<MmMasRequestStatus> list){
		List<Integer> listId=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			listId.add(list.get(i).getId());
		}
		return listId;
	}
	
	public List<Integer> getMaintenancePriorityId(List<MasPriorityCodes> list){
		List<Integer> listId=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			listId.add(list.get(i).getId());
		}
		return listId;
	}
	
	@Override
	public Map<String, Object> showFeedBackDetails(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
		Integer[] status=null;
		mmServiceRequest=getServiceRequestDetails(details, status);
		map.put("mmServiceRequest", mmServiceRequest);		
		return map;
	}
	
	@Override
	public Map<String, Object> submitFeedBack(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		String msg="";
		if(details.get("requestId")!=null)
		mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, (Integer)details.get("requestId"));
		Transaction tx=null;
		try{
			tx=getSession().beginTransaction();
			if(details.get("FeedBackSatisfaction")!=null){
				mmServiceRequest.setFeedbackSatisfaction((String)details.get("FeedBackSatisfaction"));
			}
			if(details.get("FeedBackCloser")!=null){
				mmServiceRequest.setFeedbackCloser((String)details.get("FeedBackCloser"));
			}
			if(details.get("FeedBackRemark")!=null){
				mmServiceRequest.setFeedbackRemarks((String)details.get("FeedBackRemark"));
			}
			hbt.update(mmServiceRequest);
			tx.commit();
			hbt.flush();
			hbt.clear();
			msg="<span style='color: green'>Thanks For giving FeedBack.</span>";
		}catch(Exception e){
			e.printStackTrace();
			if(tx==null)
				tx.rollback();
				msg="<span style='color: red'>Try Again.....</span>";
		}
		map.put("msg", msg);
		return map;
	}
	
	@Override
	public Map<String, Object> getFeedBackList(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> serviceRequests=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Integer hospitalId=0;
		Integer userId=0;
		String[] statusCode=null;
		String flag = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("feedback.view.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
		Date fromDate=null;
		Date toDate=null;
		if(details.get("hospitalId")!=null){
			hospitalId=(Integer)details.get("hospitalId");
		}
		if(details.get("hospitalId")!=null){
			userId=(Integer)details.get("userId");
		}
		if(details.get("flag")!=null){
			flag=(String)details.get("flag");
		}
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.LastChgBy", "us")
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.eq("h.Id", hospitalId))
					/*.add(Restrictions.eq("us.Id", userId))*/
					.add(Restrictions.in("rs.Id", status))
					.add(Restrictions.isNotNull("FeedbackSatisfaction"));
			serviceRequests=cr.list();
			
		}else{
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.LastChgBy", "us")
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.eq("h.Id", hospitalId))
					/*.add(Restrictions.eq("us.Id", userId))*/
					.add(Restrictions.in("rs.Id", status))
					.add(Restrictions.isNotNull("FeedbackSatisfaction"));
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("RequestDate", fromDate, toDate));
			}
			if(details.get("WorkOrderNo")!=null){
				cr=cr.add(Restrictions.eq("ServiceRequestNo", (String)details.get("WorkOrderNo")));
			}
			serviceRequests=cr.list();
	}
		map.put("serviceRequest", serviceRequests);
		return map;
	}
	
	@Override
	public Map<String, Object> getCondemnationApprovalList(
			Map<String, Object> details) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> serviceRequests=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Integer hospitalId=0;
		Integer userId=0;
		String[] statusCode=null;
		String flag = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("condemnation.pending.approval.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
		Date fromDate=null;
		Date toDate=null;
		if(details.get("hospitalId")!=null){
			hospitalId=(Integer)details.get("hospitalId");
		}
		if(details.get("hospitalId")!=null){
			userId=(Integer)details.get("userId");
		}
		if(details.get("flag")!=null){
			flag=(String)details.get("flag");
		}
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.LastChgBy", "us")
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.RequestStatus", "rs")
					.createAlias("sr.Equipment", "e")
					.createAlias("e.Department", "de")
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("us.Id", userId))
					.add(Restrictions.in("rs.Id", status));
			
			// Added by Amit Das on 30-03-2016
			if(details.get("departmentId")!=null){
				cr.add(Restrictions.eq("de.Id", details.get("departmentId")));
			}
			
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.isNull("KfcFormNo"));

			cr.add(disjunction);
			//	cr.add(Restrictions.or(Restrictions.eq("KfcFormNo", ""), Restrictions.eq("KfcFormNo", null)));
			//	cr.add(Restrictions.eq("KfcFormNo", null));
			
			serviceRequests=cr.list();
			
		}else{
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.LastChgBy", "us")
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.RequestStatus", "rs")
					.createAlias("sr.Equipment", "e")
					.createAlias("e.Department", "de")
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("us.Id", userId))
					.add(Restrictions.in("rs.Id", status));
			
			// Added by Amit Das on 30-03-2016
			if(details.get("departmentId")!=null){
				cr.add(Restrictions.eq("de.Id", details.get("departmentId")));
			}
		//	cr.add(Restrictions.or(Restrictions.eq("KfcFormNo", ""), Restrictions.eq("KfcFormNo", null)));
			//cr.add(Restrictions.eq("KfcFormNo", null));
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.isNull("KfcFormNo"));

			cr.add(disjunction);
			
			
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("RequestDate", fromDate, toDate));
			}
			if(details.get("RequestId")!=null){
				cr=cr.add(Restrictions.eq("ServiceRequestNo", (String)details.get("RequestId")));
			}
			if(details.get("ItemName")!=null){
				cr=cr.createAlias("sr.Equipment", "e").createAlias("e.Item", "i").add(Restrictions.like("i.Nomenclature", (String)details.get("ItemName")).ignoreCase());
			}
			serviceRequests=cr.list();
	}
		map.put("serviceRequest", serviceRequests);
		return map;
	}
	
	@Override
	public Map<String, Object> getCondemnationList(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> serviceRequests=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Integer hospitalId=0;
		Integer userId=0;
		String flag = "";
		String[] statusCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("condemnation.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
		Date fromDate=null;
		Date toDate=null;
		if(details.get("hospitalId")!=null){
			hospitalId=(Integer)details.get("hospitalId");
		}
		if(details.get("flag")!=null){
			flag=(String)details.get("flag");
		}
		if(details.get("hospitalId")!=null){
			userId=(Integer)details.get("userId");
		}
		if(flag.equalsIgnoreCase("all")){
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.LastChgBy", "us")
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("us.Id", userId))
					.add(Restrictions.in("rs.Id", status));
			serviceRequests=cr.list();
		
		}else{
			Criteria cr=getSession().createCriteria(MmServiceRequest.class, "sr")
					.createAlias("sr.LastChgBy", "us")
					.createAlias("sr.Hospital", "h")
					.createAlias("sr.RequestStatus", "rs")
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("us.Id", userId))
					.add(Restrictions.in("rs.Id", status));
			if(details.get("fromDate")!=null && details.get("toDate")!=null){
				try{
					fromDate=sdf.parse((String)details.get("fromDate"));
					toDate=sdf.parse((String)details.get("toDate"));
				}catch(Exception e){e.printStackTrace();}
				cr=cr.add(Restrictions.between("RequestDate", fromDate, toDate));
			}
			if(details.get("RequestId")!=null){
				cr=cr.add(Restrictions.eq("ServiceRequestNo", (String)details.get("RequestId")));
			}
			if(details.get("ItemName")!=null){
				cr=cr.createAlias("sr.Equipment", "e").createAlias("e.Item", "i").add(Restrictions.like("i.Nomenclature", (String)details.get("ItemName")).ignoreCase());
			}
			serviceRequests=cr.list();
	}
		map.put("serviceRequest", serviceRequests);
		return map;
	}
	
	@Override
	public Map<String, Object> approvedCondemnation(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
		List<MmMasRequestStatus> mmMasRequestStatus=new ArrayList<MmMasRequestStatus>();
		String[] statusCode=null;
		Integer[] status=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("condemnation.approval.status.list").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		mmServiceRequest=getServiceRequestDetails(details, status);
		mmMasRequestStatus=getSession().createCriteria(MmMasRequestStatus.class).add(Restrictions.in("StatusCode", statusCode)).add(Restrictions.eq("Status", "y").ignoreCase()).list(); // Added status condition by Amit Das on 29-03-2016
		map.put("mmServiceRequest", mmServiceRequest);
		map.put("mmMasRequestStatus", mmMasRequestStatus);
		return map;
	}
	
	@Override
	public boolean submitCondemnationApproved(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String message="";
		Transaction tx=null;
		boolean flag = false;
		try{
			tx=session.beginTransaction();
			if(details.get("requestId")!=null){
				mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, (Integer)details.get("requestId"));
				if(mmServiceRequest.getEquipment()!=null)
					hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
				if(mmServiceRequest.getAmc()!=null)
					hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getAmc().getEpuipment().getId());
			}
			if(details.get("CondemnationStatus")!=null){
				String[] statusCode={(String)details.get("CondemnationStatus")};
				List<Integer> statusId=getMaintenanceId(getMaintenanceStatus(statusCode));
				mmMasRequestStatus.setId(statusId.get(0));
				mmServiceRequest.setRequestStatus(mmMasRequestStatus);
			}
			if(details.get("CondemnationRemark")!=null){
				mmServiceRequest.setCondemnApprovelRemarks((String)details.get("CondemnationRemark"));
			}
			if(details.get("ReplacementValue")!=null){
				hesEquipmentMaster.setReplacementValue(new BigDecimal((String)details.get("ReplacementValue")));
			}
			hbt.update(mmServiceRequest);
			hbt.flush();
			hbt.clear();
			hbt.update(hesEquipmentMaster);
			hbt.flush();
			hbt.clear();
			tx.commit();
			flag = true;
			//message="<span style='color: green'>Sucessfully Proceed.</span>";
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			//message="<span style='color: red'>Try Again...</span>";
		}
		return flag;
	}
	
	@Override
	public Map<String, Object> submitCondemnation(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		HesEquipmentAmcDetailsEntry hesEquipmentAmcDetailsEntry=new HesEquipmentAmcDetailsEntry();
		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String message="";
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			if(details.get("requestId")!=null){
				mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, (Integer)details.get("requestId"));
				if(mmServiceRequest.getEquipment()!=null){
					hesEquipmentMaster = (HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
				}
				if(mmServiceRequest.getAmc()!=null){
					hesEquipmentAmcDetailsEntry=(HesEquipmentAmcDetailsEntry)hbt.get(HesEquipmentAmcDetailsEntry.class, mmServiceRequest.getAmc().getId());
					hesEquipmentMaster = (HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, hesEquipmentAmcDetailsEntry.getEpuipment().getId());
				}
			}
			
				String[] statusCode=null;
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("maintenance.properties");
				try {
					java.util.Properties prop = new java.util.Properties();
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
					statusCode = prop.getProperty("approved.reject.status.list").split("#");
				} catch (IOException e) {
					e.printStackTrace();
				}
				List<Integer> statusId=getMaintenanceId(getMaintenanceStatus(statusCode));
				mmMasRequestStatus.setId(statusId.get(0));
				mmServiceRequest.setRequestStatus(mmMasRequestStatus);
			if(hesEquipmentMaster.getId()!=null){
				hesEquipmentMaster.setEquipStatus(mmMasRequestStatus);
				hbt.update(hesEquipmentMaster);
				hbt.flush();
				hbt.clear();
			}
			if(details.get("CondemnationRemark")!=null){
				mmServiceRequest.setCondemnRemarks((String)details.get("CondemnationRemark"));
			}
			hbt.update(mmServiceRequest);
			hbt.flush();
			hbt.clear();
			tx.commit();
			message="<span style='color: green'>Sucessfully Proceed.</span>";
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			message="<span style='color: red'>Try Again...</span>";
		}
		map.put("message", message);
		return map;
	}
	
	@Override
	public Map<String, Object> getPerformanceAnalysisList(
			Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
		String[] statusCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			statusCode = prop.getProperty("pending.list.performance.analysis.status").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> status=getMaintenanceId(getMaintenanceStatus(statusCode));
		mmServiceRequest=getServiceRequestDetails(details, status);
		map.put("mmServiceRequest", mmServiceRequest);
		return map;
	}

	@Override
	public Map<String, Object> getAllPendingServiceRequest(
			Map<String, Object> details) {
		Session session=(Session)getSession();
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		if(details.get("hospitalId")!=null){
			hospitalId=Integer.parseInt(details.get("hospitalId").toString());
		}
		Criteria cr=session.createCriteria(MmServiceRequest.class,"sr")
				.createAlias("sr.Equipment", "em")
				.createAlias("sr.RequestStatus", "rs")
				.createAlias("em.Hospital", "h")
				.createAlias("sr.Priority", "pr")
				.createAlias("em.Department", "d")
				.createAlias("sr.LastChgBy", "u")
				//.setProjection(Projections.projectionList().add(Projections.property("sr.Id")).add(Projections.property("sr.RequestDate")).add(Projections.property("sr.ServiceRequestNo")).add(Projections.property("em.EntryNo")).add(Projections.property("em.EquipmentName")).add(Projections.property("pr.CodesName")).add(Projections.property("u.UserName")).add(Projections.property("d.DepartmentName")).add(Projections.property("rs.StatusName")))
				.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("rs.StatusCode", "PN"));
		
		
		mmServiceRequest=cr.list();
		map.put("mmServiceRequest", mmServiceRequest);
		return map;
	}

	@Override
	public Map<String, Object> showAllPendingListOfInspctionJsp(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
		List<MasPriorityCodes> priority=new ArrayList<MasPriorityCodes>();
		List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
//		Integer[] status={2,16};
		String[] statusCode=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("maintenance.properties");
		try {
			java.util.Properties prop = new java.util.Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			if(prop.getProperty("pending.list.inspection.status")!=null)
			statusCode = prop.getProperty("pending.list.inspection.status").split("#");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(details.get("hospitalId")!=null && details.get("hospitalId")!=""){
			hospitalId=(Integer)details.get("hospitalId");
		}
		Criteria cr=session.createCriteria(MmServiceRequest.class, "sr").createAlias("sr.Hospital", "h").createAlias("sr.RequestStatus", "rs")
				.createAlias("sr.Priority", "pr").createAlias("sr.Equipment", "em").createAlias("em.Department", "de")
				.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("RequestDate"));
		if(statusCode!=null){
			cr=cr.add(Restrictions.in("rs.StatusCode", statusCode));
		}
		/*if(details.get("fromDate")!=null && details.get("fromDate")!="" && details.get("toDate")!=null && details.get("toDate")!=""){
			try{
			fromDate=sdf.parse(details.get("fromDate").toString());
			toDate=sdf.parse(details.get("toDate").toString());
			}catch(Exception e){e.printStackTrace();}
			cr=cr.add(Restrictions.between("sr.RequestDate", fromDate, toDate));
		}
		if(details.get("requestId")!=null && details.get("requestId")!=""){
			cr=cr.add(Restrictions.eq("sr.ServiceRequestNo", details.get("requestId")));
		}
		if(details.get("itemCode")!=null && details.get("itemCode")!=""){
			cr=cr.add(Restrictions.eq("em.EntryNo", details.get("itemCode")));
		}
		if(details.get("priority")!=null && details.get("priority")!=""){
			cr=cr.add(Restrictions.eq("pr.Id", Integer.parseInt(details.get("priority").toString())));
		}
		if(details.get("RequestedFrom")!=null && details.get("RequestedFrom")!=""){
			cr=cr.add(Restrictions.eq("de.Id", Integer.parseInt(details.get("RequestedFrom").toString())));
		}*/
		mmServiceRequests=cr.list();
		priority=session.createCriteria(MasPriorityCodes.class).add(Restrictions.eq("Status", "y")).list();
		departmentList=session.createCriteria(MasDepartment.class,"d").createAlias("d.Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("d.DepartmentName")).list();
		map.put("mmServiceRequests", mmServiceRequests);
		map.put("priority", priority);
		map.put("departmentList", departmentList);
		return map;
	}

	@Override
	public Map<String, Object> getVendorAddress(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		List<MasStoreSupplier> supplierList=new ArrayList<MasStoreSupplier>();
		int vendorId = 0;
		if(details.get("vendorId") != null){
			vendorId = (Integer)details.get("vendorId");
		}
		supplierList = session.createCriteria(MasStoreSupplier.class).add(Restrictions.idEq(vendorId)).list();
		map.put("supplierList", supplierList);
		return map;
	}

	@Override
	public Map<String, Object> showInstituteHeadApproval(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<String>kfcFormList = null;
		
		Session session = (Session)getSession();
		String statusCode = "CND";
		
		kfcFormList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
							.createAlias("RequestStatus", "rs").add(Restrictions.eq("rs.StatusCode", statusCode)).add(Restrictions.isNotNull("KfcFormNo"))
								.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("KfcFormNo")))).list();
		
		
		
		map.put("kfcFormList", kfcFormList);
		return map;
	}

	@Override
	public Map<String, Object> displayEquipmentDetail(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest> mmServiceRequestList = new ArrayList<MmServiceRequest>();
		List<MmMasRequestStatus> mmMasRequestList = new ArrayList<MmMasRequestStatus>();
		// List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<String> kfcFormList = new ArrayList<String>();
		List<MasHospitalType> instituteTypeList = null; // added by amit das on 24-10-2016
		
		Session session = (Session)getSession();
		String statusCode[] ={"IHA","IHR"};
		String status = "CND";
		
		mmServiceRequestList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("KfcFormNo", box.getString("kfcFormNo"))).list();
		mmMasRequestList = session.createCriteria(MmMasRequestStatus.class).add(Restrictions.in("StatusCode", statusCode)).list();
		// employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		kfcFormList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.createAlias("RequestStatus", "rs").add(Restrictions.eq("rs.StatusCode", status)).add(Restrictions.isNotNull("KfcFormNo"))
					.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("KfcFormNo")))).list();
		// added by amit das on 24-10-2016
		instituteTypeList = session.createCriteria(MasHospitalType.class).add(Restrictions.eq("Status","y").ignoreCase()).list();


		
		map.put("kfcFormList", kfcFormList);
		map.put("mmServiceRequestList", mmServiceRequestList);
		map.put("mmMasRequestList", mmMasRequestList);
		// map.put("employeeList", employeeList);
		map.put("instituteTypeList", instituteTypeList);
		return map;
	}

	
	@Override
	public Map<String, Object> displayInstitueEmployee(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasEmployee> employeeList = null;
		Session session = (Session)getSession();
		
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("Status", "y").ignoreCase()).list();

		map.put("employeeList", employeeList);
		return map;
	}
	
	
	@Override
	public Map<String, Object> displayInstitues(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MasInstitute> instituteList = null;
		Session session = (Session)getSession();
		
		instituteList = session.createCriteria(MasHospital.class).add(Restrictions.eq("HospitalType.Id",box.getInt("hospitalTypeId"))) .add(Restrictions.eq("Status","y").ignoreCase()).list();
		
		map.put("instituteList", instituteList);
		return map;
	}
	
	@Override
	public Map<String, Object> submitInstituteHeadApproval(Box box,Map<String, Object> generalMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		List condemnationComiteeIdList = new ArrayList();
		String msg="";
		String commiteeName = null;
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
		int count = 0;
		if(box.getInt("count") != 0){
			count = box.getInt("count");
		}
		if(generalMap.get("condemnationComiteeIdList") != null){
			condemnationComiteeIdList=(List)generalMap.get("condemnationComiteeIdList");
		}
		if(box.get("commiteeName") != null && !box.get("commiteeName").trim().equals("")){
			commiteeName = box.get("commiteeName");
		}
		
		
		for(int i=1;i<=count;i++){
			if(box.getInt("mmServiceRequestId"+i) != 0){
			MmServiceRequest mmServiceRequest=(MmServiceRequest) hbt.load(MmServiceRequest.class, box.getInt("mmServiceRequestId"+i));
			if(box.getInt("headApprovalStatus"+i) != 0){
				MmMasRequestStatus mmMasRequestStatus = new MmMasRequestStatus();
				mmMasRequestStatus.setId(box.getInt("headApprovalStatus"+i));
				mmServiceRequest.setRequestStatus(mmMasRequestStatus);
			}
			hbt.update(mmServiceRequest);
			}
		}
		
		if(commiteeName!=null){
			MmCondemnationCommitee mmCondemnationCommitee = new MmCondemnationCommitee();
			mmCondemnationCommitee.setName(commiteeName);
			mmCondemnationCommitee.setFormNo(box.getString("kfcFormNo"));
			hbt.save(mmCondemnationCommitee);
			
		if(condemnationComiteeIdList.size()>0){
			for(int j=0;j<condemnationComiteeIdList.size();j++){
				MmCondemnationCommiteeMembers mmCondemnationCommiteeMembers = new MmCondemnationCommiteeMembers();
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt(condemnationComiteeIdList.get(j).toString()));
				mmCondemnationCommiteeMembers.setEmployee(masEmployee);
				mmCondemnationCommiteeMembers.setCondemnationCommitee(mmCondemnationCommitee);
				hbt.save(mmCondemnationCommiteeMembers);
			 }
			}
		}
		
		flag = true;
		
		
		if(tx!=null && !tx.wasCommitted())
			tx.commit();
		
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			
		}
		
		map.put("flag", flag);
		return map;
	}
	
	
	// added By Amit Das on 30-03-2016
	@Override
	public Map<String, Object> approveCondemnationFromDepartment(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
		MmServiceRequest mmServiceRequest=new MmServiceRequest();
		HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String message="";
		String kfcFormNo= null;
		Transaction tx=null;
		boolean flag = false;
		boolean kfcflag = true;
		Criteria criteria = null;
		int serviceCount = box.getInt("serviceCount");
		try{
			tx=session.beginTransaction();
			SecureRandom random = new SecureRandom();
				
			while(kfcflag){
				kfcFormNo =	new BigInteger(20, random).toString(10);
				criteria = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("KfcFormNo", kfcFormNo));
				if(criteria.list().size()==0){
					kfcflag = false;
				}
			}
			
			for(int i = 0; i <serviceCount; i++){
				
			if((box.get("requestCheck"+i)!=null && box.get("requestCheck"+i).trim().equalsIgnoreCase("on")) && box.get("serviceDetailId"+i)!=null){
				
				mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, box.getInt("serviceDetailId"+i));
				if(mmServiceRequest!=null && mmServiceRequest.getEquipment()!=null)
					hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
				if(mmServiceRequest!=null && mmServiceRequest.getAmc()!=null)
					hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getAmc().getEpuipment().getId());

				mmServiceRequest.setKfcFormNo(kfcFormNo);
				hbt.update(mmServiceRequest);
				hbt.flush();
				hbt.clear();
				hbt.update(hesEquipmentMaster);
				
			 }	
			}
			hbt.flush();
			hbt.clear();
			tx.commit();
			flag = true;	
			message="<span style='color: green'>Sucessfully Proceed.</span>";
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			message="<span style='color: red'>Try Again...</span>";
		}
		map.put("message", message);
		return map;
	}

	@Override
	public Map<String, Object> showAuctionApprovalJsp(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<String>kfcFormList = new ArrayList<String>();
		Session session = (Session)getSession();
		String statusCode = "CNMD";
		kfcFormList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
							.createAlias("RequestStatus", "rs").add(Restrictions.eq("rs.StatusCode", statusCode)).add(Restrictions.isNotNull("KfcFormNo"))
								.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("KfcFormNo")))).list();
		map.put("kfcFormList", kfcFormList);
		return map;
	}

	@Override
	public Map<String, Object> displayAuctionDetail(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmServiceRequest>mmServiceRequestList = new ArrayList<MmServiceRequest>();
		List<String>kfcFormList = new ArrayList<String>();
		Session session = (Session)getSession();
		String status = "CNMD";
		mmServiceRequestList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("KfcFormNo", box.getString("kfcFormNo"))).list();
		kfcFormList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.createAlias("RequestStatus", "rs").add(Restrictions.eq("rs.StatusCode", status)).add(Restrictions.isNotNull("KfcFormNo"))
					.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("KfcFormNo")))).list();
		map.put("kfcFormList", kfcFormList);
		map.put("mmServiceRequestList", mmServiceRequestList);
		return map;
	}

	@Override
	public Map<String, Object> addPartyDetail(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmAuctionParticipent> mmAutionParticipentList = new ArrayList<MmAuctionParticipent>();
		Session session = (Session)getSession();
		mmAutionParticipentList = session.createCriteria(MmAuctionParticipent.class).add(Restrictions.eq("Request.Id", box.getInt("requestId")))
									.list();
		Map<String, Object>	map2 = getMaxAmountBid(box);
		map.putAll(map2); 
		
		map.put("mmAutionParticipentList", mmAutionParticipentList);
		return map;
	}

	@Override
	public Map<String, Object> savePartyAuctionDetail(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<MmAuctionParticipent> mmAutionParticipentList = new ArrayList<MmAuctionParticipent>();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		try{
		int count = 0;
		if(box.getInt("hdb") != 0){
			count = box.getInt("hdb");
		}
		for(int i=1;i<=count;i++){
			MmAuctionParticipent mmAuctionParticipent = new MmAuctionParticipent();
			
			if(box.getInt("serviceId"+i) != 0){
				MmServiceRequest mmServiceRequest = new MmServiceRequest();
				mmServiceRequest.setId(box.getInt("serviceId"+i));
				mmAuctionParticipent.setRequest(mmServiceRequest);
			}
			
			if(!box.getString("partyName"+i).equals("")){
				mmAuctionParticipent.setPartyName(box.getString("partyName"+i));
			}
			if(!box.getString("amount"+i).equals("")){
				mmAuctionParticipent.setAmount(new BigDecimal(box.getString("amount"+i)));
			}
			if(!box.getString("formNo"+i).equals("")){
				mmAuctionParticipent.setFormNo(box.getString("formNo"+i));
			}
			hbt.save(mmAuctionParticipent);
			flag = true;
			
		}
		
		Map<String, Object>	map2 = getMaxAmountBid(box);
		map.putAll(map2);
		mmAutionParticipentList = session.createCriteria(MmAuctionParticipent.class).add(Restrictions.eq("Request.Id", box.getInt("requestId")))
									.list();
		map.put("mmAutionParticipentList", mmAutionParticipentList);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		map.put("flag", flag);
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	   // added By Amit Das on 31-03-2016
		@Override
		public Boolean approveCondemnationFromCommitte(Box box) {
			Map<String, Object> map=new HashMap<String, Object>();
			MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
			MmServiceRequest mmServiceRequest=new MmServiceRequest();
			HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
			Session session=(Session)getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			String message="";
			Transaction tx=null;
			boolean flag = false;
			Criteria criteria = null;
			int serviceCount = box.getInt("serviceCount");
			try{
				tx=session.beginTransaction();
				String[] statusCode=null;
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("maintenance.properties");
				try {
					java.util.Properties prop = new java.util.Properties();
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
					statusCode = prop.getProperty("approved.reject.status.list").split("#");
				} catch (IOException e) {
					e.printStackTrace();
				}
				List<Integer> statusId=getMaintenanceId(getMaintenanceStatus(statusCode));
				
				for(int i = 0; i <serviceCount; i++){
					
				if((box.get("requestCheck"+i)!=null && box.get("requestCheck"+i).trim().equalsIgnoreCase("on")) && box.get("serviceDetailId"+i)!=null){
					
					mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, box.getInt("serviceDetailId"+i));
					if(mmServiceRequest!=null && mmServiceRequest.getEquipment()!=null)
						hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
					if(mmServiceRequest!=null && mmServiceRequest.getAmc()!=null)
						hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getAmc().getEpuipment().getId());
					
					
					mmMasRequestStatus.setId(statusId.get(0));
					mmServiceRequest.setRequestStatus(mmMasRequestStatus);
					
				if(box.get("remarks"+i)!=null){
						mmServiceRequest.setCondemnRemarks(box.get("remarks"+i));
				}
				
				if(box.get("replacementValue"+i)!=null){
						hesEquipmentMaster.setReplacementValue(new BigDecimal((String)box.get("replacementValue"+i)));
				}
				
				if(hesEquipmentMaster.getId()!=null){
					hesEquipmentMaster.setEquipStatus(mmMasRequestStatus);
					hbt.update(hesEquipmentMaster);
					hbt.flush();
					hbt.clear();
				}
					
					hbt.update(mmServiceRequest);
					hbt.flush();
					hbt.clear();
					
				 }	
				}
				if(tx!=null && !tx.wasCommitted())
					tx.commit();
				
				flag = true;
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
				flag = false;
			}
			return flag;
		}
	
		// added by Amit das on 31-03-2016
		@Override
		public Map<String, Object> displayEquipmentDetailForCommitee(Box box) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<MmServiceRequest>mmServiceRequestList = new ArrayList<MmServiceRequest>();
			List<String>kfcFormList = new ArrayList<String>();
			Session session = (Session)getSession();
			String statusCode[] ={"IHA","IHR"};
			String status = "IHA";
			mmServiceRequestList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("KfcFormNo", box.getString("kfcFormNo")))
									.createAlias("RequestStatus", "rs")
									.add(Restrictions.eq("rs.StatusCode", status)).list();
			
			String[] statusCodes=null;
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("maintenance.properties");
			try {
				java.util.Properties prop = new java.util.Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				statusCodes = prop.getProperty("approved.reject.status.list").split("#");
			} catch (IOException e) {
				e.printStackTrace();
			}
			List<Integer> statusId=getMaintenanceId(getMaintenanceStatus(statusCodes));
			

			if(statusId!=null && statusId.size()>0){	
			List list	= session.createSQLQuery("Select distinct(form_no) from mm_condemnation_commitee mcc join mm_service_request msr on msr.kfc_form_no = mcc.form_no "+ 
												"join mm_mas_request_status mrs on msr.request_status =  mrs.status_id "+
												"where mrs.status_id != :statusId")
												.setParameter("statusId", statusId.get(0))
												.list();
			for(Object object : list){
	            kfcFormList.add((String)object);
	          } 
			}
			
			map.put("kfcFormList", kfcFormList);
			map.put("serviceRequest", mmServiceRequestList);
			
			return map;
		}
		
		// added by Amit Das on 31-03-2016
		@Override
		public Map<String, Object> showCommiteeApproval(Box box) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<String>kfcFormList = new ArrayList<String>();
			Session session = (Session)getSession();
			
			String[] statusCode=null;
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("maintenance.properties");
			try {
				java.util.Properties prop = new java.util.Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				statusCode = prop.getProperty("approved.reject.status.list").split("#");
			} catch (IOException e) {
				e.printStackTrace();
			}
			List<Integer> statusId=getMaintenanceId(getMaintenanceStatus(statusCode));
			
			if(statusId!=null && statusId.size()>0){	
			List list	= session.createSQLQuery("Select distinct(form_no) from mm_condemnation_commitee mcc join mm_service_request msr on msr.kfc_form_no = mcc.form_no "+ 
												"join mm_mas_request_status mrs on msr.request_status =  mrs.status_id "+
												"where mrs.status_id != :statusId")
												.setParameter("statusId", statusId.get(0))
												.list();
			for(Object object : list){
	            kfcFormList.add((String)object);
	           }
			}
			
			map.put("kfcFormList", kfcFormList);
			return map;
		}
		
		// added by Amit Das on 31-03-2016
				@Override
				public Map<String, Object> getMaxAmountBid(Box box) {
					Map<String, Object> map=new HashMap<String, Object>();
					List<Object[]>maxAuctionParticipentList  = new ArrayList<Object[]>();
					Session session = (Session)getSession();
					
					maxAuctionParticipentList = session.createCriteria(MmAuctionParticipent.class).add(Restrictions.eq("Request.id", box.getInt("requestId")))
										 .setProjection(Projections.projectionList().add(Projections.max("Amount")).add(Projections.groupProperty("PartyName"))).setMaxResults(1).list();
					map.put("maxAuctionParticipentList", maxAuctionParticipentList);
					
					
					return map;
				}
				
				 // added By Amit Das on 31-03-2016
				@Override
				public Map<String, Object> submitAuctionDetails(Box box) {
					Map<String, Object> map=new HashMap<String, Object>();
					List<String>kfcFormList = new ArrayList<String>();
					MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
					MmServiceRequest mmServiceRequest=new MmServiceRequest();
					HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
					Session session=(Session)getSession();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_AUTO");
					hbt.setCheckWriteOperations(false);
					String message="";
					Transaction tx=null;
					boolean flag = false;
					Criteria criteria = null;
					int serviceCount = box.getInt("count");
					try{
						
						for(int i = 1; i <serviceCount; i++){
							
							mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, box.getInt("mmServiceRequestId"+i));
							/*if(mmServiceRequest!=null && mmServiceRequest.getEquipment()!=null)
								hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
							if(mmServiceRequest!=null && mmServiceRequest.getAmc()!=null)
								hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getAmc().getEpuipment().getId());
							
							*/
							
							// mmServiceRequest.setRequestStatus(mmMasRequestStatus);
							
						
						if(box.get("highestAmount"+i)!=null){
							mmServiceRequest.setMaxBidAmount(new BigDecimal(box.get("highestAmount"+i)));
						}
						
						/*if(hesEquipmentMaster.getId()!=null){
							hesEquipmentMaster.setEquipStatus(mmMasRequestStatus);
							hbt.update(hesEquipmentMaster);
							hbt.flush();
							hbt.clear();
						}*/
							
							hbt.update(mmServiceRequest);
							hbt.flush();
							hbt.clear();
						
						}
						
						String status = "CNMD";
						kfcFormList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
								.createAlias("RequestStatus", "rs").add(Restrictions.eq("rs.StatusCode", status)).add(Restrictions.isNotNull("KfcFormNo"))
									.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("KfcFormNo")))).list();
						map.put("kfcFormList", kfcFormList);
						
						if(tx!=null && !tx.wasCommitted())
						tx.commit();
						
						flag = true;
					}catch(Exception e){
						e.printStackTrace();
						if(tx!=null)
						tx.rollback();
						
						flag = false;
					}
					return map;
				}
				
				
				 // added By Amit Das on 04-04-2016
				@Override
				public Map<String, Object> submitReauctionDetails(Box box) {
					Map<String, Object> map=new HashMap<String, Object>();
					List<String> kfcFormList = new ArrayList<String>();
					MmMasRequestStatus mmMasRequestStatus=new MmMasRequestStatus();
					MmServiceRequest mmServiceRequest=new MmServiceRequest();
					HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
					Session session=(Session)getSession();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					StringBuffer oldAuctionDetails = null;
					hbt.setFlushModeName("FLUSH_AUTO");
					hbt.setCheckWriteOperations(false);
					String message="";
					Transaction tx=null;
					boolean flag = false;
					Criteria criteria = null;
					int serviceCount = box.getInt("count");
					try{
						
						String[] statusCode=null;
						String[] equimentStatusCode = null;
						URL resourcePath = Thread.currentThread().getContextClassLoader()
								.getResource("maintenance.properties");
						try {
							java.util.Properties prop = new java.util.Properties();
							prop.load(new FileInputStream(new File(resourcePath.getFile())));
							statusCode = prop.getProperty("maintinence.pending").split("#");
							equimentStatusCode = prop.getProperty("create.reauction.list").split("#");
						} catch (IOException e) {
							e.printStackTrace();
						}
						List<Integer> statusId=getMaintenanceId(getMaintenanceStatus(statusCode));
						
						tx = session.beginTransaction();
						for(int i = 1; i <serviceCount; i++){
							
							if((box.get("requestCheck"+i)!=null && box.get("requestCheck"+i).trim().equalsIgnoreCase("on")) && box.getInt("mmServiceRequestId"+i)!=0){
							oldAuctionDetails = new StringBuffer();  
							mmServiceRequest=(MmServiceRequest)hbt.get(MmServiceRequest.class, box.getInt("mmServiceRequestId"+i));
							
							// added by Amit Das on 25-04-2016
							if(mmServiceRequest.getEquipment()!=null)
								hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getEquipment().getId());
							if(mmServiceRequest.getAmc()!=null)
								hesEquipmentMaster=(HesEquipmentMaster)hbt.get(HesEquipmentMaster.class, mmServiceRequest.getAmc().getEpuipment().getId());
							
							
							oldAuctionDetails.append("Last Max Bid - "+mmServiceRequest.getMaxBidAmount()+"\n");
							oldAuctionDetails.append("Department - "+mmServiceRequest.getEquipment().getDepartment().getDepartmentName()+"\n");
							oldAuctionDetails.append("Condemnation Remarks - "+mmServiceRequest.getCondemnRemarks()+"\n");
							oldAuctionDetails.append("Condemnation Aprrove Remarks - "+mmServiceRequest.getCondemnApprovelRemarks()+"\n");
							oldAuctionDetails.append("KFC Form No - "+mmServiceRequest.getKfcFormNo());
							mmServiceRequest.setLastAuctionDetails(oldAuctionDetails.toString());
							mmServiceRequest.setMaxBidAmount(new BigDecimal(0));
							mmServiceRequest.setForwardDepartment(null);
							mmServiceRequest.setCondemnRemarks("");
							mmServiceRequest.setCondemnApprovelRemarks("");
							mmServiceRequest.setKfcFormNo("");
							
							mmMasRequestStatus.setId(statusId.get(0));
					 		mmServiceRequest.setRequestStatus(mmMasRequestStatus);
							
					 		if(hesEquipmentMaster!=null){
								hesEquipmentMaster.setStatus(equimentStatusCode[0]);
								hbt.update(hesEquipmentMaster);
							}
							
					 		
							hbt.update(mmServiceRequest);
							hbt.flush();
							hbt.clear();
						}
						
						}
						
						String status = "CNMD";
						kfcFormList = session.createCriteria(MmServiceRequest.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
								.createAlias("RequestStatus", "rs").add(Restrictions.eq("rs.StatusCode", status)).add(Restrictions.isNotNull("KfcFormNo"))
									.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("KfcFormNo")))).list();
						map.put("kfcFormList", kfcFormList);
						
						if(tx!=null && !tx.wasCommitted())
						tx.commit();
						
						flag = true;	
						message="<span style='color: green'>Sucessfully Proceed.</span>";
					}catch(Exception e){
						e.printStackTrace();
						tx.rollback();
						flag = false;
						message="<span style='color: red'>Try Again...</span>";
					}
					map.put("message", message);
					return map;
				}
		
				@Override
				public Map<String, Object> deleteAttachFiles(Map<String, Object> generalMap) {
					Map<String, Object> map = new HashMap<String, Object>();
					
					List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
					Session session = (Session) getSession();

					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					Integer requestId = 0;
					Integer ticketAttachId = 0;
					int documentId = 0;
					if (generalMap.get("documentId") != null) {
						documentId = (Integer) generalMap.get("documentId");
					}
					if(documentId!=0){
						UploadDocuments uploadDocument = (UploadDocuments) hbt.load(UploadDocuments.class, documentId);
						//uploadDocument.setStatus("n");
						//requestId = uploadDocument.getRequest().getId();
						//hbt.saveOrUpdate(uploadDocument);
						hbt.update(uploadDocument);
						hbt.flush();
						hbt.clear();
						hbt.delete(uploadDocument);
						int hinId=0;
						if(uploadDocument.getHin()!=null){
							//requestId = uploadDocument.getRequest().getId();
							hinId = uploadDocument.getHin().getId();
							uploadDocuments = session.createCriteria(UploadDocuments.class, "ud")
									.createAlias("ud.Hin", "r")
									.add(Restrictions.eq("r.Id", hinId))
									//.add(Restrictions.or(Restrictions.eq("Status", "y").ignoreCase(), Restrictions.isNull("Status")))
									.list();
						}
					}
					
					map.put("uploadDocuments", uploadDocuments);
					return map;
				}
}
