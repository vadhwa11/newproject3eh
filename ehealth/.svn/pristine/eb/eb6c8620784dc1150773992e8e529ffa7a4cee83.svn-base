package jkt.hrms.setup.dataservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasHospital;
import jkt.hrms.masters.business.HrMasParameterMaintenance;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SetupDataServiceImpl extends HibernateDaoSupport implements
		SetupDataService {

	public Map<String, Object> showParameterMaintenanceJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<HrMasParameterMaintenance> masParameterMaintenanceList = new ArrayList<HrMasParameterMaintenance>();
		masParameterMaintenanceList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasParameterMaintenance ");
		masHospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasHospital as mh where mh.Id = '"
						+ hospitalId + "'");

		map.put("masParameterMaintenanceList", masParameterMaintenanceList);
		map.put("masHospitalList", masHospitalList);
		return map;
	}

	public Map<String, Object> saveParameterMaintenance(
			HrMasParameterMaintenance hrMasParameterMaintenance) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			if (hrMasParameterMaintenance != null) {

				hbt.save(hrMasParameterMaintenance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		successfullyAdded = true;
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	public Map<String, Object> upDateParameterMaintenance(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasParameterMaintenance> masParameterMaintenanceList = new ArrayList<HrMasParameterMaintenance>();
		int parameterMaintenanceId = 0;
		if (generalMap.get("parameterMaintenanceId") != null) {
			parameterMaintenanceId = (Integer) generalMap
					.get("parameterMaintenanceId");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasParameterMaintenance hrMasParameterMaintenance = (HrMasParameterMaintenance) hbt
				.load(HrMasParameterMaintenance.class, parameterMaintenanceId);

		float inspectionCharge = 0;
		if (generalMap.get("inspectionCharge") != null) {
			inspectionCharge = (Float) generalMap.get("inspectionCharge");
		}

		String da = "";
		if (generalMap.get("da") != null) {
			da = (String) generalMap.get("da");
		}
		BigDecimal epsMaxLimit = null;

		if (generalMap.get("epsMaxLimit") != null) {
			epsMaxLimit = (BigDecimal) generalMap.get("epsMaxLimit");
		}

		if (generalMap.get("edli") != null) {
			float edli = (Float) generalMap.get("edli");
			hrMasParameterMaintenance.setEdli(edli);
		}
		float adminCharge = 0;
		if (generalMap.get("adminCharge") != null) {
			adminCharge = (Float) generalMap.get("adminCharge");

		}
		String headOfficeCode = "";
		if (generalMap.get("headOfficeCode") != null) {
			headOfficeCode = (String) generalMap.get("headOfficeCode");

		}
		int inServiceCode = 0;
		if (generalMap.get("inServiceCode") != null) {
			inServiceCode = (Integer) generalMap.get("inServiceCode");

		}
		int leaveEncash = 0;
		if (generalMap.get("leaveEncash") != null) {
			leaveEncash = (Integer) generalMap.get("leaveEncash");
		}

		int payType = 0;
		if (generalMap.get("payType") != null) {
			payType = (Integer) generalMap.get("payType");

		}
		int noOfWorkingDays = 0;
		if (generalMap.get("noOfWorkingDays") != null) {
			noOfWorkingDays = (Integer) generalMap.get("noOfWorkingDays");
		}
		int retirementAge = 0;
		if (generalMap.get("retirementAge") != null) {
			retirementAge = (Integer) generalMap.get("retirementAge");
		}
		String volunatryContr = "";
		if (generalMap.get("volunatryContr") != null) {
			volunatryContr = (String) generalMap.get("volunatryContr");
		}

		String saturdayHoliday = "";
		if (generalMap.get("saturdayHoliday") != null) {
			saturdayHoliday = (String) generalMap.get("saturdayHoliday");
		}
		String sundayHoliday = "";
		if (generalMap.get("sundayHoliday") != null) {
			sundayHoliday = (String) generalMap.get("sundayHoliday");
		}
		float gratuity = 0;
		if (generalMap.get("gratuity") != null) {
			gratuity = (Float) generalMap.get("gratuity");
		}

		float superannuation = 0;
		if (generalMap.get("superannuation") != null) {
			superannuation = (Float) generalMap.get("superannuation");

		}
		int passwordExpiryDay = 0;
		if (generalMap.get("passwordExpiryDay") != null) {
			passwordExpiryDay = (Integer) generalMap.get("passwordExpiryDay");
		}

		float adminOnEdli = 0;
		if (generalMap.get("adminOnEdli") != null) {
			adminOnEdli = (Float) generalMap.get("adminOnEdli");
		}
		float pensionFund = 0;
		if (generalMap.get("pensionFund") != null) {
			pensionFund = (Float) generalMap.get("pensionFund");

		}
		String accountNoOfEpf = "";
		if (generalMap.get("accountNoOfEpf") != null) {
			accountNoOfEpf = (String) generalMap.get("accountNoOfEpf");
		}
		BigDecimal femaleTaxRebate = null;
		if (generalMap.get("femaleTaxRebate") != null) {
			femaleTaxRebate = (BigDecimal) generalMap.get("femaleTaxRebate");
		}
		String tanNo = "";
		if (generalMap.get("tanNo") != null) {
			tanNo = (String) generalMap.get("tanNo");
		}
		String panNo = "";
		if (generalMap.get("panNo") != null) {
			panNo = (String) generalMap.get("panNo");
		}
		float esiEmployeeCont = 0;
		if (generalMap.get("esiEmployeeCont") != null) {
			esiEmployeeCont = (Float) generalMap.get("esiEmployeeCont");
		}
		float esiEmployerCont = 0;
		if (generalMap.get("esiEmployerCont") != null) {
			esiEmployerCont = (Float) generalMap.get("esiEmployerCont");
		}
		String nightShiftStart = "";
		if (generalMap.get("nightShiftStart") != null) {
			nightShiftStart = (String) generalMap.get("nightShiftStart");
		}
		String nightShiftEnd = "";
		if (generalMap.get("nightShiftEnd") != null) {
			nightShiftEnd = (String) generalMap.get("nightShiftEnd");
		}
		float benefitPercentage = 0;
		if (generalMap.get("benefitPercentage") != null) {
			benefitPercentage = (Float) generalMap.get("benefitPercentage");
		}
		String finalYrLeaveCalc = "";
		if (generalMap.get("finalYrLeaveCalc") != null) {
			finalYrLeaveCalc = (String) generalMap.get("finalYrLeaveCalc");
		}
		String includeHolidaysInLeave = "";
		if (generalMap.get("includeHolidaysInLeave") != null) {
			includeHolidaysInLeave = (String) generalMap
					.get("includeHolidaysInLeave");
		}
		String unusdLeaveForCaryOrEncash = "";
		if (generalMap.get("unusdLeaveForCaryOrEncash") != null) {
			unusdLeaveForCaryOrEncash = (String) generalMap
					.get("unusdLeaveForCaryOrEncash");
		}
		String sickLeaveEligibility = "";
		if (generalMap.get("sickLeaveEligibility") != null) {
			sickLeaveEligibility = (String) generalMap
					.get("sickLeaveEligibility");
		}
		String vacationLeaveEligibility = "";
		if (generalMap.get("vacationLeaveEligibility") != null) {
			vacationLeaveEligibility = (String) generalMap
					.get("vacationLeaveEligibility");

		}
		hrMasParameterMaintenance.setInspectionCharge(inspectionCharge);
		hrMasParameterMaintenance.setEpsMaxLimit(epsMaxLimit);
		hrMasParameterMaintenance.setDa(da);
		hrMasParameterMaintenance.setAdminCharge(adminCharge);
		hrMasParameterMaintenance.setHeadOfficeCode(headOfficeCode);
		hrMasParameterMaintenance.setInServiceCode(inServiceCode);
		hrMasParameterMaintenance.setLeaveEncash(leaveEncash);
		hrMasParameterMaintenance.setPayType(payType);
		hrMasParameterMaintenance.setNoOfWorkingDays(noOfWorkingDays);
		hrMasParameterMaintenance.setRetirementAge(retirementAge);
		hrMasParameterMaintenance.setVolunatryContr(volunatryContr);
		hrMasParameterMaintenance.setHoliday1(saturdayHoliday);
		hrMasParameterMaintenance.setHoliday2(sundayHoliday);
		hrMasParameterMaintenance.setGratuity(gratuity);
		hrMasParameterMaintenance.setSuperannuation(superannuation);
		hrMasParameterMaintenance.setPasswordExpiryDay(passwordExpiryDay);
		hrMasParameterMaintenance.setAdminOnEdli(adminOnEdli);
		hrMasParameterMaintenance.setPensionFund(pensionFund);
		hrMasParameterMaintenance.setAccountNoOfEpf(accountNoOfEpf);
		hrMasParameterMaintenance.setFemaleTaxRebate(femaleTaxRebate);
		hrMasParameterMaintenance.setTanNo(tanNo);
		hrMasParameterMaintenance.setPanNo(panNo);
		hrMasParameterMaintenance.setEsiEmployeeCont(esiEmployeeCont);
		hrMasParameterMaintenance.setEsiEmployerCont(esiEmployerCont);
		hrMasParameterMaintenance.setNightShiftStart(nightShiftStart);
		hrMasParameterMaintenance.setNightShiftEnd(nightShiftEnd);
		hrMasParameterMaintenance.setBenefitPercentage(benefitPercentage);
		hrMasParameterMaintenance.setFinYrForLeaveCalc(finalYrLeaveCalc);
		hrMasParameterMaintenance
				.setIncludeHolidaysInLeave(includeHolidaysInLeave);
		hrMasParameterMaintenance
				.setUnusdLeaveCaryFwdOrEncash(unusdLeaveForCaryOrEncash);
		hrMasParameterMaintenance.setSickLeaveEligibilty(sickLeaveEligibility);
		hrMasParameterMaintenance
				.setVacationLeaveEligibilty(vacationLeaveEligibility);
		hbt.update(hrMasParameterMaintenance);
		boolean flag = false;
		flag = true;
		if (flag) {
			masParameterMaintenanceList = getHibernateTemplate()
					.find("from jkt.hrms.masters.business.HrMasParameterMaintenance ");
		}
		map.put("masParameterMaintenanceList", masParameterMaintenanceList);
		return map;
	}

}
