package jkt.hrms.payroll.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrAdvanceDetail;
import jkt.hrms.masters.business.HrArrear;
import jkt.hrms.masters.business.HrArrearSalary;
import jkt.hrms.masters.business.HrBonusDetail;
import jkt.hrms.masters.business.HrEmployeePayElements;
import jkt.hrms.masters.business.HrEmployeePayStructure;
import jkt.hrms.masters.business.HrLeaveDetails;
import jkt.hrms.masters.business.HrLoanDetail;
import jkt.hrms.masters.business.HrMasLocation;
import jkt.hrms.masters.business.HrPayrollProcessDetail;
import jkt.hrms.masters.business.HrPayrollProcessHeader;
import jkt.hrms.masters.handler.IncomeTaxMasHandlerService;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PayrollDataServiceImpl extends HibernateDaoSupport implements
		PayrollDataService {

	public IncomeTaxMasHandlerService incomeTaxMasHandlerService = null;

	/**
	 * @return the incomeTaxMasHandlerService
	 */
	public IncomeTaxMasHandlerService getIncomeTaxMasHandlerService() {
		return incomeTaxMasHandlerService;
	}

	/**
	 * @param incomeTaxMasHandlerService
	 *            the incomeTaxMasHandlerService to set
	 */
	public void setIncomeTaxMasHandlerService(
			IncomeTaxMasHandlerService incomeTaxMasHandlerService) {
		this.incomeTaxMasHandlerService = incomeTaxMasHandlerService;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPrePayrollProcessJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		// employeeList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasEmployee as emp where emp.EmpCategory.Id
		// = '1' and emp.EmployeeStatus = '1'");
		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as emp where emp.Status = 'y'");

		departmentList = session.createCriteria(MasDepartment.class).list();
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> processPrePayrollDetail(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrEmployeePayStructure> employeePaystructureList = new ArrayList<HrEmployeePayStructure>();
		List<Object[]> leaveDeatilList = new ArrayList<Object[]>();
		@SuppressWarnings("unused")
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> singleEmployeeList = new ArrayList<MasEmployee>();
		List<HrEmployeePayElements> employeePayElementList = new ArrayList<HrEmployeePayElements>();
		List<HrEmployeePayStructure> employeePayStructureList = new ArrayList<HrEmployeePayStructure>();
		List<Object[]> loanDetailList = new ArrayList<Object[]>();
		List<HrBonusDetail> bonusDetailList = new ArrayList<HrBonusDetail>();
		List<Object[]> advanceDetailList = new ArrayList<Object[]>();
		List<HrArrear> arrearPayElementList = new ArrayList<HrArrear>();
		List<HrArrearSalary> arrearSalaryList = new ArrayList<HrArrearSalary>();
		List<HrPayrollProcessHeader> existingPayrollHeader = new ArrayList<HrPayrollProcessHeader>();
		HrPayrollProcessHeader hrPayrollProcessHeader = new HrPayrollProcessHeader();

		if (generalMap.get("hrPayrollProcessHeader") != null) {
			hrPayrollProcessHeader = (HrPayrollProcessHeader) generalMap
					.get("hrPayrollProcessHeader");
		}
		int employeeId = hrPayrollProcessHeader.getEmployee().getId();
		int payrollMonth = hrPayrollProcessHeader.getMonth();
		int payrollYear = hrPayrollProcessHeader.getYear();
		int deapartmentId = 0;

		// int actualdays = 30;

		leaveDeatilList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails as ld join ld.leaveType as lt join lt.LeaveType as leaveType join leaveType.LeaveType as ml where ml.Id = 8 and ld.leaveStatus.Id = 2 and ld.EmpId.Id = "
						+ employeeId);
		singleEmployeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as emp where emp.Status='y' and emp.Id = '"
						+ employeeId + "'");
		employeePayElementList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrEmployeePayElements as element where element.Status='y' and element.Employee.Id = "
						+ employeeId);
		employeePaystructureList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrEmployeePayStructure as payStructure where payStructure.Employee.Id = "
						+ employeeId);
		loanDetailList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLoanDetail as ld join ld.LoanHeader as lh join lh.Employee as emp where emp.Id = "
						+ employeeId
						+ " and lh.LoanStatus = 'open' and lh.DeductFrom = 'salary' ");
		bonusDetailList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrBonusDetail as bd where bd.Employee.Id = "
						+ employeeId);
		advanceDetailList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrAdvanceDetail as ad join ad.Advance as ah join ah.Employee as emp where emp.Id = "
						+ employeeId + " and ah.RecoveryMode = 'Salary'");
		arrearPayElementList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrArrear as aa where aa.Employee.Id = '"
						+ employeeId + "'and aa.ArrearStatus = 'unpaid'");
		arrearSalaryList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrArrearSalary as salary where salary.Employee.Id = "
						+ employeeId);

		if (hrPayrollProcessHeader.getDepartment() != null) {
			deapartmentId = hrPayrollProcessHeader.getDepartment().getId();

		} else {
			MasEmployee employee = singleEmployeeList.get(0);
			deapartmentId = employee.getDepartment().getId();
		}

		String joinDate = null;
		if (singleEmployeeList.size() > 0) {
			MasEmployee masEmployee = singleEmployeeList.get(0);
			joinDate = HMSUtil.convertDateToStringWithoutTime(masEmployee
					.getJoinDate());
		}

		String splitDate[] = {};
		int jDate = 0;
		int jMonth = 0;
		int jYear = 0;
		if (joinDate != null) {
			splitDate = joinDate.split("/");
			joinDate = splitDate[0] + "" + splitDate[1] + "" + splitDate[2];
			jDate = Integer.parseInt(joinDate.substring(0, 2));
			jMonth = Integer.parseInt(joinDate.substring(2, 4));
			jYear = Integer.parseInt(joinDate.substring(4, 8));
		}
		// int noOfDaysInOffice = 0;
		// BigDecimal perDayBasicSalary = new BigDecimal("0");
		// BigDecimal employeeHra = new BigDecimal("0");
		// BigDecimal employeePf = new BigDecimal("0");
		// BigDecimal canteen = new BigDecimal("0");
		// BigDecimal conv = new BigDecimal("0");
		// BigDecimal additionPayElementAmount = new BigDecimal("0");
		// BigDecimal totalPayElementAmount = new BigDecimal("0");

		int noOfLeaveWithOutPay = 0;
		BigDecimal basicSalary = new BigDecimal("0");
		BigDecimal loanMonthlyInstallment = new BigDecimal("0");
		BigDecimal totalSalary = new BigDecimal("0");
		BigDecimal bonusAmount = new BigDecimal("0");
		BigDecimal advanceAmount = new BigDecimal("0");
		BigDecimal arrearPayElementAmount = new BigDecimal("0");
		Float arrearSalaryDays = 0.0f;

		// ------------------------------------------Employee Leave Without Pay
		// detail-----------------------------------
		if (leaveDeatilList.size() > 0) {
			for (Object[] obj : leaveDeatilList) {
				HrLeaveDetails hrLeaveDetails = (HrLeaveDetails) obj[0];

				String leaveFromDate = HMSUtil
						.convertDateToStringWithoutTime(hrLeaveDetails
								.getFromDate());
				String leaveTodate = HMSUtil
						.convertDateToStringWithoutTime(hrLeaveDetails
								.getToDate());

				String splitLeaveFromDate[] = leaveFromDate.split("/");
				leaveFromDate = splitLeaveFromDate[0] + ""
						+ splitLeaveFromDate[1] + "" + splitLeaveFromDate[2];
				int leaveFromMonth = Integer.parseInt(leaveFromDate.substring(
						2, 4));
				int leaveFromYear = Integer.parseInt(leaveFromDate.substring(4,
						8));

				String splitLeaveToDate[] = leaveTodate.split("/");
				leaveTodate = splitLeaveToDate[0] + "" + splitLeaveToDate[1]
						+ "" + splitLeaveToDate[2];
				int leaveToMonth = Integer
						.parseInt(leaveTodate.substring(2, 4));
				int leaveToYear = Integer.parseInt(leaveTodate.substring(4, 8));

				if ((leaveFromYear == payrollYear && leaveFromMonth <= payrollMonth)
						&& (leaveToYear == payrollYear && leaveToMonth >= payrollMonth)) {
					noOfLeaveWithOutPay = Integer.parseInt(hrLeaveDetails
							.getNoOfWorkingDays());

				} else if ((leaveFromYear < payrollYear)
						&& (leaveToYear == payrollYear && leaveToMonth >= payrollMonth)) {
					noOfLeaveWithOutPay = Integer.parseInt(hrLeaveDetails
							.getNoOfWorkingDays());

				} else if ((leaveToYear > payrollYear)
						&& (leaveFromYear == payrollYear && leaveFromMonth <= payrollMonth)) {
					noOfLeaveWithOutPay = Integer.parseInt(hrLeaveDetails
							.getNoOfWorkingDays());

				} else if ((leaveToYear > payrollYear)
						&& (leaveFromYear < payrollYear)) {
					noOfLeaveWithOutPay = Integer.parseInt(hrLeaveDetails
							.getNoOfWorkingDays());
				}
			}
		}
		// -------------------------------------------Employee Basic Salary
		// Detail --------------------------------------------
		if (employeePaystructureList.size() > 0) {
			for (HrEmployeePayStructure hrEmployeePayStructure : employeePaystructureList) {

				String paystructureFromDate = HMSUtil
						.convertDateToStringWithoutTime(hrEmployeePayStructure
								.getFromDate());
				String paystructureToDate = HMSUtil
						.convertDateToStringWithoutTime(hrEmployeePayStructure
								.getToDate());

				String splitPayStructureFromDate[] = paystructureFromDate
						.split("/");
				paystructureFromDate = splitPayStructureFromDate[0] + ""
						+ splitPayStructureFromDate[1] + ""
						+ splitPayStructureFromDate[2];
				int payStructureFromMonth = Integer
						.parseInt(paystructureFromDate.substring(2, 4));
				int payStructureFromYear = Integer
						.parseInt(paystructureFromDate.substring(4, 8));

				String splitPayStructureToDate[] = paystructureToDate
						.split("/");
				paystructureToDate = splitPayStructureToDate[0] + ""
						+ splitPayStructureToDate[1] + ""
						+ splitPayStructureToDate[2];
				int payStructureToMonth = Integer.parseInt(paystructureToDate
						.substring(2, 4));
				int payStructureToYear = Integer.parseInt(paystructureToDate
						.substring(4, 8));

				if ((payStructureFromYear == payrollYear && payStructureFromMonth <= payrollMonth)
						&& (payStructureToYear == payrollYear && payStructureToMonth >= payrollMonth)) {
					if (hrEmployeePayStructure.getBasicPay() != null) {
						basicSalary = hrEmployeePayStructure.getBasicPay();
					}
				} else if ((payStructureFromYear < payrollYear)
						&& (payStructureToYear == payrollYear && payStructureToMonth >= payrollMonth)) {
					if (hrEmployeePayStructure.getBasicPay() != null) {
						basicSalary = hrEmployeePayStructure.getBasicPay();
					}
				} else if ((payStructureToYear > payrollYear)
						&& (payStructureFromYear == payrollYear && payStructureFromMonth <= payrollMonth)) {
					if (hrEmployeePayStructure.getBasicPay() != null) {
						basicSalary = hrEmployeePayStructure.getBasicPay();
					}
				} else if ((payStructureToYear > payrollYear)
						&& (payStructureFromYear < payrollYear)) {
					if (hrEmployeePayStructure.getBasicPay() != null) {
						basicSalary = hrEmployeePayStructure.getBasicPay();
					}
				}
			}
		}
		// --------------------------------Employee PayElement
		// details---------------------------------------------------
		BigDecimal payElementAmt = new BigDecimal("0");
		BigDecimal totalAdditionPayElement = new BigDecimal("0");
		BigDecimal totalDeductionPayElement = new BigDecimal("0");
		BigDecimal totalReimbPayElement = new BigDecimal("0");
		BigDecimal totalPayElement = new BigDecimal("0");
		if (employeePayElementList.size() > 0) {
			for (HrEmployeePayElements hrEmployeePayElements : employeePayElementList) {
				if (hrEmployeePayElements.getPayAmount() != null
						&& !(hrEmployeePayElements.getPayAmount().compareTo(
								new BigDecimal(0)) == 0)) {
					payElementAmt = hrEmployeePayElements.getPayAmount();

					if (hrEmployeePayElements.getPayElementType() != null) {
						if (hrEmployeePayElements.getPayElementType().equals(
								"Addition")) {
							totalAdditionPayElement = totalAdditionPayElement
									.add(payElementAmt);
						}

						// if(hrEmployeePayElements.getPayElementType()!= null
						// ){
						if (hrEmployeePayElements.getPayElementType().equals(
								"Reimb")) {
							totalReimbPayElement = totalReimbPayElement
									.add(payElementAmt);
						}
						// }
						// if(hrEmployeePayElements.getPayElementType()!= null){
						if (hrEmployeePayElements.getPayElementType().equals(
								"Deduction")) {
							totalDeductionPayElement = totalDeductionPayElement
									.add(payElementAmt);
						}
						// }
					}
				}
				totalPayElement = totalAdditionPayElement.add(
						totalReimbPayElement)
						.subtract(totalDeductionPayElement);

			}

		}
		BigDecimal totalPayElementAmtAndBasicSalary = totalPayElement
				.add(basicSalary);

		// ---------------------------------------Employee Loan
		// Detail------------------------------------------
		if (loanDetailList.size() > 0) {
			for (Object[] obj : loanDetailList) {
				HrLoanDetail hrLoanDetail = (HrLoanDetail) obj[0];
				// HrLoanHeader hrLoanHeader = (HrLoanHeader)obj[1];
				String loanInstallmentDate = HMSUtil
						.convertDateToStringWithoutTime(hrLoanDetail
								.getInstallDate());

				String splitLoanInstallmentDate[] = loanInstallmentDate
						.split("/");
				loanInstallmentDate = splitLoanInstallmentDate[0] + ""
						+ splitLoanInstallmentDate[1] + ""
						+ splitLoanInstallmentDate[2];
				int interstMonth = Integer.parseInt(loanInstallmentDate
						.substring(2, 4));
				int interstYear = Integer.parseInt(loanInstallmentDate
						.substring(4, 8));
				if (interstMonth == payrollMonth && interstYear == payrollYear) {
					loanMonthlyInstallment = hrLoanDetail.getInstallAmount();
				}
			}
		}
		// ------------------------------------Employee Bonus
		// Detail----------------------------------------------------
		if (bonusDetailList.size() > 0) {
			HrBonusDetail hrBonusDetail = bonusDetailList.get(0);
			String bonusPaidDate = HMSUtil
					.convertDateToStringWithoutTime(hrBonusDetail.getPaidDate());
			String splitbonusPaidDate[] = bonusPaidDate.split("/");
			bonusPaidDate = splitbonusPaidDate[0] + "" + splitbonusPaidDate[1]
					+ "" + splitbonusPaidDate[2];
			int bonusPaidMonth = Integer
					.parseInt(bonusPaidDate.substring(2, 4));
			int bonusPaidYear = Integer.parseInt(bonusPaidDate.substring(4, 8));
			if (bonusPaidMonth == payrollMonth && bonusPaidYear == payrollYear) {
				bonusAmount = hrBonusDetail.getBonusAmount();
			}
		}
		// -------------------------------------Employee Advance
		// Details------------------------------------------------------
		if (advanceDetailList.size() > 0) {
			for (Object[] obj : advanceDetailList) {
				HrAdvanceDetail hrAdvanceDetail = (HrAdvanceDetail) obj[0];
				// HrAdvance hrAdvance = (HrAdvance)obj[1];
				String advanceRecoveryDate = HMSUtil
						.convertDateToStringWithoutTime(hrAdvanceDetail
								.getRecoveryDate());
				String splitadvanceRecoveryDate[] = advanceRecoveryDate
						.split("/");
				advanceRecoveryDate = splitadvanceRecoveryDate[0] + ""
						+ splitadvanceRecoveryDate[1] + ""
						+ splitadvanceRecoveryDate[2];
				int advancePaidMonth = Integer.parseInt(advanceRecoveryDate
						.substring(2, 4));
				int advancePaidYear = Integer.parseInt(advanceRecoveryDate
						.substring(4, 8));
				if (advancePaidMonth == payrollMonth
						&& advancePaidYear == payrollYear) {
					advanceAmount = hrAdvanceDetail.getRecoveredAmount();
				}
			}
		}
		// --------------------------------------Employee Arrear PayElement
		// Detail ---------------------------------------------
		if (arrearPayElementList.size() > 0) {
			HrArrear hrArrear = arrearPayElementList.get(0);
			String arrearPayElementPaidDate = HMSUtil
					.convertDateToStringWithoutTime(hrArrear.getPaidDate());
			String splitarrearPayElementPaidDate[] = arrearPayElementPaidDate
					.split("/");
			arrearPayElementPaidDate = splitarrearPayElementPaidDate[0] + ""
					+ splitarrearPayElementPaidDate[1] + ""
					+ splitarrearPayElementPaidDate[2];
			int arrearPayElementPaidMonth = Integer
					.parseInt(arrearPayElementPaidDate.substring(2, 4));
			int arrearPayElementPaidYear = Integer
					.parseInt(arrearPayElementPaidDate.substring(4, 8));
			if (arrearPayElementPaidMonth == payrollMonth
					&& arrearPayElementPaidYear == payrollYear) {
				arrearPayElementAmount = hrArrear.getArrearAmount();
			}

		}
		// ---------------------------------------Employee Arrear Salary
		// Detail---------------------------------------
		if (arrearSalaryList.size() > 0) {
			HrArrearSalary hrArrearSalary = arrearSalaryList.get(0);
			String arrearsalaryPaymentdate = HMSUtil
					.convertDateToStringWithoutTime(hrArrearSalary
							.getPaymentDate());
			String splitarrearsalaryPaymentdate[] = arrearsalaryPaymentdate
					.split("/");
			arrearsalaryPaymentdate = splitarrearsalaryPaymentdate[0] + ""
					+ splitarrearsalaryPaymentdate[1] + ""
					+ splitarrearsalaryPaymentdate[2];
			int arrearsalaryPaymentMonth = Integer
					.parseInt(arrearsalaryPaymentdate.substring(2, 4));
			int arrearsalaryPaymentYear = Integer
					.parseInt(arrearsalaryPaymentdate.substring(4, 8));
			if (arrearsalaryPaymentMonth == payrollMonth
					&& arrearsalaryPaymentYear == payrollYear) {
				arrearSalaryDays = hrArrearSalary.getArrearDays();
			}
		}
		BigDecimal totalArrearSalaryAmount = new BigDecimal(
				totalPayElementAmtAndBasicSalary.intValue()
						* (arrearSalaryDays) / (30));
		BigDecimal arrearBasic = new BigDecimal(basicSalary.intValue()
				* (arrearSalaryDays) / (30));
		// =============================================Total Earnings And
		// Deduction And Reimb=============================//

		BigDecimal totalEarning = (basicSalary.add(totalAdditionPayElement)
				.add(bonusAmount).add(arrearPayElementAmount)
				.add(totalArrearSalaryAmount));
		BigDecimal totaldeduction = totalDeductionPayElement.subtract(
				loanMonthlyInstallment).add(advanceAmount);
		BigDecimal totaReimb = totalReimbPayElement;
		// BigDecimal totalDeduction = new BigDecimal(to);
		BigDecimal netSalary = new BigDecimal("0");
		int salaryDays = 0;
		int totalDays = 0;
		int totalMonthDays = 0;
		BigDecimal totalDaysSalary = new BigDecimal("0");
		if (jMonth == payrollMonth && jYear == payrollYear) {
			if (payrollMonth == 1 || payrollMonth == 3 || payrollMonth == 5
					|| payrollMonth == 7 || payrollMonth == 8
					|| payrollMonth == 10 || payrollMonth == 12) {
				totalMonthDays = 31;
				// BigDecimal perDaySalary =new
				// BigDecimal(totalPayElementAmtAndBasicSalary.intValue()/totalMonthDays);
				totalDays = 31 - jDate;
				salaryDays = totalDays - noOfLeaveWithOutPay;
				totalDaysSalary = new BigDecimal(
						totalPayElementAmtAndBasicSalary.intValue()
								* (salaryDays) / totalMonthDays);
				totalSalary = totalDaysSalary.subtract(loanMonthlyInstallment)
						.add(bonusAmount).subtract(advanceAmount)
						.add(arrearPayElementAmount)
						.add(totalArrearSalaryAmount);
				netSalary = totalSalary;
			} else if (payrollMonth == 2 || payrollMonth == 4
					|| payrollMonth == 6 || payrollMonth == 9
					|| payrollMonth == 11) {
				totalMonthDays = 30;
				// BigDecimal perDaySalary =new
				// BigDecimal(totalPayElementAmtAndBasicSalary.intValue()/totalMonthDays);
				totalDays = 30 - jDate;
				salaryDays = totalDays - noOfLeaveWithOutPay;
				totalDaysSalary = new BigDecimal(
						totalPayElementAmtAndBasicSalary.intValue()
								* (salaryDays) / totalMonthDays);
				totalSalary = totalDaysSalary.subtract(loanMonthlyInstallment)
						.add(bonusAmount).subtract(advanceAmount)
						.add(arrearPayElementAmount)
						.add(totalArrearSalaryAmount);
				netSalary = totalSalary;
			}

		} else if (noOfLeaveWithOutPay == 0) {

			if (payrollMonth == 1 || payrollMonth == 3 || payrollMonth == 5
					|| payrollMonth == 7 || payrollMonth == 8
					|| payrollMonth == 10 || payrollMonth == 12) {
				totalMonthDays = 31;
				totalDays = 31;
				salaryDays = totalDays;
				totalSalary = totalPayElementAmtAndBasicSalary
						.subtract(loanMonthlyInstallment).add(bonusAmount)
						.subtract(advanceAmount).add(arrearPayElementAmount)
						.add(totalArrearSalaryAmount);
				netSalary = totalSalary;
			} else if (payrollMonth == 2 || payrollMonth == 4
					|| payrollMonth == 6 || payrollMonth == 9
					|| payrollMonth == 11) {
				totalMonthDays = 30;
				totalDays = 30;
				salaryDays = totalDays;
				totalSalary = totalPayElementAmtAndBasicSalary
						.subtract(loanMonthlyInstallment).add(bonusAmount)
						.subtract(advanceAmount).add(arrearPayElementAmount)
						.add(totalArrearSalaryAmount);
				netSalary = totalSalary;
			}
		} else {
			if (payrollMonth == 1 || payrollMonth == 3 || payrollMonth == 5
					|| payrollMonth == 7 || payrollMonth == 8
					|| payrollMonth == 10 || payrollMonth == 12) {
				totalMonthDays = 31;
				BigDecimal perDaySalary = new BigDecimal(
						totalPayElementAmtAndBasicSalary.intValue()
								/ totalMonthDays);
				totalDays = 31;
				salaryDays = totalDays - noOfLeaveWithOutPay;
				totalDaysSalary = new BigDecimal(perDaySalary.intValue()
						* (salaryDays));
				totalSalary = totalDaysSalary.subtract(loanMonthlyInstallment)
						.add(bonusAmount).subtract(advanceAmount)
						.add(arrearPayElementAmount)
						.add(totalArrearSalaryAmount);
				netSalary = totalSalary;
			} else if (payrollMonth == 2 || payrollMonth == 4
					|| payrollMonth == 6 || payrollMonth == 9
					|| payrollMonth == 11) {
				totalMonthDays = 30;
				BigDecimal perDaySalary = new BigDecimal(
						totalPayElementAmtAndBasicSalary.intValue()
								/ totalMonthDays);
				totalDays = 30;
				salaryDays = totalDays - noOfLeaveWithOutPay;
				totalDaysSalary = new BigDecimal(perDaySalary.intValue()
						* (salaryDays));
				totalSalary = totalDaysSalary.subtract(loanMonthlyInstallment)
						.add(bonusAmount).subtract(advanceAmount)
						.add(arrearPayElementAmount)
						.add(totalArrearSalaryAmount);
				netSalary = totalSalary;
			}
		}
		String message = "";
		if (netSalary.intValue() < 0) {
			message = "<span><i>Salary Processed in minus</i><span>";
		} else {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrPayrollProcessHeader.setEmployee(masEmployee);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deapartmentId);
			hrPayrollProcessHeader.setDepartment(masDepartment);

			hrPayrollProcessHeader.setYear(payrollYear);
			hrPayrollProcessHeader.setMonth(payrollMonth);
			hrPayrollProcessHeader.setTotalDays(totalDays);
			hrPayrollProcessHeader.setLwpDays(noOfLeaveWithOutPay);
			hrPayrollProcessHeader.setSalDays(salaryDays);
			hrPayrollProcessHeader.setLoanInstallment(loanMonthlyInstallment);
			hrPayrollProcessHeader.setAdvanceInstallment(advanceAmount);
			hrPayrollProcessHeader.setBonusAmount(bonusAmount);
			hrPayrollProcessHeader.setBasic(basicSalary);
			hrPayrollProcessHeader
					.setArrearPayelementAmt(arrearPayElementAmount);
			hrPayrollProcessHeader.setArrearDays(arrearSalaryDays);
			hrPayrollProcessHeader.setArrearSalaryAmt(totalArrearSalaryAmount);
			hrPayrollProcessHeader.setTotalMonthDays(totalMonthDays);
			hrPayrollProcessHeader.setFlag("P");
			hrPayrollProcessHeader.setNetSalary(netSalary);
			hrPayrollProcessHeader.setTotalEarning(totalEarning);
			hrPayrollProcessHeader.setTotalDeduction(totaldeduction);
			hrPayrollProcessHeader.setTotalReimb(totaReimb);

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			existingPayrollHeader = getHibernateTemplate()
					.find("from jkt.hrms.masters.business.HrPayrollProcessHeader as pph where pph.Employee.Id = '"
							+ employeeId
							+ "' and pph.Year = '"
							+ payrollYear
							+ "' and pph.Month = '" + payrollMonth + "'");

			if (existingPayrollHeader.size() > 0) {
				HrPayrollProcessHeader hrPayrollProcessHeader2 = existingPayrollHeader
						.get(0);
				message = "&nbsp;<span><i>Salary already processed for "
						+ hrPayrollProcessHeader2.getEmployee().getFirstName()
						+ " "
						+ hrPayrollProcessHeader2.getEmployee().getLastName()
						+ "</i></span>,";
				map.put("unprocessed", hrPayrollProcessHeader2);
			} else {

				Date currentDate = new Date();
				// Integer year = currentDate.getYear()+1900;
				// Integer month = currentDate.getMonth();
				Map parameterMap = new HashMap<String, Object>();
				// parameterMap.put("empListForITComputation",
				// empListForITComputation);
				parameterMap.put("year", hrPayrollProcessHeader.getYear());
				parameterMap.put("month", hrPayrollProcessHeader.getMonth());
				parameterMap.put("currentDate", currentDate);

				// Map returnMap =
				// incomeTaxMasHandlerService.computeIncomeTax(hrPayrollProcessHeader.getEmployee(),parameterMap);
				HrPayrollProcessHeader emplHrPayrollProcessHeader = hrPayrollProcessHeader;
				Set<HrPayrollProcessDetail> sethrPayProDet = new HashSet<HrPayrollProcessDetail>();
				for (HrEmployeePayElements payElements : employeePayElementList) {
					HrPayrollProcessDetail payrollProcessDetail = new HrPayrollProcessDetail();
					payrollProcessDetail.setElementType(payElements
							.getPayElementType());
					if (payElements.getPayAmount() != null) {
						payrollProcessDetail.setPayelementAmount(payElements
								.getPayAmount());
					}
					// hrPayrollProcessHeader.setId(hrPayrollProcessHeader.getId());
					payrollProcessDetail
							.setPayrollProcessHeader(hrPayrollProcessHeader);
					HrEmployeePayElements employeePayElements = new HrEmployeePayElements();
					employeePayElements.setId(payElements.getId());
					payrollProcessDetail.setEmpPayElement(payElements);
					sethrPayProDet.add(payrollProcessDetail);
				}
				emplHrPayrollProcessHeader
						.setHrPayrollProcessDetails(sethrPayProDet);
				/*
				 * returnMap.put("employeePayrollProcessHeader",
				 * emplHrPayrollProcessHeader); returnMap.put("arrearBasic",
				 * arrearBasic);returnMap.put("incomeTaxMasHandlerService",
				 * incomeTaxMasHandlerService); returnMap.put("empId",
				 * employeeId); IncomeTaxUtil.initialize(returnMap);
				 * IncomeTaxUtil
				 * .populateItaxDetails(hrPayrollProcessHeader.getEmployee());
				 * try { BigDecimal itaxCalculate =
				 * IncomeTaxUtil.computeIncomeTax(); } catch (Exception e) { //
				 * TODO Auto-generated catch block e.printStackTrace(); }
				 */

				hbt.save(hrPayrollProcessHeader);
				hbt.refresh(hrPayrollProcessHeader);
				for (HrEmployeePayElements payElements : employeePayElementList) {
					HrPayrollProcessDetail payrollProcessDetail = new HrPayrollProcessDetail();
					payrollProcessDetail.setElementType(payElements
							.getPayElementType());
					if (payElements.getPayAmount() != null) {
						payrollProcessDetail.setPayelementAmount(payElements
								.getPayAmount());
					}
					// hrPayrollProcessHeader.setId(hrPayrollProcessHeader.getId());
					payrollProcessDetail
							.setPayrollProcessHeader(hrPayrollProcessHeader);
					HrEmployeePayElements employeePayElements = new HrEmployeePayElements();
					employeePayElements.setId(payElements.getId());
					payrollProcessDetail.setEmpPayElement(employeePayElements);

					hbt.save(payrollProcessDetail);
					hbt.refresh(payrollProcessDetail);
				}

				MasEmployee emp = hrPayrollProcessHeader.getEmployee();
				message = "&nbsp;<i>" + emp.getFirstName() + " "
						+ emp.getLastName() + "-" + emp.getEmployeeCode()
						+ "</i>,";
				map.put("processed", hrPayrollProcessHeader);
			}
		}
		Map tempMap = showPrePayrollProcessJsp();
		map.putAll(tempMap);
		map.put("message", message);
		return map;
	}

	public Map<String, Object> showSearchPrePayrollProcessJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		// employeeList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasEmployee as emp where emp.EmpCategory.Id
		// = '1' and emp.EmployeeStatus = '1'");
		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as emp where emp.Status = 'y'");
		departmentList = session.createCriteria(MasDepartment.class).list();
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPrePayrollDetail(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrEmployeePayStructure> employeePayStructureList = new ArrayList<HrEmployeePayStructure>();
		List<HrPayrollProcessHeader> prePayrollProcessList = new ArrayList<HrPayrollProcessHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		int employeeId = 0;
		if (generalMap.get("employeeId") != null) {
			employeeId = (Integer) generalMap.get("employeeId");
		}
		int departmentId = 0;
		if (generalMap.get("departmentId") != null) {
			departmentId = (Integer) generalMap.get("departmentId");
		}
		int month = 0;
		if (generalMap.get("month") != null) {
			month = (Integer) generalMap.get("month");
		}
		int year = 0;
		if (generalMap.get("year") != null) {
			year = (Integer) generalMap.get("year");
		}
		Criteria crit = null;
		crit = session.createCriteria(HrPayrollProcessHeader.class).add(
				Restrictions.eq("Year", year));
		if (employeeId != 0) {
			crit = crit.createAlias("Employee", "emp").add(
					Restrictions.eq("emp.Id", employeeId));
		}
		if (departmentId != 0) {
			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId));
		}
		if (month != 0) {
			crit = crit.add(Restrictions.eq("Month", month));
		}
		prePayrollProcessList = crit.list();

		// prePayrollProcessList =
		// session.createCriteria(HrPayrollProcessHeader.class).add(Restrictions.eq("Month",
		// month)).add(Restrictions.eq("Year", year)).createAlias("Employee",
		// "emp").add(Restrictions.eq("emp.Id",
		// employeeId)).createAlias("Department",
		// "dept").add(Restrictions.eq("dept.Id", departmentId)).list();
		// prePayrollProcessList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.HrPayrollProcessHeader as pph where
		// pph.Employee.Id = '"+employeeId+"' and pph.Department.Id =
		// '"+departmentId+"' and pph.Month = '"+month+"' and pph.Year =
		// '"+year+"'");
		employeePayStructureList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeePayStructure");
		// employeeList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasEmployee as emp where emp.EmpCategory.Id
		// = '1' and emp.EmployeeStatus = '1'");
		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as emp where emp.Status = 'y'");
		departmentList = session.createCriteria(MasDepartment.class).list();
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("prePayrollProcessList", prePayrollProcessList);
		map.put("employeePayStructureList", employeePayStructureList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editPrePayrollDetail(int prePayrollProcessId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrPayrollProcessHeader> singlePrePayrollProcessList = new ArrayList<HrPayrollProcessHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HrPayrollProcessHeader> prePayrollProcessList = new ArrayList<HrPayrollProcessHeader>();
		List<HrEmployeePayElements> payElementsList = new ArrayList<HrEmployeePayElements>();
		Session session = (Session) getSession();
		singlePrePayrollProcessList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrPayrollProcessHeader as pph where pph.Id = '"
						+ prePayrollProcessId + "' ");
		HrPayrollProcessHeader emplPayrollProcessHeader = singlePrePayrollProcessList
				.get(0);
		// employeeList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasEmployee as emp where emp.EmpCategory.Id
		// = '1' and emp.EmployeeStatus = '1'");
		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as emp where emp.Status = '1y'");
		departmentList = session.createCriteria(MasDepartment.class).list();
		prePayrollProcessList = session.createCriteria(
				HrPayrollProcessHeader.class).list();

		payElementsList = session
				.createCriteria(HrEmployeePayElements.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Employee.Id", emplPayrollProcessHeader
						.getEmployee().getId())).list();
		map.put("singlePrePayrollProcessList", singlePrePayrollProcessList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("prePayrollProcessList", prePayrollProcessList);
		map.put("payElementsList", payElementsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateProcessPrePayrollDetail(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrEmployeePayStructure> employeePayStructureList = new ArrayList<HrEmployeePayStructure>();
		List<HrPayrollProcessHeader> prePayrollProcessList = new ArrayList<HrPayrollProcessHeader>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		String message = "";
		List payElementIdList = new ArrayList();
		List payElementCodeList = new ArrayList();
		List payElementAmountList = new ArrayList();
		List payElementTypeList = new ArrayList();
		boolean updated = false;
		if (generalMap.get("payElementIdList") != null) {
			payElementIdList = (List) generalMap.get("payElementIdList");
		}
		if (generalMap.get("payElementCodeList") != null) {
			payElementCodeList = (List) generalMap.get("payElementCodeList");
		}
		if (generalMap.get("payElementAmountList") != null) {
			payElementAmountList = (List) generalMap
					.get("payElementAmountList");
		}
		if (generalMap.get("payElementTypeList") != null) {
			payElementTypeList = (List) generalMap.get("payElementTypeList");
		}
		int prePayrollProcessId = 0;
		if (generalMap.get("prePayrollProcessId") != null) {
			prePayrollProcessId = (Integer) generalMap
					.get("prePayrollProcessId");
		}
		int employeeId = 0;
		if (generalMap.get("employeeId") != null) {
			employeeId = (Integer) generalMap.get("employeeId");
		}
		int departmentId = 0;
		if (generalMap.get("departmentId") != null) {
			departmentId = (Integer) generalMap.get("departmentId");
		}
		int month = 0;
		if (generalMap.get("month") != null) {
			month = (Integer) generalMap.get("month");
		}
		int year = 0;
		if (generalMap.get("year") != null) {
			year = (Integer) generalMap.get("year");
		}
		int lwp = 0;
		if (generalMap.get("lwp") != null) {
			lwp = (Integer) generalMap.get("lwp");
		}
		int totalDays = 0;
		if (generalMap.get("totalDays") != null) {
			totalDays = (Integer) generalMap.get("totalDays");
		}
		int salaryDays = 0;
		if (generalMap.get("salaryDays") != null) {
			salaryDays = (Integer) generalMap.get("salaryDays");
		}
		BigDecimal loanMonthlyInstallment = new BigDecimal("0");
		if (generalMap.get("loanMonthlyInstallment") != null) {
			loanMonthlyInstallment = (BigDecimal) generalMap
					.get("loanMonthlyInstallment");
		}
		BigDecimal advanceAmount = new BigDecimal("0");
		if (generalMap.get("advanceAmount") != null) {
			advanceAmount = (BigDecimal) generalMap.get("advanceAmount");
		}
		BigDecimal bonusAmount = new BigDecimal("0");
		if (generalMap.get("bonusAmount") != null) {
			bonusAmount = (BigDecimal) generalMap.get("bonusAmount");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrPayrollProcessHeader hrPayrollProcessHeader = (HrPayrollProcessHeader) hbt
				.load(HrPayrollProcessHeader.class, prePayrollProcessId);
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrPayrollProcessHeader.setEmployee(masEmployee);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		hrPayrollProcessHeader.setDepartment(masDepartment);
		hrPayrollProcessHeader.setYear(year);
		hrPayrollProcessHeader.setMonth(month);
		hrPayrollProcessHeader.setLwpDays(lwp);
		hrPayrollProcessHeader.setTotalDays(totalDays);
		hrPayrollProcessHeader.setSalDays(salaryDays);
		hrPayrollProcessHeader.setLoanInstallment(loanMonthlyInstallment);
		hrPayrollProcessHeader.setAdvanceInstallment(advanceAmount);
		hrPayrollProcessHeader.setBonusAmount(bonusAmount);

		HrPayrollProcessDetail hrPayrollProcessDetail = new HrPayrollProcessDetail();
		if (payElementIdList.size() > 0) {
			for (int i = 0; i < payElementIdList.size(); i++) {
				if (payElementIdList.get(i) != null) {
					int prePayrollProcessdetailId = Integer
							.parseInt(payElementIdList.get(i).toString());
					hrPayrollProcessDetail = (HrPayrollProcessDetail) hbt.load(
							HrPayrollProcessDetail.class,
							prePayrollProcessdetailId);
					if (payElementAmountList.get(i) != null) {
						BigDecimal payElementAmount = new BigDecimal(
								payElementAmountList.get(i).toString());
						hrPayrollProcessDetail
								.setPayelementAmount(payElementAmount);

					}
					if (payElementIdList.get(i) != null) {
						String elementType = (String) payElementTypeList.get(i);
						hrPayrollProcessDetail.setElementType(elementType);
					}

					hbt.update(hrPayrollProcessDetail);
					hbt.flush();
					hbt.refresh(hrPayrollProcessDetail);

				}
			}
		}
		hbt.refresh(hrPayrollProcessHeader);
		Date currentDate = new Date();
		// Integer year = currentDate.getYear()+1900;
		// Integer month = currentDate.getMonth();
		Map parameterMap = new HashMap<String, Object>();
		// parameterMap.put("empListForITComputation", empListForITComputation);
		parameterMap.put("year", hrPayrollProcessHeader.getYear());
		parameterMap.put("month", hrPayrollProcessHeader.getMonth());
		parameterMap.put("currentDate", currentDate);

		// Map returnMap =
		// incomeTaxMasHandlerService.computeIncomeTax(hrPayrollProcessHeader.getEmployee(),parameterMap);
		// HrPayrollProcessHeader emplHrPayrollProcessHeader =
		// hrPayrollProcessHeader;
		// Set<HrPayrollProcessDetail> sethrPayProDet =
		// emplHrPayrollProcessHeader.getHrPayrollProcessDetails();

		// emplHrPayrollProcessHeader.setHrPayrollProcessDetails(sethrPayProDet);
		/*
		 * returnMap.put("employeePayrollProcessHeader",
		 * hrPayrollProcessHeader); //returnMap.put("arrearBasic", arrearBasic);
		 * returnMap
		 * .put("incomeTaxMasHandlerService",incomeTaxMasHandlerService);
		 * returnMap.put("empId", employeeId);
		 * IncomeTaxUtil.initialize(returnMap);
		 * IncomeTaxUtil.populateItaxDetails
		 * (hrPayrollProcessHeader.getEmployee()); try { BigDecimal
		 * itaxCalculate = IncomeTaxUtil.computeIncomeTax(); } catch (Exception
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * if(hrPayrollProcessHeader.getFlag().equals("C")){ message = "Data
		 * can't updated Salary Fixed ."; }else
		 * if(hrPayrollProcessHeader.getFlag().equals("P")){
		 * hbt.update(hrPayrollProcessDetail); message = "Data update
		 * Successfully."; }
		 */

		updated = true;

		if (updated) {
			message = "Data update Successfully.";
		} else {
			message = "Some Problem Occured.";
		}
		// prePayrollProcessList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.HrPayrollProcessHeader as pph where
		// pph.Employee.Id = '"+employeeId+"' and pph.Department.Id =
		// '"+departmentId+"' and pph.Month = '"+month+"' and pph.Year =
		// '"+year+"'");
		prePayrollProcessList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrPayrollProcessHeader");
		employeePayStructureList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeePayStructure");
		// employeeList = getHibernateTemplate().find("from
		// jkt.hms.masters.business.MasEmployee as emp where emp.EmpCategory.Id
		// = '1' and emp.EmployeeStatus = '1'");
		employeeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as emp where emp.Status = 'y'");
		departmentList = session.createCriteria(MasDepartment.class).list();
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("prePayrollProcessList", prePayrollProcessList);
		map.put("employeePayStructureList", employeePayStructureList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPostPayrollProcessJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		departmentList = session.createCriteria(MasDepartment.class).list();
		map.put("departmentList", departmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> processPostPayrollDetail(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrPayrollProcessHeader> postProcessHeaderList = new ArrayList<HrPayrollProcessHeader>();
		Session session = (Session) getSession();
		boolean updated = false;
		int departmentId = 0;
		if (generalMap.get("departmentId") != null) {
			departmentId = (Integer) generalMap.get("departmentId");
		}
		int month = 0;
		if (generalMap.get("month") != null) {
			month = (Integer) generalMap.get("month");
		}
		int year = 0;
		if (generalMap.get("year") != null) {
			year = (Integer) generalMap.get("year");
		}
		Criteria crit = null;
		crit = session.createCriteria(HrPayrollProcessHeader.class)
				.add(Restrictions.eq("Year", year))
				.add(Restrictions.eq("Month", month));

		if (departmentId != 0) {
			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId));
		}

		postProcessHeaderList = crit.list();
		int payrollHeaderId = 0;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		// postProcessHeaderList =
		// session.createCriteria(HrPayrollProcessHeader.class).add(Restrictions.eq("Month",
		// month)).add(Restrictions.eq("Year", year)).createAlias("Department",
		// "dept").add(Restrictions.eq("dept.Id", departmentId)).list();
		for (HrPayrollProcessHeader payrollProcessHeader : postProcessHeaderList) {
			payrollHeaderId = payrollProcessHeader.getId();
			HrPayrollProcessHeader payrollProcessHeader1 = (HrPayrollProcessHeader) hbt
					.load(HrPayrollProcessHeader.class, payrollHeaderId);

			if (payrollProcessHeader.getFlag().equals("P")) {
				payrollProcessHeader.setFlag("C");
				hbt.update(payrollProcessHeader1);
			}
		}

		updated = true;
		String message = "";
		if (updated) {
			message = "Salary Fixed Successfully.";
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIncrementMonthStatementJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class).list();
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showStaffPersonnelDetailsJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class).list();
		empStatusList = session.createCriteria(MasEmpStatus.class).list();
		map.put("employeeList", employeeList);
		map.put("empStatusList", empStatusList);
		return map;
	}

	public Map<String, Object> showServiceStatementJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class).list();
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showPaySlipJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<HrMasLocation> locationList = new ArrayList<HrMasLocation>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class).list();
		locationList = session.createCriteria(HrMasLocation.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("locationList", locationList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showEarningAndDeductionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasEmpCategory> empCategorylist = new ArrayList<MasEmpCategory>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		empCategorylist = session.createCriteria(MasEmpCategory.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("empCategorylist", empCategorylist);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showMonthlyBankAdviceReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class).list();
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showIndividualPayJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showSalaryRegisterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		return map;
	}

	public List<MasEmployee> getAllEmployeeList() {
		Criteria criteria = getSession().createCriteria(MasEmployee.class);
		criteria = criteria.add(Restrictions.eq("Status", "y"));
		List employeeList = criteria.list();
		return employeeList;
	}

	public MasDepartment getDepartment(Integer departmentId) {
		MasDepartment department = (MasDepartment) getHibernateTemplate().load(
				MasDepartment.class, departmentId);
		return department;

	}

}
