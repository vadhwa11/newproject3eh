package jkt.hrms.payroll.dataservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hrms.masters.business.HrMasBonus;
import jkt.hrms.masters.business.HrMasLoan;
import jkt.hrms.masters.business.HrMasPayElement;
import jkt.hrms.masters.business.HrMasPayroll;
import jkt.hrms.masters.business.HrMasReimbersement;

import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PayrollMastersDataServiceImpl extends HibernateDaoSupport
		implements PayrollMastersDataService {

	public Map<String, Object> showBonusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		bonusList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasBonus as bonus  ");
		gradeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasGrade");
		map.put("bonusList", bonusList);
		map.put("gradeList", gradeList);
		return map;
	}

	public Map<String, Object> saveBonus(HrMasBonus hrMasBonus) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<HrMasBonus> existingBonusList = new ArrayList<HrMasBonus>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String bonusCode = hrMasBonus.getBonusCode();
		String bonusDescription = hrMasBonus.getDescription();
		existingBonusList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasBonus as bonus where bonus.BonusCode = '"
						+ bonusCode + "' and bonus.Description = '"
						+ bonusDescription + "'");
		if (existingBonusList.size() > 0) {
			message = "Record already Exist";
		} else {
			hbt.save(hrMasBonus);
			message = "Record saved sucessfully!";

		}
		bonusList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasBonus");
		gradeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasGrade");
		map.put("gradeList", gradeList);
		map.put("message", message);
		map.put("bonusList", bonusList);
		return map;
	}

	public Map<String, Object> editBonus(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		List<HrMasBonus> existingBonusList = new ArrayList<HrMasBonus>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		Session session = (Session) getSession();
		int bonusId = 0;
		if (generalMap.get("bonusId") != null) {
			bonusId = (Integer) generalMap.get("bonusId");
		}
		String bonusCode = "";
		if (generalMap.get("bonusCode") != null) {
			bonusCode = (String) generalMap.get("bonusCode");
		}
		String bonusDescription = "";
		if (generalMap.get("bonusDescription") != null) {
			bonusDescription = (String) generalMap.get("bonusDescription");
		}
		Date fromDate = new Date();
		if (generalMap.get("fromDate") != null) {
			fromDate = (Date) generalMap.get("fromDate");
		}
		Date toDate = new Date();
		if (generalMap.get("toDate") != null) {
			toDate = (Date) generalMap.get("toDate");
		}
		Date dueDate = new Date();
		if (generalMap.get("dueDate") != null) {
			dueDate = (Date) generalMap.get("dueDate");
		}
		String bonusType = "";
		if (generalMap.get("bonusType") != null) {
			bonusType = (String) generalMap.get("bonusType");
		}
		String paymentFrequency = "";
		if (generalMap.get("paymentFrequency") != null) {
			paymentFrequency = (String) generalMap.get("paymentFrequency");
		}

		Float bonusRate = null;
		if (generalMap.get("bonusRate") != null) {
			bonusRate = (Float) generalMap.get("bonusRate");
		}
		BigDecimal fixedAmount = null;
		if (generalMap.get("fixedAmount") != null) {
			fixedAmount = (BigDecimal) generalMap.get("fixedAmount");
		}
		BigDecimal maxBasic = null;
		if (generalMap.get("maxBasic") != null) {
			maxBasic = (BigDecimal) generalMap.get("maxBasic");
		}
		int gradeId = 0;
		if (generalMap.get("gradeId") != null) {
			gradeId = (Integer) generalMap.get("gradeId");
		}
		String taxable = "";
		if (generalMap.get("taxable") != null) {
			taxable = (String) generalMap.get("taxable");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = null;
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasBonus hrMasBonus = (HrMasBonus) hbt
				.load(HrMasBonus.class, bonusId);
		hrMasBonus.setBonusCode(bonusCode);
		hrMasBonus.setDescription(bonusDescription);
		hrMasBonus.setFromDate(fromDate);
		hrMasBonus.setToDate(toDate);
		hrMasBonus.setDueDate(dueDate);
		hrMasBonus.setPaymentFrequency(paymentFrequency);
		hrMasBonus.setBonusType(bonusType);
		hrMasBonus.setBonusRate(bonusRate);
		hrMasBonus.setFixedAmount(fixedAmount);
		hrMasBonus.setMaxBasic(maxBasic);

		MasGrade masGrade = new MasGrade();
		masGrade.setId(gradeId);
		hrMasBonus.setGrade(masGrade);
		hrMasBonus.setTaxable(taxable);
		hrMasBonus.setLastChgBy(changedBy);
		hrMasBonus.setLastChgDate(currentDate);
		hrMasBonus.setLastChgTime(currentTime);
		// existingBonusList =
		// session.createCriteria(HrMasBonus.class).add(Restrictions.eq("BonusCode",
		// bonusCode)) .add(Restrictions.eq("Description",
		// bonusDescription)).add(Restrictions.).list();
		existingBonusList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasBonus as bonus where bonus.BonusCode = '"
						+ bonusCode + "' and bonus.Description = '"
						+ bonusDescription + "' and bonus.Id != '" + bonusId
						+ "' ");
		String message = "";
		if (existingBonusList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.update(hrMasBonus);
			message = "Record update successfully";
		}
		bonusList = session.createCriteria(HrMasBonus.class).list();
		gradeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasGrade");
		map.put("gradeList", gradeList);
		map.put("bonusList", bonusList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> deleteBonus(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int bonusId = 0;
		if (generalMap.get("bonusId") != null) {
			bonusId = (Integer) generalMap.get("bonusId");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasBonus hrMasBonus = (HrMasBonus) hbt
				.load(HrMasBonus.class, bonusId);
		hrMasBonus.setLastChgBy(changedBy);
		hrMasBonus.setLastChgDate(currentDate);
		hrMasBonus.setLastChgTime(currentTime);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrMasBonus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrMasBonus.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(hrMasBonus);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		bonusList = session.createCriteria(HrMasBonus.class).list();
		map.put("bonusList", bonusList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> searchBonus(String bonusCode,
			String bonusDescription) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
		try {
			if ((bonusCode == null) || (bonusDescription != null)) {

				bonusList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasBonus mb where mb.Description like '"
								+ bonusDescription
								+ "%' order by mb.Description");
			} else {
				bonusList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasBonus mb where mb.BonusCode like '"
								+ bonusCode + "%' order by mb.BonusCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("bonusList", bonusList);
		map.put("bonusCode", bonusCode);
		map.put("bonusDescription", bonusDescription);
		return map;
	}

	public Map<String, Object> showLoanJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		Session session = (Session) getSession();
		loanList = session.createCriteria(HrMasLoan.class).list();
		map.put("loanList", loanList);
		return map;
	}

	public Map<String, Object> saveLoan(HrMasLoan hrMasLoan) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<HrMasLoan> existingLoanList = new ArrayList<HrMasLoan>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String loanCode = hrMasLoan.getLoanCode();
		String loanDescription = hrMasLoan.getLoanDescription();
		existingLoanList = session.createCriteria(HrMasLoan.class)
				.add(Restrictions.eq("LoanCode", loanCode))
				.add(Restrictions.eq("LoanDescription", loanDescription))
				.list();
		if (existingLoanList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.save(hrMasLoan);
			message = "Record save successfully";
		}
		loanList = session.createCriteria(HrMasLoan.class).list();
		map.put("loanList", loanList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> editLoan(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		List<HrMasLoan> existingloanList = new ArrayList<HrMasLoan>();
		Session session = (Session) getSession();
		int loanId = 0;
		if (generalMap.get("loanId") != null) {
			loanId = (Integer) generalMap.get("loanId");
		}
		String loanCode = "";
		if (generalMap.get("loanCode") != null) {
			loanCode = (String) generalMap.get("loanCode");
		}
		String loanDescription = "";
		if (generalMap.get("loanDescription") != null) {
			loanDescription = (String) generalMap.get("loanDescription");
		}

		BigDecimal maxAmount = null;
		if (generalMap.get("maxAmount") != null) {
			maxAmount = (BigDecimal) generalMap.get("maxAmount");
		}
		Float interestPercent = null;
		if (generalMap.get("interestPercent") != null) {
			interestPercent = (Float) generalMap.get("interestPercent");
		}

		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = null;
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasLoan hrMasLoan = (HrMasLoan) hbt.load(HrMasLoan.class, loanId);
		hrMasLoan.setLoanCode(loanCode);
		hrMasLoan.setLoanDescription(loanDescription);
		hrMasLoan.setMaxAmount(maxAmount);
		hrMasLoan.setInterestPercent(interestPercent);
		hrMasLoan.setLastChgBy(changedBy);
		hrMasLoan.setLastChgTime(currentTime);
		hrMasLoan.setLastChgDate(currentDate);

		// existingloanList =
		// session.createCriteria(HrMasLoan.class).add(Restrictions.eq("LoanCode",
		// loanCode)) .add(Restrictions.eq("LoanDescription",
		// loanDescription)).list();
		existingloanList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasLoan as loan where loan.LoanCode = '"
						+ loanCode + "' and loan.LoanDescription = '"
						+ loanDescription + "' and loan.Id != '" + loanId
						+ "' ");
		String message = "";
		if (existingloanList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.update(hrMasLoan);
			hbt.refresh(hrMasLoan);
			message = "Record update successfully";
		}
		loanList = session.createCriteria(HrMasLoan.class).list();
		map.put("message", message);
		map.put("loanList", loanList);
		return map;
	}

	public Map<String, Object> deleteLoan(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int loanId = 0;
		if (generalMap.get("loanId") != null) {
			loanId = (Integer) generalMap.get("loanId");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasLoan hrMasLoan = (HrMasLoan) hbt.load(HrMasLoan.class, loanId);
		hrMasLoan.setLastChgBy(changedBy);
		hrMasLoan.setLastChgDate(currentDate);
		hrMasLoan.setLastChgTime(currentTime);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrMasLoan.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrMasLoan.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(hrMasLoan);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		loanList = session.createCriteria(HrMasLoan.class).list();
		map.put("loanList", loanList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> searchLoan(String loanCode,
			String loanDescription) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLoan> loanList = new ArrayList<HrMasLoan>();
		Session session = (Session) getSession();
		try {
			if ((loanCode == null) || (loanDescription != null)) {

				loanList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasLoan ml where ml.LoanDescription like '"
								+ loanDescription
								+ "%' order by ml.LoanDescription");
			} else {
				loanList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasLoan ml where ml.LoanCode like '"
								+ loanCode + "%' order by ml.LoanCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("loanList", loanList);
		map.put("loanCode", loanCode);
		map.put("loanDescription", loanDescription);
		return map;
	}

	public Map<String, Object> showPayrollJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session) getSession();
		payrollList = session.createCriteria(HrMasPayroll.class).list();
		map.put("payrollList", payrollList);
		return map;
	}

	public Map<String, Object> savePayroll(HrMasPayroll hrMasPayroll) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		List<HrMasPayroll> existingpayrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session) getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String payrollCode = hrMasPayroll.getPayrollCode();
		String payrollDescription = hrMasPayroll.getPayrollDescription();
		existingpayrollList = session.createCriteria(HrMasPayroll.class)
				.add(Restrictions.eq("PayrollCode", payrollCode))
				.add(Restrictions.eq("PayrollDescription", payrollDescription))
				.list();
		if (existingpayrollList.size() > 0) {
			message = "Record already Exist";
		} else {
			hbt.save(hrMasPayroll);
			message = "Record saved sucessfully!";

		}
		payrollList = session.createCriteria(HrMasPayroll.class).list();
		map.put("message", message);
		map.put("payrollList", payrollList);
		return map;
	}

	public Map<String, Object> editPayroll(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		List<HrMasPayroll> existingPayrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session) getSession();
		int payrollId = 0;
		if (generalMap.get("payrollId") != null) {
			payrollId = (Integer) generalMap.get("payrollId");
		}
		String payrollCode = "";
		if (generalMap.get("payrollCode") != null) {
			payrollCode = (String) generalMap.get("payrollCode");
		}
		String payrollDescription = "";
		if (generalMap.get("payrollDescription") != null) {
			payrollDescription = (String) generalMap.get("payrollDescription");
		}
		Date fromDate = new Date();
		if (generalMap.get("fromDate") != null) {
			fromDate = (Date) generalMap.get("fromDate");
		}

		Date toDate = new Date();
		if (generalMap.get("toDate") != null) {
			toDate = (Date) generalMap.get("toDate");
		}
		String frequency = "";
		if (generalMap.get("frequency") != null) {
			frequency = (String) generalMap.get("frequency");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = null;
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasPayroll hrMasPayroll = (HrMasPayroll) hbt.load(HrMasPayroll.class,
				payrollId);
		hrMasPayroll.setPayrollCode(payrollCode);
		hrMasPayroll.setPayrollDescription(payrollDescription);
		hrMasPayroll.setFromDate(fromDate);
		hrMasPayroll.setToDate(toDate);
		hrMasPayroll.setFrequency(frequency);
		hrMasPayroll.setLastChgBy(changedBy);
		hrMasPayroll.setLastChgDate(currentDate);
		hrMasPayroll.setLastChgTime(currentTime);
		// existingPayrollList =
		// session.createCriteria(HrMasPayroll.class).add(Restrictions.eq("PayrollCode",
		// payrollCode)) .add(Restrictions.eq("PayrollDescription",
		// payrollDescription)).list();
		existingPayrollList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasPayroll as payroll where payroll.PayrollCode = '"
						+ payrollCode
						+ "' and payroll.PayrollDescription = '"
						+ payrollDescription
						+ "' and payroll.Id != '"
						+ payrollId + "' ");
		String message = "";
		if (existingPayrollList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.update(hrMasPayroll);
			// hbt.refresh(hrMasPayroll);
			message = "Record update successfully";
		}
		payrollList = session.createCriteria(HrMasPayroll.class).list();
		map.put("message", message);
		map.put("payrollList", payrollList);
		return map;
	}

	public Map<String, Object> deletePayroll(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int payrollId = 0;
		if (generalMap.get("payrollId") != null) {
			payrollId = (Integer) generalMap.get("payrollId");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasPayroll hrMasPayroll = (HrMasPayroll) hbt.load(HrMasPayroll.class,
				payrollId);
		hrMasPayroll.setLastChgBy(changedBy);
		hrMasPayroll.setLastChgDate(currentDate);
		hrMasPayroll.setLastChgTime(currentTime);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrMasPayroll.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrMasPayroll.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(hrMasPayroll);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		payrollList = session.createCriteria(HrMasPayroll.class).list();
		map.put("payrollList", payrollList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> searchPayroll(String payrollCode,
			String payrollDescription) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayroll> payrollList = new ArrayList<HrMasPayroll>();
		Session session = (Session) getSession();
		try {
			if ((payrollCode == null) || (payrollDescription != null)) {

				payrollList = session
						.createCriteria(HrMasPayroll.class)
						.add(Restrictions.like("PayrollDescription",
								payrollDescription + "%"))
						.addOrder(Property.forName("PayrollDescription").asc())
						.list();
			} else {
				payrollList = session
						.createCriteria(HrMasPayroll.class)
						.add(Restrictions
								.like("PayrollCode", payrollCode + "%"))
						.addOrder(Property.forName("PayrollCode").asc()).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("payrollList", payrollList);
		map.put("payrollCode", payrollCode);
		map.put("payrollDescription", payrollDescription);
		return map;
	}

	public Map<String, Object> showPayElementJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		Session session = (Session) getSession();
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		map.put("payElementList", payElementList);
		return map;
	}

	public Map<String, Object> savePayElement(HrMasPayElement hrMasPayElement) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		List<HrMasPayElement> existingPayElementList = new ArrayList<HrMasPayElement>();
		List<HrMasPayElement> existingPayElementList1 = new ArrayList<HrMasPayElement>();
		Session session = (Session) getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String payElementCode = hrMasPayElement.getPayElementCode();
		String payElementDescription = hrMasPayElement.getPayElementDesc();

		existingPayElementList = session.createCriteria(HrMasPayElement.class)
				.add(Restrictions.eq("PayElementCode", payElementCode)).list();
		existingPayElementList1 = session.createCriteria(HrMasPayElement.class)
				.add(Restrictions.eq("PayElementDesc", payElementDescription))
				.list();

		if (existingPayElementList.size() > 0) {
			message = "PayElement Code already Exist";
		} else if (existingPayElementList1.size() > 0) {

			message = "PayElement Name already Exist";
		} else if (existingPayElementList1.size() > 0
				&& existingPayElementList.size() > 0) {

			message = "PayElement Code & Description already Exist";

		} else {
			hbt.save(hrMasPayElement);
			message = "Record saved sucessfully!";

		}
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		map.put("message", message);
		map.put("payElementList", payElementList);
		return map;
	}

	public Map<String, Object> editPayElement(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		List<HrMasPayElement> existingPayElementList = new ArrayList<HrMasPayElement>();
		Session session = (Session) getSession();
		int payElementId = 0;
		if (generalMap.get("payElementId") != null) {
			payElementId = (Integer) generalMap.get("payElementId");
		}
		String payElementCode = "";
		if (generalMap.get("payElementCode") != null) {
			payElementCode = (String) generalMap.get("payElementCode");
		}
		String payElementDescription = "";
		if (generalMap.get("payElementDescription") != null) {
			payElementDescription = (String) generalMap
					.get("payElementDescription");
		}
		Date effectiveDate = new Date();
		if (generalMap.get("effectiveDate") != null) {
			effectiveDate = (Date) generalMap.get("effectiveDate");
		}
		String payElementType = "";
		if (generalMap.get("payElementType") != null) {
			payElementType = (String) generalMap.get("payElementType");
		}
		String taxableElement = "";
		if (generalMap.get("taxableElement") != null) {
			taxableElement = (String) generalMap.get("taxableElement");
		}
		String otCalculation = "";
		if (generalMap.get("otCalculation") != null) {
			otCalculation = (String) generalMap.get("otCalculation");
		}
		Float basicMultiplier = 0.0f;
		if (generalMap.get("basicMultiplier") != null) {
			basicMultiplier = (Float) generalMap.get("basicMultiplier");
		}
		String arrearElement = "";
		if (generalMap.get("arrearElement") != null) {
			arrearElement = (String) generalMap.get("arrearElement");
		}
		String reimbElement = "";
		if (generalMap.get("reimbElement") != null) {
			reimbElement = (String) generalMap.get("reimbElement");
		}

		String basicDependent = "";
		if (generalMap.get("basicDependent") != null) {
			basicDependent = (String) generalMap.get("basicDependent");
		}
		String pfDependent = "";
		if (generalMap.get("pfDependent") != null) {
			pfDependent = (String) generalMap.get("pfDependent");
		}

		BigDecimal maxAmount = null;
		if (generalMap.get("maxAmount") != null) {
			maxAmount = (BigDecimal) generalMap.get("maxAmount");
		}

		String ctcHeading = "";
		if (generalMap.get("ctcHeading") != null) {
			ctcHeading = (String) generalMap.get("ctcHeading");
		}

		String payElementStatus = "";
		if (generalMap.get("payElementStatus") != null) {
			payElementStatus = (String) generalMap.get("payElementStatus");
		}
		Date statusDate = new Date();
		if (generalMap.get("statusDate") != null) {
			statusDate = (Date) generalMap.get("statusDate");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = null;
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasPayElement hrMasPayElement = (HrMasPayElement) hbt.load(
				HrMasPayElement.class, payElementId);
		hrMasPayElement.setPayElementCode(payElementCode);
		hrMasPayElement.setPayElementDesc(payElementDescription);
		hrMasPayElement.setEffectiveDate(effectiveDate);
		hrMasPayElement.setPayElementType(payElementType);
		hrMasPayElement.setTaxableElement(taxableElement);
		hrMasPayElement.setOtCalculation(otCalculation);
		hrMasPayElement.setBasicMultiplier(basicMultiplier);
		hrMasPayElement.setArrearElement(arrearElement);
		hrMasPayElement.setReimbElement(reimbElement);
		hrMasPayElement.setBasicDependent(basicDependent);
		hrMasPayElement.setPfDependent(pfDependent);
		hrMasPayElement.setStatusDate(statusDate);
		hrMasPayElement.setMaxAmount(maxAmount);
		hrMasPayElement.setCTCHeading(ctcHeading);
		hrMasPayElement.setPayElementStatus(payElementStatus);
		hrMasPayElement.setLastChgBy(changedBy);
		hrMasPayElement.setLastChgDate(currentDate);
		hrMasPayElement.setLastChgTime(currentTime);
		// existingPayElementList =
		// session.createCriteria(HrMasPayElement.class).add(Restrictions.eq("PayElementCode",
		// payElementCode)) .add(Restrictions.eq("PayElementDesc",
		// payElementDescription)).list();
		existingPayElementList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasPayElement as pe where pe.PayElementCode = '"
						+ payElementCode
						+ "' and pe.PayElementDesc = '"
						+ payElementDescription
						+ "' and pe.Id != '"
						+ payElementId + "' ");
		String message = "";
		if (existingPayElementList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.update(hrMasPayElement);
			// hbt.refresh(hrMasPayroll);
			message = "Record update successfully";
		}
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		map.put("message", message);
		map.put("payElementList", payElementList);
		return map;
	}

	public Map<String, Object> deletePayElement(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int payElementId = 0;
		if (generalMap.get("payElementId") != null) {
			payElementId = (Integer) generalMap.get("payElementId");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasPayElement hrMasPayElement = (HrMasPayElement) hbt.load(
				HrMasPayElement.class, payElementId);
		hrMasPayElement.setLastChgBy(changedBy);
		hrMasPayElement.setLastChgDate(currentDate);
		hrMasPayElement.setLastChgTime(currentTime);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrMasPayElement.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrMasPayElement.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(hrMasPayElement);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		payElementList = session.createCriteria(HrMasPayElement.class).list();
		map.put("payElementList", payElementList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> searchPayElement(String payElementCode,
			String payElementDescription) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasPayElement> payElementList = new ArrayList<HrMasPayElement>();
		Session session = (Session) getSession();
		try {
			if ((payElementCode == null) || (payElementDescription != null)) {

				payElementList = session
						.createCriteria(HrMasPayElement.class)
						.add(Restrictions.like("PayElementDesc",
								payElementDescription + "%"))
						.addOrder(Property.forName("PayElementDesc").asc())
						.list();
			} else {
				payElementList = session
						.createCriteria(HrMasPayElement.class)
						.add(Restrictions.like("PayElementCode", payElementCode
								+ "%"))
						.addOrder(Property.forName("PayElementCode").asc())
						.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("payElementList", payElementList);
		map.put("payElementCode", payElementCode);
		map.put("payElementDescription", payElementDescription);
		return map;
	}

	public Map<String, Object> showReimbersementJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		reimbList = session.createCriteria(HrMasReimbersement.class).list();
		map.put("reimbList", reimbList);
		return map;
	}

	public Map<String, Object> saveReimbersement(
			HrMasReimbersement hrMasReimbersement) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<HrMasReimbersement> existingReimbList = new ArrayList<HrMasReimbersement>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String reimbCode = hrMasReimbersement.getReimbCode();
		String reimbDescription = hrMasReimbersement.getReimbDesc();
		existingReimbList = session.createCriteria(HrMasReimbersement.class)
				.add(Restrictions.eq("ReimbCode", reimbCode))
				.add(Restrictions.eq("ReimbDesc", reimbDescription)).list();
		if (existingReimbList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.save(hrMasReimbersement);
			message = "Record save successfully";
		}
		reimbList = session.createCriteria(HrMasReimbersement.class).list();
		map.put("reimbList", reimbList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> editReimbersement(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasReimbersement> existingReimbList = new ArrayList<HrMasReimbersement>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		Session session = (Session) getSession();
		int reimbId = 0;
		if (generalMap.get("reimbId") != null) {
			reimbId = (Integer) generalMap.get("reimbId");
		}
		String reimbCode = "";
		if (generalMap.get("reimbCode") != null) {
			reimbCode = (String) generalMap.get("reimbCode");
		}
		String reimbDescription = "";
		if (generalMap.get("reimbDescription") != null) {
			reimbDescription = (String) generalMap.get("reimbDescription");
		}
		BigDecimal maxAmount = null;
		if (generalMap.get("maxAmount") != null) {
			maxAmount = (BigDecimal) generalMap.get("maxAmount");
		}
		String taxable = "";
		if (generalMap.get("taxable") != null) {
			taxable = (String) generalMap.get("taxable");
		}
		BigDecimal maxTaxExemption = null;
		if (generalMap.get("maxTaxExemption") != null) {
			maxTaxExemption = (BigDecimal) generalMap.get("maxTaxExemption");
		}
		String carryForward = "";
		if (generalMap.get("carryForward") != null) {
			carryForward = (String) generalMap.get("carryForward");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = null;
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasReimbersement hrMasReimbersement = (HrMasReimbersement) hbt.load(
				HrMasReimbersement.class, reimbId);
		hrMasReimbersement.setReimbCode(reimbCode);
		hrMasReimbersement.setReimbDesc(reimbDescription);
		hrMasReimbersement.setMaxAmount(maxAmount);
		hrMasReimbersement.setTaxable(taxable);
		hrMasReimbersement.setMaxTaxExemption(maxTaxExemption);
		hrMasReimbersement.setCarryForward(carryForward);
		hrMasReimbersement.setLastChgBy(changedBy);
		hrMasReimbersement.setLastChgDate(currentDate);
		hrMasReimbersement.setLastChgTime(currentTime);

		// existingReimbList =
		// session.createCriteria(HrMasReimbersement.class).add(Restrictions.eq("ReimbCode",
		// reimbCode)).add(Restrictions.eq("ReimbDesc",
		// reimbDescription)).list();
		existingReimbList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrMasReimbersement as reimb where reimb.ReimbCode = '"
						+ reimbCode
						+ "' and reimb.ReimbDesc = '"
						+ reimbDescription
						+ "' and reimb.Id != '"
						+ reimbId
						+ "' ");
		String message = "";
		if (existingReimbList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.update(hrMasReimbersement);
			message = "Record update successfully";
		}
		reimbList = session.createCriteria(HrMasReimbersement.class).list();
		map.put("reimbList", reimbList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> deleteReimbersement(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int reimbId = 0;
		if (generalMap.get("reimbId") != null) {
			reimbId = (Integer) generalMap.get("reimbId");
		}
		String changedBy = "";
		if (generalMap.get("changedBy") != null) {
			changedBy = (String) generalMap.get("changedBy");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasReimbersement hrMasReimbersement = (HrMasReimbersement) hbt.load(
				HrMasReimbersement.class, reimbId);
		hrMasReimbersement.setLastChgBy(changedBy);
		hrMasReimbersement.setLastChgDate(currentDate);
		hrMasReimbersement.setLastChgTime(currentTime);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrMasReimbersement.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrMasReimbersement.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(hrMasReimbersement);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		reimbList = session.createCriteria(HrMasReimbersement.class).list();
		map.put("reimbList", reimbList);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> searchReimbersement(String reimbCode,
			String reimbDescription) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasReimbersement> reimbList = new ArrayList<HrMasReimbersement>();
		Session session = (Session) getSession();
		try {
			if ((reimbCode == null) || (reimbDescription != null)) {

				reimbList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasReimbersement reimb where reimb.ReimbDesc like '"
								+ reimbDescription
								+ "%' order by reimb.ReimbDesc");
			} else {
				reimbList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasReimbersement reimb where reimb.ReimbCode like '"
								+ reimbCode + "%' order by reimb.ReimbCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("reimbList", reimbList);
		map.put("reimbCode", reimbCode);
		map.put("reimbDescription", reimbDescription);
		return map;
	}

}
