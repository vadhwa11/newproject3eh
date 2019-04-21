package jkt.hms.sms.dataservice;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BulkDetails;
import jkt.hms.masters.business.BulkMain;
import jkt.hms.masters.business.MasBulkDetail;
import jkt.hms.masters.business.MasBulkMain;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmployee;


import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.logica.smpp.Session;

public class SmsDataServiceImpl extends HibernateDaoSupport implements SmsDataService {

	@Override
	public boolean saveOneToOne(OneToOne oto) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(oto);
		hbt.flush();
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> showSendBulkSmsJsp() {
		Map<String,Object>map=new HashMap<String,Object>();
		List<MasBulkMain>mainList=new ArrayList<MasBulkMain>();
		List<BulkMain>bulkMainList=new ArrayList<BulkMain>();
		org.hibernate.Session session=(org.hibernate.Session)getSession();
		bulkMainList=session.createCriteria(BulkMain.class).add(Restrictions.eq("SendStatus", "U")).list();
		mainList=session.createCriteria(MasBulkMain.class).add(Restrictions.eq("Status", "y")).list();
		map.put("mainList",mainList);
		map.put("bulkMainList",bulkMainList);
		
		return map;
	}

	@Override
	public Map<String, Object> showSendonetoOneSmsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	@Override
	public Map<String, Object> updateBulkDetails(Map<String,Object> dataMap,Box box) {
		Map<String,Object>map=new HashMap<String,Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String priority = "";
		String type="";
		if(dataMap.get("type")!=null){
			type=(String)dataMap.get("type");
		}		
		String statusMessage="";
		int mainId=0;
		org.hibernate.Session session =(org.hibernate.Session)getSession();
		if (type.equals("update")) {
			
		@SuppressWarnings("unused")
		String message = "";
		String repeat = "n";
		String groupName = "-";
		String date = "";
		String time = "";
		String mobileNo="";
		String repeat_frequestuency = "";
		String repeat_time = "";
		String repeat_day_of_month = "";
		String repeat_week_day = "";
		String repeat_year = "";
		String  activate_date = "";
		int hiddenValue = 0;


		if(dataMap.get("hiddenValue")!=null){
			hiddenValue= (Integer)  dataMap.get("hiddenValue");
		}
		if(dataMap.get("priority")!=null){
			priority= (String)  dataMap.get("priority");
		}
		
		if(dataMap.get("groupName")!=null){
			groupName= (String)  dataMap.get("groupName");
		}
		if(dataMap.get("date")!=null){
			date= (String)  dataMap.get("date");
		}
		
		if(dataMap.get("time")!=null){
			time= (String)  dataMap.get("time");
		}
		
		if(dataMap.get("repeat_frequestuency")!=null){
			repeat_frequestuency= (String)  dataMap.get("repeat_frequestuency");
		}
		
		
		if(dataMap.get("repeat_year")!=null){
			repeat_year= (String)  dataMap.get("repeat_year");
		}
		
		if(dataMap.get("activate_date")!=null){
			activate_date= (String)  dataMap.get("activate_date");
		}
		
		if(dataMap.get("repeat_day_of_month")!=null){
			repeat_day_of_month= (String)  dataMap.get("repeat_day_of_month");
		}
		
		if(dataMap.get("repeat_week_day")!=null){
			repeat_week_day= (String)  dataMap.get("repeat_week_day");
		}
		
		if(dataMap.get("repeat_week_day")!=null){
			repeat_week_day= (String)  dataMap.get("repeat_week_day");
		}
		
		if(dataMap.get("repeat_time")!=null){
			repeat_time= (String)  dataMap.get("repeat_time");
		}

		if(dataMap.get("mainId")!=null){
			mainId= (Integer)  dataMap.get("mainId");
		}
		if(dataMap.get("mobileNo")!=null){
			mobileNo=(String)dataMap.get("mobileNo");
		}
		String mainQry = "update bulk_main set activate_date ='"
				+ activate_date + "' , activate_time ='" + time
				+ "'  , priority='" + priority + "'  , repeat_status='"
				+ repeat + "',message='" + message + "',repeat_frequency='"
				+ repeat_frequestuency + "',repeat_time='" + repeat_time
				+ "',repeat_day_of_month='" + repeat_day_of_month
				+ "',repeat_week_day='" + repeat_week_day
				+ "',repeat_year='" + repeat_year + "' where id=" + mainId;
		// repeat_time,repeat_day_of_month,repeat_week_day,repeat_year)
		// VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
		try {

			int update = session.createSQLQuery(mainQry).executeUpdate();
			if (update > 0)
				statusMessage = "Record Edited Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}

		String detailQry = "delete  from bulk_details where group_main_id="
				+ mainId;
	
		try {
			
			@SuppressWarnings("unused")
			int update = session.createSQLQuery(detailQry).executeUpdate();
			// if(update >0)
			statusMessage = "Record Edited Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int inc = 1; inc <= hiddenValue; inc++) {
			try {
				BulkDetails prepareStatement =new BulkDetails();
						
				prepareStatement.setMobileNo(box.getString("mobileNo"
						+ inc));
//				prepareStatement.setMain(mainId);
				prepareStatement.setName(box.getString("name" + inc));
				hbt.saveOrUpdate(prepareStatement);
				hbt.flush();
				statusMessage = "Record Edited Successfully";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}  if (type.equals("cancel")) {
		try {
			String qry = "update bulk_details set status='C' where status='U' and group_main_id="
					+ mainId;
			
			int update = session.createSQLQuery(qry).executeUpdate();;
			if (update > 0)
				statusMessage = "This Bulk Message canceled ";
		} catch (Exception e) {
			e.printStackTrace();
		}

	} else if (type.equals("print")) {
		
		map.put("group_id", mainId);
		String groupName = "";
		if (box.getString("groupName") != null)
			groupName = "" + box.getString("groupName");
		map.put("GROUP_NAME", groupName);
/*		HMSUtil.generateReport("bulkReportOfGroup", map, ConnectionFactory
				.getConnectionFromMysql(), response, getServletContext());
*/	}else if (type.equals("stopAll")) {
		try {
			statusMessage = "All messages are sent.No message is there to stop ";
			String qry = "update bulk_details set status='C' where status='U'" ;

			int update = session.createSQLQuery(qry).executeUpdate();
			if (update > 0)
				statusMessage = "All bulk messages stopped successfully ";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		successfullyAdded = true;
		map.put("successfullyAdded",successfullyAdded);
		return map;
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		org.hibernate.Session session = (org.hibernate.Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@Override
	public Map<String, Object> showGroupMasterJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBulkMain> searchGroupList = new ArrayList<MasBulkMain>();
		
		searchGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBulkMain where Hospital.Id="+hospitalId);
		System.out.println("searchGroupList.size()-------->>>"+searchGroupList.size());
		map.put("searchGroupList", searchGroupList);
		
		return map;
	}

	@Override
	public boolean addGroupSMS(MasBulkMain masBulkMain) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBulkMain);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public boolean deletegroupSMS(int countryId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		System.out.println(" countryId---->>"+ countryId);
		MasBulkMain masCountry = new MasBulkMain();
		masCountry = (MasBulkMain) getHibernateTemplate().get(MasBulkMain.class,
				countryId);
		//@SuppressWarnings("unused")
		//Integer currencyId = masCountry.getCurrency().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			/*List currencyList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasCurrency as isc where isc.Id='"
							+ countryId + "' and isc.Status='Y'");*/
			if (flag.equals("InActivate")) {
				masCountry.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCountry.setStatus("y");
				dataDeleted = false;
			}
		}
		int userId = (Integer)generalMap.get("userId");
		Users user = new Users();
		user.setId(userId);
		masCountry.setLastChgBy(user);
		masCountry.setLastChgDate(currentDate);
		masCountry.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCountry);
		System.out.println("updating now!!");
		hbt.flush();
		return dataDeleted;
	}

	@Override
	public boolean editCountryToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int currencyId = 0;
		String countryName = "";
		@SuppressWarnings("unused")
		String countryCode = "";
		int countryId = 0;
		String changedBy = "";
		countryId = (Integer) generalMap.get("id");
		countryCode = (String) generalMap.get("countryCode");
		countryName = (String) generalMap.get("name");
		currencyId = (Integer) generalMap.get("currencyId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasBulkMain masCountry = (MasBulkMain) getHibernateTemplate().load(
				MasBulkMain.class, countryId);

		masCountry.setId(countryId);
		masCountry.setGroupName(countryName);
		
		int userId = (Integer)generalMap.get("userId");
		Users user = new Users();
		user.setId(userId);
		masCountry.setLastChgBy(user);
		masCountry.setLastChgDate(currentDate);
		masCountry.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		hbt.update(masCountry);
		dataUpdated = true;
		return dataUpdated;
	}

	@Override
	public Map<String, Object> searchGroupSMS(String groupCode, String groupName) {
		List<MasBulkMain> searchTitleList = new ArrayList<MasBulkMain>();
		Map<String, Object> titleFieldsMap = new HashMap<String, Object>();
		try {
			if ((groupName != null) || (groupCode == null)) {

				searchTitleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBulkMain imc where imc.GroupName like '"
								+ groupName + "%' order by imc.GroupName");
			} else {
				searchTitleList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBulkMaine imc where imc.GroupCode like '"
								+ groupCode + "%' order by imc.GroupCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		titleFieldsMap.put("searchTitleList", searchTitleList);
		return titleFieldsMap;
	}

	@Override
	public Map<String, Object> showGroupWiseDetailJsp(int hospitalId) {
		List<MasBulkMain> mainList = new ArrayList<MasBulkMain>();
		Map<String,Object>map=new HashMap<String,Object>();
		org.hibernate.Session session=(org.hibernate.Session)getSession();
		mainList=session.createCriteria(MasBulkMain.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		map.put("mainList",mainList);
		return map;
	}

	@Override
	public List<MasEmployee> getValForGroup(int hospitalId) {
		List<MasEmployee>empList=new ArrayList<MasEmployee>();
		org.hibernate.Session session=(org.hibernate.Session)getSession();
		empList=session.createCriteria(MasEmployee.class)
				       .add(Restrictions.eq("Hospital.Id", hospitalId))
				       .add(Restrictions.eq("Status", "y")).add(  Restrictions.isNotNull("CellNoEmergency"))
				       //.add(Restrictions.isNotEmpty("CellNoEmergency"))
				       .list();
		return empList;
	}

	@Override
	public List<MasStoreSupplier> getValForGroup1(int hospitalId) {
		List<MasStoreSupplier>supplierList=new ArrayList<MasStoreSupplier>();
		org.hibernate.Session session=(org.hibernate.Session)getSession();
		supplierList=session.createCriteria(MasStoreSupplier.class)
				       //.add(Restrictions.eq("Hospital.Id", hospitalId))
				       .add(Restrictions.eq("Status", "y"))
				       //.add(  Restrictions.isNotNull("CellNoEmergency"))
				       //.add(Restrictions.isNotEmpty("CellNoEmergency"))
				       .list();
		return supplierList;
	}

	@Override
	public boolean saveGroupWiseDetail(List<MasStoreSupplier> supplierList) {
		Map<String,Object>map=new HashMap<String,Object>();
		System.out.println("size in data--->>"+supplierList.size());
		return false;
	}

	@Override
	public Map<String, Object> saveGroupWiseDetail(int hospitalId, MasBulkDetail mbd) {		
	Map<String,Object>map=new HashMap<String,Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
	hbt.save(mbd);
	hbt.flush();
	successfullyAdded = true;
	map.put("successfullyAdded",successfullyAdded);
	return map;
}

	@Override
	public int getEmployeeCategory(int employeeId) {
		int empCategoryId=0;
		List<MasEmployee>empList=new ArrayList<MasEmployee>();
		org.hibernate.Session session=(org.hibernate.Session)getSession();
		empList=session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).list();
		for(MasEmployee emp:empList){
			empCategoryId=emp.getEmpCategory().getId();
		}
		
		return empCategoryId;
	}

	@Override
	public String getEmployeeMobile(int employeeId) {
		String mobileNo="";
		List<MasEmployee>empList=new ArrayList<MasEmployee>();
		org.hibernate.Session session=(org.hibernate.Session)getSession();
		empList=session.createCriteria(MasEmployee.class).add(Restrictions.idEq(employeeId)).list();
		for(MasEmployee emp:empList){
			mobileNo=emp.getCellNoEmergency();
		}
		
		return mobileNo;
	}

	@Override
	public boolean saveBulkSMS(Map<String, Object> generalMap) {
		Date ScheduleDate=new Date();
		String scheduleTime="";
		String minute="";
		String messageToBeSent="";
		String hours="";
		String groupName="";
		int mainGroupId=0;
		int tempId=0;
		String minutes="";
		int userID=0;
		org.hibernate.Session session =(org.hibernate.Session)getSession();
		boolean saved=false;
		if(generalMap.get("minute")!=null){
			minute=(String)generalMap.get("minute");
		}
		if(generalMap.get("messageToBeSent")!=null){
			messageToBeSent=(String)generalMap.get("messageToBeSent");
		}
		
		if(generalMap.get("groupName")!=null){
			groupName=(String)generalMap.get("groupName");
		}
		
		if(generalMap.get("mainGroupId")!=null){
			mainGroupId=(Integer)generalMap.get("mainGroupId");
		}
		
		if(generalMap.get("tempId")!=null){
			tempId=(Integer)generalMap.get("tempId");
		}
		if(generalMap.get("hours")!=null){
			hours=(String)generalMap.get("hours");
		}
		if(generalMap.get("minutes")!=null){
			minutes=(String)generalMap.get("minutes");
		}
		
		if(generalMap.get("ScheduleDate")!=null){
			ScheduleDate=(Date)generalMap.get("ScheduleDate");
		}
		int hospitalId=0;
		if(generalMap.get("hospitalId")!=null){
			hospitalId=(Integer)generalMap.get("hospitalId");
		}
		if(generalMap.get("userId")!=null){
			userID=(Integer)generalMap.get("userId");
		}
		System.out.println("mainGroupId>>>"+mainGroupId);
		System.out.println("tempId>>>"+tempId);
		System.out.println("hours>>>"+hours);
		System.out.println("minutes>>>"+minutes);
		System.out.println("minutes>>>"+minutes);
		System.out.println("messageToBeSent>>>>"+messageToBeSent);
		String name="";
		try{
		name=""+session.createCriteria(MasBulkMain.class).add(Restrictions.eq("Id", tempId)).setProjection(Projections.property("GroupName")).list().get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		BulkMain bm=new BulkMain();
		bm.setActivateTime(hours.concat(":").concat(minutes));
		bm.setActiveDate(ScheduleDate);
		bm.setEditStatus("n");
		
		MasHospital mh =new MasHospital();
		mh.setId(hospitalId);
		bm.setHospital(mh);
		bm.setMessage(messageToBeSent);
		
		bm.setScheduleStatus("y");
		bm.setSendStatus("U");
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");

		bm.setSystemDate(new Date());
		bm.setSystemTime(time);
		bm.setName(name);
		//bm.setName();
		Users user=new Users();
		user.setId(userID);
		bm.setUser(user);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(bm);
		
		int mainId=0;
		mainId= bm.getId();
		System.out.println("mainId------>>>>"+mainId);
		List<MasBulkDetail>detailList=new ArrayList<MasBulkDetail>();
		
		detailList=session.createCriteria(MasBulkDetail.class).add(Restrictions.eq("Group.Id", tempId)).list();
		System.out.println("detailList.size()   ---->>"+detailList.size());
		for(MasBulkDetail dtl:detailList){
			BulkDetails b=new BulkDetails();
			System.out.println("IN LOOP");
			b.setHours(Integer.parseInt(hours));//Chk("C");
			
			BulkMain main2=new BulkMain();
			main2.setId(mainId);
			b.setMain(main2);
			
			b.setMinutes(Integer.parseInt(minutes));
			if(dtl.getEmployeeId().getCellNoEmergency()!=null && !dtl.getEmployeeId().getCellNoEmergency().equals("")){
			b.setMobileNo(dtl.getEmployeeId().getCellNoEmergency());
			}
			b.setPriority(1);
			b.setSentDate(new Date());

			b.setStatus("U");
			
			b.setSystemDate(new Date());
			b.setSystemTime(time);
			Users user2=new Users();
			user2.setId(userID);
			b.setUser(user2);
			
			b.setName(dtl.getEmployeeId().getEmployeeName());
			hbt.save(b);
			
		}
		hbt.flush();
		saved=true;
		
		
		return saved;
	}

}
