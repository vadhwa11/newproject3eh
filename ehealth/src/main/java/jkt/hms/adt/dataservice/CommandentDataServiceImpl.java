package jkt.hms.adt.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.SilDilStatus;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommandentDataServiceImpl extends HibernateDaoSupport implements
		CommandentDataService {

	Session session;

	/**
	 * ---------------------------------- Today Admission and SIL/DIL
	 * ------------------------------------- made by Mansi Gagrani
	 * 
	 * @param generalMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Inpatient> showTodayAdmission(Map<String, Object> map) {
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		session = getSession();
		Date currentDate = null;
		int deptId = 0;
		int hospitalId = (Integer) map.get("hospitalId");
		currentDate = (Date) map.get("currentDate");
		deptId = (Integer) map.get("deptId");
		// inpatientList =
		// session.createCriteria(Inpatient.class).add(Restrictions.eq("DateOfAddmission",
		// currentDate)).add(Restrictions.eq("Department.Id", deptId)).list();
		inpatientList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("AdStatus", "A"))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).list();
		return inpatientList;
	}

	@SuppressWarnings("unchecked")
	public List<SilDilStatus> showTodaySILDILJsp(Map<String, Object> map) {
		List<SilDilStatus> silDilStatusList = new ArrayList<SilDilStatus>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Date currentDate = null;
		int deptId = 0;
		int hospitalId = (Integer) map.get("hospitalId");
		currentDate = (Date) map.get("currentDate");
		deptId = (Integer) map.get("deptId");
		session = getSession();
		silDilStatusList = session.createCriteria(SilDilStatus.class)
				.add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.ne("ConditionStatus", "Normal"))
				.createAlias("Inpatient", "in").createAlias("in.Hospital", "H")
				.add(Restrictions.eq("H.Id", hospitalId)).list();
		List l = new ArrayList();
		l.add("DIL");
		l.add("SIL");
		// inpatientList =
		// session.createCriteria(Inpatient.class).add(Restrictions.eq("Department.Id",
		// deptId)).add(Restrictions.eq("AdStatus",
		// "A")).add(Restrictions.in("ConditionStatus",l)).list();
		return silDilStatusList;
	}

	/**
	 * ---------------------------------- ADT BED STATUS
	 * ------------------------------------- made by Priyanka Garg
	 * 
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map<String, Object> showBedStateJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List bedStatusList = new ArrayList();
		Date currentDate = null;
		List sumList = new ArrayList();
		session = getSession();
		currentDate = (Date) generalMap.get("currentDate");
		int toYear = 1900 + currentDate.getYear();
		int toMonth = currentDate.getMonth() + 1;
		int hospitalId = (Integer) generalMap.get("hospitalId");
		String dateTo = Integer.toString(toYear) + "-"
				+ Integer.toString(toMonth) + "-"
				+ Integer.toString(currentDate.getDate());

		/*
		 * String qry="select ifnull(adm,0) , ifnull(DIL,0),ifnull(SIL,0),
		 * dt.department_id, dt.department_name from mas_department dt left join
		 * " + "(SELECT count(*) adm ,department_id FROM inpatient where
		 * date_of_addmission='"+dateTo+"' group by department_id) a " + "on
		 * a.department_id=dt.department_id "+ "left join (SELECT count(*) as
		 * DIL, department_id FROM sil_dil_status s " + "where
		 * last_chg_date='"+dateTo+"' and condition_status='DIL' group by
		 * department_id) b "+ "on b.department_id=dt.department_id "+ "left
		 * join (SELECT count(*) as SIL, department_id FROM sil_dil_status s " +
		 * "where last_chg_date='"+dateTo+"' and condition_status='SIL' group by
		 * department_id) c "+ "on c.department_id=dt.department_id ";
		 * 
		 * bedStatusList = session.createSQLQuery(qry).list();
		 * 
		 * String sumQry="select sum(tot) as sumtot from (select (ifnull(adm,0)+
		 * ifnull(DIL,0)+ ifnull(SIL,0)) tot from mas_department dt left join "
		 * + "(SELECT count(*) adm ,department_id FROM inpatient where
		 * date_of_addmission='"+dateTo+"' group by department_id) a " + "on
		 * a.department_id=dt.department_id "+ "left join (SELECT count(*) as
		 * DIL, department_id FROM sil_dil_status s " + "where
		 * last_chg_date='"+dateTo+"' and condition_status='DIL' group by
		 * department_id) b "+ "on b.department_id=dt.department_id "+ "left
		 * join (SELECT count(*) as SIL, department_id FROM sil_dil_status s " +
		 * "where last_chg_date='"+dateTo+"' and condition_status='SIL' group by
		 * department_id) c "+ "on c.department_id=dt.department_id)d ";
		 */

		/*
		 * Query modified by K.R. Othivadivel,on 16.07.2008
		 */

		String qry = " select b.department_name, count(b.department_id) dept_count, "
				+ " sum(case condition_status when 'SIL' Then 1 else 0 end) condition_sil, "
				+ " sum(case condition_status when 'DIL' Then 1 else 0 end) condition_dil, "
				+ " sum(case diet_type when 'Veg' Then 1 else 0 end) diet_veg, "
				+ " sum(case diet_type when 'Non-Veg' Then 1 else 0 end) diet_nonveg, b.department_id, b.bed_strength "
				+ " from inpatient a , mas_department b "
				+ " where a.ad_status = 'A' and a.department_id = b.department_id and a.hospital_id='"+hospitalId+"' "
				+ " group by b.department_id ,b.department_name, b.bed_strength";

		bedStatusList = session.createSQLQuery(qry).list();

		// sumList = session.createSQLQuery(sumQry).list();
		map.put("bedStatusList", bedStatusList);
		map.put("sumList", sumList);

		return map;
	}

}
