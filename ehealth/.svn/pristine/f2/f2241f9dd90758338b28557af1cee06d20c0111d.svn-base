package jkt.hrms.masters.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HrmsCommonMasterDataServiceImpl extends HibernateDaoSupport
		implements HrmsCommonMasterDataService {

	// -----------------General Methods for All Masters By Rajendra
	// Kumar-------------------

	public List getMastersList(Map<String, Object> generalMap) {
		String pojoName = (String) generalMap.get("pojoName");
		String pojoPropertyName = (String) generalMap.get("pojoPropertyName");
		List mastersList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business." + pojoName
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
		int id = 0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
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

		} else if (generalMap.get("flag") != null) {
			boolean flag = (Boolean) generalMap.get("flag");
			duplicateMastersList = getHibernateTemplate().find(
					"from jkt.hrms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.Id != " + id);
		}
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}

	public List getMastersInformationOnChange(Map<String, Object> generalMap) {
		int id = (Integer) generalMap.get("id");
		String pojoName = (String) generalMap.get("pojoName");
		String pojoPropertyName = (String) generalMap.get("pojoPropertyName");

		List onChangeMastersList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business." + pojoName
						+ " as g where g.Id = " + id + " order by "
						+ pojoPropertyName + " ");
		return onChangeMastersList;
	}

	public List getMastersListByName(Map mastersEnquiryMap, String status) {
		List listByMastersName = new ArrayList();

		String name = (String) mastersEnquiryMap.get("name");
		String pojoPropertyName = (String) mastersEnquiryMap
				.get("pojoPropertyName");
		String pojoName = (String) mastersEnquiryMap.get("pojoName");

		if (status.equals("y")) {
			listByMastersName = getHibernateTemplate().find(
					"from jkt.hrms.masters.business." + pojoName + " as g "
							+ "where g." + pojoPropertyName + " like '" + name
							+ "%' and g.Status = 'y' order by "
							+ pojoPropertyName + " ");
		} else {
			listByMastersName = getHibernateTemplate().find(
					"from jkt.hrms.masters.business." + pojoName + " as g "
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
					"from jkt.hrms.masters.business." + pojoName
							+ " as master where master." + pojoPropertyName
							+ " like '" + searchName + "%'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enquiryList;
	}

	public List getAllMasterRecords(String masterName) {
		List masterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business." + masterName
						+ " as  master where master.Status = 'y'");
		return masterList;
	}

}
