package jkt.hrms.masters.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrArrear;
import jkt.hrms.masters.business.HrBonusDetail;
import jkt.hrms.masters.business.HrEmployeeInvestment;
import jkt.hrms.masters.business.HrEmployeeOtherEarning;
import jkt.hrms.masters.business.HrEmployeePayElements;
import jkt.hrms.masters.business.HrEmployeePayStructure;
import jkt.hrms.masters.business.HrItaxDetails;
import jkt.hrms.masters.business.HrItaxHeader;
import jkt.hrms.masters.business.HrMasFinancialYear;
import jkt.hrms.masters.business.HrMasInvestmentType;
import jkt.hrms.masters.business.HrMasItaxCheckCode;
import jkt.hrms.masters.business.HrMasItaxExemption;
import jkt.hrms.masters.business.HrMasItaxIncomeCode;
import jkt.hrms.masters.business.HrMasItaxSecInvestment;
import jkt.hrms.masters.business.HrMasItaxSlab;
import jkt.hrms.masters.business.HrMasItaxSurcharge;
import jkt.hrms.masters.business.HrMasSurcharge;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class IncomeTaxMasDataServiceImpl extends HibernateDaoSupport implements
		IncomeTaxMasDataService {
	@SuppressWarnings("unchecked")
	public Map showIncomeTaxSlabJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<HrMasItaxSlab> searchItaxSlabMasterList = session.createCriteria(
				HrMasItaxSlab.class).list();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		if (searchItaxSlabMasterList != null) {
			map.put("searchItaxSlabMasterList", searchItaxSlabMasterList);
		}
		if (hrMasFinancialYearList != null) {
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map searchItaxSlabMaster(Float taxRate, String financialYear) {
		List<HrMasItaxSlab> searchItaxSlabMasterList = new ArrayList<HrMasItaxSlab>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		try {
			if (taxRate != null || financialYear == null) {

				searchItaxSlabMasterList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasItaxSlab mi where mi.TaxRate = '"
								+ taxRate + "' order by mi.TaxRate");
			} else {
				searchItaxSlabMasterList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasItaxSlab mi where mi.FinancialYear like '"
								+ financialYear
								+ "%' order by mi.FinancialYear");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		generalMap.put("searchItaxSlabMasterList", searchItaxSlabMasterList);
		return generalMap;
	}

	public boolean addIncomeTaxSlabMaster(HrMasItaxSlab hrMasItaxSlab) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasItaxSlab);
		hbt.refresh(hrMasItaxSlab);
		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean editIncomeTaxSlabMaster(Map map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String taxRate = "";
		String financialyear = "";
		int hospitalId = 0;
		int slabId = 0;
		String lowerLimit = "";
		String upperLimit = "";
		String citizen = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		try {
			slabId = (Integer) map.get("id");

			taxRate = (String) map.get("code");
			financialyear = (String) map.get("name");
			lowerLimit = (String) map.get("lowerLimit");
			upperLimit = (String) map.get("upperLimit");
			citizen = (String) map.get("citizen");
			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");
			HrMasItaxSlab hrMasItaxSlab = (HrMasItaxSlab) getHibernateTemplate()
					.load(HrMasItaxSlab.class, slabId);

			hrMasItaxSlab.setId(slabId);
			hrMasItaxSlab.setTaxRate(new BigDecimal(taxRate));
			HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
			hrMasFinancialYear.setId(new Integer(financialyear));
			hrMasItaxSlab.setFinancialYear(hrMasFinancialYear);
			hrMasItaxSlab.setLowerLimit(new BigDecimal(lowerLimit));
			hrMasItaxSlab.setUpperLimit(new BigDecimal(upperLimit));
			hrMasItaxSlab.setCitizen(citizen);
			hrMasItaxSlab.setLastChgBy(changedBy);
			hrMasItaxSlab.setLastChgDate(currentDate);
			hrMasItaxSlab.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxSlab);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteIncomeTaxSlabMaster(int slabid, Map generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasItaxSlab hrMasItaxSlab = new HrMasItaxSlab();
			hrMasItaxSlab = (HrMasItaxSlab) getHibernateTemplate().load(
					HrMasItaxSlab.class, slabid);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasItaxSlab.getStatus().equals("y")) {
				hrMasItaxSlab.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasItaxSlab.setStatus("y");
				dataDeleted = false;
			}
			hrMasItaxSlab.setLastChgBy(changedBy);
			hrMasItaxSlab.setLastChgDate(currentDate);
			hrMasItaxSlab.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxSlab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map showFinancialJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<HrMasFinancialYear> searchFinancialYearMasterList = session
				.createCriteria(HrMasFinancialYear.class).list();

		if (searchFinancialYearMasterList != null) {
			map.put("searchFinancialYearMasterList",
					searchFinancialYearMasterList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map searchFinancialYearMaster(String year, String financialYear) {
		List<HrMasFinancialYear> searchFinancialYearMasterList = new ArrayList<HrMasFinancialYear>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			if (year != null || financialYear == null) {

			/*	searchFinancialYearMasterList = getHibernateTemplate()
						.find(
								"from jkt.hrms.masters.business.HrMasFinancialYear mi where mi.YearDescription like '"
										+ year
										+ "%' order by mi.YearDescription");*/
				searchFinancialYearMasterList =session.createCriteria(HrMasFinancialYear.class).add(Restrictions.like("YearDescription","%"+year+"%").ignoreCase()).addOrder(Order.asc("YearDescription")).list();
				
				
			} else {
			/*	searchFinancialYearMasterList = getHibernateTemplate()
						.find(
								"from jkt.hrms.masters.business.HrMasFinancialYear mi where mi.FinancialYear like '"
										+ financialYear
										+ "%' order by mi.FinancialYear");
				*/
				searchFinancialYearMasterList =session.createCriteria(HrMasFinancialYear.class).add(Restrictions.like("FinancialYear","%"+financialYear+"%").ignoreCase()).addOrder(Order.asc("FinancialYear")).list();
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("searchFinancialYearMasterList",
				searchFinancialYearMasterList);
		return generalMap;
	}

	// Start Added by Ramdular
	// +++++++++++++++++++++++++++++++++++++++++++++++2011/04/14

	@SuppressWarnings("unchecked")
	public Map showIncomeTaxExemptJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<HrMasItaxExemption> searchItaxExemptMasterList = session
				.createCriteria(HrMasItaxExemption.class).list();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		if (searchItaxExemptMasterList != null) {
			map.put("searchItaxExemptMasterList", searchItaxExemptMasterList);
		}
		if (hrMasFinancialYearList != null) {
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map searchIncomeTaxExemptMaster(String financialYear) {
		Session session = (Session) getSession();
		List<HrMasItaxExemption> searchItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (hrMasFinancialYearList != null) {
			generalMap.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}

		Integer fYear = Integer.parseInt(financialYear);
		try {
			if (fYear != null) {

				searchItaxExemptMasterList = session.createCriteria(
						HrMasItaxExemption.class).add(
						Restrictions.eq("FinancialYear.Id", fYear)).list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap
				.put("searchItaxExemptMasterList", searchItaxExemptMasterList);
		return generalMap;
	}

	public boolean addIncomeTaxExemptMaster(
			HrMasItaxExemption hrMasItaxExemption) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasItaxExemption);
		hbt.refresh(hrMasItaxExemption);
		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean editIncomeTaxExemptMaster(Map map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String sectionCode = "";
		String financialyear = "";
		int hospitalId = 0;
		int id = 0;
		String minAmt = "";
		String maxAmt = "";
		String exemptionBase = "";
		String exemptionPercent = "";
		String maxExemption = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String secDesc = "";
		try {
			id = (Integer) map.get("id");

			sectionCode = (String) map.get("code");
			secDesc = (String) map.get("secDesc");
			financialyear = (String) map.get("name");
			minAmt = (String) map.get("minAmt");
			maxAmt = (String) map.get("maxAmt");
			exemptionBase = (String) map.get("exemptionBase");
			exemptionPercent = (String) map.get("exemptionPercent");
			maxExemption = (String) map.get("maxExemption");

			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");
			HrMasItaxExemption hrMasItaxExemption = (HrMasItaxExemption) getHibernateTemplate()
					.load(HrMasItaxExemption.class, id);

			hrMasItaxExemption.setId(id);
			hrMasItaxExemption.setSectionCode(sectionCode);
			hrMasItaxExemption.setSectionDesc(secDesc);
			HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
			hrMasFinancialYear.setId(new Integer(financialyear));

			hrMasItaxExemption.setFinancialYear(hrMasFinancialYear);
			hrMasItaxExemption.setMinimumAmt(new BigDecimal(minAmt));
			hrMasItaxExemption.setMaximumAmt(new BigDecimal(maxAmt));
			hrMasItaxExemption.setExemptionBase(exemptionBase);
			hrMasItaxExemption.setMaxExemption(new BigDecimal(maxExemption));
			hrMasItaxExemption.setExemptionPercentage(new BigDecimal(
					exemptionPercent));
			hrMasItaxExemption.setLastChgBy(changedBy);
			hrMasItaxExemption.setLastChgDate(currentDate);
			hrMasItaxExemption.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxExemption);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteIncomeTaxExemptMaster(int id, Map generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasItaxExemption hrMasItaxExemption = new HrMasItaxExemption();
			hrMasItaxExemption = (HrMasItaxExemption) getHibernateTemplate()
					.load(HrMasItaxExemption.class, id);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasItaxExemption.getStatus().equals("y")) {
				hrMasItaxExemption.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasItaxExemption.setStatus("y");
				dataDeleted = false;
			}
			hrMasItaxExemption.setLastChgBy(changedBy);
			hrMasItaxExemption.setLastChgDate(currentDate);
			hrMasItaxExemption.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxExemption);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

	@SuppressWarnings("unchecked")
	public Map copyIncomeTaxExemptMaster(int copyFromYear, int copyToYear) {
		String msg = "";
		boolean dataCopied = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		String changedBy = "";

		String sectionCode = "";
		String secDesc = "";
		BigDecimal maxExemption;
		BigDecimal minAmt;
		BigDecimal maxAmt;
		BigDecimal exemptionPercent;
		String exemptionBase = "";

		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<HrMasItaxExemption> prevItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
		List<HrMasItaxExemption> newItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
		List<HrMasItaxExemption> searchItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
		HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();

		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (hrMasFinancialYearList != null) {
			generalMap.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}

		Integer fYear = copyFromYear;
		try {
			if (fYear != null) {

				prevItaxExemptMasterList = session.createCriteria(
						HrMasItaxExemption.class).add(
						Restrictions.eq("FinancialYear.Id", fYear)).list();
			}
			Integer tYear = copyToYear;

			if (tYear != null) {

				newItaxExemptMasterList = session.createCriteria(
						HrMasItaxExemption.class).add(
						Restrictions.eq("FinancialYear.Id", tYear)).list();
			}

			if (prevItaxExemptMasterList.size() <= 0) {
				msg = "From Year Having no records";
			} else if (newItaxExemptMasterList.size() > 0) {
				msg = "Already Records Exist for To Year";
			}

			if ((prevItaxExemptMasterList.size() > 0)
					&& (newItaxExemptMasterList.size() <= 0)) {

				hrMasFinancialYear.setId(tYear);
				for (HrMasItaxExemption prevHrMasItaxExemption : prevItaxExemptMasterList) {
					HrMasItaxExemption itaxExemptMasterObj = new HrMasItaxExemption();
					sectionCode = prevHrMasItaxExemption.getSectionCode();
					secDesc = prevHrMasItaxExemption.getSectionDesc();
					maxExemption = prevHrMasItaxExemption.getMaxExemption();
					maxAmt = prevHrMasItaxExemption.getMaximumAmt();
					minAmt = prevHrMasItaxExemption.getMinimumAmt();
					exemptionPercent = prevHrMasItaxExemption
							.getExemptionPercentage();
					exemptionBase = prevHrMasItaxExemption.getExemptionBase();

					itaxExemptMasterObj.setExemptionBase(exemptionBase);
					itaxExemptMasterObj
							.setExemptionPercentage(exemptionPercent);
					itaxExemptMasterObj.setSectionCode(sectionCode);
					itaxExemptMasterObj.setSectionDesc(secDesc);
					itaxExemptMasterObj.setMaxExemption(maxExemption);
					itaxExemptMasterObj.setMaximumAmt(maxAmt);
					itaxExemptMasterObj.setMinimumAmt(minAmt);
					itaxExemptMasterObj.setStatus("y");
					itaxExemptMasterObj.setLastChgBy("Admin");
					itaxExemptMasterObj.setLastChgDate(currentDate);
					itaxExemptMasterObj.setLastChgTime(currentTime);
					itaxExemptMasterObj.setFinancialYear(hrMasFinancialYear);

					hbt.save(itaxExemptMasterObj);
					hbt.refresh(itaxExemptMasterObj);
					msg = "Data Update Successfully";
					searchItaxExemptMasterList = session.createCriteria(
							HrMasItaxExemption.class).add(
							Restrictions.eq("FinancialYear.Id", tYear)).list();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap
				.put("searchItaxExemptMasterList", searchItaxExemptMasterList);
		generalMap.put("message", msg);
		return generalMap;
	}

	public boolean addFinancialYearMaster(HrMasFinancialYear hrMasFinancialYear) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasFinancialYear);
		hbt.refresh(hrMasFinancialYear);
		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean editFinancialYearMaster(Map map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String year = "";
		String financialyear = "";
		Date fromDate = null;
		Date toDate = null;
		int financialYrId = 0;

		int userId = 0;

		try {
			financialYrId = (Integer) map.get("id");
			fromDate = (Date) map.get("fromDate");
			toDate = (Date) map.get("toDate");
			year = (String) map.get("code");
			financialyear = (String) map.get("name");
			userId= (Integer) map.get("userId");
			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");
			HrMasFinancialYear hrMasFinancialYear = (HrMasFinancialYear) getHibernateTemplate()
					.load(HrMasFinancialYear.class, financialYrId);

			hrMasFinancialYear.setId(financialYrId);
			hrMasFinancialYear.setFinancialYear(financialyear);
			hrMasFinancialYear.setYearDescription(year);
			hrMasFinancialYear.setYearFromDate(fromDate);
			hrMasFinancialYear.setYearToDate(toDate);
			//hrMasFinancialYear.setLastChgBy(changedBy);
			Users users = new Users();
			users.setId(userId);
			hrMasFinancialYear.setLastChgBy(users);
			hrMasFinancialYear.setLastChgDate(currentDate);
			hrMasFinancialYear.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasFinancialYear);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map showSectionInvestmentJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<HrMasItaxSecInvestment> searchItaxSecInvestmentMasterList = session
				.createCriteria(HrMasItaxSecInvestment.class).list();
		List<HrMasInvestmentType> hrMasInvestmentTypeList = session
				.createCriteria(HrMasInvestmentType.class).add(
						Restrictions.eq("Status", "y")).list();
		List<HrMasItaxExemption> hrMasItaxExemptionList = session
				.createCriteria(HrMasItaxExemption.class).add(
						Restrictions.eq("Status", "y")).list();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		if (searchItaxSecInvestmentMasterList != null) {
			map.put("searchItaxSecInvestmentMasterList",
					searchItaxSecInvestmentMasterList);
		}
		if (hrMasInvestmentTypeList != null) {
			map.put("hrMasInvestmentTypeList", hrMasInvestmentTypeList);
		}
		if (hrMasItaxExemptionList != null) {
			map.put("hrMasItaxExemptionList", hrMasItaxExemptionList);
		}
		if (hrMasFinancialYearList != null) {
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map copySectionInvestmentJsp(int copyFromYear, int copyToYear) {
		String msg = "";
		boolean dataCopied = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "Admin";

		String sectionCode = "";
		BigDecimal maxAmt;
		String investmentType = "";
		BigDecimal benefitPercent;
		String basicDep = "";
		String monthlyDep = "";

		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<HrMasItaxSecInvestment> prevHrMasItaxSecInvestmentList = new ArrayList<HrMasItaxSecInvestment>();
		List<HrMasItaxSecInvestment> newHrMasItaxSecInvestmentList = new ArrayList<HrMasItaxSecInvestment>();
		List<HrMasItaxSecInvestment> searchItaxSecInvestmentMasterList = new ArrayList<HrMasItaxSecInvestment>();
		HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
		HrMasInvestmentType hrMasInvestmentType = new HrMasInvestmentType();
		HrMasItaxExemption hrMasItaxExemption = new HrMasItaxExemption();

		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		List<HrMasInvestmentType> hrMasInvestmentTypeList = session
				.createCriteria(HrMasInvestmentType.class).add(
						Restrictions.eq("Status", "y")).list();
		List<HrMasItaxExemption> hrMasItaxExemptionList = session
				.createCriteria(HrMasItaxExemption.class).add(
						Restrictions.eq("Status", "y")).list();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (hrMasFinancialYearList != null) {
			generalMap.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		if (hrMasInvestmentTypeList != null) {
			generalMap.put("hrMasInvestmentTypeList", hrMasInvestmentTypeList);
		}
		if (hrMasItaxExemptionList != null) {
			generalMap.put("hrMasItaxExemptionList", hrMasItaxExemptionList);
		}

		Integer fYear = copyFromYear;
		try {
			if (fYear != null) {

				prevHrMasItaxSecInvestmentList = session.createCriteria(
						HrMasItaxSecInvestment.class).add(
						Restrictions.eq("FinancialYear.Id", fYear)).list();
			}
			Integer tYear = copyToYear;

			if (tYear != null) {

				newHrMasItaxSecInvestmentList = session.createCriteria(
						HrMasItaxSecInvestment.class).add(
						Restrictions.eq("FinancialYear.Id", tYear)).list();
			}


			if (prevHrMasItaxSecInvestmentList.size() <= 0) {
				msg = "From Year Having no records";
			} else if (newHrMasItaxSecInvestmentList.size() > 0) {
				msg = "Already Records Exist for To Year";
			}

			if ((prevHrMasItaxSecInvestmentList.size() > 0)
					&& (newHrMasItaxSecInvestmentList.size() <= 0)) {

				hrMasFinancialYear.setId(tYear);

				for (HrMasItaxSecInvestment hrMasItaxSecInvestment : prevHrMasItaxSecInvestmentList) {
					HrMasItaxSecInvestment hrMasItaxSecInvestmentObj = new HrMasItaxSecInvestment();
					hrMasInvestmentType.setId(hrMasItaxSecInvestment
							.getInvestmentType().getId());
					hrMasItaxExemption.setId(hrMasItaxSecInvestment
							.getHrMasItaxExemption().getId());
					benefitPercent = hrMasItaxSecInvestment.getBenefitPercent();
					maxAmt = hrMasItaxSecInvestment.getMaxAmount();
					basicDep = hrMasItaxSecInvestment.getBasicDependent();
					monthlyDep = hrMasItaxSecInvestment.getMonthlyDependent();

					hrMasItaxSecInvestmentObj
							.setHrMasItaxExemption(hrMasItaxExemption);
					hrMasItaxSecInvestmentObj
							.setInvestmentType(hrMasInvestmentType);
					hrMasItaxSecInvestmentObj.setBenefitPercent(benefitPercent);
					hrMasItaxSecInvestmentObj.setBasicDependent(basicDep);
					hrMasItaxSecInvestmentObj.setMaxAmount(maxAmt);
					hrMasItaxSecInvestmentObj.setMonthlyDependent(monthlyDep);
					hrMasItaxSecInvestmentObj.setStatus("y");
					hrMasItaxSecInvestmentObj.setLastChgBy("Admin");
					hrMasItaxSecInvestmentObj.setLastChgDate(currentDate);
					hrMasItaxSecInvestmentObj.setLastChgTime(currentTime);
					hrMasItaxSecInvestmentObj
							.setFinancialYear(hrMasFinancialYear);

					hbt.save(hrMasItaxSecInvestmentObj);
					hbt.refresh(hrMasItaxSecInvestmentObj);
					msg = "Data Update Successfully";
					searchItaxSecInvestmentMasterList = session.createCriteria(
							HrMasItaxSecInvestment.class).add(
							Restrictions.eq("FinancialYear.Id", tYear)).list();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("searchItaxSecInvestmentMasterList",
				searchItaxSecInvestmentMasterList);
		generalMap.put("hrMasFinancialYearList", hrMasFinancialYearList);
		generalMap.put("hrMasInvestmentTypeList", hrMasInvestmentTypeList);
		generalMap.put("hrMasItaxExemptionList", hrMasItaxExemptionList);

		generalMap.put("message", msg);
		return generalMap;
	}

	@SuppressWarnings("unchecked")
	public Map searchSectionInvestmentJsp(String financialYear) {
		Session session = (Session) getSession();
		List<HrMasItaxSecInvestment> searchItaxSecInvestmentMasterList = session
				.createCriteria(HrMasItaxSecInvestment.class).list();
		List<HrMasInvestmentType> hrMasInvestmentTypeList = session
				.createCriteria(HrMasInvestmentType.class).add(
						Restrictions.eq("Status", "y")).list();
		List<HrMasItaxExemption> hrMasItaxExemptionList = session
				.createCriteria(HrMasItaxExemption.class).add(
						Restrictions.eq("Status", "y")).list();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (hrMasFinancialYearList != null) {
			generalMap.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		if (hrMasInvestmentTypeList != null) {
			generalMap.put("hrMasInvestmentTypeList", hrMasInvestmentTypeList);
		}
		if (hrMasItaxExemptionList != null) {
			generalMap.put("hrMasItaxExemptionList", hrMasItaxExemptionList);
		}

		Integer fYear = Integer.parseInt(financialYear);
		try {
			if (fYear != null) {

				searchItaxSecInvestmentMasterList = session.createCriteria(
						HrMasItaxSecInvestment.class).add(
						Restrictions.eq("FinancialYear.Id", fYear)).list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("searchItaxSecInvestmentMasterList",
				searchItaxSecInvestmentMasterList);
		return generalMap;
	}

	public boolean addISectionInvestmentJsp(
			HrMasItaxSecInvestment hrMasItaxSecInvestment) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasItaxSecInvestment);
		hbt.refresh(hrMasItaxSecInvestment);
		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean editISectionInvestmentJsp(Map map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		String financialyear = "";
		int hospitalId = 0;
		int id = 0;
		String sectionCode = "";
		String maxAmt = "";
		String investmentType = "";
		String benefitPercent = "";
		String basicDep = "";
		String monthlyDep = "";

		try {
			id = (Integer) map.get("id");

			sectionCode = (String) map.get("sectionCode");
			financialyear = (String) map.get("name");
			benefitPercent = (String) map.get("benefitPercent");
			maxAmt = (String) map.get("maxAmt");
			basicDep = (String) map.get("basicDep");
			monthlyDep = (String) map.get("monthlyDep");
			investmentType = (String) map.get("investmentType");

			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");
			HrMasItaxSecInvestment hrMasItaxSecInvestment = (HrMasItaxSecInvestment) getHibernateTemplate()
					.load(HrMasItaxSecInvestment.class, id);

			hrMasItaxSecInvestment.setId(id);
			HrMasItaxExemption hrMasItaxExemption = new HrMasItaxExemption();
			hrMasItaxExemption.setId(new Integer(sectionCode));
			hrMasItaxSecInvestment.setHrMasItaxExemption(hrMasItaxExemption);

			HrMasInvestmentType hrMasInvestmentType = new HrMasInvestmentType();
			hrMasInvestmentType.setId(new Integer(investmentType));
			hrMasItaxSecInvestment.setInvestmentType(hrMasInvestmentType);

			HrMasFinancialYear financialYear = new HrMasFinancialYear();
			financialYear.setId(new Integer(financialyear));
			hrMasItaxSecInvestment.setFinancialYear(financialYear);
			hrMasItaxSecInvestment.setBenefitPercent(new BigDecimal(
					benefitPercent));
			hrMasItaxSecInvestment.setMaxAmount(new BigDecimal(maxAmt));
			hrMasItaxSecInvestment.setBasicDependent(basicDep);
			hrMasItaxSecInvestment.setMonthlyDependent(monthlyDep);

			hrMasItaxSecInvestment.setStatus("y");

			hrMasItaxSecInvestment.setLastChgDate(currentDate);
			hrMasItaxSecInvestment.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxSecInvestment);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	public boolean deleteISectionInvestmentJsp(int id, Map generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasItaxSecInvestment hrMasItaxSecInvestment = new HrMasItaxSecInvestment();
			hrMasItaxSecInvestment = (HrMasItaxSecInvestment) getHibernateTemplate()
					.load(HrMasItaxSecInvestment.class, id);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasItaxSecInvestment.getStatus().equals("y")) {
				hrMasItaxSecInvestment.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasItaxSecInvestment.setStatus("y");
				dataDeleted = false;
			}
			hrMasItaxSecInvestment.setLastChgBy(changedBy);
			hrMasItaxSecInvestment.setLastChgDate(currentDate);
			hrMasItaxSecInvestment.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxSecInvestment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;

	}

	@SuppressWarnings("unchecked")
	public Map showIncomeTaxSurchargeJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<HrMasItaxSurcharge> searchItaxSurchargeMasterList = session
				.createCriteria(HrMasItaxSurcharge.class).list();
		List<HrMasSurcharge> hrMasSurchargeList = session.createCriteria(
				HrMasSurcharge.class).add(Restrictions.eq("Status", "y"))
				.list();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		if (searchItaxSurchargeMasterList != null) {
			map.put("searchItaxSurchargeMasterList",
					searchItaxSurchargeMasterList);
		}
		if (hrMasSurchargeList != null) {
			map.put("hrMasSurchargeList", hrMasSurchargeList);
		}
		if (hrMasFinancialYearList != null) {
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map copyIncomeTaxSurchargeJsp(int copyFromYear, int copyToYear) {
		String msg = "";
		boolean dataCopied = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "Admin";

		BigDecimal lowerLimit;
		BigDecimal upperLimit;
		BigDecimal minTaxSal = null;
		BigDecimal perOne;
		BigDecimal perTwo;
		String surchargeBase = "";

		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<HrMasItaxSurcharge> prevHrMasItaxSurchargeList = new ArrayList<HrMasItaxSurcharge>();
		List<HrMasItaxSurcharge> newHrMasItaxSurchargeList = new ArrayList<HrMasItaxSurcharge>();
		List<HrMasItaxSurcharge> searchItaxSurchargeMasterList = new ArrayList<HrMasItaxSurcharge>();

		List<HrMasSurcharge> hrMasSurchargeList = session.createCriteria(
				HrMasSurcharge.class).add(Restrictions.eq("Status", "y"))
				.list();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();

		HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
		HrMasSurcharge hrMasSurcharge = new HrMasSurcharge();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (hrMasFinancialYearList != null) {
			generalMap.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		if (hrMasSurchargeList != null) {
			generalMap.put("hrMasSurchargeList", hrMasSurchargeList);
		}

		Integer fYear = copyFromYear;
		try {
			if (fYear != null) {

				prevHrMasItaxSurchargeList = session.createCriteria(
						HrMasItaxSurcharge.class).add(
						Restrictions.eq("FinancialYear.Id", fYear)).list();
			}
			Integer tYear = copyToYear;

			if (tYear != null) {

				newHrMasItaxSurchargeList = session.createCriteria(
						HrMasItaxSurcharge.class).add(
						Restrictions.eq("FinancialYear.Id", tYear)).list();
			}


			if (prevHrMasItaxSurchargeList.size() <= 0) {
				msg = "From Year Having no records";
			} else if (newHrMasItaxSurchargeList.size() > 0) {
				msg = "Already Records Exist for To Year";
			}

			if ((prevHrMasItaxSurchargeList.size() > 0)
					&& (newHrMasItaxSurchargeList.size() <= 0)) {

				hrMasFinancialYear.setId(tYear);

				for (HrMasItaxSurcharge hrMasItaxSurcharge : prevHrMasItaxSurchargeList) {

					lowerLimit = hrMasItaxSurcharge.getLowerLimit();
					upperLimit = hrMasItaxSurcharge.getUpperLimit();
					minTaxSal = hrMasItaxSurcharge.getMinTaxSal();
					perOne = hrMasItaxSurcharge.getPercentOne();
					perTwo = hrMasItaxSurcharge.getPercentTwo();
					surchargeBase = hrMasItaxSurcharge.getSurchargeBase();

					HrMasItaxSurcharge hrMasItaxSurchargeObj = new HrMasItaxSurcharge();
					hrMasSurcharge.setId(hrMasItaxSurcharge.getHrMasSurcharge()
							.getId());

					hrMasItaxSurchargeObj.setLowerLimit(lowerLimit);
					hrMasItaxSurchargeObj.setUpperLimit(upperLimit);
					hrMasItaxSurchargeObj.setMinTaxSal(minTaxSal);
					hrMasItaxSurchargeObj.setPercentOne(perOne);
					hrMasItaxSurchargeObj.setPercentTwo(perTwo);
					hrMasItaxSurchargeObj.setSurchargeBase(surchargeBase);
					hrMasItaxSurchargeObj.setStatus("y");
					hrMasItaxSurchargeObj.setLastChgBy("Admin");
					hrMasItaxSurchargeObj.setLastChgDate(currentDate);
					hrMasItaxSurchargeObj.setLastChgTime(currentTime);
					hrMasItaxSurchargeObj.setFinancialYear(hrMasFinancialYear);
					hrMasItaxSurchargeObj.setHrMasSurcharge(hrMasSurcharge);

					hbt.save(hrMasItaxSurchargeObj);
					hbt.refresh(hrMasItaxSurchargeObj);
					msg = "Data Update Successfully";
					searchItaxSurchargeMasterList = session.createCriteria(
							HrMasItaxSurcharge.class).add(
							Restrictions.eq("FinancialYear.Id", tYear)).list();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("searchItaxSurchargeMasterList",
				searchItaxSurchargeMasterList);
		generalMap.put("hrMasSurchargeList", hrMasSurchargeList);

		generalMap.put("message", msg);
		return generalMap;
	}

	@SuppressWarnings("unchecked")
	public Map searchIncomeTaxSurchargeJsp(String financialYear) {
		Session session = (Session) getSession();
		List<HrMasItaxSurcharge> searchItaxSurchargeMasterList = session
				.createCriteria(HrMasItaxSurcharge.class).list();
		List<HrMasSurcharge> hrMasSurchargeList = session.createCriteria(
				HrMasSurcharge.class).add(Restrictions.eq("Status", "y"))
				.list();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).add(
						Restrictions.eq("Status", "y")).list();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (hrMasSurchargeList != null) {
			generalMap.put("hrMasSurchargeList", hrMasSurchargeList);
		}
		if (hrMasFinancialYearList != null) {
			generalMap.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}

		Integer fYear = Integer.parseInt(financialYear);
		try {
			if (fYear != null) {

				searchItaxSurchargeMasterList = session.createCriteria(
						HrMasItaxSurcharge.class).add(
						Restrictions.eq("FinancialYear.Id", fYear)).list();
			}
			if (searchItaxSurchargeMasterList != null) {
				generalMap.put("searchItaxSurchargeMasterList",
						searchItaxSurchargeMasterList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return generalMap;
	}

	public boolean addIncomeTaxSurchargeJsp(
			HrMasItaxSurcharge hrMasItaxSurcharge) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasItaxSurcharge);
		hbt.refresh(hrMasItaxSurcharge);
		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean editIncomeTaxSurchargeJsp(Map map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		String financialyear = "";
		int hospitalId = 0;
		int id = 0;
		String surchargeCode = "";
		String lowerLimit = "";
		String upperLimit = "";
		BigDecimal minTaxSal = null;
		String perOne = "";
		String perTwo = "";
		String surchargeBase = "";

		try {
			id = (Integer) map.get("id");

			surchargeCode = (String) map.get("surchargeCode");
			financialyear = (String) map.get("name");
			lowerLimit = (String) map.get("lowerLimit");
			upperLimit = (String) map.get("upperLimit");
			minTaxSal = (BigDecimal) map.get("minTaxSal");
			perOne = (String) map.get("perOne");
			perTwo = (String) map.get("perTwo");
			surchargeBase = (String) map.get("surchargeBase");

			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");
			HrMasItaxSurcharge hrMasItaxSurcharge = (HrMasItaxSurcharge) getHibernateTemplate()
					.load(HrMasItaxSurcharge.class, id);

			hrMasItaxSurcharge.setId(id);
			HrMasSurcharge hrMasSurcharge = new HrMasSurcharge();
			hrMasSurcharge.setId(new Integer(surchargeCode));
			hrMasItaxSurcharge.setHrMasSurcharge(hrMasSurcharge);

			HrMasFinancialYear financialYear = new HrMasFinancialYear();
			financialYear.setId(new Integer(financialyear));
			hrMasItaxSurcharge.setFinancialYear(financialYear);
			hrMasItaxSurcharge.setLowerLimit(new BigDecimal(lowerLimit));
			hrMasItaxSurcharge.setUpperLimit(new BigDecimal(upperLimit));
			hrMasItaxSurcharge.setMinTaxSal(minTaxSal);
			hrMasItaxSurcharge.setPercentOne(new BigDecimal(perOne));
			hrMasItaxSurcharge.setPercentTwo(new BigDecimal(perTwo));
			hrMasItaxSurcharge.setSurchargeBase(surchargeBase);
			hrMasItaxSurcharge.setStatus("y");

			hrMasItaxSurcharge.setLastChgDate(currentDate);
			hrMasItaxSurcharge.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxSurcharge);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;

	}

	public boolean deleteIncomeTaxSurchargeJsp(int id, Map generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasItaxSurcharge hrMasItaxSurcharge = new HrMasItaxSurcharge();
			hrMasItaxSurcharge = (HrMasItaxSurcharge) getHibernateTemplate()
					.load(HrMasItaxSurcharge.class, id);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasItaxSurcharge.getStatus().equals("y")) {
				hrMasItaxSurcharge.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasItaxSurcharge.setStatus("y");
				dataDeleted = false;
			}
			hrMasItaxSurcharge.setLastChgBy(changedBy);
			hrMasItaxSurcharge.setLastChgDate(currentDate);
			hrMasItaxSurcharge.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxSurcharge);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map showSurchargeJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<HrMasSurcharge> searchSurchargeList = session.createCriteria(
				HrMasSurcharge.class).list();

		if (searchSurchargeList != null) {
			map.put("searchSurchargeList", searchSurchargeList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map searchSurcharge(String code, String name) {
		List<HrMasSurcharge> searchSurchargeList = new ArrayList<HrMasSurcharge>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		try {
			if (code != null || name == null) {

				searchSurchargeList = getHibernateTemplate()
						.find(
								"from jkt.hrms.masters.business.HrMasSurcharge ms where ms.SurchargeDescription like '"
										+ name
										+ "%' order by ms.SurchargeDescription");
			} else {
				searchSurchargeList = getHibernateTemplate()
						.find(
								"from jkt.hrms.masters.business.HrMasSurcharge ms where ms.SurchargeCode like '"
										+ code + "%' order by ms.SurchargeCode");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("searchSurchargeList", searchSurchargeList);
		return generalMap;
	}

	public boolean addSurcharge(HrMasSurcharge hrMasSurcharge) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasSurcharge);
		hbt.refresh(hrMasSurcharge);
		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean editSurcharge(Map map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String code = "";
		String name = "";

		int surchargeId = 0;

		String changedBy = "";

		try {
			surchargeId = (Integer) map.get("id");
			code = (String) map.get("code");
			name = (String) map.get("name");

			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");
			HrMasSurcharge hrMasSurcharge = (HrMasSurcharge) getHibernateTemplate()
					.load(HrMasSurcharge.class, surchargeId);

			hrMasSurcharge.setId(surchargeId);
			hrMasSurcharge.setSurchargeCode(code);
			hrMasSurcharge.setSurchargeDescription(name);

			hrMasSurcharge.setLastChgBy(changedBy);
			hrMasSurcharge.setLastChgDate(currentDate);
			hrMasSurcharge.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasSurcharge);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteSurcharge(int surchargeId, Map generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasSurcharge hrMasSurcharge = new HrMasSurcharge();
			hrMasSurcharge = (HrMasSurcharge) getHibernateTemplate().load(
					HrMasSurcharge.class, surchargeId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasSurcharge.getStatus().equals("y")) {
				hrMasSurcharge.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasSurcharge.setStatus("y");
				dataDeleted = false;
			}
			hrMasSurcharge.setLastChgBy(changedBy);
			hrMasSurcharge.setLastChgDate(currentDate);
			hrMasSurcharge.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasSurcharge);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map showOtherIncomeCodeJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<HrMasItaxIncomeCode> searchOtherIncomeCodeList = session
				.createCriteria(HrMasItaxIncomeCode.class).list();

		if (searchOtherIncomeCodeList != null) {
			map.put("searchOtherIncomeCodeList", searchOtherIncomeCodeList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map searchOtherIncomeCode(String code, String name) {
		List<HrMasItaxIncomeCode> searchOtherIncomeCodeList = new ArrayList<HrMasItaxIncomeCode>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		try {
			if (code != null || name == null) {

				searchOtherIncomeCodeList = getHibernateTemplate()
						.find(
								"from jkt.hrms.masters.business.HrMasItaxIncomeCode miic where miic.IncomeDesc like '"
										+ name + "%' order by miic.IncomeDesc");
			} else {
				searchOtherIncomeCodeList = getHibernateTemplate()
						.find(
								"from jkt.hrms.masters.business.HrMasItaxIncomeCode miic where miic.IncomeCode like '"
										+ code + "%' order by miic.IncomeCode");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		generalMap.put("searchOtherIncomeCodeList", searchOtherIncomeCodeList);
		return generalMap;
	}

	public boolean addOtherIncomeCode(HrMasItaxIncomeCode hrMasItaxIncomeCode) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMasItaxIncomeCode);
		hbt.refresh(hrMasItaxIncomeCode);
		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean editOtherIncomeCode(Map map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String code = "";
		String name = "";

		int otehrIncomeCodeId = 0;

		String changedBy = "";

		try {
			otehrIncomeCodeId = (Integer) map.get("id");
			code = (String) map.get("code");
			name = (String) map.get("name");

			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");
			HrMasItaxIncomeCode hrMasItaxIncomeCode = (HrMasItaxIncomeCode) getHibernateTemplate()
					.load(HrMasItaxIncomeCode.class, otehrIncomeCodeId);

			hrMasItaxIncomeCode.setId(otehrIncomeCodeId);
			hrMasItaxIncomeCode.setIncomeCode(code);
			hrMasItaxIncomeCode.setIncomeDesc(name);

			hrMasItaxIncomeCode.setLastChgBy(changedBy);
			hrMasItaxIncomeCode.setLastChgDate(currentDate);
			hrMasItaxIncomeCode.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxIncomeCode);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteOtherIncomeCode(int otehrIncomeCodeId, Map generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrMasItaxIncomeCode hrMasItaxIncomeCode = new HrMasItaxIncomeCode();
			hrMasItaxIncomeCode = (HrMasItaxIncomeCode) getHibernateTemplate()
					.load(HrMasItaxIncomeCode.class, otehrIncomeCodeId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrMasItaxIncomeCode.getStatus().equals("y")) {
				hrMasItaxIncomeCode.setStatus("n");
				dataDeleted = true;
			} else {
				hrMasItaxIncomeCode.setStatus("y");
				dataDeleted = false;
			}
			hrMasItaxIncomeCode.setLastChgBy(changedBy);
			hrMasItaxIncomeCode.setLastChgDate(currentDate);
			hrMasItaxIncomeCode.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasItaxIncomeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map showEmployeeOtherEarningJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		List<HrEmployeeOtherEarning> searchEmployeeOtherEarningList = session
				.createCriteria(HrEmployeeOtherEarning.class).list();
		List<HrMasItaxCheckCode> hrMasItaxCheckCodeList = session
				.createCriteria(HrMasItaxCheckCode.class).add(
						Restrictions.eq("Status", "y")).list();
		List<HrMasItaxIncomeCode> hrMasItaxIncomeCodeList = session
				.createCriteria(HrMasItaxIncomeCode.class).add(
						Restrictions.eq("Status", "y")).list();
		List<HrMasFinancialYear> hrMasFinancialYearList = session
				.createCriteria(HrMasFinancialYear.class).list();
		List<MasEmployee> masEmployeeList = session.createCriteria(
				MasEmployee.class).list();
		if (searchEmployeeOtherEarningList != null) {
			map.put("searchEmployeeOtherEarningList",
					searchEmployeeOtherEarningList);
		}
		if (hrMasItaxCheckCodeList != null) {
			map.put("hrMasItaxCheckCodeList", hrMasItaxCheckCodeList);
		}
		if (hrMasItaxIncomeCodeList != null) {
			map.put("hrMasItaxIncomeCodeList", hrMasItaxIncomeCodeList);
		}
		if (hrMasFinancialYearList != null) {
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		if (masEmployeeList != null) {
			map.put("masEmployeeList", masEmployeeList);
		}
		return map;
	}

	public boolean addEmployeeOtherEarning(
			HrEmployeeOtherEarning hrEmployeeOtherEarning) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrEmployeeOtherEarning);
		hbt.refresh(hrEmployeeOtherEarning);
		successfullyAdded = true;

		return successfullyAdded;
	}

	public boolean editEmployeeOtherEarning(Map map) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		String financialyear = "";
		int hospitalId = 0;
		int id = 0;
		String checkCode = "";
		String financialYear = "";
		String incomeAmount = "";
		Date incomeDate = null;
		String empId = "";
		String code = "";

		try {
			id = (Integer) map.get("id");

			checkCode = (String) map.get("checkCode");
			financialYear = (String) map.get("financialYear");
			incomeAmount = (String) map.get("incomeAmount");
			code = (String) map.get("code");
			empId = (String) map.get("empId");
			incomeDate = (Date) map.get("incomeDate");

			currentDate = (Date) map.get("currentDate");
			currentTime = (String) map.get("currentTime");


			HrEmployeeOtherEarning hrEmployeeOtherEarning = (HrEmployeeOtherEarning) getHibernateTemplate()
					.load(HrEmployeeOtherEarning.class, id);

			hrEmployeeOtherEarning.setId(id);
			if (financialYear != "") {
				HrMasFinancialYear hrMasFinancialYear = new HrMasFinancialYear();
				hrMasFinancialYear.setId(new Integer(financialYear));
				hrEmployeeOtherEarning.setFinancialYear(hrMasFinancialYear);
			}

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(new Integer(empId));
			hrEmployeeOtherEarning.setEmp(masEmployee);

			HrMasItaxIncomeCode hrMasIncomeCode = new HrMasItaxIncomeCode();
			hrMasIncomeCode.setId(new Integer(code));
			hrEmployeeOtherEarning.setIncomeCode(hrMasIncomeCode);

			HrMasItaxCheckCode hrMasItaxCheckCode = new HrMasItaxCheckCode();
			hrMasItaxCheckCode.setId(new Integer(checkCode));
			hrEmployeeOtherEarning.setCheckCode(hrMasItaxCheckCode);

			hrEmployeeOtherEarning
					.setIncomeAmount(new BigDecimal(incomeAmount));
			hrEmployeeOtherEarning.setIncomeDate(incomeDate);
			hrEmployeeOtherEarning.setStatus("y");

			hrEmployeeOtherEarning.setLastChgDate(currentDate);
			hrEmployeeOtherEarning.setLastChgTime(currentTime);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrEmployeeOtherEarning);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteEmployeeOtherEarning(int id, Map generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		try {
			HrEmployeeOtherEarning hrEmployeeOtherEarning = new HrEmployeeOtherEarning();
			hrEmployeeOtherEarning = (HrEmployeeOtherEarning) getHibernateTemplate()
					.load(HrEmployeeOtherEarning.class, id);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (hrEmployeeOtherEarning.getStatus().equals("y")) {
				hrEmployeeOtherEarning.setStatus("n");
				dataDeleted = true;
			} else {
				hrEmployeeOtherEarning.setStatus("y");
				dataDeleted = false;
			}
			hrEmployeeOtherEarning.setLastChgBy(changedBy);
			hrEmployeeOtherEarning.setLastChgDate(currentDate);
			hrEmployeeOtherEarning.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrEmployeeOtherEarning);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map showEmployeeInvestmentJsp() {
		Map map = new HashMap();
		Session session = (Session) getSession();
		Criteria crit = getSession().createCriteria(HrMasFinancialYear.class);
		crit = crit.add(Restrictions.eq("Status", "y"));
		crit = crit.addOrder(Order.desc("YearDescription"));
		List<HrMasFinancialYear> hrMasFinancialYearList = crit.list();
		List<HrMasItaxSecInvestment> hrMasItaxSecInvestmentList = new ArrayList<HrMasItaxSecInvestment>();
		List<MasEmployee> masEmployeeList = session.createCriteria(
				MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		hrMasItaxSecInvestmentList = session.createCriteria(
				HrMasItaxSecInvestment.class).add(
				Restrictions.eq("Status", "y")).list();
		if (masEmployeeList != null) {
			map.put("masEmployeeList", masEmployeeList);
		}
		if (hrMasItaxSecInvestmentList != null) {
			map.put("hrMasItaxSecInvestmentList", hrMasItaxSecInvestmentList);
		}
		if (hrMasFinancialYearList != null) {
			map.put("hrMasFinancialYearList", hrMasFinancialYearList);
		}
		return map;
	}

	public Map showITComputationJsp() {
		List employeeList = getEmployeeListForITcomp();
		List finList = getFinancialYearList();
		Map map = new HashMap<String, Object>();
		map.put("employeeList", employeeList);
		map.put("financialYearList", finList);
		return map;
	}

	public List getEmployeeListForITcomp() {
		Criteria criteria = getSession().createCriteria(MasEmployee.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		criteria = criteria.add(Restrictions.eq("EmployeeStatus.Id", 1));
		criteria = criteria.addOrder(Order.asc("FirstName"));
		List<MasEmployee> employeeList = criteria.list();
		return employeeList;
	}

	public List<HrMasFinancialYear> getFinancialYearList() {
		Criteria criteria = getSession().createCriteria(
				HrMasFinancialYear.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		criteria = criteria.addOrder(Order.desc("YearFromDate"));
		List<HrMasFinancialYear> list = criteria.list();
		return list;
	}

	public Object loadObject(Class klass, Integer id) {
		Object object = getSession().load(klass, id);
		return object;

	}

	public void saveObject(Object object) {
		getHibernateTemplate().saveOrUpdate(object);
		getHibernateTemplate().flush();
		getHibernateTemplate().refresh(object);
	}

	public void removeItaxDetails(Map parameterMap) {
		Integer iTaxHeaderId = (Integer) parameterMap.get("iTaxHeaderId");
		// HrMasFinancialYear finYr =
		// (HrMasFinancialYear)parameterMap.get("finYr");
		// Integer month = (Integer)parameterMap.get("month");

		Criteria criteria = getSession().createCriteria(HrItaxDetails.class);
		criteria = criteria.add(Restrictions.eq("ItaxHeader.Id", iTaxHeaderId));
		List<HrItaxDetails> itaxDetailsList = criteria.list();

		getHibernateTemplate().deleteAll(itaxDetailsList);
	}

	public Boolean checkDuplicateITaxHeader(HrItaxHeader itaxHeader) {
		Criteria criteria = getSession().createCriteria(HrItaxHeader.class);
		criteria = criteria
				.add(Restrictions.eq("FYear", itaxHeader.getFYear()));
		criteria = criteria.add(Restrictions.eq("Employee.Id", itaxHeader
				.getEmployee().getId()));
		criteria = criteria.add(Restrictions.eq("FMonth", itaxHeader
				.getFMonth()));
		List list = criteria.list();
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public List getITaxHeaderList(Map parameterMap) {
		Integer empId = 0;
		Integer finYrId = 0;
		empId = (Integer) parameterMap.get("empId");
		finYrId = (Integer) parameterMap.get("finYrId");
		List itaxHeaderList = new ArrayList();
		Criteria criteria = getSession().createCriteria(HrItaxHeader.class);
		criteria = criteria.add(Restrictions.eq("Employee.Id", empId));
		criteria = criteria.add(Restrictions.eq("FYear.Id", finYrId));
		itaxHeaderList = criteria.list();
		return itaxHeaderList;

	}

	public List getPayElementsAmountSumList(List listHeader) {

		String items = "(";
		Session session = (Session) getSession();
		int cnt = listHeader.size();
		List<HrItaxHeader> hrItaxHeaderList = listHeader;
		/*
		 * if(cnt>0){
		 * hrItaxHeaderList=session.createCriteria(HrItaxHeader.class)
		 * .add(Restrictions.in("FMonth", listHeader)).list(); }
		 */
		int inc = 0;
		for (HrItaxHeader list : hrItaxHeaderList) {
			inc++;
			if (hrItaxHeaderList.size() != inc)
				items = items + list.getId() + ",";
			else {
				items = items + list.getId();
			}
		}
		items = items + ")";
		List list = getHibernateTemplate()
				.find(
						"select sum(Amount) as amount,PayElement as payElement,ElementType as elemntType,Section as section from HrItaxDetails as itxd where ItaxHeader.Id in "
								+ items
								+ " group by PayElement order by PayElement");
		/*
		 * Criteria criteria = getSession().createCriteria(HrItaxDetails.class);
		 * criteria = criteria.add() criteria =
		 * criteria.add(Restrictions.in("ItaxHeader", listHeader));
		 */

		return list;
	}

	public HrEmployeePayStructure getEmployeePayStructure(Integer empId) {
		Criteria criteria = getSession().createCriteria(
				HrEmployeePayStructure.class);
		criteria = criteria.add(Restrictions.eq("Employee.Id", empId));
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		List list = criteria.list();
		HrEmployeePayStructure payStructure = null;
		if (list.size() > 0)
			payStructure = (HrEmployeePayStructure) list.get(0);
		return payStructure;
	}

	public List<HrEmployeePayElements> getEmployeePayElements(Integer empId) {
		Criteria criteria = getSession().createCriteria(
				HrEmployeePayElements.class);
		criteria = criteria.add(Restrictions.eq("Employee.Id", empId));
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		List list = criteria.list();

		return list;
	}
	public List<HrMasItaxSlab> getSlabList(Map map)
	{
		HrMasFinancialYear finYear = (HrMasFinancialYear)map.get("finyear");
		String citizen = (String)map.get("citizen");
		Criteria criteria = getSession().createCriteria(HrMasItaxSlab.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		criteria = criteria.add(Restrictions.eq("FinancialYear.Id", finYear.getId()));
		criteria = criteria.add(Restrictions.eq("Citizen", citizen));
		criteria = criteria.addOrder(Order.asc("LowerLimit"));
		return criteria.list();
	}

	public List<HrMasItaxSurcharge> getSurcharge(HrMasFinancialYear finYear)
	{
		Criteria criteria = getSession().createCriteria(HrMasItaxSurcharge.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		criteria = criteria.add(Restrictions.eq("FinancialYear",finYear));
		List<HrMasItaxSurcharge> surchargeList =   (List)criteria.list();
		//HrMasItaxSurcharge surcharge = (HrMasItaxSurcharge)surchargeList.get(0);
		return surchargeList;
	}

	public Connection getDBConnection() {
		Session session = (Session) getSession(true);
		Connection connection = null;
		Map<String, Object> map = new HashMap<String, Object>();

		try{
			connection  = session.connection();
			//session.close();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}


		return connection;
	}
	public Map saveEmployeeInvestment(Map generalMap) {
		boolean successfullyAdded = false;

		List<HrEmployeeInvestment> obj = (List<HrEmployeeInvestment>)generalMap.get("empInvList");
		Integer empid = (Integer)generalMap.get("empid");
		Integer invYear = (Integer) generalMap.get("invYear");
		Integer invSec = (Integer) generalMap.get("invSec");

		Criteria criteria = getSession().createCriteria(HrEmployeeInvestment.class);
		criteria = criteria.add(Restrictions.eq("InvYear.Id", invYear));
		criteria = criteria.add(Restrictions.eq("Emp.Id", empid));
	//	criteria = criteria.add(Restrictions.eq("SecInvest.Id", invSec));
		List<HrEmployeeInvestment> duplicateList = (List<HrEmployeeInvestment>)criteria.list();

		if(duplicateList.size() == 0){
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdateAll(obj);
			//hbt.flush();
			//hbt.refresh(obj);

			successfullyAdded =true;



		}
		else if(duplicateList.size() > 0){
			getHibernateTemplate().deleteAll(duplicateList);
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdateAll(obj);

			//List<HrEmployeeInvestment> obj1 = duplicateList.get(0);
		}
		Map map = showEmployeeInvestmentJsp();
		generalMap.putAll(map);
		return generalMap;
	}

	public Map checkEmployeeInvestment(Map generalMap){
		Map map = new HashMap();
		Integer empid = (Integer)generalMap.get("empid");
		Integer invYear = (Integer) generalMap.get("invYear");
		Session session = (Session)getSession();
		Criteria crit = getSession().createCriteria(HrMasFinancialYear.class);
		crit = crit.add(Restrictions.eq("Status", "y"));
		crit = crit.addOrder(Order.desc("YearDescription"));
		Criteria criteria = getSession().createCriteria(HrEmployeeInvestment.class);
		criteria = criteria.add(Restrictions.eq("InvYear.Id", invYear));
		criteria = criteria.add(Restrictions.eq("Emp.Id", empid));
		List<HrMasFinancialYear> hrMasFinancialYearList = crit.list();
		HrMasFinancialYear finYear = (HrMasFinancialYear)session.createCriteria(HrMasFinancialYear.class).add(Restrictions.eq("Id", invYear)).uniqueResult();
		MasEmployee emp =(MasEmployee) session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empid)).uniqueResult();
		List<HrMasItaxSecInvestment> hrMasItaxSecInvestmentList = new ArrayList<HrMasItaxSecInvestment>();
		List<MasEmployee> masEmployeeList  = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		hrMasItaxSecInvestmentList = session.createCriteria(HrMasItaxSecInvestment.class).add(Restrictions.eq("Status", "y")).list();
		if(masEmployeeList != null)
		{
			map.put("masEmployeeList",masEmployeeList);
		}
		if(hrMasItaxSecInvestmentList != null)
		{
			map.put("hrMasItaxSecInvestmentList",hrMasItaxSecInvestmentList);
		}
		if(hrMasFinancialYearList != null)
		{
			map.put("hrMasFinancialYearList",hrMasFinancialYearList);
		}
		List<HrEmployeeInvestment> existingList = (List<HrEmployeeInvestment>)criteria.list();
		map.put("existingList", existingList);
		map.put("finYear",finYear);
		map.put("emp",emp);
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		map.put("con",con);
		return map;
	}

	public boolean deleteFinancialYearMaster(int financialYrId, Map generalMap) {
		boolean dataDeleted=false;
		  int userId = 0;
		  Date currentDate = new Date();
		  String currentTime = "";
		  currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		try{
		HrMasFinancialYear hrMasFinancialYear =new HrMasFinancialYear();
		hrMasFinancialYear=(HrMasFinancialYear)getHibernateTemplate().load(HrMasFinancialYear.class,financialYrId);
		userId= (Integer) generalMap.get("userId");
	    currentDate=(Date)generalMap.get("currentDate");
	    currentTime=(String)generalMap.get("currentTime");
		if (hrMasFinancialYear.getStatus().equals("y")){
			hrMasFinancialYear.setStatus("n");
			dataDeleted=true;
		}else{
			hrMasFinancialYear.setStatus("y");
			dataDeleted=false;
		}
		Users users = new Users();
		users.setId(userId);
		hrMasFinancialYear.setLastChgBy(users);
		hrMasFinancialYear.setLastChgDate(currentDate);
		hrMasFinancialYear.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrMasFinancialYear);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataDeleted;
	}

	public Map computeIncomeTax(Map parameterMap)
	{

		List<MasEmployee> employeeList = (List)parameterMap.get("empListForITComputation");

		for(MasEmployee employee : employeeList)
		{
			computeIncomeTax(employee,parameterMap);
		}

		return null;
	}

	public Map computeIncomeTax(MasEmployee employee,Map parameterMap)
	{
		Integer year = (Integer)parameterMap.get("year");
		Integer month = (Integer)parameterMap.get("month");
		month = month - 1;
		Calendar c = Calendar.getInstance();
		c.set(year, month, 1);
		Date payRollDate = c.getTime();
		HrMasFinancialYear payRollFinancialYear = null;

		List<HrMasFinancialYear> listFinList = getFinancialYearList();

		for(HrMasFinancialYear finYr : listFinList)
		{
		 if(payRollDate.after(finYr.getYearFromDate()) && payRollDate.before(finYr.getYearToDate()))
			{


			 payRollFinancialYear = finYr;
			}
		}
		//---------------------Get employee payroll process header
		/*Criteria criteria = getSession().createCriteria(HrPayrollProcessHeader.class);
		criteria = criteria.add(Restrictions.eq("Employee.Id", employee.getId()));
		criteria = criteria.add(Restrictions.eq("Year", year));
		criteria = criteria.add(Restrictions.eq("Month", month-1));
		//criteria = criteria.add(Restrictions.eq("Status", "y"));
		List<HrPayrollProcessHeader> listPayrollProcessHeader = criteria.list();
		HrPayrollProcessHeader employeePayrollProcessHeader = listPayrollProcessHeader.get(0);*/

		//------------------------------
		Criteria criteria1 = getSession().createCriteria(HrArrear.class);
		criteria1 = criteria1.add(Restrictions.eq("Employee.Id", employee.getId()));
		criteria1 = criteria1.add(Restrictions.eq("Status", "y"));
		criteria1 = criteria1.add(Restrictions.eq("ArrearStatus", "unpaid"));
		List<HrArrear> listArrearHeader = criteria1.list();
		List<HrArrear> listArrear = new ArrayList<HrArrear>();
		HrArrear employeeArrear = null;
		for(HrArrear arrear : listArrearHeader)
		{
			if(arrear.getPaidDate().after(payRollFinancialYear.getYearFromDate()) &&  arrear.getPaidDate().before(payRollFinancialYear.getYearToDate())){
				if(arrear.getPaidDate().getMonth() == month)
				{
				listArrear.add(arrear);
				}
			}
		}
		//-----------------------------

		/*//---------------------Get employee loan header
		Criteria criteria2 = getSession().createCriteria(HrLoanHeader.class);
		criteria2 = criteria2.add(Restrictions.eq("Employee.Id", employee.getId()));
		criteria2 = criteria2.add(Restrictions.eq("Status", "y"));
		List<HrLoanHeader> listLoanHeader = criteria2.list();
		HrLoanHeader employeeLoanHeader = null;
		for(HrLoanHeader loanHeader:listLoanHeader)
		{
			if(loanHeader.getLoanDate().getMonth() == month)
			{
				employeeLoanHeader = loanHeader;
			}
		}*/

		//------------------------------

		//---------------------Get employee bonus details
		Criteria criteria3 = getSession().createCriteria(HrBonusDetail.class);
		criteria3 = criteria3.add(Restrictions.eq("Employee.Id", employee.getId()));
		criteria3 = criteria3.add(Restrictions.eq("Status", "y"));
		List<HrBonusDetail> listBonusDetail = criteria3.list();
		List<HrBonusDetail> bonusDetailsList = new ArrayList();
		for(HrBonusDetail bonusDetail:listBonusDetail)
		{
			if(bonusDetail.getPaidDate().after(payRollFinancialYear.getYearFromDate()) && bonusDetail.getPaidDate().before(payRollFinancialYear.getYearToDate())){

				if(bonusDetail.getPaidDate().getMonth() == month)
				{
					bonusDetailsList.add(bonusDetail);
				}

			}
		}
		//------------------------------

		//---------------------Get employee Investments details
		Criteria criteria4 = getSession().createCriteria(HrEmployeeInvestment.class);
		criteria4 = criteria4.add(Restrictions.eq("Emp.Id", employee.getId()));
		//criteria4 = criteria4.add(Restrictions.eq("Status", "y"));
		///criteria4 = criteria4.add(Restrictions.eq("Status", "y"));
		List<HrEmployeeInvestment> listEmployeeInvestments = criteria4.list();
		List<HrEmployeeInvestment> employeeInvestmentList = new ArrayList();
		for(HrEmployeeInvestment employeeInvestment:listEmployeeInvestments)
		{
			if(employeeInvestment.getInvDate().after(payRollFinancialYear.getYearFromDate()) && employeeInvestment.getInvDate().before(payRollFinancialYear.getYearToDate()))
			{
				employeeInvestmentList.add(employeeInvestment);
			}
		}

		//------------------------------

		//Get employee other earnings
		Criteria criteria5 = getSession().createCriteria(HrEmployeeOtherEarning.class);
		criteria5 = criteria5.add(Restrictions.eq("Emp.Id", employee.getId()));
		//criteria4 = criteria4.add(Restrictions.eq("Status", "y"));
		///criteria4 = criteria4.add(Restrictions.eq("Status", "y"));
		List<HrEmployeeOtherEarning> listEmployeeOtherEarnings = criteria5.list();
		List<HrEmployeeOtherEarning> employeeOtherEarningsList = new ArrayList();
		for(HrEmployeeOtherEarning employeeOtherEarning:listEmployeeOtherEarnings)
		{
			if(employeeOtherEarning.getFinancialYear().getId().equals(payRollFinancialYear.getId()))
			{
				employeeOtherEarningsList.add(employeeOtherEarning);
			}
		}

		Map map = new HashMap();

		map.put("listArrear", listArrear);
		//map.put("employeeLoanHeader", employeeLoanHeader);
		map.put("bonusDetailsList", bonusDetailsList);
		map.put("employeeInvestmentList", employeeInvestmentList);
		map.put("employeeOtherEarningsList", employeeOtherEarningsList);
		return map;
	}

	 public Map checkForExistingIncomeTaxExempt(Map generalMap) {
		Map<String,Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();

		int id = 0;

		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String pojoPropertyName = "";



		if(generalMap.get("id") != null){
			id = (Integer)generalMap.get("id");
		}
		String name = (String)generalMap.get("name");
		String pojoName = (String)generalMap.get("pojoName");
		if(generalMap.get("pojoPropertyName") != null)
			pojoPropertyName = (String)generalMap.get("pojoPropertyName");

		if(generalMap.get("pojoPropertyCode") != null){
			pojoPropertyCode = (String)generalMap.get("pojoPropertyCode");
		}
		if(generalMap.get("pojoPropertyAddress") != null){
			pojoPropertyAddress = (String)generalMap.get("pojoPropertyAddress");
		}
		if(generalMap.get("flag") == null){
			String code = (String)generalMap.get("code");
			String address = (String)generalMap.get("address");

			if(!pojoPropertyCode.equals("")){
				duplicateGeneralCodeList = getHibernateTemplate().find("from jkt.hrms.masters.business."+pojoName+" as g where g."+pojoPropertyCode+" ='"+code+"'");
			}
			if(!pojoPropertyName.equals("")){
				duplicateGeneralNameList = getHibernateTemplate().find("from jkt.hrms.masters.business."+pojoName+" as g where g."+pojoPropertyName+" = '"+name+"'");
			}
			if(!pojoPropertyAddress.equals("")){
				duplicateGeneralAddressList = getHibernateTemplate().find("from jkt.hrms.masters.business."+pojoName+" as g where g."+pojoPropertyAddress+" ='"+address+"'");
			}

		}
		else if(generalMap.get("flag") != null){
			boolean flag = (Boolean)generalMap.get("flag");
			duplicateMastersList = getHibernateTemplate().find("from jkt.hrms.masters.business."+pojoName+" as g where g."+pojoPropertyName+" = '"+name+"' and g.Id != "+id);
		}
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}

	// End by Ramdular -----------------------------------------------2011/04/16
}
