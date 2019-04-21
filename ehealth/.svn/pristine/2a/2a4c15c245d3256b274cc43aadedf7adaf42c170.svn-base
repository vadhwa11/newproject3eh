package jkt.hrms.applicant.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.util.Box;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RegistrationDataServiceImpl extends HibernateDaoSupport implements
		RegistrationDataService {
	@SuppressWarnings("unchecked")
	public Map<String, Object> showApplicantRegistrationJsp() {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();

		try {
			titleList = session.createCriteria(MasTitle.class)
					.add(Restrictions.eq("Status", "y")).list();
			countryList = session.createCriteria(MasCountry.class)
					.add(Restrictions.eq("Status", "y")).list();
			stateList = session.createCriteria(MasState.class)
					.add(Restrictions.eq("Status", "y")).list();
			districtList = session
					.createQuery(
							"select dist from MasDistrict as dist order by dist.DistrictName ")
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("titleList", titleList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);

		return map;
	}
	
	
}
