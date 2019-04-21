package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.HMSUtil;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommonMasterDataServiceImpl extends HibernateDaoSupport implements
		CommonMasterDataService {
	/*
	 * Logger Implemented By Mukesh Narayan Singh
	 * Date 30 Aug 2010
	 */
	static final Logger log = Logger.getLogger(jkt.hms.masters.dataservice.CommonMasterDataServiceImpl.class);

	// -----------------General Methods for All Masters By Deepti
	// Tevatia-------------------

	public List getMastersList(Map<String, Object> generalMap) {
		String pojoName = (String) generalMap.get("pojoName");
		String pojoPropertyName = (String) generalMap.get("pojoPropertyName");

		List mastersList = getHibernateTemplate().find(
				"from jkt.hms.masters.business." + pojoName
						+ " as g where g.Status = 'y' order by "
						+ pojoPropertyName + " ");
		return mastersList;
	}

	public Map checkForExistingMasters(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();
		List duplicateGeneralPriorityList = new ArrayList();
		List duplicateShortCodeList = new ArrayList(); //Added by Om Tripathi 25/09/2017
		int id = 0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String pojoPropertyName = "";

		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}

		String name = (String) generalMap.get("name");
		int priority = 0;
		
		if(generalMap.get("priority")!=null)
			priority = (Integer) generalMap.get("priority"); // Added by Amit Das on 26-02-2016
		String invShortCode=null;  //Added by Om Tripathi 25/09/2017
		if(generalMap.get("invShortCode")!=null && !generalMap.get("invShortCode").equals("")){
			invShortCode =  (String) generalMap.get("invShortCode"); // Added by Om Tripathi on 21-09-2017
		}
		
		String pojoName = (String) generalMap.get("pojoName");
		String description="";
		String pojoPropertyDescription="";
		String notifiableDisease="";
		String pregister="";
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
		if (generalMap.get("notifiableDisease") != null) {
			notifiableDisease = (String) generalMap
					.get("notifiableDisease");
		}
		if (generalMap.get("pregister") != null) {
			pregister = (String) generalMap
					.get("pregister");
		}
	
		if (generalMap.get("flag") == null) {
			String code = (String) generalMap.get("code");
			String address = (String) generalMap.get("address");
			if (!pojoPropertyCode.equals("")) {
				/*duplicateGeneralCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where lower(g." + pojoPropertyCode + ") ='"
								+ code.toLowerCase() + "'");*/
				// commented by amit das on 01-08-2017
				// added by amit das on 01-08-2017
				duplicateGeneralCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where lower(g." + pojoPropertyCode + ") = ? ",code.toLowerCase());
				
				
				
			}
			/*
			 * Code for PO DILIVERY TERM JSP
			 * Code By Mukesh Narayan SIngh
			 * Date 30 Aug 2010
			 */
			if(!description.equals("")){
				if (pojoPropertyName!=null && !pojoPropertyName.equals("") && !description.equals("")) {
					/*duplicateGeneralNameList = getHibernateTemplate().find(
							"from jkt.hms.masters.business." + pojoName
							+ " as g where lower(g." + pojoPropertyName + ") = '"
							+ name.toLowerCase() + "' and lower(g." + pojoPropertyDescription + ") = '"
							+ description.toLowerCase() + "'");*/
					// commented by amit das on 01-08-2017
					// added by amit das on 01-08-2017
					duplicateGeneralNameList = getHibernateTemplate().find(
							"from jkt.hms.masters.business." + pojoName
							+ " as g where lower(g." + pojoPropertyName + ") = '"
							+ name.toLowerCase() + "' and lower(g." + pojoPropertyDescription + ") = ?",description.toLowerCase());
					
				}
			}else{
				if (pojoPropertyName!=null && !pojoPropertyName.equals("")) {
					/*duplicateGeneralNameList = getHibernateTemplate().find(
							"from jkt.hms.masters.business." + pojoName
							+ " as g where lower(g." + pojoPropertyName + ") = '"
							+ name.toLowerCase() + "'");*/
					// commented by amit das on 01-08-2017
					// added by amit das on 01-08-2017
					duplicateGeneralNameList = getHibernateTemplate().find(
							"from jkt.hms.masters.business." + pojoName
							+ " as g where lower(g." + pojoPropertyName + ") = ?", name.toLowerCase());
				}
			}
			if (pojoPropertyAddress!=null && !pojoPropertyAddress.equals("")) {
				/*duplicateGeneralAddressList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where lower(g." + pojoPropertyAddress
								+ ") ='" + address.toLowerCase() + "'");*/
				// commented by amit das on 01-08-2017
				// added by amit das on 01-08-2017
				duplicateGeneralAddressList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where lower(g." + pojoPropertyAddress
								+ ") = ?",address.toLowerCase());
			}
			if (invShortCode!=null && !invShortCode.equals("")) {
				duplicateShortCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
						+ " as g where lower(g." + "InvestigationShortCode" + ") = ?", invShortCode.toLowerCase());
			}
		} else if (generalMap.get("flag") != null && (notifiableDisease==null && pregister==null)) {
			/*duplicateMastersList = getHibernateTemplate().find("from jkt.hms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.Id != " + id);*/
			// commented by amit das on 01-08-2017
			// added by amit das on 01-08-2017
			duplicateMastersList = getHibernateTemplate().find("from jkt.hms.masters.business." + pojoName
					+ " as g where g." + pojoPropertyName + " = ? and g.Id != ?",name,id);
			
			if (invShortCode!=null && !invShortCode.equals("")) {
				duplicateShortCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
						+ " as g where lower(g." + "InvestigationShortCode" + ") = ? and g.Id != ?", invShortCode.toLowerCase());
			}
			
		}
		
		if (priority!=0) {
			/*duplicateGeneralPriorityList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as g where g.Priority" 
							+ "=" + priority);*/
			// commented by amit das on 01-08-2017
						// added by amit das on 01-08-2017
			duplicateGeneralPriorityList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as g where g.Priority = ? ",priority);
		}
		//Added by Om Tripathi 25/09/2017
		

		map.put("duplicateShortCodeList", duplicateShortCodeList); //Added by Om Tripathi 25/09/2017
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateGeneralPriorityList", duplicateGeneralPriorityList); // Added by Amit Das on 26-02-2016 
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}

	public List getMastersInformationOnChange(Map<String, Object> generalMap) {
		int id = (Integer) generalMap.get("id");
		String pojoName = (String) generalMap.get("pojoName");
		String pojoPropertyName = (String) generalMap.get("pojoPropertyName");

		List onChangeMastersList = getHibernateTemplate().find(
				"from jkt.hms.masters.business." + pojoName
						+ " as g where g.Id = " + id + " order by "
						+ pojoPropertyName + " ");
		return onChangeMastersList;
	}

	public List getMastersListByName(Map<String, Object> mastersEnquiryMap, String status) {
		List listByMastersName = new ArrayList();

		String name = (String) mastersEnquiryMap.get("name");
		String pojoPropertyName = (String) mastersEnquiryMap
				.get("pojoPropertyName");
		String pojoName = (String) mastersEnquiryMap.get("pojoName");

		if (status.equals("y")) {
			listByMastersName = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName + " as g "
							+ "where g." + pojoPropertyName + " like '" + name
							+ "%' and g.Status = 'y' order by "
							+ pojoPropertyName + " ");
		} else {
			listByMastersName = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName + " as g "
							+ "where g." + pojoPropertyName + " like '" + name
							+ "%' order by " + pojoPropertyName + " ");
		}

		return listByMastersName;
	}

	public List getTableRecords(Map<String, Object> mapForDs) {
		List enquiryList = new ArrayList();
		String pojoName = (String) mapForDs.get("pojoName");
		String searchName = (String) mapForDs.get("searchName");
		String pojoPropertyName = (String) mapForDs.get("pojoPropertyName");
		try {
			enquiryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as master where master." + pojoPropertyName
							+ " like '" + searchName + "%'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enquiryList;
	}

	public List getAllMasterRecords(String masterName) {
		List masterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business." + masterName
						+ " as  master where lower(master.Status) = 'y'");
		return masterList;
	}

	public MasApplication getAppIdObject(String appId) {
		List list = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication as am where am.Id = '"
						+ appId + "'");
		return (MasApplication) list.get(0);

	}

	public Map<String, Object> getBreadCrumbs(String appId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List appList = getAppList();
		List<MasApplication> parentList = new Vector<MasApplication>();
		parentList = getParentLink(appList, appId, parentList);
		String parentLink = "";
		if (parentList.size() == 0) {
			parentLink = "<a href='../hms/common?method=showHome"
					+ "'>Home</a>";
		} else if (parentList.size() > 0) {
			for (int i = 0; i < parentList.size(); i++) {
				MasApplication appObj = (MasApplication) parentList.get(i);
				if (appObj.getParentId() == null
						&& !(appObj.getId().equals(appId))) {
					parentLink = " > " + appObj.getName() + " " + parentLink;
				} else if (appObj.getParentId() != null
						&& !(appObj.getId().equals(appId))) {
					parentLink = " > " + appObj.getName() + " " + parentLink;
				}
			}
			parentLink = "<a href='../hms/common?method=showHome"
					+ "'>Home</a>" + parentLink;
		}
		map.put("breadCrumbs", parentLink);
		return map;
	}

	public List getAppList() {
		Session session = getSession();
		List appList = new ArrayList();
		try {
			appList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasApplication as am");
		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return appList;
	}

	protected List<MasApplication> getParentLink(List _fullList, String appId,
			List<MasApplication> parentList) {
		for (Iterator iter = _fullList.iterator(); iter.hasNext();) {
			MasApplication app = (MasApplication) iter.next();
			if (app.getId().equals(appId)) {
				if (app.getParentId() == null) {
					parentList.add(app);
					break;
				} else {
					parentList.add(app);
					String parentId = app.getParentId();
					parentList = getParentLink(_fullList, parentId, parentList);
				}
			}
		}
		return parentList;
	}

	public Map checkForExistingMastersForHrms(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();
		List duplicateGeneralShortCodeList = new ArrayList();
		
		int id = 0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String invShortCode="";//Added by Om Tripathi 25/09/2017
		String pojoPropertyName = "";
		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}

		String name = (String) generalMap.get("name");
		String pojoName = (String) generalMap.get("pojoName");
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
		//Added by Om Tripathi 25/09/2017
		if (generalMap.get("invShortCode") != null) {
			invShortCode = (String) generalMap
					.get("invShortCode");
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
			if (!pojoPropertyName.equals("")) {
				duplicateGeneralNameList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyName + " = '"
								+ name + "'");
			}
			if (!pojoPropertyAddress.equals("")) {
				duplicateGeneralAddressList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyAddress
								+ " ='" + address + "'");
			}
			//Added by Om Tripathi 25/09/2017
			if (!invShortCode.equals("")) {
				duplicateGeneralShortCodeList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyAddress
								+ " ='" + invShortCode + "'");
			}

		} else if (generalMap.get("flag") != null) {
			duplicateMastersList = getHibernateTemplate().find(
					"from jkt.hrms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.Id != " + id);
		}
		map.put("duplicateGeneralShortCodeList", duplicateGeneralShortCodeList);
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}

	public Map<String, Object> getVillegeListForAutoComplete(
			Map<String, Object> dataMap) {
		Session session = getSession();
		

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> itemList = new ArrayList<MasVillage>();

		try {

			Map<String, Object> utilMap = new HashMap<String, Object>();

			List objectList = new ArrayList();
			String str = (String) dataMap.get("autoHint") + "%";

			Criteria c = session.createCriteria(MasVillage.class)
					.add(Restrictions.like("VillageName", str))
					.add(Restrictions.eq("Status", "y").ignoreCase());

			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("itemList", itemList);

		return map;

	}
	/**
	 * Code Copy From CHAFB
	 * Date 15 FEB 2011
	 * Code By Mukesh
	 */

	public Map<String, Object> getUserButtonRights(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UserButtonRights> userRightsList = new ArrayList<UserButtonRights>();
		Users users = (Users) dataMap.get("users");
		int userId = users.getId();
		try {
			userRightsList = session.createCriteria(UserButtonRights.class)
					.createAlias("Button", "button")
					.createAlias("User", "user").add(
							Restrictions.eq("button.Status", "y")).add(
							Restrictions.eq("user.Id", userId)).list();

			map.put("userRightsList", userRightsList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	
	@Override
	public synchronized String getMaxCode(String pojoName,String pojoPropertyCode) {
		// TODO Auto-generated method stub
		Session sess = getSession();
		String code="0";
		
		String hql = "select  pn."+pojoPropertyCode+"   from "+pojoName+" pn  order by Id desc" ;
	
		List codeList = sess.createQuery(hql).list();
		/*System.out.println(code.size()+"code>>"+code.get(0));*/
		if(codeList.size()>0)
			code = ""+codeList.get(0);
	
			if(code!=null && !code.equals("0") && !code.isEmpty())
			code = ""+(Integer.parseInt(code)+1);
		
		
		return code;
	} 

	@Override
	public Map<String, Object> getVisitPendingListForPatientGrid(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		List<Visit> visits = new ArrayList<Visit>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		int hospitalId=0;
		String uhid="";
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		Criteria cr = session
				.createCriteria(Visit.class)
				.createAlias("Hospital", "hospital")
				.createAlias("Department", "dept")
				.createAlias("Hin", "hin")/*
				.add(Restrictions.ne("VisitStatus", "c").ignoreCase())
					.add(Restrictions.ne("VisitStatus", "a").ignoreCase())*/  // commented by Amit Das on 15-03-2016
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("VisitStatus", "w").ignoreCase()) // added by Amit Das on 15-03-2016
				.add(Restrictions.eq("dept.DepartmentCode", "PHAR").ignoreCase())
				.add(Restrictions.eq("VisitDate",date));
		if(dataMap.get("uhid")!=null && dataMap.get("uhid")!=""){
			uhid=(String) dataMap.get("uhid");
			cr=cr.add(Restrictions.eq("hin.HinNo", uhid));
		}
		 visits=cr.list();
		map.put("visits", visits);
		return map;
	}
	


}