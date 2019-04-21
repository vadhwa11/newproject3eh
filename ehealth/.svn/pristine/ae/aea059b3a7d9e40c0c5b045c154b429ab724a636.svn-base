package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.USER_ID;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import jkt.hms.masters.business.AppEquipmentMaster;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCharityType;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasModularity;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.OpdInstructionTreatment;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OpdTemplateInvestigation;
import jkt.hms.masters.business.OpdTemplateTreatment;
import jkt.hms.masters.business.OpdVaccinMst;
import jkt.hms.masters.business.PrescriptionMapping;
import jkt.hms.masters.business.RouteOfAdministration;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.MasInstitute;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OPDMasterDataServiceImpl extends HibernateDaoSupport implements
		OPDMasterDataService {
	
	
	Properties properties = new Properties();{
		try{
					ClassLoader loader =getClass().getClassLoader();
					InputStream inStream = loader.getResourceAsStream("stores.properties");
			        properties.load(inStream);
			        }catch (IOException e) {
			    	//
			    	e.printStackTrace();
			       }
		}

	// ****************************************** Start Of OPD Template by Mansi
	// ****************************//
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdTemplate(String templateCode,
			String templateName) {
		List<OpdTemplate> searchOpdTemplateList = new ArrayList<OpdTemplate>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		Map<String, Object> opdTemplateFieldsMap = new HashMap<String, Object>();
		try {
			if ((templateName != null) || (templateCode == null)) {

				searchOpdTemplateList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.OpdTemplate imc where imc.TemplateName like '"
								+ templateName + "%' order by imc.TemplateName");
			} else {
				searchOpdTemplateList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.OpdTemplate imc where imc.TemplateCode like '"
								+ templateCode + "%' order by imc.TemplateCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id='1'and mm.Status ='y' order by mm.DepartmentName");
		opdTemplateFieldsMap.put("departmentList", departmentList);
		opdTemplateFieldsMap
				.put("searchOpdTemplateList", searchOpdTemplateList);
		return opdTemplateFieldsMap;
	}

	public boolean addOpdTemplate(OpdTemplate opdTemplate) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdTemplate);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteOpdTemplate(int templateId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdTemplate opdTemplate = new OpdTemplate();
		opdTemplate = (OpdTemplate) getHibernateTemplate().get(
				OpdTemplate.class, templateId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdTemplate.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdTemplate.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=(Users)generalMap.get("users");
		opdTemplate.setLastChgBy(users);
		opdTemplate.setLastChgDate(currentDate);
		opdTemplate.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdTemplate);
		return dataDeleted;
	}

	public boolean editOpdTemplateToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String templateName = "";
		@SuppressWarnings("unused")
		String templateCode = "";
		int templateId = 0;
		int departmentId = 0;
		String templateType = "";
		String changedBy = "";
		 String instituteTemplateType = "";
		 int hospitalId = 0;
		try {
			templateId = (Integer) generalMap.get("id");
			templateCode = (String) generalMap.get("templateCode");
			templateName = (String) generalMap.get("name");
			departmentId = (Integer) generalMap.get("departmentId");
			if(generalMap.get("instituteTemplateType") != null){
				instituteTemplateType = (String)generalMap.get("instituteTemplateType");
			}
			templateType = (String) generalMap.get("templateType");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			hospitalId = (Integer)generalMap.get("hospitalId");
		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdTemplate opdTemplate = (OpdTemplate) getHibernateTemplate().get(
				OpdTemplate.class, templateId);

		opdTemplate.setId(templateId);
		opdTemplate.setTemplateName(templateName);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		opdTemplate.setDepartment(masDepartment);
		if(instituteTemplateType.equals("local")){
			if (hospitalId != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				opdTemplate.setHospital(masHospital);
			}
		}


		opdTemplate.setTemplateType(templateType);
	//	opdTemplate.setLastChgBy(changedBy);
		opdTemplate.setLastChgDate(currentDate);
		opdTemplate.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdTemplate);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdTemplateJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdTemplate> searchOpdTemplateList = new ArrayList<OpdTemplate>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasInstituteDepartment> masDepartmentList = new ArrayList<MasInstituteDepartment>();
		Session session=(Session)getSession();
		searchOpdTemplateList = session.createCriteria(OpdTemplate.class).list();
		
		departmentList =  session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "Y").ignoreCase())
				.addOrder(Order.asc("DepartmentName"))
				.createAlias("DepartmentType", "dType").add(Restrictions.eq("dType.Id",1)).list();
		
		
		//masDepartmentList =  session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		masDepartmentList =  session.createCriteria(MasInstituteDepartment.class)
				.addOrder(Order.asc("Description"))
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.createAlias("Institute", "h")
				.add(Restrictions.eq("h.Id",hospitalId))
				// .createAlias("Department", "d")
				 //.setProjection( Projections.distinct(Projections.property( "d.Id" )))
                 	.list();
		map.put("searchOpdTemplateList", searchOpdTemplateList);
		map.put("departmentList", departmentList);
		map.put("masDepartmentList", masDepartmentList);
		return map;
	}

	// ****************************************** End Of OPD Template by Mansi
	// ****************************//

	// //****************************************** Start Of OPD Treatment
	// Template by Mansi ****************************//

	public boolean addOpdHoliday(OpdHoliday opdHoliday) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdHoliday);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean deleteOpdHoliday(int holidayId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdHoliday opdHoliday = new OpdHoliday();
		opdHoliday = (OpdHoliday) getHibernateTemplate().get(OpdHoliday.class,
				holidayId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdHoliday.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdHoliday.setStatus("y");
				dataDeleted = false;
			}
		}
		opdHoliday.setLastChgBy(changedBy);
		opdHoliday.setLastChgDate(currentDate);
		opdHoliday.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdHoliday);
		return dataDeleted;
	}

	public boolean editOpdHolidayToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String holidayName = "";
		@SuppressWarnings("unused")
		String holidayCode = "";
		int holidayId = 0;
		Date holidayDate = new Date();
		String changedBy = "";
		int hospitalId=0;
		try {
			holidayId = (Integer) generalMap.get("id");
			holidayCode = (String) generalMap.get("holidayCode");
			holidayName = (String) generalMap.get("name");
			holidayDate = (Date) generalMap.get("holidayDate");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			hospitalId = (Integer) generalMap.get("hospitalId");

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdHoliday opdHoliday = (OpdHoliday) getHibernateTemplate().get(
				OpdHoliday.class, holidayId);

		opdHoliday.setId(holidayId);
		opdHoliday.setHolidayName(holidayName);
		opdHoliday.setHolidayDate(holidayDate);
		opdHoliday.setLastChgBy(changedBy);
		opdHoliday.setLastChgDate(currentDate);
		opdHoliday.setLastChgTime(currentTime);

		  MasHospital hospital = new MasHospital();
		  hospital.setId(hospitalId);
		  opdHoliday.setHospital(hospital);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdHoliday);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdHoliday(String holidayCode,
			String holidayName) {
		List<OpdHoliday> searchOpdHolidayList = new ArrayList<OpdHoliday>();

		Map<String, Object> opdHolidayFieldsMap = new HashMap<String, Object>();
		try {
			if ((holidayName != null) || (holidayCode == null)) {

				searchOpdHolidayList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.OpdHoliday imc where imc.HolidayName like '"
								+ holidayName + "%' order by imc.HolidayName");
			} else {
				searchOpdHolidayList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.OpdHoliday imc where imc.HolidayCode like '"
								+ holidayCode + "%' order by imc.HolidayCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdHolidayFieldsMap.put("searchOpdHolidayList", searchOpdHolidayList);
		return opdHolidayFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdHolidayJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdHoliday> searchOpdHolidayList = new ArrayList<OpdHoliday>();
		searchOpdHolidayList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdHoliday ");
		map.put("searchOpdHolidayList", searchOpdHolidayList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdTemplateTreatmentJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdTemplateTreatment> searchOpdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<OpdInstructionTreatment> opdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();
		Session session=(Session)getSession();
		searchOpdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class).list();
		opdTemplateList = getSession().createCriteria(OpdTemplate.class).add(Restrictions.eq("TemplateType", "P").ignoreCase())
				.add(Restrictions.eq("Status", "Y").ignoreCase())//.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("templateLocal", box.getInt("changedBy")))//Added By Om Tripathi 5/2/2018
				.list();
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "Y").ignoreCase()).createAlias("DepartmentType", "dType")
				.add(Restrictions.eq("dType.Id",1)).addOrder(Order.asc("DepartmentName")).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status","Y").ignoreCase()).list(); 
		opdInstructionTreatmentList = session.createCriteria(OpdInstructionTreatment.class).add(Restrictions.eq("Status","Y").ignoreCase()).list();
		map.put("opdTemplateList", opdTemplateList);
		map.put("departmentList", departmentList);
		map.put("searchOpdTemplateTreatmentList",searchOpdTemplateTreatmentList);
		map.put("frequencyList", frequencyList);
		map.put("opdInstructionTreatmentList", opdInstructionTreatmentList);
		return map;
	}

	public boolean addOpdTemplateTreatment(
			OpdTemplateTreatment opdTemplateTreatment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdTemplateTreatment);
		successfullyAdded = true;
		return successfullyAdded;
	}
	
	public boolean deleteTemplateTreatment(
			Map generalMap) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session=(Session)getSession();
		int templateId=0;
		int hospitalId=0;
		int departmentId=0;
		int changedBy=0;
		Date currentDate = new Date();
		if(generalMap.get("templateId")!=null){
			templateId = Integer.parseInt(generalMap.get("templateId").toString());			
		}/*if(generalMap.get("hospitalId")!=null){
			 hospitalId =Integer.parseInt(generalMap.get("hospitalId").toString());
		}if(generalMap.get("departmentId")!=null){
			departmentId =Integer.parseInt(generalMap.get("departmentId").toString());
		}*/if(generalMap.get("changedBy")!=null){
			changedBy =Integer.parseInt(generalMap.get("changedBy").toString());
		}
		try{
			OpdTemplate opdtemplate = (OpdTemplate) session.get(OpdTemplate.class,new Integer(templateId));
			
			if(opdtemplate!=null){
				OpdTemplateTreatment opdTemplateTreatment=null;
				if(opdtemplate.getId()!=null){
					@SuppressWarnings("unchecked")
					List<OpdTemplateTreatment> opdtemplateTreatment = session.createCriteria(OpdTemplateTreatment.class).createAlias("Template", "temp").add(Restrictions.eq("temp.Id",  opdtemplate.getId())).list();
					if(opdtemplateTreatment.size()>0){
						for(int i = 1;i<opdtemplateTreatment.size();i++){
							opdTemplateTreatment =(OpdTemplateTreatment)session.get(OpdTemplateTreatment.class,opdtemplateTreatment.get(i).getId());
							opdTemplateTreatment.setStatus("n");
							Users user=new Users();
							user.setId(changedBy);
							opdTemplateTreatment.setLastChgBy(user);
							opdTemplateTreatment.setLastChgDate(new Date());
							hbt.update(opdTemplateTreatment);
							hbt.flush();
						}
					}
				}
				
				opdtemplate.setStatus("n");
				Users users = new Users();
				users.setId(changedBy);
				opdtemplate.setLastChgBy(users);
				opdtemplate.setLastChgDate(currentDate);
				hbt.update(opdtemplate);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteOpdTemplateTreatment(int templateTreatmentId,
			Map<String, Object> generalMap) {
		List<OpdTemplate>templateList = new ArrayList<OpdTemplate>();
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String currentTime = "";
		int userType = 0;
		int templateId = 0;
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		if(generalMap.get("userType") != null){
			userType=(Integer)generalMap.get("userType");
		}
		if(generalMap.get("templateId") != null){
			templateId=(Integer)generalMap.get("templateId");
		}
		Session session = (Session)getSession();
		OpdTemplateTreatment opdTemplateTreatment = new OpdTemplateTreatment();
		templateList = session.createCriteria(OpdTemplate.class).add(Restrictions.idEq(templateId)).list();
		if(templateList.size()>0){
		if( templateList.get(0).getHospital() != null && templateList.get(0).getHospital().getId()!=null && !templateList.get(0).getHospital().getId().equals("")){	
			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equalsIgnoreCase("InActivate")) {
					opdTemplateTreatment = (OpdTemplateTreatment) hbt.load(OpdTemplateTreatment.class, templateTreatmentId);
					hbt.delete(opdTemplateTreatment);
					dataDeleted = true;
				}/* else if (flag.equals("Activate")) {
					opdTemplateTreatment.setStatus("y");
					dataDeleted = false;
				}*/
			}
		 }else{
			 if(userType == 1){
			 if (generalMap.get("flag") != null) {
					String flag = (String) generalMap.get("flag");
					if (flag.equals("InActivate")) {
						opdTemplateTreatment = (OpdTemplateTreatment) hbt.load(OpdTemplateTreatment.class, templateTreatmentId);
						hbt.delete(opdTemplateTreatment);
						dataDeleted = true;
					}/* else if (flag.equals("Activate")) {
						opdTemplateTreatment.setStatus("y");
						dataDeleted = false;
					}*/
				}
			 }
			 
		  }
		}
		/*Users users = new Users();
		users.setId(changedBy);
		opdTemplateTreatment.setLastChgBy(users);
		
		opdTemplateTreatment.setLastChgDate(currentDate);
		opdTemplateTreatment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdTemplateTreatment);*/
		return dataDeleted;
	}

	public boolean editOpdTemplateTreatment(Map<String, Object> generalMap) {
		List<OpdTemplate>templateList = new ArrayList<OpdTemplate>();
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int templateTreatmentId = 0;
		int departmentId = 0;
		int frequencyId = 0;
		@SuppressWarnings("unused")
		int itemId = 0;
		int templateId = 0;
		int instructionId = 0;
		int noofdays = 0;
		int total = 0;
		String dosage = "";
		int changedBy = 0;
		String duration="";
		int userType = 0;
		Session session = (Session)getSession();
		try {
			if(generalMap.get("userType") != null){
				userType=(Integer)generalMap.get("userType");
			}
			duration= (String) generalMap.get("duration");
			templateTreatmentId = (Integer) generalMap.get("id");
			templateId = (Integer) generalMap.get("templateId");
			frequencyId = (Integer) generalMap.get("frequencyId");
			instructionId = (Integer) generalMap.get("instructionId");
			departmentId = (Integer) generalMap.get("departmentId");
			noofdays = (Integer) generalMap.get("noofdays");
			total = (Integer) generalMap.get("total");
			itemId = (Integer) generalMap.get("itemId");
			dosage = (String) generalMap.get("dosage");
			changedBy = (Integer) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		templateList = session.createCriteria(OpdTemplate.class).add(Restrictions.idEq(templateId)).list();
		if(templateList.size()>0){
		if( templateList.get(0).getHospital() != null && templateList.get(0).getHospital().getId()!=null && !templateList.get(0).getHospital().getId().equals("")){	
			OpdTemplateTreatment opdTemplateTreatment = (OpdTemplateTreatment) getHibernateTemplate().get(OpdTemplateTreatment.class, templateTreatmentId);
			opdTemplateTreatment.setId(templateTreatmentId);
			opdTemplateTreatment.setDosage(dosage);
			opdTemplateTreatment.setNoofdays(noofdays);
			opdTemplateTreatment.setTotal(total);
	
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			opdTemplateTreatment.setDepartment(masDepartment);
	
			MasFrequency masFrequency = new MasFrequency();
			masFrequency.setId(frequencyId);
			opdTemplateTreatment.setFrequency(masFrequency);
	
			OpdTemplate opdTemplate = new OpdTemplate();
			opdTemplate.setId(templateId);
			opdTemplateTreatment.setTemplate(opdTemplate);
	
			opdTemplateTreatment.setDuration(duration);
			
			MasStoreItem masStoreItem = new MasStoreItem();
			masStoreItem.setId(itemId);
			opdTemplateTreatment.setItem(masStoreItem);
	
			if(instructionId>0){
			OpdInstructionTreatment opdInstructionTreatment = new OpdInstructionTreatment();
			opdInstructionTreatment.setId(instructionId);
			opdTemplateTreatment
					.setOpdInstructionTreatment(opdInstructionTreatment);
			}
			
			Users users = new Users();
			users.setId(changedBy);
			opdTemplateTreatment.setLastChgBy(users);
			
			
			opdTemplateTreatment.setLastChgDate(currentDate);
			opdTemplateTreatment.setLastChgTime(currentTime);
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.saveOrUpdate(opdTemplateTreatment);
				dataUpdated = true;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}else{
			if(userType == 1){
				OpdTemplateTreatment opdTemplateTreatment = (OpdTemplateTreatment) getHibernateTemplate().get(OpdTemplateTreatment.class, templateTreatmentId);
				opdTemplateTreatment.setId(templateTreatmentId);
				opdTemplateTreatment.setDosage(dosage);
				opdTemplateTreatment.setNoofdays(noofdays);
				opdTemplateTreatment.setTotal(total);
		
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				opdTemplateTreatment.setDepartment(masDepartment);
		
				MasFrequency masFrequency = new MasFrequency();
				masFrequency.setId(frequencyId);
				opdTemplateTreatment.setFrequency(masFrequency);
		
				OpdTemplate opdTemplate = new OpdTemplate();
				opdTemplate.setId(templateId);
				opdTemplateTreatment.setTemplate(opdTemplate);
		
				opdTemplateTreatment.setDuration(duration);
				
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(itemId);
				opdTemplateTreatment.setItem(masStoreItem);
		
				OpdInstructionTreatment opdInstructionTreatment = new OpdInstructionTreatment();
				opdInstructionTreatment.setId(instructionId);
				opdTemplateTreatment
						.setOpdInstructionTreatment(opdInstructionTreatment);
		
				
				Users users = new Users();
				users.setId(changedBy);
				opdTemplateTreatment.setLastChgBy(users);
				
				
				opdTemplateTreatment.setLastChgDate(currentDate);
				opdTemplateTreatment.setLastChgTime(currentTime);
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.saveOrUpdate(opdTemplateTreatment);
					dataUpdated = true;
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
			
			}
		  }
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdTemplateTreatment(String templateGroup) {
		List<OpdTemplateTreatment> searchOpdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<OpdInstructionTreatment> opdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();
		Session session=(Session)getSession();
		Map<String, Object> opdTemplateTreatmentFieldsMap = new HashMap<String, Object>();
		try {
			if ((templateGroup != null)) {

				searchOpdTemplateTreatmentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.OpdTemplateTreatment imc where imc.Template.TemplateName like '"
								+ templateGroup
								+ "%' order by imc.Template.TemplateName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id='1'and mm.Status ='y'");
		opdTemplateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplate ");
		
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status","Y").ignoreCase()).list();
		opdInstructionTreatmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.OpdInstructionTreatment as mm where mm.Status ='y'");
		opdTemplateTreatmentFieldsMap.put("departmentList", departmentList);
		opdTemplateTreatmentFieldsMap.put("opdTemplateList", opdTemplateList);
		opdTemplateTreatmentFieldsMap.put("searchOpdTemplateTreatmentList",
				searchOpdTemplateTreatmentList);
		opdTemplateTreatmentFieldsMap.put("frequencyList", frequencyList);
		opdTemplateTreatmentFieldsMap.put("opdInstructionTreatmentList",
				opdInstructionTreatmentList);

		return opdTemplateTreatmentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTemplateGroup(int templateId, int deptId) {
		List showList = new ArrayList();
		List<OpdTemplateTreatment> searchOpdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<OpdInstructionTreatment> opdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// Criteria nursinCareSetupCriteria =
			// session.createCriteria(NursingcareSetup.class)

			// .createCriteria(NursingcareSetup.PROP_NURSING)
			// .add(Expression.eq(MasNursingCare.PROP_ID, careId));

			// showList = nursinCareSetupCriteria.list();

			showList = session.createCriteria(OpdTemplateTreatment.class)
					.add(Restrictions.eq("Template.Id", templateId))
					.add(Restrictions.eq("Department.Id", deptId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status","Y").ignoreCase()).list();
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id='1'and mm.Status ='y'");
		opdTemplateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplate ");
		
		searchOpdTemplateTreatmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplateTreatment");
		opdInstructionTreatmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdInstructionTreatment");
		map.put("frequencyList", frequencyList);
		map.put("departmentList", departmentList);
		map.put("opdTemplateList", opdTemplateList);
		map.put("searchOpdTemplateTreatmentList",
				searchOpdTemplateTreatmentList);
		map.put("showList", showList);
		map.put("opdInstructionTreatmentList", opdInstructionTreatmentList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsInGrid(Map map) {

		Session session = (Session) getSession();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			if (map.get("deptId") != null) {
				deptId = Integer.parseInt("" + map.get("deptId"));
			}
			String str = "" + map.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();
			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemList(Map map) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = map.get("autoHint") + "%";
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("pharmacy.properties");
			properties.load(resourcePath.openStream());
			String sectionName = properties.getProperty("sectionName");
			
			String query = "SELECT DISTINCT (sib.Nomenclature),sib.PvmsNo from  MasStoreItem as sib left join sib.Section as msc  where lower(sib.Nomenclature) like '"+ str.toLowerCase() + "' and lower(msc.SectionName) like '"+sectionName.toLowerCase()+"'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			Iterator itr = itemList.iterator();
			while (itr.hasNext()) {
				Object[] pair = (Object[]) itr.next();
				@SuppressWarnings("unused")
				String nomenclature = (String) pair[0];
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	// ****************************************** End Of OPD Treatment Template
	// by Mansi ****************************//

	// //****************************************** Start Of OPD Instruction
	// Treatment by Mansi ****************************//

	public boolean addOpdInstructionTreatment(
			OpdInstructionTreatment opdInstructionTreatment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdInstructionTreatment);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean deleteOpdInstructionTreatment(int opdInstructionTreatmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdInstructionTreatment opdInstructionTreatment = new OpdInstructionTreatment();
		opdInstructionTreatment = (OpdInstructionTreatment) getHibernateTemplate()
				.get(OpdInstructionTreatment.class, opdInstructionTreatmentId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdInstructionTreatment.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdInstructionTreatment.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(changedBy);
		opdInstructionTreatment.setLastChgBy(users);
		
		opdInstructionTreatment.setLastChgDate(currentDate);
		opdInstructionTreatment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdInstructionTreatment);
		return dataDeleted;
	}

	public boolean editOpdInstructionTreatmentToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String opdInstructionTreatmentName = "";
		@SuppressWarnings("unused")
		String opdInstructionTreatmentCode = "";
		int opdInstructionTreatmentId = 0;
		int changedBy = 0;
		int hospitalId=0;
		try {
			opdInstructionTreatmentId = (Integer) generalMap.get("id");
			opdInstructionTreatmentCode = (String) generalMap
					.get("opdInstructionTreatmentCode");
			opdInstructionTreatmentName = (String) generalMap.get("name");
			hospitalId = (Integer) generalMap.get("hospitalId");
			changedBy = (Integer) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdInstructionTreatment opdInstructionTreatment = (OpdInstructionTreatment) getHibernateTemplate()
				.get(OpdInstructionTreatment.class, opdInstructionTreatmentId);

		opdInstructionTreatment.setId(opdInstructionTreatmentId);
		opdInstructionTreatment
				.setOpdInstructionTreatmentName(opdInstructionTreatmentName);
		Users users = new Users();
		users.setId(changedBy);
		opdInstructionTreatment.setLastChgBy(users);
		
		opdInstructionTreatment.setLastChgDate(currentDate);
		opdInstructionTreatment.setLastChgTime(currentTime);
		
		
		
		  MasHospital hospital = new MasHospital();
		  hospital.setId(hospitalId);
		  opdInstructionTreatment.setHospital(hospital);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdInstructionTreatment);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdInstructionTreatment(
			String opdInstructionTreatmentCode,
			String opdInstructionTreatmentName) {
		List<OpdInstructionTreatment> searchOpdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();

		Map<String, Object> opdInstructionTreatmentFieldsMap = new HashMap<String, Object>();
		try {
			if ((opdInstructionTreatmentName != null)
					|| (opdInstructionTreatmentCode == null)) {

				searchOpdInstructionTreatmentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.OpdInstructionTreatment imc where imc.OpdInstructionTreatmentName like '"
								+ opdInstructionTreatmentName
								+ "%' order by imc.OpdInstructionTreatmentName");
			} else {
				searchOpdInstructionTreatmentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.OpdInstructionTreatment imc where imc.OpdInstructionTreatmentCode like '"
								+ opdInstructionTreatmentCode
								+ "%' order by imc.OpdInstructionTreatmentCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdInstructionTreatmentFieldsMap.put(
				"searchOpdInstructionTreatmentList",
				searchOpdInstructionTreatmentList);
		return opdInstructionTreatmentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdInstructionTreatmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdInstructionTreatment> searchOpdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();
		searchOpdInstructionTreatmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdInstructionTreatment ");
		map.put("searchOpdInstructionTreatmentList",
				searchOpdInstructionTreatmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getInvestigationTemplateGroup(int templateId,
			int deptId) {
		List showInvList = new ArrayList();

		List<OpdTemplateInvestigation> searchOpdTemplateInvestigationList = new ArrayList<OpdTemplateInvestigation>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// Criteria nursinCareSetupCriteria =
			// session.createCriteria(NursingcareSetup.class)

			// .createCriteria(NursingcareSetup.PROP_NURSING)
			// .add(Expression.eq(MasNursingCare.PROP_ID, careId));

			// showList = nursinCareSetupCriteria.list();

			showInvList = session
					.createCriteria(OpdTemplateInvestigation.class)
					.add(Restrictions.eq("Template.Id", templateId))
					.add(Restrictions.eq("Department.Id", deptId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		departmentList = getSession().createCriteria(MasDepartment.class).createAlias("DepartmentType", "dType").add(Restrictions.eq("dType.Id",1)).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		opdTemplateList = getSession().createCriteria(OpdTemplate.class).add(Restrictions.eq("TemplateType", "I").ignoreCase()).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		searchOpdTemplateInvestigationList = getHibernateTemplate().find("from jkt.hms.masters.business.OpdTemplateInvestigation");

		map.put("departmentList", departmentList);
		map.put("opdTemplateList", opdTemplateList);
		map.put("searchOpdTemplateInvestigationList",searchOpdTemplateInvestigationList);
		map.put("showInvList", showInvList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillChargeCodeInGrid(Map map) {

		Session session = (Session) getSession();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			if (map.get("deptId") != null) {
				deptId = Integer.parseInt("" + map.get("deptId"));
			}
			String str = "" + map.get("chargeCodeCode");
			Criteria c = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("ChargeCodeCode", str));
			chargeCodeList = c.list();
			map.put("chargeCodeList", chargeCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdTemplateInvestigationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdTemplateInvestigation> searchOpdTemplateInvestigationList = new ArrayList<OpdTemplateInvestigation>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		searchOpdTemplateInvestigationList = getSession().createCriteria(OpdTemplateInvestigation.class).list();   //getHibernateTemplate().find("from jkt.hms.masters.business.OpdTemplateInvestigation");
		opdTemplateList = getSession().createCriteria(OpdTemplate.class).add(Restrictions.eq("TemplateType", "I").ignoreCase()).add(Restrictions.eq("Status", "Y").ignoreCase()).list();//getHibernateTemplate().find("from jkt.hms.masters.business.OpdTemplate as op where op.TemplateType ='I' and op.Status ='y'");
		departmentList =getSession().createCriteria(MasDepartment.class).createAlias("DepartmentType", "dType").add(Restrictions.eq("Status", "Y").ignoreCase()).add(Restrictions.eq("dType.Id", 1)).addOrder(Order.asc("DepartmentName")).list();
		
		// getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id='1'and mm.Status ='y'");
		map.put("opdTemplateList", opdTemplateList);
		map.put("departmentList", departmentList);
		map.put("searchOpdTemplateInvestigationList",
				searchOpdTemplateInvestigationList);
		return map;
	}

	public boolean addOpdTemplateInvestigation(
			OpdTemplateInvestigation opdTemplateInvestigation) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdTemplateInvestigation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteOpdTemplateInvestigation(int templateInvestigationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		 int userId =0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdTemplateInvestigation opdTemplateInvestigation = new OpdTemplateInvestigation();
		opdTemplateInvestigation = (OpdTemplateInvestigation) getHibernateTemplate()
				.get(OpdTemplateInvestigation.class, templateInvestigationId);

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdTemplateInvestigation.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdTemplateInvestigation.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		opdTemplateInvestigation.setLastChgBy(users);
		opdTemplateInvestigation.setLastChgDate(currentDate);
		opdTemplateInvestigation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdTemplateInvestigation);
		return dataDeleted;
	}

	public boolean editOpdTemplateInvestigation(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int templateInvestigationId = 0;
		int departmentId = 0;
		@SuppressWarnings("unused")
		int chargeCodeId = 0;
		int templateId = 0;
		int templateInvestigationQty = 0;
		String clinicalNotes = "";
		String changedBy = "";
		int userId =0;
		try {
			templateInvestigationId = (Integer) generalMap.get("id");
			templateId = (Integer) generalMap.get("templateId");
			departmentId = (Integer) generalMap.get("departmentId");
			templateInvestigationQty = (Integer) generalMap
					.get("templateInvestigationQty");
			chargeCodeId = (Integer) generalMap.get("chargeCodeId");
			clinicalNotes = (String) generalMap.get("clinicalNotes");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			userId = (Integer) generalMap.get("userId");

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdTemplateInvestigation opdTemplateInvestigation = (OpdTemplateInvestigation) getHibernateTemplate()
				.get(OpdTemplateInvestigation.class, templateInvestigationId);

		opdTemplateInvestigation.setId(templateInvestigationId);

		opdTemplateInvestigation.setClinicalNotes(clinicalNotes);

		opdTemplateInvestigation
				.setTemplateInvestigationQty(templateInvestigationQty);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		opdTemplateInvestigation.setDepartment(masDepartment);

		OpdTemplate opdTemplate = new OpdTemplate();
		opdTemplate.setId(templateId);
		opdTemplateInvestigation.setTemplate(opdTemplate);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);
		opdTemplateInvestigation.setChargeCode(masChargeCode);
		
		Users users = new Users();
		users.setId(userId);
		opdTemplateInvestigation.setLastChgBy(users);
		opdTemplateInvestigation.setLastChgDate(currentDate);
		opdTemplateInvestigation.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdTemplateInvestigation);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeList(Map<String, Object> map) {
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = map.get("autoHint") + "%";
			String query = "SELECT DISTINCT (sib.ChargeCodeName),sib.ChargeCodeCode from MasChargeCode as sib where sib.ChargeType.Id='2' and lower(sib.ChargeCodeName) like '"
					+ str.toLowerCase() + "'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			chargeCodeList = q.list();
			Iterator itr = chargeCodeList.iterator();
			while (itr.hasNext()) {
				Object[] pair = (Object[]) itr.next();
				@SuppressWarnings("unused")
				String chargeCodeName = (String) pair[0];
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeCodeList", chargeCodeList);
		return map;

	}

	// //****************************************** Start Methods by Vishal
	// ****************************//
	// --------------------------Equipment
	// Master-----------------------------------
	public Map<String, Object> showOpdEquipmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppEquipmentMaster> searchOpdEquipmentList = new ArrayList<AppEquipmentMaster>();
		searchOpdEquipmentList = getHibernateTemplate().find(
				"from AppEquipmentMaster ");
		map.put("searchOpdEquipmentList", searchOpdEquipmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdEquipment(String equipmentCode,
			String equipmentName) {
		List<AppEquipmentMaster> searchOpdEquipmentList = new ArrayList<AppEquipmentMaster>();
		Map<String, Object> opdEquipmentFieldsMap = new HashMap<String, Object>();
		// Map<String,Object> map = new HashMap<String,Object>();
		try {
			if ((equipmentName != null) || (equipmentCode == null)) {
				searchOpdEquipmentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.AppEquipmentMaster as aem where aem.EquipmentName like '"
								+ equipmentName
								+ "%' order by aem.EquipmentName");
			} else {
				searchOpdEquipmentList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.AppEquipmentMaster as aem where aem.EquipmentCode like '"
								+ equipmentCode
								+ "%' order by aem.EquipmentCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdEquipmentFieldsMap.put("searchOpdEquipmentList",
				searchOpdEquipmentList);
		return opdEquipmentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addOpdEquipment(AppEquipmentMaster appEquipmentMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(appEquipmentMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editOpdEquipmentToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String equipmentName = "";
		@SuppressWarnings("unused")
		String equipmentCode = "";
		int equipmentId = 0;
		int noOfEquipment = 0;
		int changedBy = 0;
		int hospitalId=0;
		try {
			equipmentId = (Integer) generalMap.get("id");
			equipmentCode = (String) generalMap.get("equipmentCode");
			equipmentName = (String) generalMap.get("name");
			noOfEquipment = (Integer) generalMap.get("noOfEquipment");
			changedBy = (Integer) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			hospitalId = (Integer) generalMap.get("hospitalId");

		} catch (Exception e) {
			e.printStackTrace();
		}

		AppEquipmentMaster appEquipmentMaster = (AppEquipmentMaster) getHibernateTemplate()
				.get(AppEquipmentMaster.class, equipmentId);

		appEquipmentMaster.setId(equipmentId);
		appEquipmentMaster.setEquipmentName(equipmentName);
		appEquipmentMaster.setNoOfEquipments(noOfEquipment);
		Users users = new Users();
		users.setId(changedBy);
		appEquipmentMaster.setLastChgBy(users);
		
		appEquipmentMaster.setLastChgDate(currentDate);
		appEquipmentMaster.setLastChgTime(currentTime);

		  MasHospital hospital = new MasHospital();
		  hospital.setId(hospitalId);
		  appEquipmentMaster.setHospital(hospital);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(appEquipmentMaster);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteOpdEquipment(int equipmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		AppEquipmentMaster appEquipmentMaster = new AppEquipmentMaster();
		appEquipmentMaster = (AppEquipmentMaster) getHibernateTemplate().get(
				AppEquipmentMaster.class, equipmentId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				appEquipmentMaster.setEquipmentStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				appEquipmentMaster.setEquipmentStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(changedBy);
		appEquipmentMaster.setLastChgBy(users);
		
		appEquipmentMaster.setLastChgDate(currentDate);
		appEquipmentMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(appEquipmentMaster);
		return dataDeleted;
	}

	// ------------------------Vaccine master----------------------------
	public Map<String, Object> showOpdVaccinJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdVaccinMst> searchOpdVaccinList = new ArrayList<OpdVaccinMst>();
		Session session = (Session)getSession();
		searchOpdVaccinList = session.createCriteria(OpdVaccinMst.class)
								.add(Restrictions.eq("Status", "y").ignoreCase())
								//.addOrder(Order.asc("MasStoreItem.Id"))
								//.addOrder(Order.asc("VaccinName")) 
								//.addOrder(Order.asc("VaccinCode"))//govind code 14-7-2016
								.addOrder(Order.asc("SrNo")) 
								.list();
		map.put("searchOpdVaccinList", searchOpdVaccinList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdVaccin(String vaccinCode,
			String vaccinName) {
		List<OpdVaccinMst> searchOpdVaccinList = new ArrayList<OpdVaccinMst>();
		Map<String, Object> opdVaccinFieldsMap = new HashMap<String, Object>();
		// Map<String,Object> map = new HashMap<String,Object>();
		try {
			if ((vaccinName != null) || (vaccinCode == null)) {
				searchOpdVaccinList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.OpdVaccinMst as mv where mv.VaccinName like '"
								+ vaccinName + "%' order by mv.VaccinName");
			} else {
				searchOpdVaccinList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.OpdVaccinMst as mv where mv.VaccinCode like '"
								+ vaccinCode + "%' order by mv.VaccinCode");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdVaccinFieldsMap.put("searchOpdVaccinList", searchOpdVaccinList);

		return opdVaccinFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addOpdVaccin(OpdVaccinMst opdVaccin) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdVaccin);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean editOpdVaccinToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		String vaccinName = "";
		@SuppressWarnings("unused")
		String vaccinCode = "";
		int vaccinId = 0;
		int vaccinDuration = 0;
		String changedBy = "";
		int userId = 0;
		int masStoreItemId = 0;
		int dose=0;
		int maxDays=0;
		try {
			vaccinId = (Integer) generalMap.get("id");
			vaccinCode = (String) generalMap.get("vaccinCode");
			vaccinName = (String) generalMap.get("name");
			vaccinDuration = (Integer) generalMap.get("vaccinDuration");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			userId = (Integer)generalMap.get("userId");
			masStoreItemId = (Integer)generalMap.get("masStoreItemId");
			Box box=(Box)generalMap.get("box");
			dose=box.getInt("vaccineDose");
			if(generalMap.get("maxDays")!=null){
				maxDays=(Integer)generalMap.get("maxDays");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdVaccinMst opdVaccin = (OpdVaccinMst) getHibernateTemplate().get(
				OpdVaccinMst.class, vaccinId);

		opdVaccin.setId(vaccinId);
		opdVaccin.setVaccinName(vaccinName);
		opdVaccin.setVaccinDuration(vaccinDuration);
		opdVaccin.setVaccinToDays(maxDays);
		
		Users users = new Users();
		users.setId(userId);
		opdVaccin.setLastChgBy(users);
		opdVaccin.setLastChgDate(currentDate);
		opdVaccin.setLastChgTime(currentTime);
		if(masStoreItemId!=0){
			MasStoreItem item=new MasStoreItem(masStoreItemId);
			opdVaccin.setMasStoreItem(item);
		}
		opdVaccin.setDose(dose);
		opdVaccin.setVaccinType((String)generalMap.get("type")); // added by amit das on 05-08-2016
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdVaccin);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}
	
	public Map checkExistingVaccineMaster(Map<String, Object> generalMap) {
		Map<String, Object> dataMap=new HashMap<String,Object>();
		boolean dataUpdated = false; 
		String vaccinName = ""; 
		String vaccinCode = ""; 
		int vaccinDuration = 0; 
		int masStoreItemId = 0;
		int dose=0; 
		org.hibernate.Session session=getSession();
		try {
			 
			//vaccinCode = (String) generalMap.get("vaccinCode");
			vaccinName = (String) generalMap.get("name");
			//vaccinDuration = (Integer) generalMap.get("vaccinDuration");  
			masStoreItemId = (Integer)generalMap.get("masStoreItemId");
			Box box=(Box)generalMap.get("box");
			dose=box.getInt("vaccineDose");   
			 Criteria criteria=session.createCriteria(OpdVaccinMst.class)
					 .add(Restrictions.eq("VaccinName", vaccinName)) 
					 .add(Restrictions.eq("MasStoreItem.Id", masStoreItemId))
					 .add(Restrictions.eq("Dose", dose));
			 List<OpdVaccinMst> vaccinMstsList=criteria.list();
			  	
			dataMap.put("duplicateMastersList", vaccinMstsList);
			 
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		 catch (Exception e) {
				e.printStackTrace();
			} 
		return dataMap;
	}
	

	@SuppressWarnings("unchecked")
	public boolean deleteOpdVaccin(int vaccinId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdVaccinMst opdVaccin = new OpdVaccinMst();
		opdVaccin = (OpdVaccinMst) getHibernateTemplate().get(
				OpdVaccinMst.class, vaccinId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer)generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdVaccin.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdVaccin.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		opdVaccin.setLastChgBy(users);
		opdVaccin.setLastChgDate(currentDate);
		opdVaccin.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdVaccin);
		return dataDeleted;
	}

	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}

	@SuppressWarnings("unused")
	public Map<String, Object> submitModularity(Map<String, Object> modulMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();

		String currentDate = (String) modulMap.get("currentDate");
		String time = (String) modulMap.get("time");
		String modularity_code = (String) modulMap.get("modularity_code");
		String modularity_name = (String) modulMap.get("modularity_name");
		String userName = (String)modulMap.get("userName");

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasModularity modularity =new MasModularity();
			modularity.setCode(modularity_code.toUpperCase());
			modularity.setModularityName(modularity_name.toUpperCase());
			modularity.setStatus("y");
			modularity.setLastChgBy(userName);
			modularity.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			modularity.setLastChgTime(time);

			hbt.save(modularity);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdModalityJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasModularity> searchOpdModalityList = new ArrayList<MasModularity>();
		searchOpdModalityList = getHibernateTemplate().find("from jkt.hms.masters.business.MasModularity");
		map.put("searchOpdModalityList", searchOpdModalityList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdModality(String modalityCode,
			String modalityName) {
		List<MasModularity> searchOpdModalityList = new ArrayList<MasModularity>();
		Map<String, Object> opdModalityFieldsMap = new HashMap<String, Object>();
		try {
			if ((modalityName != null) || (modalityCode == null)) {

				searchOpdModalityList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasModularity mm where mm.ModularityName like '"
								+ modalityName + "%' order by mm.ModularityName");
			} else {
				searchOpdModalityList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasModularity mm where mm.Code like '"
								+ modalityCode + "%' order by mm.Code");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdModalityFieldsMap.put("searchOpdModalityList", searchOpdModalityList);
		return opdModalityFieldsMap;
	}

	public boolean addOpdModality(MasModularity masModularity) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masModularity);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean deleteOpdModality(int holidayId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasModularity masModularity = new MasModularity();
		masModularity = (MasModularity) getHibernateTemplate().get(MasModularity.class,
				holidayId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masModularity.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masModularity.setStatus("y");
				dataDeleted = false;
			}
		}
		masModularity.setLastChgBy(changedBy);
		masModularity.setLastChgDate(currentDate);
		masModularity.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masModularity);
		return dataDeleted;
	}

	public boolean editOpdModalityToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String modalityCode = "";
		String modalityName = "";
		int modalityId = 0;
		String changedBy = "";
		try {
			modalityId = (Integer) generalMap.get("id");
			modalityCode = (String) generalMap.get("modalityCode");
			modalityName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		MasModularity masModularity = (MasModularity) getHibernateTemplate().get(
				MasModularity.class, modalityId);
		masModularity.setId(modalityId);
		masModularity.setModularityName(modalityName);
		masModularity.setCode(modalityCode);
		masModularity.setLastChgBy(changedBy);
		masModularity.setLastChgDate(currentDate);
		masModularity.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masModularity);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@Override
	public boolean addFrequency(MasOpdFrequency masOpdFrequency) {
		boolean saveFlag = false;
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masOpdFrequency);
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlag;
	}

	@Override
	public Map<String, Object> showFrequencyJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOpdFrequency> searchFrequencyList = new ArrayList<MasOpdFrequency>();
		try{
			searchFrequencyList = getHibernateTemplate().find("from jkt.hms.masters.business.MasOpdFrequency");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("searchFrequencyList", searchFrequencyList);
		return map;
	}

	@Override
	public Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName) {
		List<MasOpdFrequency> searchFrequencyList = new ArrayList<MasOpdFrequency>();
		Map<String, Object> frequencyFieldsMap = new HashMap<String, Object>();
		try {
			if ((frequencyName != null) || (frequencyCode == null)) {
				searchFrequencyList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasOpdFrequency as dis where dis.FrequencyName like '"
								+ frequencyName + "%' order by dis.FrequencyName");
			} else {
				searchFrequencyList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasOpdFrequency as dis where dis.FrequencyCode like '"
								+ frequencyCode + "%' order by dis.FrequencyCode");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		frequencyFieldsMap.put("searchFrequencyList", searchFrequencyList);
		
		return frequencyFieldsMap;
	}

	@Override
	public boolean editFrequency(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String frequencyName = "";
		String frequencyCode = "";
		int frequencyId = 0;
		frequencyId = (Integer) generalMap.get("id");
		frequencyCode = (String) generalMap.get("frequencyCode");
		frequencyName = (String) generalMap.get("name");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		MasOpdFrequency masOpdFrequency = (MasOpdFrequency) getHibernateTemplate().get(
				MasOpdFrequency.class, frequencyId);

		masOpdFrequency.setId(frequencyId);
		masOpdFrequency.setFrequencyName(frequencyName);

	

		masOpdFrequency.setLastChgDate(currentDate);
		masOpdFrequency.setLastChgTime(currentTime);
		
		
		Users users = new Users();
		users.setId(userId);
		masOpdFrequency.setLastChgBy(users);
		
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masOpdFrequency);
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
	public boolean deleteFrequency(int frequencyId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasOpdFrequency masOpdFrequency = new MasOpdFrequency();
		masOpdFrequency = (MasOpdFrequency) getHibernateTemplate().get(
				MasOpdFrequency.class, frequencyId);
		
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masOpdFrequency.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masOpdFrequency.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		masOpdFrequency.setLastChgBy(users);
		masOpdFrequency.setLastChgDate(currentDate);
		masOpdFrequency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masOpdFrequency);
		return dataDeleted;
	}
	@Override
	public Map<String, Object> getVaccinationList(Box box) {
		Map<String,Object> dataMap=new HashMap<String,Object>(); 
		int sectionId=Integer.parseInt(properties.getProperty("store.vaccine_id"));
		Session session=(Session) getSession();
		String str = "%" + box.get("autoHint") + "%";
		Criteria criteria=session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("Section.Id", sectionId))
				.add(Restrictions.ilike("Nomenclature", str));
		List<MasStoreItem> masStoreItems=criteria.list();
		dataMap.put("masStoreItems", masStoreItems);
		return dataMap;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> addOpdExaminationTemplate(Box box) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<OpdTemplate>opdTemplateList = new ArrayList<OpdTemplate>();
		List<OpdTemplateTreatment>opdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		List<OpdTemplateTreatment>deleteOpdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		Session session=(Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean saveFlag = false;
		int count = 0;
		String deletedIds = "";
		if(box.getInt("hdb") != 0){
			count =(Integer)box.getInt("hdb"); 
		}
		if(!box.getString("deletedIds") .equals("")){
			deletedIds =(String)box.getString("deletedIds"); 
		}
		ArrayList<Integer> deletedIdsList=new ArrayList<Integer>();
		System.out.println("deletedIds=="+deletedIds);
		if(!deletedIds.equals("")){
			String[] strIds=deletedIds.split(",");
			for (int i = 0; i < strIds.length; i++) {
				deletedIdsList.add(Integer.parseInt(strIds[i]));
			}
		
		deleteOpdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)	
				.add(Restrictions.in("Id",deletedIdsList)).list();
		
		
			for(OpdTemplateTreatment deleteOpdTemplateTreatment :deleteOpdTemplateTreatmentList){
				hbt.delete(deleteOpdTemplateTreatment);
				saveFlag = true;
			}
		}
		
	
		for (int i = 1; i <= count; i++) {
			OpdTemplateTreatment opdTemplateTreatment = new OpdTemplateTreatment();
			
			if(!box.getString("templateType").equals("")){
				opdTemplateList = session.createCriteria(OpdTemplate.class).add(Restrictions.eq("TemplateName", box.getString("templateType")).ignoreCase())
								.add(Restrictions.eq("Status", "y").ignoreCase()).list();
				int templateId = 0;
				if(opdTemplateList.size()>0){
					templateId = opdTemplateList.get(0).getId();
			 }
		if(box.getInt("opdTemplateTreatmentId"+i) == 0){
			if(!box.getString("examinationParameter"+i).equals("")){
			if(box.getString("templateType").equalsIgnoreCase("Present Complaint")){
				opdTemplateTreatment.setPresentComplaintHistory(box.getString("examinationParameter"+i));
			}
			if(box.getString("templateType").equalsIgnoreCase("Past History")){
				opdTemplateTreatment.setPastIllnessHistory(box.getString("examinationParameter"+i));
			}
			if(box.getString("templateType").equalsIgnoreCase("Personal History")){
				opdTemplateTreatment.setPersonalHistory(box.getString("examinationParameter"+i));
			}
			if(box.getString("templateType").equalsIgnoreCase("Medication History")){
				opdTemplateTreatment.setMedicationHistory(box.getString("examinationParameter"+i));
			}
			if(box.getString("templateType").equalsIgnoreCase("Family History")){
				opdTemplateTreatment.setFamilyHistory(box.getString("examinationParameter"+i));	
			}
			if(box.getString("templateType").equalsIgnoreCase("General Examination")){
				opdTemplateTreatment.setGeneralExamination(box.getString("examinationParameter"+i));
			}
			if(box.getString("templateType").equalsIgnoreCase("Systemic  Examination")){
				opdTemplateTreatment.setSystemicExamination(box.getString("examinationParameter"+i));
			}
			
			
			
			if(templateId != 0){
				OpdTemplate opdTemplate = new OpdTemplate();
				opdTemplate.setId(templateId);
				opdTemplateTreatment.setTemplate(opdTemplate);
			}else{
				OpdTemplate opdTemplate = new OpdTemplate();
				opdTemplate.setId(templateId);
				opdTemplate.setId(0);
			}
			
			if(box.getInt("deptId") != 0){
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(box.getInt("deptId"));
				opdTemplateTreatment.setDepartment(masDepartment);
			}
			if(box.getInt("userId") != 0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				opdTemplateTreatment.setLastChgBy(users);
			}
			opdTemplateTreatment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			opdTemplateTreatment.setLastChgTime(time);
			opdTemplateTreatment.setStatus("y");
			hbt.save(opdTemplateTreatment);
			 saveFlag = true;
		 }
		}
	 }
   }	
		
		if(box.getString("templateType").equalsIgnoreCase("Present Complaint")){
		opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.add(Restrictions.isNotNull("PresentComplaintHistory"))
				.add(Restrictions.ne("PresentComplaintHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();

		}else if(box.getString("templateType").equalsIgnoreCase("Past History")){ 
			opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
							.add(Restrictions.isNotNull("PastIllnessHistory")).
										add(Restrictions.ne("PastIllnessHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
		}else if(box.getString("templateType").equalsIgnoreCase("Personal History")){ 
			opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
							.add(Restrictions.isNotNull("PersonalHistory")).
										add(Restrictions.ne("PersonalHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
		}else if(box.getString("templateType").equalsIgnoreCase("Medication History")){ 
			opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
							.add(Restrictions.isNotNull("MedicationHistory")).
										add(Restrictions.ne("MedicationHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		}else if(box.getString("templateType").equalsIgnoreCase("Family History")){
			opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
						.add(Restrictions.isNotNull("FamilyHistory"))
												.add(Restrictions.ne("FamilyHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		}else if(box.getString("templateType").equalsIgnoreCase("General Examination")){
			opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
					.add(Restrictions.ne("GeneralExamination", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		}else if(box.getString("templateType").equalsIgnoreCase("Systemic  Examination")){
			opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
					.add(Restrictions.isNotNull("SystemicExamination"))
					.add(Restrictions.ne("SystemicExamination", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		} 
		map.put("templateType", box.getString("templateType"));
		map.put("opdTemplateTreatmentList",opdTemplateTreatmentList);
		map.put("saveFlag", saveFlag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchOpdExaminationTemplate(Box box) {
		Map<String,Object> map=new HashMap<String,Object>();
		List<OpdTemplateTreatment>opdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		Session session=(Session) getSession();
		System.out.println("template type==="+box.getString("templateType"));
		System.out.println("deptId==="+ box.getInt("deptId"));
		if(box.getString("templateType").equalsIgnoreCase("Present Complaint")){
			opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
					.add(Restrictions.isNotNull("PresentComplaintHistory"))
					.add(Restrictions.ne("PresentComplaintHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();

			}else if(box.getString("templateType").equalsIgnoreCase("Past History")){ 
				opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
								.add(Restrictions.isNotNull("PastIllnessHistory")).
											add(Restrictions.ne("PastIllnessHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
				
			}else if(box.getString("templateType").equalsIgnoreCase("Personal History")){ 
				opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
								.add(Restrictions.isNotNull("PersonalHistory")).
											add(Restrictions.ne("PersonalHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
				
			}else if(box.getString("templateType").equalsIgnoreCase("Medication History")){ 
				opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
								.add(Restrictions.isNotNull("MedicationHistory")).
											add(Restrictions.ne("MedicationHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			}else if(box.getString("templateType").equalsIgnoreCase("Family History")){
				opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
							.add(Restrictions.isNotNull("FamilyHistory"))
													.add(Restrictions.ne("FamilyHistory", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			}else if(box.getString("templateType").equalsIgnoreCase("General Examination")){
				opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
						.add(Restrictions.ne("GeneralExamination", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			}else if(box.getString("templateType").equalsIgnoreCase("Systemic  Examination")){
				opdTemplateTreatmentList = session.createCriteria(OpdTemplateTreatment.class)//.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
						.add(Restrictions.isNotNull("SystemicExamination"))
						.add(Restrictions.ne("SystemicExamination", "")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			} 
		map.put("templateType", box.getString("templateType"));
		map.put("opdTemplateTreatmentList",opdTemplateTreatmentList);
		return map;
	}



	@Override
	public Map<String, Object> showPrescriptionMappingJsp(int hospitalId) {	Session session = null;
	session = (Session) getSession();
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();
	Map<String,Object> map=new HashMap<String,Object>();
	routeOfAdministrationList = session
			.createCriteria(RouteOfAdministration.class)
			.add(Restrictions.eq("Status", "y".toLowerCase())
					.ignoreCase()).addOrder(Order.asc("OrderNo")).list();
	
	
	frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	
	
	map.put("frequencyList", frequencyList);
	map.put("routeOfAdministrationList", routeOfAdministrationList);
	
	return map;
	
	
	}

	
	@Override
	public Map<String, Object> displayAU(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemMasterList = new ArrayList<MasStoreItem>();
		String pvmsNo ="";
		int hospitalId = 0;
		if(dataMap.get("hospitalId") != null){
			hospitalId = (Integer)dataMap.get("hospitalId");
		}
		if(dataMap.get("pvmsNo") != null){
			pvmsNo = (String)dataMap.get("pvmsNo");
		}
		Session session = (Session)getSession();
		itemMasterList = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("PvmsNo", pvmsNo))
						//	.add(Restrictions.eq("Hospital.Id", 0))
							.list();
		int itemId = 0;
		if(itemMasterList.size()>0){
			MasStoreItem storeItem = itemMasterList.get(0);
			itemId = storeItem.getId();
		}
		List<Object[]> presMapList = new ArrayList<Object[]>();
		
		presMapList = session.createCriteria(PrescriptionMapping.class).createAlias("Frequency", "f")
				.add(Restrictions.eq("Item.Id", itemId)).setProjection(Projections.projectionList().add(Projections.property("Dosage")).add(Projections.property("Noofdays")).add(Projections.property("f.Id")).add(Projections.property("f.FrequencyType")).add(Projections.property("Id"))).list();
		map.put("presMapList", presMapList);
		map.put("itemMasterList", itemMasterList);
		return map;
	}


	@Override
	public Map<String, Object> submitPrescriptionGrid(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		
		try{
		
				int totalItem = box.getInt("hdb");
				System.out.println(totalItem+"--totalItem");
				for (int i = 0; i <= totalItem; i++) {
					String pvmsNo = box.getString("pvmsNo" + i);
					
					
					List<MasStoreItem> itemIdListNew = new ArrayList<MasStoreItem>();
					itemIdListNew = getItemIdFromPVMS(pvmsNo);
					int itemId = 0;
					
					
					for (int k = 0; k < itemIdListNew.size(); k++) {
						itemId = itemIdListNew.get(k).getId();
					}
					int presMapId = box.getInt("presMapId"+i);
					
					if (itemId != 0) {

						PrescriptionMapping prescriptionMapping = new PrescriptionMapping();
						if(presMapId!=0){
							prescriptionMapping = hbt.load(PrescriptionMapping.class, presMapId);
						}
						MasStoreItem item = new MasStoreItem();
						item.setId(itemId);
						prescriptionMapping.setItem(item);

						if (!box.getString("dosage" + i).equals("")) {	
							prescriptionMapping.setDosage(box
									.getString("dosage" + i));
						}

						if (box.getInt("noOfDays" + i) != 0) {
							prescriptionMapping.setNoofdays(box.getInt("noOfDays" + i));
						}
					

						if (box.getInt("frequency" + i) != 0) {
							MasFrequency frequency = new MasFrequency();
							frequency.setId(box.getInt("frequency" + i));
							prescriptionMapping.setFrequency(frequency);
						}

						

						if (box.getInt("route" + i) != 0) {
							RouteOfAdministration routeOfAdministration = new RouteOfAdministration();
							routeOfAdministration
									.setId(box.getInt("route" + i));
							prescriptionMapping
									.setRoute(routeOfAdministration);
						}
						
						hbt.saveOrUpdate(prescriptionMapping);
						map.put("message", "Record Saved Successfully.");
					}

				}
		
			} catch (Exception exception) {
				map.put("message", "Error occured Please try after sometime.");
			}
		
		
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MasStoreItem> getItemIdFromPVMS(String pvmsNo) {
		List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		try {
			itemIdList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", pvmsNo)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemIdList;
	}
	

}
